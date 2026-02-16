package com.genoma.plus.controller.facturacion;

import Acceso.Principal;
import Historia.JDPatologia;
import Historia.ReporteAnexo2;
import Utilidades.Metodos;
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
import com.genoma.plus.dto.general.DepartamentoDTO;
import com.genoma.plus.dto.general.MunicipioDTO;
import com.genoma.plus.dto.general.PatologiaCie10DTO;
import com.genoma.plus.dto.historia.AnexoDosDTO;
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
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
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
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/facturacion/JPI_FormularioAnexo2.class */
public class JPI_FormularioAnexo2 extends JPanel {
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
    private JButton JBBuscaTercero;
    private ButtonGroup JBG_Clasificacion;
    private ButtonGroup JBG_Destino;
    private ButtonGroup JBG_Remitido;
    public JComboBox JCBEspecialidad;
    public JComboBox JCBProfesional;
    private JComboBox JCB_Remitido_Departamento;
    private JComboBox JCB_Remitido_Municipio;
    private JCheckBox JCH_Destino_ContraRemision;
    private JCheckBox JCH_Destino_Domicilio;
    private JCheckBox JCH_Destino_Internacion;
    private JCheckBox JCH_Destino_Observacion;
    private JCheckBox JCH_Destino_Otros;
    private JCheckBox JCH_Destino_Remision;
    private JCheckBox JCH_Remitido_No;
    private JCheckBox JCH_Remitido_Si;
    private JCheckBox JCH_Tiage1;
    private JCheckBox JCH_Tiage2;
    private JCheckBox JCH_Tiage3;
    private JDateChooser JDFecha;
    private JLabel JLB_Id;
    private JLabel JLB_NRegistro;
    private JLabel JLB_Remitido;
    private JPanel JPI_ClasificacionTriage;
    private JPanel JPI_DatosAnexo;
    private JPanel JPI_Destino;
    private JPanel JPI_Detalle;
    private JPanel JPI_InformacionEncabezado;
    private JPanel JPI_MotivoConsulta;
    private JPanel JPI_Remitido;
    private JScrollPane JSPMotivoConsulta;
    public JTextField JTFCDxP;
    private JTextField JTFCDxR1;
    private JTextField JTFCDxR2;
    private JTextField JTFCDxR3;
    private JFormattedTextField JTFF_Hora;
    public JTextField JTFNCodigoDxP;
    private JTextField JTFNDxR1;
    private JTextField JTFNDxR2;
    private JTextField JTFNDxR3;
    public JTextField JTF_Remitido_CodigoPrestador;
    public JTextField JTF_Remitido_Nombre_Prestador;
    private JTabbedPane JTPDatos;
    private JTabbedPane JTPFormulario;
    public JTextPane JTPMotivoConsulta;
    private JLabel jLabel1;
    private Metodos metodos = new Metodos();
    private Boolean estadoLlenadoCombos = false;
    private Boolean esRemitido = false;
    private String destino = "Observación";
    private Integer triage = 1;

    public JPI_FormularioAnexo2(String idIngreso, String idAtencion) {
        this.idIngreso = "0";
        this.idAtencion = "0";
        initComponents();
        this.idIngreso = idIngreso;
        this.idAtencion = idAtencion;
        springStart();
        nuevo();
    }

