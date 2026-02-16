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
import net.sf.dynamicreports.report.constant.PageType;
import net.sf.dynamicreports.report.constant.VerticalAlignment;
import net.sf.dynamicreports.report.exception.DRException;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: loaded from: GenomaP.jar:Facturacion/Furcen.class */
public class Furcen {
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
    private static Metodos xmt = new Metodos();
    private String xevento;
    private ResultSet xrs_per;
    private ConsultasMySQL xct = new ConsultasMySQL();
    private Connection connection = this.xct.establecerConexionBd();

    public Furcen(String xevento) {
        this.xevento = "";
        this.xevento = xevento;
    }

    public JasperReportBuilder build() {
        xmt.mEliminarArchivo(new File(xmt.getRutaRep() + "furcen.pdf"));
        JasperPdfExporterBuilder pdfExporter = DynamicReports.export.pdfExporter(xmt.getRutaRep() + "furcen.pdf");
        JasperReportBuilder report = DynamicReports.report();
        new Templates_1();
        try {
            Statement persona = this.connection.createStatement();
            Statement evento = this.connection.createStatement();
            this.connection.createStatement();
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
            DynamicReports.stl.style(this.bold14Style).setFontSize(10).bold().setHorizontalAlignment(HorizontalAlignment.CENTER).setBorder(DynamicReports.stl.pen1Point());
            DynamicReports.stl.style(this.bold14Style).setFontSize(8).setHorizontalAlignment(HorizontalAlignment.JUSTIFIED).setBorder(DynamicReports.stl.pen1Point());
            this.styleCamposLabel = DynamicReports.stl.style(this.bold14Style).setFontSize(10).bold().setHorizontalAlignment(HorizontalAlignment.LEFT).setBorder(DynamicReports.stl.pen1Point());
            this.xrs_per = persona.executeQuery("SELECT      `g_persona`.`Id_TipoIdentificacion`  AS IdTDocPers    , `g_persona`.`NoDocumento`      , `g_persona`.`Nombre1`      , `g_persona`.`Nombre2`      , `g_persona`.`Apellido1`      , `g_persona`.`Apellido2`  FROM  `a_eventoecat_paciente`      INNER JOIN  `g_persona`   ON (`a_eventoecat_paciente`.`Id_Persona` = `g_persona`.`Id`)  WHERE (`a_eventoecat_paciente`.`Id_Eventoecat` ='" + this.xevento + "') GROUP BY a_eventoecat_paciente.`Id_Persona` ;");
            this.xrs_per.first();
            ResultSet xrs = evento.executeQuery("SELECT `a_tipoevento`.`idReporte` AS Evento,`a_eventoecat`.`Direccion` , DATE_FORMAT(`a_eventoecat`.`Fechaeventoecat`,'%d%m%Y') AS Fechaeventoecat , DATE_FORMAT(`a_eventoecat`.`Horaeventoecat`,'%H%i')AS Horaeventoecat  , UPPER(`g_departamento`.`Nbre`) AS Dpto ,`g_departamento`.`Id` AS CodDpto , `g_municipio`.`Nbre` AS Mpio , SUBSTRING(`g_municipio`.`Id`,3,5) AS CodMpio,`a_eventoecat`.`Zona` , `a_eventoecat`.`Descripcion`, `g_ips`.`Nbre` AS RSocial , `g_ips`.`CodigoOrganismo`  , CONCAT(`g_ips`.`Identificacion`,`g_ips`.`DigitoVerificacion`) AS Nit FROM g_ips,`a_eventoecat`   INNER JOIN `a_tipoevento`  ON (`a_eventoecat`.`Id_tipoevento` = `a_tipoevento`.`Id`)   INNER JOIN `g_municipio`   ON (`a_eventoecat`.`Id_Munucipio` = `g_municipio`.`Id`)  INNER JOIN `g_departamento`  ON (`g_municipio`.`Id_Dpto` = `g_departamento`.`Id`)  WHERE (`a_eventoecat`.`Id` ='" + this.xevento + "')");
            xrs.first();
            ResultSet xrsaccidente = accidente.executeQuery("SELECT  `a_estadoasegveh`.`Id` AS `EstadoSeg`  , `a_marcavehiculo`.`Nbre` AS `marcaveh`  , `a_accidentetransito`.`Placa1Veh`  , `a_tipovehiculo`.`Id` AS `tipoveh`  , `a_aseguradora`.`Codigo` AS `aseguradora`  , `a_accidentetransito`.`NoPoliza`  , DATE_FORMAT(`a_accidentetransito`.`FechaInicPol`,'%d%m%Y')AS FechaInicPol , DATE_FORMAT(`a_accidentetransito`.`FechaFinPol`,'%d%m%Y') AS FechaFinPol  , `a_accidentetransito`.`IntAutoridad` , `a_accidentetransito`.`Placa2Veh`  , `g_tipoidentificacion_Prop2`.`Nbre` AS `tdocprop2` , `a_accidentetransito`.`NoDocProp2` , `a_accidentetransito`.`Placa3Veh`  , `g_tipoidentificacion_Prop3`.`Nbre` AS `tdocprop3`  , `a_accidentetransito`.`NoDocProp3` , `g_tipoidentificacion_Prop`.`Id` AS `tdocPROP`  , `a_accidentetransito`.`NodocumProp` , UPPER(`a_accidentetransito`.`Apellido1Prop`) AS Apellido1Prop  , UPPER(`a_accidentetransito`.`Apellido2Prop`) AS Apellido2Prop  , UPPER(`a_accidentetransito`.`Nombre1Prop`) AS Nombre1Prop  , UPPER(`a_accidentetransito`.`Nombre2Prop`) AS Nombre2Prop  , `a_accidentetransito`.`DireccionProp` , `a_accidentetransito`.`TelefonoProp`  , UPPER(`g_departamento`.`Nbre`) AS `dptoPROP`,`g_departamento`.`Id` AS `CoddptoPROP` , `g_municipio`.`Nbre` AS `mpioPROP`,SUBSTRING(`g_municipio`.`Id`,3,5)  AS `CodmpioPROP`  , UPPER(`a_accidentetransito`.`Apellido1Cond`) AS Apellido1Cond , UPPER(`a_accidentetransito`.`Apellido2Cond`) AS Apellido2Cond , UPPER(`a_accidentetransito`.`Nombre1Cond`) AS Nombre1Cond , UPPER(`a_accidentetransito`.`Nombre2Cond`) AS Nombre2Cond  , `g_tipoidentificacion_Cond`.`Nbre` AS `tdocCond`  , `a_accidentetransito`.`NodocumCond`  , `a_accidentetransito`.`DireccionCond` , UPPER(`g_departamento_Cond`.`Nbre`) AS `dptoCond` , `g_municipio_Cond`.`Nbre` AS `mpioCond` , `a_accidentetransito`.`TelefonoCond` FROM  `a_accidentetransito`  INNER JOIN  `a_estadoasegveh`   ON (`a_accidentetransito`.`Id_estadoasegveh` = `a_estadoasegveh`.`Id`)  INNER JOIN  `a_marcavehiculo`  ON (`a_accidentetransito`.`Id_marcavehiculo` = `a_marcavehiculo`.`Id`) INNER JOIN  `a_tipovehiculo`  ON (`a_accidentetransito`.`Id_tipovehiculo` = `a_tipovehiculo`.`Id`) INNER JOIN  `a_aseguradora`   ON (`a_accidentetransito`.`Id_aseguradora` = `a_aseguradora`.`Id`) LEFT JOIN  `g_tipoidentificacion` AS `g_tipoidentificacion_Prop2` ON (`a_accidentetransito`.`TipodocProp2` = `g_tipoidentificacion_Prop2`.`Id`)  INNER JOIN  `g_tipoidentificacion` AS `g_tipoidentificacion_Prop`  ON (`a_accidentetransito`.`Id_tipodocProp` = `g_tipoidentificacion_Prop`.`Id`)  INNER JOIN  `g_departamento`  ON (`a_accidentetransito`.`DepartProp` = `g_departamento`.`Id`)  INNER JOIN  `g_municipio`  ON (`a_accidentetransito`.`MunicProp` = `g_municipio`.`Id`)  INNER JOIN  `g_tipoidentificacion` AS `g_tipoidentificacion_Cond`  ON (`a_accidentetransito`.`tipodocCond` = `g_tipoidentificacion_Cond`.`Id`)  INNER JOIN  `g_departamento` AS `g_departamento_Cond`  ON (`a_accidentetransito`.`DepartCond` = `g_departamento_Cond`.`Id`)  INNER JOIN  `g_municipio` AS `g_municipio_Cond`  ON (`a_accidentetransito`.`MunicCond` = `g_municipio_Cond`.`Id`)  LEFT JOIN  `g_tipoidentificacion` AS `g_tipoidentificacion_Prop3`  ON (`a_accidentetransito`.`TipodocProp3` = `g_tipoidentificacion_Prop3`.`Id`)  WHERE (`a_accidentetransito`.`Id_eventoecat` ='" + this.xevento + "')");
            xrsaccidente.first();
            ComponentBuilder componentBuilderAdd = DynamicReports.cmp.horizontalList().add(new ComponentBuilder[]{label("Fecha Radicación", 8), emptyCell(1), textCell("DDMMAAAA", 8), emptyCell(10)}).add(new ComponentBuilder[]{label("No. Radicado", 6), DynamicReports.cmp.text(" \n").setStyle(styleEncabezados)}).newRow(3).add(new ComponentBuilder[]{label("Fecha Expedición del Certificado", 15), emptyCell(1), textCell("DDMMAAAA", 8), emptyCell(20)}).add(new ComponentBuilder[]{label("HOJA No___ DE___", 10)});
            ComponentBuilder componentBuilderNewRow = DynamicReports.cmp.horizontalList().newRow(4).add(new ComponentBuilder[]{label("Fecha Evento/Accidente", 12), emptyCell(1), textCell(xrs.getString("Fechaeventoecat"), 8), emptyCell(8)}).add(new ComponentBuilder[]{label("Hora", 6), emptyCell(1), textCell(xrs.getString("Horaeventoecat"), 4)}).newRow(2).add(new ComponentBuilder[]{TipoEventoN(xrs.getString("Evento"))}).newRow(2).add(new ComponentBuilder[]{TipoEventoT(xrs.getString("Evento"))}).newRow(1).add(new ComponentBuilder[]{label("Otros", 3), emptyCell(1), textCell("", 1), emptyCell(1)}).add(new ComponentBuilder[]{label("Cual?", 3), emptyCell(1), textCell("", 19)}).newRow(1).add(new ComponentBuilder[]{label("Dirección de la ocurrencia", 12), emptyCell(1), textCell(xrs.getString("Direccion"), 33)}).newRow(2).add(new ComponentBuilder[]{label("Departamento", 8), emptyCell(1), textCell(xrs.getString("Dpto"), 16), emptyCell(4)}).add(new ComponentBuilder[]{label("Cod.", 4), emptyCell(1), textCell(xrs.getString("CodDpto"), 2)}).newRow(2).add(new ComponentBuilder[]{label("Municipio", 8), emptyCell(1), textCell(xrs.getString("Mpio"), 18), emptyCell(2)}).add(new ComponentBuilder[]{label("Cod.", 4), emptyCell(1), textCell(xrs.getString("CodMpio"), 3)}).add(new ComponentBuilder[]{emptyCell(3), Zona(xrs.getString("Zona"))}).newRow(3);
            ComponentBuilder componentBuilderNewRow2 = DynamicReports.cmp.horizontalList().add(new ComponentBuilder[]{labelP("", 25), emptyCell(9)}).add(new ComponentBuilder[]{labelP("", 25)}).newRow(1).add(new ComponentBuilder[]{emptyCell(10), label("1er Apellido", 11)}).add(new ComponentBuilder[]{emptyCell(23), label("2do Apellido", 11)}).newRow(1).add(new ComponentBuilder[]{labelP("", 25), emptyCell(9)}).add(new ComponentBuilder[]{labelP("", 25)}).newRow(1).add(new ComponentBuilder[]{emptyCell(10), label("1er Nombre", 11)}).add(new ComponentBuilder[]{emptyCell(23), label("2do Nombre", 11)}).newRow(1).add(new ComponentBuilder[]{label("Tipo de Documento        CC-CE", 15), emptyCell(18)}).add(new ComponentBuilder[]{label("No. Documento", 8), emptyCell(2), textCell("", 16)}).newRow(1).add(new ComponentBuilder[]{label("Firma   ______________________________________________________", 30)}).newRow(2).add(new ComponentBuilder[]{label("Cargo     Comités Locales y/o Regionales de Emergencias", 23), emptyCell(2), textCell("", 1)}).newRow(2).add(new ComponentBuilder[]{label("Alcalde de la Localidad", 13), emptyCell(1), textCell("", 1), emptyCell(1), label("Procuraduria General de la Nación", 14), emptyCell(1), textCell("", 1), emptyCell(2), label("Direccion Gral para los derechos Humanos Min Interior", 23), emptyCell(0), textCell("", 1)}).newRow(2).add(new ComponentBuilder[]{label("Personeria Municipal o Distrital", 13), emptyCell(1), textCell("", 1), emptyCell(1), label("Defensoria del Pueblo", 14), emptyCell(1), textCell("", 1), emptyCell(2), label("Autoridades Correspondientes de la Policia Nal o Ejercito", 23), emptyCell(0), textCell("", 1)}).newRow(2);
            ComponentBuilder componentBuilderNewRow3 = DynamicReports.cmp.horizontalList().add(new ComponentBuilder[]{label("Tipo de documento permitido  CC - CE - PA - TI - RC - AS - MS", 30)}).newRow(3).add(new ComponentBuilder[]{emptyCell(1), labelP("TipoDoc", 6), labelP("     No. Documento", 16), labelP("Primer Nombre", 9), labelP("Segundo Nombre", 9), labelP("Primer Apellido", 9), labelP("Segundo Apellido", 9)}).newRow(0);
            try {
                this.xrs_per.beforeFirst();
                if (this.xrs_per.next()) {
                    this.xrs_per.beforeFirst();
                    int n = 1;
                    while (this.xrs_per.next()) {
                        componentBuilderNewRow3.add(new ComponentBuilder[]{label(n + " ", 1), labelP(this.xrs_per.getString("IdTDocPers"), 6), labelP(this.xrs_per.getString("NoDocumento"), 16), labelP(this.xrs_per.getString("g_persona.Nombre1"), 9), labelP(this.xrs_per.getString("g_persona.Nombre2"), 9), labelP(this.xrs_per.getString("g_persona.Apellido1"), 9), labelP(this.xrs_per.getString("g_persona.Apellido2"), 9)}).newRow(0);
                        n++;
                    }
                }
                this.xrs_per.close();
            } catch (SQLException ex) {
                Logger.getLogger(Furtran.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
            report.setTemplate(Templates_1.reportTemplate).setPageFormat(PageType.LEGAL).setTextStyle(this.textStyle).title(new ComponentBuilder[]{DynamicReports.cmp.image(xmt.getRutaRep() + "Encabezado_Furcen.png").setFixedDimension(592, 60), componentBuilderAdd, DynamicReports.cmp.verticalGap(2), DynamicReports.cmp.text("I. IDENTIFICACION DEL EVENTO CATASTROFICO").setStyle(styleEncabezados), DynamicReports.cmp.verticalGap(2), componentBuilderNewRow, DynamicReports.cmp.verticalGap(2), DynamicReports.cmp.text("II. IDENTIFICACION DE LAS VICTIMAS DEL EVENTO CATASTRÓFICO").setStyle(styleEncabezados), DynamicReports.cmp.verticalGap(2), componentBuilderNewRow3, DynamicReports.cmp.verticalGap(12), DynamicReports.cmp.text("III. APROBACION DE CERTIFICACION").setStyle(styleEncabezados), DynamicReports.cmp.verticalGap(2), componentBuilderNewRow2, DynamicReports.cmp.verticalGap(2)});
            try {
                report.toPdf(pdfExporter);
            } catch (DRException e) {
                Logger.getLogger(Furcen.class.getName()).log(Level.SEVERE, (String) null, e);
            }
        } catch (SQLException ex2) {
            Logger.getLogger(Furcen.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex2);
        }
        return report;
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
