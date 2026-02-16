package com.genoma.plus.jpa.repository;

import com.genoma.plus.jpa.entity.INumeroSecuenciaXML;
import com.genoma.plus.jpa.entity.NotasNominaElectronica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/jpa/repository/NotaNominaRepository.class */
@Repository
public interface NotaNominaRepository extends JpaRepository<NotasNominaElectronica, Long> {
    @Query(value = "SELECT\n    LPAD(`consecutivo`,5,'0') AS consecutivo\n    , 'NNE' AS prefijo\n    ,CONCAT('NNE',consecutivo) AS numero\n FROM\n    `rh_nota_nomina_electronica`\nWHERE (`consecutivo` =:numero);", nativeQuery = true)
    INumeroSecuenciaXML obtenerNota(@Param("numero") Integer num);
}
