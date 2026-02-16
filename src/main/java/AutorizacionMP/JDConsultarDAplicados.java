package AutorizacionMP;

import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:AutorizacionMP/JDConsultarDAplicados.class */
public class JDConsultarDAplicados extends JDialog {
    private ConsultasMySQL xconsultas;
    private Metodos xmt;
    private DefaultTableModel xmodelo;
    private Object[] xdato;
    private String sql;
    private JScrollPane JSPHistorico;
    private JTable JTHistorico;

    public JDConsultarDAplicados(Frame parent, boolean modal, String xid) {
        super(parent, modal);
        this.xconsultas = new ConsultasMySQL();
        this.xmt = new Metodos();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        initComponents();
        mCargarTabla(xid);
    }

    /* JADX WARN: Type inference failed for: r3v4, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JSPHistorico = new JScrollPane();
        this.JTHistorico = new JTable();
        setDefaultCloseOperation(2);
        setTitle("Consolidado de Descuento");
        this.JSPHistorico.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JSPHistorico.setFont(new Font("Arial", 1, 12));
        this.JTHistorico.setFont(new Font("Arial", 1, 12));
        this.JTHistorico.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTHistorico.setRowHeight(25);
        this.JTHistorico.setSelectionBackground(new Color(255, 255, 255));
        this.JTHistorico.setSelectionForeground(Color.red);
        this.JTHistorico.setSelectionMode(0);
        this.JSPHistorico.setViewportView(this.JTHistorico);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JSPHistorico, -1, 461, 32767).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JSPHistorico, -1, 278, 32767).addContainerGap()));
        pack();
    }

    private void mCrearTabla() {
        this.xmodelo = new DefaultTableModel((Object[][]) null, new String[]{"N° Plantilla", "Fecha", "V/Descontar", "V/Descontado"}) { // from class: AutorizacionMP.JDConsultarDAplicados.1
            Class[] types = {Long.class, String.class, Double.class, Double.class};
            boolean[] canEdit = {false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTHistorico.setModel(this.xmodelo);
        this.JTHistorico.getColumnModel().getColumn(0).setPreferredWidth(30);
        this.JTHistorico.getColumnModel().getColumn(1).setPreferredWidth(30);
        this.JTHistorico.getColumnModel().getColumn(2).setPreferredWidth(50);
        this.JTHistorico.getColumnModel().getColumn(3).setPreferredWidth(50);
    }

    private void mCargarTabla(String xid) {
        mCrearTabla();
        this.sql = "SELECT d_relacion.Id, DATE_FORMAT(d_relacion.FechaI, '%d-%m-%Y') AS Fecha, d_detalle_relacion.VADescontar , d_detalle_relacion.VDescontado FROM d_detalle_relacion INNER JOIN d_relacion  ON (d_detalle_relacion.Id_Relacion = d_relacion.Id) WHERE d_detalle_relacion.Id_Descuento ='" + xid + "' ORDER BY d_relacion.Id DESC ";
        ResultSet rs = this.xconsultas.traerRs(this.sql);
        try {
            if (rs.next()) {
                rs.beforeFirst();
                int x = 0;
                while (rs.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(Long.valueOf(rs.getLong(1)), x, 0);
                    this.xmodelo.setValueAt(rs.getString(2), x, 1);
                    this.xmodelo.setValueAt(Double.valueOf(rs.getDouble(3)), x, 2);
                    this.xmodelo.setValueAt(Double.valueOf(rs.getDouble(4)), x, 3);
                    x++;
                }
            }
            rs.close();
            this.xconsultas.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JDConsultarDAplicados.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }
}
