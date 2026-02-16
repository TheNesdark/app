package ImagenesDx;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.SpinnerNumberModel;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:ImagenesDx/JIFRegistroInformacionPlacas.class */
public class JIFRegistroInformacionPlacas extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private DefaultTableModel xmodelopu;
    private DefaultTableModel xmodelopd;
    private String[] xidtiposervicio;
    private String[] xiddano;
    private String[] xidplaca;
    private Object[] dato;
    public JIFSeguimientoOrdenes xjifseguimientoord;
    private ButtonGroup JBGFiltro1;
    private JButton JBTAdicionar;
    private JComboBox JCBMotivo;
    private JComboBox JCBTipoPlaca;
    private JComboBox JCBTipoServicio;
    private JDateChooser JDFFechaR;
    public JDateChooser JDFechaF;
    public JDateChooser JDFechaI;
    private JPanel JPIDatos;
    private JPanel JPIRegistroD;
    private JSpinner JSPCantidad;
    private JScrollPane JSPDDescripcion;
    private JScrollPane JSPPDetallePD;
    private JScrollPane JSPPUtilizadas;
    private JScrollPane JSPResultado;
    private JTextPane JTADDescripcion;
    private JTable JTBDetalePD;
    private JTable JTBPUtilizadas;
    private JTable JTBResultado;
    private int xfiltro = 0;
    private Metodos xmetodos = new Metodos();
    private ConsultasMySQL xconsultas = new ConsultasMySQL();
    private int xnfila = 0;

    public JIFRegistroInformacionPlacas() {
        initComponents();
        this.xidtiposervicio = this.xconsultas.llenarCombo("SELECT Id, Nbre FROM f_tiposervicio WHERE (Id =3 AND Estado =0 AND EsConsulta <>1) ORDER BY Nbre ASC", this.xidtiposervicio, this.JCBTipoServicio);
        this.xiddano = this.xconsultas.llenarCombo("SELECT Id, Nbre FROM g_tipo_causadañoplacas WHERE (Id <>1 AND Estado =0) ORDER BY Nbre ASC", this.xiddano, this.JCBMotivo);
        this.xidplaca = this.xconsultas.llenarCombo("SELECT Id, Nbre FROM g_tipo_placasrx WHERE (Estado =0) ORDER BY Id ASC", this.xidplaca, this.JCBTipoPlaca);
        this.xconsultas.cerrarConexionBd();
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v36, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v48, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v7, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGFiltro1 = new ButtonGroup();
        this.JSPResultado = new JScrollPane();
        this.JTBResultado = new JTable();
        this.JPIDatos = new JPanel();
        this.JDFechaI = new JDateChooser();
        this.JDFechaF = new JDateChooser();
        this.JCBTipoServicio = new JComboBox();
        this.JSPPUtilizadas = new JScrollPane();
        this.JTBPUtilizadas = new JTable();
        this.JPIRegistroD = new JPanel();
        this.JCBTipoPlaca = new JComboBox();
        this.JCBMotivo = new JComboBox();
        this.JSPPDetallePD = new JScrollPane();
        this.JTBDetalePD = new JTable();
        this.JBTAdicionar = new JButton();
        this.JSPCantidad = new JSpinner();
        this.JSPDDescripcion = new JScrollPane();
        this.JTADDescripcion = new JTextPane();
        this.JDFFechaR = new JDateChooser();
        setClosable(true);
        setIconifiable(true);
        setTitle("REGISTRO DE INFORMACIÓN DE PLACAS");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifregistroplacas");
        this.JSPResultado.setBorder(BorderFactory.createTitledBorder((Border) null, "RESULTADO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JSPResultado.setEnabled(false);
        this.JSPResultado.setFont(new Font("Arial", 1, 12));
        this.JTBResultado.setFont(new Font("Arial", 1, 12));
        this.JTBResultado.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTBResultado.setAutoResizeMode(4);
        this.JTBResultado.setGridColor(UIManager.getDefaults().getColor("Menu.selectionBackground"));
        this.JTBResultado.setRowHeight(25);
        this.JTBResultado.setSelectionBackground(new Color(255, 255, 255));
        this.JTBResultado.setSelectionForeground(new Color(255, 0, 0));
        this.JTBResultado.setSelectionMode(0);
        this.JSPResultado.setViewportView(this.JTBResultado);
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS PARA CONSULTA", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JDFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicial", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFechaI.setFont(new Font("Arial", 1, 12));
        this.JDFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Final", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFechaF.setFont(new Font("Arial", 1, 12));
        this.JCBTipoServicio.setFont(new Font("Arial", 1, 12));
        this.JCBTipoServicio.setBorder(BorderFactory.createTitledBorder((Border) null, "Servicio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addComponent(this.JDFechaI, -2, 143, -2).addGap(18, 18, 18).addComponent(this.JDFechaF, -2, 143, -2).addGap(18, 18, 18).addComponent(this.JCBTipoServicio, 0, 366, 32767).addGap(427, 427, 427)));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addGroup(GroupLayout.Alignment.LEADING, JPIDatosLayout.createSequentialGroup().addContainerGap().addComponent(this.JCBTipoServicio)).addComponent(this.JDFechaF, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.JDFechaI, GroupLayout.Alignment.LEADING, -2, 64, -2)).addContainerGap(-1, 32767)));
        this.JSPPUtilizadas.setBorder(BorderFactory.createTitledBorder((Border) null, "Placas Utilizadas", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JSPPUtilizadas.setEnabled(false);
        this.JSPPUtilizadas.setFont(new Font("Arial", 1, 12));
        this.JTBPUtilizadas.setFont(new Font("Arial", 1, 12));
        this.JTBPUtilizadas.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTBPUtilizadas.setAutoResizeMode(4);
        this.JTBPUtilizadas.setGridColor(UIManager.getDefaults().getColor("Menu.selectionBackground"));
        this.JTBPUtilizadas.setRowHeight(25);
        this.JTBPUtilizadas.setSelectionBackground(new Color(255, 255, 255));
        this.JTBPUtilizadas.setSelectionForeground(Color.red);
        this.JTBPUtilizadas.setSelectionMode(0);
        this.JSPPUtilizadas.setViewportView(this.JTBPUtilizadas);
        this.JPIRegistroD.setBorder(BorderFactory.createTitledBorder((Border) null, "Placas Dañadas", 0, 0, new Font("Arial", 1, 14), Color.red));
        this.JPIRegistroD.setFont(new Font("Arial", 1, 12));
        this.JCBTipoPlaca.setFont(new Font("Arial", 1, 12));
        this.JCBTipoPlaca.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Placa", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBMotivo.setFont(new Font("Arial", 1, 12));
        this.JCBMotivo.setBorder(BorderFactory.createTitledBorder((Border) null, "Motivo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPPDetallePD.setBorder(BorderFactory.createTitledBorder((Border) null, "Detalle", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JSPPDetallePD.setEnabled(false);
        this.JSPPDetallePD.setFont(new Font("Arial", 1, 12));
        this.JTBDetalePD.setFont(new Font("Arial", 1, 12));
        this.JTBDetalePD.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTBDetalePD.setAutoResizeMode(4);
        this.JTBDetalePD.setGridColor(UIManager.getDefaults().getColor("Menu.selectionBackground"));
        this.JTBDetalePD.setRowHeight(25);
        this.JTBDetalePD.setSelectionBackground(new Color(255, 255, 255));
        this.JTBDetalePD.setSelectionForeground(new Color(255, 0, 0));
        this.JTBDetalePD.setSelectionMode(0);
        this.JSPPDetallePD.setViewportView(this.JTBDetalePD);
        this.JBTAdicionar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTAdicionar.addActionListener(new ActionListener() { // from class: ImagenesDx.JIFRegistroInformacionPlacas.1
            public void actionPerformed(ActionEvent evt) {
                JIFRegistroInformacionPlacas.this.JBTAdicionarActionPerformed(evt);
            }
        });
        this.JSPCantidad.setFont(new Font("Arial", 1, 12));
        this.JSPCantidad.setModel(new SpinnerNumberModel(1, 1, (Comparable) null, 1));
        this.JSPCantidad.setBorder(BorderFactory.createTitledBorder((Border) null, "Cant.", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPIRegistroDLayout = new GroupLayout(this.JPIRegistroD);
        this.JPIRegistroD.setLayout(JPIRegistroDLayout);
        JPIRegistroDLayout.setHorizontalGroup(JPIRegistroDLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIRegistroDLayout.createSequentialGroup().addContainerGap().addGroup(JPIRegistroDLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JSPPDetallePD, GroupLayout.Alignment.LEADING, -1, 633, 32767).addGroup(JPIRegistroDLayout.createSequentialGroup().addComponent(this.JCBTipoPlaca, -2, 185, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBMotivo, -2, 296, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPCantidad, -2, 73, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTAdicionar, -1, 65, 32767))).addContainerGap()));
        JPIRegistroDLayout.setVerticalGroup(JPIRegistroDLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIRegistroDLayout.createSequentialGroup().addContainerGap().addGroup(JPIRegistroDLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JBTAdicionar, -1, 53, 32767).addGroup(JPIRegistroDLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBTipoPlaca, -1, 53, 32767).addComponent(this.JSPCantidad, -2, 50, -2).addComponent(this.JCBMotivo, -1, 53, 32767))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPPDetallePD, -2, 103, -2).addGap(11, 11, 11)));
        this.JSPDDescripcion.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTADDescripcion.setFont(new Font("Arial", 1, 12));
        this.JSPDDescripcion.setViewportView(this.JTADDescripcion);
        this.JDFFechaR.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFechaR.setDateFormatString("dd/MM/yyyy");
        this.JDFFechaR.setFont(new Font("Arial", 1, 12));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup().addComponent(this.JDFFechaR, -2, 121, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDDescripcion)).addComponent(this.JSPPUtilizadas, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPIRegistroD, -1, -1, 32767)).addComponent(this.JPIDatos, -1, -1, 32767)).addContainerGap()).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JSPResultado, -1, 1141, 32767).addContainerGap())));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addGap(325, 325, 325).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JPIRegistroD, -2, -1, -2).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JDFFechaR, -1, 69, 32767).addGroup(layout.createSequentialGroup().addGap(11, 11, 11).addComponent(this.JSPDDescripcion, -2, 53, -2).addGap(0, 0, 32767))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPPUtilizadas, -2, 155, -2))).addContainerGap()).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap(144, 32767).addComponent(this.JSPResultado, -2, 302, -2).addGap(232, 232, 232))));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTAdicionarActionPerformed(ActionEvent evt) {
        if (this.JTBResultado.getSelectedRow() != -1) {
            if (this.JCBTipoPlaca.getSelectedIndex() != -1) {
                if (this.JCBMotivo.getSelectedIndex() != -1) {
                    int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    if (n == 0) {
                        String sql = "insert into h_informe_detalle_imagenesdx (Id_infomesdx, Id_OrdenFac, Id_Procedimiento, Id_TipoPlaca, Id_TipoDano, Cantidad) values ('" + Principal.txtNo.getText() + "','" + this.xmodelo.getValueAt(this.JTBResultado.getSelectedRow(), 0) + "','" + this.xmodelo.getValueAt(this.JTBResultado.getSelectedRow(), 7) + "','" + this.xidplaca[this.JCBTipoPlaca.getSelectedIndex()] + "','" + this.xiddano[this.JCBMotivo.getSelectedIndex()] + "','" + this.JSPCantidad.getValue() + "')";
                        this.xconsultas.ejecutarSQL(sql);
                        this.xconsultas.cerrarConexionBd();
                        this.xmodelopd.addRow(this.dato);
                        this.xmodelopd.setValueAt(this.xidplaca[this.JCBTipoPlaca.getSelectedIndex()], this.xnfila, 0);
                        this.xmodelopd.setValueAt(this.JCBTipoPlaca.getSelectedItem().toString(), this.xnfila, 1);
                        this.xmodelopd.setValueAt(this.xiddano[this.JCBMotivo.getSelectedIndex()], this.xnfila, 2);
                        this.xmodelopd.setValueAt(this.JCBMotivo.getSelectedItem().toString(), this.xnfila, 3);
                        this.xmodelopd.setValueAt(this.JSPCantidad.getValue(), this.xnfila, 4);
                        this.xnfila++;
                        this.JCBTipoPlaca.setSelectedIndex(-1);
                        this.JCBMotivo.setSelectedIndex(-1);
                        return;
                    }
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un motivo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JCBMotivo.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un tipo de placa", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBTipoPlaca.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un registro", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    public void mNuevo() {
        Principal.mLimpiarDatosP();
        this.JDFechaI.setDate(this.xmetodos.getFechaActual());
        this.JDFechaF.setDate(this.xmetodos.getFechaActual());
        this.JDFFechaR.setDate(this.xmetodos.getFechaActual());
        this.JTADDescripcion.setText("");
        this.JCBTipoServicio.setSelectedIndex(0);
        this.JCBTipoPlaca.setSelectedIndex(-1);
        this.JCBMotivo.setSelectedIndex(-1);
        mCrearTabla();
        mCrearTablaPlacasUtilizadas();
        mCrearTablaPlacasDanadas();
        this.xfiltro = 0;
    }

    public void mBuscar() {
        if (this.JCBTipoServicio.getSelectedIndex() != -1) {
            mCargarDatos();
            mCargarDatosPlacasUtilizadas();
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTabla() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Fecha", "N° HC", "Nombre", "Sexo", "Edad", "Estudio", "Id"}) { // from class: ImagenesDx.JIFRegistroInformacionPlacas.2
            Class[] types = {Long.class, String.class, String.class, String.class, String.class, String.class, String.class, Long.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTBResultado.setModel(this.xmodelo);
        this.JTBResultado.getColumnModel().getColumn(0).setPreferredWidth(20);
        this.JTBResultado.getColumnModel().getColumn(1).setPreferredWidth(30);
        this.JTBResultado.getColumnModel().getColumn(2).setPreferredWidth(30);
        this.JTBResultado.getColumnModel().getColumn(3).setPreferredWidth(200);
        this.JTBResultado.getColumnModel().getColumn(4).setPreferredWidth(20);
        this.JTBResultado.getColumnModel().getColumn(5).setPreferredWidth(10);
        this.JTBResultado.getColumnModel().getColumn(6).setPreferredWidth(200);
        this.JTBResultado.getColumnModel().getColumn(7).setPreferredWidth(0);
        this.JTBResultado.getColumnModel().getColumn(7).setMinWidth(0);
        this.JTBResultado.getColumnModel().getColumn(7).setMaxWidth(0);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTablaPlacasUtilizadas() {
        this.xmodelopu = new DefaultTableModel(new Object[0], new String[]{"Id", "Dimensión Placa", "Utilizó?", "Cantidad"}) { // from class: ImagenesDx.JIFRegistroInformacionPlacas.3
            Class[] types = {Long.class, String.class, Boolean.class, Long.class};
            boolean[] canEdit = {false, false, true, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTBPUtilizadas.setModel(this.xmodelopu);
        this.JTBPUtilizadas.getColumnModel().getColumn(0).setPreferredWidth(20);
        this.JTBPUtilizadas.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTBPUtilizadas.getColumnModel().getColumn(2).setPreferredWidth(30);
        this.JTBPUtilizadas.getColumnModel().getColumn(3).setPreferredWidth(30);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTablaPlacasDanadas() {
        this.xmodelopd = new DefaultTableModel(new Object[0], new String[]{"IdTipo", "Tipo", "IdMotivo", "Motivo", "Cant"}) { // from class: ImagenesDx.JIFRegistroInformacionPlacas.4
            Class[] types = {String.class, String.class, String.class, String.class, Integer.class};
            boolean[] canEdit = {false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTBDetalePD.setModel(this.xmodelopd);
        this.JTBDetalePD.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTBDetalePD.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTBDetalePD.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTBDetalePD.getColumnModel().getColumn(1).setPreferredWidth(50);
        this.JTBDetalePD.getColumnModel().getColumn(2).setPreferredWidth(0);
        this.JTBDetalePD.getColumnModel().getColumn(2).setMinWidth(0);
        this.JTBDetalePD.getColumnModel().getColumn(2).setMaxWidth(0);
        this.JTBDetalePD.getColumnModel().getColumn(3).setPreferredWidth(50);
        this.JTBDetalePD.getColumnModel().getColumn(4).setPreferredWidth(30);
        this.xnfila = 0;
    }

    private void mCargarDatos() {
        try {
            String sql = "SELECT f_ordenes.Id, ingreso.FechaIngreso, persona.NoHistoria, persona.NUsuario, persona.IdSexo, persona.Edad, persona.NTipoEdad, g_procedimiento.Nbre, g_procedimiento.Id FROM f_ordenes INNER JOIN ingreso ON (f_ordenes.Id_Ingreso = ingreso.Id) INNER JOIN persona  ON (persona.Id_persona = ingreso.Id_Usuario) INNER JOIN f_itemordenesproced ON (f_itemordenesproced.Id_Ordenes = f_ordenes.Id) INNER JOIN g_procedimiento  ON (f_itemordenesproced.Id_Procedimiento = g_procedimiento.Id) WHERE (ingreso.FechaIngreso >='" + this.xmetodos.formatoAMD.format(this.JDFechaI.getDate()) + "'  AND f_ordenes.Id_TipoServicio ='" + this.xidtiposervicio[this.JCBTipoServicio.getSelectedIndex()] + "' AND f_ordenes.Estado =0 AND ingreso.FechaIngreso <='" + this.xmetodos.formatoAMD.format(this.JDFechaF.getDate()) + "' AND f_itemordenesproced.EsRecepcionado =0) GROUP BY f_ordenes.Id, g_procedimiento.Id ORDER BY ingreso.FechaIngreso ASC, persona.NUsuario ASC ";
            ResultSet rs = this.xconsultas.traerRs(sql);
            if (rs.next()) {
                rs.beforeFirst();
                int filaGrid = 0;
                mCrearTabla();
                while (rs.next()) {
                    this.xmodelo.addRow(this.dato);
                    this.xmodelo.setValueAt(Long.valueOf(rs.getLong(1)), filaGrid, 0);
                    this.xmodelo.setValueAt(rs.getString(2), filaGrid, 1);
                    this.xmodelo.setValueAt(rs.getString(3), filaGrid, 2);
                    this.xmodelo.setValueAt(rs.getString(4), filaGrid, 3);
                    this.xmodelo.setValueAt(rs.getString(5), filaGrid, 4);
                    this.xmodelo.setValueAt(rs.getString(6) + " " + rs.getString(7), filaGrid, 5);
                    this.xmodelo.setValueAt(rs.getString(8), filaGrid, 6);
                    this.xmodelo.setValueAt(Long.valueOf(rs.getLong(9)), filaGrid, 7);
                    filaGrid++;
                }
            }
            rs.close();
            this.xconsultas.cerrarConexionBd();
        } catch (Exception ex) {
            Logger.getLogger(JIFRegistroInformacionPlacas.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarDatosPlacasUtilizadas() {
        try {
            ResultSet rs = this.xconsultas.traerRs("SELECT Id, Nbre FROM g_tipo_placasrx WHERE (Estado =0) ORDER BY Id ASC");
            if (rs.next()) {
                rs.beforeFirst();
                int filaGrid = 0;
                mCrearTablaPlacasUtilizadas();
                while (rs.next()) {
                    this.xmodelopu.addRow(this.dato);
                    this.xmodelopu.setValueAt(Long.valueOf(rs.getLong(1)), filaGrid, 0);
                    this.xmodelopu.setValueAt(rs.getString(2), filaGrid, 1);
                    this.xmodelopu.setValueAt(false, filaGrid, 2);
                    this.xmodelopu.setValueAt(new Integer(0), filaGrid, 3);
                    filaGrid++;
                }
            }
            rs.close();
            this.xconsultas.cerrarConexionBd();
        } catch (Exception ex) {
            Logger.getLogger(JIFRegistroInformacionPlacas.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mGrabar() {
        if (Principal.txtNo.getText().isEmpty()) {
            if (this.JTBResultado.getSelectedRow() != -1) {
                int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (n == 0) {
                    String sql = "insert into h_informe_imagenesdx(FechaR, Observacion, Estado, Fecha, UsuarioS) values('" + this.xmetodos.formatoAMD.format(this.JDFFechaR.getDate()) + "','" + this.JTADDescripcion.getText() + "','1','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                    Principal.txtNo.setText(this.xconsultas.ejecutarSQLId(sql));
                    this.xconsultas.cerrarConexionBd();
                    for (int x = 0; x < this.JTBPUtilizadas.getRowCount(); x++) {
                        if (Boolean.valueOf(this.xmodelopu.getValueAt(x, 2).toString()).booleanValue() && Integer.valueOf(this.xmodelopu.getValueAt(x, 3).toString()).intValue() != 0) {
                            String sql2 = "insert into h_informe_detalle_imagenesdx (Id_infomesdx, Id_OrdenFac, Id_Procedimiento, Id_TipoPlaca, Id_TipoDano, Cantidad) values ('" + Principal.txtNo.getText() + "','" + this.xmodelo.getValueAt(this.JTBResultado.getSelectedRow(), 0) + "','" + this.xmodelo.getValueAt(this.JTBResultado.getSelectedRow(), 7) + "','" + this.xmodelopu.getValueAt(x, 0) + "','1','" + this.xmodelopu.getValueAt(x, 3) + "')";
                            this.xconsultas.ejecutarSQL(sql2);
                            this.xconsultas.cerrarConexionBd();
                        }
                    }
                    mActulizarEstadoProcedimiento();
                    return;
                }
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un registro", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Registro ya grabado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    public void mActulizarEstadoProcedimiento() {
        String sql = "update f_itemordenesproced set EsRecepcionado=1 where Id_Ordenes='" + this.xmodelo.getValueAt(this.JTBResultado.getSelectedRow(), 0) + "' and Id_Procedimiento='" + this.xmodelo.getValueAt(this.JTBResultado.getSelectedRow(), 7) + "'";
        this.xconsultas.ejecutarSQL(sql);
        this.xconsultas.cerrarConexionBd();
    }
}
