package Salud_Ocupacional;

import Acceso.Principal;
import Sig.JIFInformesPyP;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
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
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

/* JADX INFO: loaded from: GenomaP.jar:Salud_Ocupacional/JIFFInformes.class */
public class JIFFInformes extends JInternalFrame {
    private String xnombre;
    private String xsql;
    private DefaultTableModel xmodelo;
    private DefaultTableModel xmodelo2;
    private DefaultTableModel xmodelogeneral;
    private Object[] xdatos;
    private JButton JBImprimir;
    private JButton JBTExportar;
    private JDateChooser JDFechaF;
    private JDateChooser JDFechaI;
    private JLabel JLCantidad;
    private JLabel JLPorcentaje;
    private JLabel JLPosAlc;
    private JLabel JLPosDro;
    private JLabel JLRealizadas;
    private JScrollPane JSPTConsolidado;
    private JScrollPane JSPTConsolidadoGeneral;
    private JScrollPane JSPTDetalle;
    private JTable JTConsolidado;
    private JTable JTConsolidadoGeneral;
    private JTable JTDetalle;
    private JTextField JTFRuta;
    private JTabbedPane JTPDatos;
    private JPanel jPanel1;
    private String xtitulo = "";
    private ConsultasMySQL xct = new ConsultasMySQL();
    private Metodos xmt = new Metodos();
    private int[] xresultado = new int[3];

    public JIFFInformes(String xnombre, String xtitulo) {
        this.xnombre = "";
        initComponents();
        setName(xnombre);
        setTitle(xtitulo.toUpperCase());
        this.xnombre = xnombre;
        this.JDFechaF.setDate(this.xmt.getFechaActual());
        this.JDFechaI.setDate(this.xmt.getFechaActual());
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
        if (this.xnombre.equals("xjiftestfatigaInf1") || this.xnombre.equals("xjiftestfatigaInf2")) {
            this.JTPDatos.removeTabAt(1);
        }
    }

