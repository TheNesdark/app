package com.genoma.plus.controller.historia;

import Facturacion.Furips_PA_V2023;
import Facturacion.Templates_1;
import Utilidades.Metodos;
import Utilidades.MetodosGenericos;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.genoma.plus.controller.historia.dto.Anexo2335Dto;
import com.genoma.plus.controller.historia.dto.ListaCodigoOtrosDto;
import com.genoma.plus.controller.historia.dto.ListaCumDetalleDto;
import com.genoma.plus.controller.historia.dto.ListaCupsDetalleDto;
import com.genoma.plus.controller.laboratorio.dto.CustomPresenter;
import com.genoma.plus.controller.laboratorio.dto.infoAlertaRececion;
import com.genoma.plus.domains.models.domains.general.RecursosMicroserviciosDomain;
import java.awt.Color;
import java.io.File;
import java.sql.Connection;
import java.sql.ResultSetMetaData;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.Response;
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

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/historia/ImpresionAnexo2335.class */
public class ImpresionAnexo2335 {
    private static final int cellWidth = 10;
    private static final int cellHeight = 10;
    private static final int cellWidth1 = 8;
    private static final int cellHeight1 = 8;
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
    private Connection connection;
    private StyleBuilder bold14Style;
    private StyleBuilder styleCamposLabel;
    private Long ingresoId;
    private Integer tipoAnexo;
    private Long idAnexo;
    private Metodos metodo = new Metodos();
    MetodosGenericos<infoAlertaRececion> metodosGenericos = new MetodosGenericos<>();
    int index = 0;
    private String motivoConsulta = "";
    private String clasificacionTriage = "";
    private String fechaHoraIngreso = "";
    private String viaIngreso = "";
    private String codigoPrestadorRemite = "";
    private String diagnostico = "";
    private String diagnosticoRelacionado1 = "";
    private String diagnosticoRelacionado2 = "";
    private String diagnosticoRelacionado3 = "";
    private String condicionDestino = "";
    private String causaAtencion = "";
    private String prioridadAtencion = "";
    private String tipoAtencionSolicitada = "";
    private String grupoServicios = "";
    private String modalidadAtencion = "";
    private String codigoServicio = "";
    private String titulo = "";
    private Metodos metodos = new Metodos();
    HorizontalListBuilder datelleCups = DynamicReports.cmp.horizontalList();
    HorizontalListBuilder datelleOtroServicios = DynamicReports.cmp.horizontalList();
    HorizontalListBuilder Anexo2 = DynamicReports.cmp.horizontalList();
    HorizontalListBuilder Anexo3 = DynamicReports.cmp.horizontalList();
    HorizontalListBuilder Anexo5 = DynamicReports.cmp.horizontalList();
    HorizontalListBuilder Anexo6 = DynamicReports.cmp.horizontalList();
    HorizontalListBuilder AnexoCompleto = DynamicReports.cmp.horizontalList();
    HorizontalListBuilder datosPago = DynamicReports.cmp.horizontalList();
    List<Map<String, String>> detallesCombinados = new ArrayList();

    public ImpresionAnexo2335(Long ingresoId, Integer tipo, Long idAnexo) {
        this.ingresoId = ingresoId;
        this.tipoAnexo = tipo;
        this.idAnexo = idAnexo;
    }

