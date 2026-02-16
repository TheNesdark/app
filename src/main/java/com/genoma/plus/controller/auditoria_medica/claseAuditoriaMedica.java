package com.genoma.plus.controller.auditoria_medica;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.genoma.plus.controller.sgc.JIF_Reportes_PyP_Generico;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/auditoria_medica/claseAuditoriaMedica.class */
public class claseAuditoriaMedica {
    private ConsultasMySQL xconsultasbd = new ConsultasMySQL();
    private Metodos xmetodo = new Metodos();
    public Principal frmPrincipal;
    private JIFAtencion_AuditoriaM xJIFAuditoriaMed;
    private JIF_Auditoria_Facturacion xJIFAuditoriaMedFac;
    private JIFAtencion_Administracion xJIFAntencion_Administracion;
    public JIF_Cierre_Seguimiento xJIFCierre_Seguimiento;
    public JIF_Informe_SeguimientosAM xJIFInformeSeguimientoAM;
    private JIF_Reportes_PyP_Generico jifreportes;

    public claseAuditoriaMedica(Principal frmP) {
        this.frmPrincipal = frmP;
    }

    public void cargarPantalla(String frm) {
        if (frm.equals("Concurrente")) {
            this.xJIFAuditoriaMed = new JIFAtencion_AuditoriaM(frm.toUpperCase());
            Principal.cargarPantalla(this.xJIFAuditoriaMed);
            return;
        }
        if (frm.equals("Facturas")) {
            this.xJIFAuditoriaMedFac = new JIF_Auditoria_Facturacion(frm.toUpperCase());
            Principal.cargarPantalla(this.xJIFAuditoriaMedFac);
            return;
        }
        if (frm.equals("Administracion")) {
            this.xJIFAntencion_Administracion = new JIFAtencion_Administracion(frm.toUpperCase());
            Principal.cargarPantalla(this.xJIFAntencion_Administracion);
            return;
        }
        if (frm.equals("Cierre de Seguimiento")) {
            this.xJIFCierre_Seguimiento = new JIF_Cierre_Seguimiento();
            Principal.cargarPantalla(this.xJIFCierre_Seguimiento);
        } else if (frm.equals("InformeSeguimientoAM")) {
            this.xJIFInformeSeguimientoAM = new JIF_Informe_SeguimientosAM();
            Principal.cargarPantalla(this.xJIFInformeSeguimientoAM);
        } else if (frm.equals("Informes Generales")) {
            this.jifreportes = new JIF_Reportes_PyP_Generico(23, "INFORMES GENERALES", "jif_ReportesPyP_Auditoria");
            Principal.cargarPantalla(this.jifreportes);
        }
    }

    public void nuevo(String frm) {
        if (frm.equals("xjifAuditoriaMedica")) {
            this.xJIFAuditoriaMed.mNuevo();
            return;
        }
        if (frm.equals("xjifAuditoriaMedicaFac")) {
            this.xJIFAuditoriaMedFac.mNuevo();
        } else if (frm.equals("xjifAuditoriaMedicaAdmin")) {
            this.xJIFAntencion_Administracion.mNuevo();
        } else if (frm.equals("xjif_InformeSeguimentosAM")) {
            this.xJIFInformeSeguimientoAM.mNuevo();
        }
    }

    public void grabar(String frm) {
    }

    public void buscar(String frm) {
        if (frm.equals("xjifAuditoriaMedica")) {
            this.xJIFAuditoriaMed.mBuscar();
            return;
        }
        if (frm.equals("xjifAuditoriaMedicaFac")) {
            this.xJIFAuditoriaMedFac.mBuscar();
            return;
        }
        if (frm.equals("xjifAuditoriaMedicaAdmin")) {
            this.xJIFAntencion_Administracion.mBuscar();
            return;
        }
        if (frm.equals("xjif_InformeSeguimentosAM")) {
            this.xJIFInformeSeguimientoAM.mBuscar();
        } else if (frm.equals("xjifCierreSeguimientoAuditoriaMedica")) {
            this.xJIFCierre_Seguimiento.mBuscar();
        } else if (frm.equals("jif_ReportesPyP_Auditoria")) {
            this.jifreportes.mBuscar();
        }
    }

    public void imprimir(String frm) {
    }

    public void anular(String frm) {
    }
}
