package Utilidades.tree;

import Acceso.Principal;
import Citas.clasesCita;
import Facturacion.claseFacturacion;
import General.AccesoModulos;
import GestionDoc.clasesGestionDoc;
import ParametrizacionN.claseParametrizacionN;
import Sgc.claseSgc;
import Sig.claseSig;
import com.genoma.plus.jpa.service.MenuParametrizacionService;
import com.genoma.plus.jpa.service.MenuSGCService;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.tree.DefaultMutableTreeNode;

/* JADX INFO: loaded from: GenomaP.jar:Utilidades/tree/PersistentRegionEditor.class */
public class PersistentRegionEditor implements ActionListener, KeyListener {
    private JPersistentTree tree;
    private JPersistentTree treeCal;
    private Principal xPrincipal;
    public JPersistentTree regTree;
    public JPersistentTree regTreeCal;
    private RegionStoreAdapter store;
    private RegionStoreAdapter storeCal;
    private String server;
    private String db;
    private String user;
    private String pw;
    private static final String APP_TITLE = "PersistentRegionEditor";
    private static final String BTN_TXT_ADD = "add";
    private static final String BTN_TXT_REMOVE = "remove";
    private static final String BTN_TXT_LICENSE = "License";
    private final MenuSGCService xMenuSGCService = (MenuSGCService) Principal.contexto.getBean(MenuSGCService.class);
    private final MenuParametrizacionService xMenuParametrizacionService = (MenuParametrizacionService) Principal.contexto.getBean(MenuParametrizacionService.class);
    private int id = 0;

    public PersistentRegionEditor(String server, String db, String user, String pw) {
        this.server = server;
        this.db = db;
        this.user = user;
        this.pw = pw;
    }

    public PersistentRegionEditor() {
        Principal.claseparametrizacionn = new claseParametrizacionN(this.xPrincipal);
        Principal.xclasesgc = new claseSgc();
        Principal.clasefacturacion = new claseFacturacion();
        Principal.xclasesig = new claseSig();
        Principal.clasescita = new clasesCita(this.xPrincipal);
        Principal.clasegestiondoc = new clasesGestionDoc();
    }

    private JPersistentTree getTree() {
        this.store = new RegionStoreAdapter("g_menu_conf", "g_usuario_sist_menu");
        this.tree = new JPersistentTree(this.store);
        this.tree.setShowsRootHandles(true);
        if (Principal.usuarioSistemaDTO.getTipoUsuario().intValue() == 2) {
            this.tree.setEditable(true);
        } else {
            this.tree.setEditable(false);
        }
        this.tree.setCellEditor(new UserTreeCellEditor(this.tree, this.tree.getCellRenderer()));
        NodeMoveTransferHandler handler = new NodeMoveTransferHandler();
        this.tree.setTransferHandler(handler);
        this.tree.setDropTarget(new TreeDropTarget(handler));
        this.tree.setDragEnabled(true);
        this.tree.addMouseListener(new MouseAdapter() { // from class: Utilidades.tree.PersistentRegionEditor.1
            public void mouseClicked(MouseEvent me) {
                PersistentRegionEditor.this.doMouseClicked(me);
            }
        });
        this.tree.addKeyListener(new KeyAdapter() { // from class: Utilidades.tree.PersistentRegionEditor.2
            public void keyPressed(KeyEvent ke) {
                PersistentRegionEditor.this.xkeyPressedParam(ke);
            }
        });
        return this.tree;
    }

