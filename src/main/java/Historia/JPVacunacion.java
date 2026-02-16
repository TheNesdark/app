package Historia;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Historia/JPVacunacion.class */
public class JPVacunacion extends JPanel {
    private DefaultTableModel xmodelo;
    private ConsultasMySQL xct = new ConsultasMySQL();
    private Metodos xmt = new Metodos();
    private int filaGrid;
    private Object[] dato;
    private ResultSet rs;
    private JTable JTDetalle;
    private JScrollPane jScrollPane1;
    public JDateChooser txtFecha;
    public JTextField txtVacunador;

    public JPVacunacion() {
        initComponents();
        cargarCarnet();
        this.txtVacunador.setText(Principal.usuarioSistemaDTO.getNombreUsuario());
        this.txtFecha.setDate(this.xmt.getFechaActual());
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCreaModelo() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Vacuna", "Edad", "Dosis", "Fecha", "Vacunador", "Aplicar?", "Observacion", "Paciente", "Esquema", "id"}) { // from class: Historia.JPVacunacion.1
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, Boolean.class, String.class, Integer.class, Integer.class, Integer.class};
            boolean[] canEdit = {false, false, false, false, false, false, true, true, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        JTable jTable = this.JTDetalle;
        JTable jTable2 = this.JTDetalle;
        jTable.setAutoResizeMode(0);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(250);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(70);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(60);
        this.JTDetalle.getColumnModel().getColumn(8).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(8).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(9).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(9).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(10).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(10).setMaxWidth(0);
    }

    public void mGrabar() {
        for (int x = 0; x < this.JTDetalle.getRowCount(); x++) {
            if (Boolean.valueOf(this.xmodelo.getValueAt(x, 6).toString()).booleanValue() && this.xmodelo.getValueAt(x, 4).toString().equals("")) {
                if (this.JTDetalle.isEditing()) {
                    this.JTDetalle.getCellEditor().stopCellEditing();
                }
                String sql = "UPDATE p_vacunacion_carnet SET FechaVacuna = '" + this.xmt.formatoAMD1.format(this.txtFecha.getDate()) + "', Vacunador = '" + this.txtVacunador.getText() + "', UsuarioS = '" + Principal.usuarioSistemaDTO.getLogin() + "', Fecha = now()  , Observacion = '" + this.xmodelo.getValueAt(x, 7).toString() + "'WHERE (IdEsquema ='" + this.xmodelo.getValueAt(x, 0) + "' AND IdPaciente = '" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "')";
                this.xct.ejecutarSQL(sql);
                this.xct.cerrarConexionBd();
            } else if (!Boolean.valueOf(this.xmodelo.getValueAt(x, 6).toString()).booleanValue() && !this.xmodelo.getValueAt(x, 4).toString().equals("")) {
                if (this.JTDetalle.isEditing()) {
                    this.JTDetalle.getCellEditor().stopCellEditing();
                }
                String sql2 = "UPDATE\n  `p_vacunacion_carnet`\nSET\n  `FechaVacuna` = '',\n  `Vacunador` = '',\n  `Observacion` = ''\nWHERE `id` = '" + this.xmodelo.getValueAt(x, 8) + "'\n  AND `IdEsquema` = '" + this.xmodelo.getValueAt(x, 0) + "'\n  AND `IdPaciente` = '" + this.xmodelo.getValueAt(x, 9) + "'";
                this.xct.ejecutarSQL(sql2);
                this.xct.cerrarConexionBd();
            }
        }
        cargarCarnet();
    }

