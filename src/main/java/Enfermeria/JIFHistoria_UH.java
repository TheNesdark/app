package Enfermeria;

import Acceso.Principal;
import General.Persona;
import Historia.JPAAPatologiasAsociadas;
import Historia.JPAAntecedentesPediatricos;
import Historia.JPAAntecentesFamiliares;
import Historia.JPAAntecentesHabitos;
import Historia.JPAAntecentesPPersonales;
import Historia.JPADiagnostico;
import Historia.JPANotas;
import Historia.JPEgresoUrgencias;
import Historia.JPFichaUsuario;
import Historia.JPGestion_Hospitalizacion;
import Historia.JPIOrden_Tratamiento;
import Historia.JPI_Cirugias1;
import Historia.JPI_Control_Impresion;
import Historia.JPORemisiones;
import Historia.JPTransfuciones;
import Historia.clasesHistoriaCE;
import Odontologia.JPAAntecentesOdontologicos;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.genoma.plus.controller.enfermeria.JPHojaTratamiento;
import com.genoma.plus.controller.enfermeria.JPI_SeguimientoPosparto;
import com.genoma.plus.controller.enfermeria.JP_AtencionEnfermeria;
import com.genoma.plus.controller.facturacion.JPI_FormularioAnexo2;
import com.genoma.plus.controller.facturacion.JPI_FormularioAnexo3;
import com.genoma.plus.controller.sgc.JPEventoAdverso;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
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

/* JADX INFO: loaded from: GenomaP.jar:Enfermeria/JIFHistoria_UH.class */
public class JIFHistoria_UH extends JInternalFrame {
    private String xsql;
    private String xid_atencion;
    private String xId_Ingreso;
    private ConsultasMySQL xct = new ConsultasMySQL();
    private Metodos xmt = new Metodos();
    public Persona xjppersona;
    private long xidempresa;
    private long xidingreso;
    private JPEvoluciones xjpevolucion;
    public JPAplicaciontto xjpaplicaciontto;
    private JPEAyudasDx xjpeayudasdx;
    private JPRSignosVitales xjpsignoavitales;
    private JPIOrden_Tratamiento xjiftratamiento;
    private JPGestion_Hospitalizacion xjifg_hospitalizacion;
    private JPTransfuciones xJPTransfuciones;
    private int xtipo;
    public int xId_TipoAtencion;
    public int idTipoHistoria;
    public JPI_Cirugias1 xJPCirugias;
    public JPI_Control_Impresion xJPImpresion_Doc;
    public JPControlDiabetes xJPControlDiabetes;
    public JPControlOxigeno xJPControlOxigeno;
    public JPANotas xjp_notas;
    public JPControlLiquidos xJPControlLiquidos;
    private JPI_CensoCama xJPCesoCama;
    public JPEscaneoDocumentosEnf xJPEscaneoDocumentosEnf;
    public JPHojaTratamiento xJPHojaTratamiento;
    public JPI_FormularioAnexo3 formularioAnexo3;
    public JPI_FormularioAnexo2 formularioAnexo2;
    public JPI_SeguimientoPosparto xSeguimientoPosparto;
    public JPEventoAdverso xJPEventoAdverso;
    private String frmLlamador;
    public clasesHistoriaCE xclaseHC;
    public JPORemisiones xJPRemisiones;
    public JP_AtencionEnfermeria atencionEnfermeria;
    private JButton JBTVisualizar;
    public JLabel JLBNAatencion;
    public JPanel JPNVentana;
    private JPanel JPPersona;
    private JScrollPane JSPDatosArbol;
    private JTree JTRMenu;

    public JIFHistoria_UH(String xnhc, String xId_Ingreso, int xtipo, String xid_atencion, Integer idTipoHistoria, String frmLlamador) {
        this.xtipo = 0;
        initComponents();
        this.xtipo = xtipo;
        this.xId_TipoAtencion = xtipo;
        this.xid_atencion = xid_atencion;
        this.idTipoHistoria = idTipoHistoria.intValue();
        mCargarPanelPersonas();
        this.xjppersona.txtHistoria.setText(xnhc);
        this.xjppersona.buscar(2);
        this.xId_Ingreso = xId_Ingreso;
        Principal.txtNo.setText(xId_Ingreso);
        this.JLBNAatencion.setText(xid_atencion);
        Metodos metodos = this.xmt;
        Metodos.mExpandAll(this.JTRMenu, true);
        this.frmLlamador = frmLlamador;
    }

