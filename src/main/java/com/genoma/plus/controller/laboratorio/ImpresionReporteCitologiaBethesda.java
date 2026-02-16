package com.genoma.plus.controller.laboratorio;

import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import Utilidades.MetodosGenericos;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.genoma.plus.controller.general.dto.GenericDomain;
import com.genoma.plus.controller.laboratorio.dto.CitologiaDTO;
import com.genoma.plus.controller.laboratorio.dto.CustomPresenter;
import com.genoma.plus.controller.utilidades.GeneracionFichaTomaMuestraCovid19_Nueva;
import com.genoma.plus.domains.models.domains.general.RecursosMicroserviciosDomain;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.ws.rs.core.Response;
import lombok.Generated;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/laboratorio/ImpresionReporteCitologiaBethesda.class */
public class ImpresionReporteCitologiaBethesda {
    private PdfReader reader;
    private PdfStamper stamper;
    private BaseFont bf;
    private PdfContentByte over;
    private PdfContentByte overLetrapequena6;
    private ConsultasMySQL consulta = new ConsultasMySQL();
    private Metodos metodos = new Metodos();
    private Metodos xmetodo = new Metodos();

    @Generated
    public void setConsulta(ConsultasMySQL consulta) {
        this.consulta = consulta;
    }

    @Generated
    public void setMetodos(Metodos metodos) {
        this.metodos = metodos;
    }

    @Generated
    public void setReader(PdfReader reader) {
        this.reader = reader;
    }

    @Generated
    public void setStamper(PdfStamper stamper) {
        this.stamper = stamper;
    }

    @Generated
    public void setBf(BaseFont bf) {
        this.bf = bf;
    }

    @Generated
    public void setOver(PdfContentByte over) {
        this.over = over;
    }

    @Generated
    public void setOverLetrapequena6(PdfContentByte overLetrapequena6) {
        this.overLetrapequena6 = overLetrapequena6;
    }

    @Generated
    public void setXmetodo(Metodos xmetodo) {
        this.xmetodo = xmetodo;
    }

    @Generated
    public ConsultasMySQL getConsulta() {
        return this.consulta;
    }

    @Generated
    public Metodos getMetodos() {
        return this.metodos;
    }

    @Generated
    public PdfReader getReader() {
        return this.reader;
    }

    @Generated
    public PdfStamper getStamper() {
        return this.stamper;
    }

    @Generated
    public BaseFont getBf() {
        return this.bf;
    }

    @Generated
    public PdfContentByte getOver() {
        return this.over;
    }

    @Generated
    public PdfContentByte getOverLetrapequena6() {
        return this.overLetrapequena6;
    }

    @Generated
    public Metodos getXmetodo() {
        return this.xmetodo;
    }

