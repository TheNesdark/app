package com.genoma.plus.controller.gcuenta;

import Utilidades.Metodos;
import Utilidades.MetodosFile;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/gcuenta/JIFExportacionInforCarpetas.class */
public class JIFExportacionInforCarpetas extends JInternalFrame {
    private Object[] objetoTabla;
    private final Metodos metodo = new Metodos();
    private DefaultTableModel modeloDetalle;
    private File fileExcel;
    private ButtonGroup JBGSeleccion;
    private JButton JBTExportar3;
    private JLabel JLBNumeroRegistro;
    private JLabel JLBNumeroRegistro1;
    private JPanel JPIDatoP;
    private JPanel JPITipoSeleccion;
    private JRadioButton JRBDeseleccionarTodo;
    private JRadioButton JRBSelecionarTodo;
    private JScrollPane JSPResultado;
    private JTable JTBResultado;
    private JTextField JTFRuta;
    private JTextField JTFRutaExcel;
    private JTextField JTFRutaPdf;

    public JIFExportacionInforCarpetas() {
        initComponents();
        nuevo();
    }

    /* JADX WARN: Type inference failed for: r3v38, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGSeleccion = new ButtonGroup();
        this.JPIDatoP = new JPanel();
        this.JTFRutaExcel = new JTextField();
        this.JLBNumeroRegistro = new JLabel();
        this.JTFRutaPdf = new JTextField();
        this.JLBNumeroRegistro1 = new JLabel();
        this.JSPResultado = new JScrollPane();
        this.JTBResultado = new JTable();
        this.JTFRuta = new JTextField();
        this.JBTExportar3 = new JButton();
        this.JPITipoSeleccion = new JPanel();
        this.JRBSelecionarTodo = new JRadioButton();
        this.JRBDeseleccionarTodo = new JRadioButton();
        setClosable(true);
        setIconifiable(true);
        setTitle("EXPORTACIÓN HISTORIA CLINICA PDF MASIVA");
        setFont(new Font("Arial", 1, 14));
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifexportacionmasivahcpdf");
        this.JPIDatoP.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTFRutaExcel.setFont(new Font("Arial", 1, 12));
        this.JTFRutaExcel.setBorder(BorderFactory.createTitledBorder((Border) null, "Ruta de Archivo (Archivo Excel)", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRutaExcel.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.gcuenta.JIFExportacionInforCarpetas.1
            public void mouseClicked(MouseEvent evt) {
                JIFExportacionInforCarpetas.this.JTFRutaExcelMouseClicked(evt);
            }
        });
        this.JLBNumeroRegistro.setFont(new Font("Arial", 1, 14));
        this.JLBNumeroRegistro.setHorizontalAlignment(0);
        this.JLBNumeroRegistro.setBorder(BorderFactory.createTitledBorder((Border) null, "No. Registro", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JTFRutaPdf.setFont(new Font("Arial", 1, 12));
        this.JTFRutaPdf.setBorder(BorderFactory.createTitledBorder((Border) null, "Ruta de Carpeta (Archivo PDF)", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRutaPdf.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.gcuenta.JIFExportacionInforCarpetas.2
            public void mouseClicked(MouseEvent evt) {
                JIFExportacionInforCarpetas.this.JTFRutaPdfMouseClicked(evt);
            }
        });
        this.JLBNumeroRegistro1.setFont(new Font("Arial", 1, 14));
        this.JLBNumeroRegistro1.setHorizontalAlignment(0);
        this.JLBNumeroRegistro1.setBorder(BorderFactory.createTitledBorder((Border) null, "No. Registro", 0, 0, new Font("Arial", 1, 12), Color.red));
        GroupLayout JPIDatoPLayout = new GroupLayout(this.JPIDatoP);
        this.JPIDatoP.setLayout(JPIDatoPLayout);
        JPIDatoPLayout.setHorizontalGroup(JPIDatoPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatoPLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatoPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFRutaPdf).addComponent(this.JTFRutaExcel)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPIDatoPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLBNumeroRegistro, GroupLayout.Alignment.TRAILING, -2, 151, -2).addComponent(this.JLBNumeroRegistro1, GroupLayout.Alignment.TRAILING, -2, 151, -2)).addContainerGap()));
        JPIDatoPLayout.setVerticalGroup(JPIDatoPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatoPLayout.createSequentialGroup().addGroup(JPIDatoPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatoPLayout.createSequentialGroup().addContainerGap().addComponent(this.JTFRutaExcel, -2, 50, -2)).addComponent(this.JLBNumeroRegistro, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPIDatoPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLBNumeroRegistro1, -2, 50, -2).addComponent(this.JTFRutaPdf, -2, 50, -2)).addContainerGap(19, 32767)));
        this.JSPResultado.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JSPResultado.setFont(new Font("Arial", 1, 12));
        this.JTBResultado.setFont(new Font("Arial", 1, 12));
        this.JTBResultado.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTBResultado.setEditingColumn(1);
        this.JTBResultado.setEditingRow(1);
        this.JTBResultado.setRowHeight(25);
        this.JTBResultado.setSelectionBackground(new Color(255, 255, 255));
        this.JTBResultado.setSelectionForeground(Color.red);
        this.JTBResultado.setSelectionMode(0);
        this.JSPResultado.setViewportView(this.JTBResultado);
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.gcuenta.JIFExportacionInforCarpetas.3
            public void mouseClicked(MouseEvent evt) {
                JIFExportacionInforCarpetas.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBTExportar3.setFont(new Font("Arial", 1, 12));
        this.JBTExportar3.setForeground(Color.red);
        this.JBTExportar3.setIcon(new ImageIcon(getClass().getResource("/Imagenes/IcoPdf.png")));
        this.JBTExportar3.setText("Exportar");
        this.JBTExportar3.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.gcuenta.JIFExportacionInforCarpetas.4
            public void actionPerformed(ActionEvent evt) {
                JIFExportacionInforCarpetas.this.JBTExportar3ActionPerformed(evt);
            }
        });
        this.JPITipoSeleccion.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo de Selección", 0, 0, new Font("Arial", 1, 12)));
        this.JBGSeleccion.add(this.JRBSelecionarTodo);
        this.JRBSelecionarTodo.setFont(new Font("Arial", 1, 12));
        this.JRBSelecionarTodo.setText("Todo");
        this.JRBSelecionarTodo.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.gcuenta.JIFExportacionInforCarpetas.5
            public void actionPerformed(ActionEvent evt) {
                JIFExportacionInforCarpetas.this.JRBSelecionarTodoActionPerformed(evt);
            }
        });
        this.JBGSeleccion.add(this.JRBDeseleccionarTodo);
        this.JRBDeseleccionarTodo.setFont(new Font("Arial", 1, 12));
        this.JRBDeseleccionarTodo.setSelected(true);
        this.JRBDeseleccionarTodo.setText("Ninguno");
        this.JRBDeseleccionarTodo.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.gcuenta.JIFExportacionInforCarpetas.6
            public void actionPerformed(ActionEvent evt) {
                JIFExportacionInforCarpetas.this.JRBDeseleccionarTodoActionPerformed(evt);
            }
        });
        GroupLayout JPITipoSeleccionLayout = new GroupLayout(this.JPITipoSeleccion);
        this.JPITipoSeleccion.setLayout(JPITipoSeleccionLayout);
        JPITipoSeleccionLayout.setHorizontalGroup(JPITipoSeleccionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPITipoSeleccionLayout.createSequentialGroup().addContainerGap().addComponent(this.JRBSelecionarTodo).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBDeseleccionarTodo).addContainerGap(14, 32767)));
        JPITipoSeleccionLayout.setVerticalGroup(JPITipoSeleccionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPITipoSeleccionLayout.createSequentialGroup().addContainerGap(-1, 32767).addGroup(JPITipoSeleccionLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBSelecionarTodo).addComponent(this.JRBDeseleccionarTodo)).addGap(29, 29, 29)));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPIDatoP, -1, -1, 32767).addGroup(layout.createSequentialGroup().addComponent(this.JTFRuta, -2, 491, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTExportar3, -2, 167, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JPITipoSeleccion, -2, -1, -2).addGap(52, 52, 52)).addGroup(layout.createSequentialGroup().addComponent(this.JSPResultado, -2, 941, -2).addGap(0, 0, 32767))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatoP, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPResultado, -2, 426, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 35, 32767).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTFRuta, -1, 50, 32767).addComponent(this.JBTExportar3, -1, -1, 32767)).addComponent(this.JPITipoSeleccion, GroupLayout.Alignment.TRAILING, -2, 55, -2)).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JFileChooser xfilec = new JFileChooser(this.metodo.getDirectorioExportacion());
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
    public void JTFRutaExcelMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JFileChooser xfilec = new JFileChooser(this.metodo.getDirectorioExportacion());
            FileNameExtensionFilter filtroImagen = new FileNameExtensionFilter("XLSX", new String[]{"xlsx"});
            xfilec.setFileFilter(filtroImagen);
            int r = xfilec.showOpenDialog(this);
            if (r == 0) {
                xfilec.showOpenDialog(this);
                this.fileExcel = xfilec.getSelectedFile();
                this.JTFRutaExcel.setText(this.fileExcel.getAbsolutePath());
                leerArchivoExcel();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTExportar3ActionPerformed(ActionEvent evt) {
        copiarArchivos();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBSelecionarTodoActionPerformed(ActionEvent evt) {
        seleccionarEstado(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBDeseleccionarTodoActionPerformed(ActionEvent evt) {
        seleccionarEstado(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaPdfMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JFileChooser xfilec = new JFileChooser(this.metodo.getDirectorioExportacion());
            xfilec.setFileSelectionMode(1);
            int r = xfilec.showOpenDialog(this);
            if (r == 0) {
                try {
                    File selectedFolder = xfilec.getSelectedFile();
                    this.JTFRutaPdf.setText(selectedFolder.getAbsolutePath());
                    this.JLBNumeroRegistro1.setText("" + MetodosFile.countPDFFilesInFolder(selectedFolder.toPath(), "pdf"));
                } catch (IOException ex) {
                    Logger.getLogger(JIFExportacionInforCarpetas.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                }
            }
        }
    }

    private void seleccionarEstado(Boolean estado) {
        for (int i = 0; i < this.JTBResultado.getRowCount(); i++) {
            this.JTBResultado.setValueAt(estado, i, 0);
        }
    }

    private void crearDetalle() {
        this.modeloDetalle = new DefaultTableModel() { // from class: com.genoma.plus.controller.gcuenta.JIFExportacionInforCarpetas.7
            Class[] types = {Boolean.class, String.class, String.class, Boolean.class};
            boolean[] canEdit = {true, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return this.canEdit[colIndex];
            }
        };
        this.modeloDetalle.addColumn("Selección");
        this.modeloDetalle.addColumn("No. Factura");
        this.modeloDetalle.addColumn("Fecha");
        this.modeloDetalle.addColumn("Encontro?");
        this.JTBResultado.setAutoResizeMode(0);
        this.JTBResultado.doLayout();
        this.JTBResultado.setModel(this.modeloDetalle);
        this.JTBResultado.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTBResultado.getColumnModel().getColumn(1).setPreferredWidth(200);
        this.JTBResultado.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTBResultado.getColumnModel().getColumn(3).setPreferredWidth(100);
    }

    public void nuevo() {
        this.JTFRuta.setText(this.metodo.getDirectorioExportacion());
        crearDetalle();
    }

    private void leerArchivoExcel() {
        try {
            FileInputStream inputStream = new FileInputStream(this.fileExcel);
            Sheet firstSheet = new XSSFWorkbook(inputStream).getSheetAt(0);
            Iterator iterator = firstSheet.iterator();
            int nfila = 0;
            iterator.next();
            crearDetalle();
            while (iterator.hasNext()) {
                Row nextRow = (Row) iterator.next();
                this.modeloDetalle.addRow(this.objetoTabla);
                this.JTBResultado.setValueAt(false, nfila, 0);
                this.JTBResultado.setValueAt(nextRow.getCell(0), nfila, 1);
                this.JTBResultado.setValueAt(nextRow.getCell(1), nfila, 2);
                this.JTBResultado.setValueAt(false, nfila, 3);
                nfila++;
            }
            if (nfila >= 0) {
                this.JLBNumeroRegistro.setText("" + nfila);
            }
        } catch (IOException ex) {
            Logger.getLogger(JIFExportacionInforCarpetas.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void copiarArchivos() {
        for (int i = 0; i < this.JTBResultado.getRowCount(); i++) {
            if (Boolean.parseBoolean(this.JTBResultado.getValueAt(i, 0).toString())) {
                try {
                    AtomicBoolean estado = MetodosFile.searchAndCopyFile(new File(this.JTFRutaPdf.getText()).toPath(), this.JTBResultado.getValueAt(i, 1).toString(), new File(this.JTFRuta.getText()).toPath());
                    if (estado.get()) {
                        MetodosFile.modifyExcelCell(this.JTFRutaExcel.getText(), 0, i + 1, 2, "Copiado");
                    }
                } catch (IOException ex) {
                    Logger.getLogger(JIFExportacionInforCarpetas.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                }
            }
        }
    }
}
