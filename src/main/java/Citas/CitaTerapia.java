package Citas;

import Acceso.Principal;
import General.Anular;
import General.Persona;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.genoma.plus.controller.citas.JDConsultarIngreso;
import com.genoma.plus.controller.citas.JIFCarneCitas;
import com.genoma.plus.dao.citas.CitasDAO;
import com.genoma.plus.dao.impl.citas.CitasDAOImpl;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.beans.PropertyVetoException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:Citas/CitaTerapia.class */
public class CitaTerapia extends JInternalFrame {
    private Calendario frmCalendario;
    public Persona frmPersona;
    private clasesCita xclasescita;
    public String[] listaDiasFestivos;
    public String[] xidempresafac;
    public String[] xidsede;
    public String[][] listaProfesional;
    public String[][] listaClaseCita;
    public int filaArbol;
    public ResultSet rs;
    public String sql;
    public String nbreProfesional;
    public String especialAnterior;
    public String idCita;
    public static String NoCitaIps;
    public DefaultMutableTreeNode rama;
    public DefaultMutableTreeNode hoja;
    public Object[] dato;
    public DefaultTableModel modeloGrid;
    private hiloCitasT hCitaT;
    private Thread hilo;
    private CitasDAO xCitasDAO;
    public JTree Arbol;
    private JComboBox JCBEmpresa;
    private JComboBox JCBSede;
    private JMenuItem JMIFacturacion;
    private JFormattedTextField JTFFNCitas;
    public JFormattedTextField JTFFNorden;
    private JComboBox cboClaseCita;
    public JTable grid;
    private ButtonGroup grupoRemision;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JPanel jPanel1;
    private JPanel jPanel5;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane3;
    private JSeparator jSeparator1;
    private JSeparator jSeparator2;
    private JLabel lblFecha;
    private JMenuItem mnAsignar;
    private JMenuItem mnCertificado;
    private JMenuItem mnDesistir;
    private JMenuItem mnLlamar;
    private JPopupMenu mnPopup;
    private JMenuItem mnReasignar;
    private JMenuItem mnRecordatorio;
    private JMenuItem mnRecordatorio1;
    private JMenuItem mnSalir;
    private JPanel panelCalendario;
    private JPanel panelPersonas;
    public static JTextField txtConsultorio;
    private JTextField txtDuracion;
    private Metodos metodos = new Metodos();
    private ConsultasMySQL consultas = new ConsultasMySQL();
    public int filaGrid = 0;
    public int motivoDesistida = 1;
    public String[][] listaDiasConCita = new String[1000][7];
    public String[][] listaPacientesConCita = new String[0][0];
    public int filaListaDiasConCita = 0;
    public int comboLleno = 0;
    public int combocc = 0;
    public String idEspecialidad = "";
    private GregorianCalendar fechaActual = new GregorianCalendar();
    public DefaultMutableTreeNode tallo = new DefaultMutableTreeNode("Especialidades");
    public DefaultTreeModel modeloArbol = new DefaultTreeModel(this.tallo);
    public DefaultMutableTreeNode nodo = new DefaultMutableTreeNode();
    private int citaTelefonica = 0;
    private int citaPrimerVez = 0;
    public int remitida = -1;
    private String horaUltima = "";
    private int idReasignar = 0;
    private int grabarCita = 0;
    private String NoCitaAReasignar = "0";
    private ImageIcon rootIcon = new ImageIcon(getClass().getResource("/Imagenes/AgendaMedica.png"));
    private ImageIcon especialidadIcon = new ImageIcon(getClass().getResource("/Imagenes/Especialidad_16.png"));
    private ImageIcon medicoIcon = new ImageIcon(getClass().getResource("/Imagenes/Profesiona_16x20.png"));
    private String xIdIngreso = "0";
    private String idConsultorio = "1";

    public CitaTerapia(clasesCita clase) {
        initComponents();
        this.Arbol.setCellRenderer(new MyTreeCellRenderer());
        this.xclasescita = clase;
        this.lblFecha.setText(this.metodos.formatoFecha.format(this.metodos.getFechaActual()).toUpperCase());
        cargarPanelPersonas();
        cargarPanelCalendario();
        springStart();
        this.hCitaT = new hiloCitasT(this);
        this.hilo = new Thread(this.hCitaT);
        crearGrid();
        cargarArbol();
        cargarNoCitaIps();
        this.hilo.start();
        mllenarComboEmpresaFac();
        if (Principal.informacionIps.getEsFpz().intValue() == 1) {
            this.JTFFNorden.setBorder(BorderFactory.createTitledBorder((Border) null, "N° INGRESO", 0, 0, new Font("Arial", 1, 12)));
        }
        nuevo();
    }

