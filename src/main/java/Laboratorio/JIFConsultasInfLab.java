package Laboratorio;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.genoma.plus.jpa.projection.LRecepcionMuestrasRechazadasProjection;
import com.genoma.plus.jpa.projection.LRecepcionProcedimientoProjection;
import com.genoma.plus.jpa.projection.LRecepcionRegistroDiarioProjection;
import com.genoma.plus.jpa.projection.LRecepcionesAgrupadoProjection;
import com.genoma.plus.jpa.projection.LRecepcionesProfesionaProjection;
import com.genoma.plus.jpa.service.RecepcionService;
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
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
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

/* JADX INFO: loaded from: GenomaP.jar:Laboratorio/JIFConsultasInfLab.class */
public class JIFConsultasInfLab extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private DefaultTableModel xmodelo1;
    private DefaultTableModel xmodelo2;
    private DefaultTableModel xmodelo3;
    private DefaultTableModel xmodelorec;
    private Object[] xdatos;
    private String[] xidespecialidad;
    private String[] xidSede;
    private List<LRecepcionesAgrupadoProjection> listaRecepcionesAgrupadas;
    private List<LRecepcionesProfesionaProjection> listaRecepcionProfesional;
    private List<LRecepcionProcedimientoProjection> listaProcedimientosRecepcionados;
    private List<LRecepcionRegistroDiarioProjection> listaRegistroDiario;
    private List<LRecepcionMuestrasRechazadasProjection> listaMuestrasRechazadas;
    private ButtonGroup JBGFiltro;
    private ButtonGroup JBGSeleccion;
    private ButtonGroup JBGSeleccion1;
    private JButton JBTExportar;
    private JButton JBTExportarR;
    private JComboBox JCBEspecialidad;
    private JComboBox JCBSede;
    private JCheckBox JCHFiltroEspecialidad;
    private JCheckBox JCHFiltroSede;
    private JDateChooser JDFechaF;
    private JDateChooser JDFechaI;
    private JPanel JPIAgrupado;
    private JPanel JPIAgrupadoPProfes;
    private JPanel JPIAgrupadoProced;
    private JPanel JPIDatos;
    private JPanel JPIRegistroD;
    private JRadioButton JRBMuestraN;
    private JRadioButton JRBNormal;
    private JRadioButton JRBTodo;
    private JScrollPane JSPDetalle;
    private JScrollPane JSPDetalle1;
    private JScrollPane JSPDetalle2;
    private JScrollPane JSPDetalle3;
    private JScrollPane JSPDetalle4;
    private JTable JTDetalle;
    private JTable JTDetalle1;
    private JTable JTDetalle2;
    private JTable JTDetalle3;
    private JTable JTDetalleRec;
    private JTextField JTFRuta;
    private JTabbedPane JTPDatosA;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private ConsultasMySQL xconsulta = new ConsultasMySQL();
    private Metodos xmt = new Metodos();
    private boolean xllenoc = false;
    private final RecepcionService recepcionService = (RecepcionService) Principal.contexto.getBean(RecepcionService.class);
    private List<Integer> xFiltro = new ArrayList();
    private Long idSede = -1L;
    private Long idEspecialidad = -1L;

    public JIFConsultasInfLab(String nombre, String xtitulo) {
        initComponents();
        setTitle(xtitulo.toUpperCase());
        setName(nombre);
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v41, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v50, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v59, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v79, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v93, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGSeleccion = new ButtonGroup();
        this.JBGSeleccion1 = new ButtonGroup();
        this.JBGFiltro = new ButtonGroup();
        this.JPIDatos = new JPanel();
        this.JDFechaI = new JDateChooser();
        this.JDFechaF = new JDateChooser();
        this.JCBEspecialidad = new JComboBox();
        this.JCHFiltroEspecialidad = new JCheckBox();
        this.jPanel3 = new JPanel();
        this.JRBTodo = new JRadioButton();
        this.JRBMuestraN = new JRadioButton();
        this.JRBNormal = new JRadioButton();
        this.JTPDatosA = new JTabbedPane();
        this.JPIAgrupado = new JPanel();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JPIAgrupadoPProfes = new JPanel();
        this.JSPDetalle1 = new JScrollPane();
        this.JTDetalle1 = new JTable();
        this.JPIAgrupadoProced = new JPanel();
        this.JSPDetalle2 = new JScrollPane();
        this.JTDetalle2 = new JTable();
        this.JBTExportarR = new JButton();
        this.JPIRegistroD = new JPanel();
        this.JSPDetalle3 = new JScrollPane();
        this.JTDetalle3 = new JTable();
        this.jPanel2 = new JPanel();
        this.JSPDetalle4 = new JScrollPane();
        this.JTDetalleRec = new JTable();
        this.JCHFiltroSede = new JCheckBox();
        this.JCBSede = new JComboBox();
        this.jPanel1 = new JPanel();
        this.JBTExportar = new JButton();
        this.JTFRuta = new JTextField();
        setClosable(true);
        setIconifiable(true);
        setTitle("INFORME DE RECEPCIÓN ");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setMaximumSize(null);
        setName("jifconsinformelab");
        try {
            setSelected(true);
        } catch (PropertyVetoException e1) {
            e1.printStackTrace();
        }
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JDFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicial", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFechaI.setFont(new Font("Arial", 1, 12));
        this.JDFechaI.addPropertyChangeListener(new PropertyChangeListener() { // from class: Laboratorio.JIFConsultasInfLab.1
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFConsultasInfLab.this.JDFechaIPropertyChange(evt);
            }
        });
        this.JDFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Final", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFechaF.setFont(new Font("Arial", 1, 12));
        this.JDFechaF.addPropertyChangeListener(new PropertyChangeListener() { // from class: Laboratorio.JIFConsultasInfLab.2
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFConsultasInfLab.this.JDFechaFPropertyChange(evt);
            }
        });
        this.JCBEspecialidad.setFont(new Font("Arial", 1, 12));
        this.JCBEspecialidad.setBorder(BorderFactory.createTitledBorder((Border) null, "Especialidad", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHFiltroEspecialidad.setFont(new Font("Arial", 1, 12));
        this.JCHFiltroEspecialidad.setText("Filtro por Especialidad");
        this.JCHFiltroEspecialidad.addActionListener(new ActionListener() { // from class: Laboratorio.JIFConsultasInfLab.3
            public void actionPerformed(ActionEvent evt) {
                JIFConsultasInfLab.this.JCHFiltroEspecialidadActionPerformed(evt);
            }
        });
        this.jPanel3.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo de Muestra", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBGFiltro.add(this.JRBTodo);
        this.JRBTodo.setFont(new Font("Arial", 1, 12));
        this.JRBTodo.setText("Todo");
        this.JRBTodo.addActionListener(new ActionListener() { // from class: Laboratorio.JIFConsultasInfLab.4
            public void actionPerformed(ActionEvent evt) {
                JIFConsultasInfLab.this.JRBTodoActionPerformed(evt);
            }
        });
        this.JBGFiltro.add(this.JRBMuestraN);
        this.JRBMuestraN.setFont(new Font("Arial", 1, 12));
        this.JRBMuestraN.setText("Muestra Nueva");
        this.JRBMuestraN.addActionListener(new ActionListener() { // from class: Laboratorio.JIFConsultasInfLab.5
            public void actionPerformed(ActionEvent evt) {
                JIFConsultasInfLab.this.JRBMuestraNActionPerformed(evt);
            }
        });
        this.JBGFiltro.add(this.JRBNormal);
        this.JRBNormal.setFont(new Font("Arial", 1, 12));
        this.JRBNormal.setText("Normal");
        this.JRBNormal.addActionListener(new ActionListener() { // from class: Laboratorio.JIFConsultasInfLab.6
            public void actionPerformed(ActionEvent evt) {
                JIFConsultasInfLab.this.JRBNormalActionPerformed(evt);
            }
        });
        GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
        this.jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addComponent(this.JRBTodo).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBNormal).addGap(18, 18, 18).addComponent(this.JRBMuestraN).addContainerGap(-1, 32767)));
        jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap(-1, 32767).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBTodo).addComponent(this.JRBMuestraN).addComponent(this.JRBNormal))));
        this.JTPDatosA.setForeground(new Color(0, 103, 0));
        this.JTPDatosA.setFont(new Font("Arial", 1, 14));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalle.setSelectionMode(0);
        this.JSPDetalle.setViewportView(this.JTDetalle);
        GroupLayout JPIAgrupadoLayout = new GroupLayout(this.JPIAgrupado);
        this.JPIAgrupado.setLayout(JPIAgrupadoLayout);
        JPIAgrupadoLayout.setHorizontalGroup(JPIAgrupadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIAgrupadoLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPDetalle, -1, 980, 32767).addContainerGap()));
        JPIAgrupadoLayout.setVerticalGroup(JPIAgrupadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIAgrupadoLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPDetalle, -1, 370, 32767).addContainerGap()));
        this.JTPDatosA.addTab("AGRUPADO", this.JPIAgrupado);
        this.JTDetalle1.setFont(new Font("Arial", 1, 12));
        this.JTDetalle1.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle1.setRowHeight(25);
        this.JTDetalle1.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle1.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalle1.setSelectionMode(0);
        this.JSPDetalle1.setViewportView(this.JTDetalle1);
        GroupLayout JPIAgrupadoPProfesLayout = new GroupLayout(this.JPIAgrupadoPProfes);
        this.JPIAgrupadoPProfes.setLayout(JPIAgrupadoPProfesLayout);
        JPIAgrupadoPProfesLayout.setHorizontalGroup(JPIAgrupadoPProfesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIAgrupadoPProfesLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPDetalle1, -1, 980, 32767).addContainerGap()));
        JPIAgrupadoPProfesLayout.setVerticalGroup(JPIAgrupadoPProfesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIAgrupadoPProfesLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPDetalle1, -1, 370, 32767).addContainerGap()));
        this.JTPDatosA.addTab("PROFESIONAL", this.JPIAgrupadoPProfes);
        this.JTDetalle2.setFont(new Font("Arial", 1, 12));
        this.JTDetalle2.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle2.setRowHeight(25);
        this.JTDetalle2.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle2.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalle2.setSelectionMode(0);
        this.JTDetalle2.addMouseListener(new MouseAdapter() { // from class: Laboratorio.JIFConsultasInfLab.7
            public void mouseClicked(MouseEvent evt) {
                JIFConsultasInfLab.this.JTDetalle2MouseClicked(evt);
            }
        });
        this.JSPDetalle2.setViewportView(this.JTDetalle2);
        this.JBTExportarR.setFont(new Font("Arial", 1, 12));
        this.JBTExportarR.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTExportarR.setText("Exportar Resultados");
        this.JBTExportarR.addActionListener(new ActionListener() { // from class: Laboratorio.JIFConsultasInfLab.8
            public void actionPerformed(ActionEvent evt) {
                JIFConsultasInfLab.this.JBTExportarRActionPerformed(evt);
            }
        });
        GroupLayout JPIAgrupadoProcedLayout = new GroupLayout(this.JPIAgrupadoProced);
        this.JPIAgrupadoProced.setLayout(JPIAgrupadoProcedLayout);
        JPIAgrupadoProcedLayout.setHorizontalGroup(JPIAgrupadoProcedLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIAgrupadoProcedLayout.createSequentialGroup().addContainerGap().addGroup(JPIAgrupadoProcedLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPDetalle2, -1, 980, 32767).addGroup(JPIAgrupadoProcedLayout.createSequentialGroup().addComponent(this.JBTExportarR, -2, 225, -2).addGap(0, 0, 32767))).addContainerGap()));
        JPIAgrupadoProcedLayout.setVerticalGroup(JPIAgrupadoProcedLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIAgrupadoProcedLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPDetalle2, -1, 318, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBTExportarR, -2, 40, -2).addContainerGap()));
        this.JTPDatosA.addTab("PROCEDIMIENTO", this.JPIAgrupadoProced);
        this.JTDetalle3.setFont(new Font("Arial", 1, 12));
        this.JTDetalle3.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle3.setRowHeight(25);
        this.JTDetalle3.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle3.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalle3.addMouseListener(new MouseAdapter() { // from class: Laboratorio.JIFConsultasInfLab.9
            public void mouseClicked(MouseEvent evt) {
                JIFConsultasInfLab.this.JTDetalle3MouseClicked(evt);
            }
        });
        this.JSPDetalle3.setViewportView(this.JTDetalle3);
        GroupLayout JPIRegistroDLayout = new GroupLayout(this.JPIRegistroD);
        this.JPIRegistroD.setLayout(JPIRegistroDLayout);
        JPIRegistroDLayout.setHorizontalGroup(JPIRegistroDLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIRegistroDLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPDetalle3, -1, 980, 32767).addContainerGap()));
        JPIRegistroDLayout.setVerticalGroup(JPIRegistroDLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIRegistroDLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPDetalle3, -1, 370, 32767).addContainerGap()));
        this.JTPDatosA.addTab("REGISTRO DIARIO", this.JPIRegistroD);
        this.JSPDetalle4.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.JTDetalleRec.setFont(new Font("Arial", 1, 12));
        this.JTDetalleRec.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalleRec.setRowHeight(25);
        this.JTDetalleRec.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalleRec.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalleRec.setSelectionMode(0);
        this.JSPDetalle4.setViewportView(this.JTDetalleRec);
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(this.JSPDetalle4, -1, 980, 32767).addContainerGap()));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(this.JSPDetalle4, -1, 370, 32767).addContainerGap()));
        this.JTPDatosA.addTab("MUESTRAS RECHAZADAS", this.jPanel2);
        this.JCHFiltroSede.setFont(new Font("Arial", 1, 12));
        this.JCHFiltroSede.setText("Filtro por Sede");
        this.JCHFiltroSede.addActionListener(new ActionListener() { // from class: Laboratorio.JIFConsultasInfLab.10
            public void actionPerformed(ActionEvent evt) {
                JIFConsultasInfLab.this.JCHFiltroSedeActionPerformed(evt);
            }
        });
        this.JCBSede.setFont(new Font("Arial", 1, 12));
        this.JCBSede.setBorder(BorderFactory.createTitledBorder((Border) null, "Sede", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JDFechaI, -2, 120, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JDFechaF, -2, 120, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHFiltroEspecialidad).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBEspecialidad, -2, 253, -2).addGap(58, 58, 58).addComponent(this.jPanel3, -2, -1, -2)).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addComponent(this.JTPDatosA, -2, 0, 32767))).addContainerGap()).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addComponent(this.JCHFiltroSede).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBSede, -2, 253, -2).addGap(634, 634, 634)));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jPanel3, -2, -1, -2).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBEspecialidad, -2, 50, -2).addComponent(this.JCHFiltroEspecialidad)).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JDFechaI, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.JDFechaF, GroupLayout.Alignment.LEADING, -1, 50, 32767)))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBSede, -2, 50, -2).addComponent(this.JCHFiltroSede)).addGap(10, 10, 10).addComponent(this.JTPDatosA).addContainerGap()));
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS PARA EXPORTAR", 0, 0, new Font("Arial", 1, 14), Color.red));
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: Laboratorio.JIFConsultasInfLab.11
            public void actionPerformed(ActionEvent evt) {
                JIFConsultasInfLab.this.JBTExportarActionPerformed(evt);
            }
        });
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\genoma\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: Laboratorio.JIFConsultasInfLab.12
            public void mouseClicked(MouseEvent evt) {
                JIFConsultasInfLab.this.JTFRutaMouseClicked(evt);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addComponent(this.JTFRuta).addGap(18, 18, 18).addComponent(this.JBTExportar, -2, 161, -2).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JBTExportar, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.JTFRuta, -2, 50, -2)).addContainerGap()));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPIDatos, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addComponent(this.jPanel1, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.jPanel1, -2, -1, -2).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaIPropertyChange(PropertyChangeEvent evt) {
        if (this.xllenoc) {
            mLLenarCEspecialidad();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaFPropertyChange(PropertyChangeEvent evt) {
        if (this.xllenoc) {
            mLLenarCEspecialidad();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHFiltroEspecialidadActionPerformed(ActionEvent evt) {
        if (this.JCHFiltroEspecialidad.isSelected()) {
            this.JCBEspecialidad.setEnabled(true);
            mLLenarCEspecialidad();
        } else {
            this.JCBEspecialidad.setEnabled(false);
            this.JCBEspecialidad.setSelectedIndex(-1);
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
        if (this.JTPDatosA.getSelectedIndex() == 3) {
            this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTDetalle3, this.JTFRuta.getText(), getTitle());
        } else {
            mExportar();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalle2MouseClicked(MouseEvent evt) {
        if (this.JTDetalle2.getSelectedRow() != -1 && this.JTDetalle2.getSelectedColumn() != 4) {
            String[][] parametros = new String[5][2];
            parametros[0][0] = "fechai";
            parametros[0][1] = this.xmt.formatoAMD.format(this.JDFechaI.getDate());
            parametros[1][0] = "fechaf";
            parametros[1][1] = this.xmt.formatoAMD.format(this.JDFechaF.getDate());
            parametros[2][0] = "id";
            parametros[2][1] = this.xmodelo2.getValueAt(this.JTDetalle2.getSelectedRow(), 0).toString();
            parametros[3][0] = "SUBREPORT_DIR";
            parametros[3][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
            parametros[4][0] = "SUBREPORTFIRMA_DIR";
            parametros[4][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
            Object[] botones = {"Procedimiento", "Resultado", "Cerrar"};
            int n = JOptionPane.showInternalOptionDialog(this, "Que desea hacer?", "IMPRIMIR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), botones, "Cerrar");
            if (n == 0) {
                this.xmt.GenerarPDF(this.xmt.getRutaRep() + "L_Usuario_Procedimiento", parametros);
            } else if (n == 1) {
                this.xmt.GenerarPDF(this.xmt.getRutaRep() + "L_Usuario_Procedimiento_Resultado", parametros);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTExportarRActionPerformed(ActionEvent evt) {
        String xcodigopro = "";
        for (int x = 0; x < this.JTDetalle2.getRowCount(); x++) {
            try {
                if (Boolean.valueOf(this.xmodelo2.getValueAt(x, 4).toString()).booleanValue()) {
                    xcodigopro = xcodigopro + "," + this.xmodelo2.getValueAt(x, 0).toString();
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(JIFConsultasInfLab.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                return;
            }
        }
        String xsql = " SELECT \ngp.Id_TipoIdentificacion AS 'TIPO DE IDENTIFICACION',\ngp.NoDocumento 'NUMERO DE DOCUMENTO',\nCONCAT(gp.Apellido1,' ', gp.Apellido2,' ', gp.Nombre1,' ', gp.Nombre2) AS 'NOMBRE DE USUARIO',\ngp.Apellido1 AS 'PRIMER APELLIDO',\ngp.Apellido2 AS 'SEGUNDO APELLIDO',\ngp.Nombre1 AS 'PRIMER NOMBRE',\ngp.Nombre2 AS 'SEGUNDO NOMBRE',\ngm.Nbre AS 'MUNICIPIO',\ngp.Direccion AS 'DIRECCION',\ngb.Nbre AS 'BARRIO',\ngp.Telefono AS 'TELEFONO',\ngp.Movil AS 'CELULAR',\ngp.FechaNac 'FECHA DE NACIMIENTO',\ngp.Edad AS 'EDAD',\ngt.Id AS 'TIPO EDAD',\nCONCAT(gp.Edad,' ',gt.Nbre,'(s)') AS 'EDAD',\ngp.Id_Sexo AS 'SEXO',\nlr.FechaResult AS 'FECHA DE RESULTADO' ,\ngp2.Id AS 'CODIGO CUPS',\ngp2.Nbre AS 'NOMBRE DEL PROCEDIMIENTO',\nlp2.Nbre AS 'NOMBRE DEL PROTOCOLO',\nld.VrNumerico AS 'RESULTADO',\nld.VReferencia1 AS 'VALOR DE REFERENCIA 1' ,\nld.VReferencia2 AS 'VALOR DE REFERENCIA 2',\nIF(ld.Observacion IS NULL,'',ld.Observacion) AS 'OBSERVACION' ,\nIF(ld.Alterado=0, 'NO','SI') AS 'ES ALTERADO' ,\nge2.Nbre AS 'EPS',\nlr2.Peso AS 'PESO',\nlr2.Talla AS 'TALLA',\nlr2.PAbdominal AS 'PERIMETRO ABDOMINAL',\nlr2.Imc AS 'IMC',\nlr2.SCorporal AS 'SCORPORAL',\nIF(gu.Id_Programa IS NULL,'NO APLICA',IF(gu.Id_Programa = 3,'SI','NO APLICA')) EMBARAZADA ,\nfe.Nbre AS 'CONVENIO EMPRESA'\nFROM l_detalleresultado ld \nINNER JOIN l_resultados lr ON (lr.Id=Id_Resultado)\nINNER JOIN l_recepcion lr2 ON (lr2.Id=lr.Id_Recepcion)\nINNER JOIN l_protocoloxprocedimiento lp ON (lp.Id=ld.Id_ProtocolProcedim)\nINNER JOIN l_protocolos lp2 ON (lp2.Id=lp.Id_Protocolo)\nINNER JOIN g_persona gp ON (gp.Id = lr2.Id_Paciente)\nINNER JOIN g_tipoedad gt ON (gt.Id=gp.Id_TipoEdad)\nINNER JOIN g_municipio gm ON (gm.Id=gp.Id_MunicipioNac)\nINNER JOIN g_barrio gb ON (gb.Id=gp.Id_Barrio)\nINNER JOIN g_procedimiento gp2 ON (gp2.Id=lp.Id_Procedim)\nINNER JOIN l_tiporesultado lt ON (lt.Id=ld.Resultado)\nINNER JOIN f_empresacontxconvenio fe ON (fe.Id=lr2.Id_EmpresaConv)\nINNER JOIN g_usuario gu2 ON (gu2.Id_persona=gp.Id)\nINNER JOIN g_empresacont ge ON (ge.Id_empresa = gu2.Id_EmpresaCont)\nINNER JOIN g_empresa ge2 ON (ge2.Id=ge.Id_empresa)\nLEFT JOIN g_usuarioxprograma gu ON (gu.Id_Usuario = lr2.Id_Paciente)\n\tAND (gu.Id_Programa = 3)\n\tAND (gu.Estado = 0)WHERE\n\t(lr.FechaResult  BETWEEN '" + this.xmt.formatoAMD1.format(this.JDFechaI.getDate()) + "' AND '" + this.xmt.formatoAMD1.format(this.JDFechaF.getDate()) + "'\n\t\tAND lr.Estado =0\n\t\tAND gp2.Id IN(" + xcodigopro.substring(1, xcodigopro.length()) + "))\nORDER BY\ngp.NoDocumento ASC, \nlr.FechaResult ASC,\ngp2.Id ASC";
        System.out.println("consulta -> " + xsql);
        this.xmt.mExportar_Datos_Formato_Consulta(xsql, this.JTFRuta.getText(), "Resultados");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalle3MouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHFiltroSedeActionPerformed(ActionEvent evt) {
        if (this.JCHFiltroSede.isSelected()) {
            this.JCBSede.setEnabled(true);
            mLLenarSede();
        } else {
            this.JCBSede.setEnabled(false);
            this.JCBSede.setSelectedIndex(-1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBTodoActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBNormalActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBMuestraNActionPerformed(ActionEvent evt) {
    }

    public void mImprimir() {
        String[][] mparametros = new String[4][2];
        mparametros[0][0] = "fechai";
        mparametros[0][1] = this.xmt.formatoAMD1.format(this.JDFechaI.getDate());
        mparametros[1][0] = "fechaf";
        mparametros[1][1] = this.xmt.formatoAMD1.format(this.JDFechaF.getDate());
        mparametros[2][0] = "SUBREPORT_DIR";
        mparametros[2][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
        mparametros[3][0] = "SUBREPORTFIRMA_DIR";
        mparametros[3][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
        Object[] botones = {"Registro Diario", "Registro Diario por Municipio", "Cerrar"};
        int y = JOptionPane.showInternalOptionDialog(this, "Como desea visualizar en informe?", "VISUALIZAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), botones, "Cerrar");
        if (y == 0) {
            this.xmt.GenerarPDF(this.xmt.getRutaRep() + "L_Registro_Diario", mparametros);
        } else {
            this.xmt.GenerarPDF(this.xmt.getRutaRep() + "L_Registro_Diario_AMunicipio", mparametros);
        }
    }

    public void mBuscar() {
        this.xFiltro = new ArrayList();
        if (this.JRBTodo.isSelected()) {
            this.xFiltro.add(0);
            this.xFiltro.add(1);
        } else if (this.JRBNormal.isSelected()) {
            this.xFiltro.add(0);
        } else if (this.JRBMuestraN.isSelected()) {
            this.xFiltro.add(1);
        }
        if (this.JCHFiltroEspecialidad.isSelected()) {
            if (this.JCBEspecialidad.getSelectedIndex() != -1) {
                mCargarDatosTabla();
                mCargarDatosTabla1();
                mCargarDatosTabla2();
                return;
            }
            return;
        }
        mCargarDatosTabla();
        mCargarDatosTabla1();
        mCargarDatosTabla2();
        mCargarDatosTabla3();
        mCargarDatosRech();
    }

    private void mExportar() {
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            try {
                WritableWorkbook workbook = Workbook.createWorkbook(new File(this.JTFRuta.getText() + ".xls"));
                WritableSheet sheet = workbook.createSheet("Consolidado", 0);
                for (int x = 0; x < this.JTDetalle.getColumnCount(); x++) {
                    sheet.addCell(new Label(x, 0, this.JTDetalle.getColumnName(x)));
                }
                for (int x2 = 0; x2 < this.JTDetalle.getRowCount(); x2++) {
                    sheet.addCell(new Label(0, x2 + 1, this.xmodelo.getValueAt(x2, 0).toString()));
                    sheet.addCell(new Number(1, x2 + 1, Long.valueOf(this.xmodelo.getValueAt(x2, 1).toString()).longValue()));
                    sheet.addCell(new Number(2, x2 + 1, Long.valueOf(this.xmodelo.getValueAt(x2, 2).toString()).longValue()));
                    sheet.addCell(new Number(3, x2 + 1, Double.valueOf(this.xmodelo.getValueAt(x2, 3).toString()).doubleValue()));
                }
                WritableSheet sheet2 = workbook.createSheet("CProfesional", 1);
                for (int x3 = 0; x3 < this.JTDetalle1.getColumnCount(); x3++) {
                    sheet2.addCell(new Label(x3, 0, this.JTDetalle1.getColumnName(x3)));
                }
                for (int x4 = 0; x4 < this.JTDetalle1.getRowCount(); x4++) {
                    sheet2.addCell(new Label(0, x4 + 1, this.xmodelo1.getValueAt(x4, 0).toString()));
                    sheet2.addCell(new Label(1, x4 + 1, this.xmodelo1.getValueAt(x4, 1).toString()));
                    sheet2.addCell(new Number(2, x4 + 1, Long.valueOf(this.xmodelo1.getValueAt(x4, 2).toString()).longValue()));
                    sheet2.addCell(new Number(3, x4 + 1, Long.valueOf(this.xmodelo1.getValueAt(x4, 3).toString()).longValue()));
                    sheet2.addCell(new Number(4, x4 + 1, Double.valueOf(this.xmodelo1.getValueAt(x4, 4).toString()).doubleValue()));
                }
                WritableSheet sheet3 = workbook.createSheet("CProcedimiento", 2);
                for (int x5 = 0; x5 < this.JTDetalle2.getColumnCount(); x5++) {
                    sheet3.addCell(new Label(x5, 0, this.JTDetalle2.getColumnName(x5)));
                }
                for (int x6 = 0; x6 < this.JTDetalle2.getRowCount(); x6++) {
                    sheet3.addCell(new Label(0, x6 + 1, this.xmodelo2.getValueAt(x6, 0).toString()));
                    sheet3.addCell(new Label(1, x6 + 1, this.xmodelo2.getValueAt(x6, 1).toString()));
                    sheet3.addCell(new Number(2, x6 + 1, Long.valueOf(this.xmodelo2.getValueAt(x6, 2).toString()).longValue()));
                    sheet3.addCell(new Label(3, x6 + 1, this.xmodelo2.getValueAt(x6, 3).toString()));
                }
                WritableSheet sheet4 = workbook.createSheet("MuestrasRechazadas", 3);
                for (int x7 = 0; x7 < this.JTDetalleRec.getColumnCount(); x7++) {
                    sheet4.addCell(new Label(x7, 0, this.JTDetalleRec.getColumnName(x7)));
                }
                for (int x8 = 0; x8 < this.JTDetalleRec.getRowCount(); x8++) {
                    sheet4.addCell(new Label(0, x8 + 1, this.xmodelorec.getValueAt(x8, 0).toString()));
                    sheet4.addCell(new Label(1, x8 + 1, this.xmodelorec.getValueAt(x8, 1).toString()));
                    sheet4.addCell(new Number(2, x8 + 1, Long.valueOf(this.xmodelorec.getValueAt(x8, 2).toString()).longValue()));
                    sheet4.addCell(new Label(3, x8 + 1, this.xmodelorec.getValueAt(x8, 3).toString()));
                }
                workbook.write();
                workbook.close();
                this.xmt.mostrarPdf(this.JTFRuta.getText() + ".xls");
            } catch (IOException ex) {
                Logger.getLogger(JIFConsultasInfLab.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            } catch (WriteException e) {
                Logger.getLogger(JIFConsultasInfLab.class.getName()).log(Level.SEVERE, (String) null, e);
            }
        }
    }

    private void mExporta_Resultado() {
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            try {
                this.xmt.mEliminarArchivo(new File(this.JTFRuta.getText() + ".xls"));
                WritableWorkbook workbook = Workbook.createWorkbook(new File(this.JTFRuta.getText() + ".xls"));
                WritableSheet sheet = workbook.createSheet("Resultados", 0);
                String xcodigopro = "";
                for (int x = 0; x < this.JTDetalle2.getRowCount(); x++) {
                    if (Boolean.valueOf(this.xmodelo2.getValueAt(x, 4).toString()).booleanValue()) {
                        xcodigopro = xcodigopro + "," + this.xmodelo2.getValueAt(x, 0).toString();
                    }
                }
                String xsql = "SELECT \ngp.Id_TipoIdentificacion,\ngp.NoDocumento ,\nCONCAT(gp.Apellido1,' ', gp.Apellido2,' ', gp.Nombre1,' ', gp.Nombre2) AS NUsuario,\ngp.Apellido1,\ngp.Apellido2 ,\ngp.Nombre1 ,\ngp.Nombre2 ,\ngm.Nbre AS NMunicipio,\ngp.Direccion,\ngb.Nbre AS NBarrio,\ngp.Telefono ,\ngp.Movil AS celular,\ngp.FechaNac ,\ngp.Edad,\ngt.Id AS TipoEdad,\nCONCAT(gp.Edad,' ',gt.Nbre,'(s)') AS Edad,\ngp.Id_Sexo,\nlr.FechaResult AS FechaResultado ,\ngp2.Id AS Cups,\ngp2.Nbre AS NProcedimiento,\nlp2.Nbre AS NProtocolo,\nld.VrNumerico AS Resultado,\nld.VReferencia1 ,\nld.VReferencia2 ,\nIF(ld.Observacion IS NULL,'',ld.Observacion) AS Observacion ,\nIF(ld.Alterado=0, 'NO','SI') AS Alterado ,\nge2.Nbre AS Eps,\nlr2.Peso,\nlr2.Talla,\nlr2.PAbdominal,\nlr2.Imc,\nlr2.SCorporal,\nIF(gu.Id_Programa IS NULL,'NO APLICA',IF(gu.Id_Programa = 3,'SI','NO APLICA')) EMBARAZADA ,\nfe.Nbre AS EmpresaConvenio\nFROM l_detalleresultado ld \nINNER JOIN l_resultados lr ON (lr.Id=Id_Resultado)\nINNER JOIN l_recepcion lr2 ON (lr2.Id=lr.Id_Recepcion)\nINNER JOIN l_protocoloxprocedimiento lp ON (lp.Id=ld.Id_ProtocolProcedim)\nINNER JOIN l_protocolos lp2 ON (lp2.Id=lp.Id_Protocolo)\nINNER JOIN g_persona gp ON (gp.Id = lr2.Id_Paciente)\nINNER JOIN g_tipoedad gt ON (gt.Id=gp.Id_TipoEdad)\nINNER JOIN g_municipio gm ON (gm.Id=gp.Id_MunicipioNac)\nINNER JOIN g_barrio gb ON (gb.Id=gp.Id_Barrio)\nINNER JOIN g_procedimiento gp2 ON (gp2.Id=lp.Id_Procedim)\nINNER JOIN l_tiporesultado lt ON (lt.Id=ld.Resultado)\nINNER JOIN f_empresacontxconvenio fe ON (fe.Id=lr2.Id_EmpresaConv)\nINNER JOIN g_usuario gu2 ON (gu2.Id_persona=gp.Id)\nINNER JOIN g_empresacont ge ON (ge.Id_empresa = gu2.Id_EmpresaCont)\nINNER JOIN g_empresa ge2 ON (ge2.Id=ge.Id_empresa)\nLEFT JOIN g_usuarioxprograma gu ON (gu.Id_Usuario = lr2.Id_Paciente)\n\tAND (gu.Id_Programa = 3)\n\tAND (gu.Estado = 0)\nWHERE\n\t(lr.FechaResult  BETWEEN '" + this.xmt.formatoAMD1.format(this.JDFechaI.getDate()) + "' AND '" + this.xmt.formatoAMD1.format(this.JDFechaF.getDate()) + "'\n\t\tAND lr.Estado =0\n\t\tAND gp2.Id IN(" + xcodigopro.substring(1, xcodigopro.length()) + "))\nORDER BY\ngp.NoDocumento ASC, \nlr.FechaResult ASC,\ngp2.Id ASC";
                ResultSet rs = this.xconsulta.traerRs(xsql);
                ResultSetMetaData rsmd = rs.getMetaData();
                if (rs.next()) {
                    int xncolumna = rsmd.getColumnCount();
                    for (int i = 0; i < xncolumna; i++) {
                        sheet.addCell(new Label(i, 0, rsmd.getColumnName(i + 1)));
                    }
                    rs.beforeFirst();
                    int x2 = 1;
                    while (rs.next()) {
                        for (int i2 = 0; i2 < xncolumna; i2++) {
                            sheet.addCell(new Label(i2, x2, rs.getString(i2 + 1)));
                        }
                        x2++;
                    }
                }
                rs.close();
                this.xconsulta.cerrarConexionBd();
                workbook.write();
                workbook.close();
            } catch (IOException ex) {
                Logger.getLogger(JIFConsultasInfLab.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            } catch (SQLException ex2) {
                Logger.getLogger(JIFConsultasInfLab.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex2);
            } catch (WriteException e) {
                Logger.getLogger(JIFConsultasInfLab.class.getName()).log(Level.SEVERE, (String) null, e);
            }
        }
    }

    public void mNuevo() {
        this.JRBTodo.setSelected(true);
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
        this.JDFechaI.setDate(this.xmt.getFechaActual());
        this.JDFechaF.setDate(this.xmt.getFechaActual());
        if (getName().equals("jifconsinformelab1") || getName().equals("jifconsinformelab") || getName().equals("jifconsinformelab2")) {
            this.JCBEspecialidad.setEnabled(false);
            this.JCBSede.setEnabled(false);
            this.JCHFiltroEspecialidad.setSelected(false);
            this.JCHFiltroSede.setSelected(false);
            mCrearModeloDatos();
            mCrearModeloDatos1();
            mCrearModeloDatos2();
            mCrearModeloDatos3();
            mLLenarCEspecialidad();
        } else if (getName().equals("jifconsinformelab_eps")) {
            this.JTPDatosA.remove(3);
            this.JTPDatosA.remove(2);
            this.JTPDatosA.remove(1);
        }
        this.JDFechaI.requestFocus();
    }

    private void mLLenarCEspecialidad() {
        this.xllenoc = false;
        this.JCBEspecialidad.removeAllItems();
        String sql = "SELECT g_especialidad.Id, g_especialidad.Nbre FROM l_detallerecepcion INNER JOIN l_recepcion  ON (l_detallerecepcion.Id_Recepcion = l_recepcion.Id) INNER JOIN g_especialidad  ON (g_especialidad.Id = l_recepcion.Id_Especialidad) WHERE (DATE_FORMAT(FechaRecep,'%Y/%m/%d') >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND DATE_FORMAT(FechaRecep,'%Y/%m/%d') >='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' AND l_recepcion.Estado =0) GROUP BY g_especialidad.Id ORDER BY g_especialidad.Nbre ASC ";
        this.xidespecialidad = this.xconsulta.llenarCombo(sql, this.xidespecialidad, this.JCBEspecialidad);
        this.JCBEspecialidad.setSelectedIndex(-1);
        this.xconsulta.cerrarConexionBd();
        this.xllenoc = true;
    }

    private void mLLenarSede() {
        this.JCBSede.removeAllItems();
        this.xidSede = this.xconsulta.llenarCombo("SELECT gs.Id, gs.Nbre FROM g_sedes gs where gs.Estado=1", this.xidSede, this.JCBSede);
        this.JCBSede.setSelectedIndex(-1);
        if (this.xidSede != null && this.xidSede.length != 0) {
            this.JCBSede.setSelectedItem(Principal.sedeUsuarioSeleccionadaDTO.getNombre());
        }
        this.xconsulta.cerrarConexionBd();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Fecha", "NRecepción", "NExamen", "Promedio"}) { // from class: Laboratorio.JIFConsultasInfLab.13
            Class[] types = {String.class, Long.class, Long.class, Double.class};
            boolean[] canEdit = {false, false, false, false};

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
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos1() {
        this.xmodelo1 = new DefaultTableModel(new Object[0], new String[]{"Especialidad", "Profesional", "NOrden", "NItems", "Promedio"}) { // from class: Laboratorio.JIFConsultasInfLab.14
            Class[] types = {String.class, String.class, Long.class, Long.class, Double.class};
            boolean[] canEdit = {false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle1.setModel(this.xmodelo1);
        this.JTDetalle1.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTDetalle1.getColumnModel().getColumn(1).setPreferredWidth(300);
        this.JTDetalle1.getColumnModel().getColumn(2).setPreferredWidth(20);
        this.JTDetalle1.getColumnModel().getColumn(3).setPreferredWidth(20);
        this.JTDetalle1.getColumnModel().getColumn(4).setPreferredWidth(20);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos2() {
        this.xmodelo2 = new DefaultTableModel(new Object[0], new String[]{"Código", "Procedimiento", "Cantidad", "Remitido", "EResultado"}) { // from class: Laboratorio.JIFConsultasInfLab.15
            Class[] types = {String.class, String.class, Long.class, Boolean.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle2.setModel(this.xmodelo2);
        this.JTDetalle2.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTDetalle2.getColumnModel().getColumn(1).setPreferredWidth(400);
        this.JTDetalle2.getColumnModel().getColumn(2).setPreferredWidth(20);
        this.JTDetalle2.getColumnModel().getColumn(3).setPreferredWidth(20);
        this.JTDetalle2.getColumnModel().getColumn(4).setPreferredWidth(20);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos3() {
        this.xmodelo3 = new DefaultTableModel(new Object[0], new String[]{"Fecha y Hora", "N° Recepción", "Documento", "Usuario", "Tèlefono", "Edad", "Sexo", "Eps", "Profesional", "Dx", "Procedimientos", "Abreviatura", "Municipio", "Urgente?", "Observación", "Tipo de Atencion", "Fecha de recepción", "Fecha de Nacimiento", "Facturador", "Sede"}) { // from class: Laboratorio.JIFConsultasInfLab.16
            Class[] types = {String.class, Long.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTDetalle3;
        JTable jTable2 = this.JTDetalle3;
        jTable.setAutoResizeMode(0);
        this.JTDetalle3.doLayout();
        this.JTDetalle3.setModel(this.xmodelo3);
        this.JTDetalle3.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTDetalle3.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTDetalle3.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTDetalle3.getColumnModel().getColumn(3).setPreferredWidth(300);
        this.JTDetalle3.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTDetalle3.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTDetalle3.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTDetalle3.getColumnModel().getColumn(7).setPreferredWidth(300);
        this.JTDetalle3.getColumnModel().getColumn(8).setPreferredWidth(300);
        this.JTDetalle3.getColumnModel().getColumn(9).setPreferredWidth(80);
        this.JTDetalle3.getColumnModel().getColumn(10).setPreferredWidth(300);
        this.JTDetalle3.getColumnModel().getColumn(11).setPreferredWidth(200);
        this.JTDetalle3.getColumnModel().getColumn(12).setPreferredWidth(200);
        this.JTDetalle3.getColumnModel().getColumn(13).setPreferredWidth(80);
        this.JTDetalle3.getColumnModel().getColumn(14).setPreferredWidth(300);
        this.JTDetalle3.getColumnModel().getColumn(15).setPreferredWidth(150);
        this.JTDetalle3.getColumnModel().getColumn(16).setPreferredWidth(100);
        this.JTDetalle3.getColumnModel().getColumn(17).setPreferredWidth(100);
        this.JTDetalle3.getColumnModel().getColumn(18).setPreferredWidth(300);
        this.JTDetalle3.getColumnModel().getColumn(19).setPreferredWidth(300);
    }

    public void mCargarDatosTabla() {
        mCrearModeloDatos();
        if (this.JCBEspecialidad.getSelectedIndex() != -1) {
            this.idEspecialidad = Long.valueOf(this.xidespecialidad[this.JCBEspecialidad.getSelectedIndex()]);
        }
        if (this.JCBSede.getSelectedIndex() != -1) {
            this.idSede = Long.valueOf(this.xidSede[this.JCBSede.getSelectedIndex()]);
        }
        this.listaRecepcionesAgrupadas = this.recepcionService.listarRecepcionesAgrupado(this.xmt.formatoAMD1.format(this.JDFechaI.getDate()), this.xmt.formatoAMD1.format(this.JDFechaF.getDate()), this.xFiltro, this.idEspecialidad, this.idSede);
        if (!this.listaRecepcionesAgrupadas.isEmpty()) {
            for (int i = 0; i < this.listaRecepcionesAgrupadas.size(); i++) {
                this.xmodelo.addRow(this.xdatos);
                this.xmodelo.setValueAt(this.listaRecepcionesAgrupadas.get(i).getMes() + " " + this.listaRecepcionesAgrupadas.get(i).getAno(), i, 0);
                this.xmodelo.setValueAt(this.listaRecepcionesAgrupadas.get(i).getNRecepcion(), i, 1);
                this.xmodelo.setValueAt(this.listaRecepcionesAgrupadas.get(i).getNExamen(), i, 2);
                this.xmodelo.setValueAt(this.listaRecepcionesAgrupadas.get(i).getPromedio(), i, 3);
            }
        }
    }

    public void mCargarDatosTabla1() {
        mCrearModeloDatos1();
        if (this.JCBEspecialidad.getSelectedIndex() != -1) {
            this.idEspecialidad = Long.valueOf(this.xidespecialidad[this.JCBEspecialidad.getSelectedIndex()]);
        }
        if (this.JCBSede.getSelectedIndex() != -1) {
            this.idSede = Long.valueOf(this.xidSede[this.JCBSede.getSelectedIndex()]);
        }
        this.listaRecepcionProfesional = this.recepcionService.listarRecepcionesPorProfesional(this.xmt.formatoAMD1.format(this.JDFechaI.getDate()), this.xmt.formatoAMD1.format(this.JDFechaF.getDate()), this.xFiltro, this.idEspecialidad, this.idSede);
        if (!this.listaRecepcionProfesional.isEmpty()) {
            for (int i = 0; i < this.listaRecepcionProfesional.size(); i++) {
                this.xmodelo1.addRow(this.xdatos);
                this.xmodelo1.setValueAt(this.listaRecepcionProfesional.get(i).getEspecialidad(), i, 0);
                this.xmodelo1.setValueAt(this.listaRecepcionProfesional.get(i).getNProfesional(), i, 1);
                this.xmodelo1.setValueAt(this.listaRecepcionProfesional.get(i).getNOrden(), i, 2);
                this.xmodelo1.setValueAt(this.listaRecepcionProfesional.get(i).getNItems(), i, 3);
                this.xmodelo1.setValueAt(this.listaRecepcionProfesional.get(i).getPromedio(), i, 4);
            }
        }
    }

    public void mCargarDatosTabla2() {
        mCrearModeloDatos2();
        if (this.JCBEspecialidad.getSelectedIndex() != -1) {
            this.idEspecialidad = Long.valueOf(this.xidespecialidad[this.JCBEspecialidad.getSelectedIndex()]);
        }
        if (this.JCBSede.getSelectedIndex() != -1) {
            this.idSede = Long.valueOf(this.xidSede[this.JCBSede.getSelectedIndex()]);
        }
        this.listaProcedimientosRecepcionados = this.recepcionService.listarProcedimientosRecepcionados(this.xmt.formatoAMD1.format(this.JDFechaI.getDate()), this.xmt.formatoAMD1.format(this.JDFechaF.getDate()), this.xFiltro, this.idEspecialidad, this.idSede);
        if (!this.listaProcedimientosRecepcionados.isEmpty()) {
            for (int i = 0; i < this.listaProcedimientosRecepcionados.size(); i++) {
                this.xmodelo2.addRow(this.xdatos);
                this.xmodelo2.setValueAt(this.listaProcedimientosRecepcionados.get(i).getId(), i, 0);
                this.xmodelo2.setValueAt(this.listaProcedimientosRecepcionados.get(i).getNbre(), i, 1);
                this.xmodelo2.setValueAt(this.listaProcedimientosRecepcionados.get(i).getCant(), i, 2);
                this.xmodelo2.setValueAt(this.listaProcedimientosRecepcionados.get(i).getEsRemitido(), i, 3);
                this.xmodelo2.setValueAt(false, i, 4);
            }
        }
    }

    public void mCargarDatosTabla3() {
        mCrearModeloDatos3();
        if (this.JCBSede.getSelectedIndex() != -1) {
            this.idSede = Long.valueOf(this.xidSede[this.JCBSede.getSelectedIndex()]);
        }
        this.listaRegistroDiario = this.recepcionService.listarRegistroDiario(this.xmt.formatoAMD1.format(this.JDFechaI.getDate()), this.xmt.formatoAMD1.format(this.JDFechaF.getDate()), this.xFiltro, this.idSede);
        if (!this.listaRegistroDiario.isEmpty()) {
            for (int i = 0; i < this.listaRegistroDiario.size(); i++) {
                this.xmodelo3.addRow(this.xdatos);
                this.xmodelo3.setValueAt(this.listaRegistroDiario.get(i).getFechaRecep(), i, 0);
                this.xmodelo3.setValueAt(this.listaRegistroDiario.get(i).getId(), i, 1);
                this.xmodelo3.setValueAt(this.listaRegistroDiario.get(i).getDocumento(), i, 2);
                this.xmodelo3.setValueAt(this.listaRegistroDiario.get(i).getPaciente(), i, 3);
                this.xmodelo3.setValueAt(this.listaRegistroDiario.get(i).getTelefono(), i, 4);
                this.xmodelo3.setValueAt(this.listaRegistroDiario.get(i).getEdad(), i, 5);
                this.xmodelo3.setValueAt(this.listaRegistroDiario.get(i).getIdSexo(), i, 6);
                this.xmodelo3.setValueAt(this.listaRegistroDiario.get(i).getEPS(), i, 7);
                this.xmodelo3.setValueAt(this.listaRegistroDiario.get(i).getNProfesional(), i, 8);
                this.xmodelo3.setValueAt(this.listaRegistroDiario.get(i).getDxIngreso(), i, 9);
                this.xmodelo3.setValueAt(this.listaRegistroDiario.get(i).getProcedimiento(), i, 10);
                this.xmodelo3.setValueAt(this.listaRegistroDiario.get(i).getAbreviatura(), i, 11);
                this.xmodelo3.setValueAt(this.listaRegistroDiario.get(i).getNMunicipioU(), i, 12);
                this.xmodelo3.setValueAt(this.listaRegistroDiario.get(i).getEsUrgente(), i, 13);
                this.xmodelo3.setValueAt(this.listaRegistroDiario.get(i).getObservacion(), i, 14);
                this.xmodelo3.setValueAt(this.listaRegistroDiario.get(i).getTipoAtencion(), i, 15);
                this.xmodelo3.setValueAt(this.listaRegistroDiario.get(i).getFechaRecepcion(), i, 16);
                this.xmodelo3.setValueAt(this.listaRegistroDiario.get(i).getFechaNacimiento(), i, 17);
                this.xmodelo3.setValueAt(this.listaRegistroDiario.get(i).getFacturador(), i, 18);
                this.xmodelo3.setValueAt(this.listaRegistroDiario.get(i).getSede(), i, 19);
            }
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloRechazos() {
        this.xmodelorec = new DefaultTableModel(new Object[0], new String[]{"Código CUPS", "Procedimiento", "Cantidad", "TipoRechazo"}) { // from class: Laboratorio.JIFConsultasInfLab.17
            Class[] types = {String.class, String.class, Long.class, String.class};
            boolean[] canEdit = {false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalleRec.setModel(this.xmodelorec);
        this.JTDetalleRec.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTDetalleRec.getColumnModel().getColumn(1).setPreferredWidth(350);
        this.JTDetalleRec.getColumnModel().getColumn(2).setPreferredWidth(20);
        this.JTDetalleRec.getColumnModel().getColumn(3).setPreferredWidth(100);
    }

    public void mCargarDatosRech() {
        mCrearModeloRechazos();
        if (this.JCBSede.getSelectedIndex() != -1) {
            this.idSede = Long.valueOf(this.xidSede[this.JCBSede.getSelectedIndex()]);
        }
        this.listaMuestrasRechazadas = this.recepcionService.listarMuestrasRechazadas(this.xmt.formatoAMD1.format(this.JDFechaI.getDate()), this.xmt.formatoAMD1.format(this.JDFechaF.getDate()), this.idSede);
        if (!this.listaMuestrasRechazadas.isEmpty()) {
            for (int i = 0; i < this.listaMuestrasRechazadas.size(); i++) {
                this.xmodelorec.addRow(this.xdatos);
                this.xmodelorec.setValueAt(this.listaMuestrasRechazadas.get(i).getIdProcedimiento(), i, 0);
                this.xmodelorec.setValueAt(this.listaMuestrasRechazadas.get(i).getProcedimiento(), i, 1);
                this.xmodelorec.setValueAt(this.listaMuestrasRechazadas.get(i).getCantidad(), i, 2);
                this.xmodelorec.setValueAt(this.listaMuestrasRechazadas.get(i).getTipoRechazo(), i, 3);
            }
        }
    }
}
