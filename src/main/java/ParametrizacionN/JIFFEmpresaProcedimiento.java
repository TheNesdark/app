package ParametrizacionN;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

/* JADX INFO: loaded from: GenomaP.jar:ParametrizacionN/JIFFEmpresaProcedimiento.class */
public class JIFFEmpresaProcedimiento extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private DefaultTableModel xmodeloL;
    private Object[] xdatos;
    private String[] xidservicio;
    private String[] xidprocedimiento;
    private boolean xlleno;
    private claseParametrizacionN xclase;
    private ButtonGroup JBGTipo;
    private JComboBox JCBProcedimiento;
    private JComboBox JCBServicio;
    private JCheckBox JCHEstado;
    private JCheckBox JCHSeleccion;
    private JCheckBox JCH_RequiereAutorizacion;
    private JPanel JPDatos;
    private JScrollPane JSPDetalle;
    private JScrollPane JSPLote;
    private JTable JTDetalle;
    private JTextField JTFCodigo;
    private JFormattedTextField JTFFValor;
    private JTable JTLote;
    private JTabbedPane JTTablas;
    private ConsultasMySQL xconsulta = new ConsultasMySQL();
    private Metodos xmetodos = new Metodos();
    private int xestados = 0;
    private int xid = 0;
    private boolean xestadog = false;
    private boolean xlleno1 = false;

    public JIFFEmpresaProcedimiento(claseParametrizacionN xclase) {
        String sql;
        this.xlleno = false;
        initComponents();
        this.xclase = xclase;
        if (Principal.informacionIps.getNombreIps().equals("BIEN ESTAR SALUD BS S.A.S.")) {
            sql = "SELECT f_tiposervicio.Id, f_tiposervicio.Nbre FROM  f_servicioempresaconv INNER JOIN  f_tiposervicio  ON (f_servicioempresaconv.Id_TipoServicio = f_tiposervicio.Id) WHERE (f_servicioempresaconv.Estado =0 AND f_servicioempresaconv.Id_EmpresaConvenio ='" + this.xclase.xjifempresaBienestar.xidempresacont + "') ORDER BY f_tiposervicio.Nbre ASC ";
        } else {
            sql = "SELECT f_tiposervicio.Id, f_tiposervicio.Nbre FROM  f_servicioempresaconv INNER JOIN  f_tiposervicio  ON (f_servicioempresaconv.Id_TipoServicio = f_tiposervicio.Id) WHERE (f_servicioempresaconv.Estado =0 AND f_servicioempresaconv.Id_EmpresaConvenio ='" + this.xclase.xjifempresa.xidempresacont + "') ORDER BY f_tiposervicio.Nbre ASC ";
        }
        this.xidservicio = this.xconsulta.llenarCombo(sql, this.xidservicio, this.JCBServicio);
        this.JCBServicio.setSelectedIndex(-1);
        this.xconsulta.cerrarConexionBd();
        this.xlleno = true;
        mCargarDatosTabla();
        mCrearModeloDatosLote();
    }

    /* JADX WARN: Type inference failed for: r3v44, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v50, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGTipo = new ButtonGroup();
        this.JPDatos = new JPanel();
        this.JCBServicio = new JComboBox();
        this.JCHEstado = new JCheckBox();
        this.JCBProcedimiento = new JComboBox();
        this.JTFFValor = new JFormattedTextField();
        this.JCHSeleccion = new JCheckBox();
        this.JTFCodigo = new JTextField();
        this.JCH_RequiereAutorizacion = new JCheckBox();
        this.JTTablas = new JTabbedPane();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JSPLote = new JScrollPane();
        this.JTLote = new JTable();
        setClosable(true);
        setTitle("PROCEDIMIENTO POR EMPRESA");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifempresaprocedimiento");
        this.JPDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JCBServicio.setFont(new Font("Arial", 1, 12));
        this.JCBServicio.setBorder(BorderFactory.createTitledBorder((Border) null, "Servicios", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBServicio.addItemListener(new ItemListener() { // from class: ParametrizacionN.JIFFEmpresaProcedimiento.1
            public void itemStateChanged(ItemEvent evt) {
                JIFFEmpresaProcedimiento.this.JCBServicioItemStateChanged(evt);
            }
        });
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setForeground(Color.blue);
        this.JCHEstado.setSelected(true);
        this.JCHEstado.setText("Estado");
        this.JCHEstado.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFEmpresaProcedimiento.2
            public void actionPerformed(ActionEvent evt) {
                JIFFEmpresaProcedimiento.this.JCHEstadoActionPerformed(evt);
            }
        });
        this.JCBProcedimiento.setFont(new Font("Arial", 1, 12));
        this.JCBProcedimiento.setBorder(BorderFactory.createTitledBorder((Border) null, "Procedimientos", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBProcedimiento.addItemListener(new ItemListener() { // from class: ParametrizacionN.JIFFEmpresaProcedimiento.3
            public void itemStateChanged(ItemEvent evt) {
                JIFFEmpresaProcedimiento.this.JCBProcedimientoItemStateChanged(evt);
            }
        });
        this.JCBProcedimiento.addFocusListener(new FocusAdapter() { // from class: ParametrizacionN.JIFFEmpresaProcedimiento.4
            public void focusLost(FocusEvent evt) {
                JIFFEmpresaProcedimiento.this.JCBProcedimientoFocusLost(evt);
            }
        });
        this.JTFFValor.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFValor.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFValor.setHorizontalAlignment(0);
        this.JTFFValor.setFont(new Font("Arial", 1, 12));
        this.JTFFValor.setValue(new Integer(0));
        this.JCHSeleccion.setFont(new Font("Arial", 1, 12));
        this.JCHSeleccion.setForeground(Color.blue);
        this.JCHSeleccion.setText("Seleccionar todo");
        this.JCHSeleccion.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFEmpresaProcedimiento.5
            public void actionPerformed(ActionEvent evt) {
                JIFFEmpresaProcedimiento.this.JCHSeleccionActionPerformed(evt);
            }
        });
        this.JTFCodigo.setFont(new Font("Arial", 1, 12));
        this.JTFCodigo.setBorder(BorderFactory.createTitledBorder((Border) null, "Codigo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFCodigo.addFocusListener(new FocusAdapter() { // from class: ParametrizacionN.JIFFEmpresaProcedimiento.6
            public void focusLost(FocusEvent evt) {
                JIFFEmpresaProcedimiento.this.JTFCodigoFocusLost(evt);
            }
        });
        this.JTFCodigo.addKeyListener(new KeyAdapter() { // from class: ParametrizacionN.JIFFEmpresaProcedimiento.7
            public void keyPressed(KeyEvent evt) {
                JIFFEmpresaProcedimiento.this.JTFCodigoKeyPressed(evt);
            }
        });
        this.JCH_RequiereAutorizacion.setFont(new Font("Arial", 1, 12));
        this.JCH_RequiereAutorizacion.setForeground(Color.blue);
        this.JCH_RequiereAutorizacion.setText("Requiere autorización?");
        this.JCH_RequiereAutorizacion.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFEmpresaProcedimiento.8
            public void actionPerformed(ActionEvent evt) {
                JIFFEmpresaProcedimiento.this.JCH_RequiereAutorizacionActionPerformed(evt);
            }
        });
        GroupLayout JPDatosLayout = new GroupLayout(this.JPDatos);
        this.JPDatos.setLayout(JPDatosLayout);
        JPDatosLayout.setHorizontalGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosLayout.createSequentialGroup().addComponent(this.JTFCodigo, -2, 132, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBProcedimiento, -2, 450, -2).addGap(7, 7, 7).addComponent(this.JTFFValor, -2, 155, -2)).addGroup(JPDatosLayout.createSequentialGroup().addComponent(this.JCBServicio, -2, 526, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosLayout.createSequentialGroup().addComponent(this.JCHEstado).addGap(19, 19, 19).addComponent(this.JCHSeleccion)).addComponent(this.JCH_RequiereAutorizacion)))).addContainerGap()));
        JPDatosLayout.setVerticalGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosLayout.createSequentialGroup().addGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JCBServicio, -2, 50, -2).addGroup(JPDatosLayout.createSequentialGroup().addComponent(this.JCH_RequiereAutorizacion).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCHEstado).addComponent(this.JCHSeleccion)))).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBProcedimiento, -2, 50, -2).addComponent(this.JTFFValor, -2, 50, -2).addComponent(this.JTFCodigo, -2, 50, -2)).addGap(11, 11, 11)));
        this.JTTablas.setForeground(Color.red);
        this.JTTablas.setFont(new Font("Arial", 1, 14));
        this.JTTablas.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFFEmpresaProcedimiento.9
            public void mouseClicked(MouseEvent evt) {
                JIFFEmpresaProcedimiento.this.JTTablasMouseClicked(evt);
            }
        });
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalle.setSelectionMode(0);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFFEmpresaProcedimiento.10
            public void mouseClicked(MouseEvent evt) {
                JIFFEmpresaProcedimiento.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.JTTablas.addTab("SIMPLE", this.JSPDetalle);
        this.JTLote.setFont(new Font("Arial", 1, 12));
        this.JTLote.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTLote.setSelectionBackground(Color.white);
        this.JTLote.setSelectionForeground(Color.red);
        this.JSPLote.setViewportView(this.JTLote);
        this.JTTablas.addTab("LOTE", this.JSPLote);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JTTablas).addComponent(this.JPDatos, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPDatos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTTablas, -1, 272, 32767).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            this.JCBServicio.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
            this.JCBProcedimiento.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString());
            this.JTFFValor.setValue(Double.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString()));
            this.JCHEstado.setSelected(Boolean.parseBoolean(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString()));
            if (Boolean.parseBoolean(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString())) {
                this.xestados = 0;
            } else {
                this.xestados = 1;
            }
            this.JCH_RequiereAutorizacion.setSelected(Boolean.parseBoolean(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 4).toString()));
            this.xestadog = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEstadoActionPerformed(ActionEvent evt) {
        if (this.JCHEstado.isSelected()) {
            this.xestados = 0;
        } else {
            this.xestados = 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBServicioItemStateChanged(ItemEvent evt) {
        if (this.JCBServicio.getSelectedIndex() != -1 && this.xlleno) {
            this.xlleno1 = false;
            this.JCBProcedimiento.removeAllItems();
            String sql = "SELECT g_procedimiento.Id, g_procedimiento.Nbre FROM  g_procedimiento INNER JOIN  f_tipoprocedimiento  ON (g_procedimiento.Id_tipoprocedimiento = f_tipoprocedimiento.Id) INNER JOIN  f_tiposervtipoproced  ON (f_tiposervtipoproced.Idtipoprocedimiento = f_tipoprocedimiento.Id) WHERE (f_tiposervtipoproced.Idtiposervicio ='" + this.xidservicio[this.JCBServicio.getSelectedIndex()] + "' AND g_procedimiento.Estado =0) ORDER BY g_procedimiento.Nbre ASC ";
            this.xidprocedimiento = this.xconsulta.llenarCombo(sql, this.xidprocedimiento, this.JCBProcedimiento);
            this.JCBProcedimiento.setSelectedIndex(-1);
            this.JTFCodigo.setText("");
            this.xconsulta.cerrarConexionBd();
            mCargarDatosTablaLote();
            this.xlleno1 = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTTablasMouseClicked(MouseEvent evt) {
        if (this.JTTablas.getSelectedIndex() == 0) {
            this.JCBProcedimiento.setVisible(true);
            this.JTFFValor.setVisible(true);
            this.JCHSeleccion.setVisible(false);
        } else if (this.JTTablas.getSelectedIndex() == 1) {
            this.JCBProcedimiento.setVisible(false);
            this.JTFFValor.setVisible(false);
            this.JCHSeleccion.setVisible(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHSeleccionActionPerformed(ActionEvent evt) {
        if (this.JCHSeleccion.isSelected()) {
            mSeleccionar(true);
        } else {
            mSeleccionar(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCodigoKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10 && this.JCBServicio.getSelectedIndex() != -1 && this.xlleno) {
            this.JCBProcedimiento.requestFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCodigoFocusLost(FocusEvent evt) {
        if (this.JCBServicio.getSelectedIndex() != -1 && this.xlleno) {
            verificarCodProcSum();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBProcedimientoFocusLost(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBProcedimientoItemStateChanged(ItemEvent evt) {
        if (this.JCBProcedimiento.getSelectedIndex() != -1 && this.xlleno1) {
            this.JTFCodigo.setText(this.xidprocedimiento[this.JCBProcedimiento.getSelectedIndex()]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_RequiereAutorizacionActionPerformed(ActionEvent evt) {
    }

    public void verificarCodProcSum() {
        if (getTraerCodigo(this.JTFCodigo.getText(), this.xidservicio[this.JCBServicio.getSelectedIndex()]).equals("")) {
            this.xmetodos.mostrarMensaje("Codigo Incorrecto:\n1.El Codigo No Se Encuentra Relacionado A Este Servicio\n2.El Codigo No Existe\n3.El Codigo De Este Procedimiento Se Encuentre Desactivado");
            this.JCBProcedimiento.setSelectedIndex(-1);
        } else {
            this.JCBProcedimiento.setSelectedItem(getTraerCodigo(this.JTFCodigo.getText(), this.xidservicio[this.JCBServicio.getSelectedIndex()]));
        }
    }

    private String getTraerCodigo(String id, String idTipoServicio) {
        String sql = "SELECT `g_procedimiento`.`Nbre` FROM `g_procedimiento` INNER JOIN `f_tipoprocedimiento` ON (`g_procedimiento`.`Id_tipoprocedimiento` = `f_tipoprocedimiento`.`Id`)\nINNER JOIN `f_tiposervtipoproced` ON (`f_tiposervtipoproced`.`Idtipoprocedimiento` = `f_tipoprocedimiento`.`Id`) INNER JOIN `f_tiposervicio` ON (`f_tiposervtipoproced`.`Idtiposervicio` = `f_tiposervicio`.`Id`)\nWHERE (g_procedimiento.Id ='" + id + "' AND `f_tiposervtipoproced`.`Idtiposervicio` ='" + idTipoServicio + "')";
        String sql2 = this.xconsulta.traerDato(sql);
        this.xconsulta.cerrarConexionBd();
        return sql2;
    }

    private void mSeleccionar(boolean xestado) {
        if (this.JTLote.getRowCount() != 0) {
            for (int i = 0; i < this.JTLote.getRowCount(); i++) {
                this.xmodeloL.setValueAt(Boolean.valueOf(xestado), i, 2);
            }
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Servicio", "Procedimiento", "Valor", "Estado", "Autorización"}) { // from class: ParametrizacionN.JIFFEmpresaProcedimiento.11
            Class[] types = {String.class, String.class, Double.class, Boolean.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setAutoResizeMode(0);
        this.JTDetalle.doLayout();
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(500);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(100);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatosLote() {
        this.xmodeloL = new DefaultTableModel(new Object[0], new String[]{"Id", "Procedimiento", "Seleccionar"}) { // from class: ParametrizacionN.JIFFEmpresaProcedimiento.12
            Class[] types = {Long.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTLote.setModel(this.xmodeloL);
        this.JTLote.getColumnModel().getColumn(0).setPreferredWidth(30);
        this.JTLote.getColumnModel().getColumn(1).setPreferredWidth(500);
        this.JTLote.getColumnModel().getColumn(2).setPreferredWidth(30);
    }

    private void mCargarDatosTablaLote() {
        try {
            mCrearModeloDatosLote();
            String sql = "SELECT `g_procedimiento`.`Id`, `g_procedimiento`.`Nbre` AS `NProcedimiento` FROM `g_procedimiento` INNER JOIN `f_tipoprocedimiento` ON (`g_procedimiento`.`Id_tipoprocedimiento` = `f_tipoprocedimiento`.`Id`)\nINNER JOIN `f_tiposervtipoproced` ON (`f_tiposervtipoproced`.`Idtipoprocedimiento` = `f_tipoprocedimiento`.`Id`) INNER JOIN `f_tiposervicio` ON (`f_tiposervtipoproced`.`Idtiposervicio` = `f_tiposervicio`.`Id`)\nWHERE (`f_tiposervtipoproced`.`Idtiposervicio` ='" + this.xidservicio[this.JCBServicio.getSelectedIndex()] + "') ORDER BY `NProcedimiento` ASC;";
            ResultSet xrs = this.xconsulta.traerRs(sql);
            Throwable th = null;
            try {
                try {
                    if (xrs.next()) {
                        xrs.beforeFirst();
                        int n = 0;
                        while (xrs.next()) {
                            this.xmodeloL.addRow(this.xdatos);
                            this.xmodeloL.setValueAt(Long.valueOf(xrs.getLong(1)), n, 0);
                            this.xmodeloL.setValueAt(xrs.getString(2), n, 1);
                            this.xmodeloL.setValueAt(false, n, 2);
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
                    this.xconsulta.cerrarConexionBd();
                } finally {
                }
            } catch (Throwable th3) {
                th = th3;
                throw th3;
            }
        } catch (SQLException ex) {
            Logger.getLogger(JIFFEmpresaProcedimiento.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarDatosTabla() {
        String sql;
        try {
            mCrearModeloDatos();
            if (Principal.informacionIps.getNombreIps().equals("BIEN ESTAR SALUD BS S.A.S.")) {
                sql = "SELECT f_tiposervicio.Nbre, g_procedimiento.Nbre, f_procedempresaconvenio.Valor, f_procedempresaconvenio.Estado, f_procedempresaconvenio.autorizacion FROM  f_procedempresaconvenio INNER JOIN  g_procedimiento  ON (f_procedempresaconvenio.Id_Procedimiento = g_procedimiento.Id) INNER JOIN  f_tipoprocedimiento  ON (g_procedimiento.Id_tipoprocedimiento = f_tipoprocedimiento.Id) INNER JOIN  f_tiposervtipoproced  ON (f_tiposervtipoproced.Idtipoprocedimiento = f_tipoprocedimiento.Id) INNER JOIN  f_tiposervicio  ON (f_tiposervtipoproced.Idtiposervicio = f_tiposervicio.Id) WHERE (f_procedempresaconvenio.Id_EmpresacontxConv ='" + this.xclase.xjifempresaBienestar.xidempresacont + "') ORDER BY f_tiposervicio.Nbre ASC, g_procedimiento.Nbre ASC ";
            } else {
                sql = "SELECT f_tiposervicio.Nbre, g_procedimiento.Nbre, f_procedempresaconvenio.Valor, f_procedempresaconvenio.Estado, f_procedempresaconvenio.autorizacion FROM  f_procedempresaconvenio INNER JOIN  g_procedimiento  ON (f_procedempresaconvenio.Id_Procedimiento = g_procedimiento.Id) INNER JOIN  f_tipoprocedimiento  ON (g_procedimiento.Id_tipoprocedimiento = f_tipoprocedimiento.Id) INNER JOIN  f_tiposervtipoproced  ON (f_tiposervtipoproced.Idtipoprocedimiento = f_tipoprocedimiento.Id) INNER JOIN  f_tiposervicio  ON (f_tiposervtipoproced.Idtiposervicio = f_tiposervicio.Id) WHERE (f_procedempresaconvenio.Id_EmpresacontxConv ='" + this.xclase.xjifempresa.xidempresacont + "') ORDER BY f_tiposervicio.Nbre ASC, g_procedimiento.Nbre ASC ";
            }
            ResultSet xrs = this.xconsulta.traerRs(sql);
            Throwable th = null;
            try {
                try {
                    if (xrs.next()) {
                        xrs.beforeFirst();
                        int n = 0;
                        while (xrs.next()) {
                            this.xmodelo.addRow(this.xdatos);
                            this.xmodelo.setValueAt(xrs.getString(1), n, 0);
                            this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                            this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(3)), n, 2);
                            this.xmodelo.setValueAt(Boolean.valueOf(!xrs.getBoolean(4)), n, 3);
                            this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean("autorizacion")), n, 4);
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
                    this.xconsulta.cerrarConexionBd();
                } finally {
                }
            } catch (Throwable th3) {
                th = th3;
                throw th3;
            }
        } catch (SQLException ex) {
            Logger.getLogger(JIFFEmpresaProcedimiento.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mNuevo() {
        this.JCBServicio.setSelectedIndex(-1);
        this.JCBProcedimiento.setSelectedIndex(-1);
        this.JTFCodigo.setText("");
        this.JCHEstado.setSelected(true);
        this.JTFFValor.setValue(new Integer(0));
        this.xestados = 0;
        this.xestadog = false;
    }

    public void mGrabar() {
        String sql;
        String sql2;
        if (this.JTTablas.getSelectedIndex() == 0) {
            if (this.JCBServicio.getSelectedIndex() != -1) {
                if (this.JCBProcedimiento.getSelectedIndex() != -1) {
                    int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    if (x == 0) {
                        int estado = this.JCH_RequiereAutorizacion.isSelected() ? 1 : 0;
                        if (!this.xestadog) {
                            if (!mVerificarDatosDoblesTabla(this.JTDetalle, 0, this.JCBServicio.getSelectedItem().toString(), 1, this.JCBProcedimiento.getSelectedItem().toString())) {
                                if (Principal.informacionIps.getNombreIps().equals("BIEN ESTAR SALUD BS S.A.S.")) {
                                    sql2 = "insert into f_procedempresaconvenio (Id_Procedimiento, Id_EmpresacontxConv, Valor, Estado, autorizacion,  Fecha, UsuarioS) values ('" + this.xidprocedimiento[this.JCBProcedimiento.getSelectedIndex()] + "','" + this.xclase.xjifempresaBienestar.xidempresacont + "','" + this.JTFFValor.getValue() + "','" + this.xestados + "','" + estado + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                                } else {
                                    sql2 = "insert into f_procedempresaconvenio (Id_Procedimiento, Id_EmpresacontxConv, Valor, Estado, autorizacion,Fecha, UsuarioS) values ('" + this.xidprocedimiento[this.JCBProcedimiento.getSelectedIndex()] + "','" + this.xclase.xjifempresa.xidempresacont + "','" + this.JTFFValor.getValue() + "','" + this.xestados + "','" + estado + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                                }
                                this.xconsulta.ejecutarSQL(sql2);
                                this.xconsulta.cerrarConexionBd();
                            } else {
                                JOptionPane.showInternalMessageDialog(this, "Esta configuracion de Servicio y Procedimiento ya se encuentra registrada", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                            }
                        } else {
                            if (Principal.informacionIps.getNombreIps().equals("BIEN ESTAR SALUD BS S.A.S.")) {
                                sql = "update f_procedempresaconvenio set Estado='" + this.xestados + "', Valor='" + this.JTFFValor.getValue() + "', autorizacion='" + estado + "' where Id_Procedimiento='" + this.xidprocedimiento[this.JCBProcedimiento.getSelectedIndex()] + "' and Id_EmpresacontxConv='" + this.xclase.xjifempresaBienestar.xidempresacont + "'";
                            } else {
                                sql = "update f_procedempresaconvenio set Estado='" + this.xestados + "', Valor='" + this.JTFFValor.getValue() + "', autorizacion='" + estado + "' where Id_Procedimiento='" + this.xidprocedimiento[this.JCBProcedimiento.getSelectedIndex()] + "' and Id_EmpresacontxConv='" + this.xclase.xjifempresa.xidempresacont + "'";
                            }
                            this.xconsulta.ejecutarSQL(sql);
                            this.xconsulta.cerrarConexionBd();
                        }
                    }
                } else {
                    JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un procedimiento", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    this.JCBProcedimiento.requestFocus();
                }
            } else {
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un servicio", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JCBServicio.requestFocus();
            }
        } else if (this.JTTablas.getSelectedIndex() == 1) {
            if (this.JCBServicio.getSelectedIndex() != -1) {
                int x2 = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (x2 == 0 && this.JTLote.getRowCount() != 0) {
                    int estado2 = this.JCH_RequiereAutorizacion.isSelected() ? 1 : 0;
                    for (int i = 0; i < this.JTLote.getRowCount(); i++) {
                        if (Boolean.valueOf(this.xmodeloL.getValueAt(i, 2).toString()).booleanValue()) {
                            String sql3 = "insert into f_procedempresaconvenio (Id_Procedimiento, Id_EmpresacontxConv, autorizacion, Fecha, UsuarioS) values ('" + this.xmodeloL.getValueAt(i, 0) + "','" + this.xclase.xjifempresa.xidempresacont + "','" + estado2 + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                            this.xconsulta.ejecutarSQL(sql3);
                            this.xconsulta.cerrarConexionBd();
                        }
                    }
                }
            } else {
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un servicio", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JCBServicio.requestFocus();
            }
        }
        mCargarDatosTabla();
        mCargarDatosTablaLote();
    }

    public boolean mVerificarDatosDoblesTabla(JTable xjtabla, int xpos1, String xvalor, int xpos2, String xvalor1) {
        boolean estado = false;
        if (xjtabla.getRowCount() > 0) {
            int i = 0;
            while (true) {
                if (i < xjtabla.getRowCount()) {
                    if (!xjtabla.getValueAt(i, xpos1).toString().equals(xvalor) || !xjtabla.getValueAt(i, xpos2).toString().equals(xvalor1)) {
                        i++;
                    } else {
                        estado = true;
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        return estado;
    }
}
