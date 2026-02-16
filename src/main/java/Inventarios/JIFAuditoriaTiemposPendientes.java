package Inventarios;

import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Inventarios/JIFAuditoriaTiemposPendientes.class */
public class JIFAuditoriaTiemposPendientes extends JInternalFrame {
    private DefaultTableModel xmodelotabla;
    private Object xjfe;
    private JDateChooser JDCFechaF;
    private JDateChooser JDCFechaI;
    private JPanel JPIConsolidado;
    private JPanel JPIDatosC;
    private JScrollPane JSPDetalleResultado;
    private JFormattedTextField JTFFNPendientes;
    private JFormattedTextField JTFFNPromedio;
    private JFormattedTextField JTFFNTDias;
    private JTable JTResultado;
    private JPanel jPanel1;
    private ConsultasMySQL xconsultas = new ConsultasMySQL();
    private Metodos xmetodos = new Metodos();
    public boolean xfiltro = true;

    public JIFAuditoriaTiemposPendientes() {
        initComponents();
        this.JDCFechaI.setDate(this.xmetodos.getFechaActual());
        this.JDCFechaF.setDate(this.xmetodos.getFechaActual());
        mCrearTablaDetalle();
    }

    /* JADX WARN: Type inference failed for: r3v47, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jPanel1 = new JPanel();
        this.JPIDatosC = new JPanel();
        this.JDCFechaI = new JDateChooser();
        this.JDCFechaF = new JDateChooser();
        this.JPIConsolidado = new JPanel();
        this.JTFFNPendientes = new JFormattedTextField();
        this.JTFFNTDias = new JFormattedTextField();
        this.JTFFNPromedio = new JFormattedTextField();
        this.JSPDetalleResultado = new JScrollPane();
        this.JTResultado = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("AUDITORIA DE TIEMPO DE ENTREGA DE PENDIENTE");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jiftiemposllamada");
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACION TIEMPO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.jPanel1.setName("jptriage");
        this.JPIDatosC.setBorder(BorderFactory.createEtchedBorder());
        this.JDCFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicio", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDCFechaI.setFont(new Font("Arial", 1, 12));
        this.JDCFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Fin", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDCFechaF.setFont(new Font("Arial", 1, 12));
        this.JPIConsolidado.setBorder(BorderFactory.createTitledBorder((Border) null, "Consolidado", 0, 0, new Font("Arial", 1, 13), Color.red));
        this.JTFFNPendientes.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Ordenes", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFNPendientes.setHorizontalAlignment(4);
        this.JTFFNPendientes.setFont(new Font("Arial", 1, 12));
        this.JTFFNTDias.setBorder(BorderFactory.createTitledBorder((Border) null, "Total Dias", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFNTDias.setHorizontalAlignment(4);
        this.JTFFNTDias.setFont(new Font("Arial", 1, 12));
        this.JTFFNPromedio.setBorder(BorderFactory.createTitledBorder((Border) null, "Promedio (Dias)", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFNPromedio.setHorizontalAlignment(4);
        this.JTFFNPromedio.setFont(new Font("Arial", 1, 12));
        GroupLayout JPIConsolidadoLayout = new GroupLayout(this.JPIConsolidado);
        this.JPIConsolidado.setLayout(JPIConsolidadoLayout);
        JPIConsolidadoLayout.setHorizontalGroup(JPIConsolidadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIConsolidadoLayout.createSequentialGroup().addContainerGap().addComponent(this.JTFFNPendientes, -2, 100, -2).addGap(18, 18, 18).addComponent(this.JTFFNTDias, -2, 106, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFFNPromedio, -2, 132, -2).addContainerGap(151, 32767)));
        JPIConsolidadoLayout.setVerticalGroup(JPIConsolidadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIConsolidadoLayout.createSequentialGroup().addGroup(JPIConsolidadoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFNPendientes, -2, -1, -2).addComponent(this.JTFFNTDias, -2, -1, -2).addComponent(this.JTFFNPromedio, -2, -1, -2)).addContainerGap(-1, 32767)));
        GroupLayout JPIDatosCLayout = new GroupLayout(this.JPIDatosC);
        this.JPIDatosC.setLayout(JPIDatosCLayout);
        JPIDatosCLayout.setHorizontalGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosCLayout.createSequentialGroup().addContainerGap().addComponent(this.JDCFechaI, -2, 143, -2).addGap(18, 18, 18).addComponent(this.JDCFechaF, -2, 143, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JPIConsolidado, -2, -1, -2).addGap(109, 109, 109)));
        JPIDatosCLayout.setVerticalGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosCLayout.createSequentialGroup().addGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosCLayout.createSequentialGroup().addGap(19, 19, 19).addGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JDCFechaI, -2, 56, -2).addComponent(this.JDCFechaF, -2, 56, -2))).addGroup(JPIDatosCLayout.createSequentialGroup().addContainerGap().addComponent(this.JPIConsolidado, -2, -1, -2))).addContainerGap(-1, 32767)));
        this.JSPDetalleResultado.setBorder(BorderFactory.createTitledBorder((Border) null, "RESULTADO", 2, 0, new Font("Arial", 1, 14), Color.blue));
        this.JTResultado.setFont(new Font("Arial", 1, 12));
        this.JTResultado.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTResultado.setRowHeight(25);
        this.JTResultado.setSelectionBackground(new Color(255, 255, 255));
        this.JTResultado.setSelectionForeground(new Color(255, 0, 0));
        this.JTResultado.setSelectionMode(0);
        this.JTResultado.addMouseListener(new MouseAdapter() { // from class: Inventarios.JIFAuditoriaTiemposPendientes.1
            public void mouseClicked(MouseEvent evt) {
                JIFAuditoriaTiemposPendientes.this.JTResultadoMouseClicked(evt);
            }
        });
        this.JTResultado.addKeyListener(new KeyAdapter() { // from class: Inventarios.JIFAuditoriaTiemposPendientes.2
            public void keyReleased(KeyEvent evt) {
                JIFAuditoriaTiemposPendientes.this.JTResultadoKeyReleased(evt);
            }
        });
        this.JSPDetalleResultado.setViewportView(this.JTResultado);
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JSPDetalleResultado, GroupLayout.Alignment.LEADING).addComponent(this.JPIDatosC, GroupLayout.Alignment.LEADING, -2, 933, 32767)).addContainerGap(-1, 32767)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatosC, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalleResultado).addContainerGap()));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 991, 32767).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, -1, -2).addContainerGap(16, 32767))));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 645, 32767).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, -1, -2).addContainerGap(52, 32767))));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTResultadoMouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTResultadoKeyReleased(KeyEvent evt) {
        if (evt.getKeyCode() == 10 && this.JTResultado.getSelectedRow() != -1) {
            int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de actualizar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                String xsql = "update i_faltantes set Fecha_Llamada='" + this.xmodelotabla.getValueAt(this.JTResultado.getSelectedRow(), 2) + "' where Id='" + this.xmodelotabla.getValueAt(this.JTResultado.getSelectedRow(), 0) + "'";
                this.xconsultas.ejecutarSQL(xsql);
                this.xconsultas.cerrarConexionBd();
                mCargarDatosTabla();
            }
        }
    }

    public void mBuscar() {
        mCrearTablaDetalle();
        mCargarDatosTabla();
    }

    private void mCrearTablaDetalle() {
        this.xmodelotabla = new DefaultTableModel((Object[][]) null, new String[]{"Id", "Fecha Despacho", "Fecha Llamada", "Diferencia", ""}) { // from class: Inventarios.JIFAuditoriaTiemposPendientes.3
            Class[] types = {Long.class, String.class, String.class, Long.class, String.class};
            boolean[] canEdit = {false, false, true, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return this.canEdit[colIndex];
            }
        };
        this.JTResultado.setModel(this.xmodelotabla);
        this.JTResultado.getColumnModel().getColumn(0).setPreferredWidth(5);
        this.JTResultado.getColumnModel().getColumn(1).setPreferredWidth(50);
        this.JTResultado.getColumnModel().getColumn(2).setPreferredWidth(50);
        this.JTResultado.getColumnModel().getColumn(3).setPreferredWidth(50);
        this.JTResultado.getColumnModel().getColumn(4).setPreferredWidth(0);
        this.JTResultado.getColumnModel().getColumn(4).setMinWidth(0);
        this.JTResultado.getColumnModel().getColumn(4).setMaxWidth(0);
    }

    private void mCargarDatosTabla() {
        String sql = "SELECT i_faltantes.Id, i_salidas.FechaSalida, IF(i_faltantes.Fecha_Llamada IS NULL,'NO REGISTRA',  i_faltantes.Fecha_Llamada) AS FechaLLamada, DATEDIFF(DATE(IF(i_faltantes.Fecha_Llamada IS NULL, NOW(), i_faltantes.Fecha_Llamada)),i_salidas.FechaSalida) AS Dif, DATE(IF(i_faltantes.Fecha_Llamada IS NULL, NOW(), i_faltantes.Fecha_Llamada)) AS FechaN FROM i_faltantes INNER JOIN i_salidas  ON (i_faltantes.IdSalida = i_salidas.Id) WHERE (i_salidas.FechaSalida >='" + this.xmetodos.formatoAMD.format(this.JDCFechaI.getDate()) + "' AND i_salidas.FechaSalida <='" + this.xmetodos.formatoAMD.format(this.JDCFechaF.getDate()) + "' AND i_faltantes.Estado =0) ";
        ResultSet rs = this.xconsultas.traerRs(sql);
        try {
            if (rs.next()) {
                this.JTFFNPendientes.setValue(new Integer(0));
                this.JTFFNTDias.setValue(new Integer(0));
                this.JTFFNPromedio.setValue(new Integer(0));
                rs.beforeFirst();
                int xn = 0;
                int xnt = 0;
                int xtotaldias = 0;
                while (rs.next()) {
                    this.xmodelotabla.addRow((Object[]) null);
                    this.xmodelotabla.setValueAt(Long.valueOf(rs.getLong(1)), xn, 0);
                    this.xmodelotabla.setValueAt(rs.getString(2), xn, 1);
                    this.xmodelotabla.setValueAt(rs.getString(3), xn, 2);
                    this.xmodelotabla.setValueAt(Long.valueOf(rs.getLong(4)), xn, 3);
                    xtotaldias += rs.getInt(4);
                    if (rs.getInt(4) > 2) {
                        this.xmodelotabla.setValueAt("1", xn, 4);
                        this.JTResultado.setDefaultRenderer(Object.class, new MiRender());
                    } else {
                        this.xmodelotabla.setValueAt("0", xn, 4);
                        this.JTResultado.setDefaultRenderer(Object.class, new MiRender());
                    }
                    xn++;
                    xnt++;
                }
                this.JTFFNPendientes.setValue(Integer.valueOf(xnt));
                this.JTFFNTDias.setValue(Integer.valueOf(xtotaldias));
                this.JTFFNPromedio.setValue(Integer.valueOf(xtotaldias / xnt));
            } else {
                this.JTFFNPendientes.setValue(new Integer(0));
                this.JTFFNTDias.setValue(new Integer(0));
                this.JTFFNPromedio.setValue(new Integer(0));
            }
            rs.close();
            this.xconsultas.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFAuditoriaTiemposPendientes.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX INFO: loaded from: GenomaP.jar:Inventarios/JIFAuditoriaTiemposPendientes$MiRender.class */
    public static class MiRender extends DefaultTableCellRenderer {
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            String trabajador = table.getValueAt(row, 4).toString();
            if (trabajador != null && trabajador.equals("1")) {
                cell.setBackground(new Color(177, 251, 177));
            } else {
                cell.setBackground(Color.WHITE);
            }
            return cell;
        }
    }
}
