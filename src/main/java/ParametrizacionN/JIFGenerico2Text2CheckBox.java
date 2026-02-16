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
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:ParametrizacionN/JIFGenerico2Text2CheckBox.class */
public class JIFGenerico2Text2CheckBox extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private Object[] xdatos;
    private String xnombre;
    private JCheckBox JCHEspecial;
    private JCheckBox JCHEstado;
    private JPanel JPIDatos;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;
    private JTextField JTFCodigo;
    private JTextField JTFCodigo1;
    private JTextField JTFNombre;
    private ConsultasMySQL xconsulta = new ConsultasMySQL();
    private Metodos xmetodos = new Metodos();
    private int xestado = 0;
    private int xespecial = 0;
    private String xid = "";
    private boolean xestadog = false;

    public JIFGenerico2Text2CheckBox(String xnombre, String xnombref) {
        initComponents();
        setName(xnombref);
        setTitle(xnombre.toUpperCase());
        this.xnombre = xnombre;
        mCargarDatosTabla();
        mIniciarComponentes();
    }

    /* JADX WARN: Type inference failed for: r3v34, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPIDatos = new JPanel();
        this.JTFNombre = new JTextField();
        this.JCHEstado = new JCheckBox();
        this.JCHEspecial = new JCheckBox();
        this.JTFCodigo = new JTextField();
        this.JTFCodigo1 = new JTextField();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("MUNICIPIO");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifgenerico2chbox2");
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
        this.JCHEstado.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFGenerico2Text2CheckBox.1
            public void actionPerformed(ActionEvent evt) {
                JIFGenerico2Text2CheckBox.this.JCHEstadoActionPerformed(evt);
            }
        });
        this.JCHEspecial.setFont(new Font("Arial", 1, 12));
        this.JCHEspecial.setText("Especial?");
        this.JCHEspecial.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFGenerico2Text2CheckBox.2
            public void actionPerformed(ActionEvent evt) {
                JIFGenerico2Text2CheckBox.this.JCHEspecialActionPerformed(evt);
            }
        });
        this.JTFCodigo.setFont(new Font("Arial", 1, 12));
        this.JTFCodigo.setToolTipText("");
        this.JTFCodigo.setBorder(BorderFactory.createTitledBorder((Border) null, "Código", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFCodigo.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFGenerico2Text2CheckBox.3
            public void actionPerformed(ActionEvent evt) {
                JIFGenerico2Text2CheckBox.this.JTFCodigoActionPerformed(evt);
            }
        });
        this.JTFCodigo1.setFont(new Font("Arial", 1, 12));
        this.JTFCodigo1.setToolTipText("");
        this.JTFCodigo1.setBorder(BorderFactory.createTitledBorder((Border) null, "Código Alf", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFCodigo1.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFGenerico2Text2CheckBox.4
            public void actionPerformed(ActionEvent evt) {
                JIFGenerico2Text2CheckBox.this.JTFCodigo1ActionPerformed(evt);
            }
        });
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosLayout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.JTFCodigo, -2, 86, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFNombre, -2, 375, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFCodigo1, -2, 86, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 17, 32767).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHEstado).addComponent(this.JCHEspecial, GroupLayout.Alignment.TRAILING)).addContainerGap()));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFNombre, -2, -1, -2).addComponent(this.JTFCodigo, -2, -1, -2).addComponent(this.JTFCodigo1, -2, -1, -2)).addGap(0, 0, 32767)).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosLayout.createSequentialGroup().addComponent(this.JCHEspecial).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 8, 32767).addComponent(this.JCHEstado))).addContainerGap()));
        this.JTFCodigo1.getAccessibleContext().setAccessibleName("CódigoAlf");
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalle.setSelectionMode(0);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFGenerico2Text2CheckBox.5
            public void mouseClicked(MouseEvent evt) {
                JIFGenerico2Text2CheckBox.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGap(10, 10, 10).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JSPDetalle).addComponent(this.JPIDatos, -1, -1, 32767)).addGap(10, 10, 10)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.JPIDatos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalle, -1, 339, 32767).addGap(10, 10, 10)));
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
            this.JTFCodigo.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
            this.JTFNombre.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString());
            this.JCHEspecial.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString()).booleanValue());
            if (!this.xnombre.equals("Forma Farmacéutica") || !this.xnombre.equals("Via de Administracion")) {
                if (this.JCHEspecial.isSelected()) {
                    this.xespecial = 1;
                } else {
                    this.xespecial = 0;
                }
            }
            this.JCHEstado.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString()).booleanValue());
            if (!this.xnombre.equals("Forma Farmacéutica") || !this.xnombre.equals("Via de Administracion")) {
                if (this.JCHEstado.isSelected()) {
                    this.xestado = 0;
                } else {
                    this.xestado = 1;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEspecialActionPerformed(ActionEvent evt) {
        if (this.JCHEspecial.isSelected()) {
            this.xespecial = 0;
        } else {
            this.xespecial = 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCodigoActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCodigo1ActionPerformed(ActionEvent evt) {
    }

    public void mNuevo() {
        Principal.txtNo.setText("");
        this.JTFNombre.setText("");
        this.JTFCodigo.setText("");
        this.JTFCodigo1.setText("");
        this.JCHEstado.setSelected(true);
        this.JCHEspecial.setSelected(false);
        this.xestado = 0;
        this.xespecial = 0;
        this.JTFNombre.requestFocus();
    }

    public void mGrabar() {
        if (!this.JTFCodigo.getText().isEmpty()) {
            if (!this.JTFNombre.getText().isEmpty()) {
                int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (n == 0) {
                    String sql = null;
                    if (Principal.txtNo.getText().isEmpty()) {
                        if (this.xnombre.equals("Forma Farmacéutica")) {
                            sql = " Insert into i_formafarmaceutica (`Id`  , `Nbre`  , `EsTopico` , `Estado`, Fecha, UsuarioS,`codigo`)  values ('" + this.JTFCodigo.getText() + "','" + this.JTFNombre.getText().toUpperCase() + "','" + this.xespecial + "','" + this.xestado + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "','" + this.JTFCodigo1.getText() + "')";
                        }
                        if (this.xnombre.equals("Via de Administracion")) {
                            sql = " Insert into i_viaadministracion (`Id`  , `Nbre`  , `AplicaHC` , `Estado`, Fecha, UsuarioS)  values ('" + this.JTFCodigo.getText() + "','" + this.JTFNombre.getText().toUpperCase() + "','" + this.xespecial + "','" + this.xestado + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                        }
                        if (this.xnombre.equals("Tipo Sala")) {
                            if (this.JCHEstado.isSelected()) {
                                this.xestado = 1;
                            } else {
                                this.xestado = 0;
                            }
                            sql = " Insert into q_tiposala (`Id`  , `Nbre`  , `InCruento` , `Estado`, Fecha, UsuarioS)  values ('" + this.JTFCodigo.getText() + "','" + this.JTFNombre.getText().toUpperCase() + "','" + this.xespecial + "','" + this.xestado + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                        }
                        if (this.xnombre.equals("Tipo Clase Precedimiento")) {
                            if (this.JCHEstado.isSelected()) {
                                this.xestado = 1;
                            } else {
                                this.xestado = 0;
                            }
                            sql = " Insert into f_tipoclaseproc (`Id`  , `Nbre`  , `InCruento` , `Estado`, Fecha, UsuarioS)  values ('" + this.JTFCodigo.getText() + "','" + this.JTFNombre.getText().toUpperCase() + "','" + this.xespecial + "','" + this.xestado + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                        }
                        if (this.xnombre.equals("Tipo Parentesco")) {
                            if (this.JCHEstado.isSelected()) {
                                this.xestado = 0;
                            } else {
                                this.xestado = 1;
                            }
                            if (this.JCHEspecial.isSelected()) {
                                this.xespecial = 0;
                            } else {
                                this.xespecial = 1;
                            }
                            sql = "INSERT INTO `g_parentesco`(`Id`,`Nbre`,`EsTrabajador`,`Estado`,`Fecha`,`UsuarioS`)VALUES ('" + this.JTFCodigo.getText() + "','" + this.JTFNombre.getText() + "','" + this.xespecial + "','" + this.xestado + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                        }
                    } else {
                        if (this.xnombre.equals("Forma Farmacéutica")) {
                            sql = " update i_formafarmaceutica set Id='" + this.JTFCodigo.getText() + "' , Nbre='" + this.JTFNombre.getText().toUpperCase() + "',EsTopico='" + this.xespecial + "',Estado='" + this.xestado + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
                        }
                        if (this.xnombre.equals("Via de Administracion")) {
                            sql = " update i_viaadministracion set Id='" + this.JTFCodigo.getText() + "' , Nbre='" + this.JTFNombre.getText().toUpperCase() + "',AplicaHC='" + this.xespecial + "',Estado='" + this.xestado + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
                        }
                        if (this.xnombre.equals("Tipo Sala")) {
                            if (this.JCHEstado.isSelected()) {
                                this.xestado = 1;
                            } else {
                                this.xestado = 0;
                            }
                            sql = " update q_tiposala set Id='" + this.JTFCodigo.getText() + "' , Nbre='" + this.JTFNombre.getText().toUpperCase() + "',InCruento='" + this.xespecial + "',Estado='" + this.xestado + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
                        }
                        if (this.xnombre.equals("Tipo Clase Precedimiento")) {
                            if (this.JCHEstado.isSelected()) {
                                this.xestado = 1;
                            } else {
                                this.xestado = 0;
                            }
                            sql = " update f_tipoclaseproc set Id='" + this.JTFCodigo.getText() + "' , Nbre='" + this.JTFNombre.getText().toUpperCase() + "',InCruento='" + this.xespecial + "',Estado='" + this.xestado + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
                        }
                        if (this.xnombre.equals("Tipo Parentesco")) {
                            if (this.JCHEstado.isSelected()) {
                                this.xestado = 0;
                            } else {
                                this.xestado = 1;
                            }
                            if (this.JCHEspecial.isSelected()) {
                                this.xespecial = 0;
                            } else {
                                this.xespecial = 1;
                            }
                            sql = " update g_parentesco set Id='" + this.JTFCodigo.getText() + "',Nbre='" + this.JTFNombre.getText() + "',EsTrabajador='" + this.xespecial + "',Estado='" + this.xestado + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
                        }
                    }
                    this.xconsulta.ejecutarSQL(sql);
                    this.xconsulta.cerrarConexionBd();
                    mCargarDatosTabla();
                    mNuevo();
                    return;
                }
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "El campo nombre no puede ser nulo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTFNombre.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "El campo Código no puede ser nulo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JTFCodigo.requestFocus();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos(String[] xcabecera) {
        this.xmodelo = new DefaultTableModel(new Object[0], xcabecera) { // from class: ParametrizacionN.JIFGenerico2Text2CheckBox.6
            Class[] types = {String.class, String.class, Boolean.class, Boolean.class, String.class};
            boolean[] canEdit = {false, false, false, false};

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
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(15);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(15);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(25);
    }

    private void mCargarDatosTabla() {
        try {
            String[] xencabezado = null;
            String sql = null;
            if (this.xnombre.equals("Forma Farmacéutica")) {
                xencabezado = new String[]{"Id", "Nombre", "Es Tópico?", "Estado", "Codigo"};
                sql = "SELECT  `Id`  , `Nbre`  , `EsTopico` , IF(`Estado`=0, TRUE, FALSE) as Estado,`codigo`  FROM `i_formafarmaceutica` ORDER BY Nbre ASC";
            } else if (this.xnombre.equals("Via de Administracion")) {
                xencabezado = new String[]{"Id", "Nombre", "AplicaHC", "Estado"};
                sql = "SELECT  `Id`  , `Nbre`  , `AplicaHC` , IF(`Estado`=0, TRUE, FALSE) as Estado  FROM `i_viaadministracion` ORDER BY Nbre ASC";
            } else if (this.xnombre.equals("Tipo Sala")) {
                xencabezado = new String[]{"Id", "Nombre", "InCruento", "Estado"};
                sql = "SELECT  `Id`  , `Nbre`  , `InCruento` , IF(`Estado`=1, TRUE, FALSE) as Estado  FROM `q_tiposala` ORDER BY Nbre ASC";
            } else if (this.xnombre.equals("Tipo Clase Procedimiento")) {
                xencabezado = new String[]{"Id", "Nombre", "EsQco", "Estado"};
                sql = "SELECT  `Id`  , `Nbre`  , `EsQco` , IF(`Estado`=0, TRUE, FALSE) as Estado  FROM `f_tipoclaseproc` ORDER BY Id ASC";
            } else if (this.xnombre.equals("Tipo Parentesco")) {
                xencabezado = new String[]{"Id", "Nombre", "EsTrabajador", "Estado"};
                sql = "SELECT `Id`, `Nbre` , EsTrabajador , Estado FROM g_parentesco ORDER BY Id ASC";
            }
            mCrearModeloDatos(xencabezado);
            ResultSet xrs = this.xconsulta.traerRs(sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(xrs.getString(1), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    if (this.xnombre.equals("Tipo Parentesco")) {
                        this.xmodelo.setValueAt(Boolean.valueOf(!xrs.getBoolean(3)), n, 2);
                    } else {
                        this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(3)), n, 2);
                    }
                    if (this.xnombre.equals("Tipo Parentesco")) {
                        this.xmodelo.setValueAt(Boolean.valueOf(!xrs.getBoolean(4)), n, 3);
                    } else {
                        this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(4)), n, 3);
                    }
                    if (this.xnombre.equals("Forma Farmacéutica")) {
                        this.xmodelo.setValueAt(Boolean.valueOf(!xrs.getBoolean(5)), n, 4);
                    }
                    n++;
                }
            }
            xrs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFGenerico2Text2CheckBox.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mIniciarComponentes() {
        if (this.xnombre.equals("Forma Farmacéutica")) {
            this.JCHEspecial.setText("Es Tópico?");
            this.JTFCodigo1.setVisible(true);
        }
        if (this.xnombre.equals("Via de Administracion")) {
            this.JCHEspecial.setText("AplicaHC?");
        }
        if (this.xnombre.equals("Tipo Sala")) {
            this.JCHEspecial.setText("InCruento?");
        }
        if (this.xnombre.equals("Tipo Clase Procedimiento")) {
            this.JCHEspecial.setText("EsQco?");
        }
        if (this.xnombre.equals("Tipo Parentesco")) {
            this.JCHEspecial.setText("EsTrabajador?");
        }
    }
}
