package PyP;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
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
import java.text.SimpleDateFormat;
import java.util.Date;
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
import javax.swing.JFormattedTextField;
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

/* JADX INFO: loaded from: GenomaP.jar:PyP/JIFGestionProgramaP.class */
public class JIFGestionProgramaP extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private DefaultTableModel xmodelo1;
    private DefaultTableModel xmodelou;
    private String xnombre;
    private String xsql;
    private String[] xidprograma;
    private Object[] xdato;
    private ButtonGroup JBGP1;
    private ButtonGroup JBGP2;
    private ButtonGroup JBGP3;
    private ButtonGroup JBGP4;
    private JButton JBTExportar;
    private JButton JBTUAdicionarElementoP;
    private JComboBox JCBPrograma;
    private JCheckBox JCHFiltro;
    private JDateChooser JDFechaF;
    private JDateChooser JDFechaI;
    private JLabel JLBP1;
    private JLabel JLBP2;
    private JLabel JLBP3;
    private JLabel JLBP4;
    private JLabel JLBResultado;
    private JPanel JPIDatos;
    private JPanel JPIDatosElementosPP;
    private JPanel JPIDetalleF;
    private JPanel JPITest;
    private JPanel JPIUsuariosN;
    private JPanel JPItest;
    private JRadioButton JRBPNo;
    private JRadioButton JRBPNo1;
    private JRadioButton JRBPNo2;
    private JRadioButton JRBPNo3;
    private JRadioButton JRBPSi;
    private JRadioButton JRBPSi1;
    private JRadioButton JRBPSi2;
    private JRadioButton JRBPSi3;
    private JScrollPane JSPDetalle;
    private JScrollPane JSPDetalle1;
    private JScrollPane JSPHistorialU;
    public JTable JTDetalle;
    public JTable JTDetalle1;
    private JFormattedTextField JTFFNRegistro;
    private JFormattedTextField JTFFNRegistroDF;
    private JFormattedTextField JTFFVFactura;
    private JTextField JTFRuta;
    private JTabbedPane JTPDatos;
    private JTable JTPHistorialU;
    private Metodos xmt = new Metodos();
    private ConsultasMySQL xct = new ConsultasMySQL();
    private int xp1 = 0;
    private int xp2 = 1;
    private int xp3 = 0;
    private int xp4 = 0;
    private int xcumple = 1;
    private String xid = "0";

    public JIFGestionProgramaP() {
        initComponents();
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v129, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v35, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v64, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGP1 = new ButtonGroup();
        this.JBGP2 = new ButtonGroup();
        this.JBGP3 = new ButtonGroup();
        this.JBGP4 = new ButtonGroup();
        this.JPIDatos = new JPanel();
        this.JDFechaI = new JDateChooser();
        this.JDFechaF = new JDateChooser();
        this.JCBPrograma = new JComboBox();
        this.JCHFiltro = new JCheckBox();
        this.JTPDatos = new JTabbedPane();
        this.JPIUsuariosN = new JPanel();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JTFFNRegistro = new JFormattedTextField();
        this.JPIDetalleF = new JPanel();
        this.JSPDetalle1 = new JScrollPane();
        this.JTDetalle1 = new JTable();
        this.JTFFNRegistroDF = new JFormattedTextField();
        this.JTFFVFactura = new JFormattedTextField();
        this.JPITest = new JPanel();
        this.JPItest = new JPanel();
        this.JPIDatosElementosPP = new JPanel();
        this.JBTUAdicionarElementoP = new JButton();
        this.JLBP1 = new JLabel();
        this.JRBPSi = new JRadioButton();
        this.JRBPNo = new JRadioButton();
        this.JLBP2 = new JLabel();
        this.JRBPSi1 = new JRadioButton();
        this.JRBPNo1 = new JRadioButton();
        this.JLBP3 = new JLabel();
        this.JRBPSi2 = new JRadioButton();
        this.JRBPNo2 = new JRadioButton();
        this.JLBP4 = new JLabel();
        this.JRBPSi3 = new JRadioButton();
        this.JRBPNo3 = new JRadioButton();
        this.JLBResultado = new JLabel();
        this.JSPHistorialU = new JScrollPane();
        this.JTPHistorialU = new JTable();
        this.JTFRuta = new JTextField();
        this.JBTExportar = new JButton();
        setClosable(true);
        setIconifiable(true);
        setTitle("GESTIÓN PROGRAMA POLIMEDICADO");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjifgestionpolimedicados");
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 0, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JDFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicial", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFechaI.setFont(new Font("Arial", 1, 12));
        this.JDFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Final", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFechaF.setFont(new Font("Arial", 1, 12));
        this.JCBPrograma.setFont(new Font("Arial", 1, 12));
        this.JCBPrograma.setBorder(BorderFactory.createTitledBorder((Border) null, "Programa", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHFiltro.setFont(new Font("Arial", 1, 12));
        this.JCHFiltro.setSelected(true);
        this.JCHFiltro.setText("Filtro");
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addComponent(this.JDFechaI, -2, 136, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JDFechaF, -2, 136, -2).addGap(18, 18, 18).addComponent(this.JCBPrograma, -2, 473, -2).addGap(30, 30, 30).addComponent(this.JCHFiltro).addContainerGap(-1, 32767)));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JDFechaI, -2, 56, -2).addComponent(this.JDFechaF, -2, 56, -2)).addGroup(JPIDatosLayout.createSequentialGroup().addGap(27, 27, 27).addComponent(this.JCHFiltro)).addComponent(this.JCBPrograma)).addContainerGap()));
        this.JTPDatos.setForeground(new Color(0, 103, 0));
        this.JTPDatos.setFont(new Font("Arial", 1, 14));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JSPDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setBorder(BorderFactory.createBevelBorder(0));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setForeground(new Color(0, 0, 204));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalle.setEditingColumn(1);
        this.JTDetalle.setEditingRow(1);
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.setSelectionMode(0);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: PyP.JIFGestionProgramaP.1
            public void mouseClicked(MouseEvent evt) {
                JIFGestionProgramaP.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.JTFFNRegistro.setEditable(false);
        this.JTFFNRegistro.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Registros", 0, 0, new Font("Arial", 1, 13), Color.red));
        this.JTFFNRegistro.setHorizontalAlignment(0);
        this.JTFFNRegistro.setFont(new Font("Arial", 1, 12));
        GroupLayout JPIUsuariosNLayout = new GroupLayout(this.JPIUsuariosN);
        this.JPIUsuariosN.setLayout(JPIUsuariosNLayout);
        JPIUsuariosNLayout.setHorizontalGroup(JPIUsuariosNLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIUsuariosNLayout.createSequentialGroup().addContainerGap().addComponent(this.JTFFNRegistro, -2, 152, -2).addContainerGap(731, 32767)).addGroup(JPIUsuariosNLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIUsuariosNLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPDetalle, -1, 873, 32767).addContainerGap())));
        JPIUsuariosNLayout.setVerticalGroup(JPIUsuariosNLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIUsuariosNLayout.createSequentialGroup().addContainerGap(344, 32767).addComponent(this.JTFFNRegistro, -2, 56, -2).addContainerGap()).addGroup(JPIUsuariosNLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIUsuariosNLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPDetalle, -2, 320, -2).addContainerGap(80, 32767))));
        this.JTPDatos.addTab("USUARIOS REPORTADOS", this.JPIUsuariosN);
        this.JSPDetalle1.setBorder(BorderFactory.createTitledBorder((Border) null, "RESULTADO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle1.setBorder(BorderFactory.createBevelBorder(0));
        this.JTDetalle1.setFont(new Font("Arial", 1, 12));
        this.JTDetalle1.setForeground(new Color(0, 0, 204));
        this.JTDetalle1.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalle1.setEditingColumn(1);
        this.JTDetalle1.setEditingRow(1);
        this.JTDetalle1.setRowHeight(25);
        this.JTDetalle1.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle1.setSelectionForeground(Color.red);
        this.JTDetalle1.setSelectionMode(0);
        this.JTDetalle1.addMouseListener(new MouseAdapter() { // from class: PyP.JIFGestionProgramaP.2
            public void mouseClicked(MouseEvent evt) {
                JIFGestionProgramaP.this.JTDetalle1MouseClicked(evt);
            }
        });
        this.JSPDetalle1.setViewportView(this.JTDetalle1);
        this.JTFFNRegistroDF.setEditable(false);
        this.JTFFNRegistroDF.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Registros", 0, 0, new Font("Arial", 1, 13), Color.blue));
        this.JTFFNRegistroDF.setHorizontalAlignment(0);
        this.JTFFNRegistroDF.setFont(new Font("Arial", 1, 12));
        this.JTFFVFactura.setEditable(false);
        this.JTFFVFactura.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor", 0, 0, new Font("Arial", 1, 13), Color.blue));
        this.JTFFVFactura.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFVFactura.setHorizontalAlignment(0);
        this.JTFFVFactura.setFont(new Font("Arial", 1, 12));
        GroupLayout JPIDetalleFLayout = new GroupLayout(this.JPIDetalleF);
        this.JPIDetalleF.setLayout(JPIDetalleFLayout);
        JPIDetalleFLayout.setHorizontalGroup(JPIDetalleFLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDetalleFLayout.createSequentialGroup().addContainerGap().addGroup(JPIDetalleFLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JSPDetalle1, GroupLayout.Alignment.LEADING, -1, 873, 32767).addGroup(JPIDetalleFLayout.createSequentialGroup().addComponent(this.JTFFNRegistroDF, -2, 152, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 569, 32767).addComponent(this.JTFFVFactura, -2, 152, -2))).addContainerGap()));
        JPIDetalleFLayout.setVerticalGroup(JPIDetalleFLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDetalleFLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPDetalle1, -1, 327, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIDetalleFLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFNRegistroDF, -2, 56, -2).addComponent(this.JTFFVFactura, -2, 56, -2)).addContainerGap()));
        this.JTPDatos.addTab("DETALLE FORMULACIÓN", this.JPIDetalleF);
        this.JPItest.setMaximumSize((Dimension) null);
        this.JPItest.setName("jifantecfamiliares");
        this.JPIDatosElementosPP.setBorder(BorderFactory.createTitledBorder((Border) null, "PREGUNTAS", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JPIDatosElementosPP.setFont(new Font("Arial", 1, 12));
        this.JBTUAdicionarElementoP.setFont(new Font("Arial", 1, 12));
        this.JBTUAdicionarElementoP.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTUAdicionarElementoP.setText("Grabar");
        this.JBTUAdicionarElementoP.addActionListener(new ActionListener() { // from class: PyP.JIFGestionProgramaP.3
            public void actionPerformed(ActionEvent evt) {
                JIFGestionProgramaP.this.JBTUAdicionarElementoPActionPerformed(evt);
            }
        });
        this.JLBP1.setFont(new Font("Arial", 1, 14));
        this.JLBP1.setText("1. ¿Se olvida alguna vez de tomar los medicamentos? ");
        this.JBGP1.add(this.JRBPSi);
        this.JRBPSi.setFont(new Font("Arial", 1, 14));
        this.JRBPSi.setForeground(Color.red);
        this.JRBPSi.setText("Si");
        this.JRBPSi.addActionListener(new ActionListener() { // from class: PyP.JIFGestionProgramaP.4
            public void actionPerformed(ActionEvent evt) {
                JIFGestionProgramaP.this.JRBPSiActionPerformed(evt);
            }
        });
        this.JBGP1.add(this.JRBPNo);
        this.JRBPNo.setFont(new Font("Arial", 1, 14));
        this.JRBPNo.setForeground(Color.red);
        this.JRBPNo.setSelected(true);
        this.JRBPNo.setText("No");
        this.JRBPNo.addActionListener(new ActionListener() { // from class: PyP.JIFGestionProgramaP.5
            public void actionPerformed(ActionEvent evt) {
                JIFGestionProgramaP.this.JRBPNoActionPerformed(evt);
            }
        });
        this.JLBP2.setFont(new Font("Arial", 1, 14));
        this.JLBP2.setText("2. ¿Toma todos los medicamentos indicados? ");
        this.JBGP2.add(this.JRBPSi1);
        this.JRBPSi1.setFont(new Font("Arial", 1, 14));
        this.JRBPSi1.setForeground(Color.red);
        this.JRBPSi1.setSelected(true);
        this.JRBPSi1.setText("Si");
        this.JRBPSi1.addActionListener(new ActionListener() { // from class: PyP.JIFGestionProgramaP.6
            public void actionPerformed(ActionEvent evt) {
                JIFGestionProgramaP.this.JRBPSi1ActionPerformed(evt);
            }
        });
        this.JBGP2.add(this.JRBPNo1);
        this.JRBPNo1.setFont(new Font("Arial", 1, 14));
        this.JRBPNo1.setForeground(Color.red);
        this.JRBPNo1.setText("No");
        this.JRBPNo1.addActionListener(new ActionListener() { // from class: PyP.JIFGestionProgramaP.7
            public void actionPerformed(ActionEvent evt) {
                JIFGestionProgramaP.this.JRBPNo1ActionPerformed(evt);
            }
        });
        this.JLBP3.setFont(new Font("Arial", 1, 14));
        this.JLBP3.setText("3. Cuando se encuentra mejor, ¿Deja de tomar los medicamentos? ");
        this.JBGP3.add(this.JRBPSi2);
        this.JRBPSi2.setFont(new Font("Arial", 1, 14));
        this.JRBPSi2.setForeground(Color.red);
        this.JRBPSi2.setText("Si");
        this.JRBPSi2.addActionListener(new ActionListener() { // from class: PyP.JIFGestionProgramaP.8
            public void actionPerformed(ActionEvent evt) {
                JIFGestionProgramaP.this.JRBPSi2ActionPerformed(evt);
            }
        });
        this.JBGP3.add(this.JRBPNo2);
        this.JRBPNo2.setFont(new Font("Arial", 1, 14));
        this.JRBPNo2.setForeground(Color.red);
        this.JRBPNo2.setSelected(true);
        this.JRBPNo2.setText("No");
        this.JRBPNo2.addActionListener(new ActionListener() { // from class: PyP.JIFGestionProgramaP.9
            public void actionPerformed(ActionEvent evt) {
                JIFGestionProgramaP.this.JRBPNo2ActionPerformed(evt);
            }
        });
        this.JLBP4.setFont(new Font("Arial", 1, 14));
        this.JLBP4.setText("4. Si alguna vez se siente mal, ¿Deja de tomarlos? ");
        this.JBGP4.add(this.JRBPSi3);
        this.JRBPSi3.setFont(new Font("Arial", 1, 14));
        this.JRBPSi3.setForeground(Color.red);
        this.JRBPSi3.setText("Si");
        this.JRBPSi3.addActionListener(new ActionListener() { // from class: PyP.JIFGestionProgramaP.10
            public void actionPerformed(ActionEvent evt) {
                JIFGestionProgramaP.this.JRBPSi3ActionPerformed(evt);
            }
        });
        this.JBGP4.add(this.JRBPNo3);
        this.JRBPNo3.setFont(new Font("Arial", 1, 14));
        this.JRBPNo3.setForeground(Color.red);
        this.JRBPNo3.setSelected(true);
        this.JRBPNo3.setText("No");
        this.JRBPNo3.addActionListener(new ActionListener() { // from class: PyP.JIFGestionProgramaP.11
            public void actionPerformed(ActionEvent evt) {
                JIFGestionProgramaP.this.JRBPNo3ActionPerformed(evt);
            }
        });
        this.JLBResultado.setFont(new Font("Arial", 1, 18));
        this.JLBResultado.setForeground(new Color(0, 103, 0));
        this.JLBResultado.setHorizontalAlignment(0);
        GroupLayout JPIDatosElementosPPLayout = new GroupLayout(this.JPIDatosElementosPP);
        this.JPIDatosElementosPP.setLayout(JPIDatosElementosPPLayout);
        JPIDatosElementosPPLayout.setHorizontalGroup(JPIDatosElementosPPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosElementosPPLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosElementosPPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosElementosPPLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addGroup(GroupLayout.Alignment.LEADING, JPIDatosElementosPPLayout.createSequentialGroup().addComponent(this.JLBP1).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JRBPSi).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBPNo)).addGroup(JPIDatosElementosPPLayout.createSequentialGroup().addGroup(JPIDatosElementosPPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLBP2).addComponent(this.JLBP3)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 92, 32767).addGroup(JPIDatosElementosPPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosElementosPPLayout.createSequentialGroup().addComponent(this.JRBPSi2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBPNo2)).addGroup(JPIDatosElementosPPLayout.createSequentialGroup().addComponent(this.JRBPSi1).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBPNo1)).addGroup(JPIDatosElementosPPLayout.createSequentialGroup().addComponent(this.JRBPSi3).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBPNo3))))).addComponent(this.JLBP4)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 43, 32767).addGroup(JPIDatosElementosPPLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JBTUAdicionarElementoP, -1, -1, 32767).addComponent(this.JLBResultado, -1, 131, 32767)).addContainerGap()));
        JPIDatosElementosPPLayout.setVerticalGroup(JPIDatosElementosPPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosElementosPPLayout.createSequentialGroup().addGroup(JPIDatosElementosPPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosElementosPPLayout.createSequentialGroup().addGroup(JPIDatosElementosPPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosElementosPPLayout.createSequentialGroup().addGap(8, 8, 8).addComponent(this.JLBP1)).addGroup(JPIDatosElementosPPLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBPSi).addComponent(this.JRBPNo))).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPIDatosElementosPPLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBPSi1).addComponent(this.JRBPNo1).addComponent(this.JLBP2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPIDatosElementosPPLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JLBP3).addComponent(this.JRBPSi2).addComponent(this.JRBPNo2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPIDatosElementosPPLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JLBP4).addComponent(this.JRBPSi3).addComponent(this.JRBPNo3))).addGroup(JPIDatosElementosPPLayout.createSequentialGroup().addComponent(this.JLBResultado, -1, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTUAdicionarElementoP, -2, 43, -2))).addContainerGap()));
        this.JSPHistorialU.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTORIAL", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTPHistorialU.setFont(new Font("Arial", 1, 12));
        this.JTPHistorialU.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTPHistorialU.setSelectionBackground(new Color(255, 255, 255));
        this.JTPHistorialU.setSelectionForeground(Color.red);
        this.JTPHistorialU.setSelectionMode(0);
        this.JSPHistorialU.setViewportView(this.JTPHistorialU);
        GroupLayout JPItestLayout = new GroupLayout(this.JPItest);
        this.JPItest.setLayout(JPItestLayout);
        JPItestLayout.setHorizontalGroup(JPItestLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPItestLayout.createSequentialGroup().addContainerGap().addGroup(JPItestLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JSPHistorialU, GroupLayout.Alignment.LEADING, -1, 853, 32767).addComponent(this.JPIDatosElementosPP, GroupLayout.Alignment.LEADING, -1, -1, 32767)).addContainerGap()));
        JPItestLayout.setVerticalGroup(JPItestLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPItestLayout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatosElementosPP, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPHistorialU, -2, 206, -2).addContainerGap(-1, 32767)));
        GroupLayout JPITestLayout = new GroupLayout(this.JPITest);
        this.JPITest.setLayout(JPITestLayout);
        JPITestLayout.setHorizontalGroup(JPITestLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 893, 32767).addGroup(JPITestLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPITestLayout.createSequentialGroup().addContainerGap().addComponent(this.JPItest, -1, -1, 32767).addContainerGap())));
        JPITestLayout.setVerticalGroup(JPITestLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 414, 32767).addGroup(JPITestLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPITestLayout.createSequentialGroup().addGap(2, 2, 2).addComponent(this.JPItest, -2, -1, -2).addContainerGap(-1, 32767))));
        this.JTPDatos.addTab("TEST MORISKY", this.JPITest);
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: PyP.JIFGestionProgramaP.12
            public void mouseClicked(MouseEvent evt) {
                JIFGestionProgramaP.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: PyP.JIFGestionProgramaP.13
            public void actionPerformed(ActionEvent evt) {
                JIFGestionProgramaP.this.JBTExportarActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.JTFRuta, -2, 595, -2).addGap(10, 10, 10).addComponent(this.JBTExportar, -1, -1, 32767)).addComponent(this.JTPDatos).addComponent(this.JPIDatos, GroupLayout.Alignment.TRAILING, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTPDatos, -2, 442, -2).addGap(18, 18, 18).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTFRuta).addComponent(this.JBTExportar, -1, 58, 32767)).addGap(27, 27, 27)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            Object[] botones = {"Matricular", "Ver Detalle Formulación", "Cerrar"};
            mCrearTablaDetalleFormula();
            mCrearTablaTestMorisky();
            mBuscarDatosTestMoriskyBd();
            int n = JOptionPane.showInternalOptionDialog(this, "Que desea hacer?", "GESTIÓN POLIMEDICADO", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), botones, "Cerrar");
            if (n == 0) {
                if (!this.JCHFiltro.isSelected() && this.JCBPrograma.getSelectedIndex() != -1) {
                    this.xsql = "insert ignore into g_usuarioxprograma (Id_Usuario, Id_Programa, FechaIngreso, Cardinal, EsIngreso, Fecha, UsuarioS) values('" + this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 16) + "','" + this.xidprograma[this.JCBPrograma.getSelectedIndex()] + "','" + this.xmt.formatoAMD.format(this.xmt.getFechaActual()) + "','0','1','" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                    this.xct.ejecutarSQL(this.xsql);
                    this.xct.cerrarConexionBd();
                    return;
                }
                return;
            }
            if (n == 1) {
                mCargarDetalleFormulaUsuario();
                this.JTPDatos.setSelectedIndex(1);
            }
        }
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
        mExportarInformacion();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalle1MouseClicked(MouseEvent evt) {
        if (this.JTDetalle1.getSelectedRow() != -1) {
            Object[] botones = {"Formula Médica", "Historia Clínica", "Cerrar"};
            int n = JOptionPane.showInternalOptionDialog(this, "Que desea hacer", "VISUALIZAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), botones, "Cerrar");
            if (n == 0) {
                mImprimirFormula(Long.valueOf(this.xmodelo1.getValueAt(this.JTDetalle1.getSelectedRow(), 0).toString()).longValue(), 1);
                return;
            }
            if (n == 1) {
                String[][] mparametros = new String[4][2];
                mparametros[0][0] = "idatencion1";
                mparametros[0][1] = this.xmodelo1.getValueAt(this.JTDetalle1.getSelectedRow(), 9).toString();
                mparametros[1][0] = "idpaciente1";
                mparametros[1][1] = this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 16).toString();
                mparametros[2][0] = "SUBREPORT_DIR";
                mparametros[2][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
                mparametros[3][0] = "SUBREPORTFIRMA_DIR";
                mparametros[3][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
                this.xmt.GenerarPDF(this.xmt.getRutaRep() + "H_HistoriaClinica", mparametros);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTUAdicionarElementoPActionPerformed(ActionEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            int x = JOptionPane.showConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                String xsql = "insert  into p_test_morisky(Id_Usuario, Id_Atencion, FechaT, Id_Especialidad, Id_Profesional, P1, P2, P3, P4, UsuarioS) values('" + this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 16) + "','0','" + this.xmt.formatoAMD.format(this.xmt.getFechaActual()) + "','" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "','" + this.xp1 + "','" + this.xp2 + "','" + this.xp3 + "','" + this.xp4 + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                this.xid = this.xct.ejecutarSQLId(xsql);
                this.xct.cerrarConexionBd();
                String xsql2 = "update g_usuarioxprograma set CumpleTesMorisky='" + this.xcumple + "' where Id_Usuario='" + this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 16) + "' and Id_Programa=11";
                this.xct.ejecutarSQL(xsql2);
                this.xct.cerrarConexionBd();
                mBuscarDatosTestMoriskyBd();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBPSiActionPerformed(ActionEvent evt) {
        this.xp1 = 1;
        mEvaluarCumplimiento();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBPNoActionPerformed(ActionEvent evt) {
        this.xp1 = 0;
        mEvaluarCumplimiento();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBPSi1ActionPerformed(ActionEvent evt) {
        this.xp2 = 1;
        mEvaluarCumplimiento();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBPNo1ActionPerformed(ActionEvent evt) {
        this.xp2 = 0;
        mEvaluarCumplimiento();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBPSi2ActionPerformed(ActionEvent evt) {
        this.xp3 = 1;
        mEvaluarCumplimiento();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBPNo2ActionPerformed(ActionEvent evt) {
        this.xp3 = 0;
        mEvaluarCumplimiento();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBPSi3ActionPerformed(ActionEvent evt) {
        this.xp4 = 1;
        mEvaluarCumplimiento();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBPNo3ActionPerformed(ActionEvent evt) {
        this.xp4 = 0;
        mEvaluarCumplimiento();
    }

    public void mNuevo() {
        this.JDFechaI.setDate(this.xmt.getFechaActual());
        this.JDFechaF.setDate(this.xmt.getFechaActual());
        this.JCBPrograma.removeAllItems();
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
        this.xidprograma = this.xct.llenarCombo("SELECT Id_TipoPrograma, UCASE(Nbre) FROM g_tipoprograma WHERE (Estado =0) ORDER BY Nbre ASC", this.xidprograma, this.JCBPrograma);
        this.JCBPrograma.setSelectedIndex(-1);
        this.xct.cerrarConexionBd();
        mCrearTablaUsuarios();
        mCrearTablaDetalleFormula();
        mCrearTablaTestMorisky();
    }

    private void mCrearTablaUsuarios() {
        this.xmodelo = new DefaultTableModel((Object[][]) null, new String[]{"NHC", "TD", "Documento", "Usuario", "FechaNac", "Edad", "TEdad", "Sexo", "Departamento", "Municipio", "Dirección", "Teléfono", "TipoEmpresa", "Parentesco", "Eps", "Tipo Beneficiario", "IdPersona"}) { // from class: PyP.JIFGestionProgramaP.14
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Integer.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Long.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(30);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(5);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(30);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(250);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(4).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(4).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(5);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(5);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(5);
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
        this.JTDetalle.getColumnModel().getColumn(15).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(16).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(16).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(16).setMaxWidth(0);
    }

    private void mCrearTablaDetalleFormula() {
        this.xmodelo1 = new DefaultTableModel((Object[][]) null, new String[]{"Id", "Fecha Orden", "Medicamento", "Principio Activo", "PFarmacéutica", "Posología", "Cant", "V/Unitario", "V/Total", "IdAtención"}) { // from class: PyP.JIFGestionProgramaP.15
            Class[] types = {Long.class, String.class, String.class, String.class, String.class, String.class, Long.class, Double.class, Double.class, Long.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        this.JTDetalle1.setModel(this.xmodelo1);
        this.JTDetalle1.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTDetalle1.getColumnModel().getColumn(1).setPreferredWidth(10);
        this.JTDetalle1.getColumnModel().getColumn(2).setPreferredWidth(150);
        this.JTDetalle1.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTDetalle1.getColumnModel().getColumn(4).setPreferredWidth(50);
        this.JTDetalle1.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTDetalle1.getColumnModel().getColumn(6).setPreferredWidth(5);
        this.JTDetalle1.getColumnModel().getColumn(7).setPreferredWidth(10);
        this.JTDetalle1.getColumnModel().getColumn(8).setPreferredWidth(10);
        this.JTDetalle1.getColumnModel().getColumn(9).setPreferredWidth(0);
        this.JTDetalle1.getColumnModel().getColumn(9).setMinWidth(0);
        this.JTDetalle1.getColumnModel().getColumn(9).setMaxWidth(0);
    }

    private void mBuscarDatosUsuario(String sql) {
        mCrearTablaUsuarios();
        ResultSet rs = this.xct.traerRs(sql);
        try {
            if (rs.next()) {
                rs.beforeFirst();
                int x = 0;
                while (rs.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(rs.getString(1), x, 0);
                    this.xmodelo.setValueAt(rs.getString(2), x, 1);
                    this.xmodelo.setValueAt(rs.getString(3), x, 2);
                    this.xmodelo.setValueAt(rs.getString(4), x, 3);
                    this.xmodelo.setValueAt(rs.getString(5), x, 4);
                    this.xmodelo.setValueAt(rs.getString(6), x, 5);
                    this.xmodelo.setValueAt(rs.getString(7), x, 6);
                    this.xmodelo.setValueAt(rs.getString(8), x, 7);
                    this.xmodelo.setValueAt(rs.getString(9), x, 8);
                    this.xmodelo.setValueAt(rs.getString(10), x, 9);
                    this.xmodelo.setValueAt(rs.getString(11), x, 10);
                    this.xmodelo.setValueAt(rs.getString(12), x, 11);
                    this.xmodelo.setValueAt(rs.getString(13), x, 12);
                    this.xmodelo.setValueAt(rs.getString(14), x, 13);
                    this.xmodelo.setValueAt(rs.getString(15), x, 14);
                    this.xmodelo.setValueAt(rs.getString(16), x, 15);
                    this.xmodelo.setValueAt(rs.getString(17), x, 16);
                    x++;
                }
                this.JTFFNRegistro.setText("" + x);
            }
            rs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            this.xct.mostrarErrorSQL(ex);
        }
    }

    private void mCargarDetalleFormulaUsuario() {
        this.xsql = "SELECT h_ordenes.Id, h_ordenes.FechaOrden, i_suministro.Nbre, i_principioactivo.Nbre, i_presentacionfarmaceutica.Nbre, h_itemordenessum.PosologiaManual, h_itemordenessum.Cantidad, h_itemordenessum.ValorUnitario, h_itemordenessum.ValorTotal, h_ordenes.Id_Atencion FROM h_ordenes INNER JOIN h_atencion  ON (h_ordenes.Id_Atencion = h_atencion.Id) INNER JOIN ingreso ON (h_atencion.Id_Ingreso = ingreso.Id) INNER JOIN persona_fpz  ON (persona_fpz.Id_persona = ingreso.Id_Usuario) INNER JOIN h_itemordenessum  ON (h_itemordenessum.Id_HOrdenes = h_ordenes.Id) INNER JOIN i_suministro  ON (h_itemordenessum.Id_Suministro = i_suministro.Id) INNER JOIN i_presentacioncomercial  ON (i_suministro.IdPresentacionComercial = i_presentacioncomercial.Id) INNER JOIN i_presentacionfarmaceutica  ON (i_suministro.IdPresentacionFarmaceutica = i_presentacionfarmaceutica.Id) INNER JOIN i_principioactivo  ON (i_suministro.IdPrincipioActivo = i_principioactivo.Id) WHERE (h_ordenes.EsPolimedicado =1 AND h_atencion.Fecha_Atencion >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND h_atencion.Fecha_Atencion <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' AND persona_fpz.Id_persona ='" + this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 16) + "' AND h_ordenes.Estado =0) ORDER BY h_ordenes.Id ASC, i_suministro.Nbre ASC ";
        mCrearTablaDetalleFormula();
        ResultSet rs = this.xct.traerRs(this.xsql);
        try {
            if (rs.next()) {
                rs.beforeFirst();
                int x = 0;
                double xvalor = 0.0d;
                while (rs.next()) {
                    this.xmodelo1.addRow(this.xdato);
                    this.xmodelo1.setValueAt(Long.valueOf(rs.getLong(1)), x, 0);
                    this.xmodelo1.setValueAt(rs.getString(2), x, 1);
                    this.xmodelo1.setValueAt(rs.getString(3), x, 2);
                    this.xmodelo1.setValueAt(rs.getString(4), x, 3);
                    this.xmodelo1.setValueAt(rs.getString(5), x, 4);
                    this.xmodelo1.setValueAt(rs.getString(6), x, 5);
                    this.xmodelo1.setValueAt(Long.valueOf(rs.getLong(7)), x, 6);
                    this.xmodelo1.setValueAt(Double.valueOf(rs.getDouble(8)), x, 7);
                    this.xmodelo1.setValueAt(Double.valueOf(rs.getDouble(9)), x, 8);
                    this.xmodelo1.setValueAt(rs.getString(10), x, 9);
                    xvalor += rs.getDouble(9);
                    x++;
                }
                this.JTFFNRegistroDF.setText("" + x);
                this.JTFFVFactura.setValue(Double.valueOf(xvalor));
            }
            rs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            this.xct.mostrarErrorSQL(ex);
        }
    }

    private void mBuscarDatosUsuario1(String sql) {
        mCrearTablaUsuarios();
        ResultSet rs = this.xct.traerRs(sql);
        try {
            if (rs.next()) {
                rs.beforeFirst();
                int x = 0;
                while (rs.next()) {
                    if (!this.xmt.mBuscarDatosBD("SELECT Id_Usuario FROM g_usuarioxprograma WHERE (Id_Usuario ='" + rs.getString(17) + "' AND Id_Programa ='" + this.xidprograma[this.JCBPrograma.getSelectedIndex()] + "' AND Estado =0)").booleanValue()) {
                        this.xmodelo.addRow(this.xdato);
                        this.xmodelo.setValueAt(rs.getString(1), x, 0);
                        this.xmodelo.setValueAt(rs.getString(2), x, 1);
                        this.xmodelo.setValueAt(rs.getString(3), x, 2);
                        this.xmodelo.setValueAt(rs.getString(4), x, 3);
                        this.xmodelo.setValueAt(rs.getString(5), x, 4);
                        this.xmodelo.setValueAt(rs.getString(6), x, 5);
                        this.xmodelo.setValueAt(rs.getString(7), x, 6);
                        this.xmodelo.setValueAt(rs.getString(8), x, 7);
                        this.xmodelo.setValueAt(rs.getString(9), x, 8);
                        this.xmodelo.setValueAt(rs.getString(10), x, 9);
                        this.xmodelo.setValueAt(rs.getString(11), x, 10);
                        this.xmodelo.setValueAt(rs.getString(12), x, 11);
                        this.xmodelo.setValueAt(rs.getString(13), x, 12);
                        this.xmodelo.setValueAt(rs.getString(14), x, 13);
                        this.xmodelo.setValueAt(rs.getString(15), x, 14);
                        this.xmodelo.setValueAt(rs.getString(16), x, 15);
                        this.xmodelo.setValueAt(rs.getString(17), x, 16);
                        x++;
                    }
                }
                this.JTFFNRegistro.setText("" + x);
            }
            rs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            this.xct.mostrarErrorSQL(ex);
        }
    }

    public void mBuscar() {
        if (this.JCHFiltro.isSelected()) {
            if (this.JCBPrograma.getSelectedIndex() != -1) {
                this.xsql = "SELECT persona_fpz.NoHistoria, persona_fpz.Id_TipoIdentificacion, persona_fpz.NoDocumento, persona_fpz.NUsuario, DATE_FORMAT(persona_fpz.FechaNac,'%d-%m-%Y')  AS FechaNac, persona_fpz.Edad , persona_fpz.NTipoEdad, persona_fpz.IdSexo, persona_fpz.NDepartamento, persona_fpz.NMunicipio, persona_fpz.Direccion, persona_fpz.Telefono, persona_fpz.TipoEmpresa, persona_fpz.Parentesco, persona_fpz.EPS , persona_fpz.TipoAfiliacion, persona_fpz.Id_persona FROM h_ordenes INNER JOIN h_atencion  ON (h_ordenes.Id_Atencion = h_atencion.Id) INNER JOIN ingreso  ON (h_atencion.Id_Ingreso = ingreso.Id) INNER JOIN persona_fpz  ON (persona_fpz.Id_persona = ingreso.Id_Usuario) INNER JOIN g_usuarioxprograma ON (g_usuarioxprograma.Id_Usuario = persona_fpz.Id_persona) WHERE (h_ordenes.EsPolimedicado =1 AND h_atencion.Fecha_Atencion >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND h_atencion.Fecha_Atencion <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' AND h_ordenes.Estado =0 AND g_usuarioxprograma.Id_Programa ='" + this.xidprograma[this.JCBPrograma.getSelectedIndex()] + "' ) GROUP BY persona_fpz.NoHistoria ORDER BY persona_fpz.NUsuario ASC ";
                mBuscarDatosUsuario(this.xsql);
                mCrearTablaDetalleFormula();
                mCrearTablaTestMorisky();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un programa", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBPrograma.requestFocus();
            return;
        }
        if (this.JCBPrograma.getSelectedIndex() != -1) {
            this.xsql = "SELECT persona_fpz.NoHistoria, persona_fpz.Id_TipoIdentificacion, persona_fpz.NoDocumento, persona_fpz.NUsuario, DATE_FORMAT(persona_fpz.FechaNac,'%d-%m-%Y')  AS FechaNac, persona_fpz.Edad , persona_fpz.NTipoEdad, persona_fpz.IdSexo, persona_fpz.NDepartamento, persona_fpz.NMunicipio, persona_fpz.Direccion, persona_fpz.Telefono, persona_fpz.TipoEmpresa, persona_fpz.Parentesco, persona_fpz.EPS , persona_fpz.TipoAfiliacion, persona_fpz.Id_persona FROM h_ordenes INNER JOIN h_atencion  ON (h_ordenes.Id_Atencion = h_atencion.Id) INNER JOIN ingreso  ON (h_atencion.Id_Ingreso = ingreso.Id) INNER JOIN persona_fpz  ON (persona_fpz.Id_persona = ingreso.Id_Usuario) WHERE (h_ordenes.EsPolimedicado =1 AND h_atencion.Fecha_Atencion >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND h_atencion.Fecha_Atencion <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' AND h_ordenes.Estado =0) GROUP BY persona_fpz.NoHistoria ORDER BY persona_fpz.NUsuario ASC ";
            mBuscarDatosUsuario1(this.xsql);
            mCrearTablaDetalleFormula();
            mCrearTablaTestMorisky();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un programa", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JCBPrograma.requestFocus();
    }

    private void mExportarInformacion() {
        if (this.JTDetalle.getRowCount() > 0) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                try {
                    WritableWorkbook workbook = Workbook.createWorkbook(new File(this.JTFRuta.getText() + ".xls"));
                    WritableSheet sheet = workbook.createSheet("plantilla", 0);
                    for (int x = 0; x < this.JTDetalle.getColumnCount(); x++) {
                        sheet.addCell(new Label(x, 0, this.JTDetalle.getColumnName(x)));
                    }
                    int y = 1;
                    for (int x2 = 0; x2 < this.JTDetalle.getRowCount(); x2++) {
                        sheet.addCell(new Number(0, y, Long.valueOf(this.xmodelo.getValueAt(x2, 0).toString()).longValue()));
                        sheet.addCell(new Label(1, y, this.xmodelo.getValueAt(x2, 1).toString()));
                        sheet.addCell(new Label(2, y, this.xmodelo.getValueAt(x2, 2).toString()));
                        sheet.addCell(new Label(3, y, this.xmodelo.getValueAt(x2, 3).toString()));
                        sheet.addCell(new Label(4, y, this.xmodelo.getValueAt(x2, 4).toString()));
                        sheet.addCell(new Number(5, y, Long.valueOf(this.xmodelo.getValueAt(x2, 5).toString()).longValue()));
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
                        y++;
                    }
                    workbook.write();
                    workbook.close();
                } catch (IOException ex) {
                    Logger.getLogger(JIFGestionProgramaP.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                } catch (WriteException e) {
                    Logger.getLogger(JIFGestionProgramaP.class.getName()).log(Level.SEVERE, (String) null, e);
                }
            }
        }
    }

    public void mImprimirFormula(long idorden, int n) {
        try {
            SimpleDateFormat xfechar = new SimpleDateFormat("dd/MM/yyyy");
            String xnotasad = null;
            String tipo = "Farmacia";
            String sql = "SELECT Id_Atencion, Id, FechaOrden FROM h_ordenes where Id='" + idorden + "'";
            ConsultasMySQL xmt1 = new ConsultasMySQL();
            ResultSet rsm = xmt1.traerRs(sql);
            rsm.first();
            long xida = rsm.getLong(1);
            if (rsm.getRow() != 0) {
                String sql2 = "SELECT Id_Atencion, Id, FechaOrden FROM  h_ordenes where  Id_Atencion='" + xida + "' and Id>'" + idorden + "' order by Id";
                rsm = this.xct.traerRs(sql2);
                rsm.next();
                if (rsm.getRow() != 0) {
                    xnotasad = "Orden N° : " + rsm.getInt(2) + "  - - - Fecha Proxima Entrega : " + xfechar.format((Date) rsm.getDate(3));
                }
                this.xct.cerrarConexionBd();
            }
            rsm.close();
            xmt1.cerrarConexionBd();
            String[][] mparametros = new String[6][2];
            for (int j = 0; j < n; j++) {
                mparametros[0][0] = "norden";
                mparametros[0][1] = String.valueOf(idorden);
                mparametros[1][0] = "xp2";
                mparametros[1][1] = tipo;
                mparametros[2][0] = "ip";
                mparametros[2][1] = xnotasad;
                mparametros[3][0] = "nusuarios";
                mparametros[3][1] = Principal.usuarioSistemaDTO.getLogin();
                mparametros[4][0] = "SUBREPORT_DIR";
                mparametros[4][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
                mparametros[5][0] = "SUBREPORTFIRMA_DIR";
                mparametros[5][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
                if (Principal.informacionIps.getEsFpz().intValue() == 0) {
                    this.xmt.GenerarPDF(this.xmt.getRutaRep() + "RFormulaGeneralMP", mparametros);
                } else {
                    this.xmt.PresentacionImpresora(this.xmt.getRutaRep() + "RFormulaGeneralMP1.jasper", mparametros);
                }
                tipo = "Usuario";
            }
        } catch (SQLException e) {
        }
    }

    private void mEvaluarCumplimiento() {
        if (this.xp1 == 0 && this.xp2 == 1 && this.xp3 == 0 && this.xp4 == 0) {
            this.JLBResultado.setText("CUMPLE");
            this.xcumple = 1;
        } else {
            this.JLBResultado.setText("INCUMPLE");
            this.xcumple = 0;
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTablaTestMorisky() {
        this.xmodelou = new DefaultTableModel(new Object[0], new String[]{"Id", "Fecha", "Especialidad", "Profesional", "P1", "P2", "P3", "P4", "Resultado"}) { // from class: PyP.JIFGestionProgramaP.16
            Class[] types = {Integer.class, String.class, String.class, String.class, Boolean.class, Boolean.class, Boolean.class, Boolean.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTPHistorialU.setModel(this.xmodelou);
        this.JTPHistorialU.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTPHistorialU.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTPHistorialU.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTPHistorialU.getColumnModel().getColumn(1).setPreferredWidth(30);
        this.JTPHistorialU.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTPHistorialU.getColumnModel().getColumn(3).setPreferredWidth(150);
        this.JTPHistorialU.getColumnModel().getColumn(4).setPreferredWidth(10);
        this.JTPHistorialU.getColumnModel().getColumn(5).setPreferredWidth(10);
        this.JTPHistorialU.getColumnModel().getColumn(6).setPreferredWidth(10);
        this.JTPHistorialU.getColumnModel().getColumn(7).setPreferredWidth(10);
        this.JTPHistorialU.getColumnModel().getColumn(8).setPreferredWidth(20);
    }

    private void mBuscarDatosTestMoriskyBd() {
        try {
            String sql = "SELECT p_test_morisky.Id, p_test_morisky.FechaT, profesional1.Especialidad, profesional1.NProfesional, p_test_morisky.P1, p_test_morisky.P2, p_test_morisky.P3, p_test_morisky.P4, if(p_test_morisky.P1=0 and p_test_morisky.P2=1 and p_test_morisky.P3=0 AND p_test_morisky.P4=0,'CUMPLE','INCUMPLE') AS Tipo FROM profesional1 INNER JOIN p_test_morisky  ON (profesional1.IdEspecialidad = p_test_morisky.Id_Especialidad) AND (profesional1.Id_Persona = p_test_morisky.Id_Profesional) WHERE (p_test_morisky.Estado =1 AND p_test_morisky.Id_Usuario ='" + this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 16) + "') ORDER BY p_test_morisky.FechaT DESC ";
            mCrearTablaTestMorisky();
            ResultSet rs = this.xct.traerRs(sql);
            if (rs.next()) {
                rs.beforeFirst();
                int x = 0;
                while (rs.next()) {
                    this.xmodelou.addRow(this.xdato);
                    this.xmodelou.setValueAt(Long.valueOf(rs.getLong(1)), x, 0);
                    this.xmodelou.setValueAt(rs.getString(2), x, 1);
                    this.xmodelou.setValueAt(rs.getString(3), x, 2);
                    this.xmodelou.setValueAt(rs.getString(4), x, 3);
                    this.xmodelou.setValueAt(Boolean.valueOf(rs.getBoolean(5)), x, 4);
                    this.xmodelou.setValueAt(Boolean.valueOf(rs.getBoolean(6)), x, 5);
                    this.xmodelou.setValueAt(Boolean.valueOf(rs.getBoolean(7)), x, 6);
                    this.xmodelou.setValueAt(Boolean.valueOf(rs.getBoolean(8)), x, 7);
                    this.xmodelou.setValueAt(rs.getString(9), x, 8);
                    this.JTPHistorialU.setDefaultRenderer(Object.class, new MiRender());
                    x++;
                }
            }
            rs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFGestionProgramaP.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX INFO: loaded from: GenomaP.jar:PyP/JIFGestionProgramaP$MiRender.class */
    public static class MiRender extends DefaultTableCellRenderer {
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (table.getValueAt(row, 8).toString().equals("INCUMPLE")) {
                cell.setBackground(new Color(97, 228, 183));
                cell.setForeground(Color.BLACK);
            } else {
                cell.setBackground(Color.WHITE);
                cell.setForeground(Color.BLACK);
            }
            return cell;
        }
    }
}
