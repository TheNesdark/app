package Historia;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Font;
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
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Historia/JPSo_EspirometriaSI.class */
public class JPSo_EspirometriaSI extends JPanel {
    private Object[] xdatos;
    private String xsql;
    private DefaultTableModel xmodelo;
    private File xfile;
    private String[] xidResultado;
    private JButton JBGrabaInterp;
    private JButton JBTActualizar;
    private JButton JBTGrabarR;
    private JComboBox JCBClasificacion;
    private JComboBox JCBResultado;
    private JPanel JPInterpretacion;
    private JSpinner JSPFEF2575;
    private JSpinner JSPFEV1FVC;
    private JSpinner JSPFV1;
    private JSpinner JSPFVC;
    private JScrollPane JSPHistorico;
    private JScrollPane JSPObservacion;
    private JSpinner JSPPEF;
    private JTextArea JTAObservacion;
    private JTextArea JTAObservacionEspiro;
    public JTable JTDetalleHistorico;
    private JTextField JTFRuta;
    private JPanel jPanel1;
    private JScrollPane jScrollPane2;
    private ConsultasMySQL xct = new ConsultasMySQL();
    private Metodos xmt = new Metodos();
    private String xid = "0";
    private String xidEspirometria = "0";

    public JPSo_EspirometriaSI() {
        initComponents();
        this.xidResultado = this.xct.llenarCombo("SELECT `Id`, `Nbre` FROM `h_so_resultado` WHERE (`Estado` =1 AND TipoExamen=1) ORDER BY `Nbre` ASC;", this.xidResultado, this.JCBResultado);
        this.JCBResultado.setSelectedIndex(-1);
        mCargarDatos();
        mCargarDatosTabla();
    }

    private void mCalcular() {
    }

