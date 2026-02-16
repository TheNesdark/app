package com.genoma.plus.dao.impl.general;

import Acceso.Principal;
import com.genoma.plus.dao.general.BuscarConceptoNominaxVFijoDAO;
import com.genoma.plus.dto.gcuenta.GCGenericoDTO;
import com.genoma.plus.dto.general.BuscarConceptoNominaxVFijoDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/general/BuscarConceptoNominaxVFijoDAOImpl.class */
public class BuscarConceptoNominaxVFijoDAOImpl implements BuscarConceptoNominaxVFijoDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.general.BuscarConceptoNominaxVFijoDAO
    public List<BuscarConceptoNominaxVFijoDTO> list(String xidunidadfc, String xbuscar) {
        String sql = "SELECT  `rh_nomina_concepto_unidadf`.`Id` , `rh_nomina_conceptos`.`Nbre` , `rh_nomina_conceptos`.`TipoCalculo` , `rh_nomina_conceptos`.`MTercero`, `rh_nomina_conceptos`.Valor, `rh_nomina_conceptos`.ValorE \nFROM `rh_nomina_concepto_unidadf` INNER JOIN  `rh_nomina_conceptos`  ON (`rh_nomina_concepto_unidadf`.`Id_ConceptosN` = `rh_nomina_conceptos`.`Id`) \nWHERE (`rh_nomina_concepto_unidadf`.`Id_UnidaFC` ='" + xidunidadfc + "' AND `rh_nomina_conceptos`.`EsFijo`=1 AND `rh_nomina_conceptos`.`Nbre` LIKE '%" + xbuscar + "%' AND `rh_nomina_conceptos`.`Estado` =1)  \nORDER BY `rh_nomina_conceptos`.`Nbre` ASC ";
        RowMapper rowMapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.general.BuscarConceptoNominaxVFijoDAOImpl.1
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                BuscarConceptoNominaxVFijoDTO Lista = new BuscarConceptoNominaxVFijoDTO();
                Lista.setId(rs.getInt("Id"));
                Lista.setNConcepto(rs.getString("Nbre"));
                Lista.setTCalculo(rs.getString("TipoCalculo"));
                Lista.setMTercero(rs.getInt("MTercero"));
                Lista.setValor(rs.getDouble("Valor"));
                Lista.setValorE(rs.getDouble("ValorE"));
                return Lista;
            }
        };
        List<BuscarConceptoNominaxVFijoDTO> lsGen = this.jdbcTemplate.query(sql, rowMapper);
        return lsGen;
    }

    @Override // com.genoma.plus.dao.general.BuscarConceptoNominaxVFijoDAO
    public String create(BuscarConceptoNominaxVFijoDTO ConceptoNomina) {
        String result = "Se Insertó Correctamente";
        int ctos = this.jdbcTemplate.update("insert ignore into rh_nomina_persona_conceptos(`Id_PersonaC`,`Id_RhConcepto_UF`,`TCalculo`,`Valor`,ValorE, `Id_Tercero`, Estado, Id_UsuarioS) VALUES (?,?,?,?,?,?,?,?);", new Object[]{ConceptoNomina.getIdTerceroC(), Integer.valueOf(ConceptoNomina.getId()), ConceptoNomina.getTCalculo(), Double.valueOf(ConceptoNomina.getValor()), Double.valueOf(ConceptoNomina.getValorE()), Integer.valueOf(ConceptoNomina.getIdCNTercero()), Integer.valueOf(ConceptoNomina.getEstado()), Principal.usuarioSistemaDTO.getIdPersonaCargo()});
        if (ctos == 0) {
            result = "No se insertó";
        }
        return result;
    }

    @Override // com.genoma.plus.dao.general.BuscarConceptoNominaxVFijoDAO
    public List<GCGenericoDTO> listTerceros() {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.general.BuscarConceptoNominaxVFijoDAOImpl.2
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                GCGenericoDTO g = new GCGenericoDTO();
                g.setIdString(rs.getString("Id"));
                g.setNombre(rs.getString("RazonSocialCompleta"));
                return g;
            }
        };
        List<GCGenericoDTO> list = this.jdbcTemplate.query("SELECT  `Id` , `RazonSocialCompleta` , `No_identificacion` FROM `cc_terceros` WHERE (`EsNomina` =1) ORDER BY RazonSocialCompleta ASC ", mapper);
        return list;
    }
}
