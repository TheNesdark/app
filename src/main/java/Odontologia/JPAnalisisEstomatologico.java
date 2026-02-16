package Odontologia;

import Acceso.Principal;
import Historia.clasesHistoriaCE;
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
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Odontologia/JPAnalisisEstomatologico.class */
public class JPAnalisisEstomatologico extends JPanel {
    Metodos xmt = new Metodos();
    private String xanaEstoma = "";
    ConsultasMySQL xconsulta = new ConsultasMySQL();
    private DefaultTableModel xmodelo2;
    private Object[] xdato;
    private JButton JBGuardar;
    private JComboBox JCBFreLabInf;
    private JComboBox JCBFreLabSup;
    private JComboBox JCBFreLingual;
    private JScrollPane JSPHistorico;
    private JScrollPane JSPObservacion;
    private JScrollPane JSPObservacion1;
    private JTextArea JTAAnomalias;
    private JTextArea JTAObservacion;
    private JTextField JTFLengua;
    private JTextField JTFPaladar;
    private JTextField JTFPisoBoca;
    private JTextField JTFTejidoBlando;
    private JTable JTHistorico;
    private JTabbedPane JTPDatos;
    private JPanel jPanel1;
    private JPanel jPanel2;

    public JPAnalisisEstomatologico() {
        initComponents();
        this.JCBFreLabSup.setSelectedIndex(-1);
        this.JCBFreLabInf.setSelectedIndex(-1);
        this.JCBFreLingual.setSelectedIndex(-1);
        mBuscarHistorico();
    }

