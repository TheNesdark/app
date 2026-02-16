package GestionDoc;

import Acceso.Principal;
import General.BuscarPersona;
import General.Persona;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
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
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import org.apache.commons.io.FilenameUtils;

/* JADX INFO: loaded from: GenomaP.jar:GestionDoc/JIFCargarDocumentosHC.class */
public class JIFCargarDocumentosHC extends JInternalFrame {
    private DefaultTableModel modelosuministro;
    private String[] xidprofesional;
    private String[] xidespecialidad;
    private String[] xiddocumentos;
    private String[] listaIngresos;
    private Object[] dato;
    public String xidusuario;
    public Persona xjppersona;
    private File xfile;
    private File directorio;
    private JComboBox JCBIngreso;
    private JComboBox JCBProfesional;
    private JComboBox JCBTipoDocumento;
    private JComboBox JCBespecialidad;
    private JCheckBox JCHAplicaIngreso;
    public JDateChooser JDCFechaI;
    private JPanel JPIDUsuario;
    private JPanel JPIDatosCargar;
    private JScrollPane JSPDetalleConsulta;
    private JTable JTBDetalle;
    private JTextField JTFRuta;
    private JPanel jPanel1;
    private TableColumn column = null;
    private ConsultasMySQL xconsultasbd = new ConsultasMySQL();
    private Metodos xmetodo = new Metodos();
    private int xvc = 0;
    private int xlleno = 0;

    public JIFCargarDocumentosHC() {
        initComponents();
        Principal.txtNo.setText("");
        mCargarDatosGenerales();
        nuevo();
    }

