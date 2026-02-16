package PyP;

import Acceso.Principal;
import General.BuscarPersona;
import General.Persona;
import ParametrizacionN.JDBuscarProfesional;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.genoma.plus.controller.general.JDGenericoPanel;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:PyP/Vacunacion.class */
public class Vacunacion extends JInternalFrame {
    private ResultSet rs;
    private int filaGrid;
    private Object[] dato;
    private String sql;
    private String nombreVacunador;
    private DefaultTableModel modelo;
    private Persona frmPersona;
    private clasePyP clasepyp;
    private boolean xAgenda;
    private long xIdOrden;
    private long xIdIngreso;
    private ButtonGroup JBG_FiltroEdad;
    private ButtonGroup JBG_Forma;
    private JButton JBTAjustarEsquema;
    private JButton JBTEventoAdverso1;
    private JCheckBox JCH_FitroEdad;
    private JCheckBox JCH_MostrarTodo;
    private JPanel JPI_FiltroEdad;
    private JPanel JPI_Orden;
    private JRadioButton JRB_FA;
    private JRadioButton JRB_FB;
    private JTextArea JTxtArea;
    private JTable grid;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JPanel panelPersona;
    public JDateChooser txtFecha;
    public JTextField txtVacunador;
    private ConsultasMySQL consultas = new ConsultasMySQL();
    private Metodos metodos = new Metodos();
    private long idProfesional = 0;

