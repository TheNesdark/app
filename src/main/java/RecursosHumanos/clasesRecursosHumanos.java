package RecursosHumanos;

import Acceso.Principal;
import ComprasBS.JIFAutorizacionOrdenesCT;
import Contabilidad.JIFAuditoriaPago;
import Contabilidad.JIFConsultasInfC;
import Contabilidad.JIFGenerarCuentaCobroM;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.genoma.plus.controller.rrhh.JIFConsolidadoConceptosRH;
import com.genoma.plus.controller.rrhh.JIFConsolidadoPersonal;
import com.genoma.plus.controller.rrhh.JIFConsultarNominaxFecha;
import com.genoma.plus.controller.rrhh.JIFDesactivarOActivarEmpleado;
import com.genoma.plus.controller.rrhh.JIFInformeNovedadesRegistradas;
import com.genoma.plus.controller.rrhh.JIFNominaInformeCgr;
import com.genoma.plus.controller.rrhh.JIFTransmisionNomina;
import com.genoma.plus.controller.rrhh.JIFTransmisionNotaNominaElectronica;
import com.genoma.plus.controller.sgc.JIF_Reportes_PyP_Generico;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

/* JADX INFO: loaded from: GenomaP.jar:RecursosHumanos/clasesRecursosHumanos.class */
public class clasesRecursosHumanos {
    private ConsultasMySQL xconsultasbd = new ConsultasMySQL();
    private Metodos xmetodo = new Metodos();
    private JIFConsultasInfC xjifconsultainf;
    private JIFAuditoriaPago xjifauditoriacp;
    private JIFGenerarCuentaCobroM xjifcuentacobrom1;
    private JIFAutorizacionOrdenesCT xjifautorizacionorden;
    private JIFAnticipos xjifanticipos;
    private JIFReporteHorasExtras xjifreportehoras;
    private JIF_LiquidacionNomina xJif_LiquidacionN;
    private JIF_LiquidacionNomina_Nueva xJif_LiquidacionNueva;
    public JIF_Nomina_Causacion xJif_CausacionNomina;
    private JIFConsultDeduccionNomina xJIFFConsultDeduccionNomina;
    private JIF_Gestion_Concepto_Empleado xJifGestion_Concepto;
    private JIFConsultarPlanillaNomina xJifConsultar_PNomina;
    private JIFConsolidadoConceptosRH xJIFConsolidadoConceptosRH;
    private JIFConsolidadoPersonal xJIFConsolidadoPersonal;
    private JIFNominaInformeCgr xJIFNominaInformeCgr;
    private JIFConsultarNominaxFecha xJIFConsultarNominaxFecha;
    private JIFDesactivarOActivarEmpleado xJIFDesactivarOActivarEmpleado;
    public JIFPrestamos xJIFPrestamos;
    private JIFTransmisionNomina xFTransmisionNomina;
    private JIFTransmisionNotaNominaElectronica jIFTransmisionNotaNominaElectronica;
    public JIFNovedadesNomina xJIFNovedadesNomina;
    private JIFInformeNovedadesRegistradas novedadesRegistradas;
    private JIF_Reportes_PyP_Generico jifreportes;

