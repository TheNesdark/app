package com.genoma.plus.controller.facturacion;

import Acceso.Principal;
import General.Anular;
import Historia.JDPatologia;
import Utilidades.Metodos;
import com.genoma.plus.dao.facturacion.EventoECatPacienteGastoDAO;
import com.genoma.plus.dao.impl.facturacion.EventoECastPacienteDAOImpl;
import com.genoma.plus.dto.facturacion.EventoECastPacienteGastoDTO;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.sql.Date;
import java.text.DecimalFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/facturacion/JPAEventoECastPacienteGasto.class */
public class JPAEventoECastPacienteGasto extends JPanel {
    private String idPersona;
    private String idIngreso;
    private EventoECatPacienteGastoDAO eventoECatPacienteGastoDAO;
    private File pdfSoporte;
    private DefaultTableModel modelo;
    private DefaultTableModel modelo1;
    private Object[] data;
    private int banderaAnulado;
    private Double valorTotal;
    private Double valorTotal1;
    private JButton JBBuscaTercero;
    public JDateChooser JDFechaGasto;
    private JLabel JLBDocumento;
    private JLabel JLBId;
    private JLabel JLBNumeroEvento;
    private JScrollPane JSP_Historico;
    private JScrollPane JSP_Historico1;
    public JTextField JTFEmpresa;
    private JTextField JTFNumeroFactura;
    private JTextField JTFRuta;
    private JTextField JTFTotalFactura;
    private JTable JTHistorico;
    private JTable JTHistorico1;
    private JTabbedPane JTP_Datos;
    private JButton jButton1;
    private JButton jButton2;
    private JButton jButton3;
    private JCheckBox jCheckBox1;
    private JFormattedTextField jFormattedTextField1;
    private JFormattedTextField jFormattedTextField2;
    private JFormattedTextField jFormattedTextField3;
    private JPanel jPanel2;
    private Metodos metodos = new Metodos();
    private List<Object[]> listaEventoGastoPacienteFX = null;
    private List<Object[]> listaEventoGastoPacienteFI = null;

    public JPAEventoECastPacienteGasto(String idPersona, String numeroDocumento, String idIngreso) {
        initComponents();
        this.idPersona = idPersona;
        this.idIngreso = idIngreso;
        System.out.println(" idPersona" + idPersona);
        this.JLBDocumento.setText(numeroDocumento);
        this.JLBNumeroEvento.setText("" + idIngreso);
        springStart();
        nuevo();
        this.JLBId.setVisible(false);
    }

