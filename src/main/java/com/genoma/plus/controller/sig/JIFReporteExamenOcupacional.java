package com.genoma.plus.controller.sig;

import Acceso.Principal;
import Utilidades.Metodos;
import com.genoma.plus.dao.impl.sig.ReporteExamenOcupacionalDAOImpl;
import com.genoma.plus.dao.sig.ReporteExamenOcupacionalDAO;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/sig/JIFReporteExamenOcupacional.class */
public class JIFReporteExamenOcupacional extends JInternalFrame {
    private Metodos xmt = new Metodos();
    private DefaultTableModel xmodeloR;
    private Object[] xDatos;
    private boolean xLleno;
    private ReporteExamenOcupacionalDAO xReporteOcupacional;
    private JButton JBTExportar;
    private JDateChooser JDFechaFin;
    private JDateChooser JDFechaInicio;
    private JPanel JPIDatos;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;
    private JTextField JTFiltro;
    private JTextField JTRuta;
    private JTextField JTTotalRegistros;
    private JPanel jPDetalle;
    private JPanel jPanel1;

    public JIFReporteExamenOcupacional(String xNombre) {
        springStart();
        initComponents();
        mNuevo();
        setName(xNombre);
    }

    private void springStart() {
        this.xReporteOcupacional = (ReporteExamenOcupacionalDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("ReporteExamenOcupacionalDAO");
    }

    public void mNuevo() {
        this.JDFechaInicio.setDate(this.xmt.getFechaActual());
        this.JDFechaFin.setDate(this.xmt.getFechaActual());
        this.JTRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
        mCrearModelo();
    }

    public void mBuscar() {
        System.out.println("entro a  buscar");
        mCargarDatosTabla();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModelo() {
        this.xmodeloR = new DefaultTableModel(new Object[0], new String[]{"IdConcepto", "FechaIngreso", "Documento", "NUsuario", "Id_sexo", "NEmpresa", "Concepto", "TipoExamen", "Reporte", "Tipo"}) { // from class: com.genoma.plus.controller.sig.JIFReporteExamenOcupacional.1
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false};

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
        this.JTDetalle.setModel(this.xmodeloR);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(8).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(8).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(100);
    }

    private void mCargarDatosTabla() {
        List<Object[]> list;
        if (this.JTFiltro.getText().isEmpty()) {
            list = this.xReporteOcupacional.ListadoExamenOcupacional(this.xmt.formatoAMD1.format(this.JDFechaInicio.getDate()), this.xmt.formatoAMD1.format(this.JDFechaFin.getDate()));
        } else {
            list = this.xReporteOcupacional.ListadoExamenOcupacionalFiltrado(this.JTFiltro.getText());
        }
        mCrearModelo();
        int Y = 0;
        for (int x = 0; x < list.size(); x++) {
            this.xmodeloR.addRow(this.xDatos);
            for (int j = 0; j < 10; j++) {
                this.xmodeloR.setValueAt(list.get(x)[j], x, j);
            }
            Y++;
        }
        this.JTTotalRegistros.setText("" + Y);
    }

    private void initComponents() {
        this.JPIDatos = new JPanel();
        this.JDFechaInicio = new JDateChooser();
        this.JDFechaFin = new JDateChooser();
        this.JTFiltro = new JTextField();
        this.jPDetalle = new JPanel();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.jPanel1 = new JPanel();
        this.JBTExportar = new JButton();
        this.JTRuta = new JTextField();
        this.JTTotalRegistros = new JTextField();
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("CONSULTA CONCEPTOS SALUD OCUPACIONAL");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xJIFReporteExamenOcupacional");
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 12), new Color(0, 103, 0)));
        this.JPIDatos.setName("");
        this.JDFechaInicio.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaInicio.setDateFormatString("dd/MM/yyyy");
        this.JDFechaInicio.setFont(new Font("Arial", 1, 12));
        this.JDFechaInicio.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.sig.JIFReporteExamenOcupacional.2
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFReporteExamenOcupacional.this.JDFechaInicioPropertyChange(evt);
            }
        });
        this.JDFechaFin.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Fin", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaFin.setDateFormatString("dd/MM/yyyy");
        this.JDFechaFin.setFont(new Font("Arial", 1, 12));
        this.JDFechaFin.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.sig.JIFReporteExamenOcupacional.3
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFReporteExamenOcupacional.this.JDFechaFinPropertyChange(evt);
            }
        });
        this.JTFiltro.setBorder(BorderFactory.createTitledBorder((Border) null, "Filtro (Nombre o Documento)", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFiltro.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.sig.JIFReporteExamenOcupacional.4
            public void keyPressed(KeyEvent evt) {
                JIFReporteExamenOcupacional.this.JTFiltroKeyPressed(evt);
            }
        });
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addComponent(this.JDFechaInicio, -2, 140, -2).addGap(27, 27, 27).addComponent(this.JDFechaFin, -2, 140, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFiltro, -2, 383, -2).addContainerGap(-1, 32767)));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JDFechaInicio, -2, 50, -2).addComponent(this.JDFechaFin, -2, 50, -2)).addComponent(this.JTFiltro, -2, 50, -2)).addGap(10, 10, 10)));
        this.jPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 12), new Color(0, 103, 0)));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.sig.JIFReporteExamenOcupacional.5
            public void mouseClicked(MouseEvent evt) {
                JIFReporteExamenOcupacional.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        GroupLayout jPDetalleLayout = new GroupLayout(this.jPDetalle);
        this.jPDetalle.setLayout(jPDetalleLayout);
        jPDetalleLayout.setHorizontalGroup(jPDetalleLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPDetalle));
        jPDetalleLayout.setVerticalGroup(jPDetalleLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPDetalle, -1, 250, 32767));
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar a Excel");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.sig.JIFReporteExamenOcupacional.6
            public void actionPerformed(ActionEvent evt) {
                JIFReporteExamenOcupacional.this.JBTExportarActionPerformed(evt);
            }
        });
        this.JTRuta.setFont(new Font("Arial", 1, 12));
        this.JTRuta.setText("C:\\Genoma");
        this.JTRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ruta", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTRuta.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.sig.JIFReporteExamenOcupacional.7
            public void actionPerformed(ActionEvent evt) {
                JIFReporteExamenOcupacional.this.JTRutaActionPerformed(evt);
            }
        });
        this.JTTotalRegistros.setEditable(false);
        this.JTTotalRegistros.setFont(new Font("Arial", 1, 12));
        this.JTTotalRegistros.setHorizontalAlignment(0);
        this.JTTotalRegistros.setText("0");
        this.JTTotalRegistros.setBorder(BorderFactory.createTitledBorder((Border) null, "Total Registros", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTTotalRegistros.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.sig.JIFReporteExamenOcupacional.8
            public void actionPerformed(ActionEvent evt) {
                JIFReporteExamenOcupacional.this.JTTotalRegistrosActionPerformed(evt);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.JTRuta, -2, 274, -2).addGap(41, 41, 41).addComponent(this.JTTotalRegistros, -2, 139, -2).addGap(205, 205, 205).addComponent(this.JBTExportar, -2, 230, -2)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addContainerGap(16, 32767).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JBTExportar, -2, 68, -2).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTRuta, -2, 47, -2).addComponent(this.JTTotalRegistros, -2, 47, -2))).addContainerGap()));
        this.JTTotalRegistros.getAccessibleContext().setAccessibleName("");
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPIDatos, -1, -1, 32767).addGroup(layout.createSequentialGroup().addComponent(this.jPanel1, -1, -1, 32767).addContainerGap()).addComponent(this.jPDetalle, -1, -1, 32767));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.JPIDatos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jPDetalle, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.jPanel1, -2, -1, -2)));
        this.JPIDatos.getAccessibleContext().setAccessibleName("Datos");
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaInicioPropertyChange(PropertyChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaFinPropertyChange(PropertyChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTExportarActionPerformed(ActionEvent evt) {
        if (this.JTDetalle.getRowCount() != -1) {
            this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTDetalle, this.JTRuta.getText(), getTitle());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTRutaActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTTotalRegistrosActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            mImiprimir();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFiltroKeyPressed(KeyEvent evt) {
        if (!this.JTFiltro.getText().isEmpty()) {
            mBuscar();
        }
    }

    public void mImiprimir() {
        String[][] mparametros = new String[3][2];
        mparametros[0][0] = "Id";
        mparametros[0][1] = this.xmodeloR.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString();
        mparametros[1][0] = "SUBREPORT_DIR";
        mparametros[1][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
        mparametros[2][0] = "SUBREPORTFIRMA_DIR";
        mparametros[2][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
        System.out.println("" + Principal.informacionIps.getNombreIps());
        this.xmt.GenerarPDF(this.xmt.getRutaRep() + "H_So_Concepto_Aptitud_Mineros", mparametros);
    }
}
