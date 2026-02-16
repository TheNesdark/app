package com.genoma.plus.dao.impl.sig;

import Utilidades.Metodos;
import com.genoma.plus.dao.sig.Resolucion4725_DAO;
import com.genoma.plus.dto.sig.GenericoComboDTO;
import com.genoma.plus.dto.sig.Resolucion4725_DTO;
import java.awt.Color;
import java.awt.Component;
import java.io.BufferedWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/sig/Resolucion4725_DAOImpl.class */
public class Resolucion4725_DAOImpl implements Resolucion4725_DAO {
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

    @Override // com.genoma.plus.dao.sig.Resolucion4725_DAO
    public List<GenericoComboDTO> comboEmpresa() {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.sig.Resolucion4725_DAOImpl.1
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                GenericoComboDTO g = new GenericoComboDTO();
                g.setId(rs.getLong("Id"));
                g.setNombre(rs.getString("RazonSocialCompleta"));
                return g;
            }
        };
        List<GenericoComboDTO> list = this.jdbcTemplate.query("SELECT\n                 `cc_terceros`.`Id`\n                 ,`cc_terceros`.`No_identificacion`\n                 , `cc_terceros`.`RazonSocialCompleta`\n                 , `g_empresacont`.`Codigo`\n                 FROM\n                 `p_res_2463_r`\n                 \n                 INNER JOIN `ingreso` \n                     ON (`p_res_2463_r`.`IdIngreso` = `ingreso`.`Id`)\n                 INNER JOIN `g_usuario` \n                     ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)\n                 INNER JOIN `cc_terceros` \n                     ON (`g_usuario`.`Id_EmpresaCont` = `cc_terceros`.`Id`)\n                 INNER JOIN `g_empresacont` \n                     ON (`g_usuario`.`Id_EmpresaCont` = `g_empresacont`.`Id_empresa`)\n                 GROUP BY `cc_terceros`.`Id`\n                 ORDER BY `cc_terceros`.`RazonSocial` ASC;;", mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.sig.Resolucion4725_DAO
    public void eliminarTablaReso4725() {
        this.jdbcTemplate.update("DELETE FROM `baseserver`.`p_res_4725_r`");
    }

    @Override // com.genoma.plus.dao.sig.Resolucion4725_DAO
    public void mEjecutarSql(String fechaInicial, String fechaFinal, JRadioButton xjrButton1) {
        this.fechaI = fechaInicial;
        this.fechaF = fechaFinal;
        this.xjrButton = xjrButton1;
        String xSql = "SELECT `Descripcion` , `Sql`, `Parametros` FROM `p_res_4725_sql` WHERE (`Nvariable` = '" + this.xjrButton.getText() + "' AND Estado=1)";
        RowMapper rowMapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.sig.Resolucion4725_DAOImpl.2
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                Resolucion4725_DTO xRes4725 = new Resolucion4725_DTO();
                xRes4725.setXDescripcion(rs.getString(1));
                xRes4725.setXNSql(rs.getString(2));
                xRes4725.setXNParametros(rs.getInt(3));
                String xSql_Vista = rs.getString("Sql");
                if (rs.getInt(3) == 0) {
                    if (rs.getInt(3) == 0) {
                        Resolucion4725_DAOImpl.this.jdbcTemplate.update(xSql_Vista);
                    } else if (rs.getInt(3) == 1) {
                        Resolucion4725_DAOImpl.this.jdbcTemplate.update(xSql_Vista, new Object[]{Resolucion4725_DAOImpl.this.fechaI});
                    } else if (rs.getInt(3) == 2) {
                        Resolucion4725_DAOImpl.this.jdbcTemplate.update(xSql_Vista, new Object[]{Resolucion4725_DAOImpl.this.fechaI, Resolucion4725_DAOImpl.this.fechaF});
                    } else if (rs.getInt(3) == 3) {
                        Resolucion4725_DAOImpl.this.jdbcTemplate.update(xSql_Vista, new Object[]{Resolucion4725_DAOImpl.this.fechaI, Resolucion4725_DAOImpl.this.fechaF, Resolucion4725_DAOImpl.this.fechaI});
                    } else if (rs.getInt(3) == 4) {
                        Resolucion4725_DAOImpl.this.jdbcTemplate.update(xSql_Vista, new Object[]{Resolucion4725_DAOImpl.this.fechaI, Resolucion4725_DAOImpl.this.fechaF, Resolucion4725_DAOImpl.this.fechaI, Resolucion4725_DAOImpl.this.fechaF});
                    }
                    Resolucion4725_DAOImpl.this.xjrButton.setForeground(Color.red);
                } else if (rs.getInt(3) == 1) {
                    if (rs.getInt(3) == 0) {
                        Resolucion4725_DAOImpl.this.jdbcTemplate.update(xSql_Vista);
                    } else if (rs.getInt(3) == 1) {
                        Resolucion4725_DAOImpl.this.jdbcTemplate.update(xSql_Vista, new Object[]{Resolucion4725_DAOImpl.this.fechaI});
                    } else if (rs.getInt(3) == 2) {
                        Resolucion4725_DAOImpl.this.jdbcTemplate.update(xSql_Vista, new Object[]{Resolucion4725_DAOImpl.this.fechaI, Resolucion4725_DAOImpl.this.fechaF});
                    } else if (rs.getInt(3) == 3) {
                        Resolucion4725_DAOImpl.this.jdbcTemplate.update(xSql_Vista, new Object[]{Resolucion4725_DAOImpl.this.fechaI, Resolucion4725_DAOImpl.this.fechaF, Resolucion4725_DAOImpl.this.fechaI});
                    } else if (rs.getInt(3) == 4) {
                        Resolucion4725_DAOImpl.this.jdbcTemplate.update(xSql_Vista, new Object[]{Resolucion4725_DAOImpl.this.fechaI, Resolucion4725_DAOImpl.this.fechaF, Resolucion4725_DAOImpl.this.fechaI, Resolucion4725_DAOImpl.this.fechaF});
                    }
                    Resolucion4725_DAOImpl.this.xjrButton.setForeground(Color.red);
                } else if (rs.getInt(3) == 2) {
                    if (rs.getInt(3) == 0) {
                        Resolucion4725_DAOImpl.this.jdbcTemplate.update(xSql_Vista);
                    } else if (rs.getInt(3) == 1) {
                        Resolucion4725_DAOImpl.this.jdbcTemplate.update(xSql_Vista, new Object[]{Resolucion4725_DAOImpl.this.fechaI});
                    } else if (rs.getInt(3) == 2) {
                        Resolucion4725_DAOImpl.this.jdbcTemplate.update(xSql_Vista, new Object[]{Resolucion4725_DAOImpl.this.fechaI, Resolucion4725_DAOImpl.this.fechaF});
                    } else if (rs.getInt(3) == 3) {
                        Resolucion4725_DAOImpl.this.jdbcTemplate.update(xSql_Vista, new Object[]{Resolucion4725_DAOImpl.this.fechaI, Resolucion4725_DAOImpl.this.fechaF, Resolucion4725_DAOImpl.this.fechaI});
                    } else if (rs.getInt(3) == 4) {
                        Resolucion4725_DAOImpl.this.jdbcTemplate.update(xSql_Vista, new Object[]{Resolucion4725_DAOImpl.this.fechaI, Resolucion4725_DAOImpl.this.fechaF, Resolucion4725_DAOImpl.this.fechaI, Resolucion4725_DAOImpl.this.fechaF});
                    }
                    Resolucion4725_DAOImpl.this.xjrButton.setForeground(Color.red);
                } else if (rs.getInt(3) == 3) {
                    if (rs.getInt(3) == 0) {
                        Resolucion4725_DAOImpl.this.jdbcTemplate.update(xSql_Vista);
                    } else if (rs.getInt(3) == 1) {
                        Resolucion4725_DAOImpl.this.jdbcTemplate.update(xSql_Vista, new Object[]{Resolucion4725_DAOImpl.this.fechaI});
                    } else if (rs.getInt(3) == 2) {
                        Resolucion4725_DAOImpl.this.jdbcTemplate.update(xSql_Vista, new Object[]{Resolucion4725_DAOImpl.this.fechaI, Resolucion4725_DAOImpl.this.fechaF});
                    } else if (rs.getInt(3) == 3) {
                        Resolucion4725_DAOImpl.this.jdbcTemplate.update(xSql_Vista, new Object[]{Resolucion4725_DAOImpl.this.fechaI, Resolucion4725_DAOImpl.this.fechaF, Resolucion4725_DAOImpl.this.fechaI});
                    } else if (rs.getInt(3) == 4) {
                        Resolucion4725_DAOImpl.this.jdbcTemplate.update(xSql_Vista, new Object[]{Resolucion4725_DAOImpl.this.fechaI, Resolucion4725_DAOImpl.this.fechaF, Resolucion4725_DAOImpl.this.fechaI, Resolucion4725_DAOImpl.this.fechaF});
                    }
                    Resolucion4725_DAOImpl.this.xjrButton.setForeground(Color.red);
                } else if (rs.getInt(3) == 4) {
                    if (rs.getInt(3) == 0) {
                        Resolucion4725_DAOImpl.this.jdbcTemplate.update(xSql_Vista);
                    } else if (rs.getInt(3) == 1) {
                        Resolucion4725_DAOImpl.this.jdbcTemplate.update(xSql_Vista, new Object[]{Resolucion4725_DAOImpl.this.fechaI});
                    } else if (rs.getInt(3) == 2) {
                        Resolucion4725_DAOImpl.this.jdbcTemplate.update(xSql_Vista, new Object[]{Resolucion4725_DAOImpl.this.fechaI, Resolucion4725_DAOImpl.this.fechaF});
                    } else if (rs.getInt(3) == 3) {
                        Resolucion4725_DAOImpl.this.jdbcTemplate.update(xSql_Vista, new Object[]{Resolucion4725_DAOImpl.this.fechaI, Resolucion4725_DAOImpl.this.fechaF, Resolucion4725_DAOImpl.this.fechaI});
                    } else if (rs.getInt(3) == 4) {
                        Resolucion4725_DAOImpl.this.jdbcTemplate.update(xSql_Vista, new Object[]{Resolucion4725_DAOImpl.this.fechaI, Resolucion4725_DAOImpl.this.fechaF, Resolucion4725_DAOImpl.this.fechaI, Resolucion4725_DAOImpl.this.fechaF});
                    }
                    Resolucion4725_DAOImpl.this.xjrButton.setForeground(Color.red);
                }
                System.out.println("Consulta SqlVista Impresa --> " + xSql_Vista);
                return xRes4725;
            }
        };
        this.jdbcTemplate.query(xSql, rowMapper);
        System.out.println("SQL Principal-->" + xSql + " -- RadioButton getText --" + this.xjrButton.getText());
    }

    @Override // com.genoma.plus.dao.sig.Resolucion4725_DAO
    public List<Object[]> mListadoCompleto(int idEmpresaCont) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.sig.Resolucion4725_DAOImpl.3
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = new Object[120];
                fila[0] = rs.getString(1);
                fila[1] = rs.getString(2);
                fila[2] = rs.getString(3);
                fila[3] = rs.getString(4);
                fila[4] = rs.getString(5);
                fila[5] = rs.getString(6);
                fila[6] = rs.getString(7);
                fila[7] = rs.getString(8);
                fila[8] = rs.getString(9);
                fila[9] = rs.getString(10);
                fila[10] = rs.getString(11);
                fila[11] = rs.getString(12);
                fila[12] = rs.getString(13);
                fila[13] = rs.getString(14);
                fila[14] = rs.getString(15);
                fila[15] = rs.getString(16);
                fila[16] = rs.getString(17);
                fila[17] = rs.getString(18);
                fila[18] = rs.getString(19);
                fila[19] = rs.getString(20);
                fila[20] = rs.getString(21);
                return fila;
            }
        };
        String xSql = "SELECT\n    `p_res_4725_r`.`Id_programa` AS `Programa`\n    , `g_empresa`.`Nbre`\n    , `g_empresacont`.`Id_TipoRegimen` AS `Regimen`\n    , `g_usuario`.`IdPoblacionEspecial` AS `Pespecial`\n    , `g_persona`.`Nombre1`\n    , `g_persona`.`Nombre2`\n    , `g_persona`.`Apellido1`\n    , `g_persona`.`Apellido2`\n    , `g_persona`.`Id_TipoIdentificacion`\n    , `g_persona`.`NoDocumento`\n    , `g_persona`.`FechaNac`\n    , `g_persona`.`Id_Sexo`\n    , `g_persona`.`Id_Etnia`\n    , `g_persona`.`Direccion`\n    , `g_persona`.`Telefono`\n    , `g_persona`.`Id_MunicipioNac`\n    , `p_res_4725_r`.`Ppgestante`\n    , `p_res_4725_r`.`Ttuberculosis`\n    , `p_res_4725_r`.`Fvih`\n    , `p_res_4725_r`.`ClpruebaVih`\n    , IFNULL(`p_res_4725_r`.`Vdrl`,'SIN DATO')AS VDRL \n    \nFROM\n    `p_res_4725_r`\n    INNER JOIN `g_persona` \n        ON (`p_res_4725_r`.`Id_persona` = `g_persona`.`Id`)\n    INNER JOIN `g_usuario` \n        ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)\n    INNER JOIN `g_empresacont` \n        ON (`g_usuario`.`Id_EmpresaCont` = `g_empresacont`.`Id_empresa`)\n    INNER JOIN `g_empresacont` AS `g_empresacont_1`\n        ON (`g_usuario`.`Id_EmpresaCont` = `g_empresacont_1`.`Id_empresa`)\n    INNER JOIN `f_tiporegimen` \n        ON (`g_empresacont`.`Id_TipoRegimen` = `f_tiporegimen`.`Id`)\n    INNER JOIN `g_empresa` \n        ON (`g_empresa`.`Id` = `g_empresacont_1`.`Id_empresa`)\n        WHERE `g_empresa`.`Id` = '" + idEmpresaCont + "'";
        System.out.println("xsql-->" + xSql);
        List<Object[]> list = this.jdbcTemplate.query(xSql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.sig.Resolucion4725_DAO
    public List<Object[]> mListadoCompleto1() {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.sig.Resolucion4725_DAOImpl.4
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = new Object[120];
                fila[0] = rs.getString(1);
                fila[1] = rs.getString(2);
                fila[2] = rs.getString(3);
                fila[3] = rs.getString(4);
                fila[4] = rs.getString(5);
                fila[5] = rs.getString(6);
                fila[6] = rs.getString(7);
                fila[7] = rs.getString(8);
                fila[8] = rs.getString(9);
                fila[9] = rs.getString(10);
                fila[10] = rs.getString(11);
                fila[11] = rs.getString(12);
                fila[12] = rs.getString(13);
                fila[13] = rs.getString(14);
                fila[14] = rs.getString(15);
                fila[15] = rs.getString(16);
                fila[16] = rs.getString(17);
                fila[17] = rs.getString(18);
                fila[18] = rs.getString(19);
                fila[19] = rs.getString(20);
                fila[20] = rs.getString(21);
                return fila;
            }
        };
        System.out.println("xsql-->SELECT\n    `p_res_4725_r`.`Id_programa` AS `Programa`\n    , `g_empresa`.`Nbre`\n    , `g_empresacont`.`Id_TipoRegimen` AS `Regimen`\n    , `g_usuario`.`IdPoblacionEspecial` AS `Pespecial`\n    , `g_persona`.`Nombre1`\n    , `g_persona`.`Nombre2`\n    , `g_persona`.`Apellido1`\n    , `g_persona`.`Apellido2`\n    , `g_persona`.`Id_TipoIdentificacion`\n    , `g_persona`.`NoDocumento`\n    , `g_persona`.`FechaNac`\n    , `g_persona`.`Id_Sexo`\n    , `g_persona`.`Id_Etnia`\n    , `g_persona`.`Direccion`\n    , `g_persona`.`Telefono`\n    , `g_persona`.`Id_MunicipioNac`\n    , `p_res_4725_r`.`Ppgestante`\n    , `p_res_4725_r`.`Ttuberculosis`\n    , `p_res_4725_r`.`Fvih`\n    , `p_res_4725_r`.`ClpruebaVih`\n    , IFNULL(`p_res_4725_r`.`Vdrl`,'SIN DATO')AS VDRL \n    \nFROM\n    `p_res_4725_r`\n    INNER JOIN `g_persona` \n        ON (`p_res_4725_r`.`Id_persona` = `g_persona`.`Id`)\n    INNER JOIN `g_usuario` \n        ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)\n    INNER JOIN `g_empresacont` \n        ON (`g_usuario`.`Id_EmpresaCont` = `g_empresacont`.`Id_empresa`)\n    INNER JOIN `g_empresacont` AS `g_empresacont_1`\n        ON (`g_usuario`.`Id_EmpresaCont` = `g_empresacont_1`.`Id_empresa`)\n    INNER JOIN `f_tiporegimen` \n        ON (`g_empresacont`.`Id_TipoRegimen` = `f_tiporegimen`.`Id`)\n    INNER JOIN `g_empresa` \n        ON (`g_empresa`.`Id` = `g_empresacont_1`.`Id_empresa`)");
        List<Object[]> list = this.jdbcTemplate.query("SELECT\n    `p_res_4725_r`.`Id_programa` AS `Programa`\n    , `g_empresa`.`Nbre`\n    , `g_empresacont`.`Id_TipoRegimen` AS `Regimen`\n    , `g_usuario`.`IdPoblacionEspecial` AS `Pespecial`\n    , `g_persona`.`Nombre1`\n    , `g_persona`.`Nombre2`\n    , `g_persona`.`Apellido1`\n    , `g_persona`.`Apellido2`\n    , `g_persona`.`Id_TipoIdentificacion`\n    , `g_persona`.`NoDocumento`\n    , `g_persona`.`FechaNac`\n    , `g_persona`.`Id_Sexo`\n    , `g_persona`.`Id_Etnia`\n    , `g_persona`.`Direccion`\n    , `g_persona`.`Telefono`\n    , `g_persona`.`Id_MunicipioNac`\n    , `p_res_4725_r`.`Ppgestante`\n    , `p_res_4725_r`.`Ttuberculosis`\n    , `p_res_4725_r`.`Fvih`\n    , `p_res_4725_r`.`ClpruebaVih`\n    , IFNULL(`p_res_4725_r`.`Vdrl`,'SIN DATO')AS VDRL \n    \nFROM\n    `p_res_4725_r`\n    INNER JOIN `g_persona` \n        ON (`p_res_4725_r`.`Id_persona` = `g_persona`.`Id`)\n    INNER JOIN `g_usuario` \n        ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)\n    INNER JOIN `g_empresacont` \n        ON (`g_usuario`.`Id_EmpresaCont` = `g_empresacont`.`Id_empresa`)\n    INNER JOIN `g_empresacont` AS `g_empresacont_1`\n        ON (`g_usuario`.`Id_EmpresaCont` = `g_empresacont_1`.`Id_empresa`)\n    INNER JOIN `f_tiporegimen` \n        ON (`g_empresacont`.`Id_TipoRegimen` = `f_tiporegimen`.`Id`)\n    INNER JOIN `g_empresa` \n        ON (`g_empresa`.`Id` = `g_empresacont_1`.`Id_empresa`)", mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.sig.Resolucion4725_DAO
    public void mActualizarLotes(JPanel xjPanel, String fechaInicial, String fechaFinal) {
        for (int x = 0; x < xjPanel.getComponentCount(); x++) {
            if (xjPanel.getComponent(x).getClass().toString().equals("class javax.swing.JRadioButton")) {
                JRadioButton xjrButton = (JRadioButton) xjPanel.getComponent(x);
                mEjecutarSql(fechaInicial, fechaFinal, xjrButton);
            }
        }
        JOptionPane.showMessageDialog((Component) null, "Finalizó con éxito la la actualización del informe", "Resolución 2463", 1, new ImageIcon("src/Imagenes/Information.png"));
    }
}
