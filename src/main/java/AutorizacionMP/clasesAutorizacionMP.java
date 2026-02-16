package AutorizacionMP;

import Acceso.Principal;
import Mantenimiento.JIFReporte;
import com.genoma.plus.controller.sgc.JIF_Reportes_PyP_Generico;

/* JADX INFO: loaded from: GenomaP.jar:AutorizacionMP/clasesAutorizacionMP.class */
public class clasesAutorizacionMP {
    public JIFAutorizaciones autorizacion1;
    public JIFAutorizaciones1 autorizacion;
    private JIFCargarSoporte cargarsoporte;
    private JIFCargarSoporteLote cargarsoportelote;
    private JIFGenerarRelacionCobro generarrelacioncobro;
    private JIFConsultarDescuentos consultardescuentos;
    private JIFVerificarEstado verificardescuentos;
    private JIFReporte xjifreporte;
    private JIFMatriculaPE xjifmatricula;
    private JIFRegistroEnvioMP xjifregistroenvio;
    private JIFGenerarDescuento xjifgenerard;
    private JIFCargarDAcumulado xjifcargaracumulado;
    private JIFGenerarPlantillaCobroD xjifgenerarplantillac;
    private JIFSubirRelacionC xjifsubirrelaciona;
    private JIFAuditoriaFormulasMP xjifauditoriamp;
    private JIFRProductosNAutorizados xjifproductonoautorizados;
    private JIFConsultarInfMed xjifconsultarinfmed;
    private JIFConsultarAuditorias xjidconsultarauditoria;
    private JIFConsultasUsuarioEnv xjifconsultamatricula;
    private JIF_Reportes_PyP_Generico jifreportes;

    public void cargarPantalla(String frm) {
        if (frm.equals("Autorizaciones")) {
            this.autorizacion = new JIFAutorizaciones1();
            Principal.cargarPantalla(this.autorizacion);
            return;
        }
        if (frm.equals("Cargar Soporte Individual")) {
            this.cargarsoporte = new JIFCargarSoporte();
            Principal.cargarPantalla(this.cargarsoporte);
            return;
        }
        if (frm.equals("Generar Relacion Cobro")) {
            this.generarrelacioncobro = new JIFGenerarRelacionCobro();
            Principal.cargarPantalla(this.generarrelacioncobro);
            return;
        }
        if (frm.equals("Consulta x Usuario")) {
            this.consultardescuentos = new JIFConsultarDescuentos();
            Principal.cargarPantalla(this.consultardescuentos);
            return;
        }
        if (frm.equals("Verificación")) {
            this.verificardescuentos = new JIFVerificarEstado();
            Principal.cargarPantalla(this.verificardescuentos);
            return;
        }
        if (frm.equals("Cargar Soporte por Lote")) {
            this.cargarsoportelote = new JIFCargarSoporteLote();
            Principal.cargarPantalla(this.cargarsoportelote);
            return;
        }
        if (frm.equals("Reporte")) {
            this.xjifreporte = new JIFReporte("jifreporte1");
            Principal.cargarPantalla(this.xjifreporte);
            return;
        }
        if (frm.equals("Matricula")) {
            this.xjifmatricula = new JIFMatriculaPE();
            Principal.cargarPantalla(this.xjifmatricula);
            return;
        }
        if (frm.equals("Registro de Envío")) {
            this.xjifregistroenvio = new JIFRegistroEnvioMP();
            Principal.cargarPantalla(this.xjifregistroenvio);
            return;
        }
        if (frm.equals("GenerarD")) {
            this.xjifgenerard = new JIFGenerarDescuento();
            Principal.cargarPantalla(this.xjifgenerard);
            return;
        }
        if (frm.equals("Cargar al Acumulado")) {
            this.xjifcargaracumulado = new JIFCargarDAcumulado();
            Principal.cargarPantalla(this.xjifcargaracumulado);
            return;
        }
        if (frm.equals("Generar Plantilla de Cobro")) {
            this.xjifgenerarplantillac = new JIFGenerarPlantillaCobroD();
            Principal.cargarPantalla(this.xjifgenerarplantillac);
            return;
        }
        if (frm.equals("Conciliación Plantilla Aplicada")) {
            this.xjifsubirrelaciona = new JIFSubirRelacionC();
            Principal.cargarPantalla(this.xjifsubirrelaciona);
            return;
        }
        if (frm.equals("Auditoria Formulas MP")) {
            this.xjifauditoriamp = new JIFAuditoriaFormulasMP();
            Principal.cargarPantalla(this.xjifauditoriamp);
            return;
        }
        if (frm.equals("PNoAutorizados")) {
            this.xjifproductonoautorizados = new JIFRProductosNAutorizados(this.autorizacion.frmOrdenesSuministr.JTFNordenSum.getText());
            Principal.cargarPantalla(this.xjifproductonoautorizados);
            return;
        }
        if (frm.equals("PNoAutorizadosC")) {
            this.xjifconsultarinfmed = new JIFConsultarInfMed("xjifconsultarpn");
            Principal.cargarPantalla(this.xjifconsultarinfmed);
            return;
        }
        if (frm.equals("Consolidado Auditoria")) {
            this.xjidconsultarauditoria = new JIFConsultarAuditorias();
            Principal.cargarPantalla(this.xjidconsultarauditoria);
        } else if (frm.equals("CONSULTA USUARIOS MATRICULADOS")) {
            this.xjifconsultamatricula = new JIFConsultasUsuarioEnv("jifconsultausuario");
            Principal.cargarPantalla(this.xjifconsultamatricula);
        } else if (frm.equals("Informes Generales")) {
            this.jifreportes = new JIF_Reportes_PyP_Generico(10, "INFORMES GENERALES", "jif_ReportesPyP");
            Principal.cargarPantalla(this.jifreportes);
        }
    }

