package com.genoma.plus.controller.pyp;

import Acceso.Principal;
import General.JIFBuscarPatologia;
import Utilidades.Metodos;
import com.genoma.plus.jpa.entities.GPartos;
import com.genoma.plus.jpa.entities.GPersona;
import com.genoma.plus.jpa.entities.GTipoParto;
import com.genoma.plus.jpa.entities.GUsuarioxprograma;
import com.genoma.plus.jpa.entities.PMotivoegresoEntity;
import com.genoma.plus.jpa.service.GPartosService;
import com.genoma.plus.jpa.service.GTipoPartoService;
import com.genoma.plus.jpa.service.IGUsuarioprogramaService;
import com.genoma.plus.jpa.service.PMotivoegresoService;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/pyp/JP_EngresoControlPrenatal.class */
public class JP_EngresoControlPrenatal extends JPanel {
    private DefaultTableModel xmodelo;
    private Object[] dato;
    private List<PMotivoegresoEntity> listarMotivosEgreso;
    private List<GPartos> listarPartos;
    private List<GTipoParto> listarTipoParto;
    Integer idUsuarioPrograma;
    private ButtonGroup JBGEInicio;
    private ButtonGroup JBGEMotivo;
    private ButtonGroup JBGViva;
    private JButton JBTAdicionarRN;
    private JButton JBTEGuardar;
    private JComboBox JCBMotEgreso;
    private JComboBox JCBNSexo;
    private JComboBox JCBTipoParto;
    private JDateChooser JDEFecha;
    private JDateChooser JDEHFEgreso;
    private JDateChooser JDEHFIngreso;
    private JPanel JPIDatosM;
    private JPanel JPIEHospit;
    private JPanel JPIEViva;
    private JPanel JPINDefectoC;
    private JPanel JPINFalleceLP;
    private JPanel JPINReanimacion;
    private JPanel JPINVivo;
    private JPanel JPINacidoVivo;
    private JRadioButton JRBEVNo;
    private JRadioButton JRBEVSi;
    private JRadioButton JRBNDCNo;
    private JRadioButton JRBNDCSi;
    private ButtonGroup JRBNDCongenito;
    private JRadioButton JRBNFNo;
    private JRadioButton JRBNFSi;
    private ButtonGroup JRBNFalleceLP;
    private JRadioButton JRBNRNo;
    private JRadioButton JRBNRSi;
    private ButtonGroup JRBNReanimacion;
    private JRadioButton JRBNVNo;
    private JRadioButton JRBNVSi;
    private ButtonGroup JRBNVivo;
    private JScrollPane JSPEFObservaciones1;
    private JSpinner JSPESGestacion;
    private JSpinner JSPNApgar1;
    private JSpinner JSPNApgar5;
    private JScrollPane JSPNDetalle;
    private JSpinner JSPNPCefalico;
    private JSpinner JSPNPeso;
    private JSpinner JSPNSGestacional;
    private JSpinner JSPNTalla;
    private JTable JTBNDetalle;
    private JLabel JTFEstado;
    public JTextField JTFNDx1;
    public JTextField JTFNDx2;
    public JTextField JTFNDx3;
    private JTextPane JTPEObservaciones;
    private JTabbedPane jTabbedPane1;
    private Metodos metodos = new Metodos();
    private final IGUsuarioprogramaService iUsuarioPorProgramaService = (IGUsuarioprogramaService) Principal.contexto.getBean(IGUsuarioprogramaService.class);
    private final GTipoPartoService iGTipoPartoService = (GTipoPartoService) Principal.contexto.getBean(GTipoPartoService.class);
    private final PMotivoegresoService iPMotivoegresoService = (PMotivoegresoService) Principal.contexto.getBean(PMotivoegresoService.class);
    private final GPartosService iGPartoService = (GPartosService) Principal.contexto.getBean(GPartosService.class);
    private GUsuarioxprograma GUsuarioxprogramaDTO = new GUsuarioxprograma();
    private int xcardinal = 0;
    private int xtrimestre = 1;
    private int xnvivo = 1;
    private int xnreanimacion = 0;
    private int xnfallecelp = 0;
    private int xndcongenito = 0;
    private int xnhijo = 1;
    private boolean xeviva = true;

    public JP_EngresoControlPrenatal(Integer idUsuarioPrograma) {
        initComponents();
        this.idUsuarioPrograma = idUsuarioPrograma;
        nuevo();
        this.JBTAdicionarRN.setEnabled(false);
        mBuscarDatosEgreso();
    }

    private void llenarCombos() {
        this.listarMotivosEgreso = this.iPMotivoegresoService.listarMotivosEgresoPorEstado(false);
        this.JCBMotEgreso.removeAllItems();
        for (int i = 0; i < this.listarMotivosEgreso.size(); i++) {
            this.JCBMotEgreso.addItem(this.listarMotivosEgreso.get(i).getNbre());
        }
        this.JCBMotEgreso.setSelectedIndex(-1);
        this.listarTipoParto = this.iGTipoPartoService.listarTipoPartoFiltradoPorEstado(false);
        this.JCBTipoParto.removeAllItems();
        for (int i2 = 0; i2 < this.listarTipoParto.size(); i2++) {
            this.JCBTipoParto.addItem(this.listarTipoParto.get(i2).getNbre());
        }
        this.JCBTipoParto.setSelectedIndex(-1);
    }

