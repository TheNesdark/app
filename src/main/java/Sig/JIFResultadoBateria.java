package Sig;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.genoma.plus.jpa.projection.IDetalleAdicionalCuestionarioSaludOcupacional;
import com.genoma.plus.jpa.projection.IEncabezadoCuestionarioSaludOcupacional;
import com.genoma.plus.jpa.service.ITipoCuestionarioSaludOcupacionalService;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

/* JADX INFO: loaded from: GenomaP.jar:Sig/JIFResultadoBateria.class */
public class JIFResultadoBateria extends JInternalFrame {
    private String[] xidFormato;
    private DefaultTableModel xmodeloConsolidado;
    private DefaultTableModel xmodeloDetall;
    private DefaultTableModel xmodeloDetallU;
    private Object[] xdatos;
    private ButtonGroup JBGFiltro;
    private JButton JBTExportar;
    private JComboBox JCBFormato;
    private JDateChooser JDFechaF;
    private JDateChooser JDFechaI;
    private JPanel JPDatos;
    private JPanel JPFiltro;
    private JRadioButton JRBDimension;
    private JRadioButton JRBDominio;
    private JScrollPane JSPConsolidado;
    private JScrollPane JSPDetalle;
    private JScrollPane JSPDetalle1;
    private JTable JTConsolidado;
    private JTable JTDetalle;
    private JTable JTDetalleUsuario;
    private JTextField JTFRuta;
    private JPanel jPanel1;
    private JTabbedPane jTabbedPane1;
    private Metodos xmt = new Metodos();
    private ConsultasMySQL xct = new ConsultasMySQL();
    private boolean xlleno = false;
    private final ITipoCuestionarioSaludOcupacionalService cuestionarioSaludOcupacionalService = (ITipoCuestionarioSaludOcupacionalService) Principal.contexto.getBean(ITipoCuestionarioSaludOcupacionalService.class);

    public JIFResultadoBateria() {
        initComponents();
        this.JDFechaI.setDate(this.xmt.getFechaActual());
        this.JDFechaF.setDate(this.xmt.getFechaActual());
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
        mLLenaCombo();
    }

