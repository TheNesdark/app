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
import net.sf.dynamicreports.report.constant.ComponentPositionType;
import net.sf.dynamicreports.report.constant.HorizontalAlignment;
import net.sf.dynamicreports.report.constant.PageOrientation;
import net.sf.dynamicreports.report.constant.VerticalAlignment;
import net.sf.dynamicreports.report.exception.DRException;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: loaded from: GenomaP.jar:Facturacion/Furtran.class */
public class Furtran {
    private static final int cellWidth = 10;
    private static final int cellHeight = 10;
    private StyleBuilder textStyle;
    private StyleBuilder textStyle6topleft;
    private StyleBuilder textStyle6bot;
    private StyleBuilder textStyle6;
    private StyleBuilder centeredStyle;
    private StyleBuilder labelStyle;
    private StyleBuilder cellStyle;
    private StyleBuilder cellStyle2;
    private StyleBuilder rootStyle;
    private StyleBuilder boldStyle;
    private StyleBuilder fount_roja;
    private StyleBuilder boldCenteredStyle;
    private StyleBuilder bold10CenteredStyle;
    static ResultSetMetaData rsmetadatos;
    private StyleBuilder bold14Style;
    private StyleBuilder styleCamposLabel;
    private ResultSet xrs;
    private String xevento;
    private String xpersona;
    private String xFurtran;
    private int xEsGlosa;
    private Metodos xmt = new Metodos();
    private ConsultasMySQL xct = new ConsultasMySQL();
    private Connection connection = this.xct.establecerConexionBd();

    public Furtran(String xid, int xEsGlosa) {
        this.xevento = "";
        this.xpersona = "";
        this.xevento = this.xevento;
        this.xpersona = this.xpersona;
        this.xFurtran = xid;
        this.xEsGlosa = xEsGlosa;
    }

