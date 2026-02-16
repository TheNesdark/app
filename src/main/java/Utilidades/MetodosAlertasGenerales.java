package Utilidades;

import Acceso.Principal;
import com.genoma.plus.dao.general.AlertasGeneralesDAO;
import com.genoma.plus.dao.impl.general.AlertasGeneralesDAOImpl;
import java.awt.Toolkit;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:Utilidades/MetodosAlertasGenerales.class */
public class MetodosAlertasGenerales {
    private AlertasGeneralesDAO xAlertaGenerales;
    private Principal xjifp;

    public MetodosAlertasGenerales(Principal xjifp) {
        springStart();
        this.xjifp = xjifp;
        if (Principal.informacionGeneralPrincipalDTO.getIdEspecialidad().longValue() != 0) {
            xjifp.setAsignarDatosHistoriaCE(Principal.informacionGeneralPrincipalDTO.getIdEspecialidad().toString(), "", "", 0, 1);
        }
    }

    public MetodosAlertasGenerales() {
        springStart();
    }

    private void springStart() {
        this.xAlertaGenerales = (AlertasGeneralesDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("alertasGeneralesDAO");
    }

    public void mNUsuarioPendienteSeguimiento() {
        List<Object[]> list = this.xAlertaGenerales.numeroSeguimientoAuditoriaPendientes(Principal.usuarioSistemaDTO.getIdPersonaCargo());
        if (!list.isEmpty() && !list.get(0)[0].toString().equals("0")) {
            String xmensaje = "<html><P ALIGN=center> <font face='Arial' color='red' size=4>  <b>Usted tiene " + list.get(0)[0].toString() + " seguimiento(s) registrados por revisar";
            JOptionPane.showMessageDialog(this.xjifp, xmensaje, "CONTROL DE SEGUIMIENTO AUDITORIA MEDICA - CONCURRENTE Y ADMINISTRATIVA", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Seguimiento_64.png"))));
            Principal principal = this.xjifp;
            Principal.clasegeneral.cargarPantalla("SeguimientoFiltradoUsuario", 0);
        }
    }

    public Long mNumeroSeguimientoPendientes() {
        long xNumero = 0;
        List<Object[]> list = this.xAlertaGenerales.numeroSeguimientoAuditoriaPendientes(Principal.usuarioSistemaDTO.getIdPersonaCargo());
        if (!list.isEmpty()) {
            xNumero = Long.valueOf(list.get(0)[0].toString()).longValue();
        }
        return Long.valueOf(xNumero);
    }
}
