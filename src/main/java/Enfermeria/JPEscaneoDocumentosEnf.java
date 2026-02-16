package Enfermeria;

import Acceso.Principal;
import GestionDoc.JIFConsultarAyudasDx;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.Toolkit;
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
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/* JADX INFO: loaded from: GenomaP.jar:Enfermeria/JPEscaneoDocumentosEnf.class */
public class JPEscaneoDocumentosEnf extends JPanel {
    private DefaultTableModel modelosuministro;
    private String[] xidespecialidad;
    private String[] xidtipoayuda;
    private Object[] dato;
    public String xidUsuario;
    public String xidAtencion;
    private File xfile;
    private File directorio;
    private JComboBox JCBProfesional;
    private JComboBox JCBTipoAyudaDx;
    public JDateChooser JDCFechaI;
    public JDateChooser JDCFechaI1;
    private JPanel JPIDatosCargar;
    private JScrollPane JSPDetalleConsulta;
    private JTable JTBDetalle;
    private JTextField JTFRuta;
    private TableColumn column = null;
    private ConsultasMySQL xconsultasbd = new ConsultasMySQL();
    private Metodos xmt = new Metodos();

    public JPEscaneoDocumentosEnf(String xidUsuario, String xidAtencion) {
        initComponents();
        this.xidUsuario = xidUsuario;
        this.xidAtencion = xidAtencion;
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.modelosuministro = new DefaultTableModel(new Object[0], new String[]{"Id", "Fecha", "Tipo", "Profesional", "URL"}) { // from class: Enfermeria.JPEscaneoDocumentosEnf.1
            Class[] types = {Long.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false};

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
    }

    public void mCargarDatosTabla() {
        try {
            String sql = "SELECT h_resultadoayudasdx.Id , DATE_FORMAT(h_resultadoayudasdx.Fecha_Examen, '%d-%m-%Y') as fecha, h_tipoayudadx.Nbre , profesional.NProfesional, h_resultadoayudasdx.Url FROM  h_resultadoayudasdx INNER JOIN  h_tipoayudadx  ON (h_resultadoayudasdx.Id_TipoAyudaDX = h_tipoayudadx.Id) INNER JOIN  profesional  ON (profesional.Id_Persona = h_resultadoayudasdx.Id_Profesional) WHERE (h_resultadoayudasdx.Id_Usuario ='" + this.xidUsuario + "' and h_resultadoayudasdx.Anulado=0) order by h_tipoayudadx.Nbre, h_resultadoayudasdx.Fecha_Examen ";
            ResultSet rs = this.xconsultasbd.traerRs(sql);
            mCrearModeloDatos();
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
                    i++;
                }
            }
            rs.close();
            this.xconsultasbd.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFConsultarAyudasDx.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mNuevo() {
        this.directorio = new File(this.xmt.mRutaSoporte("JPEscaneoDocumentosEnf"));
        this.JDCFechaI.setDate(this.xmt.getFechaActual());
        this.xidtipoayuda = this.xconsultasbd.llenarCombo("SELECT Id, Nbre FROM  h_tipoayudadx WHERE (Estado =0) ORDER BY Nbre ASC", this.xidtipoayuda, this.JCBTipoAyudaDx);
        this.JCBTipoAyudaDx.setSelectedIndex(-1);
        this.xconsultasbd.cerrarConexionBd();
        this.xidespecialidad = this.xconsultasbd.llenarCombo("SELECT profesional.Id_Persona, profesional.NProfesional FROM  g_profesional  INNER JOIN  profesional  ON (g_profesional.Id_Persona = profesional.Id_Persona) WHERE (g_profesional.Estado =0) ORDER BY profesional.NProfesional ASC", this.xidespecialidad, this.JCBProfesional);
        this.JCBProfesional.setSelectedIndex(-1);
        this.xconsultasbd.cerrarConexionBd();
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion());
        mCargarDatosTabla();
    }

    public void mGrabar() {
        mGrabarBlob();
    }