    private void initComponents() {
        this.jPanel1 = new JPanel();
        this.JPIDUsuario = new JPanel();
        this.JPIDatosCargar = new JPanel();
        this.JDCFechaI = new JDateChooser();
        this.JCBProfesional = new JComboBox();
        this.JCBespecialidad = new JComboBox();
        this.JTFRuta = new JTextField();
        this.JCBTipoDocumento = new JComboBox();
        this.JCBIngreso = new JComboBox();
        this.JCHAplicaIngreso = new JCheckBox();
        this.JSPDetalleConsulta = new JScrollPane();
        this.JTBDetalle = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("CARGAR ATENCIONES MANUALES");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifcargaratencionesmanuales");
        setPreferredSize(new Dimension(1043, 825));
        this.jPanel1.setName("jpcargarayudasdxu");
        this.jPanel1.setLayout((LayoutManager) null);
        this.JPIDUsuario.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS DE USUARIO", 0, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        GroupLayout JPIDUsuarioLayout = new GroupLayout(this.JPIDUsuario);
        this.JPIDUsuario.setLayout(JPIDUsuarioLayout);
        JPIDUsuarioLayout.setHorizontalGroup(JPIDUsuarioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 978, 32767));
        JPIDUsuarioLayout.setVerticalGroup(JPIDUsuarioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 165, 32767));
        this.jPanel1.add(this.JPIDUsuario);
        this.JPIDUsuario.setBounds(10, 10, 990, 191);
        this.JPIDatosCargar.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS A CARGAR", 1, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JDCFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 11), Color.blue));
        this.JDCFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDCFechaI.setFont(new Font("Arial", 1, 12));
        this.JCBProfesional.setFont(new Font("Arial", 1, 12));
        this.JCBProfesional.setBorder(BorderFactory.createTitledBorder((Border) null, "Profesional", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBespecialidad.setFont(new Font("Arial", 1, 12));
        this.JCBespecialidad.setBorder(BorderFactory.createTitledBorder((Border) null, "Especialidad", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBespecialidad.addItemListener(new ItemListener() { // from class: GestionDoc.JIFCargarDocumentosHC.1
            public void itemStateChanged(ItemEvent evt) {
                JIFCargarDocumentosHC.this.JCBespecialidadItemStateChanged(evt);
            }
        });
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ruta", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: GestionDoc.JIFCargarDocumentosHC.2
            public void mouseClicked(MouseEvent evt) {
                JIFCargarDocumentosHC.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JCBTipoDocumento.setFont(new Font("Arial", 1, 12));
        this.JCBTipoDocumento.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Documento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBIngreso.setFont(new Font("Arial", 1, 12));
        this.JCBIngreso.setBorder(BorderFactory.createTitledBorder((Border) null, "Ingreso (Opcional)", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHAplicaIngreso.setFont(new Font("Arial", 1, 12));
        this.JCHAplicaIngreso.setForeground(Color.blue);
        this.JCHAplicaIngreso.setText("Ingreso relacionado?");
        this.JCHAplicaIngreso.addActionListener(new ActionListener() { // from class: GestionDoc.JIFCargarDocumentosHC.3
            public void actionPerformed(ActionEvent evt) {
                JIFCargarDocumentosHC.this.JCHAplicaIngresoActionPerformed(evt);
            }
        });
        GroupLayout JPIDatosCargarLayout = new GroupLayout(this.JPIDatosCargar);
        this.JPIDatosCargar.setLayout(JPIDatosCargarLayout);
        JPIDatosCargarLayout.setHorizontalGroup(JPIDatosCargarLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosCargarLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosCargarLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosCargarLayout.createSequentialGroup().addComponent(this.JTFRuta, -2, 400, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBTipoDocumento, -2, 232, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBIngreso, -2, 138, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHAplicaIngreso).addContainerGap(24, 32767)).addGroup(JPIDatosCargarLayout.createSequentialGroup().addComponent(this.JDCFechaI, -2, 130, -2).addGap(10, 10, 10).addComponent(this.JCBespecialidad, 0, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBProfesional, -2, 451, -2).addGap(32, 32, 32)))));
        JPIDatosCargarLayout.setVerticalGroup(JPIDatosCargarLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosCargarLayout.createSequentialGroup().addGroup(JPIDatosCargarLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPIDatosCargarLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBProfesional, -2, -1, -2).addComponent(this.JCBespecialidad, -2, -1, -2)).addComponent(this.JDCFechaI, -2, 50, -2)).addGap(10, 10, 10).addGroup(JPIDatosCargarLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFRuta, -2, 47, -2).addComponent(this.JCBTipoDocumento).addComponent(this.JCBIngreso, -2, -1, -2).addComponent(this.JCHAplicaIngreso)).addGap(10, 10, 10)));
        this.jPanel1.add(this.JPIDatosCargar);
        this.JPIDatosCargar.setBounds(10, 210, 980, 140);
        this.JSPDetalleConsulta.setBorder(BorderFactory.createTitledBorder((Border) null, "ATENCIONES", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTBDetalle.setFont(new Font("Arial", 1, 12));
        this.JTBDetalle.setRowHeight(25);
        this.JTBDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTBDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTBDetalle.setSelectionMode(0);
        this.JTBDetalle.addMouseListener(new MouseAdapter() { // from class: GestionDoc.JIFCargarDocumentosHC.4
            public void mouseClicked(MouseEvent evt) {
                JIFCargarDocumentosHC.this.JTBDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalleConsulta.setViewportView(this.JTBDetalle);
        this.jPanel1.add(this.JSPDetalleConsulta);
        this.JSPDetalleConsulta.setBounds(10, 380, 980, 340);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.jPanel1, -2, 1013, -2).addGap(10, 10, 10)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.jPanel1, -2, 733, -2).addGap(10, 10, 10)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBespecialidadItemStateChanged(ItemEvent evt) {
        if (this.xlleno == 1) {
            this.JCBProfesional.removeAllItems();
            this.xidprofesional = this.xconsultasbd.llenarCombo("SELECT Id_Persona, NProfesional FROM profesional1 WHERE (IdEspecialidad ='" + this.xidespecialidad[this.JCBespecialidad.getSelectedIndex()] + "') ORDER BY NProfesional ASC", this.xidprofesional, this.JCBProfesional);
            this.xconsultasbd.cerrarConexionBd();
            this.JCBProfesional.setSelectedIndex(-1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JFileChooser xfilec = new JFileChooser("S:\\GestionDocumental\\DocumentosHC");
            int xv = xfilec.showOpenDialog(this);
            if (xv == 0) {
                this.xfile = xfilec.getSelectedFile();
                this.JTFRuta.setText(this.xfile.getAbsolutePath());
                this.JTFRuta.setText(this.xmetodo.mTraerUrlBD(this.xfile.getAbsolutePath()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBDetalleMouseClicked(MouseEvent evt) {
        if (this.JTBDetalle.getSelectedRow() != -1) {
            if (Principal.informacionIps.getEsFpz().intValue() == 0) {
                this.xmetodo.mostrarPdf(this.modelosuministro.getValueAt(this.JTBDetalle.getSelectedRow(), 5).toString());
            } else if (this.xmetodo.mExisteArchivo(this.modelosuministro.getValueAt(this.JTBDetalle.getSelectedRow(), 5).toString())) {
                this.xmetodo.mostrarPdf(this.modelosuministro.getValueAt(this.JTBDetalle.getSelectedRow(), 5).toString());
            } else {
                this.xmetodo.mostrarPdf(this.directorio + this.xmetodo.getBarra() + this.modelosuministro.getValueAt(this.JTBDetalle.getSelectedRow(), 5).toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHAplicaIngresoActionPerformed(ActionEvent evt) {
    }

    public void listarIngresos() {
        this.JCBIngreso.removeAllItems();
        this.listaIngresos = this.xconsultasbd.llenarCombo("SELECT Id, Id FROM ingreso WHERE (`Id_MotivoAnulacion`=1 AND Estado=0 AND Id_Usuario=" + this.xjppersona.getIdPersona() + ") ORDER BY Id DESC", this.listaIngresos, this.JCBIngreso);
        this.JCBIngreso.setSelectedIndex(-1);
    }

    public void buscar() {
        BuscarPersona frmBuscar = new BuscarPersona(null, true, this.xjppersona);
        frmBuscar.setVisible(true);
    }

    private void mCargarPanelUsuario() {
        this.xjppersona = new Persona(this);
        this.xjppersona.setVisible(true);
        this.JPIDUsuario.setVisible(false);
        this.xjppersona.setBounds(6, 15, 980, 160);
        this.JPIDUsuario.add(this.xjppersona);
        this.JPIDUsuario.setVisible(true);
    }

    private void mCargarDatosGenerales() {
        this.JDCFechaI.setDate(this.xmetodo.getFechaActual());
        this.xidespecialidad = this.xconsultasbd.llenarCombo("SELECT Id, Nbre FROM g_especialidad ORDER BY Nbre ASC", this.xidespecialidad, this.JCBespecialidad);
        this.JCBespecialidad.setSelectedIndex(-1);
        this.xconsultasbd.cerrarConexionBd();
        this.xiddocumentos = this.xconsultasbd.llenarCombo("SELECT Id, Nbre FROM h_tipodocumentoshc WHERE (Estado =0) ORDER BY Nbre ASC", this.xiddocumentos, this.JCBTipoDocumento);
        this.JCBTipoDocumento.setSelectedIndex(-1);
        this.xconsultasbd.cerrarConexionBd();
        mCargarPanelUsuario();
        mCrearTabla();
        this.xlleno = 1;
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTabla() {
        this.modelosuministro = new DefaultTableModel(new Object[0], new String[]{"Id", "Fecha", "Especialidad", "Profesional", "Tipo Documento", "Soporte", "idIngreso"}) { // from class: GestionDoc.JIFCargarDocumentosHC.5
            Class[] types = {Long.class, String.class, String.class, String.class, String.class, String.class, Long.class};
            boolean[] canEdit = {false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTBDetalle;
        JTable jTable2 = this.JTBDetalle;
        jTable.setAutoResizeMode(0);
        this.JTBDetalle.doLayout();
        this.JTBDetalle.setModel(this.modelosuministro);
        this.JTBDetalle.getColumnModel().getColumn(0).setPreferredWidth(80);
        this.JTBDetalle.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTBDetalle.getColumnModel().getColumn(2).setPreferredWidth(200);
        this.JTBDetalle.getColumnModel().getColumn(3).setPreferredWidth(300);
        this.JTBDetalle.getColumnModel().getColumn(4).setPreferredWidth(200);
        this.JTBDetalle.getColumnModel().getColumn(5).setPreferredWidth(150);
        this.JTBDetalle.getColumnModel().getColumn(6).setPreferredWidth(100);
    }

    public void mCargarDatosTabla() {
        try {
            String sql = "SELECT h_atencionesmanuales.Id, DATE_FORMAT(h_atencionesmanuales.Fecha_Atencion, '%d/%m/%Y'), g_especialidad.Nbre, profesional.NProfesional, h_tipodocumentoshc.Nbre, h_atencionesmanuales.Url, h_atencionesmanuales.Id_Ingreso  FROM h_atencionesmanuales INNER JOIN g_especialidad ON (h_atencionesmanuales.Id_Especialidad = g_especialidad.Id)  INNER JOIN profesional  ON (profesional.Id_Persona = h_atencionesmanuales.Id_Profesional)  INNER JOIN h_tipodocumentoshc  ON (h_tipodocumentoshc.Id = h_atencionesmanuales.Id_TipoDoc)  WHERE (h_atencionesmanuales.Id_Usuario ='" + this.xjppersona.getIdPersona() + "' and h_atencionesmanuales.Estado=0) ORDER BY h_atencionesmanuales.Fecha_Atencion ASC ";
            ResultSet rs = this.xconsultasbd.traerRs(sql);
            rs.next();
            if (rs.getRow() != 0) {
                rs.beforeFirst();
                int i = 0;
                while (rs.next()) {
                    this.modelosuministro.addRow(this.dato);
                    this.modelosuministro.setValueAt(Long.valueOf(rs.getLong(1)), i, 0);
                    this.modelosuministro.setValueAt(rs.getString(2), i, 1);
                    this.modelosuministro.setValueAt(rs.getString(3), i, 2);
                    this.modelosuministro.setValueAt(rs.getString(4), i, 3);
                    this.modelosuministro.setValueAt(rs.getString(5).toUpperCase(), i, 4);
                    this.modelosuministro.setValueAt(this.xmetodo.mTraerUrlBD(rs.getString(6)), i, 5);
                    this.modelosuministro.setValueAt(rs.getString("Id_Ingreso"), i, 6);
                    i++;
                }
            }
            rs.close();
            this.xconsultasbd.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFCargarDocumentosHC.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void nuevo() {
        this.xlleno = 0;
        Principal.txtNo.setText("");
        this.directorio = new File(this.xmetodo.mRutaSoporte("JIFCargarDocumentosHC"));
        this.xjppersona.nuevo();
        this.JDCFechaI.setDate(this.xmetodo.getFechaActual());
        this.JCBProfesional.setSelectedIndex(-1);
        this.JCBespecialidad.setSelectedIndex(-1);
        this.JCBTipoDocumento.setSelectedIndex(-1);
        this.JCHAplicaIngreso.setSelected(false);
        this.JCBIngreso.removeAllItems();
        this.JCBIngreso.setSelectedIndex(-1);
        this.JTFRuta.setText((String) null);
        mCrearTabla();
        this.xlleno = 1;
        this.xjppersona.txtHistoria.requestFocus();
    }

    public void grabar() {
        mGrabarBlob();
    }

    private boolean mValidarCampos() {
        boolean rs = false;
        if (Principal.txtNo.getText().isEmpty()) {
            if (this.xjppersona.validarDatos(0) == 1) {
                if (this.JCBProfesional.getSelectedIndex() != -1) {
                    if (this.JCBespecialidad.getSelectedIndex() != -1) {
                        if (!this.JTFRuta.getText().isEmpty()) {
                            if (this.JCBTipoDocumento.getSelectedIndex() != -1) {
                                if (!this.JCHAplicaIngreso.isSelected() || this.JCBIngreso.getSelectedIndex() != -1) {
                                    rs = true;
                                } else {
                                    JOptionPane.showMessageDialog(this, "Debe seleccionar un Ingreso relacionado", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                                    this.JCBIngreso.requestFocus();
                                }
                            } else {
                                JOptionPane.showMessageDialog(this, "Debe seleccionar un tipo de documento", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                                this.JCBTipoDocumento.requestFocus();
                            }
                        } else {
                            JOptionPane.showMessageDialog(this, "Debe seleccionar el arhivo a cargar", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                            this.JCBespecialidad.requestFocus();
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "Debe seleccionar un tipo de ayuda dx", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                        this.JCBespecialidad.requestFocus();
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Debe seleccionar un profesional", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                    this.JCBProfesional.requestFocus();
                }
            } else {
                JOptionPane.showMessageDialog(this, "Debe cargar un usuario", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                this.xjppersona.txtHistoria.requestFocus();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Documento ya grabado", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
        }
        return rs;
    }

    private void mGrabarBlob() {
        if (mValidarCampos()) {
            int n = JOptionPane.showConfirmDialog(this, "Esta seguro de guardar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                long idIngreso = 0;
                if (this.JCHAplicaIngreso.isSelected() && this.JCBIngreso.getSelectedIndex() != -1) {
                    idIngreso = Long.valueOf(this.listaIngresos[this.JCBIngreso.getSelectedIndex()]).longValue();
                }
                if (Principal.informacionIps.getEsFpz().intValue() == 0) {
                    String sql = "insert into h_atencionesmanuales (Id_Usuario, Id_Ingreso, Fecha_Atencion, Id_TipoDoc, Id_Especialidad, Id_Profesional, Url, Fecha, UsuarioS)  values('" + this.xjppersona.getIdPersona() + "','" + idIngreso + "','" + this.xmetodo.formatoAMD.format(this.JDCFechaI.getDate()) + "','" + this.xiddocumentos[this.JCBTipoDocumento.getSelectedIndex()] + "','" + this.xidespecialidad[this.JCBespecialidad.getSelectedIndex()] + "','" + this.xidprofesional[this.JCBProfesional.getSelectedIndex()] + "','" + this.JTFRuta.getText() + "','" + this.xmetodo.formatoAMDH24.format(this.xmetodo.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                    Principal.txtNo.setText(this.xconsultasbd.ejecutarSQLId(sql));
                } else {
                    this.directorio = new File(this.xmetodo.mRutaSoporte("JIFCargarDocumentosHC"));
                    String sql2 = "insert into h_atencionesmanuales (Id_Usuario, Id_Ingreso, Fecha_Atencion, Id_TipoDoc, Id_Especialidad, Id_Profesional, Fecha, UsuarioS)  values('" + this.xjppersona.getIdPersona() + "','" + idIngreso + "','" + this.xmetodo.formatoAMD.format(this.JDCFechaI.getDate()) + "','" + this.xiddocumentos[this.JCBTipoDocumento.getSelectedIndex()] + "','" + this.xidespecialidad[this.JCBespecialidad.getSelectedIndex()] + "','" + this.xidprofesional[this.JCBProfesional.getSelectedIndex()] + "','" + this.xmetodo.formatoAMDH24.format(this.xmetodo.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                    String xidDoc = this.xconsultasbd.ejecutarSQLId(sql2);
                    String adjunto = xidDoc + "_" + this.xjppersona.getIdPersona() + "_" + this.JCBTipoDocumento.getSelectedItem() + "." + FilenameUtils.getExtension(this.JTFRuta.getText());
                    String sql3 = "UPDATE h_atencionesmanuales set Url='" + this.xmetodo.mTraerUrlBD(adjunto) + "' WHERE Id='" + xidDoc + "'";
                    this.xconsultasbd.ejecutarSQL(sql3);
                    this.xconsultasbd.cerrarConexionBd();
                    File f1 = new File(this.JTFRuta.getText());
                    File f2 = new File(adjunto);
                    f1.renameTo(f2);
                    f2.renameTo(new File(this.directorio, f2.getName()));
                    Principal.txtNo.setText(xidDoc);
                }
                this.xconsultasbd.cerrarConexionBd();
                mCrearTabla();
                mCargarDatosTabla();
                JOptionPane.showMessageDialog(this, "Se guardo con exito", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            }
        }
    }

    public void eliminar() {
        if (this.JTBDetalle.getSelectedRow() != -1) {
            int n = JOptionPane.showConfirmDialog(this, "Esta seguro de anular?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                String sql = "update h_atencionesmanuales set Estado=1 where Id = '" + this.JTBDetalle.getValueAt(this.JTBDetalle.getSelectedRow(), 0) + "'";
                this.xconsultasbd.ejecutarSQL(sql);
                this.xconsultasbd.cerrarConexionBd();
                mCrearTabla();
                mCargarDatosTabla();
                return;
            }
            return;
        }
        JOptionPane.showMessageDialog(this, "Debe seleccionar el registroa a eliminar", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
    }
}
