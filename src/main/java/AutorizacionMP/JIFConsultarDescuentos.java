package AutorizacionMP;

import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

/* JADX INFO: loaded from: GenomaP.jar:AutorizacionMP/JIFConsultarDescuentos.class */
public class JIFConsultarDescuentos extends JInternalFrame {
    private DefaultTableModel xmodelotabla;
    private ButtonGroup JBGSoporte;
    public JDateChooser JDCFechaF;
    public JDateChooser JDCFechaI;
    private JPanel JPIDatos;
    private JPanel JPITipoGeneracion;
    private JRadioButton JRBConSoporte;
    private JRadioButton JRBSinSoporte;
    private JScrollPane JSPDetalleConsulta;
    private JTable JTDEtalle;
    private JFormattedTextField JTFFNHistoria;
    private JTextField JTFFNPersonaAplica;
    private boolean xguardado = false;
    private boolean xtipos = true;
    private ConsultasMySQL xconsultas = new ConsultasMySQL();
    private Metodos xmetodos = new Metodos();

    public JIFConsultarDescuentos() {
        initComponents();
        this.JDCFechaI.setDate(this.xmetodos.getFechaActual());
        this.JDCFechaF.setDate(this.xmetodos.getFechaActual());
        mCrearTablaDetalle();
    }

