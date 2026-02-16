package com.genoma.plus.controller.sgc;

import Acceso.Principal;
import Utilidades.Metodos;
import com.genoma.plus.controller.rrhh.JD_ConsultarUsuariosCargos;
import com.genoma.plus.dao.impl.sgc.SGC_ActasDAOImpl;
import com.genoma.plus.dao.impl.sgc.SGC_RegistroReunionesDAOImpl;
import com.genoma.plus.dao.sgc.SGC_ActasDAO;
import com.genoma.plus.dao.sgc.SGC_RegistoReunionesDAO;
import com.genoma.plus.dto.gcuenta.GCGenericoDTO;
import com.genoma.plus.dto.sgc.SGC_RegistroReuniones;
import com.genoma.plus.dto.sgc.SGC_RegistroReunionesIntegrantesDTO;
import com.genoma.plus.dto.sgc.SGC_RegistroReunionesObjetivosDTO;
import com.genoma.plus.dto.sgc.SGC_RegistroReunionesRecursosDTO;
import com.genoma.plus.dto.sgc.SGC_TipoRecurso_Reunion;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DateFormatter;
import javax.swing.text.DefaultFormatterFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/sgc/JIFRegistroReuniones.class */
public class JIFRegistroReuniones extends JInternalFrame {
    private SGC_ActasDAO xSGC_ActasDAO;
    private SGC_RegistoReunionesDAO xSGC_RegistroReunionesDAO;
    private Object[] xDato;
    private String[] xIdTipoReunion;
    public DefaultTableModel xModeloObjetivos;
    public DefaultTableModel xModeloIntegrantes;
    public DefaultTableModel xModeloHistorico;
    private DefaultTableModel xModeloRecursos;
    private ButtonGroup JBGIPersona;
    private ButtonGroup JBGOPersona;
    private JButton JBT_IAdicionarIntegrantes;
    private JButton JBT_IBuscarUsuario;
    private JButton JBT_OAdicionarObjetivos;
    private JButton JBT_OBuscarUsuario;
    private JComboBox JCBTipoReunion;
    public JDateChooser JDCHFechaF;
    public JDateChooser JDCHFechaI;
    public JFormattedTextField JFTFHoraF;
    public JFormattedTextField JFTFHoraI;
    private JLabel JLB_NRegistro;
    private JPanel JPI_DatosReunion;
    private JPanel JPI_IEncabezado;
    private JPanel JPI_Informacion;
    private JPanel JPI_Integrantes;
    private JPanel JPI_OEncabezado;
    private JPanel JPI_OObjetivos;
    private JPanel JPI_Recursos;
    private JPanel JP_OTipoPersona;
    private JPanel JP_OTipoPersona1;
    private JRadioButton JRB_IPersonaExterna;
    private JRadioButton JRB_IPersonaInterna;
    private JRadioButton JRB_OPersonaExterna;
    private JRadioButton JRB_OPersonaInterna;
    private JScrollPane JSPHistorico;
    private JScrollPane JSPObjetivo;
    private JScrollPane JSPObservacion;
    private JScrollPane JSP_DetalleObjetivos;
    private JScrollPane JSP_IDetalle;
    private JScrollPane JSP_OObjetivo;
    private JScrollPane JSP_RDetalle;
    private JTextPane JTAObjetivo;
    private JTextPane JTAObservacion;
    private JTextPane JTA_OObjetivo;
    private JTabbedPane JTB_Datos;
    private JTabbedPane JTB_Detalle;
    public JTable JTB_IDetalleIntegrantes;
    private JTable JTB_ODetalleObjetivos;
    private JTable JTB_RDetalleRecursos;
    public JTextField JTF_ICargo;
    public JTextField JTF_IEmail;
    public JTextField JTF_INombre;
    private JTextField JTF_Lugar;
    public JTextField JTF_OCargo;
    public JTextField JTF_ONombre;
    private JTable JTHistorico;
    private Metodos xmt = new Metodos();
    private Boolean xLleno = false;
    public long xIdPersonaRhObjetivos = 0;
    public long xIdPersonaRhIntegrante = 0;

