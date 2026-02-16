package com.genoma.plus.controller.contabilidad;

import Acceso.Principal;
import Utilidades.ConvertirBytesArrayAArchivo;
import Utilidades.Metodos;
import Utilidades.TablaRender;
import com.genoma.plus.jpa.entities.DocumentoSoporteDTO;
import com.genoma.plus.jpa.entities.TipoDocumentoSoporteDTO;
import com.genoma.plus.jpa.projection.IDocumentoSoporteDTO;
import com.genoma.plus.jpa.service.IDocumentoSoporteDAO;
import com.genoma.plus.jpa.service.ITipoDocumentoSoporteDAO;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import lombok.Generated;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/contabilidad/JDRegistroSoportes.class */
public class JDRegistroSoportes extends JDialog {
    private File pdfSoporte;
    private final Metodos metodos;
    private String[] idTipoDocumento;
    private List<TipoDocumentoSoporteDTO> listaTipoDocumento;
    List<IDocumentoSoporteDTO> listaHistorico;
    private String idDocumento;
    String ruta;
    private final IDocumentoSoporteDAO documentoSoporteDAO1;
    private final ITipoDocumentoSoporteDAO tipoDocumentoSoporteDAO1;
    public DefaultTableModel xmodelo;
    private ConvertirBytesArrayAArchivo convertirBytesArrayAArchivo;
    private JButton BTGrabar;
    private JButton BTNuevo;
    private JButton BTSalir;
    private JComboBox<String> JCBTipoDocumento;
    private JPanel JPI_DatosEncabezado;
    private JScrollPane JSPObservacion;
    private JScrollPane JSP_Historico;
    private JTable JTB_Historico;
    private JTextField JTFRuta;
    public JTextPane JTPObservacion;

    @Generated
    public void setPdfSoporte(File pdfSoporte) {
        this.pdfSoporte = pdfSoporte;
    }

    @Generated
    public void setIdTipoDocumento(String[] idTipoDocumento) {
        this.idTipoDocumento = idTipoDocumento;
    }

    @Generated
    public void setListaTipoDocumento(List<TipoDocumentoSoporteDTO> listaTipoDocumento) {
        this.listaTipoDocumento = listaTipoDocumento;
    }

    @Generated
    public void setListaHistorico(List<IDocumentoSoporteDTO> listaHistorico) {
        this.listaHistorico = listaHistorico;
    }

    @Generated
    public void setIdDocumento(String idDocumento) {
        this.idDocumento = idDocumento;
    }

    @Generated
    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    @Generated
    public void setXmodelo(DefaultTableModel xmodelo) {
        this.xmodelo = xmodelo;
    }

    @Generated
    public void setConvertirBytesArrayAArchivo(ConvertirBytesArrayAArchivo convertirBytesArrayAArchivo) {
        this.convertirBytesArrayAArchivo = convertirBytesArrayAArchivo;
    }

    @Generated
    public void setBTGrabar(JButton BTGrabar) {
        this.BTGrabar = BTGrabar;
    }

    @Generated
    public void setBTNuevo(JButton BTNuevo) {
        this.BTNuevo = BTNuevo;
    }

    @Generated
    public void setBTSalir(JButton BTSalir) {
        this.BTSalir = BTSalir;
    }

    @Generated
    public void setJCBTipoDocumento(JComboBox<String> JCBTipoDocumento) {
        this.JCBTipoDocumento = JCBTipoDocumento;
    }

    @Generated
    public void setJPI_DatosEncabezado(JPanel JPI_DatosEncabezado) {
        this.JPI_DatosEncabezado = JPI_DatosEncabezado;
    }

    @Generated
    public void setJSPObservacion(JScrollPane JSPObservacion) {
        this.JSPObservacion = JSPObservacion;
    }

    @Generated
    public void setJSP_Historico(JScrollPane JSP_Historico) {
        this.JSP_Historico = JSP_Historico;
    }

    @Generated
    public void setJTB_Historico(JTable JTB_Historico) {
        this.JTB_Historico = JTB_Historico;
    }

    @Generated
    public void setJTFRuta(JTextField JTFRuta) {
        this.JTFRuta = JTFRuta;
    }

    @Generated
    public void setJTPObservacion(JTextPane JTPObservacion) {
        this.JTPObservacion = JTPObservacion;
    }

    @Generated
    public File getPdfSoporte() {
        return this.pdfSoporte;
    }

    @Generated
    public Metodos getMetodos() {
        return this.metodos;
    }

