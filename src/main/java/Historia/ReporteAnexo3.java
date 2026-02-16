package Historia;

import Facturacion.Templates_1;
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
import net.sf.dynamicreports.report.builder.column.ColumnBuilder;
import net.sf.dynamicreports.report.builder.component.ComponentBuilder;
import net.sf.dynamicreports.report.builder.component.FillerBuilder;
import net.sf.dynamicreports.report.builder.component.HorizontalListBuilder;
import net.sf.dynamicreports.report.builder.component.TextFieldBuilder;
import net.sf.dynamicreports.report.builder.style.StyleBuilder;
import net.sf.dynamicreports.report.constant.ComponentPositionType;
import net.sf.dynamicreports.report.constant.HorizontalAlignment;
import net.sf.dynamicreports.report.constant.PageOrientation;
import net.sf.dynamicreports.report.constant.PageType;
import net.sf.dynamicreports.report.constant.VerticalAlignment;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.report.exception.DRException;
import net.sf.jasperreports.engine.JRDataSource;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: loaded from: GenomaP.jar:Historia/ReporteAnexo3.class */
public class ReporteAnexo3 {
    private static final int cellWidth = 10;
    private static final int cellHeight = 10;
    private StyleBuilder textStyle;
    private StyleBuilder textStyleFont7;
    private StyleBuilder centeredStyle;
    private StyleBuilder labelStyle;
    private StyleBuilder labelStyleFontSmall;
    private StyleBuilder cellStyle;
    private StyleBuilder cellStyleGray;
    private StyleBuilder rootStyle;
    private StyleBuilder boldStyle;
    private StyleBuilder fount_roja;
    private StyleBuilder boldCenteredStyle;
    private StyleBuilder bold10CenteredStyle;
    static ResultSetMetaData rsmetadatos;
    private StyleBuilder bold14Style;
    private StyleBuilder styleCamposLabel;
    private StyleBuilder styleCamposLabelCenter;
    private ResultSet rsper;
    private String xidAtencion;
    private String xid_orden;
    private String sql;
    private int xForma;
    private int xFiltroProf;
    private Metodos xmt = new Metodos();
    private ConsultasMySQL xct = new ConsultasMySQL();
    private String xpersona = "";
    private ResultSet xrsOrdenEncabezado = null;
    private ResultSet xrsRemision = null;
    private Connection connection = this.xct.establecerConexionBd();

    public ReporteAnexo3(String xidAtencion, String xid_orden, int xForma, int xFiltroProf) {
        this.xidAtencion = "";
        this.xid_orden = "";
        this.xForma = 0;
        this.xFiltroProf = 1;
        this.xidAtencion = xidAtencion;
        this.xid_orden = xid_orden;
        this.xForma = xForma;
        this.xFiltroProf = xFiltroProf;
    }

