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
import javax.swing.DefaultComboBoxModel;
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

/* JADX INFO: loaded from: GenomaP.jar:ParametrizacionN/JIFGenerico1CheckBox.class */
public class JIFGenerico1CheckBox extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private Object[] xdatos;
    private String xnombre;
    private JIFSSuministro xjifsuministro;
    private Integer[] tipoClasificacion;
    private int id;
    private JComboBox<String> JCBTipoClasificacion;
    private JCheckBox JCHEstado;
    private JPanel JPIDatos;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;
    private JTextField JTFIdReporte;
    private JTextField JTFNombre;
    private ConsultasMySQL xconsulta = new ConsultasMySQL();
    private Metodos xmetodos = new Metodos();
    private int xestado = 0;
    private String xid = "";
    private boolean xestadog = false;
    private Integer itemCombo = -1;

    public JIFGenerico1CheckBox(String xnombre, String xnombref) {
        initComponents();
        setName(xnombref);
        setTitle(xnombre.toUpperCase());
        this.xnombre = xnombre;
        mCargarDatosTabla();
        mNuevo();
    }

    public JIFGenerico1CheckBox(String xnombre, String xnombref, JIFSSuministro xjifsuministro) {
        initComponents();
        this.xjifsuministro = xjifsuministro;
        setName(xnombref);
        setTitle(xnombre);
        this.xnombre = xnombre;
        mCargarDatosTabla();
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v35, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPIDatos = new JPanel();
        this.JTFNombre = new JTextField();
        this.JCHEstado = new JCheckBox();
        this.JTFIdReporte = new JTextField();
        this.JCBTipoClasificacion = new JComboBox<>();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("MUNICIPIO");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifgenerico1chbox");
        try {
            setSelected(true);
        } catch (PropertyVetoException e1) {
            e1.printStackTrace();
        }
        addInternalFrameListener(new InternalFrameListener() { // from class: ParametrizacionN.JIFGenerico1CheckBox.1
            public void internalFrameActivated(InternalFrameEvent evt) {
            }

            public void internalFrameClosed(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                JIFGenerico1CheckBox.this.formInternalFrameClosing(evt);
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
        this.JCHEstado.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFGenerico1CheckBox.2
            public void actionPerformed(ActionEvent evt) {
                JIFGenerico1CheckBox.this.JCHEstadoActionPerformed(evt);
            }
        });
        this.JTFIdReporte.setFont(new Font("Arial", 1, 12));
        this.JTFIdReporte.setToolTipText("");
        this.JTFIdReporte.setBorder(BorderFactory.createTitledBorder((Border) null, "ID Reporte", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTipoClasificacion.setFont(new Font("Arial", 1, 12));
        this.JCBTipoClasificacion.setModel(new DefaultComboBoxModel(new String[]{"No Aplica", "Manifestación de oposición a la presunción legal de donación", "Voluntad Anticipada"}));
        this.JCBTipoClasificacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Clasificación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTipoClasificacion.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFGenerico1CheckBox.3
            public void actionPerformed(ActionEvent evt) {
                JIFGenerico1CheckBox.this.JCBTipoClasificacionActionPerformed(evt);
            }
        });
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosLayout.createSequentialGroup().addContainerGap().addComponent(this.JTFNombre, -2, 289, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFIdReporte, -2, 123, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBTipoClasificacion, 0, 229, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHEstado).addContainerGap()));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JCBTipoClasificacion, -2, 45, -2).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFNombre, -2, -1, -2).addComponent(this.JCHEstado).addComponent(this.JTFIdReporte, -2, -1, -2))).addGap(8, 8, 8)));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalle.setSelectionMode(0);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFGenerico1CheckBox.4
            public void mouseClicked(MouseEvent evt) {
                JIFGenerico1CheckBox.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPIDatos, -1, -1, 32767).addComponent(this.JSPDetalle)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.JPIDatos, -2, -1, -2).addGap(10, 10, 10).addComponent(this.JSPDetalle, -1, 368, 32767).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEstadoActionPerformed(ActionEvent evt) {
        if (this.xnombre.equals("Nombre Encuesta") || this.xnombre.equals("Población Especial") || this.xnombre.equals("Clasificacion de Respuesta") || this.xnombre.equals("Tipo Manual Tarifas") || this.xnombre.equals("Tipo Etnia") || this.xnombre.equals("Tipo División") || this.xnombre.equals("Tipo Descuento") || this.xnombre.equals("Muestra Citologia") || this.xnombre.equals("Tipo Seguimiento") || this.xnombre.equals("Tipo de Clasificacion")) {
            if (this.JCHEstado.isSelected()) {
                this.xestado = 1;
                return;
            } else {
                this.xestado = 0;
                return;
            }
        }
        if (this.JCHEstado.isSelected()) {
            this.xestado = 0;
        } else {
            this.xestado = 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            if (!this.xnombre.equals("Presentación Comercial") && !this.xnombre.equals("Concentración") && !this.xnombre.equals("Laboratorio") && this.xnombre.equals("Tipo Documento Soporte")) {
                Principal.txtNo.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
            } else {
                this.xid = this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString();
            }
            Principal.txtNo.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
            this.id = Integer.parseInt(Principal.txtNo.getText());
            this.JTFNombre.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString());
            this.JTFIdReporte.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString());
            this.itemCombo = Integer.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString());
            System.out.println("el item devuelto es de" + this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString());
            if (null == this.itemCombo) {
                this.JCBTipoClasificacion.setSelectedIndex(2);
            } else {
                switch (this.itemCombo.intValue()) {
                    case 0:
                        this.JCBTipoClasificacion.setSelectedIndex(0);
                        break;
                    case 1:
                        this.JCBTipoClasificacion.setSelectedIndex(1);
                        break;
                    default:
                        this.JCBTipoClasificacion.setSelectedIndex(2);
                        break;
                }
            }
            this.JCHEstado.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 4).toString()).booleanValue());
            if (this.xnombre.equals("Nombre Encuesta") || this.xnombre.equals("Población Especial") || this.xnombre.equals("Clasificacion de Respuesta") || this.xnombre.equals("Tipo Manual Tarifas") || this.xnombre.equals("Tipo Etnia") || this.xnombre.equals("Tipo División") || this.xnombre.equals("Tipo Descuento") || this.xnombre.equals("Muestra Citologia") || this.xnombre.equals("Tipo Seguimiento") || this.xnombre.equals("Tipo de Clasificacion") || this.xnombre.equals("Tipo Documento Soporte")) {
                if (this.JCHEstado.isSelected()) {
                    this.xestado = 1;
                    return;
                } else {
                    this.xestado = 0;
                    return;
                }
            }
            if (this.JCHEstado.isSelected()) {
                this.xestado = 0;
            } else {
                this.xestado = 1;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosing(InternalFrameEvent evt) {
        Principal.mLimpiarDatosP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBTipoClasificacionActionPerformed(ActionEvent evt) {
    }

    public void mNuevo() {
        Principal.mLimpiarDatosP();
        this.JCBTipoClasificacion.setSelectedIndex(-1);
        this.xid = "";
        this.JTFNombre.setText("");
        this.JTFIdReporte.setText("");
        this.JCBTipoClasificacion.setSelectedItem("");
        this.JCHEstado.setSelected(true);
        this.xestado = 0;
        if (this.xnombre.equals("Población Especial") || this.xnombre.equals("Clasificacion de Respuesta") || this.xnombre.equals("Tipo Manual Tarifas") || this.xnombre.equals("Tipo Etnia") || this.xnombre.equals("Tipo División") || this.xnombre.equals("Tipo Descuento") || this.xnombre.equals("Muestra Citologia") || this.xnombre.equals("Tipo Seguimiento") || this.xnombre.equals("Esquema Citologia") || this.xnombre.equals("Tipo Documento Soporte")) {
            this.xestado = 1;
        }
    }

    public void mGrabar() {
        if (!this.JTFNombre.getText().isEmpty()) {
            String sql = null;
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                if (!this.xnombre.equals("Presentación Comercial") && !this.xnombre.equals("Concentración") && !this.xnombre.equals("Laboratorio")) {
                    if (Principal.txtNo.getText().isEmpty()) {
                        switch (this.xnombre) {
                            case "Tipo de Plan":
                                sql = " Insert into f_tipoplan(Nbre, Estado, Fecha, UsuarioS)  values ('" + this.JTFNombre.getText().toUpperCase() + "','" + this.xestado + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                                break;
                            case "Tipo de Régimen":
                                sql = " Insert into f_tiporegimen(Nbre, Estado, Fecha, UsuarioS)  values ('" + this.JTFNombre.getText().toUpperCase() + "','" + this.xestado + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                                break;
                            case "Tipo Cita":
                                sql = " Insert into c_tipocita(Nbre, Estado, Fecha, UsuarioS)  values ('" + this.JTFNombre.getText().toUpperCase() + "','" + this.xestado + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                                break;
                            case "Motivo Anulación Citas":
                                sql = " Insert into c_motivodesistida(Nbre, Estado, Fecha, UsuarioS)  values ('" + this.JTFNombre.getText().toUpperCase() + "','" + this.xestado + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                                break;
                            case "Concepto Anticipo":
                                sql = " Insert into cc_concepto_anticipos(Nbre, Estado, Fecha, UsuarioS)  values ('" + this.JTFNombre.getText().toUpperCase() + "','" + this.xestado + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                                break;
                            case "Causa de Daño":
                                sql = " Insert into g_tipo_causadañoplacas(Nbre, Estado, Fecha, UsuarioS)  values ('" + this.JTFNombre.getText().toUpperCase() + "','" + this.xestado + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                                break;
                            case "Tipo Placa":
                                sql = " Insert into g_tipo_placasrx(Nbre, Estado, Fecha, UsuarioS)  values ('" + this.JTFNombre.getText().toUpperCase() + "','" + this.xestado + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                                break;
                            case "Áreas":
                                sql = " Insert into l_areas(Nbre, Estado, Fecha, UsuarioS)  values ('" + this.JTFNombre.getText().toUpperCase() + "','" + this.xestado + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                                break;
                            case "Nivel de Estudio":
                                sql = " Insert into g_nivelestudio(Nbre, Estado, Fecha, UsuarioS)  values ('" + this.JTFNombre.getText().toUpperCase() + "','" + this.xestado + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                                break;
                            case "Vacunas":
                                sql = " Insert into p_vacunacion_vacunas(Nbre, Estado, Fecha, UsuarioS)  values ('" + this.JTFNombre.getText().toUpperCase() + "','" + this.xestado + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                                break;
                            case "Dosis Vacunas":
                                sql = " Insert into p_vacunacion_dosis(Nbre, Estado, Fecha, UsuarioS)  values ('" + this.JTFNombre.getText().toUpperCase() + "','" + this.xestado + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                                break;
                            case "Clasificación":
                                sql = " Insert into i_clasificacion(Nbre, Estado, Fecha, UsuarioS)  values ('" + this.JTFNombre.getText().toUpperCase() + "','" + this.xestado + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                                break;
                            case "Motivo de Traslado":
                                sql = " Insert into rh_activos_tipo_traslado(Nbre, Estado, Fecha, UsuarioS)  values ('" + this.JTFNombre.getText().toUpperCase() + "','" + this.xestado + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                                break;
                            case "Grupo Equipo":
                                sql = " Insert into rh_activo_tipo_nagrupacion(Nbre, Estado, Fecha, UsuarioS)  values ('" + this.JTFNombre.getText().toUpperCase() + "','" + this.xestado + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                                break;
                            case "Tipo de DocumentosHC":
                                sql = " Insert into h_tipodocumentoshc(Nbre, Estado, Fecha, UsuarioS)  values ('" + this.JTFNombre.getText().toUpperCase() + "','" + this.xestado + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                                break;
                            case "Tipo de Nota":
                                if (this.JCHEstado.isSelected()) {
                                    this.xestado = 1;
                                } else {
                                    this.xestado = 0;
                                }
                                sql = " Insert into h_tiponota(Nbre, Estado, Fecha, UsuarioS)  values ('" + this.JTFNombre.getText().toUpperCase() + "','" + this.xestado + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                                break;
                            case "Ecografía":
                                if (this.JCHEstado.isSelected()) {
                                    this.xestado = 1;
                                } else {
                                    this.xestado = 0;
                                }
                                sql = " Insert into h_ecog_datosp(Nbre, Estado, Fecha, UsuarioS)  values ('" + this.JTFNombre.getText().toUpperCase() + "','" + this.xestado + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                                break;
                            case "Concepto Específico":
                                if (this.JCHEstado.isSelected()) {
                                    this.xestado = 1;
                                } else {
                                    this.xestado = 0;
                                }
                                sql = " Insert into so_concepto_especifico(Nbre, Estado, Fecha, UsuarioS)  values ('" + this.JTFNombre.getText().toUpperCase() + "','" + this.xestado + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                                break;
                            case "Recomendaciones":
                                if (this.JCHEstado.isSelected()) {
                                    this.xestado = 1;
                                } else {
                                    this.xestado = 0;
                                }
                                sql = " Insert into so_recomendaciones(Nbre, Estado, Fecha, UsuarioS)  values ('" + this.JTFNombre.getText().toUpperCase() + "','" + this.xestado + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                                break;
                            case "Tipo de Clasificacion":
                                if (this.JCHEstado.isSelected()) {
                                    this.xestado = 1;
                                } else {
                                    this.xestado = 0;
                                }
                                sql = " Insert into rh_tipo_clasificacion(Nbre, Estado, Fecha, Id_UsuarioS)  values ('" + this.JTFNombre.getText().toUpperCase() + "','" + this.xestado + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "')";
                                break;
                            case "Segmentos":
                                if (this.JCHEstado.isSelected()) {
                                    this.xestado = 1;
                                } else {
                                    this.xestado = 0;
                                }
                                sql = " Insert into so_segmento(Nbre, Estado, Fecha, UsuarioS)  values ('" + this.JTFNombre.getText().toUpperCase() + "','" + this.xestado + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                                break;
                            case "Correción":
                                if (this.JCHEstado.isSelected()) {
                                    this.xestado = 1;
                                } else {
                                    this.xestado = 0;
                                }
                                sql = " Insert into so_tipo_correccion(Nbre, Estado, Fecha, UsuarioS)  values ('" + this.JTFNombre.getText().toUpperCase() + "','" + this.xestado + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                                break;
                            case "Grupo Turnos":
                                if (this.JCHEstado.isSelected()) {
                                    this.xestado = 1;
                                } else {
                                    this.xestado = 0;
                                }
                                sql = " Insert into so_tipo_grupo(Nbre, Estado, Fecha, UsuarioS)  values ('" + this.JTFNombre.getText().toUpperCase() + "','" + this.xestado + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                                break;
                            case "Actividad Física":
                                if (this.JCHEstado.isSelected()) {
                                    this.xestado = 1;
                                } else {
                                    this.xestado = 0;
                                }
                                sql = " Insert into so_actividad_fisica(Nbre, Estado, Fecha, UsuarioS)  values ('" + this.JTFNombre.getText().toUpperCase() + "','" + this.xestado + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                                break;
                            case "Escala del Dolor":
                                if (this.JCHEstado.isSelected()) {
                                    this.xestado = 1;
                                } else {
                                    this.xestado = 0;
                                }
                                sql = " Insert into so_intensidad_dolor(Nbre, Estado, Fecha, UsuarioS)  values ('" + this.JTFNombre.getText().toUpperCase() + "','" + this.xestado + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                                break;
                            case "Tipo Actividad Física":
                                if (this.JCHEstado.isSelected()) {
                                    this.xestado = 1;
                                } else {
                                    this.xestado = 0;
                                }
                                sql = " Insert into so_tipo_actividad_fisica(Nbre, Estado, Fecha, UsuarioS)  values ('" + this.JTFNombre.getText().toUpperCase() + "','" + this.xestado + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                                break;
                            case "Tipo de Dolor":
                                if (this.JCHEstado.isSelected()) {
                                    this.xestado = 1;
                                } else {
                                    this.xestado = 0;
                                }
                                sql = " Insert into so_tipodolor(Nbre, Estado, Fecha, UsuarioS)  values ('" + this.JTFNombre.getText().toUpperCase() + "','" + this.xestado + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                                break;
                            case "Tipo Vinculación":
                                if (this.JCHEstado.isSelected()) {
                                    this.xestado = 1;
                                } else {
                                    this.xestado = 0;
                                }
                                sql = " Insert into so_tipo_vinculacion(Nbre, Estado, Fecha, UsuarioS)  values ('" + this.JTFNombre.getText().toUpperCase() + "','" + this.xestado + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                                break;
                            case "Tipo Sustancia":
                                if (this.JCHEstado.isSelected()) {
                                    this.xestado = 1;
                                } else {
                                    this.xestado = 0;
                                }
                                sql = " Insert into so_tipo_sustancia(Nbre, Estado, Fecha, UsuarioS)  values ('" + this.JTFNombre.getText().toUpperCase() + "','" + this.xestado + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                                break;
                            case "Tipo Subcategoria":
                                if (this.JCHEstado.isSelected()) {
                                    this.xestado = 1;
                                } else {
                                    this.xestado = 0;
                                }
                                sql = " Insert into so_tipo_subcategoria(Nbre, Estado, Fecha, UsuarioS)  values ('" + this.JTFNombre.getText().toUpperCase() + "','" + this.xestado + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                                break;
                            case "Motivo Prueba":
                                if (this.JCHEstado.isSelected()) {
                                    this.xestado = 1;
                                } else {
                                    this.xestado = 0;
                                }
                                sql = " Insert into so_tipo_motivo_prueba(Nbre, Estado, Fecha, UsuarioS)  values ('" + this.JTFNombre.getText().toUpperCase() + "','" + this.xestado + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                                break;
                            case "Tipo Cuestionario":
                                if (this.JCHEstado.isSelected()) {
                                    this.xestado = 1;
                                } else {
                                    this.xestado = 0;
                                }
                                sql = " Insert into so_tipo_cuestionario(Nbre, Estado, Fecha, UsuarioS)  values ('" + this.JTFNombre.getText().toUpperCase() + "','" + this.xestado + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                                break;
                            case "Escala CyD":
                                if (this.JCHEstado.isSelected()) {
                                    this.xestado = 1;
                                } else {
                                    this.xestado = 0;
                                }
                                sql = " Insert into p_escala_categoria(Nbre, Estado, UsuarioS)  values ('" + this.JTFNombre.getText().toUpperCase() + "','" + this.xestado + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                                break;
                            case "Preguntas CyD":
                                if (this.JCHEstado.isSelected()) {
                                    this.xestado = 1;
                                } else {
                                    this.xestado = 0;
                                }
                                sql = " Insert into p_escala_preguntas(Nbre, Estado, UsuarioS)  values ('" + this.JTFNombre.getText().toUpperCase() + "','" + this.xestado + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                                break;
                            case "Tipo Documento Soporte":
                                if (this.JCHEstado.isSelected()) {
                                    this.xestado = 1;
                                } else {
                                    this.xestado = 0;
                                }
                                sql = " Insert into g_tipo_documento_soporte(Nbre, IdReporte, tipoClasifiacion,  Estado, Fecha, UsuarioS)  values ('" + this.JTFNombre.getText().toUpperCase() + "','" + this.JTFIdReporte.getText() + "','" + this.JCBTipoClasificacion.getSelectedIndex() + "','" + this.xestado + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                                System.out.println(sql);
                                break;
                            case "Prueba Mauricio":
                                if (this.JCHEstado.isSelected()) {
                                    this.xestado = 1;
                                } else {
                                    this.xestado = 0;
                                }
                                sql = " Insert into rh_activos_mantenimiento(Nbre, Estado, Id_UsuarioS)  values ('" + this.JTFNombre.getText().toUpperCase() + "','" + this.xestado + "','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "')";
                                break;
                            case "Población Especial":
                                if (this.JCHEstado.isSelected()) {
                                    this.xestado = 1;
                                } else {
                                    this.xestado = 0;
                                }
                                sql = " Insert into g_poblacion_especial(Nbre, Estado, UsuarioS)  values ('" + this.JTFNombre.getText().toUpperCase() + "','" + this.xestado + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                                break;
                            case "Estado Civil":
                                sql = " Insert into g_estadocivil (Nbre, Estado, UsuarioS)  values ('" + this.JTFNombre.getText().toUpperCase() + "','" + this.xestado + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                                break;
                            case "Clasificacion de Respuesta":
                                if (this.JCHEstado.isSelected()) {
                                    this.xestado = 1;
                                } else {
                                    this.xestado = 0;
                                }
                                sql = " Insert into t_clasificacionqrs(Nbre, Estado, Fecha, UsuarioS)  values ('" + this.JTFNombre.getText().toUpperCase() + "','" + this.xestado + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                                break;
                            case "Tipo de Registro":
                                sql = " Insert into t_tiporegistro(Nbre, Estado, Fecha, UsuarioS)  values ('" + this.JTFNombre.getText().toUpperCase() + "','" + this.xestado + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                                break;
                            case "Sitio Ocurrencia":
                                sql = " Insert into t_sitioocurrencia(Nbre, Estado, Fecha, UsuarioS)  values ('" + this.JTFNombre.getText().toUpperCase() + "','" + this.xestado + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                                break;
                            case "Medio Recepción":
                                sql = " Insert into g_mediorecepcion(Nbre, Estado, Fecha, UsuarioS)  values ('" + this.JTFNombre.getText().toUpperCase() + "','" + this.xestado + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                                break;
                            case "Frecuencias":
                                sql = " Insert into g_frecuencias (Nbre, Estado, Fecha, Usuario)  values ('" + this.JTFNombre.getText().toUpperCase() + "','" + this.xestado + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                                break;
                            case "Tipo Afiliado":
                                sql = " Insert into g_tipoafiliado (Nbre, Estado, Fecha, UsuarioS)  values ('" + this.JTFNombre.getText().toUpperCase() + "','" + this.xestado + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                                break;
                            case "Tipo Manual Tarifas":
                                if (this.JCHEstado.isSelected()) {
                                    this.xestado = 1;
                                } else {
                                    this.xestado = 0;
                                }
                                sql = " Insert into g_tipo_manual_tarifas(Nbre, Estado, UsuarioS)  values ('" + this.JTFNombre.getText().toUpperCase() + "','" + this.xestado + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                                break;
                            case "Tipo Etnia":
                                if (this.JCHEstado.isSelected()) {
                                    this.xestado = 1;
                                } else {
                                    this.xestado = 0;
                                }
                                sql = " Insert into g_tipo_etnia(Nbre, Estado, UsuarioS)  values ('" + this.JTFNombre.getText().toUpperCase() + "','" + this.xestado + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                                break;
                            case "Tipo División":
                                if (this.JCHEstado.isSelected()) {
                                    this.xestado = 1;
                                } else {
                                    this.xestado = 0;
                                }
                                sql = " Insert into g_tipo_division(Nbre, Estado, UsuarioS)  values ('" + this.JTFNombre.getText().toUpperCase() + "','" + this.xestado + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                                break;
                            case "Tipo Descuento":
                                if (this.JCHEstado.isSelected()) {
                                    this.xestado = 1;
                                } else {
                                    this.xestado = 0;
                                }
                                sql = " Insert into g_tipo_descuento(Nbre, Estado, UsuarioS)  values ('" + this.JTFNombre.getText().toUpperCase() + "','" + this.xestado + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                                break;
                            case "Muestra Citologia":
                                if (this.JCHEstado.isSelected()) {
                                    this.xestado = 1;
                                } else {
                                    this.xestado = 0;
                                }
                                sql = " Insert into p_citologia_cmuestra(Nbre, Estado, UsuarioS)  values ('" + this.JTFNombre.getText().toUpperCase() + "','" + this.xestado + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                                break;
                            case "Tipo Seguimiento":
                                if (this.JCHEstado.isSelected()) {
                                    this.xestado = 1;
                                } else {
                                    this.xestado = 0;
                                }
                                sql = "INSERT INTO p_citologia_tiposeguimiento (Nbre,Estado,IdUsuarioS)\nVALUES ('" + this.JTFNombre.getText().toUpperCase() + "','" + this.xestado + "','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "');";
                                break;
                            case "Esquema Citologia":
                                if (this.JCHEstado.isSelected()) {
                                    this.xestado = 0;
                                } else {
                                    this.xestado = 1;
                                }
                                sql = " Insert into p_citologiaesquema (Nbre, Estado, Fecha, UsuarioS)  values ('" + this.JTFNombre.getText().toUpperCase() + "','" + this.xestado + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                                break;
                            case "Tipo de Parto":
                                if (this.JCHEstado.isSelected()) {
                                    this.xestado = 0;
                                } else {
                                    this.xestado = 1;
                                }
                                sql = " Insert into g_tipoparto (Nbre, Estado, Fecha, UsuarioS)  values ('" + this.JTFNombre.getText().toUpperCase() + "','" + this.xestado + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                                break;
                        }
                    } else {
                        switch (this.xnombre) {
                            case "Tipo de Plan":
                                sql = " update f_tipoplan set Nbre='" + this.JTFNombre.getText().toUpperCase() + "',Estado='" + this.xestado + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
                                break;
                            case "Tipo de Régimen":
                                sql = " update f_tiporegimen set Nbre='" + this.JTFNombre.getText().toUpperCase() + "',Estado='" + this.xestado + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
                                break;
                            case "Tipo Cita":
                                sql = " update c_tipocita set Nbre='" + this.JTFNombre.getText().toUpperCase() + "',Estado='" + this.xestado + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
                                break;
                            case "Motivo Anulación Citas":
                                sql = " update c_motivodesistida set Nbre='" + this.JTFNombre.getText().toUpperCase() + "',Estado='" + this.xestado + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
                                break;
                            case "Concepto Anticipo":
                                sql = " update cc_concepto_anticipos set Nbre='" + this.JTFNombre.getText().toUpperCase() + "',Estado='" + this.xestado + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
                                break;
                            case "Causa de Daño":
                                sql = " update g_tipo_causadañoplacas set Nbre='" + this.JTFNombre.getText().toUpperCase() + "',Estado='" + this.xestado + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
                                break;
                            case "Tipo Placa":
                                sql = " update g_tipo_placasrx set Nbre='" + this.JTFNombre.getText().toUpperCase() + "',Estado='" + this.xestado + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
                                break;
                            case "Áreas":
                                sql = " update l_areas set Nbre='" + this.JTFNombre.getText().toUpperCase() + "',Estado='" + this.xestado + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
                                break;
                            case "Nivel de Estudio":
                                sql = " update g_nivelestudio set Nbre='" + this.JTFNombre.getText().toUpperCase() + "',Estado='" + this.xestado + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
                                break;
                            case "Vacunas":
                                sql = " update p_vacunacion_vacunas set Nbre='" + this.JTFNombre.getText().toUpperCase() + "',Estado='" + this.xestado + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
                                break;
                            case "Dosis Vacunas":
                                sql = " update p_vacunacion_dosis set Nbre='" + this.JTFNombre.getText().toUpperCase() + "',Estado='" + this.xestado + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
                                break;
                            case "Clasificación":
                                sql = " update i_clasificacion set Nbre='" + this.JTFNombre.getText().toUpperCase() + "',Estado='" + this.xestado + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
                                break;
                            case "Motivo de Traslado":
                                sql = " update rh_activos_tipo_traslado set Nbre='" + this.JTFNombre.getText().toUpperCase() + "',Estado='" + this.xestado + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
                                break;
                            case "Grupo Equipo":
                                sql = " update rh_activo_tipo_nagrupacion set Nbre='" + this.JTFNombre.getText().toUpperCase() + "',Estado='" + this.xestado + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
                                break;
                            case "Tipo de DocumentosHC":
                                sql = " update h_tipodocumentoshc set Nbre='" + this.JTFNombre.getText().toUpperCase() + "',Estado='" + this.xestado + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
                                break;
                            case "Tipo de Nota":
                                if (this.JCHEstado.isSelected()) {
                                    this.xestado = 1;
                                } else {
                                    this.xestado = 0;
                                }
                                sql = " update h_tiponota set Nbre='" + this.JTFNombre.getText().toUpperCase() + "',Estado='" + this.xestado + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
                                break;
                            case "Tipo de Clasificacion":
                                if (this.JCHEstado.isSelected()) {
                                    this.xestado = 1;
                                } else {
                                    this.xestado = 0;
                                }
                                sql = " update rh_tipo_clasificacion set Nbre='" + this.JTFNombre.getText().toUpperCase() + "',Estado='" + this.xestado + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', Id_UsuarioS='" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "' Where Id='" + Principal.txtNo.getText() + "'";
                                break;
                            case "Ecografía":
                                if (this.JCHEstado.isSelected()) {
                                    this.xestado = 1;
                                } else {
                                    this.xestado = 0;
                                }
                                sql = " update h_ecog_datosp set Nbre='" + this.JTFNombre.getText().toUpperCase() + "',Estado='" + this.xestado + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
                                break;
                            case "Concepto Específico":
                                if (this.JCHEstado.isSelected()) {
                                    this.xestado = 1;
                                } else {
                                    this.xestado = 0;
                                }
                                sql = " update so_concepto_especifico set Nbre='" + this.JTFNombre.getText().toUpperCase() + "',Estado='" + this.xestado + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
                                break;
                            case "Recomendaciones":
                                if (this.JCHEstado.isSelected()) {
                                    this.xestado = 1;
                                } else {
                                    this.xestado = 0;
                                }
                                sql = " update so_recomendaciones set Nbre='" + this.JTFNombre.getText().toUpperCase() + "',Estado='" + this.xestado + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
                                break;
                            case "Segmentos":
                                if (this.JCHEstado.isSelected()) {
                                    this.xestado = 1;
                                } else {
                                    this.xestado = 0;
                                }
                                sql = " update so_segmento set Nbre='" + this.JTFNombre.getText().toUpperCase() + "',Estado='" + this.xestado + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
                                break;
                            case "Correción":
                                if (this.JCHEstado.isSelected()) {
                                    this.xestado = 1;
                                } else {
                                    this.xestado = 0;
                                }
                                sql = " update so_tipo_correccion set Nbre='" + this.JTFNombre.getText().toUpperCase() + "',Estado='" + this.xestado + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
                                break;
                            case "Grupo Turnos":
                                if (this.JCHEstado.isSelected()) {
                                    this.xestado = 1;
                                } else {
                                    this.xestado = 0;
                                }
                                sql = " update so_tipo_grupo set Nbre='" + this.JTFNombre.getText().toUpperCase() + "',Estado='" + this.xestado + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
                                break;
                            case "Actividad Física":
                                if (this.JCHEstado.isSelected()) {
                                    this.xestado = 1;
                                } else {
                                    this.xestado = 0;
                                }
                                sql = " update so_actividad_fisica set Nbre='" + this.JTFNombre.getText().toUpperCase() + "',Estado='" + this.xestado + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
                                break;
                            case "Escala del Dolor":
                                if (this.JCHEstado.isSelected()) {
                                    this.xestado = 1;
                                } else {
                                    this.xestado = 0;
                                }
                                sql = " update so_intensidad_dolor set Nbre='" + this.JTFNombre.getText().toUpperCase() + "',Estado='" + this.xestado + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
                                break;
                            case "Tipo de Dolor":
                                if (this.JCHEstado.isSelected()) {
                                    this.xestado = 1;
                                } else {
                                    this.xestado = 0;
                                }
                                sql = " update so_tipodolor set Nbre='" + this.JTFNombre.getText().toUpperCase() + "',Estado='" + this.xestado + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
                                break;
                            case "Tipo Actividad Física":
                                if (this.JCHEstado.isSelected()) {
                                    this.xestado = 1;
                                } else {
                                    this.xestado = 0;
                                }
                                sql = " update so_tipo_actividad_fisica set Nbre='" + this.JTFNombre.getText().toUpperCase() + "',Estado='" + this.xestado + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
                                break;
                            case "Tipo Vinculación":
                                if (this.JCHEstado.isSelected()) {
                                    this.xestado = 1;
                                } else {
                                    this.xestado = 0;
                                }
                                sql = " update so_tipo_vinculacion set Nbre='" + this.JTFNombre.getText().toUpperCase() + "',Estado='" + this.xestado + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
                                break;
                            case "Tipo Sustancia":
                                if (this.JCHEstado.isSelected()) {
                                    this.xestado = 1;
                                } else {
                                    this.xestado = 0;
                                }
                                sql = " update so_tipo_sustancia set Nbre='" + this.JTFNombre.getText().toUpperCase() + "',Estado='" + this.xestado + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
                                break;
                            case "Tipo Subcategoria":
                                if (this.JCHEstado.isSelected()) {
                                    this.xestado = 1;
                                } else {
                                    this.xestado = 0;
                                }
                                sql = " update so_tipo_subcategoria set Nbre='" + this.JTFNombre.getText().toUpperCase() + "',Estado='" + this.xestado + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
                                break;
                            case "Motivo Prueba":
                                if (this.JCHEstado.isSelected()) {
                                    this.xestado = 1;
                                } else {
                                    this.xestado = 0;
                                }
                                sql = " update so_tipo_motivo_prueba set Nbre='" + this.JTFNombre.getText().toUpperCase() + "',Estado='" + this.xestado + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
                                break;
                            case "Tipo Cuestionario":
                                if (this.JCHEstado.isSelected()) {
                                    this.xestado = 1;
                                } else {
                                    this.xestado = 0;
                                }
                                sql = " update so_tipo_cuestionario set Nbre='" + this.JTFNombre.getText().toUpperCase() + "',Estado='" + this.xestado + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
                                break;
                            case "Escala CyD":
                                if (this.JCHEstado.isSelected()) {
                                    this.xestado = 1;
                                } else {
                                    this.xestado = 0;
                                }
                                sql = " update p_escala_categoria set Nbre='" + this.JTFNombre.getText().toUpperCase() + "',Estado='" + this.xestado + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
                                break;
                            case "Preguntas CyD":
                                if (this.JCHEstado.isSelected()) {
                                    this.xestado = 1;
                                } else {
                                    this.xestado = 0;
                                }
                                sql = " update p_escala_preguntas set Nbre='" + this.JTFNombre.getText().toUpperCase() + "', Estado='" + this.xestado + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
                                break;
                            case "Tipo Documento Soporte":
                                if (this.JCHEstado.isSelected()) {
                                    this.xestado = 1;
                                } else {
                                    this.xestado = 0;
                                }
                                sql = " update g_tipo_documento_soporte set Nbre='" + this.JTFNombre.getText().toUpperCase() + "',IdReporte='" + this.JTFIdReporte.getText() + "',tipoClasifiacion='" + this.JCBTipoClasificacion.getSelectedIndex() + "',Estado='" + this.xestado + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
                                break;
                            case "Prueba Mauricio":
                                if (this.JCHEstado.isSelected()) {
                                    this.xestado = 1;
                                } else {
                                    this.xestado = 0;
                                }
                                sql = " update rh_activos_mantenimiento set Nbre='" + this.JTFNombre.getText().toUpperCase() + "',Estado='" + this.xestado + "', Id_UsuarioS='" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "' Where Id='" + Principal.txtNo.getText() + "'";
                                break;
                            case "Población Especial":
                                if (this.JCHEstado.isSelected()) {
                                    this.xestado = 1;
                                } else {
                                    this.xestado = 0;
                                }
                                sql = " update g_poblacion_especial set Nbre='" + this.JTFNombre.getText().toUpperCase() + "',Estado='" + this.xestado + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
                                break;
                            case "Estado Civil":
                                sql = " update g_estadocivil set Nbre='" + this.JTFNombre.getText().toUpperCase() + "',Estado='" + this.xestado + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
                                break;
                            case "Clasificacion de Respuesta":
                                if (this.JCHEstado.isSelected()) {
                                    this.xestado = 1;
                                } else {
                                    this.xestado = 0;
                                }
                                sql = " update t_clasificacionqrs set Nbre='" + this.JTFNombre.getText().toUpperCase() + "', Estado='" + this.xestado + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
                                break;
                            case "Tipo de Registro":
                                sql = " update t_tiporegistro set Nbre='" + this.JTFNombre.getText().toUpperCase() + "', Estado='" + this.xestado + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
                                break;
                            case "Sitio Ocurrencia":
                                sql = " update t_sitioocurrencia set Nbre='" + this.JTFNombre.getText().toUpperCase() + "', Estado='" + this.xestado + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
                                break;
                            case "Medio Recepción":
                                sql = " update g_mediorecepcion set Nbre='" + this.JTFNombre.getText().toUpperCase() + "', Estado='" + this.xestado + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
                                break;
                            case "Frecuencias":
                                sql = " update g_frecuencias set Nbre='" + this.JTFNombre.getText().toUpperCase() + "', Estado='" + this.xestado + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', Usuario='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
                                break;
                            case "Tipo Afiliado":
                                sql = " update g_tipoafiliado set Nbre='" + this.JTFNombre.getText().toUpperCase() + "', Estado='" + this.xestado + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
                                break;
                            case "Tipo Manual Tarifas":
                                if (this.JCHEstado.isSelected()) {
                                    this.xestado = 1;
                                } else {
                                    this.xestado = 0;
                                }
                                sql = " update g_tipo_manual_tarifas set Nbre='" + this.JTFNombre.getText().toUpperCase() + "', Estado='" + this.xestado + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
                                break;
                            case "Tipo Etnia":
                                if (this.JCHEstado.isSelected()) {
                                    this.xestado = 1;
                                } else {
                                    this.xestado = 0;
                                }
                                sql = " update g_tipo_etnia set Nbre='" + this.JTFNombre.getText().toUpperCase() + "', Estado='" + this.xestado + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
                                break;
                            case "Tipo División":
                                if (this.JCHEstado.isSelected()) {
                                    this.xestado = 1;
                                } else {
                                    this.xestado = 0;
                                }
                                sql = " update g_tipo_division set Nbre='" + this.JTFNombre.getText().toUpperCase() + "', Estado='" + this.xestado + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
                                break;
                            case "Tipo Descuento":
                                if (this.JCHEstado.isSelected()) {
                                    this.xestado = 1;
                                } else {
                                    this.xestado = 0;
                                }
                                sql = " update g_tipo_descuento set Nbre='" + this.JTFNombre.getText().toUpperCase() + "', Estado='" + this.xestado + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
                                break;
                            case "Muestra Citologia":
                                if (this.JCHEstado.isSelected()) {
                                    this.xestado = 1;
                                } else {
                                    this.xestado = 0;
                                }
                                sql = " update p_citologia_cmuestra set Nbre='" + this.JTFNombre.getText().toUpperCase() + "', Estado='" + this.xestado + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
                                break;
                            case "Tipo Seguimiento":
                                if (this.JCHEstado.isSelected()) {
                                    this.xestado = 1;
                                } else {
                                    this.xestado = 0;
                                }
                                sql = "UPDATE p_citologia_tiposeguimiento SET  Nbre = '" + this.JTFNombre.getText().toUpperCase() + "',  Estado = '" + this.xestado + "',  IdUsuarioS = '" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "' WHERE Id = '" + Principal.txtNo.getText() + "';";
                                break;
                            case "Esquema Citologia":
                                if (this.JCHEstado.isSelected()) {
                                    this.xestado = 0;
                                } else {
                                    this.xestado = 1;
                                }
                                sql = " update p_citologiaesquema set Nbre='" + this.JTFNombre.getText().toUpperCase() + "', Estado='" + this.xestado + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
                                break;
                            case "Tipo de Parto":
                                if (this.JCHEstado.isSelected()) {
                                    this.xestado = 0;
                                } else {
                                    this.xestado = 1;
                                }
                                sql = " update g_tipoparto set Nbre='" + this.JTFNombre.getText().toUpperCase() + "', Estado='" + this.xestado + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
                                break;
                        }
                    }
                    System.out.println(sql);
                    this.xconsulta.ejecutarSQL(sql);
                    this.xconsulta.cerrarConexionBd();
                    mCargarDatosTabla();
                    mNuevo();
                    return;
                }
                if (this.xid.isEmpty()) {
                    int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    if (x == 0) {
                        switch (this.xnombre) {
                            case "Presentación Comercial":
                                sql = " Insert into i_presentacioncomercial(Nbre, Estado, Fecha, UsuarioS)  values ('" + this.JTFNombre.getText().toUpperCase() + "','" + this.xestado + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                                break;
                            case "Concentración":
                                sql = " Insert into i_concentracion(Nbre, Estado, Fecha, UsuarioS)  values ('" + this.JTFNombre.getText().toUpperCase() + "','" + this.xestado + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                                break;
                            case "Laboratorio":
                                sql = " Insert into i_laboratorio(Nbre, Estado, Fecha, UsuarioS)  values ('" + this.JTFNombre.getText().toUpperCase() + "','" + this.xestado + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                                break;
                        }
                        System.out.println(this.xnombre + "-->CONsulta-->" + sql);
                        this.xconsulta.ejecutarSQL(sql);
                        this.xconsulta.cerrarConexionBd();
                        mRecargarCombo();
                        mCargarDatosTabla();
                        return;
                    }
                    return;
                }
                int x2 = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (x2 == 0) {
                    switch (this.xnombre) {
                        case "Presentación Comercial":
                            sql = " update i_presentacioncomercial set Nbre='" + this.JTFNombre.getText().toUpperCase() + "',Estado='" + this.xestado + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + this.xid + "'";
                            break;
                        case "Concentración":
                            sql = " update i_concentracion set Nbre='" + this.JTFNombre.getText().toUpperCase() + "',Estado='" + this.xestado + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + this.xid + "'";
                            break;
                        case "Laboratorio":
                            sql = " update i_laboratorio set Nbre='" + this.JTFNombre.getText().toUpperCase() + "',Estado='" + this.xestado + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + this.xid + "'";
                            break;
                    }
                    System.out.println(this.xnombre + "-->CONsulta-->" + sql);
                    this.xconsulta.ejecutarSQL(sql);
                    this.xconsulta.cerrarConexionBd();
                    mRecargarCombo();
                    mCargarDatosTabla();
                    return;
                }
                return;
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "El campo nombre no puede ser nulo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JTFNombre.requestFocus();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"No.", "NOMBRE", "REGISTRO", "CLASIFICACION", "ESTADO"}) { // from class: ParametrizacionN.JIFGenerico1CheckBox.5
            Class[] types = {Integer.class, String.class, Integer.class, Integer.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTDetalle;
        JTable jTable2 = this.JTDetalle;
        jTable.setAutoResizeMode(0);
        this.JTDetalle.doLayout();
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(400);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(80);
    }

    private void mCargarDatosTabla() {
        String sql;
        try {
            mCrearModeloDatos();
            sql = null;
            switch (this.xnombre) {
                case "Tipo de Plan":
                    sql = "SELECT Id, Nbre, '', 0,  Estado FROM f_tipoplan ORDER BY Nbre ASC";
                    break;
                case "Tipo de Régimen":
                    sql = "SELECT Id, Nbre, '', 0,Estado FROM f_tiporegimen ORDER BY Nbre ASC";
                    break;
                case "Presentación Comercial":
                    sql = "SELECT Id, Nbre, '', 0,Estado FROM i_presentacioncomercial ORDER BY Nbre ASC";
                    break;
                case "Concentración":
                    sql = "SELECT Id, Nbre, '', 0,Estado FROM i_concentracion ORDER BY Nbre ASC";
                    break;
                case "Laboratorio":
                    sql = "SELECT Id, Nbre, '', 0,Estado FROM i_laboratorio ORDER BY Nbre ASC";
                    break;
                case "Tipo Cita":
                    sql = "SELECT Id, Nbre, '', 0,Estado FROM c_tipocita ORDER BY Nbre ASC";
                    break;
                case "Motivo Anulación Citas":
                    sql = "SELECT Id, Nbre, '', 0,Estado FROM c_motivodesistida ORDER BY Nbre ASC";
                    break;
                case "Concepto Anticipo":
                    sql = "SELECT Id, Nbre,'', 0, Estado FROM cc_concepto_anticipos ORDER BY Nbre ASC";
                    break;
                case "Causa de Daño":
                    sql = "SELECT Id, Nbre, '', 0,Estado FROM g_tipo_causadañoplacas ORDER BY Nbre ASC";
                    break;
                case "Tipo Placa":
                    sql = "SELECT Id, Nbre, '', 0,Estado FROM g_tipo_placasrx ORDER BY Nbre ASC";
                    break;
                case "Áreas":
                    sql = "SELECT Id, Nbre, '', 0, IF(Estado=0,TRUE,FALSE) AS Estado FROM l_areas ORDER BY Nbre ASC";
                    break;
                case "Nivel de Estudio":
                    sql = "SELECT Id, Nbre, '', 0,Estado FROM g_nivelestudio ORDER BY Nbre ASC";
                    break;
                case "Vacunas":
                    sql = "SELECT Id, Nbre, '', 0,Estado FROM p_vacunacion_vacunas ORDER BY Nbre ASC";
                    break;
                case "Dosis Vacunas":
                    sql = "SELECT Id, Nbre, '', 0,Estado FROM p_vacunacion_dosis ORDER BY Nbre ASC";
                    break;
                case "Clasificación":
                    sql = "SELECT Id, Nbre, '', 0,Estado FROM i_clasificacion ORDER BY Id ASC";
                    break;
                case "Motivo de Traslado":
                    sql = "SELECT Id, Nbre, '', 0,Estado FROM rh_activos_tipo_traslado ORDER BY Id ASC";
                    break;
                case "Grupo Equipo":
                    sql = "SELECT Id, Nbre, '', 0,Estado FROM rh_activo_tipo_nagrupacion ORDER BY Id ASC";
                    break;
                case "Tipo de DocumentosHC":
                    sql = "SELECT Id, Nbre, '', 0,Estado FROM h_tipodocumentoshc ORDER BY Id ASC";
                    break;
                case "Tipo de Nota":
                    sql = "SELECT Id, Nbre, '', 0,IF(Estado=0,TRUE,FALSE)AS Estado  FROM h_tiponota ORDER BY Id ASC";
                    break;
                case "Ecografía":
                    sql = "SELECT Id, Nbre, '', 0,IF(Estado=0,TRUE,FALSE)AS Estado  FROM h_ecog_datosp ORDER BY Id ASC";
                    break;
                case "Concepto Específico":
                    sql = "SELECT `Id` , `Nbre`,'', 0, IF(Estado=0,TRUE,FALSE)AS Estado FROM `so_concepto_especifico` order by Nbre ASC";
                    break;
                case "Recomendaciones":
                    sql = "SELECT  `Id`, `Nbre` ,'', 0, IF(Estado=0,TRUE,FALSE)AS Estado FROM `so_recomendaciones` order by Nbre ASC";
                    break;
                case "Segmentos":
                    sql = "SELECT  `Id`, `Nbre` , '', 0,IF(Estado=0,TRUE,FALSE)AS Estado FROM `so_segmento` order by Nbre ASC";
                    break;
                case "Correción":
                    sql = "SELECT  `Id`, `Nbre` , '', 0,IF(Estado=0,TRUE,FALSE)AS Estado FROM `so_tipo_correccion` order by Nbre ASC";
                    break;
                case "Grupo Turnos":
                    sql = "SELECT  `Id`, `Nbre` , '', 0,IF(Estado=0,TRUE,FALSE)AS Estado FROM `so_tipo_grupo` order by Nbre ASC";
                    break;
                case "Actividad Física":
                    sql = "SELECT  `Id`, `Nbre` ,'', 0, IF(Estado=0,TRUE,FALSE)AS Estado FROM `so_actividad_fisica` order by Nbre ASC";
                    break;
                case "Escala del Dolor":
                    sql = "SELECT  `Id`, `Nbre` ,'', 0, IF(Estado=0,TRUE,FALSE)AS Estado FROM `so_intensidad_dolor` order by Id ASC";
                    break;
                case "Tipo de Dolor":
                    sql = "SELECT  `Id`, `Nbre` , '', 0,IF(Estado=0,TRUE,FALSE)AS Estado FROM `so_tipodolor` order by Id ASC";
                    break;
                case "Tipo Actividad Física":
                    sql = "SELECT  `Id`, `Nbre` , '', 0,IF(Estado=0,TRUE,FALSE)AS Estado FROM `so_tipo_actividad_fisica` order by Id ASC";
                    break;
                case "Tipo Vinculación":
                    sql = "SELECT  `Id`, `Nbre` ,'', 0, IF(Estado=0,TRUE,FALSE)AS Estado FROM `so_tipo_vinculacion` order by Nbre ASC";
                    break;
                case "Tipo Sustancia":
                    sql = "SELECT  `Id`, `Nbre` , '', 0,IF(Estado=0,TRUE,FALSE)AS Estado FROM `so_tipo_sustancia` order by Nbre ASC";
                    break;
                case "Tipo Subcategoria":
                    sql = "SELECT  `Id`, `Nbre` ,'', 0, IF(Estado=0,TRUE,FALSE)AS Estado FROM `so_tipo_subcategoria` order by Nbre ASC";
                    break;
                case "Motivo Prueba":
                    sql = "SELECT  `Id`, `Nbre` , '', 0,IF(Estado=0,TRUE,FALSE)AS Estado FROM `so_tipo_motivo_prueba` order by Nbre ASC";
                    break;
                case "Tipo Cuestionario":
                    sql = "SELECT  `Id`, `Nbre` , '', 0,IF(Estado=0,TRUE,FALSE)AS Estado FROM `so_tipo_cuestionario` order by Nbre ASC";
                    break;
                case "Escala CyD":
                    sql = "SELECT  `Id`, `Nbre` ,'', 0, IF(Estado=0,TRUE,FALSE)AS Estado FROM `p_escala_categoria` order by Nbre ASC";
                    break;
                case "Preguntas CyD":
                    sql = "SELECT  `Id`, `Nbre` , '', 0,IF(Estado=0,TRUE,FALSE)AS Estado FROM `p_escala_preguntas` order by Id ASC";
                    break;
                case "Tipo Documento Soporte":
                    sql = "SELECT  `Id`, `Nbre` , '', 0,`IdReporte`, `tipoClasifiacion`, `Estado`  FROM g_tipo_documento_soporte ORDER BY Id ASC";
                    break;
                case "Prueba Mauricio":
                    sql = "SELECT  `Id`, `Nbre` ,'', 0, IF(Estado=0,TRUE,FALSE) AS Estado FROM rh_activos_mantenimiento order by Id ASC";
                    break;
                case "Población Especial":
                    sql = "SELECT  `Id`, `Nbre` , '', 0,IF(Estado=0,TRUE,FALSE) AS Estado FROM g_poblacion_especial order by Nbre ASC";
                    break;
                case "Estado Civil":
                    sql = "SELECT  `Id`, `Nbre` , '', 0,Estado FROM g_estadocivil order by Nbre ASC";
                    break;
                case "Clasificacion de Respuesta":
                    sql = "SELECT  `Id`, `Nbre` ,'', 0, Estado FROM t_clasificacionqrs order by Nbre ASC";
                    break;
                case "Tipo de Registro":
                    sql = "SELECT  `Id`, `Nbre` ,'', 0, Estado FROM t_tiporegistro order by Nbre ASC";
                    break;
                case "Sitio Ocurrencia":
                    sql = "SELECT  `Id`, `Nbre` ,'', 0, Estado FROM t_sitioocurrencia order by Nbre ASC";
                    break;
                case "Medio Recepción":
                    sql = "SELECT  `Id`, `Nbre`,'', 0, Estado FROM g_mediorecepcion order by Nbre ASC";
                    break;
                case "Frecuencias":
                    sql = "SELECT  `Id`, `Nbre`, '', 0,Estado FROM g_frecuencias order by Nbre ASC";
                    break;
                case "Tipo Afiliado":
                    sql = "SELECT  `Id`, `Nbre`,'', 0, Estado FROM g_tipoafiliado order by Nbre ASC";
                    break;
                case "Tipo Manual Tarifas":
                    sql = "SELECT  `Id`, `Nbre`, '', 0,Estado FROM g_tipo_manual_tarifas order by Nbre ASC";
                    break;
                case "Tipo Etnia":
                    sql = "SELECT  `Id`, `Nbre`, '', 0,Estado FROM g_tipo_etnia order by Nbre ASC";
                    break;
                case "Tipo División":
                    sql = "SELECT  `Id`, `Nbre`, '', 0,Estado FROM g_tipo_division order by Nbre ASC";
                    break;
                case "Tipo Descuento":
                    sql = "SELECT  `Id`, `Nbre`,'', 0, Estado FROM g_tipo_descuento order by Nbre ASC";
                    break;
                case "Muestra Citologia":
                    sql = "SELECT  `Id`, `Nbre`, '', 0,Estado FROM p_citologia_cmuestra order by Nbre ASC";
                    break;
                case "Tipo Seguimiento":
                    sql = "SELECT Id,Nbre,Estado '', 0,FROM p_citologia_tiposeguimiento order by Nbre ASC";
                    break;
                case "Esquema Citologia":
                    sql = "SELECT  `Id`, `Nbre`,'', 0, Estado FROM p_citologiaesquema order by Nbre ASC";
                    break;
                case "Tipo de Clasificacion":
                    sql = "SELECT  `Id`, `Nbre`, '', 0,Estado FROM `rh_tipo_clasificacion` ORDER BY Nbre ASC";
                    break;
                case "Tipo de Parto":
                    sql = "SELECT  `Id`, `Nbre`,'', 0, Estado FROM `g_tipoparto` ORDER BY Nbre ASC";
                    break;
            }
            ResultSet xrs = this.xconsulta.traerRs(sql);
            Throwable th = null;
            try {
                try {
                    if (xrs.next()) {
                        xrs.beforeFirst();
                        int n = 0;
                        while (xrs.next()) {
                            this.xmodelo.addRow(this.xdatos);
                            this.xmodelo.setValueAt(xrs.getString(1), n, 0);
                            this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                            this.xmodelo.setValueAt(xrs.getString(3), n, 2);
                            this.xmodelo.setValueAt(xrs.getString(4), n, 3);
                            this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean("Estado")), n, 4);
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
            Logger.getLogger(JIFGenerico1CheckBox.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mRecargarCombo() {
        switch (this.xnombre) {
            case "Presentación Comercial":
                this.xjifsuministro.JCBPComercial.removeAllItems();
                this.xjifsuministro.xidpresentacionc = this.xconsulta.llenarCombo("SELECT Id, Nbre FROM baseserver.i_presentacioncomercial WHERE (Estado =0) ORDER BY Nbre ASC", this.xjifsuministro.xidpresentacionc, this.xjifsuministro.JCBPComercial);
                this.xjifsuministro.JCBPComercial.setSelectedIndex(-1);
                break;
            case "Concentración":
                this.xjifsuministro.JCBConcentracion.removeAllItems();
                this.xjifsuministro.xidconcentracion = this.xconsulta.llenarCombo("SELECT Id, Nbre FROM baseserver.i_concentracion WHERE (Estado =0) ORDER BY Nbre ASC", this.xjifsuministro.xidconcentracion, this.xjifsuministro.JCBConcentracion);
                this.xjifsuministro.JCBConcentracion.setSelectedIndex(-1);
                break;
            case "Laboratorio":
                this.xjifsuministro.JCBLaboratorio.removeAllItems();
                this.xjifsuministro.xidlaboratorio = this.xconsulta.llenarCombo("SELECT Id, Nbre FROM baseserver.i_laboratorio WHERE (Estado =0) ORDER BY Nbre ASC", this.xjifsuministro.xidlaboratorio, this.xjifsuministro.JCBLaboratorio);
                this.xjifsuministro.JCBLaboratorio.setSelectedIndex(-1);
                break;
        }
        this.xconsulta.cerrarConexionBd();
        dispose();
    }
}
