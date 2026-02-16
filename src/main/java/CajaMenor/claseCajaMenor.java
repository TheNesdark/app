package CajaMenor;

import Acceso.Principal;
import Caja.Recibos;
import Contabilidad.JIFRegistroRecibos;
import Contabilidad.JIFSolicitudReembolsoCM;
import Contabilidad.JIFSolicitudReembolsoCMV2;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.genoma.plus.controller.sgc.JIF_Reportes_PyP_Generico;

/* JADX INFO: loaded from: GenomaP.jar:CajaMenor/claseCajaMenor.class */
public class claseCajaMenor {
    private ConsultasMySQL consultas = new ConsultasMySQL();
    private Metodos metodos = new Metodos();
    private Recibos frmRecibos;
    public Principal frmPrincipal;
    public JIFRegistroRecibos xjifregistrorecibos;
    private JIFSolicitudReembolsoCM xjifsolicitudr;
    private JIFSolicitudReembolsoCMV2 xjifSolicitudRV2;
    private JIF_Reportes_PyP_Generico jifreportes;

    public claseCajaMenor(Principal frmP) {
        this.frmPrincipal = frmP;
    }

    public void anular(String frm) {
        if (frm.equals("jifregistrorecibos1")) {
            this.xjifregistrorecibos.mAnular();
        } else if (frm.equals("jifsolicitudreembolso1")) {
            this.xjifsolicitudr.mAnular();
        } else if (frm.equals("jifsolicitudreembolso2")) {
            this.xjifSolicitudRV2.mAnular();
        }
    }

    public void buscar(String frm) {
        if (frm.equals("jifregistrorecibos1")) {
            this.xjifregistrorecibos.mBuscar();
        } else if (frm.equals("jifsolicitudreembolso1")) {
            this.xjifsolicitudr.mBuscar();
        } else if (frm.equals("jifsolicitudreembolso2")) {
            this.xjifSolicitudRV2.mBuscar();
        }
    }

    public void cargarPantalla(String frm) {
        if (frm.equals("Registro Recibos")) {
            this.xjifregistrorecibos = new JIFRegistroRecibos("jifregistrorecibos1");
            Principal.cargarPantalla(this.xjifregistrorecibos);
        }
        if (frm.equals("Solicitud de Reembolso")) {
            if (Principal.informacionIps.getNombreIps().equals("E.S.E CAMU IRIS LOPEZ DURAN DE SAN ANTERO")) {
                this.xjifSolicitudRV2 = new JIFSolicitudReembolsoCMV2("jifSolicitudReembolso2");
                Principal.cargarPantalla(this.xjifSolicitudRV2);
                return;
            } else {
                this.xjifsolicitudr = new JIFSolicitudReembolsoCM("jifsolicitudreembolso1");
                Principal.cargarPantalla(this.xjifsolicitudr);
                return;
            }
        }
        if (frm.equals("Informes Generales")) {
            this.jifreportes = new JIF_Reportes_PyP_Generico(28, "INFORMES GENERALES", "jif_ReportesPyP");
            Principal.cargarPantalla(this.jifreportes);
        }
    }

    public void grabar(String frm) {
        if (frm.equals("jifregistrorecibos1")) {
            this.xjifregistrorecibos.mGrabar();
        } else if (frm.equals("jifsolicitudreembolso1")) {
            this.xjifsolicitudr.mGrabar();
        } else if (frm.equals("jifsolicitudreembolso2")) {
            this.xjifSolicitudRV2.mGrabar();
        }
    }

    public void imprimir(String frm) {
        if (frm.equals("jifsolicitudreembolso1")) {
            this.xjifsolicitudr.mImprimir();
        }
        if (frm.equals("jifregistrorecibos1")) {
            this.xjifregistrorecibos.mImprimir();
        }
    }

    public void nuevo(String frm) {
        if (frm.equals("jifregistrorecibos1")) {
            this.xjifregistrorecibos.mNuevo();
        }
    }
}
