package com.genoma.plus.controller.parametrizacion;

import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.genoma.plus.dao.parametrizacion.ImportarInfomacionPaiWebDAO;
import com.genoma.plus.dto.parametrizacion.ImportPaiWebDTO;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/parametrizacion/JIFImportatPaiweb.class */
public class JIFImportatPaiweb extends JInternalFrame {
    private File xfile;
    private String xobjetollamador;
    private Object[] xdato;
    public DefaultTableModel xmodelo;
    public DefaultTableModel xmodelo1;
    private ImportarInfomacionPaiWebDAO ImportarInfomacionPaiWebDAO;
    private JButton JBTExportar;
    private JButton JBTExportar1;
    private JButton JBTImportar;
    private JTextField JTFRuta;
    private JTextField JTFRuta1;
    private JTextField JTFRuta2;
    private JTable JTable;
    private JTable JTableVerifica;
    private JButton jButton1;
    private JButton jButton2;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JPanel jPanel4;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JTabbedPane jTabbedPane1;
    private ConsultasMySQL xconsultas = new ConsultasMySQL();
    private Metodos xmt = new Metodos();
    public int xnfila = -1;

    public JIFImportatPaiweb() {
        initComponents();
        springStart();
        mCrearTablaDetalle();
        modeloTipoInforme1();
    }

    private void springStart() {
        this.ImportarInfomacionPaiWebDAO = (ImportarInfomacionPaiWebDAO) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("importarInformacionPaiWebDAOimpl");
    }

