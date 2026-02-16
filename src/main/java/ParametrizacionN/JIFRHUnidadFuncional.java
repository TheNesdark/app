package ParametrizacionN;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:ParametrizacionN/JIFRHUnidadFuncional.class */
public class JIFRHUnidadFuncional extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private Object[] xdatos;
    private String xsql;
    private JCheckBox JCHEstado;
    private JPanel JPIDatosP;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;
    private JTextField JTFCuentaPuc;
    private JTextField JTFNDocumento;
    private JTextField JTFNPersonaC;
    private JTextField JTFNUnificacion;
    private JTextField JTFNombre;
    private JButton jButton1;
    private ConsultasMySQL xct = new ConsultasMySQL();
    private Metodos xmt = new Metodos();
    private int xestado = 1;
    private long xidusuario = 0;

    public JIFRHUnidadFuncional() {
        initComponents();
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v41, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPIDatosP = new JPanel();
        this.JTFNUnificacion = new JTextField();
        this.JCHEstado = new JCheckBox();
        this.JTFNDocumento = new JTextField();
        this.JTFNPersonaC = new JTextField();
        this.JTFCuentaPuc = new JTextField();
        this.jButton1 = new JButton();
        this.JTFNombre = new JTextField();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        setClosable(true);
        setForeground(Color.white);
        setIconifiable(true);
        setTitle("UNIDAD FUNCIONAL");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifunidadfuncional");
        this.JPIDatosP.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTFNUnificacion.setFont(new Font("Arial", 1, 12));
        this.JTFNUnificacion.setToolTipText("");
        this.JTFNUnificacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre Unificación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setSelected(true);
        this.JCHEstado.setText("Estado");
        this.JCHEstado.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFRHUnidadFuncional.1
            public void actionPerformed(ActionEvent evt) {
                JIFRHUnidadFuncional.this.JCHEstadoActionPerformed(evt);
            }
        });
        this.JTFNDocumento.setFont(new Font("Arial", 1, 12));
        this.JTFNDocumento.setToolTipText("");
        this.JTFNDocumento.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Documento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFNDocumento.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFRHUnidadFuncional.2
            public void actionPerformed(ActionEvent evt) {
                JIFRHUnidadFuncional.this.JTFNDocumentoActionPerformed(evt);
            }
        });
        this.JTFNDocumento.addFocusListener(new FocusAdapter() { // from class: ParametrizacionN.JIFRHUnidadFuncional.3
            public void focusLost(FocusEvent evt) {
                JIFRHUnidadFuncional.this.JTFNDocumentoFocusLost(evt);
            }
        });
        this.JTFNPersonaC.setFont(new Font("Arial", 1, 12));
        this.JTFNPersonaC.setToolTipText("");
        this.JTFNPersonaC.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre Persona a Cargo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFCuentaPuc.setFont(new Font("Arial", 1, 12));
        this.JTFCuentaPuc.setToolTipText("");
        this.JTFCuentaPuc.setBorder(BorderFactory.createTitledBorder((Border) null, "Cuenta Puc (Grupo)", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jButton1.setFont(new Font("Arial", 1, 12));
        this.jButton1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.jButton1.setText("Agregar Cargos");
        this.jButton1.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFRHUnidadFuncional.4
            public void actionPerformed(ActionEvent evt) {
                JIFRHUnidadFuncional.this.jButton1ActionPerformed(evt);
            }
        });
        this.JTFNombre.setFont(new Font("Arial", 1, 12));
        this.JTFNombre.setToolTipText("");
        this.JTFNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPIDatosPLayout = new GroupLayout(this.JPIDatosP);
        this.JPIDatosP.setLayout(JPIDatosPLayout);
        JPIDatosPLayout.setHorizontalGroup(JPIDatosPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosPLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosPLayout.createSequentialGroup().addComponent(this.JTFNDocumento, -2, 114, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFNPersonaC, -2, 364, -2).addGap(11, 11, 11).addComponent(this.JCHEstado, -1, 69, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jButton1)).addGroup(JPIDatosPLayout.createSequentialGroup().addComponent(this.JTFNombre).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFNUnificacion, -2, 247, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFCuentaPuc, -2, 137, -2))).addContainerGap()));
        JPIDatosPLayout.setVerticalGroup(JPIDatosPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosPLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosPLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFNUnificacion, -2, -1, -2).addComponent(this.JTFCuentaPuc, -2, -1, -2).addComponent(this.JTFNombre, -2, -1, -2)).addGap(18, 18, 18).addGroup(JPIDatosPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jButton1, -2, 50, -2).addGroup(JPIDatosPLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTFNDocumento).addGroup(JPIDatosPLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFNPersonaC).addComponent(this.JCHEstado)))).addContainerGap(18, 32767)));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalle.setSelectionMode(0);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFRHUnidadFuncional.5
            public void mouseClicked(MouseEvent evt) {
                JIFRHUnidadFuncional.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPIDatosP, -1, -1, 32767).addComponent(this.JSPDetalle, -1, 757, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatosP, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalle, -1, 253, 32767).addContainerGap()));
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
            Principal.txtNo.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
            this.JTFNombre.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString());
            this.JTFNDocumento.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 5).toString());
            this.JTFNPersonaC.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString());
            this.JTFCuentaPuc.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString());
            this.JCHEstado.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 4).toString()).booleanValue());
            if (Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 4).toString()).booleanValue()) {
                this.xestado = 1;
            } else {
                this.xestado = 0;
            }
            this.xidusuario = Long.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 6).toString()).longValue();
            this.JTFNUnificacion.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 7).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNDocumentoFocusLost(FocusEvent evt) {
        mBuscarPersona();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNDocumentoActionPerformed(ActionEvent evt) {
        this.JTFNDocumento.transferFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jButton1ActionPerformed(ActionEvent evt) {
        if (!Principal.txtNo.getText().isEmpty()) {
            Principal.claseparametrizacionn.cargarPantalla("Cargos UnidadF");
        } else {
            JOptionPane.showInternalMessageDialog(this, "Debe Seleccionar un registro", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTDetalle.requestFocus();
        }
    }

    public void mNuevo() {
        Principal.mLimpiarDatosP();
        this.JTFNombre.setText("");
        this.JTFNUnificacion.setText("");
        this.JTFNDocumento.setText("");
        this.JTFNPersonaC.setText("");
        this.JTFCuentaPuc.setText("");
        this.JCHEstado.setSelected(true);
        this.xestado = 1;
        this.xidusuario = 0L;
        mCargarDatosTabla();
        this.JTFNombre.requestFocus();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos(String[] xcabecera) {
        this.xmodelo = new DefaultTableModel(new Object[0], xcabecera) { // from class: ParametrizacionN.JIFRHUnidadFuncional.6
            Class[] types = {Long.class, String.class, String.class, String.class, Boolean.class, String.class, Long.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false};

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
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(5).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(5).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(6).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(6).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(7).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(7).setMaxWidth(0);
    }

    private void mCargarDatosTabla() {
        try {
            String[] xencabezado = {"Id", "Unidad", "Persona a Cargo", "Puc (Grupo)", "Estado", "NDocumento", "IdPersona", "NUnificacion"};
            mCrearModeloDatos(xencabezado);
            ResultSet xrs = this.xct.traerRs("SELECT rh_unidad_funcional.Id, rh_unidad_funcional.Nbre, persona.NUsuario, rh_unidad_funcional.PucGrupo, rh_unidad_funcional.Estado, persona.NoDocumento, persona.Id_Persona, rh_unidad_funcional.NUnificacion FROM persona INNER JOIN rh_unidad_funcional  ON (persona.Id_persona = rh_unidad_funcional.Id_Persona) ORDER BY rh_unidad_funcional.Nbre ASC");
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(1)), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelo.setValueAt(xrs.getString(4), n, 3);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(5)), n, 4);
                    this.xmodelo.setValueAt(xrs.getString(6), n, 5);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(7)), n, 6);
                    this.xmodelo.setValueAt(xrs.getString(8), n, 7);
                    n++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFRHUnidadFuncional.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mBuscarPersona() {
        if (!this.JTFNDocumento.getText().isEmpty()) {
            try {
                this.xsql = "SELECT Id_persona, NUsuario, NoDocumento FROM persona WHERE (NoDocumento ='" + this.JTFNDocumento.getText() + "') ";
                ResultSet xrs = this.xct.traerRs(this.xsql);
                if (xrs.next()) {
                    xrs.first();
                    this.xidusuario = xrs.getLong(1);
                    this.JTFNPersonaC.setText(xrs.getString(2));
                } else {
                    this.xidusuario = 0L;
                    this.JTFNPersonaC.setText("");
                }
                xrs.close();
                this.xct.cerrarConexionBd();
            } catch (SQLException ex) {
                Logger.getLogger(JIFRHUnidadFuncional.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        }
    }

    public void mGrabar() {
        if (this.JTFNombre.getText().isEmpty()) {
            JOptionPane.showInternalMessageDialog(this, "El nombre no puede ser nulo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTFNombre.requestFocus();
            return;
        }
        if (this.xidusuario != 0) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                if (Principal.txtNo.getText().isEmpty()) {
                    this.xsql = "insert into rh_unidad_funcional(Nbre, Id_Persona, PucGrupo, NUnificacion, Estado, Fecha, UsuarioS) values ('" + this.JTFNombre.getText().toUpperCase() + "','" + this.xidusuario + "','" + this.JTFCuentaPuc.getText() + "','" + this.JTFNUnificacion.getText().toUpperCase() + "','" + this.xestado + "','" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                } else {
                    this.xsql = "update rh_unidad_funcional set Nbre='" + this.JTFNombre.getText().toUpperCase() + "', Id_Persona='" + this.xidusuario + "', PucGrupo='" + this.JTFCuentaPuc.getText() + "', NUnificacion='" + this.JTFNUnificacion.getText().toUpperCase() + "', Estado='" + this.xestado + "', Fecha='" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' where Id='" + Principal.txtNo.getText() + "'";
                }
                this.xct.ejecutarSQL(this.xsql);
                this.xct.cerrarConexionBd();
                mNuevo();
                return;
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una persona a cargo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JTFNPersonaC.requestFocus();
    }
}
