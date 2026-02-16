package Laboratorio;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import Utilidades.WorkerSQL;
import com.genoma.plus.controller.laboratorio.dto.CustomPresenter;
import com.genoma.plus.domains.models.domains.general.RecursosMicroserviciosDomain;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

/* JADX INFO: loaded from: GenomaP.jar:Laboratorio/JIFExportacionDatos.class */
public class JIFExportacionDatos extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private Object[] xdato;
    private String xsql;
    private String[][] xidequipo;
    private String[] xidsede;
    private String xnombre;
    private String xEquipo;
    private WorkerSQL xWorkerSQL;
    private ButtonGroup JBGEstado;
    private JButton JBTEnviar;
    private JButton JBTExportar;
    private JComboBox JCBEquipo;
    private JComboBox JCBSede;
    private JCheckBox JCHSeleccionar;
    private JDateChooser JDFechaF;
    private JDateChooser JDFechaI;
    private JPanel JPEstado;
    private JPanel JPIDatosC;
    private JPanel JPIDatosExportacion;
    private JRadioButton JRBMunicipio;
    private JRadioButton JRBPendientes;
    private JRadioButton JRBProcesado;
    private JRadioButton JRBSede;
    private JRadioButton JRBTipoAtencion;
    private JRadioButton JRBTodo;
    private JRadioButton JRBTodos1;
    private JScrollPane JSPDetalle;
    private JTable JTBDetalle;
    private JTextField JTFFiltroUsuario;
    private JFormattedTextField JTFNRegistro;
    private JTextField JTFRuta;
    private JTabbedPane JTPOpciones;
    private ButtonGroup buttonGroup1;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private Metodos xmt = new Metodos();
    private ConsultasMySQL xct = new ConsultasMySQL();
    private boolean xlleno = false;
    private String xEstado = "0,1";
    ArrayList array = new ArrayList();
    HashSet hs = new HashSet();

    public JIFExportacionDatos(String xnombre, String xEquipo) {
        initComponents();
        this.xnombre = xnombre;
        this.xEquipo = xEquipo;
        setTitle(xnombre.toUpperCase());
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v56, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.buttonGroup1 = new ButtonGroup();
        this.JBGEstado = new ButtonGroup();
        this.JPIDatosC = new JPanel();
        this.JDFechaI = new JDateChooser();
        this.JDFechaF = new JDateChooser();
        this.JCBEquipo = new JComboBox();
        this.JCBSede = new JComboBox();
        this.jPanel1 = new JPanel();
        this.JRBMunicipio = new JRadioButton();
        this.JRBSede = new JRadioButton();
        this.JRBTodo = new JRadioButton();
        this.JRBTipoAtencion = new JRadioButton();
        this.JSPDetalle = new JScrollPane();
        this.JTBDetalle = new JTable();
        this.JTPOpciones = new JTabbedPane();
        this.JPIDatosExportacion = new JPanel();
        this.JTFRuta = new JTextField();
        this.JBTExportar = new JButton();
        this.JCHSeleccionar = new JCheckBox();
        this.JBTEnviar = new JButton();
        this.JTFNRegistro = new JFormattedTextField();
        this.JPEstado = new JPanel();
        this.JRBProcesado = new JRadioButton();
        this.JRBPendientes = new JRadioButton();
        this.JRBTodos1 = new JRadioButton();
        this.jPanel2 = new JPanel();
        this.JTFFiltroUsuario = new JTextField();
        setClosable(true);
        setIconifiable(true);
        setTitle("EXPORTACIÓN");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjifexportaciond");
        this.JPIDatosC.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JDFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFechaI.setFont(new Font("Arial", 1, 12));
        this.JDFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Fin", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFechaF.setFont(new Font("Arial", 1, 12));
        this.JCBEquipo.setFont(new Font("Arial", 1, 12));
        this.JCBEquipo.setBorder(BorderFactory.createTitledBorder((Border) null, "Equipo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBEquipo.addItemListener(new ItemListener() { // from class: Laboratorio.JIFExportacionDatos.1
            public void itemStateChanged(ItemEvent evt) {
                JIFExportacionDatos.this.JCBEquipoItemStateChanged(evt);
            }
        });
        this.JCBSede.setFont(new Font("Arial", 1, 12));
        this.JCBSede.setBorder(BorderFactory.createTitledBorder((Border) null, "Sede", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBSede.addActionListener(new ActionListener() { // from class: Laboratorio.JIFExportacionDatos.2
            public void actionPerformed(ActionEvent evt) {
                JIFExportacionDatos.this.JCBSedeActionPerformed(evt);
            }
        });
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "FILTRO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.buttonGroup1.add(this.JRBMunicipio);
        this.JRBMunicipio.setFont(new Font("Arial", 1, 12));
        this.JRBMunicipio.setText("Municipio");
        this.JRBMunicipio.addActionListener(new ActionListener() { // from class: Laboratorio.JIFExportacionDatos.3
            public void actionPerformed(ActionEvent evt) {
                JIFExportacionDatos.this.JRBMunicipioActionPerformed(evt);
            }
        });
        this.buttonGroup1.add(this.JRBSede);
        this.JRBSede.setFont(new Font("Arial", 1, 12));
        this.JRBSede.setText("Sede");
        this.JRBSede.addActionListener(new ActionListener() { // from class: Laboratorio.JIFExportacionDatos.4
            public void actionPerformed(ActionEvent evt) {
                JIFExportacionDatos.this.JRBSedeActionPerformed(evt);
            }
        });
        this.buttonGroup1.add(this.JRBTodo);
        this.JRBTodo.setFont(new Font("Arial", 1, 12));
        this.JRBTodo.setSelected(true);
        this.JRBTodo.setText("Todo");
        this.JRBTodo.addActionListener(new ActionListener() { // from class: Laboratorio.JIFExportacionDatos.5
            public void actionPerformed(ActionEvent evt) {
                JIFExportacionDatos.this.JRBTodoActionPerformed(evt);
            }
        });
        this.buttonGroup1.add(this.JRBTipoAtencion);
        this.JRBTipoAtencion.setFont(new Font("Arial", 1, 12));
        this.JRBTipoAtencion.setText("Tipo Atencion");
        this.JRBTipoAtencion.addActionListener(new ActionListener() { // from class: Laboratorio.JIFExportacionDatos.6
            public void actionPerformed(ActionEvent evt) {
                JIFExportacionDatos.this.JRBTipoAtencionActionPerformed(evt);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.JRBMunicipio).addGap(18, 18, 18).addComponent(this.JRBSede).addGap(18, 18, 18).addComponent(this.JRBTipoAtencion).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBTodo).addGap(10, 10, 10)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBMunicipio).addComponent(this.JRBSede).addComponent(this.JRBTodo).addComponent(this.JRBTipoAtencion)).addGap(10, 10, 10)));
        GroupLayout JPIDatosCLayout = new GroupLayout(this.JPIDatosC);
        this.JPIDatosC.setLayout(JPIDatosCLayout);
        JPIDatosCLayout.setHorizontalGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosCLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosCLayout.createSequentialGroup().addComponent(this.jPanel1, -2, -1, -2).addGap(0, 0, 32767)).addGroup(JPIDatosCLayout.createSequentialGroup().addComponent(this.JDFechaI, -2, 114, -2).addGap(18, 18, 18).addComponent(this.JDFechaF, -2, 114, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBEquipo, -2, 308, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBSede, 0, -1, 32767))).addContainerGap()));
        JPIDatosCLayout.setVerticalGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosCLayout.createSequentialGroup().addGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JDFechaI, -2, 50, -2).addComponent(this.JDFechaF, -2, 50, -2)).addGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBEquipo, -2, 50, -2).addComponent(this.JCBSede, -2, 50, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel1, -2, -1, -2)));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.JTBDetalle.setFont(new Font("Arial", 1, 12));
        this.JTBDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTBDetalle.setRowHeight(25);
        this.JTBDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTBDetalle.setSelectionForeground(Color.red);
        this.JTBDetalle.setSelectionMode(0);
        this.JTBDetalle.addMouseListener(new MouseAdapter() { // from class: Laboratorio.JIFExportacionDatos.7
            public void mouseClicked(MouseEvent evt) {
                JIFExportacionDatos.this.JTBDetalleMouseClicked(evt);
            }
        });
        this.JTBDetalle.addPropertyChangeListener(new PropertyChangeListener() { // from class: Laboratorio.JIFExportacionDatos.8
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFExportacionDatos.this.JTBDetallePropertyChange(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTBDetalle);
        this.JTPOpciones.setForeground(Color.red);
        this.JTPOpciones.setFont(new Font("Arial", 1, 14));
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Program Files (x86)\\A25\\Import\\Import");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ruta", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: Laboratorio.JIFExportacionDatos.9
            public void mouseClicked(MouseEvent evt) {
                JIFExportacionDatos.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/actualizar.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: Laboratorio.JIFExportacionDatos.10
            public void actionPerformed(ActionEvent evt) {
                JIFExportacionDatos.this.JBTExportarActionPerformed(evt);
            }
        });
        this.JCHSeleccionar.setFont(new Font("Arial", 1, 12));
        this.JCHSeleccionar.setText("Seleccionar todo?");
        this.JCHSeleccionar.addActionListener(new ActionListener() { // from class: Laboratorio.JIFExportacionDatos.11
            public void actionPerformed(ActionEvent evt) {
                JIFExportacionDatos.this.JCHSeleccionarActionPerformed(evt);
            }
        });
        this.JBTEnviar.setFont(new Font("Arial", 1, 12));
        this.JBTEnviar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/enviar.png")));
        this.JBTEnviar.setText("Enviar Orden");
        this.JBTEnviar.addActionListener(new ActionListener() { // from class: Laboratorio.JIFExportacionDatos.12
            public void actionPerformed(ActionEvent evt) {
                JIFExportacionDatos.this.JBTEnviarActionPerformed(evt);
            }
        });
        this.JTFNRegistro.setBorder(BorderFactory.createTitledBorder((Border) null, "Nº Registro", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFNRegistro.setHorizontalAlignment(4);
        this.JTFNRegistro.setText("0");
        this.JTFNRegistro.setFont(new Font("Arial", 1, 12));
        this.JPEstado.setBorder(BorderFactory.createTitledBorder((Border) null, "ESTADO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JBGEstado.add(this.JRBProcesado);
        this.JRBProcesado.setFont(new Font("Arial", 1, 12));
        this.JRBProcesado.setText("Procesados");
        this.JRBProcesado.addActionListener(new ActionListener() { // from class: Laboratorio.JIFExportacionDatos.13
            public void actionPerformed(ActionEvent evt) {
                JIFExportacionDatos.this.JRBProcesadoActionPerformed(evt);
            }
        });
        this.JBGEstado.add(this.JRBPendientes);
        this.JRBPendientes.setFont(new Font("Arial", 1, 12));
        this.JRBPendientes.setText("Pendientes");
        this.JRBPendientes.addActionListener(new ActionListener() { // from class: Laboratorio.JIFExportacionDatos.14
            public void actionPerformed(ActionEvent evt) {
                JIFExportacionDatos.this.JRBPendientesActionPerformed(evt);
            }
        });
        this.JBGEstado.add(this.JRBTodos1);
        this.JRBTodos1.setFont(new Font("Arial", 1, 12));
        this.JRBTodos1.setSelected(true);
        this.JRBTodos1.setText("Todo");
        this.JRBTodos1.addActionListener(new ActionListener() { // from class: Laboratorio.JIFExportacionDatos.15
            public void actionPerformed(ActionEvent evt) {
                JIFExportacionDatos.this.JRBTodos1ActionPerformed(evt);
            }
        });
        GroupLayout JPEstadoLayout = new GroupLayout(this.JPEstado);
        this.JPEstado.setLayout(JPEstadoLayout);
        JPEstadoLayout.setHorizontalGroup(JPEstadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPEstadoLayout.createSequentialGroup().addContainerGap().addComponent(this.JRBProcesado).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBPendientes).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBTodos1).addContainerGap(23, 32767)));
        JPEstadoLayout.setVerticalGroup(JPEstadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPEstadoLayout.createSequentialGroup().addGroup(JPEstadoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBProcesado).addComponent(this.JRBPendientes).addComponent(this.JRBTodos1)).addGap(10, 10, 10)));
        GroupLayout JPIDatosExportacionLayout = new GroupLayout(this.JPIDatosExportacion);
        this.JPIDatosExportacion.setLayout(JPIDatosExportacionLayout);
        JPIDatosExportacionLayout.setHorizontalGroup(JPIDatosExportacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosExportacionLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosExportacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosExportacionLayout.createSequentialGroup().addComponent(this.JTFRuta, -2, 392, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBTExportar, -2, 128, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTEnviar).addGap(18, 18, 18).addComponent(this.JCHSeleccionar).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFNRegistro, -2, 119, -2)).addComponent(this.JPEstado, -2, -1, -2)).addContainerGap(15, 32767)));
        JPIDatosExportacionLayout.setVerticalGroup(JPIDatosExportacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosExportacionLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosExportacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosExportacionLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFRuta, -2, 50, -2).addComponent(this.JBTExportar, -2, 50, -2).addComponent(this.JBTEnviar, -2, 50, -2).addComponent(this.JTFNRegistro, -2, 50, -2)).addComponent(this.JCHSeleccionar)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPEstado, -2, -1, -2).addContainerGap()));
        this.JTPOpciones.addTab("DATOS PARA LA EXPORTACIÓN", this.JPIDatosExportacion);
        this.JTFFiltroUsuario.setFont(new Font("Arial", 1, 12));
        this.JTFFiltroUsuario.setBorder(BorderFactory.createTitledBorder((Border) null, "Filtrar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFiltroUsuario.addMouseListener(new MouseAdapter() { // from class: Laboratorio.JIFExportacionDatos.16
            public void mouseClicked(MouseEvent evt) {
                JIFExportacionDatos.this.JTFFiltroUsuarioMouseClicked(evt);
            }
        });
        this.JTFFiltroUsuario.addKeyListener(new KeyAdapter() { // from class: Laboratorio.JIFExportacionDatos.17
            public void keyPressed(KeyEvent evt) {
                JIFExportacionDatos.this.JTFFiltroUsuarioKeyPressed(evt);
            }
        });
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(this.JTFFiltroUsuario, -1, 959, 32767).addContainerGap()));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(this.JTFFiltroUsuario, -2, 50, -2).addContainerGap(97, 32767)));
        this.JTPOpciones.addTab("BUSQUEDA POR USUARIO", this.jPanel2);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPIDatosC, -1, -1, 32767).addComponent(this.JSPDetalle).addComponent(this.JTPOpciones)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatosC, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalle, -2, 339, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTPOpciones, -2, 191, -2).addGap(10, 10, 10)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JFileChooser xfilec = new JFileChooser(this.JTFRuta.getText());
            xfilec.setFileSelectionMode(1);
            int xv = xfilec.showOpenDialog(this);
            if (xv == 0) {
                File xfile = xfilec.getSelectedFile();
                this.JTFRuta.setText(xfile.getAbsolutePath() + this.xmt.getBarra());
                this.JTFRuta.requestFocus();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTExportarActionPerformed(ActionEvent evt) {
        if (this.JTFRuta.getText().isEmpty()) {
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un ruta valida", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTFRuta.requestFocus();
        }
        if (this.JTBDetalle.getRowCount() == -1) {
            JOptionPane.showInternalMessageDialog(this, "No existe información para exportar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        if (!this.xmt.mVerificarDatosTablaTrue(this.JTBDetalle, 8)) {
            JOptionPane.showInternalMessageDialog(this, "No existe información seleccionada para exportar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (x == 0) {
            switch (this.JCBEquipo.getSelectedItem().toString()) {
                case "AUTOPLEX":
                    mExportar_Autoplex();
                    break;
                case "DL-96II":
                    for (int i = 0; i < this.JTBDetalle.getRowCount(); i++) {
                        if (Boolean.valueOf(this.xmodelo.getValueAt(i, 8).toString()).booleanValue()) {
                            mExportar_DL96II(this.JTBDetalle.getValueAt(i, 5).toString(), i);
                        }
                    }
                    mBuscar();
                    break;
                case "DL-96II V2":
                    for (int i2 = 0; i2 < this.JTBDetalle.getRowCount(); i2++) {
                        if (Boolean.valueOf(this.xmodelo.getValueAt(i2, 8).toString()).booleanValue()) {
                            Map<String, String> objMap = new HashMap<>();
                            objMap.put("idReception", this.JTBDetalle.getValueAt(i2, 5).toString());
                            objMap.put("noDocumento", this.JTBDetalle.getValueAt(i2, 1).toString());
                            objMap.put("nombre", this.JTBDetalle.getValueAt(i2, 11).toString());
                            objMap.put("apellido", this.JTBDetalle.getValueAt(i2, 12).toString());
                            if (this.JTBDetalle.getValueAt(i2, 18).toString().equals("F")) {
                                objMap.put("genero", "Mujer");
                            } else if (this.JTBDetalle.getValueAt(i2, 18).toString().equals("M")) {
                                objMap.put("genero", "Hombre");
                            } else {
                                objMap.put("genero", "");
                            }
                            objMap.put("edad", this.xmt.CalcularEdadAnos(this.JTBDetalle.getValueAt(i2, 17).toString()).toString());
                            objMap.put("fechaNacimiento", this.JTBDetalle.getValueAt(i2, 17).toString());
                            objMap.put("fechaOrden", this.JTBDetalle.getValueAt(i2, 0).toString());
                            objMap.put("tipoMuestra", "Orina");
                            RecursosMicroserviciosDomain microserviciosDomain = this.xmt.getParametrosEncriptados("24", "uploadOrderLisDL96II");
                            if (microserviciosDomain.getUrlRecurso() != null && !microserviciosDomain.getUrlRecurso().isEmpty()) {
                                CompletableFuture<CustomPresenter> future = sendPostApi(microserviciosDomain.getUrlRecurso(), objMap);
                                try {
                                    CustomPresenter response = future.join();
                                    if (response != null) {
                                        System.out.println("Respuesta recibida: " + response.getMessage());
                                        mActualizarEnviOrden(this.xmodelo.getValueAt(x, 5).toString(), this.xmodelo.getValueAt(x, 15).toString());
                                    }
                                } catch (Exception e) {
                                    System.out.println("Error al enviar el POST: " + e);
                                }
                            }
                        }
                        mBuscar();
                    }
                    break;
                case "WIENER LAB CM250":
                    for (int i3 = 0; i3 < this.JTBDetalle.getRowCount(); i3++) {
                        if (Boolean.valueOf(this.xmodelo.getValueAt(i3, 8).toString()).booleanValue()) {
                            mExportar_CM250(i3);
                        }
                    }
                    mBuscar();
                    break;
                default:
                    mExportar();
                    mBuscar();
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHSeleccionarActionPerformed(ActionEvent evt) {
        if (this.JCHSeleccionar.isSelected()) {
            this.JCHSeleccionar.setText("Quitar seleccion?");
            mDesact_Activar(true);
        } else {
            this.JCHSeleccionar.setText("Seleccionar todo?");
            mDesact_Activar(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBEquipoItemStateChanged(ItemEvent evt) {
        if (this.xlleno && this.JCBEquipo.getSelectedIndex() != -1) {
            if (this.JCBEquipo.getSelectedItem().equals("AUTOPLEX")) {
                this.JTFRuta.setText(this.xidequipo[this.JCBEquipo.getSelectedIndex()][1] + "\\" + this.xmt.formatoDMAH24_Unida.format(this.xmt.getFechaActual()) + ".LIS");
            } else {
                this.JTFRuta.setText(this.xidequipo[this.JCBEquipo.getSelectedIndex()][1]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBSedeActionPerformed(ActionEvent evt) {
        this.JCBSede.setBorder(BorderFactory.createTitledBorder((Border) null, "Sede", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBSede.removeAllItems();
        this.xsql = "SELECT\n\tgs.Id,\n\tgs.Nbre\nFROM\n\tl_recepcion lr\nINNER JOIN g_sedes gs ON\n\tgs.Id = lr.Id_Sede\nWHERE\n\tlr.Estado = 0\n\tAND DATE_FORMAT(lr.FechaRecep, '%Y-%m-%d') BETWEEN '" + this.xmt.formatoAMD1.format(this.JDFechaI.getDate()) + "' AND '" + this.xmt.formatoAMD1.format(this.JDFechaF.getDate()) + "'\nGROUP BY\n\tgs.Id\nORDER BY\n\tgs.Nbre ASC";
        this.xidsede = this.xct.llenarCombo(this.xsql, this.xidsede, this.JCBSede);
        this.JCBSede.setEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBMunicipioActionPerformed(ActionEvent evt) {
        this.JCBSede.setEnabled(true);
        this.JCBSede.setBorder(BorderFactory.createTitledBorder((Border) null, "Municipio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBSede.removeAllItems();
        this.xsql = "SELECT\n\tgm.Id,\n\tgm.Nbre\nFROM\n\tl_recepcion lr\nINNER JOIN g_persona gp ON\n\tgp.Id = lr.Id_Paciente\nINNER JOIN g_municipio gm ON\n\tgm.Id = gp.Id_Municipio\nWHERE\n\tlr.Estado = 0\n\tAND DATE_FORMAT(lr.FechaRecep, '%Y-%m-%d') BETWEEN '" + this.xmt.formatoAMD1.format(this.JDFechaI.getDate()) + "' AND '" + this.xmt.formatoAMD1.format(this.JDFechaF.getDate()) + "'\nGROUP BY\n\tgm.Id\nORDER BY\n\tgm.Nbre ASC";
        this.xidsede = this.xct.llenarCombo(this.xsql, this.xidsede, this.JCBSede);
        this.JCBSede.setSelectedIndex(-1);
        this.JCBSede.setEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBTodoActionPerformed(ActionEvent evt) {
        this.JCBSede.removeAllItems();
        this.JCBSede.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBSedeActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTEnviarActionPerformed(ActionEvent evt) {
        this.xWorkerSQL = null;
        this.xWorkerSQL = new WorkerSQL("Enviando la Informacion...", this);
        this.xWorkerSQL.execute();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBProcesadoActionPerformed(ActionEvent evt) {
        this.xEstado = "1";
        mBuscar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBPendientesActionPerformed(ActionEvent evt) {
        this.xEstado = "0";
        mBuscar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBTodos1ActionPerformed(ActionEvent evt) {
        this.xEstado = "0,1";
        mBuscar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFiltroUsuarioMouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFiltroUsuarioKeyPressed(KeyEvent evt) {
        mBuscar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBTipoAtencionActionPerformed(ActionEvent evt) {
        this.JCBSede.setEnabled(true);
        this.JCBSede.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo de Atencion", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBSede.removeAllItems();
        this.xsql = "SELECT\n\tgt.Id,\n\tgt.Nbre\nFROM\n\tl_recepcion lr\nINNER JOIN f_ordenes fo ON\n\tfo.Id = lr.Id_OrdenFacturac\nINNER JOIN ingreso i ON\n\ti.Id = fo.Id_Ingreso\nINNER JOIN g_tipoatencion gt ON\n\tgt.Id = i.Id_TipoAtencion\nWHERE\n\tlr.Estado =0\n\tAND DATE_FORMAT(lr.FechaRecep, '%Y-%m-%d') BETWEEN '" + this.xmt.formatoAMD1.format(this.JDFechaI.getDate()) + "' AND '" + this.xmt.formatoAMD1.format(this.JDFechaF.getDate()) + "'\nGROUP BY\n\tgt.Id\nORDER BY\n\tgt.Nbre ASC";
        this.xidsede = this.xct.llenarCombo(this.xsql, this.xidsede, this.JCBSede);
        this.JCBSede.setSelectedIndex(-1);
        this.JCBSede.setEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBDetalleMouseClicked(MouseEvent evt) {
        if (this.JTBDetalle.getRowCount() != 0 && this.JTBDetalle.getSelectedColumn() == 8 && Principal.informacionIps.getEsFpz().intValue() == 1 && !Principal.informacionIps.getNombreIps().equals("LABORATORIO CLINICO VIVIAN RAMIREZ I.P.S. S.A.") && Principal.informacionIps.getNombreIps().equals("ESE HOSPITAL JOSE MARIA CORDOBA")) {
            if (Boolean.valueOf(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 8).toString()).booleanValue()) {
                mSeleccionar(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 5).toString(), true);
            } else {
                mSeleccionar(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 5).toString(), false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBDetallePropertyChange(PropertyChangeEvent evt) {
    }

    private void mSeleccionar(String xRecepcion, Boolean xestado) {
        for (int x = 0; x < this.JTBDetalle.getRowCount(); x++) {
            if (this.xmodelo.getValueAt(x, 5).toString().equals(xRecepcion)) {
                this.xmodelo.setValueAt(xestado, x, 8);
            }
        }
    }

    public void mCastearMaquina() {
        switch (this.xnombre) {
            case "Exportación Wiener Lab CB400i":
                mExportar_CB400i();
                break;
            case "Exportación Abbott Architect i1000SR":
            case "Exportación Cobas e411":
                mExportar_i1000();
                break;
            case "Exportación STA Satellite":
                mExportar_STASatellite();
                break;
            case "Exportación AU480":
                mExportar_AU480();
                break;
        }
    }

    public void mExportar_CB400i() {
        claseLab claselab = Principal.claselab;
        JIFSerialCom jIFSerialCom = claseLab.xJIFSerialCom;
        JIFSerialCom.xenviando = true;
        int cont = 0;
        int xtotal = 0;
        String Tecnica = "";
        this.hs.clear();
        this.array.clear();
        for (int i = 0; i < this.JTBDetalle.getRowCount(); i++) {
            if (Boolean.valueOf(this.xmodelo.getValueAt(i, 8).toString()).booleanValue()) {
                this.hs.add(agregarCeros(this.xmodelo.getValueAt(i, 5).toString(), 15));
            }
        }
        this.array.addAll(this.hs);
        for (int x = 0; x < this.array.size(); x++) {
            for (int y = 0; y < this.JTBDetalle.getRowCount(); y++) {
                if (Boolean.valueOf(this.xmodelo.getValueAt(y, 8).toString()).booleanValue() && agregarCeros(this.xmodelo.getValueAt(y, 5).toString(), 15).equals(this.array.get(x))) {
                    cont++;
                    Tecnica = Tecnica + mFormatearString("%-4s", this.xmodelo.getValueAt(y, 6).toString());
                    String[] pvalor = String.valueOf(this.array.get(x)).replaceFirst("^0*", "").split("\\.|\\-");
                    mActualizarEnviOrden(pvalor[0], this.xmodelo.getValueAt(y, 15).toString());
                }
            }
            if (cont != 0) {
                JIFSerialCom.mEnvioPuertoSerial("\u0002\u0004");
                while (JIFSerialCom.flag == 0) {
                    try {
                        JIFSerialCom.EnviOrden = "\u0002" + mCalcularNVerificacionCB400i(this.array.get(x) + "TSN00" + mFormatearString("%02d", Integer.valueOf(cont)) + Tecnica) + "\u0004";
                        Thread.sleep(300L);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(JIFExportacionDatos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                    }
                }
                JIFSerialCom.flag = 0;
                xtotal++;
                cont = 0;
                Tecnica = "";
            }
        }
        JIFSerialCom.mEnvioPuertoSerial("\u0002\u0004");
        JIFSerialCom.xenviando = false;
        this.JTFNRegistro.setValue(Integer.valueOf(xtotal));
        mBuscar();
    }

    public void mExportar_i1000() {
        claseLab claselab = Principal.claselab;
        JIFSerialCom jIFSerialCom = claseLab.xJIFSerialCom;
        JIFSerialCom.xenviando = true;
        long xc1 = 1;
        long xc2 = 1;
        long xcont = 1;
        long xtotal = 0;
        String xid_recepcion = "";
        JIFSerialCom.mEnvioPuertoSerial("\u0005");
        String msg = "1H|\\^&||||||||||P|1";
        JIFSerialCom.mEnvioPuertoSerial("\u0002" + msg + "\r\u0003" + mCalcularNVASTM(msg) + "\r\n");
        for (int x = 0; x < this.JTBDetalle.getRowCount(); x++) {
            if (Boolean.valueOf(this.xmodelo.getValueAt(x, 8).toString()).booleanValue() && isNumeric(this.xmodelo.getValueAt(x, 6).toString())) {
                if (xid_recepcion != this.xmodelo.getValueAt(x, 5).toString()) {
                    long xcont2 = NoFrame(xcont).longValue() + 1;
                    String msg2 = xcont2 + "P|" + xc1 + "||||||||||||||||||||||||";
                    JIFSerialCom.mEnvioPuertoSerial("\u0002" + msg2 + "\r\u0003" + mCalcularNVASTM(msg2) + "\r\n");
                    xid_recepcion = this.xmodelo.getValueAt(x, 5).toString();
                    xcont = NoFrame(xcont2).longValue() + 1;
                    String msg3 = xcont + "O|1|" + this.xmodelo.getValueAt(x, 5).toString() + "||^^^" + this.xmodelo.getValueAt(x, 6).toString() + "|||||||A||||||||||||||Q";
                    JIFSerialCom.mEnvioPuertoSerial("\u0002" + msg3 + "\r\u0003" + mCalcularNVASTM(msg3) + "\r\n");
                    xtotal++;
                    xc1++;
                    xc2 = 1 + 1;
                    mActualizarEnviOrden(this.xmodelo.getValueAt(x, 5).toString(), this.xmodelo.getValueAt(x, 15).toString());
                } else {
                    xcont = NoFrame(xcont).longValue() + 1;
                    String msg4 = xcont + "O|" + xc2 + "|" + this.xmodelo.getValueAt(x, 5).toString() + "||^^^" + this.xmodelo.getValueAt(x, 6).toString() + "|||||||A||||||||||||||Q";
                    JIFSerialCom.mEnvioPuertoSerial("\u0002" + msg4 + "\r\u0003" + mCalcularNVASTM(msg4) + "\r\n");
                    xtotal++;
                    xc2++;
                    mActualizarEnviOrden(this.xmodelo.getValueAt(x, 5).toString(), this.xmodelo.getValueAt(x, 15).toString());
                }
            }
        }
        String msg5 = (NoFrame(xcont).longValue() + 1) + "L|1";
        JIFSerialCom.mEnvioPuertoSerial("\u0002" + msg5 + "\r\u0003" + mCalcularNVASTM(msg5) + "\r\n");
        JIFSerialCom.mEnvioPuertoSerial("\u0004");
        JIFSerialCom.xenviando = false;
        this.JTFNRegistro.setValue(Long.valueOf(xtotal));
        mBuscar();
    }

    public void mExportar_STASatellite() {
        claseLab claselab = Principal.claselab;
        JIFSerialCom jIFSerialCom = claseLab.xJIFSerialCom;
        JIFSerialCom.xenviando = true;
        long xid_recepcion = 0;
        long xc1 = 1;
        long xc2 = 1;
        long xcont = 1;
        long xtotal = 0;
        JIFSerialCom.mEnvioPuertoSerial("\u0005");
        String msg = "1H|\\^&|||99^2.00|||||||P|1.00|";
        JIFSerialCom.mEnvioPuertoSerial("\u0002" + msg + "\r\u0003" + mCalcularNVASTM(msg) + "\r\n");
        for (int x = 0; x < this.JTBDetalle.getRowCount(); x++) {
            if (Boolean.valueOf(this.xmodelo.getValueAt(x, 8).toString()).booleanValue() && isNumeric(this.xmodelo.getValueAt(x, 6).toString())) {
                if (xid_recepcion != Long.valueOf(this.xmodelo.getValueAt(x, 5).toString()).longValue()) {
                    long xcont2 = NoFrame(xcont).longValue() + 1;
                    String msg2 = xcont2 + "P|" + xc1 + "|||^^^";
                    JIFSerialCom.mEnvioPuertoSerial("\u0002" + msg2 + "\r\u0003" + mCalcularNVASTM(msg2) + "\r\n");
                    xid_recepcion = Long.valueOf(this.xmodelo.getValueAt(x, 5).toString()).longValue();
                    xcont = NoFrame(xcont2).longValue() + 1;
                    String msg3 = xcont + "O|1|" + this.xmodelo.getValueAt(x, 5).toString() + "||^^^1\\^^^3\\^^^4|R";
                    JIFSerialCom.mEnvioPuertoSerial("\u0002" + msg3 + "\r\u0003" + mCalcularNVASTM(msg3) + "\r\n");
                    xtotal++;
                    xc1++;
                    xc2 = 1 + 1;
                    mActualizarEnviOrden(this.xmodelo.getValueAt(x, 5).toString(), this.xmodelo.getValueAt(x, 15).toString());
                } else {
                    xcont = NoFrame(xcont).longValue() + 1;
                    String msg4 = xcont + "O|" + xc2 + "|" + this.xmodelo.getValueAt(x, 5).toString() + "||^^^" + this.xmodelo.getValueAt(x, 6).toString() + "|R";
                    JIFSerialCom.mEnvioPuertoSerial("\u0002" + msg4 + "\r\u0003" + mCalcularNVASTM(msg4) + "\r\n");
                    xtotal++;
                    xc2++;
                    mActualizarEnviOrden(this.xmodelo.getValueAt(x, 5).toString(), this.xmodelo.getValueAt(x, 15).toString());
                }
            }
        }
        String msg5 = (NoFrame(xcont).longValue() + 1) + "L|1";
        JIFSerialCom.mEnvioPuertoSerial("\u0002" + msg5 + "\r\u0003" + mCalcularNVASTM(msg5) + "\r\n");
        JIFSerialCom.mEnvioPuertoSerial("\u0004");
        JIFSerialCom.xenviando = false;
        this.JTFNRegistro.setValue(Long.valueOf(xtotal));
        mBuscar();
    }

    public void mExportar_AU480() {
        int cont = 0;
        int xtotal = 0;
        String Tecnica = "";
        this.hs.clear();
        this.array.clear();
        for (int i = 0; i < this.JTBDetalle.getRowCount(); i++) {
            if (Boolean.valueOf(this.xmodelo.getValueAt(i, 8).toString()).booleanValue()) {
                this.hs.add(this.xmodelo.getValueAt(i, 5).toString());
            }
        }
        this.array.addAll(this.hs);
        for (int x = 0; x < 1; x++) {
            for (int y = 0; y < this.JTBDetalle.getRowCount(); y++) {
                if (Boolean.valueOf(this.xmodelo.getValueAt(y, 8).toString()).booleanValue() && agregarCeros(this.xmodelo.getValueAt(y, 5).toString(), 15).equals(this.array.get(x))) {
                    cont++;
                    Tecnica = Tecnica + mFormatearString("%-4s", this.xmodelo.getValueAt(y, 6).toString());
                    String[] pvalor = String.valueOf(this.array.get(x)).replaceFirst("^0*", "").split("\\.|\\-");
                    mActualizarEnviOrden(pvalor[0], this.xmodelo.getValueAt(y, 15).toString());
                }
            }
            if (cont != 0) {
                JIFSerialCom.mEnvioPuertoSerial("\u0006");
                try {
                    if (!"Serum".equals(this.xmodelo.getValueAt(x, 5).toString())) {
                        this.xmodelo.getValueAt(x, 5).toString().substring(1);
                    }
                    Thread.sleep(300L);
                } catch (InterruptedException ex) {
                    Logger.getLogger(JIFExportacionDatos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                }
                JIFSerialCom.flag = 0;
                xtotal++;
                cont = 0;
                Tecnica = "";
            }
        }
        JIFSerialCom.xenviando = false;
        this.JTFNRegistro.setValue(Integer.valueOf(xtotal));
        mBuscar();
    }

    private Long NoFrame(long xnumero) {
        long xcont = xnumero;
        if (xcont == 7) {
            xcont = -1;
        }
        return Long.valueOf(xcont);
    }

    private static boolean isNumeric(String cadena) {
        try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private String agregarCeros(String string, int largo) {
        String ceros = "";
        int cantidad = largo - string.length();
        if (cantidad >= 1) {
            for (int i = 0; i < cantidad; i++) {
                ceros = ceros + "0";
            }
            return ceros + string;
        }
        return string;
    }

    private String mFormatearString(String Condicion, Object Campo) {
        Formatter fmt = new Formatter();
        fmt.format(Condicion, Campo);
        return fmt.toString();
    }

    private String mCalcularNVerificacionCB400i(String xCadena) {
        int sum = 0;
        for (int i = 0; i < xCadena.length(); i++) {
            sum += xCadena.codePointAt(i);
        }
        return xCadena + mFormatearString("%03d", Integer.valueOf(sum % 256));
    }

    private String mCalcularNVASTM(String xCadena) {
        int sum = 0;
        for (int i = 0; i < xCadena.length(); i++) {
            sum += xCadena.charAt(i);
        }
        String checksum = Integer.toHexString((sum + 16) % 256).toUpperCase();
        if (checksum.length() == 1) {
            checksum = "0" + checksum;
        }
        return checksum;
    }

    private void mDesact_Activar(boolean xestado) {
        for (int x = 0; x < this.JTBDetalle.getRowCount(); x++) {
            this.xmodelo.setValueAt(Boolean.valueOf(xestado), x, 8);
        }
    }

    private void mExportar_Autoplex() {
        BufferedWriter fw = null;
        try {
            try {
                fw = new BufferedWriter(new FileWriter(this.JTFRuta.getText()));
                fw.write("H|^~\\&||||||||||P|A.2|" + this.xmt.formatoAMD_Unida.format(this.JDFechaI.getDate()) + "" + this.xmt.formatoH24_Unida.format(this.xmt.getFechaActual()));
                long xid_recepcion = 0;
                long xc1 = 1;
                long xc2 = 1;
                long xc3 = 0;
                for (int x = 0; x < this.JTBDetalle.getRowCount(); x++) {
                    if (Boolean.valueOf(this.xmodelo.getValueAt(x, 8).toString()).booleanValue()) {
                        if (xid_recepcion != Long.valueOf(this.xmodelo.getValueAt(x, 5).toString()).longValue()) {
                            fw.newLine();
                            fw.write("P|" + xc1 + "|" + this.xmodelo.getValueAt(x, 5).toString() + "|||" + this.xmodelo.getValueAt(x, 11).toString() + "^" + this.xmodelo.getValueAt(x, 11).toString());
                            xid_recepcion = Long.valueOf(this.xmodelo.getValueAt(x, 5).toString()).longValue();
                            fw.newLine();
                            fw.write("OBR|1|||" + this.xmodelo.getValueAt(x, 6).toString());
                            xc1++;
                            xc2 = 1 + 1;
                        } else {
                            fw.newLine();
                            fw.write("OBR|" + xc2 + "|||" + this.xmodelo.getValueAt(x, 6).toString());
                        }
                        xc3++;
                    }
                }
                fw.newLine();
                fw.write("L|||3|" + xc3);
                try {
                    fw.close();
                } catch (IOException ex) {
                    Logger.getLogger(JIFExportacionDatos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                }
            } catch (IOException ex2) {
                Logger.getLogger(JIFExportacionDatos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex2);
                try {
                    fw.close();
                } catch (IOException ex3) {
                    Logger.getLogger(JIFExportacionDatos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex3);
                }
            }
        } catch (Throwable th) {
            try {
                fw.close();
            } catch (IOException ex4) {
                Logger.getLogger(JIFExportacionDatos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex4);
            }
            throw th;
        }
    }

    private void mExportar() {
        String xc;
        try {
            FileWriter fw = new FileWriter(this.JTFRuta.getText() + ".txt");
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter salArch = new PrintWriter(bw);
            for (int x = 0; x < this.JTBDetalle.getRowCount(); x++) {
                if (Boolean.valueOf(this.xmodelo.getValueAt(x, 8).toString()).booleanValue()) {
                    if (Boolean.valueOf(this.xmodelo.getValueAt(x, 3).toString()).booleanValue()) {
                        xc = "U";
                    } else {
                        xc = "N";
                    }
                    salArch.println(xc + "\t" + this.xmodelo.getValueAt(x, 4).toString().toUpperCase() + "\t" + this.xmodelo.getValueAt(x, 5) + "\t" + this.xmodelo.getValueAt(x, 6) + "\t" + this.xmodelo.getValueAt(x, 7));
                    mActualizarEnviOrden(this.xmodelo.getValueAt(x, 5).toString(), this.xmodelo.getValueAt(x, 15).toString());
                }
            }
            salArch.close();
        } catch (IOException ex) {
            Logger.getLogger(JIFExportacionDatos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mExportar_DL96II(String xnarchivo, int x) {
        try {
            String sFichero = this.JTFRuta.getText() + xnarchivo + ".astm";
            this.xmt.mEliminarArchivo(new File(sFichero));
            BufferedWriter bw = new BufferedWriter(new FileWriter(sFichero));
            bw.write("1H|\\^&|||GENOMA||||||||1|" + this.xmt.formatoDMAH24_Unida.format(this.xmt.getFechaActual()));
            bw.newLine();
            bw.write("2P|1|" + this.JTBDetalle.getValueAt(x, 1).toString() + "|||" + this.JTBDetalle.getValueAt(x, 11).toString().trim() + "^" + this.JTBDetalle.getValueAt(x, 12).toString().trim() + "||" + this.JTBDetalle.getValueAt(x, 17).toString().replaceAll("-", "").trim() + "|" + this.JTBDetalle.getValueAt(x, 18).toString().trim() + "|||||");
            bw.newLine();
            bw.write("3O|1|" + this.JTBDetalle.getValueAt(x, 5).toString() + "||^^^" + this.JTBDetalle.getValueAt(x, 6).toString() + "|1||||||N||||||||||||||O");
            bw.newLine();
            bw.write("4L|1|N");
            bw.close();
            mActualizarEnviOrden(this.xmodelo.getValueAt(x, 5).toString(), this.xmodelo.getValueAt(x, 15).toString());
        } catch (IOException ex) {
            Logger.getLogger(crear_ArchivosPlanos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mExportar_CM250(int x) {
        try {
            String Tecnica = "";
            String Paciente = "";
            String HC = "";
            int cont = 0;
            String sFichero = this.JTFRuta.getText() + "Import.ana";
            this.xmt.mEliminarArchivo(new File(sFichero));
            BufferedWriter bw = new BufferedWriter(new FileWriter(sFichero));
            this.hs.clear();
            this.array.clear();
            for (int i = 0; i < this.JTBDetalle.getRowCount(); i++) {
                if (Boolean.valueOf(this.xmodelo.getValueAt(i, 8).toString()).booleanValue()) {
                    this.hs.add(this.xmodelo.getValueAt(i, 5).toString());
                }
            }
            this.array.addAll(this.hs);
            for (int i2 = 0; i2 < this.array.size(); i2++) {
                for (int y = 0; y < this.JTBDetalle.getRowCount(); y++) {
                    if (Boolean.valueOf(this.xmodelo.getValueAt(y, 8).toString()).booleanValue() && this.xmodelo.getValueAt(y, 5).toString().equals(this.array.get(i2))) {
                        cont++;
                        Tecnica = Tecnica + ";" + this.xmodelo.getValueAt(y, 6).toString();
                        Paciente = this.xmodelo.getValueAt(y, 2).toString();
                        HC = this.xmodelo.getValueAt(y, 1).toString();
                    }
                }
                bw.write(this.array.get(i2) + ";N;" + Paciente + ";" + HC + ";;;" + cont + Tecnica);
                bw.newLine();
                Tecnica = "";
                Paciente = "";
                HC = "";
                cont = 0;
            }
            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(crear_ArchivosPlanos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mNuevo() {
        this.xlleno = false;
        this.JDFechaI.setDate(this.xmt.getFechaActual());
        this.JDFechaF.setDate(this.xmt.getFechaActual());
        this.JCBEquipo.removeAllItems();
        this.xidequipo = this.xct.llenarComboyLista("SELECT\n\tlta.id,\n\tlca.Nbre ,\n\tlca.Url\nFROM\n\tl_config_analizador lca\nINNER JOIN l_tipo_analizador lta ON\n\tlca.idEquipo = lta.id\nWHERE\n\t(lca.Estado = 1)\nORDER BY\n\tlca.Nbre ASC", this.xidequipo, this.JCBEquipo, 3);
        this.JCBEquipo.setSelectedItem(-1);
        this.xlleno = true;
        if (this.xidequipo.length == 1) {
            this.JCBEquipo.setSelectedItem(this.xEquipo);
            this.JTFRuta.setText(this.xidequipo[this.JCBEquipo.getSelectedIndex()][1]);
        }
        this.xct.cerrarConexionBd();
        seleccionarAnalizador();
        this.JRBTodo.setSelected(true);
        JRBTodoActionPerformed(null);
        if (this.xnombre.equals("Exportación Wiener Lab CB400i") || this.xnombre.equals("Exportación Abbott Architect i1000SR") || this.xnombre.equals("Exportación STA Satellite") || this.xnombre.equals("Exportación Cobas e411") || this.xnombre.equals("Exportación AU480")) {
            this.JBTEnviar.setVisible(true);
            this.JTFRuta.setVisible(false);
            this.JBTExportar.setVisible(false);
        } else {
            this.JBTEnviar.setVisible(false);
        }
        this.JTFNRegistro.setValue(0);
        mCrearModeloDatos();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Fecha", "N° HC", "Usuario", "Urgente?", "Tipo Muestra", "NRecepción", "Tecnica", "Tubo", "Exportar?", "Protocolo", "Procedimiento", "Nombre1", "Apellido1", "Municipio", "EnvioMaquina", "Id_Procedimiento", "Tipo de Atencion", "Fecha de Nacimiento", "Sexo"}) { // from class: Laboratorio.JIFExportacionDatos.18
            Class[] types = {String.class, String.class, String.class, Boolean.class, String.class, String.class, String.class, String.class, Boolean.class, String.class, String.class, String.class, String.class, String.class, Boolean.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, true, false, true, false, false, true, false, false, false, false, false, false, false, false, false, false};

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
        this.JTBDetalle.setModel(this.xmodelo);
        this.JTBDetalle.getColumnModel().getColumn(0).setPreferredWidth(80);
        this.JTBDetalle.getColumnModel().getColumn(1).setPreferredWidth(120);
        this.JTBDetalle.getColumnModel().getColumn(2).setPreferredWidth(300);
        this.JTBDetalle.getColumnModel().getColumn(3).setPreferredWidth(80);
        this.JTBDetalle.getColumnModel().getColumn(4).setPreferredWidth(80);
        this.JTBDetalle.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTBDetalle.getColumnModel().getColumn(6).setPreferredWidth(80);
        this.JTBDetalle.getColumnModel().getColumn(7).setPreferredWidth(100);
        this.JTBDetalle.getColumnModel().getColumn(8).setPreferredWidth(80);
        this.JTBDetalle.getColumnModel().getColumn(9).setPreferredWidth(150);
        this.JTBDetalle.getColumnModel().getColumn(10).setPreferredWidth(300);
        this.JTBDetalle.getColumnModel().getColumn(11).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(11).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(11).setMaxWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(12).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(12).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(12).setMaxWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(13).setPreferredWidth(150);
        this.JTBDetalle.getColumnModel().getColumn(14).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(14).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(14).setMaxWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(15).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(15).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(15).setMaxWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(16).setPreferredWidth(120);
        this.JTBDetalle.getColumnModel().getColumn(17).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(17).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(17).setMaxWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(18).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(18).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(18).setMaxWidth(0);
    }

    private void mCargarDatosTabla() {
        try {
            mCrearModeloDatos();
            StringBuilder query = new StringBuilder();
            query.append("SELECT\n\tDATE_FORMAT(lr.FechaRecep, '%Y-%m-%d') AS fechaRecepcion,\n\tgp2.NoDocumento,\n\tCONCAT(gp2.Nombre1, ' ', gp2.Nombre2, ' ', gp2.Apellido1, ' ', gp2.Apellido2) AS NUsuario,\n\tLEFT(lt.Abreviatura,3) AS TipoM,\n");
            if (Principal.informacionIps.getAplicaConsecutivoDiarioLaboratorio().booleanValue()) {
                query.append("\tCONCAT(DATE_FORMAT(lr.FechaRecep, '%Y%m%d'), LPAD(lr.consecutivo, 3, 0), UPPER(lt.indicativo), IF(lp.CNOrden_Recepcion = 1, lp.Orden, IFNULL(lp.NAdicional, ''))) AS idRecepcion,\n");
            } else {
                query.append("\tCONCAT(lr.Id, UPPER(lt.indicativo), IF(lp.CNOrden_Recepcion = 1, lp.Orden, IFNULL(lp.NAdicional, ''))) AS IdRecepcion,\n");
            }
            query.append("\tLEFT(lp3.Abreviatura,16) AS Tecnica,\n\tltt.Abreviatura AS tipoTuboAbreviatura,\n\tlp2.Nbre as nombreProtocolo,\n\tgp.Nbre as nombreProcedimiento,\n\tgp2.Nombre1,\n\tgp2.Apellido1,\n\tgm.Nbre AS Municipio,\n\tld.EnvioMaquina,\n\tld.Id_Procedim,\n\tgt.Nbre AS TipoAtencion,\n\tgp2.FechaNac,\n\tgp2.Id_Sexo\nFROM\n\tl_recepcion lr\nINNER JOIN l_detallerecepcion ld ON\n\tld.Id_Recepcion = lr.Id\nINNER JOIN f_ordenes fo ON\n\tlr.Id_OrdenFacturac = fo.Id\nINNER JOIN g_procedimiento gp ON\n\tld.Id_Procedim = gp.Id\nINNER JOIN l_tipo_tubo ltt ON\n\tgp.Id_Tubo = ltt.Id\nINNER JOIN l_protocoloxprocedimiento lp ON\n\tgp.Id = lp.Id_Procedim\n\tAND lp.Estado = 0\nINNER JOIN ingreso i ON\n\tfo.Id_Ingreso = i.Id\nINNER JOIN g_persona gp2 ON\n\tgp2.Id = i.Id_Usuario\nINNER JOIN g_tipoatencion gt ON\n\ti.Id_TipoAtencion = gt.Id\nINNER JOIN g_municipio gm ON\n\tgp2.Id_Municipio = gm.Id\nINNER JOIN l_protocolos lp2 ON\n\tlp.Id_Protocolo = lp2.Id\nINNER JOIN l_tipomuestra lt ON\n\tlp2.Id_Tipo_Muestra = lt.Id\nINNER JOIN l_protocolosxequipos lp3 ON\n\tlp3.IdProtocoloProcedimiento = lp.Id\n\tAND lp3.Estado = 1\n\tAND lp3.EsPrincipal = 1\nWHERE\n\t(\n\t\tCONCAT(gp2.Nombre1, ' ', gp2.Nombre2, ' ', gp2.Apellido1, ' ', gp2.Apellido2) LIKE '%" + this.JTFFiltroUsuario.getText() + "%'\n");
            if (this.JRBSede.isSelected() && this.JCBSede.getSelectedIndex() != -1) {
                query.append("\t\tAND lr.Id_Sede = " + this.xidsede[this.JCBSede.getSelectedIndex()] + "\n");
            } else if (this.JRBMunicipio.isSelected() && this.JCBSede.getSelectedIndex() != -1) {
                query.append("\t\tAND gm.Id = '" + this.xidsede[this.JCBSede.getSelectedIndex()] + "'\n");
            } else if (this.JRBTipoAtencion.isSelected() && this.JCBSede.getSelectedIndex() != -1) {
                query.append("\t\tAND gt.Id = '" + this.xidsede[this.JCBSede.getSelectedIndex()] + "'\n");
            }
            query.append("\t\tAND lp3.IdEquipo = " + this.xidequipo[this.JCBEquipo.getSelectedIndex()][0] + "\n\t\tAND DATE_FORMAT(lr.FechaRecep, '%Y-%m-%d') BETWEEN '" + this.xmt.formatoAMD1.format(this.JDFechaI.getDate()) + "' AND '" + this.xmt.formatoAMD1.format(this.JDFechaF.getDate()) + "'\n\t\tAND lr.Estado = 0\n\t\t\tAND ld.EnvioMaquina IN (" + this.xEstado + ")\n\t\t)\nGROUP BY\n\tIdRecepcion,\n\tlp.Id\nORDER BY\n\tlr.Id ASC,\n\tIdRecepcion ASC,\n\tgp.Id ASC");
            ResultSet xrs = this.xct.traerRs(query.toString());
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(xrs.getString("fechaRecepcion"), n, 0);
                    this.xmodelo.setValueAt(xrs.getString("NoDocumento"), n, 1);
                    this.xmodelo.setValueAt(xrs.getString("NUsuario"), n, 2);
                    this.xmodelo.setValueAt(false, n, 3);
                    this.xmodelo.setValueAt(xrs.getString("TipoM"), n, 4);
                    this.xmodelo.setValueAt(xrs.getString("IdRecepcion"), n, 5);
                    this.xmodelo.setValueAt(xrs.getString("Tecnica"), n, 6);
                    this.xmodelo.setValueAt(xrs.getString("tipoTuboAbreviatura"), n, 7);
                    this.xmodelo.setValueAt(false, n, 8);
                    this.xmodelo.setValueAt(xrs.getString("nombreProtocolo"), n, 9);
                    this.xmodelo.setValueAt(xrs.getString("nombreProcedimiento"), n, 10);
                    this.xmodelo.setValueAt(xrs.getString("Nombre1"), n, 11);
                    this.xmodelo.setValueAt(xrs.getString("Apellido1"), n, 12);
                    this.xmodelo.setValueAt(xrs.getString("Municipio"), n, 13);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean("EnvioMaquina")), n, 14);
                    this.xmodelo.setValueAt(xrs.getString("Id_Procedim"), n, 15);
                    this.xmodelo.setValueAt(xrs.getString("TipoAtencion"), n, 16);
                    this.xmodelo.setValueAt(xrs.getString("FechaNac"), n, 17);
                    this.xmodelo.setValueAt(xrs.getString("Id_Sexo"), n, 18);
                    this.JTBDetalle.setDefaultRenderer(Object.class, new MiRender());
                    n++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFExportacionDatos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mBuscar() {
        if (this.JCBEquipo.getSelectedIndex() != -1) {
            if (this.JRBSede.isSelected()) {
                if (this.JCBSede.getSelectedIndex() != -1) {
                    mCargarDatosTabla();
                    return;
                } else {
                    JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una sede", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    this.JCBSede.requestFocus();
                    return;
                }
            }
            if (this.JRBMunicipio.isSelected()) {
                if (this.JCBSede.getSelectedIndex() != -1) {
                    mCargarDatosTabla();
                    return;
                } else {
                    JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un municipio", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    this.JCBSede.requestFocus();
                    return;
                }
            }
            mCargarDatosTabla();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un equipo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JCBEquipo.requestFocus();
    }

    /* JADX INFO: loaded from: GenomaP.jar:Laboratorio/JIFExportacionDatos$MiRender.class */
    public static class MiRender extends DefaultTableCellRenderer {
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            boolean Enviado = Boolean.valueOf(table.getValueAt(row, 14).toString()).booleanValue();
            if (Enviado) {
                cell.setBackground(new Color(255, 255, 204));
            } else {
                cell.setBackground(Color.WHITE);
            }
            return cell;
        }
    }

    private void mActualizarEnviOrden(String IdRecepcion, String IdProcedimiento) {
        if (IdRecepcion.trim().matches("^([\\d]+)([-a-zA-Z]+)([\\d]+)*$")) {
            String[] pvalor = IdRecepcion.trim().split("[-a-zA-Z]+");
            IdRecepcion = pvalor[0];
        } else if (IdRecepcion.contains(".")) {
            String[] pvalor2 = IdRecepcion.split("\\.");
            IdRecepcion = pvalor2[0];
        } else if (IdRecepcion.contains("-")) {
            String[] pvalor3 = IdRecepcion.split("\\-");
            IdRecepcion = pvalor3[0];
        }
        this.xsql = "UPDATE `l_detallerecepcion` SET `EnvioMaquina`=1 WHERE `Id_Recepcion`='" + IdRecepcion + "' AND `Id_Procedim`='" + IdProcedimiento + "'";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
    }

    public boolean mExisteArchivo(String xruta) {
        boolean existe = false;
        File fichero = new File(xruta);
        if (fichero.exists()) {
            existe = true;
        }
        return existe;
    }

    private void seleccionarAnalizador() {
        switch (this.xnombre) {
            case "Exportación BioSystem A25":
                this.JCBEquipo.setSelectedItem("BIOSYSTEM A25");
                break;
            case "Exportación BioSystem A15":
                this.JCBEquipo.setSelectedItem("BIOSYSTEM A15");
                break;
            case "Exportación Wiener Lab CB400i":
                this.JCBEquipo.setSelectedItem("CB400I");
                break;
            case "Exportación Abbott Architect i1000SR":
                this.JCBEquipo.setSelectedItem("ARCHITECT I1000SR");
                break;
            case "Exportación Cobas e411":
                this.JCBEquipo.setSelectedItem("COBAS E411");
                break;
            case "Exportación DL-96II":
                this.JCBEquipo.setSelectedItem("DL-96II");
                break;
            case "Exportación AU480":
                this.JCBEquipo.setSelectedItem("AU480");
                break;
            case "Exportación Wiener Lab CM250":
                this.JCBEquipo.setSelectedItem("WIENER LAB CM250");
                break;
        }
    }

    private RestTemplate createInsecureRestTemplate(int connectionTimeout, int readTimeout) throws Exception {
        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(null, new TrustManager[]{new X509TrustManager() { // from class: Laboratorio.JIFExportacionDatos.19
            @Override // javax.net.ssl.X509TrustManager
            public void checkClientTrusted(X509Certificate[] chain, String authType) {
            }

            @Override // javax.net.ssl.X509TrustManager
            public void checkServerTrusted(X509Certificate[] chain, String authType) {
            }

            @Override // javax.net.ssl.X509TrustManager
            public X509Certificate[] getAcceptedIssuers() {
                return new X509Certificate[0];
            }
        }}, new SecureRandom());
        CloseableHttpClient httpClient = HttpClients.custom().setSSLContext(sslContext).setSSLHostnameVerifier(NoopHostnameVerifier.INSTANCE).build();
        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory(httpClient);
        factory.setConnectTimeout(connectionTimeout);
        factory.setReadTimeout(readTimeout);
        return new RestTemplate(factory);
    }

    public CompletableFuture<CustomPresenter> sendPostApi(String endpoint, Object data) {
        return CompletableFuture.supplyAsync(() -> {
            CustomPresenter response = null;
            try {
                RestTemplate restTemplate = createInsecureRestTemplate(5000, 10000);
                response = (CustomPresenter) restTemplate.postForObject(endpoint, data, CustomPresenter.class, new Object[0]);
            } catch (RestClientException exception) {
                System.out.println("Error al enviar el POST: " + exception.getMessage());
            } catch (Exception ex) {
                System.out.println("Error: " + ex.getMessage());
            }
            return response;
        });
    }
}
