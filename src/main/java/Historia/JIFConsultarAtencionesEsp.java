package Historia;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/* JADX INFO: loaded from: GenomaP.jar:Historia/JIFConsultarAtencionesEsp.class */
public class JIFConsultarAtencionesEsp extends JInternalFrame {
    private Object[] dato;
    private ResultSet rs;
    private int xTipo;
    private clasesHistoriaCE xclaseHC;
    private String xsql;
    private ButtonGroup JBGOpciones;
    private JButton JBTCerrar;
    private JPanel JPITipoConsulta;
    private JRadioButton JRBAtendidos;
    private JRadioButton JRBPAtender;
    private JScrollPane JSPDetalleConsulta;
    private JTable JTBDetalle;
    private DefaultTableModel xmodelod = new DefaultTableModel();
    private TableColumn column = null;
    private int xestado = 0;
    private ConsultasMySQL xconsultasbd = new ConsultasMySQL();
    private Metodos xmetodo = new Metodos();

    public JIFConsultarAtencionesEsp(clasesHistoriaCE xclase, int xtipo) {
        initComponents();
        this.xclaseHC = xclase;
        this.xTipo = xtipo;
        setLocation((this.xmetodo.getAnchoPantalla() / 2) / 2, (this.xmetodo.getAltoPantalla() / 2) / 2);
        mCargarDatos();
    }

