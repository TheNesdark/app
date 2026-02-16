package Sig;

import Acceso.Principal;
import Utilidades.Metodos;
import com.genoma.plus.jpa.projection.InformeSalidaAdministrativaProjection;
import com.genoma.plus.jpa.service.IIngresoSalidaAdministrativaService;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
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
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Sig/JIFInformeSalidaAdministrativa.class */
public class JIFInformeSalidaAdministrativa extends JInternalFrame {
    List<InformeSalidaAdministrativaProjection> listSalidasAdministrativas;
    private Object[] xdatos;
    private DefaultTableModel xmodelo;
    public Boolean xEstado;
    private ButtonGroup GroupFiltros;
    private JButton JBTExportar;
    private JDateChooser JDCFechaFin;
    private JDateChooser JDCFechaInicio;
    private JRadioButton JRBActivos;
    private JRadioButton JRBAnulados;
    private JRadioButton JRBTodos;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;
    private JTextField JTFRuta;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private final IIngresoSalidaAdministrativaService administrativaService = (IIngresoSalidaAdministrativaService) Principal.contexto.getBean(IIngresoSalidaAdministrativaService.class);
    private Metodos xmt = new Metodos();

    public JIFInformeSalidaAdministrativa(String xtitulo) {
        setTitle(xtitulo.toUpperCase());
        initComponents();
        this.JDCFechaInicio.setDate(this.xmt.getFechaActual());
        this.JDCFechaFin.setDate(this.xmt.getFechaActual());
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloTabla() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Fecha Inicio", "Identificacion", "Nombre Usuario", "Sexo", "Empresa Convenio", "Fecha Salida", "Motivo Salida", "Estado", "Usuario Registro", "Cargo", "Fecha Registro", "Concepto Anulacion", "Detalle Anulacion", "Fecha Anulacion", "Usuario Anulacion"}) { // from class: Sig.JIFInformeSalidaAdministrativa.1
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, Boolean.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

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
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(40);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(250);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(12).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(13).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(14).setPreferredWidth(100);
    }

    private void mCargarDatosTabla() {
        mCrearModeloTabla();
        if (this.JRBTodos.isSelected()) {
            this.listSalidasAdministrativas = this.administrativaService.listarSalidasAdministrativas(this.JDCFechaInicio.getDate(), this.JDCFechaFin.getDate(), new ArrayList(Arrays.asList(true, false)));
        } else if (this.JRBActivos.isSelected()) {
            this.listSalidasAdministrativas = this.administrativaService.listarSalidasAdministrativas(this.JDCFechaInicio.getDate(), this.JDCFechaFin.getDate(), new ArrayList(Arrays.asList(true)));
        } else if (this.JRBAnulados.isSelected()) {
            this.listSalidasAdministrativas = this.administrativaService.listarSalidasAdministrativas(this.JDCFechaInicio.getDate(), this.JDCFechaFin.getDate(), new ArrayList(Arrays.asList(false)));
        }
        if (!this.listSalidasAdministrativas.isEmpty()) {
            for (int i = 0; i < this.listSalidasAdministrativas.size(); i++) {
                this.xmodelo.addRow(this.xdatos);
                this.xmodelo.setValueAt(this.listSalidasAdministrativas.get(i).getFechaIngreso(), i, 0);
                this.xmodelo.setValueAt(this.listSalidasAdministrativas.get(i).getIdentificacion(), i, 1);
                this.xmodelo.setValueAt(this.listSalidasAdministrativas.get(i).getNombreUsuario(), i, 2);
                this.xmodelo.setValueAt(this.listSalidasAdministrativas.get(i).getSexp(), i, 3);
                this.xmodelo.setValueAt(this.listSalidasAdministrativas.get(i).getEmpresaConvenio(), i, 4);
                this.xmodelo.setValueAt(this.listSalidasAdministrativas.get(i).getFechaSalida(), i, 5);
                this.xmodelo.setValueAt(this.listSalidasAdministrativas.get(i).getMotivoSalida(), i, 6);
                this.xmodelo.setValueAt(this.listSalidasAdministrativas.get(i).getEstado(), i, 7);
                this.xmodelo.setValueAt(this.listSalidasAdministrativas.get(i).getUsuarioRegistro(), i, 8);
                this.xmodelo.setValueAt(this.listSalidasAdministrativas.get(i).getCargo(), i, 9);
                this.xmodelo.setValueAt(this.listSalidasAdministrativas.get(i).getFechaRegistro(), i, 10);
                this.xmodelo.setValueAt(this.listSalidasAdministrativas.get(i).getConceptoAnulacion(), i, 11);
                this.xmodelo.setValueAt(this.listSalidasAdministrativas.get(i).getDetalleAnulacion(), i, 12);
                this.xmodelo.setValueAt(this.listSalidasAdministrativas.get(i).getFechaAnulacion(), i, 13);
                this.xmodelo.setValueAt(this.listSalidasAdministrativas.get(i).getUsuarioAnulacion(), i, 14);
            }
        }
    }

