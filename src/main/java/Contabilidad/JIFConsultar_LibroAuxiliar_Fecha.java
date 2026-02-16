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
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Contabilidad/JIFConsultar_LibroAuxiliar_Fecha.class */
public class JIFConsultar_LibroAuxiliar_Fecha extends JInternalFrame {
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
    private JCheckBox JCHSeleccion;
    private JCheckBox JCHTercero;
    private JCheckBox JCHVisualizarNiif;
    private JCheckBox JCH_AgrupacionDocumento;
    private JCheckBox JCH_FiltroPorTercero;
    private JCheckBox JCH_IncluirMovCierre;
    private JDateChooser JDCFechaFin;
    private JDateChooser JDCFechaInicio;
    public JLabel JLTercero;
    private JPanel JPIDatosP;
    private JPanel JPI_FTercero;
    private JScrollPane JSPDetalle;
    private JScrollPane JSPMovimiento;
    private JTabbedPane JTB_Datos;
    private JTable JTDetalle;
    private JTextField JTFCuentaFin;
    private JTextField JTFCuentaInicio;
    private JTextField JTFRuta;
    private JTable JTH_Detalle;
    private JTabbedPane JTPDetalle;
    private ConsultasMySQL xct = new ConsultasMySQL();
    private int xNCaracter = 0;
    private final int xM = 2;
    private String[] x6 = new String[4];
    private String[] x8 = new String[5];
    private String[] x10 = new String[6];
    private String[] x12 = new String[7];
    private String xIncluirCierre = "in(0,1)";
    private String idTercero = "";
    private String xAplicaNiif = "in(0)";
    private Metodos xmt = new Metodos();
    private String xcodigo = "";
    private boolean esgenerado = false;

