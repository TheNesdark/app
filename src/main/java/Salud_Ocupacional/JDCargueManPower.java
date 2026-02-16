package Salud_Ocupacional;

import Presupuesto.JIFFCarguePTOInicial;
import Utilidades.ConsultasMySQL;
import Utilidades.WorkerSQL;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

/* JADX INFO: loaded from: GenomaP.jar:Salud_Ocupacional/JDCargueManPower.class */
public class JDCargueManPower extends JDialog {
    private JFileChooser FileChooser;
    private Vector columna;
    private Vector filas;
    private DefaultTableModel xmodelo;
    private DefaultTableModel xmodeloSEG;
    private DefaultTableModel xmodeloUN;
    private ConsultasMySQL xct;
    private ArrayList<String[]> xlog;
    private Object[] xdatos;
    private int cont;
    private String urlFile;
    private JIFGestion_ManPower xJIFGestion_ManPower;
    private WorkerSQL xWorkerSQL;
    private JButton JBImportar;
    private JButton JBSalir;
    private JButton JBValidar;
    public JLabel JLErrores;
    private JTextArea JTALog;
    private JTable JTDetalles;
    private JTable JTSEG;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JScrollPane jScrollPane3;
    private JTabbedPane jTabbedPane1;

    public JDCargueManPower(Frame parent, boolean modal, JIFGestion_ManPower xJIFGestion_ManPower) {
        super(parent, modal);
        this.FileChooser = new JFileChooser();
        this.columna = new Vector();
        this.filas = new Vector();
        this.xct = new ConsultasMySQL();
        this.xlog = new ArrayList<>();
        this.cont = 1;
        this.urlFile = "";
        initComponents();
        this.xJIFGestion_ManPower = xJIFGestion_ManPower;
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        setLocationRelativeTo(null);
        mCrearModeloDatos();
        mBuscaSEG();
    }