    public JIFRegistroReuniones() {
        initComponents();
        springStart();
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v105, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v164, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v179, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v203, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGIPersona = new ButtonGroup();
        this.JBGOPersona = new ButtonGroup();
        this.JTB_Datos = new JTabbedPane();
        this.JPI_Informacion = new JPanel();
        this.JPI_DatosReunion = new JPanel();
        this.JDCHFechaI = new JDateChooser("dd/MM/yyyy", "##/##/####", '_');
        this.JFTFHoraI = new JFormattedTextField();
        this.JDCHFechaF = new JDateChooser("dd/MM/yyyy", "##/##/####", '_');
        this.JFTFHoraF = new JFormattedTextField();
        this.JTF_Lugar = new JTextField();
        this.JCBTipoReunion = new JComboBox();
        this.JSPObjetivo = new JScrollPane();
        this.JTAObjetivo = new JTextPane();
        this.JSPObservacion = new JScrollPane();
        this.JTAObservacion = new JTextPane();
        this.JLB_NRegistro = new JLabel();
        this.JTB_Detalle = new JTabbedPane();
        this.JPI_OObjetivos = new JPanel();
        this.JPI_OEncabezado = new JPanel();
        this.JSP_OObjetivo = new JScrollPane();
        this.JTA_OObjetivo = new JTextPane();
        this.JTF_OCargo = new JTextField();
        this.JTF_ONombre = new JTextField();
        this.JP_OTipoPersona = new JPanel();
        this.JRB_OPersonaInterna = new JRadioButton();
        this.JRB_OPersonaExterna = new JRadioButton();
        this.JBT_OBuscarUsuario = new JButton();
        this.JBT_OAdicionarObjetivos = new JButton();
        this.JSP_DetalleObjetivos = new JScrollPane();
        this.JTB_ODetalleObjetivos = new JTable();
        this.JPI_Integrantes = new JPanel();
        this.JPI_IEncabezado = new JPanel();
        this.JTF_ICargo = new JTextField();
        this.JTF_INombre = new JTextField();
        this.JP_OTipoPersona1 = new JPanel();
        this.JRB_IPersonaInterna = new JRadioButton();
        this.JRB_IPersonaExterna = new JRadioButton();
        this.JBT_IBuscarUsuario = new JButton();
        this.JBT_IAdicionarIntegrantes = new JButton();
        this.JTF_IEmail = new JTextField();
        this.JSP_IDetalle = new JScrollPane();
        this.JTB_IDetalleIntegrantes = new JTable();
        this.JPI_Recursos = new JPanel();
        this.JSP_RDetalle = new JScrollPane();
        this.JTB_RDetalleRecursos = new JTable();
        this.JSPHistorico = new JScrollPane();
        this.JTHistorico = new JTable();
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("REGISTRO DE REUNIONES");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setMinimumSize(new Dimension(824, 731));
        setName("xjifregistroreuniones");
        setPreferredSize(new Dimension(824, 731));
        this.JTB_Datos.setForeground(Color.red);
        this.JTB_Datos.setFont(new Font("Arial", 1, 14));
        this.JPI_DatosReunion.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS DE LA REUNIÓN", 0, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JDCHFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicial", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCHFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDCHFechaI.setFont(new Font("Arial", 1, 12));
        this.JFTFHoraI.setBorder(BorderFactory.createTitledBorder((Border) null, "Hora Inicial", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JFTFHoraI.setFormatterFactory(new DefaultFormatterFactory(new DateFormatter(new SimpleDateFormat("HH:mm:ss"))));
        this.JFTFHoraI.setFont(new Font("Tahoma", 1, 12));
        this.JDCHFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Final", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCHFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDCHFechaF.setFont(new Font("Arial", 1, 12));
        this.JFTFHoraF.setBorder(BorderFactory.createTitledBorder((Border) null, "Hora Final", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JFTFHoraF.setFormatterFactory(new DefaultFormatterFactory(new DateFormatter(new SimpleDateFormat("HH:mm:ss"))));
        this.JFTFHoraF.setFont(new Font("Tahoma", 1, 12));
        this.JTF_Lugar.setFont(new Font("Arial", 1, 12));
        this.JTF_Lugar.setBorder(BorderFactory.createTitledBorder((Border) null, "Lugar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTipoReunion.setFont(new Font("Arial", 1, 12));
        this.JCBTipoReunion.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo de Reunion", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPObjetivo.setBorder(BorderFactory.createTitledBorder((Border) null, "Objetivo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPObjetivo.setMinimumSize((Dimension) null);
        this.JTAObjetivo.setFont(new Font("Arial", 1, 12));
        this.JSPObjetivo.setViewportView(this.JTAObjetivo);
        this.JSPObservacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPObservacion.setMinimumSize((Dimension) null);
        this.JTAObservacion.setFont(new Font("Arial", 1, 12));
        this.JSPObservacion.setViewportView(this.JTAObservacion);
        this.JLB_NRegistro.setBackground(new Color(255, 255, 255));
        this.JLB_NRegistro.setFont(new Font("Arial", 1, 14));
        this.JLB_NRegistro.setForeground(Color.red);
        this.JLB_NRegistro.setHorizontalAlignment(0);
        this.JLB_NRegistro.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Registro", 2, 0, new Font("Arial", 1, 14), Color.blue));
        GroupLayout JPI_DatosReunionLayout = new GroupLayout(this.JPI_DatosReunion);
        this.JPI_DatosReunion.setLayout(JPI_DatosReunionLayout);
        JPI_DatosReunionLayout.setHorizontalGroup(JPI_DatosReunionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DatosReunionLayout.createSequentialGroup().addContainerGap().addGroup(JPI_DatosReunionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DatosReunionLayout.createSequentialGroup().addComponent(this.JDCHFechaI, -2, 110, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JFTFHoraI, -2, 110, -2).addGap(18, 18, 18).addComponent(this.JDCHFechaF, -2, 110, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JFTFHoraF, -2, 110, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JLB_NRegistro, -2, 146, -2)).addGroup(GroupLayout.Alignment.TRAILING, JPI_DatosReunionLayout.createSequentialGroup().addComponent(this.JSPObjetivo, -1, -1, 32767).addGap(18, 18, 18).addComponent(this.JSPObservacion, -2, 358, -2)).addGroup(GroupLayout.Alignment.TRAILING, JPI_DatosReunionLayout.createSequentialGroup().addComponent(this.JTF_Lugar).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBTipoReunion, -2, 379, -2))).addContainerGap()));
        JPI_DatosReunionLayout.setVerticalGroup(JPI_DatosReunionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DatosReunionLayout.createSequentialGroup().addContainerGap().addGroup(JPI_DatosReunionLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JDCHFechaF, -1, -1, 32767).addComponent(this.JFTFHoraF, -1, 50, 32767).addComponent(this.JDCHFechaI, -1, -1, 32767).addComponent(this.JFTFHoraI, -1, 50, 32767).addComponent(this.JLB_NRegistro, -1, -1, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPI_DatosReunionLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JCBTipoReunion, -2, 50, -2).addComponent(this.JTF_Lugar, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addGroup(JPI_DatosReunionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPObservacion, GroupLayout.Alignment.TRAILING, -2, 78, -2).addComponent(this.JSPObjetivo, GroupLayout.Alignment.TRAILING, -2, 78, -2)).addContainerGap()));
        this.JTB_Detalle.setForeground(new Color(0, 103, 0));
        this.JTB_Detalle.setFont(new Font("Arial", 1, 14));
        this.JTB_Detalle.setPreferredSize(new Dimension(824, 731));
        this.JSP_OObjetivo.setBorder(BorderFactory.createTitledBorder((Border) null, "Objetivo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSP_OObjetivo.setMinimumSize((Dimension) null);
        this.JTA_OObjetivo.setFont(new Font("Arial", 1, 12));
        this.JSP_OObjetivo.setViewportView(this.JTA_OObjetivo);
        this.JTF_OCargo.setFont(new Font("Arial", 1, 12));
        this.JTF_OCargo.setBorder(BorderFactory.createTitledBorder((Border) null, "Cargo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTF_ONombre.setFont(new Font("Arial", 1, 12));
        this.JTF_ONombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Persona Responsable", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTF_ONombre.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.sgc.JIFRegistroReuniones.1
            public void actionPerformed(ActionEvent evt) {
                JIFRegistroReuniones.this.JTF_ONombreActionPerformed(evt);
            }
        });
        this.JP_OTipoPersona.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Persona", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBGOPersona.add(this.JRB_OPersonaInterna);
        this.JRB_OPersonaInterna.setFont(new Font("Arial", 1, 12));
        this.JRB_OPersonaInterna.setSelected(true);
        this.JRB_OPersonaInterna.setText("Interna");
        this.JRB_OPersonaInterna.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.sgc.JIFRegistroReuniones.2
            public void actionPerformed(ActionEvent evt) {
                JIFRegistroReuniones.this.JRB_OPersonaInternaActionPerformed(evt);
            }
        });
        this.JBGOPersona.add(this.JRB_OPersonaExterna);
        this.JRB_OPersonaExterna.setFont(new Font("Arial", 1, 12));
        this.JRB_OPersonaExterna.setText("Externa");
        this.JRB_OPersonaExterna.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.sgc.JIFRegistroReuniones.3
            public void actionPerformed(ActionEvent evt) {
                JIFRegistroReuniones.this.JRB_OPersonaExternaActionPerformed(evt);
            }
        });
        GroupLayout JP_OTipoPersonaLayout = new GroupLayout(this.JP_OTipoPersona);
        this.JP_OTipoPersona.setLayout(JP_OTipoPersonaLayout);
        JP_OTipoPersonaLayout.setHorizontalGroup(JP_OTipoPersonaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JP_OTipoPersonaLayout.createSequentialGroup().addComponent(this.JRB_OPersonaInterna).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRB_OPersonaExterna)));
        JP_OTipoPersonaLayout.setVerticalGroup(JP_OTipoPersonaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JP_OTipoPersonaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRB_OPersonaInterna).addComponent(this.JRB_OPersonaExterna)));
        this.JBT_OBuscarUsuario.setFont(new Font("Arial", 1, 14));
        this.JBT_OBuscarUsuario.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Bueno.png")));
        this.JBT_OBuscarUsuario.setText("...");
        this.JBT_OBuscarUsuario.setToolTipText("Buscar usuarios en recurso humano");
        this.JBT_OBuscarUsuario.setIconTextGap(3);
        this.JBT_OBuscarUsuario.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.sgc.JIFRegistroReuniones.4
            public void actionPerformed(ActionEvent evt) {
                JIFRegistroReuniones.this.JBT_OBuscarUsuarioActionPerformed(evt);
            }
        });
        this.JBT_OAdicionarObjetivos.setFont(new Font("Arial", 1, 12));
        this.JBT_OAdicionarObjetivos.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBT_OAdicionarObjetivos.setText("Adicionar");
        this.JBT_OAdicionarObjetivos.setToolTipText("Adicionar al detalle");
        this.JBT_OAdicionarObjetivos.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.sgc.JIFRegistroReuniones.5
            public void actionPerformed(ActionEvent evt) {
                JIFRegistroReuniones.this.JBT_OAdicionarObjetivosActionPerformed(evt);
            }
        });
        GroupLayout JPI_OEncabezadoLayout = new GroupLayout(this.JPI_OEncabezado);
        this.JPI_OEncabezado.setLayout(JPI_OEncabezadoLayout);
        JPI_OEncabezadoLayout.setHorizontalGroup(JPI_OEncabezadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_OEncabezadoLayout.createSequentialGroup().addContainerGap().addGroup(JPI_OEncabezadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_OEncabezadoLayout.createSequentialGroup().addComponent(this.JSP_OObjetivo, -1, -1, 32767).addGap(56, 56, 56)).addGroup(GroupLayout.Alignment.TRAILING, JPI_OEncabezadoLayout.createSequentialGroup().addGroup(JPI_OEncabezadoLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JBT_OAdicionarObjetivos, GroupLayout.Alignment.LEADING, -1, -1, 32767).addGroup(JPI_OEncabezadoLayout.createSequentialGroup().addComponent(this.JP_OTipoPersona, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JTF_OCargo, -2, 229, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTF_ONombre, -2, 274, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBT_OBuscarUsuario, -2, 38, -2))).addGap(59, 59, 59)))));
        JPI_OEncabezadoLayout.setVerticalGroup(JPI_OEncabezadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_OEncabezadoLayout.createSequentialGroup().addContainerGap().addComponent(this.JSP_OObjetivo, -2, 61, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPI_OEncabezadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(JPI_OEncabezadoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTF_OCargo, -2, 50, -2).addComponent(this.JTF_ONombre, -2, 50, -2).addComponent(this.JBT_OBuscarUsuario, -2, 50, -2)).addComponent(this.JP_OTipoPersona, -2, -1, -2)).addGap(18, 18, 18).addComponent(this.JBT_OAdicionarObjetivos).addContainerGap(-1, 32767)));
        this.JSP_DetalleObjetivos.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTB_ODetalleObjetivos.setFont(new Font("Arial", 1, 12));
        this.JTB_ODetalleObjetivos.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTB_ODetalleObjetivos.setRowHeight(25);
        this.JTB_ODetalleObjetivos.setRowMargin(2);
        this.JTB_ODetalleObjetivos.setSelectionBackground(Color.white);
        this.JTB_ODetalleObjetivos.setSelectionForeground(Color.red);
        this.JTB_ODetalleObjetivos.setSelectionMode(0);
        this.JTB_ODetalleObjetivos.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.sgc.JIFRegistroReuniones.6
            public void keyPressed(KeyEvent evt) {
                JIFRegistroReuniones.this.JTB_ODetalleObjetivosKeyPressed(evt);
            }
        });
        this.JSP_DetalleObjetivos.setViewportView(this.JTB_ODetalleObjetivos);
        GroupLayout JPI_OObjetivosLayout = new GroupLayout(this.JPI_OObjetivos);
        this.JPI_OObjetivos.setLayout(JPI_OObjetivosLayout);
        JPI_OObjetivosLayout.setHorizontalGroup(JPI_OObjetivosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_OObjetivosLayout.createSequentialGroup().addContainerGap().addGroup(JPI_OObjetivosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPI_OEncabezado, -2, 738, 32767).addComponent(this.JSP_DetalleObjetivos, GroupLayout.Alignment.TRAILING)).addContainerGap()));
        JPI_OObjetivosLayout.setVerticalGroup(JPI_OObjetivosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_OObjetivosLayout.createSequentialGroup().addContainerGap().addComponent(this.JPI_OEncabezado, -2, 195, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSP_DetalleObjetivos, -2, 121, -2).addContainerGap()));
        this.JTB_Detalle.addTab("OBJETIVOS", this.JPI_OObjetivos);
        this.JTF_ICargo.setFont(new Font("Arial", 1, 12));
        this.JTF_ICargo.setBorder(BorderFactory.createTitledBorder((Border) null, "Cargo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTF_INombre.setFont(new Font("Arial", 1, 12));
        this.JTF_INombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JP_OTipoPersona1.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Persona", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBGIPersona.add(this.JRB_IPersonaInterna);
        this.JRB_IPersonaInterna.setFont(new Font("Arial", 1, 12));
        this.JRB_IPersonaInterna.setSelected(true);
        this.JRB_IPersonaInterna.setText("Interna");
        this.JRB_IPersonaInterna.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.sgc.JIFRegistroReuniones.7
            public void actionPerformed(ActionEvent evt) {
                JIFRegistroReuniones.this.JRB_IPersonaInternaActionPerformed(evt);
            }
        });
        this.JBGIPersona.add(this.JRB_IPersonaExterna);
        this.JRB_IPersonaExterna.setFont(new Font("Arial", 1, 12));
        this.JRB_IPersonaExterna.setText("Externa");
        this.JRB_IPersonaExterna.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.sgc.JIFRegistroReuniones.8
            public void actionPerformed(ActionEvent evt) {
                JIFRegistroReuniones.this.JRB_IPersonaExternaActionPerformed(evt);
            }
        });
        GroupLayout JP_OTipoPersona1Layout = new GroupLayout(this.JP_OTipoPersona1);
        this.JP_OTipoPersona1.setLayout(JP_OTipoPersona1Layout);
        JP_OTipoPersona1Layout.setHorizontalGroup(JP_OTipoPersona1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JP_OTipoPersona1Layout.createSequentialGroup().addComponent(this.JRB_IPersonaInterna).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRB_IPersonaExterna)));
        JP_OTipoPersona1Layout.setVerticalGroup(JP_OTipoPersona1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JP_OTipoPersona1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRB_IPersonaInterna).addComponent(this.JRB_IPersonaExterna)));
        this.JBT_IBuscarUsuario.setFont(new Font("Arial", 1, 14));
        this.JBT_IBuscarUsuario.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Bueno.png")));
        this.JBT_IBuscarUsuario.setText("...");
        this.JBT_IBuscarUsuario.setToolTipText("Buscar usuarios en recurso humano");
        this.JBT_IBuscarUsuario.setIconTextGap(3);
        this.JBT_IBuscarUsuario.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.sgc.JIFRegistroReuniones.9
            public void actionPerformed(ActionEvent evt) {
                JIFRegistroReuniones.this.JBT_IBuscarUsuarioActionPerformed(evt);
            }
        });
        this.JBT_IAdicionarIntegrantes.setFont(new Font("Arial", 1, 12));
        this.JBT_IAdicionarIntegrantes.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBT_IAdicionarIntegrantes.setText("Adicionar");
        this.JBT_IAdicionarIntegrantes.setToolTipText("Adicionar al detalle");
        this.JBT_IAdicionarIntegrantes.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.sgc.JIFRegistroReuniones.10
            public void actionPerformed(ActionEvent evt) {
                JIFRegistroReuniones.this.JBT_IAdicionarIntegrantesActionPerformed(evt);
            }
        });
        this.JTF_IEmail.setFont(new Font("Arial", 1, 12));
        this.JTF_IEmail.setBorder(BorderFactory.createTitledBorder((Border) null, "Correo Electrónico", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPI_IEncabezadoLayout = new GroupLayout(this.JPI_IEncabezado);
        this.JPI_IEncabezado.setLayout(JPI_IEncabezadoLayout);
        JPI_IEncabezadoLayout.setHorizontalGroup(JPI_IEncabezadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPI_IEncabezadoLayout.createSequentialGroup().addContainerGap().addGroup(JPI_IEncabezadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_IEncabezadoLayout.createSequentialGroup().addComponent(this.JTF_IEmail, -2, 274, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBT_IAdicionarIntegrantes, -1, -1, 32767)).addGroup(JPI_IEncabezadoLayout.createSequentialGroup().addComponent(this.JP_OTipoPersona1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JTF_ICargo, -2, 229, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTF_INombre, -2, 262, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBT_IBuscarUsuario, -2, 51, -2)))));
        JPI_IEncabezadoLayout.setVerticalGroup(JPI_IEncabezadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_IEncabezadoLayout.createSequentialGroup().addGroup(JPI_IEncabezadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_IEncabezadoLayout.createSequentialGroup().addGap(12, 12, 12).addGroup(JPI_IEncabezadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(JPI_IEncabezadoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTF_ICargo, -2, 50, -2).addComponent(this.JTF_INombre, -2, 50, -2)).addComponent(this.JP_OTipoPersona1, -2, -1, -2))).addGroup(GroupLayout.Alignment.TRAILING, JPI_IEncabezadoLayout.createSequentialGroup().addContainerGap().addComponent(this.JBT_IBuscarUsuario, -2, 50, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPI_IEncabezadoLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JTF_IEmail, -2, 50, -2).addComponent(this.JBT_IAdicionarIntegrantes, -2, 50, -2)).addContainerGap(-1, 32767)));
        this.JSP_IDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTB_IDetalleIntegrantes.setFont(new Font("Arial", 1, 12));
        this.JTB_IDetalleIntegrantes.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTB_IDetalleIntegrantes.setRowHeight(25);
        this.JTB_IDetalleIntegrantes.setRowMargin(2);
        this.JTB_IDetalleIntegrantes.setSelectionBackground(Color.white);
        this.JTB_IDetalleIntegrantes.setSelectionForeground(Color.red);
        this.JTB_IDetalleIntegrantes.setSelectionMode(0);
        this.JTB_IDetalleIntegrantes.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.sgc.JIFRegistroReuniones.11
            public void keyPressed(KeyEvent evt) {
                JIFRegistroReuniones.this.JTB_IDetalleIntegrantesKeyPressed(evt);
            }
        });
        this.JSP_IDetalle.setViewportView(this.JTB_IDetalleIntegrantes);
        GroupLayout JPI_IntegrantesLayout = new GroupLayout(this.JPI_Integrantes);
        this.JPI_Integrantes.setLayout(JPI_IntegrantesLayout);
        JPI_IntegrantesLayout.setHorizontalGroup(JPI_IntegrantesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_IntegrantesLayout.createSequentialGroup().addContainerGap().addGroup(JPI_IntegrantesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSP_IDetalle).addComponent(this.JPI_IEncabezado, -1, -1, 32767)).addContainerGap()));
        JPI_IntegrantesLayout.setVerticalGroup(JPI_IntegrantesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPI_IntegrantesLayout.createSequentialGroup().addComponent(this.JPI_IEncabezado, -2, 124, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSP_IDetalle, -1, 199, 32767).addContainerGap()));
        this.JTB_Detalle.addTab("INTEGRANTES", this.JPI_Integrantes);
        this.JSP_RDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTB_RDetalleRecursos.setFont(new Font("Arial", 1, 12));
        this.JTB_RDetalleRecursos.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTB_RDetalleRecursos.setRowHeight(25);
        this.JTB_RDetalleRecursos.setRowMargin(2);
        this.JTB_RDetalleRecursos.setSelectionBackground(Color.white);
        this.JTB_RDetalleRecursos.setSelectionForeground(Color.red);
        this.JTB_RDetalleRecursos.setSelectionMode(0);
        this.JTB_RDetalleRecursos.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.sgc.JIFRegistroReuniones.12
            public void mouseClicked(MouseEvent evt) {
                JIFRegistroReuniones.this.JTB_RDetalleRecursosMouseClicked(evt);
            }
        });
        this.JTB_RDetalleRecursos.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.sgc.JIFRegistroReuniones.13
            public void keyPressed(KeyEvent evt) {
                JIFRegistroReuniones.this.JTB_RDetalleRecursosKeyPressed(evt);
            }
        });
        this.JSP_RDetalle.setViewportView(this.JTB_RDetalleRecursos);
        GroupLayout JPI_RecursosLayout = new GroupLayout(this.JPI_Recursos);
        this.JPI_Recursos.setLayout(JPI_RecursosLayout);
        JPI_RecursosLayout.setHorizontalGroup(JPI_RecursosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPI_RecursosLayout.createSequentialGroup().addContainerGap().addComponent(this.JSP_RDetalle, -1, 738, 32767).addContainerGap()));
        JPI_RecursosLayout.setVerticalGroup(JPI_RecursosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPI_RecursosLayout.createSequentialGroup().addContainerGap().addComponent(this.JSP_RDetalle, -1, 323, 32767).addContainerGap()));
        this.JTB_Detalle.addTab("RECURSOS", this.JPI_Recursos);
        GroupLayout JPI_InformacionLayout = new GroupLayout(this.JPI_Informacion);
        this.JPI_Informacion.setLayout(JPI_InformacionLayout);
        JPI_InformacionLayout.setHorizontalGroup(JPI_InformacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_InformacionLayout.createSequentialGroup().addContainerGap().addGroup(JPI_InformacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPI_DatosReunion, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addComponent(this.JTB_Detalle, -1, -1, 32767)).addContainerGap()));
        JPI_InformacionLayout.setVerticalGroup(JPI_InformacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_InformacionLayout.createSequentialGroup().addContainerGap().addComponent(this.JPI_DatosReunion, -2, -1, -2).addGap(18, 18, 18).addComponent(this.JTB_Detalle, -1, -1, 32767).addContainerGap()));
        this.JTB_Datos.addTab("INFORMACIÓN", this.JPI_Informacion);
        this.JTHistorico.setFont(new Font("Arial", 1, 12));
        this.JTHistorico.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTHistorico.setSelectionBackground(Color.white);
        this.JTHistorico.setSelectionForeground(Color.red);
        this.JTHistorico.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.sgc.JIFRegistroReuniones.14
            public void mouseClicked(MouseEvent evt) {
                JIFRegistroReuniones.this.JTHistoricoMouseClicked(evt);
            }
        });
        this.JSPHistorico.setViewportView(this.JTHistorico);
        this.JTB_Datos.addTab("HISTÓRICO", this.JSPHistorico);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTB_Datos).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTB_Datos).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_OPersonaInternaActionPerformed(ActionEvent evt) {
        this.JTF_ONombre.setText("");
        this.JTF_OCargo.setText("");
        this.JTF_ONombre.setEnabled(false);
        this.JTF_OCargo.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_OPersonaExternaActionPerformed(ActionEvent evt) {
        this.xIdPersonaRhObjetivos = 0L;
        this.JTF_ONombre.setText("");
        this.JTF_OCargo.setText("");
        this.JTF_ONombre.setEnabled(true);
        this.JTF_OCargo.setEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_OAdicionarObjetivosActionPerformed(ActionEvent evt) {
        if (!this.JTA_OObjetivo.getText().isEmpty()) {
            if (!this.JTF_OCargo.getText().isEmpty()) {
                if (!this.JTF_ONombre.getText().isEmpty()) {
                    this.xDato = new Object[4];
                    this.xDato[0] = this.JTA_OObjetivo.getText();
                    this.xDato[1] = this.JTF_OCargo.getText();
                    this.xDato[2] = this.JTF_ONombre.getText();
                    this.xDato[3] = Long.valueOf(this.xIdPersonaRhObjetivos);
                    this.xModeloObjetivos.addRow(this.xDato);
                    this.xmt.mEstablecerTextEditor(this.JTB_ODetalleObjetivos, 0);
                    this.xmt.mEstablecerTextEditor(this.JTB_ODetalleObjetivos, 1);
                    this.xmt.mEstablecerTextEditor(this.JTB_ODetalleObjetivos, 2);
                    mNuevoObjetivo();
                    this.JTA_OObjetivo.requestFocus();
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "El nombre de la persona responsable no puede estar en blanco", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                this.JTF_ONombre.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "El cargo no puede estar en blanco", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            this.JTF_OCargo.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Objetivo no puede estar en blanco", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        this.JTA_OObjetivo.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_OBuscarUsuarioActionPerformed(ActionEvent evt) {
        if (this.JRB_OPersonaInterna.isSelected()) {
            JD_ConsultarUsuariosCargos xJDConsultar = new JD_ConsultarUsuariosCargos(null, true, "xJifReunionP1", this);
            xJDConsultar.setVisible(true);
            xJDConsultar.setLocationRelativeTo(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTB_ODetalleObjetivosKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 127 && this.JTB_ODetalleObjetivos.getSelectedRow() != -1) {
            int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de eliminar la fila seleccionada", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                this.xModeloObjetivos.removeRow(this.JTB_ODetalleObjetivos.getSelectedRow());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTB_IDetalleIntegrantesKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 127 && this.JTB_IDetalleIntegrantes.getSelectedRow() != -1) {
            int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de eliminar la fila seleccionada", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                this.xModeloIntegrantes.removeRow(this.JTB_IDetalleIntegrantes.getSelectedRow());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_IPersonaInternaActionPerformed(ActionEvent evt) {
        this.JTF_INombre.setText("");
        this.JTF_ICargo.setText("");
        this.JTF_IEmail.setText("");
        this.JTF_INombre.setEnabled(false);
        this.JTF_ICargo.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_IPersonaExternaActionPerformed(ActionEvent evt) {
        this.xIdPersonaRhIntegrante = 0L;
        this.JTF_INombre.setText("");
        this.JTF_ICargo.setText("");
        this.JTF_IEmail.setText("");
        this.JTF_INombre.setEnabled(true);
        this.JTF_ICargo.setEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_IBuscarUsuarioActionPerformed(ActionEvent evt) {
        if (this.JRB_OPersonaInterna.isSelected()) {
            JD_ConsultarUsuariosCargos xJDConsultar = new JD_ConsultarUsuariosCargos(null, true, "xJifReunionP2", this);
            xJDConsultar.setVisible(true);
            xJDConsultar.setLocationRelativeTo(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_IAdicionarIntegrantesActionPerformed(ActionEvent evt) {
        if (!this.JTF_ICargo.getText().isEmpty()) {
            if (!this.JTF_INombre.getText().isEmpty()) {
                this.xDato = new Object[4];
                this.xDato[0] = Long.valueOf(this.xIdPersonaRhIntegrante);
                this.xDato[1] = this.JTF_ICargo.getText();
                this.xDato[2] = this.JTF_INombre.getText();
                this.xDato[3] = this.JTF_IEmail.getText();
                this.xModeloIntegrantes.addRow(this.xDato);
                this.xmt.mEstablecerTextEditor(this.JTB_IDetalleIntegrantes, 1);
                this.xmt.mEstablecerTextEditor(this.JTB_IDetalleIntegrantes, 2);
                mNuevoIntegrante();
                this.JTF_ICargo.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "El nombre de la persona no puede estar en blanco", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            this.JTF_INombre.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "El cargo no puede estar en blanco", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        this.JTF_ICargo.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTB_RDetalleRecursosKeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTF_ONombreActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTB_RDetalleRecursosMouseClicked(MouseEvent evt) {
        if (this.JTB_RDetalleRecursos.getSelectedRow() != -1 && this.JTB_RDetalleRecursos.getSelectedColumn() == 0 && Boolean.valueOf(this.xModeloRecursos.getValueAt(this.JTB_RDetalleRecursos.getSelectedRow(), 6).toString()).booleanValue()) {
            List<Object[]> list = this.xSGC_RegistroReunionesDAO.listTipoRecursos_Utilizados(0, this.xmt.formatoAMD.format(this.JDCHFechaI.getDate()), Long.valueOf(this.xModeloRecursos.getValueAt(this.JTB_RDetalleRecursos.getSelectedRow(), 1).toString()));
            if (!list.isEmpty()) {
                JOptionPane.showInternalMessageDialog(this, "Este recurso ya se encuentra recervado para ese dia", "VERIFICACION", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                this.xModeloRecursos.setValueAt(false, this.JTB_RDetalleRecursos.getSelectedRow(), 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTHistoricoMouseClicked(MouseEvent evt) {
        if (this.JTHistorico.getSelectedRow() != -1) {
            this.JLB_NRegistro.setText(this.xModeloHistorico.getValueAt(this.JTHistorico.getSelectedRow(), 0).toString());
            this.JDCHFechaI.setDate(Date.valueOf(this.xModeloHistorico.getValueAt(this.JTHistorico.getSelectedRow(), 1).toString()));
            this.JFTFHoraI.setText(this.xModeloHistorico.getValueAt(this.JTHistorico.getSelectedRow(), 2).toString());
            this.JDCHFechaF.setDate(Date.valueOf(this.xModeloHistorico.getValueAt(this.JTHistorico.getSelectedRow(), 3).toString()));
            this.JFTFHoraF.setText(this.xModeloHistorico.getValueAt(this.JTHistorico.getSelectedRow(), 4).toString());
            this.JCBTipoReunion.setSelectedItem(this.xModeloHistorico.getValueAt(this.JTHistorico.getSelectedRow(), 5).toString());
            this.JTF_Lugar.setText(this.xModeloHistorico.getValueAt(this.JTHistorico.getSelectedRow(), 6).toString());
            this.JTAObjetivo.setText(this.xModeloHistorico.getValueAt(this.JTHistorico.getSelectedRow(), 7).toString());
            this.JTAObservacion.setText(this.xModeloHistorico.getValueAt(this.JTHistorico.getSelectedRow(), 8).toString());
            mCargarDatosObjetivos(this.JLB_NRegistro.getText());
            mCargarDatosIntegrantes(this.JLB_NRegistro.getText());
            mCargarDatosRecursosGrabados(this.JLB_NRegistro.getText());
            this.JTB_Datos.setSelectedIndex(0);
        }
    }

    private void springStart() {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"});
        this.xSGC_ActasDAO = (SGC_ActasDAOImpl) classPathXmlApplicationContext.getBean("sGCActasDAO");
        this.xSGC_RegistroReunionesDAO = (SGC_RegistroReunionesDAOImpl) classPathXmlApplicationContext.getBean("sGCRegistroReunionesDAO");
    }

    public void mNuevo() {
        this.JLB_NRegistro.setText("");
        this.JDCHFechaI.setDate(this.xmt.getFechaActual());
        this.JFTFHoraI.setValue(this.xmt.getFechaActual());
        this.JDCHFechaF.setDate(this.xmt.getFechaActual());
        this.JFTFHoraF.setValue(this.xmt.getFechaActual());
        this.JTF_Lugar.setText("");
        this.JTAObjetivo.setText("");
        this.JTAObservacion.setText("");
        JRB_OPersonaInternaActionPerformed(null);
        JRB_IPersonaInternaActionPerformed(null);
        mLLenaCombo();
        mCargarDatosHistorico();
        mCrearModeloObjetivos();
        mCrearModeloIntegrantes();
        mCargarDatosRecursos();
    }

    private void mNuevoObjetivo() {
        this.xIdPersonaRhObjetivos = 0L;
        this.JRB_OPersonaInterna.setSelected(true);
        this.JTA_OObjetivo.setText("");
        this.JTF_OCargo.setText("");
        this.JTF_ONombre.setText("");
    }

    public void mNuevoIntegrante() {
        this.xIdPersonaRhIntegrante = 0L;
        this.JRB_IPersonaInterna.setSelected(true);
        this.JTF_ICargo.setText("");
        this.JTF_INombre.setText("");
        this.JTF_IEmail.setText("");
    }

    private void mLLenaCombo() {
        this.xLleno = false;
        this.JCBTipoReunion.removeAllItems();
        List<GCGenericoDTO> listiporeunion = this.xSGC_ActasDAO.listTipoReunion();
        this.xIdTipoReunion = new String[listiporeunion.size()];
        for (int x = 0; x < listiporeunion.size(); x++) {
            this.xIdTipoReunion[x] = String.valueOf(listiporeunion.get(x).getId());
            this.JCBTipoReunion.addItem(listiporeunion.get(x).getNombre());
        }
        this.JCBTipoReunion.setSelectedIndex(-1);
        this.xLleno = true;
    }

    private void mCrearModeloObjetivos() {
        this.xModeloObjetivos = new DefaultTableModel((Object[][]) null, new String[]{"Objetivo", "Cargo", "Persona Responsable", "IdUsuarioRh"}) { // from class: com.genoma.plus.controller.sgc.JIFRegistroReuniones.15
            Class[] types = {String.class, String.class, String.class, Long.class};
            boolean[] canEdit = {false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTB_ODetalleObjetivos;
        JTable jTable2 = this.JTB_ODetalleObjetivos;
        jTable.setAutoResizeMode(0);
        this.JTB_ODetalleObjetivos.doLayout();
        this.JTB_ODetalleObjetivos.setModel(this.xModeloObjetivos);
        this.JTB_ODetalleObjetivos.getColumnModel().getColumn(0).setPreferredWidth(400);
        this.JTB_ODetalleObjetivos.getColumnModel().getColumn(1).setPreferredWidth(200);
        this.JTB_ODetalleObjetivos.getColumnModel().getColumn(2).setPreferredWidth(300);
        this.JTB_ODetalleObjetivos.getColumnModel().getColumn(3).setPreferredWidth(0);
        this.JTB_ODetalleObjetivos.getColumnModel().getColumn(3).setMinWidth(0);
        this.JTB_ODetalleObjetivos.getColumnModel().getColumn(3).setMaxWidth(0);
    }

    private void mCargarDatosObjetivos(String idReunion) {
        List<SGC_RegistroReunionesObjetivosDTO> listObjetivos = this.xSGC_RegistroReunionesDAO.listObjetivos(idReunion);
        mCrearModeloRecursos();
        if (!listObjetivos.isEmpty()) {
            for (int x = 0; x < listObjetivos.size(); x++) {
                this.xModeloObjetivos.addRow(this.xDato);
                this.xModeloObjetivos.setValueAt(listObjetivos.get(x).getObjetivoE(), x, 0);
                this.xModeloObjetivos.setValueAt(listObjetivos.get(x).getNCargo(), x, 1);
                this.xModeloObjetivos.setValueAt(listObjetivos.get(x).getNUsuario(), x, 2);
                this.xModeloObjetivos.setValueAt(listObjetivos.get(x).getIdUsuarioRH(), x, 3);
            }
        }
    }

    private void mCrearModeloIntegrantes() {
        this.xModeloIntegrantes = new DefaultTableModel((Object[][]) null, new String[]{"IdRh", "Cargo", "Persona", "Email"}) { // from class: com.genoma.plus.controller.sgc.JIFRegistroReuniones.16
            Class[] types = {Long.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTB_IDetalleIntegrantes;
        JTable jTable2 = this.JTB_IDetalleIntegrantes;
        jTable.setAutoResizeMode(0);
        this.JTB_IDetalleIntegrantes.doLayout();
        this.JTB_IDetalleIntegrantes.setModel(this.xModeloIntegrantes);
        this.JTB_IDetalleIntegrantes.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTB_IDetalleIntegrantes.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTB_IDetalleIntegrantes.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTB_IDetalleIntegrantes.getColumnModel().getColumn(1).setPreferredWidth(200);
        this.JTB_IDetalleIntegrantes.getColumnModel().getColumn(2).setPreferredWidth(400);
        this.JTB_IDetalleIntegrantes.getColumnModel().getColumn(3).setPreferredWidth(200);
    }

    private void mCargarDatosIntegrantes(String idReunion) {
        List<SGC_RegistroReunionesIntegrantesDTO> listIntegrantes = this.xSGC_RegistroReunionesDAO.listIntegrantes(idReunion);
        mCrearModeloRecursos();
        if (!listIntegrantes.isEmpty()) {
            for (int x = 0; x < listIntegrantes.size(); x++) {
                this.xModeloIntegrantes.addRow(this.xDato);
                this.xModeloIntegrantes.setValueAt(listIntegrantes.get(x).getIdUsuarioRH(), x, 0);
                this.xModeloIntegrantes.setValueAt(listIntegrantes.get(x).getNCargo(), x, 1);
                this.xModeloIntegrantes.setValueAt(listIntegrantes.get(x).getNUsuario(), x, 2);
                this.xModeloIntegrantes.setValueAt(listIntegrantes.get(x).getCorreo(), x, 3);
            }
        }
    }

    private void mCrearModeloRecursos() {
        this.xModeloRecursos = new DefaultTableModel((Object[][]) null, new String[]{"Aplica?", "Id", "Nombre", "Cant.", "Observacion", "Email", "Control"}) { // from class: com.genoma.plus.controller.sgc.JIFRegistroReuniones.17
            Class[] types = {Boolean.class, Long.class, String.class, Long.class, String.class, String.class, Boolean.class};
            boolean[] canEdit = {true, false, false, true, true, true, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTB_RDetalleRecursos;
        JTable jTable2 = this.JTB_RDetalleRecursos;
        jTable.setAutoResizeMode(0);
        this.JTB_RDetalleRecursos.doLayout();
        this.JTB_RDetalleRecursos.setModel(this.xModeloRecursos);
        this.JTB_RDetalleRecursos.getColumnModel().getColumn(0).setPreferredWidth(50);
        this.JTB_RDetalleRecursos.getColumnModel().getColumn(1).setPreferredWidth(0);
        this.JTB_RDetalleRecursos.getColumnModel().getColumn(1).setMinWidth(0);
        this.JTB_RDetalleRecursos.getColumnModel().getColumn(1).setMaxWidth(0);
        this.JTB_RDetalleRecursos.getColumnModel().getColumn(2).setPreferredWidth(200);
        this.JTB_RDetalleRecursos.getColumnModel().getColumn(3).setPreferredWidth(50);
        this.JTB_RDetalleRecursos.getColumnModel().getColumn(4).setPreferredWidth(300);
        this.JTB_RDetalleRecursos.getColumnModel().getColumn(5).setPreferredWidth(200);
        this.JTB_RDetalleRecursos.getColumnModel().getColumn(6).setPreferredWidth(50);
    }

    private void mCargarDatosRecursos() {
        List<SGC_TipoRecurso_Reunion> listTipoReunion = this.xSGC_RegistroReunionesDAO.listTipoRecursos();
        mCrearModeloRecursos();
        if (!listTipoReunion.isEmpty()) {
            for (int x = 0; x < listTipoReunion.size(); x++) {
                this.xModeloRecursos.addRow(this.xDato);
                this.xModeloRecursos.setValueAt(false, x, 0);
                this.xModeloRecursos.setValueAt(Integer.valueOf(listTipoReunion.get(x).getId()), x, 1);
                this.xModeloRecursos.setValueAt(listTipoReunion.get(x).getNombre(), x, 2);
                this.xModeloRecursos.setValueAt(1, x, 3);
                this.xModeloRecursos.setValueAt("", x, 4);
                this.xModeloRecursos.setValueAt(listTipoReunion.get(x).getEmail(), x, 5);
                this.xModeloRecursos.setValueAt(listTipoReunion.get(x).getControl(), x, 6);
            }
        }
    }

    private void mCargarDatosRecursosGrabados(String idReunion) {
        List<SGC_RegistroReunionesRecursosDTO> listRecurso = this.xSGC_RegistroReunionesDAO.listRecursos(idReunion);
        mCrearModeloRecursos();
        if (!listRecurso.isEmpty()) {
            for (int x = 0; x < listRecurso.size(); x++) {
                this.xModeloRecursos.addRow(this.xDato);
                this.xModeloRecursos.setValueAt(true, x, 0);
                this.xModeloRecursos.setValueAt(listRecurso.get(x).getIdRecurso(), x, 1);
                this.xModeloRecursos.setValueAt(listRecurso.get(x).getNRecurso(), x, 2);
                this.xModeloRecursos.setValueAt(1, x, 3);
                this.xModeloRecursos.setValueAt(listRecurso.get(x).getObservacion(), x, 4);
                this.xModeloRecursos.setValueAt(listRecurso.get(x).getEmail(), x, 5);
                if (listRecurso.get(x).getControl() == 1) {
                    this.xModeloRecursos.setValueAt(true, x, 6);
                } else {
                    this.xModeloRecursos.setValueAt(false, x, 6);
                }
            }
        }
    }

    private void mCrearModeloHistorico() {
        this.xModeloHistorico = new DefaultTableModel((Object[][]) null, new String[]{"Id", "FechaI", "HoraI", "FechaF", "HoraF", "Tipo Reunion", "Lugar", "Objetivo", "Observacion"}) { // from class: com.genoma.plus.controller.sgc.JIFRegistroReuniones.18
            Class[] types = {Long.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTHistorico;
        JTable jTable2 = this.JTB_RDetalleRecursos;
        jTable.setAutoResizeMode(0);
        this.JTHistorico.doLayout();
        this.JTHistorico.setModel(this.xModeloHistorico);
        this.JTHistorico.getColumnModel().getColumn(0).setPreferredWidth(80);
        this.JTHistorico.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTHistorico.getColumnModel().getColumn(2).setPreferredWidth(80);
        this.JTHistorico.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTHistorico.getColumnModel().getColumn(4).setPreferredWidth(80);
        this.JTHistorico.getColumnModel().getColumn(5).setPreferredWidth(200);
        this.JTHistorico.getColumnModel().getColumn(6).setPreferredWidth(200);
        this.JTHistorico.getColumnModel().getColumn(7).setPreferredWidth(0);
        this.JTHistorico.getColumnModel().getColumn(7).setMinWidth(0);
        this.JTHistorico.getColumnModel().getColumn(7).setMaxWidth(0);
        this.JTHistorico.getColumnModel().getColumn(8).setPreferredWidth(0);
        this.JTHistorico.getColumnModel().getColumn(8).setMinWidth(0);
        this.JTHistorico.getColumnModel().getColumn(8).setMaxWidth(0);
    }

    private void mCargarDatosHistorico() {
        List<SGC_RegistroReuniones> listReunion = this.xSGC_RegistroReunionesDAO.listReuniones();
        mCrearModeloHistorico();
        if (!listReunion.isEmpty()) {
            for (int x = 0; x < listReunion.size(); x++) {
                this.xModeloHistorico.addRow(this.xDato);
                this.xModeloHistorico.setValueAt(Long.valueOf(listReunion.get(x).getIdReunion()), x, 0);
                this.xModeloHistorico.setValueAt(listReunion.get(x).getFechaInicial(), x, 1);
                this.xModeloHistorico.setValueAt(listReunion.get(x).getHoraIncial(), x, 2);
                this.xModeloHistorico.setValueAt(listReunion.get(x).getFechaFinal(), x, 3);
                this.xModeloHistorico.setValueAt(listReunion.get(x).getHoraFinal(), x, 4);
                this.xModeloHistorico.setValueAt(listReunion.get(x).getIdTipoReunion(), x, 5);
                this.xModeloHistorico.setValueAt(listReunion.get(x).getLugar(), x, 6);
                this.xModeloHistorico.setValueAt(listReunion.get(x).getObjetivo(), x, 7);
                this.xModeloHistorico.setValueAt(listReunion.get(x).getObservacion(), x, 8);
            }
        }
    }

    public void mGrabar() {
        if (this.JLB_NRegistro.getText().isEmpty()) {
            if (this.JCBTipoReunion.getSelectedIndex() != -1) {
                if (!this.JTF_Lugar.getText().isEmpty()) {
                    if (!this.JTAObjetivo.getText().isEmpty()) {
                        if (this.JTB_ODetalleObjetivos.getRowCount() != -1) {
                            if (this.JTB_IDetalleIntegrantes.getRowCount() != -1) {
                                int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                                if (n == 0) {
                                    mGrabaReunion();
                                    mCargarDatosHistorico();
                                    return;
                                }
                                return;
                            }
                            JOptionPane.showInternalMessageDialog(this, "No existe integrante registrado", "VERIFICACION", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                            this.JTB_Detalle.setSelectedIndex(1);
                            this.JTB_IDetalleIntegrantes.requestFocus();
                            return;
                        }
                        JOptionPane.showInternalMessageDialog(this, "No existe objetivo registrado", "VERIFICACION", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                        this.JTB_Detalle.setSelectedIndex(0);
                        this.JTB_ODetalleObjetivos.requestFocus();
                        return;
                    }
                    JOptionPane.showInternalMessageDialog(this, "El sitio de la reunion no puede estas en blanco", "VERIFICACION", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    this.JTAObjetivo.requestFocus();
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "El sitio de la reunion no puede estas en blanco", "VERIFICACION", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                this.JTF_Lugar.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un tipo de reunion", "VERIFICACION", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            this.JCBTipoReunion.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Esta reunion ya se encuentra grabada", "VERIFICACION", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        this.JCBTipoReunion.requestFocus();
    }

    @Transactional(value = "transactionManager", propagation = Propagation.SUPPORTS, readOnly = true)
    public void mGrabaReunion() {
        SGC_RegistroReuniones xObjEncabezado = new SGC_RegistroReuniones();
        xObjEncabezado.setIdTipoReunion(this.xIdTipoReunion[this.JCBTipoReunion.getSelectedIndex()]);
        xObjEncabezado.setFechaInicial(this.xmt.formatoAMD.format(this.JDCHFechaI.getDate()));
        xObjEncabezado.setHoraIncial(this.xmt.formatoH24.format(this.JFTFHoraI.getValue()));
        xObjEncabezado.setFechaFinal(this.xmt.formatoAMD.format(this.JDCHFechaF.getDate()));
        xObjEncabezado.setHoraFinal(this.xmt.formatoH24.format(this.JFTFHoraF.getValue()));
        xObjEncabezado.setLugar(this.JTF_Lugar.getText());
        xObjEncabezado.setObjetivo(this.JTAObjetivo.getText());
        xObjEncabezado.setObservacion(this.JTAObservacion.getText());
        String xIdEncabezado = this.xSGC_RegistroReunionesDAO.create_return_id(xObjEncabezado);
        this.JLB_NRegistro.setText(xIdEncabezado);
        SGC_RegistroReunionesObjetivosDTO xObjetivos = new SGC_RegistroReunionesObjetivosDTO();
        for (int x = 0; x < this.JTB_ODetalleObjetivos.getRowCount(); x++) {
            xObjetivos.setIdRegistroR(Long.valueOf(xIdEncabezado));
            xObjetivos.setIdUsuarioRH(Long.valueOf(this.xModeloObjetivos.getValueAt(x, 3).toString()));
            xObjetivos.setObjetivoE(this.xModeloObjetivos.getValueAt(x, 0).toString());
            xObjetivos.setNUsuario(this.xModeloObjetivos.getValueAt(x, 2).toString());
            xObjetivos.setNCargo(this.xModeloObjetivos.getValueAt(x, 1).toString());
            this.xSGC_RegistroReunionesDAO.create_objetivo(xObjetivos);
        }
        SGC_RegistroReunionesIntegrantesDTO xIntegrantes = new SGC_RegistroReunionesIntegrantesDTO();
        for (int x2 = 0; x2 < this.JTB_IDetalleIntegrantes.getRowCount(); x2++) {
            xIntegrantes.setIdRegistroR(Long.valueOf(xIdEncabezado));
            xIntegrantes.setIdUsuarioRH(Long.valueOf(this.xModeloIntegrantes.getValueAt(x2, 0).toString()));
            xIntegrantes.setNUsuario(this.xModeloIntegrantes.getValueAt(x2, 2).toString());
            xIntegrantes.setNCargo(this.xModeloIntegrantes.getValueAt(x2, 1).toString());
            this.xSGC_RegistroReunionesDAO.create_integrante(xIntegrantes);
            if (!this.xModeloIntegrantes.getValueAt(x2, 3).toString().isEmpty()) {
                this.xmt.mEnvioCorreoElectronico("", this.xModeloIntegrantes.getValueAt(x2, 3).toString(), "SEGURIDAD CLINICA - REPORTE DE CASO Nº ", Principal.usuarioSistemaDTO.getLogin());
            }
        }
        SGC_RegistroReunionesRecursosDTO xRecursos = new SGC_RegistroReunionesRecursosDTO();
        for (int x3 = 0; x3 < this.JTB_RDetalleRecursos.getRowCount(); x3++) {
            if (Boolean.valueOf(this.xModeloRecursos.getValueAt(x3, 0).toString()).booleanValue()) {
                xRecursos.setIdRegistroR(Long.valueOf(xIdEncabezado));
                xRecursos.setIdRecurso(Long.valueOf(this.xModeloRecursos.getValueAt(x3, 1).toString()));
                xRecursos.setCantidad(Integer.valueOf(this.xModeloRecursos.getValueAt(x3, 3).toString()).intValue());
                xRecursos.setObservacion(this.xModeloRecursos.getValueAt(x3, 4).toString());
                this.xSGC_RegistroReunionesDAO.create_recurso(xRecursos);
                if (Boolean.valueOf(this.xModeloRecursos.getValueAt(x3, 6).toString()).booleanValue() && !this.xModeloRecursos.getValueAt(x3, 5).toString().isEmpty()) {
                    this.xmt.mEnvioCorreoElectronico("", this.xModeloRecursos.getValueAt(x3, 5).toString(), "SEGURIDAD CLINICA - REPORTE DE CASO Nº ", Principal.usuarioSistemaDTO.getLogin());
                }
            }
        }
    }
}
