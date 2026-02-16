package com.genoma.plus.dao.impl.general;

import com.genoma.plus.dao.general.MunicipioDAO;
import com.genoma.plus.dto.general.MunicipioDTO;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/general/MunicipioDAOImpl.class */
public class MunicipioDAOImpl implements MunicipioDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.general.MunicipioDAO
    public List<MunicipioDTO> listadoMunicipioFiltradoIdDepartamento(String idDepartamento) {
        BeanPropertyRowMapper bprm = new BeanPropertyRowMapper(MunicipioDTO.class);
        String sql = "SELECT\n    `Id` AS `idCodigo`\n    , `Nbre` AS `nombre`\n    , `Id_Dpto` AS `idDepartamento`\n    , IFNULL(`Cod_Sucursal`, '') AS `codigoSucursal`\n    , `VTaxi` AS `valorTaxi`\n    , `Estado` AS `estado`\n    , IFNULL(`Fecha`, '') AS `fecha`\n    , IFNULL(`UsuarioS`, '') AS `usuarioSistema`\nFROM\n    `g_municipio`\nWHERE (`Id_Dpto` ='" + idDepartamento + "')\nORDER BY `nombre` ASC";
        List<MunicipioDTO> e = this.jdbcTemplate.query(sql, bprm);
        return e;
    }
}
