package com.genoma.plus.controller.rrhh;

import Acceso.Principal;
import RecursosHumanos.JDVisualizarNominaJSON;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import co.com.genomaempresarial.ankara.dto.NAnticipo;
import co.com.genomaempresarial.ankara.dto.NAuxilios;
import co.com.genomaempresarial.ankara.dto.NBasico;
import co.com.genomaempresarial.ankara.dto.NBonificacion;
import co.com.genomaempresarial.ankara.dto.NBonoEPCTV;
import co.com.genomaempresarial.ankara.dto.NCesantias;
import co.com.genomaempresarial.ankara.dto.NComision;
import co.com.genomaempresarial.ankara.dto.NCompensacion;
import co.com.genomaempresarial.ankara.dto.NDeducciones;
import co.com.genomaempresarial.ankara.dto.NDevengados;
import co.com.genomaempresarial.ankara.dto.NEmpleador;
import co.com.genomaempresarial.ankara.dto.NFechaPagos;
import co.com.genomaempresarial.ankara.dto.NFondoPension;
import co.com.genomaempresarial.ankara.dto.NFondoSP;
import co.com.genomaempresarial.ankara.dto.NHDE;
import co.com.genomaempresarial.ankara.dto.NHEDDF;
import co.com.genomaempresarial.ankara.dto.NHEN;
import co.com.genomaempresarial.ankara.dto.NHENDF;
import co.com.genomaempresarial.ankara.dto.NHRDDF;
import co.com.genomaempresarial.ankara.dto.NHRN;
import co.com.genomaempresarial.ankara.dto.NHRNDF;
import co.com.genomaempresarial.ankara.dto.NHuelgasLegales;
import co.com.genomaempresarial.ankara.dto.NIncapacidad;
import co.com.genomaempresarial.ankara.dto.NInformacionGeneral;
import co.com.genomaempresarial.ankara.dto.NLibranza;
import co.com.genomaempresarial.ankara.dto.NLicenciaMP;
import co.com.genomaempresarial.ankara.dto.NLicenciaNR;
import co.com.genomaempresarial.ankara.dto.NLicenciaR;
import co.com.genomaempresarial.ankara.dto.NLicencias;
import co.com.genomaempresarial.ankara.dto.NLugarGeneracionXML;
import co.com.genomaempresarial.ankara.dto.NNumeroSecuenciaXML;
import co.com.genomaempresarial.ankara.dto.NOtrasDeducciones;
import co.com.genomaempresarial.ankara.dto.NOtrosConcepto;
import co.com.genomaempresarial.ankara.dto.NPagosN;
import co.com.genomaempresarial.ankara.dto.NPagosTerceros;
import co.com.genomaempresarial.ankara.dto.NPeriodo;
import co.com.genomaempresarial.ankara.dto.NPrimas;
import co.com.genomaempresarial.ankara.dto.NProveedorXML;
import co.com.genomaempresarial.ankara.dto.NSalud;
import co.com.genomaempresarial.ankara.dto.NSancion;
import co.com.genomaempresarial.ankara.dto.NSindicato;
import co.com.genomaempresarial.ankara.dto.NTrabajador;
import co.com.genomaempresarial.ankara.dto.NTransporte;
import co.com.genomaempresarial.ankara.dto.NVacaciones;
import co.com.genomaempresarial.ankara.dto.NVacacionesCompensadas;
import co.com.genomaempresarial.ankara.dto.NVacacionesComunes;
import co.com.genomaempresarial.ankara.dto.NominaIndividual;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.genoma.plus.jpa.entity.ConceptoPorEmpleado;
import com.genoma.plus.jpa.entity.EmpleadoPagoProyection;
import com.genoma.plus.jpa.entity.EmpleadoPorNomina;
import com.genoma.plus.jpa.entity.EmpleadorProyection;
import com.genoma.plus.jpa.entity.INumeroSecuenciaXML;
import com.genoma.plus.jpa.entity.IProveedorXml;
import com.genoma.plus.jpa.entity.LugarDeGeneracion;
import com.genoma.plus.jpa.entity.NovedadesNomina;
import com.genoma.plus.jpa.service.NominaService;
import com.genoma.plus.jpa.service.impl.NominaServiceImpl;
import java.awt.Color;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
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
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;
import org.apache.commons.codec.digest.DigestUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/rrhh/JIFTransmisionNomina.class */
public class JIFTransmisionNomina extends JInternalFrame {
    private String[][] idNomina;
    private DefaultTableModel modelo;
    private Object[] data;
    private List<EmpleadoPorNomina> listaEmpleado;
    Document doc;
    private JButton JBConsultar;
    private ButtonGroup JBG_Filtro;
    private JButton JBTExportar;
    private JButton JBTest;
    private JButton JBTransmitir;
    private JComboBox<String> JCBNomina;
    private JPanel JP_Filtro;
    private JRadioButton JRB_PorEnviar;
    private JRadioButton JRB_Todo;
    private JRadioButton JRB_Trasmitida;
    private JTable JTDetalle;
    private JFormattedTextField JTFFValor;
    private JTextField JTFRuta;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JScrollPane jScrollPane1;
    private ConsultasMySQL consulta = new ConsultasMySQL();
    private Metodos metodos = new Metodos();
    private NominaService nominaService = (NominaService) Principal.contexto.getBean(NominaService.class);
    private int ambiente = 0;

    public JIFTransmisionNomina() {
        initComponents();
        nuevo();
    }

