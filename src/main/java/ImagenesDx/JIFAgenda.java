package ImagenesDx;

import Acceso.Principal;
import Laboratorio.Render;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:ImagenesDx/JIFAgenda.class */
public class JIFAgenda extends JInternalFrame {
    private Thread hilo;
    private String[] xIdServicio;
    private Timer timer;
    private Object[] dato;
    private String sql;
    public DefaultTableModel xmodelo;
    private claseImagenesDx xclaselab;
    private ButtonGroup JBGFiltro;
    private ButtonGroup JBGFiltroNp;
    public JComboBox JCBServicio;
    private JPanel JPIFiltro;
    public JRadioButton JRBAtendidas;
    public JRadioButton JRBPorAtender;
    public JRadioButton JRBTodas;
    private JScrollPane JSPDatosAgenta;
    private JTable JTBDatosAgenda;
    private JTextField JTFFiltro;
    private JTextField txtCantidad;
    public JDateChooser txtFecha;
    private Metodos xmt = new Metodos();
    private ConsultasMySQL xct = new ConsultasMySQL();
    private int estado = 0;
    private int xlleno = 0;
    private boolean xllenox = false;
    AtomicBoolean EstadoTarea = new AtomicBoolean(true);

    public JIFAgenda(claseImagenesDx xclaselab) {
        initComponents();
        this.xclaselab = xclaselab;
        mNuevo();
        ejecutarTareaTimer();
    }

