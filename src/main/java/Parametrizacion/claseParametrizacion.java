package Parametrizacion;

import Acceso.Principal;
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
import Mantenimiento.JIFConfigurar;
import Mantenimiento.JIFReporte;
import Mantenimiento.JIPconsultar;
import Mantenimiento.Seguimiento;

/* JADX INFO: loaded from: GenomaP.jar:Parametrizacion/claseParametrizacion.class */
public class claseParametrizacion {
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
    public JIFRegistroTecnico xregistrotecnico;
    public JIFComponentes xcomponente;
    public JIFFrecuencias xfrecuencia;
    public JIFNormalidades xnormalidad;
    public JIFProcedimientos xprocedimiento;
    public JIFManuales xmanuales;
    public JIFRespuestos xrepuestos;
    private JIFServiciosMantenimiento xserman;
    public jiflaboratorio xlaboratorio;
    private JIFGenerico xgenerico;

    public void cargarPantalla(String frm, String ID) {
        if (frm.equals("Generar")) {
            if (this.xjifreporte != null) {
                this.xjifreporte.dispose();
            }
            this.xjifreporte = new JIFReporte("jifreporte");
            Principal.cargarPantalla(this.xjifreporte);
            this.xjifreporte.moveToFront();
            return;
        }
        if (frm.equals("Vacunas")) {
            if (this.xgenerico != null) {
                this.xgenerico.dispose();
            }
            this.xgenerico = new JIFGenerico("Generico");
            Principal.cargarPantalla(this.xgenerico);
            this.xgenerico.moveToFront();
            return;
        }
        if (frm.equals("Registro Tecnico")) {
            if (this.xregistrotecnico != null) {
                this.xregistrotecnico.dispose();
            }
            this.xregistrotecnico = new JIFRegistroTecnico();
            Principal.cargarPantalla(this.xregistrotecnico);
            this.xregistrotecnico.moveToFront();
            return;
        }
        if (frm.equals("Laboratorio")) {
            if (this.xlaboratorio != null) {
                this.xlaboratorio.dispose();
            }
            this.xlaboratorio = new jiflaboratorio();
            Principal.cargarPantalla(this.xlaboratorio);
            this.xlaboratorio.moveToFront();
            return;
        }
        if (frm.equals("Componentes")) {
            if (this.xcomponente != null) {
                this.xcomponente.dispose();
            }
            this.xcomponente = new JIFComponentes();
            Principal.cargarPantalla(this.xcomponente);
            this.xcomponente.moveToFront();
            return;
        }
        if (frm.equals("Frecuencias Procedimientos")) {
            if (this.xfrecuencia != null) {
                this.xfrecuencia.dispose();
            }
            this.xfrecuencia = new JIFFrecuencias();
            Principal.cargarPantalla(this.xfrecuencia);
            this.xfrecuencia.moveToFront();
            return;
        }
        if (frm.equals("Normalidad")) {
            if (this.xnormalidad != null) {
                this.xnormalidad.dispose();
            }
            this.xnormalidad = new JIFNormalidades();
            Principal.cargarPantalla(this.xnormalidad);
            this.xnormalidad.moveToFront();
            return;
        }
        if (frm.equals("Procedimientos")) {
            if (this.xprocedimiento != null) {
                this.xprocedimiento.dispose();
            }
            this.xprocedimiento = new JIFProcedimientos();
            Principal.cargarPantalla(this.xprocedimiento);
            this.xprocedimiento.moveToFront();
            return;
        }
        if (frm.equals("Manuales")) {
            if (this.xmanuales != null) {
                this.xmanuales.dispose();
            }
            this.xmanuales = new JIFManuales();
            Principal.cargarPantalla(this.xmanuales);
            this.xmanuales.moveToFront();
            return;
        }
        if (frm.equals("Repuestos")) {
            if (this.xrepuestos != null) {
                this.xrepuestos.dispose();
            }
            this.xrepuestos = new JIFRespuestos();
            Principal.cargarPantalla(this.xrepuestos);
            this.xrepuestos.moveToFront();
            return;
        }
        if (frm.equals("Servicios")) {
            if (this.xserman != null) {
                this.xserman.dispose();
            }
            this.xserman = new JIFServiciosMantenimiento();
            Principal.cargarPantalla(this.xserman);
            this.xserman.moveToFront();
        }
    }

    public void anular(String frm) {
        if (frm.equals("JIFRegistroTecnico")) {
            this.xregistrotecnico.eliminar();
        }
        if (frm.equals("JIFComponentes")) {
            this.xcomponente.eliminar();
        }
        if (frm.equals("JIFFrecuencias")) {
            this.xfrecuencia.eliminar();
        }
        if (frm.equals("JIFNormalidades")) {
            this.xnormalidad.eliminar();
        }
        if (frm.equals("JIFManuales")) {
            this.xmanuales.eliminar();
        }
        if (frm.equals("JIFProcedimientos")) {
            this.xprocedimiento.eliminar();
        }
        if (frm.equals("JIFRespuestos")) {
            this.xrepuestos.eliminar();
        }
        if (frm.equals("JIFServiciosMantenimiento")) {
            this.xserman.eliminar();
        }
    }

    public void buscar(String frm) {
    }

    public void desplazar(String frm, int boton) {
    }

    public void imprimir(String frm) {
    }

    public void nuevo(String frm) {
        if (frm.equals("jifreporte")) {
            this.xjifreporte.nuevo();
        }
        if (frm.equals("JIFConfigurar")) {
            this.xConfigurar.nuevo();
        }
    }

    public void grabar(String frm) {
        if (!frm.equals("jifreporte")) {
            if (!frm.equals("seguimiento")) {
                if (!frm.equals("JIFConfigurar")) {
                    if (!frm.equals("JIFRegistroTecnico")) {
                        if (!frm.equals("JIFComponentes")) {
                            if (!frm.equals("JIFFrecuencias")) {
                                if (!frm.equals("JIFNormalidades")) {
                                    if (!frm.equals("JIFManuales")) {
                                        if (!frm.equals("JIFProcedimientos")) {
                                            if (!frm.equals("JIFRespuestos")) {
                                                if (!frm.equals("JIFServiciosMantenimiento")) {
                                                    if (frm.equals("jiflaboratorio")) {
                                                        this.xlaboratorio.grabar();
                                                        return;
                                                    }
                                                    return;
                                                }
                                                this.xserman.grabar();
                                                return;
                                            }
                                            this.xrepuestos.grabar();
                                            return;
                                        }
                                        this.xprocedimiento.grabar();
                                        return;
                                    }
                                    this.xmanuales.grabar();
                                    return;
                                }
                                this.xnormalidad.grabar();
                                return;
                            }
                            this.xfrecuencia.grabar();
                            return;
                        }
                        this.xcomponente.grabar();
                        return;
                    }
                    this.xregistrotecnico.grabar();
                    return;
                }
                this.xConfigurar.grabar();
                return;
            }
            this.xseguimiento.grabar();
            return;
        }
        this.xjifreporte.grabar();
    }
}