    public JIFConsultar_LibroAuxiliar_Fecha(String xTitulo) {
        initComponents();
        setTitle(xTitulo.toUpperCase());
        this.xTitulo = xTitulo;
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v14, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v19, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JTFRuta = new JTextField();
        this.JBTExportar = new JButton();
        this.JTPDetalle = new JTabbedPane();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JSPMovimiento = new JScrollPane();
        this.JTH_Detalle = new JTable();
        this.JTB_Datos = new JTabbedPane();
        this.JPIDatosP = new JPanel();
        this.JDCFechaInicio = new JDateChooser();
        this.JDCFechaFin = new JDateChooser();
        this.JCHTercero = new JCheckBox();
        this.JTFCuentaInicio = new JTextField();
        this.JCHVisualizarNiif = new JCheckBox();
        this.JCH_IncluirMovCierre = new JCheckBox();
        this.JCH_FiltroPorTercero = new JCheckBox();
        this.JCH_AgrupacionDocumento = new JCheckBox();
        this.JTFCuentaFin = new JTextField();
        this.JPI_FTercero = new JPanel();
        this.JLTercero = new JLabel();
        this.JBBuscaTercero = new JButton();
        this.JCHSeleccion = new JCheckBox();
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("CONSULTAR LIBRO AUXILIAR");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjif_libro_auxiliar");
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: Contabilidad.JIFConsultar_LibroAuxiliar_Fecha.1
            public void mouseClicked(MouseEvent evt) {
                JIFConsultar_LibroAuxiliar_Fecha.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setForeground(Color.red);
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: Contabilidad.JIFConsultar_LibroAuxiliar_Fecha.2
            public void actionPerformed(ActionEvent evt) {
                JIFConsultar_LibroAuxiliar_Fecha.this.JBTExportarActionPerformed(evt);
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
        this.JTDetalle.setSelectionMode(0);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: Contabilidad.JIFConsultar_LibroAuxiliar_Fecha.3
            public void mouseClicked(MouseEvent evt) {
                JIFConsultar_LibroAuxiliar_Fecha.this.JTDetalleMouseClicked(evt);
            }
        });
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
        this.JTB_Datos.setForeground(new Color(0, 103, 0));
        this.JTB_Datos.setFont(new Font("Arial", 1, 14));
        this.JDCFechaInicio.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicio", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFechaInicio.setDateFormatString("dd/MM/yyyy");
        this.JDCFechaInicio.setFont(new Font("Arial", 1, 12));
        this.JDCFechaFin.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Fin", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFechaFin.setDateFormatString("dd/MM/yyyy");
        this.JDCFechaFin.setFont(new Font("Arial", 1, 12));
        this.JCHTercero.setFont(new Font("Arial", 1, 13));
        this.JCHTercero.setSelected(true);
        this.JCHTercero.setText("Con Tercero?");
        this.JCHTercero.addActionListener(new ActionListener() { // from class: Contabilidad.JIFConsultar_LibroAuxiliar_Fecha.4
            public void actionPerformed(ActionEvent evt) {
                JIFConsultar_LibroAuxiliar_Fecha.this.JCHTerceroActionPerformed(evt);
            }
        });
        this.JTFCuentaInicio.setFont(new Font("Arial", 1, 12));
        this.JTFCuentaInicio.setBorder(BorderFactory.createTitledBorder((Border) null, "Cuenta Inicio", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFCuentaInicio.addKeyListener(new KeyAdapter() { // from class: Contabilidad.JIFConsultar_LibroAuxiliar_Fecha.5
            public void keyPressed(KeyEvent evt) {
                JIFConsultar_LibroAuxiliar_Fecha.this.JTFCuentaInicioKeyPressed(evt);
            }

            public void keyReleased(KeyEvent evt) {
                JIFConsultar_LibroAuxiliar_Fecha.this.JTFCuentaInicioKeyReleased(evt);
            }
        });
        this.JCHVisualizarNiif.setFont(new Font("Arial", 1, 13));
        this.JCHVisualizarNiif.setSelected(true);
        this.JCHVisualizarNiif.setText("Visualizacion NIIF");
        this.JCHVisualizarNiif.addActionListener(new ActionListener() { // from class: Contabilidad.JIFConsultar_LibroAuxiliar_Fecha.6
            public void actionPerformed(ActionEvent evt) {
                JIFConsultar_LibroAuxiliar_Fecha.this.JCHVisualizarNiifActionPerformed(evt);
            }
        });
        this.JCH_IncluirMovCierre.setFont(new Font("Arial", 1, 13));
        this.JCH_IncluirMovCierre.setText("Incluir Movimiento Cierre?");
        this.JCH_IncluirMovCierre.addActionListener(new ActionListener() { // from class: Contabilidad.JIFConsultar_LibroAuxiliar_Fecha.7
            public void actionPerformed(ActionEvent evt) {
                JIFConsultar_LibroAuxiliar_Fecha.this.JCH_IncluirMovCierreActionPerformed(evt);
            }
        });
        this.JCH_FiltroPorTercero.setFont(new Font("Arial", 1, 13));
        this.JCH_FiltroPorTercero.setText("Filtro por tercero?");
        this.JCH_FiltroPorTercero.addActionListener(new ActionListener() { // from class: Contabilidad.JIFConsultar_LibroAuxiliar_Fecha.8
            public void actionPerformed(ActionEvent evt) {
                JIFConsultar_LibroAuxiliar_Fecha.this.JCH_FiltroPorTerceroActionPerformed(evt);
            }
        });
        this.JCH_AgrupacionDocumento.setFont(new Font("Arial", 1, 13));
        this.JCH_AgrupacionDocumento.setText("Agrupación por documento?");
        this.JCH_AgrupacionDocumento.addActionListener(new ActionListener() { // from class: Contabilidad.JIFConsultar_LibroAuxiliar_Fecha.9
            public void actionPerformed(ActionEvent evt) {
                JIFConsultar_LibroAuxiliar_Fecha.this.JCH_AgrupacionDocumentoActionPerformed(evt);
            }
        });
        this.JTFCuentaFin.setFont(new Font("Arial", 1, 12));
        this.JTFCuentaFin.setBorder(BorderFactory.createTitledBorder(BorderFactory.createTitledBorder((Border) null, "Cuenta Fin", 0, 0, new Font("Arial", 1, 12), new Color(0, 51, 255)), "", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFCuentaFin.addKeyListener(new KeyAdapter() { // from class: Contabilidad.JIFConsultar_LibroAuxiliar_Fecha.10
            public void keyPressed(KeyEvent evt) {
                JIFConsultar_LibroAuxiliar_Fecha.this.JTFCuentaFinKeyPressed(evt);
            }

            public void keyReleased(KeyEvent evt) {
                JIFConsultar_LibroAuxiliar_Fecha.this.JTFCuentaFinKeyReleased(evt);
            }
        });
        GroupLayout JPIDatosPLayout = new GroupLayout(this.JPIDatosP);
        this.JPIDatosP.setLayout(JPIDatosPLayout);
        JPIDatosPLayout.setHorizontalGroup(JPIDatosPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosPLayout.createSequentialGroup().addContainerGap().addComponent(this.JDCFechaInicio, -2, 125, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JDCFechaFin, -2, 125, -2).addGap(18, 18, 18).addComponent(this.JTFCuentaInicio, -2, 158, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFCuentaFin, -2, 160, -2).addGap(30, 30, 30).addGroup(JPIDatosPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosPLayout.createSequentialGroup().addGroup(JPIDatosPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCH_IncluirMovCierre).addComponent(this.JCH_FiltroPorTercero)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIDatosPLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JCHVisualizarNiif, -1, -1, 32767).addComponent(this.JCHTercero, -2, 145, -2))).addComponent(this.JCH_AgrupacionDocumento)).addContainerGap(-1, 32767)));
        JPIDatosPLayout.setVerticalGroup(JPIDatosPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosPLayout.createSequentialGroup().addGroup(JPIDatosPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosPLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosPLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCHTercero).addComponent(this.JCH_IncluirMovCierre)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIDatosPLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCHVisualizarNiif).addComponent(this.JCH_FiltroPorTercero)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCH_AgrupacionDocumento)).addGroup(JPIDatosPLayout.createSequentialGroup().addGap(28, 28, 28).addGroup(JPIDatosPLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JTFCuentaFin, -2, 50, -2).addGroup(JPIDatosPLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JDCFechaInicio, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addComponent(this.JDCFechaFin, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addComponent(this.JTFCuentaInicio, GroupLayout.Alignment.TRAILING, -2, 50, -2))))).addContainerGap(-1, 32767)));
        this.JTB_Datos.addTab("DATOS", this.JPIDatosP);
        this.JLTercero.setFont(new Font("Arial", 1, 12));
        this.JLTercero.setBorder(BorderFactory.createTitledBorder((Border) null, "Tercero", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBBuscaTercero.setIcon(new ImageIcon(getClass().getResource("/Imagenes/lupa.png")));
        this.JBBuscaTercero.setToolTipText("Buscar Tercero");
        this.JBBuscaTercero.setName("xRadicacion");
        this.JBBuscaTercero.addActionListener(new ActionListener() { // from class: Contabilidad.JIFConsultar_LibroAuxiliar_Fecha.11
            public void actionPerformed(ActionEvent evt) {
                JIFConsultar_LibroAuxiliar_Fecha.this.JBBuscaTerceroActionPerformed(evt);
            }
        });
        GroupLayout JPI_FTerceroLayout = new GroupLayout(this.JPI_FTercero);
        this.JPI_FTercero.setLayout(JPI_FTerceroLayout);
        JPI_FTerceroLayout.setHorizontalGroup(JPI_FTerceroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_FTerceroLayout.createSequentialGroup().addContainerGap().addComponent(this.JLTercero, -2, 494, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JBBuscaTercero, -2, 58, -2).addGap(283, 283, 283)));
        JPI_FTerceroLayout.setVerticalGroup(JPI_FTerceroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_FTerceroLayout.createSequentialGroup().addGap(19, 19, 19).addGroup(JPI_FTerceroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLTercero, -2, 50, -2).addComponent(this.JBBuscaTercero, -2, 50, -2)).addContainerGap(27, 32767)));
        this.JTB_Datos.addTab("FILTRO POR TERCERO", this.JPI_FTercero);
        this.JCHSeleccion.setFont(new Font("Arial", 1, 12));
        this.JCHSeleccion.setForeground(Color.blue);
        this.JCHSeleccion.setText("Seleccionar Todo");
        this.JCHSeleccion.addActionListener(new ActionListener() { // from class: Contabilidad.JIFConsultar_LibroAuxiliar_Fecha.12
            public void actionPerformed(ActionEvent evt) {
                JIFConsultar_LibroAuxiliar_Fecha.this.JCHSeleccionActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTPDetalle).addGroup(layout.createSequentialGroup().addComponent(this.JTFRuta, -2, 398, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBTExportar, -2, 128, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHSeleccion).addGap(0, 0, 32767)).addComponent(this.JTB_Datos)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTB_Datos, -2, 142, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTPDetalle, -1, 376, 32767).addGap(18, 18, 18).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFRuta, -2, 50, -2).addComponent(this.JBTExportar, -2, 50, -2)).addComponent(this.JCHSeleccion)).addContainerGap()));
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
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                if (this.JTPDetalle.getSelectedIndex() == 0) {
                    this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTDetalle, this.xmt.mTraerUrlBD(this.JTFRuta.getText()), getTitle() + " - " + this.JTPDetalle.getTitleAt(0));
                    return;
                } else {
                    this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTH_Detalle, this.xmt.mTraerUrlBD(this.JTFRuta.getText()), getTitle() + " - " + this.JTPDetalle.getTitleAt(1));
                    return;
                }
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un ruta valida", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JTFRuta.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHTerceroActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCuentaInicioKeyPressed(KeyEvent evt) {
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
    public void JCHSeleccionActionPerformed(ActionEvent evt) {
        if (this.JCHSeleccion.isSelected()) {
            mRecorrerTabla();
        } else {
            mRecorrerTabla();
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
    public void JBBuscaTerceroActionPerformed(ActionEvent evt) {
        JDPatologia x = new JDPatologia(null, true, this);
        x.setLocationRelativeTo(this);
        x.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_FiltroPorTerceroActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            this.xmodelo.setValueAt(true, this.JTDetalle.getSelectedRow(), 6);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_AgrupacionDocumentoActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCuentaFinKeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCuentaInicioKeyReleased(KeyEvent evt) {
        if (this.JTFCuentaInicio.getText().length() == this.JTFCuentaFin.getText().length()) {
            mCargarDatos(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCuentaFinKeyReleased(KeyEvent evt) {
        if (this.JTFCuentaInicio.getText().length() == this.JTFCuentaFin.getText().length()) {
            mCargarDatos(false);
        }
    }

    private void mRecorrerTabla() {
        if (this.JTDetalle.getRowCount() > 0) {
            for (int i = 0; i < this.JTDetalle.getRowCount(); i++) {
                if (this.JCHSeleccion.isSelected()) {
                    this.xmodelo.setValueAt(true, i, 6);
                } else {
                    this.xmodelo.setValueAt(false, i, 6);
                }
            }
        }
    }

    public void mNuevo() {
        this.esgenerado = false;
        this.JLTercero.setText("");
        this.JDCFechaInicio.setDate(this.xmt.getFechaActual());
        this.JDCFechaFin.setDate(this.xmt.getFechaActual());
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
        this.xct.ejecutarSQL("UPDATE `cc_puc` SET SaldoAnterior=0,VDebito=0,VCredito=0,SaldoActual=0");
        this.xct.cerrarConexionBd();
        mCrearModeloDatos2();
    }

    public void mBuscar() {
        if (this.JTPDetalle.getSelectedIndex() == 0) {
            if (this.xmt.mVerificarDatosTablaTrue(this.JTDetalle, 6)) {
                if (!this.JCH_FiltroPorTercero.isSelected()) {
                    CargarDatosBuscar();
                    return;
                } else if (!this.JLTercero.getText().isEmpty()) {
                    CargarDatosBuscar();
                    return;
                } else {
                    this.JTB_Datos.setSelectedIndex(1);
                    JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un tercero", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    return;
                }
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una cuenta", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        this.xWorkerSQL = null;
        this.xWorkerSQL = new WorkerSQL("Cargando la Informacion...", this);
        this.xWorkerSQL.execute();
    }

    private void CargarDatosBuscar() {
        this.xWorkerSQL = null;
        this.xWorkerSQL = new WorkerSQL("Cargando la Informacion...", this);
        this.xWorkerSQL.execute();
    }

    public void mBuscarSeleccionTab() {
        if (this.JTPDetalle.getSelectedIndex() == 0) {
            mBuscarM();
        } else {
            mCargarHistorial();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x01d8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void mBuscarM() {
        /*
            Method dump skipped, instruction units count: 531
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: Contabilidad.JIFConsultar_LibroAuxiliar_Fecha.mBuscarM():void");
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x01d3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void mBuscar_Niif() {
        /*
            Method dump skipped, instruction units count: 500
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: Contabilidad.JIFConsultar_LibroAuxiliar_Fecha.mBuscar_Niif():void");
    }

    private void mConsultaTercero() {
        String xsql;
        this.xct.ejecutarSQL("delete from cc_balance_tercero");
        this.xct.cerrarConexionBd();
        if (!this.JCH_FiltroPorTercero.isSelected()) {
            xsql = " INSERT IGNORE INTO cc_balance_tercero( `Id_Auxiliar` ,`Id_Tercero` , `SAnterior` , `VDebito` , `VCredito` , `SActual`) SELECT   Id_Puc,  Id_Tercero,  SUM(SALDO_ANTERIOR) SALDO_ANTERIOR,  SUM(VDEBITO) VDEBITO,  SUM(VCREDITO) VCREDITO,  SUM(SALDO_ACTUAL) SALDO_ACTUAL FROM (  SELECT   Id_Puc,   DET.Id_Tercero,   PUC.Tipo,   ENC.Id_PeriodoC,   CASE WHEN ENC.FechaD<'" + this.xmt.formatoAMD1.format(this.JDCFechaInicio.getDate()) + "' THEN    CASE WHEN PUC.Tipo=0 THEN     DET.VDebito-DET.VCredito    ELSE     DET.VCredito-DET.VDebito     END   ELSE    0    END  SALDO_ANTERIOR,         CASE WHEN ENC.FechaD>='" + this.xmt.formatoAMD1.format(this.JDCFechaInicio.getDate()) + "' and ENC.FechaD<='" + this.xmt.formatoAMD1.format(this.JDCFechaFin.getDate()) + "' THEN    DET.VDebito   ELSE    0   END  VDEBITO,      CASE WHEN ENC.FechaD>='" + this.xmt.formatoAMD1.format(this.JDCFechaInicio.getDate()) + "' and ENC.FechaD<='" + this.xmt.formatoAMD1.format(this.JDCFechaFin.getDate()) + "' THEN    DET.VCredito   ELSE    0   END  VCREDITO,       CASE WHEN PUC.Tipo=0 THEN    DET.VDebito-DET.VCredito   ELSE    DET.VCredito-DET.VDebito    END SALDO_ACTUAL  FROM  cc_detalle_documentoc DET  INNER JOIN cc_documentoc  ENC  ON DET.Id_Documentoc = ENC.Id  INNER JOIN cc_periodo_contable   ON ENC.Id_PeriodoC = cc_periodo_contable.Id  INNER JOIN `cc_tipo_documentoc` \n        ON (`ENC`.`Id_TipoComprobante` = `cc_tipo_documentoc`.`Id`) INNER JOIN cc_puc PUC   ON (DET.Id_Puc = PUC.Id)  WHERE cc_periodo_contable.EsCierre " + this.xIncluirCierre + " and `cc_tipo_documentoc`.`Es_Niif`" + this.xAplicaNiif + " and ENC.Estado=1  AND FechaD<='" + this.xmt.formatoAMD1.format(this.JDCFechaFin.getDate()) + "' ) TODO GROUP BY Id_Puc, Id_Tercero";
        } else {
            xsql = " INSERT INTO cc_balance_tercero( `Id_Auxiliar` ,`Id_Tercero` , `SAnterior` , `VDebito` , `VCredito` , `SActual`) SELECT   Id_Puc,  Id_Tercero,  SUM(SALDO_ANTERIOR) SALDO_ANTERIOR,  SUM(VDEBITO) VDEBITO,  SUM(VCREDITO) VCREDITO,  SUM(SALDO_ACTUAL) SALDO_ACTUAL FROM (  SELECT   Id_Puc,   DET.Id_Tercero,   PUC.Tipo,   ENC.Id_PeriodoC,   CASE WHEN ENC.FechaD<'" + this.xmt.formatoAMD1.format(this.JDCFechaInicio.getDate()) + "' THEN    CASE WHEN PUC.Tipo=0 THEN     DET.VDebito-DET.VCredito    ELSE     DET.VCredito-DET.VDebito     END   ELSE    0    END  SALDO_ANTERIOR,         CASE WHEN ENC.FechaD>='" + this.xmt.formatoAMD1.format(this.JDCFechaInicio.getDate()) + "' and ENC.FechaD<='" + this.xmt.formatoAMD1.format(this.JDCFechaFin.getDate()) + "' THEN    DET.VDebito   ELSE    0   END  VDEBITO,      CASE WHEN ENC.FechaD>='" + this.xmt.formatoAMD1.format(this.JDCFechaInicio.getDate()) + "' and ENC.FechaD<='" + this.xmt.formatoAMD1.format(this.JDCFechaFin.getDate()) + "' THEN    DET.VCredito   ELSE    0   END  VCREDITO,       CASE WHEN PUC.Tipo=0 THEN    DET.VDebito-DET.VCredito   ELSE    DET.VCredito-DET.VDebito    END SALDO_ACTUAL  FROM  cc_detalle_documentoc DET  INNER JOIN cc_documentoc  ENC  ON DET.Id_Documentoc = ENC.Id  INNER JOIN cc_periodo_contable   ON ENC.Id_PeriodoC = cc_periodo_contable.Id  INNER JOIN `cc_tipo_documentoc` \n        ON (`ENC`.`Id_TipoComprobante` = `cc_tipo_documentoc`.`Id`) INNER JOIN cc_puc PUC   ON (DET.Id_Puc = PUC.Id)  WHERE (cc_periodo_contable.EsCierre " + this.xIncluirCierre + " and `cc_tipo_documentoc`.`Es_Niif`" + this.xAplicaNiif + " and ENC.Estado=1  AND FechaD<='" + this.xmt.formatoAMD1.format(this.JDCFechaFin.getDate()) + "' and DET.Id_Tercero='" + getIdTercero() + "') ) TODO GROUP BY Id_Puc, Id_Tercero";
        }
        System.out.println("" + xsql);
        this.xct.ejecutarSQL(xsql);
        this.xct.cerrarConexionBd();
    }

    private void mCrearModeloDatos2() {
        this.xmodelo2 = new DefaultTableModel((Object[][]) null, new String[]{"Fecha", "TipoDoc", "Tecero", "Descripción", "NCheque", "NDoc", "VDebito", "VCredito", "VSaldo", "Id_Puc", "Cuenta", "Observación", "NFactura"}) { // from class: Contabilidad.JIFConsultar_LibroAuxiliar_Fecha.13
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, Double.class, Double.class, Double.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return this.canEdit[colIndex];
            }
        };
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
    }

    public void mCargarHistorial() {
        String xsql2;
        try {
            mCrearModeloDatos2();
            if (this.JCHVisualizarNiif.isSelected()) {
                xsql2 = "SELECT\n`FechaD`\n, `cc_tmp_lauxiliar`.`TIpoDoc`\n, `cc_tmp_lauxiliar`.`RazonSC`\n, `cc_tmp_lauxiliar`.`Descripcion`\n, `cc_tmp_lauxiliar`.`NCheque`\n, `cc_tmp_lauxiliar`.`NConsecutivo`\n, `cc_tmp_lauxiliar`.`VDebito`\n, `cc_tmp_lauxiliar`.`VCredito`\n, `cc_tmp_lauxiliar`.`VSActual`\n, cc_puc_niif.`Id` AS IdPuc\n, cc_puc_niif.`Nbre` AS NCuenta\n, `cc_tmp_lauxiliar`.`Descripcion`\n, `cc_tmp_lauxiliar`.`NFactura`\n  FROM\n`cc_tmp_lauxiliar`\nINNER JOIN `cc_pucg_niif` ON (cc_tmp_lauxiliar.`IdPuc`=`cc_pucg_niif`.`Id_Puc_G`) AND (cc_pucg_niif.`Estado`=1)\nINNER JOIN `cc_puc_niif` ON(cc_pucg_niif.`Id_Puc_Niif`= cc_puc_niif.`Id`)";
            } else if (this.JCH_AgrupacionDocumento.isSelected()) {
                xsql2 = "SELECT\n    `FechaD`\n    , `TIpoDoc`\n    , `RazonSC`\n    , `Descripcion`\n    , `NCheque`\n    , `NConsecutivo`\n    , sum(`VDebito`) VDebito\n    , sum(`VCredito`) VCredito\n    , `VSActual`\n    , `IdPuc`\n    , `NCuenta`\n    , `Descripcion`\n    , `NFactura`\nFROM\n    `cc_tmp_lauxiliar` group by `TIpoDoc`, `NConsecutivo`";
            } else {
                xsql2 = "SELECT\n    `FechaD`\n    , `TIpoDoc`\n    , `RazonSC`\n    , `Descripcion`\n    , `NCheque`\n    , `NConsecutivo`\n    , `VDebito`\n    , `VCredito`\n    , `VSActual`\n    , `IdPuc`\n    , `NCuenta`\n    , `Descripcion`\n    , `NFactura`\nFROM\n    `cc_tmp_lauxiliar`";
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
                    i++;
                }
            }
            xrs1.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFConsultar_LibroAuxiliar_Fecha.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mImprimir() {
        if (this.esgenerado) {
            this.xcodigo = "";
            for (int x = 0; x < this.JTDetalle.getRowCount(); x++) {
                if (Boolean.valueOf(this.xmodelo.getValueAt(x, 6).toString()).booleanValue()) {
                    this.xcodigo += "," + this.xmodelo.getValueAt(x, 0).toString();
                }
            }
            mCrearTablaTmp();
            String[][] parametros = new String[8][2];
            parametros[0][0] = "NUsuario";
            parametros[0][1] = Principal.usuarioSistemaDTO.getLogin();
            parametros[1][0] = "Periodo";
            parametros[1][1] = "Del " + this.xmt.formatoAMD.format(this.JDCFechaInicio.getDate()) + " Al " + this.xmt.formatoAMD.format(this.JDCFechaFin.getDate());
            parametros[2][0] = "Titulo";
            parametros[2][1] = "LIBRO AUXILIAR";
            parametros[3][0] = "fechai";
            parametros[3][1] = this.xmt.formatoAMD.format(this.JDCFechaInicio.getDate());
            parametros[4][0] = "fechaf";
            parametros[4][1] = this.xmt.formatoAMD.format(this.JDCFechaFin.getDate());
            parametros[5][0] = "idcuenta";
            parametros[5][1] = this.xcodigo.substring(1, this.xcodigo.length());
            parametros[6][0] = "SUBREPORT_DIR";
            parametros[6][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
            parametros[7][0] = "SUBREPORTFIRMA_DIR";
            parametros[7][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
            if (this.JCHVisualizarNiif.isSelected()) {
                this.xmt.GenerarPDF(this.xmt.getRutaRep() + "CC_Libro_Auxiliar_Tercero_Niif", parametros);
                return;
            } else if (this.JCH_AgrupacionDocumento.isSelected()) {
                this.xmt.GenerarPDF(this.xmt.getRutaRep() + "CC_Libro_Auxiliar_Tercero_Agrupado", parametros);
                return;
            } else {
                this.xmt.GenerarPDF(this.xmt.getRutaRep() + "CC_Libro_Auxiliar_Tercero", parametros);
                return;
            }
        }
        JOptionPane.showInternalMessageDialog(this, "Debe generar la consulta", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel((Object[][]) null, new String[]{"Id", "Auxiliar", "SaldoAnterior", "Debito", "Credito", "SaldoActual", "Consultar?"}) { // from class: Contabilidad.JIFConsultar_LibroAuxiliar_Fecha.14
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false, false, true};

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
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(120);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(120);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(120);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(120);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(120);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(80);
        centrarDatosTabla(this.JTDetalle, 2);
        centrarDatosTabla(this.JTDetalle, 3);
        centrarDatosTabla(this.JTDetalle, 4);
        centrarDatosTabla(this.JTDetalle, 5);
    }

    public void centrarDatosTabla(JTable jTable, int columna) {
        DefaultTableCellRenderer alinear = new DefaultTableCellRenderer();
        alinear.setHorizontalAlignment(4);
        jTable.getColumnModel().getColumn(columna).setCellRenderer(alinear);
    }

    private void mCargarDatos(boolean estado) {
        if (this.JCHVisualizarNiif.isSelected()) {
            if (estado) {
                this.xsql = "SELECT `cc_puc_niif`.`Id`  , `cc_puc_niif`.`Nbre`,FORMAT(`cc_puc_niif`.SaldoAnterior,2) as SaldoAnterior,FORMAT(`cc_puc_niif`.VDebito,2) as VDebito,FORMAT(`cc_puc_niif`.VCredito,2) as VCredito,FORMAT(`cc_puc_niif`.SaldoActual,2) as SaldoActual , '' as vacio \nFROM `cc_detalle_documentoc`  \nINNER JOIN  `cc_pucg_niif`ON (`cc_detalle_documentoc`.`Id_Puc` = `cc_pucg_niif`.`Id_Puc_G`) AND (cc_pucg_niif.`Estado`=1)\nINNER JOIN  `cc_puc_niif`ON (`cc_puc_niif`.`Id` = `cc_pucg_niif`.`Id_Puc_Niif`)\nGROUP BY `cc_puc_niif`.`Id`\nORDER BY `cc_puc_niif`.`Id` ASC";
            } else if (!this.JTFCuentaInicio.getText().isEmpty()) {
                this.xsql = "SELECT `cc_puc_niif`.`Id`, `cc_puc_niif`.`Nbre`, FORMAT(`cc_puc_niif`.SaldoAnterior,2) as SaldoAnterior, FORMAT(`cc_puc_niif`.VDebito,2) as VDebito, FORMAT(`cc_puc_niif`.VCredito,2) as VCredito, FORMAT(`cc_puc_niif`.SaldoActual,2) as SaldoActual \nFROM `cc_detalle_documentoc` \nINNER JOIN  `cc_pucg_niif` ON (`cc_detalle_documentoc`.`Id_Puc` = `cc_pucg_niif`.`Id_Puc_G`) AND (cc_pucg_niif.`Estado`=1)\nINNER JOIN  `cc_puc_niif`ON (`cc_puc_niif`.`Id` = `cc_pucg_niif`.`Id_Puc_Niif`)\nWHERE ( SUBSTRING( cc_puc_niif.Id,1," + this.JTFCuentaInicio.getText().length() + ") >= " + this.JTFCuentaInicio.getText() + " AND SUBSTRING( cc_puc_niif.Id,1," + this.JTFCuentaFin.getText().length() + ") <= " + this.JTFCuentaFin.getText() + " ) GROUP BY `cc_puc_niif`.`Id`\nORDER BY `cc_puc_niif`.`Id` ASC;";
            } else {
                this.xsql = "SELECT `cc_puc_niif`.`Id`  , `cc_puc_niif`.`Nbre`,FORMAT(`cc_puc_niif`.SaldoAnterior,2) as SaldoAnterior,FORMAT(`cc_puc_niif`.VDebito,2) as VDebito,FORMAT(`cc_puc_niif`.VCredito,2) as VCredito,FORMAT(`cc_puc_niif`.SaldoActual,2) as SaldoActual \nFROM `cc_detalle_documentoc`  \nINNER JOIN  `cc_pucg_niif`ON (`cc_detalle_documentoc`.`Id_Puc` = `cc_pucg_niif`.`Id_Puc_G`) AND (cc_pucg_niif.`Estado`=1)\nINNER JOIN  `cc_puc_niif`ON (`cc_puc_niif`.`Id` = `cc_pucg_niif`.`Id_Puc_Niif`)\nGROUP BY `cc_puc_niif`.`Id`\nORDER BY `cc_puc_niif`.`Id` ASC";
            }
        } else if (!estado && !this.JTFCuentaInicio.getText().isEmpty()) {
            this.xsql = "SELECT `cc_puc`.`Id`  , `cc_puc`.`Nbre`,FORMAT(`cc_puc`.SaldoAnterior,2) as SaldoAnterior,FORMAT(`cc_puc`.VDebito,2) as VDebito,FORMAT(`cc_puc`.VCredito,2) as VCredito,FORMAT(`cc_puc`.SaldoActual,2) as SaldoActual \nFROM `cc_detalle_documentoc`  INNER JOIN  `cc_puc`  ON (`cc_detalle_documentoc`.`Id_Puc` = `cc_puc`.`Id`)\nWHERE ( SUBSTRING( cc_puc.Id,1," + this.JTFCuentaInicio.getText().length() + ") >= " + this.JTFCuentaInicio.getText() + " AND SUBSTRING( cc_puc.Id,1," + this.JTFCuentaFin.getText().length() + ") <= " + this.JTFCuentaFin.getText() + " ) GROUP BY `cc_puc`.`Id`\nORDER BY `cc_puc`.`Id` ASC";
        } else {
            this.xsql = "SELECT `cc_puc`.`Id`  , `cc_puc`.`Nbre`,FORMAT(`cc_puc`.SaldoAnterior,2) as SaldoAnterior,FORMAT(`cc_puc`.VDebito,2) as VDebito,FORMAT(`cc_puc`.VCredito,2) as VCredito,FORMAT(`cc_puc`.SaldoActual,2) as SaldoActual \nFROM `cc_detalle_documentoc`  INNER JOIN  `cc_puc`  ON (`cc_detalle_documentoc`.`Id_Puc` = `cc_puc`.`Id`)\nGROUP BY `cc_puc`.`Id`\nORDER BY `cc_puc`.`Id` ASC";
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
                    this.xmodelo.setValueAt(rs.getString("SaldoAnterior"), x, 2);
                    this.xmodelo.setValueAt(rs.getString("VDebito"), x, 3);
                    this.xmodelo.setValueAt(rs.getString("VCredito"), x, 4);
                    this.xmodelo.setValueAt(rs.getString("SaldoActual"), x, 5);
                    this.xmodelo.setValueAt(false, x, 6);
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
            this.xsql = "ALTER TABLE `cc_tmp_lauxiliar` ENGINE=INNODB AUTO_INCREMENT=1 COMMENT='' ROW_FORMAT=DEFAULT CHARSET=utf8 COLLATE=utf8_bin ";
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
            if (!this.JCH_FiltroPorTercero.isSelected()) {
                this.xsql = "INSERT IGNORE INTO cc_tmp_lauxiliar(`FechaD`\n    , `TIpoDoc`\n    , `RazonSC`\n    , `Descripcion`\n    , `NCheque`\n    , `NConsecutivo`\n    , `VDebito`\n    , `VCredito`\n    , `VSActual`\n    , `IdPuc`\n    , `NCuenta`\n    , `SAnterior`\n    , `CDebito`\n    , `CCredito`\n    , `SActual`\n    , `TipoIdNormal`\n    , `IdConcatenado`\n    , `NEmpresa`\n    , `Direccion`\n    , `NMunicipio`\n    , `NDepartamento`\n    , `Logo`\n    , `NFactura`)\nSELECT\n    `cc_documentoc`.`FechaD`\n    , cc_tipo_documentoc.`Nbre`  TIpoDoc\n    , cc_terceros.`RazonSocialCompleta` RazonSC\n    , `cc_detalle_documentoc`.`Concepto`\n    , `cc_documentoc`.`NCheque`\n    , `cc_documentoc`.`NConsecutivo`\n    , cc_detalle_documentoc.`VDebito`\n    , cc_detalle_documentoc.`VCredito`\n    , 0 VSActual\n    , cc_detalle_documentoc.`Id_Puc` IdPuc\n    ,  `cc_puc`.`Nbre` NCuenta\n    ,  `cc_puc`.`SaldoAnterior` \n    ,  `cc_puc`.`VDebito` CDebito\n    ,  `cc_puc`.`VCredito` CCredito\n    ,  `cc_puc`.`SaldoActual` SActual\n     , d_ips.`TipoIdEmpresa` `TipoIdNormal`\n    , `d_ips`.`IdConcatenado`\n    , `d_ips`.`NIEmpresa` `NEmpresa`\n    , `d_ips`.`Direccion` `Direccion`\n    , `d_ips`.`NMunicipio` `NMunicipio`\n    , UCASE(`d_ips`.`NDepartamento`) NDepartamento\n    , `d_ips`.Logo\n    , if(cc_detalle_documentoc.`NFactura`='', IFNULL(cc_radicacion.NoFactura, ''),cc_detalle_documentoc.`NFactura`) NFactura\nFROM\n     `d_ips`,\n     cc_detalle_documentoc\n    INNER JOIN  `cc_documentoc`\n        ON (cc_detalle_documentoc.`Id_Documentoc` = `cc_documentoc`.`Id`)\n    INNER JOIN  cc_tipo_documentoc\n        ON (`cc_documentoc`.`Id_TipoComprobante` = cc_tipo_documentoc.`Id`)\n    INNER JOIN   `cc_puc`\n        ON (cc_detalle_documentoc.`Id_Puc` =  `cc_puc`.`Id`)\n    INNER JOIN  `cc_terceros`\n        ON (cc_terceros.`Id` = cc_detalle_documentoc.`Id_Tercero`)\n    LEFT JOIN  cc_radicacion\n        ON (cc_radicacion.`Id` = `cc_documentoc`.`Id_Radicacion`)\nWHERE ( cc_detalle_documentoc.`Id_Puc` IN (" + this.xcodigo.substring(1, this.xcodigo.length()) + ")\n    and `cc_tipo_documentoc`.`Es_Niif`" + this.xAplicaNiif + " AND `cc_documentoc`.`FechaD` >='" + this.xmt.formatoAMD1.format(this.JDCFechaInicio.getDate()) + "'\n    AND `cc_documentoc`.`FechaD` <='" + this.xmt.formatoAMD1.format(this.JDCFechaFin.getDate()) + "'\n    AND `cc_documentoc`.`Estado` =1) \nORDER BY cc_detalle_documentoc.`Id_Puc` ASC, `cc_documentoc`.`FechaD` ASC";
            } else {
                this.xsql = "INSERT IGNORE INTO cc_tmp_lauxiliar(`FechaD`\n    , `TIpoDoc`\n    , `RazonSC`\n    , `Descripcion`\n    , `NCheque`\n    , `NConsecutivo`\n    , `VDebito`\n    , `VCredito`\n    , `VSActual`\n    , `IdPuc`\n    , `NCuenta`\n    , `SAnterior`\n    , `CDebito`\n    , `CCredito`\n    , `SActual`\n    , `TipoIdNormal`\n    , `IdConcatenado`\n    , `NEmpresa`\n    , `Direccion`\n    , `NMunicipio`\n    , `NDepartamento`\n    , `Logo`\n    , `NFactura`)\nSELECT\n    `cc_documentoc`.`FechaD`\n    , cc_tipo_documentoc.`Nbre`  TIpoDoc\n    , cc_terceros.`RazonSocialCompleta` RazonSC\n    , `cc_detalle_documentoc`.`Concepto`\n    , `cc_documentoc`.`NCheque`\n    , `cc_documentoc`.`NConsecutivo`\n    , cc_detalle_documentoc.`VDebito`\n    , cc_detalle_documentoc.`VCredito`\n    , 0 VSActual\n    , cc_detalle_documentoc.`Id_Puc` IdPuc\n    ,  `cc_puc`.`Nbre` NCuenta\n    ,  `cc_puc`.`SaldoAnterior` \n    ,  `cc_puc`.`VDebito` CDebito\n    ,  `cc_puc`.`VCredito` CCredito\n    ,  `cc_puc`.`SaldoActual` SActual\n     , d_ips.`TipoIdEmpresa` `TipoIdNormal`\n    , `d_ips`.`IdConcatenado`\n    , `d_ips`.`NIEmpresa` `NEmpresa`\n    , `d_ips`.`Direccion` `Direccion`\n    , `d_ips`.`NMunicipio` `NMunicipio`\n    , UCASE(`d_ips`.`NDepartamento`) NDepartamento\n    , `d_ips`.Logo\n    , if(cc_detalle_documentoc.`NFactura`='', IFNULL(cc_radicacion.NoFactura, ''),cc_detalle_documentoc.`NFactura`) NFactura\nFROM\n     `d_ips`,\n     cc_detalle_documentoc\n    INNER JOIN  `cc_documentoc`\n        ON (cc_detalle_documentoc.`Id_Documentoc` = `cc_documentoc`.`Id`)\n    INNER JOIN  cc_tipo_documentoc\n        ON (`cc_documentoc`.`Id_TipoComprobante` = cc_tipo_documentoc.`Id`)\n    INNER JOIN   `cc_puc`\n        ON (cc_detalle_documentoc.`Id_Puc` =  `cc_puc`.`Id`)\n    INNER JOIN  `cc_terceros`\n        ON (cc_terceros.`Id` = cc_detalle_documentoc.`Id_Tercero`)\n    LEFT JOIN  cc_radicacion\n        ON (cc_radicacion.`Id` = `cc_documentoc`.`Id_Radicacion`)\nWHERE (cc_detalle_documentoc.Id_Tercero='" + getIdTercero() + "' and cc_detalle_documentoc.`Id_Puc` IN (" + this.xcodigo.substring(1, this.xcodigo.length()) + ")\n    and `cc_tipo_documentoc`.`Es_Niif`" + this.xAplicaNiif + " AND `cc_documentoc`.`FechaD` >='" + this.xmt.formatoAMD1.format(this.JDCFechaInicio.getDate()) + "'\n    AND `cc_documentoc`.`FechaD` <='" + this.xmt.formatoAMD1.format(this.JDCFechaFin.getDate()) + "'\n    AND `cc_documentoc`.`Estado` =1) \nORDER BY cc_detalle_documentoc.`Id_Puc` ASC, `cc_documentoc`.`FechaD` ASC";
            }
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
            Logger.getLogger(JIFConsultar_LibroAuxiliar_Fecha.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public String getIdTercero() {
        return this.idTercero;
    }

    public void setIdTercero(String idTercero) {
        this.idTercero = idTercero;
    }
}
