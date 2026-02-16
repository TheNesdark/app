package ParametrizacionN;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
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
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:ParametrizacionN/JIFTipoEncuesta.class */
public class JIFTipoEncuesta extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private Object[] xdatos;
    private String xnombre;
    private JIFSSuministro xjifsuministro;
    private String[] xidtipop;
    public String[][] xidtiposolicitud;
    public String[][] xidproceso;
    private JComboBox JCBProceso;
    private JComboBox JCBTProceso;
    private JCheckBox JCHEstado;
    private JDateChooser JDFecha;
    private JPanel JPIDatos;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;
    private JTextField JTFNombre;
    private ConsultasMySQL xct = new ConsultasMySQL();
    private Metodos xmt = new Metodos();
    private int xestado = 0;
    private String xid = "";
    private boolean xestadog = false;
    private boolean xlleno = false;
    private boolean xlleno1 = false;

    public JIFTipoEncuesta() {
        initComponents();
        mCargarDatosTabla();
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v32, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPIDatos = new JPanel();
        this.JTFNombre = new JTextField();
        this.JCHEstado = new JCheckBox();
        this.JCBTProceso = new JComboBox();
        this.JCBProceso = new JComboBox();
        this.JDFecha = new JDateChooser();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("TIPO DE ENCUESTA");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifgenerico1chbox");
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
        this.JCHEstado.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFTipoEncuesta.1
            public void actionPerformed(ActionEvent evt) {
                JIFTipoEncuesta.this.JCHEstadoActionPerformed(evt);
            }
        });
        this.JCBTProceso.setFont(new Font("Arial", 1, 12));
        this.JCBTProceso.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Proceso", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTProceso.addItemListener(new ItemListener() { // from class: ParametrizacionN.JIFTipoEncuesta.2
            public void itemStateChanged(ItemEvent evt) {
                JIFTipoEncuesta.this.JCBTProcesoItemStateChanged(evt);
            }
        });
        this.JCBProceso.setFont(new Font("Arial", 1, 12));
        this.JCBProceso.setBorder(BorderFactory.createTitledBorder((Border) null, "Proceso", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFecha.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Cierre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFecha.setDateFormatString("dd/MM/yyyy");
        this.JDFecha.setFont(new Font("Arial", 1, 12));
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosLayout.createSequentialGroup().addComponent(this.JTFNombre, -2, 583, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JDFecha, -2, 120, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHEstado)).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JCBTProceso, -2, 236, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBProceso, -2, 466, -2))).addContainerGap()));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFNombre, -2, -1, -2).addComponent(this.JCHEstado)).addComponent(this.JDFecha, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBTProceso, -2, -1, -2).addComponent(this.JCBProceso, -2, -1, -2)).addContainerGap(-1, 32767)));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalle.setSelectionMode(0);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFTipoEncuesta.3
            public void mouseClicked(MouseEvent evt) {
                JIFTipoEncuesta.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JSPDetalle, GroupLayout.Alignment.LEADING, -1, 808, 32767).addComponent(this.JPIDatos, GroupLayout.Alignment.LEADING, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalle, -1, 281, 32767).addContainerGap()));
        pack();
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
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            if (!this.xnombre.equals("Presentación Comercial") && !this.xnombre.equals("Concentración") && !this.xnombre.equals("Laboratorio")) {
                Principal.txtNo.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
            } else {
                this.xid = this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString();
            }
            this.JTFNombre.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString());
            this.JCHEstado.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString()).booleanValue());
            if (this.JCHEstado.isSelected()) {
                this.xestado = 0;
            } else {
                this.xestado = 1;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBTProcesoItemStateChanged(ItemEvent evt) {
        if (this.xlleno && this.JCBTProceso.getSelectedIndex() != -1) {
            ConsultasMySQL xct1 = new ConsultasMySQL();
            this.JCBProceso.removeAllItems();
            this.xidproceso = xct1.llenarComboyLista("SELECT Id, Nbre, correo FROM s_sgc_tipoproceso WHERE (Id_Proceso ='" + this.xidtipop[this.JCBTProceso.getSelectedIndex()] + "' AND Estado =1) ORDER BY Nbre ASC", this.xidproceso, this.JCBProceso, 3);
            this.JCBProceso.setSelectedIndex(-1);
            xct1.cerrarConexionBd();
            this.xlleno1 = true;
        }
    }

    public void mNuevo() {
        Principal.mLimpiarDatosP();
        this.JTFNombre.setText("");
        this.JCHEstado.setSelected(true);
        this.xestado = 1;
        this.xlleno = false;
        this.xlleno1 = false;
        this.JDFecha.setDate(this.xmt.getFechaActual());
        this.JCBProceso.removeAllItems();
        this.JCBTProceso.removeAllItems();
        this.xidtipop = this.xct.llenarCombo("SELECT Id , Nbre FROM s_sgc_procesos WHERE (Estado =1) ORDER BY Nbre ASC", this.xidtipop, this.JCBTProceso);
        this.JCBTProceso.setSelectedIndex(-1);
        this.xlleno = true;
        this.xct.cerrarConexionBd();
    }

    public void mGrabar() {
        if (!this.JTFNombre.getText().isEmpty()) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                String sql = null;
                if (!this.xnombre.equals("Presentación Comercial") && !this.xnombre.equals("Concentración") && !this.xnombre.equals("Laboratorio")) {
                    if (Principal.txtNo.getText().isEmpty()) {
                        if (this.xnombre.equals("Tipo de Plan")) {
                            sql = " Insert into f_tipoplan(Nbre, Estado, Fecha, UsuarioS)  values ('" + this.JTFNombre.getText().toUpperCase() + "','" + this.xestado + "','" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                        } else if (this.xnombre.equals("Tipo de Régimen")) {
                            sql = " Insert into f_tiporegimen(Nbre, Estado, Fecha, UsuarioS)  values ('" + this.JTFNombre.getText().toUpperCase() + "','" + this.xestado + "','" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                        } else if (this.xnombre.equals("Tipo Cita")) {
                            sql = " Insert into c_tipocita(Nbre, Estado, Fecha, UsuarioS)  values ('" + this.JTFNombre.getText().toUpperCase() + "','" + this.xestado + "','" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                        } else if (this.xnombre.equals("Motivo de Anulación")) {
                            sql = " Insert into c_motivodesistida(Nbre, Estado, Fecha, UsuarioS)  values ('" + this.JTFNombre.getText().toUpperCase() + "','" + this.xestado + "','" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                        } else if (this.xnombre.equals("Concepto Anticipo")) {
                            sql = " Insert into cc_concepto_anticipos(Nbre, Estado, Fecha, UsuarioS)  values ('" + this.JTFNombre.getText().toUpperCase() + "','" + this.xestado + "','" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                        } else if (this.xnombre.equals("Causa de Daño")) {
                            sql = " Insert into g_tipo_causadañoplacas(Nbre, Estado, Fecha, UsuarioS)  values ('" + this.JTFNombre.getText().toUpperCase() + "','" + this.xestado + "','" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                        } else if (this.xnombre.equals("Tipo Placa")) {
                            sql = " Insert into g_tipo_placasrx(Nbre, Estado, Fecha, UsuarioS)  values ('" + this.JTFNombre.getText().toUpperCase() + "','" + this.xestado + "','" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                        } else if (this.xnombre.equals("Tipo Encuesta")) {
                            sql = " Insert into t_etipo_encuestas(Nbre, Estado, Fecha, UsuarioS)  values ('" + this.JTFNombre.getText().toUpperCase() + "','" + this.xestado + "','" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                        }
                    } else if (this.xnombre.equals("Tipo de Plan")) {
                        sql = " update f_tipoplan set Nbre='" + this.JTFNombre.getText().toUpperCase() + "',Estado='" + this.xestado + "', Fecha='" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
                    } else if (this.xnombre.equals("Tipo de Régimen")) {
                        sql = " update f_tiporegimen set Nbre='" + this.JTFNombre.getText().toUpperCase() + "',Estado='" + this.xestado + "', Fecha='" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
                    } else if (this.xnombre.equals("Tipo Cita")) {
                        sql = " update c_tipocita set Nbre='" + this.JTFNombre.getText().toUpperCase() + "',Estado='" + this.xestado + "', Fecha='" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
                    } else if (this.xnombre.equals("Motivo de Anulación")) {
                        sql = " update c_motivodesistida set Nbre='" + this.JTFNombre.getText().toUpperCase() + "',Estado='" + this.xestado + "', Fecha='" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
                    } else if (this.xnombre.equals("Concepto Anticipo")) {
                        sql = " update cc_concepto_anticipos set Nbre='" + this.JTFNombre.getText().toUpperCase() + "',Estado='" + this.xestado + "', Fecha='" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
                    } else if (this.xnombre.equals("Causa de Daño")) {
                        sql = " update g_tipo_causadañoplacas set Nbre='" + this.JTFNombre.getText().toUpperCase() + "',Estado='" + this.xestado + "', Fecha='" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
                    } else if (this.xnombre.equals("Tipo Placa")) {
                        sql = " update g_tipo_placasrx set Nbre='" + this.JTFNombre.getText().toUpperCase() + "',Estado='" + this.xestado + "', Fecha='" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
                    } else if (this.xnombre.equals("Tipo Encuesta")) {
                        sql = " update t_etipo_encuestas set Nbre='" + this.JTFNombre.getText().toUpperCase() + "',Estado='" + this.xestado + "', Fecha='" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
                    }
                    this.xct.ejecutarSQL(sql);
                    this.xct.cerrarConexionBd();
                    mCargarDatosTabla();
                    return;
                }
                if (this.xid.isEmpty()) {
                    if (this.xnombre.equals("Presentación Comercial")) {
                        sql = " Insert into i_presentacioncomercial(Nbre, Estado, Fecha, UsuarioS)  values ('" + this.JTFNombre.getText().toUpperCase() + "','" + this.xestado + "','" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                    } else if (this.xnombre.equals("Concentración")) {
                        sql = " Insert into i_concentracion(Nbre, Estado, Fecha, UsuarioS)  values ('" + this.JTFNombre.getText().toUpperCase() + "','" + this.xestado + "','" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                    } else if (this.xnombre.equals("Laboratorio")) {
                        sql = " Insert into i_laboratorio(Nbre, Estado, Fecha, UsuarioS)  values ('" + this.JTFNombre.getText().toUpperCase() + "','" + this.xestado + "','" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                    }
                } else if (this.xnombre.equals("Presentación Comercial")) {
                    sql = " update i_presentacioncomercial set Nbre='" + this.JTFNombre.getText().toUpperCase() + "',Estado='" + this.xestado + "', Fecha='" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + this.xid + "'";
                } else if (this.xnombre.equals("Concentración")) {
                    sql = " update i_concentracion set Nbre='" + this.JTFNombre.getText().toUpperCase() + "',Estado='" + this.xestado + "', Fecha='" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + this.xid + "'";
                } else if (this.xnombre.equals("Laboratorio")) {
                    sql = " update i_laboratorio set Nbre='" + this.JTFNombre.getText().toUpperCase() + "',Estado='" + this.xestado + "', Fecha='" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + this.xid + "'";
                }
                this.xct.ejecutarSQL(sql);
                this.xct.cerrarConexionBd();
                mCargarDatosTabla();
                return;
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "El campo nombre no puede ser nulo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JTFNombre.requestFocus();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Nombre", "Estado"}) { // from class: ParametrizacionN.JIFTipoEncuesta.4
            Class[] types = {Long.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, false};

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
    }

    private void mCargarDatosTabla() {
        try {
            mCrearModeloDatos();
            ResultSet xrs = this.xct.traerRs("SELECT Id, Nbre, Estado FROM t_etipo_encuestas ORDER BY Nbre ASC");
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(xrs.getString(1), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt(Boolean.valueOf(!xrs.getBoolean(3)), n, 2);
                    n++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFTipoEncuesta.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }
}