    /* JADX WARN: Type inference failed for: r3v28, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v33, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBSalir = new JButton();
        this.jPanel1 = new JPanel();
        this.JBImportar = new JButton();
        this.JBValidar = new JButton();
        this.jScrollPane2 = new JScrollPane();
        this.JTALog = new JTextArea();
        this.jTabbedPane1 = new JTabbedPane();
        this.jScrollPane1 = new JScrollPane();
        this.JTDetalles = new JTable();
        this.jPanel2 = new JPanel();
        this.jScrollPane3 = new JScrollPane();
        this.JTSEG = new JTable();
        this.JLErrores = new JLabel();
        setDefaultCloseOperation(2);
        setTitle("VALIDACIÓN POBLACIÓN OBJETO");
        this.JBSalir.setFont(new Font("Arial", 1, 12));
        this.JBSalir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.JBSalir.setText("Salir");
        this.JBSalir.addActionListener(new ActionListener() { // from class: Salud_Ocupacional.JDCargueManPower.1
            public void actionPerformed(ActionEvent evt) {
                JDCargueManPower.this.JBSalirActionPerformed(evt);
            }
        });
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JBImportar.setFont(new Font("Arial", 1, 12));
        this.JBImportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel.jpg")));
        this.JBImportar.setText("Importar");
        this.JBImportar.setToolTipText("");
        this.JBImportar.addActionListener(new ActionListener() { // from class: Salud_Ocupacional.JDCargueManPower.2
            public void actionPerformed(ActionEvent evt) {
                JDCargueManPower.this.JBImportarActionPerformed(evt);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.JBImportar, -2, 176, -2).addContainerGap(-1, 32767)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.JBImportar, -2, 54, -2).addContainerGap(19, 32767)));
        this.JBValidar.setFont(new Font("Arial", 1, 12));
        this.JBValidar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBValidar.setText("Validar");
        this.JBValidar.addActionListener(new ActionListener() { // from class: Salud_Ocupacional.JDCargueManPower.3
            public void actionPerformed(ActionEvent evt) {
                JDCargueManPower.this.JBValidarActionPerformed(evt);
            }
        });
        this.JTALog.setColumns(1);
        this.JTALog.setRows(1);
        this.JTALog.setWrapStyleWord(true);
        this.JTALog.setBorder(BorderFactory.createTitledBorder((Border) null, "Log", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jScrollPane2.setViewportView(this.JTALog);
        this.jTabbedPane1.setForeground(new Color(0, 102, 0));
        this.jTabbedPane1.setFont(new Font("Arial", 1, 14));
        this.jScrollPane1.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLES", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JTDetalles.setFont(new Font("Arial", 1, 12));
        this.JTDetalles.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalles.setAutoResizeMode(0);
        this.JTDetalles.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalles.setSelectionForeground(Color.red);
        this.jScrollPane1.setViewportView(this.JTDetalles);
        this.jTabbedPane1.addTab("CARGUE", this.jScrollPane1);
        this.jScrollPane3.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLES", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JTSEG.setFont(new Font("Arial", 1, 12));
        this.JTSEG.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTSEG.setSelectionBackground(new Color(255, 255, 255));
        this.JTSEG.setSelectionForeground(Color.red);
        this.jScrollPane3.setViewportView(this.JTSEG);
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 764, 32767).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.jScrollPane3, -2, 764, -2).addGap(0, 0, 32767))));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 379, 32767).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.jScrollPane3, -2, 379, -2).addGap(0, 0, 32767))));
        this.jTabbedPane1.addTab("SEG", this.jPanel2);
        this.JLErrores.setFont(new Font("Arial", 1, 14));
        this.JLErrores.setForeground(Color.red);
        this.JLErrores.setHorizontalAlignment(0);
        this.JLErrores.setText("0");
        this.JLErrores.setBorder(BorderFactory.createTitledBorder((Border) null, "Errores", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -1, -1, 32767).addGroup(layout.createSequentialGroup().addComponent(this.JBValidar, -2, 212, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JLErrores, -2, 157, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JBSalir, -2, 190, -2)).addComponent(this.jScrollPane2).addComponent(this.jTabbedPane1)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jTabbedPane1, -1, 410, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane2, -2, 119, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLErrores).addComponent(this.JBValidar, -1, -1, 32767).addComponent(this.JBSalir, -1, 43, 32767)).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBSalirActionPerformed(ActionEvent evt) {
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBValidarActionPerformed(ActionEvent evt) {
        this.xWorkerSQL = new WorkerSQL("Validando información", this);
        this.xWorkerSQL.execute();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBImportarActionPerformed(ActionEvent evt) {
        Importar();
    }

    public void mValidar() {
        validaPersona();
        validaSEG();
    }

    private void validaPersona() {
        for (int i = 0; i < this.JTDetalles.getRowCount(); i++) {
            String sql = "SELECT Id, NoDocumento FROM `g_persona` WHERE NoDocumento='" + this.xmodelo.getValueAt(i, 1).toString() + "'";
            ResultSet xrs = this.xct.traerRs(sql);
            try {
                if (xrs.next()) {
                    xrs.first();
                    this.xmodelo.setValueAt(xrs.getString(1), i, 11);
                } else {
                    String[] registro = {"" + this.cont, "Verificar Usuario--> fila(" + (i + 2) + ") " + this.xmodelo.getValueAt(i, 1).toString() + " - " + this.xmodelo.getValueAt(i, 4).toString()};
                    this.xlog.add(registro);
                    this.cont++;
                }
                xrs.close();
                this.xct.cerrarConexionBd();
            } catch (SQLException ex) {
                Logger.getLogger(JIFFCarguePTOInicial.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        }
    }

    private void mLlenaLog() {
        System.out.println("Entra a llenar log-->" + this.cont);
        String texto = "";
        try {
            if (this.xlog.size() > 0) {
                System.out.println("xlog.size() " + this.xlog.size());
                for (int i = 0; i < this.xlog.size(); i++) {
                    System.out.println((i + 1) + ". " + this.xlog.get(i)[0].toString() + " " + this.xlog.get(i)[1].toString());
                    texto = texto + this.xlog.get(i)[0].toString() + " " + this.xlog.get(i)[1].toString() + "\n";
                }
                this.JTALog.setText(this.JTALog.getText() + texto);
                this.JLErrores.setText("" + (this.cont - 1));
            } else {
                this.JTALog.setText("Archivo validado sin errores...");
                this.xJIFGestion_ManPower.JTFRuta.setText(this.urlFile);
                this.xJIFGestion_ManPower.xValidado = 1;
                dispose();
            }
        } catch (Exception e) {
            System.out.println("\n\n\n" + e.getMessage());
        }
    }

    private void validaSEG() {
        System.out.println("-------------- validaSEG()  ");
        for (int i = 0; i < this.JTDetalles.getRowCount(); i++) {
            for (int j = 0; j < this.JTSEG.getRowCount(); j++) {
                System.out.println(this.xmodelo.getValueAt(i, 10).toString() + " " + this.xmodeloSEG.getValueAt(j, 1).toString());
                if (this.xmodelo.getValueAt(i, 10).toString().equals(this.xmodeloSEG.getValueAt(j, 1).toString())) {
                    this.xmodelo.setValueAt(this.xmodeloSEG.getValueAt(j, 0).toString(), i, 12);
                }
            }
        }
        for (int i2 = 0; i2 < this.JTDetalles.getRowCount(); i2++) {
            if (this.xmodelo.getValueAt(i2, 12) == null) {
                String[] registro = {"" + this.cont, "Verificar SEG--> fila(" + (i2 + 2) + ") " + this.xmodelo.getValueAt(i2, 10).toString()};
                this.xlog.add(registro);
                this.cont++;
            }
        }
        mLlenaLog();
    }

    private void Importar() {
        this.FileChooser.showDialog((Component) null, "Importar Hoja ");
        File file = this.FileChooser.getSelectedFile();
        System.out.println("url-->" + file.getPath());
        this.urlFile = file.getPath();
        if (!file.getName().endsWith("xls")) {
            JOptionPane.showMessageDialog((Component) null, "Seleccione un archivo excel...", "Error", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
            return;
        }
        try {
            CrearTabla(file);
        } catch (IOException ex) {
            Logger.getLogger(JDCargueManPower.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void CrearTabla(File file) throws IOException {
        try {
            Workbook workbook = Workbook.getWorkbook(file);
            Sheet sheet = workbook.getSheet(0);
            this.columna.clear();
            for (int i = 0; i < sheet.getColumns(); i++) {
                Cell cell1 = sheet.getCell(i, 0);
                this.columna.add(cell1.getContents());
            }
            this.filas.clear();
            for (int j = 1; j < sheet.getRows(); j++) {
                Vector d = new Vector();
                for (int i2 = 0; i2 < sheet.getColumns(); i2++) {
                    Cell cell = sheet.getCell(i2, j);
                    if (i2 == 11 || i2 == 12) {
                        d.add("");
                    } else {
                        d.add(cell.getContents());
                    }
                }
                d.add("\n");
                this.xmodelo.addRow(d);
            }
        } catch (BiffException e) {
            e.printStackTrace();
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Codigo", "Cedula", "Tcontrato", "TContrato1", "Nombre Completo", "Cargo", "Grupo", "Email", "UnidadN", "FechaIngreso", "SEG", "idPersona", "idSeg", "idUN"}) { // from class: Salud_Ocupacional.JDCargueManPower.4
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalles.setModel(this.xmodelo);
        this.JTDetalles.getColumnModel().getColumn(0).setPreferredWidth(90);
        this.JTDetalles.getColumnModel().getColumn(1).setPreferredWidth(90);
        this.JTDetalles.getColumnModel().getColumn(2).setPreferredWidth(90);
        this.JTDetalles.getColumnModel().getColumn(3).setPreferredWidth(230);
        this.JTDetalles.getColumnModel().getColumn(4).setPreferredWidth(230);
        this.JTDetalles.getColumnModel().getColumn(5).setPreferredWidth(230);
        this.JTDetalles.getColumnModel().getColumn(6).setPreferredWidth(230);
        this.JTDetalles.getColumnModel().getColumn(7).setPreferredWidth(230);
        this.JTDetalles.getColumnModel().getColumn(8).setPreferredWidth(230);
        this.JTDetalles.getColumnModel().getColumn(9).setPreferredWidth(230);
        this.JTDetalles.getColumnModel().getColumn(10).setPreferredWidth(230);
        this.JTDetalles.getColumnModel().getColumn(11).setPreferredWidth(2);
        this.JTDetalles.getColumnModel().getColumn(12).setPreferredWidth(2);
        this.JTDetalles.getColumnModel().getColumn(13).setPreferredWidth(0);
        this.JTDetalles.getColumnModel().getColumn(13).setMinWidth(0);
        this.JTDetalles.getColumnModel().getColumn(13).setMaxWidth(0);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloSEG() {
        this.xmodeloSEG = new DefaultTableModel(new Object[0], new String[]{"Id", "Nombre SEG"}) { // from class: Salud_Ocupacional.JDCargueManPower.5
            Class[] types = {String.class, String.class};
            boolean[] canEdit = {false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTSEG.setModel(this.xmodeloSEG);
        this.JTSEG.getColumnModel().getColumn(0).setPreferredWidth(20);
        this.JTSEG.getColumnModel().getColumn(1).setPreferredWidth(200);
    }

    private void mBuscaSEG() {
        mCrearModeloSEG();
        ResultSet xrs = this.xct.traerRs("SELECT Id, Nbre FROM `so_tipo_segmento` WHERE Estado=1 ORDER BY Nbre ASC");
        int n = 0;
        try {
            if (xrs.next()) {
                xrs.beforeFirst();
                while (xrs.next()) {
                    this.xmodeloSEG.addRow(this.xdatos);
                    this.xmodeloSEG.setValueAt(xrs.getString("Id"), n, 0);
                    this.xmodeloSEG.setValueAt(xrs.getString("Nbre"), n, 1);
                    n++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JDCargueManPower.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }
}
