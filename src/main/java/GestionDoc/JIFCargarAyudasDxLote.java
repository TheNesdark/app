package GestionDoc;

import Acceso.Principal;
import General.Persona;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.genoma.plus.jpa.entities.GPersona;
import com.genoma.plus.jpa.entities.HResultadoayudasdx;
import com.genoma.plus.jpa.entities.HTipoAyudaDx;
import com.genoma.plus.jpa.service.HResultadoayudasdxService;
import com.genoma.plus.jpa.service.impl.HResultadoayudasdxServiceImpl;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
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

/* JADX INFO: loaded from: GenomaP.jar:GestionDoc/JIFCargarAyudasDxLote.class */
public class JIFCargarAyudasDxLote extends JInternalFrame {
    private DefaultTableModel modelosuministro;
    private DefaultTableModel modelosuministro1;
    private String[] xidtipoayuda;
    private Object[] dato;
    public Persona xjppersona;
    private File xfile;
    private int xidprofesional;
    private JComboBox JCBTipoAyudaDx;
    public JDateChooser JDCFechaI;
    private JPanel JPIDatosCargar;
    private JScrollPane JSPDetalleConsulta;
    private JScrollPane JSPDetalleConsulta1;
    private JTable JTBDetalle;
    private JTable JTBDetalle1;
    private JFormattedTextField JTFFAcargar;
    private JFormattedTextField JTFFCargardos;
    private JFormattedTextField JTFFNoCargardos;
    private JTextField JTFRuta;
    private JPanel jPanel1;
    private TableColumn column = null;
    private ConsultasMySQL xconsultasbd = new ConsultasMySQL();
    private Metodos xmetodo = new Metodos();
    private long xidusuario = 0;
    private int xnfilasc = 0;
    private int xnfilascn = 0;
    private int xtotalf = 0;
    private final HResultadoayudasdxService hResultadoayudasdxService = (HResultadoayudasdxService) Principal.contexto.getBean(HResultadoayudasdxServiceImpl.class);

    public JIFCargarAyudasDxLote() {
        initComponents();
        this.JDCFechaI.setDate(this.xmetodo.getFechaActual());
        this.xidtipoayuda = this.xconsultasbd.llenarCombo("SELECT Id, Nbre FROM baseserver.h_tipoayudadx WHERE (Estado =0) ORDER BY Nbre ASC", this.xidtipoayuda, this.JCBTipoAyudaDx);
        this.JCBTipoAyudaDx.setSelectedIndex(-1);
        mCrearTabla();
        mCrearTabla1();
        this.xconsultasbd.cerrarConexionBd();
        this.JCBTipoAyudaDx.setSelectedIndex(-1);
    }