    public void cargarPantalla(String frm) {
        if (frm.equals("Consolidado x Fecha")) {
            this.xjifconsultainf = new JIFConsultasInfC("jifconsultarinformesc1");
            Principal.cargarPantalla(this.xjifconsultainf);
            return;
        }
        if (frm.equals("Gestión de Conceptos por Lote")) {
            this.xJifGestion_Concepto = new JIF_Gestion_Concepto_Empleado();
            Principal.cargarPantalla(this.xJifGestion_Concepto);
            return;
        }
        if (frm.equals("InformeNovedadesNomina")) {
            this.novedadesRegistradas = new JIFInformeNovedadesRegistradas();
            Principal.cargarPantalla(this.novedadesRegistradas);
            return;
        }
        if (frm.equals("Reporte Horas")) {
            this.xjifreportehoras = new JIFReporteHorasExtras();
            Principal.cargarPantalla(this.xjifreportehoras);
            return;
        }
        if (frm.equals("Autorización Pago")) {
            this.xjifauditoriacp = new JIFAuditoriaPago("jifauditoriacp1");
            Principal.cargarPantalla(this.xjifauditoriacp);
            return;
        }
        if (frm.equals("Cuenta de Cobro")) {
            this.xjifcuentacobrom1 = new JIFGenerarCuentaCobroM("jifcuentacobrom1");
            Principal.cargarPantalla(this.xjifcuentacobrom1);
            return;
        }
        if (frm.equals("Autorización")) {
            this.xjifautorizacionorden = new JIFAutorizacionOrdenesCT("jifautorizaciondocumentos", 0);
            Principal.cargarPantalla(this.xjifautorizacionorden);
            return;
        }
        if (frm.equals("Anticipos")) {
            this.xjifanticipos = new JIFAnticipos();
            Principal.cargarPantalla(this.xjifanticipos);
            return;
        }
        if (frm.equals("xjif_liquidacionn")) {
            this.xJif_LiquidacionN = new JIF_LiquidacionNomina();
            Principal.cargarPantalla(this.xJif_LiquidacionN);
            return;
        }
        if (frm.equals("xjif_liquidacionnuevo")) {
            this.xJif_LiquidacionNueva = new JIF_LiquidacionNomina_Nueva();
            Principal.cargarPantalla(this.xJif_LiquidacionNueva);
            return;
        }
        if (frm.equals("xjif_causacion_nomina")) {
            this.xJif_CausacionNomina = new JIF_Nomina_Causacion();
            Principal.cargarPantalla(this.xJif_CausacionNomina);
            return;
        }
        if (frm.equals("Consulta Deducciones por Conceptos")) {
            this.xJIFFConsultDeduccionNomina = new JIFConsultDeduccionNomina();
            Principal.cargarPantalla(this.xJIFFConsultDeduccionNomina);
            return;
        }
        if (frm.equals("Consulta Deducciones por Conceptos")) {
            this.xJIFFConsultDeduccionNomina = new JIFConsultDeduccionNomina();
            Principal.cargarPantalla(this.xJIFFConsultDeduccionNomina);
            return;
        }
        if (frm.equals("xjif_consultarplanillanomina")) {
            this.xJifConsultar_PNomina = new JIFConsultarPlanillaNomina();
            Principal.cargarPantalla(this.xJifConsultar_PNomina);
            return;
        }
        if (frm.equals("Consolidado Por Conceptos")) {
            this.xJIFConsolidadoConceptosRH = new JIFConsolidadoConceptosRH();
            Principal.cargarPantalla(this.xJIFConsolidadoConceptosRH);
            return;
        }
        if (frm.equals("Consolidado Personal")) {
            this.xJIFConsolidadoPersonal = new JIFConsolidadoPersonal();
            Principal.cargarPantalla(this.xJIFConsolidadoPersonal);
            return;
        }
        if (frm.equals("Informe CGR Nomina")) {
            this.xJIFNominaInformeCgr = new JIFNominaInformeCgr();
            Principal.cargarPantalla(this.xJIFNominaInformeCgr);
            return;
        }
        if (frm.equals("Consolidado por Intervalo de Fecha")) {
            this.xJIFConsultarNominaxFecha = new JIFConsultarNominaxFecha();
            Principal.cargarPantalla(this.xJIFConsultarNominaxFecha);
            return;
        }
        if (frm.equals("Empleados")) {
            this.xJIFDesactivarOActivarEmpleado = new JIFDesactivarOActivarEmpleado();
            Principal.cargarPantalla(this.xJIFDesactivarOActivarEmpleado);
            return;
        }
        if (frm.equals("Prestamos")) {
            this.xJIFPrestamos = new JIFPrestamos();
            Principal.cargarPantalla(this.xJIFPrestamos);
            return;
        }
        if (frm.equals("Transmision nomina") || frm.equals("Transmisión Nómina")) {
            this.xFTransmisionNomina = new JIFTransmisionNomina();
            System.out.println("llega");
            Principal.cargarPantalla(this.xFTransmisionNomina);
        } else if (frm.equals("Transmision notas Nomina") || frm.equals("Transmisión Notas Nómina")) {
            this.jIFTransmisionNotaNominaElectronica = new JIFTransmisionNotaNominaElectronica();
            System.out.println("llega");
            Principal.cargarPantalla(this.jIFTransmisionNotaNominaElectronica);
        } else if (frm.equals("NovedadesNomina")) {
            this.xJIFNovedadesNomina = new JIFNovedadesNomina(1, "xjif_NovedadesNomina");
            Principal.cargarPantalla(this.xJIFNovedadesNomina);
        } else if (frm.equals("Informes Generales")) {
            this.jifreportes = new JIF_Reportes_PyP_Generico(27, "INFORMES GENERALES", "jif_ReportesPyP");
            Principal.cargarPantalla(this.jifreportes);
        }
    }

