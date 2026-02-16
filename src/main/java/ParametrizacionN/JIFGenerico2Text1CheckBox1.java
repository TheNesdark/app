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
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:ParametrizacionN/JIFGenerico2Text1CheckBox1.class */
public class JIFGenerico2Text1CheckBox1 extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private Object[] xdatos;
    private String xnombre;
    private JIFSSuministro xjifsuministro;
    private String idPadre;
    private JCheckBox JCHEstado;
    private JPanel JPIDatos;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;
    private JTextField JTFCodigo;
    private JTextField JTFNombre;
    private ConsultasMySQL xconsulta = new ConsultasMySQL();
    private Metodos xmetodos = new Metodos();
    private int xestado = 0;
    private String xid = "";
    private boolean xestadog = false;

    public JIFGenerico2Text1CheckBox1(String xnombre, String xnombref) {
        initComponents();
        setName(xnombref);
        setTitle(xnombre.toUpperCase());
        this.xnombre = xnombre;
        mCargarDatosTabla();
        mNuevo();
    }

    public JIFGenerico2Text1CheckBox1(String xnombre, String xnombref, JIFSSuministro xjifsuministro) {
        initComponents();
        this.xjifsuministro = xjifsuministro;
        setName(xnombref);
        setTitle(xnombre.toUpperCase());
        this.xnombre = xnombre;
        mCargarDatosTabla();
    }

    /* JADX WARN: Type inference failed for: r3v29, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPIDatos = new JPanel();
        this.JTFCodigo = new JTextField();
        this.JTFNombre = new JTextField();
        this.JCHEstado = new JCheckBox();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("GENERICO2");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifgenerico2");
        try {
            setSelected(true);
        } catch (PropertyVetoException e1) {
            e1.printStackTrace();
        }
        addInternalFrameListener(new InternalFrameListener() { // from class: ParametrizacionN.JIFGenerico2Text1CheckBox1.1
            public void internalFrameClosed(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                JIFGenerico2Text1CheckBox1.this.formInternalFrameClosing(evt);
            }

            public void internalFrameOpened(InternalFrameEvent evt) {
            }

            public void internalFrameActivated(InternalFrameEvent evt) {
            }

            public void internalFrameDeactivated(InternalFrameEvent evt) {
            }

            public void internalFrameDeiconified(InternalFrameEvent evt) {
            }

            public void internalFrameIconified(InternalFrameEvent evt) {
            }
        });
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTFCodigo.setFont(new Font("Arial", 1, 12));
        this.JTFCodigo.setToolTipText("");
        this.JTFCodigo.setBorder(BorderFactory.createTitledBorder((Border) null, "Código", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFNombre.setFont(new Font("Arial", 1, 12));
        this.JTFNombre.setToolTipText("");
        this.JTFNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setSelected(true);
        this.JCHEstado.setText("Estado");
        this.JCHEstado.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFGenerico2Text1CheckBox1.2
            public void actionPerformed(ActionEvent evt) {
                JIFGenerico2Text1CheckBox1.this.JCHEstadoActionPerformed(evt);
            }
        });
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addComponent(this.JTFCodigo, -2, 121, -2).addGap(18, 18, 18).addComponent(this.JTFNombre, -2, 488, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHEstado).addContainerGap(-1, 32767)));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFCodigo, -2, -1, -2).addComponent(this.JTFNombre, -2, -1, -2).addComponent(this.JCHEstado)).addContainerGap(21, 32767)));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFGenerico2Text1CheckBox1.3
            public void mouseClicked(MouseEvent evt) {
                JIFGenerico2Text1CheckBox1.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JSPDetalle, GroupLayout.Alignment.LEADING, -1, 726, 32767).addComponent(this.JPIDatos, GroupLayout.Alignment.LEADING, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPDetalle, -1, 317, 32767).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEstadoActionPerformed(ActionEvent evt) {
        if (this.xnombre.equals("Tipo Edad")) {
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
            this.JTFCodigo.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
            this.JTFNombre.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString());
            if (!this.xnombre.equals("Tipo Ambito")) {
                this.JCHEstado.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString()).booleanValue());
                if (this.xnombre.equals("Tipo Edad")) {
                    if (this.JCHEstado.isSelected()) {
                        this.xestado = 0;
                        return;
                    } else {
                        this.xestado = 1;
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosing(InternalFrameEvent evt) {
        Principal.mLimpiarDatosP();
    }

    public void mNuevo() {
        Principal.mLimpiarDatosP();
        this.JTFNombre.setText("");
        this.JTFCodigo.setText("");
        this.JCHEstado.setSelected(true);
        this.xestado = 0;
        if (this.xnombre.equals("Tipo Ambito")) {
            this.JCHEstado.setVisible(false);
        }
    }

    public void mGrabar() {
        if (!this.JTFCodigo.getText().isEmpty()) {
            if (!this.JTFNombre.getText().isEmpty()) {
                int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (n == 0) {
                    String sql = null;
                    if (Principal.txtNo.getText().isEmpty()) {
                        if (this.xnombre.equals("Formato Dian")) {
                            sql = " Insert into cc_tipo_formato_dian(Id, Nbre, Estado, UsuarioS)  values ('" + this.JTFCodigo.getText() + "','" + this.JTFNombre.getText().toUpperCase() + "','" + this.xestado + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                        } else if (this.xnombre.equals("Concepto Dian")) {
                            sql = " Insert into cc_tipo_concepto_dian(Id, Nbre, Estado, UsuarioS)  values ('" + this.JTFCodigo.getText() + "','" + this.JTFNombre.getText().toUpperCase() + "','" + this.xestado + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                        } else if (this.xnombre.equals("Ocupación")) {
                            calcularIdPadre();
                            if (this.JCHEstado.isSelected()) {
                                this.xestado = 0;
                            } else {
                                this.xestado = 1;
                            }
                            sql = " Insert into g_ocupacion(Id, Nbre, idPadre ,Nivel ,Estado, Fecha, UsuarioS)  values ('" + this.JTFCodigo.getText() + "','" + this.JTFNombre.getText().toUpperCase() + "','" + this.idPadre + "','" + this.JTFCodigo.getText().length() + "','" + this.xestado + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                        } else if (this.xnombre.equals("Tipo Conceptopagogru")) {
                            if (this.JCHEstado.isSelected()) {
                                this.xestado = 0;
                            } else {
                                this.xestado = 1;
                            }
                            sql = " Insert into f_tipoconceptoagrup(Id, Nbre, Estado, Fecha, UsuarioS)  values ('" + this.JTFCodigo.getText() + "','" + this.JTFNombre.getText().toUpperCase() + "','" + this.xestado + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                        } else if (this.xnombre.equals("Tipo Destino Salida")) {
                            if (this.JCHEstado.isSelected()) {
                                this.xestado = 0;
                            } else {
                                this.xestado = 1;
                            }
                            sql = " Insert into f_tipodestinosalida(Id, Nbre, Estado, Fecha, UsuarioS)  values ('" + this.JTFCodigo.getText() + "','" + this.JTFNombre.getText().toUpperCase() + "','" + this.xestado + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                        } else if (this.xnombre.equals("Etapa Proceso")) {
                            sql = " Insert into g_etapa_proceso(Id, Nbre, Estado, Fecha, UsuarioS)  values ('" + this.JTFCodigo.getText() + "','" + this.JTFNombre.getText().toUpperCase() + "','" + this.xestado + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                        } else if (this.xnombre.equals("Tipo Edad")) {
                            sql = " Insert into g_tipoedad(Id, Nbre, Estado, Fecha, UsuarioS)  values ('" + this.JTFCodigo.getText() + "','" + this.JTFNombre.getText().toUpperCase() + "','" + this.xestado + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                        } else if (this.xnombre.equals("Tipo Ambito")) {
                            sql = " Insert into g_tipoambito(Id, Nbre, Fecha, UsuarioS)  values ('" + this.JTFCodigo.getText() + "','" + this.JTFNombre.getText().toUpperCase() + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                        } else if (this.xnombre.equals("Unidad Minima Dispensacion")) {
                            sql = " Insert into i_unidad_minima_dispensacion(codigo, nombre, estado, usuarioSistema, fecha)  values ('" + this.JTFCodigo.getText() + "','" + this.JTFNombre.getText().toUpperCase() + "','" + this.xestado + "','" + Principal.usuarioSistemaDTO.getLogin() + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "')";
                        }
                    } else if (this.xnombre.equals("Formato Dian")) {
                        if (this.JCHEstado.isSelected()) {
                            this.xestado = 0;
                        } else {
                            this.xestado = 1;
                        }
                        sql = " update cc_tipo_formato_dian set Nbre='" + this.JTFNombre.getText().toUpperCase() + "',Estado='" + this.xestado + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
                    } else if (this.xnombre.equals("Concepto Dian")) {
                        sql = " update cc_tipo_concepto_dian set Nbre='" + this.JTFNombre.getText().toUpperCase() + "',Estado='" + this.xestado + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
                    } else if (this.xnombre.equals("Ocupación")) {
                        calcularIdPadre();
                        if (this.JCHEstado.isSelected()) {
                            this.xestado = 0;
                        } else {
                            this.xestado = 1;
                        }
                        sql = " update g_ocupacion set Nbre='" + this.JTFNombre.getText().toUpperCase() + "',id='" + this.JTFCodigo.getText() + "',idPadre='" + this.idPadre + "',Nivel='" + this.JTFCodigo.getText().length() + "',Estado='" + this.xestado + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
                    } else if (this.xnombre.equals("Tipo Conceptopagogru")) {
                        if (this.JCHEstado.isSelected()) {
                            this.xestado = 0;
                        } else {
                            this.xestado = 1;
                        }
                        sql = " update f_tipoconceptoagrup set Nbre='" + this.JTFNombre.getText().toUpperCase() + "',Estado='" + this.xestado + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
                    } else if (this.xnombre.equals("Tipo Destino Salida")) {
                        if (this.JCHEstado.isSelected()) {
                            this.xestado = 0;
                        } else {
                            this.xestado = 1;
                        }
                        sql = " update f_tipodestinosalida set Nbre='" + this.JTFNombre.getText().toUpperCase() + "',Estado='" + this.xestado + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
                    } else if (this.xnombre.equals("Etapa Proceso")) {
                        sql = " update g_etapa_proceso set Nbre='" + this.JTFNombre.getText().toUpperCase() + "',Estado='" + this.xestado + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
                    } else if (this.xnombre.equals("Tipo Edad")) {
                        sql = " update g_tipoedad set Nbre='" + this.JTFNombre.getText().toUpperCase() + "',Estado='" + this.xestado + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
                    } else if (this.xnombre.equals("Tipo Ambito")) {
                        sql = " update g_tipoambito set Nbre='" + this.JTFNombre.getText().toUpperCase() + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
                    } else if (this.xnombre.equals("Unidad Minima Dispensacion")) {
                        sql = " update `i_unidad_minima_dispensacion` set nombre='" + this.JTFNombre.getText().toUpperCase() + "',estado='" + this.xestado + "', fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioSistemaActualizacion='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
                    }
                    System.out.println(sql);
                    this.xconsulta.ejecutarSQL(sql);
                    this.xconsulta.cerrarConexionBd();
                    mCargarDatosTabla();
                    mNuevo();
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "El campo nombre no puede ser nulo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JTFNombre.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "El campo código no puede ser nulo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTFCodigo.requestFocus();
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        if (this.xnombre.equals("Unidad Minima Dispensacion")) {
            this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Codigo", "Nombre", "Estado"}) { // from class: ParametrizacionN.JIFGenerico2Text1CheckBox1.4
                Class[] types = {Long.class, String.class, Boolean.class};
                boolean[] canEdit = {false, false, false};

                public Class getColumnClass(int columnIndex) {
                    return this.types[columnIndex];
                }

                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return this.canEdit[columnIndex];
                }
            };
        } else {
            this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Nombre", "Estado"}) { // from class: ParametrizacionN.JIFGenerico2Text1CheckBox1.5
                Class[] types = {Long.class, String.class, Boolean.class};
                boolean[] canEdit = {false, false, false};

                public Class getColumnClass(int columnIndex) {
                    return this.types[columnIndex];
                }

                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return this.canEdit[columnIndex];
                }
            };
        }
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(400);
        if (this.xnombre.equals("Tipo Ambito")) {
            this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(0);
            this.JTDetalle.getColumnModel().getColumn(2).setMinWidth(0);
            this.JTDetalle.getColumnModel().getColumn(2).setMaxWidth(0);
            return;
        }
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(30);
    }

    private void mCargarDatosTabla() {
        try {
            mCrearModeloDatos();
            String sql = null;
            if (this.xnombre.equals("Formato Dian")) {
                sql = "SELECT Id, Nbre, Estado FROM cc_tipo_formato_dian ORDER BY Nbre ASC";
            } else if (this.xnombre.equals("Concepto Dian")) {
                sql = "SELECT Id, Nbre, Estado FROM cc_tipo_concepto_dian ORDER BY Nbre ASC";
            } else if (this.xnombre.equals("Ocupación")) {
                sql = "SELECT Id, Nbre, Estado FROM g_ocupacion ORDER BY Nbre ASC";
            } else if (this.xnombre.equals("Tipo Conceptopagogru")) {
                sql = "SELECT Id, Nbre, Estado FROM f_tipoconceptoagrup ORDER BY Id ASC";
            } else if (this.xnombre.equals("Tipo Destino Salida")) {
                sql = "SELECT Id, Nbre, Estado FROM f_tipodestinosalida ORDER BY Id ASC";
            } else if (this.xnombre.equals("Etapa Proceso")) {
                sql = "SELECT Id, Nbre, Estado FROM g_etapa_proceso ORDER BY Id ASC";
            } else if (this.xnombre.equals("Tipo Edad")) {
                sql = "SELECT Id, Nbre, Estado FROM g_tipoedad ORDER BY Id ASC";
            } else if (this.xnombre.equals("Tipo Ambito")) {
                sql = "SELECT Id, Nbre, 0 FROM g_tipoambito ORDER BY Id ASC";
            } else if (this.xnombre.equals("Unidad Minima Dispensacion")) {
                sql = "SELECT codigo, nombre, estado FROM `i_unidad_minima_dispensacion` ORDER BY Id ASC";
            }
            ResultSet xrs = this.xconsulta.traerRs(sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(xrs.getString(1), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    if (this.xnombre.equals("Etapa Proceso") || this.xnombre.equals("Unidad Minima Dispensacion")) {
                        this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(3)), n, 2);
                    } else {
                        this.xmodelo.setValueAt(Boolean.valueOf(!xrs.getBoolean(3)), n, 2);
                    }
                    n++;
                }
            }
            xrs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFGenerico2Text1CheckBox1.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void calcularIdPadre() {
        this.idPadre = this.JTFCodigo.getText();
        if (this.idPadre.length() > 1) {
            this.idPadre = this.idPadre.substring(0, this.idPadre.length() - 1);
        } else if (this.idPadre.length() == 1) {
            this.idPadre = "-1";
        }
    }
}
