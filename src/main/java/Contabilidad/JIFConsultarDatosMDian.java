package Contabilidad;

import Acceso.Principal;
import ComprasBS.JIFOrdenServicio;
import Utilidades.ConsultasMySQL;
import Utilidades.CustomPopupMenuListener;
import Utilidades.Metodos;
import com.genoma.plus.dao.contabilidad.InformesContabilidadDAO;
import com.genoma.plus.dao.impl.contabilidad.InformesContabilidadDAOImpl;
import com.genoma.plus.dto.gcuenta.GCGenericoDTO;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JYearChooser;
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
import java.beans.PropertyVetoException;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.List;
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
import javax.swing.JFormattedTextField;
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
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:Contabilidad/JIFConsultarDatosMDian.class */
public class JIFConsultarDatosMDian extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private Object[] xdato;
    private String[][] xidformato1;
    private String[][] xidformato;
    private String[] xidmunicipio;
    private String[] IdFormato2;
    private Object[] xDato;
    private String xsql;
    private String xnombre;
    private String xcc_detalle_documentoc;
    private String xcc_puc;
    private String xcc_documentoc;
    private String IdNomina;
    private InformesContabilidadDAO xInformesContabilidadDAO;
    private ButtonGroup JBGOpciones;
    private ButtonGroup JBGTipo;
    private JButton JBTExportar;
    private JComboBox JCBFormato;
    private JComboBox JCBFormato1;
    private JComboBox JCBFormato2;
    private JComboBox JCBMnunicipio;
    private JCheckBox JCHFiltroM;
    private JDateChooser JDFFechaF;
    private JDateChooser JDFFechaI;
    private JPanel JPIDatosDian;
    private JPanel JPIDatosDian1;
    private JPanel JPIDatosID;
    private JRadioButton JRBExcel;
    private JRadioButton JRBTxT;
    private JScrollPane JSPDetalle;
    public JTable JTDetalle;
    private JFormattedTextField JTFFTope;
    private JTextField JTFRuta;
    private JTabbedPane JTPDatos;
    private JYearChooser JYCAno;
    private JYearChooser JYCAno1;
    private JButton jButton1;
    private JButton jButton2;
    private Metodos xmt = new Metodos();
    private ConsultasMySQL xconsultas = new ConsultasMySQL();
    private boolean xlleno = false;
    private int xnfila = 0;

    public JIFConsultarDatosMDian(String xnombre) {
        initComponents();
        this.xnombre = xnombre;
        springStart();
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

    private void springStart() {
        this.xInformesContabilidadDAO = (InformesContabilidadDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("informesContabilidadDAO");
    }

    public void mIdNominasRecorer(String fechaInicial, String fechaFinal) {
        this.IdNomina = "";
        String sql = "SELECT  MAX(`Id`) AS Valor\nFROM\n    `baseserver`.`rh_nomina_liquidacion`\nWHERE (`FechaR` >='" + fechaInicial + "'  AND `FechaR` <='" + fechaFinal + "' ); ";
        ConsultasMySQL xct1 = new ConsultasMySQL();
        ResultSet xrs1 = xct1.traerRs(sql);
        try {
            if (xrs1.next()) {
                xrs1.first();
                this.IdNomina = xrs1.getString("Valor");
            }
            xrs1.close();
            xct1.cerrarConexionBd();
            System.err.println("idnomina" + this.IdNomina);
            this.xInformesContabilidadDAO.mEjecutarSql(this.xmt.formatoAMD1.format(this.JDFFechaI.getDate()), this.xmt.formatoAMD1.format(this.JDFFechaF.getDate()), this.IdNomina, "2");
        } catch (SQLException ex) {
            Logger.getLogger(JIFOrdenServicio.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX WARN: Type inference failed for: r3v6, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGOpciones = new ButtonGroup();
        this.JBGTipo = new ButtonGroup();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JBTExportar = new JButton();
        this.JTFRuta = new JTextField();
        this.JTPDatos = new JTabbedPane();
        this.JPIDatosDian = new JPanel();
        this.JCBFormato = new JComboBox();
        this.JYCAno1 = new JYearChooser();
        this.JPIDatosID = new JPanel();
        this.JYCAno = new JYearChooser();
        this.JCBFormato1 = new JComboBox();
        this.JCHFiltroM = new JCheckBox();
        this.JCBMnunicipio = new JComboBox();
        this.JTFFTope = new JFormattedTextField();
        this.JPIDatosDian1 = new JPanel();
        this.JCBFormato2 = new JComboBox();
        this.JDFFechaI = new JDateChooser();
        this.JDFFechaF = new JDateChooser();
        this.jButton1 = new JButton();
        this.jButton2 = new JButton();
        this.JRBExcel = new JRadioButton();
        this.JRBTxT = new JRadioButton();
        setClosable(true);
        setIconifiable(true);
        setTitle("CONSULTAR INFORMACIÓN MEDIOS DIAN");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifmediosdian");
        setRequestFocusEnabled(false);
        try {
            setSelected(true);
        } catch (PropertyVetoException e1) {
            e1.printStackTrace();
        }
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setBorder(BorderFactory.createBevelBorder(0));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalle.setEditingColumn(1);
        this.JTDetalle.setEditingRow(1);
        this.JTDetalle.setGridColor(new Color(204, 204, 204));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.setSelectionMode(0);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: Contabilidad.JIFConsultarDatosMDian.1
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarDatosMDian.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setForeground(Color.red);
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: Contabilidad.JIFConsultarDatosMDian.2
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarDatosMDian.this.JBTExportarActionPerformed(evt);
            }
        });
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: Contabilidad.JIFConsultarDatosMDian.3
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarDatosMDian.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JTPDatos.setForeground(new Color(0, 103, 0));
        this.JTPDatos.setFont(new Font("Arial", 1, 14));
        this.JPIDatosDian.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JCBFormato.setFont(new Font("Arial", 1, 12));
        this.JCBFormato.setBorder(BorderFactory.createTitledBorder((Border) null, "Formato", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JYCAno1.setBorder(BorderFactory.createTitledBorder((Border) null, "Año", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JYCAno1.addPropertyChangeListener(new PropertyChangeListener() { // from class: Contabilidad.JIFConsultarDatosMDian.4
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFConsultarDatosMDian.this.JYCAno1PropertyChange(evt);
            }
        });
        GroupLayout JPIDatosDianLayout = new GroupLayout(this.JPIDatosDian);
        this.JPIDatosDian.setLayout(JPIDatosDianLayout);
        JPIDatosDianLayout.setHorizontalGroup(JPIDatosDianLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosDianLayout.createSequentialGroup().addContainerGap().addComponent(this.JYCAno1, -2, 95, -2).addGap(18, 18, 18).addComponent(this.JCBFormato, -2, 684, -2).addContainerGap(211, 32767)));
        JPIDatosDianLayout.setVerticalGroup(JPIDatosDianLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosDianLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosDianLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JYCAno1, -2, 50, -2).addComponent(this.JCBFormato, -2, 50, -2)).addGap(12, 12, 12)));
        this.JTPDatos.addTab("DIAN", this.JPIDatosDian);
        this.JPIDatosDian.getAccessibleContext().setAccessibleName("DIAN");
        this.JYCAno.setBorder(BorderFactory.createTitledBorder((Border) null, "Año", 0, 0, new Font("Arial", 1, 13), Color.blue));
        this.JYCAno.addPropertyChangeListener(new PropertyChangeListener() { // from class: Contabilidad.JIFConsultarDatosMDian.5
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFConsultarDatosMDian.this.JYCAnoPropertyChange(evt);
            }
        });
        this.JCBFormato1.setFont(new Font("Arial", 1, 12));
        this.JCBFormato1.setBorder(BorderFactory.createTitledBorder((Border) null, "Formato", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBFormato1.addItemListener(new ItemListener() { // from class: Contabilidad.JIFConsultarDatosMDian.6
            public void itemStateChanged(ItemEvent evt) {
                JIFConsultarDatosMDian.this.JCBFormato1ItemStateChanged(evt);
            }
        });
        this.JCHFiltroM.setFont(new Font("Arial", 1, 12));
        this.JCHFiltroM.setText("Filtro por municipio?");
        this.JCHFiltroM.addActionListener(new ActionListener() { // from class: Contabilidad.JIFConsultarDatosMDian.7
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarDatosMDian.this.JCHFiltroMActionPerformed(evt);
            }
        });
        this.JCBMnunicipio.setFont(new Font("Arial", 1, 12));
        this.JCBMnunicipio.setBorder(BorderFactory.createTitledBorder((Border) null, "Municipio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFTope.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor Tope", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFTope.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFTope.setHorizontalAlignment(4);
        this.JTFFTope.setFont(new Font("Arial", 1, 12));
        GroupLayout JPIDatosIDLayout = new GroupLayout(this.JPIDatosID);
        this.JPIDatosID.setLayout(JPIDatosIDLayout);
        JPIDatosIDLayout.setHorizontalGroup(JPIDatosIDLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosIDLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosIDLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosIDLayout.createSequentialGroup().addComponent(this.JYCAno, -2, 95, -2).addGap(18, 18, 18).addComponent(this.JCBFormato1, -2, 535, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFFTope, -2, 118, -2)).addGroup(JPIDatosIDLayout.createSequentialGroup().addComponent(this.JCBMnunicipio, -2, 535, -2).addGap(18, 18, 18).addComponent(this.JCHFiltroM))).addContainerGap(240, 32767)));
        JPIDatosIDLayout.setVerticalGroup(JPIDatosIDLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosIDLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosIDLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JCBFormato1, -2, -1, -2).addComponent(this.JYCAno, -2, 44, -2).addComponent(this.JTFFTope, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPIDatosIDLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBMnunicipio, -2, -1, -2).addComponent(this.JCHFiltroM)).addContainerGap(-1, 32767)));
        this.JTPDatos.addTab("INFORME POR DISTRITO", this.JPIDatosID);
        this.JPIDatosDian1.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JCBFormato2.setFont(new Font("Arial", 1, 12));
        this.JCBFormato2.setBorder(BorderFactory.createTitledBorder((Border) null, "Formato", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFFechaI.setFont(new Font("Arial", 1, 12));
        this.JDFFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Fin", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFFechaF.setFont(new Font("Arial", 1, 12));
        this.JDFFechaF.addPropertyChangeListener(new PropertyChangeListener() { // from class: Contabilidad.JIFConsultarDatosMDian.8
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFConsultarDatosMDian.this.JDFFechaFPropertyChange(evt);
            }
        });
        this.jButton1.setFont(new Font("Arial", 1, 12));
        this.jButton1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/actualizar.png")));
        this.jButton1.setText("ACTUALIZAR");
        this.jButton1.addActionListener(new ActionListener() { // from class: Contabilidad.JIFConsultarDatosMDian.9
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarDatosMDian.this.jButton1ActionPerformed(evt);
            }
        });
        this.jButton2.setFont(new Font("Arial", 1, 12));
        this.jButton2.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Limpiar.png")));
        this.jButton2.setText("LIMPIAR");
        this.jButton2.addActionListener(new ActionListener() { // from class: Contabilidad.JIFConsultarDatosMDian.10
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarDatosMDian.this.jButton2ActionPerformed(evt);
            }
        });
        GroupLayout JPIDatosDian1Layout = new GroupLayout(this.JPIDatosDian1);
        this.JPIDatosDian1.setLayout(JPIDatosDian1Layout);
        JPIDatosDian1Layout.setHorizontalGroup(JPIDatosDian1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosDian1Layout.createSequentialGroup().addContainerGap().addComponent(this.JDFFechaI, -2, 129, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JDFFechaF, -2, 129, -2).addGap(18, 18, 18).addComponent(this.JCBFormato2, -2, 439, -2).addGap(18, 18, 18).addComponent(this.jButton1).addGap(18, 18, 18).addComponent(this.jButton2).addContainerGap(-1, 32767)));
        JPIDatosDian1Layout.setVerticalGroup(JPIDatosDian1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosDian1Layout.createSequentialGroup().addGroup(JPIDatosDian1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosDian1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JDFFechaF, -2, 50, -2).addComponent(this.JDFFechaI, -2, 50, -2)).addGroup(JPIDatosDian1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBFormato2, -2, 50, -2).addComponent(this.jButton1).addComponent(this.jButton2))).addGap(0, 20, 32767)));
        this.JTPDatos.addTab("DIAN NUEVO FORMATO", this.JPIDatosDian1);
        this.JBGTipo.add(this.JRBExcel);
        this.JRBExcel.setFont(new Font("Arial", 1, 12));
        this.JRBExcel.setSelected(true);
        this.JRBExcel.setText("Excel");
        this.JBGTipo.add(this.JRBTxT);
        this.JRBTxT.setFont(new Font("Arial", 1, 12));
        this.JRBTxT.setText("Texto");
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPDetalle).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.JRBExcel).addGap(18, 18, 18).addComponent(this.JRBTxT).addGap(18, 18, 18).addComponent(this.JTFRuta).addGap(18, 18, 18).addComponent(this.JBTExportar, -2, 413, -2)).addComponent(this.JTPDatos)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTPDatos, -2, 148, -2).addGap(18, 18, 18).addComponent(this.JSPDetalle, -1, 408, 32767).addGap(18, 18, 18).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBExcel).addComponent(this.JRBTxT)).addComponent(this.JTFRuta, -2, 50, -2)).addComponent(this.JBTExportar, -2, 52, -2)).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTExportarActionPerformed(ActionEvent evt) {
        if (this.JTPDatos.getSelectedIndex() == 0) {
            if (this.xidformato[this.JCBFormato.getSelectedIndex()][0].equals("1001")) {
                mExportar();
                return;
            }
            if (this.xidformato[this.JCBFormato.getSelectedIndex()][0].equals("1007")) {
                mExportar1();
                return;
            }
            if (this.xidformato[this.JCBFormato.getSelectedIndex()][0].equals("1008") || this.xidformato[this.JCBFormato.getSelectedIndex()][0].equals("1009")) {
                mExportar2();
                return;
            } else {
                if (this.xidformato[this.JCBFormato.getSelectedIndex()][0].equals("1012")) {
                    mExportar3();
                    return;
                }
                return;
            }
        }
        if (this.JTPDatos.getSelectedIndex() == 1) {
            if (this.JRBExcel.isSelected()) {
                mExportar3();
                return;
            } else {
                mGenerarArchivoTexto();
                return;
            }
        }
        if (this.JTPDatos.getSelectedIndex() == 2) {
            if (this.JRBExcel.isSelected()) {
                this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTDetalle, this.JTFRuta.getText() + ".xls", getTitle());
            } else {
                mGenerarArchivoTexto2();
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
    public void JYCAnoPropertyChange(PropertyChangeEvent evt) {
        if (this.xlleno) {
            mLlenarCommbo();
            mCrearTabla4();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHFiltroMActionPerformed(ActionEvent evt) {
        if (this.JCBFormato1.getSelectedIndex() != -1) {
            if (this.JCHFiltroM.isSelected()) {
                mFiltrarComboMunicipio();
                this.JCBMnunicipio.setEnabled(true);
            } else {
                this.JCBMnunicipio.setEnabled(false);
            }
        }
        this.JCBMnunicipio.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBFormato1ItemStateChanged(ItemEvent evt) {
        if (this.xlleno && this.JCBFormato1.getSelectedIndex() != -1) {
            this.JTFFTope.setValue(Double.valueOf(this.xidformato1[this.JCBFormato1.getSelectedIndex()][1]));
            mCrearTabla4();
            mFiltrarComboMunicipio();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JYCAno1PropertyChange(PropertyChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jButton1ActionPerformed(ActionEvent evt) {
        mIdNominasRecorer(this.xmt.formatoAMD1.format(this.JDFFechaI.getDate()), this.xmt.formatoAMD1.format(this.JDFFechaF.getDate()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFFechaFPropertyChange(PropertyChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jButton2ActionPerformed(ActionEvent evt) {
        this.xInformesContabilidadDAO.eliminarTablaInformes2276();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mModelo2276() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"CARGO", "CODIGO", "GRADO", "NDOCUMENTO", "NOMBRE", "DIRECCION", "ASIGNACIÓN BÁSICA MENSUAL", "MESES LABORADOS ", "ASIGNACION BASICA ANUAL", "PRIMA O SUBSID ALIMENTAC ANUAL", "AUXILIO DE TRANSPORTE ANUAL", "PRIMA DE ANTIGÜEDAD ANUAL", "PRIMA DE SERVICIOS ANUAL", "PRIMA DE NAVIDAD ANUAL", "BONIFIC POR SERVICIOS ANUAL", "BONIFIC DE RECREACIÓN ANUAL", "PRIMA DE VACACIONES ANUAL", "INTERESES SOBRE CESANTÍAS ANUAL", "CESANTÍAS ANUAL"}) { // from class: Contabilidad.JIFConsultarDatosMDian.11
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

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
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(12).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(13).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(14).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(15).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(16).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(17).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(18).setPreferredWidth(150);
    }

    public void mBuscar() {
        if (this.JTPDatos.getSelectedIndex() == 0) {
            if (this.xidformato[this.JCBFormato.getSelectedIndex()][0].equals("1001")) {
                mBuscarDEmpresa1001();
                return;
            }
            if (this.xidformato[this.JCBFormato.getSelectedIndex()][0].equals("1007")) {
                mBuscarDEmpresa1007();
                return;
            }
            if (this.xidformato[this.JCBFormato.getSelectedIndex()][0].equals("1008") || this.xidformato[this.JCBFormato.getSelectedIndex()][0].equals("1009")) {
                mBuscarDEmpresa10081009();
                return;
            } else if (this.xidformato[this.JCBFormato.getSelectedIndex()][0].equals("1012")) {
                mBuscarDEmpresa1012();
                return;
            } else {
                if (this.xidformato[this.JCBFormato.getSelectedIndex()][0].equals("1005")) {
                    consultarDatosFormato1005();
                    return;
                }
                return;
            }
        }
        if (this.JTPDatos.getSelectedIndex() == 1) {
            if (this.JCBFormato1.getSelectedIndex() != -1) {
                if (this.JCHFiltroM.isSelected()) {
                    if (this.JCBMnunicipio.getSelectedIndex() != -1) {
                        if (this.xidformato1[this.JCBFormato1.getSelectedIndex()][0].equals("9002")) {
                            this.xsql = "SELECT DATE_FORMAT(`cc_periodo_contable`.`FechaI`,'%Y') AS `Ano`, `cc_tercero`.`Id_TipoIdentificacionEC`, MID(`cc_tercero`.`No_identificacion`,1,11) AS NID, MID(`cc_tercero`.`NEmpresa`,1,70) AS NEMpresa, MID(`cc_tercero`.`Direccion`,1,70) AS Direccion,  MID(`cc_tercero`.`Tel_Numero`,1,10) AS NTelefono,MID(`cc_tercero`.`Correo`,1,70) AS Email, CONCAT(`cc_tercero`.`CodDepartamento`,'',`cc_tercero`.`CodNMunicipio`) AS NMunicipio , `cc_tercero`.`CodDepartamento`,  cc_tipo_concepto_pago.`Codigo`,SUM((`" + this.xcc_detalle_documentoc + "`.`VCredito`)) AS `Valor1` ,SUM((`" + this.xcc_detalle_documentoc + "`.`VDebito`)) AS `Valor2` , `cc_tercero`.NMunicipio, `cc_tercero`.`IdMunicipioR` FROM  `" + this.xcc_detalle_documentoc + "` INNER JOIN  `" + this.xcc_documentoc + "`  ON (`" + this.xcc_detalle_documentoc + "`.`Id_Documentoc` = `" + this.xcc_documentoc + "`.`Id`) INNER JOIN  `" + this.xcc_puc + "`  ON (`" + this.xcc_detalle_documentoc + "`.`Id_Puc` = `" + this.xcc_puc + "`.`Id`) INNER JOIN  `cc_tercero`  ON (`" + this.xcc_detalle_documentoc + "`.`Id_Tercero` = `cc_tercero`.`Id`) INNER JOIN  `cc_tipo_concepto_dian`   ON (`cc_tipo_concepto_dian`.`Id` = `" + this.xcc_puc + "`.`Id_TipoConceptoID`) INNER JOIN  `cc_tipo_formato_concepto_dian`  ON (`cc_tipo_formato_concepto_dian`.`Id_ConceptoDian` = `cc_tipo_concepto_dian`.`Id`) INNER JOIN `cc_periodo_contable`  ON (cc_periodo_contable.`Id` = " + this.xcc_documentoc + ".`Id_PeriodoC`) INNER JOIN  `cc_tipo_formato_dian`  ON (`cc_tipo_formato_concepto_dian`.`Id_FormatoDian` = `cc_tipo_formato_dian`.`Id`) INNER JOIN  `cc_tipo_impuesto`  ON (`cc_tipo_impuesto`.`Id` = `" + this.xcc_puc + "`.`Id_TipoImpuesto`) INNER JOIN  `cc_tipo_concepto_pago` ON (`cc_tipo_concepto_pago`.`Id` = `" + this.xcc_puc + "`.`Id_ConceptoP`) WHERE (DATE_FORMAT(`cc_periodo_contable`.`FechaI`,'%Y') ='" + this.JYCAno.getValue() + "' AND `" + this.xcc_documentoc + "`.`Estado` =1 AND `cc_periodo_contable`.`EsCierre`=0 and  `cc_tercero`.`IdMunicipioR` ='" + this.xidmunicipio[this.JCBMnunicipio.getSelectedIndex()] + "' AND `cc_tipo_concepto_dian`.`Id` ='" + this.xidformato1[this.JCBFormato1.getSelectedIndex()][0] + "') GROUP BY `cc_tercero`.`Id`, cc_tipo_concepto_pago.`Id` HAVING (`Valor1` >=" + Double.valueOf(this.JTFFTope.getValue().toString()) + ") ORDER BY `cc_tercero`.`NEmpresa` ASC ";
                        } else {
                            this.xsql = "SELECT DATE_FORMAT(`cc_periodo_contable`.`FechaI`,'%Y') AS `Ano`, `cc_tercero`.`Id_TipoIdentificacionEC`, MID(`cc_tercero`.`No_identificacion`,1,11) AS NID, MID(`cc_tercero`.`NEmpresa`,1,70) AS NEMpresa, MID(`cc_tercero`.`Direccion`,1,70) AS Direccion,  MID(`cc_tercero`.`Tel_Numero`,1,10) AS NTelefono,MID(`cc_tercero`.`Correo`,1,70) AS Email, CONCAT(`cc_tercero`.`CodDepartamento`,'',`cc_tercero`.`CodNMunicipio`) AS NMunicipio , `cc_tercero`.`CodDepartamento`,  cc_tipo_concepto_pago.`Codigo`,ROUND(SUM((`" + this.xcc_detalle_documentoc + "`.`VDebito`-`" + this.xcc_detalle_documentoc + "`.`VCredito`))) AS `Valor1` , 0 AS `Valor2` , `cc_tercero`.NMunicipio, `cc_tercero`.`IdMunicipioR` FROM  `" + this.xcc_detalle_documentoc + "` INNER JOIN  `" + this.xcc_documentoc + "`  ON (`" + this.xcc_detalle_documentoc + "`.`Id_Documentoc` = `" + this.xcc_documentoc + "`.`Id`) INNER JOIN  `" + this.xcc_puc + "`  ON (`" + this.xcc_detalle_documentoc + "`.`Id_Puc` = `" + this.xcc_puc + "`.`Id`) INNER JOIN  `cc_tercero`  ON (`" + this.xcc_detalle_documentoc + "`.`Id_Tercero` = `cc_tercero`.`Id`) INNER JOIN  `cc_tipo_concepto_dian`   ON (`cc_tipo_concepto_dian`.`Id` = `" + this.xcc_puc + "`.`Id_TipoConceptoID`) INNER JOIN  `cc_tipo_formato_concepto_dian`  ON (`cc_tipo_formato_concepto_dian`.`Id_ConceptoDian` = `cc_tipo_concepto_dian`.`Id`) INNER JOIN `cc_periodo_contable`  ON (cc_periodo_contable.`Id` = " + this.xcc_documentoc + ".`Id_PeriodoC`) INNER JOIN  `cc_tipo_formato_dian`  ON (`cc_tipo_formato_concepto_dian`.`Id_FormatoDian` = `cc_tipo_formato_dian`.`Id`) INNER JOIN  `cc_tipo_impuesto`  ON (`cc_tipo_impuesto`.`Id` = `" + this.xcc_puc + "`.`Id_TipoImpuesto`) INNER JOIN  `cc_tipo_concepto_pago` ON (`cc_tipo_concepto_pago`.`Id` = `" + this.xcc_puc + "`.`Id_ConceptoP`) WHERE (`cc_tipo_impuesto`.`EsImpuestos`=0 AND DATE_FORMAT(`cc_periodo_contable`.`FechaI`,'%Y') ='" + this.JYCAno.getValue() + "' AND `" + this.xcc_documentoc + "`.`Estado` =1 AND `cc_periodo_contable`.`EsCierre`=0 and  `cc_tercero`.`IdMunicipioR` ='" + this.xidmunicipio[this.JCBMnunicipio.getSelectedIndex()] + "' AND `cc_tipo_concepto_dian`.`Id` ='" + this.xidformato1[this.JCBFormato1.getSelectedIndex()][0] + "') GROUP BY `cc_tercero`.`Id`, cc_tipo_concepto_pago.`Id`  HAVING (`Valor1` >=" + Double.valueOf(this.JTFFTope.getValue().toString()) + ") ORDER BY `cc_tercero`.`NEmpresa` ASC ";
                        }
                        mBuscarDatos(this.xsql);
                        return;
                    }
                    JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un municipio", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    this.JCBMnunicipio.requestFocus();
                    return;
                }
                if (this.xidformato1[this.JCBFormato1.getSelectedIndex()][0].equals("9002")) {
                    this.xsql = "SELECT DATE_FORMAT(`cc_periodo_contable`.`FechaI`,'%Y') AS `Ano`, `cc_tercero`.`Id_TipoIdentificacionEC`, MID(`cc_tercero`.`No_identificacion`,1,11) AS NID, MID(`cc_tercero`.`NEmpresa`,1,70) AS NEMpresa, MID(`cc_tercero`.`Direccion`,1,70) AS Direccion,  MID(`cc_tercero`.`Tel_Numero`,1,10) AS NTelefono,MID(`cc_tercero`.`Correo`,1,70) AS Email, CONCAT(`cc_tercero`.`CodDepartamento`,'',`cc_tercero`.`CodNMunicipio`) AS NMunicipio , `cc_tercero`.`CodDepartamento`,  cc_tipo_concepto_pago.`Codigo`,SUM((`" + this.xcc_detalle_documentoc + "`.`VCredito`)) AS `Valor1` ,SUM((`" + this.xcc_detalle_documentoc + "`.`VDebito`)) AS `Valor2` , `cc_tercero`.NMunicipio, `cc_tercero`.`IdMunicipioR` FROM  `" + this.xcc_detalle_documentoc + "` INNER JOIN  `" + this.xcc_documentoc + "`  ON (`" + this.xcc_detalle_documentoc + "`.`Id_Documentoc` = `" + this.xcc_documentoc + "`.`Id`) INNER JOIN  `" + this.xcc_puc + "`  ON (`" + this.xcc_detalle_documentoc + "`.`Id_Puc` = `" + this.xcc_puc + "`.`Id`) INNER JOIN  `cc_tercero`  ON (`" + this.xcc_detalle_documentoc + "`.`Id_Tercero` = `cc_tercero`.`Id`) INNER JOIN  `cc_tipo_concepto_dian`   ON (`cc_tipo_concepto_dian`.`Id` = `" + this.xcc_puc + "`.`Id_TipoConceptoID`) INNER JOIN  `cc_tipo_formato_concepto_dian`  ON (`cc_tipo_formato_concepto_dian`.`Id_ConceptoDian` = `cc_tipo_concepto_dian`.`Id`) INNER JOIN  `cc_tipo_formato_dian`  ON (`cc_tipo_formato_concepto_dian`.`Id_FormatoDian` = `cc_tipo_formato_dian`.`Id`) INNER JOIN `cc_periodo_contable`  ON (cc_periodo_contable.`Id` = " + this.xcc_documentoc + ".`Id_PeriodoC`) INNER JOIN  `cc_tipo_impuesto`  ON (`cc_tipo_impuesto`.`Id` = `" + this.xcc_puc + "`.`Id_TipoImpuesto`) INNER JOIN  `cc_tipo_concepto_pago` ON (`cc_tipo_concepto_pago`.`Id` = `" + this.xcc_puc + "`.`Id_ConceptoP`) WHERE (DATE_FORMAT(`cc_periodo_contable`.`FechaI`,'%Y') ='" + this.JYCAno.getValue() + "' AND `cc_periodo_contable`.`EsCierre`=0 AND `" + this.xcc_documentoc + "`.`Estado` =1 AND `cc_tipo_concepto_dian`.`Id` ='" + this.xidformato1[this.JCBFormato1.getSelectedIndex()][0] + "') GROUP BY `cc_tercero`.`Id`, cc_tipo_concepto_pago.`Id` HAVING (`Valor1` >=" + Double.valueOf(this.JTFFTope.getValue().toString()) + ") ORDER BY `cc_tercero`.`NEmpresa` ASC ";
                } else {
                    this.xsql = "SELECT DATE_FORMAT(`cc_periodo_contable`.`FechaI`,'%Y') AS `Ano`, `cc_tercero`.`Id_TipoIdentificacionEC`, MID(`cc_tercero`.`No_identificacion`,1,11) AS NID, MID(`cc_tercero`.`NEmpresa`,1,70) AS NEMpresa, MID(`cc_tercero`.`Direccion`,1,70) AS Direccion,  MID(`cc_tercero`.`Tel_Numero`,1,10) AS NTelefono,MID(`cc_tercero`.`Correo`,1,70) AS Email, CONCAT(`cc_tercero`.`CodDepartamento`,'',`cc_tercero`.`CodNMunicipio`) AS NMunicipio , `cc_tercero`.`CodDepartamento`,  cc_tipo_concepto_pago.`Codigo`,ROUND(SUM((`" + this.xcc_detalle_documentoc + "`.`VDebito`-`" + this.xcc_detalle_documentoc + "`.`VCredito`))) AS `Valor1` , 0 AS `Valor2` , `cc_tercero`.NMunicipio, `cc_tercero`.`IdMunicipioR` FROM  `" + this.xcc_detalle_documentoc + "` INNER JOIN  `" + this.xcc_documentoc + "`  ON (`" + this.xcc_detalle_documentoc + "`.`Id_Documentoc` = `" + this.xcc_documentoc + "`.`Id`) INNER JOIN  `" + this.xcc_puc + "`  ON (`" + this.xcc_detalle_documentoc + "`.`Id_Puc` = `" + this.xcc_puc + "`.`Id`) INNER JOIN  `cc_tercero`  ON (`" + this.xcc_detalle_documentoc + "`.`Id_Tercero` = `cc_tercero`.`Id`) INNER JOIN  `cc_tipo_concepto_dian`   ON (`cc_tipo_concepto_dian`.`Id` = `" + this.xcc_puc + "`.`Id_TipoConceptoID`) INNER JOIN  `cc_tipo_formato_concepto_dian`  ON (`cc_tipo_formato_concepto_dian`.`Id_ConceptoDian` = `cc_tipo_concepto_dian`.`Id`) INNER JOIN  `cc_tipo_formato_dian`  ON (`cc_tipo_formato_concepto_dian`.`Id_FormatoDian` = `cc_tipo_formato_dian`.`Id`) INNER JOIN `cc_periodo_contable`  ON (cc_periodo_contable.`Id` = " + this.xcc_documentoc + ".`Id_PeriodoC`) INNER JOIN  `cc_tipo_impuesto`  ON (`cc_tipo_impuesto`.`Id` = `" + this.xcc_puc + "`.`Id_TipoImpuesto`) INNER JOIN  `cc_tipo_concepto_pago` ON (`cc_tipo_concepto_pago`.`Id` = `" + this.xcc_puc + "`.`Id_ConceptoP`) WHERE (`cc_tipo_impuesto`.`EsImpuestos`=0 and DATE_FORMAT(`cc_periodo_contable`.`FechaI`,'%Y') ='" + this.JYCAno.getValue() + "' AND `" + this.xcc_documentoc + "`.`Estado` =1 AND `cc_periodo_contable`.`EsCierre`=0 AND `cc_tipo_concepto_dian`.`Id` ='" + this.xidformato1[this.JCBFormato1.getSelectedIndex()][0] + "') GROUP BY `cc_tercero`.`Id`, cc_tipo_concepto_pago.`Id` HAVING (`Valor1` >=" + Double.valueOf(this.JTFFTope.getValue().toString()) + ") ORDER BY `cc_tercero`.`NEmpresa` ASC ";
                }
                mBuscarDatos(this.xsql);
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un formato", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBFormato1.requestFocus();
            return;
        }
        if (this.JTPDatos.getSelectedIndex() == 2) {
            mBuscarDEmpresa2276();
        }
    }

    public void mNuevo() {
        this.JDFFechaI.setDate(this.xmt.getFechaActual());
        this.JDFFechaF.setDate(this.xmt.getFechaActual());
        this.JCBFormato.removeAllItems();
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
        this.xsql = "SELECT cc_tipo_formato_dian.Id, CONCAT(cc_tipo_formato_dian.Id ,' - ', cc_tipo_formato_dian.Nbre) AS Nbre, cc_tipo_formato_dian.Tope  FROM cc_tipo_concepto_dian INNER JOIN " + this.xcc_puc + "  ON (cc_tipo_concepto_dian.Id = " + this.xcc_puc + ".Id_TipoConceptoDian) INNER JOIN " + this.xcc_detalle_documentoc + "  ON (" + this.xcc_puc + ".Id = " + this.xcc_detalle_documentoc + ".Id_Puc) INNER JOIN cc_tipo_formato_concepto_dian  ON (cc_tipo_formato_concepto_dian.Id_ConceptoDian = cc_tipo_concepto_dian.Id) INNER JOIN cc_tipo_formato_dian  ON (cc_tipo_formato_concepto_dian.Id_FormatoDian = cc_tipo_formato_dian.Id)  GROUP BY cc_tipo_formato_dian.Id ORDER BY cc_tipo_formato_dian.Id ASC, cc_tipo_formato_dian.Nbre ASC ";
        this.xidformato = this.xconsultas.llenarComboyLista(this.xsql, this.xidformato, this.JCBFormato, 3);
        this.JCBFormato.setSelectedIndex(-1);
        this.xconsultas.cerrarConexionBd();
        if (this.xnombre.equals("jifmediosdian")) {
            this.JTPDatos.setEnabledAt(0, true);
            this.JTPDatos.setEnabledAt(1, false);
            this.JTPDatos.setSelectedIndex(0);
        } else if (this.xnombre.equals("jifmediosid")) {
            this.JTPDatos.setEnabledAt(0, false);
            this.JTPDatos.setEnabledAt(1, true);
            this.JTPDatos.setSelectedIndex(1);
            mCrearTabla4();
        }
        this.JTFFTope.setValue(new Double(0.0d));
        this.JCBMnunicipio.setEditable(false);
        mLlenarCommbo();
        this.xlleno = true;
    }

    private void mLlenarCommbo() {
        this.xlleno = false;
        this.JTFFTope.setValue(new Double(0.0d));
        this.xsql = "SELECT `cc_tipo_concepto_dian`.`Id`, `cc_tipo_concepto_dian`.`Nbre`, cc_tipo_concepto_dian.Tope  FROM  `" + this.xcc_detalle_documentoc + "` INNER JOIN  `" + this.xcc_documentoc + "`  ON (`" + this.xcc_detalle_documentoc + "`.`Id_Documentoc` = `" + this.xcc_documentoc + "`.`Id`) INNER JOIN `cc_periodo_contable`  ON (cc_periodo_contable.`Id` = " + this.xcc_documentoc + ".`Id_PeriodoC`) INNER JOIN  `" + this.xcc_puc + "`  ON (`" + this.xcc_detalle_documentoc + "`.`Id_Puc` = `" + this.xcc_puc + "`.`Id`) INNER JOIN  `cc_tipo_concepto_dian`  ON (`" + this.xcc_puc + "`.`Id_TipoConceptoID` = `cc_tipo_concepto_dian`.`Id`) WHERE (`cc_tipo_concepto_dian`.`Id` <>'0000' AND DATE_FORMAT(`cc_periodo_contable`.`FechaI`, '%Y') ='" + this.JYCAno1.getValue() + "' AND cc_periodo_contable.`EsCierre`=0 AND `" + this.xcc_documentoc + "`.`Estado` =1) GROUP BY `cc_tipo_concepto_dian`.`Id` ORDER BY `cc_tipo_concepto_dian`.`Nbre` ASC ";
        this.JCBFormato1.removeAllItems();
        this.xidformato1 = this.xconsultas.llenarComboyLista(this.xsql, this.xidformato1, this.JCBFormato1, 3);
        if (this.xidformato1.length > 1) {
            this.JCBFormato1.setSelectedIndex(-1);
        }
        this.xsql = "SELECT `cc_tercero`.`IdMunicipioR`, UCASE(CONCAT(`cc_tercero`.`NMunicipio`,' - ', `cc_tercero`.`NDepartamento`)) AS Municipio FROM  `" + this.xcc_detalle_documentoc + "` INNER JOIN  `" + this.xcc_documentoc + "`  ON (`" + this.xcc_detalle_documentoc + "`.`Id_Documentoc` = `" + this.xcc_documentoc + "`.`Id`) INNER JOIN `" + this.xcc_puc + "`  ON (`" + this.xcc_detalle_documentoc + "`.`Id_Puc` = `" + this.xcc_puc + "`.`Id`) INNER JOIN  `cc_tercero` ON (`" + this.xcc_detalle_documentoc + "`.`Id_Tercero` = `cc_tercero`.`Id`) INNER JOIN  `cc_tipo_concepto_dian`  ON (`" + this.xcc_puc + "`.`Id_TipoConceptoID` = `cc_tipo_concepto_dian`.`Id`) INNER JOIN `cc_periodo_contable`  ON (cc_periodo_contable.`Id` = " + this.xcc_documentoc + ".`Id_PeriodoC`) WHERE (`cc_tipo_concepto_dian`.`Id` <>'0000' AND DATE_FORMAT(`cc_periodo_contable`.`FechaI`, '%Y') ='" + this.JYCAno1.getValue() + "' AND cc_periodo_contable.`EsCierre`=0 AND `" + this.xcc_documentoc + "`.`Estado` =1) GROUP BY `cc_tercero`.`IdMunicipioR` ORDER BY `cc_tercero`.`NMunicipio` ASC ";
        this.xidmunicipio = this.xconsultas.llenarCombo(this.xsql, this.xidmunicipio, this.JCBMnunicipio);
        if (this.xidmunicipio.length > 1) {
            this.JCBMnunicipio.setSelectedIndex(-1);
        }
        this.xconsultas.cerrarConexionBd();
        this.xlleno = true;
        this.JCBFormato2.removeAllItems();
        List<GCGenericoDTO> list1 = this.xInformesContabilidadDAO.listTdeFormatosDian();
        this.IdFormato2 = new String[list1.size()];
        for (int x = 0; x < list1.size(); x++) {
            this.IdFormato2[x] = String.valueOf(list1.get(x).getId());
            this.JCBFormato2.addItem(list1.get(x).getNombre());
        }
        this.JCBFormato2.addPopupMenuListener(new CustomPopupMenuListener(true, false));
        this.JCBFormato2.setSelectedIndex(-1);
    }

    private void mFiltrarComboMunicipio() {
        this.JCBMnunicipio.removeAllItems();
        this.xsql = "SELECT `cc_tercero`.`IdMunicipioR`, UCASE(CONCAT(`cc_tercero`.`NMunicipio`,' - ', `cc_tercero`.`NDepartamento`)) AS Municipio FROM  `" + this.xcc_detalle_documentoc + "` INNER JOIN  `" + this.xcc_documentoc + "`  ON (`" + this.xcc_detalle_documentoc + "`.`Id_Documentoc` = `" + this.xcc_documentoc + "`.`Id`) INNER JOIN  `cc_periodo_contable` ON (`cc_periodo_contable`.`Id` = `" + this.xcc_documentoc + "`.`Id_PeriodoC`)  INNER JOIN `" + this.xcc_puc + "`  ON (`" + this.xcc_detalle_documentoc + "`.`Id_Puc` = `" + this.xcc_puc + "`.`Id`) INNER JOIN  `cc_tercero` ON (`" + this.xcc_detalle_documentoc + "`.`Id_Tercero` = `cc_tercero`.`Id`) INNER JOIN  `cc_tipo_concepto_dian`  ON (`" + this.xcc_puc + "`.`Id_TipoConceptoID` = `cc_tipo_concepto_dian`.`Id`) WHERE (`cc_tipo_concepto_dian`.`Id`='" + this.xidformato1[this.JCBFormato1.getSelectedIndex()][0] + "' AND cc_periodo_contable.`EsCierre`=0 AND DATE_FORMAT(`cc_periodo_contable`.`FechaI`, '%Y') ='" + this.JYCAno1.getValue() + "' AND `" + this.xcc_documentoc + "`.`Estado` =1) GROUP BY `cc_tercero`.`IdMunicipioR` ORDER BY `cc_tercero`.`NMunicipio` ASC ";
        this.xidmunicipio = this.xconsultas.llenarCombo(this.xsql, this.xidmunicipio, this.JCBMnunicipio);
        if (this.xidmunicipio.length > 1) {
            this.JCBMnunicipio.setSelectedIndex(-1);
        }
        this.xconsultas.cerrarConexionBd();
    }

    private void mCargarDetalleTableF1001(String xconcepto) {
        ConsultasMySQL xct = new ConsultasMySQL();
        String sql = "SELECT round(ABS((SUM(" + this.xcc_detalle_documentoc + ".VDebito)-SUM(" + this.xcc_detalle_documentoc + ".VCredito)) )) AS Valor, cc_terceros.Id as IdTercero, cc_tipo_concepto_dian.Id as IdConcepto FROM cc_tipo_concepto_dian INNER JOIN " + this.xcc_puc + "  ON (cc_tipo_concepto_dian.Id = " + this.xcc_puc + ".Id_TipoConceptoDian) INNER JOIN " + this.xcc_detalle_documentoc + " ON (" + this.xcc_puc + ".Id = " + this.xcc_detalle_documentoc + ".Id_Puc) INNER JOIN cc_tipo_formato_concepto_dian  ON (cc_tipo_formato_concepto_dian.Id_ConceptoDian = cc_tipo_concepto_dian.Id) INNER JOIN cc_tipo_formato_dian  ON (cc_tipo_formato_concepto_dian.Id_FormatoDian = cc_tipo_formato_dian.Id) INNER JOIN " + this.xcc_documentoc + "  ON (" + this.xcc_detalle_documentoc + ".Id_Documentoc = " + this.xcc_documentoc + ".Id) INNER JOIN cc_terceros  ON (" + this.xcc_detalle_documentoc + ".Id_Tercero = cc_terceros.Id) INNER JOIN cc_tipo_impuesto  ON (" + this.xcc_puc + ".Id_TipoImpuesto = cc_tipo_impuesto.Id) INNER JOIN `cc_periodo_contable`  ON (cc_periodo_contable.`Id` = " + this.xcc_documentoc + ".`Id_PeriodoC`) WHERE (cc_tipo_formato_dian.Id =1001 AND " + this.xcc_documentoc + ".Estado =1 AND cc_periodo_contable.`EsCierre`=0 AND DATE_FORMAT(`cc_periodo_contable`.`FechaI`, '%Y') ='" + this.JYCAno1.getValue() + "' AND " + this.xcc_puc + ".EsDeduccionDian =0 AND cc_tipo_impuesto.EsImpuestos =0 AND   cc_tipo_concepto_dian.Id= '" + xconcepto + "') GROUP BY cc_terceros.Id ";
        this.xsql = "DROP VIEW IF EXISTS v_cc_tmp  ";
        xct.ejecutarSQL(this.xsql);
        xct.cerrarConexionBd();
        this.xsql = "CREATE VIEW v_cc_tmp   AS " + sql;
        xct.ejecutarSQL(this.xsql);
        xct.cerrarConexionBd();
        this.xsql = "UPDATE cc_tmp_f1001, v_cc_tmp SET cc_tmp_f1001.V1=v_cc_tmp.Valor WHERE cc_tmp_f1001.Id_Tercero=v_cc_tmp.IdTercero AND cc_tmp_f1001.Concepto=IdConcepto";
        xct.ejecutarSQL(this.xsql);
        xct.cerrarConexionBd();
        String sql2 = "SELECT ABS((SUM(" + this.xcc_detalle_documentoc + ".VDebito)-SUM(" + this.xcc_detalle_documentoc + ".VCredito)) ) AS Valor, cc_terceros.Id as IdTercero, cc_tipo_concepto_dian.Id as IdConcepto FROM cc_tipo_concepto_dian INNER JOIN " + this.xcc_puc + "  ON (cc_tipo_concepto_dian.Id = " + this.xcc_puc + ".Id_TipoConceptoDian) INNER JOIN " + this.xcc_detalle_documentoc + "  ON (" + this.xcc_puc + ".Id = " + this.xcc_detalle_documentoc + ".Id_Puc) INNER JOIN cc_tipo_formato_concepto_dian ON (cc_tipo_formato_concepto_dian.Id_ConceptoDian = cc_tipo_concepto_dian.Id) INNER JOIN cc_tipo_formato_dian  ON (cc_tipo_formato_concepto_dian.Id_FormatoDian = cc_tipo_formato_dian.Id) INNER JOIN " + this.xcc_documentoc + "  ON (" + this.xcc_detalle_documentoc + ".Id_Documentoc = " + this.xcc_documentoc + ".Id) INNER JOIN cc_terceros  ON (" + this.xcc_detalle_documentoc + ".Id_Tercero = cc_terceros.Id) INNER JOIN cc_tipo_impuesto  ON (" + this.xcc_puc + ".Id_TipoImpuesto = cc_tipo_impuesto.Id) INNER JOIN `cc_periodo_contable`  ON (cc_periodo_contable.`Id` = " + this.xcc_documentoc + ".`Id_PeriodoC`) WHERE (cc_tipo_formato_dian.Id =1001 AND " + this.xcc_documentoc + ".Estado =1 AND   cc_tipo_concepto_dian.Id= '" + xconcepto + "' AND cc_periodo_contable.`EsCierre`=0  AND DATE_FORMAT(`cc_periodo_contable`.`FechaI`, '%Y') ='" + this.JYCAno1.getValue() + "' AND " + this.xcc_puc + ".EsDeduccionDian =1 AND cc_tipo_impuesto.EsImpuestos =0) GROUP BY cc_terceros.Id ";
        this.xsql = "DROP VIEW IF EXISTS v_cc_tmp  ";
        xct.ejecutarSQL(this.xsql);
        xct.cerrarConexionBd();
        this.xsql = "CREATE VIEW v_cc_tmp   AS " + sql2;
        xct.ejecutarSQL(this.xsql);
        xct.cerrarConexionBd();
        this.xsql = "UPDATE cc_tmp_f1001, v_cc_tmp SET cc_tmp_f1001.V2=v_cc_tmp.Valor WHERE cc_tmp_f1001.Id_Tercero=v_cc_tmp.IdTercero AND cc_tmp_f1001.Concepto=IdConcepto";
        xct.ejecutarSQL(this.xsql);
        xct.cerrarConexionBd();
        String sql3 = "SELECT ABS((SUM(" + this.xcc_detalle_documentoc + ".VDebito)-SUM(" + this.xcc_detalle_documentoc + ".VCredito)) ) AS Valor , cc_terceros.Id as IdTercero, cc_tipo_concepto_dian.Id as IdConcepto FROM cc_tipo_concepto_dian INNER JOIN " + this.xcc_puc + "  ON (cc_tipo_concepto_dian.Id = " + this.xcc_puc + ".Id_TipoConceptoDian)  INNER JOIN " + this.xcc_detalle_documentoc + "  ON (" + this.xcc_puc + ".Id = " + this.xcc_detalle_documentoc + ".Id_Puc) INNER JOIN cc_tipo_formato_concepto_dian  ON (cc_tipo_formato_concepto_dian.Id_ConceptoDian = cc_tipo_concepto_dian.Id) INNER JOIN cc_tipo_formato_dian  ON (cc_tipo_formato_concepto_dian.Id_FormatoDian = cc_tipo_formato_dian.Id) INNER JOIN " + this.xcc_documentoc + "  ON (" + this.xcc_detalle_documentoc + ".Id_Documentoc = " + this.xcc_documentoc + ".Id) INNER JOIN cc_terceros  ON (" + this.xcc_detalle_documentoc + ".Id_Tercero = cc_terceros.Id) INNER JOIN cc_tipo_impuesto  ON (" + this.xcc_puc + ".Id_TipoImpuesto = cc_tipo_impuesto.Id) INNER JOIN `cc_periodo_contable`  ON (cc_periodo_contable.`Id` = " + this.xcc_documentoc + ".`Id_PeriodoC`) WHERE (cc_tipo_formato_dian.Id =1001 AND " + this.xcc_documentoc + ".Estado =1 AND cc_tipo_concepto_dian.Id= '" + xconcepto + "' AND cc_periodo_contable.`EsCierre`=0 AND DATE_FORMAT(`cc_periodo_contable`.`FechaI`, '%Y') ='" + this.JYCAno1.getValue() + "' AND " + this.xcc_puc + ".EsDeduccionDian =0 AND cc_tipo_impuesto.EsImpuestos =1 AND cc_tipo_impuesto.Id =5) GROUP BY cc_terceros.Id ";
        this.xsql = "DROP VIEW IF EXISTS v_cc_tmp  ";
        xct.ejecutarSQL(this.xsql);
        xct.cerrarConexionBd();
        this.xsql = "CREATE VIEW v_cc_tmp   AS " + sql3;
        xct.ejecutarSQL(this.xsql);
        xct.cerrarConexionBd();
        this.xsql = "UPDATE cc_tmp_f1001, v_cc_tmp SET cc_tmp_f1001.V3=v_cc_tmp.Valor WHERE cc_tmp_f1001.Id_Tercero=v_cc_tmp.IdTercero AND cc_tmp_f1001.Concepto=IdConcepto";
        xct.ejecutarSQL(this.xsql);
        xct.cerrarConexionBd();
        String sql4 = "SELECT ABS((SUM(" + this.xcc_detalle_documentoc + ".VDebito)-SUM(" + this.xcc_detalle_documentoc + ".VCredito)) ) AS Valor, cc_terceros.Id as IdTercero, cc_tipo_concepto_dian.Id as IdConcepto FROM cc_tipo_concepto_dian  INNER JOIN " + this.xcc_puc + "  ON (cc_tipo_concepto_dian.Id = " + this.xcc_puc + ".Id_TipoConceptoDian) INNER JOIN " + this.xcc_detalle_documentoc + "  ON (" + this.xcc_puc + ".Id = " + this.xcc_detalle_documentoc + ".Id_Puc) INNER JOIN cc_tipo_formato_concepto_dian  ON (cc_tipo_formato_concepto_dian.Id_ConceptoDian = cc_tipo_concepto_dian.Id) INNER JOIN cc_tipo_formato_dian  ON (cc_tipo_formato_concepto_dian.Id_FormatoDian = cc_tipo_formato_dian.Id) INNER JOIN " + this.xcc_documentoc + "  ON (" + this.xcc_detalle_documentoc + ".Id_Documentoc = " + this.xcc_documentoc + ".Id) INNER JOIN cc_terceros  ON (" + this.xcc_detalle_documentoc + ".Id_Tercero = cc_terceros.Id) INNER JOIN cc_tipo_impuesto  ON (" + this.xcc_puc + ".Id_TipoImpuesto = cc_tipo_impuesto.Id) INNER JOIN `cc_periodo_contable`  ON (cc_periodo_contable.`Id` = " + this.xcc_documentoc + ".`Id_PeriodoC`)  WHERE (cc_tipo_formato_dian.Id =1001 AND " + this.xcc_documentoc + ".Estado =1 AND  cc_tipo_concepto_dian.Id= '" + xconcepto + "' AND cc_periodo_contable.`EsCierre`=0 AND DATE_FORMAT(`cc_periodo_contable`.`FechaI`, '%Y') ='" + this.JYCAno1.getValue() + "' AND " + this.xcc_puc + ".EsDeduccionDian =1 AND cc_tipo_impuesto.EsImpuestos =1 AND cc_tipo_impuesto.Id =5) GROUP BY cc_terceros.Id ";
        this.xsql = "DROP VIEW IF EXISTS v_cc_tmp  ";
        xct.ejecutarSQL(this.xsql);
        xct.cerrarConexionBd();
        this.xsql = "CREATE VIEW v_cc_tmp   AS " + sql4;
        xct.ejecutarSQL(this.xsql);
        xct.cerrarConexionBd();
        this.xsql = "UPDATE cc_tmp_f1001, v_cc_tmp SET cc_tmp_f1001.V4=v_cc_tmp.Valor WHERE cc_tmp_f1001.Id_Tercero=v_cc_tmp.IdTercero AND cc_tmp_f1001.Concepto=IdConcepto";
        xct.ejecutarSQL(this.xsql);
        xct.cerrarConexionBd();
        String sql5 = "SELECT  ABS((SUM(" + this.xcc_detalle_documentoc + ".VDebito)-SUM(" + this.xcc_detalle_documentoc + ".VCredito)) ) AS Valor, cc_terceros.Id as IdTercero, cc_tipo_concepto_dian.Id as IdConcepto FROM cc_tipo_concepto_dian INNER JOIN " + this.xcc_puc + "  ON (cc_tipo_concepto_dian.Id = " + this.xcc_puc + ".Id_TipoConceptoDian) INNER JOIN " + this.xcc_detalle_documentoc + "  ON (" + this.xcc_puc + ".Id = " + this.xcc_detalle_documentoc + ".Id_Puc) INNER JOIN cc_tipo_formato_concepto_dian  ON (cc_tipo_formato_concepto_dian.Id_ConceptoDian = cc_tipo_concepto_dian.Id) INNER JOIN cc_tipo_formato_dian  ON (cc_tipo_formato_concepto_dian.Id_FormatoDian = cc_tipo_formato_dian.Id) INNER JOIN " + this.xcc_documentoc + " ON (" + this.xcc_detalle_documentoc + ".Id_Documentoc = " + this.xcc_documentoc + ".Id) INNER JOIN cc_terceros  ON (" + this.xcc_detalle_documentoc + ".Id_Tercero = cc_terceros.Id) INNER JOIN cc_tipo_impuesto  ON (" + this.xcc_puc + ".Id_TipoImpuesto = cc_tipo_impuesto.Id) INNER JOIN `cc_periodo_contable`  ON (cc_periodo_contable.`Id` = " + this.xcc_documentoc + ".`Id_PeriodoC`)  WHERE (cc_tipo_formato_dian.Id =1001 AND " + this.xcc_documentoc + ".Estado =1 AND   cc_tipo_concepto_dian.Id= '" + xconcepto + "' AND cc_periodo_contable.`EsCierre`=0 AND DATE_FORMAT(`cc_periodo_contable`.`FechaI`, '%Y') ='" + this.JYCAno1.getValue() + "' AND cc_tipo_impuesto.EsImpuestos =1 AND cc_tipo_impuesto.Id =3) GROUP BY cc_terceros.Id ";
        this.xsql = "DROP VIEW IF EXISTS v_cc_tmp  ";
        xct.ejecutarSQL(this.xsql);
        xct.cerrarConexionBd();
        this.xsql = "CREATE VIEW v_cc_tmp   AS " + sql5;
        xct.ejecutarSQL(this.xsql);
        xct.cerrarConexionBd();
        this.xsql = "UPDATE cc_tmp_f1001, v_cc_tmp SET cc_tmp_f1001.V5=v_cc_tmp.Valor WHERE cc_tmp_f1001.Id_Tercero=v_cc_tmp.IdTercero AND cc_tmp_f1001.Concepto=IdConcepto";
        xct.ejecutarSQL(this.xsql);
        xct.cerrarConexionBd();
        String sql6 = "SELECT  ABS((SUM(" + this.xcc_detalle_documentoc + ".VDebito)-SUM(" + this.xcc_detalle_documentoc + ".VCredito)) ) AS Valor, cc_terceros.Id as IdTercero, cc_tipo_concepto_dian.Id as IdConcepto FROM cc_tipo_concepto_dian INNER JOIN " + this.xcc_puc + "  ON (cc_tipo_concepto_dian.Id = " + this.xcc_puc + ".Id_TipoConceptoDian) INNER JOIN " + this.xcc_detalle_documentoc + "  ON (" + this.xcc_puc + ".Id = " + this.xcc_detalle_documentoc + ".Id_Puc) INNER JOIN cc_tipo_formato_concepto_dian  ON (cc_tipo_formato_concepto_dian.Id_ConceptoDian = cc_tipo_concepto_dian.Id) INNER JOIN cc_tipo_formato_dian  ON (cc_tipo_formato_concepto_dian.Id_FormatoDian = cc_tipo_formato_dian.Id) INNER JOIN " + this.xcc_documentoc + " ON (" + this.xcc_detalle_documentoc + ".Id_Documentoc = " + this.xcc_documentoc + ".Id) INNER JOIN cc_terceros  ON (" + this.xcc_detalle_documentoc + ".Id_Tercero = cc_terceros.Id) INNER JOIN cc_tipo_impuesto  ON (" + this.xcc_puc + ".Id_TipoImpuesto = cc_tipo_impuesto.Id) INNER JOIN `cc_periodo_contable`  ON (cc_periodo_contable.`Id` = " + this.xcc_documentoc + ".`Id_PeriodoC`)  WHERE (cc_tipo_formato_dian.Id =1001 AND " + this.xcc_documentoc + ".Estado =1 AND   cc_tipo_concepto_dian.Id= '" + xconcepto + "' AND cc_periodo_contable.`EsCierre`=0 AND DATE_FORMAT(`cc_periodo_contable`.`FechaI`, '%Y') ='" + this.JYCAno1.getValue() + "' AND cc_tipo_impuesto.EsImpuestos =1 AND cc_tipo_impuesto.Id =9) GROUP BY cc_terceros.Id ";
        this.xsql = "DROP VIEW IF EXISTS v_cc_tmp  ";
        xct.ejecutarSQL(this.xsql);
        xct.cerrarConexionBd();
        this.xsql = "CREATE VIEW v_cc_tmp   AS " + sql6;
        xct.ejecutarSQL(this.xsql);
        xct.cerrarConexionBd();
        this.xsql = "UPDATE cc_tmp_f1001, v_cc_tmp SET cc_tmp_f1001.V6=v_cc_tmp.Valor WHERE cc_tmp_f1001.Id_Tercero=v_cc_tmp.IdTercero AND cc_tmp_f1001.Concepto=IdConcepto";
        xct.ejecutarSQL(this.xsql);
        xct.cerrarConexionBd();
        String sql7 = "SELECT ABS((SUM(" + this.xcc_detalle_documentoc + ".VDebito)-SUM(" + this.xcc_detalle_documentoc + ".VCredito)) ) AS Valor, cc_terceros.Id as IdTercero, cc_tipo_concepto_dian.Id as IdConcepto FROM cc_tipo_concepto_dian  INNER JOIN " + this.xcc_puc + "  ON (cc_tipo_concepto_dian.Id = " + this.xcc_puc + ".Id_TipoConceptoDian) INNER JOIN " + this.xcc_detalle_documentoc + "  ON (" + this.xcc_puc + ".Id = " + this.xcc_detalle_documentoc + ".Id_Puc) INNER JOIN cc_tipo_formato_concepto_dian  ON (cc_tipo_formato_concepto_dian.Id_ConceptoDian = cc_tipo_concepto_dian.Id) INNER JOIN cc_tipo_formato_dian  ON (cc_tipo_formato_concepto_dian.Id_FormatoDian = cc_tipo_formato_dian.Id) INNER JOIN " + this.xcc_documentoc + "  ON (" + this.xcc_detalle_documentoc + ".Id_Documentoc = " + this.xcc_documentoc + ".Id) INNER JOIN cc_terceros  ON (" + this.xcc_detalle_documentoc + ".Id_Tercero = cc_terceros.Id) INNER JOIN cc_tipo_impuesto  ON (" + this.xcc_puc + ".Id_TipoImpuesto = cc_tipo_impuesto.Id) INNER JOIN `cc_periodo_contable`  ON (cc_periodo_contable.`Id` = " + this.xcc_documentoc + ".`Id_PeriodoC`)  WHERE (cc_tipo_formato_dian.Id =1001 AND " + this.xcc_documentoc + ".Estado =1 AND  cc_tipo_concepto_dian.Id= '" + xconcepto + "' AND cc_periodo_contable.`EsCierre`=0 AND DATE_FORMAT(`cc_periodo_contable`.`FechaI`, '%Y') ='" + this.JYCAno1.getValue() + "' AND cc_tipo_impuesto.EsImpuestos =1 AND cc_tipo_impuesto.Id =1) GROUP BY cc_terceros.Id";
        this.xsql = "DROP VIEW IF EXISTS v_cc_tmp  ";
        xct.ejecutarSQL(this.xsql);
        xct.cerrarConexionBd();
        this.xsql = "CREATE VIEW v_cc_tmp   AS " + sql7;
        xct.ejecutarSQL(this.xsql);
        xct.cerrarConexionBd();
        this.xsql = "UPDATE cc_tmp_f1001, v_cc_tmp SET cc_tmp_f1001.V7=v_cc_tmp.Valor WHERE cc_tmp_f1001.Id_Tercero=v_cc_tmp.IdTercero AND cc_tmp_f1001.Concepto=IdConcepto";
        xct.ejecutarSQL(this.xsql);
        xct.cerrarConexionBd();
        String sql8 = "SELECT ABS((SUM(" + this.xcc_detalle_documentoc + ".VDebito)-SUM(" + this.xcc_detalle_documentoc + ".VCredito)) ) AS Valor, cc_terceros.Id as IdTercero, cc_tipo_concepto_dian.Id as IdConcepto FROM cc_tipo_concepto_dian  INNER JOIN " + this.xcc_puc + "  ON (cc_tipo_concepto_dian.Id = " + this.xcc_puc + ".Id_TipoConceptoDian) INNER JOIN " + this.xcc_detalle_documentoc + "  ON (" + this.xcc_puc + ".Id = " + this.xcc_detalle_documentoc + ".Id_Puc) INNER JOIN cc_tipo_formato_concepto_dian  ON (cc_tipo_formato_concepto_dian.Id_ConceptoDian = cc_tipo_concepto_dian.Id) INNER JOIN cc_tipo_formato_dian  ON (cc_tipo_formato_concepto_dian.Id_FormatoDian = cc_tipo_formato_dian.Id) INNER JOIN " + this.xcc_documentoc + "  ON (" + this.xcc_detalle_documentoc + ".Id_Documentoc = " + this.xcc_documentoc + ".Id) INNER JOIN cc_terceros  ON (" + this.xcc_detalle_documentoc + ".Id_Tercero = cc_terceros.Id) INNER JOIN cc_tipo_impuesto  ON (" + this.xcc_puc + ".Id_TipoImpuesto = cc_tipo_impuesto.Id) INNER JOIN `cc_periodo_contable`  ON (cc_periodo_contable.`Id` = " + this.xcc_documentoc + ".`Id_PeriodoC`)  WHERE (cc_tipo_formato_dian.Id =1001 AND " + this.xcc_documentoc + ".Estado =1 AND  cc_tipo_concepto_dian.Id= '" + xconcepto + "' AND cc_periodo_contable.`EsCierre`=0 AND DATE_FORMAT(`cc_periodo_contable`.`FechaI`, '%Y') ='" + this.JYCAno1.getValue() + "' AND cc_tipo_impuesto.EsImpuestos =1 AND cc_tipo_impuesto.Id =10) GROUP BY cc_terceros.Id";
        this.xsql = "DROP VIEW IF EXISTS v_cc_tmp  ";
        xct.ejecutarSQL(this.xsql);
        xct.cerrarConexionBd();
        this.xsql = "CREATE VIEW v_cc_tmp   AS " + sql8;
        xct.ejecutarSQL(this.xsql);
        xct.cerrarConexionBd();
        this.xsql = "UPDATE cc_tmp_f1001, v_cc_tmp SET cc_tmp_f1001.V9=v_cc_tmp.Valor WHERE cc_tmp_f1001.Id_Tercero=v_cc_tmp.IdTercero AND cc_tmp_f1001.Concepto=IdConcepto";
        xct.ejecutarSQL(this.xsql);
        xct.cerrarConexionBd();
        String sql9 = "SELECT ABS((SUM(" + this.xcc_detalle_documentoc + ".VDebito)-SUM(" + this.xcc_detalle_documentoc + ".VCredito)) ) AS Valor, cc_terceros.Id as IdTercero, cc_tipo_concepto_dian.Id as IdConcepto FROM cc_tipo_concepto_dian  INNER JOIN " + this.xcc_puc + "  ON (cc_tipo_concepto_dian.Id = " + this.xcc_puc + ".Id_TipoConceptoDian) INNER JOIN " + this.xcc_detalle_documentoc + "  ON (" + this.xcc_puc + ".Id = " + this.xcc_detalle_documentoc + ".Id_Puc) INNER JOIN cc_tipo_formato_concepto_dian  ON (cc_tipo_formato_concepto_dian.Id_ConceptoDian = cc_tipo_concepto_dian.Id) INNER JOIN cc_tipo_formato_dian  ON (cc_tipo_formato_concepto_dian.Id_FormatoDian = cc_tipo_formato_dian.Id) INNER JOIN " + this.xcc_documentoc + "  ON (" + this.xcc_detalle_documentoc + ".Id_Documentoc = " + this.xcc_documentoc + ".Id) INNER JOIN cc_terceros  ON (" + this.xcc_detalle_documentoc + ".Id_Tercero = cc_terceros.Id) INNER JOIN cc_tipo_impuesto  ON (" + this.xcc_puc + ".Id_TipoImpuesto = cc_tipo_impuesto.Id) INNER JOIN `cc_periodo_contable`  ON (cc_periodo_contable.`Id` = " + this.xcc_documentoc + ".`Id_PeriodoC`)  WHERE (cc_tipo_formato_dian.Id =1001 AND " + this.xcc_puc + ".EsDeduccionDian =0 AND " + this.xcc_documentoc + ".Estado =1 AND  cc_tipo_concepto_dian.Id= '" + xconcepto + "' AND cc_periodo_contable.`EsCierre`=0 AND DATE_FORMAT(`cc_periodo_contable`.`FechaI`, '%Y') ='" + this.JYCAno1.getValue() + "' AND cc_tipo_impuesto.EsImpuestos =1 AND cc_tipo_impuesto.Id =8) GROUP BY cc_terceros.Id";
        this.xsql = "DROP VIEW IF EXISTS v_cc_tmp  ";
        xct.ejecutarSQL(this.xsql);
        xct.cerrarConexionBd();
        this.xsql = "CREATE VIEW v_cc_tmp   AS " + sql9;
        xct.ejecutarSQL(this.xsql);
        xct.cerrarConexionBd();
        this.xsql = "UPDATE cc_tmp_f1001, v_cc_tmp SET cc_tmp_f1001.V10=v_cc_tmp.Valor WHERE cc_tmp_f1001.Id_Tercero=v_cc_tmp.IdTercero AND cc_tmp_f1001.Concepto=IdConcepto";
        xct.ejecutarSQL(this.xsql);
        xct.cerrarConexionBd();
        String sql10 = "SELECT ABS((SUM(" + this.xcc_detalle_documentoc + ".VDebito)-SUM(" + this.xcc_detalle_documentoc + ".VCredito)) ) AS Valor, cc_terceros.Id as IdTercero, cc_tipo_concepto_dian.Id as IdConcepto FROM cc_tipo_concepto_dian  INNER JOIN " + this.xcc_puc + "  ON (cc_tipo_concepto_dian.Id = " + this.xcc_puc + ".Id_TipoConceptoDian) INNER JOIN " + this.xcc_detalle_documentoc + "  ON (" + this.xcc_puc + ".Id = " + this.xcc_detalle_documentoc + ".Id_Puc) INNER JOIN cc_tipo_formato_concepto_dian  ON (cc_tipo_formato_concepto_dian.Id_ConceptoDian = cc_tipo_concepto_dian.Id) INNER JOIN cc_tipo_formato_dian  ON (cc_tipo_formato_concepto_dian.Id_FormatoDian = cc_tipo_formato_dian.Id) INNER JOIN " + this.xcc_documentoc + "  ON (" + this.xcc_detalle_documentoc + ".Id_Documentoc = " + this.xcc_documentoc + ".Id) INNER JOIN cc_terceros  ON (" + this.xcc_detalle_documentoc + ".Id_Tercero = cc_terceros.Id) INNER JOIN cc_tipo_impuesto  ON (" + this.xcc_puc + ".Id_TipoImpuesto = cc_tipo_impuesto.Id) INNER JOIN `cc_periodo_contable`  ON (cc_periodo_contable.`Id` = " + this.xcc_documentoc + ".`Id_PeriodoC`)  WHERE (cc_tipo_formato_dian.Id =1001 AND " + this.xcc_puc + ".EsDeduccionDian =1 AND " + this.xcc_documentoc + ".Estado =1 AND  cc_tipo_concepto_dian.Id= '" + xconcepto + "' AND cc_periodo_contable.`EsCierre`=0 AND DATE_FORMAT(`cc_periodo_contable`.`FechaI`, '%Y') ='" + this.JYCAno1.getValue() + "' AND cc_tipo_impuesto.EsImpuestos =1 AND cc_tipo_impuesto.Id =8) GROUP BY cc_terceros.Id";
        this.xsql = "DROP VIEW IF EXISTS v_cc_tmp  ";
        xct.ejecutarSQL(this.xsql);
        xct.cerrarConexionBd();
        this.xsql = "CREATE VIEW v_cc_tmp   AS " + sql10;
        xct.ejecutarSQL(this.xsql);
        xct.cerrarConexionBd();
        this.xsql = "UPDATE cc_tmp_f1001, v_cc_tmp SET cc_tmp_f1001.V11=v_cc_tmp.Valor WHERE cc_tmp_f1001.Id_Tercero=v_cc_tmp.IdTercero AND cc_tmp_f1001.Concepto=IdConcepto";
        xct.ejecutarSQL(this.xsql);
        xct.cerrarConexionBd();
    }

    private void mCargarDetalleTableF1008(String xconcepto) {
        ConsultasMySQL xct = new ConsultasMySQL();
        String sql = "SELECT round(ABS((SUM(" + this.xcc_detalle_documentoc + ".VDebito)-SUM(" + this.xcc_detalle_documentoc + ".VCredito)) )) AS Valor, cc_terceros.Id as IdTercero, cc_tipo_concepto_dian.Id as IdConcepto FROM cc_tipo_concepto_dian INNER JOIN " + this.xcc_puc + "  ON (cc_tipo_concepto_dian.Id = " + this.xcc_puc + ".Id_TipoConceptoDian) INNER JOIN " + this.xcc_detalle_documentoc + " ON (" + this.xcc_puc + ".Id = " + this.xcc_detalle_documentoc + ".Id_Puc) INNER JOIN cc_tipo_formato_concepto_dian  ON (cc_tipo_formato_concepto_dian.Id_ConceptoDian = cc_tipo_concepto_dian.Id) INNER JOIN cc_tipo_formato_dian  ON (cc_tipo_formato_concepto_dian.Id_FormatoDian = cc_tipo_formato_dian.Id) INNER JOIN " + this.xcc_documentoc + "  ON (" + this.xcc_detalle_documentoc + ".Id_Documentoc = " + this.xcc_documentoc + ".Id) INNER JOIN cc_terceros  ON (" + this.xcc_detalle_documentoc + ".Id_Tercero = cc_terceros.Id) INNER JOIN cc_tipo_impuesto  ON (" + this.xcc_puc + ".Id_TipoImpuesto = cc_tipo_impuesto.Id) INNER JOIN `cc_periodo_contable`  ON (cc_periodo_contable.`Id` = " + this.xcc_documentoc + ".`Id_PeriodoC`) WHERE (cc_tipo_formato_dian.Id ='" + this.xidformato[this.JCBFormato.getSelectedIndex()][0] + "' AND cc_periodo_contable.`EsCierre`=0 AND " + this.xcc_documentoc + ".Estado =1 AND DATE_FORMAT(`cc_periodo_contable`.`FechaI`, '%Y') ='" + this.JYCAno1.getValue() + "' AND   cc_tipo_concepto_dian.Id= '" + xconcepto + "') GROUP BY cc_terceros.Id ";
        this.xsql = "DROP VIEW IF EXISTS v_cc_tmp  ";
        xct.ejecutarSQL(this.xsql);
        xct.cerrarConexionBd();
        this.xsql = "CREATE VIEW v_cc_tmp   AS " + sql;
        xct.ejecutarSQL(this.xsql);
        xct.cerrarConexionBd();
        this.xsql = "UPDATE cc_tmp_f1001, v_cc_tmp SET cc_tmp_f1001.V1=v_cc_tmp.Valor WHERE cc_tmp_f1001.Id_Tercero=v_cc_tmp.IdTercero AND cc_tmp_f1001.Concepto=IdConcepto";
        xct.ejecutarSQL(this.xsql);
        xct.cerrarConexionBd();
    }

    private void mCargarDetalleTableF1009(String xconcepto) {
        ConsultasMySQL xct = new ConsultasMySQL();
        String sql = "SELECT round(ABS((SUM(" + this.xcc_detalle_documentoc + ".VCredito)-SUM(" + this.xcc_detalle_documentoc + ".VDebito)) )) AS Valor, cc_terceros.Id as IdTercero, cc_tipo_concepto_dian.Id as IdConcepto FROM cc_tipo_concepto_dian INNER JOIN " + this.xcc_puc + "  ON (cc_tipo_concepto_dian.Id = " + this.xcc_puc + ".Id_TipoConceptoDian) INNER JOIN " + this.xcc_detalle_documentoc + " ON (" + this.xcc_puc + ".Id = " + this.xcc_detalle_documentoc + ".Id_Puc) INNER JOIN cc_tipo_formato_concepto_dian  ON (cc_tipo_formato_concepto_dian.Id_ConceptoDian = cc_tipo_concepto_dian.Id) INNER JOIN cc_tipo_formato_dian  ON (cc_tipo_formato_concepto_dian.Id_FormatoDian = cc_tipo_formato_dian.Id) INNER JOIN " + this.xcc_documentoc + "  ON (" + this.xcc_detalle_documentoc + ".Id_Documentoc = " + this.xcc_documentoc + ".Id) INNER JOIN cc_terceros  ON (" + this.xcc_detalle_documentoc + ".Id_Tercero = cc_terceros.Id) INNER JOIN cc_tipo_impuesto  ON (" + this.xcc_puc + ".Id_TipoImpuesto = cc_tipo_impuesto.Id) INNER JOIN `cc_periodo_contable`  ON (cc_periodo_contable.`Id` = " + this.xcc_documentoc + ".`Id_PeriodoC`)  WHERE (cc_tipo_formato_dian.Id ='" + this.xidformato[this.JCBFormato.getSelectedIndex()][0] + "' AND cc_periodo_contable.`EsCierre`=0 AND " + this.xcc_documentoc + ".Estado =1 AND DATE_FORMAT(`cc_periodo_contable`.`FechaI`, '%Y') ='" + this.JYCAno1.getValue() + "' AND   cc_tipo_concepto_dian.Id= '" + xconcepto + "') GROUP BY cc_terceros.Id ";
        this.xsql = "DROP VIEW IF EXISTS v_cc_tmp  ";
        xct.ejecutarSQL(this.xsql);
        xct.cerrarConexionBd();
        this.xsql = "CREATE VIEW v_cc_tmp   AS " + sql;
        xct.ejecutarSQL(this.xsql);
        xct.cerrarConexionBd();
        this.xsql = "UPDATE cc_tmp_f1001, v_cc_tmp SET cc_tmp_f1001.V1=v_cc_tmp.Valor WHERE cc_tmp_f1001.Id_Tercero=v_cc_tmp.IdTercero AND cc_tmp_f1001.Concepto=IdConcepto";
        xct.ejecutarSQL(this.xsql);
        xct.cerrarConexionBd();
    }

    private void mCargarDetalleTableF1007(String xconcepto) {
        ConsultasMySQL xct = new ConsultasMySQL();
        String sql = "SELECT round(ABS(SUM(" + this.xcc_detalle_documentoc + ".VCredito))) AS Valor, cc_terceros.Id as IdTercero, cc_tipo_concepto_dian.Id as IdConcepto FROM cc_tipo_concepto_dian INNER JOIN " + this.xcc_puc + "  ON (cc_tipo_concepto_dian.Id = " + this.xcc_puc + ".Id_TipoConceptoDian) INNER JOIN " + this.xcc_detalle_documentoc + " ON (" + this.xcc_puc + ".Id = " + this.xcc_detalle_documentoc + ".Id_Puc) INNER JOIN cc_tipo_formato_concepto_dian  ON (cc_tipo_formato_concepto_dian.Id_ConceptoDian = cc_tipo_concepto_dian.Id) INNER JOIN cc_tipo_formato_dian  ON (cc_tipo_formato_concepto_dian.Id_FormatoDian = cc_tipo_formato_dian.Id) INNER JOIN " + this.xcc_documentoc + "  ON (" + this.xcc_detalle_documentoc + ".Id_Documentoc = " + this.xcc_documentoc + ".Id) INNER JOIN cc_terceros  ON (" + this.xcc_detalle_documentoc + ".Id_Tercero = cc_terceros.Id) INNER JOIN cc_tipo_impuesto  ON (" + this.xcc_puc + ".Id_TipoImpuesto = cc_tipo_impuesto.Id) INNER JOIN `cc_periodo_contable`  ON (cc_periodo_contable.`Id` = " + this.xcc_documentoc + ".`Id_PeriodoC`) WHERE (cc_tipo_formato_dian.Id =1007 AND " + this.xcc_documentoc + ".Estado =1 AND cc_periodo_contable.`EsCierre`=0  AND DATE_FORMAT(`cc_periodo_contable`.`FechaI`, '%Y') ='" + this.JYCAno1.getValue() + "' AND  cc_tipo_concepto_dian.Id= '" + xconcepto + "') GROUP BY cc_terceros.Id ";
        this.xsql = "DROP VIEW IF EXISTS v_cc_tmp  ";
        xct.ejecutarSQL(this.xsql);
        xct.cerrarConexionBd();
        this.xsql = "CREATE VIEW v_cc_tmp   AS " + sql;
        xct.ejecutarSQL(this.xsql);
        xct.cerrarConexionBd();
        this.xsql = "UPDATE cc_tmp_f1001, v_cc_tmp SET cc_tmp_f1001.V1=v_cc_tmp.Valor WHERE cc_tmp_f1001.Id_Tercero=v_cc_tmp.IdTercero AND cc_tmp_f1001.Concepto=IdConcepto";
        xct.ejecutarSQL(this.xsql);
        xct.cerrarConexionBd();
        String sql2 = "SELECT round(ABS(SUM(" + this.xcc_detalle_documentoc + ".VDebito))) AS Valor, cc_terceros.Id as IdTercero, cc_tipo_concepto_dian.Id as IdConcepto FROM cc_tipo_concepto_dian INNER JOIN " + this.xcc_puc + "  ON (cc_tipo_concepto_dian.Id = " + this.xcc_puc + ".Id_TipoConceptoDian) INNER JOIN " + this.xcc_detalle_documentoc + " ON (" + this.xcc_puc + ".Id = " + this.xcc_detalle_documentoc + ".Id_Puc) INNER JOIN cc_tipo_formato_concepto_dian  ON (cc_tipo_formato_concepto_dian.Id_ConceptoDian = cc_tipo_concepto_dian.Id) INNER JOIN cc_tipo_formato_dian  ON (cc_tipo_formato_concepto_dian.Id_FormatoDian = cc_tipo_formato_dian.Id) INNER JOIN " + this.xcc_documentoc + "  ON (" + this.xcc_detalle_documentoc + ".Id_Documentoc = " + this.xcc_documentoc + ".Id) INNER JOIN cc_terceros  ON (" + this.xcc_detalle_documentoc + ".Id_Tercero = cc_terceros.Id) INNER JOIN cc_tipo_impuesto  ON (" + this.xcc_puc + ".Id_TipoImpuesto = cc_tipo_impuesto.Id) INNER JOIN `cc_periodo_contable`  ON (cc_periodo_contable.`Id` = " + this.xcc_documentoc + ".`Id_PeriodoC`)  WHERE (cc_tipo_formato_dian.Id =1007 AND " + this.xcc_documentoc + ".Estado =1 AND cc_periodo_contable.`EsCierre`=0 AND DATE_FORMAT(`cc_periodo_contable`.`FechaI`, '%Y') ='" + this.JYCAno1.getValue() + "' AND  cc_tipo_concepto_dian.Id= '" + xconcepto + "') GROUP BY cc_terceros.Id ";
        this.xsql = "DROP VIEW IF EXISTS v_cc_tmp  ";
        xct.ejecutarSQL(this.xsql);
        xct.cerrarConexionBd();
        this.xsql = "CREATE VIEW v_cc_tmp   AS " + sql2;
        xct.ejecutarSQL(this.xsql);
        xct.cerrarConexionBd();
        this.xsql = "UPDATE cc_tmp_f1001, v_cc_tmp SET cc_tmp_f1001.V7=v_cc_tmp.Valor WHERE cc_tmp_f1001.Id_Tercero=v_cc_tmp.IdTercero AND cc_tmp_f1001.Concepto=IdConcepto";
        xct.ejecutarSQL(this.xsql);
        xct.cerrarConexionBd();
    }

    private void mActualizarDatosEmpresa() {
        this.xsql = "UPDATE g_empresa  SET g_empresa.GRetencion=0 ";
        this.xconsultas.ejecutarSQL(this.xsql);
        this.xconsultas.cerrarConexionBd();
        this.xsql = "DROP VIEW IF EXISTS a_v_tmp ";
        this.xconsultas.ejecutarSQL(this.xsql);
        this.xconsultas.cerrarConexionBd();
        this.xsql = "CREATE VIEW `a_v_tmp`  AS SELECT  " + this.xcc_detalle_documentoc + ".Id_Tercero FROM " + this.xcc_detalle_documentoc + " INNER JOIN " + this.xcc_documentoc + "  ON (" + this.xcc_detalle_documentoc + ".Id_Documentoc = " + this.xcc_documentoc + ".Id) INNER JOIN " + this.xcc_puc + "  ON (" + this.xcc_detalle_documentoc + ".Id_Puc = " + this.xcc_puc + ".Id) INNER JOIN `cc_periodo_contable`  ON (cc_periodo_contable.`Id` = " + this.xcc_documentoc + ".`Id_PeriodoC`)  WHERE (DATE_FORMAT(`cc_periodo_contable`.`FechaI`, '%Y') ='" + this.JYCAno1.getValue() + "' AND cc_periodo_contable.`EsCierre`=0 AND " + this.xcc_documentoc + ".Estado =1 AND " + this.xcc_puc + ".Id_TipoImpuesto in(1,3)) ";
        this.xconsultas.ejecutarSQL(this.xsql);
        this.xconsultas.cerrarConexionBd();
        this.xsql = "UPDATE g_empresa,  a_v_tmp  SET g_empresa.GRetencion=1 WHERE g_empresa.Id=a_v_tmp.Id_Tercero ";
        this.xconsultas.ejecutarSQL(this.xsql);
        this.xconsultas.cerrarConexionBd();
    }

    private void mCrearTablaBd() {
        this.xsql = "DROP TABLE IF EXISTS cc_tmp_f1001 ";
        this.xconsultas.ejecutarSQL(this.xsql);
        this.xconsultas.cerrarConexionBd();
        this.xsql = "CREATE TABLE `cc_tmp_f1001` ( `Concepto` SMALLINT(4) DEFAULT '0',`Tipo` SMALLINT(2) DEFAULT '0',`NIdentificacion` VARCHAR(16) DEFAULT '',`DV` VARCHAR(1) DEFAULT '',`Apellido1` VARCHAR(200) DEFAULT '',`Apellido2` VARCHAR(200) DEFAULT '',`Nombre1` VARCHAR(200) DEFAULT '',`Nombre2` VARCHAR(200) DEFAULT '',`RazonS` VARCHAR(200) DEFAULT '', `Direccion` VARCHAR(200) DEFAULT '',`Dpto` VARCHAR(2) DEFAULT '',`Municipio` VARCHAR(4) DEFAULT '',`Pais` VARCHAR(3) DEFAULT '',`V1` DOUBLE DEFAULT '0',`V2` DOUBLE DEFAULT '0',`V3` DOUBLE DEFAULT '0',`V4` DOUBLE DEFAULT '0',`V5` DOUBLE DEFAULT '0',`V6` DOUBLE DEFAULT '0',`V7` DOUBLE DEFAULT '0',`V8` DOUBLE DEFAULT '0',`V9` DOUBLE DEFAULT '0',`V10` DOUBLE DEFAULT '0',`V11` DOUBLE DEFAULT '0', `Id_Tercero` MEDIUMINT(9) DEFAULT '0', `Valor` DOUBLE DEFAULT '0',`Tope` DOUBLE DEFAULT '0' ) ENGINE=INNODB DEFAULT CHARSET=latin1";
        this.xconsultas.ejecutarSQL(this.xsql);
        this.xconsultas.cerrarConexionBd();
    }

    private void mCrearTabla() {
        this.xmodelo = new DefaultTableModel((Object[][]) null, new String[]{"Concepto", "Tipo Documento", "NIdentificacion", "Dv", "1 Apellido", "2 Apellido", "1 Nombre", "2 Nombre", "Razon Social", "Direccion", "Depto", "Municipio", "Pais", "VAbono D", "VAbono ND", "Iva D", "Iva ND", "RetencionPR", "RetencionAR", "RetencionIvaRC", "RetencionIvaRS", "RetencionIvaOC", "RetencionCreeD", "RetencionCreeA"}) { // from class: Contabilidad.JIFConsultarDatosMDian.12
            Class[] types = {Long.class, String.class, String.class, Long.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(5);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(5);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(5);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(12).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(13).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(14).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(15).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(15).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(17).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(18).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(19).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(20).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(21).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(22).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(23).setPreferredWidth(10);
    }

    private void mCrearTabla2() {
        this.xmodelo = new DefaultTableModel((Object[][]) null, new String[]{"Concepto", "Tipo Documento", "NIdentificacion", "Dv", "1 Apellido", "2 Apellido", "1 Nombre", "2 Nombre", "Razon Social", "Direccion", "Depto", "Municipio", "Pais", "Valor"}) { // from class: Contabilidad.JIFConsultarDatosMDian.13
            Class[] types = {Long.class, String.class, String.class, Long.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Double.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(5);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(5);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(5);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(12).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(13).setPreferredWidth(10);
    }

    private void mCrearTabla3() {
        this.xmodelo = new DefaultTableModel((Object[][]) null, new String[]{"Concepto", "Tipo Documento", "NIdentificacion", "Dv", "1 Apellido", "2 Apellido", "1 Nombre", "2 Nombre", "Razon Social", "Pais", "Valor"}) { // from class: Contabilidad.JIFConsultarDatosMDian.14
            Class[] types = {Long.class, String.class, String.class, Long.class, String.class, String.class, String.class, String.class, String.class, String.class, Double.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(5);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(5);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(5);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(20);
    }

    private void mCrearTabla1() {
        this.xmodelo = new DefaultTableModel((Object[][]) null, new String[]{"Concepto", "Tipo Documento", "NIdentificacion", "Dv", "1 Apellido", "2 Apellido", "1 Nombre", "2 Nombre", "Razon Social", "Pais", "V/IngresoB", "V/IngresoCo", "V/IngresoCM", "V/IngresoMimeria", "V/IngresoFiducia", "V/IngresoTercero", "V/DescuentoDevolucion"}) { // from class: Contabilidad.JIFConsultarDatosMDian.15
            Class[] types = {Long.class, String.class, String.class, Long.class, String.class, String.class, String.class, String.class, String.class, String.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(5);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(5);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(5);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(12).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(13).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(14).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(15).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(15).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(16).setPreferredWidth(10);
    }

    private void mCrearTabla4() {
        this.xmodelo = new DefaultTableModel((Object[][]) null, new String[]{"Vigencia", "TD", "NIdentificacion", "Nombre y Apellidos o Razón Social", "Dirección", "Teléfono", "Email", "CodMunicipio", "CodDpto", "Concepto", "Valor", "ValorD", "Municipio", "CodRMunicipio"}) { // from class: Contabilidad.JIFConsultarDatosMDian.16
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Long.class, Double.class, Double.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, true, true, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(5);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(5);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(30);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(12).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(12).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(12).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(13).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(13).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(13).setMaxWidth(0);
    }

    private void mBuscarDEmpresa1001() {
        try {
            mCrearTablaBd();
            mActualizarDatosEmpresa();
            this.xnfila = 0;
            this.xsql = "insert into cc_tmp_f1001 (Concepto, Tipo, NIdentificacion, DV, Apellido1, Apellido2, Nombre1, Nombre2, RazonS, Direccion, Dpto, Municipio, Pais, Id_Tercero, Valor, Tope) SELECT cc_tipo_concepto_dian.Id,IF(cc_terceros.Dig_Verificacion<>'',31,cc_terceros.Id_Dian )    , cc_terceros.No_identificacion, cc_terceros.Dig_Verificacion, cc_terceros.Apellido1, cc_terceros.Apellido2, cc_terceros.Nombre1, cc_terceros.Nombre2, cc_terceros.RazonSocial, cc_terceros.Direccion, cc_terceros.CodDepartamento, MID(cc_terceros.CodMunicipio,3,4) AS CodMunicipio, cc_terceros.CodPais, cc_terceros.Id,0,cc_tipo_concepto_dian.Tope  FROM cc_tipo_concepto_dian INNER JOIN " + this.xcc_puc + "  ON (cc_tipo_concepto_dian.Id = " + this.xcc_puc + ".Id_TipoConceptoDian) INNER JOIN " + this.xcc_detalle_documentoc + "  ON (" + this.xcc_puc + ".Id = " + this.xcc_detalle_documentoc + ".Id_Puc) INNER JOIN cc_tipo_formato_concepto_dian  ON (cc_tipo_formato_concepto_dian.Id_ConceptoDian = cc_tipo_concepto_dian.Id) INNER JOIN cc_tipo_formato_dian  ON (cc_tipo_formato_concepto_dian.Id_FormatoDian = cc_tipo_formato_dian.Id) INNER JOIN " + this.xcc_documentoc + "  ON (" + this.xcc_detalle_documentoc + ".Id_Documentoc = " + this.xcc_documentoc + ".Id) INNER JOIN cc_terceros  ON (" + this.xcc_detalle_documentoc + ".Id_Tercero = cc_terceros.Id) INNER JOIN `cc_periodo_contable`  ON (cc_periodo_contable.`Id` = " + this.xcc_documentoc + ".`Id_PeriodoC`) WHERE (cc_tipo_formato_dian.Id =1001 AND cc_periodo_contable.`EsCierre`=0 AND date_format(`cc_periodo_contable`.`FechaI`,'%Y')='" + this.JYCAno1.getValue() + "' AND " + this.xcc_documentoc + ".Estado =1 ) GROUP BY cc_tipo_concepto_dian.Id, cc_terceros.Id ORDER BY cc_terceros.Id, cc_tipo_concepto_dian.Id ";
            this.xconsultas.ejecutarSQL(this.xsql);
            this.xconsultas.cerrarConexionBd();
            this.xsql = "SELECT Concepto FROM cc_tmp_f1001 GROUP BY Concepto ORDER BY Concepto ASC";
            ResultSet rs = this.xconsultas.traerRs(this.xsql);
            if (rs.next()) {
                rs.beforeFirst();
                while (rs.next()) {
                    mCargarDetalleTableF1001(rs.getString(1));
                }
            }
            rs.close();
            this.xconsultas.cerrarConexionBd();
            this.xsql = "SELECT cc_tmp_f1001.Concepto, cc_tmp_f1001.Tipo, cc_tmp_f1001.NIdentificacion, cc_tmp_f1001.DV, cc_tmp_f1001.Apellido1, cc_tmp_f1001.Apellido2, cc_tmp_f1001.Nombre1, cc_tmp_f1001.Nombre2, cc_tmp_f1001.RazonS , cc_tmp_f1001.Direccion, cc_tmp_f1001.Dpto, cc_tmp_f1001.Municipio, cc_tmp_f1001.Pais, cc_tmp_f1001.V1, cc_tmp_f1001.V2, cc_tmp_f1001.V3, cc_tmp_f1001.V4, cc_tmp_f1001.V5, cc_tmp_f1001.V6, cc_tmp_f1001.V7, cc_tmp_f1001.V8, cc_tmp_f1001.V9 , cc_tmp_f1001.Tope, cc_tmp_f1001.V10, cc_tmp_f1001.V11  FROM g_empresa INNER JOIN cc_tmp_f1001  ON (g_empresa.Id = cc_tmp_f1001.Id_Tercero) WHERE (g_empresa.GRetencion =1) ORDER BY  cc_tmp_f1001.Concepto ASC, cc_tmp_f1001.Apellido1 ASC ";
            mCrearTabla();
            ResultSet rs2 = this.xconsultas.traerRs(this.xsql);
            if (rs2.next()) {
                rs2.beforeFirst();
                while (rs2.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(Long.valueOf(rs2.getLong(1)), this.xnfila, 0);
                    this.xmodelo.setValueAt(rs2.getString(2), this.xnfila, 1);
                    this.xmodelo.setValueAt(rs2.getString(3), this.xnfila, 2);
                    this.xmodelo.setValueAt(rs2.getString(4), this.xnfila, 3);
                    this.xmodelo.setValueAt(rs2.getString(5), this.xnfila, 4);
                    this.xmodelo.setValueAt(rs2.getString(6), this.xnfila, 5);
                    this.xmodelo.setValueAt(rs2.getString(7), this.xnfila, 6);
                    this.xmodelo.setValueAt(rs2.getString(8), this.xnfila, 7);
                    this.xmodelo.setValueAt(rs2.getString(9), this.xnfila, 8);
                    this.xmodelo.setValueAt(rs2.getString(10), this.xnfila, 9);
                    this.xmodelo.setValueAt(rs2.getString(11), this.xnfila, 10);
                    this.xmodelo.setValueAt(rs2.getString(12), this.xnfila, 11);
                    this.xmodelo.setValueAt(rs2.getString(13), this.xnfila, 12);
                    this.xmodelo.setValueAt(Double.valueOf(rs2.getDouble(14)), this.xnfila, 13);
                    this.xmodelo.setValueAt(Double.valueOf(rs2.getDouble(15)), this.xnfila, 14);
                    this.xmodelo.setValueAt(Double.valueOf(rs2.getDouble(16)), this.xnfila, 15);
                    this.xmodelo.setValueAt(Double.valueOf(rs2.getDouble(17)), this.xnfila, 16);
                    this.xmodelo.setValueAt(Double.valueOf(rs2.getDouble(18)), this.xnfila, 17);
                    this.xmodelo.setValueAt(Double.valueOf(rs2.getDouble(19)), this.xnfila, 18);
                    this.xmodelo.setValueAt(Double.valueOf(rs2.getDouble(20)), this.xnfila, 19);
                    this.xmodelo.setValueAt(Double.valueOf(rs2.getDouble(21)), this.xnfila, 20);
                    this.xmodelo.setValueAt(Double.valueOf(rs2.getDouble(22)), this.xnfila, 21);
                    this.xmodelo.setValueAt(Double.valueOf(rs2.getDouble(24)), this.xnfila, 22);
                    this.xmodelo.setValueAt(Double.valueOf(rs2.getDouble(25)), this.xnfila, 23);
                    this.xnfila++;
                }
            }
            rs2.close();
            this.xconsultas.cerrarConexionBd();
            this.xsql = "SELECT cc_tmp_f1001.Concepto, cc_tmp_f1001.Tipo, cc_tmp_f1001.NIdentificacion, cc_tmp_f1001.DV, cc_tmp_f1001.Apellido1, cc_tmp_f1001.Apellido2, cc_tmp_f1001.Nombre1, cc_tmp_f1001.Nombre2, cc_tmp_f1001.RazonS , cc_tmp_f1001.Direccion, cc_tmp_f1001.Dpto, cc_tmp_f1001.Municipio, cc_tmp_f1001.Pais, cc_tmp_f1001.V1, cc_tmp_f1001.V2, cc_tmp_f1001.V3, cc_tmp_f1001.V4, cc_tmp_f1001.V5, cc_tmp_f1001.V6, cc_tmp_f1001.V7, cc_tmp_f1001.V8, cc_tmp_f1001.V9 , cc_tmp_f1001.Tope, cc_tmp_f1001.V10, cc_tmp_f1001.V11  FROM g_empresa INNER JOIN cc_tmp_f1001  ON (g_empresa.Id = cc_tmp_f1001.Id_Tercero) WHERE (g_empresa.GRetencion =0 AND cc_tmp_f1001.V1>=cc_tmp_f1001.Tope) ORDER BY cc_tmp_f1001.Concepto ASC, cc_tmp_f1001.Apellido1 ASC ";
            ResultSet rs3 = this.xconsultas.traerRs(this.xsql);
            if (rs3.next()) {
                rs3.beforeFirst();
                while (rs3.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(Long.valueOf(rs3.getLong(1)), this.xnfila, 0);
                    this.xmodelo.setValueAt(rs3.getString(2), this.xnfila, 1);
                    this.xmodelo.setValueAt(rs3.getString(3), this.xnfila, 2);
                    this.xmodelo.setValueAt(rs3.getString(4), this.xnfila, 3);
                    this.xmodelo.setValueAt(rs3.getString(5), this.xnfila, 4);
                    this.xmodelo.setValueAt(rs3.getString(6), this.xnfila, 5);
                    this.xmodelo.setValueAt(rs3.getString(7), this.xnfila, 6);
                    this.xmodelo.setValueAt(rs3.getString(8), this.xnfila, 7);
                    this.xmodelo.setValueAt(rs3.getString(9), this.xnfila, 8);
                    this.xmodelo.setValueAt(rs3.getString(10), this.xnfila, 9);
                    this.xmodelo.setValueAt(rs3.getString(11), this.xnfila, 10);
                    this.xmodelo.setValueAt(rs3.getString(12), this.xnfila, 11);
                    this.xmodelo.setValueAt(rs3.getString(13), this.xnfila, 12);
                    this.xmodelo.setValueAt(Double.valueOf(rs3.getDouble(14)), this.xnfila, 13);
                    this.xmodelo.setValueAt(Double.valueOf(rs3.getDouble(15)), this.xnfila, 14);
                    this.xmodelo.setValueAt(Double.valueOf(rs3.getDouble(16)), this.xnfila, 15);
                    this.xmodelo.setValueAt(Double.valueOf(rs3.getDouble(17)), this.xnfila, 16);
                    this.xmodelo.setValueAt(Double.valueOf(rs3.getDouble(18)), this.xnfila, 17);
                    this.xmodelo.setValueAt(Double.valueOf(rs3.getDouble(19)), this.xnfila, 18);
                    this.xmodelo.setValueAt(Double.valueOf(rs3.getDouble(20)), this.xnfila, 19);
                    this.xmodelo.setValueAt(Double.valueOf(rs3.getDouble(21)), this.xnfila, 20);
                    this.xmodelo.setValueAt(Double.valueOf(rs3.getDouble(22)), this.xnfila, 21);
                    this.xmodelo.setValueAt(Double.valueOf(rs3.getDouble(24)), this.xnfila, 22);
                    this.xmodelo.setValueAt(Double.valueOf(rs3.getDouble(25)), this.xnfila, 23);
                    this.xnfila++;
                }
            }
            rs3.close();
            this.xconsultas.cerrarConexionBd();
            this.xsql = "SELECT cc_tmp_f1001.Concepto, 43 AS TD, '222222222', '', '', '', '', '', 'CUANTIAS MENORES', d_ips.Direccion, d_ips.CodDepartamento, d_ips.CodMunicipio, d_ips.CodPais , SUM(cc_tmp_f1001.V1), SUM(cc_tmp_f1001.V2), SUM(cc_tmp_f1001.V3), SUM(cc_tmp_f1001.V4), SUM(cc_tmp_f1001.V5), SUM(cc_tmp_f1001.V6), SUM(cc_tmp_f1001.V7), SUM(cc_tmp_f1001.V8), SUM(cc_tmp_f1001.V9) , cc_tmp_f1001.Tope, cc_tmp_f1001.V10, cc_tmp_f1001.V11  FROM d_ips,  g_empresa INNER JOIN cc_tmp_f1001  ON (g_empresa.Id = cc_tmp_f1001.Id_Tercero) WHERE (g_empresa.GRetencion =0 AND cc_tmp_f1001.V1 <cc_tmp_f1001.Tope) GROUP BY cc_tmp_f1001.Concepto ORDER BY cc_tmp_f1001.Concepto ASC, '' ASC ";
            ResultSet rs4 = this.xconsultas.traerRs(this.xsql);
            if (rs4.next()) {
                rs4.beforeFirst();
                while (rs4.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(Long.valueOf(rs4.getLong(1)), this.xnfila, 0);
                    this.xmodelo.setValueAt(rs4.getString(2), this.xnfila, 1);
                    this.xmodelo.setValueAt(rs4.getString(3), this.xnfila, 2);
                    this.xmodelo.setValueAt(rs4.getString(4), this.xnfila, 3);
                    this.xmodelo.setValueAt(rs4.getString(5), this.xnfila, 4);
                    this.xmodelo.setValueAt(rs4.getString(6), this.xnfila, 5);
                    this.xmodelo.setValueAt(rs4.getString(7), this.xnfila, 6);
                    this.xmodelo.setValueAt(rs4.getString(8), this.xnfila, 7);
                    this.xmodelo.setValueAt(rs4.getString(9), this.xnfila, 8);
                    this.xmodelo.setValueAt(rs4.getString(10), this.xnfila, 9);
                    this.xmodelo.setValueAt(rs4.getString(11), this.xnfila, 10);
                    this.xmodelo.setValueAt(rs4.getString(12), this.xnfila, 11);
                    this.xmodelo.setValueAt(rs4.getString(13), this.xnfila, 12);
                    this.xmodelo.setValueAt(Double.valueOf(rs4.getDouble(14)), this.xnfila, 13);
                    this.xmodelo.setValueAt(Double.valueOf(rs4.getDouble(15)), this.xnfila, 14);
                    this.xmodelo.setValueAt(Double.valueOf(rs4.getDouble(16)), this.xnfila, 15);
                    this.xmodelo.setValueAt(Double.valueOf(rs4.getDouble(17)), this.xnfila, 16);
                    this.xmodelo.setValueAt(Double.valueOf(rs4.getDouble(18)), this.xnfila, 17);
                    this.xmodelo.setValueAt(Double.valueOf(rs4.getDouble(19)), this.xnfila, 18);
                    this.xmodelo.setValueAt(Double.valueOf(rs4.getDouble(20)), this.xnfila, 19);
                    this.xmodelo.setValueAt(Double.valueOf(rs4.getDouble(21)), this.xnfila, 20);
                    this.xmodelo.setValueAt(Double.valueOf(rs4.getDouble(22)), this.xnfila, 21);
                    this.xmodelo.setValueAt(Double.valueOf(rs4.getDouble(24)), this.xnfila, 22);
                    this.xmodelo.setValueAt(Double.valueOf(rs4.getDouble(25)), this.xnfila, 23);
                    this.xnfila++;
                }
            }
            rs4.close();
            this.xconsultas.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFConsultarDatosMDian.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mBuscarDEmpresa10081009() {
        try {
            mCrearTablaBd();
            mActualizarDatosEmpresa();
            this.xnfila = 0;
            this.xsql = "insert into cc_tmp_f1001 (Concepto, Tipo, NIdentificacion, DV, Apellido1, Apellido2, Nombre1, Nombre2, RazonS, Direccion, Dpto, Municipio, Pais, Id_Tercero, Valor, Tope) SELECT cc_tipo_concepto_dian.Id,IF(cc_terceros.Dig_Verificacion<>'',31,cc_terceros.Id_Dian )    , cc_terceros.No_identificacion, cc_terceros.Dig_Verificacion, cc_terceros.Apellido1, cc_terceros.Apellido2, cc_terceros.Nombre1, cc_terceros.Nombre2, cc_terceros.RazonSocial, cc_terceros.Direccion, cc_terceros.CodDepartamento, MID(cc_terceros.CodMunicipio,3,4) AS CodMunicipio, cc_terceros.CodPais, cc_terceros.Id,0,cc_tipo_concepto_dian.Tope  FROM cc_tipo_concepto_dian INNER JOIN " + this.xcc_puc + "  ON (cc_tipo_concepto_dian.Id = " + this.xcc_puc + ".Id_TipoConceptoDian) INNER JOIN " + this.xcc_detalle_documentoc + "  ON (" + this.xcc_puc + ".Id = " + this.xcc_detalle_documentoc + ".Id_Puc) INNER JOIN cc_tipo_formato_concepto_dian  ON (cc_tipo_formato_concepto_dian.Id_ConceptoDian = cc_tipo_concepto_dian.Id) INNER JOIN cc_tipo_formato_dian  ON (cc_tipo_formato_concepto_dian.Id_FormatoDian = cc_tipo_formato_dian.Id) INNER JOIN " + this.xcc_documentoc + "  ON (" + this.xcc_detalle_documentoc + ".Id_Documentoc = " + this.xcc_documentoc + ".Id) INNER JOIN cc_terceros  ON (" + this.xcc_detalle_documentoc + ".Id_Tercero = cc_terceros.Id)  INNER JOIN `cc_periodo_contable`  ON (cc_periodo_contable.`Id` = " + this.xcc_documentoc + ".`Id_PeriodoC`)  WHERE (cc_tipo_formato_dian.Id ='" + this.xidformato[this.JCBFormato.getSelectedIndex()][0] + "' AND cc_periodo_contable.`EsCierre`=0 AND date_format(`cc_periodo_contable`.`FechaI`,'%Y')<='" + this.JYCAno1.getValue() + "' AND " + this.xcc_documentoc + ".Estado =1 ) GROUP BY cc_tipo_concepto_dian.Id, cc_terceros.Id ORDER BY cc_terceros.Id, cc_tipo_concepto_dian.Id ";
            this.xconsultas.ejecutarSQL(this.xsql);
            this.xconsultas.cerrarConexionBd();
            this.xsql = "SELECT Concepto FROM cc_tmp_f1001 GROUP BY Concepto ORDER BY Concepto ASC";
            ResultSet rs = this.xconsultas.traerRs(this.xsql);
            if (rs.next()) {
                rs.beforeFirst();
                while (rs.next()) {
                    if (this.xidformato[this.JCBFormato.getSelectedIndex()][0].equals("1008")) {
                        mCargarDetalleTableF1008(rs.getString(1));
                    } else if (this.xidformato[this.JCBFormato.getSelectedIndex()][0].equals("1009")) {
                        mCargarDetalleTableF1009(rs.getString(1));
                    }
                }
            }
            rs.close();
            this.xconsultas.cerrarConexionBd();
            this.xsql = "SELECT cc_tmp_f1001.Concepto, cc_tmp_f1001.Tipo, cc_tmp_f1001.NIdentificacion, cc_tmp_f1001.DV, cc_tmp_f1001.Apellido1, cc_tmp_f1001.Apellido2, cc_tmp_f1001.Nombre1, cc_tmp_f1001.Nombre2, cc_tmp_f1001.RazonS , cc_tmp_f1001.Direccion, cc_tmp_f1001.Dpto, cc_tmp_f1001.Municipio, cc_tmp_f1001.Pais, cc_tmp_f1001.V1, cc_tmp_f1001.Tope  FROM g_empresa INNER JOIN cc_tmp_f1001  ON (g_empresa.Id = cc_tmp_f1001.Id_Tercero) WHERE (cc_tmp_f1001.V1>=cc_tmp_f1001.Tope) ORDER BY cc_tmp_f1001.Concepto ASC, cc_tmp_f1001.Apellido1 ASC ";
            mCrearTabla2();
            ResultSet rs2 = this.xconsultas.traerRs(this.xsql);
            if (rs2.next()) {
                rs2.beforeFirst();
                while (rs2.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(Long.valueOf(rs2.getLong(1)), this.xnfila, 0);
                    this.xmodelo.setValueAt(rs2.getString(2), this.xnfila, 1);
                    this.xmodelo.setValueAt(rs2.getString(3), this.xnfila, 2);
                    this.xmodelo.setValueAt(rs2.getString(4), this.xnfila, 3);
                    this.xmodelo.setValueAt(rs2.getString(5), this.xnfila, 4);
                    this.xmodelo.setValueAt(rs2.getString(6), this.xnfila, 5);
                    this.xmodelo.setValueAt(rs2.getString(7), this.xnfila, 6);
                    this.xmodelo.setValueAt(rs2.getString(8), this.xnfila, 7);
                    this.xmodelo.setValueAt(rs2.getString(9), this.xnfila, 8);
                    this.xmodelo.setValueAt(rs2.getString(10), this.xnfila, 9);
                    this.xmodelo.setValueAt(rs2.getString(11), this.xnfila, 10);
                    this.xmodelo.setValueAt(rs2.getString(12), this.xnfila, 11);
                    this.xmodelo.setValueAt(rs2.getString(13), this.xnfila, 12);
                    this.xmodelo.setValueAt(Double.valueOf(rs2.getDouble(14)), this.xnfila, 13);
                    this.xnfila++;
                }
            }
            rs2.close();
            this.xconsultas.cerrarConexionBd();
            this.xsql = "SELECT cc_tmp_f1001.Concepto, 43 AS TD, '222222222', '', '', '', '', '', 'CUANTIAS MENORES', d_ips.Direccion, d_ips.CodDepartamento, d_ips.CodMunicipio, d_ips.CodPais , SUM(cc_tmp_f1001.V1), SUM(cc_tmp_f1001.V2), SUM(cc_tmp_f1001.V3), SUM(cc_tmp_f1001.V4), SUM(cc_tmp_f1001.V5), SUM(cc_tmp_f1001.V6), SUM(cc_tmp_f1001.V7), SUM(cc_tmp_f1001.V8), SUM(cc_tmp_f1001.V9) , cc_tmp_f1001.Tope  FROM d_ips,  g_empresa INNER JOIN cc_tmp_f1001  ON (g_empresa.Id = cc_tmp_f1001.Id_Tercero) WHERE (cc_tmp_f1001.V1 <cc_tmp_f1001.Tope) GROUP BY cc_tmp_f1001.Concepto ORDER BY cc_tmp_f1001.Concepto ASC, '' ASC ";
            ResultSet rs3 = this.xconsultas.traerRs(this.xsql);
            if (rs3.next()) {
                rs3.beforeFirst();
                while (rs3.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(Long.valueOf(rs3.getLong(1)), this.xnfila, 0);
                    this.xmodelo.setValueAt(rs3.getString(2), this.xnfila, 1);
                    this.xmodelo.setValueAt(rs3.getString(3), this.xnfila, 2);
                    this.xmodelo.setValueAt(rs3.getString(4), this.xnfila, 3);
                    this.xmodelo.setValueAt(rs3.getString(5), this.xnfila, 4);
                    this.xmodelo.setValueAt(rs3.getString(6), this.xnfila, 5);
                    this.xmodelo.setValueAt(rs3.getString(7), this.xnfila, 6);
                    this.xmodelo.setValueAt(rs3.getString(8), this.xnfila, 7);
                    this.xmodelo.setValueAt(rs3.getString(9), this.xnfila, 8);
                    this.xmodelo.setValueAt(rs3.getString(10), this.xnfila, 9);
                    this.xmodelo.setValueAt(rs3.getString(11), this.xnfila, 10);
                    this.xmodelo.setValueAt(rs3.getString(12), this.xnfila, 11);
                    this.xmodelo.setValueAt(rs3.getString(13), this.xnfila, 12);
                    this.xmodelo.setValueAt(Double.valueOf(rs3.getDouble(14)), this.xnfila, 13);
                    this.xnfila++;
                }
            }
            rs3.close();
            this.xconsultas.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFConsultarDatosMDian.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mBuscarDEmpresa1007() {
        try {
            mCrearTablaBd();
            mActualizarDatosEmpresa();
            this.xnfila = 0;
            this.xsql = "insert into cc_tmp_f1001 (Concepto, Tipo, NIdentificacion, DV, Apellido1, Apellido2, Nombre1, Nombre2, RazonS, Direccion, Dpto, Municipio, Pais, Id_Tercero, Valor, Tope) SELECT cc_tipo_concepto_dian.Id,IF(cc_terceros.Dig_Verificacion<>'',31,cc_terceros.Id_Dian )    , cc_terceros.No_identificacion, cc_terceros.Dig_Verificacion, cc_terceros.Apellido1, cc_terceros.Apellido2, cc_terceros.Nombre1, cc_terceros.Nombre2, cc_terceros.RazonSocial, cc_terceros.Direccion, cc_terceros.CodDepartamento, MID(cc_terceros.CodMunicipio,3,4) AS CodMunicipio, cc_terceros.CodPais, cc_terceros.Id,0,cc_tipo_concepto_dian.Tope  FROM cc_tipo_concepto_dian INNER JOIN " + this.xcc_puc + "  ON (cc_tipo_concepto_dian.Id = " + this.xcc_puc + ".Id_TipoConceptoDian) INNER JOIN " + this.xcc_detalle_documentoc + "  ON (" + this.xcc_puc + ".Id = " + this.xcc_detalle_documentoc + ".Id_Puc) INNER JOIN cc_tipo_formato_concepto_dian  ON (cc_tipo_formato_concepto_dian.Id_ConceptoDian = cc_tipo_concepto_dian.Id) INNER JOIN cc_tipo_formato_dian  ON (cc_tipo_formato_concepto_dian.Id_FormatoDian = cc_tipo_formato_dian.Id) INNER JOIN " + this.xcc_documentoc + "  ON (" + this.xcc_detalle_documentoc + ".Id_Documentoc = " + this.xcc_documentoc + ".Id) INNER JOIN cc_terceros  ON (" + this.xcc_detalle_documentoc + ".Id_Tercero = cc_terceros.Id) INNER JOIN `cc_periodo_contable`  ON (cc_periodo_contable.`Id` = " + this.xcc_documentoc + ".`Id_PeriodoC`)  WHERE (cc_tipo_formato_dian.Id ='" + this.xidformato[this.JCBFormato.getSelectedIndex()][0] + "' AND cc_periodo_contable.`EsCierre`=0 AND date_format(`cc_periodo_contable`.`FechaI`,'%Y')='" + this.JYCAno1.getValue() + "' AND " + this.xcc_documentoc + ".Estado =1 ) GROUP BY cc_tipo_concepto_dian.Id, cc_terceros.Id ORDER BY cc_terceros.Id, cc_tipo_concepto_dian.Id ";
            this.xconsultas.ejecutarSQL(this.xsql);
            this.xconsultas.cerrarConexionBd();
            this.xsql = "SELECT Concepto FROM cc_tmp_f1001 GROUP BY Concepto ORDER BY Concepto ASC";
            ResultSet rs = this.xconsultas.traerRs(this.xsql);
            if (rs.next()) {
                rs.beforeFirst();
                while (rs.next()) {
                    mCargarDetalleTableF1007(rs.getString(1));
                }
            }
            rs.close();
            this.xconsultas.cerrarConexionBd();
            this.xsql = "SELECT cc_tmp_f1001.Concepto, cc_tmp_f1001.Tipo, cc_tmp_f1001.NIdentificacion, cc_tmp_f1001.DV, cc_tmp_f1001.Apellido1, cc_tmp_f1001.Apellido2, cc_tmp_f1001.Nombre1, cc_tmp_f1001.Nombre2, cc_tmp_f1001.RazonS , cc_tmp_f1001.Pais, cc_tmp_f1001.V1, cc_tmp_f1001.V2, cc_tmp_f1001.V3, cc_tmp_f1001.V4, cc_tmp_f1001.V5, cc_tmp_f1001.V6, cc_tmp_f1001.V7, cc_tmp_f1001.Tope  FROM g_empresa INNER JOIN cc_tmp_f1001  ON (g_empresa.Id = cc_tmp_f1001.Id_Tercero) WHERE (cc_tmp_f1001.V1>=cc_tmp_f1001.Tope) ORDER BY cc_tmp_f1001.Concepto ASC, cc_tmp_f1001.Apellido1 ASC ";
            mCrearTabla1();
            ResultSet rs2 = this.xconsultas.traerRs(this.xsql);
            if (rs2.next()) {
                rs2.beforeFirst();
                while (rs2.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(Long.valueOf(rs2.getLong(1)), this.xnfila, 0);
                    this.xmodelo.setValueAt(rs2.getString(2), this.xnfila, 1);
                    this.xmodelo.setValueAt(rs2.getString(3), this.xnfila, 2);
                    this.xmodelo.setValueAt(rs2.getString(4), this.xnfila, 3);
                    this.xmodelo.setValueAt(rs2.getString(5), this.xnfila, 4);
                    this.xmodelo.setValueAt(rs2.getString(6), this.xnfila, 5);
                    this.xmodelo.setValueAt(rs2.getString(7), this.xnfila, 6);
                    this.xmodelo.setValueAt(rs2.getString(8), this.xnfila, 7);
                    this.xmodelo.setValueAt(rs2.getString(9), this.xnfila, 8);
                    this.xmodelo.setValueAt(rs2.getString(10), this.xnfila, 9);
                    this.xmodelo.setValueAt(Double.valueOf(rs2.getDouble(11)), this.xnfila, 10);
                    this.xmodelo.setValueAt(Double.valueOf(rs2.getDouble(12)), this.xnfila, 11);
                    this.xmodelo.setValueAt(Double.valueOf(rs2.getDouble(13)), this.xnfila, 12);
                    this.xmodelo.setValueAt(Double.valueOf(rs2.getDouble(14)), this.xnfila, 13);
                    this.xmodelo.setValueAt(Double.valueOf(rs2.getDouble(15)), this.xnfila, 14);
                    this.xmodelo.setValueAt(Double.valueOf(rs2.getDouble(16)), this.xnfila, 15);
                    this.xmodelo.setValueAt(Double.valueOf(rs2.getDouble(17)), this.xnfila, 16);
                    this.xnfila++;
                }
            }
            rs2.close();
            this.xconsultas.cerrarConexionBd();
            this.xsql = "SELECT cc_tmp_f1001.Concepto, 43 AS TD, '222222222', '', '', '', '', '', 'CUANTIAS MENORES', d_ips.CodPais , SUM(cc_tmp_f1001.V1), SUM(cc_tmp_f1001.V2), SUM(cc_tmp_f1001.V3), SUM(cc_tmp_f1001.V4), SUM(cc_tmp_f1001.V5), SUM(cc_tmp_f1001.V6), SUM(cc_tmp_f1001.V7) , cc_tmp_f1001.Tope  FROM d_ips,  g_empresa INNER JOIN cc_tmp_f1001  ON (g_empresa.Id = cc_tmp_f1001.Id_Tercero) WHERE (g_empresa.GRetencion =0 AND cc_tmp_f1001.V1 <cc_tmp_f1001.Tope) GROUP BY cc_tmp_f1001.Concepto ORDER BY cc_tmp_f1001.Concepto ASC, '' ASC ";
            ResultSet rs3 = this.xconsultas.traerRs(this.xsql);
            if (rs3.next()) {
                rs3.beforeFirst();
                while (rs3.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(Long.valueOf(rs3.getLong(1)), this.xnfila, 0);
                    this.xmodelo.setValueAt(rs3.getString(2), this.xnfila, 1);
                    this.xmodelo.setValueAt(rs3.getString(3), this.xnfila, 2);
                    this.xmodelo.setValueAt(rs3.getString(4), this.xnfila, 3);
                    this.xmodelo.setValueAt(rs3.getString(5), this.xnfila, 4);
                    this.xmodelo.setValueAt(rs3.getString(6), this.xnfila, 5);
                    this.xmodelo.setValueAt(rs3.getString(7), this.xnfila, 6);
                    this.xmodelo.setValueAt(rs3.getString(8), this.xnfila, 7);
                    this.xmodelo.setValueAt(rs3.getString(9), this.xnfila, 8);
                    this.xmodelo.setValueAt(rs3.getString(10), this.xnfila, 9);
                    this.xmodelo.setValueAt(Double.valueOf(rs3.getDouble(11)), this.xnfila, 10);
                    this.xmodelo.setValueAt(Double.valueOf(rs3.getDouble(12)), this.xnfila, 11);
                    this.xmodelo.setValueAt(Double.valueOf(rs3.getDouble(13)), this.xnfila, 12);
                    this.xmodelo.setValueAt(Double.valueOf(rs3.getDouble(14)), this.xnfila, 13);
                    this.xmodelo.setValueAt(Double.valueOf(rs3.getDouble(15)), this.xnfila, 14);
                    this.xmodelo.setValueAt(Double.valueOf(rs3.getDouble(16)), this.xnfila, 15);
                    this.xmodelo.setValueAt(Double.valueOf(rs3.getDouble(17)), this.xnfila, 16);
                    this.xnfila++;
                }
            }
            rs3.close();
            this.xconsultas.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFConsultarDatosMDian.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void crearModeloTablaFormato1005() {
        this.xmodelo = new DefaultTableModel((Object[][]) null, new String[]{"TipoDeDocumento", "NIdentificacion", "DV", "primerApellido", "segundoApellido", "primerNombre", "segundoNombre", "razonSocial", "impuestoDescontables"}) { // from class: Contabilidad.JIFConsultarDatosMDian.17
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Double.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setAutoResizeMode(0);
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(30);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(200);
    }

    private void consultarDatosFormato1005() {
        crearModeloTablaFormato1005();
        List<Object[]> datosFormato1005 = this.xInformesContabilidadDAO.datosFormato1005(this.xmt.formatoAMD.format(this.JDFFechaI.getDate()), this.xmt.formatoAMD.format(this.JDFFechaF.getDate()));
        if (datosFormato1005.size() > 0) {
            for (int j = 0; j < datosFormato1005.size(); j++) {
                this.xmodelo.addRow(this.xdato);
                this.xmodelo.setValueAt(datosFormato1005.get(j)[0], j, 0);
                this.xmodelo.setValueAt(datosFormato1005.get(j)[1], j, 1);
                this.xmodelo.setValueAt(datosFormato1005.get(j)[2], j, 2);
                this.xmodelo.setValueAt(datosFormato1005.get(j)[3], j, 3);
                this.xmodelo.setValueAt(datosFormato1005.get(j)[4], j, 4);
                this.xmodelo.setValueAt(datosFormato1005.get(j)[5], j, 5);
                this.xmodelo.setValueAt(datosFormato1005.get(j)[6], j, 6);
                this.xmodelo.setValueAt(datosFormato1005.get(j)[7], j, 7);
                this.xmodelo.setValueAt(datosFormato1005.get(j)[8], j, 8);
            }
        }
    }

    private void mBuscarDEmpresa2276() {
        mModelo2276();
        List<Object[]> list1 = this.xInformesContabilidadDAO.listTercerosInfome2276();
        long xnfila = 0;
        if (list1.size() >= 1) {
            this.xmt.mEstablecerTextEditor(this.JTDetalle, 6);
            for (int x = 0; x < list1.size(); x++) {
                this.xmodelo.addRow(this.xDato);
                this.xmodelo.setValueAt(list1.get(x)[0], x, 0);
                this.xmodelo.setValueAt(list1.get(x)[1], x, 1);
                this.xmodelo.setValueAt(list1.get(x)[2], x, 2);
                this.xmodelo.setValueAt(list1.get(x)[3], x, 3);
                this.xmodelo.setValueAt(list1.get(x)[4], x, 4);
                this.xmodelo.setValueAt(list1.get(x)[5], x, 5);
                this.xmodelo.setValueAt(list1.get(x)[6], x, 6);
                this.xmodelo.setValueAt(list1.get(x)[7], x, 7);
                this.xmodelo.setValueAt(list1.get(x)[8], x, 8);
                this.xmodelo.setValueAt(list1.get(x)[9], x, 9);
                this.xmodelo.setValueAt(list1.get(x)[10], x, 10);
                this.xmodelo.setValueAt(list1.get(x)[11], x, 11);
                this.xmodelo.setValueAt(list1.get(x)[12], x, 12);
                this.xmodelo.setValueAt(list1.get(x)[13], x, 13);
                this.xmodelo.setValueAt(list1.get(x)[14], x, 14);
                this.xmodelo.setValueAt(list1.get(x)[15], x, 15);
                this.xmodelo.setValueAt(list1.get(x)[16], x, 16);
                this.xmodelo.setValueAt(list1.get(x)[17], x, 17);
                this.xmodelo.setValueAt(list1.get(x)[18], x, 18);
                xnfila++;
            }
        }
    }

    private void mBuscarDEmpresa1012() {
        try {
            mCrearTablaBd();
            mActualizarDatosEmpresa();
            this.xnfila = 0;
            this.xsql = "insert into cc_tmp_f1001 (Concepto, Tipo, NIdentificacion, DV, Apellido1, Apellido2, Nombre1, Nombre2, RazonS, Direccion, Dpto, Municipio, Pais, Id_Tercero, Valor, Tope) SELECT cc_tipo_concepto_dian.Id,IF(cc_terceros.Dig_Verificacion<>'',31,cc_terceros.Id_Dian )    , cc_terceros.No_identificacion, cc_terceros.Dig_Verificacion, cc_terceros.Apellido1, cc_terceros.Apellido2, cc_terceros.Nombre1, cc_terceros.Nombre2, cc_terceros.RazonSocial, cc_terceros.Direccion, cc_terceros.CodDepartamento, MID(cc_terceros.CodMunicipio,3,4) AS CodMunicipio, cc_terceros.CodPais, cc_terceros.Id,0,cc_tipo_concepto_dian.Tope  FROM cc_tipo_concepto_dian INNER JOIN " + this.xcc_puc + "  ON (cc_tipo_concepto_dian.Id = " + this.xcc_puc + ".Id_TipoConceptoDian) INNER JOIN " + this.xcc_detalle_documentoc + "  ON (" + this.xcc_puc + ".Id = " + this.xcc_detalle_documentoc + ".Id_Puc) INNER JOIN cc_tipo_formato_concepto_dian  ON (cc_tipo_formato_concepto_dian.Id_ConceptoDian = cc_tipo_concepto_dian.Id) INNER JOIN cc_tipo_formato_dian  ON (cc_tipo_formato_concepto_dian.Id_FormatoDian = cc_tipo_formato_dian.Id) INNER JOIN " + this.xcc_documentoc + "  ON (" + this.xcc_detalle_documentoc + ".Id_Documentoc = " + this.xcc_documentoc + ".Id) INNER JOIN cc_terceros  ON (" + this.xcc_detalle_documentoc + ".Id_Tercero = cc_terceros.Id) INNER JOIN `cc_periodo_contable`  ON (cc_periodo_contable.`Id` = " + this.xcc_documentoc + ".`Id_PeriodoC`)  WHERE (cc_tipo_formato_dian.Id =1012 AND cc_periodo_contable.`EsCierre`=0 AND date_format(`cc_periodo_contable`.`FechaI`,'%Y')='" + this.JYCAno1.getValue() + "' AND " + this.xcc_documentoc + ".Estado =1 ) GROUP BY cc_tipo_concepto_dian.Id, cc_terceros.Id ORDER BY cc_terceros.Id, cc_tipo_concepto_dian.Id ";
            this.xconsultas.ejecutarSQL(this.xsql);
            this.xconsultas.cerrarConexionBd();
            this.xsql = "SELECT Concepto FROM cc_tmp_f1001 GROUP BY Concepto ORDER BY Concepto ASC";
            ResultSet rs = this.xconsultas.traerRs(this.xsql);
            if (rs.next()) {
                rs.beforeFirst();
                while (rs.next()) {
                    mCargarDetalleTableF1008(rs.getString(1));
                }
            }
            rs.close();
            this.xconsultas.cerrarConexionBd();
            this.xsql = "SELECT cc_tmp_f1001.Concepto, cc_tmp_f1001.Tipo, cc_tmp_f1001.NIdentificacion, cc_tmp_f1001.DV, cc_tmp_f1001.Apellido1, cc_tmp_f1001.Apellido2, cc_tmp_f1001.Nombre1, cc_tmp_f1001.Nombre2, cc_tmp_f1001.RazonS , cc_tmp_f1001.Pais, cc_tmp_f1001.V1, cc_tmp_f1001.Tope  FROM g_empresa INNER JOIN cc_tmp_f1001  ON (g_empresa.Id = cc_tmp_f1001.Id_Tercero) WHERE (cc_tmp_f1001.V1>=cc_tmp_f1001.Tope) ORDER BY cc_tmp_f1001.Concepto ASC, cc_tmp_f1001.Apellido1 ASC ";
            mCrearTabla3();
            ResultSet rs2 = this.xconsultas.traerRs(this.xsql);
            if (rs2.next()) {
                rs2.beforeFirst();
                while (rs2.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(Long.valueOf(rs2.getLong(1)), this.xnfila, 0);
                    this.xmodelo.setValueAt(rs2.getString(2), this.xnfila, 1);
                    this.xmodelo.setValueAt(rs2.getString(3), this.xnfila, 2);
                    this.xmodelo.setValueAt(rs2.getString(4), this.xnfila, 3);
                    this.xmodelo.setValueAt(rs2.getString(5), this.xnfila, 4);
                    this.xmodelo.setValueAt(rs2.getString(6), this.xnfila, 5);
                    this.xmodelo.setValueAt(rs2.getString(7), this.xnfila, 6);
                    this.xmodelo.setValueAt(rs2.getString(8), this.xnfila, 7);
                    this.xmodelo.setValueAt(rs2.getString(9), this.xnfila, 8);
                    this.xmodelo.setValueAt(rs2.getString(10), this.xnfila, 9);
                    this.xmodelo.setValueAt(Double.valueOf(rs2.getDouble(11)), this.xnfila, 10);
                    this.xnfila++;
                }
            }
            rs2.close();
            this.xconsultas.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFConsultarDatosMDian.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mBuscarDatos(String sql) {
        try {
            mCrearTabla4();
            ResultSet rs = this.xconsultas.traerRs(sql);
            if (rs.next()) {
                rs.beforeFirst();
                this.xnfila = 0;
                while (rs.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(Long.valueOf(rs.getLong(1)), this.xnfila, 0);
                    this.xmodelo.setValueAt(rs.getString(2), this.xnfila, 1);
                    this.xmodelo.setValueAt(rs.getString(3), this.xnfila, 2);
                    this.xmodelo.setValueAt(rs.getString(4), this.xnfila, 3);
                    this.xmodelo.setValueAt(rs.getString(5), this.xnfila, 4);
                    this.xmodelo.setValueAt(rs.getString(6), this.xnfila, 5);
                    this.xmodelo.setValueAt(rs.getString(7), this.xnfila, 6);
                    this.xmodelo.setValueAt(rs.getString(8), this.xnfila, 7);
                    this.xmodelo.setValueAt(rs.getString(9), this.xnfila, 8);
                    this.xmodelo.setValueAt(Long.valueOf(rs.getLong(10)), this.xnfila, 9);
                    this.xmodelo.setValueAt(Double.valueOf(rs.getDouble(11)), this.xnfila, 10);
                    this.xmodelo.setValueAt(Double.valueOf(rs.getDouble(12)), this.xnfila, 11);
                    this.xmodelo.setValueAt(rs.getString(13), this.xnfila, 12);
                    this.xmodelo.setValueAt(rs.getString(14), this.xnfila, 13);
                    this.xnfila++;
                }
            }
            rs.close();
            this.xconsultas.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFConsultarDatosMDian.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mExportar() {
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            try {
                WritableWorkbook workbook = Workbook.createWorkbook(new File(this.JTFRuta.getText() + ".xls"));
                WritableSheet sheet = workbook.createSheet("plantilla", 0);
                String[] xencabezado = {"Concepto", "Tipo Documento", "NIdentificacion", "Dv", "1 Apellido", "2 Apellido", "1 Nombre", "2 Nombre", "Razon Social", "Direccion", "Depto", "Municipio", "Pais", "VAbono D", "VAbono ND", "Iva D", "Iva ND", "RetencionPR", "RetencionAR", "RetencionIvaRC", "RetencionIvaRS", "RetencionIvaOC", "RCreeDescontado", "RCreeAsumida"};
                for (int x = 0; x < xencabezado.length; x++) {
                    sheet.addCell(new Label(x, 0, xencabezado[x]));
                }
                for (int y = 0; y < this.JTDetalle.getRowCount(); y++) {
                    sheet.addCell(new Number(0, y + 1, Long.valueOf(this.xmodelo.getValueAt(y, 0).toString()).longValue()));
                    sheet.addCell(new Label(1, y + 1, this.xmodelo.getValueAt(y, 1).toString()));
                    sheet.addCell(new Label(2, y + 1, this.xmodelo.getValueAt(y, 2).toString()));
                    sheet.addCell(new Label(3, y + 1, this.xmodelo.getValueAt(y, 3).toString()));
                    sheet.addCell(new Label(4, y + 1, this.xmodelo.getValueAt(y, 4).toString()));
                    sheet.addCell(new Label(5, y + 1, this.xmodelo.getValueAt(y, 5).toString()));
                    sheet.addCell(new Label(6, y + 1, this.xmodelo.getValueAt(y, 6).toString()));
                    sheet.addCell(new Label(7, y + 1, this.xmodelo.getValueAt(y, 7).toString()));
                    sheet.addCell(new Label(8, y + 1, this.xmodelo.getValueAt(y, 8).toString()));
                    sheet.addCell(new Label(9, y + 1, this.xmodelo.getValueAt(y, 9).toString()));
                    sheet.addCell(new Label(10, y + 1, this.xmodelo.getValueAt(y, 10).toString()));
                    sheet.addCell(new Label(11, y + 1, this.xmodelo.getValueAt(y, 11).toString()));
                    sheet.addCell(new Label(12, y + 1, this.xmodelo.getValueAt(y, 12).toString()));
                    sheet.addCell(new Number(13, y + 1, Double.valueOf(this.xmodelo.getValueAt(y, 13).toString()).doubleValue()));
                    sheet.addCell(new Number(14, y + 1, Double.valueOf(this.xmodelo.getValueAt(y, 14).toString()).doubleValue()));
                    sheet.addCell(new Number(15, y + 1, Double.valueOf(this.xmodelo.getValueAt(y, 15).toString()).doubleValue()));
                    sheet.addCell(new Number(16, y + 1, Double.valueOf(this.xmodelo.getValueAt(y, 16).toString()).doubleValue()));
                    sheet.addCell(new Number(17, y + 1, Double.valueOf(this.xmodelo.getValueAt(y, 17).toString()).doubleValue()));
                    sheet.addCell(new Number(18, y + 1, Double.valueOf(this.xmodelo.getValueAt(y, 18).toString()).doubleValue()));
                    sheet.addCell(new Number(19, y + 1, Double.valueOf(this.xmodelo.getValueAt(y, 19).toString()).doubleValue()));
                    sheet.addCell(new Number(20, y + 1, Double.valueOf(this.xmodelo.getValueAt(y, 20).toString()).doubleValue()));
                    sheet.addCell(new Number(21, y + 1, Double.valueOf(this.xmodelo.getValueAt(y, 21).toString()).doubleValue()));
                    sheet.addCell(new Number(22, y + 1, Double.valueOf(this.xmodelo.getValueAt(y, 22).toString()).doubleValue()));
                    sheet.addCell(new Number(23, y + 1, Double.valueOf(this.xmodelo.getValueAt(y, 23).toString()).doubleValue()));
                }
                workbook.write();
                workbook.close();
            } catch (WriteException e) {
                Logger.getLogger(JIFConsultarDatosMDian.class.getName()).log(Level.SEVERE, (String) null, e);
            } catch (IOException ex) {
                Logger.getLogger(JIFConsultarDatosMDian.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        }
    }

    private void mExportar1() {
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            try {
                WritableWorkbook workbook = Workbook.createWorkbook(new File(this.JTFRuta.getText() + ".xls"));
                WritableSheet sheet = workbook.createSheet("plantilla", 0);
                for (int x = 0; x < this.JTDetalle.getColumnCount(); x++) {
                    sheet.addCell(new Label(x, 0, this.JTDetalle.getColumnName(x)));
                }
                for (int y = 0; y < this.JTDetalle.getRowCount(); y++) {
                    sheet.addCell(new Number(0, y + 1, Long.valueOf(this.xmodelo.getValueAt(y, 0).toString()).longValue()));
                    sheet.addCell(new Label(1, y + 1, this.xmodelo.getValueAt(y, 1).toString()));
                    sheet.addCell(new Label(2, y + 1, this.xmodelo.getValueAt(y, 2).toString()));
                    sheet.addCell(new Label(3, y + 1, this.xmodelo.getValueAt(y, 3).toString()));
                    sheet.addCell(new Label(4, y + 1, this.xmodelo.getValueAt(y, 4).toString()));
                    sheet.addCell(new Label(5, y + 1, this.xmodelo.getValueAt(y, 5).toString()));
                    sheet.addCell(new Label(6, y + 1, this.xmodelo.getValueAt(y, 6).toString()));
                    sheet.addCell(new Label(7, y + 1, this.xmodelo.getValueAt(y, 7).toString()));
                    sheet.addCell(new Label(8, y + 1, this.xmodelo.getValueAt(y, 8).toString()));
                    sheet.addCell(new Label(9, y + 1, this.xmodelo.getValueAt(y, 9).toString()));
                    sheet.addCell(new Number(10, y + 1, Double.valueOf(this.xmodelo.getValueAt(y, 10).toString()).doubleValue()));
                    sheet.addCell(new Number(11, y + 1, Double.valueOf(this.xmodelo.getValueAt(y, 11).toString()).doubleValue()));
                    sheet.addCell(new Number(12, y + 1, Double.valueOf(this.xmodelo.getValueAt(y, 12).toString()).doubleValue()));
                    sheet.addCell(new Number(13, y + 1, Double.valueOf(this.xmodelo.getValueAt(y, 13).toString()).doubleValue()));
                    sheet.addCell(new Number(14, y + 1, Double.valueOf(this.xmodelo.getValueAt(y, 14).toString()).doubleValue()));
                    sheet.addCell(new Number(15, y + 1, Double.valueOf(this.xmodelo.getValueAt(y, 15).toString()).doubleValue()));
                    sheet.addCell(new Number(16, y + 1, Double.valueOf(this.xmodelo.getValueAt(y, 16).toString()).doubleValue()));
                }
                workbook.write();
                workbook.close();
            } catch (WriteException e) {
                Logger.getLogger(JIFConsultarDatosMDian.class.getName()).log(Level.SEVERE, (String) null, e);
            } catch (IOException ex) {
                Logger.getLogger(JIFConsultarDatosMDian.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        }
    }

    private void mExportar2() {
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            try {
                WritableWorkbook workbook = Workbook.createWorkbook(new File(this.JTFRuta.getText() + ".xls"));
                WritableSheet sheet = workbook.createSheet("plantilla", 0);
                for (int x = 0; x < this.JTDetalle.getColumnCount(); x++) {
                    sheet.addCell(new Label(x, 0, this.JTDetalle.getColumnName(x)));
                }
                for (int y = 0; y < this.JTDetalle.getRowCount(); y++) {
                    sheet.addCell(new Number(0, y + 1, Long.valueOf(this.xmodelo.getValueAt(y, 0).toString()).longValue()));
                    sheet.addCell(new Label(1, y + 1, this.xmodelo.getValueAt(y, 1).toString()));
                    sheet.addCell(new Label(2, y + 1, this.xmodelo.getValueAt(y, 2).toString()));
                    sheet.addCell(new Label(3, y + 1, this.xmodelo.getValueAt(y, 3).toString()));
                    sheet.addCell(new Label(4, y + 1, this.xmodelo.getValueAt(y, 4).toString()));
                    sheet.addCell(new Label(5, y + 1, this.xmodelo.getValueAt(y, 5).toString()));
                    sheet.addCell(new Label(6, y + 1, this.xmodelo.getValueAt(y, 6).toString()));
                    sheet.addCell(new Label(7, y + 1, this.xmodelo.getValueAt(y, 7).toString()));
                    sheet.addCell(new Label(8, y + 1, this.xmodelo.getValueAt(y, 8).toString()));
                    sheet.addCell(new Label(9, y + 1, this.xmodelo.getValueAt(y, 9).toString()));
                    sheet.addCell(new Label(10, y + 1, this.xmodelo.getValueAt(y, 10).toString()));
                    sheet.addCell(new Label(11, y + 1, this.xmodelo.getValueAt(y, 11).toString()));
                    sheet.addCell(new Label(12, y + 1, this.xmodelo.getValueAt(y, 12).toString()));
                    sheet.addCell(new Number(13, y + 1, Double.valueOf(this.xmodelo.getValueAt(y, 13).toString()).doubleValue()));
                }
                workbook.write();
                workbook.close();
            } catch (IOException ex) {
                Logger.getLogger(JIFConsultarDatosMDian.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            } catch (WriteException e) {
                Logger.getLogger(JIFConsultarDatosMDian.class.getName()).log(Level.SEVERE, (String) null, e);
            }
        }
    }

    private void mExportar3() {
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            try {
                WritableWorkbook workbook = Workbook.createWorkbook(new File(this.JTFRuta.getText() + ".xls"));
                WritableSheet sheet = workbook.createSheet("plantilla", 0);
                for (int x = 0; x < this.JTDetalle.getColumnCount(); x++) {
                    sheet.addCell(new Label(x, 0, this.JTDetalle.getColumnName(x)));
                }
                for (int y = 0; y < this.JTDetalle.getRowCount(); y++) {
                    sheet.addCell(new Number(0, y + 1, Long.valueOf(this.xmodelo.getValueAt(y, 0).toString()).longValue()));
                    sheet.addCell(new Label(1, y + 1, this.xmodelo.getValueAt(y, 1).toString()));
                    sheet.addCell(new Label(2, y + 1, this.xmodelo.getValueAt(y, 2).toString()));
                    sheet.addCell(new Label(3, y + 1, this.xmodelo.getValueAt(y, 3).toString()));
                    sheet.addCell(new Label(4, y + 1, this.xmodelo.getValueAt(y, 4).toString()));
                    sheet.addCell(new Label(5, y + 1, this.xmodelo.getValueAt(y, 5).toString()));
                    sheet.addCell(new Label(6, y + 1, this.xmodelo.getValueAt(y, 6).toString()));
                    sheet.addCell(new Label(7, y + 1, this.xmodelo.getValueAt(y, 7).toString()));
                    sheet.addCell(new Label(8, y + 1, this.xmodelo.getValueAt(y, 8).toString()));
                    if (this.JTPDatos.getSelectedIndex() == 0) {
                        sheet.addCell(new Label(9, y + 1, this.xmodelo.getValueAt(y, 9).toString()));
                        sheet.addCell(new Number(10, y + 1, Double.valueOf(this.xmodelo.getValueAt(y, 10).toString()).doubleValue()));
                    } else {
                        sheet.addCell(new Number(9, y + 1, Long.valueOf(this.xmodelo.getValueAt(y, 9).toString()).longValue()));
                        sheet.addCell(new Number(10, y + 1, Double.valueOf(this.xmodelo.getValueAt(y, 10).toString()).doubleValue()));
                        sheet.addCell(new Number(11, y + 1, Double.valueOf(this.xmodelo.getValueAt(y, 11).toString()).doubleValue()));
                        sheet.addCell(new Label(12, y + 1, this.xmodelo.getValueAt(y, 12).toString()));
                        sheet.addCell(new Label(13, y + 1, this.xmodelo.getValueAt(y, 13).toString()));
                    }
                }
                workbook.write();
                workbook.close();
            } catch (IOException ex) {
                Logger.getLogger(JIFConsultarDatosMDian.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            } catch (WriteException e) {
                Logger.getLogger(JIFConsultarDatosMDian.class.getName()).log(Level.SEVERE, (String) null, e);
            }
        }
    }

    private void mGenerarArchivoTexto() {
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            this.xmt.mEliminarArchivo(new File(this.JTFRuta.getText() + ".cvs"));
            try {
                DecimalFormat xformato = new DecimalFormat("###");
                FileWriter fw = new FileWriter(this.JTFRuta.getText() + ".cvs");
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter salArch = new PrintWriter(bw);
                for (int x = 0; x < this.JTDetalle.getRowCount(); x++) {
                    salArch.println(this.xmodelo.getValueAt(x, 0).toString() + ";" + this.xmodelo.getValueAt(x, 1) + ";" + this.xmodelo.getValueAt(x, 2) + ";" + this.xmodelo.getValueAt(x, 3) + ";" + this.xmodelo.getValueAt(x, 4) + ";" + this.xmodelo.getValueAt(x, 5) + ";" + this.xmodelo.getValueAt(x, 6) + ";" + this.xmodelo.getValueAt(x, 7) + ";" + this.xmodelo.getValueAt(x, 8) + ";" + this.xmodelo.getValueAt(x, 9) + ";" + xformato.format(Double.valueOf(this.xmodelo.getValueAt(x, 10).toString())) + ";" + xformato.format(Double.valueOf(this.xmodelo.getValueAt(x, 11).toString())));
                }
                salArch.close();
                fw.close();
            } catch (IOException ex) {
                Logger.getLogger(JIFConsultarDatosMDian.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        }
    }

    private void mGenerarArchivoTexto2() {
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            this.xmt.mEliminarArchivo(new File(this.JTFRuta.getText() + ".cvs"));
            try {
                new DecimalFormat("###");
                FileWriter fw = new FileWriter(this.JTFRuta.getText() + ".cvs");
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter salArch = new PrintWriter(bw);
                for (int x = 0; x < this.JTDetalle.getRowCount(); x++) {
                    salArch.println(this.xmodelo.getValueAt(x, 0).toString() + ";" + this.xmodelo.getValueAt(x, 1) + ";" + this.xmodelo.getValueAt(x, 2) + ";" + this.xmodelo.getValueAt(x, 3) + ";" + this.xmodelo.getValueAt(x, 4) + ";" + this.xmodelo.getValueAt(x, 5) + ";" + this.xmodelo.getValueAt(x, 6) + ";" + this.xmodelo.getValueAt(x, 7) + ";" + this.xmodelo.getValueAt(x, 8) + ";" + this.xmodelo.getValueAt(x, 9) + ";" + this.xmodelo.getValueAt(x, 10) + ";" + this.xmodelo.getValueAt(x, 11) + ";" + this.xmodelo.getValueAt(x, 12) + ";" + this.xmodelo.getValueAt(x, 13) + ";" + this.xmodelo.getValueAt(x, 14) + ";" + this.xmodelo.getValueAt(x, 15) + ";" + this.xmodelo.getValueAt(x, 16) + this.xmodelo.getValueAt(x, 16) + ";" + this.xmodelo.getValueAt(x, 17) + ";" + this.xmodelo.getValueAt(x, 18));
                }
                salArch.close();
                fw.close();
            } catch (IOException ex) {
                Logger.getLogger(JIFConsultarDatosMDian.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        }
    }
}
