package Informes;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Informes/JIFRActividades.class */
public class JIFRActividades extends JInternalFrame {
    private Object[] dato;
    private DefaultTableModel xmodelodatos;
    private boolean xestadof = false;
    private boolean xestadoact = false;
    private int xestado = 1;
    private ConsultasMySQL xconsulta = new ConsultasMySQL();
    private Metodos xmetodo = new Metodos();
    private JCheckBox JCBEstado;
    private JScrollPane JSPDetalle;
    private JTable JTBDetalle;
    private JTextField JTFNombreActividad;
    private JPanel jPanel1;
    private JSeparator jSeparator1;
    private JLabel txtTitulo;

    public JIFRActividades() {
        initComponents();
        mCrearTabla();
        mCargarDatosTabla();
    }

    /* JADX WARN: Type inference failed for: r3v8, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jPanel1 = new JPanel();
        this.txtTitulo = new JLabel();
        this.jSeparator1 = new JSeparator();
        this.JSPDetalle = new JScrollPane();
        this.JTBDetalle = new JTable();
        this.JTFNombreActividad = new JTextField();
        this.JCBEstado = new JCheckBox();
        setClosable(true);
        setIconifiable(true);
        setTitle("ACTIVIDADES EDUCATIVAS");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifractividadespyp");
        this.jPanel1.setBorder(BorderFactory.createEtchedBorder());
        this.jPanel1.setName("jpactividades");
        this.txtTitulo.setBackground((Color) null);
        this.txtTitulo.setFont(new Font("Arial", 1, 14));
        this.txtTitulo.setForeground(new Color(0, 102, 0));
        this.txtTitulo.setHorizontalAlignment(0);
        this.txtTitulo.setText("ACTIVIDADES EDUCATIVAS");
        this.txtTitulo.setBorder(BorderFactory.createEtchedBorder());
        this.txtTitulo.setOpaque(true);
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTBDetalle.setFont(new Font("Arial", 1, 12));
        this.JTBDetalle.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTBDetalle.setRowHeight(25);
        this.JTBDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTBDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTBDetalle.setSelectionMode(0);
        this.JTBDetalle.addMouseListener(new MouseAdapter() { // from class: Informes.JIFRActividades.1
            public void mouseClicked(MouseEvent evt) {
                JIFRActividades.this.JTBDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTBDetalle);
        this.JTFNombreActividad.setFont(new Font("Arial", 1, 12));
        this.JTFNombreActividad.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBEstado.setFont(new Font("Arial", 1, 12));
        this.JCBEstado.setSelected(true);
        this.JCBEstado.setText("Estado");
        this.JCBEstado.addActionListener(new ActionListener() { // from class: Informes.JIFRActividades.2
            public void actionPerformed(ActionEvent evt) {
                JIFRActividades.this.JCBEstadoActionPerformed(evt);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JSPDetalle, GroupLayout.Alignment.LEADING, -1, 894, 32767).addComponent(this.txtTitulo, GroupLayout.Alignment.LEADING, -1, 894, 32767).addComponent(this.jSeparator1, -1, 894, 32767).addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup().addComponent(this.JTFNombreActividad, -2, 744, -2).addGap(18, 18, 18).addComponent(this.JCBEstado, -1, 132, 32767))).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.txtTitulo, -2, 32, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jSeparator1, -2, 10, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFNombreActividad, -2, 61, -2).addComponent(this.JCBEstado)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPDetalle, -2, 510, -2).addGap(24, 24, 24)));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 918, 32767).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.jPanel1, -2, -1, -2).addGap(0, 0, 32767))));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 679, 32767).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(0, 2, 32767).addComponent(this.jPanel1, -2, -1, -2).addGap(0, 2, 32767))));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBDetalleMouseClicked(MouseEvent evt) {
        if (this.JTBDetalle.getSelectedRow() != -1) {
            this.JTFNombreActividad.setText(this.JTBDetalle.getValueAt(this.JTBDetalle.getSelectedRow(), 1).toString());
            if (this.JTBDetalle.getValueAt(this.JTBDetalle.getSelectedRow(), 2).toString().equals("true")) {
                this.JCBEstado.setSelected(true);
            } else {
                this.JCBEstado.setSelected(false);
            }
            this.xestadoact = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBEstadoActionPerformed(ActionEvent evt) {
        if (this.JCBEstado.isSelected()) {
            this.xestado = 1;
        } else {
            this.xestado = 0;
        }
    }

    private void mCrearTabla() {
        this.xmodelodatos = new DefaultTableModel((Object[][]) null, new String[]{"Id", "Actividad", "Estado"}) { // from class: Informes.JIFRActividades.3
            Class[] types = {Integer.class, String.class, Boolean.class};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        this.JTBDetalle.setModel(this.xmodelodatos);
        this.JTBDetalle.getColumnModel().getColumn(0).setPreferredWidth(30);
        this.JTBDetalle.getColumnModel().getColumn(0).setMinWidth(30);
        this.JTBDetalle.getColumnModel().getColumn(0).setMaxWidth(30);
        this.JTBDetalle.getColumnModel().getColumn(1).setPreferredWidth(750);
        this.JTBDetalle.getColumnModel().getColumn(1).setMinWidth(750);
        this.JTBDetalle.getColumnModel().getColumn(1).setMaxWidth(750);
        this.JTBDetalle.getColumnModel().getColumn(2).setPreferredWidth(50);
        this.JTBDetalle.getColumnModel().getColumn(2).setMinWidth(50);
        this.JTBDetalle.getColumnModel().getColumn(2).setMaxWidth(50);
    }

    private void mCargarDatosTabla() {
        try {
            ResultSet rs = this.xconsulta.traerRs("SELECT Id, Nbre, Estado FROM baseserver.p_actividades ORDER BY Nbre ASC ");
            rs.next();
            if (rs.getRow() != 0) {
                rs.beforeFirst();
                int i = 0;
                while (rs.next()) {
                    this.xmodelodatos.addRow(this.dato);
                    this.xmodelodatos.setValueAt(Long.valueOf(rs.getLong(1)), i, 0);
                    this.xmodelodatos.setValueAt(rs.getString(2), i, 1);
                    this.xmodelodatos.setValueAt(Boolean.valueOf(rs.getBoolean(3)), i, 2);
                    i++;
                }
            }
            rs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFRActividades.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void grabar() {
        if (!this.JTFNombreActividad.getText().isEmpty()) {
            if (!this.xestadof) {
                int n = JOptionPane.showConfirmDialog(this, "Esta seguro de grabar", "CONFIRMAR", 2);
                if (n == 0) {
                    if (!this.xestadoact) {
                        String sql = "insert into baseserver.p_actividades (Nbre, Estado, Fecha, UsuarioS) values('" + this.JTFNombreActividad.getText().toUpperCase() + "','" + this.xestado + "','" + this.xmetodo.formatoAMDH24.format(this.xmetodo.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                        this.xconsulta.ejecutarSQL(sql);
                        this.xconsulta.cerrarConexionBd();
                        mCrearTabla();
                        mCargarDatosTabla();
                        this.xestadof = true;
                        nuevo();
                        return;
                    }
                    if (this.JTBDetalle.getSelectedRow() != -1) {
                        String sql2 = "update  baseserver.p_actividades set Nbre='" + this.JTFNombreActividad.getText().toUpperCase() + "', Fecha='" + this.xmetodo.formatoAMDH24.format(this.xmetodo.getFechaActual()) + "', Estado='" + this.xestado + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' where id='" + this.xmodelodatos.getValueAt(this.JTBDetalle.getSelectedRow(), 0) + "'";
                        this.xconsulta.ejecutarSQL(sql2);
                        this.xconsulta.cerrarConexionBd();
                        mCrearTabla();
                        mCargarDatosTabla();
                        this.xestadof = true;
                        nuevo();
                        return;
                    }
                    JOptionPane.showMessageDialog(this, "Debe seleccionar el registro a modificar", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                    return;
                }
                return;
            }
            return;
        }
        JOptionPane.showMessageDialog(this, "El campo nombre no puede ser nulo", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
        this.JTFNombreActividad.requestFocus();
    }

    public void nuevo() {
        this.JTFNombreActividad.setText((String) null);
        this.xestadof = false;
        this.xestadoact = false;
        this.xestado = 0;
        this.JTFNombreActividad.requestFocus();
    }
}
