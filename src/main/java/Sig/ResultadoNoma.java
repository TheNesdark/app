package Sig;

import Utilidades.ConsultasMySQL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.dynamicreports.jasper.builder.export.JasperXlsExporterBuilder;
import net.sf.dynamicreports.report.builder.DynamicReports;
import net.sf.dynamicreports.report.builder.component.ComponentBuilder;
import net.sf.dynamicreports.report.builder.crosstab.CrosstabColumnGroupBuilder;
import net.sf.dynamicreports.report.builder.crosstab.CrosstabMeasureBuilder;
import net.sf.dynamicreports.report.builder.crosstab.CrosstabRowGroupBuilder;
import net.sf.dynamicreports.report.constant.Calculation;
import net.sf.dynamicreports.report.constant.HorizontalAlignment;
import net.sf.dynamicreports.report.constant.PageOrientation;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.report.exception.DRException;
import net.sf.jasperreports.engine.JRDataSource;

/* JADX INFO: loaded from: GenomaP.jar:Sig/ResultadoNoma.class */
public class ResultadoNoma {
    ResultSet xrs;
    ResultSet xrsSub;
    private String xTitulo;
    private String xFechaI;
    private String xFechaF;
    private int xEncabezado;
    private String xRuta;
    ConsultasMySQL xct = new ConsultasMySQL();
    private Connection connection = this.xct.establecerConexionBd();

    public ResultadoNoma(String xRuta, String xFechaI, String xFechaF, int xEncabezado) {
        this.xRuta = xRuta;
        this.xFechaI = xFechaI;
        this.xFechaF = xFechaF;
        this.xEncabezado = xEncabezado;
        build();
        System.out.println("Ruta-->" + xRuta);
    }