    public JIFHistoria_UH(String xnhc, String xId_Ingreso, String xid_atencion) {
        this.xtipo = 0;
        initComponents();
        this.xtipo = this.xtipo;
        this.xid_atencion = xid_atencion;
        mCargarPanelPersonas();
        this.xjppersona.txtHistoria.setText(xnhc);
        this.xjppersona.buscar(2);
        this.xId_Ingreso = xId_Ingreso;
        Principal.txtNo.setText(xId_Ingreso);
        this.JLBNAatencion.setText(xid_atencion);
        Metodos metodos = this.xmt;
        Metodos.mExpandAll(this.JTRMenu, true);
    }

    private void initComponents() {
        this.JPPersona = new JPanel();
        this.JSPDatosArbol = new JScrollPane();
        this.JTRMenu = new JTree();
        this.JPNVentana = new JPanel();
        this.JLBNAatencion = new JLabel();
        this.JBTVisualizar = new JButton();
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("HISTORIA URGENCIAS - HOSPITALIZACIÒN");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjifhistoriauh");
        setPreferredSize(new Dimension(1364, 941));
        addInternalFrameListener(new InternalFrameListener() { // from class: Enfermeria.JIFHistoria_UH.1
            public void internalFrameOpened(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                JIFHistoria_UH.this.formInternalFrameClosing(evt);
            }

            public void internalFrameClosed(InternalFrameEvent evt) {
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
        this.JPPersona.setMaximumSize(new Dimension(1000, 160));
        this.JPPersona.setMinimumSize(new Dimension(1000, 160));
        this.JPPersona.setPreferredSize(new Dimension(1000, 160));
        GroupLayout JPPersonaLayout = new GroupLayout(this.JPPersona);
        this.JPPersona.setLayout(JPPersonaLayout);
        JPPersonaLayout.setHorizontalGroup(JPPersonaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 0, 32767));
        JPPersonaLayout.setVerticalGroup(JPPersonaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 160, 32767));
        this.JTRMenu.setFont(new Font("Arial", 1, 12));
        DefaultMutableTreeNode treeNode1 = new DefaultMutableTreeNode("root");
        DefaultMutableTreeNode treeNode2 = new DefaultMutableTreeNode("Atención");
        DefaultMutableTreeNode treeNode3 = new DefaultMutableTreeNode("Ingreso");
        treeNode2.add(treeNode3);
        DefaultMutableTreeNode treeNode32 = new DefaultMutableTreeNode("Diagnóstico de Ingreso");
        treeNode2.add(treeNode32);
        DefaultMutableTreeNode treeNode33 = new DefaultMutableTreeNode("Atención (Nanda, Nic, Noc)");
        treeNode2.add(treeNode33);
        treeNode1.add(treeNode2);
        DefaultMutableTreeNode treeNode22 = new DefaultMutableTreeNode("Antecendentes");
        DefaultMutableTreeNode treeNode34 = new DefaultMutableTreeNode("Familiares");
        treeNode22.add(treeNode34);
        DefaultMutableTreeNode treeNode35 = new DefaultMutableTreeNode("Hábitos");
        treeNode22.add(treeNode35);
        DefaultMutableTreeNode treeNode36 = new DefaultMutableTreeNode("Infantiles");
        treeNode22.add(treeNode36);
        DefaultMutableTreeNode treeNode37 = new DefaultMutableTreeNode("Odontológicos");
        treeNode22.add(treeNode37);
        DefaultMutableTreeNode treeNode38 = new DefaultMutableTreeNode("Patológicos");
        treeNode22.add(treeNode38);
        DefaultMutableTreeNode treeNode39 = new DefaultMutableTreeNode("Personales");
        treeNode22.add(treeNode39);
        treeNode1.add(treeNode22);
        DefaultMutableTreeNode treeNode23 = new DefaultMutableTreeNode("Observación-Hospitalización");
        DefaultMutableTreeNode treeNode310 = new DefaultMutableTreeNode("Censo de Cama");
        treeNode23.add(treeNode310);
        DefaultMutableTreeNode treeNode311 = new DefaultMutableTreeNode("Solicitud");
        treeNode23.add(treeNode311);
        DefaultMutableTreeNode treeNode312 = new DefaultMutableTreeNode("Asignación");
        treeNode23.add(treeNode312);
        DefaultMutableTreeNode treeNode313 = new DefaultMutableTreeNode("Traslados");
        treeNode23.add(treeNode313);
        treeNode1.add(treeNode23);
        DefaultMutableTreeNode treeNode24 = new DefaultMutableTreeNode("Ordenes y/o Servicios");
        DefaultMutableTreeNode treeNode314 = new DefaultMutableTreeNode("Ayuda Dx y Terapéutica");
        treeNode24.add(treeNode314);
        DefaultMutableTreeNode treeNode315 = new DefaultMutableTreeNode("Hoja de Tratamiento");
        treeNode24.add(treeNode315);
        DefaultMutableTreeNode treeNode316 = new DefaultMutableTreeNode("Remisiones");
        treeNode24.add(treeNode316);
        DefaultMutableTreeNode treeNode317 = new DefaultMutableTreeNode("Solicitud Dispositivos Médicos");
        treeNode24.add(treeNode317);
        DefaultMutableTreeNode treeNode318 = new DefaultMutableTreeNode("Transfusiones Sanguineas");
        treeNode24.add(treeNode318);
        DefaultMutableTreeNode treeNode319 = new DefaultMutableTreeNode("Tratamiento");
        treeNode24.add(treeNode319);
        treeNode1.add(treeNode24);
        treeNode1.add(new DefaultMutableTreeNode("Control Diabetes"));
        treeNode1.add(new DefaultMutableTreeNode("Control Oxígeno"));
        treeNode1.add(new DefaultMutableTreeNode("Control de Líquidos"));
        treeNode1.add(new DefaultMutableTreeNode("Nota Enfermeria"));
        treeNode1.add(new DefaultMutableTreeNode("Signos Vitales"));
        DefaultMutableTreeNode treeNode25 = new DefaultMutableTreeNode("Cirugía");
        DefaultMutableTreeNode treeNode320 = new DefaultMutableTreeNode("Intervención Quirúrgica");
        treeNode25.add(treeNode320);
        treeNode1.add(treeNode25);
        treeNode1.add(new DefaultMutableTreeNode("Egreso"));
        treeNode1.add(new DefaultMutableTreeNode("Impresión Documentos"));
        treeNode1.add(new DefaultMutableTreeNode("Escaneo de Documentos"));
        DefaultMutableTreeNode treeNode26 = new DefaultMutableTreeNode("Anexos");
        DefaultMutableTreeNode treeNode321 = new DefaultMutableTreeNode("Anexo 2");
        treeNode26.add(treeNode321);
        DefaultMutableTreeNode treeNode322 = new DefaultMutableTreeNode("Anexo 3");
        treeNode26.add(treeNode322);
        treeNode1.add(treeNode26);
        treeNode1.add(new DefaultMutableTreeNode("Registro Evento Adverso"));
        DefaultMutableTreeNode treeNode27 = new DefaultMutableTreeNode("Posparto");
        DefaultMutableTreeNode treeNode323 = new DefaultMutableTreeNode("Seguimiento");
        treeNode27.add(treeNode323);
        treeNode1.add(treeNode27);
        this.JTRMenu.setModel(new DefaultTreeModel(treeNode1));
        this.JTRMenu.setRootVisible(false);
        this.JTRMenu.addMouseListener(new MouseAdapter() { // from class: Enfermeria.JIFHistoria_UH.2
            public void mouseClicked(MouseEvent evt) {
                JIFHistoria_UH.this.JTRMenuMouseClicked(evt);
            }
        });
        this.JSPDatosArbol.setViewportView(this.JTRMenu);
        this.JPNVentana.setBorder(BorderFactory.createTitledBorder(""));
        this.JPNVentana.setAutoscrolls(true);
        GroupLayout JPNVentanaLayout = new GroupLayout(this.JPNVentana);
        this.JPNVentana.setLayout(JPNVentanaLayout);
        JPNVentanaLayout.setHorizontalGroup(JPNVentanaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 0, 32767));
        JPNVentanaLayout.setVerticalGroup(JPNVentanaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 0, 32767));
        this.JLBNAatencion.setFont(new Font("Arial", 1, 18));
        this.JLBNAatencion.setHorizontalAlignment(0);
        this.JLBNAatencion.setBorder(BorderFactory.createTitledBorder((Border) null, "Nº ATENCIÓN", 2, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.JBTVisualizar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Configuracion29x27.png")));
        this.JBTVisualizar.setText("Visualizar HC");
        this.JBTVisualizar.setIconTextGap(0);
        this.JBTVisualizar.addActionListener(new ActionListener() { // from class: Enfermeria.JIFHistoria_UH.3
            public void actionPerformed(ActionEvent evt) {
                JIFHistoria_UH.this.JBTVisualizarActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JSPDatosArbol, -1, 220, 32767).addComponent(this.JLBNAatencion, -1, -1, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPNVentana, -1, -1, 32767)).addGroup(layout.createSequentialGroup().addComponent(this.JPPersona, -2, 988, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTVisualizar, -1, 346, 32767))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JPPersona, -1, -1, 32767).addComponent(this.JBTVisualizar, -1, -1, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.JSPDatosArbol, -1, 627, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JLBNAatencion, -2, 83, -2)).addComponent(this.JPNVentana, -1, -1, 32767)).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTRMenuMouseClicked(MouseEvent evt) {
        DefaultMutableTreeNode nodo = (DefaultMutableTreeNode) this.JTRMenu.getLastSelectedPathComponent();
        if (nodo != null && !nodo.getUserObject().toString().equals("Liquidación de Servicios")) {
            switch (nodo.getUserObject().toString()) {
                case "Ingreso":
                    JPFichaUsuario frm = new JPFichaUsuario(Principal.txtNo.getText());
                    mMostrarPanel1(frm);
                    return;
                case "Atención (Nanda, Nic, Noc)":
                    this.atencionEnfermeria = new JP_AtencionEnfermeria(this.xid_atencion, nodo.getUserObject().toString());
                    mMostrarPanel1(this.atencionEnfermeria);
                    return;
                case "Diagnóstico de Ingreso":
                    JPADiagnostico frm2 = new JPADiagnostico(this.xid_atencion);
                    mMostrarPanel1(frm2);
                    return;
                case "Egreso":
                    JPEgresoUrgencias xJPEgresoUrgencias = new JPEgresoUrgencias(Long.valueOf(this.xId_Ingreso).longValue(), Long.valueOf(this.xid_atencion).longValue(), this.xId_TipoAtencion, "xEgresoHC", 0);
                    mMostrarPanel1(xJPEgresoUrgencias);
                    return;
                case "Nota Enfermeria":
                    this.xjp_notas = new JPANotas(this, Long.valueOf(this.JLBNAatencion.getText()), String.valueOf(this.xId_TipoAtencion), "0", Long.valueOf(this.xId_Ingreso), "in(6,11,8)", nodo.getUserObject().toString().toUpperCase());
                    mMostrarPanel1(this.xjp_notas);
                    return;
                case "Remisiones":
                    if (!this.JLBNAatencion.getText().isEmpty()) {
                        this.xclaseHC = new clasesHistoriaCE();
                        clasesHistoriaCE.informacionAgendaMedicaDTO.setIdAtencion(this.JLBNAatencion.getText());
                        clasesHistoriaCE.informacionAgendaMedicaDTO.setIdIngreso(Long.valueOf(getXidingreso()));
                        clasesHistoriaCE.informacionAgendaMedicaDTO.setIdUsuarioAtendido(Long.valueOf(this.xjppersona.getIdPersona()));
                        this.xJPRemisiones = new JPORemisiones(this.xclaseHC, 1, false);
                        mMostrarPanel1(this.xJPRemisiones);
                        return;
                    }
                    JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un ingreso", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    this.JTRMenu.setSelectionRow(1);
                    return;
                case "Tratamiento":
                    this.xjpaplicaciontto = new JPAplicaciontto(this.xId_TipoAtencion, this.JLBNAatencion.getText(), this.xId_Ingreso);
                    mMostrarPanel1(this.xjpaplicaciontto);
                    return;
                case "Ayuda Dx y Terapéutica":
                    this.xjpeayudasdx = new JPEAyudasDx(this.JLBNAatencion.getText(), this.xId_Ingreso);
                    mMostrarPanel1(this.xjpeayudasdx);
                    return;
                case "Signos Vitales":
                    this.xjpsignoavitales = new JPRSignosVitales(getName());
                    mMostrarPanel1(this.xjpsignoavitales);
                    return;
                case "Solicitud Dispositivos Médicos":
                    this.xjiftratamiento = new JPIOrden_Tratamiento(this.JLBNAatencion.getText(), Principal.txtNo.getText(), this.xjppersona.IdPersona, this.xId_TipoAtencion, 0L, getName());
                    mMostrarPanel1(this.xjiftratamiento);
                    return;
                case "Solicitud":
                    this.xjifg_hospitalizacion = new JPGestion_Hospitalizacion(this.JLBNAatencion.getText(), "", "", 0, Principal.txtNo.getText(), getName(), false);
                    mMostrarPanel1(this.xjifg_hospitalizacion);
                    return;
                case "Asignación":
                    if (mValidarRegistrosAsignacion()) {
                        if (Principal.informacionIps.getNombreIps().equals("CLINICA LAURELES PSIQUIATRAS ASOCIADOS I.P.S. S.A.S.") || Principal.informacionIps.getIdentificacion().equals("812005644") || Principal.informacionIps.getNombreIps().equals("UNION TEMPORAL CLINICA LAURELES")) {
                            this.xjifg_hospitalizacion = new JPGestion_Hospitalizacion(this.JLBNAatencion.getText(), "", "", 5, Principal.txtNo.getText(), getName(), false);
                            mMostrarPanel1(this.xjifg_hospitalizacion);
                            return;
                        } else {
                            this.xjifg_hospitalizacion = new JPGestion_Hospitalizacion(this.JLBNAatencion.getText(), "", "", 4, Principal.txtNo.getText(), getName(), false);
                            mMostrarPanel1(this.xjifg_hospitalizacion);
                            return;
                        }
                    }
                    JOptionPane.showInternalMessageDialog(this, "Debe realizar primero una solicitud", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    mLimpiarPanel(this.JPNVentana);
                    return;
                case "Transfusiones Sanguineas":
                    this.xJPTransfuciones = new JPTransfuciones("TransfusionesEnf");
                    mMostrarPanel1(this.xJPTransfuciones);
                    return;
                case "Intervención Quirúrgica":
                    this.xJPCirugias = new JPI_Cirugias1(Long.valueOf(this.JLBNAatencion.getText()).longValue(), nodo.getUserObject().toString().toUpperCase());
                    mMostrarPanel2(this.xJPCirugias);
                    return;
                case "Impresión Documentos":
                    this.xJPImpresion_Doc = new JPI_Control_Impresion(this.JLBNAatencion.getText(), this.xjppersona.getIdPersona(), Principal.txtNo.getText(), String.valueOf(this.xtipo), Integer.valueOf(this.idTipoHistoria), this.xjppersona.txtCorreo.getText());
                    mMostrarPanel2(this.xJPImpresion_Doc);
                    return;
                case "Control Diabetes":
                    this.xJPControlDiabetes = new JPControlDiabetes("jifControlDM_Enf");
                    mMostrarPanel2(this.xJPControlDiabetes);
                    return;
                case "Control Oxígeno":
                    this.xJPControlOxigeno = new JPControlOxigeno(getName());
                    mMostrarPanel2(this.xJPControlOxigeno);
                    return;
                case "Familiares":
                    JPAAntecentesFamiliares frm3 = new JPAAntecentesFamiliares(this.xjppersona.getIdPersona(), this.xid_atencion);
                    mMostrarPanel2(frm3);
                    frm3.JCBTipoParentesco.requestFocus();
                    return;
                case "Hábitos":
                    JPAAntecentesHabitos frm4 = new JPAAntecentesHabitos(this.xjppersona.getIdPersona(), this.xid_atencion);
                    mMostrarPanel2(frm4);
                    frm4.JRBPDSi.requestFocus();
                    return;
                case "Patológicos":
                    JPAAntecentesPPersonales frm5 = new JPAAntecentesPPersonales(this.xjppersona.getIdPersona(), this.xid_atencion);
                    mMostrarPanel2(frm5);
                    return;
                case "Personales":
                    JPAAPatologiasAsociadas frm6 = new JPAAPatologiasAsociadas(this.xjppersona.getIdPersona(), this.xid_atencion);
                    mMostrarPanel2(frm6);
                    return;
                case "Infantiles":
                    JPAAntecedentesPediatricos frm7 = new JPAAntecedentesPediatricos(this.xjppersona.getIdPersona(), this.xid_atencion);
                    mMostrarPanel2(frm7);
                    return;
                case "Odontológicos":
                    JPAAntecentesOdontologicos frm8 = new JPAAntecentesOdontologicos(this.xjppersona.getIdPersona(), this.xid_atencion);
                    mMostrarPanel2(frm8);
                    return;
                case "Traslados":
                    if (mValidarRegistrosAsignacion()) {
                        JPTrasladosCamas frm9 = new JPTrasladosCamas(this.xid_atencion);
                        mMostrarPanel2(frm9);
                        return;
                    } else {
                        JOptionPane.showInternalMessageDialog(this, "Debe realizar asignación", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        break;
                    }
                    break;
                case "Control de Líquidos":
                    break;
                case "Censo de Cama":
                    this.xJPCesoCama = new JPI_CensoCama();
                    mMostrarPanel2(this.xJPCesoCama);
                    return;
                case "Escaneo de Documentos":
                    this.xJPEscaneoDocumentosEnf = new JPEscaneoDocumentosEnf(this.xjppersona.getIdPersona(), this.xid_atencion);
                    mMostrarPanel2(this.xJPEscaneoDocumentosEnf);
                    return;
                case "Hoja de Tratamiento":
                    this.xJPHojaTratamiento = new JPHojaTratamiento(this.xid_atencion, getName(), "xjphojatratamiento");
                    mMostrarPanel2(this.xJPHojaTratamiento);
                    return;
                case "Anexo 2":
                    this.formularioAnexo2 = new JPI_FormularioAnexo2(this.xId_Ingreso, this.xid_atencion);
                    mMostrarPanel2(this.formularioAnexo2);
                    return;
                case "Registro Evento Adverso":
                    this.xJPEventoAdverso = new JPEventoAdverso(false, this.xId_Ingreso, 2);
                    mMostrarPanel1(this.xJPEventoAdverso);
                    return;
                case "Anexo 3":
                    this.formularioAnexo3 = new JPI_FormularioAnexo3(this.xId_Ingreso);
                    mMostrarPanel2(this.formularioAnexo3);
                    return;
                case "Seguimiento":
                    this.xSeguimientoPosparto = new JPI_SeguimientoPosparto(this.xid_atencion);
                    mMostrarPanel2(this.xSeguimientoPosparto);
                    return;
                default:
                    mLimpiarPanel(this.JPNVentana);
                    return;
            }
            this.xJPControlLiquidos = new JPControlLiquidos(this.xid_atencion, this.xjppersona.getIdPersona());
            mMostrarPanel2(this.xJPControlLiquidos);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosing(InternalFrameEvent evt) {
        if (Principal.claseenfer.xjifagenda_UH == null) {
            Principal.mLimpiarDatosP();
            mActivarAgendas();
            dispose();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTVisualizarActionPerformed(ActionEvent evt) {
        String[][] mparametros = new String[4][2];
        mparametros[0][0] = "idatencion1";
        mparametros[0][1] = this.JLBNAatencion.getText();
        mparametros[1][0] = "idpaciente1";
        mparametros[1][1] = this.xjppersona.IdPersona;
        mparametros[2][0] = "SUBREPORT_DIR";
        mparametros[2][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
        mparametros[3][0] = "SUBREPORTFIRMA_DIR";
        mparametros[3][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
        if (Principal.informacionIps.getEsFpz().intValue() == 0) {
            this.xmt.GenerarPDF(this.xmt.getRutaRep() + "H_HistoriaClinica", mparametros);
        } else if (Principal.claseenfer.xjifhc_uhh.xId_TipoAtencion == 2) {
            this.xmt.GenerarPDF(this.xmt.getRutaRep() + "H_HistoriaClinica_Hospitalizacion", mparametros);
        } else {
            this.xmt.GenerarPDF(this.xmt.getRutaRep() + "H_HistoriaClinica_Urgencias", mparametros);
        }
    }

    public void mMostrarPanel1(JPanel formulario) {
        mLimpiarPanel(this.JPNVentana);
        formulario.setBounds(5, 10, 890, 700);
        this.JPNVentana.add(formulario);
        this.JPNVentana.setVisible(true);
    }

    public void mMostrarPanel2(JPanel formulario) {
        mLimpiarPanel(this.JPNVentana);
        formulario.setBounds(5, 10, 890, 580);
        this.JPNVentana.add(formulario);
        this.JPNVentana.setVisible(true);
    }

    public void mMostrarPanelEncabezado(JPanel formulario, JPanel xjpmostar) {
        mLimpiarPanel(xjpmostar);
        formulario.setBounds(5, 5, 780, 160);
        xjpmostar.add(formulario);
        xjpmostar.setVisible(true);
    }

    public void mLimpiarPanel(JPanel xjplimpiar) {
        xjplimpiar.setVisible(false);
        xjplimpiar.removeAll();
        xjplimpiar.setVisible(true);
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
        if (this.JPNVentana.getComponentCount() == 1) {
            if (this.JPNVentana.getComponent(0).getName().equals("xjpevolucion")) {
                this.xjpevolucion.mNuevo();
                return;
            }
            if (this.JPNVentana.getComponent(0).getName().equals("xjpaplicaciontto")) {
                this.xjpaplicaciontto.mNuevo();
                return;
            }
            if (this.JPNVentana.getComponent(0).getName().equals("jifControlDM_Enf")) {
                this.xJPControlDiabetes.mNuevo();
                return;
            }
            if (this.JPNVentana.getComponent(0).getName().equals("xpControlOxigeno")) {
                this.xJPControlOxigeno.mNuevo();
                return;
            }
            if (this.JPNVentana.getComponent(0).getName().equals("xjpescaneodocumentosenf")) {
                this.xJPEscaneoDocumentosEnf.mNuevo();
                return;
            }
            if (this.JPNVentana.getComponent(0).getName().equals("xjpevolucion")) {
                this.xjpevolucion.mNuevo();
                return;
            }
            if (this.JPNVentana.getComponent(0).getName().equals("jptratamiento_ordenes")) {
                this.xjiftratamiento.mNuevo();
                return;
            }
            if (this.JPNVentana.getComponent(0).getName().equals("jpi_formulario_anexo2")) {
                this.formularioAnexo2.nuevo();
                return;
            }
            if (this.JPNVentana.getComponent(0).getName().equals("xjpi_formulaanexo3")) {
                this.formularioAnexo3.nuevo();
            } else if (this.JPNVentana.getComponent(0).getName().equals("xjpi_formulaanexo3")) {
                this.formularioAnexo3.nuevo();
            } else if (this.JPNVentana.getComponent(0).getName().equals("xjpeventoadverso")) {
                this.xJPEventoAdverso.mNuevo();
            }
        }
    }

    public void anular() {
        if (this.JPNVentana.getComponentCount() == 1 && this.JPNVentana.getComponent(0).getName().equals("jpi_atencionEnfermeria")) {
            this.atencionEnfermeria.anular();
        }
    }

    public void mGrabar() {
        if (this.JPNVentana.getComponentCount() == 1) {
            switch (this.JPNVentana.getComponent(0).getName()) {
                case "xjpevolucion":
                    this.xjpevolucion.mGrabar();
                    break;
                case "xjpaplicaciontto":
                    this.xjpaplicaciontto.mGrabar();
                    break;
                case "xjpeayudasdx":
                    this.xjpeayudasdx.mGrabar();
                    break;
                case "jptratamiento_ordenes":
                    this.xjiftratamiento.mGrabar();
                    break;
                case "transfusiones":
                    this.xJPTransfuciones.mGuardar();
                    break;
                case "jifControlDM_Enf":
                    this.xJPControlDiabetes.mGuardar();
                    break;
                case "xpControlOxigeno":
                    this.xJPControlOxigeno.mGuardar();
                    break;
                case "xpControlLiquidos":
                    this.xJPControlLiquidos.mGuardar();
                    break;
                case "xjpescaneodocumentosenf":
                    this.xJPEscaneoDocumentosEnf.mGrabar();
                    break;
                case "jpi_formulario_anexo2":
                    this.formularioAnexo2.grabar();
                    break;
                case "xjpi_formulaanexo3":
                    this.formularioAnexo3.grabar();
                    break;
                case "jpremisiones":
                    this.xJPRemisiones.grabar();
                    break;
                case "xjpeventoadverso":
                    this.xJPEventoAdverso.mGrabar();
                    break;
                case "xjpseguimientoposparto":
                    this.xSeguimientoPosparto.mGrabar();
                    break;
                case "jpi_atencionEnfermeria":
                    this.atencionEnfermeria.grabar();
                    break;
            }
        }
    }

    public void mImprimir() {
        if (this.JPNVentana.getComponentCount() == 1) {
            switch (this.JPNVentana.getComponent(0).getName()) {
                case "jpi_atencionEnfermeria":
                    this.atencionEnfermeria.imprimir();
                    break;
            }
        }
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

    /* JADX WARN: Finally extract failed */
    private void mCargarNAtencion() {
        try {
            this.xsql = "SELECT h_atencion.`Id`, `ingreso`.`Id_TipoAtencion` FROM `h_atencion` INNER JOIN `ingreso`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`) WHERE (h_atencion.`Id_Ingreso` ='" + Principal.txtNo.getText() + "') ";
            ResultSet xrs = this.xct.traerRs(this.xsql);
            Throwable th = null;
            try {
                if (xrs.next()) {
                    xrs.first();
                    this.JLBNAatencion.setText(xrs.getString(1));
                    this.xId_TipoAtencion = xrs.getInt(2);
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
            } catch (Throwable th3) {
                if (xrs != null) {
                    if (0 != 0) {
                        try {
                            xrs.close();
                        } catch (Throwable th4) {
                            th.addSuppressed(th4);
                        }
                    } else {
                        xrs.close();
                    }
                }
                throw th3;
            }
        } catch (SQLException ex) {
            Logger.getLogger(JIFHistoria_UH.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private boolean mValidarRegistrosAsignacion() {
        boolean xvalidar = false;
        try {
            this.xsql = "SELECT `h_orden_hospitalizacion`.`Id`,  DATE_FORMAT(`h_orden_hospitalizacion`.`FechaH`,'%Y-%m-%d') AS `Fecha`, DATE_FORMAT(`h_orden_hospitalizacion`.`FechaH`,'%H:%m:%s') AS `Hora` , CONCAT(`profesional1`.`NProfesional`,' - ', `profesional1`.`Especialidad`) AS `Profesional` , `g_patologia`.`Id` , `g_patologia`.`Nbre` , IF(`h_orden_hospitalizacion`.`FechaS` IS NULL,  '',  DATE_FORMAT(`h_orden_hospitalizacion`.`FechaS`,'%Y-%m-%d')) AS `FEchaS` , IF(`h_orden_hospitalizacion`.`FechaS` IS NULL, '',  DATE_FORMAT(`h_orden_hospitalizacion`.`FechaS`,'%H:%m:%s') ) AS `HoraS`  , IF(`Profesional_Solicitante`.`Especialidad` IS NULL, '', CONCAT(`Profesional_Solicitante`.`NProfesional`,' - ',`Profesional_Solicitante`.`Especialidad` )) AS `PSolictante`      \nFROM  `profesional1` INNER JOIN `h_orden_hospitalizacion`  ON (`profesional1`.`IdEspecialidad` = `h_orden_hospitalizacion`.`Id_Especialidad_O`) AND (`profesional1`.`Id_Persona` = `h_orden_hospitalizacion`.`Id_Profesional_O`) \nINNER JOIN h_atencion ON( h_orden_hospitalizacion.`Id_Atencion`=h_atencion.`Id`) INNER JOIN `ingreso` ON( ingreso.`Id`=h_atencion.`Id_Ingreso`) INNER JOIN `g_patologia`  ON (`h_orden_hospitalizacion`.`Dx_Cie10` = `g_patologia`.`Id`) \nLEFT JOIN `profesional1` AS `Profesional_Solicitante`  ON (`Profesional_Solicitante`.`Id_Persona` = `h_orden_hospitalizacion`.`Id_Profesional_S`) AND (`Profesional_Solicitante`.`IdEspecialidad` = `h_orden_hospitalizacion`.`Id_Especialidad_S`) \nLEFT JOIN `profesional1` AS `PAsignado`  ON (`PAsignado`.`Id_Persona` = `h_orden_hospitalizacion`.`Id_Profesional_A`) AND (`PAsignado`.`IdEspecialidad` = `h_orden_hospitalizacion`.`Id_Especialidad_A`)   \nLEFT JOIN `f_camas`  ON (`f_camas`.`Id` = `ingreso`.`Cama`)  LEFT JOIN `f_unidadcama`  ON (`f_camas`.`Id_UnidadCamas` = `f_unidadcama`.`Id`) WHERE (`h_orden_hospitalizacion`.`Id_Atencion` ='" + this.JLBNAatencion.getText() + "' AND `h_orden_hospitalizacion`.`Estado` =1)";
            ResultSet xrs = this.xct.traerRs(this.xsql);
            Throwable th = null;
            try {
                try {
                    if (xrs.next()) {
                        xrs.first();
                        if (!xrs.getString(1).isEmpty() && !xrs.getString(2).isEmpty() && !xrs.getString(3).isEmpty() && !xrs.getString(4).isEmpty() && !xrs.getString(5).isEmpty() && !xrs.getString(6).isEmpty() && !xrs.getString(7).isEmpty() && !xrs.getString(8).isEmpty()) {
                            if (!xrs.getString(9).isEmpty()) {
                                xvalidar = true;
                            }
                        }
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
            } finally {
            }
        } catch (SQLException ex) {
            Logger.getLogger(JIFHistoria_UH.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return xvalidar;
    }

    private void mActivarAgendas() {
        if (Principal.claseenfer.agendaServicioEnfermeria != null || Principal.claseenfer.agendaServicioEnfermeriaV2 != null || Principal.claseenfer.xjifagenda_UH != null) {
            Principal.claseenfer.xjp.mLimpiarPanel();
        }
        if (this.frmLlamador.equals("Agenda Servicios") || this.frmLlamador.equals("Agenda Servicios (Beta)") || this.frmLlamador.equals("Agenda Urgencias - Hospitalizacion")) {
            Principal.claseenfer.cargarPantalla(this.frmLlamador);
        }
    }
}
