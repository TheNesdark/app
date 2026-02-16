package com.genoma.plus.controller.facturacion;

import Acceso.Principal;
import Facturacion.JIFLiqServicios;
import Laboratorio.JIFRemisionLab;
import Utilidades.Metodos;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.genoma.plus.controller.historia.dto.Anexo2335Dto;
import com.genoma.plus.controller.historia.dto.Anexo2Dto;
import com.genoma.plus.controller.historia.dto.AnexoDatoUsuarioDto;
import com.genoma.plus.controller.historia.dto.AnexoInformacionIpsDto;
import com.genoma.plus.controller.laboratorio.dto.CustomPresenter;
import com.genoma.plus.dao.general.DepartamentoDAO;
import com.genoma.plus.dao.general.InformacionProfesionalDAO;
import com.genoma.plus.dao.general.MunicipioDAO;
import com.genoma.plus.dao.general.PatologiaCie10DAO;
import com.genoma.plus.dao.historia.InformacionAtencionAnexo2DAO;
import com.genoma.plus.dao.impl.general.DepartamentoDAOImpl;
import com.genoma.plus.dao.impl.general.InformacionProfesionalDAOImpl;
import com.genoma.plus.dao.impl.general.MunicipioDAOImpl;
import com.genoma.plus.dao.impl.general.PatologiaCie10DAOImpl;
import com.genoma.plus.dao.impl.historia.InformacionAtencionAnexo2DAOImpl;
import com.genoma.plus.domains.models.domains.general.RecursosMicroserviciosDomain;
import com.genoma.plus.dto.general.PatologiaCie10DTO;
import com.genoma.plus.jpa.service.IGPersonaService;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.text.ParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/facturacion/JPI_FormularioAnexo2Res2335.class */
public class JPI_FormularioAnexo2Res2335 extends JPanel {
    private JIFLiqServicios xjifliq;
    private String[] idDepartamento;
    private String[] idMunicipio;
    private String[] idEspecialidad;
    private String[] idProfesional;
    private DepartamentoDAO departamentoDAO;
    private MunicipioDAO municipioDAO;
    private PatologiaCie10DAO patologiaCie10DAO;
    private InformacionProfesionalDAO informacionProfesionalDAO;
    private InformacionAtencionAnexo2DAO informacionAtencionAnexo2DAO;
    private String idIngreso;
    private String idAtencion;
    private String triage;
    private String codigoRips;
    private ButtonGroup JBG_Clasificacion;
    private ButtonGroup JBG_Destino;
    private ButtonGroup JBG_Remitido;
    public JComboBox JCBEspecialidad;
    public JComboBox JCBProfesional;
    private JCheckBox JCH_Tiage1;
    private JCheckBox JCH_Tiage2;
    private JCheckBox JCH_Tiage3;
    private JDateChooser JDFecha;
    private JLabel JLB_Consecutivo;
    private JLabel JLB_Id;
    private JPanel JPI_ClasificacionTriage1;
    private JPanel JPI_DatosAnexo1;
    private JPanel JPI_Detalle1;
    private JPanel JPI_InformacionEncabezado1;
    public JTextField JTFCDxP;
    private JTextField JTFCDxR1;
    private JTextField JTFCDxR2;
    private JTextField JTFCDxR3;
    private JFormattedTextField JTFF_Hora;
    public JTextField JTFNCodigoDxP;
    private JTextField JTFNDxR1;
    private JTextField JTFNDxR2;
    private JTextField JTFNDxR3;
    private JTabbedPane JTPDatos;
    private JLabel jLabel2;
    private JPanel jPanel1;
    private Metodos metodos = new Metodos();
    private final IGPersonaService xPersonaService = (IGPersonaService) Principal.contexto.getBean(IGPersonaService.class);
    private Boolean estadoLlenadoCombos = false;
    private Boolean esRemitido = false;
    private String destino = "03";

    public JPI_FormularioAnexo2Res2335(String idIngreso, String idAtencion, JIFLiqServicios xjifliq, String codigoRips) {
        this.idIngreso = "0";
        this.idAtencion = "0";
        initComponents();
        this.idIngreso = idIngreso;
        this.idAtencion = idAtencion;
        this.xjifliq = xjifliq;
        setCodigoRips(codigoRips);
        springStart();
        nuevo();
    }

