package Citas;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JCalendar;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.GregorianCalendar;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

/* JADX INFO: loaded from: GenomaP.jar:Citas/PasarTurnos.class */
public class PasarTurnos extends JInternalFrame {
    private String[][] listaProfesional;
    private String sql;
    private String nbreProfesional1;
    private String idProfesional1;
    private String especialAnterior1;
    private String nbreProfesional2;
    private String idProfesional2;
    private String especialidad1;
    private String especialidad2;
    private ResultSet rs;
    private JTree Arbol1;
    private JTree Arbol2;
    private JCalendar CalendarioD;
    private JCalendar CalendarioO;
    private JRadioButton btnEntreProfesional;
    private JRadioButton btnMismoProfesional;
    private ButtonGroup buttonGroup1;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JPanel jPanel3;
    private JPanel jPanel4;
    private JPanel jPanel5;
    private JRadioButton jRadioButton1;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JTextField txtDestino;
    private JTextField txtFechaD;
    private JTextField txtFechaO;
    private JTextField txtOrigen;
    private ConsultasMySQL consultas = new ConsultasMySQL();
    private Metodos metodos = new Metodos();
    private int puedeGrabar = 0;
    private int tipoCambio = 1;
    private DefaultMutableTreeNode tallo1 = new DefaultMutableTreeNode("ESPECIALIDADES");
    private DefaultMutableTreeNode tallo2 = new DefaultMutableTreeNode("ESPECIALIDADES");
    private DefaultMutableTreeNode rama1 = new DefaultMutableTreeNode("PROFESIONALES");
    private DefaultMutableTreeNode rama2 = new DefaultMutableTreeNode("PROFESIONALES");
    private DefaultMutableTreeNode hoja1 = new DefaultMutableTreeNode("MEDICOS");
    private DefaultMutableTreeNode hoja2 = new DefaultMutableTreeNode("MEDICOS");
    private DefaultTreeModel modeloArbol1 = new DefaultTreeModel(this.tallo1);
    private DefaultTreeModel modeloArbol2 = new DefaultTreeModel(this.tallo2);
    private DefaultMutableTreeNode nodo1 = new DefaultMutableTreeNode();
    private DefaultMutableTreeNode nodo2 = new DefaultMutableTreeNode();

    public PasarTurnos() {
        initComponents();
        cargarArbol();
        activarObjetos();
    }

    private void activarObjetos() {
        this.Arbol2.setEnabled(true);
        this.CalendarioD.setEnabled(true);
        if (this.tipoCambio == 1) {
            this.Arbol2.setEnabled(false);
        } else if (this.tipoCambio == 2) {
            this.CalendarioD.setEnabled(false);
        } else if (this.tipoCambio == 3) {
            this.Arbol2.setEnabled(false);
        }
    }

    private void actualizarCita(String profesional1, String fecha, String profesional2, String fecha2) {
        this.sql = "UPDATE c_citas SET Id_Profesional = '" + profesional1 + "', Id_Especialidad = '" + this.especialidad1 + "', Fecha_Cita = '" + fecha + "', Fecha = '" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "', UsuarioS = '" + Principal.usuarioSistemaDTO.getLogin() + "' WHERE (Id_Profesional = '" + profesional2 + "' AND Id_Especialidad = '" + this.especialidad1 + "' AND Fecha_Cita ='" + fecha2 + "')";
        this.consultas.ejecutarSQL(this.sql);
        this.consultas.cerrarConexionBd();
    }

    private void actualizarConfCita(String profesional1, String fecha, String profesional2, String fecha2) {
        GregorianCalendar fech = new GregorianCalendar();
        int xDia = fech.get(7) - 1;
        this.sql = "UPDATE c_confcitas SET Id_Profesional = '" + profesional1 + "', Id_Especialidad = '" + this.especialidad1 + "', DiaSemana = '" + xDia + "', Fecha_ConfCitas = '" + fecha + "', UsuarioS = '" + Principal.usuarioSistemaDTO.getLogin() + "' WHERE (Id_Profesional = '" + profesional2 + "' AND Id_Especialidad = '" + this.especialidad1 + "' AND Fecha_ConfCitas ='" + fecha2 + "')";
        this.consultas.ejecutarSQL(this.sql);
        this.consultas.cerrarConexionBd();
    }

