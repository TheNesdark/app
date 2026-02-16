package AutorizacionMP;

import Acceso.Principal;
import General.BuscarPersona;
import General.Persona;
import ParametrizacionN.JIFFEmpresaServicios;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
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
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:AutorizacionMP/JIFMatriculaPE.class */
public class JIFMatriculaPE extends JInternalFrame {
    private ConsultasMySQL xconsultas = new ConsultasMySQL();
    private Metodos xmetodos = new Metodos();
    public Persona xjppersona;
    private DefaultTableModel xmodelo;
    private Object[] xdato;
    private ButtonGroup JBGOpciones;
    private JPanel JPIFDatosUsuario;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;

    public JIFMatriculaPE() {
        initComponents();
        mCargasPanelUsuario();
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v12, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGOpciones = new ButtonGroup();
        this.JPIFDatosUsuario = new JPanel();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        setClosable(true);
        setTitle("MATRICULA DE USUARIO AL PROGRAMA EPECIAL DE ENVÍO DE MEDICAMENTOS A OTRAS CIUDADES");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setMaximumSize(null);
        setName("jifmatriculape");
        addInternalFrameListener(new InternalFrameListener() { // from class: AutorizacionMP.JIFMatriculaPE.1
            public void internalFrameActivated(InternalFrameEvent evt) {
            }

            public void internalFrameDeactivated(InternalFrameEvent evt) {
            }

            public void internalFrameDeiconified(InternalFrameEvent evt) {
            }

            public void internalFrameIconified(InternalFrameEvent evt) {
            }

            public void internalFrameClosed(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                JIFMatriculaPE.this.formInternalFrameClosing(evt);
            }

            public void internalFrameOpened(InternalFrameEvent evt) {
            }
        });
        this.JPIFDatosUsuario.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN DE USUARIO", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 51)));
        this.JPIFDatosUsuario.setFont(new Font("Arial", 1, 12));
        GroupLayout JPIFDatosUsuarioLayout = new GroupLayout(this.JPIFDatosUsuario);
        this.JPIFDatosUsuario.setLayout(JPIFDatosUsuarioLayout);
        JPIFDatosUsuarioLayout.setHorizontalGroup(JPIFDatosUsuarioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 992, 32767));
        JPIFDatosUsuarioLayout.setVerticalGroup(JPIFDatosUsuarioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 168, 32767));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "ORDENES GENERADAS", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JSPDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalle.setSelectionMode(0);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: AutorizacionMP.JIFMatriculaPE.2
            public void mouseClicked(MouseEvent evt) {
                JIFMatriculaPE.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPDetalle, -2, 638, -2).addComponent(this.JPIFDatosUsuario, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIFDatosUsuario, -2, -1, -2).addGap(18, 18, 18).addComponent(this.JSPDetalle, -1, 276, 32767).addContainerGap()));
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
        if (this.JTDetalle.getSelectedRow() != -1 && evt.getClickCount() == 2) {
            int x = JOptionPane.showInternalConfirmDialog(this, "Desea visualizar la formula?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                mImprimir(1);
                return;
            }
            return;
        }
        if (this.JTDetalle.getSelectedRow() != -1 && evt.getClickCount() == 1 && this.JTDetalle.getSelectedColumn() == 3 && this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 7).toString().equals("1")) {
            if (!this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 5).toString().equals("DESPACHADA")) {
                mQuitarMatricula();
                return;
            } else {
                JOptionPane.showInternalMessageDialog(this, "No se puede ejecutar la tarea porque esta orden ya se encuentra Despachada", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                mCargarDatosTabla(this.xjppersona.getIdPersona());
                return;
            }
        }
        if (this.JTDetalle.getSelectedRow() != -1 && evt.getClickCount() == 1 && this.JTDetalle.getSelectedColumn() == 3 && this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 7).toString().equals("0")) {
            JOptionPane.showInternalMessageDialog(this, "Orden no se encuentra matriculada", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            mCargarDatosTabla(this.xjppersona.getIdPersona());
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
        mCrearModeloDatos();
        this.xjppersona.txtHistoria.requestFocus();
    }

    public void mGrabar() {
        if (!this.xjppersona.getIdPersona().equals("") && this.xjppersona.getIdPersona() != null) {
            if (mVerificarDatosTablaTrue()) {
                int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "VERIFICAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (n == 0) {
                    for (int x = 0; x < this.JTDetalle.getRowCount(); x++) {
                        if (this.JTDetalle.getValueAt(x, 4).toString().equals("true") && this.JTDetalle.getValueAt(x, 3).toString().equals("false")) {
                            String sql = "Insert into d_programaenviomedicamentos(N_OrdenHc, UsuarioS, Fecha) values ('" + this.xmodelo.getValueAt(x, 0) + "','" + Principal.usuarioSistemaDTO.getLogin() + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "')";
                            this.xconsultas.ejecutarSQL(sql);
                            this.xconsultas.cerrarConexionBd();
                            String sql2 = "update h_ordenes set Matriculada=1 where Id='" + this.xmodelo.getValueAt(x, 0) + "'";
                            this.xconsultas.ejecutarSQL(sql2);
                            this.xconsultas.cerrarConexionBd();
                            if (this.JTDetalle.getValueAt(x, 6).toString().equals("true")) {
                                this.xmetodos.mEnvioCorreoElectronico("Se ha matriculado la formula N° " + this.xmodelo.getValueAt(x, 0) + ", del usuario: " + this.xjppersona.getApellido1() + " " + this.xjppersona.getApellido2() + " " + this.xjppersona.getNombre1() + " " + this.xjppersona.getNombre2() + ".\nFavor imprimir y tener pendiente para envió", "serviciofarmaceutico@fundacionpanzenu.org.co", "MATRICULA O RENOVACIÓN DE FORMULA PARA ENVIÓ DE MEDICAMENTOS ", Principal.usuarioSistemaDTO.getLogin());
                            }
                        }
                    }
                    mCargarDatosTabla(this.xjppersona.getIdPersona());
                    return;
                }
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una orden", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una persona", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    private void mQuitarMatricula() {
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de Quitar la Matricula?", "VERIFICAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            String sql = "update h_ordenes set Matriculada=0 where Id='" + this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0) + "'";
            String sql1 = "update d_programaenviomedicamentos set Estado=0 where N_OrdenHc='" + this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0) + "'";
            this.xconsultas.ejecutarSQL(sql);
            this.xconsultas.cerrarConexionBd();
            this.xconsultas.ejecutarSQL(sql1);
            this.xconsultas.cerrarConexionBd();
            return;
        }
        mCargarDatosTabla(this.xjppersona.getIdPersona());
    }

    private boolean mVerificarDatosTablaTrue() {
        boolean estado = false;
        if (this.JTDetalle.getRowCount() > 1) {
            int i = 0;
            while (true) {
                if (i >= this.JTDetalle.getRowCount() - 1) {
                    break;
                }
                if (!this.JTDetalle.getValueAt(i, 4).toString().equals("true")) {
                    i++;
                } else {
                    estado = true;
                    break;
                }
            }
        }
        return estado;
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Fecha", "N° Formula", "Matriculada?", "Cargar", "Estado", "Email", "QM"}) { // from class: AutorizacionMP.JIFMatriculaPE.3
            Class[] types = {Long.class, String.class, String.class, Boolean.class, Boolean.class, String.class, Boolean.class, Long.class};
            boolean[] canEdit = {false, false, false, true, true, false, true, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(7).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(7).setMaxWidth(0);
    }

    public void mCargarDatosTabla(String xidpersona) {
        try {
            mCrearModeloDatos();
            String sql = "SELECT h_ordenes.Id , DATE_FORMAT(h_ordenes.FechaOrden,'%d-%m-%Y') AS fecha, h_ordenes.NoFormInicio, h_ordenes.NoFormuFin, h_ordenes.Matriculada, IF(EstaEntregada=0, 'NO ENTREGADA', IF(EstaEntregada=1, 'IMPRESA','DESPACHADA' )) AS Estado FROM h_ordenes INNER JOIN h_atencion  ON (h_ordenes.Id_Atencion = h_atencion.Id) INNER JOIN ingreso  ON (h_atencion.Id_Ingreso = ingreso.Id) WHERE (ingreso.Id_Usuario ='" + xidpersona + "' AND h_ordenes.Estado =0) ORDER BY h_ordenes.FechaOrden DESC ";
            ResultSet xrs = this.xconsultas.traerRs(sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(1)), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt(xrs.getString(3) + " de " + xrs.getString(4), n, 2);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(5)), n, 3);
                    this.xmodelo.setValueAt(false, n, 4);
                    this.xmodelo.setValueAt(xrs.getString(6), n, 5);
                    this.xmodelo.setValueAt(false, n, 6);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(5)), n, 7);
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

    private void mImprimir(int n) {
        try {
            String xnotasad = null;
            String tipo = "Farmacia";
            String sql = "SELECT Id_Atencion, Id, Date_Format(FechaOrden,'%d-%m-%Y') as Fecha FROM baseserver.h_ordenes where Id='" + this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0) + "'";
            ConsultasMySQL xmt = new ConsultasMySQL();
            ResultSet rsm = xmt.traerRs(sql);
            rsm.first();
            long xida = rsm.getLong(1);
            if (rsm.getRow() != 0) {
                String sql2 = "SELECT Id_Atencion, Id, Date_Format(FechaOrden,'%d-%m-%Y') as Fecha FROM  baseserver.h_ordenes where  Id_Atencion='" + xida + "' and Id>'" + this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0) + "' order by Id";
                rsm = this.xconsultas.traerRs(sql2);
                rsm.next();
                if (rsm.getRow() != 0) {
                    xnotasad = "Orden N° : " + rsm.getInt(2) + "  - - - Fecha Proxima Entrega : " + rsm.getString(3);
                }
                this.xconsultas.cerrarConexionBd();
            }
            rsm.close();
            xmt.cerrarConexionBd();
            String[][] mparametros = new String[6][2];
            for (int j = 0; j < n; j++) {
                mparametros[0][0] = "norden";
                mparametros[0][1] = this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString();
                mparametros[1][0] = "xp2";
                mparametros[1][1] = tipo;
                mparametros[2][0] = "ip";
                mparametros[2][1] = xnotasad;
                mparametros[3][0] = "nusuarios";
                mparametros[3][1] = Principal.usuarioSistemaDTO.getLogin();
                mparametros[4][0] = "SUBREPORT_DIR";
                mparametros[4][1] = this.xmetodos.getSO() + this.xmetodos.getBarra() + "Reportes" + this.xmetodos.getBarra();
                mparametros[5][0] = "SUBREPORTFIRMA_DIR";
                mparametros[5][1] = this.xmetodos.getSO() + this.xmetodos.getBarra() + "Firmas" + this.xmetodos.getBarra();
                this.xmetodos.GenerarPDF(this.xmetodos.getRutaRep() + "RFormulaGeneralMP", mparametros);
                tipo = "Usuario";
            }
        } catch (SQLException e) {
        }
    }
}