    public void nuevo(String frm) {
        switch (frm) {
            case "jifcuentacobrom1":
                this.xjifcuentacobrom1.mNuevo();
                break;
            case "xjifanticipo":
                this.xjifanticipos.mNuevo();
                break;
            case "xjif_conolidado_concepto":
                this.xJIFFConsultDeduccionNomina.mNuevo();
                break;
            case "xjif_causacion_nomina":
                this.xJif_CausacionNomina.mNuevo();
                break;
            case "xjifconsolidadopersonal":
                this.xJIFConsolidadoPersonal.mNuevo();
                break;
            case "xjifnominainformecgr":
                this.xJIFNominaInformeCgr.mNuevo();
                break;
            case "xjifconsultarnominaxfecha":
                this.xJIFConsultarNominaxFecha.mNuevo();
                break;
            case "xjif_prestamos":
                this.xJIFPrestamos.mNuevo();
                break;
            case "xjif_NovedadesNomina":
                this.xJIFNovedadesNomina.mNuevo();
                break;
            case "jifinformeregistronovedades":
                this.novedadesRegistradas.nuevo();
                break;
        }
    }

    public void grabar(String frm) {
        switch (frm) {
            case "jifauditoriacp1":
                this.xjifauditoriacp.mGrabar();
                break;
            case "jifcuentacobrom1":
                this.xjifcuentacobrom1.mGrabar();
                break;
            case "jifautorizaciondocumentos":
                this.xjifautorizacionorden.mGrabar();
                break;
            case "xjifanticipo":
                this.xjifanticipos.mGrabar();
                break;
            case "xjif_liquidacionn":
                this.xJif_LiquidacionN.mGrabar();
                break;
            case "xjif_causacion_nomina":
                this.xJif_CausacionNomina.mGrabar();
                break;
            case "xjif_gestion_concepto_empleado":
                this.xJifGestion_Concepto.mGrabar();
                break;
            case "jIFDesactivarOActivarEmpleado":
                this.xJIFDesactivarOActivarEmpleado.mGuardar();
                break;
            case "xjif_prestamos":
                this.xJIFPrestamos.mGrabar();
                break;
            case "xjif_NovedadesNomina":
                this.xJIFNovedadesNomina.mGrabar();
                break;
        }
    }

    public void buscar(String frm) {
        switch (frm) {
            case "jifconsultarinformesc1":
                this.xjifconsultainf.mBuscar();
                break;
            case "jifcuentacobrom1":
                this.xjifcuentacobrom1.mBuscar();
                break;
            case "jifautorizaciondocumentos":
                this.xjifautorizacionorden.mBuscar();
                break;
            case "xjif_liquidacionnuevo":
                this.xJif_LiquidacionNueva.mBuscar();
                break;
            case "xjif_liquidacionn":
                this.xJif_LiquidacionN.mBuscar();
                break;
            case "xjif_causacion_nomina":
                this.xJif_CausacionNomina.mBuscar();
                break;
            case "xjif_conolidado_concepto":
                this.xJIFFConsultDeduccionNomina.mBuscar();
                break;
            case "xjif_gestion_concepto_empleado":
                this.xJifGestion_Concepto.mBuscar();
                break;
            case "xjifconsolidadopersonal":
                this.xJIFConsolidadoPersonal.mBuscar();
                break;
            case "xjifnominainformecgr":
                this.xJIFNominaInformeCgr.mBuscar();
                break;
            case "xjifconsultarnominaxfecha":
                this.xJIFConsultarNominaxFecha.mBuscar();
                break;
            case "jiftramisionnominaelectronica":
                this.xFTransmisionNomina.buscar();
                break;
            case "jifinformeregistronovedades":
                this.novedadesRegistradas.buscar();
                break;
        }
    }

    public void imprimir(String frm) {
        switch (frm) {
            case "jifcuentacobrom1":
                this.xjifcuentacobrom1.mImprimir();
                break;
            case "xjifanticipo":
                this.xjifanticipos.mImprimir();
                break;
            case "xjif_liquidacionn":
                this.xJif_LiquidacionN.mImprimir();
                break;
            case "xjif_causacion_nomina":
                this.xJif_CausacionNomina.mImprimir();
                break;
            case "xjif_conolidado_concepto":
                this.xJIFFConsultDeduccionNomina.mImprimir();
                break;
            case "xjif_consultarplanillanomina":
                this.xJifConsultar_PNomina.mImprimir();
                break;
            case "xjifconsolidadoconceptosrh":
                this.xJIFConsolidadoConceptosRH.mImprimir();
                break;
            case "jiftramisionnominaelectronica":
                this.xFTransmisionNomina.imprimir();
                break;
        }
    }

