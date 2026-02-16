package PyP;

import java.util.Date;

/* JADX INFO: loaded from: GenomaP.jar:PyP/datosAtencionInfantilPrescolar.class */
public class datosAtencionInfantilPrescolar {
    private int lactancia;
    private int destete;
    private int otrasLeches;
    private int edadOtrasLeches;
    private int aliCom;
    private int edadAliCom;
    private int temperatura;
    private int peso;
    private int talla;
    private int perimetro;
    private int motora;
    private int adaptativa;
    private int lenguaje;
    private int personal;
    private int total;
    private int estadoNutricional;
    private int remitido;
    private String edad;
    private String cualesLeches;
    private String curvaPeso;
    private String curvaTalla;
    private Date fecha;
    private Date proximaCita;

    public datosAtencionInfantilPrescolar(Date xFecha, String xEdad, int xLactancia, int xDestete, int xOtrasLeches, int xEdadOtrasLeches, int xAliCom, int xEdadAliCom, String xCualesLeches, int xTemperatura, int xPeso, int xTalla, int xPerimetro, int xMotora, int xAdaptativa, int xLenguaje, int xPersonal, int xTotal, String xCurvaPeso, String xCurvaTalla, int xEstadoNutricional, int xRemitido, Date xProximaCita) {
        this.fecha = xFecha;
        this.edad = xEdad;
        this.lactancia = xLactancia;
        this.destete = xDestete;
        this.otrasLeches = xOtrasLeches;
        this.edadOtrasLeches = xEdadOtrasLeches;
        this.aliCom = xAliCom;
        this.edadAliCom = xEdadAliCom;
        this.cualesLeches = xCualesLeches;
        this.temperatura = xTemperatura;
        this.peso = xPeso;
        this.talla = xTalla;
        this.perimetro = xPerimetro;
        this.motora = xMotora;
        this.adaptativa = xAdaptativa;
        this.lenguaje = xLenguaje;
        this.personal = xPersonal;
        this.total = xTotal;
        this.curvaPeso = xCurvaPeso;
        this.curvaTalla = xCurvaTalla;
        this.estadoNutricional = xEstadoNutricional;
        this.remitido = xRemitido;
        this.proximaCita = xProximaCita;
    }

    public Date getFecha() {
        return this.fecha;
    }

    public String getEdad() {
        return this.edad;
    }

    public int getLactancia() {
        return this.lactancia;
    }

    public int getDestete() {
        return this.destete;
    }

    public int getOtrasLeches() {
        return this.otrasLeches;
    }

    public int getEdadOtrasLeches() {
        return this.edadOtrasLeches;
    }

    public int getAliCom() {
        return this.aliCom;
    }

    public int getEdadAliCom() {
        return this.edadAliCom;
    }

    public String getCualesLeches() {
        return this.cualesLeches;
    }

    public int getTemperatura() {
        return this.temperatura;
    }

    public int getPeso() {
        return this.peso;
    }

    public int getTalla() {
        return this.talla;
    }

    public int getPerimetro() {
        return this.perimetro;
    }

    public int getMotora() {
        return this.motora;
    }

    public int getAdaptativa() {
        return this.adaptativa;
    }

    public int getLenguaje() {
        return this.lenguaje;
    }

    public int getPersonal() {
        return this.personal;
    }

    public int getTotal() {
        return this.total;
    }

    public String getCurvaPeso() {
        return this.curvaPeso;
    }

    public String getCurvaTalla() {
        return this.curvaTalla;
    }

    public int getEstadoNutricional() {
        return this.estadoNutricional;
    }

    public int getRemitido() {
        return this.remitido;
    }

    public Date getProximaCita() {
        return this.proximaCita;
    }
}
