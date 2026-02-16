package Citas;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JCalendar;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.DecimalFormat;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.LayoutStyle;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

/* JADX INFO: loaded from: GenomaP.jar:Citas/ReporteCitas.class */
public class ReporteCitas extends JDialog {
    private Metodos metodos;
    private ConsultasMySQL consultas;
    private String[] listaProfesional;
    private String[][] listaEspecialidad;
    private int cboLleno;
    private int tipo;
    private String sql;
    private JCheckBox JCHFiltro;
    private JButton btnAceptar;
    private JButton btnSalir;
    private JComboBox cboEspecialidad;
    private JComboBox cboProfesional;
    private JCalendar fechaFinal;
    private JCalendar fechaInicial;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JLabel lblTitulo;
    private JFormattedTextField txtCantidad;
    private JSpinner txtEdadFin;
    private JSpinner txtEdadIni;

    public ReporteCitas(Frame parent, boolean modal, int Tipo) {
        super(parent, modal);
        this.metodos = new Metodos();
        this.consultas = new ConsultasMySQL();
        this.cboLleno = 0;
        initComponents();
        this.tipo = Tipo;
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        setLocationRelativeTo(null);
        cargarComboEspecialidad();
        evaluarTipoInforme();
    }

    private void activarObjetos() {
        this.cboEspecialidad.setEnabled(true);
        this.cboProfesional.setEnabled(true);
        this.fechaInicial.setEnabled(true);
        this.fechaFinal.setEnabled(true);
    }

    private void cargarComboEspecialidad() {
        this.listaEspecialidad = this.consultas.llenarComboyLista("SELECT g_especialidad.Id, g_especialidad.Nbre, g_especialidad.EsOdontologia FROM g_especialidad INNER JOIN c_citas  ON (g_especialidad.Id = c_citas.Id_Especialidad) WHERE (g_especialidad.Estado =0) GROUP BY g_especialidad.Id ORDER BY g_especialidad.Nbre ASC", this.listaEspecialidad, this.cboEspecialidad, 3);
        this.cboEspecialidad.setSelectedIndex(-1);
        this.cboLleno = 1;
        this.consultas.cerrarConexionBd();
    }

    private void cargarComboProfesional() {
        this.cboProfesional.removeAllItems();
        if (this.tipo == 2) {
            this.sql = "SELECT profesional1.Id_Persona, profesional1.NProfesional FROM profesional1 INNER JOIN c_citasnp  ON (profesional1.Id_Persona = c_citasnp.Id_Profesional) AND (profesional1.IdEspecialidad = c_citasnp.Id_Especialidad) WHERE (profesional1.Estado =0 AND profesional1.IdEspecialidad ='" + this.listaEspecialidad[this.cboEspecialidad.getSelectedIndex()][0] + "') GROUP BY profesional1.Id_Persona ORDER BY profesional1.NProfesional ASC ";
        } else {
            this.sql = "SELECT profesional1.Id_Persona, profesional1.NProfesional FROM profesional1 INNER JOIN c_citas  ON (profesional1.Id_Persona = c_citas.Id_Profesional) AND (profesional1.IdEspecialidad = c_citas.Id_Especialidad) WHERE (profesional1.Estado =0 AND profesional1.IdEspecialidad ='" + this.listaEspecialidad[this.cboEspecialidad.getSelectedIndex()][0] + "') GROUP BY profesional1.Id_Persona ORDER BY profesional1.NProfesional ASC ";
        }
        this.listaProfesional = this.consultas.llenarCombo(this.sql, this.listaProfesional, this.cboProfesional);
        this.cboLleno = 1;
        this.consultas.cerrarConexionBd();
    }

    private void desactivarObjetos() {
        this.cboEspecialidad.setEnabled(false);
        this.cboProfesional.setEnabled(false);
        this.fechaInicial.setEnabled(false);
        this.fechaFinal.setEnabled(false);
    }

