package Contabilidad;

import Acceso.Principal;
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
import java.io.File;
import java.io.IOException;
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
import javax.swing.JTextPane;
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

/* JADX INFO: loaded from: GenomaP.jar:Contabilidad/JIFConsultarInfPeriodos.class */
public class JIFConsultarInfPeriodos extends JInternalFrame {
    private ConsultasMySQL xct = new ConsultasMySQL();
    private Metodos xmt = new Metodos();
    private String[][] xid;
    private Object[] xdato;
    private String[][] xidtipoimpuesto;
    private String[] xidtipodoc;
    private String[] xidtercero;
    private String xsql;
    private String xcc_detalle_documentoc;
    private String xcc_puc;
    private String xcc_documentoc;
    private DefaultTableModel xmodelo;
    private DefaultTableModel xmodelo1;
    private DefaultTableModel xmodelo2;
    private JButton JBTAdicionarT;
    private JButton JBTExportar;
    private JButton JBTGrabar;
    private JComboBox JCBTercero;
    private JComboBox JCBTipoC;
    private JComboBox JCBTipoImpuesto;
    private JCheckBox JCHActivo;
    private JCheckBox JCHMovimiento;
    public JDateChooser JDFechaF;
    public JDateChooser JDFechaI;
    private JPanel JPIAjuste;
    private JPanel JPIDatosC;
    private JScrollPane JSPConceptC;
    private JScrollPane JSPDetalle;
    private JScrollPane JSPDetalle1;
    private JScrollPane JSPDetalle2;
    private JTextPane JTAConceptoC;
    private JTable JTDetalle;
    private JTable JTDetalle1;
    private JTable JTDetalle2;
    private JFormattedTextField JTFFTotal;
    private JFormattedTextField JTFFTotalBase;
    private JTextField JTFRuta;
    private JTabbedPane JTPDetalle;

