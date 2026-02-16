package ComprasBS;

import Acceso.Principal;
import ParametrizacionN.JIFSSuministro;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyVetoException;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

/* JADX INFO: loaded from: GenomaP.jar:ComprasBS/JIFCotizacion.class */
public class JIFCotizacion extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private DefaultTableModel xmodelocot;
    private DefaultTableModel xmodeloprov;
    private DefaultTableModel xmodelocomp;
    private Object[] xdatos;
    private Object[] xdatoscot;
    private String xnombre;
    private String[] xmodulo;
    private JIFSSuministro xjifsuministro;
    private File xfile;
    private boolean xlleno;
    private String xidcot;
    private JButton JBAprobar;
    private JButton JBComparar;
    private JCheckBox JCHEstado;
    private JDateChooser JDFFechaC;
    private JPanel JPCotizacion;
    private JPanel JPRequisiciones;
    private JScrollPane JPSComparacion;
    private JScrollPane JPSCotizacion;
    private JScrollPane JPSProvedor;
    private JScrollPane JSPDetalle;
    private JTextArea JTAObservacion;
    private JTextArea JTAObservacionG;
    private JTable JTComparacion;
    private JTable JTCotizacion;
    private JTable JTDetalle;
    private JFormattedTextField JTFFValorIVA;
    private JFormattedTextField JTFFValorST;
    private JFormattedTextField JTFFValorTotal;
    public JTextField JTFNoCot;
    public JTextField JTFNombreP;
    private JTextField JTFRuta;
    private JTabbedPane JTPGeneral;
    private JTable JTProveedor;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private ConsultasMySQL xconsulta = new ConsultasMySQL();
    private Metodos xmetodos = new Metodos();
    private int xestado = 1;
    private int xautorizado = 1;
    private String xid = "";
    private boolean xestadog = false;

    public JIFCotizacion(String xnombre) {
        initComponents();
        if (xnombre.equals("xjifSolicitudPTO")) {
            setTitle("SOLICITUDES Y REGISTRO DE COTIZACIONES");
            this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "SOLICITUDES", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        } else if (xnombre.equals("jifcotizacion")) {
            setTitle("REGISTRO DE COTIZACIONES");
        }
        this.xnombre = xnombre;
        mCargarDatosTabla();
        this.JDFFechaC.setDate(this.xmetodos.getFechaActual());
    }

    /* JADX WARN: Type inference failed for: r3v23, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v42, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v63, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v9, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JTPGeneral = new JTabbedPane();
        this.JPRequisiciones = new JPanel();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JPCotizacion = new JPanel();
        this.JPSCotizacion = new JScrollPane();
        this.JTCotizacion = new JTable();
        this.JTFNombreP = new JTextField();
        this.JTFNoCot = new JTextField();
        this.JDFFechaC = new JDateChooser();
        this.JCHEstado = new JCheckBox();
        this.JTFRuta = new JTextField();
        this.JPSProvedor = new JScrollPane();
        this.JTProveedor = new JTable();
        this.JTFFValorST = new JFormattedTextField();
        this.JTFFValorIVA = new JFormattedTextField();
        this.JTFFValorTotal = new JFormattedTextField();
        this.JBComparar = new JButton();
        this.JPSComparacion = new JScrollPane();
        this.JTComparacion = new JTable();
        this.JBAprobar = new JButton();
        this.jScrollPane1 = new JScrollPane();
        this.JTAObservacion = new JTextArea();
        this.jScrollPane2 = new JScrollPane();
        this.JTAObservacionG = new JTextArea();
        setClosable(true);
        setIconifiable(true);
        setTitle("MUNICIPIO");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifcotizacion");
        try {
            setSelected(true);
        } catch (PropertyVetoException e1) {
            e1.printStackTrace();
        }
        addInternalFrameListener(new InternalFrameListener() { // from class: ComprasBS.JIFCotizacion.1
            public void internalFrameOpened(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                JIFCotizacion.this.formInternalFrameClosing(evt);
            }

            public void internalFrameClosed(InternalFrameEvent evt) {
            }

            public void internalFrameIconified(InternalFrameEvent evt) {
            }

            public void internalFrameDeiconified(InternalFrameEvent evt) {
            }

            public void internalFrameActivated(InternalFrameEvent evt) {
            }

            public void internalFrameDeactivated(InternalFrameEvent evt) {
            }
        });
        this.JTPGeneral.setForeground(new Color(255, 0, 0));
        this.JTPGeneral.setFont(new Font("Arial", 1, 14));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "REQUISICIONES AUTORIZADAS", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalle.setSelectionMode(0);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: ComprasBS.JIFCotizacion.2
            public void mouseClicked(MouseEvent evt) {
                JIFCotizacion.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        GroupLayout JPRequisicionesLayout = new GroupLayout(this.JPRequisiciones);
        this.JPRequisiciones.setLayout(JPRequisicionesLayout);
        JPRequisicionesLayout.setHorizontalGroup(JPRequisicionesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPRequisicionesLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPDetalle, -1, 870, 32767).addContainerGap()));
        JPRequisicionesLayout.setVerticalGroup(JPRequisicionesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPRequisicionesLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPDetalle, -1, 634, 32767).addContainerGap()));
        this.JTPGeneral.addTab("REQUISICIONES", this.JPRequisiciones);
        this.JPSCotizacion.setBorder(BorderFactory.createTitledBorder((Border) null, "PRODUCTOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTCotizacion.setFont(new Font("Arial", 1, 12));
        this.JTCotizacion.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTCotizacion.setSelectionBackground(new Color(255, 255, 255));
        this.JTCotizacion.setSelectionForeground(new Color(255, 0, 0));
        this.JTCotizacion.addPropertyChangeListener(new PropertyChangeListener() { // from class: ComprasBS.JIFCotizacion.3
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFCotizacion.this.JTCotizacionPropertyChange(evt);
            }
        });
        this.JPSCotizacion.setViewportView(this.JTCotizacion);
        this.JTFNombreP.setFont(new Font("Arial", 1, 12));
        this.JTFNombreP.setHorizontalAlignment(2);
        this.JTFNombreP.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre del Proveedor", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFNombreP.addMouseListener(new MouseAdapter() { // from class: ComprasBS.JIFCotizacion.4
            public void mouseClicked(MouseEvent evt) {
                JIFCotizacion.this.JTFNombrePMouseClicked(evt);
            }
        });
        this.JTFNoCot.setFont(new Font("Arial", 1, 12));
        this.JTFNoCot.setHorizontalAlignment(2);
        this.JTFNoCot.setBorder(BorderFactory.createTitledBorder((Border) null, "Código Cot.", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFechaC.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFechaC.setDateFormatString("dd/MM/yyyy");
        this.JDFFechaC.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setSelected(true);
        this.JCHEstado.setText("Estado");
        this.JCHEstado.addActionListener(new ActionListener() { // from class: ComprasBS.JIFCotizacion.5
            public void actionPerformed(ActionEvent evt) {
                JIFCotizacion.this.JCHEstadoActionPerformed(evt);
            }
        });
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setToolTipText("Doble click para abrir asistente");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ruta", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: ComprasBS.JIFCotizacion.6
            public void mouseClicked(MouseEvent evt) {
                JIFCotizacion.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JPSProvedor.setBorder(BorderFactory.createTitledBorder((Border) null, "COTIZACIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTProveedor.setFont(new Font("Arial", 1, 12));
        this.JTProveedor.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTProveedor.setSelectionBackground(new Color(255, 255, 255));
        this.JTProveedor.setSelectionForeground(new Color(255, 0, 0));
        this.JTProveedor.addMouseListener(new MouseAdapter() { // from class: ComprasBS.JIFCotizacion.7
            public void mouseClicked(MouseEvent evt) {
                JIFCotizacion.this.JTProveedorMouseClicked(evt);
            }
        });
        this.JPSProvedor.setViewportView(this.JTProveedor);
        this.JTFFValorST.setBorder(BorderFactory.createTitledBorder((Border) null, "Sub Total", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFValorST.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFValorST.setHorizontalAlignment(4);
        this.JTFFValorST.setToolTipText("Sub Total");
        this.JTFFValorST.setFont(new Font("Arial", 1, 13));
        this.JTFFValorIVA.setBorder(BorderFactory.createTitledBorder((Border) null, "Total IVA", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFValorIVA.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFValorIVA.setHorizontalAlignment(4);
        this.JTFFValorIVA.setToolTipText("Total IVA");
        this.JTFFValorIVA.setFont(new Font("Arial", 1, 13));
        this.JTFFValorTotal.setBorder(BorderFactory.createTitledBorder((Border) null, "Total", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFValorTotal.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFValorTotal.setHorizontalAlignment(4);
        this.JTFFValorTotal.setToolTipText("Total");
        this.JTFFValorTotal.setFont(new Font("Arial", 1, 13));
        this.JBComparar.setFont(new Font("Arial", 1, 12));
        this.JBComparar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/compare.png")));
        this.JBComparar.setText("Detalle Comparación");
        this.JBComparar.addActionListener(new ActionListener() { // from class: ComprasBS.JIFCotizacion.8
            public void actionPerformed(ActionEvent evt) {
                JIFCotizacion.this.JBCompararActionPerformed(evt);
            }
        });
        this.JPSComparacion.setBorder(BorderFactory.createTitledBorder((Border) null, "COMPARACIÓN Y APROBACIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTComparacion.setFont(new Font("Arial", 1, 12));
        this.JTComparacion.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTComparacion.setSelectionBackground(new Color(255, 255, 255));
        this.JTComparacion.setSelectionForeground(new Color(255, 0, 0));
        this.JTComparacion.addMouseListener(new MouseAdapter() { // from class: ComprasBS.JIFCotizacion.9
            public void mouseClicked(MouseEvent evt) {
                JIFCotizacion.this.JTComparacionMouseClicked(evt);
            }
        });
        this.JPSComparacion.setViewportView(this.JTComparacion);
        this.JBAprobar.setFont(new Font("Arial", 1, 12));
        this.JBAprobar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ok29x27.png")));
        this.JBAprobar.setText("Aprobar");
        this.JBAprobar.addActionListener(new ActionListener() { // from class: ComprasBS.JIFCotizacion.10
            public void actionPerformed(ActionEvent evt) {
                JIFCotizacion.this.JBAprobarActionPerformed(evt);
            }
        });
        this.JTAObservacion.setColumns(1);
        this.JTAObservacion.setFont(new Font("Arial", 1, 12));
        this.JTAObservacion.setLineWrap(true);
        this.JTAObservacion.setRows(1);
        this.JTAObservacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación de Aprobación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jScrollPane1.setViewportView(this.JTAObservacion);
        this.jScrollPane2.setBorder(BorderFactory.createTitledBorder((Border) null, "Observacion", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTAObservacionG.setColumns(20);
        this.JTAObservacionG.setFont(new Font("Arial", 1, 12));
        this.JTAObservacionG.setRows(5);
        this.jScrollPane2.setViewportView(this.JTAObservacionG);
        GroupLayout JPCotizacionLayout = new GroupLayout(this.JPCotizacion);
        this.JPCotizacion.setLayout(JPCotizacionLayout);
        JPCotizacionLayout.setHorizontalGroup(JPCotizacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPCotizacionLayout.createSequentialGroup().addContainerGap().addGroup(JPCotizacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPSProvedor).addComponent(this.JPSCotizacion).addComponent(this.JPSComparacion, GroupLayout.Alignment.TRAILING).addGroup(JPCotizacionLayout.createSequentialGroup().addComponent(this.JBComparar, -2, 245, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBAprobar, -2, 228, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane1)).addGroup(JPCotizacionLayout.createSequentialGroup().addComponent(this.JTFRuta, -2, 403, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane2)).addGroup(GroupLayout.Alignment.TRAILING, JPCotizacionLayout.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.JTFFValorST, -2, 130, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFValorIVA, -2, 130, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFValorTotal, -2, 130, -2)).addGroup(GroupLayout.Alignment.TRAILING, JPCotizacionLayout.createSequentialGroup().addComponent(this.JDFFechaC, -1, -1, 32767).addGap(18, 18, 18).addComponent(this.JTFNoCot, -2, 100, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFNombreP, -2, 520, -2).addGap(18, 18, 18).addComponent(this.JCHEstado))).addContainerGap()));
        JPCotizacionLayout.setVerticalGroup(JPCotizacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPCotizacionLayout.createSequentialGroup().addContainerGap().addGroup(JPCotizacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPCotizacionLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFNombreP, -2, 50, -2).addComponent(this.JTFNoCot, -2, 50, -2).addComponent(this.JCHEstado)).addComponent(this.JDFFechaC, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPCotizacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTFRuta, -1, 46, 32767).addComponent(this.jScrollPane2, -2, 0, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPSProvedor, -2, 122, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPSCotizacion, -2, 135, -2).addGap(3, 3, 3).addGroup(JPCotizacionLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFValorST, -1, 50, 32767).addComponent(this.JTFFValorIVA, -1, 50, 32767).addComponent(this.JTFFValorTotal, -1, 50, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPSComparacion, -2, 134, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPCotizacionLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jScrollPane1, -2, 65, -2).addGroup(JPCotizacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JBComparar, -1, -1, 32767).addComponent(this.JBAprobar, -2, 46, -2))).addGap(42, 42, 42)));
        this.JTPGeneral.addTab("COTIZACIONES", this.JPCotizacion);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTPGeneral).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTPGeneral, -2, 687, -2).addGap(3, 3, 3)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            Principal.txtNo.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
            Object[] botones = {"Visualizar Orden", "Registrar Cotización", "Cerrar"};
            int n = JOptionPane.showInternalOptionDialog(this, "Que desea realizar", "ACCIÓN", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), botones, "Cerrar");
            if (n == 0) {
                if (this.JTDetalle.getSelectedRow() != -1) {
                    mImprimirDoc(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString(), "CC_Requisicion");
                    return;
                } else {
                    JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una fila", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    return;
                }
            }
            if (n == 1) {
                this.JTPGeneral.setSelectedIndex(1);
                mCargarDatosCotizacion();
                mCargarDatosProductos();
                mCargarDatosComparacion();
            }
        }
    }

    private void mImprimirDoc(String xid, String xArchivo) {
        if (!Principal.txtNo.getText().isEmpty()) {
            String[][] mparametros = new String[4][2];
            mparametros[0][0] = "IdC";
            mparametros[0][1] = xid;
            mparametros[1][0] = "UsuarioS";
            mparametros[1][1] = Principal.usuarioSistemaDTO.getLogin();
            mparametros[2][0] = "SUBREPORT_DIR";
            mparametros[2][1] = this.xmetodos.getSO() + this.xmetodos.getBarra() + "Reportes" + this.xmetodos.getBarra();
            mparametros[3][0] = "SUBREPORTFIRMA_DIR";
            mparametros[3][1] = this.xmetodos.getSO() + this.xmetodos.getBarra() + "Firmas" + this.xmetodos.getBarra();
            this.xmetodos.GenerarPDF(this.xmetodos.getRutaRep() + xArchivo, mparametros);
        }
    }

    private void mAutorizar(String xid) {
        String sql = "update `cc_r_requisicion` set cc_r_requisicion.`Evaluado`=1 where cc_r_requisicion.`Id`='" + xid + "'";
        this.xconsulta.ejecutarSQL(sql);
        this.xconsulta.cerrarConexionBd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosing(InternalFrameEvent evt) {
        Principal.mLimpiarDatosP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNombrePMouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JFileChooser xfilec = new JFileChooser("S:\\Manuales del Usuario");
            int xv = xfilec.showOpenDialog(this);
            if (xv == 0) {
                this.xfile = xfilec.getSelectedFile();
                this.JTFRuta.setText(this.xmetodos.mTraerUrlBD(this.xfile.getAbsolutePath()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEstadoActionPerformed(ActionEvent evt) {
        if (this.JCHEstado.isSelected()) {
            this.xestado = 1;
        } else {
            this.xestado = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTCotizacionPropertyChange(PropertyChangeEvent evt) {
        if (this.JTCotizacion.getSelectedRow() != -1 && !this.JTCotizacion.getValueAt(this.JTCotizacion.getSelectedRow(), 2).equals("") && !this.JTCotizacion.getValueAt(this.JTCotizacion.getSelectedRow(), 3).equals("") && !this.JTCotizacion.getValueAt(this.JTCotizacion.getSelectedRow(), 5).equals("")) {
            mCalcularValoresCelda();
            mSumarValoresTabla();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTProveedorMouseClicked(MouseEvent evt) {
        if (this.JTProveedor.getSelectedRow() != -1 && evt.getClickCount() == 2) {
            mCargarDatosProductos();
            mSumarValoresTabla();
        } else if (this.JTProveedor.getSelectedRow() != -1 && this.JTProveedor.getSelectedColumn() == 4 && !this.xmodeloprov.getValueAt(this.JTProveedor.getSelectedRow(), 4).equals("")) {
            this.xmetodos.mostrarPdf(this.xmodeloprov.getValueAt(this.JTProveedor.getSelectedRow(), 4).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBCompararActionPerformed(ActionEvent evt) {
        if (!Principal.txtNo.getText().isEmpty() && this.JTProveedor.getRowCount() >= 1) {
            mImprimirDoc(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString(), "CC_Req_CuadroComparativo");
        } else {
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una requisición \n ó no hay cotizaciones registradas", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTPGeneral.setSelectedIndex(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTComparacionMouseClicked(MouseEvent evt) {
        if (this.JTComparacion.getSelectedRow() > -1) {
            this.JTAObservacion.setText(this.xmodelocomp.getValueAt(this.JTComparacion.getSelectedRow(), 6).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBAprobarActionPerformed(ActionEvent evt) {
        if (this.JTComparacion.getSelectedRow() != -1) {
            if (!this.JTAObservacion.getText().isEmpty()) {
                if (!Boolean.valueOf(this.xmodelocomp.getValueAt(this.JTComparacion.getSelectedRow(), 5).toString()).booleanValue()) {
                    int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "VERIFICAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    if (n == 0) {
                        String sql = "UPDATE `cc_r_cotizacion` SET Aprobado=1, Observacion= '" + this.JTAObservacion.getText() + "', IdUsuarioAut='" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "' WHERE Id='" + this.xmodelocomp.getValueAt(this.JTComparacion.getSelectedRow(), 0).toString() + "'";
                        this.xconsulta.ejecutarSQL(sql);
                        this.xconsulta.cerrarConexionBd();
                        mCargarDatosComparacion();
                        this.JTAObservacion.setText("");
                        return;
                    }
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Este proveedor ya está aprovado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe digitar una Observación de Aprobacion para continuar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTAObservacion.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un Proveedor para continuar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    private void mCalcularValoresCelda() {
        double cantidad = Double.valueOf(this.xmodelocot.getValueAt(this.JTCotizacion.getSelectedRow(), 2).toString()).doubleValue();
        double valorpro = Double.valueOf(this.xmodelocot.getValueAt(this.JTCotizacion.getSelectedRow(), 3).toString()).doubleValue();
        double PIva = Double.valueOf(this.xmodelocot.getValueAt(this.JTCotizacion.getSelectedRow(), 4).toString()).doubleValue();
        if (PIva != 0.0d) {
            this.xmodelocot.setValueAt(Double.valueOf(((valorpro * cantidad) * PIva) / 100.0d), this.JTCotizacion.getSelectedRow(), 5);
        }
        double valoriva = Double.valueOf(this.xmodelocot.getValueAt(this.JTCotizacion.getSelectedRow(), 5).toString()).doubleValue();
        double total = (cantidad * valorpro) + valoriva;
        this.xmodelocot.setValueAt(Double.valueOf(total), this.JTCotizacion.getSelectedRow(), 6);
    }

    private void mSumarValoresTabla() {
        double vu = 0.0d;
        double iva = 0.0d;
        double vt = 0.0d;
        for (int x = 0; x < this.JTCotizacion.getRowCount(); x++) {
            vu += Double.valueOf(this.xmodelocot.getValueAt(x, 3).toString()).doubleValue() * Double.valueOf(this.xmodelocot.getValueAt(x, 2).toString()).doubleValue();
            iva += Double.valueOf(this.xmodelocot.getValueAt(x, 5).toString()).doubleValue();
            vt += Double.valueOf(this.xmodelocot.getValueAt(x, 6).toString()).doubleValue();
        }
        this.JTFFValorST.setValue(Double.valueOf(vu));
        this.JTFFValorIVA.setValue(Double.valueOf(iva));
        this.JTFFValorTotal.setValue(Double.valueOf(vt));
    }

    public void mNuevo() {
        this.JDFFechaC.setDate(this.xmetodos.getFechaActual());
        this.JTFNoCot.setText("");
        this.JTFNombreP.setText("");
        this.JTFRuta.setText("");
        this.JTAObservacionG.setText("");
        this.xestado = 1;
        mCargarDatosCotizacion();
        mCargarDatosProductos();
        this.JTFFValorST.setValue(0);
        this.JTFFValorIVA.setValue(0);
        this.JTFFValorTotal.setValue(0);
        this.JTAObservacion.setText("");
    }

    public void mGrabar() {
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "VERIFICAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0 && !Principal.txtNo.getText().isEmpty()) {
            String sql = " Insert into cc_r_cotizacion(`Id_requisicion`, `NProveedor`, `NCotizacion`, `FechaCot`, `SoporteUrl`, ObservacionG, `Estado`, `Fecha`, `UsuarioS`)  values('" + Principal.txtNo.getText() + "','" + this.JTFNombreP.getText().toUpperCase() + "','" + this.JTFNoCot.getText().toUpperCase() + "','" + this.xmetodos.formatoAMD.format(this.JDFFechaC.getDate()) + "','" + this.JTFRuta.getText() + "','" + this.JTAObservacionG.getText() + "','" + this.xestado + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
            this.xidcot = this.xconsulta.ejecutarSQLId(sql);
            this.xconsulta.cerrarConexionBd();
            mGrabarValoresProduc();
            mNuevo();
            mCargarDatosComparacion();
        }
    }

    private void mGrabarValoresProduc() {
        for (int x = 0; x < this.JTCotizacion.getRowCount(); x++) {
            String sql = "insert into  cc_r_cotizacion_valor(`Id_Cotizacion` , `Id_Suministro`  , `ValorU`, `PIva`, `Iva`, `UsuarioS`)values ('" + this.xidcot + "','" + this.xmodelocot.getValueAt(x, 0) + "','" + this.xmodelocot.getValueAt(x, 3) + "','" + this.xmodelocot.getValueAt(x, 4) + "','" + this.xmodelocot.getValueAt(x, 5) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
            this.xconsulta.ejecutarSQL(sql);
            this.xconsulta.cerrarConexionBd();
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "FechaR", "Unidad F", "Presupuesto", "Persona que Solicita"}) { // from class: ComprasBS.JIFCotizacion.11
            Class[] types = {Long.class, String.class, String.class, Double.class, String.class};
            boolean[] canEdit = {false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(35);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(200);
    }

    private void mCargarDatosTabla() {
        try {
            mCrearModeloDatos();
            ResultSet xrs = this.xconsulta.traerRs("SELECT `cc_r_requisicion`.`Id`  , `cc_r_requisicion`.`FechaR` , `cc_unidad_funcional`.`Nbre` , `cc_r_requisicion`.`VPresupuestado`\n    , `persona`.`NUsuario`\nFROM `cc_r_requisicion` INNER JOIN `baseserver`.`cc_unidad_funcional`   ON (`cc_r_requisicion`.`Id_UnidadFC` = `cc_unidad_funcional`.`Id`)\nINNER JOIN `baseserver`.`rh_tipo_persona_cargon`  ON (`cc_r_requisicion`.`Id_Persona_cargo` = `rh_tipo_persona_cargon`.`Id`)\nINNER JOIN `baseserver`.`persona`  ON (`persona`.`Id_persona` = `rh_tipo_persona_cargon`.`Id_Persona`)\nWHERE (`cc_r_requisicion`.`Autorizado` =1) ORDER BY `cc_r_requisicion`.`FechaR` DESC;");
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(1)), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(4)), n, 3);
                    this.xmodelo.setValueAt(xrs.getString(5), n, 4);
                    n++;
                }
            }
            xrs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFCotizacion.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloProducto() {
        this.xmodelocot = new DefaultTableModel(new Object[0], new String[]{"Id", "Producto", "Cantidad", "Valor Unitario", "% Iva", "Iva", "VTotal"}) { // from class: ComprasBS.JIFCotizacion.12
            Class[] types = {Long.class, String.class, Long.class, Double.class, Double.class, Double.class, Double.class};
            boolean[] canEdit = {false, false, false, true, true, true, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTCotizacion.setModel(this.xmodelocot);
        this.JTCotizacion.getColumnModel().getColumn(0).setPreferredWidth(4);
        this.JTCotizacion.getColumnModel().getColumn(1).setPreferredWidth(300);
        this.JTCotizacion.getColumnModel().getColumn(2).setPreferredWidth(10);
        this.JTCotizacion.getColumnModel().getColumn(3).setPreferredWidth(15);
        this.JTCotizacion.getColumnModel().getColumn(4).setPreferredWidth(15);
        this.JTCotizacion.getColumnModel().getColumn(5).setPreferredWidth(15);
        this.JTCotizacion.getColumnModel().getColumn(6).setPreferredWidth(15);
    }

    private void mCargarDatosProductos() {
        String sql;
        try {
            mCrearModeloProducto();
            if (this.JTProveedor.getSelectedRow() != -1) {
                sql = "SELECT `cc_r_requisicion_detalle`.`Id`\n, `cc_r_requisicion_detalle`.`Descripcion`\n, `cc_r_requisicion_detalle`.`Cantidad`\n, `cc_r_cotizacion_valor`.`ValorU`\n, `cc_r_cotizacion_valor`.`PIva` \n, IF(`cc_r_cotizacion_valor`.`PIva`=0,`cc_r_cotizacion_valor`.`Iva`,((`cc_r_cotizacion_valor`.`ValorU` * `cc_r_requisicion_detalle`.`Cantidad`) * `cc_r_cotizacion_valor`.`PIva`)/100) AS Iva\n, IF(`cc_r_cotizacion_valor`.`PIva`=0,((`cc_r_cotizacion_valor`.`ValorU`+`cc_r_cotizacion_valor`.`Iva`)*(`cc_r_requisicion_detalle`.`Cantidad`)),((`cc_r_cotizacion_valor`.`ValorU` + ((`cc_r_cotizacion_valor`.`ValorU` * `cc_r_cotizacion_valor`.`PIva`)/100))*`cc_r_requisicion_detalle`.`Cantidad`)) AS total \nFROM `cc_r_cotizacion_valor` \nINNER JOIN `baseserver`.`cc_r_requisicion_detalle` ON (`cc_r_cotizacion_valor`.`Id_Suministro` = `cc_r_requisicion_detalle`.`Id`) \nWHERE (`cc_r_cotizacion_valor`.`Id_Cotizacion` ='" + this.xmodeloprov.getValueAt(this.JTProveedor.getSelectedRow(), 0) + "')";
            } else {
                sql = "SELECT `Id`, `Descripcion`, `Cantidad` FROM `cc_r_requisicion_detalle` WHERE (`Id_Requisicion` ='" + this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0) + "');";
            }
            ResultSet xrs = this.xconsulta.traerRs(sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelocot.addRow(this.xdatoscot);
                    this.xmodelocot.setValueAt(Long.valueOf(xrs.getLong(1)), n, 0);
                    this.xmodelocot.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelocot.setValueAt(Long.valueOf(xrs.getLong(3)), n, 2);
                    if (this.JTProveedor.getSelectedRow() != -1) {
                        this.xmodelocot.setValueAt(Double.valueOf(xrs.getDouble(4)), n, 3);
                        this.xmodelocot.setValueAt(Double.valueOf(xrs.getDouble(5)), n, 4);
                        this.xmodelocot.setValueAt(Double.valueOf(xrs.getDouble(6)), n, 5);
                        this.xmodelocot.setValueAt(Double.valueOf(xrs.getDouble(7)), n, 6);
                    } else {
                        this.xmodelocot.setValueAt(0, n, 3);
                        this.xmodelocot.setValueAt(0, n, 4);
                        this.xmodelocot.setValueAt(0, n, 5);
                        this.xmodelocot.setValueAt(0, n, 6);
                    }
                    n++;
                }
            }
            xrs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFCotizacion.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloCotizacion() {
        this.xmodeloprov = new DefaultTableModel(new Object[0], new String[]{"Id", "Fecha", "Código", "Proveedor", "Soporte", "Observacion"}) { // from class: ComprasBS.JIFCotizacion.13
            Class[] types = {Long.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTProveedor;
        JTable jTable2 = this.JTProveedor;
        jTable.setAutoResizeMode(0);
        this.JTProveedor.doLayout();
        this.JTProveedor.setModel(this.xmodeloprov);
        this.JTProveedor.getColumnModel().getColumn(0).setPreferredWidth(80);
        this.JTProveedor.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTProveedor.getColumnModel().getColumn(2).setPreferredWidth(50);
        this.JTProveedor.getColumnModel().getColumn(3).setPreferredWidth(300);
        this.JTProveedor.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTProveedor.getColumnModel().getColumn(5).setPreferredWidth(300);
    }

    private void mCargarDatosCotizacion() {
        try {
            mCrearModeloCotizacion();
            String sql = "SELECT `Id` ,date_format(`FechaCot`,'%Y-%m-%d')AS FechaCot,`NCotizacion`, `NProveedor`, `SoporteUrl`, IFNULL(ObservacionG,'') AS ObservacionG FROM `cc_r_cotizacion` WHERE (`Estado` =1 AND `Id_requisicion` ='" + Principal.txtNo.getText() + "')";
            ResultSet xrs = this.xconsulta.traerRs(sql);
            this.xmetodos.mEstablecerTextEditor(this.JTProveedor, 5);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodeloprov.addRow(this.xdatoscot);
                    this.xmodeloprov.setValueAt(Long.valueOf(xrs.getLong(1)), n, 0);
                    this.xmodeloprov.setValueAt(xrs.getString(2), n, 1);
                    this.xmodeloprov.setValueAt(xrs.getString(3), n, 2);
                    this.xmodeloprov.setValueAt(xrs.getString(4), n, 3);
                    this.xmodeloprov.setValueAt(xrs.getString(5), n, 4);
                    this.xmodeloprov.setValueAt(xrs.getString(6), n, 5);
                    n++;
                }
            }
            xrs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFCotizacion.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloComparacion() {
        this.xmodelocomp = new DefaultTableModel(new Object[0], new String[]{"Id", "Proveedor", "Subtotal", "Total IVA", "TOTAL", "Aprobado?", "Observacion"}) { // from class: ComprasBS.JIFCotizacion.14
            Class[] types = {Long.class, String.class, Double.class, Double.class, Double.class, Boolean.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTComparacion.setModel(this.xmodelocomp);
        this.JTComparacion.getColumnModel().getColumn(0).setPreferredWidth(3);
        this.JTComparacion.getColumnModel().getColumn(1).setPreferredWidth(250);
        this.JTComparacion.getColumnModel().getColumn(2).setPreferredWidth(15);
        this.JTComparacion.getColumnModel().getColumn(3).setPreferredWidth(15);
        this.JTComparacion.getColumnModel().getColumn(4).setPreferredWidth(15);
        this.JTComparacion.getColumnModel().getColumn(5).setPreferredWidth(15);
        this.JTComparacion.getColumnModel().getColumn(6).setPreferredWidth(0);
        this.JTComparacion.getColumnModel().getColumn(6).setMinWidth(0);
        this.JTComparacion.getColumnModel().getColumn(6).setMaxWidth(0);
    }

    private void mCargarDatosComparacion() {
        try {
            mCrearModeloComparacion();
            String sql = "SELECT `cc_r_cotizacion`.`Id`  , `cc_r_cotizacion`.`NProveedor`,SUM(`cc_r_cotizacion_valor`.`ValorU`*`cc_r_requisicion_detalle`.`Cantidad`) AS vunitario,SUM(`cc_r_cotizacion_valor`.`Iva`*`cc_r_requisicion_detalle`.`Cantidad`) AS vtiva,(SUM(`cc_r_cotizacion_valor`.`ValorU`*`cc_r_requisicion_detalle`.`Cantidad`)+ SUM(`cc_r_cotizacion_valor`.`Iva`*`cc_r_requisicion_detalle`.`Cantidad`)) AS total, cc_r_cotizacion.Aprobado, IFNULL(cc_r_cotizacion.Observacion,'') AS Observacion FROM `cc_r_cotizacion_valor`INNER JOIN `baseserver`.`cc_r_cotizacion` ON (`cc_r_cotizacion_valor`.`Id_Cotizacion` = `cc_r_cotizacion`.`Id`) INNER JOIN `baseserver`.`cc_r_requisicion_detalle` ON (`cc_r_cotizacion_valor`.`Id_Suministro` = `cc_r_requisicion_detalle`.`Id`) WHERE (`cc_r_cotizacion`.`Id_requisicion` ='" + Principal.txtNo.getText() + "') GROUP BY `cc_r_cotizacion`.`Id` ORDER BY total ASC;";
            ResultSet xrs = this.xconsulta.traerRs(sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelocomp.addRow(this.xdatoscot);
                    this.xmodelocomp.setValueAt(Long.valueOf(xrs.getLong(1)), n, 0);
                    this.xmodelocomp.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelocomp.setValueAt(Double.valueOf(xrs.getDouble(3)), n, 2);
                    this.xmodelocomp.setValueAt(Double.valueOf(xrs.getDouble(4)), n, 3);
                    this.xmodelocomp.setValueAt(Double.valueOf(xrs.getDouble(5)), n, 4);
                    this.xmodelocomp.setValueAt(Boolean.valueOf(xrs.getBoolean(6)), n, 5);
                    this.xmodelocomp.setValueAt(xrs.getString(7), n, 6);
                    n++;
                }
            }
            xrs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFCotizacion.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mBuscar() {
        mCargarDatosTabla();
    }
}
