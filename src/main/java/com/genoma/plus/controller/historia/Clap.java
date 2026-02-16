package com.genoma.plus.controller.historia;

import Utilidades.Metodos;
import com.genoma.plus.dao.general.ClapDAO;
import com.genoma.plus.dao.impl.general.ClapDAOImpl;
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
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/historia/Clap.class */
public class Clap {
    static PdfReader reader;
    static PdfStamper stamper;
    static BaseFont bf;
    static PdfContentByte over;
    private static Metodos xmt = new Metodos();
    Long idUsuarioxPrograma;
    private ClapDAO xClapDAO;
    private List<Object[]> listencabezado;
    private List<Object[]> listAtenciones;

    public Clap(Long idUsuarioxPrograma) {
        this.idUsuarioxPrograma = idUsuarioxPrograma;
        springStart();
        mGenerarClap();
    }

    private void springStart() {
        this.xClapDAO = (ClapDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("clapDAO");
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.itextpdf.text.DocumentException */
    public void mGenerarClap() {
        this.listencabezado = this.xClapDAO.listEncabezado(this.idUsuarioxPrograma);
        if (!this.listencabezado.isEmpty()) {
            try {
                mDatosBasicos();
            } catch (DocumentException e) {
                Logger.getLogger(Clap.class.getName()).log(Level.SEVERE, (String) null, e);
            }
        }
    }

    private void mDatosBasicos() throws DocumentException {
        try {
            xmt.mEliminarArchivo(new File(xmt.getRutaRep() + "CLAP1584_Modificado.pdf"));
            reader = new PdfReader(xmt.getRutaRep() + "CLAP1584.pdf");
            stamper = new PdfStamper(reader, new FileOutputStream(xmt.getRutaRep() + "CLAP1584_Modificado.pdf"));
            bf = BaseFont.createFont("Helvetica", "Cp1252", false);
            over = stamper.getOverContent(1);
            over.beginText();
            over.setFontAndSize(bf, 6.0f);
            campo(this.listencabezado.get(0)[4].toString(), 35, 604);
            campo(this.listencabezado.get(0)[5].toString(), 117, 604);
            campo(this.listencabezado.get(0)[6].toString(), 35, 594);
            campo(this.listencabezado.get(0)[7].toString(), 35, 582);
            campo(this.listencabezado.get(0)[8].toString(), 124, 582);
            mllenarCasillas(this.listencabezado.get(0)[9].toString().substring(8, 10), 2, 202, 600);
            mllenarCasillas(this.listencabezado.get(0)[9].toString().substring(5, 7), 2, 218, 600);
            mllenarCasillas(this.listencabezado.get(0)[9].toString().substring(2, 4), 2, 234, 600);
            mllenarCasillas(this.listencabezado.get(0)[10].toString(), 2, 204, 583);
            mcondicionEdad(Boolean.valueOf(this.listencabezado.get(0)[11].toString()).booleanValue());
            mEtnia(this.listencabezado.get(0)[13].toString());
            mEstudios(this.listencabezado.get(0)[12].toString());
            mEstadoCivil(this.listencabezado.get(0)[14].toString());
            mllenarCasillas(this.listencabezado.get(0)[3].toString(), 10, 363, 582);
            AntecedentesFamiliares(this.listencabezado.get(0)[16].toString());
            AntecedentesPersonales("");
            AntecedentesOtros("");
            mGemelar(Integer.valueOf(this.listencabezado.get(0)[27].toString()).intValue());
            mllenarCasillas(this.listencabezado.get(0)[17].toString(), 2, 208, 561);
            campo(this.listencabezado.get(0)[21].toString(), 216, 548);
            mllenarCasillas(this.listencabezado.get(0)[20].toString(), 2, 242, 561);
            mllenarCasillas(this.listencabezado.get(0)[18].toString(), 2, 267, 561);
            mllenarCasillas(this.listencabezado.get(0)[23].toString(), 2, 299, 561);
            mllenarCasillas(this.listencabezado.get(0)[17].toString(), 2, 242, 527);
            campo(this.listencabezado.get(0)[19].toString(), 271, 527);
            mllenarCasillas(this.listencabezado.get(0)[23].toString(), 2, 340, 561);
            campo(this.listencabezado.get(0)[22].toString(), 303, 527);
            campo("0", 347, 543);
            campo("0", 347, 527);
            mllenarCasillas(this.listencabezado.get(0)[26].toString().substring(0, 2), 2, 365, 556);
            mllenarCasillas(this.listencabezado.get(0)[26].toString().substring(3, 5), 2, 381, 556);
            mllenarCasillas(this.listencabezado.get(0)[26].toString().substring(8, 10), 2, 397, 556);
            mllenarCasillas(this.listencabezado.get(0)[24].toString().substring(8, 10), 2, 107, 505);
            mllenarCasillas(this.listencabezado.get(0)[24].toString().substring(5, 7), 2, 123, 505);
            mllenarCasillas(this.listencabezado.get(0)[24].toString().substring(2, 4), 2, 139, 505);
            mllenarCasillas(this.listencabezado.get(0)[25].toString().substring(8, 10), 2, 107, 491);
            mllenarCasillas(this.listencabezado.get(0)[25].toString().substring(5, 7), 2, 123, 491);
            mllenarCasillas(this.listencabezado.get(0)[25].toString().substring(2, 4), 2, 139, 491);
            mHabitos(Integer.valueOf(this.listencabezado.get(0)[31].toString()).intValue(), 1, Integer.valueOf(this.listencabezado.get(0)[29].toString()).intValue());
            mHabitos(Integer.valueOf(this.listencabezado.get(0)[31].toString()).intValue(), 2, 0);
            mHabitos(Integer.valueOf(this.listencabezado.get(0)[31].toString()).intValue(), 3, Integer.valueOf(this.listencabezado.get(0)[30].toString()).intValue());
            mHabitos(Integer.valueOf(this.listencabezado.get(0)[31].toString()).intValue(), 4, Integer.valueOf(this.listencabezado.get(0)[28].toString()).intValue());
            mHabitos(Integer.valueOf(this.listencabezado.get(0)[31].toString()).intValue(), 5, 0);
            this.listAtenciones = this.xClapDAO.listAtenciones(this.idUsuarioxPrograma);
            if (!this.listAtenciones.isEmpty()) {
                int sum = 0;
                for (int i = 0; i < this.listAtenciones.size(); i++) {
                    mllenarCasillas(this.listAtenciones.get(i)[2].toString().substring(8, 10), 2, 43, 398 - sum);
                    mllenarCasillas(this.listAtenciones.get(i)[2].toString().substring(5, 7), 2, 59, 398 - sum);
                    mllenarCasillas(this.listAtenciones.get(i)[2].toString().substring(2, 4), 2, 74, 398 - sum);
                    campo(this.listAtenciones.get(i)[4].toString(), 91, 398 - sum);
                    if (this.listAtenciones.get(i)[6].toString().contains(".")) {
                        if (this.listAtenciones.get(i)[6].toString().replace(".", "").length() == 4) {
                            mllenarCasillas(this.listAtenciones.get(i)[6].toString().replace(".", ""), 4, 111, 398 - sum);
                        } else {
                            String espacios = "";
                            for (int x = 0; x <= 3 - this.listAtenciones.get(i)[6].toString().replace(".", "").length(); x++) {
                                espacios = espacios + " ";
                            }
                            mllenarCasillas(espacios + this.listAtenciones.get(i)[6].toString().replace(".", ""), 4, 111, 398 - sum);
                        }
                    } else if (this.listAtenciones.get(i)[6].toString().length() == 3) {
                        mllenarCasillas(this.listAtenciones.get(i)[6].toString() + "0", 4, 111, 398 - sum);
                    } else {
                        String espacios2 = "";
                        for (int x2 = 0; x2 <= 2 - this.listAtenciones.get(i)[6].toString().length(); x2++) {
                            espacios2 = espacios2 + " ";
                        }
                        System.out.println(espacios2 + this.listAtenciones.get(i)[6].toString() + "0");
                        mllenarCasillas(espacios2 + this.listAtenciones.get(i)[6].toString() + "0", 4, 111, 398 - sum);
                    }
                    campo(this.listAtenciones.get(i)[5].toString(), 174, 398 - sum);
                    campo(this.listAtenciones.get(i)[7].toString(), 204, 398 - sum);
                    campo(this.listAtenciones.get(i)[8].toString(), 223, 398 - sum);
                    campo(this.listAtenciones.get(i)[3].toString(), 252, 398 - sum);
                    System.out.println(398 - sum);
                    sum += 10;
                }
            }
            stamper.close();
            mostrarPdf(xmt.getRutaRep() + "CLAP1584_Modificado.pdf");
        } catch (IOException ex) {
            Logger.getLogger(Clap.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private static void mcondicionEdad(boolean Aplica) {
        if (Aplica) {
            over.setTextMatrix(228.0f, 583.0f);
            over.showText("X");
        }
    }

    private static void mEtnia(String xTexto) {
        if (!xTexto.isEmpty()) {
            if (xTexto.contains("blanca")) {
                over.setTextMatrix(253.0f, 608.0f);
                over.showText("X");
            } else if (xTexto.contains("indígena")) {
                over.setTextMatrix(253.0f, 602.0f);
                over.showText("X");
            } else if (xTexto.contains("mestiza")) {
                over.setTextMatrix(253.0f, 595.0f);
                over.showText("X");
            } else if (xTexto.contains("negro")) {
                over.setTextMatrix(253.0f, 588.0f);
                over.showText("X");
            } else if (xTexto.contains("otras")) {
                over.setTextMatrix(253.0f, 581.0f);
                over.showText("X");
            }
            System.out.println(xTexto);
        }
    }

    private static void mAlfabeta(String xTexto) {
        if (!xTexto.isEmpty()) {
            switch (xTexto) {
                case "No":
                    over.setTextMatrix(277.0f, 599.0f);
                    break;
                case "Si":
                    over.setTextMatrix(277.0f, 586.0f);
                    break;
            }
            over.showText("X");
        }
    }

    private static void mEstudios(String xTexto) {
        if (!xTexto.isEmpty()) {
            if (xTexto.contains("Prescolar".toLowerCase()) || xTexto.contains("Básica Primaria".toLowerCase())) {
                over.setTextMatrix(306.0f, 609.0f);
                over.showText("X");
                return;
            }
            if (xTexto.contains("Básica Secundaria (Bachillerato Básico)".toLowerCase()) || xTexto.contains("Media Académica o Clásica (Bachillerato Básico)".toLowerCase()) || xTexto.contains("Media Técnica (Bachillerato Técnico)".toLowerCase())) {
                over.setTextMatrix(291.0f, 598.0f);
                over.showText("X");
                return;
            }
            if (xTexto.contains("Técnica Profesional".toLowerCase()) || xTexto.contains("Tecnológica".toLowerCase()) || xTexto.contains("Profesional".toLowerCase()) || xTexto.contains("Especialización".toLowerCase()) || xTexto.contains("Maestría".toLowerCase()) || xTexto.contains("Doctorado".toLowerCase())) {
                over.setTextMatrix(306.0f, 598.0f);
                over.showText("X");
            } else if (xTexto.contains("Ninguno".toLowerCase())) {
                over.setTextMatrix(291.0f, 609.0f);
                over.showText("X");
            }
        }
    }

    private static void mEstadoCivil(String xTexto) {
        if (!xTexto.isEmpty()) {
            if (xTexto.contains("CASADO (A)")) {
                over.setTextMatrix(345.0f, 615.0f);
                over.showText("X");
            } else if (xTexto.contains("UNION LIBRE")) {
                over.setTextMatrix(345.0f, 607.0f);
                over.showText("X");
            } else if (xTexto.contains("SOLTERO (A)")) {
                over.setTextMatrix(345.0f, 600.0f);
                over.showText("X");
            } else {
                over.setTextMatrix(345.0f, 592.0f);
                over.showText("X");
            }
        }
    }

    private static void mViveSola(String xTexto) {
        if (!xTexto.isEmpty()) {
            switch (xTexto) {
                case "No":
                    over.setTextMatrix(333.0f, 582.0f);
                    break;
                case "Si":
                    over.setTextMatrix(346.0f, 582.0f);
                    break;
            }
            over.showText("X");
        }
    }

    private static void AntecedentesFamiliares(String Pregunta) {
        if (Pregunta.contains("1")) {
            campo("X", 54, 560);
        } else {
            campo("X", 45, 560);
        }
        if (Pregunta.contains("2")) {
            campo("X", 54, 553);
        } else {
            campo("X", 45, 553);
        }
        if (Pregunta.contains("3")) {
            campo("X", 54, 545);
        } else {
            campo("X", 45, 545);
        }
        if (Pregunta.contains("4")) {
            campo("X", 54, 538);
        } else {
            campo("X", 45, 538);
        }
        if (Pregunta.contains("5")) {
            campo("X", 54, 530);
        } else {
            campo("X", 45, 530);
        }
        if (Pregunta.contains("6")) {
            campo("X", 54, 523);
        } else {
            campo("X", 45, 523);
        }
    }

    private static void AntecedentesPersonales(String Pregunta) {
        if (Pregunta.contains("1")) {
            campo("X", 102, 560);
        } else {
            campo("X", 94, 560);
        }
        if (Pregunta.contains("2")) {
            campo("X", 102, 553);
        } else {
            campo("X", 94, 553);
        }
        if (Pregunta.contains("3")) {
            campo("X", 102, 545);
        } else {
            campo("X", 94, 545);
        }
        if (Pregunta.contains("4")) {
            campo("X", 102, 538);
        } else {
            campo("X", 94, 538);
        }
        if (Pregunta.contains("5")) {
            campo("X", 102, 530);
        } else {
            campo("X", 94, 530);
        }
        if (Pregunta.contains("6")) {
            campo("X", 102, 523);
        } else {
            campo("X", 94, 523);
        }
    }

    private static void AntecedentesOtros(String Pregunta) {
        if (Pregunta.contains("1")) {
            campo("X", 151, 566);
        } else {
            campo("X", 143, 566);
        }
        if (Pregunta.contains("2")) {
            campo("X", 151, 559);
        } else {
            campo("X", 143, 559);
        }
        if (Pregunta.contains("3")) {
            campo("X", 151, 552);
        } else {
            campo("X", 143, 552);
        }
        if (Pregunta.contains("4")) {
            campo("X", 151, 545);
        } else {
            campo("X", 143, 545);
        }
        if (Pregunta.contains("5")) {
            campo("X", 151, 537);
        } else {
            campo("X", 143, 537);
        }
        if (Pregunta.contains("6")) {
            campo("X", 151, 530);
        } else {
            campo("X", 143, 530);
        }
    }

    private static void mGemelar(int xTexto) {
        switch (xTexto) {
            case 0:
                over.setTextMatrix(189.0f, 525.0f);
                break;
            case 1:
                over.setTextMatrix(197.0f, 525.0f);
                break;
        }
        over.showText("X");
    }

    private static void mHabitos(int trimestre, int pregunta, int Respuesta) {
        switch (trimestre) {
            case 1:
                if (pregunta == 1) {
                    if (Respuesta == 0) {
                        campo("X", 214, 505);
                    } else {
                        campo("X", 222, 505);
                    }
                } else if (pregunta == 2) {
                    if (Respuesta == 0) {
                        campo("X", 235, 505);
                    } else {
                        campo("X", 243, 505);
                    }
                } else if (pregunta == 3) {
                    if (Respuesta == 0) {
                        campo("X", 255, 505);
                    } else {
                        campo("X", 263, 505);
                    }
                } else if (pregunta == 4) {
                    if (Respuesta == 0) {
                        campo("X", 275, 505);
                    } else {
                        campo("X", 283, 505);
                    }
                } else if (pregunta == 5) {
                    if (Respuesta == 0) {
                        campo("X", 295, 505);
                    } else {
                        campo("X", 303, 505);
                    }
                }
                break;
            case 2:
                if (pregunta == 1) {
                    if (Respuesta == 0) {
                        campo("X", 214, 498);
                    } else {
                        campo("X", 222, 498);
                    }
                } else if (pregunta == 2) {
                    if (Respuesta == 0) {
                        campo("X", 235, 498);
                    } else {
                        campo("X", 243, 498);
                    }
                } else if (pregunta == 3) {
                    if (Respuesta == 0) {
                        campo("X", 255, 498);
                    } else {
                        campo("X", 263, 498);
                    }
                } else if (pregunta == 4) {
                    if (Respuesta == 0) {
                        campo("X", 275, 498);
                    } else {
                        campo("X", 283, 498);
                    }
                } else if (pregunta == 5) {
                    if (Respuesta == 0) {
                        campo("X", 295, 498);
                    } else {
                        campo("X", 303, 498);
                    }
                }
                break;
            case 3:
                if (pregunta == 1) {
                    if (Respuesta == 0) {
                        campo("X", 214, 491);
                    } else {
                        campo("X", 222, 491);
                    }
                } else if (pregunta == 2) {
                    if (Respuesta == 0) {
                        campo("X", 235, 491);
                    } else {
                        campo("X", 243, 491);
                    }
                } else if (pregunta == 3) {
                    if (Respuesta == 0) {
                        campo("X", 255, 491);
                    } else {
                        campo("X", 263, 491);
                    }
                } else if (pregunta == 4) {
                    if (Respuesta == 0) {
                        campo("X", 275, 491);
                    } else {
                        campo("X", 283, 491);
                    }
                } else if (pregunta == 5) {
                    if (Respuesta == 0) {
                        campo("X", 295, 491);
                    } else {
                        campo("X", 303, 491);
                    }
                }
                break;
        }
    }

    private static void mllenarCasillas(String xtexto, int cont, int x, int y) {
        int sum = x;
        for (int i = 0; i < cont; i++) {
            over.setTextMatrix(sum, y);
            over.showText(xtexto.substring(i, 1 + i));
            sum += 8;
        }
    }

    private static void campo(String xtexto, int x, int y) {
        over.setTextMatrix(x, y);
        over.showText(xtexto);
    }

    public static void mostrarPdf(String rutaa) {
        try {
            System.out.println("" + rutaa);
            File archivo = new File(rutaa);
            if (archivo.exists()) {
                Desktop d = Desktop.getDesktop();
                d.open(archivo);
            }
        } catch (IOException e) {
        }
    }
}
