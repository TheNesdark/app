package com.genoma.plus.dao.impl.sig;

import Utilidades.Metodos;
import com.genoma.plus.dao.sig.Resolucion1604_DAO;
import com.genoma.plus.dto.sig.GenericoComboDTO;
import java.io.BufferedWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/sig/Resolucion1604_DAOImpl.class */
public class Resolucion1604_DAOImpl implements Resolucion1604_DAO {
    private JdbcTemplate jdbcTemplate;
    private String fechaI;
    private String fechaF;
    private JRadioButton xjrButton;
    private JTable xTabla;
    DefaultTableModel xModelo;
    private Metodos xmt = new Metodos();
    BufferedWriter bw = null;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.sig.Resolucion1604_DAO
    public List<GenericoComboDTO> comboEmpresa(String xFechaI, String xFechaF) {
        String xsql = "SELECT f_empresacontxconvenio.`Id`, f_empresacontxconvenio.`Nbre` FROM `i_detallesalida` INNER JOIN `i_salidas` ON (`i_detallesalida`.`IdSalida` = `i_salidas`.`Id`) INNER JOIN `i_suministro` ON (`i_detallesalida`.`IdSuministro` = `i_suministro`.`Id`) INNER JOIN `g_persona` ON (`g_persona`.`Id` = `i_salidas`.`IdDestino`) INNER JOIN `f_empresacontxconvenio` ON (`f_empresacontxconvenio`.`Id` = `i_salidas`.`Eps`) INNER JOIN `i_concentracion` ON (`i_suministro`.`IdConcentracion` = `i_concentracion`.`Id`) INNER JOIN `i_presentacionfarmaceutica` ON (`i_suministro`.`IdPresentacionFarmaceutica` = `i_presentacionfarmaceutica`.`Id`) INNER JOIN `i_viaadministracion` ON (`i_suministro`.`IdViaAdministracion` = `i_viaadministracion`.`Id`) INNER JOIN `i_formafarmaceutica` ON (`i_presentacionfarmaceutica`.`IdFormaFarmaceutica` = `i_formafarmaceutica`.`Id`) LEFT JOIN `h_ordenes` ON (`h_ordenes`.`Id` = `i_salidas`.`OrdenH`) LEFT JOIN `h_itemordenessum` ON (`h_itemordenessum`.`Id_Suministro` = `i_detallesalida`.`IdSuministro`) AND (`h_itemordenessum`.`Id_HOrdenes` = `h_ordenes`.`Id`) LEFT JOIN `h_atencion` ON (`h_ordenes`.`Id_Atencion` = `h_atencion`.`Id`) INNER JOIN `i_tiposmovimientos` ON (`i_salidas`.`IdTipoMovimiento` = `i_tiposmovimientos`.`Id`) WHERE (`i_salidas`.`FechaSalida` >='" + xFechaI + "'AND `i_salidas`.`FechaSalida` <='" + xFechaF + "'AND `i_salidas`.`Estado` =0) GROUP BY f_empresacontxconvenio.`Id` ORDER BY f_empresacontxconvenio.`Nbre` ASC";
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.sig.Resolucion1604_DAOImpl.1
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                GenericoComboDTO g = new GenericoComboDTO();
                g.setId(rs.getLong("Id"));
                g.setNombre(rs.getString("Nbre"));
                return g;
            }
        };
        List<GenericoComboDTO> list = this.jdbcTemplate.query(xsql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.sig.Resolucion1604_DAO
    public List<Object[]> listadoDatosResolucion(String xFechaI, String xFechaF, Boolean xFiltro, String xIdEmpresa) {
        String xSql;
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.sig.Resolucion1604_DAOImpl.2
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15), rs.getString(16), rs.getString(17), rs.getString(18), rs.getString(19), rs.getString(20), rs.getString(21), rs.getString(22)};
                return fila;
            }
        };
        if (xFiltro.booleanValue()) {
            xSql = "SELECT\n    `g_persona`.`Nombre1`\n    , `g_persona`.`Nombre2`\n    , `g_persona`.`Apellido1`\n    , `g_persona`.`Apellido2`\n    , `g_persona`.`Id_TipoIdentificacion`\n    , `g_persona`.`NoDocumento`\n    , `g_persona`.`Id_Sexo`\n    , `i_suministro`.`Nbre` AS `NSUministro`\n    , `i_concentracion`.`Nbre` AS `NConcentracion`\n    , `i_formafarmaceutica`.`Nbre` AS `NFormaFarmaceutica`\n    , `i_viaadministracion`.`Nbre` AS `NViaAdministracion`\n    , IFNULL(`h_itemordenessum`.`PosologiaManual`, 'NO RELACIONADO') AS `Frecuencia`\n    , IFNULL(`h_itemordenessum`.`Duracion`, 'NO RELACIONADO') AS `Duracion`\n    , IFNULL(`h_itemordenessum`.`Cantidad`, 'NO RELACIONADO')  AS `CantOrdenada`\n    , `i_detallesalida`.`CantidadDespachada` AS `CantDespachada`\n    , IFNULL(`h_atencion`.`Codigo_Dxp`, 'NO RELACIONADO') AS `Codigo_Dxp`\n    , IFNULL(`h_atencion`.`Codigo_DxR1`, 'NO RELACIONADO') AS `Codigo_DxR1`\n    , IFNULL(`h_ordenes`.`FechaOrden`, 'NO RELACIONADO') AS `FechaOrden`\n    , `i_salidas`.`FechaSalida`\n    , `i_salidas`.`Id`\n    , `i_tiposmovimientos`.`Nbre` AS `TipoMOvimiento`, f_empresacontxconvenio.`Nbre` NConvenio\nFROM\n     `i_detallesalida`\n    INNER JOIN  `i_salidas` \n        ON (`i_detallesalida`.`IdSalida` = `i_salidas`.`Id`)\n    INNER JOIN  `i_suministro` \n        ON (`i_detallesalida`.`IdSuministro` = `i_suministro`.`Id`)\n    INNER JOIN  `g_persona` \n        ON (`g_persona`.`Id` = `i_salidas`.`IdDestino`)\n    INNER JOIN  `f_empresacontxconvenio` \n        ON (`f_empresacontxconvenio`.`Id` = `i_salidas`.`Eps`)\n    INNER JOIN  `i_concentracion` \n        ON (`i_suministro`.`IdConcentracion` = `i_concentracion`.`Id`)\n    INNER JOIN  `i_presentacionfarmaceutica` \n        ON (`i_suministro`.`IdPresentacionFarmaceutica` = `i_presentacionfarmaceutica`.`Id`)\n    INNER JOIN  `i_viaadministracion` \n        ON (`i_suministro`.`IdViaAdministracion` = `i_viaadministracion`.`Id`)\n    INNER JOIN  `i_formafarmaceutica` \n        ON (`i_presentacionfarmaceutica`.`IdFormaFarmaceutica` = `i_formafarmaceutica`.`Id`)\n    LEFT JOIN  `h_ordenes` \n        ON (`h_ordenes`.`Id` = `i_salidas`.`OrdenH`)\n    LEFT JOIN  `h_itemordenessum` \n        ON (`h_itemordenessum`.`Id_Suministro` = `i_detallesalida`.`IdSuministro`) AND (`h_itemordenessum`.`Id_HOrdenes` = `h_ordenes`.`Id`)\n    LEFT JOIN  `h_atencion` \n        ON (`h_ordenes`.`Id_Atencion` = `h_atencion`.`Id`)\n    INNER JOIN  `i_tiposmovimientos` \n        ON (`i_salidas`.`IdTipoMovimiento` = `i_tiposmovimientos`.`Id`)\nWHERE (`i_salidas`.`FechaSalida` >='" + xFechaI + "'\n    AND `i_salidas`.`FechaSalida` <='" + xFechaF + "'\n    AND `f_empresacontxconvenio`.`Id` ='" + xIdEmpresa + "'\n    AND `i_salidas`.`Estado` =0) Order by `i_salidas`.`Id` asc, `i_suministro`.`Nbre` asc";
        } else {
            xSql = "SELECT\n    `g_persona`.`Nombre1`\n    , `g_persona`.`Nombre2`\n    , `g_persona`.`Apellido1`\n    , `g_persona`.`Apellido2`\n    , `g_persona`.`Id_TipoIdentificacion`\n    , `g_persona`.`NoDocumento`\n    , `g_persona`.`Id_Sexo`\n    , `i_suministro`.`Nbre` AS `NSUministro`\n    , `i_concentracion`.`Nbre` AS `NConcentracion`\n    , `i_formafarmaceutica`.`Nbre` AS `NFormaFarmaceutica`\n    , `i_viaadministracion`.`Nbre` AS `NViaAdministracion`\n    , IFNULL(`h_itemordenessum`.`PosologiaManual`, 'NO RELACIONADO') AS `Frecuencia`\n    , IFNULL(`h_itemordenessum`.`Duracion`, 'NO RELACIONADO') AS `Duracion`\n    , IFNULL(`h_itemordenessum`.`Cantidad`, 'NO RELACIONADO')  AS `CantOrdenada`\n    , `i_detallesalida`.`CantidadDespachada` AS `CantDespachada`\n    , IFNULL(`h_atencion`.`Codigo_Dxp`, 'NO RELACIONADO') AS `Codigo_Dxp`\n    , IFNULL(`h_atencion`.`Codigo_DxR1`, 'NO RELACIONADO') AS `Codigo_DxR1`\n    , IFNULL(`h_ordenes`.`FechaOrden`, 'NO RELACIONADO') AS `FechaOrden`\n    , `i_salidas`.`FechaSalida`\n    , `i_salidas`.`Id`\n    , `i_tiposmovimientos`.`Nbre` AS `TipoMOvimiento`, f_empresacontxconvenio.`Nbre` NConvenio\nFROM\n     `i_detallesalida`\n    INNER JOIN  `i_salidas` \n        ON (`i_detallesalida`.`IdSalida` = `i_salidas`.`Id`)\n    INNER JOIN  `i_suministro` \n        ON (`i_detallesalida`.`IdSuministro` = `i_suministro`.`Id`)\n    INNER JOIN  `g_persona` \n        ON (`g_persona`.`Id` = `i_salidas`.`IdDestino`)\n    INNER JOIN  `f_empresacontxconvenio` \n        ON (`f_empresacontxconvenio`.`Id` = `i_salidas`.`Eps`)\n    INNER JOIN  `i_concentracion` \n        ON (`i_suministro`.`IdConcentracion` = `i_concentracion`.`Id`)\n    INNER JOIN  `i_presentacionfarmaceutica` \n        ON (`i_suministro`.`IdPresentacionFarmaceutica` = `i_presentacionfarmaceutica`.`Id`)\n    INNER JOIN  `i_viaadministracion` \n        ON (`i_suministro`.`IdViaAdministracion` = `i_viaadministracion`.`Id`)\n    INNER JOIN  `i_formafarmaceutica` \n        ON (`i_presentacionfarmaceutica`.`IdFormaFarmaceutica` = `i_formafarmaceutica`.`Id`)\n    LEFT JOIN  `h_ordenes` \n        ON (`h_ordenes`.`Id` = `i_salidas`.`OrdenH`)\n    LEFT JOIN  `h_itemordenessum` \n        ON (`h_itemordenessum`.`Id_Suministro` = `i_detallesalida`.`IdSuministro`) AND (`h_itemordenessum`.`Id_HOrdenes` = `h_ordenes`.`Id`)\n    LEFT JOIN  `h_atencion` \n        ON (`h_ordenes`.`Id_Atencion` = `h_atencion`.`Id`)\n    INNER JOIN  `i_tiposmovimientos` \n        ON (`i_salidas`.`IdTipoMovimiento` = `i_tiposmovimientos`.`Id`)\nWHERE (`i_salidas`.`FechaSalida` >='" + xFechaI + "'\n    AND `i_salidas`.`FechaSalida` <='" + xFechaF + "'\n    AND `i_salidas`.`Estado` =0) Order by `i_salidas`.`Id` asc, `i_suministro`.`Nbre` asc";
        }
        System.out.println("xsql-->" + xSql);
        List<Object[]> list = this.jdbcTemplate.query(xSql, mapper);
        return list;
    }
}
