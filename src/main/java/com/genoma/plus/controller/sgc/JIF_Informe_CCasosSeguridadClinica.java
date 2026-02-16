package com.genoma.plus.controller.sgc;

import Utilidades.Metodos;
import com.genoma.plus.dao.impl.sgc.SGC_Informes_Consolidado_EventosDAOImpl;
import com.genoma.plus.dao.sgc.SGC_Informes_Consolidado_EventosDAO;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
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
import javax.swing.JFileChooser;
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
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/sgc/JIF_Informe_CCasosSeguridadClinica.class */
public class JIF_Informe_CCasosSeguridadClinica extends JInternalFrame {
    private Metodos xmt = new Metodos();
    private SGC_Informes_Consolidado_EventosDAO consolidado_EventosDAO;
    private DefaultTableModel xModelo1;
    private DefaultTableModel xModelo2;
    private DefaultTableModel xModelo3;
    private Object[] xDato;
    private JButton JBTExportar;
    private JDateChooser JDFechaF;
    private JDateChooser JDFechaI;
    private JScrollPane JSP_Datos1;
    private JScrollPane JSP_Datos2;
    private JScrollPane JSP_Datos3;
    private JTable JTB_Datos1;
    private JTable JTB_Datos2;
    private JTable JTB_Datos3;
    private JTextField JTFRuta;
    private JTextField JTF_NEventos;
    private JTabbedPane JTP_Datos;
    private JPanel jPanel1;