    private void nuevo() {
        this.JDEFecha.setDate(this.metodos.getFechaActual());
        llenarCombos();
        this.JDEHFEgreso.setDate(this.metodos.getFechaActual());
        this.JDEHFIngreso.setDate(this.metodos.getFechaActual());
        mCrearTablaRecienNacido();
    }

    private void mNuevoDRecienNacido() {
        this.JSPNApgar1.setValue(new Integer(0));
        this.JSPNApgar5.setValue(new Integer(0));
        this.JSPNPCefalico.setValue(new Integer(0));
        this.JSPNPeso.setValue(new Integer(0));
        this.JSPNSGestacional.setValue(new Integer(0));
        this.JSPNTalla.setValue(new Integer(0));
        this.JTFNDx1.setText("0000");
        this.JTFNDx2.setText("0000");
        this.JTFNDx3.setText("0000");
        this.JCBNSexo.requestFocus();
    }

    private void mBuscarPatologiaN(JTextField codigo) {
        JIFBuscarPatologia pac = new JIFBuscarPatologia((Frame) null, true, codigo, "EgresoPyP");
        pac.setVisible(true);
        pac.setLocationRelativeTo(this);
    }

    public void mBuscarDatosEgreso() {
        this.GUsuarioxprogramaDTO = this.iUsuarioPorProgramaService.buscarPorIdUsuarioPrograma(this.idUsuarioPrograma);
        if (this.GUsuarioxprogramaDTO.isEstado()) {
            this.JTFEstado.setText("EGRESADO");
            this.JDEFecha.setDate(this.GUsuarioxprogramaDTO.getFechaEgreso());
            this.JCBMotEgreso.setSelectedItem(this.iPMotivoegresoService.buscarMotivoEgreso(this.GUsuarioxprogramaDTO.getMotivoEgreso()).getNbre());
            this.JDEHFIngreso.setDate(this.GUsuarioxprogramaDTO.getFechaIngresoHosp());
            this.JDEHFEgreso.setDate(this.GUsuarioxprogramaDTO.getFechaEgresoHosp());
            this.JCBTipoParto.setSelectedItem(this.iGTipoPartoService.buscarTipoParto(this.GUsuarioxprogramaDTO.getInicioParto()).getNbre());
            this.JSPESGestacion.setValue(this.GUsuarioxprogramaDTO.getEdadGestacionParto());
            if (!this.GUsuarioxprogramaDTO.getViva().booleanValue()) {
                this.JRBEVNo.setSelected(true);
            } else {
                this.JRBEVSi.setSelected(true);
            }
            this.JTPEObservaciones.setText(this.GUsuarioxprogramaDTO.getObservacionEgreso());
            this.listarPartos = this.iGPartoService.listarPartosPorUsuario(this.GUsuarioxprogramaDTO.getIdUsuario().getId());
            if (!this.listarPartos.isEmpty()) {
                mCrearTablaRecienNacido();
                for (int i = 0; i < this.listarPartos.size(); i++) {
                    this.xmodelo.addRow(this.dato);
                    this.xmodelo.setValueAt(this.listarPartos.get(i).getNHijo(), i, 0);
                    if (Boolean.valueOf(this.listarPartos.get(i).getSexo().toString()).booleanValue()) {
                        this.xmodelo.setValueAt("M", i, 1);
                    } else {
                        this.xmodelo.setValueAt("F", i, 1);
                    }
                    if (Boolean.valueOf(this.listarPartos.get(i).getNacioVivo().toString()).booleanValue()) {
                        this.xmodelo.setValueAt("SI", i, 2);
                    } else {
                        this.xmodelo.setValueAt("NO", i, 2);
                    }
                    this.xmodelo.setValueAt(this.listarPartos.get(i).getPeso(), i, 3);
                    this.xmodelo.setValueAt(this.listarPartos.get(i).getTalla(), i, 4);
                    this.xmodelo.setValueAt(this.listarPartos.get(i).getPerimetroCefalico(), i, 5);
                    this.xmodelo.setValueAt(this.listarPartos.get(i).getEdadGestacional(), i, 6);
                    this.xmodelo.setValueAt(this.listarPartos.get(i).getApgar1(), i, 7);
                    this.xmodelo.setValueAt(this.listarPartos.get(i).getApgar5(), i, 8);
                    if (Boolean.valueOf(this.listarPartos.get(i).getReanimacion().toString()).booleanValue()) {
                        this.xmodelo.setValueAt("SI", i, 9);
                    } else {
                        this.xmodelo.setValueAt("NO", i, 9);
                    }
                    if (Boolean.valueOf(this.listarPartos.get(i).getFalleceLP().toString()).booleanValue()) {
                        this.xmodelo.setValueAt("SI", i, 10);
                    } else {
                        this.xmodelo.setValueAt("NO", i, 10);
                    }
                    if (Boolean.valueOf(this.listarPartos.get(i).getDefectosCong().toString()).booleanValue()) {
                        this.xmodelo.setValueAt("SI", i, 11);
                    } else {
                        this.xmodelo.setValueAt("NO", i, 11);
                    }
                    this.xmodelo.setValueAt(this.listarPartos.get(i).getDx1(), i, 12);
                    this.xmodelo.setValueAt(this.listarPartos.get(i).getDx2(), i, 13);
                    this.xmodelo.setValueAt(this.listarPartos.get(i).getDx3(), i, 14);
                }
            }
            this.JBTEGuardar.setEnabled(false);
            this.JBTAdicionarRN.setEnabled(false);
            return;
        }
        this.JTFEstado.setText("ACTIVO");
        nuevo();
        this.JBTEGuardar.setEnabled(true);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTablaRecienNacido() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"N° Hijo", "Sexo", "NVivo", "Peso", "Talla", "PCefalico", "EGestacional", "Apgar1", "Apgar5", "Reanimación", "FLugarParto", "DCongenito", "Dx1", "Dx2", "Dx3"}) { // from class: com.genoma.plus.controller.pyp.JP_EngresoControlPrenatal.1
            Class[] types = {Integer.class, String.class, String.class, Double.class, Double.class, Double.class, Integer.class, Integer.class, Integer.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTBNDetalle.setModel(this.xmodelo);
        this.JTBNDetalle.getColumnModel().getColumn(0).setPreferredWidth(5);
        this.JTBNDetalle.getColumnModel().getColumn(1).setPreferredWidth(5);
        this.JTBNDetalle.getColumnModel().getColumn(2).setPreferredWidth(5);
        this.JTBNDetalle.getColumnModel().getColumn(3).setPreferredWidth(10);
        this.JTBNDetalle.getColumnModel().getColumn(4).setPreferredWidth(10);
        this.JTBNDetalle.getColumnModel().getColumn(5).setPreferredWidth(10);
        this.JTBNDetalle.getColumnModel().getColumn(6).setPreferredWidth(10);
        this.JTBNDetalle.getColumnModel().getColumn(7).setPreferredWidth(5);
        this.JTBNDetalle.getColumnModel().getColumn(8).setPreferredWidth(5);
        this.JTBNDetalle.getColumnModel().getColumn(9).setPreferredWidth(5);
        this.JTBNDetalle.getColumnModel().getColumn(10).setPreferredWidth(5);
        this.JTBNDetalle.getColumnModel().getColumn(11).setPreferredWidth(5);
        this.JTBNDetalle.getColumnModel().getColumn(12).setPreferredWidth(10);
        this.JTBNDetalle.getColumnModel().getColumn(13).setPreferredWidth(10);
        this.JTBNDetalle.getColumnModel().getColumn(14).setPreferredWidth(10);
    }

    /* JADX WARN: Type inference failed for: r3v176, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGEMotivo = new ButtonGroup();
        this.JBGEInicio = new ButtonGroup();
        this.JBGViva = new ButtonGroup();
        this.JRBNVivo = new ButtonGroup();
        this.JRBNReanimacion = new ButtonGroup();
        this.JRBNDCongenito = new ButtonGroup();
        this.JRBNFalleceLP = new ButtonGroup();
        this.jTabbedPane1 = new JTabbedPane();
        this.JPIDatosM = new JPanel();
        this.JDEFecha = new JDateChooser();
        this.JPIEHospit = new JPanel();
        this.JDEHFIngreso = new JDateChooser();
        this.JDEHFEgreso = new JDateChooser();
        this.JSPESGestacion = new JSpinner();
        this.JSPEFObservaciones1 = new JScrollPane();
        this.JTPEObservaciones = new JTextPane();
        this.JPIEViva = new JPanel();
        this.JRBEVSi = new JRadioButton();
        this.JRBEVNo = new JRadioButton();
        this.JBTEGuardar = new JButton();
        this.JTFEstado = new JLabel();
        this.JCBMotEgreso = new JComboBox();
        this.JCBTipoParto = new JComboBox();
        this.JPINacidoVivo = new JPanel();
        this.JCBNSexo = new JComboBox();
        this.JPINVivo = new JPanel();
        this.JRBNVSi = new JRadioButton();
        this.JRBNVNo = new JRadioButton();
        this.JSPNTalla = new JSpinner();
        this.JSPNPeso = new JSpinner();
        this.JSPNPCefalico = new JSpinner();
        this.JSPNSGestacional = new JSpinner();
        this.JSPNApgar1 = new JSpinner();
        this.JSPNApgar5 = new JSpinner();
        this.JPINReanimacion = new JPanel();
        this.JRBNRSi = new JRadioButton();
        this.JRBNRNo = new JRadioButton();
        this.JPINFalleceLP = new JPanel();
        this.JRBNFSi = new JRadioButton();
        this.JRBNFNo = new JRadioButton();
        this.JPINDefectoC = new JPanel();
        this.JRBNDCSi = new JRadioButton();
        this.JRBNDCNo = new JRadioButton();
        this.JTFNDx1 = new JTextField();
        this.JTFNDx2 = new JTextField();
        this.JTFNDx3 = new JTextField();
        this.JBTAdicionarRN = new JButton();
        this.JSPNDetalle = new JScrollPane();
        this.JTBNDetalle = new JTable();
        this.jTabbedPane1.setForeground(Color.red);
        this.jTabbedPane1.setFont(new Font("Arial", 1, 14));
        this.JPIDatosM.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS DE LA MADRE", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JDEFecha.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JDEFecha.setDateFormatString("dd/MM/yyyy");
        this.JDEFecha.setFont(new Font("Arial", 1, 12));
        this.JPIEHospit.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha de Hospitalización", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDEHFIngreso.setBorder(BorderFactory.createTitledBorder((Border) null, "Ingreso", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JDEHFIngreso.setDateFormatString("dd/MM/yyyy");
        this.JDEHFIngreso.setFont(new Font("Arial", 1, 12));
        this.JDEHFEgreso.setBorder(BorderFactory.createTitledBorder((Border) null, "Egreso", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JDEHFEgreso.setDateFormatString("dd/MM/yyyy");
        this.JDEHFEgreso.setFont(new Font("Arial", 1, 12));
        GroupLayout JPIEHospitLayout = new GroupLayout(this.JPIEHospit);
        this.JPIEHospit.setLayout(JPIEHospitLayout);
        JPIEHospitLayout.setHorizontalGroup(JPIEHospitLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIEHospitLayout.createSequentialGroup().addContainerGap().addComponent(this.JDEHFIngreso, -2, 110, -2).addGap(18, 18, 18).addComponent(this.JDEHFEgreso, -2, 110, -2).addContainerGap(14, 32767)));
        JPIEHospitLayout.setVerticalGroup(JPIEHospitLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIEHospitLayout.createSequentialGroup().addContainerGap().addGroup(JPIEHospitLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JDEHFIngreso, -1, 45, 32767).addComponent(this.JDEHFEgreso, -1, -1, 32767)).addContainerGap()));
        this.JSPESGestacion.setFont(new Font("Arial", 1, 12));
        this.JSPESGestacion.setModel(new SpinnerNumberModel(Float.valueOf(0.0f), Float.valueOf(0.0f), (Comparable) null, Float.valueOf(0.1f)));
        this.JSPESGestacion.setBorder(BorderFactory.createTitledBorder((Border) null, "SGestación", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPEFObservaciones1.setBorder(BorderFactory.createTitledBorder((Border) null, "Observaciones", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTPEObservaciones.setFont(new Font("Arial", 1, 12));
        this.JTPEObservaciones.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.pyp.JP_EngresoControlPrenatal.2
            public void keyPressed(KeyEvent evt) {
                JP_EngresoControlPrenatal.this.JTPEObservacionesKeyPressed(evt);
            }
        });
        this.JSPEFObservaciones1.setViewportView(this.JTPEObservaciones);
        this.JPIEViva.setBorder(BorderFactory.createTitledBorder((Border) null, "Viva", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBGViva.add(this.JRBEVSi);
        this.JRBEVSi.setFont(new Font("Arial", 1, 12));
        this.JRBEVSi.setSelected(true);
        this.JRBEVSi.setText("Si");
        this.JRBEVSi.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.pyp.JP_EngresoControlPrenatal.3
            public void actionPerformed(ActionEvent evt) {
                JP_EngresoControlPrenatal.this.JRBEVSiActionPerformed(evt);
            }
        });
        this.JBGViva.add(this.JRBEVNo);
        this.JRBEVNo.setFont(new Font("Arial", 1, 12));
        this.JRBEVNo.setText("No");
        this.JRBEVNo.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.pyp.JP_EngresoControlPrenatal.4
            public void actionPerformed(ActionEvent evt) {
                JP_EngresoControlPrenatal.this.JRBEVNoActionPerformed(evt);
            }
        });
        GroupLayout JPIEVivaLayout = new GroupLayout(this.JPIEViva);
        this.JPIEViva.setLayout(JPIEVivaLayout);
        JPIEVivaLayout.setHorizontalGroup(JPIEVivaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIEVivaLayout.createSequentialGroup().addContainerGap().addGroup(JPIEVivaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JRBEVSi).addComponent(this.JRBEVNo)).addContainerGap(-1, 32767)));
        JPIEVivaLayout.setVerticalGroup(JPIEVivaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIEVivaLayout.createSequentialGroup().addComponent(this.JRBEVSi).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 14, 32767).addComponent(this.JRBEVNo).addContainerGap()));
        this.JBTEGuardar.setFont(new Font("Arial", 1, 12));
        this.JBTEGuardar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTEGuardar.setText("Grabar");
        this.JBTEGuardar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.pyp.JP_EngresoControlPrenatal.5
            public void actionPerformed(ActionEvent evt) {
                JP_EngresoControlPrenatal.this.JBTEGuardarActionPerformed(evt);
            }
        });
        this.JBTEGuardar.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.pyp.JP_EngresoControlPrenatal.6
            public void keyPressed(KeyEvent evt) {
                JP_EngresoControlPrenatal.this.JBTEGuardarKeyPressed(evt);
            }
        });
        this.JTFEstado.setFont(new Font("Arial", 1, 14));
        this.JTFEstado.setForeground(Color.red);
        this.JTFEstado.setHorizontalAlignment(0);
        this.JTFEstado.setBorder(BorderFactory.createTitledBorder((Border) null, "Estado", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBMotEgreso.setFont(new Font("Arial", 1, 12));
        this.JCBMotEgreso.setBorder(BorderFactory.createTitledBorder((Border) null, "Motivo de Egreso", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTipoParto.setFont(new Font("Arial", 1, 12));
        this.JCBTipoParto.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo de Parto", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPIDatosMLayout = new GroupLayout(this.JPIDatosM);
        this.JPIDatosM.setLayout(JPIDatosMLayout);
        JPIDatosMLayout.setHorizontalGroup(JPIDatosMLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosMLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosMLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(JPIDatosMLayout.createSequentialGroup().addComponent(this.JPIEHospit, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPIEViva, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPEFObservaciones1, -2, 401, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTEGuardar)).addGroup(JPIDatosMLayout.createSequentialGroup().addComponent(this.JDEFecha, -2, 110, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBMotEgreso, -2, 188, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBTipoParto, -2, 306, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPESGestacion, -2, 97, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFEstado, -1, -1, 32767))).addContainerGap(14, 32767)));
        JPIDatosMLayout.setVerticalGroup(JPIDatosMLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosMLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosMLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosMLayout.createSequentialGroup().addGroup(JPIDatosMLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPIDatosMLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBMotEgreso, -2, 51, -2).addComponent(this.JCBTipoParto, -2, 51, -2).addComponent(this.JSPESGestacion, -2, 50, -2)).addComponent(this.JDEFecha, -2, 50, -2)).addGap(9, 9, 9)).addGroup(JPIDatosMLayout.createSequentialGroup().addComponent(this.JTFEstado, -1, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED))).addGroup(JPIDatosMLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JPIEHospit, GroupLayout.Alignment.LEADING, -2, -1, -2).addComponent(this.JBTEGuardar, -1, -1, 32767).addComponent(this.JSPEFObservaciones1).addComponent(this.JPIEViva, -2, -1, -2)).addGap(88, 88, 88)));
        this.jTabbedPane1.addTab("MADRE", this.JPIDatosM);
        this.JPINacidoVivo.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS DEL RECIEN NACIDO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JCBNSexo.setFont(new Font("Arial", 1, 12));
        this.JCBNSexo.setModel(new DefaultComboBoxModel(new String[]{"M", "F"}));
        this.JCBNSexo.setBorder(BorderFactory.createTitledBorder((Border) null, "Sexo", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JPINVivo.setBorder(BorderFactory.createTitledBorder((Border) null, "Vivo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JRBNVivo.add(this.JRBNVSi);
        this.JRBNVSi.setFont(new Font("Arial", 1, 12));
        this.JRBNVSi.setSelected(true);
        this.JRBNVSi.setText("Si");
        this.JRBNVSi.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.pyp.JP_EngresoControlPrenatal.7
            public void actionPerformed(ActionEvent evt) {
                JP_EngresoControlPrenatal.this.JRBNVSiActionPerformed(evt);
            }
        });
        this.JRBNVivo.add(this.JRBNVNo);
        this.JRBNVNo.setFont(new Font("Arial", 1, 12));
        this.JRBNVNo.setText("No");
        this.JRBNVNo.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.pyp.JP_EngresoControlPrenatal.8
            public void actionPerformed(ActionEvent evt) {
                JP_EngresoControlPrenatal.this.JRBNVNoActionPerformed(evt);
            }
        });
        GroupLayout JPINVivoLayout = new GroupLayout(this.JPINVivo);
        this.JPINVivo.setLayout(JPINVivoLayout);
        JPINVivoLayout.setHorizontalGroup(JPINVivoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPINVivoLayout.createSequentialGroup().addContainerGap().addComponent(this.JRBNVSi).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBNVNo).addContainerGap(-1, 32767)));
        JPINVivoLayout.setVerticalGroup(JPINVivoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPINVivoLayout.createSequentialGroup().addGroup(JPINVivoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBNVSi).addComponent(this.JRBNVNo)).addGap(0, 3, 32767)));
        this.JSPNTalla.setFont(new Font("Arial", 1, 12));
        this.JSPNTalla.setModel(new SpinnerNumberModel(0.0d, 0.0d, 200.0d, 1.0d));
        this.JSPNTalla.setBorder(BorderFactory.createTitledBorder((Border) null, "Talla(cm)", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPNPeso.setFont(new Font("Arial", 1, 12));
        this.JSPNPeso.setModel(new SpinnerNumberModel(Double.valueOf(0.0d), Double.valueOf(0.0d), (Comparable) null, Double.valueOf(1.0d)));
        this.JSPNPeso.setBorder(BorderFactory.createTitledBorder((Border) null, "Peso(Kg)", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPNPCefalico.setFont(new Font("Arial", 1, 12));
        this.JSPNPCefalico.setModel(new SpinnerNumberModel(Float.valueOf(0.0f), Float.valueOf(0.0f), (Comparable) null, Float.valueOf(0.1f)));
        this.JSPNPCefalico.setBorder(BorderFactory.createTitledBorder((Border) null, "P. Cefálico", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPNSGestacional.setFont(new Font("Arial", 1, 12));
        this.JSPNSGestacional.setModel(new SpinnerNumberModel(Float.valueOf(0.0f), Float.valueOf(0.0f), (Comparable) null, Float.valueOf(0.1f)));
        this.JSPNSGestacional.setBorder(BorderFactory.createTitledBorder((Border) null, "SGestación", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPNApgar1.setFont(new Font("Arial", 1, 12));
        this.JSPNApgar1.setModel(new SpinnerNumberModel(1, 1, 10, 1));
        this.JSPNApgar1.setBorder(BorderFactory.createTitledBorder((Border) null, "Apgar - 1", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPNApgar5.setFont(new Font("Arial", 1, 12));
        this.JSPNApgar5.setModel(new SpinnerNumberModel(1, 1, 10, 1));
        this.JSPNApgar5.setBorder(BorderFactory.createTitledBorder((Border) null, "Apgar - 5", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JPINReanimacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Reanimación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JRBNReanimacion.add(this.JRBNRSi);
        this.JRBNRSi.setFont(new Font("Arial", 1, 12));
        this.JRBNRSi.setText("Si");
        this.JRBNRSi.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.pyp.JP_EngresoControlPrenatal.9
            public void actionPerformed(ActionEvent evt) {
                JP_EngresoControlPrenatal.this.JRBNRSiActionPerformed(evt);
            }
        });
        this.JRBNReanimacion.add(this.JRBNRNo);
        this.JRBNRNo.setFont(new Font("Arial", 1, 12));
        this.JRBNRNo.setSelected(true);
        this.JRBNRNo.setText("No");
        this.JRBNRNo.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.pyp.JP_EngresoControlPrenatal.10
            public void actionPerformed(ActionEvent evt) {
                JP_EngresoControlPrenatal.this.JRBNRNoActionPerformed(evt);
            }
        });
        GroupLayout JPINReanimacionLayout = new GroupLayout(this.JPINReanimacion);
        this.JPINReanimacion.setLayout(JPINReanimacionLayout);
        JPINReanimacionLayout.setHorizontalGroup(JPINReanimacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPINReanimacionLayout.createSequentialGroup().addContainerGap().addComponent(this.JRBNRSi).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBNRNo).addContainerGap(-1, 32767)));
        JPINReanimacionLayout.setVerticalGroup(JPINReanimacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPINReanimacionLayout.createSequentialGroup().addGroup(JPINReanimacionLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBNRSi).addComponent(this.JRBNRNo)).addGap(0, 0, 32767)));
        this.JPINFalleceLP.setBorder(BorderFactory.createTitledBorder((Border) null, "Fallece LP", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JPINFalleceLP.setToolTipText("Fellece en el lugar del parto");
        this.JRBNFalleceLP.add(this.JRBNFSi);
        this.JRBNFSi.setFont(new Font("Arial", 1, 12));
        this.JRBNFSi.setText("Si");
        this.JRBNFSi.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.pyp.JP_EngresoControlPrenatal.11
            public void actionPerformed(ActionEvent evt) {
                JP_EngresoControlPrenatal.this.JRBNFSiActionPerformed(evt);
            }
        });
        this.JRBNFalleceLP.add(this.JRBNFNo);
        this.JRBNFNo.setFont(new Font("Arial", 1, 12));
        this.JRBNFNo.setSelected(true);
        this.JRBNFNo.setText("No");
        this.JRBNFNo.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.pyp.JP_EngresoControlPrenatal.12
            public void actionPerformed(ActionEvent evt) {
                JP_EngresoControlPrenatal.this.JRBNFNoActionPerformed(evt);
            }
        });
        GroupLayout JPINFalleceLPLayout = new GroupLayout(this.JPINFalleceLP);
        this.JPINFalleceLP.setLayout(JPINFalleceLPLayout);
        JPINFalleceLPLayout.setHorizontalGroup(JPINFalleceLPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPINFalleceLPLayout.createSequentialGroup().addContainerGap().addComponent(this.JRBNFSi).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBNFNo).addContainerGap(-1, 32767)));
        JPINFalleceLPLayout.setVerticalGroup(JPINFalleceLPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPINFalleceLPLayout.createSequentialGroup().addGroup(JPINFalleceLPLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBNFSi).addComponent(this.JRBNFNo)).addGap(0, 3, 32767)));
        this.JPINDefectoC.setBorder(BorderFactory.createTitledBorder((Border) null, "D. Congenito", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JPINDefectoC.setToolTipText("Defectos Congenitos");
        this.JRBNDCongenito.add(this.JRBNDCSi);
        this.JRBNDCSi.setFont(new Font("Arial", 1, 12));
        this.JRBNDCSi.setText("Si");
        this.JRBNDCSi.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.pyp.JP_EngresoControlPrenatal.13
            public void actionPerformed(ActionEvent evt) {
                JP_EngresoControlPrenatal.this.JRBNDCSiActionPerformed(evt);
            }
        });
        this.JRBNDCongenito.add(this.JRBNDCNo);
        this.JRBNDCNo.setFont(new Font("Arial", 1, 12));
        this.JRBNDCNo.setSelected(true);
        this.JRBNDCNo.setText("No");
        this.JRBNDCNo.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.pyp.JP_EngresoControlPrenatal.14
            public void actionPerformed(ActionEvent evt) {
                JP_EngresoControlPrenatal.this.JRBNDCNoActionPerformed(evt);
            }
        });
        GroupLayout JPINDefectoCLayout = new GroupLayout(this.JPINDefectoC);
        this.JPINDefectoC.setLayout(JPINDefectoCLayout);
        JPINDefectoCLayout.setHorizontalGroup(JPINDefectoCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPINDefectoCLayout.createSequentialGroup().addContainerGap().addComponent(this.JRBNDCSi).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBNDCNo).addContainerGap(-1, 32767)));
        JPINDefectoCLayout.setVerticalGroup(JPINDefectoCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPINDefectoCLayout.createSequentialGroup().addGroup(JPINDefectoCLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBNDCSi).addComponent(this.JRBNDCNo)).addGap(0, 0, 32767)));
        this.JTFNDx1.setFont(new Font("Arial", 1, 12));
        this.JTFNDx1.setHorizontalAlignment(4);
        this.JTFNDx1.setText("0000");
        this.JTFNDx1.setToolTipText("");
        this.JTFNDx1.setBorder(BorderFactory.createTitledBorder((Border) null, "Dx1", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFNDx1.setEnabled(false);
        this.JTFNDx1.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.pyp.JP_EngresoControlPrenatal.15
            public void mouseClicked(MouseEvent evt) {
                JP_EngresoControlPrenatal.this.JTFNDx1MouseClicked(evt);
            }
        });
        this.JTFNDx2.setFont(new Font("Arial", 1, 12));
        this.JTFNDx2.setHorizontalAlignment(4);
        this.JTFNDx2.setText("0000");
        this.JTFNDx2.setBorder(BorderFactory.createTitledBorder((Border) null, "Dx2", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFNDx2.setEnabled(false);
        this.JTFNDx2.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.pyp.JP_EngresoControlPrenatal.16
            public void mouseClicked(MouseEvent evt) {
                JP_EngresoControlPrenatal.this.JTFNDx2MouseClicked(evt);
            }
        });
        this.JTFNDx3.setFont(new Font("Arial", 1, 12));
        this.JTFNDx3.setHorizontalAlignment(4);
        this.JTFNDx3.setText("0000");
        this.JTFNDx3.setBorder(BorderFactory.createTitledBorder((Border) null, "Dx3", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFNDx3.setEnabled(false);
        this.JTFNDx3.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.pyp.JP_EngresoControlPrenatal.17
            public void mouseClicked(MouseEvent evt) {
                JP_EngresoControlPrenatal.this.JTFNDx3MouseClicked(evt);
            }
        });
        this.JBTAdicionarRN.setFont(new Font("Arial", 1, 12));
        this.JBTAdicionarRN.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTAdicionarRN.setText("Adicionar");
        this.JBTAdicionarRN.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.pyp.JP_EngresoControlPrenatal.18
            public void actionPerformed(ActionEvent evt) {
                JP_EngresoControlPrenatal.this.JBTAdicionarRNActionPerformed(evt);
            }
        });
        this.JSPNDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTBNDetalle.setFont(new Font("Arial", 1, 12));
        this.JTBNDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTBNDetalle.setRowHeight(25);
        this.JTBNDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTBNDetalle.setSelectionForeground(Color.red);
        this.JSPNDetalle.setViewportView(this.JTBNDetalle);
        GroupLayout JPINacidoVivoLayout = new GroupLayout(this.JPINacidoVivo);
        this.JPINacidoVivo.setLayout(JPINacidoVivoLayout);
        JPINacidoVivoLayout.setHorizontalGroup(JPINacidoVivoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPINacidoVivoLayout.createSequentialGroup().addContainerGap().addGroup(JPINacidoVivoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPINacidoVivoLayout.createSequentialGroup().addComponent(this.JSPNDetalle).addContainerGap()).addGroup(JPINacidoVivoLayout.createSequentialGroup().addComponent(this.JCBNSexo, -2, 53, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JPINVivo, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPNTalla).addGap(6, 6, 6).addComponent(this.JSPNPeso).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPNPCefalico, -2, 97, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPNSGestacional, -2, 101, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPNApgar1, -2, 88, -2).addGap(18, 18, 18).addComponent(this.JSPNApgar5, -2, 88, -2).addGap(8, 8, 8)).addGroup(JPINacidoVivoLayout.createSequentialGroup().addComponent(this.JPINReanimacion, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JPINFalleceLP, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JPINDefectoC, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFNDx1, -2, 81, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFNDx2, -2, 81, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFNDx3, -2, 81, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTAdicionarRN, -1, -1, 32767).addContainerGap()))));
        JPINacidoVivoLayout.setVerticalGroup(JPINacidoVivoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPINacidoVivoLayout.createSequentialGroup().addContainerGap().addGroup(JPINacidoVivoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPINacidoVivoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JSPNTalla, -2, 50, -2).addComponent(this.JSPNPeso, -2, 50, -2).addComponent(this.JSPNPCefalico, -2, 50, -2).addComponent(this.JSPNSGestacional, -2, 50, -2).addComponent(this.JSPNApgar1, -2, 50, -2).addComponent(this.JSPNApgar5, -2, 50, -2)).addComponent(this.JPINVivo, -2, -1, -2).addComponent(this.JCBNSexo, -2, 50, -2)).addGap(10, 10, 10).addGroup(JPINacidoVivoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JPINFalleceLP, -1, -1, 32767).addComponent(this.JPINReanimacion, -1, -1, 32767).addComponent(this.JPINDefectoC, -1, -1, 32767).addComponent(this.JTFNDx1).addComponent(this.JTFNDx2).addComponent(this.JTFNDx3).addComponent(this.JBTAdicionarRN, -1, -1, 32767)).addGap(10, 10, 10).addComponent(this.JSPNDetalle, -1, 108, 32767).addContainerGap()));
        this.jTabbedPane1.addTab("RECIEN NACIDO", this.JPINacidoVivo);
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addComponent(this.jTabbedPane1, -2, 898, -2).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jTabbedPane1).addContainerGap()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTPEObservacionesKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 9) {
            this.JTPEObservaciones.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBEVSiActionPerformed(ActionEvent evt) {
        this.xeviva = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBEVNoActionPerformed(ActionEvent evt) {
        this.xeviva = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTEGuardarActionPerformed(ActionEvent evt) {
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            this.GUsuarioxprogramaDTO.setFechaEgreso(this.JDEFecha.getDate());
            this.GUsuarioxprogramaDTO.setMotivoEgreso(this.listarMotivosEgreso.get(this.JCBMotEgreso.getSelectedIndex()).getId());
            this.GUsuarioxprogramaDTO.setFechaIngresoHosp(this.JDEHFIngreso.getDate());
            this.GUsuarioxprogramaDTO.setFechaEgresoHosp(this.JDEHFEgreso.getDate());
            this.GUsuarioxprogramaDTO.setInicioParto(this.listarTipoParto.get(this.JCBTipoParto.getSelectedIndex()).getId());
            this.GUsuarioxprogramaDTO.setEdadGestacionParto(Double.valueOf(this.JSPESGestacion.getValue().toString()));
            this.GUsuarioxprogramaDTO.setViva(Boolean.valueOf(this.xeviva));
            this.GUsuarioxprogramaDTO.setEstado(true);
            this.GUsuarioxprogramaDTO.setIdAtencionEgreso(0);
            this.GUsuarioxprogramaDTO.setObservacionEgreso(this.JTPEObservaciones.getText());
            this.iUsuarioPorProgramaService.grabar(this.GUsuarioxprogramaDTO);
            this.JTFEstado.setText("EGRESADO");
            this.JBTAdicionarRN.setEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTEGuardarKeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBNVSiActionPerformed(ActionEvent evt) {
        this.xnvivo = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBNVNoActionPerformed(ActionEvent evt) {
        this.xnvivo = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBNRSiActionPerformed(ActionEvent evt) {
        this.xnreanimacion = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBNRNoActionPerformed(ActionEvent evt) {
        this.xnreanimacion = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBNFSiActionPerformed(ActionEvent evt) {
        this.xnfallecelp = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBNFNoActionPerformed(ActionEvent evt) {
        this.xnfallecelp = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBNDCSiActionPerformed(ActionEvent evt) {
        this.xndcongenito = 1;
        this.JTFNDx1.setEnabled(true);
        this.JTFNDx2.setEnabled(true);
        this.JTFNDx3.setEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBNDCNoActionPerformed(ActionEvent evt) {
        this.xndcongenito = 0;
        this.JTFNDx1.setEnabled(false);
        this.JTFNDx2.setEnabled(false);
        this.JTFNDx3.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNDx1MouseClicked(MouseEvent evt) {
        mBuscarPatologiaN(this.JTFNDx1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNDx2MouseClicked(MouseEvent evt) {
        mBuscarPatologiaN(this.JTFNDx2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNDx3MouseClicked(MouseEvent evt) {
        mBuscarPatologiaN(this.JTFNDx3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTAdicionarRNActionPerformed(ActionEvent evt) {
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            GPersona gPersona = GPersona.builder().id(this.GUsuarioxprogramaDTO.getIdUsuario().getGPersona().getId()).build();
            GPartos gp = GPartos.builder().idPersona(gPersona).cardinal(this.GUsuarioxprogramaDTO.getCardinal()).nHijo(Integer.valueOf(this.xnhijo)).sexo(Integer.valueOf(this.JCBNSexo.getSelectedIndex())).nacioVivo(Integer.valueOf(this.xnvivo)).peso(Double.valueOf(this.JSPNPeso.getValue().toString())).talla(Double.valueOf(this.JSPNTalla.getValue().toString())).perimetroCefalico(Double.valueOf(this.JSPNPCefalico.getValue().toString())).edadGestacional(Double.valueOf(this.JSPNSGestacional.getValue().toString())).apgar1(Integer.valueOf(this.JSPNApgar1.getValue().toString())).apgar5(Integer.valueOf(this.JSPNApgar5.getValue().toString())).reanimacion(Integer.valueOf(this.xnreanimacion)).falleceLP(Integer.valueOf(this.xnfallecelp)).defectosCong(Integer.valueOf(this.xndcongenito)).dx1(this.JTFNDx1.getText()).dx2(this.JTFNDx2.getText()).dx3(this.JTFNDx3.getText()).tsh(0).carnetVacunacion(0).rh(0).fecha(this.metodos.getFechaActual()).usuarioS(Principal.usuarioSistemaDTO.getLogin()).build();
            this.iGPartoService.grabar(gp);
            mNuevoDRecienNacido();
            this.xnhijo++;
            mBuscarDatosEgreso();
        }
    }
}
