package Facturacion;

import Acceso.Principal;
import AutorizacionMP.JIFSubirRelacionC;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
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
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

/* JADX INFO: loaded from: GenomaP.jar:Facturacion/JIFSAutorizaciones.class */
public class JIFSAutorizaciones extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private DefaultTableModel xmodelo1;
    private Object[] xdato;
    private String xsql;
    private String[][] xidtipoempresa;
    private File xfile;
    private ButtonGroup JBGSoporte;
    private JButton JBTExportar;
    private JButton JBTExportar1;
    private JComboBox JCBEmpresa;
    private JCheckBox JCHSeleccion;
    private JDateChooser JDCFechaF;
    private JDateChooser JDCFechaI;
    private JPanel JPIDExportacion;
    private JPanel JPIDImportacion;
    private JPanel JPIDatos;
    private JScrollPane JSPDetalleProc;
    private JScrollPane JSPImportacion;
    private JTable JTDetalleProc;
    private JTextField JTFRuta;
    private JTextField JTFRuta1;
    private JTable JTImportacion;
    private JTabbedPane JTPDatos;
    private ConsultasMySQL xconsultas = new ConsultasMySQL();
    private Metodos xmt = new Metodos();
    private boolean xlleno = false;

    public JIFSAutorizaciones() {
        initComponents();
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v39, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v72, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGSoporte = new ButtonGroup();
        this.JTPDatos = new JTabbedPane();
        this.JPIDExportacion = new JPanel();
        this.JPIDatos = new JPanel();
        this.JDCFechaI = new JDateChooser();
        this.JDCFechaF = new JDateChooser();
        this.JCBEmpresa = new JComboBox();
        this.JCHSeleccion = new JCheckBox();
        this.JSPDetalleProc = new JScrollPane();
        this.JTDetalleProc = new JTable();
        this.JBTExportar = new JButton();
        this.JTFRuta1 = new JTextField();
        this.JPIDImportacion = new JPanel();
        this.JTFRuta = new JTextField();
        this.JSPImportacion = new JScrollPane();
        this.JTImportacion = new JTable();
        this.JBTExportar1 = new JButton();
        setClosable(true);
        setIconifiable(true);
        setTitle("SOLICITUD DE AUTORIZACIONES POR PROCEDIMIENTO");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjifsautorizaciones");
        this.JTPDatos.setForeground(new Color(0, 103, 0));
        this.JTPDatos.setFont(new Font("Arial", 1, 14));
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JDCFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDCFechaI.setFont(new Font("Arial", 1, 12));
        this.JDCFechaI.addPropertyChangeListener(new PropertyChangeListener() { // from class: Facturacion.JIFSAutorizaciones.1
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFSAutorizaciones.this.JDCFechaIPropertyChange(evt);
            }
        });
        this.JDCFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Fin", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDCFechaF.setFont(new Font("Arial", 1, 12));
        this.JDCFechaF.addPropertyChangeListener(new PropertyChangeListener() { // from class: Facturacion.JIFSAutorizaciones.2
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFSAutorizaciones.this.JDCFechaFPropertyChange(evt);
            }
        });
        this.JCBEmpresa.setFont(new Font("Arial", 1, 12));
        this.JCBEmpresa.setBorder(BorderFactory.createTitledBorder((Border) null, "Empresa", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHSeleccion.setFont(new Font("Arial", 1, 12));
        this.JCHSeleccion.setText("Por Autorizar");
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addComponent(this.JDCFechaI, -2, 124, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JDCFechaF, -2, 124, -2).addGap(18, 18, 18).addComponent(this.JCBEmpresa, -2, 562, -2).addGap(37, 37, 37).addComponent(this.JCHSeleccion).addContainerGap(-1, 32767)));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosLayout.createSequentialGroup().addGap(13, 13, 13).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JDCFechaI, -2, -1, -2).addComponent(this.JDCFechaF, -2, -1, -2)).addGap(19, 19, 19)).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBEmpresa, -2, -1, -2).addComponent(this.JCHSeleccion)).addContainerGap()));
        this.JSPDetalleProc.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE PLANTILLA", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTDetalleProc.setFont(new Font("Arial", 1, 12));
        this.JTDetalleProc.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalleProc.setRowHeight(25);
        this.JTDetalleProc.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalleProc.setSelectionForeground(Color.red);
        this.JTDetalleProc.setSelectionMode(0);
        this.JTDetalleProc.addMouseListener(new MouseAdapter() { // from class: Facturacion.JIFSAutorizaciones.3
            public void mouseClicked(MouseEvent evt) {
                JIFSAutorizaciones.this.JTDetalleProcMouseClicked(evt);
            }
        });
        this.JSPDetalleProc.setViewportView(this.JTDetalleProc);
        this.JBTExportar.setFont(new Font("Arial", 1, 14));
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: Facturacion.JIFSAutorizaciones.4
            public void actionPerformed(ActionEvent evt) {
                JIFSAutorizaciones.this.JBTExportarActionPerformed(evt);
            }
        });
        this.JTFRuta1.setFont(new Font("Arial", 1, 12));
        this.JTFRuta1.setText("C:\\plantilla");
        this.JTFRuta1.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta1.addMouseListener(new MouseAdapter() { // from class: Facturacion.JIFSAutorizaciones.5
            public void mouseClicked(MouseEvent evt) {
                JIFSAutorizaciones.this.JTFRuta1MouseClicked(evt);
            }
        });
        this.JTFRuta1.addActionListener(new ActionListener() { // from class: Facturacion.JIFSAutorizaciones.6
            public void actionPerformed(ActionEvent evt) {
                JIFSAutorizaciones.this.JTFRuta1ActionPerformed(evt);
            }
        });
        GroupLayout JPIDExportacionLayout = new GroupLayout(this.JPIDExportacion);
        this.JPIDExportacion.setLayout(JPIDExportacionLayout);
        JPIDExportacionLayout.setHorizontalGroup(JPIDExportacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDExportacionLayout.createSequentialGroup().addContainerGap().addGroup(JPIDExportacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPIDatos, -1, -1, 32767).addComponent(this.JSPDetalleProc, -1, 1048, 32767).addGroup(GroupLayout.Alignment.TRAILING, JPIDExportacionLayout.createSequentialGroup().addComponent(this.JTFRuta1, -1, 373, 32767).addGap(18, 18, 18).addComponent(this.JBTExportar, -2, 657, -2))).addContainerGap()));
        JPIDExportacionLayout.setVerticalGroup(JPIDExportacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDExportacionLayout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPDetalleProc, -2, 255, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 9, 32767).addGroup(JPIDExportacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JBTExportar, -2, 52, -2).addGroup(JPIDExportacionLayout.createSequentialGroup().addGap(4, 4, 4).addComponent(this.JTFRuta1))).addContainerGap()));
        this.JTPDatos.addTab("EXPORTACIÓN", this.JPIDExportacion);
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ruta", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: Facturacion.JIFSAutorizaciones.7
            public void mouseClicked(MouseEvent evt) {
                JIFSAutorizaciones.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JSPImportacion.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE ARCHIVO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTImportacion.setFont(new Font("Arial", 1, 12));
        this.JTImportacion.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTImportacion.setRowHeight(25);
        this.JTImportacion.setSelectionBackground(new Color(255, 255, 255));
        this.JTImportacion.setSelectionForeground(Color.red);
        this.JTImportacion.setSelectionMode(0);
        this.JTImportacion.addMouseListener(new MouseAdapter() { // from class: Facturacion.JIFSAutorizaciones.8
            public void mouseClicked(MouseEvent evt) {
                JIFSAutorizaciones.this.JTImportacionMouseClicked(evt);
            }
        });
        this.JSPImportacion.setViewportView(this.JTImportacion);
        this.JBTExportar1.setFont(new Font("Arial", 1, 14));
        this.JBTExportar1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTExportar1.setText("Actualizar");
        this.JBTExportar1.addActionListener(new ActionListener() { // from class: Facturacion.JIFSAutorizaciones.9
            public void actionPerformed(ActionEvent evt) {
                JIFSAutorizaciones.this.JBTExportar1ActionPerformed(evt);
            }
        });
        GroupLayout JPIDImportacionLayout = new GroupLayout(this.JPIDImportacion);
        this.JPIDImportacion.setLayout(JPIDImportacionLayout);
        JPIDImportacionLayout.setHorizontalGroup(JPIDImportacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDImportacionLayout.createSequentialGroup().addContainerGap().addGroup(JPIDImportacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPImportacion, -1, 1048, 32767).addComponent(this.JBTExportar1, -1, 1048, 32767).addComponent(this.JTFRuta, -2, 538, -2)).addContainerGap()));
        JPIDImportacionLayout.setVerticalGroup(JPIDImportacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDImportacionLayout.createSequentialGroup().addGap(20, 20, 20).addComponent(this.JTFRuta, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPImportacion, -2, 291, -2).addGap(18, 18, 18).addComponent(this.JBTExportar1, -2, 52, -2).addContainerGap(27, 32767)));
        this.JTPDatos.addTab("IMPORTACIÓN", this.JPIDImportacion);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addComponent(this.JTPDatos).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTPDatos, -2, 491, -2).addContainerGap(-1, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleProcMouseClicked(MouseEvent evt) {
        if (this.JTDetalleProc.getSelectedRow() != -1) {
            Principal.clasefacturacion.mImprmir_Factura_Codigos(this.xmodelo.getValueAt(this.JTDetalleProc.getSelectedRow(), 12).toString(), this.xmodelo.getValueAt(this.JTDetalleProc.getSelectedRow(), 13).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JFileChooser xfilec = new JFileChooser(this.JTFRuta.getText());
            int xv = xfilec.showOpenDialog(this);
            if (xv == 0) {
                this.xfile = xfilec.getSelectedFile();
                this.JTFRuta.setText(this.xfile.getAbsolutePath());
                this.JTFRuta.setText(this.xmt.mTraerUrlBD(this.xfile.getAbsolutePath()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTImportacionMouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTExportarActionPerformed(ActionEvent evt) {
        mExportarDatos();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDCFechaIPropertyChange(PropertyChangeEvent evt) {
        if (this.xlleno) {
            mLlenarComboEmpresa();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDCFechaFPropertyChange(PropertyChangeEvent evt) {
        if (this.xlleno) {
            mLlenarComboEmpresa();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRuta1MouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JFileChooser xfilec = new JFileChooser("C:\\");
            xfilec.setFileSelectionMode(1);
            int xv = xfilec.showOpenDialog(this);
            if (xv == 0) {
                File xfile = xfilec.getSelectedFile();
                this.JTFRuta1.setText(xfile.getAbsolutePath() + "\\");
                this.JTFRuta1.requestFocus();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRuta1ActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTExportar1ActionPerformed(ActionEvent evt) {
        if (this.JTImportacion.getRowCount() >= 0) {
            int xv = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de actualizar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (xv == 0) {
                for (int x = 0; x < this.JTImportacion.getRowCount(); x++) {
                    this.xsql = "update `f_itemordenesproced` set `NAutorizacion`='" + this.xmodelo1.getValueAt(x, 9) + "' where `Id_Ordenes`='" + this.xmodelo1.getValueAt(x, 10) + "' and `Id_Procedimiento`='" + this.xmodelo1.getValueAt(x, 5) + "'";
                    this.xconsultas.ejecutarSQL(this.xsql);
                    this.xconsultas.cerrarConexionBd();
                }
            }
        }
    }

    public void mGrabar() {
        if (this.JTDetalleProc.getRowCount() >= 0 && this.xmt.mVerificarDatosLLeno(this.JTDetalleProc, 10)) {
            int xv = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de actualizar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (xv == 0) {
                for (int x = 0; x < this.JTDetalleProc.getRowCount(); x++) {
                    this.xsql = "update `f_itemordenesproced` set `NAutorizacion`='" + this.xmodelo.getValueAt(x, 10) + "' where `Id_Ordenes`='" + this.xmodelo.getValueAt(x, 9) + "' and `Id_Procedimiento`='" + this.xmodelo.getValueAt(x, 15) + "'";
                    this.xconsultas.ejecutarSQL(this.xsql);
                    this.xconsultas.cerrarConexionBd();
                }
            }
        }
    }

    public void mNuevo() {
        this.JDCFechaI.setDate(this.xmt.getFechaActual());
        this.JDCFechaF.setDate(this.xmt.getFechaActual());
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
        mCrearTabla();
        mCrearTabla1();
        this.xlleno = true;
        mLlenarComboEmpresa();
    }

    private void mLlenarComboEmpresa() {
        this.xsql = "SELECT  `f_empresacontxconvenio`.`Id` , `f_empresacontxconvenio`.`Nbre`, `f_empresacontxconvenio`.EsCapitado FROM `f_itemordenesproced` INNER JOIN  `f_ordenes`   ON (`f_itemordenesproced`.`Id_Ordenes` = `f_ordenes`.`Id`) INNER JOIN  `ingreso`  ON (`f_ordenes`.`Id_Ingreso` = `ingreso`.`Id`) INNER JOIN  `f_empresacontxconvenio`   ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`) INNER JOIN  `f_liquidacion`  ON (`ingreso`.`Id` = `f_liquidacion`.`Id_Ingreso`)  WHERE (`f_ordenes`.`FechaOrden` >='" + this.xmt.formatoAMD1.format(this.JDCFechaI.getDate()) + "'  AND `f_ordenes`.`FechaOrden` <='" + this.xmt.formatoAMD1.format(this.JDCFechaF.getDate()) + "'  AND `f_ordenes`.`Estado` =0 AND `f_liquidacion`.`Estado`=0 AND `ingreso`.`Estado`=0 ) GROUP BY `f_empresacontxconvenio`.`Id` ORDER BY `f_empresacontxconvenio`.`Nbre` ASC ";
        this.JCBEmpresa.removeAllItems();
        this.xidtipoempresa = this.xconsultas.llenarComboyLista(this.xsql, this.xidtipoempresa, this.JCBEmpresa, 3);
        this.JCBEmpresa.setSelectedIndex(-1);
        this.xconsultas.cerrarConexionBd();
    }

    public void mBuscar() {
        if (this.JTPDatos.getSelectedIndex() == 0) {
            if (this.JCBEmpresa.getSelectedIndex() != -1) {
                mCargarDatosTabla();
                return;
            } else {
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una empresa", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JCBEmpresa.requestFocus();
                return;
            }
        }
        mCagarDArchivo();
    }

    public void mImprimir() {
    }

    private void mCrearTabla() {
        this.xmodelo = new DefaultTableModel((Object[][]) null, new String[]{"Fecha", "Documento", "Usuario", "Afiliación", "Nit", "Dx", "Cups", "NProcedimiento", "Cant.", "NOrden", "NAutorización", "Exportar?", "NFactura", "IdIngreso", "TipoDoc", "IdProc"}) { // from class: Facturacion.JIFSAutorizaciones.10
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Long.class, Long.class, String.class, Boolean.class, String.class, Long.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, true, true, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalleProc.setModel(this.xmodelo);
        this.JTDetalleProc.getColumnModel().getColumn(0).setPreferredWidth(20);
        this.JTDetalleProc.getColumnModel().getColumn(1).setPreferredWidth(20);
        this.JTDetalleProc.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTDetalleProc.getColumnModel().getColumn(3).setPreferredWidth(30);
        this.JTDetalleProc.getColumnModel().getColumn(4).setPreferredWidth(30);
        this.JTDetalleProc.getColumnModel().getColumn(5).setPreferredWidth(10);
        this.JTDetalleProc.getColumnModel().getColumn(6).setPreferredWidth(20);
        this.JTDetalleProc.getColumnModel().getColumn(7).setPreferredWidth(100);
        this.JTDetalleProc.getColumnModel().getColumn(8).setPreferredWidth(5);
        this.JTDetalleProc.getColumnModel().getColumn(9).setPreferredWidth(20);
        this.JTDetalleProc.getColumnModel().getColumn(10).setPreferredWidth(20);
        this.JTDetalleProc.getColumnModel().getColumn(11).setPreferredWidth(10);
        this.JTDetalleProc.getColumnModel().getColumn(12).setPreferredWidth(10);
        this.JTDetalleProc.getColumnModel().getColumn(13).setPreferredWidth(0);
        this.JTDetalleProc.getColumnModel().getColumn(13).setMinWidth(0);
        this.JTDetalleProc.getColumnModel().getColumn(13).setMaxWidth(0);
        this.JTDetalleProc.getColumnModel().getColumn(14).setPreferredWidth(0);
        this.JTDetalleProc.getColumnModel().getColumn(14).setMinWidth(0);
        this.JTDetalleProc.getColumnModel().getColumn(14).setMaxWidth(0);
        this.JTDetalleProc.getColumnModel().getColumn(15).setPreferredWidth(0);
        this.JTDetalleProc.getColumnModel().getColumn(15).setMinWidth(0);
        this.JTDetalleProc.getColumnModel().getColumn(15).setMaxWidth(0);
    }

    private void mCrearTabla1() {
        this.xmodelo1 = new DefaultTableModel((Object[][]) null, new String[]{"FECHA", "CARNET", "NIT_ORIGEN", "PROVEEDOR", "DIAGNÓSTICO", "PROCEDIMIENTO", "CANTIDAD", "IDUSUARIO", "CONSECUTIVO", "AUTORIZACION", "N/ORDEN", "N/FACTURA"}) { // from class: Facturacion.JIFSAutorizaciones.11
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, Long.class, String.class, String.class, String.class, Long.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTImportacion.setModel(this.xmodelo1);
        this.JTImportacion.getColumnModel().getColumn(0).setPreferredWidth(20);
        this.JTImportacion.getColumnModel().getColumn(1).setPreferredWidth(20);
        this.JTImportacion.getColumnModel().getColumn(2).setPreferredWidth(20);
        this.JTImportacion.getColumnModel().getColumn(3).setPreferredWidth(20);
        this.JTImportacion.getColumnModel().getColumn(4).setPreferredWidth(20);
        this.JTImportacion.getColumnModel().getColumn(5).setPreferredWidth(20);
        this.JTImportacion.getColumnModel().getColumn(6).setPreferredWidth(20);
        this.JTImportacion.getColumnModel().getColumn(7).setPreferredWidth(20);
        this.JTImportacion.getColumnModel().getColumn(8).setPreferredWidth(20);
        this.JTImportacion.getColumnModel().getColumn(9).setPreferredWidth(20);
        this.JTImportacion.getColumnModel().getColumn(10).setPreferredWidth(20);
        this.JTImportacion.getColumnModel().getColumn(11).setPreferredWidth(20);
    }

    private void mCargarDatosTabla() {
        mCrearTabla();
        if (this.JCHSeleccion.isSelected()) {
            this.xsql = "SELECT date_format(`f_ordenes`.`FechaOrden`,'%Y/%m/%d') as Fecha , `persona`.`NoDocumento`, `persona`.`NUsuario` , `persona`.`NAfiliacion` , `d_ips`.`NIEmpresa` , `ingreso`.`DxIngreso` , `f_tarifaprocedimiento`.`CodCUPS` , `g_procedimiento`.`Nbre` , `f_itemordenesproced`.`Cantidad` , `f_ordenes`.`Id` , `f_itemordenesproced`.`NAutorizacion`, `f_factura_capita`.`No_FacturaCapita`, `ingreso`.Id, `persona`.Id_TipoIdentificacion, `f_itemordenesproced`.Id_Procedimiento FROM `d_ips`,  `f_itemordenesproced` INNER JOIN `f_ordenes`  ON (`f_itemordenesproced`.`Id_Ordenes` = `f_ordenes`.`Id`) INNER JOIN  `ingreso`  ON (`f_ordenes`.`Id_Ingreso` = `ingreso`.`Id`) INNER JOIN  `g_procedimiento`  ON (`f_itemordenesproced`.`Id_Procedimiento` = `g_procedimiento`.`Id`) INNER JOIN  `persona` ON (`persona`.`Id_persona` = `ingreso`.`Id_Usuario`) INNER JOIN  `f_liquidacion`  ON (`ingreso`.`Id` = `f_liquidacion`.`Id_Ingreso`) INNER JOIN  `f_empresacontxconvenio`  ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`) INNER JOIN  `f_factura_capita`  ON (`f_factura_capita`.`Id_Liquidacion` = `f_liquidacion`.`Id`) INNER JOIN  `f_tarifaprocedimiento`  ON (`f_tarifaprocedimiento`.`Id_Procedimiento` = `g_procedimiento`.`Id`) AND (`f_empresacontxconvenio`.`Id_Manual` = `f_tarifaprocedimiento`.`Id_Manual`) WHERE (`f_itemordenesproced`.`NAutorizacion`= '' and `f_ordenes`.`FechaOrden` >='" + this.xmt.formatoAMD1.format(this.JDCFechaI.getDate()) + "' AND `f_ordenes`.`FechaOrden` <='" + this.xmt.formatoAMD1.format(this.JDCFechaF.getDate()) + "' AND `f_ordenes`.`Estado` =0 AND `ingreso`.`Estado` =0 AND `f_liquidacion`.`Estado` =0 AND `f_factura_capita`.`Estado` =0 AND `f_empresacontxconvenio`.`Id`='" + this.xidtipoempresa[this.JCBEmpresa.getSelectedIndex()][0] + "') ORDER BY `f_ordenes`.`FechaOrden` ASC, `f_factura_capita`.`No_FacturaCapita` ASC ";
        } else {
            this.xsql = "SELECT date_format(`f_ordenes`.`FechaOrden`,'%Y/%m/%d') as Fecha , `persona`.`NoDocumento`, `persona`.`NUsuario` , `persona`.`NAfiliacion` , `d_ips`.`NIEmpresa` , `ingreso`.`DxIngreso` , `f_tarifaprocedimiento`.`CodCUPS` , `g_procedimiento`.`Nbre` , `f_itemordenesproced`.`Cantidad` , `f_ordenes`.`Id` , `f_itemordenesproced`.`NAutorizacion`, `f_factura_capita`.`No_FacturaCapita`, `ingreso`.Id, `persona`.Id_TipoIdentificacion, `f_itemordenesproced`.Id_Procedimiento FROM `d_ips`,  `f_itemordenesproced` INNER JOIN `f_ordenes`  ON (`f_itemordenesproced`.`Id_Ordenes` = `f_ordenes`.`Id`) INNER JOIN  `ingreso`  ON (`f_ordenes`.`Id_Ingreso` = `ingreso`.`Id`) INNER JOIN  `g_procedimiento`  ON (`f_itemordenesproced`.`Id_Procedimiento` = `g_procedimiento`.`Id`) INNER JOIN  `persona` ON (`persona`.`Id_persona` = `ingreso`.`Id_Usuario`) INNER JOIN  `f_liquidacion`  ON (`ingreso`.`Id` = `f_liquidacion`.`Id_Ingreso`) INNER JOIN  `f_empresacontxconvenio`  ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`) INNER JOIN  `f_factura_capita`  ON (`f_factura_capita`.`Id_Liquidacion` = `f_liquidacion`.`Id`) INNER JOIN  `f_tarifaprocedimiento`  ON (`f_tarifaprocedimiento`.`Id_Procedimiento` = `g_procedimiento`.`Id`) AND (`f_empresacontxconvenio`.`Id_Manual` = `f_tarifaprocedimiento`.`Id_Manual`) WHERE (`f_ordenes`.`FechaOrden` >='" + this.xmt.formatoAMD1.format(this.JDCFechaI.getDate()) + "' AND `f_ordenes`.`FechaOrden` <='" + this.xmt.formatoAMD1.format(this.JDCFechaF.getDate()) + "' AND `f_ordenes`.`Estado` =0 AND `ingreso`.`Estado` =0 AND `f_liquidacion`.`Estado` =0 AND `f_factura_capita`.`Estado` =0 AND `f_empresacontxconvenio`.`Id`='" + this.xidtipoempresa[this.JCBEmpresa.getSelectedIndex()][0] + "') ORDER BY `f_ordenes`.`FechaOrden` ASC, `f_factura_capita`.`No_FacturaCapita` ASC ";
        }
        ResultSet rs = this.xconsultas.traerRs(this.xsql);
        try {
            if (rs.next()) {
                rs.beforeFirst();
                int x = 0;
                while (rs.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(rs.getString(1), x, 0);
                    this.xmodelo.setValueAt(rs.getString(2), x, 1);
                    this.xmodelo.setValueAt(rs.getString(3), x, 2);
                    this.xmodelo.setValueAt(rs.getString(4), x, 3);
                    this.xmodelo.setValueAt(rs.getString(5), x, 4);
                    this.xmodelo.setValueAt(rs.getString(6), x, 5);
                    this.xmodelo.setValueAt(rs.getString(7), x, 6);
                    this.xmodelo.setValueAt(rs.getString(8), x, 7);
                    this.xmodelo.setValueAt(Long.valueOf(rs.getLong(9)), x, 8);
                    this.xmodelo.setValueAt(Long.valueOf(rs.getLong(10)), x, 9);
                    this.xmodelo.setValueAt(rs.getString(11), x, 10);
                    this.xmodelo.setValueAt(rs.getString(12), x, 12);
                    this.xmodelo.setValueAt(rs.getString(13), x, 13);
                    this.xmodelo.setValueAt(rs.getString(14), x, 14);
                    this.xmodelo.setValueAt(rs.getString(15), x, 15);
                    if (rs.getString(11).equals("")) {
                        this.xmodelo.setValueAt(true, x, 11);
                    } else {
                        this.xmodelo.setValueAt(false, x, 11);
                    }
                    this.JTDetalleProc.setDefaultRenderer(Object.class, new MiRender());
                    x++;
                }
            }
            rs.close();
            this.xconsultas.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFSubirRelacionC.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX INFO: loaded from: GenomaP.jar:Facturacion/JIFSAutorizaciones$MiRender.class */
    public static class MiRender extends DefaultTableCellRenderer {
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (!table.getValueAt(row, 10).toString().equals("")) {
                cell.setBackground(new Color(177, 251, 177));
            } else {
                cell.setBackground(Color.WHITE);
            }
            return cell;
        }
    }

    private void mCagarDArchivo() {
        try {
            mCrearTabla1();
            Workbook xac = Workbook.getWorkbook(new File(this.JTFRuta.getText()));
            Sheet sheet = xac.getSheet(0);
            int y = 1;
            for (int x = 0; x < xac.getSheet(0).getRows() - 1; x++) {
                this.xmodelo1.addRow(this.xdato);
                this.xmodelo1.setValueAt(sheet.getCell(0, y).getContents(), x, 0);
                this.xmodelo1.setValueAt(sheet.getCell(1, y).getContents(), x, 1);
                this.xmodelo1.setValueAt(sheet.getCell(2, y).getContents(), x, 2);
                this.xmodelo1.setValueAt(sheet.getCell(3, y).getContents(), x, 3);
                this.xmodelo1.setValueAt(sheet.getCell(4, y).getContents(), x, 4);
                this.xmodelo1.setValueAt(sheet.getCell(5, y).getContents(), x, 5);
                this.xmodelo1.setValueAt(Long.valueOf(sheet.getCell(6, y).getContents()), x, 6);
                this.xmodelo1.setValueAt(sheet.getCell(7, y).getContents(), x, 7);
                this.xmodelo1.setValueAt(sheet.getCell(8, y).getContents(), x, 8);
                this.xmodelo1.setValueAt(sheet.getCell(9, y).getContents(), x, 9);
                this.xmodelo1.setValueAt(Long.valueOf(sheet.getCell(10, y).getContents()), x, 10);
                y++;
            }
            xac.close();
        } catch (IOException ex) {
            Logger.getLogger(JIFSubirRelacionC.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        } catch (BiffException e) {
            Logger.getLogger(JIFSubirRelacionC.class.getName()).log(Level.SEVERE, (String) null, e);
        }
    }

    private void mExportarDatos() {
        if (this.JTDetalleProc.getRowCount() > 0) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                try {
                    WritableWorkbook workbook = Workbook.createWorkbook(new File(this.JTFRuta1.getText() + ".xls"));
                    WritableSheet sheet = workbook.createSheet("plantilla", 0);
                    sheet.addCell(new Label(0, 0, "FECHA"));
                    sheet.addCell(new Label(1, 0, "CARNET"));
                    sheet.addCell(new Label(2, 0, "NIT_ORIGEN"));
                    sheet.addCell(new Label(3, 0, "PROVEEDOR"));
                    sheet.addCell(new Label(4, 0, "DIAGNÓSTICO"));
                    sheet.addCell(new Label(5, 0, "PROCEDIMIENTO"));
                    sheet.addCell(new Label(6, 0, "CANTIDAD"));
                    sheet.addCell(new Label(7, 0, "IDUSUARIO"));
                    sheet.addCell(new Label(8, 0, "CONSECUTIVO"));
                    sheet.addCell(new Label(9, 0, "AUTORIZACION"));
                    sheet.addCell(new Label(10, 0, "N/ORDEN"));
                    sheet.addCell(new Label(11, 0, "N/FACTURA"));
                    sheet.addCell(new Label(12, 0, "TipoDoc"));
                    sheet.addCell(new Label(13, 0, "N° DOC"));
                    sheet.addCell(new Label(14, 0, "NUsuario"));
                    int y = 1;
                    for (int x = 0; x < this.JTDetalleProc.getRowCount(); x++) {
                        sheet.addCell(new Label(0, y, this.xmodelo.getValueAt(x, 0).toString()));
                        sheet.addCell(new Label(1, y, this.xmodelo.getValueAt(x, 3).toString()));
                        sheet.addCell(new Label(2, y, this.xmodelo.getValueAt(x, 4).toString()));
                        sheet.addCell(new Label(3, y, this.xmodelo.getValueAt(x, 4).toString()));
                        sheet.addCell(new Label(4, y, this.xmodelo.getValueAt(x, 5).toString()));
                        sheet.addCell(new Label(5, y, this.xmodelo.getValueAt(x, 6).toString()));
                        sheet.addCell(new Number(6, y, Integer.valueOf(this.xmodelo.getValueAt(x, 8).toString()).intValue()));
                        sheet.addCell(new Label(7, y, ""));
                        sheet.addCell(new Label(8, y, ""));
                        sheet.addCell(new Label(9, y, ""));
                        sheet.addCell(new Number(10, y, Integer.valueOf(this.xmodelo.getValueAt(x, 9).toString()).intValue()));
                        sheet.addCell(new Number(11, y, Integer.valueOf(this.xmodelo.getValueAt(x, 12).toString()).intValue()));
                        sheet.addCell(new Label(12, y, this.xmodelo.getValueAt(x, 14).toString()));
                        sheet.addCell(new Label(13, y, this.xmodelo.getValueAt(x, 1).toString()));
                        sheet.addCell(new Label(14, y, this.xmodelo.getValueAt(x, 2).toString()));
                        y++;
                    }
                    workbook.write();
                    workbook.close();
                } catch (IOException ex) {
                    Logger.getLogger(JIFSAutorizaciones.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                } catch (WriteException e) {
                    Logger.getLogger(JIFSAutorizaciones.class.getName()).log(Level.SEVERE, (String) null, e);
                }
            }
        }
    }
}
