package AutorizacionMP;

import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultCellEditor;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/* JADX INFO: loaded from: GenomaP.jar:AutorizacionMP/JIFVerificarEstado.class */
public class JIFVerificarEstado extends JInternalFrame {
    public DefaultTableModel xmodelo;
    private Object[] xdato;
    private int xestado = 0;
    private boolean xgrabado = false;
    private ButtonGroup JBGSeleccion;
    public JDateChooser JDCFechaFin;
    public JDateChooser JDCFechaInicio;
    private JPanel JPIDatoP;
    private JRadioButton JRBSinArmar;
    private JScrollPane JSPResultado;
    private JTable JTBResultado;

    public JIFVerificarEstado() {
        initComponents();
        nuevo();
    }

    /* JADX WARN: Type inference failed for: r3v28, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGSeleccion = new ButtonGroup();
        this.JPIDatoP = new JPanel();
        this.JDCFechaInicio = new JDateChooser();
        this.JDCFechaFin = new JDateChooser();
        this.JRBSinArmar = new JRadioButton();
        this.JSPResultado = new JScrollPane();
        this.JTBResultado = new JTable();
        setClosable(true);
        setTitle("CONSULTAR DESCUENTOS");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifverificacion");
        this.JPIDatoP.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JDCFechaInicio.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicio", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFechaInicio.setDateFormatString("dd/MM/yyyy");
        this.JDCFechaInicio.setFont(new Font("Arial", 1, 12));
        this.JDCFechaFin.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Fin", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFechaFin.setDateFormatString("dd/MM/yyyy");
        this.JDCFechaFin.setFont(new Font("Arial", 1, 12));
        this.JRBSinArmar.setFont(new Font("Arial", 1, 12));
        this.JRBSinArmar.setText("Con Soporte?");
        this.JRBSinArmar.addActionListener(new ActionListener() { // from class: AutorizacionMP.JIFVerificarEstado.1
            public void actionPerformed(ActionEvent evt) {
                JIFVerificarEstado.this.JRBSinArmarActionPerformed(evt);
            }
        });
        GroupLayout JPIDatoPLayout = new GroupLayout(this.JPIDatoP);
        this.JPIDatoP.setLayout(JPIDatoPLayout);
        JPIDatoPLayout.setHorizontalGroup(JPIDatoPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatoPLayout.createSequentialGroup().addContainerGap().addComponent(this.JDCFechaInicio, -2, 171, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JDCFechaFin, -2, 170, -2).addGap(68, 68, 68).addComponent(this.JRBSinArmar).addContainerGap(336, 32767)));
        JPIDatoPLayout.setVerticalGroup(JPIDatoPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatoPLayout.createSequentialGroup().addGroup(JPIDatoPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatoPLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JDCFechaInicio, -2, 61, -2).addComponent(this.JDCFechaFin, -2, 61, -2)).addGroup(JPIDatoPLayout.createSequentialGroup().addGap(21, 21, 21).addComponent(this.JRBSinArmar))).addContainerGap(-1, 32767)));
        this.JSPResultado.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JSPResultado.setFont(new Font("Arial", 1, 12));
        this.JTBResultado.setFont(new Font("Arial", 1, 12));
        this.JTBResultado.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTBResultado.setEditingColumn(1);
        this.JTBResultado.setEditingRow(1);
        this.JTBResultado.setRowHeight(25);
        this.JTBResultado.setSelectionBackground(new Color(255, 255, 255));
        this.JTBResultado.setSelectionForeground(new Color(255, 0, 0));
        this.JTBResultado.setSelectionMode(0);
        this.JSPResultado.setViewportView(this.JTBResultado);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPResultado, GroupLayout.Alignment.TRAILING, -1, 880, 32767).addComponent(this.JPIDatoP, GroupLayout.Alignment.TRAILING, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatoP, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPResultado, -2, 276, -2).addContainerGap(15, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBSinArmarActionPerformed(ActionEvent evt) {
        if (this.JRBSinArmar.isSelected()) {
            this.xestado = 1;
        } else {
            this.xestado = 0;
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTablaDetalleProc() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Fecha", "N° Descuento", "Usuario", "NQuincena", "Valor", "Verificado"}) { // from class: AutorizacionMP.JIFVerificarEstado.2
            Class[] types = {String.class, String.class, String.class, Integer.class, Long.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTBResultado.setModel(this.xmodelo);
        this.JTBResultado.getColumnModel().getColumn(0).setPreferredWidth(20);
        this.JTBResultado.getColumnModel().getColumn(1).setPreferredWidth(20);
        this.JTBResultado.getColumnModel().getColumn(2).setPreferredWidth(200);
        this.JTBResultado.getColumnModel().getColumn(3).setPreferredWidth(10);
        this.JTBResultado.getColumnModel().getColumn(4).setPreferredWidth(30);
        this.JTBResultado.getColumnModel().getColumn(5).setPreferredWidth(10);
        TableColumn sportColumn = this.JTBResultado.getColumnModel().getColumn(5);
        JCheckBox jch = new JCheckBox();
        sportColumn.setCellEditor(new DefaultCellEditor(jch));
    }

    private void mCargarDatos() {
        Metodos xmt1 = new Metodos();
        String sql = "SELECT h_atencion.Fecha_Atencion, d_descuento.Id, persona.NUsuario, d_descuento.NQuincenas, d_descuento.Valor, d_descuento.Verificado FROM baseserver.d_descuento INNER JOIN baseserver.h_atencion ON (d_descuento.Id_HAtencion = h_atencion.Id) INNER JOIN baseserver.ingreso ON (h_atencion.Id_Ingreso = ingreso.Id) INNER JOIN baseserver.persona ON (ingreso.Id_Usuario = persona.Id_persona) WHERE (d_descuento.Valor <>0 AND d_descuento.Verificado ='" + this.xestado + "' AND d_descuento.Estado =0 AND h_atencion.Fecha_Atencion >='" + xmt1.formatoAMD.format(this.JDCFechaInicio.getDate()) + "' AND h_atencion.Fecha_Atencion <='" + xmt1.formatoAMD.format(this.JDCFechaFin.getDate()) + "') ORDER BY h_atencion.Fecha_Atencion ASC, d_descuento.Id ASC";
        ConsultasMySQL xmt = new ConsultasMySQL();
        ResultSet rs = xmt.traerRs(sql);
        try {
            if (rs.next()) {
                rs.beforeFirst();
                int x = 0;
                while (rs.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(rs.getString(1), x, 0);
                    this.xmodelo.setValueAt(rs.getString(2), x, 1);
                    this.xmodelo.setValueAt(rs.getString(3), x, 2);
                    this.xmodelo.setValueAt(rs.getString(4), x, 3);
                    this.xmodelo.setValueAt(rs.getString(5), x, 4);
                    if (this.xestado == 0) {
                        this.xmodelo.setValueAt(false, x, 5);
                    } else {
                        this.xmodelo.setValueAt(true, x, 5);
                    }
                    x++;
                }
            }
            rs.close();
            xmt.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFVerificarEstado.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void buscar() {
        mCrearTablaDetalleProc();
        mCargarDatos();
        this.xgrabado = false;
    }

    public void nuevo() {
        Metodos xmt1 = new Metodos();
        this.JDCFechaInicio.setDate(xmt1.getFechaActual());
        this.JDCFechaFin.setDate(xmt1.getFechaActual());
        mCrearTablaDetalleProc();
        this.JDCFechaInicio.requestFocus();
        this.xgrabado = false;
    }

    public void grabar() {
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de guardar", "CONFIRMAR", 2, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            if (!this.xgrabado && mVerificarDatosTablaTrue() && this.JTBResultado.getRowCount() > 1) {
                ConsultasMySQL xmt = new ConsultasMySQL();
                for (int i = 0; i < this.JTBResultado.getRowCount() - 1; i++) {
                    if (this.JTBResultado.getValueAt(i, 5).toString().equals("true")) {
                        String sql = "Update d_descuento set Verificado=1 where Id='" + this.JTBResultado.getValueAt(i, 1) + "'";
                        xmt.ejecutarSQL(sql);
                        xmt.cerrarConexionBd();
                    }
                }
                mCrearTablaDetalleProc();
                mCargarDatos();
                this.xgrabado = true;
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "No existe orden seleccionada", "VERIFICAR", 0);
            this.JTBResultado.requestFocus();
        }
    }

    private boolean mVerificarDatosTablaTrue() {
        boolean estado = false;
        if (this.JTBResultado.getRowCount() > 1) {
            int i = 0;
            while (true) {
                if (i >= this.JTBResultado.getRowCount() - 1) {
                    break;
                }
                if (!this.JTBResultado.getValueAt(i, 5).toString().equals("true")) {
                    i++;
                } else {
                    estado = true;
                    break;
                }
            }
        }
        return estado;
    }
}
