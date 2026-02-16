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

/* JADX INFO: loaded from: GenomaP.jar:Sig/ResultadoSociodemografico.class */
public class ResultadoSociodemografico {
    ResultSet xrs;
    ResultSet xrsSub;
    private String xTitulo;
    private String xFechaI;
    private String xFechaF;
    private int xEncabezado;
    private String xRuta;
    ConsultasMySQL xct = new ConsultasMySQL();
    private Connection connection = this.xct.establecerConexionBd();

    public ResultadoSociodemografico(String xRuta, String xFechaI, String xFechaF) {
        this.xRuta = xRuta;
        this.xFechaI = xFechaI;
        this.xFechaF = xFechaF;
        build();
        System.out.println("Ruta-->" + xRuta);
    }

    private void build() {
        new TemplateSO();
        CrosstabRowGroupBuilder<String> rowGroupTDoc = DynamicReports.ctab.rowGroup("IdEvaluacion", String.class).setShowTotal(Boolean.FALSE).setHeaderWidth(10).setHeaderHorizontalAlignment(HorizontalAlignment.LEFT);
        CrosstabRowGroupBuilder<String> rowGroupDoc = DynamicReports.ctab.rowGroup("documento", String.class).setShowTotal(Boolean.FALSE).setHeaderWidth(100).setHeaderHorizontalAlignment(HorizontalAlignment.LEFT);
        CrosstabRowGroupBuilder<String> rowGroup = DynamicReports.ctab.rowGroup("usuario", String.class).setShowTotal(Boolean.FALSE).setHeaderWidth(300).setHeaderHorizontalAlignment(HorizontalAlignment.LEFT);
        CrosstabRowGroupBuilder<String> rowGroupSex = DynamicReports.ctab.rowGroup("genero", String.class).setShowTotal(Boolean.FALSE).setHeaderWidth(100).setHeaderHorizontalAlignment(HorizontalAlignment.LEFT);
        CrosstabRowGroupBuilder<String> rowGroupEdad = DynamicReports.ctab.rowGroup("edad", String.class).setShowTotal(Boolean.FALSE).setHeaderWidth(70).setHeaderHorizontalAlignment(HorizontalAlignment.LEFT);
        CrosstabColumnGroupBuilder<String> columnGroup = DynamicReports.ctab.columnGroup("item", String.class).setShowTotal(Boolean.FALSE).setHeaderStyle(TemplateSO.encabezado).setHeaderHeight(150);
        ComponentBuilder repeatColumnHeaders = DynamicReports.ctab.crosstab().rowGroups(new CrosstabRowGroupBuilder[]{rowGroupTDoc}).rowGroups(new CrosstabRowGroupBuilder[]{rowGroupDoc}).rowGroups(new CrosstabRowGroupBuilder[]{rowGroup}).rowGroups(new CrosstabRowGroupBuilder[]{rowGroupSex}).rowGroups(new CrosstabRowGroupBuilder[]{rowGroupEdad}).columnGroups(new CrosstabColumnGroupBuilder[]{columnGroup}).measures(new CrosstabMeasureBuilder[]{DynamicReports.ctab.measure("Respuesta", "Respuesta", String.class, Calculation.NOTHING)}).setRepeatColumnHeaders(Boolean.FALSE);
        try {
            Statement persona = this.connection.createStatement();
            this.xrs = persona.executeQuery("SELECT  so_p_sociodemografico_atencion.Id AS IdEval, `so_p_sociodemografica`.`Orden`,     CONCAT(`so_p_sociodemografica`.`Orden`,'-',so_p_sociodemografica.`Nbre`) AS Pregunta     , `so_p_sociodem_detalle`.`Respuesta`     , `persona`.`NUsuario`     , `persona`.`IdSexo`     , `persona`.`FechaNac`     , `persona`.`Edad`     , `persona`.`NoDocumento`  FROM     `so_p_sociodem_detalle`     INNER JOIN `so_p_sociodemografico_atencion`         ON (`so_p_sociodem_detalle`.`IdEvaluacion` = `so_p_sociodemografico_atencion`.`Id`)     INNER JOIN `h_atencion`         ON (`so_p_sociodemografico_atencion`.`IdAtencion` = `h_atencion`.`Id`)     INNER JOIN `so_p_sociodemografica`         ON (`so_p_sociodem_detalle`.`IdPregunta` = `so_p_sociodemografica`.`Id`)     INNER JOIN `ingreso`         ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)     INNER JOIN `persona`         ON (`ingreso`.`Id_Usuario` = `persona`.`Id_persona`)         WHERE(so_p_sociodemografico_atencion.`FechaR`>='" + this.xFechaI + "' AND so_p_sociodemografico_atencion.`FechaR`<='" + this.xFechaF + "')  ORDER BY so_p_sociodemografico_atencion.`Id`,`so_p_sociodemografica`.`Orden`;");
        } catch (SQLException ex) {
            Logger.getLogger(ResultadoSociodemografico.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        try {
            JasperXlsExporterBuilder xlsExporter = DynamicReports.export.xlsExporter(this.xRuta + ".xls").setDetectCellType(true).setIgnorePageMargins(true).setWhitePageBackground(false).setRemoveEmptySpaceBetweenColumns(true);
            DynamicReports.report().setPageFormat(550, 3250, PageOrientation.LANDSCAPE).setTemplate(TemplateSO.reportTemplate).title(new ComponentBuilder[]{TemplateSO.createTitleComponent("")}).summary(new ComponentBuilder[]{repeatColumnHeaders}).addProperty("net.sf.jasperreports.export.xls.freeze.row", "2").ignorePageWidth().ignorePagination().setDataSource(createDataSource()).toXls(xlsExporter);
        } catch (DRException e) {
            e.printStackTrace();
        }
    }

    private JRDataSource createDataSource() {
        DRDataSource dataSource = new DRDataSource(new String[]{"IdEvaluacion", "documento", "usuario", "genero", "edad", "item", "Respuesta"});
        try {
            if (this.xrs.next()) {
                int n = 0;
                while (this.xrs.next()) {
                    dataSource.add(new Object[]{this.xrs.getString("IdEval"), this.xrs.getString("NoDocumento"), this.xrs.getString("NUsuario"), this.xrs.getString("IdSexo"), this.xrs.getString("Edad"), this.xrs.getString("Pregunta"), this.xrs.getString("Respuesta")});
                    n++;
                }
            }
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(ResultadoSociodemografico.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return dataSource;
    }
}
