package ParametrizacionN;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:ParametrizacionN/JIFGenerico3combo2text1check.class */
public class JIFGenerico3combo2text1check extends JInternalFrame {
    private String xnombre;
    private DefaultTableModel xmodelo;
    private Object[] xdatos;
    private String[] xprocedimiento;
    private String[] xmanual;
    private String[] xgrupo;
    private JComboBox JCBIdPracedimiento;
    private JComboBox JCBIdgrupo;
    private JComboBox JCBTipomanuelqx;
    private JPanel JPProcedimiento;
    private JTable JTDetalle;
    private JTextField JTXFCodCups;
    private JTextField JTXFGrupoUvr;
    private JPanel jPanel1;
    private JScrollPane jScrollPane1;
    private ConsultasMySQL xconsulta = new ConsultasMySQL();
    private Metodos xmetodos = new Metodos();
    String sql = null;

    public JIFGenerico3combo2text1check(String xnombre, String xnombref) {
        initComponents();
        setName(xnombref);
        setTitle(xnombre);
        this.xnombre = xnombre;
        mIniciarComponentes();
        mCargarDatosTabla();
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v4, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jScrollPane1 = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JPProcedimiento = new JPanel();
        this.JCBIdPracedimiento = new JComboBox();
        this.JCBTipomanuelqx = new JComboBox();
        this.JCBIdgrupo = new JComboBox();
        this.jPanel1 = new JPanel();
        this.JTXFGrupoUvr = new JTextField();
        this.JTXFCodCups = new JTextField();
        setClosable(true);
        setIconifiable(true);
        this.jScrollPane1.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "", 0, 0, new Font("Arial", 1, 14)));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFGenerico3combo2text1check.1
            public void mouseClicked(MouseEvent evt) {
                JIFGenerico3combo2text1check.this.JTDetalleMouseClicked(evt);
            }
        });
        this.jScrollPane1.setViewportView(this.JTDetalle);
        this.JPProcedimiento.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JCBIdPracedimiento.setBorder(BorderFactory.createTitledBorder((Border) null, "Precedimiento", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTipomanuelqx.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Manual Qx", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBIdgrupo.setBorder(BorderFactory.createTitledBorder((Border) null, "Grupo UVRQx", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jPanel1.setBorder(BorderFactory.createTitledBorder(""));
        this.JTXFGrupoUvr.setBorder(BorderFactory.createTitledBorder((Border) null, "Grupo UVR", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTXFCodCups.setBorder(BorderFactory.createTitledBorder((Border) null, "Codigo Cups", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.JTXFCodCups, -2, 170, -2).addGap(31, 31, 31).addComponent(this.JTXFGrupoUvr, -2, 170, -2).addContainerGap(-1, 32767)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(10, 10, 10).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTXFGrupoUvr, -2, -1, -2).addComponent(this.JTXFCodCups, -2, -1, -2)).addGap(10, 10, 10)));
        GroupLayout JPProcedimientoLayout = new GroupLayout(this.JPProcedimiento);
        this.JPProcedimiento.setLayout(JPProcedimientoLayout);
        JPProcedimientoLayout.setHorizontalGroup(JPProcedimientoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPProcedimientoLayout.createSequentialGroup().addGroup(JPProcedimientoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBIdPracedimiento, 0, 373, 32767).addComponent(this.JCBIdgrupo, 0, -1, 32767)).addGap(18, 18, 18).addGroup(JPProcedimientoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBTipomanuelqx, 0, -1, 32767).addComponent(this.jPanel1, -1, -1, 32767)).addGap(10, 10, 10)));
        JPProcedimientoLayout.setVerticalGroup(JPProcedimientoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPProcedimientoLayout.createSequentialGroup().addGroup(JPProcedimientoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBTipomanuelqx, -2, 50, -2).addComponent(this.JCBIdPracedimiento)).addGap(10, 10, 10).addGroup(JPProcedimientoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPProcedimientoLayout.createSequentialGroup().addComponent(this.jPanel1, -2, 0, 32767).addGap(10, 10, 10)).addGroup(GroupLayout.Alignment.TRAILING, JPProcedimientoLayout.createSequentialGroup().addGap(0, 18, 32767).addComponent(this.JCBIdgrupo, -2, 50, -2).addGap(10, 10, 10)))));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(10, 10, 10).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane1).addComponent(this.JPProcedimiento, -1, -1, 32767)).addGap(10, 10, 10)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.JPProcedimiento, -1, -1, 32767).addGap(10, 10, 10).addComponent(this.jScrollPane1, -2, 192, -2).addGap(10, 10, 10)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            this.JCBIdPracedimiento.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
            this.JCBTipomanuelqx.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString());
            this.JCBIdgrupo.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString());
            this.JTXFCodCups.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString());
            this.JTXFGrupoUvr.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 4).toString());
        }
        if (this.xnombre.equals("ProcedimientoTipoQx")) {
            this.JCBIdPracedimiento.setEnabled(false);
            this.JCBIdgrupo.setEnabled(false);
            this.JCBTipomanuelqx.setEnabled(false);
        }
    }

    private void mIniciarComponentes() {
        this.xprocedimiento = this.xconsulta.llenarCombo("SELECT `Id`  , `Nbre` FROM `g_procedimiento` WHERE (Id) ORDER BY Nbre", this.xprocedimiento, this.JCBIdPracedimiento);
        this.JCBIdPracedimiento.setSelectedIndex(-1);
        this.xmanual = this.xconsulta.llenarCombo("SELECT `Id`  , `Nbre` FROM `q_tipomanualqx` WHERE (Id) ORDER BY Nbre", this.xmanual, this.JCBTipomanuelqx);
        this.JCBTipomanuelqx.setSelectedIndex(-1);
        this.xgrupo = this.xconsulta.llenarCombo("SELECT `Id`  , `Nbre` FROM `q_grupouvr` WHERE (Id) ORDER BY Nbre", this.xgrupo, this.JCBIdgrupo);
        this.JCBIdgrupo.setSelectedIndex(-1);
    }

    public void mNuevo() {
        Principal.txtNo.setText("");
        this.JCBIdPracedimiento.setSelectedIndex(-1);
        this.JCBTipomanuelqx.setSelectedIndex(-1);
        this.JTXFCodCups.setText("");
        this.JCBIdgrupo.setSelectedIndex(-1);
        this.JTXFGrupoUvr.setText("");
        this.JCBIdPracedimiento.requestFocus();
        if (this.xnombre.equals("ProcedimientoTipoQx")) {
            this.JCBIdPracedimiento.setEnabled(true);
            this.JCBIdgrupo.setEnabled(true);
            this.JCBTipomanuelqx.setEnabled(true);
        }
    }

    public void mGrabar() {
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            this.sql = null;
            if (Principal.txtNo.getText().isEmpty()) {
                if (this.xnombre.equals("ProcedimientoTipoQx")) {
                    this.sql = " Insert IGNORE into q_procedtipomanqx(`Id_Procedimiento`,`Id_TipoManualQx`, `Id_GrupoUVRQx` , `CodCups` , `Grupo_UVR`,`Fecha`,`UsuarioS`) values ('" + this.xprocedimiento[this.JCBIdPracedimiento.getSelectedIndex()] + "','" + this.xmanual[this.JCBTipomanuelqx.getSelectedIndex()] + "','" + this.xgrupo[this.JCBIdgrupo.getSelectedIndex()] + "','" + this.JTXFCodCups.getText().toUpperCase() + "','" + this.JTXFGrupoUvr.getText().toUpperCase() + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                }
            } else if (this.xnombre.equals("ProcedimientoTipoQx")) {
                this.sql = " update q_procedtipomanqx set CodCups='" + this.JTXFCodCups.getText().toUpperCase() + "',Grupo_UVR ='" + this.JTXFGrupoUvr.getText().toUpperCase() + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "'Where Id_Procedimiento='" + this.xprocedimiento[this.JCBIdPracedimiento.getSelectedIndex()] + "'and Id_TipoManualQx='" + this.xmanual[this.JCBTipomanuelqx.getSelectedIndex()] + "'";
            }
            this.xconsulta.ejecutarSQL(this.sql);
            this.xconsulta.cerrarConexionBd();
            mCargarDatosTabla();
            mNuevo();
        }
    }

    private void mvalidador() {
        if (this.JCBIdPracedimiento.getSelectedIndex() != -1) {
            if (this.JCBTipomanuelqx.getSelectedIndex() != -1) {
                if (!this.JTXFCodCups.getText().isEmpty()) {
                    if (this.JCBIdgrupo.getSelectedIndex() != -1) {
                        if (!this.JTXFGrupoUvr.getText().isEmpty()) {
                            mGrabar();
                            return;
                        } else {
                            JOptionPane.showInternalMessageDialog(this, "El campo de grupo uvr no pude ser nulo", "VERFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                            return;
                        }
                    }
                    JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un grupo", "VERFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "El campo de codigo cup no pude ser nulo", "VERFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un tipo de manual", "VERFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un procedimiento", "VERFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Procedimiento", "TipoManualQx", "GrupoUVRQx", "CodCups", "GrupoUVR"}) { // from class: ParametrizacionN.JIFGenerico3combo2text1check.2
            Class[] types = {String.class, String.class, String.class, String.class, Integer.class};
            boolean[] canEdit = {false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(60);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(40);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(10);
    }

    private void mCargarDatosTabla() {
        try {
            String sql = null;
            if (this.xnombre.equals("ProcedimientoTipoQx")) {
                sql = "SELECT`g_procedimiento`.`Nbre` AS `procedimiento`,`q_tipomanualqx`.`Nbre` AS `tipomanual`,`q_grupouvr`.`Nbre` AS `grupovr`,`q_procedtipomanqx`.`CodCups`,`q_procedtipomanqx`.`Grupo_UVR`FROM `q_procedtipomanqx` INNER JOIN `g_procedimiento` ON (`q_procedtipomanqx`.`Id_Procedimiento` = `g_procedimiento`.`Id`) INNER JOIN `q_tipomanualqx`  ON (`q_procedtipomanqx`.`Id_TipoManualQx` = `q_tipomanualqx`.`Id`) INNER JOIN `q_grupouvr` ON (`q_procedtipomanqx`.`Id_GrupoUVRQx` = `q_grupouvr`.`Id`);";
            }
            mCrearModeloDatos();
            ResultSet xrs = this.xconsulta.traerRs(sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(xrs.getString(1), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelo.setValueAt(xrs.getString(4), n, 3);
                    this.xmodelo.setValueAt(Integer.valueOf(xrs.getInt(5)), n, 4);
                    n++;
                }
            }
            xrs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFGenericoCh.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void meliminar() {
        if (this.JTDetalle.getSelectedRow() != -1) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de Anular ?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                String sqlup = " DELETE FROM `q_procedtipomanqx`WHERE Id_Procedimiento = '" + this.xprocedimiento[this.JCBIdPracedimiento.getSelectedIndex()] + "' AND  Id_TipoManualQx = '" + this.xmanual[this.JCBTipomanuelqx.getSelectedIndex()] + "'";
                this.xconsulta.ejecutarSQL(sqlup);
                this.xconsulta.cerrarConexionBd();
                JOptionPane.showInternalMessageDialog(this, "Operacion Exitosa", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                mNuevo();
                this.JCBIdPracedimiento.requestFocus();
            } else {
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un registro", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            }
            mCargarDatosTabla();
            mNuevo();
        }
    }
}
