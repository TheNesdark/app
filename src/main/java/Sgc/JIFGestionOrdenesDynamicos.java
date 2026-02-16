package Sgc;

import Acceso.Principal;
import Utilidades.Metodos;
import com.genoma.plus.jpa.projection.GestionOrdenesDynamicosProjection;
import com.genoma.plus.jpa.service.FFacturaCapitaService;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
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

/* JADX INFO: loaded from: GenomaP.jar:Sgc/JIFGestionOrdenesDynamicos.class */
public class JIFGestionOrdenesDynamicos extends JInternalFrame {
    private final FFacturaCapitaService fFacturaCapitaService;
    private GestionOrdenesDynamicosProjection gestionOrdenesDynamicos;
    private DefaultTableModel modelo;
    private Object[] dato;
    private List<GestionOrdenesDynamicosProjection> listaGestionDynamicos;
    private List<GestionOrdenesDynamicosProjection> listaActualizarDynamicos;
    private Date fechaInicial;
    private Date fechaFinal;
    private int caso;
    private int actualizar;
    private JButton JBTExportar15;
    private JButton JBTNActualizar;
    private JCheckBox JCHCaso;
    private JCheckBox JCHOtro;
    private JCheckBox JCHSinCaso;
    private JDateChooser JDCFechaFinal;
    private JDateChooser JDCFechaInicial;
    private JTable JTBGestionDynamicos;
    private JTabbedPane JTBPDynamicos;
    private JTextField JTFFacturaCapita;
    private JTextField JTFRuta;
    private JFrame jFrame1;
    private JPanel jPanel1;
    private JPanel jPanel16;
    private JPanel jPanel2;
    private JScrollPane jScrollPane1;
    private Boolean xlleno = false;
    private Metodos metodo = new Metodos();

    public JIFGestionOrdenesDynamicos() {
        initComponents();
        mNuevo();
        this.listaGestionDynamicos = new ArrayList();
        this.fFacturaCapitaService = (FFacturaCapitaService) Principal.contexto.getBean(FFacturaCapitaService.class);
        cargarDatosTabla();
    }

    public void mNuevo() {
        this.JDCFechaInicial.setDate(this.metodo.getFechaActual());
        this.JDCFechaFinal.setDate(this.metodo.getFechaActual());
        this.JCHCaso.setSelected(false);
        this.JCHSinCaso.setSelected(false);
        this.JCHOtro.setSelected(false);
        this.caso = 0;
    }

    public void guardar() {
        this.listaActualizarDynamicos = this.fFacturaCapitaService.listaActualizarDynamicos(Integer.valueOf(this.actualizar));
    }

