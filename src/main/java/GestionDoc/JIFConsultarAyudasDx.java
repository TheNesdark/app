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
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/* JADX INFO: loaded from: GenomaP.jar:GestionDoc/JIFConsultarAyudasDx.class */
public class JIFConsultarAyudasDx extends JInternalFrame {
    private DefaultTableModel modelosuministro;
    private String[] xidespecialidad;
    private String[] xidtipoayuda;
    private String[] listaAtenciones;
    private Object[] dato;
    public String xidusuario;
    public Persona xjppersona;
    private File xfile;
    private File directorio;
    public JButton JBTRegresa;
    private JComboBox JCBIdAtencion;
    private JComboBox JCBProfesional;
    private JComboBox JCBTipoAyudaDx;
    private JCheckBox JCHAplicaAtencion;
    public JDateChooser JDCFechaI;
    public JDateChooser JDCFechaI1;
    private JPanel JPIDUsuario;
    private JPanel JPIDatosCargar;
    private JScrollPane JSPDetalleConsulta;
    private JTable JTBDetalle;
    private JTextField JTFRuta;
    private JPanel jPanel1;
    private TableColumn column = null;
    private ConsultasMySQL xconsultasbd = new ConsultasMySQL();
    private Metodos xmetodo = new Metodos();

    public JIFConsultarAyudasDx() {
        initComponents();
        Principal.txtNo.setText("");
        mCargarDatosGenerales();
    }

