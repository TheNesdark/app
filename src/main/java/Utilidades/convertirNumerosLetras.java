package Utilidades;

import java.util.Arrays;

/* JADX INFO: loaded from: GenomaP.jar:Utilidades/convertirNumerosLetras.class */
public class convertirNumerosLetras {
    private static final String PREFIJO_ERROR = "Error: ";
    private static final String COMA = ",";
    private static final String MENOS = "-";
    public static final String[] listaUnidades = {"cero", "un", "dos", "tres", "cuatro", "cinco", "seis", "siete", "ocho", "nueve", "diez", "once", "doce", "trece", "catorce", "quince", "dieciséis", "diecisiete", "dieciocho", "diecinueve", "veinte", "veintiún", "veintidós", "veintitrés", "veinticuatro", "veinticinco", "veintiséis", "veintisiete", "veintiocho", "veintinueve"};
    public static final String[] listaDecenas = {"", "diez", "veinte", "treinta", "cuarenta", "cincuenta", "sesenta", "setenta", "ochenta", "noventa"};
    public static final String[] listaCentenas = {"", "cien", "doscientos", "trescientos", "cuatrocientos", "quinientos", "seiscientos", "setecientos", "ochocientos", "novecientos"};
    public static final String[] listaOrdenesMillonSingular = {"", "millón", "billón", "trillón", "cuatrillón", "quintillón", "sextillón", "septillón", "octillón", "nonillón", "decillón", "undecillón", "duodecillón", "tridecillón", "cuatridecillón", "quidecillón", "sexdecillón", "septidecillón", "octodecillón", "nonidecillón", "vigillón"};
    public static final String[] listaOrdenesMillonPlural = {"", "millones", "billones", "trillones", "cuatrillones", "quintillones", "sextillones", "septillones", "octillones", "nonillones", "decillones", "undecillones", "duodecillones", "tridecillones", "cuatridecillones", "quidecillones", "sexdecillones", "septidecillones", "octodecillones", "nonidecillones", "vigillones"};
    public static final String[] listaUnidadesOrdinales = {"ningún", "primer", "segundo", "tercer", "cuarto", "quinto", "sexto", "séptimo", "octavo", "noveno", "décimo", "undécimo", "duodécimo", "decimotercer", "decimocuarto", "decimoquinto", "decimosexto", "decimoséptimo", "decimoctavo", "decimonoveno"};
    public static final String[] listaDecenasOrdinales = {"", "décimo", "vigésimo", "trigésimo", "cuadragésimo", "quincuagésimo", "sexagésimo", "septuagésimo", "octogésimo", "nonagésimo"};
    public static final String[] listaCentenasOrdinales = {"", "centésimo", "ducentésimo", "tricentésimo", "cuadringentésimo", "quingentésimo", "sexcentésimo", "septingentésimo", "octingentésimo", "noningentésimo"};
    public static final String[] listaPotenciasDiezOrdinales = {"", "décimo", "centésimo", "milésimo", "diezmilésimo", "cienmilésimo", "millonésimo"};

    /* JADX INFO: loaded from: GenomaP.jar:Utilidades/convertirNumerosLetras$Genero.class */
    public enum Genero {
        neutro,
        masculino,
        femenino;

        public boolean esMasculino() {
            return this == masculino;
        }

        public boolean esFemenino() {
            return this == femenino;
        }

        public static Genero desdeNumero(int numero) {
            if (numero == 0) {
                return neutro;
            }
            if (numero == 1) {
                return masculino;
            }
            return femenino;
        }
    }

    protected static String convertirUnidades(int unidades, Genero genero) {
        if (unidades == 1) {
            if (genero.esMasculino()) {
                return "uno";
            }
            if (genero.esFemenino()) {
                return "una";
            }
        } else if (unidades == 21) {
            if (genero.esMasculino()) {
                return "veintiuno";
            }
            if (genero.esFemenino()) {
                return "veintiuna";
            }
        }
        return listaUnidades[unidades];
    }

    protected static String convertirCentenas(int centenas, Genero genero) {
        String resultado = listaCentenas[centenas];
        if (genero.esFemenino()) {
            resultado = resultado.replaceAll("iento", "ienta");
        }
        return resultado;
    }

    public static String convertirDosCifras(int cifras, Genero genero) {
        int unidad = cifras % 10;
        int decena = cifras / 10;
        if (cifras < 30) {
            return convertirUnidades(cifras, genero);
        }
        if (unidad == 0) {
            return listaDecenas[decena];
        }
        return listaDecenas[decena] + " y " + convertirUnidades(unidad, genero);
    }

