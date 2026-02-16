package com.genoma.plus.controller.presupuesto;

import Acceso.Principal;
import Utilidades.Metodos;
import com.genoma.plus.dao.impl.presupuesto.ParametrizacionCGRDAOImpl;
import com.genoma.plus.dao.presupuesto.ParametrizacionCGRDAO;
import com.genoma.plus.dto.presupuesto.ParametrizacionCGRDTO;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/presupuesto/JDParametrizacionCGR.class */
public class JDParametrizacionCGR extends JDialog {
    private ParametrizacionCGRDAO xParametrizacionCGRDAO;
    private DefaultTableModel xmodelo;
    private Object[] xdatos;
    private int[] id;
    private int[] idTipovigencia;
    private int[] idTiporecursos;
    private int[] idTipoSituacion;
    private String idRubro;
    public int idFinalidad;
    public int idTipoDestino;
    public int idorigenIngreso;
    private int xGuardado;
    private int idP;
    private Metodos metodos;
    private String idEncabezado;
    private JButton JBGuardar;
    private JComboBox<String> JCBTipoRecursos;
    private JComboBox<String> JCBTipoSituacion;
    private JComboBox<String> JCBTipoVigencia;
    private JCheckBox JCHEstado;
    private JTable JTDetalle;
    public JTextField JTFFinalidadGasto;
    public JTextField JTFOrigenIngreso;
    private JTextField JTFRubro;
    public JTextField JTFRubroContraloria;
    public JTextField JTFTipoDestino;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JScrollPane jScrollPane1;

    public JDParametrizacionCGR(Frame parent, boolean modal, String idRubro, String idEncabezado) {
        super(parent, false);
        this.idFinalidad = 0;
        this.idTipoDestino = 0;
        this.idorigenIngreso = 0;
        this.xGuardado = 0;
        this.metodos = new Metodos();
        initComponents();
        setLocationRelativeTo(null);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        sprintStart();
        System.out.println("idRubro-->" + idRubro);
        this.idRubro = idRubro;
        inicializarCombos();
        this.idEncabezado = idEncabezado;
        mNuevo();
    }

