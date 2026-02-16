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

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/historia/ClapV2.class */
public class ClapV2 {
    static PdfReader reader;
    static PdfStamper stamper;
    static BaseFont bf;
    static PdfContentByte over;
    private static Metodos xmt = new Metodos();
    Long idUsuarioxPrograma;
    private ClapDAO xClapDAO;
    private List<Object[]> listencabezado;
    private List<Object[]> listAtenciones;

    public ClapV2(Long idUsuarioxPrograma) {
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
                Logger.getLogger(ClapV2.class.getName()).log(Level.SEVERE, (String) null, e);
            }
        }
    }

    private void mDatosBasicos() throws DocumentException {
        try {
            xmt.mEliminarArchivo(new File(xmt.getRutaRep() + "HISTORIA CLINICA MATERNO-PERINATAL - CLAP - OPS_modificado.pdf"));
            reader = new PdfReader(xmt.getRutaRep() + "HISTORIA CLINICA MATERNO-PERINATAL - CLAP - OPS.pdf");
            stamper = new PdfStamper(reader, new FileOutputStream(xmt.getRutaRep() + "HISTORIA CLINICA MATERNO-PERINATAL - CLAP - OPS_modificado.pdf"));
            bf = BaseFont.createFont("Helvetica", "Cp1252", false);
            over = stamper.getOverContent(1);
            over.beginText();
            over.setFontAndSize(bf, 7.0f);
            campo(this.listencabezado.get(0)[4].toString(), 35, 734);
            campo(this.listencabezado.get(0)[5].toString(), 135, 734);
            campo(this.listencabezado.get(0)[6].toString(), 35, 715);
            campo(this.listencabezado.get(0)[7].toString(), 35, 693);
            campo(this.listencabezado.get(0)[8].toString(), 170, 693);
            mllenarCasillas(this.listencabezado.get(0)[9].toString().substring(8, 10), 2, 241, 721);
            mllenarCasillas(this.listencabezado.get(0)[9].toString().substring(5, 7), 2, 262, 721);
            mllenarCasillas(this.listencabezado.get(0)[9].toString().substring(2, 4), 2, 283, 721);
            mllenarCasillas(this.listencabezado.get(0)[10].toString(), 2, 247, 699);
            mcondicionEdad(Boolean.valueOf(this.listencabezado.get(0)[11].toString()).booleanValue());
            mEtnia(this.listencabezado.get(0)[13].toString());
            mEstudios(this.listencabezado.get(0)[12].toString().toLowerCase());
            mEstadoCivil(this.listencabezado.get(0)[14].toString());
            mllenarCasillas(this.listencabezado.get(0)[3].toString(), 11, 473, 752);
            mllenarCasillas("PAJONAL   ", 10, 483, 735);
            AntecedentesFamiliares(this.listencabezado.get(0)[16].toString());
            AntecedentesPersonales("");
            AntecedentesOtros("");
            mGemelar(Integer.valueOf(this.listencabezado.get(0)[27].toString()).intValue());
            mllenarCasillas(this.listencabezado.get(0)[17].toString(), 2, 235, 671);
            mllenarCasillas(this.listencabezado.get(0)[20].toString(), 2, 286, 671);
            mllenarCasillas(this.listencabezado.get(0)[18].toString(), 2, 320, 671);
            mllenarCasillas(this.listencabezado.get(0)[23].toString(), 2, 362, 671);
            mllenarCasillas(this.listencabezado.get(0)[23].toString(), 2, 416, 671);
            mllenarCasillas(this.listencabezado.get(0)[17].toString(), 2, 286, 625);
            campo(this.listencabezado.get(0)[19].toString(), 324, 625);
            campo(this.listencabezado.get(0)[22].toString(), 367, 625);
            campo("0", 427, 646);
            campo("0", 427, 625);
            mllenarCasillas(this.listencabezado.get(0)[26].toString().substring(0, 2), 2, 460, 662);
            mllenarCasillas(this.listencabezado.get(0)[26].toString().substring(3, 5), 2, 480, 662);
            mllenarCasillas(this.listencabezado.get(0)[26].toString().substring(8, 10), 2, 502, 662);
            mllenarCasillas(this.listencabezado.get(0)[24].toString().substring(8, 10), 2, 131, 595);
            mllenarCasillas(this.listencabezado.get(0)[24].toString().substring(5, 7), 2, 155, 595);
            mllenarCasillas(this.listencabezado.get(0)[24].toString().substring(2, 4), 2, 177, 595);
            mllenarCasillas(this.listencabezado.get(0)[25].toString().substring(8, 10), 2, 131, 577);
            mllenarCasillas(this.listencabezado.get(0)[25].toString().substring(5, 7), 2, 155, 577);
            mllenarCasillas(this.listencabezado.get(0)[25].toString().substring(2, 4), 2, 177, 577);
            mFuma(Integer.valueOf(this.listencabezado.get(0)[29].toString()).intValue());
            mAlcohol(Integer.valueOf(this.listencabezado.get(0)[28].toString()).intValue());
            mDrogas(Integer.valueOf(this.listencabezado.get(0)[30].toString()).intValue());
            this.listAtenciones = this.xClapDAO.listAtenciones(this.idUsuarioxPrograma);
            if (!this.listAtenciones.isEmpty()) {
                int sum = 0;
                if (this.listAtenciones.size() >= 2) {
                    mllenarCasillas(this.listAtenciones.get(1)[12].toString(), 3, 39, 583);
                }
                mllenarCasillas(this.listAtenciones.get(0)[11].toString(), 2, 96, 583);
                for (int i = 0; i < this.listAtenciones.size(); i++) {
                    over.setFontAndSize(bf, 5.0f);
                    mllenarCasillas(this.listAtenciones.get(i)[2].toString().substring(8, 10), 2, 53, 505 - sum);
                    mllenarCasillas(this.listAtenciones.get(i)[2].toString().substring(5, 7), 2, 74, 505 - sum);
                    mllenarCasillas(this.listAtenciones.get(i)[2].toString().substring(2, 4), 2, 96, 505 - sum);
                    campo(this.listAtenciones.get(i)[4].toString(), 115, 505 - sum);
                    campo(this.listAtenciones.get(i)[6].toString(), 131, 505 - sum);
                    campo(this.listAtenciones.get(i)[10].toString(), 145, 505 - sum);
                    campo(this.listAtenciones.get(i)[5].toString(), 167, 505 - sum);
                    campo(this.listAtenciones.get(i)[7].toString(), 204, 505 - sum);
                    campo(this.listAtenciones.get(i)[8].toString(), 223, 505 - sum);
                    campo(this.listAtenciones.get(i)[3].toString(), 312, 505 - sum);
                    campo(this.listAtenciones.get(i)[9].toString(), 432, 505 - sum);
                    sum += 14;
                }
            }
            stamper.close();
            mostrarPdf(xmt.getRutaRep() + "HISTORIA CLINICA MATERNO-PERINATAL - CLAP - OPS_modificado.pdf");
        } catch (IOException ex) {
            Logger.getLogger(ClapV2.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private static void mcondicionEdad(boolean Aplica) {
        if (Aplica) {
            campo("X", 272, 699);
        }
    }

    private static void mEtnia(String xTexto) {
        if (!xTexto.isEmpty()) {
            if (xTexto.contains("blanca")) {
                campo("X", 303, 733);
                return;
            }
            if (xTexto.contains("indígena")) {
                campo("X", 303, 724);
                return;
            }
            if (xTexto.contains("mestiza")) {
                campo("X", 303, 715);
            } else if (xTexto.contains("negro")) {
                campo("X", 303, 705);
            } else if (xTexto.contains("otras")) {
                campo("X", 303, 696);
            }
        }
    }

    private static void mAlfabeta(String xTexto) {
        if (!xTexto.isEmpty()) {
            if (xTexto.contains("No")) {
                campo("X", 277, 599);
            } else if (xTexto.contains("Si")) {
                campo("X", 277, 586);
            }
        }
    }

    private static void mEstudios(String xTexto) {
        if (!xTexto.isEmpty()) {
            if (xTexto.contains("Prescolar".toLowerCase()) || xTexto.contains("Básica Primaria".toLowerCase())) {
                campo("X", 382, 734);
                return;
            }
            if (xTexto.contains("Básica Secundaria (Bachillerato Básico)".toLowerCase()) || xTexto.contains("Media Académica o Clásica (Bachillerato Básico)".toLowerCase()) || xTexto.contains("Media Técnica (Bachillerato Técnico)".toLowerCase())) {
                campo("X", 361, 719);
                return;
            }
            if (xTexto.contains("Técnica Profesional".toLowerCase()) || xTexto.contains("Tecnológica".toLowerCase()) || xTexto.contains("Profesional".toLowerCase()) || xTexto.contains("Especialización".toLowerCase()) || xTexto.contains("Maestría".toLowerCase()) || xTexto.contains("Doctorado".toLowerCase())) {
                campo("X", 382, 719);
            } else if (xTexto.contains("Ninguno".toLowerCase())) {
                campo("X", 361, 734);
            }
        }
    }

    private static void mEstadoCivil(String xTexto) {
        if (!xTexto.isEmpty()) {
            if (xTexto.contains("CASADO (A)")) {
                campo("X", 402, 716);
                return;
            }
            if (xTexto.contains("UNION LIBRE")) {
                campo("X", 418, 716);
            } else if (xTexto.contains("SOLTERO (A)")) {
                campo("X", 402, 698);
            } else {
                campo("X", 418, 698);
            }
        }
    }

    private static void mViveSola(String xTexto) {
        if (!xTexto.isEmpty()) {
            if (xTexto.contains("No")) {
                campo("X", 333, 582);
            } else {
                campo("X", 346, 582);
            }
        }
    }

    private static void AntecedentesFamiliares(String Pregunta) {
        if (Pregunta.contains("1")) {
            campo("X", 47, 660);
        } else {
            campo("X", 36, 660);
        }
        if (Pregunta.contains("2")) {
            campo("X", 47, 651);
        } else {
            campo("X", 36, 651);
        }
        if (Pregunta.contains("3")) {
            campo("X", 47, 641);
        } else {
            campo("X", 36, 641);
        }
        if (Pregunta.contains("4")) {
            campo("X", 47, 631);
        } else {
            campo("X", 36, 631);
        }
        if (Pregunta.contains("5")) {
            campo("X", 47, 621);
        } else {
            campo("X", 36, 621);
        }
    }

    private static void AntecedentesPersonales(String Pregunta) {
        if (Pregunta.contains("1")) {
            campo("X", 112, 660);
        } else {
            campo("X", 101, 660);
        }
        if (Pregunta.contains("2")) {
            campo("X", 112, 651);
        } else {
            campo("X", 101, 651);
        }
        if (Pregunta.contains("3")) {
            campo("X", 112, 641);
        } else {
            campo("X", 101, 641);
        }
        if (Pregunta.contains("4")) {
            campo("X", 112, 631);
        } else {
            campo("X", 101, 631);
        }
        if (Pregunta.contains("5")) {
            campo("X", 112, 621);
        } else {
            campo("X", 101, 621);
        }
    }

    private static void AntecedentesOtros(String Pregunta) {
        if (Pregunta.contains("1")) {
            campo("X", 174, 677);
        } else {
            campo("X", 163, 677);
        }
        if (Pregunta.contains("2")) {
            campo("X", 174, 667);
        } else {
            campo("X", 163, 667);
        }
        if (Pregunta.contains("3")) {
            campo("X", 174, 657);
        } else {
            campo("X", 163, 657);
        }
        if (Pregunta.contains("4")) {
            campo("X", 174, 647);
        } else {
            campo("X", 163, 647);
        }
        if (Pregunta.contains("5")) {
            campo("X", 174, 638);
        } else {
            campo("X", 163, 638);
        }
        if (Pregunta.contains("6")) {
            campo("X", 174, 628);
        } else {
            campo("X", 163, 628);
        }
        if (Pregunta.contains("7")) {
            campo("X", 174, 618);
        } else {
            campo("X", 163, 618);
        }
    }

    private static void mGemelar(int xTexto) {
        switch (xTexto) {
            case 1:
                campo("X", 219, 626);
                break;
        }
    }

    private static void mFuma(int Respuesta) {
        if (Respuesta == 0) {
            campo("X", 282, 591);
            mllenarCasillas("()", 2, 319, 589);
        } else {
            campo("X", 282, 601);
        }
    }

    private static void mAlcohol(int Respuesta) {
        if (Respuesta == 0) {
            campo("X", 378, 597);
        } else {
            campo("X", 391, 597);
        }
    }

    private static void mDrogas(int Respuesta) {
        if (Respuesta == 0) {
            campo("X", 378, 583);
        } else {
            campo("X", 391, 583);
        }
    }

    private static void mllenarCasillas(String xtexto, int cont, int x, int y) {
        int sum = x;
        for (int i = 0; i < cont; i++) {
            campo(xtexto.substring(i, 1 + i), sum, y);
            sum += 10;
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
