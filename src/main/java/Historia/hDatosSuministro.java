package Historia;

/* JADX INFO: loaded from: GenomaP.jar:Historia/hDatosSuministro.class */
public class hDatosSuministro {
    private long idsum;
    private String nombresum;
    private String observaciones;
    private String xfremanual;
    private String xfrecuencia;
    private int frecuencia;
    private int duracion;
    private int finsum;
    private int codigosum;
    private int idmtrata;
    private int xdig;
    private int cantidad;
    private double dosis;
    private double valor;

    public hDatosSuministro(int codigosum, String nombresum, String xfrecuencia, int duracion, int cantidad, String observaciones, int idmtrata, int xdig, double valor) {
        this.codigosum = codigosum;
        this.nombresum = nombresum;
        this.xfrecuencia = xfrecuencia;
        this.duracion = duracion;
        this.cantidad = cantidad;
        this.observaciones = observaciones;
        this.idmtrata = idmtrata;
        this.xdig = xdig;
        this.valor = valor;
    }

    public hDatosSuministro(int codigosum, String nombresum, double dosis, int frecuencia, String xfremanual, int duracion, int cantidad, String observaciones, int idmtrata, int xdig, double valor) {
        this.codigosum = codigosum;
        this.nombresum = nombresum;
        this.dosis = dosis;
        this.frecuencia = frecuencia;
        this.duracion = duracion;
        this.cantidad = cantidad;
        this.observaciones = observaciones;
        this.idmtrata = idmtrata;
        this.xfremanual = xfremanual;
        this.valor = valor;
        this.xdig = xdig;
    }

    public int getIdSum() {
        return this.codigosum;
    }

    public String getNombreSum() {
        return this.nombresum;
    }

    public double getDosisSum() {
        return this.dosis;
    }

    public int getFrecuencia() {
        return this.frecuencia;
    }

    public int getDuracion() {
        return this.duracion;
    }

    public int getCantidadSum() {
        return this.cantidad;
    }

    public String getObaservacionsum() {
        return this.observaciones;
    }

    public int getIdmtrata() {
        return this.idmtrata;
    }

    public int getXdig() {
        return this.xdig;
    }

    public String getXfremanual() {
        return this.xfremanual;
    }

    public double getValor() {
        return this.valor;
    }

    public String getXfrecuencia() {
        return this.xfrecuencia;
    }
}
