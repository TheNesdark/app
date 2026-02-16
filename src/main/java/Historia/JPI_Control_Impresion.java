package Historia;

import Acceso.Principal;
import Facturacion.Furcen;
import Facturacion.Furips_PA;
import Facturacion.Furips_PA_V2023;
import Facturacion.Furips_PB;
import Facturacion.Furips_PB_Glosa;
import Facturacion.Furips_PB_V2023;
import Facturacion.Furtran;
import General.ClaseImpresionInformes;
import Utilidades.ConsultasMySQL;
import Utilidades.Enviar_Correo_Electronico;
import Utilidades.Metodos;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.genoma.plus.controller.gcuenta.dto.ConvenioDTO;
import com.genoma.plus.controller.general.dto.BitacoraCorreoDto;
import com.genoma.plus.controller.general.dto.CorreosConvenioDto;
import com.genoma.plus.controller.historia.ImpresionAnexo2335;
import com.genoma.plus.controller.laboratorio.dto.CustomPresenter;
import com.genoma.plus.dao.impl.laboratorio.ImpresionReportesDAOImpl;
import com.genoma.plus.domains.models.domains.general.RecursosMicroserviciosDomain;
import com.genoma.plus.dto.soporte_digitalizado.ImpresionReportesDTO;
import com.genoma.plus.jpa.entities.Ingreso;
import com.genoma.plus.jpa.projection.ISoporteCarpetasArchivos;
import com.genoma.plus.jpa.service.ISoporteCarpetasArchivosDAO;
import com.genoma.plus.jpa.service.IngresoService;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
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
import javax.ws.rs.ProcessingException;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;

/* JADX INFO: loaded from: GenomaP.jar:Historia/JPI_Control_Impresion.class */
public class JPI_Control_Impresion extends JPanel implements CorreoListener {
    private String xsql;
    private DefaultTableModel xmodelo;
    private DefaultTableModel xmodelod;
    private DefaultTableModel modeloCorreo;
    private Object[] xdato;
    private String xId_Atencion;
    private String xId_Usuario;
    private String xId_Ingreso;
    private String Xid_TipoAtencion;
    private String correoUsuario;
    private Integer idTipoHistoria;
    private Object[] xDatos;
    private Object[] datosPdf;
    private Object[] datosCorreos;
    private List<ISoporteCarpetasArchivos> listarArchivos;
    private List<Ingreso> ingreso;
    private List<String> listaarchivos;
    private JButton ENVIAR;
    private ButtonGroup JBG_Forma;
    private JCheckBox JCHUnificarReportes;
    private JCheckBox JCH_FiltroProfesional;
    private JCheckBox JCH_Filtro_Seleccion;
    private JCheckBox JCH_Seleccion;
    private JDateChooser JDFechaF;
    private JDateChooser JDFechaI;
    private JPanel JPI_Adicional;
    private JPanel JPI_Detalle;
    private JPanel JPI_FiltroFechas;
    private JPanel JPI_Forma;
    private JRadioButton JRB_EnvioCorreo;
    private JRadioButton JRB_VImpresora;
    private JRadioButton JRB_VPreliminar;
    private JScrollPane JSPDetalle1;
    private JScrollPane JSPDetalleDoc;
    private JTable JTBDetalle;
    private JTable JTBDetalle1;
    private JTable JTCorreos;
    private JTextField JTFCorreo;
    private JTabbedPane JTP_Utilidades;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JScrollPane jScrollPane1;
    private JTabbedPane jTabbedPane1;
    private Metodos xmt = new Metodos();
    private ConsultasMySQL xct = new ConsultasMySQL();
    private int xFiltroProfesional = 1;
    private int xFiltroVista = 0;
    private int xposicion = 0;
    private ImpresionDocumentosHC xImpresionDc = new ImpresionDocumentosHC();
    private Boolean detalle = false;
    private ConsultasMySQL xconsultasbd = new ConsultasMySQL();
    private ConvenioDTO DetalleConvenioDTO = new ConvenioDTO();
    private List<Object[]> listaCorreos = new ArrayList();
    private List<Object[]> listaPdf = new ArrayList();
    private final ISoporteCarpetasArchivosDAO xISoporteCarpetasArchivosDAO = (ISoporteCarpetasArchivosDAO) Principal.contexto.getBean(ISoporteCarpetasArchivosDAO.class);
    private final IngresoService ingresoService = (IngresoService) Principal.contexto.getBean(IngresoService.class);

    public JPI_Control_Impresion(String xId_Atencion, String xId_Usuario, String xId_Ingreso, String xId_TipoAtencion, Integer idTipoHistoria, String correoUsuario) {
        initComponents();
        this.xId_Atencion = xId_Atencion;
        this.xId_Usuario = xId_Usuario;
        this.xId_Ingreso = xId_Ingreso;
        this.idTipoHistoria = idTipoHistoria;
        this.Xid_TipoAtencion = xId_TipoAtencion;
        this.correoUsuario = correoUsuario;
        this.JDFechaI.setDate(this.xmt.getFechaActual());
        this.JDFechaF.setDate(this.xmt.getFechaActual());
        this.xmt.cargarPanelOdontogramaDientes(this.JPI_Forma);
        mCargarDatos();
        if (Principal.informacionIps.getAplicaMicroservicios().booleanValue()) {
            buscarCorreosConvenio();
        }
        mIniciarComponentes();
    }

