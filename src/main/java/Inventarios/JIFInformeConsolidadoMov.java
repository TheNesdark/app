package Inventarios;

import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
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
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

/* JADX INFO: loaded from: GenomaP.jar:Inventarios/JIFInformeConsolidadoMov.class */
public class JIFInformeConsolidadoMov extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private DefaultTableModel xmodelo1;
    private DefaultTableModel xmodelo2;
    private DefaultTableModel xmodelo3;
    private Object[] xdatos;
    private String[] xidbodega;
    private String[] xId_TipoEmpresa;
    private String[][] xidperiodo;
    private String xsql;
    private JButton JBTExportar;
    private JComboBox JCBBodega;
    private JComboBox JCBPeriodo;
    private JComboBox JCB_TipoEmpresa;
    private JCheckBox JCHContable;
    private JCheckBox JCH_FiltroR;
    public JDateChooser JDCFechaF;
    public JDateChooser JDCFechaI;
    private JPanel JPIDatos;
    private JPanel JPIEntradas;
    private JPanel JPIMP;
    private JPanel JPISalidas;
    private JPanel JPITotales;
    private JPanel JPITotales1;
    private JPanel JPITotales2;
    private JPanel JPI_DRecobro;
    private JPanel JPI_Dinventario;
    private JScrollPane JSPDetalleE;
    private JScrollPane JSPDetalleMP;
    private JScrollPane JSPDetalleR;
    private JScrollPane JSPDetalleS;
    private JTable JTDetalleE;
    private JTable JTDetalleMP;
    private JTable JTDetalleR;
    private JTable JTDetalleS;
    private JFormattedTextField JTFFTotal1;
    private JFormattedTextField JTFFTotal10;
    private JFormattedTextField JTFFTotal2;
    private JFormattedTextField JTFFTotal3;
    private JFormattedTextField JTFFTotal4;
    private JFormattedTextField JTFFTotal5;
    private JFormattedTextField JTFFTotal6;
    private JFormattedTextField JTFFTotal7;
    private JFormattedTextField JTFFTotal8;
    private JFormattedTextField JTFFTotal9;
    private JTextField JTFRuta;
    private JTabbedPane JTPDatos;
    private JTabbedPane JTP_DatoP;
    private ConsultasMySQL xct = new ConsultasMySQL();
    private Metodos xmt = new Metodos();
    private boolean xlleno = false;

    public JIFInformeConsolidadoMov(String xnombre) {
        initComponents();
        setName(xnombre);
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v125, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v185, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v38, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v75, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JTFRuta = new JTextField();
        this.JBTExportar = new JButton();
        this.JTP_DatoP = new JTabbedPane();
        this.JPI_Dinventario = new JPanel();
        this.JPIDatos = new JPanel();
        this.JCBBodega = new JComboBox();
        this.JCBPeriodo = new JComboBox();
        this.JCHContable = new JCheckBox();
        this.JTPDatos = new JTabbedPane();
        this.JPISalidas = new JPanel();
        this.JSPDetalleS = new JScrollPane();
        this.JTDetalleS = new JTable();
        this.JPITotales = new JPanel();
        this.JTFFTotal1 = new JFormattedTextField();
        this.JTFFTotal2 = new JFormattedTextField();
        this.JTFFTotal3 = new JFormattedTextField();
        this.JPIEntradas = new JPanel();
        this.JSPDetalleE = new JScrollPane();
        this.JTDetalleE = new JTable();
        this.JPITotales1 = new JPanel();
        this.JTFFTotal4 = new JFormattedTextField();
        this.JTFFTotal5 = new JFormattedTextField();
        this.JTFFTotal6 = new JFormattedTextField();
        this.JPIMP = new JPanel();
        this.JSPDetalleMP = new JScrollPane();
        this.JTDetalleMP = new JTable();
        this.JPITotales2 = new JPanel();
        this.JTFFTotal7 = new JFormattedTextField();
        this.JTFFTotal8 = new JFormattedTextField();
        this.JTFFTotal9 = new JFormattedTextField();
        this.JPI_DRecobro = new JPanel();
        this.JSPDetalleR = new JScrollPane();
        this.JTDetalleR = new JTable();
        this.JDCFechaI = new JDateChooser();
        this.JDCFechaF = new JDateChooser();
        this.JCB_TipoEmpresa = new JComboBox();
        this.JTFFTotal10 = new JFormattedTextField();
        this.JCH_FiltroR = new JCheckBox();
        setClosable(true);
        setIconifiable(true);
        setTitle("CONSOLIDADO DE MOVIMIENTO");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjifconsolidadomovimiento");
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: Inventarios.JIFInformeConsolidadoMov.1
            public void mouseClicked(MouseEvent evt) {
                JIFInformeConsolidadoMov.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setForeground(Color.red);
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: Inventarios.JIFInformeConsolidadoMov.2
            public void actionPerformed(ActionEvent evt) {
                JIFInformeConsolidadoMov.this.JBTExportarActionPerformed(evt);
            }
        });
        this.JTP_DatoP.setForeground(new Color(0, 103, 0));
        this.JTP_DatoP.setFont(new Font("Arial", 1, 14));
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS PARA CONSULTA", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JCBBodega.setFont(new Font("Arial", 1, 12));
        this.JCBBodega.setBorder(BorderFactory.createTitledBorder((Border) null, "Bodega", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBPeriodo.setFont(new Font("Arial", 1, 12));
        this.JCBPeriodo.setBorder(BorderFactory.createTitledBorder((Border) null, "Periodo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHContable.setFont(new Font("Arial", 1, 12));
        this.JCHContable.setSelected(true);
        this.JCHContable.setText("Contable?");
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addComponent(this.JCBBodega, -2, 349, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBPeriodo, -2, 243, -2).addGap(18, 18, 18).addComponent(this.JCHContable).addContainerGap(-1, 32767)));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBBodega, -2, -1, -2).addComponent(this.JCBPeriodo, -2, -1, -2).addComponent(this.JCHContable)).addContainerGap(-1, 32767)));
        this.JTPDatos.setForeground(new Color(0, 103, 0));
        this.JTPDatos.setFont(new Font("Arial", 1, 14));
        this.JTDetalleS.setFont(new Font("Arial", 1, 12));
        this.JTDetalleS.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalleS.setRowHeight(25);
        this.JTDetalleS.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalleS.setSelectionForeground(new Color(255, 0, 0));
        this.JSPDetalleS.setViewportView(this.JTDetalleS);
        this.JPITotales.setBorder(BorderFactory.createTitledBorder((Border) null, "TOTALES", 0, 0, new Font("Arial", 1, 14), Color.red));
        this.JTFFTotal1.setEditable(false);
        this.JTFFTotal1.setBorder(BorderFactory.createTitledBorder((Border) null, "NOrdenes", 0, 0, new Font("Arial", 1, 13), Color.blue));
        this.JTFFTotal1.setForeground(Color.red);
        this.JTFFTotal1.setHorizontalAlignment(0);
        this.JTFFTotal1.setFont(new Font("Arial", 1, 18));
        this.JTFFTotal2.setEditable(false);
        this.JTFFTotal2.setBorder(BorderFactory.createTitledBorder((Border) null, "NItems", 0, 0, new Font("Arial", 1, 13), Color.blue));
        this.JTFFTotal2.setForeground(Color.red);
        this.JTFFTotal2.setHorizontalAlignment(0);
        this.JTFFTotal2.setFont(new Font("Arial", 1, 18));
        this.JTFFTotal3.setEditable(false);
        this.JTFFTotal3.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor", 0, 0, new Font("Arial", 1, 13), Color.blue));
        this.JTFFTotal3.setForeground(Color.red);
        this.JTFFTotal3.setHorizontalAlignment(0);
        this.JTFFTotal3.setFont(new Font("Arial", 1, 18));
        GroupLayout JPITotalesLayout = new GroupLayout(this.JPITotales);
        this.JPITotales.setLayout(JPITotalesLayout);
        JPITotalesLayout.setHorizontalGroup(JPITotalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPITotalesLayout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.JTFFTotal1, -2, 116, -2).addGap(18, 18, 18).addComponent(this.JTFFTotal2, -2, 116, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFFTotal3, -2, 184, -2).addContainerGap()));
        JPITotalesLayout.setVerticalGroup(JPITotalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPITotalesLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFTotal3, -2, -1, -2).addComponent(this.JTFFTotal1, -2, -1, -2).addComponent(this.JTFFTotal2, -2, -1, -2)));
        GroupLayout JPISalidasLayout = new GroupLayout(this.JPISalidas);
        this.JPISalidas.setLayout(JPISalidasLayout);
        JPISalidasLayout.setHorizontalGroup(JPISalidasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPISalidasLayout.createSequentialGroup().addContainerGap().addGroup(JPISalidasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPDetalleS, -1, 805, 32767).addComponent(this.JPITotales, GroupLayout.Alignment.TRAILING, -2, -1, -2)).addContainerGap()));
        JPISalidasLayout.setVerticalGroup(JPISalidasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPISalidasLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPDetalleS, -2, 183, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JPITotales, -2, -1, -2).addContainerGap()));
        this.JTPDatos.addTab("SALIDAS", this.JPISalidas);
        this.JTDetalleE.setFont(new Font("Arial", 1, 12));
        this.JTDetalleE.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalleE.setRowHeight(25);
        this.JTDetalleE.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalleE.setSelectionForeground(new Color(255, 0, 0));
        this.JSPDetalleE.setViewportView(this.JTDetalleE);
        this.JPITotales1.setBorder(BorderFactory.createTitledBorder((Border) null, "TOTALES", 0, 0, new Font("Arial", 1, 14), Color.red));
        this.JTFFTotal4.setEditable(false);
        this.JTFFTotal4.setBorder(BorderFactory.createTitledBorder((Border) null, "NOrdenes", 0, 0, new Font("Arial", 1, 13), Color.blue));
        this.JTFFTotal4.setForeground(Color.red);
        this.JTFFTotal4.setHorizontalAlignment(0);
        this.JTFFTotal4.setFont(new Font("Arial", 1, 18));
        this.JTFFTotal5.setEditable(false);
        this.JTFFTotal5.setBorder(BorderFactory.createTitledBorder((Border) null, "NItems", 0, 0, new Font("Arial", 1, 13), Color.blue));
        this.JTFFTotal5.setForeground(Color.red);
        this.JTFFTotal5.setHorizontalAlignment(0);
        this.JTFFTotal5.setFont(new Font("Arial", 1, 18));
        this.JTFFTotal6.setEditable(false);
        this.JTFFTotal6.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor", 0, 0, new Font("Arial", 1, 13), Color.blue));
        this.JTFFTotal6.setForeground(Color.red);
        this.JTFFTotal6.setHorizontalAlignment(0);
        this.JTFFTotal6.setFont(new Font("Arial", 1, 18));
        GroupLayout JPITotales1Layout = new GroupLayout(this.JPITotales1);
        this.JPITotales1.setLayout(JPITotales1Layout);
        JPITotales1Layout.setHorizontalGroup(JPITotales1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPITotales1Layout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.JTFFTotal4, -2, 116, -2).addGap(18, 18, 18).addComponent(this.JTFFTotal5, -2, 116, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFFTotal6, -2, 184, -2).addContainerGap()));
        JPITotales1Layout.setVerticalGroup(JPITotales1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPITotales1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFTotal6, -2, -1, -2).addComponent(this.JTFFTotal4, -2, -1, -2).addComponent(this.JTFFTotal5, -2, -1, -2)));
        GroupLayout JPIEntradasLayout = new GroupLayout(this.JPIEntradas);
        this.JPIEntradas.setLayout(JPIEntradasLayout);
        JPIEntradasLayout.setHorizontalGroup(JPIEntradasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIEntradasLayout.createSequentialGroup().addContainerGap(339, 32767).addComponent(this.JPITotales1, -2, -1, -2).addContainerGap()).addGroup(JPIEntradasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIEntradasLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPDetalleE, -2, 805, -2).addContainerGap(-1, 32767))));
        JPIEntradasLayout.setVerticalGroup(JPIEntradasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIEntradasLayout.createSequentialGroup().addContainerGap(204, 32767).addComponent(this.JPITotales1, -2, -1, -2).addContainerGap()).addGroup(JPIEntradasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIEntradasLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPDetalleE, -2, 174, -2).addContainerGap(-1, 32767))));
        this.JTPDatos.addTab("ENTRADAS", this.JPIEntradas);
        this.JTDetalleMP.setFont(new Font("Arial", 1, 12));
        this.JTDetalleMP.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalleMP.setRowHeight(25);
        this.JTDetalleMP.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalleMP.setSelectionForeground(new Color(255, 0, 0));
        this.JSPDetalleMP.setViewportView(this.JTDetalleMP);
        this.JPITotales2.setBorder(BorderFactory.createTitledBorder((Border) null, "TOTALES", 0, 0, new Font("Arial", 1, 14), Color.red));
        this.JTFFTotal7.setEditable(false);
        this.JTFFTotal7.setBorder(BorderFactory.createTitledBorder((Border) null, "NOrdenes", 0, 0, new Font("Arial", 1, 13), Color.blue));
        this.JTFFTotal7.setForeground(Color.red);
        this.JTFFTotal7.setHorizontalAlignment(0);
        this.JTFFTotal7.setFont(new Font("Arial", 1, 18));
        this.JTFFTotal8.setEditable(false);
        this.JTFFTotal8.setBorder(BorderFactory.createTitledBorder((Border) null, "NItems", 0, 0, new Font("Arial", 1, 13), Color.blue));
        this.JTFFTotal8.setForeground(Color.red);
        this.JTFFTotal8.setHorizontalAlignment(0);
        this.JTFFTotal8.setFont(new Font("Arial", 1, 18));
        this.JTFFTotal9.setEditable(false);
        this.JTFFTotal9.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor", 0, 0, new Font("Arial", 1, 13), Color.blue));
        this.JTFFTotal9.setForeground(Color.red);
        this.JTFFTotal9.setHorizontalAlignment(0);
        this.JTFFTotal9.setFont(new Font("Arial", 1, 18));
        GroupLayout JPITotales2Layout = new GroupLayout(this.JPITotales2);
        this.JPITotales2.setLayout(JPITotales2Layout);
        JPITotales2Layout.setHorizontalGroup(JPITotales2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPITotales2Layout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.JTFFTotal7, -2, 116, -2).addGap(18, 18, 18).addComponent(this.JTFFTotal8, -2, 116, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFFTotal9, -2, 184, -2).addContainerGap()));
        JPITotales2Layout.setVerticalGroup(JPITotales2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPITotales2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFTotal9, -2, -1, -2).addComponent(this.JTFFTotal7, -2, -1, -2).addComponent(this.JTFFTotal8, -2, -1, -2)));
        GroupLayout JPIMPLayout = new GroupLayout(this.JPIMP);
        this.JPIMP.setLayout(JPIMPLayout);
        JPIMPLayout.setHorizontalGroup(JPIMPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIMPLayout.createSequentialGroup().addContainerGap(339, 32767).addComponent(this.JPITotales2, -2, -1, -2).addContainerGap()).addGroup(JPIMPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIMPLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPDetalleMP, -2, 805, -2).addContainerGap(-1, 32767))));
        JPIMPLayout.setVerticalGroup(JPIMPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIMPLayout.createSequentialGroup().addContainerGap(204, 32767).addComponent(this.JPITotales2, -2, -1, -2).addContainerGap()).addGroup(JPIMPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIMPLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPDetalleMP, -2, 174, -2).addContainerGap(-1, 32767))));
        this.JTPDatos.addTab("AUDITORIA MEDICINA PREPAGADA", this.JPIMP);
        GroupLayout JPI_DinventarioLayout = new GroupLayout(this.JPI_Dinventario);
        this.JPI_Dinventario.setLayout(JPI_DinventarioLayout);
        JPI_DinventarioLayout.setHorizontalGroup(JPI_DinventarioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DinventarioLayout.createSequentialGroup().addContainerGap().addGroup(JPI_DinventarioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPIDatos, -1, -1, 32767).addComponent(this.JTPDatos)).addContainerGap()));
        JPI_DinventarioLayout.setVerticalGroup(JPI_DinventarioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DinventarioLayout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTPDatos).addContainerGap()));
        this.JTP_DatoP.addTab("INFORMACIÓN DE INVENTARIO", this.JPI_Dinventario);
        this.JSPDetalleR.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalleR.setFont(new Font("Arial", 1, 12));
        this.JTDetalleR.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalleR.setRowHeight(25);
        this.JTDetalleR.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalleR.setSelectionForeground(new Color(255, 0, 0));
        this.JSPDetalleR.setViewportView(this.JTDetalleR);
        this.JDCFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicio", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDCFechaI.setFont(new Font("Arial", 1, 12));
        this.JDCFechaI.addPropertyChangeListener(new PropertyChangeListener() { // from class: Inventarios.JIFInformeConsolidadoMov.3
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFInformeConsolidadoMov.this.JDCFechaIPropertyChange(evt);
            }
        });
        this.JDCFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicio", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDCFechaF.setFont(new Font("Arial", 1, 12));
        this.JDCFechaF.addPropertyChangeListener(new PropertyChangeListener() { // from class: Inventarios.JIFInformeConsolidadoMov.4
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFInformeConsolidadoMov.this.JDCFechaFPropertyChange(evt);
            }
        });
        this.JCB_TipoEmpresa.setFont(new Font("Arial", 1, 12));
        this.JCB_TipoEmpresa.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Empresa", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCB_TipoEmpresa.addItemListener(new ItemListener() { // from class: Inventarios.JIFInformeConsolidadoMov.5
            public void itemStateChanged(ItemEvent evt) {
                JIFInformeConsolidadoMov.this.JCB_TipoEmpresaItemStateChanged(evt);
            }
        });
        this.JTFFTotal10.setEditable(false);
        this.JTFFTotal10.setBorder(BorderFactory.createTitledBorder((Border) null, "Total", 0, 0, new Font("Arial", 1, 13), Color.blue));
        this.JTFFTotal10.setForeground(Color.red);
        this.JTFFTotal10.setHorizontalAlignment(0);
        this.JTFFTotal10.setFont(new Font("Arial", 1, 18));
        this.JCH_FiltroR.setFont(new Font("Arial", 1, 12));
        this.JCH_FiltroR.setText("Filtro?");
        this.JCH_FiltroR.addActionListener(new ActionListener() { // from class: Inventarios.JIFInformeConsolidadoMov.6
            public void actionPerformed(ActionEvent evt) {
                JIFInformeConsolidadoMov.this.JCH_FiltroRActionPerformed(evt);
            }
        });
        GroupLayout JPI_DRecobroLayout = new GroupLayout(this.JPI_DRecobro);
        this.JPI_DRecobro.setLayout(JPI_DRecobroLayout);
        JPI_DRecobroLayout.setHorizontalGroup(JPI_DRecobroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DRecobroLayout.createSequentialGroup().addContainerGap().addGroup(JPI_DRecobroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPDetalleR).addGroup(JPI_DRecobroLayout.createSequentialGroup().addComponent(this.JDCFechaI, -2, 120, -2).addGap(18, 18, 18).addComponent(this.JDCFechaF, -2, 120, -2).addGap(29, 29, 29).addComponent(this.JCB_TipoEmpresa, -2, 291, -2).addGap(41, 41, 41).addComponent(this.JCH_FiltroR).addGap(0, 150, 32767)).addGroup(GroupLayout.Alignment.TRAILING, JPI_DRecobroLayout.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.JTFFTotal10, -2, 184, -2))).addContainerGap()));
        JPI_DRecobroLayout.setVerticalGroup(JPI_DRecobroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DRecobroLayout.createSequentialGroup().addContainerGap().addGroup(JPI_DRecobroLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPI_DRecobroLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(JPI_DRecobroLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JDCFechaI, -2, 50, -2).addComponent(this.JDCFechaF, -2, 50, -2)).addComponent(this.JCB_TipoEmpresa)).addComponent(this.JCH_FiltroR)).addGap(18, 18, 18).addComponent(this.JSPDetalleR, -1, 294, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFFTotal10, -2, -1, -2).addContainerGap()));
        this.JTP_DatoP.addTab("INFORMACIÓN PARA RECOBRO", this.JPI_DRecobro);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.JTFRuta).addGap(18, 18, 18).addComponent(this.JBTExportar, -2, 339, -2)).addComponent(this.JTP_DatoP)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTP_DatoP).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFRuta, -2, 50, -2).addComponent(this.JBTExportar, -2, 50, -2)).addContainerGap()));
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
            if (this.JTP_DatoP.getSelectedIndex() == 0) {
                if (this.JTDetalleS.getRowCount() > -1) {
                    int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    if (n == 0) {
                        mExportar();
                        return;
                    }
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "No existe información para exportar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                return;
            }
            int n2 = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n2 == 0) {
                this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTDetalleR, this.JTFRuta.getText(), getTitle());
                return;
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un ruta valida", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JTFRuta.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDCFechaIPropertyChange(PropertyChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDCFechaFPropertyChange(PropertyChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_FiltroRActionPerformed(ActionEvent evt) {
        if (this.JCH_FiltroR.isSelected()) {
            this.xlleno = false;
            this.JCB_TipoEmpresa.removeAllItems();
            this.xsql = "SELECT  `Id_TEmpresa` , `NTEmpresa` FROM `cc_tmp_recobro` GROUP BY `Id_TEmpresa` ORDER BY `NTEmpresa` ASC ";
            this.xId_TipoEmpresa = this.xct.llenarCombo(this.xsql, this.xId_TipoEmpresa, this.JCB_TipoEmpresa);
            this.xct.cerrarConexionBd();
            this.xlleno = true;
            return;
        }
        mBuscar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCB_TipoEmpresaItemStateChanged(ItemEvent evt) {
        if (this.JCB_TipoEmpresa.getSelectedIndex() != -1 && this.xlleno) {
            mCargarDatosTablaR();
        }
    }

    public void mNuevo() {
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
        this.JCBBodega.removeAllItems();
        this.xidbodega = this.xct.llenarCombo("SELECT Id, Nbre FROM i_bodegas WHERE (Contabilidad =1) ORDER BY Nbre ASC", this.xidbodega, this.JCBBodega);
        this.JCBBodega.setSelectedIndex(-1);
        this.xct.cerrarConexionBd();
        this.JCBPeriodo.removeAllItems();
        this.xidperiodo = this.xct.llenarComboyLista("SELECT Id, CONCAT(DevuelveMes(FechaF), '-',DATE_FORMAT(FechaF,'%Y')) AS MesC, FechaI, FechaF FROM i_periodo order by FechaI desc", this.xidperiodo, this.JCBPeriodo, 4);
        this.JCBPeriodo.setSelectedIndex(-1);
        this.xct.cerrarConexionBd();
        this.JDCFechaI.setDate(this.xmt.getFechaActual());
        this.JDCFechaF.setDate(this.xmt.getFechaActual());
        mCrearModeloDatoS();
        mCrearModeloDatoE();
        mCrearModeloDatoMP();
        mCrearModeloDatoR();
        this.JTFFTotal1.setValue(new Integer(0));
        this.JTFFTotal2.setValue(new Integer(0));
        this.JTFFTotal3.setValue(new Double(0.0d));
        this.JTFFTotal4.setValue(new Integer(0));
        this.JTFFTotal5.setValue(new Integer(0));
        this.JTFFTotal6.setValue(new Double(0.0d));
        this.JTFFTotal7.setValue(new Integer(0));
        this.JTFFTotal8.setValue(new Integer(0));
        this.JTFFTotal9.setValue(new Double(0.0d));
        this.JCBBodega.requestFocus();
    }

    public void mBuscar() {
        if (this.JTP_DatoP.getSelectedIndex() == 0) {
            if (this.JCBBodega.getSelectedIndex() != -1) {
                if (this.JCBPeriodo.getSelectedIndex() != -1) {
                    mCargarDatosTablaS();
                    mCargarDatosTablaE();
                    mCargarDatosTablaMP();
                    return;
                } else {
                    JOptionPane.showInternalMessageDialog(this, "Debe selecionar un periodo", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                    this.JCBPeriodo.requestFocus();
                    return;
                }
            }
            JOptionPane.showInternalMessageDialog(this, "Debe selecionar una bodega", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
            this.JCBBodega.requestFocus();
            return;
        }
        mInsertarDatosTabla();
        mCargarDatosTablaR();
    }

    private void mInsertarDatosTabla() {
        this.xsql = "delete from cc_tmp_recobro ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "INSERT INTO cc_tmp_recobro( `Id_TEmpresa` , `NTEmpresa` , `Id_UnidadN` , `NUnidadNego` , `NDocumento` , `CSap` , `NUsuario` , `Valor`)\nSELECT  `g_tipoempresa`.`Id` , `g_tipoempresa`.`Nbre` AS `NTipoEmpresa` , `g_tipounidadnegocio`.`Id` , `g_tipounidadnegocio`.`Nbre` AS `NUnidadNegocio` , `g_persona_1`.`NoDocumento` , `g_persona_1`.`Codigo1Sap` , CONCAT(`g_persona_1`.`Apellido1`,' ', `g_persona_1`.`Apellido2`,' ', `g_persona_1`.`Nombre1`,' ', `g_persona_1`.`Nombre2`) AS `NUsuario` , SUM(`h_itemordenessum`.`ValorTotal`) AS `VTotal`\nFROM       `h_ordenes` INNER JOIN  `d_auditoria_formulamp`  ON (`h_ordenes`.`Id_AuditoriaMP` = `d_auditoria_formulamp`.`Id`) INNER JOIN  `h_itemordenessum`  ON (`h_itemordenessum`.`Id_HOrdenes` = `h_ordenes`.`Id`) INNER JOIN  `h_atencion`  ON (`h_ordenes`.`Id_Atencion` = `h_atencion`.`Id`) INNER JOIN  `ingreso` \nON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`) INNER JOIN  `g_usuario`  ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`) INNER JOIN  `g_persona`  ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`) INNER JOIN  `g_usuario_fpz`  ON (`g_usuario_fpz`.`Id_Persona` = `g_persona`.`Id`) INNER JOIN  `g_persona` AS `g_persona_1`  ON (`g_persona_1`.`Id` = `g_usuario_fpz`.`Id_PersDescuento`)\nINNER JOIN  `g_usuario_fpz` AS `g_usuario_fpz_1`  ON (`g_usuario_fpz_1`.`Id_Persona` = `g_persona_1`.`Id`) INNER JOIN  `g_tipounidadnegocio`  ON (`g_usuario_fpz_1`.`Id_UnidadN` = `g_tipounidadnegocio`.`Id`) INNER JOIN  `g_tipoempresa`  ON (`g_usuario_fpz_1`.`Id_Empresa` = `g_tipoempresa`.`Id`)\nWHERE (`d_auditoria_formulamp`.`FechaA` >='" + this.xmt.formatoAMD.format(this.JDCFechaI.getDate()) + "' AND `d_auditoria_formulamp`.`FechaA` <='" + this.xmt.formatoAMD.format(this.JDCFechaF.getDate()) + "' AND d_auditoria_formulamp.`Estado`=1)\nGROUP BY `g_tipoempresa`.`Id`, `g_tipounidadnegocio`.`Id`, `g_persona_1`.`Id`\nORDER BY `NTipoEmpresa` ASC, `NUnidadNegocio` ASC, `NUsuario` ASC";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "INSERT INTO cc_tmp_recobro( `Id_TEmpresa` , `NTEmpresa` , `Id_UnidadN` , `NUnidadNego` , `NDocumento` , `CSap` , `NUsuario` , `Valor`)\nSELECT  `g_tipoempresa`.`Id` , `g_tipoempresa`.`Nbre` AS `NTipoEmpresa` , `g_tipounidadnegocio`.`Id` , `g_tipounidadnegocio`.`Nbre` AS `NUnidadNegocio` , `g_persona_1`.`NoDocumento` , `g_persona_1`.`Codigo1Sap` ,  CONCAT(`g_persona_1`.`Apellido1`,' ', `g_persona_1`.`Apellido2`,' ', `g_persona_1`.`Nombre1`,' ', `g_persona_1`.`Nombre2`) AS `NUsuario` , SUM((`i_detallesalida`.`CantidadDespachada`*`i_detallesalida`.`ValorUnitario`)) AS `VEntrega`\nFROM `i_detallesalida` INNER JOIN  `i_salidas`  ON (`i_detallesalida`.`IdSalida` = `i_salidas`.`Id`) INNER JOIN  `g_persona`  ON (`g_persona`.`Id` = `i_salidas`.`IdDestino`) INNER JOIN  `g_usuario`  ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`) INNER JOIN  `g_usuario_fpz`  ON (`g_usuario_fpz`.`Id_Persona` = `g_persona`.`Id`) INNER JOIN  `g_usuario_fpz` AS `g_usuario_fpz_1`  ON (`g_usuario_fpz_1`.`Id_Persona` = `g_usuario_fpz`.`Id_PersDescuento`)\nINNER JOIN  `g_tipoempresa`  ON (`g_usuario_fpz_1`.`Id_Empresa` = `g_tipoempresa`.`Id`) INNER JOIN  `g_tipounidadnegocio`  ON (`g_usuario_fpz_1`.`Id_UnidadN` = `g_tipounidadnegocio`.`Id`) INNER JOIN  `g_persona` AS `g_persona_1` ON (`g_usuario_fpz_1`.`Id_Persona` = `g_persona_1`.`Id`) INNER JOIN  `i_tiposmovimientos`  ON (`i_salidas`.`IdTipoMovimiento` = `i_tiposmovimientos`.`Id`)\nWHERE (`i_salidas`.`FechaSalida`>='" + this.xmt.formatoAMD.format(this.JDCFechaI.getDate()) + "' AND `i_salidas`.`FechaSalida`<='" + this.xmt.formatoAMD.format(this.JDCFechaF.getDate()) + "' AND `i_salidas`.`Estado` =0  AND `i_tiposmovimientos`.`Despacho` =1 AND i_salidas.`IdBodega`IN(2,4))\nGROUP BY `g_tipoempresa`.`Id`, `g_tipounidadnegocio`.`Id`, `g_persona_1`.`Id`\nORDER BY `NTipoEmpresa` ASC, `NUnidadNegocio` ASC, `NUsuario` ASC";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatoS() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Tipo Movimiento", "C", "D", "NOrden", "NItems", "Valor"}) { // from class: Inventarios.JIFInformeConsolidadoMov.7
            Class[] types = {String.class, String.class, String.class, Long.class, Long.class, Double.class};
            boolean[] canEdit = {false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalleS.setModel(this.xmodelo);
        this.JTDetalleS.getColumnModel().getColumn(0).setPreferredWidth(200);
        this.JTDetalleS.getColumnModel().getColumn(1).setPreferredWidth(50);
        this.JTDetalleS.getColumnModel().getColumn(2).setPreferredWidth(50);
        this.JTDetalleS.getColumnModel().getColumn(3).setPreferredWidth(30);
        this.JTDetalleS.getColumnModel().getColumn(4).setPreferredWidth(30);
        this.JTDetalleS.getColumnModel().getColumn(5).setPreferredWidth(30);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatoE() {
        this.xmodelo1 = new DefaultTableModel(new Object[0], new String[]{"Tipo Movimiento", "C", "D", "NOrden", "NItems", "Valor"}) { // from class: Inventarios.JIFInformeConsolidadoMov.8
            Class[] types = {String.class, String.class, String.class, Long.class, Long.class, Double.class};
            boolean[] canEdit = {false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalleE.setModel(this.xmodelo1);
        this.JTDetalleE.getColumnModel().getColumn(0).setPreferredWidth(200);
        this.JTDetalleE.getColumnModel().getColumn(1).setPreferredWidth(50);
        this.JTDetalleE.getColumnModel().getColumn(2).setPreferredWidth(50);
        this.JTDetalleE.getColumnModel().getColumn(3).setPreferredWidth(30);
        this.JTDetalleE.getColumnModel().getColumn(4).setPreferredWidth(30);
        this.JTDetalleE.getColumnModel().getColumn(5).setPreferredWidth(30);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatoMP() {
        this.xmodelo2 = new DefaultTableModel(new Object[0], new String[]{"Id", "Empresa", "N° Factura", "Fecha Auditoria", "NOrden", "NItems", "Valor"}) { // from class: Inventarios.JIFInformeConsolidadoMov.9
            Class[] types = {String.class, String.class, String.class, String.class, Long.class, Long.class, Double.class};
            boolean[] canEdit = {false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalleMP.setModel(this.xmodelo2);
        this.JTDetalleMP.getColumnModel().getColumn(0).setPreferredWidth(1);
        this.JTDetalleMP.getColumnModel().getColumn(1).setPreferredWidth(200);
        this.JTDetalleMP.getColumnModel().getColumn(2).setPreferredWidth(30);
        this.JTDetalleMP.getColumnModel().getColumn(3).setPreferredWidth(30);
        this.JTDetalleMP.getColumnModel().getColumn(4).setPreferredWidth(30);
        this.JTDetalleMP.getColumnModel().getColumn(5).setPreferredWidth(30);
        this.JTDetalleMP.getColumnModel().getColumn(6).setPreferredWidth(30);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatoR() {
        this.xmodelo3 = new DefaultTableModel(new Object[0], new String[]{"NTipoEmpresa", "Unidad Negocio", "Documento", "Código Sap", "Usuario", "Total"}) { // from class: Inventarios.JIFInformeConsolidadoMov.10
            Class[] types = {String.class, String.class, String.class, Long.class, String.class, Double.class};
            boolean[] canEdit = {false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalleR.setModel(this.xmodelo3);
        this.JTDetalleR.getColumnModel().getColumn(0).setPreferredWidth(30);
        this.JTDetalleR.getColumnModel().getColumn(1).setPreferredWidth(50);
        this.JTDetalleR.getColumnModel().getColumn(2).setPreferredWidth(10);
        this.JTDetalleR.getColumnModel().getColumn(3).setPreferredWidth(10);
        this.JTDetalleR.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTDetalleR.getColumnModel().getColumn(5).setPreferredWidth(30);
    }

    private void mCargarDatosTablaS() {
        try {
            mCrearModeloDatoS();
            if (this.JCHContable.isSelected()) {
                this.xsql = "SELECT i_tiposmovimientos.Nbre, i_tiposmovimientos.CPuc_Credito AS CCredito, i_tiposmovimientos.CPuc_Debito AS CDebito, COUNT(DISTINCT(i_salidas.Id)) AS NFormulas , COUNT(i_salidas.Id) AS NItems , sum(round((i_detallesalida.CantidadDespachada*i_detallesalida.ValorUnitario))) AS Valor     FROM i_detallesalida INNER JOIN i_salidas  ON (i_detallesalida.IdSalida = i_salidas.Id) INNER JOIN i_tiposmovimientos  ON (i_salidas.IdTipoMovimiento = i_tiposmovimientos.Id) WHERE (i_salidas.Id_Periodo ='" + this.xidperiodo[this.JCBPeriodo.getSelectedIndex()][0] + "' AND i_salidas.Estado =0 AND i_salidas.IdBodega in(2,4) AND i_salidas.Id_DocContable <>0) GROUP BY i_tiposmovimientos.Nbre ORDER BY i_tiposmovimientos.Despacho ASC, i_tiposmovimientos.Nbre ASC ";
            } else {
                this.xsql = "SELECT i_tiposmovimientos.Nbre, i_tiposmovimientos.CPuc_Credito AS CCredito, i_tiposmovimientos.CPuc_Debito AS CDebito, COUNT(DISTINCT(i_salidas.Id)) AS NFormulas , COUNT(i_salidas.Id) AS NItems , sum(round((i_detallesalida.CantidadDespachada*i_detallesalida.ValorUnitario))) AS Valor     FROM i_detallesalida INNER JOIN i_salidas  ON (i_detallesalida.IdSalida = i_salidas.Id) INNER JOIN i_tiposmovimientos  ON (i_salidas.IdTipoMovimiento = i_tiposmovimientos.Id) WHERE (i_salidas.Id_Periodo ='" + this.xidperiodo[this.JCBPeriodo.getSelectedIndex()][0] + "' AND i_salidas.Estado =0 AND i_salidas.IdBodega ='" + this.xidbodega[this.JCBBodega.getSelectedIndex()] + "') GROUP BY i_tiposmovimientos.Nbre ORDER BY i_tiposmovimientos.Despacho ASC, i_tiposmovimientos.Nbre ASC ";
            }
            ResultSet xrs = this.xct.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                double xv1 = 0.0d;
                double xv2 = 0.0d;
                double xv3 = 0.0d;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(xrs.getString(1), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(4)), n, 3);
                    xv1 += xrs.getLong(4);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(5)), n, 4);
                    xv2 += xrs.getLong(5);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(6)), n, 5);
                    xv3 += xrs.getDouble(6);
                    n++;
                }
                this.JTFFTotal1.setValue(Double.valueOf(xv1));
                this.JTFFTotal2.setValue(Double.valueOf(xv2));
                this.JTFFTotal3.setValue(Double.valueOf(xv3));
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFInformeConsolidadoMov.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarDatosTablaE() {
        try {
            mCrearModeloDatoE();
            if (this.JCHContable.isSelected()) {
                this.xsql = "SELECT i_tiposmovimientos.Nbre, i_tiposmovimientos.CPuc_Credito, i_tiposmovimientos.CPuc_Debito, COUNT(DISTINCT(i_entradas.Id)) AS NOrden, COUNT(i_detalleentrada.IdEntrada) AS NItems, SUM(ROUND(((((i_detalleentrada.ValorUnitario*i_detalleentrada.Cantidad)*i_detalleentrada.Iva)/100)+(i_detalleentrada.ValorUnitario*i_detalleentrada.Cantidad)))) AS SValor FROM i_detalleentrada INNER JOIN i_entradas  ON (i_detalleentrada.IdEntrada = i_entradas.Id) INNER JOIN i_tiposmovimientos  ON (i_entradas.IdTipoMovimiento = i_tiposmovimientos.Id) WHERE (i_entradas.Estado =0 AND i_entradas.Id_Periodo ='" + this.xidperiodo[this.JCBPeriodo.getSelectedIndex()][0] + "' AND i_entradas.IdBodega IN(2,4)  AND i_entradas.Id_DocContable<>0 ) GROUP BY i_tiposmovimientos.Nbre ORDER BY i_tiposmovimientos.Nbre ASC ";
            } else {
                this.xsql = "SELECT i_tiposmovimientos.Nbre, i_tiposmovimientos.CPuc_Credito, i_tiposmovimientos.CPuc_Debito, COUNT(DISTINCT(i_entradas.Id)) AS NOrden, COUNT(i_detalleentrada.IdEntrada) AS NItems, SUM(ROUND(((((i_detalleentrada.ValorUnitario*i_detalleentrada.Cantidad)*i_detalleentrada.Iva)/100)+(i_detalleentrada.ValorUnitario*i_detalleentrada.Cantidad)))) AS SValor FROM i_detalleentrada INNER JOIN i_entradas  ON (i_detalleentrada.IdEntrada = i_entradas.Id) INNER JOIN i_tiposmovimientos  ON (i_entradas.IdTipoMovimiento = i_tiposmovimientos.Id) WHERE (i_entradas.Estado =0 AND i_entradas.Id_Periodo ='" + this.xidperiodo[this.JCBPeriodo.getSelectedIndex()][0] + "' AND i_entradas.IdBodega IN(2,4) ='" + this.xidbodega[this.JCBBodega.getSelectedIndex()] + "' ) GROUP BY i_tiposmovimientos.Nbre ORDER BY i_tiposmovimientos.Nbre ASC ";
            }
            ResultSet xrs = this.xct.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                double xv1 = 0.0d;
                double xv2 = 0.0d;
                double xv3 = 0.0d;
                while (xrs.next()) {
                    this.xmodelo1.addRow(this.xdatos);
                    this.xmodelo1.setValueAt(xrs.getString(1), n, 0);
                    this.xmodelo1.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo1.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelo1.setValueAt(Long.valueOf(xrs.getLong(4)), n, 3);
                    xv1 += xrs.getLong(4);
                    this.xmodelo1.setValueAt(Long.valueOf(xrs.getLong(5)), n, 4);
                    xv2 += xrs.getLong(5);
                    this.xmodelo1.setValueAt(Double.valueOf(xrs.getDouble(6)), n, 5);
                    xv3 += xrs.getDouble(6);
                    n++;
                }
                this.JTFFTotal4.setValue(Double.valueOf(xv1));
                this.JTFFTotal5.setValue(Double.valueOf(xv2));
                this.JTFFTotal6.setValue(Double.valueOf(xv3));
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFInformeConsolidadoMov.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarDatosTablaMP() {
        try {
            mCrearModeloDatoMP();
            this.xsql = "SELECT d_auditoria_formulamp.Id, cc_terceros.RazonSocialCompleta, d_auditoria_formulamp.NFactura, DATE_FORMAT(d_auditoria_formulamp.FechaA,'%d-%m-%Y') AS FA, COUNT(DISTINCT(h_ordenes.Id)) AS NOrdenes, COUNT(h_itemordenessum.Id_HOrdenes) AS NItems, SUM(DISTINCT(d_auditoria_formulamp.Subtotal+d_auditoria_formulamp.Iva+d_auditoria_formulamp.OtroValor)) AS Valor FROM h_ordenes INNER JOIN d_auditoria_formulamp  ON (h_ordenes.Id_AuditoriaMP = d_auditoria_formulamp.Id) INNER JOIN h_itemordenessum  ON (h_itemordenessum.Id_HOrdenes = h_ordenes.Id) INNER JOIN cc_terceros  ON (d_auditoria_formulamp.Id_Empresa = cc_terceros.Id) WHERE (d_auditoria_formulamp.FechaA >='" + this.xidperiodo[this.JCBPeriodo.getSelectedIndex()][1] + "' and d_auditoria_formulamp.FechaA <='" + this.xidperiodo[this.JCBPeriodo.getSelectedIndex()][2] + "') GROUP BY d_auditoria_formulamp.Id ORDER BY cc_terceros.RazonSocialCompleta ASC, d_auditoria_formulamp.NFactura ASC ";
            ResultSet xrs = this.xct.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                double xv1 = 0.0d;
                double xv2 = 0.0d;
                double xv3 = 0.0d;
                while (xrs.next()) {
                    this.xmodelo2.addRow(this.xdatos);
                    this.xmodelo2.setValueAt(xrs.getString(1), n, 0);
                    this.xmodelo2.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo2.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelo2.setValueAt(xrs.getString(4), n, 3);
                    this.xmodelo2.setValueAt(Long.valueOf(xrs.getLong(5)), n, 4);
                    xv1 += xrs.getLong(5);
                    this.xmodelo2.setValueAt(Long.valueOf(xrs.getLong(6)), n, 5);
                    xv2 += xrs.getLong(6);
                    this.xmodelo2.setValueAt(Double.valueOf(xrs.getDouble(7)), n, 6);
                    xv3 += xrs.getDouble(7);
                    n++;
                }
                this.JTFFTotal7.setValue(Double.valueOf(xv1));
                this.JTFFTotal8.setValue(Double.valueOf(xv2));
                this.JTFFTotal9.setValue(Double.valueOf(xv3));
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFInformeConsolidadoMov.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarDatosTablaR() {
        try {
            mCrearModeloDatoR();
            if (this.JCH_FiltroR.isSelected() && this.JCB_TipoEmpresa.getSelectedIndex() != -1) {
                this.xsql = "SELECT  `NTEmpresa` , `NUnidadNego` , `NDocumento` , `CSap` , `NUsuario` , SUM(`Valor`)\nFROM `cc_tmp_recobro` WHERE (`Id_TEmpresa` ='" + this.xId_TipoEmpresa[this.JCB_TipoEmpresa.getSelectedIndex()] + "') GROUP BY `Id_TEmpresa`, `Id_UnidadN`, `NDocumento` ORDER BY `NTEmpresa` ASC, `NUnidadNego` ASC, `NUsuario` ASC";
            } else {
                this.xsql = "SELECT  `NTEmpresa` , `NUnidadNego` , `NDocumento` , `CSap` , `NUsuario` , SUM(`Valor`)\nFROM `cc_tmp_recobro` GROUP BY `Id_TEmpresa`, `Id_UnidadN`, `NDocumento` ORDER BY `NTEmpresa` ASC, `NUnidadNego` ASC, `NUsuario` ASC";
            }
            ResultSet xrs = this.xct.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                double xv1 = 0.0d;
                while (xrs.next()) {
                    this.xmodelo3.addRow(this.xdatos);
                    this.xmodelo3.setValueAt(xrs.getString(1), n, 0);
                    this.xmodelo3.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo3.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelo3.setValueAt(Long.valueOf(xrs.getLong(4)), n, 3);
                    this.xmodelo3.setValueAt(xrs.getString(5), n, 4);
                    this.xmodelo3.setValueAt(Double.valueOf(xrs.getDouble(6)), n, 5);
                    xv1 += xrs.getDouble(6);
                    n++;
                }
                this.JTFFTotal10.setValue(Double.valueOf(xv1));
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFInformeConsolidadoMov.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mExportar() {
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            try {
                WritableWorkbook workbook = Workbook.createWorkbook(new File(this.JTFRuta.getText() + ".xls"));
                WritableSheet sheet = workbook.createSheet("Salidas", 0);
                for (int x = 0; x < this.JTDetalleS.getColumnCount(); x++) {
                    sheet.addCell(new Label(x, 0, this.JTDetalleS.getColumnName(x)));
                }
                for (int x2 = 0; x2 < this.JTDetalleS.getRowCount(); x2++) {
                    sheet.addCell(new Label(0, x2 + 1, this.xmodelo.getValueAt(x2, 0).toString()));
                    sheet.addCell(new Label(1, x2 + 1, this.xmodelo.getValueAt(x2, 1).toString()));
                    sheet.addCell(new Label(2, x2 + 1, this.xmodelo.getValueAt(x2, 2).toString()));
                    sheet.addCell(new Number(3, x2 + 1, Long.valueOf(this.xmodelo.getValueAt(x2, 3).toString()).longValue()));
                    sheet.addCell(new Number(4, x2 + 1, Long.valueOf(this.xmodelo.getValueAt(x2, 4).toString()).longValue()));
                    sheet.addCell(new Number(5, x2 + 1, Double.valueOf(this.xmodelo.getValueAt(x2, 5).toString()).doubleValue()));
                }
                WritableSheet sheet2 = workbook.createSheet("Entradas", 1);
                for (int x3 = 0; x3 < this.JTDetalleE.getColumnCount(); x3++) {
                    sheet2.addCell(new Label(x3, 0, this.JTDetalleE.getColumnName(x3)));
                }
                for (int x4 = 0; x4 < this.JTDetalleE.getRowCount(); x4++) {
                    sheet2.addCell(new Label(0, x4 + 1, this.xmodelo1.getValueAt(x4, 0).toString()));
                    sheet2.addCell(new Label(1, x4 + 1, this.xmodelo1.getValueAt(x4, 1).toString()));
                    sheet2.addCell(new Label(2, x4 + 1, this.xmodelo1.getValueAt(x4, 2).toString()));
                    sheet2.addCell(new Number(3, x4 + 1, Long.valueOf(this.xmodelo1.getValueAt(x4, 3).toString()).longValue()));
                    sheet2.addCell(new Number(4, x4 + 1, Long.valueOf(this.xmodelo1.getValueAt(x4, 4).toString()).longValue()));
                    sheet2.addCell(new Number(5, x4 + 1, Double.valueOf(this.xmodelo1.getValueAt(x4, 5).toString()).doubleValue()));
                }
                WritableSheet sheet3 = workbook.createSheet("Medicina Prepagada", 2);
                for (int x5 = 0; x5 < this.JTDetalleMP.getColumnCount(); x5++) {
                    sheet3.addCell(new Label(x5, 0, this.JTDetalleMP.getColumnName(x5)));
                }
                for (int x6 = 0; x6 < this.JTDetalleMP.getRowCount(); x6++) {
                    sheet3.addCell(new Label(0, x6 + 1, this.xmodelo2.getValueAt(x6, 0).toString()));
                    sheet3.addCell(new Label(1, x6 + 1, this.xmodelo2.getValueAt(x6, 1).toString()));
                    sheet3.addCell(new Label(2, x6 + 1, this.xmodelo2.getValueAt(x6, 2).toString()));
                    sheet3.addCell(new Label(3, x6 + 1, this.xmodelo2.getValueAt(x6, 3).toString()));
                    sheet3.addCell(new Number(4, x6 + 1, Long.valueOf(this.xmodelo2.getValueAt(x6, 4).toString()).longValue()));
                    sheet3.addCell(new Number(5, x6 + 1, Long.valueOf(this.xmodelo2.getValueAt(x6, 5).toString()).longValue()));
                    sheet3.addCell(new Number(6, x6 + 1, Double.valueOf(this.xmodelo2.getValueAt(x6, 6).toString()).doubleValue()));
                }
                workbook.write();
                workbook.close();
            } catch (WriteException e) {
                Logger.getLogger(JIFInformeConsolidadoMov.class.getName()).log(Level.SEVERE, (String) null, e);
            } catch (IOException ex) {
                Logger.getLogger(JIFInformeConsolidadoMov.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        }
    }
}
