package Presupuesto;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.genoma.plus.dao.general.InformacionIpsDAO;
import com.genoma.plus.dao.impl.general.InformacionIpsDAOImpl;
import com.genoma.plus.dao.impl.presupuesto.EjecucionPresupuestalDAOImpl;
import com.genoma.plus.dao.impl.presupuesto.PresupuestoDAOImpl;
import com.genoma.plus.dao.presupuesto.EjecucionPresupuestalDAO;
import com.genoma.plus.dao.presupuesto.PresupuestoDAO;
import com.genoma.plus.dto.presupuesto.EjecucionPresupuestalDTO;
import com.genoma.plus.dto.presupuesto.EjecucionPresupuestalNuevaDTO;
import com.genoma.plus.dto.presupuesto.InformeEjecucionPresupuestalDTO;
import com.genoma.plus.dto.presupuesto.PeriodoDTO;
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
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
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
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:Presupuesto/JIFConsultaRubros.class */
public class JIFConsultaRubros extends JInternalFrame {
    private EjecucionPresupuestalDAO ejecucionPresupuestalDAO;
    private InformacionIpsDAO informacionIpsDAO;
    private String sql;
    private String idPeriodo;
    private String[] xid;
    private int filaGridI;
    private int filaGridG;
    private Object[] datoI;
    private Object[] datoG;
    private DefaultTableModel modeloI;
    private DefaultTableModel modeloG;
    private DefaultTableModel modeloIngresoNuevo;
    private DefaultTableModel modeloGastoNuevo;
    private List<EjecucionPresupuestalDTO> listEjecucion;
    private List<EjecucionPresupuestalNuevaDTO> listaEjecucionNueva;
    private PresupuestoDAO presupuestoDAO;
    private List<PeriodoDTO> lstPeriodos;
    private List<EjecucionPresupuestalDTO> tableIngreso;
    private List<EjecucionPresupuestalDTO> tableGastos;
    private List<EjecucionPresupuestalNuevaDTO> listaIngreso;
    private List<EjecucionPresupuestalNuevaDTO> listaGastos;
    private JButton JBTExportar;
    private JButton JBTExportarNuevoFormato;
    private JButton JBTNConsultar;
    private JButton JBTOk;
    private JComboBox JCBPeriodo;
    private JComboBox<String> JCBPeriodoNuevoFormato;
    private JPanel JPPanelAccionNuevoFormato;
    private JPanel JPPanelAntiguoFormato;
    private JPanel JPPanelDatos;
    private JPanel JPPanelNuevoFormato;
    private JRadioButton JRBExportar;
    private JRadioButton JRBExportarNuevoFormato;
    private JRadioButton JRBSobreescribiNuevoFormato;
    private JRadioButton JRBSobreescribir;
    private JTable JTDetalleGastosNuevoFormato;
    private JTable JTDetalleIngresoNuevoFormato;
    private JTextField JTFRuta;
    private JTextField JTFRutaNuevoFormato;
    private JTabbedPane JTPEjecucionPresupuestal;
    private JTabbedPane JTPPanelNuevoFormato;
    private JTabbedPane JT_Datos;
    private JYearChooser JYCAno;
    private JYearChooser JYCAnooNuevoFormato;
    private ButtonGroup Tipo;
    private ButtonGroup buttonGroup1;
    private JTable gridG;
    private JTable gridI;
    private JPanel jPanel2;
    private JPanel jPanel5;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JScrollPane jScrollPane3;
    private JScrollPane jScrollPane4;
    private Metodos xmt = new Metodos();
    private int xUltimoN = 0;
    private int xAplicaTercero = 0;
    private ConsultasMySQL xct = new ConsultasMySQL();

    public JIFConsultaRubros() {
        initComponents();
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
        springStart();
        this.JBTOk.setVisible(false);
    }

