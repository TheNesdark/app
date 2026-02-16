package ParametrizacionN;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyVetoException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
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
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:ParametrizacionN/JIFEArmadoEncuesta.class */
public class JIFEArmadoEncuesta extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private DefaultTableModel xmodelo1;
    private DefaultTableModel xmodelo2;
    private DefaultTableModel xmodelo_p_x_e;
    private Object[] xdatos;
    private String xnombre;
    private String[] xidarea;
    private String[] xidencuesta;
    private String[] xidtipop;
    public String[][] xidtiposolicitud;
    public String[][] xidproceso;
    private JButton JBActualizar;
    private ButtonGroup JBGDatos;
    private JButton JBTGrabar;
    private JButton JBTGrabarP;
    private JComboBox JCBEncuesta;
    private JComboBox JCBProceso;
    private JComboBox JCBTProceso;
    private JCheckBox JCHEspecial;
    private JDateChooser JDFechaCierre;
    private JPanel JPIAsignacion;
    private JPanel JPIDatos;
    private JPanel JPIDatosA;
    private JPanel JPIProceso;
    private JPanel JPIUsuario;
    private JRadioButton JRBClienteI;
    private JRadioButton JRBProceso;
    private JScrollPane JSPDetalle;
    private JScrollPane JSPProceso;
    private JScrollPane JSPUsuarios;
    private JTable JTDetalle;
    private JTable JTDetalleProceso;
    private JTable JTDetallePxE;
    private JTable JTDetalleUsuario;
    private JTextField JTFNombre;
    private JTabbedPane JTPDatosA;
    private JTabbedPane JTPDetalle;
    private JPanel jPanel1;
    private JScrollPane jScrollPane1;
    private ConsultasMySQL xconsulta = new ConsultasMySQL();
    private Metodos xmetodos = new Metodos();
    private int xestado = 0;
    private int xespecial = 0;
    private boolean xlleno = false;

    public JIFEArmadoEncuesta(String xnombre) {
        initComponents();
        this.xnombre = xnombre;
        setTitle(xnombre.toUpperCase());
        mNuevo();
        mCargarDatosPxE(0);
    }

    /* JADX WARN: Type inference failed for: r3v121, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v22, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v45, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v74, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGDatos = new ButtonGroup();
        this.JPIDatos = new JPanel();
        this.JCBEncuesta = new JComboBox();
        this.JTFNombre = new JTextField();
        this.JTPDetalle = new JTabbedPane();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JPIAsignacion = new JPanel();
        this.JPIDatosA = new JPanel();
        this.JRBClienteI = new JRadioButton();
        this.JRBProceso = new JRadioButton();
        this.JTPDatosA = new JTabbedPane();
        this.JPIUsuario = new JPanel();
        this.JSPUsuarios = new JScrollPane();
        this.JTDetalleUsuario = new JTable();
        this.JBTGrabar = new JButton();
        this.JPIProceso = new JPanel();
        this.JSPProceso = new JScrollPane();
        this.JTDetalleProceso = new JTable();
        this.JBTGrabarP = new JButton();
        this.JDFechaCierre = new JDateChooser();
        this.JCHEspecial = new JCheckBox();
        this.JCBTProceso = new JComboBox();
        this.JCBProceso = new JComboBox();
        this.jPanel1 = new JPanel();
        this.jScrollPane1 = new JScrollPane();
        this.JTDetallePxE = new JTable();
        this.JBActualizar = new JButton();
        setClosable(true);
        setIconifiable(true);
        setTitle("ARMADO DE ENCUESTA");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifarmadoencuesta");
        try {
            setSelected(true);
        } catch (PropertyVetoException e1) {
            e1.printStackTrace();
        }
        addInternalFrameListener(new InternalFrameListener() { // from class: ParametrizacionN.JIFEArmadoEncuesta.1
            public void internalFrameActivated(InternalFrameEvent evt) {
            }

            public void internalFrameClosed(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                JIFEArmadoEncuesta.this.formInternalFrameClosing(evt);
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
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JCBEncuesta.setFont(new Font("Arial", 1, 12));
        this.JCBEncuesta.setBorder(BorderFactory.createTitledBorder((Border) null, "Encuesta", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBEncuesta.addItemListener(new ItemListener() { // from class: ParametrizacionN.JIFEArmadoEncuesta.2
            public void itemStateChanged(ItemEvent evt) {
                JIFEArmadoEncuesta.this.JCBEncuestaItemStateChanged(evt);
            }
        });
        this.JTFNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 1, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JCBEncuesta, -2, 731, -2).addGap(18, 18, 18).addComponent(this.JTFNombre).addContainerGap()));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBEncuesta).addComponent(this.JTFNombre)).addContainerGap()));
        this.JTPDetalle.setForeground(Color.red);
        this.JTPDetalle.setFont(new Font("Arial", 1, 12));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.setSelectionMode(0);
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.JTPDetalle.addTab("PREGUNTAS", this.JSPDetalle);
        this.JPIDatosA.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo", 0, 0, new Font("Arial", 1, 12), new Color(0, 102, 0)));
        this.JBGDatos.add(this.JRBClienteI);
        this.JRBClienteI.setFont(new Font("Arial", 1, 12));
        this.JRBClienteI.setSelected(true);
        this.JRBClienteI.setText("Cliente Interno");
        this.JRBClienteI.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFEArmadoEncuesta.3
            public void actionPerformed(ActionEvent evt) {
                JIFEArmadoEncuesta.this.JRBClienteIActionPerformed(evt);
            }
        });
        this.JBGDatos.add(this.JRBProceso);
        this.JRBProceso.setFont(new Font("Arial", 1, 12));
        this.JRBProceso.setText("Proceso");
        this.JRBProceso.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFEArmadoEncuesta.4
            public void actionPerformed(ActionEvent evt) {
                JIFEArmadoEncuesta.this.JRBProcesoActionPerformed(evt);
            }
        });
        GroupLayout JPIDatosALayout = new GroupLayout(this.JPIDatosA);
        this.JPIDatosA.setLayout(JPIDatosALayout);
        JPIDatosALayout.setHorizontalGroup(JPIDatosALayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosALayout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.JRBClienteI).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBProceso).addGap(16, 16, 16)));
        JPIDatosALayout.setVerticalGroup(JPIDatosALayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosALayout.createSequentialGroup().addGroup(JPIDatosALayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBClienteI).addComponent(this.JRBProceso)).addContainerGap()));
        this.JTPDatosA.setForeground(new Color(0, 103, 0));
        this.JTPDatosA.setTabPlacement(2);
        this.JTPDatosA.setFont(new Font("Arial", 1, 12));
        this.JSPUsuarios.setBorder(BorderFactory.createTitledBorder((Border) null, "", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JTDetalleUsuario.setFont(new Font("Arial", 1, 12));
        this.JTDetalleUsuario.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalleUsuario.setRowHeight(25);
        this.JTDetalleUsuario.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalleUsuario.setSelectionForeground(Color.red);
        this.JTDetalleUsuario.setSelectionMode(0);
        this.JSPUsuarios.setViewportView(this.JTDetalleUsuario);
        this.JBTGrabar.setFont(new Font("Arial", 1, 12));
        this.JBTGrabar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTGrabar.setText("Crear y Asignar");
        this.JBTGrabar.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFEArmadoEncuesta.5
            public void actionPerformed(ActionEvent evt) {
                JIFEArmadoEncuesta.this.JBTGrabarActionPerformed(evt);
            }
        });
        GroupLayout JPIUsuarioLayout = new GroupLayout(this.JPIUsuario);
        this.JPIUsuario.setLayout(JPIUsuarioLayout);
        JPIUsuarioLayout.setHorizontalGroup(JPIUsuarioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIUsuarioLayout.createSequentialGroup().addContainerGap().addComponent(this.JBTGrabar, -1, 915, 32767).addContainerGap()).addGroup(JPIUsuarioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIUsuarioLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPUsuarios, -2, 910, -2).addContainerGap(15, 32767))));
        JPIUsuarioLayout.setVerticalGroup(JPIUsuarioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIUsuarioLayout.createSequentialGroup().addContainerGap(242, 32767).addComponent(this.JBTGrabar, -2, 42, -2).addContainerGap()).addGroup(JPIUsuarioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIUsuarioLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPUsuarios, -2, 210, -2).addContainerGap(74, 32767))));
        this.JTPDatosA.addTab("USUARIO", this.JPIUsuario);
        this.JSPProceso.setBorder(BorderFactory.createTitledBorder((Border) null, "", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JTDetalleProceso.setFont(new Font("Arial", 1, 12));
        this.JTDetalleProceso.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalleProceso.setRowHeight(25);
        this.JTDetalleProceso.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalleProceso.setSelectionForeground(Color.red);
        this.JTDetalleProceso.setSelectionMode(0);
        this.JSPProceso.setViewportView(this.JTDetalleProceso);
        this.JBTGrabarP.setFont(new Font("Arial", 1, 12));
        this.JBTGrabarP.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTGrabarP.setText("Asignar");
        this.JBTGrabarP.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFEArmadoEncuesta.6
            public void actionPerformed(ActionEvent evt) {
                JIFEArmadoEncuesta.this.JBTGrabarPActionPerformed(evt);
            }
        });
        GroupLayout JPIProcesoLayout = new GroupLayout(this.JPIProceso);
        this.JPIProceso.setLayout(JPIProcesoLayout);
        JPIProcesoLayout.setHorizontalGroup(JPIProcesoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIProcesoLayout.createSequentialGroup().addContainerGap().addComponent(this.JBTGrabarP, -1, 915, 32767).addContainerGap()).addGroup(JPIProcesoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIProcesoLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPProceso, -2, 910, -2).addContainerGap(15, 32767))));
        JPIProcesoLayout.setVerticalGroup(JPIProcesoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIProcesoLayout.createSequentialGroup().addContainerGap(242, 32767).addComponent(this.JBTGrabarP, -2, 42, -2).addContainerGap()).addGroup(JPIProcesoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIProcesoLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPProceso, -2, 219, -2).addContainerGap(65, 32767))));
        this.JTPDatosA.addTab("PROCESO", this.JPIProceso);
        this.JDFechaCierre.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha P/Cierre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaCierre.setDateFormatString("dd/MM/yyyy");
        this.JDFechaCierre.setFont(new Font("Arial", 1, 12));
        this.JCHEspecial.setFont(new Font("Arial", 1, 12));
        this.JCHEspecial.setText("Especial");
        this.JCHEspecial.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFEArmadoEncuesta.7
            public void actionPerformed(ActionEvent evt) {
                JIFEArmadoEncuesta.this.JCHEspecialActionPerformed(evt);
            }
        });
        this.JCBTProceso.setFont(new Font("Arial", 1, 12));
        this.JCBTProceso.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Proceso", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTProceso.addItemListener(new ItemListener() { // from class: ParametrizacionN.JIFEArmadoEncuesta.8
            public void itemStateChanged(ItemEvent evt) {
                JIFEArmadoEncuesta.this.JCBTProcesoItemStateChanged(evt);
            }
        });
        this.JCBProceso.setFont(new Font("Arial", 1, 12));
        this.JCBProceso.setBorder(BorderFactory.createTitledBorder((Border) null, "Proceso", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPIAsignacionLayout = new GroupLayout(this.JPIAsignacion);
        this.JPIAsignacion.setLayout(JPIAsignacionLayout);
        JPIAsignacionLayout.setHorizontalGroup(JPIAsignacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIAsignacionLayout.createSequentialGroup().addContainerGap().addGroup(JPIAsignacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTPDatosA).addGroup(JPIAsignacionLayout.createSequentialGroup().addComponent(this.JPIDatosA, -2, 202, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JDFechaCierre, -2, 118, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHEspecial).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBTProceso, -2, 236, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBProceso, -2, 356, -2))).addContainerGap()));
        JPIAsignacionLayout.setVerticalGroup(JPIAsignacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIAsignacionLayout.createSequentialGroup().addContainerGap().addGroup(JPIAsignacionLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPIAsignacionLayout.createSequentialGroup().addGroup(JPIAsignacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JDFechaCierre, GroupLayout.Alignment.TRAILING, -1, 67, 32767).addComponent(this.JPIDatosA, GroupLayout.Alignment.TRAILING, -2, 52, -2).addGroup(GroupLayout.Alignment.TRAILING, JPIAsignacionLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBTProceso, -2, -1, -2).addComponent(this.JCBProceso, -2, -1, -2))).addGap(13, 13, 13)).addGroup(JPIAsignacionLayout.createSequentialGroup().addComponent(this.JCHEspecial).addGap(18, 18, 18))).addComponent(this.JTPDatosA, -2, 300, -2).addContainerGap()));
        this.JTPDetalle.addTab("ASIGNACIÓN", this.JPIAsignacion);
        this.JTDetallePxE.setFont(new Font("Arial", 1, 12));
        this.JTDetallePxE.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetallePxE.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFEArmadoEncuesta.9
            public void mouseClicked(MouseEvent evt) {
                JIFEArmadoEncuesta.this.JTDetallePxEMouseClicked(evt);
            }
        });
        this.jScrollPane1.setViewportView(this.JTDetallePxE);
        this.JBActualizar.setFont(new Font("Arial", 1, 12));
        this.JBActualizar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBActualizar.setText("Actualizar");
        this.JBActualizar.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFEArmadoEncuesta.10
            public void actionPerformed(ActionEvent evt) {
                JIFEArmadoEncuesta.this.JBActualizarActionPerformed(evt);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane1, -1, 1013, 32767).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JBActualizar, -2, 426, -2).addGap(0, 0, 32767))).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane1, -2, 338, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBActualizar, -1, 40, 32767).addContainerGap()));
        this.JTPDetalle.addTab("PREGUNTAS X ENCUESTA", this.jPanel1);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JTPDetalle, GroupLayout.Alignment.LEADING).addComponent(this.JPIDatos, GroupLayout.Alignment.LEADING, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTPDetalle).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosing(InternalFrameEvent evt) {
        Principal.mLimpiarDatosP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTGrabarActionPerformed(ActionEvent evt) {
        if (Principal.txtNo.getText().isEmpty()) {
            if (this.JCBEncuesta.getSelectedIndex() != -1) {
                if (this.JCBProceso.getSelectedIndex() != -1) {
                    if (this.xmetodos.mVerificarDatosTablaTrue(this.JTDetalleUsuario, 3)) {
                        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                        if (n == 0) {
                            mGrabarEncabezadoD();
                            for (int x = 0; x < this.JTDetalleUsuario.getRowCount(); x++) {
                                if (Boolean.valueOf(this.xmodelo1.getValueAt(x, 3).toString()).booleanValue()) {
                                    String sql = "insert ignore into  t_e_tipo_encuesta_detalle(Id_Tipo_Encuesta, Id_UsuarioG, Fecha, UsuarioS)  values('" + Principal.txtNo.getText() + "','" + this.xmodelo1.getValueAt(x, 0) + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                                    this.xconsulta.ejecutarSQL(sql);
                                    this.xconsulta.cerrarConexionBd();
                                    if (!this.xmodelo1.getValueAt(x, 2).toString().equals("")) {
                                        this.xmetodos.mEnvioCorreoElectronico("Se le ha asignado la encuesta de : " + this.JCBEncuesta.getSelectedItem() + "\n\n Favor entrar a Genoma Plus y diligenciarla. \n\n\n" + Principal.usuarioSistemaDTO.getNombreUsuario(), this.xmodelo1.getValueAt(x, 2).toString(), "NOTIFICACIÓN DE ENCUESTA ASIGNADA", Principal.usuarioSistemaDTO.getLogin());
                                    }
                                }
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un proceso", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JCBProceso.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una encuesta", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBEncuesta.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Registro ya grabado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTGrabarPActionPerformed(ActionEvent evt) {
        if (Principal.txtNo.getText().isEmpty()) {
            if (this.JCBEncuesta.getSelectedIndex() != -1) {
                if (this.JCBProceso.getSelectedIndex() != -1) {
                    if (this.xmetodos.mVerificarDatosTablaTrue(this.JTDetalleProceso, 3)) {
                        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                        if (n == 0) {
                            mGrabarEncabezadoD();
                            for (int x = 0; x < this.JTDetalleProceso.getRowCount(); x++) {
                                if (Boolean.valueOf(this.xmodelo2.getValueAt(x, 3).toString()).booleanValue()) {
                                    String sql = "insert ignore into  t_e_tipo_encuesta_detalle(Id_Tipo_Encuesta, Id_TipoProceso, Fecha, UsuarioS)  values('" + Principal.txtNo.getText() + "','" + this.xmodelo2.getValueAt(x, 0) + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                                    this.xconsulta.ejecutarSQL(sql);
                                    this.xconsulta.cerrarConexionBd();
                                }
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un proceso", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JCBProceso.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una encuesta", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBEncuesta.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Registro ya grabado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBClienteIActionPerformed(ActionEvent evt) {
        if (this.JRBClienteI.isSelected()) {
            this.JTPDatosA.setEnabledAt(0, true);
            this.JTPDatosA.setEnabledAt(1, false);
            this.JTPDatosA.setSelectedIndex(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBProcesoActionPerformed(ActionEvent evt) {
        if (this.JRBProceso.isSelected()) {
            this.JTPDatosA.setEnabledAt(0, false);
            this.JTPDatosA.setEnabledAt(1, true);
            this.JTPDatosA.setSelectedIndex(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEspecialActionPerformed(ActionEvent evt) {
        if (this.JCHEspecial.isSelected()) {
            this.xespecial = 1;
        } else {
            this.xespecial = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBTProcesoItemStateChanged(ItemEvent evt) {
        if (this.xlleno && this.JCBTProceso.getSelectedIndex() != -1) {
            ConsultasMySQL xct1 = new ConsultasMySQL();
            this.JCBProceso.removeAllItems();
            this.xidproceso = xct1.llenarComboyLista("SELECT Id, Nbre, correo FROM s_sgc_tipoproceso WHERE (Id_Proceso ='" + this.xidtipop[this.JCBTProceso.getSelectedIndex()] + "' AND Estado =1) ORDER BY Nbre ASC", this.xidproceso, this.JCBProceso, 3);
            this.JCBProceso.setSelectedIndex(-1);
            xct1.cerrarConexionBd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBEncuestaItemStateChanged(ItemEvent evt) {
        if (this.xlleno && this.JCBEncuesta.getSelectedIndex() > -1 && this.JTPDetalle.getSelectedIndex() == 2) {
            mCargarDatosPxE(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBActualizarActionPerformed(ActionEvent evt) {
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            for (int i = 0; i < this.JTDetallePxE.getRowCount(); i++) {
                String sql = "UPDATE  `t_tipoencuestaxpregunta`\nSET   `Orden` = '" + this.xmodelo_p_x_e.getValueAt(i, 3) + "',\n  `Estado` = '" + this.xmodelo_p_x_e.getValueAt(i, 6) + "'\nWHERE `Id_Tipo_Encuesta` = '" + this.xmodelo_p_x_e.getValueAt(i, 0) + "'\n    AND `Id_Pregunta` = '" + this.xmodelo_p_x_e.getValueAt(i, 2) + "';";
                this.xconsulta.ejecutarSQL(sql);
                this.xconsulta.cerrarConexionBd();
            }
            mCargarDatosPxE(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetallePxEMouseClicked(MouseEvent evt) {
        if (this.JTDetallePxE.getSelectedRow() > -1 && this.JTDetallePxE.getSelectedColumn() == 5) {
            if (Boolean.valueOf(this.xmodelo_p_x_e.getValueAt(this.JTDetallePxE.getSelectedRow(), 5).toString()).booleanValue()) {
                this.xmodelo_p_x_e.setValueAt(1, this.JTDetallePxE.getSelectedRow(), 6);
            } else {
                this.xmodelo_p_x_e.setValueAt(0, this.JTDetallePxE.getSelectedRow(), 6);
            }
        }
    }

    public void mNuevo() {
        Principal.mLimpiarDatosP();
        this.JCBEncuesta.removeAllItems();
        this.xidencuesta = this.xconsulta.llenarCombo("SELECT Id, Nbre FROM t_encuestas WHERE (Estado =1) ORDER BY Nbre ASC", this.xidencuesta, this.JCBEncuesta);
        this.JCBEncuesta.setSelectedIndex(-1);
        mCargarDatosTabla();
        if (this.xnombre.equals("Pregunta x Encuesta")) {
            this.JTPDetalle.setEnabledAt(1, false);
            this.xlleno = true;
        } else if (this.xnombre.equals("Asignación x Encuesta")) {
            this.JCBProceso.removeAllItems();
            this.JTFNombre.setText("");
            this.JCBTProceso.removeAllItems();
            this.xidtipop = this.xconsulta.llenarCombo("SELECT Id , Nbre FROM s_sgc_procesos WHERE (Estado =1) ORDER BY Nbre ASC", this.xidtipop, this.JCBTProceso);
            this.JCBTProceso.setSelectedIndex(-1);
            this.xlleno = true;
            this.JDFechaCierre.setDate(this.xmetodos.getFechaActual());
            this.xconsulta.cerrarConexionBd();
            this.JTPDetalle.setEnabledAt(0, false);
            this.JTPDetalle.setEnabledAt(1, true);
            this.JTPDatosA.setEnabledAt(0, true);
            this.JTPDatosA.setEnabledAt(1, false);
            this.JRBClienteI.setSelected(true);
            this.JTPDetalle.setSelectedIndex(1);
            this.JTPDatosA.setSelectedIndex(0);
            mCargarDatosTablaU();
            mCargarDatosTablaP();
        }
        this.xconsulta.cerrarConexionBd();
        this.xestado = 0;
    }

    public void mGrabar() {
        if (this.JCBEncuesta.getSelectedIndex() != -1) {
            if (this.xmetodos.mVerificarDatosTablaTrue(this.JTDetalle, 3)) {
                int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (n == 0) {
                    for (int x = 0; x < this.JTDetalle.getRowCount(); x++) {
                        if (Boolean.valueOf(this.xmodelo.getValueAt(x, 3).toString()).booleanValue()) {
                            String sql = "insert ignore into  t_tipoencuestaxpregunta(Id_Tipo_Encuesta, Id_Pregunta, Orden, Fecha, UsuarioS)  values('" + this.xidencuesta[this.JCBEncuesta.getSelectedIndex()] + "','" + this.xmodelo.getValueAt(x, 0) + "','" + this.xmodelo.getValueAt(x, 2) + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                            this.xconsulta.ejecutarSQL(sql);
                            this.xconsulta.cerrarConexionBd();
                            mCargarDatosPxE(0);
                        }
                    }
                    return;
                }
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar las preguntas", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una encuesta", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JCBEncuesta.requestFocus();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Pregunta", "Orden", "Asignar?"}) { // from class: ParametrizacionN.JIFEArmadoEncuesta.11
            Class[] types = {Long.class, String.class, Integer.class, Boolean.class};
            boolean[] canEdit = {false, false, true, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(570);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(10);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatosU() {
        this.xmodelo1 = new DefaultTableModel(new Object[0], new String[]{"Id", "Usuario", "Email", "Asignar?"}) { // from class: ParametrizacionN.JIFEArmadoEncuesta.12
            Class[] types = {Long.class, String.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, true, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalleUsuario.setModel(this.xmodelo1);
        this.JTDetalleUsuario.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTDetalleUsuario.getColumnModel().getColumn(1).setPreferredWidth(500);
        this.JTDetalleUsuario.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTDetalleUsuario.getColumnModel().getColumn(3).setPreferredWidth(10);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatosP() {
        this.xmodelo2 = new DefaultTableModel(new Object[0], new String[]{"Id", "Tipo", "Proceso", "Asignar?"}) { // from class: ParametrizacionN.JIFEArmadoEncuesta.13
            Class[] types = {Long.class, String.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, true, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalleProceso.setModel(this.xmodelo2);
        this.JTDetalleProceso.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTDetalleProceso.getColumnModel().getColumn(1).setPreferredWidth(150);
        this.JTDetalleProceso.getColumnModel().getColumn(2).setPreferredWidth(500);
        this.JTDetalleProceso.getColumnModel().getColumn(3).setPreferredWidth(10);
    }

    private void mCargarDatosTabla() {
        try {
            mCrearModeloDatos();
            ResultSet xrs = this.xconsulta.traerRs("SELECT t_epregunta.Id, t_epregunta.Nbre    FROM  t_epregunta INNER JOIN t_etipo_r  ON (t_epregunta.Id_tipor = t_etipo_r.Id) ORDER BY t_epregunta.Nbre ASC");
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(1)), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt("", n, 2);
                    this.xmodelo.setValueAt(false, n, 3);
                    n++;
                }
            }
            xrs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFEArmadoEncuesta.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarDatosTablaU() {
        try {
            mCrearModeloDatosU();
            ResultSet xrs = this.xconsulta.traerRs("SELECT  g_usuario_sist.Id_Persona, persona.NUsuario, persona.Corre FROM persona INNER JOIN g_usuario_sist  ON (persona.Id_persona = g_usuario_sist.Id_Persona) WHERE (g_usuario_sist.Estado =0) ORDER BY persona.NUsuario ASC ");
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo1.addRow(this.xdatos);
                    this.xmodelo1.setValueAt(Long.valueOf(xrs.getLong(1)), n, 0);
                    this.xmodelo1.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo1.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelo1.setValueAt(false, n, 3);
                    n++;
                }
            }
            xrs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFEArmadoEncuesta.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarDatosTablaP() {
        try {
            mCrearModeloDatosP();
            ResultSet xrs = this.xconsulta.traerRs("SELECT s_sgc_tipoproceso.Id, s_sgc_procesos.Nbre, s_sgc_tipoproceso.Nbre FROM s_sgc_tipoproceso INNER JOIN s_sgc_procesos  ON (s_sgc_tipoproceso.Id_Proceso = s_sgc_procesos.Id) WHERE (s_sgc_tipoproceso.Estado =1) ORDER BY s_sgc_procesos.Id ASC, s_sgc_tipoproceso.Nbre ASC ");
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo2.addRow(this.xdatos);
                    this.xmodelo2.setValueAt(Long.valueOf(xrs.getLong(1)), n, 0);
                    this.xmodelo2.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo2.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelo2.setValueAt(false, n, 3);
                    n++;
                }
            }
            xrs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFEArmadoEncuesta.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mGrabarEncabezadoD() {
        String sql = "insert ignore into  t_e_tipo_encuesta(Id_TipoEncuesta, Nbre, FechaCierre, Especial, Id_TipoProceso, Fecha, UsuarioS)  values('" + this.xidencuesta[this.JCBEncuesta.getSelectedIndex()] + "','" + this.JTFNombre.getText() + "','" + this.xmetodos.formatoAMD.format(this.JDFechaCierre.getDate()) + "','" + this.xespecial + "','" + this.xidproceso[this.JCBProceso.getSelectedIndex()][0] + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
        Principal.txtNo.setText(this.xconsulta.ejecutarSQLId(sql));
        this.xconsulta.cerrarConexionBd();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatosExP() {
        this.xmodelo_p_x_e = new DefaultTableModel(new Object[0], new String[]{"IdEncuesta", "Encuesta", "IdPregunta", "Orden", "Pregunta", "Estado", "EstadoNum"}) { // from class: ParametrizacionN.JIFEArmadoEncuesta.14
            Class[] types = {Integer.class, String.class, Integer.class, Integer.class, String.class, Boolean.class, Integer.class};
            boolean[] canEdit = {false, false, false, true, false, true, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetallePxE.setModel(this.xmodelo_p_x_e);
        this.JTDetallePxE.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTDetallePxE.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTDetallePxE.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTDetallePxE.getColumnModel().getColumn(1).setPreferredWidth(280);
        this.JTDetallePxE.getColumnModel().getColumn(2).setPreferredWidth(0);
        this.JTDetallePxE.getColumnModel().getColumn(2).setMinWidth(0);
        this.JTDetallePxE.getColumnModel().getColumn(2).setMaxWidth(0);
        this.JTDetallePxE.getColumnModel().getColumn(3).setPreferredWidth(10);
        this.JTDetallePxE.getColumnModel().getColumn(4).setPreferredWidth(300);
        this.JTDetallePxE.getColumnModel().getColumn(5).setPreferredWidth(10);
        this.JTDetallePxE.getColumnModel().getColumn(6).setPreferredWidth(10);
    }

    private void mCargarDatosPxE(int xTipo) {
        String sql;
        try {
            mCrearModeloDatosExP();
            if (xTipo == 0) {
                sql = " SELECT\n    `t_tipoencuestaxpregunta`.`Id_Tipo_Encuesta`\n    , `t_encuestas`.`Nbre` AS Encuesta\n    , `t_tipoencuestaxpregunta`.`Id_Pregunta`\n    , `t_tipoencuestaxpregunta`.`Orden`\n    , `t_epregunta`.`Nbre` AS Pregunta\n    , `t_tipoencuestaxpregunta`.`Estado`\n    , `t_tipoencuestaxpregunta`.`Estado` FROM  `t_tipoencuestaxpregunta`  INNER JOIN `t_encuestas`  ON (`t_tipoencuestaxpregunta`.`Id_Tipo_Encuesta` = `t_encuestas`.`Id`)\n    INNER JOIN `t_epregunta`  ON (`t_tipoencuestaxpregunta`.`Id_Pregunta` = `t_epregunta`.`Id`)\n ORDER BY `t_tipoencuestaxpregunta`.`Id_Tipo_Encuesta` ASC, `t_tipoencuestaxpregunta`.`Orden` ASC;";
            } else {
                sql = "SELECT\n    `t_tipoencuestaxpregunta`.`Id_Tipo_Encuesta`\n    , `t_encuestas`.`Nbre` AS Encuesta\n    , `t_tipoencuestaxpregunta`.`Id_Pregunta`\n    , `t_tipoencuestaxpregunta`.`Orden`\n    , `t_epregunta`.`Nbre` AS Pregunta\n    , `t_tipoencuestaxpregunta`.`Estado`\n    , `t_tipoencuestaxpregunta`.`Estado`FROM  `t_tipoencuestaxpregunta`  INNER JOIN `t_encuestas`  ON (`t_tipoencuestaxpregunta`.`Id_Tipo_Encuesta` = `t_encuestas`.`Id`)\n    INNER JOIN `t_epregunta`  ON (`t_tipoencuestaxpregunta`.`Id_Pregunta` = `t_epregunta`.`Id`)\n WHERE (`t_tipoencuestaxpregunta`.`Id_Tipo_Encuesta`='" + this.xidencuesta[this.JCBEncuesta.getSelectedIndex()] + "') ORDER BY `t_tipoencuestaxpregunta`.`Id_Tipo_Encuesta` ASC, `t_tipoencuestaxpregunta`.`Orden` ASC;";
            }
            ResultSet xrs = this.xconsulta.traerRs(sql);
            this.xmetodos.mEstablecerTextEditor(this.JTDetallePxE, 4);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo_p_x_e.addRow(this.xdatos);
                    this.xmodelo_p_x_e.setValueAt(Integer.valueOf(xrs.getInt(1)), n, 0);
                    this.xmodelo_p_x_e.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo_p_x_e.setValueAt(Integer.valueOf(xrs.getInt(3)), n, 2);
                    this.xmodelo_p_x_e.setValueAt(Integer.valueOf(xrs.getInt(4)), n, 3);
                    this.xmodelo_p_x_e.setValueAt(xrs.getString(5), n, 4);
                    this.xmodelo_p_x_e.setValueAt(Boolean.valueOf(xrs.getBoolean(6)), n, 5);
                    this.xmodelo_p_x_e.setValueAt(Integer.valueOf(xrs.getInt(7)), n, 6);
                    n++;
                }
            }
            xrs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFEArmadoEncuesta.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }
}
