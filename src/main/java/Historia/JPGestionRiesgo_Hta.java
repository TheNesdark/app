package Historia;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Historia/JPGestionRiesgo_Hta.class */
public class JPGestionRiesgo_Hta extends JPanel {
    private clasesHistoriaCE xclase;
    private DefaultTableModel xmodelo;
    private Object[] xdatos;
    private String[] xclasificacionR;
    private String[] xidriesgo;
    private String xsql;
    private JButton JBTGuardar;
    private JComboBox JCBCRiesgo;
    private JComboBox JCBHta_ClasificacionR;
    private JComboBox JCBR_ClasificacionEstadio;
    private JDateChooser JDDT_Dialisis;
    private JDateChooser JDDT_Predialisis;
    private JDateChooser JDDT_Transplante;
    private JPanel JPICRiesgo;
    private JPanel JPIDDial_Transplante;
    private JPanel JPIDNFproteccion;
    private JPanel JPIGRiesgo;
    private JScrollPane JSPHistorico;
    private JTable JTBDetalle;
    private JTabbedPane JTPDatosPyp;
    private int xcontroldm = 0;
    private Metodos xmt = new Metodos();
    private ConsultasMySQL xct = new ConsultasMySQL();
    private String xid = "0";

    public JPGestionRiesgo_Hta(clasesHistoriaCE xclase) {
        initComponents();
        this.xclase = xclase;
        mNuevo();
        mBuscarDatos();
    }

