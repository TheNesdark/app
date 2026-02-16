package Sig;

import Acceso.Principal;
import Facturacion.Furips_PA;
import Facturacion.Furips_PB;
import General.JD_Impresin_Central_Dc;
import Historia.ReporteAnexo2;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.genoma.plus.controller.utilidades.JDRegistroTrazabilidad;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyVetoException;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.Icon;
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
import javax.swing.text.DateFormatter;
import javax.swing.text.DefaultFormatterFactory;

/* JADX INFO: loaded from: GenomaP.jar:Sig/JIFInformesNProgramadaRangoHora.class */
public class JIFInformesNProgramadaRangoHora extends JInternalFrame {
    private String[] xidtipodato;
    private Object[] xdatos;
    public DefaultTableModel xmodelo;
    public DefaultTableModel xmodelo1;
    public DefaultTableModel xmodelo2;
    private JButton JBAbrir_Hc;
    private JButton JBAbrir_Hc1;
    private JButton JBAnexo_dos;
    private ButtonGroup JBGEstado;
    private JButton JBTActualizar;
    private JButton JBTExportar;
    private JComboBox JCBUno;
    private JCheckBox JCHFiltro;
    private JCheckBox JCHFiltroB;
    private JCheckBox JCH_FiltroProg;
    private JDateChooser JDFechaF;
    private JDateChooser JDFechaI;
    private JLabel JLContador;
    private JPanel JPDatos1;
    private JPanel JPExportar;
    private JPanel JPIDetalle1;
    private JPanel JPIEstado1;
    private JPanel JPI_Utilidades;
    private JRadioButton JRBDeAlta;
    private JRadioButton JRBEnAtencion1;
    private JRadioButton JRBTodos;
    private JScrollPane JSPDetalle2;
    public JTable JTBDetalle2;
    private JTextField JTFBusqueda;
    private JTextField JTFRuta;
    private JTabbedPane JTPResultado;
    private JTabbedPane jTabbedPane1;
    public JFormattedTextField txtHoraF;
    public JFormattedTextField txtHoraI;
    private Metodos xmt = new Metodos();
    private ConsultasMySQL xconsultabd = new ConsultasMySQL();
    private String xfiltro = "0,1";

