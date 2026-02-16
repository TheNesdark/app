package ImagenesDx;

import Acceso.Principal;
import General.Anular;
import General.JDRxImagen;
import General.Persona;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.genoma.plus.controller.general.JDGenericoPanel;
import com.genoma.plus.dto.general.IpsDTO;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:ImagenesDx/JIFRecepcion_Rx1.class */
public class JIFRecepcion_Rx1 extends JInternalFrame {
    public Persona frmPersona;
    private DefaultTableModel xmodelo;
    private String sql;
    public String xIdIngreso;
    private Object[] fila;
    private String[] xidesps;
    private String[] xidprofe;
    private String xServicio;
    private IpsDTO ips;
    private JButton JBTCerrar;
    private JButton JBTCerrar1;
    private JButton JBTConsultarHC;
    private JButton JBTEventoAdverso;
    private JButton JBTEventoAdverso1;
    private JButton JBTSubirEstudio;
    private JComboBox JCBEspecialidad;
    private JComboBox JCBProfesional;
    private JCheckBox JCHRLEctura;
    private JPanel JPI_DUsuarios;
    private JPanel JPI_Historico;
    private JScrollPane JSP_DetalleT;
    private JTable JTB_Detalle;
    private JTabbedPane JTP_Datos;
    private JPanel jPanel1;
    private JScrollPane jScrollPane1;
    private JPanel panelPersona;
    public JTextField txtFecha;
    public JTextField txtNoOrden;
    private JEditorPane txtObservaciones;
    private JTextField txtProfesional;
    private Metodos metodos = new Metodos();
    private ConsultasMySQL consultas = new ConsultasMySQL();
    public String xidnrecepcion = "0";
    public String xIdTipoAtencion = "1";
    private int xrlectura = 0;
    private boolean xtipog = false;
    private boolean xlleno = false;
    private long xidespecialidad = 0;
    private long xidprofesional = 0;
    private String anioOrden = "";
    private String mesOrden = "";