    /* JADX WARN: Type inference failed for: r3v54, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGSoporte = new ButtonGroup();
        this.JPIDatos = new JPanel();
        this.JTFFNHistoria = new JFormattedTextField();
        this.JDCFechaI = new JDateChooser();
        this.JDCFechaF = new JDateChooser();
        this.JPITipoGeneracion = new JPanel();
        this.JRBSinSoporte = new JRadioButton();
        this.JRBConSoporte = new JRadioButton();
        this.JTFFNPersonaAplica = new JTextField();
        this.JSPDetalleConsulta = new JScrollPane();
        this.JTDEtalle = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("CONSULTAR DESCUENTOS");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifconsultardescuentos");
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTFFNHistoria.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Documento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFNHistoria.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0"))));
        this.JTFFNHistoria.setHorizontalAlignment(4);
        this.JTFFNHistoria.setFont(new Font("Arial", 1, 12));
        this.JTFFNHistoria.addActionListener(new ActionListener() { // from class: AutorizacionMP.JIFConsultarDescuentos.1
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarDescuentos.this.JTFFNHistoriaActionPerformed(evt);
            }
        });
        this.JTFFNHistoria.addFocusListener(new FocusAdapter() { // from class: AutorizacionMP.JIFConsultarDescuentos.2
            public void focusLost(FocusEvent evt) {
                JIFConsultarDescuentos.this.JTFFNHistoriaFocusLost(evt);
            }
        });
        this.JDCFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicial", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDCFechaI.setFont(new Font("Arial", 1, 12));
        this.JDCFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Final", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDCFechaF.setFont(new Font("Arial", 1, 12));
        this.JPITipoGeneracion.setBorder(BorderFactory.createTitledBorder((Border) null, "Soporte?", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBGSoporte.add(this.JRBSinSoporte);
        this.JRBSinSoporte.setFont(new Font("Arial", 1, 12));
        this.JRBSinSoporte.setSelected(true);
        this.JRBSinSoporte.setText("Si");
        this.JRBSinSoporte.addActionListener(new ActionListener() { // from class: AutorizacionMP.JIFConsultarDescuentos.3
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarDescuentos.this.JRBSinSoporteActionPerformed(evt);
            }
        });
        this.JBGSoporte.add(this.JRBConSoporte);
        this.JRBConSoporte.setFont(new Font("Arial", 1, 12));
        this.JRBConSoporte.setText("No");
        this.JRBConSoporte.addActionListener(new ActionListener() { // from class: AutorizacionMP.JIFConsultarDescuentos.4
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarDescuentos.this.JRBConSoporteActionPerformed(evt);
            }
        });
        GroupLayout JPITipoGeneracionLayout = new GroupLayout(this.JPITipoGeneracion);
        this.JPITipoGeneracion.setLayout(JPITipoGeneracionLayout);
        JPITipoGeneracionLayout.setHorizontalGroup(JPITipoGeneracionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPITipoGeneracionLayout.createSequentialGroup().addContainerGap().addComponent(this.JRBSinSoporte).addGap(18, 18, 18).addComponent(this.JRBConSoporte).addContainerGap(-1, 32767)));
        JPITipoGeneracionLayout.setVerticalGroup(JPITipoGeneracionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPITipoGeneracionLayout.createSequentialGroup().addContainerGap(-1, 32767).addGroup(JPITipoGeneracionLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBSinSoporte).addComponent(this.JRBConSoporte))));
        this.JTFFNPersonaAplica.setFont(new Font("Arial", 1, 12));
        this.JTFFNPersonaAplica.setBorder(BorderFactory.createTitledBorder((Border) null, "Persona que Aplica el Descuento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addComponent(this.JDCFechaI, -2, 136, -2).addGap(18, 18, 18).addComponent(this.JDCFechaF, -2, 136, -2).addGap(18, 18, 18).addComponent(this.JPITipoGeneracion, -2, -1, -2).addGap(18, 18, 18).addComponent(this.JTFFNHistoria, -2, 113, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFFNPersonaAplica, -1, 405, 32767).addContainerGap()));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JDCFechaI, -2, 65, -2).addComponent(this.JDCFechaF, -2, 65, -2)).addGroup(JPIDatosLayout.createSequentialGroup().addGap(2, 2, 2).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFNHistoria, -2, 63, -2).addComponent(this.JTFFNPersonaAplica)).addComponent(this.JPITipoGeneracion, -2, -1, -2)))).addContainerGap(27, 32767)));
        this.JSPDetalleConsulta.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JSPDetalleConsulta.setFont(new Font("Arial", 1, 12));
        this.JTDEtalle.setFont(new Font("Arial", 1, 12));
        this.JTDEtalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDEtalle.setRowHeight(25);
        this.JTDEtalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDEtalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTDEtalle.setSelectionMode(0);
        this.JTDEtalle.addMouseListener(new MouseAdapter() { // from class: AutorizacionMP.JIFConsultarDescuentos.5
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarDescuentos.this.JTDEtalleMouseClicked(evt);
            }
        });
        this.JSPDetalleConsulta.setViewportView(this.JTDEtalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JSPDetalleConsulta, GroupLayout.Alignment.LEADING, -1, 1014, 32767).addComponent(this.JPIDatos, GroupLayout.Alignment.LEADING, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalleConsulta, -1, 439, 32767).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBSinSoporteActionPerformed(ActionEvent evt) {
        this.xtipos = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBConSoporteActionPerformed(ActionEvent evt) {
        this.xtipos = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFNHistoriaActionPerformed(ActionEvent evt) {
        mBuscarPersona();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFNHistoriaFocusLost(FocusEvent evt) {
        mBuscarPersona();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDEtalleMouseClicked(MouseEvent evt) {
        if (this.JTDEtalle.getSelectedRow() != -1 && this.JTDEtalle.getSelectedColumn() == 0 && this.xtipos) {
            this.xmetodos.mostrarPdf(this.xmodelotabla.getValueAt(this.JTDEtalle.getSelectedRow(), 10).toString());
        }
    }

    private void mBuscarPersona() {
        if (!this.JTFFNHistoria.getText().isEmpty()) {
            try {
                String sql = "SELECT NUsuario FROM baseserver.persona WHERE (NoDocumento ='" + this.JTFFNHistoria.getText() + "') ";
                ConsultasMySQL xt2 = new ConsultasMySQL();
                ResultSet xrs = xt2.traerRs(sql);
                if (xrs.next()) {
                    xrs.first();
                    this.JTFFNPersonaAplica.setText(xrs.getString(1));
                }
                xrs.close();
                xt2.cerrarConexionBd();
            } catch (SQLException e) {
            }
        }
    }

    public void buscar() {
        if (!this.JTFFNHistoria.getText().isEmpty()) {
            if (!this.JTFFNPersonaAplica.getText().isEmpty()) {
                mCrearTablaDetalle();
                mCargarDatos();
                return;
            } else {
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un usuario", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                this.JTFFNHistoria.requestFocus();
                return;
            }
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un usuario", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
        this.JTFFNHistoria.requestFocus();
    }

    public void nuevo() {
        this.JDCFechaI.setDate(this.xmetodos.getFechaActual());
        this.JDCFechaF.setDate(this.xmetodos.getFechaActual());
        this.JTFFNHistoria.setText((String) null);
        this.JTFFNPersonaAplica.setText((String) null);
        mCrearTablaDetalle();
        this.JTFFNHistoria.requestFocus();
    }

    private void mCrearTablaDetalle() {
        this.xmodelotabla = new DefaultTableModel();
        this.xmodelotabla.addColumn("Id");
        this.xmodelotabla.addColumn("Fecha");
        this.xmodelotabla.addColumn("Usuario Formula");
        this.xmodelotabla.addColumn("Municipio");
        this.xmodelotabla.addColumn("Profesional");
        this.xmodelotabla.addColumn("NQ");
        this.xmodelotabla.addColumn("Valor");
        this.xmodelotabla.addColumn("IR");
        this.xmodelotabla.addColumn("FechaI");
        this.xmodelotabla.addColumn("FechaF");
        this.xmodelotabla.addColumn("");
        this.JTDEtalle.setModel(this.xmodelotabla);
        this.JTDEtalle.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTDEtalle.getColumnModel().getColumn(1).setPreferredWidth(40);
        this.JTDEtalle.getColumnModel().getColumn(2).setPreferredWidth(150);
        this.JTDEtalle.getColumnModel().getColumn(3).setPreferredWidth(70);
        this.JTDEtalle.getColumnModel().getColumn(4).setPreferredWidth(150);
        this.JTDEtalle.getColumnModel().getColumn(5).setPreferredWidth(15);
        this.JTDEtalle.getColumnModel().getColumn(6).setPreferredWidth(30);
        this.JTDEtalle.getColumnModel().getColumn(7).setPreferredWidth(5);
        this.JTDEtalle.getColumnModel().getColumn(8).setPreferredWidth(40);
        this.JTDEtalle.getColumnModel().getColumn(9).setPreferredWidth(40);
        this.JTDEtalle.getColumnModel().getColumn(10).setPreferredWidth(0);
        this.JTDEtalle.getColumnModel().getColumn(10).setMinWidth(0);
        this.JTDEtalle.getColumnModel().getColumn(10).setMaxWidth(0);
    }

    private void mCargarDatos() {
        String sql;
        SimpleDateFormat xffechan = new SimpleDateFormat("yyyy/MM/dd");
        if (this.xtipos) {
            sql = "SELECT d_descuento.Id, DATE_FORMAT(h_atencion.Fecha_Atencion, '%d-%m-%Y') AS fecha, CONCAT(g_persona.Nombre1,' ', g_persona.Nombre2,' ', g_persona.Apellido1,' ', g_persona.Apellido2) AS PFormula , g_municipio.Nbre AS Municipio, profesional.NProfesional, d_descuento.NQuincenas, d_descuento.Valor, persona.NUsuario AS Pdescuento, persona.NoDocumento,  d_descuento.Id_RelacionC,  d_descuento.Url FROM baseserver.d_descuento INNER JOIN baseserver.h_atencion  ON (d_descuento.Id_HAtencion = h_atencion.Id) INNER JOIN baseserver.ingreso  ON (h_atencion.Id_Ingreso = ingreso.Id) INNER JOIN baseserver.g_usuario  ON (ingreso.Id_Usuario = g_usuario.Id_persona) INNER JOIN baseserver.profesional  ON (profesional.Id_Persona = h_atencion.Id_Profesional) INNER JOIN baseserver.h_ordenes  ON (h_ordenes.Id_Atencion = h_atencion.Id) INNER JOIN baseserver.g_municipio  ON (g_municipio.Id = h_ordenes.IdMunicipio) INNER JOIN baseserver.g_usuario_fpz  ON (g_usuario.Id_persona = g_usuario_fpz.Id_Persona) INNER JOIN baseserver.persona  ON (g_usuario_fpz.Id_PersDescuento = persona.Id_persona) INNER JOIN baseserver.g_persona  ON (g_usuario.Id_persona = g_persona.Id) WHERE (ingreso.FechaIngreso >='" + xffechan.format(this.JDCFechaI.getDate()) + "'  AND ingreso.FechaIngreso <='" + xffechan.format(this.JDCFechaF.getDate()) + "' AND d_descuento.Url <>''  AND d_descuento.Estado =0 AND persona.NoDocumento ='" + this.JTFFNHistoria.getText() + "')GROUP BY d_descuento.Id ORDER BY ingreso.FechaIngreso DESC ";
        } else {
            sql = "SELECT d_descuento.Id, DATE_FORMAT(h_atencion.Fecha_Atencion, '%d-%m-%Y') AS fecha, CONCAT(g_persona.Nombre1,' ', g_persona.Nombre2,' ', g_persona.Apellido1,' ', g_persona.Apellido2) AS PFormula , g_municipio.Nbre AS Municipio, profesional.NProfesional, d_descuento.NQuincenas, d_descuento.Valor, persona.NUsuario AS Pdescuento, persona.NoDocumento,  d_descuento.Id_RelacionC,  d_descuento.Url FROM baseserver.d_descuento INNER JOIN baseserver.h_atencion  ON (d_descuento.Id_HAtencion = h_atencion.Id) INNER JOIN baseserver.ingreso  ON (h_atencion.Id_Ingreso = ingreso.Id) INNER JOIN baseserver.g_usuario  ON (ingreso.Id_Usuario = g_usuario.Id_persona) INNER JOIN baseserver.profesional  ON (profesional.Id_Persona = h_atencion.Id_Profesional) INNER JOIN baseserver.h_ordenes  ON (h_ordenes.Id_Atencion = h_atencion.Id) INNER JOIN baseserver.g_municipio  ON (g_municipio.Id = h_ordenes.IdMunicipio) INNER JOIN baseserver.g_usuario_fpz  ON (g_usuario.Id_persona = g_usuario_fpz.Id_Persona) INNER JOIN baseserver.persona  ON (g_usuario_fpz.Id_PersDescuento = persona.Id_persona) INNER JOIN baseserver.g_persona  ON (g_usuario.Id_persona = g_persona.Id) WHERE (ingreso.FechaIngreso >='" + xffechan.format(this.JDCFechaI.getDate()) + "'  AND ingreso.FechaIngreso <='" + xffechan.format(this.JDCFechaF.getDate()) + "' AND d_descuento.Url  ='' AND d_descuento.Estado =0 AND persona.NoDocumento ='" + this.JTFFNHistoria.getText() + "')GROUP BY d_descuento.Id ORDER BY ingreso.FechaIngreso DESC ";
        }
        ConsultasMySQL xt1 = new ConsultasMySQL();
        ResultSet rs = xt1.traerRs(sql);
        try {
            if (rs.next()) {
                rs.beforeFirst();
                int m = 0;
                while (rs.next()) {
                    this.xmodelotabla.addRow((Object[]) null);
                    this.xmodelotabla.setValueAt(rs.getString(1), m, 0);
                    this.xmodelotabla.setValueAt(rs.getString(2), m, 1);
                    this.xmodelotabla.setValueAt(rs.getString(3), m, 2);
                    this.xmodelotabla.setValueAt(rs.getString(4), m, 3);
                    this.xmodelotabla.setValueAt(rs.getString(5), m, 4);
                    this.xmodelotabla.setValueAt(rs.getString(6), m, 5);
                    this.xmodelotabla.setValueAt(rs.getString(7), m, 6);
                    this.xmodelotabla.setValueAt(rs.getString(10), m, 7);
                    if (rs.getInt(10) != 0) {
                        ConsultasMySQL xt2 = new ConsultasMySQL();
                        String xsql = "SELECT DATE_FORMAT(FechaI,'%d-%m-%Y') as fechai, DATE_FORMAT(FechaF,'%d-%m-%Y') as fechaf FROM baseserver.d_relacion WHERE (Id ='" + rs.getInt(10) + "' AND Estado =0) ";
                        ResultSet xrs = xt2.traerRs(xsql);
                        if (xrs.next()) {
                            xrs.first();
                            this.xmodelotabla.setValueAt(xrs.getString(1), m, 8);
                            this.xmodelotabla.setValueAt(xrs.getString(2), m, 9);
                        }
                        xrs.close();
                        xt2.cerrarConexionBd();
                    }
                    this.xmodelotabla.setValueAt(this.xmetodos.mTraerUrlBD(rs.getString(11)), m, 10);
                    m++;
                }
            } else {
                mCrearTablaDetalle();
            }
            rs.close();
            xt1.cerrarConexionBd();
        } catch (SQLException e) {
        }
    }
}
