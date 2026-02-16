package Contabilidad;

import Acceso.Principal;
import Activos.JIFGestionActivos;
import ParametrizacionN.JIFGenerico1Text1Combo2CheckBox;
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
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Contabilidad/JIFGenerico1CheckBoxC.class */
public class JIFGenerico1CheckBoxC extends JInternalFrame {
    private ConsultasMySQL xconsulta;
    private Metodos xmetodos;
    private int xestado;
    private int xestado1;
    private DefaultTableModel xmodelo;
    private Object[] xdatos;
    private String xnombre;
    private String xid;
    private boolean xestado2;
    private JIFGestionActivos xjifges;
    private JIFGenerico1Text1Combo2CheckBox xAntecedentes;
    private String nombre;
    private JButton JBAntecedentesPatologicos;
    private JButton JBTDatosA;
    private JButton JBTExaFisico;
    private JCheckBox JCHDos;
    private JCheckBox JCHEstado;
    private JPanel JPIDatos;
    private JScrollPane JSPDetalle;
    private JSpinner JSPUno;
    private JTable JTDetalle;
    private JTextField JTFNombre;

    public JIFGenerico1CheckBoxC(String xnombre, String xnombref) {
        this.xconsulta = new ConsultasMySQL();
        this.xmetodos = new Metodos();
        this.xestado = 1;
        this.xestado1 = 1;
        this.xid = "";
        this.xestado2 = false;
        this.nombre = "";
        initComponents();
        setName(xnombref);
        setTitle(xnombre.toUpperCase());
        this.xnombre = xnombre;
        if (this.xnombre.equals("Tipo de Novedad")) {
            mCargarTablaConTipo();
        } else {
            mCargarDatosTabla();
        }
        mIniciarBoton();
    }

    public JIFGenerico1CheckBoxC(String xnombre, String xnombref, JIFGestionActivos xjifgestion, boolean xestado) {
        this.xconsulta = new ConsultasMySQL();
        this.xmetodos = new Metodos();
        this.xestado = 1;
        this.xestado1 = 1;
        this.xid = "";
        this.xestado2 = false;
        this.nombre = "";
        initComponents();
        this.xestado2 = true;
        this.xjifges = xjifgestion;
        setName(xnombref);
        setTitle(xnombre.toUpperCase());
        this.xnombre = xnombre;
        mCargarDatosTabla();
        mIniciarBoton();
    }

