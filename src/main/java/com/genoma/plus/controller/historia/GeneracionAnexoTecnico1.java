package com.genoma.plus.controller.historia;

import Acceso.Principal;
import Utilidades.Metodos;
import com.genoma.plus.jpa.projection.IInformacionReporteAnexo1;
import com.genoma.plus.jpa.service.IIngresoAnexo1Service;
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

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/historia/GeneracionAnexoTecnico1.class */
public class GeneracionAnexoTecnico1 {
    static PdfReader reader;
    static PdfStamper stamper;
    static BaseFont bf;
    static PdfContentByte over;
    public Metodos metodo = new Metodos();
    private final IIngresoAnexo1Service ingresoAnexo1Service = (IIngresoAnexo1Service) Principal.contexto.getBean(IIngresoAnexo1Service.class);
    private IInformacionReporteAnexo1 informacionReporteAnexo1;
    private Long idAnexo;

    @Generated
    public void setMetodo(Metodos metodo) {
        this.metodo = metodo;
    }

    @Generated
    public void setInformacionReporteAnexo1(IInformacionReporteAnexo1 informacionReporteAnexo1) {
        this.informacionReporteAnexo1 = informacionReporteAnexo1;
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
    public IIngresoAnexo1Service getIngresoAnexo1Service() {
        return this.ingresoAnexo1Service;
    }

    @Generated
    public IInformacionReporteAnexo1 getInformacionReporteAnexo1() {
        return this.informacionReporteAnexo1;
    }

    @Generated
    public Long getIdAnexo() {
        return this.idAnexo;
    }

    public GeneracionAnexoTecnico1(Long idAnexo) {
        setIdAnexo(idAnexo);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.itextpdf.text.DocumentException */
    public void generarPdf() throws DocumentException {
        this.informacionReporteAnexo1 = this.ingresoAnexo1Service.informacionAnexoTecnico1PorId(getIdAnexo());
        File archivo = new File(getMetodo().getRutaRep() + "AnexoTecnico_1.pdf");
        if (this.informacionReporteAnexo1 != null && archivo != null) {
            try {
                datosBase("new_AnexoTecnico1", getMetodo().getRutaRep() + "AnexoTecnico_1.pdf", 1);
                stamper.close();
                mostrarPdf(this.metodo.getRutaRep() + "new_AnexoTecnico1.pdf");
            } catch (DocumentException | IOException ex) {
                Logger.getLogger(GeneracionAnexoTecnico1.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        }
    }

    private void datosBase(String nArchivo, String rutaOrigen, int pagina) throws DocumentException {
        try {
            reader = new PdfReader(rutaOrigen);
            stamper = new PdfStamper(reader, new FileOutputStream(this.metodo.getRutaRep() + nArchivo + ".pdf"));
            bf = BaseFont.createFont("Helvetica-Bold", "Cp1252", false);
            over = stamper.getOverContent(pagina);
            over.beginText();
            over.setFontAndSize(bf, 6.0f);
            LlenarCasillas(this.informacionReporteAnexo1.getNumeroConsecutivo(), 4, 308, 609);
            campo(this.informacionReporteAnexo1.getIps_Nombre(), 90, 580);
            tipoDocumento_IPS(this.informacionReporteAnexo1.getIps_TipoIdentificacion());
            LlenarCasillas(this.informacionReporteAnexo1.getIps_NumeroIdentificacion(), 10, 416, 588);
            LlenarCasillas(this.informacionReporteAnexo1.getIps_DigitoVerificacion(), 1, 507, 588);
            LlenarCasillas(this.informacionReporteAnexo1.getFecha(), 10, 367, 609);
            LlenarCasillas(this.informacionReporteAnexo1.getHora(), 5, 475, 609);
            LlenarCasillas(this.informacionReporteAnexo1.getIps_CodigoHabilitacion(), this.informacionReporteAnexo1.getIps_CodigoHabilitacion().length(), 130, 570);
            campo(this.informacionReporteAnexo1.getIps_Direccion(), 230, 558);
            LlenarCasillas(this.informacionReporteAnexo1.getIps_Telefono(), this.informacionReporteAnexo1.getIps_Telefono().length(), 170, 558);
            campo(this.informacionReporteAnexo1.getIps_NombreDepartamento(), 270, 548);
            LlenarCasillas(this.informacionReporteAnexo1.getIps_CodigoDepartamento(), this.informacionReporteAnexo1.getIps_CodigoDepartamento().length(), 350, 548);
            campo(this.informacionReporteAnexo1.getIps_NombreMunicipio(), 400, 548);
            LlenarCasillas(this.informacionReporteAnexo1.getIps_CodigoMunicipio(), this.informacionReporteAnexo1.getIps_CodigoMunicipio().length(), 490, 548);
            campo(this.informacionReporteAnexo1.getNombreEntidad(), 210, 533);
            LlenarCasillas(this.informacionReporteAnexo1.getCodigoEntidad(), this.informacionReporteAnexo1.getCodigoEntidad().length(), 465, 533);
            tipoInconsistencia(this.informacionReporteAnexo1.getTipoInconsistecia());
            campo(this.informacionReporteAnexo1.getPrimerApellido(), 90, 487);
            campo(this.informacionReporteAnexo1.getSegundoApellido(), 195, 487);
            campo(this.informacionReporteAnexo1.getPrimerNombre(), 300, 487);
            campo(this.informacionReporteAnexo1.getSegundoNombre(), 408, 487);
            tipoDocumentoUsuario(this.informacionReporteAnexo1.getIdTipoIdentificacion());
            LlenarCasillas(this.informacionReporteAnexo1.getNumeroIdentificacion(), this.informacionReporteAnexo1.getNumeroIdentificacion().length(), 352, 456);
            LlenarCasillas(this.informacionReporteAnexo1.getFechaNacimiento(), this.informacionReporteAnexo1.getFechaNacimiento().length(), 408, 426);
            campo(this.informacionReporteAnexo1.getDireccion(), 175, 415);
            LlenarCasillas(this.informacionReporteAnexo1.getTelefono(), this.informacionReporteAnexo1.getTelefono().length(), 432, 415);
            campo(this.informacionReporteAnexo1.getUsuario_NombreDepartamento(), 132, 404);
            LlenarCasillas(this.informacionReporteAnexo1.getIps_CodigoDepartamento(), this.informacionReporteAnexo1.getIps_CodigoDepartamento().length(), 285, 404);
            campo(this.informacionReporteAnexo1.getIps_NombreMunicipio(), 329, 404);
            LlenarCasillas(this.informacionReporteAnexo1.getIps_CodigoMunicipio(), this.informacionReporteAnexo1.getIps_CodigoMunicipio().length(), 490, 404);
            tipoRegimen(this.informacionReporteAnexo1.getIdRegimen());
            List<String> listObservacion = this.metodo.dividirEnLineas(this.informacionReporteAnexo1.getObservacion(), 105);
            System.out.println("List :" + listObservacion.size());
            if (!listObservacion.isEmpty()) {
                switch (listObservacion.size()) {
                    case 1:
                        campo(listObservacion.get(0), 90, 246);
                        break;
                    case 2:
                        campo(listObservacion.get(0), 90, 246);
                        campo(listObservacion.get(1), 90, 235);
                        break;
                    case 3:
                        campo(listObservacion.get(0), 90, 246);
                        campo(listObservacion.get(1), 90, 235);
                        campo(listObservacion.get(2), 90, 224);
                        break;
                }
            }
            campo(this.informacionReporteAnexo1.getNombreUsuarioReporta(), 90, 189);
            campo(this.informacionReporteAnexo1.getCargoUsuarioReporta(), 150, 178);
            LlenarCasillas(this.informacionReporteAnexo1.getTelefonoPersonaReporta(), this.informacionReporteAnexo1.getTelefonoPersonaReporta().length(), 408, 200);
            LlenarCasillas(this.informacionReporteAnexo1.getCelularPersonaReporta(), this.informacionReporteAnexo1.getCelularPersonaReporta().length(), 432, 178);
            verificacionCambios();
            over.endText();
        } catch (IOException ex) {
            Logger.getLogger(GeneracionAnexoTecnico1.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void verificacionCambios() {
        if (!this.informacionReporteAnexo1.getPrimerApellido().equals(this.informacionReporteAnexo1.getPrimerApellidoInconsistencia())) {
            campo("X", 87, 330);
            LlenarCasillas(this.informacionReporteAnexo1.getPrimerApellidoInconsistencia(), this.informacionReporteAnexo1.getPrimerApellidoInconsistencia().length(), 293, 330);
        }
        if (!this.informacionReporteAnexo1.getSegundoApellido().equals(this.informacionReporteAnexo1.getSegundoApellidoInconsistencia())) {
            campo("X", 87, 318);
            LlenarCasillas(this.informacionReporteAnexo1.getSegundoApellidoInconsistencia(), this.informacionReporteAnexo1.getSegundoApellidoInconsistencia().length(), 293, 318);
        }
        if (!this.informacionReporteAnexo1.getPrimerNombre().equals(this.informacionReporteAnexo1.getPrimerNombreInconsistencia())) {
            campo("X", 87, 308);
            LlenarCasillas(this.informacionReporteAnexo1.getPrimerNombreInconsistencia(), this.informacionReporteAnexo1.getPrimerNombreInconsistencia().length(), 293, 308);
        }
        if (!this.informacionReporteAnexo1.getSegundoNombre().equals(this.informacionReporteAnexo1.getSegundoNombreInconsistencia())) {
            campo("X", 87, 296);
            LlenarCasillas(this.informacionReporteAnexo1.getSegundoNombreInconsistencia(), this.informacionReporteAnexo1.getSegundoNombreInconsistencia().length(), 293, 296);
        }
        if (!this.informacionReporteAnexo1.getIdTipoIdentificacion().equals(this.informacionReporteAnexo1.getIdTipoIdentificacionInconsistencia())) {
            campo("X", 87, 286);
            LlenarCasillas(this.informacionReporteAnexo1.getIdTipoIdentificacionInconsistencia(), this.informacionReporteAnexo1.getIdTipoIdentificacionInconsistencia().length(), 332, 286);
        }
        System.out.println("Cedula : " + this.informacionReporteAnexo1.getNumeroIdentificacion());
        System.out.println("Cedula Incosistencia : " + this.informacionReporteAnexo1.getNumeroIdentificacionInconsistencia());
        if (!this.informacionReporteAnexo1.getNumeroIdentificacion().trim().equals(this.informacionReporteAnexo1.getNumeroIdentificacionInconsistencia())) {
            campo("X", 87, 275);
            LlenarCasillas(this.informacionReporteAnexo1.getNumeroIdentificacionInconsistencia(), this.informacionReporteAnexo1.getNumeroIdentificacionInconsistencia().length(), 392, 275);
        }
        if (!this.informacionReporteAnexo1.getFechaNacimiento().equals(this.informacionReporteAnexo1.getFechaNacimientoInconsistencia())) {
            campo("X", 87, 265);
            LlenarCasillas(this.informacionReporteAnexo1.getFechaNacimientoInconsistencia(), this.informacionReporteAnexo1.getFechaNacimientoInconsistencia().length(), 308, 265);
        }
    }

    private void tipoDocumento_IPS(String xTipoDocumento) {
        if (!xTipoDocumento.isEmpty()) {
            switch (xTipoDocumento) {
                case "NI":
                    campo("X", 399, 588);
                    break;
                case "CC":
                    campo("X", 399, 580);
                    break;
            }
        }
    }

    private void tipoInconsistencia(Integer tipo) {
        switch (tipo.intValue()) {
            case 0:
                campo("X", 170, 520);
                break;
            case 1:
                campo("X", 170, 510);
                break;
        }
    }

    private void tipoDocumentoUsuario(String tipoDocumento) {
        switch (tipoDocumento) {
            case "RC":
                campo("X", 87, 456);
                break;
            case "TI":
                campo("X", 87, 444);
                break;
            case "CC":
                campo("X", 87, 436);
                break;
            case "CE":
                campo("X", 87, 426);
                break;
            case "PA":
                campo("X", 186, 456);
                break;
            case "AS":
                campo("X", 186, 444);
                break;
            case "MS":
                campo("X", 186, 436);
                break;
            case "CD":
                campo("X", 186, 426);
                break;
        }
    }

    private void tipoRegimen(String idRegimen) {
        System.out.println("" + idRegimen);
        switch (idRegimen) {
            case "1":
                campo("X", 87, 378);
                break;
            case "2":
                campo("X", 87, 368);
                break;
            case "3":
                campo("X", 178, 378);
                break;
            case "4":
                campo("X", 178, 368);
                break;
            case "5":
                campo("X", 310, 378);
                break;
            case "6":
                campo("X", 310, 368);
                break;
            case "7":
                campo("X", 424, 378);
                break;
            case "8":
                campo("X", 424, 368);
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
                Logger.getLogger(GeneracionAnexoTecnico1.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        }
    }
}
