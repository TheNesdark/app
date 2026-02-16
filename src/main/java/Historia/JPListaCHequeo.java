package Historia;

import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Historia/JPListaCHequeo.class */
public class JPListaCHequeo extends JPanel {
    private DefaultTableModel xmodelo;
    private String xsql;
    private Object[] xdatos;
    private String xsexo;
    private String xfechanac;
    private String xidusuario;
    private JScrollPane JSPDetalle;
    private JTable JTBDetalle;
    private Metodos xmt = new Metodos();
    private ConsultasMySQL xct = new ConsultasMySQL();
    private String xTEdad = "";

    public JPListaCHequeo() {
        initComponents();
        String sql = "SELECT FechaNac AS AnioNac FROM `persona` WHERE (`Id_persona` ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "');";
        ResultSet xrs = this.xct.traerRs(sql);
        this.xidusuario = String.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido());
        try {
            if (xrs.next()) {
                this.xfechanac = xrs.getString(1);
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPGraficasPyP.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        mCargarDetalle();
    }

    /* JADX WARN: Type inference failed for: r3v3, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JSPDetalle = new JScrollPane();
        this.JTBDetalle = new JTable();
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "ACTIVIDADES", 2, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.JTBDetalle.setFont(new Font("Arial", 1, 12));
        this.JTBDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTBDetalle.setRowHeight(25);
        this.JTBDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTBDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTBDetalle.setSelectionMode(0);
        this.JSPDetalle.setViewportView(this.JTBDetalle);
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addComponent(this.JSPDetalle, -1, 689, 32767).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JSPDetalle, -1, 442, 32767).addContainerGap()));
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDato() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Tipo", "Procedimiento", "FRealización", "Peridiocidad", "IdProcedimiento", "Vencido"}) { // from class: Historia.JPListaCHequeo.1
            Class[] types = {String.class, String.class, String.class, String.class, String.class, Long.class};
            boolean[] canEdit = {false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTBDetalle.setModel(this.xmodelo);
        this.JTBDetalle.getColumnModel().getColumn(0).setPreferredWidth(50);
        this.JTBDetalle.getColumnModel().getColumn(1).setPreferredWidth(300);
        this.JTBDetalle.getColumnModel().getColumn(2).setPreferredWidth(20);
        this.JTBDetalle.getColumnModel().getColumn(3).setPreferredWidth(20);
        this.JTBDetalle.getColumnModel().getColumn(4).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(4).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(4).setMaxWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(5).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(5).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(5).setMaxWidth(0);
    }

    private void mCargarDetalle() {
        try {
            mCrearModeloDato();
            mBuscaTipoEdad();
            this.xsql = "SELECT UCASE(`f_tipoprocedimiento`.`Nbre`) AS `TipoServicio`, UCASE(`p_demanda_inducida`.`Nbre`) AS `Nprocedimiento`,IF( (`p_demanda_inducida`.`Peridiocidad`/30)>12,CONCAT(ROUND((`p_demanda_inducida`.`Peridiocidad`/30)/12),' Año(s)'),CONCAT(ROUND(`p_demanda_inducida`.`Peridiocidad`/30),' Mes(es)')) AS Peridiocidad, `g_procedimiento`.`Id`,  `p_demanda_inducida`.`Peridiocidad` FROM  `p_demanda_inducida` INNER JOIN  `g_procedimiento`  ON (`p_demanda_inducida`.`Id_Procedimiento` = `g_procedimiento`.`Id`) INNER JOIN  `f_tipoprocedimiento`  ON (`g_procedimiento`.`Id_tipoprocedimiento` = `f_tipoprocedimiento`.`Id`) INNER JOIN  `g_tipoprograma`  ON (`p_demanda_inducida`.`Id_Programa` = `g_tipoprograma`.`Id_TipoPrograma`) WHERE (`p_demanda_inducida`.`Id_Sexo` ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getNombreSexo() + "' AND INTERVAL((SELECT Calcula_Edad('" + this.xfechanac + "')),`p_demanda_inducida`.`EdadI`, `p_demanda_inducida`.`EdadF`) =1 AND (p_demanda_inducida.`TEdadI`='" + this.xTEdad + "' OR p_demanda_inducida.`TEdadF`='" + this.xTEdad + "') and p_demanda_inducida.EsDemanda=1) GROUP BY `g_procedimiento`.`Id` ORDER BY `TipoServicio` ASC, `Nprocedimiento` ASC ";
            ResultSet xrs = this.xct.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int x = 0;
                this.xmt.mEstablecerTextEditor(this.JTBDetalle, 1);
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(xrs.getString(1), x, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), x, 1);
                    this.xmodelo.setValueAt(xrs.getString(3), x, 3);
                    this.xmodelo.setValueAt(xrs.getString(4), x, 4);
                    mFechaAtencion(xrs.getString(4), x, xrs.getLong(5));
                    this.JTBDetalle.setDefaultRenderer(Object.class, new MiRender());
                    x++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPListaCHequeo.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mFechaAtencion(String xidprocedimiento, int xfila, long xndias) {
        try {
            ConsultasMySQL xct1 = new ConsultasMySQL();
            this.xsql = "SELECT DATE_FORMAT(MAX(`f_ordenes`.`FechaOrden`),'%d-%m-%Y') AS FechaR, ADDDATE(MAX(`f_ordenes`.`FechaOrden`), INTERVAL " + xndias + "  DAY) AS PF,  DATEDIFF(ADDDATE(MAX(`f_ordenes`.`FechaOrden`), INTERVAL " + xndias + "  DAY), NOW())AS Dif FROM `f_itemordenesproced`  INNER JOIN  `f_ordenes`  ON (`f_itemordenesproced`.`Id_Ordenes` = `f_ordenes`.`Id`) INNER JOIN  `ingreso`  ON (`f_ordenes`.`Id_Ingreso` = `ingreso`.`Id`) WHERE (`ingreso`.`Id_Usuario` ='" + this.xidusuario + "' AND `f_itemordenesproced`.`Id_Procedimiento` ='" + xidprocedimiento + "' AND `f_ordenes`.`Estado` =0) ORDER BY  `f_ordenes`.`FechaOrden` DESC ";
            ResultSet xrs = xct1.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.first();
                this.xmodelo.setValueAt(xrs.getString(1), xfila, 2);
                if (xrs.getInt(3) < 0) {
                    this.xmodelo.setValueAt(1, xfila, 5);
                } else if (xrs.getInt(3) > 0 && xrs.getInt(3) <= 30) {
                    this.xmodelo.setValueAt(2, xfila, 5);
                } else {
                    this.xmodelo.setValueAt(3, xfila, 5);
                }
            } else {
                this.xmodelo.setValueAt("SIN DATO", xfila, 2);
                this.xmodelo.setValueAt(0, xfila, 5);
            }
            xrs.close();
            xct1.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPListaCHequeo.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mBuscaTipoEdad() {
        String sql = "SELECT `Devuelve_Tipo_Edad_Sing`('" + this.xfechanac + "') AS TipoEdad";
        ResultSet xrs = this.xct.traerRs(sql);
        try {
            if (xrs.next()) {
                xrs.first();
                this.xTEdad = xrs.getString("TipoEdad");
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPListaCHequeo.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX INFO: loaded from: GenomaP.jar:Historia/JPListaCHequeo$MiRender.class */
    public static class MiRender extends DefaultTableCellRenderer {
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (table.getValueAt(row, 5).toString().equals("1")) {
                cell.setBackground(Color.RED);
                cell.setForeground(Color.WHITE);
            } else if (table.getValueAt(row, 5).toString().equals("2")) {
                cell.setBackground(new Color(60, 193, 191));
                cell.setForeground(Color.BLACK);
            } else if (table.getValueAt(row, 5).toString().equals("3")) {
                cell.setBackground(Color.white);
                cell.setForeground(Color.BLACK);
            } else {
                cell.setBackground(Color.RED);
                cell.setForeground(Color.WHITE);
            }
            return cell;
        }
    }
}
