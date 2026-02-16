package Utilidades;

import Acceso.Principal;
import com.genoma.plus.jpa.entities.GServicioGrupoEntity;
import com.genoma.plus.jpa.entities.GServicioRipsEntity;
import com.genoma.plus.jpa.service.GServicioGrupoService;
import com.genoma.plus.jpa.service.GServicioRipsService;
import com.genoma.plus.jpa.service.IGEntornoAtencionService;
import com.genoma.plus.jpa.service.IGModalidadAtencionService;
import com.genoma.plus.jpa.service.IGSedesService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lombok.Generated;

/* JADX INFO: loaded from: GenomaP.jar:Utilidades/LlenarCombosGenericos.class */
public class LlenarCombosGenericos<K> {
    private final IGEntornoAtencionService gEntornoAtencionService = (IGEntornoAtencionService) Principal.contexto.getBean(IGEntornoAtencionService.class);
    private final IGModalidadAtencionService gModalidadAtencionService = (IGModalidadAtencionService) Principal.contexto.getBean(IGModalidadAtencionService.class);
    private final GServicioGrupoService gServicioGrupoService = (GServicioGrupoService) Principal.contexto.getBean(GServicioGrupoService.class);
    private final GServicioRipsService gServicioRipsService = (GServicioRipsService) Principal.contexto.getBean(GServicioRipsService.class);
    private final IGSedesService sedesService = (IGSedesService) Principal.contexto.getBean(IGSedesService.class);

    @Generated
    public LlenarCombosGenericos() {
    }

    @Generated
    public IGEntornoAtencionService getGEntornoAtencionService() {
        return this.gEntornoAtencionService;
    }

    @Generated
    public IGModalidadAtencionService getGModalidadAtencionService() {
        return this.gModalidadAtencionService;
    }

    @Generated
    public GServicioGrupoService getGServicioGrupoService() {
        return this.gServicioGrupoService;
    }

    @Generated
    public GServicioRipsService getGServicioRipsService() {
        return this.gServicioRipsService;
    }

    @Generated
    public IGSedesService getSedesService() {
        return this.sedesService;
    }

    public List<K> getListComboLleno(String nombreCombo) {
        List<K> list;
        list = new ArrayList();
        switch (nombreCombo) {
            case "modalidadAtencion":
                list = this.gModalidadAtencionService.getListAllOrderByNombre();
                break;
            case "entornoAtencion":
                list = this.gEntornoAtencionService.listarGEntornoAtencion();
                break;
            case "grupoServicio":
                list = this.gServicioGrupoService.findAByOrderByNombre();
                break;
            case "sedeServicio":
                list = this.sedesService.listaSedePorEstadoOrdeAsc(Boolean.TRUE);
                break;
        }
        return list;
    }

    public List<GServicioRipsEntity> getListComboLlenoParametro(String nombreCombo, Object object) {
        List<GServicioRipsEntity> list;
        list = new ArrayList<>();
        switch (nombreCombo) {
            case "servicioRips":
                if (object instanceof GServicioGrupoEntity) {
                    GServicioGrupoEntity gServicioGrupoEntity = (GServicioGrupoEntity) object;
                    Optional<GServicioGrupoEntity> o = this.gServicioGrupoService.findById(gServicioGrupoEntity.getId().toString());
                    if (o.isPresent()) {
                        GServicioGrupoEntity grupo = o.get();
                        List<GServicioRipsEntity> ripsList = this.gServicioRipsService.findByidGrupoServicio(grupo);
                        if (!ripsList.isEmpty()) {
                            for (GServicioRipsEntity rips : ripsList) {
                                list.add(rips);
                            }
                        }
                    }
                    break;
                }
                break;
        }
        return list;
    }
}