    /* JADX WARN: Type inference failed for: r3v103, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v106, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v6, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v9, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.Tipo = new ButtonGroup();
        this.buttonGroup1 = new ButtonGroup();
        this.JTPEjecucionPresupuestal = new JTabbedPane();
        this.JPPanelAntiguoFormato = new JPanel();
        this.JTPPanelNuevoFormato = new JTabbedPane();
        this.jScrollPane1 = new JScrollPane();
        this.JTDetalleIngresoNuevoFormato = new JTable();
        this.jScrollPane4 = new JScrollPane();
        this.JTDetalleGastosNuevoFormato = new JTable();
        this.jPanel5 = new JPanel();
        this.JCBPeriodoNuevoFormato = new JComboBox<>();
        this.JYCAnooNuevoFormato = new JYearChooser();
        this.JBTNConsultar = new JButton();
        this.JTFRutaNuevoFormato = new JTextField();
        this.JPPanelAccionNuevoFormato = new JPanel();
        this.JRBExportarNuevoFormato = new JRadioButton();
        this.JRBSobreescribiNuevoFormato = new JRadioButton();
        this.JBTExportarNuevoFormato = new JButton();
        this.JPPanelNuevoFormato = new JPanel();
        this.JPPanelDatos = new JPanel();
        this.JCBPeriodo = new JComboBox();
        this.JYCAno = new JYearChooser();
        this.JBTOk = new JButton();
        this.JT_Datos = new JTabbedPane();
        this.jScrollPane2 = new JScrollPane();
        this.gridI = new JTable();
        this.jScrollPane3 = new JScrollPane();
        this.gridG = new JTable();
        this.JTFRuta = new JTextField();
        this.jPanel2 = new JPanel();
        this.JRBExportar = new JRadioButton();
        this.JRBSobreescribir = new JRadioButton();
        this.JBTExportar = new JButton();
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("EJECUCIÓN PRESUPUESTAL");
        setAutoscrolls(true);
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xConsultaRubros");
        this.JTPPanelNuevoFormato.setForeground(Color.red);
        this.JTPPanelNuevoFormato.setFont(new Font("Arial", 1, 14));
        this.JTDetalleIngresoNuevoFormato.setFont(new Font("Arial", 1, 12));
        this.JTDetalleIngresoNuevoFormato.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.jScrollPane1.setViewportView(this.JTDetalleIngresoNuevoFormato);
        this.JTPPanelNuevoFormato.addTab("INGRESOS", this.jScrollPane1);
        this.JTDetalleGastosNuevoFormato.setFont(new Font("Arial", 1, 12));
        this.JTDetalleGastosNuevoFormato.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.jScrollPane4.setViewportView(this.JTDetalleGastosNuevoFormato);
        this.JTPPanelNuevoFormato.addTab("GASTOS", this.jScrollPane4);
        this.jPanel5.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JCBPeriodoNuevoFormato.setBorder(BorderFactory.createTitledBorder((Border) null, "Periodo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JYCAnooNuevoFormato.setBorder(BorderFactory.createTitledBorder((Border) null, "Año", 0, 0, new Font("Arial", 1, 13), Color.blue));
        this.JYCAnooNuevoFormato.addPropertyChangeListener(new PropertyChangeListener() { // from class: Presupuesto.JIFConsultaRubros.1
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFConsultaRubros.this.JYCAnooNuevoFormatoPropertyChange(evt);
            }
        });
        this.JBTNConsultar.setFont(new Font("Arial", 1, 14));
        this.JBTNConsultar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTNConsultar.setText("CONSULTAR");
        this.JBTNConsultar.addActionListener(new ActionListener() { // from class: Presupuesto.JIFConsultaRubros.2
            public void actionPerformed(ActionEvent evt) {
                JIFConsultaRubros.this.JBTNConsultarActionPerformed(evt);
            }
        });
        GroupLayout jPanel5Layout = new GroupLayout(this.jPanel5);
        this.jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addGap(19, 19, 19).addComponent(this.JYCAnooNuevoFormato, -2, 104, -2).addGap(18, 18, 18).addComponent(this.JCBPeriodoNuevoFormato, -2, 345, -2).addGap(18, 18, 18).addComponent(this.JBTNConsultar, -2, 223, -2).addContainerGap(-1, 32767)));
        jPanel5Layout.setVerticalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addContainerGap().addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JBTNConsultar, -2, 50, -2).addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JCBPeriodoNuevoFormato, GroupLayout.Alignment.LEADING).addComponent(this.JYCAnooNuevoFormato, GroupLayout.Alignment.LEADING, -1, -1, 32767))).addContainerGap(-1, 32767)));
        this.JTFRutaNuevoFormato.setFont(new Font("Arial", 1, 12));
        this.JTFRutaNuevoFormato.setText("C:\\Genoma\\plantilla");
        this.JTFRutaNuevoFormato.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRutaNuevoFormato.addMouseListener(new MouseAdapter() { // from class: Presupuesto.JIFConsultaRubros.3
            public void mouseClicked(MouseEvent evt) {
                JIFConsultaRubros.this.JTFRutaNuevoFormatoMouseClicked(evt);
            }
        });
        this.JPPanelAccionNuevoFormato.setBorder(BorderFactory.createTitledBorder((Border) null, "ACCION", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.buttonGroup1.add(this.JRBExportarNuevoFormato);
        this.JRBExportarNuevoFormato.setFont(new Font("Arial", 1, 12));
        this.JRBExportarNuevoFormato.setText("Exportal Excel");
        this.JRBExportarNuevoFormato.addActionListener(new ActionListener() { // from class: Presupuesto.JIFConsultaRubros.4
            public void actionPerformed(ActionEvent evt) {
                JIFConsultaRubros.this.JRBExportarNuevoFormatoActionPerformed(evt);
            }
        });
        this.buttonGroup1.add(this.JRBSobreescribiNuevoFormato);
        this.JRBSobreescribiNuevoFormato.setFont(new Font("Arial", 1, 12));
        this.JRBSobreescribiNuevoFormato.setText("Sobrescribir Excel");
        this.JRBSobreescribiNuevoFormato.addActionListener(new ActionListener() { // from class: Presupuesto.JIFConsultaRubros.5
            public void actionPerformed(ActionEvent evt) {
                JIFConsultaRubros.this.JRBSobreescribiNuevoFormatoActionPerformed(evt);
            }
        });
        GroupLayout JPPanelAccionNuevoFormatoLayout = new GroupLayout(this.JPPanelAccionNuevoFormato);
        this.JPPanelAccionNuevoFormato.setLayout(JPPanelAccionNuevoFormatoLayout);
        JPPanelAccionNuevoFormatoLayout.setHorizontalGroup(JPPanelAccionNuevoFormatoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPPanelAccionNuevoFormatoLayout.createSequentialGroup().addContainerGap().addGroup(JPPanelAccionNuevoFormatoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JRBExportarNuevoFormato).addComponent(this.JRBSobreescribiNuevoFormato)).addGap(10, 10, 10)));
        JPPanelAccionNuevoFormatoLayout.setVerticalGroup(JPPanelAccionNuevoFormatoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPPanelAccionNuevoFormatoLayout.createSequentialGroup().addComponent(this.JRBExportarNuevoFormato).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBSobreescribiNuevoFormato, -1, -1, 32767)));
        this.JBTExportarNuevoFormato.setFont(new Font("Arial", 1, 12));
        this.JBTExportarNuevoFormato.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportarNuevoFormato.setText("Exportar");
        this.JBTExportarNuevoFormato.addActionListener(new ActionListener() { // from class: Presupuesto.JIFConsultaRubros.6
            public void actionPerformed(ActionEvent evt) {
                JIFConsultaRubros.this.JBTExportarNuevoFormatoActionPerformed(evt);
            }
        });
        GroupLayout JPPanelAntiguoFormatoLayout = new GroupLayout(this.JPPanelAntiguoFormato);
        this.JPPanelAntiguoFormato.setLayout(JPPanelAntiguoFormatoLayout);
        JPPanelAntiguoFormatoLayout.setHorizontalGroup(JPPanelAntiguoFormatoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPPanelAntiguoFormatoLayout.createSequentialGroup().addContainerGap().addGroup(JPPanelAntiguoFormatoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTPPanelNuevoFormato).addComponent(this.jPanel5, -1, -1, 32767).addGroup(JPPanelAntiguoFormatoLayout.createSequentialGroup().addComponent(this.JTFRutaNuevoFormato, -2, 1083, -2).addGap(18, 18, 18).addComponent(this.JPPanelAccionNuevoFormato, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBTExportarNuevoFormato, -2, 221, -2).addGap(0, 0, 32767))).addContainerGap()));
        JPPanelAntiguoFormatoLayout.setVerticalGroup(JPPanelAntiguoFormatoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPPanelAntiguoFormatoLayout.createSequentialGroup().addContainerGap().addComponent(this.jPanel5, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTPPanelNuevoFormato, -2, 521, -2).addGap(18, 18, 18).addGroup(JPPanelAntiguoFormatoLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JTFRutaNuevoFormato, -2, 68, -2).addComponent(this.JPPanelAccionNuevoFormato, -2, -1, -2).addComponent(this.JBTExportarNuevoFormato, -2, 68, -2)).addContainerGap(18, 32767)));
        this.JTPEjecucionPresupuestal.addTab("EJECUCION PRESUPUESTAL NUEVO FORMATO", this.JPPanelAntiguoFormato);
        this.JPPanelDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JCBPeriodo.setFont(new Font("Arial", 1, 12));
        this.JCBPeriodo.setBorder(BorderFactory.createTitledBorder((Border) null, "Periodo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBPeriodo.addItemListener(new ItemListener() { // from class: Presupuesto.JIFConsultaRubros.7
            public void itemStateChanged(ItemEvent evt) {
                JIFConsultaRubros.this.JCBPeriodoItemStateChanged(evt);
            }
        });
        this.JYCAno.setBorder(BorderFactory.createTitledBorder((Border) null, "Año", 0, 0, new Font("Arial", 1, 13), Color.blue));
        this.JYCAno.addPropertyChangeListener(new PropertyChangeListener() { // from class: Presupuesto.JIFConsultaRubros.8
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFConsultaRubros.this.JYCAnoPropertyChange(evt);
            }
        });
        this.JBTOk.setFont(new Font("Arial", 1, 13));
        this.JBTOk.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTOk.setText("Consultar");
        this.JBTOk.addActionListener(new ActionListener() { // from class: Presupuesto.JIFConsultaRubros.9
            public void actionPerformed(ActionEvent evt) {
                JIFConsultaRubros.this.JBTOkActionPerformed(evt);
            }
        });
        GroupLayout JPPanelDatosLayout = new GroupLayout(this.JPPanelDatos);
        this.JPPanelDatos.setLayout(JPPanelDatosLayout);
        JPPanelDatosLayout.setHorizontalGroup(JPPanelDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPPanelDatosLayout.createSequentialGroup().addGap(16, 16, 16).addComponent(this.JYCAno, -2, 95, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBPeriodo, -2, 335, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JBTOk, -2, 240, -2).addGap(28, 28, 28)));
        JPPanelDatosLayout.setVerticalGroup(JPPanelDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPPanelDatosLayout.createSequentialGroup().addGroup(JPPanelDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JYCAno, -2, 50, -2).addGroup(JPPanelDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JBTOk, -2, 50, -2).addComponent(this.JCBPeriodo, GroupLayout.Alignment.TRAILING, -2, 50, -2))).addGap(0, 15, 32767)));
        this.JT_Datos.setForeground(Color.red);
        this.JT_Datos.setFont(new Font("Arial", 1, 14));
        this.gridI.setFont(new Font("Arial", 1, 12));
        this.gridI.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.gridI.setSelectionBackground(Color.white);
        this.gridI.setSelectionForeground(Color.red);
        this.jScrollPane2.setViewportView(this.gridI);
        this.JT_Datos.addTab("INGRESOS", this.jScrollPane2);
        this.gridG.setFont(new Font("Arial", 1, 12));
        this.gridG.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.gridG.setSelectionBackground(Color.white);
        this.gridG.setSelectionForeground(Color.red);
        this.jScrollPane3.setViewportView(this.gridG);
        this.JT_Datos.addTab("GASTOS", this.jScrollPane3);
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: Presupuesto.JIFConsultaRubros.10
            public void mouseClicked(MouseEvent evt) {
                JIFConsultaRubros.this.JTFRutaMouseClicked(evt);
            }
        });
        this.jPanel2.setBorder(BorderFactory.createTitledBorder((Border) null, "ACCION", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.buttonGroup1.add(this.JRBExportar);
        this.JRBExportar.setFont(new Font("Arial", 1, 12));
        this.JRBExportar.setText("Exportal Excel");
        this.JRBExportar.addActionListener(new ActionListener() { // from class: Presupuesto.JIFConsultaRubros.11
            public void actionPerformed(ActionEvent evt) {
                JIFConsultaRubros.this.JRBExportarActionPerformed(evt);
            }
        });
        this.buttonGroup1.add(this.JRBSobreescribir);
        this.JRBSobreescribir.setFont(new Font("Arial", 1, 12));
        this.JRBSobreescribir.setText("Sobrescribir Excel");
        this.JRBSobreescribir.addActionListener(new ActionListener() { // from class: Presupuesto.JIFConsultaRubros.12
            public void actionPerformed(ActionEvent evt) {
                JIFConsultaRubros.this.JRBSobreescribirActionPerformed(evt);
            }
        });
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JRBExportar).addComponent(this.JRBSobreescribir)).addGap(10, 10, 10)));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.JRBExportar).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBSobreescribir, -1, -1, 32767)));
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: Presupuesto.JIFConsultaRubros.13
            public void actionPerformed(ActionEvent evt) {
                JIFConsultaRubros.this.JBTExportarActionPerformed(evt);
            }
        });
        GroupLayout JPPanelNuevoFormatoLayout = new GroupLayout(this.JPPanelNuevoFormato);
        this.JPPanelNuevoFormato.setLayout(JPPanelNuevoFormatoLayout);
        JPPanelNuevoFormatoLayout.setHorizontalGroup(JPPanelNuevoFormatoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPPanelNuevoFormatoLayout.createSequentialGroup().addContainerGap().addGroup(JPPanelNuevoFormatoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JT_Datos).addComponent(this.JPPanelDatos, -1, -1, 32767).addGroup(JPPanelNuevoFormatoLayout.createSequentialGroup().addComponent(this.JTFRuta, -2, 1083, -2).addGap(18, 18, 18).addComponent(this.jPanel2, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBTExportar, -2, 221, -2).addGap(0, 0, 32767))).addContainerGap()));
        JPPanelNuevoFormatoLayout.setVerticalGroup(JPPanelNuevoFormatoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPPanelNuevoFormatoLayout.createSequentialGroup().addContainerGap().addComponent(this.JPPanelDatos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JT_Datos, -1, 521, 32767).addGap(22, 22, 22).addGroup(JPPanelNuevoFormatoLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jPanel2, -2, -1, -2).addComponent(this.JTFRuta, -2, 68, -2).addComponent(this.JBTExportar, -2, 68, -2)).addGap(17, 17, 17)));
        this.JT_Datos.getAccessibleContext().setAccessibleName("Ingresos");
        this.JTPEjecucionPresupuestal.addTab("EJECUCION PRESUPUESTAL", this.JPPanelNuevoFormato);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTPEjecucionPresupuestal).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTPEjecucionPresupuestal).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JFileChooser xfilec = new JFileChooser(this.JTFRuta.getText());
            if (this.JRBSobreescribir.isSelected()) {
                xfilec.setFileSelectionMode(2);
            } else {
                xfilec.setFileSelectionMode(1);
            }
            int xv = xfilec.showOpenDialog(this);
            if (xv == 0) {
                File xfile = xfilec.getSelectedFile();
                this.JTFRuta.setText(xfile.getAbsolutePath() + this.xmt.getBarra());
                this.JTFRuta.requestFocus();
            }
        }
    }

    private void sobreEscribirExcel(JTable xtabla, JTable xtablaGasto, String nombreMes) throws InvalidFormatException, IOException {
        try {
            String url = this.JTFRuta.getText();
            url.replace(".xlsx\\", ".xlsx");
            System.out.println("url final " + url);
            FileInputStream inputStream = new FileInputStream(new File(url));
            Workbook workbook = WorkbookFactory.create(inputStream);
            String idRubro = "";
            String idRubroGasto = "";
            System.out.println("la hoja a trabajar es " + workbook.getSheetIndex(nombreMes));
            Sheet sheet = workbook.getSheet(nombreMes.toString());
            Iterator ite = sheet.rowIterator();
            while (ite.hasNext()) {
                Row row = (Row) ite.next();
                Iterator<Cell> cite = row.cellIterator();
                while (cite.hasNext()) {
                    Cell contentCell = cite.next();
                    if (contentCell.getCellType() == 1 && contentCell.getColumnIndex() == 0) {
                        idRubro = String.valueOf(contentCell.getStringCellValue());
                    } else if (contentCell.getCellType() == 0 && contentCell.getColumnIndex() == 0) {
                        idRubro = String.valueOf(contentCell.getNumericCellValue()).replace(".0", "");
                    } else if (contentCell.getCellType() == 2 && contentCell.getColumnIndex() == 0) {
                        switch (contentCell.getCachedFormulaResultType()) {
                            case 0:
                                idRubro = String.valueOf(contentCell.getNumericCellValue()).replace(".0", "");
                                System.out.println("casteando formula como numerico... idrurbo " + idRubro);
                                break;
                            case 1:
                                idRubro = String.valueOf(contentCell.getStringCellValue());
                                System.out.println("casteando formula como string... idrurbo " + idRubro);
                                break;
                        }
                    }
                    if (contentCell.getCellType() == 1 && contentCell.getColumnIndex() == 18) {
                        idRubroGasto = String.valueOf(contentCell.getStringCellValue());
                    } else if (contentCell.getCellType() == 0 && contentCell.getColumnIndex() == 18) {
                        idRubroGasto = String.valueOf(contentCell.getNumericCellValue()).replace(".0", "");
                    } else if (contentCell.getCellType() == 2 && contentCell.getColumnIndex() == 18) {
                        switch (contentCell.getCachedFormulaResultType()) {
                            case 0:
                                idRubroGasto = String.valueOf(contentCell.getNumericCellValue()).replace(".0", "");
                                System.out.println("casteando formula como numerico... idrurboGasto " + idRubroGasto);
                                break;
                            case 1:
                                idRubroGasto = String.valueOf(contentCell.getStringCellValue());
                                System.out.println("casteando formula como string... idrurboGasto " + idRubroGasto);
                                break;
                        }
                    }
                    int i = 0;
                    while (true) {
                        if (i < xtabla.getRowCount()) {
                            if (!xtabla.getValueAt(i, 0).toString().trim().equals(idRubro.trim()) || !xtabla.getValueAt(i, 14).toString().equals("1")) {
                                i++;
                            } else {
                                System.out.println(idRubro + " Entro a iterador de ingreso, i = " + i);
                                if (nombreMes.equalsIgnoreCase("ENERO")) {
                                    row.getCell(2).setCellValue(Double.valueOf(xtabla.getValueAt(i, 2).toString()).doubleValue());
                                    row.getCell(6).setCellValue(Double.valueOf(xtabla.getValueAt(i, 6).toString()).doubleValue());
                                    row.getCell(9).setCellValue(Double.valueOf(xtabla.getValueAt(i, 9).toString()).doubleValue());
                                }
                                row.getCell(7).setCellValue(Double.valueOf(xtabla.getValueAt(i, 7).toString()).doubleValue());
                                row.getCell(10).setCellValue(Double.valueOf(xtabla.getValueAt(i, 10).toString()).doubleValue());
                                row.getCell(16).setCellValue(Double.valueOf(xtabla.getValueAt(i, 3).toString()).doubleValue() - Double.valueOf(xtabla.getValueAt(i, 4).toString()).doubleValue());
                                row.getCell(15).setCellValue(Double.valueOf(xtabla.getValueAt(i, 16).toString()).doubleValue() - Double.valueOf(xtabla.getValueAt(i, 15).toString()).doubleValue());
                                idRubro = "";
                            }
                        }
                    }
                    int i2 = 0;
                    while (true) {
                        if (i2 >= xtablaGasto.getRowCount()) {
                            break;
                        }
                        if (!xtablaGasto.getValueAt(i2, 0).toString().trim().equals(idRubroGasto.trim()) || !xtablaGasto.getValueAt(i2, 28).toString().equals("1")) {
                            i2++;
                        } else {
                            System.out.println(idRubroGasto + " Entro a iterador de gasto, i = " + i2);
                            if (nombreMes.equalsIgnoreCase("ENERO")) {
                                row.getCell(20).setCellValue(Double.valueOf(xtablaGasto.getValueAt(i2, 2).toString()).doubleValue());
                                row.getCell(24).setCellValue(Double.valueOf(xtablaGasto.getValueAt(i2, 12).toString()).doubleValue());
                                row.getCell(27).setCellValue(Double.valueOf(xtablaGasto.getValueAt(i2, 16).toString()).doubleValue());
                                row.getCell(30).setCellValue(Double.valueOf(xtablaGasto.getValueAt(i2, 20).toString()).doubleValue());
                            }
                            row.getCell(25).setCellValue(Double.valueOf(xtablaGasto.getValueAt(i2, 13).toString()).doubleValue());
                            row.getCell(28).setCellValue(Double.valueOf(xtablaGasto.getValueAt(i2, 17).toString()).doubleValue());
                            row.getCell(31).setCellValue(Double.valueOf(xtablaGasto.getValueAt(i2, 21).toString()).doubleValue());
                            row.getCell(37).setCellValue(Double.valueOf(xtablaGasto.getValueAt(i2, 6).toString()).doubleValue() - Double.valueOf(xtablaGasto.getValueAt(i2, 5).toString()).doubleValue());
                            row.getCell(38).setCellValue(Double.valueOf(xtablaGasto.getValueAt(i2, 3).toString()).doubleValue() - Double.valueOf(xtablaGasto.getValueAt(i2, 4).toString()).doubleValue());
                            idRubroGasto = "";
                        }
                    }
                }
            }
            workbook.setForceFormulaRecalculation(true);
            inputStream.close();
            FileOutputStream fileOut = new FileOutputStream(url);
            workbook.write(fileOut);
            fileOut.flush();
            fileOut.close();
            this.xmt.mostrarPdf(url);
            System.out.println("Exportacion exitosa.");
        } catch (InvalidFormatException e) {
            Logger.getLogger(JIFConsultaRubros.class.getName()).log(Level.SEVERE, (String) null, e);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(JIFConsultaRubros.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.poi.openxml4j.exceptions.InvalidFormatException */
    public void JBTExportarActionPerformed(ActionEvent evt) {
        if (!this.JTFRuta.getText().isEmpty()) {
            if (this.JRBSobreescribir.isSelected()) {
                try {
                    String mesPeriodo = this.lstPeriodos.get(this.JCBPeriodo.getSelectedIndex()).getFechaFin();
                    int mes = Integer.parseInt(StringUtils.substring(mesPeriodo, 5, 7));
                    System.out.println("el mes es: " + mes);
                    System.out.println("el mes periodo es" + mesPeriodo);
                    if (mes > 0 && mes <= 12) {
                        String nombreMes = "";
                        switch (mes) {
                            case 1:
                                nombreMes = "ENERO";
                                break;
                            case 2:
                                nombreMes = "FEBRERO";
                                break;
                            case 3:
                                nombreMes = "MARZO";
                                break;
                            case 4:
                                nombreMes = "ABRIL";
                                break;
                            case 5:
                                nombreMes = "MAYO";
                                break;
                            case 6:
                                nombreMes = "JUNIO";
                                break;
                            case 7:
                                nombreMes = "JULIO";
                                break;
                            case 8:
                                nombreMes = "AGOSTO";
                                break;
                            case 9:
                                nombreMes = "SEPTIEMBRE";
                                break;
                            case 10:
                                nombreMes = "OCTUBRE";
                                break;
                            case 11:
                                nombreMes = "NOVIEMBRE";
                                break;
                            case 12:
                                nombreMes = "DICIEMBRE";
                                break;
                        }
                        if (!nombreMes.equals("")) {
                            if (this.JTFRuta.getText().contains("xlsx")) {
                                int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar datos en el mes de " + nombreMes, "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                                if (n == 0) {
                                    sobreEscribirExcel(this.gridI, this.gridG, nombreMes);
                                }
                            } else {
                                JOptionPane.showMessageDialog(this, "formato de archivo invalido solo aplica Excel 2007 (XLSX) ", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                            }
                        }
                    }
                    return;
                } catch (IOException ex) {
                    Logger.getLogger(JIFConsultaRubros.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                    return;
                } catch (InvalidFormatException e) {
                    Logger.getLogger(JIFConsultaRubros.class.getName()).log(Level.SEVERE, (String) null, e);
                    return;
                }
            }
            if (this.JT_Datos.getSelectedIndex() == 0) {
                if (this.gridI.getRowCount() > -1) {
                    int n2 = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    if (n2 == 0) {
                        String xtitulo = "EJECUCIÓN PRESUPUESTAL DE INGRESOS AÑO " + this.JYCAno.getValue() + " PERIODO " + this.JCBPeriodo.getSelectedItem();
                        this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.gridI, this.xmt.mTraerUrlBD(this.JTFRuta.getText()), xtitulo);
                        return;
                    }
                    return;
                }
                return;
            }
            int n3 = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n3 == 0) {
                String xtitulo2 = "EJECUCIÓN PRESUPUESTAL DE GASTOS AÑO " + this.JYCAno.getValue() + " PERIODO " + this.JCBPeriodo.getSelectedItem();
                this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.gridG, this.xmt.mTraerUrlBD(this.JTFRuta.getText()), xtitulo2);
                return;
            }
            return;
        }
        JOptionPane.showMessageDialog(this, "La Ubicacion del archivo no puede estar vacia", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JTFRuta.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBPeriodoItemStateChanged(ItemEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JYCAnoPropertyChange(PropertyChangeEvent evt) {
        mCargarCombo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTOkActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBExportarActionPerformed(ActionEvent evt) {
        this.JBTExportar.setText("Exportar");
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBSobreescribirActionPerformed(ActionEvent evt) {
        this.JBTExportar.setText("Sobrescribir");
        this.JTFRuta.setText("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JYCAnooNuevoFormatoPropertyChange(PropertyChangeEvent evt) {
        cargarComboNuevoFormato();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaNuevoFormatoMouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBExportarNuevoFormatoActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBSobreescribiNuevoFormatoActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.poi.openxml4j.exceptions.InvalidFormatException */
    public void JBTExportarNuevoFormatoActionPerformed(ActionEvent evt) {
        if (!this.JTFRuta.getText().isEmpty()) {
            if (this.JRBSobreescribir.isSelected()) {
                try {
                    String mesPeriodo = this.lstPeriodos.get(this.JCBPeriodo.getSelectedIndex()).getFechaFin();
                    int mes = Integer.parseInt(StringUtils.substring(mesPeriodo, 5, 7));
                    System.out.println("el mes es: " + mes);
                    System.out.println("el mes periodo es" + mesPeriodo);
                    if (mes > 0 && mes <= 12) {
                        String nombreMes = "";
                        switch (mes) {
                            case 1:
                                nombreMes = "ENERO";
                                break;
                            case 2:
                                nombreMes = "FEBRERO";
                                break;
                            case 3:
                                nombreMes = "MARZO";
                                break;
                            case 4:
                                nombreMes = "ABRIL";
                                break;
                            case 5:
                                nombreMes = "MAYO";
                                break;
                            case 6:
                                nombreMes = "JUNIO";
                                break;
                            case 7:
                                nombreMes = "JULIO";
                                break;
                            case 8:
                                nombreMes = "AGOSTO";
                                break;
                            case 9:
                                nombreMes = "SEPTIEMBRE";
                                break;
                            case 10:
                                nombreMes = "OCTUBRE";
                                break;
                            case 11:
                                nombreMes = "NOVIEMBRE";
                                break;
                            case 12:
                                nombreMes = "DICIEMBRE";
                                break;
                        }
                        if (!nombreMes.equals("")) {
                            if (this.JTFRuta.getText().contains("xlsx")) {
                                int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar datos en el mes de " + nombreMes, "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                                if (n == 0) {
                                    sobreEscribirExcel(this.gridI, this.gridG, nombreMes);
                                }
                            } else {
                                JOptionPane.showMessageDialog(this, "formato de archivo invalido solo aplica Excel 2007 (XLSX) ", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                            }
                        }
                    }
                    return;
                } catch (IOException ex) {
                    Logger.getLogger(JIFConsultaRubros.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                    return;
                } catch (InvalidFormatException e) {
                    Logger.getLogger(JIFConsultaRubros.class.getName()).log(Level.SEVERE, (String) null, e);
                    return;
                }
            }
            if (this.JT_Datos.getSelectedIndex() == 0) {
                if (this.gridI.getRowCount() > -1) {
                    int n2 = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    if (n2 == 0) {
                        String xtitulo = "EJECUCIÓN PRESUPUESTAL DE INGRESOS AÑO " + this.JYCAno.getValue() + " PERIODO " + this.JCBPeriodo.getSelectedItem();
                        this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.gridI, this.xmt.mTraerUrlBD(this.JTFRuta.getText()), xtitulo);
                        return;
                    }
                    return;
                }
                return;
            }
            int n3 = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n3 == 0) {
                String xtitulo2 = "EJECUCIÓN PRESUPUESTAL DE GASTOS AÑO " + this.JYCAno.getValue() + " PERIODO " + this.JCBPeriodo.getSelectedItem();
                this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.gridG, this.xmt.mTraerUrlBD(this.JTFRuta.getText()), xtitulo2);
                return;
            }
            return;
        }
        JOptionPane.showMessageDialog(this, "La Ubicacion del archivo no puede estar vacia", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JTFRuta.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTNConsultarActionPerformed(ActionEvent evt) {
        buscarNuevoFormato();
    }

    private void springStart() {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"});
        this.ejecucionPresupuestalDAO = (EjecucionPresupuestalDAOImpl) classPathXmlApplicationContext.getBean("ejecucionPresupuestalDAOImpl");
        this.informacionIpsDAO = (InformacionIpsDAOImpl) classPathXmlApplicationContext.getBean("informacionIpsDAOImpl");
        this.presupuestoDAO = (PresupuestoDAOImpl) classPathXmlApplicationContext.getBean("presupuestoDAOImpl");
    }

    private void mCargarCombo() {
        this.JCBPeriodo.removeAllItems();
        this.lstPeriodos = this.presupuestoDAO.listPeriodoPPT(String.valueOf(this.JYCAno.getValue()));
        if (!this.lstPeriodos.isEmpty()) {
            this.xid = new String[this.lstPeriodos.size()];
            for (int i = 0; i < this.lstPeriodos.size(); i++) {
                this.xid[i] = String.valueOf(this.lstPeriodos.get(i).getId());
                this.JCBPeriodo.addItem(this.lstPeriodos.get(i).getNombre());
            }
        }
    }

    public void buscar() {
        int xControl = 0;
        int i = 1;
        while (true) {
            if (i >= 20) {
                break;
            }
            if (this.ejecucionPresupuestalDAO.existeTable(String.valueOf(i))) {
                i++;
            } else {
                xControl = i;
                break;
            }
        }
        this.ejecucionPresupuestalDAO.executeQueryPTO(String.valueOf(xControl), String.valueOf(this.lstPeriodos.get(this.JCBPeriodo.getSelectedIndex()).getId()), String.valueOf(this.lstPeriodos.get(this.JCBPeriodo.getSelectedIndex()).getIdEncabezado()));
        for (int i2 = 1; i2 <= 50; i2++) {
            this.ejecucionPresupuestalDAO.updateValoresPadres(String.valueOf(xControl));
        }
        this.listEjecucion = this.ejecucionPresupuestalDAO.getEjecucionPresupuestal(String.valueOf(xControl));
        this.ejecucionPresupuestalDAO.deleteTemporalTable(String.valueOf(xControl));
        llenarTablaIngreso();
        llenarTablaGasto();
    }

    private void llenarTablaIngreso() {
        mCrearGridIngresos();
        System.out.println("Presupuesto.JIFConsultaRubros.llenarTablaIngreso()-->" + this.listEjecucion.size());
        this.tableIngreso = (List) this.listEjecucion.stream().filter(p -> {
            return p.getTipoRubro().equals("I");
        }).collect(Collectors.toList());
        for (int i = 0; i < this.tableIngreso.size(); i++) {
            this.modeloI.addRow(this.datoI);
            this.modeloI.setValueAt(this.tableIngreso.get(i).getCodigo(), i, 0);
            this.modeloI.setValueAt(this.tableIngreso.get(i).getNombreRubro(), i, 1);
            this.modeloI.setValueAt(this.tableIngreso.get(i).getValorPresupuestoInicial(), i, 2);
            this.modeloI.setValueAt(this.tableIngreso.get(i).getValorAdicionPresupuesto(), i, 3);
            this.modeloI.setValueAt(this.tableIngreso.get(i).getValorReduccionPresupuesto(), i, 4);
            this.modeloI.setValueAt(this.tableIngreso.get(i).getValorPresupuestoDefinitivo(), i, 5);
            this.modeloI.setValueAt(this.tableIngreso.get(i).getValorReconocimientoAnterior(), i, 6);
            this.modeloI.setValueAt(this.tableIngreso.get(i).getValorReconocimientoActual(), i, 7);
            this.modeloI.setValueAt(this.tableIngreso.get(i).getValorReconocimientoTotal(), i, 8);
            this.modeloI.setValueAt(this.tableIngreso.get(i).getValorRecaudoAnterior(), i, 9);
            this.modeloI.setValueAt(this.tableIngreso.get(i).getValorRecaudoActual(), i, 10);
            this.modeloI.setValueAt(this.tableIngreso.get(i).getValorRecaudoTotal(), i, 11);
            this.modeloI.setValueAt(this.tableIngreso.get(i).getValorSaldoporEjecutar(), i, 12);
            this.modeloI.setValueAt(this.tableIngreso.get(i).getValorSaldoporRecaudar(), i, 13);
            this.modeloI.setValueAt(this.tableIngreso.get(i).getUltimoNivel(), i, 14);
            this.modeloI.setValueAt(this.tableIngreso.get(i).getValorTrasladosDebitos(), i, 15);
            this.modeloI.setValueAt(this.tableIngreso.get(i).getValorTrasladosCreditos(), i, 16);
        }
    }

    private void llenarTablaGasto() {
        mCrearGridGastos();
        double G1 = 0.0d;
        double G2 = 0.0d;
        double G3 = 0.0d;
        double G4 = 0.0d;
        double G5 = 0.0d;
        double G6 = 0.0d;
        double G7 = 0.0d;
        double G8 = 0.0d;
        double G9 = 0.0d;
        double G10 = 0.0d;
        double G11 = 0.0d;
        double G12 = 0.0d;
        double G13 = 0.0d;
        double G14 = 0.0d;
        double G15 = 0.0d;
        double G16 = 0.0d;
        double G17 = 0.0d;
        double G18 = 0.0d;
        double G19 = 0.0d;
        double G20 = 0.0d;
        double G21 = 0.0d;
        double G22 = 0.0d;
        double G23 = 0.0d;
        double G24 = 0.0d;
        double G25 = 0.0d;
        double G26 = 0.0d;
        this.tableGastos = (List) this.listEjecucion.stream().filter(p -> {
            return p.getTipoRubro().equals("G");
        }).collect(Collectors.toList());
        for (int i = 0; i < this.tableGastos.size(); i++) {
            this.modeloG.addRow(this.datoI);
            this.modeloG.setValueAt(this.tableGastos.get(i).getCodigo(), i, 0);
            this.modeloG.setValueAt(this.tableGastos.get(i).getNombreRubro(), i, 1);
            this.modeloG.setValueAt(this.tableGastos.get(i).getValorPresupuestoInicial(), i, 2);
            this.modeloG.setValueAt(this.tableGastos.get(i).getValorAdicionPresupuesto(), i, 3);
            this.modeloG.setValueAt(this.tableGastos.get(i).getValorReduccionPresupuesto(), i, 4);
            this.modeloG.setValueAt(this.tableGastos.get(i).getValorTrasladosDebitos(), i, 5);
            this.modeloG.setValueAt(this.tableGastos.get(i).getValorTrasladosCreditos(), i, 6);
            this.modeloG.setValueAt(this.tableGastos.get(i).getValorPresupuestoDefinitivo(), i, 7);
            this.modeloG.setValueAt(this.tableGastos.get(i).getValorCertificadoAnterior(), i, 8);
            this.modeloG.setValueAt(this.tableGastos.get(i).getValorCertificadoActual(), i, 9);
            this.modeloG.setValueAt(this.tableGastos.get(i).getValorTotalReintegroCertificados(), i, 10);
            this.modeloG.setValueAt(this.tableGastos.get(i).getValorTotalCertificados(), i, 11);
            this.modeloG.setValueAt(this.tableGastos.get(i).getValorCompromisoAnterior(), i, 12);
            this.modeloG.setValueAt(this.tableGastos.get(i).getValorCompromisoActual(), i, 13);
            this.modeloG.setValueAt(this.tableGastos.get(i).getValorTotalReintegroCompromiso(), i, 14);
            this.modeloG.setValueAt(this.tableGastos.get(i).getValorTotalCompromiso(), i, 15);
            this.modeloG.setValueAt(this.tableGastos.get(i).getValorObligacionAnterior(), i, 16);
            this.modeloG.setValueAt(this.tableGastos.get(i).getValorObligacionActual(), i, 17);
            this.modeloG.setValueAt(this.tableGastos.get(i).getValorTotalReintegroObligacion(), i, 18);
            this.modeloG.setValueAt(this.tableGastos.get(i).getValorTotalObligaciones(), i, 19);
            this.modeloG.setValueAt(this.tableGastos.get(i).getValorPagosAnterior(), i, 20);
            this.modeloG.setValueAt(this.tableGastos.get(i).getValorPagosActual(), i, 21);
            this.modeloG.setValueAt(this.tableGastos.get(i).getValorTotalPagos(), i, 22);
            this.modeloG.setValueAt(this.tableGastos.get(i).getValorSaldoDisponible(), i, 23);
            this.modeloG.setValueAt(this.tableGastos.get(i).getValorSinComprometer(), i, 24);
            this.modeloG.setValueAt(this.tableGastos.get(i).getValorCompromisosporPagar(), i, 25);
            this.modeloG.setValueAt(this.tableGastos.get(i).getValorCuentasporPagar(), i, 26);
            this.modeloG.setValueAt(this.tableGastos.get(i).getValorCertificadosinComprometer(), i, 27);
            this.modeloG.setValueAt(this.tableGastos.get(i).getUltimoNivel(), i, 28);
            if (Principal.informacionIps.getNombreIps().equals("ESE HOSPITAL LOCAL DE PUERTO LIBERTADOR") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL LOCAL DE MONTELIBANO") || Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN JORGE DE AYAPEL")) {
                if (this.tableGastos.get(i).getIdPadre().equals("-1")) {
                    G1 += this.tableGastos.get(i).getValorPresupuestoInicial().doubleValue();
                    G2 += this.tableGastos.get(i).getValorAdicionPresupuesto().doubleValue();
                    G3 += this.tableGastos.get(i).getValorReduccionPresupuesto().doubleValue();
                    G4 += this.tableGastos.get(i).getValorTrasladosDebitos().doubleValue();
                    G5 += this.tableGastos.get(i).getValorTrasladosCreditos().doubleValue();
                    G6 += this.tableGastos.get(i).getValorPresupuestoDefinitivo().doubleValue();
                    G7 += this.tableGastos.get(i).getValorCertificadoAnterior().doubleValue();
                    G8 += this.tableGastos.get(i).getValorCertificadoActual().doubleValue();
                    G9 += this.tableGastos.get(i).getValorTotalReintegroCertificados().doubleValue();
                    G10 += this.tableGastos.get(i).getValorTotalCertificados().doubleValue();
                    G11 += this.tableGastos.get(i).getValorCompromisoAnterior().doubleValue();
                    G12 += this.tableGastos.get(i).getValorCompromisoActual().doubleValue();
                    G13 += this.tableGastos.get(i).getValorTotalReintegroCompromiso().doubleValue();
                    G14 += this.tableGastos.get(i).getValorTotalCompromiso().doubleValue();
                    G15 += this.tableGastos.get(i).getValorObligacionAnterior().doubleValue();
                    G16 += this.tableGastos.get(i).getValorObligacionActual().doubleValue();
                    G17 += this.tableGastos.get(i).getValorTotalReintegroObligacion().doubleValue();
                    G18 += this.tableGastos.get(i).getValorTotalObligaciones().doubleValue();
                    G19 += this.tableGastos.get(i).getValorPagosAnterior().doubleValue();
                    G20 += this.tableGastos.get(i).getValorPagosActual().doubleValue();
                    G21 += this.tableGastos.get(i).getValorTotalPagos().doubleValue();
                    G22 += this.tableGastos.get(i).getValorSaldoDisponible().doubleValue();
                    G23 += this.tableGastos.get(i).getValorSinComprometer().doubleValue();
                    G24 += this.tableGastos.get(i).getValorCompromisosporPagar().doubleValue();
                    G25 += this.tableGastos.get(i).getValorCuentasporPagar().doubleValue();
                    G26 += this.tableGastos.get(i).getValorCertificadosinComprometer().doubleValue();
                }
            } else if (this.tableGastos.get(i).getCodigo().length() == 1) {
                G1 += this.tableGastos.get(i).getValorPresupuestoInicial().doubleValue();
                G2 += this.tableGastos.get(i).getValorAdicionPresupuesto().doubleValue();
                G3 += this.tableGastos.get(i).getValorReduccionPresupuesto().doubleValue();
                G4 += this.tableGastos.get(i).getValorTrasladosDebitos().doubleValue();
                G5 += this.tableGastos.get(i).getValorTrasladosCreditos().doubleValue();
                G6 += this.tableGastos.get(i).getValorPresupuestoDefinitivo().doubleValue();
                G7 += this.tableGastos.get(i).getValorCertificadoAnterior().doubleValue();
                G8 += this.tableGastos.get(i).getValorCertificadoActual().doubleValue();
                G9 += this.tableGastos.get(i).getValorTotalReintegroCertificados().doubleValue();
                G10 += this.tableGastos.get(i).getValorTotalCertificados().doubleValue();
                G11 += this.tableGastos.get(i).getValorCompromisoAnterior().doubleValue();
                G12 += this.tableGastos.get(i).getValorCompromisoActual().doubleValue();
                G13 += this.tableGastos.get(i).getValorTotalReintegroCompromiso().doubleValue();
                G14 += this.tableGastos.get(i).getValorTotalCompromiso().doubleValue();
                G15 += this.tableGastos.get(i).getValorObligacionAnterior().doubleValue();
                G16 += this.tableGastos.get(i).getValorObligacionActual().doubleValue();
                G17 += this.tableGastos.get(i).getValorTotalReintegroObligacion().doubleValue();
                G18 += this.tableGastos.get(i).getValorTotalObligaciones().doubleValue();
                G19 += this.tableGastos.get(i).getValorPagosAnterior().doubleValue();
                G20 += this.tableGastos.get(i).getValorPagosActual().doubleValue();
                G21 += this.tableGastos.get(i).getValorTotalPagos().doubleValue();
                G22 += this.tableGastos.get(i).getValorSaldoDisponible().doubleValue();
                G23 += this.tableGastos.get(i).getValorSinComprometer().doubleValue();
                G24 += this.tableGastos.get(i).getValorCompromisosporPagar().doubleValue();
                G25 += this.tableGastos.get(i).getValorCuentasporPagar().doubleValue();
                G26 += this.tableGastos.get(i).getValorCertificadosinComprometer().doubleValue();
            }
        }
        this.modeloG.addRow(this.datoG);
        this.modeloG.setValueAt("TOTAL", this.tableGastos.size(), 0);
        this.modeloG.setValueAt("", this.tableGastos.size(), 1);
        this.modeloG.setValueAt(Double.valueOf(G1), this.tableGastos.size(), 2);
        this.modeloG.setValueAt(Double.valueOf(G2), this.tableGastos.size(), 3);
        this.modeloG.setValueAt(Double.valueOf(G3), this.tableGastos.size(), 4);
        this.modeloG.setValueAt(Double.valueOf(G4), this.tableGastos.size(), 5);
        this.modeloG.setValueAt(Double.valueOf(G5), this.tableGastos.size(), 6);
        this.modeloG.setValueAt(Double.valueOf(G6), this.tableGastos.size(), 7);
        this.modeloG.setValueAt(Double.valueOf(G7), this.tableGastos.size(), 8);
        this.modeloG.setValueAt(Double.valueOf(G8), this.tableGastos.size(), 9);
        this.modeloG.setValueAt(Double.valueOf(G9), this.tableGastos.size(), 10);
        this.modeloG.setValueAt(Double.valueOf(G10), this.tableGastos.size(), 11);
        this.modeloG.setValueAt(Double.valueOf(G11), this.tableGastos.size(), 12);
        this.modeloG.setValueAt(Double.valueOf(G12), this.tableGastos.size(), 13);
        this.modeloG.setValueAt(Double.valueOf(G13), this.tableGastos.size(), 14);
        this.modeloG.setValueAt(Double.valueOf(G14), this.tableGastos.size(), 15);
        this.modeloG.setValueAt(Double.valueOf(G15), this.tableGastos.size(), 16);
        this.modeloG.setValueAt(Double.valueOf(G16), this.tableGastos.size(), 17);
        this.modeloG.setValueAt(Double.valueOf(G17), this.tableGastos.size(), 18);
        this.modeloG.setValueAt(Double.valueOf(G18), this.tableGastos.size(), 19);
        this.modeloG.setValueAt(Double.valueOf(G19), this.tableGastos.size(), 20);
        this.modeloG.setValueAt(Double.valueOf(G20), this.tableGastos.size(), 21);
        this.modeloG.setValueAt(Double.valueOf(G21), this.tableGastos.size(), 22);
        this.modeloG.setValueAt(Double.valueOf(G22), this.tableGastos.size(), 23);
        this.modeloG.setValueAt(Double.valueOf(G23), this.tableGastos.size(), 24);
        this.modeloG.setValueAt(Double.valueOf(G24), this.tableGastos.size(), 25);
        this.modeloG.setValueAt(Double.valueOf(G25), this.tableGastos.size(), 26);
        this.modeloG.setValueAt(Double.valueOf(G26), this.tableGastos.size(), 27);
        this.modeloG.setValueAt(0, this.tableGastos.size(), 28);
    }

    private void mLlenarDatos() {
        this.sql = "DROP TABLE IF EXISTS pp_tem_rubros;\n";
        this.xct.ejecutarSQL(this.sql);
        this.sql = "CREATE TABLE pp_tem_rubros\nSELECT  \nr.Id\n,r.IdPadre\n,r.Nbre\n,r.TipoRubro\n,Presupuesto_Inicial\n,Adicion_Presupuesto\n,Reduccion_Presupuesto\n,Traslados_Debitos\n,Traslados_Creditos\n,Presupuesto_Definitivo\n,Reconocimiento_Anterior\n,Reconocimiento_Actual\n,Reconocimiento_Total\n,Recaudo_Anterior\n,Recaudo_Actual\n,Recaudo_Total\n,Saldo_por_Ejecutar\n,Saldo_por_Recaudar \n,Certificado_Anterior\n,Certificado_Actual\n,Total_Certificados\n,Compromiso_Anterior\n,Compromiso_Actual\n,Compromiso_Total\n,Obligacion_Anterior\n,Obligacion_Actual\n,Total_Obligaciones\n,Pagos_Anterior\n,Pagos_Actual\n,Total_Pagos\n,Saldo_Disponible\n,Sin_Comprometer\n,Compromisos_por_Pagar\n,Cuentas_por_Pagar\n,Certificado_sin_Comprometer\n\nFROM pp_rubros r\nLEFT JOIN \n(SELECT \n Id_R\n ,N_R\n ,TipoRubro\n ,Presupuesto_Inicial\n ,Adicion_Presupuesto\n ,Reduccion_Presupuesto\n ,Traslados_Debitos\n ,Traslados_Creditos\n , (Presupuesto_Inicial+Adicion_Presupuesto-Reduccion_Presupuesto-Traslados_Debitos+Traslados_Creditos) Presupuesto_Definitivo\n  ,Reconocimiento_Anterior\n ,Reconocimiento_Actual\n ,(Reconocimiento_Anterior+Reconocimiento_Actual) Reconocimiento_Total\n ,Recaudo_Anterior\n ,Recaudo_Actual\n ,(Recaudo_Anterior+Recaudo_Actual) Recaudo_Total\n , ((Presupuesto_Inicial+Adicion_Presupuesto-Reduccion_Presupuesto-Traslados_Debitos+Traslados_Creditos) - (Reconocimiento_Anterior+Reconocimiento_Actual)) Saldo_por_Ejecutar\n , ((Reconocimiento_Anterior+Reconocimiento_Actual) - (Recaudo_Anterior+Recaudo_Actual)) Saldo_por_Recaudar \n ,Disponibilidad_Anterior  AS Certificado_Anterior\n ,Disponibilidad_Actual  AS Certificado_Actual\n , (Disponibilidad_Anterior+Disponibilidad_Actual) Total_Certificados\n ,Compromiso_Anterior\n ,Compromiso_Actual\n ,(Compromiso_Anterior+Compromiso_Actual) Compromiso_Total\n ,Obligacion_Anterior\n ,Obligacion_Actual\n ,(Obligacion_Anterior+Obligacion_Actual) Total_Obligaciones\n ,Pagos_Anterior\n ,Pagos_Actual\n ,(Pagos_Anterior+ Pagos_Actual) Total_Pagos\n ,((Presupuesto_Inicial+Adicion_Presupuesto-Reduccion_Presupuesto-Traslados_Debitos+Traslados_Creditos)- (Disponibilidad_Anterior+Disponibilidad_Actual)) Saldo_Disponible\n ,((Presupuesto_Inicial+Adicion_Presupuesto-Reduccion_Presupuesto-Traslados_Debitos+Traslados_Creditos)-(Compromiso_Anterior+Compromiso_Actual)) Sin_Comprometer\n ,((Compromiso_Anterior+Compromiso_Actual)-(Pagos_Anterior+ Pagos_Actual)) Compromisos_por_Pagar\n ,((Obligacion_Anterior+Obligacion_Actual)-(Pagos_Anterior+ Pagos_Actual)) Cuentas_por_Pagar\n ,((Disponibilidad_Anterior+Disponibilidad_Actual)-(Compromiso_Anterior+Compromiso_Actual)) Certificado_sin_Comprometer\nFROM \n(SELECT  \nId_R\n,N_R\n,TipoRubro\n,SUM(IFNULL(Presupuesto_Inicial,0)) Presupuesto_Inicial\n,SUM(IFNULL(Adicion_Presupuesto,0)) Adicion_Presupuesto\n,SUM(IFNULL(Reduccion_Presupuesto,0)) Reduccion_Presupuesto\n,SUM(IFNULL(Traslados_Debitos,0)) Traslados_Debitos\n,SUM(IFNULL(Traslados_Creditos,0)) Traslados_Creditos\n,SUM(IFNULL(Reconocimiento_Anterior,0)) Reconocimiento_Anterior\n,SUM(IFNULL(Reconocimiento_Actual,0)) Reconocimiento_Actual\n,SUM(IFNULL(Recaudo_Anterior,0)) Recaudo_Anterior\n,SUM(IFNULL(Recaudo_Actual,0)) Recaudo_Actual\n,SUM(IFNULL(Disponibilidad_Anterior,0)) Disponibilidad_Anterior\n,SUM(IFNULL(Disponibilidad_Actual,0)) Disponibilidad_Actual\n,SUM(IFNULL(Compromiso_Anterior,0)) Compromiso_Anterior\n,SUM(IFNULL(Compromiso_Actual,0)) Compromiso_Actual\n,SUM(IFNULL(Obligacion_Anterior,0)) Obligacion_Anterior\n,SUM(IFNULL(Obligacion_Actual,0)) Obligacion_Actual\n,SUM(IFNULL(Pagos_Anterior,0)) Pagos_Anterior\n,SUM(IFNULL(Pagos_Actual,0)) Pagos_Actual\nFROM \n(SELECT \nId_R\n,N_R\n,TipoRubro\n,CASE WHEN Id_CD=1 THEN \n   Valor\nEND Presupuesto_Inicial  \n\n,CASE WHEN Id_CD=8  AND Tipo=1 THEN \n   Valor\nEND Adicion_Presupuesto  \n\n,CASE WHEN Id_CD=8  AND Tipo=0 THEN \n   Valor \nEND Reduccion_Presupuesto  \n\n,CASE WHEN Id_CD=7 AND Tipo=0 THEN\n   Valor\n  END Traslados_Debitos \n\n,CASE WHEN Id_CD=7 AND Tipo=1 THEN \n Valor\nEND Traslados_Creditos\n\n\n,CASE WHEN Id_CD=2  AND Id_Periodo<>Periodo_Act  THEN\n     Valor\n END Reconocimiento_Anterior\n\n,CASE WHEN Id_CD=2  AND Id_Periodo=Periodo_Act  THEN\n     Valor\n END Reconocimiento_Actual\n\n,CASE WHEN Id_CD=3  AND Id_Periodo<>Periodo_Act  THEN\n     Valor\n END Recaudo_Anterior\n\n,CASE WHEN Id_CD=3  AND Id_Periodo=Periodo_Act  THEN\n     Valor\n END Recaudo_Actual\n\n\n,CASE WHEN Id_CD IN(9,10)  AND Id_Periodo<>Periodo_Act  THEN\n     Valor\n     WHEN Id_CD IN(11)  AND Id_Periodo<>Periodo_Act  THEN\n     Valor*(-1)\n END Disponibilidad_Anterior\n\n,CASE WHEN Id_CD IN(9,10)  AND Id_Periodo=Periodo_Act  THEN\n     Valor\n     WHEN Id_CD IN(11)  AND Id_Periodo=Periodo_Act  THEN\n     Valor*(-1)\n END Disponibilidad_Actual\n\n,CASE WHEN Id_CD IN(4,12)  AND Id_Periodo<>Periodo_Act  THEN\n     Valor\n     WHEN Id_CD IN(13)  AND Id_Periodo<>Periodo_Act  THEN\n     Valor*(-1)\n END Compromiso_Anterior\n \n ,CASE WHEN Id_CD IN(4,12)  AND Id_Periodo=Periodo_Act  THEN\n     Valor\n     WHEN Id_CD IN(13)  AND Id_Periodo=Periodo_Act  THEN\n     Valor*(-1)\n END Compromiso_Actual\n \n,CASE WHEN Id_CD IN(5,14)  AND Id_Periodo<>Periodo_Act THEN\n  Valor\n    WHEN Id_CD IN(15)  AND Id_Periodo<>Periodo_Act  THEN\n  Valor*(-1)\n  END Obligacion_Anterior\n \n ,CASE WHEN Id_CD IN(5,14)  AND Id_Periodo=Periodo_Act THEN\n   Valor\n   WHEN Id_CD IN(15)  AND Id_Periodo=Periodo_Act  THEN\n   Valor*(-1)\n END Obligacion_Actual  \n ,CASE WHEN Id_CD=6 AND Id_Periodo<>Periodo_Act THEN\n     Valor\n END Pagos_Anterior\n \n ,CASE WHEN Id_CD=6 AND Id_Periodo=Periodo_Act THEN\n     Valor\n END Pagos_Actual\n \n     \n FROM \n(SELECT\n      pp_clase_documento.Id Id_CD \n     , pp_clase_documento.Nbre N_CD\n     , pp_rubros.Id Id_R\n     , pp_rubros.Nbre N_R\n     ,pp_rubros.TipoRubro \n    , pp_detalle_movimiento.Tipo\n    , pp_movimiento.Id_Periodo\n    , SUM(pp_detalle_movimiento.Valor) Valor\n    , @Periodo_Act Periodo_Act\n    \nFROM (SELECT @Periodo_Act:=" + this.idPeriodo + ") p,\n    pp_movimiento\n    INNER JOIN pp_periodo \n        ON (pp_movimiento.Id_Periodo = pp_periodo.Id)\n    INNER JOIN pp_detalle_movimiento \n        ON (pp_detalle_movimiento.Id_Movimiento = pp_movimiento.Id)\n    INNER JOIN pp_tipo_documentos \n        ON (pp_movimiento.Id_TipoDoc = pp_tipo_documentos.Id)\n    INNER JOIN pp_rubros \n        ON (pp_detalle_movimiento.Id_Rubro = pp_rubros.Id) AND (pp_rubros.`idEncabezadoRubro`=pp_detalle_movimiento.`idEncabezado`) \n    INNER JOIN pp_clase_documento \n        ON (pp_tipo_documentos.Id_ClaseDoc = pp_clase_documento.Id)\n    WHERE pp_detalle_movimiento.idEncabezado='" + Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro() + "' AND pp_periodo.Id IN ( SELECT pant.Id  FROM `pp_periodo` pant, (SELECT Id, FechaI,FechaF FROM `pp_periodo`\n\t\t\t\tWHERE Id=" + this.idPeriodo + " ) pact\n\t\t\t\tWHERE (DATE_FORMAT(pant.FechaI,'%Y')=DATE_FORMAT(pact.FechaI,'%Y') AND pant.FechaF<=pact.FechaI)\n\t\t\t\tOR pact.Id=pant.id\n\t\t\t      ) \t\n    AND pp_movimiento.Id_MotivoAnulacion=1 \n GROUP BY  pp_clase_documento.Id   , pp_clase_documento.Nbre, pp_rubros.Id ,pp_detalle_movimiento.Tipo ,pp_movimiento.Id_Periodo\n ) datos\n ) datos\nGROUP BY Id_R ,N_R,TipoRubro\n) datos ) datos\nON r.Id=datos.Id_R WHERE r.`idEncabezadoRubro`='" + Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro() + "';";
        System.out.println(this.sql);
        this.xct.ejecutarSQL(this.sql);
        this.sql = "UPDATE pp_tem_rubros P\nINNER JOIN\n(SELECT \n A.Id\n,SUM(B.Presupuesto_Inicial) Presupuesto_Inicial\n,SUM(B.Adicion_Presupuesto) Adicion_Presupuesto\n,SUM(B.Reduccion_Presupuesto) Reduccion_Presupuesto\n,SUM(B.Traslados_Debitos) Traslados_Debitos\n,SUM(B.Traslados_Creditos) Traslados_Creditos\n,SUM(B.Presupuesto_Definitivo) Presupuesto_Definitivo\n,SUM(B.Reconocimiento_Anterior) Reconocimiento_Anterior\n,SUM(B.Reconocimiento_Actual) Reconocimiento_Actual\n,SUM(B.Reconocimiento_Total) Reconocimiento_Total\n,SUM(B.Recaudo_Anterior) Recaudo_Anterior\n,SUM(B.Recaudo_Actual) Recaudo_Actual\n,SUM(B.Recaudo_Total) Recaudo_Total\n,SUM(B.Saldo_por_Ejecutar) Saldo_por_Ejecutar\n,SUM(B.Saldo_por_Recaudar ) Saldo_por_Recaudar\n,SUM(B.Certificado_Anterior) Certificado_Anterior\n,SUM(B.Certificado_Actual) Certificado_Actual\n,SUM(B.Total_Certificados) Total_Certificados\n,SUM(B.Compromiso_Anterior) Compromiso_Anterior\n,SUM(B.Compromiso_Actual) Compromiso_Actual\n,SUM(B.Compromiso_Total) Compromiso_Total\n,SUM(B.Obligacion_Anterior) Obligacion_Anterior\n,SUM(B.Obligacion_Actual) Obligacion_Actual\n,SUM(B.Total_Obligaciones) Total_Obligaciones\n,SUM(B.Pagos_Anterior) Pagos_Anterior\n,SUM(B.Pagos_Actual) Pagos_Actual\n,SUM(B.Total_Pagos) Total_Pagos\n,SUM(B.Saldo_Disponible) Saldo_Disponible\n,SUM(B.Sin_Comprometer) Sin_Comprometer\n,SUM(B.Compromisos_por_Pagar) Compromisos_por_Pagar\n,SUM(B.Cuentas_por_Pagar) Cuentas_por_Pagar\n,SUM(B.Certificado_sin_Comprometer) Certificado_sin_Comprometer\n\nFROM pp_tem_rubros A\nINNER JOIN\npp_tem_rubros B\nON A.Id= B.IdPadre\nGROUP BY A.Id) A\nON P.Id=A.Id\nSET \tP.Presupuesto_Inicial=A.Presupuesto_Inicial\n,\tP.Adicion_Presupuesto\t=\tA.Adicion_Presupuesto\n,\tP.Reduccion_Presupuesto\t=\tA.Reduccion_Presupuesto\n,\tP.Traslados_Debitos\t=\tA.Traslados_Debitos\n,\tP.Traslados_Creditos\t=\tA.Traslados_Creditos\n,\tP.Presupuesto_Definitivo\t=\tA.Presupuesto_Definitivo\n,\tP.Reconocimiento_Anterior\t=\tA.Reconocimiento_Anterior\n,\tP.Reconocimiento_Actual\t=\tA.Reconocimiento_Actual\n,\tP.Reconocimiento_Total\t=\tA.Reconocimiento_Total\n,\tP.Recaudo_Anterior\t=\tA.Recaudo_Anterior\n,\tP.Recaudo_Actual\t=\tA.Recaudo_Actual\n,\tP.Recaudo_Total\t=\tA.Recaudo_Total\n,\tP.Saldo_por_Ejecutar\t=\tA.Saldo_por_Ejecutar\n,\tP.Saldo_por_Recaudar \t=\tA.Saldo_por_Recaudar \n,\tP.Certificado_Anterior\t=\tA.Certificado_Anterior\n,\tP.Certificado_Actual\t=\tA.Certificado_Actual\n,\tP.Total_Certificados\t=\tA.Total_Certificados\n,\tP.Compromiso_Anterior\t=\tA.Compromiso_Anterior\n,\tP.Compromiso_Actual\t=\tA.Compromiso_Actual\n,\tP.Compromiso_Total\t=\tA.Compromiso_Total\n,\tP.Obligacion_Anterior\t=\tA.Obligacion_Anterior\n,\tP.Obligacion_Actual\t=\tA.Obligacion_Actual\n,\tP.Total_Obligaciones\t=\tA.Total_Obligaciones\n,\tP.Pagos_Anterior\t=\tA.Pagos_Anterior\n,\tP.Pagos_Actual\t=\tA.Pagos_Actual\n,\tP.Total_Pagos\t=\tA.Total_Pagos\n,\tP.Saldo_Disponible\t=\tA.Saldo_Disponible\n,\tP.Sin_Comprometer\t=\tA.Sin_Comprometer\n,\tP.Compromisos_por_Pagar\t=\tA.Compromisos_por_Pagar\n,\tP.Cuentas_por_Pagar\t=\tA.Cuentas_por_Pagar\n,\tP.Certificado_sin_Comprometer\t=\tA.Certificado_sin_Comprometer";
        for (int i = 0; i < 50; i++) {
            this.xct.ejecutarSQL(this.sql);
        }
        this.xct.cerrarConexionBd();
        this.sql = "SELECT * FROM pp_tem_rubros";
        this.filaGridI = 0;
        this.filaGridG = 0;
        mCrearGridIngresos();
        mCrearGridGastos();
        ResultSet xrs = this.xct.traerRs(this.sql);
        double G1 = 0.0d;
        double G2 = 0.0d;
        double G3 = 0.0d;
        double G4 = 0.0d;
        double G5 = 0.0d;
        double G6 = 0.0d;
        double G7 = 0.0d;
        double G8 = 0.0d;
        double G9 = 0.0d;
        double G10 = 0.0d;
        double G11 = 0.0d;
        double G12 = 0.0d;
        double G13 = 0.0d;
        double G14 = 0.0d;
        double G15 = 0.0d;
        double G16 = 0.0d;
        double G17 = 0.0d;
        double G18 = 0.0d;
        double G19 = 0.0d;
        double G20 = 0.0d;
        double G21 = 0.0d;
        double G22 = 0.0d;
        double G23 = 0.0d;
        while (xrs.next()) {
            try {
                if (xrs.getString("TipoRubro").equals("I")) {
                    this.modeloI.addRow(this.datoI);
                    this.modeloI.setValueAt(xrs.getString("Id"), this.filaGridI, 0);
                    this.modeloI.setValueAt(xrs.getString("Nbre"), this.filaGridI, 1);
                    this.modeloI.setValueAt(Double.valueOf(xrs.getDouble("Presupuesto_Inicial")), this.filaGridI, 2);
                    this.modeloI.setValueAt(Double.valueOf(xrs.getDouble("Adicion_Presupuesto")), this.filaGridI, 3);
                    this.modeloI.setValueAt(Double.valueOf(xrs.getDouble("Reduccion_Presupuesto")), this.filaGridI, 4);
                    this.modeloI.setValueAt(Double.valueOf(xrs.getDouble("Presupuesto_Definitivo")), this.filaGridI, 5);
                    this.modeloI.setValueAt(Double.valueOf(xrs.getDouble("Reconocimiento_Anterior")), this.filaGridI, 6);
                    this.modeloI.setValueAt(Double.valueOf(xrs.getDouble("Reconocimiento_Actual")), this.filaGridI, 7);
                    this.modeloI.setValueAt(Double.valueOf(xrs.getDouble("Reconocimiento_Total")), this.filaGridI, 8);
                    this.modeloI.setValueAt(Double.valueOf(xrs.getDouble("Recaudo_Anterior")), this.filaGridI, 9);
                    this.modeloI.setValueAt(Double.valueOf(xrs.getDouble("Recaudo_Actual")), this.filaGridI, 10);
                    this.modeloI.setValueAt(Double.valueOf(xrs.getDouble("Recaudo_Total")), this.filaGridI, 11);
                    this.modeloI.setValueAt(Double.valueOf(xrs.getDouble("Saldo_por_Ejecutar")), this.filaGridI, 12);
                    this.modeloI.setValueAt(Double.valueOf(xrs.getDouble("Saldo_por_Recaudar")), this.filaGridI, 13);
                    this.modeloI.setValueAt(Double.valueOf(xrs.getDouble("Traslados_Debitos")), this.filaGridI, 14);
                    this.modeloI.setValueAt(Double.valueOf(xrs.getDouble("Traslados_Creditos")), this.filaGridI, 15);
                    this.filaGridI++;
                } else {
                    this.modeloG.addRow(this.datoG);
                    this.modeloG.setValueAt(xrs.getString("Id"), this.filaGridG, 0);
                    this.modeloG.setValueAt(xrs.getString("Nbre"), this.filaGridG, 1);
                    this.modeloG.setValueAt(Double.valueOf(xrs.getDouble("Presupuesto_Inicial")), this.filaGridG, 2);
                    this.modeloG.setValueAt(Double.valueOf(xrs.getDouble("Adicion_Presupuesto")), this.filaGridG, 3);
                    this.modeloG.setValueAt(Double.valueOf(xrs.getDouble("Reduccion_Presupuesto")), this.filaGridG, 4);
                    this.modeloG.setValueAt(Double.valueOf(xrs.getDouble("Traslados_Debitos")), this.filaGridG, 5);
                    this.modeloG.setValueAt(Double.valueOf(xrs.getDouble("Traslados_Creditos")), this.filaGridG, 6);
                    this.modeloG.setValueAt(Double.valueOf(xrs.getDouble("Presupuesto_Definitivo")), this.filaGridG, 7);
                    this.modeloG.setValueAt(Double.valueOf(xrs.getDouble("Certificado_Anterior")), this.filaGridG, 8);
                    this.modeloG.setValueAt(Double.valueOf(xrs.getDouble("Certificado_Actual")), this.filaGridG, 9);
                    this.modeloG.setValueAt(Double.valueOf(xrs.getDouble("Total_Certificados")), this.filaGridG, 10);
                    this.modeloG.setValueAt(Double.valueOf(xrs.getDouble("Compromiso_Anterior")), this.filaGridG, 11);
                    this.modeloG.setValueAt(Double.valueOf(xrs.getDouble("Compromiso_Actual")), this.filaGridG, 12);
                    this.modeloG.setValueAt(Double.valueOf(xrs.getDouble("Compromiso_Total")), this.filaGridG, 13);
                    this.modeloG.setValueAt(Double.valueOf(xrs.getDouble("Obligacion_Anterior")), this.filaGridG, 14);
                    this.modeloG.setValueAt(Double.valueOf(xrs.getDouble("Obligacion_Actual")), this.filaGridG, 15);
                    this.modeloG.setValueAt(Double.valueOf(xrs.getDouble("Total_Obligaciones")), this.filaGridG, 16);
                    this.modeloG.setValueAt(Double.valueOf(xrs.getDouble("Pagos_Anterior")), this.filaGridG, 17);
                    this.modeloG.setValueAt(Double.valueOf(xrs.getDouble("Pagos_Actual")), this.filaGridG, 18);
                    this.modeloG.setValueAt(Double.valueOf(xrs.getDouble("Total_Pagos")), this.filaGridG, 19);
                    this.modeloG.setValueAt(Double.valueOf(xrs.getDouble("Saldo_Disponible")), this.filaGridG, 20);
                    this.modeloG.setValueAt(Double.valueOf(xrs.getDouble("Sin_Comprometer")), this.filaGridG, 21);
                    this.modeloG.setValueAt(Double.valueOf(xrs.getDouble("Compromisos_por_Pagar")), this.filaGridG, 22);
                    this.modeloG.setValueAt(Double.valueOf(xrs.getDouble("Cuentas_por_Pagar")), this.filaGridG, 23);
                    this.modeloG.setValueAt(Double.valueOf(xrs.getDouble("Certificado_sin_Comprometer")), this.filaGridG, 24);
                    if (xrs.getString("Id").length() == 1) {
                        G1 += xrs.getDouble("Presupuesto_Inicial");
                        G2 += xrs.getDouble("Adicion_Presupuesto");
                        G3 += xrs.getDouble("Reduccion_Presupuesto");
                        G4 += xrs.getDouble("Traslados_Debitos");
                        G5 += xrs.getDouble("Traslados_Creditos");
                        G6 += xrs.getDouble("Presupuesto_Definitivo");
                        G7 += xrs.getDouble("Certificado_Anterior");
                        G8 += xrs.getDouble("Certificado_Actual");
                        G9 += xrs.getDouble("Total_Certificados");
                        G10 += xrs.getDouble("Compromiso_Anterior");
                        G11 += xrs.getDouble("Compromiso_Actual");
                        G12 += xrs.getDouble("Compromiso_Total");
                        G13 += xrs.getDouble("Obligacion_Anterior");
                        G14 += xrs.getDouble("Obligacion_Actual");
                        G15 += xrs.getDouble("Total_Obligaciones");
                        G16 += xrs.getDouble("Pagos_Anterior");
                        G17 += xrs.getDouble("Pagos_Actual");
                        G18 += xrs.getDouble("Total_Pagos");
                        G19 += xrs.getDouble("Saldo_Disponible");
                        G20 += xrs.getDouble("Sin_Comprometer");
                        G21 += xrs.getDouble("Compromisos_por_Pagar");
                        G22 += xrs.getDouble("Cuentas_por_Pagar");
                        G23 += xrs.getDouble("Certificado_sin_Comprometer");
                    }
                    this.filaGridG++;
                }
            } catch (SQLException ex) {
                Logger.getLogger(JIFConsultaRubros.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                return;
            }
        }
        this.modeloG.addRow(this.datoG);
        this.modeloG.setValueAt("TOTAL", this.filaGridG, 0);
        this.modeloG.setValueAt("", this.filaGridG, 1);
        this.modeloG.setValueAt(Double.valueOf(G1), this.filaGridG, 2);
        this.modeloG.setValueAt(Double.valueOf(G2), this.filaGridG, 3);
        this.modeloG.setValueAt(Double.valueOf(G3), this.filaGridG, 4);
        this.modeloG.setValueAt(Double.valueOf(G4), this.filaGridG, 5);
        this.modeloG.setValueAt(Double.valueOf(G5), this.filaGridG, 6);
        this.modeloG.setValueAt(Double.valueOf(G6), this.filaGridG, 7);
        this.modeloG.setValueAt(Double.valueOf(G7), this.filaGridG, 8);
        this.modeloG.setValueAt(Double.valueOf(G8), this.filaGridG, 9);
        this.modeloG.setValueAt(Double.valueOf(G9), this.filaGridG, 10);
        this.modeloG.setValueAt(Double.valueOf(G10), this.filaGridG, 11);
        this.modeloG.setValueAt(Double.valueOf(G11), this.filaGridG, 12);
        this.modeloG.setValueAt(Double.valueOf(G12), this.filaGridG, 13);
        this.modeloG.setValueAt(Double.valueOf(G13), this.filaGridG, 14);
        this.modeloG.setValueAt(Double.valueOf(G14), this.filaGridG, 15);
        this.modeloG.setValueAt(Double.valueOf(G15), this.filaGridG, 16);
        this.modeloG.setValueAt(Double.valueOf(G16), this.filaGridG, 17);
        this.modeloG.setValueAt(Double.valueOf(G17), this.filaGridG, 18);
        this.modeloG.setValueAt(Double.valueOf(G18), this.filaGridG, 19);
        this.modeloG.setValueAt(Double.valueOf(G19), this.filaGridG, 20);
        this.modeloG.setValueAt(Double.valueOf(G20), this.filaGridG, 21);
        this.modeloG.setValueAt(Double.valueOf(G21), this.filaGridG, 22);
        this.modeloG.setValueAt(Double.valueOf(G22), this.filaGridG, 23);
        this.modeloG.setValueAt(Double.valueOf(G23), this.filaGridG, 24);
        xrs.close();
    }

    private void mCrearGridIngresos() {
        this.modeloI = new DefaultTableModel() { // from class: Presupuesto.JIFConsultaRubros.14
            Class[] types = {String.class, String.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Integer.class, Double.class, Double.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return this.canEdit[colIndex];
            }
        };
        this.modeloI.addColumn("Rubro");
        this.modeloI.addColumn("Nombre Rubro");
        this.modeloI.addColumn("Presupuesto Inicial");
        this.modeloI.addColumn("Adiciones");
        this.modeloI.addColumn("Reducciones");
        this.modeloI.addColumn("Presupuesto Definitivo");
        this.modeloI.addColumn("Reconoc. Anteriores");
        this.modeloI.addColumn("Reconoc. Mes ");
        this.modeloI.addColumn("Total Reconocimientos");
        this.modeloI.addColumn("Saldo Ant. Recaudos");
        this.modeloI.addColumn("Recaudos Mes");
        this.modeloI.addColumn("Acumulado Recaudos");
        this.modeloI.addColumn("Saldo por Ejecutar");
        this.modeloI.addColumn("Saldo por Recaudar");
        this.modeloI.addColumn("Ultimo nivel");
        this.modeloI.addColumn("Traslados Debito");
        this.modeloI.addColumn("Traslados Credito");
        JTable jTable = this.gridI;
        JTable jTable2 = this.gridI;
        jTable.setAutoResizeMode(0);
        this.gridI.doLayout();
        this.gridI.setModel(this.modeloI);
        this.gridI.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.gridI.getColumnModel().getColumn(1).setPreferredWidth(450);
        this.gridI.getColumnModel().getColumn(2).setPreferredWidth(150);
        this.gridI.getColumnModel().getColumn(3).setPreferredWidth(150);
        this.gridI.getColumnModel().getColumn(4).setPreferredWidth(150);
        this.gridI.getColumnModel().getColumn(5).setPreferredWidth(150);
        this.gridI.getColumnModel().getColumn(6).setPreferredWidth(150);
        this.gridI.getColumnModel().getColumn(7).setPreferredWidth(150);
        this.gridI.getColumnModel().getColumn(8).setPreferredWidth(150);
        this.gridI.getColumnModel().getColumn(9).setPreferredWidth(150);
        this.gridI.getColumnModel().getColumn(10).setPreferredWidth(150);
        this.gridI.getColumnModel().getColumn(11).setPreferredWidth(150);
        this.gridI.getColumnModel().getColumn(12).setPreferredWidth(150);
        this.gridI.getColumnModel().getColumn(13).setPreferredWidth(150);
        this.gridI.getColumnModel().getColumn(14).setPreferredWidth(150);
        this.gridI.getColumnModel().getColumn(14).setMinWidth(150);
        this.gridI.getColumnModel().getColumn(14).setMaxWidth(150);
        this.gridI.getColumnModel().getColumn(15).setPreferredWidth(150);
        this.gridI.getColumnModel().getColumn(15).setMinWidth(150);
        this.gridI.getColumnModel().getColumn(15).setMaxWidth(150);
        this.gridI.getColumnModel().getColumn(16).setPreferredWidth(150);
        this.gridI.getColumnModel().getColumn(16).setMinWidth(150);
        this.gridI.getColumnModel().getColumn(16).setMaxWidth(150);
        this.gridI.setModel(this.modeloI);
    }

    private void mCrearGridGastos() {
        this.modeloG = new DefaultTableModel() { // from class: Presupuesto.JIFConsultaRubros.15
            Class[] types = {String.class, String.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Integer.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return this.canEdit[colIndex];
            }
        };
        this.modeloG.addColumn("Rubro");
        this.modeloG.addColumn("Nombre Rubro");
        this.modeloG.addColumn("Presupuesto Inicial");
        this.modeloG.addColumn("Adiciones");
        this.modeloG.addColumn("Reducciones");
        this.modeloG.addColumn("Traslados Debitos");
        this.modeloG.addColumn("Traslados Creditos");
        this.modeloG.addColumn("Apropiación Definitiva");
        this.modeloG.addColumn("Certificados Anterior");
        this.modeloG.addColumn("Certificados Mes");
        this.modeloG.addColumn("Total Reintregro Certificados");
        this.modeloG.addColumn("Total Certificados");
        this.modeloG.addColumn("Comprometido Anterior");
        this.modeloG.addColumn("Compromisos Mes");
        this.modeloG.addColumn("Total Reintegro Compromisos");
        this.modeloG.addColumn("Total Compromisos");
        this.modeloG.addColumn("Obligaciones Ant.");
        this.modeloG.addColumn("Obligaciones Mes");
        this.modeloG.addColumn("Total Reintegro Obligaciones");
        this.modeloG.addColumn("Total Obligaciones");
        this.modeloG.addColumn("Pagos Anterior");
        this.modeloG.addColumn("Pagos Mes");
        this.modeloG.addColumn("Total Pagos");
        this.modeloG.addColumn("Saldo Disponible");
        this.modeloG.addColumn("Sin Comprometer");
        this.modeloG.addColumn("Compromisos por Pagar");
        this.modeloG.addColumn("Cuentas por Pagar");
        this.modeloG.addColumn("Certificado sin Comprometer");
        this.modeloG.addColumn("Ultimo nivel");
        JTable jTable = this.gridG;
        JTable jTable2 = this.gridG;
        jTable.setAutoResizeMode(0);
        this.gridG.doLayout();
        this.gridG.setModel(this.modeloG);
        this.gridG.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.gridG.getColumnModel().getColumn(1).setPreferredWidth(450);
        this.gridG.getColumnModel().getColumn(2).setPreferredWidth(150);
        this.gridG.getColumnModel().getColumn(3).setPreferredWidth(150);
        this.gridG.getColumnModel().getColumn(4).setPreferredWidth(150);
        this.gridG.getColumnModel().getColumn(5).setPreferredWidth(150);
        this.gridG.getColumnModel().getColumn(6).setPreferredWidth(150);
        this.gridG.getColumnModel().getColumn(7).setPreferredWidth(150);
        this.gridG.getColumnModel().getColumn(8).setPreferredWidth(150);
        this.gridG.getColumnModel().getColumn(9).setPreferredWidth(150);
        this.gridG.getColumnModel().getColumn(10).setPreferredWidth(0);
        this.gridG.getColumnModel().getColumn(10).setMinWidth(0);
        this.gridG.getColumnModel().getColumn(10).setMaxWidth(0);
        this.gridG.getColumnModel().getColumn(11).setPreferredWidth(150);
        this.gridG.getColumnModel().getColumn(12).setPreferredWidth(150);
        this.gridG.getColumnModel().getColumn(13).setPreferredWidth(150);
        this.gridG.getColumnModel().getColumn(14).setPreferredWidth(0);
        this.gridG.getColumnModel().getColumn(14).setMinWidth(0);
        this.gridG.getColumnModel().getColumn(14).setMaxWidth(0);
        this.gridG.getColumnModel().getColumn(15).setPreferredWidth(150);
        this.gridG.getColumnModel().getColumn(16).setPreferredWidth(150);
        this.gridG.getColumnModel().getColumn(17).setPreferredWidth(150);
        this.gridG.getColumnModel().getColumn(18).setPreferredWidth(0);
        this.gridG.getColumnModel().getColumn(18).setMinWidth(0);
        this.gridG.getColumnModel().getColumn(18).setMaxWidth(0);
        this.gridG.getColumnModel().getColumn(19).setPreferredWidth(150);
        this.gridG.getColumnModel().getColumn(20).setPreferredWidth(150);
        this.gridG.getColumnModel().getColumn(21).setPreferredWidth(150);
        this.gridG.getColumnModel().getColumn(22).setPreferredWidth(150);
        this.gridG.getColumnModel().getColumn(23).setPreferredWidth(150);
        this.gridG.getColumnModel().getColumn(24).setPreferredWidth(150);
        this.gridG.getColumnModel().getColumn(25).setPreferredWidth(150);
        this.gridG.getColumnModel().getColumn(26).setPreferredWidth(150);
        this.gridG.getColumnModel().getColumn(27).setPreferredWidth(150);
        this.filaGridG = 0;
        this.gridG.setModel(this.modeloG);
    }

    public void mNuevo() {
        this.xUltimoN = 0;
        this.xAplicaTercero = 0;
    }

    public void mImprimir() {
        InformeEjecucionPresupuestalDTO informeEjecucion = new InformeEjecucionPresupuestalDTO();
        if (this.JT_Datos.getSelectedIndex() == 0) {
            informeEjecucion.setListadoEjecucion(this.tableIngreso);
        } else {
            informeEjecucion.setListadoEjecucion(this.tableGastos);
        }
        informeEjecucion.setInformacionIps(this.informacionIpsDAO.informacionIps());
        informeEjecucion.setRutaSubReportes(this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra());
        informeEjecucion.setRutaFirmas(this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra());
        informeEjecucion.setPeriodo(this.JCBPeriodo.getSelectedItem().toString() + " de " + this.JYCAno.getValue());
        informeEjecucion.setUsuarioGeneradorInforme(Principal.usuarioSistemaDTO.getNombreUsuario());
        if (this.JT_Datos.getSelectedIndex() == 0) {
            informeEjecucion.setTituloReporte("EJECUCIÓN PRESUPUESTAL DE INGRESO");
            this.xmt.GenerarPDF(this.xmt.getRutaRep() + "PP_Ejecucion_Ingreso_Periodo_DTO2", informeEjecucion, "PP_Ejecucion_Ingreso_Periodo", true);
        } else {
            informeEjecucion.setTituloReporte("EJECUCIÓN PRESUPUESTAL DE GASTOS");
            this.xmt.GenerarPDF(this.xmt.getRutaRep() + "PP_Ejecucion_Gasto_Periodo_DTO", informeEjecucion, "PP_Ejecucion_Gasto_Periodo_DTO", true);
        }
    }

    private void cargarComboNuevoFormato() {
        this.JCBPeriodoNuevoFormato.removeAllItems();
        this.lstPeriodos = this.presupuestoDAO.listPeriodoPPT(String.valueOf(this.JYCAnooNuevoFormato.getValue()));
        if (!this.lstPeriodos.isEmpty()) {
            this.xid = new String[this.lstPeriodos.size()];
            for (int i = 0; i < this.lstPeriodos.size(); i++) {
                this.xid[i] = String.valueOf(this.lstPeriodos.get(i).getId());
                this.JCBPeriodoNuevoFormato.addItem(this.lstPeriodos.get(i).getNombre());
            }
        }
    }

    private void buscarNuevoFormato() {
        int control = 0;
        int i = 1;
        while (true) {
            if (i >= 20) {
                break;
            }
            if (this.ejecucionPresupuestalDAO.verificarExistenciaTabla(String.valueOf(i))) {
                i++;
            } else {
                control = i;
                System.out.println("control: " + control);
                break;
            }
        }
        this.ejecucionPresupuestalDAO.queryEjecucionNeuva(String.valueOf(control), String.valueOf(this.lstPeriodos.get(this.JCBPeriodoNuevoFormato.getSelectedIndex()).getId()), String.valueOf(this.lstPeriodos.get(this.JCBPeriodoNuevoFormato.getSelectedIndex()).getIdEncabezado()));
        for (int i2 = 1; i2 <= 50; i2++) {
            this.ejecucionPresupuestalDAO.actualizarValoresPadreNuevoFormato(String.valueOf(control));
        }
        this.listaEjecucionNueva = this.ejecucionPresupuestalDAO.getEjecucionPresupuestalNueva(String.valueOf(control));
        this.ejecucionPresupuestalDAO.eliminarTablasTemporales(String.valueOf(control));
        llenarTablaIngresoNuevoFormato();
        llenarTablaGastoNuevoFormato();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearModeloIngresoNuevoFormato() {
        this.modeloIngresoNuevo = new DefaultTableModel(new Object[0], new String[]{"Codigo Rubro", "Nombre Rubro", "Ultimo Nivel", "Presupuesto Inicial", "Adiciones", "Reducciones", "Presupuesto Definitivo", "Reconocimientos Anteriores", "Total Reconocimientos", "Saldo Recaudo Anterior", "Recaudos Acumulados", "Saldo Por Ejecutar", "Saldo Por Recaudar", "Traslado Debito", "Traslado Credito"}) { // from class: Presupuesto.JIFConsultaRubros.16
            Class[] types = {String.class, String.class, String.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalleIngresoNuevoFormato.setAutoResizeMode(0);
        this.JTDetalleIngresoNuevoFormato.doLayout();
        this.JTDetalleIngresoNuevoFormato.setModel(this.modeloIngresoNuevo);
        this.JTDetalleIngresoNuevoFormato.getColumnModel().getColumn(0).setPreferredWidth(150);
        this.JTDetalleIngresoNuevoFormato.getColumnModel().getColumn(1).setPreferredWidth(150);
        this.JTDetalleIngresoNuevoFormato.getColumnModel().getColumn(2).setPreferredWidth(150);
        this.JTDetalleIngresoNuevoFormato.getColumnModel().getColumn(3).setPreferredWidth(150);
        this.JTDetalleIngresoNuevoFormato.getColumnModel().getColumn(4).setPreferredWidth(150);
        this.JTDetalleIngresoNuevoFormato.getColumnModel().getColumn(5).setPreferredWidth(150);
        this.JTDetalleIngresoNuevoFormato.getColumnModel().getColumn(6).setPreferredWidth(150);
        this.JTDetalleIngresoNuevoFormato.getColumnModel().getColumn(7).setPreferredWidth(150);
        this.JTDetalleIngresoNuevoFormato.getColumnModel().getColumn(8).setPreferredWidth(150);
        this.JTDetalleIngresoNuevoFormato.getColumnModel().getColumn(9).setPreferredWidth(150);
        this.JTDetalleIngresoNuevoFormato.getColumnModel().getColumn(10).setPreferredWidth(150);
        this.JTDetalleIngresoNuevoFormato.getColumnModel().getColumn(11).setPreferredWidth(150);
        this.JTDetalleIngresoNuevoFormato.getColumnModel().getColumn(12).setPreferredWidth(150);
        this.JTDetalleIngresoNuevoFormato.getColumnModel().getColumn(13).setPreferredWidth(150);
        this.JTDetalleIngresoNuevoFormato.getColumnModel().getColumn(14).setPreferredWidth(150);
    }

    private void llenarTablaIngresoNuevoFormato() {
        crearModeloIngresoNuevoFormato();
        this.listaIngreso = (List) this.listaEjecucionNueva.stream().filter(p -> {
            return p.getTipoRubro().equals("I");
        }).collect(Collectors.toList());
        this.listaIngreso.forEach(e -> {
            this.modeloIngresoNuevo.addRow(this.datoI);
            this.modeloIngresoNuevo.setValueAt(e.getCodigoRubro(), this.JTDetalleIngresoNuevoFormato.getRowCount() - 1, 0);
            this.modeloIngresoNuevo.setValueAt(e.getNombreRubro(), this.JTDetalleIngresoNuevoFormato.getRowCount() - 1, 1);
            this.modeloIngresoNuevo.setValueAt(e.getNivel(), this.JTDetalleIngresoNuevoFormato.getRowCount() - 1, 2);
            this.modeloIngresoNuevo.setValueAt(e.getPresupuestoInicial(), this.JTDetalleIngresoNuevoFormato.getRowCount() - 1, 3);
            this.modeloIngresoNuevo.setValueAt(e.getAdicionPresupuesto(), this.JTDetalleIngresoNuevoFormato.getRowCount() - 1, 4);
            this.modeloIngresoNuevo.setValueAt(e.getReduccionPresupuesto(), this.JTDetalleIngresoNuevoFormato.getRowCount() - 1, 5);
            this.modeloIngresoNuevo.setValueAt(e.getPresupuestoDefinitivo(), this.JTDetalleIngresoNuevoFormato.getRowCount() - 1, 6);
            this.modeloIngresoNuevo.setValueAt(e.getReconocimientoAnterior(), this.JTDetalleIngresoNuevoFormato.getRowCount() - 1, 7);
            this.modeloIngresoNuevo.setValueAt(e.getReconocimientoTotal(), this.JTDetalleIngresoNuevoFormato.getRowCount() - 1, 8);
            this.modeloIngresoNuevo.setValueAt(e.getRecaudoAnterior(), this.JTDetalleIngresoNuevoFormato.getRowCount() - 1, 9);
            this.modeloIngresoNuevo.setValueAt(e.getRecaudoTotal(), this.JTDetalleIngresoNuevoFormato.getRowCount() - 1, 10);
            this.modeloIngresoNuevo.setValueAt(e.getSaldoPorEjecutar(), this.JTDetalleIngresoNuevoFormato.getRowCount() - 1, 11);
            this.modeloIngresoNuevo.setValueAt(e.getSaldoPorRecaudar(), this.JTDetalleIngresoNuevoFormato.getRowCount() - 1, 12);
            this.modeloIngresoNuevo.setValueAt(e.getTrasladosDebitos(), this.JTDetalleIngresoNuevoFormato.getRowCount() - 1, 13);
            this.modeloIngresoNuevo.setValueAt(e.getTrasladosCreditos(), this.JTDetalleIngresoNuevoFormato.getRowCount() - 1, 14);
        });
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearModeloGastoNuevoFormato() {
        this.modeloGastoNuevo = new DefaultTableModel(new Object[0], new String[]{"Codigo Rubro", "Codigo Padre", "Nombre Rubro", "Codigo Altero", "Ultimo Nivel", "Codigo de Cpc", "Nombre de Cpc", "Codigo Fuente de Financiacion", "Nombre Fuente de Financiacion", "Nombre Centro de Costo", "Tipo de Vigencia", "Presupuesto Inicial", "Adición Presupuesto", "Reducción Presupuesto", "Traslados Debitos", "Traslados Creditos", "Presupuesto Definitivo", "Reconocimiento Anterior", "Reconocimiento Actual", "Reconocimiento Total", "Recaudo Anterior", "Recaudo Actual", "Recaudo Total", "Saldo Por Ejecutar", "Saldo Por Recaudar", "Certificado Anterior", "Certificado Actual", "Reintegros Certificado", "Total Certificado", "Compromiso Anterior", "Compromiso Actual", "Reintegro Compromiso", "Total Compromiso", "Obligación Anterior", "Obligación Actual", "Reintegro Obligación", "Total Obligación", "Pagos Anteriores", "Pagos Actuales", "Total de Pagos", "Saldo Disponible", "Sin Comprometer", "Compromiso Por Pagar", "Cuentas Por Pagar", "Certificado Sin Comprometer", "Compromiso Sin Obligación"}) { // from class: Presupuesto.JIFConsultaRubros.17
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalleGastosNuevoFormato.setAutoResizeMode(0);
        this.JTDetalleGastosNuevoFormato.doLayout();
        this.JTDetalleGastosNuevoFormato.setModel(this.modeloGastoNuevo);
        this.JTDetalleGastosNuevoFormato.getColumnModel().getColumn(0).setPreferredWidth(150);
        this.JTDetalleGastosNuevoFormato.getColumnModel().getColumn(1).setPreferredWidth(150);
        this.JTDetalleGastosNuevoFormato.getColumnModel().getColumn(2).setPreferredWidth(150);
        this.JTDetalleGastosNuevoFormato.getColumnModel().getColumn(3).setPreferredWidth(150);
        this.JTDetalleGastosNuevoFormato.getColumnModel().getColumn(4).setPreferredWidth(150);
        this.JTDetalleGastosNuevoFormato.getColumnModel().getColumn(5).setPreferredWidth(150);
        this.JTDetalleGastosNuevoFormato.getColumnModel().getColumn(6).setPreferredWidth(150);
        this.JTDetalleGastosNuevoFormato.getColumnModel().getColumn(7).setPreferredWidth(150);
        this.JTDetalleGastosNuevoFormato.getColumnModel().getColumn(8).setPreferredWidth(300);
        this.JTDetalleGastosNuevoFormato.getColumnModel().getColumn(9).setPreferredWidth(150);
        this.JTDetalleGastosNuevoFormato.getColumnModel().getColumn(10).setPreferredWidth(150);
        this.JTDetalleGastosNuevoFormato.getColumnModel().getColumn(11).setPreferredWidth(150);
        this.JTDetalleGastosNuevoFormato.getColumnModel().getColumn(12).setPreferredWidth(150);
        this.JTDetalleGastosNuevoFormato.getColumnModel().getColumn(13).setPreferredWidth(150);
        this.JTDetalleGastosNuevoFormato.getColumnModel().getColumn(14).setPreferredWidth(150);
        this.JTDetalleGastosNuevoFormato.getColumnModel().getColumn(15).setPreferredWidth(150);
        this.JTDetalleGastosNuevoFormato.getColumnModel().getColumn(16).setPreferredWidth(150);
        this.JTDetalleGastosNuevoFormato.getColumnModel().getColumn(17).setPreferredWidth(150);
        this.JTDetalleGastosNuevoFormato.getColumnModel().getColumn(18).setPreferredWidth(150);
        this.JTDetalleGastosNuevoFormato.getColumnModel().getColumn(19).setPreferredWidth(150);
        this.JTDetalleGastosNuevoFormato.getColumnModel().getColumn(20).setPreferredWidth(150);
        this.JTDetalleGastosNuevoFormato.getColumnModel().getColumn(21).setPreferredWidth(150);
        this.JTDetalleGastosNuevoFormato.getColumnModel().getColumn(22).setPreferredWidth(150);
        this.JTDetalleGastosNuevoFormato.getColumnModel().getColumn(23).setPreferredWidth(150);
        this.JTDetalleGastosNuevoFormato.getColumnModel().getColumn(24).setPreferredWidth(150);
        this.JTDetalleGastosNuevoFormato.getColumnModel().getColumn(25).setPreferredWidth(150);
        this.JTDetalleGastosNuevoFormato.getColumnModel().getColumn(26).setPreferredWidth(150);
        this.JTDetalleGastosNuevoFormato.getColumnModel().getColumn(27).setPreferredWidth(150);
        this.JTDetalleGastosNuevoFormato.getColumnModel().getColumn(28).setPreferredWidth(150);
        this.JTDetalleGastosNuevoFormato.getColumnModel().getColumn(29).setPreferredWidth(150);
        this.JTDetalleGastosNuevoFormato.getColumnModel().getColumn(30).setPreferredWidth(150);
        this.JTDetalleGastosNuevoFormato.getColumnModel().getColumn(31).setPreferredWidth(150);
        this.JTDetalleGastosNuevoFormato.getColumnModel().getColumn(32).setPreferredWidth(150);
        this.JTDetalleGastosNuevoFormato.getColumnModel().getColumn(33).setPreferredWidth(150);
        this.JTDetalleGastosNuevoFormato.getColumnModel().getColumn(34).setPreferredWidth(150);
        this.JTDetalleGastosNuevoFormato.getColumnModel().getColumn(35).setPreferredWidth(150);
        this.JTDetalleGastosNuevoFormato.getColumnModel().getColumn(36).setPreferredWidth(150);
        this.JTDetalleGastosNuevoFormato.getColumnModel().getColumn(37).setPreferredWidth(150);
        this.JTDetalleGastosNuevoFormato.getColumnModel().getColumn(38).setPreferredWidth(150);
        this.JTDetalleGastosNuevoFormato.getColumnModel().getColumn(39).setPreferredWidth(150);
        this.JTDetalleGastosNuevoFormato.getColumnModel().getColumn(40).setPreferredWidth(150);
        this.JTDetalleGastosNuevoFormato.getColumnModel().getColumn(41).setPreferredWidth(150);
        this.JTDetalleGastosNuevoFormato.getColumnModel().getColumn(42).setPreferredWidth(150);
        this.JTDetalleGastosNuevoFormato.getColumnModel().getColumn(43).setPreferredWidth(150);
        this.JTDetalleGastosNuevoFormato.getColumnModel().getColumn(44).setPreferredWidth(150);
        this.JTDetalleGastosNuevoFormato.getColumnModel().getColumn(45).setPreferredWidth(150);
    }

    private void llenarTablaGastoNuevoFormato() {
        crearModeloGastoNuevoFormato();
        this.listaGastos = (List) this.listaEjecucionNueva.stream().filter(p -> {
            return p.getTipoRubro().equals("G");
        }).collect(Collectors.toList());
        this.listaGastos.forEach(e -> {
            this.modeloGastoNuevo.addRow(this.datoG);
            this.modeloGastoNuevo.setValueAt(e.getCodigoRubro(), this.JTDetalleGastosNuevoFormato.getRowCount() - 1, 0);
            this.modeloGastoNuevo.setValueAt(e.getCodigoPadre(), this.JTDetalleGastosNuevoFormato.getRowCount() - 1, 1);
            this.modeloGastoNuevo.setValueAt(e.getNombreRubro(), this.JTDetalleGastosNuevoFormato.getRowCount() - 1, 2);
            this.modeloGastoNuevo.setValueAt(e.getCodigoAlterno(), this.JTDetalleGastosNuevoFormato.getRowCount() - 1, 3);
            this.modeloGastoNuevo.setValueAt(e.getNivel(), this.JTDetalleGastosNuevoFormato.getRowCount() - 1, 4);
            this.modeloGastoNuevo.setValueAt(e.getCodigoCpc(), this.JTDetalleGastosNuevoFormato.getRowCount() - 1, 5);
            this.modeloGastoNuevo.setValueAt(e.getNombreCpc(), this.JTDetalleGastosNuevoFormato.getRowCount() - 1, 6);
            this.modeloGastoNuevo.setValueAt(e.getCodigoFuenteFinanciacion(), this.JTDetalleGastosNuevoFormato.getRowCount() - 1, 7);
            this.modeloGastoNuevo.setValueAt(e.getNombreFuenteFinanciacion(), this.JTDetalleGastosNuevoFormato.getRowCount() - 1, 8);
            this.modeloGastoNuevo.setValueAt(e.getNombreCentroCosto(), this.JTDetalleGastosNuevoFormato.getRowCount() - 1, 9);
            this.modeloGastoNuevo.setValueAt(e.getNombreVigencia(), this.JTDetalleGastosNuevoFormato.getRowCount() - 1, 10);
            this.modeloGastoNuevo.setValueAt(e.getPresupuestoInicial(), this.JTDetalleGastosNuevoFormato.getRowCount() - 1, 11);
            this.modeloGastoNuevo.setValueAt(e.getAdicionPresupuesto(), this.JTDetalleGastosNuevoFormato.getRowCount() - 1, 12);
            this.modeloGastoNuevo.setValueAt(e.getReduccionPresupuesto(), this.JTDetalleGastosNuevoFormato.getRowCount() - 1, 13);
            this.modeloGastoNuevo.setValueAt(e.getTrasladosDebitos(), this.JTDetalleGastosNuevoFormato.getRowCount() - 1, 14);
            this.modeloGastoNuevo.setValueAt(e.getTrasladosCreditos(), this.JTDetalleGastosNuevoFormato.getRowCount() - 1, 15);
            this.modeloGastoNuevo.setValueAt(e.getPresupuestoDefinitivo(), this.JTDetalleGastosNuevoFormato.getRowCount() - 1, 16);
            this.modeloGastoNuevo.setValueAt(e.getReconocimientoAnterior(), this.JTDetalleGastosNuevoFormato.getRowCount() - 1, 17);
            this.modeloGastoNuevo.setValueAt(e.getReconocimientoActual(), this.JTDetalleGastosNuevoFormato.getRowCount() - 1, 18);
            this.modeloGastoNuevo.setValueAt(e.getReconocimientoTotal(), this.JTDetalleGastosNuevoFormato.getRowCount() - 1, 19);
            this.modeloGastoNuevo.setValueAt(e.getRecaudoAnterior(), this.JTDetalleGastosNuevoFormato.getRowCount() - 1, 20);
            this.modeloGastoNuevo.setValueAt(e.getRecaudoActual(), this.JTDetalleGastosNuevoFormato.getRowCount() - 1, 21);
            this.modeloGastoNuevo.setValueAt(e.getRecaudoTotal(), this.JTDetalleGastosNuevoFormato.getRowCount() - 1, 22);
            this.modeloGastoNuevo.setValueAt(e.getSaldoPorEjecutar(), this.JTDetalleGastosNuevoFormato.getRowCount() - 1, 23);
            this.modeloGastoNuevo.setValueAt(e.getSaldoPorRecaudar(), this.JTDetalleGastosNuevoFormato.getRowCount() - 1, 24);
            this.modeloGastoNuevo.setValueAt(e.getCertificadoAnterior(), this.JTDetalleGastosNuevoFormato.getRowCount() - 1, 25);
            this.modeloGastoNuevo.setValueAt(e.getCertificadoActual(), this.JTDetalleGastosNuevoFormato.getRowCount() - 1, 26);
            this.modeloGastoNuevo.setValueAt(e.getReintegrosCertificado(), this.JTDetalleGastosNuevoFormato.getRowCount() - 1, 27);
            this.modeloGastoNuevo.setValueAt(e.getTotalCertificados(), this.JTDetalleGastosNuevoFormato.getRowCount() - 1, 28);
            this.modeloGastoNuevo.setValueAt(e.getCompromisoAnterior(), this.JTDetalleGastosNuevoFormato.getRowCount() - 1, 29);
            this.modeloGastoNuevo.setValueAt(e.getCompromisoActual(), this.JTDetalleGastosNuevoFormato.getRowCount() - 1, 30);
            this.modeloGastoNuevo.setValueAt(e.getReintegroCompromiso(), this.JTDetalleGastosNuevoFormato.getRowCount() - 1, 31);
            this.modeloGastoNuevo.setValueAt(e.getCompromisoTotal(), this.JTDetalleGastosNuevoFormato.getRowCount() - 1, 32);
            this.modeloGastoNuevo.setValueAt(e.getObligacionAnterior(), this.JTDetalleGastosNuevoFormato.getRowCount() - 1, 33);
            this.modeloGastoNuevo.setValueAt(e.getObligacionActual(), this.JTDetalleGastosNuevoFormato.getRowCount() - 1, 34);
            this.modeloGastoNuevo.setValueAt(e.getReintegroObligacion(), this.JTDetalleGastosNuevoFormato.getRowCount() - 1, 35);
            this.modeloGastoNuevo.setValueAt(e.getTotalObligacion(), this.JTDetalleGastosNuevoFormato.getRowCount() - 1, 36);
            this.modeloGastoNuevo.setValueAt(e.getPagoAnterior(), this.JTDetalleGastosNuevoFormato.getRowCount() - 1, 37);
            this.modeloGastoNuevo.setValueAt(e.getPagoActual(), this.JTDetalleGastosNuevoFormato.getRowCount() - 1, 38);
            this.modeloGastoNuevo.setValueAt(e.getTotalPago(), this.JTDetalleGastosNuevoFormato.getRowCount() - 1, 39);
            this.modeloGastoNuevo.setValueAt(e.getSaldoDisponible(), this.JTDetalleGastosNuevoFormato.getRowCount() - 1, 40);
            this.modeloGastoNuevo.setValueAt(e.getSinComprometer(), this.JTDetalleGastosNuevoFormato.getRowCount() - 1, 41);
            this.modeloGastoNuevo.setValueAt(e.getCompromisoPorPagar(), this.JTDetalleGastosNuevoFormato.getRowCount() - 1, 42);
            this.modeloGastoNuevo.setValueAt(e.getCuentasPorPagar(), this.JTDetalleGastosNuevoFormato.getRowCount() - 1, 43);
            this.modeloGastoNuevo.setValueAt(e.getCertificadoSinComprometer(), this.JTDetalleGastosNuevoFormato.getRowCount() - 1, 44);
            this.modeloGastoNuevo.setValueAt(e.getCompromisoSinObligacion(), this.JTDetalleGastosNuevoFormato.getRowCount() - 1, 45);
        });
    }
}
