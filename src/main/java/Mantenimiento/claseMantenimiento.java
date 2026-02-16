package Mantenimiento;

import Acceso.Principal;
import Activos.JIFGestionActivos;
import Contabilidad.JIFGenerico1CheckBoxC;
import Laboratorio.Agenda;
import Laboratorio.Areas;
import Laboratorio.ImporExpor;
import Laboratorio.Imprimir;
import Laboratorio.JIFAuditoriaTiempos;
import Laboratorio.JIFProcedimientoxProtocolo;
import Laboratorio.JIFProtocolos;
import Laboratorio.JIFProtocoloxTipoResultado;
import Laboratorio.RecepcionAuto;
import Laboratorio.RecepcionManual;
import Laboratorio.ResultadoManual;
import Laboratorio.TipoResultado;
import ParametrizacionN.JIFGenerico1Text1Combo1CheckBox1;
import com.genoma.plus.controller.sgc.JIF_Reportes_PyP_Generico;

/* JADX INFO: loaded from: GenomaP.jar:Mantenimiento/claseMantenimiento.class */
public class claseMantenimiento {
    public Principal frmPrincipal;
    public RecepcionAuto frmRecep;
    public ImporExpor frmIE;
    public Areas frmAreas;
    public JIFProtocolos frmProto;
    public JIFProcedimientoxProtocolo frmPxAxP;
    public TipoResultado frmTipoRes;
    public RecepcionManual frmRecepManual;
    public JIFProtocoloxTipoResultado frmPxTR;
    public ResultadoManual frmResultManual;
    public JIFAuditoriaTiempos jifauditoria;
    public Imprimir frmImp;
    public Agenda frmAgenda;
    public JIFReporte xjifreporte;
    public JIPconsultar xjipconsultar;
    public Seguimiento xseguimiento;
    public JIFConfigurar xConfigurar;
    public ConfigComplementos xConfiguraciones;
    public Seguimiento_Mantenimiento xmantenimiento;
    public JIFInspecciones xinspecciones;
    public JIFCalibrar xcalibra;
    public JIFEquiposdebaja xbaja;
    public Cambios xcambio;
    public historial xhistorial;
    public Reportesmantenimiento xreport;
    public aprobo_termino xabprobo;
    public JIFTiemporeporte xtiempo;
    private JIF_Reportes_PyP_Generico jifreportes;
    private JIFGestionActivos xjifgestionactivo;
    public JIFGenerico1CheckBoxC xjifgenerico;
    public JIFGenerico1Text1Combo1CheckBox1 xjifgenerico2;

    public void cargarPantalla(String frm) {
        if (frm.equals("Gestion Activos")) {
            this.xjifgestionactivo = new JIFGestionActivos("xjifgestionactivos");
            Principal.cargarPantalla(this.xjifgestionactivo);
        } else if (frm.equals("Informes Generales")) {
            this.jifreportes = new JIF_Reportes_PyP_Generico(25, "INFORMES GENERALES", "jif_ReportesPyP");
            Principal.cargarPantalla(this.jifreportes);
        }
    }

