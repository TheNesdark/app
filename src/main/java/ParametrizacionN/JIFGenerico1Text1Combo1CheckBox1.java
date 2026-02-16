package ParametrizacionN;

import Acceso.Principal;
import Activos.JIFGestionActivos;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import Utilidades.TextAreaEditor;
import Utilidades.TextAreaRenderer;
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
import javax.swing.table.TableColumnModel;

/* JADX INFO: loaded from: GenomaP.jar:ParametrizacionN/JIFGenerico1Text1Combo1CheckBox1.class */
public class JIFGenerico1Text1Combo1CheckBox1 extends JInternalFrame {
    private ConsultasMySQL xconsulta;
    private Metodos xmetodos;
    private int xestado;
    private DefaultTableModel xmodelo;
    private Object[] xdatos;
    private String xnombre;
    private String[] xidgenerico;
    private boolean xestado1;
    private JIFGestionActivos xjifges;
    private String nombre;
    private JComboBox JCBGenerico;
    private JCheckBox JCHEstado;
    private JPanel JPIDatos;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;
    private JTextField JTFNombre;

    public JIFGenerico1Text1Combo1CheckBox1(String xnombre, String xtitulo) {
        this.xconsulta = new ConsultasMySQL();
        this.xmetodos = new Metodos();
        this.xestado = 0;
        this.xestado1 = false;
        this.nombre = "";
        initComponents();
        setName(xnombre);
        setTitle(xtitulo.toUpperCase());
        this.xnombre = xnombre;
        mNuevo();
        mIniciarComponentes();
        mCargarDatosTabla();
    }

    public JIFGenerico1Text1Combo1CheckBox1(String xnombre, String xtitulo, JIFGestionActivos xjifgestion, boolean xestado1) {
        this.xconsulta = new ConsultasMySQL();
        this.xmetodos = new Metodos();
        this.xestado = 0;
        this.xestado1 = false;
        this.nombre = "";
        initComponents();
        setName(xnombre);
        setTitle(xtitulo.toUpperCase());
        this.xestado1 = xestado1;
        this.xjifges = xjifgestion;
        this.xnombre = xnombre;
        mNuevo();
        mIniciarComponentes();
        mCargarDatosTabla();
    }

