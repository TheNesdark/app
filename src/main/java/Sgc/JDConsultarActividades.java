package Sgc;

import Utilidades.ConsultasMySQL;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JDialog;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Sgc/JDConsultarActividades.class */
public class JDConsultarActividades extends JDialog {
    private DefaultTableModel xmodelo;
    private JIFSolicitudes xjifsol;
    private String xnombre;
    private JScrollPane JSPDetalle;
    private JTable JTResultado;

    public JDConsultarActividades(Frame parent, boolean modal, JInternalFrame xjif, String xtitulo) {
        super(parent, modal);
        this.xnombre = "";
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        setTitle(xtitulo.toUpperCase());
        mCastingInterno(xjif);
        mCargarDatos();
    }

    /* JADX WARN: Type inference failed for: r3v4, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JSPDetalle = new JScrollPane();
        this.JTResultado = new JTable();
        setDefaultCloseOperation(2);
        setTitle("Consultar Lotes x Producto");
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "Resultado", 2, 0, new Font("Arial", 1, 14), Color.blue));
        this.JSPDetalle.setFont(new Font("Arial", 1, 12));
        this.JTResultado.setFont(new Font("Arial", 1, 12));
        this.JTResultado.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTResultado.setRowHeight(25);
        this.JTResultado.setSelectionBackground(new Color(255, 255, 255));
        this.JTResultado.setSelectionForeground(new Color(255, 0, 0));
        this.JTResultado.setSelectionMode(0);
        this.JTResultado.addMouseListener(new MouseAdapter() { // from class: Sgc.JDConsultarActividades.1
            public void mouseClicked(MouseEvent evt) {
                JDConsultarActividades.this.JTResultadoMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTResultado);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JSPDetalle, -1, 380, 32767).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(22, 22, 22).addComponent(this.JSPDetalle, -2, 259, -2).addContainerGap(19, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTResultadoMouseClicked(MouseEvent evt) {
        if (this.JTResultado.getSelectedRow() != -1 && this.xnombre.equals("jifsolicitudes")) {
            this.xjifsol.setXidactividad(Long.valueOf(this.xmodelo.getValueAt(this.JTResultado.getSelectedRow(), 0).toString()).longValue());
            this.xjifsol.JTFNombreP.setText(this.xmodelo.getValueAt(this.JTResultado.getSelectedRow(), 1).toString());
            dispose();
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Actividad"}) { // from class: Sgc.JDConsultarActividades.2
            Class[] types = {Long.class, String.class};
            boolean[] canEdit = {false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTResultado.setModel(this.xmodelo);
        this.JTResultado.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTResultado.getColumnModel().getColumn(1).setPreferredWidth(150);
    }

    private void mCargarDatos() {
        ConsultasMySQL consultas = new ConsultasMySQL();
        mCrearModeloDatos();
        String xsql = null;
        if (this.xnombre.equals("jifsolicitudes")) {
            xsql = "SELECT s_solicitud_tipo_actividad.Id, s_solicitud_tipo_actividad.Nbre FROM s_solicitud_tactividad_tproceso INNER JOIN s_solicitud_tipo_actividad  ON (s_solicitud_tactividad_tproceso.Id_Tipo_Actividad = s_solicitud_tipo_actividad.Id) INNER JOIN s_solicitud_tipo_tipoproceso  ON (s_solicitud_tactividad_tproceso.Id_Tipo_Solicitud = s_solicitud_tipo_tipoproceso.Id) WHERE (s_solicitud_tactividad_tproceso.Id_Tipo_Solicitud ='" + this.xjifsol.xidtiposolicitud[this.xjifsol.JCBTipoSolicitud.getSelectedIndex()][0] + "' AND s_solicitud_tactividad_tproceso.Estado =1) ORDER BY s_solicitud_tipo_actividad.Nbre ASC ";
        }
        ResultSet rs = consultas.traerRs(xsql);
        try {
            if (rs.next()) {
                rs.beforeFirst();
                int n = 0;
                while (rs.next()) {
                    this.xmodelo.addRow((Object[]) null);
                    this.xmodelo.setValueAt(Long.valueOf(rs.getLong(1)), n, 0);
                    this.xmodelo.setValueAt(rs.getString(2), n, 1);
                    n++;
                }
            }
            rs.close();
            consultas.cerrarConexionBd();
        } catch (SQLException ex) {
            consultas.mostrarErrorSQL(ex);
        }
    }

    private void mCastingInterno(JInternalFrame frm) {
        if (frm.getName().equals("jifsolicitudes")) {
            this.xjifsol = (JIFSolicitudes) frm;
            this.xnombre = "jifsolicitudes";
        }
    }
}
