package com.genoma.plus.controller.utilidades;

import Acceso.Principal;
import Utilidades.Metodos;
import com.genoma.plus.jpa.entities.IngresoPruebaCovidDetalleViajeDTO;
import com.genoma.plus.jpa.projection.IInformacionFichaTomaMuestraCovid;
import com.genoma.plus.jpa.service.IIngresoPruebaCovidDetalleViajeService;
import com.genoma.plus.jpa.service.IIngresoPruebaCovidService;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import lombok.Generated;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/utilidades/GeneracionFichaTomaMuestraCovid19.class */
public final class GeneracionFichaTomaMuestraCovid19 {
    static PdfReader reader;
    static PdfStamper stamper;
    static BaseFont bf;
    static PdfContentByte over;
    public Metodos metodo = new Metodos();
    private final IIngresoPruebaCovidService ingresoPruebaCovidService = (IIngresoPruebaCovidService) Principal.contexto.getBean(IIngresoPruebaCovidService.class);
    private final IIngresoPruebaCovidDetalleViajeService ingresoPruebaCovidDetalleViajeService = (IIngresoPruebaCovidDetalleViajeService) Principal.contexto.getBean(IIngresoPruebaCovidDetalleViajeService.class);
    private IInformacionFichaTomaMuestraCovid informacionFichaTomaMuestraCovid;
    private List<IngresoPruebaCovidDetalleViajeDTO> listaInformacionDetalleCovid;
    private Long idAnexo;

    @Generated
    public void setMetodo(Metodos metodo) {
        this.metodo = metodo;
    }

    @Generated
    public void setInformacionFichaTomaMuestraCovid(IInformacionFichaTomaMuestraCovid informacionFichaTomaMuestraCovid) {
        this.informacionFichaTomaMuestraCovid = informacionFichaTomaMuestraCovid;
    }

    @Generated
    public void setListaInformacionDetalleCovid(List<IngresoPruebaCovidDetalleViajeDTO> listaInformacionDetalleCovid) {
        this.listaInformacionDetalleCovid = listaInformacionDetalleCovid;
    }

    @Generated
    public void setIdAnexo(Long idAnexo) {
        this.idAnexo = idAnexo;
    }

    @Generated
    public Metodos getMetodo() {
        return this.metodo;
    }

    @Generated
    public IIngresoPruebaCovidService getIngresoPruebaCovidService() {
        return this.ingresoPruebaCovidService;
    }

    @Generated
    public IIngresoPruebaCovidDetalleViajeService getIngresoPruebaCovidDetalleViajeService() {
        return this.ingresoPruebaCovidDetalleViajeService;
    }

    @Generated
    public IInformacionFichaTomaMuestraCovid getInformacionFichaTomaMuestraCovid() {
        return this.informacionFichaTomaMuestraCovid;
    }

    @Generated
    public List<IngresoPruebaCovidDetalleViajeDTO> getListaInformacionDetalleCovid() {
        return this.listaInformacionDetalleCovid;
    }

    @Generated
    public Long getIdAnexo() {
        return this.idAnexo;
    }

