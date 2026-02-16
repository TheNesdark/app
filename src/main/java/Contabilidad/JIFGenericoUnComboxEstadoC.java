package Contabilidad;

import Acceso.Principal;
import ParametrizacionN.JIFGenericoCh;
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
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Contabilidad/JIFGenericoUnComboxEstadoC.class */
public class JIFGenericoUnComboxEstadoC extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private Object[] xdatos;
    private String xnombre;
    private String[] xidgenerico2;
    private JComboBox JCBGenerico2;
    private JCheckBox JCHEstado;
    private JPanel JPIDatos;
    private JScrollPane JSPDetalle;
    private JSpinner JSPNOrden;
    private JTable JTDetalle;
    private ConsultasMySQL xconsulta = new ConsultasMySQL();
    private Metodos xmetodos = new Metodos();
    private int xestado = 1;
    private boolean xestadog = false;
    private Metodos xmt_t = new Metodos();

    public JIFGenericoUnComboxEstadoC(String xnombre, String xtitulo) {
        initComponents();
        setTitle(xtitulo.toUpperCase());
        setName(xnombre);
        this.xnombre = xnombre;
        mIniciarComponentes();
        mCargarDatosTabla();
    }

    /* JADX WARN: Type inference failed for: r3v29, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPIDatos = new JPanel();
        this.JCBGenerico2 = new JComboBox();
        this.JCHEstado = new JCheckBox();
        this.JSPNOrden = new JSpinner();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("Generico Combox");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifgenericocombox1");
        try {
            setSelected(true);
        } catch (PropertyVetoException e1) {
            e1.printStackTrace();
        }
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JCBGenerico2.setFont(new Font("Arial", 1, 13));
        this.JCBGenerico2.setBorder(BorderFactory.createTitledBorder((Border) null, "Generico2", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setSelected(true);
        this.JCHEstado.setText("Estado");
        this.JCHEstado.addActionListener(new ActionListener() { // from class: Contabilidad.JIFGenericoUnComboxEstadoC.1
            public void actionPerformed(ActionEvent evt) {
                JIFGenericoUnComboxEstadoC.this.JCHEstadoActionPerformed(evt);
            }
        });
        this.JSPNOrden.setFont(new Font("Arial", 1, 12));
        this.JSPNOrden.setModel(new SpinnerNumberModel(0, 0, (Comparable) null, 1));
        this.JSPNOrden.setBorder(BorderFactory.createTitledBorder((Border) null, "Orden", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosLayout.createSequentialGroup().addContainerGap().addComponent(this.JCBGenerico2, -2, 481, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPNOrden, -1, 68, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHEstado).addGap(10, 10, 10)));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JCBGenerico2, -2, -1, -2).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHEstado).addComponent(this.JSPNOrden, -2, -1, -2))).addContainerGap(-1, 32767)));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: Contabilidad.JIFGenericoUnComboxEstadoC.2
            public void mouseClicked(MouseEvent evt) {
                JIFGenericoUnComboxEstadoC.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JSPDetalle, GroupLayout.Alignment.LEADING, -1, 658, 32767).addComponent(this.JPIDatos, GroupLayout.Alignment.LEADING, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPDetalle, -1, 359, 32767).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            this.JCBGenerico2.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
            this.JCHEstado.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString()).booleanValue());
            if (Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString()).booleanValue()) {
                this.xestado = 1;
            } else {
                this.xestado = 0;
            }
            this.JSPNOrden.setValue(Long.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString()));
            this.xestadog = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEstadoActionPerformed(ActionEvent evt) {
        if (this.JCHEstado.isSelected()) {
            this.xestado = 1;
        } else {
            this.xestado = 0;
        }
    }

    public void mNuevo() {
        this.xestado = 1;
        this.JCBGenerico2.setSelectedIndex(-1);
        this.JCBGenerico2.requestFocus();
        this.JCHEstado.setSelected(true);
        this.xestado = 1;
        this.xestadog = false;
    }

    public void mGrabar() {
        String sql = null;
        if (!this.xestadog) {
            if (this.JCBGenerico2.getSelectedIndex() != -1) {
                if (!this.xmt_t.mVerificarDatosDoblesTabla(this.JTDetalle, 0, this.JCBGenerico2.getSelectedItem().toString())) {
                    int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    if (n == 0) {
                        if (this.xnombre.equals("jifconceptounidadf")) {
                            sql = " Insert ignore into  cc_conceptoxareaf(Id_Concepto, Id_UnidadF, Estado, Fecha, UsuarioS)  values ('" + Principal.txtNo.getText() + "','" + this.xidgenerico2[this.JCBGenerico2.getSelectedIndex()] + "','" + this.xestado + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                        } else if (this.xnombre.equals("jifsucursal")) {
                            sql = " Insert ignore into  cc_bancoxsucursal(Id_Banco, Id_Municipio, Estado, Fecha, UsuarioS)  values ('" + Principal.txtNo.getText() + "','" + this.xidgenerico2[this.JCBGenerico2.getSelectedIndex()] + "','" + this.xestado + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                        } else if (this.xnombre.equals("jiftiporegimen")) {
                            sql = " Insert ignore into  cc_tiporegimenxempresa(Id_Empresa, Id_TipoRegimen, Estado, Fecha, UsuarioS)  values ('" + Principal.txtNo.getText() + "','" + this.xidgenerico2[this.JCBGenerico2.getSelectedIndex()] + "','" + this.xestado + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                        } else if (this.xnombre.equals("jifunidadfempresa")) {
                            sql = " Insert ignore into  cc_unidadfuncionalxempresa(Id_Empresa, Id_UnidadF, Estado, Fecha, UsuarioS)  values ('" + Principal.txtNo.getText() + "','" + this.xidgenerico2[this.JCBGenerico2.getSelectedIndex()] + "','" + this.xestado + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                        } else if (this.xnombre.equals("jifdetallecontenido1")) {
                            sql = " Insert ignore into  o_tipo_contenidoxdescripcion(Id_tipo_contenido, Id_tipo_adescripcion, NOrden, Estado, UsuarioS)  values ('" + Principal.txtNo.getText() + "','" + this.xidgenerico2[this.JCBGenerico2.getSelectedIndex()] + "','" + this.JSPNOrden.getValue() + "','" + this.xestado + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                        } else if (this.xnombre.equals("jifparametrodetalle")) {
                            sql = " Insert ignore into  o_tipo_descripcionxparametro(Id_cdescipcion, Id_TipoParametro, NOrden, Estado, UsuarioS)  values ('" + Principal.txtNo.getText() + "','" + this.xidgenerico2[this.JCBGenerico2.getSelectedIndex()] + "','" + this.JSPNOrden.getValue() + "','" + this.xestado + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                        } else if (this.xnombre.equals("xjifconceptoxcaja")) {
                            sql = " Insert ignore into  k_cajaxconceptos(Id_Caja, Id_Concepto, Estado, UsuarioS)  values ('" + Principal.txtNo.getText() + "','" + this.xidgenerico2[this.JCBGenerico2.getSelectedIndex()] + "','" + this.xestado + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                        } else if (this.xnombre.equals("xjifcargosunidadf")) {
                            sql = " Insert ignore into  rh_unidadf_cargo(Id_UnidadF, Id_Cargo, Estado, Fecha, UsuarioS)  values ('" + Principal.txtNo.getText() + "','" + this.xidgenerico2[this.JCBGenerico2.getSelectedIndex()] + "','" + this.xestado + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                        } else if (this.xnombre.equals("xjifactividadsolictud")) {
                            sql = " Insert ignore into  s_solicitud_tactividad_tproceso(Id_Tipo_Solicitud, Id_Tipo_Actividad, Estado, Fecha, UsuarioS)  values ('" + Principal.txtNo.getText() + "','" + this.xidgenerico2[this.JCBGenerico2.getSelectedIndex()] + "','" + this.xestado + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                        } else if (this.xnombre.equals("xjifcontenidoxdetallehc")) {
                            sql = " Insert ignore into  h_ctipohcxdhistoria(Id_TipoHistoria, Id_CHhistoria, Orden, Estado, Fecha, UsuarioS)  values ('" + Principal.txtNo.getText() + "','" + this.xidgenerico2[this.JCBGenerico2.getSelectedIndex()] + "','" + this.JSPNOrden.getValue() + "','" + this.xestado + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                        } else if (this.xnombre.equals("xjifdetalleincumplimiento")) {
                            sql = " Insert ignore into  s_sgc_tincumplimiento_detalle(Id_TipoIncumplimiento, Id_TipoIncumpDetalle, Estado, UsuarioS)  values ('" + Principal.txtNo.getText() + "','" + this.xidgenerico2[this.JCBGenerico2.getSelectedIndex()] + "','" + this.xestado + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                        } else if (this.xnombre.equals("xjifnovconceptonomina")) {
                            sql = " Insert ignore into  rh_nomina_novedad_concepto(Id_Novedad, Id_Concepto, Estado, UsuarioS)  values ('" + Principal.txtNo.getText() + "','" + this.xidgenerico2[this.JCBGenerico2.getSelectedIndex()] + "','" + this.xestado + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                        }
                        this.xconsulta.ejecutarSQL(sql);
                        this.xconsulta.cerrarConexionBd();
                        mCargarDatosTabla();
                        return;
                    }
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Esta Configuración ya existe", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JCBGenerico2.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar el item del combo 2", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBGenerico2.requestFocus();
            return;
        }
        if (this.xnombre.equals("jifconceptounidadf")) {
            sql = "update cc_conceptoxareaf set Estado='" + this.xestado + "',Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "',UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' where Id_Concepto='" + Principal.txtNo.getText() + "' and Id_UnidadF='" + this.xidgenerico2[this.JCBGenerico2.getSelectedIndex()] + "'";
        } else if (this.xnombre.equals("jifsucursal")) {
            sql = "update cc_bancoxsucursal set Estado='" + this.xestado + "',Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "',UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' where Id_Banco='" + Principal.txtNo.getText() + "' and Id_Municipio='" + this.xidgenerico2[this.JCBGenerico2.getSelectedIndex()] + "'";
        } else if (this.xnombre.equals("jiftiporegimen")) {
            sql = "update cc_tiporegimenxempresa set Estado='" + this.xestado + "',Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "',UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' where Id_Empresa='" + Principal.txtNo.getText() + "' and Id_TipoRegimen='" + this.xidgenerico2[this.JCBGenerico2.getSelectedIndex()] + "'";
        } else if (this.xnombre.equals("jifunidadfempresa")) {
            sql = "update cc_unidadfuncionalxempresa set Estado='" + this.xestado + "',Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "',UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' where Id_Empresa='" + Principal.txtNo.getText() + "' and Id_TipoRegimen='" + this.xidgenerico2[this.JCBGenerico2.getSelectedIndex()] + "'";
        } else if (this.xnombre.equals("jifdetallecontenido1")) {
            sql = "update o_tipo_contenidoxdescripcion set Estado='" + this.xestado + "',NOrden='" + this.JSPNOrden.getValue() + "',Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "',UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' where Id='" + this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString() + "'";
        } else if (this.xnombre.equals("jifparametrodetalle")) {
            sql = "update o_tipo_descripcionxparametro set Estado='" + this.xestado + "',NOrden='" + this.JSPNOrden.getValue() + "',Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "',UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' where Id_cdescipcion='" + Principal.txtNo.getText() + "' and Id_TipoParametro='" + this.xidgenerico2[this.JCBGenerico2.getSelectedIndex()] + "'";
        } else if (this.xnombre.equals("xjifconceptoxcaja")) {
            sql = "update k_cajaxconceptos set Estado='" + this.xestado + "',Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "',UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' where Id_Caja='" + Principal.txtNo.getText() + "' and Id_Concepto='" + this.xidgenerico2[this.JCBGenerico2.getSelectedIndex()] + "'";
        } else if (this.xnombre.equals("xjifcargosunidadf")) {
            sql = "update rh_unidadf_cargo set Estado='" + this.xestado + "',Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "',UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' where Id_UnidadF='" + Principal.txtNo.getText() + "' and Id_Cargo='" + this.xidgenerico2[this.JCBGenerico2.getSelectedIndex()] + "'";
        } else if (this.xnombre.equals("xjifactividadsolictud")) {
            sql = "update s_solicitud_tactividad_tproceso set Estado='" + this.xestado + "',Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "',UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' where Id_Tipo_Solicitud='" + Principal.txtNo.getText() + "' and Id_Tipo_Actividad='" + this.xidgenerico2[this.JCBGenerico2.getSelectedIndex()] + "'";
        } else if (this.xnombre.equals("xjifcontenidoxdetallehc")) {
            sql = "update h_ctipohcxdhistoria set Estado='" + this.xestado + "',Orden='" + this.JSPNOrden.getValue() + "',Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "',UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' where Id_TipoHistoria='" + Principal.txtNo.getText() + "' and Id_CHhistoria='" + this.xidgenerico2[this.JCBGenerico2.getSelectedIndex()] + "'";
        } else if (this.xnombre.equals("xjifdetalleincumplimiento")) {
            sql = "update s_sgc_tincumplimiento_detalle set Estado='" + this.xestado + "',Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "',UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' where  Id_TipoIncumplimiento='" + Principal.txtNo.getText() + "' and Id_TipoIncumpDetalle='" + this.xidgenerico2[this.JCBGenerico2.getSelectedIndex()] + "'";
        } else if (this.xnombre.equals("xjifnovconceptonomina")) {
            sql = "update rh_nomina_novedad_concepto set Estado='" + this.xestado + "',Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "',UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' where  Id_Novedad='" + Principal.txtNo.getText() + "' and Id_Concepto='" + this.xidgenerico2[this.JCBGenerico2.getSelectedIndex()] + "'";
        }
        this.xconsulta.ejecutarSQL(sql);
        this.xconsulta.cerrarConexionBd();
        mCargarDatosTabla();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos(String[] xcabecera) {
        this.xmodelo = new DefaultTableModel(new Object[0], xcabecera) { // from class: Contabilidad.JIFGenericoUnComboxEstadoC.3
            Class[] types = {String.class, Boolean.class, Long.class, Long.class};
            boolean[] canEdit = {false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(250);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(2).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(2).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(20);
        if (this.xnombre.equals("xjifcargosunidadf") || this.xnombre.equals("xjifnovconceptonomina") || this.xnombre.equals("xjifactividadsolictud") || this.xnombre.equals("xjifdetalleincumplimiento")) {
            this.JTDetalle.getColumnModel().getColumn(3).setMinWidth(0);
            this.JTDetalle.getColumnModel().getColumn(3).setMaxWidth(0);
        }
    }

    private void mCargarDatosTabla() {
        try {
            String sql = null;
            String[] xencabezado = null;
            if (this.xnombre.equals("jifconceptounidadf")) {
                xencabezado = new String[]{"Unidad Funcional", "Estado", "Id", "Orden"};
                sql = "SELECT cc_unidad_funcional.Nbre, cc_unidad_funcional.Estado  FROM cc_conceptoxareaf INNER JOIN cc_unidad_funcional  ON (cc_conceptoxareaf.Id_UnidadF = cc_unidad_funcional.Id) WHERE (cc_conceptoxareaf.Id_Concepto ='" + Principal.txtNo.getText() + "') ORDER BY cc_unidad_funcional.Nbre ASC ";
            } else if (this.xnombre.equals("jifsucursal")) {
                xencabezado = new String[]{"Sucursal", "Estado", "Id", "Orden"};
                sql = "SELECT g_municipio.Nbre, cc_bancoxsucursal.Estado FROM cc_bancoxsucursal INNER JOIN cc_banco  ON (cc_bancoxsucursal.Id_Banco = cc_banco.Id) INNER JOIN g_municipio ON (cc_bancoxsucursal.Id_Municipio = g_municipio.Id) WHERE (cc_banco.Id ='" + Principal.txtNo.getText() + "') ORDER BY g_municipio.Nbre ASC ";
            } else if (this.xnombre.equals("jiftiporegimen")) {
                xencabezado = new String[]{"Tipo Régimen", "Estado", "Id", "Orden"};
                sql = "SELECT cc_tipo_regimen.Nbre, cc_tiporegimenxempresa.Estado FROM cc_tiporegimenxempresa INNER JOIN cc_tipo_regimen  ON (cc_tiporegimenxempresa.Id_TipoRegimen = cc_tipo_regimen.Id) WHERE (cc_tiporegimenxempresa.Id_Empresa ='" + Principal.txtNo.getText() + "') ORDER BY cc_tipo_regimen.Nbre ASC ";
            } else if (this.xnombre.equals("jifunidadfempresa")) {
                xencabezado = new String[]{"Unidad Funcional", "Estado", "Id", "Orden"};
                sql = "SELECT  cc_unidad_funcional.Nbre, cc_unidadfuncionalxempresa.Estado  FROM cc_unidadfuncionalxempresa INNER JOIN cc_unidad_funcional ON (cc_unidadfuncionalxempresa.Id_UnidadF = cc_unidad_funcional.Id) WHERE (cc_unidadfuncionalxempresa.Id_Empresa ='" + Principal.txtNo.getText() + "') ORDER BY cc_unidad_funcional.Nbre ASC ";
            } else if (this.xnombre.equals("jifdetallecontenido1")) {
                xencabezado = new String[]{"Detalle", "Estado", "ID", "Orden"};
                sql = "SELECT o_tipo_contenido_descripcion.Nbre, o_tipo_contenidoxdescripcion.Estado, o_tipo_contenidoxdescripcion.Id,o_tipo_contenidoxdescripcion.NOrden  FROM o_tipo_contenidoxdescripcion INNER JOIN o_tipo_contenido_descripcion  ON (o_tipo_contenidoxdescripcion.Id_tipo_adescripcion = o_tipo_contenido_descripcion.Id) WHERE (o_tipo_contenidoxdescripcion.Id_tipo_contenido ='" + Principal.txtNo.getText() + "') ORDER BY o_tipo_contenido_descripcion.Nbre ASC ";
            } else if (this.xnombre.equals("jifparametrodetalle")) {
                xencabezado = new String[]{"Parametro", "Estado", "ID", "Orden"};
                sql = "SELECT o_tipo_parametros.Nbre, o_tipo_descripcionxparametro.Estado , 0 as Id , o_tipo_descripcionxparametro.NOrden FROM o_tipo_descripcionxparametro INNER JOIN o_tipo_parametros  ON (o_tipo_descripcionxparametro.Id_TipoParametro = o_tipo_parametros.Id) WHERE (o_tipo_descripcionxparametro.Id_cdescipcion ='" + Principal.txtNo.getText() + "') ORDER BY o_tipo_parametros.Nbre ASC ";
            } else if (this.xnombre.equals("xjifconceptoxcaja")) {
                xencabezado = new String[]{"Concepto", "Estado", "ID", "Orden"};
                sql = "SELECT k_conceptos.Nbre, k_cajaxconceptos.Estado, k_conceptos.Id,  k_conceptos.Orden FROM k_cajaxconceptos INNER JOIN k_conceptos  ON (k_cajaxconceptos.Id_Concepto = k_conceptos.Id) WHERE (k_cajaxconceptos.Id_Caja ='" + Principal.txtNo.getText() + "') ORDER BY k_conceptos.Nbre ASC ";
            } else if (this.xnombre.equals("xjifcargosunidadf")) {
                xencabezado = new String[]{"Cargo", "Estado", "Id", "Orden"};
                sql = "SELECT rh_tipo_cargo.Nbre, rh_unidadf_cargo.Estado, rh_tipo_cargo.Id , rh_unidadf_cargo.Id FROM rh_unidadf_cargo INNER JOIN rh_tipo_cargo  ON (rh_unidadf_cargo.Id_Cargo = rh_tipo_cargo.Id) WHERE (rh_unidadf_cargo.Id_UnidadF ='" + Principal.txtNo.getText() + "') ORDER BY rh_tipo_cargo.Nbre ASC ";
            } else if (this.xnombre.equals("xjifactividadsolictud")) {
                xencabezado = new String[]{"Actividad", "Estado", "Id", "Orden"};
                sql = "SELECT  s_solicitud_tipo_actividad.Nbre, s_solicitud_tactividad_tproceso.Estado FROM s_solicitud_tactividad_tproceso INNER JOIN s_solicitud_tipo_actividad  ON (s_solicitud_tactividad_tproceso.Id_Tipo_Actividad = s_solicitud_tipo_actividad.Id) WHERE (s_solicitud_tactividad_tproceso.Id_Tipo_Solicitud ='" + Principal.txtNo.getText() + "') ORDER BY s_solicitud_tipo_actividad.Nbre ASC ";
            } else if (this.xnombre.equals("xjifcontenidoxdetallehc")) {
                xencabezado = new String[]{"Actividad", "Estado", "Id", "Orden"};
                sql = "SELECT h_chistoria.Nbre, h_ctipohcxdhistoria.Estado, h_chistoria.Id, h_ctipohcxdhistoria.Orden FROM h_ctipohcxdhistoria  INNER JOIN h_chistoria  ON (h_ctipohcxdhistoria.Id_CHhistoria = h_chistoria.Id)WHERE (h_ctipohcxdhistoria.Id_TipoHistoria ='" + Principal.txtNo.getText() + "') ORDER BY h_ctipohcxdhistoria.Orden ASC ";
            } else if (this.xnombre.equals("xjifdetalleincumplimiento")) {
                xencabezado = new String[]{"Incumplimiento", "Estado", "Id", "Orden"};
                sql = "SELECT `s_sgc_tipoincumplimiento_detalle`.`Nbre`, `s_sgc_tipoincumplimiento_detalle`.`Estado`, `s_sgc_tincumplimiento_detalle`.`Id`,0 FROM`s_sgc_tincumplimiento_detalle`INNER JOIN `s_sgc_tipoincumplimiento_detalle` ON (`s_sgc_tincumplimiento_detalle`.`Id_TipoIncumpDetalle` = `s_sgc_tipoincumplimiento_detalle`.`Id`)WHERE (`s_sgc_tincumplimiento_detalle`.`Id_TipoIncumplimiento` ='" + Principal.txtNo.getText() + "') ORDER BY `s_sgc_tipoincumplimiento_detalle`.`Nbre` ASC;";
            } else if (this.xnombre.equals("xjifnovconceptonomina")) {
                xencabezado = new String[]{"Concepto", "Estado", "Id", "Orden"};
                sql = "SELECT rh_nomina_conceptos.Nbre, rh_nomina_novedad_concepto.Estado, rh_nomina_novedad_concepto.Id, 0 FROM rh_nomina_novedad_concepto INNER JOIN rh_nomina_conceptos  ON (rh_nomina_novedad_concepto.Id_Concepto = rh_nomina_conceptos.Id) WHERE (rh_nomina_novedad_concepto.Id_Novedad ='" + Principal.txtNo.getText() + "') order by rh_nomina_conceptos.Nbre";
            }
            mCrearModeloDatos(xencabezado);
            ResultSet xrs = this.xconsulta.traerRs(sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(xrs.getString(1), n, 0);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(2)), n, 1);
                    if (this.xnombre.equals("jifdetallecontenido1") || this.xnombre.equals("jifparametrodetalle") || this.xnombre.equals("xjifcargosunidadf") || this.xnombre.equals("xjifdetalleincumplimiento") || this.xnombre.equals("xjifcontenidoxdetallehc") || this.xnombre.equals("xjifnovconceptonomina") || this.xnombre.equals("xjifconceptoxcaja")) {
                        this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(3)), n, 2);
                        this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(4)), n, 3);
                    } else {
                        this.xmodelo.setValueAt(new Long(0L), n, 2);
                        this.xmodelo.setValueAt(new Long(0L), n, 3);
                    }
                    n++;
                }
            }
            xrs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFGenericoCh.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mIniciarComponentes() {
        if (this.xnombre.equals("jifconceptounidadf")) {
            this.JCBGenerico2.setBorder(BorderFactory.createTitledBorder((Border) null, "Unidad Funcional", 0, 0, new Font("Arial", 1, 12), Color.blue));
            this.xidgenerico2 = this.xconsulta.llenarCombo("SELECT Id, Nbre FROM cc_unidad_funcional WHERE (Estado =1) ORDER BY Nbre ASC", this.xidgenerico2, this.JCBGenerico2);
        } else if (this.xnombre.equals("jifsucursal")) {
            this.JSPNOrden.setVisible(false);
            this.JCBGenerico2.setBorder(BorderFactory.createTitledBorder((Border) null, "Sucursal", 0, 0, new Font("Arial", 1, 12), Color.blue));
            this.xidgenerico2 = this.xconsulta.llenarCombo("SELECT Id, Nbre FROM g_municipio WHERE (Estado =0) ORDER BY Nbre ASC", this.xidgenerico2, this.JCBGenerico2);
        } else if (this.xnombre.equals("jiftiporegimen")) {
            this.JSPNOrden.setVisible(false);
            this.JCBGenerico2.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Régimen", 0, 0, new Font("Arial", 1, 12), Color.blue));
            this.xidgenerico2 = this.xconsulta.llenarCombo("SELECT Id , Nbre FROM cc_tipo_regimen WHERE (Estado =1) ORDER BY Nbre ASC", this.xidgenerico2, this.JCBGenerico2);
        } else if (this.xnombre.equals("jifunidadfempresa")) {
            this.JSPNOrden.setVisible(false);
            this.JCBGenerico2.setBorder(BorderFactory.createTitledBorder((Border) null, "Unidad Funcional", 0, 0, new Font("Arial", 1, 12), Color.blue));
            this.xidgenerico2 = this.xconsulta.llenarCombo("SELECT Id, Nbre FROM cc_unidad_funcional WHERE (Estado =1) ORDER BY Nbre ASC", this.xidgenerico2, this.JCBGenerico2);
        } else if (this.xnombre.equals("jifdetallecontenido1")) {
            this.JCBGenerico2.setBorder(BorderFactory.createTitledBorder((Border) null, "Detalle Contenido", 0, 0, new Font("Arial", 1, 12), Color.blue));
            this.xidgenerico2 = this.xconsulta.llenarCombo("SELECT Id, Nbre FROM o_tipo_contenido_descripcion WHERE (Estado =1) ORDER BY Nbre ASC", this.xidgenerico2, this.JCBGenerico2);
        } else if (this.xnombre.equals("jifparametrodetalle")) {
            this.JCBGenerico2.setBorder(BorderFactory.createTitledBorder((Border) null, "Parametro", 0, 0, new Font("Arial", 1, 12), Color.blue));
            this.xidgenerico2 = this.xconsulta.llenarCombo("SELECT Id, Nbre FROM o_tipo_parametros WHERE (Estado =1) ORDER BY Nbre ASC", this.xidgenerico2, this.JCBGenerico2);
        } else if (this.xnombre.equals("xjifconceptoxcaja")) {
            this.JSPNOrden.setVisible(false);
            this.JCBGenerico2.setBorder(BorderFactory.createTitledBorder((Border) null, "Concepto", 0, 0, new Font("Arial", 1, 12), Color.blue));
            this.xidgenerico2 = this.xconsulta.llenarCombo("SELECT Id, Nbre  FROM k_conceptos WHERE (Estado =1) ORDER BY Nbre ASC", this.xidgenerico2, this.JCBGenerico2);
        } else if (this.xnombre.equals("xjifcargosunidadf")) {
            this.JSPNOrden.setVisible(false);
            this.JCBGenerico2.setBorder(BorderFactory.createTitledBorder((Border) null, "Cargos", 0, 0, new Font("Arial", 1, 12), Color.blue));
            this.xidgenerico2 = this.xconsulta.llenarCombo("SELECT Id, Nbre FROM rh_tipo_cargo WHERE (Estado =1) ORDER BY Nbre ASC", this.xidgenerico2, this.JCBGenerico2);
        } else if (this.xnombre.equals("xjifactividadsolictud")) {
            this.JSPNOrden.setVisible(false);
            this.JCBGenerico2.setBorder(BorderFactory.createTitledBorder((Border) null, "Actividad", 0, 0, new Font("Arial", 1, 12), Color.blue));
            this.xidgenerico2 = this.xconsulta.llenarCombo("SELECT Id , Nbre FROM s_solicitud_tipo_actividad WHERE (Estado =1) ORDER BY Nbre ASC", this.xidgenerico2, this.JCBGenerico2);
        } else if (this.xnombre.equals("xjifcontenidoxdetallehc")) {
            this.JCBGenerico2.setBorder(BorderFactory.createTitledBorder((Border) null, "Detalle", 0, 0, new Font("Arial", 1, 12), Color.blue));
            this.xidgenerico2 = this.xconsulta.llenarCombo("SELECT Id, Nbre FROM h_chistoria WHERE (Estado =1) ORDER BY Nbre ASC", this.xidgenerico2, this.JCBGenerico2);
        } else if (this.xnombre.equals("xjifdetalleincumplimiento")) {
            this.JSPNOrden.setVisible(false);
            this.JCBGenerico2.setBorder(BorderFactory.createTitledBorder((Border) null, "Detalle", 0, 0, new Font("Arial", 1, 12), Color.blue));
            this.xidgenerico2 = this.xconsulta.llenarCombo("SELECT Id, Nbre FROM s_sgc_tipoincumplimiento_detalle WHERE (Estado =1) ORDER BY Nbre ASC", this.xidgenerico2, this.JCBGenerico2);
        } else if (this.xnombre.equals("xjifnovconceptonomina")) {
            this.JSPNOrden.setVisible(false);
            this.JCBGenerico2.setBorder(BorderFactory.createTitledBorder((Border) null, "Concepto", 0, 0, new Font("Arial", 1, 12), Color.blue));
            this.xidgenerico2 = this.xconsulta.llenarCombo("SELECT Id, Nbre FROM rh_nomina_conceptos WHERE (Estado =1) ORDER BY Nbre ASC", this.xidgenerico2, this.JCBGenerico2);
        }
        this.JCBGenerico2.setSelectedIndex(-1);
        this.xconsulta.cerrarConexionBd();
    }
}
