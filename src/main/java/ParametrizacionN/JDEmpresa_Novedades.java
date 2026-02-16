package ParametrizacionN;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:ParametrizacionN/JDEmpresa_Novedades.class */
public class JDEmpresa_Novedades extends JDialog {
    private int xtipo;
    private String xestado;
    private String xidtercero;
    private String xsql;
    private ConsultasMySQL xct;
    private DefaultTableModel xmodelo;
    private Object[] xdato;
    private Metodos xmt;
    private ButtonGroup JBGFiltro;
    private JButton JBTGrabar;
    private JButton JBTSalir;
    private JDateChooser JDFechaI;
    private JPanel JPIDatosE;
    private JPanel JPITipoAccion;
    private JRadioButton JRBActivar;
    private JRadioButton JRBDesactivar;
    private JScrollPane JSPD_Motivo;
    private JScrollPane JSPHistorico;
    private JTextArea JTAD_Motivo;
    private JTable JTBDetalle;

    public JDEmpresa_Novedades(Frame parent, boolean modal, String xidtercero, String xestado) {
        super(parent, modal);
        this.xtipo = 0;
        this.xestado = "0";
        this.xct = new ConsultasMySQL();
        this.xmt = new Metodos();
        initComponents();
        this.xestado = xestado;
        this.xidtercero = xidtercero;
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        setLocationRelativeTo(null);
        mNuevo();
    }