    public static String convertirTresCifras(int cifras, Genero genero) {
        int decenas_y_unidades = cifras % 100;
        int centenas = cifras / 100;
        if (cifras < 100) {
            return convertirDosCifras(cifras, genero);
        }
        if (decenas_y_unidades == 0) {
            return convertirCentenas(centenas, genero);
        }
        if (centenas == 1) {
            return "ciento " + convertirDosCifras(decenas_y_unidades, genero);
        }
        return convertirCentenas(centenas, genero) + " " + convertirDosCifras(decenas_y_unidades, genero);
    }

    public static String convertirSeisCifras(int cifras, Genero genero) {
        int primerMillar = cifras % 1000;
        int grupoMiles = cifras / 1000;
        Genero generoMiles = genero.esMasculino() ? Genero.neutro : genero;
        if (grupoMiles == 0) {
            return convertirTresCifras(primerMillar, genero);
        }
        if (grupoMiles == 1) {
            if (primerMillar == 0) {
                return "mil";
            }
            return "mil " + convertirTresCifras(primerMillar, genero);
        }
        if (primerMillar == 0) {
            return convertirTresCifras(grupoMiles, generoMiles) + " mil";
        }
        return convertirTresCifras(grupoMiles, generoMiles) + " mil " + convertirTresCifras(primerMillar, genero);
    }

    public static String convertirCifrasEnLetras(String cifras, Genero genero, String separadorGruposSeisCifras) {
        String cifras2 = cifras.trim();
        int numeroCifras = cifras2.length();
        if (numeroCifras == 0) {
            return "Error: No hay ningún número";
        }
        for (int indiceCifra = 0; indiceCifra < numeroCifras; indiceCifra++) {
            char cifra = cifras2.charAt(indiceCifra);
            boolean esDecimal = "0123456789".indexOf(cifra) >= 0;
            if (!esDecimal) {
                return "Error: Uno de los caracteres no es una cifra decimal";
            }
        }
        if (numeroCifras > 126) {
            return "Error: El número es demasiado grande ya que tiene más de 126 cifras";
        }
        int numeroGruposSeisCifras = (numeroCifras / 6) + Integer.signum(numeroCifras);
        String cerosIzquierda = repetirCaracter('0', (numeroGruposSeisCifras * 6) - numeroCifras);
        String cifras3 = cerosIzquierda + cifras2;
        int ordenMillon = numeroGruposSeisCifras - 1;
        StringBuffer resultado = new StringBuffer();
        for (int indiceGrupo = 0; indiceGrupo < numeroGruposSeisCifras * 6; indiceGrupo += 6) {
            int seisCifras = Integer.parseInt(cifras3.substring(indiceGrupo, indiceGrupo + 6));
            if (seisCifras != 0) {
                if (resultado.length() > 0) {
                    resultado.append(separadorGruposSeisCifras);
                }
                if (ordenMillon == 0) {
                    resultado.append(convertirSeisCifras(seisCifras, genero));
                } else if (seisCifras == 1) {
                    resultado.append("un " + listaOrdenesMillonSingular[ordenMillon]);
                } else {
                    resultado.append(convertirSeisCifras(seisCifras, Genero.neutro) + " " + listaOrdenesMillonPlural[ordenMillon]);
                }
            }
            ordenMillon--;
        }
        if (resultado.length() == 0) {
            resultado.append(listaUnidades[0]);
        }
        return resultado.toString();
    }

    public static String convertirCifrasEnLetras(String cifras) {
        return convertirCifrasEnLetras(cifras, Genero.neutro, " ");
    }

    public static String convertirCifrasEnLetrasMasculinas(String cifras) {
        return convertirCifrasEnLetras(cifras, Genero.masculino, " ");
    }

    public static String convertirCifrasEnLetrasFemeninas(String cifras) {
        return convertirCifrasEnLetras(cifras, Genero.femenino, " ");
    }

