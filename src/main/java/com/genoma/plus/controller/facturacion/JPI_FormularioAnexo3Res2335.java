package com.genoma.plus.controller.facturacion;

import Acceso.Principal;
import Facturacion.BuscarProced;
import Facturacion.BuscarSum;
import Facturacion.JIFLiqServicios;
import Historia.clasesHistoriaCE;
import Utilidades.CargarCombosVarios;
import Utilidades.CustomPopupMenuListener;
import Utilidades.LlenarCombosGenericos;
import Utilidades.Metodos;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.genoma.plus.controller.historia.ImpresionAnexo2335;
import com.genoma.plus.controller.historia.dto.Anexo2335Dto;
import com.genoma.plus.controller.historia.dto.Anexo3Dto;
import com.genoma.plus.controller.historia.dto.AnexoDatoUsuarioDto;
import com.genoma.plus.controller.historia.dto.AnexoInformacionIpsDto;
import com.genoma.plus.controller.historia.dto.ListaCodigoOtrosDto;
import com.genoma.plus.controller.historia.dto.ListaCumDetalleDto;
import com.genoma.plus.controller.historia.dto.ListaCupsDetalleDto;
import com.genoma.plus.controller.laboratorio.dto.CustomPresenter;
import com.genoma.plus.dao.facturacion.FacturacionDAO;
import com.genoma.plus.dao.facturacion.OrdenAnexo3DAO;
import com.genoma.plus.dao.general.InformacionProfesionalDAO;
import com.genoma.plus.dao.general.PatologiaCie10DAO;
import com.genoma.plus.dao.impl.facturacion.FacturacionDAOImp;
import com.genoma.plus.dao.impl.facturacion.OrdenAnexo3DAOImpl;
import com.genoma.plus.dao.impl.general.InformacionProfesionalDAOImpl;
import com.genoma.plus.dao.impl.general.PatologiaCie10DAOImpl;
import com.genoma.plus.domains.models.domains.general.RecursosMicroserviciosDomain;
import com.genoma.plus.dto.facturacion.GenericoDTO;
import com.genoma.plus.dto.general.PatologiaCie10DTO;
import com.genoma.plus.jpa.entities.GServicioGrupoEntity;
import com.genoma.plus.jpa.entities.GServicioRipsEntity;
import com.genoma.plus.jpa.projection.OrdenProcedimientoProjection;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.InputMethodEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;
import org.jdesktop.jdnc.incubator.jxcombobox.IncompatibleLookAndFeelException;
import org.jdesktop.jdnc.incubator.jxcombobox.JTableComboBox;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/facturacion/JPI_FormularioAnexo3Res2335.class */
public class JPI_FormularioAnexo3Res2335 extends JPanel {
    private InformacionProfesionalDAO informacionProfesionalDAO;
    private OrdenAnexo3DAO ordenAnexo3DAO;
    private FacturacionDAO facturacionDAO;
    private PatologiaCie10DAO patologiaCie10DAO;
    private String[] idEspecialidad;
    private String[] idProfesional;
    private DefaultTableModel modeloDetalleProcedimiento;
    private DefaultTableModel modeloHistorico;
    private DefaultTableModel modeloSuministro;
    private DefaultTableModel modeloOtroProcedimiento;
    private Object[] dato;
    private clasesHistoriaCE historiaCE;
    private String idIngreso;
    private boolean xlleno;
    public List<GServicioGrupoEntity> listGrupoEntitys;
    public List<GServicioRipsEntity> ListripsEntitys;
    private String codigoRips;
    private JButton JBT_Adicionar;
    private JButton JBT_Adicionar1;
    private JButton JBT_Adicionar2;
    public JComboBox JCBEspecialidad;
    public JTableComboBox JCBFinProcedimiento;
    public JComboBox JCBGrupoSevicio;
    public JComboBox JCBProfesional;
    public JComboBox JCBSevicioRips;
    private JCheckBox JCH_No_Prioritaria;
    private JCheckBox JCH_Prioritaria;
    private JCheckBox JCH_S_Prioritaria;
    private JCheckBox JCH_S_Urgencia;
    private JCheckBox JCH_S_programable;
    private JLabel JLB_NConsecutivo;
    private JLabel JLB_NRegistro;
    private JPanel JPI_DatosAnexo;
    private JPanel JPI_DatosProc;
    private JPanel JPI_DatosProc1;
    private JPanel JPI_DatosProc2;
    private JPanel JPI_Detalle;
    private JPanel JPI_Detalle1;
    private JPanel JPI_Detalle2;
    private JPanel JPI_Historico;
    private JPanel JPI_InformacionEncabezado;
    private JPanel JPI_Justificacion;
    private JScrollPane JSPDetalleDoc;
    private JScrollPane JSPDetalleDoc1;
    private JScrollPane JSPDetalleDoc2;
    private JScrollPane JSPHistorico;
    private JSpinner JSP_Cantidad;
    private JSpinner JSP_CantidadOtroProc;
    private JSpinner JSP_CantidadSuministro;
    private JTable JTBDetalle;
    private JTable JTBDetalleOtroProc;
    private JTable JTBDetalleSuministro;
    public JTextField JTFCDxP;
    private JTextField JTFCDxR1;
    private JTextField JTFCDxR2;
    private JTextField JTFCDxR3;
    private JFormattedTextField JTFF_Hora;
    public JTextField JTFNCodigoDxP;
    private JTextField JTFNDxR1;
    private JTextField JTFNDxR2;
    private JTextField JTFNDxR3;
    public JTextField JTF_Codigo;
    public JTextField JTF_CodigoOtroProc;
    public JTextField JTF_CodigoSuministro;
    public JTextField JTF_NOtroProcedimiento;
    public JTextField JTF_NProcedimiento;
    public JTextField JTF_NSuministro;
    private JTable JTHistorico;
    public JTabbedPane JTPDatos;
    public JTabbedPane JTPFomurlario;
    private JDateChooser jDateChooser;
    private JLabel jLabel1;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private Metodos metodos = new Metodos();
    private Boolean estadoLlenadoCombos = false;
    private int xnfila = -1;
    private int xnfilaS = -1;
    private int xnfilaOP = -1;
    private String prioridad = "02";
    private String TipoAtencion = "01";
    int index = 0;
    private CargarCombosVarios cargarCombosVarios = new CargarCombosVarios();

    public JPI_FormularioAnexo3Res2335(String idIngreso, JIFLiqServicios xjifliq, String codigoRips) {
        initComponents();
        springStart();
        setCodigoRips(codigoRips);
        this.idIngreso = idIngreso;
        if (Principal.clasehistoriace == null) {
            this.historiaCE = new clasesHistoriaCE();
        } else {
            this.historiaCE = Principal.clasehistoriace;
        }
        nuevo();
    }

