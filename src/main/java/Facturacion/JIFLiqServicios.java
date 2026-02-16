package Facturacion;

import Acceso.Principal;
import Armado.JPGlosa;
import Cirugia.JIF_Programacion_Cx;
import Enfermeria.JPAplicaciontto;
import Enfermeria.JPEAyudasDx;
import Enfermeria.JPEscaneoDocumentosEnf;
import General.BuscarPersona;
import General.Persona;
import Historia.JPANotas;
import Historia.JPEgresoUrgencias;
import Historia.JPI_Control_Impresion;
import Historia.JPORemisiones;
import Historia.clasesHistoriaCE;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.genoma.plus.controller.enfermeria.JPHojaTratamiento;
import com.genoma.plus.controller.facturacion.JPAEventoECastPacienteGasto;
import com.genoma.plus.controller.facturacion.JPI_FormularioAnexo1;
import com.genoma.plus.controller.facturacion.JPI_FormularioAnexo1Res2335;
import com.genoma.plus.controller.facturacion.JPI_FormularioAnexo2;
import com.genoma.plus.controller.facturacion.JPI_FormularioAnexo2Res2335;
import com.genoma.plus.controller.facturacion.JPI_FormularioAnexo3;
import com.genoma.plus.controller.facturacion.JPI_FormularioAnexo3Res2335;
import com.genoma.plus.controller.facturacion.JPI_IngresoSalidaAdministrativa;
import com.genoma.plus.controller.facturacion.JPIngresoDocumento;
import com.genoma.plus.controller.facturacion.JPIngresoSeguimientos;
import com.genoma.plus.controller.facturacion.JPOrdenSalidaIngreso;
import com.genoma.plus.controller.facturacion.JPRecienNacido;
import com.genoma.plus.controller.facturacion.JP_SalidasInventario;
import com.genoma.plus.dao.facturacion.EventoECatPacienteGastoDAO;
import com.genoma.plus.dao.impl.facturacion.EventoECastPacienteDAOImpl;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:Facturacion/JIFLiqServicios.class */
public class JIFLiqServicios extends JInternalFrame {
    private ConsultasMySQL xct;
    private Metodos xmt;
    private String xsql;
    public Persona xjppersona;
    public JPIngreso xjpingreso;
    public JPConsolidado xjpconsolidado;
    public JPProcedimientos xjpprocedimiento;
    public JPEstanciasH xJPEstanciasH;
    public JPHistorico_Ingresos xJPHistorico_Ingresos;
    public JPEgresoUrgencias xJPEgresoUrgencias;
    public JPQuirurgico xJPQuirurgico;
    public JP_SalidasInventario xJPSalidaInventario;
    public JPORemisiones xJPRemisiones;
    private long xidempresa;
    private long xidingreso;
    private long xTipoEstrato;
    private long xId_Liqidacion;
    private long xId_Atencion;
    private long xId_GIps;
    private long xMovContable;
    private String xidtiposervicio;
    private String xidservicio;
    private String xId_ClaseProc;
    public String xIdManual;
    public String xEsCapitado;
    public String xCValor;
    public String xFiltroProc;
    public String xIdTipoPlan;
    public String xId_Cx;
    public String xGeneraMovContable;
    public String codigoRips;
    public double xPCopago;
    public double xCModeradora;
    public double xTopeAtencion;
    public double xTopeAnual;
    public double idClaseCita;
    private int xId_TipoAtencion;
    private int xId_Editable;
    private int xCerrarFactura;
    private int xTipoAuditoria;
    private int idTipoHistoria;
    private int idModalidadAtencion;
    public JPI_Control_Impresion xJPImpresion_Doc;
    public JIF_Programacion_Cx xjif_cx;
    public claseFacturacion clasefacturacion;
    public clasesHistoriaCE xclaseHC;
    public JPIngresoDocumento xJPIngresoDocumento;
    public JPIngresoSeguimientos xJPIngresoSeguimientos;
    public JPAplicaciontto xjpaplicaciontto;
    private JPEAyudasDx xjpeayudasdx;
    public JPANotas xjp_notas;
    public JPGlosa xJPGlosa;
    public JPEscaneoDocumentosEnf xJPEscaneoDocumentosEnf;
    public JPOrdenSalidaIngreso xJPOrdenSalidaIngreso;
    private int xMetodoFact;
    private int xRedondeo;
    public JPI_FormularioAnexo3 formularioAnexo3;
    public JPI_FormularioAnexo2 formularioAnexo2;
    public JPI_FormularioAnexo1 formularioAnexo1;
    public JPI_FormularioAnexo1Res2335 formularioAnexo1Res2335;
    public JPI_FormularioAnexo2Res2335 formularioAnexo2Res2335;
    public JPI_FormularioAnexo3Res2335 formularioAnexo3Res2335;
    public JPHojaTratamiento xJPHojaTratamiento;
    public JPAEventoECastPacienteGasto jPAEventoECastPacienteGasto;
    private EventoECatPacienteGastoDAO eventoECastPacienteGastoDAO;
    public JPI_IngresoSalidaAdministrativa ingresoSalidaAdministrativa;
    private JPNotasProcedimientos notasProcedimientos;
    private JPRecienNacido jPRecienNacido;
    public JLabel JLB_NIngreso;
    private JPanel JPPersona;
    public JPanel JPnVentana;
    private JTree JTRMenu;
    private JScrollPane jScrollPane1;

    public JIFLiqServicios() {
        this.xct = new ConsultasMySQL();
        this.xmt = new Metodos();
        this.xTipoEstrato = 0L;
        this.xId_Liqidacion = 0L;
        this.xId_Atencion = 0L;
        this.xMovContable = 0L;
        this.xidtiposervicio = "";
        this.xidservicio = "";
        this.xId_ClaseProc = "2";
        this.xIdManual = "";
        this.xEsCapitado = "";
        this.xCValor = "";
        this.xFiltroProc = "";
        this.xIdTipoPlan = "";
        this.xId_Cx = "0";
        this.xGeneraMovContable = "0";
        this.codigoRips = "";
        this.xPCopago = 0.0d;
        this.xCModeradora = 0.0d;
        this.xTopeAtencion = 0.0d;
        this.xTopeAnual = 0.0d;
        this.idClaseCita = 0.0d;
        this.xId_TipoAtencion = 0;
        this.xId_Editable = 0;
        this.xCerrarFactura = 0;
        this.xTipoAuditoria = -1;
        this.idTipoHistoria = 0;
        this.xjif_cx = null;
        this.clasefacturacion = null;
        initComponents();
        mCargarPanelPersonas();
        this.JLB_NIngreso.setText("");
        this.xId_Cx = "0";
        this.idClaseCita = 0.0d;
        Principal.clasefacturacion.setXgrabadofact(true);
        Metodos metodos = this.xmt;
        Metodos.mExpandAll(this.JTRMenu, true);
        springStart();
    }