    public static String convertirNumeroEnLetras(String cifras, int numeroDecimales, String palabraEnteraSingular, String palabraEnteraPlural, boolean esFemeninaPalabraEntera, String palabraDecimalSingular, String palabraDecimalPlural, boolean esFemeninaPalabraDecimal) {
        String cifras2 = dejarSoloCaracteresDeseados(cifras, "0123456789,-");
        int repeticionesMenos = numeroRepeticiones(cifras2, MENOS);
        int repeticionesComa = numeroRepeticiones(cifras2, COMA);
        if (repeticionesMenos > 1) {
            return "Error: Símbolo negativo incorrecto o demasiados símbolos negativos";
        }
        if (repeticionesMenos == 1 && !cifras2.startsWith(MENOS)) {
            return "Error: Símbolo negativo incorrecto o demasiados símbolos negativos";
        }
        if (repeticionesComa > 1) {
            return "Error: Demasiadas comas decimales";
        }
        boolean esNegativo = cifras2.startsWith(MENOS);
        if (esNegativo) {
            cifras2 = cifras2.substring(1);
        }
        int posicionComa = cifras2.indexOf(COMA);
        if (posicionComa == -1) {
            posicionComa = cifras2.length();
        }
        String cifrasEntera = cifras2.substring(0, posicionComa);
        if (cifrasEntera.equals("") || cifrasEntera.equals(MENOS)) {
            cifrasEntera = "0";
        }
        String cifrasDecimal = cifras2.substring(Math.min(posicionComa + 1, cifras2.length()));
        boolean esAutomaticoNumeroDecimales = numeroDecimales < 0;
        if (esAutomaticoNumeroDecimales) {
            cifrasDecimal.length();
        } else {
            String cifrasDecimal2 = cifrasDecimal.substring(0, Math.min(numeroDecimales, cifrasDecimal.length()));
            String cerosDerecha = repetirCaracter('0', numeroDecimales - cifrasDecimal2.length());
            cifrasDecimal = cifrasDecimal2 + cerosDerecha;
        }
        boolean esCero = dejarSoloCaracteresDeseados(cifrasEntera, "123456789").equals("") && dejarSoloCaracteresDeseados(cifrasDecimal, "123456789").equals("");
        StringBuffer resultado = new StringBuffer();
        if (esNegativo && !esCero) {
            resultado.append("menos ");
        }
        String parteEntera = procesarEnLetras(cifrasEntera, palabraEnteraSingular, palabraEnteraPlural, esFemeninaPalabraEntera);
        if (parteEntera.startsWith(PREFIJO_ERROR)) {
            return parteEntera;
        }
        resultado.append(parteEntera);
        if (!cifrasDecimal.equals("")) {
            String parteDecimal = procesarEnLetras(cifrasDecimal, palabraDecimalSingular, palabraDecimalPlural, esFemeninaPalabraDecimal);
            if (parteDecimal.startsWith(PREFIJO_ERROR)) {
                return parteDecimal;
            }
            resultado.append(" con ");
            resultado.append(parteDecimal);
        }
        return resultado.toString();
    }

    public static String convertirNumeroEnLetras(String cifras) {
        return convertirNumeroEnLetras(cifras, -1, "", "", false, "", "", false);
    }

    public static String convertirNumeroEnLetras(String cifras, int numeroDecimales) {
        return convertirNumeroEnLetras(cifras, numeroDecimales, "", "", false, "", "", false);
    }

    public static String convertirNumeroEnLetras(String cifras, String palabraEntera) {
        return convertirNumeroEnLetras(cifras, 0, palabraEntera, palabraEntera + "s", false, "", "", false);
    }

    public static String convertirNumeroEnLetras(String cifras, String palabraEntera, boolean esFemeninaPalabraEntera) {
        return convertirNumeroEnLetras(cifras, 0, palabraEntera, palabraEntera + "s", esFemeninaPalabraEntera, "", "", false);
    }

    public static String convertirNumeroEnLetras(String cifras, int numeroDecimales, String palabraEntera, String palabraDecimal) {
        return convertirNumeroEnLetras(cifras, numeroDecimales, palabraEntera, palabraEntera + "s", false, palabraDecimal, palabraDecimal + "s", false);
    }

    public static String convertirNumeroEnLetras(String cifras, int numeroDecimales, String palabraEntera, String palabraDecimal, boolean esFemeninaPalabraEntera, boolean esFemeninaPalabraDecimal) {
        return convertirNumeroEnLetras(cifras, numeroDecimales, palabraEntera, palabraEntera + "s", esFemeninaPalabraEntera, palabraDecimal, palabraDecimal + "s", esFemeninaPalabraDecimal);
    }

