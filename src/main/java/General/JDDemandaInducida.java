package General;

import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:General/JDDemandaInducida.class */
public class JDDemandaInducida extends JDialog {
    private String xsql;
    private ConsultasMySQL xct;
    private Metodos xmt;
    private DefaultTableModel xmodelo;
    private Object[] xdatos;
    private String xsexo;
    private String xfechanac;
    private String xidusuario;
    private String xTEdad;
    private JLabel JLBtitulo;
    private JScrollPane JSPDetalle;
    private JTable JTBDetalle;
    private JCheckBox jCheckBox1;
    private JCheckBox jCheckBox2;
    private JCheckBox jCheckBox3;

    public JDDemandaInducida(Frame parent, boolean modal, String xsexo, String xfechanac, String xidusuario) {
        super(parent, modal);
        this.xct = new ConsultasMySQL();
        this.xmt = new Metodos();
        this.xTEdad = "";
        initComponents();
        this.xsexo = xsexo;
        this.xfechanac = xfechanac;
        this.xidusuario = xidusuario;
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        mCargarDetalle();
    }

    /* JADX WARN: Type inference failed for: r3v5, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JLBtitulo = new JLabel();
        this.JSPDetalle = new JScrollPane();
        this.JTBDetalle = new JTable();
        this.jCheckBox1 = new JCheckBox();
        this.jCheckBox2 = new JCheckBox();
        this.jCheckBox3 = new JCheckBox();
        setDefaultCloseOperation(2);
        this.JLBtitulo.setFont(new Font("Arial", 1, 18));
        this.JLBtitulo.setForeground(new Color(0, 103, 0));
        this.JLBtitulo.setHorizontalAlignment(0);
        this.JLBtitulo.setText("<html><P ALIGN=center> DEMANDA INDUCIDA</p> PROMOCIÓN Y PREVENCIÓN");
        this.JLBtitulo.setToolTipText("");
        this.JLBtitulo.setBorder(BorderFactory.createBevelBorder(0));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "ACTIVIDADES", 2, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.JTBDetalle.setFont(new Font("Arial", 1, 12));
        this.JTBDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTBDetalle.setRowHeight(25);
        this.JTBDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTBDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTBDetalle.setSelectionMode(0);
        this.JSPDetalle.setViewportView(this.JTBDetalle);
        this.jCheckBox1.setBackground(Color.red);
        this.jCheckBox1.setFont(new Font("Arial", 1, 12));
        this.jCheckBox1.setForeground(new Color(255, 255, 255));
        this.jCheckBox1.setText("Vencidas");
        this.jCheckBox2.setBackground(new Color(255, 255, 255));
        this.jCheckBox2.setFont(new Font("Arial", 1, 12));
        this.jCheckBox2.setText("Sin Notificación");
        this.jCheckBox3.setBackground(new Color(60, 193, 191));
        this.jCheckBox3.setFont(new Font("Arial", 1, 12));
        this.jCheckBox3.setText("Pronto a vencer");
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.jCheckBox1).addGap(18, 18, 18).addComponent(this.jCheckBox3).addGap(19, 19, 19).addComponent(this.jCheckBox2).addGap(0, 0, 32767)).addComponent(this.JLBtitulo).addComponent(this.JSPDetalle, -1, 829, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(3, 3, 3).addComponent(this.JLBtitulo, -2, 69, -2).addGap(3, 3, 3).addComponent(this.JSPDetalle, -2, 302, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jCheckBox1).addComponent(this.jCheckBox2).addComponent(this.jCheckBox3)).addContainerGap(-1, 32767)));
        pack();
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
            Logger.getLogger(JDDemandaInducida.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDato() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Tipo", "Procedimiento", "FRealización", "Peridiocidad", "IdProcedimiento", "Vencido"}) { // from class: General.JDDemandaInducida.1
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
            this.xsql = "SELECT UCASE(`f_tipoprocedimiento`.`Nbre`) AS `TipoServicio`, UCASE(`g_procedimiento`.`Nbre`) AS `Nprocedimiento`,IF( (`p_demanda_inducida`.`Peridiocidad`/30)>12,CONCAT(ROUND((`p_demanda_inducida`.`Peridiocidad`/30)/12),' Año(s)'),CONCAT(ROUND(`p_demanda_inducida`.`Peridiocidad`/30),' Mes(es)')) AS Peridiocidad, `g_procedimiento`.`Id`,  `p_demanda_inducida`.`Peridiocidad` FROM  `p_demanda_inducida` INNER JOIN  `g_procedimiento`  ON (`p_demanda_inducida`.`Id_Procedimiento` = `g_procedimiento`.`Id`) INNER JOIN  `f_tipoprocedimiento`  ON (`g_procedimiento`.`Id_tipoprocedimiento` = `f_tipoprocedimiento`.`Id`) INNER JOIN  `g_tipoprograma`  ON (`p_demanda_inducida`.`Id_Programa` = `g_tipoprograma`.`Id_TipoPrograma`) WHERE (`p_demanda_inducida`.`Id_Sexo` ='" + this.xsexo + "' AND INTERVAL((SELECT Calcula_Edad('" + this.xfechanac + "')),`p_demanda_inducida`.`EdadI`, `p_demanda_inducida`.`EdadF`) =1 AND (p_demanda_inducida.`TEdadI`='" + this.xTEdad + "' OR p_demanda_inducida.`TEdadF`='" + this.xTEdad + "') and p_demanda_inducida.EsDemanda=1) GROUP BY `g_procedimiento`.`Id` ORDER BY `TipoServicio` ASC, `Nprocedimiento` ASC ";
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
            Logger.getLogger(JDDemandaInducida.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
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
            Logger.getLogger(JDDemandaInducida.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX INFO: loaded from: GenomaP.jar:General/JDDemandaInducida$MiRender.class */
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