    public JIFRecepcion_Rx1(String xServicio) {
        this.xServicio = "";
        initComponents();
        this.xServicio = xServicio;
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v62, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JTP_Datos = new JTabbedPane();
        this.JPI_DUsuarios = new JPanel();
        this.panelPersona = new JPanel();
        this.jPanel1 = new JPanel();
        this.txtNoOrden = new JTextField();
        this.jScrollPane1 = new JScrollPane();
        this.txtObservaciones = new JEditorPane();
        this.txtProfesional = new JTextField();
        this.txtFecha = new JTextField();
        this.JCHRLEctura = new JCheckBox();
        this.JCBEspecialidad = new JComboBox();
        this.JCBProfesional = new JComboBox();
        this.JSP_DetalleT = new JScrollPane();
        this.JTB_Detalle = new JTable();
        this.JBTCerrar = new JButton();
        this.JBTConsultarHC = new JButton();
        this.JBTEventoAdverso = new JButton();
        this.JBTEventoAdverso1 = new JButton();
        this.JBTCerrar1 = new JButton();
        this.JBTSubirEstudio = new JButton();
        this.JPI_Historico = new JPanel();
        setClosable(true);
        setIconifiable(true);
        setTitle("RECEPCIÓN AUTOMATICA");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjifrecepcionar_rx");
        addInternalFrameListener(new InternalFrameListener() { // from class: ImagenesDx.JIFRecepcion_Rx1.1
            public void internalFrameOpened(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
            }

            public void internalFrameClosed(InternalFrameEvent evt) {
                JIFRecepcion_Rx1.this.formInternalFrameClosed(evt);
            }

            public void internalFrameIconified(InternalFrameEvent evt) {
            }

            public void internalFrameDeiconified(InternalFrameEvent evt) {
            }

            public void internalFrameActivated(InternalFrameEvent evt) {
            }

            public void internalFrameDeactivated(InternalFrameEvent evt) {
            }
        });
        this.JTP_Datos.setForeground(Color.red);
        this.JTP_Datos.setFont(new Font("Arial", 1, 14));
        this.panelPersona.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS DE USUARIO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.panelPersona.setFont(new Font("Arial", 1, 12));
        this.panelPersona.setMaximumSize(new Dimension(1000, 160));
        this.panelPersona.setMinimumSize(new Dimension(1000, 160));
        GroupLayout panelPersonaLayout = new GroupLayout(this.panelPersona);
        this.panelPersona.setLayout(panelPersonaLayout);
        panelPersonaLayout.setHorizontalGroup(panelPersonaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 0, 32767));
        panelPersonaLayout.setVerticalGroup(panelPersonaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 144, 32767));
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS DE LA ORDEN", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.jPanel1.setFont(new Font("Arial", 1, 12));
        this.txtNoOrden.setFont(new Font("Arial", 1, 12));
        this.txtNoOrden.setHorizontalAlignment(0);
        this.txtNoOrden.setBorder(BorderFactory.createTitledBorder((Border) null, "Número de Orden / Factura", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.txtNoOrden.addFocusListener(new FocusAdapter() { // from class: ImagenesDx.JIFRecepcion_Rx1.2
            public void focusLost(FocusEvent evt) {
                JIFRecepcion_Rx1.this.txtNoOrdenFocusLost(evt);
            }
        });
        this.txtNoOrden.addActionListener(new ActionListener() { // from class: ImagenesDx.JIFRecepcion_Rx1.3
            public void actionPerformed(ActionEvent evt) {
                JIFRecepcion_Rx1.this.txtNoOrdenActionPerformed(evt);
            }
        });
        this.jScrollPane1.setBorder(BorderFactory.createTitledBorder((Border) null, "Observaciones", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jScrollPane1.setHorizontalScrollBarPolicy(31);
        this.jScrollPane1.setVerticalScrollBarPolicy(21);
        this.jScrollPane1.setFont(new Font("Arial", 1, 12));
        this.txtObservaciones.setBorder((Border) null);
        this.txtObservaciones.setFont(new Font("Arial", 1, 12));
        this.jScrollPane1.setViewportView(this.txtObservaciones);
        this.txtProfesional.setBackground(new Color(0, 0, 102));
        this.txtProfesional.setFont(new Font("Arial", 1, 12));
        this.txtProfesional.setForeground(new Color(0, 0, 204));
        this.txtProfesional.setHorizontalAlignment(0);
        this.txtProfesional.setBorder(BorderFactory.createTitledBorder((Border) null, "Profesional que Ordena", 0, 0, new Font("Dialog", 1, 12), new Color(204, 255, 255)));
        this.txtProfesional.setDisabledTextColor(new Color(255, 255, 255));
        this.txtProfesional.setEnabled(false);
        this.txtFecha.setBackground(new Color(0, 0, 102));
        this.txtFecha.setFont(new Font("Arial", 1, 12));
        this.txtFecha.setHorizontalAlignment(0);
        this.txtFecha.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Dialog", 1, 12), new Color(204, 255, 255)));
        this.txtFecha.setDisabledTextColor(new Color(255, 255, 255));
        this.txtFecha.setEnabled(false);
        this.txtFecha.setMinimumSize(new Dimension(30, 54));
        this.txtFecha.setPreferredSize(new Dimension(30, 54));
        this.JCHRLEctura.setFont(new Font("Arial", 1, 12));
        this.JCHRLEctura.setText("Requiere Lectura?");
        this.JCHRLEctura.addActionListener(new ActionListener() { // from class: ImagenesDx.JIFRecepcion_Rx1.4
            public void actionPerformed(ActionEvent evt) {
                JIFRecepcion_Rx1.this.JCHRLEcturaActionPerformed(evt);
            }
        });
        this.JCBEspecialidad.setBorder(BorderFactory.createTitledBorder((Border) null, "Especialidad", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JCBEspecialidad.addItemListener(new ItemListener() { // from class: ImagenesDx.JIFRecepcion_Rx1.5
            public void itemStateChanged(ItemEvent evt) {
                JIFRecepcion_Rx1.this.JCBEspecialidadItemStateChanged(evt);
            }
        });
        this.JCBProfesional.setBorder(BorderFactory.createTitledBorder((Border) null, "Profesional", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(4, 4, 4).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.txtNoOrden, -2, 190, -2).addGap(10, 10, 10).addComponent(this.txtFecha, -2, 160, -2).addGap(18, 18, 18).addComponent(this.JCHRLEctura, -2, 139, -2)).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.txtProfesional, -2, 360, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jScrollPane1))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBEspecialidad, 0, -1, 32767).addComponent(this.JCBProfesional, GroupLayout.Alignment.TRAILING, 0, -1, 32767)).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(10, 10, 10).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.txtNoOrden, -2, 50, -2).addComponent(this.txtFecha, -2, 50, -2).addComponent(this.JCHRLEctura, GroupLayout.Alignment.TRAILING).addComponent(this.JCBEspecialidad, -2, 49, -2)).addGap(10, 10, 10).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.txtProfesional).addComponent(this.jScrollPane1).addComponent(this.JCBProfesional, -2, 0, 32767)).addContainerGap()));
        this.JSP_DetalleT.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTB_Detalle.setFont(new Font("Arial", 1, 12));
        this.JTB_Detalle.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTB_Detalle.setRowHeight(25);
        this.JTB_Detalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTB_Detalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTB_Detalle.setSelectionMode(0);
        this.JTB_Detalle.addMouseListener(new MouseAdapter() { // from class: ImagenesDx.JIFRecepcion_Rx1.6
            public void mouseClicked(MouseEvent evt) {
                JIFRecepcion_Rx1.this.JTB_DetalleMouseClicked(evt);
            }
        });
        this.JSP_DetalleT.setViewportView(this.JTB_Detalle);
        this.JBTCerrar.setFont(new Font("Arial", 1, 12));
        this.JBTCerrar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/HojaLapiz29x27.png")));
        this.JBTCerrar.setText("Registro Lectura");
        this.JBTCerrar.addActionListener(new ActionListener() { // from class: ImagenesDx.JIFRecepcion_Rx1.7
            public void actionPerformed(ActionEvent evt) {
                JIFRecepcion_Rx1.this.JBTCerrarActionPerformed(evt);
            }
        });
        this.JBTConsultarHC.setFont(new Font("Arial", 1, 12));
        this.JBTConsultarHC.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Configuracion29x27.png")));
        this.JBTConsultarHC.setText("<html><P ALIGN=center>Consultar HC");
        this.JBTConsultarHC.addActionListener(new ActionListener() { // from class: ImagenesDx.JIFRecepcion_Rx1.8
            public void actionPerformed(ActionEvent evt) {
                JIFRecepcion_Rx1.this.JBTConsultarHCActionPerformed(evt);
            }
        });
        this.JBTEventoAdverso.setFont(new Font("Arial", 1, 12));
        this.JBTEventoAdverso.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Evento Adverso.png")));
        this.JBTEventoAdverso.setText("<html><P ALIGN=center>Caso de Seguridad del Paciente\n");
        this.JBTEventoAdverso.addActionListener(new ActionListener() { // from class: ImagenesDx.JIFRecepcion_Rx1.9
            public void actionPerformed(ActionEvent evt) {
                JIFRecepcion_Rx1.this.JBTEventoAdversoActionPerformed(evt);
            }
        });
        this.JBTEventoAdverso1.setFont(new Font("Arial", 1, 12));
        this.JBTEventoAdverso1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/advertenciaRadiacion.png")));
        this.JBTEventoAdverso1.setText("<html><P ALIGN=center>Actualizar valores de radiación");
        this.JBTEventoAdverso1.addActionListener(new ActionListener() { // from class: ImagenesDx.JIFRecepcion_Rx1.10
            public void actionPerformed(ActionEvent evt) {
                JIFRecepcion_Rx1.this.JBTEventoAdverso1ActionPerformed(evt);
            }
        });
        this.JBTCerrar1.setFont(new Font("Arial", 1, 12));
        this.JBTCerrar1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.JBTCerrar1.setText("Cerrar");
        this.JBTCerrar1.addActionListener(new ActionListener() { // from class: ImagenesDx.JIFRecepcion_Rx1.11
            public void actionPerformed(ActionEvent evt) {
                JIFRecepcion_Rx1.this.JBTCerrar1ActionPerformed(evt);
            }
        });
        this.JBTSubirEstudio.setFont(new Font("Arial", 1, 12));
        this.JBTSubirEstudio.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTSubirEstudio.setText("Adjuntar estudio a HC");
        this.JBTSubirEstudio.setEnabled(false);
        this.JBTSubirEstudio.addActionListener(new ActionListener() { // from class: ImagenesDx.JIFRecepcion_Rx1.12
            public void actionPerformed(ActionEvent evt) {
                JIFRecepcion_Rx1.this.JBTSubirEstudioActionPerformed(evt);
            }
        });
        GroupLayout JPI_DUsuariosLayout = new GroupLayout(this.JPI_DUsuarios);
        this.JPI_DUsuarios.setLayout(JPI_DUsuariosLayout);
        JPI_DUsuariosLayout.setHorizontalGroup(JPI_DUsuariosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DUsuariosLayout.createSequentialGroup().addGap(5, 5, 5).addGroup(JPI_DUsuariosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DUsuariosLayout.createSequentialGroup().addComponent(this.JBTConsultarHC, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTEventoAdverso, -2, 182, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTEventoAdverso1, -2, 184, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTCerrar).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTSubirEstudio).addGap(29, 29, 29).addComponent(this.JBTCerrar1, -2, 117, -2).addGap(0, 0, 32767)).addComponent(this.panelPersona, -1, -1, 32767).addComponent(this.jPanel1, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addComponent(this.JSP_DetalleT, GroupLayout.Alignment.TRAILING)).addContainerGap()));
        JPI_DUsuariosLayout.setVerticalGroup(JPI_DUsuariosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DUsuariosLayout.createSequentialGroup().addGap(8, 8, 8).addComponent(this.panelPersona, -2, -1, -2).addGap(10, 10, 10).addComponent(this.jPanel1, -2, -1, -2).addGap(10, 10, 10).addComponent(this.JSP_DetalleT, -2, 120, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPI_DUsuariosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DUsuariosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DUsuariosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBTCerrar, -2, 50, -2).addComponent(this.JBTCerrar1, -2, 50, -2).addComponent(this.JBTSubirEstudio, -2, 50, -2)).addComponent(this.JBTConsultarHC, GroupLayout.Alignment.TRAILING, -2, 50, -2)).addComponent(this.JBTEventoAdverso1, -2, 50, -2).addComponent(this.JBTEventoAdverso, -2, 50, -2)).addContainerGap()));
        this.JTP_Datos.addTab("ATENCIÓN", this.JPI_DUsuarios);
        GroupLayout JPI_HistoricoLayout = new GroupLayout(this.JPI_Historico);
        this.JPI_Historico.setLayout(JPI_HistoricoLayout);
        JPI_HistoricoLayout.setHorizontalGroup(JPI_HistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 1114, 32767));
        JPI_HistoricoLayout.setVerticalGroup(JPI_HistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 548, 32767));
        this.JTP_Datos.addTab("HISTÓRICO", this.JPI_Historico);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTP_Datos)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTP_Datos, -2, -1, -2).addContainerGap(-1, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtNoOrdenActionPerformed(ActionEvent evt) {
        this.txtFecha.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtNoOrdenFocusLost(FocusEvent evt) {
        mBuscarOrden();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHRLEcturaActionPerformed(ActionEvent evt) {
        if (this.JCHRLEctura.isSelected()) {
            this.xrlectura = 1;
        } else {
            this.xrlectura = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBEspecialidadItemStateChanged(ItemEvent evt) {
        mLlenarComboProfesional();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTCerrarActionPerformed(ActionEvent evt) {
        if (this.JTB_Detalle.getSelectedRow() != -1 && Long.valueOf(this.xmodelo.getValueAt(this.JTB_Detalle.getSelectedRow(), 6).toString()).longValue() > 0) {
            JD_FormularioLectura dialog = new JD_FormularioLectura(null, true, Long.valueOf(this.xmodelo.getValueAt(this.JTB_Detalle.getSelectedRow(), 6).toString()));
            dialog.setLocationRelativeTo(Principal.claseimagendx.xjifrecepcion);
            dialog.setVisible(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTConsultarHCActionPerformed(ActionEvent evt) {
        Principal.claseimagendx.cargarPantalla("Consultar HC");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTEventoAdversoActionPerformed(ActionEvent evt) {
        if (!Principal.txtNo.getText().isEmpty()) {
            mTraerIngreso();
            JDGenericoPanel detalle = new JDGenericoPanel(null, true, "Evento Adverso", this.xIdIngreso, 29);
            detalle.setLocationRelativeTo(this);
            detalle.setVisible(true);
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Se debe cargar un registro", "Verificar", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTEventoAdverso1ActionPerformed(ActionEvent evt) {
        if (!Principal.txtNo.getText().isEmpty() && this.metodos.getPregunta("Esta seguro de actualizar?") == 0) {
            for (int f = 0; f < this.JTB_Detalle.getRowCount(); f++) {
                this.sql = "update h_radiologia_detalle set Kv='" + this.xmodelo.getValueAt(f, 4) + "',mAs='" + this.xmodelo.getValueAt(f, 5) + "' where `Id_radiologia`='" + Principal.txtNo.getText() + "' and `Id_Procedimiento`='" + this.xmodelo.getValueAt(f, 0) + "'";
                this.consultas.ejecutarSQL(this.sql);
                this.consultas.cerrarConexionBd();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTCerrar1ActionPerformed(ActionEvent evt) {
        mCerrar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosed(InternalFrameEvent evt) {
        mCerrar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTSubirEstudioActionPerformed(ActionEvent evt) {
        RecepcionrxController r = new RecepcionrxController();
        JFileChooser fc = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Imagenes Dicom", new String[]{"Dicom", "dicom"});
        fc.setFileFilter(filter);
        fc.setFileSelectionMode(0);
        if (!fc.isMultiSelectionEnabled()) {
            fc.setMultiSelectionEnabled(true);
        }
        int returnVal = fc.showOpenDialog(this);
        if (returnVal == 0) {
            File[] files = fc.getSelectedFiles();
            File rutaCreada = r.crearRutaEstudioRX(Principal.informacionIps.getUrlEstudiosRX(), this.anioOrden, this.mesOrden, Principal.txtNo.getText());
            if (files != null) {
                for (File file : files) {
                    try {
                        String destino = rutaCreada.getPath() + this.metodos.getBarra() + file.getName();
                        Path Destino = Paths.get(destino, new String[0]);
                        String orig = file.getPath();
                        Path origen = Paths.get(orig, new String[0]);
                        Files.copy(origen, Destino, StandardCopyOption.REPLACE_EXISTING);
                    } catch (IOException ex) {
                        Logger.getLogger(JIFRecepcion_Rx1.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                    }
                }
            }
            mActualizaUrlEstudio();
            mBuscarOrden();
            JOptionPane.showMessageDialog((Component) null, "Estudio Adjuntado correctamente");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTB_DetalleMouseClicked(MouseEvent evt) {
        File[] ficheros;
        if (evt.getClickCount() == 2) {
            if (!this.xmodelo.getValueAt(this.JTB_Detalle.getSelectedRow(), 8).toString().isEmpty()) {
                File f = new File(this.xmodelo.getValueAt(this.JTB_Detalle.getSelectedRow(), 8).toString());
                if (f.exists() && (ficheros = f.listFiles()) != null) {
                    if (ficheros.length == 1) {
                        try {
                            Runtime.getRuntime().exec("C:\\Genoma\\Visor\\mDicom.exe  " + this.metodos.mTraerUrlBD(ficheros[0].toString()));
                            return;
                        } catch (IOException ex) {
                            Logger.getLogger(JIFRecepcion_Rx1.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                            return;
                        }
                    }
                    JDRxImagen dialogAct = new JDRxImagen(null, true, ficheros);
                    dialogAct.setLocationRelativeTo(this);
                    dialogAct.setVisible(true);
                    return;
                }
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "No se puede visualizar por que no hay estudios adjuntos", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        }
    }

    private void mLlenarComboProfesional() {
        if (this.xlleno && this.JCBEspecialidad.getSelectedIndex() != -1) {
            this.JCBProfesional.removeAllItems();
            this.xidprofe = this.consultas.llenarCombo("SELECT `Id_Persona`, `NProfesional` FROM `profesional1` WHERE (`IdEspecialidad` ='" + this.xidesps[this.JCBEspecialidad.getSelectedIndex()] + "') ORDER BY `NProfesional` ASC", this.xidprofe, this.JCBProfesional);
            this.JCBProfesional.setSelectedIndex(-1);
        }
    }

    private void mCerrar() {
        if (getName().equals("xjifrecepcionar_rx")) {
            if (Principal.claseimagendx.xjifagenda == null) {
                Principal.claseimagendx.cargarPantalla("Agenda_Rx");
                dispose();
                return;
            }
            return;
        }
        dispose();
    }

    private void mActualizarEstadoRecepOrden() {
        this.sql = "update f_ordenes set EstadoRecep=2, Id_OrdenRecep='" + Principal.txtNo.getText() + "' where Id='" + this.txtNoOrden.getText() + "'";
        this.consultas.ejecutarSQL(this.sql);
        this.consultas.cerrarConexionBd();
    }

    public void mBuscarOrden() {
        String idPaciente = "0";
        mCrearTabla();
        this.sql = "SELECT `f_itemordenesproced`.`Id_Procedimiento`, `g_procedimiento`.`Nbre`, `f_itemordenesproced`.`Cantidad`, `f_ordenes`.`FechaOrden`, `profesional1`.`Especialidad`, `profesional1`.`NProfesional`, `f_ordenes`.`Id`, `ingreso`.`Id_Usuario`, `f_ordenes`.Id_OrdenRecep, ingreso.Id_TipoAtencion, IFNULL(h_radiologia_detalle.`Kv`,0) Kv , IFNULL(h_radiologia_detalle.`mAs`,0) mAs  , IFNULL(h_radiologia_detalle.`Id`, 0) IdRecRadiologia, IF(h_radiologia_lectura_encabezado.`Id`=NULL,FALSE, TRUE)RLectura, date_format(FechaOrden,'%Y') anioOrden,date_format(FechaOrden,'%m') mesOrden, IFNULL(h_radiologia.Url_Estudio,'') as Url_Estudio FROM  `f_itemordenesproced` INNER JOIN  `f_ordenes`  ON (`f_itemordenesproced`.`Id_Ordenes` = `f_ordenes`.`Id`) INNER JOIN  `ingreso`  ON (`f_ordenes`.`Id_Ingreso` = `ingreso`.`Id`) INNER JOIN  `g_procedimiento`  ON (`f_itemordenesproced`.`Id_Procedimiento` = `g_procedimiento`.`Id`) INNER JOIN  `persona`  ON (`persona`.`Id_persona` = `ingreso`.`Id_Usuario`) INNER JOIN  `profesional1`  ON (`profesional1`.`Id_Persona` = `f_ordenes`.`Id_Profesional`) AND (`profesional1`.`IdEspecialidad` = `f_ordenes`.`Id_Especialidad`)  LEFT JOIN `h_radiologia` ON (`f_ordenes`.`Id`= `h_radiologia`.`Id_OrdenFac`) and (h_radiologia.`Estado`=1) LEFT JOIN `h_radiologia_detalle` ON (`h_radiologia_detalle`.`Id_radiologia`= `h_radiologia`.`Id`) AND (h_radiologia_detalle.`Id_Procedimiento`=`f_itemordenesproced`.`Id_Procedimiento`)   LEFT JOIN `h_radiologia_lectura_encabezado` ON (`h_radiologia_detalle`.`Id`= h_radiologia_lectura_encabezado.`Id_Radiologia`) AND (h_radiologia_lectura_encabezado.`Estado`=1)  WHERE (`f_ordenes`.`Id` ='" + this.txtNoOrden.getText() + "') GROUP BY `f_ordenes`.`Id` , `f_itemordenesproced`.`Id_Procedimiento`  ORDER BY `g_procedimiento`.`Nbre` ASC ";
        System.out.println(" Procedimiento : " + this.sql);
        ResultSet rs = this.consultas.traerRs(this.sql);
        try {
            if (rs.next()) {
                this.anioOrden = rs.getString("anioOrden");
                this.mesOrden = rs.getString("mesOrden");
                this.txtFecha.setText(this.metodos.formatoDMA.format((Date) rs.getDate("FechaOrden")));
                this.xlleno = false;
                this.JCBEspecialidad.setSelectedItem(rs.getString("Especialidad"));
                this.xlleno = true;
                mLlenarComboProfesional();
                this.txtProfesional.setText(rs.getString("NProfesional"));
                this.JCBProfesional.setSelectedItem(rs.getString("NProfesional"));
                Principal.txtNo.setText(rs.getString("Id_OrdenRecep"));
                this.xidnrecepcion = Principal.txtNo.getText();
                if (!Principal.txtNo.getText().isEmpty() && !Principal.txtNo.getText().equals("0")) {
                    this.JBTSubirEstudio.setEnabled(true);
                }
                idPaciente = rs.getString("Id_Usuario");
                this.xIdTipoAtencion = rs.getString("Id_TipoAtencion");
                rs.beforeFirst();
                int xnfila = 0;
                while (rs.next()) {
                    this.xmodelo.addRow(this.fila);
                    this.xmodelo.setValueAt(rs.getString("Id_Procedimiento"), xnfila, 0);
                    this.xmodelo.setValueAt(rs.getString("Nbre"), xnfila, 1);
                    this.xmodelo.setValueAt(rs.getString("Cantidad"), xnfila, 2);
                    this.xmodelo.setValueAt(true, xnfila, 3);
                    this.xmodelo.setValueAt(Double.valueOf(rs.getDouble("Kv")), xnfila, 4);
                    this.xmodelo.setValueAt(Double.valueOf(rs.getDouble("mAs")), xnfila, 5);
                    this.xmodelo.setValueAt(Long.valueOf(rs.getLong("IdRecRadiologia")), xnfila, 6);
                    this.xmodelo.setValueAt(Boolean.valueOf(rs.getBoolean("RLectura")), xnfila, 7);
                    if (!rs.getString("Url_Estudio").isEmpty()) {
                        this.xmodelo.setValueAt(Principal.informacionIps.getUrlEstudiosRX() + "" + rs.getString("Url_Estudio"), xnfila, 8);
                    } else {
                        this.xmodelo.setValueAt("", xnfila, 8);
                    }
                    xnfila++;
                }
            }
            rs.close();
            this.consultas.cerrarConexionBd();
            this.frmPersona.setIdPersona(idPaciente);
            this.frmPersona.buscar(1);
        } catch (SQLException ex) {
            this.consultas.mostrarErrorSQL(ex);
        }
    }

    private void cargarPanelPersonas() {
        this.frmPersona = new Persona(this);
        this.frmPersona.setVisible(false);
        this.panelPersona.setVisible(false);
        this.frmPersona.setBounds(1, 1, 950, 160);
        this.panelPersona.add(this.frmPersona);
        this.panelPersona.setVisible(true);
        this.frmPersona.setVisible(true);
    }

    private void mCrearTabla() {
        this.xmodelo = new DefaultTableModel((Object[][]) null, new String[]{"Id", "Examen", "Cantidad", "Realizar", "Kv", "mAs", "Id_RecRadiologia", "RLectura", "UrlEstudio"}) { // from class: ImagenesDx.JIFRecepcion_Rx1.13
            Class[] types = {String.class, String.class, Integer.class, Boolean.class, Double.class, Double.class, Long.class, Boolean.class, String.class};
            boolean[] canEdit = {false, false, false, true, true, true, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTB_Detalle.setModel(this.xmodelo);
        this.JTB_Detalle.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTB_Detalle.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTB_Detalle.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTB_Detalle.getColumnModel().getColumn(1).setPreferredWidth(650);
        this.JTB_Detalle.getColumnModel().getColumn(2).setPreferredWidth(50);
        this.JTB_Detalle.getColumnModel().getColumn(3).setPreferredWidth(20);
        this.JTB_Detalle.getColumnModel().getColumn(4).setPreferredWidth(10);
        this.JTB_Detalle.getColumnModel().getColumn(5).setPreferredWidth(10);
        this.JTB_Detalle.getColumnModel().getColumn(6).setPreferredWidth(10);
        this.JTB_Detalle.getColumnModel().getColumn(7).setPreferredWidth(10);
        this.JTB_Detalle.getColumnModel().getColumn(8).setPreferredWidth(10);
        this.JTB_Detalle.getColumnModel().getColumn(8).setMinWidth(0);
        this.JTB_Detalle.getColumnModel().getColumn(8).setMaxWidth(0);
        this.JTB_Detalle.setDefaultRenderer(Object.class, new MiRenderAgendaServicios());
    }

    public void grabar() {
        if (!this.xtipog) {
            if (this.xidnrecepcion.equals("0")) {
                if (this.metodos.getPregunta("Esta seguro de Grabar?") == 0 && mValidadDatos() == 1) {
                    this.frmPersona.grabar();
                    grabarCabecera();
                    grabarDetalle();
                    mActualizarEstadoRecepOrden();
                    mBuscarOrden();
                    mHabilitarLectura();
                    this.JBTSubirEstudio.setEnabled(true);
                    return;
                }
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Orden ya recepcionada", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        if (this.metodos.getPregunta("Esta seguro de Grabar?") == 0 && mValidadDatos() == 1) {
            this.frmPersona.grabar();
            grabarDetalle();
            mBuscarOrden();
            mActualizarEstadoRecepOrden();
            mHabilitarLectura();
        }
    }

    private void mHabilitarLectura() {
        if (Principal.informacionIps.getNombreIps().equals("RADIOLOGOS ASOCIADOS DE CORDOBA S.A.S.") && this.JTB_Detalle.getRowCount() == 1 && Long.valueOf(this.xmodelo.getValueAt(0, 6).toString()).longValue() > 0) {
            JD_FormularioLectura dialog = new JD_FormularioLectura(null, true, Long.valueOf(this.xmodelo.getValueAt(0, 6).toString()));
            dialog.setLocationRelativeTo(Principal.claseimagendx.xjifrecepcion);
            dialog.setVisible(true);
        }
    }

    private void grabarCabecera() {
        if (this.JCHRLEctura.isSelected()) {
            this.xidespecialidad = Long.valueOf(this.xidesps[this.JCBEspecialidad.getSelectedIndex()]).longValue();
            this.xidprofesional = Long.valueOf(this.xidprofe[this.JCBProfesional.getSelectedIndex()]).longValue();
        }
        this.sql = "INSERT INTO h_radiologia(`Fecha_Rec`, `Id_OrdenFac`,Id_TipoA,  `Observacion`, `Id_Usuario`, `Lectura`, `Id_Especialidad`, `Id_Profesional`, `UsuarioS`) VALUES('" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "','" + this.txtNoOrden.getText() + "','" + this.xIdTipoAtencion + "','" + this.txtObservaciones.getText() + "','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "','" + this.xrlectura + "','" + this.xidespecialidad + "','" + this.xidprofesional + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
        Principal.txtNo.setText(this.consultas.ejecutarSQLId(this.sql));
        this.consultas.cerrarConexionBd();
    }

    private void grabarDetalle() {
        for (int f = 0; f < this.JTB_Detalle.getRowCount(); f++) {
            if (Integer.parseInt(this.xmodelo.getValueAt(f, 2).toString()) > 0 && this.xmodelo.getValueAt(f, 3).equals(true)) {
                this.sql = "INSERT INTO h_radiologia_detalle(`Id_radiologia`, `Id_Procedimiento`, `Cant`, Kv, mAs) VALUES('" + Principal.txtNo.getText() + "','" + this.xmodelo.getValueAt(f, 0) + "','" + this.xmodelo.getValueAt(f, 2) + "','" + this.xmodelo.getValueAt(f, 4) + "','" + this.xmodelo.getValueAt(f, 5) + "')";
                this.consultas.ejecutarSQL(this.sql);
                this.consultas.cerrarConexionBd();
            }
        }
    }

    private void mNuevo() {
        this.xlleno = false;
        cargarPanelPersonas();
        this.frmPersona.panelPersona.setEnabledAt(0, true);
        this.frmPersona.panelPersona.setSelectedIndex(0);
        this.JCBProfesional.removeAllItems();
        this.JCBEspecialidad.removeAllItems();
        this.xidespecialidad = 0L;
        this.xidprofesional = 0L;
        this.xidesps = this.consultas.llenarCombo("SELECT `IdEspecialidad`, `Especialidad` FROM  `profesional1` WHERE (`LecturaRx` =1) GROUP BY `IdEspecialidad` ORDER BY `Especialidad` ASC", this.xidesps, this.JCBEspecialidad);
        this.consultas.cerrarConexionBd();
        this.JCBEspecialidad.setSelectedIndex(-1);
        this.frmPersona.txtHistoria.requestFocus();
        this.xlleno = true;
        if (!Principal.txtNo.getText().isEmpty()) {
            this.JBTSubirEstudio.setEnabled(true);
        }
    }

    private void mTraerIngreso() {
        this.sql = "SELECT `Id_Ingreso` FROM `f_ordenes` WHERE (`Id` ='" + this.txtNoOrden.getText() + "');";
        ResultSet rs = this.consultas.traerRs(this.sql);
        try {
            if (rs.next()) {
                this.xIdIngreso = rs.getString("Id_Ingreso");
            }
            rs.close();
            this.consultas.cerrarConexionBd();
        } catch (SQLException ex) {
            this.consultas.mostrarErrorSQL(ex);
        }
    }

    private int mValidadDatos() {
        int retorno = 0;
        if (this.txtNoOrden.getText() == null || this.txtNoOrden.getText().isEmpty()) {
            this.metodos.mostrarMensaje("Por favor digite un Número de Orden / Factura");
        } else if (this.txtFecha.getText() == null || this.txtProfesional.getText() == null || this.txtProfesional.getText().isEmpty()) {
            this.metodos.mostrarMensaje("Por favor digite una Orden que contenga datos");
        } else if (this.JTB_Detalle.getRowCount() < 0) {
            this.metodos.mostrarMensaje("Por favor seleccione los Exámenes que desea cargar");
        } else {
            retorno = 1;
        }
        return retorno;
    }

    private void mActualizaUrlEstudio() {
        String urlRx;
        StringBuilder url = new StringBuilder();
        url.append(this.metodos.getBarra()).append(this.anioOrden).append(this.metodos.getBarra()).append(this.mesOrden).append(this.metodos.getBarra()).append(Principal.txtNo.getText());
        if (System.getProperty("os.name").substring(0, 3).equals("Win")) {
            urlRx = url.toString().replace("\\", "\\\\");
        } else {
            urlRx = url.toString();
        }
        String sql = "UPDATE h_radiologia SET Url_Estudio='" + urlRx + "' WHERE Id=" + Integer.valueOf(Principal.txtNo.getText()) + ";";
        this.consultas.ejecutarSQL(sql);
        this.consultas.cerrarConexionBd();
    }

    /* JADX INFO: loaded from: GenomaP.jar:ImagenesDx/JIFRecepcion_Rx1$MiRenderAgendaServicios.class */
    public class MiRenderAgendaServicios extends DefaultTableCellRenderer {
        public MiRenderAgendaServicios() {
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (!table.getValueAt(row, 8).toString().isEmpty()) {
                cell.setBackground(new Color(77, 227, 109));
                cell.setForeground(Color.BLACK);
            }
            return cell;
        }
    }

    public void anular() {
        if (this.xidnrecepcion.equals("0")) {
            this.metodos.mostrarMensaje("Esta recepcion se encuentra sin grabar");
        } else if (Principal.txtEstado.getText().equals("ANULADA")) {
            this.metodos.mostrarMensaje("Esta recepcion ya se encuentra Anulada.");
        } else {
            Anular frm = new Anular(null, true, "Radiologia", 29);
            frm.setVisible(true);
        }
    }

    public void anularOrden(String razon) {
        this.sql = "UPDATE h_radiologia SET Estado =0 WHERE Id='" + Principal.txtNo.getText() + "'";
        this.consultas.ejecutarSQL(this.sql);
        this.consultas.cerrarConexionBd();
        this.sql = "UPDATE f_ordenes SET Id_OrdenRecep =0, EstadoRecep=0 WHERE Id='" + this.txtNoOrden.getText() + "'";
        this.consultas.ejecutarSQL(this.sql);
        this.consultas.cerrarConexionBd();
        this.metodos.marcarEstado(1);
        this.metodos.mostrarMensaje("Esta recepcion de radiologia, ya se encuentra anulada");
    }
}