    private void build() {
        new TemplateSO();
        CrosstabRowGroupBuilder<String> rowGroupTDoc = DynamicReports.ctab.rowGroup("Tdocumento", String.class).setShowTotal(Boolean.FALSE).setHeaderWidth(10).setHeaderHorizontalAlignment(HorizontalAlignment.LEFT);
        CrosstabRowGroupBuilder<String> rowGroupDoc = DynamicReports.ctab.rowGroup("documento", String.class).setShowTotal(Boolean.FALSE).setHeaderWidth(100).setHeaderHorizontalAlignment(HorizontalAlignment.LEFT);
        CrosstabRowGroupBuilder<String> rowGroup = DynamicReports.ctab.rowGroup("state", String.class).setShowTotal(Boolean.FALSE).setHeaderWidth(300).setHeaderHorizontalAlignment(HorizontalAlignment.LEFT);
        CrosstabRowGroupBuilder<String> rowGroupSex = DynamicReports.ctab.rowGroup("genero", String.class).setShowTotal(Boolean.FALSE).setHeaderWidth(100).setHeaderHorizontalAlignment(HorizontalAlignment.LEFT);
        CrosstabRowGroupBuilder<String> rowGroupEdad = DynamicReports.ctab.rowGroup("edad", String.class).setShowTotal(Boolean.FALSE).setHeaderWidth(70).setHeaderHorizontalAlignment(HorizontalAlignment.LEFT);
        CrosstabRowGroupBuilder<String> rowGroupCargo = DynamicReports.ctab.rowGroup("cargo", String.class).setShowTotal(Boolean.FALSE).setHeaderWidth(300).setHeaderHorizontalAlignment(HorizontalAlignment.LEFT);
        CrosstabRowGroupBuilder<String> rowGroupUN = DynamicReports.ctab.rowGroup("UN", String.class).setShowTotal(Boolean.FALSE).setHeaderWidth(300).setHeaderHorizontalAlignment(HorizontalAlignment.LEFT);
        CrosstabColumnGroupBuilder<String> columnGroup = DynamicReports.ctab.columnGroup("item", String.class).setShowTotal(Boolean.FALSE).setHeaderStyle(TemplateSO.encabezado).setHeaderHeight(100);
        ComponentBuilder repeatColumnHeaders = DynamicReports.ctab.crosstab().rowGroups(new CrosstabRowGroupBuilder[]{rowGroupTDoc}).rowGroups(new CrosstabRowGroupBuilder[]{rowGroupDoc}).rowGroups(new CrosstabRowGroupBuilder[]{rowGroup}).rowGroups(new CrosstabRowGroupBuilder[]{rowGroupSex}).rowGroups(new CrosstabRowGroupBuilder[]{rowGroupEdad}).rowGroups(new CrosstabRowGroupBuilder[]{rowGroupCargo}).rowGroups(new CrosstabRowGroupBuilder[]{rowGroupUN}).columnGroups(new CrosstabColumnGroupBuilder[]{columnGroup}).measures(new CrosstabMeasureBuilder[]{DynamicReports.ctab.measure("CUELLO", "cuello", String.class, Calculation.NOTHING), DynamicReports.ctab.measure("HOMBRO", "hombro", String.class, Calculation.NOTHING), DynamicReports.ctab.measure("MUÑECA", "munieca", String.class, Calculation.NOTHING), DynamicReports.ctab.measure("RODILLA", "rodilla", String.class, Calculation.NOTHING), DynamicReports.ctab.measure("CADERA", "cadera", String.class, Calculation.NOTHING), DynamicReports.ctab.measure("PIES", "pies", String.class, Calculation.NOTHING), DynamicReports.ctab.measure("TRONCO DORSAL", "tdorsal", String.class, Calculation.NOTHING), DynamicReports.ctab.measure("TRONCO LUMBAR", "tlumbar", String.class, Calculation.NOTHING)}).setRepeatColumnHeaders(Boolean.FALSE);
        try {
            Statement persona = this.connection.createStatement();
            this.xrs = persona.executeQuery("SELECT (@rownum := @rownum + 1) NFila,  `h_so_cuestionarios_encabezado`.`Id`, `so_tipo_preguntas`.`Id` AS IdPregunta  , `h_so_cuestionarios_encabezado`.`FechaR`  , `so_tipo_cuestionario`.`Nbre` AS `NCuestionario`  , IF(`h_so_cuestionarios_encabezado`.`Observacion` IS NULL,'', CONCAT('OBSERVACION : ',`h_so_cuestionarios_encabezado`.`Observacion`)) AS `ObservacionG`  , `so_tipo_preguntas`.`Nbre` AS `NPregunta` , `h_so_cuestionario_detalle`.`ValorR` AS `Respuesta`  , `h_so_cuestionario_detalle`.`Observacion` AS `ObservacionR`  , `persona`.`Id_TipoIdentificacion`, `persona`.`NoDocumento`  , `persona`.`NUsuario` , `persona`.`NSexo`  , `persona`.`Edad`, `persona`.`EPS`  , IF(`ingreso`.`SO_Cargo`='',NULL, `ingreso`.`SO_Cargo`) AS Cargo  , IF(`ingreso`.`SO_UNegocio`='',NULL, `ingreso`.`SO_UNegocio`) AS UNegocio,  IF(`ingreso`.`SO_Arl`='',NULL,CONCAT('ARL : ', `ingreso`.`SO_Arl`)) AS  Arl  ,  IF(`f_empresacontxconvenio`.`Nbre`='',NULL,CONCAT('EMPRESA : ', `ingreso`.`SO_Arl`)) AS `EContratista`   , GROUP_CONCAT(`so_tipo_subcategoria`.`Nbre` ORDER BY `so_tipo_subcategoria`.`Nbre` DESC SEPARATOR ', ') AS SubCategorias  FROM `h_so_cuestionario_detalle`  INNER JOIN `h_so_cuestionarios_encabezado` ON (`h_so_cuestionario_detalle`.`Id_Cuestionario` = `h_so_cuestionarios_encabezado`.`Id`)  INNER JOIN `so_tipo_cuestionario` ON (`h_so_cuestionarios_encabezado`.`Id_Cuestionario` = `so_tipo_cuestionario`.`Id`)  INNER JOIN `so_tipo_respuesta` ON (`h_so_cuestionario_detalle`.`Id_Respuesta` = `so_tipo_respuesta`.`Id`)  INNER JOIN `so_tipo_preguntas` ON (`h_so_cuestionario_detalle`.`Id_Pregunta` = `so_tipo_preguntas`.`Id`)  INNER JOIN `h_atencion`  ON (`h_atencion`.`Id` = `h_so_cuestionarios_encabezado`.`Id_Atencion`)  INNER JOIN `ingreso` ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)  INNER JOIN `f_empresacontxconvenio` ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)  INNER JOIN `persona` ON (`persona`.`Id_persona` = `h_so_cuestionarios_encabezado`.`Id_Usuario`) LEFT JOIN `h_so_cuestionario_detalle_subcategoria`  ON (`h_so_cuestionario_detalle_subcategoria`.`Id_CDetalle` = `h_so_cuestionario_detalle`.`Id`)  LEFT JOIN `so_tipo_subcategoria`  ON (`h_so_cuestionario_detalle_subcategoria`.`Id_SubCategoria` = `so_tipo_subcategoria`.`Id`) , (SELECT @rownum:=0) R   WHERE ( `h_so_cuestionarios_encabezado`.`Estado` =1  AND h_so_cuestionarios_encabezado.`Id_Cuestionario`='" + this.xEncabezado + "' AND h_so_cuestionarios_encabezado.`FechaR`>='" + this.xFechaI + "' AND h_so_cuestionarios_encabezado.`FechaR`<='" + this.xFechaF + "')  GROUP BY `h_so_cuestionarios_encabezado`.`Id`,  `h_so_cuestionario_detalle`.`Id_Pregunta`  ORDER BY `ingreso`.`SO_UNegocio` ASC, `persona`.`NUsuario` ASC ");
        } catch (SQLException ex) {
            Logger.getLogger(ResultadoNoma.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        try {
            JasperXlsExporterBuilder xlsExporter = DynamicReports.export.xlsExporter(this.xRuta + ".xls").setDetectCellType(true).setIgnorePageMargins(true).setWhitePageBackground(false).setRemoveEmptySpaceBetweenColumns(true);
            DynamicReports.report().setPageFormat(550, 3250, PageOrientation.LANDSCAPE).setTemplate(TemplateSO.reportTemplate).title(new ComponentBuilder[]{TemplateSO.createTitleComponent("")}).summary(new ComponentBuilder[]{repeatColumnHeaders}).addProperty("net.sf.jasperreports.export.xls.freeze.row", "2").ignorePageWidth().ignorePagination().setDataSource(createDataSource()).toXls(xlsExporter);
        } catch (DRException e) {
            e.printStackTrace();
        }
    }

    private JRDataSource createDataSource() {
        DRDataSource dataSource = new DRDataSource(new String[]{"Tdocumento", "documento", "state", "genero", "edad", "cargo", "UN", "item", "respuesta", "obs", "sub"});
        try {
            if (this.xrs.next()) {
                int n = 0;
                while (this.xrs.next()) {
                    dataSource.add(new Object[]{this.xrs.getString(10), this.xrs.getString(11), this.xrs.getString(12), this.xrs.getString(13), this.xrs.getString(14), this.xrs.getString(16), this.xrs.getString(17), this.xrs.getString(7), this.xrs.getString(8), this.xrs.getString(9), this.xrs.getString("SubCategorias")});
                    n++;
                }
            }
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(ResultadoNoma.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return dataSource;
    }
}