    public JIFConsultarInfPeriodos() {
        initComponents();
        if (Principal.xclase.getxForma_Gn_Niif() == 1) {
            this.xcc_detalle_documentoc = "cc_detalle_documentoc_niif";
            this.xcc_puc = "cc_puc_niif";
            this.xcc_documentoc = "cc_documentoc_niif";
        } else {
            this.xcc_detalle_documentoc = "cc_detalle_documentoc";
            this.xcc_puc = "cc_puc";
            this.xcc_documentoc = "cc_documentoc";
        }
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v39, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v43, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v48, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPIDatosC = new JPanel();
        this.JCBTipoImpuesto = new JComboBox();
        this.JCHActivo = new JCheckBox();
        this.JCHMovimiento = new JCheckBox();
        this.JDFechaI = new JDateChooser();
        this.JDFechaF = new JDateChooser();
        this.JTPDetalle = new JTabbedPane();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JSPDetalle1 = new JScrollPane();
        this.JTDetalle1 = new JTable();
        this.JPIAjuste = new JPanel();
        this.JSPDetalle2 = new JScrollPane();
        this.JTDetalle2 = new JTable();
        this.JCBTipoC = new JComboBox();
        this.JCBTercero = new JComboBox();
        this.JBTAdicionarT = new JButton();
        this.JBTGrabar = new JButton();
        this.JSPConceptC = new JScrollPane();
        this.JTAConceptoC = new JTextPane();
        this.JTFFTotal = new JFormattedTextField();
        this.JTFFTotalBase = new JFormattedTextField();
        this.JTFRuta = new JTextField();
        this.JBTExportar = new JButton();
        setClosable(true);
        setIconifiable(true);
        setTitle("CONSULTA BASES GRABADAS ACOMULADAS");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjifconsultarportipoimpuesto");
        this.JPIDatosC.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS PARA CONSULTA", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JCBTipoImpuesto.setFont(new Font("Arial", 1, 12));
        this.JCBTipoImpuesto.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Impuesto", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHActivo.setFont(new Font("Arial", 1, 13));
        this.JCHActivo.setSelected(true);
        this.JCHActivo.setText("Activo");
        this.JCHActivo.addActionListener(new ActionListener() { // from class: Contabilidad.JIFConsultarInfPeriodos.1
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarInfPeriodos.this.JCHActivoActionPerformed(evt);
            }
        });
        this.JCHMovimiento.setFont(new Font("Arial", 1, 13));
        this.JCHMovimiento.setSelected(true);
        this.JCHMovimiento.setText("Movimiento?");
        this.JCHMovimiento.addActionListener(new ActionListener() { // from class: Contabilidad.JIFConsultarInfPeriodos.2
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarInfPeriodos.this.JCHMovimientoActionPerformed(evt);
            }
        });
        this.JDFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFechaI.setFont(new Font("Arial", 1, 12));
        this.JDFechaI.addPropertyChangeListener(new PropertyChangeListener() { // from class: Contabilidad.JIFConsultarInfPeriodos.3
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFConsultarInfPeriodos.this.JDFechaIPropertyChange(evt);
            }
        });
        this.JDFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Fin", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFechaF.setFont(new Font("Arial", 1, 12));
        this.JDFechaF.addPropertyChangeListener(new PropertyChangeListener() { // from class: Contabilidad.JIFConsultarInfPeriodos.4
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFConsultarInfPeriodos.this.JDFechaFPropertyChange(evt);
            }
        });
        GroupLayout JPIDatosCLayout = new GroupLayout(this.JPIDatosC);
        this.JPIDatosC.setLayout(JPIDatosCLayout);
        JPIDatosCLayout.setHorizontalGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosCLayout.createSequentialGroup().addContainerGap().addComponent(this.JDFechaI, -2, 140, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JDFechaF, -2, 140, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBTipoImpuesto, -2, 457, -2).addGap(18, 18, 18).addGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosCLayout.createSequentialGroup().addComponent(this.JCHActivo, -1, 91, 32767).addGap(32, 32, 32)).addGroup(JPIDatosCLayout.createSequentialGroup().addComponent(this.JCHMovimiento, -1, 117, 32767).addContainerGap()))));
        JPIDatosCLayout.setVerticalGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosCLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JDFechaF, -2, 50, -2).addComponent(this.JDFechaI, -2, 50, -2).addGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JCBTipoImpuesto).addGroup(GroupLayout.Alignment.LEADING, JPIDatosCLayout.createSequentialGroup().addComponent(this.JCHActivo).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHMovimiento)))).addContainerGap(-1, 32767)));
        this.JTPDetalle.setForeground(new Color(0, 103, 0));
        this.JTPDetalle.setFont(new Font("Arial", 1, 14));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.setSelectionMode(0);
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.JTPDetalle.addTab("DETALLE", this.JSPDetalle);
        this.JTDetalle1.setFont(new Font("Arial", 1, 12));
        this.JTDetalle1.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle1.setRowHeight(25);
        this.JTDetalle1.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle1.setSelectionForeground(Color.red);
        this.JTDetalle1.setSelectionMode(0);
        this.JSPDetalle1.setViewportView(this.JTDetalle1);
        this.JTPDetalle.addTab("CONSOLIDADO", this.JSPDetalle1);
        this.JSPDetalle2.setBorder(BorderFactory.createTitledBorder((Border) null, "CONSOLIDADO", 2, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.JTDetalle2.setFont(new Font("Arial", 1, 12));
        this.JTDetalle2.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle2.setRowHeight(25);
        this.JTDetalle2.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle2.setSelectionForeground(Color.red);
        this.JTDetalle2.setSelectionMode(0);
        this.JSPDetalle2.setViewportView(this.JTDetalle2);
        this.JCBTipoC.setFont(new Font("Arial", 1, 12));
        this.JCBTipoC.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Documento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTercero.setFont(new Font("Arial", 1, 12));
        this.JCBTercero.setBorder(BorderFactory.createTitledBorder((Border) null, "Tercero", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBTAdicionarT.setFont(new Font("Arial", 1, 12));
        this.JBTAdicionarT.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTAdicionarT.setText("Adicionar");
        this.JBTAdicionarT.addActionListener(new ActionListener() { // from class: Contabilidad.JIFConsultarInfPeriodos.5
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarInfPeriodos.this.JBTAdicionarTActionPerformed(evt);
            }
        });
        this.JBTGrabar.setFont(new Font("Arial", 1, 12));
        this.JBTGrabar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Grabar29x27.png")));
        this.JBTGrabar.setText("Generar Documento Contable");
        this.JBTGrabar.addActionListener(new ActionListener() { // from class: Contabilidad.JIFConsultarInfPeriodos.6
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarInfPeriodos.this.JBTGrabarActionPerformed(evt);
            }
        });
        this.JSPConceptC.setBorder(BorderFactory.createTitledBorder((Border) null, "Concepto", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPConceptC.setViewportView(this.JTAConceptoC);
        GroupLayout JPIAjusteLayout = new GroupLayout(this.JPIAjuste);
        this.JPIAjuste.setLayout(JPIAjusteLayout);
        JPIAjusteLayout.setHorizontalGroup(JPIAjusteLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIAjusteLayout.createSequentialGroup().addContainerGap().addGroup(JPIAjusteLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JSPConceptC).addGroup(GroupLayout.Alignment.LEADING, JPIAjusteLayout.createSequentialGroup().addComponent(this.JCBTipoC, -2, 238, -2).addGap(18, 18, 18).addComponent(this.JCBTercero, -2, 515, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBTAdicionarT, -1, -1, 32767)).addComponent(this.JBTGrabar, GroupLayout.Alignment.LEADING, -1, -1, 32767)).addContainerGap()).addGroup(JPIAjusteLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIAjusteLayout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.JSPDetalle2, -2, 893, -2).addContainerGap())));
        JPIAjusteLayout.setVerticalGroup(JPIAjusteLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIAjusteLayout.createSequentialGroup().addGap(150, 150, 150).addComponent(this.JSPConceptC, -1, 68, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIAjusteLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JBTAdicionarT, -1, -1, 32767).addGroup(JPIAjusteLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBTipoC, -2, 45, 32767).addComponent(this.JCBTercero, -2, 45, 32767))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTGrabar, -2, 57, -2).addContainerGap()).addGroup(JPIAjusteLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIAjusteLayout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.JSPDetalle2, -2, 132, -2).addContainerGap(200, 32767))));
        this.JTPDetalle.addTab("AJUSTE CONTABLE", this.JPIAjuste);
        this.JTFFTotal.setBorder(BorderFactory.createTitledBorder((Border) null, "Total", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFTotal.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFTotal.setHorizontalAlignment(4);
        this.JTFFTotal.setFont(new Font("Arial", 1, 12));
        this.JTFFTotalBase.setBorder(BorderFactory.createTitledBorder((Border) null, "Total Base", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFTotalBase.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFTotalBase.setHorizontalAlignment(4);
        this.JTFFTotalBase.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: Contabilidad.JIFConsultarInfPeriodos.7
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarInfPeriodos.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setForeground(Color.red);
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: Contabilidad.JIFConsultarInfPeriodos.8
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarInfPeriodos.this.JBTExportarActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.JTFRuta, -2, 398, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBTExportar, -2, 128, -2).addGap(65, 65, 65).addComponent(this.JTFFTotal, -2, 147, -2).addGap(18, 18, 18).addComponent(this.JTFFTotalBase)).addComponent(this.JPIDatosC, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addComponent(this.JTPDetalle, -2, 0, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatosC, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTPDetalle, -2, 374, -2).addGap(18, 18, 18).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFTotalBase).addComponent(this.JTFFTotal, -2, -1, -2)).addComponent(this.JTFRuta, -2, 50, -2).addComponent(this.JBTExportar, -2, 50, -2)).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHActivoActionPerformed(ActionEvent evt) {
        mCargarCombo();
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
                mExportar();
                return;
            } else {
                JOptionPane.showInternalMessageDialog(this, "No existe información para exportar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                return;
            }
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un ruta valida", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JTFRuta.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTAdicionarTActionPerformed(ActionEvent evt) {
        if (this.JTDetalle2.getSelectedRow() != -1) {
            if (this.JCBTercero.getSelectedIndex() != -1) {
                this.xmodelo2.setValueAt(this.xidtercero[this.JCBTercero.getSelectedIndex()], this.JTDetalle2.getSelectedRow(), 5);
                this.xmodelo2.setValueAt(this.JCBTercero.getSelectedItem(), this.JTDetalle2.getSelectedRow(), 6);
                return;
            } else {
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un tercero", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                this.JCBTercero.requestFocus();
                return;
            }
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un registro en la tabla", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
        this.JTDetalle2.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTGrabarActionPerformed(ActionEvent evt) {
        if (this.JTDetalle2.getRowCount() >= 0) {
            if (!this.xmt.mVerificarDatosLLeno(this.JTDetalle2, 5)) {
                if (this.JCBTipoC.getSelectedIndex() != -1) {
                    if (Principal.txtNo.getText().isEmpty()) {
                        int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                        if (x == 0) {
                            String sql = "insert into " + this.xcc_documentoc + " (FechaD, Id_TipoComprobante, Id_PeriodoC, Descripcion, Fecha, UsuarioS) Values ('" + this.xmt.formatoAMD.format(this.xmt.getFechaActual()) + "','" + this.xidtipodoc[this.JCBTipoC.getSelectedIndex()] + "','" + Principal.xclase.getXidperiodoc() + "','" + this.JTAConceptoC.getText() + "','" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                            Principal.txtNo.setText(this.xct.ejecutarSQLId(sql));
                            Principal.txtEstado.setText("ACTIVO");
                            this.xct.cerrarConexionBd();
                            for (int y = 0; y < this.JTDetalle2.getRowCount(); y++) {
                                ConsultasMySQL xct1 = new ConsultasMySQL();
                                String sql2 = "insert into " + this.xcc_detalle_documentoc + " (Id_Documentoc, Id_Puc, TipoCPuc, Id_Tercero, VDebito, VCredito) Values ('" + Principal.txtNo.getText() + "','" + this.xmodelo2.getValueAt(y, 0).toString() + "','" + this.xmodelo2.getValueAt(y, 2).toString() + "','" + this.xmodelo2.getValueAt(y, 5).toString() + "','" + this.xmodelo2.getValueAt(y, 3) + "','" + this.xmodelo2.getValueAt(y, 4) + "' )";
                                xct1.ejecutarSQL(sql2);
                                xct1.cerrarConexionBd();
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un tipo de documento", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                this.JCBTipoC.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Faltan datos de tercero", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
            this.JTDetalle2.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "No existen registros para grabar", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
        this.JTDetalle2.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHMovimientoActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaIPropertyChange(PropertyChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaFPropertyChange(PropertyChangeEvent evt) {
    }

    public void mNuevo() {
        this.JDFechaI.setDate(this.xmt.getFechaActual());
        this.JDFechaF.setDate(this.xmt.getFechaActual());
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
        this.JCBTipoImpuesto.removeAllItems();
        this.xsql = "SELECT `cc_tipo_impuesto`.`Id`, `cc_tipo_impuesto`.`Nbre`, `cc_tipo_impuesto`.`Id_Puc` FROM  `cc_valorxtipo_impuesto` INNER JOIN  `" + this.xcc_detalle_documentoc + "`  ON (`cc_valorxtipo_impuesto`.`Id_Puc` = `" + this.xcc_detalle_documentoc + "`.`Id_Puc`) INNER JOIN  `cc_tipo_impuesto`  ON (`cc_valorxtipo_impuesto`.`Id_TipoImpuesto` = `cc_tipo_impuesto`.`Id`) WHERE (`cc_tipo_impuesto`.`EsImpuestos` =1) GROUP BY `cc_tipo_impuesto`.`Id` ";
        this.xidtipoimpuesto = this.xct.llenarComboyLista(this.xsql, this.xidtipoimpuesto, this.JCBTipoImpuesto, 3);
        this.JCBTipoImpuesto.setSelectedIndex(-1);
        this.xidtipodoc = this.xct.llenarCombo("SELECT `Id`, `Nbre` FROM `cc_tipo_documentoc` WHERE (`EsAjuste` =1) ORDER BY `Nbre` ASC", this.xidtipodoc, this.JCBTipoC);
        if (this.xidtipodoc.length > 1) {
            this.JCBTipoC.setSelectedIndex(-1);
        }
        this.xidtercero = this.xct.llenarCombo("SELECT Id, Nbre FROM g_empresa WHERE (Estado =1) ORDER BY Nbre ASC", this.xidtercero, this.JCBTercero);
        if (this.xidtercero.length > 1) {
            this.JCBTercero.setSelectedIndex(-1);
        }
        this.xct.cerrarConexionBd();
        this.JTFFTotal.setValue(new Double(0.0d));
        this.JTFFTotalBase.setValue(new Double(0.0d));
        mCargarCombo();
        mCrearModeloDatos();
        mCrearModeloDatos1();
        mCrearModeloDatos2();
    }

    public void mBuscar() {
        if (this.JCBTipoImpuesto.getSelectedIndex() != -1) {
            mCrearVistas();
            mCargarDatos();
            mCargarDatos1();
            mImprimir();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un tipo de impuesto", "VALIDACIÓN", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
        this.JCBTipoImpuesto.requestFocus();
    }

    private void mCargarCombo() {
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"IdClase", "NClase", "IdAuxiliar", "NAuxiliar", "Documento", "Tercero", "%Base", "Valor", "SBase", "VAcomulado", "BAcomulada"}) { // from class: Contabilidad.JIFConsultarInfPeriodos.9
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, Double.class, Double.class, Double.class, Double.class, Double.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(5);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(10);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos1() {
        this.xmodelo1 = new DefaultTableModel(new Object[0], new String[]{"IdAuxiliar", "NAuxiliar", "%Base", "Valor", "SBase", "ValorR", "NValor"}) { // from class: Contabilidad.JIFConsultarInfPeriodos.10
            Class[] types = {String.class, String.class, Double.class, Double.class, Double.class, Double.class, Double.class};
            boolean[] canEdit = {false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle1.setModel(this.xmodelo1);
        this.JTDetalle1.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTDetalle1.getColumnModel().getColumn(1).setPreferredWidth(150);
        this.JTDetalle1.getColumnModel().getColumn(2).setPreferredWidth(10);
        this.JTDetalle1.getColumnModel().getColumn(3).setPreferredWidth(10);
        this.JTDetalle1.getColumnModel().getColumn(4).setPreferredWidth(10);
        this.JTDetalle1.getColumnModel().getColumn(5).setPreferredWidth(10);
        this.JTDetalle1.getColumnModel().getColumn(6).setPreferredWidth(10);
    }

    public void mCrearModeloDatos2() {
        this.xmodelo2 = new DefaultTableModel((Object[][]) null, new String[]{"Id", "Nombre", "Tipo", "V/Débito", "V/Crédito", "IdTercero", "Tercero"}) { // from class: Contabilidad.JIFConsultarInfPeriodos.11
            Class[] types = {Long.class, String.class, Long.class, Double.class, Double.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return this.canEdit[colIndex];
            }
        };
        this.JTDetalle2.setModel(this.xmodelo2);
        this.JTDetalle2.getColumnModel().getColumn(0).setPreferredWidth(20);
        this.JTDetalle2.getColumnModel().getColumn(1).setPreferredWidth(400);
        this.JTDetalle2.getColumnModel().getColumn(2).setPreferredWidth(0);
        this.JTDetalle2.getColumnModel().getColumn(2).setMinWidth(0);
        this.JTDetalle2.getColumnModel().getColumn(2).setMaxWidth(0);
        this.JTDetalle2.getColumnModel().getColumn(3).setPreferredWidth(20);
        this.JTDetalle2.getColumnModel().getColumn(4).setPreferredWidth(20);
        this.JTDetalle2.getColumnModel().getColumn(5).setPreferredWidth(0);
        this.JTDetalle2.getColumnModel().getColumn(5).setMinWidth(0);
        this.JTDetalle2.getColumnModel().getColumn(5).setMaxWidth(0);
        this.JTDetalle2.getColumnModel().getColumn(6).setPreferredWidth(200);
    }

    private void mCargarDatos() {
        if (this.JCHMovimiento.isSelected()) {
            this.xsql = "SELECT `IdClase`, `NClase`, `IdAuxiliar`, `NAuxuliar`, `DocTercero`, `NTercero`, `PBase`, `VPeriodo`, `BPeriodo`, `VAcomulado`, `BAcomulada` FROM  `cc_v_tmp_datos1` where `VPeriodo`<>0 ORDER BY `IdAuxiliar` ASC, `NTercero` ASC ";
        } else {
            this.xsql = "SELECT `IdClase`, `NClase`, `IdAuxiliar`, `NAuxuliar`, `DocTercero`, `NTercero`, `PBase`, `VPeriodo`, `BPeriodo`, `VAcomulado`, `BAcomulada` FROM  `cc_v_tmp_datos1` ORDER BY `IdAuxiliar` ASC, `NTercero` ASC ";
        }
        mCrearModeloDatos();
        ResultSet rs = this.xct.traerRs(this.xsql);
        double xvalor = 0.0d;
        double xvalor1 = 0.0d;
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
                    this.xmodelo.setValueAt(Double.valueOf(rs.getDouble(7)), x, 6);
                    this.xmodelo.setValueAt(Double.valueOf(rs.getDouble(8)), x, 7);
                    this.xmodelo.setValueAt(Double.valueOf(rs.getDouble(9)), x, 8);
                    this.xmodelo.setValueAt(Double.valueOf(rs.getDouble(10)), x, 9);
                    this.xmodelo.setValueAt(Double.valueOf(rs.getDouble(11)), x, 10);
                    xvalor += rs.getDouble(8);
                    xvalor1 += rs.getDouble(9);
                    x++;
                }
            }
            rs.close();
            this.xct.cerrarConexionBd();
            this.JTFFTotal.setValue(Double.valueOf(xvalor));
            this.JTFFTotalBase.setValue(Double.valueOf(xvalor1));
        } catch (SQLException ex) {
            this.xct.mostrarErrorSQL(ex);
        }
    }

    private void mCargarDatos1() {
        this.xsql = "SELECT `IdAuxiliar`, `NAuxuliar`, `PBase`, SUM(`VPeriodo`) AS `VPeriodo`, SUM(`BPeriodo`) AS `BPeriodio`, (SUM(`VPeriodo`)-ROUND(SUM(`VPeriodo`),-3)) AS RAjuste, ROUND(SUM(`VPeriodo`),-3) AS Nvalor  FROM  `cc_v_tmp_datos1` GROUP BY `IdAuxiliar` HAVING (`VPeriodo` <>0) ORDER BY `IdAuxiliar` ASC";
        mCrearModeloDatos1();
        ResultSet rs = this.xct.traerRs(this.xsql);
        try {
            if (rs.next()) {
                rs.beforeFirst();
                int x = 0;
                while (rs.next()) {
                    this.xmodelo1.addRow(this.xdato);
                    this.xmodelo1.setValueAt(rs.getString(1), x, 0);
                    this.xmodelo1.setValueAt(rs.getString(2), x, 1);
                    this.xmodelo1.setValueAt(Double.valueOf(rs.getDouble(3)), x, 2);
                    this.xmodelo1.setValueAt(Double.valueOf(rs.getDouble(4)), x, 3);
                    this.xmodelo1.setValueAt(Double.valueOf(rs.getDouble(5)), x, 4);
                    this.xmodelo1.setValueAt(Double.valueOf(rs.getDouble(6)), x, 5);
                    this.xmodelo1.setValueAt(Double.valueOf(rs.getDouble(7)), x, 6);
                    x++;
                }
            }
            rs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            this.xct.mostrarErrorSQL(ex);
        }
    }

    private void mCargarDatos2() {
        this.xsql = "SELECT `PucAjuste` , `Puc` , ABS(SUM(`Valor`)), `Tipo` FROM `cc_v_tmp_ajuste` GROUP BY `PucAjuste` ";
        mCrearModeloDatos2();
        ResultSet rs = this.xct.traerRs(this.xsql);
        try {
            if (rs.next()) {
                rs.beforeFirst();
                int x = 0;
                while (rs.next()) {
                    this.xmodelo2.addRow(this.xdato);
                    this.xmodelo2.setValueAt(rs.getString(1), x, 0);
                    this.xmodelo2.setValueAt(rs.getString(2), x, 1);
                    this.xmodelo2.setValueAt("", x, 5);
                    this.xmodelo2.setValueAt("", x, 6);
                    if (rs.getInt(4) == 0) {
                        this.xmodelo2.setValueAt(0, x, 2);
                        this.xmodelo2.setValueAt(Double.valueOf(rs.getDouble(3)), x, 3);
                        this.xmodelo2.setValueAt(0, x, 4);
                        if (!this.xidtipoimpuesto[this.JCBTipoImpuesto.getSelectedIndex()][1].equals("")) {
                            x++;
                            this.xmodelo2.addRow(this.xdato);
                            this.xmodelo2.setValueAt(this.xidtipoimpuesto[this.JCBTipoImpuesto.getSelectedIndex()][1], x, 0);
                            this.xmodelo2.setValueAt(Principal.xclase.mBuscarNCuentaPuc(this.xidtipoimpuesto[this.JCBTipoImpuesto.getSelectedIndex()][1]), x, 1);
                            this.xmodelo2.setValueAt(1, x, 2);
                            this.xmodelo2.setValueAt(0, x, 3);
                            this.xmodelo2.setValueAt(Double.valueOf(rs.getDouble(3)), x, 4);
                            this.xmodelo2.setValueAt("", x, 5);
                            this.xmodelo2.setValueAt("", x, 6);
                        }
                    } else {
                        this.xmodelo2.setValueAt(1, x, 2);
                        this.xmodelo2.setValueAt(0, x, 3);
                        this.xmodelo2.setValueAt(Double.valueOf(rs.getDouble(3)), x, 4);
                        if (!this.xidtipoimpuesto[this.JCBTipoImpuesto.getSelectedIndex()][1].equals("")) {
                            x++;
                            this.xmodelo2.addRow(this.xdato);
                            this.xmodelo2.setValueAt(this.xidtipoimpuesto[this.JCBTipoImpuesto.getSelectedIndex()][1], x, 0);
                            this.xmodelo2.setValueAt(Principal.xclase.mBuscarNCuentaPuc(this.xidtipoimpuesto[this.JCBTipoImpuesto.getSelectedIndex()][1]), x, 1);
                            this.xmodelo2.setValueAt(0, x, 2);
                            this.xmodelo2.setValueAt(Double.valueOf(rs.getDouble(3)), x, 3);
                            this.xmodelo2.setValueAt(0, x, 4);
                            this.xmodelo2.setValueAt("", x, 5);
                            this.xmodelo2.setValueAt("", x, 6);
                        }
                    }
                    x++;
                }
            }
            rs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            this.xct.mostrarErrorSQL(ex);
        }
    }

    private void mExportar() {
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            try {
                WritableWorkbook workbook = Workbook.createWorkbook(new File(this.JTFRuta.getText() + ".xls"));
                WritableSheet sheet = workbook.createSheet("Detalle", 0);
                for (int x = 0; x < this.JTDetalle.getColumnCount(); x++) {
                    sheet.addCell(new Label(x, 0, this.JTDetalle.getColumnName(x)));
                }
                for (int x2 = 0; x2 < this.JTDetalle.getRowCount(); x2++) {
                    sheet.addCell(new Label(0, x2 + 1, this.xmodelo.getValueAt(x2, 0).toString()));
                    sheet.addCell(new Label(1, x2 + 1, this.xmodelo.getValueAt(x2, 1).toString()));
                    sheet.addCell(new Label(2, x2 + 1, this.xmodelo.getValueAt(x2, 2).toString()));
                    sheet.addCell(new Label(3, x2 + 1, this.xmodelo.getValueAt(x2, 3).toString()));
                    sheet.addCell(new Label(4, x2 + 1, this.xmodelo.getValueAt(x2, 4).toString()));
                    sheet.addCell(new Label(5, x2 + 1, this.xmodelo.getValueAt(x2, 5).toString()));
                    sheet.addCell(new Number(6, x2 + 1, Double.valueOf(this.xmodelo.getValueAt(x2, 6).toString()).doubleValue()));
                    sheet.addCell(new Number(7, x2 + 1, Double.valueOf(this.xmodelo.getValueAt(x2, 7).toString()).doubleValue()));
                    sheet.addCell(new Number(8, x2 + 1, Double.valueOf(this.xmodelo.getValueAt(x2, 8).toString()).doubleValue()));
                    sheet.addCell(new Number(9, x2 + 1, Double.valueOf(this.xmodelo.getValueAt(x2, 9).toString()).doubleValue()));
                    sheet.addCell(new Number(10, x2 + 1, Double.valueOf(this.xmodelo.getValueAt(x2, 10).toString()).doubleValue()));
                }
                WritableSheet sheet2 = workbook.createSheet("Consolidado", 1);
                for (int x3 = 0; x3 < this.JTDetalle1.getColumnCount(); x3++) {
                    sheet2.addCell(new Label(x3, 0, this.JTDetalle1.getColumnName(x3)));
                }
                for (int x4 = 0; x4 < this.JTDetalle1.getRowCount(); x4++) {
                    sheet2.addCell(new Label(0, x4 + 1, this.xmodelo1.getValueAt(x4, 0).toString()));
                    sheet2.addCell(new Label(1, x4 + 1, this.xmodelo1.getValueAt(x4, 1).toString()));
                    sheet2.addCell(new Number(2, x4 + 1, Double.valueOf(this.xmodelo1.getValueAt(x4, 2).toString()).doubleValue()));
                    sheet2.addCell(new Number(3, x4 + 1, Double.valueOf(this.xmodelo1.getValueAt(x4, 3).toString()).doubleValue()));
                    sheet2.addCell(new Number(4, x4 + 1, Double.valueOf(this.xmodelo1.getValueAt(x4, 4).toString()).doubleValue()));
                    sheet2.addCell(new Number(5, x4 + 1, Double.valueOf(this.xmodelo1.getValueAt(x4, 5).toString()).doubleValue()));
                    sheet2.addCell(new Number(6, x4 + 1, Double.valueOf(this.xmodelo1.getValueAt(x4, 6).toString()).doubleValue()));
                }
                workbook.write();
                workbook.close();
            } catch (IOException ex) {
                Logger.getLogger(JIFConsultarInfPeriodos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            } catch (WriteException e) {
                Logger.getLogger(JIFConsultarInfPeriodos.class.getName()).log(Level.SEVERE, (String) null, e);
            }
        }
    }

    public void mImprimir() {
        if (this.JTDetalle.getRowCount() != -1) {
            String[][] parametros = new String[8][2];
            parametros[0][0] = "UsuarioS";
            parametros[0][1] = Principal.usuarioSistemaDTO.getLogin();
            parametros[1][0] = "periodo";
            parametros[1][1] = this.xmt.formatoAMD1.format(this.JDFechaI.getDate()) + " - " + this.xmt.formatoAMD1.format(this.JDFechaF.getDate());
            parametros[2][0] = "Tipo";
            parametros[2][1] = this.JCBTipoImpuesto.getSelectedItem().toString();
            parametros[3][0] = "SUBREPORT_DIR";
            parametros[3][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
            parametros[4][0] = "SUBREPORTFIRMA_DIR";
            parametros[4][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
            parametros[5][0] = "Titulo";
            parametros[5][1] = "INFORME DE IMPUESTO : " + this.JCBTipoImpuesto.getSelectedItem().toString();
            parametros[6][0] = "fechai";
            parametros[6][1] = this.xmt.formatoAMD1.format(this.JDFechaI.getDate());
            parametros[7][0] = "fechaf";
            parametros[7][1] = this.xmt.formatoAMD1.format(this.JDFechaF.getDate());
            this.xmt.GenerarPDF(this.xmt.getRutaRep() + "CC_Informe_Bases_Gravadas", parametros);
            this.xmt.GenerarPDF(this.xmt.getRutaRep() + "CC_InformeImpuestoDian", parametros);
            this.xmt.GenerarPDF(this.xmt.getRutaRep() + "CC_InformeImpuestoDian_Nomina", parametros);
        }
    }

    private void mCrearVistas() {
        this.xsql = "delete from cc_tmp";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "";
        this.xsql = "insert into cc_tmp(`Id_Tercero`, `Puc`, `VAcomulado`, `BAcomulada`) SELECT  `" + this.xcc_detalle_documentoc + "`.`Id_Tercero` , `" + this.xcc_detalle_documentoc + "`.`Id_Puc` , SUM((`" + this.xcc_detalle_documentoc + "`.`VCredito`-`" + this.xcc_detalle_documentoc + "`.`VDebito`)) AS `STotal` , SUM(if(`" + this.xcc_detalle_documentoc + "`.`VDebito`<>0, (`" + this.xcc_detalle_documentoc + "`.`Base`*-1),`" + this.xcc_detalle_documentoc + "`.`Base`)) AS `SBase` FROM  `" + this.xcc_detalle_documentoc + "` INNER JOIN `" + this.xcc_documentoc + "`  ON (`" + this.xcc_detalle_documentoc + "`.`Id_Documentoc` = `" + this.xcc_documentoc + "`.`Id`) INNER JOIN `cc_tipo_documentoc` ON (cc_tipo_documentoc.`Id`=`" + this.xcc_documentoc + "`.`Id_TipoComprobante`) INNER JOIN `" + this.xcc_puc + "`  ON (`" + this.xcc_detalle_documentoc + "`.`Id_Puc` = `" + this.xcc_puc + "`.`Id`) INNER JOIN `cc_terceros`  ON (`" + this.xcc_detalle_documentoc + "`.`Id_Tercero` = `cc_terceros`.`Id`) INNER JOIN `cc_tipo_impuesto`  ON (`" + this.xcc_puc + "`.`Id_TipoImpuesto` = `cc_tipo_impuesto`.`Id`) INNER JOIN `cc_periodo_contable`  ON (`" + this.xcc_documentoc + "`.`Id_PeriodoC` = `cc_periodo_contable`.`Id`) WHERE (`" + this.xcc_documentoc + "`.`Estado` =1 AND `" + this.xcc_puc + "`.`Id_TipoImpuesto` ='" + this.xidtipoimpuesto[this.JCBTipoImpuesto.getSelectedIndex()][0] + "' AND `" + this.xcc_documentoc + "`.`FechaD` >='" + this.xmt.formatoAMD1.format(this.JDFechaI.getDate()) + "' AND `" + this.xcc_documentoc + "`.`FechaD` <='" + this.xmt.formatoAMD1.format(this.JDFechaF.getDate()) + "'  AND `cc_periodo_contable`.`EsCierre` =0) GROUP BY `" + this.xcc_detalle_documentoc + "`.`Id_Tercero`, `" + this.xcc_detalle_documentoc + "`.`Id_Puc`";
        System.out.println("Acomulada " + this.xsql);
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "";
        this.xsql = "insert into cc_tmp(`Id_Tercero`, `Puc`, `Valor`, `BPeriodo`) SELECT  `" + this.xcc_detalle_documentoc + "`.`Id_Tercero` , `" + this.xcc_detalle_documentoc + "`.`Id_Puc` , SUM((`" + this.xcc_detalle_documentoc + "`.`VCredito`-`" + this.xcc_detalle_documentoc + "`.`VDebito`)) AS `STotal` , SUM(if(`" + this.xcc_detalle_documentoc + "`.`VDebito`<>0, (`" + this.xcc_detalle_documentoc + "`.`Base`*-1),`" + this.xcc_detalle_documentoc + "`.`Base`))  AS `SBase` FROM  `" + this.xcc_detalle_documentoc + "` INNER JOIN `" + this.xcc_documentoc + "`  ON (`" + this.xcc_detalle_documentoc + "`.`Id_Documentoc` = `" + this.xcc_documentoc + "`.`Id`) INNER JOIN `cc_tipo_documentoc` ON (cc_tipo_documentoc.`Id`=`" + this.xcc_documentoc + "`.`Id_TipoComprobante`) INNER JOIN `" + this.xcc_puc + "`  ON (`" + this.xcc_detalle_documentoc + "`.`Id_Puc` = `" + this.xcc_puc + "`.`Id`) INNER JOIN `cc_terceros`  ON (`" + this.xcc_detalle_documentoc + "`.`Id_Tercero` = `cc_terceros`.`Id`) INNER JOIN `cc_tipo_impuesto`  ON (`" + this.xcc_puc + "`.`Id_TipoImpuesto` = `cc_tipo_impuesto`.`Id`) INNER JOIN `cc_periodo_contable`  ON (`" + this.xcc_documentoc + "`.`Id_PeriodoC` = `cc_periodo_contable`.`Id`) WHERE (`" + this.xcc_documentoc + "`.`Estado` =1 AND `" + this.xcc_puc + "`.`Id_TipoImpuesto` ='" + this.xidtipoimpuesto[this.JCBTipoImpuesto.getSelectedIndex()][0] + "' AND `" + this.xcc_documentoc + "`.`FechaD` >='" + this.xmt.formatoAMD1.format(this.JDFechaI.getDate()) + "' AND `" + this.xcc_documentoc + "`.`FechaD` <='" + this.xmt.formatoAMD1.format(this.JDFechaF.getDate()) + "'  AND `cc_periodo_contable`.`EsCierre` =0) GROUP BY `" + this.xcc_detalle_documentoc + "`.`Id_Tercero`, `" + this.xcc_detalle_documentoc + "`.`Id_Puc`";
        System.out.println("VPeriodo " + this.xsql);
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "";
        this.xsql = "SELECT `cc_v_puc_clase`.`Id` AS `IdClase`, `cc_v_puc_clase`.`Nbre` AS `NClase`, `cc_v_puc_auxiliares`.`Id` AS `IdAuxiliar`, `cc_v_puc_auxiliares`.`Nbre` AS `NAuxuliar`, `cc_v_puc_auxiliares`.PBase , `cc_terceros`.`TDCompleto` AS `DocTercero` , `cc_terceros`.`RazonSocialCompleta` AS `NTercero` , sum(`cc_tmp`.`Valor`) AS `VPeriodo` , sum(`cc_tmp`.`BPeriodo`) AS `BPeriodo` , sum(`cc_tmp`.`VAcomulado`) AS `VAcomulado` , sum(`cc_tmp`.`BAcomulada`) AS `BAcomulada` FROM  `cc_terceros` INNER JOIN  `cc_tmp`  ON (`cc_terceros`.`Id` = `cc_tmp`.`Id_Tercero`) INNER JOIN  `cc_v_puc_auxiliares`  ON (`cc_v_puc_auxiliares`.`Id` = `cc_tmp`.`Puc`) INNER JOIN  `cc_v_puc_clase`  ON (`cc_v_puc_clase`.`Id` = `cc_v_puc_auxiliares`.`Clase`)   GROUP BY `cc_tmp`.`Id_Tercero`, `IdAuxiliar` ORDER BY `IdClase` ASC, `IdAuxiliar` ASC, `NTercero` ASC ";
        System.out.println(" Vista : " + this.xsql);
        this.xct.ejecutarSQL("DROP VIEW IF EXISTS cc_v_tmp_datos1");
        this.xct.cerrarConexionBd();
        String sqlw = "CREATE VIEW cc_v_tmp_datos1 AS " + this.xsql;
        this.xct.ejecutarSQL(sqlw);
        this.xct.cerrarConexionBd();
    }
}
