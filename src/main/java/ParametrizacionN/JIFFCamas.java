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
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:ParametrizacionN/JIFFCamas.class */
public class JIFFCamas extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private Object[] xdatos;
    private String[] xprocedimiento;
    private String[] xunidadcama;
    private JComboBox JCBProcedimiento;
    private JComboBox JCBUnidadCama;
    private JCheckBox JCHEsDisponible;
    private JCheckBox JCHEsObservacion;
    private JCheckBox JCHEstado;
    private JPanel JPInformacion;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;
    private JTextField JTFNombre;
    private ConsultasMySQL xconsulta = new ConsultasMySQL();
    private Metodos xmetodos = new Metodos();
    private int xestado = 0;
    private int xesdisponible = 0;
    private int xesobservacion = 0;
    String sql = null;

    public JIFFCamas() {
        initComponents();
        mIniciarComponentes();
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v36, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPInformacion = new JPanel();
        this.JTFNombre = new JTextField();
        this.JCHEsDisponible = new JCheckBox();
        this.JCHEsObservacion = new JCheckBox();
        this.JCHEstado = new JCheckBox();
        this.JCBProcedimiento = new JComboBox();
        this.JCBUnidadCama = new JComboBox();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("CAMAS");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("Camas");
        this.JPInformacion.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACION", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTFNombre.setFont(new Font("Arial", 1, 12));
        this.JTFNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHEsDisponible.setFont(new Font("Arial", 1, 12));
        this.JCHEsDisponible.setForeground(Color.blue);
        this.JCHEsDisponible.setText("Disponible?");
        this.JCHEsDisponible.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFCamas.1
            public void actionPerformed(ActionEvent evt) {
                JIFFCamas.this.JCHEsDisponibleActionPerformed(evt);
            }
        });
        this.JCHEsObservacion.setFont(new Font("Arial", 1, 12));
        this.JCHEsObservacion.setForeground(Color.blue);
        this.JCHEsObservacion.setText("Observacion?");
        this.JCHEsObservacion.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFCamas.2
            public void actionPerformed(ActionEvent evt) {
                JIFFCamas.this.JCHEsObservacionActionPerformed(evt);
            }
        });
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setForeground(Color.blue);
        this.JCHEstado.setText("Estado");
        this.JCHEstado.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFCamas.3
            public void actionPerformed(ActionEvent evt) {
                JIFFCamas.this.JCHEstadoActionPerformed(evt);
            }
        });
        this.JCBProcedimiento.setFont(new Font("Arial", 1, 12));
        this.JCBProcedimiento.setBorder(BorderFactory.createTitledBorder((Border) null, "Procedimiento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBUnidadCama.setFont(new Font("Arial", 1, 12));
        this.JCBUnidadCama.setBorder(BorderFactory.createTitledBorder((Border) null, "Unidad Cama", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPInformacionLayout = new GroupLayout(this.JPInformacion);
        this.JPInformacion.setLayout(JPInformacionLayout);
        JPInformacionLayout.setHorizontalGroup(JPInformacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPInformacionLayout.createSequentialGroup().addContainerGap().addGroup(JPInformacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPInformacionLayout.createSequentialGroup().addComponent(this.JTFNombre, -2, 380, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBUnidadCama, -2, 319, -2)).addComponent(this.JCBProcedimiento, -2, 687, -2)).addGap(10, 10, 10).addGroup(JPInformacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JCHEsDisponible).addComponent(this.JCHEsObservacion, -1, -1, 32767).addComponent(this.JCHEstado, -1, -1, 32767)).addContainerGap(-1, 32767)));
        JPInformacionLayout.setVerticalGroup(JPInformacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPInformacionLayout.createSequentialGroup().addGroup(JPInformacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPInformacionLayout.createSequentialGroup().addComponent(this.JTFNombre, -2, 50, -2).addGap(0, 0, 32767)).addGroup(GroupLayout.Alignment.TRAILING, JPInformacionLayout.createSequentialGroup().addGap(0, 0, 32767).addGroup(JPInformacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(JPInformacionLayout.createSequentialGroup().addComponent(this.JCHEsDisponible).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JCHEsObservacion)).addComponent(this.JCBUnidadCama, -2, 49, -2)))).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPInformacionLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBProcedimiento, -2, 50, -2).addComponent(this.JCHEstado)).addGap(77, 77, 77)));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFFCamas.4
            public void mouseClicked(MouseEvent evt) {
                JIFFCamas.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPInformacion, -2, -1, -2).addContainerGap(-1, 32767)).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.JSPDetalle, -2, 852, -2).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPInformacion, -2, 145, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPDetalle, -2, 330, -2).addContainerGap(-1, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEsDisponibleActionPerformed(ActionEvent evt) {
        if (this.JCHEsDisponible.isSelected()) {
            this.xesdisponible = 1;
        } else {
            this.xesdisponible = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEsObservacionActionPerformed(ActionEvent evt) {
        if (this.JCHEsObservacion.isSelected()) {
            this.xesobservacion = 1;
        } else {
            this.xesobservacion = 0;
        }
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
            Principal.txtNo.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
            this.JTFNombre.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString());
            this.JCBProcedimiento.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString());
            this.JCBUnidadCama.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString());
            this.JCHEsDisponible.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 4).toString()).booleanValue());
            if (this.JCHEsDisponible.isSelected()) {
                this.xesdisponible = 1;
            } else {
                this.xesdisponible = 0;
            }
            this.JCHEsObservacion.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 5).toString()).booleanValue());
            if (this.JCHEsObservacion.isSelected()) {
                this.xesobservacion = 1;
            } else {
                this.xesobservacion = 0;
            }
            this.JCHEstado.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 6).toString()).booleanValue());
            if (this.JCHEstado.isSelected()) {
                this.xestado = 1;
            } else {
                this.xestado = 0;
            }
        }
    }

    public void mNuevo() {
        Principal.mLimpiarDatosP();
        this.JTFNombre.setText("");
        this.JCBProcedimiento.setSelectedIndex(-1);
        this.JCBUnidadCama.setSelectedIndex(-1);
        this.JCHEsDisponible.setSelected(false);
        this.xesdisponible = 0;
        this.JCHEsObservacion.setSelected(false);
        this.xesobservacion = 0;
        this.JCHEstado.setSelected(true);
        this.xestado = 1;
        mCargarDatostabla();
    }

    public void mGrabar() {
        if (!this.JTFNombre.getText().isEmpty()) {
            if (this.JCBProcedimiento.getSelectedIndex() != -1) {
                if (this.JCBProcedimiento.getSelectedIndex() != -1) {
                    int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    if (n == 0) {
                        this.sql = null;
                        if (Principal.txtNo.getText().isEmpty()) {
                            this.sql = "   INSERT INTO `f_camas`(`Nbre`,`Id_Procedimiento`, `Id_UnidadCamas`,`Disponible`,`CObservacion`,`Estado`,`Fecha`,`UsuarioS`)VALUES('" + this.JTFNombre.getText().toUpperCase() + "','" + this.xprocedimiento[this.JCBProcedimiento.getSelectedIndex()] + "','" + this.xunidadcama[this.JCBUnidadCama.getSelectedIndex()] + "','" + this.xesdisponible + "','" + this.xesobservacion + "','" + this.xestado + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                        } else {
                            this.sql = "UPDATE f_camas SET `Nbre` = '" + this.JTFNombre.getText().toUpperCase() + "',`Id_Procedimiento` = '" + this.xprocedimiento[this.JCBProcedimiento.getSelectedIndex()] + "',`Id_UnidadCamas` = '" + this.xunidadcama[this.JCBUnidadCama.getSelectedIndex()] + "',`Disponible` = '" + this.xesdisponible + "',`CObservacion` = '" + this.xesobservacion + "',`Estado` = '" + this.xestado + "',`Fecha` = '" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "',`UsuarioS` = '" + Principal.usuarioSistemaDTO.getLogin() + "' WHERE `Id` = '" + Principal.txtNo.getText() + "'";
                        }
                        this.xconsulta.ejecutarSQL(this.sql);
                        this.xconsulta.cerrarConexionBd();
                        mNuevo();
                        return;
                    }
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Debe debe seleccionar una unidad de cama ", "VERFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JCBUnidadCama.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un procedimiento", "VERFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBProcedimiento.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe digitar una cama", "VERFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JTFNombre.requestFocus();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloTabla() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"ID", "Nombre", "Procedimiento", "Unidad Cama", "Disponible?", "Observacion?", "Estado"}) { // from class: ParametrizacionN.JIFFCamas.5
            Class[] types = {Long.class, String.class, String.class, String.class, Boolean.class, Boolean.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(10);
    }

    private void mCargarDatostabla() {
        try {
            mCrearModeloTabla();
            ResultSet xrs = this.xconsulta.traerRs("SELECT`f_camas`.`Id`, `f_camas`.`Nbre`, `g_procedimiento`.`Nbre` AS `Procedimiento`, `f_unidadcama`.`Nbre` AS `UniCama`, `f_camas`.`Disponible`, `f_camas`.`CObservacion` , `f_camas`.`Estado`FROM`f_camas`INNER JOIN `g_procedimiento` ON (`f_camas`.`Id_Procedimiento` = `g_procedimiento`.`Id`)INNER JOIN `f_unidadcama` ON (`f_camas`.`Id_UnidadCamas` = `f_unidadcama`.`Id`)ORDER BY `f_camas`.`Nbre` ASC;");
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                this.xmetodos.mEstablecerTextEditor(this.JTDetalle, 1);
                this.xmetodos.mEstablecerTextEditor(this.JTDetalle, 2);
                this.xmetodos.mEstablecerTextEditor(this.JTDetalle, 3);
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(1)), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelo.setValueAt(xrs.getString(4), n, 3);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(5)), n, 4);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(6)), n, 5);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(7)), n, 6);
                    n++;
                }
            }
            xrs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFFCamas.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mIniciarComponentes() {
        this.xprocedimiento = this.xconsulta.llenarCombo("SELECT `g_procedimiento`.`Id` , `g_procedimiento`.`Nbre`  FROM `g_procedimiento` INNER JOIN  `f_tipoprocedimiento`  ON (`g_procedimiento`.`Id_tipoprocedimiento` = `f_tipoprocedimiento`.`Id`)  WHERE (`f_tipoprocedimiento`.`Id` =15 AND `g_procedimiento`.`Estado` =0) ORDER BY `g_procedimiento`.`Nbre` ASC ", this.xprocedimiento, this.JCBProcedimiento);
        this.JCBProcedimiento.setSelectedIndex(-1);
        this.xunidadcama = this.xconsulta.llenarCombo("SELECT `Id`, `Nbre` FROM `f_unidadcama` WHERE (`Estado` =1) ORDER BY Nbre ASC", this.xunidadcama, this.JCBUnidadCama);
        this.JCBUnidadCama.setSelectedIndex(-1);
        this.xconsulta.cerrarConexionBd();
    }
}
