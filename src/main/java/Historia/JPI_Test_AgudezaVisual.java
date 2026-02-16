package Historia;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Historia/JPI_Test_AgudezaVisual.class */
public class JPI_Test_AgudezaVisual extends JPanel {
    private ConsultasMySQL xct = new ConsultasMySQL();
    private Metodos xmt = new Metodos();
    private String[][] xId1;
    private String[][] xId2;
    private String[][] xId3;
    private String[][] xId4;
    private String[][] xId5;
    private String[][] xId6;
    private String xsql;
    private DefaultTableModel xmodelo;
    private Object[] xdato;
    private JComboBox JCB_Mca_AOjos;
    private JComboBox JCB_Mca_ODerecho;
    private JComboBox JCB_Mca_OIzquierdo;
    private JComboBox JCB_Msa_AOjos;
    private JComboBox JCB_Msa_ODerecho;
    private JComboBox JCB_Msa_OIzquierdo;
    private JLabel JLB_;
    private JLabel JLB_1;
    private JPanel JPI_DatosE;
    private JScrollPane JSPDetalle;
    private JScrollPane JSPObservacion;
    private JTable JTBDetalle;
    public JTextField JTF_Id;
    public JTextPane JTPObservacion;

    public JPI_Test_AgudezaVisual() {
        initComponents();
        mNuevo();
    }