    @Generated
    public String[] getIdTipoDocumento() {
        return this.idTipoDocumento;
    }

    @Generated
    public List<TipoDocumentoSoporteDTO> getListaTipoDocumento() {
        return this.listaTipoDocumento;
    }

    @Generated
    public List<IDocumentoSoporteDTO> getListaHistorico() {
        return this.listaHistorico;
    }

    @Generated
    public String getIdDocumento() {
        return this.idDocumento;
    }

    @Generated
    public String getRuta() {
        return this.ruta;
    }

    @Generated
    public IDocumentoSoporteDAO getDocumentoSoporteDAO1() {
        return this.documentoSoporteDAO1;
    }

    @Generated
    public ITipoDocumentoSoporteDAO getTipoDocumentoSoporteDAO1() {
        return this.tipoDocumentoSoporteDAO1;
    }

    @Generated
    public DefaultTableModel getXmodelo() {
        return this.xmodelo;
    }

    @Generated
    public ConvertirBytesArrayAArchivo getConvertirBytesArrayAArchivo() {
        return this.convertirBytesArrayAArchivo;
    }

    public JDRegistroSoportes(Frame parent, boolean modal, String idDocumento) {
        super(parent, modal);
        this.metodos = new Metodos();
        this.ruta = this.metodos.getDirectorioExportacion();
        this.documentoSoporteDAO1 = (IDocumentoSoporteDAO) Principal.contexto.getBean(IDocumentoSoporteDAO.class);
        this.tipoDocumentoSoporteDAO1 = (ITipoDocumentoSoporteDAO) Principal.contexto.getBean(ITipoDocumentoSoporteDAO.class);
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        this.idDocumento = idDocumento;
        System.out.println("idDocumento = " + idDocumento);
        nuevo();
        crearModeloTabla();
        cargarHistoricoDocumentos();
    }

