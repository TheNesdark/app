package ImagenesDx;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:ImagenesDx/JIFSeguimientoOrdenes.class */
public class JIFSeguimientoOrdenes extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private Object[] xdato;
    private ButtonGroup JBGCumple;
    private JDateChooser JDFFecha;
    private JPanel JPIDCumple;
    private JPanel JPIDatos;
    private JPanel JPIDatosC;
    private JRadioButton JRBNo;
    private JRadioButton JRBSi;
    private JScrollPane JSPDDescripcion;
    private JScrollPane JSPDetalle;
    private JScrollPane JSPDseguimiento;
    private JTextPane JTADDescripcion;
    private JTextPane JTADSeguimiento;
    private JTable JTDetalle;
    private Metodos xmetodos = new Metodos();
    private ConsultasMySQL xconsultas = new ConsultasMySQL();
    private int xcumple = 0;
    private boolean xestado = false;

    public JIFSeguimientoOrdenes() {
        initComponents();
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v51, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGCumple = new ButtonGroup();
        this.JPIDatos = new JPanel();
        this.JDFFecha = new JDateChooser();
        this.JSPDseguimiento = new JScrollPane();
        this.JTADSeguimiento = new JTextPane();
        this.JPIDatosC = new JPanel();
        this.JSPDDescripcion = new JScrollPane();
        this.JTADDescripcion = new JTextPane();
        this.JPIDCumple = new JPanel();
        this.JRBSi = new JRadioButton();
        this.JRBNo = new JRadioButton();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("REGISTRO");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifseguimientoordenes");
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "DATO DE SEGUIMIENTO", 0, 0, new Font("Arial", 1, 14), new Color(0, 102, 51)));
        this.JDFFecha.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFecha.setDateFormatString("dd/MM/yyyy");
        this.JDFFecha.setFont(new Font("Arial", 1, 12));
        this.JSPDseguimiento.setBorder(BorderFactory.createTitledBorder((Border) null, "Descripción", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTADSeguimiento.setFont(new Font("Arial", 1, 12));
        this.JSPDseguimiento.setViewportView(this.JTADSeguimiento);
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addComponent(this.JDFFecha, -2, 121, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDseguimiento, -1, 398, 32767).addContainerGap()));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JSPDseguimiento, GroupLayout.Alignment.LEADING).addComponent(this.JDFFecha, GroupLayout.Alignment.LEADING, -1, -1, 32767)).addContainerGap(-1, 32767)));
        this.JPIDatosC.setBorder(BorderFactory.createTitledBorder((Border) null, "VERIFICACIÓN DE INFORMACIÓN DE ORDEN", 0, 0, new Font("Arial", 1, 14), new Color(0, 102, 51)));
        this.JSPDDescripcion.setBorder(BorderFactory.createTitledBorder((Border) null, "Descripción", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTADDescripcion.setFont(new Font("Arial", 1, 12));
        this.JSPDDescripcion.setViewportView(this.JTADDescripcion);
        this.JPIDCumple.setBorder(BorderFactory.createTitledBorder((Border) null, "Cumple?", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JBGCumple.add(this.JRBSi);
        this.JRBSi.setFont(new Font("Arial", 1, 12));
        this.JRBSi.setText("Si");
        this.JRBSi.addActionListener(new ActionListener() { // from class: ImagenesDx.JIFSeguimientoOrdenes.1
            public void actionPerformed(ActionEvent evt) {
                JIFSeguimientoOrdenes.this.JRBSiActionPerformed(evt);
            }
        });
        this.JBGCumple.add(this.JRBNo);
        this.JRBNo.setFont(new Font("Arial", 1, 12));
        this.JRBNo.setSelected(true);
        this.JRBNo.setText("No");
        this.JRBNo.addActionListener(new ActionListener() { // from class: ImagenesDx.JIFSeguimientoOrdenes.2
            public void actionPerformed(ActionEvent evt) {
                JIFSeguimientoOrdenes.this.JRBNoActionPerformed(evt);
            }
        });
        GroupLayout JPIDCumpleLayout = new GroupLayout(this.JPIDCumple);
        this.JPIDCumple.setLayout(JPIDCumpleLayout);
        JPIDCumpleLayout.setHorizontalGroup(JPIDCumpleLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDCumpleLayout.createSequentialGroup().addContainerGap().addComponent(this.JRBSi).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 13, 32767).addComponent(this.JRBNo).addContainerGap()));
        JPIDCumpleLayout.setVerticalGroup(JPIDCumpleLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDCumpleLayout.createSequentialGroup().addGroup(JPIDCumpleLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBSi).addComponent(this.JRBNo)).addContainerGap(-1, 32767)));
        GroupLayout JPIDatosCLayout = new GroupLayout(this.JPIDatosC);
        this.JPIDatosC.setLayout(JPIDatosCLayout);
        JPIDatosCLayout.setHorizontalGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosCLayout.createSequentialGroup().addContainerGap().addComponent(this.JPIDCumple, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPDDescripcion, -1, 396, 32767).addContainerGap()));
        JPIDatosCLayout.setVerticalGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosCLayout.createSequentialGroup().addGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JSPDDescripcion, GroupLayout.Alignment.LEADING).addComponent(this.JPIDCumple, GroupLayout.Alignment.LEADING, -1, -1, 32767)).addContainerGap(-1, 32767)));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JSPDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setBorder(BorderFactory.createBevelBorder(0));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setForeground(new Color(0, 0, 204));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalle.setEditingColumn(1);
        this.JTDetalle.setEditingRow(1);
        this.JTDetalle.setGridColor(new Color(204, 255, 204));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalle.setSelectionMode(0);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: ImagenesDx.JIFSeguimientoOrdenes.3
            public void mouseClicked(MouseEvent evt) {
                JIFSeguimientoOrdenes.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JSPDetalle, -1, 566, 32767).addGroup(GroupLayout.Alignment.LEADING, layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JPIDatosC, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.JPIDatos, GroupLayout.Alignment.LEADING, -1, -1, 32767))).addContainerGap(15, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addGap(18, 18, 18).addComponent(this.JPIDatosC, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalle, -1, 265, 32767).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBSiActionPerformed(ActionEvent evt) {
        this.xcumple = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBNoActionPerformed(ActionEvent evt) {
        this.xcumple = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            this.JDFFecha.setDate(this.xmetodos.getPasarTextoAFecha(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString()));
            this.JTADSeguimiento.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString());
            if (Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString()).booleanValue()) {
                this.xcumple = 1;
                this.JRBSi.setSelected(true);
            } else {
                this.xcumple = 0;
                this.JRBNo.setSelected(true);
            }
            this.JTADDescripcion.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 4).toString());
        }
    }

    public void mNuevo() {
        this.JDFFecha.setDate(this.xmetodos.getFechaActual());
        this.JTADSeguimiento.setText("");
        this.JTADDescripcion.setText("");
        this.JRBNo.setSelected(true);
        this.xcumple = 0;
        this.xestado = false;
        mCargarDatos();
    }

    private void mCrearTabla() {
        this.xmodelo = new DefaultTableModel((Object[][]) null, new String[]{"Id", "Fecha", "Seguimiento", "Cumple?", "Observación", "Estado"}) { // from class: ImagenesDx.JIFSeguimientoOrdenes.4
            Class[] types = {Long.class, String.class, String.class, Boolean.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return this.canEdit[colIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(10);
    }

    private void mCargarDatos() {
        String sql = "SELECT Id, Date_Format(FechaS,'%d-%m-%Y') as FechaS, DescripcionS, OrdenC, ObservacionC, Estado FROM h_seguimiento_imagenesdx WHERE (Id_OrdenH ='" + Principal.txtNo.getText() + "') ORDER BY FechaS DESC ";
        mCrearTabla();
        ResultSet rs = this.xconsultas.traerRs(sql);
        try {
            if (rs.next()) {
                rs.beforeFirst();
                int x = 0;
                while (rs.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(Long.valueOf(rs.getLong(1)), x, 0);
                    this.xmodelo.setValueAt(rs.getString(2), x, 1);
                    this.xmodelo.setValueAt(rs.getString(3), x, 2);
                    this.xmodelo.setValueAt(Boolean.valueOf(rs.getBoolean(4)), x, 3);
                    this.xmodelo.setValueAt(rs.getString(5), x, 4);
                    this.xmodelo.setValueAt(Boolean.valueOf(rs.getBoolean(6)), x, 5);
                    x++;
                }
            }
            rs.close();
            this.xconsultas.cerrarConexionBd();
        } catch (SQLException ex) {
            this.xconsultas.mostrarErrorSQL(ex);
        }
    }

    public void mGrabar() {
        if (!this.xestado) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                String sql = "insert into h_seguimiento_imagenesdx(Id_OrdenH, FechaS, DescripcionS, OrdenC, ObservacionC, Estado, Fecha, UsuarioS) values ('" + Principal.txtNo.getText() + "','" + this.xmetodos.formatoAMD.format(this.JDFFecha.getDate()) + "','" + this.JTADSeguimiento.getText() + "','" + this.xcumple + "','" + this.JTADDescripcion.getText() + "','1','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                this.xconsultas.ejecutarSQL(sql);
                this.xconsultas.cerrarConexionBd();
                mCargarDatos();
                this.xestado = true;
            }
        }
    }
}