    private void evaluarReporte() {
        if (this.cboProfesional.getSelectedIndex() < 0) {
            this.metodos.mostrarMensaje("Por favor seleccione un Profesional.");
            this.cboProfesional.requestFocus();
            return;
        }
        if (this.cboEspecialidad.getSelectedIndex() < 0) {
            this.metodos.mostrarMensaje("Por favor seleccione una Especialidad.");
            this.cboEspecialidad.requestFocus();
            return;
        }
        String nbreArchivo = "";
        String[][] parametros = (String[][]) null;
        if (this.tipo == 1) {
            parametros = new String[10][2];
            parametros[0][0] = "idprofesional";
            parametros[0][1] = this.listaProfesional[this.cboProfesional.getSelectedIndex()];
            parametros[1][0] = "idespecialidad";
            parametros[1][1] = this.listaEspecialidad[this.cboEspecialidad.getSelectedIndex()][0];
            parametros[2][0] = "fechaInicial";
            parametros[2][1] = this.metodos.formatoAMD.format(this.fechaInicial.getDate());
            parametros[3][0] = "fechaFinal";
            parametros[3][1] = this.metodos.formatoAMD.format(this.fechaFinal.getDate());
            if (this.listaEspecialidad[this.cboEspecialidad.getSelectedIndex()][1].toString().equals("1")) {
                parametros[4][0] = "nbreProfesional";
                parametros[4][1] = this.cboProfesional.getSelectedItem().toString();
                parametros[5][0] = "nbreEspecialidad";
                parametros[5][1] = this.cboEspecialidad.getSelectedItem().toString();
                nbreArchivo = "C_SisOdontologia";
            } else {
                parametros[4][0] = "nbreProfesional";
                parametros[4][1] = this.cboProfesional.getSelectedItem().toString();
                parametros[5][0] = "nbreEspecialidad";
                parametros[5][1] = this.cboEspecialidad.getSelectedItem().toString();
                if (Principal.informacionIps.getPrefijoReportes().equals("")) {
                    nbreArchivo = "C_ReporteDeCitasPorMedico";
                } else {
                    nbreArchivo = Principal.informacionIps.getPrefijoReportes() + "C_ReporteDeCitasPorMedico";
                }
            }
            parametros[6][0] = "ruta";
            parametros[6][1] = this.metodos.getRutaRep();
            parametros[7][0] = "SUBREPORT_DIR";
            parametros[7][1] = this.metodos.getSO() + this.metodos.getBarra() + "Reportes" + this.metodos.getBarra();
            parametros[8][0] = "SUBREPORTFIRMA_DIR";
            parametros[8][1] = this.metodos.getSO() + this.metodos.getBarra() + "Firmas" + this.metodos.getBarra();
            parametros[9][0] = "usuarioSistema";
            parametros[9][1] = Principal.usuarioSistemaDTO.getNombreUsuario();
        } else if (this.tipo == 2) {
            this.fechaInicial.setEnabled(true);
            this.fechaFinal.setEnabled(true);
            this.cboEspecialidad.setEditable(true);
            parametros = new String[9][2];
            parametros[0][0] = "idEspecialidad";
            parametros[0][1] = this.listaEspecialidad[this.cboEspecialidad.getSelectedIndex()][0];
            parametros[1][0] = "nbreEspecialidad";
            parametros[1][1] = this.cboEspecialidad.getSelectedItem().toString();
            parametros[2][0] = "fechaInicial";
            parametros[2][1] = this.metodos.formatoAMD.format(this.fechaInicial.getDate());
            parametros[3][0] = "fechaFinal";
            parametros[3][1] = this.metodos.formatoAMD.format(this.fechaFinal.getDate());
            parametros[4][0] = "ruta";
            parametros[4][1] = this.metodos.getRutaRep();
            parametros[5][0] = "idprofesional";
            parametros[5][1] = this.listaProfesional[this.cboProfesional.getSelectedIndex()];
            parametros[6][0] = "nbreprofesional";
            parametros[6][1] = this.cboProfesional.getSelectedItem().toString();
            parametros[7][0] = "SUBREPORT_DIR";
            parametros[7][1] = this.metodos.getSO() + this.metodos.getBarra() + "Reportes" + this.metodos.getBarra();
            parametros[8][0] = "SUBREPORTFIRMA_DIR";
            parametros[8][1] = this.metodos.getSO() + this.metodos.getBarra() + "Firmas" + this.metodos.getBarra();
            nbreArchivo = Principal.informacionIps.getEsFpz().intValue() == 0 ? "C_CitasNoProgramadas" : this.JCHFiltro.isSelected() ? "C_CitasNoProgramadas_FiltroP" : "C_CitasNoProgramadas_1";
        } else if (this.tipo == 3) {
            parametros = new String[10][2];
            parametros[0][0] = "idprofesional";
            parametros[0][1] = this.listaProfesional[this.cboProfesional.getSelectedIndex()];
            parametros[1][0] = "nbreprofesional";
            parametros[1][1] = this.cboProfesional.getSelectedItem().toString();
            parametros[2][0] = "idespecialidad";
            parametros[2][1] = this.listaEspecialidad[this.cboEspecialidad.getSelectedIndex()][0];
            parametros[3][0] = "nbreespecialidad";
            parametros[3][1] = this.cboEspecialidad.getSelectedItem().toString();
            parametros[4][0] = "fechaInicial";
            parametros[4][1] = this.metodos.formatoAMD.format(this.fechaInicial.getDate());
            parametros[5][0] = "fechaFinal";
            parametros[5][1] = this.metodos.formatoAMD.format(this.fechaFinal.getDate());
            parametros[6][0] = "ruta";
            parametros[6][1] = this.metodos.getRutaRep();
            parametros[7][0] = "SUBREPORT_DIR";
            parametros[7][1] = this.metodos.getSO() + this.metodos.getBarra() + "Reportes" + this.metodos.getBarra();
            parametros[8][0] = "SUBREPORTFIRMA_DIR";
            parametros[8][1] = this.metodos.getSO() + this.metodos.getBarra() + "Firmas" + this.metodos.getBarra();
            parametros[9][0] = "usuarioSistema";
            parametros[9][1] = Principal.usuarioSistemaDTO.getNombreUsuario();
            nbreArchivo = Principal.informacionIps.getPrefijoReportes().equals("") ? "C_ReporteDeCitasNoAtendidas" : Principal.informacionIps.getPrefijoReportes() + "C_ReporteDeCitasNoAtendidas";
        } else if (this.tipo == 4) {
            parametros = new String[9][2];
            parametros[0][0] = "idprofesional";
            parametros[0][1] = this.listaProfesional[this.cboProfesional.getSelectedIndex()];
            parametros[1][0] = "nbreprofesional";
            parametros[1][1] = this.cboProfesional.getSelectedItem().toString();
            parametros[2][0] = "idespecialidad";
            parametros[2][1] = this.listaEspecialidad[this.cboEspecialidad.getSelectedIndex()][0];
            parametros[3][0] = "nbreespecialidad";
            parametros[3][1] = this.cboEspecialidad.getSelectedItem().toString();
            parametros[4][0] = "fechaInicial";
            parametros[4][1] = this.metodos.formatoAMD.format(this.fechaInicial.getDate());
            parametros[5][0] = "fechaFinal";
            parametros[5][1] = this.metodos.formatoAMD.format(this.fechaFinal.getDate());
            parametros[6][0] = "ruta";
            parametros[6][1] = this.metodos.getRutaRep();
            parametros[7][0] = "SUBREPORT_DIR";
            parametros[7][1] = this.metodos.getSO() + this.metodos.getBarra() + "Reportes" + this.metodos.getBarra();
            parametros[8][0] = "SUBREPORTFIRMA_DIR";
            parametros[8][1] = this.metodos.getSO() + this.metodos.getBarra() + "Firmas" + this.metodos.getBarra();
            nbreArchivo = "C_AsignacionDeCitasPorUsuario";
        } else if (this.tipo == 5) {
            this.sql = "SELECT COUNT(c_citas.Id) FROM c_citas INNER JOIN persona ON (c_citas.Id_Usuario = persona.Id_persona) WHERE (c_citas.Id_Profesional ='" + this.listaProfesional[this.cboProfesional.getSelectedIndex()] + "' AND c_citas.Id_Especialidad = '" + this.listaEspecialidad[this.cboEspecialidad.getSelectedIndex()][0] + "' AND c_citas.Fecha_Cita >='" + this.metodos.formatoAMD.format(this.fechaInicial.getDate()) + "' AND c_citas.Fecha_Cita <='" + this.metodos.formatoAMD.format(this.fechaFinal.getDate()) + "' AND c_citas.PrimerVez =1 AND c_citas.Id_MotivoDesistida =1  AND persona.Edad >'" + this.txtEdadIni.getValue() + "' AND persona.Edad <'" + this.txtEdadFin.getValue() + "' ) GROUP BY c_citas.PrimerVez";
            String dato = this.consultas.traerDato(this.sql);
            this.consultas.cerrarConexionBd();
            if (dato != null && !dato.equals("")) {
                this.txtCantidad.setValue(Integer.valueOf(Integer.parseInt(this.consultas.traerDato(this.sql))));
            } else {
                this.txtCantidad.setValue(0);
            }
        } else if (this.tipo == 6) {
            parametros = new String[10][2];
            parametros[0][0] = "idprofesional";
            parametros[0][1] = this.listaProfesional[this.cboProfesional.getSelectedIndex()];
            parametros[1][0] = "nbreprofesional";
            parametros[1][1] = this.cboProfesional.getSelectedItem().toString();
            parametros[2][0] = "idespecialidad";
            parametros[2][1] = this.listaEspecialidad[this.cboEspecialidad.getSelectedIndex()][0];
            parametros[3][0] = "nbreespecialidad";
            parametros[3][1] = this.cboEspecialidad.getSelectedItem().toString();
            parametros[4][0] = "fechaInicial";
            parametros[4][1] = this.metodos.formatoAMD.format(this.fechaInicial.getDate());
            parametros[5][0] = "fechaFinal";
            parametros[5][1] = this.metodos.formatoAMD.format(this.fechaFinal.getDate());
            parametros[6][0] = "ruta";
            parametros[6][1] = this.metodos.getRutaRep();
            parametros[7][0] = "SUBREPORT_DIR";
            parametros[7][1] = this.metodos.getSO() + this.metodos.getBarra() + "Reportes" + this.metodos.getBarra();
            parametros[8][0] = "SUBREPORTFIRMA_DIR";
            parametros[8][1] = this.metodos.getSO() + this.metodos.getBarra() + "Firmas" + this.metodos.getBarra();
            parametros[9][0] = "usuarioSistema";
            parametros[9][1] = Principal.usuarioSistemaDTO.getNombreUsuario();
            nbreArchivo = Principal.informacionIps.getPrefijoReportes().equals("") ? "C_ReporteDeCitasAtendidas" : Principal.informacionIps.getPrefijoReportes() + "C_ReporteDeCitasAtendidas";
        }
        if (this.tipo != 5) {
            this.metodos.GenerarPDF(this.metodos.getRutaRep() + nbreArchivo, parametros);
        }
    }

