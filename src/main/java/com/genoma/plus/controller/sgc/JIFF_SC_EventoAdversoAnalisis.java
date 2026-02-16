package com.genoma.plus.controller.sgc;

import Acceso.Principal;
import General.Anular;
import Utilidades.CustomPopupMenuListener;
import Utilidades.Metodos;
import com.genoma.plus.controller.general.JDGenericoPanel;
import com.genoma.plus.dao.impl.sgc.SC_EventoAdversoAnalisisDAOImpl;
import com.genoma.plus.dao.impl.sgc.SC_EventoAdversoDAOImpl;
import com.genoma.plus.dao.sgc.SC_EventoAdversoAnalisisDAO;
import com.genoma.plus.dao.sgc.SC_EventoAdversoDAO;
import com.genoma.plus.dto.gcuenta.GCGenericoDTO;
import com.genoma.plus.dto.sgc.SC_EventoAdversoAnalisisDTO;
import com.genoma.plus.dto.sgc.SC_EventoAdversoDTO;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyVetoException;
import java.beans.VetoableChangeListener;
import java.io.File;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/sgc/JIFF_SC_EventoAdversoAnalisis.class */
public class JIFF_SC_EventoAdversoAnalisis extends JInternalFrame {
    private SC_EventoAdversoAnalisisDAO xSC_EventoAdversoAnalisisDAO;
    private SC_EventoAdversoDAO xSC_EventoAdversoDAO;
    public DefaultTableModel xmodelo;
    private Object[] xDato;
    private int xtipo = 1;
    private Metodos xmt = new Metodos();
    private Boolean xEsVisualizacion;
    private String[] xidTipoProceso;
    private ButtonGroup BGFiltro;
    private JButton JBTAnalisisEvenAdv;
    private JButton JBTClasificacion;
    private JButton JBTExportar;
    private JComboBox<String> JCBProcesos;
    private JCheckBox JCHEspecial;
    private JCheckBox JCHEspecial1;
    private JCheckBox JCHPExpuestos;
    public JDateChooser JDFFechaF;
    public JDateChooser JDFFechaI;
    private JPanel JPBuscar;
    private JRadioButton JRBFecha;
    private JRadioButton JRBIdentificacion;
    private JRadioButton JRBNombre;
    private JRadioButton JRBProcesos;
    private JScrollPane JSPDetalle;
    public JTable JTDetalle;
    private JTextField JTFBuscar;
    private JTextField JTFRuta;
    private JPanel jPanel1;

    public JIFF_SC_EventoAdversoAnalisis(Boolean xEsVisualizacion) {
        initComponents();
        springStart();
        this.xEsVisualizacion = xEsVisualizacion;
        this.JBTAnalisisEvenAdv.setVisible(this.xEsVisualizacion.booleanValue());
        this.JBTClasificacion.setVisible(this.xEsVisualizacion.booleanValue());
        this.JCBProcesos.setVisible(false);
        this.JDFFechaF.setVisible(false);
        this.JDFFechaI.setVisible(false);
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
        mCargarDatosTabla(0, null, null);
    }

    public void springStart() {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"});
        this.xSC_EventoAdversoAnalisisDAO = (SC_EventoAdversoAnalisisDAOImpl) classPathXmlApplicationContext.getBean("sCEventoAdversoAnalisisDAOImpl");
        this.xSC_EventoAdversoDAO = (SC_EventoAdversoDAOImpl) classPathXmlApplicationContext.getBean("sCEventoAdversoDAO");
    }

