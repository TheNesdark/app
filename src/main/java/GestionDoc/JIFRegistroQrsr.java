package GestionDoc;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;

/* JADX INFO: loaded from: GenomaP.jar:GestionDoc/JIFRegistroQrsr.class */
public class JIFRegistroQrsr extends JInternalFrame {
    private File xfile;
    private String[] xidtipoempresa;
    private String[] xmediorecepcion;
    private String[] xidtipoafiliado;
    private String[] xidarea;
    private String[] xidtiporegistro;
    private String[] xidclasificacion;
    private int xgenera = 0;
    private ConsultasMySQL xconsulta = new ConsultasMySQL();
    private Metodos xmetodo = new Metodos();
    private clasesGestionDoc xclase;
    private JIFConsultarSQR xjifconsultar;
    private JComboBox JCBArea;
    private JComboBox JCBClasificacion;
    private JComboBox JCBMedioRecepcion;
    private JComboBox JCBTipoAfiliado;
    private JComboBox JCBTipoEmpresa;
    private JComboBox JCBTipoRegistro;
    private JCheckBox JCHGeneraAccion;
    public JDateChooser JDCFechaI;
    private JPanel JPIDGeneral;
    private JPanel JPIDatosUsuario;
    private JScrollPane JSPDAccionInm;
    private JScrollPane JSPDCausas;
    private JScrollPane JSPDQrs;
    private JTextField JTFDireccion;
    private JTextField JTFDocumento;
    private JTextField JTFEmail;
    private JTextField JTFFuncionario;
    private JTextField JTFRuta;
    private JTextField JTFTelefono;
    private JTextField JTFUsuario;
    private JTextPane JTPDAccionInm;
    private JTextPane JTPDCausas;
    private JTextPane JTPDQrs;
    private JPanel jPanel1;
    private JPanel jPanel2;

    public JIFRegistroQrsr(clasesGestionDoc xclase) {
        initComponents();
        this.xclase = xclase;
        mCargarCombox();
    }

