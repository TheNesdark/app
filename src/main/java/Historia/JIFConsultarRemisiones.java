package Historia;

import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyVetoException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/* JADX INFO: loaded from: GenomaP.jar:Historia/JIFConsultarRemisiones.class */
public class JIFConsultarRemisiones extends JInternalFrame {
    private Object[] dato;
    private ResultSet rs;
    private clasesHistoriaCE xclase;
    private int xtipo;
    private ButtonGroup JBGOpciones;
    private JButton JBTCerrar;
    private JPanel JPITipoConsulta;
    private JRadioButton JRBActivas;
    private JRadioButton JRBAnuladas;
    private JScrollPane JSPDetalleConsulta;
    private JTable JTBDetalle;
    private DefaultTableModel xmodelod = new DefaultTableModel();
    private TableColumn column = null;
    private int xestado = 0;
    private ConsultasMySQL xconsultasbd = new ConsultasMySQL();
    private Metodos xmetodo = new Metodos();

    public JIFConsultarRemisiones(clasesHistoriaCE xclase, int xtipo) {
        this.xtipo = 0;
        initComponents();
        this.xclase = xclase;
        this.xtipo = xtipo;
        setLocation((this.xmetodo.getAnchoPantalla() / 2) / 2, (this.xmetodo.getAltoPantalla() / 2) / 2);
        mCargarDatos();
    }