    private void initComponents() {
        this.JPIGRiesgo = new JPanel();
        this.JTPDatosPyp = new JTabbedPane();
        this.JPICRiesgo = new JPanel();
        this.JPIDNFproteccion = new JPanel();
        this.JCBR_ClasificacionEstadio = new JComboBox();
        this.JPIDDial_Transplante = new JPanel();
        this.JDDT_Predialisis = new JDateChooser();
        this.JDDT_Dialisis = new JDateChooser();
        this.JDDT_Transplante = new JDateChooser();
        this.JBTGuardar = new JButton();
        this.JSPHistorico = new JScrollPane();
        this.JTBDetalle = new JTable();
        this.JCBCRiesgo = new JComboBox();
        this.JCBHta_ClasificacionR = new JComboBox();
        setName("jpgestionriesgo_hta");
        this.JPIGRiesgo.setBorder(BorderFactory.createTitledBorder((Border) null, "CLASIFICACIÓN DEL RIESGO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JPIGRiesgo.setForeground(new Color(0, 103, 0));
        this.JPIGRiesgo.setFont(new Font("Arial", 1, 14));
        this.JTPDatosPyp.setForeground(new Color(255, 0, 0));
        this.JTPDatosPyp.setFont(new Font("Arial", 1, 12));
        this.JPIDNFproteccion.setBorder(BorderFactory.createTitledBorder((Border) null, "ESTADIO ACTUAL DE NEFROPROTECCIÓN", 2, 0, new Font("Arial", 1, 12), new Color(255, 0, 0)));
        this.JCBR_ClasificacionEstadio.setFont(new Font("Arial", 1, 12));
        this.JCBR_ClasificacionEstadio.setModel(new DefaultComboBoxModel(new String[]{" ", "Estadío 1", "Estadío 2", "Estadío 3", "Estadío 4", "Estadío 5"}));
        this.JCBR_ClasificacionEstadio.setBorder(BorderFactory.createTitledBorder((Border) null, "Clasificación de Estadío", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPIDNFproteccionLayout = new GroupLayout(this.JPIDNFproteccion);
        this.JPIDNFproteccion.setLayout(JPIDNFproteccionLayout);
        JPIDNFproteccionLayout.setHorizontalGroup(JPIDNFproteccionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDNFproteccionLayout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.JCBR_ClasificacionEstadio, -2, 221, -2).addContainerGap()));
        JPIDNFproteccionLayout.setVerticalGroup(JPIDNFproteccionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBR_ClasificacionEstadio, -2, 50, -2));
        this.JPIDDial_Transplante.setBorder(BorderFactory.createTitledBorder((Border) null, "PROGRAMA DE DIALISIS O TRANSPLANTE", 2, 0, new Font("Arial", 1, 12), new Color(255, 0, 0)));
        this.JDDT_Predialisis.setBorder(BorderFactory.createTitledBorder((Border) null, "Prediálisis", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JDDT_Predialisis.setToolTipText("Fecha Prediálisis");
        this.JDDT_Predialisis.setDateFormatString("dd/MM/yyyy");
        this.JDDT_Predialisis.setFont(new Font("Arial", 1, 12));
        this.JDDT_Dialisis.setBorder(BorderFactory.createTitledBorder((Border) null, "Diálisis", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JDDT_Dialisis.setToolTipText("Fecha Diálisis");
        this.JDDT_Dialisis.setDateFormatString("dd/MM/yyyy");
        this.JDDT_Dialisis.setFont(new Font("Arial", 1, 12));
        this.JDDT_Transplante.setBorder(BorderFactory.createTitledBorder((Border) null, "Transplante", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JDDT_Transplante.setToolTipText("Fecha Transplante");
        this.JDDT_Transplante.setDateFormatString("dd/MM/yyyy");
        this.JDDT_Transplante.setFont(new Font("Arial", 1, 12));
        GroupLayout JPIDDial_TransplanteLayout = new GroupLayout(this.JPIDDial_Transplante);
        this.JPIDDial_Transplante.setLayout(JPIDDial_TransplanteLayout);
        JPIDDial_TransplanteLayout.setHorizontalGroup(JPIDDial_TransplanteLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDDial_TransplanteLayout.createSequentialGroup().addContainerGap().addComponent(this.JDDT_Predialisis, -2, 110, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JDDT_Dialisis, -2, 110, -2).addGap(18, 18, 18).addComponent(this.JDDT_Transplante, -2, 110, -2).addContainerGap(-1, 32767)));
        JPIDDial_TransplanteLayout.setVerticalGroup(JPIDDial_TransplanteLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDDial_TransplanteLayout.createSequentialGroup().addContainerGap().addGroup(JPIDDial_TransplanteLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JDDT_Predialisis, -2, 50, -2).addComponent(this.JDDT_Dialisis, -2, 50, -2).addComponent(this.JDDT_Transplante, -2, 50, -2)).addContainerGap(-1, 32767)));
        this.JBTGuardar.setFont(new Font("Arial", 1, 12));
        this.JBTGuardar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTGuardar.setText("Guardar");
        this.JBTGuardar.addActionListener(new ActionListener() { // from class: Historia.JPGestionRiesgo_Hta.1
            public void actionPerformed(ActionEvent evt) {
                JPGestionRiesgo_Hta.this.JBTGuardarActionPerformed(evt);
            }
        });
        this.JSPHistorico.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JTBDetalle.setFont(new Font("Arial", 1, 12));
        this.JTBDetalle.setRowHeight(25);
        this.JTBDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTBDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JSPHistorico.setViewportView(this.JTBDetalle);
        this.JCBCRiesgo.setFont(new Font("Arial", 1, 12));
        this.JCBCRiesgo.setBorder(BorderFactory.createTitledBorder((Border) null, "Clasificación Riesgo Cardiovascular", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JCBHta_ClasificacionR.setFont(new Font("Arial", 1, 12));
        this.JCBHta_ClasificacionR.setModel(new DefaultComboBoxModel(new String[]{" ", "Bajo", "Moderado", "Alto"}));
        this.JCBHta_ClasificacionR.setBorder(BorderFactory.createTitledBorder((Border) null, "Clasificación de Riesgo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPICRiesgoLayout = new GroupLayout(this.JPICRiesgo);
        this.JPICRiesgo.setLayout(JPICRiesgoLayout);
        JPICRiesgoLayout.setHorizontalGroup(JPICRiesgoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPICRiesgoLayout.createSequentialGroup().addContainerGap().addGroup(JPICRiesgoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPICRiesgoLayout.createSequentialGroup().addGroup(JPICRiesgoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JBTGuardar, -1, -1, 32767).addComponent(this.JSPHistorico, -1, 746, 32767)).addContainerGap()).addGroup(JPICRiesgoLayout.createSequentialGroup().addGroup(JPICRiesgoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBHta_ClasificacionR, -2, 258, -2).addComponent(this.JCBCRiesgo, -2, 273, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addGroup(JPICRiesgoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPIDDial_Transplante, -2, -1, -2).addComponent(this.JPIDNFproteccion, -2, -1, -2)).addGap(20, 20, 20)))));
        JPICRiesgoLayout.setVerticalGroup(JPICRiesgoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPICRiesgoLayout.createSequentialGroup().addContainerGap().addGroup(JPICRiesgoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPICRiesgoLayout.createSequentialGroup().addComponent(this.JPIDDial_Transplante, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPIDNFproteccion, -2, -1, -2)).addGroup(JPICRiesgoLayout.createSequentialGroup().addComponent(this.JCBHta_ClasificacionR, -2, 51, -2).addGap(18, 18, 18).addComponent(this.JCBCRiesgo, -2, 50, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPHistorico, -1, 183, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTGuardar, -2, 41, -2).addContainerGap()));
        this.JTPDatosPyp.addTab("CLASIFICACIÓN DE RIESGO", this.JPICRiesgo);
        GroupLayout JPIGRiesgoLayout = new GroupLayout(this.JPIGRiesgo);
        this.JPIGRiesgo.setLayout(JPIGRiesgoLayout);
        JPIGRiesgoLayout.setHorizontalGroup(JPIGRiesgoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIGRiesgoLayout.createSequentialGroup().addContainerGap().addComponent(this.JTPDatosPyp)));
        JPIGRiesgoLayout.setVerticalGroup(JPIGRiesgoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIGRiesgoLayout.createSequentialGroup().addContainerGap().addComponent(this.JTPDatosPyp).addContainerGap()));
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIGRiesgo, -1, -1, 32767).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIGRiesgo, -1, -1, 32767).addContainerGap()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTGuardarActionPerformed(ActionEvent evt) {
        mGrabar();
    }

    private void mNuevo() {
        this.xidriesgo = this.xct.llenarCombo("SELECT `Id` , `Nbre` FROM `h_tipo_riesgo` WHERE (`Tipo` =1) ORDER BY `Nbre` ASC", this.xidriesgo, this.JCBCRiesgo);
        this.JCBCRiesgo.setSelectedItem("SIN DETERMINAR");
        this.xct.cerrarConexionBd();
        mCargarDatosTabla();
    }

    public void mGrabar() {
        if (this.xid.equals("0")) {
            this.xsql = "insert into `p_clasificacion_riesgo`(`Id_Usuario`,`Id_UsuarioP`, `Id_Atencion`, `FechaC`, `CRiesgoC`, `Hta_CRiesgo`,  `NF_Estadio`, `NF_FPreDialisis`, `NF_FDialisis`, `NF_FTransplante`, `Id_Profesional`, `Id_Especialidad`)  values('" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "','" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioPrograma() + "','" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "','" + this.xmt.formatoAMD.format(this.xmt.getFechaActual()) + "','" + this.JCBCRiesgo.getSelectedItem() + "','" + this.JCBHta_ClasificacionR.getSelectedItem() + "','" + this.JCBR_ClasificacionEstadio.getSelectedItem() + "' ," + mDatoFecha_Valor(this.JDDT_Predialisis) + " ," + mDatoFecha_Valor(this.JDDT_Dialisis) + " ," + mDatoFecha_Valor(this.JDDT_Transplante) + " ,'" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "' ,'" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "')";
            this.xid = this.xct.ejecutarSQLId(this.xsql);
            this.xct.cerrarConexionBd();
            this.xsql = "update g_usuarioxprograma set U_CRiesgo_Hta='" + this.JCBHta_ClasificacionR.getSelectedItem() + "',U_CRiesgo='" + this.JCBCRiesgo.getSelectedItem() + "',U_Estadio_NFP='" + this.JCBR_ClasificacionEstadio.getSelectedItem() + "',NF_FPreDialisis=" + mDatoFecha_Valor(this.JDDT_Predialisis) + ",NF_FDialisis=" + mDatoFecha_Valor(this.JDDT_Dialisis) + ",NF_FTranspante=" + mDatoFecha_Valor(this.JDDT_Transplante) + " where Id='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioPrograma() + "'";
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
            mCargarDatosTabla();
            this.xmt.cambiarEstadoValidadoItemHC(getName(), 1, true);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTabla() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "id_Atención", "Fecha", "Riesgo Hta", "C/Estadío", "F/Prediálisis", "F/Diálisis", "F/Transplante", "Profesional"}) { // from class: Historia.JPGestionRiesgo_Hta.2
            Class[] types = {Long.class, Long.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTBDetalle.setModel(this.xmodelo);
        this.JTBDetalle.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(1).setPreferredWidth(5);
        this.JTBDetalle.getColumnModel().getColumn(2).setPreferredWidth(10);
        this.JTBDetalle.getColumnModel().getColumn(3).setPreferredWidth(15);
        this.JTBDetalle.getColumnModel().getColumn(4).setPreferredWidth(15);
        this.JTBDetalle.getColumnModel().getColumn(5).setPreferredWidth(15);
        this.JTBDetalle.getColumnModel().getColumn(6).setPreferredWidth(15);
        this.JTBDetalle.getColumnModel().getColumn(7).setPreferredWidth(15);
        this.JTBDetalle.getColumnModel().getColumn(8).setPreferredWidth(15);
    }

    private void mCargarDatosTabla() {
        try {
            mCrearTabla();
            this.xsql = "SELECT `p_clasificacion_riesgo`.`Id`,`p_clasificacion_riesgo`.`Id_Atencion`, `p_clasificacion_riesgo`.`FechaC`, `p_clasificacion_riesgo`.`Hta_CRiesgo` , `p_clasificacion_riesgo`.`NF_Estadio` , `p_clasificacion_riesgo`.`NF_FPreDialisis` , `p_clasificacion_riesgo`.`NF_FDialisis` , `p_clasificacion_riesgo`.`NF_FTransplante` , `profesional1`.`Especialidad` , `profesional1`.`NProfesional` FROM  `profesional1` INNER JOIN `p_clasificacion_riesgo`  ON (`profesional1`.`Id_Persona` = `p_clasificacion_riesgo`.`Id_Profesional`) AND (`profesional1`.`IdEspecialidad` = `p_clasificacion_riesgo`.`Id_Especialidad`) WHERE (`p_clasificacion_riesgo`.`Id_Usuario` ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "' AND `p_clasificacion_riesgo`.`Estado` =1) ORDER BY `p_clasificacion_riesgo`.`FechaC` DESC ";
            ResultSet rs = this.xct.traerRs(this.xsql);
            rs.next();
            if (rs.getRow() != 0) {
                rs.beforeFirst();
                int i = 0;
                while (rs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(Long.valueOf(rs.getLong(1)), i, 0);
                    this.xmodelo.setValueAt(Long.valueOf(rs.getLong(2)), i, 1);
                    this.xmodelo.setValueAt(rs.getString(3), i, 2);
                    this.xmodelo.setValueAt(rs.getString(4), i, 3);
                    this.xmodelo.setValueAt(rs.getString(5), i, 4);
                    this.xmodelo.setValueAt(rs.getString(6), i, 5);
                    this.xmodelo.setValueAt(rs.getString(7), i, 6);
                    this.xmodelo.setValueAt(rs.getString(8), i, 7);
                    this.xmodelo.setValueAt(rs.getString(9), i, 8);
                    i++;
                }
            }
            rs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPANotas.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private String mDatoFecha(JDateChooser xcomp, String xvariable) {
        String xv;
        if (xcomp.getDate() != null) {
            xv = xvariable + "='" + this.xmt.formatoAMD.format(xcomp.getDate()) + "'";
        } else {
            xv = xvariable + "=" + ((Object) null) + "";
        }
        return xv;
    }

    private String mDatoFecha_Valor(JDateChooser xcomp) {
        String xv;
        if (xcomp.getDate() != null) {
            xv = "'" + this.xmt.formatoAMD.format(xcomp.getDate()) + "'";
        } else {
            xv = null;
        }
        return xv;
    }

    private void mBuscarDatos() {
        try {
            this.xsql = "SELECT `Hta_CRiesgo`, `Dm_CRiesgo`, `Dm_Tipo`, `Dm_TipoInsulina`, `NF_Estadio`, `NF_FPreDialisis`, `NF_FDialisis`, `NF_FTransplante`, `Id` FROM  `p_clasificacion_riesgo` WHERE (`Id_Atencion` ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "' AND `Estado` =1) ";
            ResultSet xrs = this.xct.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.first();
                this.JCBHta_ClasificacionR.setSelectedItem(xrs.getString(1));
                this.JCBR_ClasificacionEstadio.setSelectedItem(xrs.getString(5));
                this.JDDT_Predialisis.setDate(xrs.getDate(6));
                this.JDDT_Dialisis.setDate(xrs.getDate(7));
                this.JDDT_Transplante.setDate(xrs.getDate(8));
                this.xid = xrs.getString(9);
                this.xmt.cambiarEstadoValidadoItemHC(getName(), 1, true);
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPGestionRiesgo_Hta.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }
}
