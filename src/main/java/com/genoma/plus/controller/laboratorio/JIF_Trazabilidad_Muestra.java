package com.genoma.plus.controller.laboratorio;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import Utilidades.MetodosGenericos;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.genoma.plus.controller.laboratorio.dto.InfoRecepcion;
import com.genoma.plus.controller.laboratorio.dto.TrackingDomain;
import com.genoma.plus.controller.laboratorio.enums.EstadoMuestra;
import com.genoma.plus.domains.models.domains.general.RecursosMicroserviciosDomain;
import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/laboratorio/JIF_Trazabilidad_Muestra.class */
public class JIF_Trazabilidad_Muestra extends JInternalFrame {
    private String[] xidarea;
    private Metodos metodos;
    private DefaultTableModel modelo;
    private Object[] datos;
    private List<TrackingDomain> trackingDomains;
    private JButton JBT_Adicionar;
    private JComboBox JCBArea;
    private JComboBox JCB_Estado;
    private JLabel JLB_InfoUsuario;
    private JLabel JLB_NumeroMuestra;
    private JEditorPane JPE_InformacionMuestra;
    private JEditorPane JPE_Observacion;
    private JPanel JPI_Consulta;
    private JPanel JPI_Registro;
    private JScrollPane JSP_Detalle;
    private JScrollPane JSP_InformacionMuestra;
    private JScrollPane JSP_Observacion;
    public JTable JTB_Detalle;
    private JTextField JTFIdRecepcion;
    private JTextField JTFIdRecepcionC;
    private JTabbedPane JTP_Datos;
    private JCheckBox Jch_Registra;
    private ConsultasMySQL xct = new ConsultasMySQL();
    private MetodosGenericos<Long> metodosGenericos = new MetodosGenericos<>();

    public JIF_Trazabilidad_Muestra() {
        initComponents();
        this.metodos = new Metodos();
        creaModeloTabla();
        nuevo();
    }

