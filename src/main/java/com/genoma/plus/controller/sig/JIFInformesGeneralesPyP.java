package com.genoma.plus.controller.sig;

import Utilidades.CustomPopupMenuListener;
import Utilidades.Metodos;
import com.genoma.plus.dao.impl.sig.InformeGeneralesDAOImpl;
import com.genoma.plus.dao.sig.InformeGeneralesPyPDAO;
import com.genoma.plus.dto.gcuenta.GCGenericoDTO;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/sig/JIFInformesGeneralesPyP.class */
public class JIFInformesGeneralesPyP extends JInternalFrame {
    private InformeGeneralesPyPDAO xInformeGeneralesPyPDAO;
    private String[] xidEmpresa;
    private String idInforme;
    private Metodos xmt = new Metodos();
    private DefaultTableModel xmodelo;
    private Object[] xdato;
    private JButton JBTActualizar;
    private JButton JBTExportar;
    private JComboBox<String> JCBEmpresas;
    private JComboBox<String> JCBTipodeInforme;
    private JDateChooser JDFFechaF;
    private JDateChooser JDFFechaI;
    private JButton JTBLimpiar;
    private JTextField JTFRuta;
    private JTable Jtable;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel4;
    private JScrollPane jScrollPane1;

    public JIFInformesGeneralesPyP() {
        initComponents();
        springStart();
        mNuevo();
    }