    private void springStart() {
        this.eventoECatPacienteGastoDAO = (EventoECastPacienteDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("eventoCastPacienteDAO");
    }

    /* JADX WARN: Type inference failed for: r3v72, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v77, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jPanel2 = new JPanel();
        this.JLBNumeroEvento = new JLabel();
        this.JLBDocumento = new JLabel();
        this.JDFechaGasto = new JDateChooser();
        this.JTFNumeroFactura = new JTextField();
        this.JTFTotalFactura = new JTextField();
        this.jCheckBox1 = new JCheckBox();
        this.jButton1 = new JButton();
        this.JTFRuta = new JTextField();
        this.JTFEmpresa = new JTextField();
        this.jButton3 = new JButton();
        this.JLBId = new JLabel();
        this.JBBuscaTercero = new JButton();
        this.jButton2 = new JButton();
        this.jFormattedTextField1 = new JFormattedTextField();
        this.JTP_Datos = new JTabbedPane();
        this.JSP_Historico = new JScrollPane();
        this.JTHistorico = new JTable();
        this.JSP_Historico1 = new JScrollPane();
        this.JTHistorico1 = new JTable();
        this.jFormattedTextField2 = new JFormattedTextField();
        this.jFormattedTextField3 = new JFormattedTextField();
        setName("JPAEventoECastPacienteGasto");
        this.jPanel2.setBorder(BorderFactory.createTitledBorder((Border) null, "RELACIÓN DE GASTOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.jPanel2.setFont(new Font("Arial", 1, 12));
        this.JLBNumeroEvento.setFont(new Font("Arial", 1, 12));
        this.JLBNumeroEvento.setHorizontalAlignment(0);
        this.JLBNumeroEvento.setBorder(BorderFactory.createTitledBorder((Border) null, "Numero Evento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JLBDocumento.setFont(new Font("Arial", 1, 12));
        this.JLBDocumento.setHorizontalAlignment(0);
        this.JLBDocumento.setBorder(BorderFactory.createTitledBorder((Border) null, "Documento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaGasto.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaGasto.setDateFormatString("dd/MM/yyyy");
        this.JDFechaGasto.setFont(new Font("Arial", 1, 12));
        this.JDFechaGasto.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.facturacion.JPAEventoECastPacienteGasto.1
            public void keyPressed(KeyEvent evt) {
                JPAEventoECastPacienteGasto.this.JDFechaGastoKeyPressed(evt);
            }
        });
        this.JTFNumeroFactura.setFont(new Font("Arial", 1, 12));
        this.JTFNumeroFactura.setHorizontalAlignment(0);
        this.JTFNumeroFactura.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Factura", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFTotalFactura.setFont(new Font("Arial", 1, 12));
        this.JTFTotalFactura.setHorizontalAlignment(4);
        this.JTFTotalFactura.setBorder(BorderFactory.createTitledBorder((Border) null, "Total Factura", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jCheckBox1.setFont(new Font("Arial", 1, 12));
        this.jCheckBox1.setSelected(true);
        this.jCheckBox1.setText("Estado");
        this.jCheckBox1.setEnabled(false);
        this.jCheckBox1.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.facturacion.JPAEventoECastPacienteGasto.2
            public void actionPerformed(ActionEvent evt) {
                JPAEventoECastPacienteGasto.this.jCheckBox1ActionPerformed(evt);
            }
        });
        this.jButton1.setFont(new Font("Arial", 1, 12));
        this.jButton1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Autorizacion.png")));
        this.jButton1.setText("Adjuntar Factura");
        this.jButton1.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.facturacion.JPAEventoECastPacienteGasto.3
            public void actionPerformed(ActionEvent evt) {
                JPAEventoECastPacienteGasto.this.jButton1ActionPerformed(evt);
            }
        });
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ruta", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.facturacion.JPAEventoECastPacienteGasto.4
            public void actionPerformed(ActionEvent evt) {
                JPAEventoECastPacienteGasto.this.JTFRutaActionPerformed(evt);
            }
        });
        this.JTFEmpresa.setFont(new Font("Arial", 1, 12));
        this.JTFEmpresa.setToolTipText("");
        this.JTFEmpresa.setBorder(BorderFactory.createTitledBorder((Border) null, "Entidad  que Genera Gasto", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFEmpresa.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.facturacion.JPAEventoECastPacienteGasto.5
            public void mouseClicked(MouseEvent evt) {
                JPAEventoECastPacienteGasto.this.JTFEmpresaMouseClicked(evt);
            }
        });
        this.JTFEmpresa.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.facturacion.JPAEventoECastPacienteGasto.6
            public void actionPerformed(ActionEvent evt) {
                JPAEventoECastPacienteGasto.this.JTFEmpresaActionPerformed(evt);
            }
        });
        this.jButton3.setFont(new Font("Arial", 1, 12));
        this.jButton3.setIcon(new ImageIcon(getClass().getResource("/Imagenes/HojaLapiz29x27.png")));
        this.jButton3.setText("Ver Soporte Factura");
        this.jButton3.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.facturacion.JPAEventoECastPacienteGasto.7
            public void actionPerformed(ActionEvent evt) {
                JPAEventoECastPacienteGasto.this.jButton3ActionPerformed(evt);
            }
        });
        this.JBBuscaTercero.setIcon(new ImageIcon(getClass().getResource("/Imagenes/lupa.png")));
        this.JBBuscaTercero.setToolTipText("Buscar Tercero");
        this.JBBuscaTercero.setName("xRadicacion");
        this.JBBuscaTercero.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.facturacion.JPAEventoECastPacienteGasto.8
            public void actionPerformed(ActionEvent evt) {
                JPAEventoECastPacienteGasto.this.JBBuscaTerceroActionPerformed(evt);
            }
        });
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.JLBDocumento, -1, 107, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JLBNumeroEvento, -2, 129, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JDFechaGasto, -2, 130, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFNumeroFactura, -2, 125, -2)).addComponent(this.JTFRuta).addGroup(GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup().addComponent(this.JTFEmpresa).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBBuscaTercero, -2, 58, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.jButton1, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.jButton3, GroupLayout.Alignment.LEADING, -1, 207, 32767)).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.JTFTotalFactura, -2, 115, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLBId, -2, 39, -2).addComponent(this.jCheckBox1, -2, 93, -2))))));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGap(6, 6, 6).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLBId, -2, 17, -2).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFNumeroFactura, -2, 50, -2).addComponent(this.JTFTotalFactura, -2, 50, -2).addComponent(this.jCheckBox1))).addGap(14, 14, 14)).addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLBNumeroEvento, -2, 50, -2).addComponent(this.JDFechaGasto, -2, 50, -2).addComponent(this.JLBDocumento, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED))).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFEmpresa, -2, 50, -2).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JBBuscaTercero, -2, 50, -2).addComponent(this.jButton3, -2, 49, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jButton1, -2, 50, -2).addComponent(this.JTFRuta, -2, 50, -2)).addContainerGap(-1, 32767)));
        this.jButton2.setFont(new Font("Arial", 1, 12));
        this.jButton2.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.jButton2.setText("Guardar");
        this.jButton2.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.facturacion.JPAEventoECastPacienteGasto.9
            public void actionPerformed(ActionEvent evt) {
                JPAEventoECastPacienteGasto.this.jButton2ActionPerformed(evt);
            }
        });
        this.jFormattedTextField1.setBorder(BorderFactory.createTitledBorder((Border) null, "Total facturas externas", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.jFormattedTextField1.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.jFormattedTextField1.setHorizontalAlignment(4);
        this.jFormattedTextField1.setFont(new Font("Arial", 1, 12));
        this.JTP_Datos.setForeground(Color.red);
        this.JTP_Datos.setFont(new Font("Arial", 1, 14));
        this.JSP_Historico.setBorder((Border) null);
        this.JSP_Historico.setForeground(Color.red);
        this.JSP_Historico.setFont(new Font("Arial", 1, 14));
        this.JTHistorico.setFont(new Font("Arial", 1, 12));
        this.JTHistorico.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTHistorico.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.facturacion.JPAEventoECastPacienteGasto.10
            public void mouseClicked(MouseEvent evt) {
                JPAEventoECastPacienteGasto.this.JTHistoricoMouseClicked(evt);
            }
        });
        this.JSP_Historico.setViewportView(this.JTHistorico);
        this.JTP_Datos.addTab("FACTURAS EXTERNAS", this.JSP_Historico);
        this.JSP_Historico1.setBorder((Border) null);
        this.JSP_Historico1.setForeground(Color.red);
        this.JSP_Historico1.setFont(new Font("Arial", 1, 14));
        this.JTHistorico1.setFont(new Font("Arial", 1, 12));
        this.JTHistorico1.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTHistorico1.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.facturacion.JPAEventoECastPacienteGasto.11
            public void mouseClicked(MouseEvent evt) {
                JPAEventoECastPacienteGasto.this.JTHistorico1MouseClicked(evt);
            }
        });
        this.JSP_Historico1.setViewportView(this.JTHistorico1);
        this.JTP_Datos.addTab("FACTURAS INTERNAS", this.JSP_Historico1);
        this.jFormattedTextField2.setBorder(BorderFactory.createTitledBorder((Border) null, "Total facturas internas", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.jFormattedTextField2.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.jFormattedTextField2.setHorizontalAlignment(4);
        this.jFormattedTextField2.setFont(new Font("Arial", 1, 12));
        this.jFormattedTextField3.setBorder(BorderFactory.createTitledBorder((Border) null, "Total evento", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.jFormattedTextField3.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.jFormattedTextField3.setHorizontalAlignment(4);
        this.jFormattedTextField3.setFont(new Font("Arial", 1, 12));
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.jPanel2, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.jButton2, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.JTP_Datos, GroupLayout.Alignment.LEADING)).addGroup(layout.createSequentialGroup().addComponent(this.jFormattedTextField1, -2, 185, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jFormattedTextField2, -2, 185, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jFormattedTextField3, -2, 185, -2))).addGap(0, 20, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.jPanel2, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jButton2, -2, 50, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTP_Datos, -2, 211, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jFormattedTextField1, -2, 50, -2).addComponent(this.jFormattedTextField2, -2, 50, -2).addComponent(this.jFormattedTextField3, -2, 50, -2)).addContainerGap(-1, 32767)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaGastoKeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jButton1ActionPerformed(ActionEvent evt) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileNameExtensionFilter("PDF", new String[]{"pdf"}));
        if (fileChooser.showSaveDialog(this) == 0) {
            File file = fileChooser.getSelectedFile();
            this.pdfSoporte = file;
            if (this.pdfSoporte != null) {
                this.JTFRuta.setText(this.pdfSoporte.getAbsolutePath());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox1ActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFEmpresaActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jButton2ActionPerformed(ActionEvent evt) {
        guardar();
    }

    private void generarPdf(List<Object[]> Lista, JTable Tabla) {
        try {
            byte[] pdfbytes = (byte[]) Lista.get(Tabla.getSelectedRow())[6];
            InputStream pdf = new ByteArrayInputStream(pdfbytes);
            int peso = pdf.available();
            byte[] pdfb = new byte[peso];
            pdf.read(pdfb, 0, peso);
            OutputStream salida = new FileOutputStream("soporte.pdf");
            salida.write(pdfb);
            this.JTFRuta.setText(this.metodos.getDirectorioExportacion() + "soporte.pdf");
        } catch (IOException ex) {
            Logger.getLogger(JPAEventoECastPacienteGasto.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jButton3ActionPerformed(ActionEvent evt) {
        File path = new File(this.metodos.getDirectorioExportacion() + "soporte.pdf");
        try {
            Desktop.getDesktop().open(path);
        } catch (IOException ex) {
            Logger.getLogger(JPAEventoECastPacienteGasto.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTHistoricoMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2 && this.JTHistorico.getSelectedRow() != -1) {
            this.JTFNumeroFactura.setText(this.modelo.getValueAt(this.JTHistorico.getSelectedRow(), 2).toString());
            this.JTFTotalFactura.setText(this.modelo.getValueAt(this.JTHistorico.getSelectedRow(), 4).toString());
            this.JTFEmpresa.setText(this.modelo.getValueAt(this.JTHistorico.getSelectedRow(), 3).toString());
            this.jCheckBox1.setSelected(((Boolean) this.modelo.getValueAt(this.JTHistorico.getSelectedRow(), 5)).booleanValue());
            this.JDFechaGasto.setDate(Date.valueOf(this.modelo.getValueAt(this.JTHistorico.getSelectedRow(), 1).toString()));
            this.JLBId.setText(this.modelo.getValueAt(this.JTHistorico.getSelectedRow(), 0).toString());
            generarPdf(this.listaEventoGastoPacienteFX, this.JTHistorico);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTHistorico1MouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFEmpresaMouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBBuscaTerceroActionPerformed(ActionEvent evt) {
        JDPatologia x = new JDPatologia(null, true, this);
        x.setVisible(true);
    }

    public void nuevo() {
        this.JDFechaGasto.setDate(this.metodos.getFechaActual());
        this.JTFEmpresa.setText("");
        this.JTFNumeroFactura.setText("");
        this.JTFTotalFactura.setText("0");
        this.JTFRuta.setText("");
        this.jCheckBox1.setSelected(true);
        cargarDatosFacturaExterna();
        cargarDatosFacturaInterna();
    }

    public void limpiarPanel() {
        this.JDFechaGasto.setDate(this.metodos.getFechaActual());
        this.JTFEmpresa.setText("");
        this.JTFNumeroFactura.setText("");
        this.JTFTotalFactura.setText("0");
        this.JTFRuta.setText("");
        this.jCheckBox1.setSelected(true);
        this.JLBId.setText("");
        this.JLBNumeroEvento.setText("");
        this.JLBDocumento.setText("");
        cargarDatosFacturaExterna();
        cargarDatosFacturaInterna();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearModelo() {
        this.modelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Fecha", "Numero Factura", "Entidad", "Total factura", "Estado"}) { // from class: com.genoma.plus.controller.facturacion.JPAEventoECastPacienteGasto.12
            Class[] types = {Integer.class, String.class, String.class, String.class, Double.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTHistorico.setModel(this.modelo);
        this.JTHistorico.getColumnModel().getColumn(0).setPreferredWidth(100);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearModelo1() {
        this.modelo1 = new DefaultTableModel(new Object[0], new String[]{"Fecha Ingreso", "Fecha Factura", "Numero Factura", "Valor", "Estado", "Id Ingreso"}) { // from class: com.genoma.plus.controller.facturacion.JPAEventoECastPacienteGasto.13
            Class[] types = {String.class, String.class, String.class, Double.class, String.class, Long.class};
            boolean[] canEdit = {false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTHistorico1.setModel(this.modelo1);
        this.JTHistorico1.getColumnModel().getColumn(0).setPreferredWidth(200);
    }

    public void cargarDatosFacturaExterna() {
        crearModelo();
        this.listaEventoGastoPacienteFX = this.eventoECatPacienteGastoDAO.listaEventoECatPacienteGasto(Long.valueOf(this.JLBNumeroEvento.getText()), Long.valueOf(this.idPersona));
        this.valorTotal = new Double(0.0d);
        for (int j = 0; j < this.listaEventoGastoPacienteFX.size(); j++) {
            this.modelo.addRow(this.data);
            for (int x = 0; x < 6; x++) {
                this.modelo.setValueAt(this.listaEventoGastoPacienteFX.get(j)[x], j, x);
            }
            this.valorTotal = Double.valueOf(this.valorTotal.doubleValue() + Double.valueOf(this.listaEventoGastoPacienteFX.get(j)[4].toString()).doubleValue());
        }
        this.jFormattedTextField1.setValue(this.valorTotal);
    }

    public void cargarDatosFacturaInterna() {
        crearModelo1();
        this.listaEventoGastoPacienteFI = this.eventoECatPacienteGastoDAO.listaEventoECatPacienteGastoInternos(Long.valueOf(this.JLBNumeroEvento.getText()), Long.valueOf(this.idPersona));
        this.valorTotal1 = new Double(0.0d);
        for (int j = 0; j < this.listaEventoGastoPacienteFI.size(); j++) {
            this.modelo1.addRow(this.data);
            for (int x = 0; x < 6; x++) {
                this.modelo1.setValueAt(this.listaEventoGastoPacienteFI.get(j)[x], j, x);
            }
            this.valorTotal1 = Double.valueOf(this.valorTotal1.doubleValue() + Double.valueOf(this.listaEventoGastoPacienteFI.get(j)[3].toString()).doubleValue());
        }
        this.jFormattedTextField2.setValue(this.valorTotal1);
        this.jFormattedTextField3.setValue(Double.valueOf(this.valorTotal.doubleValue() + this.valorTotal1.doubleValue()));
    }

    public void anular() {
        if (!this.JLBId.getText().isEmpty()) {
            int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de anular?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                Anular frm = new Anular(null, true, "JPAEventoECastPacienteGasto", 5);
                frm.setVisible(true);
            }
        }
    }

    public void anular(String idMotivo, String motivo) {
        Object[] datosAnulacion = {Principal.usuarioSistemaDTO.getIdUsuarioSistema(), this.metodos.formatoAMD.format(this.metodos.getFechaActual()), idMotivo, motivo, this.JLBId.getText()};
        this.eventoECatPacienteGastoDAO.anulacion(datosAnulacion);
        nuevo();
    }

    public void guardar() {
        if (this.JLBId.getText().isEmpty()) {
            if (!this.JTFEmpresa.getText().isEmpty() && !this.JTFNumeroFactura.getText().isEmpty() && !this.JTFTotalFactura.getText().isEmpty() && !this.JTFRuta.getText().isEmpty()) {
                System.out.println("entro a guardar");
                int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro que quiere guardar la infomación", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (n == 0) {
                    EventoECastPacienteGastoDTO evento = new EventoECastPacienteGastoDTO();
                    evento.setIdPersona(Long.parseLong(this.idPersona));
                    evento.setIdEventoEcast(Integer.parseInt(this.JLBNumeroEvento.getText()));
                    evento.setNumeroFactura(this.JTFNumeroFactura.getText());
                    evento.setValorTotalFactura(Double.parseDouble(this.JTFTotalFactura.getText()));
                    evento.setEntidadGeneraGasto(this.JTFEmpresa.getText());
                    evento.setEstado(this.jCheckBox1.isSelected());
                    evento.setFechaGasto(this.metodos.formatoAMD.format(this.JDFechaGasto.getDate()));
                    if (null != this.pdfSoporte) {
                        try {
                            byte[] bArr = new byte[1024];
                            byte[] buffer = Files.readAllBytes(this.pdfSoporte.toPath());
                            evento.setSoporteFactura(buffer);
                        } catch (IOException e) {
                        }
                    }
                    evento.setIdUsario(Principal.usuarioSistemaDTO.getIdUsuarioSistema().longValue());
                    this.eventoECatPacienteGastoDAO.create(evento);
                    nuevo();
                    return;
                }
                return;
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Este documento ya esta guardado");
    }
}
