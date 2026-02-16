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

/* JADX INFO: loaded from: GenomaP.jar:ParametrizacionN/JIFGenerico2CheckBox.class */
public class JIFGenerico2CheckBox extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private Object[] xdatos;
    private String xnombre;
    private JCheckBox JCHEspecial;
    private JCheckBox JCHEstado;
    private JPanel JPIDatos;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;
    private JTextField JTFNombre1;
    private JTextField JTRecomendaciones;
    private ConsultasMySQL xconsulta = new ConsultasMySQL();
    private Metodos xmetodos = new Metodos();
    private int xestado = 0;
    private int xespecial = 0;
    private String xid = "";
    private boolean xestadog = false;

    public JIFGenerico2CheckBox(String xnombre, String xnombref) {
        initComponents();
        setName(xnombref);
        setTitle(xnombre.toUpperCase());
        this.xnombre = xnombre;
        mCargarDatosTabla();
        mIniciarComponentes();
    }

    /* JADX WARN: Type inference failed for: r3v39, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPIDatos = new JPanel();
        this.JTRecomendaciones = new JTextField();
        this.JCHEstado = new JCheckBox();
        this.JCHEspecial = new JCheckBox();
        this.JTFNombre1 = new JTextField();
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
        this.JTRecomendaciones.setFont(new Font("Arial", 1, 12));
        this.JTRecomendaciones.setToolTipText("");
        this.JTRecomendaciones.setBorder(BorderFactory.createTitledBorder((Border) null, "Recomendaciones", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setSelected(true);
        this.JCHEstado.setText("Estado");
        this.JCHEstado.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFGenerico2CheckBox.1
            public void actionPerformed(ActionEvent evt) {
                JIFGenerico2CheckBox.this.JCHEstadoActionPerformed(evt);
            }
        });
        this.JCHEspecial.setFont(new Font("Arial", 1, 12));
        this.JCHEspecial.setText("Especial?");
        this.JCHEspecial.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFGenerico2CheckBox.2
            public void actionPerformed(ActionEvent evt) {
                JIFGenerico2CheckBox.this.JCHEspecialActionPerformed(evt);
            }
        });
        this.JTFNombre1.setFont(new Font("Arial", 1, 12));
        this.JTFNombre1.setToolTipText("");
        this.JTFNombre1.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosLayout.createSequentialGroup().addGap(18, 18, 18).addComponent(this.JTRecomendaciones, -2, 506, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHEspecial).addComponent(this.JCHEstado)).addContainerGap(-1, 32767)).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addGap(16, 16, 16).addComponent(this.JTFNombre1, -2, 506, -2).addContainerGap(110, 32767))));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosLayout.createSequentialGroup().addContainerGap(60, 32767).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JCHEspecial).addGap(18, 18, 18).addComponent(this.JCHEstado)).addComponent(this.JTRecomendaciones, -2, 66, -2)).addGap(23, 23, 23)).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addGap(16, 16, 16).addComponent(this.JTFNombre1, -2, -1, -2).addContainerGap(98, 32767))));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalle.setSelectionMode(0);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFGenerico2CheckBox.3
            public void mouseClicked(MouseEvent evt) {
                JIFGenerico2CheckBox.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGap(10, 10, 10).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JSPDetalle, GroupLayout.Alignment.LEADING).addComponent(this.JPIDatos, GroupLayout.Alignment.LEADING, -1, -1, 32767)).addGap(10, 10, 10)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.JPIDatos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalle, -2, 271, -2).addGap(10, 10, 10)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEstadoActionPerformed(ActionEvent evt) {
        if (this.xnombre.equals("Tipo Anestesia") || this.xnombre.equals("Categoria")) {
            if (this.JCHEstado.isSelected()) {
                this.xestado = 0;
                return;
            } else {
                this.xestado = 1;
                return;
            }
        }
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
            this.JTRecomendaciones.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString());
            this.JCHEspecial.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString()).booleanValue());
            if (this.xnombre.equals("Tipo de Doc Ayudas DX")) {
                if (this.JCHEspecial.isSelected()) {
                    this.xespecial = 0;
                } else {
                    this.xespecial = 1;
                }
            } else if (this.xnombre.equals("Tipo Alerta") || this.xnombre.equals("Grupo Sistema") || this.xnombre.equals("Categoria") || this.xnombre.equals("Clasif Concepto Nomina")) {
                if (this.JCHEspecial.isSelected()) {
                    this.xespecial = 1;
                } else {
                    this.xespecial = 0;
                }
            }
            this.JCHEstado.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString()).booleanValue());
            if (this.xnombre.equals("Tipo de Formula") || this.xnombre.equals("Tipo de Programa") || this.xnombre.equals("Tipo de Doc Ayudas DX") || this.xnombre.equals("Categoria")) {
                if (this.JCHEstado.isSelected()) {
                    this.xestado = 0;
                    return;
                } else {
                    this.xestado = 1;
                    return;
                }
            }
            if (this.xnombre.equals("Tipo de Acción") || this.xnombre.equals("Grupo Sistema") || this.xnombre.equals("Tipo Alerta") || this.xnombre.equals("Clasif Concepto Nomina")) {
                if (this.JCHEstado.isSelected()) {
                    this.xestado = 1;
                } else {
                    this.xestado = 0;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEspecialActionPerformed(ActionEvent evt) {
        if (this.JCHEspecial.isSelected()) {
            this.xespecial = 1;
        } else {
            this.xespecial = 0;
        }
    }

    public void mNuevo() {
        Principal.txtNo.setText("");
        this.JTRecomendaciones.setText("");
        this.JCHEstado.setSelected(true);
        if (this.xnombre.equals("Categoria")) {
            this.xestado = 0;
        } else {
            this.xestado = 1;
        }
        this.JCHEspecial.setSelected(false);
        if (this.xnombre.equals("Categoria")) {
            this.xespecial = 0;
        } else {
            this.xespecial = 1;
        }
        this.xespecial = 0;
        this.JTRecomendaciones.requestFocus();
    }

    public void mGrabar() {
        if (!this.JTRecomendaciones.getText().isEmpty()) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                String sql = null;
                if (Principal.txtNo.getText().isEmpty()) {
                    if (this.xnombre.equals("Tipo de Formula")) {
                        if (this.JCHEstado.isSelected()) {
                            this.xestado = 0;
                        } else {
                            this.xestado = 1;
                        }
                        sql = " Insert into h_tipoformula (`Nbre` , `Especial` , `Estado`, Fecha, UsuarioS)  values ('" + this.JTRecomendaciones.getText().toUpperCase() + "','" + this.xespecial + "','" + this.xestado + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                    } else if (this.xnombre.equals("Tipo de Programa")) {
                        sql = " Insert into g_tipoprograma (`Nbre`, `EsPrenatal`, `Estado`, Fecha, UsuarioS)  values ('" + this.JTRecomendaciones.getText().toUpperCase() + "','" + this.xespecial + "','" + this.xestado + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                    } else if (this.xnombre.equals("Tipo de Acción")) {
                        if (this.JCHEstado.isSelected()) {
                            this.xestado = 1;
                        } else {
                            this.xestado = 0;
                        }
                        sql = " Insert into s_sgc_tipo_accion (`Nbre` , `RAnalisis` ,`Estado`, Fecha, UsuarioS)  values ('" + this.JTRecomendaciones.getText().toUpperCase() + "','" + this.xespecial + "','" + this.xestado + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                    } else if (this.xnombre.equals("Tipo de Doc Ayudas DX")) {
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
                        sql = " Insert into h_tipoayudadx (`Nbre`,`Tipo`,`Estado`, Fecha, UsuarioS)  values ('" + this.JTRecomendaciones.getText().toUpperCase() + "','" + this.xespecial + "','" + this.xestado + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                    } else if (this.xnombre.equals("Tipo de Concepto")) {
                        if (this.JCHEstado.isSelected()) {
                            this.xestado = 1;
                        } else {
                            this.xestado = 0;
                        }
                        sql = " Insert into so_tipo_concepto (`Nbre` , `Tipo`, `Estado`,`Fecha`,`UsuarioS`,`Recomendaciones`)  values ('" + this.JTFNombre1.getText().toUpperCase() + "','" + this.xespecial + "','" + this.xestado + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "','" + this.JTRecomendaciones.getText().toUpperCase() + "')";
                    } else if (this.xnombre.equals("Tipo Restricción")) {
                        if (this.JCHEstado.isSelected()) {
                            this.xestado = 1;
                        } else {
                            this.xestado = 0;
                        }
                        sql = " Insert into so_tipo_restriccion (`Nbre` , `Tipo`, `Estado`,`Fecha`,`UsuarioS`)  values ('" + this.JTRecomendaciones.getText().toUpperCase() + "','" + this.xespecial + "','" + this.xestado + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                    } else if (this.xnombre.equals("Grupo Sistema")) {
                        if (this.JCHEstado.isSelected()) {
                            this.xestado = 1;
                        } else {
                            this.xestado = 0;
                        }
                        sql = " Insert into h_gruposistemas (`Nbre` , `Orden`, `Estado`,`Fecha`,`UsuarioS`)  values ('" + this.JTRecomendaciones.getText().toUpperCase() + "','" + this.xespecial + "','" + this.xestado + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                    } else if (this.xnombre.equals("Tipo Alerta")) {
                        if (this.JCHEstado.isSelected()) {
                            this.xestado = 1;
                        } else {
                            this.xestado = 0;
                        }
                        sql = " Insert into g_tipoalerta (`Nbre` , `EsHC` , `Estado`, Fecha, UsuarioS)  values ('" + this.JTRecomendaciones.getText().toUpperCase() + "','" + this.xespecial + "','" + this.xestado + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                    } else if (this.xnombre.equals("Tipo Anestesia")) {
                        if (this.JCHEstado.isSelected()) {
                            this.xestado = 0;
                        } else {
                            this.xestado = 1;
                        }
                        sql = " Insert into f_tipoanestesia (`Nbre`,`GeneraCobro`,`Estado`, Fecha, UsuarioS)  values ('" + this.JTRecomendaciones.getText().toUpperCase() + "','" + this.xespecial + "','" + this.xestado + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                    } else if (this.xnombre.equals("Categoria")) {
                        if (this.JCHEstado.isSelected()) {
                            this.xestado = 0;
                        } else {
                            this.xestado = 1;
                        }
                        sql = " Insert into i_categoria (`Nbre`,`Comercial`,`Estado`, Fecha, UsuarioS)  values ('" + this.JTRecomendaciones.getText().toUpperCase() + "','" + this.xespecial + "','" + this.xestado + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                    } else if (this.xnombre.equals("Clasif Concepto Nomina")) {
                        if (this.JCHEstado.isSelected()) {
                            this.xestado = 1;
                        } else {
                            this.xestado = 0;
                        }
                        sql = " Insert into rh_tipo_clasificacion_conceptonomina(Nbre,EsContable, Estado, Id_Usuarios)  values ('" + this.JTRecomendaciones.getText().toUpperCase() + "','" + this.xespecial + "','" + this.xestado + "','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "')";
                    }
                } else if (this.xnombre.equals("Tipo de Formula")) {
                    if (this.JCHEstado.isSelected()) {
                        this.xestado = 0;
                    } else {
                        this.xestado = 1;
                    }
                    sql = " update h_tipoformula set Nbre='" + this.JTRecomendaciones.getText().toUpperCase() + "',Especial='" + this.xespecial + "',Estado='" + this.xestado + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
                } else if (this.xnombre.equals("Tipo de Programa")) {
                    sql = " update g_tipoprograma set Nbre='" + this.JTRecomendaciones.getText().toUpperCase() + "',EsPrenatal='" + this.xespecial + "',Estado='" + this.xestado + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id_TipoPrograma='" + Principal.txtNo.getText() + "'";
                } else if (this.xnombre.equals("Tipo de Doc Ayudas DX")) {
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
                    sql = " update h_tipoayudadx set Nbre='" + this.JTRecomendaciones.getText().toUpperCase() + "',Tipo='" + this.xespecial + "',Estado='" + this.xestado + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
                } else if (this.xnombre.equals("Tipo de Concepto")) {
                    if (this.JCHEstado.isSelected()) {
                        this.xestado = 1;
                    } else {
                        this.xestado = 0;
                    }
                    sql = " update so_tipo_concepto set Nbre='" + this.JTFNombre1.getText().toUpperCase() + "',Tipo='" + this.xespecial + "',Estado='" + this.xestado + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "',Recomendaciones='" + this.JTRecomendaciones.getText().toUpperCase() + "' Where Id='" + Principal.txtNo.getText() + "'";
                } else if (this.xnombre.equals("Tipo Restricción")) {
                    if (this.JCHEstado.isSelected()) {
                        this.xestado = 1;
                    } else {
                        this.xestado = 0;
                    }
                    sql = " update so_tipo_restriccion set Nbre='" + this.JTRecomendaciones.getText().toUpperCase() + "',Tipo='" + this.xespecial + "',Estado='" + this.xestado + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
                } else if (this.xnombre.equals("Grupo Sistema")) {
                    if (this.JCHEstado.isSelected()) {
                        this.xestado = 1;
                    } else {
                        this.xestado = 0;
                    }
                    sql = " update `h_gruposistemas` set Nbre='" + this.JTRecomendaciones.getText().toUpperCase() + "',Orden='" + this.xespecial + "',Estado='" + this.xestado + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
                } else if (this.xnombre.equals("Tipo Alerta")) {
                    sql = " update g_tipoalerta set Nbre='" + this.JTRecomendaciones.getText().toUpperCase() + "',EsHC='" + this.xespecial + "',Estado='" + this.xestado + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
                } else if (this.xnombre.equals("Categoria")) {
                    if (this.JCHEstado.isSelected()) {
                        this.xestado = 0;
                    } else {
                        this.xestado = 1;
                    }
                    sql = " update i_categoria set Nbre='" + this.JTRecomendaciones.getText().toUpperCase() + "',Comercial='" + this.xespecial + "',Estado='" + this.xestado + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
                } else if (this.xnombre.equals("Clasif Concepto Nomina")) {
                    if (this.JCHEstado.isSelected()) {
                        this.xestado = 1;
                    } else {
                        this.xestado = 0;
                    }
                    sql = " update rh_tipo_clasificacion_conceptonomina set Nbre='" + this.JTRecomendaciones.getText().toUpperCase() + "', EsContable='" + this.xespecial + "', Estado='" + this.xestado + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', Id_Usuarios='" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "' Where Id='" + Principal.txtNo.getText() + "'";
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
        this.JTRecomendaciones.requestFocus();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos(String[] xcabecera) {
        this.xmodelo = new DefaultTableModel(new Object[0], xcabecera) { // from class: ParametrizacionN.JIFGenerico2CheckBox.4
            Class[] types = {Long.class, String.class, Boolean.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false};

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
        this.JTDetalle.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(250);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(15);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(15);
    }

    private void mCargarDatosTabla() {
        try {
            String[] xencabezado = null;
            String sql = null;
            if (this.xnombre.equals("Tipo de Formula")) {
                xencabezado = new String[]{"Id", "Nombre", "Especial", "Estado"};
                sql = "SELECT `Id`, `Nbre` , `Especial` , IF(`Estado`=0,TRUE,FALSE) AS Estado FROM `h_tipoformula` ORDER BY Nbre ASC";
            } else if (this.xnombre.equals("Tipo de Programa")) {
                xencabezado = new String[]{"Id", "Nombre", "EsPrenatal", "Estado"};
                sql = "SELECT `Id_TipoPrograma`, `Nbre`, `EsPrenatal`, IF(`Estado`=0,TRUE,FALSE) AS Estado FROM `g_tipoprograma` ORDER BY Nbre ASC";
            } else if (this.xnombre.equals("Tipo de Acción")) {
                xencabezado = new String[]{"Id", "Nombre", "RAnálisis", "Estado"};
                sql = "SELECT `Id`, `Nbre` , `RAnalisis` , `Estado` FROM `s_sgc_tipo_accion` ORDER BY Nbre ASC";
            } else if (this.xnombre.equals("Tipo de Doc Ayudas DX")) {
                xencabezado = new String[]{"Id", "Nombre", "Tipo", "Estado"};
                sql = "SELECT `Id`, `Nbre` , IF(`Tipo`=0,TRUE,FALSE) AS`Tipo` , IF(`Estado`=0,TRUE,FALSE) AS Estado FROM `h_tipoayudadx` ORDER BY Nbre ASC";
            } else if (this.xnombre.equals("Tipo de Concepto")) {
                xencabezado = new String[]{"Id", "Nombre", "Tipo", "Estado"};
                sql = "SELECT `Id`, `Nbre` , Tipo , Estado FROM `so_tipo_concepto` ORDER BY Nbre ASC";
            } else if (this.xnombre.equals("Tipo Restricción")) {
                xencabezado = new String[]{"Id", "Nombre", "Tipo", "Estado"};
                sql = "SELECT `Id`, `Nbre` , Tipo , Estado FROM `so_tipo_restriccion` ORDER BY Nbre ASC";
            } else if (this.xnombre.equals("Grupo Sistema")) {
                xencabezado = new String[]{"Id", "Nombre", "Orden", "Estado"};
                sql = "SELECT `Id`, `Nbre` , Orden , Estado FROM h_gruposistemas ORDER BY Nbre ASC";
            } else if (this.xnombre.equals("Tipo Alerta")) {
                xencabezado = new String[]{"Id", "Nombre", "Es HC", "Estado"};
                sql = "SELECT `Id`, `Nbre` , EsHC , Estado FROM g_tipoalerta ORDER BY Nbre ASC";
            } else if (this.xnombre.equals("Tipo Anestesia")) {
                xencabezado = new String[]{"Id", "Nombre", "Genera Cobro?", "Estado"};
                sql = "SELECT `Id`, `Nbre` , GeneraCobro , Estado FROM f_tipoanestesia ORDER BY Nbre ASC";
            } else if (this.xnombre.equals("Categoria")) {
                xencabezado = new String[]{"Id", "Nombre", "Comercial?", "Estado"};
                sql = "SELECT `Id`, `Nbre` , Comercial , Estado FROM i_categoria ORDER BY Nbre ASC";
            } else if (this.xnombre.equals("Clasif Concepto Nomina")) {
                xencabezado = new String[]{"Id", "Nombre", "Es Contable?", "Estado"};
                sql = "SELECT  Id,Nbre,EsContable,Estado FROM rh_tipo_clasificacion_conceptonomina ORDER BY Nbre ASC";
            }
            mCrearModeloDatos(xencabezado);
            ResultSet xrs = this.xconsulta.traerRs(sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(1)), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(3)), n, 2);
                    if (this.xnombre.equals("Tipo Anestesia") || this.xnombre.equals("Categoria")) {
                        this.xmodelo.setValueAt(Boolean.valueOf(!xrs.getBoolean(4)), n, 3);
                    } else {
                        this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(4)), n, 3);
                    }
                    n++;
                }
            }
            xrs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFGenerico2CheckBox.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mIniciarComponentes() {
        if (this.xnombre.equals("Tipo de Formula")) {
            this.JCHEspecial.setText("Especial?");
            return;
        }
        if (this.xnombre.equals("Tipo de Programa")) {
            this.JCHEspecial.setText("Es Prenatal?");
            return;
        }
        if (this.xnombre.equals("Tipo de Acción")) {
            this.JCHEspecial.setText("Requiere Análisis?");
            return;
        }
        if (this.xnombre.equals("Tipo de Doc Ayudas DX")) {
            this.JCHEspecial.setText("Tipo");
            return;
        }
        if (this.xnombre.equals("Tipo de Concepto")) {
            this.JCHEspecial.setText("Ingreso?");
            return;
        }
        if (this.xnombre.equals("Tipo Restricción")) {
            this.JCHEspecial.setText("Permanente?");
            return;
        }
        if (this.xnombre.equals("Grupo Sistema")) {
            this.JCHEspecial.setText("Orden ?");
            return;
        }
        if (this.xnombre.equals("Tipo Alerta")) {
            this.JCHEspecial.setText("Es HC ?");
            return;
        }
        if (this.xnombre.equals("Tipo Anestesia")) {
            this.JCHEspecial.setText("Genera Cobro?");
        } else if (this.xnombre.equals("Categoria")) {
            this.JCHEspecial.setText("Comercial?");
        } else if (this.xnombre.equals("Clasif Concepto Nomina")) {
            this.JCHEspecial.setText("Es Contable?");
        }
    }
}