    public void anular(String frm) {
        switch (frm) {
            case "jifcuentacobrom1":
                this.xjifcuentacobrom1.mAnular();
                break;
            case "xjif_causacion_nomina":
                this.xJif_CausacionNomina.mAnular();
                break;
            case "xjif_prestamos":
                this.xJIFPrestamos.mAnulacion();
                break;
            case "xjif_NovedadesNomina":
                this.xJIFNovedadesNomina.mAnulacion();
                break;
        }
    }

    public void imprimirSoporteNomina(String idLiquidacion, String numeroDocumento, JInternalFrame frame, int forma, Boolean visualizarPdf) {
        String[][] parametros = new String[5][2];
        parametros[0][0] = "Id_Liquidacion";
        parametros[0][1] = idLiquidacion;
        parametros[1][0] = "Documento";
        parametros[1][1] = numeroDocumento;
        parametros[2][0] = "Usuario";
        parametros[2][1] = Principal.usuarioSistemaDTO.getNombreUsuario();
        parametros[3][0] = "SUBREPORT_DIR";
        parametros[3][1] = this.xmetodo.getSO() + this.xmetodo.getBarra() + "Reportes" + this.xmetodo.getBarra();
        parametros[4][0] = "SUBREPORTFIRMA_DIR";
        parametros[4][1] = this.xmetodo.getSO() + this.xmetodo.getBarra() + "Firmas" + this.xmetodo.getBarra();
        if (visualizarPdf.booleanValue()) {
            if (forma == 0) {
                Object[] botones1 = {"Carta", "Media Carta", "Cerrar"};
                int j = JOptionPane.showInternalOptionDialog(frame, "Como desea visualizar?", "GENERACIÓN REPORTE", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), botones1, "Cerrar");
                if (j == 0) {
                    this.xmetodo.GenerarPDF(this.xmetodo.getRutaRep() + "N_Comprobante_Pago", parametros, visualizarPdf);
                    return;
                } else {
                    if (j == 1) {
                        this.xmetodo.GenerarPDF(this.xmetodo.getRutaRep() + "N_Comprobante_Pago_A5", parametros, visualizarPdf);
                        return;
                    }
                    return;
                }
            }
            return;
        }
        this.xmetodo.GenerarPDF(this.xmetodo.getRutaRep() + "N_Comprobante_Pago", parametros, visualizarPdf);
    }

    public void imprimirConsolidadoNomina(String idLiquidacion) {
        String[][] mparametros = new String[4][2];
        mparametros[0][0] = "Id_Liquidacion";
        mparametros[0][1] = idLiquidacion;
        mparametros[1][0] = "ValorL";
        mparametros[1][1] = "";
        mparametros[2][0] = "SUBREPORT_DIR";
        mparametros[2][1] = this.xmetodo.getSO() + this.xmetodo.getBarra() + "Reportes" + this.xmetodo.getBarra();
        mparametros[3][0] = "SUBREPORTFIRMA_DIR";
        mparametros[3][1] = this.xmetodo.getSO() + this.xmetodo.getBarra() + "Firmas" + this.xmetodo.getBarra();
        this.xmetodo.GenerarPDF(this.xmetodo.getRutaRep() + "N_Liqudiacion", mparametros);
    }

    public void imprimirConsolidadoNominaPorConcepto(String idLiquidacion) {
        String[][] mparametros = new String[3][2];
        mparametros[0][0] = "Id_Liquidacion";
        mparametros[0][1] = idLiquidacion;
        mparametros[1][0] = "SUBREPORT_DIR";
        mparametros[1][1] = this.xmetodo.getSO() + this.xmetodo.getBarra() + "Reportes" + this.xmetodo.getBarra();
        mparametros[2][0] = "SUBREPORTFIRMA_DIR";
        mparametros[2][1] = this.xmetodo.getSO() + this.xmetodo.getBarra() + "Firmas" + this.xmetodo.getBarra();
        this.xmetodo.GenerarPDF(this.xmetodo.getRutaRep() + "N_Consolidado_Concepto", mparametros);
    }
}
