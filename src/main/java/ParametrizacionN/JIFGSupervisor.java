package ParametrizacionN;

import Acceso.Principal;
import General.BuscarPersona;
import General.Persona;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:ParametrizacionN/JIFGSupervisor.class */
public class JIFGSupervisor extends JInternalFrame {
    public Persona xjppersona;
    private DefaultTableModel xmodelo;
    private Object[] xdato;
    private String[] xidtipoempresa;
    private ButtonGroup JBGOpciones;
    private JComboBox JCBTipoEmpresa;
    private JCheckBox JCHEstado;
    private JPanel JPIDatosProf;
    private JPanel JPIFDatosUsuario;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;
    private ConsultasMySQL xconsultas = new ConsultasMySQL();
    private Metodos xmetodos = new Metodos();
    private int xestado = 0;
    private int xestadog = 0;

    public JIFGSupervisor() {
        initComponents();
        mCargasPanelUsuario();
        this.xidtipoempresa = this.xconsultas.llenarCombo("SELECT Id, Nbre FROM g_tipoempresa WHERE (Estado =0) ORDER BY Nbre ASC", this.xidtipoempresa, this.JCBTipoEmpresa);
        this.JCBTipoEmpresa.setSelectedIndex(-1);
        this.xconsultas.cerrarConexionBd();
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v13, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGOpciones = new ButtonGroup();
        this.JPIFDatosUsuario = new JPanel();
        this.JPIDatosProf = new JPanel();
        this.JCBTipoEmpresa = new JComboBox();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JCHEstado = new JCheckBox();
        setClosable(true);
        setTitle("SUPERVISOR");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setMaximumSize(null);
        setName("jifsupervisor");
        addInternalFrameListener(new InternalFrameListener() { // from class: ParametrizacionN.JIFGSupervisor.1
            public void internalFrameClosed(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                JIFGSupervisor.this.formInternalFrameClosing(evt);
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
        this.JPIFDatosUsuario.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN DEL USUARIO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        GroupLayout JPIFDatosUsuarioLayout = new GroupLayout(this.JPIFDatosUsuario);
        this.JPIFDatosUsuario.setLayout(JPIFDatosUsuarioLayout);
        JPIFDatosUsuarioLayout.setHorizontalGroup(JPIFDatosUsuarioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 992, 32767));
        JPIFDatosUsuarioLayout.setVerticalGroup(JPIFDatosUsuarioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 168, 32767));
        this.JPIDatosProf.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS DEL PROFESIONAL", 0, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JCBTipoEmpresa.setFont(new Font("Arial", 1, 12));
        this.JCBTipoEmpresa.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Empresa", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.setSelectionMode(0);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFGSupervisor.2
            public void mouseClicked(MouseEvent evt) {
                JIFGSupervisor.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setForeground(Color.blue);
        this.JCHEstado.setSelected(true);
        this.JCHEstado.setText("Estado");
        this.JCHEstado.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFGSupervisor.3
            public void actionPerformed(ActionEvent evt) {
                JIFGSupervisor.this.JCHEstadoActionPerformed(evt);
            }
        });
        GroupLayout JPIDatosProfLayout = new GroupLayout(this.JPIDatosProf);
        this.JPIDatosProf.setLayout(JPIDatosProfLayout);
        JPIDatosProfLayout.setHorizontalGroup(JPIDatosProfLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosProfLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosProfLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosProfLayout.createSequentialGroup().addComponent(this.JCBTipoEmpresa, 0, 720, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHEstado).addGap(191, 191, 191)).addGroup(JPIDatosProfLayout.createSequentialGroup().addComponent(this.JSPDetalle, -1, 972, 32767).addContainerGap()))));
        JPIDatosProfLayout.setVerticalGroup(JPIDatosProfLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosProfLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosProfLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBTipoEmpresa, -1, 50, 32767).addComponent(this.JCHEstado, -2, 36, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPDetalle, -2, 138, -2)));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JPIDatosProf, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.JPIFDatosUsuario, GroupLayout.Alignment.LEADING, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIFDatosUsuario, -2, -1, -2).addGap(18, 18, 18).addComponent(this.JPIDatosProf, -2, -1, -2).addContainerGap(31, 32767)));
        getAccessibleContext().setAccessibleName("usuario");
        pack();
    }

    private void txtFechaNacimientoFocusLost(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosing(InternalFrameEvent evt) {
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            this.JCBTipoEmpresa.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString());
            this.JCHEstado.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString()).booleanValue());
            mIniciarCheck();
            this.xestadog = 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEstadoActionPerformed(ActionEvent evt) {
        mIniciarCheck();
    }

    private void mIniciarCheck() {
        if (this.JCHEstado.isSelected()) {
            this.xestado = 0;
        } else {
            this.xestado = 1;
        }
    }

    private void mCargasPanelUsuario() {
        this.xjppersona = new Persona(this);
        this.xjppersona.setVisible(true);
        this.JPIFDatosUsuario.setVisible(false);
        this.xjppersona.setBounds(5, 15, 950, 160);
        this.JPIFDatosUsuario.add(this.xjppersona);
        this.JPIFDatosUsuario.setVisible(true);
    }

    public void mNuevo() {
        this.xjppersona.nuevo();
        this.xestado = 0;
        this.xestadog = 0;
        this.JCBTipoEmpresa.setSelectedIndex(-1);
        mCrearModeloDatos();
        this.xjppersona.txtHistoria.requestFocus();
    }

    public void mGrabar() {
        if (!this.xjppersona.getIdPersona().equals("") && this.xjppersona.getIdPersona() != null) {
            if (this.JCBTipoEmpresa.getSelectedIndex() != -1) {
                int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (n == 0) {
                    if (this.xestadog == 1) {
                        System.err.println("Entro Update");
                        if (this.JTDetalle.getSelectedRow() != -1) {
                            String sql = "update g_supervisor set Estado='" + this.xestado + "' where Id_Persona='" + this.xjppersona.getIdPersona() + "' and Id_TipoEmpresa='" + this.xidtipoempresa[this.JCBTipoEmpresa.getSelectedIndex()] + "'";
                            this.xconsultas.ejecutarSQL(sql);
                            this.xconsultas.cerrarConexionBd();
                        }
                    } else {
                        System.err.println("Entro Insert");
                        this.xjppersona.grabar();
                        String sql2 = "Insert into g_supervisor(Id_Persona, Id_TipoEmpresa, Estado, Fecha, UsuarioS) values ('" + this.xjppersona.getIdPersona() + "','" + this.xidtipoempresa[this.JCBTipoEmpresa.getSelectedIndex()] + "','" + this.xestado + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                        this.xconsultas.ejecutarSQL(sql2);
                        this.xconsultas.cerrarConexionBd();
                    }
                    mCargarDatosTabla(this.xjppersona.getIdPersona());
                    return;
                }
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una especialidad", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBTipoEmpresa.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una persona", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Tipo Epresa", "Estado"}) { // from class: ParametrizacionN.JIFGSupervisor.4
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
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(350);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(50);
    }

    public void mCargarDatosTabla(String xidp) {
        try {
            mCrearModeloDatos();
            String sql = "SELECT g_tipoempresa.Id, g_tipoempresa.Nbre, g_supervisor.Estado FROM g_supervisor INNER JOIN g_tipoempresa ON (g_supervisor.Id_TipoEmpresa = g_tipoempresa.Id) WHERE (g_supervisor.Id_Persona ='" + xidp + "') ORDER BY g_tipoempresa.Nbre ASC ";
            ResultSet xrs = this.xconsultas.traerRs(sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(1)), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt(Boolean.valueOf(!xrs.getBoolean(3)), n, 2);
                    n++;
                }
            }
            xrs.close();
            this.xconsultas.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFFEmpresaServicios.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mBuscar() {
        BuscarPersona frmBuscar = new BuscarPersona(null, true, this.xjppersona);
        frmBuscar.setVisible(true);
    }
}