    private void evaluarTipoInforme() {
        if (this.tipo == 1) {
            this.lblTitulo.setText("REPORTE DE CITAS POR PROFESIONAL");
            activarObjetos();
            return;
        }
        if (this.tipo == 2) {
            this.lblTitulo.setText("REPORTE DE CITAS NO PROGRAMADAS");
            activarObjetos();
            this.cboEspecialidad.setEnabled(true);
            this.fechaInicial.setEnabled(true);
            this.fechaFinal.setEnabled(true);
            return;
        }
        if (this.tipo == 3) {
            this.lblTitulo.setText("REPORTE DE CITAS NO ASISTIDAS");
            activarObjetos();
            return;
        }
        if (this.tipo == 4) {
            this.lblTitulo.setText("REPORTE DE CITAS Y USUARIOS QUE LA ASIGNAN");
            return;
        }
        if (this.tipo == 5) {
            this.lblTitulo.setText("REPORTE DE CITAS DE PRIMER VEZ");
            activarObjetos();
            this.txtEdadIni.setEnabled(true);
            this.txtEdadFin.setEnabled(true);
            return;
        }
        if (this.tipo == 6) {
            this.lblTitulo.setText("REPORTE DE CITAS ATENDIDAS");
            activarObjetos();
            this.cboEspecialidad.setEnabled(true);
            this.fechaInicial.setEnabled(true);
            this.fechaFinal.setEnabled(true);
        }
    }