    public JIF_Informe_CCasosSeguridadClinica() {
        initComponents();
        springStart();
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v32, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v35, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v38, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jPanel1 = new JPanel();
        this.JDFechaI = new JDateChooser();
        this.JDFechaF = new JDateChooser();
        this.JTF_NEventos = new JTextField();
        this.JTP_Datos = new JTabbedPane();
        this.JSP_Datos1 = new JScrollPane();
        this.JTB_Datos1 = new JTable();
        this.JSP_Datos2 = new JScrollPane();
        this.JTB_Datos2 = new JTable();
        this.JSP_Datos3 = new JScrollPane();
        this.JTB_Datos3 = new JTable();
        this.JTFRuta = new JTextField();
        this.JBTExportar = new JButton();
        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        setTitle("INFORME CONSOLIDADO CASOS DE SEGURIDAD CLINICA ");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjif_informescasosseguridadclinica");
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "FILTRO", 0, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JDFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicial", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFechaI.setFont(new Font("Arial", 1, 12));
        this.JDFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Final", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFechaF.setFont(new Font("Arial", 1, 12));
        this.JTF_NEventos.setFont(new Font("Arial", 1, 16));
        this.JTF_NEventos.setHorizontalAlignment(0);
        this.JTF_NEventos.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Eventos", 0, 0, new Font("Arial", 1, 12), Color.red));
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(22, 22, 22).addComponent(this.JDFechaI, -2, 136, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JDFechaF, -2, 136, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JTF_NEventos, -2, 129, -2).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JDFechaI, -2, 50, -2).addComponent(this.JDFechaF, -2, 50, -2)).addContainerGap(-1, 32767)).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.JTF_NEventos, -2, -1, -2).addContainerGap()));
        this.JTP_Datos.setForeground(Color.red);
        this.JTP_Datos.setFont(new Font("Arial", 1, 14));
        this.JTB_Datos1.setFont(new Font("Arial", 1, 12));
        this.JTB_Datos1.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTB_Datos1.setRowHeight(25);
        this.JTB_Datos1.setSelectionMode(2);
        this.JSP_Datos1.setViewportView(this.JTB_Datos1);
        this.JTP_Datos.addTab("TIPO DE EVENTO", this.JSP_Datos1);
        this.JTB_Datos2.setFont(new Font("Arial", 1, 12));
        this.JTB_Datos2.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTB_Datos2.setRowHeight(25);
        this.JTB_Datos2.setSelectionMode(2);
        this.JSP_Datos2.setViewportView(this.JTB_Datos2);
        this.JTP_Datos.addTab("CLASIFICACIÓN", this.JSP_Datos2);
        this.JTB_Datos3.setFont(new Font("Arial", 1, 12));
        this.JTB_Datos3.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTB_Datos3.setRowHeight(25);
        this.JTB_Datos3.setSelectionMode(2);
        this.JSP_Datos3.setViewportView(this.JTB_Datos3);
        this.JTP_Datos.addTab("CATEGORÍA", this.JSP_Datos3);
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.sgc.JIF_Informe_CCasosSeguridadClinica.1
            public void mouseClicked(MouseEvent evt) {
                JIF_Informe_CCasosSeguridadClinica.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setForeground(Color.red);
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.sgc.JIF_Informe_CCasosSeguridadClinica.2
            public void actionPerformed(ActionEvent evt) {
                JIF_Informe_CCasosSeguridadClinica.this.JBTExportarActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -1, -1, 32767).addComponent(this.JTP_Datos).addGroup(layout.createSequentialGroup().addComponent(this.JTFRuta, -2, 374, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBTExportar, -2, 225, -2).addGap(0, 381, 32767))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTP_Datos, -2, 334, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFRuta, -2, 50, -2).addComponent(this.JBTExportar, -1, 50, 32767)).addContainerGap(-1, 32767)));
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
            if (this.JTP_Datos.getSelectedIndex() == 0) {
                if (this.JTB_Datos1.getRowCount() != -1) {
                    int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMAR", 0, 3, new ImageIcon("src/Imagenes/Question2.png"));
                    if (n == 0) {
                        this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTB_Datos1, this.JTFRuta.getText(), getTitle() + " : " + this.JTP_Datos.getTitleAt(0));
                        return;
                    }
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "No existe información para exportar", "VERIFICAR", 1, new ImageIcon("src/Imagenes/Information2.png"));
                return;
            }
            if (this.JTP_Datos.getSelectedIndex() == 1) {
                if (this.JTB_Datos2.getRowCount() != -1) {
                    int n2 = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMAR", 0, 3, new ImageIcon("src/Imagenes/Question2.png"));
                    if (n2 == 0) {
                        this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTB_Datos2, this.JTFRuta.getText(), getTitle() + " : " + this.JTP_Datos.getTitleAt(1));
                        return;
                    }
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "No existe información para exportar", "VERIFICAR", 1, new ImageIcon("src/Imagenes/Information2.png"));
                return;
            }
            if (this.JTP_Datos.getSelectedIndex() == 2) {
                if (this.JTB_Datos3.getRowCount() != -1) {
                    int n3 = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMAR", 0, 3, new ImageIcon("src/Imagenes/Question2.png"));
                    if (n3 == 0) {
                        this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTB_Datos3, this.JTFRuta.getText(), getTitle() + " : " + this.JTP_Datos.getTitleAt(2));
                        return;
                    }
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "No existe información para exportar", "VERIFICAR", 1, new ImageIcon("src/Imagenes/Information2.png"));
                return;
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un ruta valida", "VERIFICAR", 1, new ImageIcon("src/Imagenes/Information2.png"));
        this.JTFRuta.requestFocus();
    }

    public void mNuevo() {
        this.JDFechaI.setDate(this.xmt.getFechaActual());
        this.JDFechaF.setDate(this.xmt.getFechaActual());
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
        mCrearModeloDatos1();
        mCrearModeloDatos2();
        mCrearModeloDatos3();
    }

    public void mBuscar() {
        mCargarDatos1();
        mCargarDatos2();
        mCargarDatos3();
    }

    private void springStart() {
        this.consolidado_EventosDAO = (SGC_Informes_Consolidado_EventosDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("sGCInformesConsolidadoEventosDAO");
    }

    private void mCrearModeloDatos1() {
        this.xModelo1 = new DefaultTableModel((Object[][]) null, new String[]{"Proceso", "Evento", "Cantidad", "%"}) { // from class: com.genoma.plus.controller.sgc.JIF_Informe_CCasosSeguridadClinica.3
            Class[] types = {String.class, String.class, Long.class, Double.class};
            boolean[] canEdit = {false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTB_Datos1.setModel(this.xModelo1);
        this.JTB_Datos1.getColumnModel().getColumn(0).setPreferredWidth(150);
        this.JTB_Datos1.getColumnModel().getColumn(1).setPreferredWidth(300);
        this.JTB_Datos1.getColumnModel().getColumn(2).setPreferredWidth(50);
        this.JTB_Datos1.getColumnModel().getColumn(3).setPreferredWidth(50);
    }

    private void mCrearModeloDatos2() {
        this.xModelo2 = new DefaultTableModel((Object[][]) null, new String[]{"Nombre", "Cantidad", "%"}) { // from class: com.genoma.plus.controller.sgc.JIF_Informe_CCasosSeguridadClinica.4
            Class[] types = {String.class, Long.class, Double.class};
            boolean[] canEdit = {false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTB_Datos2.setModel(this.xModelo2);
        this.JTB_Datos2.getColumnModel().getColumn(0).setPreferredWidth(300);
        this.JTB_Datos2.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTB_Datos2.getColumnModel().getColumn(2).setPreferredWidth(100);
    }

    private void mCrearModeloDatos3() {
        this.xModelo3 = new DefaultTableModel((Object[][]) null, new String[]{"Nombre", "Cantidad", "%"}) { // from class: com.genoma.plus.controller.sgc.JIF_Informe_CCasosSeguridadClinica.5
            Class[] types = {String.class, Long.class, Double.class};
            boolean[] canEdit = {false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTB_Datos3.setModel(this.xModelo3);
        this.JTB_Datos3.getColumnModel().getColumn(0).setPreferredWidth(300);
        this.JTB_Datos3.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTB_Datos3.getColumnModel().getColumn(2).setPreferredWidth(100);
    }

    private void mCargarDatos1() {
        mCrearModeloDatos1();
        List<Object[]> listAccion = this.consolidado_EventosDAO.informeConsolidadoTipoEvento(this.xmt.formatoAMD1.format(this.JDFechaI.getDate()), this.xmt.formatoAMD1.format(this.JDFechaF.getDate()));
        this.xmt.mEstablecerTextEditor(this.JTB_Datos1, 2);
        this.xmt.mEstablecerTextEditor(this.JTB_Datos1, 1);
        for (int x = 0; x < listAccion.size(); x++) {
            this.xModelo1.addRow(this.xDato);
            this.xModelo1.setValueAt(listAccion.get(x)[0], x, 0);
            this.xModelo1.setValueAt(listAccion.get(x)[1], x, 1);
            this.xModelo1.setValueAt(listAccion.get(x)[2], x, 2);
            this.xModelo1.setValueAt(listAccion.get(x)[4], x, 3);
            this.JTF_NEventos.setText(listAccion.get(x)[3].toString());
        }
    }

    private void mCargarDatos2() {
        mCrearModeloDatos2();
        List<Object[]> listAccion = this.consolidado_EventosDAO.informeConsolidadoTipoClasificacion(this.xmt.formatoAMD1.format(this.JDFechaI.getDate()), this.xmt.formatoAMD1.format(this.JDFechaF.getDate()));
        for (int x = 0; x < listAccion.size(); x++) {
            this.xModelo2.addRow(this.xDato);
            this.xModelo2.setValueAt(listAccion.get(x)[0], x, 0);
            this.xModelo2.setValueAt(listAccion.get(x)[1], x, 1);
            this.xModelo2.setValueAt(listAccion.get(x)[3], x, 2);
        }
    }

    private void mCargarDatos3() {
        mCrearModeloDatos3();
        List<Object[]> listAccion = this.consolidado_EventosDAO.informeConsolidadoTipoCategoria(this.xmt.formatoAMD1.format(this.JDFechaI.getDate()), this.xmt.formatoAMD1.format(this.JDFechaF.getDate()));
        for (int x = 0; x < listAccion.size(); x++) {
            this.xModelo3.addRow(this.xDato);
            this.xModelo3.setValueAt(listAccion.get(x)[0], x, 0);
            this.xModelo3.setValueAt(listAccion.get(x)[1], x, 1);
            this.xModelo3.setValueAt(listAccion.get(x)[3], x, 2);
        }
    }
}
