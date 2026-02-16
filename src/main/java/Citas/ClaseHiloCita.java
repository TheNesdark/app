package Citas;

import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: GenomaP.jar:Citas/ClaseHiloCita.class */
public class ClaseHiloCita extends Thread {
    private String noCita;
    private String IdProfesional;
    private String sql = "SELECT NoCita, IdProfesionalUltimaCita FROM g_ips";
    private Metodos metodos = new Metodos();
    private ConsultasMySQL consultas = new ConsultasMySQL();
    private ResultSet rs;
    public static int interrumpir = 0;
    private CitaInterconsulta frm;
    private String NoCitaIps;
    private String idProfesional;

    public ClaseHiloCita(Object fiCitas, String NoCitaIps, String idProfesional) {
        this.NoCitaIps = NoCitaIps;
        this.idProfesional = idProfesional;
        if (fiCitas.getClass().getSimpleName().equals("CitaInterconsulta")) {
            this.frm = (CitaInterconsulta) fiCitas;
        } else {
            if (fiCitas.getClass().getSimpleName().equals("FICitas")) {
            }
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        while (true) {
            this.rs = this.consultas.traerRs(this.sql);
            try {
                this.rs.next();
                this.noCita = this.rs.getString(1);
                this.IdProfesional = this.rs.getString(2);
                this.rs.close();
                this.consultas.cerrarConexionBd();
                if (!this.NoCitaIps.equals(this.noCita) && this.idProfesional.equals(this.IdProfesional)) {
                    this.frm.cargarHorarioGrid();
                }
                Thread.sleep(800000L);
            } catch (InterruptedException ex) {
                Logger.getLogger(ClaseHiloCita.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            } catch (SQLException ex2) {
                Logger.getLogger(ClaseHiloCita.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex2);
            }
        }
    }
}
