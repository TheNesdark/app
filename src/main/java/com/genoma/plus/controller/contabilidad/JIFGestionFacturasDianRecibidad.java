package com.genoma.plus.controller.contabilidad;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.genoma.plus.dto.contabilidad.FacturacionDianRecibidaDto;
import com.genoma.plus.dto.contabilidad.GestionEstado;
import com.genoma.plus.dto.facturaelectronica.RequesterEstadoDian;
import com.genoma.plus.jpa.entities.CcFacturacionDianRecibida;
import com.genoma.plus.jpa.entities.CcFacturacionDianRecibidaEstado;
import com.genoma.plus.jpa.service.ICcFacturacionDianRecibidaEstadoService;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Base64;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/contabilidad/JIFGestionFacturasDianRecibidad.class */
public class JIFGestionFacturasDianRecibidad extends JInternalFrame {
    private DefaultTableModel modeloTable;
    private List<FacturacionDianRecibidaDto> dianRecibidaDto;
    private Metodos metodo;
    private Properties prop = new Properties();
    private ICcFacturacionDianRecibidaEstadoService iCcFacturacionDianRecibidaEstadoService;
    private String end_point;
    private String end_point_leer;
    private String end_point_estado;
    private String codigoEstado;
    private static String FILTRO_BUSQUEDA;
    private ButtonGroup JBG_Filtro;
    private ButtonGroup JBG_FiltroEnvio;
    private JButton JBTExportar;
    private JButton JBT_Enviar;
    private JPanel JPI_Envio;
    private JPanel JPI_Estado;
    private JPanel JPI_Filtro;
    private JPanel JPI_Utilidades;
    private JRadioButton JRB_AceptacionExpresa;
    private JRadioButton JRB_AcuseBienServicio;
    private JRadioButton JRB_AcuseRecibido;
    private JRadioButton JRB_CorreoRecibido;
    private JRadioButton JRB_EstadoAceptacionExpresa;
    private JRadioButton JRB_EstadoAcuseBienServicio;
    private JRadioButton JRB_EstadoAcuseRecibido;
    private JRadioButton JRB_EstadoRechazo;
    private JRadioButton JRB_Rechazo;
    private JRadioButton JRB_Todas;
    private JScrollPane JSPDetalleS;
    public JTable JTDetalleS;
    private JTextField JTFRuta;
    private JTabbedPane JTPDatos;

