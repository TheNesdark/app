package Historia;

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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/* JADX INFO: loaded from: GenomaP.jar:Historia/JPAActividadesPyP.class */
public class JPAActividadesPyP extends JPanel {
    private DefaultTableModel xmodeloactividad;
    private Object[] dato;
    private clasesHistoriaCE xclase;
    private JScrollPane JSPDetalleHistorial;
    private JTable JTBDetalleHistorial;
    private TableColumn xcolumn = null;
    private ConsultasMySQL xconsultasbd = new ConsultasMySQL();
    private Metodos xmetodo = new Metodos();

    public JPAActividadesPyP(clasesHistoriaCE xclase) {
        initComponents();
        this.xclase = xclase;
        mCrearTablaActividad();
        mCargarDatosTablaActividad();
    }

    private void initComponents() {
        this.JSPDetalleHistorial = new JScrollPane();
        this.JTBDetalleHistorial = new JTable();
        setBorder(BorderFactory.createTitledBorder((Border) null, "ACTIVIDADES PYP", 2, 0, new Font("Arial", 1, 18), Color.blue));
        setName("jpconclusiones");
        this.JSPDetalleHistorial.setBorder(BorderFactory.createTitledBorder((Border) null, "Histórico", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JTBDetalleHistorial.setFont(new Font("Arial", 1, 12));
        this.JTBDetalleHistorial.setRowHeight(25);
        this.JTBDetalleHistorial.setSelectionBackground(new Color(255, 255, 255));
        this.JTBDetalleHistorial.setSelectionForeground(new Color(255, 0, 0));
        this.JTBDetalleHistorial.setSelectionMode(0);
        this.JTBDetalleHistorial.addMouseListener(new MouseAdapter() { // from class: Historia.JPAActividadesPyP.1
            public void mouseClicked(MouseEvent evt) {
                JPAActividadesPyP.this.JTBDetalleHistorialMouseClicked(evt);
            }
        });
        this.JSPDetalleHistorial.setViewportView(this.JTBDetalleHistorial);
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.JSPDetalleHistorial, -2, 822, -2).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.JSPDetalleHistorial, -1, 639, 32767).addContainerGap()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBDetalleHistorialMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            int ver = JOptionPane.showInternalConfirmDialog(this.xclase.xjifhistoriaclinica, "Desea visualizar la evidencia", "VISUALIZACIÓN", 0);
            if (ver == 0) {
                this.xmetodo.mostrarPdf(this.xmodeloactividad.getValueAt(this.JTBDetalleHistorial.getSelectedRow(), 4).toString());
            }
        }
    }

    private void mCrearTablaActividad() {
        this.xmodeloactividad = new DefaultTableModel((Object[][]) null, new String[]{"Nombre", "Fecha", "Hora", "Profesional", "Ruta"}) { // from class: Historia.JPAActividadesPyP.2
            Class[] types = {String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return this.canEdit[colIndex];
            }
        };
        this.JTBDetalleHistorial.setModel(this.xmodeloactividad);
        this.JTBDetalleHistorial.getColumnModel().getColumn(0).setPreferredWidth(400);
        this.JTBDetalleHistorial.getColumnModel().getColumn(1).setPreferredWidth(10);
        this.JTBDetalleHistorial.getColumnModel().getColumn(2).setPreferredWidth(10);
        this.JTBDetalleHistorial.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTBDetalleHistorial.getColumnModel().getColumn(4).setPreferredWidth(30);
    }

    private void mCargarDatosTablaActividad() {
        try {
            String sql = "SELECT p_actividades.Nbre, DATE_FORMAT(p_planeacionactividades.Fecha_Actividad, '%d/%m/%Y') AS FechaAct, p_planeacionactividades.Hora_Actividad, profesional.NProfesional, p_planeacionactividades.Registro  FROM p_planeacionactividades INNER JOIN p_actividades ON (p_planeacionactividades.Id_PActividad = p_actividades.Id)INNER JOIN profesional  ON (p_planeacionactividades.Id_Profesional = profesional.Id_Persona) INNER JOIN h_actividadespyp  ON (h_actividadespyp.Id_Actividad = p_planeacionactividades.Id) INNER JOIN persona  ON (persona.Id_persona = h_actividadespyp.Id_Usuario)  WHERE (persona.Id_persona ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "') ORDER BY p_planeacionactividades.Fecha_Actividad DESC, p_planeacionactividades.Hora_Actividad DESC";
            ResultSet rs = this.xconsultasbd.traerRs(sql);
            rs.next();
            if (rs.getRow() != 0) {
                rs.beforeFirst();
                int i = 0;
                while (rs.next()) {
                    this.xmodeloactividad.addRow(this.dato);
                    this.xmodeloactividad.setValueAt(rs.getString(1), i, 0);
                    this.xmodeloactividad.setValueAt(rs.getString(2), i, 1);
                    this.xmodeloactividad.setValueAt(rs.getString(3), i, 2);
                    this.xmodeloactividad.setValueAt(rs.getString(4), i, 3);
                    this.xmodeloactividad.setValueAt(rs.getString(5), i, 4);
                    i++;
                }
            }
            rs.close();
            this.xconsultasbd.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPAActividadesPyP.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }
}