    private void initComponents() {
        this.JBGFiltro = new ButtonGroup();
        this.JPIDatosE = new JPanel();
        this.JDFechaI = new JDateChooser();
        this.JPITipoAccion = new JPanel();
        this.JRBActivar = new JRadioButton();
        this.JRBDesactivar = new JRadioButton();
        this.JSPD_Motivo = new JScrollPane();
        this.JTAD_Motivo = new JTextArea();
        this.JSPHistorico = new JScrollPane();
        this.JTBDetalle = new JTable();
        this.JBTGrabar = new JButton();
        this.JBTSalir = new JButton();
        setDefaultCloseOperation(2);
        setTitle("NOVEDADES");
        this.JPIDatosE.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JDFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFechaI.setFont(new Font("Arial", 1, 13));
        this.JPITipoAccion.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Acción", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JBGFiltro.add(this.JRBActivar);
        this.JRBActivar.setFont(new Font("Arial", 1, 12));
        this.JRBActivar.setForeground(new Color(51, 51, 51));
        this.JRBActivar.setSelected(true);
        this.JRBActivar.setText("Activar");
        this.JRBActivar.addActionListener(new ActionListener() { // from class: ParametrizacionN.JDEmpresa_Novedades.1
            public void actionPerformed(ActionEvent evt) {
                JDEmpresa_Novedades.this.JRBActivarActionPerformed(evt);
            }
        });
        this.JBGFiltro.add(this.JRBDesactivar);
        this.JRBDesactivar.setFont(new Font("Arial", 1, 12));
        this.JRBDesactivar.setForeground(new Color(51, 51, 51));
        this.JRBDesactivar.setText("Desactivar");
        this.JRBDesactivar.addActionListener(new ActionListener() { // from class: ParametrizacionN.JDEmpresa_Novedades.2
            public void actionPerformed(ActionEvent evt) {
                JDEmpresa_Novedades.this.JRBDesactivarActionPerformed(evt);
            }
        });
        GroupLayout JPITipoAccionLayout = new GroupLayout(this.JPITipoAccion);
        this.JPITipoAccion.setLayout(JPITipoAccionLayout);
        JPITipoAccionLayout.setHorizontalGroup(JPITipoAccionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPITipoAccionLayout.createSequentialGroup().addContainerGap().addComponent(this.JRBActivar, -2, 83, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBDesactivar).addContainerGap(-1, 32767)));
        JPITipoAccionLayout.setVerticalGroup(JPITipoAccionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPITipoAccionLayout.createSequentialGroup().addGroup(JPITipoAccionLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBActivar).addComponent(this.JRBDesactivar)).addGap(0, 0, 32767)));
        this.JSPD_Motivo.setBorder(BorderFactory.createTitledBorder((Border) null, "Motivo", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTAD_Motivo.setColumns(1);
        this.JTAD_Motivo.setFont(new Font("Arial", 1, 12));
        this.JTAD_Motivo.setRows(1);
        this.JTAD_Motivo.setTabSize(1);
        this.JSPD_Motivo.setViewportView(this.JTAD_Motivo);
        GroupLayout JPIDatosELayout = new GroupLayout(this.JPIDatosE);
        this.JPIDatosE.setLayout(JPIDatosELayout);
        JPIDatosELayout.setHorizontalGroup(JPIDatosELayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosELayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosELayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPD_Motivo).addGroup(JPIDatosELayout.createSequentialGroup().addComponent(this.JDFechaI, -2, 120, -2).addGap(18, 18, 18).addComponent(this.JPITipoAccion, -2, -1, -2).addGap(0, 0, 32767))).addContainerGap()));
        JPIDatosELayout.setVerticalGroup(JPIDatosELayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosELayout.createSequentialGroup().addGroup(JPIDatosELayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JPITipoAccion, -1, -1, 32767).addComponent(this.JDFechaI, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPD_Motivo, -2, 58, -2).addContainerGap(-1, 32767)));
        this.JSPHistorico.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JTBDetalle.setFont(new Font("Arial", 1, 12));
        this.JTBDetalle.setRowHeight(25);
        this.JTBDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTBDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JSPHistorico.setViewportView(this.JTBDetalle);
        this.JBTGrabar.setFont(new Font("Arial", 1, 12));
        this.JBTGrabar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Grabar29x27.png")));
        this.JBTGrabar.setText("Grabar");
        this.JBTGrabar.addActionListener(new ActionListener() { // from class: ParametrizacionN.JDEmpresa_Novedades.3
            public void actionPerformed(ActionEvent evt) {
                JDEmpresa_Novedades.this.JBTGrabarActionPerformed(evt);
            }
        });
        this.JBTSalir.setFont(new Font("Arial", 1, 12));
        this.JBTSalir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.JBTSalir.setText("Salir");
        this.JBTSalir.addActionListener(new ActionListener() { // from class: ParametrizacionN.JDEmpresa_Novedades.4
            public void actionPerformed(ActionEvent evt) {
                JDEmpresa_Novedades.this.JBTSalirActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPIDatosE, -1, -1, 32767).addComponent(this.JSPHistorico, GroupLayout.Alignment.TRAILING, -1, 546, 32767).addGroup(layout.createSequentialGroup().addComponent(this.JBTGrabar, -2, 245, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JBTSalir, -2, 245, -2))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatosE, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPHistorico, -2, 127, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBTGrabar, -1, 50, 32767).addComponent(this.JBTSalir, -1, 50, 32767)).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBActivarActionPerformed(ActionEvent evt) {
        this.xtipo = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBDesactivarActionPerformed(ActionEvent evt) {
        this.xtipo = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTSalirActionPerformed(ActionEvent evt) {
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTGrabarActionPerformed(ActionEvent evt) {
        if (!this.JTAD_Motivo.getText().isEmpty()) {
            int x = JOptionPane.showConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 3);
            if (x == 0) {
                this.xsql = "insert into g_empresa_novedades (`Id_Empresa`, `FechaA`, `Tipo`, `Motivo`, `Id_UsuarioC`, `UsuarioS` ) values('" + this.xidtercero + "','" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "','" + this.xtipo + "','" + this.JTAD_Motivo.getText() + "','" + Principal.usuarioSistemaDTO.getIdPersonaCargo() + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                this.xct.ejecutarSQL(this.xsql);
                this.xct.cerrarConexionBd();
                this.xsql = "update g_empresa set ActivoC='" + this.xtipo + "' where Id='" + this.xidtercero + "'";
                this.xct.ejecutarSQL(this.xsql);
                this.xct.cerrarConexionBd();
                mCargarDatosTabla();
                return;
            }
            return;
        }
        JOptionPane.showMessageDialog(this, "El motivo no puedes estas en blanco", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JTAD_Motivo.requestFocus();
    }

    private void mNuevo() {
        if (this.xestado.equals("0")) {
            this.JRBActivar.setSelected(true);
            this.xtipo = 1;
        } else {
            this.JRBDesactivar.setSelected(true);
            this.xtipo = 0;
        }
        this.JDFechaI.setDate(this.xmt.getFechaActual());
        this.JDFechaI.setEnabled(false);
        mCargarDatosTabla();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTabla() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Fecha", "Tipo", "Motivo", "Empleado"}) { // from class: ParametrizacionN.JDEmpresa_Novedades.5
            Class[] types = {Long.class, String.class, Boolean.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTBDetalle.setModel(this.xmodelo);
        this.JTBDetalle.getColumnModel().getColumn(0).setPreferredWidth(5);
        this.JTBDetalle.getColumnModel().getColumn(1).setPreferredWidth(10);
        this.JTBDetalle.getColumnModel().getColumn(2).setPreferredWidth(5);
        this.JTBDetalle.getColumnModel().getColumn(3).setPreferredWidth(50);
        this.JTBDetalle.getColumnModel().getColumn(4).setPreferredWidth(50);
    }

    private void mCargarDatosTabla() {
        try {
            mCrearTabla();
            this.xsql = "SELECT `g_empresa_novedades`.`Id`, date_format(`g_empresa_novedades`.`FechaA`,'%d-%m-%Y') as Fecha, `g_empresa_novedades`.`Tipo`, `g_empresa_novedades`.`Motivo`, CONCAT(`persona`.`NUsuario`,' ',`rh_tipo_cargo`.`Nbre`) AS Persona FROM `g_empresa_novedades` INNER JOIN `rh_tipo_persona_cargon`  ON (`g_empresa_novedades`.`Id_UsuarioC` = `rh_tipo_persona_cargon`.`Id`) INNER JOIN `rh_unidadf_cargo`  ON (`rh_tipo_persona_cargon`.`Id_unidadf_cargo` = `rh_unidadf_cargo`.`Id`) INNER JOIN `rh_tipo_cargo`  ON (`rh_unidadf_cargo`.`Id_Cargo` = `rh_tipo_cargo`.`Id`) INNER JOIN `persona`  ON (`persona`.`Id_persona` = `rh_tipo_persona_cargon`.`Id_Persona`) WHERE (`g_empresa_novedades`.`Id_Empresa` ='" + this.xidtercero + "') ORDER BY `g_empresa_novedades`.`Id` DESC";
            ResultSet rs = this.xct.traerRs(this.xsql);
            rs.next();
            if (rs.getRow() != 0) {
                rs.beforeFirst();
                int i = 0;
                while (rs.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(Long.valueOf(rs.getLong(1)), i, 0);
                    this.xmodelo.setValueAt(rs.getString(2), i, 1);
                    this.xmodelo.setValueAt(Boolean.valueOf(rs.getBoolean(3)), i, 2);
                    this.xmodelo.setValueAt(rs.getString(4), i, 3);
                    this.xmodelo.setValueAt(rs.getString(5), i, 4);
                    i++;
                }
            }
            rs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JDEmpresa_Novedades.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }
}