    public JIFInformesNProgramadaRangoHora(String xnombre) {
        initComponents();
        setName(xnombre);
        mNuevo();
        if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL LOCAL DE MONTELIBANO") || Principal.informacionIps.getIdentificacion().equals("812005644")) {
            this.JBAbrir_Hc.setVisible(false);
        }
    }

    /* JADX WARN: Type inference failed for: r3v67, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGEstado = new ButtonGroup();
        this.JPDatos1 = new JPanel();
        this.JCBUno = new JComboBox();
        this.JDFechaI = new JDateChooser();
        this.JDFechaF = new JDateChooser();
        this.JCHFiltro = new JCheckBox();
        this.JPIEstado1 = new JPanel();
        this.JRBEnAtencion1 = new JRadioButton();
        this.JRBDeAlta = new JRadioButton();
        this.JRBTodos = new JRadioButton();
        this.txtHoraI = new JFormattedTextField();
        this.txtHoraF = new JFormattedTextField();
        this.JLContador = new JLabel();
        this.JCH_FiltroProg = new JCheckBox();
        this.JCHFiltroB = new JCheckBox();
        this.JTFBusqueda = new JTextField();
        this.JTPResultado = new JTabbedPane();
        this.JPIDetalle1 = new JPanel();
        this.JSPDetalle2 = new JScrollPane();
        this.JTBDetalle2 = new JTable();
        this.jTabbedPane1 = new JTabbedPane();
        this.JPI_Utilidades = new JPanel();
        this.JBTActualizar = new JButton();
        this.JBAnexo_dos = new JButton();
        this.JBAbrir_Hc = new JButton();
        this.JBAbrir_Hc1 = new JButton();
        this.JPExportar = new JPanel();
        this.JTFRuta = new JTextField();
        this.JBTExportar = new JButton();
        setClosable(true);
        setIconifiable(true);
        setTitle("ATENCIONES NO PROGRAMAS");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setMaximumSize(null);
        setMinimumSize(null);
        setName("jifatencionesnpfachora");
        setRequestFocusEnabled(false);
        try {
            setSelected(true);
        } catch (PropertyVetoException e1) {
            e1.printStackTrace();
        }
        this.JPDatos1.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS PARA CONSULTA", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JCBUno.setFont(new Font("Arial", 1, 12));
        this.JCBUno.setBorder(BorderFactory.createTitledBorder((Border) null, "Sede", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicial", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFechaI.setFont(new Font("Arial", 1, 12));
        this.JDFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Final", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFechaF.setFont(new Font("Arial", 1, 12));
        this.JCHFiltro.setFont(new Font("Arial", 1, 12));
        this.JCHFiltro.setText("Filtro por Fact");
        this.JCHFiltro.addActionListener(new ActionListener() { // from class: Sig.JIFInformesNProgramadaRangoHora.1
            public void actionPerformed(ActionEvent evt) {
                JIFInformesNProgramadaRangoHora.this.JCHFiltroActionPerformed(evt);
            }
        });
        this.JPIEstado1.setBorder(BorderFactory.createTitledBorder((Border) null, "Estado", 0, 0, new Font("Arial", 1, 12), new Color(255, 0, 0)));
        this.JBGEstado.add(this.JRBEnAtencion1);
        this.JRBEnAtencion1.setFont(new Font("Arial", 1, 12));
        this.JRBEnAtencion1.setForeground(Color.blue);
        this.JRBEnAtencion1.setText("En Atención");
        this.JRBEnAtencion1.addActionListener(new ActionListener() { // from class: Sig.JIFInformesNProgramadaRangoHora.2
            public void actionPerformed(ActionEvent evt) {
                JIFInformesNProgramadaRangoHora.this.JRBEnAtencion1ActionPerformed(evt);
            }
        });
        this.JBGEstado.add(this.JRBDeAlta);
        this.JRBDeAlta.setFont(new Font("Arial", 1, 12));
        this.JRBDeAlta.setForeground(Color.blue);
        this.JRBDeAlta.setText("De Alta");
        this.JRBDeAlta.addActionListener(new ActionListener() { // from class: Sig.JIFInformesNProgramadaRangoHora.3
            public void actionPerformed(ActionEvent evt) {
                JIFInformesNProgramadaRangoHora.this.JRBDeAltaActionPerformed(evt);
            }
        });
        this.JBGEstado.add(this.JRBTodos);
        this.JRBTodos.setFont(new Font("Arial", 1, 12));
        this.JRBTodos.setForeground(Color.blue);
        this.JRBTodos.setSelected(true);
        this.JRBTodos.setText("Todos");
        this.JRBTodos.addActionListener(new ActionListener() { // from class: Sig.JIFInformesNProgramadaRangoHora.4
            public void actionPerformed(ActionEvent evt) {
                JIFInformesNProgramadaRangoHora.this.JRBTodosActionPerformed(evt);
            }
        });
        GroupLayout JPIEstado1Layout = new GroupLayout(this.JPIEstado1);
        this.JPIEstado1.setLayout(JPIEstado1Layout);
        JPIEstado1Layout.setHorizontalGroup(JPIEstado1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIEstado1Layout.createSequentialGroup().addContainerGap().addComponent(this.JRBTodos).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JRBEnAtencion1).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBDeAlta).addContainerGap()));
        JPIEstado1Layout.setVerticalGroup(JPIEstado1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIEstado1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBEnAtencion1).addComponent(this.JRBDeAlta).addComponent(this.JRBTodos)));
        this.txtHoraI.setBorder(BorderFactory.createTitledBorder((Border) null, "Hora Inicial", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.txtHoraI.setFormatterFactory(new DefaultFormatterFactory(new DateFormatter(new SimpleDateFormat("HH:mm"))));
        this.txtHoraI.setFont(new Font("Tahoma", 1, 12));
        this.txtHoraI.addKeyListener(new KeyAdapter() { // from class: Sig.JIFInformesNProgramadaRangoHora.5
            public void keyPressed(KeyEvent evt) {
                JIFInformesNProgramadaRangoHora.this.txtHoraIKeyPressed(evt);
            }
        });
        this.txtHoraF.setBorder(BorderFactory.createTitledBorder((Border) null, "Hora Final", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.txtHoraF.setFormatterFactory(new DefaultFormatterFactory(new DateFormatter(new SimpleDateFormat("HH:mm"))));
        this.txtHoraF.setFont(new Font("Tahoma", 1, 12));
        this.txtHoraF.addKeyListener(new KeyAdapter() { // from class: Sig.JIFInformesNProgramadaRangoHora.6
            public void keyPressed(KeyEvent evt) {
                JIFInformesNProgramadaRangoHora.this.txtHoraFKeyPressed(evt);
            }
        });
        this.JLContador.setFont(new Font("Arial", 1, 12));
        this.JLContador.setHorizontalAlignment(0);
        this.JLContador.setText("0");
        this.JLContador.setBorder(BorderFactory.createTitledBorder((Border) null, "Nº Registros", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JCH_FiltroProg.setFont(new Font("Arial", 1, 12));
        this.JCH_FiltroProg.setSelected(true);
        this.JCH_FiltroProg.setText("No programas?");
        this.JCHFiltroB.setFont(new Font("Arial", 1, 12));
        this.JCHFiltroB.setText("Filtro?");
        this.JTFBusqueda.setFont(new Font("Arial", 1, 12));
        this.JTFBusqueda.setBorder(BorderFactory.createTitledBorder((Border) null, "Búsqueda de usuario por apellido", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPDatos1Layout = new GroupLayout(this.JPDatos1);
        this.JPDatos1.setLayout(JPDatos1Layout);
        JPDatos1Layout.setHorizontalGroup(JPDatos1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPDatos1Layout.createSequentialGroup().addContainerGap().addGroup(JPDatos1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.txtHoraI).addComponent(this.JDFechaI, -2, 120, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPDatos1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JDFechaF, -1, -1, 32767).addComponent(this.txtHoraF, -2, 120, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPDatos1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatos1Layout.createSequentialGroup().addComponent(this.JPIEstado1, -2, -1, -2).addGap(18, 18, 18).addComponent(this.JCBUno, -2, 308, -2)).addGroup(JPDatos1Layout.createSequentialGroup().addComponent(this.JLContador, -2, 93, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFBusqueda, -2, 357, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPDatos1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHFiltro).addComponent(this.JCHFiltroB).addComponent(this.JCH_FiltroProg)).addContainerGap(-1, 32767)));
        JPDatos1Layout.setVerticalGroup(JPDatos1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatos1Layout.createSequentialGroup().addContainerGap().addGroup(JPDatos1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatos1Layout.createSequentialGroup().addGroup(JPDatos1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JDFechaI, -2, 50, -2).addComponent(this.JDFechaF, -2, 50, -2).addComponent(this.JPIEstado1, -2, -1, -2)).addGroup(JPDatos1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatos1Layout.createSequentialGroup().addGap(4, 4, 4).addGroup(JPDatos1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.txtHoraI, -2, 50, -2).addComponent(this.txtHoraF, -2, 50, -2))).addGroup(JPDatos1Layout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPDatos1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JLContador, -1, -1, 32767).addComponent(this.JTFBusqueda, -2, 50, -2))))).addGroup(JPDatos1Layout.createSequentialGroup().addComponent(this.JCBUno, -2, 50, -2).addGap(0, 0, 32767)).addGroup(JPDatos1Layout.createSequentialGroup().addComponent(this.JCHFiltro).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCH_FiltroProg).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JCHFiltroB))).addContainerGap()));
        this.JTPResultado.setForeground(Color.red);
        this.JTPResultado.setFont(new Font("Arial", 1, 14));
        this.JTBDetalle2.setBorder(BorderFactory.createBevelBorder(0));
        this.JTBDetalle2.setFont(new Font("Arial", 1, 12));
        this.JTBDetalle2.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTBDetalle2.setEditingColumn(1);
        this.JTBDetalle2.setEditingRow(1);
        this.JTBDetalle2.setRowHeight(25);
        this.JTBDetalle2.setSelectionBackground(new Color(255, 255, 255));
        this.JTBDetalle2.setSelectionForeground(Color.red);
        this.JTBDetalle2.addMouseListener(new MouseAdapter() { // from class: Sig.JIFInformesNProgramadaRangoHora.7
            public void mouseClicked(MouseEvent evt) {
                JIFInformesNProgramadaRangoHora.this.JTBDetalle2MouseClicked(evt);
            }
        });
        this.JSPDetalle2.setViewportView(this.JTBDetalle2);
        GroupLayout JPIDetalle1Layout = new GroupLayout(this.JPIDetalle1);
        this.JPIDetalle1.setLayout(JPIDetalle1Layout);
        JPIDetalle1Layout.setHorizontalGroup(JPIDetalle1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDetalle1Layout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.JSPDetalle2, -1, 1106, 32767).addContainerGap()));
        JPIDetalle1Layout.setVerticalGroup(JPIDetalle1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDetalle1Layout.createSequentialGroup().addContainerGap().addComponent(this.JSPDetalle2, -2, 368, -2).addContainerGap(-1, 32767)));
        this.JTPResultado.addTab("USUARIOS ATENDIDOS", this.JPIDetalle1);
        this.jTabbedPane1.setForeground(new Color(0, 103, 0));
        this.jTabbedPane1.setFont(new Font("Arial", 1, 14));
        this.JBTActualizar.setFont(new Font("Arial", 1, 12));
        this.JBTActualizar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/actualizar.png")));
        this.JBTActualizar.setText("<html><P ALIGN=center>Actualizar Agenda");
        this.JBTActualizar.addActionListener(new ActionListener() { // from class: Sig.JIFInformesNProgramadaRangoHora.8
            public void actionPerformed(ActionEvent evt) {
                JIFInformesNProgramadaRangoHora.this.JBTActualizarActionPerformed(evt);
            }
        });
        this.JBAnexo_dos.setFont(new Font("Arial", 1, 12));
        this.JBAnexo_dos.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Contrato2.png")));
        this.JBAnexo_dos.setText("Anexo 2");
        this.JBAnexo_dos.addActionListener(new ActionListener() { // from class: Sig.JIFInformesNProgramadaRangoHora.9
            public void actionPerformed(ActionEvent evt) {
                JIFInformesNProgramadaRangoHora.this.JBAnexo_dosActionPerformed(evt);
            }
        });
        this.JBAbrir_Hc.setFont(new Font("Arial", 1, 12));
        this.JBAbrir_Hc.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Configuracion29x27.png")));
        this.JBAbrir_Hc.setText("Abrir Hc");
        this.JBAbrir_Hc.addActionListener(new ActionListener() { // from class: Sig.JIFInformesNProgramadaRangoHora.10
            public void actionPerformed(ActionEvent evt) {
                JIFInformesNProgramadaRangoHora.this.JBAbrir_HcActionPerformed(evt);
            }
        });
        this.JBAbrir_Hc1.setFont(new Font("Arial", 1, 12));
        this.JBAbrir_Hc1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/FinalidadProcedimiento.png")));
        this.JBAbrir_Hc1.setText("Registro Trazabilidad");
        this.JBAbrir_Hc1.addActionListener(new ActionListener() { // from class: Sig.JIFInformesNProgramadaRangoHora.11
            public void actionPerformed(ActionEvent evt) {
                JIFInformesNProgramadaRangoHora.this.JBAbrir_Hc1ActionPerformed(evt);
            }
        });
        GroupLayout JPI_UtilidadesLayout = new GroupLayout(this.JPI_Utilidades);
        this.JPI_Utilidades.setLayout(JPI_UtilidadesLayout);
        JPI_UtilidadesLayout.setHorizontalGroup(JPI_UtilidadesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_UtilidadesLayout.createSequentialGroup().addGap(18, 18, 18).addComponent(this.JBTActualizar, -2, 250, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBAnexo_dos, -2, 250, -2).addGap(18, 18, 18).addComponent(this.JBAbrir_Hc, -2, 250, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 24, 32767).addComponent(this.JBAbrir_Hc1, -2, 250, -2).addGap(21, 21, 21)));
        JPI_UtilidadesLayout.setVerticalGroup(JPI_UtilidadesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_UtilidadesLayout.createSequentialGroup().addContainerGap().addGroup(JPI_UtilidadesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPI_UtilidadesLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBTActualizar, -2, 70, -2).addComponent(this.JBAnexo_dos, -2, 70, -2)).addGroup(GroupLayout.Alignment.TRAILING, JPI_UtilidadesLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBAbrir_Hc, -2, 70, -2).addComponent(this.JBAbrir_Hc1, -2, 70, -2))).addContainerGap(19, 32767)));
        this.jTabbedPane1.addTab("UTILIDADES", this.JPI_Utilidades);
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: Sig.JIFInformesNProgramadaRangoHora.12
            public void mouseClicked(MouseEvent evt) {
                JIFInformesNProgramadaRangoHora.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JTFRuta.addActionListener(new ActionListener() { // from class: Sig.JIFInformesNProgramadaRangoHora.13
            public void actionPerformed(ActionEvent evt) {
                JIFInformesNProgramadaRangoHora.this.JTFRutaActionPerformed(evt);
            }
        });
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setForeground(Color.red);
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: Sig.JIFInformesNProgramadaRangoHora.14
            public void actionPerformed(ActionEvent evt) {
                JIFInformesNProgramadaRangoHora.this.JBTExportarActionPerformed(evt);
            }
        });
        GroupLayout JPExportarLayout = new GroupLayout(this.JPExportar);
        this.JPExportar.setLayout(JPExportarLayout);
        JPExportarLayout.setHorizontalGroup(JPExportarLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPExportarLayout.createSequentialGroup().addContainerGap().addComponent(this.JTFRuta, -2, 558, -2).addGap(18, 18, 18).addComponent(this.JBTExportar, -2, 145, -2).addContainerGap(-1, 32767)));
        JPExportarLayout.setVerticalGroup(JPExportarLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPExportarLayout.createSequentialGroup().addContainerGap().addGroup(JPExportarLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JBTExportar, GroupLayout.Alignment.TRAILING, -2, 48, -2).addComponent(this.JTFRuta, GroupLayout.Alignment.TRAILING, -2, 48, -2)).addContainerGap(-1, 32767)));
        this.jTabbedPane1.addTab("EXPORTAR", this.JPExportar);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.JPDatos1, -1, -1, 32767)).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(6, 6, 6).addComponent(this.jTabbedPane1, -2, 1093, -2).addGap(0, 0, 32767)).addComponent(this.JTPResultado)))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPDatos1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTPResultado, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 24, 32767).addComponent(this.jTabbedPane1, -2, -1, -2).addGap(22, 22, 22)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHFiltroActionPerformed(ActionEvent evt) {
        mCargarDatosTabla2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBEnAtencion1ActionPerformed(ActionEvent evt) {
        this.xfiltro = "0";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBDeAltaActionPerformed(ActionEvent evt) {
        this.xfiltro = "1";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBDetalle2MouseClicked(MouseEvent evt) {
        if (this.JTBDetalle2.getSelectedRow() != -1) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Desea ver la Impresión Centralizada", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                JD_Impresin_Central_Dc xjd = new JD_Impresin_Central_Dc(null, true, this.xmodelo2.getValueAt(this.JTBDetalle2.getSelectedRow(), 13).toString(), this.xmodelo2.getValueAt(this.JTBDetalle2.getSelectedRow(), 14).toString(), this.xmodelo2.getValueAt(this.JTBDetalle2.getSelectedRow(), 15).toString(), this.xmodelo2.getValueAt(this.JTBDetalle2.getSelectedRow(), 18).toString(), Integer.valueOf(this.xmodelo2.getValueAt(this.JTBDetalle2.getSelectedRow(), 20).toString()), "");
                xjd.setLocationRelativeTo(this);
                xjd.setVisible(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTActualizarActionPerformed(ActionEvent evt) {
        if (this.JCHFiltroB.isSelected()) {
            if (!this.JTFBusqueda.getText().isEmpty()) {
                mCargarDatosTabla2();
                return;
            }
            return;
        }
        mBuscar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBAnexo_dosActionPerformed(ActionEvent evt) {
        if (this.JTBDetalle2.getSelectedRow() != -1) {
            mVerificarAnexoDos(this.xmodelo2.getValueAt(this.JTBDetalle2.getSelectedRow(), 13).toString());
        } else {
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un registro", "Verificación", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBAbrir_HcActionPerformed(ActionEvent evt) {
        if (this.JTBDetalle2.getSelectedRow() != -1) {
            String xsql = "update h_atencion set TipoGuardado=0 where Id='" + this.xmodelo2.getValueAt(this.JTBDetalle2.getSelectedRow(), 13) + "'";
            this.xconsultabd.ejecutarSQL(xsql);
            this.xconsultabd.cerrarConexionBd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBTodosActionPerformed(ActionEvent evt) {
        this.xfiltro = "0,1";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtHoraIKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.txtHoraI.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtHoraFKeyPressed(KeyEvent evt) {
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
    public void JTFRutaActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTExportarActionPerformed(ActionEvent evt) {
        mExportar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBAbrir_Hc1ActionPerformed(ActionEvent evt) {
        if (this.JTBDetalle2.getSelectedRow() != -1) {
            JDRegistroTrazabilidad trazabilidad = new JDRegistroTrazabilidad(null, true, Long.valueOf(this.JTBDetalle2.getValueAt(this.JTBDetalle2.getSelectedRow(), 15).toString()), "ANEXO 2");
            trazabilidad.setLocationRelativeTo(this);
            trazabilidad.setVisible(true);
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un registro", "VERIFICAR", 1, new ImageIcon("src/Imagenes/Information.png"));
    }

    private void mVerAnexo2() {
        ReporteAnexo2 x = new ReporteAnexo2(this.xmodelo2.getValueAt(this.JTBDetalle2.getSelectedRow(), 13).toString(), 0);
        x.build();
        this.xmt.mostrarPdf(this.xmt.getRutaRep() + "H_Anexo2.pdf");
    }

    private String mGeneraNoAtencion() {
        String xNoAtencion = null;
        String sql = "SELECT `h_atencion_anexo_dos`.`Id` , IF(MAX(`h_atencion_anexo_dos`.`IdAteAnexo2`)IS NULL,1,(MAX(`h_atencion_anexo_dos`.`IdAteAnexo2`)+1)) AS maximo\n , `h_atencion_anexo_dos`.`FechaR` FROM `h_atencion_anexo_dos`  INNER JOIN `h_atencion`  ON (`h_atencion_anexo_dos`.`IdAtencion` = `h_atencion`.`Id`) WHERE (`h_atencion_anexo_dos`.`FechaR` ='" + this.xmt.formatoAMD.format(this.xmt.getFechaActual()) + "')";
        ConsultasMySQL xct = new ConsultasMySQL();
        ResultSet xrs = xct.traerRs(sql);
        try {
            if (xrs.next()) {
                xrs.first();
                xNoAtencion = xrs.getString("maximo");
            }
            xrs.close();
            xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFInformesNProgramadaRangoHora.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return xNoAtencion;
    }

    private void mVerificarAnexoDos(String xAtencion) {
        String sql = "SELECT  `h_atencion_anexo_dos`.`IdAteAnexo2` FROM `h_atencion_anexo_dos`  WHERE (`h_atencion_anexo_dos`.`IdAtencion` ='" + xAtencion + "')";
        ResultSet xrs = this.xconsultabd.traerRs(sql);
        System.out.println("sql-->" + sql);
        try {
            if (xrs.next()) {
                xrs.first();
                mVerAnexo2();
            } else {
                String sql2 = "INSERT INTO `h_atencion_anexo_dos` ( `IdAtencion`, `IdAteAnexo2`, `IdUsuarioS`, `FechaR`, `HoraR`, `UsuarioS`)\nVALUES ( '" + xAtencion + "', '" + mGeneraNoAtencion() + "', '" + Principal.usuarioSistemaDTO.getIdPersonaCargo() + "', '" + this.xmt.formatoAMD.format(this.xmt.getFechaActual()) + "', '" + this.xmt.formatoH24.format(this.xmt.getFechaActual()) + "', '" + Principal.usuarioSistemaDTO.getLogin() + "');";
                this.xconsultabd.ejecutarSQL(sql2);
                this.xconsultabd.cerrarConexionBd();
                mVerAnexo2();
            }
            xrs.close();
            this.xconsultabd.cerrarConexionBd();
            this.xmt.getInterceptor(Long.valueOf(this.JTBDetalle2.getValueAt(this.JTBDetalle2.getSelectedRow(), 15).toString()), "SOLICITUD DE ANEXO 2 ", "Solicitud de anexo dos generado desde el sistema", true);
        } catch (SQLException ex) {
            Logger.getLogger(JIFInformesNProgramadaRangoHora.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mNuevo() {
        this.JDFechaI.setDate(this.xmt.getFechaActual());
        this.JDFechaF.setDate(this.xmt.getFechaActual());
        this.txtHoraI.setValue(this.xmt.getFechaActual());
        this.txtHoraF.setValue(this.xmt.getFechaActual());
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
        this.JLContador.setText("0");
        this.JCBUno.removeAllItems();
        this.xidtipodato = this.xconsultabd.llenarCombo("SELECT Id, Nbre FROM g_sedes ORDER BY Nbre ASC", this.xidtipodato, this.JCBUno);
        this.JCBUno.setSelectedIndex(0);
        this.xconsultabd.cerrarConexionBd();
    }

    private void mExportar() {
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTBDetalle2, this.JTFRuta.getText(), this.title);
        }
    }

    public void mBuscar() {
        if (this.JCBUno.getSelectedIndex() != -1) {
            mCargarDatosTabla2();
        } else {
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una sede", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            this.JCBUno.requestFocus();
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos2() {
        this.xmodelo2 = new DefaultTableModel(new Object[0], new String[]{"Fecha", "Hora", "NHC", "Usuario", "Edad", "Sexo", "DxP", "DxR1", "DxR2", "DxR3", "Clase Cita", "Empresa", "F?", "Id_Atencion", "Id_Usuario", "Id_Ingreso", "Cod_Victima", "UsuarioS", "IdTipoA", "Estado", "idTipoHistoria", "Tiempo(Hora)", "C/Triage", "alerta"}) { // from class: Sig.JIFInformesNProgramadaRangoHora.15
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Integer.class, String.class, String.class, String.class, Integer.class, String.class, String.class, String.class, Integer.class, Long.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTBDetalle2.setAutoResizeMode(0);
        this.JTBDetalle2.doLayout();
        this.JTBDetalle2.setModel(this.xmodelo2);
        this.JTBDetalle2.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTBDetalle2.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTBDetalle2.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTBDetalle2.getColumnModel().getColumn(3).setPreferredWidth(300);
        this.JTBDetalle2.getColumnModel().getColumn(4).setPreferredWidth(80);
        this.JTBDetalle2.getColumnModel().getColumn(5).setPreferredWidth(80);
        this.JTBDetalle2.getColumnModel().getColumn(6).setPreferredWidth(80);
        this.JTBDetalle2.getColumnModel().getColumn(7).setPreferredWidth(50);
        this.JTBDetalle2.getColumnModel().getColumn(8).setPreferredWidth(80);
        this.JTBDetalle2.getColumnModel().getColumn(9).setPreferredWidth(80);
        this.JTBDetalle2.getColumnModel().getColumn(10).setPreferredWidth(150);
        this.JTBDetalle2.getColumnModel().getColumn(11).setPreferredWidth(300);
        this.JTBDetalle2.getColumnModel().getColumn(12).setPreferredWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(12).setMinWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(12).setMaxWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(13).setPreferredWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(13).setMinWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(13).setMaxWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(14).setPreferredWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(14).setMinWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(14).setMaxWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(15).setPreferredWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(15).setMinWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(15).setMaxWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(16).setPreferredWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(16).setMinWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(16).setMaxWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(17).setPreferredWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(17).setMinWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(17).setMaxWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(18).setPreferredWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(18).setMinWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(18).setMaxWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(19).setPreferredWidth(100);
        this.JTBDetalle2.getColumnModel().getColumn(20).setPreferredWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(20).setMinWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(20).setMaxWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(21).setPreferredWidth(100);
        this.JTBDetalle2.getColumnModel().getColumn(22).setPreferredWidth(100);
        this.JTBDetalle2.getColumnModel().getColumn(23).setPreferredWidth(100);
    }

    private void mCargarDatosTabla2() {
        try {
            String sql = null;
            mCrearModeloDatos2();
            if (this.JRBEnAtencion1.isSelected()) {
                if (this.JCHFiltroB.isSelected()) {
                    if (this.JCH_FiltroProg.isSelected()) {
                        sql = "SELECT  DATE_FORMAT(h_atencion.Fecha_Atencion,'%d-%m-%Y') AS fecha, h_atencion.Hora_Atencion, g_usuario.NoHistoria,  CONCAT(g_persona.`Apellido1`, ' ',g_persona.`Apellido2`, ' ',g_persona.`Nombre1`, ' ',g_persona.`Nombre2`) AS NUsuario, CONCAT(g_persona.Edad ,' ' , g_tipoedad.`Nbre` ) AS Edad    , g_persona.`Id_Sexo`    , h_atencion.Codigo_Dxp , h_atencion.Codigo_DxR1 , h_atencion.Codigo_DxR2 , h_atencion.Codigo_DxR3, c_clasecita.Nbre AS NClaseCita, f_empresacontxconvenio.Nbre AS NEmpresa,c_citasnp.EstaFacturada, h_atencion.`Id`, g_persona.`Id`, ingreso.Id AS IdIngreso, ingreso.Id_CondVict, ingreso.UsuarioS, ingreso.Id_TipoAtencion, IF(`ingreso`.`Egreso`=0, 'EN ATENCION', 'DE ALTA') AS EgresoE,`c_clasecita`.`Id_Historia`  , TIMESTAMPDIFF(Hour,  concat(h_atencion.Fecha_Atencion, ' ', h_atencion.Hora_Atencion), if(h_egreso_atencion.Id is null, now(), concat(h_egreso_atencion.FechaSO, ' ', h_egreso_atencion.HoraSO))) as  hora   , ifnull(ht.Clasificacion, 'NO CLASIFICADO') triage , if(d.alerta='true', true , false) alerta FROM `profesional1` INNER JOIN `c_citasnp` ON (`profesional1`.`Id_Persona` = `c_citasnp`.`Id_Profesional`) AND (`profesional1`.`IdEspecialidad` = `c_citasnp`.`Id_Especialidad`) INNER JOIN `ingreso`  ON (`ingreso`.`Id` = `c_citasnp`.`Id_ingreso`) INNER JOIN `g_usuario`  ON (`g_usuario`.`Id_persona` = `ingreso`.`Id_Usuario`)   INNER JOIN `g_persona`  ON (`g_persona`.`Id` = `g_usuario`.`Id_persona`)  INNER JOIN `g_tipoedad`  ON (`g_persona`.`Id_TipoEdad` = `g_tipoedad`.`Id`) INNER JOIN `f_empresacontxconvenio`  ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`) INNER JOIN `h_atencion`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`) INNER JOIN `c_clasecita`  ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`)  inner join g_tipoatencion gton on (ingreso.`Id_TipoAtencion`=gton.Id)\t\n left join h_triage ht on (ht.IdIngreso=`ingreso`.`Id`) left join h_egreso_atencion on (h_egreso_atencion.Id_Ingreso=ingreso.Id) and (h_egreso_atencion.Id_Tipo=ingreso.Id_TipoAtencion) and (h_egreso_atencion.Estado=1)  left join (SELECT gtp.idIngreso, gtp.Id , \n       JSON_UNQUOTE(JSON_EXTRACT(json_entry, '$.usuario')) AS usuario,\n       JSON_UNQUOTE(JSON_EXTRACT(json_entry, '$.cargo')) AS cargo,\n       JSON_UNQUOTE(JSON_EXTRACT(json_entry, '$.accion')) AS accion,\n       JSON_UNQUOTE(JSON_EXTRACT(json_entry, '$.motivo')) AS motivo,\n       JSON_UNQUOTE(JSON_EXTRACT(json_entry, '$.idmodulo')) AS idmodulo,\n       JSON_UNQUOTE(JSON_EXTRACT(json_entry, '$.alerta')) AS alerta\nFROM g_trazabilidad_proceso gtp ,\n     JSON_TABLE(gtp.detalleProcesos , '$[*]' \n     COLUMNS (\n         json_entry JSON PATH '$'\n     )) AS log_entries\nWHERE JSON_UNQUOTE(JSON_EXTRACT(json_entry, '$.idmodulo')) = '5'\n  AND JSON_UNQUOTE(JSON_EXTRACT(json_entry, '$.alerta')) = 'true'\n  -- and gtp.idIngreso =5340\n  group by gtp.idIngreso) d on (d.idIngreso=ingreso.Id)  WHERE (gton.Id_TipoAmbito = 3 AND CONCAT(g_persona.`Apellido1`, ' ',g_persona.`Apellido2`, ' ',g_persona.`Nombre1`, ' ',g_persona.`Nombre2`) like'" + this.JTFBusqueda.getText() + "%' and CONVERT(CONCAT(`Fecha_Cita`, ' ' ,`HoraInicial`), DATETIME)   >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + " " + this.xmt.formatoH24.format(this.txtHoraI.getValue()) + ":00'  AND CONVERT(CONCAT(`Fecha_Cita`, ' ' ,`HoraInicial`), DATETIME)  <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + " " + this.xmt.formatoH24.format(this.txtHoraF.getValue()) + ":00' AND `ingreso`.`Egreso`=0   AND ingreso.Id_Sede ='" + this.xidtipodato[this.JCBUno.getSelectedIndex()] + "'  )   ORDER BY fecha DESC, h_atencion.Hora_Atencion DESC";
                    } else {
                        sql = "SELECT  DATE_FORMAT(h_atencion.Fecha_Atencion,'%d-%m-%Y') AS fecha, h_atencion.Hora_Atencion, g_usuario.NoHistoria,  CONCAT(g_persona.`Apellido1`, ' ',g_persona.`Apellido2`, ' ',g_persona.`Nombre1`, ' ',g_persona.`Nombre2`) AS NUsuario, CONCAT(g_persona.Edad ,' ' , g_tipoedad.`Nbre` ) AS Edad    , g_persona.`Id_Sexo`    , h_atencion.Codigo_Dxp , h_atencion.Codigo_DxR1 , h_atencion.Codigo_DxR2 , h_atencion.Codigo_DxR3, c_clasecita.Nbre AS NClaseCita, f_empresacontxconvenio.Nbre AS NEmpresa,1, h_atencion.`Id`, g_persona.`Id`, ingreso.Id AS IdIngreso, ingreso.Id_CondVict, ingreso.UsuarioS, ingreso.Id_TipoAtencion, IF(`ingreso`.`Egreso`=0, 'EN ATENCION', 'DE ALTA') AS EgresoE,`c_clasecita`.`Id_Historia`  , TIMESTAMPDIFF(Hour,  concat(h_atencion.Fecha_Atencion, ' ', h_atencion.Hora_Atencion), if(h_egreso_atencion.Id is null, now(), concat(h_egreso_atencion.FechaSO, ' ', h_egreso_atencion.HoraSO))) as  hora   , ifnull(ht.Clasificacion, 'NO CLASIFICADO') triage, if(d.alerta='true', true , false) alerta FROM `profesional1` INNER JOIN `c_citas` ON (`profesional1`.`Id_Persona` = `c_citas`.`Id_Profesional`) AND (`profesional1`.`IdEspecialidad` = `c_citas`.`Id_Especialidad`) INNER JOIN `ingreso`  ON (`ingreso`.`Id` = `c_citas`.`Id_ingreso`) INNER JOIN `g_usuario`  ON (`g_usuario`.`Id_persona` = `ingreso`.`Id_Usuario`)   INNER JOIN `g_persona`  ON (`g_persona`.`Id` = `g_usuario`.`Id_persona`)  INNER JOIN `g_tipoedad`  ON (`g_persona`.`Id_TipoEdad` = `g_tipoedad`.`Id`) INNER JOIN `f_empresacontxconvenio`  ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`) INNER JOIN `h_atencion`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`) INNER JOIN `c_clasecita`  ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`)  inner join g_tipoatencion gton on (ingreso.`Id_TipoAtencion`=gton.Id)\t\n left join h_triage ht on (ht.IdIngreso=`ingreso`.`Id`) left join h_egreso_atencion on (h_egreso_atencion.Id_Ingreso=ingreso.Id) and (h_egreso_atencion.Id_Tipo=ingreso.Id_TipoAtencion) and (h_egreso_atencion.Estado=1)  left join (SELECT gtp.idIngreso, gtp.Id , \n       JSON_UNQUOTE(JSON_EXTRACT(json_entry, '$.usuario')) AS usuario,\n       JSON_UNQUOTE(JSON_EXTRACT(json_entry, '$.cargo')) AS cargo,\n       JSON_UNQUOTE(JSON_EXTRACT(json_entry, '$.accion')) AS accion,\n       JSON_UNQUOTE(JSON_EXTRACT(json_entry, '$.motivo')) AS motivo,\n       JSON_UNQUOTE(JSON_EXTRACT(json_entry, '$.idmodulo')) AS idmodulo,\n       JSON_UNQUOTE(JSON_EXTRACT(json_entry, '$.alerta')) AS alerta\nFROM g_trazabilidad_proceso gtp ,\n     JSON_TABLE(gtp.detalleProcesos , '$[*]' \n     COLUMNS (\n         json_entry JSON PATH '$'\n     )) AS log_entries\nWHERE JSON_UNQUOTE(JSON_EXTRACT(json_entry, '$.idmodulo')) = '5'\n  AND JSON_UNQUOTE(JSON_EXTRACT(json_entry, '$.alerta')) = 'true'\n  -- and gtp.idIngreso =5340\n  group by gtp.idIngreso) d on (d.idIngreso=ingreso.Id)  WHERE (gton.Id_TipoAmbito = 3 AND CONCAT(g_persona.`Apellido1`, ' ',g_persona.`Apellido2`, ' ',g_persona.`Nombre1`, ' ',g_persona.`Nombre2`) like'" + this.JTFBusqueda.getText() + "%' and CONVERT(CONCAT(`Fecha_Cita`, ' ' ,`HoraInicial`), DATETIME)   >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + " " + this.xmt.formatoH24.format(this.txtHoraI.getValue()) + ":00'  AND CONVERT(CONCAT(`Fecha_Cita`, ' ' ,`HoraInicial`), DATETIME)  <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + " " + this.xmt.formatoH24.format(this.txtHoraF.getValue()) + ":00' AND `ingreso`.`Egreso`=0   AND ingreso.Id_Sede ='" + this.xidtipodato[this.JCBUno.getSelectedIndex()] + "'  )   ORDER BY fecha DESC, h_atencion.Hora_Atencion DESC";
                    }
                } else if (this.JCH_FiltroProg.isSelected()) {
                    sql = "SELECT  DATE_FORMAT(h_atencion.Fecha_Atencion,'%d-%m-%Y') AS fecha, h_atencion.Hora_Atencion, g_usuario.NoHistoria,  CONCAT(g_persona.`Apellido1`, ' ',g_persona.`Apellido2`, ' ',g_persona.`Nombre1`, ' ',g_persona.`Nombre2`) AS NUsuario, CONCAT(g_persona.Edad ,' ' , g_tipoedad.`Nbre` ) AS Edad    , g_persona.`Id_Sexo`    ,  h_atencion.Codigo_Dxp , h_atencion.Codigo_DxR1 , h_atencion.Codigo_DxR2 , h_atencion.Codigo_DxR3, c_clasecita.Nbre AS NClaseCita, f_empresacontxconvenio.Nbre AS NEmpresa,c_citasnp.EstaFacturada, h_atencion.`Id`, g_persona.`Id`, ingreso.Id AS IdIngreso, ingreso.Id_CondVict, ingreso.UsuarioS, ingreso.Id_TipoAtencion, IF(`ingreso`.`Egreso`=0, 'EN ATENCION', 'DE ALTA') AS EgresoE,`c_clasecita`.`Id_Historia`  , TIMESTAMPDIFF(Hour,  concat(h_atencion.Fecha_Atencion, ' ', h_atencion.Hora_Atencion), if(h_egreso_atencion.Id is null, now(), concat(h_egreso_atencion.FechaSO, ' ', h_egreso_atencion.HoraSO))) as  hora   , ifnull(ht.Clasificacion, 'NO CLASIFICADO') triage, if(d.alerta='true', true , false) alerta FROM `profesional1` INNER JOIN `c_citasnp` ON (`profesional1`.`Id_Persona` = `c_citasnp`.`Id_Profesional`) AND (`profesional1`.`IdEspecialidad` = `c_citasnp`.`Id_Especialidad`) INNER JOIN `ingreso`  ON (`ingreso`.`Id` = `c_citasnp`.`Id_ingreso`) INNER JOIN `g_usuario`  ON (`g_usuario`.`Id_persona` = `ingreso`.`Id_Usuario`)   INNER JOIN `g_persona`  ON (`g_persona`.`Id` = `g_usuario`.`Id_persona`)  INNER JOIN `g_tipoedad`  ON (`g_persona`.`Id_TipoEdad` = `g_tipoedad`.`Id`) INNER JOIN `f_empresacontxconvenio`  ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`) INNER JOIN `h_atencion`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`) INNER JOIN `c_clasecita`  ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`)  inner join g_tipoatencion gton on (ingreso.`Id_TipoAtencion`=gton.Id)\t\n left join h_triage ht on (ht.IdIngreso=`ingreso`.`Id`) left join h_egreso_atencion on (h_egreso_atencion.Id_Ingreso=ingreso.Id) and (h_egreso_atencion.Id_Tipo=ingreso.Id_TipoAtencion) and (h_egreso_atencion.Estado=1)  left join (SELECT gtp.idIngreso, gtp.Id , \n       JSON_UNQUOTE(JSON_EXTRACT(json_entry, '$.usuario')) AS usuario,\n       JSON_UNQUOTE(JSON_EXTRACT(json_entry, '$.cargo')) AS cargo,\n       JSON_UNQUOTE(JSON_EXTRACT(json_entry, '$.accion')) AS accion,\n       JSON_UNQUOTE(JSON_EXTRACT(json_entry, '$.motivo')) AS motivo,\n       JSON_UNQUOTE(JSON_EXTRACT(json_entry, '$.idmodulo')) AS idmodulo,\n       JSON_UNQUOTE(JSON_EXTRACT(json_entry, '$.alerta')) AS alerta\nFROM g_trazabilidad_proceso gtp ,\n     JSON_TABLE(gtp.detalleProcesos , '$[*]' \n     COLUMNS (\n         json_entry JSON PATH '$'\n     )) AS log_entries\nWHERE JSON_UNQUOTE(JSON_EXTRACT(json_entry, '$.idmodulo')) = '5'\n  AND JSON_UNQUOTE(JSON_EXTRACT(json_entry, '$.alerta')) = 'true'\n  -- and gtp.idIngreso =5340\n  group by gtp.idIngreso) d on (d.idIngreso=ingreso.Id)  WHERE (gton.Id_TipoAmbito = 3 AND CONVERT(CONCAT(`Fecha_Cita`, ' ' ,`HoraInicial`), DATETIME)   >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + " " + this.xmt.formatoH24.format(this.txtHoraI.getValue()) + ":00'  AND CONVERT(CONCAT(`Fecha_Cita`, ' ' ,`HoraInicial`), DATETIME)  <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + " " + this.xmt.formatoH24.format(this.txtHoraF.getValue()) + ":00' AND `ingreso`.`Egreso`=0  AND ingreso.Id_Sede ='" + this.xidtipodato[this.JCBUno.getSelectedIndex()] + "'  )   ORDER BY fecha DESC, h_atencion.Hora_Atencion DESC";
                } else {
                    sql = "SELECT  DATE_FORMAT(h_atencion.Fecha_Atencion,'%d-%m-%Y') AS fecha, h_atencion.Hora_Atencion, g_usuario.NoHistoria,  CONCAT(g_persona.`Apellido1`, ' ',g_persona.`Apellido2`, ' ',g_persona.`Nombre1`, ' ',g_persona.`Nombre2`) AS NUsuario, CONCAT(g_persona.Edad ,' ' , g_tipoedad.`Nbre` ) AS Edad    , g_persona.`Id_Sexo`    ,  h_atencion.Codigo_Dxp , h_atencion.Codigo_DxR1 , h_atencion.Codigo_DxR2 , h_atencion.Codigo_DxR3, c_clasecita.Nbre AS NClaseCita, f_empresacontxconvenio.Nbre AS NEmpresa,1, h_atencion.`Id`, g_persona.`Id`, ingreso.Id AS IdIngreso, ingreso.Id_CondVict, ingreso.UsuarioS, ingreso.Id_TipoAtencion, IF(`ingreso`.`Egreso`=0, 'EN ATENCION', 'DE ALTA') AS EgresoE,`c_clasecita`.`Id_Historia`  , TIMESTAMPDIFF(Hour,  concat(h_atencion.Fecha_Atencion, ' ', h_atencion.Hora_Atencion), if(h_egreso_atencion.Id is null, now(), concat(h_egreso_atencion.FechaSO, ' ', h_egreso_atencion.HoraSO))) as  hora   , ifnull(ht.Clasificacion, 'NO CLASIFICADO') triage, if(d.alerta='true', true , false) alerta FROM `profesional1` INNER JOIN `c_citas` ON (`profesional1`.`Id_Persona` = `c_citas`.`Id_Profesional`) AND (`profesional1`.`IdEspecialidad` = `c_citas`.`Id_Especialidad`) INNER JOIN `ingreso`  ON (`ingreso`.`Id` = `c_citas`.`Id_ingreso`) INNER JOIN `g_usuario`  ON (`g_usuario`.`Id_persona` = `ingreso`.`Id_Usuario`)   INNER JOIN `g_persona`  ON (`g_persona`.`Id` = `g_usuario`.`Id_persona`)  INNER JOIN `g_tipoedad`  ON (`g_persona`.`Id_TipoEdad` = `g_tipoedad`.`Id`) INNER JOIN `f_empresacontxconvenio`  ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`) INNER JOIN `h_atencion`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`) INNER JOIN `c_clasecita`  ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`)  inner join g_tipoatencion gton on (ingreso.`Id_TipoAtencion`=gton.Id)\t\n left join h_triage ht on (ht.IdIngreso=`ingreso`.`Id`) left join h_egreso_atencion on (h_egreso_atencion.Id_Ingreso=ingreso.Id) and (h_egreso_atencion.Id_Tipo=ingreso.Id_TipoAtencion) and (h_egreso_atencion.Estado=1)  left join (SELECT gtp.idIngreso, gtp.Id , \n       JSON_UNQUOTE(JSON_EXTRACT(json_entry, '$.usuario')) AS usuario,\n       JSON_UNQUOTE(JSON_EXTRACT(json_entry, '$.cargo')) AS cargo,\n       JSON_UNQUOTE(JSON_EXTRACT(json_entry, '$.accion')) AS accion,\n       JSON_UNQUOTE(JSON_EXTRACT(json_entry, '$.motivo')) AS motivo,\n       JSON_UNQUOTE(JSON_EXTRACT(json_entry, '$.idmodulo')) AS idmodulo,\n       JSON_UNQUOTE(JSON_EXTRACT(json_entry, '$.alerta')) AS alerta\nFROM g_trazabilidad_proceso gtp ,\n     JSON_TABLE(gtp.detalleProcesos , '$[*]' \n     COLUMNS (\n         json_entry JSON PATH '$'\n     )) AS log_entries\nWHERE JSON_UNQUOTE(JSON_EXTRACT(json_entry, '$.idmodulo')) = '5'\n  AND JSON_UNQUOTE(JSON_EXTRACT(json_entry, '$.alerta')) = 'true'\n  -- and gtp.idIngreso =5340\n  group by gtp.idIngreso) d on (d.idIngreso=ingreso.Id)  WHERE (gton.Id_TipoAmbito = 3 AND CONVERT(CONCAT(`Fecha_Cita`, ' ' ,`HoraInicial`), DATETIME)   >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + " " + this.xmt.formatoH24.format(this.txtHoraI.getValue()) + ":00'  AND CONVERT(CONCAT(`Fecha_Cita`, ' ' ,`HoraInicial`), DATETIME)  <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + " " + this.xmt.formatoH24.format(this.txtHoraF.getValue()) + ":00' AND `ingreso`.`Egreso`=0   AND ingreso.Id_Sede ='" + this.xidtipodato[this.JCBUno.getSelectedIndex()] + "'  )   ORDER BY fecha DESC, h_atencion.Hora_Atencion DESC";
                }
            } else if (this.JRBDeAlta.isSelected()) {
                if (this.JCHFiltroB.isSelected()) {
                    if (this.JCH_FiltroProg.isSelected()) {
                        sql = "SELECT  DATE_FORMAT(h_atencion.Fecha_Atencion,'%d-%m-%Y') AS fecha, h_atencion.Hora_Atencion, g_usuario.NoHistoria,  CONCAT(g_persona.`Apellido1`, ' ',g_persona.`Apellido2`, ' ',g_persona.`Nombre1`, ' ',g_persona.`Nombre2`) AS NUsuario, CONCAT(g_persona.Edad ,' ' , g_tipoedad.`Nbre` ) AS Edad    , g_persona.`Id_Sexo`    ,  h_atencion.Codigo_Dxp , h_atencion.Codigo_DxR1 , h_atencion.Codigo_DxR2 , h_atencion.Codigo_DxR3, c_clasecita.Nbre AS NClaseCita, f_empresacontxconvenio.Nbre AS NEmpresa,c_citasnp.EstaFacturada, h_atencion.`Id`, g_persona.`Id`, ingreso.Id AS IdIngreso, ingreso.Id_CondVict, ingreso.UsuarioS, ingreso.Id_TipoAtencion, IF(`ingreso`.`Egreso`=0, 'EN ATENCION', 'DE ALTA') AS EgresoE,`c_clasecita`.`Id_Historia`  , TIMESTAMPDIFF(Hour,  concat(h_atencion.Fecha_Atencion, ' ', h_atencion.Hora_Atencion), if(h_egreso_atencion.Id is null, now(), concat(h_egreso_atencion.FechaSO, ' ', h_egreso_atencion.HoraSO))) as  hora   , ifnull(ht.Clasificacion, 'NO CLASIFICADO') triage, if(d.alerta='true', true , false) alerta FROM `profesional1` INNER JOIN `c_citasnp` ON (`profesional1`.`Id_Persona` = `c_citasnp`.`Id_Profesional`) AND (`profesional1`.`IdEspecialidad` = `c_citasnp`.`Id_Especialidad`) INNER JOIN `ingreso`  ON (`ingreso`.`Id` = `c_citasnp`.`Id_ingreso`) INNER JOIN `g_usuario`  ON (`g_usuario`.`Id_persona` = `ingreso`.`Id_Usuario`)   INNER JOIN `g_persona`  ON (`g_persona`.`Id` = `g_usuario`.`Id_persona`)  INNER JOIN `g_tipoedad`  ON (`g_persona`.`Id_TipoEdad` = `g_tipoedad`.`Id`) INNER JOIN `f_empresacontxconvenio`  ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`) INNER JOIN `h_atencion`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`) INNER JOIN `c_clasecita`  ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`)  inner join g_tipoatencion gton on (ingreso.`Id_TipoAtencion`=gton.Id)\t\n left join h_triage ht on (ht.IdIngreso=`ingreso`.`Id`) left join h_egreso_atencion on (h_egreso_atencion.Id_Ingreso=ingreso.Id) and (h_egreso_atencion.Id_Tipo=ingreso.Id_TipoAtencion) and (h_egreso_atencion.Estado=1)  left join (SELECT gtp.idIngreso, gtp.Id , \n       JSON_UNQUOTE(JSON_EXTRACT(json_entry, '$.usuario')) AS usuario,\n       JSON_UNQUOTE(JSON_EXTRACT(json_entry, '$.cargo')) AS cargo,\n       JSON_UNQUOTE(JSON_EXTRACT(json_entry, '$.accion')) AS accion,\n       JSON_UNQUOTE(JSON_EXTRACT(json_entry, '$.motivo')) AS motivo,\n       JSON_UNQUOTE(JSON_EXTRACT(json_entry, '$.idmodulo')) AS idmodulo,\n       JSON_UNQUOTE(JSON_EXTRACT(json_entry, '$.alerta')) AS alerta\nFROM g_trazabilidad_proceso gtp ,\n     JSON_TABLE(gtp.detalleProcesos , '$[*]' \n     COLUMNS (\n         json_entry JSON PATH '$'\n     )) AS log_entries\nWHERE JSON_UNQUOTE(JSON_EXTRACT(json_entry, '$.idmodulo')) = '5'\n  AND JSON_UNQUOTE(JSON_EXTRACT(json_entry, '$.alerta')) = 'true'\n  -- and gtp.idIngreso =5340\n  group by gtp.idIngreso) d on (d.idIngreso=ingreso.Id)  WHERE (gton.Id_TipoAmbito = 3 AND CONCAT(g_persona.`Apellido1`, ' ',g_persona.`Apellido2`, ' ',g_persona.`Nombre1`, ' ',g_persona.`Nombre2`) like'" + this.JTFBusqueda.getText() + "%' CONVERT(CONCAT(`Fecha_Cita`, ' ' ,`HoraInicial`), DATETIME)   >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + " " + this.xmt.formatoH24.format(this.txtHoraI.getValue()) + ":00'  AND CONVERT(CONCAT(`Fecha_Cita`, ' ' ,`HoraInicial`), DATETIME)  <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + " " + this.xmt.formatoH24.format(this.txtHoraF.getValue()) + ":00' AND `ingreso`.`Egreso`=1   AND ingreso.Id_Sede ='" + this.xidtipodato[this.JCBUno.getSelectedIndex()] + "'  )   ORDER BY fecha DESC, h_atencion.Hora_Atencion DESC";
                    } else {
                        sql = "SELECT  DATE_FORMAT(h_atencion.Fecha_Atencion,'%d-%m-%Y') AS fecha, h_atencion.Hora_Atencion, g_usuario.NoHistoria,  CONCAT(g_persona.`Apellido1`, ' ',g_persona.`Apellido2`, ' ',g_persona.`Nombre1`, ' ',g_persona.`Nombre2`) AS NUsuario, CONCAT(g_persona.Edad ,' ' , g_tipoedad.`Nbre` ) AS Edad    , g_persona.`Id_Sexo`    ,  h_atencion.Codigo_Dxp , h_atencion.Codigo_DxR1 , h_atencion.Codigo_DxR2 , h_atencion.Codigo_DxR3, c_clasecita.Nbre AS NClaseCita, f_empresacontxconvenio.Nbre AS NEmpresa,1, h_atencion.`Id`, g_persona.`Id`, ingreso.Id AS IdIngreso, ingreso.Id_CondVict, ingreso.UsuarioS, ingreso.Id_TipoAtencion, IF(`ingreso`.`Egreso`=0, 'EN ATENCION', 'DE ALTA') AS EgresoE , TIMESTAMPDIFF(Hour,  concat(h_atencion.Fecha_Atencion, ' ', h_atencion.Hora_Atencion), if(h_egreso_atencion.Id is null, now(), concat(h_egreso_atencion.FechaSO, ' ', h_egreso_atencion.HoraSO))) as  hora   , ifnull(ht.Clasificacion, 'NO CLASIFICADO') triage, if(d.alerta='true', true , false) alerta FROM `profesional1` INNER JOIN `c_citas` ON (`profesional1`.`Id_Persona` = `c_citas`.`Id_Profesional`) AND (`profesional1`.`IdEspecialidad` = `c_citas`.`Id_Especialidad`) INNER JOIN `ingreso`  ON (`ingreso`.`Id` = `c_citas`.`Id_ingreso`) INNER JOIN `g_usuario`  ON (`g_usuario`.`Id_persona` = `ingreso`.`Id_Usuario`)   INNER JOIN `g_persona`  ON (`g_persona`.`Id` = `g_usuario`.`Id_persona`)  INNER JOIN `g_tipoedad`  ON (`g_persona`.`Id_TipoEdad` = `g_tipoedad`.`Id`) INNER JOIN `f_empresacontxconvenio`  ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`) INNER JOIN `h_atencion`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`) INNER JOIN `c_clasecita`  ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`)  inner join g_tipoatencion gton on (ingreso.`Id_TipoAtencion`=gton.Id)\t\n left join h_triage ht on (ht.IdIngreso=`ingreso`.`Id`) left join h_egreso_atencion on (h_egreso_atencion.Id_Ingreso=ingreso.Id) and (h_egreso_atencion.Id_Tipo=ingreso.Id_TipoAtencion) and (h_egreso_atencion.Estado=1)  left join (SELECT gtp.idIngreso, gtp.Id , \n       JSON_UNQUOTE(JSON_EXTRACT(json_entry, '$.usuario')) AS usuario,\n       JSON_UNQUOTE(JSON_EXTRACT(json_entry, '$.cargo')) AS cargo,\n       JSON_UNQUOTE(JSON_EXTRACT(json_entry, '$.accion')) AS accion,\n       JSON_UNQUOTE(JSON_EXTRACT(json_entry, '$.motivo')) AS motivo,\n       JSON_UNQUOTE(JSON_EXTRACT(json_entry, '$.idmodulo')) AS idmodulo,\n       JSON_UNQUOTE(JSON_EXTRACT(json_entry, '$.alerta')) AS alerta\nFROM g_trazabilidad_proceso gtp ,\n     JSON_TABLE(gtp.detalleProcesos , '$[*]' \n     COLUMNS (\n         json_entry JSON PATH '$'\n     )) AS log_entries\nWHERE JSON_UNQUOTE(JSON_EXTRACT(json_entry, '$.idmodulo')) = '5'\n  AND JSON_UNQUOTE(JSON_EXTRACT(json_entry, '$.alerta')) = 'true'\n  -- and gtp.idIngreso =5340\n  group by gtp.idIngreso) d on (d.idIngreso=ingreso.Id)  WHERE (gton.Id_TipoAmbito = 3 AND CONCAT(g_persona.`Apellido1`, ' ',g_persona.`Apellido2`, ' ',g_persona.`Nombre1`, ' ',g_persona.`Nombre2`) like'" + this.JTFBusqueda.getText() + "%' and CONVERT(CONCAT(`Fecha_Cita`, ' ' ,`HoraInicial`), DATETIME)   >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + " " + this.xmt.formatoH24.format(this.txtHoraI.getValue()) + ":00'  AND CONVERT(CONCAT(`Fecha_Cita`, ' ' ,`HoraInicial`), DATETIME)  <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + " " + this.xmt.formatoH24.format(this.txtHoraF.getValue()) + ":00' AND `ingreso`.`Egreso`=1   AND ingreso.Id_Sede ='" + this.xidtipodato[this.JCBUno.getSelectedIndex()] + "'  )   ORDER BY fecha DESC, h_atencion.Hora_Atencion DESC";
                    }
                } else if (this.JCH_FiltroProg.isSelected()) {
                    sql = "SELECT  DATE_FORMAT(h_atencion.Fecha_Atencion,'%d-%m-%Y') AS fecha, h_atencion.Hora_Atencion, g_usuario.NoHistoria,  CONCAT(g_persona.`Apellido1`, ' ',g_persona.`Apellido2`, ' ',g_persona.`Nombre1`, ' ',g_persona.`Nombre2`) AS NUsuario, CONCAT(g_persona.Edad ,' ' , g_tipoedad.`Nbre` ) AS Edad    , g_persona.`Id_Sexo`    , h_atencion.Codigo_Dxp , h_atencion.Codigo_DxR1 , h_atencion.Codigo_DxR2 , h_atencion.Codigo_DxR3, c_clasecita.Nbre AS NClaseCita, f_empresacontxconvenio.Nbre AS NEmpresa,c_citasnp.EstaFacturada, h_atencion.`Id`, g_persona.`Id`, ingreso.Id AS IdIngreso, ingreso.Id_CondVict, ingreso.UsuarioS, ingreso.Id_TipoAtencion, IF(`ingreso`.`Egreso`=0, 'EN ATENCION', 'DE ALTA') AS EgresoE,`c_clasecita`.`Id_Historia`  , TIMESTAMPDIFF(Hour,  concat(h_atencion.Fecha_Atencion, ' ', h_atencion.Hora_Atencion), if(h_egreso_atencion.Id is null, now(), concat(h_egreso_atencion.FechaSO, ' ', h_egreso_atencion.HoraSO))) as  hora   , ifnull(ht.Clasificacion, 'NO CLASIFICADO') triage, if(d.alerta='true', true , false) alerta FROM `profesional1` INNER JOIN `c_citasnp` ON (`profesional1`.`Id_Persona` = `c_citasnp`.`Id_Profesional`) AND (`profesional1`.`IdEspecialidad` = `c_citasnp`.`Id_Especialidad`) INNER JOIN `ingreso`  ON (`ingreso`.`Id` = `c_citasnp`.`Id_ingreso`) INNER JOIN `g_usuario`  ON (`g_usuario`.`Id_persona` = `ingreso`.`Id_Usuario`)   INNER JOIN `g_persona`  ON (`g_persona`.`Id` = `g_usuario`.`Id_persona`)  INNER JOIN `g_tipoedad`  ON (`g_persona`.`Id_TipoEdad` = `g_tipoedad`.`Id`) INNER JOIN `f_empresacontxconvenio`  ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`) INNER JOIN `h_atencion`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`) INNER JOIN `c_clasecita`  ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`)  inner join g_tipoatencion gton on (ingreso.`Id_TipoAtencion`=gton.Id)\t\n left join h_triage ht on (ht.IdIngreso=`ingreso`.`Id`) left join h_egreso_atencion on (h_egreso_atencion.Id_Ingreso=ingreso.Id) and (h_egreso_atencion.Id_Tipo=ingreso.Id_TipoAtencion) and (h_egreso_atencion.Estado=1)  left join (SELECT gtp.idIngreso, gtp.Id , \n       JSON_UNQUOTE(JSON_EXTRACT(json_entry, '$.usuario')) AS usuario,\n       JSON_UNQUOTE(JSON_EXTRACT(json_entry, '$.cargo')) AS cargo,\n       JSON_UNQUOTE(JSON_EXTRACT(json_entry, '$.accion')) AS accion,\n       JSON_UNQUOTE(JSON_EXTRACT(json_entry, '$.motivo')) AS motivo,\n       JSON_UNQUOTE(JSON_EXTRACT(json_entry, '$.idmodulo')) AS idmodulo,\n       JSON_UNQUOTE(JSON_EXTRACT(json_entry, '$.alerta')) AS alerta\nFROM g_trazabilidad_proceso gtp ,\n     JSON_TABLE(gtp.detalleProcesos , '$[*]' \n     COLUMNS (\n         json_entry JSON PATH '$'\n     )) AS log_entries\nWHERE JSON_UNQUOTE(JSON_EXTRACT(json_entry, '$.idmodulo')) = '5'\n  AND JSON_UNQUOTE(JSON_EXTRACT(json_entry, '$.alerta')) = 'true'\n  -- and gtp.idIngreso =5340\n  group by gtp.idIngreso) d on (d.idIngreso=ingreso.Id)  WHERE (gton.Id_TipoAmbito = 3 AND CONVERT(CONCAT(`Fecha_Cita`, ' ' ,`HoraInicial`), DATETIME)   >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + " " + this.xmt.formatoH24.format(this.txtHoraI.getValue()) + ":00'  AND CONVERT(CONCAT(`Fecha_Cita`, ' ' ,`HoraInicial`), DATETIME)  <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + " " + this.xmt.formatoH24.format(this.txtHoraF.getValue()) + ":00' AND `ingreso`.`Egreso`=1  AND ingreso.Id_Sede ='" + this.xidtipodato[this.JCBUno.getSelectedIndex()] + "'  )   ORDER BY fecha DESC, h_atencion.Hora_Atencion DESC";
                } else {
                    sql = "SELECT  DATE_FORMAT(h_atencion.Fecha_Atencion,'%d-%m-%Y') AS fecha, h_atencion.Hora_Atencion, g_usuario.NoHistoria,  CONCAT(g_persona.`Apellido1`, ' ',g_persona.`Apellido2`, ' ',g_persona.`Nombre1`, ' ',g_persona.`Nombre2`) AS NUsuario, CONCAT(g_persona.Edad ,' ' , g_tipoedad.`Nbre` ) AS Edad    , g_persona.`Id_Sexo`    , h_atencion.Codigo_Dxp , h_atencion.Codigo_DxR1 , h_atencion.Codigo_DxR2 , h_atencion.Codigo_DxR3, c_clasecita.Nbre AS NClaseCita, f_empresacontxconvenio.Nbre AS NEmpresa,1, h_atencion.`Id`, g_persona.`Id`, ingreso.Id AS IdIngreso, ingreso.Id_CondVict, ingreso.UsuarioS, ingreso.Id_TipoAtencion, IF(`ingreso`.`Egreso`=0, 'EN ATENCION', 'DE ALTA') AS EgresoE,`c_clasecita`.`Id_Historia`  , TIMESTAMPDIFF(Hour,  concat(h_atencion.Fecha_Atencion, ' ', h_atencion.Hora_Atencion), if(h_egreso_atencion.Id is null, now(), concat(h_egreso_atencion.FechaSO, ' ', h_egreso_atencion.HoraSO))) as  hora   , ifnull(ht.Clasificacion, 'NO CLASIFICADO') triage, if(d.alerta='true', true , false) alerta FROM `profesional1` INNER JOIN `c_citas` ON (`profesional1`.`Id_Persona` = `c_citas`.`Id_Profesional`) AND (`profesional1`.`IdEspecialidad` = `c_citas`.`Id_Especialidad`) INNER JOIN `ingreso`  ON (`ingreso`.`Id` = `c_citas`.`Id_ingreso`) INNER JOIN `g_usuario`  ON (`g_usuario`.`Id_persona` = `ingreso`.`Id_Usuario`)   INNER JOIN `g_persona`  ON (`g_persona`.`Id` = `g_usuario`.`Id_persona`)  INNER JOIN `g_tipoedad`  ON (`g_persona`.`Id_TipoEdad` = `g_tipoedad`.`Id`) INNER JOIN `f_empresacontxconvenio`  ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`) INNER JOIN `h_atencion`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`) INNER JOIN `c_clasecita`  ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`)  inner join g_tipoatencion gton on (ingreso.`Id_TipoAtencion`=gton.Id)\t\n left join h_triage ht on (ht.IdIngreso=`ingreso`.`Id`) left join h_egreso_atencion on (h_egreso_atencion.Id_Ingreso=ingreso.Id) and (h_egreso_atencion.Id_Tipo=ingreso.Id_TipoAtencion) and (h_egreso_atencion.Estado=1)  left join (SELECT gtp.idIngreso, gtp.Id , \n       JSON_UNQUOTE(JSON_EXTRACT(json_entry, '$.usuario')) AS usuario,\n       JSON_UNQUOTE(JSON_EXTRACT(json_entry, '$.cargo')) AS cargo,\n       JSON_UNQUOTE(JSON_EXTRACT(json_entry, '$.accion')) AS accion,\n       JSON_UNQUOTE(JSON_EXTRACT(json_entry, '$.motivo')) AS motivo,\n       JSON_UNQUOTE(JSON_EXTRACT(json_entry, '$.idmodulo')) AS idmodulo,\n       JSON_UNQUOTE(JSON_EXTRACT(json_entry, '$.alerta')) AS alerta\nFROM g_trazabilidad_proceso gtp ,\n     JSON_TABLE(gtp.detalleProcesos , '$[*]' \n     COLUMNS (\n         json_entry JSON PATH '$'\n     )) AS log_entries\nWHERE JSON_UNQUOTE(JSON_EXTRACT(json_entry, '$.idmodulo')) = '5'\n  AND JSON_UNQUOTE(JSON_EXTRACT(json_entry, '$.alerta')) = 'true'\n  -- and gtp.idIngreso =5340\n  group by gtp.idIngreso) d on (d.idIngreso=ingreso.Id)  WHERE (gton.Id_TipoAmbito = 3 AND CONVERT(CONCAT(`Fecha_Cita`, ' ' ,`HoraInicial`), DATETIME)   >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + " " + this.xmt.formatoH24.format(this.txtHoraI.getValue()) + ":00'  AND CONVERT(CONCAT(`Fecha_Cita`, ' ' ,`HoraInicial`), DATETIME)  <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + " " + this.xmt.formatoH24.format(this.txtHoraF.getValue()) + ":00' AND `ingreso`.`Egreso`=1  AND ingreso.Id_Sede ='" + this.xidtipodato[this.JCBUno.getSelectedIndex()] + "'  )   ORDER BY fecha DESC, h_atencion.Hora_Atencion DESC";
                }
            } else if (this.JRBTodos.isSelected()) {
                if (this.JCH_FiltroProg.isSelected()) {
                    sql = "SELECT  DATE_FORMAT(h_atencion.Fecha_Atencion,'%d-%m-%Y') AS fecha, h_atencion.Hora_Atencion, g_usuario.NoHistoria,  CONCAT(g_persona.`Apellido1`, ' ',g_persona.`Apellido2`, ' ',g_persona.`Nombre1`, ' ',g_persona.`Nombre2`) AS NUsuario, CONCAT(g_persona.Edad ,' ' , g_tipoedad.`Nbre` ) AS Edad    , g_persona.`Id_Sexo`    , h_atencion.Codigo_Dxp , h_atencion.Codigo_DxR1 , h_atencion.Codigo_DxR2 , h_atencion.Codigo_DxR3, c_clasecita.Nbre AS NClaseCita, f_empresacontxconvenio.Nbre AS NEmpresa,c_citasnp.EstaFacturada, h_atencion.`Id`, g_persona.`Id`, ingreso.Id AS IdIngreso, ingreso.Id_CondVict, ingreso.UsuarioS, ingreso.Id_TipoAtencion, IF(`ingreso`.`Egreso`=0, 'EN ATENCION', 'DE ALTA') AS EgresoE,`c_clasecita`.`Id_Historia`  , TIMESTAMPDIFF(Hour,  concat(h_atencion.Fecha_Atencion, ' ', h_atencion.Hora_Atencion), if(h_egreso_atencion.Id is null, now(), concat(h_egreso_atencion.FechaSO, ' ', h_egreso_atencion.HoraSO))) as  hora   , ifnull(ht.Clasificacion, 'NO CLASIFICADO') triage, if(d.alerta='true', true , false) alerta FROM `profesional1` INNER JOIN `c_citasnp` ON (`profesional1`.`Id_Persona` = `c_citasnp`.`Id_Profesional`) AND (`profesional1`.`IdEspecialidad` = `c_citasnp`.`Id_Especialidad`) INNER JOIN `ingreso`  ON (`ingreso`.`Id` = `c_citasnp`.`Id_ingreso`) INNER JOIN `g_usuario`  ON (`g_usuario`.`Id_persona` = `ingreso`.`Id_Usuario`)   INNER JOIN `g_persona`  ON (`g_persona`.`Id` = `g_usuario`.`Id_persona`)  INNER JOIN `g_tipoedad`  ON (`g_persona`.`Id_TipoEdad` = `g_tipoedad`.`Id`) INNER JOIN `f_empresacontxconvenio`  ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`) INNER JOIN `h_atencion`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`) INNER JOIN `c_clasecita`  ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`)  inner join g_tipoatencion gton on (ingreso.`Id_TipoAtencion`=gton.Id)\t\n left join h_triage ht on (ht.IdIngreso=`ingreso`.`Id`) left join h_egreso_atencion on (h_egreso_atencion.Id_Ingreso=ingreso.Id) and (h_egreso_atencion.Id_Tipo=ingreso.Id_TipoAtencion) and (h_egreso_atencion.Estado=1)  left join (SELECT gtp.idIngreso, gtp.Id , \n       JSON_UNQUOTE(JSON_EXTRACT(json_entry, '$.usuario')) AS usuario,\n       JSON_UNQUOTE(JSON_EXTRACT(json_entry, '$.cargo')) AS cargo,\n       JSON_UNQUOTE(JSON_EXTRACT(json_entry, '$.accion')) AS accion,\n       JSON_UNQUOTE(JSON_EXTRACT(json_entry, '$.motivo')) AS motivo,\n       JSON_UNQUOTE(JSON_EXTRACT(json_entry, '$.idmodulo')) AS idmodulo,\n       JSON_UNQUOTE(JSON_EXTRACT(json_entry, '$.alerta')) AS alerta\nFROM g_trazabilidad_proceso gtp ,\n     JSON_TABLE(gtp.detalleProcesos , '$[*]' \n     COLUMNS (\n         json_entry JSON PATH '$'\n     )) AS log_entries\nWHERE JSON_UNQUOTE(JSON_EXTRACT(json_entry, '$.idmodulo')) = '5'\n  AND JSON_UNQUOTE(JSON_EXTRACT(json_entry, '$.alerta')) = 'true'\n  -- and gtp.idIngreso =5340\n  group by gtp.idIngreso) d on (d.idIngreso=ingreso.Id)  WHERE (gton.Id_TipoAmbito = 3 AND  CONVERT(CONCAT(`Fecha_Cita`, ' ' ,`HoraInicial`), DATETIME)   >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + " " + this.xmt.formatoH24.format(this.txtHoraI.getValue()) + ":00'  AND CONVERT(CONCAT(`Fecha_Cita`, ' ' ,`HoraInicial`), DATETIME)  <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + " " + this.xmt.formatoH24.format(this.txtHoraF.getValue()) + ":00'   AND ingreso.Id_Sede ='" + this.xidtipodato[this.JCBUno.getSelectedIndex()] + "'  )   ORDER BY fecha DESC, h_atencion.Hora_Atencion DESC";
                } else {
                    sql = "SELECT  DATE_FORMAT(h_atencion.Fecha_Atencion,'%d-%m-%Y') AS fecha, h_atencion.Hora_Atencion, g_usuario.NoHistoria,  CONCAT(g_persona.`Apellido1`, ' ',g_persona.`Apellido2`, ' ',g_persona.`Nombre1`, ' ',g_persona.`Nombre2`) AS NUsuario, CONCAT(g_persona.Edad ,' ' , g_tipoedad.`Nbre` ) AS Edad    , g_persona.`Id_Sexo`    , h_atencion.Codigo_Dxp , h_atencion.Codigo_DxR1 , h_atencion.Codigo_DxR2 , h_atencion.Codigo_DxR3, c_clasecita.Nbre AS NClaseCita, f_empresacontxconvenio.Nbre AS NEmpresa,1, h_atencion.`Id`, g_persona.`Id`, ingreso.Id AS IdIngreso, ingreso.Id_CondVict, ingreso.UsuarioS, ingreso.Id_TipoAtencion, IF(`ingreso`.`Egreso`=0, 'EN ATENCION', 'DE ALTA') AS EgresoE,`c_clasecita`.`Id_Historia`  , TIMESTAMPDIFF(Hour,  concat(h_atencion.Fecha_Atencion, ' ', h_atencion.Hora_Atencion), if(h_egreso_atencion.Id is null, now(), concat(h_egreso_atencion.FechaSO, ' ', h_egreso_atencion.HoraSO))) as  hora   , ifnull(ht.Clasificacion, 'NO CLASIFICADO') triage, if(d.alerta='true', true , false) alerta FROM `profesional1` INNER JOIN `c_citas` ON (`profesional1`.`Id_Persona` = `c_citas`.`Id_Profesional`) AND (`profesional1`.`IdEspecialidad` = `c_citas`.`Id_Especialidad`) INNER JOIN `ingreso`  ON (`ingreso`.`Id` = `c_citas`.`Id_ingreso`) INNER JOIN `g_usuario`  ON (`g_usuario`.`Id_persona` = `ingreso`.`Id_Usuario`)   INNER JOIN `g_persona`  ON (`g_persona`.`Id` = `g_usuario`.`Id_persona`)  INNER JOIN `g_tipoedad`  ON (`g_persona`.`Id_TipoEdad` = `g_tipoedad`.`Id`) INNER JOIN `f_empresacontxconvenio`  ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`) INNER JOIN `h_atencion`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`) INNER JOIN `c_clasecita`  ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`)  inner join g_tipoatencion gton on (ingreso.`Id_TipoAtencion`=gton.Id)\t\n left join h_triage ht on (ht.IdIngreso=`ingreso`.`Id`) left join h_egreso_atencion on (h_egreso_atencion.Id_Ingreso=ingreso.Id) and (h_egreso_atencion.Id_Tipo=ingreso.Id_TipoAtencion) and (h_egreso_atencion.Estado=1)  left join (SELECT gtp.idIngreso, gtp.Id , \n       JSON_UNQUOTE(JSON_EXTRACT(json_entry, '$.usuario')) AS usuario,\n       JSON_UNQUOTE(JSON_EXTRACT(json_entry, '$.cargo')) AS cargo,\n       JSON_UNQUOTE(JSON_EXTRACT(json_entry, '$.accion')) AS accion,\n       JSON_UNQUOTE(JSON_EXTRACT(json_entry, '$.motivo')) AS motivo,\n       JSON_UNQUOTE(JSON_EXTRACT(json_entry, '$.idmodulo')) AS idmodulo,\n       JSON_UNQUOTE(JSON_EXTRACT(json_entry, '$.alerta')) AS alerta\nFROM g_trazabilidad_proceso gtp ,\n     JSON_TABLE(gtp.detalleProcesos , '$[*]' \n     COLUMNS (\n         json_entry JSON PATH '$'\n     )) AS log_entries\nWHERE JSON_UNQUOTE(JSON_EXTRACT(json_entry, '$.idmodulo')) = '5'\n  AND JSON_UNQUOTE(JSON_EXTRACT(json_entry, '$.alerta')) = 'true'\n  -- and gtp.idIngreso =5340\n  group by gtp.idIngreso) d on (d.idIngreso=ingreso.Id)  WHERE (gton.Id_TipoAmbito = 3 AND CONVERT(CONCAT(`Fecha_Cita`, ' ' ,`HoraInicial`), DATETIME)   >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + " " + this.xmt.formatoH24.format(this.txtHoraI.getValue()) + ":00'  AND CONVERT(CONCAT(`Fecha_Cita`, ' ' ,`HoraInicial`), DATETIME)  <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + " " + this.xmt.formatoH24.format(this.txtHoraF.getValue()) + ":00'   AND ingreso.Id_Sede ='" + this.xidtipodato[this.JCBUno.getSelectedIndex()] + "'  )   ORDER BY fecha DESC, h_atencion.Hora_Atencion DESC";
                }
            }
            System.out.println(sql);
            ResultSet xrs = this.xconsultabd.traerRs(sql);
            Throwable th = null;
            try {
                try {
                    if (xrs.next()) {
                        xrs.beforeFirst();
                        int n = 0;
                        this.xmt.mEstablecerTextEditor(this.JTBDetalle2, 3);
                        this.xmt.mEstablecerTextEditor(this.JTBDetalle2, 10);
                        while (xrs.next()) {
                            this.xmodelo2.addRow(this.xdatos);
                            this.xmodelo2.setValueAt(xrs.getString(1), n, 0);
                            this.xmodelo2.setValueAt(xrs.getString(2), n, 1);
                            this.xmodelo2.setValueAt(xrs.getString(3), n, 2);
                            this.xmodelo2.setValueAt(xrs.getString(4), n, 3);
                            this.xmodelo2.setValueAt(xrs.getString(5), n, 4);
                            this.xmodelo2.setValueAt(xrs.getString(6), n, 5);
                            this.xmodelo2.setValueAt(xrs.getString(7), n, 6);
                            this.xmodelo2.setValueAt(xrs.getString(8), n, 7);
                            this.xmodelo2.setValueAt(xrs.getString(9), n, 8);
                            this.xmodelo2.setValueAt(xrs.getString(10), n, 9);
                            this.xmodelo2.setValueAt(xrs.getString(11), n, 10);
                            this.xmodelo2.setValueAt(xrs.getString(12), n, 11);
                            this.xmodelo2.setValueAt(Integer.valueOf(xrs.getInt(13)), n, 12);
                            this.xmodelo2.setValueAt(xrs.getString(14), n, 13);
                            this.xmodelo2.setValueAt(xrs.getString(15), n, 14);
                            this.xmodelo2.setValueAt(xrs.getString(16), n, 15);
                            this.xmodelo2.setValueAt(Integer.valueOf(xrs.getInt(17)), n, 16);
                            this.xmodelo2.setValueAt(xrs.getString(18), n, 17);
                            this.xmodelo2.setValueAt(xrs.getString(19), n, 18);
                            this.xmodelo2.setValueAt(xrs.getString(20), n, 19);
                            this.xmodelo2.setValueAt(Integer.valueOf(xrs.getInt("Id_Historia")), n, 20);
                            this.xmodelo2.setValueAt(Long.valueOf(xrs.getLong("hora")), n, 21);
                            this.xmodelo2.setValueAt(xrs.getString("triage"), n, 22);
                            this.xmodelo2.setValueAt(Boolean.valueOf(xrs.getBoolean("alerta")), n, 23);
                            this.JTBDetalle2.setDefaultRenderer(Object.class, new MiRender());
                            n++;
                        }
                    }
                    if (xrs != null) {
                        if (0 != 0) {
                            try {
                                xrs.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                        } else {
                            xrs.close();
                        }
                    }
                    this.xconsultabd.cerrarConexionBd();
                    this.JLContador.setText(String.valueOf(this.JTBDetalle2.getRowCount()));
                } finally {
                }
            } catch (Throwable th3) {
                th = th3;
                throw th3;
            }
        } catch (SQLException ex) {
            Logger.getLogger(JIFInformesNProgramadaRangoHora.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mImprimir() {
        String[][] parametros = new String[8][2];
        parametros[0][0] = "fechai";
        parametros[0][1] = this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + " " + this.xmt.formatoH24.format(this.txtHoraI.getValue()) + ":00";
        parametros[1][0] = "fechaf";
        parametros[1][1] = this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + " " + this.xmt.formatoH24.format(this.txtHoraF.getValue()) + ":00";
        parametros[2][0] = "horai";
        parametros[2][1] = this.xmt.formatoH24.format(this.txtHoraI.getValue());
        parametros[3][0] = "horaf";
        parametros[3][1] = this.xmt.formatoH24.format(this.txtHoraF.getValue());
        parametros[4][0] = "sede";
        parametros[4][1] = this.xidtipodato[this.JCBUno.getSelectedIndex()];
        parametros[5][0] = "filtro";
        parametros[5][1] = this.xfiltro;
        parametros[6][0] = "SUBREPORT_DIR";
        parametros[6][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
        parametros[7][0] = "SUBREPORTFIRMA_DIR";
        parametros[7][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
        this.xmt.GenerarPDF(this.xmt.getRutaRep() + "H_ReporteDeAtencionNPMedico_RangoHora", parametros);
    }

    /* JADX INFO: loaded from: GenomaP.jar:Sig/JIFInformesNProgramadaRangoHora$MiRender.class */
    public static class MiRender extends DefaultTableCellRenderer {
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (Long.valueOf(table.getValueAt(row, 16).toString()).longValue() != 0 || Boolean.valueOf(table.getValueAt(row, 23).toString()).booleanValue()) {
                cell.setBackground(new Color(177, 251, 177));
            } else {
                cell.setBackground(Color.WHITE);
            }
            return cell;
        }
    }

    private void mImprimirEvento() {
        try {
            String xsql = "SELECT `Id_Eventoecat`, `Id_Persona`, `Id_Ingreso`, Id FROM `a_eventoecat_paciente` WHERE (`Id_Ingreso` ='" + this.JTBDetalle2.getValueAt(this.JTBDetalle2.getSelectedRow(), 14).toString() + "')";
            ResultSet xrs = this.xconsultabd.traerRs(xsql);
            if (xrs.next()) {
                xrs.first();
                Object[] botones1 = {"FORMATO A", "FORMATO B", "CERRAR"};
                int n = JOptionPane.showOptionDialog(this, "Que desea hacer?", "VISUALIZAR", 0, 3, (Icon) null, botones1, "CERRAR");
                if (n == 0) {
                    Furips_PA xfrPA = new Furips_PA(xrs.getString(1), xrs.getString(2), xrs.getString("Id_Ingreso"), "", "");
                    xfrPA.build();
                    this.xmt.mostrarPdf(this.xmt.getRutaRep() + "furipsPA.pdf");
                } else if (n == 1) {
                    Furips_PB xfr = new Furips_PB(xrs.getString(4), xrs.getString(1), xrs.getString("Id_Ingreso"), "", "", "");
                    xfr.build();
                    this.xmt.mostrarPdf(this.xmt.getRutaRep() + "furipsPB.pdf");
                }
            }
            xrs.close();
            this.xconsultabd.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFInformesNProgramadaRangoHora.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }
}
