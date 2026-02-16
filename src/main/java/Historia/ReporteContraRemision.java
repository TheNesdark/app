package Historia;

import Facturacion.Templates_1;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
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

/* JADX INFO: loaded from: GenomaP.jar:Historia/ReporteContraRemision.class */
public class ReporteContraRemision {
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
    private String xidAtencion;
    private Metodos xmt = new Metodos();
    private ConsultasMySQL xct = new ConsultasMySQL();
    private String xpersona = "";
    private Connection connection = this.xct.establecerConexionBd();

    public ReporteContraRemision(String xidAtencion) {
        this.xidAtencion = "";
        this.xidAtencion = xidAtencion;
    }

    public JasperReportBuilder build() {
        JasperPdfExporterBuilder pdfExporter = DynamicReports.export.pdfExporter(this.xmt.getRutaRep() + "FContraReferencia.pdf");
        JasperReportBuilder report = DynamicReports.report();
        new Templates_1();
        try {
            Statement persona = this.connection.createStatement();
            Statement empresa = this.connection.createStatement();
            Statement remision = this.connection.createStatement();
            this.rootStyle = DynamicReports.stl.style().setPadding(2);
            this.boldStyle = DynamicReports.stl.style(this.rootStyle).bold();
            this.boldCenteredStyle = DynamicReports.stl.style(this.boldStyle).setAlignment(HorizontalAlignment.CENTER, VerticalAlignment.TOP);
            this.fount_roja = DynamicReports.stl.style(this.boldStyle).setAlignment(HorizontalAlignment.CENTER, VerticalAlignment.TOP).setFontSize(7).setForegroundColor(Color.RED);
            this.bold10CenteredStyle = DynamicReports.stl.style(this.boldCenteredStyle).setFontSize(8);
            this.textStyle = DynamicReports.stl.style().setFontSize(8).setPadding(2);
            this.centeredStyle = DynamicReports.stl.style(this.textStyle).setAlignment(HorizontalAlignment.CENTER, VerticalAlignment.MIDDLE);
            this.labelStyle = DynamicReports.stl.style(this.textStyle).setHorizontalAlignment(HorizontalAlignment.LEFT).bold();
            this.cellStyle = DynamicReports.stl.style(this.textStyle).setBorder(DynamicReports.stl.pen1Point()).setAlignment(HorizontalAlignment.CENTER, VerticalAlignment.MIDDLE);
            DynamicReports.stl.style(this.bold14Style).setFontSize(10).bold().setHorizontalAlignment(HorizontalAlignment.CENTER).setBackgroundColor(new Color(204, 255, 204)).setBorder(DynamicReports.stl.pen1Point());
            DynamicReports.stl.style(this.bold14Style).setFontSize(10).bold().setHorizontalAlignment(HorizontalAlignment.CENTER).setBorder(DynamicReports.stl.pen1Point());
            StyleBuilder styleCuadroBlanco2 = DynamicReports.stl.style(this.bold14Style).setFontSize(8).setHorizontalAlignment(HorizontalAlignment.LEFT).setBorder(DynamicReports.stl.pen1Point());
            this.styleCamposLabel = DynamicReports.stl.style(this.bold14Style).setFontSize(10).bold().setHorizontalAlignment(HorizontalAlignment.LEFT).setBorder(DynamicReports.stl.pen1Point());
            ResultSet xrs = empresa.executeQuery("SELECT `g_ips`.`Nbre` AS NEmpresa , `g_ips`.`Id_TipoIdentificacion` , CONCAT(`g_ips`.`Identificacion`,'-',`g_ips`.`DigitoVerificacion`) AS Identificacion     , `g_ips`.`CodigoOrganismo` , `g_ips`.`Direccion` , `g_ips`.`Telefono`  , `g_municipio`.`Nbre` AS Mpio , `g_departamento`.`Nbre` AS Dpto FROM `g_ips` INNER JOIN  `g_municipio`  ON (`g_ips`.`Id_Municipio` = `g_municipio`.`Id`)     INNER JOIN  `g_departamento`  ON (`g_municipio`.`Id_Dpto` = `g_departamento`.`Id`)");
            xrs.first();
            ResultSet xrsper = persona.executeQuery("SELECT CONCAT(`g_persona`.`Apellido1` ,' ' , `g_persona`.`Apellido2` ,' ' , `g_persona`.`Nombre1` ,' ' , `g_persona`.`Nombre2` ) AS NombreCompleto, `g_persona`.`Id_TipoIdentificacion`\n    , `g_persona`.`NoDocumento` , `g_persona`.`Direccion` , `g_persona`.`Telefono` ,  DATE_FORMAT(`g_persona`.`FechaNac`,'%Y-%m-%d') AS FechaNac , `g_municipio`.`Nbre` AS Mpio, `g_departamento`.`Nbre` AS Dpto\n    , `f_empresacontxconvenio`.`Nbre` AS NEmpresa , `g_empresacont`.`Codigo`, ingreso.NPersonaResp, ingreso.TipDoc, ingreso.NoDocumento AS NoDocumentoResp, ingreso.TelefonoPResp, `g_tipoatencion`.`Nbre` AS TipoAtencion   FROM `ingreso`\n    INNER JOIN  `g_persona`  ON (`ingreso`.`Id_Usuario` = `g_persona`.`Id`)\n    INNER JOIN  `g_municipio`   ON (`g_persona`.`Id_Municipio` = `g_municipio`.`Id`)\n    INNER JOIN  `g_departamento`  ON (`g_municipio`.`Id_Dpto` = `g_departamento`.`Id`)\n    INNER JOIN  `f_empresacontxconvenio`  ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)\n    INNER JOIN  `g_empresacont`   ON (`f_empresacontxconvenio`.`Id_EmpresaCont` = `g_empresacont`.`Id_empresa`)\n    INNER JOIN  `g_tipoatencion`  ON (`ingreso`.`Id_TipoAtencion` = `g_tipoatencion`.`Id`)     INNER JOIN `h_atencion`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`) WHERE (`h_atencion`.`Id` ='" + this.xidAtencion + "')");
            xrsper.first();
            ResultSet xrsrem = remision.executeQuery("SELECT CONCAT(`g_persona`.`Apellido1`,' ',`g_persona`.`Apellido2` ,' ', `g_persona`.`Nombre1` ,' ', `g_persona`.`Nombre2`) AS Profesional , `g_persona`.`Telefono` , `g_persona`.`Movil`  , `h_remisiones`.`ServicioRem`,   `h_remisiones`.`Detalle` , IF(`profesional1`.`DireccionF` IS NULL, '',`profesional1`.`DireccionF`) AS DireccionF , `profesional1`.`NProfesional` , `profesional1`.`Especialidad` , `profesional1`.`Tarjeta`, DATE_FORMAT(h_remisiones.Fecha,'%Y-%m-%d') AS Fecha, DATE_FORMAT(h_remisiones.Hora, '%H:%i') AS Hora FROM `h_remisiones` INNER JOIN `h_atencion`   ON (`h_remisiones`.`Id_Atencion` = `h_atencion`.`Id`)\n    INNER JOIN  `g_persona`   ON (`h_remisiones`.`Id_Profesional` = `g_persona`.`Id`)\n     INNER JOIN  `profesional1`  ON (`h_remisiones`.`Id_Profesional` = `profesional1`.`Id_Persona`) AND (`h_remisiones`.`Id_EspecialidadR` = `profesional1`.`IdEspecialidad`) WHERE (`h_atencion`.`Id` ='" + this.xidAtencion + "')");
            xrsrem.first();
            report.setTemplate(Templates_1.reportTemplate).setPageFormat(612, 1030, PageOrientation.PORTRAIT).setTextStyle(this.textStyle).title(new ComponentBuilder[]{DynamicReports.cmp.image(this.xmt.getRutaRep() + "EncabezadoContraReferencia.png").setFixedDimension(592, 60), DynamicReports.cmp.horizontalList().add(new ComponentBuilder[]{emptyCell(34), label("Fecha:", 4), textCell(xrsrem.getString("Fecha"), 10)}).add(new ComponentBuilder[]{emptyCell(2), label("Hora:", 4), textCell(xrsrem.getString("Hora"), 5)}).newRow().add(new ComponentBuilder[]{label("INFORMACIÓN DEL PRESTADOR QUE RESPONDE", 30)}).newRow(0).add(new ComponentBuilder[]{labelP("Nombre", 7), textCell(xrs.getString("NEmpresa"), 30)}).add(new ComponentBuilder[]{emptyCell(1), TipoDocumento(xrs.getString("Id_TipoIdentificacion")), emptyCell(1)}).add(new ComponentBuilder[]{emptyCell(1), textCell(xrs.getString("Identificacion"), 11)}).newRow(0).add(new ComponentBuilder[]{labelP("Código", 7), textCell(xrs.getString("CodigoOrganismo"), 12)}).add(new ComponentBuilder[]{labelP("  Dirección prestador", 14), textCell(xrs.getString("Direccion"), 26)}).newRow(0).add(new ComponentBuilder[]{labelP("Teléfono", 7), labelP(xrs.getString("Telefono"), 12)}).add(new ComponentBuilder[]{labelP(" Departamento", 10), textCell(xrs.getString("Dpto"), 10)}).add(new ComponentBuilder[]{labelP(" Municipio", 7), textCell(xrs.getString("Mpio"), 13)}), DynamicReports.cmp.verticalGap(2), DynamicReports.cmp.horizontalList().add(new ComponentBuilder[]{emptyCell(25), label("DATOS DEL PACIENTE ", 20)}).newRow(0).add(new ComponentBuilder[]{textCell(xrsper.getString("NombreCompleto"), 59)}).newFlowRow(2).add(new ComponentBuilder[]{TipoDocumentoPac(xrsper.getString("Id_TipoIdentificacion"), xrsper.getString("NoDocumento"), xrsper.getString("FechaNac")), emptyCell(1)}).newRow(0).add(new ComponentBuilder[]{labelP(" Dirección de Residencia Habitual: ", 19), textCell(xrsper.getString("Direccion"), 25)}).add(new ComponentBuilder[]{labelP(" Teléfono", 5), textCell(xrsper.getString("Telefono"), 10)}).newRow().add(new ComponentBuilder[]{labelP(" Departamento", 10), textCell(xrsper.getString("Dpto"), 20)}).add(new ComponentBuilder[]{labelP(" Municipio", 8), textCell(xrsper.getString("Mpio"), 21)}).newRow().add(new ComponentBuilder[]{labelP(" ENTIDAD RESPONSABLE DEL PAGO", 20), textCell(xrsper.getString("NEmpresa"), 27)}).add(new ComponentBuilder[]{labelP(" CODIGO", 6), textCell(xrsper.getString("Codigo"), 6)}), DynamicReports.cmp.verticalGap(2), DynamicReports.cmp.horizontalList().add(new ComponentBuilder[]{emptyCell(20), label("DATOS DE LA PERSONA RESPONSABLE DEL PACIENTE ", 30)}).newRow(0).add(new ComponentBuilder[]{textCell(xrsper.getString("NPersonaResp"), 59)}).newFlowRow(2).add(new ComponentBuilder[]{TipoDocumentoResponsable(xrsper.getString("TipDoc"), xrsper.getString("NoDocumentoResp")), emptyCell(1)}).newRow(0).add(new ComponentBuilder[]{labelP(" Dirección de Residencia Habitual: ", 19), textCell(xrsper.getString("Direccion"), 25)}).add(new ComponentBuilder[]{labelP(" Teléfono", 5), textCell(xrsper.getString("TelefonoPResp"), 10)}).newRow().add(new ComponentBuilder[]{labelP(" Departamento", 10), textCell(xrsper.getString("Dpto"), 20)}).add(new ComponentBuilder[]{labelP(" Municipio", 8), textCell(xrsper.getString("Mpio"), 21)}).newRow(), DynamicReports.cmp.verticalGap(2), DynamicReports.cmp.horizontalList().add(new ComponentBuilder[]{emptyCell(20), label("PROFESIONAL QUE CONTRAREFIERE ", 45)}).newRow(0).add(new ComponentBuilder[]{labelP("Nombre", 7), textCell(xrsrem.getString("Profesional"), 35)}).add(new ComponentBuilder[]{labelP(" Teléfono", 7), textCell(xrsrem.getString("Telefono"), 10)}).newRow().add(new ComponentBuilder[]{labelP("Servicio que contrarrefiere", 24), textCell(xrsper.getString("TipoAtencion"), 15)}).add(new ComponentBuilder[]{labelP(" Teléfono celular: ", 10), textCell(xrsrem.getString("Movil"), 10)}).newRow().add(new ComponentBuilder[]{emptyCell(20), label("INFORMACIÓN CLÍNICA RELEVANTE ", 35)}).newRow(0).add(new ComponentBuilder[]{DynamicReports.cmp.text(xrsrem.getString("Detalle")).setStyle(styleCuadroBlanco2)}).newRow(20).add(new ComponentBuilder[]{emptyCell(25), DynamicReports.cmp.image(xrsrem.getString("DireccionF")).setFixedDimension(80, 50)}).newRow().add(new ComponentBuilder[]{emptyCell(20), label(xrsrem.getString("NProfesional"), 20)}).newRow().add(new ComponentBuilder[]{emptyCell(25), label(xrsrem.getString("Especialidad"), 20)}).newRow().add(new ComponentBuilder[]{emptyCell(27), label(xrsrem.getString("Tarjeta"), 10)}), DynamicReports.cmp.verticalGap(2)});
            try {
                report.toPdf(pdfExporter);
            } catch (DRException e) {
                Logger.getLogger(ReporteContraRemision.class.getName()).log(Level.SEVERE, (String) null, e);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReporteContraRemision.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return report;
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
        componentBuilderArr7[1] = label("Cédula de extranjería", 10, this.textStyle);
        HorizontalListBuilder list = horizontalListBuilderNewRow3.add(componentBuilderArr7).add(new ComponentBuilder[]{emptyCell(20), label("Fecha de Nacimiento", 12), textCell(xFechaNac, 10)}).newFlowRow(0).newRow(0);
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
        componentBuilderArr7[1] = label("Cédula de extranjería", 10, this.textStyle);
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