    private void cargarArbol() {
        this.sql = "SELECT g_profesionalespecial.Id_Especialidad, g_especialidad.Nbre, g_persona.Apellido1, g_persona.Apellido2, g_persona.Nombre1, g_persona.Nombre2, g_persona.Id FROM baseserver.g_profesional INNER JOIN baseserver.g_profesionalespecial ON (g_profesional.Id_Persona = g_profesionalespecial.Id_Profesional) INNER JOIN baseserver.g_persona ON (g_profesional.Id_Persona = g_persona.Id) INNER JOIN baseserver.g_especialidad ON (g_profesionalespecial.Id_Especialidad = g_especialidad.Id) WHERE g_profesional.Activo_Cita = 0 ORDER BY g_especialidad.Nbre DESC, g_persona.Apellido1 DESC, g_persona.Apellido2 DESC, g_persona.Nombre1 DESC";
        try {
            this.rs = this.consultas.traerRs(this.sql);
            this.rs.last();
            this.listaProfesional = new String[this.rs.getRow() + 1][4];
            this.rs.beforeFirst();
            while (this.rs.next()) {
                this.nbreProfesional1 = this.rs.getString(3) + " " + this.rs.getString(4) + " " + this.rs.getString(5) + " " + this.rs.getString(6);
                this.nbreProfesional2 = this.nbreProfesional1;
                this.hoja1 = new DefaultMutableTreeNode(this.nbreProfesional1);
                this.hoja2 = new DefaultMutableTreeNode(this.nbreProfesional2);
                this.listaProfesional[this.rs.getRow()][0] = this.rs.getString(7);
                this.listaProfesional[this.rs.getRow()][1] = this.nbreProfesional1;
                this.listaProfesional[this.rs.getRow()][2] = this.rs.getString(1);
                this.listaProfesional[this.rs.getRow()][3] = this.rs.getString(2);
                if (!this.rs.getString(2).equals(this.especialAnterior1)) {
                    this.rama1 = new DefaultMutableTreeNode(this.rs.getString(2));
                    this.rama2 = new DefaultMutableTreeNode(this.rs.getString(2));
                    this.modeloArbol1.insertNodeInto(this.rama1, this.tallo1, 0);
                    this.modeloArbol2.insertNodeInto(this.rama2, this.tallo2, 0);
                    this.especialAnterior1 = this.rs.getString(2);
                }
                this.modeloArbol1.insertNodeInto(this.hoja1, this.rama1, 0);
                this.modeloArbol2.insertNodeInto(this.hoja2, this.rama2, 0);
            }
            this.rs.close();
            this.consultas.cerrarConexionBd();
            this.Arbol1.setModel(this.modeloArbol1);
            this.Arbol2.setModel(this.modeloArbol2);
            this.Arbol1.getSelectionModel().setSelectionMode(1);
            this.Arbol2.getSelectionModel().setSelectionMode(1);
            this.Arbol1.setScrollsOnExpand(true);
            this.Arbol2.setScrollsOnExpand(true);
            this.Arbol1.requestFocus();
        } catch (SQLException e) {
        }
    }