    /* JADX WARN: Type inference failed for: r3v21, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v26, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v37, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JDFechaI = new JDateChooser();
        this.JDFechaF = new JDateChooser();
        this.JTFRuta = new JTextField();
        this.JBTExportar = new JButton();
        this.JLCantidad = new JLabel();
        this.JTPDatos = new JTabbedPane();
        this.JSPTDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.jPanel1 = new JPanel();
        this.JSPTConsolidado = new JScrollPane();
        this.JTConsolidado = new JTable();
        this.JBImprimir = new JButton();
        this.JSPTConsolidadoGeneral = new JScrollPane();
        this.JTConsolidadoGeneral = new JTable();
        this.JLRealizadas = new JLabel();
        this.JLPosAlc = new JLabel();
        this.JLPosDro = new JLabel();
        this.JLPorcentaje = new JLabel();
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("INFORMES");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        this.JDFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicio", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JDFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFechaI.setFont(new Font("Arial", 1, 12));
        this.JDFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Final", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JDFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFechaF.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: Salud_Ocupacional.JIFFInformes.1
            public void mouseClicked(MouseEvent evt) {
                JIFFInformes.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: Salud_Ocupacional.JIFFInformes.2
            public void actionPerformed(ActionEvent evt) {
                JIFFInformes.this.JBTExportarActionPerformed(evt);
            }
        });
        this.JLCantidad.setFont(new Font("Arial", 1, 18));
        this.JLCantidad.setForeground(Color.red);
        this.JLCantidad.setHorizontalAlignment(0);
        this.JLCantidad.setBorder(BorderFactory.createTitledBorder((Border) null, "Cantidad", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTPDatos.setForeground(Color.red);
        this.JTPDatos.setFont(new Font("Arial", 1, 14));
        this.JSPTDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JSPTDetalle.setViewportView(this.JTDetalle);
        this.JTPDatos.addTab("DETALLE", this.JSPTDetalle);
        this.JSPTConsolidado.setBorder(BorderFactory.createTitledBorder(""));
        this.JTConsolidado.setFont(new Font("Arial", 1, 12));
        this.JTConsolidado.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTConsolidado.setSelectionBackground(new Color(255, 255, 255));
        this.JTConsolidado.setSelectionForeground(new Color(255, 0, 0));
        this.JSPTConsolidado.setViewportView(this.JTConsolidado);
        this.JBImprimir.setFont(new Font("Arial", 1, 14));
        this.JBImprimir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Imprimir.png")));
        this.JBImprimir.setText("Imprimir");
        this.JBImprimir.addActionListener(new ActionListener() { // from class: Salud_Ocupacional.JIFFInformes.3
            public void actionPerformed(ActionEvent evt) {
                JIFFInformes.this.JBImprimirActionPerformed(evt);
            }
        });
        this.JSPTConsolidadoGeneral.setBorder(BorderFactory.createTitledBorder((Border) null, "GENERAL POR CLIENTE", 2, 0, new Font("Arial", 1, 14), new Color(0, 107, 0)));
        this.JTConsolidadoGeneral.setFont(new Font("Arial", 1, 12));
        this.JTConsolidadoGeneral.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTConsolidadoGeneral.setSelectionBackground(new Color(255, 255, 255));
        this.JTConsolidadoGeneral.setSelectionForeground(new Color(255, 0, 0));
        this.JSPTConsolidadoGeneral.setViewportView(this.JTConsolidadoGeneral);
        this.JLRealizadas.setFont(new Font("Arial", 1, 14));
        this.JLRealizadas.setForeground(new Color(255, 0, 0));
        this.JLRealizadas.setHorizontalAlignment(0);
        this.JLRealizadas.setText("0");
        this.JLRealizadas.setBorder(BorderFactory.createTitledBorder((Border) null, "Total Realizadas", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JLPosAlc.setFont(new Font("Arial", 1, 14));
        this.JLPosAlc.setForeground(new Color(255, 0, 0));
        this.JLPosAlc.setHorizontalAlignment(0);
        this.JLPosAlc.setText("0");
        this.JLPosAlc.setBorder(BorderFactory.createTitledBorder((Border) null, "Positivas Alcohol", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JLPosDro.setFont(new Font("Arial", 1, 14));
        this.JLPosDro.setForeground(new Color(255, 0, 0));
        this.JLPosDro.setHorizontalAlignment(0);
        this.JLPosDro.setText("0");
        this.JLPosDro.setBorder(BorderFactory.createTitledBorder((Border) null, "Positivas Drogas", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JLPorcentaje.setFont(new Font("Arial", 1, 14));
        this.JLPorcentaje.setForeground(new Color(255, 0, 0));
        this.JLPorcentaje.setHorizontalAlignment(0);
        this.JLPorcentaje.setText("0");
        this.JLPorcentaje.setBorder(BorderFactory.createTitledBorder((Border) null, "% Positivas AyD", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JBImprimir, -1, -1, 32767).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPTConsolidado, -2, 974, -2).addComponent(this.JSPTConsolidadoGeneral, -2, 974, -2).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JLRealizadas, -2, 124, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JLPosAlc, -2, 124, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JLPosDro, -2, 124, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JLPorcentaje, -2, 124, -2))).addGap(0, 0, 32767))).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.JSPTConsolidado, -2, 270, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPTConsolidadoGeneral, -2, 122, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLRealizadas, -1, -1, 32767).addComponent(this.JLPosAlc, -1, 51, 32767).addComponent(this.JLPosDro, GroupLayout.Alignment.TRAILING, -1, 51, 32767).addComponent(this.JLPorcentaje, -1, 51, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBImprimir, -2, 33, -2)));
        this.JTPDatos.addTab("CONSOLIDADO", this.jPanel1);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.JDFechaI, -2, 115, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JDFechaF, -2, 115, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JLCantidad, -2, 124, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)).addComponent(this.JTPDatos, -1, 1173, 32767).addGroup(layout.createSequentialGroup().addComponent(this.JTFRuta, -2, 398, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTExportar, -2, 201, -2).addGap(0, 0, 32767))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(8, 8, 8).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JDFechaI, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.JDFechaF, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.JLCantidad, GroupLayout.Alignment.LEADING, -1, -1, 32767)).addGap(10, 10, 10).addComponent(this.JTPDatos).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFRuta, -2, 50, -2).addComponent(this.JBTExportar, -2, 47, -2)).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaMouseClicked(MouseEvent evt) {
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
    public void JBTExportarActionPerformed(ActionEvent evt) {
        if (this.xnombre.equals("xjifaydInf") || this.xnombre.equals("xjifaydInfe")) {
            mExportarInformacion1();
            return;
        }
        if (this.xnombre.equals("xjiftestfatigaInf") || this.xnombre.equals("xjiftestfatigaInfe")) {
            mExportarInformacion2();
        } else if (this.xnombre.equals("xjiftestfatigaInf1") || this.xnombre.equals("xjiftestfatigaInf2") || this.xnombre.equals("xjif_interpreacionesrx") || this.xnombre.equals("CIS20")) {
            this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTDetalle, this.JTFRuta.getText(), getTitle());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBImprimirActionPerformed(ActionEvent evt) {
        mImprimir();
    }

    private void mImprimir() {
        String[][] mparametros = new String[4][2];
        mparametros[0][0] = "FECHAI";
        mparametros[0][1] = this.xmt.formatoAMD.format(this.JDFechaI.getDate());
        mparametros[1][0] = "FECHAF";
        mparametros[1][1] = this.xmt.formatoAMD.format(this.JDFechaF.getDate());
        mparametros[2][0] = "SUBREPORT_DIR";
        mparametros[2][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
        mparametros[3][0] = "SUBREPORTFIRMA_DIR";
        mparametros[3][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
        if (this.xnombre.equals("xjifaydInf") || this.xnombre.equals("xjifaydInfe")) {
            this.xmt.GenerarPDF(this.xmt.getRutaRep() + "H_So_ConsolidadoAtencionesAyD", mparametros);
        } else if (this.xnombre.equals("xjiftestfatigaInf") || this.xnombre.equals("xjiftestfatigaInfe")) {
            this.xmt.GenerarPDF(this.xmt.getRutaRep() + "H_So_ConsolidadoAtencionesTFatiga", mparametros);
        }
    }

    private void mExportarInformacion1() {
        if (this.JTDetalle.getRowCount() > 0) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "Confirmación", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                try {
                    WritableWorkbook workbook = Workbook.createWorkbook(new File(this.JTFRuta.getText() + ".xls"));
                    WritableSheet sheet = workbook.createSheet("Detalle", 0);
                    for (int x = 0; x < this.JTDetalle.getColumnCount(); x++) {
                        sheet.addCell(new Label(x, 0, this.JTDetalle.getColumnName(x)));
                    }
                    int y = 1;
                    for (int x2 = 0; x2 < this.JTDetalle.getRowCount(); x2++) {
                        sheet.addCell(new Number(0, y, Integer.valueOf(this.xmodelo.getValueAt(x2, 0).toString()).intValue()));
                        sheet.addCell(new Label(1, y, this.xmodelo.getValueAt(x2, 1).toString()));
                        sheet.addCell(new Label(2, y, this.xmodelo.getValueAt(x2, 2).toString()));
                        sheet.addCell(new Label(3, y, this.xmodelo.getValueAt(x2, 3).toString()));
                        sheet.addCell(new Label(4, y, this.xmodelo.getValueAt(x2, 4).toString()));
                        sheet.addCell(new Label(5, y, this.xmodelo.getValueAt(x2, 5).toString()));
                        sheet.addCell(new Label(6, y, this.xmodelo.getValueAt(x2, 6).toString()));
                        sheet.addCell(new Label(7, y, this.xmodelo.getValueAt(x2, 7).toString()));
                        sheet.addCell(new Label(8, y, this.xmodelo.getValueAt(x2, 8).toString()));
                        sheet.addCell(new Label(9, y, this.xmodelo.getValueAt(x2, 9).toString()));
                        sheet.addCell(new Label(10, y, this.xmodelo.getValueAt(x2, 10).toString()));
                        sheet.addCell(new Label(11, y, this.xmodelo.getValueAt(x2, 11).toString()));
                        sheet.addCell(new Label(12, y, this.xmodelo.getValueAt(x2, 12).toString()));
                        sheet.addCell(new Label(13, y, this.xmodelo.getValueAt(x2, 13).toString()));
                        sheet.addCell(new Label(14, y, this.xmodelo.getValueAt(x2, 14).toString()));
                        sheet.addCell(new Label(15, y, this.xmodelo.getValueAt(x2, 15).toString()));
                        sheet.addCell(new Label(16, y, this.xmodelo.getValueAt(x2, 16).toString()));
                        sheet.addCell(new Label(17, y, this.xmodelo.getValueAt(x2, 17).toString()));
                        sheet.addCell(new Label(18, y, this.xmodelo.getValueAt(x2, 18).toString()));
                        sheet.addCell(new Label(19, y, this.xmodelo.getValueAt(x2, 19).toString()));
                        sheet.addCell(new Label(20, y, this.xmodelo.getValueAt(x2, 20).toString()));
                        sheet.addCell(new Label(21, y, this.xmodelo.getValueAt(x2, 21).toString()));
                        sheet.addCell(new Label(22, y, this.xmodelo.getValueAt(x2, 22).toString()));
                        sheet.addCell(new Label(23, y, this.xmodelo.getValueAt(x2, 23).toString()));
                        sheet.addCell(new Label(24, y, this.xmodelo.getValueAt(x2, 24).toString()));
                        sheet.addCell(new Label(25, y, this.xmodelo.getValueAt(x2, 25).toString()));
                        sheet.addCell(new Label(26, y, this.xmodelo.getValueAt(x2, 26).toString()));
                        y++;
                    }
                    if (this.xmodelogeneral.getRowCount() >= 0) {
                        WritableSheet sheet2 = workbook.createSheet("Consolidado General x Clientes", 1);
                        for (int x3 = 0; x3 < this.JTConsolidadoGeneral.getColumnCount(); x3++) {
                            sheet2.addCell(new Label(x3, 0, this.JTConsolidadoGeneral.getColumnName(x3)));
                        }
                        for (int x4 = 0; x4 < this.JTConsolidadoGeneral.getRowCount(); x4++) {
                            sheet2.addCell(new Label(0, x4 + 1, this.xmodelogeneral.getValueAt(x4, 0).toString()));
                            sheet2.addCell(new Label(1, x4 + 1, this.xmodelogeneral.getValueAt(x4, 1).toString()));
                            sheet2.addCell(new Number(2, x4 + 1, Integer.valueOf(this.xmodelogeneral.getValueAt(x4, 2).toString()).intValue()));
                            sheet2.addCell(new Number(3, x4 + 1, Integer.valueOf(this.xmodelogeneral.getValueAt(x4, 3).toString()).intValue()));
                            sheet2.addCell(new Number(4, x4 + 1, Integer.valueOf(this.xmodelogeneral.getValueAt(x4, 4).toString()).intValue()));
                        }
                    }
                    workbook.write();
                    workbook.close();
                } catch (IOException ex) {
                    Logger.getLogger(JIFInformesPyP.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                } catch (WriteException e) {
                    Logger.getLogger(JIFInformesPyP.class.getName()).log(Level.SEVERE, (String) null, e);
                }
            }
        }
    }

    private void mExportarInformacion2() {
        if (this.JTDetalle.getRowCount() > 0) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "Confirmación", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                try {
                    WritableWorkbook workbook = Workbook.createWorkbook(new File(this.JTFRuta.getText() + ".xls"));
                    WritableSheet sheet = workbook.createSheet("plantilla", 0);
                    for (int x = 0; x < this.JTDetalle.getColumnCount(); x++) {
                        sheet.addCell(new Label(x, 0, this.JTDetalle.getColumnName(x)));
                    }
                    int y = 1;
                    for (int x2 = 0; x2 < this.JTDetalle.getRowCount(); x2++) {
                        sheet.addCell(new Number(0, y, Integer.valueOf(this.xmodelo.getValueAt(x2, 0).toString()).intValue()));
                        sheet.addCell(new Label(1, y, this.xmodelo.getValueAt(x2, 1).toString()));
                        sheet.addCell(new Label(2, y, this.xmodelo.getValueAt(x2, 2).toString()));
                        sheet.addCell(new Label(3, y, this.xmodelo.getValueAt(x2, 3).toString()));
                        sheet.addCell(new Label(4, y, this.xmodelo.getValueAt(x2, 4).toString()));
                        sheet.addCell(new Label(5, y, this.xmodelo.getValueAt(x2, 5).toString()));
                        sheet.addCell(new Label(6, y, this.xmodelo.getValueAt(x2, 6).toString()));
                        sheet.addCell(new Label(7, y, this.xmodelo.getValueAt(x2, 7).toString()));
                        sheet.addCell(new Label(8, y, this.xmodelo.getValueAt(x2, 8).toString()));
                        sheet.addCell(new Label(9, y, this.xmodelo.getValueAt(x2, 9).toString()));
                        sheet.addCell(new Label(10, y, this.xmodelo.getValueAt(x2, 10).toString()));
                        sheet.addCell(new Label(11, y, this.xmodelo.getValueAt(x2, 11).toString()));
                        sheet.addCell(new Label(12, y, this.xmodelo.getValueAt(x2, 12).toString()));
                        sheet.addCell(new Label(13, y, this.xmodelo.getValueAt(x2, 13).toString()));
                        sheet.addCell(new Label(14, y, this.xmodelo.getValueAt(x2, 14).toString()));
                        sheet.addCell(new Label(15, y, this.xmodelo.getValueAt(x2, 15).toString()));
                        sheet.addCell(new Label(16, y, this.xmodelo.getValueAt(x2, 16).toString()));
                        sheet.addCell(new Label(17, y, this.xmodelo.getValueAt(x2, 17).toString()));
                        sheet.addCell(new Label(18, y, this.xmodelo.getValueAt(x2, 18).toString()));
                        sheet.addCell(new Label(19, y, this.xmodelo.getValueAt(x2, 19).toString()));
                        sheet.addCell(new Label(20, y, this.xmodelo.getValueAt(x2, 20).toString()));
                        sheet.addCell(new Label(21, y, this.xmodelo.getValueAt(x2, 21).toString()));
                        sheet.addCell(new Label(22, y, this.xmodelo.getValueAt(x2, 22).toString()));
                        sheet.addCell(new Label(23, y, this.xmodelo.getValueAt(x2, 23).toString()));
                        y++;
                    }
                    if (!this.xnombre.equals("xjiftestfatigaInf") && !this.xnombre.equals("xjiftestfatigaInfe")) {
                        System.out.println("Entra xnombre-->" + this.xnombre);
                        WritableSheet sheet2 = workbook.createSheet("Consolidado", 1);
                        for (int x3 = 0; x3 < this.JTConsolidado.getColumnCount(); x3++) {
                            sheet2.addCell(new Label(x3, 0, this.JTConsolidado.getColumnName(x3)));
                        }
                        for (int x4 = 0; x4 < this.JTConsolidado.getRowCount(); x4++) {
                            sheet2.addCell(new Label(0, x4 + 1, this.xmodelo2.getValueAt(x4, 0).toString()));
                            sheet2.addCell(new Label(1, x4 + 1, this.xmodelo2.getValueAt(x4, 1).toString()));
                            sheet2.addCell(new Label(2, x4 + 1, this.xmodelo2.getValueAt(x4, 2).toString()));
                            sheet2.addCell(new Number(3, x4 + 1, Integer.valueOf(this.xmodelo2.getValueAt(x4, 3).toString()).intValue()));
                        }
                    }
                    workbook.write();
                    workbook.close();
                } catch (IOException ex) {
                    Logger.getLogger(JIFInformesPyP.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                } catch (WriteException e) {
                    Logger.getLogger(JIFInformesPyP.class.getName()).log(Level.SEVERE, (String) null, e);
                }
            }
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloConsGeneral() {
        this.xmodelogeneral = new DefaultTableModel(new Object[0], new String[]{"Id", "Clientes", "Realizadas", "Positivas Alcohol", "Positivas Drogas"}) { // from class: Salud_Ocupacional.JIFFInformes.4
            Class[] types = {Long.class, String.class, Integer.class, Integer.class, Integer.class};
            boolean[] canEdit = {false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTConsolidadoGeneral.setModel(this.xmodelogeneral);
        this.JTConsolidadoGeneral.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTConsolidadoGeneral.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTConsolidadoGeneral.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTConsolidadoGeneral.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTConsolidadoGeneral.getColumnModel().getColumn(2).setPreferredWidth(30);
        this.JTConsolidadoGeneral.getColumnModel().getColumn(3).setPreferredWidth(30);
        this.JTConsolidadoGeneral.getColumnModel().getColumn(4).setPreferredWidth(30);
    }

    private void mCargaCondolidadoGeneral() {
        mCrearModeloConsGeneral();
        String sql = "SELECT `so_tipo_vinculacion`.`Id` , `so_tipo_vinculacion`.`Nbre`  FROM `h_so_alcohol_drogas`  INNER JOIN  `so_tipo_vinculacion`  ON (`h_so_alcohol_drogas`.`Id_Vinculo` = `so_tipo_vinculacion`.`Id`)  WHERE (`h_so_alcohol_drogas`.`FechaR` >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND `h_so_alcohol_drogas`.`FechaR` <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "') GROUP BY `so_tipo_vinculacion`.`Nbre` ORDER BY `so_tipo_vinculacion`.`Nbre`";
        ConsultasMySQL xct = new ConsultasMySQL();
        ResultSet xrs = xct.traerRs(sql);
        try {
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelogeneral.addRow(this.xdatos);
                    this.xmodelogeneral.setValueAt(Integer.valueOf(xrs.getInt(1)), n, 0);
                    mResultados(xrs.getInt(1));
                    this.xmodelogeneral.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelogeneral.setValueAt(Integer.valueOf(this.xresultado[0]), n, 2);
                    this.xmodelogeneral.setValueAt(Integer.valueOf(this.xresultado[1]), n, 3);
                    this.xmodelogeneral.setValueAt(Integer.valueOf(this.xresultado[2]), n, 4);
                    n++;
                    this.JLRealizadas.setText((Integer.parseInt(this.JLRealizadas.getText().toString()) + this.xresultado[0]) + "");
                    this.JLPosAlc.setText((Integer.parseInt(this.JLPosAlc.getText().toString()) + this.xresultado[1]) + "");
                    this.JLPosDro.setText((Integer.parseInt(this.JLPosDro.getText().toString()) + this.xresultado[2]) + "");
                }
            }
            double suma = Double.parseDouble(this.JLPosAlc.getText().toString()) + Double.parseDouble(this.JLPosDro.getText().toString());
            double porcentaje = (suma / Double.parseDouble(this.JLRealizadas.getText().toString())) * 100.0d;
            DecimalFormat df = new DecimalFormat("#.##");
            this.JLPorcentaje.setText(df.format(porcentaje) + " %");
            xrs.close();
            xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFFInformes.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mResultados(long xid) {
        int xtotal = 0;
        int xposAlch = 0;
        int xposDro = 0;
        String totalsql = "SELECT  COUNT(`Id`) AS cantidad FROM `h_so_alcohol_drogas` WHERE (`FechaR` >= '" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND `FechaR` <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "'  AND `Id_Vinculo` ='" + xid + "')";
        ResultSet xrs = this.xct.traerRs(totalsql);
        try {
            if (xrs.next()) {
                xtotal = xrs.getInt(1);
            }
            xrs.close();
        } catch (SQLException ex) {
            Logger.getLogger(JIFFInformes.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        String posAlc = "SELECT  COUNT(`Id`) AS cantidad FROM `h_so_alcohol_drogas` WHERE (`FechaR` >= '" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND `FechaR` <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "'  AND `Id_Vinculo` ='" + xid + "' AND AResultado='POSITIVO');";
        ResultSet xrs2 = this.xct.traerRs(posAlc);
        try {
            if (xrs2.next()) {
                xposAlch = xrs2.getInt(1);
            }
            xrs2.close();
        } catch (SQLException ex2) {
            Logger.getLogger(JIFFInformes.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex2);
        }
        String posDro = "SELECT  COUNT(`Id`) AS cantidad FROM `h_so_alcohol_drogas` WHERE (`FechaR` >= '" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND `FechaR` <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "'  AND `Id_Vinculo` ='" + xid + "' AND DResultado='POSITIVO');";
        ResultSet xrs3 = this.xct.traerRs(posDro);
        try {
            if (xrs3.next()) {
                xposDro = xrs3.getInt(1);
            }
            xrs3.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex3) {
            Logger.getLogger(JIFFInformes.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex3);
        }
        this.xresultado[0] = xtotal;
        this.xresultado[1] = xposAlch;
        this.xresultado[2] = xposDro;
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCreaModeloDatos(String[] xcabecera) {
        this.xmodelo = new DefaultTableModel(new Object[0], xcabecera) { // from class: Salud_Ocupacional.JIFFInformes.5
            Class[] types = {Integer.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(15);
        this.JTDetalle.getColumnModel().getColumn(2).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(2).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(3).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(3).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(7).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(7).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(8).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(8).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(9).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(9).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(10).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(10).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(11).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(11).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(12).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(12).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(12).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(13).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(13).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(13).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(14).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(14).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(14).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(15).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(15).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(15).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(16).setPreferredWidth(15);
        this.JTDetalle.getColumnModel().getColumn(17).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(17).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(17).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(18).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(18).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(18).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(19).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(20).setPreferredWidth(5);
        this.JTDetalle.getColumnModel().getColumn(21).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(22).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(23).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(24).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(25).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(25).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(25).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(26).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(26).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(26).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(27).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(28).setPreferredWidth(100);
    }

    private void mCargarDatos() {
        try {
            String[] xencabezado = null;
            String sql = null;
            if (this.xnombre.equals("xjifaydInf") || this.xnombre.equals("xjifaydInfe")) {
                if (Principal.informacionIps.getNombreIps().equals("FUNDACIÓN PANZENÚ")) {
                    xencabezado = new String[]{"Id", "Fecha", "Sede", "Tipo Identificacion", "No. Doc", "No. HC", "Nombre Usuario", "Sexo", "Fecha Nac", "Edad", "Tipo Edad", "Tipo Sangre", "EPS", "Telefono", "Correo", " Cod. 1SAP", "Motivo de Prueba", "Vinculación", "Empresa Contratista", "Resultado Alcohol", "Valor Alcohol", "Lote Alcohol", "Resultado Drogas", "Lote Drogas", "Medicamentos", "Profesional", "Especialidad", "Url", "Unidad de Negocio"};
                    sql = "SELECT  `h_so_alcohol_drogas`.`Id`  , `h_so_alcohol_drogas`.`FechaR`  , `g_sedes`.`Nbre` AS sede  , \n`g_persona`.`Id_TipoIdentificacion`, `g_persona`.`NoDocumento`, `g_usuario`.`NoHistoria`  , CONCAT(`g_persona`.`Apellido1`,' ',`g_persona`.`Apellido2`,`g_persona`.`Nombre1`,`g_persona`.`Nombre2`) AS NUsuario, \n`g_persona`.`Id_Sexo` ,  `g_persona`.`FechaNac`,  `g_persona`.`Edad` ,  IF(`g_persona`.`Id_TipoEdad`=1,'AÑO',IF(`g_persona`.`Id_TipoEdad`=2,'MES','DÍA')) AS TipoEdad ,   IF(CONCAT(`g_persona`.`GrupoSangre`,' ',IF(g_persona.`Rh`=0, 'Negativo','Positivo'))is null,'',CONCAT(`g_persona`.`GrupoSangre`,' ',IF(g_persona.`Rh`=0, 'Negativo','Positivo'))) AS TipoSangre, \n'EPS',  ifnull(`g_persona`.`Telefono`,'') as Telefono ,  ifnull(`g_persona`.`Correo`,'') as Correo ,  `g_persona`.`Codigo1Sap`  ,  `so_tipo_motivo_prueba`.`Nbre` ,  `so_tipo_vinculacion`.`Nbre` , `h_so_alcohol_drogas`.`NEmpresa` , `h_so_alcohol_drogas`.`AResultado` , \n`h_so_alcohol_drogas`.`AValor` , `h_so_alcohol_drogas`.`ALote` , `h_so_alcohol_drogas`.`DResultado` , \n`h_so_alcohol_drogas`.`DLote`  , `h_so_alcohol_drogas`.`Medicamentos` , `profesional1`.`NProfesional` ,  `profesional1`.`Especialidad`    FROM `h_so_alcohol_drogas`  INNER JOIN `g_sedes`  ON (`h_so_alcohol_drogas`.`Id_Sede` = `g_sedes`.`Id`)  INNER JOIN `g_persona`   ON (`h_so_alcohol_drogas`.`Id_Usuario` = `g_persona`.`Id`) INNER JOIN `g_usuario`   ON (`g_persona`.`Id` = `g_usuario`.`Id_persona`)  INNER JOIN `so_tipo_motivo_prueba`  ON (`h_so_alcohol_drogas`.`Id_Motivo` = `so_tipo_motivo_prueba`.`Id`) INNER JOIN `so_tipo_vinculacion`  ON (`h_so_alcohol_drogas`.`Id_Vinculo` = `so_tipo_vinculacion`.`Id`) INNER JOIN `profesional1`  ON (`h_so_alcohol_drogas`.`Id_Profesional` = `profesional1`.`Id_Persona`)  AND (`h_so_alcohol_drogas`.`Id_Especialidad` = `profesional1`.`IdEspecialidad`) WHERE (`h_so_alcohol_drogas`.`FechaR` >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND `h_so_alcohol_drogas`.`FechaR` <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "') ORDER BY `h_so_alcohol_drogas`.`FechaR`DESC, CONCAT(`g_persona`.`Apellido1`,' ',`g_persona`.`Apellido2`,`g_persona`.`Nombre1`,`g_persona`.`Nombre2`) ASC;";
                } else {
                    xencabezado = new String[]{"Id", "Fecha", "Sede", "Tipo Identificacion", "No. Doc", "No. HC", "Nombre Usuario", "Sexo", "Fecha Nac", "Edad", "Tipo Edad", "Tipo Sangre", "EPS", "Telefono", "Correo", " Cod. 1SAP", "Motivo de Prueba", "Vinculación", "Empresa Contratista", "Resultado Alcohol", "Valor Alcohol", "Lote Alcohol", "Resultado Drogas", "Lote Drogas", "Medicamentos", "Profesional", "Especialidad", "Url"};
                    sql = "SELECT  `h_so_alcohol_drogas`.`Id`  , `h_so_alcohol_drogas`.`FechaR`  , `g_sedes`.`Nbre` AS sede  , \n`g_persona`.`Id_TipoIdentificacion`, `g_persona`.`NoDocumento`, `g_usuario`.`NoHistoria`  , CONCAT(`g_persona`.`Apellido1`,' ',`g_persona`.`Apellido2`,`g_persona`.`Nombre1`,`g_persona`.`Nombre2`) AS NUsuario, \n`g_persona`.`Id_Sexo` ,  `g_persona`.`FechaNac`,  `g_persona`.`Edad` ,  IF(`g_persona`.`Id_TipoEdad`=1,'AÑO',IF(`g_persona`.`Id_TipoEdad`=2,'MES','DÍA')) AS TipoEdad ,   IF(CONCAT(`g_persona`.`GrupoSangre`,' ',IF(g_persona.`Rh`=0, 'Negativo','Positivo'))is null,'',CONCAT(`g_persona`.`GrupoSangre`,' ',IF(g_persona.`Rh`=0, 'Negativo','Positivo'))) AS TipoSangre, \n'EPS',  ifnull(`g_persona`.`Telefono`,'') as Telefono ,  ifnull(`g_persona`.`Correo`,'') as Correo ,  `g_persona`.`Codigo1Sap`  ,  `so_tipo_motivo_prueba`.`Nbre` ,  `so_tipo_vinculacion`.`Nbre` , `h_so_alcohol_drogas`.`NEmpresa` , `h_so_alcohol_drogas`.`AResultado` , \n`h_so_alcohol_drogas`.`AValor` , `h_so_alcohol_drogas`.`ALote` , `h_so_alcohol_drogas`.`DResultado` , \n`h_so_alcohol_drogas`.`DLote`  , `h_so_alcohol_drogas`.`Medicamentos` , `profesional1`.`NProfesional` ,  `profesional1`.`Especialidad`    FROM `h_so_alcohol_drogas`  INNER JOIN `g_sedes`  ON (`h_so_alcohol_drogas`.`Id_Sede` = `g_sedes`.`Id`)  INNER JOIN `g_persona`   ON (`h_so_alcohol_drogas`.`Id_Usuario` = `g_persona`.`Id`) INNER JOIN `g_usuario`   ON (`g_persona`.`Id` = `g_usuario`.`Id_persona`)  INNER JOIN `so_tipo_motivo_prueba`  ON (`h_so_alcohol_drogas`.`Id_Motivo` = `so_tipo_motivo_prueba`.`Id`) INNER JOIN `so_tipo_vinculacion`  ON (`h_so_alcohol_drogas`.`Id_Vinculo` = `so_tipo_vinculacion`.`Id`) INNER JOIN `profesional1`  ON (`h_so_alcohol_drogas`.`Id_Profesional` = `profesional1`.`Id_Persona`)  AND (`h_so_alcohol_drogas`.`Id_Especialidad` = `profesional1`.`IdEspecialidad`) WHERE (`h_so_alcohol_drogas`.`FechaR` >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND `h_so_alcohol_drogas`.`FechaR` <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "') ORDER BY `h_so_alcohol_drogas`.`FechaR`DESC, CONCAT(`g_persona`.`Apellido1`,' ',`g_persona`.`Apellido2`,`g_persona`.`Nombre1`,`g_persona`.`Nombre2`) ASC;";
                }
            }
            mCreaModeloDatos(xencabezado);
            System.out.println(sql);
            ResultSet xrs = this.xct.traerRs(sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                int cuenta = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(Integer.valueOf(xrs.getInt(1)), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelo.setValueAt(xrs.getString(4), n, 3);
                    this.xmodelo.setValueAt(xrs.getString(5), n, 4);
                    this.xmodelo.setValueAt(xrs.getString(6), n, 5);
                    this.xmodelo.setValueAt(xrs.getString(7), n, 6);
                    this.xmodelo.setValueAt(xrs.getString(8), n, 7);
                    this.xmodelo.setValueAt(xrs.getString(9), n, 8);
                    this.xmodelo.setValueAt(xrs.getString(10), n, 9);
                    this.xmodelo.setValueAt(xrs.getString(11), n, 10);
                    this.xmodelo.setValueAt(xrs.getString(12), n, 11);
                    this.xmodelo.setValueAt(xrs.getString(13), n, 12);
                    this.xmodelo.setValueAt(xrs.getString(14), n, 13);
                    this.xmodelo.setValueAt(xrs.getString(15), n, 14);
                    this.xmodelo.setValueAt(xrs.getString(16), n, 15);
                    this.xmodelo.setValueAt(xrs.getString(17), n, 16);
                    this.xmodelo.setValueAt(xrs.getString(18), n, 17);
                    this.xmodelo.setValueAt(xrs.getString(19), n, 18);
                    this.xmodelo.setValueAt(xrs.getString(20), n, 19);
                    this.xmodelo.setValueAt(xrs.getString(21), n, 20);
                    this.xmodelo.setValueAt(xrs.getString(22), n, 21);
                    this.xmodelo.setValueAt(xrs.getString(23), n, 22);
                    this.xmodelo.setValueAt(xrs.getString(24), n, 23);
                    this.xmodelo.setValueAt(xrs.getString(25), n, 24);
                    this.xmodelo.setValueAt(xrs.getString(26), n, 25);
                    this.xmodelo.setValueAt(xrs.getString(27), n, 26);
                    n++;
                    cuenta++;
                }
                this.JLCantidad.setText("" + cuenta);
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFFInformes.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mBuscar() {
        this.JLRealizadas.setText("0");
        this.JLPosAlc.setText("0");
        this.JLPosDro.setText("0");
        this.JLPorcentaje.setText("0");
        if (this.xnombre.equals("xjifaydInf") || this.xnombre.equals("xjifaydInfe")) {
            mCargarDatos();
            mCargarDatosConsolidado();
            mCargaCondolidadoGeneral();
            return;
        }
        if (this.xnombre.equals("xjiftestfatigaInf") || this.xnombre.equals("xjiftestfatigaInfe")) {
            mCargarDatos2();
            return;
        }
        if (this.xnombre.equals("xjiftestfatigaInf1") || this.xnombre.equals("xjiftestfatigaInf2")) {
            mActualizarDatos();
            return;
        }
        if (this.xnombre.equals("xjif_interpreacionesrx")) {
            mCargar_Datos_EstudiosRx();
        } else if (this.xnombre.equals("CIS20")) {
            mCargar_CIS20();
        } else {
            mCargarDatosConsolidado();
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos2(String[] xcabecera) {
        this.xmodelo = new DefaultTableModel(new Object[0], xcabecera) { // from class: Salud_Ocupacional.JIFFInformes.6
            Class[] types = {Integer.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(2).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(2).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(6).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(6).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(7).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(7).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(8).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(8).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(9).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(9).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(10).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(10).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(11).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(11).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(12).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(12).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(12).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(13).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(13).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(13).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(14).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(14).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(14).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(15).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(16).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(17).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(18).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(19).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(20).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(21).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(21).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(21).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(22).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(22).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(22).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(23).setPreferredWidth(100);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatosConsolidado(String[] xcabecera) {
        this.xmodelo2 = new DefaultTableModel(new Object[0], xcabecera) { // from class: Salud_Ocupacional.JIFFInformes.7
            Class[] types = {String.class, String.class, String.class, Long.class};
            boolean[] canEdit = {false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTConsolidado.setModel(this.xmodelo2);
        this.JTConsolidado.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTConsolidado.getColumnModel().getColumn(1).setPreferredWidth(10);
        this.JTConsolidado.getColumnModel().getColumn(2).setPreferredWidth(150);
        this.JTConsolidado.getColumnModel().getColumn(3).setPreferredWidth(10);
    }

    private void mCargarDatosConsolidado() {
        try {
            String sql = null;
            String[] xencabezado = {"No. Documento", "No. HC", "Nombre Usuario", "Cantidad"};
            if (this.xnombre.equals("xjiftestfatigaInf") || this.xnombre.equals("xjiftestfatigaInfe")) {
                sql = "SELECT  `persona`.`NoDocumento`  , `persona`.`NoHistoria` , `persona`.`NUsuario`,COUNT( `h_so_test_fatiga`.`Id_Usuario`)AS cantidad  FROM `h_so_test_fatiga` INNER JOIN `persona`  ON (`h_so_test_fatiga`.`Id_Usuario` = `persona`.`Id_persona`)  WHERE (`h_so_test_fatiga`.`FechaT` >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "'   AND `h_so_test_fatiga`.`FechaT` <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' )GROUP BY `h_so_test_fatiga`.`Id_Usuario` ORDER BY `persona`.`NUsuario` ASC ";
            } else if (this.xnombre.equals("xjifaydInf") || this.xnombre.equals("xjifaydInfe")) {
                sql = "SELECT  `persona`.`NoDocumento`  , `persona`.`NoHistoria` , `persona`.`NUsuario`,COUNT( `h_so_alcohol_drogas`.`Id_Usuario`)AS cantidad FROM `h_so_alcohol_drogas`  INNER JOIN `persona`  ON (`h_so_alcohol_drogas`.`Id_Usuario` = `persona`.`Id_persona`) WHERE (`h_so_alcohol_drogas`.`FechaR` >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "'   AND `h_so_alcohol_drogas`.`FechaR` <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' )GROUP BY `h_so_alcohol_drogas`.`Id_Usuario` ORDER BY `persona`.`NUsuario` ASC;";
            }
            mCrearModeloDatosConsolidado(xencabezado);
            ResultSet xrs = this.xct.traerRs(sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo2.addRow(this.xdatos);
                    this.xmodelo2.setValueAt(xrs.getString(1), n, 0);
                    this.xmodelo2.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo2.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelo2.setValueAt(Long.valueOf(xrs.getLong(4)), n, 3);
                    n++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFFInformes.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarDatos2() {
        try {
            String[] xencabezado = {"Id", "Fecha", "Tipo Identificacion", "No. Doc", "No. HC", "Nombre Usuario", "Sexo", "Fecha Nac", "Edad", "Tipo Edad", "Tipo Sangre", "EPS", "Telefono", "Correo", " Cod. 1SAP", "P1", "P2", "P3", "PTotal", "Observacion", "Riesgo", "Profesional", "Especialidad", "tipoVinculacion"};
            String sql = "SELECT h_so_test_fatiga.`Id` \n, `h_so_test_fatiga`.`FechaT` \n, gp.Id_TipoIdentificacion  as `Id_TipoIdentificacion` \n, gp.NoDocumento as `NoDocumento` \n, gu.NoHistoria as `NoHistoria` \n , concat(gp.Apellido1 ,'  ',  gp.Apellido2 ,'  ', gp.Nombre1  ,'  ', gp.Nombre2) as `NUsuario` \n , gs.Nbre  as  `NSexo` \n , gp.FechaNac  as `FechaNac` \n , Devuelve_Edad_2F(gp.FechaNac ,h_so_test_fatiga.FechaT  )as `Edad` \n , Devuelve_Tipo_Edad_2F(gp.FechaNac ,h_so_test_fatiga.FechaT  ) as `NTipoEdad` \n ,concat(gp.GrupoSangre,' ' ,if(gp.Rh=-1, '', if(gp.Rh=1, '+', '-')) )`TipoSangre`\n , ge.Nbre as `EPS` \n , gp.Telefono  as `Telefono` \n , gp.Correo  as `Corre`\n , gp.Codigo1Sap  as `Codigo1Sap` \n , `h_so_test_fatiga`.`P1` \n , `h_so_test_fatiga`.`P2`\n , `h_so_test_fatiga`.`P3` \n , `h_so_test_fatiga`.`PTotal` \n , `h_so_test_fatiga`.`Observacion` , `h_so_test_fatiga`.`Riesgo` , `profesional1`.`NProfesional`  , `profesional1`.`Especialidad`\n , ifnull(gt.Nbre,'') tipoVinculacion\n FROM `h_so_test_fatiga` \n INNER JOIN g_persona gp  ON (`h_so_test_fatiga`.`Id_Usuario` = gp.Id)\n inner join g_sexo gs on (gs.Id=gp.Id_Sexo)\n inner join g_usuario gu on (gu.Id_persona=gp.Id)\n inner join g_empresa ge on (ge.Id=gu.Id_EmpresaCont)\n left join g_usuario_fpz guf on (guf.Id_Persona=gu.Id_persona)\n left join g_tipoempresa gt on (gt.Id=guf.Id_Empresa)\n INNER JOIN `profesional1`  ON (`h_so_test_fatiga`.`I_Profesional` = `profesional1`.`Id_Persona`)\n AND (`h_so_test_fatiga`.`Id_Especialidad` = `profesional1`.`IdEspecialidad`)\n  WHERE (`h_so_test_fatiga`.`FechaT` BETWEEN '" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND'" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "')\n  ORDER BY `h_so_test_fatiga`.`FechaT` DESC, NUsuario ASC";
            System.out.println(sql);
            mCrearModeloDatos2(xencabezado);
            ResultSet xrs = this.xct.traerRs(sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                int cuenta = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(Integer.valueOf(xrs.getInt(1)), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelo.setValueAt(xrs.getString(4), n, 3);
                    this.xmodelo.setValueAt(xrs.getString(5), n, 4);
                    this.xmodelo.setValueAt(xrs.getString(6), n, 5);
                    this.xmodelo.setValueAt(xrs.getString(7), n, 6);
                    this.xmodelo.setValueAt(xrs.getString(8), n, 7);
                    this.xmodelo.setValueAt(xrs.getString(9), n, 8);
                    this.xmodelo.setValueAt(xrs.getString(10), n, 9);
                    this.xmodelo.setValueAt(xrs.getString(11), n, 10);
                    this.xmodelo.setValueAt(xrs.getString(12), n, 11);
                    this.xmodelo.setValueAt(xrs.getString(13), n, 12);
                    this.xmodelo.setValueAt(xrs.getString(14), n, 13);
                    this.xmodelo.setValueAt(xrs.getString(15), n, 14);
                    this.xmodelo.setValueAt(xrs.getString(16), n, 15);
                    this.xmodelo.setValueAt(xrs.getString(17), n, 16);
                    this.xmodelo.setValueAt(xrs.getString(18), n, 17);
                    this.xmodelo.setValueAt(xrs.getString(19), n, 18);
                    this.xmodelo.setValueAt(xrs.getString(20), n, 19);
                    this.xmodelo.setValueAt(xrs.getString(21), n, 20);
                    this.xmodelo.setValueAt(xrs.getString(22), n, 21);
                    this.xmodelo.setValueAt(xrs.getString(23), n, 22);
                    this.xmodelo.setValueAt(xrs.getString(24), n, 23);
                    n++;
                    cuenta++;
                }
                this.JLCantidad.setText("" + cuenta);
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFFInformes.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloTablaS() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Fecha", "Hora", "TD", "Documento", "Usuario", "Edad", "Sexo", "Cargo", "Seg", "Grupo", "UN", "Supervisor", "Tipo Empresa", "MC", "EA", "Conclusión", "Recomendaciones", "Concepto", "Observacion Concepto", "Fecha Audimetria", "Resultado Audimetria", "Interpretación Audiometria", "Historico Audiometria", "Fecha Espirometria", "Resultado Espirometria", "Interpretación Espirometria", "Historico Espirometria", "Fecha Visiometria", "Resultado Visiometria", "Interpretación Visiometria", "Historico Visiometria", "Fecha Osteomuscular", "Resultado Osteomuscular", "Interpretación Osteomuscular", "Historico Osteomuscular", "Fecha Radiología", "Resultado Radiología", "Interpretación Radiología", "Historico Radiología", "Fecha Hemograma", "Resultado Hemograma", "Interpretación Hemograma", "Historico Hemograma", "Fecha Esp", "Resultado Esp", "Interpretación Esp", "Historico Esp", "Fecha Hormona", "Resultado Hormona", "Interpretación Hormona", "Historico Hormona", "Creatinina", "Nitrogeno", "Empresa"}) { // from class: Salud_Ocupacional.JIFFInformes.8
            Class[] types = {Long.class, String.class, String.class, String.class, String.class, String.class, Long.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

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
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(12).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(13).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(14).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(15).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(16).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(17).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(18).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(19).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(20).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(21).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(22).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(23).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(24).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(25).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(26).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(27).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(28).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(29).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(30).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(31).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(32).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(33).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(34).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(35).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(36).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(37).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(38).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(39).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(40).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(41).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(42).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(43).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(44).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(45).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(46).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(47).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(48).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(49).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(50).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(51).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(52).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(53).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(54).setPreferredWidth(300);
    }

    public void mCargarDatosS() {
        try {
            mCrearModeloTablaS();
            this.xsql = "SELECT `Id_Atencion`, `Fecha`, `Hora`, `TD`, `Documento`, `Usuario`, `Edad`, `Sexo`, `Cargo`, `Seg`, `Grupo`, `UnidadN`, `Supervisor`, `TEmpresa`, `MC`, IF(`EA` IS NULL, '', `EA`) AS `EA`, IF(`Conclusiones` IS NULL, '',TRIM(`Conclusiones`)) AS `Conclusiones` , IF(`Recomendaciones` IS NULL,'',`Recomendaciones`)`Recomendaciones` , `Concepto`, IF(`ObservacionC` IS NULL,'', `ObservacionC`) AS `ObservacionC`  , IF(`F_Audiometria` IS NULL, '', `F_Audiometria`) AS `F_Audiometria`, IF(`RAudiometria` IS NULL, '', `RAudiometria`) AS `RAudiometria`, IF(`IAudiometria` IS NULL, '',`IAudiometria`) AS `IAudiometria`, IF(`HAudiometria` IS NULL, '',`HAudiometria`) AS `HAudiometria`,  IF(`F_Espirometria` IS NULL, '',`F_Espirometria`) AS `F_Espirometria`, IF(`REspirometria` IS NULL, '',`REspirometria`) AS `REspirometria` , IF(`IEspirometria` IS NULL,'',`IEspirometria`) AS `IEspirometria`, IF(`HEspirometria` IS NULL,'',`HEspirometria`) AS `HEspirometria` , IF(`F_Visiometria` IS NULL,'',`F_Visiometria`) AS `F_Visiometria` , IF(`RVisiometria` IS NULL,'',`RVisiometria`) AS `RVisiometria` , IF(`IVisiometria` IS NULL,'',`IVisiometria`) AS `IVisiometria`, IF(`HVisiometria` IS NULL,'',`HVisiometria`) AS `HVisiometria`, IF(`F_Noma` IS NULL, '',`F_Noma`) AS `F_Noma`, IF(`RNoma` IS NULL, '',`RNoma`) AS `RNoma`, IF(`INoma` IS NULL,'',`INoma`) AS Noma, IF(`HNoma` IS NULL,'',`HNoma`) AS HNoma, IF(`F_Radiologia` IS NULL, '', `F_Radiologia`) AS F_Radiologia,`RRadiologia` AS IRadiologia , IF(`IRadiologia` IS NULL, '', `IRadiologia`) AS ORadiologia, IF(`HRadiologia` IS NULL, '', `HRadiologia`) AS HRadiologia, IF(`F_Hemograma` IS NULL, '',`F_Hemograma`) AS `F_Hemograma`, IF(`RHemograma` IS NULL, '',`RHemograma`) AS `RHemograma`, IF(`IHemograma` IS NULL,'',`IHemograma`) AS IHemograma, IF(`HHemograma` IS NULL,'',`HHemograma`) AS HHemograma,   IF(`F_Esp` IS NULL, '',`F_Esp`) AS `F_Esp`, IF(`R_Esp` IS NULL, '',`R_Esp`) AS `R_Esp`, IF(`I_Esp` IS NULL,'',`I_Esp`) AS I_Esp , IF(`H_Esp` IS NULL,'',`H_Esp`) AS H_Esp   ,   IF(`F_Hormona` IS NULL, '',`F_Hormona`) AS `F_Hormona`, IF(`R_Hormona` IS NULL, '',`R_Hormona`) AS `R_Hormona`, IF(`I_Hormona` IS NULL,'',`I_Hormona`) AS I_Hormona , IF(`H_Hormona` IS NULL,'',`H_Hormona`) AS H_Hormona,IF(`Creatinina` IS NULL,'',`Creatinina`) AS Creatinina,IF(`Nitrogeno` IS NULL,'',`Nitrogeno`) AS Nitrogeno, EmpresaF FROM `so_tmp_consolidado` ORDER BY `Fecha` ASC, `Hora` ASC ";
            ResultSet xrs = this.xct.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.first();
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(1)), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelo.setValueAt(xrs.getString(4), n, 3);
                    this.xmodelo.setValueAt(xrs.getString(5), n, 4);
                    this.xmodelo.setValueAt(xrs.getString(6), n, 5);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(7)), n, 6);
                    this.xmodelo.setValueAt(xrs.getString(8), n, 7);
                    this.xmodelo.setValueAt(xrs.getString(9), n, 8);
                    this.xmodelo.setValueAt(xrs.getString(10), n, 9);
                    this.xmodelo.setValueAt(xrs.getString(11), n, 10);
                    this.xmodelo.setValueAt(xrs.getString(12), n, 11);
                    this.xmodelo.setValueAt(xrs.getString(13), n, 12);
                    this.xmodelo.setValueAt(xrs.getString(14), n, 13);
                    this.xmodelo.setValueAt(xrs.getString(15), n, 14);
                    this.xmodelo.setValueAt(xrs.getString(16), n, 15);
                    this.xmodelo.setValueAt(xrs.getString(17), n, 16);
                    this.xmodelo.setValueAt(xrs.getString(18), n, 17);
                    this.xmodelo.setValueAt(xrs.getString(19), n, 18);
                    this.xmodelo.setValueAt(xrs.getString(20), n, 19);
                    this.xmodelo.setValueAt(xrs.getString(21), n, 20);
                    this.xmodelo.setValueAt(xrs.getString(22), n, 21);
                    this.xmodelo.setValueAt(xrs.getString(23), n, 22);
                    this.xmodelo.setValueAt(xrs.getString(24), n, 23);
                    this.xmodelo.setValueAt(xrs.getString(25), n, 24);
                    this.xmodelo.setValueAt(xrs.getString(26), n, 25);
                    this.xmodelo.setValueAt(xrs.getString(27), n, 26);
                    this.xmodelo.setValueAt(xrs.getString(28), n, 27);
                    this.xmodelo.setValueAt(xrs.getString(29), n, 28);
                    this.xmodelo.setValueAt(xrs.getString(30), n, 29);
                    this.xmodelo.setValueAt(xrs.getString(31), n, 30);
                    this.xmodelo.setValueAt(xrs.getString(32), n, 31);
                    this.xmodelo.setValueAt(xrs.getString(33), n, 32);
                    this.xmodelo.setValueAt(xrs.getString(34), n, 33);
                    this.xmodelo.setValueAt(xrs.getString(35), n, 34);
                    this.xmodelo.setValueAt(xrs.getString(36), n, 35);
                    this.xmodelo.setValueAt(xrs.getString(37), n, 36);
                    this.xmodelo.setValueAt(xrs.getString(38), n, 37);
                    this.xmodelo.setValueAt(xrs.getString(39), n, 38);
                    this.xmodelo.setValueAt(xrs.getString(40), n, 39);
                    this.xmodelo.setValueAt(xrs.getString(41), n, 40);
                    this.xmodelo.setValueAt(xrs.getString(42), n, 41);
                    this.xmodelo.setValueAt(xrs.getString(43), n, 42);
                    this.xmodelo.setValueAt(xrs.getString(44), n, 43);
                    this.xmodelo.setValueAt(xrs.getString(45), n, 44);
                    this.xmodelo.setValueAt(xrs.getString(46), n, 45);
                    this.xmodelo.setValueAt(xrs.getString(47), n, 46);
                    this.xmodelo.setValueAt(xrs.getString(48), n, 47);
                    this.xmodelo.setValueAt(xrs.getString(49), n, 48);
                    this.xmodelo.setValueAt(xrs.getString(50), n, 49);
                    this.xmodelo.setValueAt(xrs.getString(51), n, 50);
                    this.xmodelo.setValueAt(xrs.getString(52), n, 51);
                    this.xmodelo.setValueAt(xrs.getString(53), n, 52);
                    this.xmodelo.setValueAt(xrs.getString(54), n, 53);
                    this.xmodelo.setValueAt(xrs.getString(55), n, 54);
                    n++;
                }
                this.JLCantidad.setText("" + n);
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFFInformes.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mActualizarDatos() {
        this.xsql = "DELETE FROM `so_tmp_consolidado`";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "insert into so_tmp_consolidado(`Id_Atencion`,`Id_Usuario`, `Fecha`, `Hora`, `TD`, `Documento`, `Usuario`, `Edad`,`Sexo`, `Cargo`, `Seg`, `Grupo`, `UnidadN`, `Supervisor`, `TEmpresa`, `MC`, `EA`, `Conclusiones`, `Recomendaciones`, `Concepto`, `ObservacionC`, EmpresaF ) SELECT  `h_atencion`.`Id`, `persona`.`Id_persona`, `h_atencion`.`Fecha_Atencion`, `h_atencion`.`Hora_Atencion`, `persona`.`Id_TipoIdentificacion`, `persona`.`NoDocumento`, `persona`.`NUsuario`, `persona`.`Edad`, `persona`.`IdSexo`, `ingreso`.`SO_Cargo`     , `ingreso`.`SO_SEG`, `ingreso`.`SO_Grupo` , `ingreso`.`SO_UNegocio`, `ingreso`.`SO_Supervisor`, `ingreso`.`Tipo_Empresa`, `h_atencion`.`Motivo_Atencion`, `h_atencion`.`EActual`, `h_atencion`.`Conclusion`, `h_atencion`.`Recomendaciones`, `so_tipo_concepto`.`Nbre`, `h_so_concepto_laboral`.`Observacion`, `f_empresacontxconvenio`.`Nbre` FROM  `h_atencion` INNER JOIN .`ingreso`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`) INNER JOIN .`persona`  ON (`persona`.`Id_persona` = `ingreso`.`Id_Usuario`) INNER JOIN .`c_clasecita`  ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`) INNER JOIN .`h_so_concepto_laboral`  ON (`h_so_concepto_laboral`.`Id_Atencion` = `h_atencion`.`Id`) INNER JOIN .`so_tipo_concepto`  ON (`h_so_concepto_laboral`.`Id_TipoC` = `so_tipo_concepto`.`Id`) INNER JOIN `f_empresacontxconvenio`  ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`) WHERE (`h_atencion`.`Codigo_Dxp` <>'' AND `h_atencion`.`Fecha_Atencion` >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND `h_atencion`.`Fecha_Atencion` <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' AND `h_atencion`.`Id_Especialidad` =690) ORDER BY `h_atencion`.`Fecha_Atencion` ASC";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "UPDATE `so_tmp_consolidado`,`so_v_raudiometria` SET so_tmp_consolidado.`RAudiometria`=so_v_raudiometria.ResultadoM, so_tmp_consolidado.`IAudiometria`=so_v_raudiometria.ObservacionM, so_tmp_consolidado.`F_Audiometria`=so_v_raudiometria.Fecha_R  WHERE so_v_raudiometria.Id_Atencion=so_tmp_consolidado.`Id_Atencion` ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "UPDATE `so_tmp_consolidado`,`so_v_respirometria` SET so_tmp_consolidado.`REspirometria`=so_v_respirometria.ResultadoM, so_tmp_consolidado.`IEspirometria`=so_v_respirometria.ObservacionM, so_tmp_consolidado.`F_Espirometria`=so_v_respirometria.Fecha_R WHERE so_v_respirometria.Id_Atencion=so_tmp_consolidado.`Id_Atencion` ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "UPDATE `so_tmp_consolidado`,`so_v_rvisiometria` SET so_tmp_consolidado.`RVisiometria`=so_v_rvisiometria.ResultadoM, so_tmp_consolidado.`IVisiometria`=so_v_rvisiometria.ObservacionM, so_tmp_consolidado.`F_Visiometria`=so_v_rvisiometria.Fecha_R WHERE so_v_rvisiometria.Id_Atencion=so_tmp_consolidado.`Id_Atencion` ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "UPDATE `so_tmp_consolidado`,`so_v_rosteomuscular` SET so_tmp_consolidado.`RNoma`=so_v_rosteomuscular.ResultadoM, so_tmp_consolidado.`INoma`=so_v_rosteomuscular.ObservacionM, so_tmp_consolidado.`F_Noma`=so_v_rosteomuscular.Fecha_R WHERE so_v_rosteomuscular.Id_Atencion=so_tmp_consolidado.`Id_Atencion` ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "UPDATE `so_tmp_consolidado`,`so_v_radiologia` SET so_tmp_consolidado.`RRadiologia`=so_v_radiologia.Resultado, so_tmp_consolidado.`IRadiologia`=so_v_radiologia.Observacion, so_tmp_consolidado.`F_Radiologia`=so_v_radiologia.Fecha_R WHERE so_v_radiologia.Id_Atencion=so_tmp_consolidado.`Id_Atencion` ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "DROP VIEW IF EXISTS so_v_tmp_lab";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "CREATE VIEW  `so_v_tmp_lab`  AS SELECT DATE_FORMAT(`l_resultados`.`FechaResult`,'%Y-%m-%d') AS FechaR, IF(`l_detallerecepcion`.`Alterado`=0,'NORMAL', 'CON HALLAZGO') AS IResultado, `l_detallerecepcion`.`Interpretacion`, `l_detallerecepcion`.`Id_Atencion`, `l_recepcion`.Id_Paciente as Id_Usuario  FROM `l_resultados` INNER JOIN `l_recepcion`  ON (`l_resultados`.`Id_Recepcion` = `l_recepcion`.`Id`) INNER JOIN  `l_detallerecepcion`  ON (`l_detallerecepcion`.`Id_Recepcion` = `l_recepcion`.`Id`) WHERE (`l_detallerecepcion`.`Id_Procedim` =902210 AND `l_detallerecepcion`.`Id_Atencion` <>0 AND `l_recepcion`.`Estado` =0 AND `l_resultados`.`Estado` =0) GROUP BY `l_recepcion`.`Id` ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "UPDATE `so_tmp_consolidado`,`so_v_tmp_lab` SET so_tmp_consolidado.`F_Hemograma`=so_v_tmp_lab.FechaR, so_tmp_consolidado.`RHemograma`=so_v_tmp_lab.IResultado, so_tmp_consolidado.`IHemograma`=so_v_tmp_lab.Interpretacion WHERE so_v_tmp_lab.Id_Atencion=so_tmp_consolidado.`Id_Atencion` ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "DROP VIEW IF EXISTS so_v_tmp_historico";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "CREATE VIEW  `so_v_tmp_historico`  AS SELECT `Id_Usuario` , GROUP_CONCAT(CONCAT(`FechaR`,'_',CAST(`IResultado` AS CHAR CHARACTER SET utf8),'_', CAST(Interpretacion AS CHAR CHARACTER SET utf8)) ORDER BY `FechaR` DESC SEPARATOR '\\n') AS HC     FROM  `so_v_tmp_lab` GROUP BY `Id_Usuario` ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "UPDATE `so_tmp_consolidado`,`so_v_tmp_historico` SET so_tmp_consolidado.`HHemograma`=so_v_tmp_historico.Hc WHERE so_v_tmp_historico.Id_Usuario=so_tmp_consolidado.`Id_Usuario` ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "DROP VIEW IF EXISTS so_v_tmp_lab";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "CREATE VIEW  `so_v_tmp_lab`  AS SELECT DATE_FORMAT(`l_resultados`.`FechaResult`,'%Y-%m-%d') AS FechaR, IF(`l_detallerecepcion`.`Alterado`=0,'NORMAL', 'CON HALLAZGO') AS IResultado, `l_detallerecepcion`.`Interpretacion`, `l_detallerecepcion`.`Id_Atencion`, `l_recepcion`.Id_Paciente as Id_Usuario  FROM `l_resultados` INNER JOIN `l_recepcion`  ON (`l_resultados`.`Id_Recepcion` = `l_recepcion`.`Id`) INNER JOIN  `l_detallerecepcion`  ON (`l_detallerecepcion`.`Id_Recepcion` = `l_recepcion`.`Id`) WHERE (`l_detallerecepcion`.`Id_Procedim` =902206 AND `l_detallerecepcion`.`Id_Atencion` <>0 AND `l_recepcion`.`Estado` =0 AND `l_resultados`.`Estado` =0) GROUP BY `l_recepcion`.`Id` ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "UPDATE `so_tmp_consolidado`,`so_v_tmp_lab` SET so_tmp_consolidado.`F_Esp`=so_v_tmp_lab.FechaR, so_tmp_consolidado.`R_Esp`=so_v_tmp_lab.IResultado, so_tmp_consolidado.`I_Esp`=so_v_tmp_lab.Interpretacion WHERE so_v_tmp_lab.Id_Atencion=so_tmp_consolidado.`Id_Atencion` ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "DROP VIEW IF EXISTS so_v_tmp_historico";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "CREATE VIEW  `so_v_tmp_historico`  AS SELECT `Id_Usuario` , GROUP_CONCAT(CONCAT(`FechaR`,'_',CAST(`IResultado` AS CHAR CHARACTER SET utf8),'_', CAST(Interpretacion AS CHAR CHARACTER SET utf8)) ORDER BY `FechaR` DESC SEPARATOR '\\n') AS HC     FROM  `so_v_tmp_lab` GROUP BY `Id_Usuario` ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "UPDATE `so_tmp_consolidado`,`so_v_tmp_historico` SET so_tmp_consolidado.`H_Esp`=so_v_tmp_historico.Hc WHERE so_v_tmp_historico.Id_Usuario=so_tmp_consolidado.`Id_Usuario` ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "DROP VIEW IF EXISTS so_v_tmp_lab";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "CREATE VIEW  `so_v_tmp_lab`  AS SELECT DATE_FORMAT(`l_resultados`.`FechaResult`,'%Y-%m-%d') AS FechaR, IF(`l_detallerecepcion`.`Alterado`=0,'NORMAL', 'CON HALLAZGO') AS IResultado, `l_detallerecepcion`.`Interpretacion`, `l_detallerecepcion`.`Id_Atencion`, `l_recepcion`.Id_Paciente as Id_Usuario  FROM `l_resultados` INNER JOIN `l_recepcion`  ON (`l_resultados`.`Id_Recepcion` = `l_recepcion`.`Id`) INNER JOIN  `l_detallerecepcion`  ON (`l_detallerecepcion`.`Id_Recepcion` = `l_recepcion`.`Id`) WHERE (`l_detallerecepcion`.`Id_Procedim` =904902 AND `l_detallerecepcion`.`Id_Atencion` <>0 AND `l_recepcion`.`Estado` =0 AND `l_resultados`.`Estado` =0) GROUP BY `l_recepcion`.`Id` ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "UPDATE `so_tmp_consolidado`,`so_v_tmp_lab` SET so_tmp_consolidado.`F_Hormona`=so_v_tmp_lab.FechaR, so_tmp_consolidado.`R_Hormona`=so_v_tmp_lab.IResultado, so_tmp_consolidado.`I_Hormona`=so_v_tmp_lab.Interpretacion WHERE so_v_tmp_lab.Id_Atencion=so_tmp_consolidado.`Id_Atencion` ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "DROP VIEW IF EXISTS so_v_tmp_lab";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "CREATE VIEW  `so_v_tmp_lab`  AS SELECT DATE_FORMAT(`l_resultados`.`FechaResult`,'%Y-%m-%d') AS FechaR, IF(`l_detallerecepcion`.`Alterado`=0,'NORMAL', 'CON HALLAZGO') AS IResultado, `l_detallerecepcion`.`Interpretacion`, `l_detallerecepcion`.`Id_Atencion`, `l_recepcion`.Id_Paciente as Id_Usuario  FROM `l_resultados` INNER JOIN `l_recepcion`  ON (`l_resultados`.`Id_Recepcion` = `l_recepcion`.`Id`) INNER JOIN  `l_detallerecepcion`  ON (`l_detallerecepcion`.`Id_Recepcion` = `l_recepcion`.`Id`) WHERE (`l_detallerecepcion`.`Id_Procedim` =903825 AND `l_detallerecepcion`.`Id_Atencion` <>0 AND `l_recepcion`.`Estado` =0 AND `l_resultados`.`Estado` =0) GROUP BY `l_recepcion`.`Id` ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "DROP VIEW IF EXISTS so_v_tmp_historico";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "CREATE VIEW  `so_v_tmp_historico`  AS SELECT `Id_Usuario` , GROUP_CONCAT(CONCAT(`FechaR`,'_',CAST(`IResultado` AS CHAR CHARACTER SET utf8),'_', CAST(Interpretacion AS CHAR CHARACTER SET utf8)) ORDER BY `FechaR` DESC SEPARATOR '\\n') AS HC     FROM  `so_v_tmp_lab` GROUP BY `Id_Usuario` ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "UPDATE `so_tmp_consolidado`,`so_v_tmp_historico` SET so_tmp_consolidado.`Creatinina`=so_v_tmp_historico.Hc WHERE so_v_tmp_historico.Id_Usuario=so_tmp_consolidado.`Id_Usuario` ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "DROP VIEW IF EXISTS so_v_tmp_lab";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "CREATE VIEW  `so_v_tmp_lab`  AS SELECT DATE_FORMAT(`l_resultados`.`FechaResult`,'%Y-%m-%d') AS FechaR, IF(`l_detallerecepcion`.`Alterado`=0,'NORMAL', 'CON HALLAZGO') AS IResultado, `l_detallerecepcion`.`Interpretacion`, `l_detallerecepcion`.`Id_Atencion`, `l_recepcion`.Id_Paciente as Id_Usuario  FROM `l_resultados` INNER JOIN `l_recepcion`  ON (`l_resultados`.`Id_Recepcion` = `l_recepcion`.`Id`) INNER JOIN  `l_detallerecepcion`  ON (`l_detallerecepcion`.`Id_Recepcion` = `l_recepcion`.`Id`) WHERE (`l_detallerecepcion`.`Id_Procedim` =903856 AND `l_detallerecepcion`.`Id_Atencion` <>0 AND `l_recepcion`.`Estado` =0 AND `l_resultados`.`Estado` =0) GROUP BY `l_recepcion`.`Id` ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "DROP VIEW IF EXISTS so_v_tmp_historico";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "CREATE VIEW  `so_v_tmp_historico`  AS SELECT `Id_Usuario` , GROUP_CONCAT(CONCAT(`FechaR`,'_',CAST(`IResultado` AS CHAR CHARACTER SET utf8),'_', CAST(Interpretacion AS CHAR CHARACTER SET utf8)) ORDER BY `FechaR` DESC SEPARATOR '\\n') AS HC     FROM  `so_v_tmp_lab` GROUP BY `Id_Usuario` ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "UPDATE `so_tmp_consolidado`,`so_v_tmp_historico` SET so_tmp_consolidado.`Nitrogeno`=so_v_tmp_historico.Hc WHERE so_v_tmp_historico.Id_Usuario=so_tmp_consolidado.`Id_Usuario` ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "DROP VIEW IF EXISTS so_v_tmp_historico";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "CREATE VIEW  `so_v_tmp_historico`  AS SELECT `Id_Usuario` , GROUP_CONCAT(CONCAT(`FechaR`,'_',CAST(`IResultado` AS CHAR CHARACTER SET utf8),'_', CAST(Interpretacion AS CHAR CHARACTER SET utf8)) ORDER BY `FechaR` DESC SEPARATOR '\\n') AS HC     FROM  `so_v_tmp_lab` GROUP BY `Id_Usuario` ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "UPDATE `so_tmp_consolidado`,`so_v_tmp_historico` SET so_tmp_consolidado.`H_Hormona`=so_v_tmp_historico.Hc WHERE so_v_tmp_historico.Id_Usuario=so_tmp_consolidado.`Id_Usuario` ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "DROP VIEW IF EXISTS so_v_tmp_historico";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "DROP VIEW IF EXISTS so_v_tmp_historico";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "CREATE VIEW  `so_v_tmp_historico`  AS SELECT `Id_Usuario` , GROUP_CONCAT(CONCAT(`Fecha_R`,'_', CAST(`Resultado` AS CHAR CHARACTER SET utf8),'_', CAST(`Observacion` AS CHAR CHARACTER SET utf8)) ORDER BY `Fecha_R` DESC SEPARATOR '\\n') AS HC FROM `so_v_radiologia` GROUP BY `Id_Usuario` ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "UPDATE `so_tmp_consolidado`,`so_v_tmp_historico` SET so_tmp_consolidado.`HRadiologia`=so_v_tmp_historico.Hc WHERE so_v_tmp_historico.Id_Usuario=so_tmp_consolidado.`Id_Usuario` ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "DROP VIEW IF EXISTS so_v_tmp_historico";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "CREATE VIEW  `so_v_tmp_historico`  AS SELECT `Id_Usuario` , GROUP_CONCAT(CONCAT(`Fecha_R`,'_',CAST(`ResultadoM` AS CHAR CHARACTER SET utf8),'_',CAST(`ObservacionM` AS CHAR CHARACTER SET utf8)) ORDER BY Fecha_R DESC SEPARATOR '\\n') AS HC    FROM `so_v_raudiometria` GROUP BY `Id_Usuario` ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "UPDATE `so_tmp_consolidado`,`so_v_tmp_historico` SET so_tmp_consolidado.`HAudiometria`=so_v_tmp_historico.Hc WHERE so_v_tmp_historico.Id_Usuario=so_tmp_consolidado.`Id_Usuario` ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "DROP VIEW IF EXISTS so_v_tmp_historico";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "CREATE VIEW  `so_v_tmp_historico`  AS SELECT `Id_Usuario` , GROUP_CONCAT(CONCAT(`Fecha_R`,'_',CAST(`ResultadoM` AS CHAR CHARACTER SET utf8),'_',CAST(`ObservacionM` AS CHAR CHARACTER SET utf8)) ORDER BY Fecha_R DESC SEPARATOR '\\n') AS HC    FROM `so_v_respirometria` GROUP BY `Id_Usuario` ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "UPDATE `so_tmp_consolidado`,`so_v_tmp_historico` SET so_tmp_consolidado.`HEspirometria`=so_v_tmp_historico.Hc WHERE so_v_tmp_historico.Id_Usuario=so_tmp_consolidado.`Id_Usuario` ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "DROP VIEW IF EXISTS so_v_tmp_historico";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "CREATE VIEW  `so_v_tmp_historico`  AS SELECT `Id_Usuario` , GROUP_CONCAT(CONCAT(`Fecha_R`,'_',CAST(`ResultadoM` AS CHAR CHARACTER SET utf8),'_',CAST(`ObservacionM` AS CHAR CHARACTER SET utf8)) ORDER BY Fecha_R DESC SEPARATOR '\\n') AS HC    FROM `so_v_rvisiometria` GROUP BY `Id_Usuario` ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "UPDATE `so_tmp_consolidado`,`so_v_tmp_historico` SET so_tmp_consolidado.`HVisiometria`=so_v_tmp_historico.Hc WHERE so_v_tmp_historico.Id_Usuario=so_tmp_consolidado.`Id_Usuario` ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "DROP VIEW IF EXISTS so_v_tmp_historico";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "CREATE VIEW  `so_v_tmp_historico`  AS SELECT `Id_Usuario` , GROUP_CONCAT(CONCAT(`Fecha_R`,'_',CAST(`ResultadoM` AS CHAR CHARACTER SET utf8),'_',CAST(`ObservacionM` AS CHAR CHARACTER SET utf8)) ORDER BY Fecha_R DESC SEPARATOR '\\n') AS HC    FROM `so_v_rosteomuscular` GROUP BY `Id_Usuario` ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "UPDATE `so_tmp_consolidado`,`so_v_tmp_historico` SET so_tmp_consolidado.`HNoma`=so_v_tmp_historico.Hc WHERE so_v_tmp_historico.Id_Usuario=so_tmp_consolidado.`Id_Usuario` ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "DROP VIEW IF EXISTS so_v_tmp_lab";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "DROP VIEW IF EXISTS so_v_tmp_historico";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        mCargarDatosS();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Tipo", "N° Documento", "N° Historia", "Usuario", "Fecha Examen", "Tipo Empresa", "Observaciones"}) { // from class: Salud_Ocupacional.JIFFInformes.9
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(30);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(30);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(80);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatosCIS20() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"N° Documento", "N° Historia", "Usuario", "Parentezco", "Empresa", "Fecha Examen", "Dimensión", "Valor", "Clasificación"}) { // from class: Salud_Ocupacional.JIFFInformes.10
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(30);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(80);
    }

    public void mCargar_Datos_EstudiosRx() {
        try {
            mCrearModeloDatos();
            this.xsql = "SELECT `persona_fpz`.`Id_TipoIdentificacion` , `persona_fpz`.`NoDocumento` , `persona_fpz`.`NoHistoria` , `persona_fpz`.`NUsuario` , `h_resultadoayudasdx`.`Fecha_Examen` , `persona_fpz`.`TipoEmpresa` , IF(`h_resultadoayudasdx`.`Interpretacion` IS NULL, 'NO TIENE', `h_resultadoayudasdx`.`Interpretacion` ) AS Observaciones FROM  `h_resultadoayudasdx` INNER JOIN  `h_tipoayudadx`  ON (`h_resultadoayudasdx`.`Id_TipoAyudaDX` = `h_tipoayudadx`.`Id`) INNER JOIN `persona_fpz`  ON (`persona_fpz`.`Id_persona` = `h_resultadoayudasdx`.`Id_Usuario`) WHERE (`h_tipoayudadx`.`Id` =1  AND `h_resultadoayudasdx`.`Id_Profesional` =22703 AND `h_resultadoayudasdx`.`Anulado`=0) ORDER BY `persona_fpz`.`NUsuario` ASC ";
            ResultSet xrs = this.xct.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.first();
                xrs.beforeFirst();
                this.xmt.mEstablecerTextEditor(this.JTDetalle, 6);
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(xrs.getString(1), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelo.setValueAt(xrs.getString(4), n, 3);
                    this.xmodelo.setValueAt(xrs.getString(5), n, 4);
                    this.xmodelo.setValueAt(xrs.getString(6), n, 5);
                    this.xmodelo.setValueAt(xrs.getString(7), n, 6);
                    n++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFFInformes.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mCargar_CIS20() {
        try {
            mCrearModeloDatosCIS20();
            this.xsql = "SELECT g_persona.`NoDocumento`, g_usuario.`NoHistoria`,\nCONCAT(g_persona.`Apellido1`,' ', g_persona.`Apellido2`,' ', g_persona.`Nombre1`,' ', g_persona.`Nombre2`) AS usuario,\ng_parentesco.`Nbre` AS parentezco,\ng_tipoempresa.`Nbre` AS empresa, \nh_so_cuestionarios_encabezado.`FechaR`\n    , `so_tipo_pregunta_dimension`.`Nbre` AS `Dimension`\n    , SUM(`so_tipo_pregunta_respuesta`.`VCuantitativo`) AS `SValor`\n    , IF( `so_tipo_pregunta_dimension`.`Id` =24,\n    IF(SUM(`so_tipo_pregunta_respuesta`.`VCuantitativo`) <=31,'BAJA',IF((SUM(`so_tipo_pregunta_respuesta`.`VCuantitativo`)>31 AND SUM(`so_tipo_pregunta_respuesta`.`VCuantitativo`)<=32),'MEDIA','ALTA' )),\n    IF( `so_tipo_pregunta_dimension`.`Id` =25, IF(SUM(`so_tipo_pregunta_respuesta`.`VCuantitativo`) <=19,'BAJA',IF((SUM(`so_tipo_pregunta_respuesta`.`VCuantitativo`)>19 AND SUM(`so_tipo_pregunta_respuesta`.`VCuantitativo`)<=20),'MEDIA','ALTA' )),\n    IF( `so_tipo_pregunta_dimension`.`Id` =26, IF(SUM(`so_tipo_pregunta_respuesta`.`VCuantitativo`) <=15,'BAJA',IF((SUM(`so_tipo_pregunta_respuesta`.`VCuantitativo`)>15 AND SUM(`so_tipo_pregunta_respuesta`.`VCuantitativo`)<=16),'MEDIA','ALTA' )),\n    IF( `so_tipo_pregunta_dimension`.`Id` =27, IF(SUM(`so_tipo_pregunta_respuesta`.`VCuantitativo`) <=11,'BAJA',IF((SUM(`so_tipo_pregunta_respuesta`.`VCuantitativo`)>11 AND SUM(`so_tipo_pregunta_respuesta`.`VCuantitativo`)<=12),'MEDIA','ALTA' )),'NA'\n    )))) AS Clasificacion\nFROM\n    `h_so_cuestionario_detalle`\n    INNER JOIN `h_so_cuestionarios_encabezado`\n        ON (`h_so_cuestionario_detalle`.`Id_Cuestionario` = `h_so_cuestionarios_encabezado`.`Id`)\n    INNER JOIN `so_tipo_preguntas`\n        ON (`h_so_cuestionario_detalle`.`Id_Pregunta` = `so_tipo_preguntas`.`Id`)\n    INNER JOIN `so_tipo_cuestionario`\n        ON (`h_so_cuestionarios_encabezado`.`Id_Cuestionario` = `so_tipo_cuestionario`.`Id`)\n    INNER JOIN `so_tipo_pregunta_dimension`\n        ON (`so_tipo_preguntas`.`Id_Dimension` = `so_tipo_pregunta_dimension`.`Id`)\n    INNER JOIN `so_tipo_pregunta_dominio`\n        ON (`so_tipo_pregunta_dimension`.`Id_Dominio` = `so_tipo_pregunta_dominio`.`Id`)\n    INNER JOIN `so_tipo_respuesta`\n        ON (`h_so_cuestionario_detalle`.`Id_Respuesta` = `so_tipo_respuesta`.`Id`)\n    INNER JOIN `so_tipo_pregunta_respuesta`\n        ON (`so_tipo_pregunta_respuesta`.`Id_Pregunta` = `so_tipo_preguntas`.`Id`) AND (`so_tipo_pregunta_respuesta`.`Id_Tipo_Respuesta` = `so_tipo_respuesta`.`Id`)\n    INNER JOIN `g_persona` \n\tON (`h_so_cuestionarios_encabezado`.`Id_Usuario`=g_persona.`Id`)\n    INNER JOIN `g_usuario` \n\tON (g_persona.`Id`=g_usuario.`Id_persona`)\n    INNER JOIN `g_usuario_fpz` \n\tON (g_persona.`Id`=g_usuario_fpz.`Id_Persona`)\n     INNER JOIN `g_parentesco`\n\tON (g_usuario_fpz.`Id_Parentesco`=g_parentesco.`Id`)\n     INNER JOIN `g_tipoempresa`\n\tON (g_usuario_fpz.`Id_Empresa`=g_tipoempresa.`Id`)\n    \n WHERE (so_tipo_pregunta_dominio.`Id`=7  -- AND `h_so_cuestionarios_encabezado`.`Id` =42436\n AND h_so_cuestionarios_encabezado.`Estado`=1 AND h_so_cuestionarios_encabezado.`FechaR`>='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND h_so_cuestionarios_encabezado.`FechaR`<='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "'\n )\nGROUP BY h_so_cuestionarios_encabezado.`Id`,`so_tipo_pregunta_dimension`.`Id`\nORDER BY CONCAT(g_persona.`Apellido1`,' ', g_persona.`Apellido2`,' ', g_persona.`Nombre1`,' ', g_persona.`Nombre2`) ASC";
            System.out.println("cis20-->" + this.xsql);
            ResultSet xrs = this.xct.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.first();
                xrs.beforeFirst();
                this.xmt.mEstablecerTextEditor(this.JTDetalle, 6);
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(xrs.getString(1), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelo.setValueAt(xrs.getString(4), n, 3);
                    this.xmodelo.setValueAt(xrs.getString(5), n, 4);
                    this.xmodelo.setValueAt(xrs.getString(6), n, 5);
                    this.xmodelo.setValueAt(xrs.getString(7), n, 6);
                    this.xmodelo.setValueAt(xrs.getString(8), n, 7);
                    this.xmodelo.setValueAt(xrs.getString(9), n, 8);
                    n++;
                }
                this.JLCantidad.setText("" + n);
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFFInformes.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }
}
