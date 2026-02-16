package ParametrizacionN;

import Acceso.Principal;
import General.BuscarPersona;
import General.Persona;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

/* JADX INFO: loaded from: GenomaP.jar:ParametrizacionN/JIFGProfesional.class */
public class JIFGProfesional extends JInternalFrame {
    public Persona xjppersona;
    private DefaultTableModel xmodelo;
    private Object[] xdato;
    private File xfile;
    private String[] xidespecialidad;
    private ButtonGroup JBGOpciones;
    private JButton JBTGrabar;
    private JComboBox JCBEspecialidad;
    private JCheckBox JCHActivoCita;
    private JCheckBox JCHEsVacunador;
    private JCheckBox JCHEstadoEspe;
    private JCheckBox JCHEstadoProfesional;
    private JCheckBox JCHIps;
    private JPanel JPIDatosProf;
    private JPanel JPIFDatosUsuario;
    private JScrollPane JSPDetalleEspecialidad;
    private JSpinner JSPNHoras;
    private JSpinner JSPNVisitas;
    private JTable JTDetalle;
    public JFormattedTextField JTFFVHora;
    private JTextField JTFLExpedicion;
    private JTextField JTFRuta;
    private JTextField JTFTarjetaP;
    private ConsultasMySQL xconsultas = new ConsultasMySQL();
    private Metodos xmetodos = new Metodos();
    private int xesprofesional = 0;
    private int xestadoprofesional = 0;
    private int xactivocita = 1;
    private int xips = 0;
    private int xVacunador = 1;
    private boolean xencontroprofesional = false;
    private boolean xencontroespprofesional = false;