    private void copiarProgramacion() {
        try {
            this.sql = "SELECT Fecha_ConfCitas, TipoAgenda, DiaSemana, HoraInicial, HoraFinal, Cupo, Id_Consultorio FROM c_confcitas WHERE (Id_Profesional ='" + this.idProfesional1 + "' AND Id_Especialidad ='" + this.especialidad1 + "') ORDER BY Fecha_ConfCitas DESC";
            this.rs = this.consultas.traerRs(this.sql);
            this.rs.next();
            if (this.rs.getRow() > 0) {
                this.rs.beforeFirst();
                while (true) {
                    if (!this.rs.next()) {
                        break;
                    }
                    if (this.rs.getDate(1).getTime() <= this.CalendarioO.getDate().getTime()) {
                        this.sql = "SELECT Id_Usuario FROM c_citas WHERE (Id_Profesional ='" + this.idProfesional1 + "' AND Id_Especialidad ='" + this.especialidad1 + "' AND Fecha_Cita = '" + this.txtFechaD.getText() + "')";
                        String dato = this.consultas.traerDato(this.sql);
                        this.consultas.cerrarConexionBd();
                        if (!dato.isEmpty()) {
                            this.metodos.mostrarMensaje("El Profesional ya tiene Usuarios asignados\nen la fecha de destino, por favor verifique");
                        } else {
                            if (this.rs.getInt(2) == 1) {
                                grabarRegistro(this.rs, this.txtFechaO.getText(), this.idProfesional1, 3);
                                grabarRegistro(this.rs, this.txtFechaD.getText(), this.idProfesional1, 2);
                                actualizarCita(this.idProfesional1, this.txtFechaD.getText(), this.idProfesional1, this.txtFechaO.getText());
                            } else if (this.rs.getInt(2) == 2) {
                                actualizarConfCita(this.idProfesional1, this.txtFechaD.getText(), this.idProfesional1, this.txtFechaO.getText());
                                actualizarCita(this.idProfesional2, this.txtFechaD.getText(), this.idProfesional1, this.txtFechaO.getText());
                            }
                            this.metodos.mostrarMensaje("Cambio realizado, Ok");
                        }
                    }
                }
            } else {
                this.metodos.mostrarMensaje("El Profesional no tiene Programación para ese día.");
            }
            this.rs.close();
            this.consultas.cerrarConexionBd();
        } catch (SQLException ex) {
            this.consultas.mostrarErrorSQL(ex);
        }
    }

    public void grabar() {
        if (validarDatos() == 0 && this.metodos.getPregunta("Esta seguro de Grabar?") == 0) {
            if (this.tipoCambio == 1) {
                grabarMismoProfesional();
            } else if (this.tipoCambio == 2) {
                grabarDiferenteProfesional();
            } else if (this.tipoCambio == 3) {
                this.metodos.mostrarMensaje("Esta opción aun se encuentra pendiente por desarrollo");
            }
            this.consultas.cerrarConexionBd();
        }
    }