    private void springStart() {
        this.xCitasDAO = (CitasDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("citasDAO");
    }

    public void mCargarClaseCitas(int xfiltro, String xFecha, String xSexo) {
        if (Principal.informacionIps.getNombreIps().equals("IPS TERAPIAS Y ESTETICA INTEGRAL SAS") || Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN JUAN DE DIOS - Segovia") || Principal.informacionIps.getIdentificacion().equals("812003851") || Principal.informacionIps.getIdentificacion().equals("900017536")) {
            List<Object[]> list = this.xCitasDAO.consultarIngreso(0, this.frmPersona.IdPersona, this.frmCalendario.getAno(), this.listaProfesional[this.filaArbol][2]);
            for (int x = 0; x < list.size(); x++) {
                this.JTFFNorden.setText(list.get(x)[0].toString());
            }
            if (list.isEmpty()) {
                this.JTFFNorden.setText("0");
            }
        }
    }

    private void cargarPanelCalendario() {
        this.frmCalendario = new Calendario(this);
        this.panelCalendario.setVisible(false);
        this.frmCalendario.setBounds(2, 2, 298, 296);
        this.panelCalendario.add(this.frmCalendario);
        this.frmCalendario.setVisible(true);
        this.panelCalendario.setVisible(true);
    }

    private void asignarCita() {
        this.mnPopup.setVisible(false);
        if (getValidarCampos() == 1) {
            if (this.idReasignar == 0) {
                grabar();
                cargarHorarioGrid();
                if (this.metodos.getPregunta("Cita Grabada, Desea ver el Recordatorio de Cita?") == 0) {
                    this.xclasescita.imprimirCita("0", this.cboClaseCita.getSelectedItem().toString(), this);
                }
            } else {
                modificarCita();
                cargarHorarioGrid();
                if (this.metodos.getPregunta("Cita reasignada, Desea ver el Recordatorio de Cita?") == 0) {
                    this.xclasescita.imprimirCita("0", this.cboClaseCita.getSelectedItem().toString(), this);
                }
            }
        }
        this.consultas.cerrarConexionBd();
    }

    private void mImprimirRecordatorio(int forma) {
        if (forma == 0) {
            Object[] botones = {"Simple", "Por N° Orden ", "Cerrar"};
            int n = JOptionPane.showInternalOptionDialog(this, "Como desea consultar el recordatorio?", "IMPRIMIR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), botones, "Cerrar");
            if (n == 0) {
                this.xclasescita.imprimirCita("0", this.cboClaseCita.getSelectedItem().toString(), this);
                return;
            }
            if (n == 1) {
                String[][] parametros = new String[7][2];
                parametros[0][0] = "fecha";
                parametros[0][1] = this.grid.getValueAt(this.filaGrid, 11).toString();
                parametros[1][0] = "nbreUsuario";
                parametros[1][1] = Principal.usuarioSistemaDTO.getNombreUsuario();
                parametros[2][0] = "ruta";
                parametros[2][1] = this.metodos.getRutaRep();
                parametros[3][0] = "idusuario";
                parametros[3][1] = this.grid.getValueAt(this.filaGrid, 4).toString();
                parametros[4][0] = "idEspecialidad";
                parametros[4][1] = this.idEspecialidad;
                parametros[5][0] = "SUBREPORT_DIR";
                parametros[5][1] = this.metodos.getSO() + this.metodos.getBarra() + "Reportes" + this.metodos.getBarra();
                parametros[6][0] = "SUBREPORTFIRMA_DIR";
                parametros[6][1] = this.metodos.getSO() + this.metodos.getBarra() + "Firmas" + this.metodos.getBarra();
                if (Principal.informacionIps.getNombreIps().equals("FUNDACIÓN PANZENÚ")) {
                    this.metodos.GenerarPDF(this.metodos.getRutaRep() + "C_RecordatorioDeCitaFTFecha", parametros);
                    return;
                } else {
                    this.metodos.GenerarPDF(this.metodos.getRutaRep() + "C_RecordatorioDeCitaFTFecha_1", parametros);
                    return;
                }
            }
            return;
        }
        String[][] parametros2 = new String[7][2];
        parametros2[0][0] = "fecha";
        parametros2[0][1] = this.grid.getValueAt(this.filaGrid, 11).toString();
        parametros2[1][0] = "nbreUsuario";
        parametros2[1][1] = Principal.usuarioSistemaDTO.getNombreUsuario();
        parametros2[2][0] = "ruta";
        parametros2[2][1] = this.metodos.getRutaRep();
        parametros2[3][0] = "idusuario";
        parametros2[3][1] = this.grid.getValueAt(this.filaGrid, 4).toString();
        parametros2[4][0] = "idEspecialidad";
        parametros2[4][1] = this.idEspecialidad;
        parametros2[5][0] = "SUBREPORT_DIR";
        parametros2[5][1] = this.metodos.getSO() + this.metodos.getBarra() + "Reportes" + this.metodos.getBarra();
        parametros2[6][0] = "SUBREPORTFIRMA_DIR";
        parametros2[6][1] = this.metodos.getSO() + this.metodos.getBarra() + "Firmas" + this.metodos.getBarra();
        if (Principal.informacionIps.getNombreIps().equals("FUNDACIÓN PANZENÚ")) {
            this.metodos.GenerarPDF(this.metodos.getRutaRep() + "C_Registro_SesionesRealizadas", parametros2);
        } else {
            this.metodos.GenerarPDF(this.metodos.getRutaRep() + "C_Registro_SesionesRealizadas", parametros2);
        }
    }

    private void mImprimirCertificado() {
        String[][] parametros = new String[9][2];
        parametros[0][0] = "fecha";
        parametros[0][1] = this.grid.getValueAt(this.filaGrid, 11).toString();
        parametros[1][0] = "nbreUsuario";
        parametros[1][1] = Principal.usuarioSistemaDTO.getNombreUsuario();
        parametros[2][0] = "ruta";
        parametros[2][1] = this.metodos.getRutaRep();
        parametros[3][0] = "idusuario";
        parametros[3][1] = this.grid.getValueAt(this.filaGrid, 4).toString();
        parametros[4][0] = "idEspecialidad";
        parametros[4][1] = this.idEspecialidad;
        parametros[5][0] = "SUBREPORT_DIR";
        parametros[5][1] = this.metodos.getSO() + this.metodos.getBarra() + "Reportes" + this.metodos.getBarra();
        parametros[6][0] = "SUBREPORTFIRMA_DIR";
        parametros[6][1] = this.metodos.getSO() + this.metodos.getBarra() + "Firmas" + this.metodos.getBarra();
        parametros[7][0] = "cargo";
        parametros[7][1] = Principal.usuarioSistemaDTO.getNombreCargoUsuario();
        parametros[8][0] = "urlFirma";
        parametros[8][1] = Principal.usuarioSistemaDTO.getUrlFirma();
        this.metodos.GenerarPDF(this.metodos.getRutaRep() + "C_CertificadoRecordatorioDeCitaFTFecha_1", parametros);
    }

    public void buscarUsuario() {
        this.frmPersona.buscar(2);
    }

    public void cargarPacienteConCita() {
        try {
            if (Principal.informacionIps.getEsFpz().intValue() == 0) {
                this.sql = "SELECT  `c_citas`.`HoraInicial`, `c_citas`.`HoraFinal`, `persona_fpz`.`NUsuario`, `c_clasecita`.`Duracion`, `c_citas`.`Id`, `persona_fpz`.`Id_persona`,c_clasecita.Nbre, EsTrabajador , `persona_fpz`.`NoHistoria`, c_citas.Asistida, c_citas.Id_ingreso, c_clasecita.Id_Programa, c_citas.Fecha_Cita, c_clasecita.Id_Procedimiento FROM  `c_citas` INNER JOIN  `c_clasecita`  ON (`c_citas`.`Id_ClaseCita` = `c_clasecita`.`Id`) INNER JOIN `persona_fpz`  ON (`persona_fpz`.`Id_persona` = `c_citas`.`Id_Usuario`) INNER JOIN  `f_empresacontxconvenio`  ON (`f_empresacontxconvenio`.`Id` = `c_citas`.`Id_EmpresaCont`) WHERE (`c_citas`.`Fecha_Cita` ='" + this.frmCalendario.getAno() + "-" + (Integer.parseInt(this.frmCalendario.getMes()) + 1) + "-" + this.frmCalendario.getDia() + "' AND `c_citas`.`Id_Profesional` ='" + this.listaProfesional[this.filaArbol][0] + "' AND `c_citas`.`Id_Especialidad` ='" + this.idEspecialidad + "' AND `c_citas`.`Id_MotivoDesistida` =1) ORDER BY `c_citas`.`HoraInicial` ASC ";
            } else {
                this.sql = "SELECT  `c_citas`.`HoraInicial`, `c_citas`.`HoraFinal`, `persona`.`NUsuario`, `c_clasecita`.`Duracion`, `c_citas`.`Id`, `persona`.`Id_persona`,c_clasecita.Nbre, 0 , `persona`.`NoHistoria`, c_citas.Asistida, c_citas.Id_ingreso, c_clasecita.Id_Programa, c_citas.Fecha_Cita, c_clasecita.Id_Procedimiento FROM  `c_citas` INNER JOIN  `c_clasecita`  ON (`c_citas`.`Id_ClaseCita` = `c_clasecita`.`Id`) INNER JOIN `persona`  ON (`persona`.`Id_persona` = `c_citas`.`Id_Usuario`) INNER JOIN  `f_empresacontxconvenio`  ON (`f_empresacontxconvenio`.`Id` = `c_citas`.`Id_EmpresaCont`) WHERE (`c_citas`.`Fecha_Cita` ='" + this.frmCalendario.getAno() + "-" + (Integer.parseInt(this.frmCalendario.getMes()) + 1) + "-" + this.frmCalendario.getDia() + "' AND `c_citas`.`Id_Profesional` ='" + this.listaProfesional[this.filaArbol][0] + "' AND `c_citas`.`Id_Especialidad` ='" + this.idEspecialidad + "' AND `c_citas`.`Id_MotivoDesistida` =1) ORDER BY `c_citas`.`HoraInicial` ASC ";
            }
            this.rs = this.consultas.traerRs(this.sql);
            this.rs.last();
            this.listaPacientesConCita = new String[this.rs.getRow()][14];
            int xnpac = 0;
            if (this.rs.getRow() > 0) {
                int fila = 0;
                this.rs.beforeFirst();
                while (this.rs.next()) {
                    this.listaPacientesConCita[fila][0] = this.rs.getString(1);
                    this.listaPacientesConCita[fila][1] = this.rs.getString(2);
                    this.listaPacientesConCita[fila][2] = this.rs.getString(3);
                    this.listaPacientesConCita[fila][3] = this.rs.getString(4);
                    this.listaPacientesConCita[fila][4] = this.rs.getString(5);
                    this.listaPacientesConCita[fila][5] = this.rs.getString(6);
                    this.listaPacientesConCita[fila][6] = this.rs.getString(7);
                    if (this.rs.getString(8) != null) {
                        if (this.rs.getString(8).equals("1")) {
                            this.listaPacientesConCita[fila][7] = "1";
                        } else {
                            this.listaPacientesConCita[fila][7] = "0";
                        }
                    } else {
                        this.listaPacientesConCita[fila][7] = "0";
                    }
                    this.listaPacientesConCita[fila][8] = this.rs.getString(9);
                    this.listaPacientesConCita[fila][9] = this.rs.getString(10);
                    this.listaPacientesConCita[fila][10] = this.rs.getString(11);
                    this.listaPacientesConCita[fila][11] = this.rs.getString(12);
                    this.listaPacientesConCita[fila][12] = this.rs.getString(13);
                    this.listaPacientesConCita[fila][13] = this.rs.getString(14);
                    xnpac++;
                    fila++;
                }
            }
            this.JTFFNCitas.setValue(Integer.valueOf(xnpac));
            this.rs.close();
            this.consultas.cerrarConexionBd();
        } catch (SQLException ex) {
            this.consultas.mostrarErrorSQL(ex);
        }
    }

    private void cargarArbol() {
        this.sql = "SELECT g_profesionalespecial.Id_Especialidad, g_especialidad.Nbre, g_persona.Apellido1, g_persona.Apellido2, g_persona.Nombre1, g_persona.Nombre2, g_persona.Id FROM g_profesionalespecial INNER JOIN g_especialidad ON (g_profesionalespecial.Id_Especialidad = g_especialidad.Id) INNER JOIN g_profesional ON (g_profesionalespecial.Id_Profesional = g_profesional.Id_Persona) INNER JOIN g_persona  ON (g_profesional.Id_Persona = g_persona.Id) WHERE (g_profesional.Activo_Cita =0 AND g_profesional.Estado=0 AND g_especialidad.Fisioterapia = 1) ORDER BY g_especialidad.Nbre DESC, g_persona.Apellido1 DESC, g_persona.Apellido2 DESC";
        try {
            this.rs = this.consultas.traerRs(this.sql);
            this.rs.last();
            if (this.rs.getRow() < 1) {
                this.metodos.mostrarMensaje("No hay Especialidades y Profesionales Asociados");
            } else {
                this.listaProfesional = new String[this.rs.getRow() + 1][7];
                this.rs.beforeFirst();
                while (this.rs.next()) {
                    this.nbreProfesional = this.rs.getString(3) + " " + this.rs.getString(4) + " " + this.rs.getString(5) + " " + this.rs.getString(6);
                    this.hoja = new DefaultMutableTreeNode(this.nbreProfesional);
                    this.listaProfesional[this.rs.getRow()][0] = this.rs.getString(7);
                    this.listaProfesional[this.rs.getRow()][1] = this.nbreProfesional;
                    this.listaProfesional[this.rs.getRow()][2] = this.rs.getString(1);
                    this.listaProfesional[this.rs.getRow()][3] = this.rs.getString(2);
                    if (!this.rs.getString(2).equals(this.especialAnterior)) {
                        this.rama = new DefaultMutableTreeNode(this.rs.getString(2));
                        this.modeloArbol.insertNodeInto(this.rama, this.tallo, 0);
                        this.especialAnterior = this.rs.getString(2);
                    }
                    this.modeloArbol.insertNodeInto(this.hoja, this.rama, 0);
                }
                this.Arbol.setModel(this.modeloArbol);
                this.Arbol.getSelectionModel().setSelectionMode(1);
                this.Arbol.setScrollsOnExpand(true);
                this.Arbol.requestFocus();
            }
            this.rs.close();
            this.consultas.cerrarConexionBd();
        } catch (SQLException e) {
        }
    }

    private void cargarClaseCita() {
        this.cboClaseCita.removeAllItems();
        this.listaClaseCita = this.consultas.llenarComboyLista("SELECT Id, Nbre, Duracion, Id_Programa FROM c_clasecita WHERE Id_Especialidad ='" + this.listaProfesional[this.filaArbol][2] + "'and Id_Programa<>0 and Estado=0 ORDER BY Nbre ASC", this.listaClaseCita, this.cboClaseCita, 4);
        this.consultas.cerrarConexionBd();
        if (this.cboClaseCita.getItemCount() > 0) {
            this.cboClaseCita.setSelectedIndex(-1);
            this.combocc = 1;
        } else {
            this.metodos.mostrarMensaje("El Profesional '" + this.listaProfesional[this.filaArbol][1] + "', no tiene Clases de Citas asociadas");
        }
        if (Principal.informacionIps.getNombreIps().equals("IPS TERAPIAS Y ESTETICA INTEGRAL SAS") || Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN JUAN DE DIOS - Segovia") || Principal.informacionIps.getIdentificacion().equals("812003851") || Principal.informacionIps.getIdentificacion().equals("900017536")) {
            List<Object[]> list = this.xCitasDAO.consultarIngreso(0, this.frmPersona.IdPersona, this.frmCalendario.getAno(), this.listaProfesional[this.filaArbol][2]);
            for (int x = 0; x < list.size(); x++) {
                this.JTFFNorden.setText(list.get(x)[0].toString());
            }
        }
    }

    private void cargarPanelPersonas() {
        this.frmPersona = new Persona(this);
        this.frmPersona.setVisible(true);
        this.panelPersonas.setVisible(false);
        this.frmPersona.setBounds(1, 1, 1199, 160);
        this.panelPersonas.add(this.frmPersona);
        this.panelPersonas.setVisible(true);
    }

    private void mllenarComboEmpresaFac() {
        this.JCBEmpresa.removeAllItems();
        this.xidempresafac = this.consultas.llenarCombo("SELECT `f_empresacontxconvenio`.`Id`, UCASE(`f_empresacontxconvenio`.`Nbre`) AS NEmpresa FROM  `f_empresacontxconvenio` INNER JOIN  `g_empresacont`  ON (`f_empresacontxconvenio`.`Id_EmpresaCont` = `g_empresacont`.`Id_empresa`) INNER JOIN  `g_empresa`  ON (`g_empresacont`.`Id_empresa` = `g_empresa`.`Id`)  WHERE (`f_empresacontxconvenio`.`Estado` =0 AND `g_empresa`.`Estado` =1) ORDER BY `f_empresacontxconvenio`.`Nbre` ASC ", this.xidempresafac, this.JCBEmpresa);
        this.JCBEmpresa.setSelectedIndex(-1);
        this.consultas.cerrarConexionBd();
        String xsql = "SELECT `g_sedes`.`Id` , `g_sedes`.`Nbre`\nFROM `g_usuario_sist_sede` INNER JOIN `g_sedes`  ON (`g_usuario_sist_sede`.`Id_Sede` = `g_sedes`.`Id`)\nWHERE (`g_usuario_sist_sede`.`Id_Persona` ='" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "' AND `g_usuario_sist_sede`.`Estado` =1)\nORDER BY `g_sedes`.`Nbre` ASC";
        this.JCBSede.removeAllItems();
        this.xidsede = this.consultas.llenarCombo(xsql, this.xidsede, this.JCBSede);
        this.JCBSede.setSelectedItem(Principal.sedeUsuarioSeleccionadaDTO.getNombre());
        this.consultas.cerrarConexionBd();
    }

    private void cargarPacienteDeLaHora(String hora24, String hora) {
        for (int a = 0; a < this.listaPacientesConCita.length; a++) {
            if (this.listaPacientesConCita[a][0].toString().substring(0, 5).equals(hora24.substring(0, 5))) {
                this.horaUltima = this.listaPacientesConCita[a][1];
                this.modeloGrid.setValueAt(hora, this.filaGrid, 0);
                this.modeloGrid.setValueAt(this.metodos.formatoHora12(this.horaUltima), this.filaGrid, 1);
                this.modeloGrid.setValueAt(this.listaPacientesConCita[a][2], this.filaGrid, 2);
                this.modeloGrid.setValueAt(this.listaPacientesConCita[a][4], this.filaGrid, 3);
                this.modeloGrid.setValueAt(this.listaPacientesConCita[a][5], this.filaGrid, 4);
                this.modeloGrid.setValueAt(this.listaPacientesConCita[a][6], this.filaGrid, 5);
                this.modeloGrid.setValueAt(this.listaPacientesConCita[a][7], this.filaGrid, 6);
                this.modeloGrid.setValueAt(this.listaPacientesConCita[a][8], this.filaGrid, 7);
                this.modeloGrid.setValueAt(this.listaPacientesConCita[a][10], this.filaGrid, 9);
                this.modeloGrid.setValueAt(this.listaPacientesConCita[a][11], this.filaGrid, 10);
                this.modeloGrid.setValueAt(this.listaPacientesConCita[a][12], this.filaGrid, 11);
                this.modeloGrid.setValueAt(this.listaPacientesConCita[a][13], this.filaGrid, 12);
                this.modeloGrid.setValueAt(this.listaPacientesConCita[a][9], this.filaGrid, 13);
                if (this.listaPacientesConCita[a][9].equals("0")) {
                    this.modeloGrid.setValueAt("POR FACTURAR", this.filaGrid, 8);
                } else if (this.listaPacientesConCita[a][9].equals("1")) {
                    this.modeloGrid.setValueAt("FACTURADA", this.filaGrid, 8);
                } else {
                    this.modeloGrid.setValueAt("ATENDIDO", this.filaGrid, 8);
                }
                this.grid.setDefaultRenderer(Object.class, new MiRender1());
                this.filaGrid++;
                llenarFilaVacia(hora);
            }
        }
    }

    /* JADX INFO: loaded from: GenomaP.jar:Citas/CitaTerapia$MiRender1.class */
    public static class MiRender1 extends DefaultTableCellRenderer {
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            int cantidad = Integer.parseInt(table.getValueAt(row, 13).toString());
            if (cantidad == 0) {
                cell.setBackground(Color.CYAN);
                cell.setForeground(Color.BLACK);
            } else if (cantidad == 1) {
                cell.setBackground(Color.PINK);
                cell.setForeground(Color.BLACK);
            } else if (cantidad >= 2) {
                cell.setBackground(Color.MAGENTA);
                cell.setForeground(Color.BLACK);
            } else {
                cell.setBackground(new Color(255, 255, 255));
                cell.setForeground(new Color(0, 0, 102));
            }
            return cell;
        }
    }

    public void cargarHorarioGrid() {
        cargarPacienteConCita();
        int diaAnterior = 0;
        this.filaGrid = 0;
        for (int i = 0; i < 1000 && this.frmCalendario.listaDiasConCita[i][0] != null; i++) {
            if (Integer.parseInt(this.frmCalendario.listaDiasConCita[i][0]) == Integer.parseInt(this.frmCalendario.getDia())) {
                if (diaAnterior != Integer.parseInt(this.frmCalendario.listaDiasConCita[i][0])) {
                    crearGrid();
                    this.filaGrid = 0;
                }
                diaAnterior = Integer.parseInt(this.frmCalendario.listaDiasConCita[i][0]);
                int horaInicio = Integer.parseInt(this.frmCalendario.listaDiasConCita[i][2].substring(0, 2));
                int minutoInicio = Integer.parseInt(this.frmCalendario.listaDiasConCita[i][2].substring(3, 5));
                int horaFinal = Integer.parseInt(this.frmCalendario.listaDiasConCita[i][3].substring(0, 2));
                int minutoFinal = Integer.parseInt(this.frmCalendario.listaDiasConCita[i][3].substring(3, 5));
                String hora = "";
                txtConsultorio.setText(this.frmCalendario.listaDiasConCita[i][4]);
                this.idConsultorio = this.frmCalendario.listaDiasConCita[i][1];
                for (int horaIni = horaInicio; horaIni <= horaFinal; horaIni++) {
                    int i2 = minutoInicio;
                    while (true) {
                        int min = i2;
                        if (min >= 60 || (horaIni >= horaFinal && min >= minutoFinal)) {
                            break;
                        }
                        hora = getHora(horaIni, min);
                        if (this.frmCalendario.listaDiasConCita[i][5].equals("3")) {
                            llenarFilaVacaciones(hora);
                        } else {
                            llenarFilaVacia(hora);
                            this.horaUltima = "hora";
                            String hora24 = this.metodos.pasarHora12a24(hora);
                            cargarPacienteDeLaHora(hora24, hora);
                            this.filaGrid++;
                        }
                        i2 = min + 5;
                    }
                }
                llenarFilaVacia(hora);
                this.modeloGrid.setValueAt("                        - DESCANSO -                ", this.filaGrid, 2);
            }
        }
        limpiarFilasEnBlanco();
    }

    private void llenarFilaVacaciones(String hora) {
        for (int p = 0; p < this.modeloGrid.getRowCount(); p++) {
            if (this.modeloGrid.getValueAt(p, 0).toString().equals(hora)) {
                this.modeloGrid.setValueAt("Libre / Permiso / Vacaciones", p, 2);
                return;
            }
        }
    }

    private void llenarFilaVacia(String hora) {
        this.modeloGrid.addRow(this.dato);
        this.modeloGrid.setValueAt(hora, this.filaGrid, 0);
        this.modeloGrid.setValueAt(" ", this.filaGrid, 2);
        this.modeloGrid.setValueAt("", this.filaGrid, 5);
        this.modeloGrid.setValueAt("0", this.filaGrid, 6);
        this.modeloGrid.setValueAt("-1", this.filaGrid, 13);
    }

    private void limpiarFilasEnBlanco() {
        int f = 0;
        while (f < this.modeloGrid.getRowCount()) {
            if (this.modeloGrid.getValueAt(f, 0) == null) {
                this.modeloGrid.removeRow(f);
                f--;
            }
            f++;
        }
    }

    public void cargarAgenda() {
        this.frmCalendario.refrescar();
        this.frmCalendario.limpiarListaDiasConCita();
        this.frmCalendario.montarAgendaGeneral(this.listaProfesional[this.filaArbol][0], this.idEspecialidad);
        this.frmCalendario.montarAgendaEspecial(this.listaProfesional[this.filaArbol][0], this.idEspecialidad);
        this.frmCalendario.montarAgendaExcepcion(this.listaProfesional[this.filaArbol][0], this.idEspecialidad);
    }

    private void cargarNoCitaIps() {
        this.sql = "SELECT NoCita FROM g_ips";
        NoCitaIps = this.consultas.traerDato(this.sql);
        this.consultas.cerrarConexionBd();
    }

    public final void crearGrid() {
        this.modeloGrid = new DefaultTableModel() { // from class: Citas.CitaTerapia.1
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        this.modeloGrid.addColumn("DESDE");
        this.modeloGrid.addColumn("HASTA");
        this.modeloGrid.addColumn("USUARIO");
        this.modeloGrid.addColumn("");
        this.modeloGrid.addColumn("");
        this.modeloGrid.addColumn("");
        this.modeloGrid.addColumn("");
        this.modeloGrid.addColumn("");
        this.modeloGrid.addColumn("Asistida");
        this.modeloGrid.addColumn("");
        this.modeloGrid.addColumn("");
        this.modeloGrid.addColumn("");
        this.modeloGrid.addColumn("");
        this.modeloGrid.addColumn("");
        this.grid.setModel(this.modeloGrid);
        this.grid.getColumnModel().getColumn(0).setPreferredWidth(90);
        this.grid.getColumnModel().getColumn(1).setPreferredWidth(90);
        this.grid.getColumnModel().getColumn(2).setPreferredWidth(500);
        this.grid.getColumnModel().getColumn(3).setPreferredWidth(0);
        this.grid.getColumnModel().getColumn(3).setMinWidth(0);
        this.grid.getColumnModel().getColumn(3).setMaxWidth(0);
        this.grid.getColumnModel().getColumn(4).setPreferredWidth(0);
        this.grid.getColumnModel().getColumn(4).setMinWidth(0);
        this.grid.getColumnModel().getColumn(4).setMaxWidth(0);
        this.grid.getColumnModel().getColumn(5).setPreferredWidth(0);
        this.grid.getColumnModel().getColumn(5).setMinWidth(0);
        this.grid.getColumnModel().getColumn(5).setMaxWidth(0);
        this.grid.getColumnModel().getColumn(6).setPreferredWidth(0);
        this.grid.getColumnModel().getColumn(6).setMinWidth(0);
        this.grid.getColumnModel().getColumn(6).setMaxWidth(0);
        this.grid.getColumnModel().getColumn(7).setPreferredWidth(0);
        this.grid.getColumnModel().getColumn(7).setMinWidth(0);
        this.grid.getColumnModel().getColumn(7).setMaxWidth(0);
        this.grid.getColumnModel().getColumn(8).setPreferredWidth(80);
        this.grid.getColumnModel().getColumn(8).setMinWidth(80);
        this.grid.getColumnModel().getColumn(8).setMaxWidth(80);
        this.grid.getColumnModel().getColumn(9).setPreferredWidth(0);
        this.grid.getColumnModel().getColumn(9).setMinWidth(0);
        this.grid.getColumnModel().getColumn(9).setMaxWidth(0);
        this.grid.getColumnModel().getColumn(10).setPreferredWidth(40);
        this.grid.getColumnModel().getColumn(11).setPreferredWidth(0);
        this.grid.getColumnModel().getColumn(11).setMinWidth(0);
        this.grid.getColumnModel().getColumn(11).setMaxWidth(0);
        this.grid.getColumnModel().getColumn(12).setPreferredWidth(0);
        this.grid.getColumnModel().getColumn(12).setMinWidth(0);
        this.grid.getColumnModel().getColumn(12).setMaxWidth(0);
        this.grid.getColumnModel().getColumn(13).setPreferredWidth(0);
        this.grid.getColumnModel().getColumn(13).setMinWidth(0);
        this.grid.getColumnModel().getColumn(13).setMaxWidth(0);
    }

    public void desistir() {
        if (Principal.txtNo.getText() == null || Principal.txtNo.getText().isEmpty() || Principal.txtNo.getText().equals("")) {
            this.mnPopup.setVisible(false);
            this.metodos.mostrarMensaje("Por favor selecione una Cita para Anular");
            return;
        }
        if (Long.valueOf(this.modeloGrid.getValueAt(this.grid.getSelectedRow(), 9).toString()).longValue() == 0 || ((Principal.informacionIps.getNombreIps().equals("IPS TERAPIAS Y ESTETICA INTEGRAL SAS") || Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN JUAN DE DIOS - Segovia") || Principal.informacionIps.getIdentificacion().equals("812003851") || Principal.informacionIps.getIdentificacion().equals("900017536")) && this.modeloGrid.getValueAt(this.grid.getSelectedRow(), 8).toString().equals("POR FACTURAR"))) {
            this.mnPopup.setVisible(false);
            Anular frm1 = new Anular(null, true, "CitaTerapia", 7);
            frm1.setVisible(true);
        } else {
            this.mnPopup.setVisible(false);
            this.metodos.mostrarMensaje("Esta cita ya posee un ingreso");
        }
    }

    private void evaluarNodo() {
        this.nodo = (DefaultMutableTreeNode) this.Arbol.getLastSelectedPathComponent();
        if (this.nodo != null) {
            String nbreEspecial = this.nodo.getParent().toString();
            if (this.Arbol.getLastSelectedPathComponent() != null) {
                this.filaArbol = 1;
                while (this.filaArbol < this.listaProfesional.length) {
                    if (this.nodo.getUserObject().equals(this.listaProfesional[this.filaArbol][1]) && this.listaProfesional[this.filaArbol][3].equals(nbreEspecial)) {
                        crearGrid();
                        this.idEspecialidad = this.listaProfesional[this.filaArbol][2];
                        cargarAgenda();
                        cargarClaseCita();
                        return;
                    }
                    this.filaArbol++;
                }
            }
        }
    }

    public String getHora(int hInicial, int min) {
        String hora;
        if (hInicial < 10) {
            if (min < 10) {
                hora = this.metodos.formatoHora12("0" + String.valueOf(hInicial) + ":0" + String.valueOf(min));
            } else {
                hora = this.metodos.formatoHora12("0" + String.valueOf(hInicial) + ":" + String.valueOf(min));
            }
        } else if (min < 10) {
            hora = this.metodos.formatoHora12(String.valueOf(hInicial) + ":0" + String.valueOf(min));
        } else {
            hora = this.metodos.formatoHora12(String.valueOf(hInicial) + ":" + String.valueOf(min));
        }
        return hora;
    }

    private int getValidarCampos() {
        int validar = 0;
        if (this.frmPersona.txtApellido1.getText().isEmpty() || this.frmPersona.txtNombre1.getText().isEmpty()) {
            this.metodos.mostrarMensaje("Por Favor registre un Usuario y escriba sus Nombres y Apellidos.");
            this.frmPersona.txtApellido1.requestFocus();
        } else if (this.nbreProfesional.isEmpty()) {
            this.metodos.mostrarMensaje("Por Favor seleccione un Profesional.");
            this.Arbol.requestFocus();
        } else if (this.frmPersona.cboEps.getSelectedIndex() < 0) {
            this.metodos.mostrarMensaje("Por favor seleccione una Empresa o EPS a la cual esta afiliado.");
            this.frmPersona.cboEps.requestFocus();
        } else if (this.cboClaseCita.getSelectedIndex() < 0) {
            this.metodos.mostrarMensaje("Por favor seleccione la Clase de Cita.");
            this.cboClaseCita.requestFocus();
        } else if (this.JCBEmpresa.getSelectedIndex() < 0 && this.grabarCita == 1) {
            this.metodos.mostrarMensaje("Por favor seleccione la empresa a facturar.");
            this.JCBEmpresa.requestFocus();
        } else if (this.JCBSede.getSelectedIndex() < 0) {
            this.metodos.mostrarMensaje("Por favor seleccione una sede.");
            this.JCBSede.requestFocus();
        } else {
            validar = 1;
        }
        return validar;
    }

    public void grabar() {
        this.frmPersona.grabar();
        grabarCita();
        this.nodo.setUserObject(this.listaProfesional[this.filaArbol][1]);
        this.consultas.cerrarConexionBd();
    }

    public void grabarCita() {
        String horaI = this.grid.getValueAt(this.filaGrid, 0).toString().substring(0, 5);
        if (this.grid.getValueAt(this.filaGrid, 0).toString().substring(6, 8).equals("PM")) {
            horaI = String.valueOf(12 + Integer.parseInt(this.grid.getValueAt(this.filaGrid, 0).toString().substring(0, 2))) + ":" + this.grid.getValueAt(this.filaGrid, 0).toString().substring(3, 5);
        }
        mTraerNIngresoOrden();
        String horaF = this.metodos.sumarHoras24(horaI, this.txtDuracion.getText());
        this.sql = "INSERT INTO c_citas (Id_Profesional, Id_Especialidad, Id_Usuario, Id_EmpresaCont, Id_ClaseCita, Fecha_Cita, HoraInicial, HoraFinal, Telefonica, Remitida, PrimerVez, Asistida, Id_ingreso, Id_Sede, Id_Consultorio, Fecha, UsuarioS, Id_UsuarioS) VALUES ('" + this.listaProfesional[this.filaArbol][0] + "','" + this.idEspecialidad + "','" + this.frmPersona.getIdPersona() + "','" + this.xidempresafac[this.JCBEmpresa.getSelectedIndex()] + "','" + this.listaClaseCita[this.cboClaseCita.getSelectedIndex()][0] + "','" + this.metodos.formatoAMDH24.format(this.frmCalendario.getFecha().getTime()) + "','" + horaI + "','" + horaF + "','" + this.citaTelefonica + "','" + this.remitida + "','" + this.citaPrimerVez + "','0','" + this.JTFFNorden.getText() + "','" + this.xidsede[this.JCBSede.getSelectedIndex()] + "','" + this.idConsultorio + "','" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "')";
        this.idCita = this.consultas.ejecutarSQLId(this.sql);
        this.consultas.cerrarConexionBd();
        Principal.txtNo.setText(this.idCita);
        Principal.txtEstado.setText("ACTIVA");
        Principal.txtFecha.setText(this.metodos.formatoDMA.format(this.frmCalendario.getFecha().getTime()));
        this.grid.setValueAt(horaF, this.filaGrid, 1);
        this.grid.setValueAt(this.idCita, this.filaGrid, 3);
        this.metodos.marcarEstado(0);
        this.sql = "UPDATE g_ips SET g_ips.NoCita = '" + this.idCita + "', IdProfesionalUltimaCita ='" + this.listaProfesional[this.filaArbol][0] + "'";
        this.consultas.ejecutarSQL(this.sql);
        this.consultas.cerrarConexionBd();
    }

    private void llamarUsuario() {
        this.mnPopup.setVisible(false);
        Principal.clasegeneral.cargarPantalla("Llamadas");
        Principal.clasegeneral.frmLlamadas.frmPersona.txtHistoria.setText(this.modeloGrid.getValueAt(this.filaGrid, 7).toString());
        Principal.clasegeneral.frmLlamadas.frmPersona.buscar(1);
    }

    private void modificarCita() {
        String horaI = this.metodos.pasarHora12a24(this.modeloGrid.getValueAt(this.filaGrid, 0).toString());
        String horaF = this.metodos.sumarHoras24(horaI, this.txtDuracion.getText());
        this.sql = "UPDATE c_citas SET Id_Profesional ='" + this.listaProfesional[this.filaArbol][0] + "', Id_Especialidad ='" + this.idEspecialidad + "', Id_Sede ='" + this.xidsede[this.JCBSede.getSelectedIndex()] + "', Id_ClaseCita ='" + this.listaClaseCita[this.cboClaseCita.getSelectedIndex()][0] + "', Fecha_Cita ='" + this.metodos.formatoAMD.format(this.frmCalendario.getFecha().getTime()) + "', HoraInicial ='" + horaI.substring(0, 5) + "', HoraFinal ='" + horaF + "', Id_ingreso ='" + this.JTFFNorden.getText() + "', Fecha ='" + this.metodos.formatoAMDH24.format(this.fechaActual.getTime()) + "', UsuarioS ='" + Principal.usuarioSistemaDTO.getLogin() + "' WHERE Id = '" + this.NoCitaAReasignar + "'";
        this.consultas.ejecutarSQL(this.sql);
        this.consultas.cerrarConexionBd();
        this.idReasignar = 0;
        this.NoCitaAReasignar = "";
    }

    public void nuevo() {
        this.idCita = "0";
        this.metodos.limpiarDatosPrincipal();
        this.frmPersona.nuevo();
        this.cboClaseCita.setSelectedIndex(-1);
        this.JTFFNorden.setValue(new Integer(0));
        setxIdIngreso("0");
        this.JTFFNCitas.setText("");
        if (Principal.informacionIps.getEsFpz().intValue() == 0) {
            this.JTFFNorden.setBorder(BorderFactory.createTitledBorder((Border) null, "No. Orden", 2, 0, new Font("Arial", 1, 12), Color.blue));
        } else {
            this.JTFFNorden.setBorder(BorderFactory.createTitledBorder((Border) null, "No. Ingreso", 2, 0, new Font("Arial", 1, 12), Color.blue));
        }
    }

    private void reasignar() {
        this.mnPopup.setVisible(false);
        String nbre = this.frmPersona.txtApellido1.getText() + " " + this.frmPersona.txtApellido2.getText() + " " + this.frmPersona.txtNombre1.getText() + " " + this.frmPersona.txtNombre2.getText();
        if (nbre.equals(this.modeloGrid.getValueAt(this.filaGrid, 2).toString())) {
            this.idReasignar = 1;
            this.NoCitaAReasignar = Principal.txtNo.getText();
        } else {
            this.metodos.mostrarMensaje("Por favor ubique al usuario que desea Reasignar la Cita.\nLuego busque el día de destino para Reasignar");
        }
    }

    public void revisarCita() {
        try {
            if (Principal.txtNo.getText() != null && !Principal.txtNo.getText().equals("") && this.filaArbol > 0) {
                this.sql = "SELECT NoCita, IdProfesionalUltimaCita FROM g_ips";
                this.rs = this.consultas.traerRs(this.sql);
                this.rs.next();
                String noCita = this.rs.getString(1);
                String IdProfesional = this.rs.getString(2);
                this.rs.close();
                this.consultas.cerrarConexionBd();
                if (!Principal.txtNo.getText().equals(noCita) && this.listaProfesional[this.filaArbol][0].toString().equals(IdProfesional)) {
                    cargarHorarioGrid();
                }
            }
        } catch (SQLException ex) {
            this.consultas.mostrarErrorSQL(ex);
        }
    }

    private void mTraerNIngresoOrden() {
        try {
            if (getxIdIngreso().equals("0")) {
                String xsql = "SELECT h_atencion.Id_Ingreso FROM  h_ordenes INNER JOIN  h_atencion  ON (h_ordenes.Id_Atencion = h_atencion.Id) WHERE (h_ordenes.Id ='" + this.JTFFNorden.getValue() + "') ";
                ResultSet xrs = this.consultas.traerRs(xsql);
                if (xrs.next()) {
                    setxIdIngreso(xrs.getString(1));
                }
                xrs.close();
                this.consultas.cerrarConexionBd();
            }
        } catch (SQLException ex) {
            Logger.getLogger(CitaTerapia.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private String mTraerNOrdenIngreso() {
        String norden = "0";
        try {
            String xsql = "SELECT h_ordenes.Id  FROM  h_ordenes INNER JOIN  h_atencion  ON (h_ordenes.Id_Atencion = h_atencion.Id)  INNER JOIN  h_itemordenesproced  ON (h_itemordenesproced.Id_HOrdenes = h_ordenes.Id)  WHERE (h_atencion.Id_Ingreso ='" + this.grid.getValueAt(this.grid.getSelectedRow(), 9).toString() + "' AND h_itemordenesproced.Id_Procedimiento ='" + this.grid.getValueAt(this.grid.getSelectedRow(), 12).toString() + "' ) GROUP BY h_ordenes.Id";
            ResultSet xrs = this.consultas.traerRs(xsql);
            if (xrs.next()) {
                norden = xrs.getString(1);
                this.xclasescita.setxIdIngreso(Long.valueOf(this.grid.getValueAt(this.grid.getSelectedRow(), 9).toString()).longValue());
            }
            xrs.close();
            this.consultas.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(CitaTerapia.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return norden;
    }

    /* JADX INFO: loaded from: GenomaP.jar:Citas/CitaTerapia$MiRender.class */
    public static class MiRender extends DefaultTableCellRenderer {
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            String trabajador = table.getValueAt(row, 6).toString();
            if (trabajador != null && trabajador.equals("1")) {
                cell.setBackground(new Color(255, 255, 204));
            } else {
                cell.setBackground(Color.WHITE);
            }
            return cell;
        }
    }

    /* JADX INFO: loaded from: GenomaP.jar:Citas/CitaTerapia$MyTreeCellRenderer.class */
    public class MyTreeCellRenderer extends DefaultTreeCellRenderer {
        public MyTreeCellRenderer() {
        }

        public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected, boolean expanded, boolean leaf, int row, boolean hasFocus) {
            super.getTreeCellRendererComponent(tree, value, selected, expanded, leaf, row, hasFocus);
            tree.setRowHeight(26);
            setOpaque(true);
            setForeground(Color.black);
            if (selected) {
                setForeground(Color.red);
            }
            if (tree.getModel().getRoot().equals((DefaultMutableTreeNode) value)) {
                setIcon(CitaTerapia.this.rootIcon);
            } else if (leaf) {
                setIcon(CitaTerapia.this.medicoIcon);
            } else if (expanded) {
                setIcon(CitaTerapia.this.especialidadIcon);
            } else {
                setIcon(CitaTerapia.this.especialidadIcon);
            }
            return this;
        }
    }

    /* JADX WARN: Type inference failed for: r3v32, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.mnPopup = new JPopupMenu();
        this.mnAsignar = new JMenuItem();
        this.mnReasignar = new JMenuItem();
        this.mnDesistir = new JMenuItem();
        this.jSeparator1 = new JSeparator();
        this.mnRecordatorio = new JMenuItem();
        this.mnRecordatorio1 = new JMenuItem();
        this.mnCertificado = new JMenuItem();
        this.mnLlamar = new JMenuItem();
        this.JMIFacturacion = new JMenuItem();
        this.jSeparator2 = new JSeparator();
        this.mnSalir = new JMenuItem();
        this.grupoRemision = new ButtonGroup();
        this.jPanel5 = new JPanel();
        this.panelCalendario = new JPanel();
        this.jScrollPane1 = new JScrollPane();
        this.Arbol = new JTree();
        this.jScrollPane3 = new JScrollPane();
        this.grid = new JTable();
        this.lblFecha = new JLabel();
        this.panelPersonas = new JPanel();
        this.jPanel1 = new JPanel();
        this.cboClaseCita = new JComboBox();
        this.jLabel2 = new JLabel();
        this.txtDuracion = new JTextField();
        this.jLabel3 = new JLabel();
        txtConsultorio = new JTextField();
        this.JTFFNorden = new JFormattedTextField();
        this.JTFFNCitas = new JFormattedTextField();
        this.jLabel4 = new JLabel();
        this.JCBEmpresa = new JComboBox();
        this.JCBSede = new JComboBox();
        this.mnPopup.setFont(new Font("Arial", 1, 12));
        this.mnAsignar.setFont(new Font("Arial", 1, 12));
        this.mnAsignar.setText("Asignar Cita");
        this.mnAsignar.addActionListener(new ActionListener() { // from class: Citas.CitaTerapia.2
            public void actionPerformed(ActionEvent evt) {
                CitaTerapia.this.mnAsignarActionPerformed(evt);
            }
        });
        this.mnPopup.add(this.mnAsignar);
        this.mnReasignar.setFont(new Font("Arial", 1, 12));
        this.mnReasignar.setText("Reasignar Cita");
        this.mnReasignar.addActionListener(new ActionListener() { // from class: Citas.CitaTerapia.3
            public void actionPerformed(ActionEvent evt) {
                CitaTerapia.this.mnReasignarActionPerformed(evt);
            }
        });
        this.mnPopup.add(this.mnReasignar);
        this.mnDesistir.setFont(new Font("Arial", 1, 12));
        this.mnDesistir.setText("Desistir Cita");
        this.mnDesistir.addActionListener(new ActionListener() { // from class: Citas.CitaTerapia.4
            public void actionPerformed(ActionEvent evt) {
                CitaTerapia.this.mnDesistirActionPerformed(evt);
            }
        });
        this.mnPopup.add(this.mnDesistir);
        this.mnPopup.add(this.jSeparator1);
        this.mnRecordatorio.setFont(new Font("Arial", 1, 12));
        this.mnRecordatorio.setText("Imprimir Recordatorio de Cita");
        this.mnRecordatorio.addActionListener(new ActionListener() { // from class: Citas.CitaTerapia.5
            public void actionPerformed(ActionEvent evt) {
                CitaTerapia.this.mnRecordatorioActionPerformed(evt);
            }
        });
        this.mnPopup.add(this.mnRecordatorio);
        this.mnRecordatorio1.setFont(new Font("Arial", 1, 12));
        this.mnRecordatorio1.setText("Registro Sesiones Realizadas");
        this.mnRecordatorio1.addActionListener(new ActionListener() { // from class: Citas.CitaTerapia.6
            public void actionPerformed(ActionEvent evt) {
                CitaTerapia.this.mnRecordatorio1ActionPerformed(evt);
            }
        });
        this.mnPopup.add(this.mnRecordatorio1);
        this.mnCertificado.setFont(new Font("Arial", 1, 12));
        this.mnCertificado.setText("Certificado de Servicios");
        this.mnCertificado.addActionListener(new ActionListener() { // from class: Citas.CitaTerapia.7
            public void actionPerformed(ActionEvent evt) {
                CitaTerapia.this.mnCertificadoActionPerformed(evt);
            }
        });
        this.mnPopup.add(this.mnCertificado);
        this.mnLlamar.setFont(new Font("Arial", 1, 12));
        this.mnLlamar.setText("Llamar al Usuario");
        this.mnLlamar.addActionListener(new ActionListener() { // from class: Citas.CitaTerapia.8
            public void actionPerformed(ActionEvent evt) {
                CitaTerapia.this.mnLlamarActionPerformed(evt);
            }
        });
        this.mnPopup.add(this.mnLlamar);
        this.JMIFacturacion.setFont(new Font("Arial", 1, 12));
        this.JMIFacturacion.setText("Facturación");
        this.JMIFacturacion.addActionListener(new ActionListener() { // from class: Citas.CitaTerapia.9
            public void actionPerformed(ActionEvent evt) {
                CitaTerapia.this.JMIFacturacionActionPerformed(evt);
            }
        });
        this.mnPopup.add(this.JMIFacturacion);
        this.mnPopup.add(this.jSeparator2);
        this.mnSalir.setFont(new Font("Arial", 1, 12));
        this.mnSalir.setText("Salir");
        this.mnSalir.addActionListener(new ActionListener() { // from class: Citas.CitaTerapia.10
            public void actionPerformed(ActionEvent evt) {
                CitaTerapia.this.mnSalirActionPerformed(evt);
            }
        });
        this.mnPopup.add(this.mnSalir);
        setBackground(new Color(204, 255, 204));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("CITAS DE FISIOTERAPIAS");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setMaximumSize(new Dimension(1216, 833));
        setMinimumSize(new Dimension(1216, 833));
        setName("CitaTerapia");
        try {
            setSelected(true);
        } catch (PropertyVetoException e1) {
            e1.printStackTrace();
        }
        addInternalFrameListener(new InternalFrameListener() { // from class: Citas.CitaTerapia.11
            public void internalFrameActivated(InternalFrameEvent evt) {
            }

            public void internalFrameClosed(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                CitaTerapia.this.formInternalFrameClosing(evt);
            }

            public void internalFrameDeactivated(InternalFrameEvent evt) {
            }

            public void internalFrameDeiconified(InternalFrameEvent evt) {
            }

            public void internalFrameIconified(InternalFrameEvent evt) {
            }

            public void internalFrameOpened(InternalFrameEvent evt) {
            }
        });
        this.jPanel5.setBackground(new Color(204, 255, 204));
        this.jPanel5.setBorder(BorderFactory.createEtchedBorder());
        this.panelCalendario.setBorder(BorderFactory.createEtchedBorder(0));
        this.panelCalendario.setLayout((LayoutManager) null);
        this.Arbol.setFont(new Font("Arial", 1, 12));
        this.Arbol.setName("Arbol");
        this.Arbol.addTreeSelectionListener(new TreeSelectionListener() { // from class: Citas.CitaTerapia.12
            public void valueChanged(TreeSelectionEvent evt) {
                CitaTerapia.this.ArbolValueChanged(evt);
            }
        });
        this.jScrollPane1.setViewportView(this.Arbol);
        this.grid.setFont(new Font("Arial", 1, 12));
        this.grid.setForeground(new Color(0, 0, 102));
        this.grid.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.grid.setAutoResizeMode(3);
        this.grid.setCellSelectionEnabled(true);
        this.grid.setName("grid");
        this.grid.setRowHeight(25);
        this.grid.setSelectionBackground(new Color(255, 255, 255));
        this.grid.setSelectionForeground(new Color(255, 0, 0));
        this.grid.setSelectionMode(0);
        this.grid.addMouseMotionListener(new MouseMotionAdapter() { // from class: Citas.CitaTerapia.13
            public void mouseDragged(MouseEvent evt) {
                CitaTerapia.this.gridMouseDragged(evt);
            }

            public void mouseMoved(MouseEvent evt) {
                CitaTerapia.this.gridMouseMoved(evt);
            }
        });
        this.grid.addMouseListener(new MouseAdapter() { // from class: Citas.CitaTerapia.14
            public void mouseClicked(MouseEvent evt) {
                CitaTerapia.this.gridMouseClicked(evt);
            }

            public void mouseEntered(MouseEvent evt) {
                CitaTerapia.this.gridMouseEntered(evt);
            }

            public void mouseExited(MouseEvent evt) {
                CitaTerapia.this.gridMouseExited(evt);
            }

            public void mousePressed(MouseEvent evt) {
                CitaTerapia.this.gridMousePressed(evt);
            }

            public void mouseReleased(MouseEvent evt) {
                CitaTerapia.this.gridMouseReleased(evt);
            }
        });
        this.jScrollPane3.setViewportView(this.grid);
        this.grid.getColumnModel().getSelectionModel().setSelectionMode(1);
        this.lblFecha.setBackground(new Color(0, 0, 153));
        this.lblFecha.setFont(new Font("Arial", 1, 14));
        this.lblFecha.setForeground(new Color(204, 255, 255));
        this.lblFecha.setHorizontalAlignment(0);
        this.lblFecha.setText("jLabel8");
        this.lblFecha.setOpaque(true);
        this.panelPersonas.setBackground(new Color(204, 255, 204));
        this.panelPersonas.setMaximumSize(new Dimension(1000, 160));
        this.panelPersonas.setMinimumSize(new Dimension(1000, 160));
        this.panelPersonas.setPreferredSize(new Dimension(1000, 160));
        GroupLayout panelPersonasLayout = new GroupLayout(this.panelPersonas);
        this.panelPersonas.setLayout(panelPersonasLayout);
        panelPersonasLayout.setHorizontalGroup(panelPersonasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 0, 32767));
        panelPersonasLayout.setVerticalGroup(panelPersonasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 170, 32767));
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN CITA", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.cboClaseCita.setFont(new Font("Arial", 1, 12));
        this.cboClaseCita.setBorder(BorderFactory.createTitledBorder((Border) null, "Clase Cita", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.cboClaseCita.setName("cboClaseCita");
        this.cboClaseCita.addActionListener(new ActionListener() { // from class: Citas.CitaTerapia.15
            public void actionPerformed(ActionEvent evt) {
                CitaTerapia.this.cboClaseCitaActionPerformed(evt);
            }
        });
        this.jLabel2.setFont(new Font("Arial", 1, 12));
        this.jLabel2.setForeground(new Color(0, 0, 102));
        this.jLabel2.setText("Minutos de Duración");
        this.txtDuracion.setEditable(false);
        this.txtDuracion.setBackground(new Color(0, 0, 153));
        this.txtDuracion.setFont(new Font("Tahoma", 1, 12));
        this.txtDuracion.setForeground(new Color(255, 255, 255));
        this.txtDuracion.setHorizontalAlignment(0);
        this.txtDuracion.setDisabledTextColor(new Color(255, 255, 255));
        this.txtDuracion.setEnabled(false);
        this.txtDuracion.setName("txtDuracion");
        this.jLabel3.setFont(new Font("Arial", 1, 12));
        this.jLabel3.setForeground(new Color(0, 0, 102));
        this.jLabel3.setText("Consultorio");
        txtConsultorio.setBackground(new Color(0, 0, 153));
        txtConsultorio.setDisabledTextColor(new Color(255, 255, 255));
        txtConsultorio.setEnabled(false);
        txtConsultorio.setName("txtConsultorio");
        this.JTFFNorden.setBorder(BorderFactory.createTitledBorder((Border) null, "N° ORDEN", 0, 0, new Font("Arial", 1, 12)));
        this.JTFFNorden.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0"))));
        this.JTFFNorden.setHorizontalAlignment(0);
        this.JTFFNorden.setFont(new Font("Arial", 1, 18));
        this.JTFFNorden.addMouseListener(new MouseAdapter() { // from class: Citas.CitaTerapia.16
            public void mouseClicked(MouseEvent evt) {
                CitaTerapia.this.JTFFNordenMouseClicked(evt);
            }
        });
        this.JTFFNCitas.setBorder(BorderFactory.createTitledBorder((Border) null, "N° CITAS", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFNCitas.setForeground(new Color(255, 0, 0));
        this.JTFFNCitas.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0"))));
        this.JTFFNCitas.setHorizontalAlignment(0);
        this.JTFFNCitas.setFont(new Font("Arial", 1, 24));
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.cboClaseCita, GroupLayout.Alignment.TRAILING, 0, -1, 32767).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jLabel2, -2, 124, -2).addGap(30, 30, 30).addComponent(this.txtDuracion, -2, 110, -2)).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JTFFNorden, -2, 127, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFFNCitas, -2, 127, -2)).addComponent(this.jLabel3, -2, 74, -2).addComponent(txtConsultorio, -2, 264, -2)).addGap(0, 20, 32767))).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(8, 8, 8).addComponent(this.cboClaseCita, -2, -1, -2).addGap(0, 0, 0).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel2).addComponent(this.txtDuracion, -2, 28, -2)).addGap(2, 2, 2).addComponent(this.jLabel3).addGap(5, 5, 5).addComponent(txtConsultorio, -2, 30, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JTFFNorden, -2, 55, -2).addGap(0, 0, 32767)).addComponent(this.JTFFNCitas)).addContainerGap()));
        this.jLabel4.setFont(new Font("Arial", 1, 14));
        this.jLabel4.setForeground(new Color(0, 0, 153));
        this.jLabel4.setHorizontalAlignment(0);
        this.jLabel4.setIcon(new ImageIcon(getClass().getResource("/Imagenes/sillarueda.png")));
        this.jLabel4.setText("Buscar Citas");
        this.jLabel4.setToolTipText("Busca citas asignadas al usuario");
        this.jLabel4.setBorder(BorderFactory.createEtchedBorder());
        this.jLabel4.setCursor(new Cursor(0));
        this.jLabel4.setHorizontalTextPosition(0);
        this.jLabel4.setVerticalTextPosition(3);
        this.jLabel4.addMouseListener(new MouseAdapter() { // from class: Citas.CitaTerapia.17
            public void mouseClicked(MouseEvent evt) {
                CitaTerapia.this.jLabel4MouseClicked(evt);
            }
        });
        this.JCBEmpresa.setBorder(BorderFactory.createTitledBorder((Border) null, "Empresa para Facturar", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JCBEmpresa.setName("cboClaseCita");
        this.JCBEmpresa.addActionListener(new ActionListener() { // from class: Citas.CitaTerapia.18
            public void actionPerformed(ActionEvent evt) {
                CitaTerapia.this.JCBEmpresaActionPerformed(evt);
            }
        });
        this.JCBSede.setBorder(BorderFactory.createTitledBorder((Border) null, "Sede de Atención", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JCBSede.setName("cboClaseCita");
        this.JCBSede.addActionListener(new ActionListener() { // from class: Citas.CitaTerapia.19
            public void actionPerformed(ActionEvent evt) {
                CitaTerapia.this.JCBSedeActionPerformed(evt);
            }
        });
        GroupLayout jPanel5Layout = new GroupLayout(this.jPanel5);
        this.jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addGap(8, 8, 8).addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addComponent(this.panelPersonas, -2, 990, -2).addGap(10, 10, 10).addComponent(this.jLabel4, -2, 180, -2)).addGroup(jPanel5Layout.createSequentialGroup().addComponent(this.jScrollPane1, -2, 310, -2).addGap(10, 10, 10).addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.lblFecha, -2, 540, -2).addComponent(this.jScrollPane3, -2, 540, -2)).addGap(10, 10, 10).addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.panelCalendario, -2, 310, -2).addComponent(this.JCBEmpresa, -2, 310, -2).addComponent(this.JCBSede, -2, 310, -2).addComponent(this.jPanel1, -2, -1, -2))))));
        jPanel5Layout.setVerticalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addGap(8, 8, 8).addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.panelPersonas, -2, 170, -2).addGroup(jPanel5Layout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.jLabel4, -2, 150, -2))).addGap(10, 10, 10).addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane1, -2, 620, -2).addGroup(jPanel5Layout.createSequentialGroup().addComponent(this.lblFecha, -2, 22, -2).addGap(8, 8, 8).addComponent(this.jScrollPane3, -2, 590, -2)).addGroup(jPanel5Layout.createSequentialGroup().addComponent(this.panelCalendario, -2, 280, -2).addGap(10, 10, 10).addComponent(this.JCBEmpresa, -2, -1, -2).addGap(1, 1, 1).addComponent(this.JCBSede, -2, -1, -2).addGap(1, 1, 1).addComponent(this.jPanel1, -2, -1, -2))).addContainerGap(13, 32767)));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel5, -2, -1, -2));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel5, -1, -1, 32767));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ArbolValueChanged(TreeSelectionEvent evt) {
        evaluarNodo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mnAsignarActionPerformed(ActionEvent evt) {
        asignarCita();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mnDesistirActionPerformed(ActionEvent evt) {
        desistir();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mnSalirActionPerformed(ActionEvent evt) {
        this.mnPopup.setVisible(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cboClaseCitaActionPerformed(ActionEvent evt) {
        if (this.combocc == 1 && this.cboClaseCita.getSelectedIndex() > -1) {
            this.txtDuracion.setText(this.listaClaseCita[this.cboClaseCita.getSelectedIndex()][1]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mnRecordatorioActionPerformed(ActionEvent evt) {
        this.mnPopup.setVisible(false);
        mImprimirRecordatorio(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gridMousePressed(MouseEvent evt) {
        if (evt.getButton() == 3) {
            this.mnPopup.setVisible(true);
            this.mnPopup.setLocation(evt.getLocationOnScreen().x, evt.getLocationOnScreen().y);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mnReasignarActionPerformed(ActionEvent evt) {
        reasignar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gridMouseMoved(MouseEvent evt) {
        this.grid.setToolTipText(this.modeloGrid.getValueAt(this.filaGrid, 5).toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gridMouseClicked(MouseEvent evt) {
        this.filaGrid = this.grid.getSelectedRow();
        if ((this.grid.getSelectedRow() != -1 && this.modeloGrid.getValueAt(this.grid.getSelectedRow(), 13).equals("1")) || this.modeloGrid.getValueAt(this.grid.getSelectedRow(), 13).equals("3")) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Desea cargar la Historia?", "HISTORIA", 0);
            if (n == 0) {
                this.xclasescita.setxIdIngreso(Long.valueOf(this.grid.getValueAt(this.grid.getSelectedRow(), 9).toString()).longValue());
                this.frmPersona.txtHistoria.setText(this.grid.getValueAt(this.grid.getSelectedRow(), 7).toString());
                this.frmPersona.buscar(2);
                this.xclasescita.setxIdIngreso(Long.valueOf(this.modeloGrid.getValueAt(this.grid.getSelectedRow(), 9).toString()).longValue());
                this.xclasescita.setxNHistoria(this.frmPersona.txtHistoria.getText());
                this.xclasescita.setXidcita(Long.valueOf(this.modeloGrid.getValueAt(this.grid.getSelectedRow(), 3).toString()).longValue());
                this.xclasescita.cargarPantalla(this.xclasescita.frmPrincipal, "Historia FT");
                if (this.modeloGrid.getValueAt(this.grid.getSelectedRow(), 5).toString().equals("TERAPIA FISICA")) {
                    this.xclasescita.setxTipoTerapia(1L);
                    this.xclasescita.xjifhistoriaft.mTerapiasFis();
                } else {
                    this.xclasescita.setxTipoTerapia(0L);
                    this.xclasescita.xjifhistoriaft.mTerapiasResp();
                }
                setVisible(false);
                setVisible(false);
                return;
            }
            Principal.txtNo.setText(this.modeloGrid.getValueAt(this.grid.getSelectedRow(), 3).toString());
            Principal.txtEstado.setText("ACTIVA");
            Principal.txtFecha.setText(this.metodos.formatoDMA.format(this.frmCalendario.getFecha().getTime()));
            this.xclasescita.setxIdIngreso(Long.valueOf(this.grid.getValueAt(this.grid.getSelectedRow(), 9).toString()).longValue());
            this.frmPersona.txtHistoria.setText(this.grid.getValueAt(this.grid.getSelectedRow(), 7).toString());
            this.frmPersona.buscar(2);
            if (Principal.informacionIps.getEsFpz().intValue() == 0) {
                this.JTFFNorden.setBorder(BorderFactory.createTitledBorder((Border) null, "No. Orden", 2, 0, new Font("Arial", 1, 12), Color.blue));
                this.JTFFNorden.setText(mTraerNOrdenIngreso());
                return;
            } else {
                this.JTFFNorden.setBorder(BorderFactory.createTitledBorder((Border) null, "No. Ingreso", 2, 0, new Font("Arial", 1, 12), Color.blue));
                this.JTFFNorden.setText(this.grid.getValueAt(this.grid.getSelectedRow(), 9).toString());
                return;
            }
        }
        if ((this.grid.getSelectedRow() != -1 && this.modeloGrid.getValueAt(this.grid.getSelectedRow(), 13).equals("1")) || this.modeloGrid.getValueAt(this.grid.getSelectedRow(), 13).equals("0")) {
            this.cboClaseCita.setSelectedItem(this.modeloGrid.getValueAt(this.grid.getSelectedRow(), 5));
            Principal.txtNo.setText(this.modeloGrid.getValueAt(this.grid.getSelectedRow(), 3).toString());
            Principal.txtEstado.setText("ACTIVA");
            Principal.txtFecha.setText(this.metodos.formatoDMA.format(this.frmCalendario.getFecha().getTime()));
            if (Principal.informacionIps.getEsFpz().intValue() == 0) {
                this.JTFFNorden.setBorder(BorderFactory.createTitledBorder((Border) null, "No. Orden", 2, 0, new Font("Arial", 1, 12), Color.blue));
                this.JTFFNorden.setText(mTraerNOrdenIngreso());
            } else {
                this.JTFFNorden.setBorder(BorderFactory.createTitledBorder((Border) null, "No. Ingreso", 2, 0, new Font("Arial", 1, 12), Color.blue));
                this.JTFFNorden.setText(this.grid.getValueAt(this.grid.getSelectedRow(), 9).toString());
            }
            this.frmPersona.txtHistoria.setText(this.grid.getValueAt(this.grid.getSelectedRow(), 7).toString());
            this.frmPersona.buscar(2);
            return;
        }
        Principal.txtNo.setText("");
        Principal.txtEstado.setText("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gridMouseEntered(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gridMouseExited(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gridMouseReleased(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gridMouseDragged(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mnLlamarActionPerformed(ActionEvent evt) {
        llamarUsuario();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jLabel4MouseClicked(MouseEvent evt) {
        JIFCarneCitas frmB = new JIFCarneCitas(null, true, this.frmPersona.getIdPersona(), "CitaTerapia", this);
        frmB.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIFacturacionActionPerformed(ActionEvent evt) {
        if (this.modeloGrid.getValueAt(this.filaGrid, 13).toString().equals("0")) {
            this.mnPopup.setVisible(false);
            Principal.clasescita.frmPrincipal.mIniciarDatosFacturacion();
            Principal.clasefacturacion.frmFacturac.frmPersona.txtHistoria.setText(this.frmPersona.txtHistoria.getText());
            Principal.clasefacturacion.frmFacturac.frmPersona.buscar(2);
            setVisible(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosing(InternalFrameEvent evt) {
        Principal.mLimpiarDatosP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBEmpresaActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFNordenMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            if (this.JTFFNorden.getText().isEmpty()) {
                if (!this.frmPersona.getIdPersona().equals("0")) {
                    if (!this.idEspecialidad.equals("")) {
                        JDConsultarIngreso xJDConsultarIngreso = new JDConsultarIngreso(null, true, this.frmPersona.getIdPersona(), "CTerapias", this.idEspecialidad);
                        xJDConsultarIngreso.setLocationRelativeTo(this);
                        xJDConsultarIngreso.setVisible(true);
                        return;
                    }
                    JOptionPane.showInternalMessageDialog(this, "Debe selecionar una especialidad", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Debe selecionar un usuario", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                return;
            }
            if (!this.frmPersona.getIdPersona().equals("0")) {
                if (!this.idEspecialidad.equals("")) {
                    JDConsultarIngreso xJDConsultarIngreso2 = new JDConsultarIngreso(null, true, this.frmPersona.getIdPersona(), "CTerapias", this.idEspecialidad);
                    xJDConsultarIngreso2.setLocationRelativeTo(this);
                    xJDConsultarIngreso2.setVisible(true);
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Debe selecionar una especialidad", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe selecionar un usuario", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBSedeActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mnRecordatorio1ActionPerformed(ActionEvent evt) {
        this.mnPopup.setVisible(false);
        mImprimirRecordatorio(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mnCertificadoActionPerformed(ActionEvent evt) {
        this.mnPopup.setVisible(false);
        mImprimirCertificado();
    }

    public String getxIdIngreso() {
        return this.xIdIngreso;
    }

    public void setxIdIngreso(String xIdIngreso) {
        this.xIdIngreso = xIdIngreso;
    }
}