    private void initComponents() {
        this.JBG_Clasificacion = new ButtonGroup();
        this.JBG_Destino = new ButtonGroup();
        this.JBG_Remitido = new ButtonGroup();
        this.jPanel1 = new JPanel();
        this.JPI_DatosAnexo1 = new JPanel();
        this.JPI_InformacionEncabezado1 = new JPanel();
        this.JTFF_Hora = new JFormattedTextField();
        this.JPI_ClasificacionTriage1 = new JPanel();
        this.JCH_Tiage1 = new JCheckBox();
        this.JCH_Tiage2 = new JCheckBox();
        this.JCH_Tiage3 = new JCheckBox();
        this.JCBEspecialidad = new JComboBox();
        this.JCBProfesional = new JComboBox();
        this.JDFecha = new JDateChooser();
        this.JLB_Id = new JLabel();
        this.JLB_Consecutivo = new JLabel();
        this.JTPDatos = new JTabbedPane();
        this.JPI_Detalle1 = new JPanel();
        this.JTFCDxP = new JTextField();
        this.JTFNCodigoDxP = new JTextField();
        this.jLabel2 = new JLabel();
        this.JTFCDxR1 = new JTextField();
        this.JTFNDxR1 = new JTextField();
        this.JTFCDxR2 = new JTextField();
        this.JTFNDxR2 = new JTextField();
        this.JTFCDxR3 = new JTextField();
        this.JTFNDxR3 = new JTextField();
        setName("jpi_formulario_anexo2Res2335");
        this.jPanel1.setName("jpi_formulario_anexo2");
        this.JPI_InformacionEncabezado1.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN ENCABEZADO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTFF_Hora.setBorder(BorderFactory.createTitledBorder((Border) null, "Hora", 0, 0, new Font("Arial", 1, 12), Color.blue));
        try {
            this.JTFF_Hora.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("##:##:##")));
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        this.JTFF_Hora.setHorizontalAlignment(4);
        this.JTFF_Hora.setToolTipText("Formato hh:mm p");
        this.JTFF_Hora.setFont(new Font("Arial", 1, 12));
        this.JTFF_Hora.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.facturacion.JPI_FormularioAnexo2Res2335.1
            public void actionPerformed(ActionEvent evt) {
                JPI_FormularioAnexo2Res2335.this.JTFF_HoraActionPerformed(evt);
            }
        });
        this.JTFF_Hora.addFocusListener(new FocusAdapter() { // from class: com.genoma.plus.controller.facturacion.JPI_FormularioAnexo2Res2335.2
            public void focusGained(FocusEvent evt) {
                JPI_FormularioAnexo2Res2335.this.JTFF_HoraFocusGained(evt);
            }
        });
        this.JPI_ClasificacionTriage1.setBorder(BorderFactory.createTitledBorder((Border) null, "Clasificación Triage", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCH_Tiage1.setBackground(Color.red);
        this.JBG_Clasificacion.add(this.JCH_Tiage1);
        this.JCH_Tiage1.setFont(new Font("Arial", 1, 12));
        this.JCH_Tiage1.setText("I");
        this.JCH_Tiage1.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.facturacion.JPI_FormularioAnexo2Res2335.3
            public void actionPerformed(ActionEvent evt) {
                JPI_FormularioAnexo2Res2335.this.JCH_Tiage1ActionPerformed(evt);
            }
        });
        this.JCH_Tiage2.setBackground(Color.yellow);
        this.JBG_Clasificacion.add(this.JCH_Tiage2);
        this.JCH_Tiage2.setFont(new Font("Arial", 1, 12));
        this.JCH_Tiage2.setText("II");
        this.JCH_Tiage2.setToolTipText("");
        this.JCH_Tiage2.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.facturacion.JPI_FormularioAnexo2Res2335.4
            public void actionPerformed(ActionEvent evt) {
                JPI_FormularioAnexo2Res2335.this.JCH_Tiage2ActionPerformed(evt);
            }
        });
        this.JCH_Tiage3.setBackground(Color.green);
        this.JBG_Clasificacion.add(this.JCH_Tiage3);
        this.JCH_Tiage3.setFont(new Font("Arial", 1, 12));
        this.JCH_Tiage3.setSelected(true);
        this.JCH_Tiage3.setText("III");
        this.JCH_Tiage3.setToolTipText("");
        this.JCH_Tiage3.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.facturacion.JPI_FormularioAnexo2Res2335.5
            public void actionPerformed(ActionEvent evt) {
                JPI_FormularioAnexo2Res2335.this.JCH_Tiage3ActionPerformed(evt);
            }
        });
        GroupLayout JPI_ClasificacionTriage1Layout = new GroupLayout(this.JPI_ClasificacionTriage1);
        this.JPI_ClasificacionTriage1.setLayout(JPI_ClasificacionTriage1Layout);
        JPI_ClasificacionTriage1Layout.setHorizontalGroup(JPI_ClasificacionTriage1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_ClasificacionTriage1Layout.createSequentialGroup().addContainerGap().addComponent(this.JCH_Tiage1, -2, 60, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCH_Tiage2, -2, 60, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCH_Tiage3, -2, 60, -2).addContainerGap(-1, 32767)));
        JPI_ClasificacionTriage1Layout.setVerticalGroup(JPI_ClasificacionTriage1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_ClasificacionTriage1Layout.createSequentialGroup().addContainerGap().addGroup(JPI_ClasificacionTriage1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCH_Tiage1).addComponent(this.JCH_Tiage2).addComponent(this.JCH_Tiage3)).addContainerGap(-1, 32767)));
        this.JCBEspecialidad.setFont(new Font("Arial", 1, 12));
        this.JCBEspecialidad.setBorder(BorderFactory.createTitledBorder((Border) null, "Especialidad", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JCBEspecialidad.addItemListener(new ItemListener() { // from class: com.genoma.plus.controller.facturacion.JPI_FormularioAnexo2Res2335.6
            public void itemStateChanged(ItemEvent evt) {
                JPI_FormularioAnexo2Res2335.this.JCBEspecialidadItemStateChanged(evt);
            }
        });
        this.JCBProfesional.setFont(new Font("Arial", 1, 12));
        this.JCBProfesional.setBorder(BorderFactory.createTitledBorder((Border) null, "Profesional", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JDFecha.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFecha.setDateFormatString("dd/MM/yyyy");
        this.JDFecha.setFont(new Font("Arial", 1, 12));
        this.JLB_Id.setBackground(new Color(255, 255, 255));
        this.JLB_Id.setFont(new Font("Arial", 1, 14));
        this.JLB_Id.setForeground(Color.red);
        this.JLB_Id.setHorizontalAlignment(0);
        this.JLB_Id.setBorder(BorderFactory.createTitledBorder("Id"));
        this.JLB_Consecutivo.setFont(new Font("Arial", 1, 14));
        this.JLB_Consecutivo.setHorizontalAlignment(0);
        this.JLB_Consecutivo.setBorder(BorderFactory.createTitledBorder((Border) null, "No. Consecutivo", 0, 0, new Font("Arial", 1, 12), Color.red));
        GroupLayout JPI_InformacionEncabezado1Layout = new GroupLayout(this.JPI_InformacionEncabezado1);
        this.JPI_InformacionEncabezado1.setLayout(JPI_InformacionEncabezado1Layout);
        JPI_InformacionEncabezado1Layout.setHorizontalGroup(JPI_InformacionEncabezado1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_InformacionEncabezado1Layout.createSequentialGroup().addContainerGap().addGroup(JPI_InformacionEncabezado1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_InformacionEncabezado1Layout.createSequentialGroup().addComponent(this.JDFecha, -2, 145, -2).addGap(10, 10, 10).addComponent(this.JTFF_Hora, -2, 105, -2).addGap(10, 10, 10).addComponent(this.JLB_Id, -2, 123, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JLB_Consecutivo, -2, 121, -2).addGap(0, 0, 32767)).addGroup(JPI_InformacionEncabezado1Layout.createSequentialGroup().addComponent(this.JPI_ClasificacionTriage1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBEspecialidad, -2, 231, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBProfesional, 0, 257, 32767))).addContainerGap()));
        JPI_InformacionEncabezado1Layout.setVerticalGroup(JPI_InformacionEncabezado1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_InformacionEncabezado1Layout.createSequentialGroup().addContainerGap().addGroup(JPI_InformacionEncabezado1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JDFecha, -2, -1, -2).addComponent(this.JTFF_Hora, -2, 42, -2).addComponent(this.JLB_Id, -2, 51, -2).addComponent(this.JLB_Consecutivo, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPI_InformacionEncabezado1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JPI_ClasificacionTriage1, -2, -1, -2).addGroup(JPI_InformacionEncabezado1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBEspecialidad, -2, -1, -2).addComponent(this.JCBProfesional, -2, -1, -2))).addContainerGap(11, 32767)));
        this.JTPDatos.setForeground(Color.red);
        this.JTPDatos.setFont(new Font("Arial", 1, 14));
        this.JTFCDxP.setFont(new Font("Arial", 1, 12));
        this.JTFCDxP.setBorder(BorderFactory.createTitledBorder((Border) null, "Cie10", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFCDxP.addFocusListener(new FocusAdapter() { // from class: com.genoma.plus.controller.facturacion.JPI_FormularioAnexo2Res2335.7
            public void focusLost(FocusEvent evt) {
                JPI_FormularioAnexo2Res2335.this.JTFCDxPFocusLost(evt);
            }
        });
        this.JTFCDxP.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.facturacion.JPI_FormularioAnexo2Res2335.8
            public void actionPerformed(ActionEvent evt) {
                JPI_FormularioAnexo2Res2335.this.JTFCDxPActionPerformed(evt);
            }
        });
        this.JTFCDxP.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.facturacion.JPI_FormularioAnexo2Res2335.9
            public void keyPressed(KeyEvent evt) {
                JPI_FormularioAnexo2Res2335.this.JTFCDxPKeyPressed(evt);
            }
        });
        this.JTFNCodigoDxP.setFont(new Font("Arial", 1, 12));
        this.JTFNCodigoDxP.setBorder(BorderFactory.createTitledBorder((Border) null, "Dx Principal", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFNCodigoDxP.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.facturacion.JPI_FormularioAnexo2Res2335.10
            public void mouseClicked(MouseEvent evt) {
                JPI_FormularioAnexo2Res2335.this.JTFNCodigoDxPMouseClicked(evt);
            }
        });
        this.JTFNCodigoDxP.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.facturacion.JPI_FormularioAnexo2Res2335.11
            public void keyPressed(KeyEvent evt) {
                JPI_FormularioAnexo2Res2335.this.JTFNCodigoDxPKeyPressed(evt);
            }
        });
        this.jLabel2.setFont(new Font("Arial", 1, 12));
        this.jLabel2.setForeground(Color.red);
        this.jLabel2.setHorizontalAlignment(0);
        this.jLabel2.setText("DIAGNÓSTICO RELACIONADO");
        this.JTFCDxR1.setFont(new Font("Arial", 1, 12));
        this.JTFCDxR1.addFocusListener(new FocusAdapter() { // from class: com.genoma.plus.controller.facturacion.JPI_FormularioAnexo2Res2335.12
            public void focusGained(FocusEvent evt) {
                JPI_FormularioAnexo2Res2335.this.JTFCDxR1FocusGained(evt);
            }

            public void focusLost(FocusEvent evt) {
                JPI_FormularioAnexo2Res2335.this.JTFCDxR1FocusLost(evt);
            }
        });
        this.JTFCDxR1.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.facturacion.JPI_FormularioAnexo2Res2335.13
            public void keyPressed(KeyEvent evt) {
                JPI_FormularioAnexo2Res2335.this.JTFCDxR1KeyPressed(evt);
            }
        });
        this.JTFNDxR1.setFont(new Font("Arial", 1, 12));
        this.JTFNDxR1.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.facturacion.JPI_FormularioAnexo2Res2335.14
            public void mouseClicked(MouseEvent evt) {
                JPI_FormularioAnexo2Res2335.this.JTFNDxR1MouseClicked(evt);
            }
        });
        this.JTFNDxR1.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.facturacion.JPI_FormularioAnexo2Res2335.15
            public void keyPressed(KeyEvent evt) {
                JPI_FormularioAnexo2Res2335.this.JTFNDxR1KeyPressed(evt);
            }
        });
        this.JTFCDxR2.setFont(new Font("Arial", 1, 12));
        this.JTFCDxR2.addFocusListener(new FocusAdapter() { // from class: com.genoma.plus.controller.facturacion.JPI_FormularioAnexo2Res2335.16
            public void focusLost(FocusEvent evt) {
                JPI_FormularioAnexo2Res2335.this.JTFCDxR2FocusLost(evt);
            }
        });
        this.JTFCDxR2.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.facturacion.JPI_FormularioAnexo2Res2335.17
            public void keyPressed(KeyEvent evt) {
                JPI_FormularioAnexo2Res2335.this.JTFCDxR2KeyPressed(evt);
            }
        });
        this.JTFNDxR2.setFont(new Font("Arial", 1, 12));
        this.JTFNDxR2.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.facturacion.JPI_FormularioAnexo2Res2335.18
            public void mouseClicked(MouseEvent evt) {
                JPI_FormularioAnexo2Res2335.this.JTFNDxR2MouseClicked(evt);
            }
        });
        this.JTFNDxR2.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.facturacion.JPI_FormularioAnexo2Res2335.19
            public void keyPressed(KeyEvent evt) {
                JPI_FormularioAnexo2Res2335.this.JTFNDxR2KeyPressed(evt);
            }
        });
        this.JTFCDxR3.setFont(new Font("Arial", 1, 12));
        this.JTFCDxR3.addFocusListener(new FocusAdapter() { // from class: com.genoma.plus.controller.facturacion.JPI_FormularioAnexo2Res2335.20
            public void focusLost(FocusEvent evt) {
                JPI_FormularioAnexo2Res2335.this.JTFCDxR3FocusLost(evt);
            }
        });
        this.JTFCDxR3.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.facturacion.JPI_FormularioAnexo2Res2335.21
            public void keyPressed(KeyEvent evt) {
                JPI_FormularioAnexo2Res2335.this.JTFCDxR3KeyPressed(evt);
            }
        });
        this.JTFNDxR3.setFont(new Font("Arial", 1, 12));
        this.JTFNDxR3.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.facturacion.JPI_FormularioAnexo2Res2335.22
            public void mouseClicked(MouseEvent evt) {
                JPI_FormularioAnexo2Res2335.this.JTFNDxR3MouseClicked(evt);
            }
        });
        this.JTFNDxR3.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.facturacion.JPI_FormularioAnexo2Res2335.23
            public void keyPressed(KeyEvent evt) {
                JPI_FormularioAnexo2Res2335.this.JTFNDxR3KeyPressed(evt);
            }
        });
        GroupLayout JPI_Detalle1Layout = new GroupLayout(this.JPI_Detalle1);
        this.JPI_Detalle1.setLayout(JPI_Detalle1Layout);
        JPI_Detalle1Layout.setHorizontalGroup(JPI_Detalle1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_Detalle1Layout.createSequentialGroup().addContainerGap().addGroup(JPI_Detalle1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jLabel2, -1, 725, 32767).addGroup(JPI_Detalle1Layout.createSequentialGroup().addComponent(this.JTFCDxP, -2, 90, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFNCodigoDxP)).addGroup(JPI_Detalle1Layout.createSequentialGroup().addGroup(JPI_Detalle1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JTFCDxR3).addComponent(this.JTFCDxR2, GroupLayout.Alignment.LEADING).addComponent(this.JTFCDxR1, -1, 90, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPI_Detalle1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFNDxR1).addComponent(this.JTFNDxR2).addComponent(this.JTFNDxR3, GroupLayout.Alignment.TRAILING)))).addContainerGap(23, 32767)));
        JPI_Detalle1Layout.setVerticalGroup(JPI_Detalle1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_Detalle1Layout.createSequentialGroup().addContainerGap().addGroup(JPI_Detalle1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFNCodigoDxP, -2, 50, -2).addComponent(this.JTFCDxP, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPI_Detalle1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFNDxR1, -2, 40, -2).addComponent(this.JTFCDxR1, -2, 40, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPI_Detalle1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFNDxR2, -2, 40, -2).addComponent(this.JTFCDxR2, -2, 40, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPI_Detalle1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFNDxR3, -2, 40, -2).addComponent(this.JTFCDxR3, -2, 40, -2)).addContainerGap(16, 32767)));
        this.JTPDatos.addTab("DIAGÓSTICO", this.JPI_Detalle1);
        GroupLayout JPI_DatosAnexo1Layout = new GroupLayout(this.JPI_DatosAnexo1);
        this.JPI_DatosAnexo1.setLayout(JPI_DatosAnexo1Layout);
        JPI_DatosAnexo1Layout.setHorizontalGroup(JPI_DatosAnexo1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DatosAnexo1Layout.createSequentialGroup().addContainerGap().addGroup(JPI_DatosAnexo1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTPDatos, -2, -1, -2).addComponent(this.JPI_InformacionEncabezado1, -2, -1, -2)).addContainerGap(-1, 32767)));
        JPI_DatosAnexo1Layout.setVerticalGroup(JPI_DatosAnexo1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DatosAnexo1Layout.createSequentialGroup().addContainerGap().addComponent(this.JPI_InformacionEncabezado1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTPDatos, -2, 276, -2).addContainerGap(96, 32767)));
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.JPI_DatosAnexo1, -2, -1, -2).addGap(0, 0, 32767)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.JPI_DatosAnexo1, -2, -1, -2).addGap(0, 0, 32767)));
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(5, 5, 5).addComponent(this.jPanel1, -2, -1, -2).addGap(5, 5, 5)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(5, 5, 5).addComponent(this.jPanel1, -2, -1, -2).addGap(0, 0, 32767)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFF_HoraActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFF_HoraFocusGained(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_Tiage1ActionPerformed(ActionEvent evt) {
        this.triage = "1";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_Tiage2ActionPerformed(ActionEvent evt) {
        this.triage = "2";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_Tiage3ActionPerformed(ActionEvent evt) {
        this.triage = "3";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBEspecialidadItemStateChanged(ItemEvent evt) {
        if (this.estadoLlenadoCombos.booleanValue() && this.JCBEspecialidad.getSelectedIndex() != -1) {
            llenarComboProfesional();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCDxPFocusLost(FocusEvent evt) {
        if (!this.JTFCDxP.getText().isEmpty()) {
            buscarPatologias(this.JTFCDxP, this.JTFNCodigoDxP);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCDxPActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCDxPKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JTFCDxP.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNCodigoDxPMouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNCodigoDxPKeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCDxR1FocusLost(FocusEvent evt) {
        if (!this.JTFCDxR1.getText().isEmpty()) {
            buscarPatologias(this.JTFCDxR1, this.JTFNDxR1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCDxR1KeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNDxR1MouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNDxR1KeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCDxR2FocusLost(FocusEvent evt) {
        if (!this.JTFCDxR2.getText().isEmpty()) {
            buscarPatologias(this.JTFCDxR2, this.JTFNDxR2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCDxR2KeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNDxR2MouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNDxR2KeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCDxR3FocusLost(FocusEvent evt) {
        if (!this.JTFCDxR3.getText().isEmpty()) {
            buscarPatologias(this.JTFCDxR3, this.JTFNDxR3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCDxR3KeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNDxR3MouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNDxR3KeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCDxR1FocusGained(FocusEvent evt) {
    }

    public void nuevo() {
        this.estadoLlenadoCombos = false;
        this.JDFecha.setDate(this.metodos.getFechaActual());
        this.JTFF_Hora.setValue(this.metodos.formatoH24.format(this.metodos.getFechaActual()));
        llenarComboEspecialidad();
        this.JTFCDxP.setText("");
        this.JTFCDxR1.setText("");
        this.JTFCDxR2.setText("");
        this.JTFNCodigoDxP.setText("");
        this.JTFNDxR1.setText("");
        this.JTFNDxR2.setText("");
        this.estadoLlenadoCombos = true;
        mBuscarAnexo2335();
        this.triage = "3";
    }

    private void buscarPatologias(JTextField codigo, JTextField nombre) {
        PatologiaCie10DTO patologiaCie10DTO = this.patologiaCie10DAO.patologiaFiltrada(codigo.getText(), -1);
        if (patologiaCie10DTO != null) {
            codigo.setText(patologiaCie10DTO.getId());
            nombre.setText(patologiaCie10DTO.getNombre());
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

    public String getCodigoRips() {
        return this.codigoRips;
    }

    public void setCodigoRips(String codigoRips) {
        this.codigoRips = codigoRips;
    }

    private void springStart() {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"});
        this.departamentoDAO = (DepartamentoDAOImpl) classPathXmlApplicationContext.getBean("departamentoDAO");
        this.municipioDAO = (MunicipioDAOImpl) classPathXmlApplicationContext.getBean("municipioDAO");
        this.informacionAtencionAnexo2DAO = (InformacionAtencionAnexo2DAOImpl) classPathXmlApplicationContext.getBean("informacionAtencionAnexo2DAOImpl");
        this.patologiaCie10DAO = (PatologiaCie10DAOImpl) classPathXmlApplicationContext.getBean("patologiaCie10DAOImpl");
        this.informacionProfesionalDAO = (InformacionProfesionalDAOImpl) classPathXmlApplicationContext.getBean("informacionProfesionalDAOImpl");
    }

    public void consultarDatosAnexo() {
        List<Object[]> listaInformacionaAnexoDosAtencion = this.informacionAtencionAnexo2DAO.informacionAtencionAnexo2FiltradaIdIngresoAnexonuevo(this.idIngreso);
        if (!listaInformacionaAnexoDosAtencion.isEmpty()) {
            System.out.println("" + listaInformacionaAnexoDosAtencion.get(0)[0].toString());
            this.JDFecha.setDate(Date.valueOf(listaInformacionaAnexoDosAtencion.get(0)[0].toString()));
            this.JTFF_Hora.setText(listaInformacionaAnexoDosAtencion.get(0)[1].toString());
            this.JCBEspecialidad.setSelectedItem(listaInformacionaAnexoDosAtencion.get(0)[5].toString());
            this.JCBProfesional.setSelectedItem(listaInformacionaAnexoDosAtencion.get(0)[4].toString());
            if (null == Integer.valueOf(listaInformacionaAnexoDosAtencion.get(0)[2].toString())) {
                this.JCH_Tiage3.setSelected(true);
                this.triage = "3";
            } else {
                switch (Integer.parseInt(listaInformacionaAnexoDosAtencion.get(0)[2].toString())) {
                    case 1:
                        this.JCH_Tiage1.setSelected(true);
                        this.triage = "1";
                        break;
                    case 2:
                        this.JCH_Tiage2.setSelected(true);
                        this.triage = "2";
                        break;
                    default:
                        this.JCH_Tiage3.setSelected(true);
                        this.triage = "3";
                        break;
                }
            }
            if (listaInformacionaAnexoDosAtencion.get(0)[3] != null) {
                String[] arrayDiagnosticos = listaInformacionaAnexoDosAtencion.get(0)[3].toString().split(",");
                for (int i = 0; i < arrayDiagnosticos.length; i++) {
                    String[] arrayDiagnosticosIndividual = arrayDiagnosticos[i].split("_");
                    switch (i) {
                        case 0:
                            this.JTFCDxP.setText(arrayDiagnosticosIndividual[0]);
                            this.JTFNCodigoDxP.setText(arrayDiagnosticosIndividual[1]);
                            break;
                        case 1:
                            this.JTFCDxR1.setText(arrayDiagnosticosIndividual[0]);
                            this.JTFNDxR1.setText(arrayDiagnosticosIndividual[1]);
                            break;
                        case 2:
                            this.JTFCDxR2.setText(arrayDiagnosticosIndividual[0]);
                            this.JTFNDxR2.setText(arrayDiagnosticosIndividual[1]);
                            break;
                        case 3:
                            this.JTFCDxR3.setText(arrayDiagnosticosIndividual[0]);
                            this.JTFNDxR3.setText(arrayDiagnosticosIndividual[1]);
                            break;
                    }
                }
            } else {
                this.JTFCDxP.setText(listaInformacionaAnexoDosAtencion.get(0)[7].toString());
                this.JTFNCodigoDxP.setText(listaInformacionaAnexoDosAtencion.get(0)[8].toString());
                this.JTFCDxR1.setText(listaInformacionaAnexoDosAtencion.get(0)[9].toString());
                this.JTFNDxR1.setText(listaInformacionaAnexoDosAtencion.get(0)[10].toString());
                this.JTFCDxR2.setText(listaInformacionaAnexoDosAtencion.get(0)[11].toString());
                this.JTFNDxR2.setText(listaInformacionaAnexoDosAtencion.get(0)[12].toString());
                this.JTFCDxR3.setText(listaInformacionaAnexoDosAtencion.get(0)[13].toString());
                this.JTFNDxR3.setText(listaInformacionaAnexoDosAtencion.get(0)[14].toString());
            }
            this.JCBEspecialidad.setSelectedItem(listaInformacionaAnexoDosAtencion.get(0)[5].toString());
            this.JCBProfesional.setSelectedItem(listaInformacionaAnexoDosAtencion.get(0)[4].toString());
        }
    }

    public void grabar() {
        if (!this.JTFCDxP.getText().isEmpty() || !this.JTFNCodigoDxP.getText().isEmpty()) {
            accionGrabar();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "El diagnóstico principal no puede ser nulo", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
        this.JTPDatos.setSelectedIndex(2);
        this.JTFCDxP.requestFocus();
    }

    private void accionGrabar() {
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            Anexo2335Dto anexo2335Dto = new Anexo2335Dto();
            new AnexoInformacionIpsDto();
            new AnexoDatoUsuarioDto();
            Anexo2Dto anexo2Dto = new Anexo2Dto();
            List<Object[]> listaInformacionAnexo2 = this.informacionAtencionAnexo2DAO.informacionIngresoAnexo2Res2335(this.idIngreso);
            if (!listaInformacionAnexo2.isEmpty()) {
                for (int fila = 0; fila < listaInformacionAnexo2.size(); fila++) {
                    try {
                        System.err.println("this.idIngreso" + this.idIngreso);
                        if (!this.JLB_Id.getText().equals("")) {
                            anexo2335Dto.setId(Long.valueOf(Long.parseLong(this.JLB_Id.getText())));
                        }
                        anexo2335Dto.setIngresoId(Long.valueOf(this.idIngreso));
                        anexo2335Dto.setIdOrden(Long.valueOf(Long.parseLong("0")));
                        anexo2335Dto.setFechaRegistro(this.metodos.formatoAMD1.format(this.JDFecha.getDate()));
                        anexo2335Dto.setHoraRegistro(this.JTFF_Hora.getText());
                        anexo2335Dto.setTipoAnexo(2);
                        anexo2335Dto.setEstado(true);
                        anexo2335Dto.setProfesionalId(this.idProfesional[this.JCBProfesional.getSelectedIndex()]);
                        anexo2335Dto.setEspecialidadId(this.idEspecialidad[this.JCBEspecialidad.getSelectedIndex()]);
                        anexo2335Dto.setIdUsuarioS(Principal.usuarioSistemaDTO.getIdPersonaCargo());
                        AnexoInformacionIpsDto anexoInformacionIpsDto = (AnexoInformacionIpsDto) this.metodos.getMapper().readValue(listaInformacionAnexo2.get(fila)[0].toString(), AnexoInformacionIpsDto.class);
                        anexoInformacionIpsDto.setCodigoEntidadPagadora(getCodigoRips());
                        AnexoDatoUsuarioDto anexoDatoUsuarioDto = (AnexoDatoUsuarioDto) this.metodos.getMapper().readValue(listaInformacionAnexo2.get(fila)[1].toString(), AnexoDatoUsuarioDto.class);
                        anexo2335Dto.setAnexoInformacionIps(anexoInformacionIpsDto);
                        anexo2335Dto.setAnexoDatoUsuario(anexoDatoUsuarioDto);
                        anexo2Dto.setMotivoConsulta(listaInformacionAnexo2.get(fila)[2].toString());
                        anexo2Dto.setClasificacionTriage(String.valueOf(this.triage));
                        anexo2Dto.setFechaHoraIngreso(listaInformacionAnexo2.get(fila)[5].toString());
                        anexo2Dto.setViaIngreso(listaInformacionAnexo2.get(fila)[4].toString());
                        anexo2Dto.setCodigoPrestadorRemite(" ");
                        anexo2Dto.setDiagnostico(this.JTFCDxP.getText());
                        anexo2Dto.setDiagnosticoRelacionado1(this.JTFCDxR1.getText());
                        anexo2Dto.setDiagnosticoRelacionado2(this.JTFCDxR2.getText());
                        anexo2Dto.setDiagnosticoRelacionado3(this.JTFCDxR3.getText());
                        anexo2335Dto.setAnexo2(anexo2Dto);
                        System.out.println(this.metodos.getMapper().writeValueAsString(anexo2335Dto));
                        try {
                            RecursosMicroserviciosDomain microserviciosDomain = this.metodos.getParametrosEncriptados("24", "RegistroAnexo2335");
                            Response responsePos = this.metodos.getResteasyClient().target(microserviciosDomain.getUrlRecurso()).request().post(Entity.json(this.metodos.getMapper().writeValueAsString(anexo2335Dto)));
                            CustomPresenter presenter = (CustomPresenter) this.metodos.getMapper().readValue((String) responsePos.readEntity(String.class), CustomPresenter.class);
                            Anexo2335Dto dto = (Anexo2335Dto) this.metodos.getMapper().readValue(this.metodos.getMapper().writeValueAsString(presenter.getData()), Anexo2335Dto.class);
                            System.err.println("dtoId" + dto.getId());
                            this.JLB_Id.setText(dto.getId().toString());
                            this.JLB_Consecutivo.setText(this.metodos.numeroCerosIzquierda(dto.getId(), 12));
                            responsePos.close();
                            this.metodos.getResteasyClient().close();
                        } catch (JsonProcessingException e) {
                            Logger.getLogger(JIFRemisionLab.class.getName()).log(Level.SEVERE, (String) null, e);
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            }
        }
    }

    public void mBuscarAnexo2335() {
        try {
            RecursosMicroserviciosDomain microserviciosDomain = this.metodos.getParametrosEncriptados("24", "finByAnexoIngreso");
            Anexo2335Dto.builder().build();
            String fullUrl = microserviciosDomain.getUrlRecurso() + "/" + this.idIngreso + "/2";
            System.out.println("fullurlSql --- " + fullUrl);
            Response response = this.metodos.getResteasyClient().target(fullUrl).request().get();
            int statusCode = response.getStatus();
            if (statusCode == 200) {
                try {
                    new CustomPresenter();
                    CustomPresenter presenter = (CustomPresenter) this.metodos.getMapper().readValue((String) response.readEntity(String.class), CustomPresenter.class);
                    Anexo2335Dto anexo2335Dto = (Anexo2335Dto) this.metodos.getMapper().readValue(this.metodos.getMapper().writeValueAsString(presenter.getData()), new TypeReference<Anexo2335Dto>() { // from class: com.genoma.plus.controller.facturacion.JPI_FormularioAnexo2Res2335.24
                    });
                    if (anexo2335Dto != null) {
                        System.err.println("id" + anexo2335Dto.getId());
                        this.JLB_Id.setText(anexo2335Dto.getId().toString());
                        this.JDFecha.setDate(Date.valueOf(anexo2335Dto.getFechaRegistro()));
                        this.JTFF_Hora.setText(anexo2335Dto.getHoraRegistro());
                        this.JLB_Consecutivo.setText(this.metodos.numeroCerosIzquierda(anexo2335Dto.getId(), 12));
                        this.JTFCDxP.setText(anexo2335Dto.getAnexo2().getDiagnostico());
                        if (!this.JTFCDxP.getText().isEmpty()) {
                            buscarPatologias(this.JTFCDxP, this.JTFNCodigoDxP);
                        }
                        this.JTFCDxR1.setText(anexo2335Dto.getAnexo2().getDiagnosticoRelacionado1());
                        if (!this.JTFCDxR1.getText().isEmpty()) {
                            buscarPatologias(this.JTFCDxR1, this.JTFNDxR1);
                        }
                        this.JTFCDxR2.setText(anexo2335Dto.getAnexo2().getDiagnosticoRelacionado1());
                        if (!this.JTFCDxR2.getText().isEmpty()) {
                            buscarPatologias(this.JTFCDxR2, this.JTFNDxR2);
                        }
                        this.JTFCDxR3.setText(anexo2335Dto.getAnexo2().getDiagnosticoRelacionado1());
                        if (!this.JTFCDxR3.getText().isEmpty()) {
                            buscarPatologias(this.JTFCDxR3, this.JTFNDxR3);
                        }
                        switch (anexo2335Dto.getAnexo2().getClasificacionTriage()) {
                            case "1":
                                this.JCH_Tiage1.setSelected(true);
                                this.triage = "1";
                                break;
                            case "2":
                                this.JCH_Tiage2.setSelected(true);
                                this.triage = "2";
                                break;
                            case "3":
                                this.JCH_Tiage3.setSelected(true);
                                this.triage = "3";
                                break;
                        }
                    } else {
                        consultarDatosAnexo();
                    }
                } catch (JsonProcessingException e) {
                    Logger.getLogger(JPI_FormularioAnexo2Res2335.class.getName()).log(Level.SEVERE, (String) null, e);
                }
            } else {
                consultarDatosAnexo();
            }
            response.close();
            this.metodos.getResteasyClient().close();
        } catch (Exception e2) {
            Logger.getLogger(JPI_FormularioAnexo2Res2335.class.getName()).log(Level.SEVERE, (String) null, (Throwable) e2);
        }
    }
}
