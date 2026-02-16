package Facturacion;

import General.ClaseImpresionInformes;
import Historia.JIFRVisitasDomiciliarias;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Facturacion/JPNotasProcedimientos.class */
public class JPNotasProcedimientos extends JPanel {
    private ConsultasMySQL consultasbd = new ConsultasMySQL();
    private Metodos metodo = new Metodos();
    private DefaultTableModel modelo;
    private Long idIngreso;
    private Object[] datos;
    private JScrollPane JSPHistorico;
    private JTable JTDetalle;

    public JPNotasProcedimientos(Long idIngreso) {
        initComponents();
        this.idIngreso = idIngreso;
        mCargarDatosTabla();
    }

    /* JADX WARN: Type inference failed for: r3v3, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JSPHistorico = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JSPHistorico.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalle.setSelectionMode(0);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: Facturacion.JPNotasProcedimientos.1
            public void mouseClicked(MouseEvent evt) {
                JPNotasProcedimientos.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPHistorico.setViewportView(this.JTDetalle);
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JSPHistorico, -2, 910, -2).addContainerGap(-1, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JSPHistorico, -2, 313, -2).addContainerGap(22, 32767)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getRowCount() != -1 && evt.getClickCount() == 2) {
            ClaseImpresionInformes informes = new ClaseImpresionInformes();
            informes.imprimirNotas(this.JTDetalle.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.modelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Fecha", "Hora", "Tipo Nota", "Descripción", "Profesional", "Especialidad"}) { // from class: Facturacion.JPNotasProcedimientos.2
            Class[] types = {Long.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTDetalle;
        JTable jTable2 = this.JTDetalle;
        jTable.setAutoResizeMode(0);
        this.JTDetalle.doLayout();
        this.JTDetalle.setModel(this.modelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(200);
    }

    private void mCargarDatosTabla() {
        try {
            mCrearModeloDatos();
            String sql = "SELECT h_rvisitasdomiciliarias.Id, DATE_FORMAT(h_rvisitasdomiciliarias.FechaV,'%d-%m-%Y') AS Fecha, h_rvisitasdomiciliarias.HoraV, h_tiponota.Nbre , h_rvisitasdomiciliarias.Descripcion, profesional1.NProfesional, profesional1.Especialidad, h_rvisitasdomiciliarias.Id_Persona FROM h_rvisitasdomiciliarias INNER JOIN profesional1  ON (h_rvisitasdomiciliarias.Id_Profesional = profesional1.Id_Persona) AND (h_rvisitasdomiciliarias.Id_Especialidad = profesional1.IdEspecialidad) INNER JOIN h_tiponota  ON (h_rvisitasdomiciliarias.Id_TipoNota= h_tiponota.Id) WHERE (h_rvisitasdomiciliarias.Id_Ingreso =" + this.idIngreso + ")  ORDER BY h_rvisitasdomiciliarias.FechaV DESC, h_rvisitasdomiciliarias.HoraV DESC ";
            ResultSet xrs = this.consultasbd.traerRs(sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                this.metodo.mEstablecerTextEditor(this.JTDetalle, 4);
                this.metodo.mEstablecerTextEditor(this.JTDetalle, 5);
                this.metodo.mEstablecerTextEditor(this.JTDetalle, 6);
                while (xrs.next()) {
                    this.modelo.addRow(this.datos);
                    this.modelo.setValueAt(Long.valueOf(xrs.getLong(1)), n, 0);
                    this.modelo.setValueAt(xrs.getString(2), n, 1);
                    this.modelo.setValueAt(xrs.getString(3), n, 2);
                    this.modelo.setValueAt(xrs.getString(4), n, 3);
                    this.modelo.setValueAt(xrs.getString(5), n, 4);
                    this.modelo.setValueAt(xrs.getString(6), n, 5);
                    this.modelo.setValueAt(xrs.getString(7), n, 6);
                    n++;
                }
            }
            xrs.close();
            this.consultasbd.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFRVisitasDomiciliarias.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }
}