    public JIFGestionFacturasDianRecibidad() {
        try {
            InputStream input = ConsultasMySQL.class.getClassLoader().getResourceAsStream("recursos/url_endpoint.properties");
            this.prop.load(input);
            this.end_point = this.prop.getProperty("url.facturadian");
            this.end_point_estado = this.prop.getProperty("url.notificacion.estado.facturadian");
            this.end_point_leer = this.prop.getProperty("url.leer.correo");
            leerCorreo();
            this.iCcFacturacionDianRecibidaEstadoService = (ICcFacturacionDianRecibidaEstadoService) Principal.contexto.getBean(ICcFacturacionDianRecibidaEstadoService.class);
            initComponents();
            this.metodo = new Metodos();
            buscar();
        } catch (IOException ex) {
            Logger.getLogger(JIFGestionFacturasDianRecibidad.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX WARN: Type inference failed for: r3v55, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBG_Filtro = new ButtonGroup();
        this.JBG_FiltroEnvio = new ButtonGroup();
        this.JPI_Filtro = new JPanel();
        this.JRB_CorreoRecibido = new JRadioButton();
        this.JRB_Todas = new JRadioButton();
        this.JRB_AcuseRecibido = new JRadioButton();
        this.JRB_AcuseBienServicio = new JRadioButton();
        this.JRB_AceptacionExpresa = new JRadioButton();
        this.JRB_Rechazo = new JRadioButton();
        this.JSPDetalleS = new JScrollPane();
        this.JTDetalleS = new JTable();
        this.JTPDatos = new JTabbedPane();
        this.JPI_Utilidades = new JPanel();
        this.JTFRuta = new JTextField();
        this.JBTExportar = new JButton();
        this.JPI_Envio = new JPanel();
        this.JPI_Estado = new JPanel();
        this.JRB_EstadoAcuseRecibido = new JRadioButton();
        this.JRB_EstadoAcuseBienServicio = new JRadioButton();
        this.JRB_EstadoAceptacionExpresa = new JRadioButton();
        this.JRB_EstadoRechazo = new JRadioButton();
        this.JBT_Enviar = new JButton();
        setClosable(true);
        setIconifiable(true);
        setTitle("GESTIÓN FACTURAS RECIBIDAS");
        setFont(new Font("Arial", 1, 14));
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jiffacturaciondianrecibida");
        setPreferredSize(new Dimension(1307, 828));
        this.JPI_Filtro.setBorder(BorderFactory.createTitledBorder((Border) null, "FILTRO", 1, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JRB_CorreoRecibido.setBackground(new Color(255, 255, 255));
        this.JBG_Filtro.add(this.JRB_CorreoRecibido);
        this.JRB_CorreoRecibido.setFont(new Font("Arial", 1, 12));
        this.JRB_CorreoRecibido.setText("Correo Recibido");
        this.JRB_CorreoRecibido.setOpaque(true);
        this.JRB_CorreoRecibido.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.contabilidad.JIFGestionFacturasDianRecibidad.1
            public void actionPerformed(ActionEvent evt) {
                JIFGestionFacturasDianRecibidad.this.JRB_CorreoRecibidoActionPerformed(evt);
            }
        });
        this.JRB_Todas.setBackground(new Color(255, 255, 255));
        this.JBG_Filtro.add(this.JRB_Todas);
        this.JRB_Todas.setFont(new Font("Arial", 1, 12));
        this.JRB_Todas.setSelected(true);
        this.JRB_Todas.setText("Todas");
        this.JRB_Todas.setOpaque(true);
        this.JRB_Todas.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.contabilidad.JIFGestionFacturasDianRecibidad.2
            public void actionPerformed(ActionEvent evt) {
                JIFGestionFacturasDianRecibidad.this.JRB_TodasActionPerformed(evt);
            }
        });
        this.JRB_AcuseRecibido.setBackground(Color.yellow);
        this.JBG_Filtro.add(this.JRB_AcuseRecibido);
        this.JRB_AcuseRecibido.setFont(new Font("Arial", 1, 12));
        this.JRB_AcuseRecibido.setText("Acuse Recibido");
        this.JRB_AcuseRecibido.setOpaque(true);
        this.JRB_AcuseRecibido.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.contabilidad.JIFGestionFacturasDianRecibidad.3
            public void actionPerformed(ActionEvent evt) {
                JIFGestionFacturasDianRecibidad.this.JRB_AcuseRecibidoActionPerformed(evt);
            }
        });
        this.JRB_AcuseBienServicio.setBackground(Color.orange);
        this.JBG_Filtro.add(this.JRB_AcuseBienServicio);
        this.JRB_AcuseBienServicio.setFont(new Font("Arial", 1, 12));
        this.JRB_AcuseBienServicio.setText("Acuse Bien o Servicio");
        this.JRB_AcuseBienServicio.setOpaque(true);
        this.JRB_AcuseBienServicio.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.contabilidad.JIFGestionFacturasDianRecibidad.4
            public void actionPerformed(ActionEvent evt) {
                JIFGestionFacturasDianRecibidad.this.JRB_AcuseBienServicioActionPerformed(evt);
            }
        });
        this.JRB_AceptacionExpresa.setBackground(new Color(0, 204, 0));
        this.JBG_Filtro.add(this.JRB_AceptacionExpresa);
        this.JRB_AceptacionExpresa.setFont(new Font("Arial", 1, 12));
        this.JRB_AceptacionExpresa.setText("Por Aceptación(Expresa)");
        this.JRB_AceptacionExpresa.setOpaque(true);
        this.JRB_AceptacionExpresa.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.contabilidad.JIFGestionFacturasDianRecibidad.5
            public void actionPerformed(ActionEvent evt) {
                JIFGestionFacturasDianRecibidad.this.JRB_AceptacionExpresaActionPerformed(evt);
            }
        });
        this.JRB_Rechazo.setBackground(Color.red);
        this.JBG_Filtro.add(this.JRB_Rechazo);
        this.JRB_Rechazo.setFont(new Font("Arial", 1, 12));
        this.JRB_Rechazo.setForeground(new Color(255, 255, 255));
        this.JRB_Rechazo.setText("Rechazo");
        this.JRB_Rechazo.setOpaque(true);
        this.JRB_Rechazo.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.contabilidad.JIFGestionFacturasDianRecibidad.6
            public void actionPerformed(ActionEvent evt) {
                JIFGestionFacturasDianRecibidad.this.JRB_RechazoActionPerformed(evt);
            }
        });
        GroupLayout JPI_FiltroLayout = new GroupLayout(this.JPI_Filtro);
        this.JPI_Filtro.setLayout(JPI_FiltroLayout);
        JPI_FiltroLayout.setHorizontalGroup(JPI_FiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_FiltroLayout.createSequentialGroup().addGap(23, 23, 23).addComponent(this.JRB_Todas).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRB_CorreoRecibido).addGap(18, 18, 18).addComponent(this.JRB_AcuseRecibido).addGap(18, 18, 18).addComponent(this.JRB_AcuseBienServicio).addGap(18, 18, 18).addComponent(this.JRB_AceptacionExpresa).addGap(18, 18, 18).addComponent(this.JRB_Rechazo).addContainerGap(-1, 32767)));
        JPI_FiltroLayout.setVerticalGroup(JPI_FiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_FiltroLayout.createSequentialGroup().addGap(20, 20, 20).addGroup(JPI_FiltroLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRB_Todas).addComponent(this.JRB_AcuseRecibido).addComponent(this.JRB_AcuseBienServicio).addComponent(this.JRB_AceptacionExpresa).addComponent(this.JRB_Rechazo).addComponent(this.JRB_CorreoRecibido)).addContainerGap(22, 32767)));
        this.JSPDetalleS.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JSPDetalleS.setFont(new Font("Arial", 1, 12));
        this.JTDetalleS.setFont(new Font("Arial", 1, 12));
        this.JTDetalleS.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalleS.setEditingColumn(1);
        this.JTDetalleS.setEditingRow(1);
        this.JTDetalleS.setRowHeight(25);
        this.JTDetalleS.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalleS.setSelectionForeground(Color.red);
        this.JTDetalleS.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.contabilidad.JIFGestionFacturasDianRecibidad.7
            public void mouseClicked(MouseEvent evt) {
                JIFGestionFacturasDianRecibidad.this.JTDetalleSMouseClicked(evt);
            }
        });
        this.JSPDetalleS.setViewportView(this.JTDetalleS);
        this.JTPDatos.setForeground(new Color(0, 103, 0));
        this.JTPDatos.setFont(new Font("Arial", 1, 14));
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.contabilidad.JIFGestionFacturasDianRecibidad.8
            public void mouseClicked(MouseEvent evt) {
                JIFGestionFacturasDianRecibidad.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setForeground(Color.red);
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.contabilidad.JIFGestionFacturasDianRecibidad.9
            public void actionPerformed(ActionEvent evt) {
                JIFGestionFacturasDianRecibidad.this.JBTExportarActionPerformed(evt);
            }
        });
        GroupLayout JPI_UtilidadesLayout = new GroupLayout(this.JPI_Utilidades);
        this.JPI_Utilidades.setLayout(JPI_UtilidadesLayout);
        JPI_UtilidadesLayout.setHorizontalGroup(JPI_UtilidadesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_UtilidadesLayout.createSequentialGroup().addContainerGap().addComponent(this.JTFRuta, -2, 423, -2).addGap(18, 18, 18).addComponent(this.JBTExportar, -2, 221, -2).addContainerGap(615, 32767)));
        JPI_UtilidadesLayout.setVerticalGroup(JPI_UtilidadesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_UtilidadesLayout.createSequentialGroup().addContainerGap().addGroup(JPI_UtilidadesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFRuta, -2, 50, -2).addComponent(this.JBTExportar, -2, 50, -2)).addContainerGap(13, 32767)));
        this.JTPDatos.addTab("UTILIDADES", this.JPI_Utilidades);
        this.JPI_Estado.setBorder(BorderFactory.createTitledBorder((Border) null, "ESTADO", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JRB_EstadoAcuseRecibido.setBackground(Color.yellow);
        this.JBG_FiltroEnvio.add(this.JRB_EstadoAcuseRecibido);
        this.JRB_EstadoAcuseRecibido.setFont(new Font("Arial", 1, 12));
        this.JRB_EstadoAcuseRecibido.setText("Acuse Recibido");
        this.JRB_EstadoAcuseRecibido.setName("030");
        this.JRB_EstadoAcuseRecibido.setOpaque(true);
        this.JRB_EstadoAcuseRecibido.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.contabilidad.JIFGestionFacturasDianRecibidad.10
            public void actionPerformed(ActionEvent evt) {
                JIFGestionFacturasDianRecibidad.this.JRB_EstadoAcuseRecibidoActionPerformed(evt);
            }
        });
        this.JRB_EstadoAcuseBienServicio.setBackground(Color.orange);
        this.JBG_FiltroEnvio.add(this.JRB_EstadoAcuseBienServicio);
        this.JRB_EstadoAcuseBienServicio.setFont(new Font("Arial", 1, 12));
        this.JRB_EstadoAcuseBienServicio.setText("Recibo del bien o prestación del servicio");
        this.JRB_EstadoAcuseBienServicio.setName("032");
        this.JRB_EstadoAcuseBienServicio.setOpaque(true);
        this.JRB_EstadoAcuseBienServicio.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.contabilidad.JIFGestionFacturasDianRecibidad.11
            public void actionPerformed(ActionEvent evt) {
                JIFGestionFacturasDianRecibidad.this.JRB_EstadoAcuseBienServicioActionPerformed(evt);
            }
        });
        this.JRB_EstadoAceptacionExpresa.setBackground(new Color(0, 204, 0));
        this.JBG_FiltroEnvio.add(this.JRB_EstadoAceptacionExpresa);
        this.JRB_EstadoAceptacionExpresa.setFont(new Font("Arial", 1, 12));
        this.JRB_EstadoAceptacionExpresa.setText("Aceptación(Expresa)");
        this.JRB_EstadoAceptacionExpresa.setName("033");
        this.JRB_EstadoAceptacionExpresa.setOpaque(true);
        this.JRB_EstadoAceptacionExpresa.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.contabilidad.JIFGestionFacturasDianRecibidad.12
            public void actionPerformed(ActionEvent evt) {
                JIFGestionFacturasDianRecibidad.this.JRB_EstadoAceptacionExpresaActionPerformed(evt);
            }
        });
        this.JRB_EstadoRechazo.setBackground(Color.red);
        this.JBG_FiltroEnvio.add(this.JRB_EstadoRechazo);
        this.JRB_EstadoRechazo.setFont(new Font("Arial", 1, 12));
        this.JRB_EstadoRechazo.setForeground(new Color(255, 255, 255));
        this.JRB_EstadoRechazo.setText("Reclamo de la Factura Electrónica de Venta");
        this.JRB_EstadoRechazo.setName("031");
        this.JRB_EstadoRechazo.setOpaque(true);
        this.JRB_EstadoRechazo.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.contabilidad.JIFGestionFacturasDianRecibidad.13
            public void actionPerformed(ActionEvent evt) {
                JIFGestionFacturasDianRecibidad.this.JRB_EstadoRechazoActionPerformed(evt);
            }
        });
        GroupLayout JPI_EstadoLayout = new GroupLayout(this.JPI_Estado);
        this.JPI_Estado.setLayout(JPI_EstadoLayout);
        JPI_EstadoLayout.setHorizontalGroup(JPI_EstadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 855, 32767).addGroup(JPI_EstadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_EstadoLayout.createSequentialGroup().addGap(13, 13, 13).addComponent(this.JRB_EstadoAcuseRecibido).addGap(18, 18, 18).addComponent(this.JRB_EstadoAcuseBienServicio).addGap(18, 18, 18).addComponent(this.JRB_EstadoAceptacionExpresa).addGap(18, 18, 18).addComponent(this.JRB_EstadoRechazo).addContainerGap(-1, 32767))));
        JPI_EstadoLayout.setVerticalGroup(JPI_EstadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 0, 32767).addGroup(JPI_EstadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_EstadoLayout.createSequentialGroup().addGap(5, 5, 5).addGroup(JPI_EstadoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRB_EstadoAcuseRecibido).addComponent(this.JRB_EstadoAcuseBienServicio).addComponent(this.JRB_EstadoAceptacionExpresa).addComponent(this.JRB_EstadoRechazo)).addContainerGap(-1, 32767))));
        this.JBT_Enviar.setFont(new Font("Arial", 1, 12));
        this.JBT_Enviar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBT_Enviar.setText("Enviar Factura");
        this.JBT_Enviar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.contabilidad.JIFGestionFacturasDianRecibidad.14
            public void actionPerformed(ActionEvent evt) {
                JIFGestionFacturasDianRecibidad.this.JBT_EnviarActionPerformed(evt);
            }
        });
        GroupLayout JPI_EnvioLayout = new GroupLayout(this.JPI_Envio);
        this.JPI_Envio.setLayout(JPI_EnvioLayout);
        JPI_EnvioLayout.setHorizontalGroup(JPI_EnvioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_EnvioLayout.createSequentialGroup().addContainerGap().addComponent(this.JPI_Estado, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBT_Enviar, -2, 155, -2).addContainerGap(-1, 32767)));
        JPI_EnvioLayout.setVerticalGroup(JPI_EnvioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_EnvioLayout.createSequentialGroup().addGap(16, 16, 16).addGroup(JPI_EnvioLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JBT_Enviar, -1, 51, 32767).addComponent(this.JPI_Estado, -1, -1, 32767)).addContainerGap(15, 32767)));
        this.JTPDatos.addTab("ENVIO", this.JPI_Envio);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPI_Filtro, -1, -1, 32767).addComponent(this.JSPDetalleS).addComponent(this.JTPDatos)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGap(14, 14, 14).addComponent(this.JPI_Filtro, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalleS, -2, 543, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 17, 32767).addComponent(this.JTPDatos, -2, 115, -2)));
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
                this.JTFRuta.setText(xfile.getAbsolutePath() + this.metodo.getBarra());
                this.JTFRuta.requestFocus();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTExportarActionPerformed(ActionEvent evt) {
        if (!this.JTFRuta.getText().isEmpty()) {
            if (this.JTDetalleS.getRowCount() > -1) {
                int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la información", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (n == 0) {
                    this.metodo.mExportar_Datos_Tabla_Titulo_Formato(this.JTDetalleS, this.metodo.mTraerUrlBD(this.JTFRuta.getText()), getTitle());
                    return;
                }
                return;
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un ruta valida", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JTFRuta.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_RechazoActionPerformed(ActionEvent evt) {
        FILTRO_BUSQUEDA = "031";
        cargarDatos();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_TodasActionPerformed(ActionEvent evt) {
        cargarDatos();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_CorreoRecibidoActionPerformed(ActionEvent evt) {
        FILTRO_BUSQUEDA = "000";
        cargarDatos();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_AcuseRecibidoActionPerformed(ActionEvent evt) {
        FILTRO_BUSQUEDA = "030";
        cargarDatos();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_AcuseBienServicioActionPerformed(ActionEvent evt) {
        FILTRO_BUSQUEDA = "032";
        cargarDatos();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_AceptacionExpresaActionPerformed(ActionEvent evt) {
        FILTRO_BUSQUEDA = "033";
        cargarDatos();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_EstadoAcuseRecibidoActionPerformed(ActionEvent evt) {
        this.codigoEstado = this.JRB_EstadoAcuseRecibido.getName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_EstadoAcuseBienServicioActionPerformed(ActionEvent evt) {
        this.codigoEstado = this.JRB_EstadoAcuseBienServicio.getName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_EstadoAceptacionExpresaActionPerformed(ActionEvent evt) {
        this.codigoEstado = this.JRB_EstadoAceptacionExpresa.getName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_EstadoRechazoActionPerformed(ActionEvent evt) {
        this.codigoEstado = this.JRB_EstadoRechazo.getName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_EnviarActionPerformed(ActionEvent evt) {
        if (this.JTDetalleS.getSelectedRow() != -1) {
            RestTemplate restTemplate = new RestTemplate();
            BillEventRequester billEventRequester = new BillEventRequester();
            PersonRequester requester = new PersonRequester();
            new FacturaElectronicaWrapper();
            requester.setId(Principal.usuarioSistemaDTO.getNumeroDocumento());
            requester.setIdType(Principal.usuarioSistemaDTO.getTipoDocumentoDian());
            requester.setFirstName(Principal.usuarioSistemaDTO.getPrimerNombre());
            requester.setLastName(Principal.usuarioSistemaDTO.getSegundoApellido());
            requester.setPosition(Principal.usuarioSistemaDTO.getNombreCargoUsuario());
            requester.setArea(Principal.usuarioSistemaDTO.getUnidadFuncional());
            billEventRequester.setResponsiblePerson(requester);
            ObjectMapper objectMapper = new ObjectMapper();
            String facturaElectronica = null;
            try {
                System.out.println("datos  : " + this.dianRecibidaDto.get(this.JTDetalleS.getSelectedRow()).getJsonFactura());
                FacturaElectronicaWrapper wrapper = (FacturaElectronicaWrapper) objectMapper.readValue(this.dianRecibidaDto.get(this.JTDetalleS.getSelectedRow()).getJsonFactura(), FacturaElectronicaWrapper.class);
                billEventRequester.setInvoice(wrapper.getInvoice());
                facturaElectronica = objectMapper.writeValueAsString(billEventRequester);
            } catch (JsonProcessingException e) {
                Logger.getLogger(JIFGestionFacturasDianRecibidad.class.getName()).log(Level.SEVERE, (String) null, e);
            }
            String cadenaCodificada = Base64.getEncoder().encodeToString(facturaElectronica.getBytes());
            System.out.println("" + cadenaCodificada);
            HttpHeaders headers = new HttpHeaders();
            headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
            headers.add("X-Body", cadenaCodificada);
            HttpEntity<String> entity = new HttpEntity<>(headers);
            String url = this.end_point_estado + "//" + this.codigoEstado + "//";
            System.out.println("" + url);
            RequesterEstadoDian requesterEstadoDian = (RequesterEstadoDian) restTemplate.postForObject(url, entity, RequesterEstadoDian.class, new Object[0]);
            System.out.println("" + requesterEstadoDian.getMensaje());
            if (requesterEstadoDian.getEstado().equals("SUCCESS")) {
                CcFacturacionDianRecibida dianRecibida = new CcFacturacionDianRecibida();
                dianRecibida.setId(this.dianRecibidaDto.get(this.JTDetalleS.getSelectedRow()).getId());
                CcFacturacionDianRecibidaEstado estado = CcFacturacionDianRecibidaEstado.builder().codigoEstado(this.codigoEstado).estado(true).estadoRespuesta(requesterEstadoDian.getEstado()).mensaje(requesterEstadoDian.getMensaje()).fechaRegistro(this.metodo.getFechaActual()).fecha(this.metodo.getFechaActual()).idUsuarioRh(Principal.usuarioSistemaDTO.getIdPersonaCargo()).idFacturasRecibida(dianRecibida).build();
                this.iCcFacturacionDianRecibidaEstadoService.save(estado);
                cargarDatos();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, requesterEstadoDian.getMensaje(), "VERIFICACIÓN", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleSMouseClicked(MouseEvent evt) {
        if (this.JTDetalleS.getSelectedRow() != -1) {
            validarEstado(this.JTDetalleS.getValueAt(this.JTDetalleS.getSelectedRow(), 8).toString());
        }
    }

    private void crearModelo() {
        this.modeloTable = new DefaultTableModel() { // from class: com.genoma.plus.controller.contabilidad.JIFGestionFacturasDianRecibidad.15
            Class[] types = {Date.class, String.class, String.class, String.class, String.class, Double.class, Double.class, Double.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, true, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return this.canEdit[colIndex];
            }
        };
        this.modeloTable.addColumn("Fecha");
        this.modeloTable.addColumn("Hora");
        this.modeloTable.addColumn("No Factura");
        this.modeloTable.addColumn("Nit");
        this.modeloTable.addColumn("Nombre Emisor");
        this.modeloTable.addColumn("SubTotal");
        this.modeloTable.addColumn("Valor Impuesto");
        this.modeloTable.addColumn("Valor Total");
        this.modeloTable.addColumn("Estado");
        this.modeloTable.addColumn("cufe");
        this.modeloTable.addColumn("nombreCarpeta");
        this.modeloTable.addColumn("Json");
        this.JTDetalleS.setAutoResizeMode(0);
        this.JTDetalleS.doLayout();
        this.JTDetalleS.setModel(this.modeloTable);
        this.JTDetalleS.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTDetalleS.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTDetalleS.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTDetalleS.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTDetalleS.getColumnModel().getColumn(4).setPreferredWidth(300);
        this.JTDetalleS.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTDetalleS.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTDetalleS.getColumnModel().getColumn(7).setPreferredWidth(100);
        this.JTDetalleS.getColumnModel().getColumn(8).setPreferredWidth(100);
        this.JTDetalleS.getColumnModel().getColumn(9).setPreferredWidth(300);
        this.JTDetalleS.getColumnModel().getColumn(10).setPreferredWidth(200);
        this.JTDetalleS.getColumnModel().getColumn(11).setPreferredWidth(200);
    }

    private void leerCorreo() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getForObject(this.end_point_leer, Void.TYPE, new Object[0]);
    }

    private void cargarDatos() {
        FacturacionDianRecibidaDto[] list;
        RestTemplate restTemplate = new RestTemplate();
        if (!this.JRB_Todas.isSelected()) {
            list = (FacturacionDianRecibidaDto[]) restTemplate.getForObject(this.end_point + "/" + FILTRO_BUSQUEDA, FacturacionDianRecibidaDto[].class, new Object[0]);
        } else {
            list = (FacturacionDianRecibidaDto[]) restTemplate.getForObject(this.end_point, FacturacionDianRecibidaDto[].class, new Object[0]);
        }
        crearModelo();
        if (list != null) {
            this.dianRecibidaDto = Arrays.asList(list);
            this.dianRecibidaDto.forEach(f -> {
                this.modeloTable.addRow((Object[]) null);
                this.modeloTable.setValueAt(f.getFechaFactura(), this.JTDetalleS.getRowCount() - 1, 0);
                this.modeloTable.setValueAt(f.getHoraFactura(), this.JTDetalleS.getRowCount() - 1, 1);
                this.modeloTable.setValueAt(f.getNumeroFactura(), this.JTDetalleS.getRowCount() - 1, 2);
                this.modeloTable.setValueAt(f.getNit(), this.JTDetalleS.getRowCount() - 1, 3);
                this.modeloTable.setValueAt(f.getNombreEmisor(), this.JTDetalleS.getRowCount() - 1, 4);
                this.modeloTable.setValueAt(f.getSubTotal(), this.JTDetalleS.getRowCount() - 1, 5);
                this.modeloTable.setValueAt(f.getValorImpuesto(), this.JTDetalleS.getRowCount() - 1, 6);
                this.modeloTable.setValueAt(f.getValorTotal(), this.JTDetalleS.getRowCount() - 1, 7);
                this.modeloTable.setValueAt(GestionEstado.findByAbbr(f.getGestionEstado()), this.JTDetalleS.getRowCount() - 1, 8);
                this.modeloTable.setValueAt(f.getCufe(), this.JTDetalleS.getRowCount() - 1, 9);
                this.modeloTable.setValueAt(f.getNombreCarpeta(), this.JTDetalleS.getRowCount() - 1, 10);
                this.modeloTable.setValueAt(f.getJsonFactura(), this.JTDetalleS.getRowCount() - 1, 11);
                this.JTDetalleS.setDefaultRenderer(Object.class, new MiRender());
            });
        }
    }

    public void buscar() {
        cargarDatos();
    }

    private void validarEstado(String valorEstado) {
        switch (valorEstado) {
            case "CORREO_RECIBIDO":
                this.JRB_EstadoAcuseRecibido.setEnabled(true);
                this.JRB_EstadoAcuseBienServicio.setEnabled(false);
                this.JRB_EstadoAceptacionExpresa.setEnabled(false);
                this.JRB_EstadoRechazo.setEnabled(false);
                break;
            case "ACUSE_RECIBIDO":
                this.JRB_EstadoAcuseRecibido.setEnabled(false);
                this.JRB_EstadoAcuseBienServicio.setEnabled(true);
                this.JRB_EstadoAceptacionExpresa.setEnabled(false);
                this.JRB_EstadoRechazo.setEnabled(false);
                break;
            case "RECIBIDO_BIEN_SERVICO":
                this.JRB_EstadoAcuseRecibido.setEnabled(false);
                this.JRB_EstadoAcuseBienServicio.setEnabled(false);
                this.JRB_EstadoAceptacionExpresa.setEnabled(true);
                this.JRB_EstadoRechazo.setEnabled(true);
                break;
            case "ACEPTACION_EXPRESA":
                this.JRB_EstadoAcuseRecibido.setEnabled(false);
                this.JRB_EstadoAcuseBienServicio.setEnabled(false);
                this.JRB_EstadoAceptacionExpresa.setEnabled(false);
                this.JRB_EstadoRechazo.setEnabled(true);
                break;
            case "RECLAMO":
                this.JRB_EstadoAcuseRecibido.setEnabled(false);
                this.JRB_EstadoAcuseBienServicio.setEnabled(false);
                this.JRB_EstadoAceptacionExpresa.setEnabled(false);
                this.JRB_EstadoRechazo.setEnabled(false);
                break;
            default:
                this.JRB_EstadoAcuseRecibido.setEnabled(false);
                this.JRB_EstadoAcuseBienServicio.setEnabled(false);
                this.JRB_EstadoAceptacionExpresa.setEnabled(false);
                this.JRB_EstadoRechazo.setEnabled(false);
                break;
        }
    }

    /* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/contabilidad/JIFGestionFacturasDianRecibidad$MiRender.class */
    public static class MiRender extends DefaultTableCellRenderer {
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell;
            cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            switch (table.getValueAt(row, 8).toString()) {
                case "CORREO_RECIBIDO":
                    cell.setBackground(Color.WHITE);
                    cell.setForeground(Color.BLACK);
                    break;
                case "ACUSE_RECIBIDO":
                    cell.setBackground(Color.YELLOW);
                    cell.setForeground(Color.BLACK);
                    break;
                case "RECIBIDO_BIEN_SERVICO":
                    cell.setBackground(Color.ORANGE);
                    cell.setForeground(Color.BLACK);
                    break;
                case "ACEPTACION_EXPRESA":
                    cell.setBackground(new Color(0, 204, 0));
                    cell.setForeground(Color.BLACK);
                    break;
                case "RECLAMO":
                    cell.setBackground(Color.RED);
                    cell.setForeground(Color.BLACK);
                    break;
                default:
                    cell.setBackground(Color.WHITE);
                    cell.setForeground(Color.BLACK);
                    break;
            }
            return cell;
        }
    }
}