    public void nuevo(String frm) {
        if (!frm.equals("jifautorizacion")) {
            if (!frm.equals("jpicargardescuento")) {
                if (!frm.equals("jifconsultardescuentos")) {
                    if (!frm.equals("jifgenerarrelacioncobro")) {
                        if (!frm.equals("jifverificacion")) {
                            if (!frm.equals("jifcargarsoportelote")) {
                                if (!frm.equals("jifreporte1")) {
                                    if (!frm.equals("jifmatriculape")) {
                                        if (!frm.equals("jifregistroenvio")) {
                                            if (!frm.equals("jifgeneraciondescuento")) {
                                                if (!frm.equals("jifcargardescuentoacumulado")) {
                                                    if (!frm.equals("jifgenerarplantillacd")) {
                                                        if (!frm.equals("xjifconsultarpn")) {
                                                            if (frm.equals("xjifconsolidadoauditoria")) {
                                                                this.xjidconsultarauditoria.mNuevo();
                                                                return;
                                                            }
                                                            return;
                                                        }
                                                        this.xjifconsultarinfmed.mNuevo();
                                                        return;
                                                    }
                                                    this.xjifgenerarplantillac.mNuevo();
                                                    return;
                                                }
                                                this.xjifcargaracumulado.mNuevo();
                                                return;
                                            }
                                            this.xjifgenerard.mNuevo();
                                            return;
                                        }
                                        this.xjifregistroenvio.mNuevo();
                                        return;
                                    }
                                    this.xjifmatricula.mNuevo();
                                    return;
                                }
                                this.xjifreporte.nuevo();
                                return;
                            }
                            this.cargarsoportelote.nuevo();
                            return;
                        }
                        this.verificardescuentos.nuevo();
                        return;
                    }
                    this.generarrelacioncobro.nuevo();
                    return;
                }
                this.consultardescuentos.nuevo();
                return;
            }
            this.cargarsoporte.nuevo();
            return;
        }
        this.autorizacion.nuevo();
    }