    /* JADX WARN: Type inference failed for: r3v58, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGuardar = new JButton();
        this.JTPDatos = new JTabbedPane();
        this.jPanel1 = new JPanel();
        this.JTFTejidoBlando = new JTextField();
        this.JTFPaladar = new JTextField();
        this.JTFLengua = new JTextField();
        this.JTFPisoBoca = new JTextField();
        this.JCBFreLabSup = new JComboBox();
        this.JCBFreLabInf = new JComboBox();
        this.JCBFreLingual = new JComboBox();
        this.JSPObservacion1 = new JScrollPane();
        this.JTAAnomalias = new JTextArea();
        this.JSPObservacion = new JScrollPane();
        this.JTAObservacion = new JTextArea();
        this.jPanel2 = new JPanel();
        this.JSPHistorico = new JScrollPane();
        this.JTHistorico = new JTable();
        setName("jpanalisisestomatologico");
        this.JBGuardar.setFont(new Font("Arial", 1, 12));
        this.JBGuardar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBGuardar.setText("Guardar");
        this.JBGuardar.addActionListener(new ActionListener() { // from class: Odontologia.JPAnalisisEstomatologico.1
            public void actionPerformed(ActionEvent evt) {
                JPAnalisisEstomatologico.this.JBGuardarActionPerformed(evt);
            }
        });
        this.JTPDatos.setForeground(new Color(0, 107, 0));
        this.JTPDatos.setFont(new Font("Arial", 1, 14));
        this.JTFTejidoBlando.setFont(new Font("Arial", 1, 12));
        this.JTFTejidoBlando.setToolTipText("");
        this.JTFTejidoBlando.setBorder(BorderFactory.createTitledBorder((Border) null, "Tejidos Blandos", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFPaladar.setFont(new Font("Arial", 1, 12));
        this.JTFPaladar.setToolTipText("");
        this.JTFPaladar.setBorder(BorderFactory.createTitledBorder((Border) null, "Paladar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFLengua.setFont(new Font("Arial", 1, 12));
        this.JTFLengua.setToolTipText("");
        this.JTFLengua.setBorder(BorderFactory.createTitledBorder((Border) null, "Lengua", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFPisoBoca.setFont(new Font("Arial", 1, 12));
        this.JTFPisoBoca.setToolTipText("");
        this.JTFPisoBoca.setBorder(BorderFactory.createTitledBorder((Border) null, "Piso de boca", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBFreLabSup.setFont(new Font("Arial", 1, 12));
        this.JCBFreLabSup.setModel(new DefaultComboBoxModel(new String[]{"NORMAL", "SOBRE INSERTADO"}));
        this.JCBFreLabSup.setBorder(BorderFactory.createTitledBorder((Border) null, "Frenillo Labial Superior", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBFreLabInf.setFont(new Font("Arial", 1, 12));
        this.JCBFreLabInf.setModel(new DefaultComboBoxModel(new String[]{"NORMAL", "SOBRE INSERTADO"}));
        this.JCBFreLabInf.setBorder(BorderFactory.createTitledBorder((Border) null, "Frenillo Labial Inferior", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBFreLingual.setFont(new Font("Arial", 1, 12));
        this.JCBFreLingual.setModel(new DefaultComboBoxModel(new String[]{"NORMAL", "SOBRE INSERTADO"}));
        this.JCBFreLingual.setBorder(BorderFactory.createTitledBorder((Border) null, "Frenillo Lingual", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTAAnomalias.setColumns(1);
        this.JTAAnomalias.setFont(new Font("Arial", 0, 12));
        this.JTAAnomalias.setLineWrap(true);
        this.JTAAnomalias.setRows(1);
        this.JTAAnomalias.setBorder(BorderFactory.createTitledBorder((Border) null, "Anomalías de Esmalte y Dentina", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JSPObservacion1.setViewportView(this.JTAAnomalias);
        this.JTAObservacion.setColumns(1);
        this.JTAObservacion.setFont(new Font("Arial", 0, 12));
        this.JTAObservacion.setLineWrap(true);
        this.JTAObservacion.setRows(1);
        this.JTAObservacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JSPObservacion.setViewportView(this.JTAObservacion);
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBFreLingual, -2, 228, -2).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JTFPisoBoca, -2, 525, -2).addComponent(this.JTFLengua, -2, 525, -2).addComponent(this.JTFPaladar, -2, 525, -2).addComponent(this.JTFTejidoBlando, -2, 525, -2)).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JCBFreLabSup, -2, 228, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JCBFreLabInf, -2, 228, -2))).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JSPObservacion, GroupLayout.Alignment.LEADING, -1, 652, 32767).addComponent(this.JSPObservacion1, GroupLayout.Alignment.LEADING))).addContainerGap(19, 32767)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.JTFTejidoBlando, -2, 50, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFPaladar, -2, 50, -2).addGap(6, 6, 6).addComponent(this.JTFLengua, -2, 50, -2).addGap(6, 6, 6).addComponent(this.JTFPisoBoca, -2, 50, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBFreLabSup, -2, 50, -2).addComponent(this.JCBFreLabInf, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBFreLingual, -2, 50, -2).addGap(17, 17, 17).addComponent(this.JSPObservacion1, -2, 74, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPObservacion, -2, 74, -2).addContainerGap()));
        this.JTPDatos.addTab("ESTOMATOLOGÍA", this.jPanel1);
        this.JTHistorico.setFont(new Font("Arial", 1, 12));
        this.JTHistorico.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTHistorico.setSelectionBackground(new Color(255, 255, 255));
        this.JTHistorico.setSelectionForeground(new Color(255, 0, 0));
        this.JTHistorico.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPAnalisisEstomatologico.2
            public void mouseClicked(MouseEvent evt) {
                JPAnalisisEstomatologico.this.JTHistoricoMouseClicked(evt);
            }
        });
        this.JSPHistorico.setViewportView(this.JTHistorico);
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(this.JSPHistorico, -1, 661, 32767).addContainerGap()));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(this.JSPHistorico, -1, 500, 32767).addContainerGap()));
        this.JTPDatos.addTab("HISTÓRICO", this.jPanel2);
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTPDatos, GroupLayout.Alignment.TRAILING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JBGuardar, -2, 652, -2).addGap(0, 0, 32767))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.JTPDatos, -2, 553, -2).addGap(10, 10, 10).addComponent(this.JBGuardar, -2, 34, -2).addContainerGap()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBGuardarActionPerformed(ActionEvent evt) {
        mGuardar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTHistoricoMouseClicked(MouseEvent evt) {
        cargarDatos();
    }

    private void cargarDatos() {
        if (this.JTHistorico.getSelectedRow() != -1) {
            String sql = "SELECT TejidosBlandos , Paladar, Lengua, PisoBoca, FreLabSuperior,FreLabInferior,FreLingual, Anomalias ,Observacion  FROM o_estomatologia oe\nWHERE Id =" + this.xmodelo2.getValueAt(this.JTHistorico.getSelectedRow(), 0) + "";
            System.out.println(sql);
            ConsultasMySQL xct = new ConsultasMySQL();
            ResultSet xrs = xct.traerRs(sql);
            try {
                if (xrs.next()) {
                    xrs.first();
                    this.JTFTejidoBlando.setText(xrs.getString("TejidosBlandos"));
                    this.JTFPaladar.setText(xrs.getString("Paladar"));
                    this.JTFLengua.setText(xrs.getString("Lengua"));
                    this.JTFPisoBoca.setText(xrs.getString("PisoBoca"));
                    this.JCBFreLabSup.setSelectedItem(xrs.getString("FreLabSuperior"));
                    this.JCBFreLabInf.setSelectedItem(xrs.getString("FreLabInferior"));
                    this.JCBFreLingual.setSelectedItem(xrs.getString("FreLingual"));
                    this.JTAAnomalias.setText(xrs.getString("Anomalias"));
                    this.JTAObservacion.setText(xrs.getString("Observacion"));
                    mVerificaAnalisisAtencion();
                    this.JTPDatos.setSelectedIndex(0);
                }
                xrs.close();
                xct.cerrarConexionBd();
            } catch (SQLException ex) {
                Logger.getLogger(JPAnalisiOclusal.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        }
    }

    public void mGuardar() {
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            if (this.xanaEstoma.equals("")) {
                String sql = "INSERT INTO  `o_estomatologia` (`IdAtencion`, `IdTratamiento`,  `IdUsuario`,  `IdProfesional`, `IdEspecialidad`,  `TejidosBlandos`, `Paladar`,Lengua, `PisoBoca`, `FreLabSuperior`, `FreLabInferior`, `FreLingual`, `Anomalias`, `Observacion`,   `UsuarioS`)  VALUES ('" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "', '" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTratamiento() + "', '" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "',  '" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "', '" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "',  '" + this.JTFTejidoBlando.getText() + "', '" + this.JTFPaladar.getText() + "', '" + this.JTFLengua.getText() + "', '" + this.JTFPisoBoca.getText() + "','" + this.JCBFreLabSup.getSelectedItem() + "', '" + this.JCBFreLabInf.getSelectedItem() + "',  '" + this.JCBFreLingual.getSelectedItem() + "', '" + this.JTAAnomalias.getText() + "', '" + this.JTAObservacion.getText() + "',  '" + Principal.usuarioSistemaDTO.getLogin() + "')";
                this.xanaEstoma = this.xconsulta.ejecutarSQLId(sql);
            } else {
                String sql2 = "UPDATE  `o_estomatologia`  SET  `TejidosBlandos` = '" + this.JTFTejidoBlando.getText() + "', `Paladar` = '" + this.JTFPaladar.getText() + "',  `Lengua` = '" + this.JTFLengua.getText() + "',  `PisoBoca` = '" + this.JTFPisoBoca.getText() + "', `FreLabSuperior` = '" + this.JCBFreLabSup.getSelectedItem() + "', `FreLabInferior` = '" + this.JCBFreLabInf.getSelectedItem() + "',  `FreLingual` = '" + this.JCBFreLingual.getSelectedItem() + "', `Anomalias` = '" + this.JTAAnomalias.getText() + "', `Observacion` = '" + this.JTAObservacion.getText() + "', `UsuarioS` = '" + Principal.usuarioSistemaDTO.getLogin() + "'  WHERE `Id` = '" + this.xanaEstoma + "' ";
                this.xconsulta.ejecutarSQL(sql2);
            }
            this.xconsulta.cerrarConexionBd();
            mBuscarHistorico();
            this.xmt.cambiarEstadoValidadoItemHC(getName(), 1, true);
        }
    }

    private void mVerificaAnalisisAtencion() {
        String sql = "SELECT `Id`  , `IdAtencion` FROM `o_estomatologia` WHERE (`IdUsuario` = '" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "' AND `IdAtencion` ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "')";
        ConsultasMySQL xct = new ConsultasMySQL();
        ResultSet xrs = xct.traerRs(sql);
        try {
            if (xrs.next()) {
                xrs.first();
                mBuscarDatosBD(xrs.getInt("Id"));
                this.xanaEstoma = xrs.getString("Id");
                this.xmt.cambiarEstadoValidadoItemHC(getName(), 1, true);
            }
            xrs.close();
            xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPAnalisiOclusal.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mBuscarDatosBD(int xid) {
        String sql = "SELECT  `Id`, `TejidosBlandos`  , `Paladar` , `Lengua`  , `PisoBoca` , `FreLabSuperior`  , `FreLabInferior` , `FreLingual` , `Anomalias`  , `Observacion`  FROM `o_estomatologia` WHERE (`Id` ='" + xid + "') ";
        ResultSet xrs = this.xconsulta.traerRs(sql);
        try {
            if (xrs.next()) {
                xrs.first();
                this.JTFTejidoBlando.setText(xrs.getString("TejidosBlandos"));
                this.JTFPaladar.setText(xrs.getString("Paladar"));
                this.JTFLengua.setText(xrs.getString("Lengua"));
                this.JTFPisoBoca.setText(xrs.getString("PisoBoca"));
                this.JCBFreLabSup.setSelectedItem(xrs.getString("FreLabSuperior"));
                this.JCBFreLabInf.setSelectedItem(xrs.getString("FreLabInferior"));
                this.JCBFreLingual.setSelectedItem(xrs.getString("FreLingual"));
                this.JTAAnomalias.setText(xrs.getString("Anomalias"));
                this.JTAObservacion.setText(xrs.getString("Observacion"));
            }
            xrs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPAnalisiOclusal.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloHistorico() {
        this.xmodelo2 = new DefaultTableModel(new Object[0], new String[]{"Id", "IdAtencion", "Profesional", "Especialidad"}) { // from class: Odontologia.JPAnalisisEstomatologico.3
            Class[] types = {Integer.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTHistorico.setModel(this.xmodelo2);
        this.JTHistorico.getColumnModel().getColumn(0).setPreferredWidth(2);
        this.JTHistorico.getColumnModel().getColumn(1).setPreferredWidth(20);
        this.JTHistorico.getColumnModel().getColumn(2).setPreferredWidth(150);
        this.JTHistorico.getColumnModel().getColumn(3).setPreferredWidth(150);
    }

    private void mBuscarHistorico() {
        mCrearModeloHistorico();
        String sql = "SELECT `o_estomatologia`.`Id` , `o_estomatologia`.`IdAtencion` , `profesional1`.`NProfesional` , `profesional1`.`Especialidad`  FROM `o_estomatologia`  INNER JOIN  `profesional1`   ON (`o_estomatologia`.`IdProfesional` = `profesional1`.`Id_Persona`) AND (`o_estomatologia`.`IdEspecialidad` = `profesional1`.`IdEspecialidad`) WHERE (`o_estomatologia`.`IdUsuario` ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "')";
        ResultSet xrs = this.xconsulta.traerRs(sql);
        try {
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo2.addRow(this.xdato);
                    this.xmodelo2.setValueAt(Integer.valueOf(xrs.getInt(1)), n, 0);
                    this.xmodelo2.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo2.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelo2.setValueAt(xrs.getString(4), n, 3);
                    n++;
                }
            }
            xrs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPAnalisiOclusal.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }
}
