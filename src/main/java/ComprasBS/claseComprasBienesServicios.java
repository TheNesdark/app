package ComprasBS;

import Acceso.Principal;
import Contabilidad.JIFSolicitudReembolsoCM;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.genoma.plus.controller.comprabs.JIFConsolidadoContratos;
import com.genoma.plus.controller.comprabs.JIFContratoInformeCgr;
import com.genoma.plus.controller.sgc.JIF_Reportes_PyP_Generico;

/* JADX INFO: loaded from: GenomaP.jar:ComprasBS/claseComprasBienesServicios.class */
public class claseComprasBienesServicios {
    private ConsultasMySQL consultas = new ConsultasMySQL();
    private Metodos metodos = new Metodos();
    public Principal frmPrincipal;
    private JIFSolicitudReembolsoCM xjifsolicitudr;
    public JIFOrdenCompra xjifcomprasbs;
    private JIFAutorizacionOrdenesCT xjifautorizacionorden;
    private JIFOrdenServicio xjifordenservicio;
    public JIFRequisicion xjifrequisicion;
    private JIFAutorizarReq xjifautorizacionreq;
    private JIFCotizacion xjifcotizacion;
    public JIFSolicitudContrato xJIFSolicitudContrato;
    private JIFConsolidadoContratos xJIFConsolidadoContratos;
    private JIFContratoInformeCgr xJIFContratoInformeCgr;
    private JIF_Reportes_PyP_Generico jifreportes;

    public claseComprasBienesServicios(Principal frmP) {
        this.frmPrincipal = frmP;
    }

    public void anular(String frm) {
        switch (frm) {
            case "jifcompras":
                this.xjifcomprasbs.mAnular();
                break;
            case "jifsolicitudreembolso1":
                this.xjifsolicitudr.mAnular();
                break;
            case "jifordenservicio":
                this.xjifordenservicio.mAnular();
                break;
            case "jifrequisicion":
                this.xjifrequisicion.mAnular();
                break;
        }
    }

    public void buscar(String frm) {
        switch (frm) {
            case "jifcompras":
                this.xjifcomprasbs.mBuscar();
                break;
            case "jifsolicitudreembolso1":
                this.xjifsolicitudr.mBuscar();
                break;
            case "jifautorizaciondocumentos2":
                this.xjifautorizacionorden.mBuscar();
                break;
            case "jifordenservicio":
                this.xjifordenservicio.mBuscar();
                break;
            case "jifrequisicion":
                this.xjifrequisicion.mBuscar();
                break;
            case "jifaurizacionreq":
                this.xjifautorizacionreq.mBuscar();
                break;
            case "jifcotizacion":
                this.xjifcotizacion.mBuscar();
                break;
            case "xjifcontratoinformecgr":
                this.xJIFContratoInformeCgr.mBuscar();
                break;
        }
    }

    public void cargarPantalla(String frm) {
        if (frm.equals("Solicitud")) {
            this.xjifcomprasbs = new JIFOrdenCompra("jifcompras", 0L);
            Principal.cargarPantalla(this.xjifcomprasbs);
        }
        if (frm.equals("Solicitud de Reembolso")) {
            this.xjifsolicitudr = new JIFSolicitudReembolsoCM("jifsolicitudreembolso1");
            Principal.cargarPantalla(this.xjifsolicitudr);
        }
        if (frm.equals("Consultar Estado")) {
            this.xjifautorizacionorden = new JIFAutorizacionOrdenesCT("jifautorizaciondocumentos2", 1);
            Principal.cargarPantalla(this.xjifautorizacionorden);
        }
        if (frm.equals("jifordenservicio")) {
            this.xjifordenservicio = new JIFOrdenServicio();
            Principal.cargarPantalla(this.xjifordenservicio);
        }
        if (frm.equals("Requisición")) {
            this.xjifrequisicion = new JIFRequisicion("jifrequisicion", "req");
            Principal.cargarPantalla(this.xjifrequisicion);
        }
        if (frm.equals("SolicitudDisponibilidad")) {
            this.xjifrequisicion = new JIFRequisicion("jifrequisicion", "SolDisp");
            Principal.cargarPantalla(this.xjifrequisicion);
        }
        if (frm.equals("Evaluación")) {
            this.xjifautorizacionreq = new JIFAutorizarReq("jifaurizacionreq");
            Principal.cargarPantalla(this.xjifautorizacionreq);
        }
        if (frm.equals("Registro de Cotizaciones")) {
            this.xjifcotizacion = new JIFCotizacion("jifcotizacion");
            Principal.cargarPantalla(this.xjifcotizacion);
        }
        if (frm.equals("Registro De Contrato")) {
            this.xJIFSolicitudContrato = new JIFSolicitudContrato("JIFSolicitudContrato");
            Principal.cargarPantalla(this.xJIFSolicitudContrato);
        }
        if (frm.equals("Consolidado Contratos")) {
            this.xJIFConsolidadoContratos = new JIFConsolidadoContratos();
            Principal.cargarPantalla(this.xJIFConsolidadoContratos);
        }
        if (frm.equals("Informe CGR Compras")) {
            this.xJIFContratoInformeCgr = new JIFContratoInformeCgr();
            Principal.cargarPantalla(this.xJIFContratoInformeCgr);
        }
        if (frm.equals("Informes Generales")) {
            this.jifreportes = new JIF_Reportes_PyP_Generico(11, "INFORMES GENERALES", "jif_ReportesPyP");
            Principal.cargarPantalla(this.jifreportes);
        }
    }

    public void grabar(String frm) {
        if (!frm.equals("jifcompras")) {
            if (!frm.equals("jifsolicitudreembolso1")) {
                if (!frm.equals("jifordenservicio")) {
                    if (!frm.equals("jifrequisicion")) {
                        if (!frm.equals("jifcotizacion")) {
                            if (frm.equals("JIFSolicitudContrato")) {
                                this.xJIFSolicitudContrato.mGrabar();
                                return;
                            }
                            return;
                        }
                        this.xjifcotizacion.mGrabar();
                        return;
                    }
                    this.xjifrequisicion.mGrabar();
                    return;
                }
                this.xjifordenservicio.mGrabar();
                return;
            }
            this.xjifsolicitudr.mGrabar();
            return;
        }
        this.xjifcomprasbs.mGrabar();
    }

    public void imprimir(String frm) {
        if (!frm.equals("jifcompras")) {
            if (!frm.equals("jifordenservicio")) {
                if (frm.equals("jifrequisicion")) {
                    this.xjifrequisicion.mImprimir();
                    return;
                }
                return;
            }
            this.xjifordenservicio.mImprimir();
            return;
        }
        this.xjifcomprasbs.mImprimir();
    }

    public void nuevo(String frm) {
        if (!frm.equals("jifcompras")) {
            if (!frm.equals("jifordenservicio")) {
                if (!frm.equals("jifrequisicion")) {
                    if (!frm.equals("jifcotizacion")) {
                        if (!frm.equals("JIFSolicitudContrato")) {
                            if (frm.equals("xjifcontratoinformecgr")) {
                                this.xJIFContratoInformeCgr.mNuevo();
                                return;
                            }
                            return;
                        }
                        this.xJIFSolicitudContrato.mNuevo();
                        return;
                    }
                    this.xjifcotizacion.mNuevo();
                    return;
                }
                this.xjifrequisicion.mNuevo();
                return;
            }
            this.xjifordenservicio.mNuevo();
            return;
        }
        this.xjifcomprasbs.mNuevo();
    }
}