    /* JADX WARN: Type inference failed for: r3v320, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JTPFomurlario = new JTabbedPane();
        this.JPI_DatosAnexo = new JPanel();
        this.JPI_InformacionEncabezado = new JPanel();
        this.JCBEspecialidad = new JComboBox();
        this.JCBProfesional = new JComboBox();
        this.JLB_NRegistro = new JLabel();
        this.JTFF_Hora = new JFormattedTextField();
        this.JLB_NConsecutivo = new JLabel();
        this.jDateChooser = new JDateChooser();
        this.JTPDatos = new JTabbedPane();
        this.JPI_Justificacion = new JPanel();
        this.JTFCDxP = new JTextField();
        this.JTFNCodigoDxP = new JTextField();
        this.jLabel1 = new JLabel();
        this.JTFNDxR1 = new JTextField();
        this.JTFCDxR1 = new JTextField();
        this.JTFCDxR2 = new JTextField();
        this.JTFNDxR2 = new JTextField();
        this.JTFCDxR3 = new JTextField();
        this.JTFNDxR3 = new JTextField();
        this.jPanel1 = new JPanel();
        this.JCH_Prioritaria = new JCheckBox();
        this.JCH_No_Prioritaria = new JCheckBox();
        this.jPanel2 = new JPanel();
        this.JCH_S_Urgencia = new JCheckBox();
        this.JCH_S_Prioritaria = new JCheckBox();
        this.JCH_S_programable = new JCheckBox();
        this.JPI_Detalle = new JPanel();
        this.JPI_DatosProc = new JPanel();
        this.JTF_Codigo = new JTextField();
        this.JTF_NProcedimiento = new JTextField();
        this.JSP_Cantidad = new JSpinner();
        this.JBT_Adicionar = new JButton();
        this.JCBGrupoSevicio = new JComboBox();
        try {
            this.JCBFinProcedimiento = new JTableComboBox();
        } catch (IncompatibleLookAndFeelException e1) {
            e1.printStackTrace();
        }
        this.JCBSevicioRips = new JComboBox();
        this.JSPDetalleDoc = new JScrollPane();
        this.JTBDetalle = new JTable();
        this.JPI_Detalle2 = new JPanel();
        this.JPI_DatosProc2 = new JPanel();
        this.JTF_CodigoOtroProc = new JTextField();
        this.JTF_NOtroProcedimiento = new JTextField();
        this.JSP_CantidadOtroProc = new JSpinner();
        this.JBT_Adicionar2 = new JButton();
        this.JSPDetalleDoc2 = new JScrollPane();
        this.JTBDetalleOtroProc = new JTable();
        this.JPI_Detalle1 = new JPanel();
        this.JPI_DatosProc1 = new JPanel();
        this.JTF_CodigoSuministro = new JTextField();
        this.JTF_NSuministro = new JTextField();
        this.JSP_CantidadSuministro = new JSpinner();
        this.JBT_Adicionar1 = new JButton();
        this.JSPDetalleDoc1 = new JScrollPane();
        this.JTBDetalleSuministro = new JTable();
        this.JPI_Historico = new JPanel();
        this.JSPHistorico = new JScrollPane();
        this.JTHistorico = new JTable();
        setName("xjpi_formulaanexo3Res2335");
        this.JTPFomurlario.setForeground(Color.red);
        this.JTPFomurlario.setFont(new Font("Arial", 1, 14));
        this.JPI_InformacionEncabezado.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN ENCABEZADO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JCBEspecialidad.setFont(new Font("Arial", 1, 12));
        this.JCBEspecialidad.setBorder(BorderFactory.createTitledBorder((Border) null, "Especialidad", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JCBEspecialidad.addItemListener(new ItemListener() { // from class: com.genoma.plus.controller.facturacion.JPI_FormularioAnexo3Res2335.1
            public void itemStateChanged(ItemEvent evt) {
                JPI_FormularioAnexo3Res2335.this.JCBEspecialidadItemStateChanged(evt);
            }
        });
        this.JCBProfesional.setFont(new Font("Arial", 1, 12));
        this.JCBProfesional.setBorder(BorderFactory.createTitledBorder((Border) null, "Profesional", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JLB_NRegistro.setFont(new Font("Arial", 1, 14));
        this.JLB_NRegistro.setHorizontalAlignment(0);
        this.JLB_NRegistro.setBorder(BorderFactory.createTitledBorder((Border) null, "No.", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JTFF_Hora.setBorder(BorderFactory.createTitledBorder((Border) null, "Hora", 0, 0, new Font("Arial", 1, 12), Color.blue));
        try {
            this.JTFF_Hora.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("##:##:##")));
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        this.JTFF_Hora.setHorizontalAlignment(4);
        this.JTFF_Hora.setToolTipText("Formato hh:mm p");
        this.JTFF_Hora.setFont(new Font("Arial", 1, 12));
        this.JTFF_Hora.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.facturacion.JPI_FormularioAnexo3Res2335.2
            public void actionPerformed(ActionEvent evt) {
                JPI_FormularioAnexo3Res2335.this.JTFF_HoraActionPerformed(evt);
            }
        });
        this.JTFF_Hora.addFocusListener(new FocusAdapter() { // from class: com.genoma.plus.controller.facturacion.JPI_FormularioAnexo3Res2335.3
            public void focusGained(FocusEvent evt) {
                JPI_FormularioAnexo3Res2335.this.JTFF_HoraFocusGained(evt);
            }
        });
        this.JLB_NConsecutivo.setFont(new Font("Arial", 1, 14));
        this.JLB_NConsecutivo.setBorder(BorderFactory.createTitledBorder((Border) null, "No. Consecutivo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jDateChooser.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jDateChooser.setDateFormatString("dd/MM/yyyy");
        this.jDateChooser.setFont(new Font("Arial", 1, 12));
        GroupLayout JPI_InformacionEncabezadoLayout = new GroupLayout(this.JPI_InformacionEncabezado);
        this.JPI_InformacionEncabezado.setLayout(JPI_InformacionEncabezadoLayout);
        JPI_InformacionEncabezadoLayout.setHorizontalGroup(JPI_InformacionEncabezadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_InformacionEncabezadoLayout.createSequentialGroup().addContainerGap().addGroup(JPI_InformacionEncabezadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBEspecialidad, -2, 301, -2).addGroup(JPI_InformacionEncabezadoLayout.createSequentialGroup().addComponent(this.jDateChooser, -2, -1, -2).addGap(11, 11, 11).addComponent(this.JTFF_Hora, -2, 90, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPI_InformacionEncabezadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_InformacionEncabezadoLayout.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.JLB_NRegistro, -2, 123, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JLB_NConsecutivo, -2, 122, -2)).addComponent(this.JCBProfesional, -2, 400, -2)).addGap(15, 15, 15)));
        JPI_InformacionEncabezadoLayout.setVerticalGroup(JPI_InformacionEncabezadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_InformacionEncabezadoLayout.createSequentialGroup().addGroup(JPI_InformacionEncabezadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JLB_NRegistro, -1, -1, 32767).addComponent(this.JLB_NConsecutivo, -1, -1, 32767).addGroup(JPI_InformacionEncabezadoLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jDateChooser, -2, -1, -2).addComponent(this.JTFF_Hora, -2, 42, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 9, 32767).addGroup(JPI_InformacionEncabezadoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBEspecialidad, -2, -1, -2).addComponent(this.JCBProfesional, -2, -1, -2)).addContainerGap()));
        this.JTPDatos.setForeground(Color.red);
        this.JTPDatos.setFont(new Font("Arial", 1, 14));
        this.JTFCDxP.setFont(new Font("Arial", 1, 12));
        this.JTFCDxP.setBorder(BorderFactory.createTitledBorder((Border) null, "Cie10", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFCDxP.addFocusListener(new FocusAdapter() { // from class: com.genoma.plus.controller.facturacion.JPI_FormularioAnexo3Res2335.4
            public void focusLost(FocusEvent evt) {
                JPI_FormularioAnexo3Res2335.this.JTFCDxPFocusLost(evt);
            }
        });
        this.JTFCDxP.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.facturacion.JPI_FormularioAnexo3Res2335.5
            public void keyPressed(KeyEvent evt) {
                JPI_FormularioAnexo3Res2335.this.JTFCDxPKeyPressed(evt);
            }
        });
        this.JTFNCodigoDxP.setFont(new Font("Arial", 1, 12));
        this.JTFNCodigoDxP.setBorder(BorderFactory.createTitledBorder((Border) null, "Dx Principal", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFNCodigoDxP.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.facturacion.JPI_FormularioAnexo3Res2335.6
            public void mouseClicked(MouseEvent evt) {
                JPI_FormularioAnexo3Res2335.this.JTFNCodigoDxPMouseClicked(evt);
            }
        });
        this.JTFNCodigoDxP.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.facturacion.JPI_FormularioAnexo3Res2335.7
            public void keyPressed(KeyEvent evt) {
                JPI_FormularioAnexo3Res2335.this.JTFNCodigoDxPKeyPressed(evt);
            }
        });
        this.jLabel1.setFont(new Font("Arial", 1, 12));
        this.jLabel1.setForeground(Color.red);
        this.jLabel1.setHorizontalAlignment(0);
        this.jLabel1.setText("DIAGNÓSTICO RELACIONADO");
        this.JTFNDxR1.setFont(new Font("Arial", 1, 12));
        this.JTFNDxR1.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.facturacion.JPI_FormularioAnexo3Res2335.8
            public void mouseClicked(MouseEvent evt) {
                JPI_FormularioAnexo3Res2335.this.JTFNDxR1MouseClicked(evt);
            }
        });
        this.JTFNDxR1.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.facturacion.JPI_FormularioAnexo3Res2335.9
            public void keyPressed(KeyEvent evt) {
                JPI_FormularioAnexo3Res2335.this.JTFNDxR1KeyPressed(evt);
            }
        });
        this.JTFCDxR1.setFont(new Font("Arial", 1, 12));
        this.JTFCDxR1.addFocusListener(new FocusAdapter() { // from class: com.genoma.plus.controller.facturacion.JPI_FormularioAnexo3Res2335.10
            public void focusLost(FocusEvent evt) {
                JPI_FormularioAnexo3Res2335.this.JTFCDxR1FocusLost(evt);
            }
        });
        this.JTFCDxR1.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.facturacion.JPI_FormularioAnexo3Res2335.11
            public void keyPressed(KeyEvent evt) {
                JPI_FormularioAnexo3Res2335.this.JTFCDxR1KeyPressed(evt);
            }

            public void keyReleased(KeyEvent evt) {
                JPI_FormularioAnexo3Res2335.this.JTFCDxR1KeyReleased(evt);
            }
        });
        this.JTFCDxR2.setFont(new Font("Arial", 1, 12));
        this.JTFCDxR2.addFocusListener(new FocusAdapter() { // from class: com.genoma.plus.controller.facturacion.JPI_FormularioAnexo3Res2335.12
            public void focusLost(FocusEvent evt) {
                JPI_FormularioAnexo3Res2335.this.JTFCDxR2FocusLost(evt);
            }
        });
        this.JTFCDxR2.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.facturacion.JPI_FormularioAnexo3Res2335.13
            public void keyPressed(KeyEvent evt) {
                JPI_FormularioAnexo3Res2335.this.JTFCDxR2KeyPressed(evt);
            }
        });
        this.JTFNDxR2.setFont(new Font("Arial", 1, 12));
        this.JTFNDxR2.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.facturacion.JPI_FormularioAnexo3Res2335.14
            public void mouseClicked(MouseEvent evt) {
                JPI_FormularioAnexo3Res2335.this.JTFNDxR2MouseClicked(evt);
            }
        });
        this.JTFNDxR2.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.facturacion.JPI_FormularioAnexo3Res2335.15
            public void keyPressed(KeyEvent evt) {
                JPI_FormularioAnexo3Res2335.this.JTFNDxR2KeyPressed(evt);
            }
        });
        this.JTFCDxR3.setFont(new Font("Arial", 1, 12));
        this.JTFCDxR3.addFocusListener(new FocusAdapter() { // from class: com.genoma.plus.controller.facturacion.JPI_FormularioAnexo3Res2335.16
            public void focusLost(FocusEvent evt) {
                JPI_FormularioAnexo3Res2335.this.JTFCDxR3FocusLost(evt);
            }
        });
        this.JTFCDxR3.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.facturacion.JPI_FormularioAnexo3Res2335.17
            public void keyPressed(KeyEvent evt) {
                JPI_FormularioAnexo3Res2335.this.JTFCDxR3KeyPressed(evt);
            }
        });
        this.JTFNDxR3.setFont(new Font("Arial", 1, 12));
        this.JTFNDxR3.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.facturacion.JPI_FormularioAnexo3Res2335.18
            public void mouseClicked(MouseEvent evt) {
                JPI_FormularioAnexo3Res2335.this.JTFNDxR3MouseClicked(evt);
            }
        });
        this.JTFNDxR3.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.facturacion.JPI_FormularioAnexo3Res2335.19
            public void keyPressed(KeyEvent evt) {
                JPI_FormularioAnexo3Res2335.this.JTFNDxR3KeyPressed(evt);
            }
        });
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "PRIORIDAD", 2, 0, new Font("Arial", 1, 12), Color.red));
        this.JCH_Prioritaria.setFont(new Font("Arial", 1, 12));
        this.JCH_Prioritaria.setText("Prioritaria");
        this.JCH_Prioritaria.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.facturacion.JPI_FormularioAnexo3Res2335.20
            public void actionPerformed(ActionEvent evt) {
                JPI_FormularioAnexo3Res2335.this.JCH_PrioritariaActionPerformed(evt);
            }
        });
        this.JCH_No_Prioritaria.setFont(new Font("Arial", 1, 12));
        this.JCH_No_Prioritaria.setSelected(true);
        this.JCH_No_Prioritaria.setText("No prioritaria");
        this.JCH_No_Prioritaria.setToolTipText("");
        this.JCH_No_Prioritaria.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.facturacion.JPI_FormularioAnexo3Res2335.21
            public void actionPerformed(ActionEvent evt) {
                JPI_FormularioAnexo3Res2335.this.JCH_No_PrioritariaActionPerformed(evt);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(21, 21, 21).addComponent(this.JCH_Prioritaria, -2, 118, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCH_No_Prioritaria, -2, 127, -2).addContainerGap(428, 32767)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCH_Prioritaria).addComponent(this.JCH_No_Prioritaria)).addGap(0, 6, 32767)));
        this.jPanel2.setBorder(BorderFactory.createTitledBorder((Border) null, "TIPO ATENCION SOLICITADA", 2, 0, new Font("Arial", 1, 12), Color.red));
        this.JCH_S_Urgencia.setFont(new Font("Arial", 1, 12));
        this.JCH_S_Urgencia.setSelected(true);
        this.JCH_S_Urgencia.setText("Servicios y tecnologías en casos posteriores a urgencia ");
        this.JCH_S_Urgencia.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.facturacion.JPI_FormularioAnexo3Res2335.22
            public void actionPerformed(ActionEvent evt) {
                JPI_FormularioAnexo3Res2335.this.JCH_S_UrgenciaActionPerformed(evt);
            }
        });
        this.JCH_S_Prioritaria.setFont(new Font("Arial", 1, 12));
        this.JCH_S_Prioritaria.setText("Servicios y tecnologias en atención prioritaria");
        this.JCH_S_Prioritaria.setToolTipText("");
        this.JCH_S_Prioritaria.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.facturacion.JPI_FormularioAnexo3Res2335.23
            public void actionPerformed(ActionEvent evt) {
                JPI_FormularioAnexo3Res2335.this.JCH_S_PrioritariaActionPerformed(evt);
            }
        });
        this.JCH_S_programable.setFont(new Font("Arial", 1, 12));
        this.JCH_S_programable.setText("Servicios y tecnologías de salud electivos o programables no prioritaria");
        this.JCH_S_programable.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.facturacion.JPI_FormularioAnexo3Res2335.24
            public void actionPerformed(ActionEvent evt) {
                JPI_FormularioAnexo3Res2335.this.JCH_S_programableActionPerformed(evt);
            }
        });
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGap(21, 21, 21).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCH_S_programable, -2, 483, -2).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.JCH_S_Urgencia, -2, 365, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCH_S_Prioritaria, -2, 309, -2))).addContainerGap(-1, 32767)));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCH_S_Urgencia).addComponent(this.JCH_S_Prioritaria)).addGap(5, 5, 5).addComponent(this.JCH_S_programable).addContainerGap()));
        GroupLayout JPI_JustificacionLayout = new GroupLayout(this.JPI_Justificacion);
        this.JPI_Justificacion.setLayout(JPI_JustificacionLayout);
        JPI_JustificacionLayout.setHorizontalGroup(JPI_JustificacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_JustificacionLayout.createSequentialGroup().addGroup(JPI_JustificacionLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPI_JustificacionLayout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, -1, -2)).addGroup(GroupLayout.Alignment.LEADING, JPI_JustificacionLayout.createSequentialGroup().addGap(6, 6, 6).addGroup(JPI_JustificacionLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.jPanel2, -1, -1, 32767).addGroup(GroupLayout.Alignment.LEADING, JPI_JustificacionLayout.createSequentialGroup().addComponent(this.JTFCDxP, -2, 68, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFNCodigoDxP, -2, 609, -2)).addComponent(this.jLabel1, GroupLayout.Alignment.LEADING, -1, -1, 32767).addGroup(JPI_JustificacionLayout.createSequentialGroup().addComponent(this.JTFCDxR3, -2, 65, -2).addGap(5, 5, 5).addComponent(this.JTFNDxR3)).addGroup(GroupLayout.Alignment.LEADING, JPI_JustificacionLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPI_JustificacionLayout.createSequentialGroup().addComponent(this.JTFCDxR2, -2, 65, -2).addGap(5, 5, 5).addComponent(this.JTFNDxR2, -2, 610, -2)).addGroup(JPI_JustificacionLayout.createSequentialGroup().addComponent(this.JTFCDxR1, -2, 65, -2).addGap(5, 5, 5).addComponent(this.JTFNDxR1, -2, 610, -2)))))).addGap(0, 85, 32767)));
        JPI_JustificacionLayout.setVerticalGroup(JPI_JustificacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_JustificacionLayout.createSequentialGroup().addGap(20, 20, 20).addGroup(JPI_JustificacionLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFNCodigoDxP, -2, -1, -2).addComponent(this.JTFCDxP, -2, -1, -2)).addComponent(this.jLabel1).addGap(6, 6, 6).addGroup(JPI_JustificacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFCDxR1, -2, -1, -2).addComponent(this.JTFNDxR1, -2, -1, -2)).addGap(6, 6, 6).addGroup(JPI_JustificacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTFCDxR2).addComponent(this.JTFNDxR2)).addGap(6, 6, 6).addGroup(JPI_JustificacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFCDxR3, -2, -1, -2).addComponent(this.JTFNDxR3, -2, -1, -2)).addGap(5, 5, 5).addComponent(this.jPanel1, -2, -1, -2).addGap(7, 7, 7).addComponent(this.jPanel2, -2, -1, -2)));
        this.JTPDatos.addTab("JUSTIFICACIÓN", this.JPI_Justificacion);
        this.JPI_DatosProc.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS SERVICIO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTF_Codigo.setFont(new Font("Arial", 1, 12));
        this.JTF_Codigo.setBorder(BorderFactory.createTitledBorder((Border) null, "Código", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTF_Codigo.addFocusListener(new FocusAdapter() { // from class: com.genoma.plus.controller.facturacion.JPI_FormularioAnexo3Res2335.25
            public void focusLost(FocusEvent evt) {
                JPI_FormularioAnexo3Res2335.this.JTF_CodigoFocusLost(evt);
            }
        });
        this.JTF_Codigo.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.facturacion.JPI_FormularioAnexo3Res2335.26
            public void actionPerformed(ActionEvent evt) {
                JPI_FormularioAnexo3Res2335.this.JTF_CodigoActionPerformed(evt);
            }
        });
        this.JTF_Codigo.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.facturacion.JPI_FormularioAnexo3Res2335.27
            public void keyPressed(KeyEvent evt) {
                JPI_FormularioAnexo3Res2335.this.JTF_CodigoKeyPressed(evt);
            }
        });
        this.JTF_NProcedimiento.setFont(new Font("Arial", 1, 12));
        this.JTF_NProcedimiento.setBorder(BorderFactory.createTitledBorder((Border) null, "Procedimiento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTF_NProcedimiento.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.facturacion.JPI_FormularioAnexo3Res2335.28
            public void mouseClicked(MouseEvent evt) {
                JPI_FormularioAnexo3Res2335.this.JTF_NProcedimientoMouseClicked(evt);
            }
        });
        this.JTF_NProcedimiento.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.facturacion.JPI_FormularioAnexo3Res2335.29
            public void actionPerformed(ActionEvent evt) {
                JPI_FormularioAnexo3Res2335.this.JTF_NProcedimientoActionPerformed(evt);
            }
        });
        this.JTF_NProcedimiento.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.facturacion.JPI_FormularioAnexo3Res2335.30
            public void keyPressed(KeyEvent evt) {
                JPI_FormularioAnexo3Res2335.this.JTF_NProcedimientoKeyPressed(evt);
            }
        });
        this.JSP_Cantidad.setFont(new Font("Arial", 1, 12));
        this.JSP_Cantidad.setModel(new SpinnerNumberModel(1, 1, (Comparable) null, 1));
        this.JSP_Cantidad.setBorder(BorderFactory.createTitledBorder((Border) null, "Cant.", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSP_Cantidad.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.facturacion.JPI_FormularioAnexo3Res2335.31
            public void keyPressed(KeyEvent evt) {
                JPI_FormularioAnexo3Res2335.this.JSP_CantidadKeyPressed(evt);
            }
        });
        this.JBT_Adicionar.setFont(new Font("Arial", 1, 12));
        this.JBT_Adicionar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBT_Adicionar.setText("Adicionar");
        this.JBT_Adicionar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.facturacion.JPI_FormularioAnexo3Res2335.32
            public void actionPerformed(ActionEvent evt) {
                JPI_FormularioAnexo3Res2335.this.JBT_AdicionarActionPerformed(evt);
            }
        });
        this.JBT_Adicionar.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.facturacion.JPI_FormularioAnexo3Res2335.33
            public void keyPressed(KeyEvent evt) {
                JPI_FormularioAnexo3Res2335.this.JBT_AdicionarKeyPressed(evt);
            }
        });
        this.JCBGrupoSevicio.setFont(new Font("Arial", 1, 12));
        this.JCBGrupoSevicio.setBorder(BorderFactory.createTitledBorder((Border) null, "Grupo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBGrupoSevicio.setName("grupoServicio");
        this.JCBGrupoSevicio.addItemListener(new ItemListener() { // from class: com.genoma.plus.controller.facturacion.JPI_FormularioAnexo3Res2335.34
            public void itemStateChanged(ItemEvent evt) {
                JPI_FormularioAnexo3Res2335.this.JCBGrupoSevicioItemStateChanged(evt);
            }
        });
        this.JCBFinProcedimiento.setBorder(BorderFactory.createTitledBorder((Border) null, "Finalidad Tecnología en Salud", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBFinProcedimiento.setFont(new Font("Arial", 1, 12));
        this.JCBFinProcedimiento.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.facturacion.JPI_FormularioAnexo3Res2335.35
            public void keyPressed(KeyEvent evt) {
                JPI_FormularioAnexo3Res2335.this.JCBFinProcedimientoKeyPressed(evt);
            }
        });
        this.JCBSevicioRips.setFont(new Font("Arial", 1, 12));
        this.JCBSevicioRips.setBorder(BorderFactory.createTitledBorder((Border) null, "Servicio Rips", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBSevicioRips.setName("servicioRips");
        GroupLayout JPI_DatosProcLayout = new GroupLayout(this.JPI_DatosProc);
        this.JPI_DatosProc.setLayout(JPI_DatosProcLayout);
        JPI_DatosProcLayout.setHorizontalGroup(JPI_DatosProcLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DatosProcLayout.createSequentialGroup().addGap(6, 6, 6).addGroup(JPI_DatosProcLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(JPI_DatosProcLayout.createSequentialGroup().addComponent(this.JTF_Codigo, -2, 102, -2).addGap(6, 6, 6).addComponent(this.JTF_NProcedimiento, -2, 450, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JSP_Cantidad, -2, 60, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBT_Adicionar)).addGroup(JPI_DatosProcLayout.createSequentialGroup().addComponent(this.JCBGrupoSevicio, -2, 274, -2).addGap(57, 57, 57).addComponent(this.JCBFinProcedimiento, -2, 427, -2)).addComponent(this.JCBSevicioRips, -2, 758, -2))));
        JPI_DatosProcLayout.setVerticalGroup(JPI_DatosProcLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DatosProcLayout.createSequentialGroup().addGroup(JPI_DatosProcLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DatosProcLayout.createSequentialGroup().addGap(5, 5, 5).addGroup(JPI_DatosProcLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTF_Codigo, -2, 50, -2).addGroup(JPI_DatosProcLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTF_NProcedimiento, -2, 50, -2).addComponent(this.JSP_Cantidad, -2, 50, -2)))).addComponent(this.JBT_Adicionar, -2, 50, -2)).addGap(6, 6, 6).addGroup(JPI_DatosProcLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBGrupoSevicio, -2, 50, -2).addComponent(this.JCBFinProcedimiento, -2, 50, -2)).addGap(5, 5, 5).addComponent(this.JCBSevicioRips, -2, 50, -2)));
        this.JSPDetalleDoc.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTBDetalle.setFont(new Font("Arial", 1, 12));
        this.JTBDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTBDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTBDetalle.addInputMethodListener(new InputMethodListener() { // from class: com.genoma.plus.controller.facturacion.JPI_FormularioAnexo3Res2335.36
            public void caretPositionChanged(InputMethodEvent evt) {
            }

            public void inputMethodTextChanged(InputMethodEvent evt) {
                JPI_FormularioAnexo3Res2335.this.JTBDetalleInputMethodTextChanged(evt);
            }
        });
        this.JTBDetalle.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.facturacion.JPI_FormularioAnexo3Res2335.37
            public void keyPressed(KeyEvent evt) {
                JPI_FormularioAnexo3Res2335.this.JTBDetalleKeyPressed(evt);
            }
        });
        this.JSPDetalleDoc.setViewportView(this.JTBDetalle);
        GroupLayout JPI_DetalleLayout = new GroupLayout(this.JPI_Detalle);
        this.JPI_Detalle.setLayout(JPI_DetalleLayout);
        JPI_DetalleLayout.setHorizontalGroup(JPI_DetalleLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPI_DetalleLayout.createSequentialGroup().addContainerGap().addGroup(JPI_DetalleLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JSPDetalleDoc).addComponent(this.JPI_DatosProc, -1, -1, 32767)).addContainerGap()));
        JPI_DetalleLayout.setVerticalGroup(JPI_DetalleLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPI_DetalleLayout.createSequentialGroup().addContainerGap().addComponent(this.JPI_DatosProc, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JSPDetalleDoc, -2, 88, -2).addGap(38, 38, 38)));
        this.JTPDatos.addTab("PROCEDIMIENTO", this.JPI_Detalle);
        this.JPI_DatosProc2.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS SERVICIO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTF_CodigoOtroProc.setFont(new Font("Arial", 1, 12));
        this.JTF_CodigoOtroProc.setBorder(BorderFactory.createTitledBorder((Border) null, "Código", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTF_CodigoOtroProc.addFocusListener(new FocusAdapter() { // from class: com.genoma.plus.controller.facturacion.JPI_FormularioAnexo3Res2335.38
            public void focusLost(FocusEvent evt) {
                JPI_FormularioAnexo3Res2335.this.JTF_CodigoOtroProcFocusLost(evt);
            }
        });
        this.JTF_CodigoOtroProc.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.facturacion.JPI_FormularioAnexo3Res2335.39
            public void actionPerformed(ActionEvent evt) {
                JPI_FormularioAnexo3Res2335.this.JTF_CodigoOtroProcActionPerformed(evt);
            }
        });
        this.JTF_CodigoOtroProc.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.facturacion.JPI_FormularioAnexo3Res2335.40
            public void keyPressed(KeyEvent evt) {
                JPI_FormularioAnexo3Res2335.this.JTF_CodigoOtroProcKeyPressed(evt);
            }
        });
        this.JTF_NOtroProcedimiento.setFont(new Font("Arial", 1, 12));
        this.JTF_NOtroProcedimiento.setBorder(BorderFactory.createTitledBorder((Border) null, "Procedimiento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTF_NOtroProcedimiento.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.facturacion.JPI_FormularioAnexo3Res2335.41
            public void mouseClicked(MouseEvent evt) {
                JPI_FormularioAnexo3Res2335.this.JTF_NOtroProcedimientoMouseClicked(evt);
            }
        });
        this.JTF_NOtroProcedimiento.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.facturacion.JPI_FormularioAnexo3Res2335.42
            public void actionPerformed(ActionEvent evt) {
                JPI_FormularioAnexo3Res2335.this.JTF_NOtroProcedimientoActionPerformed(evt);
            }
        });
        this.JTF_NOtroProcedimiento.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.facturacion.JPI_FormularioAnexo3Res2335.43
            public void keyPressed(KeyEvent evt) {
                JPI_FormularioAnexo3Res2335.this.JTF_NOtroProcedimientoKeyPressed(evt);
            }
        });
        this.JSP_CantidadOtroProc.setFont(new Font("Arial", 1, 12));
        this.JSP_CantidadOtroProc.setModel(new SpinnerNumberModel(1, 1, (Comparable) null, 1));
        this.JSP_CantidadOtroProc.setBorder(BorderFactory.createTitledBorder((Border) null, "Cant.", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSP_CantidadOtroProc.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.facturacion.JPI_FormularioAnexo3Res2335.44
            public void keyPressed(KeyEvent evt) {
                JPI_FormularioAnexo3Res2335.this.JSP_CantidadOtroProcKeyPressed(evt);
            }
        });
        this.JBT_Adicionar2.setFont(new Font("Arial", 1, 12));
        this.JBT_Adicionar2.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBT_Adicionar2.setText("Adicionar");
        this.JBT_Adicionar2.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.facturacion.JPI_FormularioAnexo3Res2335.45
            public void actionPerformed(ActionEvent evt) {
                JPI_FormularioAnexo3Res2335.this.JBT_Adicionar2ActionPerformed(evt);
            }
        });
        this.JBT_Adicionar2.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.facturacion.JPI_FormularioAnexo3Res2335.46
            public void keyPressed(KeyEvent evt) {
                JPI_FormularioAnexo3Res2335.this.JBT_Adicionar2KeyPressed(evt);
            }
        });
        GroupLayout JPI_DatosProc2Layout = new GroupLayout(this.JPI_DatosProc2);
        this.JPI_DatosProc2.setLayout(JPI_DatosProc2Layout);
        JPI_DatosProc2Layout.setHorizontalGroup(JPI_DatosProc2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DatosProc2Layout.createSequentialGroup().addContainerGap().addComponent(this.JTF_CodigoOtroProc, -2, 102, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTF_NOtroProcedimiento).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSP_CantidadOtroProc, -2, 60, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBT_Adicionar2, -2, 136, -2).addContainerGap()));
        JPI_DatosProc2Layout.setVerticalGroup(JPI_DatosProc2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DatosProc2Layout.createSequentialGroup().addGap(25, 25, 25).addGroup(JPI_DatosProc2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JBT_Adicionar2, -2, 50, -2).addGroup(JPI_DatosProc2Layout.createSequentialGroup().addGap(3, 3, 3).addGroup(JPI_DatosProc2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JSP_CantidadOtroProc, -2, 50, -2).addComponent(this.JTF_NOtroProcedimiento, -2, 50, -2).addComponent(this.JTF_CodigoOtroProc, -2, 50, -2)))).addContainerGap()));
        this.JSPDetalleDoc2.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTBDetalleOtroProc.setFont(new Font("Arial", 1, 12));
        this.JTBDetalleOtroProc.setSelectionBackground(new Color(255, 255, 255));
        this.JTBDetalleOtroProc.setSelectionForeground(new Color(255, 0, 0));
        this.JTBDetalleOtroProc.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.facturacion.JPI_FormularioAnexo3Res2335.47
            public void keyPressed(KeyEvent evt) {
                JPI_FormularioAnexo3Res2335.this.JTBDetalleOtroProcKeyPressed(evt);
            }
        });
        this.JSPDetalleDoc2.setViewportView(this.JTBDetalleOtroProc);
        GroupLayout JPI_Detalle2Layout = new GroupLayout(this.JPI_Detalle2);
        this.JPI_Detalle2.setLayout(JPI_Detalle2Layout);
        JPI_Detalle2Layout.setHorizontalGroup(JPI_Detalle2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_Detalle2Layout.createSequentialGroup().addContainerGap().addGroup(JPI_Detalle2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPI_DatosProc2, -1, -1, 32767).addComponent(this.JSPDetalleDoc2, -1, 796, 32767)).addContainerGap()));
        JPI_Detalle2Layout.setVerticalGroup(JPI_Detalle2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPI_Detalle2Layout.createSequentialGroup().addContainerGap().addComponent(this.JPI_DatosProc2, -2, -1, -2).addGap(5, 5, 5).addComponent(this.JSPDetalleDoc2, -2, 197, -2).addGap(24, 24, 24)));
        this.JTPDatos.addTab("OTROS PROCEDIMIENTO", this.JPI_Detalle2);
        this.JPI_DatosProc1.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS SERVICIO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTF_CodigoSuministro.setFont(new Font("Arial", 1, 12));
        this.JTF_CodigoSuministro.setBorder(BorderFactory.createTitledBorder((Border) null, "Código", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTF_CodigoSuministro.addFocusListener(new FocusAdapter() { // from class: com.genoma.plus.controller.facturacion.JPI_FormularioAnexo3Res2335.48
            public void focusLost(FocusEvent evt) {
                JPI_FormularioAnexo3Res2335.this.JTF_CodigoSuministroFocusLost(evt);
            }
        });
        this.JTF_NSuministro.setFont(new Font("Arial", 1, 12));
        this.JTF_NSuministro.setBorder(BorderFactory.createTitledBorder((Border) null, "Suministro", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTF_NSuministro.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.facturacion.JPI_FormularioAnexo3Res2335.49
            public void mouseClicked(MouseEvent evt) {
                JPI_FormularioAnexo3Res2335.this.JTF_NSuministroMouseClicked(evt);
            }
        });
        this.JTF_NSuministro.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.facturacion.JPI_FormularioAnexo3Res2335.50
            public void actionPerformed(ActionEvent evt) {
                JPI_FormularioAnexo3Res2335.this.JTF_NSuministroActionPerformed(evt);
            }
        });
        this.JSP_CantidadSuministro.setFont(new Font("Arial", 1, 12));
        this.JSP_CantidadSuministro.setModel(new SpinnerNumberModel(1, 1, (Comparable) null, 1));
        this.JSP_CantidadSuministro.setBorder(BorderFactory.createTitledBorder((Border) null, "Cant.", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSP_CantidadSuministro.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.facturacion.JPI_FormularioAnexo3Res2335.51
            public void keyPressed(KeyEvent evt) {
                JPI_FormularioAnexo3Res2335.this.JSP_CantidadSuministroKeyPressed(evt);
            }
        });
        this.JBT_Adicionar1.setFont(new Font("Arial", 1, 12));
        this.JBT_Adicionar1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBT_Adicionar1.setText("Adicionar");
        this.JBT_Adicionar1.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.facturacion.JPI_FormularioAnexo3Res2335.52
            public void actionPerformed(ActionEvent evt) {
                JPI_FormularioAnexo3Res2335.this.JBT_Adicionar1ActionPerformed(evt);
            }
        });
        this.JBT_Adicionar1.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.facturacion.JPI_FormularioAnexo3Res2335.53
            public void keyPressed(KeyEvent evt) {
                JPI_FormularioAnexo3Res2335.this.JBT_Adicionar1KeyPressed(evt);
            }
        });
        GroupLayout JPI_DatosProc1Layout = new GroupLayout(this.JPI_DatosProc1);
        this.JPI_DatosProc1.setLayout(JPI_DatosProc1Layout);
        JPI_DatosProc1Layout.setHorizontalGroup(JPI_DatosProc1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DatosProc1Layout.createSequentialGroup().addContainerGap().addComponent(this.JTF_CodigoSuministro, -2, 102, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTF_NSuministro, -2, 398, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSP_CantidadSuministro, -2, 60, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBT_Adicionar1, -1, -1, 32767).addContainerGap()));
        JPI_DatosProc1Layout.setVerticalGroup(JPI_DatosProc1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DatosProc1Layout.createSequentialGroup().addGroup(JPI_DatosProc1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DatosProc1Layout.createSequentialGroup().addGap(32, 32, 32).addGroup(JPI_DatosProc1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTF_CodigoSuministro, -2, 50, -2).addComponent(this.JTF_NSuministro, -2, 50, -2).addComponent(this.JSP_CantidadSuministro, -1, -1, -2))).addGroup(JPI_DatosProc1Layout.createSequentialGroup().addGap(33, 33, 33).addComponent(this.JBT_Adicionar1, -2, 43, -2))).addContainerGap(42, 32767)));
        this.JSPDetalleDoc1.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTBDetalleSuministro.setFont(new Font("Arial", 1, 12));
        this.JTBDetalleSuministro.setSelectionBackground(new Color(255, 255, 255));
        this.JTBDetalleSuministro.setSelectionForeground(new Color(255, 0, 0));
        this.JTBDetalleSuministro.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.facturacion.JPI_FormularioAnexo3Res2335.54
            public void keyPressed(KeyEvent evt) {
                JPI_FormularioAnexo3Res2335.this.JTBDetalleSuministroKeyPressed(evt);
            }
        });
        this.JSPDetalleDoc1.setViewportView(this.JTBDetalleSuministro);
        GroupLayout JPI_Detalle1Layout = new GroupLayout(this.JPI_Detalle1);
        this.JPI_Detalle1.setLayout(JPI_Detalle1Layout);
        JPI_Detalle1Layout.setHorizontalGroup(JPI_Detalle1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_Detalle1Layout.createSequentialGroup().addContainerGap().addGroup(JPI_Detalle1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JPI_DatosProc1, -1, -1, 32767).addComponent(this.JSPDetalleDoc1)).addContainerGap(83, 32767)));
        JPI_Detalle1Layout.setVerticalGroup(JPI_Detalle1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPI_Detalle1Layout.createSequentialGroup().addContainerGap().addComponent(this.JPI_DatosProc1, -2, -1, -2).addGap(5, 5, 5).addComponent(this.JSPDetalleDoc1, -2, 113, -2).addContainerGap()));
        this.JTPDatos.addTab("MATERIALES", this.JPI_Detalle1);
        GroupLayout JPI_DatosAnexoLayout = new GroupLayout(this.JPI_DatosAnexo);
        this.JPI_DatosAnexo.setLayout(JPI_DatosAnexoLayout);
        JPI_DatosAnexoLayout.setHorizontalGroup(JPI_DatosAnexoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DatosAnexoLayout.createSequentialGroup().addContainerGap().addGroup(JPI_DatosAnexoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPI_InformacionEncabezado, -1, -1, 32767).addComponent(this.JTPDatos)).addContainerGap()));
        JPI_DatosAnexoLayout.setVerticalGroup(JPI_DatosAnexoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DatosAnexoLayout.createSequentialGroup().addContainerGap().addComponent(this.JPI_InformacionEncabezado, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTPDatos, -2, 355, -2).addContainerGap(-1, 32767)));
        this.JTPFomurlario.addTab("DATOS ANEXO", this.JPI_DatosAnexo);
        this.JSPHistorico.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.facturacion.JPI_FormularioAnexo3Res2335.55
            public void keyPressed(KeyEvent evt) {
                JPI_FormularioAnexo3Res2335.this.JSPHistoricoKeyPressed(evt);
            }
        });
        this.JTHistorico.setFont(new Font("Arial", 1, 12));
        this.JTHistorico.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTHistorico.setSelectionBackground(Color.white);
        this.JTHistorico.setSelectionForeground(Color.red);
        this.JTHistorico.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.facturacion.JPI_FormularioAnexo3Res2335.56
            public void mouseClicked(MouseEvent evt) {
                JPI_FormularioAnexo3Res2335.this.JTHistoricoMouseClicked(evt);
            }
        });
        this.JSPHistorico.setViewportView(this.JTHistorico);
        GroupLayout JPI_HistoricoLayout = new GroupLayout(this.JPI_Historico);
        this.JPI_Historico.setLayout(JPI_HistoricoLayout);
        JPI_HistoricoLayout.setHorizontalGroup(JPI_HistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPHistorico, -2, 790, -2));
        JPI_HistoricoLayout.setVerticalGroup(JPI_HistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_HistoricoLayout.createSequentialGroup().addComponent(this.JSPHistorico, -2, 477, -2).addGap(0, 10, 32767)));
        this.JTPFomurlario.addTab("HISTÓRICO", this.JPI_Historico);
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(6, 6, 6).addComponent(this.JTPFomurlario, -2, 820, -2)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(6, 6, 6).addComponent(this.JTPFomurlario, -2, 518, -2)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBEspecialidadItemStateChanged(ItemEvent evt) {
        if (this.estadoLlenadoCombos.booleanValue() && this.JCBEspecialidad.getSelectedIndex() != -1) {
            llenarComboProfesional();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTHistoricoMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            iniciarCheck();
            if (this.JTHistorico.getSelectedRow() != -1) {
                crearModeloDatosDetalle();
                crearModeloSumunistro();
                crearModeloOtroProcedimeinto();
                try {
                    String idAnexo = this.modeloHistorico.getValueAt(this.JTHistorico.getSelectedRow(), 1).toString();
                    RecursosMicroserviciosDomain microserviciosDomain = this.metodos.getParametrosEncriptados("24", "finByAnexoIdAndIngreso");
                    String fullUrl = microserviciosDomain.getUrlRecurso() + "/" + idAnexo + "/" + this.idIngreso + "/3";
                    System.out.println("fullurlSql --- " + fullUrl);
                    Response response = this.metodos.getResteasyClient().target(fullUrl).request().get();
                    int statusCode = response.getStatus();
                    if (statusCode == 200) {
                        try {
                            new CustomPresenter();
                            CustomPresenter presenter = (CustomPresenter) this.metodos.getMapper().readValue((String) response.readEntity(String.class), CustomPresenter.class);
                            Anexo2335Dto anexo2335Dto = (Anexo2335Dto) this.metodos.getMapper().readValue(this.metodos.getMapper().writeValueAsString(presenter.getData()), new TypeReference<Anexo2335Dto>() { // from class: com.genoma.plus.controller.facturacion.JPI_FormularioAnexo3Res2335.57
                            });
                            System.err.println("id" + anexo2335Dto.getId());
                            this.JLB_NRegistro.setText(anexo2335Dto.getId().toString());
                            this.JLB_NConsecutivo.setText(this.metodos.numeroCerosIzquierda(anexo2335Dto.getId(), 12));
                            this.jDateChooser.setDate(Date.valueOf(anexo2335Dto.getFechaRegistro()));
                            this.JTFF_Hora.setText(anexo2335Dto.getHoraRegistro().toString());
                            this.JTFCDxP.setText(anexo2335Dto.getAnexo3().getDiagnostico());
                            if (!this.JTFCDxP.getText().isEmpty()) {
                                buscarPatologias(this.JTFCDxP, this.JTFNCodigoDxP);
                            }
                            this.JTFCDxR1.setText(anexo2335Dto.getAnexo3().getDiagnosticoRelacionado1());
                            if (!this.JTFCDxR1.getText().isEmpty()) {
                                buscarPatologias(this.JTFCDxR1, this.JTFNDxR1);
                            }
                            this.JTFCDxR2.setText(anexo2335Dto.getAnexo3().getDiagnosticoRelacionado2());
                            if (!this.JTFCDxR2.getText().isEmpty()) {
                                buscarPatologias(this.JTFCDxR2, this.JTFNDxR2);
                            }
                            this.JTFCDxR3.setText(anexo2335Dto.getAnexo3().getDiagnosticoRelacionado3());
                            if (!this.JTFCDxR3.getText().isEmpty()) {
                                buscarPatologias(this.JTFCDxR3, this.JTFNDxR3);
                            }
                            switch (anexo2335Dto.getAnexo3().getPrioridadAtencion()) {
                                case "01":
                                    this.JCH_Prioritaria.setSelected(true);
                                    this.prioridad = "01";
                                    break;
                                case "02":
                                    this.JCH_No_Prioritaria.setSelected(true);
                                    this.prioridad = "02";
                                    break;
                            }
                            switch (anexo2335Dto.getAnexo3().getTipoAtencionSolicitada()) {
                                case "01":
                                    this.JCH_S_Urgencia.setSelected(true);
                                    this.TipoAtencion = "01";
                                    break;
                                case "02":
                                    this.JCH_S_Prioritaria.setSelected(true);
                                    this.TipoAtencion = "02";
                                    break;
                                case "03":
                                    this.JCH_S_programable.setSelected(true);
                                    this.TipoAtencion = "03";
                                    break;
                            }
                            this.index = 0;
                            this.metodos.mEstablecerTextEditor(this.JTBDetalle, 1);
                            this.metodos.mEstablecerTextEditor(this.JTBDetalleOtroProc, 1);
                            this.metodos.mEstablecerTextEditor(this.JTBDetalleSuministro, 1);
                            anexo2335Dto.getAnexo3().getCupsDetalle().forEach(cupsDetalle -> {
                                this.modeloDetalleProcedimiento.addRow(this.dato);
                                this.modeloDetalleProcedimiento.setValueAt(anexo2335Dto.getAnexo3().getCupsDetalle().get(this.index).getCodigoCups(), this.index, 0);
                                this.modeloDetalleProcedimiento.setValueAt(anexo2335Dto.getAnexo3().getCupsDetalle().get(this.index).getNombreCups(), this.index, 1);
                                this.modeloDetalleProcedimiento.setValueAt(anexo2335Dto.getAnexo3().getCupsDetalle().get(this.index).getCantidadRequerida(), this.index, 2);
                                this.modeloDetalleProcedimiento.setValueAt(anexo2335Dto.getAnexo3().getCupsDetalle().get(this.index).getFinalidadTecnologia(), this.index, 3);
                                this.modeloDetalleProcedimiento.setValueAt(anexo2335Dto.getAnexo3().getCupsDetalle().get(this.index).getCodigoServicio(), this.index, 4);
                                this.index++;
                            });
                            this.index = 0;
                            anexo2335Dto.getAnexo3().getCumDetalle().forEach(cumDetalle -> {
                                System.err.println("index" + anexo2335Dto.getAnexo3().getCumDetalle().get(this.index).getCodigoImuCum());
                                this.modeloSuministro.addRow(this.dato);
                                this.modeloSuministro.setValueAt(anexo2335Dto.getAnexo3().getCumDetalle().get(this.index).getCodigoImuCum(), this.index, 0);
                                this.modeloSuministro.setValueAt(anexo2335Dto.getAnexo3().getCumDetalle().get(this.index).getNombreImuCum(), this.index, 1);
                                this.modeloSuministro.setValueAt(anexo2335Dto.getAnexo3().getCumDetalle().get(this.index).getCantidadRequeridaImuCum(), this.index, 2);
                                this.index++;
                            });
                            this.index = 0;
                            anexo2335Dto.getAnexo3().getOtroCodigoDetalle().forEach(OtroDetalle -> {
                                System.err.println("index" + anexo2335Dto.getAnexo3().getOtroCodigoDetalle().get(this.index).getCodigoOtrosServicios());
                                this.modeloOtroProcedimiento.addRow(this.dato);
                                this.modeloOtroProcedimiento.setValueAt(anexo2335Dto.getAnexo3().getOtroCodigoDetalle().get(this.index).getCodigoOtrosServicios(), this.index, 0);
                                this.modeloOtroProcedimiento.setValueAt(anexo2335Dto.getAnexo3().getOtroCodigoDetalle().get(this.index).getNombreOtrosServicios(), this.index, 1);
                                this.modeloOtroProcedimiento.setValueAt(anexo2335Dto.getAnexo3().getOtroCodigoDetalle().get(this.index).getCantidadOtrosServicios(), this.index, 2);
                                this.index++;
                            });
                            this.JTPFomurlario.setSelectedIndex(0);
                        } catch (Exception e) {
                            Logger.getLogger(JPI_FormularioAnexo3Res2335.class.getName()).log(Level.SEVERE, (String) null, (Throwable) e);
                        }
                    }
                    response.close();
                    this.metodos.getResteasyClient().close();
                } catch (Exception e2) {
                    Logger.getLogger(JPI_FormularioAnexo3Res2335.class.getName()).log(Level.SEVERE, (String) null, (Throwable) e2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JSPHistoricoKeyPressed(KeyEvent evt) {
        System.out.println("esto actualiza con enter- scroll");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFF_HoraFocusGained(FocusEvent evt) {
        this.JTFF_Hora.selectAll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFF_HoraActionPerformed(ActionEvent evt) {
        this.jDateChooser.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBDetalleOtroProcKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 127) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de eliminar este registro?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                this.modeloOtroProcedimiento.removeRow(this.JTBDetalleOtroProc.getSelectedRow());
                this.JTF_CodigoOtroProc.requestFocus();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_Adicionar2KeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_Adicionar2ActionPerformed(ActionEvent evt) {
        if (this.JLB_NRegistro.getText().isEmpty()) {
            adicionarOtroProcedimiento();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JSP_CantidadOtroProcKeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTF_NOtroProcedimientoKeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTF_NOtroProcedimientoActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTF_NOtroProcedimientoMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            BuscarProced frmBuscarProced = new BuscarProced((Frame) null, true, (JPanel) this, "xjpi_formulaanexo3Res2335", 2);
            frmBuscarProced.setVisible(true);
            buscarCodigoDelProcedimiento();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTF_CodigoOtroProcKeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTF_CodigoOtroProcActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTF_CodigoOtroProcFocusLost(FocusEvent evt) {
        if (!this.JTF_CodigoOtroProc.getText().isEmpty()) {
            buscarCodigoOtroProcedimeinto();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBDetalleKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 127) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de eliminar este registro?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                this.modeloDetalleProcedimiento.removeRow(this.JTBDetalle.getSelectedRow());
                this.JTF_Codigo.requestFocus();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBDetalleInputMethodTextChanged(InputMethodEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBFinProcedimientoKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JCBFinProcedimiento.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBGrupoSevicioItemStateChanged(ItemEvent evt) {
        if (this.xlleno) {
            int selectedIndex = this.JCBGrupoSevicio.getSelectedIndex();
            if (selectedIndex != -1) {
                llenarComboServicio();
            } else {
                this.JCBSevicioRips.removeAllItems();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_AdicionarKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            adicionar();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_AdicionarActionPerformed(ActionEvent evt) {
        if (this.JLB_NRegistro.getText().isEmpty()) {
            adicionar();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JSP_CantidadKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JBT_Adicionar.requestFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTF_NProcedimientoKeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTF_NProcedimientoActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTF_NProcedimientoMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            BuscarProced frmBuscarProced = new BuscarProced((Frame) null, true, (JPanel) this, "xjpi_formulaanexo3Res2335", 1);
            frmBuscarProced.setVisible(true);
            buscarCodigoDelProcedimiento();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTF_CodigoKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10 && !this.JTF_Codigo.getText().isEmpty()) {
            this.JSP_Cantidad.requestFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTF_CodigoActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTF_CodigoFocusLost(FocusEvent evt) {
        if (!this.JTF_Codigo.getText().isEmpty()) {
            buscarCodigoDelProcedimiento();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_S_programableActionPerformed(ActionEvent evt) {
        this.TipoAtencion = "03";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_S_PrioritariaActionPerformed(ActionEvent evt) {
        this.TipoAtencion = "02";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_S_UrgenciaActionPerformed(ActionEvent evt) {
        this.TipoAtencion = "01";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_No_PrioritariaActionPerformed(ActionEvent evt) {
        this.prioridad = "02";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_PrioritariaActionPerformed(ActionEvent evt) {
        this.prioridad = "01";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNDxR3KeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNDxR3MouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCDxR3KeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCDxR3FocusLost(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNDxR2KeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JTFNDxR2.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNDxR2MouseClicked(MouseEvent evt) {
        this.historiaCE.buscarPatologiaNombre(this.JTFCDxR2, this.JTFNDxR2, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCDxR2KeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JTFCDxR2.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCDxR2FocusLost(FocusEvent evt) {
        buscarPatologias(this.JTFCDxR2, this.JTFNDxR2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCDxR1KeyReleased(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCDxR1KeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JTFCDxR1.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCDxR1FocusLost(FocusEvent evt) {
        buscarPatologias(this.JTFCDxR1, this.JTFNDxR1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNDxR1KeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JTFNDxR1.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNDxR1MouseClicked(MouseEvent evt) {
        this.historiaCE.buscarPatologiaNombre(this.JTFCDxR1, this.JTFNDxR1, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNCodigoDxPKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JTFNCodigoDxP.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNCodigoDxPMouseClicked(MouseEvent evt) {
        this.historiaCE.buscarPatologiaNombre(this.JTFCDxP, this.JTFNCodigoDxP, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCDxPKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JTFCDxP.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCDxPFocusLost(FocusEvent evt) {
        buscarPatologias(this.JTFCDxP, this.JTFNCodigoDxP);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTF_CodigoSuministroFocusLost(FocusEvent evt) {
        if (!this.JTF_CodigoSuministro.getText().isEmpty()) {
            buscarCodigoSuministro();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTF_NSuministroMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            BuscarSum frmBuscarSum = new BuscarSum(null, true, this, "xjpi_formulaanexo3Res2335");
            frmBuscarSum.setVisible(true);
            buscarCodigoSuministro();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JSP_CantidadSuministroKeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_Adicionar1ActionPerformed(ActionEvent evt) {
        if (this.JLB_NRegistro.getText().isEmpty()) {
            adicionarSuministro();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_Adicionar1KeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBDetalleSuministroKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 127) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de eliminar este registro?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                this.modeloSuministro.removeRow(this.JTBDetalleSuministro.getSelectedRow());
                this.JTF_CodigoSuministro.requestFocus();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTF_NSuministroActionPerformed(ActionEvent evt) {
    }

    private void springStart() {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"});
        this.informacionProfesionalDAO = (InformacionProfesionalDAOImpl) classPathXmlApplicationContext.getBean("informacionProfesionalDAOImpl");
        this.facturacionDAO = (FacturacionDAOImp) classPathXmlApplicationContext.getBean("facturacionDAOImp");
        this.ordenAnexo3DAO = (OrdenAnexo3DAOImpl) classPathXmlApplicationContext.getBean("ordenAnexo3DAO");
        this.patologiaCie10DAO = (PatologiaCie10DAOImpl) classPathXmlApplicationContext.getBean("patologiaCie10DAOImpl");
    }

    public void nuevo() {
        iniciarCheck();
        this.jDateChooser.setDate(this.metodos.getFechaActual());
        this.JTFF_Hora.setValue(this.metodos.formatoH24.format(this.metodos.getFechaActual()));
        this.JLB_NRegistro.setText("");
        this.JLB_NConsecutivo.setText("");
        this.estadoLlenadoCombos = false;
        this.JCBProfesional.removeAllItems();
        llenarComboEspecialidad();
        llenarComboGrupoServicio();
        this.estadoLlenadoCombos = true;
        crearModeloDatosDetalle();
        crearModeloSumunistro();
        crearModeloOtroProcedimeinto();
        llenaTablaHistorico();
        this.cargarCombosVarios.cargarComboTableFinalidadPorProcedimientoAnexo1(this.JCBFinProcedimiento, null);
    }

    private void llenarComboServicio() {
        this.JCBSevicioRips.removeAllItems();
        this.ListripsEntitys = new ArrayList();
        int selectedIndex = this.JCBGrupoSevicio.getSelectedIndex();
        if (selectedIndex != -1 && !this.listGrupoEntitys.isEmpty()) {
            LlenarCombosGenericos<GServicioRipsEntity> combosGenericos = new LlenarCombosGenericos<>();
            this.ListripsEntitys = combosGenericos.getListComboLlenoParametro(this.JCBSevicioRips.getName(), this.listGrupoEntitys.get(selectedIndex));
            this.ListripsEntitys.forEach(e -> {
                this.JCBSevicioRips.addItem(e.getNombre());
            });
            this.JCBSevicioRips.addPopupMenuListener(new CustomPopupMenuListener(true, false));
        }
    }

    private void iniciarCheck() {
        this.prioridad = "00";
        this.TipoAtencion = "00";
        this.JCH_Prioritaria.setSelected(false);
        this.JCH_No_Prioritaria.setSelected(false);
        this.JCH_S_Urgencia.setSelected(false);
        this.JCH_S_Prioritaria.setSelected(false);
        this.JCH_S_programable.setSelected(false);
    }

    public void grabar() {
        if (this.JLB_NRegistro.getText().isEmpty()) {
            if (this.JCBEspecialidad.getSelectedIndex() != -1) {
                if (this.JCBProfesional.getSelectedIndex() != -1) {
                    if (!this.JTFCDxP.getText().isEmpty()) {
                        if (this.JTBDetalle.getRowCount() != 0) {
                            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                            if (n == 0) {
                                GrabadoAnexo();
                                llenaTablaHistorico();
                                return;
                            }
                            return;
                        }
                        JOptionPane.showInternalMessageDialog(this, "debe haber al menos un procedimiento adicionado", "VALIDAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        return;
                    }
                    JOptionPane.showInternalMessageDialog(this, "debe digitar al menos un Diagnostico Principal", "VALIDAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "debe seleccionar un profesional", "VALIDAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "debe seleccionar una especialidad", "VALIDAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Este registro ya se encuentra grabado", "VALIDAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    public void imprimir() {
        if (!this.JLB_NRegistro.getText().isEmpty()) {
            ImpresionAnexo2335 ImpresionAnexo2335 = new ImpresionAnexo2335(Long.valueOf(this.idIngreso), 3, Long.valueOf(this.JLB_NRegistro.getText()));
            ImpresionAnexo2335.build();
            this.metodos.mostrarPdf(this.metodos.getRutaRep() + "Anexo1.pdf");
        }
    }

    private void GrabadoAnexo() {
        new ObjectMapper();
        List<Object[]> listaInformacionAnexo3 = this.ordenAnexo3DAO.informacionIngresoAnexo3Res2335(this.idIngreso);
        if (!listaInformacionAnexo3.isEmpty()) {
            Anexo2335Dto anexo2335Dto = new Anexo2335Dto();
            new AnexoDatoUsuarioDto();
            new AnexoInformacionIpsDto();
            Anexo3Dto anexo3Dto = new Anexo3Dto();
            List<ListaCupsDetalleDto> listaCupsDetalle = new ArrayList<>();
            List<ListaCumDetalleDto> listaCumDetalle = new ArrayList<>();
            List<ListaCodigoOtrosDto> listaCodigoOtrosDto = new ArrayList<>();
            for (int fila = 0; fila < listaInformacionAnexo3.size(); fila++) {
                try {
                    if (!this.JLB_NRegistro.getText().equals("")) {
                        anexo2335Dto.setId(Long.valueOf(Long.parseLong(this.JLB_NRegistro.getText())));
                    }
                    anexo2335Dto.setIngresoId(Long.valueOf(Long.parseLong(this.idIngreso)));
                    anexo2335Dto.setIdOrden(Long.valueOf(Long.parseLong("0")));
                    anexo2335Dto.setFechaRegistro(this.metodos.formatoAMD1.format(this.jDateChooser.getDate()));
                    anexo2335Dto.setHoraRegistro(this.JTFF_Hora.getText());
                    anexo2335Dto.setTipoAnexo(3);
                    anexo2335Dto.setEstado(true);
                    anexo2335Dto.setProfesionalId(this.idProfesional[this.JCBProfesional.getSelectedIndex()]);
                    anexo2335Dto.setEspecialidadId(this.idEspecialidad[this.JCBEspecialidad.getSelectedIndex()]);
                    anexo2335Dto.setIdUsuarioS(Principal.usuarioSistemaDTO.getIdPersonaCargo());
                    AnexoInformacionIpsDto anexoInformacionIpsDto = (AnexoInformacionIpsDto) this.metodos.getMapper().readValue(listaInformacionAnexo3.get(fila)[0].toString(), AnexoInformacionIpsDto.class);
                    anexoInformacionIpsDto.setCodigoEntidadPagadora(getCodigoRips());
                    AnexoDatoUsuarioDto anexoDatoUsuarioDto = (AnexoDatoUsuarioDto) this.metodos.getMapper().readValue(listaInformacionAnexo3.get(fila)[1].toString(), AnexoDatoUsuarioDto.class);
                    anexoInformacionIpsDto.setUsuarioGenera(Principal.usuarioSistemaDTO.getNombreUsuario());
                    anexoInformacionIpsDto.setDocumentoUsuarioGenera(Principal.usuarioSistemaDTO.getTipoDocumento().concat("-").concat(Principal.usuarioSistemaDTO.getNumeroDocumento()));
                    anexoInformacionIpsDto.setCargoUsuarioGenera(Principal.usuarioSistemaDTO.getNombreCargoUsuario());
                    anexo2335Dto.setAnexoInformacionIps(anexoInformacionIpsDto);
                    anexo2335Dto.setAnexoDatoUsuario(anexoDatoUsuarioDto);
                    anexo3Dto.setCausaAtencion(listaInformacionAnexo3.get(fila)[2].toString());
                    anexo3Dto.setModalidadAtencion(listaInformacionAnexo3.get(fila)[3].toString());
                    anexo3Dto.setDiagnostico(this.JTFCDxP.getText());
                    anexo3Dto.setDiagnosticoRelacionado1(this.JTFCDxR1.getText());
                    anexo3Dto.setDiagnosticoRelacionado2(this.JTFCDxR2.getText());
                    anexo3Dto.setDiagnosticoRelacionado3(this.JTFCDxR3.getText());
                    anexo3Dto.setGrupoServicios(this.TipoAtencion);
                    anexo3Dto.setPrioridadAtencion(this.prioridad);
                    anexo3Dto.setTipoAtencionSolicitada(this.TipoAtencion);
                    for (int registro = 0; registro < this.JTBDetalle.getRowCount(); registro++) {
                        ListaCupsDetalleDto CupsDetalleDto = ListaCupsDetalleDto.builder().codigoCups(this.modeloDetalleProcedimiento.getValueAt(registro, 0).toString()).cantidadRequerida(this.modeloDetalleProcedimiento.getValueAt(registro, 2).toString()).finalidadTecnologia(this.modeloDetalleProcedimiento.getValueAt(registro, 3).toString()).codigoServicio(this.modeloDetalleProcedimiento.getValueAt(registro, 4).toString()).grupoServicios(this.modeloDetalleProcedimiento.getValueAt(registro, 5).toString()).nombreCups(this.modeloDetalleProcedimiento.getValueAt(registro, 1).toString()).build();
                        listaCupsDetalle.add(CupsDetalleDto);
                    }
                    anexo3Dto.setCupsDetalle(listaCupsDetalle);
                    for (int registro2 = 0; registro2 < this.JTBDetalleSuministro.getRowCount(); registro2++) {
                        ListaCumDetalleDto CumDetalleDto = ListaCumDetalleDto.builder().codigoImuCum(this.modeloSuministro.getValueAt(registro2, 0).toString()).nombreImuCum(this.modeloSuministro.getValueAt(registro2, 1).toString()).cantidadRequeridaImuCum(this.modeloSuministro.getValueAt(registro2, 2).toString()).build();
                        listaCumDetalle.add(CumDetalleDto);
                    }
                    anexo3Dto.setCumDetalle(listaCumDetalle);
                    for (int registro3 = 0; registro3 < this.JTBDetalleOtroProc.getRowCount(); registro3++) {
                        ListaCodigoOtrosDto OtrosDetalleDto = ListaCodigoOtrosDto.builder().codigoOtrosServicios(this.modeloOtroProcedimiento.getValueAt(registro3, 0).toString()).nombreOtrosServicios(this.modeloOtroProcedimiento.getValueAt(registro3, 1).toString()).cantidadOtrosServicios(this.modeloOtroProcedimiento.getValueAt(registro3, 2).toString()).build();
                        listaCodigoOtrosDto.add(OtrosDetalleDto);
                    }
                    anexo3Dto.setOtroCodigoDetalle(listaCodigoOtrosDto);
                    anexo2335Dto.setAnexo3(anexo3Dto);
                    try {
                        RecursosMicroserviciosDomain microserviciosDomain = this.metodos.getParametrosEncriptados("24", "RegistroAnexo2335");
                        Response responsePos = this.metodos.getResteasyClient().target(microserviciosDomain.getUrlRecurso()).request().post(Entity.json(this.metodos.getMapper().writeValueAsString(anexo2335Dto)));
                        CustomPresenter presenter = (CustomPresenter) this.metodos.getMapper().readValue((String) responsePos.readEntity(String.class), CustomPresenter.class);
                        Anexo2335Dto dto = (Anexo2335Dto) this.metodos.getMapper().readValue(this.metodos.getMapper().writeValueAsString(presenter.getData()), Anexo2335Dto.class);
                        this.JLB_NRegistro.setText(dto.getId().toString());
                        this.JLB_NConsecutivo.setText(this.metodos.numeroCerosIzquierda(dto.getId(), 12));
                        responsePos.close();
                        this.metodos.getResteasyClient().close();
                    } catch (JsonProcessingException e) {
                        Logger.getLogger(JPI_FormularioAnexo3Res2335.class.getName()).log(Level.SEVERE, (String) null, e);
                    }
                    System.out.println(this.metodos.getMapper().writeValueAsString(anexo2335Dto));
                } catch (JsonProcessingException e2) {
                    Logger.getLogger(JPI_FormularioAnexo3Res2335.class.getName()).log(Level.SEVERE, (String) null, e2);
                }
            }
        }
    }

    private void llenarComboEspecialidad() {
        this.JCBEspecialidad.removeAllItems();
        List<Object[]> listadoEspecialidad = this.informacionProfesionalDAO.listadoEspecialidadConProfesional();
        if (!listadoEspecialidad.isEmpty()) {
            this.idEspecialidad = new String[listadoEspecialidad.size()];
            for (int i = 0; i < listadoEspecialidad.size(); i++) {
                this.idEspecialidad[i] = listadoEspecialidad.get(i)[0].toString();
                this.JCBEspecialidad.addItem(listadoEspecialidad.get(i)[1].toString());
            }
            this.JCBEspecialidad.setSelectedIndex(-1);
        }
    }

    private void llenarComboGrupoServicio() {
        this.JCBGrupoSevicio.removeAllItems();
        LlenarCombosGenericos<GServicioGrupoEntity> combosGenericos = new LlenarCombosGenericos<>();
        this.listGrupoEntitys = combosGenericos.getListComboLleno(this.JCBGrupoSevicio.getName());
        this.listGrupoEntitys.forEach(e -> {
            this.JCBGrupoSevicio.addItem(e.getNombre());
        });
        if (!this.listGrupoEntitys.isEmpty()) {
            this.JCBGrupoSevicio.setSelectedIndex(-1);
            this.JCBGrupoSevicio.addPopupMenuListener(new CustomPopupMenuListener(true, false));
        }
        this.xlleno = true;
    }

    private void llenarComboProfesional() {
        this.JCBProfesional.removeAllItems();
        List<Object[]> listadoProfesional = this.informacionProfesionalDAO.listadoProfesionalFiltradoPorEspecialidad(this.idEspecialidad[this.JCBEspecialidad.getSelectedIndex()]);
        if (!listadoProfesional.isEmpty()) {
            this.idProfesional = new String[listadoProfesional.size()];
            for (int i = 0; i < listadoProfesional.size(); i++) {
                this.idProfesional[i] = listadoProfesional.get(i)[0].toString();
                this.JCBProfesional.addItem(listadoProfesional.get(i)[1].toString());
            }
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearModeloDatosHistorico() {
        this.modeloHistorico = new DefaultTableModel(new Object[0], new String[]{"IdIngreso", "idEnexo", "fechaRegistro", "tipoAnexo", "NProfesional", "Especialidad"}) { // from class: com.genoma.plus.controller.facturacion.JPI_FormularioAnexo3Res2335.58
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTHistorico;
        JTable jTable2 = this.JTHistorico;
        jTable.setAutoResizeMode(0);
        this.JTHistorico.doLayout();
        this.JTHistorico.setModel(this.modeloHistorico);
        this.JTHistorico.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTHistorico.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTHistorico.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTHistorico.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTHistorico.getColumnModel().getColumn(4).setPreferredWidth(300);
        this.JTHistorico.getColumnModel().getColumn(5).setPreferredWidth(300);
    }

    private void llenaTablaHistorico() {
        crearModeloDatosHistorico();
        List<Object[]> listaHistoricoAnexo = this.ordenAnexo3DAO.historicoAnexo3Res2335(this.idIngreso, "3");
        if (!listaHistoricoAnexo.isEmpty()) {
            for (int fila = 0; fila < listaHistoricoAnexo.size(); fila++) {
                this.modeloHistorico.addRow(this.dato);
                this.modeloHistorico.setValueAt(listaHistoricoAnexo.get(fila)[0], fila, 0);
                this.modeloHistorico.setValueAt(listaHistoricoAnexo.get(fila)[1], fila, 1);
                this.modeloHistorico.setValueAt(listaHistoricoAnexo.get(fila)[2], fila, 2);
                this.modeloHistorico.setValueAt(listaHistoricoAnexo.get(fila)[3], fila, 3);
                this.modeloHistorico.setValueAt(listaHistoricoAnexo.get(fila)[4], fila, 4);
                this.modeloHistorico.setValueAt(listaHistoricoAnexo.get(fila)[5], fila, 5);
            }
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearModeloDatosDetalle() {
        this.modeloDetalleProcedimiento = new DefaultTableModel(new Object[0], new String[]{"Cups", "Procedimiento", "cantidad", "Finalidad", "servicio", "grupo"}) { // from class: com.genoma.plus.controller.facturacion.JPI_FormularioAnexo3Res2335.59
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, true, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTBDetalle.setAutoResizeMode(0);
        this.JTBDetalle.doLayout();
        this.JTBDetalle.setModel(this.modeloDetalleProcedimiento);
        this.JTBDetalle.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTBDetalle.getColumnModel().getColumn(1).setPreferredWidth(400);
        this.JTBDetalle.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTBDetalle.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTBDetalle.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTBDetalle.getColumnModel().getColumn(5).setPreferredWidth(100);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearModeloSumunistro() {
        this.modeloSuministro = new DefaultTableModel(new Object[0], new String[]{"Codigo", "Nombre", "cantidad"}) { // from class: com.genoma.plus.controller.facturacion.JPI_FormularioAnexo3Res2335.60
            Class[] types = {String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTBDetalleSuministro.setAutoResizeMode(0);
        this.JTBDetalleSuministro.doLayout();
        this.JTBDetalleSuministro.setModel(this.modeloSuministro);
        this.JTBDetalleSuministro.getColumnModel().getColumn(0).setPreferredWidth(200);
        this.JTBDetalleSuministro.getColumnModel().getColumn(1).setPreferredWidth(500);
        this.JTBDetalleSuministro.getColumnModel().getColumn(2).setPreferredWidth(100);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearModeloOtroProcedimeinto() {
        this.modeloOtroProcedimiento = new DefaultTableModel(new Object[0], new String[]{"Codigo", "Nombre", "cantidad"}) { // from class: com.genoma.plus.controller.facturacion.JPI_FormularioAnexo3Res2335.61
            Class[] types = {String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTBDetalleOtroProc.setAutoResizeMode(0);
        this.JTBDetalleOtroProc.doLayout();
        this.JTBDetalleOtroProc.setModel(this.modeloOtroProcedimiento);
        this.JTBDetalleOtroProc.getColumnModel().getColumn(0).setPreferredWidth(200);
        this.JTBDetalleOtroProc.getColumnModel().getColumn(1).setPreferredWidth(500);
        this.JTBDetalleOtroProc.getColumnModel().getColumn(2).setPreferredWidth(100);
    }

    private void buscarCodigoDelProcedimiento() {
        List<GenericoDTO> list = this.facturacionDAO.listProcedimiento(this.JTF_Codigo.getText());
        if (!list.isEmpty()) {
            this.JTF_Codigo.setText(list.get(0).getCodigo());
            this.JTF_NProcedimiento.setText(list.get(0).getNombre());
            this.cargarCombosVarios.cargarComboTableFinalidadPorProcedimientoAnexo1(this.JCBFinProcedimiento, Long.valueOf(this.JTF_Codigo.getText()));
            this.cargarCombosVarios.cargarComboBoxServicioGrupoProcedimiento(this.JCBGrupoSevicio, Long.valueOf(this.JTF_Codigo.getText()));
            this.cargarCombosVarios.cargarComboBoxServicioGrupoProcedimiento(this.JCBGrupoSevicio, this.JCBSevicioRips, Long.valueOf(this.JTF_Codigo.getText()));
            return;
        }
        this.JTF_Codigo.setText("");
        this.JTF_NProcedimiento.setText("");
        this.JTF_Codigo.requestFocus();
    }

    private void buscarCodigoOtroProcedimeinto() {
        List<GenericoDTO> list = this.facturacionDAO.listOtroProcedimiento(this.JTF_CodigoOtroProc.getText());
        if (!list.isEmpty()) {
            this.JTF_CodigoOtroProc.setText(list.get(0).getCodigo());
            this.JTF_NOtroProcedimiento.setText(list.get(0).getNombre());
        } else {
            this.JTF_CodigoOtroProc.setText("");
            this.JTF_NOtroProcedimiento.setText("");
            this.JTF_CodigoOtroProc.requestFocus();
        }
    }

    private void buscarCodigoSuministro() {
        System.err.println("codigo " + this.JTF_CodigoSuministro.getText());
        List<GenericoDTO> list = this.facturacionDAO.listMaterialAnexo1(this.JTF_CodigoSuministro.getText());
        if (!list.isEmpty()) {
            this.JTF_CodigoSuministro.setText(list.get(0).getId().toString());
            this.JTF_NSuministro.setText(list.get(0).getNombre());
        } else {
            this.JTF_CodigoSuministro.setText("");
            this.JTF_NSuministro.setText("");
            this.JTF_CodigoSuministro.requestFocus();
        }
    }

    public void adicionar() {
        if (this.JLB_NRegistro.getText().isEmpty()) {
            if (!this.JTF_Codigo.getText().isEmpty()) {
                if (!this.JTF_NProcedimiento.getText().isEmpty()) {
                    if (this.JCBGrupoSevicio.getSelectedIndex() != -1) {
                        if (this.JCBFinProcedimiento.getSelectedIndex() != -1) {
                            if (this.JCBSevicioRips.getSelectedIndex() != -1) {
                                if (!this.metodos.mVerificarDatosDoblesTabla(this.JTBDetalle, 0, this.JTF_Codigo.getText())) {
                                    this.xnfila = this.JTBDetalle.getRowCount();
                                    this.modeloDetalleProcedimiento.addRow(this.dato);
                                    this.modeloDetalleProcedimiento.setValueAt(this.JTF_Codigo.getText(), this.xnfila, 0);
                                    this.modeloDetalleProcedimiento.setValueAt(this.JTF_NProcedimiento.getText(), this.xnfila, 1);
                                    this.modeloDetalleProcedimiento.setValueAt(this.JSP_Cantidad.getValue(), this.xnfila, 2);
                                    this.modeloDetalleProcedimiento.setValueAt(this.JCBFinProcedimiento.getPopupTable().getValueAt(this.JCBFinProcedimiento.getSelectedIndex(), 2), this.xnfila, 3);
                                    System.err.println("combo" + this.JCBFinProcedimiento.getPopupTable().getValueAt(this.JCBFinProcedimiento.getSelectedIndex(), 2));
                                    this.modeloDetalleProcedimiento.setValueAt(this.JCBFinProcedimiento.getPopupTable().getValueAt(this.JCBFinProcedimiento.getSelectedIndex(), 2), this.xnfila, 3);
                                    this.modeloDetalleProcedimiento.setValueAt(this.ListripsEntitys.get(this.JCBSevicioRips.getSelectedIndex()).getCodigo(), this.xnfila, 4);
                                    this.modeloDetalleProcedimiento.setValueAt(this.listGrupoEntitys.get(this.JCBGrupoSevicio.getSelectedIndex()).getCodigo(), this.xnfila, 5);
                                    this.JTF_Codigo.setText("");
                                    this.JTF_NProcedimiento.setText("");
                                    this.JSP_Cantidad.setValue(new Integer(1));
                                    this.JCBGrupoSevicio.setSelectedIndex(-1);
                                    this.JCBSevicioRips.setSelectedIndex(-1);
                                    this.JTF_Codigo.requestFocus();
                                    return;
                                }
                                JOptionPane.showInternalMessageDialog(this, "El codigo ya se encuentra en la tabla", "VALIDAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                this.JTF_Codigo.requestFocus();
                                return;
                            }
                            JOptionPane.showInternalMessageDialog(this, "Selecionar un Servicio Rips", "VALIDAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                            this.JCBSevicioRips.requestFocus();
                            return;
                        }
                        JOptionPane.showInternalMessageDialog(this, "Selecionar un Finalidad", "VALIDAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        this.JCBFinProcedimiento.requestFocus();
                        return;
                    }
                    JOptionPane.showInternalMessageDialog(this, "Selecionar un Grupo", "VALIDAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    this.JCBGrupoSevicio.requestFocus();
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "El codigo no puede estar en blanco", "VALIDAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JTF_Codigo.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "El codigo no puede estar en blanco", "VALIDAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTF_Codigo.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "El registro ya se encuentra grabada", "VALIDAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    private void adicionarSuministro() {
        if (this.JLB_NRegistro.getText().isEmpty()) {
            if (!this.JTF_CodigoSuministro.getText().isEmpty()) {
                if (!this.JTF_NSuministro.getText().isEmpty()) {
                    if (!this.metodos.mVerificarDatosDoblesTabla(this.JTBDetalleSuministro, 0, this.JTF_CodigoSuministro.getText())) {
                        this.xnfilaS = this.JTBDetalleSuministro.getRowCount();
                        this.modeloSuministro.addRow(this.dato);
                        this.modeloSuministro.setValueAt(this.JTF_CodigoSuministro.getText(), this.xnfilaS, 0);
                        this.modeloSuministro.setValueAt(this.JTF_NSuministro.getText(), this.xnfilaS, 1);
                        this.modeloSuministro.setValueAt(this.JSP_CantidadSuministro.getValue(), this.xnfilaS, 2);
                        this.JTF_CodigoSuministro.setText("");
                        this.JTF_NSuministro.setText("");
                        this.JSP_CantidadSuministro.setValue(new Integer(1));
                        this.JTF_CodigoSuministro.requestFocus();
                        return;
                    }
                    JOptionPane.showInternalMessageDialog(this, "El codigo ya se encuentra en la tabla", "VALIDAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    this.JTF_CodigoSuministro.requestFocus();
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "El codigo no puede estar en blanco", "VALIDAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JTF_CodigoSuministro.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "El codigo no puede estar en blanco", "VALIDAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTF_CodigoSuministro.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "El registro ya se encuentra grabada", "VALIDAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    private void adicionarOtroProcedimiento() {
        if (this.JLB_NRegistro.getText().isEmpty()) {
            if (!this.JTF_CodigoOtroProc.getText().isEmpty()) {
                if (!this.JTF_NOtroProcedimiento.getText().isEmpty()) {
                    if (!this.metodos.mVerificarDatosDoblesTabla(this.JTBDetalleOtroProc, 0, this.JTF_CodigoOtroProc.getText())) {
                        this.xnfilaOP = this.JTBDetalleOtroProc.getRowCount();
                        this.modeloOtroProcedimiento.addRow(this.dato);
                        this.modeloOtroProcedimiento.setValueAt(this.JTF_CodigoOtroProc.getText(), this.xnfilaOP, 0);
                        this.modeloOtroProcedimiento.setValueAt(this.JTF_NOtroProcedimiento.getText(), this.xnfilaOP, 1);
                        this.modeloOtroProcedimiento.setValueAt(this.JSP_CantidadOtroProc.getValue(), this.xnfilaOP, 2);
                        this.JTF_CodigoOtroProc.setText("");
                        this.JTF_NOtroProcedimiento.setText("");
                        this.JSP_CantidadOtroProc.setValue(new Integer(1));
                        this.JTF_CodigoOtroProc.requestFocus();
                        return;
                    }
                    JOptionPane.showInternalMessageDialog(this, "El codigo ya se encuentra en la tabla", "VALIDAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    this.JTF_CodigoOtroProc.requestFocus();
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "El codigo no puede estar en blanco", "VALIDAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JTF_CodigoOtroProc.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "El codigo no puede estar en blanco", "VALIDAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTF_CodigoOtroProc.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "El registro ya se encuentra grabada", "VALIDAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    private void buscarPatologias(JTextField codigo, JTextField nombre) {
        PatologiaCie10DTO patologiaCie10DTO;
        if (!codigo.getText().isEmpty() && (patologiaCie10DTO = this.patologiaCie10DAO.patologiaFiltrada(codigo.getText(), -1)) != null) {
            codigo.setText(patologiaCie10DTO.getId());
            nombre.setText(patologiaCie10DTO.getNombre());
        }
    }

    public String getCodigoRips() {
        return this.codigoRips;
    }

    public void setCodigoRips(String codigoRips) {
        this.codigoRips = codigoRips;
    }

    public void cargarDetalleItemsOrden(List<OrdenProcedimientoProjection> list) {
        if (!list.isEmpty() || list != null) {
            this.JCBEspecialidad.setSelectedItem(list.get(0).getEspecialidad());
            this.JCBProfesional.setSelectedItem(list.get(0).getProfesional());
            this.JTFCDxP.setText(list.get(0).getDiagnosticoP());
            this.JTFCDxP.requestFocus();
            this.JTFCDxP.transferFocus();
            this.JTFCDxR1.setText(list.get(0).getDiagnosticoR1());
            this.JTFCDxR1.requestFocus();
            this.JTFCDxR1.transferFocus();
            this.JTFCDxR2.setText(list.get(0).getDiagnosticoR2());
            this.JTFCDxR2.requestFocus();
            this.JTFCDxR2.transferFocus();
            this.JTFCDxR3.setText(list.get(0).getDiagnosticoR3());
            this.JTFCDxR3.requestFocus();
            this.JTFCDxR3.transferFocus();
            list.forEach(e -> {
                this.JTF_Codigo.setText("" + e.getCups());
                this.JTF_Codigo.transferFocus();
                this.JTF_NProcedimiento.setText(e.getNombreCups());
                this.JSP_Cantidad.setValue(e.getCantidad());
                this.JCBGrupoSevicio.setSelectedItem(e.getGrupoRips());
                this.JCBSevicioRips.setSelectedItem(e.getSubGrupoRips());
                this.JCBFinProcedimiento.setSelectedItem(e.getFinalidadProcedimiento());
                adicionar();
            });
        }
    }
}