    protected static String procesarEnLetras(String cifras, String palabraSingular, String palabraPlural, boolean esFemenina) {
        Genero genero = Genero.neutro;
        if (esFemenina) {
            genero = Genero.femenino;
        } else if (palabraSingular.equals("")) {
            genero = Genero.masculino;
        }
        String letras = convertirCifrasEnLetras(cifras, genero, " ");
        if (letras.startsWith(PREFIJO_ERROR)) {
            return letras;
        }
        boolean esCero = letras.equals(convertirUnidades(0, genero)) || letras.equals("");
        boolean esUno = letras.equals(convertirUnidades(1, genero));
        boolean esMultiploMillon = !esCero && cifras.endsWith("000000");
        String palabra = "";
        if (!palabraSingular.equals("")) {
            if (esUno || palabraPlural.equals("")) {
                palabra = palabraSingular;
            } else {
                palabra = palabraPlural;
            }
        }
        StringBuffer resultado = new StringBuffer();
        resultado.append(letras);
        if (!palabra.equals("")) {
            if (esMultiploMillon) {
                resultado.append(" de ");
            } else {
                resultado.append(" ");
            }
            resultado.append(palabra);
        }
        return resultado.toString();
    }

    public static String convertirEurosEnLetras(String cifras, int numeroDecimales) {
        return convertirNumeroEnLetras(cifras, numeroDecimales, "peso", "céntimo");
    }

    public static String convertirEurosEnLetras(long euros) {
        String cifras = String.valueOf(euros);
        return convertirEurosEnLetras(cifras, 0);
    }

    public static String convertirEurosEnLetras(double euros) {
        String cifras = String.valueOf(euros).replace('.', ',');
        return convertirEurosEnLetras(cifras, 2);
    }

    public static String convertirOrdinalesEnLetras(String cifras, Genero genero) {
        return "";
    }

    /* JADX INFO: renamed from: convertirAñosEnLetras, reason: contains not printable characters */
    public static String m54convertirAosEnLetras(String cifras) {
        return "";
    }

    public static String convertirFechasEnLetras(String fecha) {
        return "";
    }

    public static String repetirCaracter(char caracter, int veces) {
        char[] arreglo = new char[veces];
        Arrays.fill(arreglo, caracter);
        return new String(arreglo);
    }

    public static String dejarSoloCaracteresDeseados(String texto, String caracteresDeseados) {
        int indice = 0;
        StringBuffer resultado = new StringBuffer(texto);
        while (indice < resultado.length()) {
            char caracter = resultado.charAt(indice);
            if (caracteresDeseados.indexOf(caracter) < 0) {
                resultado.deleteCharAt(indice);
            } else {
                indice++;
            }
        }
        return resultado.toString();
    }

    public static int numeroRepeticiones(String texto, String caracteres) {
        int resultado = 0;
        for (int indice = 0; indice < texto.length(); indice++) {
            char caracter = texto.charAt(indice);
            if (caracteres.indexOf(caracter) >= 0) {
                resultado++;
            }
        }
        return resultado;
    }

    public static String formatearCifras(String cifras) {
        String cifras2 = dejarSoloCaracteresDeseados(cifras, "0123456789,-");
        if (cifras2.length() == 0) {
            return cifras2;
        }
        boolean esNegativo = cifras2.startsWith(MENOS);
        if (esNegativo) {
            cifras2 = cifras2.substring(1);
        }
        int posicionComa = cifras2.indexOf(COMA);
        boolean esDecimal = posicionComa >= 0;
        if (!esDecimal) {
            posicionComa = cifras2.length();
        }
        String cifrasEntera = cifras2.substring(0, posicionComa);
        String cifrasDecimal = "";
        if (esDecimal) {
            cifrasDecimal = cifras2.substring(Math.min(posicionComa + 1, cifras2.length()));
        }
        if (cifrasEntera.equals("")) {
            cifrasEntera = "0";
        }
        StringBuffer resultado = new StringBuffer();
        int numeroCifras = cifrasEntera.length();
        boolean par = true;
        for (int indice = 0; indice < numeroCifras; indice += 3) {
            int indiceGrupo = numeroCifras - indice;
            String tresCifras = cifras2.substring(Math.max(indiceGrupo - 3, 0), indiceGrupo);
            if (indice > 0) {
                resultado.insert(0, par ? '.' : '_');
                par = !par;
            }
            resultado.insert(0, tresCifras);
        }
        if (esNegativo) {
            resultado.insert(0, MENOS);
        }
        if (esDecimal) {
            resultado.append(COMA + cifrasDecimal);
        }
        return resultado.toString();
    }
}