    /* JADX WARN: Type inference failed for: r3v112, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBG_Forma = new ButtonGroup();
        this.jTabbedPane1 = new JTabbedPane();
        this.JSPDetalleDoc = new JScrollPane();
        this.JTBDetalle = new JTable();
        this.JPI_Detalle = new JPanel();
        this.JSPDetalle1 = new JScrollPane();
        this.JTBDetalle1 = new JTable();
        this.JTP_Utilidades = new JTabbedPane();
        this.jPanel1 = new JPanel();
        this.JPI_Forma = new JPanel();
        this.JRB_VPreliminar = new JRadioButton();
        this.JRB_VImpresora = new JRadioButton();
        this.JRB_EnvioCorreo = new JRadioButton();
        this.JCHUnificarReportes = new JCheckBox();
        this.JPI_FiltroFechas = new JPanel();
        this.JDFechaI = new JDateChooser();
        this.JDFechaF = new JDateChooser();
        this.JCH_FiltroProfesional = new JCheckBox();
        this.JCH_Filtro_Seleccion = new JCheckBox();
        this.JCH_Seleccion = new JCheckBox();
        this.JPI_Adicional = new JPanel();
        this.JTFCorreo = new JTextField();
        this.jPanel2 = new JPanel();
        this.ENVIAR = new JButton();
        this.jScrollPane1 = new JScrollPane();
        this.JTCorreos = new JTable();
        setBorder(BorderFactory.createTitledBorder((Border) null, "IMPRESIÓN CENTRALIZADA DE DOCUMENTOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        setName("xjp_impresion_doc");
        this.jTabbedPane1.setForeground(Color.red);
        this.jTabbedPane1.setFont(new Font("Arial", 1, 14));
        this.JSPDetalleDoc.setBorder((Border) null);
        this.JSPDetalleDoc.addMouseListener(new MouseAdapter() { // from class: Historia.JPI_Control_Impresion.1
            public void mouseClicked(MouseEvent evt) {
                JPI_Control_Impresion.this.JSPDetalleDocMouseClicked(evt);
            }
        });
        this.JTBDetalle.setFont(new Font("Arial", 1, 12));
        this.JTBDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTBDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTBDetalle.setSelectionMode(0);
        this.JTBDetalle.addMouseListener(new MouseAdapter() { // from class: Historia.JPI_Control_Impresion.2
            public void mouseClicked(MouseEvent evt) {
                JPI_Control_Impresion.this.JTBDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalleDoc.setViewportView(this.JTBDetalle);
        this.jTabbedPane1.addTab("INFORMES", this.JSPDetalleDoc);
        this.JSPDetalle1.setBorder((Border) null);
        this.JSPDetalle1.addMouseListener(new MouseAdapter() { // from class: Historia.JPI_Control_Impresion.3
            public void mouseClicked(MouseEvent evt) {
                JPI_Control_Impresion.this.JSPDetalle1MouseClicked(evt);
            }
        });
        this.JTBDetalle1.setFont(new Font("Arial", 1, 12));
        this.JTBDetalle1.setSelectionBackground(new Color(255, 255, 255));
        this.JTBDetalle1.setSelectionForeground(new Color(255, 0, 0));
        this.JSPDetalle1.setViewportView(this.JTBDetalle1);
        GroupLayout JPI_DetalleLayout = new GroupLayout(this.JPI_Detalle);
        this.JPI_Detalle.setLayout(JPI_DetalleLayout);
        JPI_DetalleLayout.setHorizontalGroup(JPI_DetalleLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 876, 32767).addGroup(JPI_DetalleLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPDetalle1, -1, 876, 32767)));
        JPI_DetalleLayout.setVerticalGroup(JPI_DetalleLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 252, 32767).addGroup(JPI_DetalleLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPDetalle1, GroupLayout.Alignment.TRAILING, -1, 246, 32767)));
        this.jTabbedPane1.addTab("DETALLE", this.JPI_Detalle);
        this.JTP_Utilidades.setForeground(new Color(0, 103, 0));
        this.JTP_Utilidades.setFont(new Font("Arial", 1, 14));
        this.JPI_Forma.setBorder(BorderFactory.createTitledBorder((Border) null, "FORMA", 0, 0, new Font("Arial", 1, 14), Color.blue));
        this.JBG_Forma.add(this.JRB_VPreliminar);
        this.JRB_VPreliminar.setFont(new Font("Arial", 1, 12));
        this.JRB_VPreliminar.setSelected(true);
        this.JRB_VPreliminar.setText("Vista Preliminar");
        this.JRB_VPreliminar.addActionListener(new ActionListener() { // from class: Historia.JPI_Control_Impresion.4
            public void actionPerformed(ActionEvent evt) {
                JPI_Control_Impresion.this.JRB_VPreliminarActionPerformed(evt);
            }
        });
        this.JBG_Forma.add(this.JRB_VImpresora);
        this.JRB_VImpresora.setFont(new Font("Arial", 1, 12));
        this.JRB_VImpresora.setText("Impresora");
        this.JRB_VImpresora.addActionListener(new ActionListener() { // from class: Historia.JPI_Control_Impresion.5
            public void actionPerformed(ActionEvent evt) {
                JPI_Control_Impresion.this.JRB_VImpresoraActionPerformed(evt);
            }
        });
        this.JBG_Forma.add(this.JRB_EnvioCorreo);
        this.JRB_EnvioCorreo.setFont(new Font("Arial", 1, 12));
        this.JRB_EnvioCorreo.setText("Enviar por Correo");
        this.JRB_EnvioCorreo.addActionListener(new ActionListener() { // from class: Historia.JPI_Control_Impresion.6
            public void actionPerformed(ActionEvent evt) {
                JPI_Control_Impresion.this.JRB_EnvioCorreoActionPerformed(evt);
            }
        });
        this.JCHUnificarReportes.setFont(new Font("Arial", 1, 12));
        this.JCHUnificarReportes.setText("Unificar Reportes");
        this.JCHUnificarReportes.addActionListener(new ActionListener() { // from class: Historia.JPI_Control_Impresion.7
            public void actionPerformed(ActionEvent evt) {
                JPI_Control_Impresion.this.JCHUnificarReportesActionPerformed(evt);
            }
        });
        GroupLayout JPI_FormaLayout = new GroupLayout(this.JPI_Forma);
        this.JPI_Forma.setLayout(JPI_FormaLayout);
        JPI_FormaLayout.setHorizontalGroup(JPI_FormaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_FormaLayout.createSequentialGroup().addGap(19, 19, 19).addComponent(this.JRB_VPreliminar).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRB_VImpresora).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRB_EnvioCorreo).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JCHUnificarReportes).addContainerGap()));
        JPI_FormaLayout.setVerticalGroup(JPI_FormaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_FormaLayout.createSequentialGroup().addContainerGap().addGroup(JPI_FormaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRB_VPreliminar).addComponent(this.JRB_VImpresora).addComponent(this.JRB_EnvioCorreo).addComponent(this.JCHUnificarReportes)).addContainerGap(-1, 32767)));
        this.JPI_FiltroFechas.setBorder(BorderFactory.createTitledBorder((Border) null, "Filtro por fecha(Evoluciones)", 0, 0, new Font("Arial", 1, 14), Color.red));
        this.JDFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFechaI.setFont(new Font("Arial", 1, 12));
        this.JDFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Fin", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFechaF.setFont(new Font("Arial", 1, 12));
        this.JCH_FiltroProfesional.setFont(new Font("Arial", 1, 12));
        this.JCH_FiltroProfesional.setSelected(true);
        this.JCH_FiltroProfesional.setText("Filtro Profesional?");
        this.JCH_FiltroProfesional.addActionListener(new ActionListener() { // from class: Historia.JPI_Control_Impresion.8
            public void actionPerformed(ActionEvent evt) {
                JPI_Control_Impresion.this.JCH_FiltroProfesionalActionPerformed(evt);
            }
        });
        this.JCH_Filtro_Seleccion.setFont(new Font("Arial", 1, 12));
        this.JCH_Filtro_Seleccion.setSelected(true);
        this.JCH_Filtro_Seleccion.setText("Mostrar Todo?");
        this.JCH_Filtro_Seleccion.addActionListener(new ActionListener() { // from class: Historia.JPI_Control_Impresion.9
            public void actionPerformed(ActionEvent evt) {
                JPI_Control_Impresion.this.JCH_Filtro_SeleccionActionPerformed(evt);
            }
        });
        this.JCH_Seleccion.setFont(new Font("Arial", 1, 12));
        this.JCH_Seleccion.setSelected(true);
        this.JCH_Seleccion.setText("Quitar Selección");
        this.JCH_Seleccion.addActionListener(new ActionListener() { // from class: Historia.JPI_Control_Impresion.10
            public void actionPerformed(ActionEvent evt) {
                JPI_Control_Impresion.this.JCH_SeleccionActionPerformed(evt);
            }
        });
        GroupLayout JPI_FiltroFechasLayout = new GroupLayout(this.JPI_FiltroFechas);
        this.JPI_FiltroFechas.setLayout(JPI_FiltroFechasLayout);
        JPI_FiltroFechasLayout.setHorizontalGroup(JPI_FiltroFechasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_FiltroFechasLayout.createSequentialGroup().addContainerGap().addComponent(this.JDFechaI, -2, 121, -2).addGap(18, 18, 18).addComponent(this.JDFechaF, -2, 121, -2).addGap(59, 59, 59).addComponent(this.JCH_FiltroProfesional).addGap(18, 18, 18).addComponent(this.JCH_Filtro_Seleccion).addGap(51, 51, 51).addComponent(this.JCH_Seleccion).addContainerGap(105, 32767)));
        JPI_FiltroFechasLayout.setVerticalGroup(JPI_FiltroFechasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPI_FiltroFechasLayout.createSequentialGroup().addContainerGap().addGroup(JPI_FiltroFechasLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JDFechaI, -1, -1, 32767).addComponent(this.JDFechaF, -1, -1, 32767)).addContainerGap()).addGroup(JPI_FiltroFechasLayout.createSequentialGroup().addGap(17, 17, 17).addGroup(JPI_FiltroFechasLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCH_FiltroProfesional).addComponent(this.JCH_Filtro_Seleccion).addComponent(this.JCH_Seleccion)).addContainerGap(-1, 32767)));
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPI_FiltroFechas, -1, -1, 32767).addComponent(this.JPI_Forma, -1, -1, 32767)).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.JPI_FiltroFechas, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPI_Forma, -2, -1, -2).addContainerGap()));
        this.JTP_Utilidades.addTab("UTILIDAD", this.jPanel1);
        this.JTFCorreo.setFont(new Font("Arial", 1, 12));
        this.JTFCorreo.setBorder(BorderFactory.createTitledBorder((Border) null, "Correo Electrónico", 0, 0, new Font("Arial", 1, 12)));
        GroupLayout JPI_AdicionalLayout = new GroupLayout(this.JPI_Adicional);
        this.JPI_Adicional.setLayout(JPI_AdicionalLayout);
        JPI_AdicionalLayout.setHorizontalGroup(JPI_AdicionalLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_AdicionalLayout.createSequentialGroup().addContainerGap().addComponent(this.JTFCorreo, -2, 855, -2).addContainerGap(15, 32767)));
        JPI_AdicionalLayout.setVerticalGroup(JPI_AdicionalLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_AdicionalLayout.createSequentialGroup().addGap(22, 22, 22).addComponent(this.JTFCorreo, -2, 50, -2).addGap(176, 176, 176)));
        this.JTP_Utilidades.addTab("ADICIONAL", this.JPI_Adicional);
        this.ENVIAR.setFont(new Font("Arial", 1, 14));
        this.ENVIAR.setIcon(new ImageIcon(getClass().getResource("/Imagenes/enviar.png")));
        this.ENVIAR.setText("Enviar");
        this.ENVIAR.addActionListener(new ActionListener() { // from class: Historia.JPI_Control_Impresion.11
            public void actionPerformed(ActionEvent evt) {
                JPI_Control_Impresion.this.ENVIARActionPerformed(evt);
            }
        });
        this.JTCorreos.setFont(new Font("Arial", 1, 14));
        this.JTCorreos.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.jScrollPane1.setViewportView(this.JTCorreos);
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGap(15, 15, 15).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.ENVIAR, -1, -1, 32767).addComponent(this.jScrollPane1, -1, 843, 32767)).addContainerGap(18, 32767)));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane1, -2, 117, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.ENVIAR, -2, 50, -2).addContainerGap()));
        this.JTP_Utilidades.addTab("ENVIO EPS", this.jPanel2);
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jTabbedPane1).addComponent(this.JTP_Utilidades, -2, 0, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jTabbedPane1, -2, 279, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTP_Utilidades, -2, 225, -2).addContainerGap(-1, 32767)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_SeleccionActionPerformed(ActionEvent evt) {
        if (this.JCH_Seleccion.isSelected()) {
            this.JCH_Seleccion.setText("Quitar Seleccción");
            mCargarDatos();
            return;
        }
        this.JCH_Seleccion.setText("Asignar Seleccción");
        for (int x = 0; x < this.JTBDetalle.getRowCount(); x++) {
            this.xmodelo.setValueAt(false, x, 4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_FiltroProfesionalActionPerformed(ActionEvent evt) {
        if (this.JCH_FiltroProfesional.isSelected()) {
            this.xFiltroProfesional = 1;
        } else {
            this.xFiltroProfesional = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_Filtro_SeleccionActionPerformed(ActionEvent evt) {
        if (this.JCH_Filtro_Seleccion.isSelected()) {
            this.JCH_Filtro_Seleccion.setText("Filtrado?");
            mCargarDatos();
            return;
        }
        this.JCH_Filtro_Seleccion.setText("Mostrar Todo?");
        int xnfila = this.JTBDetalle.getRowCount();
        int x = 0;
        while (x < xnfila) {
            if (!Boolean.valueOf(this.JTBDetalle.getValueAt(x, 7).toString()).booleanValue()) {
                this.xmodelo.removeRow(x);
                x--;
                xnfila--;
            }
            x++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_VPreliminarActionPerformed(ActionEvent evt) {
        this.xFiltroVista = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_VImpresoraActionPerformed(ActionEvent evt) {
        this.xFiltroVista = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_EnvioCorreoActionPerformed(ActionEvent evt) {
        this.xFiltroVista = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ENVIARActionPerformed(ActionEvent evt) {
        eviarCorreosEps();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JSPDetalleDocMouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBDetalleMouseClicked(MouseEvent evt) {
        eventoTabla();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHUnificarReportesActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JSPDetalle1MouseClicked(MouseEvent evt) {
    }

    private void eventoTabla() {
        if (this.JTBDetalle.getSelectedRow() == -1 || this.JCHUnificarReportes.isSelected()) {
            return;
        }
        if (Long.valueOf(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 5).toString()).longValue() == 3) {
            if (Boolean.valueOf(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 4).toString()).booleanValue()) {
                mCargarOrdenesFormulaMedica();
                this.jTabbedPane1.setSelectedIndex(1);
                this.detalle = true;
                return;
            }
            return;
        }
        if (Long.valueOf(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 5).toString()).longValue() == 19) {
            if (Boolean.valueOf(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 4).toString()).booleanValue() && this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 2).toString().equals("Ecografias Obstetrica")) {
                mValidar_Detalle_Ecografia();
                this.jTabbedPane1.setSelectedIndex(1);
                this.detalle = true;
                return;
            } else {
                if (Boolean.valueOf(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 4).toString()).booleanValue() && this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 2).toString().equals("Ecografias General")) {
                    mValidar_Detalle_Ecografia_General();
                    this.jTabbedPane1.setSelectedIndex(1);
                    this.detalle = true;
                    return;
                }
                return;
            }
        }
        if (Long.valueOf(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 5).toString()).longValue() == 15) {
            if (Boolean.valueOf(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 4).toString()).booleanValue()) {
                mValidar_Detalle(Integer.valueOf(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 5).toString()).intValue());
                this.jTabbedPane1.setSelectedIndex(1);
                this.detalle = true;
                return;
            }
            return;
        }
        if (Long.valueOf(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 5).toString()).longValue() == 50) {
            if (Boolean.valueOf(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 4).toString()).booleanValue()) {
                mValidar_DetalleConsentimiento();
                this.jTabbedPane1.setSelectedIndex(1);
                this.detalle = true;
                return;
            }
            return;
        }
        if (Long.valueOf(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 5).toString()).longValue() == 13) {
            if (Boolean.valueOf(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 4).toString()).booleanValue()) {
                mValidar_DetalleQx();
                this.jTabbedPane1.setSelectedIndex(1);
                this.detalle = true;
                return;
            }
            return;
        }
        if (Long.valueOf(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 5).toString()).longValue() == 5 || Long.valueOf(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 5).toString()).longValue() == 6 || Long.valueOf(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 5).toString()).longValue() == 7) {
            if (Boolean.valueOf(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 4).toString()).booleanValue()) {
                mValidar_Detalle();
                this.jTabbedPane1.setSelectedIndex(1);
                this.detalle = true;
                return;
            }
            return;
        }
        if (Long.valueOf(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 5).toString()).longValue() == 1 || Long.valueOf(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 5).toString()).longValue() == 2) {
            if (Boolean.valueOf(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 4).toString()).booleanValue()) {
                if (this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 2).toString().equals("FutRips Formato A Glosas") || this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 2).toString().equals("FutRips Formato B Glosas")) {
                    mValidar_Detalle_Evento();
                    this.jTabbedPane1.setSelectedIndex(1);
                    this.detalle = true;
                    return;
                }
                return;
            }
            return;
        }
        if (Long.valueOf(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 5).toString()).longValue() == 20) {
            if (Boolean.valueOf(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 4).toString()).booleanValue() && this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 2).toString().equals("Furtran")) {
                mBuscarFurtran();
                this.jTabbedPane1.setSelectedIndex(1);
                this.detalle = true;
                return;
            } else {
                if (Boolean.valueOf(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 4).toString()).booleanValue() && this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 2).toString().equals("Furtran Glosa")) {
                    mBuscarFurtran();
                    this.jTabbedPane1.setSelectedIndex(1);
                    this.detalle = true;
                    return;
                }
                return;
            }
        }
        if (Long.valueOf(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 5).toString()).longValue() == 61) {
            if (Boolean.valueOf(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 4).toString()).booleanValue()) {
                mCargarOrdenesIncapacidad();
                this.jTabbedPane1.setSelectedIndex(1);
                this.detalle = true;
                return;
            }
            return;
        }
        if (Long.valueOf(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 5).toString()).longValue() == 64) {
            if (Boolean.valueOf(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 4).toString()).booleanValue()) {
                System.out.println("entroooo ");
                mCargarAnexo();
                this.jTabbedPane1.setSelectedIndex(1);
                this.detalle = true;
                return;
            }
            return;
        }
        this.detalle = false;
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTabla() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Modulo", "Nombre", "NReporte", "Visualizar?", "Tipo?", "Sql", "t", "EnviarCorreo?"}) { // from class: Historia.JPI_Control_Impresion.12
            Class[] types = {Long.class, String.class, String.class, String.class, Boolean.class, Long.class, String.class, Boolean.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, true, false, false, false, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTBDetalle.setModel(this.xmodelo);
        this.JTBDetalle.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(1).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(1).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(1).setMaxWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(2).setPreferredWidth(350);
        this.JTBDetalle.getColumnModel().getColumn(3).setPreferredWidth(50);
        this.JTBDetalle.getColumnModel().getColumn(3).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(3).setMaxWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(4).setPreferredWidth(10);
        this.JTBDetalle.getColumnModel().getColumn(5).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(5).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(5).setMaxWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(6).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(6).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(6).setMaxWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(7).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(7).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(7).setMaxWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(8).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(8).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(8).setMaxWidth(0);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTabla_D1() {
        this.xmodelod = new DefaultTableModel(new Object[0], new String[]{"N° Recepción", "Fecha y Hora", "Especialidad", "Profesional", "Visualizar?"}) { // from class: Historia.JPI_Control_Impresion.13
            Class[] types = {Long.class, String.class, String.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTBDetalle1.setModel(this.xmodelod);
        this.JTBDetalle1.getColumnModel().getColumn(0).setPreferredWidth(15);
        this.JTBDetalle1.getColumnModel().getColumn(1).setPreferredWidth(15);
        this.JTBDetalle1.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTBDetalle1.getColumnModel().getColumn(3).setPreferredWidth(200);
        this.JTBDetalle1.getColumnModel().getColumn(4).setPreferredWidth(10);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTabla_Glosas() {
        this.xmodelod = new DefaultTableModel(new Object[0], new String[]{"Id", "N° Radicado", "Fecha", "Concepto", "Visualizar?", "Valor", "EsTransp"}) { // from class: Historia.JPI_Control_Impresion.14
            Class[] types = {Long.class, String.class, String.class, String.class, Boolean.class, Double.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, true, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTBDetalle1.setModel(this.xmodelod);
        this.JTBDetalle1.getColumnModel().getColumn(0).setPreferredWidth(15);
        this.JTBDetalle1.getColumnModel().getColumn(1).setPreferredWidth(15);
        this.JTBDetalle1.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTBDetalle1.getColumnModel().getColumn(3).setPreferredWidth(200);
        this.JTBDetalle1.getColumnModel().getColumn(4).setPreferredWidth(10);
        this.JTBDetalle1.getColumnModel().getColumn(5).setPreferredWidth(10);
        this.JTBDetalle1.getColumnModel().getColumn(6).setPreferredWidth(0);
        this.JTBDetalle1.getColumnModel().getColumn(6).setMinWidth(0);
        this.JTBDetalle1.getColumnModel().getColumn(6).setMaxWidth(0);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTabla_D2() {
        this.xmodelod = new DefaultTableModel(new Object[0], new String[]{"N° Orden", "Fecha", "Servicio", "Especialidad", "Visualizar?", "Profesional", "Id_Servicio"}) { // from class: Historia.JPI_Control_Impresion.15
            Class[] types = {Long.class, String.class, String.class, String.class, Boolean.class, String.class, Long.class};
            boolean[] canEdit = {false, false, false, false, true, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTBDetalle1.setModel(this.xmodelod);
        this.JTBDetalle1.getColumnModel().getColumn(0).setPreferredWidth(15);
        this.JTBDetalle1.getColumnModel().getColumn(1).setPreferredWidth(15);
        this.JTBDetalle1.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTBDetalle1.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTBDetalle1.getColumnModel().getColumn(4).setPreferredWidth(10);
        this.JTBDetalle1.getColumnModel().getColumn(5).setPreferredWidth(150);
        this.JTBDetalle1.getColumnModel().getColumn(6).setPreferredWidth(10);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTabla_Consentimiento() {
        this.xmodelod = new DefaultTableModel(new Object[0], new String[]{"N°", "Consentimiento", "Especialista", "Profesional", "Visualizar?"}) { // from class: Historia.JPI_Control_Impresion.16
            Class[] types = {Long.class, String.class, String.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTBDetalle1.setModel(this.xmodelod);
        this.JTBDetalle1.getColumnModel().getColumn(0).setPreferredWidth(20);
        this.JTBDetalle1.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTBDetalle1.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTBDetalle1.getColumnModel().getColumn(3).setPreferredWidth(200);
        this.JTBDetalle1.getColumnModel().getColumn(4).setPreferredWidth(20);
    }

    /* JADX WARN: Finally extract failed */
    private void mCargarDatos() {
        try {
            mCrearTabla();
            if (Principal.informacionIps.getAplicaVisualizarAgendasNuevas().booleanValue()) {
                this.xsql = "SELECT `g_reportes`.`Id` , 'HISTORIA CLINICA'  , `g_reportes`.`Nbre` , `g_reportes`.`NReporte`, `g_reportes`.`Especial`, if(`g_reportes`.`Sql` is null, '',`g_reportes`.`Sql`) AS Id_Sql, g_reportes.enviarCorreoElectronico FROM  `g_reportes_tipohistoria` INNER JOIN `g_reportes`  ON (`g_reportes_tipohistoria`.`idReporte` = `g_reportes`.`Id`) WHERE (`g_reportes_tipohistoria`.idTipoHistoria =" + this.idTipoHistoria + " and `g_reportes_tipohistoria`.`Estado` =1 and g_reportes.`Estado` =1 ) ORDER BY  `g_reportes`.`Nbre` ASC ";
            } else {
                this.xsql = "SELECT `g_reportes`.`Id` , `g_modulos`.`Nbre`  , `g_reportes`.`Nbre` , `g_reportes`.`NReporte`, `g_reportes`.`Especial`, if(`g_reportes`.`Sql` is null, '',`g_reportes`.`Sql`) AS Id_Sql, g_reportes.enviarCorreoElectronico  FROM  `g_reportexmodulo` INNER JOIN `g_reportes`  ON (`g_reportexmodulo`.`Id_Reporte` = `g_reportes`.`Id`) INNER JOIN  `g_modulos`  ON (`g_reportexmodulo`.`Id_Modulo` = `g_modulos`.`Id`) WHERE (`g_reportes`.`Tipo` ='" + Principal.informacionIps.getEsFpz() + "' AND `g_reportes`.`Estado` =1 ) ORDER BY `g_modulos`.`Nbre` ASC, `g_reportes`.`Nbre` ASC ";
            }
            System.out.println("consulta inicial -> " + this.xsql);
            ResultSet xrs = this.xct.traerRs(this.xsql);
            Throwable th = null;
            try {
                if (xrs.next()) {
                    int xfila = 0;
                    xrs.beforeFirst();
                    while (xrs.next()) {
                        this.xmodelo.addRow(this.xdato);
                        this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(1)), xfila, 0);
                        this.xmodelo.setValueAt(xrs.getString(2), xfila, 1);
                        this.xmodelo.setValueAt(xrs.getString(3), xfila, 2);
                        this.xmodelo.setValueAt(xrs.getString(4), xfila, 3);
                        this.xmodelo.setValueAt(Boolean.valueOf(mConsultar_Datos(xrs.getString("Id_Sql"), xfila, xrs.getInt("Especial"))), xfila, 4);
                        this.xmodelo.setValueAt(xrs.getString(5), xfila, 5);
                        this.xmodelo.setValueAt(xrs.getString("Id_Sql"), xfila, 6);
                        this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean("enviarCorreoElectronico")), xfila, 8);
                        this.JTBDetalle.setDefaultRenderer(Object.class, new MiRender());
                        xfila++;
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
            Logger.getLogger(JPI_Control_Impresion.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mImprimir() {
        String[][] mparametros = new String[8][2];
        mparametros[0][0] = "idatencion1";
        mparametros[0][1] = this.xId_Atencion;
        mparametros[1][0] = "idpaciente1";
        mparametros[1][1] = this.xId_Usuario;
        mparametros[2][0] = "idingreso";
        mparametros[2][1] = this.xId_Ingreso;
        mparametros[3][0] = "SUBREPORT_DIR";
        mparametros[3][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
        mparametros[4][0] = "SUBREPORTFIRMA_DIR";
        mparametros[4][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
        mparametros[5][0] = "tituloReporte";
        mparametros[6][0] = "nbreUsuario";
        mparametros[6][1] = Principal.usuarioSistemaDTO.getNombreUsuario();
        mparametros[7][0] = "SO";
        mparametros[7][1] = this.xmt.getSO();
        ImpresionDocumentosHC impresionDocumentos = new ImpresionDocumentosHC();
        if (!this.JCHUnificarReportes.isSelected()) {
            if (this.jTabbedPane1.getSelectedIndex() == 0) {
                if (!this.detalle.booleanValue()) {
                    for (int x = 0; x < this.JTBDetalle.getRowCount(); x++) {
                        this.xposicion = x;
                        if (this.JRB_EnvioCorreo.isSelected()) {
                            this.xmt.mEliminarArchivo(new File(this.xmt.getRutaRep() + this.xmodelo.getValueAt(x, 3).toString() + ".pdf"));
                        }
                        mparametros[5][1] = this.xmodelo.getValueAt(x, 1).toString();
                        if (Boolean.valueOf(this.xmodelo.getValueAt(x, 4).toString()).booleanValue()) {
                            System.err.println("this.xmodelo.getValueAt(x, 5).toString()" + this.xmodelo.getValueAt(x, 5).toString());
                            if (Long.valueOf(this.xmodelo.getValueAt(x, 5).toString()).longValue() == 0) {
                                if (this.JRB_VPreliminar.isSelected()) {
                                    this.xmt.GenerarPDF(this.xmt.getRutaRep() + this.xmodelo.getValueAt(x, 3).toString(), mparametros);
                                } else if (this.JRB_VImpresora.isSelected()) {
                                    this.xmt.PresentacionImpresora(this.xmt.getRutaRep() + this.xmodelo.getValueAt(x, 3).toString() + ".jasper", mparametros);
                                } else {
                                    this.xmt.EnviarPDFGeneradoHC(this.xmodelo.getValueAt(x, 2).toString(), this.xmt.getRutaRep() + this.xmodelo.getValueAt(x, 3).toString(), mparametros, true, Boolean.valueOf(this.xmodelo.getValueAt(x, 8).toString()).booleanValue(), this.correoUsuario, Principal.informacionGeneralPrincipalDTO.getIdModulo());
                                }
                                Principal.mGrabarLogAtenciones(this.xmodelo.getValueAt(x, 3).toString(), this.xId_Atencion, String.valueOf(this.xId_Usuario));
                            } else if (Long.valueOf(this.xmodelo.getValueAt(x, 5).toString()).longValue() == 1) {
                                mImprimirEvento(1L, true, 1);
                            } else if (Long.valueOf(this.xmodelo.getValueAt(x, 5).toString()).longValue() == 2) {
                                mImprimirEvento(2L, true, 1);
                            } else if (Long.valueOf(this.xmodelo.getValueAt(x, 5).toString()).longValue() == 11 && !Principal.informacionIps.getNombreIps().equals("FUNDACIÓN PANZENÚ")) {
                                mImprimirEvento(1L, true, 2);
                            } else if (Long.valueOf(this.xmodelo.getValueAt(x, 5).toString()).longValue() == 12 && !Principal.informacionIps.getNombreIps().equals("FUNDACIÓN PANZENÚ")) {
                                mImprimirEvento(2L, true, 2);
                            } else if (Long.valueOf(this.xmodelo.getValueAt(x, 5).toString()).longValue() == 3) {
                                mImprimir_Formula("0");
                            } else if (Long.valueOf(this.xmodelo.getValueAt(x, 5).toString()).longValue() == 4) {
                                mImprimir_CTC();
                            } else if (Long.valueOf(this.xmodelo.getValueAt(x, 5).toString()).longValue() == 5) {
                                mImprimir_AyudaDx(1);
                            } else if (Long.valueOf(this.xmodelo.getValueAt(x, 5).toString()).longValue() == 6) {
                                mImprimir_AyudaDx_Anexo3(1, "0", 0);
                            } else if (Long.valueOf(this.xmodelo.getValueAt(x, 5).toString()).longValue() == 7) {
                                mImprimir_AyudaDx_Anexo3(0, "0", 0);
                            } else if (Long.valueOf(this.xmodelo.getValueAt(x, 5).toString()).longValue() == 8) {
                                Imprimir_Remision(0);
                            } else if (Long.valueOf(this.xmodelo.getValueAt(x, 5).toString()).longValue() == 9) {
                                Imprimir_Remision(1);
                            } else if (Long.valueOf(this.xmodelo.getValueAt(x, 5).toString()).longValue() == 10) {
                                mImprimeHistoriaOdontologia();
                                Principal.mGrabarLogAtenciones(this.xmodelo.getValueAt(x, 3).toString(), this.xId_Atencion, String.valueOf(this.xId_Usuario));
                            } else if (Long.valueOf(this.xmodelo.getValueAt(x, 5).toString()).longValue() == 11) {
                                mImprimeHistoriaSO();
                                Principal.mGrabarLogAtenciones(this.xmodelo.getValueAt(x, 3).toString(), this.xId_Atencion, String.valueOf(this.xId_Usuario));
                            } else if (Long.valueOf(this.xmodelo.getValueAt(x, 5).toString()).longValue() == 12) {
                                if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL LOCAL DE MONTELIBANO")) {
                                    Imprimir_Remision(1);
                                } else {
                                    mImprimir_Anexo3_Interconsulta();
                                }
                            } else if (Long.valueOf(this.xmodelo.getValueAt(x, 5).toString()).longValue() == 13 || Long.valueOf(this.xmodelo.getValueAt(x, 5).toString()).longValue() == 65) {
                                mImprir_InformeQx(x);
                            } else if (Long.valueOf(this.xmodelo.getValueAt(x, 5).toString()).longValue() == 14) {
                                mImprimir_Autorizacion(this.xmodelo.getValueAt(x, 3).toString(), this.xId_Ingreso);
                            } else if (Long.valueOf(this.xmodelo.getValueAt(x, 5).toString()).longValue() == 16) {
                                mImprimir_EpHosp(x);
                                Principal.mGrabarLogAtenciones(this.xmodelo.getValueAt(x, 3).toString(), this.xId_Atencion, String.valueOf(this.xId_Usuario));
                            } else if (Long.valueOf(this.xmodelo.getValueAt(x, 5).toString()).longValue() == 17) {
                                mImprir_Hc(x);
                                Principal.mGrabarLogAtenciones(this.xmodelo.getValueAt(x, 3).toString(), this.xId_Atencion, String.valueOf(this.xId_Usuario));
                            } else if (Long.valueOf(this.xmodelo.getValueAt(x, 5).toString()).longValue() == 18) {
                                mImprir_HcNacimiento(x);
                                Principal.mGrabarLogAtenciones(this.xmodelo.getValueAt(x, 3).toString(), this.xId_Atencion, String.valueOf(this.xId_Usuario));
                            } else if (Long.valueOf(this.xmodelo.getValueAt(x, 5).toString()).longValue() == 30) {
                                mImprimir_HC_IntervaloFecha(x, 0);
                                Principal.mGrabarLogAtenciones(this.xmodelo.getValueAt(x, 3).toString(), this.xId_Atencion, String.valueOf(this.xId_Usuario));
                            } else if (Long.valueOf(this.xmodelo.getValueAt(x, 5).toString()).longValue() == 31) {
                                mImprimir_HC_IntervaloFecha(x, 1);
                                Principal.mGrabarLogAtenciones(this.xmodelo.getValueAt(x, 3).toString(), this.xId_Atencion, String.valueOf(this.xId_Usuario));
                            } else if (Long.valueOf(this.xmodelo.getValueAt(x, 5).toString()).longValue() == 50) {
                                impresionDocumentos.imprimirConsentimientoInformado(this.JTBDetalle1.getValueAt(this.JTBDetalle1.getSelectedRow(), 0).toString());
                            } else if (Long.valueOf(this.xmodelo.getValueAt(x, 5).toString()).longValue() == 40) {
                                impresionDocumentos.mImprimirNotasClinciasNuevas("2,4,5,7", this.xmodelo.getValueAt(x, 2).toString().toUpperCase(), this.xmodelo.getValueAt(x, 3).toString(), this.xFiltroVista, this.xId_Atencion, this.xId_Usuario, this.xId_Ingreso, Boolean.valueOf(this.xmodelo.getValueAt(x, 8).toString()).booleanValue(), this.correoUsuario);
                            } else if (Long.valueOf(this.xmodelo.getValueAt(x, 5).toString()).longValue() == 41) {
                                impresionDocumentos.mImprimirNotasClinciasNuevas("3", this.xmodelo.getValueAt(x, 2).toString().toUpperCase(), this.xmodelo.getValueAt(x, 3).toString(), this.xFiltroVista, this.xId_Atencion, this.xId_Usuario, this.xId_Ingreso, Boolean.valueOf(this.xmodelo.getValueAt(x, 8).toString()).booleanValue(), this.correoUsuario);
                            } else if (Long.valueOf(this.xmodelo.getValueAt(x, 5).toString()).longValue() == 42) {
                                impresionDocumentos.mImprimirNotasClinciasNuevas("5", this.xmodelo.getValueAt(x, 2).toString().toUpperCase(), this.xmodelo.getValueAt(x, 3).toString(), this.xFiltroVista, this.xId_Atencion, this.xId_Usuario, this.xId_Ingreso, Boolean.valueOf(this.xmodelo.getValueAt(x, 8).toString()).booleanValue(), this.correoUsuario);
                            } else if (Long.valueOf(this.xmodelo.getValueAt(x, 5).toString()).longValue() == 43) {
                                impresionDocumentos.mImprimirNotasClinciasNuevas("6", this.xmodelo.getValueAt(x, 2).toString().toUpperCase(), this.xmodelo.getValueAt(x, 3).toString(), this.xFiltroVista, this.xId_Atencion, this.xId_Usuario, this.xId_Ingreso, Boolean.valueOf(this.xmodelo.getValueAt(x, 8).toString()).booleanValue(), this.correoUsuario);
                            } else if (Long.valueOf(this.xmodelo.getValueAt(x, 5).toString()).longValue() == 44) {
                                impresionDocumentos.mImprimirNotasClinciasNuevas("7,13", this.xmodelo.getValueAt(x, 2).toString().toUpperCase(), this.xmodelo.getValueAt(x, 3).toString(), this.xFiltroVista, this.xId_Atencion, this.xId_Usuario, this.xId_Ingreso, Boolean.valueOf(this.xmodelo.getValueAt(x, 8).toString()).booleanValue(), this.correoUsuario);
                            } else if (Long.valueOf(this.xmodelo.getValueAt(x, 5).toString()).longValue() == 45) {
                                impresionDocumentos.mImprimirNotasClinciasNuevas("8", this.xmodelo.getValueAt(x, 2).toString().toUpperCase(), this.xmodelo.getValueAt(x, 3).toString(), this.xFiltroVista, this.xId_Atencion, this.xId_Usuario, this.xId_Ingreso, Boolean.valueOf(this.xmodelo.getValueAt(x, 8).toString()).booleanValue(), this.correoUsuario);
                            } else if (Long.valueOf(this.xmodelo.getValueAt(x, 5).toString()).longValue() == 46) {
                                this.xImpresionDc.mGenerarGraficas("4", this.xId_Usuario, this.xId_Atencion);
                                impresionDocumentos.mImprimirNotasClinciasNuevas("0", this.xmodelo.getValueAt(x, 2).toString().toUpperCase(), this.xmodelo.getValueAt(x, 3).toString(), this.xFiltroVista, this.xId_Atencion, this.xId_Usuario, this.xId_Ingreso, Boolean.valueOf(this.xmodelo.getValueAt(x, 8).toString()).booleanValue(), this.correoUsuario);
                            } else if (Long.valueOf(this.xmodelo.getValueAt(x, 5).toString()).longValue() == 47) {
                                this.xImpresionDc.mGenerarGraficas("3", this.xId_Usuario, this.xId_Atencion);
                                impresionDocumentos.mImprimirNotasClinciasNuevas("0", this.xmodelo.getValueAt(x, 2).toString().toUpperCase(), this.xmodelo.getValueAt(x, 3).toString(), this.xFiltroVista, this.xId_Atencion, this.xId_Usuario, this.xId_Ingreso, Boolean.valueOf(this.xmodelo.getValueAt(x, 8).toString()).booleanValue(), this.correoUsuario);
                            } else if (Long.valueOf(this.xmodelo.getValueAt(x, 5).toString()).longValue() == 48) {
                                this.xImpresionDc.GenerarCLAP(this.xId_Usuario, this.xId_Atencion);
                            } else if (Long.valueOf(this.xmodelo.getValueAt(x, 5).toString()).longValue() == 60) {
                                ClaseImpresionInformes impresionInformes = new ClaseImpresionInformes();
                                impresionInformes.imprimirTestRespiratorio(this.xId_Ingreso);
                            } else if (Long.valueOf(this.xmodelo.getValueAt(x, 5).toString()).longValue() == 60) {
                                ClaseImpresionInformes impresionInformes2 = new ClaseImpresionInformes();
                                impresionInformes2.imprimirTestRespiratorio(this.xId_Ingreso);
                            } else if (Long.valueOf(this.xmodelo.getValueAt(x, 5).toString()).longValue() == 65) {
                                imprimirAtencionParto(x);
                            } else if (Long.valueOf(this.xmodelo.getValueAt(x, 5).toString()).longValue() == 66) {
                                mImprimirEvento(1L, true, 2);
                            } else if (Long.valueOf(this.xmodelo.getValueAt(x, 5).toString()).longValue() == 67) {
                                mImprimirEvento(2L, true, 2);
                            } else if (Long.valueOf(this.xmodelo.getValueAt(x, 5).toString()).longValue() == 68) {
                                impresionDocumentos.mImprimirNotasClinciasNuevas("11", this.xmodelo.getValueAt(x, 2).toString().toUpperCase(), this.xmodelo.getValueAt(x, 3).toString(), this.xFiltroVista, this.xId_Atencion, this.xId_Usuario, this.xId_Ingreso, Boolean.valueOf(this.xmodelo.getValueAt(x, 8).toString()).booleanValue(), this.correoUsuario);
                            }
                        }
                    }
                    return;
                }
                JOptionPane.showMessageDialog(this, "Debe seleccionar el detalle a imprimir", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.jTabbedPane1.setSelectedIndex(1);
                return;
            }
            this.xposicion = this.JTBDetalle.getSelectedRow();
            System.out.println("this.detalle -> " + this.detalle);
            if (!this.detalle.booleanValue() || !this.xmt.mVerificarDatosTablaTrue(this.JTBDetalle1, 4)) {
                JOptionPane.showMessageDialog(this, "Debe seleccionar el detalle a imprimir", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.jTabbedPane1.setSelectedIndex(1);
                return;
            }
            if (Long.valueOf(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 5).toString()).longValue() == 20) {
                if (this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 2).toString().equals("Furtran")) {
                    Furtran x2 = new Furtran(this.xmodelod.getValueAt(this.JTBDetalle1.getSelectedRow(), 0).toString(), 0);
                    x2.build();
                } else if (this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 2).toString().equals("Furtran Glosa")) {
                    Furtran x3 = new Furtran(this.xmodelod.getValueAt(this.JTBDetalle1.getSelectedRow(), 0).toString(), 1);
                    x3.build();
                }
                if (this.JRB_VPreliminar.isSelected()) {
                    this.xmt.mostrarPdf(this.xmt.getRutaRep() + "Furtran.pdf");
                    return;
                } else if (this.JRB_VImpresora.isSelected()) {
                    this.xmt.mostrarPdf(this.xmt.getRutaRep() + "Furtran.pdf");
                    return;
                } else {
                    this.xmt.EnviarPDFGeneradoHC(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 2).toString(), this.xmt.getRutaRep() + "Furtran", (String[][]) null, true, Boolean.valueOf(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 8).toString()).booleanValue(), this.correoUsuario, Principal.informacionGeneralPrincipalDTO.getIdModulo());
                    return;
                }
            }
            if (Long.valueOf(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 5).toString()).longValue() == 19) {
                if (this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 2).toString().equals("Ecografias Obstetrica")) {
                    mImprimirEcografia(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 3).toString());
                    return;
                } else {
                    if (this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 2).toString().equals("Ecografias General")) {
                        mImprimirEcografiaGeneral(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 3).toString());
                        return;
                    }
                    return;
                }
            }
            if (Long.valueOf(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 5).toString()).longValue() == 15) {
                mImprimir_RLaboratorio();
                return;
            }
            if (Long.valueOf(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 5).toString()).longValue() == 13) {
                mImprimirInformeQx();
                return;
            }
            if (Long.valueOf(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 5).toString()).longValue() == 50) {
                impresionDocumentos.imprimirConsentimientoInformado(this.JTBDetalle1.getValueAt(this.JTBDetalle1.getSelectedRow(), 0).toString());
                return;
            }
            if (Long.valueOf(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 5).toString()).longValue() == 61) {
                mImprimirInformeIncapacidad();
                return;
            }
            if (Long.valueOf(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 5).toString()).longValue() == 3) {
                mImprimirOrdenFormulaMedica();
                return;
            }
            if (Long.valueOf(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 5).toString()).longValue() != 5 && Long.valueOf(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 5).toString()).longValue() != 6 && Long.valueOf(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 5).toString()).longValue() != 7) {
                if (Long.valueOf(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 5).toString()).longValue() == 1 || Long.valueOf(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 5).toString()).longValue() == 2) {
                    if (Long.valueOf(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 5).toString()).longValue() == 1) {
                        mImprimirEvento(1L, false, 1);
                        return;
                    }
                    if (Long.valueOf(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 5).toString()).longValue() == 2) {
                        mImprimirEvento(2L, false, 1);
                        return;
                    } else if (Long.valueOf(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 5).toString()).longValue() == 11) {
                        mImprimirEvento(1L, false, 2);
                        return;
                    } else {
                        if (Long.valueOf(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 5).toString()).longValue() == 12) {
                            mImprimirEvento(1L, false, 2);
                            return;
                        }
                        return;
                    }
                }
                if (Long.valueOf(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 5).toString()).longValue() == 64) {
                    Object[] botones = {"Anexo 2335", "Cerrar"};
                    if (JOptionPane.showOptionDialog(this, "Que formato desea imprimir?", "VISUALIZAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), botones, "Cerrar") == 0) {
                        for (int x4 = 0; x4 < this.JTBDetalle1.getRowCount(); x4++) {
                            if (Boolean.valueOf(this.xmodelod.getValueAt(x4, 4).toString()).booleanValue()) {
                                ImpresionAnexo2335 ImpresionAnexo2335 = new ImpresionAnexo2335(Long.valueOf(this.xId_Ingreso), Integer.valueOf(Integer.parseInt(this.xmodelod.getValueAt(x4, 5).toString())), Long.valueOf(Long.parseLong(this.xmodelod.getValueAt(x4, 0).toString())));
                                ImpresionAnexo2335.build();
                                this.xmt.mostrarPdf(this.xmt.getRutaRep() + "Anexo1.pdf");
                            }
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            Object[] botones2 = {"Institucional", "Anexo", "Cerrar"};
            int n = JOptionPane.showOptionDialog(this, "Que formato desea imprimir?", "VISUALIZAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), botones2, "Cerrar");
            if (n == 0) {
                for (int x5 = 0; x5 < this.JTBDetalle1.getRowCount(); x5++) {
                    if (Boolean.valueOf(this.xmodelod.getValueAt(x5, 4).toString()).booleanValue()) {
                        if (this.JRB_VImpresora.isSelected()) {
                            this.xImpresionDc.mImprimirOrdenesAyudasDx(1, Integer.valueOf(this.xmodelod.getValueAt(x5, 6).toString()).intValue(), Long.valueOf(this.xmodelod.getValueAt(x5, 0).toString()), 1);
                        } else if (this.JRB_VPreliminar.isSelected()) {
                            this.xImpresionDc.mImprimirOrdenesAyudasDx(1, Integer.valueOf(this.xmodelod.getValueAt(x5, 6).toString()).intValue(), Long.valueOf(this.xmodelod.getValueAt(x5, 0).toString()), 0);
                        }
                    }
                }
                return;
            }
            if (n == 1) {
                if (Long.valueOf(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 5).toString()).longValue() == 7) {
                    String idOrden = "";
                    for (int x6 = 0; x6 < this.JTBDetalle1.getRowCount(); x6++) {
                        if (Boolean.valueOf(this.xmodelod.getValueAt(x6, 4).toString()).booleanValue()) {
                            idOrden = idOrden + "," + this.xmodelod.getValueAt(x6, 0).toString();
                            mImprimir_AyudaDx_Anexo3(0, idOrden.substring(1, idOrden.length()), 1);
                        }
                    }
                    mImprimir_AyudaDx_Anexo3(0, idOrden.substring(1, idOrden.length()), 0);
                    return;
                }
                for (int x7 = 0; x7 < this.JTBDetalle1.getRowCount(); x7++) {
                    if (Boolean.valueOf(this.xmodelod.getValueAt(x7, 4).toString()).booleanValue()) {
                        mImprimir_AyudaDx_Anexo3(0, this.xmodelod.getValueAt(x7, 0).toString(), 1);
                    }
                }
                return;
            }
            return;
        }
        try {
            this.xmt.mEliminarArchivo(new File(this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra() + "Historia Clinica.pdf"));
            mCrearPdf();
            System.out.println("Reports: " + this.listaarchivos.size());
            if (!this.listaarchivos.isEmpty()) {
                this.xmt.unirPDF(this.listaarchivos, this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra(), "Historia Clinica");
                if (this.JRB_VPreliminar.isSelected()) {
                    this.xmt.mostrarPdf(this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra() + "Historia Clinica.pdf");
                } else if (this.JRB_VImpresora.isSelected()) {
                    this.xmt.mImprimePDFSinPreview(this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra() + "Historia Clinica.pdf");
                } else {
                    this.xmt.EnviarPDFGeneradoHC("Historia Clinica", this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra() + "Historia Clinica", mparametros, false, true, this.correoUsuario, Principal.informacionGeneralPrincipalDTO.getIdModulo());
                }
                Principal.mGrabarLogAtenciones("Historia Clinia Unificada", this.xId_Atencion, String.valueOf(this.xId_Usuario));
                for (String listaarchivo : this.listaarchivos) {
                    this.xmt.mEliminarArchivo(new File(listaarchivo));
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(JPI_Control_Impresion.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mIniciarComponentes() {
        switch (Principal.informacionIps.getNombreIps()) {
            case "CLINICA OFTALMOLOGICA DAJUD SAS":
            case "JAIME CESAR DAJUD FERNANDEZ":
            case "COD-OPTICA UT":
                this.JRB_VImpresora.setSelected(true);
                break;
            case "CLINICA PAJONAL S.A.S":
            case "E.S.E. HOSPITAL SAN JUAN DE DIOS":
            case "E.S.E. HOSPITAL SAN JORGE DE AYAPEL":
            case "EMPRESA SOCIAL DEL ESTADO CAMU CHIMA":
                for (int x = 0; x < this.JTBDetalle.getRowCount(); x++) {
                    this.xmodelo.setValueAt(false, x, 4);
                }
                break;
            default:
                this.JRB_VPreliminar.setSelected(true);
                break;
        }
        if (this.correoUsuario != null) {
            boolean isValidacionCorreo = this.xmt.isValidarCorreoElectronicoExpresionRegular(this.correoUsuario);
            if (isValidacionCorreo) {
                this.JTFCorreo.setText(this.correoUsuario);
                switch (Principal.informacionIps.getNombreIps()) {
                    case "CLINICA PAJONAL S.A.S":
                        this.JRB_EnvioCorreo.setSelected(true);
                        break;
                    default:
                        this.JRB_VPreliminar.setSelected(true);
                        break;
                }
            }
        }
    }

    private void mImprimir_EpHosp(int xfila) {
        String[][] mparametros = new String[5][2];
        mparametros[0][0] = "idatencion1";
        mparametros[0][1] = String.valueOf(this.xId_Atencion);
        mparametros[1][0] = "Id_Tipo";
        mparametros[1][1] = this.Xid_TipoAtencion;
        mparametros[2][0] = "SUBREPORT_DIR";
        mparametros[2][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
        mparametros[3][0] = "SUBREPORTFIRMA_DIR";
        mparametros[3][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
        mparametros[4][0] = "nbreUsuario";
        mparametros[4][1] = Principal.usuarioSistemaDTO.getNombreUsuario();
        if (this.JRB_VPreliminar.isSelected()) {
            this.xmt.GenerarPDF(this.xmt.getRutaRep() + this.xmodelo.getValueAt(xfila, 3).toString(), mparametros);
        } else if (this.JRB_VImpresora.isSelected()) {
            this.xmt.PresentacionImpresora(this.xmt.getRutaRep() + this.xmodelo.getValueAt(xfila, 3).toString() + ".jasper", mparametros);
        } else {
            this.xmt.EnviarPDFGeneradoHC(this.xmodelo.getValueAt(this.xposicion, 2).toString(), this.xmt.getRutaRep() + this.xmodelo.getValueAt(xfila, 3).toString(), mparametros, true, Boolean.valueOf(this.xmodelo.getValueAt(this.xposicion, 8).toString()).booleanValue(), this.correoUsuario, Principal.informacionGeneralPrincipalDTO.getIdModulo());
        }
    }

    private void mImprimir_HC_IntervaloFecha(int xfila, int xtipo) {
        String[][] mparametros = new String[7][2];
        mparametros[0][0] = "idatencion1";
        mparametros[0][1] = String.valueOf(this.xId_Atencion);
        mparametros[1][0] = "fechai";
        mparametros[1][1] = this.xmt.formatoAMD1.format(this.JDFechaI.getDate());
        mparametros[2][0] = "SUBREPORT_DIR";
        mparametros[2][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
        mparametros[3][0] = "SUBREPORTFIRMA_DIR";
        mparametros[3][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
        mparametros[4][0] = "fechaf";
        mparametros[4][1] = this.xmt.formatoAMD1.format(this.JDFechaF.getDate());
        mparametros[5][0] = "tipo";
        mparametros[5][1] = String.valueOf(xtipo);
        mparametros[6][0] = "nbreUsuario";
        mparametros[6][1] = Principal.usuarioSistemaDTO.getNombreUsuario();
        if (this.JRB_VPreliminar.isSelected()) {
            this.xmt.GenerarPDF(this.xmt.getRutaRep() + this.xmodelo.getValueAt(xfila, 3).toString(), mparametros);
        } else if (this.JRB_VImpresora.isSelected()) {
            this.xmt.PresentacionImpresora(this.xmt.getRutaRep() + this.xmodelo.getValueAt(xfila, 3).toString() + ".jasper", mparametros);
        } else {
            this.xmt.EnviarPDFGeneradoHC(this.xmodelo.getValueAt(this.xposicion, 2).toString(), this.xmt.getRutaRep() + this.xmodelo.getValueAt(xfila, 3).toString(), mparametros, true, Boolean.valueOf(this.xmodelo.getValueAt(this.xposicion, 8).toString()).booleanValue(), this.correoUsuario, Principal.informacionGeneralPrincipalDTO.getIdModulo());
        }
    }

    private void mImprir_InformeQx(int x) {
        try {
            this.xsql = "SELECT `Id`     FROM `h_orden_qx` WHERE (`Id_Atencion` ='" + this.xId_Atencion + "' AND `Estado` =1 AND IF(`Fecha_Final` IS NULL,0,1)=1) ";
            ResultSet xrs = this.xct.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.beforeFirst();
                while (xrs.next()) {
                    String[][] mparametros = new String[5][2];
                    mparametros[0][0] = "Id";
                    mparametros[0][1] = xrs.getString(1);
                    mparametros[1][0] = "SUBREPORT_DIR";
                    mparametros[1][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
                    mparametros[2][0] = "SUBREPORTFIRMA_DIR";
                    mparametros[2][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
                    mparametros[3][0] = "tituloReporte";
                    mparametros[3][1] = this.xmodelo.getValueAt(x, 2).toString();
                    mparametros[4][0] = "nbreUsuario";
                    mparametros[4][1] = Principal.usuarioSistemaDTO.getNombreUsuario();
                    if (this.JRB_VPreliminar.isSelected()) {
                        this.xmt.GenerarPDF(this.xmt.getRutaRep() + this.xmodelo.getValueAt(x, 3).toString(), mparametros);
                    } else if (this.JRB_VImpresora.isSelected()) {
                        this.xmt.PresentacionImpresora(this.xmt.getRutaRep() + this.xmodelo.getValueAt(x, 3).toString() + ".jasper", mparametros);
                    } else {
                        this.xmt.EnviarPDFGeneradoHC(this.xmodelo.getValueAt(this.xposicion, 2).toString(), this.xmt.getRutaRep() + this.xmodelo.getValueAt(x, 3).toString(), mparametros, true, Boolean.valueOf(this.xmodelo.getValueAt(this.xposicion, 8).toString()).booleanValue(), this.correoUsuario, Principal.informacionGeneralPrincipalDTO.getIdModulo());
                    }
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPI_Control_Impresion.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void imprimirAtencionParto(int x) {
        try {
            this.xsql = "SELECT\n    h_orden_qx.Id\nFROM\n     h_orden_qx_procedimientos\n    INNER JOIN  h_orden_qx \n        ON (h_orden_qx_procedimientos.Id_Orden_Qx = h_orden_qx.Id)\n    INNER JOIN  g_procedimiento \n        ON (h_orden_qx_procedimientos.Id_Procedimiento = g_procedimiento.Id)\nWHERE (g_procedimiento.Id IN(735930, 735910, 7359101, 7353001)\n    AND h_orden_qx.Estado =1 AND IF(h_orden_qx.Fecha_Final IS NULL,0,1)=1\n    AND h_orden_qx.Id_Atencion =" + this.xId_Atencion + ");";
            ResultSet xrs = this.xct.traerRs(this.xsql);
            Throwable th = null;
            try {
                try {
                    if (xrs.next()) {
                        xrs.beforeFirst();
                        while (xrs.next()) {
                            String[][] mparametros = new String[5][2];
                            mparametros[0][0] = "Id";
                            mparametros[0][1] = xrs.getString(1);
                            mparametros[1][0] = "SUBREPORT_DIR";
                            mparametros[1][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
                            mparametros[2][0] = "SUBREPORTFIRMA_DIR";
                            mparametros[2][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
                            mparametros[3][0] = "tituloReporte";
                            mparametros[3][1] = this.xmodelo.getValueAt(x, 2).toString();
                            mparametros[4][0] = "nbreUsuario";
                            mparametros[4][1] = Principal.usuarioSistemaDTO.getNombreUsuario();
                            if (this.JRB_VPreliminar.isSelected()) {
                                this.xmt.GenerarPDF(this.xmt.getRutaRep() + this.xmodelo.getValueAt(x, 3).toString(), mparametros);
                            } else if (this.JRB_VImpresora.isSelected()) {
                                this.xmt.PresentacionImpresora(this.xmt.getRutaRep() + this.xmodelo.getValueAt(x, 3).toString() + ".jasper", mparametros);
                            } else {
                                this.xmt.EnviarPDFGeneradoHC(this.xmodelo.getValueAt(this.xposicion, 2).toString(), this.xmt.getRutaRep() + this.xmodelo.getValueAt(x, 3).toString(), mparametros, true, Boolean.valueOf(this.xmodelo.getValueAt(this.xposicion, 8).toString()).booleanValue(), this.correoUsuario, Principal.informacionGeneralPrincipalDTO.getIdModulo());
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
            } catch (Throwable th3) {
                th = th3;
                throw th3;
            }
        } catch (SQLException ex) {
            Logger.getLogger(JPI_Control_Impresion.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mImprir_Hc(int x) {
        try {
            this.xsql = "SELECT  `h_atencion`.`Id` , `h_tipohistoria`.`Reporte` FROM `h_atencion` INNER JOIN `c_clasecita`  ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`) INNER JOIN `h_tipohistoria`  ON (`c_clasecita`.`Id_Historia` = `h_tipohistoria`.`Id`) WHERE (`h_atencion`.`Codigo_Dxp` <>'' AND `h_atencion`.`TipoGuardado` =1 AND `h_atencion`.`Id` ='" + this.xId_Atencion + "') ";
            ResultSet xrs = this.xct.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.first();
                String[][] mparametros = new String[6][2];
                mparametros[0][0] = "idatencion1";
                mparametros[0][1] = this.xId_Atencion;
                mparametros[1][0] = "idpaciente1";
                mparametros[1][1] = this.xId_Usuario;
                mparametros[2][0] = "idingreso";
                mparametros[2][1] = this.xId_Ingreso;
                mparametros[3][0] = "SUBREPORT_DIR";
                mparametros[3][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
                mparametros[4][0] = "SUBREPORTFIRMA_DIR";
                mparametros[4][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
                mparametros[5][0] = "nbreUsuario";
                mparametros[5][1] = Principal.usuarioSistemaDTO.getNombreUsuario();
                if (this.JRB_VPreliminar.isSelected()) {
                    this.xmt.GenerarPDF(this.xmt.getRutaRep() + xrs.getString(2), mparametros);
                } else if (this.JRB_VImpresora.isSelected()) {
                    this.xmt.PresentacionImpresora(this.xmt.getRutaRep() + xrs.getString(2) + ".jasper", mparametros);
                } else {
                    this.xmt.EnviarPDFGeneradoHC(this.xmodelo.getValueAt(this.xposicion, 2).toString(), this.xmt.getRutaRep() + xrs.getString(2), mparametros, true, Boolean.valueOf(this.xmodelo.getValueAt(this.xposicion, 8).toString()).booleanValue(), this.correoUsuario, Principal.informacionGeneralPrincipalDTO.getIdModulo());
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPI_Control_Impresion.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mImprir_HcNacimiento(int xfila) {
        try {
            this.xsql = "SELECT  `h_atencion`.`Id` , `h_orden_qx_nacido_detalle`.`Id` , `ingreso`.`Id_Usuario` \nFROM   `h_orden_qx` INNER JOIN   `h_atencion`  ON (`h_orden_qx`.`Id_Atencion` = `h_atencion`.`Id`) INNER JOIN   `h_orden_qx_nacidos`  ON (`h_orden_qx_nacidos`.`IdOrdenQx` = `h_orden_qx`.`Id`)\nINNER JOIN   `ingreso`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`) INNER JOIN   `h_orden_qx_nacido_detalle`  ON (`h_orden_qx_nacido_detalle`.`IdEncabezado` = `h_orden_qx_nacidos`.`Id`)\nWHERE (`h_atencion`.`Id` ='" + this.xId_Atencion + "' AND `h_orden_qx`.`Estado` =1) ";
            ResultSet xrs = this.xct.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.first();
                String[][] mparametros = new String[6][2];
                mparametros[0][0] = "idatencion1";
                mparametros[0][1] = xrs.getString(1);
                mparametros[1][0] = "idpaciente1";
                mparametros[1][1] = xrs.getString(3);
                mparametros[2][0] = "ID_RNACIDO";
                mparametros[2][1] = xrs.getString(2);
                mparametros[3][0] = "SUBREPORT_DIR";
                mparametros[3][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
                mparametros[4][0] = "SUBREPORTFIRMA_DIR";
                mparametros[4][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
                mparametros[5][0] = "nbreUsuario";
                mparametros[5][1] = Principal.usuarioSistemaDTO.getNombreUsuario();
                if (this.JRB_VPreliminar.isSelected()) {
                    this.xmt.GenerarPDF(this.xmt.getRutaRep() + this.xmodelo.getValueAt(xfila, 3).toString(), mparametros);
                } else if (this.JRB_VImpresora.isSelected()) {
                    this.xmt.PresentacionImpresora(this.xmt.getRutaRep() + this.xmodelo.getValueAt(xfila, 3).toString() + ".jasper", mparametros);
                } else {
                    this.xmt.EnviarPDFGeneradoHC(this.xmodelo.getValueAt(this.xposicion, 2).toString(), this.xmt.getRutaRep() + this.xmodelo.getValueAt(xfila, 3).toString(), mparametros, true, Boolean.valueOf(this.xmodelo.getValueAt(this.xposicion, 8).toString()).booleanValue(), this.correoUsuario, Principal.informacionGeneralPrincipalDTO.getIdModulo());
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPI_Control_Impresion.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mImprimirEvento(long xtipo, boolean xforma, int version) {
        if (version == 1) {
            try {
                String xsql = "SELECT `Id_Eventoecat`, `Id_Persona`, `Id_Ingreso`, Id FROM `a_eventoecat_paciente` WHERE (`Id_Ingreso` ='" + this.xId_Ingreso + "')";
                ResultSet xrs = this.xct.traerRs(xsql);
                if (xrs.next()) {
                    xrs.first();
                    if (xtipo == 1) {
                        this.xmt.mEliminarArchivo(new File(this.xmt.getRutaRep() + "furipsPA.pdf"));
                        if (xforma) {
                            Furips_PA xfrPA = new Furips_PA(xrs.getString(1), xrs.getString(2), xrs.getString("Id_Ingreso"), "", "");
                            xfrPA.build();
                        } else {
                            Furips_PA xfrPA2 = new Furips_PA(xrs.getString(1), xrs.getString(2), xrs.getString("Id_Ingreso"), this.xmodelod.getValueAt(this.JTBDetalle1.getSelectedRow(), 1).toString(), this.xmodelod.getValueAt(this.JTBDetalle1.getSelectedRow(), 4).toString());
                            xfrPA2.build();
                        }
                        if (this.JRB_VPreliminar.isSelected()) {
                            this.xmt.mostrarPdf(this.xmt.getRutaRep() + "furipsPA.pdf");
                        } else if (!this.JRB_VImpresora.isSelected()) {
                            if (xforma) {
                                this.xmt.EnviarPDFGeneradoHC(this.xmodelo.getValueAt(this.xposicion, 2).toString(), this.xmt.getRutaRep() + "furipsPA", (String[][]) null, false, Boolean.valueOf(this.xmodelo.getValueAt(this.xposicion, 8).toString()).booleanValue(), this.correoUsuario, Principal.informacionGeneralPrincipalDTO.getIdModulo());
                            } else {
                                this.xmt.EnviarPDFGeneradoHC(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 2).toString(), this.xmt.getRutaRep() + "furipsPA", (String[][]) null, false, Boolean.valueOf(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 8).toString()).booleanValue(), this.correoUsuario, Principal.informacionGeneralPrincipalDTO.getIdModulo());
                            }
                        }
                    } else if (xtipo == 2) {
                        this.xmt.mEliminarArchivo(new File(this.xmt.getRutaRep() + "furipsPB.pdf"));
                        if (xforma) {
                            Furips_PB xfr = new Furips_PB(xrs.getString(4), xrs.getString(1), xrs.getString("Id_Ingreso"), "", "", "");
                            xfr.build();
                        } else {
                            double xValorG = 0.0d;
                            double xValorT = 0.0d;
                            for (int x = 0; x < this.JTBDetalle1.getRowCount(); x++) {
                                if (Boolean.valueOf(this.xmodelod.getValueAt(x, 5).toString()).booleanValue()) {
                                    if (Boolean.valueOf(this.xmodelod.getValueAt(x, 6).toString()).booleanValue()) {
                                        xValorT += Double.valueOf(this.xmodelod.getValueAt(x, 4).toString()).doubleValue();
                                    } else {
                                        xValorG += Double.valueOf(this.xmodelod.getValueAt(x, 4).toString()).doubleValue();
                                    }
                                }
                            }
                            Furips_PB_Glosa xfr2 = new Furips_PB_Glosa(xrs.getString(4), xrs.getString(1), xrs.getString("Id_Ingreso"), this.xmodelod.getValueAt(this.JTBDetalle1.getSelectedRow(), 2).toString(), this.xmt.formatoMoneda1.format(xValorG), this.xmodelod.getValueAt(this.JTBDetalle1.getSelectedRow(), 6).toString(), this.xmt.formatoMoneda1.format(xValorT));
                            xfr2.build();
                        }
                        if (this.JRB_VPreliminar.isSelected()) {
                            this.xmt.mostrarPdf(this.xmt.getRutaRep() + "furipsPB.pdf");
                        } else if (!this.JRB_VImpresora.isSelected()) {
                            if (xforma) {
                                this.xmt.EnviarPDFGeneradoHC(this.xmodelo.getValueAt(this.xposicion, 2).toString(), this.xmt.getRutaRep() + "furipsPB", (String[][]) null, false, Boolean.valueOf(this.xmodelo.getValueAt(this.xposicion, 8).toString()).booleanValue(), this.correoUsuario, Principal.informacionGeneralPrincipalDTO.getIdModulo());
                            } else {
                                this.xmt.EnviarPDFGeneradoHC(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 2).toString(), this.xmt.getRutaRep() + "furipsPB", (String[][]) null, false, Boolean.valueOf(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 8).toString()).booleanValue(), this.correoUsuario, Principal.informacionGeneralPrincipalDTO.getIdModulo());
                            }
                        }
                    } else if (xtipo == 3) {
                        this.xmt.mEliminarArchivo(new File(this.xmt.getRutaRep() + "furcen.pdf"));
                        Furcen xfr3 = new Furcen(xrs.getString(1));
                        xfr3.build();
                        if (this.JRB_VPreliminar.isSelected()) {
                            this.xmt.mostrarPdf(this.xmt.getRutaRep() + "furcen.pdf");
                        } else if (!this.JRB_VImpresora.isSelected()) {
                            if (xforma) {
                                this.xmt.EnviarPDFGeneradoHC(this.xmodelo.getValueAt(this.xposicion, 2).toString(), this.xmt.getRutaRep() + "furcen", (String[][]) null, false, Boolean.valueOf(this.xmodelo.getValueAt(this.xposicion, 8).toString()).booleanValue(), this.correoUsuario, Principal.informacionGeneralPrincipalDTO.getIdModulo());
                            } else {
                                this.xmt.EnviarPDFGeneradoHC(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 2).toString(), this.xmt.getRutaRep() + "furcen", (String[][]) null, false, Boolean.valueOf(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 8).toString()).booleanValue(), this.correoUsuario, Principal.informacionGeneralPrincipalDTO.getIdModulo());
                            }
                        }
                    }
                }
                xrs.close();
                this.xct.cerrarConexionBd();
                return;
            } catch (SQLException ex) {
                Logger.getLogger(JPI_Control_Impresion.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                return;
            }
        }
        try {
            String xsql2 = "SELECT `Id_Eventoecat`, `Id_Persona`, `Id_Ingreso`, Id FROM `a_eventoecat_paciente` WHERE (`Id_Ingreso` ='" + this.xId_Ingreso + "')";
            ResultSet xrs2 = this.xct.traerRs(xsql2);
            if (xrs2.next()) {
                xrs2.first();
                if (xtipo == 1) {
                    this.xmt.mEliminarArchivo(new File(this.xmt.getRutaRep() + "furipsPA_v2023.pdf"));
                    if (xforma) {
                        Furips_PA_V2023 xfrPA3 = new Furips_PA_V2023(xrs2.getString(1), xrs2.getString(2), xrs2.getString("Id_Ingreso"), "", "");
                        xfrPA3.build();
                    } else {
                        Furips_PA_V2023 xfrPA4 = new Furips_PA_V2023(xrs2.getString(1), xrs2.getString(2), xrs2.getString("Id_Ingreso"), this.xmodelod.getValueAt(this.JTBDetalle1.getSelectedRow(), 1).toString(), this.xmodelod.getValueAt(this.JTBDetalle1.getSelectedRow(), 4).toString());
                        xfrPA4.build();
                    }
                    if (this.JRB_VPreliminar.isSelected()) {
                        this.xmt.mostrarPdf(this.xmt.getRutaRep() + "furipsPA_v2023.pdf");
                    } else if (!this.JRB_VImpresora.isSelected()) {
                        if (xforma) {
                            this.xmt.EnviarPDFGeneradoHC(this.xmodelo.getValueAt(this.xposicion, 2).toString(), this.xmt.getRutaRep() + "furipsPA_v2023", (String[][]) null, false, Boolean.valueOf(this.xmodelo.getValueAt(this.xposicion, 8).toString()).booleanValue(), this.correoUsuario, Principal.informacionGeneralPrincipalDTO.getIdModulo());
                        } else {
                            this.xmt.EnviarPDFGeneradoHC(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 2).toString(), this.xmt.getRutaRep() + "furipsPA_v2023", (String[][]) null, false, Boolean.valueOf(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 8).toString()).booleanValue(), this.correoUsuario, Principal.informacionGeneralPrincipalDTO.getIdModulo());
                        }
                    }
                } else if (xtipo == 2) {
                    this.xmt.mEliminarArchivo(new File(this.xmt.getRutaRep() + "furipsPB_v2023.pdf"));
                    if (xforma) {
                        Furips_PB_V2023 xfr4 = new Furips_PB_V2023(xrs2.getString(4), xrs2.getString(1), xrs2.getString("Id_Ingreso"), "", "", "");
                        xfr4.build();
                    } else {
                        double xValorG2 = 0.0d;
                        double xValorT2 = 0.0d;
                        for (int x2 = 0; x2 < this.JTBDetalle1.getRowCount(); x2++) {
                            if (Boolean.valueOf(this.xmodelod.getValueAt(x2, 5).toString()).booleanValue()) {
                                if (Boolean.valueOf(this.xmodelod.getValueAt(x2, 6).toString()).booleanValue()) {
                                    xValorT2 += Double.valueOf(this.xmodelod.getValueAt(x2, 4).toString()).doubleValue();
                                } else {
                                    xValorG2 += Double.valueOf(this.xmodelod.getValueAt(x2, 4).toString()).doubleValue();
                                }
                            }
                        }
                        Furips_PB_Glosa xfr5 = new Furips_PB_Glosa(xrs2.getString(4), xrs2.getString(1), xrs2.getString("Id_Ingreso"), this.xmodelod.getValueAt(this.JTBDetalle1.getSelectedRow(), 2).toString(), this.xmt.formatoMoneda1.format(xValorG2), this.xmodelod.getValueAt(this.JTBDetalle1.getSelectedRow(), 6).toString(), this.xmt.formatoMoneda1.format(xValorT2));
                        xfr5.build();
                    }
                    if (this.JRB_VPreliminar.isSelected()) {
                        this.xmt.mostrarPdf(this.xmt.getRutaRep() + "furipsPB_v2023.pdf");
                    } else if (!this.JRB_VImpresora.isSelected()) {
                        if (xforma) {
                            this.xmt.EnviarPDFGeneradoHC(this.xmodelo.getValueAt(this.xposicion, 2).toString(), this.xmt.getRutaRep() + "furipsPB_v2023", (String[][]) null, false, Boolean.valueOf(this.xmodelo.getValueAt(this.xposicion, 8).toString()).booleanValue(), this.correoUsuario, Principal.informacionGeneralPrincipalDTO.getIdModulo());
                        } else {
                            this.xmt.EnviarPDFGeneradoHC(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 2).toString(), this.xmt.getRutaRep() + "furipsPB_v2023", (String[][]) null, false, Boolean.valueOf(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 8).toString()).booleanValue(), this.correoUsuario, Principal.informacionGeneralPrincipalDTO.getIdModulo());
                        }
                    }
                } else if (xtipo == 3) {
                    this.xmt.mEliminarArchivo(new File(this.xmt.getRutaRep() + "furcen.pdf"));
                    Furcen xfr6 = new Furcen(xrs2.getString(1));
                    xfr6.build();
                    if (this.JRB_VPreliminar.isSelected()) {
                        this.xmt.mostrarPdf(this.xmt.getRutaRep() + "furcen.pdf");
                    } else if (!this.JRB_VImpresora.isSelected()) {
                        if (xforma) {
                            this.xmt.EnviarPDFGeneradoHC(this.xmodelo.getValueAt(this.xposicion, 2).toString(), this.xmt.getRutaRep() + "furcen", (String[][]) null, false, Boolean.valueOf(this.xmodelo.getValueAt(this.xposicion, 8).toString()).booleanValue(), this.correoUsuario, Principal.informacionGeneralPrincipalDTO.getIdModulo());
                        } else {
                            this.xmt.EnviarPDFGeneradoHC(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 2).toString(), this.xmt.getRutaRep() + "furcen", (String[][]) null, false, Boolean.valueOf(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 8).toString()).booleanValue(), this.correoUsuario, Principal.informacionGeneralPrincipalDTO.getIdModulo());
                        }
                    }
                }
            }
            xrs2.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex2) {
            Logger.getLogger(JPI_Control_Impresion.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex2);
        }
    }

    /* JADX INFO: loaded from: GenomaP.jar:Historia/JPI_Control_Impresion$MiRender.class */
    public static class MiRender extends DefaultTableCellRenderer {
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (Boolean.valueOf(table.getValueAt(row, 4).toString()).booleanValue()) {
                cell.setBackground(new Color(177, 251, 177));
            } else {
                cell.setBackground(Color.WHITE);
            }
            return cell;
        }
    }

    private boolean mConsultar_Datos(String xsql, int xfila, int xTipoD) {
        System.err.println("xsql" + xsql);
        boolean xTipo = false;
        if (!xsql.isEmpty()) {
            try {
                ConsultasMySQL xct1 = new ConsultasMySQL();
                System.out.println("consulta check -> " + xsql);
                PreparedStatement xpt = xct1.establecerConexionBd().prepareStatement(xsql);
                switch (xTipoD) {
                    case 1:
                    case 2:
                        xpt.setString(1, this.xId_Ingreso);
                        break;
                    case 64:
                        xpt.setString(1, this.xId_Ingreso);
                        System.err.println("xId_Ingreso" + this.xId_Ingreso);
                        break;
                    default:
                        xpt.setString(1, this.xId_Atencion);
                        break;
                }
                xpt.executeQuery();
                ResultSet xrs = xpt.getResultSet();
                if (xrs.next()) {
                    xTipo = true;
                    this.xmodelo.setValueAt(true, xfila, 7);
                } else {
                    this.xmodelo.setValueAt(false, xfila, 7);
                }
                xrs.close();
                xpt.close();
                xct1.cerrarConexionBd();
            } catch (SQLException ex) {
                Logger.getLogger(JPI_Control_Impresion.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        } else {
            this.xmodelo.setValueAt(false, xfila, 7);
        }
        return xTipo;
    }

    /* JADX WARN: Finally extract failed */
    private void mImprimir_Formula(String n) {
        System.err.println("inicia");
        try {
            String NOrden = "";
            if ("0".equals(n)) {
                this.xsql = "SELECT  `h_ordenes`.`Id` FROM `h_itemordenessum` INNER JOIN  `h_ordenes`   ON (`h_itemordenessum`.`Id_HOrdenes` = `h_ordenes`.`Id`) WHERE (`h_ordenes`.`Estado` =0  AND `h_ordenes`.`Id_Atencion` ='" + this.xId_Atencion + "') GROUP BY `h_ordenes`.`Id` ORDER BY `h_ordenes`.`Id` ASC ";
                ResultSet xrs = this.xct.traerRs(this.xsql);
                Throwable th = null;
                try {
                    try {
                        if (xrs.next()) {
                            xrs.first();
                            NOrden = xrs.getString(1);
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
                    } finally {
                    }
                } catch (Throwable th3) {
                    th = th3;
                    throw th3;
                }
            } else {
                NOrden = n;
            }
            SimpleDateFormat xfechar = new SimpleDateFormat("dd/MM/yyyy");
            String xnotasad = null;
            String sql = "SELECT Id_Atencion, Id, FechaOrden FROM h_ordenes where Id='" + NOrden + "'";
            ConsultasMySQL xct1 = new ConsultasMySQL();
            ResultSet rsm = xct1.traerRs(sql);
            rsm.first();
            long xida = rsm.getLong(1);
            if (rsm.getRow() != 0) {
                ConsultasMySQL xct2 = new ConsultasMySQL();
                String sql2 = "SELECT Id_Atencion, Id, FechaOrden FROM  h_ordenes where  Id_Atencion='" + xida + "' and Id>'" + NOrden + "' order by Id";
                rsm = xct2.traerRs(sql2);
                if (rsm.next()) {
                    xnotasad = "Orden N° : " + rsm.getInt(2) + "  - - - Fecha Proxima Entrega : " + xfechar.format((Date) rsm.getDate(3));
                }
                xct2.cerrarConexionBd();
            }
            rsm.close();
            xct1.cerrarConexionBd();
            String[][] mparametros = new String[7][2];
            mparametros[0][0] = "norden";
            mparametros[0][1] = NOrden;
            mparametros[1][0] = "xp2";
            mparametros[1][1] = "Farmacia";
            mparametros[2][0] = "ip";
            mparametros[2][1] = xnotasad;
            mparametros[3][0] = "nusuarios";
            mparametros[3][1] = Principal.usuarioSistemaDTO.getLogin();
            mparametros[4][0] = "SUBREPORT_DIR";
            mparametros[4][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
            mparametros[5][0] = "SUBREPORTFIRMA_DIR";
            mparametros[5][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
            mparametros[6][0] = "nbreUsuario";
            mparametros[6][1] = Principal.usuarioSistemaDTO.getNombreUsuario();
            if (Principal.informacionIps.getEsFpz().intValue() == 0) {
                ConsultasMySQL xct3 = new ConsultasMySQL();
                this.xsql = "SELECT  `g_relacionlaboral`.`Id` FROM  `h_ordenes` INNER JOIN`h_atencion`  ON (`h_ordenes`.`Id_Atencion` = `h_atencion`.`Id`) INNER JOIN`ingreso`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`) INNER JOIN`g_usuario`  ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`) INNER JOIN`g_usuario_fpz`  ON (`g_usuario_fpz`.`Id_Persona` = `g_usuario`.`Id_persona`) INNER JOIN`g_relacionlaboral`  ON (`g_usuario_fpz`.`Id_RelacionLaboral` = `g_relacionlaboral`.`Id`) WHERE (`h_ordenes`.`Id` ='" + NOrden + "') ";
                ResultSet xrs1 = xct3.traerRs(this.xsql);
                Throwable th4 = null;
                try {
                    if (xrs1.next()) {
                        xrs1.first();
                        if (xrs1.getInt(1) == 1) {
                            if (this.JRB_VImpresora.isSelected()) {
                                this.xmt.PresentacionImpresora(this.xmt.getRutaRep() + "RFormulaGeneralMP.jasper", mparametros);
                            } else if (this.JRB_VPreliminar.isSelected()) {
                                this.xmt.GenerarPDF(this.xmt.getRutaRep() + "RFormulaGeneralMP", mparametros);
                            } else {
                                this.xmt.EnviarPDFGeneradoHC(this.xmodelo.getValueAt(this.xposicion, 2).toString(), this.xmt.getRutaRep() + "RFormulaGeneralMP", mparametros, true, Boolean.valueOf(this.xmodelo.getValueAt(this.xposicion, 8).toString()).booleanValue(), this.correoUsuario, Principal.informacionGeneralPrincipalDTO.getIdModulo());
                            }
                        } else if (this.JRB_VImpresora.isSelected()) {
                            this.xmt.PresentacionImpresora(this.xmt.getRutaRep() + "RFormulaGeneralMP_Directivos.jasper", mparametros);
                        } else if (this.JRB_VPreliminar.isSelected()) {
                            this.xmt.GenerarPDF(this.xmt.getRutaRep() + "RFormulaGeneralMP_Directivos", mparametros);
                        } else {
                            this.xmt.EnviarPDFGeneradoHC(this.xmodelo.getValueAt(this.xposicion, 2).toString(), this.xmt.getRutaRep() + "RFormulaGeneralMP_Directivos", mparametros, true, Boolean.valueOf(this.xmodelo.getValueAt(this.xposicion, 8).toString()).booleanValue(), this.correoUsuario, Principal.informacionGeneralPrincipalDTO.getIdModulo());
                        }
                    }
                    if (xrs1 != null) {
                        if (0 != 0) {
                            try {
                                xrs1.close();
                            } catch (Throwable th5) {
                                th4.addSuppressed(th5);
                            }
                        } else {
                            xrs1.close();
                        }
                    }
                    xct3.cerrarConexionBd();
                } catch (Throwable th6) {
                    if (xrs1 != null) {
                        if (0 != 0) {
                            try {
                                xrs1.close();
                            } catch (Throwable th7) {
                                th4.addSuppressed(th7);
                            }
                        } else {
                            xrs1.close();
                        }
                    }
                    throw th6;
                }
            } else if (this.JRB_VImpresora.isSelected()) {
                if (Principal.informacionIps.getTipoReporteImprimir().intValue() == 1) {
                    switch (Principal.informacionIps.getNombreIps()) {
                        case "CLINICA PAJONAL S.A.S":
                        case "E.S.E. HOSPITAL SAN JUAN DE DIOS":
                        case "E.S.E. HOSPITAL SAN JORGE DE AYAPEL":
                        case "EMPRESA SOCIAL DEL ESTADO CAMU CHIMA":
                            System.err.println("inicia - 1");
                            this.xmt.PresentacionImpresora(this.xmt.getRutaRep() + "Pajonal_RFormulaGeneralMP2.jasper", mparametros);
                            break;
                        case "E.S.E HOSPITAL SAN JUAN DE SAHAGUN":
                            System.err.println("inicia - 9");
                            this.xmt.PresentacionImpresora(this.xmt.getRutaRep() + "Pajonal_RFormulaGeneralMP2_Sahagun.jasper", mparametros);
                            break;
                        default:
                            this.xmt.PresentacionImpresora(this.xmt.getRutaRep() + "RFormulaGeneralMP1.jasper", mparametros);
                            System.err.println("inicia - 4");
                            break;
                    }
                } else if (Principal.informacionIps.getTipoReporteImprimir().intValue() == 2) {
                    if (Principal.informacionIps.getNombreIps().equals("CLINICA OFTALMOLOGICA DAJUD SAS") || Principal.informacionIps.getNombreIps().equals("COD-OPTICA UT") || Principal.informacionIps.getNombreIps().equals("JAIME CESAR DAJUD FERNANDEZ")) {
                        this.xmt.GenerarPDF(this.xmt.getRutaRep() + "RFormulaGeneralMP2_CDajud", mparametros);
                    } else if (Principal.informacionIps.getNombreIps().equals("CLINICA LAURELES PSIQUIATRAS ASOCIADOS I.P.S. S.A.S.") || Principal.informacionIps.getNombreIps().equals("UNION TEMPORAL CLINICA LAURELES")) {
                        this.xmt.GenerarPDF(this.xmt.getRutaRep() + "RFormulaGeneralMP2_CPsiquiatras", mparametros);
                    } else if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL LOCAL DE MONTELIBANO")) {
                        this.xmt.GenerarPDF(this.xmt.getRutaRep() + "RFormulaGeneralMP_Hospital", mparametros);
                    } else if (Principal.informacionIps.getIdentificacion().equals("812005644")) {
                        this.xmt.GenerarPDF(this.xmt.getRutaRep() + "RFormulaGeneralMP2_San_Jorge", mparametros);
                    } else if (Principal.informacionIps.getNombreIps().equals("CLINICA PAJONAL S.A.S") || Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN JUAN DE DIOS") || Principal.informacionIps.getNombreIps().equals("E.S.E CAMU IRIS LOPEZ DURAN DE SAN ANTERO") || Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN JORGE DE AYAPEL") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO CAMU CHIMA") || Principal.informacionIps.getIdentificacion().equals("812003851") || Principal.informacionIps.getIdentificacion().equals("900520293") || Principal.informacionIps.getIdentificacion().equals("900895500")) {
                        System.err.println("inicia - 2");
                        this.xmt.PresentacionImpresora(this.xmt.getRutaRep() + "Pajonal_RFormulaGeneralMP2.jasper", mparametros);
                    } else {
                        System.err.println("inicia - 3");
                        this.xmt.PresentacionImpresora(this.xmt.getRutaRep() + "RFormulaGeneralMP2.jasper", mparametros);
                    }
                }
            } else if (this.JRB_VPreliminar.isSelected()) {
                if (Principal.informacionIps.getTipoReporteImprimir().intValue() == 1) {
                    if (Principal.informacionIps.getNombreIps().equals("CLINICA PAJONAL S.A.S") || Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN JUAN DE DIOS") || Principal.informacionIps.getNombreIps().equals("E.S.E CAMU IRIS LOPEZ DURAN DE SAN ANTERO") || Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN JORGE DE AYAPEL") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO CAMU CHIMA") || Principal.informacionIps.getIdentificacion().equals("812003851") || Principal.informacionIps.getIdentificacion().equals("900895500")) {
                        this.xmt.GenerarPDF(this.xmt.getRutaRep() + "Pajonal_RFormulaGeneralMP2", mparametros);
                    } else {
                        this.xmt.GenerarPDF(this.xmt.getRutaRep() + "RFormulaGeneralMP1", mparametros);
                    }
                } else if (Principal.informacionIps.getTipoReporteImprimir().intValue() == 2) {
                    if (Principal.informacionIps.getNombreIps().equals("CLINICA OFTALMOLOGICA DAJUD SAS") || Principal.informacionIps.getNombreIps().equals("COD-OPTICA UT") || Principal.informacionIps.getNombreIps().equals("JAIME CESAR DAJUD FERNANDEZ")) {
                        this.xmt.GenerarPDF(this.xmt.getRutaRep() + "RFormulaGeneralMP2_CDajud", mparametros);
                    } else if (Principal.informacionIps.getNombreIps().equals("CLINICA LAURELES PSIQUIATRAS ASOCIADOS I.P.S. S.A.S.") || Principal.informacionIps.getNombreIps().equals("UNION TEMPORAL CLINICA LAURELES")) {
                        this.xmt.GenerarPDF(this.xmt.getRutaRep() + "RFormulaGeneralMP2_CPsiquiatras", mparametros);
                    } else if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL LOCAL DE MONTELIBANO")) {
                        this.xmt.GenerarPDF(this.xmt.getRutaRep() + "RFormulaGeneralMP_Hospital", mparametros);
                    } else if (Principal.informacionIps.getIdentificacion().equals("812005644")) {
                        this.xmt.GenerarPDF(this.xmt.getRutaRep() + "RFormulaGeneralMP2_San_Jorge", mparametros);
                    } else if (Principal.informacionIps.getNombreIps().equals("CLINICA PAJONAL S.A.S") || Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN JUAN DE DIOS") || Principal.informacionIps.getNombreIps().equals("E.S.E CAMU IRIS LOPEZ DURAN DE SAN ANTERO") || Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN JORGE DE AYAPEL") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO CAMU CHIMA") || Principal.informacionIps.getIdentificacion().equals("812003851") || Principal.informacionIps.getIdentificacion().equals("900520293") || Principal.informacionIps.getIdentificacion().equals("900895500")) {
                        this.xmt.GenerarPDF(this.xmt.getRutaRep() + "Pajonal_RFormulaGeneralMP2", mparametros);
                    } else {
                        this.xmt.GenerarPDF(this.xmt.getRutaRep() + "RFormulaGeneralMP2", mparametros);
                    }
                }
            } else if (Principal.informacionIps.getTipoReporteImprimir().intValue() == 1) {
                if (Principal.informacionIps.getNombreIps().equals("CLINICA PAJONAL S.A.S") || Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN JUAN DE DIOS") || Principal.informacionIps.getNombreIps().equals("E.S.E CAMU IRIS LOPEZ DURAN DE SAN ANTERO") || Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN JORGE DE AYAPEL") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO CAMU CHIMA") || Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN JUAN DE DIOS - Segovia") || Principal.informacionIps.getIdentificacion().equals("812003851") || Principal.informacionIps.getIdentificacion().equals("900520293") || Principal.informacionIps.getIdentificacion().equals("900895500")) {
                    this.xmt.EnviarPDFGeneradoHC(this.xmodelo.getValueAt(this.xposicion, 2).toString(), this.xmt.getRutaRep() + "Pajonal_RFormulaGeneralMP2", mparametros, true, Boolean.valueOf(this.xmodelo.getValueAt(this.xposicion, 8).toString()).booleanValue(), this.correoUsuario, Principal.informacionGeneralPrincipalDTO.getIdModulo());
                } else {
                    this.xmt.EnviarPDFGeneradoHC(this.xmodelo.getValueAt(this.xposicion, 2).toString(), this.xmt.getRutaRep() + "RFormulaGeneralMP1", mparametros, true, Boolean.valueOf(this.xmodelo.getValueAt(this.xposicion, 8).toString()).booleanValue(), this.correoUsuario, Principal.informacionGeneralPrincipalDTO.getIdModulo());
                }
            } else if (Principal.informacionIps.getTipoReporteImprimir().intValue() == 2) {
                if (Principal.informacionIps.getNombreIps().equals("CLINICA OFTALMOLOGICA DAJUD SAS") || Principal.informacionIps.getNombreIps().equals("COD-OPTICA UT") || Principal.informacionIps.getNombreIps().equals("JAIME CESAR DAJUD FERNANDEZ")) {
                    this.xmt.EnviarPDFGeneradoHC(this.xmodelo.getValueAt(this.xposicion, 2).toString(), this.xmt.getRutaRep() + "RFormulaGeneralMP2_CDajud", mparametros, true, Boolean.valueOf(this.xmodelo.getValueAt(this.xposicion, 8).toString()).booleanValue(), this.correoUsuario, Principal.informacionGeneralPrincipalDTO.getIdModulo());
                } else if (Principal.informacionIps.getNombreIps().equals("CLINICA LAURELES PSIQUIATRAS ASOCIADOS I.P.S. S.A.S.") || Principal.informacionIps.getNombreIps().equals("UNION TEMPORAL CLINICA LAURELES")) {
                    this.xmt.EnviarPDFGeneradoHC(this.xmodelo.getValueAt(this.xposicion, 2).toString(), this.xmt.getRutaRep() + "RFormulaGeneralMP2_CPsiquiatras", mparametros, true, Boolean.valueOf(this.xmodelo.getValueAt(this.xposicion, 8).toString()).booleanValue(), this.correoUsuario, Principal.informacionGeneralPrincipalDTO.getIdModulo());
                } else if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL LOCAL DE MONTELIBANO")) {
                    this.xmt.EnviarPDFGeneradoHC(this.xmodelo.getValueAt(this.xposicion, 2).toString(), this.xmt.getRutaRep() + "RFormulaGeneralMP_Hospital", mparametros, true, Boolean.valueOf(this.xmodelo.getValueAt(this.xposicion, 8).toString()).booleanValue(), this.correoUsuario, Principal.informacionGeneralPrincipalDTO.getIdModulo());
                } else if (Principal.informacionIps.getIdentificacion().equals("812005644")) {
                    this.xmt.EnviarPDFGeneradoHC(this.xmodelo.getValueAt(this.xposicion, 2).toString(), this.xmt.getRutaRep() + "RFormulaGeneralMP2_San_Jorge", mparametros, true, Boolean.valueOf(this.xmodelo.getValueAt(this.xposicion, 8).toString()).booleanValue(), this.correoUsuario, Principal.informacionGeneralPrincipalDTO.getIdModulo());
                } else if (Principal.informacionIps.getNombreIps().equals("CLINICA PAJONAL S.A.S") || Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN JUAN DE DIOS") || Principal.informacionIps.getNombreIps().equals("E.S.E CAMU IRIS LOPEZ DURAN DE SAN ANTERO") || Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN JORGE DE AYAPEL") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO CAMU CHIMA") || Principal.informacionIps.getIdentificacion().equals("812003851") || Principal.informacionIps.getIdentificacion().equals("900520293") || Principal.informacionIps.getIdentificacion().equals("900895500")) {
                    this.xmt.EnviarPDFGeneradoHC(this.xmodelo.getValueAt(this.xposicion, 2).toString(), this.xmt.getRutaRep() + "Pajonal_RFormulaGeneralMP2", mparametros, true, Boolean.valueOf(this.xmodelo.getValueAt(this.xposicion, 8).toString()).booleanValue(), this.correoUsuario, Principal.informacionGeneralPrincipalDTO.getIdModulo());
                } else {
                    this.xmt.EnviarPDFGeneradoHC(this.xmodelo.getValueAt(this.xposicion, 2).toString(), this.xmt.getRutaRep() + "RFormulaGeneralMP2", mparametros, true, Boolean.valueOf(this.xmodelo.getValueAt(this.xposicion, 8).toString()).booleanValue(), this.correoUsuario, Principal.informacionGeneralPrincipalDTO.getIdModulo());
                }
            }
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPI_Control_Impresion.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mImprimir_CTC() {
        try {
            this.xsql = "SELECT `h_ordenes`.`Id` AS `Id_Orden` , `h_concecutivo_ctc`.`Id` AS `Id_Ctc` FROM `h_itemordenessum`  INNER JOIN  `h_ordenes`  ON (`h_itemordenessum`.`Id_HOrdenes` = `h_ordenes`.`Id`) INNER JOIN  `h_concecutivo_ctc`  ON (`h_concecutivo_ctc`.`IdOrden` = `h_ordenes`.`Id`) WHERE (`h_ordenes`.`Estado` =1  AND `h_ordenes`.`Id_Atencion` ='" + this.xId_Atencion + "') GROUP BY `Id_Orden` ORDER BY `Id_Orden` ASC ";
            ResultSet xrs = this.xct.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.first();
                String[][] parametros = new String[4][2];
                parametros[0][0] = "ID_Conc";
                parametros[0][1] = xrs.getString(1);
                parametros[1][0] = "SUBREPORT_DIR";
                parametros[1][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
                parametros[2][0] = "SUBREPORTFIRMA_DIR";
                parametros[2][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
                parametros[3][0] = "nbreUsuario";
                parametros[3][1] = Principal.usuarioSistemaDTO.getNombreUsuario();
                if (this.JRB_VImpresora.isSelected()) {
                    this.xmt.PresentacionImpresora(this.xmt.getRutaRep() + "R_MedicamentoNoPOS.jasper", parametros);
                } else if (this.JRB_VPreliminar.isSelected()) {
                    this.xmt.GenerarPDF(this.xmt.getRutaRep() + "R_MedicamentoNoPOS", parametros);
                } else {
                    this.xmt.EnviarPDFGeneradoHC(this.xmodelo.getValueAt(this.xposicion, 2).toString(), this.xmt.getRutaRep() + "R_MedicamentoNoPOS", parametros, true, Boolean.valueOf(this.xmodelo.getValueAt(this.xposicion, 8).toString()).booleanValue(), this.correoUsuario, Principal.informacionGeneralPrincipalDTO.getIdModulo());
                }
                xrs.close();
                this.xct.cerrarConexionBd();
            }
        } catch (SQLException ex) {
            Logger.getLogger(JPI_Control_Impresion.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mImprimir_AyudaDx(int xn) {
        try {
            this.xsql = "SELECT  `h_ordenes`.`Id` AS `Id_Orden` , `h_ordenes`.`Id_TipoServicio` FROM `h_itemordenesproced` INNER JOIN  `h_ordenes`  ON (`h_itemordenesproced`.`Id_HOrdenes` = `h_ordenes`.`Id`) WHERE (`h_ordenes`.`Estado` =0 AND `h_ordenes`.`Id_Atencion` ='" + this.xId_Atencion + "') GROUP BY `Id_Orden` ORDER BY `Id_Orden` ASC ";
            ResultSet xrs = this.xct.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.beforeFirst();
                ConsultasMySQL xct1 = new ConsultasMySQL();
                while (xrs.next()) {
                    if (xrs.getInt(2) == 2) {
                        String xpeso = "";
                        String xtalla = "";
                        String xnstiker = "1";
                        String xsql = "SELECT h_examenfisico.Talla , h_examenfisico.Peso  FROM h_examenfisico INNER JOIN h_atencion  ON (h_examenfisico.Id_Atencion = h_atencion.Id) INNER JOIN h_ordenes  ON (h_ordenes.Id_Atencion = h_atencion.Id) INNER JOIN h_itemordenesproced  ON (h_itemordenesproced.Id_HOrdenes = h_ordenes.Id) INNER JOIN g_procedimiento  ON (h_itemordenesproced.Id_Procedimiento = g_procedimiento.Id) WHERE (h_examenfisico.Talla <>0 AND h_examenfisico.Peso <>0 AND h_ordenes.Id ='" + xrs.getString(1) + "' AND h_ordenes.Id_TipoServicio =2 AND g_procedimiento.RPrevios IS NOT NULL) ";
                        ResultSet xrs1 = xct1.traerRs(xsql);
                        Throwable th = null;
                        try {
                            try {
                                if (xrs1.next()) {
                                    xrs1.first();
                                    xtalla = xrs1.getString(1);
                                    xpeso = xrs1.getString(2);
                                }
                                if (xrs1 != null) {
                                    if (0 != 0) {
                                        try {
                                            xrs1.close();
                                        } catch (Throwable th2) {
                                            th.addSuppressed(th2);
                                        }
                                    } else {
                                        xrs1.close();
                                    }
                                }
                                xct1.cerrarConexionBd();
                                String xsql2 = "SELECT l_tipomuestra.Id FROM h_ordenes INNER JOIN h_atencion  ON (h_ordenes.Id_Atencion = h_atencion.Id) INNER JOIN h_itemordenesproced  ON (h_itemordenesproced.Id_HOrdenes = h_ordenes.Id) INNER JOIN g_procedimiento  ON (h_itemordenesproced.Id_Procedimiento = g_procedimiento.Id) INNER JOIN l_tipomuestra  ON (g_procedimiento.Id_TipoMuestra = l_tipomuestra.Id) WHERE (h_ordenes.Id ='" + xrs.getString(1) + "') GROUP BY l_tipomuestra.Id ORDER BY h_ordenes.Id ASC ";
                                ResultSet rs = xct1.traerRs(xsql2);
                                if (rs.next()) {
                                    rs.last();
                                    xnstiker = String.valueOf(rs.getRow());
                                }
                                rs.close();
                                xct1.cerrarConexionBd();
                                String[][] mparametros = new String[7][2];
                                mparametros[0][0] = "idorden";
                                mparametros[0][1] = xrs.getString(1);
                                mparametros[1][0] = "talla";
                                mparametros[1][1] = "TALLA : " + xtalla;
                                mparametros[2][0] = "peso";
                                mparametros[2][1] = "PESO : " + xpeso;
                                mparametros[3][0] = "ns";
                                mparametros[3][1] = "N° Stiker : " + xnstiker;
                                mparametros[4][0] = "SUBREPORT_DIR";
                                mparametros[4][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
                                mparametros[5][0] = "SUBREPORTFIRMA_DIR";
                                mparametros[5][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
                                mparametros[6][0] = "nbreUsuario";
                                mparametros[6][1] = Principal.usuarioSistemaDTO.getNombreUsuario();
                                if (this.JRB_VImpresora.isSelected()) {
                                    if (Principal.informacionIps.getEsFpz().intValue() == 0) {
                                        this.xmt.PresentacionImpresora(this.xmt.getRutaRep() + "RProcedimientosL.jasper", mparametros);
                                    } else if (Principal.informacionIps.getTipoReporteImprimir().intValue() == 1) {
                                        if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL LOCAL DE MONTELIBANO")) {
                                            this.xmt.PresentacionImpresora(this.xmt.getRutaRep() + "RProcedimientosL_1_Hospital.jasper", mparametros);
                                        } else {
                                            this.xmt.PresentacionImpresora(this.xmt.getRutaRep() + "RProcedimientosL1.jasper", mparametros);
                                        }
                                    } else if (Principal.informacionIps.getTipoReporteImprimir().intValue() == 2) {
                                        if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL LOCAL DE MONTELIBANO")) {
                                            this.xmt.PresentacionImpresora(this.xmt.getRutaRep() + "RProcedimientosL_1_Hospital.jasper", mparametros);
                                        } else {
                                            this.xmt.PresentacionImpresora(this.xmt.getRutaRep() + "RProcedimientosL2.jasper", mparametros);
                                        }
                                    }
                                } else if (this.JRB_VPreliminar.isSelected()) {
                                    if (Principal.informacionIps.getEsFpz().intValue() == 0) {
                                        this.xmt.GenerarPDF(this.xmt.getRutaRep() + "RProcedimientosL", mparametros);
                                    } else if (Principal.informacionIps.getTipoReporteImprimir().intValue() == 1) {
                                        if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL LOCAL DE MONTELIBANO")) {
                                            this.xmt.GenerarPDF(this.xmt.getRutaRep() + "RProcedimientosL_1_Hospital", mparametros);
                                        } else {
                                            this.xmt.GenerarPDF(this.xmt.getRutaRep() + "RProcedimientosL1", mparametros);
                                        }
                                    } else if (Principal.informacionIps.getTipoReporteImprimir().intValue() == 2) {
                                        if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL LOCAL DE MONTELIBANO")) {
                                            this.xmt.GenerarPDF(this.xmt.getRutaRep() + "RProcedimientosL_1_Hospital", mparametros);
                                        } else {
                                            this.xmt.GenerarPDF(this.xmt.getRutaRep() + "RProcedimientosL2", mparametros);
                                        }
                                    }
                                } else if (Principal.informacionIps.getEsFpz().intValue() == 0) {
                                    this.xmt.EnviarPDFGeneradoHC(this.xmodelo.getValueAt(this.xposicion, 2).toString(), this.xmt.getRutaRep() + "RProcedimientosL", mparametros, true, Boolean.valueOf(this.xmodelo.getValueAt(this.xposicion, 8).toString()).booleanValue(), this.correoUsuario, Principal.informacionGeneralPrincipalDTO.getIdModulo());
                                } else if (Principal.informacionIps.getTipoReporteImprimir().intValue() == 1) {
                                    if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL LOCAL DE MONTELIBANO")) {
                                        this.xmt.EnviarPDFGeneradoHC(this.xmodelo.getValueAt(this.xposicion, 2).toString(), this.xmt.getRutaRep() + "RProcedimientosL_1_Hospital", mparametros, true, Boolean.valueOf(this.xmodelo.getValueAt(this.xposicion, 8).toString()).booleanValue(), this.correoUsuario, Principal.informacionGeneralPrincipalDTO.getIdModulo());
                                    } else {
                                        this.xmt.EnviarPDFGeneradoHC(this.xmodelo.getValueAt(this.xposicion, 2).toString(), this.xmt.getRutaRep() + "RProcedimientosL1", mparametros, true, Boolean.valueOf(this.xmodelo.getValueAt(this.xposicion, 8).toString()).booleanValue(), this.correoUsuario, Principal.informacionGeneralPrincipalDTO.getIdModulo());
                                    }
                                } else if (Principal.informacionIps.getTipoReporteImprimir().intValue() == 2) {
                                    if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL LOCAL DE MONTELIBANO")) {
                                        this.xmt.EnviarPDFGeneradoHC(this.xmodelo.getValueAt(this.xposicion, 2).toString(), this.xmt.getRutaRep() + "RProcedimientosL_1_Hospital", mparametros, true, Boolean.valueOf(this.xmodelo.getValueAt(this.xposicion, 8).toString()).booleanValue(), this.correoUsuario, Principal.informacionGeneralPrincipalDTO.getIdModulo());
                                    } else {
                                        this.xmt.EnviarPDFGeneradoHC(this.xmodelo.getValueAt(this.xposicion, 2).toString(), this.xmt.getRutaRep() + "RProcedimientosL2", mparametros, true, Boolean.valueOf(this.xmodelo.getValueAt(this.xposicion, 8).toString()).booleanValue(), this.correoUsuario, Principal.informacionGeneralPrincipalDTO.getIdModulo());
                                    }
                                }
                            } finally {
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            throw th3;
                        }
                    } else {
                        String sql = "SELECT h_atencion.Motivo_Atencion, h_ordenes.Id FROM h_ordenes INNER JOIN h_atencion ON (h_ordenes.Id_Atencion = h_atencion.Id) where h_ordenes.Id='" + xrs.getString(1) + "'";
                        String nota = xct1.traerDato(sql);
                        xct1.cerrarConexionBd();
                        String horario = "";
                        if (xrs.getInt(2) == 3) {
                            horario = "Horario de Atencion:\nLunes a Jueves:  6:30 A.M - 4:30 P.M\nViernes:  6:30 A.M - 1:00 P.M";
                        }
                        String[][] mparametros2 = new String[7][2];
                        mparametros2[0][0] = "idorden";
                        mparametros2[0][1] = xrs.getString(1);
                        mparametros2[1][0] = "idservicio";
                        mparametros2[1][1] = xrs.getString(2);
                        mparametros2[2][0] = "nota";
                        mparametros2[2][1] = nota;
                        mparametros2[3][0] = "horario";
                        mparametros2[3][1] = horario;
                        mparametros2[4][0] = "SUBREPORT_DIR";
                        mparametros2[4][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
                        mparametros2[5][0] = "SUBREPORTFIRMA_DIR";
                        mparametros2[5][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
                        mparametros2[6][0] = "nbreUsuario";
                        mparametros2[6][1] = Principal.usuarioSistemaDTO.getNombreUsuario();
                        if (this.JRB_VImpresora.isSelected()) {
                            if (Principal.informacionIps.getEsFpz().intValue() == 0) {
                                this.xmt.PresentacionImpresora(this.xmt.getRutaRep() + "RProcedimientosO.jasper", mparametros2);
                            } else if (Principal.informacionIps.getTipoReporteImprimir().intValue() == 1) {
                                if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL LOCAL DE MONTELIBANO")) {
                                    this.xmt.PresentacionImpresora(this.xmt.getRutaRep() + "RProcedimientosO_Hospital.jasper", mparametros2);
                                } else {
                                    this.xmt.PresentacionImpresora(this.xmt.getRutaRep() + "RProcedimientosO1.jasper", mparametros2);
                                }
                            } else if (Principal.informacionIps.getTipoReporteImprimir().intValue() == 2) {
                                if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL LOCAL DE MONTELIBANO")) {
                                    this.xmt.PresentacionImpresora(this.xmt.getRutaRep() + "RProcedimientosO_Hospital.jasper", mparametros2);
                                } else {
                                    this.xmt.PresentacionImpresora(this.xmt.getRutaRep() + "RProcedimientosO2.jasper", mparametros2);
                                }
                            }
                        } else if (this.JRB_VPreliminar.isSelected()) {
                            if (Principal.informacionIps.getEsFpz().intValue() == 0) {
                                this.xmt.GenerarPDF(this.xmt.getRutaRep() + "RProcedimientosO", mparametros2);
                            } else if (Principal.informacionIps.getTipoReporteImprimir().intValue() == 1) {
                                if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL LOCAL DE MONTELIBANO")) {
                                    this.xmt.GenerarPDF(this.xmt.getRutaRep() + "RProcedimientosO_Hospital", mparametros2);
                                } else {
                                    this.xmt.GenerarPDF(this.xmt.getRutaRep() + "RProcedimientosO1", mparametros2);
                                }
                            } else if (Principal.informacionIps.getTipoReporteImprimir().intValue() == 2) {
                                if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL LOCAL DE MONTELIBANO")) {
                                    this.xmt.GenerarPDF(this.xmt.getRutaRep() + "RProcedimientosO_Hospital", mparametros2);
                                } else {
                                    this.xmt.GenerarPDF(this.xmt.getRutaRep() + "RProcedimientosO2", mparametros2);
                                }
                            }
                        } else if (Principal.informacionIps.getEsFpz().intValue() == 0) {
                            this.xmt.EnviarPDFGeneradoHC(this.xmodelo.getValueAt(this.xposicion, 2).toString(), this.xmt.getRutaRep() + "RProcedimientosO", mparametros2, true, Boolean.valueOf(this.xmodelo.getValueAt(this.xposicion, 8).toString()).booleanValue(), this.correoUsuario, Principal.informacionGeneralPrincipalDTO.getIdModulo());
                        } else if (Principal.informacionIps.getTipoReporteImprimir().intValue() == 1) {
                            if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL LOCAL DE MONTELIBANO")) {
                                this.xmt.EnviarPDFGeneradoHC(this.xmodelo.getValueAt(this.xposicion, 2).toString(), this.xmt.getRutaRep() + "RProcedimientosO_Hospital", mparametros2, true, Boolean.valueOf(this.xmodelo.getValueAt(this.xposicion, 8).toString()).booleanValue(), this.correoUsuario, Principal.informacionGeneralPrincipalDTO.getIdModulo());
                            } else {
                                this.xmt.EnviarPDFGeneradoHC(this.xmodelo.getValueAt(this.xposicion, 2).toString(), this.xmt.getRutaRep() + "RProcedimientosO1", mparametros2, true, Boolean.valueOf(this.xmodelo.getValueAt(this.xposicion, 8).toString()).booleanValue(), this.correoUsuario, Principal.informacionGeneralPrincipalDTO.getIdModulo());
                            }
                        } else if (Principal.informacionIps.getTipoReporteImprimir().intValue() == 2) {
                            if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL LOCAL DE MONTELIBANO")) {
                                this.xmt.EnviarPDFGeneradoHC(this.xmodelo.getValueAt(this.xposicion, 2).toString(), this.xmt.getRutaRep() + "RProcedimientosO_Hospital", mparametros2, true, Boolean.valueOf(this.xmodelo.getValueAt(this.xposicion, 8).toString()).booleanValue(), this.correoUsuario, Principal.informacionGeneralPrincipalDTO.getIdModulo());
                            } else {
                                this.xmt.EnviarPDFGeneradoHC(this.xmodelo.getValueAt(this.xposicion, 2).toString(), this.xmt.getRutaRep() + "RProcedimientosO2", mparametros2, true, Boolean.valueOf(this.xmodelo.getValueAt(this.xposicion, 8).toString()).booleanValue(), this.correoUsuario, Principal.informacionGeneralPrincipalDTO.getIdModulo());
                            }
                        }
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(JPI_Control_Impresion.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mImprimir_AyudaDx_Anexo3(int xn, String idOrden, int opc) {
        if (opc == 0) {
            new ReporteAnexo3(this.xId_Atencion, idOrden, xn, this.xFiltroProfesional);
            if (this.JRB_VPreliminar.isSelected()) {
                this.xmt.mostrarPdf(this.xmt.getRutaRep() + "H_Anexo3_Orden.pdf");
                return;
            } else if (this.JRB_VImpresora.isSelected()) {
                this.xmt.mImprimePDFSinPreview(this.xmt.getRutaRep() + "H_Anexo3_Orden.pdf");
                return;
            } else {
                this.xmt.EnviarPDFGeneradoHC(this.xmodelo.getValueAt(this.xposicion, 2).toString(), this.xmt.getRutaRep() + "H_Anexo3_Orden", (String[][]) null, false, Boolean.valueOf(this.xmodelo.getValueAt(this.xposicion, 8).toString()).booleanValue(), this.correoUsuario, Principal.informacionGeneralPrincipalDTO.getIdModulo());
                return;
            }
        }
        if (xn == 0) {
            ReporteAnexo3 x = new ReporteAnexo3(this.xId_Atencion, idOrden, xn, this.xFiltroProfesional);
            x.build();
            if (this.JRB_VPreliminar.isSelected()) {
                this.xmt.mostrarPdf(this.xmt.getRutaRep() + "H_Anexo3_Orden.pdf");
                return;
            } else if (this.JRB_VImpresora.isSelected()) {
                this.xmt.mImprimePDFSinPreview(this.xmt.getRutaRep() + "H_Anexo3_Orden.pdf");
                return;
            } else {
                this.xmt.EnviarPDFGeneradoHC(this.xmodelo.getValueAt(this.xposicion, 2).toString(), this.xmt.getRutaRep() + "H_Anexo3_Orden", (String[][]) null, false, Boolean.valueOf(this.xmodelo.getValueAt(this.xposicion, 8).toString()).booleanValue(), this.correoUsuario, Principal.informacionGeneralPrincipalDTO.getIdModulo());
                return;
            }
        }
        ReporteAnexo3 x2 = new ReporteAnexo3(this.xId_Atencion, idOrden, xn, this.xFiltroProfesional);
        x2.build();
        if (this.JRB_VPreliminar.isSelected()) {
            this.xmt.mostrarPdf(this.xmt.getRutaRep() + "H_Anexo3_Orden.pdf");
        } else if (this.JRB_VImpresora.isSelected()) {
            this.xmt.mImprimePDFSinPreview(this.xmt.getRutaRep() + "H_Anexo3_Orden.pdf");
        } else {
            this.xmt.EnviarPDFGeneradoHC(this.xmodelo.getValueAt(this.xposicion, 2).toString(), this.xmt.getRutaRep() + "H_Anexo3_Orden", (String[][]) null, false, Boolean.valueOf(this.xmodelo.getValueAt(this.xposicion, 8).toString()).booleanValue(), this.correoUsuario, Principal.informacionGeneralPrincipalDTO.getIdModulo());
        }
    }

    private void mImprimir_Anexo3_Interconsulta() {
        ReporteAnexo3_Interconsulta x = new ReporteAnexo3_Interconsulta(this.xId_Atencion, "0", 0);
        x.build();
        if (this.JRB_VPreliminar.isSelected()) {
            this.xmt.mostrarPdf(this.xmt.getRutaRep() + "H_Anexo3_Orden" + this.xId_Atencion + ".pdf");
        } else if (this.JRB_VImpresora.isSelected()) {
            this.xmt.mImprimePDFSinPreview(this.xmt.getRutaRep() + "H_Anexo3_Orden" + this.xId_Atencion + ".pdf");
        }
    }

    public void Imprimir_Remision(int xId_Items) {
        try {
            this.xsql = "SELECT `Id` FROM `h_remisiones` WHERE (`Id_Atencion` ='" + this.xId_Atencion + "'  AND `Estado` =0) ";
            ResultSet xrs = this.xct.traerRs(this.xsql);
            Throwable th = null;
            try {
                try {
                    if (xrs.next()) {
                        xrs.beforeFirst();
                        while (xrs.next()) {
                            if (xId_Items == 0) {
                                String[][] mparametros = new String[6][2];
                                mparametros[0][0] = "idremision";
                                mparametros[0][1] = xrs.getString(1);
                                mparametros[1][0] = "idatencion1";
                                mparametros[1][1] = this.xId_Atencion;
                                mparametros[2][0] = "marca";
                                mparametros[2][1] = "HISTORIA CLINICA";
                                mparametros[3][0] = "SUBREPORT_DIR";
                                mparametros[3][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
                                mparametros[4][0] = "SUBREPORTFIRMA_DIR";
                                mparametros[4][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
                                mparametros[5][0] = "nbreUsuario";
                                mparametros[5][1] = Principal.usuarioSistemaDTO.getNombreUsuario();
                                if (this.JRB_VPreliminar.isSelected()) {
                                    if (Principal.informacionIps.getEsFpz().intValue() == 0) {
                                        this.xmt.GenerarPDF(this.xmt.getRutaRep() + "RRemisionTO", mparametros);
                                    } else if (Principal.informacionIps.getTipoReporteImprimir().intValue() == 1) {
                                        this.xmt.GenerarPDF(this.xmt.getRutaRep() + "RRemision1", mparametros);
                                    } else if (Principal.informacionIps.getTipoReporteImprimir().intValue() == 2) {
                                        this.xmt.GenerarPDF(this.xmt.getRutaRep() + "RRemision2", mparametros);
                                    }
                                } else if (this.JRB_VImpresora.isSelected()) {
                                    if (Principal.informacionIps.getEsFpz().intValue() == 0) {
                                        this.xmt.GenerarPDF(this.xmt.getRutaRep() + "RRemisionTO", mparametros);
                                    } else if (Principal.informacionIps.getTipoReporteImprimir().intValue() == 1) {
                                        this.xmt.GenerarPDF(this.xmt.getRutaRep() + "RRemision1", mparametros);
                                    } else if (Principal.informacionIps.getTipoReporteImprimir().intValue() == 2) {
                                        this.xmt.GenerarPDF(this.xmt.getRutaRep() + "RRemision2", mparametros);
                                    }
                                } else if (Principal.informacionIps.getEsFpz().intValue() == 0) {
                                    this.xmt.EnviarPDFGeneradoHC(this.xmodelo.getValueAt(this.xposicion, 2).toString(), this.xmt.getRutaRep() + "RRemisionTO", mparametros, true, Boolean.valueOf(this.xmodelo.getValueAt(this.xposicion, 8).toString()).booleanValue(), this.correoUsuario, Principal.informacionGeneralPrincipalDTO.getIdModulo());
                                } else if (Principal.informacionIps.getTipoReporteImprimir().intValue() == 1) {
                                    this.xmt.EnviarPDFGeneradoHC(this.xmodelo.getValueAt(this.xposicion, 2).toString(), this.xmt.getRutaRep() + "RRemision1", mparametros, true, Boolean.valueOf(this.xmodelo.getValueAt(this.xposicion, 8).toString()).booleanValue(), this.correoUsuario, Principal.informacionGeneralPrincipalDTO.getIdModulo());
                                } else if (Principal.informacionIps.getTipoReporteImprimir().intValue() == 2) {
                                    this.xmt.EnviarPDFGeneradoHC(this.xmodelo.getValueAt(this.xposicion, 2).toString(), this.xmt.getRutaRep() + "RRemision2", mparametros, true, Boolean.valueOf(this.xmodelo.getValueAt(this.xposicion, 8).toString()).booleanValue(), this.correoUsuario, Principal.informacionGeneralPrincipalDTO.getIdModulo());
                                }
                            } else {
                                this.xmt.mEliminarArchivo(new File(this.xmt.getRutaRep() + "FReferencia_" + xrs.getString(1) + ".pdf"));
                                ReporteRemision xReporteRemision = new ReporteRemision(this.xId_Atencion, xrs.getString(1));
                                xReporteRemision.build();
                                if (this.JRB_VPreliminar.isSelected()) {
                                    this.xmt.mostrarPdf(this.xmt.getRutaRep() + "FReferencia_" + xrs.getString(1) + ".pdf");
                                } else if (!this.JRB_VImpresora.isSelected()) {
                                    this.xmt.EnviarPDFGeneradoHC(this.xmodelo.getValueAt(this.xposicion, 2).toString(), this.xmt.getRutaRep() + "RRemision2", (String[][]) null, false, Boolean.valueOf(this.xmodelo.getValueAt(this.xposicion, 8).toString()).booleanValue(), this.correoUsuario, Principal.informacionGeneralPrincipalDTO.getIdModulo());
                                }
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
            } catch (Throwable th3) {
                th = th3;
                throw th3;
            }
        } catch (SQLException ex) {
            Logger.getLogger(JPI_Control_Impresion.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX WARN: Finally extract failed */
    private void mImprimeHistoriaOdontologia() {
        try {
            String[][] mparametros = new String[6][2];
            mparametros[0][0] = "idatencion1";
            mparametros[0][1] = this.xId_Atencion;
            mparametros[1][0] = "idpaciente1";
            mparametros[1][1] = this.xId_Usuario;
            mparametros[2][0] = "SUBREPORT_DIR";
            mparametros[2][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
            mparametros[3][0] = "SUBREPORTFIRMA_DIR";
            mparametros[3][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
            mparametros[4][0] = "nbreUsuario";
            mparametros[4][1] = Principal.usuarioSistemaDTO.getNombreUsuario();
            mparametros[5][0] = "nbreUsuario";
            mparametros[5][1] = Principal.usuarioSistemaDTO.getNombreUsuario();
            String sql = "SELECT `Id` FROM  `o_hc_tratamiento` WHERE (`Id_Atencion` ='" + this.xId_Atencion + "')";
            ConsultasMySQL xct = new ConsultasMySQL();
            ResultSet xrs = xct.traerRs(sql);
            Throwable th = null;
            try {
                if (xrs.next()) {
                    xrs.first();
                    String xTratamiento = xrs.getString(1);
                    this.xmt.mTraerDatosDienteDxOdontInicial(this.xId_Usuario);
                    this.xmt.mTraerDatosDienteProcOdontInicial(this.xId_Usuario);
                    this.xmt.traerImagenOdontograma();
                    this.xmt.mTraerDatosDienteDxTratamiento(xTratamiento);
                    this.xmt.traerImagenOdontogramaDx();
                    this.xmt.mTraerDatosDienteProcTratamiento(xTratamiento);
                    this.xmt.traerImagenOdontogramaProc();
                    this.xmt.mTraerDatosDienteMarcadosControlPlaca(xTratamiento);
                    this.xmt.traerImagenOdontogramaControlPlaca();
                    if (this.JRB_VPreliminar.isSelected()) {
                        this.xmt.GenerarPDF(this.xmt.getRutaRep() + Principal.informacionIps.getPrefijoReportes() + "H_HistoriaClinicaOdontologia", mparametros);
                    } else if (this.JRB_VImpresora.isSelected()) {
                        this.xmt.PresentacionImpresora(this.xmt.getRutaRep() + "H_HistoriaClinicaOdontologia.jasper", mparametros);
                    } else {
                        this.xmt.EnviarPDFGeneradoHC(this.xmodelo.getValueAt(this.xposicion, 2).toString(), this.xmt.getRutaRep() + "H_HistoriaClinicaOdontologia", mparametros, true, Boolean.valueOf(this.xmodelo.getValueAt(this.xposicion, 8).toString()).booleanValue(), this.correoUsuario, Principal.informacionGeneralPrincipalDTO.getIdModulo());
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
                xct.cerrarConexionBd();
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
            Logger.getLogger(JPGestionHC.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mImprimeHistoriaSO() {
        String[][] mparametros = new String[4][2];
        mparametros[0][0] = "idatencion1";
        mparametros[0][1] = this.xId_Atencion;
        mparametros[1][0] = "idpaciente1";
        mparametros[1][1] = this.xId_Usuario;
        mparametros[2][0] = "SUBREPORT_DIR";
        mparametros[2][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
        mparametros[3][0] = "SUBREPORTFIRMA_DIR";
        mparametros[3][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
        if (this.JRB_VPreliminar.isSelected()) {
            this.xmt.GenerarPDF(this.xmt.getRutaRep() + "H_HistoriaClinicaSO_FPZ", mparametros);
        } else if (this.JRB_VImpresora.isSelected()) {
            this.xmt.PresentacionImpresora(this.xmt.getRutaRep() + "H_HistoriaClinicaSO_FPZ.jasper", mparametros);
        } else {
            this.xmt.EnviarPDFGeneradoHC(this.xmodelo.getValueAt(this.xposicion, 2).toString(), this.xmt.getRutaRep() + "H_HistoriaClinicaSO_FPZ", mparametros, true, Boolean.valueOf(this.xmodelo.getValueAt(this.xposicion, 8).toString()).booleanValue(), this.correoUsuario, Principal.informacionGeneralPrincipalDTO.getIdModulo());
        }
    }

    public void mImprimir_Autorizacion(String xreporte, String xId_Ingreso) {
        String[][] mparametros = new String[5][2];
        mparametros[0][0] = "idingreso";
        mparametros[0][1] = xId_Ingreso;
        mparametros[1][0] = "usuario";
        mparametros[1][1] = Principal.usuarioSistemaDTO.getNombreUsuario();
        mparametros[2][0] = "SUBREPORT_DIR";
        mparametros[2][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
        mparametros[3][0] = "SUBREPORTFIRMA_DIR";
        mparametros[3][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
        mparametros[4][0] = "nbreUsuario";
        mparametros[4][1] = Principal.usuarioSistemaDTO.getNombreUsuario();
        if (this.JRB_VPreliminar.isSelected()) {
            this.xmt.GenerarPDF(this.xmt.getRutaRep() + xreporte, mparametros);
        } else if (this.JRB_VImpresora.isSelected()) {
            this.xmt.PresentacionImpresora(this.xmt.getRutaRep() + xreporte + ".jasper", mparametros);
        } else {
            this.xmt.EnviarPDFGeneradoHC(this.xmodelo.getValueAt(this.xposicion, 2).toString(), this.xmt.getRutaRep() + xreporte, mparametros, true, Boolean.valueOf(this.xmodelo.getValueAt(this.xposicion, 8).toString()).booleanValue(), this.correoUsuario, Principal.informacionGeneralPrincipalDTO.getIdModulo());
        }
    }

    private void mValidar_Detalle(int xTipo) {
        if (xTipo == 15) {
            try {
                this.xsql = "SELECT  `l_recepcion`.`Id` , `l_recepcion`.`FechaRecep` , `profesional1`.`Especialidad` , `profesional1`.`NProfesional`     FROM `l_detallerecepcion` INNER JOIN  `l_recepcion`  ON (`l_detallerecepcion`.`Id_Recepcion` = `l_recepcion`.`Id`) INNER JOIN  `l_resultados`  ON (`l_resultados`.`Id_Recepcion` = `l_recepcion`.`Id`) INNER JOIN  `l_detalleresultado`  ON (`l_detalleresultado`.`Id_Resultado` = `l_resultados`.`Id`) INNER JOIN  `l_protocoloxprocedimiento`  ON (`l_protocoloxprocedimiento`.`Id_Procedim` = `l_detallerecepcion`.`Id_Procedim`) AND (`l_detalleresultado`.`Id_ProtocolProcedim` = `l_protocoloxprocedimiento`.`Id`)  INNER JOIN  `f_ordenes`  ON (`f_ordenes`.`Id` = `l_recepcion`.`Id_OrdenFacturac`) INNER JOIN  `ingreso`  ON (`f_ordenes`.`Id_Ingreso` = `ingreso`.`Id`) INNER JOIN  `h_atencion`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`) INNER JOIN  `profesional1`  ON (`profesional1`.`Id_Persona` = `l_recepcion`.`Id_Profesional`) AND (`profesional1`.`IdEspecialidad` = `l_recepcion`.`Id_Especialidad`) WHERE (`h_atencion`.`Id` ='" + this.xId_Atencion + "' AND `l_recepcion`.`Estado` =0) GROUP BY `l_recepcion`.`Id` ORDER BY  `l_recepcion`.`FechaRecep` DESC ";
                ResultSet xrs = this.xct.traerRs(this.xsql);
                mCrearTabla_D1();
                if (xrs.next()) {
                    xrs.beforeFirst();
                    int x = 0;
                    this.xmt.mEstablecerTextEditor(this.JTBDetalle1, 1);
                    while (xrs.next()) {
                        this.xmodelod.addRow(this.xdato);
                        this.xmodelod.setValueAt(Long.valueOf(xrs.getLong(1)), x, 0);
                        this.xmodelod.setValueAt(xrs.getString(2), x, 1);
                        this.xmodelod.setValueAt(xrs.getString(3), x, 2);
                        this.xmodelod.setValueAt(xrs.getString(4), x, 3);
                        this.xmodelod.setValueAt(false, x, 4);
                        x++;
                    }
                }
                xrs.close();
                this.xct.cerrarConexionBd();
            } catch (SQLException ex) {
                Logger.getLogger(JPI_Control_Impresion.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        }
    }

    private void mValidar_Detalle_Evento() {
        try {
            this.xsql = "SELECT\n    `f_factura_glosa`.`Id`\n    , `f_factura_glosa`.`NRadicacionG`\n    , `f_factura_glosa`.`FechaG`\n    , `f_tipoconcepto_pago`.`Nbre`, f_factura_glosa_respuesta.`ValorR`, f_factura_glosa_respuesta.EsTraslado     \nFROM\n     `f_factura_evento`\n    INNER JOIN  `f_liquidacion` \n        ON (`f_factura_evento`.`Id_Liquidacion` = `f_liquidacion`.`Id`)\n    INNER JOIN  `ingreso` \n        ON (`ingreso`.`Id` = `f_liquidacion`.`Id_Ingreso`)\n    INNER JOIN  `a_eventoecat_paciente` \n        ON (`a_eventoecat_paciente`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN  `f_factura_glosa` \n        ON (`f_factura_glosa`.`Id_Liquidacion` = `f_liquidacion`.`Id`)\n    INNER JOIN  `f_factura_glosa_respuesta` \n        ON (`f_factura_glosa_respuesta`.`Id_Factura_glosa` = `f_factura_glosa`.`Id`)\n    INNER JOIN  `f_tipoconcepto_pago` \n        ON (`f_factura_glosa`.`Id_ConceptoG` = `f_tipoconcepto_pago`.`Id`)\nWHERE (`ingreso`.`Id` ='" + this.xId_Ingreso + "'\n    AND `f_liquidacion`.`Estado` =0\n    AND `f_factura_glosa`.`Estado` =1 AND f_factura_glosa_respuesta.`Estado`=1) ORDER BY `f_factura_glosa`.`Id` DESC";
            ResultSet xrs = this.xct.traerRs(this.xsql);
            mCrearTabla_Glosas();
            if (xrs.next()) {
                xrs.beforeFirst();
                int x = 0;
                this.xmt.mEstablecerTextEditor(this.JTBDetalle1, 3);
                while (xrs.next()) {
                    this.xmodelod.addRow(this.xdato);
                    this.xmodelod.setValueAt(Long.valueOf(xrs.getLong(1)), x, 0);
                    this.xmodelod.setValueAt(xrs.getString(2), x, 1);
                    this.xmodelod.setValueAt(xrs.getString(3), x, 2);
                    this.xmodelod.setValueAt(xrs.getString(4), x, 3);
                    this.xmodelod.setValueAt(false, x, 4);
                    this.xmodelod.setValueAt(Double.valueOf(xrs.getDouble("ValorR")), x, 5);
                    this.xmodelod.setValueAt(Boolean.valueOf(xrs.getBoolean("EsTraslado")), x, 6);
                    x++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPI_Control_Impresion.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTablaQx() {
        this.xmodelod = new DefaultTableModel(new Object[0], new String[]{"Id", "Fecha Inicial", "Hora Inicial", "Fecha Final", "Visualizar?", "Hora Final", "Tipo Anestesia"}) { // from class: Historia.JPI_Control_Impresion.17
            Class[] types = {Long.class, String.class, String.class, String.class, Boolean.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, true, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTBDetalle1.setModel(this.xmodelod);
        this.JTBDetalle1.getColumnModel().getColumn(0).setPreferredWidth(15);
        this.JTBDetalle1.getColumnModel().getColumn(1).setPreferredWidth(20);
        this.JTBDetalle1.getColumnModel().getColumn(2).setPreferredWidth(20);
        this.JTBDetalle1.getColumnModel().getColumn(3).setPreferredWidth(20);
        this.JTBDetalle1.getColumnModel().getColumn(4).setPreferredWidth(20);
        this.JTBDetalle1.getColumnModel().getColumn(5).setPreferredWidth(10);
        this.JTBDetalle1.getColumnModel().getColumn(6).setPreferredWidth(100);
    }

    private void mValidar_DetalleQx() {
        try {
            this.xsql = "SELECT\n  h_orden_qx.`Id`,\n  h_orden_qx.`Fecha_Inicial`,\n  h_orden_qx.`Hora_Inicla`,\n  h_orden_qx.`Fecha_Final`,\n  h_orden_qx.`Hora_Final`,\n  `f_tipoanestesia`.`Nbre`\nFROM\n  `h_orden_qx`\n  INNER JOIN f_tipoanestesia\n    ON (f_tipoanestesia.`Id` = h_orden_qx.`Id_Tipo_Anestesia`)\nWHERE (h_orden_qx.Id_Atencion = '" + this.xId_Atencion + "' AND h_orden_qx.`Estado` = 1 AND IF(h_orden_qx.`Fecha_Final` IS NULL, 0, 1) = 1)\nORDER BY h_orden_qx.`Fecha_Inicial`DESC, h_orden_qx.`Hora_Inicla` DESC";
            ResultSet xrs = this.xct.traerRs(this.xsql);
            mCrearTablaQx();
            if (xrs.next()) {
                xrs.beforeFirst();
                int x = 0;
                while (xrs.next()) {
                    this.xmodelod.addRow(this.xdato);
                    this.xmodelod.setValueAt(Long.valueOf(xrs.getLong(1)), x, 0);
                    this.xmodelod.setValueAt(xrs.getString(2), x, 1);
                    this.xmodelod.setValueAt(xrs.getString(3), x, 2);
                    this.xmodelod.setValueAt(xrs.getString(4), x, 3);
                    this.xmodelod.setValueAt(xrs.getString(5), x, 5);
                    this.xmodelod.setValueAt(false, x, 4);
                    this.xmodelod.setValueAt(xrs.getString(6), x, 6);
                    x++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPI_Control_Impresion.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mValidar_DetalleConsentimiento() {
        try {
            this.xsql = "SELECT\n    `ingreso_consentimiento_informado`.`Id`\n    , `h_tipoconsentimiento`.`Nbre` nombreConsentimiento\n    , `profesional1`.`Especialidad`\n    , `profesional1`.`NProfesional`\nFROM\n     `ingreso_consentimiento_informado`\n    INNER JOIN  `h_tipoconsentimiento` \n        ON (`ingreso_consentimiento_informado`.`Id_TipoConsentimiento` = `h_tipoconsentimiento`.`Id`)\n    INNER JOIN  `ingreso` \n        ON (`ingreso_consentimiento_informado`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN  `profesional1` \n        ON (`profesional1`.`IdEspecialidad` = `ingreso_consentimiento_informado`.`Id_Especialidad`) AND (`profesional1`.`Id_Persona` = `ingreso_consentimiento_informado`.`Id_Profesional`)\nWHERE (`ingreso_consentimiento_informado`.`Estado` =1\n    AND `ingreso`.`Id` =" + this.xId_Ingreso + ")";
            ResultSet xrs = this.xct.traerRs(this.xsql);
            mCrearTabla_Consentimiento();
            if (xrs.next()) {
                xrs.beforeFirst();
                int x = 0;
                while (xrs.next()) {
                    this.xmodelod.addRow(this.xdato);
                    this.xmodelod.setValueAt(Long.valueOf(xrs.getLong("Id")), x, 0);
                    this.xmodelod.setValueAt(xrs.getString("nombreConsentimiento"), x, 1);
                    this.xmodelod.setValueAt(xrs.getString("Especialidad"), x, 2);
                    this.xmodelod.setValueAt(xrs.getString("NProfesional"), x, 3);
                    this.xmodelod.setValueAt(false, x, 4);
                    x++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPI_Control_Impresion.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mValidar_Detalle() {
        try {
            this.xsql = "SELECT\n    `h_ordenes`.`Id`\n    , `h_ordenes`.`FechaOrden`\n    , `f_tiposervicio`.`Nbre`\n    , `g_especialidad`.`Nbre`\n    , CONCAT( `g_persona`.`Apellido1` ,' ' , `g_persona`.`Apellido2`,' ' ,`g_persona`.`Nombre1`,' ' ,`g_persona`.`Nombre2`) AS `Profesional`\n    , `h_ordenes`.`Id_TipoServicio`\nFROM\n     `h_ordenes`\n    INNER JOIN  `h_atencion` \n        ON (`h_ordenes`.`Id_Atencion` = `h_atencion`.`Id`)\n    INNER JOIN  `f_tiposervicio` \n        ON (`h_ordenes`.`Id_TipoServicio` = `f_tiposervicio`.`Id`)\n    INNER JOIN  `g_profesional` \n        ON (`g_profesional`.`Id_Persona` = `h_ordenes`.`Id_Profesional`)\n    INNER JOIN  `g_especialidad` \n        ON (`g_especialidad`.`Id` = `h_ordenes`.`Id_Especialidad`)\n    INNER JOIN  `g_persona` \n        ON (`g_persona`.`Id` = `g_profesional`.`Id_Persona`)\nWHERE (`h_atencion`.`Id` ='" + this.xId_Atencion + "'\n    AND `h_ordenes`.`Estado` =0 AND Id_TipoA=1)\nORDER BY `f_tiposervicio`.`Nbre` ASC, `h_atencion`.`Id` ASC";
            ResultSet xrs = this.xct.traerRs(this.xsql);
            Throwable th = null;
            try {
                mCrearTabla_D2();
                if (xrs.next()) {
                    xrs.beforeFirst();
                    int x = 0;
                    this.xmt.mEstablecerTextEditor(this.JTBDetalle1, 1);
                    while (xrs.next()) {
                        this.xmodelod.addRow(this.xdato);
                        this.xmodelod.setValueAt(Long.valueOf(xrs.getLong(1)), x, 0);
                        this.xmodelod.setValueAt(xrs.getString(2), x, 1);
                        this.xmodelod.setValueAt(xrs.getString(3), x, 2);
                        this.xmodelod.setValueAt(xrs.getString(4), x, 3);
                        this.xmodelod.setValueAt(false, x, 4);
                        this.xmodelod.setValueAt(xrs.getString(5), x, 5);
                        this.xmodelod.setValueAt(Long.valueOf(xrs.getLong(6)), x, 6);
                        x++;
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
        } catch (SQLException ex) {
            Logger.getLogger(JPI_Control_Impresion.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTablaEcografiaObstetrica() {
        this.xmodelod = new DefaultTableModel(new Object[0], new String[]{"Id", "Fecha", "Profesional", "Especialidad", "Seleccion"}) { // from class: Historia.JPI_Control_Impresion.18
            Class[] types = {String.class, String.class, String.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTBDetalle1.setModel(this.xmodelod);
        this.JTBDetalle1.getColumnModel().getColumn(0).setPreferredWidth(20);
        this.JTBDetalle1.getColumnModel().getColumn(1).setPreferredWidth(10);
        this.JTBDetalle1.getColumnModel().getColumn(2).setPreferredWidth(200);
        this.JTBDetalle1.getColumnModel().getColumn(3).setPreferredWidth(200);
        this.JTBDetalle1.getColumnModel().getColumn(4).setPreferredWidth(0);
        this.JTBDetalle1.getColumnModel().getColumn(4).setMinWidth(0);
        this.JTBDetalle1.getColumnModel().getColumn(4).setMaxWidth(0);
    }

    private void mValidar_Detalle_Ecografia() {
        try {
            mCrearTablaEcografiaObstetrica();
            String sql = "SELECT `h_ecog_obstetrica`.Id, DATE_FORMAT(`h_ecog_obstetrica`.`Fecha`,'%d-%m-%Y' ), `profesional1`.`NProfesional`, `profesional1`.`Especialidad`  FROM `h_ecog_obstetrica` INNER JOIN `h_atencion`  ON (`h_ecog_obstetrica`.`Id_Atencion` = `h_atencion`.`Id`) INNER JOIN `profesional1`  ON (`profesional1`.`Id_Persona` = `h_ecog_obstetrica`.`Id_Profesional`) AND (`profesional1`.`IdEspecialidad` = `h_ecog_obstetrica`.`Id_Especialidad`)  INNER JOIN `ingreso`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`) WHERE (`h_ecog_obstetrica`.`Id_Atencion` ='" + this.xId_Atencion + "')";
            ResultSet xrs = this.xct.traerRs(sql);
            Throwable th = null;
            try {
                try {
                    if (xrs.next()) {
                        xrs.beforeFirst();
                        int n = 0;
                        while (xrs.next()) {
                            this.xmodelod.addRow(this.xdato);
                            this.xmodelod.setValueAt(xrs.getString(1), n, 0);
                            this.xmodelod.setValueAt(xrs.getString(2), n, 1);
                            this.xmodelod.setValueAt(xrs.getString(3), n, 2);
                            this.xmodelod.setValueAt(xrs.getString(4), n, 3);
                            this.xmodelod.setValueAt(true, n, 4);
                            n++;
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
            } catch (Throwable th3) {
                th = th3;
                throw th3;
            }
        } catch (SQLException ex) {
            Logger.getLogger(JPI_Control_Impresion.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTablaEcografiaGeneral() {
        this.xmodelod = new DefaultTableModel(new Object[0], new String[]{"Id", "Fecha", "Tipo de Ecografia", "Especialidad", "Seleccion", "Profesional", "idAtencion"}) { // from class: Historia.JPI_Control_Impresion.19
            Class[] types = {Long.class, String.class, String.class, String.class, Boolean.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, true, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTBDetalle1.setModel(this.xmodelod);
        this.JTBDetalle1.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTBDetalle1.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTBDetalle1.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTBDetalle1.getColumnModel().getColumn(1).setPreferredWidth(10);
        this.JTBDetalle1.getColumnModel().getColumn(2).setPreferredWidth(250);
        this.JTBDetalle1.getColumnModel().getColumn(3).setPreferredWidth(50);
        this.JTBDetalle1.getColumnModel().getColumn(4).setPreferredWidth(50);
        this.JTBDetalle1.getColumnModel().getColumn(5).setPreferredWidth(80);
        this.JTBDetalle1.getColumnModel().getColumn(6).setPreferredWidth(0);
        this.JTBDetalle1.getColumnModel().getColumn(6).setMinWidth(0);
        this.JTBDetalle1.getColumnModel().getColumn(6).setMaxWidth(0);
    }

    private void mValidar_Detalle_Ecografia_General() {
        try {
            mCrearTablaEcografiaGeneral();
            String sql = "SELECT `h_ecografia_general`.`Id`, DATE_FORMAT(`h_ecografia_general`.`Fecha_R`,'%d-%m-%Y') AS `Fecha`, `g_procedimiento`.`Nbre`, `profesional1`.`Especialidad`, `profesional1`.`NProfesional`, h_ecografia_general.Id_Atencion FROM  `h_ecog_detalle` INNER JOIN  `h_ecografia_general`  ON (`h_ecog_detalle`.`Id_Ecografia` = `h_ecografia_general`.`Id`) INNER JOIN  `profesional1`  ON (`profesional1`.`IdEspecialidad` = `h_ecografia_general`.`Id_Especialidad`) AND (`profesional1`.`Id_Persona` = `h_ecografia_general`.`Id_Profesional`) INNER JOIN  `h_atencion`  ON (`h_atencion`.`Id` = `h_ecografia_general`.`Id_Atencion`) INNER JOIN  `c_clasecita`  ON (`h_ecografia_general`.`Id_ClaseCita` = `c_clasecita`.`Id`) INNER JOIN  `g_procedimiento`  ON (`c_clasecita`.`Id_Procedimiento` = `g_procedimiento`.`Id`) INNER JOIN  `ingreso`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`) WHERE (`ingreso`.`Id_Usuario` ='" + this.xId_Usuario + "' AND `h_ecografia_general`.`Estado` =1) GROUP BY `h_ecografia_general`.`Id` ORDER BY `h_ecografia_general`.`Fecha_R` DESC ";
            System.out.println(sql);
            ResultSet xrs = this.xct.traerRs(sql);
            Throwable th = null;
            try {
                try {
                    if (xrs.next()) {
                        xrs.beforeFirst();
                        int n = 0;
                        while (xrs.next()) {
                            this.xmodelod.addRow(this.xdato);
                            this.xmodelod.setValueAt(Long.valueOf(xrs.getLong(1)), n, 0);
                            this.xmodelod.setValueAt(xrs.getString(2), n, 1);
                            this.xmodelod.setValueAt(xrs.getString(3), n, 2);
                            this.xmodelod.setValueAt(xrs.getString(4), n, 3);
                            this.xmodelod.setValueAt(false, n, 4);
                            this.xmodelod.setValueAt(xrs.getString(5), n, 5);
                            this.xmodelod.setValueAt(xrs.getString(6), n, 6);
                            n++;
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
            } catch (Throwable th3) {
                th = th3;
                throw th3;
            }
        } catch (SQLException ex) {
            Logger.getLogger(JPASaludOcupacional.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloHistoricoFurtran() {
        this.xmodelod = new DefaultTableModel(new Object[0], new String[]{"Cod.", "Fecha", "Empresa", "Usuario", "Documento"}) { // from class: Historia.JPI_Control_Impresion.20
            Class[] types = {String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTBDetalle1.setModel(this.xmodelod);
        this.JTBDetalle1.getColumnModel().getColumn(0).setPreferredWidth(8);
        this.JTBDetalle1.getColumnModel().getColumn(1).setPreferredWidth(20);
        this.JTBDetalle1.getColumnModel().getColumn(2).setPreferredWidth(150);
        this.JTBDetalle1.getColumnModel().getColumn(3).setPreferredWidth(20);
        this.JTBDetalle1.getColumnModel().getColumn(4).setPreferredWidth(10);
    }

    @Override // Historia.CorreoListener
    public void onCorreoEnviadoExitosamente() {
        JOptionPane.showMessageDialog(this, "El correo ha sido enviado exitosamente.", "Éxito", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        GrabarLogBBitacota("correo enviado exito");
    }

    @Override // Historia.CorreoListener
    public void onCorreoError(String error) {
        JOptionPane.showMessageDialog(this, "Hubo un error al enviar el correo: " + error, "Error", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        GrabarLogBBitacota("correo error envio");
    }

    private void GrabarLogBBitacota(String state) {
        BitacoraCorreoDto bitacoraCorreoDto = new BitacoraCorreoDto();
        bitacoraCorreoDto.setCorreoEnvio(this.correoUsuario);
        bitacoraCorreoDto.setUsuarioSistemaEnvio(Principal.usuarioSistemaDTO.getNombreCargoUsuario());
        bitacoraCorreoDto.setHostAddress(Principal.getLocalHost().getHostAddress());
        bitacoraCorreoDto.setHostName(Principal.getLocalHost().getHostName());
        bitacoraCorreoDto.setCorreoRecibe(this.correoUsuario);
        bitacoraCorreoDto.setState(state);
        try {
            RecursosMicroserviciosDomain microserviciosDomain = this.xmt.getParametrosEncriptados("100", "LogBitacoraCorreo");
            Response responsePos = this.xmt.getResteasyClient().target(microserviciosDomain.getUrlRecurso()).request().post(Entity.json(this.xmt.getMapper().writeValueAsString(bitacoraCorreoDto)));
            CustomPresenter presenter = (CustomPresenter) this.xmt.getMapper().readValue((String) responsePos.readEntity(String.class), CustomPresenter.class);
            responsePos.close();
            this.xmt.getResteasyClient().close();
        } catch (JsonProcessingException e) {
            Logger.getLogger(JPI_Control_Impresion.class.getName()).log(Level.SEVERE, (String) null, e);
        }
    }

    private void eviarCorreosEps() {
        if (this.JTCorreos == null || this.modeloCorreo == null) {
            System.err.println("JTCorreos o modeloCorreo es null");
            return;
        }
        this.listaPdf.clear();
        this.listaCorreos.clear();
        for (int j = 0; j < this.JTBDetalle.getRowCount(); j++) {
            if (Boolean.parseBoolean(this.xmodelo.getValueAt(j, 4).toString())) {
                System.err.println("j" + j);
                String nombrePdf = this.xmodelo.getValueAt(j, 3).toString();
                this.datosPdf = new Object[]{this.xmt.getRutaRep() + nombrePdf + ".pdf"};
                this.listaPdf.add(this.datosPdf);
                System.err.println(this.xmt.getRutaRep() + "" + nombrePdf);
            }
        }
        for (int x = 0; x < this.JTCorreos.getRowCount(); x++) {
            if (Boolean.parseBoolean(this.modeloCorreo.getValueAt(x, 4).toString())) {
                System.err.println("x" + x);
                Object valueAt = this.modeloCorreo.getValueAt(x, 2);
                if (valueAt != null) {
                    System.err.println("k" + valueAt.toString());
                    this.datosCorreos = new Object[]{valueAt.toString()};
                    this.listaCorreos.add(this.datosCorreos);
                } else {
                    System.err.println("El valor en modeloCorreo.getValueAt(" + x + ", 2) es null");
                }
            }
        }
        mCrearPdf();
        new Enviar_Correo_Electronico("Solicitud de autorización", this.listaPdf, this.listaCorreos, this);
    }

    private void mCrearPdf() {
        this.listaarchivos = new ArrayList();
        System.err.println("this.xmt.mRutaSoporte(\"temp\")" + this.xmt.mRutaSoporte("temp"));
        for (int j = 0; j < this.JTBDetalle.getRowCount(); j++) {
            if (Boolean.parseBoolean(this.xmodelo.getValueAt(j, 4).toString())) {
                ClaseImpresionInformes impresionInformes = new ClaseImpresionInformes();
                ImpresionReportesDTO e = new ImpresionReportesDTO();
                e.setTitulo(this.xmodelo.getValueAt(j, 2).toString());
                e.setIdReporte(Long.valueOf(this.xmodelo.getValueAt(j, 0).toString()));
                e.setNombrePDF(this.xmodelo.getValueAt(j, 3).toString());
                e.setEspecial(Integer.valueOf(this.xmodelo.getValueAt(j, 5).toString()));
                e.setIdAtencion(Long.valueOf(this.xId_Atencion));
                e.setIdUsuario(Long.valueOf(this.xId_Usuario));
                e.setIdIngreso(Long.valueOf(this.xId_Ingreso));
                e.setIdTipoAtencion(Long.valueOf(this.Xid_TipoAtencion));
                e.setNoFactura("");
                e.setIdIdentificadorTipoFactura(0);
                e.setNit("");
                e.setRutaCarpeta(this.xmt.mRutaSoporte("temp"));
                e.setVisualizar(false);
                e.setEsDocumentoEscaneado(0);
                this.listaarchivos.addAll(impresionInformes.impresionReportes(e));
                this.listaarchivos.removeIf(item -> {
                    return item == null || "".equals(item) || !this.xmt.mExisteArchivo(item);
                });
            }
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTablaCorreo() {
        this.modeloCorreo = new DefaultTableModel(new Object[0], new String[]{"idModulo", "Area", "correo", "estado", "select"}) { // from class: Historia.JPI_Control_Impresion.21
            Class[] types = {String.class, String.class, String.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTCorreos.setModel(this.modeloCorreo);
        this.JTCorreos.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTCorreos.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTCorreos.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTCorreos.getColumnModel().getColumn(1).setPreferredWidth(150);
        this.JTCorreos.getColumnModel().getColumn(2).setPreferredWidth(150);
        this.JTCorreos.getColumnModel().getColumn(3).setPreferredWidth(0);
        this.JTCorreos.getColumnModel().getColumn(3).setMinWidth(0);
        this.JTCorreos.getColumnModel().getColumn(3).setMaxWidth(0);
        this.JTCorreos.getColumnModel().getColumn(4).setPreferredWidth(50);
    }

    /* JADX WARN: Not initialized variable reg: 11, insn: 0x0246: MOVE (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r11 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY] A[D('response' javax.ws.rs.core.Response)]) A[TRY_LEAVE], block:B:37:0x0246 */
    /* JADX WARN: Not initialized variable reg: 12, insn: 0x024b: MOVE (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r12 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:39:0x024b */
    private void buscarCorreosConvenio() {
        Response response;
        Throwable th;
        try {
            mCrearTablaCorreo();
            System.out.println("ingeso : " + this.xId_Ingreso);
            List<Ingreso> ingresos = this.ingresoService.listaIngresosPorEstadoYId(false, Long.valueOf(this.xId_Ingreso));
            if (ingresos != null && !ingresos.isEmpty()) {
                RecursosMicroserviciosDomain microserviciosDomain = this.xmt.getParametrosEncriptados("24", "ListaCorreosConvenio");
                String fullUrl = microserviciosDomain.getUrlRecurso() + "/" + ingresos.get(0).getIdEmpresaContxConv().getId();
                System.out.println("fullurlSql --- " + fullUrl);
                try {
                    try {
                        Response response2 = this.xmt.getResteasyClient().target(fullUrl).request().get();
                        Throwable th2 = null;
                        int statusCode = response2.getStatus();
                        if (statusCode == 200) {
                            try {
                                CustomPresenter presenter = (CustomPresenter) this.xmt.getMapper().readValue((String) response2.readEntity(String.class), CustomPresenter.class);
                                this.DetalleConvenioDTO = (ConvenioDTO) this.xmt.getMapper().readValue(this.xmt.getMapper().writeValueAsString(presenter.getData()), new TypeReference<ConvenioDTO>() { // from class: Historia.JPI_Control_Impresion.22
                                });
                                System.out.println("Antes de detalle convenio");
                                if (this.DetalleConvenioDTO != null) {
                                    List<CorreosConvenioDto> metadataDomain = this.DetalleConvenioDTO.getMetadataDomain();
                                    System.out.println("Despues del detalle convenio");
                                    if (metadataDomain != null) {
                                        for (CorreosConvenioDto correosConvenioDto : metadataDomain) {
                                            if (correosConvenioDto.getEstado().booleanValue()) {
                                                System.out.println("Correo: " + correosConvenioDto.getCorreo());
                                                this.modeloCorreo.addRow(this.xDatos);
                                                int lastRow = this.JTCorreos.getRowCount() - 1;
                                                this.JTCorreos.setValueAt(correosConvenioDto.getIdModulo(), lastRow, 0);
                                                this.JTCorreos.setValueAt(correosConvenioDto.getArea(), lastRow, 1);
                                                this.JTCorreos.setValueAt(correosConvenioDto.getCorreo(), lastRow, 2);
                                                this.JTCorreos.setValueAt(correosConvenioDto.getEstado(), lastRow, 3);
                                                this.JTCorreos.setValueAt(false, lastRow, 4);
                                            }
                                        }
                                    }
                                }
                            } catch (JsonProcessingException e) {
                                Logger.getLogger(JPI_Control_Impresion.class.getName()).log(Level.SEVERE, "Error al procesar el JSON", e);
                            }
                        } else {
                            Logger.getLogger(JPI_Control_Impresion.class.getName()).log(Level.SEVERE, "Error en la respuesta del servicio: " + statusCode);
                        }
                        if (response2 != null) {
                            if (0 != 0) {
                                try {
                                    response2.close();
                                } catch (Throwable th3) {
                                    th2.addSuppressed(th3);
                                }
                            } else {
                                response2.close();
                            }
                        }
                    } catch (ProcessingException e2) {
                        Logger.getLogger(JPI_Control_Impresion.class.getName()).log(Level.SEVERE, "El microservicio no está disponible", e2);
                    }
                    this.xmt.getResteasyClient().close();
                } catch (Throwable th4) {
                    if (response != null) {
                        if (th != null) {
                            try {
                                response.close();
                            } catch (Throwable th5) {
                                th.addSuppressed(th5);
                            }
                        } else {
                            response.close();
                        }
                    }
                    throw th4;
                }
            } else {
                System.err.println("No se encontraron ingresos para el estado y ID especificados.");
            }
        } catch (NumberFormatException e3) {
            Logger.getLogger(JPI_Control_Impresion.class.getName()).log(Level.SEVERE, "Error de formato de número", (Throwable) e3);
        }
    }

    private void mBuscarFurtran() {
        mCrearModeloHistoricoFurtran();
        String sql = "SELECT a_furtran.`Id` , a_furtran.`FechaR` , a_furtran.`NEmpresaT` , CONCAT(a_furtran.`Apellido1`, '' ,a_furtran.`Apellido2`, ' ', a_furtran.`Nombre1`, ' ', a_furtran.`Nombre2`) AS Usuario, a_furtran.`NumDocumento` \nFROM `a_furtran`\nINNER JOIN `a_furtran_persona` ON (`a_furtran_persona`.`IdFurtran` = a_furtran.`Id`)\nINNER JOIN `a_eventoecat_paciente` ON (`a_eventoecat_paciente`.`Id` = a_furtran_persona.`IdPersonaEvento`)\nWHERE (`a_eventoecat_paciente`.`Id_Ingreso` ='" + this.xId_Ingreso + "' AND a_furtran.`Estado` =1) ORDER BY a_furtran.`FechaR` DESC;";
        ConsultasMySQL xct1 = new ConsultasMySQL();
        ResultSet xrs = xct1.traerRs(sql);
        try {
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelod.addRow(this.xdato);
                    this.xmodelod.setValueAt(xrs.getString(1), n, 0);
                    this.xmodelod.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelod.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelod.setValueAt(xrs.getString(4), n, 3);
                    this.xmodelod.setValueAt(xrs.getString(5), n, 4);
                    n++;
                }
            }
            xrs.close();
            xct1.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPI_Control_Impresion.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTablaOrdenesFormulaMedica() {
        this.xmodelod = new DefaultTableModel(new Object[0], new String[]{"No. Orden", "Fecha", "Tipo Formula", "Profesional", "Visualizar?"}) { // from class: Historia.JPI_Control_Impresion.23
            Class[] types = {Long.class, String.class, String.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTBDetalle1.setModel(this.xmodelod);
        this.JTBDetalle1.getColumnModel().getColumn(0).setPreferredWidth(80);
        this.JTBDetalle1.getColumnModel().getColumn(1).setPreferredWidth(150);
        this.JTBDetalle1.getColumnModel().getColumn(2).setPreferredWidth(350);
        this.JTBDetalle1.getColumnModel().getColumn(3).setPreferredWidth(400);
        this.JTBDetalle1.getColumnModel().getColumn(4).setPreferredWidth(50);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTablaOrdenesIncapacidad() {
        this.xmodelod = new DefaultTableModel(new Object[0], new String[]{"No.", "Fecha", "Profesional", "Especialidad", "Visualizar?"}) { // from class: Historia.JPI_Control_Impresion.24
            Class[] types = {Long.class, Date.class, String.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTBDetalle1.setModel(this.xmodelod);
        this.JTBDetalle1.getColumnModel().getColumn(0).setPreferredWidth(80);
        this.JTBDetalle1.getColumnModel().getColumn(1).setPreferredWidth(150);
        this.JTBDetalle1.getColumnModel().getColumn(2).setPreferredWidth(400);
        this.JTBDetalle1.getColumnModel().getColumn(2).setPreferredWidth(200);
        this.JTBDetalle1.getColumnModel().getColumn(3).setPreferredWidth(100);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTablaAnexo1() {
        this.xmodelod = new DefaultTableModel(new Object[0], new String[]{"No.", "IdIngreso", "Fecha", "Anexo", "Visualizar?", "tipoAnexo", "Profesional", "Especialidad"}) { // from class: Historia.JPI_Control_Impresion.25
            Class[] types = {Long.class, Long.class, Date.class, String.class, Boolean.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, true, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTBDetalle1.setModel(this.xmodelod);
        this.JTBDetalle1.getColumnModel().getColumn(0).setPreferredWidth(50);
        this.JTBDetalle1.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTBDetalle1.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTBDetalle1.getColumnModel().getColumn(3).setPreferredWidth(200);
        this.JTBDetalle1.getColumnModel().getColumn(4).setPreferredWidth(50);
        this.JTBDetalle1.getColumnModel().getColumn(5).setPreferredWidth(200);
        this.JTBDetalle1.getColumnModel().getColumn(6).setPreferredWidth(200);
        this.JTBDetalle1.getColumnModel().getColumn(7).setPreferredWidth(100);
    }

    private void mCargarAnexo() {
        mCrearTablaAnexo1();
        String sql = " SELECT `id`, `ingresoId`, `fechaRegistro`,\n CASE \n WHEN `tipoAnexo` = 1 \n THEN 'Actualización de datos decontacto'\n WHEN `tipoAnexo` = 2 \n THEN 'Informe delaatención deurgencias'\n WHEN `tipoAnexo` = 3 \n THEN 'Solicitud de autorización de servicios y tecnologías en salud '\n WHEN `tipoAnexo` = 5 \n THEN 'Referencia'\n WHEN `tipoAnexo` = 6 \n THEN 'Contrarreferencia' \n END  AS 'Anexo' \n , tipoAnexo \n , `profesional1`.`NProfesional`\n , `profesional1`.`Especialidad`\nFROM  `h_anexo_resolucion_2335`\nLEFT JOIN `profesional1` ON h_anexo_resolucion_2335.`profesionalId`=profesional1.`Id_Persona` \nAND h_anexo_resolucion_2335.`especialidadId`=profesional1.`IdEspecialidad`\nWHERE h_anexo_resolucion_2335.`ingresoId` = '" + this.xId_Ingreso + "'";
        System.out.println(sql);
        ConsultasMySQL xct1 = new ConsultasMySQL();
        ResultSet xrs = xct1.traerRs(sql);
        try {
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelod.addRow(this.xdato);
                    this.xmodelod.setValueAt(Long.valueOf(xrs.getLong("id")), n, 0);
                    this.xmodelod.setValueAt(Long.valueOf(xrs.getLong("ingresoId")), n, 1);
                    this.xmodelod.setValueAt(xrs.getDate("fechaRegistro"), n, 2);
                    this.xmodelod.setValueAt(xrs.getString("Anexo"), n, 3);
                    this.xmodelod.setValueAt(false, n, 4);
                    this.xmodelod.setValueAt(xrs.getString("tipoAnexo"), n, 5);
                    this.xmodelod.setValueAt(xrs.getString("NProfesional"), n, 6);
                    this.xmodelod.setValueAt(xrs.getString("Especialidad"), n, 7);
                    n++;
                }
            }
            xrs.close();
            xct1.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPI_Control_Impresion.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarOrdenesIncapacidad() {
        mCrearTablaOrdenesIncapacidad();
        String sql = "SELECT  hi.`Id` numeroIncapacidad,  hi.FechaInicio fechaInicio, concat(gp.Apellido1,' ', gp.Apellido2, ' ', gp.Nombre1 ,' ', gp.Nombre2) profesional, ge.Nbre  especialidad\nFROM  `h_incapacidad` hi\ninner join g_persona gp on (gp.Id=hi.Id_Profesional)\ninner join g_especialidad ge on (ge.Id=hi.Id_Especialidad)\nWHERE (hi.`IdAtencion` ='" + this.xId_Atencion + "'  AND hi.`Estado` =0)";
        System.out.println(sql);
        ConsultasMySQL xct1 = new ConsultasMySQL();
        ResultSet xrs = xct1.traerRs(sql);
        try {
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelod.addRow(this.xdato);
                    this.xmodelod.setValueAt(Long.valueOf(xrs.getLong("numeroIncapacidad")), n, 0);
                    this.xmodelod.setValueAt(xrs.getDate("fechaInicio"), n, 1);
                    this.xmodelod.setValueAt(xrs.getString("profesional"), n, 2);
                    this.xmodelod.setValueAt(xrs.getString("especialidad"), n, 3);
                    this.xmodelod.setValueAt(false, n, 4);
                    n++;
                }
            }
            xrs.close();
            xct1.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPI_Control_Impresion.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarOrdenesFormulaMedica() {
        mCrearTablaOrdenesFormulaMedica();
        String sql = "SELECT h_ordenes.Id, h_ordenes.FechaOrden, h_tipoformula.Nbre, CONCAT(g_persona.Apellido1,' ',g_persona.Apellido2,' ',g_persona.Nombre1,' ',g_persona.Nombre2) AS NOMBREPROFSIONAL, h_ordenes.Estado, h_ordenes.EstaEntregada FROM h_tipoformula INNER JOIN h_ordenes ON (h_tipoformula.Id = h_ordenes.IdTipoFormula) INNER JOIN h_atencion  ON (h_ordenes.Id_Atencion = h_atencion.Id) INNER JOIN baseserver.ingreso  ON (ingreso.Id = h_atencion.Id_Ingreso) INNER JOIN baseserver.g_profesional  ON (`h_ordenes`.Id_Profesional = g_profesional.Id_Persona) INNER JOIN baseserver.g_persona ON (g_profesional.Id_Persona = g_persona.Id) WHERE (h_ordenes.Id_TipoServicio =7 and h_atencion.Id='" + this.xId_Atencion + "' and h_ordenes.Estado=0) ORDER BY h_ordenes.FechaOrden desc; ";
        ConsultasMySQL xct1 = new ConsultasMySQL();
        ResultSet xrs = xct1.traerRs(sql);
        try {
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelod.addRow(this.xdato);
                    this.xmodelod.setValueAt(Long.valueOf(xrs.getLong(1)), n, 0);
                    this.xmodelod.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelod.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelod.setValueAt(xrs.getString(4), n, 3);
                    this.xmodelod.setValueAt(false, n, 4);
                    n++;
                }
            }
            xrs.close();
            xct1.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPI_Control_Impresion.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mImprimir_RLaboratorio() {
        for (int x = 0; x < this.JTBDetalle1.getRowCount(); x++) {
            if (Boolean.valueOf(this.xmodelod.getValueAt(x, 4).toString()).booleanValue()) {
                ImpresionReportesDAOImpl impresion = new ImpresionReportesDAOImpl();
                if (this.JRB_VPreliminar.isSelected()) {
                    impresion.mImprimirResultado(this.xmodelod.getValueAt(x, 0).toString(), "", this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra(), this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra(), true, String.valueOf(this.xId_Usuario), true);
                } else if (this.JRB_VImpresora.isSelected()) {
                    impresion.mImprimirResultado(this.xmodelod.getValueAt(x, 0).toString(), "", this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra(), this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra(), true, String.valueOf(this.xId_Usuario), true);
                } else {
                    impresion.mImprimirResultado(this.xmodelod.getValueAt(x, 0).toString(), "", this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra(), this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra(), true, String.valueOf(this.xId_Usuario), false);
                    this.xmt.EnviarPDFGeneradoHC(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 2).toString(), this.xmt.getRutaRep() + Principal.informacionIps.getPrefijoReportes() + "L_Reporte_Resultado_Con_Encabezado", (String[][]) null, false, Boolean.valueOf(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 8).toString()).booleanValue(), this.correoUsuario, Principal.informacionGeneralPrincipalDTO.getIdModulo());
                }
            }
        }
    }

    private void mImprimirInformeQx() {
        for (int x = 0; x < this.JTBDetalle1.getRowCount(); x++) {
            if (Boolean.valueOf(this.xmodelod.getValueAt(x, 4).toString()).booleanValue()) {
                String[][] mparametros = new String[5][2];
                mparametros[0][0] = "Id";
                mparametros[0][1] = this.xmodelod.getValueAt(x, 0).toString();
                mparametros[1][0] = "SUBREPORT_DIR";
                mparametros[1][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
                mparametros[2][0] = "SUBREPORTFIRMA_DIR";
                mparametros[2][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
                mparametros[3][0] = "tituloReporte";
                mparametros[3][1] = this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 2).toString();
                mparametros[4][0] = "nbreUsuario";
                mparametros[4][1] = Principal.usuarioSistemaDTO.getNombreUsuario();
                if (this.JRB_VPreliminar.isSelected()) {
                    this.xmt.CrearPDF(this.xmt.getRutaRep() + this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 3).toString(), mparametros, this.xmt.getRutaRep() + "InformeQx_" + this.xmodelod.getValueAt(x, 0).toString());
                    this.xmt.mostrarPdf(this.xmt.getRutaRep() + "InformeQx_" + this.xmodelod.getValueAt(x, 0).toString() + ".pdf");
                } else if (this.JRB_VImpresora.isSelected()) {
                    this.xmt.PresentacionImpresora(this.xmt.getRutaRep() + this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 3).toString() + ".jasper", mparametros);
                } else {
                    this.xmt.CrearPDF(this.xmt.getRutaRep() + this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 3).toString(), mparametros, this.xmt.getRutaRep() + "InformeQx_" + this.xmodelod.getValueAt(x, 0).toString());
                    this.xmt.EnviarPDFGeneradoHC(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 2).toString(), this.xmt.getRutaRep() + "InformeQx_" + this.xmodelod.getValueAt(x, 0).toString(), (String[][]) null, false, Boolean.valueOf(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 8).toString()).booleanValue(), this.correoUsuario, Principal.informacionGeneralPrincipalDTO.getIdModulo());
                }
            }
        }
    }

    private void mImprimirInformeIncapacidad() {
        for (int x = 0; x < this.JTBDetalle1.getRowCount(); x++) {
            if (Boolean.valueOf(this.xmodelod.getValueAt(x, 4).toString()).booleanValue()) {
                String[][] mparametros = new String[5][2];
                mparametros[0][0] = "Id";
                mparametros[0][1] = this.xmodelod.getValueAt(x, 0).toString();
                mparametros[1][0] = "SUBREPORT_DIR";
                mparametros[1][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
                mparametros[2][0] = "SUBREPORTFIRMA_DIR";
                mparametros[2][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
                mparametros[3][0] = "tituloReporte";
                mparametros[3][1] = this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 2).toString();
                mparametros[4][0] = "nbreUsuario";
                mparametros[4][1] = Principal.usuarioSistemaDTO.getNombreUsuario();
                if (this.JRB_VPreliminar.isSelected()) {
                    this.xmt.GenerarPDF(this.xmt.getRutaRep() + this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 3).toString(), mparametros);
                } else if (this.JRB_VImpresora.isSelected()) {
                    this.xmt.PresentacionImpresora(this.xmt.getRutaRep() + this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 3).toString() + ".jasper", mparametros);
                } else {
                    this.xmt.EnviarPDFGeneradoHC(this.xmodelo.getValueAt(x, 2).toString(), this.xmt.getRutaRep() + this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 3).toString(), mparametros, true, Boolean.valueOf(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 8).toString()).booleanValue(), this.correoUsuario, Principal.informacionGeneralPrincipalDTO.getIdModulo());
                }
                Principal.mGrabarLogAtenciones(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 3).toString(), this.xId_Atencion, String.valueOf(this.xId_Usuario));
            }
        }
    }

    private void mImprimirEcografia(String nombreReporte) {
        for (int x = 0; x < this.JTBDetalle1.getRowCount(); x++) {
            String[][] mparametros = new String[4][2];
            mparametros[0][0] = "idatencion1";
            mparametros[0][1] = this.xmodelod.getValueAt(this.JTBDetalle1.getSelectedRow(), 0).toString();
            mparametros[1][0] = "SUBREPORT_DIR";
            mparametros[1][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
            mparametros[2][0] = "SUBREPORTFIRMA_DIR";
            mparametros[2][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
            mparametros[3][0] = "nbreUsuario";
            mparametros[3][1] = Principal.usuarioSistemaDTO.getNombreUsuario();
            if (this.JRB_VPreliminar.isSelected()) {
                this.xmt.GenerarPDF(this.xmt.getRutaRep() + nombreReporte, mparametros);
            } else if (this.JRB_VImpresora.isSelected()) {
                this.xmt.PresentacionImpresora(this.xmt.getRutaRep() + nombreReporte + ".jasper", mparametros);
            } else {
                this.xmt.EnviarPDFGeneradoHC(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 2).toString(), this.xmt.getRutaRep() + nombreReporte, mparametros, true, Boolean.valueOf(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 8).toString()).booleanValue(), this.correoUsuario, Principal.informacionGeneralPrincipalDTO.getIdModulo());
            }
        }
    }

    public void mImprimirEcografiaGeneral(String nombreReporte) {
        String[][] mparametros = new String[4][2];
        mparametros[0][0] = "idatencion1";
        mparametros[0][1] = this.xmodelod.getValueAt(this.JTBDetalle1.getSelectedRow(), 0).toString();
        mparametros[1][0] = "SUBREPORT_DIR";
        mparametros[1][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
        mparametros[2][0] = "SUBREPORTFIRMA_DIR";
        mparametros[2][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
        mparametros[3][0] = "nbreUsuario";
        mparametros[3][1] = Principal.usuarioSistemaDTO.getNombreUsuario();
        if (this.JRB_VPreliminar.isSelected()) {
            this.xmt.GenerarPDF(this.xmt.getRutaRep() + nombreReporte, mparametros);
        } else if (this.JRB_VImpresora.isSelected()) {
            this.xmt.PresentacionImpresora(this.xmt.getRutaRep() + nombreReporte + ".jasper", mparametros);
        } else {
            this.xmt.EnviarPDFGeneradoHC(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 2).toString(), this.xmt.getRutaRep() + "Pajonal_H_Ecografia_General", mparametros, true, Boolean.valueOf(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 8).toString()).booleanValue(), this.correoUsuario, Principal.informacionGeneralPrincipalDTO.getIdModulo());
        }
    }

    public void mImprimirOrdenFormulaMedica() {
        for (int x = 0; x < this.JTBDetalle1.getRowCount(); x++) {
            if (Boolean.valueOf(this.xmodelod.getValueAt(x, 4).toString()).booleanValue()) {
                mImprimir_Formula(this.xmodelod.getValueAt(x, 0).toString());
            }
        }
    }
}