    private void cargarCarnet() {
        String sql = "SELECT p_vacunacion_carnet.IdEsquema, p_vacunacion_vacunas.Nbre, p_vacunacion_dosis.Nbre, p_vacunacion_edad.Nbre, p_vacunacion_carnet.FechaVacuna, p_vacunacion_carnet.Vacunador , if(p_vacunacion_carnet.FechaVacuna='', false, true) aplicada, IFNULL(p_vacunacion_carnet.Observacion,'') AS Observacion,p_vacunacion_carnet.id, p_vacunacion_carnet.IdPaciente FROM p_vacunacion_esquema  INNER JOIN p_vacunacion_vacunas  ON (p_vacunacion_esquema.IdVacuna = p_vacunacion_vacunas.Id) INNER JOIN p_vacunacion_dosis  ON (p_vacunacion_esquema.IdDosis = p_vacunacion_dosis.Id) INNER JOIN p_vacunacion_edad  ON (p_vacunacion_esquema.IdEdad = p_vacunacion_edad.Id) INNER JOIN p_vacunacion_carnet  ON (p_vacunacion_carnet.IdEsquema = p_vacunacion_esquema.Id) WHERE (p_vacunacion_carnet.IdPaciente ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "') ORDER BY p_vacunacion_vacunas.Id ASC, p_vacunacion_dosis.Id ASC";
        this.rs = this.xct.traerRs(sql);
        mCreaModelo();
        try {
            if (this.rs.next()) {
                this.rs.beforeFirst();
                int x = 0;
                while (this.rs.next()) {
                    this.xmodelo.addRow(this.dato);
                    this.xmodelo.setValueAt(this.rs.getString(1), x, 0);
                    this.xmodelo.setValueAt(this.rs.getString(2), x, 1);
                    this.xmodelo.setValueAt(this.rs.getString(3), x, 2);
                    this.xmodelo.setValueAt(this.rs.getString(4), x, 3);
                    this.xmodelo.setValueAt(this.rs.getString(5), x, 4);
                    this.xmodelo.setValueAt(this.rs.getString(6), x, 5);
                    this.xmodelo.setValueAt(Boolean.valueOf(this.rs.getBoolean("aplicada")), x, 6);
                    this.xmodelo.setValueAt(this.rs.getString("Observacion"), x, 7);
                    this.xmodelo.setValueAt(this.rs.getString("id"), x, 8);
                    this.xmodelo.setValueAt(this.rs.getString("IdPaciente"), x, 9);
                    x++;
                }
            } else {
                ConsultasMySQL xct = new ConsultasMySQL();
                ResultSet xrs = xct.traerRs("SELECT Id, IdVacuna, IdDosis, IdEdad FROM  p_vacunacion_esquema");
                while (xrs.next()) {
                    crearEsquema(xrs.getString(1));
                }
                xrs.close();
                xct.cerrarConexionBd();
                cargarCarnet();
            }
            this.rs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            this.xct.mostrarErrorSQL(ex);
        }
    }

    private void crearEsquema(String esquema) {
        ConsultasMySQL xct = new ConsultasMySQL();
        String sql = "INSERT INTO p_vacunacion_carnet(IdEsquema, IdPaciente, Fecha, UsuarioS) VALUES('" + esquema + "','" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "','" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
        xct.ejecutarSQL(sql);
        xct.cerrarConexionBd();
    }

    /* JADX WARN: Type inference failed for: r3v2, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jScrollPane1 = new JScrollPane();
        this.JTDetalle = new JTable();
        this.txtFecha = new JDateChooser();
        this.txtVacunador = new JTextField();
        setName("xjp_vacunacion");
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalle.setSelectionMode(0);
        this.jScrollPane1.setViewportView(this.JTDetalle);
        this.txtFecha.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.txtFecha.setDateFormatString("dd/MM/yyyy");
        this.txtFecha.setFont(new Font("Arial", 1, 12));
        this.txtFecha.addPropertyChangeListener(new PropertyChangeListener() { // from class: Historia.JPVacunacion.2
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JPVacunacion.this.txtFechaPropertyChange(evt);
            }
        });
        this.txtVacunador.setFont(new Font("Arial", 1, 12));
        this.txtVacunador.setBorder(BorderFactory.createTitledBorder((Border) null, "Vacunador", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.txtVacunador.setFocusCycleRoot(true);
        this.txtVacunador.addMouseListener(new MouseAdapter() { // from class: Historia.JPVacunacion.3
            public void mouseClicked(MouseEvent evt) {
                JPVacunacion.this.txtVacunadorMouseClicked(evt);
            }
        });
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane1, -1, 769, 32767).addGroup(layout.createSequentialGroup().addComponent(this.txtFecha, -2, 131, -2).addGap(18, 18, 18).addComponent(this.txtVacunador, -2, 378, -2).addGap(0, 0, 0))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.txtVacunador, -2, 51, -2).addComponent(this.txtFecha, -2, 50, -2)).addGap(25, 25, 25).addComponent(this.jScrollPane1, -2, 413, -2).addContainerGap(-1, 32767)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtFechaPropertyChange(PropertyChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtVacunadorMouseClicked(MouseEvent evt) {
    }
}
