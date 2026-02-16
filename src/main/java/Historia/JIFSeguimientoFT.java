package Historia;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.beans.PropertyVetoException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DateFormatter;
import javax.swing.text.DefaultFormatterFactory;

/* JADX INFO: loaded from: GenomaP.jar:Historia/JIFSeguimientoFT.class */
public class JIFSeguimientoFT extends JInternalFrame {
    private ConsultasMySQL xconsulta = new ConsultasMySQL();
    private Metodos xmetodo = new Metodos();
    private DefaultTableModel xmodelo;
    private Object[] dato;
    private String xsql;
    public JDateChooser JDCFecha;
    private JPanel JPDatosSeguimiento;
    private JScrollPane JSPDetalle;
    private JScrollPane JSPHistoriaS;
    private JFormattedTextField JTFFHora;
    private JTextField JTFNOrden;
    private JTable JTHistorialS;
    private JTextPane JTPDetalle;

    public JIFSeguimientoFT() {
        initComponents();
        this.JDCFecha.setDate(this.xmetodo.getFechaActual());
        this.JTFFHora.setValue(this.xmetodo.getFechaActual());
        this.JDCFecha.requestFocus();
        mCrearTabla();
        mCargarDatosTabla();
    }

    /* JADX WARN: Type inference failed for: r3v26, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPDatosSeguimiento = new JPanel();
        this.JDCFecha = new JDateChooser();
        this.JSPDetalle = new JScrollPane();
        this.JTPDetalle = new JTextPane();
        this.JTFFHora = new JFormattedTextField();
        this.JSPHistoriaS = new JScrollPane();
        this.JTHistorialS = new JTable();
        this.JTFNOrden = new JTextField();
        setClosable(true);
        setTitle("FISIOTERAPIA");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifseguimientoft");
        try {
            setSelected(true);
        } catch (PropertyVetoException e1) {
            e1.printStackTrace();
        }
        this.JPDatosSeguimiento.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JDCFecha.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFecha.setDateFormatString("dd/MM/yyyy");
        this.JDCFecha.setFont(new Font("Arial", 1, 12));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "Descripción", 0, 0, new Font("Arial", 1, 13), Color.blue));
        this.JTPDetalle.setFont(new Font("Arial", 1, 12));
        this.JSPDetalle.setViewportView(this.JTPDetalle);
        this.JTFFHora.setBorder(BorderFactory.createTitledBorder((Border) null, "Hora", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFHora.setFormatterFactory(new DefaultFormatterFactory(new DateFormatter(new SimpleDateFormat("hh:mm a"))));
        this.JTFFHora.setFont(new Font("Arial", 1, 12));
        GroupLayout JPDatosSeguimientoLayout = new GroupLayout(this.JPDatosSeguimiento);
        this.JPDatosSeguimiento.setLayout(JPDatosSeguimientoLayout);
        JPDatosSeguimientoLayout.setHorizontalGroup(JPDatosSeguimientoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosSeguimientoLayout.createSequentialGroup().addContainerGap().addGroup(JPDatosSeguimientoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPDetalle, -2, 803, -2).addGroup(JPDatosSeguimientoLayout.createSequentialGroup().addComponent(this.JDCFecha, -2, 131, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFHora, -2, 131, -2))).addContainerGap(16, 32767)));
        JPDatosSeguimientoLayout.setVerticalGroup(JPDatosSeguimientoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosSeguimientoLayout.createSequentialGroup().addGroup(JPDatosSeguimientoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosSeguimientoLayout.createSequentialGroup().addContainerGap().addComponent(this.JTFFHora, -1, 50, 32767)).addComponent(this.JDCFecha, -1, -1, 32767)).addGap(18, 18, 18).addComponent(this.JSPDetalle, -2, 142, -2).addContainerGap()));
        this.JSPHistoriaS.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTHistorialS.setFont(new Font("Arial", 1, 12));
        this.JTHistorialS.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTHistorialS.setRowHeight(25);
        this.JTHistorialS.setSelectionBackground(new Color(255, 255, 255));
        this.JTHistorialS.setSelectionForeground(new Color(255, 0, 0));
        this.JTHistorialS.setSelectionMode(0);
        this.JTHistorialS.addMouseListener(new MouseAdapter() { // from class: Historia.JIFSeguimientoFT.1
            public void mouseClicked(MouseEvent evt) {
                JIFSeguimientoFT.this.JTHistorialSMouseClicked(evt);
            }
        });
        this.JTHistorialS.addMouseMotionListener(new MouseMotionAdapter() { // from class: Historia.JIFSeguimientoFT.2
            public void mouseMoved(MouseEvent evt) {
                JIFSeguimientoFT.this.JTHistorialSMouseMoved(evt);
            }
        });
        this.JSPHistoriaS.setViewportView(this.JTHistorialS);
        this.JTFNOrden.setEditable(false);
        this.JTFNOrden.setBackground(new Color(0, 0, 102));
        this.JTFNOrden.setFont(new Font("Arial", 1, 24));
        this.JTFNOrden.setForeground(new Color(255, 255, 255));
        this.JTFNOrden.setHorizontalAlignment(0);
        this.JTFNOrden.setBorder(BorderFactory.createTitledBorder((Border) null, "N°", 0, 0, new Font("Arial", 1, 14), new Color(255, 255, 255)));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JSPHistoriaS).addComponent(this.JTFNOrden, GroupLayout.Alignment.LEADING, -2, 144, -2).addComponent(this.JPDatosSeguimiento, -1, -1, 32767)).addContainerGap(-1, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPDatosSeguimiento, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPHistoriaS, -2, 157, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFNOrden, -2, 59, -2).addContainerGap(23, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTHistorialSMouseMoved(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTHistorialSMouseClicked(MouseEvent evt) {
        if (this.JTHistorialS.getSelectedRow() != -1) {
            this.JTFNOrden.setText(this.xmodelo.getValueAt(this.JTHistorialS.getSelectedRow(), 0).toString());
            this.JTPDetalle.setText(this.xmodelo.getValueAt(this.JTHistorialS.getSelectedRow(), 2).toString());
        }
    }

    public void nuevo() {
        this.JDCFecha.setDate(this.xmetodo.getFechaActual());
        this.JTPDetalle.setText((String) null);
        this.JDCFecha.requestFocus();
        this.JTFNOrden.setText((String) null);
    }

    public void grabar() {
        if (Principal.txtEstado.getText().equals("ACTIVA")) {
            if (this.JTFNOrden.getText().isEmpty()) {
                if (!this.JTPDetalle.getText().isEmpty()) {
                    int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    if (x == 0) {
                        String sql = "Insert into h_seguimientof (Id_AtencionF, FechaS, Hora, Detalle, Id_Profesional, Id_Especialidad, UsuarioS, Fecha) values ('" + Principal.txtNo.getText() + "','" + this.xmetodo.formatoAMD.format(this.JDCFecha.getDate()) + "','" + this.xmetodo.formatoH24.format(this.JTFFHora.getValue()) + "','" + this.JTPDetalle.getText() + "','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "','1','" + Principal.usuarioSistemaDTO.getLogin() + "','" + this.xmetodo.formatoAMDH24.format(this.xmetodo.getFechaActual()) + "')";
                        this.JTFNOrden.setText(this.xconsulta.ejecutarSQLId(sql));
                        this.xconsulta.cerrarConexionBd();
                        mCrearTabla();
                        mCargarDatosTabla();
                        String sql2 = "UPDATE c_citas SET Asistida = 3 WHERE Id ='" + Principal.clasescita.getXidcita() + "'";
                        this.xconsulta.ejecutarSQL(sql2);
                        this.xconsulta.cerrarConexionBd();
                        return;
                    }
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "La descripción no puede estar en blanco", "VERIFICAR", 0);
                this.JTPDetalle.requestFocus();
                return;
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Historia cerrada, No se pueden agregar seguimiento", "VERIFICAR", 0);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTabla() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Fecha", "Descripción", "Profesional"}) { // from class: Historia.JIFSeguimientoFT.3
            Class[] types = {Integer.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTHistorialS.setModel(this.xmodelo);
        this.JTHistorialS.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTHistorialS.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTHistorialS.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTHistorialS.getColumnModel().getColumn(1).setPreferredWidth(30);
        this.JTHistorialS.getColumnModel().getColumn(2).setPreferredWidth(500);
        this.JTHistorialS.getColumnModel().getColumn(3).setPreferredWidth(200);
    }

    private void mCargarDatosTabla() {
        try {
            this.xsql = "SELECT h_seguimientof.Id, h_seguimientof.FechaS, h_seguimientof.Detalle, profesional1.NProfesional  FROM profesional1 INNER JOIN h_seguimientof  ON (profesional1.Id_Persona = h_seguimientof.Id_Profesional) AND (profesional1.IdEspecialidad = h_seguimientof.Id_Especialidad)  WHERE (h_seguimientof.Id_AtencionF ='" + Principal.txtNo.getText() + "') ORDER BY h_seguimientof.FechaS DESC ";
            ResultSet rs = this.xconsulta.traerRs(this.xsql);
            if (rs.next()) {
                rs.beforeFirst();
                int i = 0;
                while (rs.next()) {
                    this.xmodelo.addRow(this.dato);
                    this.xmodelo.setValueAt(Long.valueOf(rs.getLong(1)), i, 0);
                    this.xmodelo.setValueAt(rs.getString(2), i, 1);
                    this.xmodelo.setValueAt(rs.getString(3), i, 2);
                    this.xmodelo.setValueAt(rs.getString(4), i, 3);
                    i++;
                }
            }
            rs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFSeguimientoFT.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }
}