    /* JADX WARN: Type inference failed for: r3v41, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBG_Filtro = new ButtonGroup();
        this.jPanel1 = new JPanel();
        this.JCBNomina = new JComboBox<>();
        this.JBConsultar = new JButton();
        this.JBTransmitir = new JButton();
        this.JBTest = new JButton();
        this.jScrollPane1 = new JScrollPane();
        this.JTDetalle = new JTable();
        this.jPanel2 = new JPanel();
        this.JTFRuta = new JTextField();
        this.JBTExportar = new JButton();
        this.JTFFValor = new JFormattedTextField();
        this.JP_Filtro = new JPanel();
        this.JRB_Todo = new JRadioButton();
        this.JRB_PorEnviar = new JRadioButton();
        this.JRB_Trasmitida = new JRadioButton();
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("TRASMISIÓN NÓMINA ELECTRÓNICA");
        setToolTipText("");
        setFont(new Font("Arial", 1, 14));
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jiftramisionnominaelectronica");
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN", 2, 0, new Font("Arial", 1, 13), Color.red));
        this.JCBNomina.setFont(new Font("Arial", 1, 12));
        this.JCBNomina.setBorder(BorderFactory.createTitledBorder((Border) null, "Nomina", 0, 0, new Font("Arial", 1, 12)));
        this.JBConsultar.setFont(new Font("Arial", 1, 12));
        this.JBConsultar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Buscar.png")));
        this.JBConsultar.setText("Vista previa(JSON)");
        this.JBConsultar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.rrhh.JIFTransmisionNomina.1
            public void actionPerformed(ActionEvent evt) {
                JIFTransmisionNomina.this.JBConsultarActionPerformed(evt);
            }
        });
        this.JBTransmitir.setFont(new Font("Arial", 1, 12));
        this.JBTransmitir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTransmitir.setText("Transmitir");
        this.JBTransmitir.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.rrhh.JIFTransmisionNomina.2
            public void actionPerformed(ActionEvent evt) {
                JIFTransmisionNomina.this.JBTransmitirActionPerformed(evt);
            }
        });
        this.JBTest.setFont(new Font("Arial", 1, 12));
        this.JBTest.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Informes.png")));
        this.JBTest.setText("Test");
        this.JBTest.setToolTipText("");
        this.JBTest.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.rrhh.JIFTransmisionNomina.3
            public void actionPerformed(ActionEvent evt) {
                JIFTransmisionNomina.this.JBTestActionPerformed(evt);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.JCBNomina, -2, 311, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 45, 32767).addComponent(this.JBConsultar, -2, 200, -2).addGap(42, 42, 42).addComponent(this.JBTransmitir, -2, 200, -2).addGap(43, 43, 43).addComponent(this.JBTest, -2, 200, -2).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JCBNomina, GroupLayout.Alignment.TRAILING, -1, 55, 32767).addComponent(this.JBConsultar, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addComponent(this.JBTransmitir, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addComponent(this.JBTest, GroupLayout.Alignment.TRAILING, -1, -1, 32767)).addContainerGap(-1, 32767)));
        this.jScrollPane1.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.rrhh.JIFTransmisionNomina.4
            public void mouseClicked(MouseEvent evt) {
                JIFTransmisionNomina.this.JTDetalleMouseClicked(evt);
            }
        });
        this.jScrollPane1.setViewportView(this.JTDetalle);
        this.jPanel2.setBorder(BorderFactory.createTitledBorder((Border) null, "UTILIDAD", 0, 0, new Font("Arial", 1, 14), Color.red));
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.rrhh.JIFTransmisionNomina.5
            public void mouseClicked(MouseEvent evt) {
                JIFTransmisionNomina.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setForeground(Color.red);
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.rrhh.JIFTransmisionNomina.6
            public void actionPerformed(ActionEvent evt) {
                JIFTransmisionNomina.this.JBTExportarActionPerformed(evt);
            }
        });
        this.JTFFValor.setBorder(BorderFactory.createTitledBorder((Border) null, "Total a pagar", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JTFFValor.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFValor.setHorizontalAlignment(4);
        this.JTFFValor.setFont(new Font("Arial", 1, 12));
        this.JP_Filtro.setBorder(BorderFactory.createTitledBorder((Border) null, "Filtro", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JBG_Filtro.add(this.JRB_Todo);
        this.JRB_Todo.setFont(new Font("Arial", 1, 12));
        this.JRB_Todo.setSelected(true);
        this.JRB_Todo.setText("Todo");
        this.JRB_Todo.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.rrhh.JIFTransmisionNomina.7
            public void actionPerformed(ActionEvent evt) {
                JIFTransmisionNomina.this.JRB_TodoActionPerformed(evt);
            }
        });
        this.JRB_PorEnviar.setBackground(new Color(255, 255, 255));
        this.JBG_Filtro.add(this.JRB_PorEnviar);
        this.JRB_PorEnviar.setFont(new Font("Arial", 1, 12));
        this.JRB_PorEnviar.setText("Por Enviar");
        this.JRB_PorEnviar.setOpaque(true);
        this.JRB_PorEnviar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.rrhh.JIFTransmisionNomina.8
            public void actionPerformed(ActionEvent evt) {
                JIFTransmisionNomina.this.JRB_PorEnviarActionPerformed(evt);
            }
        });
        this.JRB_Trasmitida.setBackground(new Color(177, 251, 177));
        this.JBG_Filtro.add(this.JRB_Trasmitida);
        this.JRB_Trasmitida.setFont(new Font("Arial", 1, 12));
        this.JRB_Trasmitida.setText("Trasmitida");
        this.JRB_Trasmitida.setOpaque(true);
        this.JRB_Trasmitida.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.rrhh.JIFTransmisionNomina.9
            public void actionPerformed(ActionEvent evt) {
                JIFTransmisionNomina.this.JRB_TrasmitidaActionPerformed(evt);
            }
        });
        GroupLayout JP_FiltroLayout = new GroupLayout(this.JP_Filtro);
        this.JP_Filtro.setLayout(JP_FiltroLayout);
        JP_FiltroLayout.setHorizontalGroup(JP_FiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JP_FiltroLayout.createSequentialGroup().addContainerGap().addComponent(this.JRB_Todo).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRB_PorEnviar).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRB_Trasmitida).addContainerGap(14, 32767)));
        JP_FiltroLayout.setVerticalGroup(JP_FiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JP_FiltroLayout.createSequentialGroup().addGroup(JP_FiltroLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRB_Todo).addComponent(this.JRB_PorEnviar).addComponent(this.JRB_Trasmitida)).addContainerGap(-1, 32767)));
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(this.JTFRuta, -2, 354, -2).addGap(18, 18, 18).addComponent(this.JBTExportar, -2, 139, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JP_Filtro, -2, -1, -2).addGap(36, 36, 36).addComponent(this.JTFFValor, -2, 154, -2).addGap(16, 16, 16)));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup().addContainerGap(-1, 32767).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JTFRuta, -1, 50, 32767).addComponent(this.JBTExportar, -1, -1, 32767).addComponent(this.JTFFValor).addComponent(this.JP_Filtro, -2, 0, 32767)).addGap(78, 78, 78)));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jPanel1, -1, -1, 32767).addComponent(this.jPanel2, -1, -1, 32767)).addContainerGap()).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane1, -2, 1065, -2).addContainerGap(-1, 32767))));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 472, 32767).addComponent(this.jPanel2, -2, 88, -2).addContainerGap()).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(115, 115, 115).addComponent(this.jScrollPane1, -2, 438, -2).addContainerGap(110, 32767))));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBConsultarActionPerformed(ActionEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            armarJsonMetodo(this.JTDetalle.getSelectedRow(), false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTransmitirActionPerformed(ActionEvent evt) {
        this.ambiente = 1;
        for (int j = 0; j < this.JTDetalle.getRowCount(); j++) {
            if (((Boolean) this.modelo.getValueAt(j, 0)).booleanValue()) {
                armarJsonMetodo(j, true);
            }
        }
        buscar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTestActionPerformed(ActionEvent evt) {
        this.ambiente = 2;
        for (int j = 0; j < this.JTDetalle.getRowCount(); j++) {
            if (((Boolean) this.modelo.getValueAt(j, 0)).booleanValue()) {
                armarJsonMetodo(j, true);
            }
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
                this.JTFRuta.setText(xfile.getAbsolutePath() + this.metodos.getBarra());
                this.JTFRuta.requestFocus();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTExportarActionPerformed(ActionEvent evt) {
        if (this.JTDetalle.getRowCount() > -1) {
            int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                this.metodos.mExportar_Datos_Tabla_Titulo_Formato(this.JTDetalle, this.JTFRuta.getText(), getTitle());
                return;
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "No existe información para exportar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2 && this.JTDetalle.getSelectedColumn() == 13) {
            try {
                try {
                    this.doc = Jsoup.connect("https://catalogo-vpfe.dian.gov.co/User/SearchDocument").get();
                    Desktop.getDesktop().browse(new URI(this.doc.baseUri()));
                } catch (IOException ex) {
                    Logger.getLogger(JIFTransmisionNomina.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                }
            } catch (URISyntaxException ex2) {
                Logger.getLogger(JIFTransmisionNomina.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_TodoActionPerformed(ActionEvent evt) {
        buscar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_PorEnviarActionPerformed(ActionEvent evt) {
        busquedaFiltrada();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_TrasmitidaActionPerformed(ActionEvent evt) {
        busquedaFiltrada();
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.fasterxml.jackson.core.JsonProcessingException */
    private void armarJsonMetodo(int numeroFila, Boolean forma) {
        List<ConceptoPorEmpleado> listaConceptoPorEmpleado = this.nominaService.listaConceptoEmpleado(Integer.valueOf(Integer.parseInt(this.idNomina[this.JCBNomina.getSelectedIndex()][0])), (Integer) this.modelo.getValueAt(numeroFila, 3));
        List<NovedadesNomina> listaNovedades = this.nominaService.obtenerNovedadesNomina((Integer) this.modelo.getValueAt(numeroFila, 3), (Integer) this.modelo.getValueAt(numeroFila, 2));
        System.out.println("busco");
        try {
            armarJson(listaConceptoPorEmpleado, numeroFila, listaNovedades, 0, forma);
        } catch (JsonProcessingException e) {
            Logger.getLogger(JIFTransmisionNomina.class.getName()).log(Level.SEVERE, (String) null, e);
        }
    }

