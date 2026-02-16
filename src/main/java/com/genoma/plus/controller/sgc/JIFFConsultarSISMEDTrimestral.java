package com.genoma.plus.controller.sgc;

import Acceso.Principal;
import Utilidades.Metodos;
import com.genoma.plus.dao.sgc.ConsultaSIMEDTrimestralDAO;
import com.genoma.plus.dto.sgc.ConsultaSIMEDTrimestralDTO;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Formatter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/sgc/JIFFConsultarSISMEDTrimestral.class */
public class JIFFConsultarSISMEDTrimestral extends JInternalFrame {
    public ConsultaSIMEDTrimestralDAO xConsultaSIMEDTrimestralDAO;
    private DefaultTableModel xModeloC;
    private DefaultTableModel xModeloV;
    private DefaultTableModel xTxt;
    private Object[] xDatoC;
    private Object[] xDatoV;
    private File xfile;
    private String usarRuta;
    private String fechaInicio;
    private String fechaFin;
    private Double sumaTotalV;
    private Double sumaTotalC;
    private JButton JBGenerateTXT;
    private JButton JBTExportar;
    private JDateChooser JDFechaF;
    private JDateChooser JDFechaI;
    private JPanel JPDatos;
    private JPanel JPExportar;
    private JScrollPane JSPDetalleConsolidado;
    private JTable JTCompras;
    private JTextField JTFRuta;
    private JPanel jPanel2;
    private JTabbedPane jtpConsultasSIMED;
    private Metodos xmt = new Metodos();
    private ConsultaSIMEDTrimestralDTO consultaSIMEDTrimestralDTO = new ConsultaSIMEDTrimestralDTO();
    String sFichero = "";
    String cantidaMedicamentoV = "";
    String cantidaMedicamentoC = "";
    private DecimalFormat df = new DecimalFormat("###.00");