    private void initComponents() {
        this.jPanel1 = new JPanel();
        this.JPIDatosCargar = new JPanel();
        this.JDCFechaI = new JDateChooser();
        this.JCBTipoAyudaDx = new JComboBox();
        this.JTFRuta = new JTextField();
        this.JSPDetalleConsulta = new JScrollPane();
        this.JTBDetalle = new JTable();
        this.JSPDetalleConsulta1 = new JScrollPane();
        this.JTBDetalle1 = new JTable();
        this.JTFFAcargar = new JFormattedTextField();
        this.JTFFCargardos = new JFormattedTextField();
        this.JTFFNoCargardos = new JFormattedTextField();
        setClosable(true);
        setIconifiable(true);
        setTitle("CARGAR AYUDAS DX LOTE");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifimportarayudasdxlote");
        setPreferredSize(new Dimension(1032, 830));
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "CARGAR AYUDAS DX", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.jPanel1.setMaximumSize(new Dimension(1000, 700));
        this.jPanel1.setName("jpcargarayudasdxl");
        this.jPanel1.setPreferredSize(new Dimension(1000, 700));
        this.JPIDatosCargar.setBorder(BorderFactory.createTitledBorder((Border) null, "Datos para Cargar", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JDCFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JDCFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDCFechaI.setFont(new Font("Tahoma", 1, 12));
        this.JCBTipoAyudaDx.setFont(new Font("Arial", 1, 12));
        this.JCBTipoAyudaDx.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Ayuda", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ruta (Directorio)", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: GestionDoc.JIFCargarAyudasDxLote.1
            public void mouseClicked(MouseEvent evt) {
                JIFCargarAyudasDxLote.this.JTFRutaMouseClicked(evt);
            }
        });
        GroupLayout JPIDatosCargarLayout = new GroupLayout(this.JPIDatosCargar);
        this.JPIDatosCargar.setLayout(JPIDatosCargarLayout);
        JPIDatosCargarLayout.setHorizontalGroup(JPIDatosCargarLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosCargarLayout.createSequentialGroup().addContainerGap().addComponent(this.JDCFechaI, -2, 139, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBTipoAyudaDx, 0, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFRuta, -2, 458, -2).addContainerGap()));
        JPIDatosCargarLayout.setVerticalGroup(JPIDatosCargarLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosCargarLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosCargarLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosCargarLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBTipoAyudaDx).addComponent(this.JTFRuta, -2, -1, -2)).addComponent(this.JDCFechaI, GroupLayout.Alignment.TRAILING, -2, 50, -2)).addContainerGap()));
        this.JSPDetalleConsulta.setBorder(BorderFactory.createTitledBorder((Border) null, "ARCHIVOS CARGADOS", 2, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.JTBDetalle.setFont(new Font("Arial", 1, 12));
        this.JTBDetalle.setRowHeight(25);
        this.JTBDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTBDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTBDetalle.setSelectionMode(0);
        this.JSPDetalleConsulta.setViewportView(this.JTBDetalle);
        this.JSPDetalleConsulta1.setBorder(BorderFactory.createTitledBorder((Border) null, "ARCHIVOS NO CARGADOS", 2, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.JTBDetalle1.setFont(new Font("Arial", 1, 12));
        this.JTBDetalle1.setRowHeight(25);
        this.JTBDetalle1.setSelectionBackground(new Color(255, 255, 255));
        this.JTBDetalle1.setSelectionForeground(new Color(255, 0, 0));
        this.JTBDetalle1.setSelectionMode(0);
        this.JSPDetalleConsulta1.setViewportView(this.JTBDetalle1);
        this.JTFFAcargar.setEditable(false);
        this.JTFFAcargar.setBorder(BorderFactory.createTitledBorder((Border) null, "Total Archivos a Cargar", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFAcargar.setHorizontalAlignment(4);
        this.JTFFAcargar.setFont(new Font("Arial", 1, 18));
        this.JTFFCargardos.setEditable(false);
        this.JTFFCargardos.setBorder(BorderFactory.createTitledBorder((Border) null, "Total Archivos Cargados", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFCargardos.setHorizontalAlignment(4);
        this.JTFFCargardos.setFont(new Font("Arial", 1, 18));
        this.JTFFNoCargardos.setEditable(false);
        this.JTFFNoCargardos.setBorder(BorderFactory.createTitledBorder((Border) null, "Total Archivos No Cargados", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFNoCargardos.setHorizontalAlignment(4);
        this.JTFFNoCargardos.setFont(new Font("Arial", 1, 18));
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup().addComponent(this.JSPDetalleConsulta, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JSPDetalleConsulta1, -2, -1, -2)).addComponent(this.JPIDatosCargar, -1, -1, 32767)).addContainerGap()).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JTFFAcargar, -2, 185, -2).addGap(18, 18, 18).addComponent(this.JTFFCargardos, -2, 185, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFFNoCargardos, -2, 185, -2).addGap(401, 401, 401)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JPIDatosCargar, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JSPDetalleConsulta1).addComponent(this.JSPDetalleConsulta, -1, 553, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFAcargar, -2, -1, -2).addComponent(this.JTFFCargardos, -2, -1, -2).addComponent(this.JTFFNoCargardos, -2, -1, -2)).addContainerGap(31, 32767)));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -1, 996, 32767).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, 768, -2).addContainerGap(22, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JFileChooser xfilec = new JFileChooser(this.JTFRuta.getText());
            xfilec.setFileSelectionMode(1);
            int xv = xfilec.showOpenDialog(this);
            if (xv == 0) {
                this.xfile = xfilec.getSelectedFile();
                this.JTFRuta.setText(this.xfile.getAbsolutePath());
            }
            String[] ficheros = this.xfile.list();
            if (ficheros != null) {
                for (int x = 0; x <= ficheros.length - 1; x++) {
                    this.xtotalf++;
                }
            }
            this.JTFFAcargar.setValue(Integer.valueOf(this.xtotalf));
        }
    }

    public void recorrerDirectorio() {
        String[] ficheros = this.xfile.list();
        int xacargar = 0;
        int xcargados = 0;
        int xnocargados = 0;
        if (ficheros != null) {
            int y = 1;
            for (int x = 0; x <= ficheros.length - 1; x++) {
                String cad = ficheros[x];
                new StringTokenizer(cad);
                String[] palabra = cad.split("_");
                while (true) {
                    if (0 <= palabra.length - 1) {
                        try {
                            String sql = "SELECT g_usuario.Id_persona FROM baseserver.g_usuario INNER JOIN baseserver.g_persona  ON (g_usuario.Id_persona = g_persona.Id) WHERE (g_usuario.NoHistoria ='" + palabra[0] + "') ";
                            ResultSet rs = this.xconsultasbd.traerRs(sql);
                            if (rs.next()) {
                                this.xidusuario = rs.getLong(1);
                                this.xidprofesional = Integer.valueOf(palabra[2].trim()).intValue();
                                File archivo = new File(this.xfile.getAbsolutePath() + "\\" + ficheros[x]);
                                rs.close();
                                this.xconsultasbd.cerrarConexionBd();
                                mGrabarBlob(archivo);
                                mCargarDatosTabla(ficheros[x]);
                                xcargados++;
                            } else {
                                mCargarDatosTabla1(ficheros[x]);
                                xnocargados++;
                            }
                            int i = 0 + 1;
                        } catch (SQLException ex) {
                            Logger.getLogger(JIFCargarAyudasDxLote.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                        }
                    }
                }
                y++;
                xacargar++;
            }
        }
        this.JTFFCargardos.setValue(Integer.valueOf(xcargados));
        this.JTFFNoCargardos.setValue(Integer.valueOf(xnocargados));
    }

    private void mCrearTabla() {
        this.modelosuministro = new DefaultTableModel();
        this.modelosuministro.addColumn("N°");
        this.modelosuministro.addColumn("Nombre Archivo");
        this.JTBDetalle.setModel(this.modelosuministro);
        this.column = this.JTBDetalle.getColumnModel().getColumn(0);
        this.column.setPreferredWidth(5);
        this.column = this.JTBDetalle.getColumnModel().getColumn(1);
        this.column.setPreferredWidth(300);
        this.xnfilasc = 0;
    }

    private void mCargarDatosTabla(String idh) {
        this.modelosuministro.addRow(this.dato);
        this.modelosuministro.setValueAt(Integer.valueOf(this.xnfilasc + 1), this.xnfilasc, 0);
        this.modelosuministro.setValueAt(idh, this.xnfilasc, 1);
        this.xnfilasc++;
    }

    private void mCrearTabla1() {
        this.modelosuministro1 = new DefaultTableModel();
        this.modelosuministro1.addColumn("N°");
        this.modelosuministro1.addColumn("Nombre Archivo");
        this.JTBDetalle1.setModel(this.modelosuministro1);
        this.column = this.JTBDetalle1.getColumnModel().getColumn(0);
        this.column.setPreferredWidth(5);
        this.column = this.JTBDetalle1.getColumnModel().getColumn(1);
        this.column.setPreferredWidth(300);
        this.xnfilascn = 0;
    }

    private void mCargarDatosTabla1(String idh) {
        this.modelosuministro1.addRow(this.dato);
        this.modelosuministro1.setValueAt(Integer.valueOf(this.xnfilascn + 1), this.xnfilascn, 0);
        this.modelosuministro1.setValueAt(idh, this.xnfilascn, 1);
        this.xnfilascn++;
    }

    public void nuevo() {
        this.JDCFechaI.setDate(this.xmetodo.getFechaActual());
        this.JCBTipoAyudaDx.setSelectedIndex(-1);
        this.JTFRuta.setText((String) null);
        this.JTFFAcargar.setValue(new Integer(0));
        this.JTFFCargardos.setValue(new Integer(0));
        this.JTFFNoCargardos.setValue(new Integer(0));
        mCrearTabla();
        mCrearTabla1();
        this.JCBTipoAyudaDx.requestFocus();
    }

    public void grabar() {
        if (mValidarCampos()) {
            int n = JOptionPane.showConfirmDialog(this, "Esta seguro de guardar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                mCrearTabla();
                mCrearTabla1();
                recorrerDirectorio();
                JOptionPane.showMessageDialog(this, "Se guardo con exito", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            }
        }
    }

    private boolean mValidarCampos() {
        boolean rs = false;
        if (this.JCBTipoAyudaDx.getSelectedIndex() != -1) {
            if (!this.JTFRuta.getText().isEmpty()) {
                rs = true;
            } else {
                JOptionPane.showMessageDialog(this, "Debe seleccionar el arhivo a cargar", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                this.JTFRuta.requestFocus();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un tipo de ayuda dx", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
            this.JCBTipoAyudaDx.requestFocus();
        }
        return rs;
    }

    private void mGrabarBlob(File xarchivo) {
        HTipoAyudaDx ayudaDx = new HTipoAyudaDx();
        ayudaDx.setId(Long.valueOf(this.xidtipoayuda[this.JCBTipoAyudaDx.getSelectedIndex()]));
        GPersona gPersona = new GPersona();
        gPersona.setId(Long.valueOf(this.xidprofesional));
        HResultadoayudasdx hResultadoayudasdx = new HResultadoayudasdx();
        hResultadoayudasdx.setIdUsuario(Long.valueOf(this.xidusuario));
        hResultadoayudasdx.setIdAtencion(0L);
        hResultadoayudasdx.setFechaExamen(this.JDCFechaI.getDate());
        hResultadoayudasdx.setInterpretacion("");
        hResultadoayudasdx.setEstado(true);
        hResultadoayudasdx.setAnulado(0L);
        hResultadoayudasdx.setFecha(this.xmetodo.getFechaActual());
        hResultadoayudasdx.setUsuarios(Principal.usuarioSistemaDTO.getLogin());
        hResultadoayudasdx.setIdUsuarios(Principal.usuarioSistemaDTO.getIdUsuarioSistema());
        if (Principal.informacionIps.getEsFpz().intValue() == 0) {
            hResultadoayudasdx.setUrl(xarchivo.getAbsolutePath());
            this.hResultadoayudasdxService.save(hResultadoayudasdx);
            return;
        }
        File directorio = new File(this.xmetodo.mRutaSoporte("JPEscaneoDocumentosEnf"));
        HResultadoayudasdx hResultadoayudasdx2 = this.hResultadoayudasdxService.save(hResultadoayudasdx);
        String adjunto = hResultadoayudasdx2.getId() + "_" + this.xjppersona.getIdPersona() + "_" + this.JCBTipoAyudaDx.getSelectedItem() + ".pdf";
        hResultadoayudasdx2.setUrl(adjunto);
        this.hResultadoayudasdxService.save(hResultadoayudasdx2);
        File f1 = new File(xarchivo.getAbsolutePath());
        File f2 = new File(adjunto);
        f1.renameTo(f2);
        f2.renameTo(new File(directorio, f2.getName()));
    }
}
