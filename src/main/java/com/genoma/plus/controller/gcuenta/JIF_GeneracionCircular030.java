package com.genoma.plus.controller.gcuenta;

import Acceso.Principal;
import Utilidades.Metodos;
import Utilidades.WorkerSQL;
import com.genoma.plus.dao.impl.gcuenta.GCGeneracionCircular030DAOImpl;
import com.genoma.plus.dto.gcuenta.GCGenericoDTO;
import com.genoma.plus.jpa.gcuenta.GCGeneracionCircular030DAO;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
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
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/gcuenta/JIF_GeneracionCircular030.class */
public class JIF_GeneracionCircular030 extends JInternalFrame {
    private DefaultTableModel xModelo;
    private Object[] xDato;
    private String[] xIdEmpresa;
    private File xfile;
    private GCGeneracionCircular030DAO xGCuenta;
    private WorkerSQL xWorkerSQL;
    private ButtonGroup JBG_Filtro;
    private JButton JBTGenerar;
    private JComboBox JCBEmpresa;
    private JCheckBox JCHFiltro;
    private JDateChooser JDFechaF;
    private JDateChooser JDFechaI;
    private JLabel JLBNRegistro;
    private JPanel JPExportar;
    private JPanel JPGenerar;
    private JPanel JPIFiltro;
    private JRadioButton JRB_Exportar;
    private JRadioButton JRB_Generar;
    private JScrollPane JSPDetalleTipo;
    private JTable JTDetalleTipo;
    private JTextField JTFRuta;
    private JTabbedPane JTPDatosC;
    private JTabbedPane JTPExportar;
    private Metodos xmt = new Metodos();
    private long xnregistro = 0;
    private boolean xlleno = false;

    public JIF_GeneracionCircular030() {
        initComponents();
        mNuevo();
        springStart();
    }

