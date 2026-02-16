package Utilidades;

import java.util.regex.Pattern;

/* JADX INFO: loaded from: GenomaP.jar:Utilidades/Numero_a_Letra.class */
public class Numero_a_Letra {
    private final String[] UNIDADES = {"", "un ", "dos ", "tres ", "cuatro ", "cinco ", "seis ", "siete ", "ocho ", "nueve "};
    private final String[] DECENAS = {"diez ", "once ", "doce ", "trece ", "catorce ", "quince ", "dieciseis ", "diecisiete ", "dieciocho ", "diecinueve", "veinte ", "treinta ", "cuarenta ", "cincuenta ", "sesenta ", "setenta ", "ochenta ", "noventa "};
    private final String[] CENTENAS = {"", "ciento ", "doscientos ", "trecientos ", "cuatrocientos ", "quinientos ", "seiscientos ", "setecientos ", "ochocientos ", "novecientos "};

    public String Convertir(String numero, boolean mayusculas) {
        String literal;
        System.out.println(" Valor  " + numero);
        String numero2 = numero.replace(".", ",");
        if (numero2.indexOf(",") == -1) {
            numero2 = numero2 + ",00";
        }
        if (Pattern.matches("\\d{1,9},\\d{1,2}", numero2)) {
            String[] Num = numero2.split(",");
            if (Integer.parseInt(Num[0]) == 0) {
                literal = "cero ";
            } else if (Integer.parseInt(Num[0]) > 999999) {
                literal = getMillones(Num[0]);
            } else if (Integer.parseInt(Num[0]) > 999) {
                literal = getMiles(Num[0]);
            } else if (Integer.parseInt(Num[0]) > 99) {
                literal = getCentenas(Num[0]);
            } else if (Integer.parseInt(Num[0]) > 9) {
                literal = getDecenas(Num[0]);
            } else {
                literal = getUnidades(Num[0]);
            }
            return mayusculas ? (literal + " Pesos M/L").toUpperCase() : literal + " Pesos M/L";
        }
        return null;
    }

    public String Convertir(String numero, boolean mayusculas, String s) {
        String literal;
        System.out.println("numero : " + numero);
        String numero2 = numero.replace(".", ",");
        if (numero2.indexOf(",") == -1) {
            numero2 = numero2 + ",00";
        }
        if (Pattern.matches("\\d{1,9},\\d{1,2}", numero2)) {
            String[] Num = numero2.split(",");
            if (Integer.parseInt(Num[0]) == 0) {
                literal = "cero ";
            } else if (Integer.parseInt(Num[0]) > 999999) {
                literal = getMillones(Num[0]);
            } else if (Integer.parseInt(Num[0]) > 999) {
                literal = getMiles(Num[0]);
            } else if (Integer.parseInt(Num[0]) > 99) {
                literal = getCentenas(Num[0]);
            } else if (Integer.parseInt(Num[0]) > 9) {
                literal = getDecenas(Num[0]);
            } else {
                literal = getUnidades(Num[0]);
            }
            return mayusculas ? (literal + " de pesos M/L").toUpperCase() : literal + " de pesos M/L";
        }
        return null;
    }

    private String getUnidades(String numero) {
        String num = numero.substring(numero.length() - 1);
        return this.UNIDADES[Integer.parseInt(num)];
    }

    private String getDecenas(String num) {
        int n = Integer.parseInt(num);
        if (n < 10) {
            return getUnidades(num);
        }
        if (n > 19) {
            String u = getUnidades(num);
            if (u.equals("")) {
                return this.DECENAS[Integer.parseInt(num.substring(0, 1)) + 8];
            }
            return this.DECENAS[Integer.parseInt(num.substring(0, 1)) + 8] + "y " + u;
        }
        return this.DECENAS[n - 10];
    }

    private String getCentenas(String num) {
        if (Integer.parseInt(num) > 99) {
            if (Integer.parseInt(num) == 100) {
                return " cien ";
            }
            return this.CENTENAS[Integer.parseInt(num.substring(0, 1))] + getDecenas(num.substring(1));
        }
        return getDecenas(Integer.parseInt(num) + "");
    }

    private String getMiles(String numero) {
        String c = numero.substring(numero.length() - 3);
        String m = numero.substring(0, numero.length() - 3);
        if (Integer.parseInt(m) > 0) {
            String n = getCentenas(m);
            return n + "mil " + getCentenas(c);
        }
        return "" + getCentenas(c);
    }

    private String getMillones(String numero) {
        String n;
        String miles = numero.substring(numero.length() - 6);
        String millon = numero.substring(0, numero.length() - 6);
        System.out.println(millon.length());
        if (millon.length() > 1) {
            n = getCentenas(millon) + "millones ";
        } else {
            n = getUnidades(millon) + "millon ";
        }
        return n + getMiles(miles);
    }
}
