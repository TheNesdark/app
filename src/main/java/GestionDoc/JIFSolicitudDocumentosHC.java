package GestionDoc;

import Acceso.Principal;
import General.BuscarPersona;
import General.Persona;
import Utilidades.ConsultasMySQL;
import Utilidades.Email;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:GestionDoc/JIFSolicitudDocumentosHC.class */
public class JIFSolicitudDocumentosHC extends JInternalFrame {
    private DefaultTableModel xmodelo1;
    private DefaultTableModel xmodelo2;
    private DefaultTableModel xmodelo3;
    private Object[] xdato;
    public Persona xjppersona;
    private File xfile;
    private String xsql;
    private ButtonGroup JBGForma;
    private JPanel JPIDUsuario;
    private JPanel JPIForma;
    private JPanel JPIHistorico;
    private JPanel JPIRecepcion;
    private JRadioButton JRBCorreo;
    private JRadioButton JRBFisica;
    private JScrollPane JSPAyudasDx;
    private JScrollPane JSPDocumentosHC;
    private JScrollPane JSPHistorico;
    private JScrollPane JSPPObservacionesGenerales;
    private JTextField JTFFEmail;
    private JTable JTPAyudasDx;
    private JTabbedPane JTPDatos;
    private JTable JTPDocumentosHC;
    private JTable JTPHistorico;
    private JTextPane JTPPObservacionesGenerales;
    private ConsultasMySQL xct = new ConsultasMySQL();
    private Metodos xmt = new Metodos();
    private int xforma = 0;

