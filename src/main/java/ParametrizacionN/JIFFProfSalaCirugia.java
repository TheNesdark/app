package ParametrizacionN;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
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
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:ParametrizacionN/JIFFProfSalaCirugia.class */
public class JIFFProfSalaCirugia extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private Object[] xdatos;
    private String[] xIdSalaCirugia;
    private String[] xIdEspecialidad;
    private String[] xIdProfesional;
    private String xsql;
    private JComboBox JCBEspecialidad;
    private JComboBox JCBProfesional;
    private JComboBox JCBSalaCirugia;
    private JCheckBox JCHEstado;
    private JTable JTHistorico;
    private JPanel jPanel1;
    private JScrollPane jScrollPane1;
    private int xEstado = 1;
    private ConsultasMySQL xct = new ConsultasMySQL();
    private ConsultasMySQL xconsulta = new ConsultasMySQL();
    private boolean xlleno = false;
    private boolean xestadog = false;

    public JIFFProfSalaCirugia() {
        initComponents();
        mCargarDatosTabla();
        mLlenarComboEspecialidad();
        mLlenarComboSalaCirugia();
    }

    /* JADX WARN: Type inference failed for: r3v35, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jPanel1 = new JPanel();
        this.JCBSalaCirugia = new JComboBox();
        this.JCBProfesional = new JComboBox();
        this.JCBEspecialidad = new JComboBox();
        this.JCHEstado = new JCheckBox();
        this.jScrollPane1 = new JScrollPane();
        this.JTHistorico = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("PROFESIONALES SALA CIRUGÍA");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("Profesional Sala Cirugia");
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JCBSalaCirugia.setFont(new Font("Arial", 1, 12));
        this.JCBSalaCirugia.setBorder(BorderFactory.createTitledBorder((Border) null, "Sala de Cirugía", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBProfesional.setFont(new Font("Arial", 1, 12));
        this.JCBProfesional.setBorder(BorderFactory.createTitledBorder((Border) null, "Profesional", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBProfesional.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFProfSalaCirugia.1
            public void actionPerformed(ActionEvent evt) {
                JIFFProfSalaCirugia.this.JCBProfesionalActionPerformed(evt);
            }
        });
        this.JCBEspecialidad.setFont(new Font("Arial", 1, 12));
        this.JCBEspecialidad.setBorder(BorderFactory.createTitledBorder((Border) null, "Especialidad", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBEspecialidad.addItemListener(new ItemListener() { // from class: ParametrizacionN.JIFFProfSalaCirugia.2
            public void itemStateChanged(ItemEvent evt) {
                JIFFProfSalaCirugia.this.JCBEspecialidadItemStateChanged(evt);
            }
        });
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setSelected(true);
        this.JCHEstado.setText("Estado");
        this.JCHEstado.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFProfSalaCirugia.3
            public void actionPerformed(ActionEvent evt) {
                JIFFProfSalaCirugia.this.JCHEstadoActionPerformed(evt);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(23, 23, 23).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addComponent(this.JCBProfesional, 0, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHEstado)).addComponent(this.JCBSalaCirugia, 0, 535, 32767).addComponent(this.JCBEspecialidad, 0, -1, 32767)).addContainerGap(21, 32767)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JCBSalaCirugia, -2, 46, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBEspecialidad, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBProfesional, -2, 46, -2).addComponent(this.JCHEstado, -2, 43, -2)).addGap(3, 3, 3)));
        this.jScrollPane1.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTHistorico.setFont(new Font("Arial", 1, 12));
        this.JTHistorico.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTHistorico.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFFProfSalaCirugia.4
            public void mouseClicked(MouseEvent evt) {
                JIFFProfSalaCirugia.this.JTHistoricoMouseClicked(evt);
            }
        });
        this.jScrollPane1.setViewportView(this.JTHistorico);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap(-1, 32767).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jPanel1, -1, -1, 32767).addComponent(this.jScrollPane1))));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane1, -1, 198, 32767).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBProfesionalActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBEspecialidadItemStateChanged(ItemEvent evt) {
        if (this.xlleno && this.JCBEspecialidad.getSelectedIndex() != -1) {
            this.JCBProfesional.removeAllItems();
            this.xsql = "SELECT Id_Persona ,  NProfesional FROM profesional1 WHERE ( IdEspecialidad  ='" + this.xIdEspecialidad[this.JCBEspecialidad.getSelectedIndex()] + "' \n    AND  Estado  =0)GROUP BY  NProfesional ,  IdEspecialidad ORDER BY  NProfesional  ASC;";
            this.xIdProfesional = this.xconsulta.llenarCombo(this.xsql, this.xIdProfesional, this.JCBProfesional);
            this.JCBProfesional.setSelectedIndex(-1);
            this.xconsulta.cerrarConexionBd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTHistoricoMouseClicked(MouseEvent evt) {
        if (this.JTHistorico.getSelectedRow() != -1) {
            this.JCBSalaCirugia.setSelectedItem(this.xmodelo.getValueAt(this.JTHistorico.getSelectedRow(), 0).toString());
            this.JCBEspecialidad.setSelectedItem(this.xmodelo.getValueAt(this.JTHistorico.getSelectedRow(), 1).toString());
            this.JCBProfesional.setSelectedItem(this.xmodelo.getValueAt(this.JTHistorico.getSelectedRow(), 2).toString());
            this.JCHEstado.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTHistorico.getSelectedRow(), 3).toString()).booleanValue());
            if (this.JCHEstado.isSelected()) {
                this.xEstado = 1;
            } else {
                this.xEstado = 0;
            }
        }
        this.xestadog = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEstadoActionPerformed(ActionEvent evt) {
        if (this.JCHEstado.isSelected()) {
            this.xEstado = 1;
        } else {
            this.xEstado = 0;
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Sala de Cirugía", "Especialidad", "Profesional", "Estado"}) { // from class: ParametrizacionN.JIFFProfSalaCirugia.5
            Class[] types = {String.class, String.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTHistorico.setModel(this.xmodelo);
        this.JTHistorico.getColumnModel().getColumn(0).setPreferredWidth(180);
        this.JTHistorico.getColumnModel().getColumn(1).setPreferredWidth(180);
        this.JTHistorico.getColumnModel().getColumn(2).setPreferredWidth(180);
        this.JTHistorico.getColumnModel().getColumn(3).setPreferredWidth(100);
    }

    private void mCargarDatosTabla() {
        try {
            mCrearModeloDatos();
            ResultSet xrs = this.xconsulta.traerRs("SELECT `q_salacirugias`.`Nbre` AS `Sala`, `profesional1`.`Especialidad`, `profesional1`.`NProfesional`, `q_profsalacirugia`.`Estado`\nFROM `q_profsalacirugia` INNER JOIN `q_salacirugias` ON (`q_profsalacirugia`.`Id_SalaCirugia` = `q_salacirugias`.`Id`)\nINNER JOIN `profesional1` ON (`profesional1`.`Id_Persona` = `q_profsalacirugia`.`Id_Profesional`) AND (`profesional1`.`IdEspecialidad` = `q_profsalacirugia`.`Id_Especialidad`);");
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(xrs.getString(1), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(4)), n, 3);
                    n++;
                }
            }
            xrs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFFEmpresaProcedimiento.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mLlenarComboSalaCirugia() {
        this.xIdSalaCirugia = this.xct.llenarCombo("SELECT  Id ,  Nbre FROM q_salacirugias ", this.xIdSalaCirugia, this.JCBSalaCirugia);
        this.JCBSalaCirugia.setSelectedIndex(-1);
        this.xct.cerrarConexionBd();
    }

    private void mLlenarComboEspecialidad() {
        this.xIdEspecialidad = this.xct.llenarCombo("SELECT  IdEspecialidad ,  Especialidad  FROM profesional1 GROUP BY  IdEspecialidad ORDER BY  Especialidad  ASC", this.xIdEspecialidad, this.JCBEspecialidad);
        this.JCBEspecialidad.setSelectedIndex(-1);
        this.xct.cerrarConexionBd();
        this.xlleno = true;
    }

    public void mNuevo() {
        this.JCBEspecialidad.setSelectedIndex(-1);
        this.JCBProfesional.setSelectedIndex(-1);
        this.JCBSalaCirugia.setSelectedIndex(-1);
        this.xlleno = true;
        this.xestadog = false;
    }

    public void mGrabar() {
        if (this.JCBSalaCirugia.getSelectedIndex() != -1) {
            if (this.JCBEspecialidad.getSelectedIndex() != -1) {
                if (this.JCBProfesional.getSelectedIndex() != -1) {
                    int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    if (n == 0) {
                        if (!this.xestadog) {
                            this.xsql = " INSERT IGNORE INTO  q_profsalacirugia  ( Id_SalaCirugia , Id_Profesional , Id_Especialidad , Estado , UsuarioS ) values ('" + this.xIdSalaCirugia[this.JCBSalaCirugia.getSelectedIndex()] + "','" + this.xIdProfesional[this.JCBProfesional.getSelectedIndex()] + "','" + this.xIdEspecialidad[this.JCBEspecialidad.getSelectedIndex()] + "','" + this.xEstado + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                        } else {
                            this.xsql = "UPDATE q_profsalacirugia SET  Estado  = '" + this.xEstado + "' WHERE Id_SalaCirugia  = '" + this.xIdSalaCirugia[this.JCBSalaCirugia.getSelectedIndex()] + "' AND Id_Profesional = '" + this.xIdProfesional[this.JCBProfesional.getSelectedIndex()] + "' AND Id_Especialidad  = '" + this.xIdEspecialidad[this.JCBEspecialidad.getSelectedIndex()] + "'";
                        }
                        System.out.println("Consulta-->" + this.xsql);
                        this.xconsulta.ejecutarSQL(this.xsql);
                        this.xconsulta.cerrarConexionBd();
                        mCargarDatosTabla();
                    }
                } else {
                    JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un profesional", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    this.JCBProfesional.requestFocus();
                }
            } else {
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una especialidad", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JCBEspecialidad.requestFocus();
            }
        } else {
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una Sala", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBSalaCirugia.requestFocus();
        }
        mNuevo();
    }
}
