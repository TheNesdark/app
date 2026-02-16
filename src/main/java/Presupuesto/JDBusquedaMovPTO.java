package Presupuesto;

import Acceso.Principal;
import Contabilidad.JIFRadicacion;
import Contabilidad.JIFSolicitudReembolsoCMV2;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.genoma.plus.jpa.entities.CcRadicacionCompromiso;
import com.genoma.plus.jpa.entities.PpMovimiento;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Presupuesto/JDBusquedaMovPTO.class */
public class JDBusquedaMovPTO extends JDialog {
    private DefaultTableModel xmodelo;
    private ConsultasMySQL xct;
    private Metodos xmt;
    private Object[] xdatos;
    private JIFFMovimiento xJIFFMovimiento;
    private JIFRadicacion xJIFRadicacion;
    private String xTipoDoc;
    private String xId_Tercero;
    private String xNombre;
    private String[] xIdTipDoc;
    private JIFFMovManualOP_PP xJIFFMovManualOP_PP;
    private JIFSolicitudReembolsoCMV2 jIFSolicitudReembolsoCMV2;
    private JIFCompromisoPresupuestal jifcompromisopresupuestal;
    private JButton JBConsultar;
    private ButtonGroup JBGEstado;
    private ButtonGroup JBGFiltro;
    private JButton JBT_Grabar;
    private JButton JBT_Salir;
    private JComboBox JCTipoDoc;
    private JRadioButton JRBActivos;
    private JRadioButton JRBAnulados;
    private JTextField JTConsecutivo;
    private JTable JTDetalle;
    private JRadioButton filtro;
    private JPanel jPanel1;
    private JScrollPane jScrollPane2;
    private JRadioButton todos;

    public JDBusquedaMovPTO(Frame parent, boolean modal, JIFFMovimiento xJIFFMovimiento, String xTipoDoc) {
        this.xct = new ConsultasMySQL();
        this.xmt = new Metodos();
        this.xId_Tercero = "0";
        initComponents();
        setTitle("BÚSQUEDA DE MOVIMIENTOS");
        this.xNombre = xJIFFMovimiento.getName();
        this.xTipoDoc = xTipoDoc;
        System.out.println("xTipoDoc-->" + xTipoDoc);
        this.xJIFFMovimiento = xJIFFMovimiento;
        String sql = null;
        if (xTipoDoc.equals("4")) {
            sql = "SELECT `Id`, `Nbre` FROM `pp_tipo_documentos` WHERE Estado=1 AND pp_tipo_documentos.Id_ClaseDoc=4 ORDER BY Nbre ASC";
        } else if (xTipoDoc.equals("9")) {
            sql = "SELECT `Id`, `Nbre` FROM `pp_tipo_documentos` WHERE Estado=1 AND pp_tipo_documentos.Id_ClaseDoc=9 ORDER BY Nbre ASC";
        }
        this.xIdTipDoc = this.xct.llenarCombo(sql, this.xIdTipDoc, this.JCTipoDoc);
        this.JCTipoDoc.setSelectedIndex(-1);
        this.xct.cerrarConexionBd();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        mBuscaDatos();
    }

    public JDBusquedaMovPTO(Frame parent, boolean modal, JIFFMovManualOP_PP xJIFFMovimiento, String xTipoDoc) {
        super(parent, "BÚSQUEDA DE MOVIMIENTOS", modal);
        this.xct = new ConsultasMySQL();
        this.xmt = new Metodos();
        this.xId_Tercero = "0";
        initComponents();
        this.xNombre = xJIFFMovimiento.getName();
        this.xTipoDoc = xTipoDoc;
        System.out.println("xTipoDoc-->" + xTipoDoc);
        setLocationRelativeTo(null);
        this.xJIFFMovManualOP_PP = xJIFFMovimiento;
        String sql = null;
        if (xTipoDoc.equals("5")) {
            sql = "SELECT `Id`, `Nbre` FROM `pp_tipo_documentos` WHERE Estado=1 AND pp_tipo_documentos.Id_ClaseDoc=5 ORDER BY Nbre ASC";
        } else if (xTipoDoc.equals("6")) {
            sql = "SELECT `Id`, `Nbre` FROM `pp_tipo_documentos` WHERE Estado=1 AND pp_tipo_documentos.Id_ClaseDoc=6 ORDER BY Nbre ASC";
        }
        this.xIdTipDoc = this.xct.llenarCombo(sql, this.xIdTipDoc, this.JCTipoDoc);
        this.JCTipoDoc.setSelectedIndex(-1);
        this.xct.cerrarConexionBd();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        mBuscaDatos();
    }

    public JDBusquedaMovPTO(Frame parent, boolean modal, JIFRadicacion xJIFFMovimiento, String xTipoDoc, String xId_Tercero) {
        super(parent, "BÚSQUEDA DE MOVIMIENTOS", modal);
        this.xct = new ConsultasMySQL();
        this.xmt = new Metodos();
        this.xId_Tercero = "0";
        initComponents();
        this.xTipoDoc = xTipoDoc;
        this.xId_Tercero = xId_Tercero;
        this.xNombre = xJIFFMovimiento.getName();
        setLocationRelativeTo(null);
        this.xJIFRadicacion = xJIFFMovimiento;
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        mBuscaDatosCompromisoRadicacion();
    }

    public JDBusquedaMovPTO(Frame parent, boolean modal, JIFSolicitudReembolsoCMV2 xJIFFMovimiento, String xTipoDoc, String xId_Tercero) {
        super(parent, "BÚSQUEDA DE MOVIMIENTOS", modal);
        this.xct = new ConsultasMySQL();
        this.xmt = new Metodos();
        this.xId_Tercero = "0";
        initComponents();
        this.xTipoDoc = xTipoDoc;
        this.xId_Tercero = xId_Tercero;
        this.xNombre = xJIFFMovimiento.getName();
        setLocationRelativeTo(null);
        this.jIFSolicitudReembolsoCMV2 = xJIFFMovimiento;
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        mBuscarCompromisoCierre();
    }

    public JDBusquedaMovPTO(Frame parent, boolean modal, JIFCompromisoPresupuestal jifcompromiso, String xTipoDoc) {
        super(parent, "BÚSQUEDA DE MOVIMIENTOS", modal);
        this.xct = new ConsultasMySQL();
        this.xmt = new Metodos();
        this.xId_Tercero = "0";
        initComponents();
        this.xTipoDoc = xTipoDoc;
        this.xNombre = jifcompromiso.getName();
        setLocationRelativeTo(null);
        this.jifcompromisopresupuestal = jifcompromiso;
        this.xIdTipDoc = this.xct.llenarCombo("SELECT `Id`, `Nbre` FROM `pp_tipo_documentos` WHERE Estado=1 AND pp_tipo_documentos.Id_ClaseDoc=4 ORDER BY Nbre ASC", this.xIdTipDoc, this.JCTipoDoc);
        this.JCTipoDoc.setSelectedIndex(-1);
        this.xct.cerrarConexionBd();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        mBuscaDatos();
    }