    public void grabar(String frm) {
        if (!frm.equals("jifautorizacion")) {
            if (!frm.equals("jpicargardescuento")) {
                if (!frm.equals("jifverificacion")) {
                    if (!frm.equals("jifgenerarrelacioncobro")) {
                        if (!frm.equals("jifcargarsoportelote")) {
                            if (!frm.equals("jifreporte1")) {
                                if (!frm.equals("jifmatriculape")) {
                                    if (!frm.equals("jifregistroenvio")) {
                                        if (!frm.equals("jifgeneraciondescuento")) {
                                            if (!frm.equals("jifcargardescuentoacumulado")) {
                                                if (!frm.equals("jifgenerarplantillacd")) {
                                                    if (!frm.equals("jifsubirplantillad")) {
                                                        if (!frm.equals("jifauditoriafmp")) {
                                                            if (frm.equals("jifpnoautorizados")) {
                                                                this.xjifproductonoautorizados.mGrabar();
                                                                return;
                                                            }
                                                            return;
                                                        }
                                                        this.xjifauditoriamp.mGrabar();
                                                        return;
                                                    }
                                                    this.xjifsubirrelaciona.mGrabar();
                                                    return;
                                                }
                                                this.xjifgenerarplantillac.mGrabar();
                                                return;
                                            }
                                            this.xjifcargaracumulado.mGrabar();
                                            return;
                                        }
                                        this.xjifgenerard.mGrabar();
                                        return;
                                    }
                                    this.xjifregistroenvio.mGrabar();
                                    return;
                                }
                                this.xjifmatricula.mGrabar();
                                return;
                            }
                            this.xjifreporte.grabar();
                            return;
                        }
                        this.cargarsoportelote.grabar();
                        return;
                    }
                    this.generarrelacioncobro.grabar();
                    return;
                }
                this.verificardescuentos.grabar();
                return;
            }
            this.cargarsoporte.grabar();
            return;
        }
        this.autorizacion.grabar();
    }

    public void buscar(String frm) {
        if (!frm.equals("jifautorizacion")) {
            if (!frm.equals("jifconsultardescuentos")) {
                if (!frm.equals("jifverificacion")) {
                    if (!frm.equals("jifmatriculape")) {
                        if (!frm.equals("jifregistroenvio")) {
                            if (!frm.equals("jifgeneraciondescuento")) {
                                if (!frm.equals("jifcargardescuentoacumulado")) {
                                    if (!frm.equals("jifgenerarplantillacd")) {
                                        if (!frm.equals("jifsubirplantillad")) {
                                            if (!frm.equals("jifauditoriafmp")) {
                                                if (!frm.equals("xjifconsultarpn")) {
                                                    if (!frm.equals("xjifconsolidadoauditoria")) {
                                                        if (frm.equals("jifconsultausuario")) {
                                                            this.xjifconsultamatricula.mBuscar();
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    this.xjidconsultarauditoria.mBuscar();
                                                    return;
                                                }
                                                this.xjifconsultarinfmed.mBuscar();
                                                return;
                                            }
                                            this.xjifauditoriamp.mBuscar();
                                            return;
                                        }
                                        this.xjifsubirrelaciona.mBuscar();
                                        return;
                                    }
                                    this.xjifgenerarplantillac.mBuscar();
                                    return;
                                }
                                this.xjifcargaracumulado.mBuscar();
                                return;
                            }
                            this.xjifgenerard.mBuscar();
                            return;
                        }
                        this.xjifregistroenvio.mBuscar();
                        return;
                    }
                    this.xjifmatricula.mBuscar();
                    return;
                }
                this.verificardescuentos.buscar();
                return;
            }
            this.consultardescuentos.buscar();
            return;
        }
        this.autorizacion.buscar();
    }

    public void imprimir(String frm) {
        if (!frm.equals("jifconsultarmedicamentos")) {
            if (!frm.equals("jifgeneraciondescuento")) {
                if (frm.equals("jifgenerarrelacioncobro")) {
                    this.generarrelacioncobro.mImprimir();
                    return;
                }
                return;
            }
            this.xjifgenerard.mImprimir();
            return;
        }
        this.autorizacion.frmConsultar.imprimir();
    }

    public void anular(String frm) {
        if (!frm.equals("jifconsultarmedicamentos")) {
            if (frm.equals("jifgeneraciondescuento")) {
                this.xjifgenerard.mAnular();
                return;
            }
            return;
        }
        this.autorizacion.frmConsultar.anular();
    }
}