    public JIFFConsultarSISMEDTrimestral() {
        initComponents();
        springStart();
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v54, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPExportar = new JPanel();
        this.JTFRuta = new JTextField();
        this.JBTExportar = new JButton();
        this.JBGenerateTXT = new JButton();
        this.JPDatos = new JPanel();
        this.JDFechaI = new JDateChooser();
        this.JDFechaF = new JDateChooser();
        this.jtpConsultasSIMED = new JTabbedPane();
        this.jPanel2 = new JPanel();
        this.JSPDetalleConsolidado = new JScrollPane();
        this.JTCompras = new JTable();
        setClosable(true);
        setTitle("Consultar SIMED Trimestral");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jiffConsultarSIMEDTrimestral");
        this.JPExportar.setBorder(BorderFactory.createTitledBorder((Border) null, "EXPORTAR", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.sgc.JIFFConsultarSISMEDTrimestral.1
            public void mouseClicked(MouseEvent evt) {
                JIFFConsultarSISMEDTrimestral.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setForeground(Color.red);
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.sgc.JIFFConsultarSISMEDTrimestral.2
            public void actionPerformed(ActionEvent evt) {
                JIFFConsultarSISMEDTrimestral.this.JBTExportarActionPerformed(evt);
            }
        });
        this.JBGenerateTXT.setIcon(new ImageIcon(getClass().getResource("/Imagenes/TXT_24px.png")));
        this.JBGenerateTXT.setText("Generar");
        this.JBGenerateTXT.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.sgc.JIFFConsultarSISMEDTrimestral.3
            public void actionPerformed(ActionEvent evt) {
                JIFFConsultarSISMEDTrimestral.this.JBGenerateTXTActionPerformed(evt);
            }
        });
        GroupLayout JPExportarLayout = new GroupLayout(this.JPExportar);
        this.JPExportar.setLayout(JPExportarLayout);
        JPExportarLayout.setHorizontalGroup(JPExportarLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPExportarLayout.createSequentialGroup().addContainerGap().addComponent(this.JTFRuta, -2, 462, -2).addGap(18, 18, 18).addComponent(this.JBTExportar).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBGenerateTXT, -1, -1, 32767).addContainerGap()));
        JPExportarLayout.setVerticalGroup(JPExportarLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPExportarLayout.createSequentialGroup().addGroup(JPExportarLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JBTExportar, GroupLayout.Alignment.LEADING, -1, 50, 32767).addComponent(this.JTFRuta, GroupLayout.Alignment.LEADING).addComponent(this.JBGenerateTXT, GroupLayout.Alignment.LEADING, -1, -1, 32767)).addGap(0, 10, 32767)));
        this.JPDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "FILTRO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JPDatos.setPreferredSize(new Dimension(1330, 92));
        this.JDFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicial", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFechaI.setFont(new Font("Arial", 1, 12));
        this.JDFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Final", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFechaF.setFont(new Font("Arial", 1, 12));
        GroupLayout JPDatosLayout = new GroupLayout(this.JPDatos);
        this.JPDatos.setLayout(JPDatosLayout);
        JPDatosLayout.setHorizontalGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosLayout.createSequentialGroup().addComponent(this.JDFechaI, -2, 136, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JDFechaF, -2, 136, -2).addContainerGap(26, 32767)));
        JPDatosLayout.setVerticalGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosLayout.createSequentialGroup().addGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JDFechaI, -2, 56, -2).addComponent(this.JDFechaF, -2, 56, -2)).addGap(10, 10, 10)));
        this.jtpConsultasSIMED.setFont(new Font("Arial", 1, 12));
        this.jtpConsultasSIMED.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.sgc.JIFFConsultarSISMEDTrimestral.4
            public void mouseClicked(MouseEvent evt) {
                JIFFConsultarSISMEDTrimestral.this.jtpConsultasSIMEDMouseClicked(evt);
            }
        });
        this.jPanel2.setFont(new Font("Arial", 1, 12));
        this.JSPDetalleConsolidado.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JSPDetalleConsolidado.setPreferredSize(new Dimension(1330, 426));
        this.JTCompras.setFont(new Font("Arial", 1, 12));
        this.JTCompras.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTCompras.setAutoResizeMode(0);
        this.JSPDetalleConsolidado.setViewportView(this.JTCompras);
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 1073, 32767).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(this.JSPDetalleConsolidado, -2, 0, 32767).addContainerGap())));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 472, 32767).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(this.JSPDetalleConsolidado, -1, 448, 32767).addContainerGap())));
        this.jtpConsultasSIMED.addTab("COMPRAS", this.jPanel2);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(5, 5, 5).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jtpConsultasSIMED).addGroup(layout.createSequentialGroup().addComponent(this.JPDatos, -2, 314, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPExportar, -1, -1, 32767))).addGap(5, 5, 5)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JPExportar, -1, -1, 32767).addComponent(this.JPDatos, -2, 84, 32767)).addGap(5, 5, 5).addComponent(this.jtpConsultasSIMED, -2, 506, -2).addGap(5, 5, 5)));
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
                this.usarRuta = "";
                this.usarRuta = xfile.getAbsolutePath() + this.xmt.getBarra() + "";
                this.JTFRuta.setText(this.usarRuta + "Planilla_SISMED");
                this.JTFRuta.requestFocus(this.jtpConsultasSIMED.getSelectedIndex() == 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTExportarActionPerformed(ActionEvent evt) {
        if (this.JTCompras.getRowCount() != -1) {
            int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar?", "CONFIRMACIÓN", 0, 3);
            if (x == 0) {
                this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTCompras, this.JTFRuta.getText(), getTitle() + " Compras");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBGenerateTXTActionPerformed(ActionEvent evt) {
        mCrearArchivo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jtpConsultasSIMEDMouseClicked(MouseEvent evt) {
        mRutaDeExpor(this.usarRuta);
    }

    private void springStart() {
        this.xConsultaSIMEDTrimestralDAO = (ConsultaSIMEDTrimestralDAO) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("consultaSIMEDTrimestralDAOImpl");
    }

    public void mNuevo() {
        this.JDFechaI.setDate(this.xmt.getFechaActual());
        this.JDFechaF.setDate(this.xmt.getFechaActual());
        this.usarRuta = "";
        this.usarRuta = this.xmt.getDirectorioExportacion();
        mRutaDeExpor(this.usarRuta);
        mCrearModeloCompras();
    }

    public void mRutaDeExpor(String usarRuta) {
        this.JTFRuta.setText(usarRuta + "Planilla_SISMED");
    }

    public void mBuscar() {
        mBUscarCompras();
    }

    private void mCrearModeloCompras() {
        this.xModeloC = new DefaultTableModel((Object[][]) null, new String[]{"TR", "contador", "CHabilitacion", "Fecha", "RolActor", "TOperacion", "TTransaccion", "IUM_Inivel", "IUM_IInivel", "IUM_IIIInivel", "CodigoCUM", "Nconsecutivo", "UFacturaMed", "vlr_minimo", "vlr_maximo", "Vlr_total", "cantidad", "facturaPminimo", "facturaPmaxmo", "Nbre"}) { // from class: com.genoma.plus.controller.sgc.JIFFConsultarSISMEDTrimestral.5
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTCompras.setModel(this.xModeloC);
        this.JTCompras.getColumnModel().getColumn(0).setPreferredWidth(150);
        this.JTCompras.getColumnModel().getColumn(1).setPreferredWidth(150);
        this.JTCompras.getColumnModel().getColumn(2).setPreferredWidth(150);
        this.JTCompras.getColumnModel().getColumn(3).setPreferredWidth(150);
        this.JTCompras.getColumnModel().getColumn(4).setPreferredWidth(150);
        this.JTCompras.getColumnModel().getColumn(5).setPreferredWidth(150);
        this.JTCompras.getColumnModel().getColumn(6).setPreferredWidth(150);
        this.JTCompras.getColumnModel().getColumn(7).setPreferredWidth(150);
        this.JTCompras.getColumnModel().getColumn(8).setPreferredWidth(150);
        this.JTCompras.getColumnModel().getColumn(9).setPreferredWidth(150);
        this.JTCompras.getColumnModel().getColumn(10).setPreferredWidth(150);
        this.JTCompras.getColumnModel().getColumn(11).setPreferredWidth(150);
        this.JTCompras.getColumnModel().getColumn(12).setPreferredWidth(150);
        this.JTCompras.getColumnModel().getColumn(13).setPreferredWidth(150);
        this.JTCompras.getColumnModel().getColumn(14).setPreferredWidth(150);
        this.JTCompras.getColumnModel().getColumn(15).setPreferredWidth(150);
        this.JTCompras.getColumnModel().getColumn(16).setPreferredWidth(150);
        this.JTCompras.getColumnModel().getColumn(17).setPreferredWidth(150);
        this.JTCompras.getColumnModel().getColumn(18).setPreferredWidth(150);
        this.JTCompras.getColumnModel().getColumn(19).setPreferredWidth(300);
    }

    private void mBUscarCompras() {
        this.sumaTotalC = Double.valueOf(0.0d);
        this.cantidaMedicamentoC = "";
        mCrearModeloCompras();
        this.consultaSIMEDTrimestralDTO.setFechaInicial(this.xmt.formatoAMD.format(this.JDFechaI.getDate()));
        this.consultaSIMEDTrimestralDTO.setFechaFinal(this.xmt.formatoAMD.format(this.JDFechaF.getDate()));
        this.fechaInicio = this.xmt.formatoDMA1.format(this.JDFechaI.getDate());
        this.fechaFin = this.xmt.formatoDMA1.format(this.JDFechaF.getDate());
        System.out.println("");
        List<Object[]> list = this.xConsultaSIMEDTrimestralDAO.mBuscarComprasPorPeriodo(this.consultaSIMEDTrimestralDTO);
        for (int x = 0; x < list.size(); x++) {
            this.xModeloC.addRow(this.xDatoC);
            this.xModeloC.setValueAt(list.get(x)[0], x, 0);
            this.xModeloC.setValueAt(Integer.valueOf(x + 1), x, 1);
            if (Principal.informacionIps.getIdentificacion().equals("891982129") || Principal.informacionIps.getIdentificacion().equals("800080586")) {
                this.xModeloC.setValueAt(list.get(x)[2].toString().substring(0, list.get(x)[2].toString().length() - 2), x, 2);
            } else {
                this.xModeloC.setValueAt(list.get(x)[2], x, 2);
            }
            this.xModeloC.setValueAt(list.get(x)[3], x, 3);
            this.xModeloC.setValueAt(list.get(x)[4], x, 4);
            this.xModeloC.setValueAt(list.get(x)[5], x, 5);
            this.xModeloC.setValueAt(list.get(x)[6], x, 6);
            this.xModeloC.setValueAt(list.get(x)[7], x, 7);
            this.xModeloC.setValueAt(list.get(x)[8], x, 8);
            this.xModeloC.setValueAt(list.get(x)[9], x, 9);
            this.xModeloC.setValueAt(list.get(x)[10], x, 10);
            this.xModeloC.setValueAt(list.get(x)[11], x, 11);
            this.xModeloC.setValueAt(list.get(x)[12], x, 12);
            this.xModeloC.setValueAt(list.get(x)[13], x, 13);
            this.xModeloC.setValueAt(list.get(x)[14], x, 14);
            this.xModeloC.setValueAt(list.get(x)[15], x, 15);
            this.xModeloC.setValueAt(list.get(x)[16], x, 16);
            this.xModeloC.setValueAt(list.get(x)[17], x, 17);
            this.xModeloC.setValueAt(list.get(x)[18], x, 18);
            this.xModeloC.setValueAt(list.get(x)[19], x, 19);
        }
        System.out.println("suma total: " + this.sumaTotalC + "lista: " + list.size());
        System.out.println(this.df.format(this.sumaTotalC));
        this.cantidaMedicamentoC = list.size() + "";
    }

    private String head() {
        String head;
        List<Object[]> list = this.xConsultaSIMEDTrimestralDAO.mBuscarIps();
        if (Principal.informacionIps.getNombreIps().equals("CAMI SAS")) {
            head = "1|" + list.get(0)[0] + "|" + list.get(0)[1].toString() + "|" + this.xmt.formatoAMD1.format(this.JDFechaI.getDate()) + "|" + this.xmt.formatoAMD1.format(this.JDFechaF.getDate()) + "|" + this.cantidaMedicamentoC + "|" + this.cantidaMedicamentoC;
        } else {
            head = "1|" + list.get(0)[0] + "|" + list.get(0)[1].toString() + "|" + this.xmt.formatoAMD_Unida.format(this.JDFechaI.getDate()) + "|" + this.xmt.formatoAMD_Unida.format(this.JDFechaF.getDate()) + "|" + this.cantidaMedicamentoC + "|" + this.cantidaMedicamentoC;
        }
        return head;
    }

    private void mCrearArchivo() {
        try {
            new JTable();
            this.xTxt = new DefaultTableModel();
            Formatter obj = new Formatter();
            if (Principal.informacionIps.getNombreIps().equals("CAMI SAS")) {
                System.out.println(this.JDFechaF.getDate());
                this.sFichero = "MED100MPRE" + this.xmt.formatoAMD_Unida.format(this.JDFechaF.getDate()) + Principal.informacionIps.getIdTipoIdentificacion() + String.valueOf(obj.format("%012d", Long.valueOf(Principal.informacionIps.getIdentificacion()))) + ".txt";
            } else {
                this.sFichero = "MED100MPRE" + this.xmt.formatoAMD_Unida.format(this.xmt.getFechaActual()) + Principal.informacionIps.getIdTipoIdentificacion() + String.valueOf(obj.format("%012d", Long.valueOf(Principal.informacionIps.getIdentificacion()))) + ".txt";
            }
            JTable jtableTxt = this.JTCompras;
            this.xTxt = this.xModeloC;
            this.xmt.mEliminarArchivo(new File(this.sFichero));
            BufferedWriter bw = new BufferedWriter(new FileWriter(this.sFichero));
            bw.write(head());
            bw.newLine();
            for (int i = 0; i < jtableTxt.getRowCount(); i++) {
                String xValor = "";
                for (int y = 0; y < jtableTxt.getColumnCount() - 1; y++) {
                    if (y == jtableTxt.getColumnCount() - 2) {
                        xValor = xValor + this.xTxt.getValueAt(i, y).toString().trim();
                    } else {
                        xValor = xValor + this.xTxt.getValueAt(i, y).toString().trim() + "|";
                    }
                }
                bw.write(xValor);
                bw.newLine();
            }
            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(JIFFConsultarSISMEDTrimestral.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }
}