    public JasperReportBuilder build() {
        JasperReportBuilder report = DynamicReports.report();
        try {
            RecursosMicroserviciosDomain microserviciosDomain = this.metodo.getParametrosEncriptados("24", "finByAnexoIdAndIngreso");
            String fullUrl = microserviciosDomain.getUrlRecurso() + "/" + this.idAnexo + "/" + this.ingresoId + "/" + this.tipoAnexo;
            System.out.println("fullurlSql --- " + fullUrl);
            Response response = this.metodo.getResteasyClient().target(fullUrl).request().get();
            int statusCode = response.getStatus();
            if (statusCode == 200) {
                try {
                    new CustomPresenter();
                    CustomPresenter presenter = (CustomPresenter) this.metodo.getMapper().readValue((String) response.readEntity(String.class), CustomPresenter.class);
                    Anexo2335Dto anexo2335Dto = (Anexo2335Dto) this.metodo.getMapper().readValue(this.metodo.getMapper().writeValueAsString(presenter.getData()), new TypeReference<Anexo2335Dto>() { // from class: com.genoma.plus.controller.historia.ImpresionAnexo2335.1
                    });
                    report = Anexo(anexo2335Dto);
                } catch (JsonProcessingException e) {
                    Logger.getLogger(ImpresionAnexo2335.class.getName()).log(Level.SEVERE, (String) null, e);
                }
            }
            response.close();
            this.metodo.getResteasyClient().close();
        } catch (IllegalArgumentException | NullPointerException e2) {
            Logger.getLogger(ImpresionAnexo2335.class.getName()).log(Level.SEVERE, (String) null, (Throwable) e2);
        }
        return report;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private JasperReportBuilder createSubreportCups(HorizontalListBuilder datelleCups) {
        StyleBuilder styleEncabezados = DynamicReports.stl.style(this.bold14Style).setFontSize(8).bold().setHorizontalAlignment(HorizontalAlignment.CENTER).setBackgroundColor(new Color(204, 255, 204)).setBorder(DynamicReports.stl.pen1Point());
        JasperReportBuilder report = DynamicReports.report();
        report.title(new ComponentBuilder[]{DynamicReports.cmp.text("CÓDIGO CUPS DEL PROCEDIMIENTOS REQUERIDO ").setStyle(styleEncabezados), DynamicReports.cmp.verticalGap(2), datelleCups, DynamicReports.cmp.verticalGap(2)});
        return report;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private JasperReportBuilder createSubreportCum(HorizontalListBuilder datelleOtroServicios) {
        StyleBuilder styleEncabezados = DynamicReports.stl.style(this.bold14Style).setFontSize(8).bold().setHorizontalAlignment(HorizontalAlignment.CENTER).setBackgroundColor(new Color(204, 255, 204)).setBorder(DynamicReports.stl.pen1Point());
        JasperReportBuilder report = DynamicReports.report();
        System.err.println("datelleOtroServicios" + datelleOtroServicios.getList());
        report.title(new ComponentBuilder[]{DynamicReports.cmp.text("CÓDIGO DE OTROS SERVICIOS.").setStyle(styleEncabezados), DynamicReports.cmp.verticalGap(2), datelleOtroServicios, DynamicReports.cmp.verticalGap(2)});
        return report;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private JasperReportBuilder createSubreportOtros(HorizontalListBuilder datelleOtros) {
        StyleBuilder styleEncabezados = DynamicReports.stl.style(this.bold14Style).setFontSize(8).bold().setHorizontalAlignment(HorizontalAlignment.CENTER).setBackgroundColor(new Color(204, 255, 204)).setBorder(DynamicReports.stl.pen1Point());
        JasperReportBuilder report = DynamicReports.report();
        report.title(new ComponentBuilder[]{DynamicReports.cmp.text("CÓDIGO DE OTROS SERVICIOS ").setStyle(styleEncabezados), DynamicReports.cmp.verticalGap(2), datelleOtros, DynamicReports.cmp.verticalGap(2)});
        return report;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private JasperReportBuilder subCorreo(HorizontalListBuilder datelleOtros) {
        StyleBuilder styleEncabezados = DynamicReports.stl.style(this.bold14Style).setFontSize(8).bold().setHorizontalAlignment(HorizontalAlignment.CENTER).setBackgroundColor(new Color(204, 255, 204)).setBorder(DynamicReports.stl.pen1Point());
        JasperReportBuilder report = DynamicReports.report();
        report.title(new ComponentBuilder[]{DynamicReports.cmp.text("CÓDIGO DE OTROS SERVICIOS ").setStyle(styleEncabezados), DynamicReports.cmp.verticalGap(2), datelleOtros, DynamicReports.cmp.verticalGap(2)});
        return report;
    }

    private JasperReportBuilder Anexo(Anexo2335Dto anexo2335Dto) {
        System.err.println("si entro Anexo");
        System.err.println("anexo2335Dto" + anexo2335Dto.getId());
        this.metodo.mEliminarArchivo(new File(this.metodo.getRutaRep() + "Anexo1.pdf"));
        JasperPdfExporterBuilder pdfExporter = DynamicReports.export.pdfExporter(this.metodo.getRutaRep() + "Anexo1.pdf");
        JasperReportBuilder reportAnexo = DynamicReports.report();
        new Templates_1();
        this.rootStyle = DynamicReports.stl.style().setPadding(2);
        this.boldStyle = DynamicReports.stl.style(this.rootStyle).bold();
        this.boldCenteredStyle = DynamicReports.stl.style(this.boldStyle).setAlignment(HorizontalAlignment.CENTER, VerticalAlignment.TOP);
        this.fount_roja = DynamicReports.stl.style(this.boldStyle).setAlignment(HorizontalAlignment.CENTER, VerticalAlignment.TOP).setFontSize(7).setForegroundColor(Color.RED);
        this.bold10CenteredStyle = DynamicReports.stl.style(this.boldCenteredStyle).setFontSize(7);
        this.textStyle = DynamicReports.stl.style().setFontSize(7).setPadding(2);
        this.centeredStyle = DynamicReports.stl.style(this.textStyle).setAlignment(HorizontalAlignment.CENTER, VerticalAlignment.MIDDLE);
        this.labelStyle = DynamicReports.stl.style(this.textStyle).setHorizontalAlignment(HorizontalAlignment.LEFT).bold();
        this.cellStyle = DynamicReports.stl.style(this.textStyle).setBorder(DynamicReports.stl.pen1Point()).setAlignment(HorizontalAlignment.CENTER, VerticalAlignment.MIDDLE);
        StyleBuilder styleEncabezados = DynamicReports.stl.style(this.bold14Style).setFontSize(8).bold().setHorizontalAlignment(HorizontalAlignment.CENTER).setBackgroundColor(new Color(204, 255, 204)).setBorder(DynamicReports.stl.pen1Point());
        DynamicReports.stl.style(this.bold14Style).setFontSize(8).bold().setHorizontalAlignment(HorizontalAlignment.CENTER).setBorder(DynamicReports.stl.pen1Point());
        DynamicReports.stl.style(this.bold14Style).setFontSize(8).setHorizontalAlignment(HorizontalAlignment.JUSTIFIED).setBorder(DynamicReports.stl.pen1Point());
        this.styleCamposLabel = DynamicReports.stl.style(this.bold14Style).setFontSize(8).bold().setHorizontalAlignment(HorizontalAlignment.LEFT).setBorder(DynamicReports.stl.pen1Point());
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = formatter.parse(anexo2335Dto.getFechaRegistro());
        } catch (ParseException ex) {
            Logger.getLogger(ImpresionAnexo2335.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        DynamicReports.cmp.horizontalList(new ComponentBuilder[]{DynamicReports.cmp.text("Pie de página fijo").setStyle(styleEncabezados), DynamicReports.cmp.pageNumber().setStyle(styleEncabezados)}).setFixedHeight(20);
        ComponentBuilder componentBuilderAdd = DynamicReports.cmp.horizontalList().add(new ComponentBuilder[]{TipoAnexo(anexo2335Dto.getTipoAnexo().toString()), emptyCell(4)});
        String numeroConsecutivo = "";
        if (anexo2335Dto.getTipoAnexo().intValue() == 5 || anexo2335Dto.getTipoAnexo().intValue() == 6) {
            numeroConsecutivo = this.metodo.numeroCerosIzquierda(Long.valueOf(anexo2335Dto.getConsecutivoTipo().intValue()), 20);
            String str = anexo2335Dto.getFechaRegistro() + " " + anexo2335Dto.getHoraRegistro();
        }
        ComponentBuilder componentBuilderNewRow = DynamicReports.cmp.horizontalList().add(new ComponentBuilder[]{label("Consecutivo", 6), emptyCell(2), textCell(this.metodo.formatoAMD_Unida.format(date) + this.metodo.numeroCerosIzquierda(anexo2335Dto.getId(), 12), 20), emptyCell(2)}).add(new ComponentBuilder[]{label("Fecha y hora", 6), emptyCell(2), textCell(anexo2335Dto.getFechaRegistro() + " " + anexo2335Dto.getHoraRegistro(), 16)}).newRow(2).add(new ComponentBuilder[]{label("Numero Solicitud", 7), emptyCell(1), textCell(numeroConsecutivo, 20), emptyCell(2)}).add(new ComponentBuilder[]{label("Fecha y hora Solicitud", 8), emptyCell(1), textCell("", 16)}).newRow(2).add(new ComponentBuilder[]{label("NIT Prestador ", 6), emptyCell(2), textCell(anexo2335Dto.getAnexoInformacionIps().getNumeroIdentificacionIps(), 9), emptyCell(1)}).add(new ComponentBuilder[]{label("Codigo Prestador ", 8), emptyCell(2), textCell(anexo2335Dto.getAnexoInformacionIps().getCodigoPrestador(), 12), emptyCell(1)}).add(new ComponentBuilder[]{label("Codigo ERP", 6), emptyCell(2), textCell(anexo2335Dto.getAnexoInformacionIps().getCodigoEntidadPagadora(), 6)}).newRow(2);
        ComponentBuilder componentBuilderNewRow2 = DynamicReports.cmp.horizontalList().add(new ComponentBuilder[]{labelP(anexo2335Dto.getAnexoDatoUsuario().getPrimerApellido(), 25), emptyCell(9)}).add(new ComponentBuilder[]{labelP(anexo2335Dto.getAnexoDatoUsuario().getSegundoApellido(), 25)}).newRow(2).add(new ComponentBuilder[]{emptyCell(10), label("1er Apellido", 11)}).add(new ComponentBuilder[]{emptyCell(23), label("2do Apellido", 11)}).newRow(2).add(new ComponentBuilder[]{labelP(anexo2335Dto.getAnexoDatoUsuario().getPrimerNombre(), 25), emptyCell(9)}).add(new ComponentBuilder[]{labelP(anexo2335Dto.getAnexoDatoUsuario().getSegundoNombre(), 25)}).newRow(2).add(new ComponentBuilder[]{emptyCell(10), label("1er Nombre", 11)}).add(new ComponentBuilder[]{emptyCell(23), label("2do Nombre", 11)}).newRow(2).add(new ComponentBuilder[]{TipoDocumento(anexo2335Dto.getAnexoDatoUsuario().getTipoDocumento()), emptyCell(4)}).newRow(2).add(new ComponentBuilder[]{label("Numero Documento", 8), emptyCell(1), textCell(anexo2335Dto.getAnexoDatoUsuario().getNumeroDocumento(), 20), emptyCell(1)}).add(new ComponentBuilder[]{label("Fecha Nacimiento", 8), emptyCell(1), textCell(anexo2335Dto.getAnexoDatoUsuario().getFechaNacimiento(), 10)}).newRow(2).add(new ComponentBuilder[]{label("Dirrecion", 8), emptyCell(1), textCellSalto(anexo2335Dto.getAnexoDatoUsuario().getDireccion(), 80, 40), emptyCell(1)}).newRow(3).add(new ComponentBuilder[]{label("Telefono", 8), emptyCell(1), textCell(anexo2335Dto.getAnexoDatoUsuario().getTelefono(), 10)}).add(new ComponentBuilder[]{label("Municipio", 6), emptyCell(1), textCell(anexo2335Dto.getAnexoDatoUsuario().getMunicipio(), 5)}).newRow(2).add(new ComponentBuilder[]{label("Correo", 6), emptyCell(3), textCellSalto(anexo2335Dto.getAnexoDatoUsuario().getCorreo(), 50, 40)}).newRow(3).add(new ComponentBuilder[]{label("Dirrecion Alternativa", 9), textCellSalto(anexo2335Dto.getAnexoDatoUsuario().getDireccionAlternativa(), 80, 40)}).newRow(3).add(new ComponentBuilder[]{label("Contacto Emergencia", 8), emptyCell(1), textCellSalto(anexo2335Dto.getAnexoDatoUsuario().getNombreContactoEmergencia(), 120, 40)}).newRow(3).add(new ComponentBuilder[]{label("Telefono emergencia", 8), emptyCell(1), textCell(anexo2335Dto.getAnexoDatoUsuario().getTelefonoContactoEmergencia(), 10)}).newRow(2);
        this.datosPago.add(new ComponentBuilder[]{label("Tipo Pago Compartido ", 7), emptyCell(1), textCell("", 2), emptyCell(1)}).add(new ComponentBuilder[]{label("Nivel persona ", 7), emptyCell(1), textCell("", 2)}).newRow(2).add(new ComponentBuilder[]{label("Valor pesos pago compartido", 10), emptyCell(1), textCell("", 7)}).add(new ComponentBuilder[]{label("Tope máximo copagos", 10), emptyCell(1), textCell("", 7)}).newRow(2).newRow(1);
        if (null != anexo2335Dto.getTipoAnexo()) {
            switch (anexo2335Dto.getTipoAnexo().intValue()) {
                case 2:
                    this.titulo = "INFORME DE LA ATENCIÓN  DE URGENCIAS";
                    this.causaAtencion = anexo2335Dto.getAnexo2().getMotivoConsulta();
                    this.clasificacionTriage = anexo2335Dto.getAnexo2().getClasificacionTriage();
                    this.fechaHoraIngreso = anexo2335Dto.getAnexo2().getFechaHoraIngreso();
                    this.viaIngreso = anexo2335Dto.getAnexo2().getViaIngreso();
                    this.codigoPrestadorRemite = anexo2335Dto.getAnexo2().getCodigoPrestadorRemite();
                    this.diagnostico = anexo2335Dto.getAnexo2().getDiagnostico();
                    this.diagnosticoRelacionado1 = anexo2335Dto.getAnexo2().getDiagnosticoRelacionado1();
                    this.diagnosticoRelacionado2 = anexo2335Dto.getAnexo2().getDiagnosticoRelacionado2();
                    this.diagnosticoRelacionado3 = anexo2335Dto.getAnexo2().getDiagnosticoRelacionado3();
                    this.condicionDestino = "";
                    this.datelleCups.add(new ComponentBuilder[]{label("Grupo de servicios", 10), emptyCell(2), textCell("", 2), emptyCell(1)}).add(new ComponentBuilder[]{label("Código del servicio", 10), emptyCell(2), textCell("", 4), emptyCell(1)}).add(new ComponentBuilder[]{label("Finalidad de la tecnología", 10), emptyCell(2), textCell("", 2)}).newRow(2).add(new ComponentBuilder[]{label("Código                                             Nombre                                                           Cantidad", 55), emptyCell(2), emptyCell(1)}).newRow(1).add(new ComponentBuilder[]{label("Cups", 4), emptyCell(2), textCell("", 6), emptyCell(1)}).add(new ComponentBuilder[]{label("Nombre", 8), emptyCell(2), textCell("", 6), emptyCell(1)}).add(new ComponentBuilder[]{label("Cantidad requerida", 8), emptyCell(2), textCell("", 3)});
                    this.datelleOtroServicios.add(new ComponentBuilder[]{label("Código Servicios ", 8), emptyCell(2), textCell("", 20), emptyCell(1)}).add(new ComponentBuilder[]{label("Cantidad requerida", 8), emptyCell(2), textCell("", 3)}).newRow(2);
                    break;
                case 3:
                    this.titulo = "SOLICITUD AUTORIZACION SERVICIO Y TECNOLOGÍAS EN SALUD";
                    this.causaAtencion = anexo2335Dto.getAnexo3().getCausaAtencion();
                    this.diagnostico = anexo2335Dto.getAnexo3().getDiagnostico();
                    this.diagnosticoRelacionado1 = anexo2335Dto.getAnexo3().getDiagnosticoRelacionado1();
                    this.diagnosticoRelacionado2 = anexo2335Dto.getAnexo3().getDiagnosticoRelacionado2();
                    this.diagnosticoRelacionado3 = anexo2335Dto.getAnexo3().getDiagnosticoRelacionado3();
                    this.prioridadAtencion = anexo2335Dto.getAnexo3().getPrioridadAtencion();
                    this.tipoAtencionSolicitada = anexo2335Dto.getAnexo3().getTipoAtencionSolicitada();
                    this.modalidadAtencion = anexo2335Dto.getAnexo3().getModalidadAtencion();
                    if (anexo2335Dto.getAnexo3().getCupsDetalle() != null && !anexo2335Dto.getAnexo3().getCupsDetalle().isEmpty()) {
                        this.index = 0;
                        anexo2335Dto.getAnexo3().getCupsDetalle().forEach(cupsDetalle -> {
                            this.datelleCups.add(new ComponentBuilder[]{label("Grupo de servicios", 10), emptyCell(2), textCell(anexo2335Dto.getAnexo3().getCupsDetalle().get(this.index).getGrupoServicios(), 2)}).add(new ComponentBuilder[]{label("Código del servicio", 10), emptyCell(2), textCell(anexo2335Dto.getAnexo3().getCupsDetalle().get(this.index).getCodigoServicio(), 4), emptyCell(1)}).add(new ComponentBuilder[]{label("Finalidad de la tecnología", 10), emptyCell(2), textCell(anexo2335Dto.getAnexo3().getCupsDetalle().get(this.index).getFinalidadTecnologia(), 2)}).newRow(2).add(new ComponentBuilder[]{label("Código", 10), emptyCell(2), emptyCell(1)}).add(new ComponentBuilder[]{label("Nombre", 30), emptyCell(2), emptyCell(1)}).add(new ComponentBuilder[]{label("Cantidad", 10), emptyCell(2), emptyCell(1)}).newRow(1).add(new ComponentBuilder[]{textCell(anexo2335Dto.getAnexo3().getCupsDetalle().get(this.index).getCodigoCups(), 6), emptyCell(1)}).add(new ComponentBuilder[]{emptyCell(1), textCell(anexo2335Dto.getAnexo3().getCupsDetalle().get(this.index).getNombreCups(), 35), emptyCell(1)}).add(new ComponentBuilder[]{emptyCell(2), textCell(anexo2335Dto.getAnexo3().getCupsDetalle().get(this.index).getCantidadRequerida(), 3)}).newRow(1);
                            this.index++;
                        });
                    }
                    if (anexo2335Dto.getAnexo3().getCumDetalle() != null && !anexo2335Dto.getAnexo3().getCumDetalle().isEmpty()) {
                        anexo2335Dto.getAnexo3().getCumDetalle().forEach(cumDetalle -> {
                            Map<String, String> detalleMap = new HashMap<>();
                            detalleMap.put("codigo", cumDetalle.getCodigoImuCum().toString());
                            detalleMap.put("cantidad", cumDetalle.getCantidadRequeridaImuCum().toString());
                            detalleMap.put("tipo", "CUM");
                            this.detallesCombinados.add(detalleMap);
                        });
                    }
                    if (anexo2335Dto.getAnexo3().getOtroCodigoDetalle() != null && !anexo2335Dto.getAnexo3().getOtroCodigoDetalle().isEmpty()) {
                        anexo2335Dto.getAnexo3().getOtroCodigoDetalle().forEach(otrosDetalle -> {
                            Map<String, String> detalleMap = new HashMap<>();
                            detalleMap.put("codigo", otrosDetalle.getCodigoOtrosServicios().toString());
                            detalleMap.put("cantidad", otrosDetalle.getCantidadOtrosServicios().toString());
                            detalleMap.put("tipo", "OtroServicio");
                            this.detallesCombinados.add(detalleMap);
                        });
                    }
                    this.detallesCombinados.forEach(detalle -> {
                        this.datelleOtroServicios.add(new ComponentBuilder[]{label(((String) detalle.get("tipo")) + " Código", 8), emptyCell(2), textCell((String) detalle.get("codigo"), 20), emptyCell(1)}).add(new ComponentBuilder[]{label("Cantidad requerida", 8), emptyCell(2), textCell((String) detalle.get("cantidad"), 3)}).newRow(2);
                    });
                    break;
                case 4:
                default:
                    this.datelleCups.add(new ComponentBuilder[]{label("Cups", 4), emptyCell(2), textCell("", 6), emptyCell(1)}).add(new ComponentBuilder[]{label("Cantidad requerida", 8), emptyCell(2), textCell("", 3), emptyCell(1)}).add(new ComponentBuilder[]{label("Finalidad de la tecnología", 10), emptyCell(2), textCell("", 2)}).newRow(2).add(new ComponentBuilder[]{label("Código                                             Nombre                                                           Cantidad", 55), emptyCell(2), emptyCell(1)}).newRow(1);
                    this.datelleOtroServicios.add(new ComponentBuilder[]{label("Código Servicios", 20), emptyCell(2), textCell("", 20), emptyCell(1)}).add(new ComponentBuilder[]{label("Cantidad requerida", 8), emptyCell(2), textCell("", 3)}).newRow(2);
                    break;
                case 5:
                    this.titulo = "REFERENCIA";
                    this.causaAtencion = anexo2335Dto.getAnexo5().getCausaAtencion();
                    this.codigoPrestadorRemite = anexo2335Dto.getAnexo5().getCodigoPrestadorRemite();
                    this.diagnostico = anexo2335Dto.getAnexo5().getDiagnostico();
                    this.diagnosticoRelacionado1 = anexo2335Dto.getAnexo5().getDiagnosticoRelacionado1();
                    this.diagnosticoRelacionado2 = anexo2335Dto.getAnexo5().getDiagnosticoRelacionado1();
                    this.diagnosticoRelacionado3 = anexo2335Dto.getAnexo5().getDiagnosticoRelacionado1();
                    this.condicionDestino = anexo2335Dto.getAnexo5().getCondicionDestino();
                    this.prioridadAtencion = anexo2335Dto.getAnexo5().getPrioridadAtencion();
                    this.tipoAtencionSolicitada = anexo2335Dto.getAnexo5().getTipoAtencionSolicitada();
                    this.modalidadAtencion = anexo2335Dto.getAnexo5().getModalidadAtencion();
                    this.codigoServicio = anexo2335Dto.getAnexo5().getCodigoServicio();
                    if (anexo2335Dto.getAnexo5().getCupsDetalle() != null && !anexo2335Dto.getAnexo5().getCupsDetalle().isEmpty()) {
                        this.index = 0;
                        anexo2335Dto.getAnexo5().getCupsDetalle().forEach(cupsDetalle2 -> {
                            this.datelleCups.add(new ComponentBuilder[]{label("Grupo de servicios", 10), emptyCell(2), textCell(anexo2335Dto.getAnexo5().getCupsDetalle().get(this.index).getGrupoServicios(), 2)}).add(new ComponentBuilder[]{label("Código del servicio", 10), emptyCell(2), textCell(anexo2335Dto.getAnexo5().getCupsDetalle().get(this.index).getCodigoServicio(), 4), emptyCell(1)}).add(new ComponentBuilder[]{label("Finalidad de la tecnología", 10), emptyCell(2), textCell(anexo2335Dto.getAnexo5().getCupsDetalle().get(this.index).getFinalidadTecnologia(), 2)}).newRow(2).add(new ComponentBuilder[]{label("Código                                             Nombre                                                           Cantidad", 55), emptyCell(2), emptyCell(1)}).newRow(1).add(new ComponentBuilder[]{label("Cups", 4), emptyCell(2), textCell(anexo2335Dto.getAnexo5().getCupsDetalle().get(this.index).getCodigoCups(), 6), emptyCell(1)}).add(new ComponentBuilder[]{label("Cantidad requerida", 8), emptyCell(2), textCell(anexo2335Dto.getAnexo5().getCupsDetalle().get(this.index).getCantidadRequerida(), 3)}).newRow(1);
                            this.index++;
                        });
                        this.datelleOtroServicios.add(new ComponentBuilder[]{label("Código Servicios", 8), emptyCell(2), textCell("", 20), emptyCell(1)}).add(new ComponentBuilder[]{label("Cantidad requerida", 8), emptyCell(2), textCell("", 3)}).newRow(2);
                    }
                    break;
                case 6:
                    this.titulo = "CONTRAREFERENCIA";
                    this.codigoPrestadorRemite = anexo2335Dto.getAnexo6().getCodigoPrestadorRemite();
                    this.diagnostico = anexo2335Dto.getAnexo6().getDiagnostico();
                    this.diagnosticoRelacionado1 = anexo2335Dto.getAnexo6().getDiagnosticoRelacionado1();
                    this.diagnosticoRelacionado2 = anexo2335Dto.getAnexo6().getDiagnosticoRelacionado2();
                    this.diagnosticoRelacionado3 = anexo2335Dto.getAnexo6().getDiagnosticoRelacionado3();
                    this.condicionDestino = anexo2335Dto.getAnexo6().getCondicionDestino();
                    this.prioridadAtencion = anexo2335Dto.getAnexo6().getPrioridadAtencion();
                    this.tipoAtencionSolicitada = anexo2335Dto.getAnexo6().getTipoAtencionSolicitada();
                    this.modalidadAtencion = anexo2335Dto.getAnexo6().getModalidadAtencion();
                    this.codigoServicio = anexo2335Dto.getAnexo6().getCodigoServicio();
                    if (anexo2335Dto.getAnexo6().getCupsDetalle() != null && !anexo2335Dto.getAnexo6().getCupsDetalle().isEmpty()) {
                        this.index = 0;
                        anexo2335Dto.getAnexo6().getCupsDetalle().forEach(cupsDetalle3 -> {
                            this.datelleCups.add(new ComponentBuilder[]{label("Grupo de servicios", 10), emptyCell(2), textCell(anexo2335Dto.getAnexo6().getCupsDetalle().get(this.index).getGrupoServicios(), 2)}).add(new ComponentBuilder[]{label("Código del servicio", 10), emptyCell(2), textCell(anexo2335Dto.getAnexo6().getCupsDetalle().get(this.index).getCodigoServicio(), 4), emptyCell(1)}).add(new ComponentBuilder[]{label("Finalidad de la tecnología", 10), emptyCell(2), textCell(anexo2335Dto.getAnexo6().getCupsDetalle().get(this.index).getFinalidadTecnologia(), 2)}).newRow(2).add(new ComponentBuilder[]{label("Cups", 4), emptyCell(2), textCell(anexo2335Dto.getAnexo6().getCupsDetalle().get(this.index).getCodigoCups(), 6), emptyCell(1)}).add(new ComponentBuilder[]{label("Código                                             Nombre                                                           Cantidad", 55), emptyCell(2), emptyCell(1)}).newRow(1).add(new ComponentBuilder[]{label("Cantidad requerida", 8), emptyCell(2), textCell(anexo2335Dto.getAnexo6().getCupsDetalle().get(this.index).getCantidadRequerida(), 3)}).newRow(1);
                            this.index++;
                        });
                        this.datelleOtroServicios.add(new ComponentBuilder[]{label("Código Servicios", 8), emptyCell(2), textCell("", 20), emptyCell(1)}).add(new ComponentBuilder[]{label("Cantidad requerida", 8), emptyCell(2), textCell("", 3)}).newRow(2);
                    }
                    break;
            }
        } else {
            this.datelleCups.add(new ComponentBuilder[]{label("Grupo de servicios", 10), emptyCell(2), textCell("", 2), emptyCell(1)}).add(new ComponentBuilder[]{label("Código del servicio", 10), emptyCell(2), textCell("", 4), emptyCell(1)}).add(new ComponentBuilder[]{label("Finalidad de la tecnología", 10), emptyCell(2), textCell("", 2)}).newRow(2).add(new ComponentBuilder[]{label("Código", 10), emptyCell(2), emptyCell(1)}).add(new ComponentBuilder[]{label("Nombre", 10), emptyCell(2), emptyCell(1)}).add(new ComponentBuilder[]{label("Cantidad", 10), emptyCell(2), emptyCell(1)}).newRow(1).add(new ComponentBuilder[]{textCell("", 6), emptyCell(1)}).add(new ComponentBuilder[]{label("", 5), emptyCell(2), textCell("", 6), emptyCell(1)}).add(new ComponentBuilder[]{label("Cantidad requerida", 8), emptyCell(2), textCell("", 3)});
            this.datelleOtroServicios.add(new ComponentBuilder[]{label("CUM o IUM ", 8), emptyCell(2), textCell("", 20), emptyCell(1)}).add(new ComponentBuilder[]{label("Cantidad requerida", 8), emptyCell(2), textCell("", 3)}).newRow(2);
        }
        this.AnexoCompleto.add(new ComponentBuilder[]{label("Causa Atencion", 6), emptyCell(1), textCell(this.causaAtencion, 2), emptyCell(1)}).add(new ComponentBuilder[]{label("Clasificacion Triage", 8), emptyCell(1), textCell(this.clasificacionTriage, 1), emptyCell(1)}).add(new ComponentBuilder[]{label("Fecha y hora Ingreso ", 8), textCell(this.fechaHoraIngreso, 16), emptyCell(1)}).add(new ComponentBuilder[]{label("Via Ingreso", 6), emptyCell(1), textCell(this.viaIngreso, 2)}).newRow(1).add(new ComponentBuilder[]{label("Codigo Prestador autorizado", 10), emptyCell(1), textCell(this.codigoPrestadorRemite, 12), emptyCell(1)}).add(new ComponentBuilder[]{label("Condición y destino de la persona", 12), emptyCell(1), textCell(this.condicionDestino, 2)}).newRow(1).add(new ComponentBuilder[]{label("Diagnóstico Principal", 6), emptyCell(1), textCell(this.diagnostico, 4), emptyCell(1)}).add(new ComponentBuilder[]{label("Diagnóstico Relacionado 1", 8), emptyCell(1), textCell(this.diagnosticoRelacionado1, 4), emptyCell(1)}).add(new ComponentBuilder[]{label("Diagnóstico Relacionado 2", 8), emptyCell(1), textCell(this.diagnosticoRelacionado2, 4), emptyCell(1)}).add(new ComponentBuilder[]{label("Diagnóstico Relacionado 3", 8), emptyCell(1), textCell(this.diagnosticoRelacionado3, 4)}).newRow(1).add(new ComponentBuilder[]{label("Prioridad de la atención", 10), emptyCell(2), textCell(this.prioridadAtencion, 2), emptyCell(1)}).add(new ComponentBuilder[]{label("Tipo de atención Solicitada", 10), emptyCell(2), textCell(this.tipoAtencionSolicitada, 2)}).newRow(1).add(new ComponentBuilder[]{label("Modalidad tecnologia de salud ", 10), emptyCell(2), textCell(this.modalidadAtencion, 2), emptyCell(1)}).add(new ComponentBuilder[]{label("Código servicio solicita la referencia ", 10), emptyCell(2), textCell(this.codigoServicio, 4)}).newRow(1);
        reportAnexo.setTemplate(Templates_1.reportTemplate).setPageFormat(612, 892, PageOrientation.PORTRAIT).setTextStyle(this.textStyle).title(new ComponentBuilder[]{DynamicReports.cmp.image(this.metodo.getRutaRep() + "Anexo2335encabezado.jpg").setFixedDimension(592, 60), DynamicReports.cmp.text("").setStyle(styleEncabezados), DynamicReports.cmp.verticalGap(2), componentBuilderAdd, DynamicReports.cmp.verticalGap(2), DynamicReports.cmp.text("DATOS GENERALES").setStyle(styleEncabezados), DynamicReports.cmp.verticalGap(2), componentBuilderNewRow, DynamicReports.cmp.verticalGap(2), DynamicReports.cmp.text("ACTUALIZACIÓN DE DATOS DE CONTACTO").setStyle(styleEncabezados), DynamicReports.cmp.verticalGap(2), componentBuilderNewRow2, DynamicReports.cmp.verticalGap(2), DynamicReports.cmp.text(this.titulo).setStyle(styleEncabezados), DynamicReports.cmp.verticalGap(2), this.AnexoCompleto, DynamicReports.cmp.verticalGap(2), DynamicReports.cmp.subreport(createSubreportCups(this.datelleCups)), DynamicReports.cmp.verticalGap(2), DynamicReports.cmp.subreport(createSubreportCum(this.datelleOtroServicios)), DynamicReports.cmp.text("INFORMACION ADICIONAL").setStyle(styleEncabezados), DynamicReports.cmp.verticalGap(2), this.datosPago, DynamicReports.cmp.verticalGap(2)}).pageFooter(new ComponentBuilder[]{DynamicReports.cmp.horizontalList().add(new ComponentBuilder[]{labelP("IDENTIFICACION", 8)}).add(new ComponentBuilder[]{labelP(anexo2335Dto.getAnexoInformacionIps().getDocumentoUsuarioGenera(), 12)}).add(new ComponentBuilder[]{labelP("FUNCIONARIO", 7)}).add(new ComponentBuilder[]{labelP(anexo2335Dto.getAnexoInformacionIps().getUsuarioGenera(), 30)}).newRow(1).add(new ComponentBuilder[]{labelP("CARGO", 10)}).add(new ComponentBuilder[]{labelP(anexo2335Dto.getAnexoInformacionIps().getCargoUsuarioGenera(), 35)}).newRow(1).add(new ComponentBuilder[]{emptyCell(25), label("Página ", 3), emptyCell(1), DynamicReports.cmp.pageNumber(), emptyCell(1), label(" de ", 2), emptyCell(1), DynamicReports.cmp.totalPages()})});
        try {
            reportAnexo.toPdf(pdfExporter);
        } catch (DRException e) {
            Logger.getLogger(Furips_PA_V2023.class.getName()).log(Level.SEVERE, (String) null, e);
        }
        return reportAnexo;
    }

    private /* synthetic */ void lambda$Anexo$6(Anexo2335Dto anexo2335Dto, ListaCupsDetalleDto cupsDetalle) {
        this.datelleCups.add(new ComponentBuilder[]{label("Grupo de servicios", 10), emptyCell(2), textCell(anexo2335Dto.getAnexo3().getCupsDetalle().get(this.index).getGrupoServicios(), 2)}).add(new ComponentBuilder[]{label("Código del servicio", 10), emptyCell(2), textCell(anexo2335Dto.getAnexo3().getCupsDetalle().get(this.index).getCodigoServicio(), 4), emptyCell(1)}).add(new ComponentBuilder[]{label("Finalidad de la tecnología", 10), emptyCell(2), textCell(anexo2335Dto.getAnexo3().getCupsDetalle().get(this.index).getFinalidadTecnologia(), 2)}).newRow(2).add(new ComponentBuilder[]{label("Código                                             Nombre                                                           Cantidad", 55), emptyCell(2), emptyCell(1)}).newRow(1).add(new ComponentBuilder[]{label("Cups", 4), emptyCell(2), textCell(anexo2335Dto.getAnexo3().getCupsDetalle().get(this.index).getCodigoCups(), 6), emptyCell(1)}).add(new ComponentBuilder[]{label("Nombre", 5), emptyCell(2), textCell(anexo2335Dto.getAnexo3().getCupsDetalle().get(this.index).getNombreCups(), 6), emptyCell(1)}).add(new ComponentBuilder[]{label("Cantidad requerida", 8), emptyCell(2), textCell(anexo2335Dto.getAnexo5().getCupsDetalle().get(this.index).getCantidadRequerida(), 3)}).newRow(1);
        this.index++;
    }

    private /* synthetic */ void lambda$Anexo$7(ListaCumDetalleDto cumDetalle) {
        Map<String, String> detalleMap = new HashMap<>();
        detalleMap.put("codigo", cumDetalle.getCodigoImuCum());
        detalleMap.put("cantidad", cumDetalle.getCantidadRequeridaImuCum());
        detalleMap.put("tipo", "CUM");
        this.detallesCombinados.add(detalleMap);
    }

    private /* synthetic */ void lambda$Anexo$8(ListaCodigoOtrosDto otrosDetalle) {
        Map<String, String> detalleMap = new HashMap<>();
        detalleMap.put("codigo", otrosDetalle.getCodigoOtrosServicios());
        detalleMap.put("cantidad", otrosDetalle.getCantidadOtrosServicios());
        detalleMap.put("tipo", "OtroServicio");
        this.detallesCombinados.add(detalleMap);
    }

    private /* synthetic */ void lambda$Anexo$9(Map detalle) {
        this.datelleOtroServicios.add(new ComponentBuilder[]{label(((String) detalle.get("tipo")) + " Código", 8), emptyCell(2), textCell((String) detalle.get("codigo"), 20), emptyCell(1)}).add(new ComponentBuilder[]{label("Cantidad requerida", 8), emptyCell(2), textCell((String) detalle.get("cantidad"), 3)}).newRow(2);
    }

    private /* synthetic */ void lambda$Anexo$10(Anexo2335Dto anexo2335Dto, ListaCupsDetalleDto cupsDetalle) {
        this.datelleCups.add(new ComponentBuilder[]{label("Grupo de servicios", 10), emptyCell(2), textCell(anexo2335Dto.getAnexo5().getCupsDetalle().get(this.index).getGrupoServicios(), 2), emptyCell(1)}).add(new ComponentBuilder[]{label("Código del servicio", 10), emptyCell(2), textCell(anexo2335Dto.getAnexo5().getCupsDetalle().get(this.index).getCodigoServicio(), 4), emptyCell(1)}).add(new ComponentBuilder[]{label("Finalidad de la tecnología", 10), emptyCell(2), textCell(anexo2335Dto.getAnexo5().getCupsDetalle().get(this.index).getFinalidadTecnologia(), 2)}).newRow(2).add(new ComponentBuilder[]{label("Código                                             Nombre                                                           Cantidad", 55), emptyCell(2), emptyCell(1)}).newRow(1).add(new ComponentBuilder[]{label("Cups", 4), emptyCell(2), textCell(anexo2335Dto.getAnexo5().getCupsDetalle().get(this.index).getCodigoCups(), 6), emptyCell(1)}).add(new ComponentBuilder[]{label("Cantidad requerida", 8), emptyCell(2), textCell(anexo2335Dto.getAnexo5().getCupsDetalle().get(this.index).getCantidadRequerida(), 3), emptyCell(1)}).newRow(2);
        this.index++;
    }

    private /* synthetic */ void lambda$Anexo$11(Anexo2335Dto anexo2335Dto, ListaCupsDetalleDto cupsDetalle) {
        this.datelleCups.add(new ComponentBuilder[]{label("Grupo de servicios", 10), emptyCell(2), textCell(anexo2335Dto.getAnexo6().getCupsDetalle().get(this.index).getGrupoServicios(), 2)}).add(new ComponentBuilder[]{label("Código del servicio", 10), emptyCell(2), textCell(anexo2335Dto.getAnexo6().getCupsDetalle().get(this.index).getCodigoServicio(), 4), emptyCell(1)}).add(new ComponentBuilder[]{label("Finalidad de la tecnología", 10), emptyCell(2), textCell(anexo2335Dto.getAnexo6().getCupsDetalle().get(this.index).getFinalidadTecnologia(), 2)}).newRow(2).add(new ComponentBuilder[]{label("Código                                             Nombre                                                          Cantidad", 55), emptyCell(2), emptyCell(1)}).newRow(1).add(new ComponentBuilder[]{label("Cups", 4), emptyCell(2), textCell(anexo2335Dto.getAnexo6().getCupsDetalle().get(this.index).getCodigoCups(), 6), emptyCell(1)}).add(new ComponentBuilder[]{label("Cantidad requerida", 8), emptyCell(2), textCell(anexo2335Dto.getAnexo6().getCupsDetalle().get(this.index).getCantidadRequerida(), 3)}).newRow(1);
        this.index++;
    }

    private HorizontalListBuilder textCell(String text, int size) {
        HorizontalListBuilder list = DynamicReports.cmp.horizontalList();
        String cellText = StringUtils.rightPad(text, size);
        for (char character : StringUtils.left(cellText, size).toCharArray()) {
            list.add(new ComponentBuilder[]{(TextFieldBuilder) DynamicReports.cmp.text(String.valueOf(character)).setStyle(this.cellStyle).setFixedDimension(10, 10)});
        }
        return list;
    }

    private HorizontalListBuilder textCell2(String text, int size) {
        HorizontalListBuilder list = DynamicReports.cmp.horizontalList();
        String cellText = StringUtils.rightPad(text, size);
        for (char character : StringUtils.left(cellText, size).toCharArray()) {
            list.add(new ComponentBuilder[]{(TextFieldBuilder) DynamicReports.cmp.text(String.valueOf(character)).setStyle(this.cellStyle).setFixedDimension(10, 10)});
        }
        return list;
    }

    private HorizontalListBuilder textCellSalto(String text, int totalCells, int cellsPerRow) {
        HorizontalListBuilder list = DynamicReports.cmp.horizontalList();
        int cellCount = 0;
        for (int i = 0; i < text.length(); i++) {
            char character = text.charAt(i);
            list.add(new ComponentBuilder[]{(TextFieldBuilder) DynamicReports.cmp.text(String.valueOf(character)).setStyle(this.cellStyle).setFixedDimension(10, 10)});
            cellCount++;
            if (cellCount % cellsPerRow == 0 && cellCount < totalCells) {
                list.newRow();
            }
            if (cellCount >= totalCells) {
                break;
            }
        }
        while (cellCount < totalCells) {
            list.add(new ComponentBuilder[]{DynamicReports.cmp.text("").setStyle(this.cellStyle).setFixedDimension(10, 10)});
            cellCount++;
            if (cellCount % cellsPerRow == 0 && cellCount < totalCells) {
                list.newRow(1);
            }
        }
        return list;
    }

    private FillerBuilder emptyCell(int size) {
        return DynamicReports.cmp.gap(10 * size, 10);
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
        componentBuilderArr4[0] = textCell(xtipoDoc.equals("TI") ? "X" : "", 1);
        componentBuilderArr4[1] = label("TI", 2, this.textStyle);
        HorizontalListBuilder horizontalListBuilderAdd5 = horizontalListBuilderAdd4.add(componentBuilderArr4);
        ComponentBuilder[] componentBuilderArr5 = new ComponentBuilder[2];
        componentBuilderArr5[0] = textCell(xtipoDoc.equals("RC") ? "X" : "", 1);
        componentBuilderArr5[1] = label("RC", 2, this.textStyle);
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
        componentBuilderArr8[0] = textCell(xtipoDoc.equals("CD") ? "X" : "", 1);
        componentBuilderArr8[1] = label("CD", 2, this.textStyle);
        HorizontalListBuilder horizontalListBuilderAdd9 = horizontalListBuilderAdd8.add(componentBuilderArr8);
        ComponentBuilder[] componentBuilderArr9 = new ComponentBuilder[2];
        componentBuilderArr9[0] = textCell(xtipoDoc.equals("CN") ? "X" : "", 1);
        componentBuilderArr9[1] = label("CN", 2, this.textStyle);
        HorizontalListBuilder horizontalListBuilderAdd10 = horizontalListBuilderAdd9.add(componentBuilderArr9);
        ComponentBuilder[] componentBuilderArr10 = new ComponentBuilder[2];
        componentBuilderArr10[0] = textCell(xtipoDoc.equals("PT") ? "X" : "", 1);
        componentBuilderArr10[1] = label("PT", 2, this.textStyle);
        HorizontalListBuilder horizontalListBuilderAdd11 = horizontalListBuilderAdd10.add(componentBuilderArr10);
        ComponentBuilder[] componentBuilderArr11 = new ComponentBuilder[2];
        componentBuilderArr11[0] = textCell(xtipoDoc.equals("PE") ? "X" : "", 1);
        componentBuilderArr11[1] = label("PE", 2, this.textStyle);
        HorizontalListBuilder horizontalListBuilderAdd12 = horizontalListBuilderAdd11.add(componentBuilderArr11);
        ComponentBuilder[] componentBuilderArr12 = new ComponentBuilder[2];
        componentBuilderArr12[0] = textCell(xtipoDoc.equals("SC") ? "X" : "", 1);
        componentBuilderArr12[1] = label("SC", 2, this.textStyle);
        HorizontalListBuilder horizontalListBuilderAdd13 = horizontalListBuilderAdd12.add(componentBuilderArr12);
        ComponentBuilder[] componentBuilderArr13 = new ComponentBuilder[2];
        componentBuilderArr13[0] = textCell(xtipoDoc.equals("DE") ? "X" : "", 1);
        componentBuilderArr13[1] = label("DE", 2, this.textStyle);
        HorizontalListBuilder list = horizontalListBuilderAdd13.add(componentBuilderArr13);
        return list;
    }

    private HorizontalListBuilder TipoAnexo(String xtipoAnexo) {
        HorizontalListBuilder horizontalListBuilderHorizontalList = DynamicReports.cmp.horizontalList();
        ComponentBuilder[] componentBuilderArr = new ComponentBuilder[3];
        componentBuilderArr[0] = textCell(xtipoAnexo.equals("1") ? "X" : "", 1);
        componentBuilderArr[1] = label("1.ACTUALIZACIÓN DE DATOS DE CONTACTO", 18, this.textStyle);
        componentBuilderArr[2] = emptyCell(1);
        HorizontalListBuilder horizontalListBuilderAdd = horizontalListBuilderHorizontalList.add(componentBuilderArr);
        ComponentBuilder[] componentBuilderArr2 = new ComponentBuilder[2];
        componentBuilderArr2[0] = textCell(xtipoAnexo.equals("2") ? "X" : "", 1);
        componentBuilderArr2[1] = label("2.INFORME DE ATENCIÓN DE URGENCIA", 18, this.textStyle);
        HorizontalListBuilder horizontalListBuilderNewRow = horizontalListBuilderAdd.add(componentBuilderArr2).newRow(1);
        ComponentBuilder[] componentBuilderArr3 = new ComponentBuilder[3];
        componentBuilderArr3[0] = textCell(xtipoAnexo.equals("3") ? "X" : "", 1);
        componentBuilderArr3[1] = label("3.SOLICITUD DE AUTORIZACION SERVICIO Y TECNOLOGÍAS EN SALUD", 26, this.textStyle);
        componentBuilderArr3[2] = emptyCell(1);
        HorizontalListBuilder horizontalListBuilderAdd2 = horizontalListBuilderNewRow.add(componentBuilderArr3);
        ComponentBuilder[] componentBuilderArr4 = new ComponentBuilder[2];
        componentBuilderArr4[0] = textCell(xtipoAnexo.equals("4") ? "X" : "", 1);
        componentBuilderArr4[1] = label("4.AUTORIZACION DE SERVICIO Y TECNOLOGÍAS EN SALUD", 23, this.textStyle);
        HorizontalListBuilder horizontalListBuilderNewRow2 = horizontalListBuilderAdd2.add(componentBuilderArr4).newRow(1);
        ComponentBuilder[] componentBuilderArr5 = new ComponentBuilder[3];
        componentBuilderArr5[0] = textCell(xtipoAnexo.equals("5") ? "X" : "", 1);
        componentBuilderArr5[1] = label("5.REFERENCIA", 6, this.textStyle);
        componentBuilderArr5[2] = emptyCell(1);
        HorizontalListBuilder horizontalListBuilderAdd3 = horizontalListBuilderNewRow2.add(componentBuilderArr5);
        ComponentBuilder[] componentBuilderArr6 = new ComponentBuilder[2];
        componentBuilderArr6[0] = textCell(xtipoAnexo.equals("6") ? "X" : "", 1);
        componentBuilderArr6[1] = label("6.CONTRAREFERENCIA", 9, this.textStyle);
        HorizontalListBuilder list = horizontalListBuilderAdd3.add(componentBuilderArr6);
        return list;
    }
}