    /* JADX WARN: Type inference failed for: r3v7, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.BGFiltro = new ButtonGroup();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JBTAnalisisEvenAdv = new JButton();
        this.JPBuscar = new JPanel();
        this.JTFBuscar = new JTextField();
        this.JDFFechaI = new JDateChooser();
        this.JDFFechaF = new JDateChooser();
        this.jPanel1 = new JPanel();
        this.JRBNombre = new JRadioButton();
        this.JRBIdentificacion = new JRadioButton();
        this.JRBFecha = new JRadioButton();
        this.JRBProcesos = new JRadioButton();
        this.JCBProcesos = new JComboBox<>();
        this.JBTClasificacion = new JButton();
        this.JCHEspecial1 = new JCheckBox();
        this.JCHEspecial = new JCheckBox();
        this.JCHPExpuestos = new JCheckBox();
        this.JTFRuta = new JTextField();
        this.JBTExportar = new JButton();
        setClosable(true);
        setIconifiable(true);
        setTitle("ANÁLISIS EVENTO ADVERSO");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jiffAnalisisEventoAdverso");
        addInternalFrameListener(new InternalFrameListener() { // from class: com.genoma.plus.controller.sgc.JIFF_SC_EventoAdversoAnalisis.1
            public void internalFrameActivated(InternalFrameEvent evt) {
            }

            public void internalFrameClosed(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                JIFF_SC_EventoAdversoAnalisis.this.formInternalFrameClosing(evt);
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
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.sgc.JIFF_SC_EventoAdversoAnalisis.2
            public void mouseClicked(MouseEvent evt) {
                JIFF_SC_EventoAdversoAnalisis.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.JBTAnalisisEvenAdv.setFont(new Font("Arial", 1, 14));
        this.JBTAnalisisEvenAdv.setIcon(new ImageIcon(getClass().getResource("/Imagenes/analisisEventoEven.png")));
        this.JBTAnalisisEvenAdv.setText("Análisis Evento Adverso");
        this.JBTAnalisisEvenAdv.setToolTipText("Buscar Evento Adverso");
        this.JBTAnalisisEvenAdv.setPreferredSize((Dimension) null);
        this.JBTAnalisisEvenAdv.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.sgc.JIFF_SC_EventoAdversoAnalisis.3
            public void actionPerformed(ActionEvent evt) {
                JIFF_SC_EventoAdversoAnalisis.this.JBTAnalisisEvenAdvActionPerformed(evt);
            }
        });
        this.JPBuscar.setBorder(BorderFactory.createTitledBorder((Border) null, "BUSCAR", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTFBuscar.setFont(new Font("Arial", 1, 12));
        this.JTFBuscar.setBorder(BorderFactory.createTitledBorder((Border) null, "Buscar: Tipo de Evento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFBuscar.setPreferredSize((Dimension) null);
        this.JTFBuscar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.sgc.JIFF_SC_EventoAdversoAnalisis.4
            public void actionPerformed(ActionEvent evt) {
                JIFF_SC_EventoAdversoAnalisis.this.JTFBuscarActionPerformed(evt);
            }
        });
        this.JTFBuscar.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.sgc.JIFF_SC_EventoAdversoAnalisis.5
            public void keyPressed(KeyEvent evt) {
                JIFF_SC_EventoAdversoAnalisis.this.JTFBuscarKeyPressed(evt);
            }
        });
        this.JDFFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFFechaI.setFont(new Font("Arial", 1, 12));
        this.JDFFechaI.setPreferredSize((Dimension) null);
        this.JDFFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Final", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFFechaF.setFont(new Font("Arial", 1, 12));
        this.JDFFechaF.setPreferredSize((Dimension) null);
        this.JDFFechaF.addFocusListener(new FocusAdapter() { // from class: com.genoma.plus.controller.sgc.JIFF_SC_EventoAdversoAnalisis.6
            public void focusLost(FocusEvent evt) {
                JIFF_SC_EventoAdversoAnalisis.this.JDFFechaFFocusLost(evt);
            }
        });
        this.JDFFechaF.addMouseWheelListener(new MouseWheelListener() { // from class: com.genoma.plus.controller.sgc.JIFF_SC_EventoAdversoAnalisis.7
            public void mouseWheelMoved(MouseWheelEvent evt) {
                JIFF_SC_EventoAdversoAnalisis.this.JDFFechaFMouseWheelMoved(evt);
            }
        });
        this.JDFFechaF.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.sgc.JIFF_SC_EventoAdversoAnalisis.8
            public void mouseClicked(MouseEvent evt) {
                JIFF_SC_EventoAdversoAnalisis.this.JDFFechaFMouseClicked(evt);
            }
        });
        this.JDFFechaF.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.sgc.JIFF_SC_EventoAdversoAnalisis.9
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFF_SC_EventoAdversoAnalisis.this.JDFFechaFPropertyChange(evt);
            }
        });
        this.JDFFechaF.addVetoableChangeListener(new VetoableChangeListener() { // from class: com.genoma.plus.controller.sgc.JIFF_SC_EventoAdversoAnalisis.10
            /* JADX INFO: Thrown type has an unknown type hierarchy: java.beans.PropertyVetoException */
            public void vetoableChange(PropertyChangeEvent evt) throws PropertyVetoException {
                JIFF_SC_EventoAdversoAnalisis.this.JDFFechaFVetoableChange(evt);
            }
        });
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "TIPO DE BUSQUEDA", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.BGFiltro.add(this.JRBNombre);
        this.JRBNombre.setFont(new Font("Arial", 1, 12));
        this.JRBNombre.setSelected(true);
        this.JRBNombre.setText("Tipo Evento");
        this.JRBNombre.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.sgc.JIFF_SC_EventoAdversoAnalisis.11
            public void actionPerformed(ActionEvent evt) {
                JIFF_SC_EventoAdversoAnalisis.this.JRBNombreActionPerformed(evt);
            }
        });
        this.BGFiltro.add(this.JRBIdentificacion);
        this.JRBIdentificacion.setFont(new Font("Arial", 1, 12));
        this.JRBIdentificacion.setText("Nº Documento");
        this.JRBIdentificacion.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.sgc.JIFF_SC_EventoAdversoAnalisis.12
            public void actionPerformed(ActionEvent evt) {
                JIFF_SC_EventoAdversoAnalisis.this.JRBIdentificacionActionPerformed(evt);
            }
        });
        this.BGFiltro.add(this.JRBFecha);
        this.JRBFecha.setFont(new Font("Arial", 1, 12));
        this.JRBFecha.setText("Fecha");
        this.JRBFecha.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.sgc.JIFF_SC_EventoAdversoAnalisis.13
            public void actionPerformed(ActionEvent evt) {
                JIFF_SC_EventoAdversoAnalisis.this.JRBFechaActionPerformed(evt);
            }
        });
        this.BGFiltro.add(this.JRBProcesos);
        this.JRBProcesos.setFont(new Font("Arial", 1, 12));
        this.JRBProcesos.setText("Proceso");
        this.JRBProcesos.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.sgc.JIFF_SC_EventoAdversoAnalisis.14
            public void actionPerformed(ActionEvent evt) {
                JIFF_SC_EventoAdversoAnalisis.this.JRBProcesosActionPerformed(evt);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(10, 10, 10).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JRBIdentificacion).addComponent(this.JRBNombre)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JRBFecha, -2, 73, -2).addComponent(this.JRBProcesos))));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBNombre).addComponent(this.JRBFecha, -2, 23, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBIdentificacion).addComponent(this.JRBProcesos)).addGap(0, 0, 32767)));
        this.JCBProcesos.setFont(new Font("Arial", 1, 12));
        this.JCBProcesos.setBorder(BorderFactory.createTitledBorder((Border) null, "Procesos", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPBuscarLayout = new GroupLayout(this.JPBuscar);
        this.JPBuscar.setLayout(JPBuscarLayout);
        JPBuscarLayout.setHorizontalGroup(JPBuscarLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPBuscarLayout.createSequentialGroup().addContainerGap().addComponent(this.JDFFechaI, -2, 118, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JDFFechaF, -2, 118, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFBuscar, -1, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBProcesos, 0, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel1, -2, -1, -2).addContainerGap()));
        JPBuscarLayout.setVerticalGroup(JPBuscarLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPBuscarLayout.createSequentialGroup().addGroup(JPBuscarLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jPanel1, -2, -1, -2).addGroup(JPBuscarLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBProcesos, -2, 50, -2).addGroup(JPBuscarLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTFBuscar, -1, -1, 32767).addGroup(JPBuscarLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JDFFechaI, -1, -1, 32767).addComponent(this.JDFFechaF, -1, -1, 32767))))).addGap(0, 5, 32767)));
        this.JBTClasificacion.setFont(new Font("Arial", 1, 14));
        this.JBTClasificacion.setIcon(new ImageIcon(getClass().getResource("/Imagenes/clasificacion.png")));
        this.JBTClasificacion.setText("Clasificaciòn");
        this.JBTClasificacion.setToolTipText("Clasificacion Evento Adverso");
        this.JBTClasificacion.setPreferredSize((Dimension) null);
        this.JBTClasificacion.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.sgc.JIFF_SC_EventoAdversoAnalisis.15
            public void actionPerformed(ActionEvent evt) {
                JIFF_SC_EventoAdversoAnalisis.this.JBTClasificacionActionPerformed(evt);
            }
        });
        this.JCHEspecial1.setBackground(Color.orange);
        this.JCHEspecial1.setFont(new Font("Arial", 1, 12));
        this.JCHEspecial1.setSelected(true);
        this.JCHEspecial1.setText("Por Vencer");
        this.JCHEspecial1.setPreferredSize((Dimension) null);
        this.JCHEspecial.setBackground(Color.green);
        this.JCHEspecial.setFont(new Font("Arial", 1, 12));
        this.JCHEspecial.setSelected(true);
        this.JCHEspecial.setText("Cerrada");
        this.JCHEspecial.setPreferredSize((Dimension) null);
        this.JCHEspecial.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.sgc.JIFF_SC_EventoAdversoAnalisis.16
            public void actionPerformed(ActionEvent evt) {
                JIFF_SC_EventoAdversoAnalisis.this.JCHEspecialActionPerformed(evt);
            }
        });
        this.JCHPExpuestos.setBackground(Color.red);
        this.JCHPExpuestos.setFont(new Font("Arial", 1, 12));
        this.JCHPExpuestos.setSelected(true);
        this.JCHPExpuestos.setText("Vencida");
        this.JCHPExpuestos.setPreferredSize((Dimension) null);
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.sgc.JIFF_SC_EventoAdversoAnalisis.17
            public void mouseClicked(MouseEvent evt) {
                JIFF_SC_EventoAdversoAnalisis.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setForeground(Color.red);
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.sgc.JIFF_SC_EventoAdversoAnalisis.18
            public void actionPerformed(ActionEvent evt) {
                JIFF_SC_EventoAdversoAnalisis.this.JBTExportarActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(10, 10, 10).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(layout.createSequentialGroup().addGap(0, 0, 32767).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JPBuscar, -1, -1, 32767).addComponent(this.JSPDetalle, -2, 1020, -2))).addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(layout.createSequentialGroup().addComponent(this.JTFRuta, -2, 374, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBTExportar, -2, 260, -2)).addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup().addComponent(this.JBTAnalisisEvenAdv, -2, 317, -2).addGap(10, 10, 10).addComponent(this.JBTClasificacion, -2, 317, -2))).addGap(76, 76, 76).addComponent(this.JCHEspecial, -2, -1, -2).addGap(18, 18, 18).addComponent(this.JCHEspecial1, -2, -1, -2).addGap(10, 10, 10).addComponent(this.JCHPExpuestos, -2, -1, -2))).addGap(10, 10, 10)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(11, 11, 11).addComponent(this.JPBuscar, -2, -1, -2).addGap(11, 11, 11).addComponent(this.JSPDetalle, -2, 446, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBTClasificacion, -2, 50, -2).addComponent(this.JBTAnalisisEvenAdv, -2, 50, -2).addComponent(this.JCHEspecial, -2, -1, -2).addComponent(this.JCHEspecial1, -2, -1, -2).addComponent(this.JCHPExpuestos, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFRuta, -2, 50, -2).addComponent(this.JBTExportar, -1, 50, 32767)).addGap(5, 5, 5)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTAnalisisEvenAdvActionPerformed(ActionEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            SC_JDEventoAdversoGestion xAnalisEvento = new SC_JDEventoAdversoGestion(null, true, this);
            xAnalisEvento.setLocationRelativeTo(null);
            xAnalisEvento.setVisible(true);
            return;
        }
        JOptionPane.showMessageDialog((Component) null, "Debe seleccionar un registro");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTClasificacionActionPerformed(ActionEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            JDClasificacionEventAdv xClasificacionEvt = new JDClasificacionEventAdv(null, true, Integer.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString()).intValue());
            xClasificacionEvt.setLocationRelativeTo(null);
            xClasificacionEvt.setVisible(true);
            return;
        }
        JOptionPane.showMessageDialog((Component) null, "Debe seleccionar un registro");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFBuscarKeyPressed(KeyEvent evt) {
        if (this.JTFBuscar.getText().isEmpty()) {
            mCargarDatosTabla(0, null, null);
        } else {
            mCargarDatosTabla(this.xtipo, this.JTFBuscar.getText(), null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBNombreActionPerformed(ActionEvent evt) {
        this.xtipo = 1;
        this.JCBProcesos.setVisible(false);
        this.JDFFechaF.setVisible(false);
        this.JDFFechaI.setVisible(false);
        this.JTFBuscar.setVisible(true);
        this.JTFBuscar.setBorder(BorderFactory.createTitledBorder((Border) null, "Buscar: Tipo de Evento", 0, 0, new Font("Arial", 1, 12), Color.blue));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBIdentificacionActionPerformed(ActionEvent evt) {
        this.xtipo = 2;
        this.JCBProcesos.setVisible(false);
        this.JDFFechaF.setVisible(false);
        this.JDFFechaI.setVisible(false);
        this.JTFBuscar.setVisible(true);
        this.JTFBuscar.setBorder(BorderFactory.createTitledBorder((Border) null, "Buscar: Nº Documento", 0, 0, new Font("Arial", 1, 12), Color.blue));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFBuscarActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBFechaActionPerformed(ActionEvent evt) {
        this.xtipo = 3;
        this.JDFFechaI.setDate(this.xmt.getFechaActual());
        this.JDFFechaF.setDate(this.xmt.getFechaActual());
        this.JDFFechaF.setVisible(true);
        this.JDFFechaI.setVisible(true);
        this.JCBProcesos.setVisible(false);
        this.JTFBuscar.setVisible(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFFechaFPropertyChange(PropertyChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFFechaFVetoableChange(PropertyChangeEvent evt) throws PropertyVetoException {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFFechaFFocusLost(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFFechaFMouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFFechaFMouseWheelMoved(MouseWheelEvent evt) {
        if (this.xtipo == 3) {
            mCargarDatosTabla(this.xtipo, this.xmt.formatoAMD.format(this.JDFFechaI.getDate()), this.xmt.formatoAMD.format(this.JDFFechaF.getDate()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1 && this.xEsVisualizacion.booleanValue() && evt.getClickCount() == 2) {
            Principal.informacionGeneralPrincipalDTO.setEsModificable(1);
            JDGenericoPanel detalle = new JDGenericoPanel(null, true, "Evento Adverso", this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 15).toString(), 32);
            detalle.setLocationRelativeTo(this);
            detalle.setVisible(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosing(InternalFrameEvent evt) {
        Principal.informacionGeneralPrincipalDTO.setEsModificable(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBProcesosActionPerformed(ActionEvent evt) {
        this.xtipo = 4;
        this.JCBProcesos.setVisible(true);
        this.JDFFechaF.setVisible(false);
        this.JDFFechaI.setVisible(false);
        this.JTFBuscar.setVisible(false);
        mCargarCombo();
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
            if (this.JTDetalle.getRowCount() != -1) {
                int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMAR", 0, 3, new ImageIcon("src/Imagenes/Question2.png"));
                if (n == 0) {
                    this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTDetalle, this.JTFRuta.getText(), getTitle());
                    return;
                }
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "No existe información para exportar", "VERIFICAR", 1, new ImageIcon("src/Imagenes/Information2.png"));
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un ruta valida", "VERIFICAR", 1, new ImageIcon("src/Imagenes/Information2.png"));
        this.JTFRuta.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEspecialActionPerformed(ActionEvent evt) {
    }

    private void mCargarCombo() {
        this.JCBProcesos.removeAllItems();
        List<GCGenericoDTO> list1 = this.xSC_EventoAdversoAnalisisDAO.listaTProceso();
        this.xidTipoProceso = new String[list1.size()];
        for (int x = 0; x < list1.size(); x++) {
            this.xidTipoProceso[x] = String.valueOf(list1.get(x).getId());
            this.JCBProcesos.addItem(list1.get(x).getNombre());
            System.out.println("Consulta " + list1.get(x).getId());
            System.out.println("" + list1.get(x).getNombre());
        }
        this.JCBProcesos.addPopupMenuListener(new CustomPopupMenuListener(true, false));
        this.JCBProcesos.setSelectedIndex(-1);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    public void mModelo() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Fecha", "Hora", "Documento", "NUsuario", "ProcesoR", "TEvento", "NRiesgo", "Descripcion", "PReporta", "Cargo", "Id_Analisis", "Id_Clasificacion", "DVencimiento", "NDiasV", "IdIngreso"}) { // from class: com.genoma.plus.controller.sgc.JIFF_SC_EventoAdversoAnalisis.19
            Class[] types = {Long.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Long.class, Long.class, Integer.class, Integer.class, Long.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTDetalle;
        JTable jTable2 = this.JTDetalle;
        jTable.setAutoResizeMode(0);
        this.JTDetalle.doLayout();
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(4).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(4).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(250);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(12).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(13).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(14).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(14).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(14).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(15).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(15).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(15).setMaxWidth(0);
    }

    public void mCargarDatosTabla(int xtipo, String xbusqueda, String xbusqueda1) {
        mModelo();
        List<SC_EventoAdversoAnalisisDTO> list = this.xSC_EventoAdversoAnalisisDAO.listEvento(xtipo, xbusqueda, xbusqueda1);
        this.xmt.mEstablecerTextEditor(this.JTDetalle, 6);
        this.xmt.mEstablecerTextEditor(this.JTDetalle, 7);
        this.xmt.mEstablecerTextEditor(this.JTDetalle, 8);
        for (int x = 0; x < list.size(); x++) {
            this.xmodelo.addRow(this.xDato);
            this.xmodelo.setValueAt(Long.valueOf(list.get(x).getXCodEvent()), x, 0);
            this.xmodelo.setValueAt(list.get(x).getXFechaEvent(), x, 1);
            this.xmodelo.setValueAt(list.get(x).getXHoraEvent(), x, 2);
            this.xmodelo.setValueAt(list.get(x).getXIdentificacion(), x, 3);
            this.xmodelo.setValueAt(list.get(x).getXNombre(), x, 4);
            this.xmodelo.setValueAt(list.get(x).getXProcesoR(), x, 5);
            this.xmodelo.setValueAt(list.get(x).getXTipoEvento(), x, 6);
            this.xmodelo.setValueAt(list.get(x).getXRiesgo(), x, 7);
            this.xmodelo.setValueAt(list.get(x).getXDescripcion(), x, 8);
            this.xmodelo.setValueAt(list.get(x).getXPReporta(), x, 9);
            this.xmodelo.setValueAt(list.get(x).getXCargo(), x, 10);
            this.xmodelo.setValueAt(Long.valueOf(list.get(x).getXIdAnalisis()), x, 11);
            this.xmodelo.setValueAt(Long.valueOf(list.get(x).getXIdClasificacion()), x, 12);
            this.xmodelo.setValueAt(Integer.valueOf(list.get(x).getDVencimiento()), x, 13);
            this.xmodelo.setValueAt(Integer.valueOf(list.get(x).getNDiasV()), x, 14);
            this.xmodelo.setValueAt(Long.valueOf(list.get(x).getXIdIngreso()), x, 15);
            this.JTDetalle.setDefaultRenderer(Object.class, new MiRender());
        }
    }

    /* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/sgc/JIFF_SC_EventoAdversoAnalisis$MiRender.class */
    public static class MiRender extends DefaultTableCellRenderer {
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            int vencimiento = Integer.parseInt(table.getValueAt(row, 13).toString());
            int NDias = Integer.parseInt(table.getValueAt(row, 14).toString());
            String IdAnalisis = table.getValueAt(row, 11).toString();
            String IdClasificacion = table.getValueAt(row, 12).toString();
            if (!"0".equals(IdAnalisis) && !"0".equals(IdClasificacion)) {
                cell.setBackground(Color.green);
                cell.setForeground(Color.BLACK);
                table.setValueAt(0, row, 13);
            } else if ((NDias > 0 && vencimiento > 0) || NDias == 0) {
                cell.setBackground(Color.white);
                cell.setForeground(Color.BLACK);
            } else if (NDias > 0 && vencimiento <= 0) {
                cell.setBackground(Color.red);
                cell.setForeground(Color.BLACK);
            }
            if (("0".equals(IdAnalisis) || "0".equals(IdClasificacion)) && NDias > 0 && vencimiento <= 3 && vencimiento > 0) {
                cell.setBackground(Color.orange);
                cell.setForeground(Color.BLACK);
            }
            return cell;
        }
    }

    public void mBuscar() {
        if (this.xtipo == 3) {
            mCargarDatosTabla(this.xtipo, this.xmt.formatoAMD.format(this.JDFFechaI.getDate()), this.xmt.formatoAMD.format(this.JDFFechaF.getDate()));
        } else if (this.xtipo == 4) {
            if (this.JCBProcesos.getSelectedIndex() != -1) {
                mCargarDatosTabla(this.xtipo, this.xidTipoProceso[this.JCBProcesos.getSelectedIndex()], null);
            } else {
                JOptionPane.showMessageDialog(this, "Debe seleccionar un Proceso", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            }
        }
    }

    public void mImprimir() {
        if (this.JTDetalle.getSelectedRow() != -1) {
            String[][] parametros = new String[5][2];
            parametros[0][0] = "id";
            parametros[0][1] = String.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
            parametros[1][0] = "SUBREPORT_DIR";
            parametros[1][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
            parametros[2][0] = "SUBREPORTFIRMA_DIR";
            parametros[2][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
            parametros[3][0] = "SUBREPORT_DIR";
            parametros[3][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
            parametros[4][0] = "SUBREPORTFIRMA_DIR";
            parametros[4][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
            this.xmt.GenerarPDF(this.xmt.getRutaRep() + "EventoAdverso", parametros);
            if (!"0".equals(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 11).toString())) {
                this.xmt.GenerarPDF(this.xmt.getRutaRep() + "AnalisisEvento", parametros);
                return;
            }
            return;
        }
        JOptionPane.showMessageDialog(this, "Debe seleccionar un registro", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
    }

    public void mAnular() {
        if ("0".equals(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 11).toString())) {
            int x = JOptionPane.showConfirmDialog(this, "Esta seguro de anular?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                Anular frm = new Anular(null, true, "ANÁLISIS EVENTO ADVERSO", 32);
                frm.setVisible(true);
                return;
            }
            return;
        }
        JOptionPane.showMessageDialog(this, "Este registro tiene un analisis", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
    }

    public void mAnular(String xid, String xdetalle) {
        SC_EventoAdversoDTO Evento = new SC_EventoAdversoDTO();
        Evento.setIdAnulado(Integer.valueOf(xid).intValue());
        Evento.setMotivoAnulacion(xdetalle);
        Evento.setFechaAnulacion(this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()));
        Evento.setUsuarioAnulacion(Principal.usuarioSistemaDTO.getNombreUsuario());
        Evento.setId(Integer.parseInt(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString()));
        this.xSC_EventoAdversoDAO.delete(Evento);
        mCargarDatosTabla(0, null, null);
    }
}
