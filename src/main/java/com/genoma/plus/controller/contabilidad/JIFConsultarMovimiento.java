package com.genoma.plus.controller.contabilidad;

import Utilidades.Metodos;
import Utilidades.WorkerSQL;
import com.genoma.plus.dao.contabilidad.LibroDiarioDAO;
import com.genoma.plus.dao.impl.contabilidad.LibroDiarioDAOImpl;
import com.toedter.calendar.JDateChooser;
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
import javax.swing.JCheckBox;
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

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/contabilidad/JIFConsultarMovimiento.class */
public class JIFConsultarMovimiento extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private Object[] xdato;
    private WorkerSQL xWorkerSQL;
    private LibroDiarioDAO xLibroDiarioDAO;
    private JButton JBExportar;
    private JCheckBox JCHVisualizarNiif;
    public JDateChooser JDFFechaF;
    public JDateChooser JDFFechaI;
    private JScrollPane JSDetalle;
    private JTable JTDetalle;
    private JTextField JTFRuta;
    private JPanel jPanel2;
    private Metodos xmt = new Metodos();
    private int xEsNiif = 0;

    public JIFConsultarMovimiento() {
        initComponents();
        springStart();
        mNuevo();
    }

    private void springStart() {
        this.xLibroDiarioDAO = (LibroDiarioDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("libroDiarioDAO");
    }

    public void mNuevo() {
        this.JDFFechaI.setDate(this.xmt.getFechaActual());
        this.JDFFechaF.setDate(this.xmt.getFechaActual());
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
        mCrearModeloDatos();
    }

    public void mBuscar() {
        this.xWorkerSQL = null;
        this.xWorkerSQL = new WorkerSQL("Cargando Informacion...", this);
        this.xWorkerSQL.execute();
    }

    public void mImprimir() {
        if (this.JTDetalle.getRowCount() != -1) {
            String[][] mparametros = new String[4][2];
            mparametros[0][0] = "FechaI";
            mparametros[0][1] = this.xmt.formatoAMD.format(this.JDFFechaI.getDate());
            mparametros[1][0] = "FechaF";
            mparametros[1][1] = this.xmt.formatoAMD.format(this.JDFFechaF.getDate());
            mparametros[2][0] = "SUBREPORT_DIR";
            mparametros[2][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
            mparametros[3][0] = "SUBREPORTFIRMA_DIR";
            mparametros[3][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
            this.xmt.GenerarPDF(this.xmt.getRutaRep() + "CC_libro_Diario", mparametros);
        }
    }

    public void mCargarDatosTabla() {
        List<Object[]> list = this.xLibroDiarioDAO.listadoLibroDiario(this.xmt.formatoAMD1.format(this.JDFFechaI.getDate()), this.xmt.formatoAMD1.format(this.JDFFechaF.getDate()), this.xEsNiif);
        Double totalDebito = Double.valueOf(0.0d);
        double totalCredito = 0.0d;
        mCrearModeloDatos();
        for (int x = 0; x < list.size(); x++) {
            this.xmodelo.addRow(this.xdato);
            this.xmodelo.setValueAt(list.get(x)[0], x, 0);
            this.xmodelo.setValueAt(list.get(x)[1], x, 1);
            this.xmodelo.setValueAt(list.get(x)[2], x, 2);
            this.xmodelo.setValueAt(list.get(x)[3], x, 3);
            this.xmodelo.setValueAt(list.get(x)[4], x, 4);
            this.xmodelo.setValueAt(list.get(x)[5], x, 5);
            this.xmodelo.setValueAt(list.get(x)[6], x, 6);
            this.xmodelo.setValueAt(list.get(x)[7], x, 7);
            this.xmodelo.setValueAt(list.get(x)[8], x, 8);
            this.xmodelo.setValueAt(list.get(x)[9], x, 9);
            this.xmodelo.setValueAt(list.get(x)[10], x, 10);
            this.xmodelo.setValueAt(list.get(x)[11], x, 11);
            this.xmodelo.setValueAt(list.get(x)[12], x, 12);
            this.xmodelo.setValueAt(list.get(x)[13], x, 13);
            this.xmodelo.setValueAt(list.get(x)[14], x, 14);
            this.xmodelo.setValueAt(list.get(x)[15], x, 15);
            this.xmodelo.setValueAt(list.get(x)[16], x, 16);
            this.xmodelo.setValueAt(list.get(x)[17], x, 17);
            this.xmodelo.setValueAt(list.get(x)[18], x, 18);
            this.xmodelo.setValueAt(list.get(x)[19], x, 19);
            totalDebito = Double.valueOf(totalDebito.doubleValue() + Double.parseDouble(list.get(x)[10].toString()));
            totalCredito += Double.parseDouble(list.get(x)[11].toString());
        }
        this.xmodelo.addRow(this.xdato);
        this.xmodelo.setValueAt("Totales", list.size(), 0);
        this.xmodelo.setValueAt(totalDebito, list.size(), 10);
        this.xmodelo.setValueAt(Double.valueOf(totalCredito), list.size(), 11);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Fecha Periodo", "CodigoDoc", "Documento", "Tipo Documento", "Tercero", "FechaC", "N° Doc", "Puc", "Cuenta", "Naturaleza", "V/Debito", "V/Credito", "Base", "DescripciónG", "DescripciónE", "Estado", "Fecha Anulado", "Motivo Anulación", "Usuario Anulo", "NConsecutivo"}) { // from class: com.genoma.plus.controller.contabilidad.JIFConsultarMovimiento.1
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, Long.class, String.class, String.class, String.class, Double.class, Double.class, Double.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

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
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(1).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(1).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(3).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(3).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(5).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(5).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(8).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(8).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(12).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(12).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(12).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(13).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(13).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(13).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(14).setPreferredWidth(400);
        this.JTDetalle.getColumnModel().getColumn(15).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(15).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(15).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(16).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(16).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(16).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(17).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(17).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(17).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(18).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(18).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(18).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(19).setPreferredWidth(80);
    }

    /* JADX WARN: Type inference failed for: r3v6, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JSDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.jPanel2 = new JPanel();
        this.JBExportar = new JButton();
        this.JTFRuta = new JTextField();
        this.JDFFechaI = new JDateChooser();
        this.JDFFechaF = new JDateChooser();
        this.JCHVisualizarNiif = new JCheckBox();
        setClosable(true);
        setIconifiable(true);
        setTitle("CONSULTAR MOVIMIENTOS POR RANGO DE FECHA");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("MovimientoxRFecha");
        this.JSDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setSelectionBackground(Color.white);
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JSDetalle.setViewportView(this.JTDetalle);
        this.JBExportar.setFont(new Font("Arial", 1, 12));
        this.JBExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBExportar.setText("Exportar");
        this.JBExportar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.contabilidad.JIFConsultarMovimiento.2
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarMovimiento.this.JBExportarActionPerformed(evt);
            }
        });
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.contabilidad.JIFConsultarMovimiento.3
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarMovimiento.this.JTFRutaMouseClicked(evt);
            }
        });
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(this.JTFRuta).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBExportar, -2, 149, -2).addContainerGap()));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGap(3, 3, 3).addComponent(this.JTFRuta, -2, 50, -2).addContainerGap(11, 32767)).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.JBExportar, -2, 50, -2).addGap(0, 0, 32767)));
        this.JDFFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFFechaI.setFont(new Font("Arial", 1, 12));
        this.JDFFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Fin", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFFechaF.setFont(new Font("Arial", 1, 12));
        this.JCHVisualizarNiif.setFont(new Font("Arial", 1, 13));
        this.JCHVisualizarNiif.setText("Visualizacion NIIF");
        this.JCHVisualizarNiif.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.contabilidad.JIFConsultarMovimiento.4
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarMovimiento.this.JCHVisualizarNiifActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel2, -1, -1, 32767).addComponent(this.JSDetalle, -1, 814, 32767).addGroup(layout.createSequentialGroup().addComponent(this.JDFFechaI, -2, 121, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JDFFechaF, -2, 121, -2).addGap(18, 18, 18).addComponent(this.JCHVisualizarNiif).addGap(0, 0, 32767))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(20, 20, 20).addComponent(this.JCHVisualizarNiif)).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JDFFechaI, -2, 54, -2).addComponent(this.JDFFechaF, -2, 54, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSDetalle, -2, 472, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel2, -2, -1, -2).addGap(10, 10, 10)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBExportarActionPerformed(ActionEvent evt) {
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTDetalle, this.JTFRuta.getText(), getTitle());
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
    public void JCHVisualizarNiifActionPerformed(ActionEvent evt) {
        if (this.JCHVisualizarNiif.isSelected()) {
            this.xEsNiif = 1;
        } else {
            this.xEsNiif = 0;
        }
    }
}
