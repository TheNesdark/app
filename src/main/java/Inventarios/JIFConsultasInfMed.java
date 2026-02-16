package Inventarios;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Dimension;
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
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
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
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

/* JADX INFO: loaded from: GenomaP.jar:Inventarios/JIFConsultasInfMed.class */
public class JIFConsultasInfMed extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private DefaultTableModel xmodelo1;
    private Object[] xdatos;
    private String[] xidbodega;
    private String xsql;
    private ButtonGroup JBGSeleccion;
    private ButtonGroup JBGSeleccion1;
    private JButton JBTCalcular;
    private JButton JBTExportar;
    public JComboBox JCBBodega;
    public JComboBox JCBTipoEspecialidad;
    private JDateChooser JDFechaF;
    private JDateChooser JDFechaI;
    private JPanel JPIConsolidado;
    private JPanel JPIDatos;
    private JScrollPane JSPCCategoria;
    private JScrollPane JSPDetalleP;
    private JTable JTCCategoria;
    private JTable JTDetalleP;
    private JFormattedTextField JTFFNFormulas;
    private JFormattedTextField JTFFNItems;
    private JFormattedTextField JTFFValorPFormula;
    private JFormattedTextField JTFFValorT;
    private JTextField JTFRuta;
    private JTabbedPane JTPDatos;
    private ConsultasMySQL xconsulta = new ConsultasMySQL();
    private Metodos xmt = new Metodos();
    private boolean xlleno = false;

    public JIFConsultasInfMed(String xnombre) {
        initComponents();
        setName(xnombre);
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v50, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v90, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGSeleccion = new ButtonGroup();
        this.JBGSeleccion1 = new ButtonGroup();
        this.JPIDatos = new JPanel();
        this.JCBBodega = new JComboBox();
        this.JDFechaI = new JDateChooser();
        this.JDFechaF = new JDateChooser();
        this.JCBTipoEspecialidad = new JComboBox();
        this.JBTCalcular = new JButton();
        this.JTFRuta = new JTextField();
        this.JBTExportar = new JButton();
        this.JTPDatos = new JTabbedPane();
        this.JPIConsolidado = new JPanel();
        this.JSPCCategoria = new JScrollPane();
        this.JTCCategoria = new JTable();
        this.JTFFNFormulas = new JFormattedTextField();
        this.JTFFNItems = new JFormattedTextField();
        this.JTFFValorT = new JFormattedTextField();
        this.JTFFValorPFormula = new JFormattedTextField();
        this.JSPDetalleP = new JScrollPane();
        this.JTDetalleP = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("CONSULTA DISPENSACIÓN POR MEDICO");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setMaximumSize(new Dimension(1050, 640));
        setMinimumSize(new Dimension(1050, 640));
        setName("jifconsultarinformesm");
        try {
            setSelected(true);
        } catch (PropertyVetoException e1) {
            e1.printStackTrace();
        }
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JCBBodega.setFont(new Font("Arial", 1, 12));
        this.JCBBodega.setBorder(BorderFactory.createTitledBorder((Border) null, "Bodega", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicial", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFechaI.setFont(new Font("Arial", 1, 12));
        this.JDFechaI.addPropertyChangeListener(new PropertyChangeListener() { // from class: Inventarios.JIFConsultasInfMed.1
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFConsultasInfMed.this.JDFechaIPropertyChange(evt);
            }
        });
        this.JDFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Final", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFechaF.setFont(new Font("Arial", 1, 12));
        this.JDFechaF.addPropertyChangeListener(new PropertyChangeListener() { // from class: Inventarios.JIFConsultasInfMed.2
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFConsultasInfMed.this.JDFechaFPropertyChange(evt);
            }
        });
        this.JCBTipoEspecialidad.setFont(new Font("Arial", 1, 12));
        this.JCBTipoEspecialidad.setModel(new DefaultComboBoxModel(new String[]{"MEDICOS MEDICINA PREPAGADA", "MEDICOS GENERALES FPZ", "MEDICOS ESPECIALISTAS FPZ", "ENFERMERIA", "PROMOCIÓN Y PREVENCIÓN"}));
        this.JCBTipoEspecialidad.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo de Formulación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBTCalcular.setFont(new Font("Arial", 1, 12));
        this.JBTCalcular.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Cartera29x27.png")));
        this.JBTCalcular.setText("Calcular");
        this.JBTCalcular.setEnabled(false);
        this.JBTCalcular.addActionListener(new ActionListener() { // from class: Inventarios.JIFConsultasInfMed.3
            public void actionPerformed(ActionEvent evt) {
                JIFConsultasInfMed.this.JBTCalcularActionPerformed(evt);
            }
        });
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JDFechaI, -2, 120, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JDFechaF, -2, 120, -2).addGap(18, 18, 18).addComponent(this.JCBBodega, -2, 757, -2)).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JCBTipoEspecialidad, -2, 365, -2).addGap(29, 29, 29).addComponent(this.JBTCalcular, -2, 279, -2).addGap(0, 0, 0))).addContainerGap()));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBBodega, -2, -1, -2).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JDFechaF, GroupLayout.Alignment.LEADING, -1, -1, -2).addComponent(this.JDFechaI, GroupLayout.Alignment.LEADING, -1, -1, -2))).addGap(10, 10, 10).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JBTCalcular, -2, 50, -2).addComponent(this.JCBTipoEspecialidad, GroupLayout.Alignment.LEADING, -2, -1, -2)).addGap(10, 10, 10)));
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: Inventarios.JIFConsultasInfMed.4
            public void mouseClicked(MouseEvent evt) {
                JIFConsultasInfMed.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: Inventarios.JIFConsultasInfMed.5
            public void actionPerformed(ActionEvent evt) {
                JIFConsultasInfMed.this.JBTExportarActionPerformed(evt);
            }
        });
        this.JTPDatos.setForeground(new Color(0, 103, 0));
        this.JTPDatos.setFont(new Font("Arial", 1, 14));
        this.JSPCCategoria.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.JTCCategoria.setFont(new Font("Arial", 1, 12));
        this.JTCCategoria.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTCCategoria.setRowHeight(25);
        this.JTCCategoria.setSelectionBackground(new Color(255, 255, 255));
        this.JTCCategoria.setSelectionForeground(new Color(255, 0, 0));
        this.JTCCategoria.addMouseListener(new MouseAdapter() { // from class: Inventarios.JIFConsultasInfMed.6
            public void mouseClicked(MouseEvent evt) {
                JIFConsultasInfMed.this.JTCCategoriaMouseClicked(evt);
            }
        });
        this.JSPCCategoria.setViewportView(this.JTCCategoria);
        this.JTFFNFormulas.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Formulas", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFNFormulas.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0"))));
        this.JTFFNFormulas.setHorizontalAlignment(4);
        this.JTFFNFormulas.setFont(new Font("Arial", 1, 12));
        this.JTFFNItems.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Items", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFNItems.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0"))));
        this.JTFFNItems.setHorizontalAlignment(4);
        this.JTFFNItems.setFont(new Font("Arial", 1, 12));
        this.JTFFValorT.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor Total", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFValorT.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFValorT.setHorizontalAlignment(4);
        this.JTFFValorT.setFont(new Font("Arial", 1, 12));
        this.JTFFValorPFormula.setBorder(BorderFactory.createTitledBorder((Border) null, "V/Pomedio Formula", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFValorPFormula.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFValorPFormula.setHorizontalAlignment(4);
        this.JTFFValorPFormula.setFont(new Font("Arial", 1, 12));
        GroupLayout JPIConsolidadoLayout = new GroupLayout(this.JPIConsolidado);
        this.JPIConsolidado.setLayout(JPIConsolidadoLayout);
        JPIConsolidadoLayout.setHorizontalGroup(JPIConsolidadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIConsolidadoLayout.createSequentialGroup().addGap(352, 352, 352).addComponent(this.JTFFNFormulas, -2, 150, -2).addGap(18, 18, 18).addComponent(this.JTFFNItems, -2, 150, -2).addGap(18, 18, 18).addComponent(this.JTFFValorT, -2, 150, -2).addGap(18, 18, 18).addComponent(this.JTFFValorPFormula, -2, 150, -2).addGap(23, 23, 23)).addGroup(JPIConsolidadoLayout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.JSPCCategoria, -2, 1005, -2).addGap(10, 10, 10)));
        JPIConsolidadoLayout.setVerticalGroup(JPIConsolidadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIConsolidadoLayout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.JSPCCategoria, -2, 212, -2).addGap(10, 10, 10).addGroup(JPIConsolidadoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFNFormulas, -2, 50, -2).addComponent(this.JTFFNItems, -2, 50, -2).addComponent(this.JTFFValorT, -2, 50, -2).addComponent(this.JTFFValorPFormula, -2, 50, -2)).addGap(10, 10, 10)));
        this.JTPDatos.addTab("CONSOLIDADO POR CATEGORíA", this.JPIConsolidado);
        this.JTDetalleP.setFont(new Font("Arial", 1, 12));
        this.JTDetalleP.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalleP.setRowHeight(25);
        this.JTDetalleP.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalleP.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalleP.setSelectionMode(0);
        this.JTDetalleP.addMouseListener(new MouseAdapter() { // from class: Inventarios.JIFConsultasInfMed.7
            public void mouseClicked(MouseEvent evt) {
                JIFConsultasInfMed.this.JTDetallePMouseClicked(evt);
            }
        });
        this.JSPDetalleP.setViewportView(this.JTDetalleP);
        this.JTPDatos.addTab("DETALLE POR PROFESIONAL", this.JSPDetalleP);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(layout.createSequentialGroup().addComponent(this.JTFRuta, -2, 614, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTExportar, -2, 429, -2)).addComponent(this.JTPDatos, -2, 1049, -2).addComponent(this.JPIDatos, -2, -1, -2)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTPDatos, -2, 339, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JTFRuta, -2, 50, -2).addComponent(this.JBTExportar, -2, 53, -2)).addGap(15, 15, 15)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetallePMouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTCalcularActionPerformed(ActionEvent evt) {
        if (this.JTDetalleP.getRowCount() > 0) {
            for (int x = 0; x < this.JTDetalleP.getRowCount(); x++) {
                this.xmodelo.setValueAt(Long.valueOf(mConsultarItemsxTipo(this.JTDetalleP.getColumnName(7), this.xmodelo.getValueAt(x, 1).toString())), x, 7);
                this.xmodelo.setValueAt(Long.valueOf(mConsultarItemsxTipo(this.JTDetalleP.getColumnName(9), this.xmodelo.getValueAt(x, 1).toString())), x, 9);
                Double xvalor = Double.valueOf(Double.valueOf(this.xmodelo.getValueAt(x, 7).toString()).doubleValue() / Double.valueOf(this.xmodelo.getValueAt(x, 3).toString()).doubleValue());
                Double xvalor1 = Double.valueOf(Double.valueOf(this.xmodelo.getValueAt(x, 9).toString()).doubleValue() / Double.valueOf(this.xmodelo.getValueAt(x, 3).toString()).doubleValue());
                this.xmodelo.setValueAt(Double.valueOf(xvalor.doubleValue() * 100.0d), x, 8);
                this.xmodelo.setValueAt(Double.valueOf(xvalor1.doubleValue() * 100.0d), x, 10);
            }
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
    public void JBTExportarActionPerformed(ActionEvent evt) {
        if (this.JTDetalleP.getRowCount() != -1) {
            mExportar();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaIPropertyChange(PropertyChangeEvent evt) {
        if (this.xlleno) {
            mCargarCombo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaFPropertyChange(PropertyChangeEvent evt) {
        if (this.xlleno) {
            mCargarCombo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTCCategoriaMouseClicked(MouseEvent evt) {
    }

    public void mBuscar() {
        if (this.JCBBodega.getSelectedIndex() != -1) {
            mCargarDatosTabla_Consolidado();
            mCargarDatosTabla();
        } else {
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una bodega", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBBodega.requestFocus();
        }
    }

    private void mExportar() {
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "Confirmación", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            try {
                WritableWorkbook workbook = Workbook.createWorkbook(new File(this.JTFRuta.getText() + ".xls"));
                WritableSheet sheet = workbook.createSheet("plantilla", 0);
                sheet.addCell(new Label(0, 0, "Especialidad"));
                sheet.addCell(new Label(1, 0, "Profesional"));
                sheet.addCell(new Label(2, 0, "Nformulas"));
                sheet.addCell(new Label(3, 0, "NItems"));
                sheet.addCell(new Label(4, 0, "PItems x Formula"));
                sheet.addCell(new Label(5, 0, "Total Formulación"));
                sheet.addCell(new Label(6, 0, "VPFormula"));
                sheet.addCell(new Label(7, 0, "COMERCIAL"));
                sheet.addCell(new Label(8, 0, "%"));
                sheet.addCell(new Label(9, 0, "GENERICO"));
                sheet.addCell(new Label(10, 0, "%"));
                for (int x = 0; x < this.JTDetalleP.getRowCount(); x++) {
                    sheet.addCell(new Label(0, x + 1, this.xmodelo.getValueAt(x, 0).toString()));
                    sheet.addCell(new Label(1, x + 1, this.xmodelo.getValueAt(x, 1).toString()));
                    sheet.addCell(new Number(2, x + 1, Long.valueOf(this.xmodelo.getValueAt(x, 2).toString()).longValue()));
                    sheet.addCell(new Number(3, x + 1, Long.valueOf(this.xmodelo.getValueAt(x, 3).toString()).longValue()));
                    sheet.addCell(new Number(4, x + 1, Double.valueOf(this.xmodelo.getValueAt(x, 4).toString()).doubleValue()));
                    sheet.addCell(new Number(5, x + 1, Double.valueOf(this.xmodelo.getValueAt(x, 5).toString()).doubleValue()));
                    sheet.addCell(new Number(6, x + 1, Double.valueOf(this.xmodelo.getValueAt(x, 6).toString()).doubleValue()));
                    sheet.addCell(new Number(7, x + 1, Long.valueOf(this.xmodelo.getValueAt(x, 7).toString()).longValue()));
                    sheet.addCell(new Number(8, x + 1, Double.valueOf(this.xmodelo.getValueAt(x, 8).toString()).doubleValue()));
                    sheet.addCell(new Number(9, x + 1, Long.valueOf(this.xmodelo.getValueAt(x, 9).toString()).longValue()));
                    sheet.addCell(new Number(10, x + 1, Double.valueOf(this.xmodelo.getValueAt(x, 10).toString()).doubleValue()));
                }
                workbook.write();
                workbook.close();
            } catch (IOException ex) {
                Logger.getLogger(JIFConsultasInfMed.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            } catch (WriteException e) {
                Logger.getLogger(JIFConsultasInfMed.class.getName()).log(Level.SEVERE, (String) null, e);
            }
        }
    }

    public void mNuevo() {
        this.xlleno = false;
        this.JDFechaI.setDate(this.xmt.getFechaActual());
        this.JDFechaF.setDate(this.xmt.getFechaActual());
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
        mCargarCombo();
        mCrearModeloDatos_Detalle();
        mCrearModeloDatos_Consolidado();
        Principal.txtNo.setText("");
        this.JTFFNFormulas.setValue(new Integer(0));
        this.JTFFNItems.setValue(new Integer(0));
        this.JTFFValorT.setValue(new Double(0.0d));
        this.JTFFValorPFormula.setValue(new Double(0.0d));
        this.JDFechaI.requestFocus();
        this.xlleno = true;
    }

    private void mCargarCombo() {
        this.JCBBodega.removeAllItems();
        this.xsql = "SELECT `i_bodegas`.`Id` , `i_bodegas`.`Nbre` FROM `i_salidas` INNER JOIN `i_bodegas`  ON (`i_salidas`.`IdBodega` = `i_bodegas`.`Id`) INNER JOIN `i_tiposmovimientos`  ON (`i_salidas`.`IdTipoMovimiento` = `i_tiposmovimientos`.`Id`) WHERE (`i_salidas`.`FechaSalida` >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND `i_salidas`.`FechaSalida` <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' AND `i_salidas`.`Estado` =0 AND `i_tiposmovimientos`.`Despacho` =1) GROUP BY `i_bodegas`.`Id`";
        this.xidbodega = this.xconsulta.llenarCombo(this.xsql, this.xidbodega, this.JCBBodega);
        this.JCBBodega.setSelectedIndex(-1);
        this.xconsulta.cerrarConexionBd();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos_Detalle() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Especialidad", "Profesional", "Nformulas", "NItems", "PItems x Formula", "Total Formulación", "VPFormula", "COMERCIAL", "%", "GENERICO", "%"}) { // from class: Inventarios.JIFConsultasInfMed.8
            Class[] types = {String.class, String.class, Long.class, Long.class, Double.class, Double.class, Double.class, Long.class, Double.class, Long.class, Double.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalleP.setModel(this.xmodelo);
        this.JTDetalleP.getColumnModel().getColumn(0).setPreferredWidth(80);
        this.JTDetalleP.getColumnModel().getColumn(1).setPreferredWidth(150);
        this.JTDetalleP.getColumnModel().getColumn(2).setPreferredWidth(50);
        this.JTDetalleP.getColumnModel().getColumn(3).setPreferredWidth(50);
        this.JTDetalleP.getColumnModel().getColumn(4).setPreferredWidth(50);
        this.JTDetalleP.getColumnModel().getColumn(5).setPreferredWidth(50);
        this.JTDetalleP.getColumnModel().getColumn(6).setPreferredWidth(50);
        this.JTDetalleP.getColumnModel().getColumn(7).setPreferredWidth(50);
        this.JTDetalleP.getColumnModel().getColumn(8).setPreferredWidth(20);
        this.JTDetalleP.getColumnModel().getColumn(9).setPreferredWidth(50);
        this.JTDetalleP.getColumnModel().getColumn(10).setPreferredWidth(20);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos_Consolidado() {
        this.xmodelo1 = new DefaultTableModel(new Object[0], new String[]{"Id", "Categoría", "Nformulas", "NItems", "Valor", "% Utilizacion"}) { // from class: Inventarios.JIFConsultasInfMed.9
            Class[] types = {Long.class, String.class, Long.class, Long.class, Double.class, Double.class};
            boolean[] canEdit = {false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTCCategoria.setModel(this.xmodelo1);
        this.JTCCategoria.getColumnModel().getColumn(0).setPreferredWidth(80);
        this.JTCCategoria.getColumnModel().getColumn(1).setPreferredWidth(150);
        this.JTCCategoria.getColumnModel().getColumn(2).setPreferredWidth(50);
        this.JTCCategoria.getColumnModel().getColumn(3).setPreferredWidth(50);
        this.JTCCategoria.getColumnModel().getColumn(4).setPreferredWidth(50);
        this.JTCCategoria.getColumnModel().getColumn(5).setPreferredWidth(50);
    }

    public void mCargarDatosTabla() {
        try {
            this.xsql = "SELECT profesional1.Especialidad, profesional1.NProfesional, COUNT(DISTINCT (i_salidas.Id)) AS NFormulas, COUNT(i_detallesalida.IdSalida) AS NItems, ROUND(COUNT(i_detallesalida.IdSalida)/COUNT(DISTINCT (i_salidas.Id)),2)AS VPItems , SUM((CantidadDespachada*ValorUnitario)) AS TotalFormulacion, ROUND(SUM((CantidadDespachada*ValorUnitario))/COUNT(DISTINCT (i_salidas.Id))) AS VPFormula FROM g_profesional INNER JOIN i_salidas  ON (g_profesional.Id_Persona = i_salidas.IdProfesional) INNER JOIN profesional1  ON (profesional1.IdEspecialidad = i_salidas.IdEspecialidad) AND (g_profesional.Id_Persona = profesional1.Id_Persona) INNER JOIN i_detallesalida  ON (i_detallesalida.IdSalida = i_salidas.Id) WHERE (i_salidas.FechaSalida >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND i_salidas.Estado =0 AND i_salidas.IdBodega ='" + this.xidbodega[this.JCBBodega.getSelectedIndex()] + "' AND i_salidas.FechaSalida <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' AND g_profesional.Datos='" + this.JCBTipoEspecialidad.getSelectedIndex() + "') GROUP BY profesional1.NProfesional ORDER BY profesional1.Especialidad ASC, profesional1.NProfesional ASC ";
            mCrearModeloDatos_Detalle();
            System.out.println("Datos" + this.xsql);
            ResultSet xrs = this.xconsulta.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(xrs.getString(1), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(3)), n, 2);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(4)), n, 3);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(5)), n, 4);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(6)), n, 5);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(7)), n, 6);
                    n++;
                }
                this.JBTCalcular.setEnabled(true);
            }
            xrs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFConsultasInfMed.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mCargarDatosTabla_Consolidado() {
        try {
            this.xsql = "SELECT `i_categoria`.`Id`, `i_categoria`.`Nbre`, COUNT(DISTINCT(`i_salidas`.`Id`)) AS `CFormula`, COUNT(`i_detallesalida`.`IdSalida`) AS `CItemsF` , ROUND(SUM( (`i_detallesalida`.`CantidadDespachada`* `i_detallesalida`.`ValorUnitario`))) AS `Valor` FROM `i_detallesalida`INNER JOIN `i_salidas`  ON (`i_detallesalida`.`IdSalida` = `i_salidas`.`Id`) INNER JOIN `i_suministro`  ON (`i_detallesalida`.`IdSuministro` = `i_suministro`.`Id`) INNER JOIN `i_categoria`  ON (`i_suministro`.`IdCategoria` = `i_categoria`.`Id`) INNER JOIN `i_tiposmovimientos`  ON (`i_salidas`.`IdTipoMovimiento` = `i_tiposmovimientos`.`Id`) WHERE (`i_salidas`.`FechaSalida` >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND `i_salidas`.`FechaSalida` <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' AND `i_salidas`.`Estado` =0 AND `i_salidas`.`IdBodega` ='" + this.xidbodega[this.JCBBodega.getSelectedIndex()] + "' AND `i_tiposmovimientos`.`Despacho` =1) GROUP BY `i_categoria`.`Id` ";
            mCrearModeloDatos_Consolidado();
            System.out.println("Datos" + this.xsql);
            ResultSet xrs = this.xconsulta.traerRs(this.xsql);
            long xnf = 0;
            long xni = 0;
            double xvt = 0.0d;
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo1.addRow(this.xdatos);
                    this.xmodelo1.setValueAt(Long.valueOf(xrs.getLong(1)), n, 0);
                    this.xmodelo1.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo1.setValueAt(Long.valueOf(xrs.getLong(3)), n, 2);
                    this.xmodelo1.setValueAt(Long.valueOf(xrs.getLong(4)), n, 3);
                    this.xmodelo1.setValueAt(Double.valueOf(xrs.getDouble(5)), n, 4);
                    xnf += xrs.getLong(3);
                    xni += xrs.getLong(4);
                    xvt += xrs.getDouble(5);
                    this.xmodelo1.setValueAt(0, n, 5);
                    n++;
                }
                this.JTFFNFormulas.setValue(Long.valueOf(xnf));
                this.JTFFNItems.setValue(Long.valueOf(xni));
                this.JTFFValorT.setValue(Double.valueOf(xvt));
                this.JTFFValorPFormula.setValue(Double.valueOf(xvt / xnf));
                for (int x = 0; x < this.JTCCategoria.getRowCount(); x++) {
                    this.xmodelo1.setValueAt(Double.valueOf((Double.valueOf(this.xmodelo1.getValueAt(x, 2).toString()).doubleValue() / xnf) * 100.0d), x, 5);
                }
            }
            xrs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFConsultasInfMed.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private long mConsultarItemsxTipo(String xncolumna, String xprofesional) {
        long xdato = 0;
        ConsultasMySQL xct = new ConsultasMySQL();
        String xsql = "SELECT profesional1.Especialidad, profesional1.NProfesional,i_categoria.Nbre, COUNT(i_categoria.Nbre )  AS NItems FROM g_profesional INNER JOIN i_salidas  ON (g_profesional.Id_Persona = i_salidas.IdProfesional) INNER JOIN profesional1  ON (profesional1.IdEspecialidad = i_salidas.IdEspecialidad)  AND (g_profesional.Id_Persona = profesional1.Id_Persona)  INNER JOIN i_detallesalida  ON (i_detallesalida.IdSalida = i_salidas.Id)  INNER JOIN i_suministro ON (i_suministro.Id=i_detallesalida.IdSuministro)  INNER JOIN i_categoria ON (i_categoria.Id=i_suministro.IdCategoria)  WHERE (i_salidas.FechaSalida >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND i_salidas.Estado =0 AND i_salidas.IdBodega ='" + this.xidbodega[this.JCBBodega.getSelectedIndex()] + "' AND i_salidas.FechaSalida <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' AND g_profesional.Datos='" + this.JCBTipoEspecialidad.getSelectedIndex() + "' AND  profesional1.NProfesional='" + xprofesional + "' AND i_categoria.Nbre='" + xncolumna + "')   GROUP BY profesional1.NProfesional,i_categoria.Nbre  ORDER BY profesional1.Especialidad ASC, profesional1.NProfesional ASC";
        ResultSet rs = xct.traerRs(xsql);
        try {
            if (rs.next()) {
                xdato = rs.getLong(4);
            }
            rs.close();
            xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFConsultasInfMed.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return xdato;
    }
}
