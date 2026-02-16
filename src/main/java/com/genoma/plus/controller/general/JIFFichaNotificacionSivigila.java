package com.genoma.plus.controller.general;

import Acceso.Principal;
import Utilidades.Metodos;
import com.genoma.plus.dao.general.FichaNotificacionSivigilaDAO;
import com.genoma.plus.dto.general.FichaNotificacionSivigilaDTO;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/general/JIFFichaNotificacionSivigila.class */
public class JIFFichaNotificacionSivigila extends JInternalFrame {
    private File xfile;
    private FichaNotificacionSivigilaDAO xFichaNotificacionSivigilaDAO;
    private DefaultTableModel xmodelo;
    private Object[] xDato;
    List<FichaNotificacionSivigilaDTO> list;
    private JCheckBox JCHEstado;
    private JScrollPane JSDetalle;
    private JScrollPane JSPDescripcion;
    private JTextArea JTADescripcion;
    private JTable JTDetalle;
    private JTextField JTFCodigo;
    private JTextField JTFNombre;
    private JTextField JTFRutaDetalle;
    private JTextField JTFRutaEncabezado;
    private JPanel jPanel1;
    private Metodos xmt = new Metodos();
    private int xestado = 1;

    public JIFFichaNotificacionSivigila() {
        initComponents();
        springStart();
        mNuevo();
    }

    private void springStart() {
        this.xFichaNotificacionSivigilaDAO = (FichaNotificacionSivigilaDAO) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("fichaNotificacionSivigilaDAO");
    }

