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
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/* JADX INFO: loaded from: GenomaP.jar:Historia/JIFConsultarInforOtros.class */
public class JIFConsultarInforOtros extends JInternalFrame {
    private Object[] dato;
    private ResultSet xrsperm;
    private String xnombrejif;
    private clasesHistoriaCE xclase;
    private JButton JBTCerrar;
    private JLabel JLBTituloConsulta;
    private JScrollPane JSPDetalleConsulta;
    private JTable JTBDetalle;
    private DefaultTableModel modeloincapacidad = new DefaultTableModel();
    private TableColumn column = null;
    private ConsultasMySQL xconsultasbd = new ConsultasMySQL();
    private Metodos xmetodo = new Metodos();

    public JIFConsultarInforOtros(clasesHistoriaCE xclase, String xnombrejif) {
        initComponents();
        this.xclase = xclase;
        this.xnombrejif = xnombrejif;
        setLocation((this.xmetodo.getAnchoPantalla() / 2) / 2, (this.xmetodo.getAltoPantalla() / 2) / 2);
        if (xnombrejif.equals("jpincapacidades") || xnombrejif.equals("jifincapacidad")) {
            this.JLBTituloConsulta.setText("RESULTADO CONSULTA INCAPACIDADES");
            mBuscarIncapacidades();
        } else if (xnombrejif.equals("jppermisos")) {
            this.JLBTituloConsulta.setText("RESULTADO CONSULTA PERMISOS");
            mBuscarPermisos();
        } else if (xnombrejif.equals("jpaeventonodeseado")) {
            this.JLBTituloConsulta.setText("RESULTADO CONSULTA EVENTO NO DESEADO");
            mBuscarEvento();
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatosIncapacidad() {
        this.modeloincapacidad = new DefaultTableModel(new Object[0], new String[]{"N° Incapacidad", "Fecha Inicio", "N° dias", "Fecha Fin", "Dx", "ESTADO"}) { // from class: Historia.JIFConsultarInforOtros.1
            Class[] types = {Long.class, String.class, Integer.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTBDetalle.setModel(this.modeloincapacidad);
        this.JTBDetalle.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTBDetalle.getColumnModel().getColumn(1).setPreferredWidth(50);
        this.JTBDetalle.getColumnModel().getColumn(2).setPreferredWidth(20);
        this.JTBDetalle.getColumnModel().getColumn(3).setPreferredWidth(50);
        this.JTBDetalle.getColumnModel().getColumn(4).setPreferredWidth(30);
        this.JTBDetalle.getColumnModel().getColumn(5).setPreferredWidth(50);
    }

    private void mBuscarIncapacidades() {
        mCrearModeloDatosIncapacidad();
        try {
            String sql = "SELECT Id, FechaInicio, NDias, FechaFin, Id_Patologia, Estado, Id_Usuario FROM h_incapacidad where Id_Usuario='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "' ORDER BY FechaFin DESC ";
            this.xrsperm = this.xconsultasbd.traerRs(sql);
            if (this.xrsperm.next()) {
                this.xrsperm.beforeFirst();
                int i = 0;
                while (this.xrsperm.next()) {
                    this.modeloincapacidad.addRow(this.dato);
                    this.modeloincapacidad.setValueAt(Long.valueOf(this.xrsperm.getLong(1)), i, 0);
                    this.modeloincapacidad.setValueAt(this.xmetodo.formatoDMA.format((Date) this.xrsperm.getDate(2)), i, 1);
                    this.modeloincapacidad.setValueAt(Integer.valueOf(this.xrsperm.getInt(3)), i, 2);
                    this.modeloincapacidad.setValueAt(this.xmetodo.formatoDMA.format((Date) this.xrsperm.getDate(4)), i, 3);
                    this.modeloincapacidad.setValueAt(this.xrsperm.getString(5), i, 4);
                    if (this.xrsperm.getInt(6) == 1) {
                        this.modeloincapacidad.setValueAt("ANULADA", i, 5);
                    } else {
                        this.modeloincapacidad.setValueAt("ACTIVA", i, 5);
                    }
                    i++;
                }
            }
            this.xrsperm.close();
            this.xconsultasbd.cerrarConexionBd();
        } catch (SQLException e) {
        }
    }

    private void mBuscarEvento() {
        this.modeloincapacidad.addColumn("N° Evento");
        this.modeloincapacidad.addColumn("Fecha");
        this.modeloincapacidad.addColumn("Tipo Evento");
        this.modeloincapacidad.addColumn("Clase Evento");
        this.modeloincapacidad.addColumn("Profesionales");
        this.modeloincapacidad.addColumn("Estado");
        this.modeloincapacidad.addRow(this.dato);
        this.JTBDetalle.setModel(this.modeloincapacidad);
        this.column = this.JTBDetalle.getColumnModel().getColumn(0);
        this.column.setPreferredWidth(10);
        this.column = this.JTBDetalle.getColumnModel().getColumn(1);
        this.column.setPreferredWidth(50);
        this.column = this.JTBDetalle.getColumnModel().getColumn(2);
        this.column.setPreferredWidth(100);
        this.column = this.JTBDetalle.getColumnModel().getColumn(3);
        this.column.setPreferredWidth(100);
        this.column = this.JTBDetalle.getColumnModel().getColumn(4);
        this.column.setPreferredWidth(200);
        this.column = this.JTBDetalle.getColumnModel().getColumn(5);
        this.column.setPreferredWidth(50);
        try {
            String sql = "SELECT e_eventonodeseado.Id, e_eventonodeseado.Fecha_Evento, e_tipoevento.Nbre, e_claseevento.Nbre, CONCAT(g_persona.Apellido1,' ',g_persona.Apellido2,' ',g_persona.Nombre1,' ',g_persona.Nombre2) AS NOMBREPROFSIONAL, e_eventonodeseado.Estado FROM baseserver.e_eventonodeseado INNER JOIN baseserver.g_profesional ON (e_eventonodeseado.Id_Profesional = g_profesional.Id_Persona) INNER JOIN baseserver.e_claseevento  ON (e_eventonodeseado.Id_ClaseEvento = e_claseevento.Id) INNER JOIN baseserver.e_tipoevento ON (e_eventonodeseado.Id_TipoEvento = e_tipoevento.Id) INNER JOIN baseserver.g_persona ON (g_profesional.Id_Persona = g_persona.Id) WHERE (e_eventonodeseado.Id_Usuario ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "') ORDER BY e_eventonodeseado.Fecha_Evento DESC";
            this.xrsperm = this.xconsultasbd.traerRs(sql);
            this.xrsperm.next();
            if (this.xrsperm.getRow() != 0) {
                this.xrsperm.beforeFirst();
                int i = 0;
                while (this.xrsperm.next()) {
                    this.modeloincapacidad.addRow(this.dato);
                    this.modeloincapacidad.setValueAt(Long.valueOf(this.xrsperm.getLong(1)), i, 0);
                    this.modeloincapacidad.setValueAt(this.xmetodo.formatoDMA.format((Date) this.xrsperm.getDate(2)), i, 1);
                    this.modeloincapacidad.setValueAt(this.xrsperm.getString(3), i, 2);
                    this.modeloincapacidad.setValueAt(this.xrsperm.getString(4), i, 3);
                    this.modeloincapacidad.setValueAt(this.xrsperm.getString(5), i, 4);
                    if (this.xrsperm.getInt(6) == 1) {
                        this.modeloincapacidad.setValueAt("ANULADO", i, 5);
                    } else {
                        this.modeloincapacidad.setValueAt("ACTIVO", i, 5);
                    }
                    i++;
                }
            }
            this.xrsperm.close();
            this.xconsultasbd.cerrarConexionBd();
        } catch (SQLException e) {
        }
    }

    private void mBuscarPermisos() {
        this.modeloincapacidad.addColumn("Id");
        this.modeloincapacidad.addColumn("Fecha Expedicion");
        this.modeloincapacidad.addColumn("Fecha Cita");
        this.modeloincapacidad.addColumn("Ciudad");
        this.modeloincapacidad.addColumn("Profesional");
        this.modeloincapacidad.addColumn("Estado");
        this.modeloincapacidad.addRow(this.dato);
        this.JTBDetalle.setModel(this.modeloincapacidad);
        this.column = this.JTBDetalle.getColumnModel().getColumn(0);
        this.column.setPreferredWidth(10);
        this.column = this.JTBDetalle.getColumnModel().getColumn(1);
        this.column.setPreferredWidth(50);
        this.column = this.JTBDetalle.getColumnModel().getColumn(2);
        this.column.setPreferredWidth(50);
        this.column = this.JTBDetalle.getColumnModel().getColumn(3);
        this.column.setPreferredWidth(50);
        this.column = this.JTBDetalle.getColumnModel().getColumn(4);
        this.column.setPreferredWidth(200);
        this.column = this.JTBDetalle.getColumnModel().getColumn(5);
        this.column.setPreferredWidth(50);
        try {
            String xsqlbusc = "SELECT h_permisosmedicos.Id, h_permisosmedicos.Fecha, h_permisosmedicos.FechaCita, g_municipio.Nbre, profesional.NProfesional, h_permisosmedicos.Estado FROM baseserver.h_permisosmedicos INNER JOIN baseserver.g_municipio  ON (h_permisosmedicos.Id_Municipio = g_municipio.Id) INNER JOIN baseserver.g_profesional  ON (h_permisosmedicos.Id_Profesional = g_profesional.Id_Persona) INNER JOIN baseserver.profesional  ON (profesional.Id_Persona = g_profesional.Id_Persona) WHERE (h_permisosmedicos.Id_Usuario ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "') ORDER BY h_permisosmedicos.Fecha DESC ";
            this.xrsperm = this.xconsultasbd.traerRs(xsqlbusc);
            this.xrsperm.next();
            if (this.xrsperm.getRow() != 0) {
                this.xrsperm.beforeFirst();
                int i = 0;
                while (this.xrsperm.next()) {
                    this.modeloincapacidad.setValueAt(Long.valueOf(this.xrsperm.getLong(1)), i, 0);
                    this.modeloincapacidad.setValueAt(this.xmetodo.formatoDMA.format((Date) this.xrsperm.getDate(2)), i, 1);
                    this.modeloincapacidad.setValueAt(this.xmetodo.formatoDMA.format((Date) this.xrsperm.getDate(3)), i, 2);
                    this.modeloincapacidad.setValueAt(this.xrsperm.getString(4), i, 3);
                    this.modeloincapacidad.setValueAt(this.xrsperm.getString(5), i, 4);
                    if (this.xrsperm.getInt(6) == 1) {
                        this.modeloincapacidad.setValueAt("ANULADO", i, 5);
                    } else {
                        this.modeloincapacidad.setValueAt("ACTIV0", i, 5);
                    }
                    this.modeloincapacidad.addRow(this.dato);
                    i++;
                }
            }
            this.xrsperm.close();
            this.xconsultasbd.cerrarConexionBd();
        } catch (SQLException e) {
        }
    }

    private void initComponents() {
        this.JSPDetalleConsulta = new JScrollPane();
        this.JTBDetalle = new JTable();
        this.JLBTituloConsulta = new JLabel();
        this.JBTCerrar = new JButton();
        setClosable(true);
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        this.JSPDetalleConsulta.setBorder(BorderFactory.createEtchedBorder());
        this.JSPDetalleConsulta.setFont(new Font("Tahoma", 1, 12));
        this.JTBDetalle.setFont(new Font("Arial", 1, 12));
        this.JTBDetalle.setRowHeight(25);
        this.JTBDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTBDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTBDetalle.setSelectionMode(0);
        this.JTBDetalle.addMouseListener(new MouseAdapter() { // from class: Historia.JIFConsultarInforOtros.2
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarInforOtros.this.JTBDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalleConsulta.setViewportView(this.JTBDetalle);
        this.JLBTituloConsulta.setBackground(new Color(0, 0, 153));
        this.JLBTituloConsulta.setFont(new Font("Arial", 1, 18));
        this.JLBTituloConsulta.setForeground(new Color(204, 255, 255));
        this.JLBTituloConsulta.setHorizontalAlignment(0);
        this.JLBTituloConsulta.setBorder(BorderFactory.createEtchedBorder());
        this.JLBTituloConsulta.setOpaque(true);
        this.JBTCerrar.setFont(new Font("Arial", 1, 12));
        this.JBTCerrar.setForeground(new Color(0, 0, 153));
        this.JBTCerrar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.JBTCerrar.setText("Cerrar");
        this.JBTCerrar.addActionListener(new ActionListener() { // from class: Historia.JIFConsultarInforOtros.3
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarInforOtros.this.JBTCerrarActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JSPDetalleConsulta, GroupLayout.Alignment.LEADING, -1, 824, 32767).addComponent(this.JLBTituloConsulta, GroupLayout.Alignment.LEADING, -1, 824, 32767))).addGroup(layout.createSequentialGroup().addGap(360, 360, 360).addComponent(this.JBTCerrar))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JLBTituloConsulta, -2, 35, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPDetalleConsulta, -2, 162, -2).addGap(18, 18, 18).addComponent(this.JBTCerrar).addContainerGap(35, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBDetalleMouseClicked(MouseEvent evt) {
        if (this.xnombrejif.equals("jpincapacidades")) {
            try {
                if (this.xclase.historia_Clinica_v2 != null) {
                    this.xclase.historia_Clinica_v2.funcionalidadPanelHistoriaClinica.xjpincapacidad.mBuscarIncapacidad(this.modeloincapacidad.getValueAt(this.JTBDetalle.getSelectedRow(), 0).toString());
                    this.xclase.historia_Clinica_v2.setSelected(true);
                    dispose();
                } else if (this.xclase.historia_Clinica_v4 != null) {
                    this.xclase.historia_Clinica_v4.funcionalidadPanelHistoriaClinica.xjpincapacidad.mBuscarIncapacidad(this.modeloincapacidad.getValueAt(this.JTBDetalle.getSelectedRow(), 0).toString());
                    this.xclase.historia_Clinica_v4.setSelected(true);
                    dispose();
                } else {
                    this.xclase.xjifhistoriaclinica.xjpincapacidad.mBuscarIncapacidad(this.modeloincapacidad.getValueAt(this.JTBDetalle.getSelectedRow(), 0).toString());
                    this.xclase.xjifhistoriaclinica.setSelected(true);
                    dispose();
                }
                return;
            } catch (PropertyVetoException e) {
                Logger.getLogger(JIFConsultarInforOtros.class.getName()).log(Level.SEVERE, (String) null, e);
                return;
            }
        }
        if (this.xnombrejif.equals("jpaeventonodeseado")) {
            try {
                this.xclase.xjifhistoriaclinica.xjpeventonodeseado.mBuscarEvento(this.modeloincapacidad.getValueAt(this.JTBDetalle.getSelectedRow(), 0).toString());
                this.xclase.xjifhistoriaclinica.setSelected(true);
                dispose();
                return;
            } catch (PropertyVetoException e2) {
                Logger.getLogger(JIFConsultarInforOtros.class.getName()).log(Level.SEVERE, (String) null, e2);
                return;
            }
        }
        if (this.xnombrejif.equals("jppermisos")) {
            try {
                if (this.xclase.xjifhistoriaclinica != null) {
                    this.xclase.xjifhistoriaclinica.xjppermisos.mBuscarPermiso(this.modeloincapacidad.getValueAt(this.JTBDetalle.getSelectedRow(), 0).toString());
                    this.xclase.xjifhistoriaclinica.setSelected(true);
                } else if (this.xclase.xjifpermiso != null) {
                    this.xclase.xjifpermiso.xjppermiso.mBuscarPermiso(this.modeloincapacidad.getValueAt(this.JTBDetalle.getSelectedRow(), 0).toString());
                    this.xclase.xjifpermiso.setSelected(true);
                }
                dispose();
                return;
            } catch (PropertyVetoException e3) {
                Logger.getLogger(JIFConsultarInforOtros.class.getName()).log(Level.SEVERE, (String) null, e3);
                return;
            }
        }
        if (this.xnombrejif.equals("jifincapacidad")) {
            try {
                this.xclase.xjifincapacidad.xjpincapacidad.mBuscarIncapacidad(this.modeloincapacidad.getValueAt(this.JTBDetalle.getSelectedRow(), 0).toString());
                this.xclase.xjifincapacidad.setSelected(true);
                dispose();
            } catch (PropertyVetoException e4) {
                Logger.getLogger(JIFConsultarInforOtros.class.getName()).log(Level.SEVERE, (String) null, e4);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTCerrarActionPerformed(ActionEvent evt) {
        try {
            if (this.xnombrejif.equals("jpincapacidades") || this.xnombrejif.equals("jpaeventonodeseado") || this.xnombrejif.equals("jppermisos")) {
                if (this.xclase.xjifhistoriaclinica != null) {
                    this.xclase.xjifhistoriaclinica.setSelected(true);
                } else if (this.xclase.xjifpermiso != null) {
                    this.xclase.xjifpermiso.setSelected(true);
                }
                dispose();
            } else if (this.xnombrejif.equals("jifincapacidad")) {
                this.xclase.xjifincapacidad.setSelected(true);
                dispose();
            }
        } catch (PropertyVetoException e) {
            Logger.getLogger(JIFConsultarInforOtros.class.getName()).log(Level.SEVERE, (String) null, e);
        }
    }
}
