package com.genoma.plus.controller.utilidades;

import Utilidades.Metodos;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.genoma.plus.controller.historia.ImpresionAnexo2335;
import com.genoma.plus.controller.historia.dto.OrdenamientoMedico;
import com.genoma.plus.controller.laboratorio.dto.CustomPresenter;
import com.genoma.plus.domains.models.domains.general.RecursosMicroserviciosDomain;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.ws.rs.core.Response;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/utilidades/InformacionOrdenamientoMedico.class */
public class InformacionOrdenamientoMedico {
    private static Metodos metodo = new Metodos();
    private static List<OrdenamientoMedico> ordenamientoMedico = new ArrayList();

    /* JADX WARN: Not initialized variable reg: 10, insn: 0x010d: MOVE (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r10 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:23:0x010d */
    /* JADX WARN: Not initialized variable reg: 9, insn: 0x0108: MOVE (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r9 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY] A[D('response' javax.ws.rs.core.Response)]) A[TRY_LEAVE], block:B:21:0x0108 */
    protected static void getFindAllOrdenamientoMedico(Integer idTipoServicio, Boolean cerrado) {
        ordenamientoMedico = new ArrayList();
        try {
            try {
                RecursosMicroserviciosDomain microserviciosDomain = metodo.getParametrosEncriptados("100", "findAllOrdenameintoMedico");
                String fullUrl = microserviciosDomain.getUrlRecurso() + "/" + idTipoServicio + "/" + cerrado;
                System.out.println("RECUPERANDO DATOS DE ORDENAMIENTO --- " + fullUrl);
                Response response = metodo.getResteasyClient().target(fullUrl).request().get();
                Throwable th = null;
                int statusCode = response.getStatus();
                if (statusCode == 200) {
                    try {
                        new CustomPresenter();
                        CustomPresenter presenter = (CustomPresenter) metodo.getMapper().readValue((String) response.readEntity(String.class), CustomPresenter.class);
                        ordenamientoMedico = (List) metodo.getMapper().readValue(metodo.getMapper().writeValueAsString(presenter.getData()), new TypeReference<List<OrdenamientoMedico>>() { // from class: com.genoma.plus.controller.utilidades.InformacionOrdenamientoMedico.1
                        });
                    } catch (JsonProcessingException e) {
                        Logger.getLogger(ImpresionAnexo2335.class.getName()).log(Level.SEVERE, (String) null, e);
                    }
                }
                if (response != null) {
                    if (0 != 0) {
                        try {
                            response.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    } else {
                        response.close();
                    }
                }
                metodo.getResteasyClient().close();
            } finally {
            }
        } catch (IllegalArgumentException | NullPointerException e2) {
            Logger.getLogger(ImpresionAnexo2335.class.getName()).log(Level.SEVERE, (String) null, (Throwable) e2);
        }
    }

    /* JADX WARN: Not initialized variable reg: 10, insn: 0x012a: MOVE (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r10 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:32:0x012a */
    /* JADX WARN: Not initialized variable reg: 9, insn: 0x0125: MOVE (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r9 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY] A[D('response' javax.ws.rs.core.Response)]) A[TRY_LEAVE], block:B:30:0x0125 */
    protected static Integer getCantidadOrdenamientoMedico(Integer idTipoServicio, Boolean cerrado) {
        Response response;
        Throwable th;
        ordenamientoMedico = new ArrayList();
        try {
            try {
                RecursosMicroserviciosDomain microserviciosDomain = metodo.getParametrosEncriptados("100", "cantidadOrdenameintoMedico");
                String fullUrl = microserviciosDomain.getUrlRecurso() + "/" + idTipoServicio + "/" + cerrado;
                System.out.println("Recuperando solo cantidad de registro en ordenamiento --- " + fullUrl);
                Response response2 = metodo.getResteasyClient().target(fullUrl).request().get();
                Throwable th2 = null;
                int statusCode = response2.getStatus();
                if (statusCode == 200) {
                    try {
                        new CustomPresenter();
                        CustomPresenter presenter = (CustomPresenter) metodo.getMapper().readValue((String) response2.readEntity(String.class), CustomPresenter.class);
                        Integer num = (Integer) metodo.getMapper().readValue(metodo.getMapper().writeValueAsString(presenter.getData()), Integer.class);
                        if (response2 != null) {
                            if (0 != 0) {
                                try {
                                    response2.close();
                                } catch (Throwable th3) {
                                    th2.addSuppressed(th3);
                                }
                            } else {
                                response2.close();
                            }
                        }
                        return num;
                    } catch (JsonProcessingException e) {
                        Logger.getLogger(ImpresionAnexo2335.class.getName()).log(Level.SEVERE, (String) null, e);
                    }
                }
                if (response2 != null) {
                    if (0 != 0) {
                        try {
                            response2.close();
                        } catch (Throwable th4) {
                            th2.addSuppressed(th4);
                        }
                    } else {
                        response2.close();
                    }
                }
                metodo.getResteasyClient().close();
                return null;
            } catch (Throwable th5) {
                if (response != null) {
                    if (th != null) {
                        try {
                            response.close();
                        } catch (Throwable th6) {
                            th.addSuppressed(th6);
                        }
                    } else {
                        response.close();
                    }
                }
                throw th5;
            }
        } catch (IllegalArgumentException | NullPointerException e2) {
            Logger.getLogger(ImpresionAnexo2335.class.getName()).log(Level.SEVERE, (String) null, (Throwable) e2);
            return null;
        }
    }

    public static int getSoloCantidadNumeroRegistro(Boolean cerrado, int idServicio) {
        return getCantidadOrdenamientoMedico(Integer.valueOf(idServicio), cerrado).intValue();
    }

    public static int getNumeroRegistro(Boolean cerrado, int idServicio) {
        getFindAllOrdenamientoMedico(Integer.valueOf(idServicio), cerrado);
        getOrdenamientoMedicoFiltrado(idServicio);
        return getOrdenamientoMedicoFiltrado(idServicio).size();
    }

    public static List<OrdenamientoMedico> getOrdenamientoMedicoFiltrado(int idServicio) {
        return (List) ordenamientoMedico.stream().filter(ordenamientoMedico2 -> {
            return ordenamientoMedico2.getIdServicio().equals(Integer.valueOf(idServicio));
        }).collect(Collectors.toList());
    }
}