    private void grabarDiferenteProfesional() {
        try {
            this.sql = "SELECT Fecha_ConfCitas, TipoAgenda, DiaSemana, HoraInicial, HoraFinal, Cupo, Id_Consultorio FROM baseserver.c_confcitas WHERE (Id_Profesional ='" + this.idProfesional1 + "' AND Id_Especialidad ='" + this.especialidad1 + "' AND Estado = 0) ORDER BY Fecha_ConfCitas DESC";
            this.rs = this.consultas.traerRs(this.sql);
            this.rs.next();
            if (this.rs.getRow() > 0) {
                this.rs.beforeFirst();
                while (true) {
                    if (!this.rs.next()) {
                        break;
                    }
                    if (this.rs.getDate(1).getTime() <= this.CalendarioO.getDate().getTime()) {
                        this.sql = "SELECT Id_Usuario FROM baseserver.c_citas WHERE (Id_Profesional ='" + this.idProfesional2 + "' AND Fecha_Cita = '" + this.txtFechaD.getText() + "')";
                        String dato = this.consultas.traerDato(this.sql);
                        this.consultas.cerrarConexionBd();
                        if (!dato.isEmpty()) {
                            this.metodos.mostrarMensaje("El Profesional " + this.txtDestino.getText() + " ya tiene Usuarios asignados\nen la fecha de destino, por favor verifique");
                        } else {
                            if (this.rs.getInt(2) == 1) {
                                grabarRegistro(this.rs, this.txtFechaO.getText(), this.idProfesional1, 3);
                                grabarRegistro(this.rs, this.txtFechaD.getText(), this.idProfesional2, 2);
                                actualizarCita(this.idProfesional2, this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()), this.idProfesional1, this.txtFechaO.getText());
                            } else if (this.rs.getInt(2) == 2) {
                                actualizarConfCita(this.idProfesional2, this.txtFechaO.getText(), this.idProfesional1, this.txtFechaO.getText());
                                actualizarCita(this.idProfesional2, this.txtFechaO.getText(), this.idProfesional1, this.txtFechaO.getText());
                            }
                            this.metodos.mostrarMensaje("Cambio realizado, Ok");
                        }
                    }
                }
            } else {
                this.metodos.mostrarMensaje("El Profesional no tiene Programación para ese día.");
            }
            this.rs.close();
            this.consultas.cerrarConexionBd();
        } catch (SQLException ex) {
            this.consultas.mostrarErrorSQL(ex);
        }
    }

    private void grabarMismoProfesional() {
        try {
            this.sql = "SELECT Fecha_ConfCitas, TipoAgenda, DiaSemana, HoraInicial, HoraFinal, Cupo, Id_Consultorio FROM c_confcitas WHERE (Id_Profesional ='" + this.idProfesional1 + "' AND Id_Especialidad ='" + this.especialidad1 + "') ORDER BY Fecha_ConfCitas DESC";
            this.rs = this.consultas.traerRs(this.sql);
            this.rs.next();
            if (this.rs.getRow() > 0) {
                this.rs.beforeFirst();
                while (true) {
                    if (!this.rs.next()) {
                        break;
                    }
                    if (this.rs.getDate(1).getTime() <= this.CalendarioO.getDate().getTime()) {
                        this.sql = "SELECT Id_Usuario FROM c_citas WHERE (Id_Profesional ='" + this.idProfesional1 + "' AND Id_Especialidad ='" + this.especialidad1 + "' AND Fecha_Cita = '" + this.txtFechaD.getText() + "')";
                        String dato = this.consultas.traerDato(this.sql);
                        if (!dato.isEmpty()) {
                            this.metodos.mostrarMensaje("El Profesional ya tiene Usuarios asignados\nen la fecha de destino, por favor verifique");
                        } else {
                            if (this.rs.getInt(2) == 1) {
                                grabarRegistro(this.rs, this.txtFechaO.getText(), this.idProfesional1, 3);
                                grabarRegistro(this.rs, this.txtFechaD.getText(), this.idProfesional1, 2);
                                actualizarCita(this.idProfesional1, this.txtFechaD.getText(), this.idProfesional1, this.txtFechaO.getText());
                            } else if (this.rs.getInt(2) == 2) {
                                actualizarConfCita(this.idProfesional1, this.txtFechaD.getText(), this.idProfesional1, this.txtFechaO.getText());
                                actualizarCita(this.idProfesional2, this.txtFechaD.getText(), this.idProfesional1, this.txtFechaO.getText());
                            }
                            this.metodos.mostrarMensaje("Cambio realizado, Ok");
                        }
                    }
                }
            } else {
                this.metodos.mostrarMensaje("El Profesional no tiene Programación para ese día.");
            }
            this.rs.close();
            this.consultas.cerrarConexionBd();
        } catch (SQLException ex) {
            this.consultas.mostrarErrorSQL(ex);
        }
    }

    private void grabarRegistro(ResultSet rs, String fecha, String profesional, int tipoAgenda) {
        try {
            this.sql = "INSERT INTO c_confcitas (Id_Profesional, Id_Especialidad, Id_Consultorio, TipoAgenda, DiaSemana, Fecha_ConfCitas, HoraInicial, HoraFinal, Cupo, Fecha, UsuarioS) VALUES ('" + profesional + "','" + this.especialidad1 + "','" + rs.getInt(7) + "','" + tipoAgenda + "','" + rs.getInt(3) + "','" + fecha + "','" + rs.getString(4) + "','" + rs.getString(5) + "','" + rs.getString(6) + "','" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
            this.consultas.ejecutarSQL(this.sql);
            this.consultas.cerrarConexionBd();
        } catch (SQLException ex) {
            this.consultas.mostrarErrorSQL(ex);
        }
    }

    public void nuevo() {
        this.txtOrigen.setText((String) null);
        this.txtDestino.setText((String) null);
        this.txtFechaO.setText((String) null);
        this.txtFechaD.setText((String) null);
        this.puedeGrabar = 0;
    }

    private int validarDatos() {
        int retorno = 0;
        if (this.txtOrigen.getText().isEmpty()) {
            this.metodos.mostrarMensaje("Por favor seleccione el Profesional de Origen");
        } else if (this.txtDestino.getText().isEmpty()) {
            this.metodos.mostrarMensaje("Por favor seleccione el Profesional que recibirá la Programación");
        } else if (!this.especialidad1.equals(this.especialidad2) && this.tipoCambio == 2) {
            this.metodos.mostrarMensaje("No se puede realizar cambio de Programación\nEntre Especialidades Diferentes");
        } else if (this.txtFechaO.getText().isEmpty()) {
            this.metodos.mostrarMensaje("Por Favor seleccione la Fecha que la cual se realizara\nCambios de Programación");
        } else {
            retorno = this.metodos.getPregunta("Se hará un cambio de Programación en los siguiente Profesionales\nProfesional que se cambiará : " + this.txtOrigen.getText() + ".\nProfesional que Recibirá    : " + this.txtDestino.getText() + ".\nFecha de Origen             : " + this.txtFechaO.getText() + ".\nFecha de estino             : " + this.txtFechaD.getText() + ".\n\nEsta seguro de realizar esta cambio ? ");
        }
        return retorno;
    }

    private void initComponents() {
        this.buttonGroup1 = new ButtonGroup();
        this.jPanel3 = new JPanel();
        this.btnMismoProfesional = new JRadioButton();
        this.btnEntreProfesional = new JRadioButton();
        this.jRadioButton1 = new JRadioButton();
        this.jPanel4 = new JPanel();
        this.jLabel3 = new JLabel();
        this.txtOrigen = new JTextField();
        this.jLabel5 = new JLabel();
        this.txtFechaO = new JTextField();
        this.jScrollPane1 = new JScrollPane();
        this.Arbol1 = new JTree();
        this.CalendarioO = new JCalendar();
        this.jPanel5 = new JPanel();
        this.jLabel4 = new JLabel();
        this.txtDestino = new JTextField();
        this.jLabel6 = new JLabel();
        this.txtFechaD = new JTextField();
        this.jScrollPane2 = new JScrollPane();
        this.Arbol2 = new JTree();
        this.CalendarioD = new JCalendar();
        setClosable(true);
        setIconifiable(true);
        setTitle("CAMBIAR TURNOS DE PROGRAMACION");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("PasarTurnos");
        this.jPanel3.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo de Cambio de Turno", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.buttonGroup1.add(this.btnMismoProfesional);
        this.btnMismoProfesional.setFont(new Font("Arial", 1, 12));
        this.btnMismoProfesional.setForeground(new Color(0, 0, 255));
        this.btnMismoProfesional.setSelected(true);
        this.btnMismoProfesional.setText("Pasar entre fechas al mismo Profesional");
        this.btnMismoProfesional.addActionListener(new ActionListener() { // from class: Citas.PasarTurnos.1
            public void actionPerformed(ActionEvent evt) {
                PasarTurnos.this.btnMismoProfesionalActionPerformed(evt);
            }
        });
        this.buttonGroup1.add(this.btnEntreProfesional);
        this.btnEntreProfesional.setFont(new Font("Arial", 1, 12));
        this.btnEntreProfesional.setForeground(new Color(0, 0, 255));
        this.btnEntreProfesional.setText("Pasar entre Profesionales");
        this.btnEntreProfesional.addActionListener(new ActionListener() { // from class: Citas.PasarTurnos.2
            public void actionPerformed(ActionEvent evt) {
                PasarTurnos.this.btnEntreProfesionalActionPerformed(evt);
            }
        });
        this.buttonGroup1.add(this.jRadioButton1);
        this.jRadioButton1.setFont(new Font("Arial", 1, 12));
        this.jRadioButton1.setForeground(new Color(0, 0, 255));
        this.jRadioButton1.setText("Copiar Usuarios entre fechas al mismo Profesional");
        this.jRadioButton1.addActionListener(new ActionListener() { // from class: Citas.PasarTurnos.3
            public void actionPerformed(ActionEvent evt) {
                PasarTurnos.this.jRadioButton1ActionPerformed(evt);
            }
        });
        GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
        this.jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addComponent(this.btnMismoProfesional).addGap(23, 23, 23).addComponent(this.btnEntreProfesional).addGap(18, 18, 18).addComponent(this.jRadioButton1).addContainerGap(-1, 32767)));
        jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.btnMismoProfesional).addComponent(this.btnEntreProfesional).addComponent(this.jRadioButton1)).addContainerGap(-1, 32767)));
        this.jPanel4.setBorder(BorderFactory.createTitledBorder("Origen"));
        this.jLabel3.setFont(new Font("Arial", 1, 12));
        this.jLabel3.setForeground(Color.blue);
        this.jLabel3.setHorizontalAlignment(2);
        this.jLabel3.setText("Profesional");
        this.txtOrigen.setFont(new Font("Arial", 1, 12));
        this.txtOrigen.setDisabledTextColor(new Color(0, 0, 153));
        this.txtOrigen.setEnabled(false);
        this.jLabel5.setFont(new Font("Arial", 1, 12));
        this.jLabel5.setForeground(Color.blue);
        this.jLabel5.setHorizontalAlignment(2);
        this.jLabel5.setText("Fecha");
        this.txtFechaO.setFont(new Font("Arial", 1, 12));
        this.txtFechaO.setHorizontalAlignment(0);
        this.txtFechaO.setDisabledTextColor(new Color(0, 0, 153));
        this.txtFechaO.setEnabled(false);
        this.Arbol1.setFont(new Font("Arial", 1, 12));
        this.Arbol1.addTreeSelectionListener(new TreeSelectionListener() { // from class: Citas.PasarTurnos.4
            public void valueChanged(TreeSelectionEvent evt) {
                PasarTurnos.this.Arbol1ValueChanged(evt);
            }
        });
        this.jScrollPane1.setViewportView(this.Arbol1);
        this.CalendarioO.setBorder(BorderFactory.createEtchedBorder());
        this.CalendarioO.setFont(new Font("Arial", 1, 12));
        this.CalendarioO.setName("Calendario");
        this.CalendarioO.setWeekOfYearVisible(false);
        this.CalendarioO.addPropertyChangeListener(new PropertyChangeListener() { // from class: Citas.PasarTurnos.5
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                PasarTurnos.this.CalendarioOPropertyChange(evt);
            }
        });
        GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
        this.jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addContainerGap().addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel3, -2, 130, -2).addComponent(this.txtOrigen, -1, 308, 32767)).addGap(6, 6, 6).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.txtFechaO, -2, 130, -2).addComponent(this.jLabel5, -2, 71, -2))).addComponent(this.CalendarioO, -1, 444, 32767).addComponent(this.jScrollPane1, GroupLayout.Alignment.TRAILING, -1, 444, 32767)).addContainerGap()));
        jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup().addComponent(this.jScrollPane1, -1, 256, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.CalendarioO, -2, 253, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel3).addComponent(this.jLabel5)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.txtOrigen, -2, 28, -2).addComponent(this.txtFechaO, -2, 28, -2)).addContainerGap()));
        this.jPanel5.setBorder(BorderFactory.createTitledBorder("Destino"));
        this.jLabel4.setFont(new Font("Arial", 1, 12));
        this.jLabel4.setForeground(Color.blue);
        this.jLabel4.setHorizontalAlignment(2);
        this.jLabel4.setText("Profesional");
        this.txtDestino.setFont(new Font("Arial", 1, 12));
        this.txtDestino.setDisabledTextColor(new Color(0, 0, 153));
        this.txtDestino.setEnabled(false);
        this.jLabel6.setFont(new Font("Arial", 1, 12));
        this.jLabel6.setForeground(Color.blue);
        this.jLabel6.setHorizontalAlignment(2);
        this.jLabel6.setText("Fecha");
        this.txtFechaD.setFont(new Font("Arial", 1, 12));
        this.txtFechaD.setForeground(new Color(0, 0, 153));
        this.txtFechaD.setHorizontalAlignment(0);
        this.txtFechaD.setDisabledTextColor(new Color(0, 0, 204));
        this.txtFechaD.setEnabled(false);
        this.Arbol2.setFont(new Font("Arial", 1, 12));
        this.Arbol2.addTreeSelectionListener(new TreeSelectionListener() { // from class: Citas.PasarTurnos.6
            public void valueChanged(TreeSelectionEvent evt) {
                PasarTurnos.this.Arbol2ValueChanged(evt);
            }
        });
        this.jScrollPane2.setViewportView(this.Arbol2);
        this.CalendarioD.setBorder(BorderFactory.createEtchedBorder());
        this.CalendarioD.setFont(new Font("Arial", 1, 12));
        this.CalendarioD.setWeekOfYearVisible(false);
        this.CalendarioD.addPropertyChangeListener(new PropertyChangeListener() { // from class: Citas.PasarTurnos.7
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                PasarTurnos.this.CalendarioDPropertyChange(evt);
            }
        });
        GroupLayout jPanel5Layout = new GroupLayout(this.jPanel5);
        this.jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addContainerGap().addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel4, -2, 104, -2).addComponent(this.txtDestino, -2, 265, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 24, 32767).addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.txtFechaD, -2, 129, -2).addComponent(this.jLabel6, -2, 64, -2))).addComponent(this.CalendarioD, -1, 418, 32767).addComponent(this.jScrollPane2, GroupLayout.Alignment.TRAILING, -1, 418, 32767)).addContainerGap()));
        jPanel5Layout.setVerticalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addComponent(this.jScrollPane2, -2, 269, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.CalendarioD, -1, -1, 32767).addGap(20, 20, 20).addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(jPanel5Layout.createSequentialGroup().addComponent(this.jLabel4).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.txtDestino, -2, 28, -2)).addGroup(jPanel5Layout.createSequentialGroup().addComponent(this.jLabel6).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.txtFechaD, -2, 28, -2))).addContainerGap()));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel3, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addGroup(layout.createSequentialGroup().addComponent(this.jPanel4, -2, -1, -2).addGap(18, 18, 18).addComponent(this.jPanel5, -2, -1, -2))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel3, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jPanel5, -1, -1, 32767).addComponent(this.jPanel4, -2, -1, -2)).addContainerGap(13, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnMismoProfesionalActionPerformed(ActionEvent evt) {
        this.tipoCambio = 1;
        activarObjetos();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnEntreProfesionalActionPerformed(ActionEvent evt) {
        this.tipoCambio = 2;
        activarObjetos();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Arbol1ValueChanged(TreeSelectionEvent evt) {
        this.nodo1 = (DefaultMutableTreeNode) this.Arbol1.getLastSelectedPathComponent();
        if (this.nodo1 != null) {
            this.nbreProfesional1 = (String) this.nodo1.getUserObject();
            String especialidad = this.nodo1.getParent().toString();
            for (int i = 1; i < this.listaProfesional.length; i++) {
                if (this.listaProfesional[i][1].equals(this.nbreProfesional1) && this.listaProfesional[i][3].equals(especialidad)) {
                    this.idProfesional1 = this.listaProfesional[i][0];
                    this.especialidad1 = this.listaProfesional[i][2];
                    this.txtOrigen.setText(this.nbreProfesional1);
                    if (this.btnMismoProfesional.isSelected()) {
                        this.txtDestino.setText(this.nbreProfesional1);
                        this.idProfesional2 = this.listaProfesional[i][0];
                        return;
                    }
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CalendarioOPropertyChange(PropertyChangeEvent evt) {
        this.txtFechaO.setText(this.metodos.formatoAMD.format(this.CalendarioO.getDate()).toString());
        if (this.btnEntreProfesional.isSelected()) {
            this.txtFechaD.setText(this.metodos.formatoAMD.format(this.CalendarioO.getDate()).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Arbol2ValueChanged(TreeSelectionEvent evt) {
        this.nodo2 = (DefaultMutableTreeNode) this.Arbol2.getLastSelectedPathComponent();
        if (this.nodo1 != null) {
            this.nbreProfesional2 = (String) this.nodo2.getUserObject();
            String especialidad = this.nodo1.getParent().toString();
            for (int i = 1; i < this.listaProfesional.length; i++) {
                if (this.listaProfesional[i][1].equals(this.nbreProfesional2) && this.listaProfesional[i][3].equals(especialidad)) {
                    this.idProfesional2 = this.listaProfesional[i][0];
                    this.especialidad2 = this.listaProfesional[i][2];
                    this.txtDestino.setText(this.nbreProfesional2);
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CalendarioDPropertyChange(PropertyChangeEvent evt) {
        this.txtFechaD.setText(this.metodos.formatoAMD.format(this.CalendarioD.getDate()).toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jRadioButton1ActionPerformed(ActionEvent evt) {
        this.tipoCambio = 3;
        activarObjetos();
    }
}