    /* JADX WARN: Type inference failed for: r3v51, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v56, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v61, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGFiltro = new ButtonGroup();
        this.JPDatos = new JPanel();
        this.JDFechaI = new JDateChooser();
        this.JDFechaF = new JDateChooser();
        this.JCBFormato = new JComboBox();
        this.JPFiltro = new JPanel();
        this.JRBDimension = new JRadioButton();
        this.JRBDominio = new JRadioButton();
        this.jTabbedPane1 = new JTabbedPane();
        this.JSPConsolidado = new JScrollPane();
        this.JTConsolidado = new JTable();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.jPanel1 = new JPanel();
        this.JSPDetalle1 = new JScrollPane();
        this.JTDetalleUsuario = new JTable();
        this.JTFRuta = new JTextField();
        this.JBTExportar = new JButton();
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("RESULTADO BATERÍA PSICOSOCIAL");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjifResultadoSicosocial");
        this.JPDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JDFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFechaI.setFont(new Font("Arial", 1, 12));
        this.JDFechaI.addPropertyChangeListener(new PropertyChangeListener() { // from class: Sig.JIFResultadoBateria.1
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFResultadoBateria.this.JDFechaIPropertyChange(evt);
            }
        });
        this.JDFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Fin", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFechaF.setFont(new Font("Arial", 1, 12));
        this.JDFechaF.addPropertyChangeListener(new PropertyChangeListener() { // from class: Sig.JIFResultadoBateria.2
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFResultadoBateria.this.JDFechaFPropertyChange(evt);
            }
        });
        this.JCBFormato.setFont(new Font("Arial", 1, 12));
        this.JCBFormato.setBorder(BorderFactory.createTitledBorder((Border) null, "Formato", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBFormato.addItemListener(new ItemListener() { // from class: Sig.JIFResultadoBateria.3
            public void itemStateChanged(ItemEvent evt) {
                JIFResultadoBateria.this.JCBFormatoItemStateChanged(evt);
            }
        });
        this.JPFiltro.setBorder(BorderFactory.createTitledBorder((Border) null, "Filtro", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JBGFiltro.add(this.JRBDimension);
        this.JRBDimension.setFont(new Font("Arial", 1, 12));
        this.JRBDimension.setSelected(true);
        this.JRBDimension.setText("Dimensión");
        this.JRBDimension.addActionListener(new ActionListener() { // from class: Sig.JIFResultadoBateria.4
            public void actionPerformed(ActionEvent evt) {
                JIFResultadoBateria.this.JRBDimensionActionPerformed(evt);
            }
        });
        this.JBGFiltro.add(this.JRBDominio);
        this.JRBDominio.setFont(new Font("Arial", 1, 12));
        this.JRBDominio.setText("Dominio");
        this.JRBDominio.addActionListener(new ActionListener() { // from class: Sig.JIFResultadoBateria.5
            public void actionPerformed(ActionEvent evt) {
                JIFResultadoBateria.this.JRBDominioActionPerformed(evt);
            }
        });
        GroupLayout JPFiltroLayout = new GroupLayout(this.JPFiltro);
        this.JPFiltro.setLayout(JPFiltroLayout);
        JPFiltroLayout.setHorizontalGroup(JPFiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPFiltroLayout.createSequentialGroup().addComponent(this.JRBDimension).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 31, 32767).addComponent(this.JRBDominio, -2, 112, -2)));
        JPFiltroLayout.setVerticalGroup(JPFiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPFiltroLayout.createSequentialGroup().addGroup(JPFiltroLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBDimension).addComponent(this.JRBDominio)).addGap(0, 0, 32767)));
        GroupLayout JPDatosLayout = new GroupLayout(this.JPDatos);
        this.JPDatos.setLayout(JPDatosLayout);
        JPDatosLayout.setHorizontalGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosLayout.createSequentialGroup().addContainerGap().addComponent(this.JDFechaI, -2, 116, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JDFechaF, -2, 116, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBFormato, -2, 305, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JPFiltro, -2, -1, -2).addContainerGap(-1, 32767)));
        JPDatosLayout.setVerticalGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JCBFormato, GroupLayout.Alignment.LEADING).addComponent(this.JDFechaF, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.JDFechaI, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.JPFiltro, -1, -1, 32767)).addGap(10, 10, 10)));
        this.jTabbedPane1.setForeground(Color.red);
        this.jTabbedPane1.setFont(new Font("Arial", 1, 14));
        this.JSPConsolidado.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTConsolidado.setFont(new Font("Arial", 1, 12));
        this.JTConsolidado.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTConsolidado.setSelectionBackground(new Color(255, 255, 255));
        this.JTConsolidado.setSelectionForeground(Color.red);
        this.JSPConsolidado.setViewportView(this.JTConsolidado);
        this.jTabbedPane1.addTab("CONSOLIDADO", this.JSPConsolidado);
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 12), new Color(0, 107, 0)));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.jTabbedPane1.addTab("DETALLE (UN)", this.JSPDetalle);
        this.JSPDetalle1.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 12), new Color(0, 107, 0)));
        this.JTDetalleUsuario.setFont(new Font("Arial", 1, 12));
        this.JTDetalleUsuario.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalleUsuario.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalleUsuario.setSelectionForeground(Color.red);
        this.JSPDetalle1.setViewportView(this.JTDetalleUsuario);
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 841, 32767).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.JSPDetalle1, -2, 841, -2).addGap(0, 0, 32767))));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 352, 32767).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.JSPDetalle1, -2, 352, -2).addGap(0, 0, 32767))));
        this.jTabbedPane1.addTab("DETALLE x USUARIO", this.jPanel1);
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: Sig.JIFResultadoBateria.6
            public void mouseClicked(MouseEvent evt) {
                JIFResultadoBateria.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setForeground(Color.red);
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: Sig.JIFResultadoBateria.7
            public void actionPerformed(ActionEvent evt) {
                JIFResultadoBateria.this.JBTExportarActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPDatos, -1, -1, 32767).addComponent(this.jTabbedPane1).addGroup(layout.createSequentialGroup().addComponent(this.JTFRuta, -2, 367, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JBTExportar, -2, 378, -2))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPDatos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jTabbedPane1, -2, 381, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFRuta, -2, 50, -2).addComponent(this.JBTExportar, -2, 50, -2)).addContainerGap(23, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaIPropertyChange(PropertyChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaFPropertyChange(PropertyChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBDominioActionPerformed(ActionEvent evt) {
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
            if (this.JTDetalle.getRowCount() > -1) {
                if (this.xlleno && this.xidFormato[this.JCBFormato.getSelectedIndex()].equals("8")) {
                    mExportarExtraL();
                    return;
                } else {
                    mExportarH();
                    return;
                }
            }
            JOptionPane.showInternalMessageDialog(this, "No existe información para exportar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un ruta valida", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        this.JTFRuta.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBDimensionActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBFormatoItemStateChanged(ItemEvent evt) {
        if (this.xlleno && this.xidFormato[this.JCBFormato.getSelectedIndex()].equals("8")) {
            this.JRBDimension.setSelected(true);
            this.JRBDimension.setEnabled(false);
            this.JRBDominio.setEnabled(false);
            this.JPFiltro.setEnabled(false);
            return;
        }
        this.JPFiltro.setEnabled(true);
        this.JRBDimension.setEnabled(true);
        this.JRBDominio.setEnabled(true);
    }

    private void mExportarH() {
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            try {
                WritableWorkbook workbook = Workbook.createWorkbook(new File(this.JTFRuta.getText() + ".xls"));
                WritableSheet sheet = workbook.createSheet("Consolidado", 0);
                for (int x = 0; x < this.JTConsolidado.getColumnCount() - 2; x++) {
                    sheet.addCell(new Label(x, 0, this.JTConsolidado.getColumnName(x)));
                }
                if (this.JTConsolidado.getRowCount() > 0) {
                    for (int x2 = 0; x2 < this.JTConsolidado.getRowCount(); x2++) {
                        sheet.addCell(new Label(0, x2 + 1, this.xmodeloConsolidado.getValueAt(x2, 0).toString()));
                        sheet.addCell(new Label(1, x2 + 1, this.xmodeloConsolidado.getValueAt(x2, 1).toString()));
                        sheet.addCell(new Number(2, x2 + 1, Double.valueOf(this.xmodeloConsolidado.getValueAt(x2, 2).toString()).doubleValue()));
                        sheet.addCell(new Number(3, x2 + 1, Double.valueOf(this.xmodeloConsolidado.getValueAt(x2, 3).toString()).doubleValue()));
                        sheet.addCell(new Label(4, x2 + 1, this.xmodeloConsolidado.getValueAt(x2, 4).toString()));
                    }
                }
                WritableSheet sheet2 = workbook.createSheet("Detallado Unidad Negocio", 1);
                for (int x3 = 0; x3 < this.JTDetalle.getColumnCount(); x3++) {
                    sheet2.addCell(new Label(x3, 0, this.JTDetalle.getColumnName(x3)));
                }
                if (this.JTDetalle.getRowCount() > 0) {
                    for (int x4 = 0; x4 < this.JTDetalle.getRowCount(); x4++) {
                        sheet2.addCell(new Label(0, x4 + 1, this.xmodeloDetall.getValueAt(x4, 0).toString()));
                        sheet2.addCell(new Label(1, x4 + 1, this.xmodeloDetall.getValueAt(x4, 1).toString()));
                        sheet2.addCell(new Number(2, x4 + 1, Double.valueOf(this.xmodeloDetall.getValueAt(x4, 2).toString()).doubleValue()));
                        sheet2.addCell(new Number(3, x4 + 1, Double.valueOf(this.xmodeloDetall.getValueAt(x4, 3).toString()).doubleValue()));
                        sheet2.addCell(new Label(4, x4 + 1, this.xmodeloDetall.getValueAt(x4, 4).toString()));
                        sheet2.addCell(new Label(5, x4 + 1, this.xmodeloDetall.getValueAt(x4, 5).toString()));
                    }
                }
                WritableSheet sheet3 = workbook.createSheet("Detalle por Usuario", 2);
                for (int x5 = 0; x5 < this.JTDetalleUsuario.getColumnCount(); x5++) {
                    sheet3.addCell(new Label(x5, 0, this.JTDetalleUsuario.getColumnName(x5)));
                }
                for (int x6 = 0; x6 < this.JTDetalleUsuario.getRowCount(); x6++) {
                    sheet3.addCell(new Label(0, x6 + 1, this.xmodeloDetallU.getValueAt(x6, 0).toString()));
                    sheet3.addCell(new Label(1, x6 + 1, this.xmodeloDetallU.getValueAt(x6, 1).toString()));
                    sheet3.addCell(new Label(2, x6 + 1, this.xmodeloDetallU.getValueAt(x6, 2).toString()));
                    sheet3.addCell(new Label(3, x6 + 1, this.xmodeloDetallU.getValueAt(x6, 3).toString()));
                    sheet3.addCell(new Label(4, x6 + 1, this.xmodeloDetallU.getValueAt(x6, 4).toString()));
                    sheet3.addCell(new Label(5, x6 + 1, this.xmodeloDetallU.getValueAt(x6, 5).toString()));
                    sheet3.addCell(new Label(6, x6 + 1, this.xmodeloDetallU.getValueAt(x6, 6).toString()));
                    sheet3.addCell(new Label(7, x6 + 1, this.xmodeloDetallU.getValueAt(x6, 7).toString()));
                    sheet3.addCell(new Label(8, x6 + 1, this.xmodeloDetallU.getValueAt(x6, 8).toString()));
                    sheet3.addCell(new Label(9, x6 + 1, this.xmodeloDetallU.getValueAt(x6, 9).toString()));
                    sheet3.addCell(new Label(10, x6 + 1, this.xmodeloDetallU.getValueAt(x6, 10).toString()));
                    sheet3.addCell(new Label(11, x6 + 1, this.xmodeloDetallU.getValueAt(x6, 11).toString()));
                }
                workbook.write();
                workbook.close();
            } catch (WriteException e) {
                Logger.getLogger(JIFResultadoBateria.class.getName()).log(Level.SEVERE, (String) null, e);
            } catch (IOException ex) {
                Logger.getLogger(JIFResultadoBateria.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        }
    }

    private void mExportarExtraL() {
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            try {
                WritableWorkbook workbook = Workbook.createWorkbook(new File(this.JTFRuta.getText() + ".xls"));
                WritableSheet sheet = workbook.createSheet("Consolidado", 0);
                for (int x = 0; x < this.JTConsolidado.getColumnCount() - 2; x++) {
                    sheet.addCell(new Label(x, 0, this.JTConsolidado.getColumnName(x)));
                }
                for (int x2 = 0; x2 < this.JTConsolidado.getRowCount(); x2++) {
                    sheet.addCell(new Label(0, x2 + 1, this.xmodeloConsolidado.getValueAt(x2, 0).toString()));
                    sheet.addCell(new Label(1, x2 + 1, this.xmodeloConsolidado.getValueAt(x2, 1).toString()));
                    sheet.addCell(new Number(2, x2 + 1, Double.valueOf(this.xmodeloConsolidado.getValueAt(x2, 2).toString()).doubleValue()));
                    sheet.addCell(new Number(3, x2 + 1, Double.valueOf(this.xmodeloConsolidado.getValueAt(x2, 3).toString()).doubleValue()));
                    sheet.addCell(new Number(4, x2 + 1, Double.valueOf(this.xmodeloConsolidado.getValueAt(x2, 4).toString()).doubleValue()));
                    sheet.addCell(new Label(5, x2 + 1, this.xmodeloConsolidado.getValueAt(x2, 5).toString()));
                }
                WritableSheet sheet2 = workbook.createSheet("Detallado Unidad Negocio", 1);
                for (int x3 = 0; x3 < this.JTDetalle.getColumnCount(); x3++) {
                    sheet2.addCell(new Label(x3, 0, this.JTDetalle.getColumnName(x3)));
                }
                for (int x4 = 0; x4 < this.JTDetalle.getRowCount(); x4++) {
                    sheet2.addCell(new Label(0, x4 + 1, this.xmodeloDetall.getValueAt(x4, 0).toString()));
                    sheet2.addCell(new Label(1, x4 + 1, this.xmodeloDetall.getValueAt(x4, 1).toString()));
                    sheet2.addCell(new Number(2, x4 + 1, Double.valueOf(this.xmodeloDetall.getValueAt(x4, 2).toString()).doubleValue()));
                    sheet2.addCell(new Number(3, x4 + 1, Double.valueOf(this.xmodeloDetall.getValueAt(x4, 3).toString()).doubleValue()));
                    sheet2.addCell(new Number(4, x4 + 1, Double.valueOf(this.xmodeloDetall.getValueAt(x4, 4).toString()).doubleValue()));
                    sheet2.addCell(new Label(5, x4 + 1, this.xmodeloDetall.getValueAt(x4, 5).toString()));
                    sheet2.addCell(new Label(6, x4 + 1, this.xmodeloDetall.getValueAt(x4, 6).toString()));
                }
                WritableSheet sheet3 = workbook.createSheet("Detalle por Usuario", 2);
                for (int x5 = 0; x5 < this.JTDetalleUsuario.getColumnCount(); x5++) {
                    sheet3.addCell(new Label(x5, 0, this.JTDetalleUsuario.getColumnName(x5)));
                }
                for (int x6 = 0; x6 < this.JTDetalleUsuario.getRowCount(); x6++) {
                    sheet3.addCell(new Label(0, x6 + 1, this.xmodeloDetallU.getValueAt(x6, 0).toString()));
                    sheet3.addCell(new Label(1, x6 + 1, this.xmodeloDetallU.getValueAt(x6, 1).toString()));
                    sheet3.addCell(new Label(2, x6 + 1, this.xmodeloDetallU.getValueAt(x6, 2).toString()));
                    sheet3.addCell(new Label(3, x6 + 1, this.xmodeloDetallU.getValueAt(x6, 3).toString()));
                    sheet3.addCell(new Label(4, x6 + 1, this.xmodeloDetallU.getValueAt(x6, 4).toString()));
                    sheet3.addCell(new Label(5, x6 + 1, this.xmodeloDetallU.getValueAt(x6, 5).toString()));
                    sheet3.addCell(new Label(6, x6 + 1, this.xmodeloDetallU.getValueAt(x6, 6).toString()));
                    sheet3.addCell(new Label(7, x6 + 1, this.xmodeloDetallU.getValueAt(x6, 7).toString()));
                    sheet3.addCell(new Label(8, x6 + 1, this.xmodeloDetallU.getValueAt(x6, 8).toString()));
                    sheet3.addCell(new Label(9, x6 + 1, this.xmodeloDetallU.getValueAt(x6, 9).toString()));
                    sheet3.addCell(new Label(10, x6 + 1, this.xmodeloDetallU.getValueAt(x6, 10).toString()));
                    sheet3.addCell(new Label(11, x6 + 1, this.xmodeloDetallU.getValueAt(x6, 11).toString()));
                    sheet3.addCell(new Label(12, x6 + 1, this.xmodeloDetallU.getValueAt(x6, 12).toString()));
                }
                workbook.write();
                workbook.close();
            } catch (IOException ex) {
                Logger.getLogger(JIFResultadoBateria.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            } catch (WriteException e) {
                Logger.getLogger(JIFResultadoBateria.class.getName()).log(Level.SEVERE, (String) null, e);
            }
        }
    }

    private void mLLenaCombo() {
        this.JCBFormato.removeAllItems();
        this.xidFormato = this.xct.llenarCombo("SELECT `Id` , `Nbre` FROM `so_tipo_cuestionario` WHERE (`Id` =10 OR `Id` =11 OR `Id` =8 OR `Id`= 7 OR `Id` = 9  AND `Estado`=1);", this.xidFormato, this.JCBFormato);
        this.xct.cerrarConexionBd();
        this.JCBFormato.setSelectedIndex(-1);
        this.xlleno = true;
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCreaModeloConsolidado(String xTipo) {
        this.xmodeloConsolidado = new DefaultTableModel(new Object[0], new String[]{"Dominio", xTipo, "VBruto", "VTrasformado", "VCuantitativo", "NP", "NS"}) { // from class: Sig.JIFResultadoBateria.8
            Class[] types = {String.class, String.class, Double.class, Double.class, String.class, Double.class, Double.class};
            boolean[] canEdit = {false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTConsolidado.setModel(this.xmodeloConsolidado);
        JTable jTable = this.JTConsolidado;
        JTable jTable2 = this.JTConsolidado;
        jTable.setAutoResizeMode(0);
        this.JTConsolidado.doLayout();
        this.JTConsolidado.getColumnModel().getColumn(0).setPreferredWidth(80);
        this.JTConsolidado.getColumnModel().getColumn(1).setPreferredWidth(250);
        this.JTConsolidado.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTConsolidado.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTConsolidado.getColumnModel().getColumn(4).setPreferredWidth(200);
        this.JTConsolidado.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTConsolidado.getColumnModel().getColumn(6).setPreferredWidth(100);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCreaModeloDetalle() {
        this.xmodeloDetall = new DefaultTableModel(new Object[0], new String[]{"Dominio", "Dimensión", "VBruto", "VTrasformado", "VCuantitativo", "Unidad Neg."}) { // from class: Sig.JIFResultadoBateria.9
            Class[] types = {String.class, String.class, Double.class, Double.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodeloDetall);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(100);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCreaModeloConsolidadoExtraL() {
        this.xmodeloConsolidado = new DefaultTableModel(new Object[0], new String[]{"Dominio", "Dimensión", "Valor", "Cantidad", "Total", "Calificación"}) { // from class: Sig.JIFResultadoBateria.10
            Class[] types = {String.class, String.class, Double.class, Double.class, Double.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTConsolidado.setModel(this.xmodeloConsolidado);
        JTable jTable = this.JTConsolidado;
        JTable jTable2 = this.JTConsolidado;
        jTable.setAutoResizeMode(0);
        this.JTConsolidado.doLayout();
        this.JTConsolidado.getColumnModel().getColumn(0).setPreferredWidth(200);
        this.JTConsolidado.getColumnModel().getColumn(1).setPreferredWidth(250);
        this.JTConsolidado.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTConsolidado.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTConsolidado.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTConsolidado.getColumnModel().getColumn(5).setPreferredWidth(250);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCreaModeloDetalleExtraL() {
        this.xmodeloDetall = new DefaultTableModel(new Object[0], new String[]{"Dominio", "Dimensión", "Valor", "Cantidad", "Total", "Unidad Negocio", "Calificación"}) { // from class: Sig.JIFResultadoBateria.11
            Class[] types = {String.class, String.class, Double.class, Double.class, Double.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodeloDetall);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(30);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(30);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(30);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(150);
    }

    private void mBuscaExtralaboralC() {
        mCreaModeloConsolidadoExtraL();
        mCreaModeloDetalleExtraL();
        String sql = "SELECT *,IF(interno.idDimension=32, IF(interno.total >= interno.FA_R1I AND interno.total<= interno.FA_R1S,'Sin riesgo o riesgo despreciable',  IF(interno.total >= interno.FA_R2I AND interno.total<= interno.FA_R2S,'Riesgo Bajo',IF(interno.total >= interno.FA_R3I AND interno.total<= interno.FA_R3S,'Riesgo Medio',  IF(interno.total >= interno.FA_R4I AND interno.total<= interno.FA_R4S,'Riesgo Alto','Riesgo muy Alto')))),  IF(interno.idDimension=33,IF(interno.total >= interno.FA_R1I AND interno.total<= interno.FA_R1S,'Sin riesgo o riesgo despreciable',  IF(interno.total >= interno.FA_R2I AND interno.total<= interno.FA_R2S,'Riesgo Bajo',IF(interno.total >= interno.FA_R3I AND interno.total<= interno.FA_R3S,'Riesgo Medio',  IF(interno.total >= interno.FA_R4I AND interno.total<= interno.FA_R4S,'Riesgo Alto','Riesgo muy Alto')))),  IF(interno.idDimension=34,IF(interno.total >= interno.FA_R1I AND interno.total<= interno.FA_R1S,'Sin riesgo o riesgo despreciable',  IF(interno.total >= interno.FA_R2I AND interno.total<= interno.FA_R2S,'Riesgo Bajo',IF(interno.total >= interno.FA_R3I AND interno.total<= interno.FA_R3S,'Riesgo Medio',  IF(interno.total >= interno.FA_R4I AND interno.total<= interno.FA_R4S,'Riesgo Alto','Riesgo muy Alto')))),  IF(interno.idDimension=35,IF(interno.total >= interno.FA_R1I AND interno.total<= interno.FA_R1S,'Sin riesgo o riesgo despreciable',  IF(interno.total >= interno.FA_R2I AND interno.total<= interno.FA_R2S,'Riesgo Bajo',IF(interno.total >= interno.FA_R3I AND interno.total<= interno.FA_R3S,'Riesgo Medio',  IF(interno.total >= interno.FA_R4I AND interno.total<= interno.FA_R4S,'Riesgo Alto','Riesgo muy Alto')))),  IF(interno.idDimension=36,IF(interno.total >= interno.FA_R1I AND interno.total<= interno.FA_R1S,'Sin riesgo o riesgo despreciable',  IF(interno.total >= interno.FA_R2I AND interno.total<= interno.FA_R2S,'Riesgo Bajo',IF(interno.total >= interno.FA_R3I AND interno.total<= interno.FA_R3S,'Riesgo Medio',  IF(interno.total >= interno.FA_R4I AND interno.total<= interno.FA_R4S,'Riesgo Alto','Riesgo muy Alto')))),  IF(interno.idDimension=37,IF(interno.total >= interno.FA_R1I AND interno.total<= interno.FA_R1S,'Sin riesgo o riesgo despreciable',  IF(interno.total >= interno.FA_R2I AND interno.total<= interno.FA_R2S,'Riesgo Bajo',IF(interno.total >= interno.FA_R3I AND interno.total<= interno.FA_R3S,'Riesgo Medio',  IF(interno.total >= interno.FA_R4I AND interno.total<= interno.FA_R4S,'Riesgo Alto','Riesgo muy Alto')))),  IF(interno.idDimension=38,IF(interno.total >= interno.FA_R1I AND interno.total<= interno.FA_R1S,'Sin riesgo o riesgo despreciable',  IF(interno.total >= interno.FA_R2I AND interno.total<= interno.FA_R2S,'Riesgo Bajo',IF(interno.total >= interno.FA_R3I AND interno.total<= interno.FA_R3S,'Riesgo Medio',  IF(interno.total >= interno.FA_R4I AND interno.total<= interno.FA_R4S,'Riesgo Alto','Riesgo muy Alto')))),  '--validando'))))))) AS Calificacion  FROM(  SELECT `so_tipo_pregunta_dominio`.`Nbre` AS `Dominio`  , so_tipo_pregunta_dimension.`Id` AS idDimension  , `so_tipo_pregunta_dimension`.`Nbre` AS `Dimension`  , SUM(`so_tipo_pregunta_respuesta`.`VCuantitativo`) AS `SValor`  , COUNT(`h_so_cuestionario_detalle`.`Id_Pregunta`) AS `Cantidad`  , (SUM(`so_tipo_pregunta_respuesta`.`VCuantitativo`)/COUNT(`h_so_cuestionario_detalle`.`Id_Pregunta`)) total  ,so_tipo_pregunta_dimension.`FA_R1I`  ,so_tipo_pregunta_dimension.`FA_R1S`  ,so_tipo_pregunta_dimension.`FA_R2I`  ,so_tipo_pregunta_dimension.`FA_R2S`  ,so_tipo_pregunta_dimension.`FA_R3I`  ,so_tipo_pregunta_dimension.`FA_R3S`  ,so_tipo_pregunta_dimension.`FA_R4I`  ,so_tipo_pregunta_dimension.`FA_R4S`  ,so_tipo_pregunta_dimension.`FA_R5I`  ,so_tipo_pregunta_dimension.`FA_R5S`  FROM  `h_so_cuestionario_detalle`   INNER JOIN `h_so_cuestionarios_encabezado`  ON (`h_so_cuestionario_detalle`.`Id_Cuestionario` = `h_so_cuestionarios_encabezado`.`Id`)  INNER JOIN `so_tipo_preguntas`  ON (`h_so_cuestionario_detalle`.`Id_Pregunta` = `so_tipo_preguntas`.`Id`)  INNER JOIN `so_tipo_cuestionario`  ON (`h_so_cuestionarios_encabezado`.`Id_Cuestionario` = `so_tipo_cuestionario`.`Id`)  INNER JOIN `so_tipo_pregunta_dimension`  \tON (`so_tipo_preguntas`.`Id_Dimension` = `so_tipo_pregunta_dimension`.`Id`)  INNER JOIN `so_tipo_pregunta_dominio`  \tON (`so_tipo_pregunta_dimension`.`Id_Dominio` = `so_tipo_pregunta_dominio`.`Id`)   INNER JOIN `so_tipo_respuesta`  \tON (`h_so_cuestionario_detalle`.`Id_Respuesta` = `so_tipo_respuesta`.`Id`)   INNER JOIN `so_tipo_pregunta_respuesta`  \tON (`so_tipo_pregunta_respuesta`.`Id_Pregunta` = `so_tipo_preguntas`.`Id`) AND (`so_tipo_pregunta_respuesta`.`Id_Tipo_Respuesta` = `so_tipo_respuesta`.`Id`)  WHERE (h_so_cuestionarios_encabezado.`Id_Cuestionario`=8 AND `h_so_cuestionarios_encabezado`.`FechaR`>='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND `h_so_cuestionarios_encabezado`.`FechaR`<='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' AND `h_so_cuestionarios_encabezado`.`Estado`=1)  GROUP BY `so_tipo_pregunta_dimension`.`Id`) AS interno ";
        String sql2 = "SELECT *,IF(interno.idDimension=32, IF(interno.total >= interno.FA_R1I AND interno.total<= interno.FA_R1S,'Sin riesgo o riesgo despreciable',  IF(interno.total >= interno.FA_R2I AND interno.total<= interno.FA_R2S,'Riesgo Bajo',IF(interno.total >= interno.FA_R3I AND interno.total<= interno.FA_R3S,'Riesgo Medio',  IF(interno.total >= interno.FA_R4I AND interno.total<= interno.FA_R4S,'Riesgo Alto','Riesgo muy Alto')))),  IF(interno.idDimension=33,IF(interno.total >= interno.FA_R1I AND interno.total<= interno.FA_R1S,'Sin riesgo o riesgo despreciable',  IF(interno.total >= interno.FA_R2I AND interno.total<= interno.FA_R2S,'Riesgo Bajo',IF(interno.total >= interno.FA_R3I AND interno.total<= interno.FA_R3S,'Riesgo Medio',  IF(interno.total >= interno.FA_R4I AND interno.total<= interno.FA_R4S,'Riesgo Alto','Riesgo muy Alto')))),  IF(interno.idDimension=34,IF(interno.total >= interno.FA_R1I AND interno.total<= interno.FA_R1S,'Sin riesgo o riesgo despreciable',  IF(interno.total >= interno.FA_R2I AND interno.total<= interno.FA_R2S,'Riesgo Bajo',IF(interno.total >= interno.FA_R3I AND interno.total<= interno.FA_R3S,'Riesgo Medio',  IF(interno.total >= interno.FA_R4I AND interno.total<= interno.FA_R4S,'Riesgo Alto','Riesgo muy Alto')))),  IF(interno.idDimension=35,IF(interno.total >= interno.FA_R1I AND interno.total<= interno.FA_R1S,'Sin riesgo o riesgo despreciable',  IF(interno.total >= interno.FA_R2I AND interno.total<= interno.FA_R2S,'Riesgo Bajo',IF(interno.total >= interno.FA_R3I AND interno.total<= interno.FA_R3S,'Riesgo Medio',  IF(interno.total >= interno.FA_R4I AND interno.total<= interno.FA_R4S,'Riesgo Alto','Riesgo muy Alto')))),  IF(interno.idDimension=36,IF(interno.total >= interno.FA_R1I AND interno.total<= interno.FA_R1S,'Sin riesgo o riesgo despreciable',  IF(interno.total >= interno.FA_R2I AND interno.total<= interno.FA_R2S,'Riesgo Bajo',IF(interno.total >= interno.FA_R3I AND interno.total<= interno.FA_R3S,'Riesgo Medio',  IF(interno.total >= interno.FA_R4I AND interno.total<= interno.FA_R4S,'Riesgo Alto','Riesgo muy Alto')))),  IF(interno.idDimension=37,IF(interno.total >= interno.FA_R1I AND interno.total<= interno.FA_R1S,'Sin riesgo o riesgo despreciable',  IF(interno.total >= interno.FA_R2I AND interno.total<= interno.FA_R2S,'Riesgo Bajo',IF(interno.total >= interno.FA_R3I AND interno.total<= interno.FA_R3S,'Riesgo Medio',  IF(interno.total >= interno.FA_R4I AND interno.total<= interno.FA_R4S,'Riesgo Alto','Riesgo muy Alto')))),  IF(interno.idDimension=38,IF(interno.total >= interno.FA_R1I AND interno.total<= interno.FA_R1S,'Sin riesgo o riesgo despreciable',  IF(interno.total >= interno.FA_R2I AND interno.total<= interno.FA_R2S,'Riesgo Bajo',IF(interno.total >= interno.FA_R3I AND interno.total<= interno.FA_R3S,'Riesgo Medio',  IF(interno.total >= interno.FA_R4I AND interno.total<= interno.FA_R4S,'Riesgo Alto','Riesgo muy Alto')))),  '--validando'))))))) AS Calificacion  FROM(  SELECT `so_tipo_pregunta_dominio`.`Nbre` AS `Dominio`  , so_tipo_pregunta_dimension.`Id` AS idDimension  , `so_tipo_pregunta_dimension`.`Nbre` AS `Dimension`  , SUM(`so_tipo_pregunta_respuesta`.`VCuantitativo`) AS `SValor`  , COUNT(`h_so_cuestionario_detalle`.`Id_Pregunta`) AS `Cantidad`  , (SUM(`so_tipo_pregunta_respuesta`.`VCuantitativo`)/COUNT(`h_so_cuestionario_detalle`.`Id_Pregunta`)) total  ,so_tipo_pregunta_dimension.`FA_R1I`  ,so_tipo_pregunta_dimension.`FA_R1S`  ,so_tipo_pregunta_dimension.`FA_R2I`  ,so_tipo_pregunta_dimension.`FA_R2S`  ,so_tipo_pregunta_dimension.`FA_R3I`  ,so_tipo_pregunta_dimension.`FA_R3S`  ,so_tipo_pregunta_dimension.`FA_R4I`  ,so_tipo_pregunta_dimension.`FA_R4S`  ,so_tipo_pregunta_dimension.`FA_R5I`  ,so_tipo_pregunta_dimension.`FA_R5S` ,g_tipounidadnegocio.`Nbre` AS UnidadNeg FROM  `h_so_cuestionario_detalle`   INNER JOIN `h_so_cuestionarios_encabezado`  ON (`h_so_cuestionario_detalle`.`Id_Cuestionario` = `h_so_cuestionarios_encabezado`.`Id`)  INNER JOIN `so_tipo_preguntas`  ON (`h_so_cuestionario_detalle`.`Id_Pregunta` = `so_tipo_preguntas`.`Id`)  INNER JOIN `so_tipo_cuestionario`  ON (`h_so_cuestionarios_encabezado`.`Id_Cuestionario` = `so_tipo_cuestionario`.`Id`)  INNER JOIN `so_tipo_pregunta_dimension`  \tON (`so_tipo_preguntas`.`Id_Dimension` = `so_tipo_pregunta_dimension`.`Id`)  INNER JOIN `so_tipo_pregunta_dominio`  \tON (`so_tipo_pregunta_dimension`.`Id_Dominio` = `so_tipo_pregunta_dominio`.`Id`)   INNER JOIN `so_tipo_respuesta`  \tON (`h_so_cuestionario_detalle`.`Id_Respuesta` = `so_tipo_respuesta`.`Id`)   INNER JOIN `so_tipo_pregunta_respuesta`  \tON (`so_tipo_pregunta_respuesta`.`Id_Pregunta` = `so_tipo_preguntas`.`Id`) AND (`so_tipo_pregunta_respuesta`.`Id_Tipo_Respuesta` = `so_tipo_respuesta`.`Id`)  INNER JOIN `g_usuario_fpz`  ON (`h_so_cuestionarios_encabezado`.`Id_Usuario` = `g_usuario_fpz`.`Id_Persona`)  INNER JOIN `g_tipounidadnegocio`  ON (`g_usuario_fpz`.`Id_UnidadN` = `g_tipounidadnegocio`.`Id`)  WHERE (h_so_cuestionarios_encabezado.`Id_Cuestionario`=8 AND `h_so_cuestionarios_encabezado`.`FechaR`>='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND `h_so_cuestionarios_encabezado`.`FechaR`<='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' AND `h_so_cuestionarios_encabezado`.`Estado`=1)  GROUP BY `g_usuario_fpz`.`Id_UnidadN`,`so_tipo_pregunta_dimension`.`Id` ORDER BY g_tipounidadnegocio.`Nbre`, `so_tipo_pregunta_dimension`.`Id`) AS interno ";
        System.out.println("Consolidado-------->" + sql);
        System.out.println("Detallado-------->" + sql2);
        ResultSet xrsC = this.xct.traerRs(sql);
        ResultSet xrsD = this.xct.traerRs(sql2);
        try {
            if (xrsC.next()) {
                xrsC.beforeFirst();
                int n = 0;
                while (xrsC.next()) {
                    this.xmodeloConsolidado.addRow(this.xdatos);
                    this.xmodeloConsolidado.setValueAt(xrsC.getString("Dominio"), n, 0);
                    this.xmodeloConsolidado.setValueAt(xrsC.getString("Dimension"), n, 1);
                    this.xmodeloConsolidado.setValueAt(Double.valueOf(xrsC.getDouble("SValor")), n, 2);
                    this.xmodeloConsolidado.setValueAt(Double.valueOf(xrsC.getDouble("Cantidad")), n, 3);
                    this.xmodeloConsolidado.setValueAt(Double.valueOf(xrsC.getDouble("total")), n, 4);
                    this.xmodeloConsolidado.setValueAt(xrsC.getString("Calificacion"), n, 5);
                    n++;
                }
            }
            if (xrsD.next()) {
                xrsD.beforeFirst();
                int n2 = 0;
                while (xrsD.next()) {
                    this.xmodeloDetall.addRow(this.xdatos);
                    this.xmodeloDetall.setValueAt(xrsD.getString("Dominio"), n2, 0);
                    this.xmodeloDetall.setValueAt(xrsD.getString("Dimension"), n2, 1);
                    this.xmodeloDetall.setValueAt(Double.valueOf(xrsD.getDouble("SValor")), n2, 2);
                    this.xmodeloDetall.setValueAt(Double.valueOf(xrsD.getDouble("Cantidad")), n2, 3);
                    this.xmodeloDetall.setValueAt(Double.valueOf(xrsD.getDouble("total")), n2, 4);
                    this.xmodeloDetall.setValueAt(xrsD.getString("UnidadNeg"), n2, 5);
                    this.xmodeloDetall.setValueAt(xrsD.getString("Calificacion"), n2, 6);
                    n2++;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(JIFResultadoBateria.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mBuscar() {
        if (this.xidFormato[this.JCBFormato.getSelectedIndex()].equals("8")) {
            mBuscaExtralaboralC();
            mBuscaDetalleUsuarioExtra();
        } else {
            mBuscarFormatos1();
            mBuscaDetalleUsuario();
        }
    }

    private void mBuscarFormatos1() {
        if (this.JCBFormato.getSelectedIndex() != -1) {
            if (this.JRBDimension.isSelected()) {
                mBuscarFormatos();
                return;
            }
            List<IEncabezadoCuestionarioSaludOcupacional> list = this.cuestionarioSaludOcupacionalService.informeConsolidadCuestionarioSaludOcupacional(this.JDFechaI.getDate(), this.JDFechaF.getDate(), Integer.valueOf(this.xidFormato[this.JCBFormato.getSelectedIndex()]));
            if (!list.isEmpty()) {
                mCreaModeloConsolidado("Dominio");
                list.forEach(item -> {
                    this.xmodeloConsolidado.addRow(this.xdatos);
                    this.xmodeloConsolidado.setValueAt(item.getDominio(), this.JTConsolidado.getRowCount() - 1, 0);
                    this.xmodeloConsolidado.setValueAt(item.getDimension(), this.JTConsolidado.getRowCount() - 1, 1);
                    this.xmodeloConsolidado.setValueAt(item.getValorBruto(), this.JTConsolidado.getRowCount() - 1, 2);
                    this.xmodeloConsolidado.setValueAt(item.getValorTransformado(), this.JTConsolidado.getRowCount() - 1, 3);
                    this.xmodeloConsolidado.setValueAt(item.getValorCualitativo(), this.JTConsolidado.getRowCount() - 1, 4);
                    this.xmodeloConsolidado.setValueAt(item.getNumeroPreguntas(), this.JTConsolidado.getRowCount() - 1, 5);
                    this.xmodeloConsolidado.setValueAt(item.getPromedioPregunta(), this.JTConsolidado.getRowCount() - 1, 6);
                });
            }
            List<IDetalleAdicionalCuestionarioSaludOcupacional> listDetalle = this.cuestionarioSaludOcupacionalService.informeConsolidadUnidadNegocioCuestionarioSaludOcupacional(this.JDFechaI.getDate(), this.JDFechaF.getDate(), Integer.valueOf(this.xidFormato[this.JCBFormato.getSelectedIndex()]));
            if (!listDetalle.isEmpty()) {
                mCreaModeloDetalle();
                listDetalle.forEach(item2 -> {
                    this.xmodeloDetall.addRow(this.xdatos);
                    this.xmodeloDetall.setValueAt(item2.getDominio(), this.JTDetalle.getRowCount() - 1, 0);
                    this.xmodeloDetall.setValueAt(item2.getDimension(), this.JTDetalle.getRowCount() - 1, 1);
                    this.xmodeloDetall.setValueAt(item2.getValorBruto(), this.JTDetalle.getRowCount() - 1, 2);
                    this.xmodeloDetall.setValueAt(item2.getValorTransformado(), this.JTDetalle.getRowCount() - 1, 3);
                    this.xmodeloDetall.setValueAt(item2.getValorCualitativo(), this.JTDetalle.getRowCount() - 1, 4);
                    this.xmodeloDetall.setValueAt(item2.getUnidadNegocio(), this.JTDetalle.getRowCount() - 1, 5);
                });
                return;
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar el formato", "VERIFICAR", 1);
        this.JCBFormato.requestFocus();
    }

    public void mBuscarFormatos() {
        String sqlC = null;
        String sqlD = null;
        mCreaModeloDetalle();
        ConsultasMySQL mySQL = new ConsultasMySQL();
        if (this.JCBFormato.getSelectedIndex() != -1) {
            if (this.JRBDimension.isSelected()) {
                mCreaModeloConsolidado("Dimensión");
                if (this.xidFormato[this.JCBFormato.getSelectedIndex()].equals("7")) {
                    sqlC = "WITH  maestra AS (\nSELECT `so_tipo_pregunta_dominio`.`Nbre` AS Dominio , `so_tipo_pregunta_dimension`.`Nbre` AS `NDimension` ,\n `so_tipo_cuestionario`.Nbre AS nombreCuestionario,\nround(IF(so_tipo_pregunta_dimension.`FFormaA`=0,(SUM(`so_tipo_pregunta_respuesta`.`VCuantitativo`)/COUNT(`h_so_cuestionario_detalle`.`Id_Pregunta`)), (((SUM(`so_tipo_pregunta_respuesta`.`VCuantitativo`)/COUNT(`h_so_cuestionario_detalle`.`Id_Pregunta`)))*so_tipo_pregunta_dimension.`FFormaA`)), 2) AS `VBruto`  ,\n\nround(IF(so_tipo_pregunta_dimension.`FFormaA`=0, ((SUM(`so_tipo_pregunta_respuesta`.`VCuantitativo`)/COUNT(`h_so_cuestionario_detalle`.`Id_Pregunta`))/so_tipo_pregunta_dominio.`FFormaA`)*100,\n ((((SUM(`so_tipo_pregunta_respuesta`.`VCuantitativo`)/COUNT(`h_so_cuestionario_detalle`.`Id_Pregunta`)))*so_tipo_pregunta_dimension.`FFormaA`)/so_tipo_pregunta_dominio.`FFormaA`)*100),2)  AS VTransformado\n   , COUNT(`so_tipo_pregunta_respuesta`.`VCuantitativo`) AS NP,\n     ((SUM(`so_tipo_pregunta_respuesta`.`VCuantitativo`)/COUNT(`h_so_cuestionario_detalle`.`Id_Pregunta`))/COUNT(`h_so_cuestionario_detalle`.`Id_Pregunta`)) AS ns  \n\nFROM `h_so_cuestionario_detalle` \nINNER JOIN `h_so_cuestionarios_encabezado` ON (`h_so_cuestionario_detalle`.`Id_Cuestionario` = `h_so_cuestionarios_encabezado`.`Id`)  \nINNER JOIN `so_tipo_preguntas` ON (`h_so_cuestionario_detalle`.`Id_Pregunta` = `so_tipo_preguntas`.`Id`)  \nINNER JOIN `so_tipo_respuesta` ON (`h_so_cuestionario_detalle`.`Id_Respuesta` = `so_tipo_respuesta`.`Id`)  \nINNER JOIN `so_tipo_pregunta_respuesta` ON (`so_tipo_pregunta_respuesta`.`Id_Pregunta` = `so_tipo_preguntas`.`Id`)\n AND (`so_tipo_pregunta_respuesta`.`Id_Tipo_Respuesta` = `so_tipo_respuesta`.`Id`)  \n INNER JOIN `so_tipo_pregunta_dimension` ON (`so_tipo_preguntas`.`Id_Dimension` = `so_tipo_pregunta_dimension`.`Id`)  \n INNER JOIN `so_tipo_pregunta_dominio` ON (`so_tipo_pregunta_dimension`.`Id_Dominio` = `so_tipo_pregunta_dominio`.`Id`)  \n INNER JOIN `so_tipo_cuestionario` ON (`h_so_cuestionarios_encabezado`.`Id_Cuestionario` = `so_tipo_cuestionario`.`Id`)  \nWHERE (`so_tipo_cuestionario`.`Id`='" + this.xidFormato[this.JCBFormato.getSelectedIndex()] + "' AND  `h_so_cuestionarios_encabezado`.`Estado`=1\n AND h_so_cuestionarios_encabezado.`FechaR` BETWEEN '" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND '" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "')  \n GROUP BY   `Id_Dimension`  ORDER BY `so_tipo_pregunta_dominio`.`Orden` ASC, `so_tipo_pregunta_dimension`.`Orden` ASC, `so_tipo_preguntas`.`Orden` ASC\n),\n\nagrupacion as (\n\tselect \n\tm.Dominio,\n\tm.NDimension,\n\t m.nombreCuestionario,\n\tsum(m.VBruto) VBruto  ,\n\tsum(m.VTransformado) VTransformado, \n\tm.NP,\n     m.ns  \n\tfrom maestra m\n)\n,\ndetalle AS (\nSELECT *,\nCASE nombreCuestionario  \n  WHEN 'EVALUACION DEL ESTRES' \n  THEN \n     CASE \n\tWHEN VTransformado>= 0.0 AND VTransformado<=7.8\t\t\n\tTHEN 'Muy bajo'\n\t\n\tWHEN VTransformado>= 7.9 AND VTransformado<=12.6\t\t\n\tTHEN 'Bajo'\n\t\n\tWHEN VTransformado>= 12.7 AND VTransformado<=17.7\t\t\n\tTHEN 'Medio'\n\t\n\tWHEN VTransformado>= 17.8 AND VTransformado<=25.0\t\t\n\tTHEN 'Alto'\n\t\n\tWHEN VTransformado>= 25.0 AND VTransformado<=1000\t\t\n\tTHEN 'Muy alto'\n\t\n     END\n      \t\n  \n \nEND AS valorCualitativo\n\n\nFROM   agrupacion \n )\n select detalle.Dominio, detalle.NDimension, detalle.VBruto\n, ifnull(detalle.VTransformado,0)valorTransformado, ifnull(detalle.valorCualitativo,0) valorCualitativo, detalle.NP, detalle.ns\n from detalle";
                    sqlD = "WITH  maestra AS (\nSELECT `so_tipo_pregunta_dominio`.`Nbre` AS Dominio , `so_tipo_pregunta_dimension`.`Nbre` AS `NDimension` ,\n `so_tipo_cuestionario`.Nbre AS nombreCuestionario,\nround(IF(so_tipo_pregunta_dimension.`FFormaA`=0,(SUM(`so_tipo_pregunta_respuesta`.`VCuantitativo`)/COUNT(`h_so_cuestionario_detalle`.`Id_Pregunta`)), (((SUM(`so_tipo_pregunta_respuesta`.`VCuantitativo`)/COUNT(`h_so_cuestionario_detalle`.`Id_Pregunta`)))*so_tipo_pregunta_dimension.`FFormaA`)), 2) AS `VBruto`  ,\n\nround(IF(so_tipo_pregunta_dimension.`FFormaA`=0, ((SUM(`so_tipo_pregunta_respuesta`.`VCuantitativo`)/COUNT(`h_so_cuestionario_detalle`.`Id_Pregunta`))/so_tipo_pregunta_dominio.`FFormaA`)*100,\n ((((SUM(`so_tipo_pregunta_respuesta`.`VCuantitativo`)/COUNT(`h_so_cuestionario_detalle`.`Id_Pregunta`)))*so_tipo_pregunta_dimension.`FFormaA`)/so_tipo_pregunta_dominio.`FFormaA`)*100),2)  AS VTransformado\n   , COUNT(`so_tipo_pregunta_respuesta`.`VCuantitativo`) AS NP,\n     ((SUM(`so_tipo_pregunta_respuesta`.`VCuantitativo`)/COUNT(`h_so_cuestionario_detalle`.`Id_Pregunta`))/COUNT(`h_so_cuestionario_detalle`.`Id_Pregunta`)) AS ns  \n , g_tipounidadnegocio.`Nbre` AS unidad_negocio \n , `g_usuario_fpz`.`Id_UnidadN`\n\nFROM `h_so_cuestionario_detalle` \nINNER JOIN `h_so_cuestionarios_encabezado` ON (`h_so_cuestionario_detalle`.`Id_Cuestionario` = `h_so_cuestionarios_encabezado`.`Id`)  \nINNER JOIN `so_tipo_preguntas` ON (`h_so_cuestionario_detalle`.`Id_Pregunta` = `so_tipo_preguntas`.`Id`)  \nINNER JOIN `so_tipo_respuesta` ON (`h_so_cuestionario_detalle`.`Id_Respuesta` = `so_tipo_respuesta`.`Id`)  \nINNER JOIN `so_tipo_pregunta_respuesta` ON (`so_tipo_pregunta_respuesta`.`Id_Pregunta` = `so_tipo_preguntas`.`Id`)\n AND (`so_tipo_pregunta_respuesta`.`Id_Tipo_Respuesta` = `so_tipo_respuesta`.`Id`)  \n INNER JOIN `so_tipo_pregunta_dimension` ON (`so_tipo_preguntas`.`Id_Dimension` = `so_tipo_pregunta_dimension`.`Id`)  \n INNER JOIN `so_tipo_pregunta_dominio` ON (`so_tipo_pregunta_dimension`.`Id_Dominio` = `so_tipo_pregunta_dominio`.`Id`)  \n INNER JOIN `so_tipo_cuestionario` ON (`h_so_cuestionarios_encabezado`.`Id_Cuestionario` = `so_tipo_cuestionario`.`Id`)  \n   INNER JOIN `g_usuario_fpz`  ON (`h_so_cuestionarios_encabezado`.`Id_Usuario` = `g_usuario_fpz`.`Id_Persona`) \n INNER JOIN `g_tipounidadnegocio` ON (`g_usuario_fpz`.`Id_UnidadN` = `g_tipounidadnegocio`.`Id`)\nWHERE (`so_tipo_cuestionario`.`Id`='" + this.xidFormato[this.JCBFormato.getSelectedIndex()] + "' AND  `h_so_cuestionarios_encabezado`.`Estado`=1\n AND h_so_cuestionarios_encabezado.`FechaR` BETWEEN '" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND '" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "')  \n GROUP BY   `g_usuario_fpz`.`Id_UnidadN`,  `Id_Dimension`     \n ORDER BY g_tipounidadnegocio.`Nbre`, `so_tipo_pregunta_dominio`.`Orden` ASC, `so_tipo_pregunta_dimension`.`Orden` ASC, `so_tipo_preguntas`.`Orden` ASC\n),\n\nagrupacion as (\n\tselect \n\tm.Dominio,\n\tm.NDimension,\n\t m.nombreCuestionario,\n\tsum(m.VBruto) VBruto  ,\n\tsum(m.VTransformado) VTransformado, \n\tm.NP,\n     m.ns , \n    m.unidad_negocio\n     \n\tfrom maestra m\n\tgroup by m.Id_UnidadN\n)\n,\ndetalle AS (\nSELECT *,\nCASE nombreCuestionario  \n  WHEN 'EVALUACION DEL ESTRES' \n  THEN \n     CASE \n\tWHEN VTransformado>= 0.0 AND VTransformado<=7.8\t\t\n\tTHEN 'Muy bajo'\n\t\n\tWHEN VTransformado>= 7.9 AND VTransformado<=12.6\t\t\n\tTHEN 'Bajo'\n\t\n\tWHEN VTransformado>= 12.7 AND VTransformado<=17.7\t\t\n\tTHEN 'Medio'\n\t\n\tWHEN VTransformado>= 17.8 AND VTransformado<=25.0\t\t\n\tTHEN 'Alto'\n\t\n\tWHEN VTransformado>= 25.0 AND VTransformado<=1000\t\t\n\tTHEN 'Muy alto'\n\t\n     END\n      \t\n  \n \nEND AS valorCualitativo\n\n\nFROM   agrupacion \n )\n select detalle.Dominio, '' NDimension, detalle.VBruto\n, ifnull(detalle.VTransformado,0)valorTransformado, ifnull(detalle.valorCualitativo,0) valorCualitativo, detalle.NP, detalle.ns, detalle.unidad_negocio\n from detalle";
                } else {
                    sqlC = "WITH  maestra AS (\nSELECT `so_tipo_pregunta_dominio`.`Nbre` AS Dominio , `so_tipo_pregunta_dimension`.`Nbre` AS `NDimension` ,\n `so_tipo_cuestionario`.Nbre AS nombreCuestionario,\n IF(`so_tipo_cuestionario`.`Nbre`='EVALUACION DEL ESTRES',IF(so_tipo_pregunta_dimension.`FFormaA`=0,(SUM(`so_tipo_pregunta_respuesta`.`VCuantitativo`)/COUNT(`h_so_cuestionario_detalle`.`Id_Pregunta`)), (((SUM(`so_tipo_pregunta_respuesta`.`VCuantitativo`)/COUNT(`h_so_cuestionario_detalle`.`Id_Pregunta`)))*so_tipo_pregunta_dimension.`FFormaA`)), (SUM(`so_tipo_pregunta_respuesta`.`VCuantitativo`)/COUNT(`h_so_cuestionario_detalle`.`Id_Pregunta`))) AS `VBruto`  ,\n ROUND(IF(`so_tipo_cuestionario`.`Nbre`='FORMA B INTRALABORAL' , (((SUM(`so_tipo_pregunta_respuesta`.`VCuantitativo`)/COUNT(`h_so_cuestionario_detalle`.`Id_Pregunta`))/`so_tipo_pregunta_dominio`.`FFormaB`)*100)  ,\n  IF(`so_tipo_cuestionario`.`Nbre`='EVALUACION DEL ESTRES',  IF(so_tipo_pregunta_dimension.`FFormaA`=0, ((SUM(`so_tipo_pregunta_respuesta`.`VCuantitativo`)/COUNT(`h_so_cuestionario_detalle`.`Id_Pregunta`))/so_tipo_pregunta_dominio.`FFormaA`)*100,\n ((((SUM(`so_tipo_pregunta_respuesta`.`VCuantitativo`)/COUNT(`h_so_cuestionario_detalle`.`Id_Pregunta`)))*so_tipo_pregunta_dimension.`FFormaA`)/so_tipo_pregunta_dominio.`FFormaA`)*100) ,(((SUM(`so_tipo_pregunta_respuesta`.`VCuantitativo`)/COUNT(`h_so_cuestionario_detalle`.`Id_Pregunta`))/\n   `so_tipo_pregunta_dominio`.`FFormaA`)*100))),1) AS VTransformado\n   , COUNT(`so_tipo_pregunta_respuesta`.`VCuantitativo`) AS NP,\n     ((SUM(`so_tipo_pregunta_respuesta`.`VCuantitativo`)/COUNT(`h_so_cuestionario_detalle`.`Id_Pregunta`))/COUNT(`h_so_cuestionario_detalle`.`Id_Pregunta`)) AS ns  \n , `so_tipo_pregunta_dominio`.`FB_R1I`\n , `so_tipo_pregunta_dominio`.`FB_R1S`\n , `so_tipo_pregunta_dominio`.`FB_R2I`\n , `so_tipo_pregunta_dominio`.`FB_R2S`\n , `so_tipo_pregunta_dominio`.`FB_R3I`\n , `so_tipo_pregunta_dominio`.`FB_R3S`\n , `so_tipo_pregunta_dominio`.`FB_R4I`\n , `so_tipo_pregunta_dominio`.`FB_R4S`\n , `so_tipo_pregunta_dominio`.`FB_R5I`\n , `so_tipo_pregunta_dominio`.`FB_R5S`\n , `so_tipo_pregunta_dominio`.`FA_R1I`\n , `so_tipo_pregunta_dominio`.`FA_R1S`\n , `so_tipo_pregunta_dominio`.`FA_R2I`\n , `so_tipo_pregunta_dominio`.`FA_R2S`\n , `so_tipo_pregunta_dominio`.`FA_R3I`\n , `so_tipo_pregunta_dominio`.`FA_R3S`\n , `so_tipo_pregunta_dominio`.`FA_R4I`\n , `so_tipo_pregunta_dominio`.`FA_R4S`\n , `so_tipo_pregunta_dominio`.`FA_R5I`\n , `so_tipo_pregunta_dominio`.`FA_R5S`\nFROM `h_so_cuestionario_detalle` \nINNER JOIN `h_so_cuestionarios_encabezado` ON (`h_so_cuestionario_detalle`.`Id_Cuestionario` = `h_so_cuestionarios_encabezado`.`Id`)  \nINNER JOIN `so_tipo_preguntas` ON (`h_so_cuestionario_detalle`.`Id_Pregunta` = `so_tipo_preguntas`.`Id`)  \nINNER JOIN `so_tipo_respuesta` ON (`h_so_cuestionario_detalle`.`Id_Respuesta` = `so_tipo_respuesta`.`Id`)  \nINNER JOIN `so_tipo_pregunta_respuesta` ON (`so_tipo_pregunta_respuesta`.`Id_Pregunta` = `so_tipo_preguntas`.`Id`)\n AND (`so_tipo_pregunta_respuesta`.`Id_Tipo_Respuesta` = `so_tipo_respuesta`.`Id`)  \n INNER JOIN `so_tipo_pregunta_dimension` ON (`so_tipo_preguntas`.`Id_Dimension` = `so_tipo_pregunta_dimension`.`Id`)  \n INNER JOIN `so_tipo_pregunta_dominio` ON (`so_tipo_pregunta_dimension`.`Id_Dominio` = `so_tipo_pregunta_dominio`.`Id`)  \n INNER JOIN `so_tipo_cuestionario` ON (`h_so_cuestionarios_encabezado`.`Id_Cuestionario` = `so_tipo_cuestionario`.`Id`)  \nWHERE (`so_tipo_cuestionario`.`Id`='" + this.xidFormato[this.JCBFormato.getSelectedIndex()] + "' AND  `h_so_cuestionarios_encabezado`.`Estado`=1\n AND h_so_cuestionarios_encabezado.`FechaR` BETWEEN '" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND '" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "')  \n GROUP BY   `Id_Dimension`  ORDER BY `so_tipo_pregunta_dominio`.`Orden` ASC, `so_tipo_pregunta_dimension`.`Orden` ASC, `so_tipo_preguntas`.`Orden` ASC\n),\ndetalle AS (\nSELECT *,\nCASE nombreCuestionario  \n  WHEN 'EVALUACION DEL ESTRES' \n  THEN \n     CASE \n\tWHEN VTransformado>= 0.0 AND VTransformado<=7.8\t\t\n\tTHEN 'Muy bajo'\n\t\n\tWHEN VTransformado>= 7.9 AND VTransformado<=12.6\t\t\n\tTHEN 'Bajo'\n\t\n\tWHEN VTransformado>= 12.7 AND VTransformado<=17.7\t\t\n\tTHEN 'Medio'\n\t\n\tWHEN VTransformado>= 17.8 AND VTransformado<=25.0\t\t\n\tTHEN 'Alto'\n\t\n\tWHEN VTransformado>= 25.0 AND VTransformado<=100\t\t\n\tTHEN 'Muy alto'\n\t\n     END\n      \t\n   WHEN 'FORMA B INTRALABORAL'\n   THEN \n     CASE \n\tWHEN VTransformado>= FB_R1I AND VTransformado<=FB_R1S\t\t\n\tTHEN 'Sin riesgo o riesgo despreciable'\n\t\n\tWHEN  VTransformado>= FB_R2I AND VTransformado<=FB_R2S\t\t\t\n\tTHEN 'Riesgo bajo'\n\t\n\tWHEN  VTransformado>= FB_R3I AND VTransformado<=FB_R3S\t\t\t\n\tTHEN  'Riesgo medio'\n\t\n\tWHEN VTransformado>= FB_R4I AND VTransformado<=FB_R4S\t\t\t\n\tTHEN 'Riesgo alto'\n\t\n\tWHEN VTransformado>= FB_R5I AND VTransformado<=FB_R5S\t\t\t\n\tTHEN 'Riesgo alto'\n\t\n\tELSE  'Valor no clasificado'\n\t\n     END  \n\t\n     WHEN 'FORMA A INTRALABORAL'\n   THEN \n     CASE \n\tWHEN VTransformado>= FA_R1I AND VTransformado<=FA_R1S\t\t\n\tTHEN 'Sin riesgo o riesgo despreciable'\n\t\n\tWHEN  VTransformado>= FA_R2I AND VTransformado<=FA_R2S\t\t\t\n\tTHEN 'Riesgo bajo'\n\t\n\tWHEN  VTransformado>= FA_R3I AND VTransformado<=FA_R3S\t\t\t\n\tTHEN  'Riesgo medio'\n\t\n\tWHEN VTransformado>= FA_R4I AND VTransformado<=FA_R4S\t\t\t\n\tTHEN 'Riesgo alto'\n\t\n\tWHEN VTransformado>= FA_R5I AND VTransformado<=FA_R5S\t\t\t\n\tTHEN 'Riesgo alto'\n\t\n\tELSE  'Valor no clasificado'\t\t\n\t\n     END  \t\n \nEND AS valorCualitativo\n\n\nFROM   maestra \n )\n select detalle.Dominio, '' NDimension, detalle.VBruto\n, ifnull(detalle.VTransformado,0), ifnull(detalle.valorCualitativo,0), detalle.NP, detalle.ns\n from detalle";
                    sqlD = "WITH  maestra AS (\nSELECT `so_tipo_pregunta_dominio`.`Nbre` AS Dominio , `so_tipo_pregunta_dimension`.`Nbre` AS `NDimension` ,\n `so_tipo_cuestionario`.Nbre AS nombreCuestionario,\n IF(`so_tipo_cuestionario`.`Nbre`='EVALUACION DEL ESTRES',IF(so_tipo_pregunta_dimension.`FFormaA`=0,(SUM(`so_tipo_pregunta_respuesta`.`VCuantitativo`)/COUNT(`h_so_cuestionario_detalle`.`Id_Pregunta`)), (((SUM(`so_tipo_pregunta_respuesta`.`VCuantitativo`)/COUNT(`h_so_cuestionario_detalle`.`Id_Pregunta`)))*so_tipo_pregunta_dimension.`FFormaA`)), (SUM(`so_tipo_pregunta_respuesta`.`VCuantitativo`)/COUNT(`h_so_cuestionario_detalle`.`Id_Pregunta`))) AS `VBruto`  ,\n ROUND(IF(`so_tipo_cuestionario`.`Nbre`='FORMA B INTRALABORAL' , (((SUM(`so_tipo_pregunta_respuesta`.`VCuantitativo`)/COUNT(`h_so_cuestionario_detalle`.`Id_Pregunta`))/`so_tipo_pregunta_dominio`.`FFormaB`)*100)  ,\n  IF(`so_tipo_cuestionario`.`Nbre`='EVALUACION DEL ESTRES',  IF(so_tipo_pregunta_dimension.`FFormaA`=0, ((SUM(`so_tipo_pregunta_respuesta`.`VCuantitativo`)/COUNT(`h_so_cuestionario_detalle`.`Id_Pregunta`))/so_tipo_pregunta_dominio.`FFormaA`)*100,\n ((((SUM(`so_tipo_pregunta_respuesta`.`VCuantitativo`)/COUNT(`h_so_cuestionario_detalle`.`Id_Pregunta`)))*so_tipo_pregunta_dimension.`FFormaA`)/so_tipo_pregunta_dominio.`FFormaA`)*100) ,(((SUM(`so_tipo_pregunta_respuesta`.`VCuantitativo`)/COUNT(`h_so_cuestionario_detalle`.`Id_Pregunta`))/\n   `so_tipo_pregunta_dominio`.`FFormaA`)*100))),1) AS VTransformado\n   , COUNT(`so_tipo_pregunta_respuesta`.`VCuantitativo`) AS NP,\n     ((SUM(`so_tipo_pregunta_respuesta`.`VCuantitativo`)/COUNT(`h_so_cuestionario_detalle`.`Id_Pregunta`))/COUNT(`h_so_cuestionario_detalle`.`Id_Pregunta`)) AS ns  \n , `so_tipo_pregunta_dominio`.`FB_R1I`\n , `so_tipo_pregunta_dominio`.`FB_R1S`\n , `so_tipo_pregunta_dominio`.`FB_R2I`\n , `so_tipo_pregunta_dominio`.`FB_R2S`\n , `so_tipo_pregunta_dominio`.`FB_R3I`\n , `so_tipo_pregunta_dominio`.`FB_R3S`\n , `so_tipo_pregunta_dominio`.`FB_R4I`\n , `so_tipo_pregunta_dominio`.`FB_R4S`\n , `so_tipo_pregunta_dominio`.`FB_R5I`\n , `so_tipo_pregunta_dominio`.`FB_R5S`\n , `so_tipo_pregunta_dominio`.`FA_R1I`\n , `so_tipo_pregunta_dominio`.`FA_R1S`\n , `so_tipo_pregunta_dominio`.`FA_R2I`\n , `so_tipo_pregunta_dominio`.`FA_R2S`\n , `so_tipo_pregunta_dominio`.`FA_R3I`\n , `so_tipo_pregunta_dominio`.`FA_R3S`\n , `so_tipo_pregunta_dominio`.`FA_R4I`\n , `so_tipo_pregunta_dominio`.`FA_R4S`\n , `so_tipo_pregunta_dominio`.`FA_R5I`\n , `so_tipo_pregunta_dominio`.`FA_R5S`\n, g_tipounidadnegocio.`Nbre` AS unidad_negocio \nFROM `h_so_cuestionario_detalle` \nINNER JOIN `h_so_cuestionarios_encabezado` ON (`h_so_cuestionario_detalle`.`Id_Cuestionario` = `h_so_cuestionarios_encabezado`.`Id`)  \nINNER JOIN `so_tipo_preguntas` ON (`h_so_cuestionario_detalle`.`Id_Pregunta` = `so_tipo_preguntas`.`Id`)  \nINNER JOIN `so_tipo_respuesta` ON (`h_so_cuestionario_detalle`.`Id_Respuesta` = `so_tipo_respuesta`.`Id`)  \nINNER JOIN `so_tipo_pregunta_respuesta` ON (`so_tipo_pregunta_respuesta`.`Id_Pregunta` = `so_tipo_preguntas`.`Id`)\n AND (`so_tipo_pregunta_respuesta`.`Id_Tipo_Respuesta` = `so_tipo_respuesta`.`Id`)  \n INNER JOIN `so_tipo_pregunta_dimension` ON (`so_tipo_preguntas`.`Id_Dimension` = `so_tipo_pregunta_dimension`.`Id`)  \n INNER JOIN `so_tipo_pregunta_dominio` ON (`so_tipo_pregunta_dimension`.`Id_Dominio` = `so_tipo_pregunta_dominio`.`Id`)  \n INNER JOIN `so_tipo_cuestionario` ON (`h_so_cuestionarios_encabezado`.`Id_Cuestionario` = `so_tipo_cuestionario`.`Id`)  \n  INNER JOIN `g_usuario_fpz`  ON (`h_so_cuestionarios_encabezado`.`Id_Usuario` = `g_usuario_fpz`.`Id_Persona`) \n INNER JOIN `g_tipounidadnegocio` ON (`g_usuario_fpz`.`Id_UnidadN` = `g_tipounidadnegocio`.`Id`)\nWHERE (`so_tipo_cuestionario`.`Id`='" + this.xidFormato[this.JCBFormato.getSelectedIndex()] + "' AND  `h_so_cuestionarios_encabezado`.`Estado`=1\n AND h_so_cuestionarios_encabezado.`FechaR` BETWEEN '" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND '" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "')  \n GROUP BY  `g_usuario_fpz`.`Id_UnidadN`,  `Id_Dimension`   \n ORDER BY g_tipounidadnegocio.`Nbre`, `so_tipo_pregunta_dominio`.`Orden` ASC, `so_tipo_pregunta_dimension`.`Orden` ASC, `so_tipo_preguntas`.`Orden` ASC\n\n),\ndetalle AS (\nSELECT *,\nCASE nombreCuestionario  \n  WHEN 'EVALUACION DEL ESTRES' \n  THEN \n     CASE \n\tWHEN VTransformado>= 0.0 AND VTransformado<=7.8\t\t\n\tTHEN 'Muy bajo'\n\t\n\tWHEN VTransformado>= 7.9 AND VTransformado<=12.6\t\t\n\tTHEN 'Bajo'\n\t\n\tWHEN VTransformado>= 12.7 AND VTransformado<=17.7\t\t\n\tTHEN 'Medio'\n\t\n\tWHEN VTransformado>= 17.8 AND VTransformado<=25.0\t\t\n\tTHEN 'Alto'\n\t\n\tWHEN VTransformado>= 25.0 AND VTransformado<=100\t\t\n\tTHEN 'Muy alto'\n\t\n     END\n      \t\n   WHEN 'FORMA B INTRALABORAL'\n   THEN \n     CASE \n\tWHEN VTransformado>= FB_R1I AND VTransformado<=FB_R1S\t\t\n\tTHEN 'Sin riesgo o riesgo despreciable'\n\t\n\tWHEN  VTransformado>= FB_R2I AND VTransformado<=FB_R2S\t\t\t\n\tTHEN 'Riesgo bajo'\n\t\n\tWHEN  VTransformado>= FB_R3I AND VTransformado<=FB_R3S\t\t\t\n\tTHEN  'Riesgo medio'\n\t\n\tWHEN VTransformado>= FB_R4I AND VTransformado<=FB_R4S\t\t\t\n\tTHEN 'Riesgo alto'\n\t\n\tWHEN VTransformado>= FB_R5I AND VTransformado<=FB_R5S\t\t\t\n\tTHEN 'Riesgo alto'\n\t\n\tELSE  'Valor no clasificado'\n\t\n     END  \n\t\n     WHEN 'FORMA A INTRALABORAL'\n   THEN \n     CASE \n\tWHEN VTransformado>= FA_R1I AND VTransformado<=FA_R1S\t\t\n\tTHEN 'Sin riesgo o riesgo despreciable'\n\t\n\tWHEN  VTransformado>= FA_R2I AND VTransformado<=FA_R2S\t\t\t\n\tTHEN 'Riesgo bajo'\n\t\n\tWHEN  VTransformado>= FA_R3I AND VTransformado<=FA_R3S\t\t\t\n\tTHEN  'Riesgo medio'\n\t\n\tWHEN VTransformado>= FA_R4I AND VTransformado<=FA_R4S\t\t\t\n\tTHEN 'Riesgo alto'\n\t\n\tWHEN VTransformado>= FA_R5I AND VTransformado<=FA_R5S\t\t\t\n\tTHEN 'Riesgo alto'\n\t\n\tELSE  'Valor no clasificado'\t\t\n\t\n     END  \t\n \nEND AS valorCualitativo\n\n\nFROM   maestra \n )\nSELECT detalle.Dominio, detalle.NDimension, detalle.VBruto , ifnull(detalle.VTransformado,0), ifnull(detalle.valorCualitativo,0), detalle.NP, detalle.ns, detalle.unidad_negocio \nFROM detalle";
                }
            }
            System.out.println("Consolidado-------->" + sqlC);
            System.out.println("Detallado-------->" + sqlD);
            ResultSet xrsC = mySQL.traerRs(sqlC);
            try {
                if (xrsC.next()) {
                    xrsC.beforeFirst();
                    int n = 0;
                    while (xrsC.next()) {
                        this.xmodeloConsolidado.addRow(this.xdatos);
                        this.xmodeloConsolidado.setValueAt(xrsC.getString(1), n, 0);
                        this.xmodeloConsolidado.setValueAt(xrsC.getString(2), n, 1);
                        this.xmodeloConsolidado.setValueAt(Double.valueOf(xrsC.getDouble(3)), n, 2);
                        this.xmodeloConsolidado.setValueAt(Double.valueOf(xrsC.getDouble(4)), n, 3);
                        this.xmodeloConsolidado.setValueAt(xrsC.getString(5), n, 4);
                        this.xmodeloConsolidado.setValueAt(Double.valueOf(xrsC.getDouble(6)), n, 5);
                        this.xmodeloConsolidado.setValueAt(Double.valueOf(xrsC.getDouble(7)), n, 6);
                        n++;
                    }
                }
                ResultSet xrsD = this.xct.traerRs(sqlD);
                if (xrsD.next()) {
                    xrsD.beforeFirst();
                    int n2 = 0;
                    while (xrsD.next()) {
                        this.xmodeloDetall.addRow(this.xdatos);
                        this.xmodeloDetall.setValueAt(xrsD.getString(1), n2, 0);
                        this.xmodeloDetall.setValueAt(xrsD.getString(2), n2, 1);
                        this.xmodeloDetall.setValueAt(Double.valueOf(xrsD.getDouble(3)), n2, 2);
                        this.xmodeloDetall.setValueAt(Double.valueOf(xrsD.getDouble(4)), n2, 3);
                        this.xmodeloDetall.setValueAt(xrsD.getString(5), n2, 4);
                        this.xmodeloDetall.setValueAt(xrsD.getString(8), n2, 5);
                        n2++;
                    }
                }
                return;
            } catch (SQLException ex) {
                Logger.getLogger(JIFResultadoBateria.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                return;
            }
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar el formato", "VERIFICAR", 1);
        this.JCBFormato.requestFocus();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCreaModeloDUsuario() {
        this.xmodeloDetallU = new DefaultTableModel(new Object[0], new String[]{"Dominio", "Dimensión", "VBruto", "VTrasformado", "VCuantitativo", "Tipo Doc.", "No. Documento", "Nombre Usuario", "Sexo", "Fecha Nac", "Edad", "Unidad Nego"}) { // from class: Sig.JIFResultadoBateria.12
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalleUsuario.setModel(this.xmodeloDetallU);
        JTable jTable = this.JTDetalleUsuario;
        JTable jTable2 = this.JTDetalleUsuario;
        jTable.setAutoResizeMode(0);
        this.JTDetalleUsuario.doLayout();
        this.JTDetalleUsuario.getColumnModel().getColumn(0).setPreferredWidth(200);
        this.JTDetalleUsuario.getColumnModel().getColumn(1).setPreferredWidth(200);
        this.JTDetalleUsuario.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTDetalleUsuario.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTDetalleUsuario.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTDetalleUsuario.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTDetalleUsuario.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTDetalleUsuario.getColumnModel().getColumn(7).setPreferredWidth(250);
        this.JTDetalleUsuario.getColumnModel().getColumn(8).setPreferredWidth(100);
        this.JTDetalleUsuario.getColumnModel().getColumn(9).setPreferredWidth(100);
        this.JTDetalleUsuario.getColumnModel().getColumn(10).setPreferredWidth(100);
        this.JTDetalleUsuario.getColumnModel().getColumn(11).setPreferredWidth(250);
    }

    private void mBuscaDetalleUsuario() {
        mCreaModeloDUsuario();
        String sql = "WITH  maestra AS (\nSELECT `so_tipo_pregunta_dominio`.`Nbre` AS Dominio , `so_tipo_pregunta_dimension`.`Nbre` AS `NDimension` ,\n `so_tipo_cuestionario`.Nbre AS nombreCuestionario,\nIF(`so_tipo_cuestionario`.`Nbre`='EVALUACION DEL ESTRES',IF(so_tipo_pregunta_dimension.`FFormaA`=0,(SUM(`so_tipo_pregunta_respuesta`.`VCuantitativo`)/COUNT(`h_so_cuestionario_detalle`.`Id_Pregunta`)), (((SUM(`so_tipo_pregunta_respuesta`.`VCuantitativo`)/COUNT(`h_so_cuestionario_detalle`.`Id_Pregunta`)))*so_tipo_pregunta_dimension.`FFormaA`)), (SUM(`so_tipo_pregunta_respuesta`.`VCuantitativo`)/COUNT(`h_so_cuestionario_detalle`.`Id_Pregunta`))) AS `VBruto`  ,\n ROUND(IF(`so_tipo_cuestionario`.`Nbre`='FORMA B INTRALABORAL' , (((SUM(`so_tipo_pregunta_respuesta`.`VCuantitativo`)/COUNT(`h_so_cuestionario_detalle`.`Id_Pregunta`))/`so_tipo_pregunta_dominio`.`FFormaB`)*100)  ,\n  IF(`so_tipo_cuestionario`.`Nbre`='EVALUACION DEL ESTRES',  IF(so_tipo_pregunta_dimension.`FFormaA`=0, ((SUM(`so_tipo_pregunta_respuesta`.`VCuantitativo`)/COUNT(`h_so_cuestionario_detalle`.`Id_Pregunta`))/so_tipo_pregunta_dominio.`FFormaA`)*100,\n ((((SUM(`so_tipo_pregunta_respuesta`.`VCuantitativo`)/COUNT(`h_so_cuestionario_detalle`.`Id_Pregunta`)))*so_tipo_pregunta_dimension.`FFormaA`)/so_tipo_pregunta_dominio.`FFormaA`)*100) ,(((SUM(`so_tipo_pregunta_respuesta`.`VCuantitativo`)/COUNT(`h_so_cuestionario_detalle`.`Id_Pregunta`))/\n   `so_tipo_pregunta_dominio`.`FFormaA`)*100))),1) AS VTransformado\n   , COUNT(`so_tipo_pregunta_respuesta`.`VCuantitativo`) AS NP,\n     ((SUM(`so_tipo_pregunta_respuesta`.`VCuantitativo`)/COUNT(`h_so_cuestionario_detalle`.`Id_Pregunta`))/COUNT(`h_so_cuestionario_detalle`.`Id_Pregunta`)) AS ns  \n \n , `so_tipo_pregunta_dominio`.`FB_R1I`\n , `so_tipo_pregunta_dominio`.`FB_R1S`\n , `so_tipo_pregunta_dominio`.`FB_R2I`\n , `so_tipo_pregunta_dominio`.`FB_R2S`\n , `so_tipo_pregunta_dominio`.`FB_R3I`\n , `so_tipo_pregunta_dominio`.`FB_R3S`\n , `so_tipo_pregunta_dominio`.`FB_R4I`\n , `so_tipo_pregunta_dominio`.`FB_R4S`\n , `so_tipo_pregunta_dominio`.`FB_R5I`\n , `so_tipo_pregunta_dominio`.`FB_R5S`\n \n , `so_tipo_pregunta_dominio`.`FA_R1I`\n , `so_tipo_pregunta_dominio`.`FA_R1S`\n , `so_tipo_pregunta_dominio`.`FA_R2I`\n , `so_tipo_pregunta_dominio`.`FA_R2S`\n , `so_tipo_pregunta_dominio`.`FA_R3I`\n , `so_tipo_pregunta_dominio`.`FA_R3S`\n , `so_tipo_pregunta_dominio`.`FA_R4I`\n , `so_tipo_pregunta_dominio`.`FA_R4S`\n , `so_tipo_pregunta_dominio`.`FA_R5I`\n , `so_tipo_pregunta_dominio`.`FA_R5S`\n , `g_persona`.`Id_TipoIdentificacion`\n , `g_persona`.`NoDocumento`\n , concat(`g_persona`.`Apellido1`,' ',`g_persona`.`Apellido2`,' ',`g_persona`.`Nombre1`,' ',`g_persona`.`Nombre2`) AS `NUsuario`\n , `g_sexo`.`Nbre` AS `NSexo`\n , `g_persona`.`FechaNac`\n , `g_persona`.`Edad`\n, g_tipounidadnegocio.`Nbre` AS unidad_negocio \n\n \nFROM `h_so_cuestionario_detalle` \nINNER JOIN `h_so_cuestionarios_encabezado` ON (`h_so_cuestionario_detalle`.`Id_Cuestionario` = `h_so_cuestionarios_encabezado`.`Id`)  \nINNER JOIN `so_tipo_preguntas` ON (`h_so_cuestionario_detalle`.`Id_Pregunta` = `so_tipo_preguntas`.`Id`)  \nINNER JOIN `so_tipo_respuesta` ON (`h_so_cuestionario_detalle`.`Id_Respuesta` = `so_tipo_respuesta`.`Id`)  \nINNER JOIN `so_tipo_pregunta_respuesta` ON (`so_tipo_pregunta_respuesta`.`Id_Pregunta` = `so_tipo_preguntas`.`Id`)\n AND (`so_tipo_pregunta_respuesta`.`Id_Tipo_Respuesta` = `so_tipo_respuesta`.`Id`)  \n INNER JOIN `so_tipo_pregunta_dimension` ON (`so_tipo_preguntas`.`Id_Dimension` = `so_tipo_pregunta_dimension`.`Id`)  \n INNER JOIN `so_tipo_pregunta_dominio` ON (`so_tipo_pregunta_dimension`.`Id_Dominio` = `so_tipo_pregunta_dominio`.`Id`)  \n INNER JOIN `so_tipo_cuestionario` ON (`h_so_cuestionarios_encabezado`.`Id_Cuestionario` = `so_tipo_cuestionario`.`Id`)  \n INNER JOIN `g_persona` ON (`h_so_cuestionarios_encabezado`.`Id_Usuario` = `g_persona`.`Id`)\n INNER JOIN `g_sexo` ON (`g_sexo`.`Id`= `g_persona`.`Id_Sexo`)\n INNER JOIN `g_usuario_fpz`  ON (`g_persona`.`Id` = `g_usuario_fpz`.`Id_Persona`)\n -- INNER JOIN `g_usuario_fpz`  ON (`h_so_cuestionarios_encabezado`.`Id_Usuario` = `g_usuario_fpz`.`Id_Persona`) \n INNER JOIN `g_tipounidadnegocio` ON (`g_usuario_fpz`.`Id_UnidadN` = `g_tipounidadnegocio`.`Id`)\n \nWHERE (`so_tipo_cuestionario`.`Id`='" + this.xidFormato[this.JCBFormato.getSelectedIndex()] + "' AND  `h_so_cuestionarios_encabezado`.`Estado`=1\n AND h_so_cuestionarios_encabezado.`FechaR` BETWEEN '" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND '" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "')  \n GROUP BY  `g_usuario_fpz`.`Id_UnidadN`,  `Id_Dimension`  ,  h_so_cuestionarios_encabezado.`Id_Usuario`  \n ORDER BY g_tipounidadnegocio.`Nbre`, `so_tipo_pregunta_dominio`.`Orden` ASC, `so_tipo_pregunta_dimension`.`Orden` ASC, `so_tipo_preguntas`.`Orden` ASC\n\n),\ndetalle AS (\nSELECT *,\nCASE nombreCuestionario  \n  WHEN 'EVALUACION DEL ESTRES' \n  THEN \n     CASE \n\tWHEN VTransformado>= 0.0 AND VTransformado<=7.8\t\t\n\tTHEN 'Muy bajo'\n\t\n\tWHEN VTransformado>= 7.9 AND VTransformado<=12.6\t\t\n\tTHEN 'Bajo'\n\t\n\tWHEN VTransformado>= 12.7 AND VTransformado<=17.7\t\t\n\tTHEN 'Medio'\n\t\n\tWHEN VTransformado>= 17.8 AND VTransformado<=25.0\t\t\n\tTHEN 'Alto'\n\t\n\tWHEN VTransformado>= 25.0 AND VTransformado<=100\t\t\n\tTHEN 'Muy alto'\n\t\n     END\n      \t\n   WHEN 'FORMA B INTRALABORAL'\n   THEN \n     CASE \n\tWHEN VTransformado>= FB_R1I AND VTransformado<=FB_R1S\t\t\n\tTHEN 'Sin riesgo o riesgo despreciable'\n\t\n\tWHEN  VTransformado>= FB_R2I AND VTransformado<=FB_R2S\t\t\t\n\tTHEN 'Riesgo bajo'\n\t\n\tWHEN  VTransformado>= FB_R3I AND VTransformado<=FB_R3S\t\t\t\n\tTHEN  'Riesgo medio'\n\t\n\tWHEN VTransformado>= FB_R4I AND VTransformado<=FB_R4S\t\t\t\n\tTHEN 'Riesgo alto'\n\t\n\tWHEN VTransformado>= FB_R5I AND VTransformado<=FB_R5S\t\t\t\n\tTHEN 'Riesgo alto'\n\t\n\tELSE  'Valor no clasificado'\n\t\n     END  \n\t\n     WHEN 'FORMA A INTRALABORAL'\n   THEN \n     CASE \n\tWHEN VTransformado>= FA_R1I AND VTransformado<=FA_R1S\t\t\n\tTHEN 'Sin riesgo o riesgo despreciable'\n\t\n\tWHEN  VTransformado>= FA_R2I AND VTransformado<=FA_R2S\t\t\t\n\tTHEN 'Riesgo bajo'\n\t\n\tWHEN  VTransformado>= FA_R3I AND VTransformado<=FA_R3S\t\t\t\n\tTHEN  'Riesgo medio'\n\t\n\tWHEN VTransformado>= FA_R4I AND VTransformado<=FA_R4S\t\t\t\n\tTHEN 'Riesgo alto'\n\t\n\tWHEN VTransformado>= FA_R5I AND VTransformado<=FA_R5S\t\t\t\n\tTHEN 'Riesgo alto'\n\t\n\tELSE  'Valor no clasificado'\t\t\n\t\n     END  \t\n \nEND AS valorCualitativo\n\n\nFROM   maestra \n )\nSELECT detalle.Dominio, detalle.NDimension, ifnull(detalle.VBruto, 0) VBruto , ifnull(detalle.VTransformado, 0)VTransformado, ifnull(detalle.valorCualitativo, 0) valorCualitativo \n, `detalle`.`Id_TipoIdentificacion` \n , `detalle`.`NoDocumento`   \n ,`detalle`.`NUsuario` \n , `detalle`.`NSexo` \n , `detalle`.`FechaNac` \n , `detalle`.`Edad` \n, detalle.unidad_negocio \n\nFROM detalle";
        System.out.println("---> " + sql);
        ConsultasMySQL xctc = new ConsultasMySQL();
        ResultSet xrsc = xctc.traerRs(sql);
        try {
            if (xrsc.next()) {
                xrsc.beforeFirst();
                int n = 0;
                while (xrsc.next()) {
                    this.xmodeloDetallU.addRow(this.xdatos);
                    this.xmodeloDetallU.setValueAt(xrsc.getString("Dominio"), n, 0);
                    this.xmodeloDetallU.setValueAt(xrsc.getString("NDimension"), n, 1);
                    this.xmodeloDetallU.setValueAt(Double.valueOf(xrsc.getDouble("VBruto")), n, 2);
                    this.xmodeloDetallU.setValueAt(Double.valueOf(xrsc.getDouble("VTransformado")), n, 3);
                    this.xmodeloDetallU.setValueAt(xrsc.getString("valorCualitativo"), n, 4);
                    this.xmodeloDetallU.setValueAt(xrsc.getString("Id_TipoIdentificacion"), n, 5);
                    this.xmodeloDetallU.setValueAt(xrsc.getString("NoDocumento"), n, 6);
                    this.xmodeloDetallU.setValueAt(xrsc.getString("NUsuario"), n, 7);
                    this.xmodeloDetallU.setValueAt(xrsc.getString("NSexo"), n, 8);
                    this.xmodeloDetallU.setValueAt(xrsc.getString("FechaNac"), n, 9);
                    this.xmodeloDetallU.setValueAt(xrsc.getString("Edad"), n, 10);
                    this.xmodeloDetallU.setValueAt(xrsc.getString("unidad_negocio"), n, 11);
                    n++;
                }
            }
            xrsc.close();
            xctc.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFResultadoBateria.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCreaModeloDUsuarioExtra() {
        this.xmodeloDetallU = new DefaultTableModel(new Object[0], new String[]{"Dominio", "Dimensión", "Valor", "Cantidad", "Total", "Tipo Doc.", "No. Documento", "Nombre Usuario", "Sexo", "Fecha Nac", "Edad", "Unidad Nego", "Calificacion"}) { // from class: Sig.JIFResultadoBateria.13
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalleUsuario.setModel(this.xmodeloDetallU);
        this.JTDetalleUsuario.getColumnModel().getColumn(0).setPreferredWidth(50);
        this.JTDetalleUsuario.getColumnModel().getColumn(1).setPreferredWidth(50);
        this.JTDetalleUsuario.getColumnModel().getColumn(2).setPreferredWidth(50);
        this.JTDetalleUsuario.getColumnModel().getColumn(3).setPreferredWidth(50);
        this.JTDetalleUsuario.getColumnModel().getColumn(4).setPreferredWidth(50);
        this.JTDetalleUsuario.getColumnModel().getColumn(5).setPreferredWidth(50);
        this.JTDetalleUsuario.getColumnModel().getColumn(6).setPreferredWidth(50);
        this.JTDetalleUsuario.getColumnModel().getColumn(7).setPreferredWidth(50);
        this.JTDetalleUsuario.getColumnModel().getColumn(8).setPreferredWidth(50);
        this.JTDetalleUsuario.getColumnModel().getColumn(9).setPreferredWidth(50);
        this.JTDetalleUsuario.getColumnModel().getColumn(10).setPreferredWidth(50);
        this.JTDetalleUsuario.getColumnModel().getColumn(11).setPreferredWidth(50);
        this.JTDetalleUsuario.getColumnModel().getColumn(12).setPreferredWidth(50);
    }

    private void mBuscaDetalleUsuarioExtra() {
        mCreaModeloDUsuarioExtra();
        String sql = " SELECT *,IF(interno.idDimension=32, IF(interno.total >= interno.FA_R1I AND interno.total<= interno.FA_R1S,'Sin riesgo o riesgo despreciable',   IF(interno.total >= interno.FA_R2I AND interno.total<= interno.FA_R2S,'Riesgo Bajo',IF(interno.total >= interno.FA_R3I AND interno.total<= interno.FA_R3S,'Riesgo Medio',   IF(interno.total >= interno.FA_R4I AND interno.total<= interno.FA_R4S,'Riesgo Alto','Riesgo muy Alto')))),   IF(interno.idDimension=33,IF(interno.total >= interno.FA_R1I AND interno.total<= interno.FA_R1S,'Sin riesgo o riesgo despreciable',   IF(interno.total >= interno.FA_R2I AND interno.total<= interno.FA_R2S,'Riesgo Bajo',IF(interno.total >= interno.FA_R3I AND interno.total<= interno.FA_R3S,'Riesgo Medio',  IF(interno.total >= interno.FA_R4I AND interno.total<= interno.FA_R4S,'Riesgo Alto','Riesgo muy Alto')))),   IF(interno.idDimension=34,IF(interno.total >= interno.FA_R1I AND interno.total<= interno.FA_R1S,'Sin riesgo o riesgo despreciable',   IF(interno.total >= interno.FA_R2I AND interno.total<= interno.FA_R2S,'Riesgo Bajo',IF(interno.total >= interno.FA_R3I AND interno.total<= interno.FA_R3S,'Riesgo Medio',   IF(interno.total >= interno.FA_R4I AND interno.total<= interno.FA_R4S,'Riesgo Alto','Riesgo muy Alto')))),   IF(interno.idDimension=35,IF(interno.total >= interno.FA_R1I AND interno.total<= interno.FA_R1S,'Sin riesgo o riesgo despreciable',   IF(interno.total >= interno.FA_R2I AND interno.total<= interno.FA_R2S,'Riesgo Bajo',IF(interno.total >= interno.FA_R3I AND interno.total<= interno.FA_R3S,'Riesgo Medio',   IF(interno.total >= interno.FA_R4I AND interno.total<= interno.FA_R4S,'Riesgo Alto','Riesgo muy Alto')))),   IF(interno.idDimension=36,IF(interno.total >= interno.FA_R1I AND interno.total<= interno.FA_R1S,'Sin riesgo o riesgo despreciable',   IF(interno.total >= interno.FA_R2I AND interno.total<= interno.FA_R2S,'Riesgo Bajo',IF(interno.total >= interno.FA_R3I AND interno.total<= interno.FA_R3S,'Riesgo Medio',   IF(interno.total >= interno.FA_R4I AND interno.total<= interno.FA_R4S,'Riesgo Alto','Riesgo muy Alto')))),   IF(interno.idDimension=37,IF(interno.total >= interno.FA_R1I AND interno.total<= interno.FA_R1S,'Sin riesgo o riesgo despreciable',   IF(interno.total >= interno.FA_R2I AND interno.total<= interno.FA_R2S,'Riesgo Bajo',IF(interno.total >= interno.FA_R3I AND interno.total<= interno.FA_R3S,'Riesgo Medio',   IF(interno.total >= interno.FA_R4I AND interno.total<= interno.FA_R4S,'Riesgo Alto','Riesgo muy Alto')))),   IF(interno.idDimension=38,IF(interno.total >= interno.FA_R1I AND interno.total<= interno.FA_R1S,'Sin riesgo o riesgo despreciable',   IF(interno.total >= interno.FA_R2I AND interno.total<= interno.FA_R2S,'Riesgo Bajo',IF(interno.total >= interno.FA_R3I AND interno.total<= interno.FA_R3S,'Riesgo Medio',   IF(interno.total >= interno.FA_R4I AND interno.total<= interno.FA_R4S,'Riesgo Alto','Riesgo muy Alto')))),    '--validando'))))))) AS Calificacion    FROM(SELECT `so_tipo_pregunta_dominio`.`Nbre` AS `Dominio`    , so_tipo_pregunta_dimension.`Id` AS idDimension    , `so_tipo_pregunta_dimension`.`Nbre` AS `Dimension`    , SUM(`so_tipo_pregunta_respuesta`.`VCuantitativo`) AS `SValor`    , COUNT(`h_so_cuestionario_detalle`.`Id_Pregunta`) AS `Cantidad`    , (SUM(`so_tipo_pregunta_respuesta`.`VCuantitativo`)/COUNT(`h_so_cuestionario_detalle`.`Id_Pregunta`)) total    ,so_tipo_pregunta_dimension.`FA_R1I`    ,so_tipo_pregunta_dimension.`FA_R1S`    ,so_tipo_pregunta_dimension.`FA_R2I`    ,so_tipo_pregunta_dimension.`FA_R2S`    ,so_tipo_pregunta_dimension.`FA_R3I`    ,so_tipo_pregunta_dimension.`FA_R3S`    ,so_tipo_pregunta_dimension.`FA_R4I`    ,so_tipo_pregunta_dimension.`FA_R4S`    ,so_tipo_pregunta_dimension.`FA_R5I`    ,so_tipo_pregunta_dimension.`FA_R5S`    ,g_tipounidadnegocio.`Nbre` AS UnidadNeg   , `g_persona`.`Id_TipoIdentificacion`\n , `g_persona`.`NoDocumento`\n , concat(`g_persona`.`Apellido1`,' ',`g_persona`.`Apellido2`,' ',`g_persona`.`Nombre1`,' ',`g_persona`.`Nombre2`) AS `NUsuario`\n , `g_sexo`.`Nbre` AS `NSexo`\n , `g_persona`.`FechaNac`\n , `g_persona`.`Edad`\n FROM  `h_so_cuestionario_detalle`    INNER JOIN `h_so_cuestionarios_encabezado`    ON (`h_so_cuestionario_detalle`.`Id_Cuestionario` = `h_so_cuestionarios_encabezado`.`Id`)    INNER JOIN `so_tipo_preguntas`    ON (`h_so_cuestionario_detalle`.`Id_Pregunta` = `so_tipo_preguntas`.`Id`)    INNER JOIN `so_tipo_cuestionario`    ON (`h_so_cuestionarios_encabezado`.`Id_Cuestionario` = `so_tipo_cuestionario`.`Id`)    INNER JOIN `so_tipo_pregunta_dimension`    \tON (`so_tipo_preguntas`.`Id_Dimension` = `so_tipo_pregunta_dimension`.`Id`)    INNER JOIN `so_tipo_pregunta_dominio`    \tON (`so_tipo_pregunta_dimension`.`Id_Dominio` = `so_tipo_pregunta_dominio`.`Id`)     INNER JOIN `so_tipo_respuesta`    \tON (`h_so_cuestionario_detalle`.`Id_Respuesta` = `so_tipo_respuesta`.`Id`)     INNER JOIN `so_tipo_pregunta_respuesta`    \tON (`so_tipo_pregunta_respuesta`.`Id_Pregunta` = `so_tipo_preguntas`.`Id`) AND (`so_tipo_pregunta_respuesta`.`Id_Tipo_Respuesta` = `so_tipo_respuesta`.`Id`)    INNER JOIN `g_persona` ON (`h_so_cuestionarios_encabezado`.`Id_Usuario` = `g_persona`.`Id`)\n INNER JOIN `g_sexo` ON (`g_sexo`.`Id`= `g_persona`.`Id_Sexo`)\n INNER JOIN `g_usuario_fpz`  ON (`g_persona`.`Id` = `g_usuario_fpz`.`Id_Persona`)\n INNER JOIN `g_tipounidadnegocio`   ON (`g_usuario_fpz`.`Id_UnidadN` = `g_tipounidadnegocio`.`Id`)   WHERE (h_so_cuestionarios_encabezado.`Id_Cuestionario`=8 AND h_so_cuestionarios_encabezado.`FechaR`>='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND h_so_cuestionarios_encabezado.`FechaR`<='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' AND `h_so_cuestionarios_encabezado`.`Estado`=1)    GROUP BY `so_tipo_pregunta_dimension`.`Id` , h_so_cuestionarios_encabezado.`Id_Usuario`    ORDER BY concat(`g_persona`.`Apellido1`,' ',`g_persona`.`Apellido2`,' ',`g_persona`.`Nombre1`,' ',`g_persona`.`Nombre2`),`so_tipo_pregunta_dominio`.`Nbre` ASC, `so_tipo_pregunta_dimension`.`Nbre` ASC, `so_tipo_preguntas`.`Orden` ASC) AS interno   ;  ";
        System.out.println("DetalleUsuarioExtra: " + sql);
        ConsultasMySQL xctc = new ConsultasMySQL();
        ResultSet xrsc = xctc.traerRs(sql);
        try {
            if (xrsc.next()) {
                xrsc.beforeFirst();
                int n = 0;
                while (xrsc.next()) {
                    this.xmodeloDetallU.addRow(this.xdatos);
                    this.xmodeloDetallU.setValueAt(xrsc.getString("Dominio"), n, 0);
                    this.xmodeloDetallU.setValueAt(xrsc.getString("Dimension"), n, 1);
                    this.xmodeloDetallU.setValueAt(Double.valueOf(xrsc.getDouble("SValor")), n, 2);
                    this.xmodeloDetallU.setValueAt(Double.valueOf(xrsc.getDouble("Cantidad")), n, 3);
                    this.xmodeloDetallU.setValueAt(xrsc.getString("total"), n, 4);
                    this.xmodeloDetallU.setValueAt(xrsc.getString("Id_TipoIdentificacion"), n, 5);
                    this.xmodeloDetallU.setValueAt(xrsc.getString("NoDocumento"), n, 6);
                    this.xmodeloDetallU.setValueAt(xrsc.getString("NUsuario"), n, 7);
                    this.xmodeloDetallU.setValueAt(xrsc.getString("NSexo"), n, 8);
                    this.xmodeloDetallU.setValueAt(xrsc.getString("FechaNac"), n, 9);
                    this.xmodeloDetallU.setValueAt(xrsc.getString("Edad"), n, 10);
                    this.xmodeloDetallU.setValueAt(xrsc.getString("UnidadNeg"), n, 11);
                    this.xmodeloDetallU.setValueAt(xrsc.getString("Calificacion"), n, 12);
                    n++;
                }
            }
            xrsc.close();
            xctc.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFResultadoBateria.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }
}