    /* JADX WARN: Type inference failed for: r3v30, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBG_Filtro = new ButtonGroup();
        this.JPIFiltro = new JPanel();
        this.JDFechaI = new JDateChooser();
        this.JDFechaF = new JDateChooser();
        this.JLBNRegistro = new JLabel();
        this.JTPDatosC = new JTabbedPane();
        this.JSPDetalleTipo = new JScrollPane();
        this.JTDetalleTipo = new JTable();
        this.JTPExportar = new JTabbedPane();
        this.JPGenerar = new JPanel();
        this.JCBEmpresa = new JComboBox();
        this.JCHFiltro = new JCheckBox();
        this.JPExportar = new JPanel();
        this.JTFRuta = new JTextField();
        this.JBTGenerar = new JButton();
        this.JRB_Generar = new JRadioButton();
        this.JRB_Exportar = new JRadioButton();
        setClosable(true);
        setIconifiable(true);
        setTitle("GENERACIÓN CIRCULAR 030");
        setToolTipText("");
        setFont(new Font("Arial", 0, 14));
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjif_generacion_circular030");
        this.JPIFiltro.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS PARA CONSULTA", 0, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JDFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFechaI.setFont(new Font("Arial", 1, 12));
        this.JDFechaI.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.gcuenta.JIF_GeneracionCircular030.1
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIF_GeneracionCircular030.this.JDFechaIPropertyChange(evt);
            }
        });
        this.JDFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Fin", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFechaF.setFont(new Font("Arial", 1, 12));
        this.JDFechaF.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.gcuenta.JIF_GeneracionCircular030.2
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIF_GeneracionCircular030.this.JDFechaFPropertyChange(evt);
            }
        });
        this.JLBNRegistro.setBackground(new Color(255, 255, 255));
        this.JLBNRegistro.setFont(new Font("Arial", 1, 18));
        this.JLBNRegistro.setForeground(Color.red);
        this.JLBNRegistro.setHorizontalAlignment(0);
        this.JLBNRegistro.setBorder(BorderFactory.createTitledBorder((Border) null, "Cant.", 0, 0, new Font("Arial", 1, 14), Color.blue));
        GroupLayout JPIFiltroLayout = new GroupLayout(this.JPIFiltro);
        this.JPIFiltro.setLayout(JPIFiltroLayout);
        JPIFiltroLayout.setHorizontalGroup(JPIFiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFiltroLayout.createSequentialGroup().addContainerGap().addComponent(this.JDFechaI, -2, 115, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JDFechaF, -2, 115, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JLBNRegistro, -2, 125, -2).addContainerGap()));
        JPIFiltroLayout.setVerticalGroup(JPIFiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFiltroLayout.createSequentialGroup().addContainerGap().addGroup(JPIFiltroLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JLBNRegistro, -1, -1, 32767).addGroup(GroupLayout.Alignment.LEADING, JPIFiltroLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JDFechaI, -2, 50, -2).addComponent(this.JDFechaF, -2, 50, -2))).addContainerGap(-1, 32767)));
        this.JTPDatosC.setForeground(Color.red);
        this.JTPDatosC.setFont(new Font("Arial", 1, 14));
        this.JSPDetalleTipo.setBorder((Border) null);
        this.JTDetalleTipo.setFont(new Font("Arial", 1, 12));
        this.JTDetalleTipo.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalleTipo.setRowHeight(25);
        this.JTDetalleTipo.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalleTipo.setSelectionForeground(Color.red);
        this.JTDetalleTipo.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.gcuenta.JIF_GeneracionCircular030.3
            public void keyPressed(KeyEvent evt) {
                JIF_GeneracionCircular030.this.JTDetalleTipoKeyPressed(evt);
            }
        });
        this.JSPDetalleTipo.setViewportView(this.JTDetalleTipo);
        this.JTPDatosC.addTab("TIPO3", this.JSPDetalleTipo);
        this.JTPExportar.setForeground(Color.red);
        this.JTPExportar.setFont(new Font("Arial", 1, 14));
        this.JCBEmpresa.setFont(new Font("Arial", 1, 12));
        this.JCBEmpresa.setBorder(BorderFactory.createTitledBorder((Border) null, "Empresa", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBEmpresa.addItemListener(new ItemListener() { // from class: com.genoma.plus.controller.gcuenta.JIF_GeneracionCircular030.4
            public void itemStateChanged(ItemEvent evt) {
                JIF_GeneracionCircular030.this.JCBEmpresaItemStateChanged(evt);
            }
        });
        this.JCBEmpresa.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.gcuenta.JIF_GeneracionCircular030.5
            public void actionPerformed(ActionEvent evt) {
                JIF_GeneracionCircular030.this.JCBEmpresaActionPerformed(evt);
            }
        });
        this.JCHFiltro.setFont(new Font("Arial", 1, 12));
        this.JCHFiltro.setText("Filtrar por Empresa?");
        this.JCHFiltro.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.gcuenta.JIF_GeneracionCircular030.6
            public void actionPerformed(ActionEvent evt) {
                JIF_GeneracionCircular030.this.JCHFiltroActionPerformed(evt);
            }
        });
        GroupLayout JPGenerarLayout = new GroupLayout(this.JPGenerar);
        this.JPGenerar.setLayout(JPGenerarLayout);
        JPGenerarLayout.setHorizontalGroup(JPGenerarLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPGenerarLayout.createSequentialGroup().addContainerGap().addComponent(this.JCBEmpresa, 0, 759, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHFiltro).addGap(28, 28, 28)));
        JPGenerarLayout.setVerticalGroup(JPGenerarLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPGenerarLayout.createSequentialGroup().addGap(8, 8, 8).addGroup(JPGenerarLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBEmpresa, -1, 50, 32767).addComponent(this.JCHFiltro)).addContainerGap()));
        this.JTPExportar.addTab("FILTRAR", this.JPGenerar);
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ruta (Directorio)", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.gcuenta.JIF_GeneracionCircular030.7
            public void mouseClicked(MouseEvent evt) {
                JIF_GeneracionCircular030.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBTGenerar.setFont(new Font("Arial", 1, 12));
        this.JBTGenerar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTGenerar.setText("Generar");
        this.JBTGenerar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.gcuenta.JIF_GeneracionCircular030.8
            public void actionPerformed(ActionEvent evt) {
                JIF_GeneracionCircular030.this.JBTGenerarActionPerformed(evt);
            }
        });
        this.JBG_Filtro.add(this.JRB_Generar);
        this.JRB_Generar.setFont(new Font("Arial", 1, 12));
        this.JRB_Generar.setSelected(true);
        this.JRB_Generar.setText("Generar");
        this.JRB_Generar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.gcuenta.JIF_GeneracionCircular030.9
            public void actionPerformed(ActionEvent evt) {
                JIF_GeneracionCircular030.this.JRB_GenerarActionPerformed(evt);
            }
        });
        this.JBG_Filtro.add(this.JRB_Exportar);
        this.JRB_Exportar.setFont(new Font("Arial", 1, 12));
        this.JRB_Exportar.setText("Exportar");
        this.JRB_Exportar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.gcuenta.JIF_GeneracionCircular030.10
            public void actionPerformed(ActionEvent evt) {
                JIF_GeneracionCircular030.this.JRB_ExportarActionPerformed(evt);
            }
        });
        GroupLayout JPExportarLayout = new GroupLayout(this.JPExportar);
        this.JPExportar.setLayout(JPExportarLayout);
        JPExportarLayout.setHorizontalGroup(JPExportarLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPExportarLayout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.JTFRuta, -2, 464, -2).addGap(18, 18, 18).addComponent(this.JBTGenerar, -2, 230, -2).addGap(64, 64, 64).addComponent(this.JRB_Generar).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRB_Exportar).addContainerGap()));
        JPExportarLayout.setVerticalGroup(JPExportarLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPExportarLayout.createSequentialGroup().addContainerGap(17, 32767).addGroup(JPExportarLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPExportarLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTFRuta).addComponent(this.JBTGenerar, -2, 41, -2)).addGroup(JPExportarLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRB_Generar).addComponent(this.JRB_Exportar))).addContainerGap()));
        this.JTPExportar.addTab("EXPORTAR", this.JPExportar);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPIFiltro, -1, -1, 32767).addComponent(this.JTPExportar).addComponent(this.JTPDatosC, GroupLayout.Alignment.TRAILING)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIFiltro, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTPDatosC, -2, 368, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTPExportar, -2, 100, -2).addContainerGap(-1, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBEmpresaItemStateChanged(ItemEvent evt) {
        if (!this.xlleno || this.JCBEmpresa.getSelectedIndex() != -1) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBEmpresaActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHFiltroActionPerformed(ActionEvent evt) {
        if (this.JCHFiltro.isSelected()) {
            mLlenarCombo();
        } else {
            this.JCBEmpresa.removeAllItems();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JFileChooser xfilec = new JFileChooser(this.JTFRuta.getText());
            xfilec.setFileSelectionMode(1);
            int xv = xfilec.showOpenDialog(this);
            if (xv == 0) {
                this.xfile = xfilec.getSelectedFile();
                this.JTFRuta.setText(this.xfile.getAbsolutePath() + "");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTGenerarActionPerformed(ActionEvent evt) {
        if (this.JTDetalleTipo.getRowCount() != -1) {
            if (this.JRB_Generar.isSelected()) {
                int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de generar?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (n == 0) {
                    mCrearArchivo();
                    return;
                }
                return;
            }
            if (!this.JTFRuta.getText().isEmpty()) {
                int n2 = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (n2 == 0 && this.JTPDatosC.getSelectedIndex() == 0) {
                    this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTDetalleTipo, this.JTFRuta.getText(), getTitle());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_GenerarActionPerformed(ActionEvent evt) {
        this.JBTGenerar.setText("Generar");
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion());
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ruta (Directorio)", 0, 0, new Font("Arial", 1, 12), Color.blue));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_ExportarActionPerformed(ActionEvent evt) {
        this.JBTGenerar.setText("Exportar");
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ruta de archivo", 0, 0, new Font("Arial", 1, 12), Color.blue));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleTipoKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 127 && this.JTDetalleTipo.getSelectedRow() != -1) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de eliminar?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                this.xModelo.removeRow(this.JTDetalleTipo.getSelectedRow());
                mReorganizarConsecutivo();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaIPropertyChange(PropertyChangeEvent evt) {
        if (this.xlleno && this.JCHFiltro.isSelected()) {
            mLlenarCombo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaFPropertyChange(PropertyChangeEvent evt) {
        if (this.xlleno && this.JCHFiltro.isSelected()) {
            mLlenarCombo();
        }
    }

    public void mCrearArchivo() {
        try {
            String sFichero = this.JTFRuta.getText() + "SAC165FIPS" + this.xmt.formatoANO.format(this.JDFechaF.getDate()) + this.xmt.formatoMes.format(this.JDFechaF.getDate()) + this.xmt.formatoDia.format(this.JDFechaF.getDate()) + Principal.informacionIps.getIdTipoIdentificacion() + this.xmt.mCompletarCadena(Principal.informacionIps.getIdTipoIdentificacion(), 12, "0") + ".txt";
            this.xmt.mEliminarArchivo(new File(sFichero));
            BufferedWriter bw = new BufferedWriter(new FileWriter(sFichero));
            if (this.JTDetalleTipo.getRowCount() != -1) {
                bw.write("1," + Principal.informacionIps.getIdTipoIdentificacion() + "," + Principal.informacionIps.getIdTipoIdentificacion() + "," + Principal.informacionIps.getNombreIps() + "," + this.xmt.formatoAMD1.format(this.JDFechaI.getDate()) + "," + this.xmt.formatoAMD1.format(this.JDFechaF.getDate()) + "," + this.JLBNRegistro.getText());
                bw.newLine();
                String xDatoF = "";
                for (int x = 0; x < this.JTDetalleTipo.getRowCount(); x++) {
                    for (int y = 0; y < this.JTDetalleTipo.getColumnCount(); y++) {
                        xDatoF = xDatoF + this.JTDetalleTipo.getValueAt(x, y) + ",";
                    }
                    bw.write(xDatoF.substring(0, xDatoF.length() - 1));
                    bw.newLine();
                    xDatoF = "";
                }
            }
            bw.close();
            this.xmt.mostrarPdf(sFichero);
        } catch (IOException ex) {
            Logger.getLogger(JIF_GeneracionCircular030.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mReorganizarConsecutivo() {
        this.xnregistro = 0L;
        if (this.JTDetalleTipo.getRowCount() != -1) {
            for (int y = 0; y < this.JTDetalleTipo.getRowCount(); y++) {
                this.xnregistro++;
                this.xModelo.setValueAt(Long.valueOf(this.xnregistro), y, 1);
            }
        }
        this.JLBNRegistro.setText("" + this.xnregistro);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xModelo = new DefaultTableModel(new Object[0], new String[]{"Tr", "Nc", "Tipo", "NIdentifacion", "RazonSocial", "TipoIdentificacion", "Nit", "TipoC", "Prefijo", "NFactura", "Indicardor", "Valor", "FechaFactura", "FechaEntrega", "FechaDevolucion", "VPagos", "GlosaAceptada", "GlosaRespondida", "SaldoFactura", "CJuridico", "EtapaProceso"}) { // from class: com.genoma.plus.controller.gcuenta.JIF_GeneracionCircular030.11
            Class[] types = {Long.class, Long.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Long.class, String.class, Long.class, String.class, String.class, String.class, Long.class, Long.class, String.class, Long.class, String.class, Long.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTDetalleTipo;
        JTable jTable2 = this.JTDetalleTipo;
        jTable.setAutoResizeMode(0);
        this.JTDetalleTipo.doLayout();
        this.JTDetalleTipo.setModel(this.xModelo);
        this.JTDetalleTipo.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTDetalleTipo.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTDetalleTipo.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTDetalleTipo.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTDetalleTipo.getColumnModel().getColumn(4).setPreferredWidth(200);
        this.JTDetalleTipo.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTDetalleTipo.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTDetalleTipo.getColumnModel().getColumn(7).setPreferredWidth(100);
        this.JTDetalleTipo.getColumnModel().getColumn(8).setPreferredWidth(100);
        this.JTDetalleTipo.getColumnModel().getColumn(9).setPreferredWidth(100);
        this.JTDetalleTipo.getColumnModel().getColumn(10).setPreferredWidth(100);
        this.JTDetalleTipo.getColumnModel().getColumn(11).setPreferredWidth(100);
        this.JTDetalleTipo.getColumnModel().getColumn(12).setPreferredWidth(100);
        this.JTDetalleTipo.getColumnModel().getColumn(13).setPreferredWidth(100);
        this.JTDetalleTipo.getColumnModel().getColumn(14).setPreferredWidth(100);
        this.JTDetalleTipo.getColumnModel().getColumn(15).setPreferredWidth(100);
        this.JTDetalleTipo.getColumnModel().getColumn(16).setPreferredWidth(100);
        this.JTDetalleTipo.getColumnModel().getColumn(17).setPreferredWidth(100);
        this.JTDetalleTipo.getColumnModel().getColumn(18).setPreferredWidth(100);
        this.JTDetalleTipo.getColumnModel().getColumn(19).setPreferredWidth(100);
        this.JTDetalleTipo.getColumnModel().getColumn(20).setPreferredWidth(100);
    }

    private void mNuevo() {
        this.xlleno = false;
        this.JDFechaI.setDate(this.xmt.getFechaActual());
        this.JDFechaF.setDate(this.xmt.getFechaActual());
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion());
        mCrearModeloDatos();
        this.xlleno = true;
    }

    private void mLlenarCombo() {
        if (this.xlleno) {
            List<GCGenericoDTO> list = this.xGCuenta.listadoEmpresa030(this.xmt.formatoAMD1.format(this.JDFechaI.getDate()), this.xmt.formatoAMD1.format(this.JDFechaF.getDate()));
            if (list.size() > 0) {
                this.xIdEmpresa = new String[list.size()];
                for (int x = 0; x < list.size(); x++) {
                    this.xIdEmpresa[x] = String.valueOf(list.get(x).getId());
                    this.JCBEmpresa.addItem(list.get(x).getNombre());
                }
            }
        }
    }

    private void springStart() {
        this.xGCuenta = (GCGeneracionCircular030DAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("gCGeneracionCircular030DAO");
    }

    public void mCargarConsolidado() {
        List<Object[]> list;
        if (this.JCHFiltro.isSelected()) {
            list = this.xGCuenta.listFacturasCircular030(this.xmt.formatoAMD1.format(this.JDFechaI.getDate()), this.xmt.formatoAMD1.format(this.JDFechaF.getDate()), this.xIdEmpresa[this.JCBEmpresa.getSelectedIndex()], 1);
        } else {
            list = this.xGCuenta.listFacturasCircular030(this.xmt.formatoAMD1.format(this.JDFechaI.getDate()), this.xmt.formatoAMD1.format(this.JDFechaF.getDate()), "", 0);
        }
        mCrearModeloDatos();
        int xFilas = 0;
        for (int x = 0; x < list.size(); x++) {
            this.xModelo.addRow(this.xDato);
            for (int y = 0; y < this.JTDetalleTipo.getColumnCount(); y++) {
                this.xModelo.setValueAt(list.get(x)[y], x, y);
            }
            xFilas++;
        }
        this.JLBNRegistro.setText("" + xFilas);
    }

    public void mBuscar() {
        this.xWorkerSQL = null;
        this.xWorkerSQL = new WorkerSQL("Cargando la Informacion...", this);
        this.xWorkerSQL.execute();
    }
}
