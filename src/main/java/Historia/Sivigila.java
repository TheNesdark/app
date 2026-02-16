package Historia;

import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.genoma.plus.dao.general.PatologiaCie10DAO;
import com.genoma.plus.dao.impl.general.PatologiaCie10DAOImpl;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:Historia/Sivigila.class */
public class Sivigila {
    static PdfReader reader;
    static PdfStamper stamper;
    static BaseFont bf;
    static PdfContentByte over;
    private static Metodos xmt = new Metodos();
    String xIdAtencion;
    String xIdPatologia;
    String codigo;
    private PatologiaCie10DAO patologiaCie10DAO;
    private List<Object[]> datosFicha;
    private byte[] Archivo;
    private ConsultasMySQL xconsultasbd = new ConsultasMySQL();
    private Integer forma;

    public Sivigila(String xIdAtencion, String xIdPatologia, String codigo, byte[] Archivo, Integer forma) {
        this.xIdAtencion = xIdAtencion;
        this.xIdPatologia = xIdPatologia;
        this.codigo = codigo;
        this.Archivo = Archivo;
        springStart();
        this.forma = forma;
    }

    public Sivigila() {
        springStart();
    }

    private void springStart() {
        this.patologiaCie10DAO = (PatologiaCie10DAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("patologiaCie10DAOImpl");
    }

    public void mGenerarSivigila() {
        this.datosFicha = this.patologiaCie10DAO.informacionGeneracionFichaSivigila(this.xIdAtencion, this.xIdPatologia);
        if (!this.datosFicha.isEmpty() && this.Archivo != null) {
            try {
                xmt.AbrirArchivosblob(this.Archivo, "Sivigila", "pdf", false);
                mDatosBasicos("Sivigila", xmt.getDirectorioExportacion() + "Sivigila.pdf", 1);
                mDatosBasicos2();
                if ("100".equals(this.datosFicha.get(0)[2].toString())) {
                    mAccidenteOfidico();
                }
                stamper.close();
                mostrarPdf(xmt.getRutaRep() + "Sivigila.pdf");
                xmt.mEliminarArchivo(new File(xmt.getDirectorioExportacion() + "Sivigila.pdf"));
            } catch (DocumentException | IOException ex) {
                Logger.getLogger(Sivigila.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        }
    }

    public void mGenerarSivigila(String nombre) {
        this.datosFicha = this.patologiaCie10DAO.listReporteFichaSivigila(nombre);
        if (this.datosFicha.isEmpty() || this.datosFicha.get(0)[5] == null) {
            return;
        }
        xmt.AbrirArchivosblob(this.datosFicha.get(0)[5], nombre, "pdf", true);
    }

    private void mDatosBasicos(String nArchivo, String rutaOrigen, int pagina) throws DocumentException {
        try {
            reader = new PdfReader(rutaOrigen);
            stamper = new PdfStamper(reader, new FileOutputStream(xmt.getRutaRep() + nArchivo + ".pdf"));
            bf = BaseFont.createFont("Helvetica", "Cp1252", false);
            over = stamper.getOverContent(pagina);
            over.beginText();
            over.setFontAndSize(bf, 10.0f);
            mllenarCasillas(this.datosFicha.get(0)[0].toString(), 2, 33, this.forma.intValue() == 0 ? 642 : 680);
            mllenarCasillas(this.datosFicha.get(0)[0].toString().substring(2, 5), 3, 77, this.forma.intValue() == 0 ? 642 : 680);
            mllenarCasillas(this.datosFicha.get(0)[0].toString().substring(5, 10), 5, 133, this.forma.intValue() == 0 ? 642 : 680);
            mllenarCasillas(this.datosFicha.get(0)[0].toString().substring(10, 12), 2, 225, this.forma.intValue() == 0 ? 642 : 680);
            campo(this.datosFicha.get(0)[1].toString(), 265, this.forma.intValue() == 0 ? 642 : 680);
            campo(this.datosFicha.get(0)[3].toString(), 17, this.forma.intValue() == 0 ? 600 : 638);
            mllenarCasillas(this.datosFicha.get(0)[2].toString(), 3, 300, this.forma.intValue() == 0 ? 600 : 638);
            mllenarCasillas(this.datosFicha.get(0)[4].toString(), 2, 367, this.forma.intValue() == 0 ? 600 : 638);
            mllenarCasillas(this.datosFicha.get(0)[4].toString().substring(2, 4), 2, 411, this.forma.intValue() == 0 ? 600 : 638);
            mllenarCasillas(this.datosFicha.get(0)[4].toString().substring(4, 8), 4, 457, this.forma.intValue() == 0 ? 600 : 638);
            mTipoDocumento(this.datosFicha.get(0)[5].toString());
            campo(this.datosFicha.get(0)[6].toString(), this.forma.intValue() == 0 ? 287 : 410, this.forma.intValue() == 0 ? 547 : 582);
            campo(this.datosFicha.get(0)[7].toString(), 17, this.forma.intValue() == 0 ? 504 : 543);
            campo(this.datosFicha.get(0)[30].toString(), 467, this.forma.intValue() == 0 ? 504 : 543);
            mllenarCasillas(this.datosFicha.get(0)[8].toString(), 2, 27, this.forma.intValue() == 0 ? 468 : 510);
            mllenarCasillas(this.datosFicha.get(0)[8].toString().substring(2, 4), 2, 71, this.forma.intValue() == 0 ? 468 : 510);
            mllenarCasillas(this.datosFicha.get(0)[8].toString().substring(4, 8), 4, 116, this.forma.intValue() == 0 ? 468 : 510);
            campo(this.datosFicha.get(0)[9].toString(), 193, this.forma.intValue() == 0 ? 468 : 510);
            mUnidadMedidaEdad(this.datosFicha.get(0)[10].toString());
            mSexo(this.datosFicha.get(0)[11].toString());
            getIdentidadGenero(this.datosFicha.get(0)[42].toString());
            mllenarCasillas(this.forma.intValue() == 0 ? this.datosFicha.get(0)[12].toString() : this.datosFicha.get(0)[39].toString(), 3, this.forma.intValue() == 0 ? 550 : 545, this.forma.intValue() == 0 ? 485 : 515);
            campo(this.datosFicha.get(0)[13].toString(), this.forma.intValue() == 0 ? 495 : 410, this.forma.intValue() == 0 ? 465 : 505);
            mllenarCasillas(this.forma.intValue() == 0 ? this.datosFicha.get(0)[14].toString() : this.datosFicha.get(0)[40].toString(), 4, 146, 437);
            campo(this.datosFicha.get(0)[15].toString(), 17, 432);
            mllenarCasillas(this.datosFicha.get(0)[16].toString().substring(0, 2), 2, this.forma.intValue() == 0 ? 355 : 357, this.forma.intValue() == 0 ? 432 : 438);
            mllenarCasillas(this.datosFicha.get(0)[16].toString().substring(2, 5), 3, this.forma.intValue() == 0 ? 396 : 398, this.forma.intValue() == 0 ? 432 : 438);
            campo(this.datosFicha.get(0)[17].toString().toUpperCase(), 215, 432);
            mZona(this.datosFicha.get(0)[18].toString(), this.datosFicha.get(0)[19].toString());
            mllenarCasillas(this.datosFicha.get(0)[20].toString(), 4, 143, this.forma.intValue() == 0 ? 368 : 377);
            mRegimen(this.datosFicha.get(0)[21].toString());
            mllenarCasillas(this.datosFicha.get(0)[23].toString(), 6, 498, 366);
            mEtnia(this.datosFicha.get(0)[24].toString());
            mPoblacionEspecial(this.datosFicha.get(0)[27].toString());
            mllenarCasillas(this.datosFicha.get(0)[33].toString().substring(0, 2), 2, this.forma.intValue() == 0 ? 498 : 505, this.forma.intValue() == 0 ? 247 : 240);
            mllenarCasillas(this.datosFicha.get(0)[33].toString().substring(2, 5), 3, this.forma.intValue() == 0 ? 542 : 546, this.forma.intValue() == 0 ? 247 : 240);
            campo(this.datosFicha.get(0)[34].toString().toUpperCase(), this.forma.intValue() == 0 ? 269 : 190, this.forma.intValue() == 0 ? 247 : 235);
            campo(this.datosFicha.get(0)[28].toString(), this.forma.intValue() == 0 ? 17 : 120, this.forma.intValue() == 0 ? 217 : 216);
            mllenarCasillas(this.datosFicha.get(0)[4].toString(), 2, 27, 181);
            mllenarCasillas(this.datosFicha.get(0)[4].toString().substring(2, 4), 2, 71, 181);
            mllenarCasillas(this.datosFicha.get(0)[4].toString().substring(4, 8), 4, 115, 181);
            mEstaHostipalizado(this.datosFicha.get(0)[35].toString());
            mllenarCasillas(this.datosFicha.get(0)[36].toString().substring(0, 2), 2, 27, 133);
            mllenarCasillas(this.datosFicha.get(0)[36].toString().substring(2, 4), 2, 71, 133);
            mllenarCasillas(this.datosFicha.get(0)[36].toString().substring(4, 8), 4, 115, 133);
            mEstadoVivo(this.datosFicha.get(0)[38].toString());
            mllenarCasillas(this.datosFicha.get(0)[37].toString(), 4, 172, 100);
            campo(this.datosFicha.get(0)[29].toString(), 238, 95);
            campo(this.datosFicha.get(0)[30].toString(), 497, 95);
            over.endText();
        } catch (IOException ex) {
            Logger.getLogger(Sivigila.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mDatosBasicos2() throws DocumentException, IOException {
        over = stamper.getOverContent(2);
        over.beginText();
        over.setFontAndSize(bf, 10.0f);
        campo(this.datosFicha.get(0)[7].toString(), this.forma.intValue() == 0 ? 25 : 35, this.forma.intValue() == 0 ? 865 : 780);
        campo(this.datosFicha.get(0)[5].toString(), this.forma.intValue() == 0 ? 298 : 310, this.forma.intValue() == 0 ? 865 : 780);
        campo(this.datosFicha.get(0)[6].toString(), this.forma.intValue() == 0 ? 340 : 395, this.forma.intValue() == 0 ? 865 : 780);
        over.endText();
    }

    private void mAccidenteOfidico() throws DocumentException, IOException {
        over = stamper.getOverContent(2);
        over.beginText();
        over.setFontAndSize(bf, 10.0f);
        mllenarCasillas(this.datosFicha.get(0)[4].toString(), 2, 181, this.forma.intValue() == 0 ? 814 : 755);
        mllenarCasillas(this.datosFicha.get(0)[4].toString().substring(2, 4), 2, 221, this.forma.intValue() == 0 ? 814 : 755);
        mllenarCasillas(this.datosFicha.get(0)[4].toString().substring(4, 8), 4, 264, this.forma.intValue() == 0 ? 814 : 755);
        over.endText();
    }

    private void mTipoDocumento(String xTipoDocumento) {
        if (!xTipoDocumento.isEmpty()) {
            switch (xTipoDocumento) {
                case "RC":
                    campo("x", this.forma.intValue() == 0 ? 25 : 21, this.forma.intValue() == 0 ? 545 : 589);
                    break;
                case "TI":
                    campo("x", this.forma.intValue() == 0 ? 57 : 49, this.forma.intValue() == 0 ? 545 : 589);
                    break;
                case "CC":
                    campo("x", this.forma.intValue() == 0 ? 84 : 74, this.forma.intValue() == 0 ? 545 : 589);
                    break;
                case "CE":
                    campo("x", this.forma.intValue() == 0 ? 115 : 104, this.forma.intValue() == 0 ? 545 : 589);
                    break;
                case "PA":
                    campo("x", this.forma.intValue() == 0 ? 149 : 137, this.forma.intValue() == 0 ? 545 : 589);
                    break;
                case "MS":
                    campo("x", this.forma.intValue() == 0 ? 184 : 169, this.forma.intValue() == 0 ? 545 : 589);
                    break;
                case "AS":
                    campo("x", this.forma.intValue() == 0 ? 220 : 202, this.forma.intValue() == 0 ? 545 : 589);
                    break;
                case "PE":
                    campo("x", this.forma.intValue() == 0 ? 225 : 232, this.forma.intValue() == 0 ? 545 : 589);
                    break;
                case "CN":
                    campo("x", this.forma.intValue() == 0 ? 225 : 258, this.forma.intValue() == 0 ? 545 : 589);
                    break;
                case "CD":
                    campo("x", this.forma.intValue() == 0 ? 225 : 291, this.forma.intValue() == 0 ? 545 : 589);
                    break;
                case "SC":
                    campo("x", this.forma.intValue() == 0 ? 225 : 323, this.forma.intValue() == 0 ? 545 : 589);
                    break;
                case "DE":
                    campo("x", this.forma.intValue() == 0 ? 225 : 351, this.forma.intValue() == 0 ? 545 : 589);
                    break;
                case "PT":
                    campo("x", this.forma.intValue() == 0 ? 225 : 378, this.forma.intValue() == 0 ? 545 : 589);
                    break;
            }
        }
    }

    private void mUnidadMedidaEdad(String xMedidaEdad) {
        if (!xMedidaEdad.isEmpty()) {
            switch (xMedidaEdad) {
                case "0":
                    campo("x", 331, 465);
                    break;
                case "Año(s)":
                    campo("x", this.forma.intValue() == 0 ? 232 : 239, this.forma.intValue() == 0 ? 477 : 517);
                    break;
                case "Mes(es)":
                    campo("x", this.forma.intValue() == 0 ? 232 : 239, this.forma.intValue() == 0 ? 465 : 506);
                    break;
                case "Día(s)":
                    campo("x", this.forma.intValue() == 0 ? 283 : 289, this.forma.intValue() == 0 ? 477 : 517);
                    break;
                case "4":
                    campo("x", 283, 465);
                    break;
                case "5":
                    campo("x", 331, 477);
                    break;
            }
        }
    }

    private void mSexo(String xSexo) {
        if (!xSexo.isEmpty()) {
            switch (xSexo) {
                case "M":
                    campo("x", this.forma.intValue() == 0 ? 383 : 23, this.forma.intValue() == 0 ? 477 : 479);
                    break;
                case "F":
                    campo("x", this.forma.intValue() == 0 ? 383 : 23, this.forma.intValue() == 0 ? 465 : 467);
                    break;
                case "I":
                    campo("x", this.forma.intValue() == 0 ? 383 : 73, this.forma.intValue() == 0 ? 477 : 479);
                    break;
            }
        }
    }

    private void getIdentidadGenero(String identidad) {
        if (!identidad.isEmpty()) {
            System.out.println("sexo : " + identidad);
            switch (identidad) {
                case "1":
                    campo("x", this.forma.intValue() == 0 ? 383 : 139, this.forma.intValue() == 0 ? 477 : 479);
                    break;
                case "2":
                    campo("x", this.forma.intValue() == 0 ? 383 : 139, this.forma.intValue() == 0 ? 465 : 467);
                    break;
                case "3":
                    campo("x", this.forma.intValue() == 0 ? 383 : 183, this.forma.intValue() == 0 ? 477 : 479);
                    break;
                case "4":
                    campo("x", this.forma.intValue() == 0 ? 383 : 183, this.forma.intValue() == 0 ? 465 : 467);
                    break;
                case "5":
                    campo("x", this.forma.intValue() == 0 ? 383 : 245, this.forma.intValue() == 0 ? 477 : 479);
                    break;
            }
        }
    }

    private void mZona(String xzona, String barrio) {
        if (!xzona.isEmpty()) {
            switch (xzona) {
                case "U":
                    campo("x", 447, this.forma.intValue() == 0 ? 439 : 442);
                    campo(barrio, this.forma.intValue() == 0 ? 183 : 17, this.forma.intValue() == 0 ? 402 : 400);
                    break;
                case "R":
                    campo("x", 536, 439);
                    campo(barrio, 470, 402);
                    break;
            }
        }
    }

    private void mEtnia(String xEtnia) {
        if (!xEtnia.isEmpty()) {
            switch (xEtnia) {
                case "1":
                    campo("x", 104, 340);
                    break;
                case "2":
                    campo("x", 235, 340);
                    break;
                case "3":
                    campo("x", 297, 340);
                    break;
                case "4":
                    campo("x", 346, 340);
                    break;
                case "5":
                    campo("x", 407, 340);
                    break;
                case "6":
                    campo("x", 516, 340);
                    break;
            }
        }
    }

    private void mRegimen(String xRegimen) {
        System.out.println("regimen" + xRegimen);
        if (!xRegimen.isEmpty()) {
            switch (xRegimen) {
                case "1":
                case "6":
                    campo("x", 259, this.forma.intValue() == 0 ? 372 : 374);
                    break;
                case "2":
                case "4":
                case "7":
                    campo("x", 259, this.forma.intValue() == 0 ? 360 : 363);
                    break;
                case "3":
                case "9":
                case "8":
                    campo("x", 314, this.forma.intValue() == 0 ? 372 : 374);
                    break;
                case "10":
                    campo("x", this.forma.intValue() == 0 ? 314 : 220, this.forma.intValue() == 0 ? 360 : 374);
                    break;
                case "5":
                    campo("x", this.forma.intValue() == 0 ? 210 : 314, this.forma.intValue() == 0 ? 360 : 363);
                    break;
            }
        }
    }

    private void mPoblacionEspecial(String xPoblacionE) {
        if (xPoblacionE == null || xPoblacionE.trim().isEmpty()) {
            return;
        }
        System.out.println(xPoblacionE);
        Map<String, int[]> poblacionMap = new HashMap<>();
        int[] iArr = new int[2];
        iArr[0] = 22;
        iArr[1] = this.forma.intValue() == 0 ? 308 : 311;
        poblacionMap.put("discapacitado", iArr);
        int[] iArr2 = new int[2];
        iArr2[0] = 22;
        iArr2[1] = this.forma.intValue() == 0 ? 299 : 302;
        poblacionMap.put("desplazados", iArr2);
        int[] iArr3 = new int[2];
        iArr3[0] = this.forma.intValue() == 0 ? 83 : 135;
        iArr3[1] = this.forma.intValue() == 0 ? 308 : 311;
        poblacionMap.put("migrator", iArr3);
        int[] iArr4 = new int[2];
        iArr4[0] = this.forma.intValue() == 0 ? 83 : 135;
        iArr4[1] = this.forma.intValue() == 0 ? 308 : 302;
        poblacionMap.put("carcelarios", iArr4);
        int[] iArr5 = new int[2];
        iArr5[0] = this.forma.intValue() == 0 ? 136 : 229;
        iArr5[1] = this.forma.intValue() == 0 ? 308 : 311;
        poblacionMap.put("embarazada", iArr5);
        int[] iArr6 = new int[2];
        iArr6[0] = this.forma.intValue() == 0 ? 252 : 315;
        iArr6[1] = this.forma.intValue() == 0 ? 308 : 311;
        poblacionMap.put("icbf", iArr6);
        int[] iArr7 = new int[2];
        iArr7[0] = this.forma.intValue() == 0 ? 252 : 315;
        iArr7[1] = this.forma.intValue() == 0 ? 299 : 302;
        poblacionMap.put("comunitarias", iArr7);
        int[] iArr8 = new int[2];
        iArr8[0] = this.forma.intValue() == 0 ? 391 : 427;
        iArr8[1] = this.forma.intValue() == 0 ? 308 : 311;
        poblacionMap.put("desmovilizados", iArr8);
        int[] iArr9 = new int[2];
        iArr9[0] = this.forma.intValue() == 0 ? 391 : 427;
        iArr9[1] = this.forma.intValue() == 0 ? 299 : 302;
        poblacionMap.put("psiquiátricos", iArr9);
        int[] iArr10 = new int[2];
        iArr10[0] = this.forma.intValue() == 0 ? 485 : 504;
        iArr10[1] = this.forma.intValue() == 0 ? 308 : 311;
        poblacionMap.put("violencia armada", iArr10);
        int[] iArr11 = new int[2];
        iArr11[0] = this.forma.intValue() == 0 ? 136 : 504;
        iArr11[1] = this.forma.intValue() == 0 ? 299 : 302;
        poblacionMap.put("otro grupo poblacional", iArr11);
        String xPoblacionELower = xPoblacionE.toLowerCase();
        for (Map.Entry<String, int[]> entry : poblacionMap.entrySet()) {
            if (xPoblacionELower.contains(entry.getKey())) {
                int[] valores = entry.getValue();
                campo("x", valores[0], valores[1]);
                return;
            }
        }
        campo("x", 504, 302);
    }

    private static void mEstaHostipalizado(String EstaHospitalizado) {
        if (!EstaHospitalizado.isEmpty()) {
            switch (EstaHospitalizado) {
                case "1":
                    campo("x", 541, 178);
                    break;
                case "2":
                    campo("x", 570, 178);
                    break;
            }
        }
    }

    private static void mEstadoVivo(String EstaVivo) {
        if (!EstaVivo.isEmpty()) {
            switch (EstaVivo) {
                case "1":
                    campo("x", 186, 148);
                    break;
                case "2":
                    campo("x", 186, 138);
                    break;
            }
        }
    }

    private static void mllenarCasillas(String xtexto, int cont, int x, int y) {
        int sum = x;
        for (int i = 0; i < cont; i++) {
            campo(xtexto.substring(i, 1 + i), sum, y);
            sum += 16;
        }
    }

    private static void campo(String xtexto, int x, int y) {
        over.setTextMatrix(x, y);
        over.showText(xtexto);
    }

    public static void mostrarPdf(String rutaa) {
        File archivo = new File(rutaa);
        if (archivo.exists()) {
            try {
                Desktop d = Desktop.getDesktop();
                d.open(archivo);
            } catch (IOException ex) {
                Logger.getLogger(Sivigila.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        }
    }
}