    /* JADX WARN: Type inference failed for: r3v35, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGFiltro = new ButtonGroup();
        this.JBGEstado = new ButtonGroup();
        this.jPanel1 = new JPanel();
        this.JCTipoDoc = new JComboBox();
        this.JTConsecutivo = new JTextField();
        this.JBConsultar = new JButton();
        this.filtro = new JRadioButton();
        this.todos = new JRadioButton();
        this.jScrollPane2 = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JRBAnulados = new JRadioButton();
        this.JRBActivos = new JRadioButton();
        this.JBT_Grabar = new JButton();
        this.JBT_Salir = new JButton();
        setDefaultCloseOperation(2);
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "FILTROS", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JCTipoDoc.setFont(new Font("Arial", 1, 12));
        this.JCTipoDoc.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Documento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTConsecutivo.setFont(new Font("Arial", 1, 12));
        this.JTConsecutivo.setBorder(BorderFactory.createTitledBorder((Border) null, "No. Consecutivo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBConsultar.setFont(new Font("Arial", 1, 12));
        this.JBConsultar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/lupa.png")));
        this.JBConsultar.setText("Consultar");
        this.JBConsultar.addActionListener(new ActionListener() { // from class: Presupuesto.JDBusquedaMovPTO.1
            public void actionPerformed(ActionEvent evt) {
                JDBusquedaMovPTO.this.JBConsultarActionPerformed(evt);
            }
        });
        this.JBGFiltro.add(this.filtro);
        this.filtro.setFont(new Font("Arial", 1, 12));
        this.filtro.setText("Filtro");
        this.JBGFiltro.add(this.todos);
        this.todos.setFont(new Font("Arial", 1, 12));
        this.todos.setText("Todos");
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.JCTipoDoc, -2, 321, -2).addGap(18, 18, 18).addComponent(this.JTConsecutivo, -2, 134, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBConsultar).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.filtro).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.todos).addContainerGap(22, 32767)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JBConsultar, -1, -1, 32767).addGroup(jPanel1Layout.createSequentialGroup().addGap(0, 0, 32767).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.filtro).addComponent(this.todos))).addComponent(this.JTConsecutivo).addComponent(this.JCTipoDoc)).addGap(23, 23, 23)));
        this.jScrollPane2.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: Presupuesto.JDBusquedaMovPTO.2
            public void mouseClicked(MouseEvent evt) {
                JDBusquedaMovPTO.this.JTDetalleMouseClicked(evt);
            }
        });
        this.jScrollPane2.setViewportView(this.JTDetalle);
        this.JBGEstado.add(this.JRBAnulados);
        this.JRBAnulados.setFont(new Font("Arial", 1, 12));
        this.JRBAnulados.setText("Anulados");
        this.JRBAnulados.addActionListener(new ActionListener() { // from class: Presupuesto.JDBusquedaMovPTO.3
            public void actionPerformed(ActionEvent evt) {
                JDBusquedaMovPTO.this.JRBAnuladosActionPerformed(evt);
            }
        });
        this.JBGEstado.add(this.JRBActivos);
        this.JRBActivos.setFont(new Font("Arial", 1, 12));
        this.JRBActivos.setSelected(true);
        this.JRBActivos.setText("Activos");
        this.JRBActivos.addActionListener(new ActionListener() { // from class: Presupuesto.JDBusquedaMovPTO.4
            public void actionPerformed(ActionEvent evt) {
                JDBusquedaMovPTO.this.JRBActivosActionPerformed(evt);
            }
        });
        this.JBT_Grabar.setFont(new Font("Arial", 1, 12));
        this.JBT_Grabar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Grabar29x27.png")));
        this.JBT_Grabar.setText("Grabar");
        this.JBT_Grabar.addActionListener(new ActionListener() { // from class: Presupuesto.JDBusquedaMovPTO.5
            public void actionPerformed(ActionEvent evt) {
                JDBusquedaMovPTO.this.JBT_GrabarActionPerformed(evt);
            }
        });
        this.JBT_Salir.setFont(new Font("Arial", 1, 12));
        this.JBT_Salir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.JBT_Salir.setText("Salir");
        this.JBT_Salir.addActionListener(new ActionListener() { // from class: Presupuesto.JDBusquedaMovPTO.6
            public void actionPerformed(ActionEvent evt) {
                JDBusquedaMovPTO.this.JBT_SalirActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -1, -1, 32767).addComponent(this.jScrollPane2, GroupLayout.Alignment.TRAILING, -1, 775, 32767)).addContainerGap()).addGroup(layout.createSequentialGroup().addComponent(this.JBT_Grabar, -2, 270, -2).addGap(32, 32, 32).addComponent(this.JBT_Salir, -2, 270, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JRBActivos).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBAnulados).addGap(10, 10, 10)))));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jScrollPane2, -2, 315, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBT_Grabar, -2, 50, -2).addComponent(this.JBT_Salir, -2, 50, -2).addComponent(this.JRBActivos).addComponent(this.JRBAnulados)).addContainerGap(11, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getRowCount() > 0 && evt.getClickCount() == 2) {
            switch (this.xNombre) {
                case "xjifMovimientoPPTO":
                    Principal.txtNo.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
                    if (this.xTipoDoc.equals("9")) {
                        this.xJIFFMovimiento.JLB_Registro.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
                        this.xJIFFMovimiento.xMovimiento = this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 5).toString();
                        this.xJIFFMovimiento.mBuscaMovimiento(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 6).toString());
                    } else if (this.xTipoDoc.equals("4")) {
                        this.xJIFFMovimiento.JLB_Registro.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
                        this.xJIFFMovimiento.xMovimiento = this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 5).toString();
                        System.out.println("IdCompromiso 5-->" + this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 5).toString());
                        this.xJIFFMovimiento.mBuscaMovimiento(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 5).toString());
                    }
                    dispose();
                    break;
                case "jifMovManualOP_PP":
                    Principal.txtNo.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
                    this.xJIFFMovManualOP_PP.xidMovimiento = this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 5).toString();
                    this.xJIFFMovManualOP_PP.mBuscaDetalleObligacion();
                    dispose();
                    break;
                case "jifSolicitudReembolso2":
                    this.jIFSolicitudReembolsoCMV2.JLCodigoDoc1.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
                    this.jIFSolicitudReembolsoCMV2.idCompromiso = Long.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 5).toString());
                    dispose();
                    break;
                case "jifradicacionfac":
                    if (Double.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 10).toString()).doubleValue() > 0.0d) {
                        this.xmodelo.setValueAt(true, this.JTDetalle.getSelectedRow(), 12);
                        break;
                    } else {
                        this.xmodelo.setValueAt(false, this.JTDetalle.getSelectedRow(), 12);
                        JOptionPane.showMessageDialog(this, "Compromiso sin valor por obligar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        break;
                    }
                    break;
                case "jifcompromisopresupuestal":
                    Principal.txtNo.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 5).toString());
                    this.jifcompromisopresupuestal.JLB_Registro.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
                    this.jifcompromisopresupuestal.movimiento = this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 5).toString();
                    this.jifcompromisopresupuestal.cargarCompromisoGrabado(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 5).toString(), this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString(), this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
                    dispose();
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBConsultarActionPerformed(ActionEvent evt) {
        if (this.filtro.isSelected()) {
            if (this.JCTipoDoc.getSelectedIndex() > -1 || !this.JTConsecutivo.getText().equals("")) {
                mBuscaDatosFiltrados();
                return;
            } else {
                JOptionPane.showMessageDialog(this, "No tiene Filtros para consultar");
                return;
            }
        }
        mBuscaDatos();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBActivosActionPerformed(ActionEvent evt) {
        mBuscaDatos();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBAnuladosActionPerformed(ActionEvent evt) {
        mBuscaDatos();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_GrabarActionPerformed(ActionEvent evt) {
        cargarDetetalleCompromiso();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_SalirActionPerformed(ActionEvent evt) {
        dispose();
    }

    private void cargarDetetalleCompromiso() {
        if (this.xNombre.equals("jifradicacionfac")) {
            if (this.xmt.mVerificarDatosTablaTrue(this.JTDetalle, 12)) {
                this.xJIFRadicacion.radicacionCompromisos = new ArrayList();
                List<Long> idConsecutivo = new ArrayList<>();
                List<CcRadicacionCompromiso> list = new ArrayList<>();
                for (int x = 0; x < this.JTDetalle.getRowCount(); x++) {
                    if (Boolean.valueOf(this.JTDetalle.getValueAt(x, 12).toString()).booleanValue()) {
                        this.xJIFRadicacion.JTAConceptoC.setText(this.xmodelo.getValueAt(x, 4).toString());
                        idConsecutivo.add(Long.valueOf(this.xmodelo.getValueAt(x, 0).toString()));
                        this.xJIFRadicacion.xIDCompromiso = Long.valueOf(this.xmodelo.getValueAt(x, 1).toString()).longValue();
                        CcRadicacionCompromiso radicacionCompromiso = new CcRadicacionCompromiso();
                        PpMovimiento movimiento = new PpMovimiento();
                        movimiento.setId(Long.valueOf(this.xmodelo.getValueAt(x, 1).toString()));
                        radicacionCompromiso.setEstado(true);
                        radicacionCompromiso.setFecha(this.xmt.getFechaActual());
                        radicacionCompromiso.setIdMovimiento(movimiento);
                        radicacionCompromiso.setIdUsuarioRh(Principal.usuarioSistemaDTO.getIdPersonaCargo());
                        list.add(radicacionCompromiso);
                    }
                }
                this.xJIFRadicacion.setListaCompromisos(list);
                this.xJIFRadicacion.JLCodigoDoc1.setText("" + idConsecutivo);
                dispose();
                return;
            }
            JOptionPane.showMessageDialog(this, "Debe selecccionar compromiso", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Cod.", "Fecha", "Documento", "Observación", "Estado", "Id", "IdDisponibilidad", "Seleccionar"}) { // from class: Presupuesto.JDBusquedaMovPTO.7
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, true};

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
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(5).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(5).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(6).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(6).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(100);
    }

    private void mBuscaDatos() {
        String sql;
        mCrearModeloDatos();
        sql = null;
        switch (this.xNombre) {
            case "xjifMovimientoPPTO":
            case "jifcompromisopresupuestal":
                if (this.xTipoDoc.equals("4")) {
                    if (this.JRBActivos.isSelected()) {
                        sql = "SELECT pp_movimiento.NoConcecutivo, `pp_movimiento`.`Id`, `pp_movimiento`.`FechaD`, `pp_tipo_documentos`.`Nbre` AS Documento, `pp_movimiento`.`Observacion`, `g_motivoanulacion`.`Nbre` AS Anulacion, pp_movimiento.IdDisponibilidad \n FROM `pp_movimiento` INNER JOIN   `pp_tipo_documentos`  ON (`pp_movimiento`.`Id_TipoDoc` = `pp_tipo_documentos`.`Id`)\n    INNER JOIN   `g_motivoanulacion`  ON (`pp_movimiento`.`Id_MotivoAnulacion` = `g_motivoanulacion`.`Id`)\n  WHERE (pp_tipo_documentos.`Id_ClaseDoc`=4 AND pp_movimiento.`Id_MotivoAnulacion`= 1 AND DATE_FORMAT(`pp_movimiento`.`FechaD`,'%Y')='" + Principal.informacionGeneralPrincipalDTO.getAnoPresupuesto() + "') ORDER BY `pp_movimiento`.`Id`DESC, `pp_movimiento`.`FechaD` DESC ";
                    } else if (this.JRBAnulados.isSelected()) {
                        sql = "SELECT pp_movimiento.NoConcecutivo, `pp_movimiento`.`Id`, `pp_movimiento`.`FechaD`, `pp_tipo_documentos`.`Nbre` AS Documento, `pp_movimiento`.`Observacion`, `g_motivoanulacion`.`Nbre` AS Anulacion, pp_movimiento.IdDisponibilidad \n FROM `pp_movimiento` INNER JOIN   `pp_tipo_documentos`  ON (`pp_movimiento`.`Id_TipoDoc` = `pp_tipo_documentos`.`Id`)\n    INNER JOIN   `g_motivoanulacion`  ON (`pp_movimiento`.`Id_MotivoAnulacion` = `g_motivoanulacion`.`Id`)\n  WHERE (pp_tipo_documentos.`Id_ClaseDoc`=4 AND pp_movimiento.`Id_MotivoAnulacion`<> 1 AND DATE_FORMAT(`pp_movimiento`.`FechaD`,'%Y')='" + Principal.informacionGeneralPrincipalDTO.getAnoPresupuesto() + "') ORDER BY `pp_movimiento`.`Id`DESC, `pp_movimiento`.`FechaD` DESC ";
                    }
                    break;
                } else {
                    if (this.xTipoDoc.equals("9")) {
                        if (this.JRBActivos.isSelected()) {
                            sql = "SELECT pp_movimiento.NoConcecutivo, `pp_movimiento`.`Id`, `pp_movimiento`.`FechaD`, `pp_tipo_documentos`.`Nbre` AS Documento, `pp_movimiento`.`Observacion`, `g_motivoanulacion`.`Nbre` AS Anulacion, pp_movimiento.IdDisponibilidad  \n FROM `pp_movimiento` INNER JOIN   `pp_tipo_documentos`  ON (`pp_movimiento`.`Id_TipoDoc` = `pp_tipo_documentos`.`Id`)\n    INNER JOIN   `g_motivoanulacion`  ON (`pp_movimiento`.`Id_MotivoAnulacion` = `g_motivoanulacion`.`Id`)\n  WHERE (pp_tipo_documentos.`Id_ClaseDoc`=9 AND pp_movimiento.`Id_MotivoAnulacion`= 1 AND DATE_FORMAT(`pp_movimiento`.`FechaD`,'%Y')='" + Principal.informacionGeneralPrincipalDTO.getAnoPresupuesto() + "') ORDER BY `pp_movimiento`.`Id`DESC, `pp_movimiento`.`FechaD` DESC ";
                        } else if (this.JRBAnulados.isSelected()) {
                            sql = "SELECT pp_movimiento.NoConcecutivo, `pp_movimiento`.`Id`, `pp_movimiento`.`FechaD`, `pp_tipo_documentos`.`Nbre` AS Documento, `pp_movimiento`.`Observacion`, `g_motivoanulacion`.`Nbre` AS Anulacion, pp_movimiento.IdDisponibilidad  \n FROM `pp_movimiento` INNER JOIN   `pp_tipo_documentos`  ON (`pp_movimiento`.`Id_TipoDoc` = `pp_tipo_documentos`.`Id`)\n    INNER JOIN   `g_motivoanulacion`  ON (`pp_movimiento`.`Id_MotivoAnulacion` = `g_motivoanulacion`.`Id`)\n  WHERE (pp_tipo_documentos.`Id_ClaseDoc`=9 AND pp_movimiento.`Id_MotivoAnulacion`<> 1 AND DATE_FORMAT(`pp_movimiento`.`FechaD`,'%Y')='" + Principal.informacionGeneralPrincipalDTO.getAnoPresupuesto() + "') ORDER BY `pp_movimiento`.`Id`DESC, `pp_movimiento`.`FechaD` DESC ";
                        }
                    }
                    break;
                }
                break;
            case "jifMovManualOP_PP":
                if (this.xTipoDoc.equals("5")) {
                    if (this.JRBActivos.isSelected()) {
                        sql = "SELECT pp_movimiento.NoConcecutivo, `pp_movimiento`.`Id`, `pp_movimiento`.`FechaD`, `pp_tipo_documentos`.`Nbre` AS Documento, `pp_movimiento`.`Observacion`, `g_motivoanulacion`.`Nbre` AS Anulacion, pp_movimiento.IdDisponibilidad \n FROM `pp_movimiento` INNER JOIN   `pp_tipo_documentos`  ON (`pp_movimiento`.`Id_TipoDoc` = `pp_tipo_documentos`.`Id`)\n    INNER JOIN   `g_motivoanulacion`  ON (`pp_movimiento`.`Id_MotivoAnulacion` = `g_motivoanulacion`.`Id`)\n  WHERE (pp_tipo_documentos.`Id_ClaseDoc`=5 AND pp_movimiento.`Id_MotivoAnulacion`= 1 AND DATE_FORMAT(`pp_movimiento`.`FechaD`,'%Y')='" + Principal.informacionGeneralPrincipalDTO.getAnoPresupuesto() + "') ORDER BY `pp_movimiento`.`Id`DESC, `pp_movimiento`.`FechaD` DESC ";
                    } else if (this.JRBAnulados.isSelected()) {
                        sql = "SELECT pp_movimiento.NoConcecutivo, `pp_movimiento`.`Id`, `pp_movimiento`.`FechaD`, `pp_tipo_documentos`.`Nbre` AS Documento, `pp_movimiento`.`Observacion`, `g_motivoanulacion`.`Nbre` AS Anulacion, pp_movimiento.IdDisponibilidad \n FROM `pp_movimiento` INNER JOIN   `pp_tipo_documentos`  ON (`pp_movimiento`.`Id_TipoDoc` = `pp_tipo_documentos`.`Id`)\n    INNER JOIN   `g_motivoanulacion`  ON (`pp_movimiento`.`Id_MotivoAnulacion` = `g_motivoanulacion`.`Id`)\n  WHERE (pp_tipo_documentos.`Id_ClaseDoc`=5 AND pp_movimiento.`Id_MotivoAnulacion`<> 1 AND DATE_FORMAT(`pp_movimiento`.`FechaD`,'%Y')='" + Principal.informacionGeneralPrincipalDTO.getAnoPresupuesto() + "') ORDER BY `pp_movimiento`.`Id`DESC, `pp_movimiento`.`FechaD` DESC ";
                    }
                    break;
                } else {
                    if (this.xTipoDoc.equals("6")) {
                        if (this.JRBActivos.isSelected()) {
                            sql = "SELECT pp_movimiento.NoConcecutivo, `pp_movimiento`.`Id`, `pp_movimiento`.`FechaD`, `pp_tipo_documentos`.`Nbre` AS Documento, `pp_movimiento`.`Observacion`, `g_motivoanulacion`.`Nbre` AS Anulacion, pp_movimiento.IdDisponibilidad  \n FROM `pp_movimiento` INNER JOIN   `pp_tipo_documentos`  ON (`pp_movimiento`.`Id_TipoDoc` = `pp_tipo_documentos`.`Id`)\n    INNER JOIN   `g_motivoanulacion`  ON (`pp_movimiento`.`Id_MotivoAnulacion` = `g_motivoanulacion`.`Id`)\n  WHERE (pp_tipo_documentos.`Id_ClaseDoc`=6 AND pp_movimiento.`Id_MotivoAnulacion`= 1 AND DATE_FORMAT(`pp_movimiento`.`FechaD`,'%Y')='" + Principal.informacionGeneralPrincipalDTO.getAnoPresupuesto() + "') ORDER BY `pp_movimiento`.`Id`DESC, `pp_movimiento`.`FechaD` DESC ";
                        } else if (this.JRBAnulados.isSelected()) {
                            sql = "SELECT pp_movimiento.NoConcecutivo, `pp_movimiento`.`Id`, `pp_movimiento`.`FechaD`, `pp_tipo_documentos`.`Nbre` AS Documento, `pp_movimiento`.`Observacion`, `g_motivoanulacion`.`Nbre` AS Anulacion, pp_movimiento.IdDisponibilidad  \n FROM `pp_movimiento` INNER JOIN   `pp_tipo_documentos`  ON (`pp_movimiento`.`Id_TipoDoc` = `pp_tipo_documentos`.`Id`)\n    INNER JOIN   `g_motivoanulacion`  ON (`pp_movimiento`.`Id_MotivoAnulacion` = `g_motivoanulacion`.`Id`)\n  WHERE (pp_tipo_documentos.`Id_ClaseDoc`=6 AND pp_movimiento.`Id_MotivoAnulacion`<> 1 AND DATE_FORMAT(`pp_movimiento`.`FechaD`,'%Y')='" + Principal.informacionGeneralPrincipalDTO.getAnoPresupuesto() + "') ORDER BY `pp_movimiento`.`Id`DESC, `pp_movimiento`.`FechaD` DESC ";
                        }
                    }
                    break;
                }
                break;
            default:
                if (this.JRBActivos.isSelected()) {
                    sql = "SELECT pp_movimiento.NoConcecutivo, `pp_movimiento`.`Id`, `pp_movimiento`.`FechaD`, `pp_tipo_documentos`.`Nbre` AS Documento, `pp_movimiento`.`Observacion`, `g_motivoanulacion`.`Nbre` AS Anulacion, pp_movimiento.IdDisponibilidad \nFROM `pp_movimiento` INNER JOIN   `pp_tipo_documentos`  ON (`pp_movimiento`.`Id_TipoDoc` = `pp_tipo_documentos`.`Id`)\nINNER JOIN   `pp_detalle_movimiento`  ON (`pp_movimiento`.`Id` = `pp_detalle_movimiento`.`Id_Movimiento`)\nINNER JOIN   `g_motivoanulacion`  ON (`pp_movimiento`.`Id_MotivoAnulacion` = `g_motivoanulacion`.`Id`)\nWHERE (pp_tipo_documentos.`Id_ClaseDoc`=4 AND pp_detalle_movimiento.`Id_Tercero`='" + this.xId_Tercero + "' AND pp_movimiento.`Id_MotivoAnulacion`=1 AND pp_detalle_movimiento.idEncabezado='" + Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro() + "' AND DATE_FORMAT(`pp_movimiento`.`FechaD`,'%Y')='" + Principal.informacionGeneralPrincipalDTO.getAnoPresupuesto() + "') \nORDER BY `pp_movimiento`.`Id`DESC, `pp_movimiento`.`FechaD` DESC ";
                    break;
                } else {
                    if (this.JRBAnulados.isSelected()) {
                        sql = "SELECT pp_movimiento.NoConcecutivo, `pp_movimiento`.`Id`, `pp_movimiento`.`FechaD`, `pp_tipo_documentos`.`Nbre` AS Documento, `pp_movimiento`.`Observacion`, `g_motivoanulacion`.`Nbre` AS Anulacion, pp_movimiento.IdDisponibilidad \nFROM `pp_movimiento` INNER JOIN   `pp_tipo_documentos`  ON (`pp_movimiento`.`Id_TipoDoc` = `pp_tipo_documentos`.`Id`)\nINNER JOIN   `pp_detalle_movimiento`  ON (`pp_movimiento`.`Id` = `pp_detalle_movimiento`.`Id_Movimiento`)\nINNER JOIN   `g_motivoanulacion`  ON (`pp_movimiento`.`Id_MotivoAnulacion` = `g_motivoanulacion`.`Id`)\nWHERE (pp_tipo_documentos.`Id_ClaseDoc`=4 AND pp_detalle_movimiento.`Id_Tercero`='" + this.xId_Tercero + "' AND pp_movimiento.`Id_MotivoAnulacion`<> 1 AND pp_detalle_movimiento.idEncabezado='" + Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro() + "' AND DATE_FORMAT(`pp_movimiento`.`FechaD`,'%Y')='" + Principal.informacionGeneralPrincipalDTO.getAnoPresupuesto() + "') \nORDER BY `pp_movimiento`.`Id`DESC, `pp_movimiento`.`FechaD` DESC ";
                    }
                    break;
                }
                break;
        }
        System.out.println("Movimientos-->" + sql);
        ResultSet xrsB = this.xct.traerRs(sql);
        int n = 0;
        try {
            if (xrsB.next()) {
                xrsB.beforeFirst();
                while (xrsB.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(xrsB.getString("NoConcecutivo"), n, 0);
                    this.xmodelo.setValueAt(xrsB.getString("FechaD"), n, 1);
                    this.xmodelo.setValueAt(xrsB.getString("Documento"), n, 2);
                    this.xmodelo.setValueAt(xrsB.getString("Observacion"), n, 3);
                    this.xmodelo.setValueAt(xrsB.getString("Anulacion"), n, 4);
                    this.xmodelo.setValueAt(xrsB.getString("Id"), n, 5);
                    this.xmodelo.setValueAt(xrsB.getString("IdDisponibilidad"), n, 6);
                    this.xmodelo.setValueAt(false, n, 7);
                    n++;
                }
            }
            xrsB.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JDBusquedaMovPTO.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mBuscaDatosFiltrados() {
        String sql;
        mCrearModeloDatos();
        sql = null;
        switch (this.xNombre) {
            case "xjifMovimientoPPTO":
                if (this.xTipoDoc.equals("4")) {
                    if (this.JCTipoDoc.getSelectedIndex() > -1 && !this.JTConsecutivo.getText().equals("")) {
                        sql = "SELECT pp_movimiento.NoConcecutivo, `pp_movimiento`.`Id`, `pp_movimiento`.`FechaD`, `pp_tipo_documentos`.`Nbre` AS Documento, `pp_movimiento`.`Observacion`, `g_motivoanulacion`.`Nbre` AS Anulacion, pp_movimiento.IdDisponibilidad \n FROM `pp_movimiento` INNER JOIN   `pp_tipo_documentos`  ON (`pp_movimiento`.`Id_TipoDoc` = `pp_tipo_documentos`.`Id`)\n    INNER JOIN   `g_motivoanulacion`  ON (`pp_movimiento`.`Id_MotivoAnulacion` = `g_motivoanulacion`.`Id`)\n  WHERE (pp_tipo_documentos.`Id_ClaseDoc`=4 AND pp_tipo_documentos.Id='" + this.xIdTipDoc[this.JCTipoDoc.getSelectedIndex()] + "' AND pp_movimiento.NoConcecutivo='" + this.JTConsecutivo.getText() + "' AND DATE_FORMAT(`pp_movimiento`.`FechaD`,'%Y')='" + Principal.informacionGeneralPrincipalDTO.getAnoPresupuesto() + "') ORDER BY `pp_movimiento`.`Id`DESC, `pp_movimiento`.`FechaD` DESC ";
                    } else if (this.JCTipoDoc.getSelectedIndex() > -1 && this.JTConsecutivo.getText().equals("")) {
                        sql = "SELECT pp_movimiento.NoConcecutivo, `pp_movimiento`.`Id`, `pp_movimiento`.`FechaD`, `pp_tipo_documentos`.`Nbre` AS Documento, `pp_movimiento`.`Observacion`, `g_motivoanulacion`.`Nbre` AS Anulacion, pp_movimiento.IdDisponibilidad \n FROM `pp_movimiento` INNER JOIN   `pp_tipo_documentos`  ON (`pp_movimiento`.`Id_TipoDoc` = `pp_tipo_documentos`.`Id`)\n    INNER JOIN   `g_motivoanulacion`  ON (`pp_movimiento`.`Id_MotivoAnulacion` = `g_motivoanulacion`.`Id`)\n  WHERE (pp_tipo_documentos.`Id_ClaseDoc`=4 AND pp_tipo_documentos.Id='" + this.xIdTipDoc[this.JCTipoDoc.getSelectedIndex()] + "' AND DATE_FORMAT(`pp_movimiento`.`FechaD`,'%Y')='" + Principal.informacionGeneralPrincipalDTO.getAnoPresupuesto() + "') ORDER BY `pp_movimiento`.`Id`DESC, `pp_movimiento`.`FechaD` DESC ";
                    } else if (this.JCTipoDoc.getSelectedIndex() == -1 && !this.JTConsecutivo.getText().equals("")) {
                        sql = "SELECT pp_movimiento.NoConcecutivo, `pp_movimiento`.`Id`, `pp_movimiento`.`FechaD`, `pp_tipo_documentos`.`Nbre` AS Documento, `pp_movimiento`.`Observacion`, `g_motivoanulacion`.`Nbre` AS Anulacion, pp_movimiento.IdDisponibilidad \n FROM `pp_movimiento` INNER JOIN   `pp_tipo_documentos`  ON (`pp_movimiento`.`Id_TipoDoc` = `pp_tipo_documentos`.`Id`)\n    INNER JOIN   `g_motivoanulacion`  ON (`pp_movimiento`.`Id_MotivoAnulacion` = `g_motivoanulacion`.`Id`)\n  WHERE (pp_tipo_documentos.`Id_ClaseDoc`=4 AND pp_movimiento.NoConcecutivo='" + this.JTConsecutivo.getText() + "') ORDER BY `pp_movimiento`.`Id`DESC, `pp_movimiento`.`FechaD` DESC ";
                    }
                    break;
                } else {
                    if (this.xTipoDoc.equals("9")) {
                        if (this.JCTipoDoc.getSelectedIndex() > -1 && !this.JTConsecutivo.getText().equals("")) {
                            sql = "SELECT pp_movimiento.NoConcecutivo, `pp_movimiento`.`Id`, `pp_movimiento`.`FechaD`, `pp_tipo_documentos`.`Nbre` AS Documento, `pp_movimiento`.`Observacion`, `g_motivoanulacion`.`Nbre` AS Anulacion, pp_movimiento.IdDisponibilidad  \n FROM `pp_movimiento` INNER JOIN   `pp_tipo_documentos`  ON (`pp_movimiento`.`Id_TipoDoc` = `pp_tipo_documentos`.`Id`)\n    INNER JOIN   `g_motivoanulacion`  ON (`pp_movimiento`.`Id_MotivoAnulacion` = `g_motivoanulacion`.`Id`)\n  WHERE (pp_tipo_documentos.`Id_ClaseDoc`=9 AND pp_tipo_documentos.Id='" + this.xIdTipDoc[this.JCTipoDoc.getSelectedIndex()] + "' AND pp_movimiento.NoConcecutivo='" + this.JTConsecutivo.getText() + "' AND DATE_FORMAT(`pp_movimiento`.`FechaD`,'%Y')='" + Principal.informacionGeneralPrincipalDTO.getAnoPresupuesto() + "') ORDER BY `pp_movimiento`.`Id`DESC, `pp_movimiento`.`FechaD` DESC ";
                        } else if (this.JCTipoDoc.getSelectedIndex() > -1 && this.JTConsecutivo.getText().equals("")) {
                            sql = "SELECT pp_movimiento.NoConcecutivo, `pp_movimiento`.`Id`, `pp_movimiento`.`FechaD`, `pp_tipo_documentos`.`Nbre` AS Documento, `pp_movimiento`.`Observacion`, `g_motivoanulacion`.`Nbre` AS Anulacion, pp_movimiento.IdDisponibilidad  \n FROM `pp_movimiento` INNER JOIN   `pp_tipo_documentos`  ON (`pp_movimiento`.`Id_TipoDoc` = `pp_tipo_documentos`.`Id`)\n    INNER JOIN   `g_motivoanulacion`  ON (`pp_movimiento`.`Id_MotivoAnulacion` = `g_motivoanulacion`.`Id`)\n  WHERE (pp_tipo_documentos.`Id_ClaseDoc`=9 AND pp_tipo_documentos.Id='" + this.xIdTipDoc[this.JCTipoDoc.getSelectedIndex()] + "') ORDER BY `pp_movimiento`.`Id`DESC, `pp_movimiento`.`FechaD` DESC ";
                        } else if (this.JCTipoDoc.getSelectedIndex() == -1 && !this.JTConsecutivo.getText().equals("")) {
                            sql = "SELECT pp_movimiento.NoConcecutivo, `pp_movimiento`.`Id`, `pp_movimiento`.`FechaD`, `pp_tipo_documentos`.`Nbre` AS Documento, `pp_movimiento`.`Observacion`, `g_motivoanulacion`.`Nbre` AS Anulacion, pp_movimiento.IdDisponibilidad  \n FROM `pp_movimiento` INNER JOIN   `pp_tipo_documentos`  ON (`pp_movimiento`.`Id_TipoDoc` = `pp_tipo_documentos`.`Id`)\n    INNER JOIN   `g_motivoanulacion`  ON (`pp_movimiento`.`Id_MotivoAnulacion` = `g_motivoanulacion`.`Id`)\n  WHERE (pp_tipo_documentos.`Id_ClaseDoc`=9  AND pp_movimiento.NoConcecutivo='" + this.JTConsecutivo.getText() + "' AND DATE_FORMAT(`pp_movimiento`.`FechaD`,'%Y')='" + Principal.informacionGeneralPrincipalDTO.getAnoPresupuesto() + "') ORDER BY `pp_movimiento`.`Id`DESC, `pp_movimiento`.`FechaD` DESC ";
                        }
                    }
                    break;
                }
                break;
            case "jifMovManualOP_PP":
                if (this.xTipoDoc.equals("5")) {
                    if (this.JCTipoDoc.getSelectedIndex() > -1 && !this.JTConsecutivo.getText().equals("")) {
                        sql = "SELECT pp_movimiento.NoConcecutivo, `pp_movimiento`.`Id`, `pp_movimiento`.`FechaD`, `pp_tipo_documentos`.`Nbre` AS Documento, `pp_movimiento`.`Observacion`, `g_motivoanulacion`.`Nbre` AS Anulacion, pp_movimiento.IdDisponibilidad \n FROM `pp_movimiento` INNER JOIN   `pp_tipo_documentos`  ON (`pp_movimiento`.`Id_TipoDoc` = `pp_tipo_documentos`.`Id`)\n    INNER JOIN   `g_motivoanulacion`  ON (`pp_movimiento`.`Id_MotivoAnulacion` = `g_motivoanulacion`.`Id`)\n  WHERE (pp_tipo_documentos.`Id_ClaseDoc`=5 AND pp_tipo_documentos.Id='" + this.xIdTipDoc[this.JCTipoDoc.getSelectedIndex()] + "' AND pp_movimiento.NoConcecutivo='" + this.JTConsecutivo.getText() + "' AND DATE_FORMAT(`pp_movimiento`.`FechaD`,'%Y')='" + Principal.informacionGeneralPrincipalDTO.getAnoPresupuesto() + "') ORDER BY `pp_movimiento`.`Id`DESC, `pp_movimiento`.`FechaD` DESC ";
                    } else if (this.JCTipoDoc.getSelectedIndex() > -1 && this.JTConsecutivo.getText().equals("")) {
                        sql = "SELECT pp_movimiento.NoConcecutivo, `pp_movimiento`.`Id`, `pp_movimiento`.`FechaD`, `pp_tipo_documentos`.`Nbre` AS Documento, `pp_movimiento`.`Observacion`, `g_motivoanulacion`.`Nbre` AS Anulacion, pp_movimiento.IdDisponibilidad \n FROM `pp_movimiento` INNER JOIN   `pp_tipo_documentos`  ON (`pp_movimiento`.`Id_TipoDoc` = `pp_tipo_documentos`.`Id`)\n    INNER JOIN   `g_motivoanulacion`  ON (`pp_movimiento`.`Id_MotivoAnulacion` = `g_motivoanulacion`.`Id`)\n  WHERE (pp_tipo_documentos.`Id_ClaseDoc`=5 AND pp_tipo_documentos.Id='" + this.xIdTipDoc[this.JCTipoDoc.getSelectedIndex()] + "' AND DATE_FORMAT(`pp_movimiento`.`FechaD`,'%Y')='" + Principal.informacionGeneralPrincipalDTO.getAnoPresupuesto() + "') ORDER BY `pp_movimiento`.`Id`DESC, `pp_movimiento`.`FechaD` DESC ";
                    } else if (this.JCTipoDoc.getSelectedIndex() == -1 && !this.JTConsecutivo.getText().equals("")) {
                        sql = "SELECT pp_movimiento.NoConcecutivo, `pp_movimiento`.`Id`, `pp_movimiento`.`FechaD`, `pp_tipo_documentos`.`Nbre` AS Documento, `pp_movimiento`.`Observacion`, `g_motivoanulacion`.`Nbre` AS Anulacion, pp_movimiento.IdDisponibilidad \n FROM `pp_movimiento` INNER JOIN   `pp_tipo_documentos`  ON (`pp_movimiento`.`Id_TipoDoc` = `pp_tipo_documentos`.`Id`)\n    INNER JOIN   `g_motivoanulacion`  ON (`pp_movimiento`.`Id_MotivoAnulacion` = `g_motivoanulacion`.`Id`)\n  WHERE (pp_tipo_documentos.`Id_ClaseDoc`=5 AND pp_movimiento.NoConcecutivo='" + this.JTConsecutivo.getText() + "') ORDER BY `pp_movimiento`.`Id`DESC, `pp_movimiento`.`FechaD` DESC ";
                    }
                    break;
                } else {
                    if (this.xTipoDoc.equals("6")) {
                        if (this.JCTipoDoc.getSelectedIndex() > -1 && !this.JTConsecutivo.getText().equals("")) {
                            sql = "SELECT pp_movimiento.NoConcecutivo, `pp_movimiento`.`Id`, `pp_movimiento`.`FechaD`, `pp_tipo_documentos`.`Nbre` AS Documento, `pp_movimiento`.`Observacion`, `g_motivoanulacion`.`Nbre` AS Anulacion, pp_movimiento.IdDisponibilidad  \n FROM `pp_movimiento` INNER JOIN   `pp_tipo_documentos`  ON (`pp_movimiento`.`Id_TipoDoc` = `pp_tipo_documentos`.`Id`)\n    INNER JOIN   `g_motivoanulacion`  ON (`pp_movimiento`.`Id_MotivoAnulacion` = `g_motivoanulacion`.`Id`)\n  WHERE (pp_tipo_documentos.`Id_ClaseDoc`=6 AND pp_tipo_documentos.Id='" + this.xIdTipDoc[this.JCTipoDoc.getSelectedIndex()] + "' AND pp_movimiento.NoConcecutivo='" + this.JTConsecutivo.getText() + "' AND DATE_FORMAT(`pp_movimiento`.`FechaD`,'%Y')='" + Principal.informacionGeneralPrincipalDTO.getAnoPresupuesto() + "') ORDER BY `pp_movimiento`.`Id`DESC, `pp_movimiento`.`FechaD` DESC ";
                        } else if (this.JCTipoDoc.getSelectedIndex() > -1 && this.JTConsecutivo.getText().equals("")) {
                            sql = "SELECT pp_movimiento.NoConcecutivo, `pp_movimiento`.`Id`, `pp_movimiento`.`FechaD`, `pp_tipo_documentos`.`Nbre` AS Documento, `pp_movimiento`.`Observacion`, `g_motivoanulacion`.`Nbre` AS Anulacion, pp_movimiento.IdDisponibilidad  \n FROM `pp_movimiento` INNER JOIN   `pp_tipo_documentos`  ON (`pp_movimiento`.`Id_TipoDoc` = `pp_tipo_documentos`.`Id`)\n    INNER JOIN   `g_motivoanulacion`  ON (`pp_movimiento`.`Id_MotivoAnulacion` = `g_motivoanulacion`.`Id`)\n  WHERE (pp_tipo_documentos.`Id_ClaseDoc`=6 AND pp_tipo_documentos.Id='" + this.xIdTipDoc[this.JCTipoDoc.getSelectedIndex()] + "') ORDER BY `pp_movimiento`.`Id`DESC, `pp_movimiento`.`FechaD` DESC ";
                        } else if (this.JCTipoDoc.getSelectedIndex() == -1 && !this.JTConsecutivo.getText().equals("")) {
                            sql = "SELECT pp_movimiento.NoConcecutivo, `pp_movimiento`.`Id`, `pp_movimiento`.`FechaD`, `pp_tipo_documentos`.`Nbre` AS Documento, `pp_movimiento`.`Observacion`, `g_motivoanulacion`.`Nbre` AS Anulacion, pp_movimiento.IdDisponibilidad  \n FROM `pp_movimiento` INNER JOIN   `pp_tipo_documentos`  ON (`pp_movimiento`.`Id_TipoDoc` = `pp_tipo_documentos`.`Id`)\n    INNER JOIN   `g_motivoanulacion`  ON (`pp_movimiento`.`Id_MotivoAnulacion` = `g_motivoanulacion`.`Id`)\n  WHERE (pp_tipo_documentos.`Id_ClaseDoc`=6  AND pp_movimiento.NoConcecutivo='" + this.JTConsecutivo.getText() + "' AND DATE_FORMAT(`pp_movimiento`.`FechaD`,'%Y')='" + Principal.informacionGeneralPrincipalDTO.getAnoPresupuesto() + "') ORDER BY `pp_movimiento`.`Id`DESC, `pp_movimiento`.`FechaD` DESC ";
                        }
                    }
                    break;
                }
                break;
            default:
                sql = "SELECT pp_movimiento.NoConcecutivo, `pp_movimiento`.`Id`, `pp_movimiento`.`FechaD`, `pp_tipo_documentos`.`Nbre` AS Documento, `pp_movimiento`.`Observacion`, `g_motivoanulacion`.`Nbre` AS Anulacion, pp_movimiento.IdDisponibilidad \nFROM `pp_movimiento` INNER JOIN   `pp_tipo_documentos`  ON (`pp_movimiento`.`Id_TipoDoc` = `pp_tipo_documentos`.`Id`)\nINNER JOIN   `pp_detalle_movimiento`  ON (`pp_movimiento`.`Id` = `pp_detalle_movimiento`.`Id_Movimiento`)\nINNER JOIN   `g_motivoanulacion`  ON (`pp_movimiento`.`Id_MotivoAnulacion` = `g_motivoanulacion`.`Id`)\nWHERE (pp_tipo_documentos.`Id_ClaseDoc`=4 AND pp_detalle_movimiento.`Id_Tercero`='" + this.xId_Tercero + "' AND pp_movimiento.`Id_MotivoAnulacion`=1 AND pp_detalle_movimiento.idEncabezado='" + Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro() + "' AND DATE_FORMAT(`pp_movimiento`.`FechaD`,'%Y')='" + Principal.informacionGeneralPrincipalDTO.getAnoPresupuesto() + "') \nORDER BY `pp_movimiento`.`Id`DESC, `pp_movimiento`.`FechaD` DESC ";
                break;
        }
        System.out.println("Movimientos-->" + sql);
        ResultSet xrsB = this.xct.traerRs(sql);
        int n = 0;
        try {
            if (xrsB.next()) {
                xrsB.beforeFirst();
                while (xrsB.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(xrsB.getString("NoConcecutivo"), n, 0);
                    this.xmodelo.setValueAt(xrsB.getString("FechaD"), n, 1);
                    this.xmodelo.setValueAt(xrsB.getString("Documento"), n, 2);
                    this.xmodelo.setValueAt(xrsB.getString("Observacion"), n, 3);
                    this.xmodelo.setValueAt(xrsB.getString("Anulacion"), n, 4);
                    this.xmodelo.setValueAt(xrsB.getString("Id"), n, 5);
                    this.xmodelo.setValueAt(xrsB.getString("IdDisponibilidad"), n, 6);
                    n++;
                }
            }
            xrsB.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JDBusquedaMovPTO.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatosComproRadicacion() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Cod.", "IdCompromiso", "Fecha", "TipoDoc", "Observacion", "IdTercero", "IdRubro", "NombreRubro", "Compromiso", "Obligacion", "Por_Obligar", "Estado", "Seleccionar"}) { // from class: Presupuesto.JDBusquedaMovPTO.8
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Double.class, Double.class, Double.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, true};

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
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(1).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(1).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(250);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(5).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(5).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(12).setPreferredWidth(100);
    }

    private void mBuscarCompromisoCierre() {
        mCrearModeloDatosComproRadicacion();
        String sql = "SELECT D.NoConcecutivo\n                , D.IdCompromiso\n                ,D.FechaD\n                ,D.TipoDoc\n                ,D.Observacion\n                ,D.Id_Tercero\n                ,D.Id_rubro\n                ,D.NombreRubro\n                ,D.COMPROMISO_ADICION AS Compromiso \n                ,IFNULL(C.Obligacion,0) Obligacion\n                ,(D.COMPROMISO_ADICION-IFNULL(C.Obligacion,0)) Por_Obligacion\n                ,Estado\n                \n                 FROM \n                (\n     SELECT    A.* , ((A.COMPROMISO+IFNULL(B.COMPROMISO,0)) - IFNULL(R.COMPROMISO,0) ) COMPROMISO_ADICION FROM \n    (SELECT  pp_movimiento.`NoConcecutivo`, pp_movimiento.FechaD \n                       , pp_tipo_documentos.Nbre AS TipoDoc \n                       , pp_movimiento.Observacion \n                       , g_motivoanulacion.Nbre AS Estado \n                       ,SUM(pp_detalle_movimiento.Valor) COMPROMISO\n                       ,pp_movimiento.IdDisponibilidad\n                       ,pp_movimiento.IdCompromiso\n                       ,pp_detalle_movimiento.Id_Rubro\n                       ,pp_rubros.`Nbre` AS NombreRubro\n                       ,pp_detalle_movimiento.Id_Tercero\n                      FROM pp_movimiento  \n                                INNER JOIN  g_motivoanulacion ON (pp_movimiento.Id_MotivoAnulacion = g_motivoanulacion.Id) \n                                INNER JOIN  pp_tipo_documentos  ON (pp_movimiento.Id_TipoDoc = pp_tipo_documentos.Id)\n                                INNER JOIN pp_detalle_movimiento ON (pp_movimiento.Id = pp_detalle_movimiento.Id_Movimiento)\n                                INNER JOIN `pp_rubros` ON (pp_detalle_movimiento.Id_Rubro = pp_rubros.`Id`) AND (pp_rubros.`idEncabezadoRubro`=pp_detalle_movimiento.`idEncabezado`) \n                                WHERE pp_movimiento.Id =1 and pp_detalle_movimiento.`Estado`=1 AND pp_tipo_documentos.Id_ClaseDoc IN (4) AND pp_detalle_movimiento.idEncabezado='" + Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro() + "'                               AND pp_detalle_movimiento.`Id_Tercero`='" + this.xId_Tercero + "'  -- Busca Compromisos, y adcion al compromiso\n                      GROUP BY pp_movimiento.IdDisponibilidad,pp_movimiento.`IdCompromiso`, pp_tipo_documentos.Id_ClaseDoc,pp_detalle_movimiento.Id_Rubro,pp_detalle_movimiento.Id_Tercero\n                      ORDER BY pp_movimiento.FechaD DESC) A\n       LEFT JOIN \n       (SELECT  SUM(pp_detalle_movimiento.Valor) COMPROMISO\n                       ,pp_movimiento.IdDisponibilidad\n                       ,pp_movimiento.IdCompromiso\n                       ,pp_detalle_movimiento.Id_Rubro\n                       ,pp_rubros.`Nbre` AS NombreRubro\n                      FROM pp_movimiento  \n                                INNER JOIN  g_motivoanulacion ON (pp_movimiento.Id_MotivoAnulacion = g_motivoanulacion.Id) \n                                INNER JOIN  pp_tipo_documentos  ON (pp_movimiento.Id_TipoDoc = pp_tipo_documentos.Id)\n                                INNER JOIN pp_detalle_movimiento ON (pp_movimiento.Id = pp_detalle_movimiento.Id_Movimiento)\n                                INNER JOIN `pp_rubros` ON (pp_detalle_movimiento.Id_Rubro = pp_rubros.`Id`) AND (pp_rubros.`idEncabezadoRubro`=pp_detalle_movimiento.`idEncabezado`) \n                                WHERE pp_movimiento.Id =1 and pp_detalle_movimiento.`Estado`=1 AND pp_tipo_documentos.Id_ClaseDoc IN (12) AND pp_detalle_movimiento.idEncabezado='" + Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro() + "' AND pp_detalle_movimiento.`Id_Tercero`='" + this.xId_Tercero + "'  -- Busca Compromisos, y adcion al compromiso\n                      GROUP BY pp_movimiento.IdDisponibilidad,pp_movimiento.`IdCompromiso`, pp_tipo_documentos.Id_ClaseDoc,pp_detalle_movimiento.Id_Rubro,pp_detalle_movimiento.Id_Tercero\n                      ORDER BY pp_movimiento.FechaD DESC) B\n        ON A.IdDisponibilidad=B.IdDisponibilidad AND A.IdCompromiso=B.IdCompromiso        AND A.Id_Rubro=B.Id_Rubro \n       \n     LEFT JOIN \n       (SELECT  SUM(pp_detalle_movimiento.Valor) COMPROMISO\n                       ,pp_movimiento.IdDisponibilidad\n                       ,pp_movimiento.IdCompromiso\n                       ,pp_detalle_movimiento.Id_Rubro\n                       ,pp_rubros.`Nbre` AS NombreRubro\n                      FROM pp_movimiento  \n                                INNER JOIN  g_motivoanulacion ON (pp_movimiento.Id_MotivoAnulacion = g_motivoanulacion.Id) \n                                INNER JOIN  pp_tipo_documentos  ON (pp_movimiento.Id_TipoDoc = pp_tipo_documentos.Id)\n                                INNER JOIN pp_detalle_movimiento ON (pp_movimiento.Id = pp_detalle_movimiento.Id_Movimiento)\n                                INNER JOIN `pp_rubros` ON (pp_detalle_movimiento.Id_Rubro = pp_rubros.`Id`) AND (pp_rubros.`idEncabezadoRubro`=pp_detalle_movimiento.`idEncabezado`) \n                                WHERE pp_movimiento.Id =1 and pp_detalle_movimiento.`Estado`=1 AND pp_tipo_documentos.Id_ClaseDoc IN (13) AND pp_detalle_movimiento.idEncabezado=" + Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro() + " AND pp_detalle_movimiento.`Id_Tercero`= " + this.xId_Tercero + "  -- Busca Compromisos, y adcion al compromiso\n                      GROUP BY pp_movimiento.IdDisponibilidad,pp_movimiento.`IdCompromiso`, pp_tipo_documentos.Id_ClaseDoc,pp_detalle_movimiento.Id_Rubro,pp_detalle_movimiento.Id_Tercero\n                      ORDER BY pp_movimiento.FechaD DESC) R\n       ON A.IdDisponibilidad=R.IdDisponibilidad AND A.IdCompromiso=R.IdCompromiso  AND A.Id_Rubro=R.Id_Rubro        ) D\n                      LEFT JOIN \n                     (SELECT  pp_movimiento.IdDisponibilidad\n                      , pp_movimiento.IdCompromiso\n                      , pp_detalle_movimiento.Id_Rubro\n                      , pp_detalle_movimiento.Id_Tercero\n                   ,SUM(pp_detalle_movimiento.Valor) OBLIGACION\n                        FROM pp_movimiento  \n                        INNER JOIN  g_motivoanulacion ON (pp_movimiento.Id_MotivoAnulacion = g_motivoanulacion.Id) \n                        INNER JOIN  pp_tipo_documentos  ON (pp_movimiento.Id_TipoDoc = pp_tipo_documentos.Id)\n                        INNER JOIN pp_detalle_movimiento ON (pp_movimiento.Id = pp_detalle_movimiento.Id_Movimiento)\n                        WHERE pp_movimiento.Id =1 and pp_detalle_movimiento.`Estado`=1 AND pp_tipo_documentos.Id_ClaseDoc IN (5) AND pp_detalle_movimiento.idEncabezado='" + Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro() + "' AND pp_detalle_movimiento.`Id_Tercero`='" + this.xId_Tercero + "'  -- Busca Obligacion\n                        GROUP BY pp_movimiento.IdDisponibilidad  , pp_movimiento.IdCompromiso\n                  , pp_detalle_movimiento.Id_Rubro\n                  , pp_detalle_movimiento.Id_Tercero -- 38236318 8236318\n                      ) C\n                     ON  D.IdCompromiso=C.IdCompromiso \n                     AND D.Id_Rubro=C.Id_Rubro AND D.Id_Tercero=C.Id_Tercero\n                  WHERE (D.Id_Tercero='" + this.xId_Tercero + "')";
        System.out.println("Compromisos Radicacion Tercero-->" + sql);
        ResultSet xrsB = this.xct.traerRs(sql);
        this.xmt.mEstablecerTextEditor(this.JTDetalle, 4);
        this.JTDetalle.setAutoResizeMode(0);
        int n = 0;
        try {
            if (xrsB.next()) {
                xrsB.beforeFirst();
                while (xrsB.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(xrsB.getString("NoConcecutivo"), n, 0);
                    this.xmodelo.setValueAt(xrsB.getString("IdCompromiso"), n, 1);
                    this.xmodelo.setValueAt(xrsB.getString("FechaD"), n, 2);
                    this.xmodelo.setValueAt(xrsB.getString("TipoDoc"), n, 3);
                    this.xmodelo.setValueAt(xrsB.getString("Observacion"), n, 4);
                    this.xmodelo.setValueAt(xrsB.getString("Id_Tercero"), n, 5);
                    this.xmodelo.setValueAt(xrsB.getString("Id_rubro"), n, 6);
                    this.xmodelo.setValueAt(xrsB.getString("NombreRubro"), n, 7);
                    this.xmodelo.setValueAt(Double.valueOf(xrsB.getDouble("Compromiso")), n, 8);
                    this.xmodelo.setValueAt(Double.valueOf(xrsB.getDouble("Obligacion")), n, 9);
                    this.xmodelo.setValueAt(Double.valueOf(xrsB.getDouble("Por_Obligacion")), n, 10);
                    this.xmodelo.setValueAt(xrsB.getString("Estado"), n, 11);
                    this.xmodelo.setValueAt(false, n, 12);
                    this.JTDetalle.setDefaultRenderer(Object.class, new MiRender());
                    n++;
                }
            }
            xrsB.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JDBusquedaMovPTO.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mBuscaDatosCompromisoRadicacion() {
        mCrearModeloDatosComproRadicacion();
        String sql = "SELECT D.NoConcecutivo\n                , D.IdCompromiso\n                ,D.FechaD\n                ,D.TipoDoc\n                ,D.Observacion\n                ,D.Id_Tercero\n                ,D.Id_rubro\n                ,D.NombreRubro\n                ,D.COMPROMISO_ADICION AS Compromiso \n                ,IFNULL(C.Obligacion,0) Obligacion\n                ,(D.COMPROMISO_ADICION-IFNULL(C.Obligacion,0)) Por_Obligacion\n                ,Estado\n                \n                 FROM \n                (\n     SELECT    A.* , ((A.COMPROMISO+IFNULL(B.COMPROMISO,0)) - IFNULL(R.COMPROMISO,0) ) COMPROMISO_ADICION FROM \n    (SELECT  pp_movimiento.`NoConcecutivo`, pp_movimiento.FechaD \n                       , pp_tipo_documentos.Nbre AS TipoDoc \n                       , pp_movimiento.Observacion \n                       , g_motivoanulacion.Nbre AS Estado \n                       ,SUM(pp_detalle_movimiento.Valor) COMPROMISO\n                       ,pp_movimiento.IdDisponibilidad\n                       ,pp_movimiento.IdCompromiso\n                       ,pp_detalle_movimiento.Id_Rubro\n                       ,pp_rubros.`Nbre` AS NombreRubro\n                       ,pp_detalle_movimiento.Id_Tercero\n                      FROM pp_movimiento  \n                                INNER JOIN  g_motivoanulacion ON (pp_movimiento.Id_MotivoAnulacion = g_motivoanulacion.Id) \n                                INNER JOIN  pp_tipo_documentos  ON (pp_movimiento.Id_TipoDoc = pp_tipo_documentos.Id)\n                                INNER JOIN pp_detalle_movimiento ON (pp_movimiento.Id = pp_detalle_movimiento.Id_Movimiento)\n                                INNER JOIN `pp_rubros` ON (pp_detalle_movimiento.Id_Rubro = pp_rubros.`Id`) AND (pp_rubros.`idEncabezadoRubro`=pp_detalle_movimiento.`idEncabezado`) \n                                WHERE pp_detalle_movimiento.`Estado`=1 AND pp_tipo_documentos.Id_ClaseDoc IN (4) AND pp_detalle_movimiento.idEncabezado='" + Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro() + "'                               AND pp_detalle_movimiento.`Id_Tercero`='" + this.xJIFRadicacion.xidempresa[this.xJIFRadicacion.JCBEmpresa.getSelectedIndex()][0] + "'  -- Busca Compromisos, y adcion al compromiso\n                      GROUP BY pp_movimiento.IdDisponibilidad,pp_movimiento.`IdCompromiso`, pp_tipo_documentos.Id_ClaseDoc,pp_detalle_movimiento.Id_Rubro,pp_detalle_movimiento.Id_Tercero\n                      ORDER BY pp_movimiento.FechaD DESC) A\n       LEFT JOIN \n       (SELECT  SUM(pp_detalle_movimiento.Valor) COMPROMISO\n                       ,pp_movimiento.IdDisponibilidad\n                       ,pp_movimiento.IdCompromiso\n                       ,pp_detalle_movimiento.Id_Rubro\n                       ,pp_rubros.`Nbre` AS NombreRubro\n                      FROM pp_movimiento  \n                                INNER JOIN  g_motivoanulacion ON (pp_movimiento.Id_MotivoAnulacion = g_motivoanulacion.Id) \n                                INNER JOIN  pp_tipo_documentos  ON (pp_movimiento.Id_TipoDoc = pp_tipo_documentos.Id)\n                                INNER JOIN pp_detalle_movimiento ON (pp_movimiento.Id = pp_detalle_movimiento.Id_Movimiento)\n                                INNER JOIN `pp_rubros` ON (pp_detalle_movimiento.Id_Rubro = pp_rubros.`Id`) AND (pp_rubros.`idEncabezadoRubro`=pp_detalle_movimiento.`idEncabezado`) \n                                WHERE pp_detalle_movimiento.`Estado`=1 AND pp_tipo_documentos.Id_ClaseDoc IN (12) AND pp_detalle_movimiento.idEncabezado='" + Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro() + "' AND pp_detalle_movimiento.`Id_Tercero`='" + this.xJIFRadicacion.xidempresa[this.xJIFRadicacion.JCBEmpresa.getSelectedIndex()][0] + "'  -- Busca Compromisos, y adcion al compromiso\n                      GROUP BY pp_movimiento.IdDisponibilidad,pp_movimiento.`IdCompromiso`, pp_tipo_documentos.Id_ClaseDoc,pp_detalle_movimiento.Id_Rubro,pp_detalle_movimiento.Id_Tercero\n                      ORDER BY pp_movimiento.FechaD DESC) B\n        ON A.IdDisponibilidad=B.IdDisponibilidad AND A.IdCompromiso=B.IdCompromiso        AND A.Id_Rubro=B.Id_Rubro \n       \n     LEFT JOIN \n       (SELECT  SUM(pp_detalle_movimiento.Valor) COMPROMISO\n                       ,pp_movimiento.IdDisponibilidad\n                       ,pp_movimiento.IdCompromiso\n                       ,pp_detalle_movimiento.Id_Rubro\n                       ,pp_rubros.`Nbre` AS NombreRubro\n                      FROM pp_movimiento  \n                                INNER JOIN  g_motivoanulacion ON (pp_movimiento.Id_MotivoAnulacion = g_motivoanulacion.Id) \n                                INNER JOIN  pp_tipo_documentos  ON (pp_movimiento.Id_TipoDoc = pp_tipo_documentos.Id)\n                                INNER JOIN pp_detalle_movimiento ON (pp_movimiento.Id = pp_detalle_movimiento.Id_Movimiento)\n                                INNER JOIN `pp_rubros` ON (pp_detalle_movimiento.Id_Rubro = pp_rubros.`Id`) AND (pp_rubros.`idEncabezadoRubro`=pp_detalle_movimiento.`idEncabezado`) \n                                WHERE pp_detalle_movimiento.`Estado`=1 AND pp_tipo_documentos.Id_ClaseDoc IN (13) AND pp_detalle_movimiento.idEncabezado=" + Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro() + " AND pp_detalle_movimiento.`Id_Tercero`= " + this.xJIFRadicacion.xidempresa[this.xJIFRadicacion.JCBEmpresa.getSelectedIndex()][0] + "  -- Busca Compromisos, y adcion al compromiso\n                      GROUP BY pp_movimiento.IdDisponibilidad,pp_movimiento.`IdCompromiso`, pp_tipo_documentos.Id_ClaseDoc,pp_detalle_movimiento.Id_Rubro,pp_detalle_movimiento.Id_Tercero\n                      ORDER BY pp_movimiento.FechaD DESC) R\n       ON A.IdDisponibilidad=R.IdDisponibilidad AND A.IdCompromiso=R.IdCompromiso  AND A.Id_Rubro=R.Id_Rubro        ) D\n                      LEFT JOIN \n                     (SELECT  pp_movimiento.IdDisponibilidad\n                      , pp_movimiento.IdCompromiso\n                      , pp_detalle_movimiento.Id_Rubro\n                      , pp_detalle_movimiento.Id_Tercero\n                   ,SUM(pp_detalle_movimiento.Valor) OBLIGACION\n                        FROM pp_movimiento  \n                        INNER JOIN  g_motivoanulacion ON (pp_movimiento.Id_MotivoAnulacion = g_motivoanulacion.Id) \n                        INNER JOIN  pp_tipo_documentos  ON (pp_movimiento.Id_TipoDoc = pp_tipo_documentos.Id)\n                        INNER JOIN pp_detalle_movimiento ON (pp_movimiento.Id = pp_detalle_movimiento.Id_Movimiento)\n                        WHERE pp_detalle_movimiento.`Estado`=1 AND pp_tipo_documentos.Id_ClaseDoc IN (5) AND pp_detalle_movimiento.idEncabezado='" + Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro() + "' AND pp_detalle_movimiento.`Id_Tercero`='" + this.xJIFRadicacion.xidempresa[this.xJIFRadicacion.JCBEmpresa.getSelectedIndex()][0] + "'  -- Busca Obligacion\n                        GROUP BY pp_movimiento.IdDisponibilidad  , pp_movimiento.IdCompromiso\n                  , pp_detalle_movimiento.Id_Rubro\n                  , pp_detalle_movimiento.Id_Tercero -- 38236318 8236318\n                      ) C\n                     ON  D.IdCompromiso=C.IdCompromiso \n                     AND D.Id_Rubro=C.Id_Rubro AND D.Id_Tercero=C.Id_Tercero\n                  WHERE (D.Id_Tercero='" + this.xJIFRadicacion.xidempresa[this.xJIFRadicacion.JCBEmpresa.getSelectedIndex()][0] + "')";
        System.out.println("Compromisos Radicacion Tercero-->" + sql);
        ResultSet xrsB = this.xct.traerRs(sql);
        this.xmt.mEstablecerTextEditor(this.JTDetalle, 4);
        JTable jTable = this.JTDetalle;
        JTable jTable2 = this.JTDetalle;
        jTable.setAutoResizeMode(0);
        int n = 0;
        try {
            if (xrsB.next()) {
                xrsB.beforeFirst();
                while (xrsB.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(xrsB.getString("NoConcecutivo"), n, 0);
                    this.xmodelo.setValueAt(xrsB.getString("IdCompromiso"), n, 1);
                    this.xmodelo.setValueAt(xrsB.getString("FechaD"), n, 2);
                    this.xmodelo.setValueAt(xrsB.getString("TipoDoc"), n, 3);
                    this.xmodelo.setValueAt(xrsB.getString("Observacion"), n, 4);
                    this.xmodelo.setValueAt(xrsB.getString("Id_Tercero"), n, 5);
                    this.xmodelo.setValueAt(xrsB.getString("Id_rubro"), n, 6);
                    this.xmodelo.setValueAt(xrsB.getString("NombreRubro"), n, 7);
                    this.xmodelo.setValueAt(Double.valueOf(xrsB.getDouble("Compromiso")), n, 8);
                    this.xmodelo.setValueAt(Double.valueOf(xrsB.getDouble("Obligacion")), n, 9);
                    this.xmodelo.setValueAt(Double.valueOf(xrsB.getDouble("Por_Obligacion")), n, 10);
                    this.xmodelo.setValueAt(xrsB.getString("Estado"), n, 11);
                    this.xmodelo.setValueAt(false, n, 12);
                    this.JTDetalle.setDefaultRenderer(Object.class, new MiRender());
                    n++;
                }
            }
            xrsB.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JDBusquedaMovPTO.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX INFO: loaded from: GenomaP.jar:Presupuesto/JDBusquedaMovPTO$MiRender.class */
    public static class MiRender extends DefaultTableCellRenderer {
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (Double.valueOf(table.getValueAt(row, 10).toString()).doubleValue() <= 0.0d) {
                cell.setBackground(Color.RED);
                cell.setForeground(Color.BLACK);
            } else {
                cell.setBackground(Color.WHITE);
                cell.setForeground(Color.BLACK);
            }
            return cell;
        }
    }
}