    private void ejecutarTareaTimer() {
        this.timer = new Timer();
        this.timer.schedule(new TimerTask() { // from class: ImagenesDx.JIFAgenda.1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (JIFAgenda.this.EstadoTarea.get()) {
                    if (JIFAgenda.this.xmodelo != null && JIFAgenda.this.txtFecha.getDate() != null && JIFAgenda.this.JCBServicio.getSelectedIndex() != 1) {
                        SwingUtilities.invokeLater(() -> {
                            JIFAgenda.this.cargarDatos();
                        });
                        return;
                    }
                    return;
                }
                System.out.println("Finaliza ejecucion de Timer de Agenda de Servicios de Enfermeria");
                JIFAgenda.this.timer.cancel();
            }
        }, 0L, 20000L);
    }

    private void mLlenarCombo() {
        String sql;
        this.xllenox = false;
        if (Principal.informacionIps.getEsFpz().intValue() == 0) {
            sql = "SELECT f_tiposervicio.`Id`, f_tiposervicio.`Nbre`\nFROM  `f_itemordenesproced` \nINNER JOIN  `f_ordenes`  ON (`f_itemordenesproced`.`Id_Ordenes` = `f_ordenes`.`Id`)  \nINNER JOIN `f_tiposervicio`  ON (`f_tiposervicio`.`Id` = `f_ordenes`.`Id_TipoServicio`)  \nINNER JOIN `ingreso`  ON (`f_ordenes`.`Id_Ingreso` = `ingreso`.`Id`)  \n INNER JOIN `g_persona`  ON (`ingreso`.`Id_Usuario` = `g_persona`.`Id`) \nINNER JOIN `g_usuario`  ON (`g_persona`.`Id` = `g_usuario`.`Id_persona`)  \nINNER JOIN `g_procedimiento`  ON (`f_itemordenesproced`.`Id_Procedimiento` = `g_procedimiento`.`Id`) \n INNER JOIN `g_tipoatencion` ON (`ingreso`.`Id_TipoAtencion` = `g_tipoatencion`.`Id`)    \n  LEFT JOIN  `c_citas` ON (`ingreso`.`Id` = `c_citas`.`Id_ingreso`)    \n LEFT JOIN `c_clasecita` ON (`c_clasecita`.`Id` = `c_citas`.`Id_ClaseCita`)    \n  LEFT JOIN  `c_citasnp` ON (`ingreso`.`Id` = `c_citasnp`.`Id_ingreso`)    \n LEFT JOIN `c_clasecita` CNP ON (`CNP`.`Id` = `c_citasnp`.`Id_ClaseCita`)  \nWHERE (`f_ordenes`.`Id_TipoServicio` =3 \nAND f_ordenes.`FechaOrden` ='" + this.xmt.formatoAMD1.format(this.txtFecha.getDate()) + "' AND `f_ordenes`.`Estado` =0 ) \nGROUP BY f_tiposervicio.`Id` ORDER BY f_tiposervicio.`Nbre` ASC ";
        } else if (Principal.informacionIps.getIdentificacion().equals("812005644")) {
            sql = "SELECT f_tiposervicio.`Id`, f_tiposervicio.`Nbre`\nFROM  `f_itemordenesproced` \nINNER JOIN  `f_ordenes`  ON (`f_itemordenesproced`.`Id_Ordenes` = `f_ordenes`.`Id`)  \nINNER JOIN `f_tiposervicio`  ON (`f_tiposervicio`.`Id` = `f_ordenes`.`Id_TipoServicio`)  \nINNER JOIN `ingreso`  ON (`f_ordenes`.`Id_Ingreso` = `ingreso`.`Id`)  \n INNER JOIN `g_persona`  ON (`ingreso`.`Id_Usuario` = `g_persona`.`Id`) \nINNER JOIN `g_usuario`  ON (`g_persona`.`Id` = `g_usuario`.`Id_persona`)  \nINNER JOIN `g_procedimiento`  ON (`f_itemordenesproced`.`Id_Procedimiento` = `g_procedimiento`.`Id`) \n INNER JOIN `g_tipoatencion` ON (`ingreso`.`Id_TipoAtencion` = `g_tipoatencion`.`Id`)    \n  LEFT JOIN  `c_citas` ON (`ingreso`.`Id` = `c_citas`.`Id_ingreso`)    \n LEFT JOIN `c_clasecita` ON (`c_clasecita`.`Id` = `c_citas`.`Id_ClaseCita`)    \n  LEFT JOIN  `c_citasnp` ON (`ingreso`.`Id` = `c_citasnp`.`Id_ingreso`)    \n LEFT JOIN `c_clasecita` CNP ON (`CNP`.`Id` = `c_citasnp`.`Id_ClaseCita`)  \nWHERE (f_tiposervicio.AgendaRx=1 and f_ordenes.`FechaOrden` ='" + this.xmt.formatoAMD1.format(this.txtFecha.getDate()) + "' AND `f_ordenes`.`Estado` =0 ) \nGROUP BY f_tiposervicio.`Id` ORDER BY f_tiposervicio.`Nbre` ASC ";
        } else {
            sql = "SELECT f_tiposervicio.`Id`, f_tiposervicio.`Nbre`\nFROM  `f_itemordenesproced` \nINNER JOIN  `f_ordenes`  ON (`f_itemordenesproced`.`Id_Ordenes` = `f_ordenes`.`Id`)  \nINNER JOIN `f_tiposervicio`  ON (`f_tiposervicio`.`Id` = `f_ordenes`.`Id_TipoServicio`)  \nINNER JOIN `ingreso`  ON (`f_ordenes`.`Id_Ingreso` = `ingreso`.`Id`)  \n INNER JOIN `g_persona`  ON (`ingreso`.`Id_Usuario` = `g_persona`.`Id`) \nINNER JOIN `g_usuario`  ON (`g_persona`.`Id` = `g_usuario`.`Id_persona`)  \nINNER JOIN `g_procedimiento`  ON (`f_itemordenesproced`.`Id_Procedimiento` = `g_procedimiento`.`Id`) \n INNER JOIN `g_tipoatencion` ON (`ingreso`.`Id_TipoAtencion` = `g_tipoatencion`.`Id`)    \n  LEFT JOIN  `c_citas` ON (`ingreso`.`Id` = `c_citas`.`Id_ingreso`)    \n LEFT JOIN `c_clasecita` ON (`c_clasecita`.`Id` = `c_citas`.`Id_ClaseCita`)    \n  LEFT JOIN  `c_citasnp` ON (`ingreso`.`Id` = `c_citasnp`.`Id_ingreso`)    \n LEFT JOIN `c_clasecita` CNP ON (`CNP`.`Id` = `c_citasnp`.`Id_ClaseCita`)  \nWHERE (f_tiposervicio.AgendaRx=1 and f_ordenes.`FechaOrden` ='" + this.xmt.formatoAMD1.format(this.txtFecha.getDate()) + "' AND `f_ordenes`.`Estado` =0 ) \nGROUP BY f_tiposervicio.`Id` ORDER BY f_tiposervicio.`Nbre` ASC ";
        }
        System.out.println("Llena Combo Servicio Agenda: " + sql);
        this.JCBServicio.removeAllItems();
        this.xIdServicio = this.xct.llenarCombo(sql, this.xIdServicio, this.JCBServicio);
        if (this.xIdServicio.length > 1) {
            this.JCBServicio.setSelectedIndex(-1);
        }
        this.xllenox = true;
    }

    private void mNuevo() {
        this.JTFFiltro.setText("");
        this.xlleno = 0;
        this.txtFecha.setDate(this.xmt.getFechaActual());
        crearGrid();
        this.xlleno = 1;
        mLlenarCombo();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearGrid() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"No. Historia", "Usuario", "Edad", "Sexo", "Hora de Llegada", "Id", "Atendido", "Estado", "Servicio", "tipoAP", "Preferencial", "Clase Cita", "Empresa"}) { // from class: ImagenesDx.JIFAgenda.2
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Integer.class, JLabel.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTBDatosAgenda;
        JTable jTable2 = this.JTBDatosAgenda;
        jTable.setAutoResizeMode(0);
        this.JTBDatosAgenda.doLayout();
        this.JTBDatosAgenda.setModel(this.xmodelo);
        this.JTBDatosAgenda.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTBDatosAgenda.getColumnModel().getColumn(1).setPreferredWidth(300);
        this.JTBDatosAgenda.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTBDatosAgenda.getColumnModel().getColumn(3).setPreferredWidth(80);
        this.JTBDatosAgenda.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTBDatosAgenda.getColumnModel().getColumn(5).setPreferredWidth(0);
        this.JTBDatosAgenda.getColumnModel().getColumn(5).setMinWidth(0);
        this.JTBDatosAgenda.getColumnModel().getColumn(5).setMaxWidth(0);
        this.JTBDatosAgenda.getColumnModel().getColumn(6).setPreferredWidth(0);
        this.JTBDatosAgenda.getColumnModel().getColumn(6).setMinWidth(0);
        this.JTBDatosAgenda.getColumnModel().getColumn(6).setMaxWidth(0);
        this.JTBDatosAgenda.getColumnModel().getColumn(7).setPreferredWidth(100);
        this.JTBDatosAgenda.getColumnModel().getColumn(8).setPreferredWidth(100);
        this.JTBDatosAgenda.getColumnModel().getColumn(9).setPreferredWidth(100);
        this.JTBDatosAgenda.getColumnModel().getColumn(9).setMinWidth(0);
        this.JTBDatosAgenda.getColumnModel().getColumn(9).setMaxWidth(0);
        this.JTBDatosAgenda.getColumnModel().getColumn(10).setPreferredWidth(100);
        this.JTBDatosAgenda.getColumnModel().getColumn(11).setPreferredWidth(100);
        this.JTBDatosAgenda.getColumnModel().getColumn(12).setPreferredWidth(300);
    }

    public void cargarDatos() {
        crearGrid();
        if (this.JCBServicio.getSelectedIndex() != -1) {
            if (this.estado == 1 || this.estado == 2 || this.estado == 0) {
                this.sql = "SELECT `g_usuario`.`NoHistoria`,  CONCAT(`g_persona`.`Apellido1`, ' ', `g_persona`.`Apellido2`,' ',`g_persona`.`Nombre1`,' ',`g_persona`.`Nombre2`) AS Nombre, CONCAT(`g_persona`.`Edad`,' ',IF(`g_persona`.`Id_TipoEdad`=1, 'Años',IF(`g_persona`.`Id_TipoEdad`=2,'Mes', 'Día')) ,'(s)') AS `Edad`,  `g_persona`.`Id_Sexo`, `ingreso`.`HoraIngreso`, `f_ordenes`.`Id`, `f_ordenes`.`EstadoRecep`, `g_tipoatencion`.`Nbre` AS  NTipo   ,IF(`ingreso`.`CEspecial` IS NULL, '0',`ingreso`.`CEspecial`) AS CEspecial , IF ((c_clasecita.`Nbre` IS NULL AND CNP.`Nbre` IS NULL), g_procedimiento.`Nbre` ,IF( c_clasecita.`Nbre` IS NULL, CNP.`Nbre`, c_clasecita.`Nbre`)) NClaseCitas, f_empresacontxconvenio.`Nbre` AS NEmpresa FROM  `f_itemordenesproced` INNER JOIN  `f_ordenes`  ON (`f_itemordenesproced`.`Id_Ordenes` = `f_ordenes`.`Id`)  INNER JOIN `ingreso`  ON (`f_ordenes`.`Id_Ingreso` = `ingreso`.`Id`)   INNER JOIN `g_persona`  ON (`ingreso`.`Id_Usuario` = `g_persona`.`Id`) INNER JOIN `g_usuario`  ON (`g_persona`.`Id` = `g_usuario`.`Id_persona`)  INNER JOIN `g_procedimiento`  ON (`f_itemordenesproced`.`Id_Procedimiento` = `g_procedimiento`.`Id`)  INNER JOIN `g_tipoatencion` ON (`ingreso`.`Id_TipoAtencion` = `g_tipoatencion`.`Id`)  INNER JOIN `f_empresacontxconvenio` ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)          LEFT JOIN  `c_citas` ON (`ingreso`.`Id` = `c_citas`.`Id_ingreso`)    \n LEFT JOIN `c_clasecita` ON (`c_clasecita`.`Id` = `c_citas`.`Id_ClaseCita`)    \n  LEFT JOIN  `c_citasnp` ON (`ingreso`.`Id` = `c_citasnp`.`Id_ingreso`)    \n LEFT JOIN `c_clasecita` CNP ON (`CNP`.`Id` = `c_citasnp`.`Id_ClaseCita`)  WHERE (`f_ordenes`.`Id_TipoServicio` ='" + this.xIdServicio[this.JCBServicio.getSelectedIndex()] + "'  AND f_ordenes.`FechaOrden` ='" + this.xmt.formatoAMD.format(this.txtFecha.getDate()) + "' AND `f_ordenes`.`Estado` =0 and `f_ordenes`.`EstadoRecep`='" + this.estado + "' AND CONCAT(`g_persona`.`Apellido1`, ' ', `g_persona`.`Apellido2`,' ',`g_persona`.`Nombre1`,' ',`g_persona`.`Nombre2`) LIKE '%" + this.JTFFiltro.getText() + "%') GROUP BY `f_ordenes`.`Id`ORDER BY `ingreso`.`HoraIngreso` ASC ";
            } else {
                this.sql = "SELECT `g_usuario`.`NoHistoria`,  CONCAT(`g_persona`.`Apellido1`, ' ', `g_persona`.`Apellido2`,' ',`g_persona`.`Nombre1`,' ',`g_persona`.`Nombre2`) AS Nombre, CONCAT(`g_persona`.`Edad`,' ',IF(`g_persona`.`Id_TipoEdad`=1, 'Años',IF(`g_persona`.`Id_TipoEdad`=2,'Mes', 'Día')) ,'(s)') AS `Edad`,  `g_persona`.`Id_Sexo`, `ingreso`.`HoraIngreso`, `f_ordenes`.`Id`, `f_ordenes`.`EstadoRecep`, `g_tipoatencion`.`Nbre` AS  NTipo   ,IF(`ingreso`.`CEspecial` IS NULL, '0',`ingreso`.`CEspecial`) AS CEspecial, IF ((c_clasecita.`Nbre` IS NULL AND CNP.`Nbre` IS NULL),  g_procedimiento.`Nbre`,IF( c_clasecita.`Nbre` IS NULL, CNP.`Nbre`, c_clasecita.`Nbre`)) NClaseCitas, f_empresacontxconvenio.`Nbre` AS NEmpresa  FROM  `f_itemordenesproced` INNER JOIN  `f_ordenes`  ON (`f_itemordenesproced`.`Id_Ordenes` = `f_ordenes`.`Id`)  INNER JOIN `ingreso`  ON (`f_ordenes`.`Id_Ingreso` = `ingreso`.`Id`)   INNER JOIN `g_persona`  ON (`ingreso`.`Id_Usuario` = `g_persona`.`Id`) INNER JOIN `g_usuario`  ON (`g_persona`.`Id` = `g_usuario`.`Id_persona`)  INNER JOIN `g_procedimiento`  ON (`f_itemordenesproced`.`Id_Procedimiento` = `g_procedimiento`.`Id`)  INNER JOIN `g_tipoatencion` ON (`ingreso`.`Id_TipoAtencion` = `g_tipoatencion`.`Id`)  INNER JOIN `f_empresacontxconvenio` ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)          LEFT JOIN  `c_citas` ON (`ingreso`.`Id` = `c_citas`.`Id_ingreso`)    \n LEFT JOIN `c_clasecita` ON (`c_clasecita`.`Id` = `c_citas`.`Id_ClaseCita`)    \n  LEFT JOIN  `c_citasnp` ON (`ingreso`.`Id` = `c_citasnp`.`Id_ingreso`)    \n LEFT JOIN `c_clasecita` CNP ON (`CNP`.`Id` = `c_citasnp`.`Id_ClaseCita`)  WHERE (`f_ordenes`.`Id_TipoServicio` ='" + this.xIdServicio[this.JCBServicio.getSelectedIndex()] + "'  AND f_ordenes.`FechaOrden` ='" + this.xmt.formatoAMD.format(this.txtFecha.getDate()) + "' AND `f_ordenes`.`Estado` =0 AND CONCAT(`g_persona`.`Apellido1`, ' ', `g_persona`.`Apellido2`,' ',`g_persona`.`Nombre1`,' ',`g_persona`.`Nombre2`) LIKE '%" + this.JTFFiltro.getText() + "%') GROUP BY `f_ordenes`.`Id`ORDER BY `ingreso`.`HoraIngreso` ASC ";
            }
            System.out.println(this.sql);
            ResultSet rs = this.xct.traerRs(this.sql);
            int filaGrid = 0;
            try {
                if (rs.next()) {
                    rs.beforeFirst();
                    this.xmt.mEstablecerTextEditor(this.JTBDatosAgenda, 12);
                    while (rs.next()) {
                        this.xmodelo.addRow(this.dato);
                        this.xmodelo.setValueAt(rs.getString("NoHistoria"), filaGrid, 0);
                        this.xmodelo.setValueAt(rs.getString("Nombre"), filaGrid, 1);
                        this.xmodelo.setValueAt(rs.getString("Edad"), filaGrid, 2);
                        this.xmodelo.setValueAt(rs.getString("Id_Sexo"), filaGrid, 3);
                        this.xmodelo.setValueAt(this.xmt.formatoH12.format((Date) rs.getTime("HoraIngreso")), filaGrid, 4);
                        this.xmodelo.setValueAt(rs.getString("Id"), filaGrid, 5);
                        this.xmodelo.setValueAt(rs.getString("EstadoRecep"), filaGrid, 6);
                        this.xmodelo.setValueAt(rs.getString("NTipo"), filaGrid, 8);
                        if (rs.getInt("EstadoRecep") == 0) {
                            this.xmodelo.setValueAt("POR ATENDER", filaGrid, 7);
                        } else if (rs.getInt("EstadoRecep") == 1) {
                            this.xmodelo.setValueAt("RECEPCIONADO", filaGrid, 7);
                        } else if (rs.getInt("EstadoRecep") == 2) {
                            this.xmodelo.setValueAt("ATENDIDO", filaGrid, 7);
                        }
                        if (this.xmodelo.getValueAt(filaGrid, 6) != null) {
                            if (this.xmodelo.getValueAt(filaGrid, 6).toString().equals("0") || !this.xmodelo.getValueAt(filaGrid, 6).toString().equals("1")) {
                            }
                            this.JTBDatosAgenda.setDefaultRenderer(Object.class, new MiRender());
                        }
                        this.xmodelo.setValueAt(Long.valueOf(rs.getLong("CEspecial")), filaGrid, 9);
                        this.xmodelo.setValueAt(rs.getString("NClaseCitas"), filaGrid, 11);
                        this.xmodelo.setValueAt(rs.getString("NEmpresa"), filaGrid, 12);
                        if (rs.getLong("CEspecial") == 1) {
                            this.xmodelo.setValueAt(new JLabel(new ImageIcon(getClass().getResource("/Imagenes/Atencion Discapasitaods.png"))), filaGrid, 10);
                        } else if (rs.getLong("CEspecial") == 2) {
                            this.xmodelo.setValueAt(new JLabel(new ImageIcon(getClass().getResource("/Imagenes/Atencion Embarazada.png"))), filaGrid, 10);
                        } else if (rs.getLong("CEspecial") == 3) {
                            this.xmodelo.setValueAt(new JLabel(new ImageIcon(getClass().getResource("/Imagenes/Atencion Ancianos.png"))), filaGrid, 10);
                        } else if (rs.getLong("CEspecial") == 4) {
                            this.xmodelo.setValueAt(new JLabel(new ImageIcon(getClass().getResource("/Imagenes/AtpNiños.png"))), filaGrid, 10);
                        } else {
                            this.xmodelo.setValueAt(new JLabel(""), filaGrid, 10);
                        }
                        this.JTBDatosAgenda.setDefaultRenderer(JLabel.class, new Render(rs.getInt("CEspecial"), 9));
                        filaGrid++;
                    }
                }
                this.txtCantidad.setText(String.valueOf(this.xmodelo.getRowCount()));
                rs.close();
                this.xct.cerrarConexionBd();
            } catch (SQLException ex) {
                this.xct.mostrarErrorSQL(ex);
            }
        }
    }

    /* JADX INFO: loaded from: GenomaP.jar:ImagenesDx/JIFAgenda$MiRender.class */
    public class MiRender extends DefaultTableCellRenderer {
        public MiRender() {
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            int atendido = 0;
            if (!table.getValueAt(row, 6).toString().isEmpty()) {
                atendido = Integer.parseInt(table.getValueAt(row, 6).toString());
            }
            if (atendido == 0) {
                cell.setBackground(new Color(0, 0, 102));
                cell.setForeground(Color.WHITE);
            } else if (atendido == 1) {
                cell.setBackground(new Color(103, 0, 103));
                cell.setForeground(Color.WHITE);
            } else if (atendido == 2) {
                cell.setBackground(new Color(177, 251, 177));
                cell.setForeground(Color.BLACK);
            } else {
                cell.setForeground(Color.WHITE);
            }
            return cell;
        }
    }

    /* JADX WARN: Type inference failed for: r3v37, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGFiltro = new ButtonGroup();
        this.JBGFiltroNp = new ButtonGroup();
        this.JPIFiltro = new JPanel();
        this.JRBTodas = new JRadioButton();
        this.JRBPorAtender = new JRadioButton();
        this.JRBAtendidas = new JRadioButton();
        this.txtFecha = new JDateChooser();
        this.txtCantidad = new JTextField();
        this.JSPDatosAgenta = new JScrollPane();
        this.JTBDatosAgenda = new JTable();
        this.JCBServicio = new JComboBox();
        this.JTFFiltro = new JTextField();
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("AGENDA");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setMinimumSize(null);
        setName("Agenda");
        addInternalFrameListener(new InternalFrameListener() { // from class: ImagenesDx.JIFAgenda.3
            public void internalFrameOpened(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                JIFAgenda.this.formInternalFrameClosing(evt);
            }

            public void internalFrameClosed(InternalFrameEvent evt) {
            }

            public void internalFrameIconified(InternalFrameEvent evt) {
            }

            public void internalFrameDeiconified(InternalFrameEvent evt) {
            }

            public void internalFrameActivated(InternalFrameEvent evt) {
            }

            public void internalFrameDeactivated(InternalFrameEvent evt) {
            }
        });
        this.JPIFiltro.setBorder(BorderFactory.createTitledBorder((Border) null, "FILTRAR POR:", 0, 0, new Font("Arial", 1, 12), new Color(0, 103, 0)));
        this.JBGFiltro.add(this.JRBTodas);
        this.JRBTodas.setFont(new Font("Arial", 1, 12));
        this.JRBTodas.setForeground(Color.blue);
        this.JRBTodas.setText("Todas");
        this.JRBTodas.addActionListener(new ActionListener() { // from class: ImagenesDx.JIFAgenda.4
            public void actionPerformed(ActionEvent evt) {
                JIFAgenda.this.JRBTodasActionPerformed(evt);
            }
        });
        this.JBGFiltro.add(this.JRBPorAtender);
        this.JRBPorAtender.setFont(new Font("Arial", 1, 12));
        this.JRBPorAtender.setForeground(Color.blue);
        this.JRBPorAtender.setSelected(true);
        this.JRBPorAtender.setText("Por Atender");
        this.JRBPorAtender.addActionListener(new ActionListener() { // from class: ImagenesDx.JIFAgenda.5
            public void actionPerformed(ActionEvent evt) {
                JIFAgenda.this.JRBPorAtenderActionPerformed(evt);
            }
        });
        this.JBGFiltro.add(this.JRBAtendidas);
        this.JRBAtendidas.setFont(new Font("Arial", 1, 12));
        this.JRBAtendidas.setForeground(Color.blue);
        this.JRBAtendidas.setText("Atendidas");
        this.JRBAtendidas.addActionListener(new ActionListener() { // from class: ImagenesDx.JIFAgenda.6
            public void actionPerformed(ActionEvent evt) {
                JIFAgenda.this.JRBAtendidasActionPerformed(evt);
            }
        });
        GroupLayout JPIFiltroLayout = new GroupLayout(this.JPIFiltro);
        this.JPIFiltro.setLayout(JPIFiltroLayout);
        JPIFiltroLayout.setHorizontalGroup(JPIFiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFiltroLayout.createSequentialGroup().addContainerGap().addComponent(this.JRBPorAtender).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBAtendidas).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBTodas).addContainerGap(37, 32767)));
        JPIFiltroLayout.setVerticalGroup(JPIFiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFiltroLayout.createSequentialGroup().addGroup(JPIFiltroLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBPorAtender).addComponent(this.JRBAtendidas).addComponent(this.JRBTodas)).addContainerGap(-1, 32767)));
        this.txtFecha.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Agenda", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.txtFecha.setDateFormatString("dd/MM/yyyy");
        this.txtFecha.setFont(new Font("Arial", 1, 12));
        this.txtFecha.addPropertyChangeListener(new PropertyChangeListener() { // from class: ImagenesDx.JIFAgenda.7
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFAgenda.this.txtFechaPropertyChange(evt);
            }
        });
        this.txtCantidad.setBackground(new Color(0, 0, 102));
        this.txtCantidad.setFont(new Font("Arial", 1, 14));
        this.txtCantidad.setHorizontalAlignment(0);
        this.txtCantidad.setText("0");
        this.txtCantidad.setToolTipText("Cantidad de usuarios");
        this.txtCantidad.setBorder(BorderFactory.createTitledBorder((Border) null, "Cantidad", 0, 0, new Font("Tahoma", 1, 14), new Color(255, 255, 255)));
        this.txtCantidad.setDisabledTextColor(new Color(255, 255, 255));
        this.txtCantidad.setEnabled(false);
        this.JSPDatosAgenta.setBorder(BorderFactory.createTitledBorder((Border) null, "USUARIOS FACTURADOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JSPDatosAgenta.setFont(new Font("Arial", 1, 12));
        this.JTBDatosAgenda.setFont(new Font("Arial", 1, 12));
        this.JTBDatosAgenda.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTBDatosAgenda.setRowHeight(39);
        this.JTBDatosAgenda.setSelectionBackground(new Color(255, 255, 255));
        this.JTBDatosAgenda.setSelectionForeground(new Color(255, 0, 0));
        this.JTBDatosAgenda.setSelectionMode(0);
        this.JTBDatosAgenda.addMouseListener(new MouseAdapter() { // from class: ImagenesDx.JIFAgenda.8
            public void mouseClicked(MouseEvent evt) {
                JIFAgenda.this.JTBDatosAgendaMouseClicked(evt);
            }
        });
        this.JSPDatosAgenta.setViewportView(this.JTBDatosAgenda);
        this.JCBServicio.setBorder(BorderFactory.createTitledBorder((Border) null, "Servicio", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JCBServicio.addItemListener(new ItemListener() { // from class: ImagenesDx.JIFAgenda.9
            public void itemStateChanged(ItemEvent evt) {
                JIFAgenda.this.JCBServicioItemStateChanged(evt);
            }
        });
        this.JTFFiltro.setFont(new Font("Arial", 1, 12));
        this.JTFFiltro.setBorder(BorderFactory.createTitledBorder((Border) null, "Busqueda Filtrada Por Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFiltro.addKeyListener(new KeyAdapter() { // from class: ImagenesDx.JIFAgenda.10
            public void keyPressed(KeyEvent evt) {
                JIFAgenda.this.JTFFiltroKeyPressed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JTFFiltro).addComponent(this.JSPDatosAgenta, GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup().addComponent(this.txtFecha, -2, 143, -2).addGap(18, 18, 18).addComponent(this.JPIFiltro, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.txtCantidad, -2, 126, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBServicio, 0, 445, 32767))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTFFiltro, -2, 50, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPDatosAgenta, -1, 417, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JPIFiltro, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addComponent(this.txtFecha, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addGroup(GroupLayout.Alignment.TRAILING, layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.txtCantidad).addComponent(this.JCBServicio, -2, 49, -2))).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBTodasActionPerformed(ActionEvent evt) {
        this.estado = 3;
        cargarDatos();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBPorAtenderActionPerformed(ActionEvent evt) {
        this.estado = 0;
        cargarDatos();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBAtendidasActionPerformed(ActionEvent evt) {
        this.estado = 2;
        cargarDatos();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtFechaPropertyChange(PropertyChangeEvent evt) {
        if (this.xlleno == 1) {
            mLlenarCombo();
            cargarDatos();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBDatosAgendaMouseClicked(MouseEvent evt) {
        if (this.JTBDatosAgenda.getSelectedRow() != -1) {
            this.xclaselab.setXidorden(this.xmodelo.getValueAt(this.JTBDatosAgenda.getSelectedRow(), 5).toString());
            this.xclaselab.setXposfila(this.JTBDatosAgenda.getSelectedRow());
            mCargarAtencion();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosing(InternalFrameEvent evt) {
        this.EstadoTarea.set(false);
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBServicioItemStateChanged(ItemEvent evt) {
        if (this.xllenox && this.JCBServicio.getSelectedIndex() != -1) {
            this.JTFFiltro.setText("");
            cargarDatos();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFiltroKeyPressed(KeyEvent evt) {
        cargarDatos();
    }

    private void mCargarAtencion() {
        if (this.xmodelo.getValueAt(this.xclaselab.getXposfila(), 6).toString().equals("0")) {
            this.xclaselab.cargarPantalla("Recepcion");
            this.xclaselab.xjifrecepcion.txtNoOrden.setText(this.xclaselab.getXidorden());
            this.xclaselab.xjifrecepcion.mBuscarOrden();
            Principal.txtNo.setText("");
            dispose();
            this.EstadoTarea.set(false);
            this.xclaselab.xjifagenda = null;
            try {
                finalize();
                return;
            } catch (Throwable ex) {
                Logger.getLogger(JIFAgenda.class.getName()).log(Level.SEVERE, (String) null, ex);
                return;
            }
        }
        int n = JOptionPane.showInternalConfirmDialog(this, "Orden recepcionada, \nDesea cargarla", "VERIFICAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        if (n == 0) {
            this.xclaselab.cargarPantalla("Recepcion");
            this.xclaselab.xjifrecepcion.txtNoOrden.setText(this.xclaselab.getXidorden());
            this.xclaselab.xjifrecepcion.mBuscarOrden();
            this.sql = "SELECT Id FROM l_recepcion WHERE (Id_OrdenFacturac ='" + this.xclaselab.getXidorden() + "' AND Estado =0)";
            ResultSet rs = this.xct.traerRs(this.sql);
            try {
                if (rs.next()) {
                    Principal.txtNo.setText(rs.getString(1));
                    this.xclaselab.xjifrecepcion.xidnrecepcion = rs.getString(1);
                }
                rs.close();
                this.xct.cerrarConexionBd();
            } catch (SQLException ex2) {
                Logger.getLogger(JIFAgenda.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex2);
            }
            dispose();
            this.EstadoTarea.set(false);
            this.xclaselab.xjifagenda = null;
            try {
                finalize();
            } catch (Throwable ex3) {
                Logger.getLogger(JIFAgenda.class.getName()).log(Level.SEVERE, (String) null, ex3);
            }
        }
    }
}
