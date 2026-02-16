package com.genoma.plus.controller.presupuesto;

import Acceso.Principal;
import Utilidades.Metodos;
import com.genoma.plus.dao.impl.presupuesto.EjecucionPresupuestalDAOImpl;
import com.genoma.plus.dao.impl.presupuesto.InformesCgrDAOImpl;
import com.genoma.plus.dao.impl.presupuesto.PresupuestoDAOImpl;
import com.genoma.plus.dao.presupuesto.EjecucionPresupuestalDAO;
import com.genoma.plus.dao.presupuesto.InformesCgrDAO;
import com.genoma.plus.dao.presupuesto.PresupuestoDAO;
import com.genoma.plus.dto.presupuesto.PeriodoDTO;
import com.toedter.calendar.JYearChooser;
import java.awt.Color;
import java.awt.Component;
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
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SpinnerListModel;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/presupuesto/JIFConsultarInformacionCGR.class */
public class JIFConsultarInformacionCGR extends JInternalFrame {
    private PresupuestoDAO presupuestoDAO;
    private InformesCgrDAO informeCgrDAO;
    private EjecucionPresupuestalDAO ejecucionPresupuestalDAO;
    private String[] idPeriodo;
    private Metodos metodos = new Metodos();
    private File file;
    private DefaultTableModel modeloDatos;
    private Object[] dato;
    private ButtonGroup JBG_FiltroReportes;
    private ButtonGroup JBG_FiltroUtilidad;
    private JButton JBTGenerar;
    private JComboBox JCBPeriodo;
    private JPanel JPI_Filtro;
    private JPanel JPI_PeriodosGeneracion;
    private JRadioButton JRB_Exportar;
    private JRadioButton JRB_Generar;
    private JRadioButton JRB_Reporte1;
    private JRadioButton JRB_Reporte2;
    private JRadioButton JRB_Reporte3;
    private JRadioButton JRB_Reporte4;
    private JScrollPane JSPDetalle;
    private JSpinner JSPFin;
    private JSpinner JSPInicio;
    private JTable JTBDetalle;
    private JTextField JTFRuta;
    private JYearChooser JYCAno;
    private JPanel jPanel1;
    private JPanel jPanel2;

    public JIFConsultarInformacionCGR() {
        initComponents();
        springStart();
        nuevo();
    }

