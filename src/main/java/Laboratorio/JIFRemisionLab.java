package Laboratorio;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.genoma.plus.controller.general.JIFRecursosMicroServicios;
import com.genoma.plus.controller.general.dto.RecursosMicroserviciosDTO;
import com.genoma.plus.controller.laboratorio.dto.BitacoraEnvioRemisionDto;
import com.genoma.plus.controller.laboratorio.dto.ColcanResponseDTO;
import com.genoma.plus.controller.laboratorio.dto.CustomPresenter;
import com.genoma.plus.controller.laboratorio.dto.WrapperColocanDto;
import com.genoma.plus.domains.models.domains.general.RecursosMicroserviciosDomain;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyVetoException;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;

/* JADX INFO: loaded from: GenomaP.jar:Laboratorio/JIFRemisionLab.class */
public class JIFRemisionLab extends JInternalFrame {
    private RecursosMicroserviciosDTO microserviciosDTO;
    private DefaultTableModel xmodelo;
    private Object[] xdatos;
    private String[][] xidempresa;
    private JDBuscarRemisiones xjdremisiones;
    private Set<Long> idProcedimientoSet;
    private ButtonGroup JBGSeleccion;
    private JButton JBTEnvioColcan;
    private JButton JBTExportar1;
    public JComboBox JCBProveedor;
    private JCheckBox JCHFiltro;
    private JCheckBox JCH_Adjunto;
    private JDateChooser JDFechaF;
    private JDateChooser JDFechaI;
    private JLabel JLB_NRecepciones;
    private JPanel JPIDatos;
    private JRadioButton JRBQuitarSeleccion;
    private JRadioButton JRBSeleccionar;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;
    private JTextField JTFRuta;
    private ConsultasMySQL xconsulta = new ConsultasMySQL();
    private Metodos xmetodos = new Metodos();
    private int xdesc = 0;
    private int xid = 0;
    private int xestado = 1;
    private int xfiltro = 0;
    private boolean xestadog = false;
    private boolean xlleno = false;
    private boolean xtipog = false;

