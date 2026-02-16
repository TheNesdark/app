package com.genoma.plus.domains.models.repositories;

import com.genoma.plus.domains.models.domains.general.RecursosMicroserviciosDomain;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/domains/models/repositories/RecursosMicroserviciosFindAllDomainRepository.class */
public interface RecursosMicroserviciosFindAllDomainRepository {
    List<RecursosMicroserviciosDomain> findAll(Integer num, String str);
}