    private void initComponents() {
        this.JBG_Clasificacion = new ButtonGroup();
        this.JBG_Destino = new ButtonGroup();
        this.JBG_Remitido = new ButtonGroup();
        this.JTPFormulario = new JTabbedPane();
        this.JPI_DatosAnexo = new JPanel();
        this.JPI_InformacionEncabezado = new JPanel();
        this.JLB_NRegistro = new JLabel();
        this.JTFF_Hora = new JFormattedTextField();
        this.JPI_ClasificacionTriage = new JPanel();
        this.JCH_Tiage1 = new JCheckBox();
        this.JCH_Tiage2 = new JCheckBox();
        this.JCH_Tiage3 = new JCheckBox();
        this.JCBEspecialidad = new JComboBox();
        this.JCBProfesional = new JComboBox();
        this.JDFecha = new JDateChooser();
        this.JTPDatos = new JTabbedPane();
        this.JPI_Remitido = new JPanel();
        this.JLB_Remitido = new JLabel();
        this.JCH_Remitido_Si = new JCheckBox();
        this.JCH_Remitido_No = new JCheckBox();
        this.JTF_Remitido_Nombre_Prestador = new JTextField();
        this.JTF_Remitido_CodigoPrestador = new JTextField();
        this.JCB_Remitido_Departamento = new JComboBox();
        this.JCB_Remitido_Municipio = new JComboBox();
        this.JBBuscaTercero = new JButton();
        this.JPI_MotivoConsulta = new JPanel();
        this.JSPMotivoConsulta = new JScrollPane();
        this.JTPMotivoConsulta = new JTextPane();
        this.JPI_Detalle = new JPanel();
        this.JTFCDxP = new JTextField();
        this.JTFNCodigoDxP = new JTextField();
        this.jLabel1 = new JLabel();
        this.JTFCDxR1 = new JTextField();
        this.JTFNDxR1 = new JTextField();
        this.JTFCDxR2 = new JTextField();
        this.JTFNDxR2 = new JTextField();
        this.JTFCDxR3 = new JTextField();
        this.JTFNDxR3 = new JTextField();
        this.JPI_Destino = new JPanel();
        this.JCH_Destino_Domicilio = new JCheckBox();
        this.JCH_Destino_Internacion = new JCheckBox();
        this.JCH_Destino_Observacion = new JCheckBox();
        this.JCH_Destino_Remision = new JCheckBox();
        this.JCH_Destino_ContraRemision = new JCheckBox();
        this.JCH_Destino_Otros = new JCheckBox();
        this.JLB_Id = new JLabel();
        setName("jpi_formulario_anexo2");
        this.JTPFormulario.setForeground(Color.red);
        this.JTPFormulario.setFont(new Font("Arial", 1, 14));
        this.JPI_InformacionEncabezado.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN ENCABEZADO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JLB_NRegistro.setBackground(new Color(255, 255, 255));
        this.JLB_NRegistro.setFont(new Font("Arial", 1, 14));
        this.JLB_NRegistro.setForeground(Color.red);
        this.JLB_NRegistro.setHorizontalAlignment(0);
        this.JLB_NRegistro.setBorder(BorderFactory.createTitledBorder("No."));
        this.JTFF_Hora.setBorder(BorderFactory.createTitledBorder((Border) null, "Hora", 0, 0, new Font("Arial", 1, 12), Color.blue));
        try {
            this.JTFF_Hora.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("##:##:##")));
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        this.JTFF_Hora.setHorizontalAlignment(4);
        this.JTFF_Hora.setToolTipText("Formato hh:mm p");
        this.JTFF_Hora.setFont(new Font("Arial", 1, 12));
        this.JTFF_Hora.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.facturacion.JPI_FormularioAnexo2.1
            public void actionPerformed(ActionEvent evt) {
                JPI_FormularioAnexo2.this.JTFF_HoraActionPerformed(evt);
            }
        });
        this.JTFF_Hora.addFocusListener(new FocusAdapter() { // from class: com.genoma.plus.controller.facturacion.JPI_FormularioAnexo2.2
            public void focusGained(FocusEvent evt) {
                JPI_FormularioAnexo2.this.JTFF_HoraFocusGained(evt);
            }
        });
        this.JPI_ClasificacionTriage.setBorder(BorderFactory.createTitledBorder((Border) null, "Clasificación Triage", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCH_Tiage1.setBackground(Color.red);
        this.JBG_Clasificacion.add(this.JCH_Tiage1);
        this.JCH_Tiage1.setFont(new Font("Arial", 1, 12));
        this.JCH_Tiage1.setText("I");
        this.JCH_Tiage1.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.facturacion.JPI_FormularioAnexo2.3
            public void actionPerformed(ActionEvent evt) {
                JPI_FormularioAnexo2.this.JCH_Tiage1ActionPerformed(evt);
            }
        });
        this.JCH_Tiage2.setBackground(Color.yellow);
        this.JBG_Clasificacion.add(this.JCH_Tiage2);
        this.JCH_Tiage2.setFont(new Font("Arial", 1, 12));
        this.JCH_Tiage2.setText("II");
        this.JCH_Tiage2.setToolTipText("");
        this.JCH_Tiage2.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.facturacion.JPI_FormularioAnexo2.4
            public void actionPerformed(ActionEvent evt) {
                JPI_FormularioAnexo2.this.JCH_Tiage2ActionPerformed(evt);
            }
        });
        this.JCH_Tiage3.setBackground(Color.green);
        this.JBG_Clasificacion.add(this.JCH_Tiage3);
        this.JCH_Tiage3.setFont(new Font("Arial", 1, 12));
        this.JCH_Tiage3.setSelected(true);
        this.JCH_Tiage3.setText("III");
        this.JCH_Tiage3.setToolTipText("");
        this.JCH_Tiage3.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.facturacion.JPI_FormularioAnexo2.5
            public void actionPerformed(ActionEvent evt) {
                JPI_FormularioAnexo2.this.JCH_Tiage3ActionPerformed(evt);
            }
        });
        GroupLayout JPI_ClasificacionTriageLayout = new GroupLayout(this.JPI_ClasificacionTriage);
        this.JPI_ClasificacionTriage.setLayout(JPI_ClasificacionTriageLayout);
        JPI_ClasificacionTriageLayout.setHorizontalGroup(JPI_ClasificacionTriageLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_ClasificacionTriageLayout.createSequentialGroup().addContainerGap().addComponent(this.JCH_Tiage1, -2, 60, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCH_Tiage2, -2, 60, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCH_Tiage3, -2, 60, -2).addContainerGap(-1, 32767)));
        JPI_ClasificacionTriageLayout.setVerticalGroup(JPI_ClasificacionTriageLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_ClasificacionTriageLayout.createSequentialGroup().addContainerGap().addGroup(JPI_ClasificacionTriageLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCH_Tiage1).addComponent(this.JCH_Tiage2).addComponent(this.JCH_Tiage3)).addContainerGap(-1, 32767)));
        this.JCBEspecialidad.setFont(new Font("Arial", 1, 12));
        this.JCBEspecialidad.setBorder(BorderFactory.createTitledBorder((Border) null, "Especialidad", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JCBEspecialidad.addItemListener(new ItemListener() { // from class: com.genoma.plus.controller.facturacion.JPI_FormularioAnexo2.6
            public void itemStateChanged(ItemEvent evt) {
                JPI_FormularioAnexo2.this.JCBEspecialidadItemStateChanged(evt);
            }
        });
        this.JCBProfesional.setFont(new Font("Arial", 1, 12));
        this.JCBProfesional.setBorder(BorderFactory.createTitledBorder((Border) null, "Profesional", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JDFecha.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFecha.setDateFormatString("dd/MM/yyyy");
        this.JDFecha.setFont(new Font("Arial", 1, 12));
        GroupLayout JPI_InformacionEncabezadoLayout = new GroupLayout(this.JPI_InformacionEncabezado);
        this.JPI_InformacionEncabezado.setLayout(JPI_InformacionEncabezadoLayout);
        JPI_InformacionEncabezadoLayout.setHorizontalGroup(JPI_InformacionEncabezadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_InformacionEncabezadoLayout.createSequentialGroup().addContainerGap().addGroup(JPI_InformacionEncabezadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_InformacionEncabezadoLayout.createSequentialGroup().addComponent(this.JDFecha, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 33, 32767).addComponent(this.JTFF_Hora, -2, 90, -2).addGap(378, 378, 378).addComponent(this.JLB_NRegistro, -2, 123, -2)).addGroup(JPI_InformacionEncabezadoLayout.createSequentialGroup().addComponent(this.JPI_ClasificacionTriage, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBEspecialidad, -2, 231, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBProfesional, 0, -1, 32767).addContainerGap()))));
        JPI_InformacionEncabezadoLayout.setVerticalGroup(JPI_InformacionEncabezadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_InformacionEncabezadoLayout.createSequentialGroup().addGroup(JPI_InformacionEncabezadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLB_NRegistro, -2, 48, -2).addGroup(JPI_InformacionEncabezadoLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JDFecha, -2, -1, -2).addComponent(this.JTFF_Hora, -2, 42, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPI_InformacionEncabezadoLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JPI_ClasificacionTriage, -2, -1, -2).addGroup(JPI_InformacionEncabezadoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBProfesional, -2, -1, -2).addComponent(this.JCBEspecialidad, -2, -1, -2))).addGap(10, 10, 10)));
        this.JTPDatos.setForeground(Color.red);
        this.JTPDatos.setFont(new Font("Arial", 1, 14));
        this.JLB_Remitido.setFont(new Font("Arial", 1, 12));
        this.JLB_Remitido.setText("Viene Remitido?");
        this.JBG_Remitido.add(this.JCH_Remitido_Si);
        this.JCH_Remitido_Si.setFont(new Font("Arial", 1, 12));
        this.JCH_Remitido_Si.setText("SI");
        this.JCH_Remitido_Si.setHorizontalAlignment(2);
        this.JCH_Remitido_Si.setHorizontalTextPosition(2);
        this.JCH_Remitido_Si.setIconTextGap(5);
        this.JCH_Remitido_Si.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.facturacion.JPI_FormularioAnexo2.7
            public void actionPerformed(ActionEvent evt) {
                JPI_FormularioAnexo2.this.JCH_Remitido_SiActionPerformed(evt);
            }
        });
        this.JBG_Remitido.add(this.JCH_Remitido_No);
        this.JCH_Remitido_No.setFont(new Font("Arial", 1, 12));
        this.JCH_Remitido_No.setSelected(true);
        this.JCH_Remitido_No.setText("NO");
        this.JCH_Remitido_No.setHorizontalAlignment(2);
        this.JCH_Remitido_No.setHorizontalTextPosition(2);
        this.JCH_Remitido_No.setIconTextGap(5);
        this.JCH_Remitido_No.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.facturacion.JPI_FormularioAnexo2.8
            public void actionPerformed(ActionEvent evt) {
                JPI_FormularioAnexo2.this.JCH_Remitido_NoActionPerformed(evt);
            }
        });
        this.JTF_Remitido_Nombre_Prestador.setFont(new Font("Arial", 1, 12));
        this.JTF_Remitido_Nombre_Prestador.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre Prestador", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTF_Remitido_Nombre_Prestador.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.facturacion.JPI_FormularioAnexo2.9
            public void actionPerformed(ActionEvent evt) {
                JPI_FormularioAnexo2.this.JTF_Remitido_Nombre_PrestadorActionPerformed(evt);
            }
        });
        this.JTF_Remitido_CodigoPrestador.setFont(new Font("Arial", 1, 12));
        this.JTF_Remitido_CodigoPrestador.setBorder(BorderFactory.createTitledBorder((Border) null, "Código Habilitación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCB_Remitido_Departamento.setFont(new Font("Arial", 1, 12));
        this.JCB_Remitido_Departamento.setBorder(BorderFactory.createTitledBorder((Border) null, "Departamento", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JCB_Remitido_Departamento.addItemListener(new ItemListener() { // from class: com.genoma.plus.controller.facturacion.JPI_FormularioAnexo2.10
            public void itemStateChanged(ItemEvent evt) {
                JPI_FormularioAnexo2.this.JCB_Remitido_DepartamentoItemStateChanged(evt);
            }
        });
        this.JCB_Remitido_Municipio.setFont(new Font("Arial", 1, 12));
        this.JCB_Remitido_Municipio.setBorder(BorderFactory.createTitledBorder((Border) null, "Municipio", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JBBuscaTercero.setIcon(new ImageIcon(getClass().getResource("/Imagenes/lupa.png")));
        this.JBBuscaTercero.setToolTipText("Buscar Tercero");
        this.JBBuscaTercero.setName("xRadicacion");
        this.JBBuscaTercero.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.facturacion.JPI_FormularioAnexo2.11
            public void actionPerformed(ActionEvent evt) {
                JPI_FormularioAnexo2.this.JBBuscaTerceroActionPerformed(evt);
            }
        });
        GroupLayout JPI_RemitidoLayout = new GroupLayout(this.JPI_Remitido);
        this.JPI_Remitido.setLayout(JPI_RemitidoLayout);
        JPI_RemitidoLayout.setHorizontalGroup(JPI_RemitidoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_RemitidoLayout.createSequentialGroup().addContainerGap().addGroup(JPI_RemitidoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_RemitidoLayout.createSequentialGroup().addComponent(this.JTF_Remitido_Nombre_Prestador, -2, 493, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBBuscaTercero, -2, 58, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JTF_Remitido_CodigoPrestador, -2, 162, -2)).addGroup(JPI_RemitidoLayout.createSequentialGroup().addComponent(this.JLB_Remitido, -2, 101, -2).addGap(18, 18, 18).addComponent(this.JCH_Remitido_Si).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCH_Remitido_No).addGap(0, 0, 32767)).addGroup(JPI_RemitidoLayout.createSequentialGroup().addComponent(this.JCB_Remitido_Departamento, 0, 348, 32767).addGap(18, 18, 18).addComponent(this.JCB_Remitido_Municipio, -2, 364, -2))).addContainerGap()));
        JPI_RemitidoLayout.setVerticalGroup(JPI_RemitidoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_RemitidoLayout.createSequentialGroup().addGap(8, 8, 8).addGroup(JPI_RemitidoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JLB_Remitido).addComponent(this.JCH_Remitido_Si).addComponent(this.JCH_Remitido_No)).addGap(18, 18, 18).addGroup(JPI_RemitidoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_RemitidoLayout.createSequentialGroup().addGroup(JPI_RemitidoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTF_Remitido_Nombre_Prestador, -2, 50, -2).addComponent(this.JTF_Remitido_CodigoPrestador, -2, 50, -2)).addGap(27, 27, 27).addGroup(JPI_RemitidoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCB_Remitido_Departamento, -2, 50, -2).addComponent(this.JCB_Remitido_Municipio, -2, 50, -2))).addComponent(this.JBBuscaTercero, -2, 50, -2)).addContainerGap(54, 32767)));
        this.JTPDatos.addTab("REMITIDO?", this.JPI_Remitido);
        this.JSPMotivoConsulta.setForeground(UIManager.getDefaults().getColor("textHighlight"));
        this.JTPMotivoConsulta.setFont(new Font("Arial", 1, 12));
        this.JTPMotivoConsulta.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.facturacion.JPI_FormularioAnexo2.12
            public void keyPressed(KeyEvent evt) {
                JPI_FormularioAnexo2.this.JTPMotivoConsultaKeyPressed(evt);
            }
        });
        this.JSPMotivoConsulta.setViewportView(this.JTPMotivoConsulta);
        GroupLayout JPI_MotivoConsultaLayout = new GroupLayout(this.JPI_MotivoConsulta);
        this.JPI_MotivoConsulta.setLayout(JPI_MotivoConsultaLayout);
        JPI_MotivoConsultaLayout.setHorizontalGroup(JPI_MotivoConsultaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 754, 32767).addGroup(JPI_MotivoConsultaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPMotivoConsulta, -1, 754, 32767)));
        JPI_MotivoConsultaLayout.setVerticalGroup(JPI_MotivoConsultaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 247, 32767).addGroup(JPI_MotivoConsultaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPMotivoConsulta, -1, 247, 32767)));
        this.JTPDatos.addTab("MOTIVO DE CONSULTA", this.JPI_MotivoConsulta);
        this.JTFCDxP.setFont(new Font("Arial", 1, 12));
        this.JTFCDxP.setBorder(BorderFactory.createTitledBorder((Border) null, "Cie10", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFCDxP.addFocusListener(new FocusAdapter() { // from class: com.genoma.plus.controller.facturacion.JPI_FormularioAnexo2.13
            public void focusLost(FocusEvent evt) {
                JPI_FormularioAnexo2.this.JTFCDxPFocusLost(evt);
            }
        });
        this.JTFCDxP.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.facturacion.JPI_FormularioAnexo2.14
            public void actionPerformed(ActionEvent evt) {
                JPI_FormularioAnexo2.this.JTFCDxPActionPerformed(evt);
            }
        });
        this.JTFCDxP.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.facturacion.JPI_FormularioAnexo2.15
            public void keyPressed(KeyEvent evt) {
                JPI_FormularioAnexo2.this.JTFCDxPKeyPressed(evt);
            }
        });
        this.JTFNCodigoDxP.setFont(new Font("Arial", 1, 12));
        this.JTFNCodigoDxP.setBorder(BorderFactory.createTitledBorder((Border) null, "Dx Principal", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFNCodigoDxP.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.facturacion.JPI_FormularioAnexo2.16
            public void mouseClicked(MouseEvent evt) {
                JPI_FormularioAnexo2.this.JTFNCodigoDxPMouseClicked(evt);
            }
        });
        this.JTFNCodigoDxP.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.facturacion.JPI_FormularioAnexo2.17
            public void keyPressed(KeyEvent evt) {
                JPI_FormularioAnexo2.this.JTFNCodigoDxPKeyPressed(evt);
            }
        });
        this.jLabel1.setFont(new Font("Arial", 1, 12));
        this.jLabel1.setForeground(Color.red);
        this.jLabel1.setHorizontalAlignment(0);
        this.jLabel1.setText("DIAGNÓSTICO RELACIONADO");
        this.JTFCDxR1.setFont(new Font("Arial", 1, 12));
        this.JTFCDxR1.addFocusListener(new FocusAdapter() { // from class: com.genoma.plus.controller.facturacion.JPI_FormularioAnexo2.18
            public void focusLost(FocusEvent evt) {
                JPI_FormularioAnexo2.this.JTFCDxR1FocusLost(evt);
            }
        });
        this.JTFCDxR1.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.facturacion.JPI_FormularioAnexo2.19
            public void keyPressed(KeyEvent evt) {
                JPI_FormularioAnexo2.this.JTFCDxR1KeyPressed(evt);
            }
        });
        this.JTFNDxR1.setFont(new Font("Arial", 1, 12));
        this.JTFNDxR1.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.facturacion.JPI_FormularioAnexo2.20
            public void mouseClicked(MouseEvent evt) {
                JPI_FormularioAnexo2.this.JTFNDxR1MouseClicked(evt);
            }
        });
        this.JTFNDxR1.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.facturacion.JPI_FormularioAnexo2.21
            public void keyPressed(KeyEvent evt) {
                JPI_FormularioAnexo2.this.JTFNDxR1KeyPressed(evt);
            }
        });
        this.JTFCDxR2.setFont(new Font("Arial", 1, 12));
        this.JTFCDxR2.addFocusListener(new FocusAdapter() { // from class: com.genoma.plus.controller.facturacion.JPI_FormularioAnexo2.22
            public void focusLost(FocusEvent evt) {
                JPI_FormularioAnexo2.this.JTFCDxR2FocusLost(evt);
            }
        });
        this.JTFCDxR2.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.facturacion.JPI_FormularioAnexo2.23
            public void keyPressed(KeyEvent evt) {
                JPI_FormularioAnexo2.this.JTFCDxR2KeyPressed(evt);
            }
        });
        this.JTFNDxR2.setFont(new Font("Arial", 1, 12));
        this.JTFNDxR2.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.facturacion.JPI_FormularioAnexo2.24
            public void mouseClicked(MouseEvent evt) {
                JPI_FormularioAnexo2.this.JTFNDxR2MouseClicked(evt);
            }
        });
        this.JTFNDxR2.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.facturacion.JPI_FormularioAnexo2.25
            public void keyPressed(KeyEvent evt) {
                JPI_FormularioAnexo2.this.JTFNDxR2KeyPressed(evt);
            }
        });
        this.JTFCDxR3.setFont(new Font("Arial", 1, 12));
        this.JTFCDxR3.addFocusListener(new FocusAdapter() { // from class: com.genoma.plus.controller.facturacion.JPI_FormularioAnexo2.26
            public void focusLost(FocusEvent evt) {
                JPI_FormularioAnexo2.this.JTFCDxR3FocusLost(evt);
            }
        });
        this.JTFCDxR3.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.facturacion.JPI_FormularioAnexo2.27
            public void keyPressed(KeyEvent evt) {
                JPI_FormularioAnexo2.this.JTFCDxR3KeyPressed(evt);
            }
        });
        this.JTFNDxR3.setFont(new Font("Arial", 1, 12));
        this.JTFNDxR3.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.facturacion.JPI_FormularioAnexo2.28
            public void mouseClicked(MouseEvent evt) {
                JPI_FormularioAnexo2.this.JTFNDxR3MouseClicked(evt);
            }
        });
        this.JTFNDxR3.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.facturacion.JPI_FormularioAnexo2.29
            public void keyPressed(KeyEvent evt) {
                JPI_FormularioAnexo2.this.JTFNDxR3KeyPressed(evt);
            }
        });
        GroupLayout JPI_DetalleLayout = new GroupLayout(this.JPI_Detalle);
        this.JPI_Detalle.setLayout(JPI_DetalleLayout);
        JPI_DetalleLayout.setHorizontalGroup(JPI_DetalleLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DetalleLayout.createSequentialGroup().addContainerGap().addGroup(JPI_DetalleLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jLabel1, -1, 725, 32767).addGroup(JPI_DetalleLayout.createSequentialGroup().addComponent(this.JTFCDxP, -2, 90, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFNCodigoDxP)).addGroup(JPI_DetalleLayout.createSequentialGroup().addGroup(JPI_DetalleLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JTFCDxR3).addComponent(this.JTFCDxR2, GroupLayout.Alignment.LEADING).addComponent(this.JTFCDxR1, -1, 90, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPI_DetalleLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFNDxR1).addComponent(this.JTFNDxR2).addComponent(this.JTFNDxR3, GroupLayout.Alignment.TRAILING)))).addContainerGap(11, 32767)));
        JPI_DetalleLayout.setVerticalGroup(JPI_DetalleLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DetalleLayout.createSequentialGroup().addContainerGap().addGroup(JPI_DetalleLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFNCodigoDxP, -2, 50, -2).addComponent(this.JTFCDxP, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel1).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPI_DetalleLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFNDxR1, -2, 40, -2).addComponent(this.JTFCDxR1, -2, 40, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPI_DetalleLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFNDxR2, -2, 40, -2).addComponent(this.JTFCDxR2, -2, 40, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPI_DetalleLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFNDxR3, -2, 40, -2).addComponent(this.JTFCDxR3, -2, 40, -2)).addContainerGap(10, 32767)));
        this.JTPDatos.addTab("DIAGÓSTICO", this.JPI_Detalle);
        this.JPI_Destino.setBorder(BorderFactory.createTitledBorder((Border) null, "DESTINO", 0, 0, new Font("Arial", 1, 14), Color.red));
        this.JPI_Destino.setLayout(new AbsoluteLayout());
        this.JBG_Destino.add(this.JCH_Destino_Domicilio);
        this.JCH_Destino_Domicilio.setFont(new Font("Arial", 1, 12));
        this.JCH_Destino_Domicilio.setText("Domicilio");
        this.JCH_Destino_Domicilio.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.facturacion.JPI_FormularioAnexo2.30
            public void actionPerformed(ActionEvent evt) {
                JPI_FormularioAnexo2.this.JCH_Destino_DomicilioActionPerformed(evt);
            }
        });
        this.JPI_Destino.add(this.JCH_Destino_Domicilio, new AbsoluteConstraints(12, 25, -1, -1));
        this.JBG_Destino.add(this.JCH_Destino_Internacion);
        this.JCH_Destino_Internacion.setFont(new Font("Arial", 1, 12));
        this.JCH_Destino_Internacion.setText("Internación");
        this.JCH_Destino_Internacion.setToolTipText("");
        this.JCH_Destino_Internacion.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.facturacion.JPI_FormularioAnexo2.31
            public void actionPerformed(ActionEvent evt) {
                JPI_FormularioAnexo2.this.JCH_Destino_InternacionActionPerformed(evt);
            }
        });
        this.JPI_Destino.add(this.JCH_Destino_Internacion, new AbsoluteConstraints(109, 25, -1, -1));
        this.JBG_Destino.add(this.JCH_Destino_Observacion);
        this.JCH_Destino_Observacion.setFont(new Font("Arial", 1, 12));
        this.JCH_Destino_Observacion.setSelected(true);
        this.JCH_Destino_Observacion.setText("Observación");
        this.JCH_Destino_Observacion.setToolTipText("");
        this.JCH_Destino_Observacion.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.facturacion.JPI_FormularioAnexo2.32
            public void actionPerformed(ActionEvent evt) {
                JPI_FormularioAnexo2.this.JCH_Destino_ObservacionActionPerformed(evt);
            }
        });
        this.JPI_Destino.add(this.JCH_Destino_Observacion, new AbsoluteConstraints(211, 25, -1, -1));
        this.JBG_Destino.add(this.JCH_Destino_Remision);
        this.JCH_Destino_Remision.setFont(new Font("Arial", 1, 12));
        this.JCH_Destino_Remision.setText("Remisión");
        this.JCH_Destino_Remision.setToolTipText("");
        this.JCH_Destino_Remision.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.facturacion.JPI_FormularioAnexo2.33
            public void actionPerformed(ActionEvent evt) {
                JPI_FormularioAnexo2.this.JCH_Destino_RemisionActionPerformed(evt);
            }
        });
        this.JPI_Destino.add(this.JCH_Destino_Remision, new AbsoluteConstraints(322, 25, -1, -1));
        this.JBG_Destino.add(this.JCH_Destino_ContraRemision);
        this.JCH_Destino_ContraRemision.setFont(new Font("Arial", 1, 12));
        this.JCH_Destino_ContraRemision.setText("Contraremisión");
        this.JCH_Destino_ContraRemision.setToolTipText("");
        this.JCH_Destino_ContraRemision.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.facturacion.JPI_FormularioAnexo2.34
            public void actionPerformed(ActionEvent evt) {
                JPI_FormularioAnexo2.this.JCH_Destino_ContraRemisionActionPerformed(evt);
            }
        });
        this.JPI_Destino.add(this.JCH_Destino_ContraRemision, new AbsoluteConstraints(414, 25, -1, -1));
        this.JBG_Destino.add(this.JCH_Destino_Otros);
        this.JCH_Destino_Otros.setFont(new Font("Arial", 1, 12));
        this.JCH_Destino_Otros.setText("Otros");
        this.JCH_Destino_Otros.setToolTipText("");
        this.JCH_Destino_Otros.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.facturacion.JPI_FormularioAnexo2.35
            public void actionPerformed(ActionEvent evt) {
                JPI_FormularioAnexo2.this.JCH_Destino_OtrosActionPerformed(evt);
            }
        });
        this.JPI_Destino.add(this.JCH_Destino_Otros, new AbsoluteConstraints(547, 25, -1, -1));
        this.JLB_Id.setBackground(new Color(255, 255, 255));
        this.JLB_Id.setFont(new Font("Arial", 1, 14));
        this.JLB_Id.setForeground(Color.red);
        this.JLB_Id.setHorizontalAlignment(0);
        this.JLB_Id.setBorder(BorderFactory.createTitledBorder("Id"));
        GroupLayout JPI_DatosAnexoLayout = new GroupLayout(this.JPI_DatosAnexo);
        this.JPI_DatosAnexo.setLayout(JPI_DatosAnexoLayout);
        JPI_DatosAnexoLayout.setHorizontalGroup(JPI_DatosAnexoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DatosAnexoLayout.createSequentialGroup().addContainerGap().addGroup(JPI_DatosAnexoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTPDatos, -2, -1, -2).addGroup(JPI_DatosAnexoLayout.createSequentialGroup().addComponent(this.JPI_Destino, -2, 619, -2).addGap(18, 18, 18).addComponent(this.JLB_Id, -2, 123, -2)).addComponent(this.JPI_InformacionEncabezado, -2, -1, -2)).addContainerGap(-1, 32767)));
        JPI_DatosAnexoLayout.setVerticalGroup(JPI_DatosAnexoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DatosAnexoLayout.createSequentialGroup().addContainerGap().addComponent(this.JPI_InformacionEncabezado, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTPDatos, -2, 276, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPI_DatosAnexoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JPI_Destino, -2, 59, -2).addComponent(this.JLB_Id, -1, -1, 32767)).addContainerGap(-1, 32767)));
        this.JTPFormulario.addTab("DATOS ANEXO", this.JPI_DatosAnexo);
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTPFormulario, -2, -1, -2).addContainerGap(8, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTPFormulario, -2, -1, -2).addContainerGap(-1, 32767)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNDxR3KeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNDxR3MouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCDxR3KeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JTFNDxR3.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCDxR3FocusLost(FocusEvent evt) {
        if (!this.JTFCDxR3.getText().isEmpty()) {
            buscarPatologias(this.JTFCDxR3, this.JTFNDxR3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNDxR2KeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JTFNDxR2.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNDxR2MouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCDxR2KeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JTFCDxR2.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCDxR2FocusLost(FocusEvent evt) {
        if (!this.JTFCDxR2.getText().isEmpty()) {
            buscarPatologias(this.JTFCDxR2, this.JTFNDxR2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNDxR1KeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JTFNDxR1.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNDxR1MouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCDxR1KeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JTFCDxR1.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCDxR1FocusLost(FocusEvent evt) {
        if (!this.JTFCDxR1.getText().isEmpty()) {
            buscarPatologias(this.JTFCDxR1, this.JTFNDxR1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNCodigoDxPKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JTFNCodigoDxP.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNCodigoDxPMouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCDxPKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JTFCDxP.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCDxPActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCDxPFocusLost(FocusEvent evt) {
        if (!this.JTFCDxP.getText().isEmpty()) {
            buscarPatologias(this.JTFCDxP, this.JTFNCodigoDxP);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCB_Remitido_DepartamentoItemStateChanged(ItemEvent evt) {
        if (this.estadoLlenadoCombos.booleanValue() && this.JCB_Remitido_Departamento.getSelectedIndex() != -1) {
            llenarComboMunicipio();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFF_HoraFocusGained(FocusEvent evt) {
        this.JTFF_Hora.selectAll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFF_HoraActionPerformed(ActionEvent evt) {
        this.JDFecha.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTF_Remitido_Nombre_PrestadorActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_Tiage1ActionPerformed(ActionEvent evt) {
        this.triage = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_Tiage2ActionPerformed(ActionEvent evt) {
        this.triage = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_Tiage3ActionPerformed(ActionEvent evt) {
        this.triage = 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_Remitido_SiActionPerformed(ActionEvent evt) {
        this.esRemitido = true;
        activarDesactivarCompomentesRemision(this.esRemitido);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_Remitido_NoActionPerformed(ActionEvent evt) {
        this.esRemitido = false;
        activarDesactivarCompomentesRemision(this.esRemitido);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_Destino_DomicilioActionPerformed(ActionEvent evt) {
        this.destino = this.JCH_Destino_Domicilio.getText();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_Destino_InternacionActionPerformed(ActionEvent evt) {
        this.destino = this.JCH_Destino_Internacion.getText();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_Destino_ObservacionActionPerformed(ActionEvent evt) {
        this.destino = this.JCH_Destino_Observacion.getText();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_Destino_RemisionActionPerformed(ActionEvent evt) {
        this.destino = this.JCH_Destino_Remision.getText();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_Destino_ContraRemisionActionPerformed(ActionEvent evt) {
        this.destino = this.JCH_Destino_Domicilio.getText();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_Destino_OtrosActionPerformed(ActionEvent evt) {
        this.destino = this.JCH_Destino_Otros.getText();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBBuscaTerceroActionPerformed(ActionEvent evt) {
        JDPatologia x = new JDPatologia(null, true, this);
        x.setLocationRelativeTo(this);
        x.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBEspecialidadItemStateChanged(ItemEvent evt) {
        if (this.estadoLlenadoCombos.booleanValue() && this.JCBEspecialidad.getSelectedIndex() != -1) {
            llenarComboProfesional();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTPMotivoConsultaKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 9) {
            this.JTPMotivoConsulta.transferFocus();
        }
    }

    public void nuevo() {
        this.estadoLlenadoCombos = false;
        this.JCB_Remitido_Municipio.removeAllItems();
        this.JDFecha.setDate(this.metodos.getFechaActual());
        this.JTFF_Hora.setValue(this.metodos.formatoH24.format(this.metodos.getFechaActual()));
        llenarComboEspecialidad();
        llenarComboDepartamento();
        this.JLB_NRegistro.setText("");
        this.JTFCDxP.setText("");
        this.JTFCDxR1.setText("");
        this.JTFCDxR2.setText("");
        this.JTFNCodigoDxP.setText("");
        this.JTFNDxR1.setText("");
        this.JTFNDxR2.setText("");
        this.JTPMotivoConsulta.setText("");
        this.estadoLlenadoCombos = true;
        consultarDatosAnexo();
        activarDesactivarCompomentesRemision(this.esRemitido);
    }

    private void buscarPatologias(JTextField codigo, JTextField nombre) {
        PatologiaCie10DTO patologiaCie10DTO = this.patologiaCie10DAO.patologiaFiltrada(codigo.getText(), -1);
        if (patologiaCie10DTO != null) {
            codigo.setText(patologiaCie10DTO.getId());
            nombre.setText(patologiaCie10DTO.getNombre());
        }
    }

    private void llenarComboDepartamento() {
        this.JCB_Remitido_Departamento.removeAllItems();
        List<DepartamentoDTO> listadoDepartamento = this.departamentoDAO.listDepartamento();
        if (!listadoDepartamento.isEmpty()) {
            this.idDepartamento = new String[listadoDepartamento.size()];
            for (int i = 0; i < listadoDepartamento.size(); i++) {
                this.idDepartamento[i] = listadoDepartamento.get(i).getId();
                this.JCB_Remitido_Departamento.addItem(listadoDepartamento.get(i).getNombre());
            }
            this.JCB_Remitido_Departamento.setSelectedIndex(-1);
        }
    }

    private void llenarComboMunicipio() {
        this.JCB_Remitido_Municipio.removeAllItems();
        List<MunicipioDTO> listadoMunicipio = this.municipioDAO.listadoMunicipioFiltradoIdDepartamento(this.idDepartamento[this.JCB_Remitido_Departamento.getSelectedIndex()]);
        if (!listadoMunicipio.isEmpty()) {
            this.idMunicipio = new String[listadoMunicipio.size()];
            for (int i = 0; i < listadoMunicipio.size(); i++) {
                this.idMunicipio[i] = listadoMunicipio.get(i).getIdCodigo();
                this.JCB_Remitido_Municipio.addItem(listadoMunicipio.get(i).getNombre());
            }
            this.JCB_Remitido_Municipio.setSelectedIndex(-1);
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

    private void springStart() {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"});
        this.departamentoDAO = (DepartamentoDAOImpl) classPathXmlApplicationContext.getBean("departamentoDAO");
        this.municipioDAO = (MunicipioDAOImpl) classPathXmlApplicationContext.getBean("municipioDAO");
        this.informacionAtencionAnexo2DAO = (InformacionAtencionAnexo2DAOImpl) classPathXmlApplicationContext.getBean("informacionAtencionAnexo2DAOImpl");
        this.patologiaCie10DAO = (PatologiaCie10DAOImpl) classPathXmlApplicationContext.getBean("patologiaCie10DAOImpl");
        this.informacionProfesionalDAO = (InformacionProfesionalDAOImpl) classPathXmlApplicationContext.getBean("informacionProfesionalDAOImpl");
    }

    public void consultarDatosAnexo() {
        List<Object[]> listaInformacionaAnexoDos = this.informacionAtencionAnexo2DAO.informacionAtencionAnexo2FiltradaIdIngreso(this.idIngreso);
        if (!listaInformacionaAnexoDos.isEmpty()) {
            this.JLB_Id.setText(listaInformacionaAnexoDos.get(0)[0].toString());
            this.JLB_NRegistro.setText(listaInformacionaAnexoDos.get(0)[1].toString());
            this.JDFecha.setDate(Date.valueOf(listaInformacionaAnexoDos.get(0)[2].toString()));
            this.JTFF_Hora.setText(listaInformacionaAnexoDos.get(0)[3].toString());
            System.err.println(listaInformacionaAnexoDos.get(0)[9].toString());
            if (null == Integer.valueOf(listaInformacionaAnexoDos.get(0)[9].toString())) {
                this.JCH_Tiage3.setSelected(true);
                this.triage = 3;
            } else {
                switch (Integer.parseInt(listaInformacionaAnexoDos.get(0)[9].toString())) {
                    case 1:
                        this.JCH_Tiage1.setSelected(true);
                        this.triage = 1;
                        break;
                    case 2:
                        this.JCH_Tiage2.setSelected(true);
                        this.triage = 2;
                        break;
                    default:
                        this.JCH_Tiage3.setSelected(true);
                        this.triage = 3;
                        break;
                }
            }
            if (Boolean.valueOf(listaInformacionaAnexoDos.get(0)[4].toString()).booleanValue()) {
                this.JCH_Remitido_Si.setSelected(true);
                this.esRemitido = true;
            } else {
                this.JCH_Remitido_No.setSelected(true);
                this.esRemitido = false;
            }
            activarDesactivarCompomentesRemision(this.esRemitido);
            this.JTF_Remitido_Nombre_Prestador.setText(listaInformacionaAnexoDos.get(0)[7].toString());
            this.JTF_Remitido_CodigoPrestador.setText(listaInformacionaAnexoDos.get(0)[8].toString());
            this.JCB_Remitido_Departamento.setSelectedItem(listaInformacionaAnexoDos.get(0)[5].toString());
            this.JCB_Remitido_Municipio.setSelectedItem(listaInformacionaAnexoDos.get(0)[6].toString());
            this.JTPMotivoConsulta.setText(listaInformacionaAnexoDos.get(0)[10].toString());
            this.JTFCDxP.setText(listaInformacionaAnexoDos.get(0)[11].toString());
            this.JTFNCodigoDxP.setText(listaInformacionaAnexoDos.get(0)[12].toString());
            this.JTFCDxR1.setText(listaInformacionaAnexoDos.get(0)[13].toString());
            this.JTFNDxR1.setText(listaInformacionaAnexoDos.get(0)[14].toString());
            this.JTFCDxR2.setText(listaInformacionaAnexoDos.get(0)[15].toString());
            this.JTFNDxR2.setText(listaInformacionaAnexoDos.get(0)[16].toString());
            this.JTFCDxR3.setText(listaInformacionaAnexoDos.get(0)[17].toString());
            this.JTFNDxR3.setText(listaInformacionaAnexoDos.get(0)[18].toString());
            for (int x = 0; x < this.JPI_Destino.getComponentCount(); x++) {
                JCheckBox componente = this.JPI_Destino.getComponent(x);
                if (componente.getText().equals(listaInformacionaAnexoDos.get(0)[19].toString())) {
                    componente.setSelected(true);
                }
            }
            this.JCBEspecialidad.setSelectedItem(listaInformacionaAnexoDos.get(0)[23].toString());
            this.JCBProfesional.setSelectedItem(listaInformacionaAnexoDos.get(0)[22].toString());
            return;
        }
        List<Object[]> listaInformacionaAnexoDosAtencion = this.informacionAtencionAnexo2DAO.informacionHistoriaAtencionAnexo2FiltradaIdIngreso(this.idIngreso);
        if (!listaInformacionaAnexoDosAtencion.isEmpty()) {
            System.out.println("" + listaInformacionaAnexoDosAtencion.get(0)[0].toString());
            this.JDFecha.setDate(Date.valueOf(listaInformacionaAnexoDosAtencion.get(0)[0].toString()));
            this.JTFF_Hora.setText(listaInformacionaAnexoDosAtencion.get(0)[1].toString());
            if (null == Integer.valueOf(listaInformacionaAnexoDosAtencion.get(0)[2].toString())) {
                this.JCH_Tiage3.setSelected(true);
                this.triage = 3;
            } else {
                switch (Integer.valueOf(listaInformacionaAnexoDosAtencion.get(0)[2].toString()).intValue()) {
                    case 1:
                        this.JCH_Tiage1.setSelected(true);
                        this.triage = 1;
                        break;
                    case 2:
                        this.JCH_Tiage2.setSelected(true);
                        this.triage = 2;
                        break;
                    default:
                        this.JCH_Tiage3.setSelected(true);
                        this.triage = 3;
                        break;
                }
            }
            this.JTPMotivoConsulta.setText(listaInformacionaAnexoDosAtencion.get(0)[3].toString() + "\n\n" + listaInformacionaAnexoDosAtencion.get(0)[15].toString());
            this.JTFCDxP.setText(listaInformacionaAnexoDosAtencion.get(0)[4].toString());
            this.JTFNCodigoDxP.setText(listaInformacionaAnexoDosAtencion.get(0)[5].toString());
            this.JTFCDxR1.setText(listaInformacionaAnexoDosAtencion.get(0)[6].toString());
            this.JTFNDxR1.setText(listaInformacionaAnexoDosAtencion.get(0)[7].toString());
            this.JTFCDxR2.setText(listaInformacionaAnexoDosAtencion.get(0)[8].toString());
            this.JTFNDxR2.setText(listaInformacionaAnexoDosAtencion.get(0)[9].toString());
            this.JTFCDxR3.setText(listaInformacionaAnexoDosAtencion.get(0)[10].toString());
            this.JTFNDxR3.setText(listaInformacionaAnexoDosAtencion.get(0)[11].toString());
            this.JCBEspecialidad.setSelectedItem(listaInformacionaAnexoDosAtencion.get(0)[14].toString());
            this.JCBProfesional.setSelectedItem(listaInformacionaAnexoDosAtencion.get(0)[13].toString());
        }
    }

    public void grabar() {
        if (!this.JTPMotivoConsulta.getText().isEmpty()) {
            if (!this.JTFCDxP.getText().isEmpty() || !this.JTFNCodigoDxP.getText().isEmpty()) {
                if (this.JCH_Remitido_Si.isSelected()) {
                    if (!this.JTF_Remitido_Nombre_Prestador.getText().isEmpty()) {
                        if (!this.JTF_Remitido_CodigoPrestador.getText().isEmpty()) {
                            if (this.JCB_Remitido_Departamento.getSelectedIndex() != -1) {
                                if (this.JCB_Remitido_Municipio.getSelectedIndex() != -1) {
                                    accionGrabar();
                                    return;
                                }
                                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un departamento", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                                this.JTPDatos.setSelectedIndex(0);
                                this.JCB_Remitido_Municipio.requestFocus();
                                return;
                            }
                            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un departamento", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                            this.JTPDatos.setSelectedIndex(0);
                            this.JCB_Remitido_Departamento.requestFocus();
                            return;
                        }
                        JOptionPane.showInternalMessageDialog(this, "Nombre del prestador no puede ser nulo", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                        this.JTPDatos.setSelectedIndex(0);
                        this.JTF_Remitido_CodigoPrestador.requestFocus();
                        return;
                    }
                    JOptionPane.showInternalMessageDialog(this, "Nombre del prestador no puede ser nulo", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                    this.JTPDatos.setSelectedIndex(0);
                    this.JTF_Remitido_Nombre_Prestador.requestFocus();
                    return;
                }
                accionGrabar();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "El diagnóstico principal no puede ser nulo", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
            this.JTPDatos.setSelectedIndex(2);
            this.JTFCDxP.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Motivo de consulta no puede ser nula", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
        this.JTPDatos.setSelectedIndex(1);
        this.JTPMotivoConsulta.requestFocus();
    }

    public void imprimir() {
        ReporteAnexo2 x = new ReporteAnexo2(this.JLB_Id.getText(), 1);
        x.build();
        this.metodos.mostrarPdf(this.metodos.getRutaRep() + "H_Anexo2.pdf");
    }

    private void accionGrabar() {
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            AnexoDosDTO anexoDos = new AnexoDosDTO();
            anexoDos.setIdAtencion(Long.valueOf(this.idAtencion));
            anexoDos.setIdIngreso(Long.valueOf(this.idIngreso));
            anexoDos.setIdAteAnexo2(this.informacionAtencionAnexo2DAO.consultarConsecutivoFecha(this.metodos.formatoAMD1.format(this.JDFecha.getDate())));
            anexoDos.setFechaReporte(this.metodos.formatoAMD1.format(this.JDFecha.getDate()));
            anexoDos.setHoraReporte(this.JTFF_Hora.getText());
            anexoDos.setClasificacionTriage(this.triage);
            anexoDos.setDestino(this.destino);
            anexoDos.setMovitoConsulta(this.JTPMotivoConsulta.getText());
            anexoDos.setCodigoDxP(this.JTFCDxP.getText());
            anexoDos.setCodigoDxR1(this.JTFCDxR1.getText());
            anexoDos.setCodigoDxR2(this.JTFCDxR2.getText());
            anexoDos.setCodigoDxR3(this.JTFCDxR3.getText());
            anexoDos.setEsRemitido(this.esRemitido);
            anexoDos.setNombrePrestadorRemite(this.JTF_Remitido_Nombre_Prestador.getText());
            anexoDos.setCodigoPrestadorRemite(this.JTF_Remitido_CodigoPrestador.getText());
            anexoDos.setEstado(true);
            anexoDos.setFecha(this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()));
            anexoDos.setIdUsuarioRecursoHumano(Principal.usuarioSistemaDTO.getIdPersonaCargo());
            anexoDos.setIdRemoto(new Long(0L));
            anexoDos.setUsuarioSistema(Principal.usuarioSistemaDTO.getLogin());
            anexoDos.setIdProfesional(Long.valueOf(this.idProfesional[this.JCBProfesional.getSelectedIndex()]));
            anexoDos.setIdEspecialidad(Long.valueOf(this.idEspecialidad[this.JCBEspecialidad.getSelectedIndex()]));
            if (this.JCH_Remitido_Si.isSelected()) {
                anexoDos.setIdDepartamento(this.idDepartamento[this.JCB_Remitido_Departamento.getSelectedIndex()]);
                anexoDos.setIdMunicipio(this.idMunicipio[this.JCB_Remitido_Municipio.getSelectedIndex()]);
            }
            this.JLB_Id.setText("" + this.informacionAtencionAnexo2DAO.crear(anexoDos));
            consultarDatosAnexo();
        }
    }

    private void activarDesactivarCompomentesRemision(Boolean estado) {
        this.JTF_Remitido_Nombre_Prestador.setEnabled(estado.booleanValue());
        this.JTF_Remitido_CodigoPrestador.setEnabled(estado.booleanValue());
        this.JBBuscaTercero.setEnabled(estado.booleanValue());
        this.JCB_Remitido_Departamento.setEnabled(estado.booleanValue());
        this.JCB_Remitido_Municipio.setEnabled(estado.booleanValue());
    }
}