    private void initComponents() {
        this.jPanel1 = new JPanel();
        this.cboProfesional = new JComboBox();
        this.cboEspecialidad = new JComboBox();
        this.fechaInicial = new JCalendar();
        this.fechaFinal = new JCalendar();
        this.btnAceptar = new JButton();
        this.btnSalir = new JButton();
        this.jPanel2 = new JPanel();
        this.jLabel3 = new JLabel();
        this.txtEdadIni = new JSpinner();
        this.jLabel4 = new JLabel();
        this.txtEdadFin = new JSpinner();
        this.jLabel5 = new JLabel();
        this.txtCantidad = new JFormattedTextField();
        this.JCHFiltro = new JCheckBox();
        this.lblTitulo = new JLabel();
        setDefaultCloseOperation(2);
        setTitle("REPORTE DE CITAS");
        setModal(true);
        this.jPanel1.setBorder(BorderFactory.createEtchedBorder());
        this.cboProfesional.setFont(new Font("Arial", 1, 12));
        this.cboProfesional.setBorder(BorderFactory.createTitledBorder((Border) null, "Profesional", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.cboEspecialidad.setFont(new Font("Arial", 1, 12));
        this.cboEspecialidad.setBorder(BorderFactory.createTitledBorder((Border) null, "Especialidad", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.cboEspecialidad.addItemListener(new ItemListener() { // from class: Citas.ReporteCitas.1
            public void itemStateChanged(ItemEvent evt) {
                ReporteCitas.this.cboEspecialidadItemStateChanged(evt);
            }
        });
        this.fechaInicial.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicio", 0, 0, new Font("Arial", 1, 12), new Color(0, 102, 102)));
        this.fechaInicial.setFont(new Font("Arial", 1, 12));
        this.fechaInicial.setWeekOfYearVisible(false);
        this.fechaFinal.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Final", 0, 0, new Font("Arial", 1, 12), new Color(0, 102, 102)));
        this.fechaFinal.setFont(new Font("Arial", 1, 12));
        this.fechaFinal.setWeekOfYearVisible(false);
        this.btnAceptar.setFont(new Font("Arial", 1, 12));
        this.btnAceptar.setForeground(new Color(0, 0, 153));
        this.btnAceptar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.btnAceptar.setText("Aceptar");
        this.btnAceptar.addActionListener(new ActionListener() { // from class: Citas.ReporteCitas.2
            public void actionPerformed(ActionEvent evt) {
                ReporteCitas.this.btnAceptarActionPerformed(evt);
            }
        });
        this.btnSalir.setFont(new Font("Arial", 1, 12));
        this.btnSalir.setForeground(new Color(0, 0, 153));
        this.btnSalir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.btnSalir.setText("Salir");
        this.btnSalir.addActionListener(new ActionListener() { // from class: Citas.ReporteCitas.3
            public void actionPerformed(ActionEvent evt) {
                ReporteCitas.this.btnSalirActionPerformed(evt);
            }
        });
        this.jPanel2.setBorder(BorderFactory.createTitledBorder((Border) null, "Rango de Edad en Citas de Primer Vez", 0, 0, new Font("Arial", 1, 12), new Color(255, 0, 0)));
        this.jLabel3.setFont(new Font("Arial", 1, 12));
        this.jLabel3.setForeground(new Color(0, 0, 153));
        this.jLabel3.setText("Edad Inicial");
        this.txtEdadIni.setFont(new Font("Arial", 1, 14));
        this.txtEdadIni.setModel(new SpinnerNumberModel(0, 0, (Comparable) null, 1));
        this.txtEdadIni.setEnabled(false);
        this.jLabel4.setFont(new Font("Arial", 1, 12));
        this.jLabel4.setForeground(new Color(0, 0, 153));
        this.jLabel4.setText("Edad Final");
        this.txtEdadFin.setFont(new Font("Arial", 1, 14));
        this.txtEdadFin.setModel(new SpinnerNumberModel(0, 0, (Comparable) null, 1));
        this.txtEdadFin.setEnabled(false);
        this.jLabel5.setFont(new Font("Arial", 1, 12));
        this.jLabel5.setForeground(new Color(0, 0, 153));
        this.jLabel5.setText("Cantidad");
        this.txtCantidad.setBackground(new Color(102, 0, 102));
        this.txtCantidad.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.txtCantidad.setHorizontalAlignment(4);
        this.txtCantidad.setDisabledTextColor(new Color(0, 0, 102));
        this.txtCantidad.setEnabled(false);
        this.txtCantidad.setFont(new Font("Arial", 1, 18));
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.jLabel3).addGap(12, 12, 12)).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.txtEdadIni, -2, 56, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED))).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.txtEdadFin, -2, 56, -2).addComponent(this.jLabel4)).addGap(13, 13, 13).addComponent(this.jLabel5).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.txtCantidad).addContainerGap()));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(GroupLayout.Alignment.LEADING, jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel3).addComponent(this.jLabel4)).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap(-1, 32767).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.txtEdadFin, -2, 25, -2).addComponent(this.txtEdadIni, -2, -1, -2))).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.txtCantidad).addComponent(this.jLabel5))).addContainerGap()));
        this.JCHFiltro.setFont(new Font("Arial", 1, 12));
        this.JCHFiltro.setText("Filtro");
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel2, -1, -1, 32767).addComponent(this.fechaInicial, -1, -1, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.fechaFinal, GroupLayout.Alignment.LEADING, -1, -1, 32767).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.btnAceptar, -1, -1, 32767).addGap(18, 18, 18).addComponent(this.btnSalir, -2, 159, -2)))).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.cboEspecialidad, -2, 296, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.cboProfesional, 0, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHFiltro))).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.cboEspecialidad, -2, 50, -2).addComponent(this.cboProfesional, -2, 50, -2)).addComponent(this.JCHFiltro, GroupLayout.Alignment.TRAILING)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.fechaInicial, -2, 205, -2).addComponent(this.fechaFinal, -2, 205, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel2, -1, -1, 32767).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.btnAceptar, -2, 74, -2).addComponent(this.btnSalir, -2, 76, -2)).addGap(0, 2, 32767))).addContainerGap()));
        this.lblTitulo.setBackground(new Color(0, 0, 102));
        this.lblTitulo.setFont(new Font("Arial", 1, 16));
        this.lblTitulo.setForeground(new Color(204, 255, 255));
        this.lblTitulo.setHorizontalAlignment(0);
        this.lblTitulo.setText("jLabel3");
        this.lblTitulo.setOpaque(true);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.lblTitulo, -1, 748, 32767).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -1, -1, 32767).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.lblTitulo, -2, 40, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel1, -2, -1, -2).addContainerGap(-1, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnSalirActionPerformed(ActionEvent evt) {
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnAceptarActionPerformed(ActionEvent evt) {
        evaluarReporte();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cboEspecialidadItemStateChanged(ItemEvent evt) {
        if (this.cboLleno == 1 && this.cboEspecialidad.getSelectedIndex() > -1) {
            cargarComboProfesional();
        }
    }
}
