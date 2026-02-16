package Citas;

import Acceso.Principal;
import General.BuscarPersona;
import General.Persona;
import ParametrizacionN.JIFFEmpresaServicios;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Citas/JIFConsultarCitas.class */
public class JIFConsultarCitas extends JInternalFrame {
    public Persona xjppersona;
    private DefaultTableModel xmodelo;
    private Object[] xdato;
    private String[] xidtipoempresa;
    private ButtonGroup JBGOpciones;
    private JDateChooser JDCFechaF;
    private JDateChooser JDCFechaI;
    private JPanel JPIDatosProf;
    private JPanel JPIFDatosUsuario;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;
    private ConsultasMySQL xconsultas = new ConsultasMySQL();
    private Metodos xmetodos = new Metodos();
    private int xestado = 0;
    private boolean xestadog = false;

    public JIFConsultarCitas() {
        initComponents();
        mCargasPanelUsuario();
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v11, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGOpciones = new ButtonGroup();
        this.JPIFDatosUsuario = new JPanel();
        this.JPIDatosProf = new JPanel();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JDCFechaI = new JDateChooser();
        this.JDCFechaF = new JDateChooser();
        setClosable(true);
        setTitle("CONSULTAR CITAS POR USUARIO");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setMaximumSize(null);
        setName("jifconsultarcitas");
        addInternalFrameListener(new InternalFrameListener() { // from class: Citas.JIFConsultarCitas.1
            public void internalFrameClosed(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                JIFConsultarCitas.this.formInternalFrameClosing(evt);
            }

            public void internalFrameOpened(InternalFrameEvent evt) {
            }

            public void internalFrameActivated(InternalFrameEvent evt) {
            }

            public void internalFrameDeactivated(InternalFrameEvent evt) {
            }

            public void internalFrameDeiconified(InternalFrameEvent evt) {
            }

            public void internalFrameIconified(InternalFrameEvent evt) {
            }
        });
        this.JPIFDatosUsuario.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN DE USUARIO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        GroupLayout JPIFDatosUsuarioLayout = new GroupLayout(this.JPIFDatosUsuario);
        this.JPIFDatosUsuario.setLayout(JPIFDatosUsuarioLayout);
        JPIFDatosUsuarioLayout.setHorizontalGroup(JPIFDatosUsuarioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 992, 32767));
        JPIFDatosUsuarioLayout.setVerticalGroup(JPIFDatosUsuarioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 168, 32767));
        this.JPIDatosProf.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS DEL PROFESIONAL", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.setSelectionMode(0);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: Citas.JIFConsultarCitas.2
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarCitas.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.JDCFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicio", 1, 0, new Font("Tahoma", 1, 12), Color.blue));
        this.JDCFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDCFechaI.setFont(new Font("Arial", 1, 12));
        this.JDCFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Fin", 1, 0, new Font("Tahoma", 1, 12), Color.blue));
        this.JDCFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDCFechaF.setFont(new Font("Arial", 1, 12));
        GroupLayout JPIDatosProfLayout = new GroupLayout(this.JPIDatosProf);
        this.JPIDatosProf.setLayout(JPIDatosProfLayout);
        JPIDatosProfLayout.setHorizontalGroup(JPIDatosProfLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosProfLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosProfLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPDetalle, -1, 972, 32767).addGroup(JPIDatosProfLayout.createSequentialGroup().addComponent(this.JDCFechaI, -2, 143, -2).addGap(18, 18, 18).addComponent(this.JDCFechaF, -2, 143, -2))).addContainerGap()));
        JPIDatosProfLayout.setVerticalGroup(JPIDatosProfLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosProfLayout.createSequentialGroup().addGap(6, 6, 6).addGroup(JPIDatosProfLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JDCFechaI, -2, 56, -2).addComponent(this.JDCFechaF, -2, 56, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPDetalle, -2, 138, -2)));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JPIDatosProf, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.JPIFDatosUsuario, GroupLayout.Alignment.LEADING, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIFDatosUsuario, -2, -1, -2).addGap(18, 18, 18).addComponent(this.JPIDatosProf, -2, -1, -2).addContainerGap(20, 32767)));
        getAccessibleContext().setAccessibleName("usuario");
        pack();
    }

    private void txtFechaNacimientoFocusLost(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosing(InternalFrameEvent evt) {
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2 && this.JTDetalle.getSelectedRow() != -1) {
            Object[] botones = {"Individual", "Grupal", "Cerrar"};
            int n = JOptionPane.showInternalOptionDialog(this, "Como desea visualizar el recordatorio de citas?", "IMPRIMIR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), botones, "Cerrar");
            if (n == 0) {
                String[][] parametros = new String[5][2];
                parametros[0][0] = "numero";
                parametros[0][1] = this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 4).toString();
                parametros[1][0] = "nbreUsuario";
                parametros[1][1] = Principal.usuarioSistemaDTO.getNombreUsuario();
                parametros[2][0] = "ruta";
                parametros[2][1] = this.xmetodos.getRutaRep();
                parametros[3][0] = "SUBREPORT_DIR";
                parametros[3][1] = this.xmetodos.getSO() + this.xmetodos.getBarra() + "Reportes" + this.xmetodos.getBarra();
                parametros[4][0] = "SUBREPORTFIRMA_DIR";
                parametros[4][1] = this.xmetodos.getSO() + this.xmetodos.getBarra() + "Firmas" + this.xmetodos.getBarra();
                this.xmetodos.GenerarPDF(this.xmetodos.getRutaRep() + "C_RecordatorioDeCita", parametros);
                return;
            }
            if (n == 1) {
                String[][] parametros2 = new String[6][2];
                parametros2[0][0] = "idusuario";
                parametros2[0][1] = this.xjppersona.getIdPersona();
                parametros2[1][0] = "nbreUsuario";
                parametros2[1][1] = Principal.usuarioSistemaDTO.getNombreUsuario();
                parametros2[2][0] = "fechai";
                parametros2[2][1] = this.xmetodos.formatoAMD.format(this.JDCFechaI.getDate());
                parametros2[3][0] = "fechaf";
                parametros2[3][1] = this.xmetodos.formatoAMD.format(this.JDCFechaF.getDate());
                parametros2[4][0] = "SUBREPORT_DIR";
                parametros2[4][1] = this.xmetodos.getSO() + this.xmetodos.getBarra() + "Reportes" + this.xmetodos.getBarra();
                parametros2[5][0] = "SUBREPORTFIRMA_DIR";
                parametros2[5][1] = this.xmetodos.getSO() + this.xmetodos.getBarra() + "Firmas" + this.xmetodos.getBarra();
                this.xmetodos.GenerarPDF(this.xmetodos.getRutaRep() + "C_RecordatorioDeCitas", parametros2);
            }
        }
    }

    private void mCargasPanelUsuario() {
        this.xjppersona = new Persona(this);
        this.xjppersona.setVisible(true);
        this.JPIFDatosUsuario.setVisible(false);
        this.xjppersona.setBounds(5, 15, 950, 160);
        this.JPIFDatosUsuario.add(this.xjppersona);
        this.JPIFDatosUsuario.setVisible(true);
    }

    public void mNuevo() {
        this.xjppersona.nuevo();
        this.JDCFechaI.setDate(this.xmetodos.getFechaActual());
        this.JDCFechaF.setDate(this.xmetodos.getFechaActual());
        mCrearModeloDatos();
        this.xjppersona.txtHistoria.requestFocus();
    }

    public void mGrabar() {
        if (!this.xjppersona.getIdPersona().equals("") && this.xjppersona.getIdPersona() != null) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                mCargarDatosTabla(this.xjppersona.getIdPersona());
                return;
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una persona", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Fecha", "Especialidad", "Profesional", "Hora", "Id"}) { // from class: Citas.JIFConsultarCitas.3
            Class[] types = {String.class, String.class, String.class, String.class, Long.class};
            boolean[] canEdit = {false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(50);
    }

    public void mCargarDatosTabla(String xidpersona) {
        try {
            mCrearModeloDatos();
            String sql = "SELECT Date_Format(c_citas.Fecha_Cita,'%d-%m-%Y') as Fecha, profesional1.Especialidad, profesional1.NProfesional, c_citas.HoraInicial, c_citas.Id FROM persona INNER JOIN baseserver.c_citas ON (persona.Id_persona = c_citas.Id_Usuario)INNER JOIN profesional1 ON (profesional1.IdEspecialidad = c_citas.Id_Especialidad) AND (profesional1.Id_Persona = c_citas.Id_Profesional) WHERE (c_citas.Id_Usuario ='" + xidpersona + "' AND c_citas.Fecha_Cita >='" + this.xmetodos.formatoAMD.format(this.JDCFechaI.getDate()) + "' AND c_citas.Fecha_Cita <='" + this.xmetodos.formatoAMD.format(this.JDCFechaF.getDate()) + "' AND c_citas.Id_MotivoDesistida =1)  ORDER BY c_citas.Fecha_Cita ASC ";
            ResultSet xrs = this.xconsultas.traerRs(sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(xrs.getString(1), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelo.setValueAt(xrs.getString(4), n, 3);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(5)), n, 4);
                    this.xestadog = true;
                    n++;
                }
            }
            xrs.close();
            this.xconsultas.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFFEmpresaServicios.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mBuscar() {
        BuscarPersona frmBuscar = new BuscarPersona(null, true, this.xjppersona);
        frmBuscar.setVisible(true);
    }
}
