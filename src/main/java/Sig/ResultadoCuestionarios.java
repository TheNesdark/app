package Sig;

import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.dynamicreports.jasper.builder.export.JasperXlsxExporterBuilder;
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

/* JADX INFO: loaded from: GenomaP.jar:Sig/ResultadoCuestionarios.class */
public class ResultadoCuestionarios {
    ResultSet xrs;
    ResultSet xrsSub;
    private String xTitulo;
    private String xFechaI;
    private String xFechaF;
    private int xEncabezado;
    private String xRuta;
    ConsultasMySQL xct = new ConsultasMySQL();
    Metodos xmetodos = new Metodos();
    private Connection connection = this.xct.establecerConexionBd();

    public ResultadoCuestionarios(String xRuta, String xFechaI, String xFechaF, int xEncabezado) {
        this.xRuta = xRuta;
        this.xFechaI = xFechaI;
        this.xFechaF = xFechaF;
        this.xEncabezado = xEncabezado;
        build();
        System.out.println("Ruta-->" + xRuta);
        this.xmetodos.mostrarPdf(xRuta + ".xlsx");
    }

    private void build() {
        System.out.println("Entro al build 1 ");
        new TemplateSO();
        CrosstabRowGroupBuilder<String> rowGroupTDoc = DynamicReports.ctab.rowGroup("Tdocumento", String.class).setShowTotal(Boolean.FALSE).setHeaderWidth(20).setHeaderHorizontalAlignment(HorizontalAlignment.LEFT);
        CrosstabRowGroupBuilder<String> rowGroupFechaR = DynamicReports.ctab.rowGroup("FechaR", String.class).setShowTotal(Boolean.FALSE).setHeaderWidth(100).setHeaderHorizontalAlignment(HorizontalAlignment.LEFT);
        CrosstabRowGroupBuilder<String> rowGroupDoc = DynamicReports.ctab.rowGroup("documento", String.class).setShowTotal(Boolean.FALSE).setHeaderWidth(100).setHeaderHorizontalAlignment(HorizontalAlignment.LEFT);
        CrosstabRowGroupBuilder<String> rowGroup = DynamicReports.ctab.rowGroup("state", String.class).setShowTotal(Boolean.FALSE).setHeaderWidth(300).setHeaderHorizontalAlignment(HorizontalAlignment.LEFT);
        CrosstabRowGroupBuilder<String> rowGroupSex = DynamicReports.ctab.rowGroup("genero", String.class).setShowTotal(Boolean.FALSE).setHeaderWidth(100).setHeaderHorizontalAlignment(HorizontalAlignment.LEFT);
        CrosstabRowGroupBuilder<String> rowGroupEdad = DynamicReports.ctab.rowGroup("edad", String.class).setShowTotal(Boolean.FALSE).setHeaderWidth(70).setHeaderHorizontalAlignment(HorizontalAlignment.LEFT);
        CrosstabRowGroupBuilder<String> rowGroupCargo = DynamicReports.ctab.rowGroup("cargo", String.class).setShowTotal(Boolean.FALSE).setHeaderWidth(300).setHeaderHorizontalAlignment(HorizontalAlignment.LEFT);
        CrosstabRowGroupBuilder<String> rowGroupUN = DynamicReports.ctab.rowGroup("UN", String.class).setShowTotal(Boolean.FALSE).setHeaderWidth(300).setHeaderHorizontalAlignment(HorizontalAlignment.LEFT);
        CrosstabColumnGroupBuilder<String> columnGroup = DynamicReports.ctab.columnGroup("item", String.class).setShowTotal(Boolean.FALSE).setHeaderStyle(TemplateSO.encabezado).setHeaderHeight(100);
        ComponentBuilder repeatColumnHeaders = DynamicReports.ctab.crosstab().rowGroups(new CrosstabRowGroupBuilder[]{rowGroupTDoc}).rowGroups(new CrosstabRowGroupBuilder[]{rowGroupFechaR}).rowGroups(new CrosstabRowGroupBuilder[]{rowGroupDoc}).rowGroups(new CrosstabRowGroupBuilder[]{rowGroup}).rowGroups(new CrosstabRowGroupBuilder[]{rowGroupSex}).rowGroups(new CrosstabRowGroupBuilder[]{rowGroupEdad}).rowGroups(new CrosstabRowGroupBuilder[]{rowGroupCargo}).rowGroups(new CrosstabRowGroupBuilder[]{rowGroupUN}).columnGroups(new CrosstabColumnGroupBuilder[]{columnGroup}).measures(new CrosstabMeasureBuilder[]{DynamicReports.ctab.measure("Respuesta", "respuesta", String.class, Calculation.NOTHING), DynamicReports.ctab.measure("Observación", "obs", String.class, Calculation.NOTHING), DynamicReports.ctab.measure("Subcategorias", "sub", String.class, Calculation.NOTHING)}).setRepeatColumnHeaders(Boolean.FALSE);
        try {
            Statement persona = this.connection.createStatement();
            this.xrs = persona.executeQuery("SELECT\n\t(@rownum := @rownum + 1) NFila,\n\t`h_so_cuestionarios_encabezado`.`Id`,\n\t`so_tipo_preguntas`.`Id` AS IdPregunta ,\n\t`h_so_cuestionarios_encabezado`.`FechaR` ,\n\t`so_tipo_cuestionario`.`Nbre` AS `NCuestionario` ,\n\tIF(`h_so_cuestionarios_encabezado`.`Observacion` IS NULL,'',CONCAT('OBSERVACION : ', `h_so_cuestionarios_encabezado`.`Observacion`)) AS `ObservacionG` ,\n\t`so_tipo_preguntas`.`Nbre` AS `NPregunta` ,\n\t`h_so_cuestionario_detalle`.`ValorR` AS `Respuesta` ,\n\t`h_so_cuestionario_detalle`.`Observacion` AS `ObservacionR` ,\n\t`g_persona`.`Id_TipoIdentificacion`,\n\t`g_persona`.`NoDocumento`,\n\tCONCAT(`g_persona`.`Apellido1`,' ',`g_persona`.`Apellido2`,' ',`g_persona`.`Nombre1`,' ',`g_persona`.`Nombre2`) AS `NUsuario`,\n\t`g_sexo`.`Nbre` AS `NSexo`,\n\t`g_persona`.`Edad`,\n\t`g_empresa`.`Nbre` AS `EPS` ,\n\tIF(`ingreso`.`SO_Cargo` = '',NULL,`ingreso`.`SO_Cargo`) AS Cargo ,\n\tIF(`ingreso`.`SO_UNegocio` = '',NULL,`ingreso`.`SO_UNegocio`) AS UNegocio,\n\tIF(`ingreso`.`SO_Arl` = '',\tNULL, CONCAT('ARL : ', `ingreso`.`SO_Arl`)) AS Arl ,\n\tIF(`f_empresacontxconvenio`.`Nbre` = '', NULL,\n\tCONCAT('EMPRESA : ', `ingreso`.`SO_Arl`)) AS `EContratista` ,GROUP_CONCAT(`so_tipo_subcategoria`.`Nbre` ORDER BY `so_tipo_subcategoria`.`Nbre` DESC SEPARATOR ', ') AS SubCategorias\nFROM\n\t`h_so_cuestionario_detalle`\nINNER JOIN `h_so_cuestionarios_encabezado` ON\n\t(`h_so_cuestionario_detalle`.`Id_Cuestionario` = `h_so_cuestionarios_encabezado`.`Id`)\nINNER JOIN `so_tipo_cuestionario` ON\n\t(`h_so_cuestionarios_encabezado`.`Id_Cuestionario` = `so_tipo_cuestionario`.`Id`)\nINNER JOIN `so_tipo_respuesta` ON\n\t(`h_so_cuestionario_detalle`.`Id_Respuesta` = `so_tipo_respuesta`.`Id`)\nINNER JOIN `so_tipo_preguntas` ON\n\t(`h_so_cuestionario_detalle`.`Id_Pregunta` = `so_tipo_preguntas`.`Id`)\nINNER JOIN `h_atencion` ON\n\t(`h_atencion`.`Id` = `h_so_cuestionarios_encabezado`.`Id_Atencion`)\nINNER JOIN `ingreso` ON\n\t(`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\nINNER JOIN `f_empresacontxconvenio` ON\n\t(`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)\nINNER JOIN g_persona ON\n\t(g_persona.Id = `h_so_cuestionarios_encabezado`.`Id_Usuario`)\nINNER JOIN g_sexo  ON\n\t(`g_persona`.`Id_Sexo` = `g_sexo`.`Id`)\nINNER JOIN g_tipoedad ON\n\t(g_tipoedad.Id=g_persona.Id_TipoEdad)\nINNER JOIN g_usuario on\n\t(g_usuario.Id_persona =g_persona.Id)\nINNER JOIN g_empresacont on\n\t(`g_usuario`.`Id_EmpresaCont` = `g_empresacont`.`Id_empresa`)\nINNER JOIN g_empresa on\n\t(g_empresa.`Id`=g_empresacont.Id_empresa)\t\nLEFT JOIN `h_so_cuestionario_detalle_subcategoria` ON\n\t(`h_so_cuestionario_detalle_subcategoria`.`Id_CDetalle` = `h_so_cuestionario_detalle`.`Id`)\nLEFT JOIN `so_tipo_subcategoria` ON\n\t(`h_so_cuestionario_detalle_subcategoria`.`Id_SubCategoria` = `so_tipo_subcategoria`.`Id`) ,\n\t(\n\tSELECT\n\t\t@rownum := 0) R\nWHERE\n\t( `h_so_cuestionarios_encabezado`.`Estado` = 1\n\t\tAND h_so_cuestionarios_encabezado.`Id_Cuestionario` = '" + this.xEncabezado + "'\n\t\tAND h_so_cuestionarios_encabezado.`FechaR` >= '" + this.xFechaI + "'\n\t\tAND h_so_cuestionarios_encabezado.`FechaR` <= '" + this.xFechaF + "')\nGROUP BY\n\t`h_so_cuestionarios_encabezado`.`Id`,\n\t`h_so_cuestionario_detalle`.`Id_Pregunta`\nORDER BY\n\t`ingreso`.`SO_UNegocio` ASC,\n\t`NUsuario` ASC");
        } catch (SQLException ex) {
            Logger.getLogger(ResultadoCuestionarios.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        try {
            JasperXlsxExporterBuilder xlsExporter = DynamicReports.export.xlsxExporter(this.xRuta + ".xlsx").setDetectCellType(true).setIgnorePageMargins(true).setWhitePageBackground(false).setRemoveEmptySpaceBetweenColumns(true);
            DynamicReports.report().setPageFormat(550, 3250, PageOrientation.LANDSCAPE).setTemplate(TemplateSO.reportTemplate).title(new ComponentBuilder[]{TemplateSO.createTitleComponent("")}).summary(new ComponentBuilder[]{repeatColumnHeaders}).addProperty("net.sf.jasperreports.export.xls.freeze.row", "2").ignorePageWidth().ignorePagination().setDataSource(createDataSource()).toXlsx(xlsExporter);
        } catch (DRException e) {
            e.printStackTrace();
        }
    }

    private JRDataSource createDataSource() {
        DRDataSource dataSource = new DRDataSource(new String[]{"Tdocumento", "FechaR", "documento", "state", "genero", "edad", "cargo", "UN", "item", "respuesta", "obs", "sub"});
        try {
            if (this.xrs.next()) {
                int n = 0;
                while (this.xrs.next()) {
                    dataSource.add(new Object[]{this.xrs.getString(10), this.xrs.getString(4), this.xrs.getString(11), this.xrs.getString(12), this.xrs.getString(13), this.xrs.getString(14), this.xrs.getString(16), this.xrs.getString(17), this.xrs.getString(7), this.xrs.getString(8), this.xrs.getString(9), this.xrs.getString("SubCategorias")});
                    n++;
                }
            }
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(ResultadoCuestionarios.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return dataSource;
    }
}
