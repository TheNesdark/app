package ImagenesDx;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:ImagenesDx/JIFConsultarOrdenesHc.class */
public class JIFConsultarOrdenesHc extends JInternalFrame {
    private int xfiltro = 0;
    private Metodos xmetodos = new Metodos();
    private ConsultasMySQL xconsultas = new ConsultasMySQL();
    private DefaultTableModel xmodelo;
    private String[] xidtiposervicio;
    private Object[] dato;
    public JIFSeguimientoOrdenes xjifseguimientoord;
    private ButtonGroup JBGFiltro1;
    private JComboBox JCBTipoServicio;
    public JDateChooser JDFechaF;
    public JDateChooser JDFechaI;
    private JPanel JPIDatos;
    private JScrollPane JSPResultado;
    private JTable JTBResultado;

    public JIFConsultarOrdenesHc() {
        initComponents();
        this.xidtiposervicio = this.xconsultas.llenarCombo("SELECT Id, Nbre FROM f_tiposervicio WHERE (Id =3 AND Estado =0 AND EsConsulta <>1) ORDER BY Nbre ASC", this.xidtiposervicio, this.JCBTipoServicio);
        this.xconsultas.cerrarConexionBd();
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v7, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGFiltro1 = new ButtonGroup();
        this.JSPResultado = new JScrollPane();
        this.JTBResultado = new JTable();
        this.JPIDatos = new JPanel();
        this.JDFechaI = new JDateChooser();
        this.JDFechaF = new JDateChooser();
        this.JCBTipoServicio = new JComboBox();
        setClosable(true);
        setIconifiable(true);
        setTitle("CONSULTAR ORDENES HISTORIA CLINICA");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifconsultarordeneshc");
        this.JSPResultado.setBorder(BorderFactory.createTitledBorder((Border) null, "RESULTADO", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JSPResultado.setVerticalScrollBarPolicy(22);
        this.JSPResultado.setAutoscrolls(true);
        this.JSPResultado.setEnabled(false);
        this.JSPResultado.setFont(new Font("Arial", 1, 12));
        this.JTBResultado.setFont(new Font("Arial", 1, 12));
        this.JTBResultado.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTBResultado.setAutoResizeMode(4);
        this.JTBResultado.setGridColor(UIManager.getDefaults().getColor("Menu.selectionBackground"));
        this.JTBResultado.setRowHeight(25);
        this.JTBResultado.setSelectionBackground(new Color(255, 255, 255));
        this.JTBResultado.setSelectionForeground(new Color(255, 0, 0));
        this.JTBResultado.setSelectionMode(0);
        this.JTBResultado.addMouseListener(new MouseAdapter() { // from class: ImagenesDx.JIFConsultarOrdenesHc.1
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarOrdenesHc.this.JTBResultadoMouseClicked(evt);
            }
        });
        this.JSPResultado.setViewportView(this.JTBResultado);
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS PARA CONSULTA", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JDFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicial", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFechaI.setFont(new Font("Arial", 1, 12));
        this.JDFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Final", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFechaF.setFont(new Font("Arial", 1, 12));
        this.JCBTipoServicio.setFont(new Font("Arial", 1, 12));
        this.JCBTipoServicio.setBorder(BorderFactory.createTitledBorder((Border) null, "Servicio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addComponent(this.JDFechaI, -2, 143, -2).addGap(18, 18, 18).addComponent(this.JDFechaF, -2, 143, -2).addGap(18, 18, 18).addComponent(this.JCBTipoServicio, 0, 370, 32767).addGap(403, 403, 403)));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addGroup(GroupLayout.Alignment.LEADING, JPIDatosLayout.createSequentialGroup().addContainerGap().addComponent(this.JCBTipoServicio)).addComponent(this.JDFechaF, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.JDFechaI, GroupLayout.Alignment.LEADING, -2, 64, -2)).addContainerGap(-1, 32767)));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -1, -1, 32767).addContainerGap()).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JSPResultado, -1, 1117, 32767).addContainerGap())));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addContainerGap(558, 32767)).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap(151, 32767).addComponent(this.JSPResultado, -2, 508, -2).addContainerGap())));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBResultadoMouseClicked(MouseEvent evt) {
        if (this.JTBResultado.getSelectedRow() != -1) {
            Principal.txtNo.setText(this.xmodelo.getValueAt(this.JTBResultado.getSelectedRow(), 0).toString());
            Object[] botones = {"Vista Previa", "Seguimiento", "Cerrar"};
            int n = JOptionPane.showInternalOptionDialog(this, "Que desea hacer", "REALIZAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), botones, "Cerrar");
            if (n == 0) {
                mImprimirOrden();
            } else if (n == 1) {
                this.xjifseguimientoord = new JIFSeguimientoOrdenes();
                Principal.cargarPantalla(this.xjifseguimientoord);
            }
        }
    }

    private void mNuevo() {
        this.JDFechaI.setDate(this.xmetodos.getFechaActual());
        this.JDFechaF.setDate(this.xmetodos.getFechaActual());
        mCrearTabla();
        this.JCBTipoServicio.setSelectedIndex(0);
        this.xfiltro = 0;
    }

    public void mBuscar() {
        if (this.JCBTipoServicio.getSelectedIndex() != -1) {
            mCargarDatos();
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTabla() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Fecha", "N° HC", "Nombre", "Sexo", "Edad", "Teléfono", "Estudio", "Realizado?", "Especialidad", "Profesional"}) { // from class: ImagenesDx.JIFConsultarOrdenesHc.2
            Class[] types = {Long.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Boolean.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, true, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTBResultado.setModel(this.xmodelo);
        this.JTBResultado.getColumnModel().getColumn(0).setPreferredWidth(20);
        this.JTBResultado.getColumnModel().getColumn(1).setPreferredWidth(30);
        this.JTBResultado.getColumnModel().getColumn(2).setPreferredWidth(30);
        this.JTBResultado.getColumnModel().getColumn(3).setPreferredWidth(150);
        this.JTBResultado.getColumnModel().getColumn(4).setPreferredWidth(20);
        this.JTBResultado.getColumnModel().getColumn(5).setPreferredWidth(10);
        this.JTBResultado.getColumnModel().getColumn(6).setPreferredWidth(30);
        this.JTBResultado.getColumnModel().getColumn(7).setPreferredWidth(200);
        this.JTBResultado.getColumnModel().getColumn(8).setPreferredWidth(30);
        this.JTBResultado.getColumnModel().getColumn(9).setPreferredWidth(50);
        this.JTBResultado.getColumnModel().getColumn(10).setPreferredWidth(100);
    }

    private void mCargarDatos() {
        try {
            String sql = "SELECT h_ordenes.Id, h_ordenes.FechaOrden, persona.NoHistoria, persona.NUsuario, persona.IdSexo, persona.Edad, persona.NTipoEdad, persona.Telefono, g_procedimiento.Nbre, profesional1.Especialidad, profesional1.NProfesional FROM h_ordenes INNER JOIN h_atencion  ON (h_ordenes.Id_Atencion = h_atencion.Id) INNER JOIN ingreso  ON (h_atencion.Id_Ingreso = ingreso.Id) INNER JOIN persona  ON (ingreso.Id_Usuario = persona.Id_persona) INNER JOIN h_itemordenesproced ON (h_itemordenesproced.Id_HOrdenes = h_ordenes.Id) INNER JOIN g_procedimiento  ON (h_itemordenesproced.Id_Procedimiento = g_procedimiento.Id) INNER JOIN baseserver.profesional1 ON (profesional1.Id_Persona = h_ordenes.Id_Profesional) AND (profesional1.IdEspecialidad = h_ordenes.Id_Especialidad)WHERE (h_ordenes.FechaOrden >='" + this.xmetodos.formatoAMD.format(this.JDFechaI.getDate()) + "' AND h_ordenes.FechaOrden <='" + this.xmetodos.formatoAMD.format(this.JDFechaF.getDate()) + "' AND h_ordenes.Id_TipoServicio ='" + this.xidtiposervicio[this.JCBTipoServicio.getSelectedIndex()] + "' AND h_ordenes.Estado =0 and h_ordenes.EstaEntregada=1) ORDER BY h_ordenes.FechaOrden ASC, persona.NUsuario ASC ";
            ResultSet rs = this.xconsultas.traerRs(sql);
            if (rs.next()) {
                rs.beforeFirst();
                int filaGrid = 0;
                mCrearTabla();
                while (rs.next()) {
                    this.xmodelo.addRow(this.dato);
                    this.xmodelo.setValueAt(Long.valueOf(rs.getLong(1)), filaGrid, 0);
                    this.xmodelo.setValueAt(rs.getString(2), filaGrid, 1);
                    this.xmodelo.setValueAt(rs.getString(3), filaGrid, 2);
                    this.xmodelo.setValueAt(rs.getString(4), filaGrid, 3);
                    this.xmodelo.setValueAt(rs.getString(5), filaGrid, 4);
                    this.xmodelo.setValueAt(rs.getString(6) + " " + rs.getString(7), filaGrid, 5);
                    this.xmodelo.setValueAt(rs.getString(8), filaGrid, 6);
                    this.xmodelo.setValueAt(rs.getString(9), filaGrid, 7);
                    this.xmodelo.setValueAt(false, filaGrid, 8);
                    this.xmodelo.setValueAt(rs.getString(10), filaGrid, 9);
                    this.xmodelo.setValueAt(rs.getString(11), filaGrid, 10);
                    filaGrid++;
                }
            }
            rs.close();
            this.xconsultas.cerrarConexionBd();
        } catch (Exception ex) {
            Logger.getLogger(JIFConsultarOrdenesHc.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mImprimirOrden() {
        String sql = "SELECT h_atencion.Motivo_Atencion, h_ordenes.Id FROM baseserver.h_ordenes INNER JOIN baseserver.h_atencion ON (h_ordenes.Id_Atencion = h_atencion.Id) where h_ordenes.Id='" + this.xmodelo.getValueAt(this.JTBResultado.getSelectedRow(), 0) + "'";
        String nota = this.xconsultas.traerDato(sql);
        String[][] mparametros = new String[6][2];
        mparametros[0][0] = "idorden";
        mparametros[0][1] = this.xmodelo.getValueAt(this.JTBResultado.getSelectedRow(), 0).toString();
        mparametros[1][0] = "idservicio";
        mparametros[1][1] = this.xidtiposervicio[this.JCBTipoServicio.getSelectedIndex()];
        mparametros[2][0] = "nota";
        mparametros[2][1] = nota;
        mparametros[3][0] = "horario";
        mparametros[3][1] = "Horario de Atencion:\nLunes a Jueves:  6:30 A.M - 4:30 P.M\nViernes:  6:30 A.M - 1:00 P.M";
        mparametros[4][0] = "SUBREPORT_DIR";
        mparametros[4][1] = this.xmetodos.getSO() + this.xmetodos.getBarra() + "Reportes" + this.xmetodos.getBarra();
        mparametros[5][0] = "SUBREPORTFIRMA_DIR";
        mparametros[5][1] = this.xmetodos.getSO() + this.xmetodos.getBarra() + "Firmas" + this.xmetodos.getBarra();
        this.xmetodos.GenerarPDF(this.xmetodos.getRutaRep() + "RProcedimientosO", mparametros);
    }
}
