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

/* JADX INFO: loaded from: GenomaP.jar:ParametrizacionN/JIFGrupoUvr.class */
public class JIFGrupoUvr extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private String[] xtiposala;
    private String[] xmanual;
    private Object[] xdatos;
    private String xnombre;
    private JComboBox JCBTipoSala;
    private JComboBox JCBTipomanuelqx;
    private JPanel JPDatod;
    private JTable JTDetalle;
    private JTextField JTFNombre;
    private JTextField JTXAyudante;
    private JTextField JTXFAnestesia;
    private JTextField JTXFMaterial;
    private JTextField JTXFMedGer;
    private JTextField JTXFMedesp;
    private JTextField JTXFOrden;
    private JTextField JTXFPerfusion;
    private JTextField JTXFSala;
    private JTextField JTXTFId;
    private JPanel jPanel1;
    private JScrollPane jScrollPane1;
    private ConsultasMySQL xconsulta = new ConsultasMySQL();
    private int xestado = 1;
    String sql = null;
    private Metodos xmetodos = new Metodos();

    public JIFGrupoUvr() {
        initComponents();
        mCargarDatosTabla();
        mIniciarComponentes();
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v87, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPDatod = new JPanel();
        this.JTXFOrden = new JTextField();
        this.JTFNombre = new JTextField();
        this.JCBTipomanuelqx = new JComboBox();
        this.JCBTipoSala = new JComboBox();
        this.JTXTFId = new JTextField();
        this.jPanel1 = new JPanel();
        this.JTXFMedGer = new JTextField();
        this.JTXFMedesp = new JTextField();
        this.JTXFAnestesia = new JTextField();
        this.JTXAyudante = new JTextField();
        this.JTXFSala = new JTextField();
        this.JTXFMaterial = new JTextField();
        this.JTXFPerfusion = new JTextField();
        this.jScrollPane1 = new JScrollPane();
        this.JTDetalle = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("GRUPOUVR");
        setFocusable(false);
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("GrupoUvr");
        this.JPDatod.setBorder(BorderFactory.createTitledBorder((Border) null, "INFOMACIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JPDatod.setForeground(new Color(0, 103, 0));
        this.JTXFOrden.setFont(new Font("Arial", 1, 12));
        this.JTXFOrden.setBorder(BorderFactory.createTitledBorder((Border) null, "Orden", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTXFOrden.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFGrupoUvr.1
            public void actionPerformed(ActionEvent evt) {
                JIFGrupoUvr.this.JTXFOrdenActionPerformed(evt);
            }
        });
        this.JTFNombre.setFont(new Font("Arial", 1, 12));
        this.JTFNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTipomanuelqx.setFont(new Font("Arial", 1, 12));
        this.JCBTipomanuelqx.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Manual Qx", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTipoSala.setFont(new Font("Arial", 1, 12));
        this.JCBTipoSala.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Sala", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTXTFId.setFont(new Font("Arial", 1, 12));
        this.JTXTFId.setBorder(BorderFactory.createTitledBorder((Border) null, "ID", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jPanel1.setBorder(BorderFactory.createEtchedBorder());
        this.JTXFMedGer.setFont(new Font("Arial", 1, 12));
        this.JTXFMedGer.setBorder(BorderFactory.createTitledBorder((Border) null, "MedGer", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTXFMedesp.setFont(new Font("Arial", 1, 12));
        this.JTXFMedesp.setBorder(BorderFactory.createTitledBorder((Border) null, "MedEsp", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTXFAnestesia.setFont(new Font("Arial", 1, 12));
        this.JTXFAnestesia.setBorder(BorderFactory.createTitledBorder((Border) null, "Anestesia", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTXAyudante.setFont(new Font("Arial", 1, 12));
        this.JTXAyudante.setBorder(BorderFactory.createTitledBorder((Border) null, "Ayudante", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTXAyudante.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFGrupoUvr.2
            public void actionPerformed(ActionEvent evt) {
                JIFGrupoUvr.this.JTXAyudanteActionPerformed(evt);
            }
        });
        this.JTXFSala.setFont(new Font("Arial", 1, 12));
        this.JTXFSala.setBorder(BorderFactory.createTitledBorder((Border) null, "Sala", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTXFMaterial.setFont(new Font("Arial", 1, 12));
        this.JTXFMaterial.setBorder(BorderFactory.createTitledBorder((Border) null, "Material", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTXFPerfusion.setFont(new Font("Arial", 1, 12));
        this.JTXFPerfusion.setBorder(BorderFactory.createTitledBorder((Border) null, "Perfusion", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(4, 4, 4).addComponent(this.JTXFMedGer, -2, 120, -2).addGap(9, 9, 9).addComponent(this.JTXFMedesp, -2, 120, -2).addGap(10, 10, 10).addComponent(this.JTXFAnestesia, -2, 122, -2).addGap(10, 10, 10).addComponent(this.JTXAyudante, -2, 120, -2).addGap(10, 10, 10).addComponent(this.JTXFSala, -2, 121, -2).addGap(12, 12, 12).addComponent(this.JTXFMaterial, -2, 120, -2).addGap(10, 10, 10).addComponent(this.JTXFPerfusion, -2, 120, -2).addContainerGap(18, 32767)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.JTXFMedGer, -2, 50, -2)).addGroup(jPanel1Layout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.JTXFMedesp, -2, 50, -2)).addGroup(jPanel1Layout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.JTXFAnestesia, -2, 50, -2)).addGroup(jPanel1Layout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.JTXAyudante, -2, 50, -2)).addGroup(jPanel1Layout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.JTXFSala, -2, 50, -2)).addGroup(jPanel1Layout.createSequentialGroup().addGap(8, 8, 8).addComponent(this.JTXFMaterial, -2, 50, -2)).addGroup(jPanel1Layout.createSequentialGroup().addGap(8, 8, 8).addComponent(this.JTXFPerfusion, -2, 50, -2))).addContainerGap(-1, 32767)));
        GroupLayout JPDatodLayout = new GroupLayout(this.JPDatod);
        this.JPDatod.setLayout(JPDatodLayout);
        JPDatodLayout.setHorizontalGroup(JPDatodLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatodLayout.createSequentialGroup().addContainerGap().addGroup(JPDatodLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatodLayout.createSequentialGroup().addComponent(this.JTXTFId, -2, 101, -2).addGap(10, 10, 10).addComponent(this.JTXFOrden, -2, 127, -2)).addGroup(JPDatodLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JTFNombre, -2, 530, -2).addGroup(JPDatodLayout.createSequentialGroup().addComponent(this.JCBTipomanuelqx, -2, 398, -2).addGap(10, 10, 10).addComponent(this.JCBTipoSala, -2, 370, -2))).addComponent(this.jPanel1, -2, -1, -2)).addContainerGap(24, 32767)));
        JPDatodLayout.setVerticalGroup(JPDatodLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatodLayout.createSequentialGroup().addGap(7, 7, 7).addGroup(JPDatodLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFNombre, -2, 44, -2).addComponent(this.JTXFOrden, -2, 46, -2).addComponent(this.JTXTFId, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPDatodLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBTipomanuelqx, -2, 50, -2).addComponent(this.JCBTipoSala, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel1, -2, 72, -2).addContainerGap()));
        this.jScrollPane1.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "", 0, 0, new Font("Arial", 1, 14)));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFGrupoUvr.3
            public void mouseClicked(MouseEvent evt) {
                JIFGrupoUvr.this.JTDetalleMouseClicked(evt);
            }
        });
        this.jScrollPane1.setViewportView(this.JTDetalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(10, 10, 10).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPDatod, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addComponent(this.jScrollPane1)).addGap(10, 10, 10)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.JPDatod, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane1, -1, 230, 32767).addGap(10, 10, 10)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTXAyudanteActionPerformed(ActionEvent evt) {
    }

    private void mIniciarComponentes() {
        this.xtiposala = this.xconsulta.llenarCombo("SELECT `Id`  , `Nbre` FROM `q_tiposala` WHERE (`Id`) ORDER BY Nbre", this.xtiposala, this.JCBTipoSala);
        this.JCBTipoSala.setSelectedIndex(-1);
        this.xmanual = this.xconsulta.llenarCombo("SELECT `Id`  , `Nbre` FROM `q_tipomanualqx` WHERE (`Id`) ORDER BY Nbre", this.xmanual, this.JCBTipomanuelqx);
        this.JCBTipomanuelqx.setSelectedIndex(-1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        mcargardatosT();
    }

    private void mcargardatosT() {
        if (this.JTDetalle.getSelectedRow() != -1) {
            Principal.txtNo.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
            this.JTXTFId.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
            this.JTXFOrden.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString());
            this.JTFNombre.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString());
            this.JCBTipomanuelqx.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString());
            this.JCBTipoSala.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 4).toString());
            this.JTXFMedGer.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 5).toString());
            this.JTXFMedesp.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 6).toString());
            this.JTXFAnestesia.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 7).toString());
            this.JTXAyudante.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 8).toString());
            this.JTXFSala.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 9).toString());
            this.JTXFMaterial.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 10).toString());
            this.JTXFPerfusion.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 11).toString());
            this.JTXTFId.setEnabled(false);
            this.JCBTipoSala.setEnabled(false);
            this.JCBTipomanuelqx.setEnabled(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTXFOrdenActionPerformed(ActionEvent evt) {
    }

    public void mNuevo() {
        Principal.txtNo.setText("");
        this.JTXTFId.setText("");
        this.JTXFOrden.setText("");
        this.JTFNombre.setText("");
        this.JCBTipomanuelqx.setSelectedIndex(-1);
        this.JCBTipoSala.setSelectedIndex(-1);
        this.JTXFMedGer.setText("");
        this.JTXFMedesp.setText("");
        this.JTXFAnestesia.setText("");
        this.JTXAyudante.setText("");
        this.JTXFSala.setText("");
        this.JTXFMaterial.setText("");
        this.JTXFPerfusion.setText("");
        this.JTXTFId.setEnabled(true);
        this.JCBTipoSala.setEnabled(true);
        this.JCBTipomanuelqx.setEnabled(true);
        this.JTXTFId.requestFocus();
    }

    public void mGrabar() {
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            this.sql = null;
            if (Principal.txtNo.getText().isEmpty()) {
                this.sql = " Insert into q_grupouvr(`Id`,`Orden` , `Nbre` , `Id_TipoManualQX`, `Id_TipoSala` , `MedGer`, `MedEsp`, `Anestesia`, `Ayudante`, `Sala`, `Material`, `Perfusion`,`UsuarioS`)  values ('" + this.JTXTFId.getText().toUpperCase() + "','" + this.JTXFOrden.getText().toUpperCase() + "','" + this.JTFNombre.getText().toUpperCase() + "','" + this.xmanual[this.JCBTipomanuelqx.getSelectedIndex()] + "','" + this.xtiposala[this.JCBTipoSala.getSelectedIndex()] + "','" + this.JTXFMedGer.getText().toUpperCase() + "','" + this.JTXFMedesp.getText().toUpperCase() + "','" + this.JTXFAnestesia.getText().toUpperCase() + "','" + this.JTXAyudante.getText().toUpperCase() + "','" + this.JTXFSala.getText().toUpperCase() + "','" + this.JTXFMaterial.getText().toUpperCase() + "','" + this.JTXFPerfusion.getText().toUpperCase() + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
            } else {
                this.sql = "UPDATE q_grupouvr SET Orden = '" + this.JTXFOrden.getText().toUpperCase() + "',Nbre='" + this.JTFNombre.getText().toUpperCase() + "',Id_TipoManualQX='" + this.xmanual[this.JCBTipomanuelqx.getSelectedIndex()] + "',Id_TipoSala = '" + this.xtiposala[this.JCBTipoSala.getSelectedIndex()] + "',MedGer= '" + this.JTXFMedGer.getText().toUpperCase() + "',MedEsp='" + this.JTXFMedesp.getText().toUpperCase() + "',Anestesia='" + this.JTXFAnestesia.getText().toUpperCase() + "',Ayudante='" + this.JTXAyudante.getText().toUpperCase() + "',Sala='" + this.JTXFSala.getText().toUpperCase() + "',Material='" + this.JTXFMaterial.getText().toUpperCase() + "',Perfusion='" + this.JTXFMaterial.getText().toUpperCase() + "'Where Id='" + Principal.txtNo.getText() + "'";
            }
            this.xconsulta.ejecutarSQL(this.sql);
            this.xconsulta.cerrarConexionBd();
            mCargarDatosTabla();
            mNuevo();
        }
    }

    private void mvalidarG() {
        if (!this.JTXTFId.getText().isEmpty()) {
            if (!this.JTXFOrden.getText().isEmpty()) {
                if (!this.JTFNombre.getText().isEmpty()) {
                    if (this.JCBTipomanuelqx.getSelectedIndex() != -1) {
                        if (this.JCBTipoSala.getSelectedIndex() != -1) {
                            if (!this.JTXFMedGer.getText().isEmpty()) {
                                if (!this.JTXFMedesp.getText().isEmpty()) {
                                    if (!this.JTXFAnestesia.getText().isEmpty()) {
                                        if (!this.JTXAyudante.getText().isEmpty()) {
                                            if (!this.JTXFSala.getText().isEmpty()) {
                                                if (!this.JTXFMaterial.getText().isEmpty()) {
                                                    if (!this.JTXFPerfusion.getText().isEmpty()) {
                                                        mGrabar();
                                                        return;
                                                    } else {
                                                        JOptionPane.showInternalMessageDialog(this, "Debe Digitar un Perfusion", "VERFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                                        this.JTXFMaterial.requestFocus();
                                                        return;
                                                    }
                                                }
                                                JOptionPane.showInternalMessageDialog(this, "Debe Digitar un Material", "VERFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                                this.JTXFPerfusion.requestFocus();
                                                return;
                                            }
                                            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una Sala", "VERFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                            this.JTXFSala.requestFocus();
                                            return;
                                        }
                                        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un ayudante", "VERFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                        this.JTXAyudante.requestFocus();
                                        return;
                                    }
                                    JOptionPane.showInternalMessageDialog(this, "Debe Digitar un Cantidad de Anestesia", "VERFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                    this.JTXFAnestesia.requestFocus();
                                    return;
                                }
                                JOptionPane.showInternalMessageDialog(this, "Debe Digitar un Medesp", "VERFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                this.JTXFMedesp.requestFocus();
                                return;
                            }
                            JOptionPane.showInternalMessageDialog(this, "Debe Digitar un MedGer", "VERFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                            this.JTXFMedGer.requestFocus();
                            return;
                        }
                        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un tipo de Manual", "VERFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        this.JCBTipoSala.requestFocus();
                        return;
                    }
                    JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un tipo de Sala", "VERFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    this.JCBTipomanuelqx.requestFocus();
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Debe Digitar un Nombre ", "VERFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JTFNombre.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe Digitar una Orden ", "VERFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTXFOrden.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe Digitar un ID ", "VERFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JTXTFId.requestFocus();
    }

    private void mCargarDatosTabla() {
        try {
            mCrearModeloDatos();
            ResultSet xrs = this.xconsulta.traerRs("SELECT `q_grupouvr`.`Id`, `q_grupouvr`.`Orden`, `q_grupouvr`.`Nbre`, `q_tipomanualqx`.`Nbre` AS `manual qx`, `q_tiposala`.`Nbre` AS `tipo sala`, `q_grupouvr`.`MedGer`, `q_grupouvr`.`MedEsp`, `q_grupouvr`.`Anestesia`, `q_grupouvr`.`Ayudante`, `q_grupouvr`.`Sala`, `q_grupouvr`.`Material`, `q_grupouvr`.`Perfusion`FROM`q_tiposala`INNER JOIN `q_grupouvr`ON (`q_tiposala`.`Id` = `q_grupouvr`.`Id_TipoSala`)INNER JOIN `q_tipomanualqx`ON (`q_tipomanualqx`.`Id` = `q_grupouvr`.`Id_TipoManualQX`)ORDER BY `q_grupouvr`.`Nbre` ASC;");
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(1)), n, 0);
                    this.xmodelo.setValueAt(Integer.valueOf(xrs.getInt(2)), n, 1);
                    this.xmodelo.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelo.setValueAt(xrs.getString(4), n, 3);
                    this.xmodelo.setValueAt(xrs.getString(5), n, 4);
                    this.xmodelo.setValueAt(Integer.valueOf(xrs.getInt(6)), n, 5);
                    this.xmodelo.setValueAt(Integer.valueOf(xrs.getInt(7)), n, 6);
                    this.xmodelo.setValueAt(Integer.valueOf(xrs.getInt(8)), n, 7);
                    this.xmodelo.setValueAt(Integer.valueOf(xrs.getInt(9)), n, 8);
                    this.xmodelo.setValueAt(Integer.valueOf(xrs.getInt(10)), n, 9);
                    this.xmodelo.setValueAt(Integer.valueOf(xrs.getInt(11)), n, 10);
                    this.xmodelo.setValueAt(Integer.valueOf(xrs.getInt(12)), n, 11);
                    n++;
                }
            }
            xrs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFGrupoUvr.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Orden", "Nombre", "Tipo ManualQX", "Tipo Sala", "MedGer", "MedEsp", "Anestesia", "Ayudante", "Sala", "Material", "Perfusion"}) { // from class: ParametrizacionN.JIFGrupoUvr.4
            Class[] types = {Long.class, Integer.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(40);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(40);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(40);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(40);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(40);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(40);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(50);
    }

    public void meliminar() {
        if (this.JTDetalle.getSelectedRow() != -1) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de Anular ?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                String sqlup = " DELETE FROM q_grupouvr WHERE   Id = '" + this.JTXTFId.getText().toUpperCase() + "'";
                this.xconsulta.ejecutarSQL(sqlup);
                this.xconsulta.cerrarConexionBd();
                JOptionPane.showInternalMessageDialog(this, "Operacion Exitosa", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JTXTFId.setEnabled(true);
                this.JCBTipomanuelqx.setEnabled(true);
                this.JCBTipoSala.setEnabled(true);
                mNuevo();
                this.JTXTFId.requestFocus();
            } else {
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un registro", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            }
            mCargarDatosTabla();
            mNuevo();
        }
    }
}
