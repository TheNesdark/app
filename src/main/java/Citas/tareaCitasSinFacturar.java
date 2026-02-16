package Citas;

import Acceso.Principal;
import Facturacion.TareaLiquidacion;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/* JADX INFO: loaded from: GenomaP.jar:Citas/tareaCitasSinFacturar.class */
public class tareaCitasSinFacturar implements Job {
    ConsultasMySQL xct = new ConsultasMySQL();
    Metodos metodos = new Metodos();

    public void execute(JobExecutionContext jec) throws JobExecutionException {
        if (citasPorFacturar() > 0) {
            Principal.btnCancelar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/campana_alerta.gif")));
            Principal.btnCancelar.setVisible(true);
            Principal.btnCancelar.setText("" + citasPorFacturar());
        }
    }

    private int citasPorFacturar() {
        int xValor = 0;
        String sql = "SELECT \ngp.Id idPersona\n, gp.Id_TipoIdentificacion tipoIdentificacion\n, gp.NoDocumento documento\n, concat(gp.Apellido1 ,' ', gp.Apellido2,' ',gp.Nombre1, ' ', gp.Nombre2 ) usuario \n, cc.Fecha_Cita fechaCita\n, cc.HoraInicial  horaCita\n, ge.Nbre  especialidad \n, concat(gp2.Apellido1 ,' ', gp2.Apellido2,' ',gp2.Nombre1, ' ', gp2.Nombre2 ) profesional\n, cc2.Nbre consultorio\n, gs.Nbre sede\n, TIMESTAMPDIFF(MINUTE  ,now(), concat(cc.Fecha_Cita ,' ', cc.HoraInicial )) minutosAtencion \nFROM c_citas cc \ninner join g_persona gp on (gp.Id=cc.Id_Usuario)\ninner join g_especialidad ge on (ge.Id=cc.Id_Especialidad)\ninner join g_persona gp2 on (gp2.Id=cc.Id_Profesional)\ninner join c_consultorio cc2 on (cc2.Id=cc.Id_Consultorio)\ninner join g_sedes gs on (gs.Id=cc.Id_Sede)\nwhere cc.Fecha_Cita ='" + this.metodos.formatoAMD.format(this.metodos.getFechaActual()) + "'\nand cc.Asistida =0\nand cc.Id_Sede=" + Principal.sedeUsuarioSeleccionadaDTO.getId() + "\n  HAVING minutosAtencion BETWEEN  0 and 15";
        ResultSet xrs = this.xct.traerRs(sql);
        try {
            if (xrs.next()) {
                xrs.last();
                xValor = xrs.getRow();
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(TareaLiquidacion.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return xValor;
    }
}
