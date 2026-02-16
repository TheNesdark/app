package com.genoma.plus.controller.general;

import Acceso.Principal;
import General.Anular;
import Utilidades.Metodos;
import com.genoma.plus.jpa.entities.GBitacora;
import com.genoma.plus.jpa.projection.IHistoricoBitacora;
import com.genoma.plus.jpa.service.BitacoraService;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.layout.GroupLayout;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/general/JIFBitacora.class */
public class JIFBitacora extends JInternalFrame {
    private List<IHistoricoBitacora> listaBitacora;
    private final BitacoraService bitacoraService;
    private Object[] dato;
    private DefaultTableModel modelo;
    private String Nombre;
    private String Descripcion;
    private GBitacora gBitacora;
    private JButton JBTExportar15;
    private JCheckBox JCHEstado;
    private JDateChooser JDCFechaRegistro;
    private JLabel JLB_Id;
    private JPanel JPI_Datos;
    private JScrollPane JSPEFDescripcion;
    private JScrollPane JSP_Historico;
    private JTable JTBHistorico;
    private JTextField JTFNombre;
    private JTextField JTFRuta;
    private JTextPane JTPEFDescripcion;
    private JPanel jPanel16;
    private Boolean xlleno = false;
    private Metodos metodo = new Metodos();

    public JIFBitacora() {
        initComponents();
        this.listaBitacora = new ArrayList();
        this.bitacoraService = (BitacoraService) Principal.contexto.getBean(BitacoraService.class);
        nuevo();
    }

    public void nuevo() {
        this.JLB_Id.setText("");
        this.JCHEstado.setSelected(true);
        this.JTFNombre.setText("");
        this.JTPEFDescripcion.setText("");
        this.JDCFechaRegistro.setDate(this.metodo.getFechaActual());
        this.gBitacora = new GBitacora();
        cargarDatosTabla();
    }

    public void mBuscar() {
    }

