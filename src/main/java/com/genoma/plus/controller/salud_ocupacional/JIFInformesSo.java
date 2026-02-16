package com.genoma.plus.controller.salud_ocupacional;

import Utilidades.Metodos;
import Utilidades.WorkerSQL;
import com.genoma.plus.dao.impl.salud_ocupacional.GeneralDAOImpl;
import com.genoma.plus.dao.impl.salud_ocupacional.InformeSaludOcupacionalDAOImpl;
import com.genoma.plus.dao.salud_ocupacional.GeneralDAO;
import com.genoma.plus.dao.salud_ocupacional.InformeSaludOcupacionalDAO;
import com.toedter.calendar.JYearChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/salud_ocupacional/JIFInformesSo.class */
public class JIFInformesSo extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private Object[] xDato;
    private Metodos xmt = new Metodos();
    private boolean xlleno = false;
    private InformeSaludOcupacionalDAO InformeSaludOcupacionalDAO;
    private GeneralDAO generalDAO;
    private String[] xIdPoblacion;
    private WorkerSQL xWorkerSQL;
    private JButton JBTGenerar;
    private JComboBox JCB_PoblacionO;
    private JPanel JPI_Filtro;
    private JPanel JPI_Periodo;
    private JScrollPane JSP_Detalle;
    private JTable JTB_Detalle;
    private JTextField JTFRuta;
    private JYearChooser JYC_Fin;
    private JYearChooser JYC_Inicio;

    public JIFInformesSo(String xtitulo, String nombre) {
        initComponents();
        setTitle(xtitulo.toUpperCase());
        setName(nombre);
        springStart();
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v33, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPI_Filtro = new JPanel();
        this.JCB_PoblacionO = new JComboBox();
        this.JPI_Periodo = new JPanel();
        this.JYC_Inicio = new JYearChooser();
        this.JYC_Fin = new JYearChooser();
        this.JSP_Detalle = new JScrollPane();
        this.JTB_Detalle = new JTable();
        this.JTFRuta = new JTextField();
        this.JBTGenerar = new JButton();
        setClosable(true);
        setIconifiable(true);
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjif_informeSo");
        this.JPI_Filtro.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN PARA CONSULTA", 0, 0, new Font("Arial", 1, 14), Color.red));
        this.JCB_PoblacionO.setFont(new Font("Arial", 1, 12));
        this.JCB_PoblacionO.setBorder(BorderFactory.createTitledBorder((Border) null, "Población Objeto", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JPI_Periodo.setBorder(BorderFactory.createTitledBorder((Border) null, "Periódo de Consultac(Año)", 0, 0, new Font("Arial", 1, 12), new Color(0, 103, 0)));
        this.JYC_Inicio.setBorder(BorderFactory.createTitledBorder((Border) null, "Inicial", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JYC_Fin.setBorder(BorderFactory.createTitledBorder((Border) null, "Comparativo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPI_PeriodoLayout = new GroupLayout(this.JPI_Periodo);
        this.JPI_Periodo.setLayout(JPI_PeriodoLayout);
        JPI_PeriodoLayout.setHorizontalGroup(JPI_PeriodoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_PeriodoLayout.createSequentialGroup().addContainerGap().addComponent(this.JYC_Inicio, -1, 92, 32767).addGap(18, 18, 18).addComponent(this.JYC_Fin, -2, 92, -2).addContainerGap()));
        JPI_PeriodoLayout.setVerticalGroup(JPI_PeriodoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_PeriodoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JYC_Inicio, -2, -1, -2).addComponent(this.JYC_Fin, -2, -1, -2)));
        GroupLayout JPI_FiltroLayout = new GroupLayout(this.JPI_Filtro);
        this.JPI_Filtro.setLayout(JPI_FiltroLayout);
        JPI_FiltroLayout.setHorizontalGroup(JPI_FiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_FiltroLayout.createSequentialGroup().addContainerGap().addComponent(this.JCB_PoblacionO, -2, 312, -2).addGap(80, 80, 80).addComponent(this.JPI_Periodo, -2, -1, -2).addContainerGap(274, 32767)));
        JPI_FiltroLayout.setVerticalGroup(JPI_FiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_FiltroLayout.createSequentialGroup().addContainerGap(20, 32767).addGroup(JPI_FiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPI_Periodo, -2, -1, -2).addComponent(this.JCB_PoblacionO, -2, 50, -2))));
        this.JSP_Detalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTB_Detalle.setFont(new Font("Arial", 1, 12));
        this.JTB_Detalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTB_Detalle.setRowHeight(25);
        this.JSP_Detalle.setViewportView(this.JTB_Detalle);
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\\\Genoma\\\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ruta", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.salud_ocupacional.JIFInformesSo.1
            public void mouseClicked(MouseEvent evt) {
                JIFInformesSo.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBTGenerar.setFont(new Font("Arial", 1, 12));
        this.JBTGenerar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTGenerar.setText("Exportar");
        this.JBTGenerar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.salud_ocupacional.JIFInformesSo.2
            public void actionPerformed(ActionEvent evt) {
                JIFInformesSo.this.JBTGenerarActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(18, 18, 18).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.JTFRuta).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTGenerar, -2, 189, -2)).addComponent(this.JSP_Detalle).addComponent(this.JPI_Filtro, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPI_Filtro, -2, -1, -2).addGap(18, 18, 18).addComponent(this.JSP_Detalle, -2, 377, -2).addGap(14, 14, 14).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTFRuta, -2, 50, -2).addGroup(layout.createSequentialGroup().addComponent(this.JBTGenerar, -1, 50, 32767).addGap(2, 2, 2))).addContainerGap()));
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
    public void JBTGenerarActionPerformed(ActionEvent evt) {
        if (this.JTB_Detalle.getRowCount() != -1) {
            int x = JOptionPane.showConfirmDialog(this, "Esta seguro de exportar?", "CONFIRMACIÓN", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTB_Detalle, this.JTFRuta.getText(), getTitle());
            }
        }
    }

    private void springStart() {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"});
        this.InformeSaludOcupacionalDAO = (InformeSaludOcupacionalDAOImpl) classPathXmlApplicationContext.getBean("informeSaludOcupacionalDAO");
        this.generalDAO = (GeneralDAOImpl) classPathXmlApplicationContext.getBean("generalDAO");
    }

    public void mNuevo() {
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
        List<Object[]> list1 = this.generalDAO.listPeriodosFinancieros();
        this.xIdPoblacion = new String[list1.size()];
        for (int x = 0; x < list1.size(); x++) {
            this.xIdPoblacion[x] = String.valueOf(list1.get(x)[0]);
            this.JCB_PoblacionO.addItem(list1.get(x)[1]);
        }
        if (this.xIdPoblacion.length > 1) {
            this.JCB_PoblacionO.setSelectedIndex(-1);
        }
        this.JYC_Inicio.setValue(this.JYC_Fin.getValue() - 3);
        mCrearTabla();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTabla() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"No. Documento", "Usuario", "Unidad", "Cargo", "Edad", "Sexo", "T/Diastolica", "T/Diastolica_1", "T/Sistolica", "T/Sistolica_1", "Imc", "Imc_1", "PAbdominal", "PAbdominal_1", "VGlicemia", "VGlicemia1", "ColesterolT", "ColesterolT_1", "Trigliceridos", "Trigliceridos_1", "ColesterolHDL", "ColesterolHDL_1", "ColesterolLDL", "ColesterolLDL_1", "Framingan", "Framingan_1", "FechaAtencion", "Clase Cita", "Clase Cita 1", "Proceso", "Gerencia", "DireccionCargo"}) { // from class: com.genoma.plus.controller.salud_ocupacional.JIFInformesSo.3
            Class[] types = {String.class, String.class, String.class, String.class, Long.class, String.class, Long.class, Long.class, Long.class, Long.class, Double.class, Double.class, Long.class, Long.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTB_Detalle;
        JTable jTable2 = this.JTB_Detalle;
        jTable.setAutoResizeMode(0);
        this.JTB_Detalle.doLayout();
        this.JTB_Detalle.setModel(this.xmodelo);
        this.JTB_Detalle.getColumnModel().getColumn(0).setPreferredWidth(80);
        this.JTB_Detalle.getColumnModel().getColumn(1).setPreferredWidth(300);
        this.JTB_Detalle.getColumnModel().getColumn(2).setPreferredWidth(200);
        this.JTB_Detalle.getColumnModel().getColumn(3).setPreferredWidth(200);
        this.JTB_Detalle.getColumnModel().getColumn(4).setPreferredWidth(80);
        this.JTB_Detalle.getColumnModel().getColumn(5).setPreferredWidth(80);
        this.JTB_Detalle.getColumnModel().getColumn(6).setPreferredWidth(80);
        this.JTB_Detalle.getColumnModel().getColumn(7).setPreferredWidth(80);
        this.JTB_Detalle.getColumnModel().getColumn(8).setPreferredWidth(80);
        this.JTB_Detalle.getColumnModel().getColumn(9).setPreferredWidth(80);
        this.JTB_Detalle.getColumnModel().getColumn(10).setPreferredWidth(80);
        this.JTB_Detalle.getColumnModel().getColumn(11).setPreferredWidth(80);
        this.JTB_Detalle.getColumnModel().getColumn(12).setPreferredWidth(80);
        this.JTB_Detalle.getColumnModel().getColumn(13).setPreferredWidth(80);
        this.JTB_Detalle.getColumnModel().getColumn(14).setPreferredWidth(80);
        this.JTB_Detalle.getColumnModel().getColumn(15).setPreferredWidth(80);
        this.JTB_Detalle.getColumnModel().getColumn(16).setPreferredWidth(80);
        this.JTB_Detalle.getColumnModel().getColumn(17).setPreferredWidth(80);
        this.JTB_Detalle.getColumnModel().getColumn(18).setPreferredWidth(80);
        this.JTB_Detalle.getColumnModel().getColumn(19).setPreferredWidth(80);
        this.JTB_Detalle.getColumnModel().getColumn(20).setPreferredWidth(80);
        this.JTB_Detalle.getColumnModel().getColumn(21).setPreferredWidth(80);
        this.JTB_Detalle.getColumnModel().getColumn(22).setPreferredWidth(80);
        this.JTB_Detalle.getColumnModel().getColumn(23).setPreferredWidth(80);
        this.JTB_Detalle.getColumnModel().getColumn(24).setPreferredWidth(80);
        this.JTB_Detalle.getColumnModel().getColumn(25).setPreferredWidth(80);
        this.JTB_Detalle.getColumnModel().getColumn(26).setPreferredWidth(80);
        this.JTB_Detalle.getColumnModel().getColumn(27).setPreferredWidth(150);
        this.JTB_Detalle.getColumnModel().getColumn(28).setPreferredWidth(150);
        this.JTB_Detalle.getColumnModel().getColumn(29).setPreferredWidth(200);
        this.JTB_Detalle.getColumnModel().getColumn(30).setPreferredWidth(200);
        this.JTB_Detalle.getColumnModel().getColumn(31).setPreferredWidth(200);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTablaMineros() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"No. Documento", "Usuario", "Unidad", "Cargo", "Edad", "Sexo", "T/Diastolica", "T/Diastolica_1", "T/Sistolica", "T/Sistolica_1", "Imc", "Imc_1", "PAbdominal", "PAbdominal_1", "VGlicemia", "VGlicemia1", "ColesterolT", "ColesterolT_1", "Trigliceridos", "Trigliceridos_1", "ColesterolHDL", "ColesterolHDL_1", "ColesterolLDL", "ColesterolLDL_1", "Framingan", "Framingan_1", "FechaAtencion", "RiesgoFramingham", "Clase Cita", "Clase Cita 1", "Proceso", "Gerencia", "DireccionCargo", "Grupo sanguineo", "Factor Rh"}) { // from class: com.genoma.plus.controller.salud_ocupacional.JIFInformesSo.4
            Class[] types = {String.class, String.class, String.class, String.class, Long.class, String.class, Long.class, Long.class, Long.class, Long.class, Double.class, Double.class, Long.class, Long.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTB_Detalle;
        JTable jTable2 = this.JTB_Detalle;
        jTable.setAutoResizeMode(0);
        this.JTB_Detalle.doLayout();
        this.JTB_Detalle.setModel(this.xmodelo);
        this.JTB_Detalle.getColumnModel().getColumn(0).setPreferredWidth(80);
        this.JTB_Detalle.getColumnModel().getColumn(1).setPreferredWidth(300);
        this.JTB_Detalle.getColumnModel().getColumn(2).setPreferredWidth(200);
        this.JTB_Detalle.getColumnModel().getColumn(3).setPreferredWidth(200);
        this.JTB_Detalle.getColumnModel().getColumn(4).setPreferredWidth(80);
        this.JTB_Detalle.getColumnModel().getColumn(5).setPreferredWidth(80);
        this.JTB_Detalle.getColumnModel().getColumn(6).setPreferredWidth(80);
        this.JTB_Detalle.getColumnModel().getColumn(7).setPreferredWidth(80);
        this.JTB_Detalle.getColumnModel().getColumn(8).setPreferredWidth(80);
        this.JTB_Detalle.getColumnModel().getColumn(9).setPreferredWidth(80);
        this.JTB_Detalle.getColumnModel().getColumn(10).setPreferredWidth(80);
        this.JTB_Detalle.getColumnModel().getColumn(11).setPreferredWidth(80);
        this.JTB_Detalle.getColumnModel().getColumn(12).setPreferredWidth(80);
        this.JTB_Detalle.getColumnModel().getColumn(13).setPreferredWidth(80);
        this.JTB_Detalle.getColumnModel().getColumn(14).setPreferredWidth(80);
        this.JTB_Detalle.getColumnModel().getColumn(15).setPreferredWidth(80);
        this.JTB_Detalle.getColumnModel().getColumn(16).setPreferredWidth(80);
        this.JTB_Detalle.getColumnModel().getColumn(17).setPreferredWidth(80);
        this.JTB_Detalle.getColumnModel().getColumn(18).setPreferredWidth(80);
        this.JTB_Detalle.getColumnModel().getColumn(19).setPreferredWidth(80);
        this.JTB_Detalle.getColumnModel().getColumn(20).setPreferredWidth(80);
        this.JTB_Detalle.getColumnModel().getColumn(21).setPreferredWidth(80);
        this.JTB_Detalle.getColumnModel().getColumn(22).setPreferredWidth(80);
        this.JTB_Detalle.getColumnModel().getColumn(23).setPreferredWidth(80);
        this.JTB_Detalle.getColumnModel().getColumn(24).setPreferredWidth(80);
        this.JTB_Detalle.getColumnModel().getColumn(25).setPreferredWidth(80);
        this.JTB_Detalle.getColumnModel().getColumn(26).setPreferredWidth(80);
        this.JTB_Detalle.getColumnModel().getColumn(27).setPreferredWidth(150);
        this.JTB_Detalle.getColumnModel().getColumn(28).setPreferredWidth(150);
        this.JTB_Detalle.getColumnModel().getColumn(29).setPreferredWidth(200);
        this.JTB_Detalle.getColumnModel().getColumn(30).setPreferredWidth(200);
        this.JTB_Detalle.getColumnModel().getColumn(31).setPreferredWidth(200);
        this.JTB_Detalle.getColumnModel().getColumn(32).setPreferredWidth(200);
        this.JTB_Detalle.getColumnModel().getColumn(33).setPreferredWidth(200);
        this.JTB_Detalle.getColumnModel().getColumn(34).setPreferredWidth(200);
    }

    public void mBuscar() {
        this.xWorkerSQL = null;
        this.xWorkerSQL = new WorkerSQL("Cargando la información", this);
        this.xWorkerSQL.execute();
    }

    public void mBuscar_C() {
        if (this.xmt.esIPSMineros()) {
            mBuscar_C_Mineros();
            return;
        }
        if (this.JCB_PoblacionO.getSelectedIndex() != -1) {
            mCrearTabla();
            List<Object[]> list1 = this.InformeSaludOcupacionalDAO.informeRiesgoCardioVascularSo(this.xIdPoblacion[this.JCB_PoblacionO.getSelectedIndex()], this.JYC_Inicio.getValue(), this.JYC_Fin.getValue());
            System.out.println("Lista informes -> " + list1.size());
            if (list1.size() >= 1) {
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
                    this.xmodelo.setValueAt(list1.get(x)[19], x, 19);
                    this.xmodelo.setValueAt(list1.get(x)[20], x, 20);
                    this.xmodelo.setValueAt(list1.get(x)[21], x, 21);
                    this.xmodelo.setValueAt(list1.get(x)[22], x, 22);
                    this.xmodelo.setValueAt(list1.get(x)[23], x, 23);
                    this.xmodelo.setValueAt(list1.get(x)[24], x, 24);
                    this.xmodelo.setValueAt(list1.get(x)[25], x, 25);
                    this.xmodelo.setValueAt(list1.get(x)[26], x, 26);
                    this.xmodelo.setValueAt(list1.get(x)[27], x, 27);
                    this.xmodelo.setValueAt(list1.get(x)[28], x, 28);
                    this.xmodelo.setValueAt(list1.get(x)[29], x, 29);
                    this.xmodelo.setValueAt(list1.get(x)[30], x, 30);
                    this.xmodelo.setValueAt(list1.get(x)[31], x, 31);
                }
                return;
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una población objeto a consultar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        this.JCB_PoblacionO.requestFocus();
    }

    public void mBuscar_C_Mineros() {
        if (this.JCB_PoblacionO.getSelectedIndex() != -1) {
            mCrearTablaMineros();
            List<Object[]> list1 = this.InformeSaludOcupacionalDAO.informeRiesgoCardioVascularSoMineros(this.xIdPoblacion[this.JCB_PoblacionO.getSelectedIndex()], this.JYC_Inicio.getValue(), this.JYC_Fin.getValue());
            System.out.println("Lista informes -> " + list1.size());
            if (list1.size() >= 1) {
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
                    this.xmodelo.setValueAt(list1.get(x)[19], x, 19);
                    this.xmodelo.setValueAt(list1.get(x)[20], x, 20);
                    this.xmodelo.setValueAt(list1.get(x)[21], x, 21);
                    this.xmodelo.setValueAt(list1.get(x)[22], x, 22);
                    this.xmodelo.setValueAt(list1.get(x)[23], x, 23);
                    this.xmodelo.setValueAt(list1.get(x)[24], x, 24);
                    this.xmodelo.setValueAt(list1.get(x)[25], x, 25);
                    this.xmodelo.setValueAt(list1.get(x)[26], x, 26);
                    this.xmodelo.setValueAt(list1.get(x)[27], x, 27);
                    this.xmodelo.setValueAt(list1.get(x)[28], x, 28);
                    this.xmodelo.setValueAt(list1.get(x)[29], x, 29);
                    this.xmodelo.setValueAt(list1.get(x)[30], x, 30);
                    this.xmodelo.setValueAt(list1.get(x)[31], x, 31);
                    this.xmodelo.setValueAt(list1.get(x)[32], x, 32);
                    this.xmodelo.setValueAt(list1.get(x)[33], x, 33);
                    this.xmodelo.setValueAt(list1.get(x)[34], x, 34);
                }
                return;
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una población objeto a consultar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        this.JCB_PoblacionO.requestFocus();
    }
}
