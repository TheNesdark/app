package Contabilidad;

import Acceso.Principal;
import ComprasBS.JIFOrdenCompra;
import ComprasBS.JIFOrdenServicio;
import ComprasBS.JIFRequisicion;
import Presupuesto.JIFFSolicitudPTO;
import Presupuesto.JIFFSolicitudPTO_v2;
import Presupuesto.JIFFSolicitudPresupuestal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
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
import java.beans.PropertyVetoException;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
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
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

/* JADX INFO: loaded from: GenomaP.jar:Contabilidad/JIFConsultarDatosV.class */
public class JIFConsultarDatosV extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private Object[] xdato;
    private JIFSolicitudReembolsoCM xjifsolicitudr;
    private JIFGenerarCuentaCobroM xjifgenerarccm;
    private JIFDocContable xjifdoccontable;
    private JIFOrdenCompra xjifcomprasv;
    private JIFOrdenServicio xjifordenservicio;
    private JIFGenerarCertificadoI xjifgenerarcert;
    private JIFGenerarCuentaCobro xjifcuentacobroa;
    private JIFRequisicion xjifrequisicion;
    private JIFFSolicitudPTO xJIFFSolicitudPTO;
    private JIFFSolicitudPTO_v2 xJIFFSolicitudPTO_v2;
    private JIFFSolicitudPresupuestal jifsolicitud_new;
    private JIFSolicitudReembolsoCMV2 xIJFSolicitudReembolsov2;
    private JIFGenerarCuentaCobroMImpuestos cobroMImpuestos;
    private String xobjetollamador;
    private List<Long> idReembolso;
    private ButtonGroup JBGOpciones;
    private JButton JBTGenerar;
    private JCheckBox JCHFiltro;
    public JDateChooser JDFFechaF;
    public JDateChooser JDFFechaI;
    private JPanel JPIDatos;
    private JPanel JPI_Filtro;
    private JRadioButton JRBNinguno;
    private JRadioButton JRBTodos;
    private JScrollPane JSPDetalle1;
    private JFormattedTextField JTFF_VTotal;
    private JTextField JTFProveedor;
    private JTextField JTFRuta;
    public JTable JTResultado;
    private Metodos xmt = new Metodos();
    private ConsultasMySQL xconsultas = new ConsultasMySQL();
    private String xId = "";

    public JIFConsultarDatosV(JInternalFrame xjif) {
        initComponents();
        mNuevo();
        mRealizarCasting(xjif);
        mCargarDatos();
        xjif.getName();
    }

    /* JADX WARN: Type inference failed for: r3v35, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGOpciones = new ButtonGroup();
        this.JPIDatos = new JPanel();
        this.JCHFiltro = new JCheckBox();
        this.JDFFechaF = new JDateChooser();
        this.JDFFechaI = new JDateChooser();
        this.JTFProveedor = new JTextField();
        this.JSPDetalle1 = new JScrollPane();
        this.JTResultado = new JTable();
        this.JTFRuta = new JTextField();
        this.JBTGenerar = new JButton();
        this.JPI_Filtro = new JPanel();
        this.JRBTodos = new JRadioButton();
        this.JRBNinguno = new JRadioButton();
        this.JTFF_VTotal = new JFormattedTextField();
        setClosable(true);
        setIconifiable(true);
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jisbuscardatoscont");
        setRequestFocusEnabled(false);
        try {
            setSelected(true);
        } catch (PropertyVetoException e1) {
            e1.printStackTrace();
        }
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "CONSULTA DE DATOS", 0, 0, new Font("Arial", 1, 14), new Color(0, 102, 51)));
        this.JCHFiltro.setFont(new Font("Arial", 1, 12));
        this.JCHFiltro.setText("Filtro");
        this.JCHFiltro.addActionListener(new ActionListener() { // from class: Contabilidad.JIFConsultarDatosV.1
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarDatosV.this.JCHFiltroActionPerformed(evt);
            }
        });
        this.JDFFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFechaF.setDateFormatString("dd-MM-yyyy");
        this.JDFFechaF.setFont(new Font("Arial", 1, 12));
        this.JDFFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFechaI.setDateFormatString("dd-MM-yyyy");
        this.JDFFechaI.setFont(new Font("Arial", 1, 12));
        this.JTFProveedor.setFont(new Font("Arial", 1, 12));
        this.JTFProveedor.setBorder(BorderFactory.createTitledBorder((Border) null, "Tercero", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFProveedor.addKeyListener(new KeyAdapter() { // from class: Contabilidad.JIFConsultarDatosV.2
            public void keyPressed(KeyEvent evt) {
                JIFConsultarDatosV.this.JTFProveedorKeyPressed(evt);
            }
        });
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addComponent(this.JDFFechaI, -2, 121, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JDFFechaF, -2, 121, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFProveedor, -1, 468, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHFiltro).addContainerGap()));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.JCHFiltro).addGap(26, 26, 26)).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JDFFechaI, -2, 51, -2).addComponent(this.JDFFechaF, -2, 51, -2)).addContainerGap()).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosLayout.createSequentialGroup().addComponent(this.JTFProveedor, -2, 50, -2).addGap(12, 12, 12)))));
        this.JSPDetalle1.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTResultado.setBorder(BorderFactory.createBevelBorder(0));
        this.JTResultado.setFont(new Font("Arial", 1, 12));
        this.JTResultado.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTResultado.setEditingColumn(1);
        this.JTResultado.setEditingRow(1);
        this.JTResultado.setRowHeight(25);
        this.JTResultado.setSelectionBackground(new Color(255, 255, 255));
        this.JTResultado.setSelectionForeground(new Color(255, 0, 0));
        this.JTResultado.addMouseListener(new MouseAdapter() { // from class: Contabilidad.JIFConsultarDatosV.3
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarDatosV.this.JTResultadoMouseClicked(evt);
            }
        });
        this.JSPDetalle1.setViewportView(this.JTResultado);
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\\\Genoma\\\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ruta", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: Contabilidad.JIFConsultarDatosV.4
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarDatosV.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBTGenerar.setFont(new Font("Arial", 1, 12));
        this.JBTGenerar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTGenerar.setText("Exportar");
        this.JBTGenerar.addActionListener(new ActionListener() { // from class: Contabilidad.JIFConsultarDatosV.5
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarDatosV.this.JBTGenerarActionPerformed(evt);
            }
        });
        this.JPI_Filtro.setBorder(BorderFactory.createTitledBorder((Border) null, "Selección", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JBGOpciones.add(this.JRBTodos);
        this.JRBTodos.setFont(new Font("Arial", 1, 12));
        this.JRBTodos.setSelected(true);
        this.JRBTodos.setText("Todos");
        this.JRBTodos.addActionListener(new ActionListener() { // from class: Contabilidad.JIFConsultarDatosV.6
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarDatosV.this.JRBTodosActionPerformed(evt);
            }
        });
        this.JBGOpciones.add(this.JRBNinguno);
        this.JRBNinguno.setFont(new Font("Arial", 1, 12));
        this.JRBNinguno.setText("Ninguno");
        this.JRBNinguno.addActionListener(new ActionListener() { // from class: Contabilidad.JIFConsultarDatosV.7
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarDatosV.this.JRBNingunoActionPerformed(evt);
            }
        });
        GroupLayout JPI_FiltroLayout = new GroupLayout(this.JPI_Filtro);
        this.JPI_Filtro.setLayout(JPI_FiltroLayout);
        JPI_FiltroLayout.setHorizontalGroup(JPI_FiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_FiltroLayout.createSequentialGroup().addContainerGap().addComponent(this.JRBTodos).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 15, 32767).addComponent(this.JRBNinguno).addContainerGap()));
        JPI_FiltroLayout.setVerticalGroup(JPI_FiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_FiltroLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBTodos).addComponent(this.JRBNinguno)));
        this.JTFF_VTotal.setBorder(BorderFactory.createTitledBorder((Border) null, "Total", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JTFF_VTotal.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFF_VTotal.setHorizontalAlignment(4);
        this.JTFF_VTotal.setFont(new Font("Arial", 1, 12));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPDetalle1, -1, 813, 32767).addComponent(this.JPIDatos, -1, -1, 32767).addGroup(layout.createSequentialGroup().addComponent(this.JPI_Filtro, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFRuta, -2, 326, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBTGenerar, -2, 134, -2).addGap(31, 31, 31).addComponent(this.JTFF_VTotal))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPDetalle1, -2, 310, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBTGenerar, -2, 50, -2).addComponent(this.JTFRuta, -1, 50, 32767)).addGroup(layout.createSequentialGroup().addComponent(this.JPI_Filtro, -2, -1, -2).addGap(0, 0, 32767)).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.JTFF_VTotal, -2, 50, -2))).addContainerGap(-1, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTResultadoMouseClicked(MouseEvent evt) {
        if (this.JTResultado.getSelectedColumn() == 6) {
            mTotalizar();
            return;
        }
        if (evt.getClickCount() == 2) {
            if (this.JTResultado.getSelectedRow() != -1) {
                switch (this.xobjetollamador) {
                    case "jifsolicitudreembolso1":
                    case "jifsolicitudreembolso":
                    case "jifsolicitudreembolso2":
                        if (this.xobjetollamador.equals("jifsolicitudreembolso2")) {
                            try {
                                this.xIJFSolicitudReembolsov2.mBuscarDatos(this.xmodelo.getValueAt(this.JTResultado.getSelectedRow(), 0).toString());
                                this.xIJFSolicitudReembolsov2.setSelected(true);
                            } catch (PropertyVetoException e) {
                                Logger.getLogger(JIFConsultarDatosV.class.getName()).log(Level.SEVERE, (String) null, e);
                            }
                            break;
                        } else {
                            try {
                                this.xjifsolicitudr.mBuscarDatos(this.xmodelo.getValueAt(this.JTResultado.getSelectedRow(), 0).toString());
                                this.xjifsolicitudr.setSelected(true);
                            } catch (PropertyVetoException e2) {
                                Logger.getLogger(JIFConsultarDatosV.class.getName()).log(Level.SEVERE, (String) null, e2);
                            }
                            break;
                        }
                        break;
                    case "jifcuentacobrom":
                    case "jifcuentacobrom1":
                    case "jifcuentacobrom2":
                        try {
                            this.xjifgenerarccm.mBuscarDatos(this.xmodelo.getValueAt(this.JTResultado.getSelectedRow(), 0).toString());
                            this.xjifgenerarccm.setSelected(true);
                            break;
                        } catch (PropertyVetoException e3) {
                            Logger.getLogger(JIFConsultarDatosV.class.getName()).log(Level.SEVERE, (String) null, e3);
                            break;
                        }
                        break;
                    case "jifcuentacobromImpuestos":
                        try {
                            this.cobroMImpuestos.mBuscarDatos(this.xmodelo.getValueAt(this.JTResultado.getSelectedRow(), 0).toString());
                            this.cobroMImpuestos.setSelected(true);
                            break;
                        } catch (PropertyVetoException e4) {
                            Logger.getLogger(JIFConsultarDatosV.class.getName()).log(Level.SEVERE, (String) null, e4);
                            break;
                        }
                        break;
                    case "jifdocumentoc":
                        try {
                            llenarArregloId();
                            this.xjifdoccontable.mCargarDatosReembolsoCM(this.idReembolso);
                            this.xjifdoccontable.setSelected(true);
                            break;
                        } catch (PropertyVetoException e5) {
                            Logger.getLogger(JIFConsultarDatosV.class.getName()).log(Level.SEVERE, (String) null, e5);
                            break;
                        }
                        break;
                    case "jifcompras":
                    case "jifcompras1":
                    case "jifcompras2":
                        try {
                            this.xjifcomprasv.mCargarDatosOrden(Long.valueOf(this.xmodelo.getValueAt(this.JTResultado.getSelectedRow(), 0).toString()).longValue());
                            this.xjifcomprasv.setSelected(true);
                            break;
                        } catch (PropertyVetoException e6) {
                            Logger.getLogger(JIFConsultarDatosV.class.getName()).log(Level.SEVERE, (String) null, e6);
                            break;
                        }
                        break;
                    case "jifordenservicio":
                        try {
                            this.xjifordenservicio.mCargarDatosOrden(Long.valueOf(this.xmodelo.getValueAt(this.JTResultado.getSelectedRow(), 0).toString()).longValue());
                            this.xjifordenservicio.setSelected(true);
                            break;
                        } catch (PropertyVetoException e7) {
                            Logger.getLogger(JIFConsultarDatosV.class.getName()).log(Level.SEVERE, (String) null, e7);
                            break;
                        }
                        break;
                    case "jifgeneracioncertificadoman":
                        try {
                            this.xjifgenerarcert.mBuscarDatos(this.xmodelo.getValueAt(this.JTResultado.getSelectedRow(), 0).toString());
                            this.xjifgenerarcert.setSelected(true);
                            break;
                        } catch (PropertyVetoException e8) {
                            Logger.getLogger(JIFConsultarDatosV.class.getName()).log(Level.SEVERE, (String) null, e8);
                            break;
                        }
                        break;
                    case "jifcuentacobro":
                        try {
                            this.xjifcuentacobroa.mBuscarId(this.xmodelo.getValueAt(this.JTResultado.getSelectedRow(), 0).toString());
                            this.xjifcuentacobroa.setSelected(true);
                            break;
                        } catch (PropertyVetoException e9) {
                            Logger.getLogger(JIFConsultarDatosV.class.getName()).log(Level.SEVERE, (String) null, e9);
                            break;
                        }
                        break;
                    case "jifrequisicion":
                        try {
                            this.xjifrequisicion.mBuscarDatos(this.xmodelo.getValueAt(this.JTResultado.getSelectedRow(), 0).toString());
                            this.xjifrequisicion.setSelected(true);
                            break;
                        } catch (PropertyVetoException e10) {
                            Logger.getLogger(JIFConsultarDatosV.class.getName()).log(Level.SEVERE, (String) null, e10);
                            break;
                        }
                        break;
                    case "xjifSolicitudPTO":
                        try {
                            Principal.txtNo.setText(this.xmodelo.getValueAt(this.JTResultado.getSelectedRow(), 0).toString());
                            this.xJIFFSolicitudPTO.mConsultaSolicitud();
                            this.xJIFFSolicitudPTO.setSelected(true);
                            break;
                        } catch (PropertyVetoException e11) {
                            Logger.getLogger(JIFConsultarDatosV.class.getName()).log(Level.SEVERE, (String) null, e11);
                            break;
                        }
                        break;
                    case "xjifSolicitudPTOv2":
                        try {
                            Principal.txtNo.setText(this.xmodelo.getValueAt(this.JTResultado.getSelectedRow(), 0).toString());
                            this.xJIFFSolicitudPTO_v2.JLB_Registro.setText(this.xmodelo.getValueAt(this.JTResultado.getSelectedRow(), 0).toString());
                            this.xJIFFSolicitudPTO_v2.mConsultaSolicitud();
                            this.xJIFFSolicitudPTO_v2.setSelected(true);
                            break;
                        } catch (PropertyVetoException e12) {
                            Logger.getLogger(JIFConsultarDatosV.class.getName()).log(Level.SEVERE, (String) null, e12);
                            break;
                        }
                        break;
                    case "jifsolicitud_new":
                        try {
                            Principal.txtNo.setText(this.xmodelo.getValueAt(this.JTResultado.getSelectedRow(), 0).toString());
                            this.jifsolicitud_new.JLB_Registro.setText(this.xmodelo.getValueAt(this.JTResultado.getSelectedRow(), 0).toString());
                            this.jifsolicitud_new.mConsultaSolicitud();
                            this.jifsolicitud_new.setSelected(true);
                            break;
                        } catch (PropertyVetoException e13) {
                            Logger.getLogger(JIFConsultarDatosV.class.getName()).log(Level.SEVERE, (String) null, e13);
                            break;
                        }
                        break;
                }
            }
            dispose();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHFiltroActionPerformed(ActionEvent evt) {
        mCargarDatos();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFProveedorKeyPressed(KeyEvent evt) {
        if (!this.JTFProveedor.getText().isEmpty()) {
            mCargarDatos();
        }
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
    public void JBTGenerarActionPerformed(ActionEvent evt) {
        if (this.JTResultado.getRowCount() != -1) {
            int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar?", "CONFIRMACIÓN", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTResultado, this.JTFRuta.getText(), "CONSULTAR DATOS");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBTodosActionPerformed(ActionEvent evt) {
        mSeleccionar(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBNingunoActionPerformed(ActionEvent evt) {
        mSeleccionar(false);
    }

    private void mCrearTabla() {
        this.xmodelo = new DefaultTableModel((Object[][]) null, new String[]{"Id", "Fecha", "Observación", "Valor", "Estado", "NFactura", "S", "Tercero", "estadoDian", "responseDian"}) { // from class: Contabilidad.JIFConsultarDatosV.8
            Class[] types = {Long.class, String.class, String.class, Double.class, Boolean.class, String.class, Boolean.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, true, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return this.canEdit[colIndex];
            }
        };
        JTable jTable = this.JTResultado;
        JTable jTable2 = this.JTResultado;
        jTable.setAutoResizeMode(0);
        this.JTResultado.doLayout();
        this.JTResultado.setModel(this.xmodelo);
        this.JTResultado.getColumnModel().getColumn(0).setPreferredWidth(80);
        this.JTResultado.getColumnModel().getColumn(1).setPreferredWidth(80);
        this.JTResultado.getColumnModel().getColumn(2).setPreferredWidth(300);
        this.JTResultado.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTResultado.getColumnModel().getColumn(4).setPreferredWidth(0);
        this.JTResultado.getColumnModel().getColumn(4).setMinWidth(0);
        this.JTResultado.getColumnModel().getColumn(4).setMaxWidth(0);
        this.JTResultado.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTResultado.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTResultado.getColumnModel().getColumn(7).setPreferredWidth(200);
        this.JTResultado.getColumnModel().getColumn(8).setPreferredWidth(200);
        this.JTResultado.getColumnModel().getColumn(9).setPreferredWidth(200);
    }

    private void mCrearTabla1() {
        this.xmodelo = new DefaultTableModel((Object[][]) null, new String[]{"Id", "Fecha", "Observación", "Valor", "Estado", "NConsecutivo", "S"}) { // from class: Contabilidad.JIFConsultarDatosV.9
            Class[] types = {Long.class, String.class, String.class, Double.class, Boolean.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        this.JTResultado.setModel(this.xmodelo);
        this.JTResultado.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTResultado.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTResultado.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTResultado.getColumnModel().getColumn(1).setPreferredWidth(20);
        this.JTResultado.getColumnModel().getColumn(2).setPreferredWidth(200);
        this.JTResultado.getColumnModel().getColumn(3).setPreferredWidth(30);
        this.JTResultado.getColumnModel().getColumn(4).setPreferredWidth(0);
        this.JTResultado.getColumnModel().getColumn(4).setMinWidth(0);
        this.JTResultado.getColumnModel().getColumn(4).setMaxWidth(0);
        this.JTResultado.getColumnModel().getColumn(5).setPreferredWidth(30);
    }

    private void mCargarDatos() {
        String sql = null;
        if (this.JCHFiltro.isSelected()) {
            switch (this.xobjetollamador) {
                case "jifsolicitudreembolso1":
                    sql = "SELECT cc_solicitud_reembolso.Id, DATE_FORMAT(cc_solicitud_reembolso.FechaR,'%d-%m-%Y') as fecha, cc_solicitud_reembolso.Observacion, sum(cc_detalle_recibocm.Valor) AS Valor, cc_solicitud_reembolso.Estado,'' FROM cc_solicitud_reembolso INNER JOIN cc_recibocm  ON (cc_solicitud_reembolso.Id = cc_recibocm.Id_SolicitudR) INNER JOIN cc_terceros  ON (cc_recibocm.Id_Empresa = cc_terceros.Id) INNER JOIN cc_detalle_recibocm ON (cc_detalle_recibocm.Id_ReciboCm = cc_recibocm.Id) WHERE (cc_solicitud_reembolso.FechaR >='" + this.xmt.formatoAMD.format(this.JDFFechaI.getDate()) + "' AND cc_recibocm.Id_TipoCaja ='" + Principal.informacionGeneralPrincipalDTO.getIdCajaMenor() + "'AND cc_solicitud_reembolso.FechaR <='" + this.xmt.formatoAMD.format(this.JDFFechaF.getDate()) + "') GROUP BY cc_solicitud_reembolso.Id ";
                    break;
                case "jifcuentacobrom":
                case "jifcuentacobrom1":
                    sql = "SELECT cc_cuentacobro.Id, cc_cuentacobro.FechaC, cc_cuentacobro.Observacion, sum(cc_detalle_cuentacobrom.Valor) , cc_cuentacobro.Estado, IF( f_factura_evento.`No_FacturaEvento` IS NULL, 0,IF(  f_factura_evento.`No_FacturaEvento_M` <>0,  f_factura_evento.`No_FacturaEvento_M`, f_factura_evento.`No_FacturaEvento`) ) AS NFactura_Evento, cc_terceros.RazonSocialCompleta, f_factura_evento.responseMensaje, f_factura_evento.responseEstado FROM cc_detalle_cuentacobrom INNER JOIN cc_cuentacobro  ON (cc_detalle_cuentacobrom.Id_cuentacobro = cc_cuentacobro.Id) INNER JOIN cc_tipo_concepto_cuentacobro  ON (cc_detalle_cuentacobrom.Id_ConceptoCC = cc_tipo_concepto_cuentacobro.Id) INNER JOIN cc_terceros  ON (cc_cuentacobro.Id_Tercero = cc_terceros.Id) LEFT JOIN `f_factura_evento`  ON (f_factura_evento.`No_FacturaEvento`= `cc_cuentacobro`.`NFactura_Evento` ) WHERE (cc_cuentacobro.FechaC >='" + this.xmt.formatoAMD.format(this.JDFFechaI.getDate()) + "' AND cc_cuentacobro.FechaC <='" + this.xmt.formatoAMD.format(this.JDFFechaF.getDate()) + "') GROUP BY cc_cuentacobro.Id  ORDER BY cc_cuentacobro.Id DESC";
                    break;
                case "jifdocumentoc":
                    sql = "SELECT cc_solicitud_reembolso.Id, DATE_FORMAT(cc_solicitud_reembolso.FechaR,'%d-%m-%Y') as fecha, cc_solicitud_reembolso.Observacion, sum(cc_detalle_recibocm.Valor) AS Valor, cc_solicitud_reembolso.Estado,'' FROM cc_solicitud_reembolso INNER JOIN cc_recibocm  ON (cc_solicitud_reembolso.Id = cc_recibocm.Id_SolicitudR) INNER JOIN cc_terceros  ON (cc_recibocm.Id_Empresa = cc_terceros.Id) INNER JOIN cc_detalle_recibocm ON (cc_detalle_recibocm.Id_ReciboCm = cc_recibocm.Id) WHERE (cc_solicitud_reembolso.Id_DocContable=0 and cc_solicitud_reembolso.FechaR >='" + this.xmt.formatoAMD.format(this.JDFFechaI.getDate()) + "' AND cc_recibocm.Id_TipoCaja ='" + Principal.informacionGeneralPrincipalDTO.getIdCajaMenor() + "'AND cc_solicitud_reembolso.FechaR <='" + this.xmt.formatoAMD.format(this.JDFFechaF.getDate()) + "') GROUP BY cc_solicitud_reembolso.Id ";
                    break;
                case "jifcompras":
                case "jifcompras1":
                case "jifcompras2":
                    if (this.JTFProveedor.getText().isEmpty()) {
                        sql = "SELECT cc_orden_compra.Id, DATE_FORMAT(cc_orden_compra.FechaC,'%d-%m-%Y'), cc_terceros.`RazonSocialCompleta`,\nROUND(SUM((((cc_detalle_orden_compra.`Cantidad`*cc_detalle_orden_compra.`VUntiario`)*`cc_detalle_orden_compra`.`PIva`)/100)+(cc_detalle_orden_compra.`Cantidad`*cc_detalle_orden_compra.`VUntiario`))) Valor, cc_orden_compra.Estado,'' \nFROM  cc_orden_compra INNER JOIN`cc_terceros`  ON (cc_orden_compra.Id_Tercero = cc_terceros.Id) \nINNER JOIN cc_detalle_orden_compra  ON (cc_detalle_orden_compra.Id_OrdenC = cc_orden_compra.Id) where cc_orden_compra.FechaC>='" + this.xmt.formatoAMD.format(this.JDFFechaI.getDate()) + "' and  cc_orden_compra.FechaC<='" + this.xmt.formatoAMD.format(this.JDFFechaF.getDate()) + "'GROUP BY cc_orden_compra.Id ORDER BY cc_orden_compra.Id DESC ";
                        break;
                    } else {
                        sql = "SELECT cc_orden_compra.Id, DATE_FORMAT(cc_orden_compra.FechaC,'%d-%m-%Y'), cc_terceros.`RazonSocialCompleta`,\nROUND(SUM((((cc_detalle_orden_compra.`Cantidad`*cc_detalle_orden_compra.`VUntiario`)*`cc_detalle_orden_compra`.`PIva`)/100)+(cc_detalle_orden_compra.`Cantidad`*cc_detalle_orden_compra.`VUntiario`))) Valor, cc_orden_compra.Estado,'' \nFROM  cc_orden_compra INNER JOIN`cc_terceros`  ON (cc_orden_compra.Id_Tercero = cc_terceros.Id) \nINNER JOIN cc_detalle_orden_compra  ON (cc_detalle_orden_compra.Id_OrdenC = cc_orden_compra.Id) where cc_orden_compra.FechaC>='" + this.xmt.formatoAMD.format(this.JDFFechaI.getDate()) + "' and  cc_orden_compra.FechaC<='" + this.xmt.formatoAMD.format(this.JDFFechaF.getDate()) + "' and cc_terceros.RazonSocialCompleta like '" + this.JTFProveedor.getText() + "%' GROUP BY cc_orden_compra.Id ORDER BY cc_orden_compra.Id DESC ";
                        break;
                    }
                    break;
                case "jifordenservicio":
                    sql = "SELECT cc_orden_compra.Id , DATE_FORMAT(cc_orden_compra.FechaC,'%d-%m-%Y') AS Fecha , cc_terceros.RazonSocialCompleta AS NEmpresa ,(((cc_orden_compra.ValorP*cc_orden_compra.Iva)/100)+ cc_orden_compra.ValorP) AS Valor, cc_orden_compra.Estado,'' FROM cc_orden_compra INNER JOIN cc_terceros  ON (cc_orden_compra.Id_Tercero = cc_terceros.Id) WHERE ( cc_orden_compra.FechaC>='" + this.xmt.formatoAMD.format(this.JDFFechaI.getDate()) + "' and  cc_orden_compra.FechaC<='" + this.xmt.formatoAMD.format(this.JDFFechaF.getDate()) + "' cc_orden_compra.Id_TipoDocF =6) ";
                    break;
                case "jifgeneracioncertificadoman":
                    sql = "SELECT cc_certificado_impuestos.Id, DATE_FORMAT(cc_certificado_impuestos.FechaG, '%d-%m-%Y') AS FechaG, cc_tipo_impuesto.Nbre, 0, cc_certificado_impuestos.Estado, Id_Tercero   FROM cc_certificado_impuestos  INNER JOIN cc_tipo_impuesto  ON (cc_certificado_impuestos.Id_TipoImpuesto = cc_tipo_impuesto.Id) WHERE (Id_Tercero ='" + this.xjifgenerarcert.xidempresa[this.xjifgenerarcert.JCBTercero.getSelectedIndex()] + "' and FechaG >='" + this.xmt.formatoAMD.format(this.JDFFechaI.getDate()) + "' and  FechaG<='" + this.xmt.formatoAMD.format(this.JDFFechaF.getDate()) + "' AND cc_certificado_impuestos.Id_TipoImpuesto='" + this.xjifgenerarcert.xidtipoimpuesto[this.xjifgenerarcert.JCBTipoImpuesto.getSelectedIndex()] + "' ) ORDER BY FechaG DESC";
                    break;
                case "jifcuentacobro":
                case "jifcuentacobrom2":
                case "jifcuentacobromImpuestos":
                    sql = "SELECT cc_cuentacobro.Id, cc_cuentacobro.FechaC, cc_cuentacobro.Observacion, SUM(ROUND(Valor)), cc_cuentacobro.Estado, `cc_cuentacobro`.`NFactura_Evento`FROM cc_detalle_cuentacobro INNER JOIN cc_cuentacobro  ON (cc_detalle_cuentacobro.Id_cuentacobro = cc_cuentacobro.Id)   WHERE (cc_cuentacobro.FechaC >='" + this.xmt.formatoAMD.format(this.JDFFechaI.getDate()) + "' AND cc_cuentacobro.FechaC <='" + this.xmt.formatoAMD.format(this.JDFFechaF.getDate()) + "') GROUP BY cc_cuentacobro.Id ORDER BY cc_cuentacobro.FechaC DESC ";
                    break;
            }
        } else {
            switch (this.xobjetollamador) {
                case "jifsolicitudreembolso1":
                case "jifsolicitudreembolso":
                case "jifsolicitudreembolso2":
                    sql = "SELECT cc_solicitud_reembolso.Id, DATE_FORMAT(cc_solicitud_reembolso.FechaR,'%d-%m-%Y') as fecha, cc_solicitud_reembolso.Observacion, sum(cc_detalle_recibocm.Valor) AS Valor, cc_solicitud_reembolso.Estado,'',  cc_terceros.RazonSocialCompleta FROM cc_solicitud_reembolso INNER JOIN cc_recibocm  ON (cc_solicitud_reembolso.Id = cc_recibocm.Id_SolicitudR) INNER JOIN cc_terceros  ON (cc_recibocm.Id_Empresa = cc_terceros.Id) INNER JOIN cc_detalle_recibocm ON (cc_detalle_recibocm.Id_ReciboCm = cc_recibocm.Id) WHERE (cc_recibocm.Id_TipoCaja ='" + Principal.informacionGeneralPrincipalDTO.getIdCajaMenor() + "') GROUP BY cc_solicitud_reembolso.Id ";
                    break;
                case "jifcuentacobrom":
                case "jifcuentacobrom1":
                case "jifcuentacobrom2":
                case "jifcuentacobromImpuestos":
                    if (this.JTFProveedor.getText().isEmpty()) {
                        sql = "SELECT cc_cuentacobro.Id, cc_cuentacobro.FechaC, cc_cuentacobro.Observacion, sum(cc_detalle_cuentacobrom.Valor) , cc_cuentacobro.Estado, IF( f_factura_evento.`No_FacturaEvento` IS NULL, 0,IF(  f_factura_evento.`No_FacturaEvento_M` <>0,  f_factura_evento.`No_FacturaEvento_M`, f_factura_evento.`No_FacturaEvento`) ) AS NFactura_Evento, cc_terceros.RazonSocialCompleta, f_factura_evento.responseMensaje, f_factura_evento.responseEstado FROM cc_detalle_cuentacobrom INNER JOIN cc_cuentacobro  ON (cc_detalle_cuentacobrom.Id_cuentacobro = cc_cuentacobro.Id) INNER JOIN cc_tipo_concepto_cuentacobro  ON (cc_detalle_cuentacobrom.Id_ConceptoCC = cc_tipo_concepto_cuentacobro.Id) INNER JOIN cc_terceros  ON (cc_cuentacobro.Id_Tercero = cc_terceros.Id) left JOIN `f_factura_evento`  ON (f_factura_evento.`No_FacturaEvento`= `cc_cuentacobro`.`NFactura_Evento` )  GROUP BY cc_cuentacobro.Id  ORDER BY cc_cuentacobro.Id DESC ";
                        break;
                    } else {
                        sql = "SELECT cc_cuentacobro.Id, cc_cuentacobro.FechaC, cc_cuentacobro.Observacion, sum(cc_detalle_cuentacobrom.Valor) , cc_cuentacobro.Estado, IF( f_factura_evento.`No_FacturaEvento` IS NULL, 0,IF(  f_factura_evento.`No_FacturaEvento_M` <>0,  f_factura_evento.`No_FacturaEvento_M`, f_factura_evento.`No_FacturaEvento`) ) AS NFactura_Evento, cc_terceros.RazonSocialCompleta FROM cc_detalle_cuentacobrom INNER JOIN cc_cuentacobro  ON (cc_detalle_cuentacobrom.Id_cuentacobro = cc_cuentacobro.Id) INNER JOIN cc_tipo_concepto_cuentacobro  ON (cc_detalle_cuentacobrom.Id_ConceptoCC = cc_tipo_concepto_cuentacobro.Id) INNER JOIN cc_terceros  ON (cc_cuentacobro.Id_Tercero = cc_terceros.Id) left JOIN `f_factura_evento`  ON (f_factura_evento.`No_FacturaEvento`= `cc_cuentacobro`.`NFactura_Evento` )  where cc_terceros.RazonSocialCompleta like '" + this.JTFProveedor.getText() + "%' GROUP BY cc_cuentacobro.Id  ORDER BY cc_cuentacobro.Id DESC ";
                        break;
                    }
                    break;
                case "jifdocumentoc":
                    sql = "SELECT cc_solicitud_reembolso.Id, DATE_FORMAT(cc_solicitud_reembolso.FechaR,'%d-%m-%Y') as fecha, cc_solicitud_reembolso.Observacion, sum(cc_detalle_recibocm.Valor) AS Valor, cc_solicitud_reembolso.Estado,'' FROM cc_solicitud_reembolso INNER JOIN cc_recibocm  ON (cc_solicitud_reembolso.Id = cc_recibocm.Id_SolicitudR) INNER JOIN cc_terceros  ON (cc_recibocm.Id_Empresa = cc_terceros.Id) INNER JOIN cc_detalle_recibocm ON (cc_detalle_recibocm.Id_ReciboCm = cc_recibocm.Id) WHERE (cc_solicitud_reembolso.Id_DocContable=0 and cc_recibocm.Id_TipoCaja ='" + Principal.informacionGeneralPrincipalDTO.getIdCajaMenor() + "') GROUP BY cc_solicitud_reembolso.Id ";
                    break;
                case "jifcompras":
                case "jifcompras1":
                case "jifcompras2":
                    if (this.JTFProveedor.getText().isEmpty()) {
                        sql = "SELECT cc_orden_compra.Id, DATE_FORMAT(cc_orden_compra.FechaC,'%d-%m-%Y'), cc_terceros.RazonSocialCompleta, 0, cc_orden_compra.Estado,'' FROM  cc_orden_compra INNER JOIN cc_terceros  ON (cc_orden_compra.Id_Tercero = cc_terceros.Id) INNER JOIN cc_detalle_orden_compra  ON (cc_detalle_orden_compra.Id_OrdenC = cc_orden_compra.Id) GROUP BY cc_orden_compra.Id ORDER BY cc_orden_compra.Id DESC ";
                        break;
                    } else {
                        sql = "SELECT cc_orden_compra.Id, DATE_FORMAT(cc_orden_compra.FechaC,'%d-%m-%Y'), cc_terceros.RazonSocialCompleta, 0, cc_orden_compra.Estado,'' FROM  cc_orden_compra INNER JOIN cc_terceros  ON (cc_orden_compra.Id_Tercero = cc_terceros.Id) INNER JOIN cc_detalle_orden_compra  ON (cc_detalle_orden_compra.Id_OrdenC = cc_orden_compra.Id) where cc_terceros.RazonSocialCompleta like '" + this.JTFProveedor.getText() + "%' GROUP BY cc_orden_compra.Id ORDER BY cc_orden_compra.Id DESC ";
                        break;
                    }
                    break;
                case "jifordenservicio":
                    sql = "SELECT cc_orden_compra.Id , DATE_FORMAT(cc_orden_compra.FechaC,'%d-%m-%Y') AS Fecha , cc_terceros.RazonSocialCompleta AS NEmpresa ,(((cc_orden_compra.ValorP*cc_orden_compra.Iva)/100)+ cc_orden_compra.ValorP) AS Valor, cc_orden_compra.Estado,'' FROM cc_orden_compra INNER JOIN cc_terceros  ON (cc_orden_compra.Id_Tercero = cc_terceros.Id) WHERE (cc_orden_compra.Id_TipoDocF =6) ";
                    break;
                case "jifgeneracioncertificadoman":
                    sql = "SELECT cc_certificado_impuestos.Id, DATE_FORMAT(cc_certificado_impuestos.FechaG, '%d-%m-%Y') AS FechaG, cc_tipo_impuesto.Nbre, 0, cc_certificado_impuestos.Estado, Id_Tercero   FROM cc_certificado_impuestos  INNER JOIN cc_tipo_impuesto  ON (cc_certificado_impuestos.Id_TipoImpuesto = cc_tipo_impuesto.Id) WHERE (Id_Tercero ='" + this.xjifgenerarcert.xidempresa[this.xjifgenerarcert.JCBTercero.getSelectedIndex()] + "' AND cc_certificado_impuestos.Id_TipoImpuesto='" + this.xjifgenerarcert.xidtipoimpuesto[this.xjifgenerarcert.JCBTipoImpuesto.getSelectedIndex()] + "' ) ORDER BY FechaG DESC";
                    break;
                case "jifcuentacobro":
                    sql = "SELECT cc_cuentacobro.Id, cc_cuentacobro.FechaC, cc_cuentacobro.Observacion, SUM(ROUND(Valor)), cc_cuentacobro.Estado, `cc_cuentacobro`.`NFactura_Evento` FROM cc_detalle_cuentacobro INNER JOIN cc_cuentacobro  ON (cc_detalle_cuentacobro.Id_cuentacobro = cc_cuentacobro.Id) GROUP BY cc_cuentacobro.Id ORDER BY cc_cuentacobro.FechaC DESC ";
                    break;
                case "jifrequisicion":
                    sql = "SELECT  `Id`, `FechaR`, `ObservacionG` , `VPresupuestado` , `Estado`,NConsecutivo FROM `cc_r_requisicion` where Estado = 1 order by `Id` DESC, FechaR DESC ";
                    break;
                case "xjifSolicitudPTO":
                    sql = "SELECT  `Id`, `FechaR`, `ObservacionG` , `VPresupuestado` , `Estado`,NConsecutivo FROM `cc_r_requisicion` where Estado = 1 order by `Id` DESC, FechaR DESC ";
                    break;
                case "xjifSolicitudPTOv2":
                case "jifsolicitud_new":
                    sql = "SELECT  `Id`, `FechaR`,Descripcion ObservacionG , valor VPresupuestado , `Estado`,NConsecutivo \nFROM pp_solicitud_pto where Estado = 1 order by `Id` DESC, FechaR DESC ";
                    break;
            }
        }
        if (this.xobjetollamador.equals("xjifSolicitudPTO") || this.xobjetollamador.equals("jifrequisicion") || this.xobjetollamador.equals("xjifSolicitudPTOv2") || this.xobjetollamador.equals("jifsolicitud_new")) {
            mCrearTabla1();
        } else {
            mCrearTabla();
        }
        System.out.println(sql);
        ResultSet rs = this.xconsultas.traerRs(sql);
        try {
            if (rs.next()) {
                rs.beforeFirst();
                int x = 0;
                while (rs.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(Long.valueOf(rs.getLong(1)), x, 0);
                    this.xmodelo.setValueAt(rs.getString(2), x, 1);
                    this.xmodelo.setValueAt(rs.getString(3), x, 2);
                    this.xmodelo.setValueAt(Double.valueOf(rs.getDouble(4)), x, 3);
                    this.xmodelo.setValueAt(Boolean.valueOf(rs.getBoolean(5)), x, 4);
                    this.xmodelo.setValueAt(rs.getString(6), x, 5);
                    this.xmodelo.setValueAt(true, x, 6);
                    if (this.xobjetollamador.equals("jifcuentacobrom") || this.xobjetollamador.equals("jifcuentacobrom1") || this.xobjetollamador.equals("jifcuentacobrom2")) {
                        this.xmodelo.setValueAt(rs.getString("RazonSocialCompleta"), x, 7);
                        this.xmodelo.setValueAt(rs.getString("responseEstado"), x, 8);
                        this.xmodelo.setValueAt(rs.getString("responseMensaje"), x, 9);
                    }
                    x++;
                }
            }
            rs.close();
            this.xconsultas.cerrarConexionBd();
            mTotalizar();
        } catch (SQLException ex) {
            this.xconsultas.mostrarErrorSQL(ex);
        }
    }

    private void mTotalizar() {
        double xvalor = 0.0d;
        this.xId = "";
        if (this.JTResultado.getRowCount() != -1) {
            for (int x = 0; x < this.JTResultado.getRowCount(); x++) {
                if (Boolean.valueOf(this.xmodelo.getValueAt(x, 6).toString()).booleanValue()) {
                    xvalor += Double.valueOf(this.xmodelo.getValueAt(x, 3).toString()).doubleValue();
                    this.xId += "," + this.xmodelo.getValueAt(x, 0).toString();
                }
            }
        }
        this.JTFF_VTotal.setValue(Double.valueOf(xvalor));
    }

    private void mSeleccionar(boolean xEstado) {
        if (this.JTResultado.getRowCount() != -1) {
            for (int x = 0; x < this.JTResultado.getRowCount(); x++) {
                this.xmodelo.setValueAt(Boolean.valueOf(xEstado), x, 6);
            }
        }
        mTotalizar();
    }

    private void llenarArregloId() {
        this.idReembolso = new ArrayList();
        for (int x = 0; x < this.JTResultado.getRowCount(); x++) {
            if (Boolean.valueOf(this.JTResultado.getValueAt(x, 6).toString()).booleanValue()) {
                this.idReembolso.add(Long.valueOf(this.JTResultado.getValueAt(x, 0).toString()));
            }
        }
    }

    public void mNuevo() {
        this.JDFFechaI.setDate(this.xmt.getFechaActual());
        this.JDFFechaF.setDate(this.xmt.getFechaActual());
        this.JCHFiltro.setSelected(false);
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
    }

    private void mRealizarCasting(JInternalFrame frm) {
        switch (frm.getName()) {
            case "jifsolicitudreembolso1":
                this.xjifsolicitudr = (JIFSolicitudReembolsoCM) frm;
                this.xobjetollamador = "jifsolicitudreembolso1";
                break;
            case "jifcuentacobrom":
                this.xjifgenerarccm = (JIFGenerarCuentaCobroM) frm;
                this.xobjetollamador = "jifcuentacobrom";
                break;
            case "jifcuentacobrom2":
                this.xjifgenerarccm = (JIFGenerarCuentaCobroM) frm;
                this.xobjetollamador = "jifcuentacobrom2";
                break;
            case "jifcuentacobromImpuestos":
                this.cobroMImpuestos = (JIFGenerarCuentaCobroMImpuestos) frm;
                this.xobjetollamador = "jifcuentacobromImpuestos";
                break;
            case "jifcuentacobrom1":
                this.xjifgenerarccm = (JIFGenerarCuentaCobroM) frm;
                this.xobjetollamador = "jifcuentacobrom1";
                break;
            case "jifdocumentoc":
                this.xjifdoccontable = (JIFDocContable) frm;
                this.xobjetollamador = "jifdocumentoc";
                break;
            case "jifsolicitudreembolso":
                this.xjifsolicitudr = (JIFSolicitudReembolsoCM) frm;
                this.xobjetollamador = "jifsolicitudreembolso";
                break;
            case "jifcompras":
                this.xjifcomprasv = (JIFOrdenCompra) frm;
                this.xobjetollamador = "jifcompras";
                break;
            case "jifcompras1":
                this.xjifcomprasv = (JIFOrdenCompra) frm;
                this.xobjetollamador = "jifcompras1";
                break;
            case "jifcompras2":
                this.xjifcomprasv = (JIFOrdenCompra) frm;
                this.xobjetollamador = "jifcompras2";
                break;
            case "jifordenservicio":
                this.xjifordenservicio = (JIFOrdenServicio) frm;
                this.xobjetollamador = "jifordenservicio";
                break;
            case "jifgeneracioncertificadoman":
                this.xjifgenerarcert = (JIFGenerarCertificadoI) frm;
                this.xobjetollamador = "jifgeneracioncertificadoman";
                break;
            case "jifcuentacobro":
                this.xjifcuentacobroa = (JIFGenerarCuentaCobro) frm;
                this.xobjetollamador = "jifcuentacobro";
                break;
            case "jifrequisicion":
                this.xjifrequisicion = (JIFRequisicion) frm;
                this.xobjetollamador = "jifrequisicion";
                break;
            case "xjifSolicitudPTO":
                this.xJIFFSolicitudPTO = (JIFFSolicitudPTO) frm;
                this.xobjetollamador = "xjifSolicitudPTO";
                break;
            case "xjifSolicitudPTOv2":
                this.xJIFFSolicitudPTO_v2 = (JIFFSolicitudPTO_v2) frm;
                this.xobjetollamador = "xjifSolicitudPTOv2";
                break;
            case "jifSolicitudReembolso2":
                this.xIJFSolicitudReembolsov2 = (JIFSolicitudReembolsoCMV2) frm;
                this.xobjetollamador = "jifsolicitudreembolso2";
                break;
            case "jifsolicitud_new":
                this.jifsolicitud_new = (JIFFSolicitudPresupuestal) frm;
                this.xobjetollamador = "jifsolicitud_new";
                break;
        }
    }
}
