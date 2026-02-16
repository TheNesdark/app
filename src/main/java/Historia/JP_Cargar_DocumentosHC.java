package Historia;

import Acceso.Principal;
import GestionDoc.JIFCargarSoporteLoteGD;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
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
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
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

/* JADX INFO: loaded from: GenomaP.jar:Historia/JP_Cargar_DocumentosHC.class */
public class JP_Cargar_DocumentosHC extends JPanel {
    private File directorio;
    private Object[] xdatos;
    private String xsql;
    private DefaultTableModel xmodelo;
    private DefaultTableModel xmodelo_pdf;
    private String[] xidespecialidad;
    private String[][] xidtipoayuda;
    private String xid_usuario;
    private String xId_Ingreso;
    private JButton JBT_Fusionar;
    private JButton JBT_UAdicionar;
    private JButton JBT_UFusionar;
    private JComboBox JCBProfesional;
    private JComboBox JCBTipoAyudaDx;
    public JDateChooser JDCFechaI;
    private JLabel JLBNArchivos1;
    private JLabel JLBNArchivos2;
    private JPanel JPIDatosCargar;
    private JPanel JPI_F_Informacion;
    private JPanel JPI_FusionarPDF;
    private JPanel JPI_UnirPdf;
    private JScrollPane JSP_Historico;
    private JScrollPane JSP_UDetalle;
    private JTable JTB_Historico;
    private JTable JTB_UDetalle;
    private JTextField JTFRuta;
    private JTextField JTFRuta1;
    private JTextField JTFRuta2;
    private JTextField JTFRuta3;
    private JTabbedPane JTP_Datos;
    private File xfile = null;
    private File xfile1 = null;
    private File xfile2 = null;
    private File xfile3 = null;
    private ConsultasMySQL xct = new ConsultasMySQL();
    private Metodos xmt = new Metodos();
    private boolean xlleno = false;
    private int xNfila = 0;

