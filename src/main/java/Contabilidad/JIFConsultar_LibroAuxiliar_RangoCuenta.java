package Contabilidad;

import Acceso.Principal;
import Historia.JDPatologia;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import Utilidades.WorkerSQL;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
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
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
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
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Contabilidad/JIFConsultar_LibroAuxiliar_RangoCuenta.class */
public class JIFConsultar_LibroAuxiliar_RangoCuenta extends JInternalFrame {
    private String[][] xid;
    private String xPadre;
    private String xsql;
    private Object[] xdato;
    private DefaultTableModel xmodelo2;
    private DefaultTableModel xmodelo;
    private Object[] xdatos;
    private String xTitulo;
    private WorkerSQL xWorkerSQL;
    private JButton JBBuscaTercero;
    private JButton JBTExportar;
    private JCheckBox JCBFiltroPorRangoPuc;
    public JCheckBox JCBFiltroPorTercero;
    private JCheckBox JCHVisualizarNiif;
    private JCheckBox JCH_IncluirMovCierre;
    private JDateChooser JDCFechaFin;
    private JDateChooser JDCFechaInicio;
    public JLabel JLTercero;
    private JPanel JPIDatosP;
    private JScrollPane JSPDetalle;
    private JScrollPane JSPMovimiento;
    private JSpinner JSPNivel;
    private JTable JTDetalle;
    private JTextField JTFCuentaF;
    private JTextField JTFCuentaI;
    private JTextField JTFRuta;
    private JTable JTH_Detalle;
    private JTabbedPane JTPDetalle;
    private JPanel jPanel1;
    private ConsultasMySQL xct = new ConsultasMySQL();
    private int xNCaracter = 0;
    private final int xM = 2;
    private String[] x6 = new String[4];
    private String[] x8 = new String[5];
    private String[] x10 = new String[6];
    private String[] x12 = new String[7];
    private String xIncluirCierre = "in(0,1)";
    private String xAplicaNiif = "in(0)";
    private Metodos xmt = new Metodos();
    private String xcodigo = "";
    private boolean esgenerado = false;
    public String idTercero = "";

