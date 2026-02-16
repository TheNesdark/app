package com.genoma.plus.controller.laboratorio;

import Acceso.Principal;
import Utilidades.Metodos;
import com.genoma.plus.jpa.entities.LProtocolosXEquipos;
import com.genoma.plus.jpa.entities.LProtocolosXEquiposJornada;
import com.genoma.plus.jpa.entities.LProtocoloxprocedimiento;
import com.genoma.plus.jpa.entities.LTipoAnalizador;
import com.genoma.plus.jpa.service.LProtocolosXEquiposJornadaService;
import com.genoma.plus.jpa.service.LProtocolosXEquiposService;
import com.genoma.plus.jpa.service.LTipoAnalizadorService;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
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

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/laboratorio/JDFProtocolosxEquipos.class */
public class JDFProtocolosxEquipos extends JDialog {
    private Metodos xmt;
    public DefaultTableModel xmodelo;
    public DefaultTableModel modeloJornada;
    private Object[] xdato;
    private Object[] xdatoJornada;
    private Long idProtocoloEquipo;
    private Long idProtocoloEquipoJornada;
    private Long idProtocoloProcedimiento;
    private List<String> listDiasSemana;
    private List<LTipoAnalizador> listTipoAnalizador;
    private List<LProtocolosXEquiposJornada> listProtocolosXEquiposJornada;
    private List<LProtocolosXEquipos> listProtocoloEquipos;
    private final LTipoAnalizadorService tipoAnalizadorService;
    private final LProtocolosXEquiposService protocolosXEquiposService;
    private final LProtocolosXEquiposJornadaService protocolosXEquiposJornadaService;
    private JButton JBGrabar;
    private JButton JBNuevo;
    private JButton JBSalir;
    private JComboBox<String> JCBDiaSemana;
    private JComboBox<String> JCBEquipos;
    private JCheckBox JCEstado;
    private JCheckBox JCHConsultarJornada;
    private JCheckBox JCHEsPrincipal;
    private JCheckBox JCHEstadoJornada;
    private JPanel JPAnalitoEquipo;
    private JPanel JPAnalitoEquipoJornada;
    private JSpinner JSPOrden;
    private JTable JTDetalle;
    private JTable JTDetalleJornada;
    private JTextField JTFAbreviatura;
    private JTextField JTFUnidad;
    private JTabbedPane JTPOpciones;
    private JPanel jPanel1;
    private JPanel jPanel5;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;

