package Facturacion;

import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Facturacion/JIF_Gestion_Hospitalizacion.class */
public class JIF_Gestion_Hospitalizacion extends JInternalFrame {
    private Metodos xmt = new Metodos();
    private ConsultasMySQL xct = new ConsultasMySQL();
    private String xsql;
    public DefaultTableModel xmodelo;
    private Object[] xdato;
    public JDateChooser JDCFechaF;
    public JDateChooser JDCFechaI;
    private JPanel JPIDatosC;
    private JPanel JPIEstado;
    private JRadioButton JRBDespachada;
    private JRadioButton JRBPorDespachar;
    private JScrollPane JSPS_Solicutudes;
    public JTable JTAgenda;
    private JTabbedPane JTPDatosA;

    public JIF_Gestion_Hospitalizacion() {
        initComponents();
    }

    /* JADX WARN: Type inference failed for: r3v41, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPIDatosC = new JPanel();
        this.JDCFechaI = new JDateChooser();
        this.JDCFechaF = new JDateChooser();
        this.JPIEstado = new JPanel();
        this.JRBPorDespachar = new JRadioButton();
        this.JRBDespachada = new JRadioButton();
        this.JTPDatosA = new JTabbedPane();
        this.JSPS_Solicutudes = new JScrollPane();
        this.JTAgenda = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("GESTIÓN DE HOSPITALIZACIÓN");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        this.JPIDatosC.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS PARA CONSULTAR", 0, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JDCFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicio", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDCFechaI.setFont(new Font("Arial", 1, 12));
        this.JDCFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Fin", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDCFechaF.setFont(new Font("Arial", 1, 12));
        this.JPIEstado.setBorder(BorderFactory.createTitledBorder((Border) null, "Estado", 0, 0, new Font("Arial", 1, 12), new Color(255, 0, 0)));
        this.JRBPorDespachar.setFont(new Font("Arial", 1, 12));
        this.JRBPorDespachar.setForeground(Color.blue);
        this.JRBPorDespachar.setSelected(true);
        this.JRBPorDespachar.setText("Por Autorizar");
        this.JRBPorDespachar.addActionListener(new ActionListener() { // from class: Facturacion.JIF_Gestion_Hospitalizacion.1
            public void actionPerformed(ActionEvent evt) {
                JIF_Gestion_Hospitalizacion.this.JRBPorDespacharActionPerformed(evt);
            }
        });
        this.JRBDespachada.setFont(new Font("Arial", 1, 12));
        this.JRBDespachada.setForeground(Color.blue);
        this.JRBDespachada.setText("Autorizadas");
        this.JRBDespachada.addActionListener(new ActionListener() { // from class: Facturacion.JIF_Gestion_Hospitalizacion.2
            public void actionPerformed(ActionEvent evt) {
                JIF_Gestion_Hospitalizacion.this.JRBDespachadaActionPerformed(evt);
            }
        });
        GroupLayout JPIEstadoLayout = new GroupLayout(this.JPIEstado);
        this.JPIEstado.setLayout(JPIEstadoLayout);
        JPIEstadoLayout.setHorizontalGroup(JPIEstadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIEstadoLayout.createSequentialGroup().addContainerGap().addComponent(this.JRBPorDespachar).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBDespachada).addContainerGap(-1, 32767)));
        JPIEstadoLayout.setVerticalGroup(JPIEstadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIEstadoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBPorDespachar).addComponent(this.JRBDespachada)));
        GroupLayout JPIDatosCLayout = new GroupLayout(this.JPIDatosC);
        this.JPIDatosC.setLayout(JPIDatosCLayout);
        JPIDatosCLayout.setHorizontalGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosCLayout.createSequentialGroup().addContainerGap().addComponent(this.JDCFechaI, -2, 110, -2).addGap(18, 18, 18).addComponent(this.JDCFechaF, -2, 110, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 269, 32767).addComponent(this.JPIEstado, -2, -1, -2).addContainerGap()));
        JPIDatosCLayout.setVerticalGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosCLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPIEstado, -2, -1, -2).addGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JDCFechaI, -2, 50, -2).addComponent(this.JDCFechaF, -2, 50, -2))).addContainerGap(-1, 32767)));
        this.JTPDatosA.setForeground(new Color(0, 103, 0));
        this.JTPDatosA.setFont(new Font("Arial", 1, 14));
        this.JTAgenda.setFont(new Font("Arial", 1, 12));
        this.JTAgenda.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTAgenda.setRowHeight(25);
        this.JTAgenda.setSelectionBackground(new Color(255, 255, 255));
        this.JTAgenda.setSelectionForeground(new Color(255, 0, 0));
        this.JTAgenda.addMouseListener(new MouseAdapter() { // from class: Facturacion.JIF_Gestion_Hospitalizacion.3
            public void mouseClicked(MouseEvent evt) {
                JIF_Gestion_Hospitalizacion.this.JTAgendaMouseClicked(evt);
            }
        });
        this.JTAgenda.addPropertyChangeListener(new PropertyChangeListener() { // from class: Facturacion.JIF_Gestion_Hospitalizacion.4
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIF_Gestion_Hospitalizacion.this.JTAgendaPropertyChange(evt);
            }
        });
        this.JSPS_Solicutudes.setViewportView(this.JTAgenda);
        this.JTPDatosA.addTab("AGENDA", this.JSPS_Solicutudes);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.JPIDatosC, -2, -1, -2).addGap(0, 17, 32767)).addComponent(this.JTPDatosA)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatosC, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTPDatosA, -1, 386, 32767).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTAgendaMouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTAgendaPropertyChange(PropertyChangeEvent evt) {
        if (this.JTAgenda.getRowCount() != -1) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBPorDespacharActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBDespachadaActionPerformed(ActionEvent evt) {
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTablaAgenda() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Fecha", "No. Historia", "Usuario", "Sexo", "Edad", "Especialidad", "Profesional", "Empresa"}) { // from class: Facturacion.JIF_Gestion_Hospitalizacion.5
            Class[] types = {Long.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Long.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTAgenda.setModel(this.xmodelo);
        this.JTAgenda.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTAgenda.getColumnModel().getColumn(1).setPreferredWidth(20);
        this.JTAgenda.getColumnModel().getColumn(2).setPreferredWidth(10);
        this.JTAgenda.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTAgenda.getColumnModel().getColumn(4).setPreferredWidth(10);
        this.JTAgenda.getColumnModel().getColumn(5).setPreferredWidth(10);
        this.JTAgenda.getColumnModel().getColumn(6).setPreferredWidth(80);
        this.JTAgenda.getColumnModel().getColumn(7).setPreferredWidth(100);
        this.JTAgenda.getColumnModel().getColumn(8).setPreferredWidth(10);
        this.JTAgenda.getColumnModel().getColumn(9).setPreferredWidth(10);
        this.JTAgenda.getColumnModel().getColumn(10).setPreferredWidth(10);
        this.JTAgenda.getColumnModel().getColumn(11).setPreferredWidth(50);
    }

    public void mCargarDatos() {
        if (this.JDCFechaI.getDate() != null && this.xmodelo != null) {
            try {
                mCrearTablaAgenda();
                if (this.JRBPorDespachar.isSelected()) {
                    this.xsql = "SELECT `h_ordenes_unidosis`.`Id` , `h_ordenes_unidosis`.`Fecha_S`  , `g_usuario`.`NoHistoria` ,  CONCAT(`g_persona`.`Apellido1` ,' ' , `g_persona`.`Apellido2`, ' ' , `g_persona`.`Nombre1`, ' ' , `g_persona`.`Nombre2`) AS Nombre ,`g_persona`.`Id_Sexo`, CONCAT(`g_persona`.`Edad`,' ', `g_tipoedad`.`Nbre`,'(s)') AS `Edad` , `profesional1`.`Especialidad` ,  `profesional1`.`NProfesional` , `f_camas`.`Nbre` AS Cama , IF(`h_ordenes_unidosis`.`Tipo`=3,'URGENCIAS', IF(`h_ordenes_unidosis`.`Tipo`=2,'HOSPITALIZACION', 'AMBULATORIO')) AS `TATencion`  , `h_ordenes_unidosis_detalle`.`Id_Salida`, `f_empresacontxconvenio`.`Nbre`  FROM `h_ordenes_unidosis`  INNER JOIN `ingreso`  ON (`h_ordenes_unidosis`.`Id_Ingreso` = `ingreso`.`Id`)  INNER JOIN `g_usuario`    ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`) INNER JOIN `g_persona`  ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`) INNER JOIN `g_tipoedad`  ON (`g_tipoedad`.`Id` = `g_persona`.`Id_TipoEdad`) INNER JOIN `profesional1`  ON (`profesional1`.`Id_Persona` = `h_ordenes_unidosis`.`Id_Profesional`) AND (`profesional1`.`IdEspecialidad` = `h_ordenes_unidosis`.`Id_Especialidad`)  INNER JOIN `h_ordenes_unidosis_detalle`  ON (`h_ordenes_unidosis_detalle`.`Id_Ordenes` = `h_ordenes_unidosis`.`Id`) INNER JOIN `f_empresacontxconvenio`   ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)  LEFT JOIN `f_camas`   ON (`ingreso`.`Cama` = `f_camas`.`Id`)  WHERE ( `h_ordenes_unidosis`.`Estado` =1 AND `h_ordenes_unidosis_detalle`.`Id_Salida` =0   AND DATE_FORMAT(`h_ordenes_unidosis`.`Fecha_S`,'%Y/%m/%d') >='" + this.xmt.formatoAMD.format(this.JDCFechaI.getDate()) + "' AND DATE_FORMAT(`h_ordenes_unidosis`.`Fecha_S`,'%Y/%m/%d') <='" + this.xmt.formatoAMD.format(this.JDCFechaF.getDate()) + "') GROUP BY `h_ordenes_unidosis`.`Id`  ";
                } else if (this.JRBDespachada.isSelected()) {
                    this.xsql = "SELECT `h_ordenes_unidosis`.`Id` , `h_ordenes_unidosis`.`Fecha_S`  , `g_usuario`.`NoHistoria` ,  CONCAT(`g_persona`.`Apellido1` ,' ' , `g_persona`.`Apellido2`, ' ' , `g_persona`.`Nombre1`, ' ' , `g_persona`.`Nombre2`) AS Nombre ,`g_persona`.`Id_Sexo`, CONCAT(`g_persona`.`Edad`,' ', `g_tipoedad`.`Nbre`,'(s)') AS `Edad` , `profesional1`.`Especialidad` ,  `profesional1`.`NProfesional` , `f_camas`.`Nbre` AS Cama , IF(`h_ordenes_unidosis`.`Tipo`=3,'URGENCIAS', IF(`h_ordenes_unidosis`.`Tipo`=2,'HOSPITALIZACION', 'AMBULATORIO')) AS `TATencion`  , `h_ordenes_unidosis_detalle`.`Id_Salida`, `f_empresacontxconvenio`.`Nbre`  FROM `h_ordenes_unidosis`  INNER JOIN `ingreso`  ON (`h_ordenes_unidosis`.`Id_Ingreso` = `ingreso`.`Id`)  INNER JOIN `g_usuario`    ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`) INNER JOIN `g_persona`  ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`) INNER JOIN `g_tipoedad`  ON (`g_tipoedad`.`Id` = `g_persona`.`Id_TipoEdad`) INNER JOIN `profesional1`  ON (`profesional1`.`Id_Persona` = `h_ordenes_unidosis`.`Id_Profesional`) AND (`profesional1`.`IdEspecialidad` = `h_ordenes_unidosis`.`Id_Especialidad`)  INNER JOIN `h_ordenes_unidosis_detalle`  ON (`h_ordenes_unidosis_detalle`.`Id_Ordenes` = `h_ordenes_unidosis`.`Id`) INNER JOIN `f_empresacontxconvenio`   ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)  LEFT JOIN `f_camas`   ON (`ingreso`.`Cama` = `f_camas`.`Id`)  WHERE ( `h_ordenes_unidosis`.`Estado` =1 AND `h_ordenes_unidosis_detalle`.`Id_Salida` <>0   AND DATE_FORMAT(`h_ordenes_unidosis`.`Fecha_S`,'%Y/%m/%d') >='" + this.xmt.formatoAMD.format(this.JDCFechaI.getDate()) + "' AND DATE_FORMAT(`h_ordenes_unidosis`.`Fecha_S`,'%Y/%m/%d') <='" + this.xmt.formatoAMD.format(this.JDCFechaF.getDate()) + "') GROUP BY `h_ordenes_unidosis`.`Id`  ";
                }
                ResultSet xrs = this.xct.traerRs(this.xsql);
                if (xrs.next()) {
                    xrs.beforeFirst();
                    int xfila = 0;
                    while (xrs.next()) {
                        this.xmodelo.addRow(this.xdato);
                        this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(1)), xfila, 0);
                        this.xmodelo.setValueAt(xrs.getString(2), xfila, 1);
                        this.xmodelo.setValueAt(xrs.getString(3), xfila, 2);
                        this.xmodelo.setValueAt(xrs.getString(4), xfila, 3);
                        this.xmodelo.setValueAt(xrs.getString(5), xfila, 4);
                        this.xmodelo.setValueAt(xrs.getString(6), xfila, 5);
                        this.xmodelo.setValueAt(xrs.getString(7), xfila, 6);
                        this.xmodelo.setValueAt(xrs.getString(8), xfila, 7);
                        this.xmodelo.setValueAt(xrs.getString(9), xfila, 8);
                        this.xmodelo.setValueAt(xrs.getString(10), xfila, 9);
                        this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(11)), xfila, 10);
                        this.xmodelo.setValueAt(xrs.getString(12), xfila, 11);
                        xfila++;
                    }
                }
                xrs.close();
                this.xct.cerrarConexionBd();
            } catch (SQLException e) {
            }
        }
    }
}
