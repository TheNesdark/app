package Historia;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JYearChooser;
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
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Historia/JPARevisionAyudasDxRx.class */
public class JPARevisionAyudasDxRx extends JPanel {
    private String xnombre;
    private DefaultTableModel xmodelo;
    private DefaultTableModel xmodelo1;
    private Object[] xdato;
    private clasesHistoriaCE xclase;
    private JButton JBTGuardarTemporal;
    private JComboBox JCBResultado;
    private JCheckBox JCHFiltro;
    private JPanel JPIDRevisionExa;
    private JPanel JPIRevisionExa;
    private JScrollPane JSPInterpretacion;
    private JScrollPane JSPRevisionExa;
    private JTable JTBRevisionExa;
    private JTextField JTFNombre;
    private JTextPane JTPInterpretacion;
    private JYearChooser JYAno;
    private ConsultasMySQL xconsultasbd = new ConsultasMySQL();
    private Metodos xmetodo = new Metodos();
    private int xestado = 0;

    public JPARevisionAyudasDxRx(clasesHistoriaCE xclase, String xnombre) {
        initComponents();
        this.xclase = xclase;
        this.xnombre = xnombre;
        mCrearTablaExamen();
        mCargarExamenes();
    }

    /* JADX WARN: Type inference failed for: r3v8, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPIRevisionExa = new JPanel();
        this.JPIDRevisionExa = new JPanel();
        this.JTFNombre = new JTextField();
        this.JCHFiltro = new JCheckBox();
        this.JSPRevisionExa = new JScrollPane();
        this.JTBRevisionExa = new JTable();
        this.JBTGuardarTemporal = new JButton();
        this.JSPInterpretacion = new JScrollPane();
        this.JTPInterpretacion = new JTextPane();
        this.JYAno = new JYearChooser();
        this.JCBResultado = new JComboBox();
        setMaximumSize(null);
        setName("jpayudasdxrx");
        setRequestFocusEnabled(false);
        this.JPIDRevisionExa.setBorder(BorderFactory.createTitledBorder((Border) null, "IMAGENES DIAGNÓSTICAS", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTFNombre.setFont(new Font("Arial", 1, 12));
        this.JTFNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFNombre.addKeyListener(new KeyAdapter() { // from class: Historia.JPARevisionAyudasDxRx.1
            public void keyPressed(KeyEvent evt) {
                JPARevisionAyudasDxRx.this.JTFNombreKeyPressed(evt);
            }

            public void keyTyped(KeyEvent evt) {
                JPARevisionAyudasDxRx.this.JTFNombreKeyTyped(evt);
            }
        });
        this.JCHFiltro.setFont(new Font("Arial", 1, 12));
        this.JCHFiltro.setForeground(Color.blue);
        this.JCHFiltro.setText("Filtro");
        this.JCHFiltro.addActionListener(new ActionListener() { // from class: Historia.JPARevisionAyudasDxRx.2
            public void actionPerformed(ActionEvent evt) {
                JPARevisionAyudasDxRx.this.JCHFiltroActionPerformed(evt);
            }
        });
        this.JTBRevisionExa.setFont(new Font("Arial", 1, 12));
        this.JTBRevisionExa.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTBRevisionExa.setRowHeight(25);
        this.JTBRevisionExa.setSelectionBackground(new Color(255, 255, 255));
        this.JTBRevisionExa.setSelectionForeground(new Color(255, 0, 0));
        this.JTBRevisionExa.setSelectionMode(0);
        this.JTBRevisionExa.addMouseListener(new MouseAdapter() { // from class: Historia.JPARevisionAyudasDxRx.3
            public void mouseClicked(MouseEvent evt) {
                JPARevisionAyudasDxRx.this.JTBRevisionExaMouseClicked(evt);
            }
        });
        this.JSPRevisionExa.setViewportView(this.JTBRevisionExa);
        GroupLayout JPIDRevisionExaLayout = new GroupLayout(this.JPIDRevisionExa);
        this.JPIDRevisionExa.setLayout(JPIDRevisionExaLayout);
        JPIDRevisionExaLayout.setHorizontalGroup(JPIDRevisionExaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDRevisionExaLayout.createSequentialGroup().addContainerGap().addGroup(JPIDRevisionExaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDRevisionExaLayout.createSequentialGroup().addComponent(this.JTFNombre, -1, 702, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHFiltro).addContainerGap()).addGroup(JPIDRevisionExaLayout.createSequentialGroup().addComponent(this.JSPRevisionExa, -2, 757, -2).addGap(0, 0, 32767)))));
        JPIDRevisionExaLayout.setVerticalGroup(JPIDRevisionExaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDRevisionExaLayout.createSequentialGroup().addGroup(JPIDRevisionExaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFNombre).addComponent(this.JCHFiltro)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPRevisionExa, -2, 150, -2).addContainerGap()));
        this.JBTGuardarTemporal.setFont(new Font("Arial", 1, 14));
        this.JBTGuardarTemporal.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Grabar29x27.png")));
        this.JBTGuardarTemporal.setText("Guardar");
        this.JBTGuardarTemporal.setEnabled(false);
        this.JBTGuardarTemporal.addActionListener(new ActionListener() { // from class: Historia.JPARevisionAyudasDxRx.4
            public void actionPerformed(ActionEvent evt) {
                JPARevisionAyudasDxRx.this.JBTGuardarTemporalActionPerformed(evt);
            }
        });
        this.JBTGuardarTemporal.addKeyListener(new KeyAdapter() { // from class: Historia.JPARevisionAyudasDxRx.5
            public void keyPressed(KeyEvent evt) {
                JPARevisionAyudasDxRx.this.JBTGuardarTemporalKeyPressed(evt);
            }
        });
        this.JSPInterpretacion.setBorder(BorderFactory.createTitledBorder((Border) null, "INTERPRETACIÓN", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTPInterpretacion.setEditable(false);
        this.JTPInterpretacion.addKeyListener(new KeyAdapter() { // from class: Historia.JPARevisionAyudasDxRx.6
            public void keyPressed(KeyEvent evt) {
                JPARevisionAyudasDxRx.this.JTPInterpretacionKeyPressed(evt);
            }
        });
        this.JSPInterpretacion.setViewportView(this.JTPInterpretacion);
        this.JYAno.setBorder(BorderFactory.createTitledBorder((Border) null, "Año", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JYAno.setFont(new Font("Arial", 1, 12));
        this.JYAno.addPropertyChangeListener(new PropertyChangeListener() { // from class: Historia.JPARevisionAyudasDxRx.7
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JPARevisionAyudasDxRx.this.JYAnoPropertyChange(evt);
            }
        });
        this.JCBResultado.setFont(new Font("Arial", 1, 12));
        this.JCBResultado.setModel(new DefaultComboBoxModel(new String[]{" ", "SIN HALLAZGO", "LLAMATIVA"}));
        this.JCBResultado.setBorder(BorderFactory.createTitledBorder((Border) null, "Resultado", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        GroupLayout JPIRevisionExaLayout = new GroupLayout(this.JPIRevisionExa);
        this.JPIRevisionExa.setLayout(JPIRevisionExaLayout);
        JPIRevisionExaLayout.setHorizontalGroup(JPIRevisionExaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIRevisionExaLayout.createSequentialGroup().addContainerGap().addGroup(JPIRevisionExaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPIDRevisionExa, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addGroup(GroupLayout.Alignment.TRAILING, JPIRevisionExaLayout.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.JYAno, -2, 82, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTGuardarTemporal, -2, 691, -2)).addGroup(GroupLayout.Alignment.TRAILING, JPIRevisionExaLayout.createSequentialGroup().addComponent(this.JCBResultado, 0, 186, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPInterpretacion, -2, 593, -2))).addContainerGap()));
        JPIRevisionExaLayout.setVerticalGroup(JPIRevisionExaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIRevisionExaLayout.createSequentialGroup().addContainerGap().addComponent(this.JPIDRevisionExa, -2, -1, -2).addGroup(JPIRevisionExaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIRevisionExaLayout.createSequentialGroup().addGap(7, 7, 7).addComponent(this.JSPInterpretacion, -2, 110, -2)).addGroup(JPIRevisionExaLayout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBResultado, -2, 50, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 22, 32767).addGroup(JPIRevisionExaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JBTGuardarTemporal, -1, 69, 32767).addComponent(this.JYAno, -1, 69, 32767)).addContainerGap()));
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.JPIRevisionExa, -2, -1, -2).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIRevisionExa, -2, -1, -2).addContainerGap(20, 32767)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTPInterpretacionKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 9) {
            this.JTPInterpretacion.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBRevisionExaMouseClicked(MouseEvent evt) {
        if (this.JTBRevisionExa.getSelectedRow() != -1) {
            if (this.xmodelo.getValueAt(this.JTBRevisionExa.getSelectedRow(), 5).toString().equals("")) {
                this.JTPInterpretacion.setText((String) null);
                this.JTPInterpretacion.setEditable(true);
                this.JBTGuardarTemporal.setEnabled(true);
            } else {
                this.JTPInterpretacion.setText(this.xmodelo.getValueAt(this.JTBRevisionExa.getSelectedRow(), 5).toString());
                this.JTPInterpretacion.setEditable(false);
                this.JBTGuardarTemporal.setEnabled(false);
            }
            String urlImagen = this.xmetodo.mRutaSoporte("jpayudasdxrx_imagenDicom");
            String urlLectura = this.xmetodo.mRutaSoporte("jpayudasdxrx_lectura");
            if (urlImagen.isEmpty() && urlLectura.isEmpty()) {
                if (urlImagen.isEmpty() || !urlLectura.isEmpty()) {
                    this.xmetodo.mostrarPdf(getUrlRutaLecturaPdf(urlLectura));
                    return;
                }
                if (!urlImagen.isEmpty() || urlLectura.isEmpty()) {
                    if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL LOCAL DE MONTELIBANO")) {
                        mSeleccionMod(urlImagen);
                        return;
                    } else {
                        mAbrirArchivo(urlImagen);
                        return;
                    }
                }
                return;
            }
            Object[] botones = {"Imagen", "Lectura", "Cerrar"};
            int n = JOptionPane.showInternalOptionDialog(this, "Que desea visualizar", "IMPRIMIR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), botones, "Cerrar");
            if (n == 0) {
                if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL LOCAL DE MONTELIBANO")) {
                    mSeleccionMod(urlImagen);
                    return;
                } else {
                    mAbrirArchivo(urlImagen);
                    return;
                }
            }
            if (n == 1) {
                this.xmetodo.mostrarPdf(getUrlRutaLecturaPdf(urlLectura));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTGuardarTemporalActionPerformed(ActionEvent evt) {
        mGrabarBd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTGuardarTemporalKeyPressed(KeyEvent evt) {
        mGrabarBd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNombreKeyPressed(KeyEvent evt) {
        if (!this.JTFNombre.getText().isEmpty()) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNombreKeyTyped(KeyEvent evt) {
        if (!this.JTFNombre.getText().isEmpty()) {
            mCargarExamenes();
        } else {
            mCrearTablaExamen();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHFiltroActionPerformed(ActionEvent evt) {
        if (this.JCHFiltro.isSelected()) {
            if (!this.JTFNombre.getText().isEmpty()) {
                mCargarExamenes();
                return;
            } else {
                mCrearTablaExamen();
                return;
            }
        }
        if (!this.JTFNombre.getText().isEmpty()) {
            mCargarExamenes();
        } else {
            mCrearTablaExamen();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JYAnoPropertyChange(PropertyChangeEvent evt) {
        mCargarExamenes();
    }

    private String getUrlRutaLecturaPdf(String ruta) {
        String urlLectura = ruta + this.xmetodo.getBarra() + this.xmodelo.getValueAt(this.JTBRevisionExa.getSelectedRow(), 0).toString() + this.xmetodo.getBarra() + this.xmodelo.getValueAt(this.JTBRevisionExa.getSelectedRow(), 0).toString() + ".pdf";
        return urlLectura;
    }

    private void mAbrirArchivo(String ruta) {
        try {
            String rutaAplicativo = this.xmetodo.mRutaSoporte("jpayudasdxrx_rutaMicrodicom");
            String rutaRecepcion = ruta + this.xmetodo.getBarra() + this.xmodelo.getValueAt(this.JTBRevisionExa.getSelectedRow(), 0).toString() + this.xmetodo.getBarra() + "Vol1";
            System.err.println("ruta --> " + ruta + this.xmetodo.getBarra() + this.xmodelo.getValueAt(this.JTBRevisionExa.getSelectedRow(), 0).toString() + this.xmetodo.getBarra() + "Vol1");
            File f = new File(ruta + this.xmetodo.getBarra() + this.xmodelo.getValueAt(this.JTBRevisionExa.getSelectedRow(), 0).toString() + this.xmetodo.getBarra() + "Vol1");
            if (f.exists()) {
                System.err.println("entro al if --> ");
                File[] ficheros = f.listFiles();
                if (ficheros != null) {
                    System.err.println("ruta --> " + rutaAplicativo + rutaRecepcion);
                    Runtime.getRuntime().exec(rutaAplicativo + rutaRecepcion);
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(JPARevisionAyudasDxRx.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mSeleccionMod(String ruta) {
        Object[] botones = {"MicroDICOM", "PDIVIEW", "Cerrar"};
        int n = JOptionPane.showInternalOptionDialog(this, "Que aplicativo desea utilizar", "VISUALIZAR", 0, 3, (Icon) null, botones, "Cerrar");
        if (n == 0) {
            mAbrirArchivo(ruta);
        } else if (n == 1) {
            mAbrirArchivo_VisorPDIVIEW();
        }
    }

    private void mAbrirArchivo_VisorPDIVIEW() {
        try {
            String[] xid = {this.xmetodo.mTraerUrlBD(this.xmodelo.getValueAt(this.JTBRevisionExa.getSelectedRow(), 6).toString())};
            Runtime.getRuntime().exec("C:\\Genoma\\Visor_PDIVIEW\\PDIVIEW.exe  ", xid, new File(this.xmetodo.mTraerUrlBD(this.xmodelo.getValueAt(this.JTBRevisionExa.getSelectedRow(), 6).toString())));
        } catch (IOException ex) {
            Logger.getLogger(JPARevisionAyudasDxRx.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mGrabarBd() {
        if (!this.JTPInterpretacion.getText().isEmpty()) {
            if (this.JTBRevisionExa.getSelectedRow() != -1) {
                String sql = "update h_radiologia_detalle set Id_Atencion='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "', Resultado='" + this.JCBResultado.getSelectedItem() + "', Observacion='" + this.JTPInterpretacion.getText() + "' where Id_radiologia='" + this.xmodelo.getValueAt(this.JTBRevisionExa.getSelectedRow(), 0).toString() + "' and Id_Procedimiento='" + this.xmodelo.getValueAt(this.JTBRevisionExa.getSelectedRow(), 8).toString() + "'";
                this.xconsultasbd.ejecutarSQL(sql);
                this.xconsultasbd.cerrarConexionBd();
                mCargarExamenes();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un examen a revisar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTBRevisionExa.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "La interpretacion no puede ser nula", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JTBRevisionExa.requestFocus();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTablaExamen() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Fecha", "Procedimiento", "Especialidad", "Profesional", "Interpretación", "Url_Estudio", "Url_Lectura", "IdProcedimiento", "Resultado", "IdLecturaR"}) { // from class: Historia.JPARevisionAyudasDxRx.8
            Class[] types = {Long.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Long.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTBRevisionExa.setAutoResizeMode(0);
        this.JTBRevisionExa.doLayout();
        this.JTBRevisionExa.setModel(this.xmodelo);
        this.JTBRevisionExa.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTBRevisionExa.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTBRevisionExa.getColumnModel().getColumn(2).setPreferredWidth(300);
        this.JTBRevisionExa.getColumnModel().getColumn(3).setPreferredWidth(200);
        this.JTBRevisionExa.getColumnModel().getColumn(4).setPreferredWidth(200);
        this.JTBRevisionExa.getColumnModel().getColumn(5).setPreferredWidth(0);
        this.JTBRevisionExa.getColumnModel().getColumn(5).setMinWidth(0);
        this.JTBRevisionExa.getColumnModel().getColumn(5).setMaxWidth(0);
        this.JTBRevisionExa.getColumnModel().getColumn(6).setPreferredWidth(0);
        this.JTBRevisionExa.getColumnModel().getColumn(6).setMinWidth(0);
        this.JTBRevisionExa.getColumnModel().getColumn(6).setMaxWidth(0);
        this.JTBRevisionExa.getColumnModel().getColumn(7).setPreferredWidth(0);
        this.JTBRevisionExa.getColumnModel().getColumn(7).setMinWidth(0);
        this.JTBRevisionExa.getColumnModel().getColumn(7).setMaxWidth(0);
        this.JTBRevisionExa.getColumnModel().getColumn(8).setPreferredWidth(0);
        this.JTBRevisionExa.getColumnModel().getColumn(8).setMinWidth(0);
        this.JTBRevisionExa.getColumnModel().getColumn(8).setMaxWidth(0);
        this.JTBRevisionExa.getColumnModel().getColumn(9).setPreferredWidth(0);
        this.JTBRevisionExa.getColumnModel().getColumn(9).setMinWidth(0);
        this.JTBRevisionExa.getColumnModel().getColumn(9).setMaxWidth(0);
        this.JTBRevisionExa.getColumnModel().getColumn(10).setPreferredWidth(0);
        this.JTBRevisionExa.getColumnModel().getColumn(10).setMinWidth(0);
        this.JTBRevisionExa.getColumnModel().getColumn(10).setMaxWidth(0);
    }

    private void mCargarExamenes() {
        String sql;
        mCrearTablaExamen();
        int m = 0;
        this.xmetodo.mRutaSoporte("jpayudasdxrx");
        ConsultasMySQL xct = new ConsultasMySQL();
        if (Principal.informacionIps.getNombreIps().equals("E.S.E CAMU IRIS LOPEZ DURAN DE SAN ANTERO")) {
            if (this.JCHFiltro.isSelected()) {
                sql = "SELECT `h_radiologia`.`Id`, DATE_FORMAT(`h_radiologia`.`Fecha_Rec`,'%d-%m-%Y') AS `Fecha`, `g_procedimiento`.`Nbre`, `profesional1`.`Especialidad`, `profesional1`.`NProfesional` , IF(`h_radiologia_detalle`.`Observacion` IS NULL,'',`h_radiologia_detalle`.`Observacion`)  AS `Interpretacion`, `h_radiologia`.`Url_Estudio` As Estudio, `h_radiologia`.`Url_Lectura`, `h_radiologia_detalle`.Id_Procedimiento,`h_radiologia_detalle`.Resultado, IF(h_radiologia_lectura_encabezado.`Id` IS NULL,0, h_radiologia_detalle.Id) IdLecturaS  FROM  `h_radiologia_detalle` INNER JOIN  `h_radiologia`  ON (`h_radiologia_detalle`.`Id_radiologia` = `h_radiologia`.`Id`)  LEFT JOIN `h_radiologia_lectura_encabezado` ON (`h_radiologia_detalle`.`Id` = `h_radiologia_lectura_encabezado`.`Id_Radiologia`) AND (h_radiologia_lectura_encabezado.`Estado`=1) INNER JOIN  `g_procedimiento`  ON (`h_radiologia_detalle`.`Id_Procedimiento` = `g_procedimiento`.`Id`) INNER JOIN  `f_ordenes`  ON (`f_ordenes`.`Id` = `h_radiologia`.`Id_OrdenFac`) INNER JOIN  `ingreso`  ON (`f_ordenes`.`Id_Ingreso` = `ingreso`.`Id`) INNER JOIN  `profesional1`  ON (`profesional1`.`Id_Persona` = `f_ordenes`.`Id_Profesional`) AND (`profesional1`.`IdEspecialidad` = `f_ordenes`.`Id_Especialidad`) WHERE (`g_procedimiento`.`Nbre` '" + this.JTFNombre.getText() + "%' AND `ingreso`.`Id_Usuario` ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "' AND DATE_FORMAT(`h_radiologia`.`Fecha_Rec`,'%Y') ='" + this.JYAno.getValue() + "') ORDER BY `Fecha` DESC, `g_procedimiento`.`Nbre` ASC ";
            } else {
                sql = "SELECT `h_radiologia`.`Id`, DATE_FORMAT(`h_radiologia`.`Fecha_Rec`,'%d-%m-%Y') AS `Fecha`, `g_procedimiento`.`Nbre`, `profesional1`.`Especialidad`, `profesional1`.`NProfesional` , IF(`h_radiologia_detalle`.`Observacion` IS NULL,'',`h_radiologia_detalle`.`Observacion`)  AS `Interpretacion`, `h_radiologia`.`Url_Estudio` As Estudio, `h_radiologia`.`Url_Lectura`, `h_radiologia_detalle`.Id_Procedimiento,`h_radiologia_detalle`.Resultado, IF(h_radiologia_lectura_encabezado.`Id` IS NULL,0, h_radiologia_detalle.Id) IdLecturaS FROM  `h_radiologia_detalle` INNER JOIN  `h_radiologia`  ON (`h_radiologia_detalle`.`Id_radiologia` = `h_radiologia`.`Id`)  LEFT JOIN `h_radiologia_lectura_encabezado` ON (`h_radiologia_detalle`.`Id` = `h_radiologia_lectura_encabezado`.`Id_Radiologia`) AND (h_radiologia_lectura_encabezado.`Estado`=1) INNER JOIN  `g_procedimiento`  ON (`h_radiologia_detalle`.`Id_Procedimiento` = `g_procedimiento`.`Id`) INNER JOIN  `f_ordenes`  ON (`f_ordenes`.`Id` = `h_radiologia`.`Id_OrdenFac`) INNER JOIN  `ingreso`  ON (`f_ordenes`.`Id_Ingreso` = `ingreso`.`Id`) INNER JOIN  `profesional1`  ON (`profesional1`.`Id_Persona` = `f_ordenes`.`Id_Profesional`) AND (`profesional1`.`IdEspecialidad` = `f_ordenes`.`Id_Especialidad`) WHERE ( `ingreso`.`Id_Usuario` ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "' AND DATE_FORMAT(`h_radiologia`.`Fecha_Rec`,'%Y') ='" + this.JYAno.getValue() + "') ORDER BY `Fecha` DESC, `g_procedimiento`.`Nbre` ASC ";
            }
        } else if (this.JCHFiltro.isSelected()) {
            sql = "SELECT `h_radiologia`.`Id`, DATE_FORMAT(`h_radiologia`.`Fecha_Rec`,'%d-%m-%Y') AS `Fecha`, `g_procedimiento`.`Nbre`, `profesional1`.`Especialidad`, `profesional1`.`NProfesional` , IF(`h_radiologia_detalle`.`Observacion` IS NULL,'',`h_radiologia_detalle`.`Observacion`)  AS `Interpretacion`, IF(`h_radiologia`.`Url_Estudio` ='',`h_radiologia`.`Url_Estudio`,LEFT(`h_radiologia`.`Url_Estudio`,(LENGTH(`h_radiologia`.`Url_Estudio`)-8) )) as Estudio, `h_radiologia`.`Url_Lectura`, `h_radiologia_detalle`.Id_Procedimiento,`h_radiologia_detalle`.Resultado, IF(h_radiologia_lectura_encabezado.`Id` IS NULL,0, h_radiologia_detalle.Id) IdLecturaS  FROM  `h_radiologia_detalle` INNER JOIN  `h_radiologia`  ON (`h_radiologia_detalle`.`Id_radiologia` = `h_radiologia`.`Id`)  LEFT JOIN `h_radiologia_lectura_encabezado` ON (`h_radiologia_detalle`.`Id` = `h_radiologia_lectura_encabezado`.`Id_Radiologia`) AND (h_radiologia_lectura_encabezado.`Estado`=1) INNER JOIN  `g_procedimiento`  ON (`h_radiologia_detalle`.`Id_Procedimiento` = `g_procedimiento`.`Id`) INNER JOIN  `f_ordenes`  ON (`f_ordenes`.`Id` = `h_radiologia`.`Id_OrdenFac`) INNER JOIN  `ingreso`  ON (`f_ordenes`.`Id_Ingreso` = `ingreso`.`Id`) INNER JOIN  `profesional1`  ON (`profesional1`.`Id_Persona` = `f_ordenes`.`Id_Profesional`) AND (`profesional1`.`IdEspecialidad` = `f_ordenes`.`Id_Especialidad`) WHERE (`g_procedimiento`.`Nbre` '" + this.JTFNombre.getText() + "%' AND `ingreso`.`Id_Usuario` ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "' AND DATE_FORMAT(`h_radiologia`.`Fecha_Rec`,'%Y') ='" + this.JYAno.getValue() + "') ORDER BY `Fecha` DESC, `g_procedimiento`.`Nbre` ASC ";
        } else {
            sql = "SELECT `h_radiologia`.`Id`, DATE_FORMAT(`h_radiologia`.`Fecha_Rec`,'%d-%m-%Y') AS `Fecha`, `g_procedimiento`.`Nbre`, `profesional1`.`Especialidad`, `profesional1`.`NProfesional` , IF(`h_radiologia_detalle`.`Observacion` IS NULL,'',`h_radiologia_detalle`.`Observacion`)  AS `Interpretacion`, IF(`h_radiologia`.`Url_Estudio` ='',`h_radiologia`.`Url_Estudio`,LEFT(`h_radiologia`.`Url_Estudio`,(LENGTH(`h_radiologia`.`Url_Estudio`)-8) )) As Estudio, `h_radiologia`.`Url_Lectura`, `h_radiologia_detalle`.Id_Procedimiento,`h_radiologia_detalle`.Resultado, IF(h_radiologia_lectura_encabezado.`Id` IS NULL,0, h_radiologia_detalle.Id) IdLecturaS FROM  `h_radiologia_detalle` INNER JOIN  `h_radiologia`  ON (`h_radiologia_detalle`.`Id_radiologia` = `h_radiologia`.`Id`)  LEFT JOIN `h_radiologia_lectura_encabezado` ON (`h_radiologia_detalle`.`Id` = `h_radiologia_lectura_encabezado`.`Id_Radiologia`) AND (h_radiologia_lectura_encabezado.`Estado`=1) INNER JOIN  `g_procedimiento`  ON (`h_radiologia_detalle`.`Id_Procedimiento` = `g_procedimiento`.`Id`) INNER JOIN  `f_ordenes`  ON (`f_ordenes`.`Id` = `h_radiologia`.`Id_OrdenFac`) INNER JOIN  `ingreso`  ON (`f_ordenes`.`Id_Ingreso` = `ingreso`.`Id`) INNER JOIN  `profesional1`  ON (`profesional1`.`Id_Persona` = `f_ordenes`.`Id_Profesional`) AND (`profesional1`.`IdEspecialidad` = `f_ordenes`.`Id_Especialidad`) WHERE ( `ingreso`.`Id_Usuario` ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "' AND DATE_FORMAT(`h_radiologia`.`Fecha_Rec`,'%Y') ='" + this.JYAno.getValue() + "') ORDER BY `Fecha` DESC, `g_procedimiento`.`Nbre` ASC ";
        }
        ResultSet rs = xct.traerRs(sql);
        System.out.println(" Uno : " + sql);
        try {
            if (rs.next()) {
                rs.beforeFirst();
                while (rs.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.JTBRevisionExa.setValueAt(Long.valueOf(rs.getLong(1)), m, 0);
                    this.JTBRevisionExa.setValueAt(rs.getString(2), m, 1);
                    this.JTBRevisionExa.setValueAt(rs.getString(3), m, 2);
                    this.JTBRevisionExa.setValueAt(rs.getString(4), m, 3);
                    this.JTBRevisionExa.setValueAt(rs.getString(5), m, 4);
                    this.JTBRevisionExa.setValueAt(rs.getString(6), m, 5);
                    this.JTBRevisionExa.setValueAt(rs.getString(8), m, 7);
                    this.JTBRevisionExa.setValueAt(rs.getString(9), m, 8);
                    this.JTBRevisionExa.setValueAt(rs.getString(10), m, 9);
                    this.JTBRevisionExa.setValueAt(Long.valueOf(rs.getLong("IdLecturaS")), m, 10);
                    this.JTBRevisionExa.setDefaultRenderer(Object.class, new MiRender());
                    m++;
                }
            }
            rs.close();
            xct.cerrarConexionBd();
        } catch (SQLException e) {
        }
    }

    /* JADX INFO: loaded from: GenomaP.jar:Historia/JPARevisionAyudasDxRx$MiRender.class */
    public class MiRender extends DefaultTableCellRenderer {
        public MiRender() {
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (!table.getValueAt(row, 5).toString().equals("")) {
                cell.setBackground(new Color(103, 0, 103));
                cell.setForeground(Color.WHITE);
            }
            return cell;
        }
    }
}