    /* JADX WARN: Type inference failed for: r3v44, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v6, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jTabbedPane1 = new JTabbedPane();
        this.jPanel2 = new JPanel();
        this.jScrollPane1 = new JScrollPane();
        this.JTable = new JTable();
        this.JTFRuta = new JTextField();
        this.JBTImportar = new JButton();
        this.jButton1 = new JButton();
        this.jButton2 = new JButton();
        this.jPanel3 = new JPanel();
        this.jScrollPane2 = new JScrollPane();
        this.JTableVerifica = new JTable();
        this.jPanel4 = new JPanel();
        this.JTFRuta2 = new JTextField();
        this.JBTExportar1 = new JButton();
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Importar  Paiweb");
        setFont(new Font("Arial", 1, 12));
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        this.JTable.setFont(new Font("Arial", 1, 12));
        this.JTable.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.jScrollPane1.setViewportView(this.JTable);
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ruta de Archivo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.parametrizacion.JIFImportatPaiweb.1
            public void mouseClicked(MouseEvent evt) {
                JIFImportatPaiweb.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBTImportar.setFont(new Font("Arial", 1, 14));
        this.JBTImportar.setForeground(Color.blue);
        this.JBTImportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/actualizar.png")));
        this.JBTImportar.setText("Importar");
        this.JBTImportar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.parametrizacion.JIFImportatPaiweb.2
            public void actionPerformed(ActionEvent evt) {
                JIFImportatPaiweb.this.JBTImportarActionPerformed(evt);
            }
        });
        this.jButton1.setFont(new Font("Arial", 1, 14));
        this.jButton1.setForeground(Color.blue);
        this.jButton1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Buscar.png")));
        this.jButton1.setText("VALIDACION");
        this.jButton1.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.parametrizacion.JIFImportatPaiweb.3
            public void actionPerformed(ActionEvent evt) {
                JIFImportatPaiweb.this.jButton1ActionPerformed(evt);
            }
        });
        this.jButton2.setFont(new Font("Arial", 1, 14));
        this.jButton2.setForeground(Color.blue);
        this.jButton2.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Compras29x27.png")));
        this.jButton2.setText("CREAR CARNET MAXIVOS");
        this.jButton2.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.parametrizacion.JIFImportatPaiweb.4
            public void actionPerformed(ActionEvent evt) {
                JIFImportatPaiweb.this.jButton2ActionPerformed(evt);
            }
        });
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane1, -1, 675, 32767).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.JBTImportar, -1, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jButton1, -2, 245, -2).addGap(18, 18, 18).addComponent(this.jButton2, -2, 219, -2)).addComponent(this.JTFRuta)).addContainerGap()));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane1, -2, 371, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFRuta, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JBTImportar, -2, 39, -2).addComponent(this.jButton1, -1, -1, 32767).addComponent(this.jButton2, -1, -1, 32767)).addGap(12, 12, 12)));
        this.jTabbedPane1.addTab("IMPORTAR INFORME PAIWEB", this.jPanel2);
        this.JTableVerifica.setFont(new Font("Arial", 1, 12));
        this.JTableVerifica.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.jScrollPane2.setViewportView(this.JTableVerifica);
        this.jPanel4.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS PARA EXPORTAR", 0, 0, new Font("Arial", 1, 14), Color.red));
        this.JTFRuta2.setFont(new Font("Arial", 1, 12));
        this.JTFRuta2.setText("C:\\Genoma\\plantilla");
        this.JTFRuta2.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta2.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.parametrizacion.JIFImportatPaiweb.5
            public void mouseClicked(MouseEvent evt) {
                JIFImportatPaiweb.this.JTFRuta2MouseClicked(evt);
            }
        });
        this.JBTExportar1.setFont(new Font("Arial", 1, 12));
        this.JBTExportar1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar1.setText("Exportar");
        this.JBTExportar1.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.parametrizacion.JIFImportatPaiweb.6
            public void actionPerformed(ActionEvent evt) {
                JIFImportatPaiweb.this.JBTExportar1ActionPerformed(evt);
            }
        });
        GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
        this.jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addContainerGap().addComponent(this.JTFRuta2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTExportar1, -2, 198, -2).addContainerGap()));
        jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JBTExportar1, -2, 50, -2).addComponent(this.JTFRuta2, -2, 50, -2)).addGap(0, 16, 32767)));
        GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
        this.jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane2, -1, 675, 32767).addComponent(this.jPanel4, GroupLayout.Alignment.TRAILING, -1, -1, 32767)).addContainerGap()));
        jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane2, -1, 347, 32767).addGap(18, 18, 18).addComponent(this.jPanel4, -2, -1, -2).addGap(22, 22, 22)));
        this.jTabbedPane1.addTab("PACIENTES NO EXISTENTES", this.jPanel3);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(5, 5, 5).addComponent(this.jTabbedPane1).addGap(5, 5, 5)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jTabbedPane1));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jButton2ActionPerformed(ActionEvent evt) {
        this.ImportarInfomacionPaiWebDAO.ejecutarSql();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jButton1ActionPerformed(ActionEvent evt) {
        if (this.JTable.getRowCount() != 0 || this.JTable.getSelectedRow() != -1.0d) {
            mGrabar();
        } else {
            JOptionPane.showMessageDialog(this, "Importar un excel", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTImportarActionPerformed(ActionEvent evt) {
        if (!this.JTFRuta.getText().isEmpty()) {
            mImportar();
        } else {
            JOptionPane.showMessageDialog(this, "Ruta del Archivo Excel es vacio", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTFRuta.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JFileChooser xfilec = new JFileChooser(this.JTFRuta.getText());
            FileNameExtensionFilter filtroImagen = new FileNameExtensionFilter("XLS", new String[]{"xls"});
            xfilec.setFileFilter(filtroImagen);
            int r = xfilec.showOpenDialog(this);
            if (r == 0) {
                xfilec.showOpenDialog(this);
                this.xfile = xfilec.getSelectedFile();
                System.out.println(this.xfile.getAbsolutePath());
                this.JTFRuta.setText(this.xfile.getAbsolutePath());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRuta2MouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JFileChooser xfilec = new JFileChooser(this.JTFRuta.getText());
            xfilec.setFileSelectionMode(1);
            int xv = xfilec.showOpenDialog(this);
            if (xv == 0) {
                File xfile = xfilec.getSelectedFile();
                this.JTFRuta.setText(xfile.getAbsolutePath() + this.xmt.getBarra());
                this.JTFRuta.requestFocus();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTExportar1ActionPerformed(ActionEvent evt) {
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTableVerifica, this.JTFRuta.getText(), this.title);
        }
    }

    private void mImportar() {
        try {
            String archivo = this.JTFRuta.getText();
            Workbook workbook = Workbook.getWorkbook(new File(archivo));
            Sheet sheet = workbook.getSheet(0);
            int rows = sheet.getRows();
            System.out.print("TOTAL FILAS: " + rows);
            this.xconsultas.ejecutarSQL("DELETE FROM   `baseserver`.`p_vacunacion_import_paiweb`");
            this.xconsultas.cerrarConexionBd();
            if (rows > 1) {
                for (int x = 1; x < rows; x++) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(String.valueOf(sheet.getCell(0, x).getContents()), x - 1, 0);
                    this.xmodelo.setValueAt(String.valueOf(sheet.getCell(1, x).getContents()), x - 1, 1);
                    this.xmodelo.setValueAt(String.valueOf(sheet.getCell(2, x).getContents()), x - 1, 2);
                    this.xmodelo.setValueAt(String.valueOf(sheet.getCell(3, x).getContents()), x - 1, 3);
                    this.xmodelo.setValueAt(String.valueOf(sheet.getCell(4, x).getContents()), x - 1, 4);
                    this.xmodelo.setValueAt(String.valueOf(sheet.getCell(5, x).getContents()), x - 1, 5);
                    this.xmodelo.setValueAt(String.valueOf(sheet.getCell(6, x).getContents()), x - 1, 6);
                    this.xmodelo.setValueAt(String.valueOf(sheet.getCell(7, x).getContents()), x - 1, 7);
                    this.xmodelo.setValueAt(String.valueOf(sheet.getCell(8, x).getContents()), x - 1, 8);
                    this.xmodelo.setValueAt(String.valueOf(sheet.getCell(9, x).getContents()), x - 1, 9);
                    this.xmodelo.setValueAt(String.valueOf(sheet.getCell(10, x).getContents()), x - 1, 10);
                    this.xmodelo.setValueAt(String.valueOf(sheet.getCell(11, x).getContents()), x - 1, 11);
                    this.xmodelo.setValueAt(String.valueOf(sheet.getCell(12, x).getContents()), x - 1, 12);
                    this.xmodelo.setValueAt(String.valueOf(sheet.getCell(13, x).getContents()), x - 1, 13);
                    this.xmodelo.setValueAt(String.valueOf(sheet.getCell(14, x).getContents()), x - 1, 14);
                    this.xmodelo.setValueAt(String.valueOf(sheet.getCell(15, x).getContents()), x - 1, 15);
                    this.xmodelo.setValueAt(String.valueOf(sheet.getCell(16, x).getContents()), x - 1, 16);
                    this.xmodelo.setValueAt(String.valueOf(sheet.getCell(17, x).getContents()), x - 1, 17);
                    this.xmodelo.setValueAt(String.valueOf(sheet.getCell(18, x).getContents()), x - 1, 18);
                    this.xmodelo.setValueAt(String.valueOf(sheet.getCell(19, x).getContents()), x - 1, 19);
                    this.xmodelo.setValueAt(String.valueOf(sheet.getCell(20, x).getContents()), x - 1, 20);
                    this.xmodelo.setValueAt(String.valueOf(sheet.getCell(21, x).getContents()), x - 1, 21);
                    this.xmodelo.setValueAt(String.valueOf(sheet.getCell(22, x).getContents()), x - 1, 22);
                    this.xmodelo.setValueAt(String.valueOf(sheet.getCell(23, x).getContents()), x - 1, 23);
                    this.xmodelo.setValueAt(String.valueOf(sheet.getCell(24, x).getContents()), x - 1, 24);
                    this.xmodelo.setValueAt(String.valueOf(sheet.getCell(25, x).getContents()), x - 1, 25);
                    this.xmodelo.setValueAt(String.valueOf(sheet.getCell(26, x).getContents()), x - 1, 26);
                    this.xmodelo.setValueAt(String.valueOf(sheet.getCell(27, x).getContents()), x - 1, 27);
                    this.xmodelo.setValueAt(String.valueOf(sheet.getCell(28, x).getContents()), x - 1, 28);
                }
            } else {
                JOptionPane.showMessageDialog(this, "El Documento No Cumple Los Requerimientos", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            }
            workbook.close();
        } catch (IOException ex) {
            Logger.getLogger(JIFImportatPaiweb.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        } catch (BiffException e) {
            Logger.getLogger(JIFImportatPaiweb.class.getName()).log(Level.SEVERE, (String) null, e);
        }
    }

    private void mGrabar() {
        ImportPaiWebDTO importPaiWebDTO = new ImportPaiWebDTO();
        for (int y = 0; y < this.JTable.getRowCount(); y++) {
            importPaiWebDTO.setFechaAplicacion(this.xmodelo.getValueAt(y, 0).toString());
            importPaiWebDTO.setIdentificacion(this.xmodelo.getValueAt(y, 1).toString());
            importPaiWebDTO.setBcg(this.xmodelo.getValueAt(y, 2).toString());
            importPaiWebDTO.setHepatitisb(this.xmodelo.getValueAt(y, 3).toString());
            importPaiWebDTO.setPolioVop(this.xmodelo.getValueAt(y, 4).toString());
            importPaiWebDTO.setPolioVip(this.xmodelo.getValueAt(y, 5).toString());
            importPaiWebDTO.setPentavalente(this.xmodelo.getValueAt(y, 6).toString());
            importPaiWebDTO.setDpt(this.xmodelo.getValueAt(y, 7).toString());
            importPaiWebDTO.setRotavirus(this.xmodelo.getValueAt(y, 8).toString());
            importPaiWebDTO.setNeumococo(this.xmodelo.getValueAt(y, 9).toString());
            importPaiWebDTO.setNeumococoPolisacarido(this.xmodelo.getValueAt(y, 10).toString());
            importPaiWebDTO.setTripleviral(this.xmodelo.getValueAt(y, 11).toString());
            importPaiWebDTO.setHepatitisa(this.xmodelo.getValueAt(y, 12).toString());
            importPaiWebDTO.setFiebreAmarilla(this.xmodelo.getValueAt(y, 13).toString());
            importPaiWebDTO.setTdp(this.xmodelo.getValueAt(y, 14).toString());
            importPaiWebDTO.setInfluenza(this.xmodelo.getValueAt(y, 15).toString());
            importPaiWebDTO.setTda(this.xmodelo.getValueAt(y, 16).toString());
            importPaiWebDTO.setSarampeonRubiola(this.xmodelo.getValueAt(y, 17).toString());
            importPaiWebDTO.setVph(this.xmodelo.getValueAt(y, 18).toString());
            importPaiWebDTO.setRabicaHumana(this.xmodelo.getValueAt(y, 19).toString());
            importPaiWebDTO.setAcelularPediatrica(this.xmodelo.getValueAt(y, 20).toString());
            importPaiWebDTO.setAcelularGestante(this.xmodelo.getValueAt(y, 21).toString());
            importPaiWebDTO.setSueroAntirabico(this.xmodelo.getValueAt(y, 22).toString());
            importPaiWebDTO.setAntiToxinaTetanica(this.xmodelo.getValueAt(y, 23).toString());
            importPaiWebDTO.setAntihepatitisb(this.xmodelo.getValueAt(y, 24).toString());
            importPaiWebDTO.setVaricela(this.xmodelo.getValueAt(y, 25).toString());
            importPaiWebDTO.setRabiacaHumana(this.xmodelo.getValueAt(y, 26).toString());
            importPaiWebDTO.setHepatitisbAdultos(this.xmodelo.getValueAt(y, 27).toString());
            importPaiWebDTO.setHepatitisaAdultos(this.xmodelo.getValueAt(y, 28).toString());
            System.out.println(y);
            this.ImportarInfomacionPaiWebDAO.InsertPaiWeb(importPaiWebDTO);
        }
        JOptionPane.showMessageDialog(this, "Finalizado Exitasamente !!");
        this.ImportarInfomacionPaiWebDAO.VerificarExistenciaUsuarios();
        BuscarInformeTipo1();
    }

    public void mCrearTablaDetalle() {
        this.xmodelo = new DefaultTableModel((Object[][]) null, new String[]{"fechaAplicacion", "identificacion", "bcg", "hepatitisb", "polioVop", "polioVip", "pentavalente", "dpt", "rotavirus", "neumococo", "neumococoPolisacarido", "tripleviral", "hepatitisa", "fiebreAmarilla", "ttd", "influenza", "td", "sarampeonRubiola", "vph", "rabicaHumana", "acelularPediatrica", "acelularGestante", "suerioAntirabico", "antihepatitisb", "antiToxinaTetanica", "varicela", "rabiacaHumana", "hepatitisbAdultos", "hepatitisaAdultos"}) { // from class: com.genoma.plus.controller.parametrizacion.JIFImportatPaiweb.7
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true, false, false, false, false, false, false, false, false, false, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return this.canEdit[colIndex];
            }
        };
        JTable jTable = this.JTable;
        JTable jTable2 = this.JTable;
        jTable.setAutoResizeMode(0);
        this.JTable.doLayout();
        this.JTable.setModel(this.xmodelo);
        this.JTable.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTable.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTable.getColumnModel().getColumn(2).setPreferredWidth(50);
        this.JTable.getColumnModel().getColumn(3).setPreferredWidth(50);
        this.JTable.getColumnModel().getColumn(4).setPreferredWidth(50);
        this.JTable.getColumnModel().getColumn(5).setPreferredWidth(50);
        this.JTable.getColumnModel().getColumn(6).setPreferredWidth(50);
        this.JTable.getColumnModel().getColumn(7).setPreferredWidth(50);
        this.JTable.getColumnModel().getColumn(8).setPreferredWidth(50);
        this.JTable.getColumnModel().getColumn(9).setPreferredWidth(50);
        this.JTable.getColumnModel().getColumn(10).setPreferredWidth(50);
        this.JTable.getColumnModel().getColumn(11).setPreferredWidth(50);
        this.JTable.getColumnModel().getColumn(12).setPreferredWidth(50);
        this.JTable.getColumnModel().getColumn(13).setPreferredWidth(50);
        this.JTable.getColumnModel().getColumn(14).setPreferredWidth(50);
        this.JTable.getColumnModel().getColumn(15).setPreferredWidth(50);
        this.JTable.getColumnModel().getColumn(16).setPreferredWidth(50);
        this.JTable.getColumnModel().getColumn(17).setPreferredWidth(50);
        this.JTable.getColumnModel().getColumn(18).setPreferredWidth(50);
        this.JTable.getColumnModel().getColumn(19).setPreferredWidth(50);
        this.JTable.getColumnModel().getColumn(20).setPreferredWidth(50);
        this.JTable.getColumnModel().getColumn(21).setPreferredWidth(50);
        this.JTable.getColumnModel().getColumn(22).setPreferredWidth(50);
        this.JTable.getColumnModel().getColumn(23).setPreferredWidth(50);
        this.JTable.getColumnModel().getColumn(24).setPreferredWidth(50);
        this.JTable.getColumnModel().getColumn(25).setPreferredWidth(50);
        this.JTable.getColumnModel().getColumn(26).setPreferredWidth(50);
        this.JTable.getColumnModel().getColumn(27).setPreferredWidth(50);
        this.JTable.getColumnModel().getColumn(28).setPreferredWidth(50);
        this.xnfila = -1;
    }

    private void BuscarInformeTipo1() {
        modeloTipoInforme1();
        List<Object[]> list1 = this.ImportarInfomacionPaiWebDAO.ListadoPacientesInexistentes();
        long xnfila = 0;
        if (list1.size() >= 1) {
            this.xmt.mEstablecerTextEditor(this.JTableVerifica, 2);
            for (int x = 0; x < list1.size(); x++) {
                this.xmodelo1.addRow(this.xdato);
                this.xmodelo1.setValueAt(list1.get(x)[0], x, 0);
                this.xmodelo1.setValueAt(list1.get(x)[1], x, 1);
                this.xmodelo1.setValueAt(list1.get(x)[2], x, 2);
                xnfila++;
            }
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void modeloTipoInforme1() {
        this.JTableVerifica.setForeground(Color.RED);
        this.xmodelo1 = new DefaultTableModel(new Object[0], new String[]{"Id", "IDPERSONA", "N°IDENTIFICACION"}) { // from class: com.genoma.plus.controller.parametrizacion.JIFImportatPaiweb.8
            Class[] types = {String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTableVerifica;
        JTable jTable2 = this.JTableVerifica;
        jTable.setAutoResizeMode(0);
        this.JTableVerifica.doLayout();
        this.JTableVerifica.setModel(this.xmodelo1);
        this.JTableVerifica.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTableVerifica.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTableVerifica.getColumnModel().getColumn(2).setPreferredWidth(300);
    }
}