    /* JADX WARN: Type inference failed for: r3v6, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.GroupFiltros = new ButtonGroup();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.jPanel1 = new JPanel();
        this.JDCFechaInicio = new JDateChooser();
        this.JDCFechaFin = new JDateChooser();
        this.jPanel2 = new JPanel();
        this.JRBTodos = new JRadioButton();
        this.JRBActivos = new JRadioButton();
        this.JRBAnulados = new JRadioButton();
        this.JBTExportar = new JButton();
        this.JTFRuta = new JTextField();
        setClosable(true);
        setIconifiable(true);
        setTitle("INFORME SALIDA ADMINISTRATIVA");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjif_InformeSalidaAdministrativa");
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "REGISTROS", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(Color.white);
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: Sig.JIFInformeSalidaAdministrativa.2
            public void mouseClicked(MouseEvent evt) {
                JIFInformeSalidaAdministrativa.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS PARA FILTRO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JDCFechaInicio.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFechaInicio.setFont(new Font("Arial", 1, 12));
        this.JDCFechaFin.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Fin", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFechaFin.setFont(new Font("Arial", 1, 12));
        this.jPanel2.setBorder(BorderFactory.createEtchedBorder());
        this.GroupFiltros.add(this.JRBTodos);
        this.JRBTodos.setFont(new Font("Arial", 1, 12));
        this.JRBTodos.setSelected(true);
        this.JRBTodos.setText("Todos");
        this.JRBTodos.addActionListener(new ActionListener() { // from class: Sig.JIFInformeSalidaAdministrativa.3
            public void actionPerformed(ActionEvent evt) {
                JIFInformeSalidaAdministrativa.this.JRBTodosActionPerformed(evt);
            }
        });
        this.GroupFiltros.add(this.JRBActivos);
        this.JRBActivos.setFont(new Font("Arial", 1, 12));
        this.JRBActivos.setText("Activos");
        this.JRBActivos.addActionListener(new ActionListener() { // from class: Sig.JIFInformeSalidaAdministrativa.4
            public void actionPerformed(ActionEvent evt) {
                JIFInformeSalidaAdministrativa.this.JRBActivosActionPerformed(evt);
            }
        });
        this.GroupFiltros.add(this.JRBAnulados);
        this.JRBAnulados.setFont(new Font("Arial", 1, 12));
        this.JRBAnulados.setText("Anulados");
        this.JRBAnulados.addActionListener(new ActionListener() { // from class: Sig.JIFInformeSalidaAdministrativa.5
            public void actionPerformed(ActionEvent evt) {
                JIFInformeSalidaAdministrativa.this.JRBAnuladosActionPerformed(evt);
            }
        });
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(this.JRBTodos).addGap(18, 18, 18).addComponent(this.JRBActivos).addGap(18, 18, 18).addComponent(this.JRBAnulados).addContainerGap(-1, 32767)));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup().addContainerGap(-1, 32767).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBTodos).addComponent(this.JRBActivos).addComponent(this.JRBAnulados)).addContainerGap()));
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.JDCFechaInicio, -2, 141, -2).addGap(18, 18, 18).addComponent(this.JDCFechaFin, -2, 140, -2).addGap(52, 52, 52).addComponent(this.jPanel2, -2, -1, -2).addContainerGap(-1, 32767)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JDCFechaFin, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.jPanel2, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.JDCFechaInicio, GroupLayout.Alignment.LEADING, -1, -1, 32767)).addContainerGap(16, 32767)));
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: Sig.JIFInformeSalidaAdministrativa.6
            public void actionPerformed(ActionEvent evt) {
                JIFInformeSalidaAdministrativa.this.JBTExportarActionPerformed(evt);
            }
        });
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: Sig.JIFInformeSalidaAdministrativa.7
            public void mouseClicked(MouseEvent evt) {
                JIFInformeSalidaAdministrativa.this.JTFRutaMouseClicked(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -1, -1, 32767).addGroup(layout.createSequentialGroup().addComponent(this.JTFRuta, -2, 386, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBTExportar, -2, 238, -2).addGap(0, 337, 32767)).addComponent(this.JSPDetalle)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPDetalle, -2, 385, -2).addGap(18, 18, 18).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFRuta, -2, 51, -2).addComponent(this.JBTExportar, -1, 50, 32767)).addContainerGap(-1, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBTodosActionPerformed(ActionEvent evt) {
        mCargarDatosTabla();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBActivosActionPerformed(ActionEvent evt) {
        mCargarDatosTabla();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBAnuladosActionPerformed(ActionEvent evt) {
        mCargarDatosTabla();
    }

    private void mExportarInformacion() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTExportarActionPerformed(ActionEvent evt) {
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTDetalle, this.JTFRuta.getText(), getTitle());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JFileChooser xfilec = new JFileChooser(this.xmt.getDirectorioExportacion());
            xfilec.setFileSelectionMode(1);
            int xv = xfilec.showOpenDialog(this);
            if (xv == 0) {
                File xfile = xfilec.getSelectedFile();
                this.JTFRuta.setText(xfile.getAbsolutePath() + this.xmt.getBarra());
                this.JTFRuta.requestFocus();
            }
        }
    }
}
