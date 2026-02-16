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

/* JADX INFO: loaded from: GenomaP.jar:ParametrizacionN/JIFGenericoCh.class */
public class JIFGenericoCh extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private Object[] xdatos;
    private String xnombre;
    private String xid;
    private JCheckBox JCHEstado;
    private JCheckBox JCHGenerico;
    private JPanel JPIDatos;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;
    private JTextField JTFNombre;
    private ConsultasMySQL xconsulta = new ConsultasMySQL();
    private Metodos xmetodos = new Metodos();
    private int xestado = 0;
    private int xeschgenerico = 0;
    private boolean xestadog = false;

    public JIFGenericoCh(String xnombre, String xtitulo) {
        initComponents();
        setTitle(xtitulo);
        setName(xnombre);
        this.xnombre = xnombre;
        mIniciarComponentes();
        mCargarDatosTabla();
    }

    /* JADX WARN: Type inference failed for: r3v28, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPIDatos = new JPanel();
        this.JTFNombre = new JTextField();
        this.JCHEstado = new JCheckBox();
        this.JCHGenerico = new JCheckBox();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("GENERICO");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifestrato");
        try {
            setSelected(true);
        } catch (PropertyVetoException e1) {
            e1.printStackTrace();
        }
        addInternalFrameListener(new InternalFrameListener() { // from class: ParametrizacionN.JIFGenericoCh.1
            public void internalFrameClosed(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                JIFGenericoCh.this.formInternalFrameClosing(evt);
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
        this.JTFNombre.setFont(new Font("Arial", 1, 12));
        this.JTFNombre.setToolTipText("");
        this.JTFNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setSelected(true);
        this.JCHEstado.setText("Estado");
        this.JCHEstado.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFGenericoCh.2
            public void actionPerformed(ActionEvent evt) {
                JIFGenericoCh.this.JCHEstadoActionPerformed(evt);
            }
        });
        this.JCHGenerico.setFont(new Font("Arial", 1, 12));
        this.JCHGenerico.setSelected(true);
        this.JCHGenerico.setText("Es Convencionado?");
        this.JCHGenerico.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFGenericoCh.3
            public void actionPerformed(ActionEvent evt) {
                JIFGenericoCh.this.JCHGenericoActionPerformed(evt);
            }
        });
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosLayout.createSequentialGroup().addComponent(this.JTFNombre, -2, 379, -2).addGap(18, 18, 18).addComponent(this.JCHGenerico).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 4, 32767).addComponent(this.JCHEstado).addContainerGap()));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCHEstado).addComponent(this.JTFNombre, -2, -1, -2).addComponent(this.JCHGenerico)).addContainerGap(21, 32767)));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalle.setSelectionMode(0);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFGenericoCh.4
            public void mouseClicked(MouseEvent evt) {
                JIFGenericoCh.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JSPDetalle, GroupLayout.Alignment.LEADING, -1, 625, 32767).addComponent(this.JPIDatos, GroupLayout.Alignment.LEADING, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPDetalle, -1, 329, 32767).addContainerGap()));
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
            this.JTFNombre.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString());
            this.JCHEstado.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString()).booleanValue());
            if (this.xnombre.equals("xjiftipoalerta")) {
                if (this.JCHEstado.isSelected()) {
                    this.xestado = 1;
                } else {
                    this.xestado = 0;
                }
            } else if (this.JCHEstado.isSelected()) {
                this.xestado = 0;
            } else {
                this.xestado = 1;
            }
            this.JCHGenerico.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString()).booleanValue());
            if (this.JCHGenerico.isSelected()) {
                this.xeschgenerico = 1;
            } else {
                this.xeschgenerico = 0;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHGenericoActionPerformed(ActionEvent evt) {
        if (this.JCHGenerico.isSelected()) {
            this.xeschgenerico = 1;
        } else {
            this.xeschgenerico = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosing(InternalFrameEvent evt) {
        Principal.mLimpiarDatosP();
    }

    public void mNuevo() {
        Principal.txtNo.setText("");
        this.JTFNombre.setText("");
        this.JCHEstado.setSelected(true);
        if (this.xnombre.equals("xjiftipoalerta")) {
            this.xestado = 0;
        } else {
            this.xestado = 1;
        }
        this.xestado = 0;
        this.xeschgenerico = 0;
        this.JCHGenerico.setSelected(false);
        mCargarDatosTabla();
    }

    public void mGrabar() {
        if (!this.JTFNombre.getText().isEmpty()) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                String sql = null;
                if (Principal.txtNo.getText().isEmpty()) {
                    if (this.xnombre.equals("jifgrupofactura")) {
                        String sql2 = " Insert into f_gruposervicio(Nbre, ConSubGrupo, Estado, Fecha, UsuarioS)  values ('" + this.JTFNombre.getText().toUpperCase() + "','" + this.xeschgenerico + "','" + this.xestado + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                        String xidgrupo = this.xconsulta.ejecutarSQLId(sql2);
                        this.xconsulta.cerrarConexionBd();
                        if (!this.JCHGenerico.isSelected()) {
                            String sql3 = " Insert into f_subgruposervicio(Nbre, Id_GrupoServicio, EsGrupo, Fecha, UsuarioS)  values ('" + this.JTFNombre.getText().toUpperCase() + "','" + xidgrupo + "','0','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                            this.xconsulta.ejecutarSQL(sql3);
                            this.xconsulta.cerrarConexionBd();
                        }
                    } else if (this.xnombre.equals("jiftiposervicio")) {
                        String sql4 = " Insert into f_tiposervicio(Nbre, EsConsulta, Estado, Fecha, UsuarioS)  values ('" + this.JTFNombre.getText().toUpperCase() + "','" + this.xeschgenerico + "','" + this.xestado + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                        this.xconsulta.ejecutarSQL(sql4);
                        this.xconsulta.cerrarConexionBd();
                    } else if (this.xnombre.equals("jifmanualtarifas")) {
                        String sql5 = " Insert into f_manual(Nbre, Id_TipoManQx, Estado, Fecha, UsuarioS)  values ('" + this.JTFNombre.getText().toUpperCase() + "','" + this.xeschgenerico + "','" + this.xestado + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                        this.xconsulta.ejecutarSQL(sql5);
                        this.xconsulta.cerrarConexionBd();
                    } else if (this.xnombre.equals("xjifareas")) {
                        String sql6 = " Insert into g_areas(Nbre, AplicaEncuentas, Estado, Fecha, UsuarioS)  values ('" + this.JTFNombre.getText().toUpperCase() + "','" + this.xeschgenerico + "','" + this.xestado + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                        this.xconsulta.ejecutarSQL(sql6);
                        this.xconsulta.cerrarConexionBd();
                    } else if (this.xnombre.equals("xjiftipoalerta")) {
                        if (this.JCHEstado.isSelected()) {
                            this.xestado = 1;
                        } else {
                            this.xestado = 0;
                        }
                        String sql7 = " Insert into g_tipoalerta(Nbre, EsHC, Estado, Fecha, UsuarioS)  values ('" + this.JTFNombre.getText().toUpperCase() + "','" + this.xeschgenerico + "','" + this.xestado + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                        this.xconsulta.ejecutarSQL(sql7);
                        this.xconsulta.cerrarConexionBd();
                    }
                } else {
                    if (this.xnombre.equals("jifgrupofactura")) {
                        sql = " update f_gruposervicio set Nbre='" + this.JTFNombre.getText().toUpperCase() + "',ConSubGrupo='" + this.xeschgenerico + "',Estado='" + this.xestado + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id_GrupoServicio='" + Principal.txtNo.getText() + "'";
                    } else if (this.xnombre.equals("jiftiposervicio")) {
                        sql = " update f_tiposervicio set Nbre='" + this.JTFNombre.getText().toUpperCase() + "',EsConsulta='" + this.xeschgenerico + "',Estado='" + this.xestado + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
                    } else if (this.xnombre.equals("jifmanualtarifas")) {
                        sql = " update f_manual set Nbre='" + this.JTFNombre.getText().toUpperCase() + "',Id_TipoManQx='" + this.xeschgenerico + "',Estado='" + this.xestado + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
                    } else if (this.xnombre.equals("xjifareas")) {
                        sql = " update g_areas set Nbre='" + this.JTFNombre.getText().toUpperCase() + "',AplicaEncuentas='" + this.xeschgenerico + "',Estado='" + this.xestado + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
                    } else if (this.xnombre.equals("xjiftipoalerta")) {
                        if (this.JCHEstado.isSelected()) {
                            this.xestado = 1;
                        } else {
                            this.xestado = 0;
                        }
                        sql = " update g_tipoalerta set Nbre='" + this.JTFNombre.getText().toUpperCase() + "',EsHC='" + this.xeschgenerico + "',Estado='" + this.xestado + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
                    }
                    this.xconsulta.ejecutarSQL(sql);
                    this.xconsulta.cerrarConexionBd();
                }
                mCargarDatosTabla();
                mNuevo();
                return;
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "El campo nombre no puede ser nulo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JTFNombre.requestFocus();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos(String[] xcabecera) {
        this.xmodelo = new DefaultTableModel(new Object[0], xcabecera) { // from class: ParametrizacionN.JIFGenericoCh.5
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
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(30);
    }

    private void mCargarDatosTabla() {
        try {
            String sql = null;
            String[] xencabezado = null;
            if (this.xnombre.equals("jifgrupofactura")) {
                xencabezado = new String[]{"Id", "Nombre", "SubGrupo?", "Estado"};
                sql = "SELECT Id_GrupoServicio, Nbre, ConSubGrupo, Estado FROM baseserver.f_gruposervicio ORDER BY Nbre ASC";
            } else if (this.xnombre.equals("jiftiposervicio")) {
                xencabezado = new String[]{"Id", "Nombre", "Es Consulta?", "Estado"};
                sql = "SELECT Id, Nbre, EsConsulta, Estado FROM baseserver.f_tiposervicio ORDER BY Nbre ASC";
            } else if (this.xnombre.equals("jifmanualtarifas")) {
                xencabezado = new String[]{"Id", "Nombre", "Es Qx?", "Estado"};
                sql = "SELECT Id, Nbre, Id_TipoManQx, Estado FROM baseserver.f_manual ORDER BY Nbre ASC";
            } else if (this.xnombre.equals("xjifareas")) {
                xencabezado = new String[]{"Id", "Nombre", "Encuesta?", "Estado"};
                sql = "SELECT Id, Nbre, AplicaEncuentas, Estado FROM g_areas ORDER BY Nbre ASC";
            } else if (this.xnombre.equals("xjiftipoalerta")) {
                xencabezado = new String[]{"Id", "Nombre", "EsHC?", "Estado"};
                sql = "SELECT Id, Nbre, EsHC, Estado FROM g_tipoalerta ORDER BY Nbre ASC";
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
                    this.xmodelo.setValueAt(Boolean.valueOf(!xrs.getBoolean(4)), n, 3);
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
        if (this.xnombre.equals("jifgrupofactura")) {
            this.JCHGenerico.setText("SubGrupo?");
            return;
        }
        if (this.xnombre.equals("jiftiposervicio")) {
            this.JCHGenerico.setText("Es Consulta?");
            return;
        }
        if (this.xnombre.equals("jifmanualtarifas")) {
            this.JCHGenerico.setText("Es Qx?");
        } else if (this.xnombre.equals("xjifareas")) {
            this.JCHGenerico.setText("Aplica Encuesta?");
        } else if (this.xnombre.equals("xjiftipoalerta")) {
            this.JCHGenerico.setText("Es HC?");
        }
    }
}