    public JIFSolicitudDocumentosHC(String xnombre) {
        initComponents();
        setName(xnombre);
        mCargarPanelUsuario();
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v35, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v40, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v59, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGForma = new ButtonGroup();
        this.JPIDUsuario = new JPanel();
        this.JTPDatos = new JTabbedPane();
        this.JPIRecepcion = new JPanel();
        this.JPIForma = new JPanel();
        this.JRBFisica = new JRadioButton();
        this.JRBCorreo = new JRadioButton();
        this.JTFFEmail = new JTextField();
        this.JSPPObservacionesGenerales = new JScrollPane();
        this.JTPPObservacionesGenerales = new JTextPane();
        this.JSPDocumentosHC = new JScrollPane();
        this.JTPDocumentosHC = new JTable();
        this.JSPAyudasDx = new JScrollPane();
        this.JTPAyudasDx = new JTable();
        this.JPIHistorico = new JPanel();
        this.JSPHistorico = new JScrollPane();
        this.JTPHistorico = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("SOLICITUD DE DOCUMENTOS CLINICOS");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setMinimumSize(null);
        setName("xjifsolicituddochc");
        addInternalFrameListener(new InternalFrameListener() { // from class: GestionDoc.JIFSolicitudDocumentosHC.1
            public void internalFrameActivated(InternalFrameEvent evt) {
            }

            public void internalFrameClosed(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                JIFSolicitudDocumentosHC.this.formInternalFrameClosing(evt);
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
        this.JPIDUsuario.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS DE USUARIO", 0, 0, new Font("Arial", 1, 14), Color.red));
        GroupLayout JPIDUsuarioLayout = new GroupLayout(this.JPIDUsuario);
        this.JPIDUsuario.setLayout(JPIDUsuarioLayout);
        JPIDUsuarioLayout.setHorizontalGroup(JPIDUsuarioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 974, 32767));
        JPIDUsuarioLayout.setVerticalGroup(JPIDUsuarioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 159, 32767));
        this.JTPDatos.setForeground(new Color(0, 103, 0));
        this.JTPDatos.setFont(new Font("Arial", 1, 14));
        this.JPIForma.setBorder(BorderFactory.createTitledBorder((Border) null, "Forma", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBGForma.add(this.JRBFisica);
        this.JRBFisica.setFont(new Font("Arial", 1, 12));
        this.JRBFisica.setSelected(true);
        this.JRBFisica.setText("Física");
        this.JRBFisica.addActionListener(new ActionListener() { // from class: GestionDoc.JIFSolicitudDocumentosHC.2
            public void actionPerformed(ActionEvent evt) {
                JIFSolicitudDocumentosHC.this.JRBFisicaActionPerformed(evt);
            }
        });
        this.JBGForma.add(this.JRBCorreo);
        this.JRBCorreo.setFont(new Font("Arial", 1, 12));
        this.JRBCorreo.setText("Correo");
        this.JRBCorreo.addActionListener(new ActionListener() { // from class: GestionDoc.JIFSolicitudDocumentosHC.3
            public void actionPerformed(ActionEvent evt) {
                JIFSolicitudDocumentosHC.this.JRBCorreoActionPerformed(evt);
            }
        });
        this.JTFFEmail.setFont(new Font("Arial", 1, 12));
        this.JTFFEmail.setBorder(BorderFactory.createTitledBorder((Border) null, "Email", 1, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPIFormaLayout = new GroupLayout(this.JPIForma);
        this.JPIForma.setLayout(JPIFormaLayout);
        JPIFormaLayout.setHorizontalGroup(JPIFormaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFormaLayout.createSequentialGroup().addContainerGap().addGroup(JPIFormaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JRBFisica).addComponent(this.JRBCorreo)).addGap(18, 18, 18).addComponent(this.JTFFEmail, -1, 281, 32767).addContainerGap()));
        JPIFormaLayout.setVerticalGroup(JPIFormaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFFEmail, GroupLayout.Alignment.TRAILING, -2, 50, -2).addGroup(GroupLayout.Alignment.TRAILING, JPIFormaLayout.createSequentialGroup().addComponent(this.JRBFisica).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBCorreo)));
        this.JSPPObservacionesGenerales.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación General", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTPPObservacionesGenerales.setFont(new Font("Arial", 1, 12));
        this.JTPPObservacionesGenerales.addKeyListener(new KeyAdapter() { // from class: GestionDoc.JIFSolicitudDocumentosHC.4
            public void keyPressed(KeyEvent evt) {
                JIFSolicitudDocumentosHC.this.JTPPObservacionesGeneralesKeyPressed(evt);
            }
        });
        this.JSPPObservacionesGenerales.setViewportView(this.JTPPObservacionesGenerales);
        this.JSPDocumentosHC.setBorder(BorderFactory.createTitledBorder((Border) null, "ATENCIONES", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTPDocumentosHC.setFont(new Font("Arial", 1, 12));
        this.JTPDocumentosHC.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTPDocumentosHC.setRowHeight(25);
        this.JTPDocumentosHC.setSelectionBackground(new Color(255, 255, 255));
        this.JTPDocumentosHC.setSelectionForeground(Color.red);
        this.JTPDocumentosHC.setSelectionMode(0);
        this.JSPDocumentosHC.setViewportView(this.JTPDocumentosHC);
        this.JSPAyudasDx.setBorder(BorderFactory.createTitledBorder((Border) null, "AYUDAS DIAGNÓSTICAS", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTPAyudasDx.setFont(new Font("Arial", 1, 12));
        this.JTPAyudasDx.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTPAyudasDx.setRowHeight(25);
        this.JTPAyudasDx.setSelectionBackground(new Color(255, 255, 255));
        this.JTPAyudasDx.setSelectionForeground(Color.red);
        this.JTPAyudasDx.setSelectionMode(0);
        this.JSPAyudasDx.setViewportView(this.JTPAyudasDx);
        GroupLayout JPIRecepcionLayout = new GroupLayout(this.JPIRecepcion);
        this.JPIRecepcion.setLayout(JPIRecepcionLayout);
        JPIRecepcionLayout.setHorizontalGroup(JPIRecepcionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIRecepcionLayout.createSequentialGroup().addContainerGap().addGroup(JPIRecepcionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIRecepcionLayout.createSequentialGroup().addComponent(this.JPIForma, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPPObservacionesGenerales, -1, 559, 32767)).addGroup(JPIRecepcionLayout.createSequentialGroup().addComponent(this.JSPDocumentosHC, -2, -1, -2).addGap(18, 18, 18).addComponent(this.JSPAyudasDx, -1, 481, 32767))).addContainerGap()));
        JPIRecepcionLayout.setVerticalGroup(JPIRecepcionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIRecepcionLayout.createSequentialGroup().addGap(22, 22, 22).addGroup(JPIRecepcionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPPObservacionesGenerales, -1, 81, 32767).addComponent(this.JPIForma, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIRecepcionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPAyudasDx, -1, 193, 32767).addComponent(this.JSPDocumentosHC, -1, 193, 32767)).addContainerGap()));
        this.JTPDatos.addTab("RECEPCIÓN", this.JPIRecepcion);
        this.JSPHistorico.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTPHistorico.setFont(new Font("Arial", 1, 12));
        this.JTPHistorico.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTPHistorico.setRowHeight(25);
        this.JTPHistorico.setSelectionBackground(new Color(255, 255, 255));
        this.JTPHistorico.setSelectionForeground(Color.red);
        this.JTPHistorico.setSelectionMode(0);
        this.JTPHistorico.addMouseListener(new MouseAdapter() { // from class: GestionDoc.JIFSolicitudDocumentosHC.5
            public void mouseClicked(MouseEvent evt) {
                JIFSolicitudDocumentosHC.this.JTPHistoricoMouseClicked(evt);
            }
        });
        this.JSPHistorico.setViewportView(this.JTPHistorico);
        GroupLayout JPIHistoricoLayout = new GroupLayout(this.JPIHistorico);
        this.JPIHistorico.setLayout(JPIHistoricoLayout);
        JPIHistoricoLayout.setHorizontalGroup(JPIHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIHistoricoLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPHistorico, -1, 961, 32767).addContainerGap()));
        JPIHistoricoLayout.setVerticalGroup(JPIHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIHistoricoLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPHistorico, -1, 291, 32767).addContainerGap()));
        this.JTPDatos.addTab("HISTÓRICO", this.JPIHistorico);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JTPDatos, GroupLayout.Alignment.LEADING, 0, 0, 32767).addComponent(this.JPIDUsuario, GroupLayout.Alignment.LEADING, -2, -1, -2)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDUsuario, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTPDatos, -2, 344, -2).addContainerGap(23, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTPPObservacionesGeneralesKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 9) {
            this.JTPPObservacionesGenerales.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBFisicaActionPerformed(ActionEvent evt) {
        this.xforma = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBCorreoActionPerformed(ActionEvent evt) {
        this.xforma = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosing(InternalFrameEvent evt) {
        Principal.mLimpiarDatosP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTPHistoricoMouseClicked(MouseEvent evt) {
        if (this.JTPHistorico.getSelectedRow() != -1) {
            Principal.txtNo.setText(this.xmodelo3.getValueAt(this.JTPHistorico.getSelectedRow(), 0).toString());
            mImprimir();
        }
    }

    private void mCargarPanelUsuario() {
        this.xjppersona = new Persona(this);
        this.xjppersona.setVisible(true);
        this.JPIDUsuario.setVisible(false);
        this.xjppersona.setBounds(6, 15, 980, 160);
        this.JPIDUsuario.add(this.xjppersona);
        this.JPIDUsuario.setVisible(true);
    }

    public void mNuevo() {
        Principal.mLimpiarDatosP();
        this.xjppersona.nuevo();
        this.JRBFisica.setSelected(true);
        this.JTFFEmail.setText("");
        this.JTPPObservacionesGenerales.setText("");
        mBuscarDatosDocumentosHCBd();
        mBuscarDatosAyudasDxBd();
        mCrearTablaHistorico();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTablaAtenciones() {
        this.xmodelo1 = new DefaultTableModel(new Object[0], new String[]{"Id", "Nombre", "S", "Observación"}) { // from class: GestionDoc.JIFSolicitudDocumentosHC.6
            Class[] types = {Integer.class, String.class, Boolean.class, String.class};
            boolean[] canEdit = {false, false, true, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTPDocumentosHC.setModel(this.xmodelo1);
        this.JTPDocumentosHC.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTPDocumentosHC.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTPDocumentosHC.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTPDocumentosHC.getColumnModel().getColumn(1).setPreferredWidth(150);
        this.JTPDocumentosHC.getColumnModel().getColumn(2).setPreferredWidth(10);
        this.JTPDocumentosHC.getColumnModel().getColumn(3).setPreferredWidth(90);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTablaAyudasDx() {
        this.xmodelo2 = new DefaultTableModel(new Object[0], new String[]{"Id", "Nombre", "S", "Observación"}) { // from class: GestionDoc.JIFSolicitudDocumentosHC.7
            Class[] types = {Integer.class, String.class, Boolean.class, String.class};
            boolean[] canEdit = {false, false, true, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTPAyudasDx.setModel(this.xmodelo2);
        this.JTPAyudasDx.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTPAyudasDx.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTPAyudasDx.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTPAyudasDx.getColumnModel().getColumn(1).setPreferredWidth(150);
        this.JTPAyudasDx.getColumnModel().getColumn(2).setPreferredWidth(10);
        this.JTPAyudasDx.getColumnModel().getColumn(3).setPreferredWidth(90);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTablaHistorico() {
        this.xmodelo3 = new DefaultTableModel(new Object[0], new String[]{"Id", "Fecha y Hora", "Forma", "Correo Electrónico", "Observación", "Usuario", "Entregado", "Fecha Entrega"}) { // from class: GestionDoc.JIFSolicitudDocumentosHC.8
            Class[] types = {Integer.class, String.class, String.class, String.class, String.class, String.class, Boolean.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTPHistorico.setModel(this.xmodelo3);
        this.JTPHistorico.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTPHistorico.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTPHistorico.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTPHistorico.getColumnModel().getColumn(1).setPreferredWidth(30);
        this.JTPHistorico.getColumnModel().getColumn(2).setPreferredWidth(10);
        this.JTPHistorico.getColumnModel().getColumn(3).setPreferredWidth(0);
        this.JTPHistorico.getColumnModel().getColumn(3).setMinWidth(0);
        this.JTPHistorico.getColumnModel().getColumn(3).setMaxWidth(0);
        this.JTPHistorico.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTPHistorico.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTPHistorico.getColumnModel().getColumn(6).setPreferredWidth(5);
        this.JTPHistorico.getColumnModel().getColumn(7).setPreferredWidth(20);
    }

    private void mBuscarDatosDocumentosHCBd() {
        try {
            mCrearTablaAtenciones();
            ResultSet rs = this.xct.traerRs("SELECT Id, Nbre FROM h_tipodocumentoshc WHERE (Estado =0) ORDER BY Nbre ASC ");
            if (rs.next()) {
                rs.beforeFirst();
                int x = 0;
                while (rs.next()) {
                    this.xmodelo1.addRow(this.xdato);
                    this.xmodelo1.setValueAt(rs.getString(1), x, 0);
                    this.xmodelo1.setValueAt(rs.getString(2), x, 1);
                    this.xmodelo1.setValueAt(false, x, 2);
                    this.xmodelo1.setValueAt("", x, 3);
                    x++;
                }
            }
            rs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFSolicitudDocumentosHC.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mBuscarDatosAyudasDxBd() {
        try {
            mCrearTablaAyudasDx();
            ResultSet rs = this.xct.traerRs("SELECT Id, Nbre FROM h_tipoayudadx WHERE (Estado =0) ORDER BY Nbre ASC ");
            if (rs.next()) {
                rs.beforeFirst();
                int x = 0;
                while (rs.next()) {
                    this.xmodelo2.addRow(this.xdato);
                    this.xmodelo2.setValueAt(rs.getString(1), x, 0);
                    this.xmodelo2.setValueAt(rs.getString(2), x, 1);
                    this.xmodelo2.setValueAt(false, x, 2);
                    this.xmodelo2.setValueAt("", x, 3);
                    x++;
                }
            }
            rs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFSolicitudDocumentosHC.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mBuscar() {
        BuscarPersona frmBuscar = new BuscarPersona(null, true, this.xjppersona);
        frmBuscar.setVisible(true);
    }

    public void mGrabar() {
        if (Principal.txtNo.getText().isEmpty()) {
            if (!this.xjppersona.getIdPersona().equals("0")) {
                if (this.xmt.mVerificarDatosTablaTrue(this.JTPDocumentosHC, 2) || this.xmt.mVerificarDatosTablaTrue(this.JTPAyudasDx, 2)) {
                    int x = JOptionPane.showConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    if (x == 0) {
                        this.xsql = "insert into gd_solicitud_doc(Id_Usuario , FEnvio , Correo , Observacion , Id_rh_persona,  UsuarioS ) values('" + this.xjppersona.getIdPersona() + "','" + this.xforma + "','" + this.JTFFEmail.getText() + "','" + this.JTPPObservacionesGenerales.getText() + "','" + Principal.usuarioSistemaDTO.getIdPersonaCargo() + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                        Principal.txtNo.setText(this.xct.ejecutarSQLId(this.xsql));
                        this.xct.cerrarConexionBd();
                        for (int y = 0; y < this.JTPDocumentosHC.getRowCount(); y++) {
                            if (Boolean.valueOf(this.xmodelo1.getValueAt(y, 2).toString()).booleanValue()) {
                                this.xsql = "insert into gd_solicitud_doc_detalle_hc(Id_solicitud_doc , Id_Tipo_DocumentoHc , Observacion) values ('" + Principal.txtNo.getText() + "','" + this.xmodelo1.getValueAt(y, 0) + "','" + this.xmodelo1.getValueAt(y, 3) + "')";
                                this.xct.ejecutarSQL(this.xsql);
                                this.xct.cerrarConexionBd();
                            }
                        }
                        for (int y2 = 0; y2 < this.JTPAyudasDx.getRowCount(); y2++) {
                            if (Boolean.valueOf(this.xmodelo2.getValueAt(y2, 2).toString()).booleanValue()) {
                                this.xsql = "insert into gd_solicitud_doc_detalle_dx(Id_solicitud_doc, Id_Tipo_AyudasDx, Observacion) values ('" + Principal.txtNo.getText() + "','" + this.xmodelo2.getValueAt(y2, 0) + "','" + this.xmodelo2.getValueAt(y2, 3) + "')";
                                this.xct.ejecutarSQL(this.xsql);
                                this.xct.cerrarConexionBd();
                            }
                        }
                        mEnviarCorreo();
                        return;
                    }
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Falta seleccionar el tipo de documento", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "No existe usuario seleccionado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.xjppersona.txtHistoria.requestFocus();
        }
    }

    public void mImprimir() {
        if (!Principal.txtNo.getText().isEmpty()) {
            String[][] parametros = new String[4][2];
            parametros[0][0] = "Id";
            parametros[0][1] = Principal.txtNo.getText();
            parametros[1][0] = "nbreUsuario";
            parametros[1][1] = Principal.usuarioSistemaDTO.getNombreUsuario();
            parametros[2][0] = "SUBREPORT_DIR";
            parametros[2][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
            parametros[3][0] = "SUBREPORTFIRMA_DIR";
            parametros[3][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
            this.xmt.GenerarPDF(this.xmt.getRutaRep() + "GD_SolicitudDocumentosClinicos", parametros);
        }
    }

    private void mEnviarCorreo() {
        String[][] parametros = new String[4][2];
        parametros[0][0] = "Id";
        parametros[0][1] = Principal.txtNo.getText();
        parametros[1][0] = "nbreUsuario";
        parametros[1][1] = Principal.usuarioSistemaDTO.getNombreUsuario();
        parametros[2][0] = "SUBREPORT_DIR";
        parametros[2][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
        parametros[3][0] = "SUBREPORTFIRMA_DIR";
        parametros[3][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
        this.xmt.GenerarPDFSinMostrar(this.xmt.getRutaRep() + "GD_SolicitudDocumentosClinicos", parametros);
        new File(this.xmt.getRutaRep() + "GD_SolicitudDocumentosClinicos.pdf");
        String str = this.xmt.getRutaRep() + "GD_SolicitudDocumentosClinicos";
        String adjunto = this.xmt.getRutaRep() + Principal.txtNo.getText() + ".pdf";
        File f1 = new File(this.xmt.getRutaRep() + "GD_SolicitudDocumentosClinicos.pdf");
        File f2 = new File(adjunto);
        boolean renombrado = f1.renameTo(f2);
        if (renombrado) {
            String remite = System.getProperty("user.name") + "@fundacionpanzenu.org.co";
            String mensaje = "Se ha generado la solicitud N°  " + Principal.txtNo.getText() + " \n\n\n" + Principal.usuarioSistemaDTO.getNombreUsuario() + "\n" + Principal.usuarioSistemaDTO.getNombreCargoUsuario();
            Email correo = new Email();
            List<String> correoE = new ArrayList<>();
            correoE.add("documentoclinico@fundacionpanzenu.org.co");
            correo.enviarAdjunto(correoE, mensaje, remite, "Solicitud copia documentos clínicos ", Principal.txtNo.getText() + ".pdf", f2.toString());
            f2.delete();
            return;
        }
        this.xmt.mostrarMensaje("Hubo un error al renombrar el archivo PDF");
    }

    public void mBuscarHistorico() {
        try {
            mCrearTablaHistorico();
            this.xsql = "SELECT gd_solicitud_doc.Id, DATE_FORMAT(gd_solicitud_doc.Fecha,'%d-%m-%Y %H:%m:%s') AS FechaS, IF(gd_solicitud_doc.FEnvio=0,'FÍSICO','CORREO ELECTRÓNICO') AS FEnvio, gd_solicitud_doc.Correo, gd_solicitud_doc.Observacion, persona.NUsuario, IF(gd_solicitud_doc.FechaEntrega IS NULL, 0,1) AS Entregado, IF(gd_solicitud_doc.FechaEntrega IS NULL, '',DATE_FORMAT(gd_solicitud_doc.FechaEntrega,'%d-%m-%Y')  ) AS FEntrega FROM gd_solicitud_doc INNER JOIN rh_tipo_persona_cargon ON (gd_solicitud_doc.Id_rh_persona = rh_tipo_persona_cargon.Id) INNER JOIN persona  ON (persona.Id_persona = rh_tipo_persona_cargon.Id_Persona) WHERE (gd_solicitud_doc.Id_Usuario ='" + this.xjppersona.getIdPersona() + "') ORDER BY gd_solicitud_doc.Fecha DESC; ";
            ResultSet xrs = this.xct.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int x = 0;
                while (xrs.next()) {
                    this.xmodelo3.addRow(this.xdato);
                    this.xmodelo3.setValueAt(Integer.valueOf(xrs.getInt(1)), x, 0);
                    this.xmodelo3.setValueAt(xrs.getString(2), x, 1);
                    this.xmodelo3.setValueAt(xrs.getString(3), x, 2);
                    this.xmodelo3.setValueAt(xrs.getString(4), x, 3);
                    this.xmodelo3.setValueAt(xrs.getString(5), x, 4);
                    this.xmodelo3.setValueAt(xrs.getString(6), x, 5);
                    this.xmodelo3.setValueAt(Boolean.valueOf(xrs.getBoolean(7)), x, 6);
                    this.xmodelo3.setValueAt(xrs.getString(8), x, 7);
                    this.JTPHistorico.setDefaultRenderer(Object.class, new MiRender1());
                    x++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFSolicitudDocumentosHC.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX INFO: loaded from: GenomaP.jar:GestionDoc/JIFSolicitudDocumentosHC$MiRender1.class */
    public static class MiRender1 extends DefaultTableCellRenderer {
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (Boolean.valueOf(table.getValueAt(row, 6).toString()).booleanValue()) {
                cell.setBackground(new Color(97, 228, 183));
                cell.setForeground(Color.BLACK);
            } else {
                cell.setBackground(Color.WHITE);
                cell.setForeground(Color.BLACK);
            }
            return cell;
        }
    }

    public void mAnular() {
        if (!Principal.txtNo.getText().isEmpty()) {
            if (!this.xmt.mVerificarEstadoAnular("SELECT if(FechaEntrega is null,0,1) entregada FROM gd_solicitud_doc WHERE (Id ='" + Principal.txtNo.getText() + "')").booleanValue()) {
                int x = JOptionPane.showConfirmDialog(this, "Esta seguro de anular?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (x == 0) {
                    this.xsql = "update gd_solicitud_doc set Estado=0 where Id='" + Principal.txtNo.getText() + "'";
                    this.xct.ejecutarSQL(this.xsql);
                    this.xct.cerrarConexionBd();
                    mBuscarHistorico();
                    return;
                }
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Solicitud ya entregrada;\nNo se puede anular.", "ANULAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        }
    }
}
