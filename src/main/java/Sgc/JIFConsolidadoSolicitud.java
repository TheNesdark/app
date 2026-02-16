package Sgc;

import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Sgc/JIFConsolidadoSolicitud.class */
public class JIFConsolidadoSolicitud extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private DefaultTableModel xmodelo1;
    private DefaultTableModel xmodelo2;
    private String xsql;
    private Object[] xdato;
    private JCheckBox JCHAutorizada;
    private JCheckBox JCHCerrada;
    private JDateChooser JDFechaF;
    private JDateChooser JDFechaI;
    private JPanel JPIConsolidado;
    private JPanel JPIDatosC;
    private JPanel JPIDetallada;
    private JPanel JPISolicitudes;
    private JScrollPane JSPSConsolidada;
    private JScrollPane JSPSDetallada;
    private JTabbedPane JTPDatosC;
    private JTabbedPane JTPSolicitudes;
    public JTable JTSConsolidada;
    public JTable JTSDetallada;
    private int xaprobadas = 0;
    private int xcerrarda = 0;
    private Metodos xmt = new Metodos();
    private ConsultasMySQL xct = new ConsultasMySQL();

    public JIFConsolidadoSolicitud() {
        initComponents();
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v35, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v48, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPIDatosC = new JPanel();
        this.JDFechaI = new JDateChooser();
        this.JDFechaF = new JDateChooser();
        this.JCHAutorizada = new JCheckBox();
        this.JCHCerrada = new JCheckBox();
        this.JTPDatosC = new JTabbedPane();
        this.JPISolicitudes = new JPanel();
        this.JTPSolicitudes = new JTabbedPane();
        this.JPIConsolidado = new JPanel();
        this.JSPSConsolidada = new JScrollPane();
        this.JTSConsolidada = new JTable();
        this.JPIDetallada = new JPanel();
        this.JSPSDetallada = new JScrollPane();
        this.JTSDetallada = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("CONSOLIDADO");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjifconsolidadosolicitudes");
        this.JPIDatosC.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS CONSULTA", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JDFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicial", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFechaI.setFont(new Font("Arial", 1, 12));
        this.JDFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Final", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFechaF.setFont(new Font("Arial", 1, 12));
        this.JCHAutorizada.setFont(new Font("Arial", 1, 12));
        this.JCHAutorizada.setForeground(Color.blue);
        this.JCHAutorizada.setSelected(true);
        this.JCHAutorizada.setText("Aprobada?");
        this.JCHAutorizada.addActionListener(new ActionListener() { // from class: Sgc.JIFConsolidadoSolicitud.1
            public void actionPerformed(ActionEvent evt) {
                JIFConsolidadoSolicitud.this.JCHAutorizadaActionPerformed(evt);
            }
        });
        this.JCHCerrada.setFont(new Font("Arial", 1, 12));
        this.JCHCerrada.setForeground(Color.blue);
        this.JCHCerrada.setSelected(true);
        this.JCHCerrada.setText("Cerradas?");
        this.JCHCerrada.addActionListener(new ActionListener() { // from class: Sgc.JIFConsolidadoSolicitud.2
            public void actionPerformed(ActionEvent evt) {
                JIFConsolidadoSolicitud.this.JCHCerradaActionPerformed(evt);
            }
        });
        GroupLayout JPIDatosCLayout = new GroupLayout(this.JPIDatosC);
        this.JPIDatosC.setLayout(JPIDatosCLayout);
        JPIDatosCLayout.setHorizontalGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosCLayout.createSequentialGroup().addContainerGap().addComponent(this.JDFechaI, -2, 120, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JDFechaF, -2, 120, -2).addGap(18, 18, 18).addComponent(this.JCHAutorizada).addGap(18, 18, 18).addComponent(this.JCHCerrada).addContainerGap(-1, 32767)));
        JPIDatosCLayout.setVerticalGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosCLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCHAutorizada).addComponent(this.JCHCerrada)).addGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JDFechaF, GroupLayout.Alignment.LEADING, -1, 45, 32767).addComponent(this.JDFechaI, GroupLayout.Alignment.LEADING, -2, -1, -2))).addContainerGap(-1, 32767)));
        this.JTPDatosC.setForeground(new Color(0, 103, 0));
        this.JTPDatosC.setFont(new Font("Arial", 1, 14));
        this.JTPSolicitudes.setForeground(Color.red);
        this.JTPSolicitudes.setTabPlacement(3);
        this.JTPSolicitudes.setFont(new Font("Arial", 1, 13));
        this.JSPSConsolidada.setFont(new Font("Arial", 1, 12));
        this.JTSConsolidada.setBorder(BorderFactory.createBevelBorder(0));
        this.JTSConsolidada.setFont(new Font("Arial", 1, 12));
        this.JTSConsolidada.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTSConsolidada.setEditingColumn(0);
        this.JTSConsolidada.setEditingRow(0);
        this.JTSConsolidada.setGridColor(new Color(204, 204, 204));
        this.JTSConsolidada.setRowHeight(25);
        this.JTSConsolidada.setRowMargin(4);
        this.JTSConsolidada.setSelectionBackground(new Color(255, 255, 255));
        this.JTSConsolidada.setSelectionForeground(Color.red);
        this.JTSConsolidada.setSelectionMode(0);
        this.JSPSConsolidada.setViewportView(this.JTSConsolidada);
        GroupLayout JPIConsolidadoLayout = new GroupLayout(this.JPIConsolidado);
        this.JPIConsolidado.setLayout(JPIConsolidadoLayout);
        JPIConsolidadoLayout.setHorizontalGroup(JPIConsolidadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIConsolidadoLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPSConsolidada, -1, 785, 32767).addContainerGap()));
        JPIConsolidadoLayout.setVerticalGroup(JPIConsolidadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIConsolidadoLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPSConsolidada, -1, 263, 32767).addContainerGap()));
        this.JTPSolicitudes.addTab("CONSOLIDADO", this.JPIConsolidado);
        this.JSPSDetallada.setFont(new Font("Arial", 1, 12));
        this.JTSDetallada.setBorder(BorderFactory.createBevelBorder(0));
        this.JTSDetallada.setFont(new Font("Arial", 1, 12));
        this.JTSDetallada.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTSDetallada.setEditingColumn(0);
        this.JTSDetallada.setEditingRow(0);
        this.JTSDetallada.setGridColor(new Color(204, 204, 204));
        this.JTSDetallada.setRowHeight(25);
        this.JTSDetallada.setRowMargin(4);
        this.JTSDetallada.setSelectionBackground(new Color(255, 255, 255));
        this.JTSDetallada.setSelectionForeground(Color.red);
        this.JTSDetallada.setSelectionMode(0);
        this.JSPSDetallada.setViewportView(this.JTSDetallada);
        GroupLayout JPIDetalladaLayout = new GroupLayout(this.JPIDetallada);
        this.JPIDetallada.setLayout(JPIDetalladaLayout);
        JPIDetalladaLayout.setHorizontalGroup(JPIDetalladaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDetalladaLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPSDetallada, -1, 785, 32767).addContainerGap()));
        JPIDetalladaLayout.setVerticalGroup(JPIDetalladaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDetalladaLayout.createSequentialGroup().addContainerGap(66, 32767).addComponent(this.JSPSDetallada, -2, 208, -2).addContainerGap()));
        this.JTPSolicitudes.addTab("DETALLADA", this.JPIDetallada);
        GroupLayout JPISolicitudesLayout = new GroupLayout(this.JPISolicitudes);
        this.JPISolicitudes.setLayout(JPISolicitudesLayout);
        JPISolicitudesLayout.setHorizontalGroup(JPISolicitudesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPISolicitudesLayout.createSequentialGroup().addContainerGap().addComponent(this.JTPSolicitudes).addContainerGap()));
        JPISolicitudesLayout.setVerticalGroup(JPISolicitudesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPISolicitudesLayout.createSequentialGroup().addContainerGap().addComponent(this.JTPSolicitudes, -2, 314, -2).addContainerGap(-1, 32767)));
        this.JTPDatosC.addTab("SOLICITUDES", this.JPISolicitudes);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JTPDatosC, GroupLayout.Alignment.LEADING).addComponent(this.JPIDatosC, GroupLayout.Alignment.LEADING, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatosC, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTPDatosC, -2, 355, -2).addContainerGap(19, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHAutorizadaActionPerformed(ActionEvent evt) {
        if (this.JCHAutorizada.isSelected()) {
            this.xaprobadas = 1;
        } else {
            this.xaprobadas = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHCerradaActionPerformed(ActionEvent evt) {
        if (this.JCHCerrada.isSelected()) {
            this.xcerrarda = 1;
        } else {
            this.xcerrarda = 0;
        }
    }

    private void mNuevo() {
        this.JDFechaI.setDate(this.xmt.getFechaActual());
        this.JDFechaF.setDate(this.xmt.getFechaActual());
        mCrearTablaC();
        mCrearTablaD();
    }

    public void mBuscar() {
        mCargarDatosTablaC();
        mCargarDatosTablaD();
    }

    private void mCrearTablaC() {
        this.xmodelo = new DefaultTableModel((Object[][]) null, new String[]{"Id", "Nombre", "Cantidad", "Encuesta?"}) { // from class: Sgc.JIFConsolidadoSolicitud.3
            Class[] types = {Long.class, String.class, Long.class, Boolean.class};
            boolean[] canEdit = {false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return this.canEdit[colIndex];
            }
        };
        this.JTSConsolidada.setModel(this.xmodelo);
        this.JTSConsolidada.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTSConsolidada.getColumnModel().getColumn(1).setPreferredWidth(400);
        this.JTSConsolidada.getColumnModel().getColumn(2).setPreferredWidth(20);
        this.JTSConsolidada.getColumnModel().getColumn(3).setPreferredWidth(20);
    }

    private void mCrearTablaD() {
        this.xmodelo1 = new DefaultTableModel((Object[][]) null, new String[]{"Id", "Actividad", "FSolicitud", "Fecha Cierre", "NDias"}) { // from class: Sgc.JIFConsolidadoSolicitud.4
            Class[] types = {Long.class, String.class, String.class, String.class, Long.class};
            boolean[] canEdit = {false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return this.canEdit[colIndex];
            }
        };
        this.JTSDetallada.setModel(this.xmodelo1);
        this.JTSDetallada.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTSDetallada.getColumnModel().getColumn(1).setPreferredWidth(400);
        this.JTSDetallada.getColumnModel().getColumn(2).setPreferredWidth(20);
        this.JTSDetallada.getColumnModel().getColumn(3).setPreferredWidth(20);
        this.JTSDetallada.getColumnModel().getColumn(4).setPreferredWidth(20);
    }

    private void mCargarDatosTablaC() {
        mCrearTablaC();
        this.xsql = "SELECT s_solicitud_tipo.Id , s_solicitud_tipo.Nbre , COUNT(IF(s_solicitud_tipo_actividad.Id=1,s_solicitud_detalle.Descripcion, s_solicitud_tipo_actividad.Nbre)) AS NDescripcion , s_solicitud_tipo.AplicaE FROM s_solicitud_detalle INNER JOIN s_solicitud  ON (s_solicitud_detalle.Id_Solicitud = s_solicitud.Id) INNER JOIN s_solicitud_tipo_tipoproceso  ON (s_solicitud_detalle.Id_Tipo_S = s_solicitud_tipo_tipoproceso.Id) INNER JOIN s_solicitud_tipo  ON (s_solicitud_tipo_tipoproceso.Id_TipoSolicitud = s_solicitud_tipo.Id) INNER JOIN s_solicitud_tipo_actividad  ON (s_solicitud_detalle.Id_Actividad = s_solicitud_tipo_actividad.Id) WHERE (s_solicitud.Estado =1 AND s_solicitud.FechaS >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND s_solicitud.FechaS <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' AND s_solicitud.EstadoCierre ='" + this.xcerrarda + "' AND s_solicitud_detalle.Aprobada ='" + this.xaprobadas + "' AND s_solicitud_tipo_tipoproceso.Id_TipoProceso =5) GROUP BY s_solicitud_tipo.Nbre ORDER BY s_solicitud_tipo.Nbre ASC, NDescripcion ASC ";
        ResultSet rs = this.xct.traerRs(this.xsql);
        try {
            if (rs.next()) {
                rs.beforeFirst();
                int x = 0;
                while (rs.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(Long.valueOf(rs.getLong(1)), x, 0);
                    this.xmodelo.setValueAt(rs.getString(2), x, 1);
                    this.xmodelo.setValueAt(Long.valueOf(rs.getLong(3)), x, 2);
                    this.xmodelo.setValueAt(Boolean.valueOf(rs.getBoolean(4)), x, 3);
                    x++;
                }
            }
            rs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            this.xct.mostrarErrorSQL(ex);
        }
    }

    private void mCargarDatosTablaD() {
        mCrearTablaD();
        this.xsql = "SELECT s_solicitud_detalle.Id, IF(s_solicitud_detalle.Id_Actividad=1, s_solicitud_detalle.Descripcion, s_solicitud_tipo_actividad.Nbre) AS NDActividad , DATE_FORMAT(s_solicitud.FechaS,'%d-%m-%Y') AS FSOlicitud , DATE_FORMAT(s_solicitud_detalle.FechaCierre,'%d-%m-%Y') AS FCierre ,  DATEDIFF(s_solicitud_detalle.FechaCierre,s_solicitud.FechaS) AS NDias FROM s_solicitud_detalle INNER JOIN s_solicitud ON (s_solicitud_detalle.Id_Solicitud = s_solicitud.Id) INNER JOIN s_solicitud_tipo_tipoproceso  ON (s_solicitud_detalle.Id_Tipo_S = s_solicitud_tipo_tipoproceso.Id) INNER JOIN s_solicitud_tipo  ON (s_solicitud_tipo_tipoproceso.Id_TipoSolicitud = s_solicitud_tipo.Id) INNER JOIN s_solicitud_tipo_actividad  ON (s_solicitud_detalle.Id_Actividad = s_solicitud_tipo_actividad.Id) WHERE (s_solicitud.Estado =1  AND s_solicitud.FechaS >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND s_solicitud.FechaS <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' AND s_solicitud_detalle.Aprobada =1 AND s_solicitud_detalle.Cerrada =1) ORDER BY s_solicitud_tipo.Nbre ASC  ";
        ResultSet rs = this.xct.traerRs(this.xsql);
        try {
            if (rs.next()) {
                rs.beforeFirst();
                int x = 0;
                while (rs.next()) {
                    this.xmodelo1.addRow(this.xdato);
                    this.xmodelo1.setValueAt(Long.valueOf(rs.getLong(1)), x, 0);
                    this.xmodelo1.setValueAt(rs.getString(2), x, 1);
                    this.xmodelo1.setValueAt(rs.getString(3), x, 2);
                    this.xmodelo1.setValueAt(rs.getString(4), x, 3);
                    this.xmodelo1.setValueAt(Long.valueOf(rs.getLong(5)), x, 4);
                    x++;
                }
            }
            rs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            this.xct.mostrarErrorSQL(ex);
        }
    }
}
