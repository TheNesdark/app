package Inventarios;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

/* JADX INFO: loaded from: GenomaP.jar:Inventarios/JIFCierresContables.class */
public class JIFCierresContables extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private Object[] xdatos;
    private String[] xidbodega;
    private String[] xidperiodo;
    private String[] xidperiodoc;
    private String[] xidtipodocumentoc;
    private String xsql;
    private ButtonGroup JBGSeleccion;
    private JButton JBTExportar;
    private JComboBox JCBBodega;
    private JComboBox JCBPeriodo;
    private JComboBox JCBPeriodoC;
    private JComboBox JCBTipoDocumentoC;
    private JDateChooser JDFecha;
    private JDateChooser JDFechaF;
    private JDateChooser JDFechaI;
    private JLabel JLB_DocumentoC;
    private JPanel JPITipoMovi;
    private JRadioButton JRBEntrada;
    private JRadioButton JRBSalida;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;
    private JFormattedTextField JTFF_Total;
    private JTextField JTFRuta;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private ConsultasMySQL xconsulta = new ConsultasMySQL();
    private Metodos xmetodos = new Metodos();
    private boolean xlleno = false;

    public JIFCierresContables() {
        initComponents();
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v8, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGSeleccion = new ButtonGroup();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.jPanel1 = new JPanel();
        this.JCBPeriodo = new JComboBox();
        this.JCBBodega = new JComboBox();
        this.JPITipoMovi = new JPanel();
        this.JRBEntrada = new JRadioButton();
        this.JRBSalida = new JRadioButton();
        this.JDFechaI = new JDateChooser();
        this.JDFechaF = new JDateChooser();
        this.JLB_DocumentoC = new JLabel();
        this.jPanel2 = new JPanel();
        this.JDFecha = new JDateChooser();
        this.JCBTipoDocumentoC = new JComboBox();
        this.JCBPeriodoC = new JComboBox();
        this.JTFF_Total = new JFormattedTextField();
        this.JTFRuta = new JTextField();
        this.JBTExportar = new JButton();
        setClosable(true);
        setIconifiable(true);
        setTitle("CIERRES CONTABLES");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setMaximumSize(null);
        setMinimumSize(null);
        setName("jifcierrescontables");
        setNormalBounds(null);
        setPreferredSize(new Dimension(737, 588));
        addInternalFrameListener(new InternalFrameListener() { // from class: Inventarios.JIFCierresContables.1
            public void internalFrameOpened(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                JIFCierresContables.this.formInternalFrameClosing(evt);
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
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE CONCEPTOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalle.setSelectionMode(0);
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JCBPeriodo.setFont(new Font("Arial", 1, 12));
        this.JCBPeriodo.setBorder(BorderFactory.createTitledBorder((Border) null, "Periodo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBPeriodo.addActionListener(new ActionListener() { // from class: Inventarios.JIFCierresContables.2
            public void actionPerformed(ActionEvent evt) {
                JIFCierresContables.this.JCBPeriodoActionPerformed(evt);
            }
        });
        this.JCBBodega.setFont(new Font("Arial", 1, 12));
        this.JCBBodega.setBorder(BorderFactory.createTitledBorder((Border) null, "Bodega", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JPITipoMovi.setBorder(BorderFactory.createTitledBorder((Border) null, "Movimiento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBGSeleccion.add(this.JRBEntrada);
        this.JRBEntrada.setFont(new Font("Arial", 1, 12));
        this.JRBEntrada.setText("Entrada");
        this.JBGSeleccion.add(this.JRBSalida);
        this.JRBSalida.setFont(new Font("Arial", 1, 12));
        this.JRBSalida.setSelected(true);
        this.JRBSalida.setText("Salida");
        GroupLayout JPITipoMoviLayout = new GroupLayout(this.JPITipoMovi);
        this.JPITipoMovi.setLayout(JPITipoMoviLayout);
        JPITipoMoviLayout.setHorizontalGroup(JPITipoMoviLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPITipoMoviLayout.createSequentialGroup().addContainerGap().addComponent(this.JRBEntrada).addGap(18, 18, 18).addComponent(this.JRBSalida).addContainerGap(-1, 32767)));
        JPITipoMoviLayout.setVerticalGroup(JPITipoMoviLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPITipoMoviLayout.createSequentialGroup().addGroup(JPITipoMoviLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBEntrada).addComponent(this.JRBSalida)).addContainerGap(-1, 32767)));
        this.JDFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFechaI.setFont(new Font("Arial", 1, 12));
        this.JDFechaI.addPropertyChangeListener(new PropertyChangeListener() { // from class: Inventarios.JIFCierresContables.3
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFCierresContables.this.JDFechaIPropertyChange(evt);
            }
        });
        this.JDFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Final", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFechaF.setFont(new Font("Arial", 1, 12));
        this.JDFechaF.addPropertyChangeListener(new PropertyChangeListener() { // from class: Inventarios.JIFCierresContables.4
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFCierresContables.this.JDFechaFPropertyChange(evt);
            }
        });
        this.JLB_DocumentoC.setFont(new Font("Arial", 1, 12));
        this.JLB_DocumentoC.setHorizontalAlignment(0);
        this.JLB_DocumentoC.setBorder(BorderFactory.createTitledBorder((Border) null, "No. Documento", 2, 0, new Font("Arial", 1, 12), Color.red));
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JCBPeriodo, -2, 296, -2).addGap(18, 18, 18).addComponent(this.JCBBodega, 0, -1, 32767)).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JPITipoMovi, -2, -1, -2).addGap(26, 26, 26).addComponent(this.JDFechaI, -2, 150, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JDFechaF, -2, 150, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 59, 32767).addComponent(this.JLB_DocumentoC, -2, 141, -2))).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JDFechaI, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addComponent(this.JDFechaF, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addComponent(this.JPITipoMovi, -2, 50, -2).addComponent(this.JLB_DocumentoC, GroupLayout.Alignment.TRAILING, -1, -1, 32767)).addGap(15, 15, 15).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JCBPeriodo, -2, 50, -2).addGap(0, 0, 32767)).addComponent(this.JCBBodega)).addContainerGap()));
        this.jPanel2.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN CONTABLE", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JDFecha.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFecha.setDateFormatString("dd/MM/yyyy");
        this.JDFecha.setFont(new Font("Arial", 1, 12));
        this.JCBTipoDocumentoC.setFont(new Font("Arial", 1, 12));
        this.JCBTipoDocumentoC.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo de Documento Contable", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTipoDocumentoC.addActionListener(new ActionListener() { // from class: Inventarios.JIFCierresContables.5
            public void actionPerformed(ActionEvent evt) {
                JIFCierresContables.this.JCBTipoDocumentoCActionPerformed(evt);
            }
        });
        this.JCBPeriodoC.setFont(new Font("Arial", 1, 12));
        this.JCBPeriodoC.setBorder(BorderFactory.createTitledBorder((Border) null, "Periodo Contable", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(this.JDFecha, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBTipoDocumentoC, 0, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBPeriodoC, -2, 229, -2).addContainerGap()));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBTipoDocumentoC, -2, 50, -2).addComponent(this.JCBPeriodoC, -2, 50, -2)).addComponent(this.JDFecha, -2, 50, -2)).addContainerGap(-1, 32767)));
        this.JTFF_Total.setBorder(BorderFactory.createTitledBorder((Border) null, "TOTAL", 0, 0, new Font("Arial", 1, 14), Color.red));
        this.JTFF_Total.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFF_Total.setHorizontalAlignment(4);
        this.JTFF_Total.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ruta (Directorio)", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: Inventarios.JIFCierresContables.6
            public void mouseClicked(MouseEvent evt) {
                JIFCierresContables.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar a Excel");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: Inventarios.JIFCierresContables.7
            public void actionPerformed(ActionEvent evt) {
                JIFCierresContables.this.JBTExportarActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPDetalle).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.JTFRuta, -2, 232, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTExportar, -2, 198, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JTFF_Total, -2, 157, -2)).addComponent(this.jPanel2, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addComponent(this.jPanel1, -1, -1, 32767)).addGap(17, 17, 17)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.jPanel1, -2, -1, -2).addGap(18, 18, 18).addComponent(this.jPanel2, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalle, -2, 215, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JBTExportar, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.JTFRuta, -1, 50, 32767).addComponent(this.JTFF_Total)).addContainerGap(17, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosing(InternalFrameEvent evt) {
        Principal.mLimpiarDatosP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBTipoDocumentoCActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBPeriodoActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JFileChooser xfilec = new JFileChooser(this.JTFRuta.getText());
            xfilec.setFileSelectionMode(1);
            int xv = xfilec.showOpenDialog(this);
            if (xv == 0) {
                File xfile = xfilec.getSelectedFile();
                this.JTFRuta.setText(xfile.getAbsolutePath() + this.xmetodos.getBarra());
                this.JTFRuta.requestFocus();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTExportarActionPerformed(ActionEvent evt) {
        if (!this.JTFRuta.getText().isEmpty()) {
            if (this.JTDetalle.getRowCount() > 0) {
                if (JOptionPane.showConfirmDialog((Component) null, "Esta seguro de exportar la infomación? ", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png")))) == 0) {
                    this.xmetodos.mExportar_Datos_Tabla_Titulo_Formato(this.JTDetalle, this.JTFRuta.getText(), getTitle() + " - Documento No." + this.JLB_DocumentoC.getText());
                    return;
                }
                return;
            }
            JOptionPane.showMessageDialog((Component) null, "No existe información para exportar", "VERIFICAR", 2, new ImageIcon("src/Imagenes/Warning.png"));
            return;
        }
        JOptionPane.showMessageDialog((Component) null, "Seleccionar Ruta Válida", "VERIFICAR", 2, new ImageIcon("src/Imagenes/Warning.png"));
        this.JTFRuta.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaIPropertyChange(PropertyChangeEvent evt) {
        if (this.xlleno) {
            mLlenarComboBodega();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaFPropertyChange(PropertyChangeEvent evt) {
        if (this.xlleno) {
            mLlenarComboBodega();
            this.JDFecha.setDate(this.JDFechaF.getDate());
        }
    }

    public void mBuscar() {
        if (this.JCBPeriodo.getSelectedIndex() != -1) {
            if (this.JCBBodega.getSelectedIndex() != -1) {
                String sql = null;
                if (this.JRBSalida.isSelected()) {
                    sql = "SELECT i_tiposmovimientos.Nbre, round(sum((i_detallesalida.CantidadDespachada*i_detallesalida.ValorUnitario))) AS ValorConsolidado, ifnull(cc_puc_1.Id,'') as CPuc_Debito, ifnull(cc_puc.Id,'') as CPuc_Credito   FROM i_salidas INNER JOIN i_tiposmovimientos ON (i_salidas.IdTipoMovimiento = i_tiposmovimientos.Id) INNER JOIN i_detallesalida  ON (i_detallesalida.IdSalida = i_salidas.Id)  left join cc_puc on (cc_puc.Id = i_tiposmovimientos.CPuc_Credito) left join cc_puc cc_puc_1 on (cc_puc_1.Id = i_tiposmovimientos.CPuc_Debito) WHERE (i_salidas.IdBodega ='" + this.xidbodega[this.JCBBodega.getSelectedIndex()] + "' AND i_salidas.Id_Periodo ='" + this.xidperiodo[this.JCBPeriodo.getSelectedIndex()] + "' AND i_salidas.Estado =0  AND i_tiposmovimientos.CPuc_Debito <>'' AND i_salidas.FechaSalida >='" + this.xmetodos.formatoAMD.format(this.JDFechaI.getDate()) + "' AND i_salidas.Id_DocContable=0 AND i_salidas.FechaSalida <='" + this.xmetodos.formatoAMD.format(this.JDFechaF.getDate()) + "') GROUP BY i_tiposmovimientos.Nbre ORDER BY ValorConsolidado desc";
                } else if (this.JRBEntrada.isSelected()) {
                    sql = "SELECT i_tiposmovimientos.Nbre, round(SUM((i_detalleentrada.Cantidad*i_detalleentrada.ValorUnitario))) AS Valor, ifnull(cc_puc_1.Id,'') as CPuc_Debito, ifnull(cc_puc.Id,'') as CPuc_Credito FROM i_detalleentrada INNER JOIN i_entradas  ON (i_detalleentrada.IdEntrada = i_entradas.Id) INNER JOIN i_tiposmovimientos  ON (i_entradas.IdTipoMovimiento = i_tiposmovimientos.Id)  left join cc_puc on (cc_puc.Id = i_tiposmovimientos.CPuc_Credito) left join cc_puc cc_puc_1 on (cc_puc_1.Id = i_tiposmovimientos.CPuc_Debito) WHERE (i_entradas.IdBodega ='" + this.xidbodega[this.JCBBodega.getSelectedIndex()] + "' AND i_entradas.Id_Periodo ='" + this.xidperiodo[this.JCBPeriodo.getSelectedIndex()] + "' AND i_entradas.Estado =0 AND i_entradas.Id_DocContable =0  AND i_tiposmovimientos.CPuc_Debito <>'' AND i_entradas.FechaEntrada >='" + this.xmetodos.formatoAMD.format(this.JDFechaI.getDate()) + "' AND i_entradas.FechaEntrada <='" + this.xmetodos.formatoAMD.format(this.JDFechaF.getDate()) + "') GROUP BY i_tiposmovimientos.Nbre ORDER BY i_tiposmovimientos.Nbre ASC ";
                }
                mCargarDatosTabla(sql);
                System.out.println(" Dentro " + sql);
                System.out.println(" suelta " + this.xsql);
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe selecionar la bodega", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBBodega.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe selecionar el periodo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JCBBodega.requestFocus();
    }

    public void mNuevo() {
        Principal.mLimpiarDatosP();
        this.JLB_DocumentoC.setText("");
        this.JTFF_Total.setValue(new Double(0.0d));
        this.JCBBodega.removeAllItems();
        this.JCBPeriodo.removeAllItems();
        this.JCBPeriodoC.removeAllItems();
        this.JCBTipoDocumentoC.removeAllItems();
        this.xidperiodo = this.xconsulta.llenarCombo("SELECT Id, CONCAT(DevuelveMes(FechaF), '-',DATE_FORMAT(FechaF,'%Y')) AS MesC FROM i_periodo WHERE (Estado =1 and Activo=1) ORDER BY FechaF desc", this.xidperiodo, this.JCBPeriodo);
        this.xidperiodoc = this.xconsulta.llenarCombo("SELECT Id, CONCAT(DevuelveMes(FechaI), '-',DATE_FORMAT(FechaI,'%Y')) AS Periodo FROM cc_periodo_contable WHERE (Estado =1) ORDER BY FechaF DESC", this.xidperiodoc, this.JCBPeriodoC);
        this.xidtipodocumentoc = this.xconsulta.llenarCombo("SELECT `Id`, `Nbre` FROM `cc_tipo_documentoc` WHERE (`Estado` =1 and `IdClasificacion` =7) ORDER BY `Nbre` ASC;", this.xidtipodocumentoc, this.JCBTipoDocumentoC);
        this.xconsulta.cerrarConexionBd();
        this.JDFecha.setDate(this.xmetodos.getFechaActual());
        this.JDFechaI.setDate(this.xmetodos.getFechaActual());
        this.JDFechaF.setDate(this.xmetodos.getFechaActual());
        this.JCBPeriodo.setSelectedIndex(-1);
        this.JCBPeriodoC.setSelectedIndex(-1);
        this.JRBSalida.setSelected(true);
        this.JTFRuta.setText(this.xmetodos.getDirectorioExportacion() + "Planilla");
        mCrearModeloDatos();
        mLlenarComboBodega();
    }

    private void mLlenarComboBodega() {
        this.xlleno = false;
        this.JCBBodega.removeAllItems();
        if (this.JRBSalida.isSelected()) {
            this.xsql = "SELECT `i_bodegas`.`Id` , `i_bodegas`.`Nbre`\nFROM `i_salidas`  INNER JOIN `i_bodegas`   ON (`i_salidas`.`IdBodega` = `i_bodegas`.`Id`)\nWHERE (`i_salidas`.`FechaSalida` >='" + this.xmetodos.formatoAMD1.format(this.JDFechaI.getDate()) + "'\n    AND `i_salidas`.`FechaSalida` <='" + this.xmetodos.formatoAMD1.format(this.JDFechaF.getDate()) + "'\n    AND `i_salidas`.`Estado` =0\n    AND `i_bodegas`.`Contabilidad` =1 and `i_salidas`.`Id_DocContable`=0)\nGROUP BY `i_bodegas`.`Id`\nORDER BY `i_bodegas`.`Nbre` ASC";
        } else {
            this.xsql = "SELECT `i_bodegas`.`Id` , `i_bodegas`.`Nbre`\nFROM `i_entradas`  INNER JOIN `i_bodegas`   ON (`i_entradas`.`IdBodega` = `i_bodegas`.`Id`)\nWHERE (`i_entradas`.`FechaEntrada`>='" + this.xmetodos.formatoAMD1.format(this.JDFechaI.getDate()) + "'\n    AND `i_entradas`.`FechaEntrada` <='" + this.xmetodos.formatoAMD1.format(this.JDFechaF.getDate()) + "'\n    AND `i_entradas`.`Estado` =0\n    AND `i_bodegas`.`Contabilidad` =1 AND i_entradas.`Id_DocContable`=0)\nGROUP BY `i_bodegas`.`Id`\nORDER BY `i_bodegas`.`Nbre` ASC";
        }
        this.xidbodega = this.xconsulta.llenarCombo(this.xsql, this.xidbodega, this.JCBBodega);
        this.xconsulta.cerrarConexionBd();
        if (this.xidbodega.length > 1) {
            this.JCBBodega.setSelectedIndex(-1);
        }
        this.xlleno = true;
    }

    public void mImprimir() {
        if (!Principal.txtNo.getText().isEmpty()) {
            String[][] parametros = new String[3][2];
            parametros[0][0] = "id";
            parametros[0][1] = Principal.txtNo.getText();
            parametros[1][0] = "SUBREPORT_DIR";
            parametros[1][1] = this.xmetodos.getSO() + this.xmetodos.getBarra() + "Reportes" + this.xmetodos.getBarra();
            parametros[2][0] = "SUBREPORTFIRMA_DIR";
            parametros[2][1] = this.xmetodos.getSO() + this.xmetodos.getBarra() + "Firmas" + this.xmetodos.getBarra();
            this.xmetodos.GenerarPDF(this.xmetodos.getRutaRep() + "L_PlanillaRemision", parametros);
            this.xconsulta.cerrarConexionBd();
        }
    }

    private Long mConcecutivo() {
        Long Con = 0L;
        String sql = "SELECT MAX(`NConsecutivo`) as MaximoCons FROM `cc_documentoc` WHERE (`Id_TipoComprobante` ='" + this.xidtipodocumentoc[this.JCBTipoDocumentoC.getSelectedIndex()] + "' AND `Estado` =1);";
        ConsultasMySQL xct1 = new ConsultasMySQL();
        ResultSet xrs1 = xct1.traerRs(sql);
        try {
            if (xrs1.next()) {
                xrs1.first();
                Con = Long.valueOf(xrs1.getLong("MaximoCons"));
            }
            xrs1.close();
            xct1.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFCierresContables.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return Long.valueOf(Con.longValue() + 1);
    }

    public void mGrabar() {
        if (this.JLB_DocumentoC.getText().isEmpty()) {
            if (Principal.xClaseInventario.isXestadop()) {
                if (Principal.xClaseInventario.mValidarFechasDoc(this.JDFecha.getDate())) {
                    if (this.JCBPeriodoC.getSelectedIndex() != -1) {
                        if (this.JCBTipoDocumentoC.getSelectedIndex() != -1) {
                            if (this.xmetodos.mVerificarDatosTablaTrue(this.JTDetalle, 4)) {
                                if (!this.xmetodos.mVerificarDatosLLeno(this.JTDetalle, 2) && !this.xmetodos.mVerificarDatosLLeno(this.JTDetalle, 3)) {
                                    String sql = "insert into cc_documentoc (FechaD, Id_TipoComprobante, NConsecutivo,  Id_PeriodoC, Descripcion, Fecha, UsuarioS) Values ('" + this.xmetodos.formatoAMD.format(this.JDFecha.getDate()) + "','" + this.xidtipodocumentoc[this.JCBTipoDocumentoC.getSelectedIndex()] + "','" + mConcecutivo() + "','" + this.xidperiodoc[this.JCBPeriodoC.getSelectedIndex()] + "','COSTOS MEDICAMENTOS DEL " + this.JCBPeriodoC.getSelectedItem().toString() + " FECHA : " + this.xmetodos.formatoAMD.format(this.JDFechaI.getDate()) + " -  " + this.JCBBodega.getSelectedItem().toString().toUpperCase() + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                                    this.JLB_DocumentoC.setText(this.xconsulta.ejecutarSQLId(sql));
                                    this.xconsulta.cerrarConexionBd();
                                    for (int y = 0; y < this.JTDetalle.getRowCount(); y++) {
                                        if (Boolean.valueOf(this.xmodelo.getValueAt(y, 4).toString()).booleanValue()) {
                                            ConsultasMySQL xct = new ConsultasMySQL();
                                            String sql2 = "insert into cc_detalle_documentoc (Id_Documentoc, Id_Puc, TipoCPuc, Id_Tercero, VDebito, VCredito) Values ('" + this.JLB_DocumentoC.getText() + "','" + this.xmodelo.getValueAt(y, 2).toString() + "','0','" + Principal.informacionIps.getIdEmpresa() + "','" + this.xmodelo.getValueAt(y, 1).toString() + "','0')";
                                            xct.ejecutarSQL(sql2);
                                            xct.cerrarConexionBd();
                                            String sql3 = "insert into cc_detalle_documentoc (Id_Documentoc, Id_Puc, TipoCPuc, Id_Tercero, VDebito, VCredito) Values ('" + this.JLB_DocumentoC.getText() + "','" + this.xmodelo.getValueAt(y, 3).toString() + "','1','" + Principal.informacionIps.getIdEmpresa() + "','0','" + this.xmodelo.getValueAt(y, 1).toString() + "')";
                                            xct.ejecutarSQL(sql3);
                                            xct.cerrarConexionBd();
                                        }
                                        mActualizarDatosInventarioN();
                                        this.xmetodos.mEnvioCorreoElectronico("Se ha generado el documento contable N° " + Principal.txtNo.getText() + "\nBodega : " + this.JCBBodega.getSelectedItem().toString(), "contabilidad@fundacionpanzenu.org.co", "COSTO DE MEDICAMENTOS  DEL " + this.xmetodos.formatoDMA.format(this.JDFechaI.getDate()) + " AL " + this.xmetodos.formatoDMA.format(this.JDFechaF.getDate()), Principal.usuarioSistemaDTO.getLogin());
                                    }
                                    return;
                                }
                                JOptionPane.showInternalMessageDialog(this, "Faltan cuentas puc", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                return;
                            }
                            JOptionPane.showInternalMessageDialog(this, "No existe registro selecionado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                            return;
                        }
                        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un tipo de documento contable", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        this.JCBTipoDocumentoC.requestFocus();
                        return;
                    }
                    JOptionPane.showInternalMessageDialog(this, "No seleccionar un periodo contable", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    this.JCBPeriodoC.requestFocus();
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Fecha fuera del periodo contable", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                this.JDFecha.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Perido cerrado", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Documento contable ya generado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Tipo Movimiento", "Valor", "CPDebito", "CPCredito", "Incluir?"}) { // from class: Inventarios.JIFCierresContables.8
            Class[] types = {String.class, Double.class, String.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(30);
    }

    public void mCargarDatosTabla(String xsql) {
        try {
            mCrearModeloDatos();
            double xvalor = 0.0d;
            ResultSet xrs = this.xconsulta.traerRs(xsql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(xrs.getString(1), n, 0);
                    double xValorC = 0.0d;
                    if (this.JRBSalida.isSelected()) {
                        if (Principal.informacionIps.getIdentificacion().equals("812005644")) {
                            if (n == 0) {
                                if (this.JCBBodega.getSelectedItem().equals("BODEGA SF")) {
                                    if (this.JCBPeriodo.getSelectedItem().equals("JULIO-2018")) {
                                        xValorC = 2856986.0d;
                                    } else if (this.JCBPeriodo.getSelectedItem().equals("AGOSTO-2018")) {
                                        xValorC = 1.6232456E7d;
                                    } else if (this.JCBPeriodo.getSelectedItem().equals("SEPTIEMBRE-2018")) {
                                        xValorC = 1.0791247E7d;
                                    } else if (this.JCBPeriodo.getSelectedItem().equals("OCTUBRE-2018")) {
                                        xValorC = -3850007.0d;
                                    } else if (this.JCBPeriodo.getSelectedItem().equals("NOVIEMBRE-2018")) {
                                        xValorC = -3569195.0d;
                                    }
                                }
                                this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(2) + xValorC), n, 1);
                            } else {
                                this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(2)), n, 1);
                            }
                        } else {
                            this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(2)), n, 1);
                        }
                    } else {
                        this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(2)), n, 1);
                    }
                    this.xmodelo.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelo.setValueAt(xrs.getString(4), n, 3);
                    this.xmodelo.setValueAt(true, n, 4);
                    xvalor += xrs.getDouble(2) + xValorC;
                    n++;
                }
            }
            xrs.close();
            this.xconsulta.cerrarConexionBd();
            this.JTFF_Total.setValue(Double.valueOf(xvalor));
        } catch (SQLException ex) {
            Logger.getLogger(JIFCierresContables.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mActualizarDatosInventarioN() {
        ConsultasMySQL xct = new ConsultasMySQL();
        if (this.JRBEntrada.isSelected()) {
            this.xsql = "UPDATE i_entradas ,(SELECT i_entradas.Id FROM i_entradas INNER JOIN i_tiposmovimientos  ON (i_entradas.IdTipoMovimiento = i_tiposmovimientos.Id) WHERE (i_entradas.IdBodega ='" + this.xidbodega[this.JCBBodega.getSelectedIndex()] + "' AND i_entradas.Id_Periodo ='" + this.xidperiodo[this.JCBPeriodo.getSelectedIndex()] + "' AND i_entradas.Estado =0 AND i_entradas.Id_DocContable =0  AND i_tiposmovimientos.CPuc_Debito <>'' AND i_entradas.FechaEntrada >='" + this.xmetodos.formatoAMD.format(this.JDFechaI.getDate()) + "' AND i_entradas.FechaEntrada <='" + this.xmetodos.formatoAMD.format(this.JDFechaF.getDate()) + "') ORDER BY i_tiposmovimientos.Nbre ASC) AS Detalle SET i_entradas.`Id_DocContable`='" + this.JLB_DocumentoC.getText() + "' WHERE i_entradas.`Id`=Detalle.Id ";
        } else if (this.JRBSalida.isSelected()) {
            this.xsql = "update i_salidas,(SELECT i_salidas.Id FROM i_salidas INNER JOIN i_tiposmovimientos  ON (i_salidas.IdTipoMovimiento = i_tiposmovimientos.Id) WHERE (i_salidas.IdBodega ='" + this.xidbodega[this.JCBBodega.getSelectedIndex()] + "' AND i_salidas.Id_Periodo ='" + this.xidperiodo[this.JCBPeriodo.getSelectedIndex()] + "' AND i_salidas.Estado =0  AND i_tiposmovimientos.CPuc_Debito <>'' AND i_salidas.FechaSalida >='" + this.xmetodos.formatoAMD.format(this.JDFechaI.getDate()) + "' AND i_salidas.Id_DocContable=0 AND i_salidas.FechaSalida <='" + this.xmetodos.formatoAMD.format(this.JDFechaF.getDate()) + "') ORDER BY i_tiposmovimientos.Despacho ASC, i_tiposmovimientos.Nbre ASC) AS Detalle SET i_salidas.`Id_DocContable`='" + this.JLB_DocumentoC.getText() + "' WHERE i_salidas.`Id`=Detalle.Id ";
        }
        xct.ejecutarSQL(this.xsql);
        xct.cerrarConexionBd();
    }
}
