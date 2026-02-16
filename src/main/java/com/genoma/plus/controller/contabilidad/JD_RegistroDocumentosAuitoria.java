package com.genoma.plus.controller.contabilidad;

import Acceso.Principal;
import Utilidades.Metodos;
import com.genoma.plus.jpa.entities.RadicacionDetalleAuditoriaDTO;
import com.genoma.plus.jpa.service.IRadicacionDetalleAuditoriaDAO;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;
import lombok.Generated;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/contabilidad/JD_RegistroDocumentosAuitoria.class */
public class JD_RegistroDocumentosAuitoria extends JDialog {
    private Long idAdutoria;
    private RadicacionDetalleAuditoriaDTO documentoDetalleAuditoriaDTO;
    private final IRadicacionDetalleAuditoriaDAO documentoDetalleAuditoriaDAO;
    private File pdfSoporte;
    private final Metodos metodos;
    private JButton BTGrabar;
    private JButton BTSalir;
    private JDateChooser JDC_Fecha;
    private JLabel JLB_IdAuditoria;
    private JPanel JPI_Detalle;
    private JScrollPane JSPObservacion;
    private JFormattedTextField JTFF_ValorGlosado;
    private JTextField JTFRuta;
    private JTextPane JTP_Observacion;

    @Generated
    public void setIdAdutoria(Long idAdutoria) {
        this.idAdutoria = idAdutoria;
    }

    @Generated
    public void setDocumentoDetalleAuditoriaDTO(RadicacionDetalleAuditoriaDTO documentoDetalleAuditoriaDTO) {
        this.documentoDetalleAuditoriaDTO = documentoDetalleAuditoriaDTO;
    }

    @Generated
    public void setPdfSoporte(File pdfSoporte) {
        this.pdfSoporte = pdfSoporte;
    }

    @Generated
    public void setBTGrabar(JButton BTGrabar) {
        this.BTGrabar = BTGrabar;
    }

    @Generated
    public void setBTSalir(JButton BTSalir) {
        this.BTSalir = BTSalir;
    }

    @Generated
    public void setJDC_Fecha(JDateChooser JDC_Fecha) {
        this.JDC_Fecha = JDC_Fecha;
    }

    @Generated
    public void setJLB_IdAuditoria(JLabel JLB_IdAuditoria) {
        this.JLB_IdAuditoria = JLB_IdAuditoria;
    }

    @Generated
    public void setJPI_Detalle(JPanel JPI_Detalle) {
        this.JPI_Detalle = JPI_Detalle;
    }

    @Generated
    public void setJSPObservacion(JScrollPane JSPObservacion) {
        this.JSPObservacion = JSPObservacion;
    }

    @Generated
    public void setJTFF_ValorGlosado(JFormattedTextField JTFF_ValorGlosado) {
        this.JTFF_ValorGlosado = JTFF_ValorGlosado;
    }

    @Generated
    public void setJTFRuta(JTextField JTFRuta) {
        this.JTFRuta = JTFRuta;
    }

    @Generated
    public void setJTP_Observacion(JTextPane JTP_Observacion) {
        this.JTP_Observacion = JTP_Observacion;
    }

    @Generated
    public Long getIdAdutoria() {
        return this.idAdutoria;
    }

    @Generated
    public RadicacionDetalleAuditoriaDTO getDocumentoDetalleAuditoriaDTO() {
        return this.documentoDetalleAuditoriaDTO;
    }

    @Generated
    public IRadicacionDetalleAuditoriaDAO getDocumentoDetalleAuditoriaDAO() {
        return this.documentoDetalleAuditoriaDAO;
    }

    @Generated
    public File getPdfSoporte() {
        return this.pdfSoporte;
    }

    @Generated
    public Metodos getMetodos() {
        return this.metodos;
    }

    public JD_RegistroDocumentosAuitoria(Frame parent, boolean modal, Long idAdutoria) {
        super(parent, modal);
        this.documentoDetalleAuditoriaDAO = (IRadicacionDetalleAuditoriaDAO) Principal.contexto.getBean(IRadicacionDetalleAuditoriaDAO.class);
        this.metodos = new Metodos();
        initComponents();
        setIdAdutoria(idAdutoria);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        buscar();
    }

