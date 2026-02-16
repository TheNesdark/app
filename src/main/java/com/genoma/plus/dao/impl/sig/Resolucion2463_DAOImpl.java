package com.genoma.plus.dao.impl.sig;

import Utilidades.Metodos;
import com.genoma.plus.dao.sig.Resolucion2463_DAO;
import com.genoma.plus.dto.sig.GenericoComboDTO;
import com.genoma.plus.dto.sig.JDVariablesResolucion2463DTO;
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

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/sig/Resolucion2463_DAOImpl.class */
public class Resolucion2463_DAOImpl implements Resolucion2463_DAO {
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

    @Override // com.genoma.plus.dao.sig.Resolucion2463_DAO
    public List<GenericoComboDTO> comboEmpresa() {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.sig.Resolucion2463_DAOImpl.1
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                GenericoComboDTO g = new GenericoComboDTO();
                g.setId(rs.getLong("Id"));
                g.setNit(rs.getString("No_identificacion"));
                g.setNombre(rs.getString("RazonSocialCompleta"));
                g.setCodigo(rs.getString("Codigo"));
                return g;
            }
        };
        List<GenericoComboDTO> list = this.jdbcTemplate.query("SELECT\n                 `cc_terceros`.`Id`\n                 ,`cc_terceros`.`No_identificacion`\n                 , `cc_terceros`.`RazonSocialCompleta`\n                 , `g_empresacont`.`Codigo`\n                 FROM\n                 `p_res_2463_r`\n                 \n                 INNER JOIN `ingreso` \n                     ON (`p_res_2463_r`.`IdIngreso` = `ingreso`.`Id`)\n                 INNER JOIN `g_usuario` \n                     ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)\n                 INNER JOIN `cc_terceros` \n                     ON (`g_usuario`.`Id_EmpresaCont` = `cc_terceros`.`Id`)\n                 INNER JOIN `g_empresacont` \n                     ON (`g_usuario`.`Id_EmpresaCont` = `g_empresacont`.`Id_empresa`)\n                 GROUP BY `cc_terceros`.`Id`\n                 ORDER BY `cc_terceros`.`RazonSocial` ASC;;", mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.sig.Resolucion2463_DAO
    public void eliminarTablaReso2463() {
        this.jdbcTemplate.update("DELETE FROM  `p_res_2463_r`");
    }

    @Override // com.genoma.plus.dao.sig.Resolucion2463_DAO
    public void mActualizarLotes(JPanel xjPanel, JPanel xjPanel1, String fechaInicial, String fechaFinal) {
        for (int x = 0; x < xjPanel.getComponentCount(); x++) {
            if (xjPanel.getComponent(x).getClass().toString().equals("class javax.swing.JRadioButton")) {
                JRadioButton xjrButton = (JRadioButton) xjPanel.getComponent(x);
                if (xjrButton.getText().equals("V35")) {
                    eliminarTablaTemporal();
                    mEjecutarSql_V35(fechaInicial, fechaFinal);
                    mEjecutarSql(fechaInicial, fechaFinal, xjrButton);
                } else {
                    mEjecutarSql(fechaInicial, fechaFinal, xjrButton);
                }
            }
        }
        for (int x2 = 0; x2 < xjPanel1.getComponentCount(); x2++) {
            if (xjPanel1.getComponent(x2).getClass().toString().equals("class javax.swing.JRadioButton")) {
                JRadioButton xjrButton2 = (JRadioButton) xjPanel1.getComponent(x2);
                if (xjrButton2.getText().equals("V35")) {
                    eliminarTablaTemporal();
                    mEjecutarSql_V35(fechaInicial, fechaFinal);
                    mEjecutarSql(fechaInicial, fechaFinal, xjrButton2);
                } else {
                    mEjecutarSql(fechaInicial, fechaFinal, xjrButton2);
                }
            }
        }
        JOptionPane.showMessageDialog((Component) null, "Finalizó con éxito la la actualización del informe", "Resolución 2463", 1, new ImageIcon("src/Imagenes/Information.png"));
    }

    @Override // com.genoma.plus.dao.sig.Resolucion2463_DAO
    public void mEjecutarSql(String fechaInicial, String fechaFinal, JRadioButton xjRadioButton) {
        this.fechaI = fechaInicial;
        this.fechaF = fechaFinal;
        this.xjrButton = xjRadioButton;
        String xSql = "SELECT `Descripcion` , `NSql`, `NParametros`, Orden FROM `p_res_2463_sql` WHERE (`NVariable` = '" + this.xjrButton.getText() + "' AND Estado=1) ORDER BY NVariable asc,  Orden ASC";
        RowMapper rowMapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.sig.Resolucion2463_DAOImpl.2
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                JDVariablesResolucion2463DTO xRes2463 = new JDVariablesResolucion2463DTO();
                xRes2463.setXDescripcion(rs.getString(1));
                xRes2463.setXNSql(rs.getString(2));
                xRes2463.setXNParametros(rs.getInt(3));
                xRes2463.setXOrden(rs.getInt(4));
                System.out.println("SQL res 3 - -->" + rs.getInt(3));
                System.out.println("SQL res 4 - -->" + rs.getInt(4));
                String xSql_Vista = rs.getString("NSql");
                if (rs.getInt(4) == 0) {
                    if (rs.getInt(3) == 0) {
                        Resolucion2463_DAOImpl.this.jdbcTemplate.update(xSql_Vista);
                    } else if (rs.getInt(3) == 1) {
                        Resolucion2463_DAOImpl.this.jdbcTemplate.update(xSql_Vista, new Object[]{Resolucion2463_DAOImpl.this.fechaI});
                    } else if (rs.getInt(3) == 2) {
                        Resolucion2463_DAOImpl.this.jdbcTemplate.update(xSql_Vista, new Object[]{Resolucion2463_DAOImpl.this.fechaI, Resolucion2463_DAOImpl.this.fechaF});
                    } else if (rs.getInt(3) == 3) {
                        Resolucion2463_DAOImpl.this.jdbcTemplate.update(xSql_Vista, new Object[]{Resolucion2463_DAOImpl.this.fechaI, Resolucion2463_DAOImpl.this.fechaF, Resolucion2463_DAOImpl.this.fechaI});
                    } else if (rs.getInt(3) == 4) {
                        Resolucion2463_DAOImpl.this.jdbcTemplate.update(xSql_Vista, new Object[]{Resolucion2463_DAOImpl.this.fechaI, Resolucion2463_DAOImpl.this.fechaF, Resolucion2463_DAOImpl.this.fechaI, Resolucion2463_DAOImpl.this.fechaF});
                    }
                    Resolucion2463_DAOImpl.this.xjrButton.setForeground(Color.red);
                } else if (rs.getInt(4) == 1) {
                    if (rs.getInt(3) == 0) {
                        Resolucion2463_DAOImpl.this.jdbcTemplate.update(xSql_Vista);
                    } else if (rs.getInt(3) == 1) {
                        Resolucion2463_DAOImpl.this.jdbcTemplate.update(xSql_Vista, new Object[]{Resolucion2463_DAOImpl.this.fechaI});
                    } else if (rs.getInt(3) == 2) {
                        Resolucion2463_DAOImpl.this.jdbcTemplate.update(xSql_Vista, new Object[]{Resolucion2463_DAOImpl.this.fechaI, Resolucion2463_DAOImpl.this.fechaF});
                    } else if (rs.getInt(3) == 3) {
                        Resolucion2463_DAOImpl.this.jdbcTemplate.update(xSql_Vista, new Object[]{Resolucion2463_DAOImpl.this.fechaI, Resolucion2463_DAOImpl.this.fechaF, Resolucion2463_DAOImpl.this.fechaI});
                    } else if (rs.getInt(3) == 4) {
                        Resolucion2463_DAOImpl.this.jdbcTemplate.update(xSql_Vista, new Object[]{Resolucion2463_DAOImpl.this.fechaI, Resolucion2463_DAOImpl.this.fechaF, Resolucion2463_DAOImpl.this.fechaI, Resolucion2463_DAOImpl.this.fechaF});
                    }
                    Resolucion2463_DAOImpl.this.xjrButton.setForeground(Color.red);
                } else if (rs.getInt(4) == 2) {
                    if (rs.getInt(3) == 0) {
                        Resolucion2463_DAOImpl.this.jdbcTemplate.update(xSql_Vista);
                    } else if (rs.getInt(3) == 1) {
                        Resolucion2463_DAOImpl.this.jdbcTemplate.update(xSql_Vista, new Object[]{Resolucion2463_DAOImpl.this.fechaI});
                    } else if (rs.getInt(3) == 2) {
                        Resolucion2463_DAOImpl.this.jdbcTemplate.update(xSql_Vista, new Object[]{Resolucion2463_DAOImpl.this.fechaI, Resolucion2463_DAOImpl.this.fechaF});
                    } else if (rs.getInt(3) == 3) {
                        Resolucion2463_DAOImpl.this.jdbcTemplate.update(xSql_Vista, new Object[]{Resolucion2463_DAOImpl.this.fechaI, Resolucion2463_DAOImpl.this.fechaF, Resolucion2463_DAOImpl.this.fechaI});
                    } else if (rs.getInt(3) == 4) {
                        Resolucion2463_DAOImpl.this.jdbcTemplate.update(xSql_Vista, new Object[]{Resolucion2463_DAOImpl.this.fechaI, Resolucion2463_DAOImpl.this.fechaF, Resolucion2463_DAOImpl.this.fechaI, Resolucion2463_DAOImpl.this.fechaF});
                    }
                    Resolucion2463_DAOImpl.this.xjrButton.setForeground(Color.red);
                } else if (rs.getInt(4) == 3) {
                    if (rs.getInt(3) == 0) {
                        Resolucion2463_DAOImpl.this.jdbcTemplate.update(xSql_Vista);
                    } else if (rs.getInt(3) == 1) {
                        Resolucion2463_DAOImpl.this.jdbcTemplate.update(xSql_Vista, new Object[]{Resolucion2463_DAOImpl.this.fechaI});
                    } else if (rs.getInt(3) == 2) {
                        Resolucion2463_DAOImpl.this.jdbcTemplate.update(xSql_Vista, new Object[]{Resolucion2463_DAOImpl.this.fechaI, Resolucion2463_DAOImpl.this.fechaF});
                    } else if (rs.getInt(3) == 3) {
                        Resolucion2463_DAOImpl.this.jdbcTemplate.update(xSql_Vista, new Object[]{Resolucion2463_DAOImpl.this.fechaI, Resolucion2463_DAOImpl.this.fechaF, Resolucion2463_DAOImpl.this.fechaI});
                    } else if (rs.getInt(3) == 4) {
                        Resolucion2463_DAOImpl.this.jdbcTemplate.update(xSql_Vista, new Object[]{Resolucion2463_DAOImpl.this.fechaI, Resolucion2463_DAOImpl.this.fechaF, Resolucion2463_DAOImpl.this.fechaI, Resolucion2463_DAOImpl.this.fechaF});
                    }
                    Resolucion2463_DAOImpl.this.xjrButton.setForeground(Color.red);
                } else if (rs.getInt(4) == 4) {
                    if (rs.getInt(3) == 0) {
                        Resolucion2463_DAOImpl.this.jdbcTemplate.update(xSql_Vista);
                    } else if (rs.getInt(3) == 1) {
                        Resolucion2463_DAOImpl.this.jdbcTemplate.update(xSql_Vista, new Object[]{Resolucion2463_DAOImpl.this.fechaI});
                    } else if (rs.getInt(3) == 2) {
                        Resolucion2463_DAOImpl.this.jdbcTemplate.update(xSql_Vista, new Object[]{Resolucion2463_DAOImpl.this.fechaI, Resolucion2463_DAOImpl.this.fechaF});
                    } else if (rs.getInt(3) == 3) {
                        Resolucion2463_DAOImpl.this.jdbcTemplate.update(xSql_Vista, new Object[]{Resolucion2463_DAOImpl.this.fechaI, Resolucion2463_DAOImpl.this.fechaF, Resolucion2463_DAOImpl.this.fechaI});
                    } else if (rs.getInt(3) == 4) {
                        Resolucion2463_DAOImpl.this.jdbcTemplate.update(xSql_Vista, new Object[]{Resolucion2463_DAOImpl.this.fechaI, Resolucion2463_DAOImpl.this.fechaF, Resolucion2463_DAOImpl.this.fechaI, Resolucion2463_DAOImpl.this.fechaF});
                    }
                    Resolucion2463_DAOImpl.this.xjrButton.setForeground(Color.red);
                }
                System.out.println("Consulta SqlVista Impresa --> " + xSql_Vista);
                return xRes2463;
            }
        };
        this.jdbcTemplate.query(xSql, rowMapper);
        System.out.println("SQL Principal-->" + xSql + " -- RadioButton getText --" + this.xjrButton.getText());
    }

    @Override // com.genoma.plus.dao.sig.Resolucion2463_DAO
    public void mEjecutarSqlJDialog2463(String fechaInicial, String fechaFinal, JTable xjTable, DefaultTableModel xModelo, JRadioButton xjrButton) {
        this.fechaI = fechaInicial;
        this.fechaF = fechaFinal;
        this.xTabla = xjTable;
        this.xModelo = xModelo;
        this.xjrButton = xjrButton;
        if (this.xmt.mVerificarDatosTablaTrue(xjTable, 3)) {
            for (int x = 0; x < this.xTabla.getRowCount(); x++) {
                if (!this.xModelo.getValueAt(x, 1).toString().equals("") && Boolean.valueOf(((Boolean) this.xModelo.getValueAt(x, 3)).booleanValue()).booleanValue()) {
                    String xSql_Vista = this.xModelo.getValueAt(x, 1).toString();
                    if (Integer.valueOf(this.xModelo.getValueAt(x, 5).toString()).intValue() == 0) {
                        if (Integer.valueOf(this.xModelo.getValueAt(x, 4).toString()).intValue() == 0) {
                            this.jdbcTemplate.update(xSql_Vista);
                        } else if (Integer.valueOf(this.xModelo.getValueAt(x, 4).toString()).intValue() == 1) {
                            this.jdbcTemplate.update(xSql_Vista, new Object[]{this.fechaI});
                        } else if (Integer.valueOf(this.xModelo.getValueAt(x, 4).toString()).intValue() == 2) {
                            this.jdbcTemplate.update(xSql_Vista, new Object[]{this.fechaI, this.fechaF});
                        } else if (Integer.valueOf(this.xModelo.getValueAt(x, 4).toString()).intValue() == 3) {
                            this.jdbcTemplate.update(xSql_Vista, new Object[]{this.fechaI, this.fechaF, this.fechaI});
                        } else if (Integer.valueOf(this.xModelo.getValueAt(x, 4).toString()).intValue() == 4) {
                            this.jdbcTemplate.update(xSql_Vista, new Object[]{this.fechaI, this.fechaF, this.fechaI, this.fechaF});
                        }
                        System.out.println("Orden --  en 0  " + Integer.valueOf(this.xModelo.getValueAt(x, 5).toString()));
                    } else if (Integer.valueOf(this.xModelo.getValueAt(x, 5).toString()).intValue() == 1) {
                        if (Integer.valueOf(this.xModelo.getValueAt(x, 4).toString()).intValue() == 0) {
                            this.jdbcTemplate.update(xSql_Vista);
                        } else if (Integer.valueOf(this.xModelo.getValueAt(x, 4).toString()).intValue() == 1) {
                            this.jdbcTemplate.update(xSql_Vista, new Object[]{this.fechaI});
                        } else if (Integer.valueOf(this.xModelo.getValueAt(x, 4).toString()).intValue() == 2) {
                            this.jdbcTemplate.update(xSql_Vista, new Object[]{this.fechaI, this.fechaF});
                        } else if (Integer.valueOf(this.xModelo.getValueAt(x, 4).toString()).intValue() == 3) {
                            this.jdbcTemplate.update(xSql_Vista, new Object[]{this.fechaI, this.fechaF, this.fechaI});
                        } else if (Integer.valueOf(this.xModelo.getValueAt(x, 4).toString()).intValue() == 4) {
                            this.jdbcTemplate.update(xSql_Vista, new Object[]{this.fechaI, this.fechaF, this.fechaI, this.fechaF});
                        }
                        System.out.println("Orden --  en 1  " + Integer.valueOf(this.xModelo.getValueAt(x, 5).toString()));
                    } else if (Integer.valueOf(this.xModelo.getValueAt(x, 5).toString()).intValue() == 2) {
                        if (Integer.valueOf(this.xModelo.getValueAt(x, 4).toString()).intValue() == 0) {
                            this.jdbcTemplate.update(xSql_Vista);
                        } else if (Integer.valueOf(this.xModelo.getValueAt(x, 4).toString()).intValue() == 1) {
                            this.jdbcTemplate.update(xSql_Vista, new Object[]{this.fechaI});
                        } else if (Integer.valueOf(this.xModelo.getValueAt(x, 4).toString()).intValue() == 2) {
                            this.jdbcTemplate.update(xSql_Vista, new Object[]{this.fechaI, this.fechaF});
                        } else if (Integer.valueOf(this.xModelo.getValueAt(x, 4).toString()).intValue() == 3) {
                            this.jdbcTemplate.update(xSql_Vista, new Object[]{this.fechaI, this.fechaF, this.fechaI});
                        } else if (Integer.valueOf(this.xModelo.getValueAt(x, 4).toString()).intValue() == 4) {
                            this.jdbcTemplate.update(xSql_Vista, new Object[]{this.fechaI, this.fechaF, this.fechaI, this.fechaF});
                        }
                        System.out.println("Orden --  en 2 " + Integer.valueOf(this.xModelo.getValueAt(x, 5).toString()));
                    } else if (Integer.valueOf(this.xModelo.getValueAt(x, 5).toString()).intValue() == 3) {
                        if (Integer.valueOf(this.xModelo.getValueAt(x, 4).toString()).intValue() == 0) {
                            this.jdbcTemplate.update(xSql_Vista);
                        } else if (Integer.valueOf(this.xModelo.getValueAt(x, 4).toString()).intValue() == 1) {
                            this.jdbcTemplate.update(xSql_Vista, new Object[]{this.fechaI});
                        } else if (Integer.valueOf(this.xModelo.getValueAt(x, 4).toString()).intValue() == 2) {
                            this.jdbcTemplate.update(xSql_Vista, new Object[]{this.fechaI, this.fechaF});
                        } else if (Integer.valueOf(this.xModelo.getValueAt(x, 4).toString()).intValue() == 3) {
                            this.jdbcTemplate.update(xSql_Vista, new Object[]{this.fechaI, this.fechaF, this.fechaI});
                        } else if (Integer.valueOf(this.xModelo.getValueAt(x, 4).toString()).intValue() == 4) {
                            this.jdbcTemplate.update(xSql_Vista, new Object[]{this.fechaI, this.fechaF, this.fechaI, this.fechaF});
                        }
                        System.out.println("Orden --  en 3  " + Integer.valueOf(this.xModelo.getValueAt(x, 5).toString()));
                    } else if (Integer.valueOf(this.xModelo.getValueAt(x, 5).toString()).intValue() == 4) {
                        if (Integer.valueOf(this.xModelo.getValueAt(x, 4).toString()).intValue() == 0) {
                            this.jdbcTemplate.update(xSql_Vista);
                        } else if (Integer.valueOf(this.xModelo.getValueAt(x, 4).toString()).intValue() == 1) {
                            this.jdbcTemplate.update(xSql_Vista, new Object[]{this.fechaI});
                        } else if (Integer.valueOf(this.xModelo.getValueAt(x, 4).toString()).intValue() == 2) {
                            this.jdbcTemplate.update(xSql_Vista, new Object[]{this.fechaI, this.fechaF});
                        } else if (Integer.valueOf(this.xModelo.getValueAt(x, 4).toString()).intValue() == 3) {
                            this.jdbcTemplate.update(xSql_Vista, new Object[]{this.fechaI, this.fechaF, this.fechaI});
                        } else if (Integer.valueOf(this.xModelo.getValueAt(x, 4).toString()).intValue() == 4) {
                            this.jdbcTemplate.update(xSql_Vista, new Object[]{this.fechaI, this.fechaF, this.fechaI, this.fechaF});
                        }
                        System.out.println("Orden -- en 4   " + Integer.valueOf(this.xModelo.getValueAt(x, 5).toString()));
                    }
                    System.out.println("Consulta SqlVista Impresa JDialog -->    " + xSql_Vista);
                }
                this.xModelo.setValueAt("PROCESADO", x, 2);
                this.xjrButton.setForeground(Color.red);
            }
        }
    }

    @Override // com.genoma.plus.dao.sig.Resolucion2463_DAO
    public List<JDVariablesResolucion2463DTO> mCargarDatosSql2463(String xIdVariable) {
        String sql = "SELECT Descripcion,NSql,NParametros, Orden FROM p_res_2463_sql WHERE (NVariable='" + xIdVariable + "' AND Estado=1) ORDER BY Orden ASC;";
        RowMapper rowMapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.sig.Resolucion2463_DAOImpl.3
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                JDVariablesResolucion2463DTO variableRes2463 = new JDVariablesResolucion2463DTO();
                variableRes2463.setXDescripcion(rs.getString("Descripcion"));
                variableRes2463.setXNSql(rs.getString("NSql"));
                variableRes2463.setXNParametros(rs.getLong("NParametros"));
                variableRes2463.setXOrden(rs.getInt("Orden"));
                return variableRes2463;
            }
        };
        List<JDVariablesResolucion2463DTO> lstSesiones = this.jdbcTemplate.query(sql, rowMapper);
        return lstSesiones;
    }

    @Override // com.genoma.plus.dao.sig.Resolucion2463_DAO
    public List<Object[]> mListadoCompleto(int idEmpresaCont) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.sig.Resolucion2463_DAOImpl.4
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15), rs.getString(16), rs.getString(17), rs.getString(18), rs.getString(19), rs.getString(20), rs.getString(21), rs.getString(22), rs.getString(23), rs.getString(24), rs.getString(25), rs.getString(26), rs.getString(27), rs.getString(28), rs.getString(29), rs.getString(30), rs.getString(31), rs.getString(32), rs.getString(33), rs.getString(34), rs.getString(35), rs.getString(36), rs.getString(37), rs.getString(38), rs.getString(39), rs.getString(40), rs.getString(41), rs.getString(42), rs.getString(43), rs.getString(44), rs.getString(45), rs.getString(46), rs.getString(47), rs.getString(48), rs.getString(49), rs.getString(50), rs.getString(51), rs.getString(52), rs.getString(53), rs.getString(54), rs.getString(55), rs.getString(56), rs.getString(57), rs.getString(58), rs.getString(59), rs.getString(60), rs.getString(61), rs.getString(62), rs.getString(63), rs.getString(64), rs.getString(65), rs.getString(66), rs.getString(67), rs.getString(68), rs.getString(69), rs.getString(70), rs.getString(71), rs.getString(72), rs.getString(73), rs.getString(74), rs.getString(75), rs.getString(76), rs.getString(77), rs.getString(78), rs.getString(79), rs.getString(80), rs.getString(81), rs.getString(82), rs.getString(83), rs.getString(84), rs.getString(85), rs.getString(86), rs.getString(87), rs.getString(88), rs.getString(89), rs.getString(90), rs.getString(91), rs.getString(92), rs.getString(93), rs.getString(94), rs.getString(95), rs.getString(96), rs.getString(97), rs.getString(98), rs.getString(99), rs.getString(100), rs.getString(101), rs.getString(102), rs.getString(103), rs.getString(104), rs.getString(105), rs.getString(106), rs.getString(107), rs.getString(108), rs.getString(109), rs.getString(110), rs.getString(111), rs.getString(112), rs.getString(113), rs.getString(114), rs.getString(115), rs.getString(116), rs.getString(117), rs.getString(118), rs.getString(119), rs.getString(120), rs.getString(121), rs.getString(122), rs.getString(123), rs.getString(124), rs.getString(125), rs.getString(126), rs.getString(127), rs.getString(128)};
                return fila;
            }
        };
        String xSql = "SELECT\n '' AS NumResgitro\n    ,g_persona.`Nombre1` AS V1_Nombre1 \n    , IF(`g_persona`.`Nombre2`='', 'NONE', `g_persona`.`Nombre2`) AS V2_Nombre2\n    , `g_persona`.`Apellido1` AS V3_Apellido1\n    , IF(`g_persona`.`Apellido2`='', 'NOAP', `g_persona`.`Apellido2`) AS V4_Apellido2\n    , `g_persona`.`Id_TipoIdentificacion` AS V5_TipoDoc\n    , `g_persona`.`NoDocumento` AS V6_NoDcomento\n    , `g_persona`.`FechaNac` AS V7_FechaNac\n    , `g_persona`.`Id_Sexo` AS V8_Sexo\n    , `f_tiporegimen`.`Id_R2463` AS V9_TRegimen\n    , `g_empresacont`.`Codigo` AS V10_CodEPS\n    , `g_persona`.`Id_Etnia` AS V11_IdEtnia\n    , `g_usuario`.`IdPoblacionEspecial` AS V12_IdGruPobl\n    , `g_persona`.`Id_Municipio` AS V13_CodMpio\n    , IF(`g_persona`.`Telefono`='' && `g_persona`.`Movil`='', 98, IF(`g_persona`.`Telefono`='' && `g_persona`.`Movil`<>'',`g_persona`.`Movil`,\n    IF(`g_persona`.`Telefono`<>'' && `g_persona`.`Movil`='',`g_persona`.`Telefono`, CONCAT(`g_persona`.`Telefono`, ' ',`g_persona`.`Movil`)))) V14_Telefono\n    , p_res_2463_r.`V15` \n    , g_ips.`CodigoOrganismo` AS V16_CodIPS\n    , `p_res_2463_r`.`V17` \n, `p_res_2463_r`.`V18` \n, `p_res_2463_r`.`V19` \n, `p_res_2463_r`.`V19_1` \n, `p_res_2463_r`.`V20` \n, `p_res_2463_r`.`V21` \n, `p_res_2463_r`.`V21_1` \n, `p_res_2463_r`.`V22` \n, `p_res_2463_r`.`V23` \n, `p_res_2463_r`.`V24` \n, `p_res_2463_r`.`V25` \n, `p_res_2463_r`.`V26` \n, `p_res_2463_r`.`V27` \n, `p_res_2463_r`.`V27_1` \n, `p_res_2463_r`.`V28` \n, `p_res_2463_r`.`V28_1` \n, `p_res_2463_r`.`V29` \n, `p_res_2463_r`.`V29_1` \n, `p_res_2463_r`.`V30` \n, `p_res_2463_r`.`V30_1` \n, `p_res_2463_r`.`V31` \n, `p_res_2463_r`.`V31_1` \n, `p_res_2463_r`.`V32` \n, `p_res_2463_r`.`V32_1` \n, `p_res_2463_r`.`V33` \n, `p_res_2463_r`.`V33_1` \n, `p_res_2463_r`.`V34` \n, `p_res_2463_r`.`V34_1` \n, `p_res_2463_r`.`V35` \n, `p_res_2463_r`.`V36` \n, `p_res_2463_r`.`V37` \n, `p_res_2463_r`.`V38` \n, `p_res_2463_r`.`V39` \n, `p_res_2463_r`.`V40` \n, `p_res_2463_r`.`V41` \n, `p_res_2463_r`.`V42` \n, `p_res_2463_r`.`V43` \n, `p_res_2463_r`.`V44` \n, `p_res_2463_r`.`V45` \n, `p_res_2463_r`.`V46` \n, `p_res_2463_r`.`V47` \n, `p_res_2463_r`.`V48` \n, `p_res_2463_r`.`V49` \n, `p_res_2463_r`.`V50` \n, `p_res_2463_r`.`V51` \n, `p_res_2463_r`.`V52` \n, `p_res_2463_r`.`V53` \n, `p_res_2463_r`.`V54` \n, `p_res_2463_r`.`V55` \n, `p_res_2463_r`.`V56` \n, `p_res_2463_r`.`V57` \n, `p_res_2463_r`.`V58` \n, `p_res_2463_r`.`V59` \n, `p_res_2463_r`.`V60` \n, `p_res_2463_r`.`V61` \n, `p_res_2463_r`.`V62` \n, `p_res_2463_r`.`V62_1` \n, `p_res_2463_r`.`V62_2` \n, `p_res_2463_r`.`V62_3` \n, `p_res_2463_r`.`V62_4` \n, `p_res_2463_r`.`V62_5` \n, `p_res_2463_r`.`V62_6` \n, `p_res_2463_r`.`V62_7` \n, `p_res_2463_r`.`V62_8` \n, `p_res_2463_r`.`V62_9` \n, `p_res_2463_r`.`V62_10` \n, `p_res_2463_r`.`V62_11` \n, `p_res_2463_r`.`V63` \n, `p_res_2463_r`.`V63_1` \n, `p_res_2463_r`.`V64` \n, `p_res_2463_r`.`V65` \n, `p_res_2463_r`.`V66` \n, `p_res_2463_r`.`V67` \n, `p_res_2463_r`.`V68` \n, `p_res_2463_r`.`V69` \n, `p_res_2463_r`.`V69_1` \n, `p_res_2463_r`.`V69_2` \n, `p_res_2463_r`.`V69_3` \n, `p_res_2463_r`.`V69_4` \n, `p_res_2463_r`.`V69_5` \n, `p_res_2463_r`.`V69_6` \n, `p_res_2463_r`.`V69_7` \n, `p_res_2463_r`.`V70` \n, `p_res_2463_r`.`V70_1` \n, `p_res_2463_r`.`V70_2` \n, `p_res_2463_r`.`V70_3` \n, `p_res_2463_r`.`V70_4` \n, `p_res_2463_r`.`V70_5` \n, `p_res_2463_r`.`V70_6` \n, `p_res_2463_r`.`V70_7` \n, `p_res_2463_r`.`V70_8` \n, `p_res_2463_r`.`V70_9` \n, `p_res_2463_r`.`V71` \n, `p_res_2463_r`.`V72` \n, `p_res_2463_r`.`V73` \n, `p_res_2463_r`.`V74` \n, `p_res_2463_r`.`V75` \n, `p_res_2463_r`.`V76` \n, `p_res_2463_r`.`V77` \n, `p_res_2463_r`.`V78` \n, `p_res_2463_r`.`V79` \n, `p_res_2463_r`.`V80` \n, `p_res_2463_r`.`V80_1` \n, `p_res_2463_r`.`V81` \n, `p_res_2463_r`.`V81_1` \n, `p_res_2463_r`.`V82` \n, `p_res_2463_r`.`V82_1` \n, `p_res_2463_r`.`V83` \n, `p_res_2463_r`.`V83_1` \n, `p_res_2463_r`.`V84` \n, `p_res_2463_r`.`V84_1` \nFROM `g_ips`, \n     `g_persona`\n    INNER JOIN  `p_res_2463_r` \n        ON (`g_persona`.`Id` = `p_res_2463_r`.`IdPersona`)\n    INNER JOIN  `g_usuario` \n        ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)\n    INNER JOIN  `g_empresacont` \n        ON (`g_usuario`.`Id_EmpresaCont` = `g_empresacont`.`Id_empresa`)\n    INNER JOIN  `g_empresa` \n        ON (`g_empresa`.`Id` = `g_empresacont`.`Id_empresa`)\n    INNER JOIN  `f_tiporegimen` \n        ON (`g_empresacont`.`Id_TipoRegimen` = `f_tiporegimen`.`Id`)\n        WHERE `g_empresa`.`Id`='" + idEmpresaCont + "'";
        System.out.println("xsql-->" + xSql);
        List<Object[]> list = this.jdbcTemplate.query(xSql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.sig.Resolucion2463_DAO
    public List<Object[]> mListadoCompleto1() {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.sig.Resolucion2463_DAOImpl.5
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15), rs.getString(16), rs.getString(17), rs.getString(18), rs.getString(19), rs.getString(20), rs.getString(21), rs.getString(22), rs.getString(23), rs.getString(24), rs.getString(25), rs.getString(26), rs.getString(27), rs.getString(28), rs.getString(29), rs.getString(30), rs.getString(31), rs.getString(32), rs.getString(33), rs.getString(34), rs.getString(35), rs.getString(36), rs.getString(37), rs.getString(38), rs.getString(39), rs.getString(40), rs.getString(41), rs.getString(42), rs.getString(43), rs.getString(44), rs.getString(45), rs.getString(46), rs.getString(47), rs.getString(48), rs.getString(49), rs.getString(50), rs.getString(51), rs.getString(52), rs.getString(53), rs.getString(54), rs.getString(55), rs.getString(56), rs.getString(57), rs.getString(58), rs.getString(59), rs.getString(60), rs.getString(61), rs.getString(62), rs.getString(63), rs.getString(64), rs.getString(65), rs.getString(66), rs.getString(67), rs.getString(68), rs.getString(69), rs.getString(70), rs.getString(71), rs.getString(72), rs.getString(73), rs.getString(74), rs.getString(75), rs.getString(76), rs.getString(77), rs.getString(78), rs.getString(79), rs.getString(80), rs.getString(81), rs.getString(82), rs.getString(83), rs.getString(84), rs.getString(85), rs.getString(86), rs.getString(87), rs.getString(88), rs.getString(89), rs.getString(90), rs.getString(91), rs.getString(92), rs.getString(93), rs.getString(94), rs.getString(95), rs.getString(96), rs.getString(97), rs.getString(98), rs.getString(99), rs.getString(100), rs.getString(101), rs.getString(102), rs.getString(103), rs.getString(104), rs.getString(105), rs.getString(106), rs.getString(107), rs.getString(108), rs.getString(109), rs.getString(110), rs.getString(111), rs.getString(112), rs.getString(113), rs.getString(114), rs.getString(115), rs.getString(116), rs.getString(117), rs.getString(118), rs.getString(119), rs.getString(120), rs.getString(121), rs.getString(122), rs.getString(123), rs.getString(124), rs.getString(125), rs.getString(126), rs.getString(127), rs.getString(128)};
                return fila;
            }
        };
        System.out.println("xsql-->SELECT\n '' AS NumResgitro\n ,`g_persona`.`Nombre1` AS V1_Nombre1 \n    , IF(`g_persona`.`Nombre2`='', 'NONE', `g_persona`.`Nombre2`) AS V2_Nombre2\n    , `g_persona`.`Apellido1` AS V3_Apellido1\n    , IF(`g_persona`.`Apellido2`='', 'NOAP', `g_persona`.`Apellido2`) AS V4_Apellido2\n    , `g_persona`.`Id_TipoIdentificacion` AS V5_TipoDoc\n    , `g_persona`.`NoDocumento` AS V6_NoDcomento\n    , `g_persona`.`FechaNac` AS V7_FechaNac\n    , `g_persona`.`Id_Sexo` AS V8_Sexo\n    , `f_tiporegimen`.`Id_R2463` AS V9_TRegimen\n    , `g_empresacont`.`Codigo` AS V10_CodEPS\n    , `g_persona`.`Id_Etnia` AS V11_IdEtnia\n    , `g_usuario`.`IdPoblacionEspecial` AS V12_IdGruPobl\n    , `g_persona`.`Id_Municipio` AS V13_CodMpio\n    , IF(`g_persona`.`Telefono`='' && `g_persona`.`Movil`='', 98, IF(`g_persona`.`Telefono`='' && `g_persona`.`Movil`<>'',`g_persona`.`Movil`,\n    IF(`g_persona`.`Telefono`<>'' && `g_persona`.`Movil`='',`g_persona`.`Telefono`, CONCAT(`g_persona`.`Telefono`, ' ',`g_persona`.`Movil`)))) V14_Telefono\n    , p_res_2463_r.`V15` \n    , g_ips.`CodigoOrganismo` AS V16_CodIPS\n    , `p_res_2463_r`.`V17` \n, `p_res_2463_r`.`V18` \n, `p_res_2463_r`.`V19` \n, `p_res_2463_r`.`V19_1` \n, `p_res_2463_r`.`V20` \n, `p_res_2463_r`.`V21` \n, `p_res_2463_r`.`V21_1` \n, `p_res_2463_r`.`V22` \n, `p_res_2463_r`.`V23` \n, `p_res_2463_r`.`V24` \n, `p_res_2463_r`.`V25` \n, `p_res_2463_r`.`V26` \n, `p_res_2463_r`.`V27` \n, `p_res_2463_r`.`V27_1` \n, `p_res_2463_r`.`V28` \n, `p_res_2463_r`.`V28_1` \n, `p_res_2463_r`.`V29` \n, `p_res_2463_r`.`V29_1` \n, `p_res_2463_r`.`V30` \n, `p_res_2463_r`.`V30_1` \n, `p_res_2463_r`.`V31` \n, `p_res_2463_r`.`V31_1` \n, `p_res_2463_r`.`V32` \n, `p_res_2463_r`.`V32_1` \n, `p_res_2463_r`.`V33` \n, `p_res_2463_r`.`V33_1` \n, `p_res_2463_r`.`V34` \n, `p_res_2463_r`.`V34_1` \n, `p_res_2463_r`.`V35` \n, `p_res_2463_r`.`V36` \n, `p_res_2463_r`.`V37` \n, `p_res_2463_r`.`V38` \n, `p_res_2463_r`.`V39` \n, `p_res_2463_r`.`V40` \n, `p_res_2463_r`.`V41` \n, `p_res_2463_r`.`V42` \n, `p_res_2463_r`.`V43` \n, `p_res_2463_r`.`V44` \n, `p_res_2463_r`.`V45` \n, `p_res_2463_r`.`V46` \n, `p_res_2463_r`.`V47` \n, `p_res_2463_r`.`V48` \n, `p_res_2463_r`.`V49` \n, `p_res_2463_r`.`V50` \n, `p_res_2463_r`.`V51` \n, `p_res_2463_r`.`V52` \n, `p_res_2463_r`.`V53` \n, `p_res_2463_r`.`V54` \n, `p_res_2463_r`.`V55` \n, `p_res_2463_r`.`V56` \n, `p_res_2463_r`.`V57` \n, `p_res_2463_r`.`V58` \n, `p_res_2463_r`.`V59` \n, `p_res_2463_r`.`V60` \n, `p_res_2463_r`.`V61` \n, `p_res_2463_r`.`V62` \n, `p_res_2463_r`.`V62_1` \n, `p_res_2463_r`.`V62_2` \n, `p_res_2463_r`.`V62_3` \n, `p_res_2463_r`.`V62_4` \n, `p_res_2463_r`.`V62_5` \n, `p_res_2463_r`.`V62_6` \n, `p_res_2463_r`.`V62_7` \n, `p_res_2463_r`.`V62_8` \n, `p_res_2463_r`.`V62_9` \n, `p_res_2463_r`.`V62_10` \n, `p_res_2463_r`.`V62_11` \n, `p_res_2463_r`.`V63` \n, `p_res_2463_r`.`V63_1` \n, `p_res_2463_r`.`V64` \n, `p_res_2463_r`.`V65` \n, `p_res_2463_r`.`V66` \n, `p_res_2463_r`.`V67` \n, `p_res_2463_r`.`V68` \n, `p_res_2463_r`.`V69` \n, `p_res_2463_r`.`V69_1` \n, `p_res_2463_r`.`V69_2` \n, `p_res_2463_r`.`V69_3` \n, `p_res_2463_r`.`V69_4` \n, `p_res_2463_r`.`V69_5` \n, `p_res_2463_r`.`V69_6` \n, `p_res_2463_r`.`V69_7` \n, `p_res_2463_r`.`V70` \n, `p_res_2463_r`.`V70_1` \n, `p_res_2463_r`.`V70_2` \n, `p_res_2463_r`.`V70_3` \n, `p_res_2463_r`.`V70_4` \n, `p_res_2463_r`.`V70_5` \n, `p_res_2463_r`.`V70_6` \n, `p_res_2463_r`.`V70_7` \n, `p_res_2463_r`.`V70_8` \n, `p_res_2463_r`.`V70_9` \n, `p_res_2463_r`.`V71` \n, `p_res_2463_r`.`V72` \n, `p_res_2463_r`.`V73` \n, `p_res_2463_r`.`V74` \n, `p_res_2463_r`.`V75` \n, `p_res_2463_r`.`V76` \n, `p_res_2463_r`.`V77` \n, `p_res_2463_r`.`V78` \n, `p_res_2463_r`.`V79` \n, `p_res_2463_r`.`V80` \n, `p_res_2463_r`.`V80_1` \n, `p_res_2463_r`.`V81` \n, `p_res_2463_r`.`V81_1` \n, `p_res_2463_r`.`V82` \n, `p_res_2463_r`.`V82_1` \n, `p_res_2463_r`.`V83` \n, `p_res_2463_r`.`V83_1` \n, `p_res_2463_r`.`V84` \n, `p_res_2463_r`.`V84_1` \nFROM `g_ips`, \n     `g_persona`\n    INNER JOIN  `p_res_2463_r` \n        ON (`g_persona`.`Id` = `p_res_2463_r`.`IdPersona`)\n    INNER JOIN  `g_usuario` \n        ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)\n    INNER JOIN  `g_empresacont` \n        ON (`g_usuario`.`Id_EmpresaCont` = `g_empresacont`.`Id_empresa`)\n    INNER JOIN  `g_empresa` \n        ON (`g_empresa`.`Id` = `g_empresacont`.`Id_empresa`)\n    INNER JOIN  `f_tiporegimen` \n        ON (`g_empresacont`.`Id_TipoRegimen` = `f_tiporegimen`.`Id`);");
        List<Object[]> list = this.jdbcTemplate.query("SELECT\n '' AS NumResgitro\n ,`g_persona`.`Nombre1` AS V1_Nombre1 \n    , IF(`g_persona`.`Nombre2`='', 'NONE', `g_persona`.`Nombre2`) AS V2_Nombre2\n    , `g_persona`.`Apellido1` AS V3_Apellido1\n    , IF(`g_persona`.`Apellido2`='', 'NOAP', `g_persona`.`Apellido2`) AS V4_Apellido2\n    , `g_persona`.`Id_TipoIdentificacion` AS V5_TipoDoc\n    , `g_persona`.`NoDocumento` AS V6_NoDcomento\n    , `g_persona`.`FechaNac` AS V7_FechaNac\n    , `g_persona`.`Id_Sexo` AS V8_Sexo\n    , `f_tiporegimen`.`Id_R2463` AS V9_TRegimen\n    , `g_empresacont`.`Codigo` AS V10_CodEPS\n    , `g_persona`.`Id_Etnia` AS V11_IdEtnia\n    , `g_usuario`.`IdPoblacionEspecial` AS V12_IdGruPobl\n    , `g_persona`.`Id_Municipio` AS V13_CodMpio\n    , IF(`g_persona`.`Telefono`='' && `g_persona`.`Movil`='', 98, IF(`g_persona`.`Telefono`='' && `g_persona`.`Movil`<>'',`g_persona`.`Movil`,\n    IF(`g_persona`.`Telefono`<>'' && `g_persona`.`Movil`='',`g_persona`.`Telefono`, CONCAT(`g_persona`.`Telefono`, ' ',`g_persona`.`Movil`)))) V14_Telefono\n    , p_res_2463_r.`V15` \n    , g_ips.`CodigoOrganismo` AS V16_CodIPS\n    , `p_res_2463_r`.`V17` \n, `p_res_2463_r`.`V18` \n, `p_res_2463_r`.`V19` \n, `p_res_2463_r`.`V19_1` \n, `p_res_2463_r`.`V20` \n, `p_res_2463_r`.`V21` \n, `p_res_2463_r`.`V21_1` \n, `p_res_2463_r`.`V22` \n, `p_res_2463_r`.`V23` \n, `p_res_2463_r`.`V24` \n, `p_res_2463_r`.`V25` \n, `p_res_2463_r`.`V26` \n, `p_res_2463_r`.`V27` \n, `p_res_2463_r`.`V27_1` \n, `p_res_2463_r`.`V28` \n, `p_res_2463_r`.`V28_1` \n, `p_res_2463_r`.`V29` \n, `p_res_2463_r`.`V29_1` \n, `p_res_2463_r`.`V30` \n, `p_res_2463_r`.`V30_1` \n, `p_res_2463_r`.`V31` \n, `p_res_2463_r`.`V31_1` \n, `p_res_2463_r`.`V32` \n, `p_res_2463_r`.`V32_1` \n, `p_res_2463_r`.`V33` \n, `p_res_2463_r`.`V33_1` \n, `p_res_2463_r`.`V34` \n, `p_res_2463_r`.`V34_1` \n, `p_res_2463_r`.`V35` \n, `p_res_2463_r`.`V36` \n, `p_res_2463_r`.`V37` \n, `p_res_2463_r`.`V38` \n, `p_res_2463_r`.`V39` \n, `p_res_2463_r`.`V40` \n, `p_res_2463_r`.`V41` \n, `p_res_2463_r`.`V42` \n, `p_res_2463_r`.`V43` \n, `p_res_2463_r`.`V44` \n, `p_res_2463_r`.`V45` \n, `p_res_2463_r`.`V46` \n, `p_res_2463_r`.`V47` \n, `p_res_2463_r`.`V48` \n, `p_res_2463_r`.`V49` \n, `p_res_2463_r`.`V50` \n, `p_res_2463_r`.`V51` \n, `p_res_2463_r`.`V52` \n, `p_res_2463_r`.`V53` \n, `p_res_2463_r`.`V54` \n, `p_res_2463_r`.`V55` \n, `p_res_2463_r`.`V56` \n, `p_res_2463_r`.`V57` \n, `p_res_2463_r`.`V58` \n, `p_res_2463_r`.`V59` \n, `p_res_2463_r`.`V60` \n, `p_res_2463_r`.`V61` \n, `p_res_2463_r`.`V62` \n, `p_res_2463_r`.`V62_1` \n, `p_res_2463_r`.`V62_2` \n, `p_res_2463_r`.`V62_3` \n, `p_res_2463_r`.`V62_4` \n, `p_res_2463_r`.`V62_5` \n, `p_res_2463_r`.`V62_6` \n, `p_res_2463_r`.`V62_7` \n, `p_res_2463_r`.`V62_8` \n, `p_res_2463_r`.`V62_9` \n, `p_res_2463_r`.`V62_10` \n, `p_res_2463_r`.`V62_11` \n, `p_res_2463_r`.`V63` \n, `p_res_2463_r`.`V63_1` \n, `p_res_2463_r`.`V64` \n, `p_res_2463_r`.`V65` \n, `p_res_2463_r`.`V66` \n, `p_res_2463_r`.`V67` \n, `p_res_2463_r`.`V68` \n, `p_res_2463_r`.`V69` \n, `p_res_2463_r`.`V69_1` \n, `p_res_2463_r`.`V69_2` \n, `p_res_2463_r`.`V69_3` \n, `p_res_2463_r`.`V69_4` \n, `p_res_2463_r`.`V69_5` \n, `p_res_2463_r`.`V69_6` \n, `p_res_2463_r`.`V69_7` \n, `p_res_2463_r`.`V70` \n, `p_res_2463_r`.`V70_1` \n, `p_res_2463_r`.`V70_2` \n, `p_res_2463_r`.`V70_3` \n, `p_res_2463_r`.`V70_4` \n, `p_res_2463_r`.`V70_5` \n, `p_res_2463_r`.`V70_6` \n, `p_res_2463_r`.`V70_7` \n, `p_res_2463_r`.`V70_8` \n, `p_res_2463_r`.`V70_9` \n, `p_res_2463_r`.`V71` \n, `p_res_2463_r`.`V72` \n, `p_res_2463_r`.`V73` \n, `p_res_2463_r`.`V74` \n, `p_res_2463_r`.`V75` \n, `p_res_2463_r`.`V76` \n, `p_res_2463_r`.`V77` \n, `p_res_2463_r`.`V78` \n, `p_res_2463_r`.`V79` \n, `p_res_2463_r`.`V80` \n, `p_res_2463_r`.`V80_1` \n, `p_res_2463_r`.`V81` \n, `p_res_2463_r`.`V81_1` \n, `p_res_2463_r`.`V82` \n, `p_res_2463_r`.`V82_1` \n, `p_res_2463_r`.`V83` \n, `p_res_2463_r`.`V83_1` \n, `p_res_2463_r`.`V84` \n, `p_res_2463_r`.`V84_1` \nFROM `g_ips`, \n     `g_persona`\n    INNER JOIN  `p_res_2463_r` \n        ON (`g_persona`.`Id` = `p_res_2463_r`.`IdPersona`)\n    INNER JOIN  `g_usuario` \n        ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)\n    INNER JOIN  `g_empresacont` \n        ON (`g_usuario`.`Id_EmpresaCont` = `g_empresacont`.`Id_empresa`)\n    INNER JOIN  `g_empresa` \n        ON (`g_empresa`.`Id` = `g_empresacont`.`Id_empresa`)\n    INNER JOIN  `f_tiporegimen` \n        ON (`g_empresacont`.`Id_TipoRegimen` = `f_tiporegimen`.`Id`);", mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.sig.Resolucion2463_DAO
    public void eliminarTablaTemporal() {
        this.jdbcTemplate.update("DELETE FROM  p_tmp_datos_resultado_fgm");
    }

    @Override // com.genoma.plus.dao.sig.Resolucion2463_DAO
    public void mEjecutarSql_V35(String fechaInicial, String fechaFinal) {
        String xSql = "INSERT INTO p_tmp_datos_resultado_fgm\nSELECT \nn.persona1,\nn.`FechaNac`, n.`Id_Sexo` , n.talla , n.peso , n.`Fecha_Atencion`, n.`FResutlado`, n.VrNumerico ,  `Devuelve_Edad_2F`(n.FechaNac, n.Fecha_Atencion) CalcFe\n-- ,  ROUND(IF((n.peso<>0 AND CAST(n.VrNumerico AS DECIMAL(2,2))>0), IF(`Devuelve_Edad_2F`(n.FechaNac, n.Fecha_Atencion)>=18, IF(n.Id_Sexo='F', ((140-`Devuelve_Edad_2F`(n.FechaNac, n.Fecha_Atencion))*n.Peso)/ ((72*CAST(n.VrNumerico AS DECIMAL(2,2)))*0.85), ((140-`Devuelve_Edad_2F`(n.FechaNac, n.Fecha_Atencion))*n.Peso)/ (72*CAST(n.VrNumerico AS DECIMAL(2,2))) ),(n.talla*0.7)/CAST(n.VrNumerico AS DECIMAL(2,2)) ) , 0),2) FGM\n-- ,  ROUND(IF((n.peso<>0 AND CAST(n.VrNumerico AS DECIMAL(2,2))>0), IF(`Devuelve_Edad_2F`(n.FechaNac, n.Fecha_Atencion)>=18, IF(n.Id_Sexo='F', ((140-`Devuelve_Edad_2F`(n.FechaNac, n.Fecha_Atencion))*n.Peso)/ ((72*CAST(n.VrNumerico AS DECIMAL(2,2)))*0.85), ((140-`Devuelve_Edad_2F`(n.FechaNac, n.Fecha_Atencion))*n.Peso)/ (72*CAST(n.VrNumerico AS DECIMAL(2,2))) ),(n.talla*0.7)/CAST(n.VrNumerico AS DECIMAL(2,2)) ) , 0),2) FGM\n, ROUND(IF(n.Id_Sexo='F', ((((140-`Devuelve_Edad_2F`(n.FechaNac, n.Fecha_Atencion))*n.Peso)/ (72*n.VrNumerico))*0.85), (((140-`Devuelve_Edad_2F`(n.FechaNac, n.Fecha_Atencion))*n.Peso)/ (72*n.VrNumerico ))),2) fgm\nFROM (\nSELECT \n\td.persona1,  d.`FechaNac`, d.`Id_Sexo`\n    , d.talla\n    , d.peso\n  , d.`Fecha_Atencion`, f.`FResutlado`, f.VrNumerico \nFROM (\n\nSELECT `g_usuario`.Id_persona AS persona1, g_persona.`FechaNac`, g_persona.`Id_Sexo`\n    , `h_examenfisico`.`Talla` AS talla\n    , `h_examenfisico`.`Peso` AS peso\n--    , `h_examenfisico`.TArtSentadoD AS distolica \n  --  , `h_examenfisico`.TArtSentadoS AS sistolica\n  , h_atencion.`Fecha_Atencion`\nFROM\n    `baseserver`.`ingreso`\n    INNER JOIN `baseserver`.`g_usuario` \n        ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)\nINNER JOIN `baseserver`.`g_persona`\n        ON (`g_persona`.`Id` = `g_usuario`.`Id_persona`)\n    INNER JOIN `baseserver`.`h_atencion` \n        ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN `baseserver`.`c_clasecita` \n        ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`)\n    INNER JOIN `baseserver`.`h_examenfisico` \n        ON (`h_atencion`.`Id` = `h_examenfisico`.`Id_Atencion`)\n    INNER JOIN `baseserver`.`g_tipoprograma` \n        ON (`c_clasecita`.`Id_Programa` = `g_tipoprograma`.`Id_TipoPrograma`)\nWHERE ( `g_tipoprograma`.`Id_TipoPrograma` IN(1,2) AND `h_examenfisico`.`Talla` <>0 AND `h_examenfisico`.`Peso` <>0)) d \n\nINNER JOIN (SELECT  `l_recepcion`.`Id_Paciente` AS persona\n ,DATE_FORMAT(`l_resultados`.`FechaResult`,'%Y-%m-%d') AS `FResutlado`, l_detalleresultado.VrNumerico \nFROM  `l_detallerecepcion` \nINNER JOIN `l_recepcion`  ON (`l_detallerecepcion`.`Id_Recepcion` = `l_recepcion`.`Id`) \nINNER JOIN `l_resultados`  ON (`l_resultados`.`Id_Recepcion` = `l_recepcion`.`Id`) \nINNER JOIN `l_detalleresultado`  ON (`l_detalleresultado`.`Id_Resultado` = `l_resultados`.`Id`)\nINNER JOIN `l_protocoloxprocedimiento`  ON (`l_protocoloxprocedimiento`.`Id_Procedim` = `l_detallerecepcion`.`Id_Procedim`) \nAND (`l_detalleresultado`.`Id_ProtocolProcedim` = `l_protocoloxprocedimiento`.`Id`) \nINNER JOIN l_protocolos  ON (`l_protocoloxprocedimiento`.`Id_Protocolo` = `l_protocolos`.`Id`) \nINNER JOIN `l_tiporesultado`  ON (`l_tiporesultado`.`Id` = `l_detalleresultado`.`Resultado`)\nINNER JOIN `g_usuario`  ON (`g_usuario`.`Id_persona` = `l_recepcion`.`Id_Paciente`) \nINNER JOIN `g_persona`  ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)\nINNER JOIN (SELECT MAX(l_resultados.`Id`) IdRe, `l_recepcion`.`Id_Paciente`\nFROM  `l_detallerecepcion` \nINNER JOIN `l_recepcion`  ON (`l_detallerecepcion`.`Id_Recepcion` = `l_recepcion`.`Id`) \nINNER JOIN `l_resultados`  ON (`l_resultados`.`Id_Recepcion` = `l_recepcion`.`Id`) \nINNER JOIN `l_detalleresultado`  ON (`l_detalleresultado`.`Id_Resultado` = `l_resultados`.`Id`)\nINNER JOIN `l_protocoloxprocedimiento`  ON (`l_protocoloxprocedimiento`.`Id_Procedim` = `l_detallerecepcion`.`Id_Procedim`) \nAND (`l_detalleresultado`.`Id_ProtocolProcedim` = `l_protocoloxprocedimiento`.`Id`) \nINNER JOIN l_protocolos  ON (`l_protocoloxprocedimiento`.`Id_Protocolo` = `l_protocolos`.`Id`) \nINNER JOIN `l_tiporesultado`  ON (`l_tiporesultado`.`Id` = `l_detalleresultado`.`Resultado`)\nINNER JOIN `g_usuario`  ON (`g_usuario`.`Id_persona` = `l_recepcion`.`Id_Paciente`) \nINNER JOIN `g_persona`  ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)\nWHERE (l_protocolos.`V2463`='V27'  \nAND DATE_FORMAT(`l_resultados`.`FechaResult`,'%Y-%m-%d') >='" + fechaInicial + "'\nAND DATE_FORMAT(`l_resultados`.`FechaResult`,'%Y-%m-%d') <='" + fechaFinal + "' AND l_resultados.`Estado`=0\n-- AND `l_recepcion`.`Id_Paciente`=60335\n) GROUP BY   `l_recepcion`.`Id_Paciente`) f ON (f.Id_Paciente=`l_recepcion`.`Id_Paciente`)  AND (f.IdRe=l_resultados.`Id`)\nWHERE (l_protocolos.`V2463`='V27'  \nAND DATE_FORMAT(`l_resultados`.`FechaResult`,'%Y-%m-%d') >='" + fechaInicial + "'\nAND DATE_FORMAT(`l_resultados`.`FechaResult`,'%Y-%m-%d') <= '" + fechaFinal + "'  AND l_resultados.`Estado`=0\n-- and `l_recepcion`.`Id_Paciente`=60335\n)) f ON (f.persona=d.persona1)\n) n\nGROUP BY n.persona1";
        this.jdbcTemplate.update(xSql);
    }
}