    public JIFConsultar_LibroAuxiliar_RangoCuenta(String xTitulo) {
        initComponents();
        setTitle(xTitulo.toUpperCase());
        this.xTitulo = xTitulo;
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v69, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v73, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPIDatosP = new JPanel();
        this.JDCFechaInicio = new JDateChooser();
        this.JDCFechaFin = new JDateChooser();
        this.jPanel1 = new JPanel();
        this.JTFCuentaI = new JTextField();
        this.JTFCuentaF = new JTextField();
        this.JSPNivel = new JSpinner();
        this.JCHVisualizarNiif = new JCheckBox();
        this.JCH_IncluirMovCierre = new JCheckBox();
        this.JLTercero = new JLabel();
        this.JBBuscaTercero = new JButton();
        this.JCBFiltroPorTercero = new JCheckBox();
        this.JCBFiltroPorRangoPuc = new JCheckBox();
        this.JTFRuta = new JTextField();
        this.JBTExportar = new JButton();
        this.JTPDetalle = new JTabbedPane();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JSPMovimiento = new JScrollPane();
        this.JTH_Detalle = new JTable();
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("CONSULTAR LIBRO AUXILIAR POR RANGO DE CUENTAS");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjif_libro_auxiliar_rangocuentas");
        this.JPIDatosP.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACION", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JDCFechaInicio.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicio", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFechaInicio.setDateFormatString("dd/MM/yyyy");
        this.JDCFechaInicio.setFont(new Font("Arial", 1, 12));
        this.JDCFechaFin.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Fin", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFechaFin.setDateFormatString("dd/MM/yyyy");
        this.JDCFechaFin.setFont(new Font("Arial", 1, 12));
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "RANGO PUC", 2, 0, new Font("Arial", 1, 12), Color.red));
        this.JTFCuentaI.setFont(new Font("Arial", 1, 12));
        this.JTFCuentaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Codigo Inicial", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFCuentaI.addFocusListener(new FocusAdapter() { // from class: Contabilidad.JIFConsultar_LibroAuxiliar_RangoCuenta.1
            public void focusLost(FocusEvent evt) {
                JIFConsultar_LibroAuxiliar_RangoCuenta.this.JTFCuentaIFocusLost(evt);
            }
        });
        this.JTFCuentaI.addKeyListener(new KeyAdapter() { // from class: Contabilidad.JIFConsultar_LibroAuxiliar_RangoCuenta.2
            public void keyPressed(KeyEvent evt) {
                JIFConsultar_LibroAuxiliar_RangoCuenta.this.JTFCuentaIKeyPressed(evt);
            }

            public void keyReleased(KeyEvent evt) {
                JIFConsultar_LibroAuxiliar_RangoCuenta.this.JTFCuentaIKeyReleased(evt);
            }
        });
        this.JTFCuentaF.setFont(new Font("Arial", 1, 12));
        this.JTFCuentaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Codigo Final", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFCuentaF.addFocusListener(new FocusAdapter() { // from class: Contabilidad.JIFConsultar_LibroAuxiliar_RangoCuenta.3
            public void focusLost(FocusEvent evt) {
                JIFConsultar_LibroAuxiliar_RangoCuenta.this.JTFCuentaFFocusLost(evt);
            }
        });
        this.JTFCuentaF.addKeyListener(new KeyAdapter() { // from class: Contabilidad.JIFConsultar_LibroAuxiliar_RangoCuenta.4
            public void keyPressed(KeyEvent evt) {
                JIFConsultar_LibroAuxiliar_RangoCuenta.this.JTFCuentaFKeyPressed(evt);
            }

            public void keyReleased(KeyEvent evt) {
                JIFConsultar_LibroAuxiliar_RangoCuenta.this.JTFCuentaFKeyReleased(evt);
            }
        });
        this.JSPNivel.setFont(new Font("Arial", 1, 12));
        this.JSPNivel.setModel(new SpinnerNumberModel(8, 1, 20, 1));
        this.JSPNivel.setBorder(BorderFactory.createTitledBorder((Border) null, "Nivel", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPNivel.addChangeListener(new ChangeListener() { // from class: Contabilidad.JIFConsultar_LibroAuxiliar_RangoCuenta.5
            public void stateChanged(ChangeEvent evt) {
                JIFConsultar_LibroAuxiliar_RangoCuenta.this.JSPNivelStateChanged(evt);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.JTFCuentaI, -2, 158, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFCuentaF, -2, 158, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPNivel, -2, 89, -2).addContainerGap(-1, 32767)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JTFCuentaF).addComponent(this.JSPNivel, -1, 55, 32767).addComponent(this.JTFCuentaI)).addGap(0, 0, 0)));
        this.JCHVisualizarNiif.setFont(new Font("Arial", 1, 13));
        this.JCHVisualizarNiif.setText("Visualizacion NIIF");
        this.JCHVisualizarNiif.addActionListener(new ActionListener() { // from class: Contabilidad.JIFConsultar_LibroAuxiliar_RangoCuenta.6
            public void actionPerformed(ActionEvent evt) {
                JIFConsultar_LibroAuxiliar_RangoCuenta.this.JCHVisualizarNiifActionPerformed(evt);
            }
        });
        this.JCH_IncluirMovCierre.setFont(new Font("Arial", 1, 13));
        this.JCH_IncluirMovCierre.setText("Incluir Movimiento Cierre?");
        this.JCH_IncluirMovCierre.addActionListener(new ActionListener() { // from class: Contabilidad.JIFConsultar_LibroAuxiliar_RangoCuenta.7
            public void actionPerformed(ActionEvent evt) {
                JIFConsultar_LibroAuxiliar_RangoCuenta.this.JCH_IncluirMovCierreActionPerformed(evt);
            }
        });
        this.JLTercero.setFont(new Font("Arial", 1, 12));
        this.JLTercero.setBorder(BorderFactory.createTitledBorder((Border) null, "Tercero", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBBuscaTercero.setIcon(new ImageIcon(getClass().getResource("/Imagenes/lupa.png")));
        this.JBBuscaTercero.setToolTipText("Buscar Tercero");
        this.JBBuscaTercero.setName("xRadicacion");
        this.JBBuscaTercero.addActionListener(new ActionListener() { // from class: Contabilidad.JIFConsultar_LibroAuxiliar_RangoCuenta.8
            public void actionPerformed(ActionEvent evt) {
                JIFConsultar_LibroAuxiliar_RangoCuenta.this.JBBuscaTerceroActionPerformed(evt);
            }
        });
        this.JCBFiltroPorTercero.setFont(new Font("Arial", 1, 12));
        this.JCBFiltroPorTercero.setText("Filtro por tercero");
        this.JCBFiltroPorTercero.addActionListener(new ActionListener() { // from class: Contabilidad.JIFConsultar_LibroAuxiliar_RangoCuenta.9
            public void actionPerformed(ActionEvent evt) {
                JIFConsultar_LibroAuxiliar_RangoCuenta.this.JCBFiltroPorTerceroActionPerformed(evt);
            }
        });
        this.JCBFiltroPorRangoPuc.setFont(new Font("Arial", 1, 12));
        this.JCBFiltroPorRangoPuc.setText("Filtro por rango puc");
        this.JCBFiltroPorRangoPuc.addActionListener(new ActionListener() { // from class: Contabilidad.JIFConsultar_LibroAuxiliar_RangoCuenta.10
            public void actionPerformed(ActionEvent evt) {
                JIFConsultar_LibroAuxiliar_RangoCuenta.this.JCBFiltroPorRangoPucActionPerformed(evt);
            }
        });
        GroupLayout JPIDatosPLayout = new GroupLayout(this.JPIDatosP);
        this.JPIDatosP.setLayout(JPIDatosPLayout);
        JPIDatosPLayout.setHorizontalGroup(JPIDatosPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosPLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosPLayout.createSequentialGroup().addComponent(this.JDCFechaInicio, -2, 125, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JDCFechaFin, -2, 125, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED, -1, 32767).addGroup(JPIDatosPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCH_IncluirMovCierre).addComponent(this.JCHVisualizarNiif))).addGroup(JPIDatosPLayout.createSequentialGroup().addComponent(this.JLTercero, -2, 481, -2).addGap(31, 31, 31).addComponent(this.JBBuscaTercero, -2, 58, -2).addGap(18, 18, 18).addComponent(this.JCBFiltroPorTercero).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBFiltroPorRangoPuc).addGap(0, 0, 32767)))));
        JPIDatosPLayout.setVerticalGroup(JPIDatosPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosPLayout.createSequentialGroup().addGroup(JPIDatosPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosPLayout.createSequentialGroup().addContainerGap().addComponent(this.JCH_IncluirMovCierre).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHVisualizarNiif)).addGroup(JPIDatosPLayout.createSequentialGroup().addGroup(JPIDatosPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -2, -1, -2).addGroup(JPIDatosPLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosPLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JDCFechaFin, -2, 56, -2).addComponent(this.JDCFechaInicio, -2, 56, -2)))).addGroup(JPIDatosPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosPLayout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPIDatosPLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JLTercero, -2, 50, -2).addComponent(this.JBBuscaTercero, -2, 50, -2))).addGroup(JPIDatosPLayout.createSequentialGroup().addGap(25, 25, 25).addGroup(JPIDatosPLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBFiltroPorTercero).addComponent(this.JCBFiltroPorRangoPuc)))))).addContainerGap()));
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: Contabilidad.JIFConsultar_LibroAuxiliar_RangoCuenta.11
            public void mouseClicked(MouseEvent evt) {
                JIFConsultar_LibroAuxiliar_RangoCuenta.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setForeground(Color.red);
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: Contabilidad.JIFConsultar_LibroAuxiliar_RangoCuenta.12
            public void actionPerformed(ActionEvent evt) {
                JIFConsultar_LibroAuxiliar_RangoCuenta.this.JBTExportarActionPerformed(evt);
            }
        });
        this.JTPDetalle.setForeground(Color.red);
        this.JTPDetalle.setFont(new Font("Arial", 1, 14));
        this.JSPDetalle.setBorder((Border) null);
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.JTPDetalle.addTab("AUXILIAR", this.JSPDetalle);
        this.JSPMovimiento.setBorder((Border) null);
        this.JTH_Detalle.setFont(new Font("Arial", 1, 12));
        this.JTH_Detalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTH_Detalle.setRowHeight(25);
        this.JTH_Detalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTH_Detalle.setSelectionForeground(Color.red);
        this.JSPMovimiento.setViewportView(this.JTH_Detalle);
        this.JTPDetalle.addTab("MOVIMIENTO", this.JSPMovimiento);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.JTFRuta, -2, 765, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTExportar, -2, 128, -2).addContainerGap(-1, 32767)).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JPIDatosP, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.JTPDetalle)).addGap(18, 18, 18)))));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatosP, -1, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTPDetalle, -2, 310, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBTExportar, -2, 50, -2).addComponent(this.JTFRuta, -2, 50, -2)).addContainerGap()));
        pack();
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
            if (this.JTDetalle.getRowCount() > 0 || this.JTH_Detalle.getRowCount() > 0) {
                int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (n == 0) {
                    if (this.JTPDetalle.getSelectedIndex() == 0) {
                        this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTDetalle, this.xmt.mTraerUrlBD(this.JTFRuta.getText()), getTitle());
                        return;
                    } else {
                        this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTH_Detalle, this.xmt.mTraerUrlBD(this.JTFRuta.getText()), getTitle());
                        return;
                    }
                }
                return;
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un ruta valida", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JTFRuta.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCuentaIKeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCuentaFKeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCuentaIFocusLost(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCuentaFFocusLost(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHVisualizarNiifActionPerformed(ActionEvent evt) {
        if (this.JCHVisualizarNiif.isSelected()) {
            this.xAplicaNiif = "IN (0,1)";
        } else {
            this.xAplicaNiif = "IN (0)";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_IncluirMovCierreActionPerformed(ActionEvent evt) {
        if (this.JCH_IncluirMovCierre.isSelected()) {
            this.xIncluirCierre = "in(0,1)";
        } else {
            this.xIncluirCierre = "in(0)";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCuentaIKeyReleased(KeyEvent evt) {
        if (evt.getKeyCode() == 10 && this.JCBFiltroPorRangoPuc.isSelected()) {
            mValidarFiltro();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCuentaFKeyReleased(KeyEvent evt) {
        if (evt.getKeyCode() == 10 && this.JCBFiltroPorRangoPuc.isSelected()) {
            mValidarFiltro();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBBuscaTerceroActionPerformed(ActionEvent evt) {
        JDPatologia x = new JDPatologia(null, true, this);
        x.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JSPNivelStateChanged(ChangeEvent evt) {
        mValidarFiltro();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBFiltroPorRangoPucActionPerformed(ActionEvent evt) {
        mValidarFiltro();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBFiltroPorTerceroActionPerformed(ActionEvent evt) {
        mValidarFiltro();
    }

    public void mValidarFiltro() {
        if (this.JCBFiltroPorRangoPuc.isSelected()) {
            if (!this.JTFCuentaI.getText().isEmpty() && !this.JTFCuentaF.getText().isEmpty()) {
                if (this.JCBFiltroPorTercero.isSelected()) {
                    if (!this.idTercero.isEmpty()) {
                        this.JSPNivel.setValue(8);
                        mWorker();
                        return;
                    } else {
                        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un tercero", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        this.JBBuscaTercero.requestFocus();
                        return;
                    }
                }
                mWorker();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe digitar el rango de cuentas puc", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        if (this.JCBFiltroPorTercero.isSelected()) {
            if (!this.idTercero.isEmpty()) {
                this.JSPNivel.setValue(8);
                mWorker();
                return;
            } else {
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un tercero", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JBBuscaTercero.requestFocus();
                return;
            }
        }
        mWorker();
    }

    public void mNuevo() {
        this.esgenerado = false;
        this.JDCFechaInicio.setDate(this.xmt.getFechaActual());
        this.JDCFechaFin.setDate(this.xmt.getFechaActual());
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
        this.xct.ejecutarSQL("UPDATE `cc_puc` SET SaldoAnterior=0,VDebito=0,VCredito=0,SaldoActual=0");
        this.xct.cerrarConexionBd();
        mCrearModeloDatos();
    }

    public void mBuscar() {
        mValidarFiltro();
    }

    private void mWorker() {
        this.xWorkerSQL = null;
        this.xWorkerSQL = new WorkerSQL("Cargando la Informacion...", this);
        this.xWorkerSQL.execute();
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x00f5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void mBuscarM() {
        /*
            Method dump skipped, instruction units count: 300
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: Contabilidad.JIFConsultar_LibroAuxiliar_RangoCuenta.mBuscarM():void");
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x00f0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void mBuscar_Niif() {
        /*
            Method dump skipped, instruction units count: 273
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: Contabilidad.JIFConsultar_LibroAuxiliar_RangoCuenta.mBuscar_Niif():void");
    }

    public void mImprimir() {
        String[][] parametros = new String[7][2];
        parametros[0][0] = "NUsuario";
        parametros[0][1] = Principal.usuarioSistemaDTO.getLogin();
        parametros[1][0] = "Periodo";
        parametros[1][1] = "Del " + this.xmt.formatoAMD.format(this.JDCFechaInicio.getDate()) + " Al " + this.xmt.formatoAMD.format(this.JDCFechaFin.getDate());
        parametros[2][0] = "Titulo";
        parametros[2][1] = getTitle();
        parametros[3][0] = "fechai";
        parametros[3][1] = this.xmt.formatoAMD.format(this.JDCFechaInicio.getDate());
        parametros[4][0] = "fechaf";
        parametros[4][1] = this.xmt.formatoAMD.format(this.JDCFechaFin.getDate());
        parametros[5][0] = "SUBREPORT_DIR";
        parametros[5][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
        parametros[6][0] = "SUBREPORTFIRMA_DIR";
        parametros[6][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
        if (this.JCHVisualizarNiif.isSelected()) {
            this.xmt.GenerarPDF(this.xmt.getRutaRep() + "CC_Libro_Auxiliar_RangoCuenta_Niif", parametros);
        } else {
            this.xmt.GenerarPDF(this.xmt.getRutaRep() + "CC_Libro_Auxiliar_RangoCuenta", parametros);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Auxiliar", "SaldoAnterior", "Debito", "Credito", "SaldoActual"}) { // from class: Contabilidad.JIFConsultar_LibroAuxiliar_RangoCuenta.13
            Class[] types = {String.class, String.class, Double.class, Double.class, Double.class, Double.class};
            boolean[] canEdit = {false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(15);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(15);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(15);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(15);
    }

    private void mCargarDatos(boolean estado) {
        String id = "";
        if (this.JCBFiltroPorTercero.isSelected()) {
            id = "AND cc_detalle_documentoc.`Id_Tercero` = '" + this.idTercero + "'";
        }
        String rangoPuc = this.JCBFiltroPorRangoPuc.isSelected() ? "WHERE ( cc_puc.Id >= '" + this.JTFCuentaI.getText() + "'\n  AND cc_puc.Id <= '" + this.JTFCuentaF.getText() + "'\n  AND LENGTH(cc_puc.Id) <= '" + this.JSPNivel.getValue().toString() + "'  )\n" : "";
        if (this.JCHVisualizarNiif.isSelected()) {
            if (!estado && !this.JTFCuentaI.getText().isEmpty() && !this.JTFCuentaF.getText().isEmpty()) {
                this.xsql = "SELECT\n  IFNULL(cc_puc_niif.Id,cc_puc.Id) AS Id,\n  IFNULL(cc_puc_niif.Nbre,cc_puc.Nbre) AS Nbre,\n  IFNULL(cc_puc_niif.SaldoAnterior,cc_puc.SaldoAnterior) AS SaldoAnterior,\n  IFNULL(cc_puc_niif.VDebito,cc_puc.VDebito) AS VDebito,\n  IFNULL(cc_puc_niif.VCredito,cc_puc.VCredito) AS VCredito,\n  IFNULL(cc_puc_niif.SaldoActual,cc_puc.SaldoActual) AS SaldoActual\nFROM\n  cc_puc \n  LEFT JOIN cc_detalle_documentoc  ON (  cc_detalle_documentoc.Id_Puc = cc_puc.Id  ) " + id + " \n  LEFT JOIN cc_pucg_niif ON (  cc_detalle_documentoc.Id_Puc = cc_pucg_niif.Id_Puc_G )  AND (cc_pucg_niif.Estado = 1)\n  LEFT JOIN cc_puc_niif ON (  cc_puc_niif.Id = cc_pucg_niif.Id_Puc_Niif )\n" + rangoPuc + "GROUP BY cc_puc.Id\nORDER BY cc_puc.Id ASC;";
            } else {
                this.xsql = "SELECT `cc_puc_niif`.`Id`  , `cc_puc_niif`.`Nbre`,`cc_puc_niif`.SaldoAnterior,`cc_puc_niif`.VDebito,`cc_puc_niif`.VCredito,`cc_puc_niif`.SaldoActual \nFROM `cc_detalle_documentoc`  \nINNER JOIN  `cc_pucg_niif`ON (`cc_detalle_documentoc`.`Id_Puc` = `cc_pucg_niif`.`Id_Puc_G`) AND (cc_pucg_niif.`Estado`=1)\nINNER JOIN  `cc_puc_niif`ON (`cc_puc_niif`.`Id` = `cc_pucg_niif`.`Id_Puc_Niif`)\nGROUP BY `cc_puc_niif`.`Id`\nORDER BY `cc_puc_niif`.`Id` ASC";
            }
        } else if (!estado && !this.JTFCuentaI.getText().isEmpty() && !this.JTFCuentaF.getText().isEmpty()) {
            this.xsql = "SELECT\n  cc_puc.Id,\n  cc_puc.Nbre,\n  cc_puc.SaldoAnterior,\n  cc_puc.VDebito,\n  cc_puc.VCredito,\n  cc_puc.SaldoActual\nFROM\ncc_puc\n  LEFT JOIN cc_detalle_documentoc ON ( cc_detalle_documentoc.Id_Puc = cc_puc.Id ) " + id + " \n" + rangoPuc + "GROUP BY cc_puc.Id\nORDER BY cc_puc.Id ASC;";
        } else {
            this.xsql = "SELECT `cc_puc`.`Id`  , `cc_puc`.`Nbre`,`cc_puc`.SaldoAnterior,`cc_puc`.VDebito,`cc_puc`.VCredito,`cc_puc`.SaldoActual \nFROM `cc_detalle_documentoc`  INNER JOIN  `cc_puc`  ON (`cc_detalle_documentoc`.`Id_Puc` = `cc_puc`.`Id`)\nGROUP BY `cc_puc`.`Id`\nORDER BY `cc_puc`.`Id` ASC";
        }
        mCrearModeloDatos();
        ResultSet rs = this.xct.traerRs(this.xsql);
        try {
            if (rs.next()) {
                rs.beforeFirst();
                int x = 0;
                while (rs.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(rs.getString(1), x, 0);
                    this.xmodelo.setValueAt(rs.getString(2), x, 1);
                    this.xmodelo.setValueAt(Double.valueOf(rs.getDouble("SaldoAnterior")), x, 2);
                    this.xmodelo.setValueAt(Double.valueOf(rs.getDouble("VDebito")), x, 3);
                    this.xmodelo.setValueAt(Double.valueOf(rs.getDouble("VCredito")), x, 4);
                    this.xmodelo.setValueAt(Double.valueOf(rs.getDouble("SaldoActual")), x, 5);
                    x++;
                }
            }
            rs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            this.xct.mostrarErrorSQL(ex);
        }
    }

    private void mCrearTablaTmp() {
        try {
            this.xsql = "delete from  cc_tmp_lauxiliar";
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
            String filtroPorRangoDeCuenta = "";
            if (this.JCBFiltroPorRangoPuc.isSelected()) {
                filtroPorRangoDeCuenta = " cc_detalle_documentoc.`Id_Puc` >= '" + this.JTFCuentaI.getText() + "' AND cc_detalle_documentoc.`Id_Puc` <= '" + this.JTFCuentaF.getText() + "' AND \n";
            }
            String filtroPorTercero = this.JCBFiltroPorTercero.isSelected() ? " cc_detalle_documentoc.`Id_Tercero` = '" + this.idTercero + "' AND \n" : "";
            this.xsql = "INSERT INTO cc_tmp_lauxiliar(`FechaD`\n    , `TIpoDoc`\n    , `RazonSC`\n    , `Descripcion`\n    , `NCheque`\n    , `NConsecutivo`\n    , `VDebito`\n    , `VCredito`\n    , `VSActual`\n    , `IdPuc`\n    , `NCuenta`\n    , `SAnterior`\n    , `CDebito`\n    , `CCredito`\n    , `SActual`\n    , `TipoIdNormal`\n    , `IdConcatenado`\n    , `NEmpresa`\n    , `Direccion`\n    , `NMunicipio`\n    , `NDepartamento`\n    , `Logo`\n    , `NFactura`, PRetencion, Base, Observacion)\nSELECT\n    `cc_documentoc`.`FechaD`\n    , cc_tipo_documentoc.`Nbre`  TIpoDoc\n    , cc_terceros.`RazonSocialCompleta` RazonSC\n    , `cc_detalle_documentoc`.`Concepto`\n    , `cc_documentoc`.`NCheque`\n    , `cc_documentoc`.`NConsecutivo`\n    , cc_detalle_documentoc.`VDebito`\n    , cc_detalle_documentoc.`VCredito`\n    , 0 VSActual\n    , cc_detalle_documentoc.`Id_Puc` IdPuc\n    ,  `cc_puc`.`Nbre` NCuenta\n    ,  `cc_puc`.`SaldoAnterior` \n    ,  `cc_puc`.`VDebito` CDebito\n    ,  `cc_puc`.`VCredito` CCredito\n    ,  `cc_puc`.`SaldoActual` SActual\n     , d_ips.`TipoIdEmpresa` `TipoIdNormal`\n    , `d_ips`.`IdConcatenado`\n    , `d_ips`.`NIEmpresa` `NEmpresa`\n    , `d_ips`.`Direccion` `Direccion`\n    , `d_ips`.`NMunicipio` `NMunicipio`\n    , UCASE(`d_ips`.`NDepartamento`) NDepartamento\n    , `d_ips`.Logo\n    , if(cc_detalle_documentoc.`NFactura`='', IFNULL(cc_radicacion.NoFactura, ''),cc_detalle_documentoc.`NFactura`)  NFactura, cc_detalle_documentoc.`PRetencion`, cc_detalle_documentoc.`Base`, cc_documentoc.Descripcion Observacion\nFROM\n     `d_ips`,\n     cc_detalle_documentoc\n    INNER JOIN  `cc_documentoc`\n        ON (cc_detalle_documentoc.`Id_Documentoc` = `cc_documentoc`.`Id`)\n    INNER JOIN  cc_tipo_documentoc\n        ON (`cc_documentoc`.`Id_TipoComprobante` = cc_tipo_documentoc.`Id`)\n    INNER JOIN   `cc_puc`\n        ON (cc_detalle_documentoc.`Id_Puc` =  `cc_puc`.`Id`)\n    INNER JOIN  `cc_terceros`\n        ON (cc_terceros.`Id` = cc_detalle_documentoc.`Id_Tercero`)\n    LEFT JOIN  cc_radicacion\n        ON (cc_radicacion.`Id` = `cc_documentoc`.`Id_Radicacion`)\nWHERE ( " + filtroPorRangoDeCuenta + filtroPorTercero + "    `cc_tipo_documentoc`.`Es_Niif`" + this.xAplicaNiif + "  AND `cc_documentoc`.`FechaD` >='" + this.xmt.formatoAMD1.format(this.JDCFechaInicio.getDate()) + "'\n    AND `cc_documentoc`.`FechaD` <='" + this.xmt.formatoAMD1.format(this.JDCFechaFin.getDate()) + "'\n    AND `cc_documentoc`.`Estado` =1) \nORDER BY cc_detalle_documentoc.`Id_Puc` ASC, `cc_documentoc`.`FechaD` ASC";
            System.out.println("" + this.xsql);
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
            this.xsql = "SELECT cc_tmp_lauxiliar.`Id`, cc_tmp_lauxiliar.`IdPuc`,\n    `cc_puc`.`Tipo`\n    , `cc_tmp_lauxiliar`.`VDebito`\n    , `cc_tmp_lauxiliar`.`VCredito`\nFROM\n   `cc_puc`\n    INNER JOIN `cc_tmp_lauxiliar` \n        ON (`cc_puc`.`Id` = `cc_tmp_lauxiliar`.`IdPuc`)";
            ResultSet xrs = this.xct.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.first();
                String xIdPuc = xrs.getString("IdPuc");
                xrs.beforeFirst();
                double xvalor = 0.0d;
                while (xrs.next()) {
                    ConsultasMySQL xct1 = new ConsultasMySQL();
                    if (xrs.getString("IdPuc").equals(xIdPuc)) {
                        if (xrs.getBoolean("Tipo")) {
                            xvalor += xrs.getDouble("VCredito") - xrs.getDouble("VDebito");
                        } else {
                            xvalor += xrs.getDouble("VDebito") - xrs.getDouble("VCredito");
                        }
                        this.xsql = "update cc_tmp_lauxiliar set VSActual=" + xvalor + " where Id='" + xrs.getString("Id") + "'";
                        xct1.ejecutarSQL(this.xsql);
                        xct1.cerrarConexionBd();
                    } else {
                        xvalor = 0.0d;
                    }
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFConsultar_LibroAuxiliar_RangoCuenta.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCrearModeloDatos2() {
        this.xmodelo2 = new DefaultTableModel() { // from class: Contabilidad.JIFConsultar_LibroAuxiliar_RangoCuenta.14
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, Double.class, Double.class, Double.class, String.class, String.class, String.class, String.class, Double.class, Double.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return this.canEdit[colIndex];
            }
        };
        this.xmodelo2.addColumn("Fecha");
        this.xmodelo2.addColumn("TipoDoc");
        this.xmodelo2.addColumn("Tecero");
        this.xmodelo2.addColumn("Descripción");
        this.xmodelo2.addColumn("NCheque");
        this.xmodelo2.addColumn("NDoc");
        this.xmodelo2.addColumn("VDebito");
        this.xmodelo2.addColumn("VCredito");
        this.xmodelo2.addColumn("VSaldo");
        this.xmodelo2.addColumn("Id_Puc");
        this.xmodelo2.addColumn("Cuenta");
        this.xmodelo2.addColumn("Observación");
        this.xmodelo2.addColumn("NFactura");
        this.xmodelo2.addColumn("PRetencion");
        this.xmodelo2.addColumn("Base");
        this.xmodelo2.addColumn("Observacion");
        JTable jTable = this.JTH_Detalle;
        JTable jTable2 = this.JTH_Detalle;
        jTable.setAutoResizeMode(0);
        this.JTH_Detalle.doLayout();
        this.JTH_Detalle.setModel(this.xmodelo2);
        this.JTH_Detalle.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTH_Detalle.getColumnModel().getColumn(1).setPreferredWidth(150);
        this.JTH_Detalle.getColumnModel().getColumn(2).setPreferredWidth(300);
        this.JTH_Detalle.getColumnModel().getColumn(3).setPreferredWidth(250);
        this.JTH_Detalle.getColumnModel().getColumn(4).setPreferredWidth(80);
        this.JTH_Detalle.getColumnModel().getColumn(5).setPreferredWidth(80);
        this.JTH_Detalle.getColumnModel().getColumn(6).setPreferredWidth(80);
        this.JTH_Detalle.getColumnModel().getColumn(7).setPreferredWidth(80);
        this.JTH_Detalle.getColumnModel().getColumn(8).setPreferredWidth(80);
        this.JTH_Detalle.getColumnModel().getColumn(9).setPreferredWidth(80);
        this.JTH_Detalle.getColumnModel().getColumn(10).setPreferredWidth(200);
        this.JTH_Detalle.getColumnModel().getColumn(11).setPreferredWidth(200);
        this.JTH_Detalle.getColumnModel().getColumn(12).setPreferredWidth(80);
        this.JTH_Detalle.getColumnModel().getColumn(13).setPreferredWidth(80);
        this.JTH_Detalle.getColumnModel().getColumn(14).setPreferredWidth(80);
        this.JTH_Detalle.getColumnModel().getColumn(15).setPreferredWidth(200);
    }

    private void mCargarHistorial() {
        String xsql2;
        try {
            mCrearModeloDatos2();
            if (this.JCHVisualizarNiif.isSelected()) {
                xsql2 = "SELECT\n`FechaD`\n, `cc_tmp_lauxiliar`.`TIpoDoc`\n, `cc_tmp_lauxiliar`.`RazonSC`\n, `cc_tmp_lauxiliar`.`Descripcion`\n, `cc_tmp_lauxiliar`.`NCheque`\n, `cc_tmp_lauxiliar`.`NConsecutivo`\n, `cc_tmp_lauxiliar`.`VDebito`\n, `cc_tmp_lauxiliar`.`VCredito`\n, `cc_tmp_lauxiliar`.`VSActual`\n, cc_puc_niif.`Id` AS IdPuc\n, cc_puc_niif.`Nbre` AS NCuenta\n, `cc_tmp_lauxiliar`.`Descripcion`\n, `cc_tmp_lauxiliar`.`NFactura`\n, `cc_tmp_lauxiliar`.`PRetencion`\n, `cc_tmp_lauxiliar`.`Base`,`cc_tmp_lauxiliar`.`Observacion`\n  FROM\n`cc_tmp_lauxiliar`\nINNER JOIN `cc_pucg_niif` ON (cc_tmp_lauxiliar.`IdPuc`=`cc_pucg_niif`.`Id_Puc_G`) AND (cc_pucg_niif.`Estado`=1)\nINNER JOIN `cc_puc_niif` ON(cc_pucg_niif.`Id_Puc_Niif`= cc_puc_niif.`Id`)";
            } else {
                xsql2 = "SELECT\n    `FechaD`\n    , `TIpoDoc`\n    , `RazonSC`\n    , `Descripcion`\n    , `NCheque`\n    , `NConsecutivo`\n    , `VDebito`\n    , `VCredito`\n    , `VSActual`\n    , `IdPuc`\n    , `NCuenta`\n    , `Descripcion`\n    , `NFactura`\n    , `PRetencion`\n    , `Base`, Observacion\nFROM\n    `cc_tmp_lauxiliar`";
            }
            ResultSet xrs1 = this.xct.traerRs(xsql2);
            if (xrs1.next()) {
                xrs1.beforeFirst();
                int i = 0;
                while (xrs1.next()) {
                    this.xmodelo2.addRow(this.xdatos);
                    this.xmodelo2.setValueAt(xrs1.getString("FechaD"), i, 0);
                    this.xmodelo2.setValueAt(xrs1.getString("TIpoDoc"), i, 1);
                    this.xmodelo2.setValueAt(xrs1.getString("RazonSC"), i, 2);
                    this.xmodelo2.setValueAt(xrs1.getString("Descripcion"), i, 3);
                    this.xmodelo2.setValueAt(xrs1.getString("NCheque"), i, 4);
                    this.xmodelo2.setValueAt(xrs1.getString("NConsecutivo"), i, 5);
                    this.xmodelo2.setValueAt(Double.valueOf(xrs1.getDouble("VDebito")), i, 6);
                    this.xmodelo2.setValueAt(Double.valueOf(xrs1.getDouble("VCredito")), i, 7);
                    this.xmodelo2.setValueAt(Double.valueOf(xrs1.getDouble("VSActual")), i, 8);
                    this.xmodelo2.setValueAt(xrs1.getString("IdPuc"), i, 9);
                    this.xmodelo2.setValueAt(xrs1.getString("NCuenta"), i, 10);
                    this.xmodelo2.setValueAt(xrs1.getString("Descripcion"), i, 11);
                    this.xmodelo2.setValueAt(xrs1.getString("NFactura"), i, 12);
                    this.xmodelo2.setValueAt(Double.valueOf(xrs1.getDouble("PRetencion")), i, 13);
                    this.xmodelo2.setValueAt(Double.valueOf(xrs1.getDouble("Base")), i, 14);
                    this.xmodelo2.setValueAt(xrs1.getString("Observacion"), i, 15);
                    i++;
                }
            }
            xrs1.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFConsultar_LibroAuxiliar_Terceros.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }
}