    private void initComponents() {
        this.JBGOpciones = new ButtonGroup();
        this.JSPDetalleConsulta = new JScrollPane();
        this.JTBDetalle = new JTable();
        this.JBTCerrar = new JButton();
        this.JPITipoConsulta = new JPanel();
        this.JRBActivas = new JRadioButton();
        this.JRBAnuladas = new JRadioButton();
        setClosable(true);
        setTitle("MODULO DE CONSULTA");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        this.JSPDetalleConsulta.setBorder(BorderFactory.createTitledBorder((Border) null, "REMISIONES", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTBDetalle.setFont(new Font("Arial", 1, 12));
        this.JTBDetalle.setRowHeight(25);
        this.JTBDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTBDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTBDetalle.setSelectionMode(0);
        this.JTBDetalle.addMouseListener(new MouseAdapter() { // from class: Historia.JIFConsultarRemisiones.1
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarRemisiones.this.JTBDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalleConsulta.setViewportView(this.JTBDetalle);
        this.JBTCerrar.setFont(new Font("Arial", 1, 12));
        this.JBTCerrar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.JBTCerrar.setText("Cerrar");
        this.JBTCerrar.addActionListener(new ActionListener() { // from class: Historia.JIFConsultarRemisiones.2
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarRemisiones.this.JBTCerrarActionPerformed(evt);
            }
        });
        this.JPITipoConsulta.setBorder(BorderFactory.createTitledBorder((Border) null, "TIPO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JBGOpciones.add(this.JRBActivas);
        this.JRBActivas.setFont(new Font("Arial", 1, 12));
        this.JRBActivas.setForeground(Color.blue);
        this.JRBActivas.setSelected(true);
        this.JRBActivas.setText("Activas");
        this.JRBActivas.addActionListener(new ActionListener() { // from class: Historia.JIFConsultarRemisiones.3
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarRemisiones.this.JRBActivasActionPerformed(evt);
            }
        });
        this.JBGOpciones.add(this.JRBAnuladas);
        this.JRBAnuladas.setFont(new Font("Arial", 1, 12));
        this.JRBAnuladas.setForeground(Color.blue);
        this.JRBAnuladas.setText("Anuladas");
        this.JRBAnuladas.addActionListener(new ActionListener() { // from class: Historia.JIFConsultarRemisiones.4
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarRemisiones.this.JRBAnuladasActionPerformed(evt);
            }
        });
        GroupLayout JPITipoConsultaLayout = new GroupLayout(this.JPITipoConsulta);
        this.JPITipoConsulta.setLayout(JPITipoConsultaLayout);
        JPITipoConsultaLayout.setHorizontalGroup(JPITipoConsultaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPITipoConsultaLayout.createSequentialGroup().addContainerGap().addComponent(this.JRBActivas).addGap(18, 18, 18).addComponent(this.JRBAnuladas).addContainerGap(-1, 32767)));
        JPITipoConsultaLayout.setVerticalGroup(JPITipoConsultaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPITipoConsultaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBActivas).addComponent(this.JRBAnuladas)));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.JBTCerrar, -2, 343, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 289, 32767).addComponent(this.JPITipoConsulta, -2, -1, -2)).addComponent(this.JSPDetalleConsulta, -1, 824, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JSPDetalleConsulta, -2, 346, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JPITipoConsulta, -2, -1, -2).addComponent(this.JBTCerrar, -2, 49, -2)).addContainerGap(18, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBDetalleMouseClicked(MouseEvent evt) {
        try {
            if (this.JTBDetalle.getSelectedRow() != -1) {
                this.xclase.xjifhistoriaclinica.xjpremisiones.mBuscarRemision(this.xmodelod.getValueAt(this.JTBDetalle.getSelectedRow(), 0).toString());
            }
            this.xclase.xjifhistoriaclinica.setSelected(true);
            dispose();
        } catch (PropertyVetoException e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTCerrarActionPerformed(ActionEvent evt) {
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBActivasActionPerformed(ActionEvent evt) {
        this.xestado = 0;
        mCargarDatos();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBAnuladasActionPerformed(ActionEvent evt) {
        this.xestado = 1;
        mCargarDatos();
    }

    private void mCrearTablaDetalle() {
        this.xmodelod = new DefaultTableModel();
        this.xmodelod.addColumn("N°");
        this.xmodelod.addColumn("Fecha");
        this.xmodelod.addColumn("Especialidad");
        this.xmodelod.addColumn("Es Prioritaria");
        this.xmodelod.addColumn("Detalle");
        this.JTBDetalle.setModel(this.xmodelod);
        this.column = this.JTBDetalle.getColumnModel().getColumn(0);
        this.column.setPreferredWidth(10);
        this.column = this.JTBDetalle.getColumnModel().getColumn(1);
        this.column.setPreferredWidth(80);
        this.column = this.JTBDetalle.getColumnModel().getColumn(2);
        this.column.setPreferredWidth(150);
        this.column = this.JTBDetalle.getColumnModel().getColumn(3);
        this.column.setPreferredWidth(30);
        this.column = this.JTBDetalle.getColumnModel().getColumn(4);
        this.column.setPreferredWidth(300);
    }

    private void mCargarDatos() {
        mCrearTablaDetalle();
        String sql = "SELECT h_remisiones.Id, DATE_FORMAT(h_remisiones.Fecha,'%d/%m%/%Y') as Fecha, DATE_FORMAT(h_atencion.Hora_Atencion,'%h:%i%:%s %p')  as Hora, h_remisiones.EsUrgente, g_especialidad.Nbre, h_remisiones.Detalle, h_remisiones.Estado FROM h_remisiones INNER JOIN h_atencion ON (h_remisiones.Id_Atencion = h_atencion.Id) INNER JOIN ingreso ON (h_atencion.Id_Ingreso = ingreso.Id) INNER JOIN g_especialidad ON (h_remisiones.I_Especialidad = g_especialidad.Id) WHERE (h_remisiones.Tipo='" + this.xtipo + "' and ingreso.Id_Usuario ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "' and h_remisiones.Estado='" + this.xestado + "') ORDER BY h_atencion.Fecha_Atencion DESC, h_atencion.Hora_Atencion ASC ";
        ResultSet rs1 = this.xconsultasbd.traerRs(sql);
        try {
            if (rs1.next()) {
                rs1.beforeFirst();
                int i = 0;
                while (rs1.next()) {
                    this.xmodelod.addRow(this.dato);
                    this.xmodelod.setValueAt(Long.valueOf(rs1.getLong(1)), i, 0);
                    this.xmodelod.setValueAt(rs1.getString(2), i, 1);
                    this.xmodelod.setValueAt(rs1.getString(5), i, 2);
                    if (rs1.getInt(4) == 1) {
                        this.xmodelod.setValueAt("No", i, 3);
                    } else {
                        this.xmodelod.setValueAt("Si", i, 3);
                    }
                    this.xmodelod.setValueAt(rs1.getString(6), i, 4);
                    i++;
                }
                this.xconsultasbd.cerrarConexionBd();
            }
            rs1.close();
            this.xconsultasbd.cerrarConexionBd();
        } catch (SQLException e) {
        }
    }
}