    public JasperReportBuilder build() {
        this.xmt.mEliminarArchivo(new File(this.xmt.getRutaRep() + "H_Anexo3_Orden.pdf"));
        JasperPdfExporterBuilder pdfExporter = DynamicReports.export.pdfExporter(this.xmt.getRutaRep() + "H_Anexo3_Orden.pdf");
        JasperReportBuilder report = DynamicReports.report();
        new Templates_1();
        try {
            Statement persona = this.connection.createStatement();
            Statement empresa = this.connection.createStatement();
            Statement remision = this.connection.createStatement();
            Statement remision_esp = this.connection.createStatement();
            this.rootStyle = DynamicReports.stl.style().setPadding(2);
            this.boldStyle = DynamicReports.stl.style(this.rootStyle).bold();
            this.boldCenteredStyle = DynamicReports.stl.style(this.boldStyle).setAlignment(HorizontalAlignment.CENTER, VerticalAlignment.TOP);
            this.fount_roja = DynamicReports.stl.style(this.boldStyle).setAlignment(HorizontalAlignment.CENTER, VerticalAlignment.TOP).setFontSize(7).setForegroundColor(Color.RED);
            this.bold10CenteredStyle = DynamicReports.stl.style(this.boldCenteredStyle).setFontSize(8);
            this.textStyle = DynamicReports.stl.style().setFontSize(8).setPadding(2);
            this.textStyleFont7 = DynamicReports.stl.style().setFontSize(7).setPadding(2);
            this.centeredStyle = DynamicReports.stl.style(this.textStyle).setAlignment(HorizontalAlignment.CENTER, VerticalAlignment.MIDDLE);
            this.labelStyle = DynamicReports.stl.style(this.textStyle).setHorizontalAlignment(HorizontalAlignment.LEFT).bold();
            this.labelStyleFontSmall = DynamicReports.stl.style(this.textStyle).setHorizontalAlignment(HorizontalAlignment.LEFT).setFontSize(5);
            this.cellStyle = DynamicReports.stl.style(this.textStyle).setBorder(DynamicReports.stl.pen1Point()).setAlignment(HorizontalAlignment.CENTER, VerticalAlignment.MIDDLE);
            this.cellStyleGray = DynamicReports.stl.style(this.textStyle).setBorder(DynamicReports.stl.pen1Point()).setAlignment(HorizontalAlignment.CENTER, VerticalAlignment.MIDDLE).setBackgroundColor(new Color(153, 153, 153));
            DynamicReports.stl.style(this.bold14Style).setFontSize(10).bold().setHorizontalAlignment(HorizontalAlignment.CENTER).setBackgroundColor(new Color(204, 255, 204)).setBorder(DynamicReports.stl.pen1Point());
            DynamicReports.stl.style(this.bold14Style).setFontSize(10).bold().setHorizontalAlignment(HorizontalAlignment.CENTER).setBorder(DynamicReports.stl.pen1Point());
            StyleBuilder styleCuadroBlanco2 = DynamicReports.stl.style(this.bold14Style).setFontSize(8).setHorizontalAlignment(HorizontalAlignment.LEFT).setBorder(DynamicReports.stl.pen1Point());
            this.styleCamposLabel = DynamicReports.stl.style(this.bold14Style).setFontSize(10).bold().setHorizontalAlignment(HorizontalAlignment.LEFT).setBorder(DynamicReports.stl.pen1Point());
            this.styleCamposLabelCenter = DynamicReports.stl.style(this.bold14Style).setFontSize(10).bold().setHorizontalAlignment(HorizontalAlignment.CENTER).setBorder(DynamicReports.stl.pen1Point());
            ResultSet xrs = empresa.executeQuery("SELECT `g_ips`.`Nbre` AS NEmpresa , `g_ips`.`Id_TipoIdentificacion` , CONCAT(`g_ips`.`Identificacion`,'-',`g_ips`.`DigitoVerificacion`) AS Identificacion     , `g_ips`.`CodigoOrganismo` , `g_ips`.`Direccion` , `g_ips`.`Telefono`  , `g_municipio`.`Nbre` AS Mpio ,SUBSTRING(`g_municipio`.`Id`,3,5) AS IdMpio, UPPER(`g_departamento`.`Nbre`) AS Dpto, `g_departamento`.`Id` AS IdDpto FROM `g_ips` INNER JOIN  `g_municipio`  ON (`g_ips`.`Id_Municipio` = `g_municipio`.`Id`)     INNER JOIN  `g_departamento`  ON (`g_municipio`.`Id_Dpto` = `g_departamento`.`Id`)");
            xrs.first();
            this.sql = "SELECT `g_persona`.`Apellido1` , `g_persona`.`Apellido2` ,`g_persona`.`Nombre1` ,  `g_persona`.`Nombre2` , `g_persona`.`Id_TipoIdentificacion`\n    , `g_persona`.`NoDocumento` , `g_persona`.`Direccion` , `g_persona`.`Telefono` ,  DATE_FORMAT(`g_persona`.`FechaNac`,'%Y-%m-%d') AS FechaNac , `g_municipio`.`Nbre` AS Mpio,SUBSTRING(`g_municipio`.`Id`,3,5) AS IdMpio, UPPER(`g_departamento`.`Nbre`) AS Dpto,`g_departamento`.`Id` AS IdDpto \n    , cc_terceros.RazonSocialCompleta AS NEmpresa , `g_empresacont`.`Codigo`, ingreso.NPersonaResp, ingreso.TipDoc, ingreso.NoDocumento AS NoDocumentoResp, ingreso.TelefonoPResp, `g_tipoatencion`.`Nbre` AS TipoAtencion, g_persona.Movil, g_persona.Correo, f_tiporegimen.Nbre AS Regimen,g_causaexterna.`Nbre` AS CausaExterna,      h_atencion.`Codigo_Dxp`, h_atencion.`Codigo_DxR1`,h_atencion.`Codigo_DxR2`,IF(`g_patologia`.`Nbre` IS NULL,'',`g_patologia`.`Nbre`) AS P1 , IF(`g_patologia_1`.`Nbre` IS NULL,'',`g_patologia_1`.`Nbre`) AS P2, IF(`g_patologia_2`.`Nbre` IS NULL,'',`g_patologia_2`.`Nbre`) AS P3, `profesional1`.`NProfesional`  , `profesional1`.`Especialidad` , `profesional1`.`Telefono` , `profesional1`.`Movil`, `profesional1`.DireccionF  FROM `ingreso`\n    INNER JOIN  `g_persona`  ON (`ingreso`.`Id_Usuario` = `g_persona`.`Id`)\n    INNER JOIN  `g_municipio`   ON (`g_persona`.`Id_Municipio` = `g_municipio`.`Id`)\n    INNER JOIN  `g_departamento`  ON (`g_municipio`.`Id_Dpto` = `g_departamento`.`Id`)\n    INNER JOIN  `f_empresacontxconvenio`  ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)\n    INNER JOIN  `g_empresacont`   ON (`f_empresacontxconvenio`.`Id_EmpresaCont` = `g_empresacont`.`Id_empresa`)\n    INNER JOIN  cc_terceros   ON (`g_empresacont`.`Id_empresa` = cc_terceros.`Id`)     INNER JOIN   f_tiporegimen ON (`f_empresacontxconvenio`.`Id_TipoRegimen` = `f_tiporegimen`.`Id`)    INNER JOIN   `g_causaexterna` ON (ingreso.`Id_CausaExterna`=g_causaexterna.`Id`)     INNER JOIN  `g_tipoatencion`  ON (`ingreso`.`Id_TipoAtencion` = `g_tipoatencion`.`Id`)     INNER JOIN `h_atencion`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`) LEFT JOIN `g_patologia`  ON (`h_atencion`.`Codigo_Dxp` = `g_patologia`.`Id`)  LEFT JOIN `g_patologia` AS `g_patologia_1` ON (`h_atencion`.`Codigo_DxR1` = `g_patologia_1`.`Id`)  LEFT JOIN `g_patologia` AS `g_patologia_2` ON (`h_atencion`.`Codigo_DxR2` = `g_patologia_2`.`Id`)INNER JOIN `profesional1`  ON (`h_atencion`.`Id_Profesional` = `profesional1`.`Id_Persona`) AND (`h_atencion`.`Id_Especialidad` = `profesional1`.`IdEspecialidad`)  WHERE (`h_atencion`.`Id` ='" + this.xidAtencion + "')";
            ResultSet xrsper = persona.executeQuery(this.sql);
            xrsper.first();
            String xsql = null;
            if (this.xForma == 0) {
                if (this.xFiltroProf == 0) {
                    xsql = "SELECT  `h_ordenes`.`Id` AS IdOrden  , `h_ordenes`.`FechaOrden` , DATE_FORMAT(`h_ordenes`.`Fecha`,'%H:%i') AS Hora\n    ,  IF( `g_procedimiento`.`C_Homologado` ='', `h_itemordenesproced`.`Id_Procedimiento`,`g_procedimiento`.`C_Homologado`) AS Id_Procedimiento , `h_itemordenesproced`.`Cantidad` , `g_procedimiento`.`Nbre` AS NProcedimiento,IF(`h_ordenes`.`NotaHc`='',h_atencion.Conclusion, `h_ordenes`.`NotaHc` ) as NotaHc, `profesional1`.`NProfesional`  , `profesional1`.`Especialidad` , `profesional1`.`Telefono` , `profesional1`.`Movil`, `profesional1`.DireccionF, Concat('R.M: ', `profesional1`.Tarjeta) AS Tarjeta \nFROM `h_itemordenesproced`  INNER JOIN  `h_ordenes`   ON (`h_itemordenesproced`.`Id_HOrdenes` = `h_ordenes`.`Id`)\n    INNER JOIN  `g_procedimiento`   ON (`h_itemordenesproced`.`Id_Procedimiento` = `g_procedimiento`.`Id`) INNER JOIN  `h_atencion`   ON (`h_ordenes`.`Id_Atencion` = `h_atencion`.`Id`) \n INNER JOIN `profesional1` ON (`h_ordenes`.`Id_Profesional` = `profesional1`.`Id_Persona`) AND (`h_ordenes`.`Id_Especialidad` = `profesional1`.`IdEspecialidad`)  WHERE (`h_ordenes`.`Id` in(" + this.xid_orden + ")) ORDER BY `g_procedimiento`.`Nbre` ASC";
                    this.xrsOrdenEncabezado = remision.executeQuery(xsql);
                } else {
                    xsql = "SELECT  `h_ordenes`.`Id` AS IdOrden  , `h_ordenes`.`FechaOrden` , DATE_FORMAT(`h_ordenes`.`Fecha`,'%H:%i') AS Hora\n    ,  IF( `g_procedimiento`.`C_Homologado` ='', `h_itemordenesproced`.`Id_Procedimiento`,`g_procedimiento`.`C_Homologado`) AS Id_Procedimiento , `h_itemordenesproced`.`Cantidad` , `g_procedimiento`.`Nbre` AS NProcedimiento,IF(`h_ordenes`.`NotaHc`='',h_atencion.Conclusion, `h_ordenes`.`NotaHc` ) as NotaHc, `profesional1`.`NProfesional`  , `profesional1`.`Especialidad` , `profesional1`.`Telefono` , `profesional1`.`Movil`, `profesional1`.DireccionF, Concat('R.M: ', `profesional1`.Tarjeta) AS Tarjeta \nFROM `h_itemordenesproced`  INNER JOIN  `h_ordenes`   ON (`h_itemordenesproced`.`Id_HOrdenes` = `h_ordenes`.`Id`)\n    INNER JOIN  `g_procedimiento`   ON (`h_itemordenesproced`.`Id_Procedimiento` = `g_procedimiento`.`Id`) INNER JOIN  `h_atencion`   ON (`h_ordenes`.`Id_Atencion` = `h_atencion`.`Id`) \n INNER JOIN `profesional1` ON (`h_ordenes`.`Id_Profesional` = `profesional1`.`Id_Persona`) AND (`h_ordenes`.`Id_Especialidad` = `profesional1`.`IdEspecialidad`)  WHERE ( `h_ordenes`.`Id` in(" + this.xid_orden + ") ) ORDER BY `g_procedimiento`.`Nbre` ASC";
                    this.xrsOrdenEncabezado = remision.executeQuery(xsql);
                }
            } else if (this.xFiltroProf == 0) {
                this.xrsOrdenEncabezado = remision.executeQuery("SELECT  `h_ordenes`.`Id` AS IdOrden  , `h_ordenes`.`FechaOrden` , DATE_FORMAT(`h_ordenes`.`Fecha`,'%H:%i') AS Hora\n    ,  IF( `g_procedimiento`.`C_Homologado` ='', `h_itemordenesproced`.`Id_Procedimiento`,`g_procedimiento`.`C_Homologado`) AS Id_Procedimiento , `h_itemordenesproced`.`Cantidad` , `g_procedimiento`.`Nbre` AS NProcedimiento, IF(`h_ordenes`.`NotaHc`='',h_atencion.Conclusion, `h_ordenes`.`NotaHc` ) as NotaHc, `profesional1`.`NProfesional`  , `profesional1`.`Especialidad` , `profesional1`.`Telefono` , `profesional1`.`Movil`, `profesional1`.DireccionF, Concat('R.M: ', `profesional1`.Tarjeta) AS Tarjeta \nFROM `h_itemordenesproced`  INNER JOIN  `h_ordenes`   ON (`h_itemordenesproced`.`Id_HOrdenes` = `h_ordenes`.`Id`)\n    INNER JOIN  `g_procedimiento`   ON (`h_itemordenesproced`.`Id_Procedimiento` = `g_procedimiento`.`Id`) INNER JOIN  `h_atencion`   ON (`h_ordenes`.`Id_Atencion` = `h_atencion`.`Id`) \n INNER JOIN `profesional1` ON (`h_ordenes`.`Id_Profesional` = `profesional1`.`Id_Persona`) AND (`h_ordenes`.`Id_Especialidad` = `profesional1`.`IdEspecialidad`)  WHERE (`h_ordenes`.`Id_Atencion` ='" + this.xidAtencion + "' ) ORDER BY `h_ordenes`.Id_TipoServicio asc, `g_procedimiento`.`Nbre` ASC");
            } else {
                this.xrsOrdenEncabezado = remision.executeQuery("SELECT  `h_ordenes`.`Id` AS IdOrden  , `h_ordenes`.`FechaOrden` , DATE_FORMAT(`h_ordenes`.`Fecha`,'%H:%i') AS Hora\n    ,  IF( `g_procedimiento`.`C_Homologado` ='', `h_itemordenesproced`.`Id_Procedimiento`,`g_procedimiento`.`C_Homologado`) AS Id_Procedimiento , `h_itemordenesproced`.`Cantidad` , `g_procedimiento`.`Nbre` AS NProcedimiento, IF(`h_ordenes`.`NotaHc`='',h_atencion.Conclusion, `h_ordenes`.`NotaHc` ) as NotaHc, `profesional1`.`NProfesional`  , `profesional1`.`Especialidad` , `profesional1`.`Telefono` , `profesional1`.`Movil`, `profesional1`.DireccionF, Concat('R.M: ', `profesional1`.Tarjeta) AS Tarjeta \nFROM `h_itemordenesproced`  INNER JOIN  `h_ordenes`   ON (`h_itemordenesproced`.`Id_HOrdenes` = `h_ordenes`.`Id`)\n    INNER JOIN  `g_procedimiento`   ON (`h_itemordenesproced`.`Id_Procedimiento` = `g_procedimiento`.`Id`) INNER JOIN  `h_atencion`   ON (`h_ordenes`.`Id_Atencion` = `h_atencion`.`Id`) \n INNER JOIN `profesional1` ON (`h_ordenes`.`Id_Profesional` = `profesional1`.`Id_Persona`) AND (`h_ordenes`.`Id_Especialidad` = `profesional1`.`IdEspecialidad`)  WHERE ( `h_ordenes`.`Id_Atencion` ='" + this.xidAtencion + "' ) ORDER BY `h_ordenes`.Id_TipoServicio asc, `g_procedimiento`.`Nbre` ASC");
            }
            System.out.println(xsql);
            this.xrsOrdenEncabezado.first();
            this.xrsRemision = remision_esp.executeQuery("SELECT `g_especialidad`.`Cups` , CONCAT(`g_procedimiento`.`Nbre` ,' (',`g_especialidad`.`Nbre`,')') AS Procedimiento\n FROM  `h_remisiones` INNER JOIN `g_especialidad`   ON (`h_remisiones`.`I_Especialidad` = `g_especialidad`.`Id`) INNER JOIN `g_procedimiento`   ON (`g_especialidad`.`Cups` = `g_procedimiento`.`Id`)\n WHERE (`h_remisiones`.`Id_Atencion`=" + this.xidAtencion + " AND  h_remisiones.`Estado`=0)");
            report.setPageFormat(PageType.LEGAL, PageOrientation.PORTRAIT).setTextStyle(this.textStyle).title(new ComponentBuilder[]{DynamicReports.cmp.image(this.xmt.getRutaRep() + "Anexo3.png").setFixedDimension(592, 60)}).pageHeader(new ComponentBuilder[]{DynamicReports.cmp.horizontalList().add(new ComponentBuilder[]{emptyCell(13), label("NUMERO DE SOLICITUD", 10), textCell(this.xrsOrdenEncabezado.getString("IdOrden"), 10)}).add(new ComponentBuilder[]{emptyCell(1), label("Fecha:", 3), textCell(this.xrsOrdenEncabezado.getString("FechaOrden"), 10)}).add(new ComponentBuilder[]{emptyCell(2), label("Hora:", 4), textCell(this.xrsOrdenEncabezado.getString("Hora"), 5)}).newRow().add(new ComponentBuilder[]{label("INFORMACIÓN DEL PRESTADOR (solicitante)", 30)}).newRow(0).add(new ComponentBuilder[]{labelP("Nombre  " + xrs.getString("NEmpresa"), 37)}).add(new ComponentBuilder[]{emptyCell(1), TipoDocumento(xrs.getString("Id_TipoIdentificacion")), emptyCell(1)}).add(new ComponentBuilder[]{emptyCell(1), textCell(xrs.getString("Identificacion"), 11)}).newRow(0).add(new ComponentBuilder[]{labelP("", 37), emptyCell(11), labelP("Número                    DV", 11)}).newRow(0).add(new ComponentBuilder[]{labelP("Código", 7), textCell(xrs.getString("CodigoOrganismo"), 12)}).add(new ComponentBuilder[]{labelP("Dirección prestador  " + xrs.getString("Direccion"), 40)}).newRow().add(new ComponentBuilder[]{labelP("Teléfono", 7), textCell(xrs.getString("Telefono"), 12)}).add(new ComponentBuilder[]{labelP(" Departamento " + xrs.getString("Dpto"), 17), textCellGray(xrs.getString("IdDpto"), 2)}).add(new ComponentBuilder[]{labelP(" Municipio " + xrs.getString("Mpio"), 18), textCellGray(xrs.getString("IdMpio"), 3)}).newRow().add(new ComponentBuilder[]{labelP("ENTIDAD A LA QUE SE LE SOLICITA (PAGADOR) " + xrsper.getString("NEmpresa"), 49), labelP("Codigo", 4), textCell(xrsper.getString("Codigo"), 6)}).newRow(), DynamicReports.cmp.verticalGap(0), DynamicReports.cmp.horizontalList().add(new ComponentBuilder[]{labelPCenter("DATOS DEL PACIENTE ", 59)}).newRow(0).add(new ComponentBuilder[]{labelP(xrsper.getString("Apellido1"), 15), labelP(xrsper.getString("Apellido2"), 15), labelP(xrsper.getString("Nombre1"), 15), labelP(xrsper.getString("Nombre2"), 14)}).newFlowRow(2).add(new ComponentBuilder[]{label("1er Apellido", 15).setStyle(this.bold10CenteredStyle), label("2do Apellido", 15).setStyle(this.bold10CenteredStyle), label("1er Nombre", 15).setStyle(this.bold10CenteredStyle), label("2do Nombre", 14).setStyle(this.bold10CenteredStyle)}).newFlowRow(2).add(new ComponentBuilder[]{TipoDocumentoPac(xrsper.getString("Id_TipoIdentificacion"), xrsper.getString("NoDocumento"), xrsper.getString("FechaNac")), emptyCell(1)}).newRow(0).add(new ComponentBuilder[]{labelP(" Dirección de Residencia Habitual:     " + xrsper.getString("Direccion"), 44)}).add(new ComponentBuilder[]{labelP(" Teléfono", 5), textCell(xrsper.getString("Telefono"), 10)}).newRow().add(new ComponentBuilder[]{labelP(" Departamento  " + xrsper.getString("Dpto"), 25), textCellGray(xrsper.getString("IdDpto"), 2)}).add(new ComponentBuilder[]{labelP(" Municipio  " + xrsper.getString("Mpio"), 29), textCellGray(xrsper.getString("IdMpio"), 3)}).newRow().add(new ComponentBuilder[]{labelP(" Teléfono Celular", 10), textCell(xrsper.getString("Movil"), 11)}).add(new ComponentBuilder[]{labelP("Correo electrónico  " + xrsper.getString("Correo"), 38)}).newRow(0).add(new ComponentBuilder[]{CoberturaSalud(xrsper.getString("Regimen"))}).newRow(0), DynamicReports.cmp.verticalGap(0), DynamicReports.cmp.horizontalList().add(new ComponentBuilder[]{labelPCenter("INFORMACION DE LA ATENCION Y SERVICIOS SOLICITADOS", 59)}).newRow(0).add(new ComponentBuilder[]{OrigenAtencion(xrsper.getString("CausaExterna"))}).newRow(0).add(new ComponentBuilder[]{label("Ubicación del Paciente al momento de la solicitud de autorizacion:", 40)}).newRow(0).add(new ComponentBuilder[]{TipoAtencion(xrsper.getString("TipoAtencion"))}).newRow(0).add(new ComponentBuilder[]{DynamicReports.cmp.line()}).newRow(0).add(new ComponentBuilder[]{label("Manejo integral según guía de: ________________________________________________________________________________________________________", 59)}).newRow(1), DynamicReports.cmp.verticalGap(2)}).columns(new ColumnBuilder[]{DynamicReports.col.column("", "posicion", DynamicReports.type.integerType()).setWidth(5), DynamicReports.col.column("Código CUPS", "codigo", DynamicReports.type.stringType()).setWidth(10), DynamicReports.col.column("Cantidad", "cantidad", DynamicReports.type.integerType()).setWidth(10), DynamicReports.col.column("Descripción", "descripcion", DynamicReports.type.stringType()).setWidth(100)}).summary(new ComponentBuilder[]{DynamicReports.cmp.horizontalList().add(new ComponentBuilder[]{DynamicReports.cmp.text("Justificación Clínica:\n " + this.xrsOrdenEncabezado.getString("NotaHc")).setStyle(styleCuadroBlanco2)}).newRow(3).add(new ComponentBuilder[]{label("Impresión Diagnóstica:", 10), emptyCell(3), label("Codigo CIE10", 7), emptyCell(1), label("Descripción", 8)}).newRow().add(new ComponentBuilder[]{label("Diagnóstico principal", 11), emptyCell(3), textCell(xrsper.getString("Codigo_Dxp"), 4), emptyCell(3), label(xrsper.getString("P1"), 38, this.labelStyleFontSmall)}).newRow().add(new ComponentBuilder[]{label("Diagnóstico relacionado 1", 11), emptyCell(3), textCell(xrsper.getString("Codigo_DxR1"), 4), emptyCell(3), label(xrsper.getString("P2"), 38, this.labelStyleFontSmall)}).newRow().add(new ComponentBuilder[]{label("Diagnóstico relacionado 2", 11), emptyCell(3), textCell(xrsper.getString("Codigo_DxR2"), 4), emptyCell(3), label(xrsper.getString("P3"), 38, this.labelStyleFontSmall)}).newRow().add(new ComponentBuilder[]{DynamicReports.cmp.line()}).newRow().add(new ComponentBuilder[]{labelPCenter("INFORMACION DE LA PERSONA QUE SOLICITA", 59)}).newRow(0).add(new ComponentBuilder[]{labelP("Nombre de que solicita:  " + this.xrsOrdenEncabezado.getString("NProfesional"), 36), label("Teléfono ", 5), textCell(this.xrsOrdenEncabezado.getString("Telefono"), 18)}).newRow().add(new ComponentBuilder[]{Firma(this.xrsOrdenEncabezado.getString("DireccionF")), emptyCell(5), label("     Indicativo            Número          Extensión", 17)}).newRow().add(new ComponentBuilder[]{label(this.xrsOrdenEncabezado.getString("Tarjeta"), 10)}).newRow().add(new ComponentBuilder[]{labelP("Cargo o actividad:  " + this.xrsOrdenEncabezado.getString("Especialidad"), 36), label("Teléfono celular: ", 7), emptyCell(6), textCell(this.xrsOrdenEncabezado.getString("Movil"), 10)})}).setDataSource(createDataSource());
            try {
                report.toPdf(pdfExporter);
            } catch (DRException e) {
                Logger.getLogger(ReporteAnexo3.class.getName()).log(Level.SEVERE, (String) null, e);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReporteAnexo3.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return report;
    }

    private JRDataSource createDataSource() throws SQLException {
        DRDataSource dataSource = new DRDataSource(new String[]{"posicion", "codigo", "cantidad", "descripcion"});
        this.xrsOrdenEncabezado.beforeFirst();
        int n = 1;
        if (this.xrsOrdenEncabezado.next()) {
            this.xrsOrdenEncabezado.beforeFirst();
            while (this.xrsOrdenEncabezado.next()) {
                dataSource.add(new Object[]{Integer.valueOf(n), this.xrsOrdenEncabezado.getString("Id_Procedimiento"), Integer.valueOf(this.xrsOrdenEncabezado.getInt("Cantidad")), this.xrsOrdenEncabezado.getString("NProcedimiento")});
                n++;
            }
        }
        if (this.xrsRemision.next()) {
            this.xrsRemision.beforeFirst();
            while (this.xrsRemision.next()) {
                dataSource.add(new Object[]{Integer.valueOf(n), this.xrsRemision.getString("Cups"), 1, this.xrsRemision.getString("Procedimiento")});
                n++;
            }
        }
        return dataSource;
    }

    private HorizontalListBuilder Firma(String firma) {
        HorizontalListBuilder list;
        String RutaFirma = this.xmt.mRutaSoporte("SUBREPORTFIRMA_DIR");
        if (!RutaFirma.isEmpty()) {
            list = DynamicReports.cmp.horizontalList().add(new ComponentBuilder[]{DynamicReports.cmp.image(RutaFirma + firma).setPositionType(ComponentPositionType.FLOAT).setMinDimension(100, 80)});
        } else {
            list = DynamicReports.cmp.horizontalList().add(new ComponentBuilder[]{DynamicReports.cmp.image(this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra() + firma).setPositionType(ComponentPositionType.FLOAT).setMinDimension(100, 80)});
        }
        return list;
    }

    private HorizontalListBuilder TipoDocumento(String xtipoDoc) {
        HorizontalListBuilder horizontalListBuilderAdd = DynamicReports.cmp.horizontalList().add(new ComponentBuilder[]{emptyCell(2)});
        ComponentBuilder[] componentBuilderArr = new ComponentBuilder[2];
        componentBuilderArr[0] = textCell(xtipoDoc.equals("NI") ? "X" : "", 1);
        componentBuilderArr[1] = label("NIT", 2, this.textStyle);
        HorizontalListBuilder horizontalListBuilderAdd2 = horizontalListBuilderAdd.add(componentBuilderArr);
        ComponentBuilder[] componentBuilderArr2 = new ComponentBuilder[2];
        componentBuilderArr2[0] = textCell(xtipoDoc.equals("CC") ? "X" : "", 1);
        componentBuilderArr2[1] = label("CC", 2, this.textStyle);
        HorizontalListBuilder list = horizontalListBuilderAdd2.add(componentBuilderArr2);
        return list;
    }

    private HorizontalListBuilder TipoDocumentoPac(String xtipoDoc, String NoDoc, String xFechaNac) {
        HorizontalListBuilder horizontalListBuilderNewRow = DynamicReports.cmp.horizontalList().add(new ComponentBuilder[]{label("Tipo de Documento de identificación", 15)}).newRow(0);
        ComponentBuilder[] componentBuilderArr = new ComponentBuilder[2];
        componentBuilderArr[0] = textCell(xtipoDoc.equals("RC") ? "X" : "", 1);
        componentBuilderArr[1] = label("Registro civil", 10, this.textStyle);
        HorizontalListBuilder horizontalListBuilderAdd = horizontalListBuilderNewRow.add(componentBuilderArr);
        ComponentBuilder[] componentBuilderArr2 = new ComponentBuilder[3];
        componentBuilderArr2[0] = textCell(xtipoDoc.equals("PA") ? "X" : "", 1);
        componentBuilderArr2[1] = label("Pasaporte", 10, this.textStyle);
        componentBuilderArr2[2] = emptyCell(15);
        HorizontalListBuilder horizontalListBuilderNewRow2 = horizontalListBuilderAdd.add(componentBuilderArr2).add(new ComponentBuilder[]{textCell(NoDoc, 16)}).newRow(0);
        ComponentBuilder[] componentBuilderArr3 = new ComponentBuilder[2];
        componentBuilderArr3[0] = textCell(xtipoDoc.equals("TI") ? "X" : "", 1);
        componentBuilderArr3[1] = label("Tarjeta de identidad", 10, this.textStyle);
        HorizontalListBuilder horizontalListBuilderAdd2 = horizontalListBuilderNewRow2.add(componentBuilderArr3);
        ComponentBuilder[] componentBuilderArr4 = new ComponentBuilder[3];
        componentBuilderArr4[0] = textCell(xtipoDoc.equals("AS") ? "X" : "", 1);
        componentBuilderArr4[1] = label("Adulto sin identifición", 10, this.textStyle);
        componentBuilderArr4[2] = emptyCell(15);
        HorizontalListBuilder horizontalListBuilderNewFlowRow = horizontalListBuilderAdd2.add(componentBuilderArr4).add(new ComponentBuilder[]{label("Número de documento de identificación", 20)}).newFlowRow(0);
        ComponentBuilder[] componentBuilderArr5 = new ComponentBuilder[2];
        componentBuilderArr5[0] = textCell(xtipoDoc.equals("CC") ? "X" : "", 1);
        componentBuilderArr5[1] = label("Cédula de ciudadanía", 10, this.textStyle);
        HorizontalListBuilder horizontalListBuilderAdd3 = horizontalListBuilderNewFlowRow.add(componentBuilderArr5);
        ComponentBuilder[] componentBuilderArr6 = new ComponentBuilder[2];
        componentBuilderArr6[0] = textCell(xtipoDoc.equals("MS") ? "X" : "", 1);
        componentBuilderArr6[1] = label("Menor sin identificación", 10, this.textStyle);
        HorizontalListBuilder horizontalListBuilderNewRow3 = horizontalListBuilderAdd3.add(componentBuilderArr6).newRow(0);
        ComponentBuilder[] componentBuilderArr7 = new ComponentBuilder[2];
        componentBuilderArr7[0] = textCell(xtipoDoc.equals("CE") ? "X" : "", 1);
        componentBuilderArr7[1] = label("Cédula de extrangería", 10, this.textStyle);
        HorizontalListBuilder list = horizontalListBuilderNewRow3.add(componentBuilderArr7).add(new ComponentBuilder[]{emptyCell(20), label("Fecha de Nacimiento", 12), textCell(xFechaNac, 10)}).newFlowRow(0).newRow(0);
        return list;
    }

    private HorizontalListBuilder CoberturaSalud(String xtipoReg) {
        HorizontalListBuilder horizontalListBuilderNewRow = DynamicReports.cmp.horizontalList().add(new ComponentBuilder[]{label("Cobertura en Salud", 15)}).newRow(0);
        ComponentBuilder[] componentBuilderArr = new ComponentBuilder[3];
        componentBuilderArr[0] = textCell(xtipoReg.equals("Regimen Contributivo") ? "X" : "", 1);
        componentBuilderArr[1] = label("Regimen Contributivo", 10, this.textStyleFont7);
        componentBuilderArr[2] = emptyCell(2);
        HorizontalListBuilder horizontalListBuilderAdd = horizontalListBuilderNewRow.add(componentBuilderArr);
        ComponentBuilder[] componentBuilderArr2 = new ComponentBuilder[3];
        componentBuilderArr2[0] = textCell(xtipoReg.equals("Regimen Subsidiado - parcial") ? "X" : "", 1);
        componentBuilderArr2[1] = label("Regimen Subsidiado - parcial", 14, this.textStyleFont7);
        componentBuilderArr2[2] = emptyCell(2);
        HorizontalListBuilder horizontalListBuilderAdd2 = horizontalListBuilderAdd.add(componentBuilderArr2);
        ComponentBuilder[] componentBuilderArr3 = new ComponentBuilder[2];
        componentBuilderArr3[0] = textCell(xtipoReg.equals("Población Pobre no asegurada sin SISBEN") ? "X" : "", 1);
        componentBuilderArr3[1] = label("Población Pobre no asegurada sin SISBEN", 16, this.textStyleFont7);
        HorizontalListBuilder horizontalListBuilderAdd3 = horizontalListBuilderAdd2.add(componentBuilderArr3);
        ComponentBuilder[] componentBuilderArr4 = new ComponentBuilder[2];
        componentBuilderArr4[0] = textCell(xtipoReg.equals("Plan adicional de salud") ? "X" : "", 1);
        componentBuilderArr4[1] = label("Plan adicional de salud", 11, this.textStyleFont7);
        HorizontalListBuilder horizontalListBuilderNewRow2 = horizontalListBuilderAdd3.add(componentBuilderArr4).newRow(0);
        ComponentBuilder[] componentBuilderArr5 = new ComponentBuilder[2];
        componentBuilderArr5[0] = textCell(xtipoReg.equals("Regimen Subsidiado - total") ? "X" : "", 1);
        componentBuilderArr5[1] = label("Regimen Subsidiado - total", 12, this.textStyleFont7);
        HorizontalListBuilder horizontalListBuilderAdd4 = horizontalListBuilderNewRow2.add(componentBuilderArr5);
        ComponentBuilder[] componentBuilderArr6 = new ComponentBuilder[2];
        componentBuilderArr6[0] = textCell(xtipoReg.equals("Población pobre No asegurada con SISBEN") ? "X" : "", 1);
        componentBuilderArr6[1] = label("Población pobre No asegurada con SISBEN", 16, this.textStyleFont7);
        HorizontalListBuilder horizontalListBuilderAdd5 = horizontalListBuilderAdd4.add(componentBuilderArr6);
        ComponentBuilder[] componentBuilderArr7 = new ComponentBuilder[3];
        componentBuilderArr7[0] = textCell((xtipoReg.equals("Desplazado con afiliacion al regimen contributivo") || xtipoReg.equals("Desplazado con afiliacion al regimen subsidiado") || xtipoReg.equals("Desplazado no asegurado (vinculado)")) ? "X" : "", 1);
        componentBuilderArr7[1] = label("Desplazado", 10, this.textStyleFont7);
        componentBuilderArr7[2] = emptyCell(6);
        HorizontalListBuilder horizontalListBuilderAdd6 = horizontalListBuilderAdd5.add(componentBuilderArr7);
        ComponentBuilder[] componentBuilderArr8 = new ComponentBuilder[2];
        componentBuilderArr8[0] = textCell(xtipoReg.equals("Otro") ? "X" : "", 1);
        componentBuilderArr8[1] = label("Otro", 10, this.textStyleFont7);
        HorizontalListBuilder list = horizontalListBuilderAdd6.add(componentBuilderArr8).newRow(0);
        return list;
    }

    private HorizontalListBuilder OrigenAtencion(String xtipoOrigen) {
        HorizontalListBuilder horizontalListBuilderNewRow = DynamicReports.cmp.horizontalList().add(new ComponentBuilder[]{label("Origen de la atención", 15), emptyCell(15), label("Tipo de servicios solicitados", 15), emptyCell(3), label("Prioridad de la atención", 10)}).newRow(0);
        ComponentBuilder[] componentBuilderArr = new ComponentBuilder[2];
        componentBuilderArr[0] = textCell(xtipoOrigen.equals("Enfermedad General") ? "X" : "", 1);
        componentBuilderArr[1] = label("Enfermedad General", 10, this.textStyleFont7);
        HorizontalListBuilder horizontalListBuilderAdd = horizontalListBuilderNewRow.add(componentBuilderArr);
        ComponentBuilder[] componentBuilderArr2 = new ComponentBuilder[2];
        componentBuilderArr2[0] = textCell(xtipoOrigen.equals("Accidente de Trabajo") ? "X" : "", 1);
        componentBuilderArr2[1] = label("Accidente de Trabajo", 8, this.textStyleFont7);
        HorizontalListBuilder horizontalListBuilderAdd2 = horizontalListBuilderAdd.add(componentBuilderArr2);
        ComponentBuilder[] componentBuilderArr3 = new ComponentBuilder[3];
        componentBuilderArr3[0] = textCell(xtipoOrigen.equals("Evento Catastrofico") ? "X" : "", 1);
        componentBuilderArr3[1] = label("Evento Catastrófico", 8, this.textStyleFont7);
        componentBuilderArr3[2] = emptyCell(1);
        HorizontalListBuilder horizontalListBuilderAdd3 = horizontalListBuilderAdd2.add(componentBuilderArr3);
        ComponentBuilder[] componentBuilderArr4 = new ComponentBuilder[3];
        componentBuilderArr4[0] = textCell(xtipoOrigen.equals("") ? "X" : "", 1);
        componentBuilderArr4[1] = label("Posterior a la atención inicial de urgencias", 15, this.textStyleFont7);
        componentBuilderArr4[2] = emptyCell(2);
        HorizontalListBuilder horizontalListBuilderAdd4 = horizontalListBuilderAdd3.add(componentBuilderArr4);
        ComponentBuilder[] componentBuilderArr5 = new ComponentBuilder[2];
        componentBuilderArr5[0] = textCell(xtipoOrigen.equals("") ? "X" : "", 1);
        componentBuilderArr5[1] = label("Prioritaria", 8, this.textStyleFont7);
        HorizontalListBuilder horizontalListBuilderNewRow2 = horizontalListBuilderAdd4.add(componentBuilderArr5).newRow(0);
        ComponentBuilder[] componentBuilderArr6 = new ComponentBuilder[2];
        componentBuilderArr6[0] = textCell(xtipoOrigen.equals("Enfermedad Profesional") ? "X" : "", 1);
        componentBuilderArr6[1] = label("Enfermedad Profesional", 10, this.textStyleFont7);
        HorizontalListBuilder horizontalListBuilderAdd5 = horizontalListBuilderNewRow2.add(componentBuilderArr6);
        ComponentBuilder[] componentBuilderArr7 = new ComponentBuilder[3];
        componentBuilderArr7[0] = textCell(xtipoOrigen.equals("Accidente de Transito") ? "X" : "", 1);
        componentBuilderArr7[1] = label("Accidente de Tránsito", 10, this.textStyleFont7);
        componentBuilderArr7[2] = emptyCell(8);
        HorizontalListBuilder horizontalListBuilderAdd6 = horizontalListBuilderAdd5.add(componentBuilderArr7);
        ComponentBuilder[] componentBuilderArr8 = new ComponentBuilder[3];
        componentBuilderArr8[0] = textCell(xtipoOrigen.equals("") ? "X" : "", 1);
        componentBuilderArr8[1] = label("Servicios electivos", 8, this.textStyleFont7);
        componentBuilderArr8[2] = emptyCell(9);
        HorizontalListBuilder horizontalListBuilderAdd7 = horizontalListBuilderAdd6.add(componentBuilderArr8);
        ComponentBuilder[] componentBuilderArr9 = new ComponentBuilder[2];
        componentBuilderArr9[0] = textCell(xtipoOrigen.equals("") ? "X" : "", 1);
        componentBuilderArr9[1] = label("No prioritaria", 8, this.textStyleFont7);
        HorizontalListBuilder list = horizontalListBuilderAdd7.add(componentBuilderArr9).newRow(0).add(new ComponentBuilder[]{DynamicReports.cmp.line()}).newRow(0);
        return list;
    }

    private HorizontalListBuilder TipoAtencion(String xtipoOrigen) {
        HorizontalListBuilder horizontalListBuilderHorizontalList = DynamicReports.cmp.horizontalList();
        ComponentBuilder[] componentBuilderArr = new ComponentBuilder[2];
        componentBuilderArr[0] = textCell(xtipoOrigen.equals("AMBULATORIO") ? "X" : "", 1);
        componentBuilderArr[1] = label("Consulta Externa", 10, this.textStyleFont7);
        HorizontalListBuilder horizontalListBuilderAdd = horizontalListBuilderHorizontalList.add(componentBuilderArr);
        ComponentBuilder[] componentBuilderArr2 = new ComponentBuilder[3];
        componentBuilderArr2[0] = textCell(xtipoOrigen.equals("HOSPITALIZACION") ? "X" : "", 1);
        componentBuilderArr2[1] = label("Hospitalización", 8, this.textStyleFont7);
        componentBuilderArr2[2] = emptyCell(3);
        HorizontalListBuilder horizontalListBuilderNewRow = horizontalListBuilderAdd.add(componentBuilderArr2).add(new ComponentBuilder[]{label("Servicio  ", 5), labelP("", 19), emptyCell(2)}).add(new ComponentBuilder[]{label("Cama ", 4), textCell("", 6)}).newRow(0);
        ComponentBuilder[] componentBuilderArr3 = new ComponentBuilder[2];
        componentBuilderArr3[0] = textCell(xtipoOrigen.equals("URGENCIAS") ? "X" : "", 1);
        componentBuilderArr3[1] = label("Urgencias", 8, this.textStyleFont7);
        HorizontalListBuilder list = horizontalListBuilderNewRow.add(componentBuilderArr3);
        return list;
    }

    private HorizontalListBuilder TipoDocumentoResponsable(String xtipoDoc, String NoDoc) {
        HorizontalListBuilder horizontalListBuilderNewRow = DynamicReports.cmp.horizontalList().add(new ComponentBuilder[]{label("Tipo de Documento de identificación", 15)}).newRow(0);
        ComponentBuilder[] componentBuilderArr = new ComponentBuilder[2];
        componentBuilderArr[0] = textCell(xtipoDoc.equals("Registro Civil") ? "X" : "", 1);
        componentBuilderArr[1] = label("Registro civil", 10, this.textStyle);
        HorizontalListBuilder horizontalListBuilderAdd = horizontalListBuilderNewRow.add(componentBuilderArr);
        ComponentBuilder[] componentBuilderArr2 = new ComponentBuilder[3];
        componentBuilderArr2[0] = textCell(xtipoDoc.equals("Pasaporte") ? "X" : "", 1);
        componentBuilderArr2[1] = label("Pasaporte", 10, this.textStyle);
        componentBuilderArr2[2] = emptyCell(15);
        HorizontalListBuilder horizontalListBuilderNewRow2 = horizontalListBuilderAdd.add(componentBuilderArr2).add(new ComponentBuilder[]{textCell(NoDoc, 16)}).newRow(0);
        ComponentBuilder[] componentBuilderArr3 = new ComponentBuilder[2];
        componentBuilderArr3[0] = textCell(xtipoDoc.equals("Tarjeta Identidad") ? "X" : "", 1);
        componentBuilderArr3[1] = label("Tarjeta de identidad", 10, this.textStyle);
        HorizontalListBuilder horizontalListBuilderAdd2 = horizontalListBuilderNewRow2.add(componentBuilderArr3);
        ComponentBuilder[] componentBuilderArr4 = new ComponentBuilder[3];
        componentBuilderArr4[0] = textCell(xtipoDoc.equals("Adulto sin Identifición") ? "X" : "", 1);
        componentBuilderArr4[1] = label("Adulto sin identifición", 10, this.textStyle);
        componentBuilderArr4[2] = emptyCell(15);
        HorizontalListBuilder horizontalListBuilderNewFlowRow = horizontalListBuilderAdd2.add(componentBuilderArr4).add(new ComponentBuilder[]{label("Número de documento de identificación", 20)}).newFlowRow(0);
        ComponentBuilder[] componentBuilderArr5 = new ComponentBuilder[2];
        componentBuilderArr5[0] = textCell(xtipoDoc.equals("Cédula de Ciudadanía") ? "X" : "", 1);
        componentBuilderArr5[1] = label("Cédula de ciudadanía", 10, this.textStyle);
        HorizontalListBuilder horizontalListBuilderAdd3 = horizontalListBuilderNewFlowRow.add(componentBuilderArr5);
        ComponentBuilder[] componentBuilderArr6 = new ComponentBuilder[2];
        componentBuilderArr6[0] = textCell(xtipoDoc.equals("Menor sin Identificación") ? "X" : "", 1);
        componentBuilderArr6[1] = label("Menor sin identificación", 10, this.textStyle);
        HorizontalListBuilder horizontalListBuilderNewRow3 = horizontalListBuilderAdd3.add(componentBuilderArr6).newRow(0);
        ComponentBuilder[] componentBuilderArr7 = new ComponentBuilder[2];
        componentBuilderArr7[0] = textCell(xtipoDoc.equals("Cedula Extranjeria") ? "X" : "", 1);
        componentBuilderArr7[1] = label("Cédula de extrangería", 10, this.textStyle);
        HorizontalListBuilder list = horizontalListBuilderNewRow3.add(componentBuilderArr7).newRow(0);
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

    private HorizontalListBuilder textCellGray(String text, int size) {
        HorizontalListBuilder list = DynamicReports.cmp.horizontalList();
        String cellText = StringUtils.rightPad(text, size);
        for (char character : StringUtils.left(cellText, size).toCharArray()) {
            list.add(new ComponentBuilder[]{(TextFieldBuilder) DynamicReports.cmp.text(String.valueOf(character)).setStyle(this.cellStyleGray).setFixedDimension(10, 10)});
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

    private TextFieldBuilder<String> labelPCenter(String text, int size) {
        return label(text, size, this.styleCamposLabelCenter);
    }
}