    private void initComponents() {
        this.JPI_DatosE = new JPanel();
        this.JLB_ = new JLabel();
        this.JCB_Msa_ODerecho = new JComboBox();
        this.JCB_Msa_OIzquierdo = new JComboBox();
        this.JCB_Msa_AOjos = new JComboBox();
        this.JLB_1 = new JLabel();
        this.JCB_Mca_ODerecho = new JComboBox();
        this.JCB_Mca_OIzquierdo = new JComboBox();
        this.JCB_Mca_AOjos = new JComboBox();
        this.JSPObservacion = new JScrollPane();
        this.JTPObservacion = new JTextPane();
        this.JSPDetalle = new JScrollPane();
        this.JTBDetalle = new JTable();
        this.JTF_Id = new JTextField();
        setBorder(BorderFactory.createTitledBorder((Border) null, "TEST DE AGUDEZA VISUAL", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        setName("xjif_testagudeza_visual");
        this.JPI_DatosE.setBorder(BorderFactory.createEtchedBorder());
        this.JLB_.setFont(new Font("Arial", 1, 12));
        this.JLB_.setForeground(Color.red);
        this.JLB_.setHorizontalAlignment(0);
        this.JLB_.setText("Medición sin Anteojos");
        this.JCB_Msa_ODerecho.setFont(new Font("Arial", 1, 12));
        this.JCB_Msa_ODerecho.setBorder(BorderFactory.createTitledBorder((Border) null, "Ojo Derecho", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCB_Msa_OIzquierdo.setFont(new Font("Arial", 1, 12));
        this.JCB_Msa_OIzquierdo.setBorder(BorderFactory.createTitledBorder((Border) null, "Ojo Izquierdo", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCB_Msa_AOjos.setFont(new Font("Arial", 1, 12));
        this.JCB_Msa_AOjos.setBorder(BorderFactory.createTitledBorder((Border) null, "Ambos Ojos", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JLB_1.setFont(new Font("Arial", 1, 12));
        this.JLB_1.setForeground(Color.red);
        this.JLB_1.setHorizontalAlignment(0);
        this.JLB_1.setText("Medición Con Anteojos");
        this.JCB_Mca_ODerecho.setFont(new Font("Arial", 1, 12));
        this.JCB_Mca_ODerecho.setBorder(BorderFactory.createTitledBorder((Border) null, "Ojo Derecho", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCB_Mca_OIzquierdo.setFont(new Font("Arial", 1, 12));
        this.JCB_Mca_OIzquierdo.setBorder(BorderFactory.createTitledBorder((Border) null, "Ojo Izquierdo", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCB_Mca_AOjos.setFont(new Font("Arial", 1, 12));
        this.JCB_Mca_AOjos.setBorder(BorderFactory.createTitledBorder((Border) null, "Ambos Ojos", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPObservacion.setBorder(BorderFactory.createTitledBorder((Border) null, "NOTA CLINICA", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTPObservacion.setFont(new Font("Arial", 1, 12));
        this.JTPObservacion.addKeyListener(new KeyAdapter() { // from class: Historia.JPI_Test_AgudezaVisual.1
            public void keyPressed(KeyEvent evt) {
                JPI_Test_AgudezaVisual.this.JTPObservacionKeyPressed(evt);
            }
        });
        this.JSPObservacion.setViewportView(this.JTPObservacion);
        GroupLayout JPI_DatosELayout = new GroupLayout(this.JPI_DatosE);
        this.JPI_DatosE.setLayout(JPI_DatosELayout);
        JPI_DatosELayout.setHorizontalGroup(JPI_DatosELayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DatosELayout.createSequentialGroup().addContainerGap().addGroup(JPI_DatosELayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLB_, -2, 169, -2).addGroup(JPI_DatosELayout.createSequentialGroup().addGap(10, 10, 10).addGroup(JPI_DatosELayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JCB_Msa_OIzquierdo, -2, 157, -2).addComponent(this.JCB_Msa_ODerecho, -2, 157, -2).addComponent(this.JCB_Msa_AOjos, -2, 157, -2)))).addGap(51, 51, 51).addGroup(JPI_DatosELayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLB_1, -2, 169, -2).addGroup(JPI_DatosELayout.createSequentialGroup().addGap(10, 10, 10).addGroup(JPI_DatosELayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JCB_Mca_OIzquierdo, -2, 157, -2).addComponent(this.JCB_Mca_ODerecho, -2, 157, -2).addComponent(this.JCB_Mca_AOjos, -2, 157, -2)))).addGap(18, 18, 18).addComponent(this.JSPObservacion, -1, 337, 32767).addContainerGap()));
        JPI_DatosELayout.setVerticalGroup(JPI_DatosELayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DatosELayout.createSequentialGroup().addContainerGap().addGroup(JPI_DatosELayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(JPI_DatosELayout.createSequentialGroup().addComponent(this.JLB_1).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCB_Mca_ODerecho, -2, 50, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCB_Mca_OIzquierdo, -2, 50, -2).addGap(12, 12, 12).addComponent(this.JCB_Mca_AOjos, -2, 50, -2)).addGroup(JPI_DatosELayout.createSequentialGroup().addComponent(this.JLB_).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCB_Msa_ODerecho, -2, 50, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCB_Msa_OIzquierdo, -2, 50, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCB_Msa_AOjos, -2, 50, -2)).addComponent(this.JSPObservacion)).addContainerGap(17, 32767)));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JTBDetalle.setFont(new Font("Arial", 1, 12));
        this.JTBDetalle.setRowHeight(25);
        this.JTBDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTBDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JSPDetalle.setViewportView(this.JTBDetalle);
        this.JTF_Id.setFont(new Font("Arial", 1, 24));
        this.JTF_Id.setHorizontalAlignment(0);
        this.JTF_Id.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Nota", 1, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPI_DatosE, -1, -1, 32767).addComponent(this.JSPDetalle).addGroup(layout.createSequentialGroup().addComponent(this.JTF_Id, -2, 162, -2).addGap(0, 0, 32767))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPI_DatosE, -2, -1, -2).addGap(18, 18, 18).addComponent(this.JSPDetalle, -2, 239, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 15, 32767).addComponent(this.JTF_Id, -2, 50, -2).addContainerGap()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTPObservacionKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 9) {
            this.JTPObservacion.transferFocus();
        } else if (evt.getKeyCode() == 222) {
            JOptionPane.showInternalMessageDialog(this, "Caracter(') no valido, \nFavor reemplazarlo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTPObservacion.setText(this.JTPObservacion.getText().substring(0, this.JTPObservacion.getText().length() - 1));
        }
    }

    private void mNuevo() {
        this.JTF_Id.setText("");
        this.xsql = "SELECT  `Id` , `Nbre` , `Resultado` FROM `so_tipo_resultado_visiometria` WHERE (`Estado` =1) ORDER BY `Nbre` ASC";
        this.JCB_Msa_AOjos.removeAllItems();
        this.xId1 = this.xct.llenarComboyLista(this.xsql, this.xId1, this.JCB_Msa_AOjos, 3);
        this.JCB_Msa_ODerecho.removeAllItems();
        this.xId2 = this.xct.llenarComboyLista(this.xsql, this.xId2, this.JCB_Msa_ODerecho, 3);
        this.JCB_Msa_OIzquierdo.removeAllItems();
        this.xId3 = this.xct.llenarComboyLista(this.xsql, this.xId3, this.JCB_Msa_OIzquierdo, 3);
        this.JCB_Mca_AOjos.removeAllItems();
        this.xId4 = this.xct.llenarComboyLista(this.xsql, this.xId4, this.JCB_Mca_AOjos, 3);
        this.JCB_Mca_ODerecho.removeAllItems();
        this.xId5 = this.xct.llenarComboyLista(this.xsql, this.xId5, this.JCB_Mca_ODerecho, 3);
        this.JCB_Mca_OIzquierdo.removeAllItems();
        this.xId6 = this.xct.llenarComboyLista(this.xsql, this.xId6, this.JCB_Mca_OIzquierdo, 3);
        this.JTPObservacion.setText("");
        this.JCB_Msa_ODerecho.requestFocus();
        mCargarDatosTabla();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTabla() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Fecha y Hora", "Msa_ODer", "Msa_OIzq", "Msa_AmbosO", "Mca_ODer", "Mca_OIzq", "Mca_AmbosO", "Observación", "Profesional"}) { // from class: Historia.JPI_Test_AgudezaVisual.2
            Class[] types = {Long.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTBDetalle.setModel(this.xmodelo);
        this.JTBDetalle.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(1).setPreferredWidth(50);
        this.JTBDetalle.getColumnModel().getColumn(2).setPreferredWidth(20);
        this.JTBDetalle.getColumnModel().getColumn(3).setPreferredWidth(20);
        this.JTBDetalle.getColumnModel().getColumn(4).setPreferredWidth(20);
        this.JTBDetalle.getColumnModel().getColumn(5).setPreferredWidth(20);
        this.JTBDetalle.getColumnModel().getColumn(6).setPreferredWidth(20);
        this.JTBDetalle.getColumnModel().getColumn(7).setPreferredWidth(20);
        this.JTBDetalle.getColumnModel().getColumn(8).setPreferredWidth(100);
        this.JTBDetalle.getColumnModel().getColumn(9).setPreferredWidth(100);
    }

    private void mCargarDatosTabla() {
        try {
            mCrearTabla();
            this.xsql = "SELECT  `h_atencion_test_agudezavisual`.`Id` , CONCAT(`h_atencion`.`Fecha_Atencion` ,' ', `h_atencion`.`Hora_Atencion`) AS Fecha , `h_atencion_test_agudezavisual`.`Msa_ODer` , `h_atencion_test_agudezavisual`.`Msa_OIzq` , `h_atencion_test_agudezavisual`.`Msa_AmbosO` , `h_atencion_test_agudezavisual`.`Mca_ODer` , `h_atencion_test_agudezavisual`.`Mca_OIzq` , `h_atencion_test_agudezavisual`.`Mca_AmbosO`  ,   h_atencion_test_agudezavisual.`Observacion`,`profesional1`.`NProfesional`,`profesional1`.`Especialidad`, h_atencion_test_agudezavisual.Id_Atencion FROM `h_atencion_test_agudezavisual` INNER JOIN `h_atencion`  ON (`h_atencion_test_agudezavisual`.`Id_Atencion` = `h_atencion`.`Id`) INNER JOIN `ingreso`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`) INNER JOIN `profesional1`  ON (`profesional1`.`IdEspecialidad` = `h_atencion`.`Id_Especialidad`) AND (`profesional1`.`Id_Persona` = `h_atencion`.`Id_Profesional`) WHERE (`h_atencion_test_agudezavisual`.`Estado` =1 AND `ingreso`.`Id_Usuario` ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "') ORDER BY `h_atencion`.`Fecha_Atencion` DESC, `h_atencion`.`Hora_Atencion` ASC";
            ResultSet rs = this.xct.traerRs(this.xsql);
            if (rs.next()) {
                rs.beforeFirst();
                this.xmt.mEstablecerTextEditor(this.JTBDetalle, 1);
                this.xmt.mEstablecerTextEditor(this.JTBDetalle, 8);
                this.xmt.mEstablecerTextEditor(this.JTBDetalle, 9);
                int i = 0;
                while (rs.next()) {
                    if (clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion().equals(rs.getString(12))) {
                        this.JCB_Msa_ODerecho.setSelectedItem(rs.getString(3));
                        this.JCB_Msa_OIzquierdo.setSelectedItem(rs.getString(4));
                        this.JCB_Msa_AOjos.setSelectedItem(rs.getString(5));
                        this.JCB_Mca_ODerecho.setSelectedItem(rs.getString(6));
                        this.JCB_Mca_OIzquierdo.setSelectedItem(rs.getString(7));
                        this.JCB_Mca_AOjos.setSelectedItem(rs.getString(8));
                        this.JTPObservacion.setText(rs.getString(9));
                    }
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(Long.valueOf(rs.getLong(1)), i, 0);
                    this.xmodelo.setValueAt(rs.getString(2), i, 1);
                    this.xmodelo.setValueAt(rs.getString(3), i, 2);
                    this.xmodelo.setValueAt(rs.getString(4), i, 3);
                    this.xmodelo.setValueAt(rs.getString(5), i, 4);
                    this.xmodelo.setValueAt(rs.getString(6), i, 5);
                    this.xmodelo.setValueAt(rs.getString(7), i, 6);
                    this.xmodelo.setValueAt(rs.getString(8), i, 7);
                    this.xmodelo.setValueAt(rs.getString(9), i, 8);
                    this.xmodelo.setValueAt(rs.getString(10) + "\n" + rs.getString(11), i, 9);
                    i++;
                }
                this.xmt.cambiarEstadoValidadoItemHC(getName(), 1, true);
            }
            rs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPI_Test_AgudezaVisual.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mGrabar() {
        if (this.JTF_Id.getText().isEmpty()) {
            if (this.JCB_Msa_ODerecho.getSelectedIndex() != -1) {
                if (this.JCB_Msa_OIzquierdo.getSelectedIndex() != -1) {
                    if (this.JCB_Msa_AOjos.getSelectedIndex() != -1) {
                        if (this.JCB_Mca_ODerecho.getSelectedIndex() != -1) {
                            if (this.JCB_Mca_OIzquierdo.getSelectedIndex() != -1) {
                                if (this.JCB_Mca_AOjos.getSelectedIndex() != -1) {
                                    int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                                    if (x == 0) {
                                        this.xsql = "insert into h_atencion_test_agudezavisual(`Id_Atencion` , `Msa_ODer` , `Msa_OIzq` , `Msa_AmbosO` , `Mca_ODer` , `Mca_OIzq` , `Mca_AmbosO` , `Observacion` , `Id_UsuarioS` ) values('" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "','" + this.JCB_Msa_ODerecho.getSelectedItem() + "','" + this.JCB_Msa_OIzquierdo.getSelectedItem() + "','" + this.JCB_Msa_AOjos.getSelectedItem() + "','" + this.JCB_Mca_ODerecho.getSelectedItem() + "','" + this.JCB_Mca_OIzquierdo.getSelectedItem() + "','" + this.JCB_Mca_AOjos.getSelectedItem() + "','" + this.JTPObservacion.getText() + "','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "')";
                                        this.JTF_Id.setText(this.xct.ejecutarSQLId(this.xsql));
                                        this.xct.cerrarConexionBd();
                                        this.xmt.cambiarEstadoValidadoItemHC(getName(), 1, true);
                                        mCargarDatosTabla();
                                        return;
                                    }
                                    return;
                                }
                                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar items", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                this.JCB_Mca_AOjos.requestFocus();
                                return;
                            }
                            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar items", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                            this.JCB_Mca_OIzquierdo.requestFocus();
                            return;
                        }
                        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar items", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        this.JCB_Mca_ODerecho.requestFocus();
                        return;
                    }
                    JOptionPane.showInternalMessageDialog(this, "Debe seleccionar items", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    this.JCB_Msa_AOjos.requestFocus();
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar items", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JCB_Msa_OIzquierdo.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar items", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCB_Msa_ODerecho.requestFocus();
        }
    }
}