    public JDFProtocolosxEquipos(Frame parent, boolean modal, Long idProtocoloProcedimiento) {
        super(parent, modal);
        this.xmt = new Metodos();
        this.idProtocoloEquipo = 0L;
        this.idProtocoloEquipoJornada = 0L;
        this.listDiasSemana = Arrays.asList("Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo");
        this.tipoAnalizadorService = (LTipoAnalizadorService) Principal.contexto.getBean(LTipoAnalizadorService.class);
        this.protocolosXEquiposService = (LProtocolosXEquiposService) Principal.contexto.getBean(LProtocolosXEquiposService.class);
        this.protocolosXEquiposJornadaService = (LProtocolosXEquiposJornadaService) Principal.contexto.getBean(LProtocolosXEquiposJornadaService.class);
        initComponents();
        setTitle("Protocolo por Equipos ");
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        setLocationRelativeTo(null);
        this.idProtocoloProcedimiento = idProtocoloProcedimiento;
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v49, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v83, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGrabar = new JButton();
        this.JBNuevo = new JButton();
        this.JBSalir = new JButton();
        this.JTPOpciones = new JTabbedPane();
        this.JPAnalitoEquipo = new JPanel();
        this.jPanel1 = new JPanel();
        this.JCBEquipos = new JComboBox<>();
        this.JTFAbreviatura = new JTextField();
        this.JCEstado = new JCheckBox();
        this.JTFUnidad = new JTextField();
        this.JCHEsPrincipal = new JCheckBox();
        this.JSPOrden = new JSpinner();
        this.JCHConsultarJornada = new JCheckBox();
        this.jScrollPane1 = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JPAnalitoEquipoJornada = new JPanel();
        this.jPanel5 = new JPanel();
        this.JCBDiaSemana = new JComboBox<>();
        this.JCHEstadoJornada = new JCheckBox();
        this.jScrollPane2 = new JScrollPane();
        this.JTDetalleJornada = new JTable();
        setDefaultCloseOperation(2);
        setName("xJDFProtocolosxEquipos");
        setResizable(false);
        this.JBGrabar.setFont(new Font("Arial", 1, 12));
        this.JBGrabar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBGrabar.setText("Guardar");
        this.JBGrabar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.laboratorio.JDFProtocolosxEquipos.1
            public void actionPerformed(ActionEvent evt) {
                JDFProtocolosxEquipos.this.JBGrabarActionPerformed(evt);
            }
        });
        this.JBNuevo.setFont(new Font("Arial", 1, 12));
        this.JBNuevo.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Nuevo.png")));
        this.JBNuevo.setText("Nuevo");
        this.JBNuevo.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.laboratorio.JDFProtocolosxEquipos.2
            public void actionPerformed(ActionEvent evt) {
                JDFProtocolosxEquipos.this.JBNuevoActionPerformed(evt);
            }
        });
        this.JBSalir.setFont(new Font("Arial", 1, 12));
        this.JBSalir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.JBSalir.setText("Salir");
        this.JBSalir.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.laboratorio.JDFProtocolosxEquipos.3
            public void actionPerformed(ActionEvent evt) {
                JDFProtocolosxEquipos.this.JBSalirActionPerformed(evt);
            }
        });
        this.JTPOpciones.setForeground(Color.red);
        this.JTPOpciones.setFont(new Font("Arial", 1, 14));
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACION", 2, 0, new Font("Arial", 1, 12), new Color(0, 103, 0)));
        this.JCBEquipos.setFont(new Font("Arial", 1, 12));
        this.JCBEquipos.setBorder(BorderFactory.createTitledBorder((Border) null, "Equipo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFAbreviatura.setFont(new Font("Arial", 1, 12));
        this.JTFAbreviatura.setBorder(BorderFactory.createTitledBorder((Border) null, "Abreviatura", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCEstado.setFont(new Font("Arial", 1, 12));
        this.JCEstado.setForeground(Color.blue);
        this.JCEstado.setText("Estado");
        this.JTFUnidad.setFont(new Font("Arial", 1, 12));
        this.JTFUnidad.setBorder(BorderFactory.createTitledBorder((Border) null, "Unidad", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHEsPrincipal.setFont(new Font("Arial", 1, 12));
        this.JCHEsPrincipal.setForeground(Color.blue);
        this.JCHEsPrincipal.setSelected(true);
        this.JCHEsPrincipal.setText("Es Principal?");
        this.JSPOrden.setFont(new Font("Arial", 1, 12));
        this.JSPOrden.setModel(new SpinnerNumberModel(0, 0, 9, 1));
        this.JSPOrden.setBorder(BorderFactory.createTitledBorder((Border) null, "Orden", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHConsultarJornada.setFont(new Font("Arial", 1, 12));
        this.JCHConsultarJornada.setForeground(Color.blue);
        this.JCHConsultarJornada.setText("Consultar por Jornada?");
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JCEstado, -2, 69, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHEsPrincipal).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHConsultarJornada).addGap(243, 243, 243)).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JCBEquipos, 0, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFAbreviatura, -2, 136, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFUnidad, -2, 80, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPOrden, -2, 68, -2).addContainerGap()))));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFAbreviatura, -2, 52, -2).addComponent(this.JCBEquipos, -1, -1, -2).addComponent(this.JTFUnidad, -2, 52, -2).addComponent(this.JSPOrden, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCEstado).addComponent(this.JCHEsPrincipal).addComponent(this.JCHConsultarJornada)).addGap(13, 13, 13)));
        this.jScrollPane1.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTORICO", 2, 0, new Font("Arial", 1, 12), new Color(0, 103, 0)));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalle.setSelectionBackground(Color.white);
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.laboratorio.JDFProtocolosxEquipos.4
            public void mouseClicked(MouseEvent evt) {
                JDFProtocolosxEquipos.this.JTDetalleMouseClicked(evt);
            }
        });
        this.jScrollPane1.setViewportView(this.JTDetalle);
        GroupLayout JPAnalitoEquipoLayout = new GroupLayout(this.JPAnalitoEquipo);
        this.JPAnalitoEquipo.setLayout(JPAnalitoEquipoLayout);
        JPAnalitoEquipoLayout.setHorizontalGroup(JPAnalitoEquipoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPAnalitoEquipoLayout.createSequentialGroup().addContainerGap().addGroup(JPAnalitoEquipoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jPanel1, -1, -1, -2).addComponent(this.jScrollPane1, -2, 611, -2)).addGap(10, 10, 10)));
        JPAnalitoEquipoLayout.setVerticalGroup(JPAnalitoEquipoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPAnalitoEquipoLayout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jScrollPane1, -2, 221, -2).addContainerGap()));
        this.JTPOpciones.addTab("Asignar Analizador", this.JPAnalitoEquipo);
        this.JPAnalitoEquipoJornada.setEnabled(false);
        this.jPanel5.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACION", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JCBDiaSemana.setFont(new Font("Arial", 1, 12));
        this.JCBDiaSemana.setModel(new DefaultComboBoxModel(new String[]{"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"}));
        this.JCBDiaSemana.setBorder(BorderFactory.createTitledBorder((Border) null, "Dia de la Semana", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHEstadoJornada.setFont(new Font("Arial", 1, 12));
        this.JCHEstadoJornada.setForeground(Color.blue);
        this.JCHEstadoJornada.setText("Estado");
        GroupLayout jPanel5Layout = new GroupLayout(this.jPanel5);
        this.jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addContainerGap().addComponent(this.JCBDiaSemana, 0, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHEstadoJornada).addContainerGap()));
        jPanel5Layout.setVerticalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup().addGap(10, 10, 10).addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBDiaSemana, -2, 50, -2).addComponent(this.JCHEstadoJornada)).addGap(15, 15, 15)));
        this.jScrollPane2.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTORICO", 2, 0, new Font("Arial", 1, 12), new Color(0, 103, 0)));
        this.jScrollPane2.setFont(new Font("Arial", 1, 12));
        this.JTDetalleJornada.setFont(new Font("Arial", 1, 12));
        this.JTDetalleJornada.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalleJornada.setSelectionBackground(Color.white);
        this.JTDetalleJornada.setSelectionForeground(Color.red);
        this.JTDetalleJornada.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.laboratorio.JDFProtocolosxEquipos.5
            public void mouseClicked(MouseEvent evt) {
                JDFProtocolosxEquipos.this.JTDetalleJornadaMouseClicked(evt);
            }
        });
        this.jScrollPane2.setViewportView(this.JTDetalleJornada);
        GroupLayout JPAnalitoEquipoJornadaLayout = new GroupLayout(this.JPAnalitoEquipoJornada);
        this.JPAnalitoEquipoJornada.setLayout(JPAnalitoEquipoJornadaLayout);
        JPAnalitoEquipoJornadaLayout.setHorizontalGroup(JPAnalitoEquipoJornadaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPAnalitoEquipoJornadaLayout.createSequentialGroup().addContainerGap().addGroup(JPAnalitoEquipoJornadaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel5, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addGroup(GroupLayout.Alignment.TRAILING, JPAnalitoEquipoJornadaLayout.createSequentialGroup().addGap(0, 4, 32767).addComponent(this.jScrollPane2, -2, 611, -2))).addContainerGap()));
        JPAnalitoEquipoJornadaLayout.setVerticalGroup(JPAnalitoEquipoJornadaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPAnalitoEquipoJornadaLayout.createSequentialGroup().addContainerGap().addComponent(this.jPanel5, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane2, -2, 253, -2).addGap(10, 10, 10)));
        this.JTPOpciones.addTab("Asignar Jornada", this.JPAnalitoEquipoJornada);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTPOpciones, -2, -1, -2).addGroup(layout.createSequentialGroup().addComponent(this.JBNuevo, -2, 198, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBGrabar, -2, 213, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBSalir, -2, 186, -2))).addGap(10, 10, 10)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTPOpciones, -2, 415, -2).addGap(10, 10, 10).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBNuevo, -2, 50, -2).addComponent(this.JBGrabar, -2, 50, -2).addComponent(this.JBSalir, -2, 50, -2)).addContainerGap(-1, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        Integer seleccion = Integer.valueOf(this.JTDetalle.getSelectedRow());
        this.idProtocoloEquipo = this.listProtocoloEquipos.get(seleccion.intValue()).getId();
        this.JCBEquipos.setSelectedItem(this.listProtocoloEquipos.get(seleccion.intValue()).getIdEquipo().getNombre());
        this.JTFAbreviatura.setText(this.listProtocoloEquipos.get(seleccion.intValue()).getAbreviatura());
        this.JCEstado.setSelected(this.listProtocoloEquipos.get(seleccion.intValue()).getEstado().booleanValue());
        this.JTFUnidad.setText(this.listProtocoloEquipos.get(seleccion.intValue()).getUnidad());
        this.JCHEsPrincipal.setSelected(this.listProtocoloEquipos.get(seleccion.intValue()).getEsPrincipal().booleanValue());
        this.JSPOrden.setValue(this.listProtocoloEquipos.get(seleccion.intValue()).getOrden());
        this.JCHConsultarJornada.setSelected(this.listProtocoloEquipos.get(seleccion.intValue()).getConsultarJornada().booleanValue());
        mCargadatosJornada();
        this.JTPOpciones.setEnabledAt(1, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBGrabarActionPerformed(ActionEvent evt) {
        mGrabar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBNuevoActionPerformed(ActionEvent evt) {
        mNuevo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBSalirActionPerformed(ActionEvent evt) {
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleJornadaMouseClicked(MouseEvent evt) {
        Integer seleccion = Integer.valueOf(this.JTDetalleJornada.getSelectedRow());
        this.idProtocoloEquipoJornada = this.listProtocolosXEquiposJornada.get(seleccion.intValue()).getId();
        this.JCBDiaSemana.setSelectedItem(this.modeloJornada.getValueAt(this.JTDetalleJornada.getSelectedRow(), 1));
        this.JCHEstadoJornada.setSelected(this.listProtocolosXEquiposJornada.get(seleccion.intValue()).getEstado().booleanValue());
    }

    public void mNuevo() {
        if (this.JTPOpciones.getSelectedIndex() == 0) {
            this.JTPOpciones.setEnabledAt(1, false);
            this.idProtocoloEquipo = 0L;
            mLlenarComboBox();
            mCargadatos();
            this.JCBEquipos.setSelectedIndex(-1);
            this.JCEstado.setSelected(true);
            this.JTFAbreviatura.setText("");
            this.JTFUnidad.setText("");
            this.JCHEsPrincipal.setSelected(false);
            this.JCHConsultarJornada.setSelected(false);
            return;
        }
        this.idProtocoloEquipoJornada = 0L;
        mCargadatosJornada();
        this.JCBDiaSemana.setSelectedIndex(-1);
        this.JCHEstadoJornada.setSelected(true);
    }

    public void mGrabar() {
        if (this.JTPOpciones.getSelectedIndex() != 0) {
            if (this.JTPOpciones.getSelectedIndex() == 1) {
                if (this.JCBDiaSemana.getSelectedIndex() == -1) {
                    this.xmt.mostrarMensaje("Por favor Selecione un dia de la semana");
                    return;
                }
                LProtocolosXEquipos equipos = new LProtocolosXEquipos();
                equipos.setId(this.idProtocoloEquipo);
                LProtocolosXEquiposJornada equiposJornada = new LProtocolosXEquiposJornada();
                equiposJornada.setIdProtocoloEquipo(equipos);
                equiposJornada.setDiaSemana(Integer.valueOf(this.JCBDiaSemana.getSelectedIndex() + 1));
                equiposJornada.setEstado(Boolean.valueOf(this.JCHEstadoJornada.isSelected()));
                equiposJornada.setFecha(this.xmt.getFechaActual().toInstant());
                equiposJornada.setIdUsuario(Principal.usuarioSistemaDTO.getIdUsuarioSistema());
                int n = JOptionPane.showConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (n == 0) {
                    if (this.idProtocoloEquipoJornada.longValue() == 0) {
                        if (this.xmt.mVerificarDatosDoblesTabla(this.JTDetalleJornada, 1, this.JCBDiaSemana.getSelectedItem().toString())) {
                            this.xmt.mostrarMensaje("Ya se encuentra registrado este dia de la semana");
                            return;
                        }
                    } else {
                        equiposJornada.setId(this.idProtocoloEquipoJornada);
                    }
                    this.protocolosXEquiposJornadaService.save(equiposJornada);
                    mNuevo();
                    return;
                }
                return;
            }
            return;
        }
        if (this.JCBEquipos.getSelectedIndex() == -1) {
            this.xmt.mostrarMensaje("Por favor Selecione un Equipo");
            return;
        }
        if (this.JTFAbreviatura.getText().isEmpty()) {
            this.xmt.mostrarMensaje("Por favor Ingrese la Abreviatura");
            return;
        }
        LProtocoloxprocedimiento protocoloxprocedimiento = new LProtocoloxprocedimiento();
        protocoloxprocedimiento.setId(this.idProtocoloProcedimiento);
        LProtocolosXEquipos equipos2 = new LProtocolosXEquipos();
        equipos2.setIdProtocoloProcedimiento(protocoloxprocedimiento);
        equipos2.setIdEquipo(this.listTipoAnalizador.get(this.JCBEquipos.getSelectedIndex()));
        equipos2.setAbreviatura(this.JTFAbreviatura.getText());
        equipos2.setUnidad(this.JTFUnidad.getText());
        equipos2.setEsPrincipal(Boolean.valueOf(this.JCHEsPrincipal.isSelected()));
        equipos2.setConsultarJornada(Boolean.valueOf(this.JCHConsultarJornada.isSelected()));
        equipos2.setOrden(Integer.valueOf(this.JSPOrden.getValue().toString()));
        equipos2.setEstado(Boolean.valueOf(this.JCEstado.isSelected()));
        equipos2.setFecha(this.xmt.getFechaActual().toInstant());
        equipos2.setIdUsuarioS(Principal.usuarioSistemaDTO.getIdUsuarioSistema());
        int n2 = JOptionPane.showConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n2 == 0) {
            if (this.idProtocoloEquipo.longValue() != 0) {
                equipos2.setId(this.idProtocoloEquipo);
            }
            this.protocolosXEquiposService.save(equipos2);
            mNuevo();
        }
    }

    public void mCargadatos() {
        mCrearModelo();
        this.listProtocoloEquipos = this.protocolosXEquiposService.findByidProtocoloProcedimiento(this.idProtocoloProcedimiento);
        if (!this.listProtocoloEquipos.isEmpty()) {
            for (int x = 0; x < this.listProtocoloEquipos.size(); x++) {
                this.xmodelo.addRow(this.xdato);
                this.xmodelo.setValueAt(this.listProtocoloEquipos.get(x).getId(), x, 0);
                this.xmodelo.setValueAt(this.listProtocoloEquipos.get(x).getIdProtocoloProcedimiento().getId(), x, 1);
                this.xmodelo.setValueAt(this.listProtocoloEquipos.get(x).getIdProtocoloProcedimiento().getLProtocolos().getNbre(), x, 2);
                this.xmodelo.setValueAt(this.listProtocoloEquipos.get(x).getIdEquipo().getId(), x, 3);
                this.xmodelo.setValueAt(this.listProtocoloEquipos.get(x).getIdEquipo().getNombre(), x, 4);
                this.xmodelo.setValueAt(this.listProtocoloEquipos.get(x).getAbreviatura(), x, 5);
                this.xmodelo.setValueAt(this.listProtocoloEquipos.get(x).getEstado(), x, 6);
                this.xmodelo.setValueAt(this.listProtocoloEquipos.get(x).getUnidad(), x, 7);
                this.xmodelo.setValueAt(this.listProtocoloEquipos.get(x).getEsPrincipal(), x, 8);
                this.xmodelo.setValueAt(this.listProtocoloEquipos.get(x).getOrden(), x, 9);
                this.xmodelo.setValueAt(this.listProtocoloEquipos.get(x).getConsultarJornada(), x, 10);
            }
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    public void mCrearModelo() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "IdProtocolo", "Protocolo", "idEquipo", "Equipo", "Abreviatura", "Estado", "Unidad", "EsPrincipal", "Orden", "Consultar Jornada"}) { // from class: com.genoma.plus.controller.laboratorio.JDFProtocolosxEquipos.6
            Class[] types = {Integer.class, Integer.class, String.class, Integer.class, String.class, String.class, Boolean.class, String.class, Boolean.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(1).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(1).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(3).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(3).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(100);
    }

    public void mCargadatosJornada() {
        mCrearModeloJornada();
        this.listProtocolosXEquiposJornada = this.protocolosXEquiposJornadaService.findByIdProtocoloEquipoOrderByDiaSemanaAsc(this.listProtocoloEquipos.get(this.JTDetalle.getSelectedRow()));
        if (!this.listProtocolosXEquiposJornada.isEmpty()) {
            for (int x = 0; x < this.listProtocolosXEquiposJornada.size(); x++) {
                this.modeloJornada.addRow(this.xdatoJornada);
                this.modeloJornada.setValueAt(this.listProtocolosXEquiposJornada.get(x).getId(), x, 0);
                this.modeloJornada.setValueAt(this.listDiasSemana.get(this.listProtocolosXEquiposJornada.get(x).getDiaSemana().intValue() - 1), x, 1);
                this.modeloJornada.setValueAt(this.listProtocolosXEquiposJornada.get(x).getEstado(), x, 2);
            }
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    public void mCrearModeloJornada() {
        this.modeloJornada = new DefaultTableModel(new Object[0], new String[]{"Id", "Dia de la Semana", "Estado"}) { // from class: com.genoma.plus.controller.laboratorio.JDFProtocolosxEquipos.7
            Class[] types = {Short.class, Short.class, Boolean.class};
            boolean[] canEdit = {false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalleJornada.setModel(this.modeloJornada);
        this.JTDetalleJornada.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTDetalleJornada.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTDetalleJornada.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTDetalleJornada.getColumnModel().getColumn(1).setPreferredWidth(50);
        this.JTDetalleJornada.getColumnModel().getColumn(2).setPreferredWidth(50);
    }

    public void mLlenarComboBox() {
        this.JCBEquipos.removeAllItems();
        this.listTipoAnalizador = this.tipoAnalizadorService.listAnalizador(true);
        if (!this.listTipoAnalizador.isEmpty()) {
            for (LTipoAnalizador lTipoAnalizador : this.listTipoAnalizador) {
                this.JCBEquipos.addItem(lTipoAnalizador.getNombre());
            }
        }
        this.JCBEquipos.setSelectedIndex(-1);
    }
}