    public void generarReporte(Long id, Integer mostrarPdf) {
        ResultSet xrs;
        Throwable th;
        ResultSet xrs2;
        Throwable th2;
        ResultSet xrs3;
        Throwable th3;
        try {
            RecursosMicroserviciosDomain microserviciosDomain = this.metodos.getParametrosEncriptados("38", "findCitologia");
            MetodosGenericos<String> metodosGenericos = new MetodosGenericos<>();
            String parametros = String.valueOf(id);
            String fullUrl = microserviciosDomain.getUrlRecurso() + "/" + metodosGenericos.getParametrosEncryptado(parametros);
            Response response = this.metodos.getResteasyClient().target(fullUrl).request().get();
            int statusCode = response.getStatus();
            Boolean esLiquida = getEsLiquida(id);
            String sql = "select if(pcr.idProfesionalEspecialista  is null, false, true) estadoValidado\nfrom p_citologia pc \ninner join p_citologia_resultados pcr on (pc.Id =pcr.Id_Citologia )\ninner join p_citologia_resultado_cestudio pcrc  on (pcrc.Id_RCitologia =pcr.Id )\ninner join p_citologia_conceptoestudio pcc on (pcc.Id=pcrc.Id_ConceptoEstudio )\nwhere pcr.DisponibleCalidad =1  \n and  pcr.Id_Citologia=" + id + " ";
            System.out.println("sql" + sql);
            try {
                xrs3 = this.consulta.traerRs(sql);
                th3 = null;
            } catch (Exception e) {
            }
            try {
                try {
                    if (xrs3.next()) {
                        xrs3.first();
                        if (!xrs3.getBoolean("estadoValidado")) {
                            System.out.println("valido : ");
                            JOptionPane.showMessageDialog((Component) null, "<html><span style='color: red; font-size: medium;'>Procedimiento con alteración, sin validación de patóloga;<br>no se puede visualizar.</span></html>", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                            if (xrs3 != null) {
                                if (0 == 0) {
                                    xrs3.close();
                                    return;
                                }
                                try {
                                    xrs3.close();
                                    return;
                                } catch (Throwable th4) {
                                    th3.addSuppressed(th4);
                                    return;
                                }
                            }
                            return;
                        }
                    }
                    if (xrs3 != null) {
                        if (0 != 0) {
                            try {
                                xrs3.close();
                            } catch (Throwable th5) {
                                th3.addSuppressed(th5);
                            }
                        } else {
                            xrs3.close();
                        }
                    }
                    if (statusCode == 200) {
                        System.out.println("Entrooo ");
                        new CustomPresenter();
                        CustomPresenter presenter = (CustomPresenter) this.metodos.getMapper().readValue((String) response.readEntity(String.class), CustomPresenter.class);
                        CitologiaDTO citologia = (CitologiaDTO) this.metodos.getMapper().readValue(this.metodos.getMapper().writeValueAsString(presenter.getData()), new TypeReference<CitologiaDTO>() { // from class: com.genoma.plus.controller.laboratorio.ImpresionReporteCitologiaBethesda.1
                        });
                        String json = this.metodos.getMapper().writeValueAsString(citologia);
                        String query1 = "select if(pcr.idProfesional=pcr.idProfesionalEspecialista,null,CONCAT(gp2.Apellido1,\" \",gp2.Apellido2,\" \",gp2.Nombre1,\" \",gp2.Nombre2)) as profesional,if(pcr.idProfesional=pcr.idProfesionalEspecialista,null,gpe.Nbre) especialida, if(pcr.idProfesional=pcr.idProfesionalEspecialista,null,gp.DireccionF) DireccionF from g_profesional gp\nleft join g_persona gp2 on gp2.Id = gp.Id_Persona \ninner join p_citologia_resultados pcr on pcr.idProfesionalEspecialista =gp.Id_Persona \ninner join g_especialidad gpe on gpe.Id  = pcr.idEspecialidadProfesionalEspe \nwhere pcr.Id_Citologia ='" + id + "' ";
                        System.out.println(" consulta : " + json);
                        try {
                            xrs2 = this.consulta.traerRs(query1);
                            th2 = null;
                        } catch (Exception e2) {
                        }
                        try {
                            try {
                                if (xrs2.next()) {
                                    xrs2.first();
                                    citologia.setProfesionalEspecialista(xrs2.getString("profesional"));
                                    citologia.setEspecialidadEspecialista(xrs2.getString("especialida"));
                                    citologia.setFirmaProfesionalEspecialista(xrs2.getString("DireccionF"));
                                }
                                if (xrs2 != null) {
                                    if (0 != 0) {
                                        try {
                                            xrs2.close();
                                        } catch (Throwable th6) {
                                            th2.addSuppressed(th6);
                                        }
                                    } else {
                                        xrs2.close();
                                    }
                                }
                                String query2 = "SELECT pcr.Id_Conducta,p_tipo_respuestas_c.Nbre FROM p_citologia_resultados pcr \nLEFT JOIN p_tipo_respuestas_c on\n\t(p_tipo_respuestas_c.Id = pcr.Id_Conducta )\n\twhere Id_Citologia ='" + id + "'\n\tlimit 1";
                                try {
                                    xrs = this.consulta.traerRs(query2);
                                    Throwable th7 = null;
                                    try {
                                        try {
                                            if (xrs.next()) {
                                                xrs.first();
                                                citologia.setNCConducta(xrs.getString("Nbre"));
                                            }
                                            if (xrs != null) {
                                                if (0 != 0) {
                                                    try {
                                                        xrs.close();
                                                    } catch (Throwable th8) {
                                                        th7.addSuppressed(th8);
                                                    }
                                                } else {
                                                    xrs.close();
                                                }
                                            }
                                        } finally {
                                        }
                                    } catch (Throwable th9) {
                                        th7 = th9;
                                        throw th9;
                                    }
                                } catch (Exception e3) {
                                }
                                LocalDate fecha = LocalDate.parse(citologia.getFechaRecepcion(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                                String fechaFormateada = fecha.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                                System.out.println(" numero citologia : " + citologia.getConsecutivo());
                                String nombreFileCitologia = String.format("%s_%s_%s_%s", Long.valueOf(citologia.getConsecutivo().substring(4, citologia.getConsecutivo().length())), citologia.getNumeroDocumento(), citologia.getNombreUsuario(), fechaFormateada);
                                String query3 = "SELECT `p_citologia`.NombreQuienTomaCitologia ,`p_citologia`.CargoQuienTomaCitologia \nFROM `p_citologia`\nWHERE (`p_citologia`.`Id` ='" + id + "')";
                                try {
                                    xrs = this.consulta.traerRs(query3);
                                    th = null;
                                } catch (Exception e4) {
                                }
                                try {
                                    try {
                                        if (xrs.next()) {
                                            xrs.first();
                                            citologia.setNombreQuienTomaCitologia(xrs.getString("NombreQuienTomaCitologia"));
                                            citologia.setCargoQuienTomaCitologia(xrs.getString("CargoQuienTomaCitologia"));
                                        }
                                        if (xrs != null) {
                                            if (0 != 0) {
                                                try {
                                                    xrs.close();
                                                } catch (Throwable th10) {
                                                    th.addSuppressed(th10);
                                                }
                                            } else {
                                                xrs.close();
                                            }
                                        }
                                        if (!esLiquida.booleanValue()) {
                                            System.out.println("citologia . " + this.metodos.getMapper().writeValueAsString(citologia));
                                            if (null != mostrarPdf) {
                                                switch (mostrarPdf.intValue()) {
                                                    case 1:
                                                        escribirPdf(citologia, nombreFileCitologia);
                                                        mostrarPdf(this.metodos.getRutaRep() + nombreFileCitologia + ".pdf");
                                                        break;
                                                    case 2:
                                                        escribirPdf(citologia, nombreFileCitologia);
                                                        break;
                                                    case 3:
                                                        escribirPdf(citologia, nombreFileCitologia);
                                                        Path sourcePath = Paths.get(this.xmetodo.getRutaRep() + nombreFileCitologia + ".pdf", new String[0]);
                                                        this.xmetodo.imprimirPDF(sourcePath.toString());
                                                        break;
                                                }
                                            }
                                        } else {
                                            citologia.setClasificacionGeneralText(citologia.getClasificacionGeneralText());
                                            citologia.setMicroorganismoText(citologia.getMicroorganismoText());
                                            citologia.setHallazgosNeoplaticosText(citologia.getHallazgosNeoplaticosText());
                                            citologia.setCelulasEscamosasText(citologia.getCelulasEscamosasText());
                                            citologia.setCelulasGlandularesText(citologia.getCelulasGlandularesText());
                                            citologia.setRutaReportes(this.xmetodo.getRutaRep());
                                            if (citologia != null) {
                                                Map<String, Object> parametrosMap = new HashMap<>();
                                                parametrosMap.put("SUBREPORT_DIR", this.xmetodo.getSO() + this.xmetodo.getBarra() + "Reportes" + this.xmetodo.getBarra());
                                                parametrosMap.put("SUBREPORTFIRMA_DIR", this.xmetodo.mRutaSoporte("SUBREPORTFIRMA_DIR") + this.xmetodo.getBarra());
                                                parametrosMap.put("SUBREPORTFIRMA_DIR", this.xmetodo.mRutaSoporte("SUBREPORTFIRMA_DIR") + this.xmetodo.getBarra());
                                                parametrosMap.put("data", this.xmetodo.convertirObjetoAMap(citologia));
                                                switch (mostrarPdf.intValue()) {
                                                    case 1:
                                                        this.xmetodo.GenerarPDF(this.xmetodo.getRutaRep() + "H_CitologiaLiquida", parametrosMap, nombreFileCitologia);
                                                        break;
                                                    case 2:
                                                        this.xmetodo.GenerarPDFSinMotrarParaCitologia(this.xmetodo.getRutaRep() + "H_CitologiaLiquida", parametrosMap);
                                                        break;
                                                    case 3:
                                                        this.xmetodo.GenerarPDFSinMotrarParaCitologia(this.xmetodo.getRutaRep() + "H_CitologiaLiquida", parametrosMap);
                                                        Path sourcePath2 = Paths.get(this.xmetodo.getRutaRep() + "H_CitologiaLiquida.pdf", new String[0]);
                                                        this.xmetodo.imprimirPDF(sourcePath2.toString());
                                                        break;
                                                }
                                            }
                                        }
                                    } finally {
                                    }
                                } catch (Throwable th11) {
                                    th = th11;
                                    throw th11;
                                }
                            } finally {
                                if (xrs2 != null) {
                                    if (th2 != null) {
                                        try {
                                            xrs2.close();
                                        } catch (Throwable th12) {
                                            th2.addSuppressed(th12);
                                        }
                                    } else {
                                        xrs2.close();
                                    }
                                }
                            }
                        } catch (Throwable th13) {
                            th2 = th13;
                            throw th13;
                        }
                    }
                    response.close();
                    this.metodos.getResteasyClient().close();
                } finally {
                    if (xrs3 != null) {
                        if (th3 != null) {
                            try {
                                xrs3.close();
                            } catch (Throwable th14) {
                                th3.addSuppressed(th14);
                            }
                        } else {
                            xrs3.close();
                        }
                    }
                }
            } catch (Throwable th15) {
                th3 = th15;
                throw th15;
            }
        } catch (JsonProcessingException e5) {
            Logger.getLogger(JIFvalidacionAdministrativa.class.getName()).log(Level.SEVERE, (String) null, e5);
        }
    }

    public static String[][] convertirMapAArray(Map<String, Object> map) {
        String[][] array = new String[map.size()][2];
        int index = 0;
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            array[index][0] = entry.getKey();
            array[index][1] = entry.getValue().toString();
            index++;
        }
        return array;
    }

    private void escribirPdf(CitologiaDTO citologia, String nombreFile) {
        this.metodos.mEliminarArchivo(new File(getMetodos().getRutaRep() + nombreFile + ".pdf"));
        String inputPdfPath = getMetodos().getRutaRep() + "Formato_Citologia_1.pdf";
        String outputPdfPath = getMetodos().getRutaRep() + nombreFile + ".pdf";
        try {
            this.reader = new PdfReader(inputPdfPath);
            this.stamper = new PdfStamper(this.reader, new FileOutputStream(outputPdfPath));
            this.over = this.stamper.getOverContent(1);
            this.overLetrapequena6 = this.stamper.getOverContent(1);
            this.bf = BaseFont.createFont("Helvetica", "Cp1252", true);
            this.overLetrapequena6.setColorFill(BaseColor.BLACK);
            this.overLetrapequena6.setFontAndSize(this.bf, 5.0f);
            this.overLetrapequena6.beginText();
            this.overLetrapequena6.showTextAligned(0, citologia.getNombreSede(), 235.0f, 711.0f, 0.0f);
            this.overLetrapequena6.endText();
            this.over.setColorFill(BaseColor.BLACK);
            this.over.setFontAndSize(this.bf, 9.0f);
            this.over.beginText();
            this.over.showTextAligned(0, citologia.getConsecutivo(), 450.0f, 711.0f, 0.0f);
            this.over.showTextAligned(0, citologia.getNombreUsuario(), 87.0f, 696.0f, 0.0f);
            this.over.showTextAligned(0, citologia.getNumeroDocumento(), 368.0f, 696.0f, 0.0f);
            this.over.showTextAligned(0, citologia.getEdad(), 537.0f, 696.0f, 0.0f);
            this.over.showTextAligned(0, citologia.getMunicipioResidencia(), 155.0f, 685.0f, 0.0f);
            this.over.showTextAligned(0, citologia.getDireccion(), 330.0f, 685.0f, 0.0f);
            this.over.showTextAligned(0, citologia.getTelefono(), 495.0f, 685.0f, 0.0f);
            getTipoRegimen(citologia.getIdTipoRegimen());
            this.over.showTextAligned(0, citologia.getEmpresaConvenio(), 87.0f, 662.0f, 0.0f);
            this.over.showTextAligned(0, citologia.getFechaToma(), 200.0f, 648.0f, 0.0f);
            this.over.showTextAligned(0, citologia.getFechaNacimiento(), 458.0f, 648.0f, 0.0f);
            campo(String.valueOf(citologia.getNumeroEmbarazo()), 83, 622);
            campo(String.valueOf(citologia.getNumeroPartos()), 102, 622);
            campo(String.valueOf(citologia.getNumeroAbortos()), 127, 622);
            campo(String.valueOf(citologia.getNumeroCesarea()), 150, 622);
            campo(String.valueOf(citologia.getFechaUltimaMestruacion()), 480, 622);
            campo(citologia.getNombreTipoMetodoPlanificacion(), 210, 622);
            campo(citologia.getResultadoUltimaCitologia(), 245, 610);
            campo(citologia.getFechaUltimaCitologia(), 485, 610);
            getPrimerVez(citologia.getPrimeraVez());
            campo(citologia.getHisterectomia(), 245, 599);
            campo(citologia.getCauterizacion(), 320, 599);
            campo(citologia.getConizacion(), 384, 599);
            campo(citologia.getRadioterapia(), 455, 599);
            campo("", 517, 599);
            campo(citologia.getTratamientoHormonal(), 106, 587);
            getAspectoCuello(citologia.getAspecCuello());
            campo(citologia.getDescripcionAspecto(), 201, 574);
            campo(citologia.getObservacion(), 42, 536);
            campo(citologia.getSintomas(), 88, 562);
            campo(citologia.getNombreQuienTomaCitologia(), 180, 516);
            campo(citologia.getCargoQuienTomaCitologia(), 350, 516);
            getCalidadMuestra(citologia.getCalidadMuestra(), citologia.getObservacionCalidad());
            campo("X", 114, 372);
            getCategoriaGeneral(citologia.getClasificacionGeneral());
            getMicroorganismo(citologia.getMicroorganismo());
            getHallazgosNeoplasicos(citologia.getHallazgosNeoplaticos());
            getCelulasEscamosas(citologia.getCelulasEscamosas());
            getCelulasGlandulares(citologia.getCelulasGlandulares());
            campo(citologia.getObservacionResultado() == null ? "" : citologia.getObservacionResultado(), 115, 105);
            campo(citologia.getNCConducta(), 45, 93);
            campo(citologia.getFechaRecepcion() == null ? "" : citologia.getFechaRecepcion(), 449, 480);
            this.overLetrapequena6.setColorFill(BaseColor.BLACK);
            this.overLetrapequena6.setFontAndSize(this.bf, 5.0f);
            this.overLetrapequena6.beginText();
            getImagen(this.metodos.mRutaSoporte("SUBREPORTFIRMA_DIR") + citologia.getFirmaProfesional(), 120, 60);
            campo(citologia.getProfesional(), 150, 61);
            campo(citologia.getEspecialidad(), 170, 54);
            campo(citologia.getRegistro(), 150, 47);
            campo("Fecha de Reporte:" + citologia.getFechaResultado(), 150, 40);
            getImagen(this.metodos.mRutaSoporte("SUBREPORTFIRMA_DIR") + citologia.getFirmaValida(), 400, 60);
            campo(citologia.getProfesionalValida() == null ? "" : citologia.getProfesionalValida(), 400, 61);
            campo(citologia.getEspecialidadEspecialista() == null ? "" : citologia.getEspecialidadEspecialista(), 420, 54);
            campo(citologia.getProfesionalValida() == null ? "" : "Tarjeta Profesional: " + citologia.getRegistroValida(), 400, 47);
            campo(citologia.getProfesionalValida() == null ? "" : "Fecha de Validación:" + citologia.getFechaValidacion(), 400, 40);
            this.overLetrapequena6.endText();
            this.over.endText();
            this.stamper.close();
            this.reader.close();
        } catch (DocumentException | IOException e) {
        }
    }

    private void getCelulasGlandulares(List<GenericDomain> list) {
        for (int i = 0; i < list.size(); i++) {
            GenericDomain get = list.get(i);
            switch (get.getNombre()) {
                case "Celulas glandulares atípicas (ACG) endocervicales":
                    campo("X", 337, 212);
                    break;
                case "Celulas glandulares atípicas (ACG) endometriales":
                    campo("X", 412, 212);
                    break;
                case "Celulas glandulares atípicas (ACG) sin especificar":
                    campo("X", 484, 212);
                    break;
                case "Celulas glandulares atípicas,  favorece  neoplasia  endocervicales":
                    campo("X", 337, 175);
                    break;
                case "Celulas glandulares atípicas,  favorece  neoplasia  sin especificar":
                    campo("X", 410, 175);
                    break;
                case "Adenocarcinoma endocervical in situ (AIS)":
                    campo("X", 337, 153);
                    break;
                case "Adenocarcinoma endocervical":
                    campo("X", 337, 138);
                    campo("X", 337, 125);
                    break;
                case "Adenocarcinoma endometrial":
                    campo("X", 337, 138);
                    campo("X", 411, 125);
                    break;
                case "Adenocarcinoma Extrauterino":
                    campo("X", 337, 138);
                    campo("X", 488, 125);
                    break;
            }
        }
    }

    private void getCelulasEscamosas(List<GenericDomain> list) {
        for (int i = 0; i < list.size(); i++) {
            GenericDomain get = list.get(i);
            switch (get.getNombre()) {
                case "ASC-US (células escamosas atípicas de significado indeterminado)":
                    campo("X", 76, 211);
                    break;
                case "ASC-H (células escamosas atípicas de signifcado indeterminado suegestivo de LEI de alto grado)":
                    campo("X", 76, 200);
                    break;
                case "Lesión intraepitelial escamosa de bajo grado- HPV (NIC I)( LEI BG)":
                    campo("X", 76, 180);
                    break;
                case "Lesión intraepitelial escamosa de alto grado(LEI)  de alto grado(NIC II-III, CA INSITU)(LEI AG) Con Características Sospechosas de Invasión":
                    campo("X", 76, 170);
                    campo("X", 109, 158);
                    break;
                case "Lesión intraepitelial escamosa de alto grado(LEI)  de alto grado(NIC II-III, CA INSITU)(LEI AG) Sin especificar":
                    campo("X", 76, 170);
                    campo("X", 109, 148);
                    break;
                case "Carcinoma de celulas escamosas ( escamocelular)":
                    campo("X", 44, 140);
                    break;
            }
        }
    }

    private void getCategoriaGeneral(List<GenericDomain> list) {
        System.out.println("general : " + list.size());
        for (int i = 0; i < list.size(); i++) {
            GenericDomain get = list.get(i);
            System.out.println("Neopal " + get.getNombre());
            switch (get.getNombre()) {
                case "Negativa para Lesión Intraeptelial o Malignidad":
                    campo("X", 338, 455);
                    break;
                case "Anormalidades Celulares Epiteliales":
                    campo("X", 338, 444);
                    break;
                case "Presencia de células endometriales en mujeres de 45 años o más":
                    campo("X", 338, 423);
                    break;
            }
        }
    }

    private void getMicroorganismo(List<GenericDomain> list) {
        for (int i = 0; i < list.size(); i++) {
            GenericDomain get = list.get(i);
            switch (get.getNombre()) {
                case "Trichomonas vaginalis":
                    campo("X", 40, 327);
                    break;
                case "Hongos Consistente con Cándida SP":
                    campo("X", 40, 317);
                    break;
                case "Flora sugestiva de vaginosis bacteriana":
                    campo("X", 40, 306);
                    break;
                case "Bacterias compatibles con Actinomices.":
                    campo("X", 40, 296);
                    break;
                case "Cambios celulares consistentes con virus Herpes simple":
                    campo("X", 40, 285);
                    break;
                case "Cambios celulares consistentes con virus Citomegalovirus":
                    campo("X", 40, 275);
                    break;
                case "Lactobacilos SPP":
                    campo("X", 40, 265);
                    break;
            }
        }
    }

    private void getHallazgosNeoplasicos(List<GenericDomain> list) {
        for (int i = 0; i < list.size(); i++) {
            GenericDomain get = list.get(i);
            System.out.println("Neopal " + get.getNombre());
            switch (get.getNombre()) {
                case "Metaplasia escamosa":
                    campo("X", 337, 317);
                    break;
                case "Metaplasia tubárica":
                    campo("X", 337, 306);
                    break;
                case "Cambios asociados a embarazo":
                    campo("X", 337, 296);
                    break;
                case "Cambios celulares por atrofia":
                    campo("X", 449, 317);
                    break;
                case "Cambios queratóticos":
                    campo("X", 449, 306);
                    break;
                case "Cambios celulares reactivos asociados a inflamación":
                    campo("X", 359, 275);
                    break;
                case "Cambios celulares reactivos asociados a radiación":
                    campo("X", 359, 265);
                    break;
                case "Cambios celulares reactivos asociados a Cervicitis linfocítica (folicular)":
                    campo("X", 456, 275);
                    break;
                case "Cambios celulares reactivos asociados a DIU":
                    campo("X", 456, 265);
                    break;
                case "Células Glandulares post-histerectomia":
                    campo("X", 337, 255);
                    break;
            }
        }
    }

    private void getCalidadMuestra(String seleccion, String observacion) {
        switch (seleccion) {
            case "Satisfactoria Presencia de Celulas Endocervicales y Zona de Transformacion":
                campo("X", 45, 454);
                campo("X", 81, 433);
                break;
            case "Satisfactoria Presencia de Celulas Endocervicales y Zona de Transformacion, Extendido Hemorragico":
                campo("X", 45, 454);
                campo("X", 81, 433);
                break;
            case "Satisfactoria Presencia de Celulas Endocervicales y Zona de Transformacion, Extendido Inflamatorio":
                campo("X", 45, 454);
                campo("X", 81, 433);
                break;
            case "Satisfactoria Ausencia de Celulas Endocervicales y Zona de Transformacion":
                campo("X", 45, 454);
                campo("X", 152, 433);
                break;
            case "Satisfactoria Ausencia de Celulas Endocervicales y Zona de Transformacion, Extendido Hemorragico":
                campo("X", 45, 454);
                campo("X", 152, 433);
                break;
            case "Satisfactoria Ausencia de Celulas Endocervicales y Zona de Transformacion, Extendido Inflamatorio":
                campo("X", 45, 454);
                campo("X", 152, 433);
                break;
            case "Insatisfactoria para Evaluacion":
                campo("X", 45, 423);
                campo(observacion, 45, 402);
                break;
            case "Rechazada":
                campo("X", 45, 423);
                campo(observacion, 45, 382);
                break;
        }
    }

    private void getAspectoCuello(String aspecto) {
        switch (aspecto) {
            case "Ausente":
                campo("X", 462, 587);
                break;
            case "Sano":
                campo("X", 496, 587);
                break;
            case "Congestivo":
                campo("X", 567, 587);
                break;
            case "Artrófico":
                campo("X", 80, 574);
                break;
            default:
                campo("X", 135, 574);
                break;
        }
    }

    private void getPrimerVez(Boolean primerVez) {
        if (primerVez.booleanValue()) {
            campo("X", 127, 610);
        } else {
            campo("X", 180, 610);
        }
    }

    private void getTipoMetodoPlanificacion(String idMetodo, String nombreMetodo) {
        switch (idMetodo) {
            case "1":
                campo("X", 228, 622);
                break;
            case "2":
                campo("X", 315, 622);
                break;
            default:
                campo(nombreMetodo, 350, 622);
                break;
        }
    }

    private void getTipoRegimen(String idRegimen) {
        switch (idRegimen) {
            case "1":
                campo("X", 200, 673);
                break;
            case "11":
                campo("X", 200, 673);
                break;
            case "2":
                campo("X", 284, 673);
                break;
            case "4":
                campo("X", 284, 673);
                break;
            case "3":
                campo("X", 427, 673);
                break;
            case "5":
                campo("X", 427, 673);
                break;
            case "6":
                campo("X", 427, 673);
                break;
            case "7":
                campo("X", 427, 673);
                break;
            case "9":
                campo("X", 427, 673);
                break;
            case "10":
                campo("X", 427, 673);
                break;
            case "8":
                campo("X", 345, 673);
                break;
            default:
                campo(idRegimen, 468, 673);
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

    private void campo(String xtexto, int x, int y) {
        this.over.setTextMatrix(x, y);
        this.over.showText(xtexto);
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

    private void getImagen(String urlImagen, int x, int y) {
        try {
            File file = new File(urlImagen);
            if (file.exists()) {
                Image image = Image.getInstance(urlImagen);
                image.setAbsolutePosition(x, y);
                image.scaleAbsolute(140.0f, 40.0f);
                this.over.addImage(image);
            }
        } catch (IOException | DocumentException ex) {
            Logger.getLogger(ImpresionReporteCitologiaBethesda.class.getName()).log(Level.WARNING, "No se pudo cargar la imagen: " + urlImagen, (Throwable) ex);
        }
    }

    private Boolean getEsLiquida(Long idCitologia) {
        ResultSet xrs;
        Throwable th;
        System.out.println("valor parametro" + idCitologia);
        String xsql = "select ld.Id_Recepcion,  gp.Id, gp.Nbre from l_detallerecepcion ld \ninner join p_citologia pc on pc.Id_Recepcion = ld.Id_Recepcion \ninner join g_procedimiento gp on gp.Id = ld.Id_Procedim \nwhere pc.Id ='" + idCitologia + "' and gp.Id = '898002'";
        Boolean esLiquida = false;
        try {
            xrs = this.consulta.traerRs(xsql);
            th = null;
            try {
                try {
                } finally {
                }
            } finally {
            }
        } catch (Exception e) {
        }
        if (!xrs.next()) {
            if (xrs != null) {
                if (0 != 0) {
                    try {
                        xrs.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                } else {
                    xrs.close();
                }
            }
            return esLiquida;
        }
        xrs.first();
        esLiquida = true;
        if (xrs != null) {
            if (0 != 0) {
                try {
                    xrs.close();
                } catch (Throwable th3) {
                    th.addSuppressed(th3);
                }
            } else {
                xrs.close();
            }
        }
        return 1;
        return esLiquida;
    }
}