    public JIFLiqServicios(claseFacturacion xclasefacturacion) {
        this.xct = new ConsultasMySQL();
        this.xmt = new Metodos();
        this.xTipoEstrato = 0L;
        this.xId_Liqidacion = 0L;
        this.xId_Atencion = 0L;
        this.xMovContable = 0L;
        this.xidtiposervicio = "";
        this.xidservicio = "";
        this.xId_ClaseProc = "2";
        this.xIdManual = "";
        this.xEsCapitado = "";
        this.xCValor = "";
        this.xFiltroProc = "";
        this.xIdTipoPlan = "";
        this.xId_Cx = "0";
        this.xGeneraMovContable = "0";
        this.codigoRips = "";
        this.xPCopago = 0.0d;
        this.xCModeradora = 0.0d;
        this.xTopeAtencion = 0.0d;
        this.xTopeAnual = 0.0d;
        this.idClaseCita = 0.0d;
        this.xId_TipoAtencion = 0;
        this.xId_Editable = 0;
        this.xCerrarFactura = 0;
        this.xTipoAuditoria = -1;
        this.idTipoHistoria = 0;
        this.xjif_cx = null;
        this.clasefacturacion = null;
        initComponents();
        this.clasefacturacion = xclasefacturacion;
        this.idClaseCita = 0.0d;
        this.xId_Cx = "0";
        mCargarPanelPersonas();
        this.JLB_NIngreso.setText("");
        Principal.clasefacturacion.setXgrabadofact(true);
        Metodos metodos = this.xmt;
        Metodos.mExpandAll(this.JTRMenu, true);
        springStart();
    }

    public JIFLiqServicios(String xid_Persona, String xId_Cx, JIF_Programacion_Cx xjif_cx, String xId_Ingreso, Integer idClaseCita) {
        this.xct = new ConsultasMySQL();
        this.xmt = new Metodos();
        this.xTipoEstrato = 0L;
        this.xId_Liqidacion = 0L;
        this.xId_Atencion = 0L;
        this.xMovContable = 0L;
        this.xidtiposervicio = "";
        this.xidservicio = "";
        this.xId_ClaseProc = "2";
        this.xIdManual = "";
        this.xEsCapitado = "";
        this.xCValor = "";
        this.xFiltroProc = "";
        this.xIdTipoPlan = "";
        this.xId_Cx = "0";
        this.xGeneraMovContable = "0";
        this.codigoRips = "";
        this.xPCopago = 0.0d;
        this.xCModeradora = 0.0d;
        this.xTopeAtencion = 0.0d;
        this.xTopeAnual = 0.0d;
        this.idClaseCita = 0.0d;
        this.xId_TipoAtencion = 0;
        this.xId_Editable = 0;
        this.xCerrarFactura = 0;
        this.xTipoAuditoria = -1;
        this.idTipoHistoria = 0;
        this.xjif_cx = null;
        this.clasefacturacion = null;
        initComponents();
        mCargarPanelPersonas();
        if (!xId_Ingreso.equals("")) {
            this.JLB_NIngreso.setText(xId_Ingreso);
        } else {
            this.JLB_NIngreso.setText("");
        }
        this.xjif_cx = xjif_cx;
        this.idClaseCita = idClaseCita.intValue();
        this.xId_Cx = xId_Cx;
        this.xidingreso = Long.valueOf(xId_Ingreso).longValue();
        Principal.clasefacturacion.setXgrabadofact(true);
        Metodos metodos = this.xmt;
        Metodos.mExpandAll(this.JTRMenu, true);
        this.xjppersona.setIdPersona(xid_Persona);
        this.xjppersona.buscar(1);
        springStart();
    }