    public GeneracionFichaTomaMuestraCovid19(Long idAnexo) {
        setIdAnexo(idAnexo);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.itextpdf.text.DocumentException */
    public void generarPdf() throws DocumentException {
        this.informacionFichaTomaMuestraCovid = this.ingresoPruebaCovidService.consultaInformeFichaCovidPDF(getIdAnexo());
        File archivo = new File(getMetodo().getRutaRep() + "Plantilla_seguimiento_covid19_Consentimiento.pdf");
        if (this.informacionFichaTomaMuestraCovid != null && archivo != null) {
            try {
                datosBase("new_SeguimientoCovid", getMetodo().getRutaRep() + "Plantilla_seguimiento_covid19_Consentimiento.pdf", 1);
                datosBasicos2();
                stamper.close();
                mostrarPdf(this.metodo.getRutaRep() + "new_SeguimientoCovid.pdf");
            } catch (DocumentException | IOException ex) {
                Logger.getLogger(GeneracionFichaTomaMuestraCovid19.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        }
    }

    private void datosBasicos2() throws DocumentException, IOException {
        over = stamper.getOverContent(2);
        over.beginText();
        over.setFontAndSize(bf, 8.0f);
        campo(this.informacionFichaTomaMuestraCovid.getFechaIngreso(), 200, 640);
        campo(this.informacionFichaTomaMuestraCovid.getNombreUsuario(), 200, 625);
        campo(this.informacionFichaTomaMuestraCovid.getEdad() + " " + this.informacionFichaTomaMuestraCovid.getTipoEdad(), 489, 625);
        campo(this.informacionFichaTomaMuestraCovid.getTipoDocumento() + " - " + this.informacionFichaTomaMuestraCovid.getNumeroDocumento(), 200, 610);
        campo(this.informacionFichaTomaMuestraCovid.getCodigoOcupacion() + " - " + this.informacionFichaTomaMuestraCovid.getNombreOcupacion(), 200, 595);
        campo(this.informacionFichaTomaMuestraCovid.getNombreEntidad(), 200, 580);
        campo(this.informacionFichaTomaMuestraCovid.getEmpresaTrabaja(), 200, 565);
        over.endText();
    }

    private void datosBase(String nArchivo, String rutaOrigen, int pagina) throws DocumentException {
        try {
            reader = new PdfReader(rutaOrigen);
            stamper = new PdfStamper(reader, new FileOutputStream(this.metodo.getRutaRep() + nArchivo + ".pdf"));
            bf = BaseFont.createFont("Helvetica-Bold", "Cp1252", false);
            over = stamper.getOverContent(pagina);
            over.beginText();
            over.setFontAndSize(bf, 8.0f);
            LlenarCasillas(this.informacionFichaTomaMuestraCovid.getFecha().replaceAll("", " ").trim().substring(0, 4), 4, 244, 660);
            LlenarCasillas(this.informacionFichaTomaMuestraCovid.getFecha().replaceAll("", " ").trim().substring(4, 8), 4, 285, 660);
            LlenarCasillas(this.informacionFichaTomaMuestraCovid.getFecha().replaceAll("", " ").trim().substring(8, 15), 7, 330, 660);
            tipoDocumento(this.informacionFichaTomaMuestraCovid.getTipoDocumento());
            campo(this.informacionFichaTomaMuestraCovid.getNumeroDocumento(), 400, 605);
            campo(this.informacionFichaTomaMuestraCovid.getNombreUsuario(), 25, 565);
            campo(this.informacionFichaTomaMuestraCovid.getTelefono(), 500, 565);
            LlenarCasillas(this.informacionFichaTomaMuestraCovid.getFechaNacimiento().replaceAll("", " ").trim().substring(0, 4), 4, 26, 532);
            LlenarCasillas(this.informacionFichaTomaMuestraCovid.getFechaNacimiento().replaceAll("", " ").trim().substring(4, 8), 4, 69, 532);
            LlenarCasillas(this.informacionFichaTomaMuestraCovid.getFechaNacimiento().replaceAll("", " ").trim().substring(8, 15), 7, 114, 532);
            campo(this.informacionFichaTomaMuestraCovid.getEdad(), 190, 532);
            tipoEdad(this.informacionFichaTomaMuestraCovid.getTipoEdad());
            tipoSexo(this.informacionFichaTomaMuestraCovid.getSexo());
            LlenarCasillas(this.informacionFichaTomaMuestraCovid.getCodigoPaisNacimiento().replaceAll("", " ").trim(), 5, 552, 543);
            campo(this.informacionFichaTomaMuestraCovid.getNombrePaisNacimiento(), 500, 524);
            LlenarCasillas(this.informacionFichaTomaMuestraCovid.getCodigoOcupacion().replaceAll("", " ").trim(), 7, 118, 500);
            tipoRegimen(this.informacionFichaTomaMuestraCovid.getIdTipoRegimen());
            if (!this.informacionFichaTomaMuestraCovid.getCodigoEntidad().isEmpty() && this.informacionFichaTomaMuestraCovid.getCodigoEntidad().length() > 6) {
                LlenarCasillas(this.informacionFichaTomaMuestraCovid.getCodigoEntidad().replaceAll("", " ").trim(), 11, 497, 495);
            }
            over.setFontAndSize(bf, 6.0f);
            campo(this.informacionFichaTomaMuestraCovid.getNombreEntidad(), 380, 485);
            over.setFontAndSize(bf, 8.0f);
            campo(this.informacionFichaTomaMuestraCovid.getDireccionResidencia(), 380, 462);
            if (!this.informacionFichaTomaMuestraCovid.getCorreo().isEmpty()) {
                campo(this.informacionFichaTomaMuestraCovid.getCorreo(), 380, 442);
            }
            LlenarCasillas(this.informacionFichaTomaMuestraCovid.getCodigoPaisResidencia().replaceAll("", " ").trim(), 5, 232, 447);
            LlenarCasillas(this.informacionFichaTomaMuestraCovid.getCodigoDepartamentoResidencia().replaceAll("", " ").trim(), 3, 288, 447);
            LlenarCasillas(this.informacionFichaTomaMuestraCovid.getCodigoMunicipioResidencia().replaceAll("", " ").trim(), 5, 330, 447);
            if (this.informacionFichaTomaMuestraCovid.getFechaExposicion().length() > 1 && !this.informacionFichaTomaMuestraCovid.getFechaExposicion().isEmpty()) {
                LlenarCasillas(this.informacionFichaTomaMuestraCovid.getFechaExposicion().replaceAll("", " ").trim().substring(0, 4), 4, 458, 380);
                LlenarCasillas(this.informacionFichaTomaMuestraCovid.getFechaExposicion().replaceAll("", " ").trim().substring(4, 8), 4, 498, 380);
                LlenarCasillas(this.informacionFichaTomaMuestraCovid.getFechaExposicion().replaceAll("", " ").trim().substring(8, 15), 7, 536, 380);
            }
            if (this.informacionFichaTomaMuestraCovid.getTipoContacto().intValue() != -1) {
                tipoContacto(this.informacionFichaTomaMuestraCovid.getTipoContacto());
            }
            over.setFontAndSize(bf, 6.0f);
            if (this.informacionFichaTomaMuestraCovid.getInstitucionLabora() != null) {
                campo(this.informacionFichaTomaMuestraCovid.getInstitucionLabora(), 456, 250);
            }
            over.setFontAndSize(bf, 8.0f);
            if (this.informacionFichaTomaMuestraCovid.getContactoSintomas().intValue() != -1) {
                tipoSintomas(this.informacionFichaTomaMuestraCovid.getContactoSintomas());
            }
            if (this.informacionFichaTomaMuestraCovid.getFechaInicioSintomas().length() > 1 && !this.informacionFichaTomaMuestraCovid.getFechaInicioSintomas().isEmpty()) {
                LlenarCasillas(this.informacionFichaTomaMuestraCovid.getFechaInicioSintomas().replaceAll("", " ").trim().substring(0, 4), 4, 250, 159);
                LlenarCasillas(this.informacionFichaTomaMuestraCovid.getFechaInicioSintomas().replaceAll("", " ").trim().substring(4, 8), 4, 290, 159);
                LlenarCasillas(this.informacionFichaTomaMuestraCovid.getFechaInicioSintomas().replaceAll("", " ").trim().substring(8, 15), 7, 332, 159);
            }
            if (this.informacionFichaTomaMuestraCovid.getHospitalizado().intValue() != -1) {
                tipoHospitalizado(this.informacionFichaTomaMuestraCovid.getHospitalizado());
            }
            if (this.informacionFichaTomaMuestraCovid.getViajo().intValue() != -1) {
                tipoViajo(this.informacionFichaTomaMuestraCovid.getViajo());
            }
            if (this.informacionFichaTomaMuestraCovid.getTomaMuestra().booleanValue()) {
                campo("X", 42, 40);
            } else {
                campo("X", 100, 40);
            }
            if (this.informacionFichaTomaMuestraCovid.getFechaTomaMuestra().length() > 1 && !this.informacionFichaTomaMuestraCovid.getFechaTomaMuestra().isEmpty()) {
                LlenarCasillas(this.informacionFichaTomaMuestraCovid.getFechaTomaMuestra().replaceAll("", " ").trim().substring(0, 4), 4, 220, 42);
                LlenarCasillas(this.informacionFichaTomaMuestraCovid.getFechaTomaMuestra().replaceAll("", " ").trim().substring(4, 8), 4, 260, 42);
                LlenarCasillas(this.informacionFichaTomaMuestraCovid.getFechaTomaMuestra().replaceAll("", " ").trim().substring(8, 15), 7, 305, 42);
            }
            this.listaInformacionDetalleCovid = this.ingresoPruebaCovidDetalleViajeService.findByIdPruebaCovid(this.informacionFichaTomaMuestraCovid.getIdPrueba());
            int x = 1;
            for (IngresoPruebaCovidDetalleViajeDTO next : this.listaInformacionDetalleCovid) {
                switch (x) {
                    case 1:
                        campo(next.getPais(), 50, 360);
                        campo(next.getDepartamento(), 160, 360);
                        campo(next.getMunicipio(), 330, 360);
                        break;
                    case 2:
                        campo(next.getPais(), 50, 325);
                        campo(next.getDepartamento(), 160, 325);
                        campo(next.getMunicipio(), 330, 325);
                        break;
                    case 3:
                        campo(next.getPais(), 50, 293);
                        campo(next.getDepartamento(), 160, 293);
                        campo(next.getMunicipio(), 330, 293);
                        break;
                    case 4:
                        campo(next.getPais(), 50, 260);
                        campo(next.getDepartamento(), 160, 260);
                        campo(next.getMunicipio(), 330, 260);
                        break;
                    case 5:
                        campo(next.getPais(), 50, 228);
                        campo(next.getDepartamento(), 160, 228);
                        campo(next.getMunicipio(), 330, 228);
                        break;
                }
                x++;
            }
            over.endText();
        } catch (IOException ex) {
            Logger.getLogger(GeneracionFichaTomaMuestraCovid19.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void tipoDocumento(String xTipoDocumento) {
        if (!xTipoDocumento.isEmpty()) {
            switch (xTipoDocumento) {
                case "RC":
                    campo("X", 25, 605);
                    break;
                case "TI":
                    campo("X", 57, 605);
                    break;
                case "CC":
                    campo("X", 84, 605);
                    break;
                case "CE":
                    campo("X", 115, 605);
                    break;
                case "PA":
                    campo("X", 149, 605);
                    break;
                case "MS":
                    campo("X", 184, 605);
                    break;
                case "AS":
                    campo("X", 222, 605);
                    break;
                case "PE":
                    campo("X", 255, 605);
                    break;
            }
        }
    }

    private void tipoEdad(String tipoEdad) {
        if (!tipoEdad.isEmpty()) {
            switch (tipoEdad) {
                case "Año(s)":
                    campo("X", 233, 537);
                    break;
                case "Mes(es)":
                    campo("X", 233, 524);
                    break;
                case "Día(s)":
                    campo("X", 282, 537);
                    break;
            }
        }
    }

    private void tipoSexo(String sexo) {
        if (!sexo.isEmpty()) {
            switch (sexo) {
                case "M":
                    campo("X", 383, 537);
                    break;
                case "F":
                    campo("X", 383, 524);
                    break;
                default:
                    campo("X", 436, 537);
                    break;
            }
        }
    }

    private void tipoRegimen(Integer tipo) {
        switch (tipo.intValue()) {
            case 1:
                campo("X", 237, 499);
                break;
            case 2:
                campo("X", 237, 487);
                break;
            case 3:
                campo("X", 294, 499);
                break;
            case 4:
                campo("X", 188, 487);
                break;
            case 5:
                campo("X", 188, 499);
                break;
            case 6:
                campo("X", 294, 487);
                break;
        }
    }

    private void tipoContacto(Integer tipo) {
        switch (tipo.intValue()) {
            case 1:
                campo("X", 456, 343);
                break;
            case 2:
                campo("X", 456, 330);
                break;
            case 3:
                campo("X", 456, 318);
                break;
            case 4:
                campo("X", 456, 307);
                break;
            case 5:
                campo("X", 456, 295);
                break;
        }
    }

    private void tipoSintomas(Integer tipo) {
        switch (tipo.intValue()) {
            case 1:
                campo("X", 48, 159);
                break;
            case 2:
                campo("X", 105, 159);
                break;
        }
    }

    private void tipoHospitalizado(Integer tipo) {
        switch (tipo.intValue()) {
            case 1:
                campo("X", 501, 159);
                break;
            case 2:
                campo("X", 540, 159);
                break;
        }
    }

    private void tipoViajo(Integer tipo) {
        switch (tipo.intValue()) {
            case 1:
                campo("X", 195, 390);
                break;
            case 2:
                campo("X", 250, 390);
                break;
        }
    }

    private void LlenarCasillas(String xtexto, int cont, int x, int y) {
        int sum = x;
        for (int i = 0; i < cont; i++) {
            campo(xtexto.substring(i, 1 + i), sum, y);
            sum += 8;
        }
    }

    private static void campo(String xtexto, int x, int y) {
        over.setTextMatrix(x, y);
        over.showText(xtexto);
    }

    private static void mostrarPdf(String rutaa) {
        File archivo = new File(rutaa);
        if (archivo.exists()) {
            try {
                Desktop d = Desktop.getDesktop();
                d.open(archivo);
            } catch (IOException ex) {
                Logger.getLogger(GeneracionFichaTomaMuestraCovid19.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        }
    }
}