    public JIFGProfesional() {
        initComponents();
        mCargasPanelUsuario();
        this.xidespecialidad = this.xconsultas.llenarCombo("SELECT Id, Nbre FROM g_especialidad WHERE (Estado =0) ORDER BY Nbre ASC", this.xidespecialidad, this.JCBEspecialidad);
        this.JCBEspecialidad.setSelectedIndex(-1);
        this.xconsultas.cerrarConexionBd();
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v44, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGOpciones = new ButtonGroup();
        this.JPIFDatosUsuario = new JPanel();
        this.JPIDatosProf = new JPanel();
        this.JCBEspecialidad = new JComboBox();
        this.JTFTarjetaP = new JTextField();
        this.JTFLExpedicion = new JTextField();
        this.JTFRuta = new JTextField();
        this.JSPNVisitas = new JSpinner();
        this.JSPNHoras = new JSpinner();
        this.JTFFVHora = new JFormattedTextField();
        this.JCHActivoCita = new JCheckBox();
        this.JCHIps = new JCheckBox();
        this.JCHEstadoEspe = new JCheckBox();
        this.JCHEstadoProfesional = new JCheckBox();
        this.JBTGrabar = new JButton();
        this.JSPDetalleEspecialidad = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JCHEsVacunador = new JCheckBox();
        setClosable(true);
        setIconifiable(true);
        setTitle("PROFESIONAL");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setMaximumSize(null);
        setName("jifprofesional");
        addInternalFrameListener(new InternalFrameListener() { // from class: ParametrizacionN.JIFGProfesional.1
            public void internalFrameActivated(InternalFrameEvent evt) {
            }

            public void internalFrameClosed(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                JIFGProfesional.this.formInternalFrameClosing(evt);
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
        this.JPIFDatosUsuario.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN DEL USUARIO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        GroupLayout JPIFDatosUsuarioLayout = new GroupLayout(this.JPIFDatosUsuario);
        this.JPIFDatosUsuario.setLayout(JPIFDatosUsuarioLayout);
        JPIFDatosUsuarioLayout.setHorizontalGroup(JPIFDatosUsuarioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 0, 32767));
        JPIFDatosUsuarioLayout.setVerticalGroup(JPIFDatosUsuarioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 168, 32767));
        this.JPIDatosProf.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS DEL PROFESIONAL", 0, 0, new Font("Arial", 1, 13), new Color(0, 102, 51)));
        this.JCBEspecialidad.setFont(new Font("Arial", 1, 12));
        this.JCBEspecialidad.setBorder(BorderFactory.createTitledBorder((Border) null, "Especialidad", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFTarjetaP.setFont(new Font("Arial", 1, 12));
        this.JTFTarjetaP.setBorder(BorderFactory.createTitledBorder((Border) null, "Tarjeta", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFLExpedicion.setFont(new Font("Arial", 1, 12));
        this.JTFLExpedicion.setBorder(BorderFactory.createTitledBorder((Border) null, "Lugar Expedición", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ruta Firma", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFGProfesional.2
            public void mouseClicked(MouseEvent evt) {
                JIFGProfesional.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JSPNVisitas.setFont(new Font("Arial", 1, 12));
        this.JSPNVisitas.setModel(new SpinnerNumberModel(0, 0, (Comparable) null, 1));
        this.JSPNVisitas.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Visitas", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPNHoras.setFont(new Font("Arial", 1, 12));
        this.JSPNHoras.setModel(new SpinnerNumberModel(0, 0, (Comparable) null, 1));
        this.JSPNHoras.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Horas", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFVHora.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor Hora", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFVHora.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFVHora.setHorizontalAlignment(4);
        this.JTFFVHora.setText("0");
        this.JTFFVHora.setFont(new Font("Arial", 1, 12));
        this.JCHActivoCita.setFont(new Font("Arial", 1, 12));
        this.JCHActivoCita.setForeground(Color.blue);
        this.JCHActivoCita.setText("Activo Cita?");
        this.JCHActivoCita.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFGProfesional.3
            public void actionPerformed(ActionEvent evt) {
                JIFGProfesional.this.JCHActivoCitaActionPerformed(evt);
            }
        });
        this.JCHIps.setFont(new Font("Arial", 1, 12));
        this.JCHIps.setForeground(Color.blue);
        this.JCHIps.setText("Ips?");
        this.JCHIps.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFGProfesional.4
            public void actionPerformed(ActionEvent evt) {
                JIFGProfesional.this.JCHIpsActionPerformed(evt);
            }
        });
        this.JCHEstadoEspe.setFont(new Font("Arial", 1, 12));
        this.JCHEstadoEspe.setForeground(Color.blue);
        this.JCHEstadoEspe.setSelected(true);
        this.JCHEstadoEspe.setText("Estado");
        this.JCHEstadoEspe.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFGProfesional.5
            public void actionPerformed(ActionEvent evt) {
                JIFGProfesional.this.JCHEstadoEspeActionPerformed(evt);
            }
        });
        this.JCHEstadoProfesional.setFont(new Font("Arial", 1, 12));
        this.JCHEstadoProfesional.setForeground(Color.blue);
        this.JCHEstadoProfesional.setSelected(true);
        this.JCHEstadoProfesional.setText("Estado Profesional");
        this.JCHEstadoProfesional.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFGProfesional.6
            public void actionPerformed(ActionEvent evt) {
                JIFGProfesional.this.JCHEstadoProfesionalActionPerformed(evt);
            }
        });
        this.JBTGrabar.setFont(new Font("Arial", 1, 12));
        this.JBTGrabar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTGrabar.setText("Grabar");
        this.JBTGrabar.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFGProfesional.7
            public void actionPerformed(ActionEvent evt) {
                JIFGProfesional.this.JBTGrabarActionPerformed(evt);
            }
        });
        this.JSPDetalleEspecialidad.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalle.setSelectionMode(0);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFGProfesional.8
            public void mouseClicked(MouseEvent evt) {
                JIFGProfesional.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalleEspecialidad.setViewportView(this.JTDetalle);
        this.JCHEsVacunador.setFont(new Font("Arial", 1, 12));
        this.JCHEsVacunador.setForeground(Color.blue);
        this.JCHEsVacunador.setText("Es Vacunador");
        this.JCHEsVacunador.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFGProfesional.9
            public void actionPerformed(ActionEvent evt) {
                JIFGProfesional.this.JCHEsVacunadorActionPerformed(evt);
            }
        });
        GroupLayout JPIDatosProfLayout = new GroupLayout(this.JPIDatosProf);
        this.JPIDatosProf.setLayout(JPIDatosProfLayout);
        JPIDatosProfLayout.setHorizontalGroup(JPIDatosProfLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosProfLayout.createSequentialGroup().addGap(10, 10, 10).addGroup(JPIDatosProfLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosProfLayout.createSequentialGroup().addGroup(JPIDatosProfLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosProfLayout.createSequentialGroup().addComponent(this.JSPNVisitas, -2, 91, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPNHoras, -2, 91, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFVHora, -2, 99, -2).addGap(22, 22, 22).addComponent(this.JCHActivoCita, -2, 97, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHIps, -2, 53, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHEstadoProfesional).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHEsVacunador).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 28, 32767).addComponent(this.JCHEstadoEspe).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBTGrabar, -2, 233, -2)).addComponent(this.JSPDetalleEspecialidad)).addGap(10, 10, 10)).addGroup(JPIDatosProfLayout.createSequentialGroup().addComponent(this.JCBEspecialidad, -2, 353, -2).addGap(18, 18, 18).addComponent(this.JTFTarjetaP, -2, 130, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFLExpedicion, -2, 162, -2).addGap(18, 18, 18).addComponent(this.JTFRuta).addContainerGap()))));
        JPIDatosProfLayout.setVerticalGroup(JPIDatosProfLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosProfLayout.createSequentialGroup().addGap(11, 11, 11).addGroup(JPIDatosProfLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBEspecialidad, -2, -1, -2).addComponent(this.JTFTarjetaP, -2, -1, -2).addComponent(this.JTFLExpedicion, -2, -1, -2).addComponent(this.JTFRuta, -2, -1, -2)).addGroup(JPIDatosProfLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosProfLayout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.JBTGrabar, -2, 45, -2)).addGroup(JPIDatosProfLayout.createSequentialGroup().addGap(10, 10, 10).addGroup(JPIDatosProfLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JSPNVisitas, -2, 46, -2).addComponent(this.JSPNHoras, -2, 46, -2).addComponent(this.JTFFVHora).addComponent(this.JCHIps).addComponent(this.JCHEstadoProfesional, -2, 36, -2).addComponent(this.JCHEstadoEspe, -2, 36, -2).addComponent(this.JCHActivoCita).addComponent(this.JCHEsVacunador, -2, 36, -2)))).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPDetalleEspecialidad, -2, 116, -2).addGap(10, 10, 10)));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(10, 10, 10).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPIDatosProf, -1, -1, 32767).addComponent(this.JPIFDatosUsuario, -1, -1, 32767)).addGap(10, 10, 10)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.JPIFDatosUsuario, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPIDatosProf, -2, -1, -2).addGap(10, 10, 10)));
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
    public void JCHActivoCitaActionPerformed(ActionEvent evt) {
        mIniciarCheck();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHIpsActionPerformed(ActionEvent evt) {
        mIniciarCheck();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JFileChooser xfilec = new JFileChooser("C:\\Genoma\\firmas");
            int xv = xfilec.showOpenDialog(this);
            if (xv == 0) {
                this.xfile = xfilec.getSelectedFile();
                System.out.println(this.xfile.getPath());
                this.JTFRuta.setText(this.xmetodos.mTraerUrlBD(this.xfile.getPath()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTGrabarActionPerformed(ActionEvent evt) {
        mGrabarProfesional();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEstadoEspeActionPerformed(ActionEvent evt) {
        mIniciarCheck();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEstadoProfesionalActionPerformed(ActionEvent evt) {
        mIniciarCheck();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            this.JCBEspecialidad.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
            this.JCHEstadoEspe.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString()).booleanValue());
            mIniciarCheck();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEsVacunadorActionPerformed(ActionEvent evt) {
        mIniciarCheck();
    }

    private void mIniciarCheck() {
        if (this.JCHEstadoProfesional.isSelected()) {
            this.xestadoprofesional = 0;
        } else {
            this.xestadoprofesional = 1;
        }
        if (this.JCHEstadoEspe.isSelected()) {
            this.xesprofesional = 0;
        } else {
            this.xesprofesional = 1;
        }
        if (this.JCHActivoCita.isSelected()) {
            this.xactivocita = 0;
        } else {
            this.xactivocita = 1;
        }
        if (this.JCHIps.isSelected()) {
            this.xips = 1;
        } else {
            this.xips = 0;
        }
        if (this.JCHEsVacunador.isSelected()) {
            this.xVacunador = 0;
        } else {
            this.xVacunador = 1;
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

    public void mBuscarProfesional(String xidusuario) {
        String sql = "SELECT Tarjeta, Activo_Cita, P_Ips, if(DireccionF is null,'',DireccionF)as Firma, Id_Persona, Estado, NVisitas, NHorasC, ValorHoraC, LExpedicion, EsVacunador  FROM g_profesional WHERE (Id_Persona ='" + xidusuario + "')";
        ResultSet xrs = this.xconsultas.traerRs(sql);
        try {
            if (xrs.next()) {
                xrs.first();
                this.JTFTarjetaP.setText(xrs.getString(1));
                this.JCHActivoCita.setSelected(!xrs.getBoolean(2));
                this.JCHIps.setSelected(xrs.getBoolean(3));
                this.JTFRuta.setText(this.xmetodos.mTraerUrlBD(xrs.getString(4)));
                this.JCHEstadoProfesional.setSelected(!xrs.getBoolean(6));
                this.JSPNVisitas.setValue(Integer.valueOf(xrs.getInt(7)));
                this.JSPNHoras.setValue(Integer.valueOf(xrs.getInt(8)));
                this.JTFFVHora.setValue(Double.valueOf(xrs.getDouble(9)));
                this.JTFLExpedicion.setText(xrs.getString(10));
                this.JCHEsVacunador.setSelected(xrs.getBoolean(11));
                this.xencontroprofesional = true;
                xrs.close();
                this.xconsultas.cerrarConexionBd();
                mCargarDatosTablaProfesional(xidusuario);
                mIniciarCheck();
            }
        } catch (SQLException ex) {
            Logger.getLogger(JIFGProfesional.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mNuevo() {
        this.xjppersona.nuevo();
        this.xencontroprofesional = false;
        this.xesprofesional = 0;
        this.xactivocita = 1;
        this.xesprofesional = 0;
        this.xips = 0;
        this.JTFTarjetaP.setText("");
        this.JTFRuta.setText("");
        this.JTFLExpedicion.setText("");
        this.JCBEspecialidad.setSelectedIndex(-1);
        this.JCHActivoCita.setSelected(false);
        this.JCHEstadoEspe.setSelected(false);
        this.JCHEstadoProfesional.setSelected(true);
        this.JCHEsVacunador.setSelected(false);
        this.JCHIps.setSelected(false);
        this.JSPNVisitas.setValue(new Integer(0));
        this.JSPNHoras.setValue(new Integer(0));
        this.JTFFVHora.setValue(new Integer(0));
        mCrearModeloDatosProfesional();
    }

    private void mGrabarProfesional() {
        if (!this.xjppersona.getIdPersona().equals("") && this.xjppersona.getIdPersona() != null) {
            if (this.JCBEspecialidad.getSelectedIndex() != -1) {
                int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (n == 0) {
                    if (this.xencontroprofesional) {
                        if (this.JTDetalle.getSelectedRow() != -1) {
                            String sql = "update g_profesional set Tarjeta='" + this.JTFTarjetaP.getText() + "', Activo_Cita='" + this.xactivocita + "', P_Ips='" + this.xips + "', DireccionF='" + this.JTFRuta.getText() + "', NVisitas='" + this.JSPNVisitas.getValue() + "', NHorasC='" + this.JSPNHoras.getValue() + "', ValorHoraC='" + this.JTFFVHora.getValue() + "', Estado='" + this.xestadoprofesional + "', LExpedicion='" + this.JTFLExpedicion.getText() + "', EsVacunador='" + this.xVacunador + "' where Id_Persona='" + this.xjppersona.getIdPersona() + "'";
                            this.xconsultas.ejecutarSQL(sql);
                            this.xconsultas.cerrarConexionBd();
                            if (this.JTDetalle.getSelectedRow() != -1) {
                                String sql2 = "update g_profesionalespecial set Estado='" + this.xesprofesional + "' where Id_Profesional='" + this.xjppersona.getIdPersona() + "' and Id_Especialidad='" + this.xidespecialidad[this.JCBEspecialidad.getSelectedIndex()] + "'";
                                this.xconsultas.ejecutarSQL(sql2);
                                this.xconsultas.cerrarConexionBd();
                            } else {
                                String sql3 = "Insert into g_profesionalespecial(Id_Profesional, Id_Especialidad, Estado, Fecha, UsuarioS) values ('" + this.xjppersona.getIdPersona() + "','" + this.xidespecialidad[this.JCBEspecialidad.getSelectedIndex()] + "','" + this.xesprofesional + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                                this.xconsultas.ejecutarSQL(sql3);
                                this.xconsultas.cerrarConexionBd();
                            }
                        }
                    } else {
                        this.xjppersona.grabar();
                        String sql4 = "Insert ignore into g_profesional(Id_persona, Tarjeta, LExpedicion, Activo_Cita, P_Ips, DireccionF, NVisitas, NHorasC, ValorHoraC, Estado,EsVacunador, Fecha, UsuarioS) values ('" + this.xjppersona.getIdPersona() + "','" + this.JTFTarjetaP.getText() + "','" + this.JTFLExpedicion.getText() + "','" + this.xactivocita + "','" + this.xips + "','" + this.JTFRuta.getText() + "','" + this.JSPNVisitas.getValue() + "','" + this.JSPNHoras.getValue() + "','" + this.JTFFVHora.getValue() + "','" + this.xestadoprofesional + "','" + this.xVacunador + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                        this.xconsultas.ejecutarSQL(sql4);
                        this.xconsultas.cerrarConexionBd();
                        this.xencontroprofesional = true;
                        String sql5 = "Insert into g_profesionalespecial(Id_Profesional, Id_Especialidad, Estado, Fecha, UsuarioS) values ('" + this.xjppersona.getIdPersona() + "','" + this.xidespecialidad[this.JCBEspecialidad.getSelectedIndex()] + "','" + this.xesprofesional + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                        this.xconsultas.ejecutarSQL(sql5);
                        this.xconsultas.cerrarConexionBd();
                    }
                    mCargarDatosTablaProfesional(this.xjppersona.getIdPersona());
                    return;
                }
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una especialidad", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBEspecialidad.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una persona", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatosProfesional() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Especialidad", "Estado"}) { // from class: ParametrizacionN.JIFGProfesional.10
            Class[] types = {String.class, Boolean.class};
            boolean[] canEdit = {false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(50);
    }

    private void mCargarDatosTablaProfesional(String xidp) {
        try {
            mCrearModeloDatosProfesional();
            String sql = "SELECT g_especialidad.Nbre, g_profesionalespecial.Estado FROM g_profesionalespecial INNER JOIN g_especialidad  ON (g_profesionalespecial.Id_Especialidad = g_especialidad.Id) WHERE (g_profesionalespecial.Id_Profesional ='" + xidp + "')  ORDER BY g_especialidad.Estado ASC ";
            ResultSet xrs = this.xconsultas.traerRs(sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(xrs.getString(1), n, 0);
                    this.xmodelo.setValueAt(Boolean.valueOf(!xrs.getBoolean(2)), n, 1);
                    this.xencontroespprofesional = true;
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

    public void mGrabar() {
        if (this.xjppersona.getIdPersona() != null) {
            this.xjppersona.grabar();
            mGrabarProfesional();
        }
    }
}