    public JIFRemisionLab() {
        initComponents();
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v44, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGSeleccion = new ButtonGroup();
        this.JPIDatos = new JPanel();
        this.JCBProveedor = new JComboBox();
        this.JDFechaI = new JDateChooser();
        this.JDFechaF = new JDateChooser();
        this.JRBSeleccionar = new JRadioButton();
        this.JRBQuitarSeleccion = new JRadioButton();
        this.JCHFiltro = new JCheckBox();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JBTEnvioColcan = new JButton();
        this.JTFRuta = new JTextField();
        this.JCH_Adjunto = new JCheckBox();
        this.JBTExportar1 = new JButton();
        this.JLB_NRecepciones = new JLabel();
        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        setTitle("REMISIÓN DE EXÁMENES");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setMaximumSize(new Dimension(966, 640));
        setMinimumSize(new Dimension(966, 640));
        setName("jifremisione");
        try {
            setSelected(true);
        } catch (PropertyVetoException e1) {
            e1.printStackTrace();
        }
        addInternalFrameListener(new InternalFrameListener() { // from class: Laboratorio.JIFRemisionLab.1
            public void internalFrameActivated(InternalFrameEvent evt) {
            }

            public void internalFrameClosed(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                JIFRemisionLab.this.formInternalFrameClosing(evt);
            }

            public void internalFrameDeactivated(InternalFrameEvent evt) {
            }

            public void internalFrameDeiconified(InternalFrameEvent evt) {
            }

            public void internalFrameIconified(InternalFrameEvent evt) {
            }

            public void internalFrameOpened(InternalFrameEvent evt) {
            }
        });
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JCBProveedor.setFont(new Font("Arial", 1, 12));
        this.JCBProveedor.setBorder(BorderFactory.createTitledBorder((Border) null, "Tercero", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicial", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFechaI.setFont(new Font("Arial", 1, 12));
        this.JDFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Final", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFechaF.setFont(new Font("Arial", 1, 12));
        this.JBGSeleccion.add(this.JRBSeleccionar);
        this.JRBSeleccionar.setFont(new Font("Arial", 1, 12));
        this.JRBSeleccionar.setSelected(true);
        this.JRBSeleccionar.setText("Seleccionar Todo");
        this.JRBSeleccionar.addActionListener(new ActionListener() { // from class: Laboratorio.JIFRemisionLab.2
            public void actionPerformed(ActionEvent evt) {
                JIFRemisionLab.this.JRBSeleccionarActionPerformed(evt);
            }
        });
        this.JBGSeleccion.add(this.JRBQuitarSeleccion);
        this.JRBQuitarSeleccion.setFont(new Font("Arial", 1, 12));
        this.JRBQuitarSeleccion.setText("Quitar Selección");
        this.JRBQuitarSeleccion.addActionListener(new ActionListener() { // from class: Laboratorio.JIFRemisionLab.3
            public void actionPerformed(ActionEvent evt) {
                JIFRemisionLab.this.JRBQuitarSeleccionActionPerformed(evt);
            }
        });
        this.JCHFiltro.setFont(new Font("Arial", 1, 12));
        this.JCHFiltro.setText("Filtro?");
        this.JCHFiltro.addActionListener(new ActionListener() { // from class: Laboratorio.JIFRemisionLab.4
            public void actionPerformed(ActionEvent evt) {
                JIFRemisionLab.this.JCHFiltroActionPerformed(evt);
            }
        });
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JDFechaI, -2, 150, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JDFechaF, -2, 150, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBProveedor, -2, 528, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHFiltro).addGap(4, 4, 4).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JRBQuitarSeleccion).addComponent(this.JRBSeleccionar)).addGap(5, 5, 5)));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addGap(5, 5, 5).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosLayout.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.JRBSeleccionar).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBQuitarSeleccion).addContainerGap()).addGroup(JPIDatosLayout.createSequentialGroup().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JDFechaI, GroupLayout.Alignment.LEADING, -2, 50, -2).addGroup(GroupLayout.Alignment.LEADING, JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBProveedor, -2, 50, -2).addComponent(this.JCHFiltro)).addComponent(this.JDFechaF, GroupLayout.Alignment.LEADING, -2, 50, -2)).addGap(10, 10, 10)))));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalle.setSelectionMode(0);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: Laboratorio.JIFRemisionLab.5
            public void mouseClicked(MouseEvent evt) {
                JIFRemisionLab.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.JBTEnvioColcan.setFont(new Font("Arial", 1, 12));
        this.JBTEnvioColcan.setForeground(Color.red);
        this.JBTEnvioColcan.setIcon(new ImageIcon(getClass().getResource("/Imagenes/hojaAtencion.png")));
        this.JBTEnvioColcan.setText("Enviar");
        this.JBTEnvioColcan.setToolTipText("");
        this.JBTEnvioColcan.setEnabled(false);
        this.JBTEnvioColcan.addActionListener(new ActionListener() { // from class: Laboratorio.JIFRemisionLab.6
            public void actionPerformed(ActionEvent evt) {
                JIFRemisionLab.this.JBTEnvioColcanActionPerformed(evt);
            }
        });
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: Laboratorio.JIFRemisionLab.7
            public void mouseClicked(MouseEvent evt) {
                JIFRemisionLab.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JCH_Adjunto.setBackground(Color.green);
        this.JCH_Adjunto.setFont(new Font("Arial", 1, 12));
        this.JCH_Adjunto.setText("Adjunto?");
        this.JCH_Adjunto.setOpaque(true);
        this.JBTExportar1.setFont(new Font("Arial", 1, 12));
        this.JBTExportar1.setForeground(Color.red);
        this.JBTExportar1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar1.setText("Exportar");
        this.JBTExportar1.addActionListener(new ActionListener() { // from class: Laboratorio.JIFRemisionLab.8
            public void actionPerformed(ActionEvent evt) {
                JIFRemisionLab.this.JBTExportar1ActionPerformed(evt);
            }
        });
        this.JLB_NRecepciones.setFont(new Font("Arial", 1, 14));
        this.JLB_NRecepciones.setForeground(Color.red);
        this.JLB_NRecepciones.setHorizontalAlignment(0);
        this.JLB_NRecepciones.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Muestras", 0, 0, new Font("Arial", 1, 12)));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(5, 5, 5).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPIDatos, -1, -1, 32767).addGroup(layout.createSequentialGroup().addComponent(this.JTFRuta, -2, 376, -2).addGap(18, 18, 18).addComponent(this.JBTExportar1, -2, 167, -2).addGap(18, 18, 18).addComponent(this.JBTEnvioColcan, -2, 146, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JCH_Adjunto).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JLB_NRecepciones, -2, 131, -2)))).addComponent(this.JSPDetalle)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.JPIDatos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPDetalle, -2, 398, -2).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(4, 4, 4).addComponent(this.JTFRuta, -2, 50, -2)).addGroup(layout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBTExportar1, -2, 50, -2).addComponent(this.JBTEnvioColcan, -2, 50, -2).addComponent(this.JCH_Adjunto))).addGroup(layout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JLB_NRecepciones, -2, 50, -2))).addGap(13, 13, 13)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        this.JBTEnvioColcan.setEnabled(true);
        if (this.JTDetalle.getSelectedRow() != -1 && evt.getClickCount() == 2) {
            if (this.JTDetalle.getValueAt(this.JTDetalle.getSelectedRow(), 8) != null) {
                try {
                    String texto = new String((byte[]) this.JTDetalle.getValueAt(this.JTDetalle.getSelectedRow(), 8), "UTF-8");
                    String[] parts = texto.split("\\.");
                    if (parts.length > 2) {
                        this.xmetodos.AbrirArchivosblob(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 8), "soporte", "pdf", true);
                    } else if (parts[1].equals("pdf")) {
                        this.xmetodos.mostrarPdf(this.xmetodos.mRutaSoporte("JDCarguePDFResultadosExternos") + texto);
                    }
                    return;
                } catch (UnsupportedEncodingException ex) {
                    Logger.getLogger(JIFRemisionLab.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                    return;
                }
            }
            return;
        }
        if (!this.JTDetalle.getModel().getColumnClass(9).equals(JButton.class) || this.JTDetalle.getSelectedColumn() != 9 || this.JTDetalle.getSelectedRow() == -1) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBSeleccionarActionPerformed(ActionEvent evt) {
        mQuitarPonerSeleccion();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBQuitarSeleccionActionPerformed(ActionEvent evt) {
        mQuitarPonerSeleccion();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosing(InternalFrameEvent evt) {
        Principal.mLimpiarDatosP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHFiltroActionPerformed(ActionEvent evt) {
        if (this.JCHFiltro.isSelected()) {
            this.xfiltro = 1;
        } else {
            this.xfiltro = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTEnvioColcanActionPerformed(ActionEvent evt) {
        if (veriifcarCodigoHomologado()) {
            enviarRemisionColcan();
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
                this.JTFRuta.setText(xfile.getAbsolutePath() + this.xmetodos.getBarra());
                this.JTFRuta.requestFocus();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTExportar1ActionPerformed(ActionEvent evt) {
        this.xmetodos.mExportar_Datos_Tabla_Titulo_Formato(this.JTDetalle, this.JTFRuta.getText(), getTitle());
    }

    public void mQuitarPonerSeleccion() {
        if (this.JTDetalle.getRowCount() != -1) {
            for (int x = 0; x < this.JTDetalle.getRowCount(); x++) {
                if (this.JRBSeleccionar.isSelected()) {
                    this.xmodelo.setValueAt(true, x, 6);
                } else if (this.JRBQuitarSeleccion.isSelected()) {
                    this.xmodelo.setValueAt(false, x, 6);
                }
            }
        }
    }

    /* JADX WARN: Not initialized variable reg: 10, insn: 0x0232: MOVE (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r10 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:78:0x0232 */
    /* JADX WARN: Not initialized variable reg: 9, insn: 0x022e: MOVE (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r9 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY] A[D('response' javax.ws.rs.core.Response)]) A[TRY_LEAVE], block:B:76:0x022e */
    public void enviarRemisionColcan() {
        Response response;
        Throwable th;
        RecursosMicroserviciosDomain microserviciosDomain = this.xmetodos.getParametrosEncriptados("24", "ListadoRemisionPorId");
        String fullUrl = microserviciosDomain.getUrlRecurso() + "/" + Principal.txtNo.getText();
        System.err.println("fullUrl: " + fullUrl);
        try {
            try {
                try {
                    Response response2 = this.xmetodos.getResteasyClient().target(fullUrl).request().get();
                    Throwable th2 = null;
                    int statusCode = response2.getStatus();
                    if (statusCode != 200) {
                        System.err.println("Error en la respuesta. Código de estado: " + statusCode);
                        if (response2 != null) {
                            if (0 != 0) {
                                try {
                                    response2.close();
                                } catch (Throwable th3) {
                                    th2.addSuppressed(th3);
                                }
                            } else {
                                response2.close();
                            }
                        }
                        this.xmetodos.getResteasyClient().close();
                        return;
                    }
                    String responseBody = (String) response2.readEntity(String.class);
                    if (responseBody == null || responseBody.isEmpty()) {
                        System.err.println("La respuesta está vacía.");
                        if (response2 != null) {
                            if (0 != 0) {
                                try {
                                    response2.close();
                                } catch (Throwable th4) {
                                    th2.addSuppressed(th4);
                                }
                            } else {
                                response2.close();
                            }
                        }
                        this.xmetodos.getResteasyClient().close();
                        return;
                    }
                    System.out.println("Response Body: " + responseBody);
                    CustomPresenter presenter = (CustomPresenter) this.xmetodos.getMapper().readValue(responseBody, CustomPresenter.class);
                    if (presenter == null || presenter.getData() == null) {
                        System.err.println("La respuesta no contiene datos válidos.");
                        if (response2 != null) {
                            if (0 != 0) {
                                try {
                                    response2.close();
                                } catch (Throwable th5) {
                                    th2.addSuppressed(th5);
                                }
                            } else {
                                response2.close();
                            }
                        }
                        this.xmetodos.getResteasyClient().close();
                        return;
                    }
                    WrapperColocanDto wrapperColocanDto = (WrapperColocanDto) this.xmetodos.getMapper().readValue(this.xmetodos.getMapper().writeValueAsString(presenter.getData()), new TypeReference<WrapperColocanDto>() { // from class: Laboratorio.JIFRemisionLab.9
                    });
                    if (wrapperColocanDto == null || wrapperColocanDto.getColcan() == null || wrapperColocanDto.getColcan().isEmpty()) {
                        System.err.println("No hay datos de Colcan para procesar.");
                        if (response2 != null) {
                            if (0 != 0) {
                                try {
                                    response2.close();
                                } catch (Throwable th6) {
                                    th2.addSuppressed(th6);
                                }
                            } else {
                                response2.close();
                            }
                        }
                        this.xmetodos.getResteasyClient().close();
                        return;
                    }
                    wrapperColocanDto.getColcan().forEach(e -> {
                        try {
                            try {
                                String jsonPayload = this.xmetodos.getMapper().writeValueAsString(e);
                                System.out.println("JSON enviado: " + jsonPayload);
                                RecursosMicroserviciosDomain microColcan = new Metodos().getParametrosEncriptados("24", "ComunicacionColcan");
                                String postUrl = microColcan.getUrlRecurso();
                                Response responsePos = this.xmetodos.getResteasyClient().target(postUrl).request().post(Entity.json(this.xmetodos.getMapper().writeValueAsString(e)));
                                Throwable th7 = null;
                                int postStatusCode = responsePos.getStatus();
                                if (postStatusCode == 404) {
                                    System.err.println("Error 404: Recurso no encontrado. Verifica la URL: " + postUrl);
                                    if (responsePos != null) {
                                        if (0 == 0) {
                                            responsePos.close();
                                            return;
                                        }
                                        try {
                                            responsePos.close();
                                            return;
                                        } catch (Throwable th8) {
                                            th7.addSuppressed(th8);
                                            return;
                                        }
                                    }
                                    return;
                                }
                                if (postStatusCode != 200) {
                                    System.err.println("Error en la respuesta POST. Código de estado: " + postStatusCode);
                                    if (responsePos != null) {
                                        if (0 == 0) {
                                            responsePos.close();
                                            return;
                                        }
                                        try {
                                            responsePos.close();
                                            return;
                                        } catch (Throwable th9) {
                                            th7.addSuppressed(th9);
                                            return;
                                        }
                                    }
                                    return;
                                }
                                String responseBodyPos = (String) responsePos.readEntity(String.class);
                                if (responseBodyPos == null || responseBodyPos.isEmpty()) {
                                    System.err.println("La respuesta POST está vacía.");
                                    if (responsePos != null) {
                                        if (0 == 0) {
                                            responsePos.close();
                                            return;
                                        }
                                        try {
                                            responsePos.close();
                                            return;
                                        } catch (Throwable th10) {
                                            th7.addSuppressed(th10);
                                            return;
                                        }
                                    }
                                    return;
                                }
                                ColcanResponseDTO miDto = (ColcanResponseDTO) new ObjectMapper().readValue(responseBodyPos, ColcanResponseDTO.class);
                                if (miDto == null) {
                                    System.err.println("No se pudo deserializar la respuesta POST.");
                                    if (responsePos != null) {
                                        if (0 == 0) {
                                            responsePos.close();
                                            return;
                                        }
                                        try {
                                            responsePos.close();
                                            return;
                                        } catch (Throwable th11) {
                                            th7.addSuppressed(th11);
                                            return;
                                        }
                                    }
                                    return;
                                }
                                RecursosMicroserviciosDomain microserviciosDomainEnvio = this.xmetodos.getParametrosEncriptados("24", "jifremisione");
                                BitacoraEnvioRemisionDto envioRemisionDto = BitacoraEnvioRemisionDto.builder().estado(true).fechaRegistro(LocalDate.now()).idRecepcion(Long.valueOf(e.getIdPresolicitud())).idRemision(Long.valueOf(Principal.txtNo.getText())).idUsuarioS(Principal.usuarioSistemaDTO.getIdPersonaCargo()).responseDomain(miDto).build();
                                Response responsePosDomain = this.xmetodos.getResteasyClient().target(microserviciosDomainEnvio.getUrlRecurso()).request().post(Entity.json(this.xmetodos.getMapper().writeValueAsString(envioRemisionDto)));
                                Throwable th12 = null;
                                try {
                                    try {
                                        if (responsePosDomain.getStatus() != 200) {
                                            System.err.println("Error en la respuesta del dominio. Código de estado: " + responsePosDomain.getStatus());
                                        }
                                        if (responsePosDomain != null) {
                                            if (0 != 0) {
                                                try {
                                                    responsePosDomain.close();
                                                } catch (Throwable th13) {
                                                    th12.addSuppressed(th13);
                                                }
                                            } else {
                                                responsePosDomain.close();
                                            }
                                        }
                                        if (responsePos != null) {
                                            if (0 != 0) {
                                                try {
                                                    responsePos.close();
                                                } catch (Throwable th14) {
                                                    th7.addSuppressed(th14);
                                                }
                                            } else {
                                                responsePos.close();
                                            }
                                        }
                                        return;
                                    } catch (Throwable th15) {
                                        if (responsePosDomain != null) {
                                            if (th12 != null) {
                                                try {
                                                    responsePosDomain.close();
                                                } catch (Throwable th16) {
                                                    th12.addSuppressed(th16);
                                                }
                                            } else {
                                                responsePosDomain.close();
                                            }
                                        }
                                        throw th15;
                                    }
                                } catch (Throwable th17) {
                                    th12 = th17;
                                    throw th17;
                                }
                            } finally {
                            }
                        } catch (JsonProcessingException e) {
                            Logger.getLogger(JIFRemisionLab.class.getName()).log(Level.SEVERE, "Error al procesar JSON", e);
                        }
                        Logger.getLogger(JIFRemisionLab.class.getName()).log(Level.SEVERE, "Error al procesar JSON", e);
                    });
                    mCargarDatosTabla(Principal.txtNo.getText(), "");
                    if (response2 != null) {
                        if (0 != 0) {
                            try {
                                response2.close();
                            } catch (Throwable th7) {
                                th2.addSuppressed(th7);
                            }
                        } else {
                            response2.close();
                        }
                    }
                    this.xmetodos.getResteasyClient().close();
                } catch (Exception ex) {
                    Logger.getLogger(JIFRemisionLab.class.getName()).log(Level.SEVERE, "Error inesperado", (Throwable) ex);
                    this.xmetodos.getResteasyClient().close();
                } catch (JsonProcessingException e2) {
                    Logger.getLogger(JIFRecursosMicroServicios.class.getName()).log(Level.SEVERE, "Error al procesar JSON", e2);
                    this.xmetodos.getResteasyClient().close();
                }
            } catch (Throwable th8) {
                if (response != null) {
                    if (th != null) {
                        try {
                            response.close();
                        } catch (Throwable th9) {
                            th.addSuppressed(th9);
                        }
                    } else {
                        response.close();
                    }
                }
                throw th8;
            }
        } catch (Throwable th10) {
            this.xmetodos.getResteasyClient().close();
            throw th10;
        }
    }

    public void mBuscar() {
        String sql;
        Object[] botones = {"Procedimiento", "Remisiones", "Cerrar"};
        int n = JOptionPane.showInternalOptionDialog(this, "Que desea hacer", "BUSCAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), botones, "Cerrar");
        if (n == 0) {
            if (this.xfiltro == 1) {
                sql = "SELECT\n\tl_recepcion.Id as idRecepcion,\n\tDATE_FORMAT(l_recepcion.FechaRecep, '%Y-%m-%d %H:%i:%s') as fechaRecepcion,\n\tconcat(gp.Id_TipoIdentificacion, ' ', gp.NoDocumento) as documento,\n\tconcat(gp.Apellido1, ' ', gp.Apellido2, ' ', gp.Nombre1, ' ', gp.Nombre2) as nombreUsuario,\n\tg_procedimiento.Id as idProcedimiento,\n\tg_procedimiento.Nbre as nombreProcedimiento,\n\tl_detallerecepcion.Id_Procedim as idProcedimientoRemision,\n\t'' as razonSocialCompleta,\n\tg_procedimiento.EsRemitido,\n\tIFNULL(f.EsRemitido, 0) AS EsR,\n\tnull url,\n\t'' as estadoEnvio\nFROM\n\tl_detallerecepcion\nINNER JOIN l_recepcion ON\n\t(l_detallerecepcion.Id_Recepcion = l_recepcion.Id)\nINNER JOIN g_procedimiento ON\n\t(l_detallerecepcion.Id_Procedim = g_procedimiento.Id)\nINNER JOIN `l_remisionxprocedimientoxentidad` ON\n\tg_procedimiento.Id = l_remisionxprocedimientoxentidad.`IdProcedimiento`\nINNER JOIN l_areas ON\n\t(g_procedimiento.Id_Area = l_areas.Id)\nINNER JOIN g_persona gp ON\n\t(gp.Id = l_recepcion.Id_Paciente)\nLEFT JOIN (\n\tSELECT\n\t\t`l_detallerecepcion_comentario`.`Id_Recepcion` ,\n\t\t`l_detallerecepcion_comentario`.`Id_Procedimiento` ,\n\t\t`l_detallerecepcion_comentario`.`EsRemitido`  \n  ,\n\t\t`l_detalleremision`.`Id_Remision`\n\tFROM\n\t\t`l_detallerecepcion_comentario`\n\tLEFT JOIN `l_detalleremision` ON\n\t\t(`l_detalleremision`.`Id_Recepcion` = `l_detallerecepcion_comentario`.`Id_Recepcion`)\n\t\t\tAND (`l_detalleremision`.`Id_Procedimiento` = `l_detallerecepcion_comentario`.`Id_Procedimiento`)\n\t\tGROUP BY\n\t\t\t`l_detallerecepcion_comentario`.`Id_Recepcion`,\n\t\t\t`l_detallerecepcion_comentario`.`Id_Procedimiento`) f  \n  ON\n\t(f.`Id_Recepcion` = l_recepcion.Id)\n\tAND (f.`Id_Procedimiento` = g_procedimiento.Id)\nWHERE\n\t(DATE_FORMAT(FechaRecep, '%Y-%m-%d') >= '" + this.xmetodos.formatoAMD1.format(this.JDFechaI.getDate()) + "'\n\t\tAND DATE_FORMAT(FechaRecep, '%Y-%m-%d') <= '" + this.xmetodos.formatoAMD1.format(this.JDFechaF.getDate()) + "'\n\t\t\tAND l_recepcion.Estado = 0\n\t\t\tAND l_detallerecepcion.Id_Remision = 0\n\t\t\tAND l_remisionxprocedimientoxentidad.`IdEmpresa` = '" + this.xidempresa[this.JCBProveedor.getSelectedIndex()][0] + "' \n  )\nHAVING\n\t(EsRemitido = 1\n\t\tOR EsR = 1)\nORDER BY\n\tl_recepcion.Id ASC ; ";
            } else {
                sql = "SELECT\n\tl_recepcion.Id as idRecepcion,\n\tDATE_FORMAT(l_recepcion.FechaRecep, '%Y-%m-%d %H:%i:%s') as fechaRecepcion,\n\tconcat(gp.Id_TipoIdentificacion, ' ', gp.NoDocumento) as documento,\n\tconcat(gp.Apellido1, ' ', gp.Apellido2, ' ', gp.Nombre1, ' ', gp.Nombre2) as nombreUsuario,\n\tg_procedimiento.Id as idProcedimiento,\n\tg_procedimiento.Nbre as nombreProcedimiento,\n\tl_detallerecepcion.Id_Procedim as idProcedimientoRemision,\n\t'' razonSocialCompleta,\n\tg_procedimiento.EsRemitido,\n\tIFNULL(f.EsRemitido, 0)AS EsR,\n\tnull url,\n\t'' estadoEnvio\nFROM\n\tl_detallerecepcion\nINNER JOIN l_recepcion ON\n\t(l_detallerecepcion.Id_Recepcion = l_recepcion.Id)\nINNER JOIN g_procedimiento ON\n\t(l_detallerecepcion.Id_Procedim = g_procedimiento.Id)\nINNER JOIN l_areas ON\n\t(g_procedimiento.Id_Area = l_areas.Id)\nINNER JOIN g_persona gp ON\n\t(gp.Id = l_recepcion.Id_Paciente)\nLEFT JOIN (\n\tSELECT\n\t\t`l_detallerecepcion_comentario`.`Id_Recepcion` ,\n\t\t`l_detallerecepcion_comentario`.`Id_Procedimiento` ,\n\t\t`l_detallerecepcion_comentario`.`EsRemitido`  \n  ,\n\t\t`l_detalleremision`.`Id_Remision`\n\tFROM\n\t\t`l_detallerecepcion_comentario`\n\tLEFT JOIN `l_detalleremision` ON\n\t\t(`l_detalleremision`.`Id_Recepcion` = `l_detallerecepcion_comentario`.`Id_Recepcion`)\n\t\t\tAND (`l_detalleremision`.`Id_Procedimiento` = `l_detallerecepcion_comentario`.`Id_Procedimiento`)\n\t\tGROUP BY\n\t\t\t`l_detallerecepcion_comentario`.`Id_Recepcion`,\n\t\t\t`l_detallerecepcion_comentario`.`Id_Procedimiento`) f  \n  ON\n\t(f.`Id_Recepcion` = l_recepcion.Id)\n\tAND (f.`Id_Procedimiento` = g_procedimiento.Id)\nWHERE\n\t(DATE_FORMAT(FechaRecep, '%Y-%m-%d') >= '" + this.xmetodos.formatoAMD1.format(this.JDFechaI.getDate()) + "'\n\t\tAND DATE_FORMAT(FechaRecep, '%Y-%m-%d') <= '" + this.xmetodos.formatoAMD1.format(this.JDFechaF.getDate()) + "'\n\t\t\tAND l_recepcion.Estado = 0\n\t\t\tAND l_detallerecepcion.Id_Remision = 0\n  )\nHAVING\n\t(EsRemitido = 1\n\t\tOR EsR = 1)\nORDER BY\n\tl_recepcion.Id ASC ; ";
            }
            mCargarDatosTabla("", sql);
            this.xtipog = false;
            return;
        }
        this.xtipog = true;
        mBuscarR();
    }

    public void mNuevo() {
        this.JTFRuta.setText(this.xmetodos.getDirectorioExportacion() + "Planilla");
        this.xidempresa = this.xconsulta.llenarComboyLista("SELECT g_empresa.Id, cc_terceros.RazonSocialCompleta, g_empresa.Id_TipoIdentificacion, g_empresa.No_identificacion, g_empresa.Dig_Verificacion, g_municipio.Nbre AS NMunicipio, g_empresa.Direccion, g_empresa.Tel_Numero \nFROM g_empresa INNER JOIN g_municipio ON (g_empresa.Id_Municipio = g_municipio.Id) INNER JOIN `cc_terceros` ON (`g_empresa`.`Id` = `cc_terceros`.`Id`) \nWHERE (g_empresa.EsPlaboratorio =1  AND g_empresa.Estado =1) ORDER BY cc_terceros.RazonSocialCompleta ASC", this.xidempresa, this.JCBProveedor, 8);
        this.JCBProveedor.setSelectedIndex(-1);
        this.JDFechaI.setDate(this.xmetodos.getFechaActual());
        this.JDFechaF.setDate(this.xmetodos.getFechaActual());
        this.xconsulta.cerrarConexionBd();
        mCrearModeloDatos();
        this.xlleno = true;
        Principal.txtNo.setText("");
        this.JLB_NRecepciones.setText("");
        this.JDFechaI.requestFocus();
    }

    public void mImprimir() {
        if (!Principal.txtNo.getText().isEmpty()) {
            String[][] parametros = new String[3][2];
            parametros[0][0] = "id";
            parametros[0][1] = Principal.txtNo.getText();
            parametros[1][0] = "SUBREPORT_DIR";
            parametros[1][1] = this.xmetodos.getSO() + this.xmetodos.getBarra() + "Reportes" + this.xmetodos.getBarra();
            parametros[2][0] = "SUBREPORTFIRMA_DIR";
            parametros[2][1] = this.xmetodos.getSO() + this.xmetodos.getBarra() + "Firmas" + this.xmetodos.getBarra();
            if (Principal.informacionIps.getEsFpz().intValue() == 0) {
                this.xmetodos.GenerarPDF(this.xmetodos.getRutaRep() + "L_PlanillaRemision", parametros);
            } else {
                this.xmetodos.GenerarPDF(this.xmetodos.getRutaRep() + "L_PlanillaRemision1", parametros);
            }
            this.xconsulta.cerrarConexionBd();
        }
    }

    private boolean veriifcarCodigoHomologado() {
        boolean estado = true;
        try {
            String sql = "select GROUP_CONCAT(concat(gp.Id, '_', gp.Nbre) SEPARATOR '\\n') as nombre \nfrom \ng_procedimiento gp \nleft join g_procedimientoxcnt gp2 on (gp.Id=gp2.idprocedimiento) and gp2.estado=1\nwhere gp.Id  in  (" + Arrays.toString(this.idProcedimientoSet.toArray()).replaceAll("\\[", "").replaceAll("\\]", "") + ") and gp2.idprocedimiento is null";
            System.out.println(" " + sql);
            ResultSet xrs = this.xconsulta.traerRs(sql);
            if (xrs.next()) {
                xrs.first();
                if (xrs.getString("nombre") != null) {
                    String xmensaje = "<html><P ALIGN=center> <font face='Arial' color='red' size=4>  <b> " + xrs.getString("nombre") + ";</p><font face='Arial' color='red' size=4>Favor verificar.</html>";
                    JOptionPane.showInternalMessageDialog(this, xmensaje, "PROCEDIMIENTOS NO HOMOLOGADOS", 2, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Warning.png"))));
                    estado = false;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(JIFRemisionLab.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return estado;
    }

    public void mGrabar() {
        if (Principal.txtNo.getText().isEmpty()) {
            if (this.JCBProveedor.getSelectedIndex() != -1) {
                if (mVerificarDatosTabla()) {
                    int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    if (n == 0) {
                        String sql = "Insert into l_remision (FechaRem, Id_Empresa, Estado, Fecha, UsuarioS, idUsuarioRh) values('" + this.xmetodos.formatoAMD.format(this.xmetodos.getFechaActual()) + "','" + this.xidempresa[this.JCBProveedor.getSelectedIndex()][0] + "','0','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "','" + Principal.usuarioSistemaDTO.getIdPersonaCargo() + "')";
                        Principal.txtNo.setText(this.xconsulta.ejecutarSQLId(sql));
                        this.xconsulta.cerrarConexionBd();
                        for (int i = 0; i < this.JTDetalle.getRowCount(); i++) {
                            if (this.xmodelo.getValueAt(i, 6).toString().equals("true")) {
                                String sql2 = "insert into l_detalleremision (Id_Remision, Id_Recepcion, Id_Procedimiento)values('" + Principal.txtNo.getText() + "','" + this.JTDetalle.getValueAt(i, 0) + "','" + this.JTDetalle.getValueAt(i, 4) + "')";
                                this.xconsulta.ejecutarSQL(sql2);
                                this.xconsulta.cerrarConexionBd();
                                String sql3 = "update l_detallerecepcion set Id_Remision='" + Principal.txtNo.getText() + "' where Id_Recepcion='" + this.JTDetalle.getValueAt(i, 0) + "' and Id_Procedim='" + this.JTDetalle.getValueAt(i, 4) + "'";
                                this.xconsulta.ejecutarSQL(sql3);
                                this.xconsulta.cerrarConexionBd();
                            }
                        }
                        mCargarDatosTabla(Principal.txtNo.getText(), "");
                        return;
                    }
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "No existe exámen seleccionado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un proveedor", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBProveedor.requestFocus();
        }
    }

    private void mBuscarR() {
        this.xjdremisiones = new JDBuscarRemisiones(null, true, this);
        this.xjdremisiones.setLocationRelativeTo(this);
        this.xjdremisiones.setVisible(true);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Fecha Recepción", "Documento", "Usuario", "CUP", "Exámen", "Remitir?", "IdProcedimiento", "url", "Ver"}) { // from class: Laboratorio.JIFRemisionLab.10
            Class[] types = {Long.class, String.class, String.class, String.class, String.class, String.class, Boolean.class, Long.class, Byte.class, JButton.class};
            boolean[] canEdit = {false, false, false, false, false, false, true, false, false, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setDefaultRenderer(JButton.class, new TableCellRenderer() { // from class: Laboratorio.JIFRemisionLab.11
            public Component getTableCellRendererComponent(JTable jtable, Object objeto, boolean estaSeleccionado, boolean tieneElFoco, int fila, int columna) {
                return (Component) objeto;
            }
        });
        this.JTDetalle.setAutoResizeMode(0);
        this.JTDetalle.doLayout();
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(120);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(400);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(7).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(7).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(8).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(8).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(100);
    }

    public void mAnular() {
        if (!Principal.txtNo.getText().isEmpty()) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de anular?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                String xsql = "update l_remision set Estado=1 where Id='" + Principal.txtNo.getText() + "'";
                this.xconsulta.ejecutarSQL(xsql);
                this.xconsulta.cerrarConexionBd();
                String xsql2 = "update l_detallerecepcion set Id_Remision=0 where Id_Remision='" + Principal.txtNo.getText() + "'";
                this.xconsulta.ejecutarSQL(xsql2);
                this.xconsulta.cerrarConexionBd();
            }
        }
    }

    private boolean mVerificarDatosTabla() {
        boolean estado = false;
        if (this.JTDetalle.getRowCount() >= 0) {
            int i = 0;
            while (true) {
                if (i >= this.JTDetalle.getRowCount()) {
                    break;
                }
                if (!this.JTDetalle.getValueAt(i, 6).toString().equals("true")) {
                    i++;
                } else {
                    estado = true;
                    break;
                }
            }
        }
        return estado;
    }

    public void mCargarDatosTabla(String idRemision, String sql) {
        String xsql;
        try {
            if (idRemision.equals("")) {
                xsql = sql;
            } else {
                xsql = "with maestra as (\n\tSELECT l_recepcion.Id idRecepcion, \n\tDATE_FORMAT(l_recepcion.FechaRecep,'%Y-%m-%d %H:%i:%s')fechaRecepcion, \n\tconcat(gp.Id_TipoIdentificacion,' ',gp.NoDocumento) documento , concat(gp.Apellido1,' ', gp.Apellido2,' ', gp.Nombre1,' ', gp.Nombre2) nombreUsuario,\n\tg_procedimiento.Id as idProcedimiento,\n\tg_procedimiento.Nbre nombreProcedimiento, \n\tl_detalleremision.Id_Procedimiento as idProcedimientoRemision,\n\tif(ge.Nbre=null or ge.Nbre='',concat(ge.Apellido1,' ', ge.Apellido2,' ', ge.Nombre1,' ', ge.Nombre2) ,ge.Nbre) as razonSocialCompleta\n\t, l_remision.Id idRemision\n\t,ld.ArchivoResultadoExterno  url \n\tFROM  l_remision \n\tINNER JOIN g_empresa ge  ON (l_remision.Id_Empresa = ge.Id)\n\tINNER JOIN l_detalleremision  ON (l_detalleremision.Id_Remision = l_remision.Id)  \n\tINNER JOIN g_procedimiento  ON (l_detalleremision.Id_Procedimiento = g_procedimiento.Id) \n\tINNER JOIN l_recepcion  ON (l_detalleremision.Id_Recepcion = l_recepcion.Id) \n\tinner join l_detallerecepcion ld on (ld.Id_Recepcion=l_recepcion.Id) and (ld.Id_Procedim=l_detalleremision.Id_Procedimiento)\n\tINNER JOIN g_persona gp  ON (gp.Id  = l_recepcion.Id_Paciente) \n\tWHERE (l_remision.Id =" + idRemision + ")  ORDER BY l_recepcion.Id ASC \n),\n\nbitacora as (\n SELECT\n    JSON_UNQUOTE(JSON_EXTRACT(responseDomain , '$.idProceso')) AS idProceso,\n    lrbe.idRemision,\n    lrbe.idRecepcion, \n    COUNT(lrbe.idRecepcion) AS cantidad\n  FROM\n    l_remision_bitacora_envio lrbe \n    \n    where lrbe.idRemision=" + idRemision + "\n  GROUP BY lrbe.idRemision, lrbe.idRecepcion, JSON_UNQUOTE(JSON_EXTRACT(responseDomain , '$.idProceso'))\n  order by lrbe.fecha DESC\n\t\n),\nrowIdProceso as (\n\tSELECT\n  idProceso,\n  idRemision,\n  idRecepcion,\n  cantidad,\n  ROW_NUMBER() OVER (PARTITION BY idRecepcion ORDER BY cantidad DESC) AS row_num\n\tFROM bitacora \n\t\n)\n\n-- select * from rowIdProceso\nselect m.idRecepcion, \n\tm.fechaRecepcion, \nm.documento, \n\tm.nombreUsuario,\n\tm.idProcedimiento,\n\tm.nombreProcedimiento, \n\tm.idProcedimientoRemision,\n\tm.razonSocialCompleta, \n\tm.idRemision,\n\tm.url,\n\tif(b.cantidad is null, 'Por enviar', if(b.cantidad=1 and b.idProceso=1, 'Enviado Ok', 'Error')) estadoEnvio\nfrom maestra m\nleft join rowIdProceso b on (b.idRecepcion=m.idRecepcion) and (b.idRemision=m.idRemision) and (b.row_num=1)";
            }
            System.out.println(" " + xsql);
            mCrearModeloDatos();
            ResultSet xrs = this.xconsulta.traerRs(xsql);
            Throwable th = null;
            try {
                try {
                    if (xrs.next()) {
                        xrs.first();
                        this.JCBProveedor.setSelectedItem(xrs.getString("razonSocialCompleta"));
                        xrs.beforeFirst();
                        int n = 0;
                        this.xmetodos.mEstablecerTextEditor(this.JTDetalle, 2);
                        this.xmetodos.mEstablecerTextEditor(this.JTDetalle, 3);
                        Set<Long> numerosSet = new HashSet<>();
                        this.idProcedimientoSet = new HashSet();
                        while (xrs.next()) {
                            this.xmodelo.addRow(this.xdatos);
                            numerosSet.add(Long.valueOf(xrs.getLong("idRecepcion")));
                            this.idProcedimientoSet.add(Long.valueOf(xrs.getLong("idProcedimiento")));
                            this.xmodelo.setValueAt(Long.valueOf(xrs.getLong("idRecepcion")), n, 0);
                            this.xmodelo.setValueAt(xrs.getString("fechaRecepcion"), n, 1);
                            this.xmodelo.setValueAt(xrs.getString("documento"), n, 2);
                            this.xmodelo.setValueAt(xrs.getString("nombreUsuario"), n, 3);
                            this.xmodelo.setValueAt(xrs.getString("idProcedimiento"), n, 4);
                            this.xmodelo.setValueAt(xrs.getString("nombreProcedimiento"), n, 5);
                            this.xmodelo.setValueAt(Long.valueOf(xrs.getLong("idProcedimientoRemision")), n, 7);
                            this.xmodelo.setValueAt(xrs.getBytes("url"), n, 8);
                            JButton button = new JButton(xrs.getString("estadoEnvio"));
                            if (xrs.getString("estadoEnvio").equals("Error")) {
                                button.setForeground(Color.RED);
                            } else if (xrs.getString("estadoEnvio").equals("Error")) {
                                button.setForeground(Color.GREEN);
                            } else {
                                button.setForeground(Color.BLACK);
                            }
                            this.xmodelo.setValueAt(button, n, 9);
                            this.xmodelo.setValueAt(true, n, 6);
                            if (this.xtipog) {
                                this.JCBProveedor.setSelectedItem(xrs.getString("razonSocialCompleta"));
                                Principal.txtNo.setText(xrs.getString("idRemision"));
                            }
                            this.JTDetalle.setDefaultRenderer(Object.class, new MiRender());
                            n++;
                        }
                        this.JLB_NRecepciones.setText("" + numerosSet.size());
                    }
                    if (xrs != null) {
                        if (0 != 0) {
                            try {
                                xrs.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                        } else {
                            xrs.close();
                        }
                    }
                    this.xconsulta.cerrarConexionBd();
                } finally {
                }
            } catch (Throwable th3) {
                th = th3;
                throw th3;
            }
        } catch (SQLException ex) {
            Logger.getLogger(JIFRemisionLab.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX INFO: loaded from: GenomaP.jar:Laboratorio/JIFRemisionLab$MiRender.class */
    public static class MiRender extends DefaultTableCellRenderer {
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (table.getValueAt(row, 8) != null) {
                cell.setBackground(Color.GREEN);
                cell.setForeground(Color.BLACK);
            } else {
                cell.setBackground(Color.white);
                cell.setForeground(Color.BLACK);
            }
            return cell;
        }
    }

    public void mAbrirArchivo() {
        try {
            Runtime.getRuntime().exec("C:\\Archivos de Programa\\Windows NT\\Accesorios\\wordpad.exe c:\\Genoma\\Reportes\\RTF_Salida.rtf");
        } catch (IOException ex) {
            Logger.getLogger(RecepcionAuto.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }
}
