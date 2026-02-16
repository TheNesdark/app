package Parametrizacion;

import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyVetoException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Parametrizacion/JIFGenerico.class */
public class JIFGenerico extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private Object[] xdatos;
    private String xnombre;
    private String xid;
    private JCheckBox JCHEstado;
    private JPanel JPIDatos;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;
    private JTextField JTFNombre;
    private ConsultasMySQL xconsulta = new ConsultasMySQL();
    private Metodos xmetodos = new Metodos();
    private int xestado = 1;
    private boolean xestadog = false;

    public JIFGenerico(String xnombre) {
        initComponents();
        setTitle(xnombre);
        this.xnombre = xnombre;
        mCargarDatosTabla();
    }

    /* JADX WARN: Type inference failed for: r3v23, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPIDatos = new JPanel();
        this.JTFNombre = new JTextField();
        this.JCHEstado = new JCheckBox();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("MUNICIPIO");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("Generico");
        try {
            setSelected(true);
        } catch (PropertyVetoException e1) {
            e1.printStackTrace();
        }
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTFNombre.setFont(new Font("Arial", 1, 12));
        this.JTFNombre.setToolTipText("");
        this.JTFNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setSelected(true);
        this.JCHEstado.setText("Estado");
        this.JCHEstado.addActionListener(new ActionListener() { // from class: Parametrizacion.JIFGenerico.1
            public void actionPerformed(ActionEvent evt) {
                JIFGenerico.this.JCHEstadoActionPerformed(evt);
            }
        });
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosLayout.createSequentialGroup().addGap(11, 11, 11).addComponent(this.JTFNombre, -1, 429, 32767).addGap(18, 18, 18).addComponent(this.JCHEstado).addContainerGap()));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFNombre, -2, -1, -2).addComponent(this.JCHEstado)).addContainerGap(21, 32767)));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalle.setSelectionMode(0);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: Parametrizacion.JIFGenerico.2
            public void mouseClicked(MouseEvent evt) {
                JIFGenerico.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JSPDetalle, GroupLayout.Alignment.LEADING, -1, 545, 32767).addComponent(this.JPIDatos, GroupLayout.Alignment.LEADING, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPDetalle, -1, 313, 32767).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEstadoActionPerformed(ActionEvent evt) {
        if (this.JCHEstado.isSelected()) {
            this.xestado = 1;
        } else {
            this.xestado = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            this.xid = this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString();
            this.JTFNombre.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString());
            this.JCHEstado.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString()).booleanValue());
            this.xestadog = true;
        }
    }

    public void mNuevo() {
        this.JTFNombre.setText("");
        this.JCHEstado.setSelected(true);
        this.xestadog = false;
    }

    public void mGrabar() {
        if (!this.JTFNombre.getText().isEmpty()) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                String sql = null;
                if (this.xnombre.equals("Municipio")) {
                    if (!this.xestadog) {
                        sql = " Insert into tipo_municipio(Nbre, Estado, Fecha, UsuarioS)  values ('" + this.JTFNombre.getText().toUpperCase() + "','" + this.xestado + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','l')";
                    } else {
                        sql = " update tipo_municipio set Nbre='" + this.JTFNombre.getText().toUpperCase() + "',Estado='" + this.xestado + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='l' Where Id='" + this.xid + "'";
                    }
                } else if (this.xnombre.equals("Municipio")) {
                    if (!this.xestadog) {
                        sql = " Insert into tipo_documento(Nbre, Estado, Fecha, UsuarioS)  values ('" + this.JTFNombre.getText().toUpperCase() + "','" + this.xestado + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','l')";
                    } else {
                        sql = " update tipo_documento set Nbre='" + this.JTFNombre.getText().toUpperCase() + "',Estado='" + this.xestado + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='l' Where Id='" + this.xid + "'";
                    }
                } else if (this.xnombre.equals("Marca")) {
                    if (!this.xestadog) {
                        sql = " Insert into tipo_marca(Nbre, Estado, Fecha, UsuarioS)  values ('" + this.JTFNombre.getText().toUpperCase() + "','" + this.xestado + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','l')";
                    } else {
                        sql = " update tipo_marca set Nbre='" + this.JTFNombre.getText().toUpperCase() + "',Estado='" + this.xestado + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='l' Where Id='" + this.xid + "'";
                    }
                } else if (this.xnombre.equals("Tipo Producto")) {
                    if (!this.xestadog) {
                        sql = " Insert into tipo_producto(Nbre, Estado, Fecha, UsuarioS)  values ('" + this.JTFNombre.getText().toUpperCase() + "','" + this.xestado + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','l')";
                    } else {
                        sql = " update tipo_producto set Nbre='" + this.JTFNombre.getText().toUpperCase() + "',Estado='" + this.xestado + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='l' Where Id='" + this.xid + "'";
                    }
                } else if (this.xnombre.equals("SubCategoria")) {
                    if (!this.xestadog) {
                        sql = " Insert into tipo_sub_categoria(Nbre, Estado, Fecha, UsuarioS)  values ('" + this.JTFNombre.getText().toUpperCase() + "','" + this.xestado + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','l')";
                    } else {
                        sql = " update tipo_sub_categoria set Nbre='" + this.JTFNombre.getText().toUpperCase() + "',Estado='" + this.xestado + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='l' Where Id='" + this.xid + "'";
                    }
                } else if (this.xnombre.equals("Categoria")) {
                    if (!this.xestadog) {
                        sql = " Insert into tipo_categoria(Nbre, Estado, Fecha, UsuarioS)  values ('" + this.JTFNombre.getText() + "','" + this.xestado + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','l')";
                    } else {
                        sql = " update tipo_categoria set Nbre='" + this.JTFNombre.getText() + "',Estado='" + this.xestado + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='l' Where Id='" + this.xid + "'";
                    }
                } else if (this.xnombre.equals("Concepto de Pago")) {
                    if (!this.xestadog) {
                        sql = " Insert into tipo_concepto(Nbre, Estado, Fecha, UsuarioS)  values ('" + this.JTFNombre.getText() + "','" + this.xestado + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','l')";
                    } else {
                        sql = " update tipo_concepto set Nbre='" + this.JTFNombre.getText() + "',Estado='" + this.xestado + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='l' Where Id='" + this.xid + "'";
                    }
                }
                this.xconsulta.ejecutarSQL(sql);
                this.xconsulta.cerrarConexionBd();
                mCargarDatosTabla();
                return;
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "El campo nombre no puede ser nulo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JTFNombre.requestFocus();
    }

    public void mEliminar() {
        if (!this.xid.isEmpty()) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de eliminar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                String tabla = null;
                if (this.xnombre.equals("Municipio")) {
                    tabla = "tipo_municipio";
                } else if (this.xnombre.equals("Marca")) {
                    tabla = "tipo_marca";
                } else if (this.xnombre.equals("Tipo Producto")) {
                    tabla = "tipo_producto";
                } else if (this.xnombre.equals("SubCategoria")) {
                    tabla = "tipo_sub_categoria";
                } else if (this.xnombre.equals("Categoria")) {
                    tabla = "tipo_categoria";
                } else if (this.xnombre.equals("Concepto de Pago")) {
                    tabla = "tipo_concepto";
                }
                String sql = "DELETE  FROM " + tabla + " WHERE Id='" + this.xid + "'";
                this.xconsulta.ejecutarSQL(sql);
                this.xconsulta.cerrarConexionBd();
                mCargarDatosTabla();
            }
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Nombre", "Estado"}) { // from class: Parametrizacion.JIFGenerico.3
            Class[] types = {String.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(250);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(30);
    }

    private void mCargarDatosTabla() {
        try {
            mCrearModeloDatos();
            String sql = null;
            if (this.xnombre.equals("Municipio")) {
                sql = "SELECT Id, Nbre, Estado FROM tipo_municipio ORDER BY Nbre ASC";
            } else if (this.xnombre.equals("Documento")) {
                sql = "SELECT Id, Nbre, Estado FROM tipo_documento ORDER BY Nbre ASC";
            } else if (this.xnombre.equals("Marca")) {
                sql = "SELECT Id, Nbre, Estado  FROM tipo_marca  ORDER BY Nbre ASC";
            } else if (this.xnombre.equals("Tipo Producto")) {
                sql = "SELECT Id, Nbre, Estado FROM tipo_producto  ORDER BY Nbre ASC";
            } else if (this.xnombre.equals("SubCategoria")) {
                sql = "SELECT Id, Nbre, Estado FROM tipo_sub_categoria  ORDER BY Nbre ASC";
            } else if (this.xnombre.equals("Categoria")) {
                sql = "SELECT Id, Nbre, Estado FROM tipo_categoria  ORDER BY Nbre ASC";
            } else if (this.xnombre.equals("Concepto de Pago")) {
                sql = "SELECT Id, Nbre, Estado FROM tipo_concepto  ORDER BY Nbre ASC";
            } else if (this.xnombre.equals("Vacunas")) {
                sql = "SELECT Id, Nbre, Estado FROM p_vacunacion_vacunas  ORDER BY Nbre ASC";
            }
            ResultSet xrs = this.xconsulta.traerRs(sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(xrs.getString(1), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(3)), n, 2);
                    n++;
                }
            }
            xrs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFGenerico.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }
}
