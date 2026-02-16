package com.genoma.plus.dao.impl.salud_ocupacional;

import Acceso.Principal;
import com.genoma.plus.dao.salud_ocupacional.CertificadoSoDAO;
import com.genoma.plus.dto.gcuenta.GCGenericoDTO;
import com.genoma.plus.dto.salud_ocupacional.CertificadoSoDTO;
import com.genoma.plus.dto.salud_ocupacional.ConceptoxCertificadoSoDTO;
import com.genoma.plus.dto.salud_ocupacional.TipoCertificadoSoDTO;
import com.genoma.plus.dto.salud_ocupacional.TipoConceptoSoDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/salud_ocupacional/CertificadoSoDAOImpl.class */
public class CertificadoSoDAOImpl implements CertificadoSoDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.salud_ocupacional.CertificadoSoDAO
    public List<CertificadoSoDTO> listCertificado(String xidAtencion) {
        String sql = "SELECT\n    `h_so_certificados`.`Id`\n    , `so_tipo_certificados`.`Nbre` AS `TipoCertificado`\n    , `so_tipo_concepto`.`Nbre` AS `TipoConcepto`\n    , `h_so_certificados`.`Observacion`\nFROM\n    `h_so_certificados`\n    INNER JOIN `so_tipo_certificados` \n        ON (`h_so_certificados`.`Id_TipoCertificado` = `so_tipo_certificados`.`Id`)\n    INNER JOIN `so_tipo_concepto` \n        ON (`h_so_certificados`.`Id_TipoConcepto` = `so_tipo_concepto`.`Id`)\nWHERE (`h_so_certificados`.`Estado` =1\n    AND `h_so_certificados`.`Id_Atencion` ='" + xidAtencion + "')\nORDER BY `TipoCertificado` DESC, `TipoConcepto` ASC;";
        RowMapper rowMapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.salud_ocupacional.CertificadoSoDAOImpl.1
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                CertificadoSoDTO Lista = new CertificadoSoDTO();
                Lista.setId(rs.getInt("Id"));
                Lista.setIdTipoCertificado(rs.getString("TipoCertificado"));
                Lista.setIdTipoConcepto(rs.getString("TipoConcepto"));
                Lista.setObservacion(rs.getString("Observacion"));
                return Lista;
            }
        };
        List<CertificadoSoDTO> lsGen = this.jdbcTemplate.query(sql, rowMapper);
        return lsGen;
    }

    @Override // com.genoma.plus.dao.salud_ocupacional.CertificadoSoDAO
    public String createRevisionExamen(CertificadoSoDTO Certificado) {
        String result = "Se Insertó Correctamente";
        int ctos = this.jdbcTemplate.update("INSERT INTO `h_so_certificados`(`Id_Atencion`,`Id_TipoCertificado`,`Id_TipoConcepto`,`Observacion`,`Id_UsuarioS`)\nVALUES (?,?,?,?,?);", new Object[]{Integer.valueOf(Certificado.getIdAtencion()), Certificado.getIdTipoCertificado(), Certificado.getIdTipoConcepto(), Certificado.getObservacion(), Principal.usuarioSistemaDTO.getIdUsuarioSistema()});
        if (ctos == 0) {
            result = "No se insertó";
        }
        return result;
    }

    @Override // com.genoma.plus.dao.salud_ocupacional.CertificadoSoDAO
    public List<GCGenericoDTO> listaComboTipoCertificados() {
        RowMapper rowMapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.salud_ocupacional.CertificadoSoDAOImpl.2
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                GCGenericoDTO Lista = new GCGenericoDTO();
                Lista.setId(rs.getLong("Id"));
                Lista.setNombre(rs.getString("Nbre"));
                return Lista;
            }
        };
        List<GCGenericoDTO> lsGen = this.jdbcTemplate.query("SELECT `Id`, `Nbre` FROM `so_tipo_certificados` WHERE (`Estado` =1) ORDER BY `Nbre` ASC;", rowMapper);
        return lsGen;
    }

    @Override // com.genoma.plus.dao.salud_ocupacional.CertificadoSoDAO
    public List<GCGenericoDTO> listaComboTipoConcepto(String xidConcepto) {
        String sql = "SELECT\n    `so_tipo_concepto`.`Id`\n    , `so_tipo_concepto`.`Nbre`\nFROM\n    `so_tipo_certificado_concepto`\n    INNER JOIN `so_tipo_certificados` \n        ON (`so_tipo_certificado_concepto`.`Id_Certificado` = `so_tipo_certificados`.`Id`)\n    INNER JOIN `so_tipo_concepto` \n        ON (`so_tipo_certificado_concepto`.`Id_TipoConcepto` = `so_tipo_concepto`.`Id`)\nWHERE (`so_tipo_concepto`.`Estado` =1\n    AND `so_tipo_certificados`.`Id` ='" + xidConcepto + "')\nORDER BY `so_tipo_concepto`.`Nbre` ASC;";
        RowMapper rowMapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.salud_ocupacional.CertificadoSoDAOImpl.3
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                GCGenericoDTO Lista = new GCGenericoDTO();
                Lista.setId(rs.getLong("Id"));
                Lista.setNombre(rs.getString("Nbre"));
                return Lista;
            }
        };
        List<GCGenericoDTO> lsGen = this.jdbcTemplate.query(sql, rowMapper);
        return lsGen;
    }

    @Override // com.genoma.plus.dao.salud_ocupacional.CertificadoSoDAO
    public List<TipoCertificadoSoDTO> listTipoCertificado() {
        RowMapper rowMapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.salud_ocupacional.CertificadoSoDAOImpl.4
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                TipoCertificadoSoDTO Lista = new TipoCertificadoSoDTO();
                Lista.setId(rs.getInt("Id"));
                Lista.setNombre(rs.getString("Nbre"));
                Lista.setEncabezado(rs.getString("Encabezado"));
                Lista.setPiePagina(rs.getString("PiePagina"));
                Lista.setEstado(rs.getInt("Estado"));
                return Lista;
            }
        };
        List<TipoCertificadoSoDTO> lsGen = this.jdbcTemplate.query("SELECT `Id`, `Nbre`, `Encabezado`, `PiePagina`, `Estado` FROM `so_tipo_certificados` ORDER BY `Nbre` ASC;", rowMapper);
        return lsGen;
    }

    @Override // com.genoma.plus.dao.salud_ocupacional.CertificadoSoDAO
    public String createTipoCertificado(TipoCertificadoSoDTO Certificado) {
        String result = "Se Insertó Correctamente";
        int ctos = this.jdbcTemplate.update("INSERT INTO `so_tipo_certificados` (`Nbre`,`Encabezado`,`PiePagina`,`Estado`,`Id_UsuarioS`)\nVALUES (?,?,?,?,?);", new Object[]{Certificado.getNombre(), Certificado.getEncabezado(), Certificado.getPiePagina(), Integer.valueOf(Certificado.getEstado()), Principal.usuarioSistemaDTO.getIdUsuarioSistema()});
        if (ctos == 0) {
            result = "No se insertó";
        }
        return result;
    }

    @Override // com.genoma.plus.dao.salud_ocupacional.CertificadoSoDAO
    public String updateTipoCertificado(TipoCertificadoSoDTO Certificado) {
        String result = "Se actualizo Correctamente";
        int ctos = this.jdbcTemplate.update("UPDATE `so_tipo_certificados`\nSET `Nbre` = ?,\n  `Encabezado` = ?,\n  `PiePagina` = ?,\n  `Estado` = ?,\n  `Id_UsuarioS` = ?\nWHERE `Id` = ?;", new Object[]{Certificado.getNombre(), Certificado.getEncabezado(), Certificado.getPiePagina(), Integer.valueOf(Certificado.getEstado()), Principal.usuarioSistemaDTO.getIdUsuarioSistema(), Integer.valueOf(Certificado.getId())});
        if (ctos == 0) {
            result = "No se actualizo";
        }
        return result;
    }

    @Override // com.genoma.plus.dao.salud_ocupacional.CertificadoSoDAO
    public List<ConceptoxCertificadoSoDTO> listConceptoxCertificado(String xidCertificado) {
        String sql = "SELECT `so_tipo_concepto`.`Nbre` FROM `so_tipo_certificado_concepto` INNER JOIN `so_tipo_concepto` ON (`so_tipo_certificado_concepto`.`Id_TipoConcepto` = `so_tipo_concepto`.`Id`)\nWHERE (`so_tipo_certificado_concepto`.`Id_Certificado` ='" + xidCertificado + "') ORDER BY `so_tipo_concepto`.`Nbre` ASC;";
        RowMapper rowMapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.salud_ocupacional.CertificadoSoDAOImpl.5
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                ConceptoxCertificadoSoDTO Lista = new ConceptoxCertificadoSoDTO();
                Lista.setIdTipoConcepto(rs.getString("Nbre"));
                return Lista;
            }
        };
        List<ConceptoxCertificadoSoDTO> lsGen = this.jdbcTemplate.query(sql, rowMapper);
        return lsGen;
    }

    @Override // com.genoma.plus.dao.salud_ocupacional.CertificadoSoDAO
    public String createConceptoxCertificado(ConceptoxCertificadoSoDTO Certificado) {
        String result = "Se Insertó Correctamente";
        int ctos = this.jdbcTemplate.update("INSERT IGNORE INTO `so_tipo_certificado_concepto` (`Id_Certificado`, `Id_TipoConcepto`)\nVALUES (?, ?);", new Object[]{Integer.valueOf(Certificado.getIdCertificado()), Certificado.getIdTipoConcepto()});
        if (ctos == 0) {
            result = "No se insertó";
        }
        return result;
    }

    @Override // com.genoma.plus.dao.salud_ocupacional.CertificadoSoDAO
    public List<GCGenericoDTO> listaComboConceptoxCertificado() {
        RowMapper rowMapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.salud_ocupacional.CertificadoSoDAOImpl.6
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                GCGenericoDTO Lista = new GCGenericoDTO();
                Lista.setId(rs.getLong("Id"));
                Lista.setNombre(rs.getString("Nbre"));
                return Lista;
            }
        };
        List<GCGenericoDTO> lsGen = this.jdbcTemplate.query("SELECT `Id`, `Nbre` FROM `so_tipo_concepto` WHERE (`Estado` =1) ORDER BY `Nbre` ASC;", rowMapper);
        return lsGen;
    }

    @Override // com.genoma.plus.dao.salud_ocupacional.CertificadoSoDAO
    public List<TipoConceptoSoDTO> listTipoConcepto() {
        RowMapper rowMapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.salud_ocupacional.CertificadoSoDAOImpl.7
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                TipoConceptoSoDTO Concepto = new TipoConceptoSoDTO();
                Concepto.setId(rs.getInt("Id"));
                Concepto.setNombre(rs.getString("Nbre"));
                Concepto.setTipo(rs.getString("Tipo"));
                Concepto.setEstado(rs.getInt("Estado"));
                return Concepto;
            }
        };
        List<TipoConceptoSoDTO> lsGen = this.jdbcTemplate.query("SELECT `Id`, `Nbre`, IF(`Tipo`=0,'EGRESO',IF(`Tipo`=1,'INGRESO',IF(`Tipo`=2,'MEDICINA DEL DEPORTE','APTITUD ALTURA'))) AS Tipo , `Estado`\nFROM `so_tipo_concepto` ORDER BY `Tipo` ASC, `Nbre` ASC;", rowMapper);
        return lsGen;
    }

    @Override // com.genoma.plus.dao.salud_ocupacional.CertificadoSoDAO
    public String createTipoConcepto(TipoConceptoSoDTO Certificado) {
        String result = "Se Insertó Correctamente";
        int ctos = this.jdbcTemplate.update("INSERT INTO `so_tipo_concepto`(`Nbre`,`Tipo`,`Estado`,`UsuarioS`)\nVALUES (?,?,?,?);", new Object[]{Certificado.getNombre(), Certificado.getTipo(), Integer.valueOf(Certificado.getEstado()), Principal.usuarioSistemaDTO.getLogin()});
        if (ctos == 0) {
            result = "No se insertó";
        }
        return result;
    }

    @Override // com.genoma.plus.dao.salud_ocupacional.CertificadoSoDAO
    public String updateTipoConcepto(TipoConceptoSoDTO Certificado) {
        String result = "Se Insertó Correctamente";
        int ctos = this.jdbcTemplate.update("UPDATE `so_tipo_concepto`\nSET `Nbre` = ?,\n  `Tipo` = ?,\n  `Estado` = ?,\n  `UsuarioS` = ?\nWHERE `Id` = ?;", new Object[]{Certificado.getNombre(), Certificado.getTipo(), Integer.valueOf(Certificado.getEstado()), Principal.usuarioSistemaDTO.getLogin(), Integer.valueOf(Certificado.getId())});
        if (ctos == 0) {
            result = "No se insertó";
        }
        return result;
    }
}