    private void springStart() {
        this.xInformeGeneralesPyPDAO = (InformeGeneralesDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("informeGeneralesPyPDAO");
    }

    public void mNuevo() {
        this.JDFFechaI.setDate(this.xmt.getFechaActual());
        this.JDFFechaF.setDate(this.xmt.getFechaActual());
        this.JCBEmpresas.removeAllItems();
        List<GCGenericoDTO> list1 = this.xInformeGeneralesPyPDAO.listaempresa();
        this.xidEmpresa = new String[list1.size()];
        for (int x = 0; x < list1.size(); x++) {
            this.xidEmpresa[x] = String.valueOf(list1.get(x).getId());
            this.JCBEmpresas.addItem(list1.get(x).getNombre());
        }
        this.JCBTipodeInforme.addPopupMenuListener(new CustomPopupMenuListener(true, false));
        this.JCBTipodeInforme.setSelectedIndex(-1);
        this.idInforme = "0";
        modeloTipoInforme1();
    }

    /* JADX WARN: Type inference failed for: r3v42, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jPanel1 = new JPanel();
        this.JDFFechaI = new JDateChooser();
        this.JDFFechaF = new JDateChooser();
        this.JCBTipodeInforme = new JComboBox<>();
        this.JBTActualizar = new JButton();
        this.JCBEmpresas = new JComboBox<>();
        this.JTBLimpiar = new JButton();
        this.jPanel4 = new JPanel();
        this.jScrollPane1 = new JScrollPane();
        this.Jtable = new JTable();
        this.jPanel2 = new JPanel();
        this.JTFRuta = new JTextField();
        this.JBTExportar = new JButton();
        setClosable(true);
        setIconifiable(true);
        setTitle("Informe Generales PyP");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("InformeGeneralPyP");
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "FILTRO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JDFFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFFechaI.setFont(new Font("Arial", 1, 12));
        this.JDFFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Fin", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFFechaF.setFont(new Font("Arial", 1, 12));
        this.JCBTipodeInforme.setFont(new Font("Arial", 1, 12));
        this.JCBTipodeInforme.setModel(new DefaultComboBoxModel(new String[]{"   ", "Informe VIH SIFILIS", "Informe Control Prenatal", "Informe Control Prenatal  AIC"}));
        this.JCBTipodeInforme.setBorder(BorderFactory.createTitledBorder((Border) null, "Informe", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTipodeInforme.addItemListener(new ItemListener() { // from class: com.genoma.plus.controller.sig.JIFInformesGeneralesPyP.1
            public void itemStateChanged(ItemEvent evt) {
                JIFInformesGeneralesPyP.this.JCBTipodeInformeItemStateChanged(evt);
            }
        });
        this.JBTActualizar.setFont(new Font("Arial", 1, 12));
        this.JBTActualizar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/actualizar.png")));
        this.JBTActualizar.setText("ACTUALIZAR");
        this.JBTActualizar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.sig.JIFInformesGeneralesPyP.2
            public void actionPerformed(ActionEvent evt) {
                JIFInformesGeneralesPyP.this.JBTActualizarActionPerformed(evt);
            }
        });
        this.JCBEmpresas.setBorder(BorderFactory.createTitledBorder((Border) null, "Empresa", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTBLimpiar.setFont(new Font("Arial", 1, 12));
        this.JTBLimpiar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Limpiar.png")));
        this.JTBLimpiar.setText("LIMPIAR");
        this.JTBLimpiar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.sig.JIFInformesGeneralesPyP.3
            public void actionPerformed(ActionEvent evt) {
                JIFInformesGeneralesPyP.this.JTBLimpiarActionPerformed(evt);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.JDFFechaI, -2, 129, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JDFFechaF, -2, 129, -2).addGap(0, 0, 32767)).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.JCBEmpresas, -2, 389, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBTipodeInforme, -2, 404, -2).addGap(18, 18, 18).addComponent(this.JTBLimpiar, -1, -1, 32767).addGap(18, 18, 18).addComponent(this.JBTActualizar, -2, 147, -2))).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JDFFechaF, -2, 50, -2).addComponent(this.JDFFechaI, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBTipodeInforme, -2, 50, -2).addComponent(this.JCBEmpresas, -2, 50, -2).addComponent(this.JBTActualizar).addComponent(this.JTBLimpiar)).addGap(6, 6, 6)));
        this.jPanel4.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.Jtable.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.jScrollPane1.setViewportView(this.Jtable);
        GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
        this.jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane1, -2, 1130, -2).addContainerGap(-1, 32767)));
        jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addComponent(this.jScrollPane1, -2, 277, -2).addGap(0, 10, 32767)));
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.sig.JIFInformesGeneralesPyP.4
            public void mouseClicked(MouseEvent evt) {
                JIFInformesGeneralesPyP.this.JTFRutaMouseClicked(evt);
            }
        });
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(this.JTFRuta, -2, 695, -2).addContainerGap(24, 32767)));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGap(7, 7, 7).addComponent(this.JTFRuta, -2, 50, -2).addGap(5, 5, 5)));
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setForeground(Color.red);
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.sig.JIFInformesGeneralesPyP.5
            public void actionPerformed(ActionEvent evt) {
                JIFInformesGeneralesPyP.this.JBTExportarActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.jPanel4, -2, -1, -2)).addGroup(layout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.jPanel1, -1, -1, 32767))).addGap(10, 10, 10)).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel2, -2, -1, -2).addGap(18, 18, 18).addComponent(this.JBTExportar, -2, 413, -2).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.jPanel1, -1, -1, 32767).addGap(10, 10, 10).addComponent(this.jPanel4, -2, -1, -2).addGap(5, 5, 5).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel2, -2, -1, -2).addComponent(this.JBTExportar, -2, 52, -2)).addGap(5, 5, 5)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTActualizarActionPerformed(ActionEvent evt) {
        this.xInformeGeneralesPyPDAO.mEjecutarSql(this.xmt.formatoAMD1.format(this.JDFFechaI.getDate()), this.xmt.formatoAMD1.format(this.JDFFechaF.getDate()), this.xidEmpresa[this.JCBEmpresas.getSelectedIndex()], this.idInforme);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBTipodeInformeItemStateChanged(ItemEvent evt) {
        if (this.JCBTipodeInforme.getSelectedIndex() == 1) {
            this.idInforme = "1";
        } else if (this.JCBTipodeInforme.getSelectedIndex() == 2) {
            this.idInforme = "3";
        } else if (this.JCBTipodeInforme.getSelectedIndex() == 3) {
            this.idInforme = "4";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBLimpiarActionPerformed(ActionEvent evt) {
        if (this.JCBTipodeInforme.getSelectedIndex() == 1) {
            this.xInformeGeneralesPyPDAO.mLimpiarTabla("1");
        } else if (this.JCBTipodeInforme.getSelectedIndex() == 2) {
            this.xInformeGeneralesPyPDAO.mLimpiarTabla("p_res_informespyp_res");
        } else if (this.JCBTipodeInforme.getSelectedIndex() == 3) {
            this.xInformeGeneralesPyPDAO.mLimpiarTabla("p_res_informespyp_res");
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
        this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.Jtable, this.JTFRuta.getText() + ".xls", getTitle());
    }

    public void buscar() {
        System.out.print("busca");
        if (this.idInforme.equals("1")) {
            System.err.println("1");
            BuscarInformeTipo1();
        } else if (this.idInforme.equals("3")) {
            System.err.println("3");
            BuscarInformeTipo2();
        } else if (this.idInforme.equals("4")) {
            System.err.println("4");
            BuscarInformeTipo3();
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void modeloTipoInforme1() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Total de gestantes que recibieron asesoría pre-prueba VIH en el I trimestre de embarazo durante el mes informado", "Total de gestantes que recibieron asesoría pre-prueba VIH en el II trimestre de embarazo durante el mes informado", "Total de gestantes que recibieron asesoría pre-prueba VIH en el III trimestre de embarazo durante el mes informado", "Total de gestantes que NO aceptaron asesoría pre-prueba durante el periodo informado", "Total gestantes que se tomaron la prueba de tamizaje VIH en el I trimestre de embarazo durante el mes informado", "Total gestantes que se tomaron la prueba de tamizaje VIH en el II trimestre de embarazo durante el mes informado", "Total gestantes que se tomaron la prueba de tamizaje VIH en el III trimestre de embarazo durante el mes informado ", "Total gestantes que se tomaron la prueba de tamizaje para sífilis en el I trimestre de embarazo durante el mes informado", "Total gestantes que se tomaron la prueba de tamizaje para sífilis en el II trimestre de embarazo durante el mes informado", "Total gestantes que se tomaron la prueba de tamizaje para sífilis en el III trimestre de embarazo durante el mes informado", "Total gestantes que se tomaron la prueba de tamizaje para sífilis en el intraparto durante el periodo informado", "Total de gestantes diagnosticadas con sífilis durante el periodo informado", "Total casos de sífilis congénita durante el periodo informado"}) { // from class: com.genoma.plus.controller.sig.JIFInformesGeneralesPyP.6
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.Jtable;
        JTable jTable2 = this.Jtable;
        jTable.setAutoResizeMode(0);
        this.Jtable.doLayout();
        this.Jtable.setModel(this.xmodelo);
        this.Jtable.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.Jtable.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.Jtable.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.Jtable.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.Jtable.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.Jtable.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.Jtable.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.Jtable.getColumnModel().getColumn(7).setPreferredWidth(100);
        this.Jtable.getColumnModel().getColumn(8).setPreferredWidth(100);
        this.Jtable.getColumnModel().getColumn(9).setPreferredWidth(100);
        this.Jtable.getColumnModel().getColumn(10).setPreferredWidth(100);
        this.Jtable.getColumnModel().getColumn(11).setPreferredWidth(100);
        this.Jtable.getColumnModel().getColumn(12).setPreferredWidth(100);
        this.Jtable.getColumnModel().getColumn(13).setPreferredWidth(100);
    }

    private void BuscarInformeTipo1() {
        modeloTipoInforme1();
        List<Object[]> list1 = this.xInformeGeneralesPyPDAO.ListadoInformaTipo1();
        long xnfila = 0;
        if (list1.size() >= 1) {
            this.xmt.mEstablecerTextEditor(this.Jtable, 13);
            for (int x = 0; x < list1.size(); x++) {
                this.xmodelo.addRow(this.xdato);
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
                xnfila++;
            }
        }
    }

    private void BuscarInformeTipo2() {
        modeloTipoInforme2();
        List<Object[]> list1 = this.xInformeGeneralesPyPDAO.ListadoInformaTipo2();
        long xnfila = 0;
        if (list1.size() >= 1) {
            this.xmt.mEstablecerTextEditor(this.Jtable, 36);
            for (int x = 0; x < list1.size(); x++) {
                this.xmodelo.addRow(this.xdato);
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
                this.xmodelo.setValueAt(list1.get(x)[35], x, 35);
                this.xmodelo.setValueAt(list1.get(x)[36], x, 36);
                xnfila++;
            }
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void modeloTipoInforme2() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"   Eps  ", "   Regimen  ", "   FechaIngreso  ", "   GrupoPoblacioal  ", "   IdPersona  ", "   Nombres  ", "   Apellidos  ", "   TipoDoc  ", "   Ndocumento  ", "   FechaNac  ", "   Sexo  ", "   Etnia  ", "   Dirreccion  ", "  Telefono ", "  CodigoM ", "  SemanaDeGestacionI ", "  SemanaDeGestacionA ", "  RiesgoOsbtetrico ", "  DxGestante ", "  FechaVIHTrimeste1 ", "  ValorVih1 ", "  FechaVIHTrimeste2 ", "  ValorVih2 ", "  FechaVIHTrimeste3 ", "  ValorVih3 ", "  FechaSifilisTrimeste1 ", "  ValorSifilis1 ", "  FechaSifilisTrimeste2 ", "  ValorSifilis2 ", "  FechaSifilisTrimeste3 ", "  ValorSifilis3 ", "  FUM ", "  FPP ", "  FechaPrimercontrol ", "  FechaUltimoControl ", "  Peso ", "  Talla"}) { // from class: com.genoma.plus.controller.sig.JIFInformesGeneralesPyP.7
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.Jtable;
        JTable jTable2 = this.Jtable;
        jTable.setAutoResizeMode(0);
        this.Jtable.doLayout();
        this.Jtable.setModel(this.xmodelo);
        this.Jtable.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.Jtable.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.Jtable.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.Jtable.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.Jtable.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.Jtable.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.Jtable.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.Jtable.getColumnModel().getColumn(7).setPreferredWidth(100);
        this.Jtable.getColumnModel().getColumn(8).setPreferredWidth(100);
        this.Jtable.getColumnModel().getColumn(9).setPreferredWidth(100);
        this.Jtable.getColumnModel().getColumn(10).setPreferredWidth(100);
        this.Jtable.getColumnModel().getColumn(11).setPreferredWidth(100);
        this.Jtable.getColumnModel().getColumn(12).setPreferredWidth(100);
        this.Jtable.getColumnModel().getColumn(13).setPreferredWidth(100);
        this.Jtable.getColumnModel().getColumn(14).setPreferredWidth(100);
        this.Jtable.getColumnModel().getColumn(15).setPreferredWidth(100);
        this.Jtable.getColumnModel().getColumn(16).setPreferredWidth(100);
        this.Jtable.getColumnModel().getColumn(17).setPreferredWidth(100);
        this.Jtable.getColumnModel().getColumn(18).setPreferredWidth(100);
        this.Jtable.getColumnModel().getColumn(19).setPreferredWidth(100);
        this.Jtable.getColumnModel().getColumn(20).setPreferredWidth(100);
        this.Jtable.getColumnModel().getColumn(21).setPreferredWidth(100);
        this.Jtable.getColumnModel().getColumn(22).setPreferredWidth(100);
        this.Jtable.getColumnModel().getColumn(23).setPreferredWidth(100);
        this.Jtable.getColumnModel().getColumn(24).setPreferredWidth(100);
        this.Jtable.getColumnModel().getColumn(25).setPreferredWidth(100);
        this.Jtable.getColumnModel().getColumn(26).setPreferredWidth(100);
        this.Jtable.getColumnModel().getColumn(27).setPreferredWidth(100);
        this.Jtable.getColumnModel().getColumn(28).setPreferredWidth(100);
        this.Jtable.getColumnModel().getColumn(29).setPreferredWidth(100);
        this.Jtable.getColumnModel().getColumn(30).setPreferredWidth(100);
        this.Jtable.getColumnModel().getColumn(31).setPreferredWidth(100);
        this.Jtable.getColumnModel().getColumn(32).setPreferredWidth(100);
        this.Jtable.getColumnModel().getColumn(33).setPreferredWidth(100);
        this.Jtable.getColumnModel().getColumn(34).setPreferredWidth(100);
        this.Jtable.getColumnModel().getColumn(35).setPreferredWidth(100);
    }

    private void BuscarInformeTipo3() {
        modeloTipoInforme3();
        List<Object[]> list1 = this.xInformeGeneralesPyPDAO.ListadoInformaTipo3();
        long xnfila = 0;
        if (list1.size() >= 1) {
            this.xmt.mEstablecerTextEditor(this.Jtable, 69);
            for (int x = 0; x < list1.size(); x++) {
                this.xmodelo.addRow(this.xdato);
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
                this.xmodelo.setValueAt(list1.get(x)[35], x, 35);
                this.xmodelo.setValueAt(list1.get(x)[36], x, 36);
                this.xmodelo.setValueAt(list1.get(x)[37], x, 37);
                this.xmodelo.setValueAt(list1.get(x)[38], x, 38);
                this.xmodelo.setValueAt(list1.get(x)[39], x, 39);
                this.xmodelo.setValueAt(list1.get(x)[40], x, 40);
                this.xmodelo.setValueAt(list1.get(x)[41], x, 41);
                this.xmodelo.setValueAt(list1.get(x)[42], x, 42);
                this.xmodelo.setValueAt(list1.get(x)[43], x, 43);
                this.xmodelo.setValueAt(list1.get(x)[44], x, 44);
                this.xmodelo.setValueAt(list1.get(x)[45], x, 45);
                this.xmodelo.setValueAt(list1.get(x)[46], x, 46);
                this.xmodelo.setValueAt(list1.get(x)[47], x, 47);
                this.xmodelo.setValueAt(list1.get(x)[48], x, 48);
                this.xmodelo.setValueAt(list1.get(x)[49], x, 49);
                this.xmodelo.setValueAt(list1.get(x)[50], x, 50);
                this.xmodelo.setValueAt(list1.get(x)[51], x, 51);
                this.xmodelo.setValueAt(list1.get(x)[52], x, 52);
                this.xmodelo.setValueAt(list1.get(x)[53], x, 53);
                this.xmodelo.setValueAt(list1.get(x)[54], x, 54);
                this.xmodelo.setValueAt(list1.get(x)[55], x, 55);
                this.xmodelo.setValueAt(list1.get(x)[56], x, 56);
                this.xmodelo.setValueAt(list1.get(x)[57], x, 57);
                this.xmodelo.setValueAt(list1.get(x)[58], x, 58);
                this.xmodelo.setValueAt(list1.get(x)[59], x, 59);
                this.xmodelo.setValueAt(list1.get(x)[60], x, 60);
                this.xmodelo.setValueAt(list1.get(x)[61], x, 61);
                this.xmodelo.setValueAt(list1.get(x)[62], x, 62);
                this.xmodelo.setValueAt(list1.get(x)[63], x, 63);
                this.xmodelo.setValueAt(list1.get(x)[64], x, 64);
                this.xmodelo.setValueAt(list1.get(x)[65], x, 65);
                this.xmodelo.setValueAt(list1.get(x)[66], x, 66);
                this.xmodelo.setValueAt(list1.get(x)[67], x, 67);
                this.xmodelo.setValueAt(list1.get(x)[68], x, 68);
                xnfila++;
            }
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void modeloTipoInforme3() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "IdPersona", "Nombres", "Apellidos", "TipoDoc", "Ndocumento", "EstadoCiVil", "Ocupacion", "FechaNac", "GestacionActual", "FechaIngreso", "FechaPrimeraCita", "Regimen", "Eps", "Municipio", "Zona", "Dirreccion", "Telefono", "Etnia", "NivelAcademico", "EmbarazoAceptado", "ApoyoFamiliar", "VictimaMaltrato", "GrupoPoblacioal", "AntecedenteHipertensionEm", "NacidoVivo", "Npartos", "Nabortos", "Ncesareas", "APerinatal", "AembarazoEtopico", "AenfermedaAutoI", "Adiabetes", "Ahipertensos", "FechaUltimoEmbarazo", "FUM", "SemanaDeGestacionI", "TrimestreIngreso", "SemanaDeGestacionA", "FechaPT1", "Peso1", "Talla1", "IMC1", "ClasificacionN1", "FechaPT2", "Peso2", "Talla2", "IMC2", "ClasificacionN2", "FechaPT3", "Peso3", "Talla3", "IMC3", "ClasificacionN3", "TASistolica20A26", "TADistolica20A26", "TASistolica30A34", "TADistolica30A34", "TASistolica35A37", "TADistolica35A37", "FechaProximaCita", "FechaUltimoControl", "EdadGestacionalUlC", "CantidadControles", "FechaRemisionPsicologia", "FechaCitaPsicologia", "FechaRemisionNutricion", "FechaCitaNutricion", "FechaRemisionGinecologia", "FechaCitaGinecologia"}) { // from class: com.genoma.plus.controller.sig.JIFInformesGeneralesPyP.8
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.Jtable;
        JTable jTable2 = this.Jtable;
        jTable.setAutoResizeMode(0);
        this.Jtable.doLayout();
        this.Jtable.setModel(this.xmodelo);
        this.Jtable.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.Jtable.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.Jtable.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.Jtable.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.Jtable.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.Jtable.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.Jtable.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.Jtable.getColumnModel().getColumn(7).setPreferredWidth(100);
        this.Jtable.getColumnModel().getColumn(8).setPreferredWidth(100);
        this.Jtable.getColumnModel().getColumn(9).setPreferredWidth(100);
        this.Jtable.getColumnModel().getColumn(10).setPreferredWidth(100);
        this.Jtable.getColumnModel().getColumn(11).setPreferredWidth(100);
        this.Jtable.getColumnModel().getColumn(12).setPreferredWidth(100);
        this.Jtable.getColumnModel().getColumn(13).setPreferredWidth(100);
        this.Jtable.getColumnModel().getColumn(14).setPreferredWidth(100);
        this.Jtable.getColumnModel().getColumn(15).setPreferredWidth(100);
        this.Jtable.getColumnModel().getColumn(16).setPreferredWidth(100);
        this.Jtable.getColumnModel().getColumn(17).setPreferredWidth(100);
        this.Jtable.getColumnModel().getColumn(18).setPreferredWidth(100);
        this.Jtable.getColumnModel().getColumn(19).setPreferredWidth(100);
        this.Jtable.getColumnModel().getColumn(20).setPreferredWidth(100);
        this.Jtable.getColumnModel().getColumn(21).setPreferredWidth(100);
        this.Jtable.getColumnModel().getColumn(22).setPreferredWidth(100);
        this.Jtable.getColumnModel().getColumn(23).setPreferredWidth(100);
        this.Jtable.getColumnModel().getColumn(24).setPreferredWidth(100);
        this.Jtable.getColumnModel().getColumn(25).setPreferredWidth(100);
        this.Jtable.getColumnModel().getColumn(26).setPreferredWidth(100);
        this.Jtable.getColumnModel().getColumn(27).setPreferredWidth(100);
        this.Jtable.getColumnModel().getColumn(28).setPreferredWidth(100);
        this.Jtable.getColumnModel().getColumn(29).setPreferredWidth(100);
        this.Jtable.getColumnModel().getColumn(30).setPreferredWidth(100);
        this.Jtable.getColumnModel().getColumn(31).setPreferredWidth(100);
        this.Jtable.getColumnModel().getColumn(32).setPreferredWidth(100);
        this.Jtable.getColumnModel().getColumn(33).setPreferredWidth(100);
        this.Jtable.getColumnModel().getColumn(34).setPreferredWidth(100);
        this.Jtable.getColumnModel().getColumn(35).setPreferredWidth(100);
        this.Jtable.getColumnModel().getColumn(36).setPreferredWidth(100);
        this.Jtable.getColumnModel().getColumn(37).setPreferredWidth(100);
        this.Jtable.getColumnModel().getColumn(38).setPreferredWidth(100);
        this.Jtable.getColumnModel().getColumn(39).setPreferredWidth(100);
        this.Jtable.getColumnModel().getColumn(40).setPreferredWidth(100);
        this.Jtable.getColumnModel().getColumn(41).setPreferredWidth(100);
        this.Jtable.getColumnModel().getColumn(42).setPreferredWidth(100);
        this.Jtable.getColumnModel().getColumn(43).setPreferredWidth(100);
        this.Jtable.getColumnModel().getColumn(44).setPreferredWidth(100);
        this.Jtable.getColumnModel().getColumn(45).setPreferredWidth(100);
        this.Jtable.getColumnModel().getColumn(46).setPreferredWidth(100);
        this.Jtable.getColumnModel().getColumn(47).setPreferredWidth(100);
        this.Jtable.getColumnModel().getColumn(48).setPreferredWidth(100);
        this.Jtable.getColumnModel().getColumn(49).setPreferredWidth(100);
        this.Jtable.getColumnModel().getColumn(50).setPreferredWidth(100);
        this.Jtable.getColumnModel().getColumn(51).setPreferredWidth(100);
        this.Jtable.getColumnModel().getColumn(52).setPreferredWidth(100);
        this.Jtable.getColumnModel().getColumn(53).setPreferredWidth(100);
        this.Jtable.getColumnModel().getColumn(54).setPreferredWidth(100);
        this.Jtable.getColumnModel().getColumn(55).setPreferredWidth(100);
        this.Jtable.getColumnModel().getColumn(56).setPreferredWidth(100);
        this.Jtable.getColumnModel().getColumn(57).setPreferredWidth(100);
        this.Jtable.getColumnModel().getColumn(58).setPreferredWidth(100);
        this.Jtable.getColumnModel().getColumn(59).setPreferredWidth(100);
        this.Jtable.getColumnModel().getColumn(60).setPreferredWidth(100);
        this.Jtable.getColumnModel().getColumn(61).setPreferredWidth(100);
        this.Jtable.getColumnModel().getColumn(62).setPreferredWidth(100);
        this.Jtable.getColumnModel().getColumn(63).setPreferredWidth(100);
        this.Jtable.getColumnModel().getColumn(64).setPreferredWidth(100);
        this.Jtable.getColumnModel().getColumn(65).setPreferredWidth(100);
        this.Jtable.getColumnModel().getColumn(66).setPreferredWidth(100);
        this.Jtable.getColumnModel().getColumn(67).setPreferredWidth(100);
        this.Jtable.getColumnModel().getColumn(68).setPreferredWidth(100);
    }
}