    public JasperReportBuilder build() {
        this.xmt.mEliminarArchivo(new File(this.xmt.getRutaRep() + "Furtran.pdf"));
        JasperPdfExporterBuilder pdfExporter = DynamicReports.export.pdfExporter(this.xmt.getRutaRep() + "Furtran.pdf");
        JasperReportBuilder report = DynamicReports.report();
        new Templates_1();
        try {
            Statement futran = this.connection.createStatement();
            this.rootStyle = DynamicReports.stl.style().setPadding(2);
            this.boldStyle = DynamicReports.stl.style(this.rootStyle).bold();
            this.boldCenteredStyle = DynamicReports.stl.style(this.boldStyle).setAlignment(HorizontalAlignment.CENTER, VerticalAlignment.TOP);
            this.fount_roja = DynamicReports.stl.style(this.boldStyle).setAlignment(HorizontalAlignment.CENTER, VerticalAlignment.TOP).setFontSize(7).setForegroundColor(Color.RED);
            this.bold10CenteredStyle = DynamicReports.stl.style(this.boldCenteredStyle).setFontSize(8);
            this.textStyle = DynamicReports.stl.style().setFontSize(8).setPadding(2);
            this.textStyle6topleft = DynamicReports.stl.style().setFontSize(6).setPadding(2).setAlignment(HorizontalAlignment.LEFT, VerticalAlignment.TOP);
            this.textStyle6bot = DynamicReports.stl.style().setFontSize(6).setPadding(2).setAlignment(HorizontalAlignment.JUSTIFIED, VerticalAlignment.BOTTOM);
            this.textStyle6 = DynamicReports.stl.style().setFontSize(6).setPadding(2).setAlignment(HorizontalAlignment.JUSTIFIED, VerticalAlignment.MIDDLE);
            this.centeredStyle = DynamicReports.stl.style(this.textStyle).setAlignment(HorizontalAlignment.CENTER, VerticalAlignment.MIDDLE);
            this.labelStyle = DynamicReports.stl.style(this.textStyle).setHorizontalAlignment(HorizontalAlignment.LEFT).bold();
            this.cellStyle = DynamicReports.stl.style(this.textStyle).setBorder(DynamicReports.stl.pen1Point()).setAlignment(HorizontalAlignment.CENTER, VerticalAlignment.MIDDLE);
            this.cellStyle2 = DynamicReports.stl.style(this.textStyle).setBorder(DynamicReports.stl.pen1Point()).setAlignment(HorizontalAlignment.CENTER, VerticalAlignment.JUSTIFIED);
            StyleBuilder styleEncabezados = DynamicReports.stl.style(this.bold14Style).setFontSize(10).bold().setHorizontalAlignment(HorizontalAlignment.CENTER).setBackgroundColor(new Color(204, 255, 204)).setBorder(DynamicReports.stl.pen1Point());
            StyleBuilder styleEncabezadosAmarillo = DynamicReports.stl.style(this.bold14Style).setFontSize(10).bold().setHorizontalAlignment(HorizontalAlignment.CENTER).setBackgroundColor(new Color(255, 255, 153)).setBorder(DynamicReports.stl.pen1Point());
            DynamicReports.stl.style(this.bold14Style).setFontSize(10).bold().setHorizontalAlignment(HorizontalAlignment.CENTER).setBorder(DynamicReports.stl.pen1Point());
            DynamicReports.stl.style(this.bold14Style).setFontSize(8).setHorizontalAlignment(HorizontalAlignment.JUSTIFIED).setBorder(DynamicReports.stl.pen1Point());
            this.styleCamposLabel = DynamicReports.stl.style(this.bold14Style).setFontSize(10).bold().setHorizontalAlignment(HorizontalAlignment.LEFT).setBorder(DynamicReports.stl.pen1Point());
            StyleBuilder stylePage = DynamicReports.stl.style(this.bold14Style).setLeftBorder(DynamicReports.stl.pen1Point()).setRightBorder(DynamicReports.stl.pen1Point()).setBorder(DynamicReports.stl.pen1Point());
            String xsql = "SELECT `a_furtran`.`Id` \n , DATE_FORMAT(`a_furtran`.`FechaR`,'%d%m%Y') AS FechaEntrega \n , `a_furtran`.`NEmpresaT`, CONCAT(g_ips.`Identificacion`, g_ips.`DigitoVerificacion`) DocumentoIps, g_ips.`Id_TipoIdentificacion`, g_ips.`UrlFG`, a_tipoevento.`Nbre` TipoEvento \n , `a_furtran`.`CodHabil` \n , `a_furtran`.`Apellido1` \n , `a_furtran`.`Apellido2` \n , `a_furtran`.`Nombre1` \n , `a_furtran`.`Nombre2` \n , `a_furtran`.`TDocumento` \n , `a_furtran`.`NumDocumento` \n , `a_furtran`.`TServicio` \n , `a_furtran`.`CualServ` \n , `a_furtran`.`Placa` \n , `a_furtran`.`Direccion` \n , `a_furtran`.`Telefono` \n , SUBSTRING(`a_furtran`.`IdMunicipio`,3  ,3) AS IdMunicipioFurtran \n , `g_municipio`.`Nbre` AS MunicpioF \n , `g_departamento`.`Id` AS IdDptoF \n , UCASE(`g_departamento`.`Nbre`) AS DptoF \n , `g_persona`.`Id_TipoIdentificacion` AS IdTDocPers \n , `g_persona`.`NoDocumento` \n , `g_persona`.`Nombre1` \n , `g_persona`.`Nombre2` \n , `g_persona`.`Apellido1` \n , `g_persona`.`Apellido2` \n , `a_furtran`.`DireccionRec` \n , SUBSTRING(`a_furtran`.`IdMunicipioRec`,3,3) AS IdMunicipioRec \n , `g_municipio_1`.`Nbre`  \n , `g_departamento_1`.`Id` \n , UCASE(`g_departamento_1`.`Nbre`) Dpto3 \n , `a_furtran`.`Zona` \n , `a_furtran`.`FechaR` \n , `g_ips`.`Nbre` AS IPS \n ,  CONCAT(g_ips.Identificacion,'-',g_ips.DigitoVerificacion) AS Nit  \n , `g_ips`.`CodigoOrganismo` \n , `g_ips`.`Direccion` \n , `g_ips`.`Telefono` \n , SUBSTRING(`g_ips`.`Id_Municipio`,3,3) AS Id_MunicipioIPS \n , `g_municipio_2`.`Nbre` \n , `g_municipio_2`.`Id_Dpto` \n , UCASE(`g_departamento_2`.`Nbre`)  DptoA, DATE_FORMAT(a_furtran.FechaR,'%H%i') AS HoraE \n , g_empresa1.`Nbre` EmpresaR\n , g_empresa1.`CHabilitacion`\n , IF(g_empresa1.`Dig_Verificacion`='', g_empresa1.`Nbre`, CONCAT(g_empresa1.`No_identificacion`, '-', g_empresa1.`Dig_Verificacion`)) NitEmpresaR\n , g_empresa1.`Direccion` DireccionR, g_empresa1.`Tel_Numero` TelefonoR\n , UCASE(g_departamento2.Nbre) DepartamentoR\n , g_departamento2.`Id` CodDept2\n , g_municipio2.`Nbre` NMunicipioR\n , MID(g_municipio2.`Id`,3,3) CodMunicipioR\n , a_furtran.`Nombre_Funcionario`\n , a_furtran.Documento_Funcionario \n , IFNULL(`f_factura_glosa`.`NRadicacionG`, '') AS NRadicacionG\nFROM  \n `a_furtran_persona` \n INNER JOIN `a_furtran`  \n     ON (`a_furtran_persona`.`IdFurtran` = `a_furtran`.`Id`) \n INNER JOIN `g_municipio`  \n     ON (`a_furtran`.`IdMunicipio` = `g_municipio`.`Id`) \n INNER JOIN `g_municipio` AS `g_municipio_1` \n     ON (`a_furtran`.`IdMunicipioRec` = `g_municipio_1`.`Id`) \n INNER JOIN `a_eventoecat_paciente`  \n     ON (`a_furtran_persona`.`IdPersonaEvento` = `a_eventoecat_paciente`.`Id`) \n INNER JOIN `f_liquidacion`  \n     ON (`f_liquidacion`.`Id_Ingreso` = `a_eventoecat_paciente`.`Id_Ingreso`)     \n LEFT JOIN `f_factura_glosa`  \n     ON (`f_factura_glosa`.`Id_Liquidacion` = `f_liquidacion`.`Id`)      \n INNER JOIN `a_eventoecat`\n     ON (`a_eventoecat`.`Id` = `a_eventoecat_paciente`.`Id_Eventoecat`) \n INNER JOIN `a_tipoevento`\n     ON (`a_eventoecat`.`Id_tipoevento` = a_tipoevento.`Id`)    \n INNER JOIN `g_persona`  \n     ON (`a_eventoecat_paciente`.`Id_Persona` = `g_persona`.`Id`) \n INNER JOIN `g_departamento`  \n     ON (`g_municipio`.`Id_Dpto` = `g_departamento`.`Id`) \n INNER JOIN `g_departamento` AS `g_departamento_1` \n     ON (`g_municipio_1`.`Id_Dpto` = `g_departamento_1`.`Id`) \n INNER JOIN g_empresa AS `g_empresa1` \n     ON (`g_empresa1`.`Id` = `a_furtran`.`IdTerceroRecibe`)     \n INNER JOIN g_municipio AS `g_municipio2` \n     ON (`g_municipio2`.`Id` = `g_empresa1`.`Id_Municipio`)     \n INNER JOIN g_departamento AS `g_departamento2` \n     ON (`g_municipio2`.`Id_Dpto` = `g_departamento2`.`Id`)                    \n , `g_ips` \n INNER JOIN `g_municipio` AS `g_municipio_2`  ON (`g_ips`.`Id_Municipio` = `g_municipio_2`.`Id`) \n INNER JOIN `g_departamento` AS `g_departamento_2` ON (`g_municipio_2`.`Id_Dpto` = `g_departamento_2`.`Id`) \n WHERE (`a_furtran`.`Id` ='" + this.xFurtran + "') ;";
            this.xrs = futran.executeQuery(xsql);
            this.xrs.first();
            ComponentBuilder componentBuilderAdd = DynamicReports.cmp.horizontalList().add(new ComponentBuilder[]{label("Fecha de Entrega", 8), emptyCell(1), textCell("        ", 8), emptyCell(15)}).add(new ComponentBuilder[]{label("No. Radicado", 6), DynamicReports.cmp.text("\n\n").setStyle(styleEncabezados)}).newRow(3).add(new ComponentBuilder[]{label("No. Radicado Anterior (Respuesta a glosa, marcar x en RG)", 15), Radicado(this.xrs.getString("NRadicacionG"))});
            ComponentBuilder componentBuilderNewRow = DynamicReports.cmp.horizontalList().add(new ComponentBuilder[]{emptyCell(3), label(" Nombre Empresa de Transporte Especial Reclamante", 20).setStyle(this.textStyle), emptyCell(1), labelP(this.xrs.getString("NEmpresaT"), 35)}).newRow(6).add(new ComponentBuilder[]{emptyCell(3), label("Código de habilitación Empresa de Transporte Especial", 21).setStyle(this.textStyle), emptyCell(2), textCell(this.xrs.getString("CodHabil"), 12)}).newRow(6).add(new ComponentBuilder[]{labelP(this.xrs.getString("a_furtran.Apellido1"), 27), emptyCell(5), labelP(this.xrs.getString("a_furtran.Apellido2"), 27)}).newRow(2).add(new ComponentBuilder[]{emptyCell(10), label("1er Apellido", 6), emptyCell(27), label("2do Apellido", 6)}).newRow(3).add(new ComponentBuilder[]{labelP(this.xrs.getString("a_furtran.Nombre1"), 27), emptyCell(5), labelP(this.xrs.getString("a_furtran.Nombre2"), 27)}).newRow(2).add(new ComponentBuilder[]{emptyCell(10), label("1er Nombre", 6), emptyCell(27), label("2do Nombre", 6)}).newRow(3).add(new ComponentBuilder[]{TipoDocumento(this.xrs.getString("Id_TipoIdentificacion")), emptyCell(2), label("Numero de documento", 10), emptyCell(1), textCell(this.xrs.getString("DocumentoIps"), 16)}).newRow(3).add(new ComponentBuilder[]{TipoServicio(this.xrs.getString("a_furtran.TServicio"), this.xrs.getString("a_furtran.CualServ"))}).newRow(3).add(new ComponentBuilder[]{label("En vehículo con placa No.", 12), emptyCell(4), textCell(this.xrs.getString("a_furtran.Placa"), 6)}).newRow(3).add(new ComponentBuilder[]{label("Dirección de la empresa o persona que realiza el transporte", 22, this.textStyle), emptyCell(2), labelP(this.xrs.getString("a_furtran.Direccion"), 35)}).newRow(4).add(new ComponentBuilder[]{label("Teléfono ó Celular", 13), emptyCell(4), textCell(this.xrs.getString("a_furtran.Telefono"), 10)}).newRow(3).add(new ComponentBuilder[]{label("Departamento", 8), emptyCell(4), textCell(this.xrs.getString("DptoF"), 20), emptyCell(2), label("Cod.", 4), textCell(this.xrs.getString("IdDptoF"), 2)}).newRow(3).add(new ComponentBuilder[]{label("Municipio", 7), emptyCell(4), textCell(this.xrs.getString("MunicpioF"), 25), emptyCell(2), label("Cod.", 4), textCell(this.xrs.getString("IdMunicipioFurtran"), 3)}).newRow(3);
            ComponentBuilder componentBuilderNewRow2 = DynamicReports.cmp.horizontalList().newRow(3).add(new ComponentBuilder[]{label("Dirección", 15), emptyCell(4), textCell(this.xrs.getString("a_furtran.DireccionRec"), 40)}).newRow(3).add(new ComponentBuilder[]{label("Departamento", 8), emptyCell(4), textCell(this.xrs.getString("Dpto3"), 20), emptyCell(2), label("Cod.", 4), textCell(this.xrs.getString("g_departamento_1.Id"), 2), emptyCell(7), Zona(this.xrs.getString("a_furtran.Zona"))}).newRow(3).add(new ComponentBuilder[]{label("Municipio", 7), emptyCell(4), textCell(this.xrs.getString("g_municipio_1.Nbre"), 25), emptyCell(2), label("Cod.", 4), textCell(this.xrs.getString("IdMunicipioRec"), 3)}).newRow(3);
            ComponentBuilder componentBuilderAdd2 = DynamicReports.cmp.horizontalList().add(new ComponentBuilder[]{label("La Institución Prestadora de Servicios de Salud certifica que la entidad de Transporte Especial o Persona Natural efectuó el traslado de la víctima a esta IPS", 57, this.textStyle)}).newRow(3).add(new ComponentBuilder[]{emptyCell(3), label("El día", 6), emptyCell(2), textCell(this.xrs.getString("FechaEntrega"), 8), emptyCell(4), label("a las", 4), textCell(this.xrs.getString("HoraE"), 4)}).newRow(3).add(new ComponentBuilder[]{emptyCell(3), label("Nombre IPS que atendió la víctima", 15), emptyCell(8), textCell(this.xrs.getString("EmpresaR"), 33)}).newRow(3).add(new ComponentBuilder[]{emptyCell(3), label("Nit", 5), emptyCell(5), textCell(this.xrs.getString("NitEmpresaR"), 16), emptyCell(7), label("Código Habilitación ", 11), textCell(this.xrs.getString("CHabilitacion"), 12)}).newRow(3).add(new ComponentBuilder[]{emptyCell(3), label("Dirección", 8), emptyCell(2), textCell(this.xrs.getString("DireccionR"), 46)}).newRow(3).add(new ComponentBuilder[]{emptyCell(3), label("Departamento", 8), emptyCell(2), textCell(this.xrs.getString("DepartamentoR"), 18), emptyCell(2), label("Cod.", 4), textCell(this.xrs.getString("CodDept2"), 2), emptyCell(3), label("Teléfono", 5), emptyCell(2), textCell(this.xrs.getString("TelefonoR"), 10)}).newRow(3).add(new ComponentBuilder[]{emptyCell(3), label("Municipio", 7), emptyCell(3), textCell(this.xrs.getString("NMunicipioR"), 23), emptyCell(2), label("Cod.", 4), textCell(this.xrs.getString("CodMunicipioR"), 3)}).newRow(3).add(new ComponentBuilder[]{emptyCell(3), label("Como representante legal o Gerente de la Institución Prestadora de Serviicos de Salud, declaró la gavedad de juramento que la información contenidad en este formulario es cierta y podrá se verificada por la Compañía de Seguros, por la Dirección Genereal de Financiamiento, por el Administrador Fiduciario del Fondo de Solidaridad y Garantía FOSYGA, por la Superintendencia Nacional de Salud o la Contraloria Generalde la República de no ser así, acepto todas las consecuencias legales que produzca esta situación.Adicionalmente, manifiesto que la reclamación no ha sido presentada con anterioridad ni se ha recibido pago alguno por las sumas reclamadas.", 56, this.textStyle6)}).newRow(10).add(new ComponentBuilder[]{emptyCell(3), label(this.xrs.getString("Nombre_Funcionario"), 26, this.textStyle6), emptyCell(3)}).newRow(3).add(new ComponentBuilder[]{emptyCell(3), DynamicReports.cmp.horizontalList().setBaseStyle(DynamicReports.stl.style().setTopBorder(DynamicReports.stl.pen1Point()).setLeftPadding(220)), emptyCell(5)}).add(new ComponentBuilder[]{DynamicReports.cmp.horizontalList().setBaseStyle(DynamicReports.stl.style().setTopBorder(DynamicReports.stl.pen1Point()).setLeftPadding(220))}).newRow(0).add(new ComponentBuilder[]{emptyCell(3), label("NOMBRE DEL REPRESENTANTE LEGAL O PERSONA RESPONSIBLE\nPARA TRAMITE DE ADMISIONES DE LA IPS", 26, this.textStyle6), emptyCell(3), label("FIRMA DEL REPRESENTANTE LEGAL O PERSONA RESPONSABLE\nPARA TRAMITE DE ADMISIONES DE LA IPS", 20, this.textStyle6)}).newRow(10).add(new ComponentBuilder[]{emptyCell(3), label(this.xrs.getString("Documento_Funcionario"), 30, this.textStyle6), emptyCell(3)}).newRow(3).add(new ComponentBuilder[]{emptyCell(3), DynamicReports.cmp.horizontalList().setBaseStyle(DynamicReports.stl.style().setTopBorder(DynamicReports.stl.pen1Point()).setLeftPadding(220))}).newRow(0).add(new ComponentBuilder[]{emptyCell(3), label("TIPO Y NUMERO DE DOCUMENTO DEL REPRESENTANTE LEGAL O PERSONA RESPONSIBLE\nPARA TRAMITE DE ADMISIONES DE LA IPS", 30, this.textStyle6)}).newRow(5).add(new ComponentBuilder[]{emptyCell(3), DynamicReports.cmp.image(this.xmt.mRutaSoporte("SUBREPORTFIRMA_DIR") + this.xrs.getString("UrlFG")).setPositionType(ComponentPositionType.FLOAT).setMinDimension(70, 20)}).newRow(3).add(new ComponentBuilder[]{emptyCell(3), DynamicReports.cmp.horizontalList().setBaseStyle(DynamicReports.stl.style().setTopBorder(DynamicReports.stl.pen1Point()).setLeftPadding(220))}).newRow(0).add(new ComponentBuilder[]{emptyCell(3), label("FIRMA DEL REPRESENTANTE LEGAL DE LA EMPRESA TRANSPORTADORA\nO DE LA PERSONA NATURAL QUE REALIZO EL TRANSPORTE", 30, this.textStyle6)});
            ComponentBuilder componentBuilderNewRow3 = DynamicReports.cmp.horizontalList().add(new ComponentBuilder[]{TipoDocumentoP(this.xrs.getString("IdTDocPers"))}).newRow(3).add(new ComponentBuilder[]{labelP("TipoDoc", 7), labelP("     No. Documento", 16), labelP("Primer Nombre", 9), labelP("Segundo Nombre", 9), labelP("Primer Apellido", 9), labelP("Segundo Apellido", 9)}).newRow(3);
            try {
                this.xrs.beforeFirst();
                if (this.xrs.next()) {
                    this.xrs.beforeFirst();
                    int n = 1;
                    while (this.xrs.next()) {
                        componentBuilderNewRow3.add(new ComponentBuilder[]{label(n + " ", 1), labelP(this.xrs.getString("IdTDocPers"), 6), textCell(this.xrs.getString("NoDocumento"), 16), labelP(this.xrs.getString("g_persona.Nombre1"), 9), labelP(this.xrs.getString("g_persona.Nombre2"), 9), labelP(this.xrs.getString("g_persona.Apellido1"), 9), labelP(this.xrs.getString("g_persona.Apellido2"), 9)}).newRow(0);
                        n++;
                    }
                }
                this.xrs.close();
            } catch (SQLException ex) {
                Logger.getLogger(Furtran.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
            componentBuilderNewRow3.add(new ComponentBuilder[]{TipoEvento("Accidente de Tránsito")}).newRow(3);
            report.setTemplate(Templates_1.reportTemplate).setPageFormat(612, 1030, PageOrientation.PORTRAIT).setBackgroundStyle(stylePage).setTextStyle(this.textStyle).title(new ComponentBuilder[]{DynamicReports.cmp.verticalGap(1), DynamicReports.cmp.centerHorizontal(DynamicReports.cmp.image(this.xmt.getRutaRep() + "FurtranEncabezado.png").setFixedDimension(590, 60)), componentBuilderAdd, DynamicReports.cmp.verticalGap(4), DynamicReports.cmp.text("I. DATOS DEL TRANSPORTADOR (Si es persona natural diligenciar los campos referentes a nombres y apellidos)").setStyle(styleEncabezadosAmarillo), DynamicReports.cmp.verticalGap(2), componentBuilderNewRow, DynamicReports.cmp.verticalGap(4), DynamicReports.cmp.text("II. RELACION DE LAS VICTIMAS TRASLADADAS").setStyle(styleEncabezadosAmarillo), DynamicReports.cmp.verticalGap(2), componentBuilderNewRow3, DynamicReports.cmp.verticalGap(4), DynamicReports.cmp.text("III. LUGAR EN EL QUE SE RECOGE LA VICTIMA O VICTIMAS").setStyle(styleEncabezadosAmarillo), DynamicReports.cmp.verticalGap(2), componentBuilderNewRow2, DynamicReports.cmp.verticalGap(4), DynamicReports.cmp.text("IV. CERTIFICACION DE TRASLADO DE VICTIMAS").setStyle(styleEncabezadosAmarillo), DynamicReports.cmp.verticalGap(2), componentBuilderAdd2, DynamicReports.cmp.verticalGap(4)});
            try {
                report.toPdf(pdfExporter);
            } catch (DRException e) {
                Logger.getLogger(Furtran.class.getName()).log(Level.SEVERE, (String) null, e);
            }
        } catch (SQLException ex2) {
            Logger.getLogger(Furtran.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex2);
        }
        return report;
    }

    private HorizontalListBuilder TipoDocumento(String xtipoDoc) {
        HorizontalListBuilder horizontalListBuilderAdd = DynamicReports.cmp.horizontalList().add(new ComponentBuilder[]{label("Tipo de Documento", 11)});
        ComponentBuilder[] componentBuilderArr = new ComponentBuilder[1];
        componentBuilderArr[0] = createCellComponent("CC", DynamicReports.cmp.text(xtipoDoc.equals("CC") ? "X" : ""));
        HorizontalListBuilder horizontalListBuilderAdd2 = horizontalListBuilderAdd.add(componentBuilderArr);
        ComponentBuilder[] componentBuilderArr2 = new ComponentBuilder[1];
        componentBuilderArr2[0] = createCellComponent("CE", DynamicReports.cmp.text(xtipoDoc.equals("CE") ? "X" : ""));
        HorizontalListBuilder horizontalListBuilderAdd3 = horizontalListBuilderAdd2.add(componentBuilderArr2);
        ComponentBuilder[] componentBuilderArr3 = new ComponentBuilder[1];
        componentBuilderArr3[0] = createCellComponent("PA", DynamicReports.cmp.text(xtipoDoc.equals("PA") ? "X" : ""));
        HorizontalListBuilder horizontalListBuilderAdd4 = horizontalListBuilderAdd3.add(componentBuilderArr3);
        ComponentBuilder[] componentBuilderArr4 = new ComponentBuilder[1];
        componentBuilderArr4[0] = createCellComponent("TI", DynamicReports.cmp.text(xtipoDoc.equals("TI") ? "X" : ""));
        HorizontalListBuilder horizontalListBuilderAdd5 = horizontalListBuilderAdd4.add(componentBuilderArr4);
        ComponentBuilder[] componentBuilderArr5 = new ComponentBuilder[1];
        componentBuilderArr5[0] = createCellComponent("NIT", DynamicReports.cmp.text(xtipoDoc.equals("NI") ? "X" : ""));
        HorizontalListBuilder list = horizontalListBuilderAdd5.add(componentBuilderArr5);
        return list;
    }

    private HorizontalListBuilder Radicado(String xnRadicado) {
        HorizontalListBuilder list;
        if (this.xEsGlosa == 0) {
            list = DynamicReports.cmp.horizontalList().add(new ComponentBuilder[]{labelP("", 13), emptyCell(2), label("RG", 2)}).add(new ComponentBuilder[]{textCell("", 1)});
        } else {
            HorizontalListBuilder horizontalListBuilderAdd = DynamicReports.cmp.horizontalList().add(new ComponentBuilder[]{labelP(xnRadicado, 13), emptyCell(2), label("RG", 2)});
            ComponentBuilder[] componentBuilderArr = new ComponentBuilder[1];
            componentBuilderArr[0] = textCell(xnRadicado.equals("") ? "" : "X", 1);
            list = horizontalListBuilderAdd.add(componentBuilderArr);
        }
        return list;
    }

    private HorizontalListBuilder TipoDocumentoP(String xtipoDoc) {
        HorizontalListBuilder horizontalListBuilderAdd = DynamicReports.cmp.horizontalList().add(new ComponentBuilder[]{label("Tipo de documento permitido", 20)});
        ComponentBuilder[] componentBuilderArr = new ComponentBuilder[1];
        componentBuilderArr[0] = createCellComponent("CC", DynamicReports.cmp.text(xtipoDoc.equals("CC") ? "X" : ""));
        HorizontalListBuilder horizontalListBuilderAdd2 = horizontalListBuilderAdd.add(componentBuilderArr);
        ComponentBuilder[] componentBuilderArr2 = new ComponentBuilder[1];
        componentBuilderArr2[0] = createCellComponent("CE", DynamicReports.cmp.text(xtipoDoc.equals("CE") ? "X" : ""));
        HorizontalListBuilder horizontalListBuilderAdd3 = horizontalListBuilderAdd2.add(componentBuilderArr2);
        ComponentBuilder[] componentBuilderArr3 = new ComponentBuilder[1];
        componentBuilderArr3[0] = createCellComponent("PA", DynamicReports.cmp.text(xtipoDoc.equals("PA") ? "X" : ""));
        HorizontalListBuilder horizontalListBuilderAdd4 = horizontalListBuilderAdd3.add(componentBuilderArr3);
        ComponentBuilder[] componentBuilderArr4 = new ComponentBuilder[1];
        componentBuilderArr4[0] = createCellComponent("TI", DynamicReports.cmp.text(xtipoDoc.equals("TI") ? "X" : ""));
        HorizontalListBuilder horizontalListBuilderAdd5 = horizontalListBuilderAdd4.add(componentBuilderArr4);
        ComponentBuilder[] componentBuilderArr5 = new ComponentBuilder[1];
        componentBuilderArr5[0] = createCellComponent("RC", DynamicReports.cmp.text(xtipoDoc.equals("RC") ? "X" : ""));
        HorizontalListBuilder horizontalListBuilderAdd6 = horizontalListBuilderAdd5.add(componentBuilderArr5);
        ComponentBuilder[] componentBuilderArr6 = new ComponentBuilder[1];
        componentBuilderArr6[0] = createCellComponent("AS", DynamicReports.cmp.text(xtipoDoc.equals("AS") ? "X" : ""));
        HorizontalListBuilder horizontalListBuilderAdd7 = horizontalListBuilderAdd6.add(componentBuilderArr6);
        ComponentBuilder[] componentBuilderArr7 = new ComponentBuilder[1];
        componentBuilderArr7[0] = createCellComponent("MS", DynamicReports.cmp.text(xtipoDoc.equals("MS") ? "X" : ""));
        HorizontalListBuilder list = horizontalListBuilderAdd7.add(componentBuilderArr7);
        return list;
    }

    private HorizontalListBuilder TipoEvento(String xtipoEvento) {
        HorizontalListBuilder horizontalListBuilderAdd = DynamicReports.cmp.horizontalList().add(new ComponentBuilder[]{label("Tipo de Evento que suscita la movilización:", 20)});
        ComponentBuilder[] componentBuilderArr = new ComponentBuilder[3];
        componentBuilderArr[0] = label("Accidente de Tránsito", 9, this.textStyle);
        componentBuilderArr[1] = textCell(xtipoEvento.equals("Accidente de Tránsito") ? "X" : "", 1);
        componentBuilderArr[2] = emptyCell(2);
        HorizontalListBuilder horizontalListBuilderAdd2 = horizontalListBuilderAdd.add(componentBuilderArr);
        ComponentBuilder[] componentBuilderArr2 = new ComponentBuilder[3];
        componentBuilderArr2[0] = label("Evento Catastrófico", 8, this.textStyle);
        componentBuilderArr2[1] = textCell(xtipoEvento.equals("Evento Catastrófico") ? "X" : "", 1);
        componentBuilderArr2[2] = emptyCell(2);
        HorizontalListBuilder horizontalListBuilderAdd3 = horizontalListBuilderAdd2.add(componentBuilderArr2);
        ComponentBuilder[] componentBuilderArr3 = new ComponentBuilder[3];
        componentBuilderArr3[0] = label("Evento Terrorista", 7, this.textStyle);
        componentBuilderArr3[1] = textCell(xtipoEvento.equals("Evento Terrorista") ? "X" : "", 1);
        componentBuilderArr3[2] = emptyCell(2);
        HorizontalListBuilder list = horizontalListBuilderAdd3.add(componentBuilderArr3);
        return list;
    }

    private HorizontalListBuilder TipoServicio(String xTEvento, String xCual) {
        HorizontalListBuilder horizontalListBuilderAdd = DynamicReports.cmp.horizontalList().add(new ComponentBuilder[]{label("Tipo de Servicio:", 15)});
        ComponentBuilder[] componentBuilderArr = new ComponentBuilder[3];
        componentBuilderArr[0] = emptyCell(4);
        componentBuilderArr[1] = label("Ambulancia Básica", 10, this.textStyle);
        componentBuilderArr[2] = textCell(xTEvento.equals("Ambulancia Básica") ? "X" : "", 1);
        HorizontalListBuilder horizontalListBuilderAdd2 = horizontalListBuilderAdd.add(componentBuilderArr);
        ComponentBuilder[] componentBuilderArr2 = new ComponentBuilder[3];
        componentBuilderArr2[0] = emptyCell(1);
        componentBuilderArr2[1] = label("Ambulancia Medicada", 9, this.textStyle);
        componentBuilderArr2[2] = textCell(xTEvento.equals("Ambulancia Medicada") ? "X" : "", 1);
        HorizontalListBuilder horizontalListBuilderAdd3 = horizontalListBuilderAdd2.add(componentBuilderArr2).newRow(3).add(new ComponentBuilder[]{label("Si es Persona Natural-tipo Servicio", 15)});
        ComponentBuilder[] componentBuilderArr3 = new ComponentBuilder[3];
        componentBuilderArr3[0] = emptyCell(4);
        componentBuilderArr3[1] = label("Particular", 10, this.textStyle);
        componentBuilderArr3[2] = textCell(xTEvento.equals("Particular") ? "X" : "", 1);
        HorizontalListBuilder horizontalListBuilderAdd4 = horizontalListBuilderAdd3.add(componentBuilderArr3);
        ComponentBuilder[] componentBuilderArr4 = new ComponentBuilder[3];
        componentBuilderArr4[0] = emptyCell(1);
        componentBuilderArr4[1] = label("Servicio Público", 9, this.textStyle);
        componentBuilderArr4[2] = textCell(xTEvento.equals("Servicio Público") ? "X" : "", 1);
        HorizontalListBuilder horizontalListBuilderAdd5 = horizontalListBuilderAdd4.add(componentBuilderArr4);
        ComponentBuilder[] componentBuilderArr5 = new ComponentBuilder[3];
        componentBuilderArr5[0] = emptyCell(1);
        componentBuilderArr5[1] = label("Otro", 3, this.textStyle);
        componentBuilderArr5[2] = textCell(xTEvento.equals("Otro") ? "X" : "", 1);
        HorizontalListBuilder list = horizontalListBuilderAdd5.add(componentBuilderArr5).add(new ComponentBuilder[]{emptyCell(1), label("Cual", 3, this.textStyle), label(xCual, 6)});
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

    private ComponentBuilder<?, ?> createCellComponent(String label, ComponentBuilder<?, ?> content) {
        HorizontalListBuilder cell = DynamicReports.cmp.horizontalList(new ComponentBuilder[]{DynamicReports.cmp.text(label).setStyle(this.textStyle6topleft), content.setStyle(this.textStyle6bot)});
        cell.setStyle(this.cellStyle2);
        cell.setFixedWidth(32);
        return cell;
    }
}