    private void initComponents() {
        this.JBGOpciones = new ButtonGroup();
        this.JSPDetalleConsulta = new JScrollPane();
        this.JTBDetalle = new JTable();
        this.JBTCerrar = new JButton();
        this.JPITipoConsulta = new JPanel();
        this.JRBPAtender = new JRadioButton();
        this.JRBAtendidos = new JRadioButton();
        setClosable(true);
        setTitle("ATENCIONES ESPECIALES");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        this.JSPDetalleConsulta.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTBDetalle.setFont(new Font("Arial", 1, 12));
        this.JTBDetalle.setRowHeight(25);
        this.JTBDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTBDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTBDetalle.setSelectionMode(0);
        this.JTBDetalle.addMouseListener(new MouseAdapter() { // from class: Historia.JIFConsultarAtencionesEsp.1
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarAtencionesEsp.this.JTBDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalleConsulta.setViewportView(this.JTBDetalle);
        this.JBTCerrar.setFont(new Font("Arial", 1, 12));
        this.JBTCerrar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.JBTCerrar.setText("Cerrar");
        this.JBTCerrar.addActionListener(new ActionListener() { // from class: Historia.JIFConsultarAtencionesEsp.2
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarAtencionesEsp.this.JBTCerrarActionPerformed(evt);
            }
        });
        this.JPITipoConsulta.setBorder(BorderFactory.createTitledBorder((Border) null, "ESTADO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JBGOpciones.add(this.JRBPAtender);
        this.JRBPAtender.setFont(new Font("Arial", 1, 12));
        this.JRBPAtender.setForeground(Color.blue);
        this.JRBPAtender.setSelected(true);
        this.JRBPAtender.setText("Por Atender");
        this.JRBPAtender.addActionListener(new ActionListener() { // from class: Historia.JIFConsultarAtencionesEsp.3
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarAtencionesEsp.this.JRBPAtenderActionPerformed(evt);
            }
        });
        this.JBGOpciones.add(this.JRBAtendidos);
        this.JRBAtendidos.setFont(new Font("Arial", 1, 12));
        this.JRBAtendidos.setForeground(Color.blue);
        this.JRBAtendidos.setText("Atendidos");
        this.JRBAtendidos.addActionListener(new ActionListener() { // from class: Historia.JIFConsultarAtencionesEsp.4
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarAtencionesEsp.this.JRBAtendidosActionPerformed(evt);
            }
        });
        GroupLayout JPITipoConsultaLayout = new GroupLayout(this.JPITipoConsulta);
        this.JPITipoConsulta.setLayout(JPITipoConsultaLayout);
        JPITipoConsultaLayout.setHorizontalGroup(JPITipoConsultaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPITipoConsultaLayout.createSequentialGroup().addContainerGap().addComponent(this.JRBPAtender).addGap(18, 18, 18).addComponent(this.JRBAtendidos).addContainerGap(-1, 32767)));
        JPITipoConsultaLayout.setVerticalGroup(JPITipoConsultaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPITipoConsultaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBPAtender).addComponent(this.JRBAtendidos)));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.JBTCerrar, -1, 584, 32767).addGap(18, 18, 18).addComponent(this.JPITipoConsulta, -2, -1, -2)).addComponent(this.JSPDetalleConsulta, -1, 824, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JSPDetalleConsulta, -2, 346, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JPITipoConsulta, -2, -1, -2).addComponent(this.JBTCerrar, -2, 49, -2)).addContainerGap(30, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBDetalleMouseClicked(MouseEvent evt) {
        try {
            if (this.JTBDetalle.getSelectedRow() != -1) {
                clasesHistoriaCE.informacionAgendaMedicaDTO.setNumeroHistoria(this.xmodelod.getValueAt(this.JTBDetalle.getSelectedRow(), 0).toString());
                clasesHistoriaCE.informacionAgendaMedicaDTO.setNombreUsuario(this.xmodelod.getValueAt(this.JTBDetalle.getSelectedRow(), 1).toString());
                clasesHistoriaCE.informacionAgendaMedicaDTO.setEdad(this.xmodelod.getValueAt(this.JTBDetalle.getSelectedRow(), 2).toString());
                clasesHistoriaCE.informacionAgendaMedicaDTO.setNombreSexo(this.xmodelod.getValueAt(this.JTBDetalle.getSelectedRow(), 3).toString());
                clasesHistoriaCE.informacionAgendaMedicaDTO.setIdUsuarioAtendido(Long.valueOf(Long.parseLong(this.xmodelod.getValueAt(this.JTBDetalle.getSelectedRow(), 4).toString())));
                clasesHistoriaCE.informacionAgendaMedicaDTO.setIdIngreso(Long.valueOf(Long.parseLong(this.xmodelod.getValueAt(this.JTBDetalle.getSelectedRow(), 5).toString())));
                clasesHistoriaCE.informacionAgendaMedicaDTO.setIdTipohc(Integer.valueOf(Integer.parseInt(this.xmodelod.getValueAt(this.JTBDetalle.getSelectedRow(), 7).toString())));
                clasesHistoriaCE.informacionAgendaMedicaDTO.setEsAtencionEspecial(Integer.valueOf(Integer.parseInt(this.xmodelod.getValueAt(this.JTBDetalle.getSelectedRow(), 8).toString())));
                if (this.xTipo == 1) {
                    clasesHistoriaCE.informacionAgendaMedicaDTO.setIdClaseCita(Integer.valueOf(Integer.parseInt(this.xmodelod.getValueAt(this.JTBDetalle.getSelectedRow(), 11).toString())));
                    clasesHistoriaCE.informacionAgendaMedicaDTO.setIdTipoAtencion(Integer.valueOf(Integer.parseInt(this.xmodelod.getValueAt(this.JTBDetalle.getSelectedRow(), 12).toString())));
                    clasesHistoriaCE.informacionAgendaMedicaDTO.setIdCargo(Long.valueOf(Long.parseLong(this.xmodelod.getValueAt(this.JTBDetalle.getSelectedRow(), 13).toString())));
                    clasesHistoriaCE.informacionAgendaMedicaDTO.setFormaHistoria(Integer.valueOf(this.xmodelod.getValueAt(this.JTBDetalle.getSelectedRow(), 14).toString()));
                    this.xsql = "UPDATE h_atencion SET  `Id_Profesional`='" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "' , `Id_Especialidad`='" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "' WHERE (`Id_Ingreso` ='" + this.xmodelod.getValueAt(this.JTBDetalle.getSelectedRow(), 5) + "' AND `TipoGuardado` =0); ";
                    this.xconsultasbd.ejecutarSQL(this.xsql);
                    this.xconsultasbd.cerrarConexionBd();
                } else {
                    clasesHistoriaCE.informacionAgendaMedicaDTO.setIdClaseCita(Integer.valueOf(Integer.parseInt(this.xmodelod.getValueAt(this.JTBDetalle.getSelectedRow(), 9).toString())));
                    clasesHistoriaCE.informacionAgendaMedicaDTO.setIdTipoAtencion(Integer.valueOf(Integer.parseInt(this.xmodelod.getValueAt(this.JTBDetalle.getSelectedRow(), 10).toString())));
                    clasesHistoriaCE.informacionAgendaMedicaDTO.setIdCargo(Long.valueOf(Long.parseLong(this.xmodelod.getValueAt(this.JTBDetalle.getSelectedRow(), 11).toString())));
                    clasesHistoriaCE.informacionAgendaMedicaDTO.setFormaHistoria(Integer.valueOf(this.xmodelod.getValueAt(this.JTBDetalle.getSelectedRow(), 12).toString()));
                }
                clasesHistoriaCE.informacionAgendaMedicaDTO.setIdPrograma(0);
                clasesHistoriaCE.informacionAgendaMedicaDTO.setEsOdontologica(0);
                clasesHistoriaCE.informacionAgendaMedicaDTO.setEsPeriodico(0);
                clasesHistoriaCE.informacionAgendaMedicaDTO.setEsRemitada(0);
                this.xclaseHC.mBuscarAtencionIngreso();
                dispose();
                this.xclaseHC.xjifagendan.dispose();
                this.xclaseHC.xjifagendan.claseHilo.xvalor = false;
                this.xclaseHC.xjifagendan.claseHilo = null;
                this.xclaseHC.xjifagendan = null;
                finalize();
                this.xclaseHC.cargarPantalla("Historia", this.xclaseHC.frmPrincipal, "Historia_Med");
            }
        } catch (Throwable ex) {
            Logger.getLogger(JIFConsultarAtencionesEsp.class.getName()).log(Level.SEVERE, (String) null, ex);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTCerrarActionPerformed(ActionEvent evt) {
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBPAtenderActionPerformed(ActionEvent evt) {
        this.xestado = 0;
        mCargarDatos();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBAtendidosActionPerformed(ActionEvent evt) {
        this.xestado = 1;
        mCargarDatos();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTablaDetalle() {
        this.xmodelod = new DefaultTableModel(new Object[0], new String[]{"N° HC", "Usuario", "Edad", "Sexo", "Id_Usuario", "Id_Ingreso", "EstadoA", "Id_Historia", "Id", "IdClaseCita", "Id_TIpoAtencion", "CCargos", "Forma"}) { // from class: Historia.JIFConsultarAtencionesEsp.5
            Class[] types = {String.class, String.class, String.class, String.class, Long.class, Long.class, Boolean.class, Long.class, Long.class, Long.class, String.class, Long.class, Long.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTBDetalle.setModel(this.xmodelod);
        this.JTBDetalle.getColumnModel().getColumn(0).setPreferredWidth(20);
        this.JTBDetalle.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTBDetalle.getColumnModel().getColumn(2).setPreferredWidth(10);
        this.JTBDetalle.getColumnModel().getColumn(3).setPreferredWidth(10);
        this.JTBDetalle.getColumnModel().getColumn(4).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(4).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(4).setMaxWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(5).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(5).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(5).setMaxWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(6).setPreferredWidth(10);
        this.JTBDetalle.getColumnModel().getColumn(7).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(7).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(7).setMaxWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(8).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(8).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(8).setMaxWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(9).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(9).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(9).setMaxWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(10).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(10).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(10).setMaxWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(11).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(11).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(11).setMaxWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(12).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(12).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(12).setMaxWidth(0);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTablaDetalle_1() {
        this.xmodelod = new DefaultTableModel(new Object[0], new String[]{"N° HC", "Usuario", "Edad", "Sexo", "Id_Usuario", "Id_Ingreso", "EstadoA", "Id_Historia", "Id", "Hora", "Observación", "IdClaseCita", "Id_TIpoAtencion", "CCargos", "Forma"}) { // from class: Historia.JIFConsultarAtencionesEsp.6
            Class[] types = {String.class, String.class, String.class, String.class, Long.class, Long.class, Boolean.class, Long.class, Long.class, String.class, String.class, Long.class, String.class, Long.class, Long.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTBDetalle.setModel(this.xmodelod);
        this.JTBDetalle.getColumnModel().getColumn(0).setPreferredWidth(20);
        this.JTBDetalle.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTBDetalle.getColumnModel().getColumn(2).setPreferredWidth(10);
        this.JTBDetalle.getColumnModel().getColumn(3).setPreferredWidth(10);
        this.JTBDetalle.getColumnModel().getColumn(4).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(4).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(4).setMaxWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(5).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(5).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(5).setMaxWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(6).setPreferredWidth(10);
        this.JTBDetalle.getColumnModel().getColumn(7).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(7).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(7).setMaxWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(8).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(8).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(8).setMaxWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(9).setPreferredWidth(10);
        this.JTBDetalle.getColumnModel().getColumn(10).setPreferredWidth(80);
        this.JTBDetalle.getColumnModel().getColumn(11).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(11).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(11).setMaxWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(12).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(12).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(12).setMaxWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(13).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(13).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(13).setMaxWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(14).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(14).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(14).setMaxWidth(0);
    }

    private void mCargarDatos() {
        if (this.xTipo == 0) {
            mCrearTablaDetalle();
            if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL LOCAL DE MONTELIBANO")) {
                this.xsql = "SELECT  gu.NoHistoria, concat(gp.Apellido1, ' ', gp.Apellido2,' ', gp.Nombre1,' ', gp.Nombre2) NUsuario, \nCONCAT(Devuelve_Edad_2F(h_atencion.Fecha_Atencion, gp.FechaNac),' ',Devuelve_Tipo_Edad_2F(h_atencion.Fecha_Atencion, gp.FechaNac)),\ngs.Nbre  as NSexo,\ningreso.Id_Usuario, h_atencion.Id_Ingreso, h_atencionespeciales.EstadoA, c_clasecita.Id_Historia, h_atencionespeciales.Id, \nc_clasecita.Id, ingreso.Id_TipoAtencion, h_atencionespeciales.RCargos, `h_tipohistoria`.`Forma`  \nFROM h_atencionespeciales \nINNER JOIN h_atencion  ON (h_atencionespeciales.Id_Atencion = h_atencion.Id) \nINNER JOIN ingreso ON (h_atencion.Id_Ingreso = ingreso.Id) \nINNER JOIN g_persona gp  ON (ingreso.Id_Usuario = gp.Id)\ninner join g_usuario gu on (gu.Id_persona=gp.Id)\ninner join g_sexo gs on (gs.Id=gp.Id_Sexo)\nINNER JOIN c_clasecita ON (h_atencion.Id_ClaseCita= c_clasecita.Id) \nINNER JOIN `h_tipohistoria` ON (`c_clasecita`.`Id_Historia` = `h_tipohistoria`.`Id`) WHERE ( h_atencionespeciales.EstadoA ='" + this.xestado + "' and DATE_FORMAT(h_atencionespeciales.Fecha_Atencion,'%d/%m/%Y') = '" + this.xmetodo.formatoDMA.format(this.xmetodo.getFechaActual()) + "' ) ORDER BY h_atencionespeciales.Fecha_Atencion ASC ";
            } else {
                this.xsql = "SELECT  gu.NoHistoria, concat(gp.Apellido1, ' ', gp.Apellido2,' ', gp.Nombre1,' ', gp.Nombre2) NUsuario, \nCONCAT(Devuelve_Edad_2F(h_atencion.Fecha_Atencion, gp.FechaNac),' ',Devuelve_Tipo_Edad_2F(h_atencion.Fecha_Atencion, gp.FechaNac)),\ngs.Nbre  as NSexo,\ningreso.Id_Usuario, h_atencion.Id_Ingreso, h_atencionespeciales.EstadoA, c_clasecita.Id_Historia, h_atencionespeciales.Id, \nc_clasecita.Id, ingreso.Id_TipoAtencion, h_atencionespeciales.RCargos, `h_tipohistoria`.`Forma`  \nFROM h_atencionespeciales \nINNER JOIN h_atencion  ON (h_atencionespeciales.Id_Atencion = h_atencion.Id) \nINNER JOIN ingreso ON (h_atencion.Id_Ingreso = ingreso.Id) \nINNER JOIN g_persona gp  ON (ingreso.Id_Usuario = gp.Id)\ninner join g_usuario gu on (gu.Id_persona=gp.Id)\ninner join g_sexo gs on (gs.Id=gp.Id_Sexo)\nINNER JOIN c_clasecita ON (h_atencion.Id_ClaseCita= c_clasecita.Id) \nINNER JOIN `h_tipohistoria` ON (`c_clasecita`.`Id_Historia` = `h_tipohistoria`.`Id`)  WHERE (h_atencionespeciales.Id_Profesional ='" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "' AND h_atencionespeciales.EstadoA ='" + this.xestado + "' and DATE_FORMAT(h_atencionespeciales.Fecha_Atencion,'%d/%m/%Y')='" + this.xmetodo.formatoDMA.format(this.xmetodo.getFechaActual()) + "' ) ORDER BY h_atencionespeciales.Fecha_Atencion ASC ";
            }
        } else {
            mCrearTablaDetalle_1();
            if (Principal.informacionGeneralPrincipalDTO.getIdEspecialidad().equals("382") || Principal.informacionGeneralPrincipalDTO.getIdEspecialidad().equals("52")) {
                this.xsql = "SELECT  g_usuario.NoHistoria,  CONCAT(g_persona.`Apellido1`,' ',g_persona.`Apellido2`,' ',g_persona.`Nombre1`,' ',g_persona.`Nombre2`) AS NPersona, CONCAT(`g_persona`.`Edad`,' ' ,g_tipoedad.`Nbre`,'(s)') AS Edad, g_persona.`Id_Sexo`,  `ingreso`.`Id_Usuario`, `ingreso`.`Id`, `c_citasnp`.`Asistida` , `c_clasecita`.`Id_Historia`, `c_citasnp`.`Id`, `ingreso`.`HoraIngreso`, IF(`c_citasnp`.`Observacion` IS NULL, '', `c_citasnp`.`Observacion`) AS Observacion, c_clasecita.Id, ingreso.Id_TipoAtencion, 0 as RCargos, `h_tipohistoria`.`Forma` FROM  `ingreso`  INNER JOIN `c_citasnp`  ON (`ingreso`.`Id` = `c_citasnp`.`Id_ingreso`)  INNER JOIN g_persona  ON (`g_persona`.`Id` = c_citasnp.Id_Usuario) INNER JOIN g_usuario  ON (g_usuario.Id_persona = g_persona.`Id`)    INNER JOIN `g_tipoedad`  ON (`g_persona`.`Id_TipoEdad` = `g_tipoedad`.`Id`)    INNER JOIN `c_clasecita`  ON (`c_citasnp`.`Id_ClaseCita` = `c_clasecita`.`Id`) INNER JOIN `h_tipohistoria` ON (`c_clasecita`.`Id_Historia` = `h_tipohistoria`.`Id`) WHERE (`c_clasecita`.`EsQx` =1 AND `c_citasnp`.`Id_MotivoDesistida` =0 AND `c_citasnp`.`Id_Anulada` =0 AND `ingreso`.`FechaIngreso` ='" + this.xmetodo.formatoAMD1.format(this.xclaseHC.xjifagendan.JDCFechaAgenda.getDate()) + "') ORDER BY `ingreso`.`HoraIngreso` ASC ";
            } else {
                this.xsql = "SELECT  g_usuario.NoHistoria,  CONCAT(g_persona.`Apellido1`,' ',g_persona.`Apellido2`,' ',g_persona.`Nombre1`,' ',g_persona.`Nombre2`) AS NPersona, CONCAT(`g_persona`.`Edad`,' ' ,g_tipoedad.`Nbre`,'(s)') AS Edad, g_persona.`Id_Sexo`,  `ingreso`.`Id_Usuario`, `ingreso`.`Id`, `c_citasnp`.`Asistida` , `c_clasecita`.`Id_Historia`, `c_citasnp`.`Id`, `ingreso`.`HoraIngreso`, IF(`c_citasnp`.`Observacion` IS NULL, '', `c_citasnp`.`Observacion`) AS Observacion, c_clasecita.Id, ingreso.Id_TipoAtencion, 0 as RCargos, `h_tipohistoria`.`Forma` FROM  `ingreso`  INNER JOIN `c_citasnp`  ON (`ingreso`.`Id` = `c_citasnp`.`Id_ingreso`)  INNER JOIN g_persona  ON (`g_persona`.`Id` = c_citasnp.Id_Usuario) INNER JOIN g_usuario  ON (g_usuario.Id_persona = g_persona.`Id`)    INNER JOIN `g_tipoedad`  ON (`g_persona`.`Id_TipoEdad` = `g_tipoedad`.`Id`)    INNER JOIN `c_clasecita`  ON (`c_citasnp`.`Id_ClaseCita` = `c_clasecita`.`Id`) INNER JOIN `h_tipohistoria` ON (`c_clasecita`.`Id_Historia` = `h_tipohistoria`.`Id`) WHERE (`ingreso`.Id_Especialidad='" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "'  and `c_clasecita`.`EsQx` =1 AND `c_citasnp`.`Id_MotivoDesistida` =0 AND `c_citasnp`.`Id_Anulada` =0 AND `ingreso`.`FechaIngreso` ='" + this.xmetodo.formatoAMD1.format(this.xclaseHC.xjifagendan.JDCFechaAgenda.getDate()) + "') ORDER BY `ingreso`.`HoraIngreso` ASC ";
            }
        }
        this.rs = this.xconsultasbd.traerRs(this.xsql);
        try {
            if (this.rs.next()) {
                this.rs.beforeFirst();
                int i = 0;
                while (this.rs.next()) {
                    this.xmodelod.addRow(this.dato);
                    this.xmodelod.setValueAt(this.rs.getString(1), i, 0);
                    this.xmodelod.setValueAt(this.rs.getString(2), i, 1);
                    this.xmodelod.setValueAt(this.rs.getString(3), i, 2);
                    this.xmodelod.setValueAt(this.rs.getString(4), i, 3);
                    this.xmodelod.setValueAt(Long.valueOf(this.rs.getLong(5)), i, 4);
                    this.xmodelod.setValueAt(Long.valueOf(this.rs.getLong(6)), i, 5);
                    this.xmodelod.setValueAt(Boolean.valueOf(this.rs.getBoolean(7)), i, 6);
                    this.xmodelod.setValueAt(Long.valueOf(this.rs.getLong(8)), i, 7);
                    this.xmodelod.setValueAt(Long.valueOf(this.rs.getLong(9)), i, 8);
                    if (this.xTipo == 1) {
                        this.xmodelod.setValueAt(this.rs.getString(10), i, 9);
                        this.xmodelod.setValueAt(this.rs.getString(11), i, 10);
                        this.xmodelod.setValueAt(Long.valueOf(this.rs.getLong(12)), i, 11);
                        this.xmodelod.setValueAt(this.rs.getString("Id_TipoAtencion"), i, 12);
                        this.xmodelod.setValueAt(Long.valueOf(this.rs.getLong("RCargos")), i, 13);
                        this.xmodelod.setValueAt(Long.valueOf(this.rs.getLong("Forma")), i, 14);
                    } else {
                        this.xmodelod.setValueAt(Long.valueOf(this.rs.getLong(10)), i, 9);
                        this.xmodelod.setValueAt(this.rs.getString("Id_TipoAtencion"), i, 10);
                        this.xmodelod.setValueAt(Long.valueOf(this.rs.getLong("RCargos")), i, 11);
                        this.xmodelod.setValueAt(Long.valueOf(this.rs.getLong("Forma")), i, 12);
                    }
                    i++;
                }
            }
            this.rs.close();
            this.xconsultasbd.cerrarConexionBd();
            this.xconsultasbd.cerrarConexionBd();
        } catch (SQLException e) {
        }
    }
}
