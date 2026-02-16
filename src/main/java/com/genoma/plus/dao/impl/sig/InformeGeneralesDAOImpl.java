package com.genoma.plus.dao.impl.sig;

import Utilidades.ConsultasMySQL;
import com.genoma.plus.dao.sig.InformeGeneralesPyPDAO;
import com.genoma.plus.dto.gcuenta.GCGenericoDTO;
import com.genoma.plus.dto.sig.InformeGeneralPypDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/sig/InformeGeneralesDAOImpl.class */
public class InformeGeneralesDAOImpl implements InformeGeneralesPyPDAO {
    private JdbcTemplate jdbcTemplate;
    private String fechaI;
    private String fechaF;
    private ConsultasMySQL xConsultasMySQL;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.sig.InformeGeneralesPyPDAO
    public void mEjecutarSql(String fechaInicial, String fechaFinal, final String xIdEmpresa, String idInforme) {
        this.fechaI = fechaInicial;
        this.fechaF = fechaFinal;
        System.err.println("tipo de informe" + idInforme);
        String xSql = "SELECT  `Id`,  ConsultasSql, `Parametro`, `Orden` , TipoInforme FROM `baseserver`.`p_res_consultas_informes` WHERE ( Estado=1 AND tipoInforme='" + idInforme + "' ) ORDER BY `Orden` ASC;";
        RowMapper rowMapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.sig.InformeGeneralesDAOImpl.1
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                InformeGeneralPypDTO xDatos = new InformeGeneralPypDTO();
                xDatos.setXId(rs.getInt(1));
                xDatos.setConsultaSql(rs.getString(2));
                xDatos.setXNParametros(rs.getInt(3));
                xDatos.setXOrden(rs.getInt(4));
                xDatos.setXIdInforme(rs.getInt(5));
                System.out.println("SQL Parametros - -->" + rs.getInt(3));
                System.out.println("SQL Orden  - -->" + rs.getInt(4));
                System.out.println("SQL TipoInforme  - -->" + rs.getInt(5));
                String xSql_Vista = rs.getString("ConsultasSql");
                if (rs.getInt(5) == 1) {
                    if (rs.getInt(4) == 0 && rs.getInt(3) == 0) {
                        InformeGeneralesDAOImpl.this.jdbcTemplate.update(xSql_Vista);
                    }
                    if (rs.getInt(4) == 1 && rs.getInt(3) == 0) {
                        InformeGeneralesDAOImpl.this.jdbcTemplate.update(xSql_Vista);
                    }
                    if (rs.getInt(4) == 2 && rs.getInt(3) == 3) {
                        InformeGeneralesDAOImpl.this.jdbcTemplate.update(xSql_Vista, new Object[]{InformeGeneralesDAOImpl.this.fechaI, InformeGeneralesDAOImpl.this.fechaF, xIdEmpresa});
                    }
                }
                if (rs.getInt(5) == 3) {
                    if (rs.getInt(4) == 0 && rs.getInt(3) == 0) {
                        InformeGeneralesDAOImpl.this.jdbcTemplate.update(xSql_Vista);
                    }
                    if (rs.getInt(4) == 1) {
                        if (rs.getInt(3) == 0) {
                            InformeGeneralesDAOImpl.this.jdbcTemplate.update(xSql_Vista);
                        }
                        if (rs.getInt(3) == 4) {
                            InformeGeneralesDAOImpl.this.jdbcTemplate.update(xSql_Vista, new Object[]{InformeGeneralesDAOImpl.this.fechaI, InformeGeneralesDAOImpl.this.fechaI, InformeGeneralesDAOImpl.this.fechaF, xIdEmpresa});
                        }
                    }
                    if (rs.getInt(4) == 2) {
                        if (rs.getInt(3) == 1) {
                            InformeGeneralesDAOImpl.this.jdbcTemplate.update(xSql_Vista, new Object[]{InformeGeneralesDAOImpl.this.fechaF});
                        }
                        if (rs.getInt(3) == 2) {
                            InformeGeneralesDAOImpl.this.jdbcTemplate.update(xSql_Vista, new Object[]{InformeGeneralesDAOImpl.this.fechaI, InformeGeneralesDAOImpl.this.fechaF});
                        }
                    }
                }
                if (rs.getInt(5) == 4) {
                    if (rs.getInt(4) == 0 && rs.getInt(3) == 0) {
                        InformeGeneralesDAOImpl.this.jdbcTemplate.update(xSql_Vista);
                    }
                    if (rs.getInt(4) == 1 && rs.getInt(3) == 4) {
                        InformeGeneralesDAOImpl.this.jdbcTemplate.update(xSql_Vista, new Object[]{InformeGeneralesDAOImpl.this.fechaI, InformeGeneralesDAOImpl.this.fechaI, InformeGeneralesDAOImpl.this.fechaF, xIdEmpresa});
                    }
                    if (rs.getInt(4) == 2) {
                        if (rs.getInt(3) == 1) {
                            InformeGeneralesDAOImpl.this.jdbcTemplate.update(xSql_Vista, new Object[]{InformeGeneralesDAOImpl.this.fechaF});
                        }
                        if (rs.getInt(3) == 2) {
                            InformeGeneralesDAOImpl.this.jdbcTemplate.update(xSql_Vista, new Object[]{InformeGeneralesDAOImpl.this.fechaI, InformeGeneralesDAOImpl.this.fechaF});
                        }
                        if (rs.getInt(3) == 4) {
                            InformeGeneralesDAOImpl.this.jdbcTemplate.update(xSql_Vista, new Object[]{InformeGeneralesDAOImpl.this.fechaI, InformeGeneralesDAOImpl.this.fechaI, InformeGeneralesDAOImpl.this.fechaF, xIdEmpresa});
                        }
                    }
                    if (rs.getInt(4) == 3) {
                        if (rs.getInt(3) == 0) {
                            InformeGeneralesDAOImpl.this.jdbcTemplate.update(xSql_Vista);
                        }
                        if (rs.getInt(3) == 1) {
                            InformeGeneralesDAOImpl.this.jdbcTemplate.update(xSql_Vista, new Object[]{InformeGeneralesDAOImpl.this.fechaI});
                        }
                        if (rs.getInt(3) == 4) {
                            InformeGeneralesDAOImpl.this.jdbcTemplate.update(xSql_Vista, new Object[]{InformeGeneralesDAOImpl.this.fechaI, InformeGeneralesDAOImpl.this.fechaI, InformeGeneralesDAOImpl.this.fechaF, xIdEmpresa});
                        }
                    }
                }
                System.out.println("Consulta SqlVista Impresa --> " + xSql_Vista);
                System.err.println("Parametroz" + InformeGeneralesDAOImpl.this.fechaI + "-" + InformeGeneralesDAOImpl.this.fechaF + "-" + xIdEmpresa);
                return xDatos;
            }
        };
        this.jdbcTemplate.query(xSql, rowMapper);
    }

    @Override // com.genoma.plus.dao.sig.InformeGeneralesPyPDAO
    public List<GCGenericoDTO> listaempresa() {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.sig.InformeGeneralesDAOImpl.2
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                GCGenericoDTO g = new GCGenericoDTO();
                g.setId(rs.getLong("Id"));
                g.setNombre(rs.getString("Nbre"));
                return g;
            }
        };
        List<GCGenericoDTO> list = this.jdbcTemplate.query("SELECT \n                       `g_empresa`.`Id` \n                       , `g_empresa`.`Nbre` \n                       , `g_empresa`.`Estado` \n                   FROM \n                       `baseserver`.`g_empresa` \n                       INNER JOIN `baseserver`.`g_empresacont`  \n                           ON (`g_empresa`.`Id` = `g_empresacont`.`Id_empresa`) \n                       INNER JOIN `baseserver`.`f_empresacontxconvenio`  \n                           ON (`g_empresacont`.`Id_empresa` = `f_empresacontxconvenio`.`Id_EmpresaCont`) \n                   WHERE (`g_empresa`.`Estado` =1 AND f_empresacontxconvenio.`Aplica4505`=1)GROUP BY g_empresa.`Id` ORDER BY `g_empresa`.`Nbre`  ASC ", mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.sig.InformeGeneralesPyPDAO
    public List<Object[]> ListadoInformaTipo1() {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.sig.InformeGeneralesDAOImpl.3
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = {Long.valueOf(rs.getLong(1)), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14)};
                return fila;
            }
        };
        System.err.println("SELECT Id, V1, V2 , V3 , V4 , V5, V6 , V7 ,V8,V9,V10, V11 , V12, V13  FROM informe ");
        List<Object[]> list = this.jdbcTemplate.query("SELECT Id, V1, V2 , V3 , V4 , V5, V6 , V7 ,V8,V9,V10, V11 , V12, V13  FROM informe ", mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.sig.InformeGeneralesPyPDAO
    public List<Object[]> ListadoInformaTipo2() {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.sig.InformeGeneralesDAOImpl.4
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15), rs.getString(16), rs.getString(17), rs.getString(18), rs.getString(19), rs.getString(20), rs.getString(21), rs.getString(22), rs.getString(23), rs.getString(24), rs.getString(25), rs.getString(26), rs.getString(27), rs.getString(28), rs.getString(29), rs.getString(30), rs.getString(31), rs.getString(32), rs.getString(33), rs.getString(34), rs.getString(35), rs.getString(36), rs.getString(37)};
                return fila;
            }
        };
        System.err.println("ConsultaSELECT `Eps`, `Regimen`, `FechaIngreso`, `GrupoPoblacioal`,\n  `IdPersona`,`Nombres`,  `Apellidos`,  `TipoDoc`,  `Ndocumento`,\n  `FechaNac`, `Sexo`,   `Etnia`, `Dirreccion`,  `Telefono`, \n  `CodigoM`,   `SemanaDeGestacionI`,   `SemanaDeGestacionA`,\n  `RiesgoOsbtetrico`,   `DxGestante`,   `FechaVIHTrimeste1`,\n  `ValorVih1`,  `FechaVIHTrimeste2`, `ValorVih2`,\n  `FechaVIHTrimeste3`, `ValorVih3`, `FechaSifilisTrimeste1`,\n  `ValorSifilis1`,  `FechaSifilisTrimeste2`,  `ValorSifilis2`,\n  `FechaSifilisTrimeste3`,  `ValorSifilis3`, `FUM`, `FPP`,\n  `FechaPrimercontrol`,  `FechaUltimoControl`, `Peso`,  `Talla`\nFROM `baseserver`.`informe` ");
        List<Object[]> list = this.jdbcTemplate.query("SELECT `Eps`, `Regimen`, `FechaIngreso`, `GrupoPoblacioal`,\n  `IdPersona`,`Nombres`,  `Apellidos`,  `TipoDoc`,  `Ndocumento`,\n  `FechaNac`, `Sexo`,   `Etnia`, `Dirreccion`,  `Telefono`, \n  `CodigoM`,   `SemanaDeGestacionI`,   `SemanaDeGestacionA`,\n  `RiesgoOsbtetrico`,   `DxGestante`,   `FechaVIHTrimeste1`,\n  `ValorVih1`,  `FechaVIHTrimeste2`, `ValorVih2`,\n  `FechaVIHTrimeste3`, `ValorVih3`, `FechaSifilisTrimeste1`,\n  `ValorSifilis1`,  `FechaSifilisTrimeste2`,  `ValorSifilis2`,\n  `FechaSifilisTrimeste3`,  `ValorSifilis3`, `FUM`, `FPP`,\n  `FechaPrimercontrol`,  `FechaUltimoControl`, `Peso`,  `Talla`\nFROM `baseserver`.`informe` ", mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.sig.InformeGeneralesPyPDAO
    public void mLimpiarTabla(String idTipoInforme) {
        String xSql = "DELETE\nFROM `baseserver`." + idTipoInforme + "";
        this.jdbcTemplate.update(xSql);
        System.err.println("akita" + xSql);
    }

    @Override // com.genoma.plus.dao.sig.InformeGeneralesPyPDAO
    public List<Object[]> ListadoInformaTipo3() {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.sig.InformeGeneralesDAOImpl.5
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15), rs.getString(16), rs.getString(17), rs.getString(18), rs.getString(19), rs.getString(20), rs.getString(21), rs.getString(22), rs.getString(23), rs.getString(24), rs.getString(25), rs.getString(26), rs.getString(27), rs.getString(28), rs.getString(29), rs.getString(30), rs.getString(31), rs.getString(32), rs.getString(33), rs.getString(34), rs.getString(35), rs.getString(36), rs.getString(37), rs.getString(38), rs.getString(39), rs.getString(40), rs.getString(41), rs.getString(42), rs.getString(43), rs.getString(44), rs.getString(45), rs.getString(46), rs.getString(47), rs.getString(48), rs.getString(49), rs.getString(50), rs.getString(51), rs.getString(52), rs.getString(53), rs.getString(54), rs.getString(55), rs.getString(56), rs.getString(57), rs.getString(58), rs.getString(59), rs.getString(60), rs.getString(61), rs.getString(62), rs.getString(63), rs.getString(64), rs.getString(65), rs.getString(66), rs.getString(67), rs.getString(68), rs.getString(69)};
                return fila;
            }
        };
        System.err.println("ConsultaSELECT\n  `Id`,\n  `IdPersona`,\n  `Nombres`,\n  `Apellidos`,\n  `TipoDoc`,\n  `Ndocumento`,\n  `EstadoCiVil`,\n  `Ocupacion`,\n  `FechaNac`,\n  `GestacionActual`,\n  `FechaIngreso`,\n  `FechaPrimeraCita`,\n  `Regimen`,\n  `Eps`,\n  `Municipio`,\n  `Zona`,\n  `Dirreccion`,\n  `Telefono`,\n  `Etnia`,\n  `NivelAcademico`,\n  `EmbarazoAceptado`,\n  `ApoyoFamiliar`,\n  `VictimaMaltrato`,\n  `GrupoPoblacioal`,\n  `AntecedenteHipertensionEm`,\n  `NacidoVivo`,\n  `Npartos`,\n  `Nabortos`,\n  `Ncesareas`,\n  `APerinatal`,\n  `AembarazoEtopico`,\n  `AenfermedaAutoI`,\n  `Adiabetes`,\n  `Ahipertensos`,\n  `FechaUltimoEmbarazo`,\n  `FUM`,\n  `SemanaDeGestacionI`,\n  `TrimestreIngreso`,\n  `SemanaDeGestacionA`,\n  `FechaPT1`,\n  `Peso1`,\n  `Talla1`,\n  `IMC1`,\n  `ClasificacionN1`,\n  `FechaPT2`,\n  `Peso2`,\n  `Talla2`,\n  `IMC2`,\n  `ClasificacionN2`,\n  `FechaPT3`,\n  `Peso3`,\n  `Talla3`,\n  `IMC3`,\n  `ClasificacionN3`,\n  `TASistolica20A26`,\n  `TADistolica20A26`,\n  `TASistolica30A34`,\n  `TADistolica30A34`,\n  `TASistolica35A37`,\n  `TADistolica35A37`,\n  `FechaProximaCita`,\n  `FechaUltimoControl`,\n  `EdadGestacionalUlC`,\n  `CantidadControles`,\n  `FechaRemisionPsicologia`,\n  `FechaCitaPsicologia`,\n  `FechaRemisionNutricion`,\n  `FechaCitaNutricion`,\n  `FechaRemisionGinecologia`,\n  `FechaCitaGinecologia`\nFROM\n  `baseserver`.`p_res_informespyp_res` ORDER BY FechaIngreso");
        List<Object[]> list = this.jdbcTemplate.query("SELECT\n  `Id`,\n  `IdPersona`,\n  `Nombres`,\n  `Apellidos`,\n  `TipoDoc`,\n  `Ndocumento`,\n  `EstadoCiVil`,\n  `Ocupacion`,\n  `FechaNac`,\n  `GestacionActual`,\n  `FechaIngreso`,\n  `FechaPrimeraCita`,\n  `Regimen`,\n  `Eps`,\n  `Municipio`,\n  `Zona`,\n  `Dirreccion`,\n  `Telefono`,\n  `Etnia`,\n  `NivelAcademico`,\n  `EmbarazoAceptado`,\n  `ApoyoFamiliar`,\n  `VictimaMaltrato`,\n  `GrupoPoblacioal`,\n  `AntecedenteHipertensionEm`,\n  `NacidoVivo`,\n  `Npartos`,\n  `Nabortos`,\n  `Ncesareas`,\n  `APerinatal`,\n  `AembarazoEtopico`,\n  `AenfermedaAutoI`,\n  `Adiabetes`,\n  `Ahipertensos`,\n  `FechaUltimoEmbarazo`,\n  `FUM`,\n  `SemanaDeGestacionI`,\n  `TrimestreIngreso`,\n  `SemanaDeGestacionA`,\n  `FechaPT1`,\n  `Peso1`,\n  `Talla1`,\n  `IMC1`,\n  `ClasificacionN1`,\n  `FechaPT2`,\n  `Peso2`,\n  `Talla2`,\n  `IMC2`,\n  `ClasificacionN2`,\n  `FechaPT3`,\n  `Peso3`,\n  `Talla3`,\n  `IMC3`,\n  `ClasificacionN3`,\n  `TASistolica20A26`,\n  `TADistolica20A26`,\n  `TASistolica30A34`,\n  `TADistolica30A34`,\n  `TASistolica35A37`,\n  `TADistolica35A37`,\n  `FechaProximaCita`,\n  `FechaUltimoControl`,\n  `EdadGestacionalUlC`,\n  `CantidadControles`,\n  `FechaRemisionPsicologia`,\n  `FechaCitaPsicologia`,\n  `FechaRemisionNutricion`,\n  `FechaCitaNutricion`,\n  `FechaRemisionGinecologia`,\n  `FechaCitaGinecologia`\nFROM\n  `baseserver`.`p_res_informespyp_res` ORDER BY FechaIngreso", mapper);
        return list;
    }
}