    private void nuevo() {
        this.listaEmpleado = new ArrayList();
        cargarCombo();
        mCrearModelo();
        this.JTFRuta.setText(this.metodos.getDirectorioExportacion() + "Planilla");
    }

    public void imprimir() {
        if (this.JTDetalle.getSelectedRow() != -1 && this.JTDetalle.getRowCount() > 0) {
            Principal.claserecursoshumanos.imprimirSoporteNomina(this.JTDetalle.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString(), this.JTDetalle.getValueAt(this.JTDetalle.getSelectedRow(), 4).toString(), this, 0, true);
        }
    }

    private void mCrearModelo() {
        this.modelo = new DefaultTableModel((Object[][]) null, new String[]{"Selecionar", "Fecha", "Id", "idpersona", "NoDocumento", "Empleado", "FechaIngreso", "Tiempo Laborado", "IDPeriodo", "Neto", "Cune", "keyDian", "NoInterno", "Ir..", "Correo Electronico", "Fecha Pago"}) { // from class: com.genoma.plus.controller.rrhh.JIFTransmisionNomina.10
            Class[] types = {Boolean.class, String.class, Integer.class, Integer.class, String.class, String.class, String.class, Integer.class, Integer.class, Double.class, String.class, String.class, Long.class, JButton.class, String.class, Date.class};
            boolean[] canEdit = {true, false, false, false, false, false, false, false, false, false, true, true, false, false, true, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setDefaultRenderer(JButton.class, new TableCellRenderer() { // from class: com.genoma.plus.controller.rrhh.JIFTransmisionNomina.11
            public Component getTableCellRendererComponent(JTable jtable, Object objeto, boolean estaSeleccionado, boolean tieneElFoco, int fila, int columna) {
                return (Component) objeto;
            }
        });
        JTable jTable = this.JTDetalle;
        JTable jTable2 = this.JTDetalle;
        jTable.setAutoResizeMode(0);
        this.JTDetalle.doLayout();
        this.JTDetalle.setModel(this.modelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(2).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(2).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(3).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(3).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(8).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(8).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(10).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(10).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(500);
        this.JTDetalle.getColumnModel().getColumn(12).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(13).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(14).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(15).setPreferredWidth(100);
    }

    private void cargarCombo() {
        this.idNomina = this.consulta.llenarComboyLista("SELECT rh.Id, IF(rh.Observacion='', CONCAT(rnp.Nbre, ' ', date_format(rh.FechaR, '%Y') ),rh.Observacion)  Observacion, STR_TO_DATE(concat(rnp.Del,'-',date_format(rh.FechaR, '%Y')), '%d-%m-%Y') fechaInicio , STR_TO_DATE(concat(rnp.Al ,'-',date_format(rh.FechaR, '%Y')), '%d-%m-%Y')   fechaFin \n-- , rnld.cune \nFROM `rh_nomina_liquidacion` rh\ninner join rh_nomina_periodo rnp on (rnp.Id=rh.Id_Periodo)\n-- inner join rh_nomina_liquidacion_detalle rnld on (rnld.Id_Liquidacion=rh.Id)\nWHERE `rh`.`Estado` = 1 \norder by rh.FechaR desc", this.idNomina, this.JCBNomina, 4);
    }

    public void buscar() {
        mCrearModelo();
        double valor = 0.0d;
        this.listaEmpleado = new ArrayList();
        this.listaEmpleado = this.nominaService.listaEmpleadosPorNomina(Integer.valueOf(Integer.parseInt(this.idNomina[this.JCBNomina.getSelectedIndex()][0])));
        for (int i = 0; i < this.listaEmpleado.size(); i++) {
            cargarDatoTabla(i);
            valor += this.listaEmpleado.get(i).getValorTotalNomina().doubleValue();
        }
        this.JTFFValor.setValue(Double.valueOf(valor));
    }

    public void busquedaFiltrada() {
        mCrearModelo();
        double valor = 0.0d;
        System.out.println("");
        if (!this.listaEmpleado.isEmpty()) {
            for (int i = 0; i < this.listaEmpleado.size(); i++) {
                if (this.JRB_PorEnviar.isSelected() && this.listaEmpleado.get(i).getkeyDian() == null) {
                    cargarDatoTabla(i);
                    valor += this.listaEmpleado.get(i).getValorTotalNomina().doubleValue();
                } else if (this.JRB_Trasmitida.isSelected() && this.listaEmpleado.get(i).getkeyDian() != null) {
                    cargarDatoTabla(i);
                    valor += this.listaEmpleado.get(i).getValorTotalNomina().doubleValue();
                }
            }
        }
        this.JTFFValor.setValue(Double.valueOf(valor));
    }

    private void cargarDatoTabla(int i) {
        this.modelo.addRow(this.data);
        int nfila = this.JTDetalle.getRowCount() - 1;
        this.modelo.setValueAt(false, nfila, 0);
        this.modelo.setValueAt(this.listaEmpleado.get(i).getFecha(), nfila, 1);
        this.modelo.setValueAt(this.listaEmpleado.get(i).getIdLiquidacion(), nfila, 2);
        this.modelo.setValueAt(this.listaEmpleado.get(i).getIdPersona(), nfila, 3);
        this.modelo.setValueAt(this.listaEmpleado.get(i).getNoDocumento(), nfila, 4);
        this.modelo.setValueAt(this.listaEmpleado.get(i).getEmpleado(), nfila, 5);
        this.modelo.setValueAt(this.listaEmpleado.get(i).getFechaIngreso(), nfila, 6);
        this.modelo.setValueAt(this.listaEmpleado.get(i).getTiempoLaborado(), nfila, 7);
        this.modelo.setValueAt(this.listaEmpleado.get(i).getIdPeriodo(), nfila, 8);
        this.modelo.setValueAt(this.listaEmpleado.get(i).getValorTotalNomina(), nfila, 9);
        this.modelo.setValueAt(this.listaEmpleado.get(i).getCorreoElectronico(), nfila, 14);
        this.modelo.setValueAt(this.listaEmpleado.get(i).getFechaPago(), nfila, 15);
        this.modelo.setValueAt(this.listaEmpleado.get(i).getCune() == null ? "" : this.listaEmpleado.get(i).getCune(), nfila, 10);
        this.modelo.setValueAt(this.listaEmpleado.get(i).getkeyDian() == null ? "" : this.listaEmpleado.get(i).getkeyDian(), nfila, 11);
        if (this.listaEmpleado.get(i).getkeyDian() != null) {
            this.modelo.setValueAt(new JButton("Abrir sitio web dian"), nfila, 13);
        } else {
            this.modelo.setValueAt(new JButton(""), nfila, 13);
        }
        this.modelo.setValueAt(this.listaEmpleado.get(i).getConsecutivo(), nfila, 12);
        this.JTDetalle.setDefaultRenderer(Object.class, new MiRender());
    }

    private void springStart() {
        this.nominaService = (NominaServiceImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("nominaService");
    }

    private void armarJson(List<ConceptoPorEmpleado> listaConcepto, int pos, List<NovedadesNomina> listaNovedades, Integer numero, Boolean forma) throws JsonProcessingException {
        List<String> listaNotas = new ArrayList<>();
        NFechaPagos fechaPagos = new NFechaPagos(this.metodos.formatoAMD1.format(this.modelo.getValueAt(pos, 15)));
        List<NFechaPagos> listaFechaPagos = new ArrayList<>();
        listaFechaPagos.add(fechaPagos);
        listaNotas.add("Nomina " + this.JCBNomina.getSelectedItem().toString());
        NominaIndividual nomina = new NominaIndividual();
        nomina.setPeriodo(getPerido(pos));
        nomina.setNumeroSecuenciaXML(getNumeroSecuenciaXML(Integer.valueOf(Integer.parseInt(this.modelo.getValueAt(pos, 3).toString())), Integer.valueOf(Integer.parseInt(this.idNomina[this.JCBNomina.getSelectedIndex()][0])), numero));
        nomina.setLugarGeneracionXML(getLugarGeneracion());
        nomina.setProveedorXML(getProvedorXML(nomina.getNumeroSecuenciaXML().getNumero()));
        nomina.setCodigoQR("Codigo");
        nomina.setInformacionGeneral(getInformacionGeneral(pos));
        nomina.setNotas(listaNotas);
        nomina.setEmpleador(getEmpleador());
        EmpleadoPagoProyection empleadoPago = this.nominaService.getEmpleadoPagoNomina(Integer.valueOf(Integer.parseInt(this.modelo.getValueAt(pos, 3).toString())));
        System.out.println("codigo " + this.modelo.getValueAt(pos, 3).toString());
        if (empleadoPago != null) {
            nomina.setTrabajador(getTrabajador(empleadoPago));
            nomina.setPago(getPago(empleadoPago));
            nomina.setFechasPagos(listaFechaPagos);
            nomina.setDevengados(getDevengados(listaConcepto, listaNovedades));
            nomina.setDeducciones(getDeducciones(listaConcepto));
            nomina.setRedondeo(Double.valueOf(0.0d));
            nomina.setDevengadoTotal(getDevengadosTotal(listaConcepto, listaNovedades));
            nomina.setDeduccionesTotal(getDeducionesTotal(listaConcepto));
            nomina.setComprobanteTotal(Double.valueOf(nomina.getDevengadoTotal().doubleValue() - nomina.getDeduccionesTotal().doubleValue()));
            ObjectMapper mapper = new ObjectMapper();
            System.out.println("entra a imprimir objetMapper");
            String datosNomina = mapper.writeValueAsString(nomina);
            System.out.println(datosNomina);
            if (forma.booleanValue()) {
                String respuesta = this.nominaService.enviarNomina(nomina, this.idNomina[this.JCBNomina.getSelectedIndex()][0], this.modelo.getValueAt(pos, 3).toString());
                if (!respuesta.contains("ha sido autorizada")) {
                    this.metodos.mostrarMensaje(respuesta);
                } else {
                    enviarComprobanteCorreo(pos);
                }
                System.out.println(respuesta);
                return;
            }
            JDVisualizarNominaJSON nominaJSON = new JDVisualizarNominaJSON(null, true, datosNomina);
            nominaJSON.setLocationRelativeTo(this);
            nominaJSON.setVisible(true);
            return;
        }
        this.metodos.mostrarMensaje("Falta información del empleado");
    }

    private void enviarComprobanteCorreo(int pos) {
    }

    private NPeriodo getPerido(int pos) {
        NPeriodo periodo = new NPeriodo();
        periodo.setFechaIngreso(this.modelo.getValueAt(pos, 6).toString());
        periodo.setFechaGen(this.modelo.getValueAt(pos, 1).toString());
        periodo.setTiempoLaborado(Integer.valueOf(Integer.parseInt(this.modelo.getValueAt(pos, 7).toString())));
        periodo.setFechaLiquidacionInicio(this.idNomina[this.JCBNomina.getSelectedIndex()][1]);
        periodo.setFechaLiquidacionFin(this.idNomina[this.JCBNomina.getSelectedIndex()][2]);
        return periodo;
    }

    private NLugarGeneracionXML getLugarGeneracion() {
        LugarDeGeneracion lugarDeGeneracion = this.nominaService.lugarDeGeneracion();
        NLugarGeneracionXML lugarGeneracionXML = NLugarGeneracionXML.builder().pais(lugarDeGeneracion.getPais()).departamentoEstado(lugarDeGeneracion.getDepartamento()).municipioCiudad(lugarDeGeneracion.getMunicipio()).idioma(lugarDeGeneracion.getIdioma()).build();
        return lugarGeneracionXML;
    }

    private NProveedorXML getProvedorXML(String numeroDocumento) {
        IProveedorXml nProveedorXML = this.nominaService.ObtenerProvedorXML();
        NProveedorXML proveedor = NProveedorXML.builder().razonSocial(nProveedorXML.getRazonSocial()).primerApellido(nProveedorXML.getRazonSocial()).segundoApellido(nProveedorXML.getSegundoApellido()).primerNombre(nProveedorXML.getPrimerNombre()).otrosNombres(nProveedorXML.getRazonSocial()).nit(nProveedorXML.getNit()).dv(nProveedorXML.getDv()).softwareID(nProveedorXML.getSoftwareId()).softwareSC(obtenerHuellaSoftware(nProveedorXML.getSoftwareId(), nProveedorXML.getPinSoftware(), numeroDocumento)).build();
        return proveedor;
    }

    private String obtenerHuellaSoftware(String softwareId, String ping, String numeroDocumento) {
        return DigestUtils.sha384Hex(softwareId.concat(ping).concat(numeroDocumento));
    }

    private NNumeroSecuenciaXML getNumeroSecuenciaXML(Integer idPersona, Integer liquidacion, Integer numero) {
        INumeroSecuenciaXML iNumeroSecuencia = this.nominaService.numeroSecuenciaXML(idPersona, liquidacion);
        NNumeroSecuenciaXML numeroSecuenciaXML = NNumeroSecuenciaXML.builder().codigoTrabajador(Integer.valueOf(Integer.parseInt(iNumeroSecuencia.getNoDocumento()))).consecutivo(iNumeroSecuencia.getConsecutivo()).prefijo(iNumeroSecuencia.getPrefijo()).numero(iNumeroSecuencia.getNumero().trim()).build();
        if (numero.intValue() > 0) {
            String consecutivo = numeroSecuenciaXML.getConsecutivo().substring(0, numeroSecuenciaXML.getConsecutivo().length() - numero.toString().length()).concat(numero.toString());
            System.out.println("consecutivo" + consecutivo);
            numeroSecuenciaXML.setConsecutivo(consecutivo);
            numeroSecuenciaXML.setNumero(numeroSecuenciaXML.getPrefijo().concat(consecutivo));
        }
        return numeroSecuenciaXML;
    }

    private String calcularConsecutivo(String consecutivo, String prefijo) {
        return "";
    }

    private NInformacionGeneral getInformacionGeneral(int pos) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
        Date fecha = new Date();
        try {
            fecha = sdf.parse(sdf.format(fecha));
            System.out.println("fecha" + fecha.toString());
        } catch (Exception e) {
        }
        NInformacionGeneral informacionGeneral = NInformacionGeneral.builder().version("V1.0: Documento Soporte de Pago de Nómina Electrónica").ambiente(Integer.valueOf(this.ambiente)).tipoXML(102).cune("").encripCune("CUNE-SHA384").fechaGen(this.modelo.getValueAt(pos, 1).toString()).horaGen(fecha).periodoNomina(5).tipoMoneda("COP").tRM(Integer.valueOf(getTRM(this.modelo.getValueAt(pos, 1).toString()))).build();
        return informacionGeneral;
    }

    private int getTRM(String fecha) {
        return 3096;
    }

    private NEmpleador getEmpleador() {
        EmpleadorProyection empleadorProyection = this.nominaService.getEmpleador();
        NEmpleador empleador = NEmpleador.builder().pais(empleadorProyection.getPais()).departamentoEstado(empleadorProyection.getDepartamentoEstado()).direccion(empleadorProyection.getDireccion()).municipioCiudad(empleadorProyection.getMunicipioCiudad()).dv(empleadorProyection.getDV()).razonSocial(empleadorProyection.getRazonSocial()).nit(empleadorProyection.getNit()).build();
        return empleador;
    }

    private NTrabajador getTrabajador(EmpleadoPagoProyection empleadoPago) {
        NTrabajador trabajador = NTrabajador.builder().tipoTrabajador(empleadoPago.getIdTipoTrabajador()).subTipoTrabajador(empleadoPago.getSubTipoTrabajador()).altoRiesgoPension(empleadoPago.getAltoRiesgoPension()).tipoDocumento(empleadoPago.getIdTipoDocumento()).numeroDocumento(empleadoPago.getNumeroDocumento()).primerApellido(empleadoPago.getPrimerApellido()).segundoApellido(empleadoPago.getSegundoApellido()).primerNombre(empleadoPago.getPrimerNombre()).otrosNombres(empleadoPago.getOtrosNombres()).lugarTrabajoPais(empleadoPago.getLugarTrabajoPais()).lugarTrabajoDepartamentoEstado(empleadoPago.getLugarTrabajoDepartamentoEstado()).lugarTrabajoMunicipioCiudad(empleadoPago.getLugarTrabajoMunicipioCiudad()).lugarTrabajoDireccion(empleadoPago.getLugarTrabajoDireccion()).salarioIntegral(empleadoPago.getSalarioIntegral()).Sueldo(Double.valueOf(empleadoPago.getSueldo().doubleValue())).tipoContrato(empleadoPago.getTipoContrato()).codigoTrabajador(empleadoPago.getCodigoTrabajador()).build();
        return trabajador;
    }

    private NPagosN getPago(EmpleadoPagoProyection empleadoPago) {
        NPagosN pago = NPagosN.builder().banco(empleadoPago.getBanco()).forma(empleadoPago.getFormaPago()).metodo(empleadoPago.getMetodoPago()).numeroCuenta(empleadoPago.getNumeroCuenta()).tipoCuenta(empleadoPago.getTipoCuenta()).build();
        return pago;
    }

    private NDevengados getDevengados(List<ConceptoPorEmpleado> listaConcepto, List<NovedadesNomina> listaNovedades) {
        NDevengados devengados = new NDevengados();
        List<NHDE> listaHorasExtras = new ArrayList<>();
        List<NHEN> listaHoraExtrasNocturas = new ArrayList<>();
        List<NHRN> listaHorasRecargosNocturnos = new ArrayList<>();
        List<NHRNDF> listaHorasRecargosDomingoFestivo = new ArrayList<>();
        List<NHEDDF> listaHorasExtrasDominicalesFestivas = new ArrayList<>();
        List<NHENDF> listaHorasExtrasNocturnasDominicalesFestivas = new ArrayList<>();
        List<NHRDDF> listaHorasRecargoDiurnoDominicalesFestivos = new ArrayList<>();
        List<NIncapacidad> listaIncapacidades = new ArrayList<>();
        List<NBonificacion> listaBonificaciones = new ArrayList<>();
        List<NAuxilios> listaAuxilios = new ArrayList<>();
        List<NHuelgasLegales> listaHuelgasLegales = new ArrayList<>();
        List<NOtrosConcepto> listaOtrosConceptos = new ArrayList<>();
        List<NCompensacion> listaCompensacion = new ArrayList<>();
        List<NBonoEPCTV> listaBonoEPCTV = new ArrayList<>();
        List<NComision> listaComisiones = new ArrayList<>();
        List<NPagosTerceros> listaPagosTerceros = new ArrayList<>();
        List<NAnticipo> listaAnticipos = new ArrayList<>();
        DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        NLicencias licencia = new NLicencias();
        NVacaciones vacaciones = new NVacaciones();
        NAuxilios auxilios = new NAuxilios();
        NCesantias cesantias = new NCesantias();
        listaNovedades.forEach(l -> {
            System.out.println("fechaInicio " + l.getHoraFin());
            System.out.println("fechaInicio " + l.getHoraInicio());
            switch (l.getClasificacionNominaElectronica().intValue()) {
                case 3:
                    listaHorasExtras.add(NHDE.builder().cantidad(l.getCantidad()).horaFin(l.getHoraFin()).horaInicio(l.getHoraInicio()).pago(l.getValor()).porcentaje(l.getPorcentajeDian()).build());
                    break;
                case 4:
                    listaHoraExtrasNocturas.add(NHEN.builder().cantidad(l.getCantidad()).horaFin(l.getHoraFin()).horaInicio(l.getHoraInicio()).pago(l.getValor()).porcentaje(l.getPorcentajeDian()).build());
                    break;
                case 5:
                    listaHorasRecargosNocturnos.add(NHRN.builder().cantidad(l.getCantidad()).horaFin(l.getHoraFin()).horaInicio(l.getHoraInicio()).pago(l.getValor()).porcentaje(l.getPorcentajeDian()).build());
                    break;
                case 6:
                    listaHorasExtrasDominicalesFestivas.add(NHEDDF.builder().cantidad(l.getCantidad()).horaFin(l.getHoraFin()).horaInicio(l.getHoraInicio()).pago(l.getValor()).porcentaje(l.getPorcentajeDian()).build());
                    break;
                case 7:
                    listaHorasRecargosDomingoFestivo.add(NHRNDF.builder().cantidad(l.getCantidad()).horaFin(l.getHoraFin()).horaInicio(l.getHoraInicio()).pago(l.getValor()).porcentaje(l.getPorcentajeDian()).build());
                    devengados.setHRNDFS(listaHorasRecargosDomingoFestivo);
                    break;
                case 8:
                    listaHorasRecargoDiurnoDominicalesFestivos.add(NHRDDF.builder().cantidad(l.getCantidad()).horaFin(l.getHoraFin()).horaInicio(l.getHoraInicio()).pago(l.getValor()).porcentaje(l.getPorcentajeDian()).build());
                    break;
                case 9:
                    NVacacionesComunes vacionesComunes = NVacacionesComunes.builder().fechaInicio(l.getFechaInicio()).fechaFin(l.getFechaFin()).cantidad(Integer.valueOf(l.getCantidad().intValue())).pago(l.getValor()).build();
                    vacaciones.setVacacionesComunes(vacionesComunes);
                    break;
                case 12:
                    NIncapacidad incapacidad = NIncapacidad.builder().fechaInicio(l.getFechaInicio()).fechaFin(l.getFechaFin()).cantidad(Integer.valueOf(l.getCantidad().intValue())).tipo(1).pago(l.getValor()).build();
                    listaIncapacidades.add(incapacidad);
                    break;
                case 13:
                case 54:
                case 55:
                    System.out.println("entro aqui");
                    if (l.getClasificacionNominaElectronica().intValue() == 14) {
                        licencia.setLicenciaMP(NLicenciaMP.builder().fechaFin(l.getFechaFin()).fechaInicio(l.getFechaInicio()).cantidad(Integer.valueOf(l.getCantidad().intValue())).pago(l.getValor()).build());
                    } else if (l.getClasificacionNominaElectronica().intValue() == 54) {
                        licencia.setLicenciaR(NLicenciaR.builder().fechaInicio(l.getFechaInicio()).fechaFin(l.getFechaFin()).pago(l.getValor()).cantidad(Integer.valueOf(l.getCantidad().intValue())).build());
                    } else {
                        licencia.setLicenciaNR(NLicenciaNR.builder().fechaFin(l.getFechaFin()).fechaInicio(l.getFechaInicio()).cantidad(Integer.valueOf(l.getCantidad().intValue())).build());
                    }
                    break;
                case 16:
                    NHuelgasLegales huelgasLegales = NHuelgasLegales.builder().fechaFin(l.getFechaFin()).fechaInicio(l.getFechaInicio()).cantidad(Integer.valueOf(l.getCantidad().intValue())).build();
                    listaHuelgasLegales.add(huelgasLegales);
                    break;
                case 53:
                    listaHorasExtrasNocturnasDominicalesFestivas.add(NHENDF.builder().cantidad(l.getCantidad()).horaFin(l.getHoraFin()).horaInicio(l.getHoraInicio()).pago(l.getValor()).porcentaje(l.getPorcentajeDian()).build());
                    break;
                case 57:
                    NVacacionesCompensadas vacacionesCompensadas = NVacacionesCompensadas.builder().cantidad(Integer.valueOf(l.getCantidad().intValue())).pago(l.getValor()).build();
                    vacaciones.setVacacionesCompensadas(vacacionesCompensadas);
                    break;
            }
        });
        devengados.setHEDDFS(listaHorasExtrasDominicalesFestivas);
        devengados.setHEDS(listaHorasExtras);
        devengados.setHENS(listaHoraExtrasNocturas);
        devengados.setHENDFs(listaHorasExtrasNocturnasDominicalesFestivas);
        devengados.setHRDDFs(listaHorasRecargoDiurnoDominicalesFestivos);
        devengados.setHRNDFS(listaHorasRecargosDomingoFestivo);
        devengados.setHRNS(listaHorasRecargosNocturnos);
        devengados.setHuelgasLegales(listaHuelgasLegales);
        devengados.setIncapacidades(listaIncapacidades);
        devengados.setHEDDFS(listaHorasExtrasDominicalesFestivas);
        devengados.setPagoTercero(listaPagosTerceros);
        devengados.setDotacion(Double.valueOf(0.0d));
        devengados.setApoyoSost(Double.valueOf(0.0d));
        devengados.setTeleTrabajo(Double.valueOf(0.0d));
        devengados.setBonifRetiro(Double.valueOf(0.0d));
        devengados.setIndemnizacion(Double.valueOf(0.0d));
        devengados.setReintegro(Double.valueOf(0.0d));
        for (int j = 0; j < listaConcepto.size(); j++) {
            switch (listaConcepto.get(j).getIdClasificacionNominaE().intValue()) {
                case 1:
                    NBasico basico = NBasico.builder().diasTrabajado(listaConcepto.get(j).getCantidad()).sueldoTrabajo(listaConcepto.get(j).getDevengado()).build();
                    devengados.setBasico(basico);
                    break;
                case 2:
                    NTransporte transporte = NTransporte.builder().auxilioTransporte(listaConcepto.get(j).getDevengado()).viaticoManutAlojNS((Double) null).viaticoManutAlojS((Double) null).build();
                    devengados.setTransporte(transporte);
                    break;
                case 10:
                    NPrimas primas = NPrimas.builder().cantidad(listaConcepto.get(j).getCantidad()).pago(listaConcepto.get(j).getDevengado()).pagoNS(Double.valueOf(0.0d)).build();
                    devengados.setPrimas(primas);
                    break;
                case 11:
                    cesantias = NCesantias.builder().pago(Integer.valueOf(listaConcepto.get(j).getDevengado().intValue())).porcentaje(Double.valueOf(1.0d)).build();
                    devengados.setCesantias(cesantias);
                    break;
                case 14:
                case 50:
                    NBonificacion bonificacion = new NBonificacion();
                    if (listaConcepto.get(j).getIdClasificacionNominaE().intValue() == 14) {
                        bonificacion.setBonificacionS(listaConcepto.get(j).getDevengado());
                        bonificacion.setBonificacionNS((Double) null);
                        listaBonificaciones.add(bonificacion);
                    } else {
                        bonificacion.setBonificacionNS(listaConcepto.get(j).getDevengado());
                        bonificacion.setBonificacionS((Double) null);
                        listaBonificaciones.add(bonificacion);
                    }
                    devengados.setBonificaciones(listaBonificaciones);
                    break;
                case 15:
                case 51:
                    if (listaConcepto.get(j).getIdClasificacionNominaE().intValue() == 15) {
                        auxilios.setAuxilioS(listaConcepto.get(j).getDevengado());
                        listaAuxilios.add(auxilios);
                    } else {
                        auxilios.setAuxilioNS(listaConcepto.get(j).getDevengado());
                        listaAuxilios.add(auxilios);
                    }
                    break;
                case 17:
                    NOtrosConcepto otrosConcepto = NOtrosConcepto.builder().DescripcionConcepto(listaConcepto.get(j).getConcepto()).ConceptoS(listaConcepto.get(j).getDevengado()).build();
                    listaOtrosConceptos.add(otrosConcepto);
                    devengados.setOtrosConceptos(listaOtrosConceptos);
                    break;
                case 18:
                case 52:
                    NCompensacion compensacion = new NCompensacion();
                    if (listaConcepto.get(j).getIdClasificacionNominaE().intValue() == 18) {
                        compensacion.setCompensacionO(listaConcepto.get(j).getDevengado());
                    } else {
                        compensacion.setCompensacionE(listaConcepto.get(j).getDevengado());
                    }
                    listaCompensacion.add(compensacion);
                    devengados.setCompensaciones(listaCompensacion);
                    break;
                case 19:
                    devengados.setBonoEPCTVS(listaBonoEPCTV);
                    break;
                case 20:
                    NComision comision = NComision.builder().comision(listaConcepto.get(j).getDevengado()).build();
                    listaComisiones.add(comision);
                    devengados.setComision(listaComisiones);
                    break;
                case 21:
                    NPagosTerceros pagos = NPagosTerceros.builder().pagoTercero(listaConcepto.get(j).getDevengado()).build();
                    listaPagosTerceros.add(pagos);
                    devengados.setPagoTercero(listaPagosTerceros);
                    break;
                case 22:
                    NAnticipo anticipo = NAnticipo.builder().anticipo(listaConcepto.get(j).getDevengado()).build();
                    listaAnticipos.add(anticipo);
                    devengados.setAnticipos(listaAnticipos);
                    break;
                case 23:
                    devengados.setDotacion(listaConcepto.get(j).getDevengado());
                    break;
                case 24:
                    devengados.setApoyoSost(listaConcepto.get(j).getDevengado());
                    break;
                case 25:
                    devengados.setTeleTrabajo(listaConcepto.get(j).getDevengado());
                    break;
                case 26:
                    devengados.setBonifRetiro(listaConcepto.get(j).getDevengado());
                    break;
                case 27:
                    devengados.setIndemnizacion(listaConcepto.get(j).getDevengado());
                    break;
                case 28:
                    devengados.setReintegro(listaConcepto.get(j).getDevengado());
                    break;
                case 45:
                    devengados.getCesantias().setPagoIntereses(listaConcepto.get(j).getDevengado());
                    break;
                case 47:
                    devengados.getTransporte().setViaticoManutAlojS(listaConcepto.get(j).getDevengado());
                    break;
                case 48:
                    devengados.getTransporte().setViaticoManutAlojNS(listaConcepto.get(j).getDevengado());
                    break;
                case 49:
                    devengados.getPrimas().setPagoNS(listaConcepto.get(j).getDevengado());
                    break;
                case 60:
                    cesantias.setPagoIntereses(listaConcepto.get(j).getDevengado());
                    break;
            }
        }
        devengados.setVacaciones(vacaciones);
        devengados.setLicencias(licencia);
        devengados.setBonificaciones(listaBonificaciones);
        devengados.setAuxilios(listaAuxilios);
        devengados.setHuelgasLegales(listaHuelgasLegales);
        devengados.setOtrosConceptos(listaOtrosConceptos);
        devengados.setCompensaciones(listaCompensacion);
        devengados.setBonoEPCTVS(listaBonoEPCTV);
        devengados.setComision(listaComisiones);
        devengados.setAnticipos(listaAnticipos);
        if (devengados.getBasico() == null) {
            devengados.setBasico(NBasico.builder().diasTrabajado(0).sueldoTrabajo(Double.valueOf(0.0d)).build());
        }
        if (devengados.getPrimas() == null) {
            devengados.setPrimas(NPrimas.builder().cantidad(0).pago(Double.valueOf(0.0d)).pagoNS(Double.valueOf(0.0d)).build());
        }
        if (devengados.getCesantias() == null) {
            devengados.setCesantias(NCesantias.builder().pago(0).pagoIntereses(Double.valueOf(0.0d)).porcentaje(Double.valueOf(0.0d)).build());
        }
        return devengados;
    }

    private NDeducciones getDeducciones(List<ConceptoPorEmpleado> listaConcepto) {
        List<NLibranza> listaLibranza = new ArrayList<>();
        List<NSindicato> listaSindicatos = new ArrayList<>();
        List<NSancion> listaSanciones = new ArrayList<>();
        new ArrayList();
        List<NPagosTerceros> listaPagosTerceros = new ArrayList<>();
        List<NAnticipo> listaAnticipo = new ArrayList<>();
        List<NOtrasDeducciones> listaDeduccioneses = new ArrayList<>();
        NDeducciones deducciones = new NDeducciones();
        NFondoSP fondoSP = new NFondoSP();
        NFondoPension fondo = new NFondoPension();
        deducciones.setPensionVoluntaria(Double.valueOf(0.0d));
        deducciones.setPlanComplementarios(Double.valueOf(0.0d));
        deducciones.setRetencionFuente(Double.valueOf(0.0d));
        deducciones.setCooperativa(Double.valueOf(0.0d));
        deducciones.setEmbargoFiscal(Double.valueOf(0.0d));
        deducciones.setEducacion(Double.valueOf(0.0d));
        deducciones.setReintegro(Double.valueOf(0.0d));
        deducciones.setDeuda(Double.valueOf(0.0d));
        deducciones.setAFC(Double.valueOf(0.0d));
        for (int j = 0; j < listaConcepto.size(); j++) {
            System.out.println("concepto " + listaConcepto.get(j).getIdClasificacionNominaE());
            switch (listaConcepto.get(j).getIdClasificacionNominaE().intValue()) {
                case 29:
                    NSalud salud = NSalud.builder().deduccion(listaConcepto.get(j).getDeducido()).porcentaje(listaConcepto.get(j).getPorcentajeValor()).build();
                    deducciones.setSalud(salud);
                    break;
                case 30:
                    fondo = NFondoPension.builder().deduccion(listaConcepto.get(j).getDeducido()).porcentaje(listaConcepto.get(j).getPorcentajeValor()).build();
                    break;
                case 31:
                    fondoSP.setDeduccion(listaConcepto.get(j).getDeducido());
                    fondoSP.setPorcentaje(listaConcepto.get(j).getPorcentajeValor());
                    fondoSP.setDeduccionSub(Double.valueOf(0.0d));
                    fondoSP.setPorcentajeSub(Double.valueOf(0.0d));
                    break;
                case 32:
                    listaSindicatos.add(NSindicato.builder().deduccion(listaConcepto.get(j).getDeducido()).porcentaje(listaConcepto.get(j).getPorcentajeValor()).build());
                    deducciones.setSindicatos(listaSindicatos);
                    break;
                case 33:
                    listaSanciones.add(new NSancion());
                    deducciones.setSanciones(listaSanciones);
                    break;
                case 34:
                    listaLibranza.add(new NLibranza(listaConcepto.get(j).getConcepto(), listaConcepto.get(j).getDeducido()));
                    deducciones.setLibranzas(listaLibranza);
                    break;
                case 35:
                    NOtrasDeducciones otrasDeducciones = NOtrasDeducciones.builder().otrasDeducciones(listaConcepto.get(j).getDeducido()).build();
                    listaDeduccioneses.add(otrasDeducciones);
                    deducciones.setOtrasDeducciones(listaDeduccioneses);
                    break;
                case 36:
                    deducciones.setPensionVoluntaria(listaConcepto.get(j).getDeducido());
                    break;
                case 37:
                    deducciones.setRetencionFuente(listaConcepto.get(j).getDeducido());
                    break;
                case 38:
                    deducciones.setAFC(listaConcepto.get(j).getDeducido());
                    break;
                case 39:
                    deducciones.setCooperativa(listaConcepto.get(j).getDeducido());
                    break;
                case 40:
                    deducciones.setEmbargoFiscal(listaConcepto.get(j).getDeducido());
                    break;
                case 41:
                    deducciones.setPlanComplementarios(listaConcepto.get(j).getDeducido());
                    break;
                case 42:
                    deducciones.setEducacion(listaConcepto.get(j).getDeducido());
                    break;
                case 43:
                    deducciones.setReintegro(listaConcepto.get(j).getDeducido());
                    break;
                case 44:
                    deducciones.setDeuda(listaConcepto.get(j).getDeducido());
                    break;
                case 46:
                    listaAnticipo.add(new NAnticipo(listaConcepto.get(j).getDeducido()));
                    deducciones.setAnticipos(listaAnticipo);
                    break;
                case 56:
                    listaPagosTerceros.add(new NPagosTerceros(listaConcepto.get(j).getDeducido()));
                    deducciones.setPagosTerceros(listaPagosTerceros);
                    break;
                case 58:
                    deducciones.setReintegro(listaConcepto.get(j).getDeducido());
                    break;
                case 59:
                    fondoSP.setDeduccionSub(listaConcepto.get(j).getDeducido());
                    fondoSP.setPorcentajeSub(listaConcepto.get(j).getPorcentajeValor());
                    break;
            }
        }
        deducciones.setSindicatos(listaSindicatos);
        deducciones.setSanciones(listaSanciones);
        deducciones.setLibranzas(listaLibranza);
        deducciones.setPagosTerceros(listaPagosTerceros);
        deducciones.setOtrasDeducciones(listaDeduccioneses);
        deducciones.setAnticipos(listaAnticipo);
        deducciones.setFondoSP(fondoSP);
        deducciones.setFondoPension(fondo);
        if (deducciones.getFondoPension().getDeduccion() == null) {
            deducciones.getFondoPension().setDeduccion(Double.valueOf(0.0d));
            deducciones.getFondoPension().setPorcentaje(Double.valueOf(0.0d));
        }
        return deducciones;
    }

    private Double getDevengadosTotal(List<ConceptoPorEmpleado> listaConcepto, List<NovedadesNomina> listaNovedades) {
        double sumaConceptos = listaConcepto.stream().mapToDouble(c -> {
            if (c.getDevengado() == null || c.getDevengado().doubleValue() <= 0.0d) {
                return 0.0d;
            }
            return c.getDevengado().doubleValue();
        }).sum();
        return Double.valueOf(sumaConceptos);
    }

    private Double getDeducionesTotal(List<ConceptoPorEmpleado> listaConcepto) {
        return Double.valueOf(listaConcepto.stream().mapToDouble(c -> {
            if (c.getDeducido() == null || c.getDeducido().doubleValue() <= 0.0d) {
                return 0.0d;
            }
            return c.getDeducido().doubleValue();
        }).sum());
    }

    /* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/rrhh/JIFTransmisionNomina$MiRender.class */
    public static class MiRender extends DefaultTableCellRenderer {
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            String valor = table.getValueAt(row, 11).toString();
            if (valor != null && !valor.equals("")) {
                cell.setBackground(new Color(177, 251, 177));
                cell.setForeground(Color.black);
            } else {
                cell.setBackground(Color.WHITE);
                cell.setForeground(Color.black);
            }
            return cell;
        }
    }
}