    public void mGuardar() {
        if (!this.JTFNombre.getText().isEmpty()) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                try {
                    FichaNotificacionSivigilaDTO e = new FichaNotificacionSivigilaDTO();
                    if (Principal.txtNo.getText().isEmpty()) {
                        e.setCodigo(this.JTFCodigo.getText());
                        e.setNombre(this.JTFNombre.getText());
                        e.setDescripcion(this.JTADescripcion.getText());
                        e.setEstado(this.xestado);
                        if (!this.JTFRutaDetalle.getText().isEmpty()) {
                            byte[] fileContent = Files.readAllBytes(Paths.get(this.JTFRutaDetalle.getText(), new String[0]));
                            e.setArchivoSivigila(fileContent);
                            this.xFichaNotificacionSivigilaDAO.mCreate(e);
                        } else {
                            this.xFichaNotificacionSivigilaDAO.mCreateSinArchivo(e);
                        }
                    } else {
                        e.setCodigo(this.JTFCodigo.getText());
                        e.setNombre(this.JTFNombre.getText());
                        e.setDescripcion(this.JTADescripcion.getText());
                        e.setEstado(this.xestado);
                        e.setId(Integer.valueOf(Principal.txtNo.getText()).intValue());
                        if (!this.JTFRutaDetalle.getText().isEmpty()) {
                            byte[] fileContent2 = Files.readAllBytes(Paths.get(this.JTFRutaDetalle.getText(), new String[0]));
                            e.setArchivoSivigila(fileContent2);
                            this.xFichaNotificacionSivigilaDAO.mUpdate(e);
                        } else {
                            this.xFichaNotificacionSivigilaDAO.mUpdateSinArchivo(e);
                        }
                    }
                    mNuevo();
                    return;
                } catch (IOException ex) {
                    Logger.getLogger(JIFFichaNotificacionSivigila.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                    return;
                }
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe digitar un nombre", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        this.JTFNombre.requestFocus();
    }

    public void mNuevo() {
        Principal.mLimpiarDatosP();
        this.JTFCodigo.setText("");
        this.JTFNombre.setText("");
        this.JTADescripcion.setText("");
        this.JTFRutaEncabezado.setText("");
        this.JTFRutaDetalle.setText("");
        this.JCHEstado.setSelected(true);
        this.xestado = 1;
        mCargarDatosTabla();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloTabla() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Codigo", "Nombre", "Descripcion", "Archivo", "Estado"}) { // from class: com.genoma.plus.controller.general.JIFFichaNotificacionSivigila.1
            Class[] types = {Long.class, String.class, String.class, String.class, Boolean.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false, false, false};

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
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(80);
    }

    private void mCargarDatosTabla() {
        this.list = this.xFichaNotificacionSivigilaDAO.listSivigila();
        mCrearModeloTabla();
        for (int x = 0; x < this.list.size(); x++) {
            this.xmodelo.addRow(this.xDato);
            this.xmodelo.setValueAt(Long.valueOf(this.list.get(x).getId()), x, 0);
            this.xmodelo.setValueAt(this.list.get(x).getCodigo(), x, 1);
            this.xmodelo.setValueAt(this.list.get(x).getNombre(), x, 2);
            this.xmodelo.setValueAt(this.list.get(x).getDescripcion(), x, 3);
            if (this.list.get(x).getArchivo() == 1) {
                this.xmodelo.setValueAt(true, x, 4);
            } else {
                this.xmodelo.setValueAt(false, x, 4);
            }
            if (this.list.get(x).getEstado() == 1) {
                this.xmodelo.setValueAt(true, x, 5);
            } else {
                this.xmodelo.setValueAt(false, x, 5);
            }
        }
    }

    /* JADX WARN: Type inference failed for: r3v46, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jPanel1 = new JPanel();
        this.JTFRutaEncabezado = new JTextField();
        this.JCHEstado = new JCheckBox();
        this.JTFCodigo = new JTextField();
        this.JTFRutaDetalle = new JTextField();
        this.JTFNombre = new JTextField();
        this.JSPDescripcion = new JScrollPane();
        this.JTADescripcion = new JTextArea();
        this.JSDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("FICHA DE NOTIFICACIONES SIVIGILA");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjiffichanotificacionsivigila");
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTFRutaEncabezado.setFont(new Font("Arial", 1, 12));
        this.JTFRutaEncabezado.setBorder(BorderFactory.createTitledBorder((Border) null, "Ruta de Encabezado", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRutaEncabezado.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.general.JIFFichaNotificacionSivigila.2
            public void mouseClicked(MouseEvent evt) {
                JIFFichaNotificacionSivigila.this.JTFRutaEncabezadoMouseClicked(evt);
            }
        });
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setSelected(true);
        this.JCHEstado.setText("Estado");
        this.JCHEstado.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.general.JIFFichaNotificacionSivigila.3
            public void actionPerformed(ActionEvent evt) {
                JIFFichaNotificacionSivigila.this.JCHEstadoActionPerformed(evt);
            }
        });
        this.JTFCodigo.setFont(new Font("Arial", 1, 12));
        this.JTFCodigo.setBorder(BorderFactory.createTitledBorder((Border) null, "Codigo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRutaDetalle.setFont(new Font("Arial", 1, 12));
        this.JTFRutaDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "Ruta Sivigila", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRutaDetalle.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.general.JIFFichaNotificacionSivigila.4
            public void mouseClicked(MouseEvent evt) {
                JIFFichaNotificacionSivigila.this.JTFRutaDetalleMouseClicked(evt);
            }
        });
        this.JTFNombre.setFont(new Font("Arial", 1, 12));
        this.JTFNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPDescripcion.setBorder(BorderFactory.createTitledBorder((Border) null, "Descripcion", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTADescripcion.setColumns(20);
        this.JTADescripcion.setFont(new Font("Arial", 1, 12));
        this.JTADescripcion.setRows(5);
        this.JSPDescripcion.setViewportView(this.JTADescripcion);
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JTFCodigo, -2, 127, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFNombre, -1, 613, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHEstado)).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JSPDescripcion).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTFRutaEncabezado).addComponent(this.JTFRutaDetalle, -2, 456, -2)).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.JCHEstado)).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFCodigo, -2, 51, -2).addComponent(this.JTFNombre, -2, 51, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JTFRutaDetalle, -2, 51, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JTFRutaEncabezado, -2, 51, -2)).addComponent(this.JSPDescripcion, -2, 108, -2)).addGap(10, 10, 10)));
        this.JTFRutaEncabezado.setVisible(false);
        this.JSDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setSelectionBackground(Color.white);
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.general.JIFFichaNotificacionSivigila.5
            public void mouseClicked(MouseEvent evt) {
                JIFFichaNotificacionSivigila.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSDetalle.setViewportView(this.JTDetalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -1, -1, 32767).addComponent(this.JSDetalle, -1, 828, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -1, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSDetalle, -2, 278, -2).addGap(10, 10, 10)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEstadoActionPerformed(ActionEvent evt) {
        if (this.JCHEstado.isSelected()) {
            this.xestado = 1;
        } else {
            this.xestado = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            Principal.txtNo.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
            this.JTFCodigo.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString());
            this.JTFNombre.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString());
            this.JTADescripcion.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString());
            if (Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 5).toString()).booleanValue()) {
                this.JCHEstado.setSelected(true);
                this.xestado = 1;
            } else {
                this.JCHEstado.setSelected(false);
                this.xestado = 0;
            }
            if (evt.getClickCount() == 2) {
                this.xmt.AbrirArchivosblob(this.list.get(this.JTDetalle.getSelectedRow()).getArchivoSivigila(), "Sivigila", "pdf", true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaEncabezadoMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JFileChooser xfilec = new JFileChooser("C:\\");
            int xv = xfilec.showOpenDialog(this);
            if (xv == 0) {
                this.xfile = xfilec.getSelectedFile();
                System.out.println(this.xfile.getAbsolutePath());
                this.JTFRutaEncabezado.setText(this.xmt.mTraerUrlBD(this.xfile.getAbsolutePath()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaDetalleMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JFileChooser xfilec = new JFileChooser("C:\\");
            FileNameExtensionFilter filter = new FileNameExtensionFilter("PDF", new String[]{"PDF"});
            xfilec.setFileFilter(filter);
            int xv = xfilec.showOpenDialog(this);
            if (xv == 0) {
                this.xfile = xfilec.getSelectedFile();
                System.out.println(this.xfile.getAbsolutePath());
                this.JTFRutaDetalle.setText(this.xmt.mTraerUrlBD(this.xfile.getAbsolutePath()));
            }
        }
    }
}
