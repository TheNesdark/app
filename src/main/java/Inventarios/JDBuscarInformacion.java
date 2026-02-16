package Inventarios;

import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyVetoException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Inventarios/JDBuscarInformacion.class */
public class JDBuscarInformacion extends JDialog {
    private Metodos xmt;
    private ConsultasMySQL xct;
    private String xsql;
    private String xnombre;
    private String[] xidbodega;
    private DefaultTableModel xmodelo;
    private Object[] xdato;
    private JIFAuditoriasProductos xjifap;
    private JButton JBTCargar;
    private JButton JBTSalir;
    private JPanel JPIDatosB;
    private JScrollPane JSPDetalleP;
    private JTable JTPDetalleP;

    public JDBuscarInformacion(Frame parent, boolean modal, String xnombre, JInternalFrame xjf) {
        super(parent, modal);
        this.xmt = new Metodos();
        this.xct = new ConsultasMySQL();
        initComponents();
        this.xnombre = xnombre;
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        mCargarDatosTabla();
        mHacerCasting(xjf);
    }

    /* JADX WARN: Type inference failed for: r3v6, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPIDatosB = new JPanel();
        this.JSPDetalleP = new JScrollPane();
        this.JTPDetalleP = new JTable();
        this.JBTCargar = new JButton();
        this.JBTSalir = new JButton();
        setDefaultCloseOperation(2);
        this.JPIDatosB.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS PARA BÚSQUEDA", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        GroupLayout JPIDatosBLayout = new GroupLayout(this.JPIDatosB);
        this.JPIDatosB.setLayout(JPIDatosBLayout);
        JPIDatosBLayout.setHorizontalGroup(JPIDatosBLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 0, 32767));
        JPIDatosBLayout.setVerticalGroup(JPIDatosBLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 64, 32767));
        this.JSPDetalleP.setBorder(BorderFactory.createTitledBorder((Border) null, "RESULTADO", 2, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.JTPDetalleP.setFont(new Font("Arial", 1, 12));
        this.JTPDetalleP.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTPDetalleP.setRowHeight(25);
        this.JTPDetalleP.setSelectionBackground(new Color(255, 255, 255));
        this.JTPDetalleP.setSelectionForeground(new Color(255, 0, 0));
        this.JTPDetalleP.setSelectionMode(0);
        this.JTPDetalleP.addMouseListener(new MouseAdapter() { // from class: Inventarios.JDBuscarInformacion.1
            public void mouseClicked(MouseEvent evt) {
                JDBuscarInformacion.this.JTPDetallePMouseClicked(evt);
            }
        });
        this.JSPDetalleP.setViewportView(this.JTPDetalleP);
        this.JBTCargar.setFont(new Font("Arial", 1, 12));
        this.JBTCargar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTCargar.setText("Cargar");
        this.JBTCargar.addActionListener(new ActionListener() { // from class: Inventarios.JDBuscarInformacion.2
            public void actionPerformed(ActionEvent evt) {
                JDBuscarInformacion.this.JBTCargarActionPerformed(evt);
            }
        });
        this.JBTSalir.setFont(new Font("Arial", 1, 12));
        this.JBTSalir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.JBTSalir.setText("Salir");
        this.JBTSalir.addActionListener(new ActionListener() { // from class: Inventarios.JDBuscarInformacion.3
            public void actionPerformed(ActionEvent evt) {
                JDBuscarInformacion.this.JBTSalirActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPIDatosB, -1, -1, 32767).addComponent(this.JSPDetalleP).addGroup(layout.createSequentialGroup().addComponent(this.JBTCargar, -2, 330, -2).addGap(18, 18, 18).addComponent(this.JBTSalir, -1, 341, 32767))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatosB, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalleP, -2, 248, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBTCargar, -1, 50, 32767).addComponent(this.JBTSalir, -1, 50, 32767)).addGap(16, 16, 16)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTSalirActionPerformed(ActionEvent evt) {
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTPDetallePMouseClicked(MouseEvent evt) {
        mCargarDato();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTCargarActionPerformed(ActionEvent evt) {
        mCargarDato();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTablaDetalle() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Fecha", "Bodega", "Cantidad", "Estado", "Estado"}) { // from class: Inventarios.JDBuscarInformacion.4
            Class[] types = {String.class, String.class, String.class, Long.class, Boolean.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTPDetalleP.setModel(this.xmodelo);
        this.JTPDetalleP.getColumnModel().getColumn(0).setPreferredWidth(30);
        this.JTPDetalleP.getColumnModel().getColumn(1).setPreferredWidth(20);
        this.JTPDetalleP.getColumnModel().getColumn(2).setPreferredWidth(80);
        this.JTPDetalleP.getColumnModel().getColumn(3).setPreferredWidth(10);
        this.JTPDetalleP.getColumnModel().getColumn(4).setPreferredWidth(10);
        this.JTPDetalleP.getColumnModel().getColumn(5).setPreferredWidth(10);
    }

    private void mCargarDatosTabla() {
        try {
            mCrearTablaDetalle();
            if (this.xnombre.equals("xjifauditoriaaleatoria") || this.xnombre.equals("xjifauditoriaaleatoria1")) {
                this.xsql = "SELECT `i_auditoria`.`Id` , DATE_FORMAT(`i_auditoria`.`FechaAuditoria`,'%d-%m-%Y') AS Fecha , `i_bodegas`.`Nbre` , `i_auditoria`.`Cantidad`, `i_auditoria`.`Estado`, `i_auditoria`.`EstadoC` FROM  `i_detalleauditoria` INNER JOIN  `i_suministroxbodega`  ON (`i_detalleauditoria`.`IdSuministroB` = `i_suministroxbodega`.`Id`) INNER JOIN  `i_auditoria`  ON (`i_detalleauditoria`.`Id` = `i_auditoria`.`Id`) INNER JOIN  `i_suministro`  ON (`i_suministroxbodega`.`IdSuministro` = `i_suministro`.`Id`) INNER JOIN  `i_bodegas`  ON (`i_auditoria`.`IdBodega` = `i_bodegas`.`Id`) INNER JOIN  `i_presentacioncomercial`  ON (`i_suministro`.`IdPresentacionComercial` = `i_presentacioncomercial`.`Id`) INNER JOIN  `i_laboratorio`  ON (`i_suministro`.`IdLaboratorio` = `i_laboratorio`.`Id`) GROUP BY `i_auditoria`.`Id` ORDER BY `i_auditoria`.`FechaAuditoria` DESC ";
            }
            ResultSet xrs = this.xct.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(1)), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelo.setValueAt(Integer.valueOf(xrs.getInt(4)), n, 3);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(5)), n, 4);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(6)), n, 5);
                    this.JTPDetalleP.setDefaultRenderer(Object.class, new MiRender());
                    n++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFAuditoriasProductos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mHacerCasting(JInternalFrame xjifp) {
        if (this.xnombre.equals("xjifauditoriaaleatoria") || this.xnombre.equals("xjifauditoriaaleatoria1")) {
            this.xjifap = (JIFAuditoriasProductos) xjifp;
        }
    }

    private void mCargarDato() {
        if (this.JTPDetalleP.getSelectedRow() != -1) {
            if (this.xnombre.equals("xjifauditoriaaleatoria") || this.xnombre.equals("xjifauditoriaaleatoria1")) {
                try {
                    this.xjifap.mBuscarDatosId(this.xmodelo.getValueAt(this.JTPDetalleP.getSelectedRow(), 0).toString());
                    this.xjifap.setSelected(true);
                } catch (PropertyVetoException e) {
                    Logger.getLogger(JDBuscarInformacion.class.getName()).log(Level.SEVERE, (String) null, e);
                }
            }
            dispose();
        }
    }

    /* JADX INFO: loaded from: GenomaP.jar:Inventarios/JDBuscarInformacion$MiRender.class */
    public static class MiRender extends DefaultTableCellRenderer {
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (Boolean.valueOf(table.getValueAt(row, 5).toString()).booleanValue()) {
                cell.setBackground(new Color(177, 251, 177));
            } else {
                cell.setBackground(Color.WHITE);
            }
            return cell;
        }
    }
}