    /* JADX WARN: Type inference failed for: r3v54, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBG_FiltroReportes = new ButtonGroup();
        this.JBG_FiltroUtilidad = new ButtonGroup();
        this.jPanel1 = new JPanel();
        this.JCBPeriodo = new JComboBox();
        this.JYCAno = new JYearChooser();
        this.JRB_Reporte1 = new JRadioButton();
        this.JRB_Reporte2 = new JRadioButton();
        this.JRB_Reporte3 = new JRadioButton();
        this.JRB_Reporte4 = new JRadioButton();
        this.JPI_PeriodosGeneracion = new JPanel();
        this.JSPInicio = new JSpinner();
        this.JSPFin = new JSpinner();
        this.JSPDetalle = new JScrollPane();
        this.JTBDetalle = new JTable();
        this.jPanel2 = new JPanel();
        this.JTFRuta = new JTextField();
        this.JBTGenerar = new JButton();
        this.JPI_Filtro = new JPanel();
        this.JRB_Generar = new JRadioButton();
        this.JRB_Exportar = new JRadioButton();
        setClosable(true);
        setIconifiable(true);
        setFont(new Font("Arial", 1, 14));
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifConsultarInformeCgrPresupuesto");
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JCBPeriodo.setFont(new Font("Arial", 1, 12));
        this.JCBPeriodo.setBorder(BorderFactory.createTitledBorder((Border) null, "Periodo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBPeriodo.addItemListener(new ItemListener() { // from class: com.genoma.plus.controller.presupuesto.JIFConsultarInformacionCGR.1
            public void itemStateChanged(ItemEvent evt) {
                JIFConsultarInformacionCGR.this.JCBPeriodoItemStateChanged(evt);
            }
        });
        this.JYCAno.setBorder(BorderFactory.createTitledBorder((Border) null, "Año", 0, 0, new Font("Arial", 1, 13), Color.blue));
        this.JYCAno.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.presupuesto.JIFConsultarInformacionCGR.2
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFConsultarInformacionCGR.this.JYCAnoPropertyChange(evt);
            }
        });
        this.JBG_FiltroReportes.add(this.JRB_Reporte1);
        this.JRB_Reporte1.setFont(new Font("Arial", 1, 12));
        this.JRB_Reporte1.setSelected(true);
        this.JRB_Reporte1.setText("Prorogramacion de Ingresos");
        this.JRB_Reporte1.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.presupuesto.JIFConsultarInformacionCGR.3
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarInformacionCGR.this.JRB_Reporte1ActionPerformed(evt);
            }
        });
        this.JBG_FiltroReportes.add(this.JRB_Reporte2);
        this.JRB_Reporte2.setFont(new Font("Arial", 1, 12));
        this.JRB_Reporte2.setText("Ejecucion de Ingresos");
        this.JRB_Reporte2.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.presupuesto.JIFConsultarInformacionCGR.4
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarInformacionCGR.this.JRB_Reporte2ActionPerformed(evt);
            }
        });
        this.JBG_FiltroReportes.add(this.JRB_Reporte3);
        this.JRB_Reporte3.setFont(new Font("Arial", 1, 12));
        this.JRB_Reporte3.setText("Prorogramacion de Gastos");
        this.JRB_Reporte3.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.presupuesto.JIFConsultarInformacionCGR.5
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarInformacionCGR.this.JRB_Reporte3ActionPerformed(evt);
            }
        });
        this.JBG_FiltroReportes.add(this.JRB_Reporte4);
        this.JRB_Reporte4.setFont(new Font("Arial", 1, 12));
        this.JRB_Reporte4.setText("Ejecucion de Gastos");
        this.JRB_Reporte4.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.presupuesto.JIFConsultarInformacionCGR.6
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarInformacionCGR.this.JRB_Reporte4ActionPerformed(evt);
            }
        });
        this.JPI_PeriodosGeneracion.setBorder(BorderFactory.createTitledBorder((Border) null, "Periodos Generación (Mes)", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JSPInicio.setFont(new Font("Arial", 1, 12));
        this.JSPInicio.setModel(new SpinnerListModel(new String[]{"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"}));
        this.JSPInicio.setBorder(BorderFactory.createTitledBorder((Border) null, "Inicio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPFin.setFont(new Font("Arial", 1, 12));
        this.JSPFin.setModel(new SpinnerListModel(new String[]{"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"}));
        this.JSPFin.setBorder(BorderFactory.createTitledBorder((Border) null, "Hasta", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPI_PeriodosGeneracionLayout = new GroupLayout(this.JPI_PeriodosGeneracion);
        this.JPI_PeriodosGeneracion.setLayout(JPI_PeriodosGeneracionLayout);
        JPI_PeriodosGeneracionLayout.setHorizontalGroup(JPI_PeriodosGeneracionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_PeriodosGeneracionLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPInicio, -2, 60, -2).addGap(30, 30, 30).addComponent(this.JSPFin, -2, 60, -2).addContainerGap(14, 32767)));
        JPI_PeriodosGeneracionLayout.setVerticalGroup(JPI_PeriodosGeneracionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_PeriodosGeneracionLayout.createSequentialGroup().addContainerGap().addGroup(JPI_PeriodosGeneracionLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JSPInicio, -2, -1, -2).addComponent(this.JSPFin, -2, -1, -2)).addContainerGap(-1, 32767)));
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(16, 16, 16).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JRB_Reporte1).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRB_Reporte2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRB_Reporte3).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRB_Reporte4)).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JYCAno, -2, 95, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBPeriodo, -2, 341, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JPI_PeriodosGeneracion, -2, -1, -2).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JYCAno, -2, 50, -2).addComponent(this.JCBPeriodo, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRB_Reporte1).addComponent(this.JRB_Reporte2).addComponent(this.JRB_Reporte3).addComponent(this.JRB_Reporte4))).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.JPI_PeriodosGeneracion, -2, -1, -2))).addContainerGap(13, 32767)));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTBDetalle.setFont(new Font("Arial", 1, 12));
        this.JTBDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTBDetalle.setSelectionBackground(Color.white);
        this.JTBDetalle.setSelectionForeground(Color.red);
        this.JSPDetalle.setViewportView(this.JTBDetalle);
        this.jPanel2.setBorder(BorderFactory.createTitledBorder((Border) null, "UTILIDAD", 0, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ruta (Directorio)", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.presupuesto.JIFConsultarInformacionCGR.7
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarInformacionCGR.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBTGenerar.setFont(new Font("Arial", 1, 12));
        this.JBTGenerar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTGenerar.setText("Generar");
        this.JBTGenerar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.presupuesto.JIFConsultarInformacionCGR.8
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarInformacionCGR.this.JBTGenerarActionPerformed(evt);
            }
        });
        this.JPI_Filtro.setBorder(BorderFactory.createTitledBorder((Border) null, "Filtro", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JBG_FiltroUtilidad.add(this.JRB_Generar);
        this.JRB_Generar.setFont(new Font("Arial", 1, 12));
        this.JRB_Generar.setSelected(true);
        this.JRB_Generar.setText("Generar");
        this.JRB_Generar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.presupuesto.JIFConsultarInformacionCGR.9
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarInformacionCGR.this.JRB_GenerarActionPerformed(evt);
            }
        });
        this.JBG_FiltroUtilidad.add(this.JRB_Exportar);
        this.JRB_Exportar.setFont(new Font("Arial", 1, 12));
        this.JRB_Exportar.setText("Exportar");
        this.JRB_Exportar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.presupuesto.JIFConsultarInformacionCGR.10
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarInformacionCGR.this.JRB_ExportarActionPerformed(evt);
            }
        });
        GroupLayout JPI_FiltroLayout = new GroupLayout(this.JPI_Filtro);
        this.JPI_Filtro.setLayout(JPI_FiltroLayout);
        JPI_FiltroLayout.setHorizontalGroup(JPI_FiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_FiltroLayout.createSequentialGroup().addComponent(this.JRB_Generar).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JRB_Exportar).addContainerGap()));
        JPI_FiltroLayout.setVerticalGroup(JPI_FiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_FiltroLayout.createSequentialGroup().addContainerGap().addGroup(JPI_FiltroLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRB_Generar).addComponent(this.JRB_Exportar)).addContainerGap(-1, 32767)));
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(this.JTFRuta, -2, 342, -2).addGap(18, 18, 18).addComponent(this.JPI_Filtro, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 54, 32767).addComponent(this.JBTGenerar, -2, 380, -2).addContainerGap()));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JPI_Filtro, GroupLayout.Alignment.LEADING, -1, -1, 32767).addGroup(GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JTFRuta, GroupLayout.Alignment.LEADING, -2, 50, -2).addComponent(this.JBTGenerar, -2, 50, -2)))).addContainerGap(-1, 32767)));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JSPDetalle).addComponent(this.jPanel2, -1, -1, 32767).addComponent(this.jPanel1, -1, -1, 32767)).addContainerGap(14, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, -1, -2).addGap(18, 18, 18).addComponent(this.JSPDetalle, -1, 400, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jPanel2, -2, -1, -2).addGap(17, 17, 17)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBPeriodoItemStateChanged(ItemEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JYCAnoPropertyChange(PropertyChangeEvent evt) {
        llenarComboPeriodo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            if (this.JRB_Generar.isSelected()) {
                JFileChooser xfilec = new JFileChooser(this.JTFRuta.getText());
                xfilec.setFileSelectionMode(1);
                int xv = xfilec.showOpenDialog(this);
                if (xv == 0) {
                    this.file = xfilec.getSelectedFile();
                    this.JTFRuta.setText(this.file.getAbsolutePath() + "");
                    return;
                }
                return;
            }
            JFileChooser xfilec2 = new JFileChooser(this.JTFRuta.getText());
            xfilec2.setFileSelectionMode(1);
            int xv2 = xfilec2.showOpenDialog(this);
            if (xv2 == 0) {
                File xfile = xfilec2.getSelectedFile();
                this.JTFRuta.setText(xfile.getAbsolutePath() + this.metodos.getBarra());
                this.JTFRuta.requestFocus();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTGenerarActionPerformed(ActionEvent evt) {
        if (this.JTBDetalle.getRowCount() > 0) {
            if (this.JRB_Generar.isSelected()) {
                if (JOptionPane.showConfirmDialog((Component) null, "Confirma generar el archivo? ", "Generar Archivo", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png")))) == 0) {
                    if (this.JRB_Reporte1.isSelected()) {
                        crearArchivoPlano(15);
                        return;
                    } else {
                        if (this.JRB_Reporte3.isSelected()) {
                            crearArchivoPlano(16);
                            return;
                        }
                        return;
                    }
                }
                return;
            }
            this.metodos.mExportar_Datos_Tabla_Titulo_Formato(this.JTBDetalle, this.JTFRuta.getText(), getTitle());
            return;
        }
        JOptionPane.showMessageDialog((Component) null, "No hay información para generar archivo", "Generar Archivo", 2, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Warning.png"))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_GenerarActionPerformed(ActionEvent evt) {
        iniciarValoresBotonesUtilidad();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_ExportarActionPerformed(ActionEvent evt) {
        iniciarValoresBotonesUtilidad();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_Reporte1ActionPerformed(ActionEvent evt) {
        setTitle(this.JRB_Reporte1.getText().toUpperCase());
        crearTablaReporte1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_Reporte2ActionPerformed(ActionEvent evt) {
        setTitle(this.JRB_Reporte2.getText().toUpperCase());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_Reporte3ActionPerformed(ActionEvent evt) {
        setTitle(this.JRB_Reporte3.getText().toUpperCase());
        crearTablaReporte3();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_Reporte4ActionPerformed(ActionEvent evt) {
        setTitle(this.JRB_Reporte4.getText().toUpperCase());
    }

    public void nuevo() {
        this.JYCAno.setValue(Integer.valueOf(this.metodos.formatoANO.format(this.metodos.getFechaActual())).intValue());
        iniciarValoresBotonesUtilidad();
        setTitle(this.JRB_Reporte1.getText().toUpperCase());
        this.JRB_Reporte1.setSelected(true);
    }

    private void llenarComboPeriodo() {
        this.JCBPeriodo.removeAllItems();
        List<PeriodoDTO> listPeriodo = this.presupuestoDAO.listPeriodoPPT(String.valueOf(this.JYCAno.getValue()));
        if (!listPeriodo.isEmpty()) {
            this.idPeriodo = new String[listPeriodo.size()];
            for (int i = 0; i < listPeriodo.size(); i++) {
                this.idPeriodo[i] = String.valueOf(listPeriodo.get(i).getId());
                this.JCBPeriodo.addItem(listPeriodo.get(i).getNombre());
            }
        }
    }

    private void springStart() {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"});
        this.presupuestoDAO = (PresupuestoDAOImpl) classPathXmlApplicationContext.getBean("presupuestoDAOImpl");
        this.informeCgrDAO = (InformesCgrDAOImpl) classPathXmlApplicationContext.getBean("informesCgrDAOImpl");
        this.ejecucionPresupuestalDAO = (EjecucionPresupuestalDAOImpl) classPathXmlApplicationContext.getBean("ejecucionPresupuestalDAOImpl");
    }

    private void crearTablaReporte1() {
        this.modeloDatos = new DefaultTableModel() { // from class: com.genoma.plus.controller.presupuesto.JIFConsultarInformacionCGR.11
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, true, true, true, true, true, true, true, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return this.canEdit[colIndex];
            }
        };
        this.modeloDatos.addColumn("Tipo");
        this.modeloDatos.addColumn("IdRubo");
        this.modeloDatos.addColumn("Nombre Rubro");
        this.modeloDatos.addColumn("Codigo CGR");
        this.modeloDatos.addColumn("TipoRecurso");
        this.modeloDatos.addColumn("Origen Ingreso");
        this.modeloDatos.addColumn("Tipo Destinacion");
        this.modeloDatos.addColumn("Tipo Situacion");
        this.modeloDatos.addColumn("Presupuesto Incial");
        this.modeloDatos.addColumn("Adicion");
        this.modeloDatos.addColumn("Reduccion");
        this.modeloDatos.addColumn("Credito");
        this.modeloDatos.addColumn("ContraCredito");
        this.modeloDatos.addColumn("Aplazamiento");
        this.modeloDatos.addColumn("Desplazamiento");
        this.modeloDatos.addColumn("Presupuesto Definitivo");
        JTable jTable = this.JTBDetalle;
        JTable jTable2 = this.JTBDetalle;
        jTable.setAutoResizeMode(0);
        this.JTBDetalle.doLayout();
        this.JTBDetalle.setModel(this.modeloDatos);
        this.JTBDetalle.getColumnModel().getColumn(0).setPreferredWidth(50);
        this.JTBDetalle.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTBDetalle.getColumnModel().getColumn(2).setPreferredWidth(300);
        this.JTBDetalle.getColumnModel().getColumn(3).setPreferredWidth(150);
        this.JTBDetalle.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTBDetalle.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTBDetalle.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTBDetalle.getColumnModel().getColumn(7).setPreferredWidth(150);
        this.JTBDetalle.getColumnModel().getColumn(8).setPreferredWidth(150);
        this.JTBDetalle.getColumnModel().getColumn(9).setPreferredWidth(150);
        this.JTBDetalle.getColumnModel().getColumn(10).setPreferredWidth(150);
        this.JTBDetalle.getColumnModel().getColumn(11).setPreferredWidth(150);
        this.JTBDetalle.getColumnModel().getColumn(12).setPreferredWidth(150);
        this.JTBDetalle.getColumnModel().getColumn(13).setPreferredWidth(150);
        this.JTBDetalle.getColumnModel().getColumn(14).setPreferredWidth(150);
        this.JTBDetalle.getColumnModel().getColumn(15).setPreferredWidth(150);
    }

    private void crearTablaReporte3() {
        this.modeloDatos = new DefaultTableModel() { // from class: com.genoma.plus.controller.presupuesto.JIFConsultarInformacionCGR.12
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, true, true, true, true, true, true, true, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return this.canEdit[colIndex];
            }
        };
        this.modeloDatos.addColumn("Tipo");
        this.modeloDatos.addColumn("IdRubo");
        this.modeloDatos.addColumn("Nombre Rubro");
        this.modeloDatos.addColumn("Codigo CGR");
        this.modeloDatos.addColumn("Numero");
        this.modeloDatos.addColumn("TipoRecurso");
        this.modeloDatos.addColumn("Origen Ingreso");
        this.modeloDatos.addColumn("Tipo Destinacion");
        this.modeloDatos.addColumn("Fin Gasto");
        this.modeloDatos.addColumn("Presupuesto Incial");
        this.modeloDatos.addColumn("Adicion");
        this.modeloDatos.addColumn("Reduccion");
        this.modeloDatos.addColumn("Credito");
        this.modeloDatos.addColumn("ContraCredito");
        this.modeloDatos.addColumn("Aplazamiento");
        this.modeloDatos.addColumn("Desplazamiento");
        this.modeloDatos.addColumn("Presupuesto Definitivo");
        JTable jTable = this.JTBDetalle;
        JTable jTable2 = this.JTBDetalle;
        jTable.setAutoResizeMode(0);
        this.JTBDetalle.doLayout();
        this.JTBDetalle.setModel(this.modeloDatos);
        this.JTBDetalle.getColumnModel().getColumn(0).setPreferredWidth(50);
        this.JTBDetalle.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTBDetalle.getColumnModel().getColumn(2).setPreferredWidth(300);
        this.JTBDetalle.getColumnModel().getColumn(3).setPreferredWidth(150);
        this.JTBDetalle.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTBDetalle.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTBDetalle.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTBDetalle.getColumnModel().getColumn(7).setPreferredWidth(100);
        this.JTBDetalle.getColumnModel().getColumn(8).setPreferredWidth(150);
        this.JTBDetalle.getColumnModel().getColumn(9).setPreferredWidth(150);
        this.JTBDetalle.getColumnModel().getColumn(10).setPreferredWidth(150);
        this.JTBDetalle.getColumnModel().getColumn(11).setPreferredWidth(150);
        this.JTBDetalle.getColumnModel().getColumn(12).setPreferredWidth(150);
        this.JTBDetalle.getColumnModel().getColumn(13).setPreferredWidth(150);
        this.JTBDetalle.getColumnModel().getColumn(14).setPreferredWidth(150);
        this.JTBDetalle.getColumnModel().getColumn(15).setPreferredWidth(150);
        this.JTBDetalle.getColumnModel().getColumn(16).setPreferredWidth(150);
    }

    private void llenarTablaReporte1() {
        List<Object[]> listReporte = null;
        if (this.JRB_Reporte1.isSelected()) {
            listReporte = this.informeCgrDAO.lisProgramacionIngresos(this.idPeriodo[this.JCBPeriodo.getSelectedIndex()], Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro(), String.valueOf(this.JYCAno.getValue()));
            crearTablaReporte1();
        } else if (this.JRB_Reporte3.isSelected()) {
            listReporte = this.informeCgrDAO.lisProgramacionGastos(this.idPeriodo[this.JCBPeriodo.getSelectedIndex()], Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro(), String.valueOf(this.JYCAno.getValue()));
            crearTablaReporte3();
        }
        if (!listReporte.isEmpty()) {
            for (int i = 0; i < listReporte.size(); i++) {
                this.modeloDatos.addRow(this.dato);
                this.modeloDatos.setValueAt(listReporte.get(i)[0], i, 0);
                this.modeloDatos.setValueAt(listReporte.get(i)[1], i, 1);
                this.modeloDatos.setValueAt(listReporte.get(i)[2], i, 2);
                this.modeloDatos.setValueAt(listReporte.get(i)[3], i, 3);
                this.modeloDatos.setValueAt(listReporte.get(i)[4], i, 4);
                this.modeloDatos.setValueAt(listReporte.get(i)[5], i, 5);
                this.modeloDatos.setValueAt(listReporte.get(i)[6], i, 6);
                this.modeloDatos.setValueAt(listReporte.get(i)[7], i, 7);
                if (this.JRB_Reporte1.isSelected()) {
                    this.modeloDatos.setValueAt(this.ejecucionPresupuestalDAO.valorRubro(this.idPeriodo[this.JCBPeriodo.getSelectedIndex()], 0, Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro(), String.valueOf(listReporte.get(i)[1].toString()), "1", String.valueOf(this.JYCAno.getValue()), Integer.valueOf(listReporte.get(i)[8].toString()), "1"), i, 8);
                    this.modeloDatos.setValueAt(this.ejecucionPresupuestalDAO.valorRubro(this.idPeriodo[this.JCBPeriodo.getSelectedIndex()], 3, Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro(), String.valueOf(listReporte.get(i)[1].toString()), "8", String.valueOf(this.JYCAno.getValue()), Integer.valueOf(listReporte.get(i)[8].toString()), "1"), i, 9);
                    this.modeloDatos.setValueAt(this.ejecucionPresupuestalDAO.valorRubro(this.idPeriodo[this.JCBPeriodo.getSelectedIndex()], 3, Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro(), String.valueOf(listReporte.get(i)[1].toString()), "8", String.valueOf(this.JYCAno.getValue()), Integer.valueOf(listReporte.get(i)[8].toString()), "0"), i, 10);
                    this.modeloDatos.setValueAt(new Double(0.0d), i, 11);
                    this.modeloDatos.setValueAt(new Double(0.0d), i, 12);
                    this.modeloDatos.setValueAt(new Double(0.0d), i, 13);
                    this.modeloDatos.setValueAt(new Double(0.0d), i, 14);
                    this.modeloDatos.setValueAt(Double.valueOf((Double.valueOf(this.modeloDatos.getValueAt(i, 8).toString()).doubleValue() + Double.valueOf(this.modeloDatos.getValueAt(i, 9).toString()).doubleValue()) - Double.valueOf(this.modeloDatos.getValueAt(i, 10).toString()).doubleValue()), i, 15);
                } else if (this.JRB_Reporte3.isSelected()) {
                    this.modeloDatos.setValueAt(listReporte.get(i)[8], i, 8);
                    this.modeloDatos.setValueAt(this.ejecucionPresupuestalDAO.valorRubro(this.idPeriodo[this.JCBPeriodo.getSelectedIndex()], 0, Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro(), String.valueOf(listReporte.get(i)[1].toString()), "1", String.valueOf(this.JYCAno.getValue()), Integer.valueOf(listReporte.get(i)[9].toString()), "1"), i, 9);
                    this.modeloDatos.setValueAt(this.ejecucionPresupuestalDAO.valorRubro(this.idPeriodo[this.JCBPeriodo.getSelectedIndex()], 3, Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro(), String.valueOf(listReporte.get(i)[1].toString()), "8", String.valueOf(this.JYCAno.getValue()), Integer.valueOf(listReporte.get(i)[9].toString()), "1"), i, 10);
                    this.modeloDatos.setValueAt(this.ejecucionPresupuestalDAO.valorRubro(this.idPeriodo[this.JCBPeriodo.getSelectedIndex()], 3, Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro(), String.valueOf(listReporte.get(i)[1].toString()), "8", String.valueOf(this.JYCAno.getValue()), Integer.valueOf(listReporte.get(i)[9].toString()), "0"), i, 11);
                    this.modeloDatos.setValueAt(this.ejecucionPresupuestalDAO.valorRubro(this.idPeriodo[this.JCBPeriodo.getSelectedIndex()], 3, Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro(), String.valueOf(listReporte.get(i)[1].toString()), "7", String.valueOf(this.JYCAno.getValue()), Integer.valueOf(listReporte.get(i)[9].toString()), "0"), i, 12);
                    this.modeloDatos.setValueAt(this.ejecucionPresupuestalDAO.valorRubro(this.idPeriodo[this.JCBPeriodo.getSelectedIndex()], 3, Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro(), String.valueOf(listReporte.get(i)[1].toString()), "7", String.valueOf(this.JYCAno.getValue()), Integer.valueOf(listReporte.get(i)[9].toString()), "1"), i, 13);
                    this.modeloDatos.setValueAt(new Double(0.0d), i, 14);
                    this.modeloDatos.setValueAt(new Double(0.0d), i, 15);
                    this.modeloDatos.setValueAt(Double.valueOf(((Double.valueOf(this.modeloDatos.getValueAt(i, 9).toString()).doubleValue() + Double.valueOf(this.modeloDatos.getValueAt(i, 10).toString()).doubleValue()) + Double.valueOf(this.modeloDatos.getValueAt(i, 12).toString()).doubleValue()) - (Double.valueOf(this.modeloDatos.getValueAt(i, 11).toString()).doubleValue() + Double.valueOf(this.modeloDatos.getValueAt(i, 13).toString()).doubleValue())), i, 16);
                }
            }
        }
    }

    public void buscar() {
        if (this.JCBPeriodo.getSelectedIndex() != -1) {
            if (this.JRB_Reporte1.isSelected() || this.JRB_Reporte3.isSelected()) {
                llenarTablaReporte1();
            }
        }
    }

    private void iniciarValoresBotonesUtilidad() {
        if (this.JRB_Generar.isSelected()) {
            this.JBTGenerar.setText("Generar");
            this.JBTGenerar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
            this.JTFRuta.setText(this.metodos.getDirectorioExportacion());
        } else {
            this.JBTGenerar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
            this.JBTGenerar.setText("Exportar a Excel");
            this.JTFRuta.setText(this.metodos.getDirectorioExportacion() + "Planilla");
        }
    }

    private void crearArchivoPlano(int columna) {
        try {
            String sFichero = this.JTFRuta.getText() + "S" + Principal.informacionIps.getCodigoContraloriaReportes() + "1" + this.JSPInicio.getValue() + this.JSPFin.getValue() + this.JYCAno.getValue() + getTitle().replaceAll(" ", "") + ".txt";
            this.metodos.mEliminarArchivo(new File(sFichero));
            BufferedWriter bw = new BufferedWriter(new FileWriter(sFichero));
            bw.write("S\t" + Principal.informacionIps.getCodigoContraloriaReportes() + "\t1" + this.JSPInicio.getValue() + this.JSPFin.getValue() + "\t" + this.JYCAno.getValue() + "\t" + getTitle().replaceAll(" ", ""));
            bw.newLine();
            for (int i = 0; i < this.JTBDetalle.getRowCount(); i++) {
                if (!this.JTBDetalle.getValueAt(i, 3).equals("") && Double.valueOf(this.modeloDatos.getValueAt(i, columna).toString()).doubleValue() > 0.0d) {
                    String xValor = "";
                    for (int y = 0; y < this.JTBDetalle.getColumnCount(); y++) {
                        if (y != 1 && y != 2) {
                            if (y == this.JTBDetalle.getColumnCount() - 1) {
                                if (this.JRB_Reporte1.isSelected()) {
                                    if (y >= 8) {
                                        xValor = xValor + this.metodos.formatoMoneda1.format(this.modeloDatos.getValueAt(i, y));
                                    } else {
                                        xValor = xValor + this.modeloDatos.getValueAt(i, y).toString();
                                    }
                                } else if (this.JRB_Reporte3.isSelected()) {
                                    if (y >= 8) {
                                        xValor = xValor + this.metodos.formatoMoneda1.format(this.modeloDatos.getValueAt(i, y));
                                    } else {
                                        xValor = xValor + this.modeloDatos.getValueAt(i, y).toString();
                                    }
                                }
                            } else if (this.JRB_Reporte1.isSelected()) {
                                if (y >= 8) {
                                    xValor = xValor + this.metodos.formatoMoneda1.format(this.modeloDatos.getValueAt(i, y)) + "\t";
                                } else {
                                    xValor = xValor + this.modeloDatos.getValueAt(i, y).toString() + "\t";
                                }
                            } else if (this.JRB_Reporte3.isSelected()) {
                                if (y >= 9) {
                                    xValor = xValor + this.metodos.formatoMoneda1.format(this.modeloDatos.getValueAt(i, y)) + "\t";
                                } else {
                                    xValor = xValor + this.modeloDatos.getValueAt(i, y).toString() + "\t";
                                }
                            }
                        }
                    }
                    bw.write(xValor);
                    bw.newLine();
                }
            }
            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(JIFConsultarInformacionCGR.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }
}