    private void initComponents() {
        this.JPI_Detalle = new JPanel();
        this.JDC_Fecha = new JDateChooser();
        this.JSPObservacion = new JScrollPane();
        this.JTP_Observacion = new JTextPane();
        this.JTFRuta = new JTextField();
        this.JLB_IdAuditoria = new JLabel();
        this.JTFF_ValorGlosado = new JFormattedTextField();
        this.BTGrabar = new JButton();
        this.BTSalir = new JButton();
        setDefaultCloseOperation(2);
        setTitle("REGISTRO ADUITORÍA");
        this.JPI_Detalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JDC_Fecha.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDC_Fecha.setDateFormatString("dd/MM/yyyy");
        this.JDC_Fecha.setFont(new Font("Arial", 1, 12));
        this.JDC_Fecha.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.contabilidad.JD_RegistroDocumentosAuitoria.1
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JD_RegistroDocumentosAuitoria.this.JDC_FechaPropertyChange(evt);
            }
        });
        this.JSPObservacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 2, 0, new Font("Arial", 1, 12), new Color(0, 103, 0)));
        this.JTP_Observacion.setFont(new Font("Arial", 1, 12));
        this.JTP_Observacion.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.contabilidad.JD_RegistroDocumentosAuitoria.2
            public void keyPressed(KeyEvent evt) {
                JD_RegistroDocumentosAuitoria.this.JTP_ObservacionKeyPressed(evt);
            }
        });
        this.JSPObservacion.setViewportView(this.JTP_Observacion);
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ruta", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.contabilidad.JD_RegistroDocumentosAuitoria.3
            public void mouseClicked(MouseEvent evt) {
                JD_RegistroDocumentosAuitoria.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JLB_IdAuditoria.setFont(new Font("Arial", 1, 12));
        this.JLB_IdAuditoria.setBorder(BorderFactory.createTitledBorder((Border) null, "Id", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JTFF_ValorGlosado.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor Glosado", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFF_ValorGlosado.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFF_ValorGlosado.setHorizontalAlignment(4);
        this.JTFF_ValorGlosado.setFont(new Font("Arial", 1, 12));
        GroupLayout JPI_DetalleLayout = new GroupLayout(this.JPI_Detalle);
        this.JPI_Detalle.setLayout(JPI_DetalleLayout);
        JPI_DetalleLayout.setHorizontalGroup(JPI_DetalleLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DetalleLayout.createSequentialGroup().addContainerGap().addGroup(JPI_DetalleLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPObservacion).addGroup(JPI_DetalleLayout.createSequentialGroup().addComponent(this.JTFRuta, -2, 436, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 41, 32767).addComponent(this.JTFF_ValorGlosado, -2, 159, -2)).addGroup(JPI_DetalleLayout.createSequentialGroup().addComponent(this.JDC_Fecha, -2, 125, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JLB_IdAuditoria, -2, 138, -2))).addContainerGap()));
        JPI_DetalleLayout.setVerticalGroup(JPI_DetalleLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DetalleLayout.createSequentialGroup().addContainerGap().addGroup(JPI_DetalleLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DetalleLayout.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.JLB_IdAuditoria, -2, 50, -2)).addComponent(this.JDC_Fecha, -1, -1, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPObservacion, -2, 121, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPI_DetalleLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFRuta, -2, 50, -2).addComponent(this.JTFF_ValorGlosado, -2, 50, -2)).addContainerGap()));
        this.BTGrabar.setFont(new Font("Arial", 1, 12));
        this.BTGrabar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.BTGrabar.setText("Grabar");
        this.BTGrabar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.contabilidad.JD_RegistroDocumentosAuitoria.4
            public void actionPerformed(ActionEvent evt) {
                JD_RegistroDocumentosAuitoria.this.BTGrabarActionPerformed(evt);
            }
        });
        this.BTSalir.setFont(new Font("Arial", 1, 12));
        this.BTSalir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.BTSalir.setText("Cerrar");
        this.BTSalir.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.contabilidad.JD_RegistroDocumentosAuitoria.5
            public void actionPerformed(ActionEvent evt) {
                JD_RegistroDocumentosAuitoria.this.BTSalirActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(14, 14, 14).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(layout.createSequentialGroup().addComponent(this.BTGrabar, -2, 180, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.BTSalir, -2, 180, -2)).addComponent(this.JPI_Detalle, -2, -1, -2)).addContainerGap(-1, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPI_Detalle, -2, -1, -2).addGap(18, 18, 18).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.BTSalir, -2, 50, -2).addComponent(this.BTGrabar, -2, 50, -2)).addContainerGap(-1, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDC_FechaPropertyChange(PropertyChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTP_ObservacionKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 9) {
            this.JTP_Observacion.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaMouseClicked(MouseEvent evt) {
        JFileChooser fileChooser = new JFileChooser(this.JTFRuta.getText());
        fileChooser.setFileFilter(new FileNameExtensionFilter("PDF", new String[]{"pdf"}));
        if (fileChooser.showSaveDialog(this) == 0) {
            File file = fileChooser.getSelectedFile();
            setPdfSoporte(file);
            if (getPdfSoporte() != null) {
                this.JTFRuta.setText(this.pdfSoporte.getAbsolutePath());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BTGrabarActionPerformed(ActionEvent evt) {
        grabar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BTSalirActionPerformed(ActionEvent evt) {
        dispose();
    }

    private void nuevo() {
        this.JDC_Fecha.setDate(getMetodos().getFechaActual());
        this.JTFRuta.setText(this.metodos.getDirectorioExportacion());
        this.JTFF_ValorGlosado.setValue(new Double(0.0d));
        this.JTP_Observacion.setText("");
    }

    private void buscar() {
        setDocumentoDetalleAuditoriaDTO(getDocumentoDetalleAuditoriaDAO().documentoDetalleAuditoriaPorId(getIdAdutoria()));
        if (getDocumentoDetalleAuditoriaDTO().getFechaAuditoria() != null) {
            this.JDC_Fecha.setDate(getDocumentoDetalleAuditoriaDTO().getFechaAuditoria());
            this.JTP_Observacion.setText(getDocumentoDetalleAuditoriaDTO().getDetalleAuditoria());
            this.JTFF_ValorGlosado.setValue(getDocumentoDetalleAuditoriaDTO().getValorGlosado());
            return;
        }
        nuevo();
    }

    private void grabar() {
        if (!this.JTP_Observacion.getText().isEmpty()) {
            if (getPdfSoporte() != null) {
                try {
                    getDocumentoDetalleAuditoriaDTO().setFechaAuditoria(this.JDC_Fecha.getDate());
                    getDocumentoDetalleAuditoriaDTO().setDetalleAuditoria(this.JTP_Observacion.getText());
                    getDocumentoDetalleAuditoriaDTO().setValorGlosado(Double.valueOf(this.JTFF_ValorGlosado.getText().replace(".", "")));
                    getDocumentoDetalleAuditoriaDTO().setSoporte(Files.readAllBytes(getPdfSoporte().toPath()));
                    getDocumentoDetalleAuditoriaDAO().grabar(getDocumentoDetalleAuditoriaDTO());
                    dispose();
                    Principal.clasegeneral.getAuditoriaFacturasContables().cargarAuditores();
                    return;
                } catch (IOException ex) {
                    Logger.getLogger(JD_RegistroDocumentosAuitoria.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                    return;
                }
            }
            JOptionPane.showMessageDialog(this, "Debe seleccionar archivo a cargar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTFRuta.requestFocus();
            return;
        }
        JOptionPane.showMessageDialog(this, "Observacion no puede estar en blanco", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JTP_Observacion.requestFocus();
    }

    @Generated
    public JButton getBTGrabar() {
        return this.BTGrabar;
    }

    @Generated
    public JButton getBTSalir() {
        return this.BTSalir;
    }

    @Generated
    public JDateChooser getJDC_Fecha() {
        return this.JDC_Fecha;
    }

    @Generated
    public JLabel getJLB_IdAuditoria() {
        return this.JLB_IdAuditoria;
    }

    @Generated
    public JPanel getJPI_Detalle() {
        return this.JPI_Detalle;
    }

    @Generated
    public JScrollPane getJSPObservacion() {
        return this.JSPObservacion;
    }

    @Generated
    public JFormattedTextField getJTFF_ValorGlosado() {
        return this.JTFF_ValorGlosado;
    }

    @Generated
    public JTextField getJTFRuta() {
        return this.JTFRuta;
    }

    @Generated
    public JTextPane getJTP_Observacion() {
        return this.JTP_Observacion;
    }
}