    private void initComponents() {
        this.JPPersona = new JPanel();
        this.jScrollPane1 = new JScrollPane();
        this.JTRMenu = new JTree();
        this.JPnVentana = new JPanel();
        this.JLB_NIngreso = new JLabel();
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("FACTURACIÓN");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifLiqServicios");
        addInternalFrameListener(new InternalFrameListener() { // from class: Facturacion.JIFLiqServicios.1
            public void internalFrameActivated(InternalFrameEvent evt) {
            }

            public void internalFrameClosed(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                JIFLiqServicios.this.formInternalFrameClosing(evt);
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
        this.JPPersona.setMaximumSize(new Dimension(1000, 160));
        this.JPPersona.setMinimumSize(new Dimension(1000, 160));
        this.JPPersona.setPreferredSize(new Dimension(1000, 160));
        GroupLayout JPPersonaLayout = new GroupLayout(this.JPPersona);
        this.JPPersona.setLayout(JPPersonaLayout);
        JPPersonaLayout.setHorizontalGroup(JPPersonaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 1000, 32767));
        JPPersonaLayout.setVerticalGroup(JPPersonaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 160, 32767));
        this.JTRMenu.setFont(new Font("Arial", 1, 12));
        DefaultMutableTreeNode treeNode1 = new DefaultMutableTreeNode("root");
        DefaultMutableTreeNode treeNode2 = new DefaultMutableTreeNode("Liquidación de Servicios");
        DefaultMutableTreeNode treeNode3 = new DefaultMutableTreeNode("Historial de Ingresos");
        treeNode2.add(treeNode3);
        DefaultMutableTreeNode treeNode32 = new DefaultMutableTreeNode("Ingreso");
        treeNode2.add(treeNode32);
        DefaultMutableTreeNode treeNode33 = new DefaultMutableTreeNode("Ordenes y/o Servicios");
        DefaultMutableTreeNode treeNode4 = new DefaultMutableTreeNode("Cirugias");
        treeNode33.add(treeNode4);
        DefaultMutableTreeNode treeNode42 = new DefaultMutableTreeNode("Procedimientos /   Suministros");
        treeNode33.add(treeNode42);
        treeNode2.add(treeNode33);
        treeNode1.add(treeNode2);
        DefaultMutableTreeNode treeNode22 = new DefaultMutableTreeNode("Anexos");
        DefaultMutableTreeNode treeNode34 = new DefaultMutableTreeNode("Anexo 1");
        treeNode22.add(treeNode34);
        DefaultMutableTreeNode treeNode35 = new DefaultMutableTreeNode("Anexo 2");
        treeNode22.add(treeNode35);
        DefaultMutableTreeNode treeNode36 = new DefaultMutableTreeNode("Anexo 3");
        treeNode22.add(treeNode36);
        treeNode1.add(treeNode22);
        DefaultMutableTreeNode treeNode23 = new DefaultMutableTreeNode("Anexos Resolución 2335");
        DefaultMutableTreeNode treeNode37 = new DefaultMutableTreeNode("Anexo 1 Resolución 2335");
        treeNode23.add(treeNode37);
        DefaultMutableTreeNode treeNode38 = new DefaultMutableTreeNode("Anexo 2 Resolución 2335");
        treeNode23.add(treeNode38);
        DefaultMutableTreeNode treeNode39 = new DefaultMutableTreeNode("Anexo 3 Resolución 2335");
        treeNode23.add(treeNode39);
        treeNode1.add(treeNode23);
        treeNode1.add(new DefaultMutableTreeNode("Consolidado"));
        treeNode1.add(new DefaultMutableTreeNode("Egreso"));
        treeNode1.add(new DefaultMutableTreeNode("Orden de Salida"));
        treeNode1.add(new DefaultMutableTreeNode("Remisiones"));
        treeNode1.add(new DefaultMutableTreeNode("Impresión Documentos"));
        DefaultMutableTreeNode treeNode24 = new DefaultMutableTreeNode("Utilidades");
        DefaultMutableTreeNode treeNode310 = new DefaultMutableTreeNode("Gasto Soat");
        treeNode24.add(treeNode310);
        DefaultMutableTreeNode treeNode311 = new DefaultMutableTreeNode("Revisión Ayudas Dx");
        treeNode24.add(treeNode311);
        DefaultMutableTreeNode treeNode312 = new DefaultMutableTreeNode("Salida de Inventario");
        treeNode24.add(treeNode312);
        DefaultMutableTreeNode treeNode313 = new DefaultMutableTreeNode("Salida Administrativa");
        treeNode24.add(treeNode313);
        DefaultMutableTreeNode treeNode314 = new DefaultMutableTreeNode("Seguimientos");
        treeNode24.add(treeNode314);
        DefaultMutableTreeNode treeNode315 = new DefaultMutableTreeNode("Soportes Escaneados");
        treeNode24.add(treeNode315);
        treeNode1.add(treeNode24);
        DefaultMutableTreeNode treeNode25 = new DefaultMutableTreeNode("Auditoría");
        DefaultMutableTreeNode treeNode316 = new DefaultMutableTreeNode("Ayuda Dx y Terapéutica");
        treeNode25.add(treeNode316);
        DefaultMutableTreeNode treeNode317 = new DefaultMutableTreeNode("Hoja de Tratamiento");
        treeNode25.add(treeNode317);
        DefaultMutableTreeNode treeNode318 = new DefaultMutableTreeNode("Notas o Evoluciones");
        treeNode25.add(treeNode318);
        DefaultMutableTreeNode treeNode319 = new DefaultMutableTreeNode("Notas de Procedimiento");
        treeNode25.add(treeNode319);
        DefaultMutableTreeNode treeNode320 = new DefaultMutableTreeNode("Tratamiento");
        treeNode25.add(treeNode320);
        treeNode1.add(treeNode25);
        DefaultMutableTreeNode treeNode26 = new DefaultMutableTreeNode("Glosas");
        DefaultMutableTreeNode treeNode321 = new DefaultMutableTreeNode("Radicación");
        treeNode26.add(treeNode321);
        DefaultMutableTreeNode treeNode322 = new DefaultMutableTreeNode("Respuesta");
        treeNode26.add(treeNode322);
        treeNode1.add(treeNode26);
        DefaultMutableTreeNode treeNode27 = new DefaultMutableTreeNode("Rips");
        DefaultMutableTreeNode treeNode323 = new DefaultMutableTreeNode("Recién Nacido");
        treeNode27.add(treeNode323);
        treeNode1.add(treeNode27);
        this.JTRMenu.setModel(new DefaultTreeModel(treeNode1));
        this.JTRMenu.addMouseListener(new MouseAdapter() { // from class: Facturacion.JIFLiqServicios.2
            public void mouseClicked(MouseEvent evt) {
                JIFLiqServicios.this.JTRMenuMouseClicked(evt);
            }
        });
        this.JTRMenu.addKeyListener(new KeyAdapter() { // from class: Facturacion.JIFLiqServicios.3
            public void keyPressed(KeyEvent evt) {
                JIFLiqServicios.this.JTRMenuKeyPressed(evt);
            }
        });
        this.jScrollPane1.setViewportView(this.JTRMenu);
        this.JPnVentana.setBorder(BorderFactory.createTitledBorder(""));
        GroupLayout JPnVentanaLayout = new GroupLayout(this.JPnVentana);
        this.JPnVentana.setLayout(JPnVentanaLayout);
        JPnVentanaLayout.setHorizontalGroup(JPnVentanaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 864, 32767));
        JPnVentanaLayout.setVerticalGroup(JPnVentanaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 575, 32767));
        this.JLB_NIngreso.setFont(new Font("Arial", 1, 14));
        this.JLB_NIngreso.setHorizontalAlignment(0);
        this.JLB_NIngreso.setBorder(BorderFactory.createTitledBorder((Border) null, "Nº INGRESO", 2, 0, new Font("Arial", 1, 12), Color.red));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.JPPersona, -2, -1, -2).addGap(0, 94, 32767)).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jScrollPane1, -1, 220, 32767).addComponent(this.JLB_NIngreso, -1, -1, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPnVentana, -1, -1, 32767))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPPersona, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPnVentana, -1, -1, 32767).addGroup(layout.createSequentialGroup().addComponent(this.jScrollPane1).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JLB_NIngreso, -2, 70, -2))).addContainerGap()));
        pack();
    }

    private void springStart() {
        this.eventoECastPacienteGastoDAO = (EventoECastPacienteDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("eventoCastPacienteDAO");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTRMenuMouseClicked(MouseEvent evt) {
        mAcciones_Arbol();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosing(InternalFrameEvent evt) {
        Principal.mLimpiarDatosP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTRMenuKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            mAcciones_Arbol();
        }
    }

    public void mAcciones_Arbol() {
        DefaultMutableTreeNode nodo = (DefaultMutableTreeNode) this.JTRMenu.getLastSelectedPathComponent();
        if (nodo != null && !nodo.getUserObject().toString().equals("Liquidación de Servicios")) {
            switch (nodo.getUserObject().toString()) {
                case "Ingreso":
                    if (!this.xjppersona.getIdPersona().equals("0")) {
                        this.xjpingreso = new JPIngreso(this);
                        mMostrarPanel1(this.xjpingreso);
                        break;
                    } else {
                        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un usuario", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        this.xjppersona.txtHistoria.requestFocus();
                        break;
                    }
                    break;
                case "Procedimientos /   Suministros":
                    if (!this.JLB_NIngreso.getText().isEmpty()) {
                        this.xjpprocedimiento = new JPProcedimientos(this);
                        mMostrarPanel1(this.xjpprocedimiento);
                        break;
                    } else {
                        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un ingreso", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        this.JTRMenu.setSelectionRow(1);
                        break;
                    }
                    break;
                case "Estancias":
                    if (!this.JLB_NIngreso.getText().isEmpty()) {
                        this.xJPEstanciasH = new JPEstanciasH(this);
                        mMostrarPanel1(this.xJPEstanciasH);
                        break;
                    } else {
                        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un ingreso", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        this.JTRMenu.setSelectionRow(1);
                        break;
                    }
                    break;
                case "Historial de Ingresos":
                    if (!this.xjppersona.getIdPersona().equals("0")) {
                        this.xJPHistorico_Ingresos = new JPHistorico_Ingresos(this);
                        mMostrarPanel1(this.xJPHistorico_Ingresos);
                        break;
                    } else {
                        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un usuario", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        this.xjppersona.txtHistoria.requestFocus();
                        break;
                    }
                    break;
                case "Consolidado":
                    if (!this.JLB_NIngreso.getText().isEmpty()) {
                        this.xjpconsolidado = new JPConsolidado(this);
                        mMostrarPanel1(this.xjpconsolidado);
                        break;
                    } else {
                        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un ingreso", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        this.JTRMenu.setSelectionRow(1);
                        break;
                    }
                    break;
                case "Egreso":
                    if (!this.JLB_NIngreso.getText().isEmpty()) {
                        this.xJPEgresoUrgencias = new JPEgresoUrgencias(Long.valueOf(this.JLB_NIngreso.getText()).longValue(), 0L, getxId_TipoAtencion(), "xEgresoFact", 0, this.xmt.formatoAMD1.format(this.xjppersona.cboFechaNacimiento.getDate()));
                        mMostrarPanel1(this.xJPEgresoUrgencias);
                        break;
                    } else {
                        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un ingreso", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        this.JTRMenu.setSelectionRow(1);
                        break;
                    }
                    break;
                case "Cirugias":
                    if (!this.JLB_NIngreso.getText().isEmpty()) {
                        this.xJPQuirurgico = new JPQuirurgico(this);
                        mMostrarPanel1(this.xJPQuirurgico);
                        break;
                    } else {
                        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un ingreso", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        this.JTRMenu.setSelectionRow(1);
                        break;
                    }
                    break;
                case "Impresión Documentos":
                    if (!this.JLB_NIngreso.getText().isEmpty()) {
                        this.xJPImpresion_Doc = new JPI_Control_Impresion(String.valueOf(this.xId_Atencion), this.xjppersona.getIdPersona(), this.JLB_NIngreso.getText(), String.valueOf(this.xId_TipoAtencion), Integer.valueOf(getIdTipoHistoria()), this.xjppersona.txtCorreo.getText());
                        mMostrarPanel1(this.xJPImpresion_Doc);
                        break;
                    } else {
                        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un ingreso", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        this.JTRMenu.setSelectionRow(1);
                        break;
                    }
                    break;
                case "Remisiones":
                    if (!this.JLB_NIngreso.getText().isEmpty()) {
                        this.xclaseHC = new clasesHistoriaCE();
                        clasesHistoriaCE claseshistoriace = this.xclaseHC;
                        clasesHistoriaCE.informacionAgendaMedicaDTO.setIdAtencion(String.valueOf(getxId_Atencion()));
                        clasesHistoriaCE claseshistoriace2 = this.xclaseHC;
                        clasesHistoriaCE.informacionAgendaMedicaDTO.setIdIngreso(Long.valueOf(getXidingreso()));
                        clasesHistoriaCE claseshistoriace3 = this.xclaseHC;
                        clasesHistoriaCE.informacionAgendaMedicaDTO.setIdUsuarioAtendido(Long.valueOf(this.xjppersona.getIdPersona()));
                        this.xJPRemisiones = new JPORemisiones(this.xclaseHC, 1, false);
                        mMostrarPanel1(this.xJPRemisiones);
                        break;
                    } else {
                        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un ingreso", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        this.JTRMenu.setSelectionRow(1);
                        break;
                    }
                    break;
                case "Anexo 1":
                    if (!this.JLB_NIngreso.getText().isEmpty()) {
                        this.formularioAnexo1 = new JPI_FormularioAnexo1(Long.valueOf(this.JLB_NIngreso.getText()));
                        mMostrarPanel1(this.formularioAnexo1);
                        break;
                    } else {
                        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un ingreso", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        this.JTRMenu.setSelectionRow(1);
                        break;
                    }
                    break;
                case "Anexo 3":
                    if (!this.JLB_NIngreso.getText().isEmpty()) {
                        this.formularioAnexo3 = new JPI_FormularioAnexo3(this.JLB_NIngreso.getText());
                        mMostrarPanel1(this.formularioAnexo3);
                        break;
                    } else {
                        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un ingreso", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        this.JTRMenu.setSelectionRow(1);
                        break;
                    }
                    break;
                case "Anexo 2":
                    if (!this.JLB_NIngreso.getText().isEmpty()) {
                        this.formularioAnexo2 = new JPI_FormularioAnexo2(this.JLB_NIngreso.getText(), String.valueOf(getxId_Atencion()));
                        mMostrarPanel1(this.formularioAnexo2);
                        break;
                    } else {
                        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un ingreso", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        this.JTRMenu.setSelectionRow(1);
                        break;
                    }
                    break;
                case "Salida de Inventario":
                    if (!this.JLB_NIngreso.getText().isEmpty()) {
                        this.xJPSalidaInventario = new JP_SalidasInventario(Long.valueOf(this.JLB_NIngreso.getText()));
                        mMostrarPanel1(this.xJPSalidaInventario);
                        break;
                    } else {
                        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un ingreso", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        this.JTRMenu.setSelectionRow(1);
                        break;
                    }
                    break;
                case "Soportes Escaneados":
                    if (!this.JLB_NIngreso.getText().isEmpty()) {
                        this.xJPIngresoDocumento = new JPIngresoDocumento(Long.valueOf(this.JLB_NIngreso.getText()));
                        mMostrarPanel1(this.xJPIngresoDocumento);
                        break;
                    } else {
                        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un ingreso", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        this.JTRMenu.setSelectionRow(1);
                        break;
                    }
                    break;
                case "Seguimientos":
                    if (!this.JLB_NIngreso.getText().isEmpty()) {
                        this.xJPIngresoSeguimientos = new JPIngresoSeguimientos(Long.valueOf(this.JLB_NIngreso.getText()), getxTipoAuditoria());
                        mMostrarPanel1(this.xJPIngresoSeguimientos);
                        break;
                    } else {
                        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un ingreso", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        this.JTRMenu.setSelectionRow(1);
                        break;
                    }
                    break;
                case "Tratamiento":
                    if (!this.JLB_NIngreso.getText().isEmpty()) {
                        this.xjpaplicaciontto = new JPAplicaciontto(this.xId_TipoAtencion, String.valueOf(this.xId_Atencion), String.valueOf(this.xidingreso));
                        this.xjpaplicaciontto.JBTAdicionarI.setVisible(false);
                        this.xjpaplicaciontto.JBTSolicitar_SF.setVisible(false);
                        mMostrarPanel1(this.xjpaplicaciontto);
                        break;
                    } else {
                        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un ingreso", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        this.JTRMenu.setSelectionRow(1);
                        break;
                    }
                    break;
                case "Ayuda Dx y Terapéutica":
                    if (!this.JLB_NIngreso.getText().isEmpty()) {
                        this.xjpeayudasdx = new JPEAyudasDx(String.valueOf(this.xId_Atencion), String.valueOf(this.xidingreso));
                        mMostrarPanel1(this.xjpeayudasdx);
                        break;
                    } else {
                        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un ingreso", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        this.JTRMenu.setSelectionRow(1);
                        break;
                    }
                    break;
                case "Notas o Evoluciones":
                    if (!this.JLB_NIngreso.getText().isEmpty()) {
                        this.xjp_notas = new JPANotas(this, Long.valueOf(String.valueOf(this.xId_Atencion)), String.valueOf(this.xId_TipoAtencion), "0", Long.valueOf(this.JLB_NIngreso.getText()), "in(1,2,3,4,5,6,7,8,9)", nodo.getUserObject().toString().toUpperCase());
                        mMostrarPanel1(this.xjp_notas);
                        break;
                    } else {
                        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un ingreso", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        this.JTRMenu.setSelectionRow(1);
                        break;
                    }
                    break;
                case "Radicación":
                    if (this.JLB_NIngreso.getText().isEmpty()) {
                        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un ingreso", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        this.JTRMenu.setSelectionRow(1);
                        break;
                    } else {
                        if (getxId_Liqidacion() != 0) {
                            this.xJPGlosa = new JPGlosa(this, "Radicación");
                            mMostrarPanel1(this.xJPGlosa);
                        } else {
                            JOptionPane.showInternalMessageDialog(this, "Ingreso sin Liquidar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                            this.JTRMenu.setSelectionRow(1);
                        }
                        break;
                    }
                    break;
                case "Respuesta":
                    if (this.JLB_NIngreso.getText().isEmpty()) {
                        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un ingreso", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        this.JTRMenu.setSelectionRow(1);
                        break;
                    } else {
                        if (getxId_Liqidacion() != 0) {
                            this.xJPGlosa = new JPGlosa(this, "Respuesta");
                            mMostrarPanel1(this.xJPGlosa);
                        } else {
                            JOptionPane.showInternalMessageDialog(this, "Ingreso sin Liquidar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                            this.JTRMenu.setSelectionRow(1);
                        }
                        break;
                    }
                    break;
                case "Revisión Ayudas Dx":
                    if (!this.JLB_NIngreso.getText().isEmpty()) {
                        this.xJPEscaneoDocumentosEnf = new JPEscaneoDocumentosEnf(this.xjppersona.getIdPersona(), String.valueOf(getxId_Atencion()));
                        mMostrarPanel1(this.xJPEscaneoDocumentosEnf);
                        break;
                    } else {
                        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un ingreso", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        this.JTRMenu.setSelectionRow(1);
                        break;
                    }
                    break;
                case "Notas de Procedimiento":
                    if (!this.JLB_NIngreso.getText().isEmpty()) {
                        this.notasProcedimientos = new JPNotasProcedimientos(Long.valueOf(this.JLB_NIngreso.getText()));
                        mMostrarPanel1(this.notasProcedimientos);
                        break;
                    } else {
                        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un ingreso", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        this.JTRMenu.setSelectionRow(1);
                        break;
                    }
                    break;
                case "Orden de Salida":
                    if (!this.xjppersona.getIdPersona().equals("0")) {
                        if (!this.JLB_NIngreso.getText().isEmpty()) {
                            this.xJPOrdenSalidaIngreso = new JPOrdenSalidaIngreso(Long.valueOf(this.JLB_NIngreso.getText()));
                            mMostrarPanel1(this.xJPOrdenSalidaIngreso);
                        } else {
                            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un ingreso", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                            this.JTRMenu.setSelectionRow(1);
                        }
                        break;
                    } else {
                        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un usuario", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        this.xjppersona.txtHistoria.requestFocus();
                        break;
                    }
                    break;
                case "Salida Administrativa":
                    if (!this.xjppersona.getIdPersona().equals("0")) {
                        if (!this.JLB_NIngreso.getText().isEmpty()) {
                            this.ingresoSalidaAdministrativa = new JPI_IngresoSalidaAdministrativa(Long.valueOf(this.JLB_NIngreso.getText()));
                            mMostrarPanel1(this.ingresoSalidaAdministrativa);
                        } else {
                            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un ingreso", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                            this.JTRMenu.setSelectionRow(1);
                        }
                        break;
                    } else {
                        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un usuario", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        this.xjppersona.txtHistoria.requestFocus();
                        break;
                    }
                    break;
                case "Hoja de Tratamiento":
                    if (!this.xjppersona.getIdPersona().equals("0")) {
                        if (!this.JLB_NIngreso.getText().isEmpty()) {
                            this.xJPHojaTratamiento = new JPHojaTratamiento(this.xId_Atencion + "", getName(), "xjphojatratamiento1");
                            mMostrarPanel1(this.xJPHojaTratamiento);
                        } else {
                            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un ingreso", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                            this.JTRMenu.setSelectionRow(1);
                        }
                        break;
                    } else {
                        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un usuario", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        this.xjppersona.txtHistoria.requestFocus();
                        break;
                    }
                    break;
                case "Gasto Soat":
                    if (!this.JLB_NIngreso.getText().isEmpty()) {
                        List<Object[]> listEventoCastPaciente = this.eventoECastPacienteGastoDAO.obtenerEventoCast(this.JLB_NIngreso.getText());
                        if (listEventoCastPaciente.size() > 0) {
                            this.jPAEventoECastPacienteGasto = new JPAEventoECastPacienteGasto(this.xjppersona.getIdPersona(), this.xjppersona.getIdentificacion(), listEventoCastPaciente.get(0)[0].toString());
                            mMostrarPanel1(this.jPAEventoECastPacienteGasto);
                        }
                        break;
                    } else {
                        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un usuario", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        break;
                    }
                    break;
                case "Recién Nacido":
                    if (!this.xjppersona.getIdPersona().equals("0")) {
                        if (!this.JLB_NIngreso.getText().isEmpty()) {
                            this.jPRecienNacido = new JPRecienNacido(Long.valueOf(this.JLB_NIngreso.getText()));
                            mMostrarPanel1(this.jPRecienNacido);
                        } else {
                            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un ingreso", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                            this.JTRMenu.setSelectionRow(1);
                        }
                        break;
                    } else {
                        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un usuario", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        this.xjppersona.txtHistoria.requestFocus();
                        break;
                    }
                    break;
                case "Anexo 1 Resolución 2335":
                    if (!this.JLB_NIngreso.getText().isEmpty()) {
                        this.formularioAnexo1Res2335 = new JPI_FormularioAnexo1Res2335(Long.valueOf(this.JLB_NIngreso.getText()), getCodigoRips());
                        mMostrarPanel1(this.formularioAnexo1Res2335);
                        break;
                    } else {
                        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un ingreso", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        this.JTRMenu.setSelectionRow(1);
                        break;
                    }
                    break;
                case "Anexo 2 Resolución 2335":
                    if (!this.JLB_NIngreso.getText().isEmpty()) {
                        this.formularioAnexo2Res2335 = new JPI_FormularioAnexo2Res2335(this.JLB_NIngreso.getText(), String.valueOf(getxId_Atencion()), this, getCodigoRips());
                        mMostrarPanel1(this.formularioAnexo2Res2335);
                        break;
                    } else {
                        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un ingreso", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        this.JTRMenu.setSelectionRow(1);
                        break;
                    }
                    break;
                case "Anexo 3 Resolución 2335":
                    if (!this.JLB_NIngreso.getText().isEmpty()) {
                        this.formularioAnexo3Res2335 = new JPI_FormularioAnexo3Res2335(this.JLB_NIngreso.getText(), this, getCodigoRips());
                        mMostrarPanel1(this.formularioAnexo3Res2335);
                        break;
                    } else {
                        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un ingreso", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        this.JTRMenu.setSelectionRow(1);
                        break;
                    }
                    break;
                default:
                    mLimpiarPanel(this.JPnVentana);
                    break;
            }
        }
    }

    public void mMostrarPanel1(JPanel formulario) {
        mLimpiarPanel(this.JPnVentana);
        formulario.setBounds(5, 5, 850, 560);
        this.JPnVentana.add(formulario);
        this.JPnVentana.setVisible(true);
    }

    public void mMostrarPanelEncabezado(JPanel formulario, JPanel xjpmostar) {
        mLimpiarPanel(xjpmostar);
        formulario.setBounds(5, 5, 780, 225);
        xjpmostar.add(formulario);
        xjpmostar.setVisible(true);
    }

    public void mLimpiarPanel(JPanel xjplimpiar) {
        xjplimpiar.setVisible(false);
        xjplimpiar.removeAll();
        xjplimpiar.setVisible(true);
    }

    public void mBuscar() {
        BuscarPersona frmBuscarP = new BuscarPersona(null, true, this.xjppersona);
        frmBuscarP.setVisible(true);
    }

    private void mCargarPanelPersonas() {
        this.xjppersona = new Persona(this);
        this.xjppersona.setVisible(false);
        this.JPPersona.setVisible(false);
        this.xjppersona.setBounds(1, 1, 967, 160);
        this.JPPersona.add(this.xjppersona);
        this.JPPersona.setVisible(true);
        this.xjppersona.setVisible(true);
    }

    public void mNuevo() {
        Principal.mLimpiarDatosP();
        this.xjppersona.nuevo();
    }

    public void selectNode(String target) {
        DefaultMutableTreeNode root = (DefaultMutableTreeNode) this.JTRMenu.getModel().getRoot();
        DefaultMutableTreeNode foundNode = buscarNodo(root, target);
        if (foundNode != null) {
            TreePath path = new TreePath(foundNode.getPath());
            this.JTRMenu.setSelectionPath(path);
            this.JTRMenu.scrollPathToVisible(path);
            System.out.println("Nodo encontrado y seleccionado: " + target);
            return;
        }
        System.out.println("Nodo no encontrado: " + target);
    }

    public DefaultMutableTreeNode buscarNodo(DefaultMutableTreeNode nodo, String target) {
        if (nodo.toString().equals(target)) {
            return nodo;
        }
        Enumeration e = nodo.children();
        while (e.hasMoreElements()) {
            DefaultMutableTreeNode child = (DefaultMutableTreeNode) e.nextElement();
            DefaultMutableTreeNode result = buscarNodo(child, target);
            if (result != null) {
                return result;
            }
        }
        return null;
    }

    public void mGrabar(String hoja) {
        switch (hoja) {
            case "Ingreso":
                this.xjpingreso.mGrabar(this.xjppersona.getIdPersona(), this.xId_Cx);
                break;
            case "Estancias":
                this.xJPEstanciasH.mGrabar();
                break;
            case "Remisiones":
                this.xJPRemisiones.grabar();
                break;
            case "Soportes Escaneados":
                this.xJPIngresoDocumento.mGrabar();
                break;
            case "Seguimientos":
                this.xJPIngresoSeguimientos.mGuardar();
                break;
            case "Revisión Ayudas Dx":
                this.xJPEscaneoDocumentosEnf.mGrabar();
                break;
            case "Orden de Salida":
                this.xJPOrdenSalidaIngreso.mGrabar();
                break;
            case "jpi_formulario_anexo2":
                this.formularioAnexo2.grabar();
                break;
            case "jpi_ingresoAnexo1":
                this.formularioAnexo1.grabar();
                break;
            case "jpi_ingresoAnexo1Res2335":
                this.formularioAnexo1Res2335.grabar();
                break;
        }
    }

    public void imprimir(String hoja) {
        System.out.println("" + hoja);
        if (hoja.equals("Remisiones")) {
            this.xJPRemisiones.imprimirHojaTraslado();
        }
    }

    public int getxId_Editable() {
        return this.xId_Editable;
    }

    public void setxId_Editable(int xId_Editable) {
        this.xId_Editable = xId_Editable;
    }

    public long getXidempresa() {
        return this.xidempresa;
    }

    public void setXidempresa(long xidempresa) {
        this.xidempresa = xidempresa;
    }

    public long getXidingreso() {
        return this.xidingreso;
    }

    public void setXidingreso(long xidingreso) {
        this.xidingreso = xidingreso;
    }

    public String getXidServicio() {
        return this.xidservicio;
    }

    public void setXidServicio(String xidservicio) {
        this.xidservicio = xidservicio;
    }

    public String getXidTipoServicio() {
        return this.xidtiposervicio;
    }

    public void setXidTipoServicio(String xidtiposervicio) {
        this.xidtiposervicio = xidtiposervicio;
    }

    public String getxIdManual() {
        return this.xIdManual;
    }

    public void setxIdManual(String xIdManual) {
        this.xIdManual = xIdManual;
    }

    public long getxId_GIps() {
        return this.xId_GIps;
    }

    public void setxId_GIps(long xId_GIps) {
        this.xId_GIps = xId_GIps;
    }

    public String getxCValor() {
        return this.xCValor;
    }

    public void setxCValor(String xCValor) {
        this.xCValor = xCValor;
    }

    public String getxIdTipoPlan() {
        return this.xIdTipoPlan;
    }

    public void setxIdTipoPlan(String xIdTipoPlan) {
        this.xIdTipoPlan = xIdTipoPlan;
    }

    public String getxId_ClaseProc() {
        return this.xId_ClaseProc;
    }

    public void setxId_ClaseProc(String xId_ClaseProc) {
        this.xId_ClaseProc = xId_ClaseProc;
    }

    public long getxTipoEstrato() {
        return this.xTipoEstrato;
    }

    public void setxTipoEstrato(long xTipoEstrato) {
        this.xTipoEstrato = xTipoEstrato;
    }

    public double getxPCopago() {
        return this.xPCopago;
    }

    public void setxPCopago(double xPCopago) {
        this.xPCopago = xPCopago;
    }

    public double getxCModeradora() {
        return this.xCModeradora;
    }

    public void setxCModeradora(double xCModeradora) {
        this.xCModeradora = xCModeradora;
    }

    public String getxEsCapitado() {
        return this.xEsCapitado;
    }

    public void setxEsCapitado(String xEsCapitado) {
        this.xEsCapitado = xEsCapitado;
    }

    public long getxId_Liqidacion() {
        return this.xId_Liqidacion;
    }

    public void setxId_Liqidacion(long xId_Liqidacion) {
        this.xId_Liqidacion = xId_Liqidacion;
    }

    public int getxId_TipoAtencion() {
        return this.xId_TipoAtencion;
    }

    public void setxId_TipoAtencion(int xId_TipoAtencion) {
        this.xId_TipoAtencion = xId_TipoAtencion;
    }

    public long getxId_Atencion() {
        return this.xId_Atencion;
    }

    public void setxId_Atencion(long xId_Atencion) {
        this.xId_Atencion = xId_Atencion;
    }

    public double getxTopeAtencion() {
        return this.xTopeAtencion;
    }

    public void setxTopeAtencion(double xTopeAtencion) {
        this.xTopeAtencion = xTopeAtencion;
    }

    public double getxTopeAnual() {
        return this.xTopeAnual;
    }

    public void setxTopeAnual(double xTopeAnual) {
        this.xTopeAnual = xTopeAnual;
    }

    public double getxMovContable() {
        return this.xMovContable;
    }

    public void setxMovContable(Long xMovContable) {
        this.xMovContable = xMovContable.longValue();
    }

    public String getxGeneraMovContable() {
        return this.xGeneraMovContable;
    }

    public void setxGeneraMovContable(String xGeneraMovContable) {
        this.xGeneraMovContable = xGeneraMovContable;
    }

    public int getxCerrarFactura() {
        return this.xCerrarFactura;
    }

    public void setxCerrarFactura(int xCerrarFactura) {
        this.xCerrarFactura = xCerrarFactura;
    }

    public int getxTipoAuditoria() {
        return this.xTipoAuditoria;
    }

    public void setxTipoAuditoria(int xTipoAuditoria) {
        this.xTipoAuditoria = xTipoAuditoria;
    }

    public int getIdTipoHistoria() {
        return this.idTipoHistoria;
    }

    public void setIdTipoHistoria(int idTipoHistoria) {
        this.idTipoHistoria = idTipoHistoria;
    }

    public int getIdModalidadAtencion() {
        return this.idModalidadAtencion;
    }

    public void setIdModalidadAtencion(int idModalidadAtencion) {
        this.idModalidadAtencion = idModalidadAtencion;
    }

    public String getCodigoRips() {
        return this.codigoRips;
    }

    public void setCodigoRips(String codigoRips) {
        this.codigoRips = codigoRips;
    }

    public void mInicar_Variables_Ingreso(String xid_ingreso) {
        try {
            this.xsql = "SELECT  `f_empresacontxconvenio`.`Id_Manual` , `f_empresacontxconvenio`.`EsCapitado` , `f_empresacontxconvenio`.`CualValor` , `f_empresacontxconvenio`.`FiltroProcxEmp`, `g_empresacont`.`Id_TipoPlan`, f_empresacontxconvenio.Id  , `f_estratoxemprcontconv`.`PorcSubsidio`, `f_estratoxemprcontconv`.`ValorMaximo` , `ingreso`.`SiCopago`, ingreso.`Id_TipoAtencion`, IF(h_atencion.`Id` IS NULL, 0,h_atencion.`Id`) AS Id_Atencion, IF(f_v_datos_liquidacion_fac.IdLiquidacion IS NULL, 0,f_v_datos_liquidacion_fac.IdLiquidacion) AS IdLiquidacion, `f_estratoxemprcontconv`.`TopeAtencion` , `f_estratoxemprcontconv`.`ToPeAnual`, f_empresacontxconvenio.Id_GIps ,f_empresacontxconvenio.MetodoFact, f_empresacontxconvenio.Redondeo , f_empresacontxconvenio.GMovimientoContable , d.PCierreFactura, ifnull(`c_clasecita`.`Id_Historia`,0) idTipoHistoria ,gma.id idModalidadAtencion,  gma.nombre  modalidadAtencion, gea.nombre entornoAtencion, gsig.nombre identidadGenero, gtd.nombre categoriaDiscapacidad, f_empresacontxconvenio.CRips codigoRips FROM `ingreso` INNER JOIN `f_empresacontxconvenio`  ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`) INNER JOIN `g_empresacont` ON (`f_empresacontxconvenio`.`Id_EmpresaCont` = `g_empresacont`.`Id_empresa`) INNER JOIN `f_estrato`  ON (`ingreso`.`Id_Estrato` = `f_estrato`.`Id`) INNER JOIN `g_tipoatencion`   ON (`ingreso`.`Id_TipoAtencion` = `g_tipoatencion`.`Id`) INNER JOIN `f_estratoxemprcontconv`  ON (`f_estratoxemprcontconv`.`Copago` = `ingreso`.`SiCopago`) AND (`f_estratoxemprcontconv`.`Id_EmpresaContConv` = `f_empresacontxconvenio`.`Id`) AND (`f_estratoxemprcontconv`.`Id_Estrato` = `f_estrato`.`Id`) inner join g_modalidad_atencion gma on (ingreso.idModalidad=gma.id)\ninner join g_entorno_atencion gea on (ingreso.idEntornoAtencion=gea.id)\ninner join g_sexo_identidad_genero gsig on (ingreso.idIdentidadG=gsig.id)\ninner join g_tipo_discapacidad gtd on (ingreso.idTipoDiscapacidad=gtd.id)\n LEFT JOIN `h_atencion`  ON (`ingreso`.`Id` = `h_atencion`.`Id_Ingreso`) LEFT JOIN `c_clasecita` ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`)LEFT JOIN `f_v_datos_liquidacion_fac`  ON (`ingreso`.`Id` = `f_v_datos_liquidacion_fac`.`Id_Ingreso`)    LEFT JOIN (SELECT\n    `Id_Ingreso`\n    , `g_tiposeguimiento`.`PCierreFactura`\nFROM\n    `ingreso_seguimiento`\n    INNER JOIN `g_tiposeguimiento` ON (g_tiposeguimiento.`Id`=ingreso_seguimiento.`Id_Tipo`)\nWHERE (`g_tiposeguimiento`.`PCierreFactura`= 1 AND `Cerrado` =0 AND ingreso_seguimiento.`Estado`=1)\nGROUP BY Id_Ingreso) d ON (ingreso.`Id`=d.Id_Ingreso) WHERE (`ingreso`.`Id` ='" + xid_ingreso + "' AND `ingreso`.`Estado`=0) ORDER BY `ingreso`.`FechaIngreso` DESC,`ingreso`.`HoraIngreso` DESC  ";
            System.out.println("Incia variable " + this.xsql);
            ResultSet xrs = this.xct.traerRs(this.xsql);
            Throwable th = null;
            try {
                try {
                    if (xrs.next()) {
                        xrs.first();
                        this.xIdManual = xrs.getString("Id_Manual");
                        setxEsCapitado(xrs.getString("EsCapitado"));
                        this.xCValor = xrs.getString("CualValor");
                        this.xFiltroProc = xrs.getString("FiltroProcxEmp");
                        this.xIdTipoPlan = xrs.getString("Id_TipoPlan");
                        setXidempresa(xrs.getLong("Id"));
                        setxPCopago(xrs.getDouble("PorcSubsidio"));
                        setxTopeAtencion(xrs.getDouble("TopeAtencion"));
                        setxTopeAnual(xrs.getDouble("TopeAnual"));
                        setxCModeradora(xrs.getDouble("ValorMaximo"));
                        setxTipoEstrato(xrs.getLong("SiCopago"));
                        setxId_Liqidacion(xrs.getLong("IdLiquidacion"));
                        setxId_TipoAtencion(xrs.getInt("Id_TipoAtencion"));
                        setxId_GIps(xrs.getLong("Id_GIps"));
                        setxMetodoFact(xrs.getInt("MetodoFact"));
                        setxRedondeo(xrs.getInt("Redondeo"));
                        setxId_Atencion(xrs.getLong("Id_Atencion"));
                        setIdTipoHistoria(xrs.getInt("idTipoHistoria"));
                        setxGeneraMovContable(xrs.getString("GMovimientoContable"));
                        setxCerrarFactura(xrs.getInt("PCierreFactura"));
                        setIdModalidadAtencion(xrs.getInt("idModalidadAtencion"));
                        setCodigoRips(xrs.getString("codigoRips"));
                    }
                    if (xrs != null) {
                        if (0 != 0) {
                            try {
                                xrs.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                        } else {
                            xrs.close();
                        }
                    }
                    this.xct.cerrarConexionBd();
                } finally {
                }
            } catch (Throwable th3) {
                th = th3;
                throw th3;
            }
        } catch (SQLException ex) {
            Logger.getLogger(JIFLiqServicios.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public int getxMetodoFact() {
        return this.xMetodoFact;
    }

    public void setxMetodoFact(int xMetodoFact) {
        this.xMetodoFact = xMetodoFact;
    }

    public int getxRedondeo() {
        return this.xRedondeo;
    }

    public void setxRedondeo(int xRedondeo) {
        this.xRedondeo = xRedondeo;
    }
}