    private void initComponents() {
        this.jPanel1 = new JPanel();
        this.JPIDatosUsuario = new JPanel();
        this.JTFUsuario = new JTextField();
        this.JTFDocumento = new JTextField();
        this.JTFDireccion = new JTextField();
        this.JTFTelefono = new JTextField();
        this.JTFEmail = new JTextField();
        this.JPIDGeneral = new JPanel();
        this.JDCFechaI = new JDateChooser();
        this.JCBTipoEmpresa = new JComboBox();
        this.JCBTipoAfiliado = new JComboBox();
        this.JCBMedioRecepcion = new JComboBox();
        this.JCBArea = new JComboBox();
        this.JTFFuncionario = new JTextField();
        this.JCBTipoRegistro = new JComboBox();
        this.JSPDQrs = new JScrollPane();
        this.JTPDQrs = new JTextPane();
        this.JSPDCausas = new JScrollPane();
        this.JTPDCausas = new JTextPane();
        this.JSPDAccionInm = new JScrollPane();
        this.JTPDAccionInm = new JTextPane();
        this.JCHGeneraAccion = new JCheckBox();
        this.jPanel2 = new JPanel();
        this.JTFRuta = new JTextField();
        this.JCBClasificacion = new JComboBox();
        setClosable(true);
        setIconifiable(true);
        setTitle("REGISTRO DE QUEJAS, RECLAMOS O SUGERENCIAS");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifregistroqrsr");
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "REGISTRO DE QUEJAS, RECLAMOS O SUGERENCIA", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.jPanel1.setName("jpqrs");
        this.JPIDatosUsuario.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN DE USUARIO", 0, 0, new Font("Arial", 1, 14), Color.red));
        this.JTFUsuario.setFont(new Font("Arial", 1, 12));
        this.JTFUsuario.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFDocumento.setFont(new Font("Arial", 1, 12));
        this.JTFDocumento.setBorder(BorderFactory.createTitledBorder((Border) null, "Documento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFDireccion.setFont(new Font("Arial", 1, 12));
        this.JTFDireccion.setBorder(BorderFactory.createTitledBorder((Border) null, "Dirección", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFTelefono.setFont(new Font("Arial", 1, 12));
        this.JTFTelefono.setBorder(BorderFactory.createTitledBorder((Border) null, "Teléfono", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFEmail.setFont(new Font("Arial", 1, 12));
        this.JTFEmail.setBorder(BorderFactory.createTitledBorder((Border) null, "Email", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPIDatosUsuarioLayout = new GroupLayout(this.JPIDatosUsuario);
        this.JPIDatosUsuario.setLayout(JPIDatosUsuarioLayout);
        JPIDatosUsuarioLayout.setHorizontalGroup(JPIDatosUsuarioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosUsuarioLayout.createSequentialGroup().addGroup(JPIDatosUsuarioLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JTFTelefono, GroupLayout.Alignment.LEADING).addComponent(this.JTFUsuario, GroupLayout.Alignment.LEADING, -1, 382, 32767)).addGap(18, 18, 18).addGroup(JPIDatosUsuarioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosUsuarioLayout.createSequentialGroup().addComponent(this.JTFDocumento, -2, 158, -2).addGap(18, 18, 18).addComponent(this.JTFDireccion, -1, 370, 32767)).addComponent(this.JTFEmail, -1, 546, 32767)).addContainerGap()));
        JPIDatosUsuarioLayout.setVerticalGroup(JPIDatosUsuarioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosUsuarioLayout.createSequentialGroup().addGroup(JPIDatosUsuarioLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFUsuario, -2, -1, -2).addComponent(this.JTFDocumento, -2, -1, -2).addComponent(this.JTFDireccion, -2, -1, -2)).addGap(18, 18, 18).addGroup(JPIDatosUsuarioLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFTelefono, -2, -1, -2).addComponent(this.JTFEmail, -2, -1, -2)).addContainerGap(-1, 32767)));
        this.JPIDGeneral.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN GENERAL", 0, 0, new Font("Arial", 1, 14), Color.red));
        this.JDCFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDCFechaI.setFont(new Font("Arial", 1, 12));
        this.JCBTipoEmpresa.setFont(new Font("Arial", 1, 12));
        this.JCBTipoEmpresa.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Empresa", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTipoAfiliado.setFont(new Font("Arial", 1, 12));
        this.JCBTipoAfiliado.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Afiliado", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBMedioRecepcion.setFont(new Font("Arial", 1, 12));
        this.JCBMedioRecepcion.setBorder(BorderFactory.createTitledBorder((Border) null, "Medio de Recepción", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBArea.setFont(new Font("Arial", 1, 12));
        this.JCBArea.setBorder(BorderFactory.createTitledBorder((Border) null, "Area donde ocurrio la no conformidad", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFuncionario.setFont(new Font("Arial", 1, 12));
        this.JTFFuncionario.setBorder(BorderFactory.createTitledBorder((Border) null, "Funcionario Involucrado", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTipoRegistro.setFont(new Font("Arial", 1, 12));
        this.JCBTipoRegistro.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Registro", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPIDGeneralLayout = new GroupLayout(this.JPIDGeneral);
        this.JPIDGeneral.setLayout(JPIDGeneralLayout);
        JPIDGeneralLayout.setHorizontalGroup(JPIDGeneralLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDGeneralLayout.createSequentialGroup().addContainerGap().addGroup(JPIDGeneralLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDGeneralLayout.createSequentialGroup().addComponent(this.JDCFechaI, -2, 131, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBTipoRegistro, 0, 211, 32767).addGap(18, 18, 18).addComponent(this.JCBTipoEmpresa, -2, 149, -2).addGap(18, 18, 18).addComponent(this.JCBTipoAfiliado, -2, 150, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBMedioRecepcion, -2, 243, -2)).addGroup(JPIDGeneralLayout.createSequentialGroup().addComponent(this.JCBArea, -2, 323, -2).addGap(18, 18, 18).addComponent(this.JTFFuncionario, -1, 595, 32767))).addContainerGap()));
        JPIDGeneralLayout.setVerticalGroup(JPIDGeneralLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDGeneralLayout.createSequentialGroup().addGroup(JPIDGeneralLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDGeneralLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBMedioRecepcion, -1, 51, 32767).addComponent(this.JCBTipoAfiliado, -1, 51, 32767).addComponent(this.JCBTipoEmpresa, -1, 51, 32767).addComponent(this.JCBTipoRegistro, -1, 51, 32767)).addComponent(this.JDCFechaI, GroupLayout.Alignment.TRAILING, -1, 52, 32767)).addGap(27, 27, 27).addGroup(JPIDGeneralLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBArea, -1, 51, 32767).addComponent(this.JTFFuncionario, -2, -1, -2)).addContainerGap()));
        this.JSPDQrs.setBorder(BorderFactory.createTitledBorder((Border) null, "Descripción de la Queja, Reclamo o Sugerencia", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTPDQrs.setFont(new Font("Arial", 1, 12));
        this.JTPDQrs.addKeyListener(new KeyAdapter() { // from class: GestionDoc.JIFRegistroQrsr.1
            public void keyPressed(KeyEvent evt) {
                JIFRegistroQrsr.this.JTPDQrsKeyPressed(evt);
            }
        });
        this.JSPDQrs.setViewportView(this.JTPDQrs);
        this.JSPDCausas.setBorder(BorderFactory.createTitledBorder((Border) null, "Descripción de Posibles Causas", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTPDCausas.setFont(new Font("Arial", 1, 12));
        this.JTPDCausas.addKeyListener(new KeyAdapter() { // from class: GestionDoc.JIFRegistroQrsr.2
            public void keyPressed(KeyEvent evt) {
                JIFRegistroQrsr.this.JTPDCausasKeyPressed(evt);
            }
        });
        this.JSPDCausas.setViewportView(this.JTPDCausas);
        this.JSPDAccionInm.setBorder(BorderFactory.createTitledBorder((Border) null, "Acción Inmediata o Correctivo Tomado", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTPDAccionInm.setFont(new Font("Arial", 1, 12));
        this.JTPDAccionInm.addKeyListener(new KeyAdapter() { // from class: GestionDoc.JIFRegistroQrsr.3
            public void keyPressed(KeyEvent evt) {
                JIFRegistroQrsr.this.JTPDAccionInmKeyPressed(evt);
            }
        });
        this.JSPDAccionInm.setViewportView(this.JTPDAccionInm);
        this.JCHGeneraAccion.setFont(new Font("Arial", 1, 12));
        this.JCHGeneraAccion.setForeground(Color.blue);
        this.JCHGeneraAccion.setText("Genera Acción de Mejora?");
        this.JCHGeneraAccion.addActionListener(new ActionListener() { // from class: GestionDoc.JIFRegistroQrsr.4
            public void actionPerformed(ActionEvent evt) {
                JIFRegistroQrsr.this.JCHGeneraAccionActionPerformed(evt);
            }
        });
        this.jPanel2.setBorder(BorderFactory.createTitledBorder((Border) null, "SOPORTE MAGNÉTICO", 0, 0, new Font("Arial", 1, 14), new Color(0, 102, 51)));
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ruta", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: GestionDoc.JIFRegistroQrsr.5
            public void mouseClicked(MouseEvent evt) {
                JIFRegistroQrsr.this.JTFRutaMouseClicked(evt);
            }
        });
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.JTFRuta, -2, 383, -2).addGap(361, 361, 361)));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.JTFRuta, -2, -1, -2).addContainerGap()));
        this.JCBClasificacion.setFont(new Font("Arial", 1, 12));
        this.JCBClasificacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Clasificación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPDAccionInm, -1, 972, 32767).addComponent(this.JSPDCausas, -1, 972, 32767).addComponent(this.JSPDQrs, GroupLayout.Alignment.TRAILING, -1, 972, 32767).addComponent(this.JPIDGeneral, -1, -1, 32767).addComponent(this.JPIDatosUsuario, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jPanel2, -2, 418, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHGeneraAccion).addComponent(this.JCBClasificacion, 0, 544, 32767)))).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JPIDGeneral, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPIDatosUsuario, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDQrs, -2, 86, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDCausas, -1, 77, 32767).addGap(18, 18, 18).addComponent(this.JSPDAccionInm, -2, 73, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 9, 32767).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jPanel2, -2, -1, -2).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JCBClasificacion, -2, -1, -2).addGap(7, 7, 7).addComponent(this.JCHGeneraAccion))).addContainerGap()));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, -1, -2).addContainerGap(-1, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, -1, -2).addContainerGap(-1, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTPDQrsKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 9) {
            this.JTPDQrs.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTPDCausasKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 9) {
            this.JTPDCausas.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTPDAccionInmKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 9) {
            this.JTPDAccionInm.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JFileChooser xfilec = new JFileChooser("S:\\QRSR\\");
            int xv = xfilec.showOpenDialog(this);
            if (xv == 0) {
                this.xfile = xfilec.getSelectedFile();
                this.JTFRuta.setText(this.xmetodo.mTraerUrlBD(this.xfile.getAbsolutePath()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHGeneraAccionActionPerformed(ActionEvent evt) {
        if (this.JCHGeneraAccion.isSelected()) {
            this.xgenera = 1;
        } else {
            this.xgenera = 0;
        }
    }

    private void mCargarCombox() {
        this.JDCFechaI.setDate(this.xmetodo.getFechaActual());
        this.xidtipoempresa = this.xconsulta.llenarCombo("SELECT Id, Nbre FROM baseserver.g_tipoempresa WHERE (Estado =0) ORDER BY Nbre ASC", this.xidtipoempresa, this.JCBTipoEmpresa);
        this.JCBTipoEmpresa.setSelectedIndex(-1);
        this.xconsulta.cerrarConexionBd();
        this.xmediorecepcion = this.xconsulta.llenarCombo("SELECT Id, Nbre FROM baseserver.g_mediorecepcion WHERE (Estado =0) ORDER BY Nbre ASC", this.xmediorecepcion, this.JCBMedioRecepcion);
        this.JCBMedioRecepcion.setSelectedIndex(-1);
        this.xconsulta.cerrarConexionBd();
        this.xidtipoafiliado = this.xconsulta.llenarCombo("SELECT Id , Nbre FROM baseserver.g_tipoafiliado WHERE (Estado =0) ORDER BY Nbre ASC", this.xidtipoafiliado, this.JCBTipoAfiliado);
        this.JCBTipoAfiliado.setSelectedIndex(-1);
        this.xconsulta.cerrarConexionBd();
        this.xidarea = this.xconsulta.llenarCombo("SELECT Id, Nbre FROM baseserver.t_sitioocurrencia WHERE (Estado =0) ORDER BY Nbre ASC", this.xidarea, this.JCBArea);
        this.JCBArea.setSelectedIndex(-1);
        this.xconsulta.cerrarConexionBd();
        this.xidtiporegistro = this.xconsulta.llenarCombo("SELECT Id, Nbre FROM baseserver.t_tiporegistro WHERE (Estado =0) ORDER BY Nbre ASC", this.xidtiporegistro, this.JCBTipoRegistro);
        this.JCBTipoRegistro.setSelectedIndex(-1);
        this.xconsulta.cerrarConexionBd();
        this.xidclasificacion = this.xconsulta.llenarCombo("SELECT Id , Nbre FROM baseserver.t_clasificacionqrs WHERE (Estado =1) ORDER BY Nbre ASC", this.xidclasificacion, this.JCBClasificacion);
        this.JCBClasificacion.setSelectedIndex(-1);
        this.xconsulta.cerrarConexionBd();
    }

    public void nuevo() {
        this.JDCFechaI.setDate(this.xmetodo.getFechaActual());
        this.JCBTipoRegistro.setSelectedIndex(-1);
        this.JCBTipoEmpresa.setSelectedIndex(-1);
        this.JCBArea.setSelectedIndex(-1);
        this.JCBMedioRecepcion.setSelectedIndex(-1);
        this.JCBTipoAfiliado.setSelectedIndex(-1);
        this.JTFDireccion.setText((String) null);
        this.JTFDocumento.setText((String) null);
        this.JTFFuncionario.setText((String) null);
        this.JTFRuta.setText("");
        this.JCBClasificacion.setSelectedIndex(-1);
        this.JTFUsuario.setText((String) null);
        this.JTFTelefono.setText((String) null);
        this.JTFEmail.setText((String) null);
        this.JTPDAccionInm.setText((String) null);
        this.JTPDCausas.setText((String) null);
        this.JTPDQrs.setText("");
        this.xfile = null;
        this.xgenera = 0;
        this.JCHGeneraAccion.setSelected(false);
        Principal.txtNo.setText("");
        this.JCBTipoRegistro.requestFocus();
    }

    public void grabar() {
        if (Principal.txtNo.getText().isEmpty() && mValidarDatos()) {
            int n = JOptionPane.showConfirmDialog(this, "Esta seguro de guardar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                String sql = "INSERT INTO t_registroqrs (FechaQRS, Id_TipoEmpresa, Id_TipoUsuario, Id_MRecepcion, Id_Area, NbreFuncionario, NbreUsuario,  DocumentoIdentidad, Direccion, Telefono, Email, Descripcion, Causas, AccionCorrectivo, AccionMejora, UrlSoporte, Usuario, Fecha, Id_TipoR, Id_Clasificacion)values('" + this.xmetodo.formatoAMD.format(this.JDCFechaI.getDate()) + "','" + this.xidtipoempresa[this.JCBTipoEmpresa.getSelectedIndex()] + "','" + this.xidtipoafiliado[this.JCBTipoAfiliado.getSelectedIndex()] + "','" + this.xmediorecepcion[this.JCBMedioRecepcion.getSelectedIndex()] + "','" + this.xidarea[this.JCBArea.getSelectedIndex()] + "','" + this.JTFFuncionario.getText() + "','" + this.JTFUsuario.getText() + "','" + this.JTFDocumento.getText() + "','" + this.JTFDireccion.getText() + "','" + this.JTFTelefono.getText() + "','" + this.JTFEmail.getText() + "','" + this.JTPDQrs.getText() + "','" + this.JTPDCausas.getText() + "','" + this.JTPDAccionInm.getText() + "','" + this.xgenera + "','" + this.JTFRuta.getText() + "','" + Principal.usuarioSistemaDTO.getLogin() + "','" + this.xmetodo.formatoAMDH24.format(this.xmetodo.getFechaActual()) + "','" + this.xidtiporegistro[this.JCBTipoRegistro.getSelectedIndex()] + "','" + this.xidclasificacion[this.JCBClasificacion.getSelectedIndex()] + "')";
                Principal.txtNo.setText(this.xconsulta.ejecutarSQLId(sql));
                this.xconsulta.cerrarConexionBd();
            }
        }
    }

    public void mBuscar(String xid) {
        String sql = "SELECT t_registroqrs.Id, t_registroqrs.FechaQRS, t_tiporegistro.Nbre, g_tipoempresa.Nbre, g_tipoafiliado.Nbre, g_mediorecepcion.Nbre, t_sitioocurrencia.Nbre, t_registroqrs.NbreFuncionario, t_registroqrs.NbreUsuario, t_registroqrs.DocumentoIdentidad , t_registroqrs.Direccion, t_registroqrs.Telefono, t_registroqrs.Email, t_registroqrs.Descripcion, t_registroqrs.Causas, t_registroqrs.AccionCorrectivo, t_registroqrs.AccionMejora, t_registroqrs.UrlSoporte, t_clasificacionqrs.Nbre  FROM baseserver.t_registroqrs INNER JOIN baseserver.t_tiporegistro  ON (t_registroqrs.Id_TipoR = t_tiporegistro.Id) INNER JOIN baseserver.g_tipoempresa  ON (t_registroqrs.Id_TipoEmpresa = g_tipoempresa.Id) INNER JOIN baseserver.g_mediorecepcion  ON (t_registroqrs.Id_MRecepcion = g_mediorecepcion.Id)  INNER JOIN baseserver.t_sitioocurrencia  ON (t_registroqrs.Id_Area = t_sitioocurrencia.Id) INNER JOIN baseserver.g_tipoafiliado  ON (t_registroqrs.Id_TipoUsuario = g_tipoafiliado.Id) INNER JOIN baseserver.t_clasificacionqrs  ON (t_registroqrs.Id_Clasificacion = t_clasificacionqrs.Id)  WHERE (t_registroqrs.Id ='" + xid + "') ";
        ResultSet xrs = this.xconsulta.traerRs(sql);
        try {
            if (xrs.next()) {
                xrs.first();
                Principal.txtNo.setText(xrs.getString(1));
                this.JDCFechaI.setDate(xrs.getDate(2));
                this.JCBTipoRegistro.setSelectedItem(xrs.getString(3));
                this.JCBTipoEmpresa.setSelectedItem(xrs.getString(4));
                this.JCBTipoAfiliado.setSelectedItem(xrs.getString(5));
                this.JCBMedioRecepcion.setSelectedItem(xrs.getString(6));
                this.JCBArea.setSelectedItem(xrs.getString(7));
                this.JTFFuncionario.setText(xrs.getString(8));
                this.JTFUsuario.setText(xrs.getString(9));
                this.JTFDocumento.setText(xrs.getString(10));
                this.JTFDireccion.setText(xrs.getString(11));
                this.JTFTelefono.setText(xrs.getString(12));
                this.JTFEmail.setText(xrs.getString(13));
                this.JTPDQrs.setText(xrs.getString(14));
                this.JTPDCausas.setText(xrs.getString(15));
                this.JTPDAccionInm.setText(xrs.getString(16));
                if (xrs.getInt(17) == 0) {
                    this.JCHGeneraAccion.setSelected(false);
                } else {
                    this.JCHGeneraAccion.setSelected(true);
                }
                this.JCBClasificacion.setSelectedItem(xrs.getString(19));
            }
            xrs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFRegistroQrsr.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void buscar() {
        this.xjifconsultar = new JIFConsultarSQR(this.xclase);
        Principal.cargarPantalla(this.xjifconsultar);
    }

    private boolean mValidarDatos() {
        boolean xest = false;
        if (this.JCBArea.getSelectedIndex() != -1) {
            if (this.JCBMedioRecepcion.getSelectedIndex() != -1) {
                if (this.JCBTipoAfiliado.getSelectedIndex() != -1) {
                    if (this.JCBTipoEmpresa.getSelectedIndex() != -1) {
                        if (!this.JTPDQrs.getText().isEmpty()) {
                            if (!this.JTFRuta.getText().isEmpty()) {
                                if (this.JCBClasificacion.getSelectedIndex() != -1) {
                                    xest = true;
                                } else {
                                    JOptionPane.showMessageDialog(this, "Debe seleccionar el tipo de clasificacion", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                                    this.JCBClasificacion.requestFocus();
                                }
                            } else {
                                JOptionPane.showMessageDialog(this, "Debe seleccionar el soporte", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                                this.JTFRuta.requestFocus();
                            }
                        } else {
                            JOptionPane.showMessageDialog(this, "Debe digitar la queja, reclamo o sugerencia", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                            this.JTPDQrs.requestFocus();
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "Debe seleccionar el tipo empresa", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                        this.JCBTipoEmpresa.requestFocus();
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Debe seleccionar el tipo de afiliado", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                    this.JCBTipoAfiliado.requestFocus();
                }
            } else {
                JOptionPane.showMessageDialog(this, "Debe seleccionar un medio de recepción", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                this.JCBMedioRecepcion.requestFocus();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un sitio de ocurrencia", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
            this.JCBArea.requestFocus();
        }
        return xest;
    }

    private void mGrabarBlob() {
        if (mValidarDatos()) {
            int n = JOptionPane.showConfirmDialog(this, "Esta seguro de guardar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                try {
                    new Metodos();
                    int l = (int) this.xfile.length();
                    PreparedStatement pSt = this.xconsulta.establecerConexionBd().prepareStatement("INSERT INTO t_registroqrs (FechaQRS, Id_TipoEmpresa, Id_TipoUsuario, Id_MRecepcion, Id_Area, NbreFuncionario, NbreUsuario,  DocumentoIdentidad, Direccion, Telefono, Email, Descripcion, Causas, AccionCorrectivo, AccionMejora, Soporte, Usuario, Fecha, Id_TipoR, Id_Clasificacion)  VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
                    InputStream is = new BufferedInputStream(new FileInputStream(this.xfile));
                    pSt.setString(1, this.xmetodo.formatoAMD.format(this.JDCFechaI.getDate()));
                    pSt.setString(2, this.xidtipoempresa[this.JCBTipoEmpresa.getSelectedIndex()]);
                    pSt.setString(3, this.xidtipoafiliado[this.JCBTipoAfiliado.getSelectedIndex()]);
                    pSt.setString(4, this.xmediorecepcion[this.JCBMedioRecepcion.getSelectedIndex()]);
                    pSt.setString(5, this.xidarea[this.JCBArea.getSelectedIndex()]);
                    pSt.setString(6, this.JTFFuncionario.getText());
                    pSt.setString(7, this.JTFUsuario.getText());
                    pSt.setString(8, this.JTFDocumento.getText());
                    pSt.setString(9, this.JTFDireccion.getText());
                    pSt.setString(10, this.JTFTelefono.getText());
                    pSt.setString(11, this.JTFEmail.getText());
                    pSt.setString(12, this.JTPDQrs.getText());
                    pSt.setString(13, this.JTPDCausas.getText());
                    pSt.setString(14, this.JTPDAccionInm.getText());
                    pSt.setInt(15, this.xgenera);
                    pSt.setBinaryStream(16, is, l);
                    pSt.setString(17, Principal.usuarioSistemaDTO.getLogin());
                    pSt.setString(18, this.xmetodo.formatoAMDH24.format(this.xmetodo.getFechaActual()));
                    pSt.setString(19, this.xidtiporegistro[this.JCBTipoRegistro.getSelectedIndex()]);
                    pSt.setString(20, this.xidclasificacion[this.JCBClasificacion.getSelectedIndex()]);
                    pSt.execute();
                    pSt.close();
                    this.xconsulta.cerrarConexionBd();
                    Principal.txtNo.setText(this.xconsulta.traerDato("SELECT MAX(Id) FROM baseserver.t_registroqrs"));
                    this.xconsulta.cerrarConexionBd();
                    JOptionPane.showMessageDialog(this, "Se guardo con exito", "Comfirmación", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(JIFRegistroQrsr.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                } catch (SQLException ex2) {
                    Logger.getLogger(JIFRegistroQrsr.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex2);
                }
            }
        }
    }
}
