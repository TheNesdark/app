package ParametrizacionN;

import Acceso.Principal;
import General.JIFBuscarPatologia;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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

/* JADX INFO: loaded from: GenomaP.jar:ParametrizacionN/JIFReportePatologia.class */
public class JIFReportePatologia extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private Object[] xdatos;
    private String xnombre;
    private String xid;
    private String[] xidgenerico1;
    private String[] xidgenerico2;
    private String[] xidgenerico3;
    private JComboBox JCBPrograma;
    private JComboBox JCBTEntidad;
    private JCheckBox JCHEstado;
    private JPanel JPIDatos;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;
    public JTextField JTFCDxP;
    public JTextField JTFFNVariable;
    private JTextField JTFNCodigoDxP;
    private ConsultasMySQL xconsulta = new ConsultasMySQL();
    private Metodos xmetodos = new Metodos();
    private int xestado = 1;
    private int xesgrupo = 0;
    private boolean xestadog = false;
    private boolean xlleno = false;

    public JIFReportePatologia(String xnombre, String xtitulo) {
        initComponents();
        setTitle(xtitulo.toUpperCase());
        setName(xnombre);
        this.xnombre = xnombre;
        mIniciarComponentes();
    }

    /* JADX WARN: Type inference failed for: r3v46, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPIDatos = new JPanel();
        this.JCBTEntidad = new JComboBox();
        this.JCBPrograma = new JComboBox();
        this.JCHEstado = new JCheckBox();
        this.JTFCDxP = new JTextField();
        this.JTFNCodigoDxP = new JTextField();
        this.JTFFNVariable = new JTextField();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("SUBGRUPO FACTURA");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setMinimumSize(null);
        setName("jifreportepatologia");
        setNormalBounds(new Rectangle(0, 0, 0, 0));
        try {
            setSelected(true);
        } catch (PropertyVetoException e1) {
            e1.printStackTrace();
        }
        addInternalFrameListener(new InternalFrameListener() { // from class: ParametrizacionN.JIFReportePatologia.1
            public void internalFrameActivated(InternalFrameEvent evt) {
            }

            public void internalFrameClosed(InternalFrameEvent evt) {
                JIFReportePatologia.this.formInternalFrameClosed(evt);
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
            }

            public void internalFrameDeactivated(InternalFrameEvent evt) {
            }

            public void internalFrameDeiconified(InternalFrameEvent evt) {
            }

            public void internalFrameIconified(InternalFrameEvent evt) {
            }

            public void internalFrameOpened(InternalFrameEvent evt) {
            }
        });
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JCBTEntidad.setFont(new Font("Arial", 1, 12));
        this.JCBTEntidad.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Entidad", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTEntidad.addItemListener(new ItemListener() { // from class: ParametrizacionN.JIFReportePatologia.2
            public void itemStateChanged(ItemEvent evt) {
                JIFReportePatologia.this.JCBTEntidadItemStateChanged(evt);
            }
        });
        this.JCBPrograma.setFont(new Font("Arial", 1, 12));
        this.JCBPrograma.setBorder(BorderFactory.createTitledBorder((Border) null, "Programa", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setSelected(true);
        this.JCHEstado.setText("Estado");
        this.JCHEstado.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFReportePatologia.3
            public void actionPerformed(ActionEvent evt) {
                JIFReportePatologia.this.JCHEstadoActionPerformed(evt);
            }
        });
        this.JTFCDxP.setFont(new Font("Arial", 1, 12));
        this.JTFCDxP.setBorder(BorderFactory.createTitledBorder((Border) null, "Código", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFCDxP.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFReportePatologia.4
            public void actionPerformed(ActionEvent evt) {
                JIFReportePatologia.this.JTFCDxPActionPerformed(evt);
            }
        });
        this.JTFCDxP.addFocusListener(new FocusAdapter() { // from class: ParametrizacionN.JIFReportePatologia.5
            public void focusLost(FocusEvent evt) {
                JIFReportePatologia.this.JTFCDxPFocusLost(evt);
            }
        });
        this.JTFNCodigoDxP.setFont(new Font("Arial", 1, 12));
        this.JTFNCodigoDxP.setBorder(BorderFactory.createTitledBorder((Border) null, "Patología", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFNCodigoDxP.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFReportePatologia.6
            public void mouseClicked(MouseEvent evt) {
                JIFReportePatologia.this.JTFNCodigoDxPMouseClicked(evt);
            }
        });
        this.JTFNCodigoDxP.addKeyListener(new KeyAdapter() { // from class: ParametrizacionN.JIFReportePatologia.7
            public void keyPressed(KeyEvent evt) {
                JIFReportePatologia.this.JTFNCodigoDxPKeyPressed(evt);
            }
        });
        this.JTFFNVariable.setFont(new Font("Arial", 1, 12));
        this.JTFFNVariable.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre Variable", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JTFCDxP, -2, 71, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFNCodigoDxP, -2, 451, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFFNVariable)).addComponent(this.JCBPrograma, GroupLayout.Alignment.TRAILING, 0, 660, 32767).addComponent(this.JCBTEntidad, GroupLayout.Alignment.TRAILING, 0, -1, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 27, 32767).addComponent(this.JCHEstado).addContainerGap()));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JCBTEntidad, -2, -1, -2).addGap(18, 18, 18).addComponent(this.JCBPrograma, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFNCodigoDxP, -2, -1, -2).addComponent(this.JTFFNVariable, -2, -1, -2)).addComponent(this.JTFCDxP, -2, -1, -2).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosLayout.createSequentialGroup().addComponent(this.JCHEstado).addGap(17, 17, 17))).addContainerGap(-1, 32767)));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionMode(0);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFReportePatologia.8
            public void mouseClicked(MouseEvent evt) {
                JIFReportePatologia.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JSPDetalle, -2, 780, -2).addContainerGap(-1, 32767)).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.JPIDatos, -2, -1, -2).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, 190, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPDetalle, -2, 275, -2).addContainerGap(-1, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            Principal.txtNo.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
            this.JTFCDxP.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
            this.JTFNCodigoDxP.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString());
            this.JCBTEntidad.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString());
            this.JCBPrograma.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString());
            this.JTFFNVariable.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 4).toString());
            this.JCHEstado.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 5).toString()).booleanValue());
            if (this.JCHEstado.isSelected()) {
                this.xestado = 1;
            } else {
                this.xestado = 0;
            }
            this.xestadog = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosed(InternalFrameEvent evt) {
        Principal.mLimpiarDatosP();
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
    public void JTFCDxPFocusLost(FocusEvent evt) {
        buscarPatologias(this.JTFCDxP, this.JTFNCodigoDxP, 0);
    }

    private void buscarPatologias(JTextField codigo, JTextField nombrep, int n) {
        if (!codigo.getText().isEmpty()) {
            try {
                String sql = "SELECT Id, Nbre FROM g_patologia where Id='" + codigo.getText().toUpperCase() + "'  and Estado=1 ";
                ResultSet res = this.xconsulta.traerRs(sql);
                res.next();
                if (res.getRow() != 0) {
                    nombrep.setText(res.getString(2));
                    codigo.setText(codigo.getText().toUpperCase());
                } else {
                    JOptionPane.showMessageDialog(this, "Codigo no existe", "BUSCAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    nombrep.setText((String) null);
                    codigo.setText((String) null);
                    codigo.requestFocus();
                }
                res.close();
                this.xconsulta.cerrarConexionBd();
            } catch (SQLException e) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNCodigoDxPMouseClicked(MouseEvent evt) {
        mBuscarPatologiaN(this.JTFCDxP, this.JTFNCodigoDxP);
    }

    private void mBuscarPatologiaN(JTextField codigo, JTextField nombrep) {
        JIFBuscarPatologia pac = new JIFBuscarPatologia(null, true, codigo, nombrep, "ReporteP", 0);
        pac.setVisible(true);
        pac.setLocationRelativeTo(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNCodigoDxPKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JTFNCodigoDxP.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCDxPActionPerformed(ActionEvent evt) {
        this.JTFNCodigoDxP.transferFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBTEntidadItemStateChanged(ItemEvent evt) {
        if (this.xlleno && this.JCBTEntidad.getSelectedIndex() != -1) {
            mCargarDatosTabla();
        }
    }

    public void mNuevo() {
        Principal.txtNo.setText("");
        this.xestado = 1;
        this.JTFCDxP.setText("");
        this.JTFNCodigoDxP.setText("");
        this.JCBTEntidad.setSelectedIndex(-1);
        this.JCBPrograma.setSelectedIndex(-1);
        this.JTFFNVariable.setText("");
    }

    public void mGrabar() {
        if (!this.JTFCDxP.getText().isEmpty() && !this.JTFNCodigoDxP.getText().isEmpty()) {
            if (this.JCBTEntidad.getSelectedIndex() != -1) {
                if (this.JCBPrograma.getSelectedIndex() != -1) {
                    int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    if (n == 0) {
                        if (Principal.txtNo.getText().isEmpty()) {
                            String sql = " Insert ignore into  r_patologiasreporte(`Id_Patologia` , `Id_TipoEntidadR` , `Id_Programa`,NVariable, `Estado`, `UsuarioS` , `Fecha`)  values ('" + this.JTFCDxP.getText() + "','" + this.xidgenerico2[this.JCBTEntidad.getSelectedIndex()] + "','" + this.xidgenerico3[this.JCBPrograma.getSelectedIndex()] + "','" + this.JTFFNVariable.getText().toUpperCase() + "','" + this.xestado + "','" + Principal.usuarioSistemaDTO.getLogin() + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "')";
                            this.xconsulta.ejecutarSQL(sql);
                            this.xconsulta.cerrarConexionBd();
                            mCargarDatosTabla();
                            return;
                        }
                        if (this.JTDetalle.getSelectedRow() != -1) {
                            String sql2 = " update r_patologiasreporte set NVariable='" + this.JTFFNVariable.getText().toUpperCase() + "', Estado='" + this.xestado + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where (Id_Patologia='" + this.JTFCDxP.getText() + "' AND Id_TipoEntidadR='" + this.xidgenerico2[this.JCBTEntidad.getSelectedIndex()] + "' AND Id_Programa='" + this.xidgenerico3[this.JCBPrograma.getSelectedIndex()] + "')";
                            this.xconsulta.ejecutarSQL(sql2);
                            this.xconsulta.cerrarConexionBd();
                            mCargarDatosTabla();
                            return;
                        }
                        return;
                    }
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un programa", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JCBPrograma.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un tipo de entidad", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBTEntidad.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una patología", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JTFNCodigoDxP.requestFocus();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos(String[] xcabecera) {
        this.xmodelo = new DefaultTableModel(new Object[0], xcabecera) { // from class: ParametrizacionN.JIFReportePatologia.9
            Class[] types = {String.class, String.class, String.class, String.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(15);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(10);
    }

    private void mCargarDatosTabla() {
        try {
            String[] xencabezado = {"Cod. Patología", "Patología", "Tipo Entidad", "Programa", "NVariable", "Estado"};
            String sql = "SELECT `r_patologiasreporte`.`Id_Patologia`, `g_patologia`.`Nbre` , `g_tipoentidad`.`Nbre` , `g_tipoprograma`.`Nbre`,r_patologiasreporte.NVariable ,r_patologiasreporte.Estado   FROM `r_patologiasreporte`  INNER JOIN `g_tipoentidad` ON (`r_patologiasreporte`.`Id_TipoEntidadR` = `g_tipoentidad`.`Id`) INNER JOIN `g_patologia` ON (`r_patologiasreporte`.`Id_Patologia` = `g_patologia`.`Id`) INNER JOIN `g_tipoprograma`  ON (`r_patologiasreporte`.`Id_Programa` = `g_tipoprograma`.`Id_TipoPrograma`) WHERE(`r_patologiasreporte`.`Id_TipoEntidadR`='" + this.xidgenerico2[this.JCBTEntidad.getSelectedIndex()] + "')   ORDER BY `g_patologia`.`Nbre`";
            mCrearModeloDatos(xencabezado);
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
                    this.xmodelo.setValueAt(xrs.getString(5), n, 4);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(6)), n, 5);
                    n++;
                }
            }
            xrs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFReportePatologia.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mIniciarComponentes() {
        this.xidgenerico2 = this.xconsulta.llenarCombo("SELECT Id, Nbre FROM g_tipoentidad WHERE (Estado =1) ORDER BY Nbre ASC", this.xidgenerico2, this.JCBTEntidad);
        this.JCBTEntidad.setSelectedIndex(-1);
        this.xidgenerico3 = this.xconsulta.llenarCombo("SELECT Id_TipoPrograma, Nbre FROM g_tipoprograma WHERE (Estado =0) ORDER BY Nbre ASC", this.xidgenerico3, this.JCBPrograma);
        this.JCBPrograma.setSelectedIndex(-1);
        this.xconsulta.cerrarConexionBd();
        this.xlleno = true;
    }
}
