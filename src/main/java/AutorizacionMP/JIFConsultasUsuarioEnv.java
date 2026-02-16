package AutorizacionMP;

import Laboratorio.JIFConsultasInfLab;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyVetoException;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
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
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

/* JADX INFO: loaded from: GenomaP.jar:AutorizacionMP/JIFConsultasUsuarioEnv.class */
public class JIFConsultasUsuarioEnv extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private DefaultTableModel xmodelo1;
    private DefaultTableModel xmodelo2;
    private Object[] xdatos;
    private String[] xidespecialidad;
    private String nombre;
    private ButtonGroup JBGSeleccion;
    private ButtonGroup JBGSeleccion1;
    private JButton JBTExportar;
    private JDateChooser JDFechaF;
    private JDateChooser JDFechaI;
    private JPanel JPIAgrupado;
    private JPanel JPIAgrupadoPProfes;
    private JPanel JPIAgrupadoProced;
    private JPanel JPIDatos;
    private JScrollPane JSPDetalle;
    private JScrollPane JSPDetalle1;
    private JScrollPane JSPDetalle2;
    private JTable JTDetalle;
    private JTable JTDetalle1;
    private JTable JTDetalle2;
    private JFormattedTextField JTFFNTotal;
    private JFormattedTextField JTFFNTotal_consolidado;
    private JTextField JTFRuta;
    private JTabbedPane JTPDatosA;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JPanel jPanel1;
    private ConsultasMySQL xconsulta = new ConsultasMySQL();
    private Metodos xmt = new Metodos();
    private boolean xllenoc = false;

    public JIFConsultasUsuarioEnv(String nombre) {
        initComponents();
        setName(nombre);
        this.nombre = nombre;
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v27, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v38, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v71, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGSeleccion = new ButtonGroup();
        this.JBGSeleccion1 = new ButtonGroup();
        this.JPIDatos = new JPanel();
        this.JDFechaI = new JDateChooser();
        this.JDFechaF = new JDateChooser();
        this.JTPDatosA = new JTabbedPane();
        this.JPIAgrupado = new JPanel();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JPIAgrupadoPProfes = new JPanel();
        this.JSPDetalle1 = new JScrollPane();
        this.JTDetalle1 = new JTable();
        this.JTFFNTotal = new JFormattedTextField();
        this.jLabel1 = new JLabel();
        this.jLabel2 = new JLabel();
        this.jLabel3 = new JLabel();
        this.jLabel4 = new JLabel();
        this.JPIAgrupadoProced = new JPanel();
        this.JSPDetalle2 = new JScrollPane();
        this.JTDetalle2 = new JTable();
        this.JTFFNTotal_consolidado = new JFormattedTextField();
        this.jPanel1 = new JPanel();
        this.JBTExportar = new JButton();
        this.JTFRuta = new JTextField();
        setClosable(true);
        setIconifiable(true);
        setTitle("CONSULTA USUARIOS MATRICULADOS");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setMaximumSize(null);
        setName("jifconsultausuario");
        try {
            setSelected(true);
        } catch (PropertyVetoException e1) {
            e1.printStackTrace();
        }
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JDFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicial", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFechaI.setFont(new Font("Arial", 1, 12));
        this.JDFechaI.addPropertyChangeListener(new PropertyChangeListener() { // from class: AutorizacionMP.JIFConsultasUsuarioEnv.1
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFConsultasUsuarioEnv.this.JDFechaIPropertyChange(evt);
            }
        });
        this.JDFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Final", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFechaF.setFont(new Font("Arial", 1, 12));
        this.JDFechaF.addPropertyChangeListener(new PropertyChangeListener() { // from class: AutorizacionMP.JIFConsultasUsuarioEnv.2
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFConsultasUsuarioEnv.this.JDFechaFPropertyChange(evt);
            }
        });
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JDFechaI, -2, 110, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JDFechaF, -2, 110, -2).addContainerGap(-1, 32767)));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JDFechaF, -1, -1, 32767).addComponent(this.JDFechaI, -1, -1, 32767)).addContainerGap()));
        this.JTPDatosA.setForeground(Color.red);
        this.JTPDatosA.setCursor(new Cursor(0));
        this.JTPDatosA.setFont(new Font("Arial", 1, 14));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JSPDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalle.setSelectionMode(0);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: AutorizacionMP.JIFConsultasUsuarioEnv.3
            public void mouseClicked(MouseEvent evt) {
                JIFConsultasUsuarioEnv.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        GroupLayout JPIAgrupadoLayout = new GroupLayout(this.JPIAgrupado);
        this.JPIAgrupado.setLayout(JPIAgrupadoLayout);
        JPIAgrupadoLayout.setHorizontalGroup(JPIAgrupadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIAgrupadoLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPDetalle, -1, 890, 32767).addContainerGap()));
        JPIAgrupadoLayout.setVerticalGroup(JPIAgrupadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIAgrupadoLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPDetalle, -1, 317, 32767).addContainerGap()));
        this.JTPDatosA.addTab("USUARIOS MATRICULADOS", this.JPIAgrupado);
        this.JSPDetalle1.setFont(new Font("Arial", 1, 12));
        this.JTDetalle1.setFont(new Font("Arial", 1, 12));
        this.JTDetalle1.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle1.setRowHeight(25);
        this.JTDetalle1.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle1.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalle1.setSelectionMode(0);
        this.JTDetalle1.addMouseListener(new MouseAdapter() { // from class: AutorizacionMP.JIFConsultasUsuarioEnv.4
            public void mouseClicked(MouseEvent evt) {
                JIFConsultasUsuarioEnv.this.JTDetalle1MouseClicked(evt);
            }
        });
        this.JSPDetalle1.setViewportView(this.JTDetalle1);
        this.JTFFNTotal.setEditable(false);
        this.JTFFNTotal.setBorder(BorderFactory.createTitledBorder((Border) null, "TOTAL", 0, 0, new Font("Arial", 1, 13), Color.blue));
        this.JTFFNTotal.setForeground(Color.red);
        this.JTFFNTotal.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(NumberFormat.getIntegerInstance())));
        this.JTFFNTotal.setHorizontalAlignment(0);
        this.JTFFNTotal.setFont(new Font("Arial", 1, 18));
        this.jLabel1.setBackground(new Color(251, 54, 54));
        this.jLabel1.setFont(new Font("Arial", 1, 12));
        this.jLabel1.setHorizontalAlignment(0);
        this.jLabel1.setText("No Entregada");
        this.jLabel1.setBorder(BorderFactory.createTitledBorder(""));
        this.jLabel1.setOpaque(true);
        this.jLabel2.setBackground(new Color(133, 218, 160));
        this.jLabel2.setFont(new Font("Arial", 1, 12));
        this.jLabel2.setHorizontalAlignment(0);
        this.jLabel2.setText("Entregada");
        this.jLabel2.setBorder(BorderFactory.createTitledBorder(""));
        this.jLabel2.setOpaque(true);
        this.jLabel3.setBackground(new Color(255, 255, 102));
        this.jLabel3.setFont(new Font("Arial", 1, 12));
        this.jLabel3.setHorizontalAlignment(0);
        this.jLabel3.setText("Despachada");
        this.jLabel3.setBorder(BorderFactory.createTitledBorder(""));
        this.jLabel3.setOpaque(true);
        this.jLabel4.setBackground(new Color(102, 204, 255));
        this.jLabel4.setFont(new Font("Arial", 1, 12));
        this.jLabel4.setHorizontalAlignment(0);
        this.jLabel4.setText("Empacada");
        this.jLabel4.setBorder(BorderFactory.createTitledBorder(""));
        this.jLabel4.setOpaque(true);
        GroupLayout JPIAgrupadoPProfesLayout = new GroupLayout(this.JPIAgrupadoPProfes);
        this.JPIAgrupadoPProfes.setLayout(JPIAgrupadoPProfesLayout);
        JPIAgrupadoPProfesLayout.setHorizontalGroup(JPIAgrupadoPProfesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIAgrupadoPProfesLayout.createSequentialGroup().addContainerGap().addGroup(JPIAgrupadoPProfesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPDetalle1, -1, 890, 32767).addGroup(GroupLayout.Alignment.TRAILING, JPIAgrupadoPProfesLayout.createSequentialGroup().addComponent(this.JTFFNTotal, -2, 139, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jLabel1, -2, 100, -2).addGap(27, 27, 27).addComponent(this.jLabel4, -2, 100, -2).addGap(18, 18, 18).addComponent(this.jLabel3, -2, 100, -2).addGap(28, 28, 28).addComponent(this.jLabel2, -2, 100, -2).addGap(0, 0, 32767))).addContainerGap()));
        JPIAgrupadoPProfesLayout.setVerticalGroup(JPIAgrupadoPProfesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIAgrupadoPProfesLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPDetalle1, -2, 262, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPIAgrupadoPProfesLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFNTotal, -2, -1, -2).addComponent(this.jLabel1).addComponent(this.jLabel2).addComponent(this.jLabel3).addComponent(this.jLabel4)).addContainerGap(-1, 32767)));
        this.JTPDatosA.addTab("ORDENES POR USUARIO", this.JPIAgrupadoPProfes);
        this.JSPDetalle2.setFont(new Font("Arial", 1, 12));
        this.JTDetalle2.setFont(new Font("Arial", 1, 12));
        this.JTDetalle2.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle2.setRowHeight(25);
        this.JTDetalle2.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle2.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalle2.setSelectionMode(0);
        this.JSPDetalle2.setViewportView(this.JTDetalle2);
        this.JTFFNTotal_consolidado.setEditable(false);
        this.JTFFNTotal_consolidado.setBorder(BorderFactory.createTitledBorder((Border) null, "TOTAL", 0, 0, new Font("Arial", 1, 13), Color.blue));
        this.JTFFNTotal_consolidado.setForeground(Color.red);
        this.JTFFNTotal_consolidado.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(NumberFormat.getIntegerInstance())));
        this.JTFFNTotal_consolidado.setHorizontalAlignment(0);
        this.JTFFNTotal_consolidado.setFont(new Font("Arial", 1, 18));
        GroupLayout JPIAgrupadoProcedLayout = new GroupLayout(this.JPIAgrupadoProced);
        this.JPIAgrupadoProced.setLayout(JPIAgrupadoProcedLayout);
        JPIAgrupadoProcedLayout.setHorizontalGroup(JPIAgrupadoProcedLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIAgrupadoProcedLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPDetalle2, -1, 890, 32767).addContainerGap()).addGroup(JPIAgrupadoProcedLayout.createSequentialGroup().addGap(19, 19, 19).addComponent(this.JTFFNTotal_consolidado, -2, 139, -2).addContainerGap(-1, 32767)));
        JPIAgrupadoProcedLayout.setVerticalGroup(JPIAgrupadoProcedLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIAgrupadoProcedLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPDetalle2, -1, 263, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFNTotal_consolidado, -2, -1, -2).addContainerGap()));
        this.JTPDatosA.addTab("CONSOLIDADO MEDICAMENTOS", this.JPIAgrupadoProced);
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS PARA EXPORTAR", 0, 0, new Font("Arial", 1, 14), Color.red));
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: AutorizacionMP.JIFConsultasUsuarioEnv.5
            public void actionPerformed(ActionEvent evt) {
                JIFConsultasUsuarioEnv.this.JBTExportarActionPerformed(evt);
            }
        });
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: AutorizacionMP.JIFConsultasUsuarioEnv.6
            public void mouseClicked(MouseEvent evt) {
                JIFConsultasUsuarioEnv.this.JTFRutaMouseClicked(evt);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addComponent(this.JTFRuta).addGap(18, 18, 18).addComponent(this.JBTExportar, -2, 161, -2).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JBTExportar, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.JTFRuta, -2, 50, -2)).addContainerGap()));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTPDatosA, GroupLayout.Alignment.TRAILING).addComponent(this.JPIDatos, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addComponent(this.jPanel1, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTPDatosA, -2, 370, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jPanel1, -2, -1, -2).addContainerGap(27, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaIPropertyChange(PropertyChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaFPropertyChange(PropertyChangeEvent evt) {
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
        mExportar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            mCargarDatosTabla1();
            mSumarTotal();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalle1MouseClicked(MouseEvent evt) {
        if (this.JTDetalle1.getSelectedRow() != -1) {
            if (this.JTDetalle1.getSelectedColumn() == 7) {
                if (!this.xmodelo1.getValueAt(this.JTDetalle1.getSelectedRow(), 7).equals("")) {
                    this.xmt.mostrarPdf(this.xmodelo1.getValueAt(this.JTDetalle1.getSelectedRow(), 7).toString());
                }
            } else if (this.JTDetalle1.getSelectedColumn() == 8 && !this.xmodelo1.getValueAt(this.JTDetalle1.getSelectedRow(), 8).equals("")) {
                this.xmt.mostrarPdf(this.xmodelo1.getValueAt(this.JTDetalle1.getSelectedRow(), 8).toString());
            }
        }
    }

    public void mBuscar() {
        mCargarDatosTabla();
        mCargarDatosTabla2();
    }

    private void mExportar() {
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            try {
                WritableWorkbook workbook = Workbook.createWorkbook(new File(this.JTFRuta.getText() + ".xls"));
                WritableSheet sheet = workbook.createSheet("UsuariosMatriculados", 0);
                for (int x = 0; x < this.JTDetalle.getColumnCount(); x++) {
                    sheet.addCell(new Label(x, 0, this.JTDetalle.getColumnName(x)));
                }
                for (int x2 = 0; x2 < this.JTDetalle.getRowCount(); x2++) {
                    sheet.addCell(new Number(0, x2 + 1, Integer.valueOf(this.xmodelo.getValueAt(x2, 0).toString()).intValue()));
                    sheet.addCell(new Label(1, x2 + 1, this.xmodelo.getValueAt(x2, 1).toString()));
                    sheet.addCell(new Label(2, x2 + 1, this.xmodelo.getValueAt(x2, 2).toString()));
                    sheet.addCell(new Label(3, x2 + 1, this.xmodelo.getValueAt(x2, 3).toString()));
                    sheet.addCell(new Label(4, x2 + 1, this.xmodelo.getValueAt(x2, 4).toString()));
                    sheet.addCell(new Label(5, x2 + 1, this.xmodelo.getValueAt(x2, 5).toString()));
                    sheet.addCell(new Label(6, x2 + 1, this.xmodelo.getValueAt(x2, 6).toString()));
                    sheet.addCell(new Label(7, x2 + 1, this.xmodelo.getValueAt(x2, 7).toString()));
                }
                WritableSheet sheet2 = workbook.createSheet("Consolidado", 1);
                for (int x3 = 0; x3 < this.JTDetalle2.getColumnCount(); x3++) {
                    sheet2.addCell(new Label(x3, 0, this.JTDetalle2.getColumnName(x3)));
                }
                for (int x4 = 0; x4 < this.JTDetalle2.getRowCount(); x4++) {
                    sheet2.addCell(new Number(0, x4 + 1, Integer.valueOf(this.xmodelo2.getValueAt(x4, 0).toString()).intValue()));
                    sheet2.addCell(new Label(1, x4 + 1, this.xmodelo2.getValueAt(x4, 1).toString()));
                    sheet2.addCell(new Label(2, x4 + 1, this.xmodelo2.getValueAt(x4, 2).toString()));
                    sheet2.addCell(new Number(3, x4 + 1, Integer.valueOf(this.xmodelo2.getValueAt(x4, 3).toString()).intValue()));
                    sheet2.addCell(new Number(4, x4 + 1, Double.valueOf(this.xmodelo2.getValueAt(x4, 4).toString()).doubleValue()));
                    sheet2.addCell(new Number(5, x4 + 1, Double.valueOf(this.xmodelo2.getValueAt(x4, 5).toString()).doubleValue()));
                    sheet2.addCell(new Label(6, x4 + 1, this.xmodelo2.getValueAt(x4, 6).toString()));
                    sheet2.addCell(new Label(7, x4 + 1, this.xmodelo2.getValueAt(x4, 7).toString()));
                    sheet2.addCell(new Number(8, x4 + 1, Long.valueOf(this.xmodelo2.getValueAt(x4, 8).toString()).longValue()));
                }
                workbook.write();
                workbook.close();
            } catch (WriteException e) {
                Logger.getLogger(JIFConsultasInfLab.class.getName()).log(Level.SEVERE, (String) null, e);
            } catch (IOException ex) {
                Logger.getLogger(JIFConsultasInfLab.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        }
    }

    public void mNuevo() {
        this.JDFechaI.setDate(this.xmt.getFechaActual());
        this.JDFechaF.setDate(this.xmt.getFechaActual());
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
        mCrearModeloDatos();
        mCrearModeloDatos1();
        this.JDFechaI.requestFocus();
    }

    private double mSumarTotal() {
        double total = 0.0d;
        for (int i = 0; i < this.JTDetalle1.getRowCount(); i++) {
            total += Double.parseDouble(String.valueOf(this.xmodelo1.getValueAt(i, 5)));
        }
        return total;
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"id", "TipoID", "No.Documento", "No.Historia", "Nombre Usuario", "Dirección", "Barrio", "Municipio"}) { // from class: AutorizacionMP.JIFConsultasUsuarioEnv.7
            Class[] types = {Integer.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false};

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
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(5);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(25);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(25);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos1() {
        this.xmodelo1 = new DefaultTableModel(new Object[0], new String[]{"No. Orden", "Cód. Barra", "Nombre", "Cantidad", "Valor Unitario", "Valor Total", "e", "Url Soporte", "Url Guía"}) { // from class: AutorizacionMP.JIFConsultasUsuarioEnv.8
            Class[] types = {Integer.class, String.class, String.class, Long.class, Double.class, Double.class, Long.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle1.setModel(this.xmodelo1);
        this.JTDetalle1.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTDetalle1.getColumnModel().getColumn(1).setPreferredWidth(10);
        this.JTDetalle1.getColumnModel().getColumn(2).setPreferredWidth(150);
        this.JTDetalle1.getColumnModel().getColumn(3).setPreferredWidth(5);
        this.JTDetalle1.getColumnModel().getColumn(4).setPreferredWidth(10);
        this.JTDetalle1.getColumnModel().getColumn(5).setPreferredWidth(10);
        this.JTDetalle1.getColumnModel().getColumn(6).setPreferredWidth(0);
        this.JTDetalle1.getColumnModel().getColumn(6).setMinWidth(0);
        this.JTDetalle1.getColumnModel().getColumn(6).setMaxWidth(0);
        this.JTDetalle1.getColumnModel().getColumn(7).setPreferredWidth(20);
        this.JTDetalle1.getColumnModel().getColumn(8).setPreferredWidth(20);
        this.JTDetalle1.setDefaultRenderer(Object.class, new MiRender());
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos2() {
        this.xmodelo2 = new DefaultTableModel(new Object[0], new String[]{"id", "Cod. Barra", "Nombre", "Cant.", "Total", "ValorU Promedio", "Laboratorio", "Pre.Comercial", "Cant.Unid"}) { // from class: AutorizacionMP.JIFConsultasUsuarioEnv.9
            Class[] types = {Long.class, String.class, String.class, Integer.class, Double.class, Double.class, String.class, String.class, Long.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle2.setModel(this.xmodelo2);
        this.JTDetalle2.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTDetalle2.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTDetalle2.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTDetalle2.getColumnModel().getColumn(1).setPreferredWidth(10);
        this.JTDetalle2.getColumnModel().getColumn(2).setPreferredWidth(150);
        this.JTDetalle2.getColumnModel().getColumn(3).setPreferredWidth(5);
        this.JTDetalle2.getColumnModel().getColumn(4).setPreferredWidth(5);
        this.JTDetalle2.getColumnModel().getColumn(5).setPreferredWidth(10);
        this.JTDetalle2.getColumnModel().getColumn(6).setPreferredWidth(50);
        this.JTDetalle2.getColumnModel().getColumn(7).setPreferredWidth(50);
        this.JTDetalle2.getColumnModel().getColumn(8).setPreferredWidth(3);
    }

    public void mCargarDatosTabla() {
        try {
            String xsql = "SELECT `persona`.`Id_persona` ,persona.`Id_TipoIdentificacion` , `persona`.`NoDocumento` , `persona`.`NoHistoria` ,`persona`.`NUsuario` ,persona.`Direccion` ,persona.`NBarrio` ,persona.`NMunicipio`FROM `d_programaenviomedicamentos` INNER JOIN `h_ordenes`  ON (`d_programaenviomedicamentos`.`N_OrdenHc` = `h_ordenes`.`Id`)INNER JOIN `h_atencion` ON (`h_ordenes`.`Id_Atencion` = `h_atencion`.`Id`) INNER JOIN `ingreso` ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)INNER JOIN `persona`  ON (`ingreso`.`Id_Usuario` = `persona`.`Id_persona`)WHERE (`d_programaenviomedicamentos`.`Estado` =1 AND `h_ordenes`.`Estado` =0 AND (h_ordenes.`FechaOrden`>='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND h_ordenes.`FechaOrden`<='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "'))GROUP BY `persona`.`Id_persona` ORDER BY `persona`.`NUsuario` ASC";
            mCrearModeloDatos();
            ResultSet xrs = this.xconsulta.traerRs(xsql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
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
                    n++;
                }
            }
            xrs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFConsultasUsuarioEnv.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mCargarDatosTabla1() {
        try {
            String xsql = "SELECT `h_itemordenessum`.`Id_HOrdenes` , `i_suministro`.`CodBarraUnidad`, `i_suministro`.`Nbre`, `h_itemordenessum`.`Cantidad` , `h_itemordenessum`.`ValorUnitario` , `h_itemordenessum`.`ValorTotal`, h_ordenes.`EstaEntregada`, h_ordenes.`UrlSoporte`,h_ordenes.`UrlGuiaEnvio` FROM `persona` AS `persona_1`, `d_programaenviomedicamentos` INNER JOIN `h_ordenes`  ON (`d_programaenviomedicamentos`.`N_OrdenHc` = `h_ordenes`.`Id`)INNER JOIN `h_atencion`  ON (`h_ordenes`.`Id_Atencion` = `h_atencion`.`Id`) INNER JOIN `baseserver`.`ingreso`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)INNER JOIN `persona`  ON (`ingreso`.`Id_Usuario` = `persona`.`Id_persona`)INNER JOIN `baseserver`.`h_itemordenessum`  ON (`h_itemordenessum`.`Id_HOrdenes` = `h_ordenes`.`Id`) INNER JOIN `i_suministro`  ON (`h_itemordenessum`.`Id_Suministro` = `i_suministro`.`Id`)WHERE (`persona`.`Id_persona` ='" + this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0) + "' AND (h_ordenes.`FechaOrden`>='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND h_ordenes.`FechaOrden`<='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "')) GROUP BY i_suministro.`Id` ORDER BY `h_itemordenessum`.`Id_HOrdenes` ASC";
            mCrearModeloDatos1();
            ResultSet xrs = this.xconsulta.traerRs(xsql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                double total = 0.0d;
                while (xrs.next()) {
                    this.xmodelo1.addRow(this.xdatos);
                    this.xmodelo1.setValueAt(Integer.valueOf(xrs.getInt(1)), n, 0);
                    this.xmodelo1.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo1.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelo1.setValueAt(Long.valueOf(xrs.getLong(4)), n, 3);
                    this.xmodelo1.setValueAt(Double.valueOf(xrs.getDouble(5)), n, 4);
                    this.xmodelo1.setValueAt(Double.valueOf(xrs.getDouble(6)), n, 5);
                    this.xmodelo1.setValueAt(Long.valueOf(xrs.getLong(7)), n, 6);
                    this.xmodelo1.setValueAt(xrs.getString(8), n, 7);
                    this.xmodelo1.setValueAt(xrs.getString(9), n, 8);
                    total += xrs.getDouble(6);
                    n++;
                }
                this.JTFFNTotal.setValue(Double.valueOf(total));
            }
            xrs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFConsultasInfLab.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mCargarDatosTabla2() {
        try {
            String xsql = "SELECT `i_suministro`.`Id` , `i_suministro`.`CodBarraUnidad` , `i_suministro`.`Nbre`, SUM(h_itemordenessum.Cantidad) AS cantidad , SUM(`h_itemordenessum`.`ValorTotal`)AS total, ROUND(SUM(`h_itemordenessum`.`ValorTotal`)/SUM(h_itemordenessum.Cantidad)) AS promedio,`i_laboratorio`.`Nbre` , `i_presentacioncomercial`.`Nbre`,`i_suministro`.`CantidadUnidad`  FROM `d_programaenviomedicamentos` INNER JOIN `h_ordenes`  ON (`d_programaenviomedicamentos`.`N_OrdenHc` = `h_ordenes`.`Id`) INNER JOIN `baseserver`.`h_atencion`  ON (`h_ordenes`.`Id_Atencion` = `h_atencion`.`Id`) INNER JOIN `baseserver`.`ingreso`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)INNER JOIN `baseserver`.`persona`   ON (`ingreso`.`Id_Usuario` = `persona`.`Id_persona`) INNER JOIN `baseserver`.`h_itemordenessum`  ON (`h_itemordenessum`.`Id_HOrdenes` = `h_ordenes`.`Id`)INNER JOIN `baseserver`.`i_suministro`  ON (`h_itemordenessum`.`Id_Suministro` = `i_suministro`.`Id`)INNER JOIN `baseserver`.`i_laboratorio`  ON (`i_suministro`.`IdLaboratorio` = `i_laboratorio`.`Id`) INNER JOIN `baseserver`.`i_presentacioncomercial`  ON (`i_suministro`.`IdPresentacionComercial` = `i_presentacioncomercial`.`Id`)WHERE (`d_programaenviomedicamentos`.`Estado` =1 AND `h_ordenes`.`Estado` =0 AND (h_ordenes.`FechaOrden`>='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND h_ordenes.`FechaOrden`<='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "')) GROUP BY `i_suministro`.`Id` ORDER BY `i_suministro`.`Nbre` ";
            mCrearModeloDatos2();
            ResultSet xrs = this.xconsulta.traerRs(xsql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                double total_c = 0.0d;
                while (xrs.next()) {
                    this.xmodelo2.addRow(this.xdatos);
                    this.xmodelo2.setValueAt(Integer.valueOf(xrs.getInt(1)), n, 0);
                    this.xmodelo2.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo2.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelo2.setValueAt(Integer.valueOf(xrs.getInt(4)), n, 3);
                    this.xmodelo2.setValueAt(Double.valueOf(xrs.getDouble(5)), n, 4);
                    this.xmodelo2.setValueAt(Double.valueOf(xrs.getDouble(6)), n, 5);
                    this.xmodelo2.setValueAt(xrs.getString(7), n, 6);
                    this.xmodelo2.setValueAt(xrs.getString(8), n, 7);
                    this.xmodelo2.setValueAt(Long.valueOf(xrs.getLong(9)), n, 8);
                    total_c += xrs.getDouble(5);
                    n++;
                }
                this.JTFFNTotal_consolidado.setValue(Double.valueOf(total_c));
            }
            xrs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFConsultasUsuarioEnv.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX INFO: loaded from: GenomaP.jar:AutorizacionMP/JIFConsultasUsuarioEnv$MiRender.class */
    public static class MiRender extends DefaultTableCellRenderer {
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            String dias_v = table.getValueAt(row, 6).toString();
            if (dias_v != null && dias_v.equals("0")) {
                cell.setBackground(new Color(251, 54, 54));
                cell.setForeground(Color.WHITE);
            } else if (dias_v != null && dias_v.equals("1")) {
                cell.setBackground(new Color(133, 218, 160));
                cell.setForeground(Color.BLACK);
            } else if (dias_v != null && dias_v.equals("2")) {
                cell.setBackground(new Color(255, 255, 102));
                cell.setForeground(Color.BLACK);
            } else {
                cell.setBackground(new Color(102, 204, 255));
                cell.setForeground(Color.BLACK);
            }
            return cell;
        }
    }
}