    private void initComponents() {
        this.jPanel1 = new JPanel();
        this.JSPDetalleConsulta = new JScrollPane();
        this.JTBDetalle = new JTable();
        this.JPIDUsuario = new JPanel();
        this.JBTRegresa = new JButton();
        this.JPIDatosCargar = new JPanel();
        this.JDCFechaI = new JDateChooser();
        this.JCBProfesional = new JComboBox();
        this.JCBTipoAyudaDx = new JComboBox();
        this.JTFRuta = new JTextField();
        this.JDCFechaI1 = new JDateChooser();
        this.JCBIdAtencion = new JComboBox();
        this.JCHAplicaAtencion = new JCheckBox();
        setClosable(true);
        setIconifiable(true);
        setTitle("CONSULTAR AYUDAS DX");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifconsultarayudasdx");
        setPreferredSize(new Dimension(1043, 778));
        this.jPanel1.setName("jpcargarayudasdxu");
        this.jPanel1.setLayout((LayoutManager) null);
        this.JSPDetalleConsulta.setBorder(BorderFactory.createTitledBorder((Border) null, "EXÁMENES CARGADOS", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTBDetalle.setFont(new Font("Arial", 1, 12));
        this.JTBDetalle.setRowHeight(25);
        this.JTBDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTBDetalle.setSelectionForeground(Color.red);
        this.JTBDetalle.setSelectionMode(0);
        this.JTBDetalle.addMouseListener(new MouseAdapter() { // from class: GestionDoc.JIFConsultarAyudasDx.1
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarAyudasDx.this.JTBDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalleConsulta.setViewportView(this.JTBDetalle);
        this.jPanel1.add(this.JSPDetalleConsulta);
        this.JSPDetalleConsulta.setBounds(10, 390, 990, 280);
        this.JPIDUsuario.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS DE USUARIO", 0, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        GroupLayout JPIDUsuarioLayout = new GroupLayout(this.JPIDUsuario);
        this.JPIDUsuario.setLayout(JPIDUsuarioLayout);
        JPIDUsuarioLayout.setHorizontalGroup(JPIDUsuarioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 978, 32767));
        JPIDUsuarioLayout.setVerticalGroup(JPIDUsuarioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 165, 32767));
        this.jPanel1.add(this.JPIDUsuario);
        this.JPIDUsuario.setBounds(10, 10, 990, 191);
        this.JBTRegresa.setFont(new Font("Arial", 1, 12));
        this.JBTRegresa.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Deshacer.png")));
        this.JBTRegresa.setText("Regresa");
        this.JBTRegresa.addActionListener(new ActionListener() { // from class: GestionDoc.JIFConsultarAyudasDx.2
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarAyudasDx.this.JBTRegresaActionPerformed(evt);
            }
        });
        this.jPanel1.add(this.JBTRegresa);
        this.JBTRegresa.setBounds(10, 680, 990, 39);
        this.JPIDatosCargar.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS A CARGAR", 1, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JPIDatosCargar.setLayout((LayoutManager) null);
        this.JDCFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDCFechaI.setFont(new Font("Arial", 1, 12));
        this.JPIDatosCargar.add(this.JDCFechaI);
        this.JDCFechaI.setBounds(20, 30, 140, 49);
        this.JCBProfesional.setFont(new Font("Arial", 1, 12));
        this.JCBProfesional.setBorder(BorderFactory.createTitledBorder((Border) null, "Profesional", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JPIDatosCargar.add(this.JCBProfesional);
        this.JCBProfesional.setBounds(170, 30, 470, 47);
        this.JCBTipoAyudaDx.setFont(new Font("Arial", 1, 12));
        this.JCBTipoAyudaDx.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Ayuda", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JPIDatosCargar.add(this.JCBTipoAyudaDx);
        this.JCBTipoAyudaDx.setBounds(650, 30, 300, 47);
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ruta", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: GestionDoc.JIFConsultarAyudasDx.3
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarAyudasDx.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JPIDatosCargar.add(this.JTFRuta);
        this.JTFRuta.setBounds(20, 100, 620, 35);
        this.JDCFechaI1.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 11)));
        this.JDCFechaI1.setDateFormatString("dd/MM/yyyy");
        this.JDCFechaI1.setFont(new Font("Tahoma", 1, 12));
        this.JPIDatosCargar.add(this.JDCFechaI1);
        this.JDCFechaI1.setBounds(20, 30, 120, 48);
        this.JCBIdAtencion.setFont(new Font("Arial", 1, 12));
        this.JCBIdAtencion.setBorder(BorderFactory.createTitledBorder((Border) null, "No Atencion (Opcional)", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JPIDatosCargar.add(this.JCBIdAtencion);
        this.JCBIdAtencion.setBounds(650, 90, 150, 47);
        this.JCHAplicaAtencion.setFont(new Font("Arial", 1, 12));
        this.JCHAplicaAtencion.setForeground(Color.blue);
        this.JCHAplicaAtencion.setText("Atencion relacionada?");
        this.JCHAplicaAtencion.addActionListener(new ActionListener() { // from class: GestionDoc.JIFConsultarAyudasDx.4
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarAyudasDx.this.JCHAplicaAtencionActionPerformed(evt);
            }
        });
        this.JPIDatosCargar.add(this.JCHAplicaAtencion);
        this.JCHAplicaAtencion.setBounds(810, 110, 170, 23);
        this.jPanel1.add(this.JPIDatosCargar);
        this.JPIDatosCargar.setBounds(10, 210, 990, 170);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, 1013, -2).addContainerGap(-1, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, 721, -2).addContainerGap(-1, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBDetalleMouseClicked(MouseEvent evt) {
        if (this.JTBDetalle.getSelectedRow() != -1 && this.JTBDetalle.getValueAt(this.JTBDetalle.getSelectedRow(), 4) != null) {
            if (Principal.informacionIps.getEsFpz().intValue() == 0) {
                this.xmetodo.mostrarPdf(this.modelosuministro.getValueAt(this.JTBDetalle.getSelectedRow(), 4).toString());
            } else {
                this.xmetodo.mostrarPdf(this.directorio + this.xmetodo.getBarra() + this.modelosuministro.getValueAt(this.JTBDetalle.getSelectedRow(), 4).toString());
            }
            Principal.mGrabarLogAtenciones(this.JTBDetalle.getValueAt(this.JTBDetalle.getSelectedRow(), 2).toString().toUpperCase() + " DIGITALIZADO", this.JTBDetalle.getValueAt(this.JTBDetalle.getSelectedRow(), 0).toString(), this.xjppersona.getIdPersona());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTRegresaActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaMouseClicked(MouseEvent evt) {
        JFileChooser xfilec;
        if (evt.getClickCount() == 2) {
            if (Principal.informacionIps.getEsFpz().intValue() == 0) {
                if (Principal.informacionIps.getNombreIps().equals("CLINICA OFTALMOLOGICA DAJUD SAS") || Principal.informacionIps.getNombreIps().equals("JAIME CESAR DAJUD FERNANDEZ") || Principal.informacionIps.getNombreIps().equals("COD-OPTICA UT")) {
                    xfilec = new JFileChooser("S:\\");
                } else {
                    xfilec = new JFileChooser("S:\\GestionDocumental\\Laboratorio");
                }
            } else {
                xfilec = new JFileChooser(this.JTFRuta.getText());
            }
            int xv = xfilec.showOpenDialog(this);
            if (xv == 0) {
                this.xfile = xfilec.getSelectedFile();
                this.JTFRuta.setText(this.xmetodo.mTraerUrlBD(this.xfile.getAbsolutePath()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHAplicaAtencionActionPerformed(ActionEvent evt) {
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
        this.directorio = new File(this.xmetodo.mRutaSoporte("JPEscaneoDocumentosEnf"));
        this.JDCFechaI.setDate(this.xmetodo.getFechaActual());
        this.xidtipoayuda = this.xconsultasbd.llenarCombo("SELECT Id, Nbre FROM  h_tipoayudadx WHERE (Estado =0) ORDER BY Nbre ASC", this.xidtipoayuda, this.JCBTipoAyudaDx);
        this.JCBTipoAyudaDx.setSelectedIndex(-1);
        this.xconsultasbd.cerrarConexionBd();
        this.xidespecialidad = this.xconsultasbd.llenarCombo("SELECT profesional.Id_Persona, profesional.NProfesional FROM  g_profesional  INNER JOIN  profesional  ON (g_profesional.Id_Persona = profesional.Id_Persona) WHERE (g_profesional.Estado =0) ORDER BY profesional.NProfesional ASC", this.xidespecialidad, this.JCBProfesional);
        this.JCBProfesional.setSelectedIndex(-1);
        this.xconsultasbd.cerrarConexionBd();
        mCargarPanelUsuario();
        this.JBTRegresa.setVisible(true);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTabla() {
        this.modelosuministro = new DefaultTableModel(new Object[0], new String[]{"Id", "Fecha", "Tipo", "Profesional", "URL", "No. Atencion"}) { // from class: GestionDoc.JIFConsultarAyudasDx.5
            Class[] types = {Long.class, String.class, String.class, String.class, String.class, Long.class};
            boolean[] canEdit = {false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTBDetalle.setModel(this.modelosuministro);
        this.JTBDetalle.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTBDetalle.getColumnModel().getColumn(1).setPreferredWidth(20);
        this.JTBDetalle.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTBDetalle.getColumnModel().getColumn(3).setPreferredWidth(200);
        this.JTBDetalle.getColumnModel().getColumn(4).setPreferredWidth(50);
        this.JTBDetalle.getColumnModel().getColumn(5).setPreferredWidth(10);
    }

    public void mCargarDatosTabla() {
        try {
            String sql = "SELECT h_resultadoayudasdx.Id , DATE_FORMAT(h_resultadoayudasdx.Fecha_Examen, '%d-%m-%Y') as fecha, h_tipoayudadx.Nbre , profesional.NProfesional, h_resultadoayudasdx.Url, h_resultadoayudasdx.IdAtencion FROM  h_resultadoayudasdx INNER JOIN  h_tipoayudadx  ON (h_resultadoayudasdx.Id_TipoAyudaDX = h_tipoayudadx.Id) INNER JOIN  profesional  ON (profesional.Id_Persona = h_resultadoayudasdx.Id_Profesional) WHERE (h_resultadoayudasdx.Id_Usuario ='" + this.xjppersona.getIdPersona() + "' and h_resultadoayudasdx.Anulado=0) order by h_tipoayudadx.Nbre, h_resultadoayudasdx.Fecha_Examen ";
            ResultSet rs = this.xconsultasbd.traerRs(sql);
            mCrearTabla();
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
                    this.modelosuministro.setValueAt(rs.getString(5), i, 4);
                    this.modelosuministro.setValueAt(Long.valueOf(rs.getLong("IdAtencion")), i, 5);
                    i++;
                }
            }
            rs.close();
            this.xconsultasbd.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFConsultarAyudasDx.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void listarAtenciones() {
        this.JCBIdAtencion.removeAllItems();
        String sql = "SELECT h_atencion.Id, h_atencion.Id FROM \n`h_atencion`\nINNER JOIN ingreso ON (`ingreso`.`Id`=`h_atencion`.`Id_Ingreso`)\n WHERE (ingreso.`Id_MotivoAnulacion`=1 AND ingreso.Estado=0 AND ingreso.Id_Usuario=" + this.xjppersona.getIdPersona() + ")\nORDER BY h_atencion.Id DESC";
        this.listaAtenciones = this.xconsultasbd.llenarCombo(sql, this.listaAtenciones, this.JCBIdAtencion);
        this.JCBIdAtencion.setSelectedIndex(-1);
    }

    public void nuevo() {
        this.directorio = new File(this.xmetodo.mRutaSoporte("JPEscaneoDocumentosEnf"));
        this.xjppersona.nuevo();
        Principal.txtNo.setText("");
        this.JDCFechaI.setDate(this.xmetodo.getFechaActual());
        this.JCBProfesional.setSelectedIndex(-1);
        this.JCBTipoAyudaDx.setSelectedIndex(-1);
        this.JCHAplicaAtencion.setSelected(false);
        this.JCBIdAtencion.removeAllItems();
        this.JCBIdAtencion.setSelectedIndex(-1);
        this.JTFRuta.setText((String) null);
        mCrearTabla();
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
                    if (this.JCBTipoAyudaDx.getSelectedIndex() != -1) {
                        if (!this.JTFRuta.getText().isEmpty()) {
                            if (!this.JCHAplicaAtencion.isSelected() || this.JCBIdAtencion.getSelectedIndex() != -1) {
                                rs = true;
                            } else {
                                JOptionPane.showMessageDialog(this, "Debe seleccionar un Ingreso relacionado", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                                this.JCBIdAtencion.requestFocus();
                            }
                        } else {
                            JOptionPane.showMessageDialog(this, "Debe seleccionar el arhivo a cargar", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                            this.JCBTipoAyudaDx.requestFocus();
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "Debe seleccionar un tipo de ayuda dx", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                        this.JCBTipoAyudaDx.requestFocus();
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
            JOptionPane.showMessageDialog(this, "Registro ya grabado", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
        }
        return rs;
    }

    private void mGrabarBlob() {
        if (mValidarCampos()) {
            int n = JOptionPane.showConfirmDialog(this, "Esta seguro de guardar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                long idAtencion = 0;
                if (this.JCHAplicaAtencion.isSelected() && this.JCBIdAtencion.getSelectedIndex() != -1) {
                    idAtencion = Long.valueOf(this.listaAtenciones[this.JCBIdAtencion.getSelectedIndex()]).longValue();
                }
                if (Principal.informacionIps.getEsFpz().intValue() == 0) {
                    String sql = "insert into h_resultadoayudasdx (Id_Usuario, Fecha_Examen, IdAtencion, Id_TipoAyudaDX, Id_Profesional, Url, Fecha, Id_UsuarioS, UsuarioS)  values('" + this.xjppersona.getIdPersona() + "','" + this.xmetodo.formatoAMD.format(this.JDCFechaI.getDate()) + "','" + idAtencion + "','" + this.xidtipoayuda[this.JCBTipoAyudaDx.getSelectedIndex()] + "','" + this.xidespecialidad[this.JCBProfesional.getSelectedIndex()] + "','" + this.JTFRuta.getText() + "','" + this.xmetodo.formatoAMDH24.format(this.xmetodo.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                    Principal.txtNo.setText(this.xconsultasbd.ejecutarSQLId(sql));
                    this.xconsultasbd.cerrarConexionBd();
                } else {
                    this.directorio = new File(this.xmetodo.mRutaSoporte("JPEscaneoDocumentosEnf"));
                    String sql2 = "insert into h_resultadoayudasdx (Id_Usuario, Fecha_Examen, IdAtencion, Id_TipoAyudaDX, Id_Profesional, Fecha, Id_UsuarioS, UsuarioS)  values('" + this.xjppersona.getIdPersona() + "','" + this.xmetodo.formatoAMD.format(this.JDCFechaI.getDate()) + "','" + idAtencion + "','" + this.xidtipoayuda[this.JCBTipoAyudaDx.getSelectedIndex()] + "','" + this.xidespecialidad[this.JCBProfesional.getSelectedIndex()] + "','" + this.xmetodo.formatoAMDH24.format(this.xmetodo.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                    String xidDoc = this.xconsultasbd.ejecutarSQLId(sql2);
                    String adjunto = xidDoc + "_" + this.xjppersona.getIdPersona() + "_" + this.JCBTipoAyudaDx.getSelectedItem() + ".pdf";
                    String sql3 = "UPDATE h_resultadoayudasdx set Url='" + this.xmetodo.mTraerUrlBD(adjunto) + "' WHERE Id='" + xidDoc + "'";
                    this.xconsultasbd.ejecutarSQL(sql3);
                    this.xconsultasbd.cerrarConexionBd();
                    File f1 = new File(this.JTFRuta.getText());
                    File f2 = new File(adjunto);
                    f1.renameTo(f2);
                    f2.renameTo(new File(this.directorio, f2.getName()));
                    Principal.txtNo.setText(xidDoc);
                }
                mCargarDatosTabla();
                JOptionPane.showMessageDialog(this, "Se guardo con exito", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            }
        }
    }

    public void eliminar() {
        if (this.JTBDetalle.getSelectedRow() != -1 && this.JTBDetalle.getValueAt(this.JTBDetalle.getSelectedRow(), 0) != null) {
            int n = JOptionPane.showConfirmDialog(this, "Esta seguro de anular?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                String sql = "update  h_resultadoayudasdx set Anulado=1 where Id = '" + this.JTBDetalle.getValueAt(this.JTBDetalle.getSelectedRow(), 0) + "'";
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
