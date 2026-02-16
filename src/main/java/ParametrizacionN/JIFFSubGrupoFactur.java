package ParametrizacionN;

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
import java.beans.PropertyVetoException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:ParametrizacionN/JIFFSubGrupoFactur.class */
public class JIFFSubGrupoFactur extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private Object[] xdatos;
    private String xnombre;
    private String xid;
    private String[] xidgrupo;
    private JComboBox JCBGrupo;
    private JCheckBox JCHEstado;
    private JCheckBox JCHGrupo;
    private JPanel JPIDatos;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;
    private JTextField JTFNombre;
    private ConsultasMySQL xconsulta = new ConsultasMySQL();
    private Metodos xmetodos = new Metodos();
    private int xestado = 0;
    private int xesgrupo = 0;
    private boolean xestadog = false;

    public JIFFSubGrupoFactur() {
        initComponents();
        this.xidgrupo = this.xconsulta.llenarCombo("SELECT Id_GrupoServicio, Nbre, Estado FROM baseserver.f_gruposervicio WHERE (Estado =0) ORDER BY Nbre ASC", this.xidgrupo, this.JCBGrupo);
        this.JCBGrupo.setSelectedIndex(-1);
        this.xconsulta.cerrarConexionBd();
        mCargarDatosTabla();
    }

    /* JADX WARN: Type inference failed for: r3v27, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPIDatos = new JPanel();
        this.JTFNombre = new JTextField();
        this.JCHEstado = new JCheckBox();
        this.JCHGrupo = new JCheckBox();
        this.JCBGrupo = new JComboBox();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("SUBGRUPO FACTURA");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifsubgrupofac");
        try {
            setSelected(true);
        } catch (PropertyVetoException e1) {
            e1.printStackTrace();
        }
        addInternalFrameListener(new InternalFrameListener() { // from class: ParametrizacionN.JIFFSubGrupoFactur.1
            public void internalFrameClosed(InternalFrameEvent evt) {
                JIFFSubGrupoFactur.this.formInternalFrameClosed(evt);
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
            }

            public void internalFrameOpened(InternalFrameEvent evt) {
            }

            public void internalFrameActivated(InternalFrameEvent evt) {
            }

            public void internalFrameDeactivated(InternalFrameEvent evt) {
            }

            public void internalFrameDeiconified(InternalFrameEvent evt) {
            }

            public void internalFrameIconified(InternalFrameEvent evt) {
            }
        });
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTFNombre.setFont(new Font("Arial", 1, 12));
        this.JTFNombre.setToolTipText("");
        this.JTFNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setSelected(true);
        this.JCHEstado.setText("Estado");
        this.JCHEstado.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFSubGrupoFactur.2
            public void actionPerformed(ActionEvent evt) {
                JIFFSubGrupoFactur.this.JCHEstadoActionPerformed(evt);
            }
        });
        this.JCHGrupo.setFont(new Font("Arial", 1, 12));
        this.JCHGrupo.setText("Es Grupo?");
        this.JCHGrupo.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFSubGrupoFactur.3
            public void actionPerformed(ActionEvent evt) {
                JIFFSubGrupoFactur.this.JCHGrupoActionPerformed(evt);
            }
        });
        this.JCBGrupo.setFont(new Font("Arial", 1, 12));
        this.JCBGrupo.setBorder(BorderFactory.createTitledBorder((Border) null, "Grupo Factura", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBGrupo, 0, 736, 32767).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JTFNombre, -2, 459, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHEstado).addComponent(this.JCHGrupo)))).addContainerGap()));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFNombre, GroupLayout.Alignment.TRAILING, -2, -1, -2).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JCHEstado).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 21, 32767).addComponent(this.JCHGrupo))).addGap(18, 18, 18).addComponent(this.JCBGrupo, -2, -1, -2).addGap(10, 10, 10)));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalle.setSelectionMode(0);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFFSubGrupoFactur.4
            public void mouseClicked(MouseEvent evt) {
                JIFFSubGrupoFactur.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JPIDatos, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.JSPDetalle, GroupLayout.Alignment.LEADING, -1, 772, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalle, -1, 332, 32767).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEstadoActionPerformed(ActionEvent evt) {
        if (this.JCHEstado.isSelected()) {
            this.xestado = 0;
        } else {
            this.xestado = 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            Principal.txtNo.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
            this.JCBGrupo.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString());
            this.JTFNombre.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString());
            this.JCHEstado.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 4).toString()).booleanValue());
            if (this.JCHEstado.isSelected()) {
                this.xestado = 0;
            } else {
                this.xestado = 1;
            }
            this.JCHGrupo.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString()).booleanValue());
            if (this.JCHGrupo.isSelected()) {
                this.xesgrupo = 1;
            } else {
                this.xesgrupo = 0;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHGrupoActionPerformed(ActionEvent evt) {
        if (this.JCHGrupo.isSelected()) {
            this.xesgrupo = 1;
        } else {
            this.xesgrupo = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosed(InternalFrameEvent evt) {
        Principal.mLimpiarDatosP();
    }

    public void mNuevo() {
        Principal.mLimpiarDatosP();
        this.JTFNombre.setText("");
        this.JCHEstado.setSelected(true);
        this.xestado = 0;
        this.xesgrupo = 0;
        this.JCHGrupo.setSelected(false);
        this.JCBGrupo.setSelectedIndex(-1);
        this.JTFNombre.requestFocus();
    }

    public void mGrabar() {
        String sql;
        if (!this.JTFNombre.getText().isEmpty()) {
            if (this.JCBGrupo.getSelectedIndex() != -1) {
                int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (n == 0) {
                    if (Principal.txtNo.getText().isEmpty()) {
                        sql = " Insert into f_subgruposervicio(Nbre, Id_GrupoServicio, EsGrupo, Estado, Fecha, UsuarioS)  values ('" + this.JTFNombre.getText().toUpperCase() + "','" + this.xidgrupo[this.JCBGrupo.getSelectedIndex()] + "','" + this.xesgrupo + "','" + this.xestado + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                    } else {
                        sql = " update f_subgruposervicio set Nbre='" + this.JTFNombre.getText().toUpperCase() + "',Id_GrupoServicio='" + this.xidgrupo[this.JCBGrupo.getSelectedIndex()] + "',EsGrupo='" + this.xesgrupo + "',Estado='" + this.xestado + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='l' Where Id_SubgrupoServicio='" + Principal.txtNo.getText() + "'";
                    }
                    this.xconsulta.ejecutarSQL(sql);
                    this.xconsulta.cerrarConexionBd();
                    mCargarDatosTabla();
                    return;
                }
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un grupo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBGrupo.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "El campo nombre no puede ser nulo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JTFNombre.requestFocus();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Grupo", "SubGrupo", "EsGrupo?", "Estado"}) { // from class: ParametrizacionN.JIFFSubGrupoFactur.5
            Class[] types = {Long.class, String.class, String.class, Boolean.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(30);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(30);
    }

    private void mCargarDatosTabla() {
        try {
            mCrearModeloDatos();
            ResultSet xrs = this.xconsulta.traerRs("SELECT f_subgruposervicio.Id_SubgrupoServicio, f_gruposervicio.Nbre , f_subgruposervicio.Nbre, f_subgruposervicio.EsGrupo, f_subgruposervicio.Estado FROM f_subgruposervicio INNER JOIN f_gruposervicio  ON (f_subgruposervicio.Id_GrupoServicio = f_gruposervicio.Id_GrupoServicio) ORDER BY f_gruposervicio.Nbre ASC, f_subgruposervicio.Nbre ASC ");
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(1)), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(4)), n, 3);
                    this.xmodelo.setValueAt(Boolean.valueOf(!xrs.getBoolean(5)), n, 4);
                    n++;
                }
            }
            xrs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFFSubGrupoFactur.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }
}