    private boolean mValidarCampos() {
        boolean rs = false;
        if (!this.xidUsuario.isEmpty() || !this.xidUsuario.equals("0")) {
            if (this.JCBProfesional.getSelectedIndex() != -1) {
                if (this.JCBTipoAyudaDx.getSelectedIndex() != -1) {
                    if (!this.JTFRuta.getText().isEmpty()) {
                        rs = true;
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
        }
        return rs;
    }

    private void mGrabarBlob() {
        if (mValidarCampos()) {
            int n = JOptionPane.showConfirmDialog(this, "Esta seguro de guardar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                this.directorio = new File(this.xmt.mRutaSoporte("JPEscaneoDocumentosEnf"));
                String sql = "insert into h_resultadoayudasdx (Id_Usuario, Fecha_Examen, IdAtencion, Id_TipoAyudaDX, Id_Profesional, Fecha, Id_UsuarioS, UsuarioS)  values('" + this.xidUsuario + "','" + this.xmt.formatoAMD.format(this.JDCFechaI.getDate()) + "','" + this.xidAtencion + "','" + this.xidtipoayuda[this.JCBTipoAyudaDx.getSelectedIndex()] + "','" + this.xidespecialidad[this.JCBProfesional.getSelectedIndex()] + "','" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                String xidDoc = this.xconsultasbd.ejecutarSQLId(sql);
                String adjunto = xidDoc + "_" + this.xidUsuario + "_" + this.JCBTipoAyudaDx.getSelectedItem() + ".pdf";
                String sql2 = "UPDATE h_resultadoayudasdx set Url='" + this.xmt.mTraerUrlBD(adjunto) + "' WHERE Id='" + xidDoc + "'";
                this.xconsultasbd.ejecutarSQL(sql2);
                this.xconsultasbd.cerrarConexionBd();
                File f1 = new File(this.JTFRuta.getText());
                File f2 = new File(adjunto);
                f1.renameTo(f2);
                f2.renameTo(new File(this.directorio, f2.getName()));
                this.xconsultasbd.cerrarConexionBd();
                mNuevo();
            }
        }
    }

    public void mAnular() {
        if (this.JTBDetalle.getSelectedRow() != -1 && this.JTBDetalle.getValueAt(this.JTBDetalle.getSelectedRow(), 0) != null) {
            int n = JOptionPane.showConfirmDialog(this, "Esta seguro de anular?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                String sql = "update  h_resultadoayudasdx set Anulado=1 where Id = '" + this.JTBDetalle.getValueAt(this.JTBDetalle.getSelectedRow(), 0) + "'";
                this.xconsultasbd.ejecutarSQL(sql);
                this.xconsultasbd.cerrarConexionBd();
                mCargarDatosTabla();
                return;
            }
            return;
        }
        JOptionPane.showMessageDialog(this, "Debe seleccionar el registroa a eliminar", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
    }

    private void initComponents() {
        this.JPIDatosCargar = new JPanel();
        this.JDCFechaI = new JDateChooser();
        this.JCBProfesional = new JComboBox();
        this.JCBTipoAyudaDx = new JComboBox();
        this.JTFRuta = new JTextField();
        this.JDCFechaI1 = new JDateChooser();
        this.JSPDetalleConsulta = new JScrollPane();
        this.JTBDetalle = new JTable();
        setName("xjpescaneodocumentosenf");
        this.JPIDatosCargar.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS A CARGAR", 1, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JPIDatosCargar.setLayout((LayoutManager) null);
        this.JDCFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDCFechaI.setFont(new Font("Arial", 1, 12));
        this.JPIDatosCargar.add(this.JDCFechaI);
        this.JDCFechaI.setBounds(20, 30, 140, 46);
        this.JCBProfesional.setFont(new Font("Arial", 1, 12));
        this.JCBProfesional.setBorder(BorderFactory.createTitledBorder((Border) null, "Profesional", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JPIDatosCargar.add(this.JCBProfesional);
        this.JCBProfesional.setBounds(170, 30, 310, 43);
        this.JCBTipoAyudaDx.setFont(new Font("Arial", 1, 12));
        this.JCBTipoAyudaDx.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Ayuda", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JPIDatosCargar.add(this.JCBTipoAyudaDx);
        this.JCBTipoAyudaDx.setBounds(490, 30, 320, 43);
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ruta", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: Enfermeria.JPEscaneoDocumentosEnf.2
            public void mouseClicked(MouseEvent evt) {
                JPEscaneoDocumentosEnf.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JPIDatosCargar.add(this.JTFRuta);
        this.JTFRuta.setBounds(20, 100, 790, 41);
        this.JDCFechaI1.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 11)));
        this.JDCFechaI1.setDateFormatString("dd/MM/yyyy");
        this.JDCFechaI1.setFont(new Font("Tahoma", 1, 12));
        this.JPIDatosCargar.add(this.JDCFechaI1);
        this.JDCFechaI1.setBounds(20, 30, 120, 45);
        this.JSPDetalleConsulta.setBorder(BorderFactory.createTitledBorder((Border) null, "EXÁMENES CARGADOS", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTBDetalle.setFont(new Font("Arial", 1, 12));
        this.JTBDetalle.setRowHeight(25);
        this.JTBDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTBDetalle.setSelectionForeground(Color.red);
        this.JTBDetalle.addMouseListener(new MouseAdapter() { // from class: Enfermeria.JPEscaneoDocumentosEnf.3
            public void mouseClicked(MouseEvent evt) {
                JPEscaneoDocumentosEnf.this.JTBDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalleConsulta.setViewportView(this.JTBDetalle);
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPDetalleConsulta, -1, 827, 32767).addComponent(this.JPIDatosCargar, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatosCargar, -2, 157, -2).addGap(10, 10, 10).addComponent(this.JSPDetalleConsulta, -2, 287, -2).addContainerGap()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JFileChooser xfilec = new JFileChooser(this.JTFRuta.getText());
            int xv = xfilec.showOpenDialog(this);
            if (xv == 0) {
                this.xfile = xfilec.getSelectedFile();
                this.JTFRuta.setText(this.xmt.mTraerUrlBD(this.xfile.getAbsolutePath()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBDetalleMouseClicked(MouseEvent evt) {
        if (this.JTBDetalle.getSelectedRow() != -1 && this.JTBDetalle.getValueAt(this.JTBDetalle.getSelectedRow(), 4) != null) {
            this.xmt.mostrarPdf(this.directorio + "\\" + this.modelosuministro.getValueAt(this.JTBDetalle.getSelectedRow(), 4).toString());
            Principal.mGrabarLogAtenciones(this.JTBDetalle.getValueAt(this.JTBDetalle.getSelectedRow(), 2).toString().toUpperCase() + " DIGITALIZADO", this.JTBDetalle.getValueAt(this.JTBDetalle.getSelectedRow(), 0).toString(), this.xidUsuario);
        }
    }
}