    public void crearModeloTabla() {
        this.modelo = new DefaultTableModel((Object[][]) null, new String[]{"Identificacion", "Nombre", "Telefono", "FacturaCapita", "TipoContrato", "FechaFacturaCapita", "UrlOrdenMedica", "UrlScreenshot", "Dx", "EsCitologia", "Caso"}) { // from class: Sgc.JIFGestionOrdenesDynamicos.1
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTBGestionDynamicos.setModel(this.modelo);
        this.JTBGestionDynamicos.setAutoResizeMode(0);
        this.JTBGestionDynamicos.doLayout();
        this.JTBGestionDynamicos.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTBGestionDynamicos.getColumnModel().getColumn(1).setPreferredWidth(200);
        this.JTBGestionDynamicos.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTBGestionDynamicos.getColumnModel().getColumn(3).setPreferredWidth(150);
        this.JTBGestionDynamicos.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTBGestionDynamicos.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTBGestionDynamicos.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTBGestionDynamicos.getColumnModel().getColumn(7).setPreferredWidth(100);
        this.JTBGestionDynamicos.getColumnModel().getColumn(8).setPreferredWidth(100);
        this.JTBGestionDynamicos.getColumnModel().getColumn(9).setPreferredWidth(100);
        this.JTBGestionDynamicos.getColumnModel().getColumn(10).setPreferredWidth(100);
    }

    public void cargarDatosTabla() {
        crearModeloTabla();
        this.fechaInicial = this.JDCFechaInicial.getDate();
        this.fechaFinal = this.JDCFechaFinal.getDate();
        this.listaGestionDynamicos = this.fFacturaCapitaService.listaGestionDynamicos(this.fechaInicial, this.fechaFinal, Integer.valueOf(this.caso));
        this.listaGestionDynamicos.forEach(e -> {
            this.modelo.addRow(this.dato);
            this.modelo.setValueAt(e.getIdentificacion(), this.JTBGestionDynamicos.getRowCount() - 1, 0);
            this.modelo.setValueAt(e.getNombre(), this.JTBGestionDynamicos.getRowCount() - 1, 1);
            this.modelo.setValueAt(e.getTelefono(), this.JTBGestionDynamicos.getRowCount() - 1, 2);
            this.modelo.setValueAt(e.getFacturaCapita(), this.JTBGestionDynamicos.getRowCount() - 1, 3);
            this.modelo.setValueAt(e.getTipoContrato(), this.JTBGestionDynamicos.getRowCount() - 1, 4);
            this.modelo.setValueAt(e.getFechaFacturaCapita(), this.JTBGestionDynamicos.getRowCount() - 1, 5);
            this.modelo.setValueAt(e.getUrlOrdenMedica(), this.JTBGestionDynamicos.getRowCount() - 1, 6);
            this.modelo.setValueAt(e.getUrlScreenshot(), this.JTBGestionDynamicos.getRowCount() - 1, 7);
            this.modelo.setValueAt(e.getDx(), this.JTBGestionDynamicos.getRowCount() - 1, 8);
            this.modelo.setValueAt(e.getEsCitologia(), this.JTBGestionDynamicos.getRowCount() - 1, 9);
            this.modelo.setValueAt(e.getCaso(), this.JTBGestionDynamicos.getRowCount() - 1, 10);
        });
    }

    /* JADX WARN: Type inference failed for: r3v8, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jFrame1 = new JFrame();
        this.jScrollPane1 = new JScrollPane();
        this.JTBGestionDynamicos = new JTable();
        this.jPanel16 = new JPanel();
        this.JTFRuta = new JTextField();
        this.JBTExportar15 = new JButton();
        this.JTBPDynamicos = new JTabbedPane();
        this.jPanel2 = new JPanel();
        this.JCHCaso = new JCheckBox();
        this.JCHSinCaso = new JCheckBox();
        this.JDCFechaFinal = new JDateChooser();
        this.JDCFechaInicial = new JDateChooser();
        this.JCHOtro = new JCheckBox();
        this.jPanel1 = new JPanel();
        this.JTFFacturaCapita = new JTextField();
        this.JBTNActualizar = new JButton();
        GroupLayout jFrame1Layout = new GroupLayout(this.jFrame1.getContentPane());
        this.jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(jFrame1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 400, 32767));
        jFrame1Layout.setVerticalGroup(jFrame1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 300, 32767));
        setClosable(true);
        setTitle("GESTION DE ORDENES DINAMICOS");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifgestionordenes");
        this.jScrollPane1.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTORICO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTBGestionDynamicos.setFont(new Font("Liberation Sans", 1, 14));
        this.JTBGestionDynamicos.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTBGestionDynamicos.addMouseListener(new MouseAdapter() { // from class: Sgc.JIFGestionOrdenesDynamicos.2
            public void mouseClicked(MouseEvent evt) {
                JIFGestionOrdenesDynamicos.this.JTBGestionDynamicosMouseClicked(evt);
            }
        });
        this.jScrollPane1.setViewportView(this.JTBGestionDynamicos);
        this.JTBGestionDynamicos.getAccessibleContext().setAccessibleName("");
        this.jPanel16.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS PARA EXPORTAR", 0, 0, new Font("Arial", 1, 14), Color.red));
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma\\GenomaP");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: Sgc.JIFGestionOrdenesDynamicos.3
            public void mouseClicked(MouseEvent evt) {
                JIFGestionOrdenesDynamicos.this.JTFRutaJTFRutaMouseClicked(evt);
            }
        });
        this.JTFRuta.addActionListener(new ActionListener() { // from class: Sgc.JIFGestionOrdenesDynamicos.4
            public void actionPerformed(ActionEvent evt) {
                JIFGestionOrdenesDynamicos.this.JTFRutaActionPerformed(evt);
            }
        });
        this.JBTExportar15.setFont(new Font("Arial", 1, 12));
        this.JBTExportar15.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar15.setText("Exportar");
        this.JBTExportar15.addActionListener(new ActionListener() { // from class: Sgc.JIFGestionOrdenesDynamicos.5
            public void actionPerformed(ActionEvent evt) {
                JIFGestionOrdenesDynamicos.this.JBTExportar15JBTExportarActionPerformed(evt);
            }
        });
        GroupLayout jPanel16Layout = new GroupLayout(this.jPanel16);
        this.jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(jPanel16Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel16Layout.createSequentialGroup().addContainerGap().addComponent(this.JTFRuta).addGap(35, 35, 35).addComponent(this.JBTExportar15, -2, 276, -2).addGap(12, 12, 12)));
        jPanel16Layout.setVerticalGroup(jPanel16Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel16Layout.createSequentialGroup().addGroup(jPanel16Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFRuta, -2, 50, -2).addComponent(this.JBTExportar15, -2, 50, -2)).addContainerGap(12, 32767)));
        this.JTBPDynamicos.setForeground(new Color(0, 103, 0));
        this.JTBPDynamicos.setFont(new Font("Arial", 1, 14));
        this.jPanel2.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JCHCaso.setFont(new Font("Arial", 1, 12));
        this.JCHCaso.setText("Caso");
        this.JCHCaso.addActionListener(new ActionListener() { // from class: Sgc.JIFGestionOrdenesDynamicos.6
            public void actionPerformed(ActionEvent evt) {
                JIFGestionOrdenesDynamicos.this.JCHCasoActionPerformed(evt);
            }
        });
        this.JCHSinCaso.setFont(new Font("Arial", 1, 12));
        this.JCHSinCaso.setText("Sin caso");
        this.JCHSinCaso.addActionListener(new ActionListener() { // from class: Sgc.JIFGestionOrdenesDynamicos.7
            public void actionPerformed(ActionEvent evt) {
                JIFGestionOrdenesDynamicos.this.JCHSinCasoActionPerformed(evt);
            }
        });
        this.JDCFechaFinal.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha final", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFechaFinal.setDateFormatString("dd/MM/yyyy");
        this.JDCFechaFinal.setFont(new Font("Arial", 1, 12));
        this.JDCFechaFinal.addPropertyChangeListener(new PropertyChangeListener() { // from class: Sgc.JIFGestionOrdenesDynamicos.8
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFGestionOrdenesDynamicos.this.JDCFechaFinalPropertyChange(evt);
            }
        });
        this.JDCFechaFinal.addKeyListener(new KeyAdapter() { // from class: Sgc.JIFGestionOrdenesDynamicos.9
            public void keyPressed(KeyEvent evt) {
                JIFGestionOrdenesDynamicos.this.JDCFechaFinalKeyPressed(evt);
            }
        });
        this.JDCFechaInicial.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicial", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFechaInicial.setDateFormatString("dd/MM/yyyy");
        this.JDCFechaInicial.setFont(new Font("Arial", 1, 12));
        this.JDCFechaInicial.addPropertyChangeListener(new PropertyChangeListener() { // from class: Sgc.JIFGestionOrdenesDynamicos.10
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFGestionOrdenesDynamicos.this.JDCFechaInicialPropertyChange(evt);
            }
        });
        this.JDCFechaInicial.addKeyListener(new KeyAdapter() { // from class: Sgc.JIFGestionOrdenesDynamicos.11
            public void keyPressed(KeyEvent evt) {
                JIFGestionOrdenesDynamicos.this.JDCFechaInicialKeyPressed(evt);
            }
        });
        this.JCHOtro.setFont(new Font("Arial", 1, 12));
        this.JCHOtro.setText("Otro");
        this.JCHOtro.addActionListener(new ActionListener() { // from class: Sgc.JIFGestionOrdenesDynamicos.12
            public void actionPerformed(ActionEvent evt) {
                JIFGestionOrdenesDynamicos.this.JCHOtroActionPerformed(evt);
            }
        });
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup().addGap(17, 17, 17).addComponent(this.JDCFechaInicial, -2, 167, -2).addGap(47, 47, 47).addComponent(this.JDCFechaFinal, -2, 178, -2).addGap(34, 34, 34).addComponent(this.JCHCaso).addGap(28, 28, 28).addComponent(this.JCHSinCaso).addGap(29, 29, 29).addComponent(this.JCHOtro).addContainerGap(20, 32767)));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup().addContainerGap(-1, 32767).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JDCFechaFinal, -2, 56, -2).addComponent(this.JDCFechaInicial, -2, 56, -2)).addGap(137, 137, 137)).addGroup(jPanel2Layout.createSequentialGroup().addGap(26, 26, 26).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCHCaso).addComponent(this.JCHOtro).addComponent(this.JCHSinCaso)).addContainerGap(-1, 32767)));
        this.JTBPDynamicos.addTab("DATOS ", this.jPanel2);
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "ACTUALIZAR DATOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTFFacturaCapita.setFont(new Font("Liberation Sans", 1, 14));
        this.JTFFacturaCapita.setBorder(BorderFactory.createTitledBorder((Border) null, "Nº Factura Capita", 0, 0, new Font("Arial", 1, 14), Color.blue));
        this.JTFFacturaCapita.addMouseListener(new MouseAdapter() { // from class: Sgc.JIFGestionOrdenesDynamicos.13
            public void mouseClicked(MouseEvent evt) {
                JIFGestionOrdenesDynamicos.this.JTFFacturaCapitaMouseClicked(evt);
            }
        });
        this.JBTNActualizar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Bueno.png")));
        this.JBTNActualizar.setText("ACTUALIZAR");
        this.JBTNActualizar.addActionListener(new ActionListener() { // from class: Sgc.JIFGestionOrdenesDynamicos.14
            public void actionPerformed(ActionEvent evt) {
                JIFGestionOrdenesDynamicos.this.JBTNActualizarActionPerformed(evt);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(85, 85, 85).addComponent(this.JTFFacturaCapita, -2, 209, -2).addGap(71, 71, 71).addComponent(this.JBTNActualizar, -2, 249, -2).addContainerGap(101, 32767)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(9, 9, 9).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JBTNActualizar, -1, -1, 32767).addComponent(this.JTFFacturaCapita, -1, 53, 32767)).addGap(20, 20, 20)));
        this.JTBPDynamicos.addTab("ACTUALIZAR", this.jPanel1);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(6, 6, 6).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel16, -1, -1, 32767).addComponent(this.JTBPDynamicos, GroupLayout.Alignment.TRAILING).addComponent(this.jScrollPane1)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTBPDynamicos, -2, 139, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane1, -1, 225, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel16, -2, -1, -2).addContainerGap()));
        this.JTBPDynamicos.getAccessibleContext().setAccessibleName("DATOS");
        this.JTBPDynamicos.getAccessibleContext().setAccessibleDescription("");
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaJTFRutaMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JFileChooser xfilec = new JFileChooser(this.JTFRuta.getText());
            xfilec.setFileSelectionMode(1);
            int xv = xfilec.showOpenDialog(this);
            if (xv == 0) {
                File xfile = xfilec.getSelectedFile();
                this.JTFRuta.setText(xfile.getAbsolutePath() + this.metodo.getBarra());
                this.JTFRuta.requestFocus();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTExportar15JBTExportarActionPerformed(ActionEvent evt) {
        if (this.JTBGestionDynamicos.getRowCount() > 0) {
            int n = JOptionPane.showConfirmDialog(this, "Esta seguro de exportar la informacion", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                this.metodo.mExportar_Datos_Tabla_Titulo_Formato(this.JTBGestionDynamicos, this.JTFRuta.getText(), getTitle());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHCasoActionPerformed(ActionEvent evt) {
        if (this.JCHCaso.isSelected()) {
            this.caso = 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHSinCasoActionPerformed(ActionEvent evt) {
        if (this.JCHSinCaso.isSelected()) {
            this.caso = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDCFechaFinalPropertyChange(PropertyChangeEvent evt) {
        if (this.xlleno.booleanValue()) {
            cargarDatosTabla();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDCFechaFinalKeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDCFechaInicialPropertyChange(PropertyChangeEvent evt) {
        if (this.xlleno.booleanValue()) {
            cargarDatosTabla();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDCFechaInicialKeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHOtroActionPerformed(ActionEvent evt) {
        if (this.JCHOtro.isSelected()) {
            this.caso = 2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTNActualizarActionPerformed(ActionEvent evt) {
        this.actualizar = Integer.valueOf(this.JTFFacturaCapita.getText()).intValue();
        guardar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFacturaCapitaMouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBGestionDynamicosMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            this.gestionOrdenesDynamicos = this.listaGestionDynamicos.get(this.JTBGestionDynamicos.getSelectedRow());
            this.JTFFacturaCapita.setText(this.listaGestionDynamicos.get(this.JTBGestionDynamicos.getSelectedRow()).getFacturaCapita());
        }
    }
}