    private JPersistentTree getTreeCalidad() {
        this.storeCal = new RegionStoreAdapter("g_menu_conf_cal", "g_usuario_sist_menu_cal");
        this.treeCal = new JPersistentTree(this.storeCal);
        this.treeCal.setShowsRootHandles(true);
        this.treeCal.setEditable(true);
        this.treeCal.setCellEditor(new UserTreeCellEditor(this.treeCal, this.treeCal.getCellRenderer()));
        NodeMoveTransferHandler handler = new NodeMoveTransferHandler();
        this.treeCal.setTransferHandler(handler);
        this.treeCal.setDropTarget(new TreeDropTarget(handler));
        this.treeCal.setDragEnabled(true);
        this.treeCal.addMouseListener(new MouseAdapter() { // from class: Utilidades.tree.PersistentRegionEditor.3
            public void mouseClicked(MouseEvent me) {
                PersistentRegionEditor.this.doMouseClickedCal(me);
            }
        });
        this.treeCal.addKeyListener(new KeyAdapter() { // from class: Utilidades.tree.PersistentRegionEditor.4
            public void keyPressed(KeyEvent ke) {
                PersistentRegionEditor.this.xkeyPressedCal(ke);
            }
        });
        return this.treeCal;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doMouseClicked(MouseEvent me) {
        DefaultMutableTreeNode nodo = (DefaultMutableTreeNode) this.tree.getLastSelectedPathComponent();
        if (nodo != null && me.getClickCount() == 2 && !nodo.getUserObject().toString().equals("Parametrización")) {
            if (nodo.getUserObject().toString().equals("Relación Laboral")) {
                Principal.claseparametrizacionn.cargarPantalla("Relación Laboral");
            } else if (nodo.getUserObject().toString().equals("Concepto")) {
                Principal.claseparametrizacionn.cargarPantalla("Concepto Caja");
            } else if (nodo.getUserObject().toString().equals("Tipo")) {
                Principal.claseparametrizacionn.cargarPantalla("Tipo Caja");
            } else if (nodo.getUserObject().toString().equals("Consultorio")) {
                Principal.claseparametrizacionn.cargarPantalla("Consultorio");
            } else if (nodo.getUserObject().toString().equals("MedioDePago")) {
                Principal.claseparametrizacionn.cargarPantalla("MedioDePago");
            } else if (nodo.getUserObject().toString().equals("Clase de Cita")) {
                Principal.claseparametrizacionn.cargarPantalla("Clase de Cita");
            } else if (nodo.getUserObject().toString().equals("Clase Consultorio")) {
                Principal.claseparametrizacionn.cargarPantalla("Clase Consultorio");
            } else if (nodo.getUserObject().toString().equals("Festivos")) {
                Principal.claseparametrizacionn.cargarPantalla("Festivos");
            } else if (nodo.getUserObject().toString().equals("Motivo Anulación Citas")) {
                Principal.claseparametrizacionn.cargarPantalla("Motivo Anulación Citas");
            } else if (nodo.getUserObject().toString().equals("Tipo Cita")) {
                Principal.claseparametrizacionn.cargarPantalla("Tipo Cita");
            } else if (nodo.getUserObject().toString().equals("Turnos")) {
                Principal.claseparametrizacionn.cargarPantalla("Turnos");
            } else if (nodo.getUserObject().toString().equals("Turnos_Nuevo")) {
                Principal.claseparametrizacionn.cargarPantalla("Turnos_Nuevo");
            } else if (nodo.getUserObject().toString().equals("Banco")) {
                Principal.claseparametrizacionn.cargarPantalla("Banco");
            } else if (nodo.getUserObject().toString().equals("Conceptos")) {
                Principal.claseparametrizacionn.cargarPantalla("Conceptos");
            } else if (nodo.getUserObject().toString().equals("Tipo de Cajas")) {
                Principal.claseparametrizacionn.cargarPantalla("Tipo de Cajas");
            } else if (nodo.getUserObject().toString().equals("Tipo Destino")) {
                Principal.claseparametrizacionn.cargarPantalla("Tipo Destino");
            } else if (nodo.getUserObject().toString().equals("Concepto")) {
                Principal.claseparametrizacionn.cargarPantalla("Concepto");
            } else if (nodo.getUserObject().toString().equals("Conceptos de Radicacion")) {
                Principal.claseparametrizacionn.cargarPantalla("Conceptos de Radicacion");
            } else if (nodo.getUserObject().toString().equals("Detalle Concepto")) {
                Principal.claseparametrizacionn.cargarPantalla("Detalle Concepto");
            } else if (nodo.getUserObject().toString().equals("Concepto Cuenta de Cobro")) {
                Principal.claseparametrizacionn.cargarPantalla("Concepto Cuenta de Cobro");
            } else if (nodo.getUserObject().toString().equals("Concepto Reembolso")) {
                Principal.claseparametrizacionn.cargarPantalla("Concepto Reembolso");
            } else if (nodo.getUserObject().toString().equals("Conceptos")) {
                Principal.claseparametrizacionn.cargarPantalla("Concepto Dian");
            } else if (nodo.getUserObject().toString().equals("Formatos")) {
                Principal.claseparametrizacionn.cargarPantalla("Formato Dian");
            } else if (nodo.getUserObject().toString().equals("Formato por conceptos")) {
                Principal.claseparametrizacionn.cargarPantalla("Formato x Concepto Dian");
            } else if (nodo.getUserObject().toString().equals("Documentos x Usuario Firmar")) {
                Principal.claseparametrizacionn.cargarPantalla("Documento x Usuario Firmar");
            } else if (nodo.getUserObject().toString().equals("Empresa")) {
                Principal.claseparametrizacionn.cargarPantalla("Empresa");
            } else if (nodo.getUserObject().toString().equals("Cuenta Contable x Concepto")) {
                Principal.claseparametrizacionn.cargarPantalla("Cuenta Contable x Concepto");
            } else if (nodo.getUserObject().toString().equals("Valorización")) {
                Principal.claseparametrizacionn.cargarPantalla("Valorización");
            } else if (nodo.getUserObject().toString().equals("Presupuesto PUC")) {
                Principal.claseparametrizacionn.cargarPantalla("Presupuesto Puc");
            } else if (nodo.getUserObject().toString().equals("Tipo Cuenta")) {
                Principal.claseparametrizacionn.cargarPantalla("Tipo Cuenta");
            } else if (nodo.getUserObject().toString().equals("Tipo Documento C")) {
                Principal.claseparametrizacionn.cargarPantalla("Tipo Documento C");
            } else if (nodo.getUserObject().toString().equals("Tipo de Empresa")) {
                Principal.claseparametrizacionn.cargarPantalla("Tipo de Empresa");
            } else if (nodo.getUserObject().toString().equals("Tipo Régimen")) {
                Principal.claseparametrizacionn.cargarPantalla("Tipo Régimen");
            } else if (nodo.getUserObject().toString().equals("Tipo Impuesto")) {
                Principal.claseparametrizacionn.cargarPantalla("Tipo Impuesto");
            } else if (nodo.getUserObject().toString().equals("Unidades Funcionales")) {
                Principal.claseparametrizacionn.cargarPantalla("Unidades Funcionales");
            } else if (nodo.getUserObject().toString().equals("Concepto Pago Glosa")) {
                Principal.claseparametrizacionn.cargarPantalla("Concepto Pago-Glosa");
            } else if (nodo.getUserObject().toString().equals("Empresa Contratante")) {
                Principal.claseparametrizacionn.cargarPantalla("Empresa", "Empresa Contratante");
            } else if (nodo.getUserObject().toString().equals("Estrato")) {
                Principal.claseparametrizacionn.cargarPantalla("Estrato");
            } else if (nodo.getUserObject().toString().equals("Incremento, Decremento o Aumento de tarifas ")) {
                Principal.claseparametrizacionn.cargarPantalla("Incremento, Decremento o Aumento de Tarifas");
            } else if (nodo.getUserObject().toString().equals("Manual de Tarifas")) {
                Principal.claseparametrizacionn.cargarPantalla("Manual de Tarifas");
            } else if (nodo.getUserObject().toString().equals("Tipo de Plan")) {
                Principal.claseparametrizacionn.cargarPantalla("Tipo de Plan");
            } else if (nodo.getUserObject().toString().equals("Tipo de Régimen")) {
                Principal.claseparametrizacionn.cargarPantalla("Tipo de Régimen");
            } else if (nodo.getUserObject().toString().equals("Grupo Factura")) {
                Principal.claseparametrizacionn.cargarPantalla("Grupo Factura");
            } else if (nodo.getUserObject().toString().equals("Procedimiento")) {
                Principal.claseparametrizacionn.cargarPantalla("Procedimiento");
            } else if (nodo.getUserObject().toString().equals("Procedimiento x Tipo deServicio ")) {
                Principal.claseparametrizacionn.cargarPantalla("Procedimiento x Tipo de Servicio");
            } else if (nodo.getUserObject().toString().equals("Tipo de Procedimiento")) {
                Principal.claseparametrizacionn.cargarPantalla("Tipo de Procedimiento");
            } else if (nodo.getUserObject().toString().equals("Tipo de Servicio")) {
                Principal.claseparametrizacionn.cargarPantalla("Tipo de Servicio");
            } else if (nodo.getUserObject().toString().equals("SubGrupo Factura")) {
                Principal.claseparametrizacionn.cargarPantalla("Sub Grupo Factura");
            } else if (nodo.getUserObject().toString().equals("Suministro")) {
                Principal.claseparametrizacionn.cargarPantalla("Suministro");
            } else if (nodo.getUserObject().toString().equals("Tipo de Medicamento")) {
                Principal.claseparametrizacionn.cargarPantalla("Tipo de Medicamento");
            } else if (nodo.getUserObject().toString().equals("Listado de Facturas armadas x Empresa")) {
                Principal.claseparametrizacionn.cargarPantalla("Listado de Facturas Armadas x Empresa");
            } else if (nodo.getUserObject().toString().equals("Listado de Facturas x Empresa")) {
                Principal.claseparametrizacionn.cargarPantalla("Listado de Facturas x Empresa");
            } else if (nodo.getUserObject().toString().equals("Reliquidación de Orden o Factura ")) {
                Principal.claseparametrizacionn.cargarPantalla("Reeliquidación de Orden o Factura");
            } else if (nodo.getUserObject().toString().equals("Grupo Equipo")) {
                Principal.claseparametrizacionn.cargarPantalla("Grupo Equipo");
            } else if (nodo.getUserObject().toString().equals("Categoría")) {
                Principal.claseparametrizacionn.cargarPantalla("Categorias Activo");
            } else if (nodo.getUserObject().toString().equals("Marca")) {
                Principal.claseparametrizacionn.cargarPantalla("Marca Activo");
            } else if (nodo.getUserObject().toString().equals("Motivo de Traslado")) {
                Principal.claseparametrizacionn.cargarPantalla("Motivo de Traslado");
            } else if (nodo.getUserObject().toString().equals("Ubicación")) {
                Principal.claseparametrizacionn.cargarPantalla("Ubicacion");
            } else if (nodo.getUserObject().toString().equals("Aeropuertos")) {
                Principal.claseparametrizacionn.cargarPantalla("Aeropuertos");
            } else if (nodo.getUserObject().toString().equals("Alerta por Usuario")) {
                Principal.claseparametrizacionn.cargarPantalla("Alerta x Usuario");
            } else if (nodo.getUserObject().toString().equals("Concepto Anticipo")) {
                Principal.claseparametrizacionn.cargarPantalla("Concepto Anticipo");
            } else if (nodo.getUserObject().toString().equals("Concepto x Detalle")) {
                Principal.claseparametrizacionn.cargarPantalla("Concepto x Detalle Anticipo");
            } else if (nodo.getUserObject().toString().equals("Detalle Concepto")) {
                Principal.claseparametrizacionn.cargarPantalla("Detalle Concepto Anticipo");
            } else if (nodo.getUserObject().toString().equals("Tipo Anticipo")) {
                Principal.claseparametrizacionn.cargarPantalla("Tipo Anticipo");
            } else if (nodo.getUserObject().toString().equals("Areas")) {
                Principal.claseparametrizacionn.cargarPantalla("Areas");
            } else if (nodo.getUserObject().toString().equals("Barrio")) {
                Principal.claseparametrizacionn.cargarPantalla("Barrio");
            } else if (nodo.getUserObject().toString().equals("Condiciones")) {
                Principal.claseparametrizacionn.cargarPantalla("Condiciones");
            } else if (nodo.getUserObject().toString().equals("Datos Ips")) {
                Principal.claseparametrizacionn.cargarPantalla("Datos Ips");
            } else if (nodo.getUserObject().toString().equals("Departamento")) {
                Principal.claseparametrizacionn.cargarPantalla("Departamento");
            } else if (nodo.getUserObject().toString().equals("Asignación")) {
                Principal.claseparametrizacionn.cargarPantalla("Asignación x Encuesta");
            } else if (nodo.getUserObject().toString().equals("Nombre")) {
                Principal.claseparametrizacionn.cargarPantalla("Nombre Encuesta");
            } else if (nodo.getUserObject().toString().equals("Preguntas")) {
                Principal.claseparametrizacionn.cargarPantalla("Preguntas");
            } else if (nodo.getUserObject().toString().equals("Preguntas por Encuesta")) {
                Principal.claseparametrizacionn.cargarPantalla("Pregunta x Encuesta");
            } else if (nodo.getUserObject().toString().equals("Tipo Respuesta")) {
                Principal.claseparametrizacionn.cargarPantalla("Tipo de Respuesta");
            } else if (nodo.getUserObject().toString().equals("Entidad a Reportar")) {
                Principal.claseparametrizacionn.cargarPantalla("Entidad");
            } else if (nodo.getUserObject().toString().equals("Especialidad")) {
                Principal.claseparametrizacionn.cargarPantalla("Especialidad");
            } else if (nodo.getUserObject().toString().equals("Causa de Daño")) {
                Principal.claseparametrizacionn.cargarPantalla("Causa de Daño");
            } else if (nodo.getUserObject().toString().equals("Tipo Placa")) {
                Principal.claseparametrizacionn.cargarPantalla("Tipo Placa");
            } else if (nodo.getUserObject().toString().equals("Manuales GenomaPlus")) {
                Principal.claseparametrizacionn.cargarPantalla("Manuales");
            } else if (nodo.getUserObject().toString().equals("Motivo de Anulación")) {
                Principal.claseparametrizacionn.cargarPantalla("Motivo de Anulación");
            } else if (nodo.getUserObject().toString().equals("Municipio")) {
                Principal.claseparametrizacionn.cargarPantalla("Municipio");
            } else if (nodo.getUserObject().toString().equals("Nivel de Estudio")) {
                Principal.claseparametrizacionn.cargarPantalla("Nivel de Estudio");
            } else if (nodo.getUserObject().toString().equals("Ocupación")) {
                Principal.claseparametrizacionn.cargarPantalla("Ocupación");
            } else if (nodo.getUserObject().toString().equals("Patología CIE10")) {
                Principal.claseparametrizacionn.cargarPantalla("Patología Cie10");
            } else if (nodo.getUserObject().toString().equals("Profesional")) {
                Principal.claseparametrizacionn.cargarPantalla("Profesional");
            } else if (nodo.getUserObject().toString().equals("Cargos")) {
                Principal.claseparametrizacionn.cargarPantalla("Cargos SO");
            } else if (nodo.getUserObject().toString().equals("Elementos PP")) {
                Principal.claseparametrizacionn.cargarPantalla("Elementos PP");
            } else if (nodo.getUserObject().toString().equals("Partes Examinar")) {
                Principal.claseparametrizacionn.cargarPantalla("Partes Examinar");
            } else if (nodo.getUserObject().toString().equals("Peligros")) {
                Principal.claseparametrizacionn.cargarPantalla("Peligros SO");
            } else if (nodo.getUserObject().toString().equals("Turnos")) {
                Principal.claseparametrizacionn.cargarPantalla("Turnos SO");
            } else if (nodo.getUserObject().toString().equals("Caracteristicas")) {
                Principal.claseparametrizacionn.cargarPantalla("Caracteristicas Sgc");
            } else if (nodo.getUserObject().toString().equals("Detalle de Incumplimiento")) {
                Principal.claseparametrizacionn.cargarPantalla("Detalle de Incumplimiento");
            } else if (nodo.getUserObject().toString().equals("Glorasio")) {
                Principal.claseparametrizacionn.cargarPantalla("Glosario");
            } else if (nodo.getUserObject().toString().equals("Incumplimiento")) {
                Principal.claseparametrizacionn.cargarPantalla("Incumplimiento");
            } else if (nodo.getUserObject().toString().equals("Ficha Técnica")) {
                Principal.claseparametrizacionn.cargarPantalla("Ficha Técnica Indicador SGC");
            } else if (nodo.getUserObject().toString().equals("Tipo Indicador")) {
                Principal.claseparametrizacionn.cargarPantalla("Tipo Indicador Sgc");
            } else if (nodo.getUserObject().toString().equals("Unidad de Medida SGC")) {
                Principal.claseparametrizacionn.cargarPantalla("Unidad Medida Sgc");
            } else if (nodo.getUserObject().toString().equals("Origen No Conformidad")) {
                Principal.claseparametrizacionn.cargarPantalla("Origen No Conformidad");
            } else if (nodo.getUserObject().toString().equals("Proceso")) {
                Principal.claseparametrizacionn.cargarPantalla("Proceso Sgc");
            } else if (nodo.getUserObject().toString().equals("Tipo Acción")) {
                Principal.claseparametrizacionn.cargarPantalla("Tipo de Acción");
            } else if (nodo.getUserObject().toString().equals("Tipo No Conformidad")) {
                Principal.claseparametrizacionn.cargarPantalla("Tipo No Conformidad");
            } else if (nodo.getUserObject().toString().equals("Tipo Proceso")) {
                Principal.claseparametrizacionn.cargarPantalla("Tipo Proceso Sgc");
            } else if (nodo.getUserObject().toString().equals("Actividad")) {
                Principal.claseparametrizacionn.cargarPantalla("Actividad Solicitud");
            } else if (nodo.getUserObject().toString().equals("Tipo Solicitud")) {
                Principal.claseparametrizacionn.cargarPantalla("Tipo Solicitud");
            } else if (nodo.getUserObject().toString().equals("Tipo Actividad x Proceso ")) {
                Principal.claseparametrizacionn.cargarPantalla("Tipo Actividad x Proceso");
            } else if (nodo.getUserObject().toString().equals("Supervisor")) {
                Principal.claseparametrizacionn.cargarPantalla("Supervisor");
            } else if (nodo.getUserObject().toString().equals("Unidad de Negocio")) {
                Principal.claseparametrizacionn.cargarPantalla("Unidad de Negocio");
            } else if (nodo.getUserObject().toString().equals("Usuario Sistema")) {
                Principal.claseparametrizacionn.cargarPantalla("jifusuariosistemas");
            } else if (nodo.getUserObject().toString().equals("Utilidades")) {
                Principal.claseparametrizacionn.cargarPantalla("Utilidades");
            } else if (nodo.getUserObject().toString().equals("Antecedentes Patológicos ")) {
                Principal.claseparametrizacionn.cargarPantalla("Antecedentes Patológicos");
            } else if (nodo.getUserObject().toString().equals("Partes a Examinar")) {
                Principal.claseparametrizacionn.cargarPantalla("Ecografía");
            } else if (nodo.getUserObject().toString().equals("Partes x Tipo Ecografía")) {
                Principal.claseparametrizacionn.cargarPantalla("Partes x Tipo de Ecografía");
            } else if (nodo.getUserObject().toString().equals("Tipo de Fórmula")) {
                Principal.claseparametrizacionn.cargarPantalla("Tipo de Formula");
            } else if (nodo.getUserObject().toString().equals("Contenido")) {
                Principal.claseparametrizacionn.cargarPantalla("Contenido HC");
            } else if (nodo.getUserObject().toString().equals("Detalle Contenido")) {
                Principal.claseparametrizacionn.cargarPantalla("Detalle Contenido HC");
            } else if (nodo.getUserObject().toString().equals("Tipo HC")) {
                Principal.claseparametrizacionn.cargarPantalla("Tipo HC");
            } else if (nodo.getUserObject().toString().equals("Tipo Detalle Exámen Físico")) {
                Principal.claseparametrizacionn.cargarPantalla("Tipo Detalle Exámen Físico");
            } else if (nodo.getUserObject().toString().equals("Tipo Exámen")) {
                Principal.claseparametrizacionn.cargarPantalla("Tipo Exámen Físico");
            } else if (nodo.getUserObject().toString().equals("Interracciones Medicamentosas")) {
                Principal.claseparametrizacionn.cargarPantalla("Interraciones Medicamentosas");
            } else if (nodo.getUserObject().toString().equals("Patología Reporte")) {
                Principal.claseparametrizacionn.cargarPantalla("Patología Reporte");
            } else if (nodo.getUserObject().toString().equals("Actividad Física")) {
                Principal.claseparametrizacionn.cargarPantalla("Actividad Física");
            } else if (nodo.getUserObject().toString().equals("Tipo de Actividad Física")) {
                Principal.claseparametrizacionn.cargarPantalla("Tipo Actividad Física");
            } else if (nodo.getUserObject().toString().equals("Tipo de Ejercicio")) {
                Principal.claseparametrizacionn.cargarPantalla("Tipo de Ejercicio");
            } else if (nodo.getUserObject().toString().equals("Concepto Específico")) {
                Principal.claseparametrizacionn.cargarPantalla("Concepto Específico");
            } else if (nodo.getUserObject().toString().equals("Encabezado Preguntas")) {
                Principal.claseparametrizacionn.cargarPantalla("Encabezado Preguntas");
            } else if (nodo.getUserObject().toString().equals("Encabezado Recomendaciones")) {
                Principal.claseparametrizacionn.cargarPantalla("Encabezado Recomendaciones");
            } else if (nodo.getUserObject().toString().equals("Detalle Preguntas")) {
                Principal.claseparametrizacionn.cargarPantalla("Detalle Preguntas So");
            } else if (nodo.getUserObject().toString().equals("Grupo Turnos")) {
                Principal.claseparametrizacionn.cargarPantalla("Grupo Turnos");
            } else if (nodo.getUserObject().toString().equals("Motivo Prueba")) {
                Principal.claseparametrizacionn.cargarPantalla("Motivo Prueba");
            } else if (nodo.getUserObject().toString().equals("Recomendaciones")) {
                Principal.claseparametrizacionn.cargarPantalla("Recomendaciones");
            } else if (nodo.getUserObject().toString().equals("Subcategoria Peligros")) {
                Principal.claseparametrizacionn.cargarPantalla("Subcategoria Peligros");
            } else if (nodo.getUserObject().toString().equals("SEG")) {
                Principal.claseparametrizacionn.cargarPantalla("SEG");
            } else if (nodo.getUserObject().toString().equals("Tipo Concepto")) {
                Principal.claseparametrizacionn.cargarPantalla("Tipo de Concepto");
            } else if (nodo.getUserObject().toString().equals("Tipo Cuestionario")) {
                Principal.claseparametrizacionn.cargarPantalla("Tipo Cuestionario");
            } else if (nodo.getUserObject().toString().equals("Tipo Restricción")) {
                Principal.claseparametrizacionn.cargarPantalla("Tipo Restricción");
            } else if (nodo.getUserObject().toString().equals("Tipo Subcategoría")) {
                Principal.claseparametrizacionn.cargarPantalla("Tipo Subcategoria");
            } else if (nodo.getUserObject().toString().equals("Tipo Sustancia")) {
                Principal.claseparametrizacionn.cargarPantalla("Tipo Sustancia");
            } else if (nodo.getUserObject().toString().equals("Tipo Vinculación")) {
                Principal.claseparametrizacionn.cargarPantalla("Tipo Vinculación");
            } else if (nodo.getUserObject().toString().equals("Escala de Dolor")) {
                Principal.claseparametrizacionn.cargarPantalla("Escala del Dolor");
            } else if (nodo.getUserObject().toString().equals("Segmentos")) {
                Principal.claseparametrizacionn.cargarPantalla("Segmentos");
            } else if (nodo.getUserObject().toString().equals("Segmento x Encabezado")) {
                Principal.claseparametrizacionn.cargarPantalla("Segmento x Encabezado");
            } else if (nodo.getUserObject().toString().equals("Tipo de Dolor")) {
                Principal.claseparametrizacionn.cargarPantalla("Tipo de Dolor");
            } else if (nodo.getUserObject().toString().equals("Dimensión")) {
                Principal.claseparametrizacionn.cargarPantalla("Dimensión");
            } else if (nodo.getUserObject().toString().equals("Dominio")) {
                Principal.claseparametrizacionn.cargarPantalla("Dominio");
            } else if (nodo.getUserObject().toString().equals("Preguntas x Subcategoría")) {
                Principal.claseparametrizacionn.cargarPantalla("Preguntas x Subcategoria");
            } else if (nodo.getUserObject().toString().equals("Tipo de Preguntas")) {
                Principal.claseparametrizacionn.cargarPantalla("Tipo de Preguntas");
            } else if (nodo.getUserObject().toString().equals("Tipo de Respuestas")) {
                Principal.claseparametrizacionn.cargarPantalla("Tipo Respuesta");
            } else if (nodo.getUserObject().toString().equals("Tipo de pregunta x Respuesta")) {
                Principal.claseparametrizacionn.cargarPantalla("Tipo pregunta x Respuesta");
            } else if (nodo.getUserObject().toString().equals("Corrección")) {
                Principal.claseparametrizacionn.cargarPantalla("Correción");
            } else if (nodo.getUserObject().toString().equals("Resultado de Visiometría")) {
                Principal.claseparametrizacionn.cargarPantalla("Resultado Visiometría");
            } else if (nodo.getUserObject().toString().equals("Tipos de DocumentosHC")) {
                Principal.claseparametrizacionn.cargarPantalla("Tipo de DocumentosHC");
            } else if (nodo.getUserObject().toString().equals("Tipo de Doc Ayudas DX")) {
                Principal.claseparametrizacionn.cargarPantalla("Tipo de Doc Ayudas DX");
            } else if (nodo.getUserObject().toString().equals("Tipo de Nota")) {
                Principal.claseparametrizacionn.cargarPantalla("Tipo de Nota");
            } else if (nodo.getUserObject().toString().equals("Bodegas")) {
                Principal.claseparametrizacionn.cargarPantalla("Bodegas");
            } else if (nodo.getUserObject().toString().equals("Clasificación")) {
                Principal.claseparametrizacionn.cargarPantalla("Clasificación");
            } else if (nodo.getUserObject().toString().equals("Forma Farmacéutica")) {
                Principal.claseparametrizacionn.cargarPantalla("Forma Farmacéutica");
            } else if (nodo.getUserObject().toString().equals("Registro de Novedad")) {
                Principal.claseparametrizacionn.cargarPantalla("Registro de Novedad");
            } else if (nodo.getUserObject().toString().equals("Tipo Novedad")) {
                Principal.claseparametrizacionn.cargarPantalla("Tipo de Novedad");
            } else if (nodo.getUserObject().toString().equals("Suministro Inventario")) {
                Principal.claseparametrizacionn.cargarPantalla("Suministro");
            } else if (nodo.getUserObject().toString().equals("Horarios Medición")) {
                Principal.claseparametrizacionn.cargarPantalla("Horarios Medición");
            } else if (nodo.getUserObject().toString().equals("Tipo Medición")) {
                Principal.claseparametrizacionn.cargarPantalla("Tipo Medición");
            } else if (nodo.getUserObject().toString().equals("Componentes")) {
                Principal.claseparametrizacion.cargarPantalla("Componentes", "");
            } else if (nodo.getUserObject().toString().equals("Frecuencias Procedimientos")) {
                Principal.claseparametrizacion.cargarPantalla("Frecuencias Procedimientos", "");
            } else if (nodo.getUserObject().toString().equals("Laboratorio")) {
                Principal.claseparametrizacion.cargarPantalla("Laboratorio", "");
            } else if (nodo.getUserObject().toString().equals("Manuales")) {
                Principal.claseparametrizacion.cargarPantalla("Manuales", "");
            } else if (nodo.getUserObject().toString().equals("Normalidad")) {
                Principal.claseparametrizacion.cargarPantalla("Normalidad", "");
            } else if (nodo.getUserObject().toString().equals("Procedimientos")) {
                Principal.claseparametrizacion.cargarPantalla("Procedimientos", "");
            } else if (nodo.getUserObject().toString().equals("Registro Técnico")) {
                Principal.claseparametrizacion.cargarPantalla("Registro Tecnico", "");
            } else if (nodo.getUserObject().toString().equals("Repuestos")) {
                Principal.claseparametrizacion.cargarPantalla("Repuestos", "");
            } else if (nodo.getUserObject().toString().equals("Servicios")) {
                Principal.claseparametrizacion.cargarPantalla("Servicios", "");
            } else if (nodo.getUserObject().toString().equals("Contenido Odon")) {
                Principal.claseparametrizacionn.cargarPantalla("Contenido HC Odontologica");
            } else if (nodo.getUserObject().toString().equals("Detalle Contenido H")) {
                Principal.claseparametrizacionn.cargarPantalla("Detalle Contenido HC Odontologica");
            } else if (nodo.getUserObject().toString().equals("Diagnóstico")) {
                Principal.claseparametrizacionn.cargarPantalla("Diagnóstico Odontológicos");
            } else if (nodo.getUserObject().toString().equals("Parámetros")) {
                Principal.claseparametrizacionn.cargarPantalla("Parametro");
            } else if (nodo.getUserObject().toString().equals("Demanda Inducida")) {
                Principal.claseparametrizacionn.cargarPantalla("Demanda Inducida");
            } else if (nodo.getUserObject().toString().equals("Tipo Programa")) {
                Principal.claseparametrizacionn.cargarPantalla("Tipo de Programa");
            } else if (nodo.getUserObject().toString().equals("Dosis Vacunas")) {
                Principal.claseparametrizacionn.cargarPantalla("Dosis Vacunas");
            } else if (nodo.getUserObject().toString().equals("Vacunas")) {
                Principal.claseparametrizacionn.cargarPantalla("Vacunas");
            } else if (nodo.getUserObject().toString().equals("Vacunas x Edad")) {
                Principal.claseparametrizacionn.cargarPantalla("Vacunas x Edad");
            } else if (nodo.getUserObject().toString().equals("Vacunas x Esquema")) {
                Principal.claseparametrizacionn.cargarPantalla("Vacunación x Esquema");
            } else if (nodo.getUserObject().toString().equals("Escala Abreviada de Desarrollo")) {
                Principal.claseparametrizacionn.cargarPantalla("Escala CyD");
            } else if (nodo.getUserObject().toString().equals("Preguntas CyD")) {
                Principal.claseparametrizacionn.cargarPantalla("Preguntas CyD");
            } else if (nodo.getUserObject().toString().equals("Preguntas x Categoría")) {
                Principal.claseparametrizacionn.cargarPantalla("Preguntas x Categoría");
            } else if (nodo.getUserObject().toString().equals("Cargo")) {
                Principal.claseparametrizacionn.cargarPantalla("Cargo");
            } else if (nodo.getUserObject().toString().equals("Cargo x Usuario")) {
                Principal.claseparametrizacionn.cargarPantalla("Cargo x Usuario");
            } else if (nodo.getUserObject().toString().equals("Concepto Anticipo RH")) {
                Principal.claseparametrizacionn.cargarPantalla("Concepto Anticipo");
            } else if (nodo.getUserObject().toString().equals("Concepto Nómina")) {
                Principal.claseparametrizacionn.cargarPantalla("Concepto Nomina");
            } else if (nodo.getUserObject().toString().equals("Novedades")) {
                Principal.claseparametrizacionn.cargarPantalla("Novedades Nomina");
            } else if (nodo.getUserObject().toString().equals("Unidad Funcional")) {
                Principal.claseparametrizacionn.cargarPantalla("Unidad Funcional");
            } else if (nodo.getUserObject().toString().equals("Sala de Cirugía")) {
                Principal.claseparametrizacionn.cargarPantalla("Sala de Cirugia");
            } else if (nodo.getUserObject().toString().equals("Profesional Sala Cirugía")) {
                Principal.claseparametrizacionn.cargarPantalla("Profesional Sala Cirugia");
            } else if (nodo.getUserObject().toString().equals("Configuración Agenda Quirófano")) {
                Principal.claseparametrizacionn.cargarPantalla("Configuración Agenda Quirófano");
            } else if (nodo.getUserObject().toString().equals("Tipo de Sala")) {
                Principal.claseparametrizacionn.cargarPantalla("Tipo Sala");
            } else if (nodo.getUserObject().toString().equals("GrupoUvr")) {
                Principal.claseparametrizacionn.cargarPantalla("GrupoVr");
            } else if (nodo.getUserObject().toString().equals("Excepción")) {
                Principal.claseparametrizacionn.cargarPantalla("Excepción");
            } else if (nodo.getUserObject().toString().equals("Procedimiento Tipo Manual Qx")) {
                Principal.claseparametrizacionn.cargarPantalla("ProcedimientoTipoQx");
            } else if (nodo.getUserObject().toString().equals("Centro de Costo")) {
                Principal.claseparametrizacionn.cargarPantalla("Centro de Costo");
            } else if (nodo.getUserObject().toString().equals("Camas")) {
                Principal.claseparametrizacionn.cargarPantalla("Camas");
            } else if (nodo.getUserObject().toString().equals("Unidad Camas")) {
                Principal.claseparametrizacionn.cargarPantalla("Unidad Camas");
            } else if (nodo.getUserObject().toString().equals("Grupo Sistema")) {
                Principal.claseparametrizacionn.cargarPantalla("Grupo Sistema");
            } else if (nodo.getUserObject().toString().equals("Tipo Alerta")) {
                Principal.claseparametrizacionn.cargarPantalla("Tipo Alerta");
            } else if (nodo.getUserObject().toString().equals("Tipo de Periodos Cartera")) {
                Principal.claseparametrizacionn.cargarPantalla("Tipo de Periodos Cartera");
            } else if (nodo.getUserObject().toString().equals("Tipo de Parto")) {
                Principal.claseparametrizacionn.cargarPantalla("Tipo de Parto");
            } else if (nodo.getUserObject().toString().equals("Tipo de Cita Prioritaria")) {
                Principal.claseparametrizacionn.cargarPantalla("Tipo de Cita Prioritaria");
            } else if (nodo.getUserObject().toString().equals("Tipo de Atencion")) {
                Principal.claseparametrizacionn.cargarPantalla("Tipo de Atencion");
            } else if (nodo.getUserObject().toString().equals("Procedimiento x Prioridad")) {
                Principal.claseparametrizacionn.cargarPantalla("Procedimiento x Prioridad");
            } else if (nodo.getUserObject().toString().equals("Población Especial")) {
                Principal.claseparametrizacionn.cargarPantalla("Población Especial");
            } else if (nodo.getUserObject().toString().equals("Tipo Anestesia")) {
                Principal.claseparametrizacionn.cargarPantalla("Tipo Anestesia");
            } else if (nodo.getUserObject().toString().equals("Tipo Sistema")) {
                Principal.claseparametrizacionn.cargarPantalla("Tipo Sistema");
            } else if (nodo.getUserObject().toString().equals("Tipo Destino Salida")) {
                Principal.claseparametrizacionn.cargarPantalla("Tipo Destido Salida");
            } else if (nodo.getUserObject().toString().equals("Tipo Concepto Agrupado")) {
                Principal.claseparametrizacionn.cargarPantalla("Tipo Concepto Agrupado");
            } else if (nodo.getUserObject().toString().equals("Estado Civil")) {
                Principal.claseparametrizacionn.cargarPantalla("Estado Civil");
            } else if (nodo.getUserObject().toString().equals("Parentesco")) {
                Principal.claseparametrizacionn.cargarPantalla("Parentesco");
            } else if (nodo.getUserObject().toString().equals("Clasificacion de Respuesta")) {
                Principal.claseparametrizacionn.cargarPantalla("Clasificacion de Respuesta");
            } else if (nodo.getUserObject().toString().equals("Tipo de Registro")) {
                Principal.claseparametrizacionn.cargarPantalla("Tipo de Registro");
            } else if (nodo.getUserObject().toString().equals("Sitio Ocurrencia")) {
                Principal.claseparametrizacionn.cargarPantalla("Sitio Ocurrencia");
            } else if (nodo.getUserObject().toString().equals("Encuesta Tipo de Respuesta")) {
                Principal.claseparametrizacionn.cargarPantalla("Encuesta Tipo de Respuesta");
            } else if (nodo.getUserObject().toString().equals("Encuesta Pregunta por Area")) {
                Principal.claseparametrizacionn.cargarPantalla("Encuesta Pregunta por Area");
            } else if (nodo.getUserObject().toString().equals("Causa Externa")) {
                Principal.claseparametrizacionn.cargarPantalla("Causa Externa");
            } else if (nodo.getUserObject().toString().equals("Estadio Glomerural")) {
                Principal.claseparametrizacionn.cargarPantalla("Estadio Glomerural");
            } else if (nodo.getUserObject().toString().equals("Medio Recepción")) {
                Principal.claseparametrizacionn.cargarPantalla("Medio Recepción");
            } else if (nodo.getUserObject().toString().equals("Periocidad")) {
                Principal.claseparametrizacionn.cargarPantalla("Periocidad");
            } else if (nodo.getUserObject().toString().equals("Frecuencias")) {
                Principal.claseparametrizacionn.cargarPantalla("Frecuencias");
            } else if (nodo.getUserObject().toString().equals("Etapa Proceso")) {
                Principal.claseparametrizacionn.cargarPantalla("Etapa Proceso");
            } else if (nodo.getUserObject().toString().equals("Horario de Farmacia")) {
                Principal.claseparametrizacionn.cargarPantalla("Horario de Farmacia");
            } else if (nodo.getUserObject().toString().equals("Tipo Afiliado")) {
                Principal.claseparametrizacionn.cargarPantalla("Tipo Afiliado");
            } else if (nodo.getUserObject().toString().equals("Tipo Prioridad")) {
                Principal.claseparametrizacionn.cargarPantalla("Tipo Prioridad");
            } else if (nodo.getUserObject().toString().equals("Periodos de Nómina")) {
                Principal.claseparametrizacionn.cargarPantalla("Periodos de Nómina");
            } else if (nodo.getUserObject().toString().equals("Tipo Edad")) {
                Principal.claseparametrizacionn.cargarPantalla("Tipo Edad");
            } else if (nodo.getUserObject().toString().equals("Tipo Ambito")) {
                Principal.claseparametrizacionn.cargarPantalla("Tipo Ambito");
            } else if (nodo.getUserObject().toString().equals("Tipo Población")) {
                Principal.claseparametrizacionn.cargarPantalla("Tipo Población");
            } else if (nodo.getUserObject().toString().equals("Tipo Manual Tarifas")) {
                Principal.claseparametrizacionn.cargarPantalla("Tipo Manual Tarifas");
            } else if (nodo.getUserObject().toString().equals("Tipo Etnia")) {
                Principal.claseparametrizacionn.cargarPantalla("Tipo Etnia");
            } else if (nodo.getUserObject().toString().equals("Tipo División")) {
                Principal.claseparametrizacionn.cargarPantalla("Tipo División");
            } else if (nodo.getUserObject().toString().equals("Tipo Descuento")) {
                Principal.claseparametrizacionn.cargarPantalla("Tipo Descuento");
            } else if (nodo.getUserObject().toString().equals("Rubros")) {
                Principal.claseparametrizacionn.cargarPantalla("Rubros");
            } else if (nodo.getUserObject().toString().equals("Maestro Rubros")) {
                Principal.claseparametrizacionn.cargarPantalla("Maestro Rubros");
            } else if (nodo.getUserObject().toString().equals("Periodo")) {
                Principal.claseparametrizacionn.cargarPantalla("Periodo");
            } else if (nodo.getUserObject().toString().equals("Tipo Documento Presupuesto")) {
                Principal.claseparametrizacionn.cargarPantalla("Tipo Documento Presupuesto");
            } else if (nodo.getUserObject().toString().equals("Documento Tercero Firma")) {
                Principal.claseparametrizacionn.cargarPantalla("Documento Tercero Firma");
            } else if (nodo.getUserObject().toString().equals("Rubro x Tipo Documento")) {
                Principal.claseparametrizacionn.cargarPantalla("Rubro x Tipo Documento");
            } else if (nodo.getUserObject().toString().equals("Tipo Documentos")) {
                Principal.claseparametrizacionn.cargarPantalla("Tipo Documentos");
            } else if (nodo.getUserObject().toString().equals("Resoluciones Presupuesto")) {
                Principal.claseparametrizacionn.cargarPantalla("Resoluciones Presupuesto");
            } else if (nodo.getUserObject().toString().equals("Tipo Parentesco")) {
                Principal.claseparametrizacionn.cargarPantalla("Tipo Parentesco");
            } else if (nodo.getUserObject().toString().equals("Códigos alternos Rubros")) {
                Principal.claseparametrizacionn.cargarPantalla("Codigos alternos Rubros");
            } else if (nodo.getUserObject().toString().equals("Histórico Salario Mínimo")) {
                Principal.claseparametrizacionn.cargarPantalla("Histórico Salario Mínimo");
            } else if (nodo.getUserObject().toString().equals("Actualizar Año Servicios Empresa Convenio")) {
                Principal.clasefacturacion.cargarPantalla("Actualizar Año Servicios Empresa Convenio");
            } else if (nodo.getUserObject().toString().equals("Concepto de Estudio Citologico")) {
                Principal.claseparametrizacionn.cargarPantalla("Concepto de Estudio Citologico");
            } else if (nodo.getUserObject().toString().equals("Muestra Citologia")) {
                Principal.claseparametrizacionn.cargarPantalla("Muestra Citologia");
            } else if (nodo.getUserObject().toString().equals("Tipo Seguimiento")) {
                Principal.claseparametrizacionn.cargarPantalla("Tipo Seguimiento");
            } else if (nodo.getUserObject().toString().equals("Citologia Tipo De  Estudios")) {
                Principal.claseparametrizacionn.cargarPantalla("Citologia Tipo De  Estudios");
            } else if (nodo.getUserObject().toString().equals("Tipo de Clasificacion")) {
                Principal.claseparametrizacionn.cargarPantalla("Tipo de Clasificacion");
            } else if (nodo.getUserObject().toString().equals("Categoria")) {
                Principal.claseparametrizacionn.cargarPantalla("Categoria");
            } else if (nodo.getUserObject().toString().equals("Tipo De Contrato")) {
                Principal.claseparametrizacionn.cargarPantalla("Tipo De Contrato");
            } else if (nodo.getUserObject().toString().equals("Clasificación Concepto Nómina")) {
                Principal.claseparametrizacionn.cargarPantalla("Clasif Concepto Nomina");
            } else if (nodo.getUserObject().toString().equals("Cod Resolucion Rubro")) {
                Principal.claseparametrizacionn.cargarPantalla("Cod Resolucion Rubro");
            } else if (nodo.getUserObject().toString().equals("Consulta Deducciones por Conceptos")) {
                Principal.claseparametrizacionn.cargarPantalla("Consulta Deducciones por Conceptos");
            } else if (nodo.getUserObject().toString().equals("Unificar Usuario Duplicado")) {
                Principal.claseparametrizacionn.cargarPantalla("Unificar Usuario Duplicado");
            } else if (nodo.getUserObject().toString().equals("Tipo de Consecuencia - Acciones")) {
                Principal.claseparametrizacionn.cargarPantalla("Tipo de Consecuencia - Acciones");
            } else if (nodo.getUserObject().toString().equals("Tipo Sexo")) {
                Principal.claseparametrizacionn.cargarPantalla("Tipo Sexo");
            } else if (nodo.getUserObject().toString().equals("Nombre Del Evento")) {
                Principal.claseparametrizacionn.cargarPantalla("Nombre Del Evento");
            } else if (nodo.getUserObject().toString().equals("Riesgo Seguridad Clinica")) {
                Principal.claseparametrizacionn.cargarPantalla("Riesgo seguridad Clínica");
            } else if (nodo.getUserObject().toString().equals("Tipo De Causa Analisis")) {
                Principal.claseparametrizacionn.cargarPantalla("Tipo De Causa Analisis");
            } else if (nodo.getUserObject().toString().equals("Tipo Clasificacion De Riesgo Adverso")) {
                Principal.claseparametrizacionn.cargarPantalla("Tipo Clasificacion De Riesgo Adverso");
            } else if (nodo.getUserObject().toString().equals("Vigencia de Pago Facturas")) {
                Principal.claseparametrizacionn.cargarPantalla("Vigencia de Pago Facturas");
            } else if (nodo.getUserObject().toString().equals("Forma de Pago")) {
                Principal.claseparametrizacionn.cargarPantalla("Forma de Pago");
            } else if (nodo.getUserObject().toString().equals("Encabezado de Rubro")) {
                Principal.claseparametrizacionn.cargarPantalla("Encabezado de Rubro");
            } else if (nodo.getUserObject().toString().equals("Tipo Documento Firmas")) {
                Principal.claseparametrizacionn.cargarPantalla("Tipo Documento Firmas");
            } else if (nodo.getUserObject().toString().equals("Tipo de Reunion")) {
                Principal.claseparametrizacionn.cargarPantalla("Tipo de Reunion");
            } else if (nodo.getUserObject().toString().equals("Tipo de Tubo")) {
                Principal.claseparametrizacionn.cargarPantalla("Tipo de Tubo");
            } else if (nodo.getUserObject().toString().equals("SO Tipo de Resultado")) {
                Principal.claseparametrizacionn.cargarPantalla("SO Tipo de Resultado");
            } else if (nodo.getUserObject().toString().equals("Tipo Clasificacion De Cita")) {
                Principal.claseparametrizacionn.cargarPantalla("Tipo Clasificacion De Cita");
            } else if (nodo.getUserObject().toString().equals("Actividad Economica")) {
                Principal.claseparametrizacionn.cargarPantalla("Actividad Economica");
            } else if (nodo.getUserObject().toString().equals("Nivel de Actividad Economica")) {
                Principal.claseparametrizacionn.cargarPantalla("Nivel de Actividad Economica");
            } else if (nodo.getUserObject().toString().equals("Tipo de Certificado SO")) {
                Principal.claseparametrizacionn.cargarPantalla("Tipo de Certificado SO");
            } else if (nodo.getUserObject().toString().equals("Tipo de Concepto SO")) {
                Principal.claseparametrizacionn.cargarPantalla("Tipo de Concepto SO");
            } else if (nodo.getUserObject().toString().equals("Tipo Documento Recursos Humanos")) {
                Principal.claseparametrizacionn.cargarPantalla("Tipo de Documento de Recursos Humanos");
            } else if (nodo.getUserObject().toString().equals("Tipo Categoría Seguridad Clínica")) {
                Principal.claseparametrizacionn.cargarPantalla("Tipo Categoría Seguridad Clínica");
            } else if (nodo.getUserObject().toString().equals("Tipo Clasificacion de Residuos")) {
                Principal.claseparametrizacionn.cargarPantalla("Tipo Clasificacion de Residuos");
            } else if (nodo.getUserObject().toString().equals("País")) {
                Principal.claseparametrizacionn.cargarPantalla("País");
            } else if (nodo.getUserObject().toString().equals("Tipo Riesgo de Complicacion")) {
                Principal.claseparametrizacionn.cargarPantalla("Tipo Riesgo de Complicacion");
            } else if (nodo.getUserObject().toString().equals("Tipo de Consentimiento")) {
                Principal.claseparametrizacionn.cargarPantalla("Tipo de Consentimiento");
            } else if (nodo.getUserObject().toString().equals("Clasificacion Tipo Complicacion de Riesgo")) {
                Principal.claseparametrizacionn.cargarPantalla("Clasificacion Tipo Complicacion de Riesgo");
            } else if (nodo.getUserObject().toString().equals("Tipo de Seguimiento")) {
                Principal.claseparametrizacionn.cargarPantalla("Tipo de Seguimiento");
            } else if (nodo.getUserObject().toString().equals("Clasifacion de Tipo Documento")) {
                Principal.claseparametrizacionn.cargarPantalla("Clasifacion de Tipo Documento");
            } else if (nodo.getUserObject().toString().equals("Conceptos de Agrupacion del Informe CGR")) {
                Principal.claseparametrizacionn.cargarPantalla("Conceptos de Agrupacion del Informe CGR");
            } else if (nodo.getUserObject().toString().equals("Tipo Clasificacion de Imagenes")) {
                Principal.claseparametrizacionn.cargarPantalla("Tipo Clasificacion de Imagenes");
            } else if (nodo.getUserObject().toString().equals("Ficha de Notificaciones Sivigila")) {
                Principal.claseparametrizacionn.cargarPantalla("Ficha de Notificaciones Sivigila");
            } else if (nodo.getUserObject().toString().equals("Esquema Citología")) {
                Principal.claseparametrizacionn.cargarPantalla("Esquema Citologia");
            } else if (nodo.getUserObject().toString().equals("Clasificacion de Notas")) {
                Principal.claseparametrizacionn.cargarPantalla("Clasificacion de Notas");
            } else if (nodo.getUserObject().toString().equals("Grupo examen Fisico")) {
                Principal.claseparametrizacionn.cargarPantalla("Grupo Examen Fisico");
            } else if (nodo.getUserObject().toString().equals("Grupo SistemasP")) {
                Principal.claseparametrizacionn.cargarPantalla("Grupo SistemasP");
            } else if (nodo.getUserObject().toString().equals("Tipo Sistemas")) {
                Principal.claseparametrizacionn.cargarPantalla("Tipo Sistemas");
            } else if (nodo.getUserObject().toString().equals("Unificar Usuario Empresa Duplicados")) {
                Principal.clasegeneral.cargarPantalla("Unificar Usuario Empresa Duplicados");
            } else if (nodo.getUserObject().toString().equals("Entorno Familiar")) {
                Principal.claseparametrizacionn.cargarPantalla("Entorno Familiar");
            } else if (nodo.getUserObject().toString().equals("Relacion Familiar")) {
                Principal.claseparametrizacionn.cargarPantalla("Relacion Familiar");
            } else if (nodo.getUserObject().toString().equals("Tipo Documento Soporte")) {
                Principal.claseparametrizacionn.cargarPantalla("Tipo Documento Soporte");
            } else if (nodo.getUserObject().toString().equals("Tipo de informe")) {
                Principal.claseparametrizacionn.cargarPantalla("Tipo de Informe");
            } else if (nodo.getUserObject().toString().equals("Puc Tipo de Informe")) {
                Principal.claseparametrizacionn.cargarPantalla("Puc Tipo de Informe");
            } else if (nodo.getUserObject().toString().equals("Entidades Contraloria")) {
                Principal.claseparametrizacionn.cargarPantalla("Entidades Contraloria");
            } else if (nodo.getUserObject().toString().equals("Origen Ingreso")) {
                Principal.claseparametrizacionn.cargarPantalla("Origen Ingreso");
            } else if (nodo.getUserObject().toString().equals("Tipo Destinacion")) {
                Principal.claseparametrizacionn.cargarPantalla("Tipo Destinacion");
            } else if (nodo.getUserObject().toString().equals("Tipo Recursos")) {
                Principal.claseparametrizacionn.cargarPantalla("Tipo Recursos");
            } else if (nodo.getUserObject().toString().equals("Tipo Situacion")) {
                Principal.claseparametrizacionn.cargarPantalla("Tipo Situacion");
            } else if (nodo.getUserObject().toString().equals("Tipo Vigencia")) {
                Principal.claseparametrizacionn.cargarPantalla("Tipo Vigencia");
            } else if (nodo.getUserObject().toString().equals("Finalidad Gasto")) {
                Principal.claseparametrizacionn.cargarPantalla("Finalidad Gasto");
            } else if (nodo.getUserObject().toString().equals("Rubro Contraloria")) {
                Principal.claseparametrizacionn.cargarPantalla("Rubro Contraloria");
            } else if (nodo.getUserObject().toString().equals("Configuracion de Items")) {
                Principal.claseparametrizacionn.cargarPantalla("Configuracion de Items");
            } else if (nodo.getUserObject().toString().equals("Clasificacion Lasa")) {
                Principal.claseparametrizacionn.cargarPantalla("Clasificacion Lasa");
            } else if (nodo.getUserObject().toString().equals("Unidad de Medida")) {
                Principal.claseparametrizacionn.cargarPantalla("Unidad de Medida");
            } else if (nodo.getUserObject().toString().equals("Tipo Antecedente Psiquiátrico")) {
                Principal.claseparametrizacionn.cargarPantalla("Tipo Antecedente Psiquiátrico");
            } else if (nodo.getUserObject().toString().equals("Tipo Atención")) {
                Principal.claseparametrizacionn.cargarPantalla("Tipo Atención");
            } else if (nodo.getUserObject().toString().equals("Importar Esquema PaiWeb")) {
                Principal.claseparametrizacionn.cargarPantalla("Importar Esquema PaiWeb");
            } else if (nodo.getUserObject().toString().equals("Periodos Financieros")) {
                Principal.claseparametrizacionn.cargarPantalla("Periodos Financieros");
            } else if (nodo.getUserObject().toString().equals("Tipo de Agente")) {
                Principal.claseparametrizacionn.cargarPantalla("TipoAgente");
            } else if (nodo.getUserObject().toString().equals("Importar Firma Electronica")) {
                Principal.claseparametrizacionn.cargarPantalla("Importar Firma Electronica");
            } else if (nodo.getUserObject().toString().equals("Tipo de comida")) {
                Principal.claseparametrizacionn.cargarPantalla("Tipo de comida");
            } else if (nodo.getUserObject().toString().equals("Tipo de dieta")) {
                Principal.claseparametrizacionn.cargarPantalla("Tipo de dieta");
            } else if (nodo.getUserObject().toString().equals("Empleados")) {
                Principal.claserecursoshumanos.cargarPantalla("Empleados");
            } else if (nodo.getUserObject().toString().equals("Resolucion dian")) {
                Principal.claseparametrizacionn.cargarPantalla("Resolucion dian");
            } else if (nodo.getUserObject().toString().equals("Tipo de Politicas")) {
                Principal.claseparametrizacionn.cargarPantalla("Tipo de Politicas");
            } else if (nodo.getUserObject().toString().equals("Vigilancia Seguimiento")) {
                Principal.claseparametrizacionn.cargarPantalla("Vigilancia Seguimiento");
            } else if (nodo.getUserObject().toString().equals("Tipo de Documento Soporte (Facturacion)")) {
                Principal.claseparametrizacionn.cargarPantalla("Tipo de Documento Soporte");
            } else if (nodo.getUserObject().toString().equals("Tipo de Documentos Hc")) {
                Principal.claseparametrizacionn.cargarPantalla("Tipo de Documentos Hc");
            } else if (nodo.getUserObject().toString().equals("Tipos de Ayuda Dx")) {
                Principal.claseparametrizacionn.cargarPantalla("Tipos de Ayuda Dx");
            } else if (nodo.getUserObject().toString().trim().equals("Transmision nomina")) {
                Principal.claserecursoshumanos.cargarPantalla("Transmision nomina");
            } else if (nodo.getUserObject().toString().trim().equals("Reporte Horas")) {
                Principal.claserecursoshumanos.cargarPantalla("Reporte Horas");
            } else if (nodo.getUserObject().toString().trim().equals("Transmision notas Nomina")) {
                Principal.claserecursoshumanos.cargarPantalla("Transmision notas Nomina");
            } else if (nodo.getUserObject().toString().trim().equals("Sexo")) {
                Principal.claseparametrizacionn.cargarPantalla("Sexo");
            } else if (nodo.getUserObject().toString().trim().equals("Tipo sistema de vigilancia")) {
                Principal.claseparametrizacionn.cargarPantalla("Tipo sistema de vigilancia");
            } else if (nodo.getUserObject().toString().trim().equals("Tipo vigilancia sistema")) {
                Principal.claseparametrizacionn.cargarPantalla("Tipo vigilancia sistema");
            } else if (nodo.getUserObject().toString().trim().equals("Identidad Genero")) {
                Principal.claseparametrizacionn.cargarPantalla("Identidad Genero");
            } else if (nodo.getUserObject().toString().trim().equals("Tipo Discapacidad")) {
                Principal.claseparametrizacionn.cargarPantalla("Tipo Discapacidad");
            } else if (nodo.getUserObject().toString().trim().equals("Entorno Atencion")) {
                Principal.claseparametrizacionn.cargarPantalla("Entorno Atencion");
            } else if (nodo.getUserObject().toString().trim().equals("Suministro Tecnologia Salud")) {
                Principal.claseparametrizacionn.cargarPantalla("Suministro Tecnologia Salud");
            } else if (nodo.getUserObject().toString().trim().equals("Origen Admision")) {
                Principal.claseparametrizacionn.cargarPantalla("Origen Admision");
            } else if (nodo.getUserObject().toString().trim().equals("Sexo")) {
                Principal.claseparametrizacionn.cargarPantalla("Sexo");
            } else if (nodo.getUserObject().toString().trim().equals("Tipo de Parentesco")) {
                Principal.claseparametrizacionn.cargarPantalla("Tipo de Parentesco");
            } else if (nodo.getUserObject().toString().trim().equals("Procedimiento Finalidad")) {
                Principal.claseparametrizacionn.cargarPantalla("Procedimiento Finalidad");
            } else if (nodo.getUserObject().toString().trim().equals("Tecnología Salud")) {
                Principal.claseparametrizacionn.cargarPantalla("Tecnología Salud");
            } else if (nodo.getUserObject().toString().trim().equals("Prueba_Datos")) {
                Principal.claseparametrizacionn.cargarPantalla("Prueba_Datos");
            } else if (nodo.getUserObject().toString().equals("Rubros N")) {
                Principal.claseparametrizacionn.cargarPantalla("Rubros N");
            } else if (nodo.getUserObject().toString().equals("Rubros Centro de Costos")) {
                Principal.claseparametrizacionn.cargarPantalla("Rubros Centro de Costos");
            } else if (nodo.getUserObject().toString().equals("Rubros Fuente Financiacion")) {
                Principal.claseparametrizacionn.cargarPantalla("Rubros Fuente Financiacion");
            } else if (nodo.getUserObject().toString().equals("Rubros CPC")) {
                Principal.claseparametrizacionn.cargarPantalla("Rubros CPC");
            } else if (nodo.getUserObject().toString().equals("Modalidad Atencion")) {
                Principal.claseparametrizacionn.cargarPantalla("Modalidad Atencion");
            } else if (nodo.getUserObject().toString().equals("Tipo Medicamento")) {
                Principal.claseparametrizacionn.cargarPantalla("Tipo Medicamento");
            } else if (nodo.getUserObject().toString().equals("Codigo Servicio")) {
                Principal.claseparametrizacionn.cargarPantalla("Codigo Servicio");
            } else if (nodo.getUserObject().toString().equals("Clasificación AIEPI")) {
                Principal.claseparametrizacionn.cargarPantalla("Clasificación AIEPI");
            } else if (nodo.getUserObject().toString().equals("Respuestas AIEPI")) {
                Principal.claseparametrizacionn.cargarPantalla("Respuestas AIEPI");
            } else if (nodo.getUserObject().toString().equals("Preguntas AIEPI Oncologíco")) {
                Principal.claseparametrizacionn.cargarPantalla("Preguntas AIEPI Oncologíco");
            } else if (nodo.getUserObject().toString().equals("Servicios RIPS")) {
                Principal.claseparametrizacionn.cargarPantalla("Servicios RIPS");
            } else if (nodo.getUserObject().toString().equals("Tipo Destino")) {
                Principal.claseparametrizacionn.cargarPantalla("Tipo Destino");
            } else if (nodo.getUserObject().toString().equals("Unidad Minima Dispensacion")) {
                Principal.claseparametrizacionn.cargarPantalla("Unidad Minima Dispensacion");
            } else if (nodo.getUserObject().toString().equals("Procedimiento Servicio Rips")) {
                Principal.claseparametrizacionn.cargarPantalla("Procedimiento Servicio Rips");
            } else if (nodo.getUserObject().toString().equals("Procedimiento Tipo Finalidad")) {
                Principal.claseparametrizacionn.cargarPantalla("Procedimiento Tipo Finalidad");
            } else if (nodo.getUserObject().toString().equals("Menu Prueba")) {
                Principal.claseparametrizacionn.cargarPantalla("Menu Prueba");
            }
            System.out.println("nodo " + nodo.getUserObject().toString().trim());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doMouseClickedCal(MouseEvent me) {
        DefaultMutableTreeNode nodo = (DefaultMutableTreeNode) this.treeCal.getLastSelectedPathComponent();
        if (nodo != null && me.getClickCount() == 2 && !nodo.getUserObject().toString().equals("Calidad")) {
            if (nodo.getUserObject().toString().equals("Consultar Usuarios Inactivos")) {
                Principal.xclasesgc.cargarPantalla("Consultar Usuarios Inactivos");
            }
            if (nodo.getUserObject().toString().equals("Información Cita x Especialidad")) {
                Principal.xclasesgc.cargarPantalla("Información Cita x Especialidad");
            }
            if (nodo.getUserObject().toString().equals("Información Salud Ocupacional")) {
                Principal.xclasesgc.cargarPantalla("Informacion SO");
            }
            if (nodo.getUserObject().toString().equals("Forma de Asignación Citas")) {
                Principal.xclasesgc.cargarPantalla("Forma de Asignación Citas");
            }
            if (nodo.getUserObject().toString().equals("Remisiones por Profesional")) {
                Principal.xclasesgc.cargarPantalla("Remisiones por Profesional");
            }
            if (nodo.getUserObject().toString().equals("Facturación - Atención Médica Programada")) {
                Principal.xclasesgc.cargarPantalla("Facturación - Atención Médica Programada");
            }
            if (nodo.getUserObject().toString().equals("Enfermera")) {
                Principal.xclasesgc.cargarPantalla("Auditoria Enfermeria");
            }
            if (nodo.getUserObject().toString().equals("Médica")) {
                Principal.xclasesgc.cargarPantalla("Auditoria Medica");
            }
            if (nodo.getUserObject().toString().equals("Consultar Alertas Parametrizadas")) {
                Principal.xclasesgc.cargarPantalla("Consultar Alertas Parametrizadas");
            }
            if (nodo.getUserObject().toString().equals("General")) {
                Principal.xclasesgc.cargarPantalla("Consultar Morbilidad");
            }
            if (nodo.getUserObject().toString().equals("General por Edades")) {
                Principal.xclasesgc.cargarPantalla("Consultar Morbilidad General por Edades");
            }
            if (nodo.getUserObject().toString().equals("General por Sexo")) {
                Principal.xclasesgc.cargarPantalla("Consultar Morbilidad General por Sexo");
            }
            if (nodo.getUserObject().toString().equals("General por Sexo y Edad")) {
                Principal.xclasesgc.cargarPantalla("Consultar Morbilidad General por Sexo y Edad");
            }
            if (nodo.getUserObject().toString().equals("Fisioterapia")) {
                Principal.xclasesgc.cargarPantalla("Consultar Morbilidad Fisioterapia");
            }
            if (nodo.getUserObject().toString().equals("Actualizar Referencia de Consulta")) {
                Principal.xclasesgc.cargarPantalla("Actualizar Referencia de Consulta");
            }
            if (nodo.getUserObject().toString().equals("Consolidado de Información")) {
                Principal.xclasesgc.cargarPantalla("Consolidado de Información");
            }
            if (nodo.getUserObject().toString().equals("Consultar Antecedentes IMC > 30")) {
                Principal.xclasesgc.cargarPantalla("Consultar Atenciones IMC>30");
            }
            if (nodo.getUserObject().toString().equals("Consultar Reducción y/o Aumento de Peso")) {
                Principal.xclasesgc.cargarPantalla("Consultar Reduccion y/o Aumento de Peso");
            }
            if (nodo.getUserObject().toString().equals("Preparar Referencia de Consulta")) {
                Principal.xclasesgc.cargarPantalla("Referencia Consulta Nutrición");
            }
            if (nodo.getUserObject().toString().equals("Resultados de Encuesta")) {
                Principal.xclasesgc.cargarPantalla("Resultado Encuestas");
            }
            if (nodo.getUserObject().toString().equals("Consolidado de Eventos no Deseados")) {
                Principal.xclasesgc.cargarPantalla("Consolidado Eventos No Deseados");
            }
            if (nodo.getUserObject().toString().equals("Generación Incapacidades")) {
                Principal.xclasesgc.cargarPantalla("Generacion_PDF");
            }
            if (nodo.getUserObject().toString().equals("Demandas no Atendidas")) {
                Principal.xclasesgc.cargarPantalla("DemandasNA");
            }
            if (nodo.getUserObject().toString().equals("Informe Tratamientos")) {
                Principal.xclasesgc.cargarPantalla("Informe Tratamientos");
            }
            if (nodo.getUserObject().toString().equals("Autorreportes")) {
                Principal.xclasesgc.cargarPantalla("Autoreportes");
            }
            if (nodo.getUserObject().toString().equals("Resultado Batería Psicosocial")) {
                Principal.xclasesgc.cargarPantalla("Bateria Sicosocial");
            }
            if (nodo.getUserObject().toString().equals("Reporte NOMA")) {
                Principal.xclasesgc.cargarPantalla("Informe NOMA");
            }
            if (nodo.getUserObject().toString().equals("Reporte Prueba Respiratoria")) {
                Principal.xclasesgc.cargarPantalla("Reporte Prueba Respiratoria");
            }
            if (nodo.getUserObject().toString().equals("Reporte Test Auditivo")) {
                Principal.xclasesgc.cargarPantalla("Reporte Test Auditivo");
            }
            if (nodo.getUserObject().toString().equals("Consolidado de Atenciones")) {
                Principal.xclasesgc.cargarPantalla("Atenciones So");
            }
            if (nodo.getUserObject().toString().equals("Reporte Audiometría")) {
                Principal.xclasesgc.cargarPantalla("Informe Audiometría");
            }
            if (nodo.getUserObject().toString().equals("Reporte Espirometría")) {
                Principal.xclasesgc.cargarPantalla("Informe Espirometría");
            }
            if (nodo.getUserObject().toString().equals("Reporte Espirometría1")) {
                Principal.xclasesgc.cargarPantalla("Informe Espirometría1");
            }
            if (nodo.getUserObject().toString().equals("Reporte Sociodemográfico")) {
                Principal.xclasesgc.cargarPantalla("Reporte Sociodemografico");
            }
            if (nodo.getUserObject().toString().equals("Consultores Crónicos x Especialidad")) {
                Principal.xclasesgc.cargarPantalla("Consultadores Crónicos x Especialidad");
            }
            if (nodo.getUserObject().toString().equals("Ficha 5w1H")) {
                new AccesoModulos(null, true, "ASIGNADOS", "PROCESOS", "xjif_ficha", this.xPrincipal);
                if (Principal.informacionGeneralPrincipalDTO.getActivarModulo().intValue() == 1) {
                    Principal.xclasesgc.cargarPantalla("Ficha 5w1H");
                }
            }
            if (nodo.getUserObject().toString().equals("Registro - Análisis NC")) {
                Principal.xclasesgc.cargarPantalla("Registro-Analisis NC");
            }
            if (nodo.getUserObject().toString().equals("Autorizar")) {
                Principal.xclasesgc.cargarPantalla("Autorizar Solicitudes");
            }
            if (nodo.getUserObject().toString().equals("Gestionar")) {
                Principal.xclasesgc.cargarPantalla("Gestionar Solicitudes");
            }
            if (nodo.getUserObject().toString().equals("Casos de Seguridad Clínica")) {
                Principal.xclasesgc.cargarPantalla("CSeguridadClinica");
            }
            if (nodo.getUserObject().toString().equals("Registro de Indicadores")) {
                Principal.xclasesgc.cargarPantalla("Registro de Indicadores");
            }
            if (nodo.getUserObject().toString().equals("Revisar Reportes NC")) {
                Principal.xclasesgc.cargarPantalla("Revisar Reporte NC");
            }
            if (nodo.getUserObject().toString().equals("Gestión Ficha 5w1H")) {
                Principal.xclasesgc.cargarPantalla("Gestion Ficha 5w1H");
            }
            if (nodo.getUserObject().toString().equals("Atenciones por Especialidad")) {
                Principal.xclasesgc.cargarPantalla("Atenciones por Especialidad");
            }
            if (nodo.getUserObject().toString().equals("Citas Programadas por Especialidad")) {
                Principal.xclasesgc.cargarPantalla("Citas Programadas por Especialidad");
            }
            if (nodo.getUserObject().toString().equals("Formulación por Tipo de Fórmula")) {
                Principal.xclasesgc.cargarPantalla("Formulación por Tipo de Formula");
            }
            if (nodo.getUserObject().toString().equals("Informacón Carn Cardiovascular")) {
                Principal.xclasesgc.cargarPantalla("Información Cardiovascular");
            }
            if (nodo.getUserObject().toString().equals("Información Crón Crónica Colmédica")) {
                Principal.xclasesgc.cargarPantalla("Información Crónicos Colmedica");
            }
            if (nodo.getUserObject().toString().equals("Informe Resolución 2175")) {
                Principal.xclasesgc.cargarPantalla("Resolucion2175");
            }
            if (nodo.getUserObject().toString().equals("Informe Resolución 1552")) {
                Principal.xclasesgc.cargarPantalla("Resolucion1552");
            }
            if (nodo.getUserObject().toString().equals("Informe Resolución 4505")) {
                Principal.xclasesgc.cargarPantalla("Resolucion4505");
            }
            if (nodo.getUserObject().toString().equals("Consultar Examenes Salud ocupacional")) {
                Principal.xclasesgc.cargarPantalla("examenesSO");
            }
            if (nodo.getUserObject().toString().equals("Patologías Asociadas")) {
                Principal.xclasesgc.cargarPantalla("Patologías Asociadas");
            }
            if (nodo.getUserObject().toString().equals("Reporte de Gestión de Riesgo") || nodo.getUserObject().toString().equals("Reporte Patología de Notificación Obligatoria") || nodo.getUserObject().toString().equals("Informe Morbilidad General (Sivigila)")) {
                Principal.xclasesgc.cargarPantalla("Informe Morbilidad General (Sivigila)");
            }
            if (nodo.getUserObject().toString().equals("Resultado de Exámenes x Procedimiento")) {
                Principal.xclasesgc.cargarPantalla("Resultado Examenes por Procedimiento");
            }
            if (nodo.getUserObject().toString().equals("Suministro Multivitaminico")) {
                Principal.xclasesgc.cargarPantalla("Suministro Multivitamínicos");
            }
            if (nodo.getUserObject().toString().equals("Usuario x Actividad")) {
                Principal.xclasesgc.cargarPantalla("Usuario x Actividad");
            }
            if (nodo.getUserObject().toString().equals("Usuario x Programa")) {
                Principal.xclasesgc.cargarPantalla("Usuario x Programa");
            }
            if (nodo.getUserObject().toString().equals("Informe x EPS")) {
                Principal.xclasesgc.cargarPantalla("Informe por eps");
            }
            if (nodo.getUserObject().toString().equals("Auditoría Triage")) {
                Principal.xclasesgc.cargarPantalla("Auditoria de Triage");
            }
            if (nodo.getUserObject().toString().equals("Informe Resolución 256")) {
                Principal.xclasesgc.cargarPantalla("Resolucion256");
            }
            if (nodo.getUserObject().toString().equals("Informe Circular 014")) {
                Principal.xclasesgc.cargarPantalla("Circular014");
            }
            if (nodo.getUserObject().toString().equals("Circular 000014 (FT025)")) {
                Principal.xclasesgc.cargarPantalla("Circular014FT025");
            }
            if (nodo.getUserObject().toString().equals("Cargue Información Entidades")) {
                Principal.xclasesgc.cargarPantalla("Cargue Información Entidades");
            }
            if (nodo.getUserObject().toString().equals("Informe Circular Externa 015")) {
                Principal.xclasesgc.cargarPantalla("Circular015");
            }
            if (nodo.getUserObject().toString().equals("Consolidado Tiempos de Atención")) {
                Principal.xclasesgc.cargarPantalla("Consolidado Tiempos de Atención");
            }
            if (nodo.getUserObject().toString().equals("Consultar Estado de Asignación de Citas no Programadas")) {
                Principal.xclasesgc.cargarPantalla("Consultar Estado de Asignaciones de Citas no Programadas");
            }
            if (nodo.getUserObject().toString().equals("Hospitalizaciones -Remisiones")) {
                Principal.xclasesgc.cargarPantalla("Hospitalizaciones-Remisiones");
            }
            if (nodo.getUserObject().toString().equals("Residuos Peligrosos")) {
                Principal.xclasesgc.cargarPantalla("Residuos Peligrosos");
            }
            if (nodo.getUserObject().toString().equals("Estadísticas de Muestras Relacionadas")) {
                Principal.xclasesgc.cargarPantalla("Estadística de Muestras Recepcionadas");
            }
            if (nodo.getUserObject().toString().equals("Estadísticas de Recepciones")) {
                Principal.xclasesgc.cargarPantalla("Estadística de Recepciones");
            }
            if (nodo.getUserObject().toString().equals("Estadísticas de Tiempo de Espera")) {
                Principal.xclasesgc.cargarPantalla("Estadística de Tiempo de Espera");
            }
            if (nodo.getUserObject().toString().equals("Estudios Realizados")) {
                Principal.xclasesgc.cargarPantalla("Usuarios Atendidos");
            }
            if (nodo.getUserObject().toString().equals("Informes de Placas")) {
                Principal.xclasesgc.cargarPantalla("Informes de Placas");
            }
            if (nodo.getUserObject().toString().equals("Placas Dañadas")) {
                Principal.xclasesgc.cargarPantalla("Placas Dañadas");
            }
            if (nodo.getUserObject().toString().equals("Tiempo de Espera RX")) {
                Principal.xclasesgc.cargarPantalla("Tiempo de Espera RX");
            }
            if (nodo.getUserObject().toString().equals("Eficacia")) {
                Principal.xclasesgc.cargarPantalla("Eficacia Fisioterapia");
            }
            if (nodo.getUserObject().toString().equals("Eficacia")) {
                Principal.xclasesgc.cargarPantalla("Eficacia Fisioterapia");
            }
            if (nodo.getUserObject().toString().equals("Formulación Médica")) {
                Principal.xclasesgc.cargarPantalla("Formulacion Medica");
            }
            if (nodo.getUserObject().toString().equals("Movimientos Consolidados")) {
                Principal.xclasesgc.cargarPantalla("Movimiento Consolidado");
            }
            if (nodo.getUserObject().toString().equals("Registro de Encuesta")) {
                Principal.xclasesgc.cargarPantalla("Registro Encuesta");
            }
            if (nodo.getUserObject().toString().equals("Consultar Usuarios Matriculados")) {
                Principal.xclasesgc.cargarPantalla("CONSULTA USUARIOS MATRICULADOS1");
            }
            if (nodo.getUserObject().toString().equals("Informe Super Salud")) {
                Principal.xclasesgc.cargarPantalla("Informe Super Salud");
            }
            if (nodo.getUserObject().toString().equals("Vigencia de Póliza x Proveedor")) {
                Principal.xclasesgc.cargarPantalla("Vigencia de Pólizas x Proveedor");
            }
            if (nodo.getUserObject().toString().equals("Información Consolidado")) {
                Principal.xclasesgc.cargarPantalla("Informacion Consolidada");
            }
            if (nodo.getUserObject().toString().equals("Informe de Citologías")) {
                Principal.xclasesgc.cargarPantalla("Informe de Citologías");
            }
            if (nodo.getUserObject().toString().equals("Informe Seguridad Programa Salud Infantil")) {
                Principal.xclasesgc.cargarPantalla("SEGUIMIENTO CRECIMIENTO Y DESARROLLO");
            }
            if (nodo.getUserObject().toString().equals("Gestion Ordenes Dynamicos")) {
                Principal.xclasesgc.cargarPantalla("Gestion Ordenes Dynamicos");
            }
            if (nodo.getUserObject().toString().equals("Consulta de Oportunidad Urgencia")) {
                Principal.clasefacturacion.cargarPantalla("Consulta de Oportunidad Urgencia");
            }
            if (nodo.getUserObject().toString().equals("Consulta de Usuarios Hospitalizados")) {
                Principal.clasefacturacion.cargarPantalla("Consulta de Usuarios Hospitalizados");
            }
            if (nodo.getUserObject().toString().equals("Consulta Detalle Alto Riesgo Obstétrico")) {
                Principal.xclasesig.cargarPantalla("Consulta Detalle Alto Riesgo Obstétrico");
            }
            if (nodo.getUserObject().toString().equals("Informe Consolidado de Clases de Citas por Especialidad")) {
                Principal.xclasesig.cargarPantalla("Informe Consolidado de Clases de Citas por Especialidad");
            }
            if (nodo.getUserObject().toString().equals("Consolidado de Atenciones por Empresa")) {
                Principal.xclasesig.cargarPantalla("Consolidado de Atenciones por Empresa");
            }
            if (nodo.getUserObject().toString().equals("Estadistica de Procedimientos por Tipo de Atencion")) {
                Principal.xclasesig.cargarPantalla("Estadistica de Procedimientos por Tipo de Atencion");
            }
            if (nodo.getUserObject().toString().equals("Consolidado de Procedimientos Detallado por Empresa")) {
                Principal.xclasesig.cargarPantalla("Consolidado de Procedimientos Detallado por Empresa");
            }
            if (nodo.getUserObject().toString().equals("Consolidado de Asignacion Citas por Usuario del Sistema")) {
                Principal.xclasesig.cargarPantalla("Consolidado de Asignacion Citas por Usuario del Sistema");
            }
            if (nodo.getUserObject().toString().equals("Consultar Citas Por Empresa")) {
                Principal.xclasesig.cargarPantalla("Consultar Citas Por Empresa");
            }
            if (nodo.getUserObject().toString().equals("Consultar Atenciones Riesgo Obstetrico (Facturacion)")) {
                Principal.xclasesig.cargarPantalla("Consultar Atenciones Riesgo Obstetrico (Facturacion)");
            }
            if (nodo.getUserObject().toString().equals("Consultar Atenciones Riesgo Cardiovascular (Facturacion)")) {
                Principal.xclasesig.cargarPantalla("Consultar Atenciones Riesgo Cardiovascular (Facturacion)");
            }
            if (nodo.getUserObject().toString().equals("Consolidado De Atenciones Por Fecha")) {
                Principal.xclasesig.cargarPantalla("Consolidado De Atenciones Por Fecha");
            }
            if (nodo.getUserObject().toString().equals("Procedimientos Realizados Por Empresa")) {
                Principal.xclasesig.cargarPantalla("Procedimientos Realizados Por Empresa");
            }
            if (nodo.getUserObject().toString().equals("Consultar Cirugias No Programadas")) {
                Principal.xclasesig.cargarPantalla("Consultar Cirugias No Programadas");
            }
            if (nodo.getUserObject().toString().equals("Consultar Consolidado Por Profesional")) {
                Principal.xclasesig.cargarPantalla("Consultar Consolidado Por Profesional");
            }
            if (nodo.getUserObject().toString().equals("Consultar Cirugias Por EPS")) {
                Principal.xclasesig.cargarPantalla("Consultar Cirugias Por EPS");
            }
            if (nodo.getUserObject().toString().equals("Consultar Cirugias Usuarios EPS y Profesional")) {
                Principal.xclasesig.cargarPantalla("Consultar Cirugias Usuarios EPS y Profesional");
            }
            if (nodo.getUserObject().toString().equals("Consultar Detalle Entrada Por Bodega")) {
                Principal.xclasesig.cargarPantalla("Consultar Detalle Entrada Por Bodega");
            }
            if (nodo.getUserObject().toString().equals("Consultar Atenciones")) {
                Principal.xclasesig.cargarPantalla("Consultar Atenciones");
            }
            if (nodo.getUserObject().toString().equals("Consolidado de Ordenes por Medico")) {
                Principal.xclasesig.cargarPantalla("Consolidado de Ordenes por Medico");
            }
            if (nodo.getUserObject().toString().equals("Consolidado de Ordenes por Convenio y Profesional")) {
                Principal.xclasesig.cargarPantalla("Consolidado de Ordenes por Convenio y Profesional");
            }
            if (nodo.getUserObject().toString().equals("Estadistica de Procedimientos Laboratorio")) {
                Principal.xclasesig.cargarPantalla("Estadistica de Procedimientos Laboratorio");
            }
            if (nodo.getUserObject().toString().equals("Consolidado de Procedimientos Detallado Laboratorio")) {
                Principal.xclasesig.cargarPantalla("Consolidado de Procedimientos Detallado Laboratorio");
            }
            if (nodo.getUserObject().toString().equals("Listado De Pacientes Facturados Para Atención Laboratorio")) {
                Principal.xclasesig.cargarPantalla("Listado De Pacientes Facturados Para Atención Laboratorio");
            }
            if (nodo.getUserObject().toString().equals("Listado De Pacientes Facturados Para Atención Radiología")) {
                Principal.xclasesig.cargarPantalla("Listado De Pacientes Facturados Para Atención Radiología");
            }
            if (nodo.getUserObject().toString().equals("Informe De Gestantes x Control prenatal")) {
                Principal.xclasesig.cargarPantalla("Informe De Gestantes x Control prenatal");
            }
            if (nodo.getUserObject().toString().equals("Reporte Examen Ocupacional")) {
                Principal.xclasesig.cargarPantalla("Reporte Examen Ocupacional");
            }
            if (nodo.getUserObject().toString().equals("Consulta Salud Ocupacional para DX")) {
                Principal.xclasesig.cargarPantalla("Consulta Salud Ocupacional para DX");
            }
            if (nodo.getUserObject().toString().equals("Consulta Orden Por Procedimiento")) {
                Principal.xclasesig.cargarPantalla("Consulta Orden Por Procedimiento");
            }
            if (nodo.getUserObject().toString().equals("Consulta Informacion de Lipidos y Carbohidratos")) {
                Principal.xclasesig.cargarPantalla("Consulta Informacion de Lipidos y Carbohidratos");
            }
            if (nodo.getUserObject().toString().equals("Total de Dosis Suministradas")) {
                Principal.xclasesig.cargarPantalla("Total de Dosis Suministradas");
            }
            if (nodo.getUserObject().toString().equals("Total de Dosis Suministrada por Entidad")) {
                Principal.xclasesig.cargarPantalla("Total de Dosis Suministrada por Entidad");
            }
            if (nodo.getUserObject().toString().equals("Informe de Aplicacion de Vacunas por Usuario")) {
                Principal.xclasesig.cargarPantalla("Informe de Aplicacion de Vacunas por Usuario");
            }
            if (nodo.getUserObject().toString().equals("Formulación Por Subgrupo Farmacológico")) {
                Principal.xclasesig.cargarPantalla("Formulación Por Subgrupo Farmacológico");
            }
            if (nodo.getUserObject().toString().equals("Empresa por Convenio (Farmacológico)")) {
                Principal.xclasesig.cargarPantalla("Empresa por Convenio (Farmacológico)");
            }
            if (nodo.getUserObject().toString().equals("Consolidado de Cuenta Nomina por Usuario")) {
                Principal.xclasesgc.cargarPantalla("Consolidado de Cuenta Nomina por Usuario");
            }
            if (nodo.getUserObject().toString().equals("SC Análisis Evento Adverso")) {
                Principal.xclasesgc.cargarPantalla("SC Análisis Evento Adverso");
            }
            if (nodo.getUserObject().toString().equals("Agudeza Visual")) {
                Principal.xclasesgc.cargarPantalla("Agudeza Visual");
            }
            if (nodo.getUserObject().toString().equals("Planificación Familiar")) {
                Principal.xclasesgc.cargarPantalla("Planificación Familiar");
            }
            if (nodo.getUserObject().toString().equals("Joven Sano")) {
                Principal.xclasesgc.cargarPantalla("Joven Sano");
            }
            if (nodo.getUserObject().toString().equals("Adulto Sano")) {
                Principal.xclasesgc.cargarPantalla("Adulto Sano");
            }
            if (nodo.getUserObject().toString().equals("Crecimiento y Desarrollo")) {
                Principal.xclasesgc.cargarPantalla("Crecimiento y Desarrollo");
            }
            if (nodo.getUserObject().toString().equals("Consolidado Descuento de Nómina")) {
                Principal.clasefacturacion.cargarPantalla("Consolidado Descuento de Nómina");
            }
            if (nodo.getUserObject().toString().equals("Informe de Procedimientos Facturados")) {
                Principal.claseparametrizacionn.cargarPantalla("Informe de Procedimientos Facturados");
            }
            if (nodo.getUserObject().toString().equals("Informe de Insumos Facturados")) {
                Principal.claseparametrizacionn.cargarPantalla("Informe de Insumos Facturados");
            }
            if (nodo.getUserObject().toString().equals("Informe Resolución 4725")) {
                Principal.xclasesig.cargarPantalla("Informe Resolucion 4725");
            }
            if (nodo.getUserObject().toString().equals("Informe Resolución 2463")) {
                Principal.xclasesig.cargarPantalla("Informe Resolucion 2463");
            }
            if (nodo.getUserObject().toString().equals("Actas")) {
                Principal.xclasesgc.cargarPantalla("Actas");
            }
            if (nodo.getUserObject().toString().equals("Producción Por Sede y Profesional")) {
                Principal.xclasesig.cargarPantalla("Producción Por Sede y Profesional");
            }
            if (nodo.getUserObject().toString().equals("Informe de Control Prenatal")) {
                Principal.xclasesig.cargarPantalla("Informe de Control Prenatal");
            }
            if (nodo.getUserObject().toString().equals("Informe de Lecturas Por Empresa y Valor")) {
                Principal.xclasesig.cargarPantalla("Informe de Lecturas Por Empresa y Valor");
            }
            if (nodo.getUserObject().toString().equals("Informe Sesiones por Trabajador")) {
                Principal.xclasesgc.cargarPantalla("xjiffSesionesXTrabajdor");
            }
            if (nodo.getUserObject().toString().equals("Oportunidad en Asignación de Citas")) {
                Principal.clasescita.cargarPantalla(Principal.clasescita.frmPrincipal, "Reorganizar Dias de Asignacion");
            }
            if (nodo.getUserObject().toString().equals("Consultar Panoramas de Eventos Adversos")) {
                Principal.xclasesgc.cargarPantalla("Consultar Panoramas de Eventos Adversos");
            }
            if (nodo.getUserObject().toString().equals("Consultar Usuarios Citas No Asignadas")) {
                Principal.xclasesgc.cargarPantalla("Cita No Asignada");
            }
            if (nodo.getUserObject().toString().equals("Informe de Autoreportes")) {
                Principal.xclaseso.cargarPantalla("Informe de Autoreportes");
            }
            if (nodo.getUserObject().toString().equals("Informe Framingham")) {
                Principal.xclaseso.cargarPantalla("Informe Framingham");
            }
            if (nodo.getUserObject().toString().equals("Informe Test de Ruffier")) {
                Principal.xclaseso.cargarPantalla("Informe Test de Ruffier");
            }
            if (nodo.getUserObject().toString().equals("Censo Hospitalización")) {
                Principal.xclasesig.cargarPantalla("Censo Hospitalización");
            }
            if (nodo.getUserObject().toString().equals("Registro de QRSR")) {
                Principal.clasegestiondoc.cargarPantalla("Registro de QRSR", this.xPrincipal);
            }
            if (nodo.getUserObject().toString().equals("Seguimiento a QRSR")) {
                Principal.clasegestiondoc.cargarPantalla("Seguimiento a QRSR", this.xPrincipal);
            }
            if (nodo.getUserObject().toString().equals("Información de Convenios")) {
                Principal.xclasesig.cargarPantalla("Información de Convenios");
            }
            if (nodo.getUserObject().toString().equals("Información De Atención Prioritaria Preferencial")) {
                Principal.xclasesig.cargarPantalla("Información De Atención Prioritaria Preferencial");
            }
            if (nodo.getUserObject().toString().equals("Medicamentos por Tipo de Formula")) {
                Principal.xclasesig.cargarPantalla("Medicamentos por Tipo de Formula");
            }
            if (nodo.getUserObject().toString().equals("Informe de Diagnosticos de Salud")) {
                Principal.xclasesig.cargarPantalla("Informe de Diagnosticos de Salud");
            }
            if (nodo.getUserObject().toString().equals("Informe Resolución 1604")) {
                Principal.xclasesig.cargarPantalla("Informe Resolución 1604");
            }
            if (nodo.getUserObject().toString().equals("Informe Morbilidad IRA")) {
                Principal.xclasesig.cargarPantalla("Informe Morbilidad IRA");
            }
            if (nodo.getUserObject().toString().equals("Informe Morbilidad EDA")) {
                Principal.xclasesig.cargarPantalla("Informe Morbilidad EDA");
            }
            if (nodo.getUserObject().toString().equals("Reuniones")) {
                Principal.xclasesgc.cargarPantalla("Reuniones");
            }
            if (nodo.getUserObject().toString().equals("Tratamientos Odontologicos por Facturar")) {
                Principal.xclasesig.cargarPantalla("Tratamientos Odontologicos por Facturar");
            }
            if (nodo.getUserObject().toString().equals("Informe Atenciones Cronicos")) {
                Principal.xclasesig.cargarPantalla("Informe Atenciones Cronicos");
            }
            if (nodo.getUserObject().toString().equals("Informe Duracion de Tratamientos Medicos")) {
                Principal.xclasesig.cargarPantalla("Informe Duracion de Tratamientos Medicos");
            }
            if (nodo.getUserObject().toString().equals("Consolidado de Procedimientos ordenados por usuario")) {
                Principal.xclasesig.cargarPantalla("Consolidado de Procedimientos ordenados por usuario");
            }
            if (nodo.getUserObject().toString().equals("Rips Ministerio(Atenciones Sentencia T-733 de 2017)")) {
                Principal.xclasesig.cargarPantalla("Rips Ministerio(Atenciones Sentencia T-733 de 2017)");
            }
            if (nodo.getUserObject().toString().equals("InformesGeneralesPyP")) {
                Principal.xclasesig.cargarPantalla("InformesGeneralesPyP");
            }
            if (nodo.getUserObject().toString().equals("Informe de Accidentes de Transito")) {
                Principal.xclasesig.cargarPantalla("Informe de Accidentes de Transito");
            }
            if (nodo.getUserObject().toString().equals("Informe Consolidado Por Finalidad")) {
                Principal.xclasesig.cargarPantalla("Informe Consolidado Por Finalidad");
            }
            if (nodo.getUserObject().toString().equals("Informe de Anexos")) {
                Principal.xclasesig.cargarPantalla("Informe de Anexos");
            }
            if (nodo.getUserObject().toString().equals("Informe de Citas Atendidas")) {
                Principal.xclasesig.cargarPantalla("Informe de Citas Atendidas");
            }
            if (nodo.getUserObject().toString().equals("Informe de Interconsultas")) {
                Principal.xclasesig.cargarPantalla("Informe de Interconsultas");
            }
            if (nodo.getUserObject().toString().equals("Informe Oportunidad Atencion 1552")) {
                Principal.xclasesgc.cargarPantalla("Informe Oportunidad Atencion 1552");
            }
            if (nodo.getUserObject().toString().equals("Informe Medicamentos Sivigila")) {
                Principal.xclasesgc.cargarPantalla("Informe Medicamentos Sivigila");
            }
            if (nodo.getUserObject().toString().equals("Informe Produccion Por Sede")) {
                Principal.xclasesig.cargarPantalla("Informe Produccion Por Sede");
            }
            if (nodo.getUserObject().toString().equals("Informe Estadistiaca Citas PyP")) {
                Principal.xclasesgc.cargarPantalla("Informe Estadistiaca Citas PyP");
            }
            if (nodo.getUserObject().toString().equals("Informe SISMED")) {
                Principal.xclasesgc.cargarPantalla("Informe SISMED");
            }
            if (nodo.getUserObject().toString().equals("Informe Planificacion Familias")) {
                Principal.xclasesgc.cargarPantalla("Informe Planificacion Familias");
            }
            if (nodo.getUserObject().toString().equals("Total dias hospitalizados")) {
                Principal.xclasesgc.cargarPantalla("Total dias hospitalizados");
            }
            if (nodo.getUserObject().toString().equals("Informe de camas")) {
                Principal.xclasesgc.cargarPantalla("Informe de camas");
            }
            if (nodo.getUserObject().toString().equals("Pacientes ingresados")) {
                Principal.xclasesgc.cargarPantalla("Pacientes ingresados");
            }
            if (nodo.getUserObject().toString().equals("Pacientes egresados")) {
                Principal.xclasesgc.cargarPantalla("Pacientes egresados");
            }
            if (nodo.getUserObject().toString().equals("Citas no programadas consulta externa")) {
                Principal.xclasesgc.cargarPantalla("Citas no programadas consulta externa");
            }
            if (nodo.getUserObject().toString().equals("Citas programadas")) {
                Principal.xclasesgc.cargarPantalla("Citas programadas");
            }
            if (nodo.getUserObject().toString().equals("Informe de Incapacidades")) {
                Principal.xclasesgc.cargarPantalla("Informe de Incapacidades");
            }
            if (nodo.getUserObject().toString().equals("Informe pacientes facturados con finalidad")) {
                Principal.xclasesgc.cargarPantalla("Informe pacientes facturados con finalidad");
            }
            if (nodo.getUserObject().toString().equals("Indicadores Generales")) {
                Principal.xclasesgc.cargarPantalla("IndicadoresGeneralesOdont");
            }
            if (nodo.getUserObject().toString().equals("Medicamentos Entregados")) {
                Principal.xclasesgc.cargarPantalla("Medicamentos Entregados");
            }
            if (nodo.getUserObject().toString().equals("Ejecucion presupuestal")) {
                Principal.xclasesgc.cargarPantalla("Ejecucion presupuestal");
            }
            if (nodo.getUserObject().toString().equals("Reportes Diarios Consultas")) {
                Principal.xclasesgc.cargarPantalla("Reportes Diarios Consultas");
            }
            if (nodo.getUserObject().toString().equals("Resolucion 2193")) {
                Principal.xclasesgc.cargarPantalla("Resolucion 2193");
            }
            if (nodo.getUserObject().toString().equals("Producción (Resolución 2193)")) {
                Principal.xclasesgc.cargarPantalla("Producción (Resolución 2193)");
            }
            if (nodo.getUserObject().toString().equals("Producción (Resolución 2193) Entidad Privada")) {
                Principal.xclasesgc.cargarPantalla(nodo.getUserObject().toString());
            }
            if (nodo.getUserObject().toString().equals("Consolidado Egresos por Edades")) {
                Principal.xclasesgc.cargarPantalla("Consolidado Egresos por Edades");
            }
            if (nodo.getUserObject().toString().equals("Informe Remisiones")) {
                Principal.xclasesgc.cargarPantalla("Informe Remisiones");
            }
            if (nodo.getUserObject().toString().equals("Informe de Cronicos")) {
                Principal.xclasesgc.cargarPantalla("Informe de Cronicos");
            }
            if (nodo.getUserObject().toString().equals("Informe Diagnostico")) {
                Principal.xclasesgc.cargarPantalla("Informe Diagnostico");
            }
            if (nodo.getUserObject().toString().equals("Consultar Atención por Fecha")) {
                Principal.xclasesgc.cargarPantalla("Consultar Atención por Fecha");
            }
            if (nodo.getUserObject().toString().equals("Auditoría de Procedimientos Facturados Rips")) {
                Principal.xclasesgc.cargarPantalla("Auditoría de Procedimientos Facturados Rips");
            }
            if (nodo.getUserObject().toString().equals("Auditoría de Medicamentos Facturados Rips")) {
                Principal.xclasesgc.cargarPantalla("Auditoría de Medicamentos Facturados Rips");
            }
            if (nodo.getUserObject().toString().equals("Informes PyP")) {
                Principal.xclasesgc.cargarPantalla("Informes PyP");
            }
            if (nodo.getUserObject().toString().equals("Número de Atenciones por Servicio")) {
                Principal.xclasesgc.cargarPantalla("Número de Atenciones por Servicio");
            }
            if (nodo.getUserObject().toString().equals("Información de Facturación Agrupada")) {
                Principal.xclasesgc.cargarPantalla("Información de Facturación Agrupada");
            }
            if (nodo.getUserObject().toString().equals("Informe Citologias")) {
                Principal.xclasesgc.cargarPantalla("Informe Citologias");
            }
            if (nodo.getUserObject().toString().equals("Informe Circular 015(Formato ST006)")) {
                Principal.xclasesgc.cargarPantalla("Informe Circular 015(Formato ST006)");
            }
            if (nodo.getUserObject().toString().equals("Morbilidad Consulta Externa") || nodo.getUserObject().toString().equals("Morbilidad Por Servicio") || nodo.getUserObject().toString().equals("Mortalidad Por Servicio")) {
                Principal.xclasesgc.cargarPantalla(nodo.getUserObject().toString());
            }
            if (nodo.getUserObject().toString().equals("Informe Resolución 1552 (CajaCopi)")) {
                Principal.xclasesgc.cargarPantalla("Resolucion1552CajaCopi");
            }
            if (nodo.getUserObject().toString().equals("Informe Resolución 202")) {
                Principal.xclasesgc.cargarPantalla("Resolucion202");
            }
            if (nodo.getUserObject().toString().equals("Reportes de Facturación")) {
                Principal.xclasesgc.cargarPantalla("ReportesDeFacturacion");
            }
            if (nodo.getUserObject().toString().equals("Informe Salida Administrativa")) {
                Principal.xclasesgc.cargarPantalla("Informe Salida Administrativa");
            }
            if (nodo.getUserObject().toString().equals("Reingreso antes de 72 Horas")) {
                Principal.xclasesig.cargarPantalla(nodo.getUserObject().toString());
            }
            System.out.println("nodo " + nodo.getUserObject().toString().trim());
            if (nodo.getUserObject().toString().trim().equals("Transmision nomina")) {
                Principal.claserecursoshumanos.cargarPantalla("Transmision nomina");
            }
            if (nodo.getUserObject().toString().trim().equals("Seguimiento a servicios ambulatorios")) {
                Principal.xclasesgc.cargarPantalla("Seguimiento a servicios ambulatorios");
            }
            if (nodo.getUserObject().toString().trim().equals("AutoGestión servicios ambulatorios")) {
                Principal.xclasesgc.cargarPantalla("AutoGestión servicios ambulatorios");
            }
        }
    }

    public JPanel buildUi() {
        JPanel treePanel = new JPanel(new BorderLayout());
        treePanel.setBorder(new EmptyBorder(3, 3, 3, 3));
        this.regTree = getTree();
        treePanel.add(new JScrollPane(this.regTree), "Center");
        return treePanel;
    }

    public JPanel buildUiCal() {
        JPanel treePanelCal = new JPanel(new BorderLayout());
        treePanelCal.setBorder(new EmptyBorder(3, 3, 3, 3));
        this.regTreeCal = getTreeCalidad();
        treePanelCal.add(new JScrollPane(this.regTreeCal), "Center");
        return treePanelCal;
    }

    public void exitApp() {
        this.store.closeConnection();
        System.exit(0);
    }

    public void addRegion() {
        JPersistentTree jPersistentTree = this.regTree;
        Integer numValueOf = Integer.valueOf(this.id);
        StringBuilder sbAppend = new StringBuilder().append("new region ");
        int i = this.id;
        this.id = i + 1;
        jPersistentTree.createInSelectedNode(new Region(numValueOf, sbAppend.append(i).toString()));
    }

    public void addRegionCal() {
        JPersistentTree jPersistentTree = this.regTreeCal;
        Integer numValueOf = Integer.valueOf(this.id);
        StringBuilder sbAppend = new StringBuilder().append("new region ");
        int i = this.id;
        this.id = i + 1;
        jPersistentTree.createInSelectedNode(new Region(numValueOf, sbAppend.append(i).toString()));
    }

    private void removeRegion() {
        this.regTree.deleteSelectedNode();
    }

    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if (src instanceof JButton) {
            JButton b = (JButton) src;
            if (b.getText().equalsIgnoreCase(BTN_TXT_ADD)) {
                addRegion();
            } else if (b.getText().equalsIgnoreCase(BTN_TXT_REMOVE)) {
                removeRegion();
            } else {
                if (b.getText().equalsIgnoreCase(BTN_TXT_LICENSE)) {
                }
            }
        }
    }

    public void xkeyPressedCal(KeyEvent ke) {
        if (ke.getKeyCode() == 127) {
            DynamicTreeNode item = (DynamicTreeNode) this.treeCal.getSelectionPath().getLastPathComponent();
            this.xMenuSGCService.mOcultarItemSGC(item.m61getUserObject().getId().toString(), Principal.usuarioSistemaDTO.getIdUsuarioSistema());
        }
    }

    public void xkeyPressedParam(KeyEvent ke) {
        if (ke.getKeyCode() == 127) {
            DynamicTreeNode item = (DynamicTreeNode) this.tree.getSelectionPath().getLastPathComponent();
            this.xMenuParametrizacionService.mOcultarItemParam(item.m61getUserObject().getId().toString(), Principal.usuarioSistemaDTO.getIdUsuarioSistema());
        }
    }

    public void keyTyped(KeyEvent ke) {
    }

    public void keyPressed(KeyEvent ke) {
    }

    public void keyReleased(KeyEvent ke) {
    }
}