    private void sprintStart() {
        this.xParametrizacionCGRDAO = (ParametrizacionCGRDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("ParametrizacionCGRDAO");
    }

    /* JADX WARN: Type inference failed for: r3v55, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jPanel1 = new JPanel();
        this.JCHEstado = new JCheckBox();
        this.JTFRubro = new JTextField();
        this.JTFRubroContraloria = new JTextField();
        this.JCBTipoRecursos = new JComboBox<>();
        this.JCBTipoSituacion = new JComboBox<>();
        this.JCBTipoVigencia = new JComboBox<>();
        this.JTFOrigenIngreso = new JTextField();
        this.JTFFinalidadGasto = new JTextField();
        this.JTFTipoDestino = new JTextField();
        this.jPanel2 = new JPanel();
        this.jScrollPane1 = new JScrollPane();
        this.JTDetalle = new JTable();
        this.jPanel3 = new JPanel();
        this.JBGuardar = new JButton();
        setDefaultCloseOperation(2);
        setTitle("ParametrizacionCGR");
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACION", 2, 0, new Font("Arial", 1, 12), new Color(0, 103, 0)));
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setForeground(Color.blue);
        this.JCHEstado.setText("Estado");
        this.JTFRubro.setFont(new Font("Arial", 1, 12));
        this.JTFRubro.setBorder(BorderFactory.createTitledBorder((Border) null, "Rubro", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRubro.setEnabled(false);
        this.JTFRubroContraloria.setFont(new Font("Arial", 1, 12));
        this.JTFRubroContraloria.setBorder(BorderFactory.createTitledBorder((Border) null, "Rubro Contraloria", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRubroContraloria.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.presupuesto.JDParametrizacionCGR.1
            public void mouseClicked(MouseEvent evt) {
                JDParametrizacionCGR.this.JTFRubroContraloriaMouseClicked(evt);
            }
        });
        this.JCBTipoRecursos.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Recursos", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTipoSituacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Situacion", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTipoVigencia.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Vigencia", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFOrigenIngreso.setBorder(BorderFactory.createTitledBorder((Border) null, "Origen Ingreso", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFOrigenIngreso.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.presupuesto.JDParametrizacionCGR.2
            public void mouseClicked(MouseEvent evt) {
                JDParametrizacionCGR.this.JTFOrigenIngresoMouseClicked(evt);
            }
        });
        this.JTFFinalidadGasto.setBorder(BorderFactory.createTitledBorder((Border) null, "Finalidad Gasto", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFinalidadGasto.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.presupuesto.JDParametrizacionCGR.3
            public void mouseClicked(MouseEvent evt) {
                JDParametrizacionCGR.this.JTFFinalidadGastoMouseClicked(evt);
            }
        });
        this.JTFTipoDestino.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Destino", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFTipoDestino.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.presupuesto.JDParametrizacionCGR.4
            public void mouseClicked(MouseEvent evt) {
                JDParametrizacionCGR.this.JTFTipoDestinoMouseClicked(evt);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(20, 20, 20).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JCBTipoVigencia, 0, 155, 32767).addComponent(this.JTFRubro)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTFRubroContraloria).addComponent(this.JTFOrigenIngreso, -1, 134, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBTipoRecursos, 0, -1, 32767).addComponent(this.JTFFinalidadGasto)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTFTipoDestino).addComponent(this.JCBTipoSituacion, 0, 185, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHEstado).addGap(24, 24, 24)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTFRubro).addComponent(this.JTFRubroContraloria).addComponent(this.JCBTipoRecursos).addComponent(this.JCBTipoSituacion)).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.JCHEstado))).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JCBTipoVigencia).addComponent(this.JTFOrigenIngreso).addComponent(this.JTFFinalidadGasto).addComponent(this.JTFTipoDestino)).addGap(0, 0, 32767)));
        this.jPanel2.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 12), new Color(0, 103, 0)));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setSelectionBackground(Color.white);
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.presupuesto.JDParametrizacionCGR.5
            public void mouseClicked(MouseEvent evt) {
                JDParametrizacionCGR.this.JTDetalleMouseClicked(evt);
            }
        });
        this.jScrollPane1.setViewportView(this.JTDetalle);
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane1, GroupLayout.Alignment.TRAILING, -1, 798, 32767));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane1, -1, 249, 32767));
        this.JBGuardar.setFont(new Font("Arial", 1, 12));
        this.JBGuardar.setForeground(Color.blue);
        this.JBGuardar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ok29x27.png")));
        this.JBGuardar.setText("Grabar");
        this.JBGuardar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.presupuesto.JDParametrizacionCGR.6
            public void actionPerformed(ActionEvent evt) {
                JDParametrizacionCGR.this.JBGuardarActionPerformed(evt);
            }
        });
        GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
        this.jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JBGuardar, GroupLayout.Alignment.TRAILING, -1, -1, 32767));
        jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addComponent(this.JBGuardar, -1, 48, 32767).addContainerGap()));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel3, -1, -1, 32767).addComponent(this.jPanel1, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addComponent(this.jPanel2, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(5, 5, 5).addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel3, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel2, -1, -1, 32767).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRubroContraloriaMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JDRubrosContraloria JD = new JDRubrosContraloria(null, true, this);
            JD.setVisible(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFOrigenIngresoMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JDGenerico JDG = new JDGenerico(null, true, this, 1);
            JDG.setVisible(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFinalidadGastoMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JDGenerico JDG = new JDGenerico(null, true, this, 2);
            JDG.setVisible(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFTipoDestinoMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JDGenerico JDG = new JDGenerico(null, true, this, 3);
            JDG.setVisible(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            this.idP = ((Integer) this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0)).intValue();
            this.JTFRubro.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString());
            this.JTFRubroContraloria.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString());
            this.JTFOrigenIngreso.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 9).toString());
            this.JTFFinalidadGasto.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 12).toString());
            this.JTFTipoDestino.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 15).toString());
            this.JCBTipoRecursos.setSelectedIndex(traerPosicionId(((Integer) this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 5)).intValue(), this.idTiporecursos));
            this.JCBTipoSituacion.setSelectedIndex(traerPosicionId(((Integer) this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 17)).intValue(), this.idTipoSituacion));
            this.JCBTipoVigencia.setSelectedIndex(traerPosicionId(((Integer) this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 20)).intValue(), this.idTipovigencia));
            this.idorigenIngreso = Integer.parseInt(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 8).toString());
            this.idTipoDestino = Integer.parseInt(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 14).toString());
            this.idFinalidad = Integer.parseInt(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 11).toString());
            this.xGuardado = 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBGuardarActionPerformed(ActionEvent evt) {
        mGuardar();
    }

    public int traerPosicionId(int id, int[] arr) {
        int pos = 0;
        for (int x = 0; x < arr.length; x++) {
            if (arr[x] == id) {
                pos = x;
            }
        }
        return pos;
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModelo() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "IdRubro", "CodigoRubro", "Codigo RubroC", "RubroC", "IdTipoRecursos", "Condigo R", "TipoRecurso", "IdOrigenIngreso", "codigo Origen", "OrigenIngreso", "IdFinGasto", "Codigo Finalidad", "Finalidad Gasto", "idTipoDestinacion", "Codigo Destinacion", "Tipo Destinacion", "IdTipoSituacion", "Codigo Situacion", "TipoSituacion", "IdTipoVigencia", "Codigo Vigencia", "TipoVigencia", "Estado"}) { // from class: com.genoma.plus.controller.presupuesto.JDParametrizacionCGR.7
            Class[] types = {Integer.class, String.class, String.class, String.class, Integer.class, String.class, String.class, Integer.class, String.class, String.class, Integer.class, String.class, String.class, Integer.class, String.class, String.class, Integer.class, String.class, String.class, Integer.class, String.class, String.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

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
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(70);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(2).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(2).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(90);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(120);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(5).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(5).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(6).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(6).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(8).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(8).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(70);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(180);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(11).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(11).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(12).setPreferredWidth(180);
        this.JTDetalle.getColumnModel().getColumn(13).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(14).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(14).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(14).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(15).setPreferredWidth(70);
        this.JTDetalle.getColumnModel().getColumn(16).setPreferredWidth(180);
        this.JTDetalle.getColumnModel().getColumn(17).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(17).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(17).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(18).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(18).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(18).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(19).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(20).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(20).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(20).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(21).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(21).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(21).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(22).setPreferredWidth(120);
        this.JTDetalle.getColumnModel().getColumn(23).setPreferredWidth(70);
    }

    private void mCargarDatos() {
        mCrearModelo();
        List<Object[]> listaParametrizacionCGR = this.xParametrizacionCGRDAO.listaParametrizacionCGR(this.idRubro, this.idEncabezado);
        for (int x = 0; x < listaParametrizacionCGR.size(); x++) {
            this.xmodelo.addRow(this.xdatos);
            for (int j = 0; j < 24; j++) {
                this.xmodelo.setValueAt(listaParametrizacionCGR.get(x)[j], x, j);
            }
        }
    }

    public void mNuevo() {
        mCargarDatos();
        this.JTFFinalidadGasto.setText("");
        this.JTFOrigenIngreso.setText("");
        this.JTFRubroContraloria.setText("");
        this.JTFTipoDestino.setText("");
        this.JCBTipoRecursos.setSelectedIndex(-1);
        this.JCBTipoSituacion.setSelectedIndex(-1);
        this.JCBTipoVigencia.setSelectedIndex(-1);
        this.JCHEstado.setSelected(true);
    }

    public void inicializarCombos() {
        this.idTiporecursos = llenarCombox(this.JCBTipoRecursos, "SELECT `Id`,`Nombre` FROM `pp_tipo_recursos`;");
        this.idTipoSituacion = llenarCombox(this.JCBTipoSituacion, "SELECT `Id`,`Nombre` FROM `pp_tipo_situacion`;");
        this.idTipovigencia = llenarCombox(this.JCBTipoVigencia, "SELECT `Id`,`Nombre` FROM `pp_tipo_vigencia`;");
        this.JCBTipoRecursos.setSelectedIndex(-1);
        this.JCBTipoSituacion.setSelectedIndex(-1);
        this.JCBTipoVigencia.setSelectedIndex(-1);
        this.JTFRubro.setText(this.idRubro);
    }

    public int[] llenarCombox(JComboBox jc, String sql) {
        List<Object[]> listaResultado = this.xParametrizacionCGRDAO.listaCombo(sql);
        this.id = new int[listaResultado.size()];
        for (int x = 0; x < listaResultado.size(); x++) {
            this.id[x] = ((Integer) listaResultado.get(x)[0]).intValue();
            jc.addItem(listaResultado.get(x)[1]);
        }
        return this.id;
    }

    public void mGuardar() {
        if (!this.JTFRubroContraloria.getText().isEmpty()) {
            if (!this.JTFOrigenIngreso.getText().isEmpty()) {
                if (!this.JTFFinalidadGasto.getText().isEmpty()) {
                    if (!this.JTFTipoDestino.getText().isEmpty()) {
                        if (this.JCBTipoRecursos.getSelectedIndex() != -1) {
                            if (this.JCBTipoSituacion.getSelectedIndex() != -1) {
                                if (this.JCBTipoVigencia.getSelectedIndex() != -1) {
                                    System.out.println("JTDetalle.getRowCount()==0-->" + this.JTDetalle.getRowCount());
                                    int n = JOptionPane.showConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                                    if (n == 0) {
                                        ParametrizacionCGRDTO parametrizacionCGR = new ParametrizacionCGRDTO();
                                        parametrizacionCGR.setIdRubro(this.idRubro);
                                        parametrizacionCGR.setIdFinGasto(this.idFinalidad);
                                        parametrizacionCGR.setIdTipoDestinacion(this.idTipoDestino);
                                        parametrizacionCGR.setIdOrigenIngreso(this.idorigenIngreso);
                                        parametrizacionCGR.setIdTipoRecurso(this.idTiporecursos[this.JCBTipoRecursos.getSelectedIndex()]);
                                        parametrizacionCGR.setIdTipoVigencia(this.idTipovigencia[this.JCBTipoVigencia.getSelectedIndex()]);
                                        parametrizacionCGR.setIdTipoSituacion(this.idTipoSituacion[this.JCBTipoSituacion.getSelectedIndex()]);
                                        parametrizacionCGR.setIdRubroContraloria(this.JTFRubroContraloria.getText());
                                        parametrizacionCGR.setIdUsuario(Principal.usuarioSistemaDTO.getIdUsuarioSistema().toString());
                                        parametrizacionCGR.setEstado(this.JCHEstado.isSelected());
                                        System.out.println("xGuardado-->" + this.xGuardado);
                                        if (this.xGuardado == 0) {
                                            if (this.JTDetalle.getRowCount() == 0) {
                                                System.out.println("guarda-->" + this.xGuardado);
                                                this.xParametrizacionCGRDAO.mCreate(parametrizacionCGR);
                                            } else {
                                                this.metodos.mostrarMensaje("No puede guardar una nueva cuenta, por favor actualice la que ya existe");
                                            }
                                        } else {
                                            parametrizacionCGR.setId(this.idP);
                                            System.out.println("actualiza-->" + this.xGuardado);
                                            this.xParametrizacionCGRDAO.mUpdate(parametrizacionCGR);
                                        }
                                        this.xGuardado = 0;
                                        mNuevo();
                                        return;
                                    }
                                    return;
                                }
                                this.metodos.mostrarMensaje("El campo Tipo vigencia  debe ser selecionado ");
                                return;
                            }
                            this.metodos.mostrarMensaje("El campo Tipo Situacion debe ser selecionado");
                            return;
                        }
                        this.metodos.mostrarMensaje("El campo Tipo recursos debe ser selecionado");
                        return;
                    }
                    this.metodos.mostrarMensaje("El campo Tipo Destinacion no puede ser vacio ");
                    return;
                }
                this.metodos.mostrarMensaje("El campo finalidad gasto no puede ser vacio ");
                return;
            }
            this.metodos.mostrarMensaje("El campo origen ingreso no puede ser vacio ");
            return;
        }
        this.metodos.mostrarMensaje("El campo rubro contraloria no puede ser vacio ");
    }
}