    /* JADX WARN: Type inference failed for: r3v27, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPI_DatosEncabezado = new JPanel();
        this.JCBTipoDocumento = new JComboBox<>();
        this.JTFRuta = new JTextField();
        this.JSPObservacion = new JScrollPane();
        this.JTPObservacion = new JTextPane();
        this.JSP_Historico = new JScrollPane();
        this.JTB_Historico = new JTable();
        this.BTNuevo = new JButton();
        this.BTGrabar = new JButton();
        this.BTSalir = new JButton();
        setDefaultCloseOperation(2);
        setTitle("GESTIÓN DE SOPORTES");
        this.JPI_DatosEncabezado.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JCBTipoDocumento.setFont(new Font("Arial", 1, 12));
        this.JCBTipoDocumento.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Documento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTipoDocumento.addItemListener(new ItemListener() { // from class: com.genoma.plus.controller.contabilidad.JDRegistroSoportes.1
            public void itemStateChanged(ItemEvent evt) {
                JDRegistroSoportes.this.JCBTipoDocumentoItemStateChanged(evt);
            }
        });
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ruta", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.contabilidad.JDRegistroSoportes.2
            public void mouseClicked(MouseEvent evt) {
                JDRegistroSoportes.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JSPObservacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPObservacion.setForeground(UIManager.getDefaults().getColor("textHighlight"));
        this.JTPObservacion.setFont(new Font("Arial", 1, 12));
        this.JTPObservacion.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.contabilidad.JDRegistroSoportes.3
            public void keyPressed(KeyEvent evt) {
                JDRegistroSoportes.this.JTPObservacionKeyPressed(evt);
            }
        });
        this.JSPObservacion.setViewportView(this.JTPObservacion);
        GroupLayout JPI_DatosEncabezadoLayout = new GroupLayout(this.JPI_DatosEncabezado);
        this.JPI_DatosEncabezado.setLayout(JPI_DatosEncabezadoLayout);
        JPI_DatosEncabezadoLayout.setHorizontalGroup(JPI_DatosEncabezadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DatosEncabezadoLayout.createSequentialGroup().addGap(14, 14, 14).addGroup(JPI_DatosEncabezadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPObservacion).addGroup(JPI_DatosEncabezadoLayout.createSequentialGroup().addComponent(this.JCBTipoDocumento, -2, 250, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFRuta))).addContainerGap()));
        JPI_DatosEncabezadoLayout.setVerticalGroup(JPI_DatosEncabezadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DatosEncabezadoLayout.createSequentialGroup().addGap(16, 16, 16).addGroup(JPI_DatosEncabezadoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBTipoDocumento, -2, 50, -2).addComponent(this.JTFRuta, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPObservacion, -2, 82, -2).addContainerGap(-1, 32767)));
        this.JSP_Historico.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTB_Historico.setFont(new Font("Arial", 1, 12));
        this.JTB_Historico.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[]{"Nombre", "Observacion", "PDF", "Estado"}));
        this.JTB_Historico.setRowHeight(25);
        this.JTB_Historico.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.contabilidad.JDRegistroSoportes.4
            public void mouseClicked(MouseEvent evt) {
                JDRegistroSoportes.this.JTB_HistoricoMouseClicked(evt);
            }
        });
        this.JSP_Historico.setViewportView(this.JTB_Historico);
        this.BTNuevo.setFont(new Font("Arial", 1, 12));
        this.BTNuevo.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Nuevo.png")));
        this.BTNuevo.setText("Nuevo");
        this.BTNuevo.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.contabilidad.JDRegistroSoportes.5
            public void actionPerformed(ActionEvent evt) {
                JDRegistroSoportes.this.BTNuevoActionPerformed(evt);
            }
        });
        this.BTGrabar.setFont(new Font("Arial", 1, 12));
        this.BTGrabar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.BTGrabar.setText("Cargar");
        this.BTGrabar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.contabilidad.JDRegistroSoportes.6
            public void actionPerformed(ActionEvent evt) {
                JDRegistroSoportes.this.BTGrabarActionPerformed(evt);
            }
        });
        this.BTSalir.setFont(new Font("Arial", 1, 12));
        this.BTSalir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.BTSalir.setText("Cerrar");
        this.BTSalir.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.contabilidad.JDRegistroSoportes.7
            public void actionPerformed(ActionEvent evt) {
                JDRegistroSoportes.this.BTSalirActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPI_DatosEncabezado, -1, -1, 32767).addComponent(this.JSP_Historico).addGroup(layout.createSequentialGroup().addComponent(this.BTNuevo, -2, 180, -2).addGap(88, 88, 88).addComponent(this.BTGrabar, -2, 180, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 115, 32767).addComponent(this.BTSalir, -2, 180, -2))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(19, 19, 19).addComponent(this.JPI_DatosEncabezado, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSP_Historico, -1, 178, 32767).addGap(18, 18, 18).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.BTNuevo, -2, 50, -2).addComponent(this.BTSalir, -2, 50, -2).addComponent(this.BTGrabar, -2, 50, -2)).addGap(19, 19, 19)));
        pack();
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
    public void JTB_HistoricoMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 1 && this.JTB_Historico.getSelectedRow() != -1 && this.JTB_Historico.getSelectedColumn() == 4) {
            this.convertirBytesArrayAArchivo = new ConvertirBytesArrayAArchivo();
            if (this.ruta != null) {
                this.metodos.AbrirArchivosblob(this.xmodelo.getValueAt(this.JTB_Historico.getSelectedRow(), 5), "soporte", "pdf", true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTPObservacionKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 9) {
            this.JTPObservacion.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BTNuevoActionPerformed(ActionEvent evt) {
        nuevo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BTSalirActionPerformed(ActionEvent evt) {
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BTGrabarActionPerformed(ActionEvent evt) {
        grabar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBTipoDocumentoItemStateChanged(ItemEvent evt) {
        if (this.JCBTipoDocumento.getSelectedIndex() != -1) {
            System.out.println("" + this.listaTipoDocumento.get(this.JCBTipoDocumento.getSelectedIndex()).getNombre());
        }
    }

    private void nuevo() {
        this.JCBTipoDocumento.setSelectedIndex(-1);
        this.JTFRuta.setText(this.metodos.getDirectorioExportacion());
        this.JTPObservacion.setText("");
        llenarComboTipoDocumento();
    }

    private void llenarComboTipoDocumento() {
        this.JCBTipoDocumento.removeAllItems();
        this.listaTipoDocumento = this.tipoDocumentoSoporteDAO1.listadoTipoDocumentoSoportePorIdTipo(2);
        if (!this.listaTipoDocumento.isEmpty()) {
            Iterator<TipoDocumentoSoporteDTO> iterator = this.listaTipoDocumento.iterator();
            while (iterator.hasNext()) {
                this.JCBTipoDocumento.addItem(iterator.next().getNombre());
            }
        }
    }

    private void crearModeloTabla() {
        this.xmodelo = new DefaultTableModel((Object[][]) null, new String[]{"id", "Fecha", "Tipo Documento", "Observacion", "PDF", "PDF2", "Estado"}) { // from class: com.genoma.plus.controller.contabilidad.JDRegistroSoportes.8
            Class[] types = {Long.class, String.class, String.class, String.class, JButton.class, Byte.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return this.canEdit[colIndex];
            }
        };
        this.JTB_Historico.setAutoResizeMode(0);
        this.JTB_Historico.doLayout();
        this.JTB_Historico.setModel(this.xmodelo);
        this.JTB_Historico.setDefaultRenderer(Object.class, new TablaRender());
        this.JTB_Historico.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTB_Historico.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTB_Historico.getColumnModel().getColumn(2).setPreferredWidth(200);
        this.JTB_Historico.getColumnModel().getColumn(3).setPreferredWidth(300);
        this.JTB_Historico.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTB_Historico.getColumnModel().getColumn(5).setPreferredWidth(0);
        this.JTB_Historico.getColumnModel().getColumn(5).setMinWidth(0);
        this.JTB_Historico.getColumnModel().getColumn(5).setMaxWidth(0);
        this.JTB_Historico.getColumnModel().getColumn(6).setPreferredWidth(100);
    }

    private void cargarHistoricoDocumentos() {
        this.JTB_Historico.setModel(this.xmodelo);
        this.listaHistorico = this.documentoSoporteDAO1.listadoDocumentoSoportePorIdDocumento(new Long(this.idDocumento));
        this.metodos.mEstablecerTextEditor(this.JTB_Historico, 1);
        this.metodos.mEstablecerTextEditor(this.JTB_Historico, 3);
        for (IDocumentoSoporteDTO documentoSoporteDTO : this.listaHistorico) {
            if (documentoSoporteDTO.getId() != null) {
                Object[] fila = {documentoSoporteDTO.getId(), documentoSoporteDTO.getFecha(), documentoSoporteDTO.getTipoDocumento(), documentoSoporteDTO.getObservacion(), new JButton("Abrir Pdf"), documentoSoporteDTO.getDocumento(), documentoSoporteDTO.getEstado()};
                this.xmodelo.addRow(fila);
            }
        }
    }

    private void grabar() {
        if (this.JCBTipoDocumento.getSelectedIndex() != -1) {
            if (this.pdfSoporte != null) {
                try {
                    DocumentoSoporteDTO e = new DocumentoSoporteDTO();
                    e.setIdDocumento(Long.valueOf(getIdDocumento()));
                    e.setIdTipoDocumento(this.listaTipoDocumento.get(this.JCBTipoDocumento.getSelectedIndex()).getId());
                    e.setDocumento(Files.readAllBytes(getPdfSoporte().toPath()));
                    e.setObservacion(this.JTPObservacion.getText());
                    e.setEstado(true);
                    e.setIdUsuarioRh(Principal.usuarioSistemaDTO.getIdPersonaCargo());
                    e.setFecha(new Date());
                    this.documentoSoporteDAO1.registrarDocumento(e);
                    cargarHistoricoDocumentos();
                    return;
                } catch (IOException ex) {
                    Logger.getLogger(JDRegistroSoportes.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                    JOptionPane.showMessageDialog(this, "Error al guardar el documento.");
                    return;
                }
            }
            JOptionPane.showMessageDialog(this, "Debe seleccionar archivo a cargar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        JOptionPane.showMessageDialog(this, "Debe seleccionar tipo de documento", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JCBTipoDocumento.requestFocus();
    }

    @Generated
    public JButton getBTGrabar() {
        return this.BTGrabar;
    }

    @Generated
    public JButton getBTNuevo() {
        return this.BTNuevo;
    }

    @Generated
    public JButton getBTSalir() {
        return this.BTSalir;
    }

    @Generated
    public JComboBox<String> getJCBTipoDocumento() {
        return this.JCBTipoDocumento;
    }

    @Generated
    public JPanel getJPI_DatosEncabezado() {
        return this.JPI_DatosEncabezado;
    }

    @Generated
    public JScrollPane getJSPObservacion() {
        return this.JSPObservacion;
    }

    @Generated
    public JScrollPane getJSP_Historico() {
        return this.JSP_Historico;
    }

    @Generated
    public JTable getJTB_Historico() {
        return this.JTB_Historico;
    }

    @Generated
    public JTextField getJTFRuta() {
        return this.JTFRuta;
    }

    @Generated
    public JTextPane getJTPObservacion() {
        return this.JTPObservacion;
    }
}