    public void anular() {
        if (!this.JLB_Id.getText().isEmpty() && this.gBitacora.getEstado().booleanValue()) {
            int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de anular?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                Anular frm = new Anular(null, true, "jifbitacora", 13);
                frm.setLocationRelativeTo(this);
                frm.setVisible(true);
                return;
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un registro", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    public void anularDatos(String xid, String xmotivo) {
        this.gBitacora.setEstado(false);
        this.gBitacora.setConceptoAnulacion(xid);
        this.gBitacora.setFechaAnulacion(this.metodo.getFechaActual());
        this.gBitacora.setObservacionAnulacion(xmotivo);
        this.gBitacora.setUsuarioAnulacion(Principal.usuarioSistemaDTO.getNombreUsuario());
        this.bitacoraService.grabar(this.gBitacora);
        nuevo();
    }

    public void grabar() {
        if (!this.JTFNombre.getText().isEmpty()) {
            this.gBitacora = new GBitacora();
            this.gBitacora.setNombre(this.JTFNombre.getText());
            this.gBitacora.setDescripcion(this.JTPEFDescripcion.getText());
            this.gBitacora.setFecha(this.JDCFechaRegistro.getDate());
            this.gBitacora.setEstado(Boolean.valueOf(this.JCHEstado.isSelected()));
            this.gBitacora.setIdUsuarioRh(Principal.usuarioSistemaDTO.getIdPersonaCargo());
            this.gBitacora.setFechaRegistro(this.metodo.getFechaActual());
            this.gBitacora.setEstado(Boolean.valueOf(this.JCHEstado.isSelected()));
            this.bitacoraService.grabar(this.gBitacora);
            nuevo();
        }
    }

    public void crearModeloTabla() {
        this.modelo = new DefaultTableModel((Object[][]) null, new String[]{"id", "Fecha", "nombre", "Descripción", "Usuario", "FechaRegistro", "Estado"}) { // from class: com.genoma.plus.controller.general.JIFBitacora.1
            Class[] types = {Long.class, Date.class, String.class, String.class, String.class, Date.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTBHistorico.setModel(this.modelo);
        this.JTBHistorico.setAutoResizeMode(0);
        this.JTBHistorico.doLayout();
        this.JTBHistorico.getColumnModel().getColumn(0).setPreferredWidth(50);
        this.JTBHistorico.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTBHistorico.getColumnModel().getColumn(2).setPreferredWidth(300);
        this.JTBHistorico.getColumnModel().getColumn(3).setPreferredWidth(400);
        this.JTBHistorico.getColumnModel().getColumn(4).setPreferredWidth(300);
        this.JTBHistorico.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTBHistorico.getColumnModel().getColumn(6).setPreferredWidth(100);
    }

    public void cargarDatosTabla() {
        crearModeloTabla();
        this.listaBitacora = this.bitacoraService.listHistoricoBitacora();
        this.metodo.mEstablecerTextEditor(this.JTBHistorico, 3);
        this.metodo.mEstablecerTextEditor(this.JTBHistorico, 4);
        this.listaBitacora.forEach(e -> {
            this.modelo.addRow(this.dato);
            this.modelo.setValueAt(e.getId(), this.JTBHistorico.getRowCount() - 1, 0);
            this.modelo.setValueAt(e.getFecha(), this.JTBHistorico.getRowCount() - 1, 1);
            this.modelo.setValueAt(e.getNombre(), this.JTBHistorico.getRowCount() - 1, 2);
            this.modelo.setValueAt(e.getDescripcion(), this.JTBHistorico.getRowCount() - 1, 3);
            this.modelo.setValueAt(e.getUsuarioRegistro() + "\n" + e.getCargo(), this.JTBHistorico.getRowCount() - 1, 4);
            this.modelo.setValueAt(e.getFechaRegistro(), this.JTBHistorico.getRowCount() - 1, 5);
            this.modelo.setValueAt(e.getEstado(), this.JTBHistorico.getRowCount() - 1, 6);
        });
    }

    /* JADX WARN: Type inference failed for: r3v48, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jPanel16 = new JPanel();
        this.JTFRuta = new JTextField();
        this.JBTExportar15 = new JButton();
        this.JPI_Datos = new JPanel();
        this.JTFNombre = new JTextField();
        this.JDCFechaRegistro = new JDateChooser();
        this.JCHEstado = new JCheckBox();
        this.JSPEFDescripcion = new JScrollPane();
        this.JTPEFDescripcion = new JTextPane();
        this.JSP_Historico = new JScrollPane();
        this.JTBHistorico = new JTable();
        this.JLB_Id = new JLabel();
        setClosable(true);
        setIconifiable(true);
        setTitle("BITACORA");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifbitacora");
        this.jPanel16.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS PARA EXPORTAR", 0, 0, new Font("Arial", 1, 14), Color.red));
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma\\GenomaP");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.general.JIFBitacora.2
            public void mouseClicked(MouseEvent evt) {
                JIFBitacora.this.JTFRutaJTFRutaMouseClicked(evt);
            }
        });
        this.JBTExportar15.setFont(new Font("Arial", 1, 12));
        this.JBTExportar15.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar15.setText("Exportar");
        this.JBTExportar15.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.general.JIFBitacora.3
            public void actionPerformed(ActionEvent evt) {
                JIFBitacora.this.JBTExportar15JBTExportarActionPerformed(evt);
            }
        });
        GroupLayout jPanel16Layout = new GroupLayout(this.jPanel16);
        this.jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(jPanel16Layout.createParallelGroup(1).add(jPanel16Layout.createSequentialGroup().addContainerGap().add(this.JTFRuta, -2, 437, -2).add(18, 18, 18).add(this.JBTExportar15, -2, 276, -2).addContainerGap(-1, 32767)));
        jPanel16Layout.setVerticalGroup(jPanel16Layout.createParallelGroup(1).add(this.JTFRuta, -2, 50, -2).add(this.JBTExportar15, -2, 50, -2));
        this.JPI_Datos.setBorder(BorderFactory.createTitledBorder((Border) null, "ACTUALIZAR DATOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTFNombre.setFont(new Font("Arial", 1, 12));
        this.JTFNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFechaRegistro.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha ", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFechaRegistro.setDateFormatString("dd/MM/yyyy");
        this.JDCFechaRegistro.setFont(new Font("Arial", 1, 12));
        this.JDCFechaRegistro.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.general.JIFBitacora.4
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFBitacora.this.JDCFechaRegistroPropertyChange(evt);
            }
        });
        this.JDCFechaRegistro.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.general.JIFBitacora.5
            public void keyPressed(KeyEvent evt) {
                JIFBitacora.this.JDCFechaRegistroKeyPressed(evt);
            }
        });
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setText("Estado");
        this.JCHEstado.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.general.JIFBitacora.6
            public void actionPerformed(ActionEvent evt) {
                JIFBitacora.this.JCHEstadoActionPerformed(evt);
            }
        });
        this.JSPEFDescripcion.setBorder(BorderFactory.createTitledBorder((Border) null, "Descripción", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPEFDescripcion.setFont(new Font("Arial", 1, 12));
        this.JTPEFDescripcion.setFont(new Font("Arial", 1, 12));
        this.JTPEFDescripcion.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.general.JIFBitacora.7
            public void keyPressed(KeyEvent evt) {
                JIFBitacora.this.JTPEFDescripcionKeyPressed(evt);
            }
        });
        this.JSPEFDescripcion.setViewportView(this.JTPEFDescripcion);
        GroupLayout JPI_DatosLayout = new GroupLayout(this.JPI_Datos);
        this.JPI_Datos.setLayout(JPI_DatosLayout);
        JPI_DatosLayout.setHorizontalGroup(JPI_DatosLayout.createParallelGroup(1).add(2, JPI_DatosLayout.createSequentialGroup().addContainerGap(-1, 32767).add(JPI_DatosLayout.createParallelGroup(1, false).add(JPI_DatosLayout.createSequentialGroup().add(this.JDCFechaRegistro, -2, 131, -2).add(18, 18, 18).add(this.JTFNombre, -2, 693, -2).addPreferredGap(1).add(this.JCHEstado)).add(this.JSPEFDescripcion)).addContainerGap()));
        JPI_DatosLayout.setVerticalGroup(JPI_DatosLayout.createParallelGroup(1).add(JPI_DatosLayout.createSequentialGroup().add(JPI_DatosLayout.createParallelGroup(1).add(this.JDCFechaRegistro, -2, 50, -2).add(2, JPI_DatosLayout.createParallelGroup(3).add(this.JTFNombre, -2, 50, -2).add(this.JCHEstado))).addPreferredGap(0).add(this.JSPEFDescripcion, -1, 92, 32767).addContainerGap()));
        this.JSP_Historico.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTORICO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTBHistorico.setFont(new Font("Arial", 1, 14));
        this.JTBHistorico.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTBHistorico.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.general.JIFBitacora.8
            public void mouseClicked(MouseEvent evt) {
                JIFBitacora.this.JTBHistoricoMouseClicked(evt);
            }
        });
        this.JSP_Historico.setViewportView(this.JTBHistorico);
        this.JLB_Id.setFont(new Font("Arial", 1, 14));
        this.JLB_Id.setHorizontalAlignment(0);
        this.JLB_Id.setBorder(BorderFactory.createTitledBorder((Border) null, "Id", 0, 0, new Font("Arial", 1, 12), Color.red));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(1).add(layout.createSequentialGroup().addContainerGap().add(layout.createParallelGroup(1).add(this.JPI_Datos, -1, -1, 32767).add(layout.createSequentialGroup().add(this.jPanel16, -2, -1, -2).add(18, 18, 18).add(this.JLB_Id, -1, -1, 32767))).addContainerGap()).add(layout.createParallelGroup(1).add(layout.createSequentialGroup().addContainerGap().add(this.JSP_Historico, -1, 939, 32767).addContainerGap())));
        layout.setVerticalGroup(layout.createParallelGroup(1).add(2, layout.createSequentialGroup().addContainerGap().add(this.JPI_Datos, -2, -1, -2).addPreferredGap(0, 257, 32767).add(layout.createParallelGroup(1).add(2, this.jPanel16, -2, -1, -2).add(2, this.JLB_Id, -2, 50, -2)).addContainerGap()).add(layout.createParallelGroup(1).add(layout.createSequentialGroup().add(182, 182, 182).add(this.JSP_Historico, -2, 250, -2).addContainerGap(89, 32767))));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaJTFRutaMouseClicked(MouseEvent evt) {
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
    public void JBTExportar15JBTExportarActionPerformed(ActionEvent evt) {
        if (this.JTBHistorico.getRowCount() > 0) {
            int n = JOptionPane.showConfirmDialog(this, "Esta seguro de exportar la informacion", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                this.metodo.mExportar_Datos_Tabla_Titulo_Formato(this.JTBHistorico, this.JTFRuta.getText(), getTitle());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDCFechaRegistroPropertyChange(PropertyChangeEvent evt) {
        if (this.xlleno.booleanValue()) {
            cargarDatosTabla();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDCFechaRegistroKeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEstadoActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBHistoricoMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            this.gBitacora = this.bitacoraService.findById(this.listaBitacora.get(this.JTBHistorico.getSelectedRow()).getId());
            this.JLB_Id.setText("" + this.listaBitacora.get(this.JTBHistorico.getSelectedRow()).getId());
            this.JTFNombre.setText(this.listaBitacora.get(this.JTBHistorico.getSelectedRow()).getNombre());
            this.JTPEFDescripcion.setText(this.listaBitacora.get(this.JTBHistorico.getSelectedRow()).getDescripcion());
            this.JDCFechaRegistro.setDate(this.listaBitacora.get(this.JTBHistorico.getSelectedRow()).getFecha());
            this.JCHEstado.setSelected(this.listaBitacora.get(this.JTBHistorico.getSelectedRow()).getEstado().booleanValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTPEFDescripcionKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 9) {
            this.JTPEFDescripcion.transferFocus();
        }
    }
}