    public Vacunacion(String Historia2, clasePyP clase, boolean xAgenda, Long xIdOrden, Long xIdIngreso, Long xIdProfesional, String nombreVacunador) {
        this.xIdOrden = 0L;
        initComponents();
        this.clasepyp = clase;
        this.xIdOrden = xIdOrden.longValue();
        this.xIdIngreso = xIdIngreso.longValue();
        this.xAgenda = xAgenda;
        this.nombreVacunador = nombreVacunador;
        System.err.println("Vacunador -->" + this.nombreVacunador);
        if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL LOCAL DE MONTELIBANO") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO CAMU DIVINO NIÑO")) {
            this.JRB_FB.setSelected(true);
        }
        cargarPanelPersona();
        crearGrid();
        if (Principal.informacionIps.getNombreIps().equals("CLINICA PAJONAL S.A.S")) {
            this.txtVacunador.setText("CLINICA PAJONAL S.A.S");
            this.txtVacunador.setEnabled(false);
        } else {
            this.txtVacunador.setText(this.nombreVacunador);
        }
        this.txtFecha.setDate(this.metodos.getFechaActual());
        if (!Historia2.equals("0")) {
            this.frmPersona.txtHistoria.setText(Historia2);
            this.frmPersona.buscar(2);
        }
    }

    private void cargarPanelPersona() {
        this.frmPersona = new Persona(this);
        this.frmPersona.setBounds(1, 1, 950, 160);
        this.panelPersona.add(this.frmPersona);
        this.panelPersona.setVisible(true);
        this.frmPersona.setVisible(true);
    }

    public void buscar() {
        BuscarPersona frmBuscarP = new BuscarPersona(null, true, this.frmPersona);
        frmBuscarP.setVisible(true);
    }

    public void borrar() {
        if (this.grid.getSelectedRow() != -1) {
            int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de eliminar?", "CONFIRMACIÓN", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                this.sql = "UPDATE p_vacunacion_carnet  SET FechaVacuna = '', Vacunador = '' , Observacion =''WHERE (IdEsquema = '" + this.modelo.getValueAt(this.grid.getSelectedRow(), 0).toString() + "' AND IdPaciente = '" + this.frmPersona.getIdPersona() + "')";
                this.consultas.ejecutarSQL(this.sql);
                this.consultas.cerrarConexionBd();
                this.metodos.mostrarMensaje("Vacuna Borrada del Esquema");
                cargarCarnet();
                return;
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar dosis a borrar", "VERIFICACIÓN", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    public void cargarCarnet() {
        this.sql = "SELECT p_vacunacion_carnet.IdEsquema, p_vacunacion_vacunas.Nbre, p_vacunacion_dosis.Nbre, p_vacunacion_edad.Nbre, p_vacunacion_carnet.FechaVacuna, p_vacunacion_carnet.Vacunador, p_vacunacion_carnet.Observacion FROM  p_vacunacion_esquema INNER JOIN  p_vacunacion_vacunas ON (p_vacunacion_esquema.IdVacuna = p_vacunacion_vacunas.Id) INNER JOIN  p_vacunacion_dosis ON (p_vacunacion_esquema.IdDosis = p_vacunacion_dosis.Id) INNER JOIN  p_vacunacion_edad ON (p_vacunacion_esquema.IdEdad = p_vacunacion_edad.Id) INNER JOIN  p_vacunacion_carnet ON (p_vacunacion_carnet.IdEsquema = p_vacunacion_esquema.Id) WHERE (p_vacunacion_esquema.Estado=1 and p_vacunacion_carnet.IdPaciente ='" + this.frmPersona.getIdPersona() + "') ORDER BY p_vacunacion_vacunas.Id ASC, p_vacunacion_dosis.Id ASC";
        this.rs = this.consultas.traerRs(this.sql);
        try {
            if (this.rs.next()) {
                mCargar_Esquema();
            } else {
                ConsultasMySQL xct = new ConsultasMySQL();
                this.sql = "SELECT Id, IdVacuna, IdDosis, IdEdad FROM  p_vacunacion_esquema";
                ResultSet xrs = xct.traerRs(this.sql);
                while (xrs.next()) {
                    crearEsquema(xrs.getString(1));
                }
                this.frmPersona.buscar(2);
                xrs.close();
                xct.cerrarConexionBd();
                mCargar_Esquema();
            }
        } catch (SQLException ex) {
            this.consultas.mostrarErrorSQL(ex);
        }
    }

    private void crearEsquema(String esquema) {
        ConsultasMySQL xct = new ConsultasMySQL();
        this.sql = "INSERT INTO p_vacunacion_carnet(IdEsquema, IdPaciente, Fecha, UsuarioS) VALUES('" + esquema + "','" + this.frmPersona.getIdPersona() + "','" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
        xct.ejecutarSQL(this.sql);
        xct.cerrarConexionBd();
    }

    private void mCargar_Esquema() {
        try {
            if (this.JRB_FA.isSelected()) {
                this.sql = "SELECT p_vacunacion_carnet.IdEsquema, p_vacunacion_vacunas.Nbre, p_vacunacion_dosis.Nbre, p_vacunacion_edad.Nbre,  IFNULL(p_vacunacion_carnet.FechaVacuna,'')FechaVacuna , IFNULL(p_vacunacion_carnet.Vacunador, '')Vacunador,IFNULL(p_vacunacion_carnet.`Observacion`,'')AS obsevacion , if(p_vacunacion_carnet.FechaVacuna='', false, true) aplicada , IF( IFNULL(p_vacunacion_carnet.Vacunador, '')='',IF(IFNULL(d.Id_Procedimiento, 0)=0, 0, 1), 0) validar, p_vacunacion_vacunas.esCovid FROM  p_vacunacion_esquema INNER JOIN  p_vacunacion_vacunas ON (p_vacunacion_esquema.IdVacuna = p_vacunacion_vacunas.Id) INNER JOIN  p_vacunacion_dosis ON (p_vacunacion_esquema.IdDosis = p_vacunacion_dosis.Id) INNER JOIN  p_vacunacion_edad ON (p_vacunacion_esquema.IdEdad = p_vacunacion_edad.Id) INNER JOIN  p_vacunacion_carnet ON (p_vacunacion_carnet.IdEsquema = p_vacunacion_esquema.Id) LEFT JOIN (SELECT `f_itemordenesproced`.`Id_Procedimiento`\nFROM `f_ordenes` INNER JOIN  `ingreso`  ON (`f_ordenes`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN  `f_itemordenesproced`  ON (`f_itemordenesproced`.`Id_Ordenes` = `f_ordenes`.`Id`)\nWHERE (`ingreso`.`Estado` =0\n    AND `f_ordenes`.`Estado` =0\n    AND `f_ordenes`.`Id` ='" + this.xIdOrden + "')) d ON (d.Id_Procedimiento=p_vacunacion_vacunas.`Id_Procedimiento`)  WHERE (p_vacunacion_carnet.IdPaciente ='" + this.frmPersona.getIdPersona() + "') ORDER BY p_vacunacion_vacunas.Nbre, p_vacunacion_dosis.Id ASC";
            } else if (this.JRB_FB.isSelected()) {
                if (this.JCH_FitroEdad.isSelected()) {
                    this.sql = "SELECT p_vacunacion_carnet.IdEsquema, p_vacunacion_vacunas.Nbre, p_vacunacion_dosis.Nbre, p_vacunacion_edad.Nbre,  IFNULL(p_vacunacion_carnet.FechaVacuna,'')FechaVacuna , IFNULL(p_vacunacion_carnet.Vacunador, '')Vacunador, IFNULL (p_vacunacion_carnet.`Observacion`,'')AS obsevacion, IF(p_vacunacion_carnet.FechaVacuna='', FALSE, TRUE) aplicada, IF( IFNULL(p_vacunacion_carnet.Vacunador, '')='',IF(IFNULL(d.Id_Procedimiento, 0)=0, 0, 1), 0) validar \n, `p_vacunacion_edad`.EdadI, `p_vacunacion_edad`.EdadF\n, IF(IFNULL(p_vacunacion_carnet.FechaVacuna,'')='', p_vacunacion_edad.EdadF, 560000) EdadFM , DATEDIFF(NOW(), g_persona.`FechaNac`) Edad\n,`p_vacunacion_esquema`.Sexo, g_persona.`Id_Sexo`, p_vacunacion_vacunas.esCovid\nFROM  p_vacunacion_esquema \nINNER JOIN  p_vacunacion_vacunas ON (p_vacunacion_esquema.IdVacuna = p_vacunacion_vacunas.Id) \nINNER JOIN  p_vacunacion_dosis ON (p_vacunacion_esquema.IdDosis = p_vacunacion_dosis.Id) \nINNER JOIN  p_vacunacion_edad ON (p_vacunacion_esquema.IdEdad = p_vacunacion_edad.Id) \nINNER JOIN  p_vacunacion_carnet ON (p_vacunacion_carnet.IdEsquema = p_vacunacion_esquema.Id) \nINNER JOIN  `g_persona` ON (g_persona.`Id` = p_vacunacion_carnet.`IdPaciente`) \nLEFT JOIN (SELECT `f_itemordenesproced`.`Id_Procedimiento`\nFROM `f_ordenes` INNER JOIN  `ingreso`  ON (`f_ordenes`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN  `f_itemordenesproced`  ON (`f_itemordenesproced`.`Id_Ordenes` = `f_ordenes`.`Id`)\nWHERE (`ingreso`.`Estado` =0\n    AND `f_ordenes`.`Estado` =0\n    AND `f_ordenes`.`Id` ='" + this.xIdOrden + "')) d ON (d.Id_Procedimiento=p_vacunacion_vacunas.`Id_Procedimiento`)  \n    WHERE (p_vacunacion_carnet.IdPaciente ='" + this.frmPersona.getIdPersona() + "'\n     AND `p_vacunacion_esquema`.Sexo  IN('A', g_persona.`Id_Sexo`)\n       AND (DATEDIFF(NOW(), g_persona.`FechaNac`)>=`p_vacunacion_edad`.EdadI AND DATEDIFF(NOW(), g_persona.`FechaNac`)<=IF(IFNULL(p_vacunacion_carnet.FechaVacuna,'')='', p_vacunacion_edad.EdadF, 560000))\n    ) ORDER BY p_vacunacion_esquema.`NOrden` ASC ";
                } else {
                    this.sql = "SELECT p_vacunacion_carnet.IdEsquema, p_vacunacion_vacunas.Nbre, p_vacunacion_dosis.Nbre, p_vacunacion_edad.Nbre,  IFNULL(p_vacunacion_carnet.FechaVacuna,'')FechaVacuna , IFNULL(p_vacunacion_carnet.Vacunador, '')Vacunador, IFNULL (p_vacunacion_carnet.`Observacion`,'')AS obsevacion, IF(p_vacunacion_carnet.FechaVacuna='', FALSE, TRUE) aplicada, IF( IFNULL(p_vacunacion_carnet.Vacunador, '')='',IF(IFNULL(d.Id_Procedimiento, 0)=0, 0, 1), 0) validar \n, `p_vacunacion_edad`.EdadI, `p_vacunacion_edad`.EdadF\n, IF(IFNULL(p_vacunacion_carnet.FechaVacuna,'')='', p_vacunacion_edad.EdadF, 560000) EdadFM , DATEDIFF(NOW(), g_persona.`FechaNac`) Edad\n,`p_vacunacion_esquema`.Sexo, g_persona.`Id_Sexo`, p_vacunacion_vacunas.esCovid\nFROM  p_vacunacion_esquema \nINNER JOIN  p_vacunacion_vacunas ON (p_vacunacion_esquema.IdVacuna = p_vacunacion_vacunas.Id) \nINNER JOIN  p_vacunacion_dosis ON (p_vacunacion_esquema.IdDosis = p_vacunacion_dosis.Id) \nINNER JOIN  p_vacunacion_edad ON (p_vacunacion_esquema.IdEdad = p_vacunacion_edad.Id) \nINNER JOIN  p_vacunacion_carnet ON (p_vacunacion_carnet.IdEsquema = p_vacunacion_esquema.Id) \nINNER JOIN  `g_persona` ON (g_persona.`Id` = p_vacunacion_carnet.`IdPaciente`) \nLEFT JOIN (SELECT `f_itemordenesproced`.`Id_Procedimiento`\nFROM `f_ordenes` INNER JOIN  `ingreso`  ON (`f_ordenes`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN  `f_itemordenesproced`  ON (`f_itemordenesproced`.`Id_Ordenes` = `f_ordenes`.`Id`)\nWHERE (`ingreso`.`Estado` =0\n    AND `f_ordenes`.`Estado` =0\n    AND `f_ordenes`.`Id` ='" + this.xIdOrden + "')) d ON (d.Id_Procedimiento=p_vacunacion_vacunas.`Id_Procedimiento`)  \n    WHERE (p_vacunacion_carnet.IdPaciente ='" + this.frmPersona.getIdPersona() + "'\n     AND `p_vacunacion_esquema`.Sexo  IN('A', g_persona.`Id_Sexo`)\n       \n    ) ORDER BY p_vacunacion_esquema.`NOrden` ASC ";
                }
            }
            crearGrid();
            this.rs = this.consultas.traerRs(this.sql);
            if (this.rs.next()) {
                this.rs.beforeFirst();
                int x = 0;
                while (this.rs.next()) {
                    this.modelo.addRow(this.dato);
                    this.modelo.setValueAt(this.rs.getString(1), x, 0);
                    this.modelo.setValueAt(this.rs.getString(2), x, 1);
                    this.modelo.setValueAt(this.rs.getString(3), x, 2);
                    this.modelo.setValueAt(this.rs.getString(4), x, 3);
                    this.modelo.setValueAt(this.rs.getString(5), x, 4);
                    this.modelo.setValueAt(this.rs.getString(6), x, 5);
                    this.modelo.setValueAt(this.rs.getString(7), x, 6);
                    this.modelo.setValueAt(Boolean.valueOf(this.rs.getBoolean("aplicada")), x, 7);
                    this.modelo.setValueAt(Integer.valueOf(this.rs.getInt("validar")), x, 8);
                    this.modelo.setValueAt(Boolean.valueOf(this.rs.getBoolean("esCovid")), x, 9);
                    this.grid.setDefaultRenderer(Object.class, new MiRender2());
                    x++;
                }
            }
            this.rs.close();
            this.consultas.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(Vacunacion.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearGrid() {
        this.modelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Vacuna", "Dosis", "Edad", "Fecha", "Vacunador", "Observacion", "Aplicar?", "V", "esCovid"}) { // from class: PyP.Vacunacion.1
            Class[] types = {Long.class, String.class, String.class, String.class, String.class, String.class, String.class, Boolean.class, Integer.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, true, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.grid.setModel(this.modelo);
        this.grid.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.grid.getColumnModel().getColumn(0).setMinWidth(0);
        this.grid.getColumnModel().getColumn(0).setMaxWidth(0);
        this.grid.getColumnModel().getColumn(1).setPreferredWidth(250);
        this.grid.getColumnModel().getColumn(2).setPreferredWidth(50);
        this.grid.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.grid.getColumnModel().getColumn(4).setPreferredWidth(50);
        this.grid.getColumnModel().getColumn(5).setPreferredWidth(150);
        this.grid.getColumnModel().getColumn(6).setPreferredWidth(150);
        this.grid.getColumnModel().getColumn(7).setPreferredWidth(10);
        this.grid.getColumnModel().getColumn(8).setPreferredWidth(0);
        this.grid.getColumnModel().getColumn(8).setMinWidth(0);
        this.grid.getColumnModel().getColumn(8).setMaxWidth(0);
        this.grid.getColumnModel().getColumn(9).setPreferredWidth(0);
        this.grid.getColumnModel().getColumn(9).setMinWidth(0);
        this.grid.getColumnModel().getColumn(9).setMaxWidth(0);
    }

    public void grabar() {
        if (!this.frmPersona.getIdPersona().equals("0")) {
            if (this.txtVacunador.getText().isEmpty()) {
                this.metodos.mostrarMensaje("Por favor escriba el nombre del Vacunador");
                this.txtVacunador.requestFocus();
                return;
            }
            for (int x = 0; x < this.grid.getRowCount(); x++) {
                if (Boolean.valueOf(this.modelo.getValueAt(x, 7).toString()).booleanValue() && this.modelo.getValueAt(x, 4).toString().equals("")) {
                    this.sql = "UPDATE p_vacunacion_carnet SET FechaVacuna = '" + this.metodos.formatoAMD1.format(this.txtFecha.getDate()) + "', Vacunador = '" + this.txtVacunador.getText() + "', IdIngreso = '" + this.xIdIngreso + "', Observacion = '" + this.JTxtArea.getText() + "', UsuarioS = '" + Principal.usuarioSistemaDTO.getLogin() + "', Fecha = now()  WHERE (IdEsquema ='" + this.modelo.getValueAt(x, 0) + "' AND IdPaciente = '" + this.frmPersona.getIdPersona() + "')";
                    this.consultas.ejecutarSQL(this.sql);
                    this.consultas.cerrarConexionBd();
                    System.out.println("Observacion" + this.sql);
                }
            }
            mActualizarEstadoOrden();
            cargarCarnet();
            return;
        }
        this.frmPersona.grabar();
        mCargar_Esquema();
    }

    private void mActualizarEstadoOrden() {
        this.sql = "update f_ordenes set EstadoRecep=1 where Id='" + this.xIdOrden + "'";
        this.consultas.ejecutaSQLUpdate(this.sql);
        this.consultas.cerrarConexionBd();
    }

    public void imprimirCarnet() {
        String[][] parametros = new String[3][2];
        parametros[0][0] = "IdPaciente";
        parametros[0][1] = this.frmPersona.getIdPersona();
        parametros[1][0] = "SUBREPORT_DIR";
        parametros[1][1] = this.metodos.getSO() + this.metodos.getBarra() + "Reportes" + this.metodos.getBarra();
        parametros[2][0] = "SUBREPORTFIRMA_DIR";
        parametros[2][1] = this.metodos.getSO() + this.metodos.getBarra() + "Firmas" + this.metodos.getBarra();
        String nbreArchivo = null;
        Boolean esCovid = false;
        int x = 0;
        while (true) {
            if (x >= this.grid.getRowCount()) {
                break;
            }
            if (!Boolean.valueOf(this.grid.getValueAt(x, 9).toString()).booleanValue()) {
                x++;
            } else {
                esCovid = true;
                break;
            }
        }
        if (esCovid.booleanValue()) {
            Object[] botones = {"Carnet", "Certificado Covid", "Cerrar"};
            int n = JOptionPane.showInternalOptionDialog(this, "Que desea visualizar?", "VISUALIZACIÓN", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), botones, "Cerrar");
            if (n == 0) {
                if (Principal.informacionIps.getEsFpz().intValue() == 0) {
                    nbreArchivo = "P_CarnetVacunacion";
                } else {
                    nbreArchivo = "P_CarnetVacunacion_1";
                }
            } else if (n == 1) {
                if (Principal.informacionIps.getEsFpz().intValue() == 0) {
                    nbreArchivo = "P_CarnetVacunacion_covid";
                } else {
                    nbreArchivo = "P_CarnetVacunacion_covid_1";
                }
            }
        } else if (Principal.informacionIps.getEsFpz().intValue() == 0) {
            nbreArchivo = "P_CarnetVacunacion";
        } else {
            nbreArchivo = "P_CarnetVacunacion_1";
        }
        this.metodos.GenerarPDF(this.metodos.getRutaRep() + nbreArchivo, parametros);
    }

    public void nuevo() {
        this.frmPersona.nuevo();
        this.txtFecha.setDate(this.metodos.getFechaActual());
        crearGrid();
        this.txtVacunador.setText("");
        this.JTxtArea.setText("");
    }

    /* JADX WARN: Type inference failed for: r3v13, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBG_Forma = new ButtonGroup();
        this.JBG_FiltroEdad = new ButtonGroup();
        this.panelPersona = new JPanel();
        this.txtVacunador = new JTextField();
        this.jScrollPane1 = new JScrollPane();
        this.grid = new JTable();
        this.JBTAjustarEsquema = new JButton();
        this.JPI_Orden = new JPanel();
        this.JRB_FA = new JRadioButton();
        this.JRB_FB = new JRadioButton();
        this.txtFecha = new JDateChooser();
        this.jScrollPane2 = new JScrollPane();
        this.JTxtArea = new JTextArea();
        this.JPI_FiltroEdad = new JPanel();
        this.JCH_MostrarTodo = new JCheckBox();
        this.JCH_FitroEdad = new JCheckBox();
        this.JBTEventoAdverso1 = new JButton();
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("ESQUEMA DE VACUNACIÓN UNICO");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setMaximumSize(null);
        setMinimumSize(null);
        setName("Vacunacion");
        addInternalFrameListener(new InternalFrameListener() { // from class: PyP.Vacunacion.2
            public void internalFrameOpened(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                Vacunacion.this.formInternalFrameClosing(evt);
            }

            public void internalFrameClosed(InternalFrameEvent evt) {
            }

            public void internalFrameIconified(InternalFrameEvent evt) {
            }

            public void internalFrameDeiconified(InternalFrameEvent evt) {
            }

            public void internalFrameActivated(InternalFrameEvent evt) {
                Vacunacion.this.formInternalFrameActivated(evt);
            }

            public void internalFrameDeactivated(InternalFrameEvent evt) {
            }
        });
        this.panelPersona.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS DE USUARIO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        GroupLayout panelPersonaLayout = new GroupLayout(this.panelPersona);
        this.panelPersona.setLayout(panelPersonaLayout);
        panelPersonaLayout.setHorizontalGroup(panelPersonaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 942, 32767));
        panelPersonaLayout.setVerticalGroup(panelPersonaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 171, 32767));
        this.txtVacunador.setFont(new Font("Arial", 1, 12));
        this.txtVacunador.setBorder(BorderFactory.createTitledBorder((Border) null, "Vacunador", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.txtVacunador.setFocusCycleRoot(true);
        this.txtVacunador.addMouseListener(new MouseAdapter() { // from class: PyP.Vacunacion.3
            public void mouseClicked(MouseEvent evt) {
                Vacunacion.this.txtVacunadorMouseClicked(evt);
            }
        });
        this.jScrollPane1.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.grid.setFont(new Font("Arial", 1, 12));
        this.grid.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.grid.setRowHeight(25);
        this.grid.setSelectionBackground(new Color(255, 255, 255));
        this.grid.setSelectionForeground(new Color(255, 0, 0));
        this.grid.setSelectionMode(0);
        this.jScrollPane1.setViewportView(this.grid);
        this.JBTAjustarEsquema.setFont(new Font("Arial", 1, 12));
        this.JBTAjustarEsquema.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTAjustarEsquema.setText("Ajustar Esquema");
        this.JBTAjustarEsquema.addActionListener(new ActionListener() { // from class: PyP.Vacunacion.4
            public void actionPerformed(ActionEvent evt) {
                Vacunacion.this.JBTAjustarEsquemaActionPerformed(evt);
            }
        });
        this.JPI_Orden.setBorder(BorderFactory.createTitledBorder((Border) null, "ORDENAR DETALLE", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JBG_Forma.add(this.JRB_FA);
        this.JRB_FA.setFont(new Font("Arial", 1, 12));
        this.JRB_FA.setText("Forma A");
        this.JRB_FA.addActionListener(new ActionListener() { // from class: PyP.Vacunacion.5
            public void actionPerformed(ActionEvent evt) {
                Vacunacion.this.JRB_FAActionPerformed(evt);
            }
        });
        this.JBG_Forma.add(this.JRB_FB);
        this.JRB_FB.setFont(new Font("Arial", 1, 12));
        this.JRB_FB.setSelected(true);
        this.JRB_FB.setText("Forma B");
        this.JRB_FB.addActionListener(new ActionListener() { // from class: PyP.Vacunacion.6
            public void actionPerformed(ActionEvent evt) {
                Vacunacion.this.JRB_FBActionPerformed(evt);
            }
        });
        GroupLayout JPI_OrdenLayout = new GroupLayout(this.JPI_Orden);
        this.JPI_Orden.setLayout(JPI_OrdenLayout);
        JPI_OrdenLayout.setHorizontalGroup(JPI_OrdenLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_OrdenLayout.createSequentialGroup().addContainerGap().addComponent(this.JRB_FA).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRB_FB).addContainerGap(20, 32767)));
        JPI_OrdenLayout.setVerticalGroup(JPI_OrdenLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_OrdenLayout.createSequentialGroup().addContainerGap(-1, 32767).addGroup(JPI_OrdenLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRB_FA).addComponent(this.JRB_FB))));
        this.txtFecha.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.txtFecha.setDateFormatString("dd/MM/yyyy");
        this.txtFecha.setFont(new Font("Arial", 1, 12));
        this.txtFecha.addPropertyChangeListener(new PropertyChangeListener() { // from class: PyP.Vacunacion.7
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                Vacunacion.this.txtFechaPropertyChange(evt);
            }
        });
        this.JTxtArea.setColumns(20);
        this.JTxtArea.setFont(new Font("Arial", 1, 12));
        this.JTxtArea.setRows(5);
        this.JTxtArea.setBorder(BorderFactory.createTitledBorder((Border) null, "Observacion", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jScrollPane2.setViewportView(this.JTxtArea);
        this.JPI_FiltroEdad.setBorder(BorderFactory.createTitledBorder((Border) null, "FILTRO POR EDAD", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JBG_FiltroEdad.add(this.JCH_MostrarTodo);
        this.JCH_MostrarTodo.setFont(new Font("Arial", 1, 12));
        this.JCH_MostrarTodo.setText("Todo");
        this.JCH_MostrarTodo.addActionListener(new ActionListener() { // from class: PyP.Vacunacion.8
            public void actionPerformed(ActionEvent evt) {
                Vacunacion.this.JCH_MostrarTodoActionPerformed(evt);
            }
        });
        this.JBG_FiltroEdad.add(this.JCH_FitroEdad);
        this.JCH_FitroEdad.setFont(new Font("Arial", 1, 12));
        this.JCH_FitroEdad.setSelected(true);
        this.JCH_FitroEdad.setText("Filtrado");
        this.JCH_FitroEdad.addActionListener(new ActionListener() { // from class: PyP.Vacunacion.9
            public void actionPerformed(ActionEvent evt) {
                Vacunacion.this.JCH_FitroEdadActionPerformed(evt);
            }
        });
        GroupLayout JPI_FiltroEdadLayout = new GroupLayout(this.JPI_FiltroEdad);
        this.JPI_FiltroEdad.setLayout(JPI_FiltroEdadLayout);
        JPI_FiltroEdadLayout.setHorizontalGroup(JPI_FiltroEdadLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_FiltroEdadLayout.createSequentialGroup().addContainerGap().addComponent(this.JCH_MostrarTodo).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCH_FitroEdad).addContainerGap(-1, 32767)));
        JPI_FiltroEdadLayout.setVerticalGroup(JPI_FiltroEdadLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_FiltroEdadLayout.createSequentialGroup().addGroup(JPI_FiltroEdadLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCH_MostrarTodo).addComponent(this.JCH_FitroEdad)).addGap(0, 6, 32767)));
        this.JBTEventoAdverso1.setFont(new Font("Arial", 1, 10));
        this.JBTEventoAdverso1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Evento Adverso.png")));
        this.JBTEventoAdverso1.setText("Casos de Seguridad del paciente");
        this.JBTEventoAdverso1.setToolTipText("Evento Adverso");
        this.JBTEventoAdverso1.addActionListener(new ActionListener() { // from class: PyP.Vacunacion.10
            public void actionPerformed(ActionEvent evt) {
                Vacunacion.this.JBTEventoAdverso1ActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane1)).addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.panelPersona, -2, -1, -2)).addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.jScrollPane2, -2, 506, -2).addGap(39, 39, 39).addComponent(this.JPI_Orden, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBTEventoAdverso1).addGap(0, 10, 32767)).addGroup(layout.createSequentialGroup().addComponent(this.txtFecha, -2, 131, -2).addGap(18, 18, 18).addComponent(this.txtVacunador).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPI_FiltroEdad, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBTAjustarEsquema, -2, 167, -2))))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(10, 10, 10).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(layout.createSequentialGroup().addComponent(this.panelPersona, -2, -1, -2).addGap(14, 14, 14).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPI_FiltroEdad, GroupLayout.Alignment.TRAILING, -2, -1, -2).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.txtFecha, -2, 50, -2).addComponent(this.txtVacunador, -2, 51, -2)))).addComponent(this.JBTAjustarEsquema, -2, 50, -2)).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(38, 38, 38).addComponent(this.JPI_Orden, -2, -1, -2)).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane2, GroupLayout.Alignment.TRAILING, -2, 72, -2).addComponent(this.JBTEventoAdverso1, GroupLayout.Alignment.TRAILING, -2, 62, -2)))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.jScrollPane1, -2, 380, -2).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameActivated(InternalFrameEvent evt) {
        this.clasepyp.frmPrincipal.mActivarBarraMenu(this.clasepyp.frmPrincipal.xMenus.barraMnuPyP, 15);
        this.metodos.limpiarDatosPrincipal();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTAjustarEsquemaActionPerformed(ActionEvent evt) {
        if (!this.frmPersona.getIdPersona().isEmpty()) {
            mAjustarEsquema();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_FAActionPerformed(ActionEvent evt) {
        if (!this.frmPersona.getIdPersona().equals("0")) {
            mCargar_Esquema();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_FBActionPerformed(ActionEvent evt) {
        if (!this.frmPersona.getIdPersona().equals("0")) {
            mCargar_Esquema();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtVacunadorMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            mBuscarVacunador(this.txtVacunador);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtFechaPropertyChange(PropertyChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosing(InternalFrameEvent evt) {
        if (this.xAgenda) {
            this.clasepyp.xJIFAgendaVacunacion.setVisible(true);
            dispose();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_MostrarTodoActionPerformed(ActionEvent evt) {
        mCargar_Esquema();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_FitroEdadActionPerformed(ActionEvent evt) {
        mCargar_Esquema();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTEventoAdverso1ActionPerformed(ActionEvent evt) {
        if (this.xIdIngreso != 0) {
            JDGenericoPanel detalle = new JDGenericoPanel(null, true, "Evento Adverso", String.valueOf(this.xIdIngreso), 29);
            detalle.setLocationRelativeTo(this);
            detalle.setVisible(true);
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Se debe cargar un ingreso", "Verificar", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    private void mBuscarVacunador(JTextField codigo) {
        JDBuscarProfesional pac = new JDBuscarProfesional(codigo, "Vacunacion", null, true);
        pac.setVisible(true);
    }

    private void mAjustarEsquema() {
        try {
            ConsultasMySQL xconsultas = new ConsultasMySQL();
            ResultSet xrs = this.consultas.traerRs("SELECT Id FROM  p_vacunacion_esquema WHERE (IdTipoEsquema =001)");
            if (xrs.next()) {
                xrs.beforeFirst();
                while (xrs.next()) {
                    ResultSet xrs1 = xconsultas.traerRs("SELECT IdEsquema FROM  p_vacunacion_carnet WHERE (IdEsquema='" + xrs.getString(1) + "' AND IdPaciente ='" + this.frmPersona.getIdPersona() + "')");
                    if (!xrs1.next()) {
                        this.sql = "insert into p_vacunacion_carnet(IdEsquema, IdPaciente, UsuarioS, Fecha) Values ('" + xrs.getInt(1) + "','" + this.frmPersona.getIdPersona() + "','" + Principal.usuarioSistemaDTO.getLogin() + "','" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "')";
                        this.consultas.ejecutarSQL(this.sql);
                    }
                    xrs1.close();
                    xconsultas.cerrarConexionBd();
                }
            }
            cargarCarnet();
            xrs.close();
            this.consultas.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(Vacunacion.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX INFO: loaded from: GenomaP.jar:PyP/Vacunacion$MiRender2.class */
    public static class MiRender2 extends DefaultTableCellRenderer {
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (table.getValueAt(row, 8) != null) {
                if (Long.valueOf(table.getValueAt(row, 8).toString()).longValue() == 1) {
                    cell.setBackground(new Color(177, 251, 177));
                    cell.setForeground(Color.BLACK);
                } else {
                    cell.setBackground(Color.WHITE);
                    cell.setForeground(Color.BLACK);
                }
            }
            return cell;
        }
    }
}