    /* JADX WARN: Type inference failed for: r3v66, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JTP_Datos = new JTabbedPane();
        this.JPI_Registro = new JPanel();
        this.JTFIdRecepcion = new JTextField();
        this.JCBArea = new JComboBox();
        this.JSP_Observacion = new JScrollPane();
        this.JPE_Observacion = new JEditorPane();
        this.JCB_Estado = new JComboBox();
        this.JLB_InfoUsuario = new JLabel();
        this.JBT_Adicionar = new JButton();
        this.Jch_Registra = new JCheckBox();
        this.JPI_Consulta = new JPanel();
        this.JTFIdRecepcionC = new JTextField();
        this.JSP_InformacionMuestra = new JScrollPane();
        this.JPE_InformacionMuestra = new JEditorPane();
        this.JSP_Detalle = new JScrollPane();
        this.JTB_Detalle = new JTable();
        this.JLB_NumeroMuestra = new JLabel();
        setClosable(true);
        setIconifiable(true);
        setTitle("TRACKING");
        setToolTipText("");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifTracking");
        this.JTP_Datos.setForeground(new Color(0, 103, 0));
        this.JTP_Datos.setFont(new Font("Arial", 1, 14));
        this.JTFIdRecepcion.setFont(new Font("Arial", 1, 12));
        this.JTFIdRecepcion.setHorizontalAlignment(0);
        this.JTFIdRecepcion.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(184, 207, 229)), "No. Recepción", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFIdRecepcion.addFocusListener(new FocusAdapter() { // from class: com.genoma.plus.controller.laboratorio.JIF_Trazabilidad_Muestra.1
            public void focusLost(FocusEvent evt) {
                JIF_Trazabilidad_Muestra.this.JTFIdRecepcionFocusLost(evt);
            }
        });
        this.JTFIdRecepcion.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.laboratorio.JIF_Trazabilidad_Muestra.2
            public void actionPerformed(ActionEvent evt) {
                JIF_Trazabilidad_Muestra.this.JTFIdRecepcionActionPerformed(evt);
            }
        });
        this.JCBArea.setFont(new Font("Arial", 1, 12));
        this.JCBArea.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(184, 207, 229)), "Area", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JPE_Observacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Observaciones", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JPE_Observacion.setFont(new Font("Arial", 1, 12));
        this.JPE_Observacion.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.laboratorio.JIF_Trazabilidad_Muestra.3
            public void keyPressed(KeyEvent evt) {
                JIF_Trazabilidad_Muestra.this.JPE_ObservacionKeyPressed(evt);
            }
        });
        this.JSP_Observacion.setViewportView(this.JPE_Observacion);
        this.JCB_Estado.setFont(new Font("Arial", 1, 12));
        this.JCB_Estado.setModel(new DefaultComboBoxModel(new String[]{"DESCARTADA", "PENDIENTE_RECEPCION", "RECEPCIONADA", "RECIBIDA", "EN_PROCESO", "EN_TRANSPORTE", "EN_SEROTECA", "RESULTADO_DISPONIBLE", "RECHAZADA"}));
        this.JCB_Estado.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(184, 207, 229)), "Estado seguimiento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JLB_InfoUsuario.setFont(new Font("Arial", 1, 12));
        this.JLB_InfoUsuario.setForeground(Color.red);
        this.JLB_InfoUsuario.setBorder(BorderFactory.createTitledBorder((Border) null, "Información usuario", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBT_Adicionar.setFont(new Font("Arial", 1, 12));
        this.JBT_Adicionar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBT_Adicionar.setText("Adicionar");
        this.JBT_Adicionar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.laboratorio.JIF_Trazabilidad_Muestra.4
            public void actionPerformed(ActionEvent evt) {
                JIF_Trazabilidad_Muestra.this.JBT_AdicionarActionPerformed(evt);
            }
        });
        this.JBT_Adicionar.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.laboratorio.JIF_Trazabilidad_Muestra.5
            public void keyPressed(KeyEvent evt) {
                JIF_Trazabilidad_Muestra.this.JBT_AdicionarKeyPressed(evt);
            }
        });
        this.Jch_Registra.setFont(new Font("Arial", 1, 12));
        this.Jch_Registra.setText("Registra");
        GroupLayout JPI_RegistroLayout = new GroupLayout(this.JPI_Registro);
        this.JPI_Registro.setLayout(JPI_RegistroLayout);
        JPI_RegistroLayout.setHorizontalGroup(JPI_RegistroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_RegistroLayout.createSequentialGroup().addContainerGap().addGroup(JPI_RegistroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_RegistroLayout.createSequentialGroup().addComponent(this.Jch_Registra).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSP_Observacion, -2, 603, -2).addGap(18, 18, 18).addComponent(this.JBT_Adicionar, -1, -1, 32767)).addGroup(JPI_RegistroLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addGroup(JPI_RegistroLayout.createSequentialGroup().addComponent(this.JTFIdRecepcion, -2, 147, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JLB_InfoUsuario, -1, -1, 32767)).addGroup(GroupLayout.Alignment.LEADING, JPI_RegistroLayout.createSequentialGroup().addComponent(this.JCBArea, -2, 538, -2).addGap(18, 18, 18).addComponent(this.JCB_Estado, -2, 299, -2)))).addGap(126, 126, 126)));
        JPI_RegistroLayout.setVerticalGroup(JPI_RegistroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPI_RegistroLayout.createSequentialGroup().addGap(14, 14, 14).addGroup(JPI_RegistroLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBArea, -2, 50, -2).addComponent(this.JCB_Estado, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPI_RegistroLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTFIdRecepcion).addComponent(this.JLB_InfoUsuario, -2, 50, -2)).addGap(24, 24, 24).addGroup(JPI_RegistroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_RegistroLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JSP_Observacion).addComponent(this.JBT_Adicionar, -2, 64, -2)).addComponent(this.Jch_Registra)).addContainerGap(17, 32767)));
        this.JTP_Datos.addTab("REGISTRO", this.JPI_Registro);
        this.JTFIdRecepcionC.setFont(new Font("Arial", 1, 12));
        this.JTFIdRecepcionC.setHorizontalAlignment(0);
        this.JTFIdRecepcionC.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(184, 207, 229)), "No. Recepción", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFIdRecepcionC.addFocusListener(new FocusAdapter() { // from class: com.genoma.plus.controller.laboratorio.JIF_Trazabilidad_Muestra.6
            public void focusLost(FocusEvent evt) {
                JIF_Trazabilidad_Muestra.this.JTFIdRecepcionCFocusLost(evt);
            }
        });
        this.JTFIdRecepcionC.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.laboratorio.JIF_Trazabilidad_Muestra.7
            public void actionPerformed(ActionEvent evt) {
                JIF_Trazabilidad_Muestra.this.JTFIdRecepcionCActionPerformed(evt);
            }
        });
        this.JPE_InformacionMuestra.setBorder(BorderFactory.createTitledBorder((Border) null, "Información de Recepción", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JPE_InformacionMuestra.setFont(new Font("Arial", 1, 12));
        this.JPE_InformacionMuestra.setForeground(Color.red);
        this.JPE_InformacionMuestra.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.laboratorio.JIF_Trazabilidad_Muestra.8
            public void keyPressed(KeyEvent evt) {
                JIF_Trazabilidad_Muestra.this.JPE_InformacionMuestraKeyPressed(evt);
            }
        });
        this.JSP_InformacionMuestra.setViewportView(this.JPE_InformacionMuestra);
        GroupLayout JPI_ConsultaLayout = new GroupLayout(this.JPI_Consulta);
        this.JPI_Consulta.setLayout(JPI_ConsultaLayout);
        JPI_ConsultaLayout.setHorizontalGroup(JPI_ConsultaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_ConsultaLayout.createSequentialGroup().addContainerGap().addComponent(this.JTFIdRecepcionC, -2, 147, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSP_InformacionMuestra, -2, 743, -2).addContainerGap(-1, 32767)));
        JPI_ConsultaLayout.setVerticalGroup(JPI_ConsultaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_ConsultaLayout.createSequentialGroup().addGap(17, 17, 17).addGroup(JPI_ConsultaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_ConsultaLayout.createSequentialGroup().addComponent(this.JSP_InformacionMuestra).addContainerGap()).addGroup(JPI_ConsultaLayout.createSequentialGroup().addComponent(this.JTFIdRecepcionC, -1, 63, 32767).addGap(151, 151, 151)))));
        this.JTP_Datos.addTab("CONSULTA", this.JPI_Consulta);
        this.JSP_Detalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.JTB_Detalle.setFont(new Font("Arial", 1, 12));
        this.JTB_Detalle.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTB_Detalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTB_Detalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTB_Detalle.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.laboratorio.JIF_Trazabilidad_Muestra.9
            public void keyPressed(KeyEvent evt) {
                JIF_Trazabilidad_Muestra.this.JTB_DetalleKeyPressed(evt);
            }
        });
        this.JSP_Detalle.setViewportView(this.JTB_Detalle);
        this.JLB_NumeroMuestra.setFont(new Font("Arial", 1, 12));
        this.JLB_NumeroMuestra.setForeground(Color.red);
        this.JLB_NumeroMuestra.setHorizontalAlignment(0);
        this.JLB_NumeroMuestra.setBorder(BorderFactory.createTitledBorder((Border) null, "No. Muestras", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSP_Detalle, GroupLayout.Alignment.TRAILING, -1, 968, 32767).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.JLB_NumeroMuestra, -2, 150, -2)).addGroup(layout.createSequentialGroup().addComponent(this.JTP_Datos, -2, 957, -2).addGap(0, 0, 32767))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(15, 15, 15).addComponent(this.JTP_Datos, -2, 262, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSP_Detalle, -1, 260, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JLB_NumeroMuestra, -2, 50, -2).addGap(17, 17, 17)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFIdRecepcionActionPerformed(ActionEvent evt) {
        this.JTFIdRecepcion.transferFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFIdRecepcionFocusLost(FocusEvent evt) {
        cargarDatosRecepcion();
        if (!this.Jch_Registra.isSelected()) {
            this.JBT_Adicionar.requestFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_AdicionarActionPerformed(ActionEvent evt) {
        adicionar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTB_DetalleKeyPressed(KeyEvent evt) {
        int selectedRow = this.JTB_Detalle.getSelectedRow();
        if (selectedRow != -1 && evt.getKeyCode() == 127) {
            this.JTB_Detalle.getModel().removeRow(selectedRow);
            this.trackingDomains.remove(selectedRow);
            getNumeroFila();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JPE_ObservacionKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 9) {
            this.JPE_Observacion.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_AdicionarKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            adicionar();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFIdRecepcionCFocusLost(FocusEvent evt) {
        cargarDatosRecepcionConsulta();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFIdRecepcionCActionPerformed(ActionEvent evt) {
        this.JTFIdRecepcionC.transferFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JPE_InformacionMuestraKeyPressed(KeyEvent evt) {
    }

    public void nuevo() {
        this.JCBArea.removeAllItems();
        this.xidarea = this.xct.llenarCombo("SELECT l_areas.Id, l_areas.Nbre FROM l_areas WHERE (l_areas.Estado =0)  ORDER BY l_areas.Nbre ASC", this.xidarea, this.JCBArea);
        limpiarCompleto();
        this.trackingDomains = new ArrayList();
    }

    private void adicionar() {
        if (!validarCampos()) {
            return;
        }
        agregarFilaATabla();
        registrarTracking();
        limpiar();
    }

    private boolean validarCampos() {
        System.out.println("" + this.JLB_InfoUsuario.getText());
        if (this.JLB_InfoUsuario == null || this.JLB_InfoUsuario.getText() == null || this.JLB_InfoUsuario.getText().isEmpty()) {
            mostrarMensajeError("No existe información de recepción para registrar");
            return false;
        }
        if (this.JCBArea.getSelectedIndex() == -1) {
            mostrarMensajeError("Debe seleccionar el área");
            this.JCBArea.requestFocus();
            return false;
        }
        if (this.JCB_Estado.getSelectedIndex() == -1) {
            mostrarMensajeError("Debe seleccionar el estado");
            this.JCB_Estado.requestFocus();
            return false;
        }
        return true;
    }

    private boolean validarCamposGrabar() {
        if (this.JTB_Detalle.getRowCount() == 0) {
            mostrarMensajeError("No existe información de recepción para registrar");
            return false;
        }
        return true;
    }

    private void agregarFilaATabla() {
        this.modelo.addRow(this.datos);
        int lastRow = this.JTB_Detalle.getRowCount() - 1;
        this.JTB_Detalle.setValueAt(this.JTFIdRecepcion.getText(), lastRow, 1);
        this.JTB_Detalle.setValueAt(this.metodos.getFechaActualLocalTime().format(this.metodos.formatter), lastRow, 2);
        this.JTB_Detalle.setValueAt(this.JLB_InfoUsuario.getText(), lastRow, 3);
        this.JTB_Detalle.setValueAt(this.JCBArea.getSelectedItem(), lastRow, 4);
        this.JTB_Detalle.setValueAt(this.JCB_Estado.getSelectedItem(), lastRow, 5);
        this.JTB_Detalle.setValueAt(Principal.usuarioSistemaDTO.getNombreUsuario(), lastRow, 6);
        this.JTB_Detalle.setValueAt(Principal.usuarioSistemaDTO.getNombreCargoUsuario(), lastRow, 7);
        this.JTB_Detalle.setValueAt(this.JPE_Observacion.getText(), lastRow, 8);
        getNumeroFila();
    }

    private void registrarTracking() {
        TrackingDomain domain = TrackingDomain.builder().area(this.JCBArea.getSelectedItem().toString()).cargo(Principal.usuarioSistemaDTO.getNombreCargoUsuario()).estado(true).estadoMAnEnum(obtenerEstadoDesdeString(this.JCB_Estado.getSelectedItem().toString())).fechaHoraRegistro(this.metodos.getFechaActualLocalTime()).idRecepcion(Long.valueOf(this.JTFIdRecepcion.getText())).usuario(Principal.usuarioSistemaDTO.getNombreUsuario()).observacion(this.JPE_Observacion.getText()).build();
        this.trackingDomains.add(domain);
    }

    private void limpiar() {
        this.JLB_InfoUsuario.setText("");
        this.JPE_Observacion.setText("");
        this.JTFIdRecepcion.setText("");
        this.JTFIdRecepcion.requestFocus();
    }

    private void limpiarCompleto() {
        this.JCBArea.setSelectedIndex(-1);
        this.JCB_Estado.setSelectedIndex(-1);
        this.JLB_NumeroMuestra.setText("");
        this.JLB_InfoUsuario.setText("");
        this.JTFIdRecepcionC.setText("");
        limpiar();
        creaModeloTabla();
        this.JCBArea.requestFocus();
    }

    private EstadoMuestra obtenerEstadoDesdeString(String estado) {
        try {
            return EstadoMuestra.valueOf(estado.toUpperCase().replace(" ", "_"));
        } catch (IllegalArgumentException | NullPointerException e) {
            return EstadoMuestra.PENDIENTE_RECEPCION;
        }
    }

    private void mostrarMensajeError(String mensaje) {
        JOptionPane.showInternalMessageDialog(this, mensaje, "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    private void cargarDatosRecepcion() {
        InfoRecepcion infoRecepcion;
        if (!this.JTFIdRecepcion.getText().isEmpty() && (infoRecepcion = this.metodos.getInfoRecepcionId(Long.valueOf(this.JTFIdRecepcion.getText()))) != null) {
            this.JLB_InfoUsuario.setText(infoRecepcion.getNombreUsuario());
        }
    }

    private void cargarDatosRecepcionConsulta() {
        try {
            String idRecepcionCText = this.JTFIdRecepcionC.getText().trim();
            if (idRecepcionCText.isEmpty()) {
                return;
            }
            Long idRecepcionC = Long.valueOf(idRecepcionCText);
            InfoRecepcion infoRecepcion = this.metodos.getInfoRecepcionId(idRecepcionC);
            if (infoRecepcion.getFechaRecepcion() != null) {
                this.JPE_InformacionMuestra.setText(String.format("%s\n\n%s\n\n%s", "Fecha Recepción: " + infoRecepcion.getFechaRecepcion().format(this.metodos.formatter), "Usuario: " + infoRecepcion.getNombreUsuario(), "Sede: " + infoRecepcion.getSede()));
                List<TrackingDomain> list = this.metodos.getListInfoTrackingIdRecepcion(idRecepcionC);
                System.out.println("tamano : " + list.size());
                if (!list.isEmpty()) {
                    creaModeloTabla();
                    for (TrackingDomain e : list) {
                        Object[] datos = {null, e.getIdRecepcion(), e.getFechaHoraRegistro().format(this.metodos.formatter), infoRecepcion.getNombreUsuario(), e.getArea(), e.getEstadoMAnEnum(), e.getUsuario(), e.getCargo(), e.getObservacion()};
                        this.modelo.addRow(datos);
                    }
                }
                return;
            }
            Logger.getLogger(getClass().getName()).log(Level.WARNING, "InfoRecepcion sin datos válidos.");
        } catch (NumberFormatException ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "Error al convertir ID de recepción", (Throwable) ex);
        } catch (Exception ex2) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "Error inesperado en cargarDatosRecepcionConsulta", (Throwable) ex2);
        }
    }

    private void getNumeroFila() {
        this.JLB_NumeroMuestra.setText("" + (this.JTB_Detalle.getRowCount() + 1));
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void creaModeloTabla() {
        this.modelo = new DefaultTableModel(new Object[0], new String[]{"id", "No. Rcepción", "Fecha y hora ", "Usuario", "Area", "Estado", "Usuario Registro", "Cargo", "Observación"}) { // from class: com.genoma.plus.controller.laboratorio.JIF_Trazabilidad_Muestra.10
            Class[] types = {Long.class, Long.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTB_Detalle.setAutoResizeMode(0);
        this.JTB_Detalle.doLayout();
        this.JTB_Detalle.setModel(this.modelo);
        this.JTB_Detalle.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTB_Detalle.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTB_Detalle.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTB_Detalle.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTB_Detalle.getColumnModel().getColumn(2).setPreferredWidth(150);
        this.JTB_Detalle.getColumnModel().getColumn(3).setPreferredWidth(400);
        this.JTB_Detalle.getColumnModel().getColumn(4).setPreferredWidth(300);
        this.JTB_Detalle.getColumnModel().getColumn(5).setPreferredWidth(200);
        this.JTB_Detalle.getColumnModel().getColumn(6).setPreferredWidth(200);
        this.JTB_Detalle.getColumnModel().getColumn(7).setPreferredWidth(300);
        this.JTB_Detalle.getColumnModel().getColumn(8).setPreferredWidth(400);
    }

    public void grabar() {
        try {
            try {
                if (!validarCamposGrabar()) {
                    JOptionPane.showMessageDialog(this, "Debe completar los campos obligatorios.", "Advertencia", 2);
                    return;
                }
                int opcion = JOptionPane.showConfirmDialog(this, "¿Está seguro de grabar?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (opcion != 0) {
                    return;
                }
                RecursosMicroserviciosDomain microserviciosDomain = (RecursosMicroserviciosDomain) Optional.ofNullable(this.metodos.getParametrosEncriptados("24", "saveListTraking")).orElseThrow(() -> {
                    return new IllegalStateException("No se pudo obtener la configuración del microservicio");
                });
                Response response = this.metodos.getResteasyClient().target(microserviciosDomain.getUrlRecurso()).request(new String[]{"application/json"}).post(Entity.entity(this.metodos.getMapper().writeValueAsString(this.trackingDomains), "application/json"));
                int statusCode = response.getStatus();
                if (statusCode == 200) {
                    limpiarCompleto();
                    JOptionPane.showMessageDialog(this, "Registro guardado exitosamente.", "Éxito", 1);
                } else {
                    JOptionPane.showMessageDialog(this, "Error al guardar: Código " + statusCode, "Error", 0);
                }
            } catch (IllegalStateException ex) {
                Logger.getLogger(JIF_Trazabilidad_Muestra.class.getName()).log(Level.SEVERE, "Error en configuración", (Throwable) ex);
                JOptionPane.showMessageDialog(this, "Error en la configuración del servicio.", "Error", 0);
            } catch (JsonProcessingException e) {
                Logger.getLogger(JIF_Trazabilidad_Muestra.class.getName()).log(Level.SEVERE, "Error al serializar JSON", e);
                JOptionPane.showMessageDialog(this, "Error al procesar los datos.", "Error", 0);
            }
        } catch (HeadlessException | IllegalArgumentException | NullPointerException ex2) {
            Logger.getLogger(JIF_Trazabilidad_Muestra.class.getName()).log(Level.SEVERE, "Error inesperado", (Throwable) ex2);
            JOptionPane.showMessageDialog(this, "Ocurrió un error inesperado.", "Error", 0);
        }
    }
}
