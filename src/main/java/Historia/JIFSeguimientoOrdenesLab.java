package Historia;

import Acceso.Principal;
import Citas.BuscarCitas;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

/* JADX INFO: loaded from: GenomaP.jar:Historia/JIFSeguimientoOrdenesLab.class */
public class JIFSeguimientoOrdenesLab extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private Object[] xdato;
    private JIFConsultarResultadoExamenes xjifconsres;
    private String xobjetollamador;
    private ButtonGroup JBGCumple;
    private JDateChooser JDFFecha;
    private JDateChooser JDFFechaR;
    private JPanel JPIDatos;
    private JPanel JPIDatosR;
    private JScrollPane JSPDetalle;
    private JScrollPane JSPDseguimiento;
    private JScrollPane JSPObservacionC;
    private JScrollPane JSPOportunidadC;
    private JTextPane JTADSeguimiento;
    private JTextPane JTAObservacionC;
    private JTextPane JTAOportunidadC;
    private JTable JTDetalle;
    private JFormattedTextField JTFFIdSeguimiento;
    public JFormattedTextField JTFFNCita;
    private Metodos xmetodos = new Metodos();
    private ConsultasMySQL xconsultas = new ConsultasMySQL();
    private int xcumple = 0;
    private boolean xestado = false;

    public JIFSeguimientoOrdenesLab(String xnombre, JInternalFrame xjif) {
        initComponents();
        setName(xnombre);
        mRealizarCasting(xjif);
        mNuevo();
    }

    public JIFSeguimientoOrdenesLab(String xnombre) {
        initComponents();
        setName(xnombre);
        this.xobjetollamador = xnombre;
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v28, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGCumple = new ButtonGroup();
        this.JPIDatos = new JPanel();
        this.JDFFecha = new JDateChooser();
        this.JSPDseguimiento = new JScrollPane();
        this.JTADSeguimiento = new JTextPane();
        this.JTFFIdSeguimiento = new JFormattedTextField();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JPIDatosR = new JPanel();
        this.JDFFechaR = new JDateChooser();
        this.JSPOportunidadC = new JScrollPane();
        this.JTAOportunidadC = new JTextPane();
        this.JSPObservacionC = new JScrollPane();
        this.JTAObservacionC = new JTextPane();
        this.JTFFNCita = new JFormattedTextField();
        setClosable(true);
        setIconifiable(true);
        setTitle("SEGUIMIENTO EXÁMENES DE LABORATORIO");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifseguimientolab");
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "Dato Seguimiento", 0, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JDFFecha.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFecha.setDateFormatString("dd/MM/yyyy");
        this.JDFFecha.setFont(new Font("Arial", 1, 12));
        this.JSPDseguimiento.setBorder(BorderFactory.createTitledBorder((Border) null, "Descripción", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPDseguimiento.setFont(new Font("Arial", 1, 12));
        this.JTADSeguimiento.addKeyListener(new KeyAdapter() { // from class: Historia.JIFSeguimientoOrdenesLab.1
            public void keyPressed(KeyEvent evt) {
                JIFSeguimientoOrdenesLab.this.JTADSeguimientoKeyPressed(evt);
            }
        });
        this.JSPDseguimiento.setViewportView(this.JTADSeguimiento);
        this.JTFFIdSeguimiento.setEditable(false);
        this.JTFFIdSeguimiento.setBorder(BorderFactory.createTitledBorder((Border) null, "N°", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFIdSeguimiento.setHorizontalAlignment(4);
        this.JTFFIdSeguimiento.setFont(new Font("Arial", 1, 16));
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addComponent(this.JDFFecha, -2, 121, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDseguimiento, -1, 690, 32767).addGap(18, 18, 18).addComponent(this.JTFFIdSeguimiento, -2, 107, -2).addContainerGap()));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JTFFIdSeguimiento, GroupLayout.Alignment.LEADING).addComponent(this.JSPDseguimiento, GroupLayout.Alignment.LEADING, -1, 54, 32767).addComponent(this.JDFFecha, GroupLayout.Alignment.LEADING, -2, -1, -2)).addContainerGap(18, 32767)));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "Detalle", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setBorder(BorderFactory.createBevelBorder(0));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalle.setEditingColumn(1);
        this.JTDetalle.setEditingRow(1);
        this.JTDetalle.setGridColor(new Color(204, 255, 204));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalle.setSelectionMode(0);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: Historia.JIFSeguimientoOrdenesLab.2
            public void mouseClicked(MouseEvent evt) {
                JIFSeguimientoOrdenesLab.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.JPIDatosR.setBorder(BorderFactory.createTitledBorder((Border) null, "Datos Recepción", 0, 0, new Font("Arial", 1, 14), Color.red));
        this.JDFFechaR.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFechaR.setDateFormatString("dd-MM-yyyy");
        this.JDFFechaR.setFont(new Font("Arial", 2, 12));
        this.JSPOportunidadC.setBorder(BorderFactory.createTitledBorder((Border) null, "Oportunidad", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTAOportunidadC.setFont(new Font("Arial", 1, 12));
        this.JTAOportunidadC.addKeyListener(new KeyAdapter() { // from class: Historia.JIFSeguimientoOrdenesLab.3
            public void keyPressed(KeyEvent evt) {
                JIFSeguimientoOrdenesLab.this.JTAOportunidadCKeyPressed(evt);
            }
        });
        this.JSPOportunidadC.setViewportView(this.JTAOportunidadC);
        this.JSPObservacionC.setBorder(BorderFactory.createTitledBorder((Border) null, "Descripción", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTAObservacionC.setFont(new Font("Arial", 1, 12));
        this.JTAObservacionC.addKeyListener(new KeyAdapter() { // from class: Historia.JIFSeguimientoOrdenesLab.4
            public void keyPressed(KeyEvent evt) {
                JIFSeguimientoOrdenesLab.this.JTAObservacionCKeyPressed(evt);
            }
        });
        this.JSPObservacionC.setViewportView(this.JTAObservacionC);
        this.JTFFNCita.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Cita", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFNCita.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0"))));
        this.JTFFNCita.setHorizontalAlignment(4);
        this.JTFFNCita.setFont(new Font("Arial", 1, 16));
        this.JTFFNCita.addMouseListener(new MouseAdapter() { // from class: Historia.JIFSeguimientoOrdenesLab.5
            public void mouseClicked(MouseEvent evt) {
                JIFSeguimientoOrdenesLab.this.JTFFNCitaMouseClicked(evt);
            }
        });
        GroupLayout JPIDatosRLayout = new GroupLayout(this.JPIDatosR);
        this.JPIDatosR.setLayout(JPIDatosRLayout);
        JPIDatosRLayout.setHorizontalGroup(JPIDatosRLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosRLayout.createSequentialGroup().addContainerGap().addComponent(this.JDFFechaR, -2, 121, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPOportunidadC, -2, 182, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPObservacionC, -2, 502, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFFNCita, -2, 107, -2).addContainerGap(-1, 32767)));
        JPIDatosRLayout.setVerticalGroup(JPIDatosRLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosRLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosRLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JSPObservacionC, -1, 54, 32767).addComponent(this.JTFFNCita, -1, 54, 32767).addComponent(this.JDFFechaR, -2, -1, -2).addComponent(this.JSPOportunidadC, -1, 54, 32767)).addGap(22, 22, 22)));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JPIDatosR, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.JSPDetalle, GroupLayout.Alignment.LEADING, -1, 978, 32767).addComponent(this.JPIDatos, GroupLayout.Alignment.LEADING, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalle, -2, 155, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPIDatosR, -2, -1, -2).addContainerGap(-1, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            if (this.xobjetollamador.equals("jifconsultarresultado")) {
                this.JTFFIdSeguimiento.setValue(Integer.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString()));
                this.JDFFecha.setDate(this.xmetodos.getPasarTextoAFecha(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString()));
                this.JTADSeguimiento.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString());
            } else if (this.xobjetollamador.equals("jifseguimientolab1")) {
                this.JDFFechaR.setDate(this.xmetodos.getPasarTextoAFecha(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString()));
                this.JTADSeguimiento.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 12).toString());
                this.JTAOportunidadC.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 10).toString());
                this.JTAObservacionC.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 11).toString());
                this.JTFFNCita.setValue(Long.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 7).toString()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTAOportunidadCKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 9) {
            this.JTAOportunidadC.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTAObservacionCKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 9) {
            this.JTAObservacionC.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTADSeguimientoKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 9) {
            this.JTADSeguimiento.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFNCitaMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            BuscarCitas frmB = new BuscarCitas(null, true, this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 8).toString(), "jifseguimientolab1", this);
            frmB.setVisible(true);
        }
    }

    public void mNuevo() {
        this.JDFFecha.setDate(this.xmetodos.getFechaActual());
        this.JDFFechaR.setDate(this.xmetodos.getFechaActual());
        this.JTADSeguimiento.setText("");
        this.JTAOportunidadC.setText("");
        this.JTAObservacionC.setText("");
        this.JTFFNCita.setValue(new Integer(0));
        this.JTFFIdSeguimiento.setValue((Object) null);
        this.xestado = false;
        mActivarDesactivar();
        mCargarDatos();
    }

    private void mCrearTabla() {
        this.xmodelo = new DefaultTableModel((Object[][]) null, new String[]{"Id", "Fecha", "Seguimiento Médico", "Oportunidad Cita", "Seguimiento Recepción", "Usuario", "Email", "Id_Cita", "IdPersona", "FechaS", "Oportunidad", "Seguimiento", "Seg"}) { // from class: Historia.JIFSeguimientoOrdenesLab.6
            Class[] types = {Long.class, String.class, String.class, String.class, String.class, String.class, String.class, Long.class, Long.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return this.canEdit[colIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(5);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(6).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(6).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(7).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(7).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(8).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(8).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(9).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(9).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(10).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(10).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(11).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(11).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(12).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(12).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(12).setMaxWidth(0);
    }

    private void mCrearTabla1() {
        this.xmodelo = new DefaultTableModel((Object[][]) null, new String[]{"Id", "Fecha", "N° HC", "Usuario", "Telefono", "Médico", "Email", "IdCita", "IdPersona", "FechaS", "Oportunidad", "Seguimiento", "SeguimientoM"}) { // from class: Historia.JIFSeguimientoOrdenesLab.7
            Class[] types = {Long.class, String.class, String.class, String.class, String.class, String.class, String.class, Long.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return this.canEdit[colIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(5);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(6).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(6).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(7).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(7).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(8).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(8).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(9).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(9).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(10).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(10).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(11).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(11).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(12).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(12).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(12).setMaxWidth(0);
    }

    private void mCargarDatos() {
        String sql = null;
        if (this.xobjetollamador.equals("jifconsultarresultado")) {
            sql = "SELECT h_seguimiento_pac.Id, DATE_FORMAT(h_seguimiento_pac.FechaS,'%d/%m/%Y') as Fecha, h_seguimiento_pac.Seguimiento, h_seguimiento_pac.OportunidadC, h_seguimiento_pac.SeguimientoR, persona.NUsuario, persona.Corre, h_seguimiento_pac.Id_Cita,0, DATE_FORMAT(h_seguimiento_pac.FechaA,'%d/%m/%Y') as FechaA,h_seguimiento_pac.OportunidadC, h_seguimiento_pac.SeguimientoR, h_seguimiento_pac.Seguimiento FROM h_seguimiento_pac INNER JOIN l_detallerecepcion ON (h_seguimiento_pac.Id = l_detallerecepcion.Id_Seguimiento) INNER JOIN l_recepcion  ON (l_detallerecepcion.Id_Recepcion = l_recepcion.Id) INNER JOIN g_usuario_sist ON (g_usuario_sist.Login = h_seguimiento_pac.UsuarioS) INNER JOIN persona  ON (persona.Id_persona = g_usuario_sist.Id_Persona) WHERE (h_seguimiento_pac.Estado =1 AND l_detallerecepcion.Id_Recepcion ='" + this.xjifconsres.xmodelo.getValueAt(this.xjifconsres.JTBResultado.getSelectedRow(), 6) + "') GROUP BY l_detallerecepcion.Id_Recepcion ORDER BY h_seguimiento_pac.FechaS DESC ";
            mCrearTabla();
        } else if (this.xobjetollamador.equals("jifseguimientolab1")) {
            sql = "SELECT h_seguimiento_pac.Id, DATE_FORMAT(h_seguimiento_pac.FechaS,'%d/%m/%Y') AS Fecha, persona.NoHistoria, persona.NUsuario, persona.Telefono, profesional.NProfesional, profesional.Correo , h_seguimiento_pac.Id_Cita, persona.Id_persona, DATE_FORMAT(h_seguimiento_pac.FechaA,'%d/%m/%Y') AS FechaA, h_seguimiento_pac.OportunidadC, IF(h_seguimiento_pac.SeguimientoR IS NULL,'',h_seguimiento_pac.SeguimientoR  ) AS SeguimientoR, h_seguimiento_pac.Seguimiento FROM l_detallerecepcion INNER JOIN h_seguimiento_pac ON (l_detallerecepcion.Id_Seguimiento = h_seguimiento_pac.Id) INNER JOIN l_recepcion  ON (l_detallerecepcion.Id_Recepcion = l_recepcion.Id) INNER JOIN persona  ON (l_recepcion.Id_Paciente = persona.Id_persona) INNER JOIN g_usuario_sist  ON (g_usuario_sist.Login = h_seguimiento_pac.UsuarioS) INNER JOIN profesional  ON (profesional.Id_Persona = g_usuario_sist.Id_Persona) WHERE (h_seguimiento_pac.FechaS ='" + this.xmetodos.formatoAMDG.format(this.JDFFecha.getDate()) + "' AND h_seguimiento_pac.Estado =1) GROUP BY h_seguimiento_pac.Id ORDER BY Fecha ASC, persona.NUsuario ASC ";
            mCrearTabla1();
        }
        System.out.println("cargar tabla -> " + sql);
        ResultSet rs = this.xconsultas.traerRs(sql);
        try {
            if (rs.next()) {
                rs.beforeFirst();
                int x = 0;
                while (rs.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(Long.valueOf(rs.getLong(1)), x, 0);
                    this.xmodelo.setValueAt(rs.getString(2), x, 1);
                    this.xmodelo.setValueAt(rs.getString(3), x, 2);
                    this.xmodelo.setValueAt(rs.getString(4), x, 3);
                    this.xmodelo.setValueAt(rs.getString(5), x, 4);
                    this.xmodelo.setValueAt(rs.getString(6), x, 5);
                    this.xmodelo.setValueAt(rs.getString(7), x, 6);
                    this.xmodelo.setValueAt(Long.valueOf(rs.getLong(8)), x, 7);
                    this.xmodelo.setValueAt(Long.valueOf(rs.getLong(9)), x, 8);
                    this.xmodelo.setValueAt(rs.getString(10), x, 9);
                    this.xmodelo.setValueAt(rs.getString(11), x, 10);
                    this.xmodelo.setValueAt(rs.getString(12), x, 11);
                    this.xmodelo.setValueAt(rs.getString(13), x, 12);
                    x++;
                }
                this.xestado = true;
            }
            rs.close();
            this.xconsultas.cerrarConexionBd();
        } catch (SQLException ex) {
            this.xconsultas.mostrarErrorSQL(ex);
        }
    }

    public void mGrabar() {
        if (this.xobjetollamador.equals("jifconsultarresultado")) {
            if (!this.xestado) {
                int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "VERIFICAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (n == 0) {
                    String sql = "insert into h_seguimiento_pac(FechaS, Seguimiento, Fecha, UsuarioS) values ('" + this.xmetodos.formatoAMD.format(this.JDFFecha.getDate()) + "','" + this.JTADSeguimiento.getText() + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                    System.out.println(sql);
                    this.JTFFIdSeguimiento.setValue(Integer.valueOf(this.xconsultas.ejecutarSQLId(sql)));
                    this.xconsultas.cerrarConexionBd();
                    mActualizarIdRecepcionLab();
                    mCargarDatos();
                    if (!Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO CAMU DEL PRADO")) {
                        this.xmetodos.mEnvioCorreoElectronico("Se ha generado el seguimiento N° " + this.JTFFIdSeguimiento.getText() + " \nFavor realizar la asignación de cita prioritaria \n\n" + Principal.usuarioSistemaDTO.getNombreUsuario(), "recepcion@fundacionpanzenu.org.co", "Exámenes Alterados", Principal.usuarioSistemaDTO.getLogin());
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        mActualizarSeguimiento();
    }

    private void mActualizarIdRecepcionLab() {
        if (this.xobjetollamador.equals("jifconsultarresultado")) {
            String sql = "update l_detallerecepcion set Id_Seguimiento='" + this.JTFFIdSeguimiento.getValue() + "' where Id_Recepcion='" + this.xjifconsres.xmodelo.getValueAt(this.xjifconsres.JTBResultado.getSelectedRow(), 6) + "' and Alterado=1";
            System.out.println(sql);
            this.xconsultas.ejecutarSQL(sql);
            this.xconsultas.cerrarConexionBd();
        }
    }

    private void mRealizarCasting(JInternalFrame frm) {
        if (frm.getName().equals("jifconsultarresultado")) {
            this.xjifconsres = (JIFConsultarResultadoExamenes) frm;
            this.xobjetollamador = "jifconsultarresultado";
        }
    }

    private void mActivarDesactivar() {
        if (this.xobjetollamador.equals("jifconsultarresultado")) {
            this.JDFFechaR.setEnabled(false);
            this.JTAOportunidadC.setEnabled(false);
            this.JTAObservacionC.setEnabled(false);
            this.JTFFNCita.setEnabled(false);
            return;
        }
        if (this.xobjetollamador.equals("jifseguimientolab1")) {
            this.JDFFechaR.setEnabled(true);
            this.JTAOportunidadC.setEnabled(true);
            this.JTAObservacionC.setEnabled(true);
            this.JTFFNCita.setEnabled(true);
        }
    }

    public void mBuscar() {
        if (this.xobjetollamador.equals("jifseguimientolab1")) {
            mCargarDatos();
        }
    }

    private void mActualizarSeguimiento() {
        if (this.JTDetalle.getSelectedRow() != -1) {
            if (!this.JTAOportunidadC.getText().isEmpty()) {
                if (this.JTAObservacionC.getText().isEmpty()) {
                    JOptionPane.showInternalMessageDialog(this, "El campo observación no puede estar en blanco", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    this.JTAObservacionC.requestFocus();
                    return;
                }
                if (Long.valueOf(this.JTFFNCita.getValue().toString()).longValue() != 0) {
                    if (Integer.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 7).toString()).intValue() == 0) {
                        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                        if (n == 0) {
                            String sql = "update h_seguimiento_pac set  FechaA='" + this.xmetodos.formatoAMD.format(this.JDFFechaR.getDate()) + "', OportunidadC='" + this.JTAOportunidadC.getText() + "', SeguimientoR='" + this.JTAObservacionC.getText() + "', Id_Cita='" + this.JTFFNCita.getValue() + "', UsuarioAC='" + Principal.usuarioSistemaDTO.getLogin() + "' where Id='" + this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0) + "'";
                            this.xconsultas.ejecutarSQL(sql);
                            this.xconsultas.cerrarConexionBd();
                            this.xmetodos.mEnvioCorreoElectronico("Se ha realizado la asignación de cita al seguimiento N° " + this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString() + " \nCon  la cita N° " + this.JTFFNCita.getText() + "\n\n" + Principal.usuarioSistemaDTO.getNombreUsuario(), this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 6).toString(), "Asignación de Citas a Exámenes Alterados", Principal.usuarioSistemaDTO.getLogin());
                            return;
                        }
                        return;
                    }
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "El número de cita no es valido", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JTFFNCita.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "El campo oportunidad no puede estar en blanco", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTAOportunidadC.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un seguimiento", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }
}