    public void cargarPantalla(String frm, String ID) {
        switch (frm) {
            case "Generar":
                if (this.xjifreporte != null) {
                    this.xjifreporte.dispose();
                }
                this.xjifreporte = new JIFReporte("jifreporte");
                Principal.cargarPantalla(this.xjifreporte);
                this.xjifreporte.moveToFront();
                break;
            case "Reportes":
                if (this.xreport != null) {
                    this.xreport.dispose();
                }
                this.xreport = new Reportesmantenimiento();
                Principal.cargarPantalla(this.xreport);
                this.xreport.moveToFront();
                break;
            case "Cambios":
                if (this.xcambio != null) {
                    this.xcambio.dispose();
                }
                this.xcambio = new Cambios();
                Principal.cargarPantalla(this.xcambio);
                this.xcambio.moveToFront();
                break;
            case "Historial":
                if (this.xhistorial != null) {
                    this.xhistorial.dispose();
                }
                this.xhistorial = new historial(this);
                Principal.cargarPantalla(this.xhistorial);
                this.xhistorial.moveToFront();
                break;
            case "Equipos Activos / Inactivos":
                if (this.xbaja != null) {
                    this.xbaja.dispose();
                }
                this.xbaja = new JIFEquiposdebaja();
                Principal.cargarPantalla(this.xbaja);
                this.xbaja.moveToFront();
                break;
            case "Consultar Estado":
                if (this.xjipconsultar != null) {
                    this.xjipconsultar.dispose();
                }
                this.xjipconsultar = new JIPconsultar(this);
                Principal.cargarPantalla(this.xjipconsultar);
                this.xjipconsultar.moveToFront();
                break;
            case "Seguimiento":
                if (this.xseguimiento != null) {
                    this.xseguimiento.dispose();
                }
                this.xseguimiento = new Seguimiento(ID);
                Principal.cargarPantalla(this.xseguimiento);
                this.xseguimiento.moveToFront();
                break;
            case "aprobo":
                if (this.xabprobo != null) {
                    this.xabprobo.dispose();
                }
                this.xabprobo = new aprobo_termino();
                Principal.cargarPantalla(this.xabprobo);
                this.xabprobo.moveToFront();
                break;
            case "Ingresar Equipos":
                if (this.xConfigurar != null) {
                    this.xConfigurar.dispose();
                }
                this.xConfigurar = new JIFConfigurar(this);
                Principal.cargarPantalla(this.xConfigurar);
                this.xConfigurar.moveToFront();
                break;
            case "Configurar Componentes":
                if (this.xConfiguraciones != null) {
                    this.xConfiguraciones.dispose();
                }
                this.xConfiguraciones = new ConfigComplementos();
                Principal.cargarPantalla(this.xConfiguraciones);
                this.xConfiguraciones.moveToFront();
                break;
            case "Seguimientos":
                if (this.xmantenimiento != null) {
                    this.xmantenimiento.dispose();
                }
                this.xmantenimiento = new Seguimiento_Mantenimiento(ID);
                Principal.cargarPantalla(this.xmantenimiento);
                this.xmantenimiento.moveToFront();
                break;
            case "Soporte Calibracion":
                if (this.xcalibra != null) {
                    this.xcalibra.dispose();
                }
                this.xcalibra = new JIFCalibrar();
                Principal.cargarPantalla(this.xcalibra);
                this.xcalibra.moveToFront();
                break;
            case "Inspecciones Planeadas":
                if (this.xinspecciones != null) {
                    this.xinspecciones.dispose();
                }
                this.xinspecciones = new JIFInspecciones();
                Principal.cargarPantalla(this.xinspecciones);
                this.xinspecciones.moveToFront();
                break;
            case "Tiempo Reportes":
                if (this.xtiempo != null) {
                    this.xtiempo.dispose();
                }
                this.xtiempo = new JIFTiemporeporte(this);
                Principal.cargarPantalla(this.xtiempo);
                this.xtiempo.moveToFront();
                break;
        }
    }

    public void anular(String frm) {
        if (frm.equals("JIFConfigurar")) {
            this.xConfigurar.eliminar();
        }
    }

    public void buscar(String frm) {
    }

    public void desplazar(String frm, int boton) {
    }

    public void imprimir(String frm) {
        switch (frm) {
            case "JIFConfigurar":
                this.xConfigurar.imprimir();
                break;
            case "Seguimiento_Mantenimiento":
                this.xmantenimiento.imprimir();
                break;
            case "JIFEquiposdebaja":
                this.xbaja.imprimir();
                break;
            case "xjifgestionactivos":
                this.xjifgestionactivo.mImprimir();
                break;
        }
    }

    public void nuevo(String frm) {
        switch (frm) {
            case "jifreporte":
                this.xjifreporte.nuevo();
                break;
            case "JIFConfigurar":
                this.xConfigurar.nuevo();
                break;
            case "Seguimiento_Mantenimiento":
                this.xmantenimiento.nuevo();
                break;
            case "xjifgestionactivos":
                this.xjifgestionactivo.mNuevo();
                break;
        }
    }

    public void grabar(String frm) {
        switch (frm) {
            case "jifreporte":
                this.xjifreporte.grabar();
                break;
            case "seguimiento":
                this.xseguimiento.grabar();
                break;
            case "JIFConfigurar":
                this.xConfigurar.grabar();
                break;
            case "Seguimiento_Mantenimiento":
                this.xmantenimiento.grabar();
                break;
            case "JIFEquiposdebaja":
                this.xbaja.grabar();
                break;
            case "JIFCalibrar":
                this.xcalibra.grabar();
                break;
            case "jifgenericoc1":
                this.xjifgenerico.mGrabar();
                break;
            case "xjifubicacion1":
                this.xjifgenerico2.mGrabar();
                break;
            case "xjifgestionactivos":
                this.xjifgestionactivo.mGrabar();
                break;
        }
    }

    public void ir() {
        if (this.xabprobo != null) {
            this.xabprobo.dispose();
        }
        this.xabprobo = new aprobo_termino();
        Principal.cargarPantalla(this.xabprobo);
        this.xabprobo.moveToFront();
    }
}
