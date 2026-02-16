package Laboratorio;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.genoma.plus.jpa.entities.LRechazo;
import com.genoma.plus.jpa.entities.LRechazoDetalle;
import com.genoma.plus.jpa.service.ILRechazoDetalleService;
import com.genoma.plus.jpa.service.ILRechazoService;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyVetoException;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Laboratorio/JIFRegistroRechazoMuestra.class */
public class JIFRegistroRechazoMuestra extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private String xnombre;
    private String xid;
    private Object[] xdatos;
    private String[] xtipo;
    private LRechazo lRechazo;
    private final ILRechazoService iLRechazoService;
    private List<LRechazo> listaRechazo;
    private List<LRechazo> listaRechazo2;
    private LRechazoDetalle lRechazoDetalle;
    private final ILRechazoDetalleService iLRechazoDetalleService;
    private List<LRechazoDetalle> listaRechazoDetalles;
    private long idRechazo;
    private int idUsuario;
    private int idIngreso;
    private int idRecepcion;
    private int resultado;
    private int resultadoDetalle;
    private int idProcedimiento;
    private int cantidad;
    private int tipoRechazo;
    private int rechazo;
    private String observacion;
    private String nombreRechazo;
    private JButton JBTExportar;
    private JComboBox JCBTipoR;
    private JDateChooser JDFechaF;
    private JDateChooser JDFechaI;
    private JDateChooser JDFechaR;
    private JPanel JPIDatos;
    private JPanel JPIDatosIR;
    private JScrollPane JSPDetalle;
    private JScrollPane JSPObservacion;
    private JTable JTDetalle;
    private JTextField JTFRuta;
    private JTextPane JTPObservacion;
    private ConsultasMySQL xconsulta = new ConsultasMySQL();
    private Metodos xmt = new Metodos();
    String[] xencabezado = null;

    public JIFRegistroRechazoMuestra(String xnombre, String xtitulo) {
        initComponents();
        setTitle(xtitulo.toUpperCase());
        setName(xnombre);
        this.xnombre = xnombre;
        mIniciarComponentes();
        this.lRechazo = new LRechazo();
        this.iLRechazoService = (ILRechazoService) Principal.contexto.getBean(ILRechazoService.class);
        this.listaRechazo = new ArrayList();
        this.lRechazoDetalle = new LRechazoDetalle();
        this.iLRechazoDetalleService = (ILRechazoDetalleService) Principal.contexto.getBean(ILRechazoDetalleService.class);
        this.listaRechazoDetalles = new ArrayList();
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v24, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPIDatos = new JPanel();
        this.JDFechaI = new JDateChooser();
        this.JDFechaF = new JDateChooser();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JPIDatosIR = new JPanel();
        this.JCBTipoR = new JComboBox();
        this.JSPObservacion = new JScrollPane();
        this.JTPObservacion = new JTextPane();
        this.JDFechaR = new JDateChooser();
        this.JTFRuta = new JTextField();
        this.JBTExportar = new JButton();
        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        setTitle("REGISTRO DE RECHAZO DE MUESTRAS");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setMaximumSize(new Dimension(966, 640));
        setMinimumSize(new Dimension(966, 640));
        setName("jifregistrorechazo");
        try {
            setSelected(true);
        } catch (PropertyVetoException e1) {
            e1.printStackTrace();
        }
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS CONSULTA", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JDFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicial", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFechaI.setFont(new Font("Arial", 1, 12));
        this.JDFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Final", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFechaF.setFont(new Font("Arial", 1, 12));
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addComponent(this.JDFechaI, -2, 120, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JDFechaF, -2, 120, -2).addContainerGap(46, 32767)));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JDFechaF, -1, 52, 32767).addComponent(this.JDFechaI, -1, -1, 32767)).addContainerGap(-1, 32767)));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: Laboratorio.JIFRegistroRechazoMuestra.1
            public void mouseClicked(MouseEvent evt) {
                JIFRegistroRechazoMuestra.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.JPIDatosIR.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN A REGISTRAR", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JCBTipoR.setFont(new Font("Arial", 1, 12));
        this.JCBTipoR.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPObservacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 13), Color.blue));
        this.JSPObservacion.setFont(new Font("Arial", 1, 12));
        this.JSPObservacion.setViewportView(this.JTPObservacion);
        this.JDFechaR.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaR.setDateFormatString("dd/MM/yyyy");
        this.JDFechaR.setFont(new Font("Arial", 1, 12));
        GroupLayout JPIDatosIRLayout = new GroupLayout(this.JPIDatosIR);
        this.JPIDatosIR.setLayout(JPIDatosIRLayout);
        JPIDatosIRLayout.setHorizontalGroup(JPIDatosIRLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosIRLayout.createSequentialGroup().addGap(5, 5, 5).addGroup(JPIDatosIRLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JDFechaR, -2, 134, -2).addComponent(this.JCBTipoR, -2, 218, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPObservacion).addContainerGap()));
        JPIDatosIRLayout.setVerticalGroup(JPIDatosIRLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosIRLayout.createSequentialGroup().addGroup(JPIDatosIRLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPIDatosIRLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPObservacion)).addGroup(JPIDatosIRLayout.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.JDFechaR, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBTipoR, -2, -1, -2))).addGap(5, 5, 5)));
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: Laboratorio.JIFRegistroRechazoMuestra.2
            public void mouseClicked(MouseEvent evt) {
                JIFRegistroRechazoMuestra.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setForeground(Color.red);
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: Laboratorio.JIFRegistroRechazoMuestra.3
            public void actionPerformed(ActionEvent evt) {
                JIFRegistroRechazoMuestra.this.JBTExportarActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.JTFRuta, -1, 749, 32767).addGap(10, 10, 10).addComponent(this.JBTExportar, -2, 171, -2)).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPDetalle).addGroup(layout.createSequentialGroup().addComponent(this.JPIDatos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JPIDatosIR, -1, -1, 32767))).addContainerGap()))));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JPIDatos, -1, -1, 32767).addComponent(this.JPIDatosIR, -1, -1, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPDetalle, -1, 401, 32767).addGap(18, 18, 18).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JBTExportar, -2, 50, -2).addComponent(this.JTFRuta, -2, 50, -2)).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            Principal.txtNo.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
            if (this.xnombre.equals("Registro de Rechazo de Muestra")) {
                this.JCBTipoR.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3));
                this.JTPObservacion.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 5).toString());
                this.idUsuario = Integer.parseInt(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 7).toString());
                this.idIngreso = Integer.parseInt(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 8).toString());
                this.idRecepcion = Integer.parseInt(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
                this.idProcedimiento = Integer.parseInt(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 4).toString());
                this.cantidad = Integer.parseInt(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 9).toString());
                this.nombreRechazo = this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString();
                this.rechazo = Integer.parseInt(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 10).toString());
                System.out.println("idUsuario -> " + this.idUsuario + "\n -idIngreso -> " + this.idIngreso + "\n - idRecepcion -> " + this.idRecepcion + "\n - idProcedimiento -> " + this.idProcedimiento + "\n - rechazo -> " + this.rechazo);
            }
        }
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
        if (!this.JTFRuta.getText().isEmpty()) {
            if (this.JTDetalle.getRowCount() > -1) {
                int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de Exportar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (x == 0) {
                    this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTDetalle, this.JTFRuta.getText(), getTitle());
                    return;
                }
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "No existe información para exportar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un ruta valida", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JTFRuta.requestFocus();
    }

    public void mBuscar() {
        String sql = "";
        if (this.xnombre.equals("Registro de Rechazo de Muestra")) {
            sql = "SELECT \n  l_recepcion.Id AS idRecepcion,\n  persona.NUsuario,\n  g_procedimiento.Nbre,\n  l_tipo_rechazo.Nbre,\n  g_procedimiento.Id,\n  IF(l_detallerecepcion.ObservacionAcepta IS NULL, '', l_detallerecepcion.ObservacionAcepta) AS Observacion,\n  IFNULL(l_detallerecepcion.FechaRM, '') AS FechaRM ,\n   persona.Id_persona AS IdUsuario ,\n  ingreso.Id AS ingreso ,\n  l_detallerecepcion.cantidad AS cantidad, \n  l_tipo_rechazo.`Id` AS rechazo\nFROM\n  l_detallerecepcion\n  INNER JOIN l_recepcion ON (l_detallerecepcion.Id_Recepcion = l_recepcion.Id)\n  INNER JOIN l_tipo_rechazo ON (l_detallerecepcion.Id_Tipo = l_tipo_rechazo.Id)\n  INNER JOIN persona ON (persona.Id_persona = l_recepcion.Id_Paciente)\n  INNER JOIN g_procedimiento ON (l_detallerecepcion.Id_Procedim = g_procedimiento.Id)\n  INNER JOIN ingreso ON (ingreso.Id=l_detallerecepcion.Id_Recepcion)\n  -- INNER JOIN l_rechazo_detalle ON (l_rechazo_detalle.Id_TipoRechazo=l_tipo_rechazo.Id)\n  -- INNER JOIN l_rechazo ON (l_rechazo.Id=l_rechazo_detalle.Id_Rechazo) \nWHERE (\n    DATE_FORMAT(FechaRecep, '%Y/%m/%d') >= '" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "'\n    AND DATE_FORMAT(FechaRecep, '%Y/%m/%d') <= '" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "'\n    AND l_recepcion.Estado = 0\n  )\n-- GROUP BY `l_recepcion`.`Id` \nORDER BY l_recepcion.FechaRecep ASC,\n  persona.NUsuario ASC";
        }
        if (this.xnombre.equals("Demanda no Atendida")) {
            sql = "SELECT`l_rechazo`.`Id`, `l_rechazo`.`FechaR`, CONCAT(`g_persona`.`Id_TipoIdentificacion` ,'-', `g_persona`.`NoDocumento`) AS `Documento`, CONCAT(`g_persona`.`Apellido1`,' ', `g_persona`.`Apellido2` ,' ', `g_persona`.`Nombre1` ,' ', `g_persona`.`Nombre2`) AS `Usuario`, `g_procedimiento`.`Id`, `g_procedimiento`.`Nbre` AS `NProcedimiento`, `l_tipo_rechazo`.`Nbre` AS `NConcepto`, `l_rechazo_detalle`.`Observacion`FROM `l_rechazo_detalle` INNER JOIN  `l_rechazo` ON (`l_rechazo_detalle`.`Id_Rechazo` = `l_rechazo`.`Id`)INNER JOIN  `l_tipo_rechazo` ON (`l_rechazo_detalle`.`Id_TipoRechazo` = `l_tipo_rechazo`.`Id`)INNER JOIN  `g_persona` ON (`g_persona`.`Id` = `l_rechazo`.`Id_Usuario`)INNER JOIN  `g_procedimiento` ON (`l_rechazo_detalle`.`Id_Procedimiento` = `g_procedimiento`.`Id`)WHERE (`l_rechazo`.`Estado` =1 AND `l_rechazo`.`FechaR` >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "'AND `l_rechazo`.`FechaR` <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "') ORDER BY `l_rechazo`.`FechaR` ASC, `Usuario` ASC, `NProcedimiento` DESC;";
        }
        System.out.println(sql);
        mCargarDatosTabla(sql);
    }

    public void mNuevo() {
        Principal.mLimpiarDatosP();
        this.JDFechaI.setDate(this.xmt.getFechaActual());
        this.JDFechaF.setDate(this.xmt.getFechaActual());
        this.JDFechaR.setDate(this.xmt.getFechaActual());
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
        this.JCBTipoR.setSelectedIndex(-1);
        this.JTPObservacion.setText("");
        this.JDFechaI.requestFocus();
    }

    public void mGrabar() {
        if (!Principal.txtNo.getText().isEmpty()) {
            if (this.JCBTipoR.getSelectedIndex() != -1) {
                System.out.println("observacion >" + this.observacion + "< nombreRechazo >" + this.nombreRechazo + "<");
                if (this.rechazo == 1) {
                    int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    this.observacion = this.JTPObservacion.getText();
                    this.nombreRechazo = this.JCBTipoR.getSelectedItem().toString();
                    System.out.println("observacion >" + this.observacion + "< nombreRechazo >" + this.nombreRechazo + "<");
                    String xxsql = "SELECT Id FROM `l_tipo_rechazo` WHERE `Nbre` = '" + this.nombreRechazo + "'";
                    System.out.println("res -> " + xxsql);
                    ResultSet xrs1 = this.xconsulta.traerRs(xxsql);
                    try {
                        if (xrs1.next()) {
                            this.tipoRechazo = xrs1.getInt(1);
                        }
                        xrs1.close();
                        this.xconsulta.cerrarConexionBd();
                    } catch (Exception e) {
                        System.out.println(">>>error<<<");
                    }
                    this.listaRechazo = this.iLRechazoService.listar(this.listaRechazo);
                    this.listaRechazo.forEach(e2 -> {
                        this.idRechazo = e2.getId().longValue();
                        System.out.println("Id -> " + this.idRechazo);
                    });
                    System.out.println("idUsuario -> " + this.idUsuario + " -idIngreso -> " + this.idIngreso + " - idRecepcion -> " + this.idRecepcion + " -fechaR -> " + this.xmt.formatoAMD.format(this.JDFechaR.getDate()) + " -usuario sistema -> " + Principal.usuarioSistemaDTO.getLogin() + "idUsuarioSistema ->" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "<");
                    String xsql = "SELECT Id AS idPersonaCargoN FROM `rh_tipo_persona_cargon` WHERE `Id_persona` = " + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "";
                    ResultSet xrs = this.xconsulta.traerRs(xsql);
                    try {
                        if (xrs.next()) {
                            this.resultado = xrs.getInt(1);
                        }
                        xrs.close();
                        this.xconsulta.cerrarConexionBd();
                    } catch (Exception e3) {
                        System.out.println(">>>error<<<");
                    }
                    System.out.println("resultado -> " + this.resultado);
                    this.lRechazo = new LRechazo();
                    this.lRechazo.setIdIngreso(Long.valueOf(this.idIngreso));
                    this.lRechazo.setIdRecepcion(Long.valueOf(this.idRecepcion));
                    this.lRechazo.setIdUsuario(Long.valueOf(this.idUsuario));
                    this.lRechazo.setEstado(1);
                    this.lRechazo.setFechaR(this.xmt.formatoAMD.format(this.JDFechaR.getDate()));
                    this.lRechazo.setUsuarioS(Principal.usuarioSistemaDTO.getLogin());
                    this.lRechazo.setIdUsuarioS(Long.valueOf(this.resultado));
                    this.iLRechazoService.grabar(this.lRechazo);
                    System.out.println("graba l_rechazo");
                    mBuscar();
                    this.listaRechazo2 = this.iLRechazoService.listar(this.listaRechazo2);
                    this.listaRechazo2.forEach(e4 -> {
                        this.idRechazo = e4.getId().longValue();
                        System.out.println("Id --> " + this.idRechazo);
                    });
                    this.lRechazoDetalle = new LRechazoDetalle();
                    System.out.println("rechazo -> " + this.idRechazo);
                    this.lRechazoDetalle.setIdRechazo(Long.valueOf(this.idRechazo));
                    this.lRechazoDetalle.setIdProcedimiento(Long.valueOf(this.idProcedimiento));
                    this.lRechazoDetalle.setCantidad(Integer.valueOf(this.cantidad));
                    this.lRechazoDetalle.setIdTipoRechazo(Integer.valueOf(this.tipoRechazo));
                    this.lRechazoDetalle.setObservacion(this.observacion);
                    this.lRechazoDetalle.setEstado(1);
                    this.lRechazoDetalle.setUsuarioS(Principal.usuarioSistemaDTO.getLogin());
                    this.iLRechazoDetalleService.grabar(this.lRechazoDetalle);
                    System.out.println("graba detalle rechazo");
                    if (n == 0) {
                        System.out.println("" + this.xtipo[this.JCBTipoR.getSelectedIndex()]);
                        System.out.println("" + this.JTPObservacion.getText());
                        System.out.println("" + this.xmt.formatoAMD.format(this.JDFechaR.getDate()));
                        System.out.println("" + this.idProcedimiento);
                        String sql = "update  l_detallerecepcion set Id_Tipo='" + this.xtipo[this.JCBTipoR.getSelectedIndex()] + "', ObservacionAcepta='" + this.JTPObservacion.getText() + "', FechaRM='" + this.xmt.formatoAMD.format(this.JDFechaR.getDate()) + "' where Id_Recepcion='" + Principal.txtNo.getText() + "' and Id_Procedim='" + this.idProcedimiento + "'";
                        System.out.println(sql);
                        this.xconsulta.ejecutarSQL(sql);
                        this.xconsulta.cerrarConexionBd();
                        JOptionPane.showMessageDialog((Component) null, "Datos Guardados");
                        mBuscar();
                        return;
                    }
                    return;
                }
                JOptionPane.showMessageDialog((Component) null, "¡Muestra ya rechazada!");
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un tipo de rechazo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBTipoR.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un registro", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos(String[] xcabecera) {
        this.xmodelo = new DefaultTableModel(new Object[0], xcabecera) { // from class: Laboratorio.JIFRegistroRechazoMuestra.4
            Class[] types = {Long.class, String.class, String.class, String.class, Long.class, String.class, String.class, String.class, Integer.class, Integer.class, Integer.class, Integer.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        if (this.xnombre.equals("Demanda no Atendida")) {
            this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(20);
            this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(20);
            this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(50);
            this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(200);
            this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(0);
            this.JTDetalle.getColumnModel().getColumn(4).setMinWidth(0);
            this.JTDetalle.getColumnModel().getColumn(4).setMaxWidth(0);
            this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(200);
            this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(20);
            this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(0);
            this.JTDetalle.getColumnModel().getColumn(7).setMinWidth(0);
            this.JTDetalle.getColumnModel().getColumn(7).setMaxWidth(0);
            this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(0);
            this.JTDetalle.getColumnModel().getColumn(8).setMinWidth(0);
            this.JTDetalle.getColumnModel().getColumn(8).setMaxWidth(0);
            this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(0);
            this.JTDetalle.getColumnModel().getColumn(9).setMinWidth(0);
            this.JTDetalle.getColumnModel().getColumn(9).setMaxWidth(0);
            this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(80);
            return;
        }
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(400);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(4).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(4).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(7).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(7).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(8).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(8).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(9).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(9).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(10).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(10).setMaxWidth(0);
    }

    public void mCargarDatosTabla(String xsql) {
        try {
            mCrearModeloDatos(this.xencabezado);
            System.out.println("consulta -> " + xsql);
            ResultSet xrs = this.xconsulta.traerRs(xsql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(1)), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelo.setValueAt(xrs.getString(4), n, 3);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(5)), n, 4);
                    this.xmodelo.setValueAt(xrs.getString(6), n, 5);
                    this.xmodelo.setValueAt(xrs.getString(7), n, 6);
                    this.xmodelo.setValueAt(Integer.valueOf(xrs.getInt(8)), n, 7);
                    this.xmodelo.setValueAt(Integer.valueOf(xrs.getInt(9)), n, 8);
                    this.xmodelo.setValueAt(Integer.valueOf(xrs.getInt(10)), n, 9);
                    this.xmodelo.setValueAt(Integer.valueOf(xrs.getInt(11)), n, 10);
                    n++;
                }
            }
            xrs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFRegistroRechazoMuestra.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mImprimir() {
        Object[] botones = {"Planilla", "Ticket", "Cerrar"};
        int n = JOptionPane.showInternalOptionDialog(this, "Que desea visualizar", "VISUALIZAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), botones, "Cerrar");
        if (n == 0) {
            String[][] mparametros = new String[4][2];
            mparametros[0][0] = "fechaInicial";
            mparametros[0][1] = this.xmt.formatoAMD.format(this.JDFechaI.getDate());
            mparametros[1][0] = "fechaFinal";
            mparametros[1][1] = this.xmt.formatoAMD.format(this.JDFechaF.getDate());
            mparametros[2][0] = "SUBREPORT_DIR";
            mparametros[2][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
            mparametros[3][0] = "SUBREPORTFIRMA_DIR";
            mparametros[3][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
            if (this.xnombre.equals("Registro de Rechazo de Muestra")) {
                this.xmt.GenerarPDF(this.xmt.getRutaRep() + "R_RegistroRechazoMuestras", mparametros);
                return;
            }
            return;
        }
        if (n == 1 && this.JTDetalle.getSelectedRow() != -1) {
            this.xmt.mImprimir_Pendiente_Laboratorio(this.JTDetalle.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
        }
    }

    private void mIniciarComponentes() {
        if (this.xnombre.equals("Registro de Rechazo de Muestra")) {
            this.xencabezado = new String[]{"Id", "Usuario", "Exámen", "Tipo", "Idprocedimiento", "Observación", "Fecha", "IdUsuario", "ingreso", "cantidad", "Estado"};
            mCrearModeloDatos(this.xencabezado);
            this.JPIDatosIR.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN RECHAZO", 2, 2, new Font("Arial", 1, 14), new Color(0, 103, 0)));
            this.JCBTipoR.removeAllItems();
            this.xtipo = this.xconsulta.llenarCombo("SELECT Id, Nbre FROM l_tipo_rechazo WHERE (Estado =1) ORDER BY Nbre ASC", this.xtipo, this.JCBTipoR);
            this.JCBTipoR.setSelectedIndex(-1);
            this.xconsulta.cerrarConexionBd();
        } else {
            this.JCBTipoR.setVisible(false);
            this.JTPObservacion.setVisible(false);
            this.JSPObservacion.setVisible(false);
        }
        if (this.xnombre.equals("Demanda no Atendida")) {
            this.xencabezado = new String[]{"Id", "Fecha Rechazo", "Documento", "Usuario", "Idprocedimiento", "Procedimiento", "Concepto", "Observacion"};
        }
        mCrearModeloDatos(this.xencabezado);
    }
}