    /* JADX WARN: Type inference failed for: r3v28, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPIDatos = new JPanel();
        this.JTFNombre = new JTextField();
        this.JCHEstado = new JCheckBox();
        this.JCBGenerico = new JComboBox();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("GENERICO3");
        setToolTipText("");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifgenerico3");
        try {
            setSelected(true);
        } catch (PropertyVetoException e1) {
            e1.printStackTrace();
        }
        addInternalFrameListener(new InternalFrameListener() { // from class: ParametrizacionN.JIFGenerico1Text1Combo1CheckBox1.1
            public void internalFrameActivated(InternalFrameEvent evt) {
            }

            public void internalFrameClosed(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                JIFGenerico1Text1Combo1CheckBox1.this.formInternalFrameClosing(evt);
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
        this.JTFNombre.setFont(new Font("Arial", 1, 12));
        this.JTFNombre.setToolTipText("");
        this.JTFNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setSelected(true);
        this.JCHEstado.setText("Estado");
        this.JCHEstado.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFGenerico1Text1Combo1CheckBox1.2
            public void actionPerformed(ActionEvent evt) {
                JIFGenerico1Text1Combo1CheckBox1.this.JCHEstadoActionPerformed(evt);
            }
        });
        this.JCBGenerico.setFont(new Font("Arial", 1, 12));
        this.JCBGenerico.setBorder(BorderFactory.createTitledBorder((Border) null, "Departamento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosLayout.createSequentialGroup().addContainerGap().addComponent(this.JTFNombre, -2, 317, -2).addGap(18, 18, 18).addComponent(this.JCBGenerico, 0, 377, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHEstado).addContainerGap()));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCHEstado).addComponent(this.JTFNombre, -2, 50, -2).addComponent(this.JCBGenerico, -1, 50, 32767)).addContainerGap()));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalle.setSelectionMode(0);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFGenerico1Text1Combo1CheckBox1.3
            public void mouseClicked(MouseEvent evt) {
                JIFGenerico1Text1Combo1CheckBox1.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JSPDetalle, GroupLayout.Alignment.LEADING, -1, 815, 32767).addComponent(this.JPIDatos, GroupLayout.Alignment.LEADING, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPDetalle, -1, 391, 32767).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEstadoActionPerformed(ActionEvent evt) {
        if (this.JCHEstado.isSelected()) {
            if (this.xnombre.equals("xjifubicacion") || this.xnombre.equals("xjifubicacion1") || this.xnombre.equals("xjiftipomedida") || this.xnombre.equals("xjifelementospp") || this.xnombre.equals("xjiffsalacirugia")) {
                this.xestado = 1;
                return;
            } else {
                this.xestado = 0;
                return;
            }
        }
        if (this.xnombre.equals("xjifubicacion") || this.xnombre.equals("xjifubicacion1") || this.xnombre.equals("xjiftipomedida") || this.xnombre.equals("xjifelementospp") || this.xnombre.equals("xjiffsalacirugia")) {
            this.xestado = 0;
        } else {
            this.xestado = 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            Principal.txtNo.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
            this.JCBGenerico.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString());
            this.JTFNombre.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString());
            this.JCHEstado.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString()).booleanValue());
            if (this.JCHEstado.isSelected()) {
                if (this.xnombre.equals("xjifubicacion") || this.xnombre.equals("xjifubicacion1") || this.xnombre.equals("xjiftipomedida") || this.xnombre.equals("xjifelementospp") || this.xnombre.equals("xjifrecomendaciones") || this.xnombre.equals("xjiffsalacirugia")) {
                    this.xestado = 1;
                    return;
                } else {
                    this.xestado = 0;
                    return;
                }
            }
            if (this.xnombre.equals("xjifubicacion") || this.xnombre.equals("xjifubicacion1") || this.xnombre.equals("xjiftipomedida") || this.xnombre.equals("xjifelementospp") || this.xnombre.equals("xjifrecomendaciones") || this.xnombre.equals("xjiffsalacirugia")) {
                this.xestado = 0;
            } else {
                this.xestado = 1;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosing(InternalFrameEvent evt) {
        Principal.mLimpiarDatosP();
        if (this.xestado1) {
            mRecargarCombo();
        }
    }

    public void mNuevo() {
        Principal.mLimpiarDatosP();
        this.JTFNombre.setText("");
        this.JCBGenerico.setSelectedIndex(-1);
        this.JCHEstado.setSelected(true);
        if (this.xnombre.equals("xjifubicacion") || this.xnombre.equals("xjifubicacion1") || this.xnombre.equals("xjiftipomedida") || this.xnombre.equals("xjifelementospp") || this.xnombre.equals("xjifrecomendaciones") || this.xnombre.equals("xjiffsalacirugia")) {
            this.xestado = 1;
        } else {
            this.xestado = 0;
        }
        this.JTFNombre.requestFocus();
    }

    public void mGrabar() {
        if (this.JCBGenerico.getSelectedIndex() != -1) {
            if (!this.JTFNombre.getText().isEmpty()) {
                int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (n == 0) {
                    String sql = null;
                    if (Principal.txtNo.getText().isEmpty()) {
                        this.nombre = this.JTFNombre.getText().toUpperCase();
                        switch (this.xnombre) {
                            case "jifclaseconsultorio":
                                sql = " Insert into c_claseconsultorio(Nbre, Id_Especialidad, Estado, Fecha, UsuarioS)  values ('" + this.JTFNombre.getText().toUpperCase() + "','" + this.xidgenerico[this.JCBGenerico.getSelectedIndex()] + "','" + this.xestado + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                                break;
                            case "jifconsultorio":
                                sql = " Insert into c_consultorio(Nbre, Id_ClaseCons, Estado, Fecha, UsuarioS)  values ('" + this.JTFNombre.getText().toUpperCase() + "','" + this.xidgenerico[this.JCBGenerico.getSelectedIndex()] + "','" + this.xestado + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                                break;
                            case "jifbanco":
                                sql = " Insert into cc_banco(Nbre, Id_Municipio, Estado, Fecha, UsuarioS)  values ('" + this.JTFNombre.getText().toUpperCase() + "','" + this.xidgenerico[this.JCBGenerico.getSelectedIndex()] + "','" + this.xestado + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                                break;
                            case "xjifunidadnegocio":
                                sql = " Insert into g_tipounidadnegocio(Nbre, Id_TipoEmpresa, Estado, Fecha, UsuarioS)  values ('" + this.JTFNombre.getText().toUpperCase() + "','" + this.xidgenerico[this.JCBGenerico.getSelectedIndex()] + "','" + this.xestado + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                                break;
                            case "xjiftipodetalleexamenf":
                                sql = " Insert into h_tipoexamenfisico(Nbre, Id_GrupoExamenFisico , Estado, Fecha, UsuarioS)  values ('" + this.JTFNombre.getText().toUpperCase() + "','" + this.xidgenerico[this.JCBGenerico.getSelectedIndex()] + "','" + this.xestado + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                                break;
                            case "xjifmotivoanulacion":
                                sql = " Insert into g_motivoanulacion(Nbre, Modulo , Estado, Fecha, UsuarioS)  values ('" + this.JTFNombre.getText().toUpperCase() + "','" + this.xidgenerico[this.JCBGenerico.getSelectedIndex()] + "','" + this.xestado + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                                break;
                            case "xjifubicacion":
                            case "xjifubicacion1":
                                sql = " Insert into rh_tipo_ubicacion(Nbre, Id_UnidadF, Estado, UsuarioS)  values ('" + this.JTFNombre.getText().toUpperCase() + "','" + this.xidgenerico[this.JCBGenerico.getSelectedIndex()] + "','" + this.xestado + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                                break;
                            case "xjiftipomedida":
                                sql = " Insert into i_tipo_medicion(`Nbre` , `Id_UMedida` , `Estado`, `Fecha`  , `UsuarioS`)  values ('" + this.JTFNombre.getText().toUpperCase() + "','" + this.xidgenerico[this.JCBGenerico.getSelectedIndex()] + "','" + this.xestado + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                                break;
                            case "xjifelementospp":
                                sql = " Insert into g_so_elementospp(`Nbre`, `Parte` , `Estado` , `Fecha` , `UsuarioS`)  values ('" + this.JTFNombre.getText().toUpperCase() + "','" + this.xidgenerico[this.JCBGenerico.getSelectedIndex()] + "','" + this.xestado + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                                break;
                            case "xjifrecomendaciones":
                                sql = " Insert into so_recomendaciones(`Nbre`, `Id_Encabezado` , `Estado`, `UsuarioS` )  values ('" + this.JTFNombre.getText() + "','" + this.xidgenerico[this.JCBGenerico.getSelectedIndex()] + "','" + this.xestado + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                                break;
                            case "xjiffsalacirugia":
                                sql = " INSERT INTO q_salacirugias(`Nbre`,`Id_TipoSala`,`Estado`,`UsuarioS`)  values ('" + this.JTFNombre.getText().toUpperCase() + "','" + this.xidgenerico[this.JCBGenerico.getSelectedIndex()] + "','" + this.xestado + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                                break;
                        }
                    } else {
                        switch (this.xnombre) {
                            case "jifclaseconsultorio":
                                sql = " update c_claseconsultorio set Nbre='" + this.JTFNombre.getText().toUpperCase() + "',Id_Especialidad='" + this.xidgenerico[this.JCBGenerico.getSelectedIndex()] + "',Estado='" + this.xestado + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
                                break;
                            case "jifconsultorio":
                                sql = " update c_consultorio set Nbre='" + this.JTFNombre.getText().toUpperCase() + "',Id_ClaseCons='" + this.xidgenerico[this.JCBGenerico.getSelectedIndex()] + "',Estado='" + this.xestado + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
                                break;
                            case "jifbanco":
                                sql = " update cc_banco set Nbre='" + this.JTFNombre.getText().toUpperCase() + "',Id_Municipio='" + this.xidgenerico[this.JCBGenerico.getSelectedIndex()] + "',Estado='" + this.xestado + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
                                break;
                            case "xjifunidadnegocio":
                                sql = " update g_tipounidadnegocio set Nbre='" + this.JTFNombre.getText().toUpperCase() + "',Id_TipoEmpresa='" + this.xidgenerico[this.JCBGenerico.getSelectedIndex()] + "',Estado='" + this.xestado + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
                                break;
                            case "xjiftipodetalleexamenf":
                                sql = " update h_tipoexamenfisico set Nbre='" + this.JTFNombre.getText().toUpperCase() + "',Id_GrupoExamenFisico='" + this.xidgenerico[this.JCBGenerico.getSelectedIndex()] + "',Estado='" + this.xestado + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
                                break;
                            case "xjifmotivoanulacion":
                                sql = " update g_motivoanulacion set Nbre='" + this.JTFNombre.getText().toUpperCase() + "',Modulo='" + this.xidgenerico[this.JCBGenerico.getSelectedIndex()] + "',Estado='" + this.xestado + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
                                break;
                            case "xjifubicacion":
                            case "xjifubicacion1":
                                sql = " update rh_tipo_ubicacion set Nbre='" + this.JTFNombre.getText().toUpperCase() + "',Id_UnidadF='" + this.xidgenerico[this.JCBGenerico.getSelectedIndex()] + "',Estado='" + this.xestado + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
                                break;
                            case "xjiftipomedida":
                                sql = " update i_tipo_medicion set Nbre='" + this.JTFNombre.getText().toUpperCase() + "',Id_UMedida='" + this.xidgenerico[this.JCBGenerico.getSelectedIndex()] + "',Estado='" + this.xestado + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
                                break;
                            case "xjifelementospp":
                                sql = " update g_so_elementospp set Nbre='" + this.JTFNombre.getText().toUpperCase() + "',Parte='" + this.xidgenerico[this.JCBGenerico.getSelectedIndex()] + "',Estado='" + this.xestado + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
                                break;
                            case "xjifrecomendaciones":
                                sql = " update so_recomendaciones set Nbre='" + this.JTFNombre.getText() + "',Id_Encabezado='" + this.xidgenerico[this.JCBGenerico.getSelectedIndex()] + "',Estado='" + this.xestado + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
                                break;
                            case "xjiffsalacirugia":
                                sql = " update q_salacirugias set Nbre='" + this.JTFNombre.getText().toUpperCase() + "',Id_TipoSala='" + this.xidgenerico[this.JCBGenerico.getSelectedIndex()] + "',Estado='" + this.xestado + "',UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
                                break;
                        }
                    }
                    this.xconsulta.ejecutarSQL(sql);
                    this.xconsulta.cerrarConexionBd();
                    mCargarDatosTabla();
                }
            } else {
                JOptionPane.showInternalMessageDialog(this, "El nombre no puede ser nulo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JTFNombre.requestFocus();
            }
        } else {
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar el item del combo 1", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBGenerico.requestFocus();
        }
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos(String[] xcabecera) {
        this.xmodelo = new DefaultTableModel(new Object[0], xcabecera) { // from class: ParametrizacionN.JIFGenerico1Text1Combo1CheckBox1.4
            Class[] types = {Long.class, String.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(5);
        if (this.xnombre.equals("xjifelementospp") || this.xnombre.equals("xjifrecomendaciones") || this.xnombre.equals("xjiffsalacirugia")) {
            this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(330);
            this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(100);
        } else {
            this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(100);
            this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(300);
        }
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(10);
    }

    private void mCargarDatosTabla() {
        String sql;
        String[] xencabezado;
        try {
            sql = null;
            xencabezado = null;
            switch (this.xnombre) {
                case "jifclaseconsultorio":
                    xencabezado = new String[]{"Id", "Especialidad", "Clase Consultorio", "Estado"};
                    sql = "SELECT c_claseconsultorio.Id, g_especialidad.Nbre, c_claseconsultorio.Nbre, c_claseconsultorio.Estado  FROM c_claseconsultorio INNER JOIN g_especialidad ON (c_claseconsultorio.Id_Especialidad = g_especialidad.Id)  ORDER BY g_especialidad.Nbre ASC, c_claseconsultorio.Nbre ASC";
                    break;
                case "jifconsultorio":
                    xencabezado = new String[]{"Id", "Clase Consultorio", "Consultorio", "Estado"};
                    sql = "SELECT c_consultorio.Id, c_claseconsultorio.Nbre, c_consultorio.Nbre, c_consultorio.Estado FROM c_consultorio INNER JOIN c_claseconsultorio ON (c_consultorio.Id_ClaseCons = c_claseconsultorio.Id) ORDER BY c_claseconsultorio.Nbre ASC, c_consultorio.Nbre ASC ";
                    break;
                case "jifbanco":
                    xencabezado = new String[]{"Id", "Banco", "Sucursal", "Estado"};
                    sql = "SELECT cc_banco.Id, cc_banco.Nbre, g_municipio.Nbre, cc_banco.Estado FROM cc_banco INNER JOIN g_municipio  ON (cc_banco.Id_Municipio = g_municipio.Id) ORDER BY cc_banco.Nbre ASC, g_municipio.Nbre ASC ";
                    break;
                case "xjifunidadnegocio":
                    xencabezado = new String[]{"Id", "Unidad", "Tipo Empresa", "Estado"};
                    sql = "SELECT g_tipounidadnegocio.Id,g_tipoempresa.Nbre, g_tipounidadnegocio.Nbre, g_tipounidadnegocio.Estado  FROM g_tipounidadnegocio INNER JOIN g_tipoempresa  ON (g_tipounidadnegocio.Id_TipoEmpresa = g_tipoempresa.Id) ORDER BY g_tipoempresa.Nbre asc, g_tipounidadnegocio.Nbre ASC ";
                    break;
                case "xjiftipodetalleexamenf":
                    xencabezado = new String[]{"Id", "Tipo Exámen", "Detalle Exámen", "Estado"};
                    sql = "SELECT h_tipoexamenfisico.Id, h_grupoexamenfisico.Nbre, h_tipoexamenfisico.Nbre, h_tipoexamenfisico.Estado FROM h_tipoexamenfisico INNER JOIN baseserver.h_grupoexamenfisico  ON (h_tipoexamenfisico.Id_GrupoExamenFisico = h_grupoexamenfisico.Id) ORDER BY h_grupoexamenfisico.Orden ASC, h_tipoexamenfisico.Nbre ASC ";
                    break;
                case "xjifmotivoanulacion":
                    xencabezado = new String[]{"Id", "Modulo", "Motivo", "Estado"};
                    sql = "SELECT g_motivoanulacion.Id, g_modulos.Nbre, g_motivoanulacion.Nbre, g_motivoanulacion.Estado FROM g_motivoanulacion INNER JOIN g_modulos  ON (g_motivoanulacion.Modulo = g_modulos.Id) ORDER BY g_modulos.Nbre ASC, g_motivoanulacion.Nbre ASC";
                    break;
                case "xjifubicacion":
                case "xjifubicacion1":
                    xencabezado = new String[]{"Id", "Unidad Funcional", "Ubicacion", "Estado"};
                    sql = "SELECT rh_tipo_ubicacion.Id, rh_unidad_funcional.Nbre , rh_tipo_ubicacion.Nbre, rh_tipo_ubicacion.Estado FROM rh_tipo_ubicacion INNER JOIN rh_unidad_funcional  ON (rh_tipo_ubicacion.Id_UnidadF = rh_unidad_funcional.Id) ORDER BY rh_unidad_funcional.Nbre ASC, rh_tipo_ubicacion.Nbre ASC ";
                    break;
                case "xjiftipomedida":
                    xencabezado = new String[]{"Id", "Unidad Medida", "Nombre", "Estado"};
                    sql = "SELECT `i_tipo_medicion`.`Id` , `i_unidadmedida`.`Nbre`,`i_tipo_medicion`.`Nbre`, IF(`i_tipo_medicion`.`Estado`=0,TRUE,FALSE) FROM `i_tipo_medicion`  INNER JOIN `baseserver`.`i_unidadmedida` ON (`i_tipo_medicion`.`Id_UMedida` = `i_unidadmedida`.`Id`) ORDER BY `i_tipo_medicion`.`Nbre` ASC ";
                    break;
                case "xjifelementospp":
                    xencabezado = new String[]{"Id", "Elemento de protección", "Parte", "Estado"};
                    sql = "SELECT `g_so_elementospp`.`Id` , `g_so_elementospp`.`Nbre`, `g_so_elementos_partes`.`Nbre` , IF(`g_so_elementospp`.`Estado`=0,TRUE,FALSE) AS Estado  FROM `g_so_elementospp`  INNER JOIN `baseserver`.`g_so_elementos_partes`   ON (`g_so_elementospp`.`Parte` = `g_so_elementos_partes`.`Id`) ORDER BY `g_so_elementos_partes`.`Nbre` ,`g_so_elementospp`.`Nbre` ASC";
                    break;
                case "xjifrecomendaciones":
                    xencabezado = new String[]{"Id", "Recomendaciones", "Encabezado", "Estado"};
                    sql = "SELECT  `so_recomendaciones`.`Id` , `so_recomendaciones`.`Nbre`  ,  `so_recomendaciones_encabezado`.`Nbre` ,`so_recomendaciones`.`Estado` FROM `so_recomendaciones`  INNER JOIN `baseserver`.`so_recomendaciones_encabezado`ON (`so_recomendaciones`.`Id_Encabezado` = `so_recomendaciones_encabezado`.`Id`) ORDER BY `so_recomendaciones_encabezado`.`Nbre` ASC,`so_recomendaciones`.`Nbre` ASC ";
                    break;
                case "xjiffsalacirugia":
                    xencabezado = new String[]{"Id", "Tipo de Sala", "Nombre", "Estado"};
                    sql = "SELECT`q_salacirugias`.`Id`, `q_tiposala`.`Nbre`, `q_salacirugias`.`Nbre`, `q_salacirugias`.`Estado`FROM`q_salacirugias`INNER JOIN `q_tiposala` ON (`q_salacirugias`.`Id_TipoSala` = `q_tiposala`.`Id`)ORDER BY `q_tiposala`.`Nbre` ASC, `q_salacirugias`.`Nbre` ASC;";
                    break;
            }
            mCrearModeloDatos(xencabezado);
            ResultSet xrs = this.xconsulta.traerRs(sql);
            Throwable th = null;
            try {
                try {
                    TableColumnModel cmodel = this.JTDetalle.getColumnModel();
                    TextAreaRenderer textAreaRenderer = new TextAreaRenderer();
                    cmodel.getColumn(1).setCellRenderer(textAreaRenderer);
                    TextAreaEditor textEditor = new TextAreaEditor();
                    cmodel.getColumn(1).setCellEditor(textEditor);
                    System.out.println("consulta-->" + sql + " Pantalla-->" + this.xnombre);
                    if (xrs.next()) {
                        xrs.beforeFirst();
                        int n = 0;
                        while (xrs.next()) {
                            this.xmodelo.addRow(this.xdatos);
                            this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(1)), n, 0);
                            this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                            this.xmodelo.setValueAt(xrs.getString(3), n, 2);
                            if (this.xnombre.equals("xjifubicacion") || this.xnombre.equals("xjifubicacion1") || this.xnombre.equals("xjifrecomendaciones") || this.xnombre.equals("xjiffsalacirugia")) {
                                this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(4)), n, 3);
                            } else {
                                this.xmodelo.setValueAt(Boolean.valueOf(!xrs.getBoolean(4)), n, 3);
                            }
                            n++;
                        }
                    }
                    if (xrs != null) {
                        if (0 != 0) {
                            try {
                                xrs.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                        } else {
                            xrs.close();
                        }
                    }
                    this.xconsulta.cerrarConexionBd();
                } finally {
                }
            } catch (Throwable th3) {
                th = th3;
                throw th3;
            }
        } catch (SQLException ex) {
            Logger.getLogger(JIFGenericoCh.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mIniciarComponentes() {
        switch (this.xnombre) {
            case "jifclaseconsultorio":
                this.JCBGenerico.setBorder(BorderFactory.createTitledBorder((Border) null, "Especialidad", 0, 0, new Font("Arial", 1, 12), Color.blue));
                this.xidgenerico = this.xconsulta.llenarCombo("SELECT Id, Nbre FROM g_especialidad WHERE (Estado =0) ORDER BY Nbre ASC", this.xidgenerico, this.JCBGenerico);
                break;
            case "jifconsultorio":
                this.JCBGenerico.setBorder(BorderFactory.createTitledBorder((Border) null, "Clase de Consultorio", 0, 0, new Font("Arial", 1, 12), Color.blue));
                this.xidgenerico = this.xconsulta.llenarCombo("SELECT Id, Nbre, Estado FROM c_claseconsultorio ORDER BY Estado ASC", this.xidgenerico, this.JCBGenerico);
                break;
            case "jifbanco":
                this.JCBGenerico.setBorder(BorderFactory.createTitledBorder((Border) null, "Sucursal", 0, 0, new Font("Arial", 1, 12), Color.blue));
                this.xidgenerico = this.xconsulta.llenarCombo("SELECT Id, Nbre FROM g_municipio WHERE (Estado =0) ORDER BY Nbre ASC", this.xidgenerico, this.JCBGenerico);
                break;
            case "xjifunidadnegocio":
                this.JCBGenerico.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Empresa", 0, 0, new Font("Arial", 1, 12), Color.blue));
                this.xidgenerico = this.xconsulta.llenarCombo("SELECT Id , Nbre FROM g_tipoempresa WHERE (Estado =0) ORDER BY Nbre ASC", this.xidgenerico, this.JCBGenerico);
                break;
            case "xjiftipodetalleexamenf":
                this.JCBGenerico.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Exámen Físico", 0, 0, new Font("Arial", 1, 12), Color.blue));
                this.xidgenerico = this.xconsulta.llenarCombo("SELECT Id, Nbre FROM h_grupoexamenfisico ORDER BY Orden ASC", this.xidgenerico, this.JCBGenerico);
                break;
            case "xjifmotivoanulacion":
                this.JCBGenerico.setBorder(BorderFactory.createTitledBorder((Border) null, "Módulo", 0, 0, new Font("Arial", 1, 12), Color.blue));
                this.xidgenerico = this.xconsulta.llenarCombo("SELECT Id , Nbre FROM g_modulos WHERE (Estado =0) ORDER BY Nbre ASC", this.xidgenerico, this.JCBGenerico);
                break;
            case "xjifubicacion":
            case "xjifubicacion1":
                this.JCBGenerico.setBorder(BorderFactory.createTitledBorder((Border) null, "Unidad Funcional", 0, 0, new Font("Arial", 1, 12), Color.blue));
                this.xidgenerico = this.xconsulta.llenarCombo("SELECT Id, Nbre FROM rh_unidad_funcional WHERE (Estado =1) ORDER BY Nbre ASC", this.xidgenerico, this.JCBGenerico);
                break;
            case "xjiftipomedida":
                this.JCBGenerico.setBorder(BorderFactory.createTitledBorder((Border) null, "Unidad de Medida", 0, 0, new Font("Arial", 1, 12), Color.blue));
                this.xidgenerico = this.xconsulta.llenarCombo("SELECT `Id` , `Nbre` FROM `i_unidadmedida` WHERE (estado=0) ORDER BY Nbre ASC", this.xidgenerico, this.JCBGenerico);
                break;
            case "xjifelementospp":
                this.JCBGenerico.setBorder(BorderFactory.createTitledBorder((Border) null, "Partes", 0, 0, new Font("Arial", 1, 12), Color.blue));
                this.xidgenerico = this.xconsulta.llenarCombo("SELECT `Id` , `Nbre` FROM `g_so_elementos_partes` WHERE (estado=1) ORDER BY Nbre ASC", this.xidgenerico, this.JCBGenerico);
                break;
            case "xjiffsalacirugia":
                this.JCBGenerico.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo de Sala", 0, 0, new Font("Arial", 1, 12), Color.blue));
                this.xidgenerico = this.xconsulta.llenarCombo("SELECT`Id`, `Nbre`FROM `q_tiposala` WHERE (estado=1) ORDER BY Nbre ASC", this.xidgenerico, this.JCBGenerico);
                break;
        }
        this.JCBGenerico.setSelectedIndex(-1);
        this.xconsulta.cerrarConexionBd();
    }

    private void mRecargarCombo() {
        if (this.xnombre.equals("xjifubicacion1")) {
            this.xjifges.llenarComboUbicacion(this.nombre);
        }
    }
}
