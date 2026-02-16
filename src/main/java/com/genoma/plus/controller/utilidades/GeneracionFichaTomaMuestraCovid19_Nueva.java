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

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/utilidades/GeneracionFichaTomaMuestraCovid19_Nueva.class */
public final class GeneracionFichaTomaMuestraCovid19_Nueva {
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

    public GeneracionFichaTomaMuestraCovid19_Nueva(Long idAnexo) {
        setIdAnexo(idAnexo);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.itextpdf.text.DocumentException */
    public void generarPdf() throws DocumentException {
        this.informacionFichaTomaMuestraCovid = this.ingresoPruebaCovidService.consultaInformeFichaCovidPDF(getIdAnexo());
        File archivo = new File(getMetodo().getRutaRep() + "Plantilla_seguimiento_covid19_Consentimiento_N.pdf");
        if (this.informacionFichaTomaMuestraCovid != null && archivo != null) {
            try {
                datosBase("new_SeguimientoCovid", getMetodo().getRutaRep() + "Plantilla_seguimiento_covid19_Consentimiento_N.pdf", 1);
                datosBasicos1();
                datosBasicos2();
                stamper.close();
                mostrarPdf(this.metodo.getRutaRep() + "new_SeguimientoCovid.pdf");
            } catch (DocumentException | IOException ex) {
                Logger.getLogger(GeneracionFichaTomaMuestraCovid19_Nueva.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        }
    }

    private void datosBasicos2() throws DocumentException, IOException {
        over = stamper.getOverContent(3);
        over.beginText();
        over.setFontAndSize(bf, 8.0f);
        campo(this.informacionFichaTomaMuestraCovid.getFechaIngreso(), 200, 640);
        campo(this.informacionFichaTomaMuestraCovid.getNombreUsuario(), 200, 625);
        campo(this.informacionFichaTomaMuestraCovid.getEdad() + " " + this.informacionFichaTomaMuestraCovid.getTipoEdad(), 490, 625);
        campo(this.informacionFichaTomaMuestraCovid.getTipoDocumento() + " - " + this.informacionFichaTomaMuestraCovid.getNumeroDocumento(), 200, 610);
        campo(this.informacionFichaTomaMuestraCovid.getNombreEntidad(), 200, 580);
        campo(this.informacionFichaTomaMuestraCovid.getEmpresaTrabaja(), 200, 565);
        over.setFontAndSize(bf, 6.0f);
        campo(this.informacionFichaTomaMuestraCovid.getCodigoOcupacion() + " - " + this.informacionFichaTomaMuestraCovid.getNombreOcupacion(), 200, 595);
        over.endText();
    }

    private void datosBasicos1() throws DocumentException, IOException {
        over = stamper.getOverContent(2);
        over.beginText();
        over.setFontAndSize(bf, 8.0f);
        campo(this.informacionFichaTomaMuestraCovid.getNombreUsuario(), 30, 875);
        campo(this.informacionFichaTomaMuestraCovid.getTipoDocumento(), 280, 875);
        campo(this.informacionFichaTomaMuestraCovid.getNumeroDocumento(), 360, 875);
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
            LlenarCasillas(this.informacionFichaTomaMuestraCovid.getCodigoOrganismo().replaceAll("", " ").trim().substring(0, 3), 3, 30, 640);
            LlenarCasillas(this.informacionFichaTomaMuestraCovid.getCodigoOrganismo().replaceAll("", " ").trim().substring(3, 9), 6, 66, 640);
            LlenarCasillas(this.informacionFichaTomaMuestraCovid.getCodigoOrganismo().replaceAll("", " ").trim().substring(9, 19), 10, 123, 640);
            LlenarCasillas(this.informacionFichaTomaMuestraCovid.getCodigoOrganismo().replaceAll("", " ").trim().substring(19, 23), 4, 220, 640);
            campo(this.informacionFichaTomaMuestraCovid.getNombreIps(), 270, 640);
            tipoDocumento(this.informacionFichaTomaMuestraCovid.getTipoDocumento());
            campo(this.informacionFichaTomaMuestraCovid.getNumeroDocumento(), 300, 545);
            campo(this.informacionFichaTomaMuestraCovid.getNombreUsuario(), 25, 505);
            campo(this.informacionFichaTomaMuestraCovid.getTelefono(), 500, 505);
            LlenarCasillas(this.informacionFichaTomaMuestraCovid.getFechaNacimiento().replaceAll("", " ").trim().substring(0, 4), 4, 26, 472);
            LlenarCasillas(this.informacionFichaTomaMuestraCovid.getFechaNacimiento().replaceAll("", " ").trim().substring(4, 8), 4, 69, 472);
            LlenarCasillas(this.informacionFichaTomaMuestraCovid.getFechaNacimiento().replaceAll("", " ").trim().substring(8, 15), 7, 114, 472);
            campo(this.informacionFichaTomaMuestraCovid.getEdad(), 190, 472);
            tipoEdad(this.informacionFichaTomaMuestraCovid.getTipoEdad());
            tipoSexo(this.informacionFichaTomaMuestraCovid.getSexo());
            LlenarCasillas(this.informacionFichaTomaMuestraCovid.getCodigoPaisNacimiento().replaceAll("", " ").trim(), 5, 552, 484);
            campo(this.informacionFichaTomaMuestraCovid.getNombrePaisNacimiento(), 500, 470);
            LlenarCasillas(this.informacionFichaTomaMuestraCovid.getCodigoPaisResidencia().replaceAll("", " ").trim(), 5, 145, 440);
            campo(this.informacionFichaTomaMuestraCovid.getNombrePaisResidencia(), 25, 430);
            LlenarCasillas(this.informacionFichaTomaMuestraCovid.getCodigoDepartamentoResidencia().replaceAll("", " ").trim(), 3, 349, 432);
            LlenarCasillas(this.informacionFichaTomaMuestraCovid.getCodigoMunicipioResidencia().replaceAll("", " ").trim(), 5, 393, 432);
            tipoZona(this.informacionFichaTomaMuestraCovid.getZona());
            campo(this.informacionFichaTomaMuestraCovid.getNombreBarrio(), 170, 397);
            campo(this.informacionFichaTomaMuestraCovid.getDireccionResidencia(), 25, 397);
            LlenarCasillas(this.informacionFichaTomaMuestraCovid.getCodigoOcupacion().replaceAll("", " ").trim(), 7, 145, 370);
            tipoRegimen(this.informacionFichaTomaMuestraCovid.getIdTipoRegimen());
            if (!this.informacionFichaTomaMuestraCovid.getCodigoEntidad().isEmpty() && this.informacionFichaTomaMuestraCovid.getCodigoEntidad().length() == 6) {
                LlenarCasillas(this.informacionFichaTomaMuestraCovid.getCodigoEntidad().replaceAll("", " ").trim(), 11, 498, 369);
            }
            over.setFontAndSize(bf, 6.0f);
            campo(this.informacionFichaTomaMuestraCovid.getNombreEntidad(), 400, 357);
            over.setFontAndSize(bf, 8.0f);
            campo(this.informacionFichaTomaMuestraCovid.getNombreMunicipioResidencia() + " - " + this.informacionFichaTomaMuestraCovid.getNombreDepartamentoResiedencia().toUpperCase(), 285, 248);
            campo("X", 40, 252);
            LlenarCasillas(this.informacionFichaTomaMuestraCovid.getCodigoDepartamentoResidencia().replaceAll("", " ").trim(), 3, 498, 248);
            LlenarCasillas(this.informacionFichaTomaMuestraCovid.getCodigoMunicipioResidencia().replaceAll("", " ").trim(), 5, 542, 248);
            campo(this.informacionFichaTomaMuestraCovid.getDireccionResidencia(), 40, 221);
            over.endText();
        } catch (IOException ex) {
            Logger.getLogger(GeneracionFichaTomaMuestraCovid19_Nueva.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void tipoDocumento(String xTipoDocumento) {
        if (!xTipoDocumento.isEmpty()) {
            switch (xTipoDocumento) {
                case "RC":
                    campo("X", 25, 545);
                    break;
                case "TI":
                    campo("X", 57, 545);
                    break;
                case "CC":
                    campo("X", 84, 545);
                    break;
                case "CE":
                    campo("X", 115, 545);
                    break;
                case "PA":
                    campo("X", 149, 545);
                    break;
                case "MS":
                    campo("X", 184, 545);
                    break;
                case "AS":
                    campo("X", 222, 545);
                    break;
                case "PE":
                    campo("X", 255, 545);
                    break;
            }
        }
    }

    private void tipoEdad(String tipoEdad) {
        if (!tipoEdad.isEmpty()) {
            switch (tipoEdad) {
                case "Año(s)":
                    campo("X", 233, 478);
                    break;
                case "Mes(es)":
                    campo("X", 233, 466);
                    break;
                case "Día(s)":
                    campo("X", 282, 478);
                    break;
            }
        }
    }

    private void tipoSexo(String sexo) {
        if (!sexo.isEmpty()) {
            switch (sexo) {
                case "M":
                    campo("X", 383, 478);
                    break;
                case "F":
                    campo("X", 383, 466);
                    break;
                default:
                    campo("X", 436, 478);
                    break;
            }
        }
    }

    private void tipoZona(String zona) {
        if (!zona.isEmpty()) {
            switch (zona) {
                case "U":
                    campo("X", 447, 440);
                    break;
                case "R":
                    campo("X", 535, 440);
                    break;
                default:
                    campo("X", 436, 478);
                    break;
            }
        }
    }

    private void tipoRegimen(Integer tipo) {
        switch (tipo.intValue()) {
            case 1:
                campo("X", 259, 374);
                break;
            case 2:
                campo("X", 259, 362);
                break;
            case 3:
                campo("X", 314, 362);
                break;
            case 4:
                campo("X", 314, 374);
                break;
            case 5:
                campo("X", 213, 374);
                break;
            case 6:
                campo("X", 213, 362);
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
                Logger.getLogger(GeneracionFichaTomaMuestraCovid19_Nueva.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        }
    }
}