    /* JADX WARN: Type inference failed for: r3v64, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jPanel1 = new JPanel();
        this.JSPFVC = new JSpinner();
        this.JSPFV1 = new JSpinner();
        this.JSPFEV1FVC = new JSpinner();
        this.JSPPEF = new JSpinner();
        this.JCBClasificacion = new JComboBox();
        this.JBTGrabarR = new JButton();
        this.jScrollPane2 = new JScrollPane();
        this.JTAObservacionEspiro = new JTextArea();
        this.JSPFEF2575 = new JSpinner();
        this.JTFRuta = new JTextField();
        this.JBTActualizar = new JButton();
        this.JSPHistorico = new JScrollPane();
        this.JTDetalleHistorico = new JTable();
        this.JPInterpretacion = new JPanel();
        this.JCBResultado = new JComboBox();
        this.JSPObservacion = new JScrollPane();
        this.JTAObservacion = new JTextArea();
        this.JBGrabaInterp = new JButton();
        setBorder(BorderFactory.createTitledBorder((Border) null, "ESPIROMETRIA", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        setName("xjifespirometria");
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "RESULTADO", 2, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.JSPFVC.setFont(new Font("Arial", 1, 12));
        this.JSPFVC.setModel(new SpinnerNumberModel(Double.valueOf(0.0d), Double.valueOf(0.0d), (Comparable) null, Double.valueOf(0.1d)));
        this.JSPFVC.setBorder(BorderFactory.createTitledBorder((Border) null, "FVC", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JSPFVC.addChangeListener(new ChangeListener() { // from class: Historia.JPSo_EspirometriaSI.1
            public void stateChanged(ChangeEvent evt) {
                JPSo_EspirometriaSI.this.JSPFVCStateChanged(evt);
            }
        });
        this.JSPFV1.setFont(new Font("Arial", 1, 12));
        this.JSPFV1.setModel(new SpinnerNumberModel(Double.valueOf(0.0d), Double.valueOf(0.0d), (Comparable) null, Double.valueOf(0.1d)));
        this.JSPFV1.setBorder(BorderFactory.createTitledBorder((Border) null, "FV1", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JSPFV1.addChangeListener(new ChangeListener() { // from class: Historia.JPSo_EspirometriaSI.2
            public void stateChanged(ChangeEvent evt) {
                JPSo_EspirometriaSI.this.JSPFV1StateChanged(evt);
            }
        });
        this.JSPFEV1FVC.setFont(new Font("Arial", 1, 12));
        this.JSPFEV1FVC.setModel(new SpinnerNumberModel(Double.valueOf(0.0d), Double.valueOf(0.0d), (Comparable) null, Double.valueOf(0.1d)));
        this.JSPFEV1FVC.setBorder(BorderFactory.createTitledBorder((Border) null, "FEV1/FVC", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JSPFEV1FVC.addChangeListener(new ChangeListener() { // from class: Historia.JPSo_EspirometriaSI.3
            public void stateChanged(ChangeEvent evt) {
                JPSo_EspirometriaSI.this.JSPFEV1FVCStateChanged(evt);
            }
        });
        this.JSPPEF.setFont(new Font("Arial", 1, 12));
        this.JSPPEF.setModel(new SpinnerNumberModel(Double.valueOf(0.0d), Double.valueOf(0.0d), (Comparable) null, Double.valueOf(0.1d)));
        this.JSPPEF.setBorder(BorderFactory.createTitledBorder((Border) null, "PEF", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JSPPEF.addChangeListener(new ChangeListener() { // from class: Historia.JPSo_EspirometriaSI.4
            public void stateChanged(ChangeEvent evt) {
                JPSo_EspirometriaSI.this.JSPPEFStateChanged(evt);
            }
        });
        this.JCBClasificacion.setFont(new Font("Arial", 1, 12));
        this.JCBClasificacion.setModel(new DefaultComboBoxModel(new String[]{"NORMAL", "MIXTO", "OBSTRUCTIVO", "RESTRICTIVO", "SIN RESULTADO"}));
        this.JCBClasificacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Clasificación", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JBTGrabarR.setFont(new Font("Arial", 1, 12));
        this.JBTGrabarR.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTGrabarR.setText("Grabar");
        this.JBTGrabarR.addActionListener(new ActionListener() { // from class: Historia.JPSo_EspirometriaSI.5
            public void actionPerformed(ActionEvent evt) {
                JPSo_EspirometriaSI.this.JBTGrabarRActionPerformed(evt);
            }
        });
        this.JTAObservacionEspiro.setColumns(1);
        this.JTAObservacionEspiro.setLineWrap(true);
        this.JTAObservacionEspiro.setRows(1);
        this.JTAObservacionEspiro.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.jScrollPane2.setViewportView(this.JTAObservacionEspiro);
        this.JSPFEF2575.setFont(new Font("Arial", 1, 12));
        this.JSPFEF2575.setModel(new SpinnerNumberModel(Double.valueOf(0.0d), Double.valueOf(0.0d), (Comparable) null, Double.valueOf(0.1d)));
        this.JSPFEF2575.setBorder(BorderFactory.createTitledBorder((Border) null, "FEF2575", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ruta de Archivo a Cargar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: Historia.JPSo_EspirometriaSI.6
            public void mouseClicked(MouseEvent evt) {
                JPSo_EspirometriaSI.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JTFRuta.addActionListener(new ActionListener() { // from class: Historia.JPSo_EspirometriaSI.7
            public void actionPerformed(ActionEvent evt) {
                JPSo_EspirometriaSI.this.JTFRutaActionPerformed(evt);
            }
        });
        this.JBTActualizar.setFont(new Font("Arial", 1, 12));
        this.JBTActualizar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTActualizar.setText("Actualizar");
        this.JBTActualizar.addActionListener(new ActionListener() { // from class: Historia.JPSo_EspirometriaSI.8
            public void actionPerformed(ActionEvent evt) {
                JPSo_EspirometriaSI.this.JBTActualizarActionPerformed(evt);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane2).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JSPFVC, -2, 120, -2).addGap(10, 10, 10).addComponent(this.JSPFV1, -2, 120, -2).addGap(10, 10, 10).addComponent(this.JSPFEV1FVC, -2, 120, -2).addGap(10, 10, 10).addComponent(this.JSPPEF, -2, 120, -2).addGap(10, 10, 10).addComponent(this.JSPFEF2575, -2, 120, -2)).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JTFRuta).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBClasificacion, -2, 176, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 49, 32767).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JBTGrabarR, GroupLayout.Alignment.TRAILING, -2, 129, -2).addComponent(this.JBTActualizar, GroupLayout.Alignment.TRAILING, -2, 129, -2)))).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.JBTGrabarR, -1, -1, 32767)).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JSPFVC, -2, 50, -2).addComponent(this.JSPFV1, -2, 50, -2).addComponent(this.JSPFEV1FVC, -2, 50, -2).addComponent(this.JSPPEF, -2, 50, -2).addComponent(this.JSPFEF2575, -2, 50, -2))).addGap(18, 18, 18).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBClasificacion).addComponent(this.JTFRuta, -2, 61, -2)).addGroup(jPanel1Layout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 12, -2).addComponent(this.JBTActualizar, -2, 49, -2))).addGap(32, 32, 32).addComponent(this.jScrollPane2, -2, 118, -2).addContainerGap()));
        this.JSPHistorico.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.JTDetalleHistorico.setFont(new Font("Arial", 1, 12));
        this.JTDetalleHistorico.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalleHistorico.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalleHistorico.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalleHistorico.setSelectionMode(0);
        this.JTDetalleHistorico.addMouseListener(new MouseAdapter() { // from class: Historia.JPSo_EspirometriaSI.9
            public void mouseClicked(MouseEvent evt) {
                JPSo_EspirometriaSI.this.JTDetalleHistoricoMouseClicked(evt);
            }
        });
        this.JSPHistorico.setViewportView(this.JTDetalleHistorico);
        this.JPInterpretacion.setBorder(BorderFactory.createTitledBorder((Border) null, "INTERPRETACIÓN MEDICA", 2, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.JCBResultado.setFont(new Font("Arial", 1, 12));
        this.JCBResultado.setBorder(BorderFactory.createTitledBorder((Border) null, "Resultado", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTAObservacion.setColumns(1);
        this.JTAObservacion.setFont(new Font("Arial", 1, 12));
        this.JTAObservacion.setLineWrap(true);
        this.JTAObservacion.setRows(1);
        this.JTAObservacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JSPObservacion.setViewportView(this.JTAObservacion);
        this.JBGrabaInterp.setFont(new Font("Arial", 1, 12));
        this.JBGrabaInterp.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBGrabaInterp.setText("Actualizar  Interpretación");
        this.JBGrabaInterp.addActionListener(new ActionListener() { // from class: Historia.JPSo_EspirometriaSI.10
            public void actionPerformed(ActionEvent evt) {
                JPSo_EspirometriaSI.this.JBGrabaInterpActionPerformed(evt);
            }
        });
        GroupLayout JPInterpretacionLayout = new GroupLayout(this.JPInterpretacion);
        this.JPInterpretacion.setLayout(JPInterpretacionLayout);
        JPInterpretacionLayout.setHorizontalGroup(JPInterpretacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPInterpretacionLayout.createSequentialGroup().addContainerGap().addComponent(this.JCBResultado, -2, 193, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPObservacion).addGap(18, 18, 18).addComponent(this.JBGrabaInterp).addContainerGap()));
        JPInterpretacionLayout.setVerticalGroup(JPInterpretacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPInterpretacionLayout.createSequentialGroup().addContainerGap().addGroup(JPInterpretacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPObservacion).addGroup(JPInterpretacionLayout.createSequentialGroup().addGroup(JPInterpretacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JBGrabaInterp, -1, 60, 32767).addGroup(JPInterpretacionLayout.createSequentialGroup().addComponent(this.JCBResultado, -2, -1, -2).addGap(0, 0, 32767))).addContainerGap()))));
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -1, -1, 32767).addComponent(this.JSPHistorico).addComponent(this.JPInterpretacion, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JSPHistorico, -2, 241, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPInterpretacion, -2, -1, -2).addGap(18, 18, 18)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JSPFVCStateChanged(ChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JSPFV1StateChanged(ChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JSPFEV1FVCStateChanged(ChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JSPPEFStateChanged(ChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleHistoricoMouseClicked(MouseEvent evt) {
        if (this.JTDetalleHistorico.getSelectedRow() != -1) {
            if (this.JTDetalleHistorico.getSelectedColumn() == 8) {
                if (!this.xmodelo.getValueAt(this.JTDetalleHistorico.getSelectedRow(), 8).equals("")) {
                    System.out.println(this.xmodelo.getValueAt(this.JTDetalleHistorico.getSelectedRow(), 8).toString());
                    this.xmt.mostrarPdf(this.xmodelo.getValueAt(this.JTDetalleHistorico.getSelectedRow(), 8).toString());
                    return;
                }
                return;
            }
            this.xidEspirometria = this.xmodelo.getValueAt(this.JTDetalleHistorico.getSelectedRow(), 0).toString();
            mImprimir();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTGrabarRActionPerformed(ActionEvent evt) {
        int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (x == 0) {
            this.xsql = "insert into h_so_espirometria_g (Id_Usuario, `Id_Atencion`, `Fecha_R`, `FVC` , `FV1`  , `FEV1_FVC` , `PEF`  , `FEF2575`, ObservacionEspiro, `Id_Profesional`, `Id_Especialidad`,Ruta, Resultado, `UsuarioS`) values('" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "','" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "','" + this.xmt.formatoAMD.format(this.xmt.getFechaActual()) + "','" + this.JSPFVC.getValue() + "','" + this.JSPFV1.getValue() + "','" + this.JSPFEV1FVC.getValue() + "','" + this.JSPPEF.getValue() + "','" + this.JSPFEF2575.getValue() + "','" + this.JTAObservacionEspiro.getText() + "','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "','" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "','" + this.JTFRuta.getText() + "','" + this.JCBClasificacion.getSelectedItem() + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
            this.xidEspirometria = this.xct.ejecutarSQLId(this.xsql);
            Principal.clasehistoriace.mCambiarEstadoOrdenProcedimiento();
            this.xct.cerrarConexionBd();
            this.JBTGrabarR.setEnabled(false);
            this.xid = clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion();
            mCargarDatosTabla();
            mImprimir();
            this.xmt.cambiarEstadoValidadoItemHC(getName(), 1, true);
        }
    }

    private void actualizarRegistro() {
        int x = JOptionPane.showInternalConfirmDialog(this, "¿Está seguro de actualizar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (x == 0) {
            String sql = "UPDATE h_so_espirometria_g SET FVC = '" + this.JSPFVC.getValue() + "', FV1 = '" + this.JSPFV1.getValue() + "', FEV1_FVC = '" + this.JSPFEV1FVC.getValue() + "', PEF = '" + this.JSPPEF.getValue() + "', FEF2575 = '" + this.JSPFEF2575.getValue() + "', ObservacionEspiro = '" + this.JTAObservacionEspiro.getText() + "', Resultado = '" + this.JCBClasificacion.getSelectedItem() + "',Fecha_R='" + this.xmt.formatoAMD.format(this.xmt.getFechaActual()) + "',Ruta='" + this.JTFRuta.getText() + "', Id_Especialidad='" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "' WHERE  Id_Atencion = '" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "'";
            System.out.println("actualizar espirometria ->" + sql);
            this.xct.ejecutarSQL(sql);
            this.xct.cerrarConexionBd();
            mCargarDatosTabla();
            mImprimir();
            this.xmt.cambiarEstadoValidadoItemHC(getName(), 1, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBGrabaInterpActionPerformed(ActionEvent evt) {
        this.xsql = "update h_so_espirometria_g set `ResultadoM`='" + this.JCBResultado.getSelectedItem() + "', `Observacion`='" + this.JTAObservacion.getText() + "' , `Id_Atencion`='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "' where Id='" + this.xidEspirometria + "'";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xmt.cambiarEstadoValidadoItemHC(getName(), 1, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JFileChooser xfilec = new JFileChooser("Y:\\SoporteEspirometria\\");
            int xv = xfilec.showOpenDialog(this);
            if (xv == 0) {
                this.xfile = xfilec.getSelectedFile();
                this.JTFRuta.setText(this.xfile.getAbsolutePath());
                this.JTFRuta.setText(this.xmt.mTraerUrlBD(this.xfile.getAbsolutePath()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTActualizarActionPerformed(ActionEvent evt) {
        actualizarRegistro();
    }

    private void mCargarDatos() {
        try {
            this.xsql = "SELECT `FVC` , `FV1`  , `FEV1_FVC` , `PEF`  , `FEF2575`,Ruta, `Resultado` , `ResultadoM` , `h_so_espirometria_g`.`Observacion`, `h_so_espirometria_g`.Id, `h_atencion`.`TipoGuardado`, ObservacionEspiro FROM `h_atencion` INNER JOIN `h_so_espirometria_g` ON (`h_atencion`.`Id` = `h_so_espirometria_g`.`Id_Atencion`) WHERE (`h_so_espirometria_g`.`Id_Atencion` ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "' AND `h_so_espirometria_g`.`Estado` =1) ";
            System.out.println("cargar datos" + this.xsql);
            ResultSet xrs = this.xct.traerRs(this.xsql);
            this.xidEspirometria = clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion();
            if (xrs.next()) {
                xrs.first();
                this.JSPFVC.setValue(Double.valueOf(xrs.getDouble(1)));
                this.JSPFV1.setValue(Double.valueOf(xrs.getDouble(2)));
                this.JSPFEV1FVC.setValue(Double.valueOf(xrs.getDouble(3)));
                this.JSPPEF.setValue(Double.valueOf(xrs.getDouble(4)));
                this.JSPFEF2575.setValue(Double.valueOf(xrs.getDouble(5)));
                this.JTFRuta.setText(xrs.getString(6));
                this.JCBClasificacion.setSelectedItem(xrs.getString(7));
                this.JCBResultado.setSelectedItem(xrs.getString(8));
                this.JTAObservacion.setText(xrs.getString(9));
                this.xidEspirometria = xrs.getString(10);
                this.JBTGrabarR.setEnabled(false);
                if (xrs.getInt(11) == 1 && !Principal.informacionIps.getNombreIps().equals("IPS SU SALUD INTEGRAL S.A.S")) {
                    this.JBGrabaInterp.setEnabled(false);
                }
                this.JTAObservacionEspiro.setText(xrs.getString(12));
                this.xmt.cambiarEstadoValidadoItemHC(getName(), 1, true);
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPSo_EspirometriaSI.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloHistorico() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "IdAtencion", "Fecha", "FVC", "FEV1", "FEV1/FVC", "PEF", "FEF2575", "Ruta", "Resultado"}) { // from class: Historia.JPSo_EspirometriaSI.11
            Class[] types = {String.class, Long.class, String.class, Double.class, Double.class, Double.class, Double.class, Double.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalleHistorico.setModel(this.xmodelo);
        this.JTDetalleHistorico.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTDetalleHistorico.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTDetalleHistorico.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTDetalleHistorico.getColumnModel().getColumn(1).setPreferredWidth(0);
        this.JTDetalleHistorico.getColumnModel().getColumn(1).setMinWidth(0);
        this.JTDetalleHistorico.getColumnModel().getColumn(1).setMaxWidth(0);
        this.JTDetalleHistorico.getColumnModel().getColumn(2).setPreferredWidth(10);
        this.JTDetalleHistorico.getColumnModel().getColumn(3).setPreferredWidth(15);
        this.JTDetalleHistorico.getColumnModel().getColumn(4).setPreferredWidth(15);
        this.JTDetalleHistorico.getColumnModel().getColumn(5).setPreferredWidth(15);
        this.JTDetalleHistorico.getColumnModel().getColumn(6).setPreferredWidth(15);
        this.JTDetalleHistorico.getColumnModel().getColumn(7).setPreferredWidth(15);
        this.JTDetalleHistorico.getColumnModel().getColumn(8).setPreferredWidth(15);
        this.JTDetalleHistorico.getColumnModel().getColumn(9).setPreferredWidth(20);
    }

    private void mCargarDatosTabla() {
        try {
            mCrearModeloHistorico();
            this.xsql = "SELECT `Id`, `Id_Atencion`, DATE_FORMAT(`Fecha_R`,'%d-%m-%Y') AS Fecha, `FVC`, `FV1`, `FEV1_FVC`, `PEF`, `FEF2575`, Ruta, `Resultado` FROM  `h_so_espirometria_g` WHERE (`Id_Usuario` ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "' and Estado=1 ) ORDER BY `Fecha_R` DESC ";
            System.out.println("cargar tabla -> " + this.xsql);
            ResultSet xrs = this.xct.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int x = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(xrs.getString(1), x, 0);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(2)), x, 1);
                    this.xmodelo.setValueAt(xrs.getString(3), x, 2);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(4)), x, 3);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(5)), x, 4);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(6)), x, 5);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(7)), x, 6);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(8)), x, 7);
                    this.xmodelo.setValueAt(xrs.getString(9), x, 8);
                    this.xmodelo.setValueAt(xrs.getString(10), x, 9);
                    x++;
                }
            } else {
                mCrearModeloHistorico();
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPSo_EspirometriaSI.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mImprimir() {
        String[][] mparametros = new String[3][2];
        mparametros[0][0] = "IdEspirometria";
        mparametros[0][1] = this.xidEspirometria;
        mparametros[1][0] = "SUBREPORT_DIR";
        mparametros[1][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
        mparametros[2][0] = "SUBREPORTFIRMA_DIR";
        mparametros[2][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
        this.xmt.GenerarPDF(this.xmt.getRutaRep() + "H_So_Espirometria2", mparametros);
    }
}