    /* JADX WARN: Type inference failed for: r3v33, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPIDatos = new JPanel();
        this.JTFNombre = new JTextField();
        this.JCHEstado = new JCheckBox();
        this.JCHDos = new JCheckBox();
        this.JSPUno = new JSpinner();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JBTDatosA = new JButton();
        this.JBTExaFisico = new JButton();
        this.JBAntecedentesPatologicos = new JButton();
        setClosable(true);
        setIconifiable(true);
        setTitle("Municipio");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifgenerico1chbox");
        try {
            setSelected(true);
        } catch (PropertyVetoException e1) {
            e1.printStackTrace();
        }
        addInternalFrameListener(new InternalFrameListener() { // from class: Contabilidad.JIFGenerico1CheckBoxC.1
            public void internalFrameOpened(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                JIFGenerico1CheckBoxC.this.formInternalFrameClosing(evt);
            }

            public void internalFrameClosed(InternalFrameEvent evt) {
            }

            public void internalFrameIconified(InternalFrameEvent evt) {
            }

            public void internalFrameDeiconified(InternalFrameEvent evt) {
            }

            public void internalFrameActivated(InternalFrameEvent evt) {
            }

            public void internalFrameDeactivated(InternalFrameEvent evt) {
            }
        });
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JTFNombre.setFont(new Font("Arial", 1, 13));
        this.JTFNombre.setToolTipText("");
        this.JTFNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setSelected(true);
        this.JCHEstado.setText("Estado");
        this.JCHEstado.addActionListener(new ActionListener() { // from class: Contabilidad.JIFGenerico1CheckBoxC.2
            public void actionPerformed(ActionEvent evt) {
                JIFGenerico1CheckBoxC.this.JCHEstadoActionPerformed(evt);
            }
        });
        this.JCHDos.setFont(new Font("Arial", 1, 12));
        this.JCHDos.setSelected(true);
        this.JCHDos.setText("Estado");
        this.JCHDos.addActionListener(new ActionListener() { // from class: Contabilidad.JIFGenerico1CheckBoxC.3
            public void actionPerformed(ActionEvent evt) {
                JIFGenerico1CheckBoxC.this.JCHDosActionPerformed(evt);
            }
        });
        this.JSPUno.setFont(new Font("Arial", 1, 12));
        this.JSPUno.setModel(new SpinnerNumberModel(0, 0, 1, 1));
        this.JSPUno.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addComponent(this.JTFNombre, -2, 380, -2).addGap(18, 18, 18).addComponent(this.JSPUno, -2, 72, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JCHDos, -1, 104, 32767).addComponent(this.JCHEstado, -1, -1, 32767)).addGap(19, 19, 19)));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosLayout.createSequentialGroup().addContainerGap(-1, 32767).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JSPUno).addComponent(this.JTFNombre).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosLayout.createSequentialGroup().addComponent(this.JCHEstado).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHDos))).addContainerGap()));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: Contabilidad.JIFGenerico1CheckBoxC.4
            public void mouseClicked(MouseEvent evt) {
                JIFGenerico1CheckBoxC.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.JBTDatosA.setFont(new Font("Arial", 1, 13));
        this.JBTDatosA.setText("Concepto x Unidad Funcional");
        this.JBTDatosA.setEnabled(false);
        this.JBTDatosA.addActionListener(new ActionListener() { // from class: Contabilidad.JIFGenerico1CheckBoxC.5
            public void actionPerformed(ActionEvent evt) {
                JIFGenerico1CheckBoxC.this.JBTDatosAActionPerformed(evt);
            }
        });
        this.JBTExaFisico.setFont(new Font("Arial", 1, 13));
        this.JBTExaFisico.setText("Detalle Examen Físico");
        this.JBTExaFisico.setEnabled(false);
        this.JBTExaFisico.addActionListener(new ActionListener() { // from class: Contabilidad.JIFGenerico1CheckBoxC.6
            public void actionPerformed(ActionEvent evt) {
                JIFGenerico1CheckBoxC.this.JBTExaFisicoActionPerformed(evt);
            }
        });
        this.JBAntecedentesPatologicos.setFont(new Font("Arial", 1, 13));
        this.JBAntecedentesPatologicos.setText("Antecendentes Patologicos");
        this.JBAntecedentesPatologicos.setEnabled(false);
        this.JBAntecedentesPatologicos.addActionListener(new ActionListener() { // from class: Contabilidad.JIFGenerico1CheckBoxC.7
            public void actionPerformed(ActionEvent evt) {
                JIFGenerico1CheckBoxC.this.JBAntecedentesPatologicosActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPDetalle, -1, 649, 32767).addComponent(this.JBTDatosA, -1, -1, 32767).addComponent(this.JBTExaFisico, -1, -1, 32767).addComponent(this.JPIDatos, -1, -1, 32767).addComponent(this.JBAntecedentesPatologicos, GroupLayout.Alignment.TRAILING, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.JPIDatos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalle, -2, 276, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTDatosA, -2, 48, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTExaFisico, -2, 50, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBAntecedentesPatologicos, -2, 50, -2).addContainerGap(-1, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEstadoActionPerformed(ActionEvent evt) {
        if (this.JCHEstado.isSelected()) {
            if (this.xnombre.equals("Tipo HC")) {
                this.xestado = 0;
                return;
            } else {
                this.xestado = 1;
                return;
            }
        }
        if (this.xnombre.equals("Tipo HC")) {
            this.xestado = 1;
        } else {
            this.xestado = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            Principal.txtNo.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
            this.JTFNombre.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString());
            this.JCHEstado.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString()).booleanValue());
            if (this.JCHEstado.isSelected()) {
                if (this.xnombre.equals("Tipo HC")) {
                    this.xestado = 0;
                } else {
                    this.xestado = 1;
                }
            } else if (this.xnombre.equals("Tipo HC")) {
                this.xestado = 1;
            } else {
                this.xestado = 0;
            }
            if (this.xnombre.equals("Tipo Solicitud") || this.xnombre.equals("Concepto Caja") || this.xnombre.equals("Diagnóstico Odontológicos") || this.xnombre.equals("Detalle Contenido HC Odontologica") || this.xnombre.equals("Detalle Concepto Anticipo") || this.xnombre.equals("Entidad")) {
                this.JCHDos.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString()).booleanValue());
                if (this.JCHDos.isSelected()) {
                    this.xestado1 = 1;
                } else {
                    this.xestado1 = 0;
                }
            }
            this.JBTDatosA.setEnabled(true);
            if (this.xnombre.equals("Tipo HC")) {
                this.JBTExaFisico.setEnabled(true);
                this.JBAntecedentesPatologicos.setEnabled(true);
            } else {
                this.JBTExaFisico.setEnabled(false);
                this.JBAntecedentesPatologicos.setEnabled(false);
            }
            if (this.xnombre.equals("Tipo de Novedad")) {
                this.JSPUno.setValue(Long.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTDatosAActionPerformed(ActionEvent evt) {
        if (!Principal.txtNo.getText().isEmpty()) {
            if (this.xnombre.equals("Concepto")) {
                this.JBTDatosA.setEnabled(true);
                Principal.claseparametrizacionn.cargarPantalla("Concepto x Unidad Funcional");
                return;
            }
            if (this.xnombre.equals("Detalle Concepto")) {
                this.JBTDatosA.setEnabled(true);
                Principal.claseparametrizacionn.cargarPantalla("Detalle Concepto x Unidad Funcional");
                return;
            }
            if (this.xnombre.equals("Banco")) {
                this.JBTDatosA.setEnabled(true);
                Principal.claseparametrizacionn.cargarPantalla("Sucursal");
                return;
            }
            if (this.xnombre.equals("Tipo Impuesto")) {
                this.JBTDatosA.setEnabled(true);
                Principal.claseparametrizacionn.cargarPantalla("%");
                return;
            }
            if (this.xnombre.equals("Contenido HC Odontologica")) {
                this.JBTDatosA.setEnabled(true);
                Principal.claseparametrizacionn.cargarPantalla("Detalle Contenido");
                return;
            }
            if (this.xnombre.equals("Detalle Contenido HC Odontologica")) {
                this.JBTDatosA.setEnabled(true);
                Principal.claseparametrizacionn.cargarPantalla("Parametro Detalle");
                return;
            }
            if (this.xnombre.equals("Tipo Solicitud")) {
                this.JBTDatosA.setEnabled(true);
                Principal.claseparametrizacionn.cargarPantalla("Actividad Solicitud");
                return;
            }
            if (this.xnombre.equals("Tipo HC")) {
                this.JBTDatosA.setEnabled(true);
                Principal.claseparametrizacionn.cargarPantalla("Contenido x Detalle HC");
            } else if (this.xnombre.equals("Incumplimiento")) {
                this.JBTDatosA.setEnabled(true);
                Principal.claseparametrizacionn.cargarPantalla("Detalle de Incumplimientos");
            } else if (this.xnombre.equals("Novedades Nomina")) {
                this.JBTDatosA.setEnabled(true);
                Principal.claseparametrizacionn.cargarPantalla("Novedades por Concepto de Nomina");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosing(InternalFrameEvent evt) {
        Principal.mLimpiarDatosP();
        if (this.xestado2) {
            mRecargarCombo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHDosActionPerformed(ActionEvent evt) {
        if (this.JCHDos.isSelected()) {
            this.xestado1 = 1;
        } else {
            this.xestado1 = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTExaFisicoActionPerformed(ActionEvent evt) {
        this.JBTExaFisico.setEnabled(true);
        Principal.claseparametrizacionn.cargarPantalla("Detalle Examen Físico");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBAntecedentesPatologicosActionPerformed(ActionEvent evt) {
        Principal.claseparametrizacionn.cargarPantalla("Antecedentes Patológicos", Integer.parseInt(Principal.txtNo.getText()));
    }

    public void mNuevo() {
        Principal.mLimpiarDatosP();
        this.JTFNombre.setText("");
        this.JCHEstado.setSelected(true);
        this.JCHDos.setSelected(true);
        if (this.xnombre.equals("Tipo HC")) {
            this.xestado = 0;
        } else {
            this.xestado = 1;
        }
        this.xestado1 = 1;
        this.JBTDatosA.setEnabled(false);
        this.JBTExaFisico.setEnabled(false);
        this.JTFNombre.requestFocus();
    }

    public void mGrabar() {
        if (!this.JTFNombre.getText().isEmpty()) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                String sql = null;
                this.nombre = this.JTFNombre.getText().toUpperCase();
                if (Principal.txtNo.getText().isEmpty()) {
                    if (this.xnombre.equals("Concepto")) {
                        sql = " Insert into cc_conceptoppt(Nbre, Estado, Fecha, UsuarioS)  values ('" + this.JTFNombre.getText().toUpperCase() + "','" + this.xestado + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                    } else if (this.xnombre.equals("Detalle Concepto")) {
                        sql = " Insert into cc_detalle_conceptoppt(Nbre, Estado, Fecha, UsuarioS)  values ('" + this.JTFNombre.getText().toUpperCase() + "','" + this.xestado + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                    } else if (this.xnombre.equals("Tipo Régimen")) {
                        sql = " Insert into cc_tipo_regimen(Nbre, Estado, Fecha, UsuarioS)  values ('" + this.JTFNombre.getText().toUpperCase() + "','" + this.xestado + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                    } else if (this.xnombre.equals("Banco")) {
                        sql = " Insert into cc_banco(Nbre, Estado, Fecha, UsuarioS)  values ('" + this.JTFNombre.getText().toUpperCase() + "','" + this.xestado + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                    } else if (this.xnombre.equals("Concepto Anticipo")) {
                        sql = " Insert into cc_concepto_anticipos(Nbre, Estado, Fecha, UsuarioS)  values ('" + this.JTFNombre.getText().toUpperCase() + "','" + this.xestado + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                    } else if (this.xnombre.equals("Tipo Impuesto")) {
                        sql = " Insert into cc_tipo_impuesto(Nbre, Estado, Fecha, UsuarioS)  values ('" + this.JTFNombre.getText().toUpperCase() + "','" + this.xestado + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                    } else if (this.xnombre.equals("Conceptos de Radicacion")) {
                        sql = " Insert into cc_conceptocmsa(Nbre, Estado, Fecha, UsuarioS)  values ('" + this.JTFNombre.getText().toUpperCase() + "','" + this.xestado + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                    } else if (this.xnombre.equals("Tipo Cuenta")) {
                        sql = " Insert into cc_tipo_cuenta(Nbre, Estado, Fecha, UsuarioS)  values ('" + this.JTFNombre.getText().toUpperCase() + "','" + this.xestado + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                    } else if (this.xnombre.equals("Tipo Documento C")) {
                        sql = " Insert into cc_tipo_documentoc(Nbre, Estado, Fecha, UsuarioS)  values ('" + this.JTFNombre.getText().toUpperCase() + "','" + this.xestado + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                    } else if (this.xnombre.equals("Condiciones")) {
                        sql = " Insert into cc_tipo_condiciones_compra(Nbre, Estado, Fecha, UsuarioS)  values ('" + this.JTFNombre.getText().toUpperCase() + "','" + this.xestado + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                    } else if (this.xnombre.equals("Tipo de Novedad")) {
                        sql = " Insert into g_tiponovedad(Nbre,Tipo, Estado, UsuarioS)  values ('" + this.JTFNombre.getText().toUpperCase() + "','" + this.JSPUno.getValue() + "','" + this.xestado + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                    } else if (this.xnombre.equals("Tipo de Respuesta")) {
                        sql = " Insert into t_etipo_r(Nbre, Estado, UsuarioS)  values ('" + this.JTFNombre.getText().toUpperCase() + "','" + this.xestado + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                    } else if (this.xnombre.equals("Festivos")) {
                        sql = " Insert into g_diafestivo(FechaFestivo, Estado, UsuarioS)  values ('" + this.JTFNombre.getText().toUpperCase() + "','" + this.xestado + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                    } else if (this.xnombre.equals("Contenido HC Odontologica")) {
                        sql = " Insert into o_tipo_contenido(Nbre, Estado, UsuarioS)  values ('" + this.JTFNombre.getText().toUpperCase() + "','" + this.xestado + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                    } else if (this.xnombre.equals("Detalle Contenido HC Odontologica")) {
                        sql = " Insert into o_tipo_contenido_descripcion(Nbre, EsDx, Estado, UsuarioS)  values ('" + this.JTFNombre.getText().toUpperCase() + "','" + this.xestado1 + "','" + this.xestado + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                    } else if (this.xnombre.equals("Parametro")) {
                        sql = " Insert into o_tipo_parametros(Nbre, Estado, UsuarioS)  values ('" + this.JTFNombre.getText().toUpperCase() + "','" + this.xestado + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                    } else if (this.xnombre.equals("Concepto Caja")) {
                        sql = " Insert into k_conceptos(Nbre, Estado, Abono, UsuarioS)  values ('" + this.JTFNombre.getText().toUpperCase() + "','" + this.xestado + "','" + this.xestado1 + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                    } else if (this.xnombre.equals("Actividad Solicitud")) {
                        sql = " Insert into s_solicitud_tipo_actividad(Nbre, Estado, UsuarioS)  values ('" + this.JTFNombre.getText().toUpperCase() + "','" + this.xestado + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                    } else if (this.xnombre.equals("Tipo Solicitud")) {
                        sql = " Insert into s_solicitud_tipo(Nbre, Estado, AplicaE, UsuarioS)  values ('" + this.JTFNombre.getText().toUpperCase() + "','" + this.xestado + "','" + this.xestado1 + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                    } else if (this.xnombre.equals("Proceso Sgc")) {
                        sql = " Insert into s_sgc_procesos(Nbre, Estado, UsuarioS)  values ('" + this.JTFNombre.getText().toUpperCase() + "','" + this.xestado + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                    } else if (this.xnombre.equals("Diagnóstico Odontológicos")) {
                        sql = " Insert into o_tipo_diagnostico(Nbre, Estado, EsFractura, UsuarioS)  values ('" + this.JTFNombre.getText().toUpperCase() + "','" + this.xestado + "','" + this.xestado1 + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                    } else if (this.xnombre.equals("Cargos SO")) {
                        sql = " Insert into g_cargos(Nbre, Estado, UsuarioS, Fecha)  values ('" + this.JTFNombre.getText().toUpperCase() + "','" + this.xestado + "','" + Principal.usuarioSistemaDTO.getLogin() + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "')";
                    } else if (this.xnombre.equals("Turnos SO")) {
                        sql = " Insert into g_turnos(Nbre, Estado, UsuarioS)  values ('" + this.JTFNombre.getText().toUpperCase() + "','" + this.xestado + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                    } else if (this.xnombre.equals("Partes Examinar")) {
                        sql = " Insert into g_so_elementos_partes(Nbre, Estado, UsuarioS)  values ('" + this.JTFNombre.getText().toUpperCase() + "','" + this.xestado + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                    } else if (this.xnombre.equals("Peligros SO")) {
                        sql = " Insert into g_so_peligros(Nbre, Estado, UsuarioS)  values ('" + this.JTFNombre.getText().toUpperCase() + "','" + this.xestado + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                    } else if (this.xnombre.equals("Tipo HC")) {
                        sql = " Insert into h_tipohistoria(Nbre, Estado, Fecha, UsuarioS)  values ('" + this.JTFNombre.getText().toUpperCase() + "','" + this.xestado + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                    } else if (this.xnombre.equals("Tipo No Conformidad")) {
                        sql = " Insert into s_sgc_nctipo(Nbre, Estado, Fecha, UsuarioS)  values ('" + this.JTFNombre.getText().toUpperCase() + "','" + this.xestado + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                    } else if (this.xnombre.equals("Origen No Conformidad")) {
                        sql = " Insert into s_sgc_ncorigen(Nbre, Estado, EsSC, UsuarioS)  values ('" + this.JTFNombre.getText().toUpperCase() + "','" + this.xestado + "','" + this.xestado1 + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                    } else if (this.xnombre.equals("Incumplimiento")) {
                        sql = " Insert into s_sgc_tipoincumplimiento(Nbre, Estado, UsuarioS)  values ('" + this.JTFNombre.getText().toUpperCase() + "','" + this.xestado + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                    } else if (this.xnombre.equals("Detalle de Incumplimiento")) {
                        sql = " Insert into s_sgc_tipoincumplimiento_detalle(Nbre, Estado, UsuarioS)  values ('" + this.JTFNombre.getText().toUpperCase() + "','" + this.xestado + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                    } else if (this.xnombre.equals("Tipo Anticipo")) {
                        sql = " Insert into cc_anticipo_tipo(Nbre, Estado, UsuarioS)  values ('" + this.JTFNombre.getText().toUpperCase() + "','" + this.xestado + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                    } else if (this.xnombre.equals("Detalle Concepto Anticipo")) {
                        sql = " Insert into cc_anticipo_detalle_concepto(Nbre, Estado, EsCalculado, UsuarioS)  values ('" + this.JTFNombre.getText().toUpperCase() + "','" + this.xestado + "','" + this.xestado1 + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                    } else if (this.xnombre.equals("Entidad")) {
                        sql = " Insert into g_tipoentidad(Nbre, Estado, Es_institucion, UsuarioS, Fecha)  values ('" + this.JTFNombre.getText().toUpperCase() + "','" + this.xestado + "','" + this.xestado1 + "','" + Principal.usuarioSistemaDTO.getLogin() + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "')";
                    } else if (this.xnombre.equals("Unidad Medida Sgc")) {
                        sql = " Insert into s_sgc_tipounidadmedida(Nbre, Estado, UsuarioS)  values ('" + this.JTFNombre.getText().toUpperCase() + "','" + this.xestado + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                    } else if (this.xnombre.equals("Caracteristicas Sgc")) {
                        sql = " Insert into s_sgc_tipocaracteristicas(Nbre, Estado, UsuarioS)  values ('" + this.JTFNombre.getText().toUpperCase() + "','" + this.xestado + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                    } else if (this.xnombre.equals("Tipo Indicador Sgc")) {
                        sql = " Insert into s_sgc_tipoindicador(Nbre, Estado, UsuarioS)  values ('" + this.JTFNombre.getText().toUpperCase() + "','" + this.xestado + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                    } else if (this.xnombre.equals("Novedades Nomina")) {
                        sql = " Insert into rh_nomina_tipo_novedades(Nbre, Estado, UsuarioS)  values ('" + this.JTFNombre.getText().toUpperCase() + "','" + this.xestado + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                    } else if (this.xnombre.equals("Categorias Activo")) {
                        sql = " Insert into rh_tipo_categoria(Nbre, Estado, UsuarioS)  values ('" + this.JTFNombre.getText().toUpperCase() + "','" + this.xestado + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                    } else if (this.xnombre.equals("Marca Activo")) {
                        sql = " Insert into rh_tipo_marca(Nbre, Estado, UsuarioS)  values ('" + this.JTFNombre.getText().toUpperCase() + "','" + this.xestado + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                    } else if (this.xnombre.equals("Tipo de Reunion")) {
                        sql = " Insert into s_sgc_tipo_reunion(Nbre, Estado, UsuarioS)  values ('" + this.JTFNombre.getText().toUpperCase() + "','" + this.xestado + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                    }
                } else if (this.xnombre.equals("Concepto")) {
                    sql = " update cc_conceptoppt set Nbre='" + this.JTFNombre.getText().toUpperCase() + "',Estado='" + this.xestado + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
                } else if (this.xnombre.equals("Detalle Concepto")) {
                    sql = " update cc_detalle_conceptoppt set Nbre='" + this.JTFNombre.getText().toUpperCase() + "',Estado='" + this.xestado + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
                } else if (this.xnombre.equals("Tipo Régimen")) {
                    sql = " update cc_tipo_regimen set Nbre='" + this.JTFNombre.getText().toUpperCase() + "',Estado='" + this.xestado + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
                } else if (this.xnombre.equals("Banco")) {
                    sql = " update cc_banco set Nbre='" + this.JTFNombre.getText().toUpperCase() + "',Estado='" + this.xestado + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
                } else if (this.xnombre.equals("Concepto Anticipo")) {
                    sql = " update cc_concepto_anticipos set Nbre='" + this.JTFNombre.getText().toUpperCase() + "',Estado='" + this.xestado + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
                } else if (this.xnombre.equals("Tipo Impuesto")) {
                    sql = " update cc_tipo_impuesto set Nbre='" + this.JTFNombre.getText().toUpperCase() + "',Estado='" + this.xestado + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
                } else if (this.xnombre.equals("Conceptos de Radicacion")) {
                    sql = " update cc_conceptocmsa set Nbre='" + this.JTFNombre.getText().toUpperCase() + "',Estado='" + this.xestado + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
                } else if (this.xnombre.equals("Tipo Cuenta")) {
                    sql = " update cc_tipo_cuenta set Nbre='" + this.JTFNombre.getText().toUpperCase() + "',Estado='" + this.xestado + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
                } else if (this.xnombre.equals("Tipo Documento C")) {
                    sql = " update cc_tipo_documentoc set Nbre='" + this.JTFNombre.getText().toUpperCase() + "',Estado='" + this.xestado + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
                } else if (this.xnombre.equals("Condiciones")) {
                    sql = " update cc_tipo_condiciones_compra set Nbre='" + this.JTFNombre.getText().toUpperCase() + "',Estado='" + this.xestado + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
                } else if (this.xnombre.equals("Tipo de Novedad")) {
                    sql = " update g_tiponovedad set Nbre='" + this.JTFNombre.getText().toUpperCase() + "',Tipo='" + this.JSPUno.getValue() + "',Estado='" + this.xestado + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
                } else if (this.xnombre.equals("Tipo de Respuesta")) {
                    sql = " update t_etipo_r set Nbre='" + this.JTFNombre.getText().toUpperCase() + "',Estado='" + this.xestado + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
                } else if (this.xnombre.equals("Festivos")) {
                    sql = " update g_diafestivo set Estado='" + this.xestado + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
                } else if (this.xnombre.equals("Contenido HC Odontologica")) {
                    sql = " update o_tipo_contenido set Nbre='" + this.JTFNombre.getText().toUpperCase() + "',Estado='" + this.xestado + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
                } else if (this.xnombre.equals("Detalle Contenido HC Odontologica")) {
                    sql = " update o_tipo_contenido_descripcion set Nbre='" + this.JTFNombre.getText().toUpperCase() + "',EsDx='" + this.xestado1 + "',Estado='" + this.xestado + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
                } else if (this.xnombre.equals("Parametro")) {
                    sql = " update o_tipo_parametros set Nbre='" + this.JTFNombre.getText().toUpperCase() + "',Estado='" + this.xestado + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
                } else if (this.xnombre.equals("Concepto Caja")) {
                    sql = " update k_conceptos set Nbre='" + this.JTFNombre.getText().toUpperCase() + "',Estado='" + this.xestado + "',Abono='" + this.xestado1 + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
                } else if (this.xnombre.equals("Actividad Solicitud")) {
                    sql = " update s_solicitud_tipo_actividad set Nbre='" + this.JTFNombre.getText().toUpperCase() + "',Estado='" + this.xestado + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
                } else if (this.xnombre.equals("Tipo Solicitud")) {
                    sql = " update s_solicitud_tipo set Nbre='" + this.JTFNombre.getText().toUpperCase() + "',Estado='" + this.xestado + "',AplicaE='" + this.xestado1 + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
                } else if (this.xnombre.equals("Proceso Sgc")) {
                    sql = " update s_sgc_procesos set Nbre='" + this.JTFNombre.getText().toUpperCase() + "',Estado='" + this.xestado + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
                } else if (this.xnombre.equals("Diagnóstico Odontológicos")) {
                    sql = " update o_tipo_diagnostico set Nbre='" + this.JTFNombre.getText().toUpperCase() + "',Estado='" + this.xestado + "',EsFractura='" + this.xestado1 + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
                } else if (this.xnombre.equals("Cargos SO")) {
                    sql = " update g_cargos set Nbre='" + this.JTFNombre.getText().toUpperCase() + "',Estado='" + this.xestado + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
                } else if (this.xnombre.equals("Turnos SO")) {
                    sql = " update g_turnos set Nbre='" + this.JTFNombre.getText().toUpperCase() + "',Estado='" + this.xestado + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
                } else if (this.xnombre.equals("Partes Examinar")) {
                    sql = " update g_so_elementos_partes set Nbre='" + this.JTFNombre.getText().toUpperCase() + "',Estado='" + this.xestado + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
                } else if (this.xnombre.equals("Peligros SO")) {
                    sql = " update g_so_peligros set Nbre='" + this.JTFNombre.getText().toUpperCase() + "',Estado='" + this.xestado + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
                } else if (this.xnombre.equals("Tipo HC")) {
                    sql = " update h_tipohistoria set Nbre='" + this.JTFNombre.getText().toUpperCase() + "',Estado='" + this.xestado + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
                } else if (this.xnombre.equals("Tipo No Conformidad")) {
                    sql = " update s_sgc_nctipo set Nbre='" + this.JTFNombre.getText().toUpperCase() + "',Estado='" + this.xestado + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
                } else if (this.xnombre.equals("Origen No Conformidad")) {
                    sql = " update s_sgc_ncorigen set Nbre='" + this.JTFNombre.getText().toUpperCase() + "',Estado='" + this.xestado + "', EsSC='" + this.xestado1 + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
                } else if (this.xnombre.equals("Incumplimiento")) {
                    sql = " update s_sgc_tipoincumplimiento set Nbre='" + this.JTFNombre.getText().toUpperCase() + "',Estado='" + this.xestado + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
                } else if (this.xnombre.equals("Detalle de Incumplimiento")) {
                    sql = " update s_sgc_tipoincumplimiento_detalle set Nbre='" + this.JTFNombre.getText().toUpperCase() + "',Estado='" + this.xestado + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
                } else if (this.xnombre.equals("Tipo Anticipo")) {
                    sql = " update cc_anticipo_tipo set Nbre='" + this.JTFNombre.getText().toUpperCase() + "',Estado='" + this.xestado + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
                } else if (this.xnombre.equals("Detalle Concepto Anticipo")) {
                    sql = " update cc_anticipo_detalle_concepto set Nbre='" + this.JTFNombre.getText().toUpperCase() + "',Estado='" + this.xestado + "',EsCalculado='" + this.xestado1 + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
                } else if (this.xnombre.equals("Entidad")) {
                    sql = " update g_tipoentidad set Nbre='" + this.JTFNombre.getText().toUpperCase() + "',Estado='" + this.xestado + "',Es_institucion='" + this.xestado1 + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
                } else if (this.xnombre.equals("Unidad Medida Sgc")) {
                    sql = " update s_sgc_tipounidadmedida set Nbre='" + this.JTFNombre.getText().toUpperCase() + "',Estado='" + this.xestado + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
                } else if (this.xnombre.equals("Caracteristicas Sgc")) {
                    sql = " update s_sgc_tipocaracteristicas set Nbre='" + this.JTFNombre.getText().toUpperCase() + "',Estado='" + this.xestado + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
                } else if (this.xnombre.equals("Tipo Indicador Sgc")) {
                    sql = " update s_sgc_tipoindicador set Nbre='" + this.JTFNombre.getText().toUpperCase() + "',Estado='" + this.xestado + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
                } else if (this.xnombre.equals("Novedades Nomina")) {
                    sql = " update rh_nomina_tipo_novedades set Nbre='" + this.JTFNombre.getText().toUpperCase() + "',Estado='" + this.xestado + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
                } else if (this.xnombre.equals("Categorias Activo")) {
                    sql = " update rh_tipo_categoria set Nbre='" + this.JTFNombre.getText().toUpperCase() + "',Estado='" + this.xestado + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
                } else if (this.xnombre.equals("Marca Activo")) {
                    sql = " update rh_tipo_marca set Nbre='" + this.JTFNombre.getText().toUpperCase() + "',Estado='" + this.xestado + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
                } else if (this.xnombre.equals("Tipo de Reunion")) {
                    sql = " update s_sgc_tipo_reunion set Nbre='" + this.JTFNombre.getText().toUpperCase() + "',Estado='" + this.xestado + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
                }
                this.xconsulta.ejecutarSQL(sql);
                this.xconsulta.cerrarConexionBd();
                if (this.xnombre.equals("Tipo de Novedad")) {
                    mCargarTablaConTipo();
                } else {
                    mCargarDatosTabla();
                }
                mNuevo();
                return;
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "El campo nombre no puede ser nulo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JTFNombre.requestFocus();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Nombre", "Estado", "Estado1"}) { // from class: Contabilidad.JIFGenerico1CheckBoxC.8
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
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(250);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(30);
        if (this.xnombre.equals("Tipo Solicitud") || this.xnombre.equals("Concepto Caja") || this.xnombre.equals("Diagnóstico Odontológicos") || this.xnombre.equals("Detalle Contenido HC Odontologica") || this.xnombre.equals("Detalle Concepto Anticipo") || this.xnombre.equals("Entidad") || this.xnombre.equals("Origen No Conformidad")) {
            this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(30);
            return;
        }
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(3).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(3).setMaxWidth(0);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCaragarTablaConTipo() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Nombre", "Estado", "Tipo"}) { // from class: Contabilidad.JIFGenerico1CheckBoxC.9
            Class[] types = {Long.class, String.class, Boolean.class, Long.class};
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
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(30);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(0);
    }

    private void mCargarTablaConTipo() {
        try {
            ResultSet xrs = this.xconsulta.traerRs("SELECT  `Id` , `Nbre` , `Estado` , `Tipo`FROM `g_tiponovedad`WHERE (`Estado` =1  );");
            mCaragarTablaConTipo();
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(1)), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(3)), n, 2);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(4)), n, 3);
                    n++;
                }
            }
            xrs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFGenerico1CheckBoxC.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarDatosTabla() {
        try {
            mCrearModeloDatos();
            String sql = null;
            if (this.xnombre.equals("Concepto")) {
                sql = "SELECT Id, Nbre, Estado FROM cc_conceptoppt ORDER BY Nbre ASC";
            } else if (this.xnombre.equals("Detalle Concepto")) {
                sql = "SELECT Id, Nbre, Estado FROM cc_detalle_conceptoppt ORDER BY Nbre ASC";
            } else if (this.xnombre.equals("Tipo Régimen")) {
                sql = "SELECT Id, Nbre, Estado FROM cc_tipo_regimen ORDER BY Nbre ASC";
            } else if (this.xnombre.equals("Banco")) {
                sql = "SELECT Id, Nbre, Estado FROM cc_banco ORDER BY Nbre ASC";
            } else if (this.xnombre.equals("Tipo Impuesto")) {
                sql = "SELECT Id, Nbre, Estado FROM cc_tipo_impuesto ORDER BY Nbre ASC";
            } else if (this.xnombre.equals("Conceptos de Radicacion")) {
                sql = "SELECT Id, Nbre, Estado FROM cc_conceptocmsa ORDER BY Nbre ASC";
            } else if (this.xnombre.equals("Tipo Cuenta")) {
                sql = "SELECT Id, Nbre, Estado FROM cc_tipo_cuenta ORDER BY Nbre ASC";
            } else if (this.xnombre.equals("Tipo Documento C")) {
                sql = "SELECT Id, Nbre, Estado FROM cc_tipo_documentoc ORDER BY Nbre ASC";
            } else if (this.xnombre.equals("Condiciones")) {
                sql = "SELECT Id, Nbre, Estado FROM cc_tipo_condiciones_compra ORDER BY Nbre ASC";
            } else if (this.xnombre.equals("Tipo Encuesta")) {
                sql = "SELECT Id, Nbre, Estado FROM t_etipo_encuestas ORDER BY Nbre ASC";
            } else if (this.xnombre.equals("Tipo de Respuesta")) {
                sql = "SELECT Id, Nbre, Estado FROM t_etipo_r ORDER BY Nbre ASC";
            } else if (this.xnombre.equals("Festivos")) {
                sql = "SELECT Id , FechaFestivo, Estado FROM g_diafestivo ORDER BY FechaFestivo DESC";
            } else if (this.xnombre.equals("Contenido HC Odontologica")) {
                sql = "SELECT Id , Nbre, Estado FROM o_tipo_contenido ORDER BY Nbre asc";
            } else if (this.xnombre.equals("Detalle Contenido HC Odontologica")) {
                sql = "SELECT Id , Nbre, Estado, EsDx FROM o_tipo_contenido_descripcion  ORDER BY Nbre asc";
            } else if (this.xnombre.equals("Parametro")) {
                sql = "SELECT Id , Nbre, Estado FROM o_tipo_parametros ORDER BY Nbre asc";
            } else if (this.xnombre.equals("Concepto Caja")) {
                sql = "SELECT Id , Nbre, Estado, Abono FROM k_conceptos ORDER BY Nbre asc";
            } else if (this.xnombre.equals("Actividad Solicitud")) {
                sql = "SELECT Id , Nbre, Estado FROM s_solicitud_tipo_actividad where Id_Tipo_Solicitud = '" + Principal.txtNo.getText() + "' ORDER BY Nbre asc";
            } else if (this.xnombre.equals("Tipo Solicitud")) {
                sql = "SELECT Id, Nbre, Estado , AplicaE FROM s_solicitud_tipo ORDER BY Nbre ASC";
            } else if (this.xnombre.equals("Proceso Sgc")) {
                sql = "SELECT Id, Nbre, Estado FROM s_sgc_procesos ORDER BY Nbre ASC";
            } else if (this.xnombre.equals("Diagnóstico Odontológicos")) {
                sql = "SELECT Id, Nbre, Estado, EsFractura FROM o_tipo_diagnostico ORDER BY Nbre ASC";
            } else if (this.xnombre.equals("Cargos SO")) {
                sql = "SELECT Id, Nbre, Estado, 0 FROM g_cargos ORDER BY Nbre ASC";
            } else if (this.xnombre.equals("Turnos SO")) {
                sql = "SELECT Id, Nbre, Estado, 0 FROM g_turnos ORDER BY Nbre ASC";
            } else if (this.xnombre.equals("Partes Examinar")) {
                sql = "SELECT Id, Nbre, Estado, 0 FROM g_so_elementos_partes ORDER BY Nbre ASC";
            } else if (this.xnombre.equals("Peligros SO")) {
                sql = "SELECT Id, Nbre, Estado, 0 FROM g_so_peligros ORDER BY Nbre ASC";
            } else if (this.xnombre.equals("Tipo HC")) {
                sql = "SELECT Id, Nbre, Estado FROM h_tipohistoria ORDER BY Nbre ASC";
            } else if (this.xnombre.equals("Tipo No Conformidad")) {
                sql = "SELECT Id, Nbre, Estado FROM s_sgc_nctipo ORDER BY Nbre ASC";
            } else if (this.xnombre.equals("Origen No Conformidad")) {
                sql = "SELECT Id, Nbre, Estado, EsSC FROM s_sgc_ncorigen ORDER BY Nbre ASC";
            } else if (this.xnombre.equals("Incumplimiento")) {
                sql = "SELECT Id, Nbre, Estado FROM s_sgc_tipoincumplimiento ORDER BY Nbre ASC";
            } else if (this.xnombre.equals("Detalle de Incumplimiento")) {
                sql = "SELECT Id, Nbre, Estado FROM s_sgc_tipoincumplimiento_detalle ORDER BY Nbre ASC";
            } else if (this.xnombre.equals("Tipo Anticipo")) {
                sql = "SELECT Id, Nbre, Estado FROM cc_anticipo_tipo ORDER BY Nbre ASC";
            } else if (this.xnombre.equals("Detalle Concepto Anticipo")) {
                sql = "SELECT Id, Nbre, Estado, EsCalculado FROM cc_anticipo_detalle_concepto ORDER BY Nbre ASC";
            } else if (this.xnombre.equals("Entidad")) {
                sql = "SELECT Id, Nbre, Estado, Es_Institucion FROM g_tipoentidad ORDER BY Nbre ASC";
            } else if (this.xnombre.equals("Unidad Medida Sgc")) {
                sql = "SELECT Id, Nbre, Estado FROM s_sgc_tipounidadmedida ORDER BY Nbre ASC";
            } else if (this.xnombre.equals("Caracteristicas Sgc")) {
                sql = "SELECT Id, Nbre, Estado FROM s_sgc_tipocaracteristicas ORDER BY Nbre ASC";
            } else if (this.xnombre.equals("Tipo Indicador Sgc")) {
                sql = "SELECT Id, Nbre, Estado FROM s_sgc_tipoindicador ORDER BY Nbre ASC";
            } else if (this.xnombre.equals("Novedades Nomina")) {
                sql = "SELECT Id, Nbre, Estado FROM rh_nomina_tipo_novedades ORDER BY Nbre ASC";
            } else if (this.xnombre.equals("Categorias Activo")) {
                sql = "SELECT Id, Nbre, Estado FROM rh_tipo_categoria ORDER BY Nbre ASC";
            } else if (this.xnombre.equals("Marca Activo")) {
                sql = "SELECT Id, Nbre, Estado FROM rh_tipo_marca ORDER BY Nbre ASC";
            } else if (this.xnombre.equals("Tipo de Reunion")) {
                sql = "SELECT Id, Nbre, Estado FROM s_sgc_tipo_reunion ORDER BY Nbre ASC";
            }
            ResultSet xrs = this.xconsulta.traerRs(sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(xrs.getString(1), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    if (this.xnombre.equals("Tipo HC")) {
                        this.xmodelo.setValueAt(Boolean.valueOf(!xrs.getBoolean(3)), n, 2);
                    } else {
                        this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(3)), n, 2);
                    }
                    if (this.xnombre.equals("Tipo Solicitud") || this.xnombre.equals("Concepto Caja") || this.xnombre.equals("Diagnóstico Odontológicos") || this.xnombre.equals("Detalle Contenido HC Odontologica") || this.xnombre.equals("Detalle Concepto Anticipo") || this.xnombre.equals("Entidad") || this.xnombre.equals("Origen No Conformidad")) {
                        this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(4)), n, 3);
                    } else {
                        this.xmodelo.setValueAt(true, n, 3);
                    }
                    n++;
                }
            }
            xrs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFGenerico1CheckBoxC.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mIniciarBoton() {
        this.JCHDos.setVisible(false);
        this.JSPUno.setVisible(false);
        if (this.xnombre.equals("Concepto")) {
            this.JBTDatosA.setText("Concepto x Unidad Funcional");
            return;
        }
        if (this.xnombre.equals("Detalle Concepto")) {
            this.JBTDatosA.setText("Detalle Concepto x Unidad Funcional x Concepto");
            return;
        }
        if (this.xnombre.equals("Banco")) {
            this.JBTDatosA.setText("Sucursal");
            return;
        }
        if (this.xnombre.equals("Novedades Nomina")) {
            this.JBTDatosA.setText("Conceptos");
            this.JBTExaFisico.setVisible(false);
            return;
        }
        if (this.xnombre.equals("Tipo Impuesto")) {
            this.JBTDatosA.setText("%");
            return;
        }
        if (this.xnombre.equals("Contenido HC Odontologica")) {
            this.JBTDatosA.setText("Detalle Contenido HC");
            return;
        }
        if (this.xnombre.equals("Detalle Contenido HC Odontologica")) {
            this.JCHDos.setText("Es Diagnóstico?");
            this.JCHDos.setVisible(true);
            this.JBTDatosA.setText("Parametro Detalle Contenido");
            return;
        }
        if (this.xnombre.equals("Tipo HC")) {
            this.JBTDatosA.setText("Detalle de Contenido HC");
            return;
        }
        if (this.xnombre.equals("Tipo Solicitud")) {
            this.JCHDos.setText("Encuesta?");
            this.JCHDos.setVisible(true);
            this.JBTDatosA.setText("Actividades");
            return;
        }
        if (this.xnombre.equals("Concepto Caja")) {
            this.JCHDos.setText("Abono?");
            this.JCHDos.setVisible(true);
            return;
        }
        if (this.xnombre.equals("Detalle Concepto Anticipo")) {
            this.JCHDos.setText("Es Calculado?");
            this.JCHDos.setVisible(true);
            this.JBTDatosA.setVisible(false);
            return;
        }
        if (this.xnombre.equals("Diagnóstico Odontológicos")) {
            this.JCHDos.setText("Dx Trauma?");
            this.JCHDos.setVisible(true);
            this.JCHDos.setSelected(false);
            this.xestado1 = 0;
            this.JBTDatosA.setVisible(false);
            return;
        }
        if (this.xnombre.equals("Entidad")) {
            this.JCHDos.setText("Institución?");
            this.JCHDos.setVisible(true);
            this.JCHDos.setSelected(false);
            this.xestado1 = 0;
            this.JBTDatosA.setVisible(false);
            return;
        }
        if (this.xnombre.equals("Incumplimiento")) {
            this.JBTDatosA.setText("Detalle");
            this.JBTExaFisico.setVisible(false);
            return;
        }
        if (this.xnombre.equals("Parametro")) {
            this.JBTDatosA.setVisible(false);
            this.JBTExaFisico.setVisible(false);
            return;
        }
        if (this.xnombre.equals("Origen No Conformidad")) {
            this.JCHDos.setText("Seguridad Clinica?");
            this.JCHDos.setToolTipText("Filtro en analisis de seguridad clinica");
            this.JCHDos.setVisible(true);
            this.JCHDos.setSelected(false);
            this.xestado1 = 0;
            return;
        }
        if (this.xnombre.equals("Tipo de Novedad")) {
            this.JSPUno.setVisible(true);
            this.xestado1 = 0;
        } else {
            if (this.xnombre.equals("Conceptos de Radicacion")) {
                this.JBTDatosA.setVisible(false);
                this.JBTExaFisico.setVisible(false);
                this.JBAntecedentesPatologicos.setVisible(false);
                return;
            }
            this.JBTDatosA.setVisible(false);
        }
    }

    private void mRecargarCombo() {
        if (this.xnombre.equals("Categorias Activo")) {
            this.xjifges.llenarComboCategoria(this.nombre);
        }
        if (this.xnombre.equals("Marca Activo")) {
            this.xjifges.llenarComboMarca(this.nombre);
        }
        dispose();
    }
}