    public JP_Cargar_DocumentosHC(String xid_usuario, String xId_Ingreso) {
        this.xid_usuario = "0";
        this.xId_Ingreso = "0";
        initComponents();
        this.xid_usuario = xid_usuario;
        this.xId_Ingreso = xId_Ingreso;
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v16, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v86, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JTP_Datos = new JTabbedPane();
        this.JPIDatosCargar = new JPanel();
        this.JDCFechaI = new JDateChooser();
        this.JCBProfesional = new JComboBox();
        this.JCBTipoAyudaDx = new JComboBox();
        this.JTFRuta = new JTextField();
        this.JSP_Historico = new JScrollPane();
        this.JTB_Historico = new JTable();
        this.JPI_FusionarPDF = new JPanel();
        this.JPI_F_Informacion = new JPanel();
        this.JTFRuta1 = new JTextField();
        this.JLBNArchivos1 = new JLabel();
        this.JTFRuta2 = new JTextField();
        this.JLBNArchivos2 = new JLabel();
        this.JBT_Fusionar = new JButton();
        this.JPI_UnirPdf = new JPanel();
        this.JTFRuta3 = new JTextField();
        this.JBT_UAdicionar = new JButton();
        this.JSP_UDetalle = new JScrollPane();
        this.JTB_UDetalle = new JTable();
        this.JBT_UFusionar = new JButton();
        setName("xjif_importaciondochc");
        this.JTP_Datos.setForeground(new Color(0, 103, 0));
        this.JTP_Datos.setFont(new Font("Arial", 1, 14));
        this.JDCFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDCFechaI.setFont(new Font("Arial", 1, 12));
        this.JCBProfesional.setFont(new Font("Arial", 1, 12));
        this.JCBProfesional.setBorder(BorderFactory.createTitledBorder((Border) null, "Profesional", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTipoAyudaDx.setFont(new Font("Arial", 1, 12));
        this.JCBTipoAyudaDx.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Ayuda", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTipoAyudaDx.addItemListener(new ItemListener() { // from class: Historia.JP_Cargar_DocumentosHC.1
            public void itemStateChanged(ItemEvent evt) {
                JP_Cargar_DocumentosHC.this.JCBTipoAyudaDxItemStateChanged(evt);
            }
        });
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ruta", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: Historia.JP_Cargar_DocumentosHC.2
            public void mouseClicked(MouseEvent evt) {
                JP_Cargar_DocumentosHC.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JTFRuta.addActionListener(new ActionListener() { // from class: Historia.JP_Cargar_DocumentosHC.3
            public void actionPerformed(ActionEvent evt) {
                JP_Cargar_DocumentosHC.this.JTFRutaActionPerformed(evt);
            }
        });
        this.JSP_Historico.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTB_Historico.setFont(new Font("Arial", 1, 12));
        this.JTB_Historico.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTB_Historico.setRowHeight(25);
        this.JTB_Historico.setSelectionBackground(new Color(255, 255, 255));
        this.JTB_Historico.setSelectionForeground(Color.red);
        this.JTB_Historico.addMouseListener(new MouseAdapter() { // from class: Historia.JP_Cargar_DocumentosHC.4
            public void mouseClicked(MouseEvent evt) {
                JP_Cargar_DocumentosHC.this.JTB_HistoricoMouseClicked(evt);
            }
        });
        this.JTB_Historico.addKeyListener(new KeyAdapter() { // from class: Historia.JP_Cargar_DocumentosHC.5
            public void keyPressed(KeyEvent evt) {
                JP_Cargar_DocumentosHC.this.JTB_HistoricoKeyPressed(evt);
            }
        });
        this.JSP_Historico.setViewportView(this.JTB_Historico);
        GroupLayout JPIDatosCargarLayout = new GroupLayout(this.JPIDatosCargar);
        this.JPIDatosCargar.setLayout(JPIDatosCargarLayout);
        JPIDatosCargarLayout.setHorizontalGroup(JPIDatosCargarLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosCargarLayout.createSequentialGroup().addGap(14, 14, 14).addGroup(JPIDatosCargarLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTFRuta).addGroup(JPIDatosCargarLayout.createSequentialGroup().addComponent(this.JDCFechaI, -2, 140, -2).addGap(10, 10, 10).addComponent(this.JCBProfesional, -2, 359, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBTipoAyudaDx, -2, 276, -2)).addComponent(this.JSP_Historico)).addContainerGap(17, 32767)));
        JPIDatosCargarLayout.setVerticalGroup(JPIDatosCargarLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosCargarLayout.createSequentialGroup().addGap(11, 11, 11).addGroup(JPIDatosCargarLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JDCFechaI, -2, 50, -2).addGroup(JPIDatosCargarLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBProfesional, -2, 50, -2).addComponent(this.JCBTipoAyudaDx, -2, 50, -2))).addGap(26, 26, 26).addComponent(this.JTFRuta, -2, 50, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSP_Historico, -1, 376, 32767).addContainerGap()));
        this.JTP_Datos.addTab("DATOS A CARGAR", this.JPIDatosCargar);
        this.JPI_F_Informacion.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACION BASE", 0, 0, new Font("Arial", 1, 14), Color.red));
        this.JTFRuta1.setFont(new Font("Arial", 1, 12));
        this.JTFRuta1.setBorder(BorderFactory.createTitledBorder((Border) null, "Ruta (Directorio 1)", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta1.addMouseListener(new MouseAdapter() { // from class: Historia.JP_Cargar_DocumentosHC.6
            public void mouseClicked(MouseEvent evt) {
                JP_Cargar_DocumentosHC.this.JTFRuta1MouseClicked(evt);
            }
        });
        this.JLBNArchivos1.setFont(new Font("Arial", 1, 18));
        this.JLBNArchivos1.setForeground(new Color(0, 102, 51));
        this.JLBNArchivos1.setHorizontalAlignment(0);
        this.JTFRuta2.setFont(new Font("Arial", 1, 12));
        this.JTFRuta2.setBorder(BorderFactory.createTitledBorder((Border) null, "Ruta (Directorio 2)", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta2.addMouseListener(new MouseAdapter() { // from class: Historia.JP_Cargar_DocumentosHC.7
            public void mouseClicked(MouseEvent evt) {
                JP_Cargar_DocumentosHC.this.JTFRuta2MouseClicked(evt);
            }
        });
        this.JLBNArchivos2.setFont(new Font("Arial", 1, 18));
        this.JLBNArchivos2.setForeground(new Color(0, 102, 51));
        this.JLBNArchivos2.setHorizontalAlignment(0);
        this.JBT_Fusionar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBT_Fusionar.addActionListener(new ActionListener() { // from class: Historia.JP_Cargar_DocumentosHC.8
            public void actionPerformed(ActionEvent evt) {
                JP_Cargar_DocumentosHC.this.JBT_FusionarActionPerformed(evt);
            }
        });
        GroupLayout JPI_F_InformacionLayout = new GroupLayout(this.JPI_F_Informacion);
        this.JPI_F_Informacion.setLayout(JPI_F_InformacionLayout);
        JPI_F_InformacionLayout.setHorizontalGroup(JPI_F_InformacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_F_InformacionLayout.createSequentialGroup().addContainerGap().addGroup(JPI_F_InformacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JBT_Fusionar, -1, -1, 32767).addGroup(GroupLayout.Alignment.TRAILING, JPI_F_InformacionLayout.createSequentialGroup().addComponent(this.JLBNArchivos1, -1, -1, 32767).addGap(10, 10, 10).addComponent(this.JLBNArchivos2, -2, 384, -2)).addGroup(JPI_F_InformacionLayout.createSequentialGroup().addComponent(this.JTFRuta1, -2, 384, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFRuta2, -2, 384, -2).addGap(0, 0, 32767))).addContainerGap()));
        JPI_F_InformacionLayout.setVerticalGroup(JPI_F_InformacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_F_InformacionLayout.createSequentialGroup().addContainerGap().addGroup(JPI_F_InformacionLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFRuta1, -2, 56, -2).addComponent(this.JTFRuta2, -2, 56, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPI_F_InformacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLBNArchivos2, -2, 29, -2).addComponent(this.JLBNArchivos1, -2, 29, -2)).addGap(18, 18, 18).addComponent(this.JBT_Fusionar, -1, 46, 32767).addContainerGap()));
        GroupLayout JPI_FusionarPDFLayout = new GroupLayout(this.JPI_FusionarPDF);
        this.JPI_FusionarPDF.setLayout(JPI_FusionarPDFLayout);
        JPI_FusionarPDFLayout.setHorizontalGroup(JPI_FusionarPDFLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_FusionarPDFLayout.createSequentialGroup().addContainerGap().addComponent(this.JPI_F_Informacion, -2, 806, 32767).addContainerGap()));
        JPI_FusionarPDFLayout.setVerticalGroup(JPI_FusionarPDFLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_FusionarPDFLayout.createSequentialGroup().addContainerGap().addComponent(this.JPI_F_Informacion, -2, -1, -2).addContainerGap(321, 32767)));
        this.JTP_Datos.addTab("FUSIONAR IMAGENES EN PDF", this.JPI_FusionarPDF);
        this.JTFRuta3.setFont(new Font("Arial", 1, 12));
        this.JTFRuta3.setBorder(BorderFactory.createTitledBorder((Border) null, "Ruta", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta3.addMouseListener(new MouseAdapter() { // from class: Historia.JP_Cargar_DocumentosHC.9
            public void mouseClicked(MouseEvent evt) {
                JP_Cargar_DocumentosHC.this.JTFRuta3MouseClicked(evt);
            }
        });
        this.JBT_UAdicionar.setFont(new Font("Arial", 1, 12));
        this.JBT_UAdicionar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBT_UAdicionar.setText("Adicionar");
        this.JBT_UAdicionar.addActionListener(new ActionListener() { // from class: Historia.JP_Cargar_DocumentosHC.10
            public void actionPerformed(ActionEvent evt) {
                JP_Cargar_DocumentosHC.this.JBT_UAdicionarActionPerformed(evt);
            }
        });
        this.JSP_UDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTB_UDetalle.setFont(new Font("Arial", 1, 12));
        this.JTB_UDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTB_UDetalle.setRowHeight(25);
        this.JTB_UDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTB_UDetalle.setSelectionForeground(Color.red);
        this.JTB_UDetalle.addKeyListener(new KeyAdapter() { // from class: Historia.JP_Cargar_DocumentosHC.11
            public void keyPressed(KeyEvent evt) {
                JP_Cargar_DocumentosHC.this.JTB_UDetalleKeyPressed(evt);
            }
        });
        this.JSP_UDetalle.setViewportView(this.JTB_UDetalle);
        this.JBT_UFusionar.setFont(new Font("Arial", 1, 12));
        this.JBT_UFusionar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/actualizar.png")));
        this.JBT_UFusionar.setText("Fusionar");
        this.JBT_UFusionar.addActionListener(new ActionListener() { // from class: Historia.JP_Cargar_DocumentosHC.12
            public void actionPerformed(ActionEvent evt) {
                JP_Cargar_DocumentosHC.this.JBT_UFusionarActionPerformed(evt);
            }
        });
        GroupLayout JPI_UnirPdfLayout = new GroupLayout(this.JPI_UnirPdf);
        this.JPI_UnirPdf.setLayout(JPI_UnirPdfLayout);
        JPI_UnirPdfLayout.setHorizontalGroup(JPI_UnirPdfLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_UnirPdfLayout.createSequentialGroup().addContainerGap().addGroup(JPI_UnirPdfLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_UnirPdfLayout.createSequentialGroup().addComponent(this.JTFRuta3).addGap(18, 18, 18).addComponent(this.JBT_UAdicionar, -2, 193, -2)).addComponent(this.JSP_UDetalle, -1, 806, 32767).addComponent(this.JBT_UFusionar, -1, -1, 32767)).addContainerGap()));
        JPI_UnirPdfLayout.setVerticalGroup(JPI_UnirPdfLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_UnirPdfLayout.createSequentialGroup().addGap(40, 40, 40).addGroup(JPI_UnirPdfLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JBT_UAdicionar, -1, -1, 32767).addComponent(this.JTFRuta3, -1, 50, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSP_UDetalle, -2, 285, -2).addGap(28, 28, 28).addComponent(this.JBT_UFusionar, -1, -1, 32767).addGap(76, 76, 76)));
        this.JTP_Datos.addTab("UNIR PDF", this.JPI_UnirPdf);
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTP_Datos, -2, 831, -2).addContainerGap(-1, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTP_Datos).addContainerGap()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JFileChooser xfilec = new JFileChooser(this.JTFRuta.getText());
            int xv = xfilec.showOpenDialog(this);
            if (xv == 0) {
                this.xfile = xfilec.getSelectedFile();
                this.JTFRuta.setText(this.xmt.mTraerUrlBD(this.xfile.getAbsolutePath()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRuta1MouseClicked(MouseEvent evt) {
        JFileChooser xfilec;
        if (evt.getClickCount() == 2) {
            this.xct.traerDato("SELECT DevuelveMes('" + this.xmt.formatoAMD.format(this.xmt.getFechaActual()) + "')");
            this.xct.cerrarConexionBd();
            if (Principal.informacionIps.getNombreIps().equals("CLINICA OFTALMOLOGICA DAJUD SAS")) {
                xfilec = new JFileChooser("F:\\Backup_Baseserver\\Dajud\\Examenes\\GOMEZ  LOPEZ  EDUARDO ENRIQUE\\OD");
            } else {
                xfilec = new JFileChooser("C:\\Backup_Baseserver\\Dajud\\Examenes\\GOMEZ  LOPEZ  EDUARDO ENRIQUE\\OD");
            }
            xfilec.setFileSelectionMode(1);
            int xv = xfilec.showOpenDialog(this);
            if (xv == 0) {
                this.xfile1 = xfilec.getSelectedFile();
                String xprevio = this.xfile1.getAbsolutePath() + "\\";
                this.JTFRuta1.setText(this.xmt.mTraerUrlBD(xprevio));
                String[] ficheros = this.xfile1.list();
                if (ficheros == null) {
                    this.JLBNArchivos1.setText("Archivos Encontrados : 0");
                } else {
                    this.JLBNArchivos1.setText("Archivos Encontrados : " + String.valueOf(ficheros.length));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRuta2MouseClicked(MouseEvent evt) {
        JFileChooser xfilec;
        if (evt.getClickCount() == 2) {
            this.xct.traerDato("SELECT DevuelveMes('" + this.xmt.formatoAMD.format(this.xmt.getFechaActual()) + "')");
            this.xct.cerrarConexionBd();
            if (Principal.informacionIps.getNombreIps().equals("CLINICA OFTALMOLOGICA DAJUD SAS")) {
                xfilec = new JFileChooser("F:\\Backup_Baseserver\\Dajud\\Examenes\\GOMEZ  LOPEZ  EDUARDO ENRIQUE\\OI");
            } else {
                xfilec = new JFileChooser("F:\\Backup_Baseserver\\Dajud\\Examenes\\GOMEZ  LOPEZ  EDUARDO ENRIQUE\\OI");
            }
            xfilec.setFileSelectionMode(1);
            int xv = xfilec.showOpenDialog(this);
            if (xv == 0) {
                this.xfile2 = xfilec.getSelectedFile();
                String xprevio = this.xfile2.getAbsolutePath() + "\\";
                this.JTFRuta2.setText(this.xmt.mTraerUrlBD(xprevio));
                String[] ficheros = this.xfile2.list();
                if (ficheros == null) {
                    this.JLBNArchivos2.setText("Archivos Encontrados : 0");
                } else {
                    this.JLBNArchivos2.setText("Archivos Encontrados : " + String.valueOf(ficheros.length));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_FusionarActionPerformed(ActionEvent evt) {
        if (this.JCBTipoAyudaDx.getSelectedIndex() != -1) {
            if (!this.JTFRuta1.getText().isEmpty() || !this.JTFRuta2.getText().isEmpty()) {
                mCrear_Pdf();
                return;
            }
            return;
        }
        JOptionPane.showMessageDialog(this, "Debe seleccionar un tipo de ayuda dx", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
        this.JTP_Datos.setSelectedIndex(0);
        this.JCBTipoAyudaDx.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTB_HistoricoMouseClicked(MouseEvent evt) {
        if (this.JTB_Historico.getSelectedRow() != -1 && evt.getClickCount() == 2) {
            if (Principal.informacionIps.getEsFpz().intValue() == 0) {
                this.xmt.mostrarPdf(this.xmodelo.getValueAt(this.JTB_Historico.getSelectedRow(), 4).toString());
            } else {
                this.xmt.mostrarPdf(this.xmt.mRutaSoporte("JPEscaneoDocumentosEnf") + "\\" + this.xmodelo.getValueAt(this.JTB_Historico.getSelectedRow(), 4).toString());
            }
            Principal.mGrabarLogAtenciones(this.JTB_Historico.getValueAt(this.JTB_Historico.getSelectedRow(), 2).toString().toUpperCase() + " DIGITALIZADO", this.JTB_Historico.getValueAt(this.JTB_Historico.getSelectedRow(), 0).toString(), this.xid_usuario);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBTipoAyudaDxItemStateChanged(ItemEvent evt) {
        if (this.xlleno && this.JCBTipoAyudaDx.getSelectedIndex() != -1) {
            this.JTFRuta.setText(this.xmt.mTraerUrlBD(this.xidtipoayuda[this.JCBTipoAyudaDx.getSelectedIndex()][1]));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRuta3MouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JFileChooser xfilec = new JFileChooser(this.JTFRuta3.getText());
            FileNameExtensionFilter filter = new FileNameExtensionFilter("PDF", new String[]{"pdf"});
            xfilec.setFileFilter(filter);
            int xv = xfilec.showOpenDialog(this);
            if (xv == 0) {
                this.xfile3 = xfilec.getSelectedFile();
                this.JTFRuta3.setText(this.xmt.mTraerUrlBD(this.xfile3.getAbsolutePath()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_UAdicionarActionPerformed(ActionEvent evt) {
        if (!this.JTFRuta3.getText().isEmpty()) {
            if (this.JTFRuta3.getText().substring(this.JTFRuta3.getText().length() - 3, this.JTFRuta3.getText().length()).equals("pdf")) {
                this.xmodelo_pdf.addRow(this.xdatos);
                this.xmodelo_pdf.setValueAt(this.JTFRuta3.getText(), this.xNfila, 0);
                this.xNfila++;
                return;
            }
            JOptionPane.showMessageDialog(this, "El tipo de archivo no es valido", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
            return;
        }
        JOptionPane.showMessageDialog(this, "La ruta no puede ser nula", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
        this.JTFRuta3.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTB_UDetalleKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 127 && this.JTB_UDetalle.getSelectedRow() != -1) {
            int xl = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de eliminar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (xl == 0) {
                this.xmodelo_pdf.removeRow(this.JTB_UDetalle.getSelectedRow());
                this.xNfila--;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_UFusionarActionPerformed(ActionEvent evt) {
        if (this.JCBTipoAyudaDx.getSelectedIndex() != -1) {
            if (!this.JTFRuta.getText().isEmpty()) {
                if (this.JTB_UDetalle.getRowCount() > 1) {
                    try {
                        List<InputStream> pdfs = new ArrayList<>();
                        for (int x = 0; x < this.JTB_UDetalle.getRowCount(); x++) {
                            pdfs.add(new FileInputStream(this.xmodelo_pdf.getValueAt(x, 0).toString()));
                        }
                        this.JTFRuta.setText(this.JTFRuta.getText() + "\\" + this.xId_Ingreso + "_" + this.JCBTipoAyudaDx.getSelectedItem() + ".pdf");
                        OutputStream output = new FileOutputStream(this.JTFRuta.getText());
                        this.xmt.mConcatenar_PDF(pdfs, output, this.xlleno);
                        return;
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(JP_Cargar_DocumentosHC.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                        return;
                    }
                }
                JOptionPane.showMessageDialog(this, "Archivos a fusionar deben ser mayor a uno", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                this.JTP_Datos.setSelectedIndex(2);
                this.JTFRuta1.requestFocus();
                return;
            }
            JOptionPane.showMessageDialog(this, "La ruta no puede ser nula", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
            this.JTP_Datos.setSelectedIndex(0);
            this.JTFRuta1.requestFocus();
            return;
        }
        JOptionPane.showMessageDialog(this, "Debe seleccionar un tipo de ayuda diagnóstica", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
        this.JTP_Datos.setSelectedIndex(0);
        this.JCBTipoAyudaDx.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTB_HistoricoKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 127 && this.JTB_Historico.getSelectedRow() != -1) {
            if (this.xmodelo.getValueAt(this.JTB_Historico.getSelectedRow(), 6).toString().equals("0")) {
                int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de anular?", "CONFIRMACION", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (x == 0) {
                    this.xsql = "update h_resultadoayudasdx set  Anulado=1 where Id='" + this.xmodelo.getValueAt(this.JTB_Historico.getSelectedRow(), 0).toString() + "' ";
                    this.xct.ejecutarSQL(this.xsql);
                    this.xct.cerrarConexionBd();
                    return;
                }
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Ayuda diagnòstica ya revisada!!!", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        }
    }

    public void mNuevo() {
        this.xlleno = false;
        this.directorio = new File(this.xmt.mRutaSoporte("JPEscaneoDocumentosEnf"));
        this.JDCFechaI.setDate(this.xmt.getFechaActual());
        this.JCBTipoAyudaDx.removeAllItems();
        this.xidtipoayuda = this.xct.llenarComboyLista("SELECT Id, Nbre, UbicacionR FROM h_tipoayudadx WHERE (Estado =0) ORDER BY Nbre ASC", this.xidtipoayuda, this.JCBTipoAyudaDx, 3);
        this.JCBTipoAyudaDx.setSelectedIndex(-1);
        this.xct.cerrarConexionBd();
        this.JCBProfesional.removeAllItems();
        this.xidespecialidad = this.xct.llenarCombo("SELECT profesional.Id_Persona, profesional.NProfesional FROM  g_profesional  INNER JOIN  profesional  ON (g_profesional.Id_Persona = profesional.Id_Persona) WHERE (g_profesional.Estado =0) ORDER BY profesional.NProfesional ASC", this.xidespecialidad, this.JCBProfesional);
        this.JCBProfesional.setSelectedIndex(-1);
        this.xct.cerrarConexionBd();
        this.JTFRuta.setText("");
        mCargarDatosTabla();
        mCrearTabla_ArchivosPDF();
        this.xlleno = true;
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTablaHistorico() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Fecha", "Documento", "Profesional", "Url", "UsuarioC", "Revisado"}) { // from class: Historia.JP_Cargar_DocumentosHC.13
            Class[] types = {Long.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTB_Historico.setModel(this.xmodelo);
        this.JTB_Historico.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTB_Historico.getColumnModel().getColumn(1).setPreferredWidth(10);
        this.JTB_Historico.getColumnModel().getColumn(2).setPreferredWidth(50);
        this.JTB_Historico.getColumnModel().getColumn(3).setPreferredWidth(150);
        this.JTB_Historico.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTB_Historico.getColumnModel().getColumn(5).setPreferredWidth(0);
        this.JTB_Historico.getColumnModel().getColumn(5).setMinWidth(0);
        this.JTB_Historico.getColumnModel().getColumn(5).setMaxWidth(0);
        this.JTB_Historico.getColumnModel().getColumn(6).setPreferredWidth(0);
        this.JTB_Historico.getColumnModel().getColumn(6).setMinWidth(0);
        this.JTB_Historico.getColumnModel().getColumn(6).setMaxWidth(0);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTabla_ArchivosPDF() {
        this.xmodelo_pdf = new DefaultTableModel(new Object[0], new String[]{"Url"}) { // from class: Historia.JP_Cargar_DocumentosHC.14
            Class[] types = {String.class};
            boolean[] canEdit = {false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTB_UDetalle.setModel(this.xmodelo_pdf);
        this.JTB_UDetalle.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.xNfila = 0;
    }

    public void mCargarDatosTabla() {
        try {
            String sql = "SELECT h_resultadoayudasdx.Id , DATE_FORMAT(h_resultadoayudasdx.Fecha_Examen, '%d-%m-%Y') as fecha, h_tipoayudadx.Nbre , profesional.NProfesional, h_resultadoayudasdx.Url, h_resultadoayudasdx.Estado FROM  h_resultadoayudasdx INNER JOIN  h_tipoayudadx  ON (h_resultadoayudasdx.Id_TipoAyudaDX = h_tipoayudadx.Id) INNER JOIN  profesional  ON (profesional.Id_Persona = h_resultadoayudasdx.Id_Profesional) WHERE (h_resultadoayudasdx.Id_Usuario ='" + this.xid_usuario + "' and h_resultadoayudasdx.Anulado=0) order by h_resultadoayudasdx.Fecha_Examen desc";
            ResultSet rs = this.xct.traerRs(sql);
            mCrearTablaHistorico();
            if (rs.next()) {
                rs.beforeFirst();
                int i = 0;
                while (rs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(Long.valueOf(rs.getLong(1)), i, 0);
                    this.xmodelo.setValueAt(rs.getString(2), i, 1);
                    this.xmodelo.setValueAt(rs.getString(3), i, 2);
                    this.xmodelo.setValueAt(rs.getString(4), i, 3);
                    this.xmodelo.setValueAt(rs.getString(5), i, 4);
                    this.xmodelo.setValueAt("", i, 5);
                    this.xmodelo.setValueAt(rs.getString("Estado"), i, 6);
                    i++;
                }
            }
            rs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JP_Cargar_DocumentosHC.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mGrabar() {
        if (!this.xid_usuario.equals("0")) {
            if (this.JCBProfesional.getSelectedIndex() != -1) {
                if (this.JCBTipoAyudaDx.getSelectedIndex() != -1) {
                    if (!this.JTFRuta.getText().isEmpty()) {
                        if (Principal.informacionIps.getEsFpz().intValue() == 0) {
                            String sql = "insert into h_resultadoayudasdx (Id_Usuario, Fecha_Examen, Id_TipoAyudaDX, Id_Profesional, Url, Fecha, Id_UsuarioS, UsuarioS)  values('" + this.xid_usuario + "','" + this.xmt.formatoAMD.format(this.JDCFechaI.getDate()) + "','" + this.xidtipoayuda[this.JCBTipoAyudaDx.getSelectedIndex()][0] + "','" + this.xidespecialidad[this.JCBProfesional.getSelectedIndex()] + "','" + this.xmt.mTraerUrlBD(this.JTFRuta.getText()) + "','" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                            Principal.txtNo.setText(this.xct.ejecutarSQLId(sql));
                            this.xct.cerrarConexionBd();
                        } else {
                            this.directorio = new File(this.xmt.mRutaSoporte("JPEscaneoDocumentosEnf"));
                            String sql2 = "insert into h_resultadoayudasdx (Id_Usuario, Fecha_Examen, IdAtencion, Id_TipoAyudaDX, Id_Profesional, Fecha, Id_UsuarioS, UsuarioS)  values('" + this.xid_usuario + "','" + this.xmt.formatoAMD.format(this.JDCFechaI.getDate()) + "','0','" + this.xidtipoayuda[this.JCBTipoAyudaDx.getSelectedIndex()][0] + "','" + this.xidespecialidad[this.JCBProfesional.getSelectedIndex()] + "','" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                            String xidDoc = this.xct.ejecutarSQLId(sql2);
                            String adjunto = xidDoc + "_" + this.xid_usuario + "_" + this.JCBTipoAyudaDx.getSelectedItem() + ".pdf";
                            String sql3 = "UPDATE h_resultadoayudasdx set Url='" + this.xmt.mTraerUrlBD(adjunto) + "' WHERE Id='" + xidDoc + "'";
                            this.xct.ejecutarSQL(sql3);
                            this.xct.cerrarConexionBd();
                            File f1 = new File(this.JTFRuta.getText());
                            File f2 = new File(adjunto);
                            f1.renameTo(f2);
                            f2.renameTo(new File(this.directorio, f2.getName()));
                            Principal.txtNo.setText(xidDoc);
                        }
                        Principal.clasehistoriace.mCambiarEstadoCita();
                        Principal.clasehistoriace.mCambiarEstadoHc(1);
                        mNuevo();
                        JOptionPane.showMessageDialog(this, "Se guardo con exito", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        return;
                    }
                    JOptionPane.showMessageDialog(this, "Debe seleccionar el arhivo a cargar", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                    this.JCBTipoAyudaDx.requestFocus();
                    return;
                }
                JOptionPane.showMessageDialog(this, "Debe seleccionar un tipo de ayuda dx", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                this.JCBTipoAyudaDx.requestFocus();
                return;
            }
            JOptionPane.showMessageDialog(this, "Debe seleccionar un profesional", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
            this.JCBProfesional.requestFocus();
            return;
        }
        JOptionPane.showMessageDialog(this, "Debe cargar un usuario", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
    }

    private void mCrear_Pdf() {
        try {
            Document mipdf = new Document();
            PdfWriter.getInstance(mipdf, new FileOutputStream(new File(this.JTFRuta.getText() + this.xId_Ingreso + "_" + this.xmt.formatoDMA1.format(this.JDCFechaI.getDate()) + "_" + this.JCBTipoAyudaDx.getSelectedItem() + ".pdf")));
            mipdf.open();
            mipdf.addTitle(this.JCBTipoAyudaDx.getSelectedItem().toString());
            mipdf.addAuthor(Principal.usuarioSistemaDTO.getNombreUsuario());
            mipdf.addSubject("Documentos de historia clinica");
            mipdf.addKeywords(this.JCBTipoAyudaDx.getSelectedItem().toString());
            mipdf.add(m_Fusionador());
            mipdf.close();
        } catch (DocumentException e) {
            Logger.getLogger(JIFCargarSoporteLoteGD.class.getName()).log(Level.SEVERE, (String) null, e);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(JIFCargarSoporteLoteGD.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public PdfPTable m_Fusionador() {
        PdfPTable xArchivo_Tabla = new PdfPTable(6);
        try {
            if (this.xfile1 != null) {
                PdfPCell celda = new PdfPCell(new Paragraph("IMAGENES OJO DERECHO", FontFactory.getFont("arial", 14.0f, 1, BaseColor.RED)));
                celda.setColspan(6);
                celda.setHorizontalAlignment(1);
                celda.setPadding(12.0f);
                celda.setBackgroundColor(BaseColor.GRAY);
                xArchivo_Tabla.addCell(celda);
                String[] ficheros = this.xfile1.list();
                for (int x = 0; x <= ficheros.length - 1; x++) {
                    if (ficheros[x].substring(ficheros[x].length() - 3, ficheros[x].length()).equals("jpg")) {
                        Image imagen = Image.getInstance(this.JTFRuta1.getText() + "" + ficheros[x]);
                        PdfPCell celda2 = new PdfPCell(imagen);
                        celda2.setColspan(2);
                        xArchivo_Tabla.addCell(celda2);
                    }
                }
            }
            if (this.xfile2 != null) {
                PdfPCell celda3 = new PdfPCell();
                celda3.setColspan(6);
                xArchivo_Tabla.addCell(celda3);
                PdfPCell celda4 = new PdfPCell();
                celda4.setColspan(6);
                xArchivo_Tabla.addCell(celda4);
                PdfPCell celda5 = new PdfPCell(new Paragraph("IMAGENES OJO IZQUIERDO", FontFactory.getFont("arial", 14.0f, 1, BaseColor.RED)));
                celda5.setColspan(2);
                celda5.setHorizontalAlignment(1);
                celda5.setPadding(12.0f);
                celda5.setBackgroundColor(BaseColor.GRAY);
                xArchivo_Tabla.addCell(celda5);
                String[] ficheros2 = this.xfile2.list();
                for (int x2 = 0; x2 <= ficheros2.length - 1; x2++) {
                    if (ficheros2[x2].substring(ficheros2[x2].length() - 3, ficheros2[x2].length()).equals("jpg")) {
                        Image imagen2 = Image.getInstance(this.JTFRuta2.getText() + "" + ficheros2[x2]);
                        PdfPCell celda6 = new PdfPCell(imagen2);
                        celda6.setColspan(2);
                        xArchivo_Tabla.addCell(celda6);
                    }
                }
            }
        } catch (BadElementException e) {
            Logger.getLogger(JIFCargarSoporteLoteGD.class.getName()).log(Level.SEVERE, (String) null, e);
        } catch (IOException ex) {
            Logger.getLogger(JIFCargarSoporteLoteGD.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return xArchivo_Tabla;
    }
}
