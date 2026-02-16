package com.genoma.plus.controller.sig;

import Utilidades.Metodos;
import Utilidades.WorkerSQL;
import com.genoma.plus.dao.impl.sgc.InformesSgcDAOImpl;
import com.genoma.plus.dao.sgc.InformesSgcDAO;
import com.genoma.plus.dto.sig.GenericoComboDTO;
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

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/sig/JIFDiagnosticoSalud.class */
public class JIFDiagnosticoSalud extends JInternalFrame {
    private InformesSgcDAO xInformesSgcDAO;
    private DefaultTableModel xModelo1;
    private Object[] xdatos;
    private String xtipo;
    private WorkerSQL xWorkerSQL;
    private String[] xidEmpresa;
    private JButton JBTExportar;
    private JComboBox JCBEmpresa;
    private JDateChooser JDFechaF;
    private JDateChooser JDFechaI;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;
    private JTextField JTFRuta;
    private JTextField JTF_NEventos;
    private JPanel jPanel1;
    private Metodos xmt = new Metodos();
    private int xlleno = 0;

    public JIFDiagnosticoSalud() {
        initComponents();
        springStart();
        mNuevo();
    }

    private void springStart() {
        this.xInformesSgcDAO = (InformesSgcDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("informesSgcDAO");
    }

    public void mNuevo() {
        this.JDFechaI.setDate(this.xmt.getFechaActual());
        this.JDFechaF.setDate(this.xmt.getFechaActual());
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
        List<GenericoComboDTO> list = this.xInformesSgcDAO.cargarCombo("SELECT `Id`, `Nbre` FROM `f_empresacontxconvenio` WHERE (`Estado` =0) ORDER BY `Nbre` ASC;");
        this.xidEmpresa = new String[list.size()];
        for (int x = 0; x < list.size(); x++) {
            this.xidEmpresa[x] = String.valueOf(list.get(x).getId());
            this.JCBEmpresa.addItem(list.get(x).getNombre());
            System.out.println("Consulta " + list.get(x).getId());
            System.out.println("" + list.get(x).getNombre());
        }
        this.JCBEmpresa.setSelectedIndex(-1);
        mCreaModeloTabla();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCreaModeloTabla() {
        this.xModelo1 = new DefaultTableModel(new Object[0], new String[]{"Id", "Fecha Atencion", "Clase de Cita", "Tipo Identificacion", "No Documento", "Usuario", "Edad", "Sexo", "Escolaridad", "Cargo", "Estado Civil", "EPS", "Accidente de Trabajo", "Enfermedad Profesional", "Practica Deporte?", "Cual Deporte?", "Fuma?", "Obs Fuma?", "Consume Alcohol?", "Cual Alcohol?", "Obs Alcohol?", "Antecedentes Familiares", "Antecedentes Personales", "Antecedentes Quirurgicos", "TArtSentadoD", "TArtSentadoS", "Peso", "Talla", "IMC", "R_VLAmbosO_V", "R_VLODerecho_V", "R_VLOIzquierdo_V", "R_VCAmbosO_V", "R_VCODerecho_V", "R_VCOIzquierdo_V", "RVisiometia", "RVObservacion", "FVC", "FV1", "FEF2575", "FEV1_FVC", "RAudiometria", "RAObservacion", "REspirometria", "REObservacion", "ROsteomuscular", "Concepto", "DxP", "NDxP", "DxR1", "NDxR1", "DxR2", "NDxR2", "DxR3", "NDxR3", "IMC", "Recomendaciones", "Observacion", "NEmpresa", "Codigo Radiologias", "Nombre Examen Radiologias", "Resultado Radiologias", "Codigo Atencion Psicologias", "Atención Psicologias", "Resultados Examen Psicologias", "Codigo Optometrias", "Examen Optometrias", "Resultado Optometrias", "Codigo Electrocardiograma", "Examen Electrocardiograma", "Resultado Electrocardiograma"}) { // from class: com.genoma.plus.controller.sig.JIFDiagnosticoSalud.1
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

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
        this.JTDetalle.setModel(this.xModelo1);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(130);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(120);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(120);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(12).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(13).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(14).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(15).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(16).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(17).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(18).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(19).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(20).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(21).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(22).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(23).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(24).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(25).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(26).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(27).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(28).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(29).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(30).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(31).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(32).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(33).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(34).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(35).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(36).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(37).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(38).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(39).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(40).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(41).setPreferredWidth(130);
        this.JTDetalle.getColumnModel().getColumn(42).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(43).setPreferredWidth(130);
        this.JTDetalle.getColumnModel().getColumn(44).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(45).setPreferredWidth(130);
        this.JTDetalle.getColumnModel().getColumn(46).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(47).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(48).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(49).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(50).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(51).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(52).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(53).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(54).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(55).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(56).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(57).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(58).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(59).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(60).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(61).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(62).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(63).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(64).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(65).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(66).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(67).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(68).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(69).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(70).setPreferredWidth(300);
    }

    public void mBuscar() {
        this.xWorkerSQL = null;
        this.xWorkerSQL = new WorkerSQL("Cargando la información", this);
        this.xWorkerSQL.execute();
    }

    public void mCargarDatos() {
        this.xInformesSgcDAO.mCrearTmpAntecedentesFamiliares();
        this.xInformesSgcDAO.mCrearTmpAntecedentesPersonales();
        this.xInformesSgcDAO.mCrearTmpAntecedentesPPatologicos();
        List<Object[]> list = this.xInformesSgcDAO.ListInformeDiagnosticoSaludSO(this.xmt.formatoAMD1.format(this.JDFechaI.getDate()), this.xmt.formatoAMD1.format(this.JDFechaF.getDate()), this.xidEmpresa[this.JCBEmpresa.getSelectedIndex()]);
        mCreaModeloTabla();
        for (int x = 0; x < list.size(); x++) {
            this.xModelo1.addRow(this.xdatos);
            this.xModelo1.setValueAt(list.get(x)[0], x, 0);
            this.xModelo1.setValueAt(list.get(x)[1], x, 1);
            this.xModelo1.setValueAt(list.get(x)[2], x, 2);
            this.xModelo1.setValueAt(list.get(x)[3], x, 3);
            this.xModelo1.setValueAt(list.get(x)[4], x, 4);
            this.xModelo1.setValueAt(list.get(x)[5], x, 5);
            this.xModelo1.setValueAt(list.get(x)[6], x, 6);
            this.xModelo1.setValueAt(list.get(x)[7], x, 7);
            this.xModelo1.setValueAt(list.get(x)[8], x, 8);
            this.xModelo1.setValueAt(list.get(x)[9], x, 9);
            this.xModelo1.setValueAt(list.get(x)[10], x, 10);
            this.xModelo1.setValueAt(list.get(x)[11], x, 11);
            this.xModelo1.setValueAt(list.get(x)[12], x, 12);
            this.xModelo1.setValueAt(list.get(x)[13], x, 13);
            this.xModelo1.setValueAt(list.get(x)[14], x, 14);
            this.xModelo1.setValueAt(list.get(x)[15], x, 15);
            this.xModelo1.setValueAt(list.get(x)[16], x, 16);
            this.xModelo1.setValueAt(list.get(x)[17], x, 17);
            this.xModelo1.setValueAt(list.get(x)[18], x, 18);
            this.xModelo1.setValueAt(list.get(x)[19], x, 19);
            this.xModelo1.setValueAt(list.get(x)[20], x, 20);
            this.xModelo1.setValueAt(list.get(x)[21], x, 21);
            this.xModelo1.setValueAt(list.get(x)[22], x, 22);
            this.xModelo1.setValueAt(list.get(x)[23], x, 23);
            this.xModelo1.setValueAt(list.get(x)[24], x, 24);
            this.xModelo1.setValueAt(list.get(x)[25], x, 25);
            this.xModelo1.setValueAt(list.get(x)[26], x, 26);
            this.xModelo1.setValueAt(list.get(x)[27], x, 27);
            this.xModelo1.setValueAt(list.get(x)[28], x, 28);
            this.xModelo1.setValueAt(list.get(x)[29], x, 29);
            this.xModelo1.setValueAt(list.get(x)[30], x, 30);
            this.xModelo1.setValueAt(list.get(x)[31], x, 31);
            this.xModelo1.setValueAt(list.get(x)[32], x, 32);
            this.xModelo1.setValueAt(list.get(x)[33], x, 33);
            this.xModelo1.setValueAt(list.get(x)[34], x, 34);
            this.xModelo1.setValueAt(list.get(x)[35], x, 35);
            this.xModelo1.setValueAt(list.get(x)[36], x, 36);
            this.xModelo1.setValueAt(list.get(x)[37], x, 37);
            this.xModelo1.setValueAt(list.get(x)[38], x, 38);
            this.xModelo1.setValueAt(list.get(x)[39], x, 39);
            this.xModelo1.setValueAt(list.get(x)[40], x, 40);
            this.xModelo1.setValueAt(list.get(x)[41], x, 41);
            this.xModelo1.setValueAt(list.get(x)[42], x, 42);
            this.xModelo1.setValueAt(list.get(x)[43], x, 43);
            this.xModelo1.setValueAt(list.get(x)[44], x, 44);
            this.xModelo1.setValueAt(list.get(x)[45], x, 45);
            this.xModelo1.setValueAt(list.get(x)[46], x, 46);
            this.xModelo1.setValueAt(list.get(x)[47], x, 47);
            this.xModelo1.setValueAt(list.get(x)[48], x, 48);
            this.xModelo1.setValueAt(list.get(x)[49], x, 49);
            this.xModelo1.setValueAt(list.get(x)[50], x, 50);
            this.xModelo1.setValueAt(list.get(x)[51], x, 51);
            this.xModelo1.setValueAt(list.get(x)[52], x, 52);
            this.xModelo1.setValueAt(list.get(x)[53], x, 53);
            this.xModelo1.setValueAt(list.get(x)[54], x, 54);
            this.xModelo1.setValueAt(list.get(x)[55], x, 55);
            this.xModelo1.setValueAt(list.get(x)[56], x, 56);
            this.xModelo1.setValueAt(list.get(x)[57], x, 57);
            this.xModelo1.setValueAt(list.get(x)[58], x, 58);
            this.xModelo1.setValueAt(list.get(x)[59], x, 59);
            this.xModelo1.setValueAt(list.get(x)[60], x, 60);
            this.xModelo1.setValueAt(list.get(x)[61], x, 61);
            this.xModelo1.setValueAt(list.get(x)[62], x, 62);
            this.xModelo1.setValueAt(list.get(x)[63], x, 63);
            this.xModelo1.setValueAt(list.get(x)[64], x, 64);
            this.xModelo1.setValueAt(list.get(x)[65], x, 65);
            this.xModelo1.setValueAt(list.get(x)[66], x, 66);
            this.xModelo1.setValueAt(list.get(x)[67], x, 67);
        }
        this.JTF_NEventos.setText(String.valueOf(list.size()));
    }

    /* JADX WARN: Type inference failed for: r3v29, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jPanel1 = new JPanel();
        this.JDFechaI = new JDateChooser();
        this.JDFechaF = new JDateChooser();
        this.JCBEmpresa = new JComboBox();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JTFRuta = new JTextField();
        this.JBTExportar = new JButton();
        this.JTF_NEventos = new JTextField();
        setClosable(true);
        setIconifiable(true);
        setTitle("DIAGNOSTICO DE SALUD");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjifdiagnosticosalud");
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JDFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicial", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFechaI.setFont(new Font("Arial", 1, 12));
        this.JDFechaI.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.sig.JIFDiagnosticoSalud.2
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFDiagnosticoSalud.this.JDFechaIPropertyChange(evt);
            }
        });
        this.JDFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Final", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFechaF.setFont(new Font("Arial", 1, 12));
        this.JDFechaF.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.sig.JIFDiagnosticoSalud.3
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFDiagnosticoSalud.this.JDFechaFPropertyChange(evt);
            }
        });
        this.JCBEmpresa.setFont(new Font("Arial", 1, 12));
        this.JCBEmpresa.setBorder(BorderFactory.createTitledBorder((Border) null, "Empresa", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JDFechaI, -2, 136, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JDFechaF, -2, 136, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBEmpresa, -2, 559, -2).addContainerGap(-1, 32767)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JDFechaI, -2, 50, -2).addComponent(this.JDFechaF, -2, 50, -2)).addComponent(this.JCBEmpresa, GroupLayout.Alignment.TRAILING, -2, -1, -2)).addContainerGap(-1, 32767)));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setSelectionBackground(Color.white);
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.sig.JIFDiagnosticoSalud.4
            public void mouseClicked(MouseEvent evt) {
                JIFDiagnosticoSalud.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setForeground(Color.red);
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.sig.JIFDiagnosticoSalud.5
            public void actionPerformed(ActionEvent evt) {
                JIFDiagnosticoSalud.this.JBTExportarActionPerformed(evt);
            }
        });
        this.JTF_NEventos.setFont(new Font("Arial", 1, 16));
        this.JTF_NEventos.setHorizontalAlignment(0);
        this.JTF_NEventos.setBorder(BorderFactory.createTitledBorder((Border) null, "No. Registros", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTF_NEventos.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.sig.JIFDiagnosticoSalud.6
            public void actionPerformed(ActionEvent evt) {
                JIFDiagnosticoSalud.this.JTF_NEventosActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JSPDetalle).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.JTF_NEventos, -2, 111, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFRuta).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTExportar, -2, 191, -2)).addComponent(this.jPanel1, -1, -1, 32767)).addGap(10, 10, 10)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalle, -2, 437, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFRuta, -2, 50, -2).addComponent(this.JTF_NEventos, -2, 50, -2)).addComponent(this.JBTExportar, -2, 51, -2)).addContainerGap(15, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaIPropertyChange(PropertyChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaFPropertyChange(PropertyChangeEvent evt) {
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
        if (this.JTDetalle.getRowCount() != -1) {
            int x = JOptionPane.showConfirmDialog(this, "Esta seguro de exportar?", "CONFIRMACIÓN", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTDetalle, this.JTFRuta.getText(), getTitle());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTF_NEventosActionPerformed(ActionEvent evt) {
    }
}
