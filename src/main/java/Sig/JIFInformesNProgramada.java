package Sig;

import Acceso.Principal;
import Facturacion.Furips_PA;
import Facturacion.Furips_PB;
import General.JD_Impresin_Central_Dc;
import Historia.ReporteAnexo2;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyVetoException;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
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
import javax.swing.JInternalFrame;
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

/* JADX INFO: loaded from: GenomaP.jar:Sig/JIFInformesNProgramada.class */
public class JIFInformesNProgramada extends JInternalFrame {
    private String[] xidtipodato;
    private Object[] xdatos;
    private Metodos xmt = new Metodos();
    private ConsultasMySQL xconsultabd = new ConsultasMySQL();
    public DefaultTableModel xmodelo;
    public DefaultTableModel xmodelo1;
    public DefaultTableModel xmodelo2;
    private JButton JBAbrir_Hc;
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
    private JPanel JPDatos1;
    private JPanel JPIDetalle;
    private JPanel JPIDetalle1;
    private JPanel JPIEstado1;
    private JRadioButton JRBDeAlta;
    private JRadioButton JRBEnAtencion1;
    private JScrollPane JSPDetalle;
    private JScrollPane JSPDetalle1;
    private JScrollPane JSPDetalle2;
    public JTable JTBDetalle;
    public JTable JTBDetalle1;
    public JTable JTBDetalle2;
    private JTextField JTFBusqueda;
    private JTextField JTFRuta;
    private JTabbedPane JTPResultado;

    public JIFInformesNProgramada(String xnombre) {
        initComponents();
        setName(xnombre);
        mNuevo();
        if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL LOCAL DE MONTELIBANO") || Principal.informacionIps.getIdentificacion().equals("812005644")) {
            this.JBAbrir_Hc.setVisible(false);
        }
    }

    /* JADX WARN: Type inference failed for: r3v50, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v55, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v64, types: [java.lang.Object[], java.lang.Object[][]] */
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
        this.JTPResultado = new JTabbedPane();
        this.JSPDetalle = new JScrollPane();
        this.JTBDetalle = new JTable();
        this.JPIDetalle = new JPanel();
        this.JSPDetalle1 = new JScrollPane();
        this.JTBDetalle1 = new JTable();
        this.JPIDetalle1 = new JPanel();
        this.JSPDetalle2 = new JScrollPane();
        this.JTBDetalle2 = new JTable();
        this.JTFBusqueda = new JTextField();
        this.JCHFiltroB = new JCheckBox();
        this.JBTActualizar = new JButton();
        this.JBAnexo_dos = new JButton();
        this.JBAbrir_Hc = new JButton();
        this.JCH_FiltroProg = new JCheckBox();
        this.JTFRuta = new JTextField();
        this.JBTExportar = new JButton();
        setClosable(true);
        setIconifiable(true);
        setTitle("ATENCIONES NO PROGRAMADAS");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setMaximumSize(null);
        setMinimumSize(null);
        setName("jifatencionesnpfac");
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
        this.JCHFiltro.addActionListener(new ActionListener() { // from class: Sig.JIFInformesNProgramada.1
            public void actionPerformed(ActionEvent evt) {
                JIFInformesNProgramada.this.JCHFiltroActionPerformed(evt);
            }
        });
        this.JPIEstado1.setBorder(BorderFactory.createTitledBorder((Border) null, "Estado", 0, 0, new Font("Arial", 1, 12), new Color(255, 0, 0)));
        this.JBGEstado.add(this.JRBEnAtencion1);
        this.JRBEnAtencion1.setFont(new Font("Arial", 1, 12));
        this.JRBEnAtencion1.setForeground(Color.blue);
        this.JRBEnAtencion1.setSelected(true);
        this.JRBEnAtencion1.setText("En Atención");
        this.JRBEnAtencion1.addActionListener(new ActionListener() { // from class: Sig.JIFInformesNProgramada.2
            public void actionPerformed(ActionEvent evt) {
                JIFInformesNProgramada.this.JRBEnAtencion1ActionPerformed(evt);
            }
        });
        this.JBGEstado.add(this.JRBDeAlta);
        this.JRBDeAlta.setFont(new Font("Arial", 1, 12));
        this.JRBDeAlta.setForeground(Color.blue);
        this.JRBDeAlta.setText("De Alta");
        this.JRBDeAlta.addActionListener(new ActionListener() { // from class: Sig.JIFInformesNProgramada.3
            public void actionPerformed(ActionEvent evt) {
                JIFInformesNProgramada.this.JRBDeAltaActionPerformed(evt);
            }
        });
        GroupLayout JPIEstado1Layout = new GroupLayout(this.JPIEstado1);
        this.JPIEstado1.setLayout(JPIEstado1Layout);
        JPIEstado1Layout.setHorizontalGroup(JPIEstado1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIEstado1Layout.createSequentialGroup().addContainerGap().addComponent(this.JRBEnAtencion1).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBDeAlta).addContainerGap(-1, 32767)));
        JPIEstado1Layout.setVerticalGroup(JPIEstado1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIEstado1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBEnAtencion1).addComponent(this.JRBDeAlta)));
        GroupLayout JPDatos1Layout = new GroupLayout(this.JPDatos1);
        this.JPDatos1.setLayout(JPDatos1Layout);
        JPDatos1Layout.setHorizontalGroup(JPDatos1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatos1Layout.createSequentialGroup().addContainerGap().addComponent(this.JDFechaI, -2, 120, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JDFechaF, -2, 120, -2).addGap(18, 18, 18).addComponent(this.JCBUno, -2, 308, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JPIEstado1, -2, -1, -2).addGap(18, 18, 18).addComponent(this.JCHFiltro).addContainerGap()));
        JPDatos1Layout.setVerticalGroup(JPDatos1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPDatos1Layout.createSequentialGroup().addContainerGap().addGroup(JPDatos1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JDFechaF, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.JDFechaI, GroupLayout.Alignment.LEADING, -2, -1, -2).addComponent(this.JCBUno, GroupLayout.Alignment.LEADING).addGroup(JPDatos1Layout.createSequentialGroup().addGap(0, 0, 32767).addGroup(JPDatos1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JPIEstado1, -2, -1, -2).addComponent(this.JCHFiltro)))).addContainerGap()));
        this.JTPResultado.setForeground(Color.red);
        this.JTPResultado.setFont(new Font("Arial", 1, 14));
        this.JTBDetalle.setBorder(BorderFactory.createBevelBorder(0));
        this.JTBDetalle.setFont(new Font("Arial", 1, 12));
        this.JTBDetalle.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTBDetalle.setEditingColumn(1);
        this.JTBDetalle.setEditingRow(1);
        this.JTBDetalle.setRowHeight(25);
        this.JTBDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTBDetalle.setSelectionForeground(Color.red);
        this.JTBDetalle.addMouseListener(new MouseAdapter() { // from class: Sig.JIFInformesNProgramada.4
            public void mouseClicked(MouseEvent evt) {
                JIFInformesNProgramada.this.JTBDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTBDetalle);
        this.JTPResultado.addTab("CONSOLIDADO", this.JSPDetalle);
        this.JTBDetalle1.setBorder(BorderFactory.createBevelBorder(0));
        this.JTBDetalle1.setFont(new Font("Arial", 1, 12));
        this.JTBDetalle1.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTBDetalle1.setEditingColumn(1);
        this.JTBDetalle1.setEditingRow(1);
        this.JTBDetalle1.setRowHeight(25);
        this.JTBDetalle1.setSelectionBackground(new Color(255, 255, 255));
        this.JTBDetalle1.setSelectionForeground(Color.red);
        this.JTBDetalle1.addMouseListener(new MouseAdapter() { // from class: Sig.JIFInformesNProgramada.5
            public void mouseClicked(MouseEvent evt) {
                JIFInformesNProgramada.this.JTBDetalle1MouseClicked(evt);
            }
        });
        this.JSPDetalle1.setViewportView(this.JTBDetalle1);
        GroupLayout JPIDetalleLayout = new GroupLayout(this.JPIDetalle);
        this.JPIDetalle.setLayout(JPIDetalleLayout);
        JPIDetalleLayout.setHorizontalGroup(JPIDetalleLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDetalleLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPDetalle1, -1, 902, 32767).addContainerGap()));
        JPIDetalleLayout.setVerticalGroup(JPIDetalleLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDetalleLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPDetalle1).addContainerGap()));
        this.JTPResultado.addTab("DETALLE", this.JPIDetalle);
        this.JTBDetalle2.setBorder(BorderFactory.createBevelBorder(0));
        this.JTBDetalle2.setFont(new Font("Arial", 1, 12));
        this.JTBDetalle2.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTBDetalle2.setEditingColumn(1);
        this.JTBDetalle2.setEditingRow(1);
        this.JTBDetalle2.setRowHeight(25);
        this.JTBDetalle2.setSelectionBackground(new Color(255, 255, 255));
        this.JTBDetalle2.setSelectionForeground(Color.red);
        this.JTBDetalle2.addMouseListener(new MouseAdapter() { // from class: Sig.JIFInformesNProgramada.6
            public void mouseClicked(MouseEvent evt) {
                JIFInformesNProgramada.this.JTBDetalle2MouseClicked(evt);
            }
        });
        this.JSPDetalle2.setViewportView(this.JTBDetalle2);
        this.JTFBusqueda.setFont(new Font("Arial", 1, 12));
        this.JTFBusqueda.setBorder(BorderFactory.createTitledBorder((Border) null, "Búsqueda de usuario por apellido", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHFiltroB.setFont(new Font("Arial", 1, 12));
        this.JCHFiltroB.setText("Filtro?");
        this.JBTActualizar.setFont(new Font("Arial", 1, 12));
        this.JBTActualizar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/actualizar.png")));
        this.JBTActualizar.setText("<html><P ALIGN=center>Actualizar Agenda");
        this.JBTActualizar.addActionListener(new ActionListener() { // from class: Sig.JIFInformesNProgramada.7
            public void actionPerformed(ActionEvent evt) {
                JIFInformesNProgramada.this.JBTActualizarActionPerformed(evt);
            }
        });
        this.JBAnexo_dos.setFont(new Font("Arial", 1, 12));
        this.JBAnexo_dos.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Contrato2.png")));
        this.JBAnexo_dos.setText("Anexo 2");
        this.JBAnexo_dos.addActionListener(new ActionListener() { // from class: Sig.JIFInformesNProgramada.8
            public void actionPerformed(ActionEvent evt) {
                JIFInformesNProgramada.this.JBAnexo_dosActionPerformed(evt);
            }
        });
        this.JBAbrir_Hc.setFont(new Font("Arial", 1, 12));
        this.JBAbrir_Hc.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Configuracion29x27.png")));
        this.JBAbrir_Hc.setText("Abrir Hc");
        this.JBAbrir_Hc.addActionListener(new ActionListener() { // from class: Sig.JIFInformesNProgramada.9
            public void actionPerformed(ActionEvent evt) {
                JIFInformesNProgramada.this.JBAbrir_HcActionPerformed(evt);
            }
        });
        this.JCH_FiltroProg.setFont(new Font("Arial", 1, 12));
        this.JCH_FiltroProg.setSelected(true);
        this.JCH_FiltroProg.setText("No programas?");
        GroupLayout JPIDetalle1Layout = new GroupLayout(this.JPIDetalle1);
        this.JPIDetalle1.setLayout(JPIDetalle1Layout);
        JPIDetalle1Layout.setHorizontalGroup(JPIDetalle1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDetalle1Layout.createSequentialGroup().addContainerGap().addGroup(JPIDetalle1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JSPDetalle2, -2, 885, -2).addGroup(JPIDetalle1Layout.createSequentialGroup().addComponent(this.JTFBusqueda, -2, 357, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPIDetalle1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHFiltroB).addComponent(this.JCH_FiltroProg)).addGap(16, 16, 16).addComponent(this.JBTActualizar, -2, 141, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBAnexo_dos, -2, 124, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBAbrir_Hc, -1, -1, 32767))).addContainerGap(11, 32767)));
        JPIDetalle1Layout.setVerticalGroup(JPIDetalle1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDetalle1Layout.createSequentialGroup().addContainerGap().addComponent(this.JSPDetalle2, -1, 327, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPIDetalle1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDetalle1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBAnexo_dos, -1, 66, 32767).addComponent(this.JBAbrir_Hc, -1, 66, 32767)).addGroup(JPIDetalle1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JBTActualizar, -2, 65, -2).addGroup(JPIDetalle1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(JPIDetalle1Layout.createSequentialGroup().addComponent(this.JCH_FiltroProg).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JCHFiltroB)).addComponent(this.JTFBusqueda, GroupLayout.Alignment.TRAILING, -2, 50, -2)))).addContainerGap()));
        this.JTPResultado.addTab("USUARIOS ATENDIDOS", this.JPIDetalle1);
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: Sig.JIFInformesNProgramada.10
            public void mouseClicked(MouseEvent evt) {
                JIFInformesNProgramada.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setForeground(Color.red);
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: Sig.JIFInformesNProgramada.11
            public void actionPerformed(ActionEvent evt) {
                JIFInformesNProgramada.this.JBTExportarActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTPResultado, -2, 0, 32767).addComponent(this.JPDatos1, -1, -1, 32767).addGroup(layout.createSequentialGroup().addComponent(this.JTFRuta).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTExportar, -2, 204, -2))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPDatos1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTPResultado, -2, 463, -2).addGap(18, 18, 18).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JBTExportar, -2, 50, -2).addComponent(this.JTFRuta, -2, 50, -2)).addGap(10, 10, 10)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBDetalleMouseClicked(MouseEvent evt) {
        if (this.JTBDetalle.getSelectedRow() != -1) {
            mCargarDatosTabla1();
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
        if (!this.JTFRuta.getText().isEmpty()) {
            switch (this.JTPResultado.getSelectedIndex()) {
                case 0:
                    this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTBDetalle, this.JTFRuta.getText(), getTitle() + ": " + this.JTPResultado.getTitleAt(0));
                    break;
                case 1:
                    this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTBDetalle1, this.JTFRuta.getText(), getTitle() + ": " + this.JTPResultado.getTitleAt(1));
                    break;
                case 2:
                    this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTBDetalle2, this.JTFRuta.getText(), getTitle() + ": " + this.JTPResultado.getTitleAt(2));
                    break;
            }
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un ruta valida", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        this.JTFRuta.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHFiltroActionPerformed(ActionEvent evt) {
        mCargarDatosTabla1();
        mCargarDatosTabla2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBDetalle1MouseClicked(MouseEvent evt) {
        if (this.JTBDetalle1.getSelectedRow() != -1) {
            Object[] botones = {"Facturar", "Historia Clínica", "Epicrisis", "Cerrar"};
            int n = JOptionPane.showInternalOptionDialog(this, "Que desea realizar?", "CONSULTAR", 0, 3, (Icon) null, botones, "Cerrar");
            if (n == 0) {
                Principal.clasefacturacion.cargarPantalla("Facturac1");
                return;
            }
            if (n != 1) {
                if (n == 2) {
                    String[][] mparametros = new String[3][2];
                    mparametros[0][0] = "idatencion1";
                    mparametros[0][1] = this.JTBDetalle1.getValueAt(this.JTBDetalle1.getSelectedRow(), 12).toString();
                    mparametros[1][0] = "SUBREPORT_DIR";
                    mparametros[1][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
                    mparametros[2][0] = "SUBREPORTFIRMA_DIR";
                    mparametros[2][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
                    this.xmt.GenerarPDF(this.xmt.getRutaRep() + "H_HistoriaClinica_Epicrisis", mparametros);
                    return;
                }
                return;
            }
            String[][] mparametros2 = new String[4][2];
            mparametros2[0][0] = "idatencion1";
            mparametros2[0][1] = this.JTBDetalle1.getValueAt(this.JTBDetalle1.getSelectedRow(), 12).toString();
            mparametros2[1][0] = "idpaciente1";
            mparametros2[1][1] = this.JTBDetalle1.getValueAt(this.JTBDetalle1.getSelectedRow(), 13).toString();
            mparametros2[2][0] = "SUBREPORT_DIR";
            mparametros2[2][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
            mparametros2[3][0] = "SUBREPORTFIRMA_DIR";
            mparametros2[3][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
            if (Principal.informacionIps.getEsFpz().intValue() == 0) {
                this.xmt.GenerarPDF(this.xmt.getRutaRep() + "H_HistoriaClinica", mparametros2);
            } else {
                this.xmt.GenerarPDF(this.xmt.getRutaRep() + "H_HistoriaClinica_Urgencias", mparametros2);
                this.xmt.GenerarPDF(this.xmt.getRutaRep() + "H_Historia_Clinica_Medicamento", mparametros2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBEnAtencion1ActionPerformed(ActionEvent evt) {
        mCargarDatosTabla();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBDeAltaActionPerformed(ActionEvent evt) {
        mCargarDatosTabla();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBDetalle2MouseClicked(MouseEvent evt) {
        if (this.JTBDetalle2.getSelectedRow() != -1) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Desea ver la Impresión Centralizada", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                JD_Impresin_Central_Dc xjd = new JD_Impresin_Central_Dc(null, true, this.xmodelo2.getValueAt(this.JTBDetalle2.getSelectedRow(), 12).toString(), this.xmodelo2.getValueAt(this.JTBDetalle2.getSelectedRow(), 13).toString(), this.xmodelo2.getValueAt(this.JTBDetalle2.getSelectedRow(), 14).toString(), this.xmodelo2.getValueAt(this.JTBDetalle2.getSelectedRow(), 17).toString(), Integer.valueOf(this.xmodelo2.getValueAt(this.JTBDetalle2.getSelectedRow(), 20).toString()), "");
                xjd.setLocationRelativeTo(this);
                xjd.setVisible(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTActualizarActionPerformed(ActionEvent evt) {
        if (this.JCHFiltroB.isSelected() && !this.JTFBusqueda.getText().isEmpty()) {
            mCargarDatosTabla2();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBAnexo_dosActionPerformed(ActionEvent evt) {
        if (this.JTBDetalle2.getSelectedRow() != -1) {
            System.out.println("Col 12-->" + this.xmodelo2.getValueAt(this.JTBDetalle2.getSelectedRow(), 12).toString());
            mVerificarAnexoDos(this.xmodelo2.getValueAt(this.JTBDetalle2.getSelectedRow(), 12).toString());
        } else {
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un registro", "Verificación", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBAbrir_HcActionPerformed(ActionEvent evt) {
        if (this.JTBDetalle2.getSelectedRow() != -1) {
            String xsql = "update h_atencion set TipoGuardado=0 where Id='" + this.xmodelo2.getValueAt(this.JTBDetalle2.getSelectedRow(), 12) + "'";
            this.xconsultabd.ejecutarSQL(xsql);
            this.xconsultabd.cerrarConexionBd();
        }
    }

    private void mVerAnexo2() {
        ReporteAnexo2 x = new ReporteAnexo2(this.xmodelo2.getValueAt(this.JTBDetalle2.getSelectedRow(), 12).toString(), 0);
        x.build();
        this.xmt.mostrarPdf(this.xmt.getRutaRep() + "H_Anexo2.pdf");
    }

    private String mGeneraNoAtencion() {
        String xNoAtencion = null;
        String sql = "SELECT `h_atencion_anexo_dos`.`Id` , IF(MAX(`h_atencion_anexo_dos`.`IdAteAnexo2`)IS NULL,1,(MAX(`h_atencion_anexo_dos`.`IdAteAnexo2`)+1)) AS maximo\n , `h_atencion_anexo_dos`.`FechaR` FROM `h_atencion_anexo_dos`  INNER JOIN `baseserver`.`h_atencion`  ON (`h_atencion_anexo_dos`.`IdAtencion` = `h_atencion`.`Id`) WHERE (`h_atencion_anexo_dos`.`FechaR` ='" + this.xmt.formatoAMD.format(this.xmt.getFechaActual()) + "')";
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
            Logger.getLogger(JIFInformesNProgramada.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
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
        } catch (SQLException ex) {
            Logger.getLogger(JIFInformesNProgramada.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mNuevo() {
        this.JDFechaI.setDate(this.xmt.getFechaActual());
        this.JDFechaF.setDate(this.xmt.getFechaActual());
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
        this.JCBUno.removeAllItems();
        this.xidtipodato = this.xconsultabd.llenarCombo("SELECT Id, Nbre FROM g_sedes ORDER BY Nbre ASC", this.xidtipodato, this.JCBUno);
        this.JCBUno.setSelectedIndex(0);
        this.xconsultabd.cerrarConexionBd();
    }

    public void mBuscar() {
        if (this.JCBUno.getSelectedIndex() != -1) {
            if (this.JTPResultado.getSelectedIndex() == 0 || this.JTPResultado.getSelectedIndex() == 2) {
                mCargarDatosTabla();
                mCargarDatosTabla2();
                return;
            } else {
                mCargarDatosTabla1();
                return;
            }
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una sede", "VERIFICAR", 1);
        this.JCBUno.requestFocus();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Fecha", "Especialidad", "Profesional", "N° Atenciones", "", "IdPesona"}) { // from class: Sig.JIFInformesNProgramada.12
            Class[] types = {String.class, String.class, String.class, Integer.class, Integer.class, Integer.class};
            boolean[] canEdit = {false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTBDetalle.setModel(this.xmodelo);
        this.JTBDetalle.getColumnModel().getColumn(0).setPreferredWidth(20);
        this.JTBDetalle.getColumnModel().getColumn(1).setPreferredWidth(50);
        this.JTBDetalle.getColumnModel().getColumn(2).setPreferredWidth(200);
        this.JTBDetalle.getColumnModel().getColumn(3).setPreferredWidth(30);
        this.JTBDetalle.getColumnModel().getColumn(4).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(4).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(4).setMaxWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(5).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(5).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(5).setMaxWidth(0);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos1() {
        this.xmodelo1 = new DefaultTableModel(new Object[0], new String[]{"Fecha", "NHC", "Usuario", "Edad", "Sexo", "DxP", "DxR1", "DxR2", "DxR3", "Clase Cita", "Empresa", "F?", "Id_Atencion", "Id_Usuario", "Id_Ingreso", "UsuarioS", "NOrden", "NFactura", "Tipo Atención"}) { // from class: Sig.JIFInformesNProgramada.13
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Integer.class, String.class, String.class, String.class, String.class, Long.class, Long.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTBDetalle1;
        JTable jTable2 = this.JTBDetalle1;
        jTable.setAutoResizeMode(0);
        this.JTBDetalle1.doLayout();
        this.JTBDetalle1.setModel(this.xmodelo1);
        this.JTBDetalle1.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTBDetalle1.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTBDetalle1.getColumnModel().getColumn(2).setPreferredWidth(300);
        this.JTBDetalle1.getColumnModel().getColumn(3).setPreferredWidth(80);
        this.JTBDetalle1.getColumnModel().getColumn(4).setPreferredWidth(50);
        this.JTBDetalle1.getColumnModel().getColumn(5).setPreferredWidth(80);
        this.JTBDetalle1.getColumnModel().getColumn(6).setPreferredWidth(80);
        this.JTBDetalle1.getColumnModel().getColumn(7).setPreferredWidth(80);
        this.JTBDetalle1.getColumnModel().getColumn(8).setPreferredWidth(80);
        this.JTBDetalle1.getColumnModel().getColumn(9).setPreferredWidth(80);
        this.JTBDetalle1.getColumnModel().getColumn(10).setPreferredWidth(0);
        this.JTBDetalle1.getColumnModel().getColumn(10).setMinWidth(0);
        this.JTBDetalle1.getColumnModel().getColumn(10).setMaxWidth(0);
        this.JTBDetalle1.getColumnModel().getColumn(11).setPreferredWidth(0);
        this.JTBDetalle1.getColumnModel().getColumn(11).setMinWidth(0);
        this.JTBDetalle1.getColumnModel().getColumn(11).setMaxWidth(0);
        this.JTBDetalle1.getColumnModel().getColumn(12).setPreferredWidth(0);
        this.JTBDetalle1.getColumnModel().getColumn(12).setMinWidth(0);
        this.JTBDetalle1.getColumnModel().getColumn(12).setMaxWidth(0);
        this.JTBDetalle1.getColumnModel().getColumn(13).setPreferredWidth(0);
        this.JTBDetalle1.getColumnModel().getColumn(13).setMinWidth(0);
        this.JTBDetalle1.getColumnModel().getColumn(13).setMaxWidth(0);
        this.JTBDetalle1.getColumnModel().getColumn(14).setPreferredWidth(0);
        this.JTBDetalle1.getColumnModel().getColumn(14).setMinWidth(0);
        this.JTBDetalle1.getColumnModel().getColumn(14).setMaxWidth(0);
        this.JTBDetalle1.getColumnModel().getColumn(15).setPreferredWidth(100);
        this.JTBDetalle1.getColumnModel().getColumn(16).setPreferredWidth(80);
        this.JTBDetalle1.getColumnModel().getColumn(17).setPreferredWidth(80);
        this.JTBDetalle1.getColumnModel().getColumn(18).setPreferredWidth(100);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos2() {
        this.xmodelo2 = new DefaultTableModel(new Object[0], new String[]{"Fecha", "NHC", "Usuario", "Edad", "Sexo", "DxP", "DxR1", "DxR2", "DxR3", "Clase Cita", "Convenio", "F?", "Id_Atencion", "Id_Usuario", "Id_Ingreso", "Cod_Victima", "UsuarioS", "IdTipoA", "IdAnexo2", "Tipo Atención", "idTipoHistoria"}) { // from class: Sig.JIFInformesNProgramada.14
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Integer.class, String.class, String.class, String.class, Integer.class, String.class, String.class, Long.class, String.class, Integer.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTBDetalle2;
        JTable jTable2 = this.JTBDetalle2;
        jTable.setAutoResizeMode(0);
        this.JTBDetalle2.doLayout();
        this.JTBDetalle2.setModel(this.xmodelo2);
        this.JTBDetalle2.getColumnModel().getColumn(0).setPreferredWidth(80);
        this.JTBDetalle2.getColumnModel().getColumn(1).setPreferredWidth(80);
        this.JTBDetalle2.getColumnModel().getColumn(2).setPreferredWidth(250);
        this.JTBDetalle2.getColumnModel().getColumn(3).setPreferredWidth(80);
        this.JTBDetalle2.getColumnModel().getColumn(4).setPreferredWidth(80);
        this.JTBDetalle2.getColumnModel().getColumn(5).setPreferredWidth(80);
        this.JTBDetalle2.getColumnModel().getColumn(6).setPreferredWidth(80);
        this.JTBDetalle2.getColumnModel().getColumn(7).setPreferredWidth(80);
        this.JTBDetalle2.getColumnModel().getColumn(8).setPreferredWidth(80);
        this.JTBDetalle2.getColumnModel().getColumn(9).setPreferredWidth(150);
        this.JTBDetalle2.getColumnModel().getColumn(10).setPreferredWidth(300);
        this.JTBDetalle2.getColumnModel().getColumn(11).setPreferredWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(11).setMinWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(11).setMaxWidth(0);
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
        this.JTBDetalle2.getColumnModel().getColumn(16).setPreferredWidth(150);
        this.JTBDetalle2.getColumnModel().getColumn(17).setPreferredWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(17).setMinWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(17).setMaxWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(18).setPreferredWidth(100);
        this.JTBDetalle2.getColumnModel().getColumn(19).setPreferredWidth(150);
        this.JTBDetalle2.getColumnModel().getColumn(20).setPreferredWidth(10);
    }

    private void mCargarDatosTabla() {
        try {
            mCrearModeloDatos();
            String sql = "";
            if (this.JRBEnAtencion1.isSelected()) {
                sql = "SELECT DATE_FORMAT(c_citasnp.Fecha_Cita,'%d-%m-%Y') as fecha, profesional1.Especialidad, profesional1.NProfesional, count(c_citasnp.Id) AS Cantidad, g_usuario_sist.Login, profesional1.Id_Persona FROM h_atencion INNER JOIN c_citasnp  ON (h_atencion.Id_Ingreso = c_citasnp.Id_ingreso) INNER JOIN profesional1  ON (profesional1.Id_Persona = h_atencion.Id_Profesional) AND (profesional1.IdEspecialidad = h_atencion.Id_Especialidad)  INNER JOIN g_usuario_sist ON (profesional1.Id_Persona = g_usuario_sist.Id_Persona) INNER JOIN ingreso  ON (h_atencion.Id_Ingreso = ingreso.Id)WHERE (c_citasnp.Fecha_Cita >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND `ingreso`.`Egreso`=0 AND c_citasnp.Fecha_Cita <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' AND h_atencion.Codigo_Dxp <>'' AND ingreso.Id_Sede ='" + this.xidtipodato[this.JCBUno.getSelectedIndex()] + "')  GROUP BY profesional1.Especialidad, profesional1.NProfesional  ORDER BY c_citasnp.Fecha_Cita ASC, profesional1.Especialidad ASC, profesional1.NProfesional ASC";
            } else if (this.JRBDeAlta.isSelected()) {
                sql = "SELECT DATE_FORMAT(c_citasnp.Fecha_Cita,'%d-%m-%Y') as fecha, profesional1.Especialidad, profesional1.NProfesional, count(c_citasnp.Id) AS Cantidad, g_usuario_sist.Login, profesional1.Id_Persona FROM h_atencion INNER JOIN c_citasnp  ON (h_atencion.Id_Ingreso = c_citasnp.Id_ingreso) INNER JOIN profesional1  ON (profesional1.Id_Persona = h_atencion.Id_Profesional) AND (profesional1.IdEspecialidad = h_atencion.Id_Especialidad)  INNER JOIN g_usuario_sist ON (profesional1.Id_Persona = g_usuario_sist.Id_Persona) INNER JOIN ingreso  ON (h_atencion.Id_Ingreso = ingreso.Id)WHERE (c_citasnp.Fecha_Cita >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND `ingreso`.`Egreso`=1 AND c_citasnp.Fecha_Cita <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' AND h_atencion.Codigo_Dxp <>'' AND ingreso.Id_Sede ='" + this.xidtipodato[this.JCBUno.getSelectedIndex()] + "')  GROUP BY profesional1.Especialidad, profesional1.NProfesional  ORDER BY c_citasnp.Fecha_Cita ASC, profesional1.Especialidad ASC, profesional1.NProfesional ASC";
            }
            ResultSet xrs = this.xconsultabd.traerRs(sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(xrs.getString(1), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelo.setValueAt(Integer.valueOf(xrs.getInt(4)), n, 3);
                    this.xmodelo.setValueAt(xrs.getString(5), n, 4);
                    this.xmodelo.setValueAt(xrs.getString(6), n, 5);
                    n++;
                }
            }
            xrs.close();
            this.xconsultabd.cerrarConexionBd();
            mCrearModeloDatos1();
        } catch (SQLException ex) {
            Logger.getLogger(JIFInformesNProgramada.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarDatosTabla1() {
        try {
            String sql = null;
            mCrearModeloDatos1();
            if (this.JTPResultado.getSelectedIndex() == 0) {
                if (this.JCHFiltro.isSelected()) {
                    if (this.JRBEnAtencion1.isSelected()) {
                        sql = "SELECT  DATE_FORMAT(h_atencion.Fecha_Atencion,'%d-%m-%Y') AS fecha, g_usuario.NoHistoria,  CONCAT(g_persona.`Apellido1`, ' ',g_persona.`Apellido2`, ' ',g_persona.`Nombre1`, ' ',g_persona.`Nombre2`) AS NUsuario, CONCAT(g_persona.Edad ,' ' , g_tipoedad.`Nbre` ) AS Edad    , g_persona.`Id_Sexo` , h_atencion.Codigo_Dxp ,  h_atencion.Codigo_DxR1 , h_atencion.Codigo_DxR2 , h_atencion.Codigo_DxR3, c_clasecita.Nbre AS NClaseCita, f_empresacontxconvenio.Nbre AS NEmpresa,c_citasnp.EstaFacturada, h_atencion.`Id`,  g_persona.`Id`, ingreso.Id AS IdIngreso, ingreso.Id_CondVict, ingreso.UsuarioS,`g_tipoatencion`.`Nbre` AS `TipoATencion`  FROM `profesional1`  INNER JOIN `c_citasnp` ON (`profesional1`.`Id_Persona` = `c_citasnp`.`Id_Profesional`)  AND (`profesional1`.`IdEspecialidad` = `c_citasnp`.`Id_Especialidad`)  INNER JOIN `ingreso`  ON (`ingreso`.`Id` = `c_citasnp`.`Id_ingreso`)  INNER JOIN `g_usuario`  ON (`g_usuario`.`Id_persona` = `ingreso`.`Id_Usuario`)  INNER JOIN `g_persona`  ON (`g_persona`.`Id` = `g_usuario`.`Id_persona`)  INNER JOIN `g_tipoedad`  ON (`g_persona`.`Id_TipoEdad` = `g_tipoedad`.`Id`)  INNER JOIN `f_empresacontxconvenio`  ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)  INNER JOIN `h_atencion`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)  INNER JOIN `c_clasecita`  ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`)   INNER JOIN `g_tipoatencion`  ON (`ingreso`.`Id_TipoAtencion` = `g_tipoatencion`.`Id`) WHERE (c_citasnp.Fecha_Cita >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND `ingreso`.`Egreso`=0 AND c_citasnp.Fecha_Cita <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' AND  h_atencion.Codigo_Dxp <>'' AND ingreso.Id_Sede ='" + this.xidtipodato[this.JCBUno.getSelectedIndex()] + "' and c_citasnp.EstaFacturada =0 AND profesional1.Id_Persona='" + this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 5) + "')   ORDER BY c_citasnp.Fecha_Cita ASC, CONCAT(g_persona.`Apellido1`, ' ',g_persona.`Apellido2`, ' ',g_persona.`Nombre1`, ' ',g_persona.`Nombre2`) ASC ";
                    } else if (this.JRBDeAlta.isSelected()) {
                        sql = "SELECT  DATE_FORMAT(h_atencion.Fecha_Atencion,'%d-%m-%Y') AS fecha, g_usuario.NoHistoria,  CONCAT(g_persona.`Apellido1`, ' ',g_persona.`Apellido2`, ' ',g_persona.`Nombre1`, ' ',g_persona.`Nombre2`) AS NUsuario, CONCAT(g_persona.Edad ,' ' , g_tipoedad.`Nbre` ) AS Edad    , g_persona.`Id_Sexo` , h_atencion.Codigo_Dxp ,  h_atencion.Codigo_DxR1 , h_atencion.Codigo_DxR2 , h_atencion.Codigo_DxR3, c_clasecita.Nbre AS NClaseCita, f_empresacontxconvenio.Nbre AS NEmpresa,c_citasnp.EstaFacturada, h_atencion.`Id`,  g_persona.`Id`, ingreso.Id AS IdIngreso, ingreso.Id_CondVict, ingreso.UsuarioS,`g_tipoatencion`.`Nbre` AS `TipoATencion`  FROM `profesional1`  INNER JOIN `c_citasnp` ON (`profesional1`.`Id_Persona` = `c_citasnp`.`Id_Profesional`)  AND (`profesional1`.`IdEspecialidad` = `c_citasnp`.`Id_Especialidad`)  INNER JOIN `ingreso`  ON (`ingreso`.`Id` = `c_citasnp`.`Id_ingreso`)  INNER JOIN `g_usuario`  ON (`g_usuario`.`Id_persona` = `ingreso`.`Id_Usuario`)  INNER JOIN `g_persona`  ON (`g_persona`.`Id` = `g_usuario`.`Id_persona`)  INNER JOIN `g_tipoedad`  ON (`g_persona`.`Id_TipoEdad` = `g_tipoedad`.`Id`)  INNER JOIN `f_empresacontxconvenio`  ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)  INNER JOIN `h_atencion`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)  INNER JOIN `c_clasecita`  ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`)   INNER JOIN `g_tipoatencion`  ON (`ingreso`.`Id_TipoAtencion` = `g_tipoatencion`.`Id`) WHERE (c_citasnp.Fecha_Cita >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND `ingreso`.`Egreso`=1 AND c_citasnp.Fecha_Cita <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' AND  h_atencion.Codigo_Dxp <>'' AND ingreso.Id_Sede ='" + this.xidtipodato[this.JCBUno.getSelectedIndex()] + "' and c_citasnp.EstaFacturada =0 AND profesional1.Id_Persona='" + this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 5) + "')   ORDER BY  c_citasnp.Fecha_Cita ASC, CONCAT(g_persona.`Apellido1`, ' ',g_persona.`Apellido2`, ' ',g_persona.`Nombre1`, ' ',g_persona.`Nombre2`) ASC ";
                    }
                } else if (this.JRBEnAtencion1.isSelected()) {
                    sql = "SELECT  DATE_FORMAT(h_atencion.Fecha_Atencion,'%d-%m-%Y') AS fecha, g_usuario.NoHistoria,  CONCAT(g_persona.`Apellido1`, ' ',g_persona.`Apellido2`, ' ',g_persona.`Nombre1`, ' ',g_persona.`Nombre2`) AS NUsuario, CONCAT(g_persona.Edad ,' ' , g_tipoedad.`Nbre` ) AS Edad    , g_persona.`Id_Sexo` , h_atencion.Codigo_Dxp ,  h_atencion.Codigo_DxR1 , h_atencion.Codigo_DxR2 , h_atencion.Codigo_DxR3, c_clasecita.Nbre AS NClaseCita, f_empresacontxconvenio.Nbre AS NEmpresa,c_citasnp.EstaFacturada, h_atencion.`Id`,  g_persona.`Id`, ingreso.Id AS IdIngreso, ingreso.Id_CondVict, ingreso.UsuarioS,`g_tipoatencion`.`Nbre` AS `TipoATencion`  FROM `profesional1`  INNER JOIN `c_citasnp` ON (`profesional1`.`Id_Persona` = `c_citasnp`.`Id_Profesional`)  AND (`profesional1`.`IdEspecialidad` = `c_citasnp`.`Id_Especialidad`)  INNER JOIN `ingreso`  ON (`ingreso`.`Id` = `c_citasnp`.`Id_ingreso`)  INNER JOIN `g_usuario`  ON (`g_usuario`.`Id_persona` = `ingreso`.`Id_Usuario`)  INNER JOIN `g_persona`  ON (`g_persona`.`Id` = `g_usuario`.`Id_persona`)  INNER JOIN `g_tipoedad`  ON (`g_persona`.`Id_TipoEdad` = `g_tipoedad`.`Id`)  INNER JOIN `f_empresacontxconvenio`  ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)  INNER JOIN `h_atencion`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)  INNER JOIN `c_clasecita`  ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`)   INNER JOIN `g_tipoatencion`  ON (`ingreso`.`Id_TipoAtencion` = `g_tipoatencion`.`Id`) WHERE (c_citasnp.Fecha_Cita >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND `ingreso`.`Egreso`=0 AND c_citasnp.Fecha_Cita <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "'  AND  h_atencion.Codigo_Dxp <>'' AND ingreso.Id_Sede ='" + this.xidtipodato[this.JCBUno.getSelectedIndex()] + "' AND profesional1.Id_Persona='" + this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 5) + "')   ORDER BY  c_citasnp.Fecha_Cita ASC, CONCAT(g_persona.`Apellido1`, ' ',g_persona.`Apellido2`, ' ',g_persona.`Nombre1`, ' ',g_persona.`Nombre2`) asc ";
                } else if (this.JRBDeAlta.isSelected()) {
                    sql = "SELECT  DATE_FORMAT(h_atencion.Fecha_Atencion,'%d-%m-%Y') AS fecha, g_usuario.NoHistoria,  CONCAT(g_persona.`Apellido1`, ' ',g_persona.`Apellido2`, ' ',g_persona.`Nombre1`, ' ',g_persona.`Nombre2`) AS NUsuario, CONCAT(g_persona.Edad ,' ' , g_tipoedad.`Nbre` ) AS Edad    , g_persona.`Id_Sexo` , h_atencion.Codigo_Dxp ,  h_atencion.Codigo_DxR1 , h_atencion.Codigo_DxR2 , h_atencion.Codigo_DxR3, c_clasecita.Nbre AS NClaseCita, f_empresacontxconvenio.Nbre AS NEmpresa,c_citasnp.EstaFacturada, h_atencion.`Id`,  g_persona.`Id`, ingreso.Id AS IdIngreso, ingreso.Id_CondVict, ingreso.UsuarioS,`g_tipoatencion`.`Nbre` AS `TipoATencion`  FROM `profesional1`  INNER JOIN `c_citasnp` ON (`profesional1`.`Id_Persona` = `c_citasnp`.`Id_Profesional`)  AND (`profesional1`.`IdEspecialidad` = `c_citasnp`.`Id_Especialidad`)  INNER JOIN `ingreso`  ON (`ingreso`.`Id` = `c_citasnp`.`Id_ingreso`)  INNER JOIN `g_usuario`  ON (`g_usuario`.`Id_persona` = `ingreso`.`Id_Usuario`)  INNER JOIN `g_persona`  ON (`g_persona`.`Id` = `g_usuario`.`Id_persona`)  INNER JOIN `g_tipoedad`  ON (`g_persona`.`Id_TipoEdad` = `g_tipoedad`.`Id`)  INNER JOIN `f_empresacontxconvenio`  ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)  INNER JOIN `h_atencion`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)  INNER JOIN `c_clasecita`  ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`)   INNER JOIN `g_tipoatencion`  ON (`ingreso`.`Id_TipoAtencion` = `g_tipoatencion`.`Id`) WHERE (c_citasnp.Fecha_Cita >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND `ingreso`.`Egreso`=1 AND c_citasnp.Fecha_Cita <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "'  AND  h_atencion.Codigo_Dxp <>'' AND ingreso.Id_Sede ='" + this.xidtipodato[this.JCBUno.getSelectedIndex()] + "' AND profesional1.Id_Persona='" + this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 5) + "')   ORDER BY  c_citasnp.Fecha_Cita ASC, CONCAT(g_persona.`Apellido1`, ' ',g_persona.`Apellido2`, ' ',g_persona.`Nombre1`, ' ',g_persona.`Nombre2`) ASC  ";
                }
            } else {
                sql = "SELECT  DATE_FORMAT(h_atencion.Fecha_Atencion,'%d-%m-%Y') AS fecha,g_usuario.NoHistoria,  CONCAT(g_persona.`Apellido1`, ' ',g_persona.`Apellido2`, ' ',g_persona.`Nombre1`, ' ',g_persona.`Nombre2`) AS NUsuario, CONCAT(g_persona.Edad ,' ' , g_tipoedad.`Nbre` ) AS Edad    , g_persona.`Id_Sexo` , h_atencion.Codigo_Dxp , h_atencion.Codigo_DxR1 , h_atencion.Codigo_DxR2 , h_atencion.Codigo_DxR3,  c_clasecita.Nbre AS NClaseCita, f_empresacontxconvenio.Nbre AS NEmpresa,c_citasnp.EstaFacturada, h_atencion.`Id`,  g_persona.`Id`, ingreso.Id, ingreso.UsuarioS,  IF(f_factura_capita.`No_FacturaCapita` IS NULL, '0',f_factura_capita.`No_FacturaCapita`) AS FCapita ,  IF(f_factura_capita.`No_FacturaEvento` IS NULL, 0,f_factura_capita.`No_FacturaEvento`) AS NFEvento ,`g_tipoatencion`.`Nbre` AS `TipoATencion`  FROM h_atencion   INNER JOIN c_citasnp  ON (h_atencion.Id_Ingreso = c_citasnp.Id_ingreso)    INNER JOIN profesional1  ON (profesional1.Id_Persona = h_atencion.Id_Profesional)    AND (profesional1.IdEspecialidad = h_atencion.Id_Especialidad)     INNER JOIN g_usuario_sist ON (profesional1.Id_Persona = g_usuario_sist.Id_Persona)    INNER JOIN ingreso  ON (h_atencion.Id_Ingreso = ingreso.Id)   INNER JOIN `g_usuario`  ON (`g_usuario`.`Id_persona` = `ingreso`.`Id_Usuario`)   INNER JOIN `g_persona`  ON (`g_persona`.`Id` = `g_usuario`.`Id_persona`)  INNER JOIN `g_tipoedad`  ON (`g_persona`.`Id_TipoEdad` = `g_tipoedad`.`Id`) INNER JOIN c_clasecita  ON (h_atencion.Id_ClaseCita = c_clasecita.Id)    INNER JOIN f_empresacontxconvenio  ON (ingreso.Id_EmpresaContxConv = f_empresacontxconvenio.Id)   LEFT JOIN `f_liquidacion`  ON (ingreso.Id = f_liquidacion.`Id_Ingreso`)   LEFT JOIN `f_factura_capita`  ON (f_factura_capita.`Id_Liquidacion`= f_liquidacion.`Id`)    INNER JOIN `g_tipoatencion`  ON (`ingreso`.`Id_TipoAtencion` = `g_tipoatencion`.`Id`) WHERE (c_citasnp.Fecha_Cita >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "'  AND c_citasnp.Fecha_Cita <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "'   AND  h_atencion.Codigo_Dxp <>'' AND ingreso.Id_Sede ='" + this.xidtipodato[this.JCBUno.getSelectedIndex()] + "' )    ORDER BY  c_citasnp.Fecha_Cita ASC, CONCAT(g_persona.`Apellido1`, ' ',g_persona.`Apellido2`, ' ',g_persona.`Nombre1`, ' ',g_persona.`Nombre2`) ";
            }
            ResultSet xrs = this.xconsultabd.traerRs(sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                this.xmt.mEstablecerTextEditor(this.JTBDetalle1, 2);
                this.xmt.mEstablecerTextEditor(this.JTBDetalle1, 9);
                while (xrs.next()) {
                    this.xmodelo1.addRow(this.xdatos);
                    this.xmodelo1.setValueAt(xrs.getString(1), n, 0);
                    this.xmodelo1.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo1.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelo1.setValueAt(xrs.getString(4), n, 3);
                    this.xmodelo1.setValueAt(xrs.getString(5), n, 4);
                    this.xmodelo1.setValueAt(xrs.getString(6), n, 5);
                    this.xmodelo1.setValueAt(xrs.getString(7), n, 6);
                    this.xmodelo1.setValueAt(xrs.getString(8), n, 7);
                    this.xmodelo1.setValueAt(xrs.getString(9), n, 8);
                    this.xmodelo1.setValueAt(xrs.getString(10), n, 9);
                    this.xmodelo1.setValueAt(xrs.getString(11), n, 10);
                    this.xmodelo1.setValueAt(Integer.valueOf(xrs.getInt(12)), n, 11);
                    this.xmodelo1.setValueAt(xrs.getString(13), n, 12);
                    this.xmodelo1.setValueAt(xrs.getString(14), n, 13);
                    this.xmodelo1.setValueAt(xrs.getString(15), n, 14);
                    this.xmodelo1.setValueAt(xrs.getString(16), n, 15);
                    if (this.JTPResultado.getSelectedIndex() == 0) {
                        this.xmodelo1.setValueAt(0, n, 16);
                        this.xmodelo1.setValueAt(0, n, 17);
                        this.xmodelo1.setValueAt(xrs.getString("TipoATencion"), n, 18);
                    } else {
                        this.xmodelo1.setValueAt(Long.valueOf(xrs.getLong(17)), n, 16);
                        this.xmodelo1.setValueAt(Long.valueOf(xrs.getLong(18)), n, 17);
                        this.xmodelo1.setValueAt(xrs.getString("TipoATencion"), n, 18);
                    }
                    n++;
                }
            }
            xrs.close();
            this.xconsultabd.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFInformesNProgramada.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarDatosTabla2() {
        try {
            String sql = null;
            mCrearModeloDatos2();
            if (this.JRBEnAtencion1.isSelected()) {
                if (this.JCHFiltroB.isSelected()) {
                    if (this.JCH_FiltroProg.isSelected()) {
                        sql = "SELECT  DATE_FORMAT(h_atencion.Fecha_Atencion,'%d-%m-%Y') AS fecha, g_usuario.NoHistoria,  CONCAT(g_persona.`Apellido1`, ' ',g_persona.`Apellido2`, ' ',g_persona.`Nombre1`, ' ',g_persona.`Nombre2`) AS NUsuario, CONCAT(g_persona.Edad ,' ' , g_tipoedad.`Nbre` ) AS Edad    , g_persona.`Id_Sexo`    , h_atencion.Codigo_Dxp , h_atencion.Codigo_DxR1 , h_atencion.Codigo_DxR2 , h_atencion.Codigo_DxR3, c_clasecita.Nbre AS NClaseCita, f_empresacontxconvenio.Nbre AS NEmpresa,c_citasnp.EstaFacturada, h_atencion.`Id`, g_persona.`Id`, ingreso.Id AS IdIngreso, ingreso.Id_CondVict, ingreso.UsuarioS, ingreso.Id_TipoAtencion , IFNULL(h_atencion_anexo_dos.`Id`, 0) NIdAnexo,`g_tipoatencion`.`Nbre` AS `TipoATencion`,`c_clasecita`.`Id_Historia` FROM `profesional1` INNER JOIN `c_citasnp` ON (`profesional1`.`Id_Persona` = `c_citasnp`.`Id_Profesional`) AND (`profesional1`.`IdEspecialidad` = `c_citasnp`.`Id_Especialidad`) INNER JOIN `ingreso`  ON (`ingreso`.`Id` = `c_citasnp`.`Id_ingreso`) INNER JOIN `g_usuario`  ON (`g_usuario`.`Id_persona` = `ingreso`.`Id_Usuario`)   INNER JOIN `g_persona`  ON (`g_persona`.`Id` = `g_usuario`.`Id_persona`)  INNER JOIN `g_tipoedad`  ON (`g_persona`.`Id_TipoEdad` = `g_tipoedad`.`Id`) INNER JOIN `f_empresacontxconvenio`  ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`) INNER JOIN `h_atencion`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`) INNER JOIN `c_clasecita`  ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`) INNER JOIN `g_tipoatencion`  ON (`ingreso`.`Id_TipoAtencion` = `g_tipoatencion`.`Id`)  LEFT JOIN `h_atencion_anexo_dos` ON (`h_atencion_anexo_dos`.`IdAtencion`=h_atencion.`Id`) AND (h_atencion_anexo_dos.`Estado`=1) WHERE (CONCAT(g_persona.`Apellido1`, ' ',g_persona.`Apellido2`, ' ',g_persona.`Nombre1`, ' ',g_persona.`Nombre2`) like'" + this.JTFBusqueda.getText() + "%' and c_citasnp.Fecha_Cita >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND `ingreso`.`Egreso`=0 AND c_citasnp.Fecha_Cita <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' AND  h_atencion.Codigo_Dxp <>'' AND ingreso.Id_Sede ='" + this.xidtipodato[this.JCBUno.getSelectedIndex()] + "'  )   ORDER BY CONCAT(g_persona.`Apellido1`, ' ',g_persona.`Apellido2`, ' ',g_persona.`Nombre1`, ' ',g_persona.`Nombre2`)  ASC ";
                    } else {
                        sql = "SELECT  DATE_FORMAT(h_atencion.Fecha_Atencion,'%d-%m-%Y') AS fecha, g_usuario.NoHistoria,  CONCAT(g_persona.`Apellido1`, ' ',g_persona.`Apellido2`, ' ',g_persona.`Nombre1`, ' ',g_persona.`Nombre2`) AS NUsuario, CONCAT(g_persona.Edad ,' ' , g_tipoedad.`Nbre` ) AS Edad    , g_persona.`Id_Sexo`    , h_atencion.Codigo_Dxp , h_atencion.Codigo_DxR1 , h_atencion.Codigo_DxR2 , h_atencion.Codigo_DxR3, c_clasecita.Nbre AS NClaseCita, f_empresacontxconvenio.Nbre AS NEmpresa,1, h_atencion.`Id`, g_persona.`Id`, ingreso.Id AS IdIngreso, ingreso.Id_CondVict, ingreso.UsuarioS, ingreso.Id_TipoAtencion , IFNULL(h_atencion_anexo_dos.`Id`, 0) NIdAnexo,`g_tipoatencion`.`Nbre` AS `TipoATencion`,`c_clasecita`.`Id_Historia` FROM `profesional1` INNER JOIN `c_citas` ON (`profesional1`.`Id_Persona` = `c_citas`.`Id_Profesional`) AND (`profesional1`.`IdEspecialidad` = `c_citas`.`Id_Especialidad`) INNER JOIN `ingreso`  ON (`ingreso`.`Id` = `c_citas`.`Id_ingreso`) INNER JOIN `g_usuario`  ON (`g_usuario`.`Id_persona` = `ingreso`.`Id_Usuario`)   INNER JOIN `g_persona`  ON (`g_persona`.`Id` = `g_usuario`.`Id_persona`)  INNER JOIN `g_tipoedad`  ON (`g_persona`.`Id_TipoEdad` = `g_tipoedad`.`Id`) INNER JOIN `f_empresacontxconvenio`  ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`) INNER JOIN `h_atencion`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`) INNER JOIN `c_clasecita`  ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`) INNER JOIN `g_tipoatencion`  ON (`ingreso`.`Id_TipoAtencion` = `g_tipoatencion`.`Id`)  LEFT JOIN `h_atencion_anexo_dos` ON (`h_atencion_anexo_dos`.`IdAtencion`=h_atencion.`Id`) AND (h_atencion_anexo_dos.`Estado`=1) WHERE (CONCAT(g_persona.`Apellido1`, ' ',g_persona.`Apellido2`, ' ',g_persona.`Nombre1`, ' ',g_persona.`Nombre2`) like'" + this.JTFBusqueda.getText() + "%' and c_citas.Fecha_Cita >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND `ingreso`.`Egreso`=0 AND c_citas.Fecha_Cita <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' AND  h_atencion.Codigo_Dxp <>'' AND ingreso.Id_Sede ='" + this.xidtipodato[this.JCBUno.getSelectedIndex()] + "'  )   ORDER BY CONCAT(g_persona.`Apellido1`, ' ',g_persona.`Apellido2`, ' ',g_persona.`Nombre1`, ' ',g_persona.`Nombre2`)  ASC ";
                    }
                } else if (this.JCH_FiltroProg.isSelected()) {
                    sql = "SELECT  DATE_FORMAT(h_atencion.Fecha_Atencion,'%d-%m-%Y') AS fecha, g_usuario.NoHistoria,  CONCAT(g_persona.`Apellido1`, ' ',g_persona.`Apellido2`, ' ',g_persona.`Nombre1`, ' ',g_persona.`Nombre2`) AS NUsuario, CONCAT(g_persona.Edad ,' ' , g_tipoedad.`Nbre` ) AS Edad    , g_persona.`Id_Sexo`    ,  h_atencion.Codigo_Dxp , h_atencion.Codigo_DxR1 , h_atencion.Codigo_DxR2 , h_atencion.Codigo_DxR3, c_clasecita.Nbre AS NClaseCita, f_empresacontxconvenio.Nbre AS NEmpresa,c_citasnp.EstaFacturada, h_atencion.`Id`, g_persona.`Id`, ingreso.Id AS IdIngreso, ingreso.Id_CondVict, ingreso.UsuarioS, ingreso.Id_TipoAtencion , IFNULL(h_atencion_anexo_dos.`Id`, 0) NIdAnexo,`g_tipoatencion`.`Nbre` AS `TipoATencion`,`c_clasecita`.`Id_Historia` FROM `profesional1` INNER JOIN `c_citasnp` ON (`profesional1`.`Id_Persona` = `c_citasnp`.`Id_Profesional`) AND (`profesional1`.`IdEspecialidad` = `c_citasnp`.`Id_Especialidad`) INNER JOIN `ingreso`  ON (`ingreso`.`Id` = `c_citasnp`.`Id_ingreso`) INNER JOIN `g_usuario`  ON (`g_usuario`.`Id_persona` = `ingreso`.`Id_Usuario`)   INNER JOIN `g_persona`  ON (`g_persona`.`Id` = `g_usuario`.`Id_persona`)  INNER JOIN `g_tipoedad`  ON (`g_persona`.`Id_TipoEdad` = `g_tipoedad`.`Id`) INNER JOIN `f_empresacontxconvenio`  ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`) INNER JOIN `h_atencion`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`) INNER JOIN `c_clasecita`  ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`) INNER JOIN `g_tipoatencion`  ON (`ingreso`.`Id_TipoAtencion` = `g_tipoatencion`.`Id`)  LEFT JOIN `h_atencion_anexo_dos` ON (`h_atencion_anexo_dos`.`IdAtencion`=h_atencion.`Id`) AND (h_atencion_anexo_dos.`Estado`=1) WHERE (c_citasnp.Fecha_Cita >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND `ingreso`.`Egreso`=0 AND c_citasnp.Fecha_Cita <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' AND  h_atencion.Codigo_Dxp <>'' AND ingreso.Id_Sede ='" + this.xidtipodato[this.JCBUno.getSelectedIndex()] + "'  )   ORDER BY CONCAT(g_persona.`Apellido1`, ' ',g_persona.`Apellido2`, ' ',g_persona.`Nombre1`, ' ',g_persona.`Nombre2`)  ASC ";
                } else {
                    sql = "SELECT  DATE_FORMAT(h_atencion.Fecha_Atencion,'%d-%m-%Y') AS fecha, g_usuario.NoHistoria,  CONCAT(g_persona.`Apellido1`, ' ',g_persona.`Apellido2`, ' ',g_persona.`Nombre1`, ' ',g_persona.`Nombre2`) AS NUsuario, CONCAT(g_persona.Edad ,' ' , g_tipoedad.`Nbre` ) AS Edad    , g_persona.`Id_Sexo`    ,  h_atencion.Codigo_Dxp , h_atencion.Codigo_DxR1 , h_atencion.Codigo_DxR2 , h_atencion.Codigo_DxR3, c_clasecita.Nbre AS NClaseCita, f_empresacontxconvenio.Nbre AS NEmpresa,1, h_atencion.`Id`, g_persona.`Id`, ingreso.Id AS IdIngreso, ingreso.Id_CondVict, ingreso.UsuarioS, ingreso.Id_TipoAtencion , IFNULL(h_atencion_anexo_dos.`Id`, 0) NIdAnexo,`g_tipoatencion`.`Nbre` AS `TipoATencion`,`c_clasecita`.`Id_Historia` FROM `profesional1` INNER JOIN `c_citas` ON (`profesional1`.`Id_Persona` = `c_citas`.`Id_Profesional`) AND (`profesional1`.`IdEspecialidad` = `c_citas`.`Id_Especialidad`) INNER JOIN `ingreso`  ON (`ingreso`.`Id` = `c_citas`.`Id_ingreso`) INNER JOIN `g_usuario`  ON (`g_usuario`.`Id_persona` = `ingreso`.`Id_Usuario`)   INNER JOIN `g_persona`  ON (`g_persona`.`Id` = `g_usuario`.`Id_persona`)  INNER JOIN `g_tipoedad`  ON (`g_persona`.`Id_TipoEdad` = `g_tipoedad`.`Id`) INNER JOIN `f_empresacontxconvenio`  ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`) INNER JOIN `h_atencion`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`) INNER JOIN `c_clasecita`  ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`) INNER JOIN `g_tipoatencion`  ON (`ingreso`.`Id_TipoAtencion` = `g_tipoatencion`.`Id`)  LEFT JOIN `h_atencion_anexo_dos` ON (`h_atencion_anexo_dos`.`IdAtencion`=h_atencion.`Id`) AND (h_atencion_anexo_dos.`Estado`=1) WHERE (c_citas.Fecha_Cita >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND `ingreso`.`Egreso`=0 AND c_citas.Fecha_Cita <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' AND  h_atencion.Codigo_Dxp <>'' AND ingreso.Id_Sede ='" + this.xidtipodato[this.JCBUno.getSelectedIndex()] + "'  )   ORDER BY CONCAT(g_persona.`Apellido1`, ' ',g_persona.`Apellido2`, ' ',g_persona.`Nombre1`, ' ',g_persona.`Nombre2`)  ASC ";
                }
            } else if (this.JRBDeAlta.isSelected()) {
                if (this.JCHFiltroB.isSelected()) {
                    if (this.JCH_FiltroProg.isSelected()) {
                        sql = "SELECT  DATE_FORMAT(h_atencion.Fecha_Atencion,'%d-%m-%Y') AS fecha, g_usuario.NoHistoria,  CONCAT(g_persona.`Apellido1`, ' ',g_persona.`Apellido2`, ' ',g_persona.`Nombre1`, ' ',g_persona.`Nombre2`) AS NUsuario, CONCAT(g_persona.Edad ,' ' , g_tipoedad.`Nbre` ) AS Edad    , g_persona.`Id_Sexo`    ,  h_atencion.Codigo_Dxp , h_atencion.Codigo_DxR1 , h_atencion.Codigo_DxR2 , h_atencion.Codigo_DxR3, c_clasecita.Nbre AS NClaseCita, f_empresacontxconvenio.Nbre AS NEmpresa,c_citasnp.EstaFacturada, h_atencion.`Id`, g_persona.`Id`, ingreso.Id AS IdIngreso, ingreso.Id_CondVict, ingreso.UsuarioS, ingreso.Id_TipoAtencion , IFNULL(h_atencion_anexo_dos.`Id`, 0) NIdAnexo,`g_tipoatencion`.`Nbre` AS `TipoATencion`,`c_clasecita`.`Id_Historia` FROM `profesional1` INNER JOIN `c_citasnp` ON (`profesional1`.`Id_Persona` = `c_citasnp`.`Id_Profesional`) AND (`profesional1`.`IdEspecialidad` = `c_citasnp`.`Id_Especialidad`) INNER JOIN `ingreso`  ON (`ingreso`.`Id` = `c_citasnp`.`Id_ingreso`) INNER JOIN `g_usuario`  ON (`g_usuario`.`Id_persona` = `ingreso`.`Id_Usuario`)   INNER JOIN `g_persona`  ON (`g_persona`.`Id` = `g_usuario`.`Id_persona`)  INNER JOIN `g_tipoedad`  ON (`g_persona`.`Id_TipoEdad` = `g_tipoedad`.`Id`) INNER JOIN `f_empresacontxconvenio`  ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`) INNER JOIN `h_atencion`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`) INNER JOIN `c_clasecita`  ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`) INNER JOIN `g_tipoatencion`  ON (`ingreso`.`Id_TipoAtencion` = `g_tipoatencion`.`Id`)  LEFT JOIN `h_atencion_anexo_dos` ON (`h_atencion_anexo_dos`.`IdAtencion`=h_atencion.`Id`) AND (h_atencion_anexo_dos.`Estado`=1)  left join h_egreso_atencion hea on (hea.Id_Ingreso=`ingreso`.`Id`) and (hea.Id_Tipo=ingreso.Id_TipoAtencion) WHERE (CONCAT(g_persona.`Apellido1`, ' ',g_persona.`Apellido2`, ' ',g_persona.`Nombre1`, ' ',g_persona.`Nombre2`) like'" + this.JTFBusqueda.getText() + "%' and c_citasnp.Fecha_Cita >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND if(hea.Id=null, 0,1)=1  AND c_citasnp.Fecha_Cita <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' AND  h_atencion.Codigo_Dxp <>'' AND ingreso.Id_Sede ='" + this.xidtipodato[this.JCBUno.getSelectedIndex()] + "'  )   ORDER BY CONCAT(g_persona.`Apellido1`, ' ',g_persona.`Apellido2`, ' ',g_persona.`Nombre1`, ' ',g_persona.`Nombre2`)  ASC ";
                    } else {
                        sql = "SELECT  DATE_FORMAT(h_atencion.Fecha_Atencion,'%d-%m-%Y') AS fecha, g_usuario.NoHistoria,  CONCAT(g_persona.`Apellido1`, ' ',g_persona.`Apellido2`, ' ',g_persona.`Nombre1`, ' ',g_persona.`Nombre2`) AS NUsuario, CONCAT(g_persona.Edad ,' ' , g_tipoedad.`Nbre` ) AS Edad    , g_persona.`Id_Sexo`    ,  h_atencion.Codigo_Dxp , h_atencion.Codigo_DxR1 , h_atencion.Codigo_DxR2 , h_atencion.Codigo_DxR3, c_clasecita.Nbre AS NClaseCita, f_empresacontxconvenio.Nbre AS NEmpresa,1, h_atencion.`Id`, g_persona.`Id`, ingreso.Id AS IdIngreso, ingreso.Id_CondVict, ingreso.UsuarioS, ingreso.Id_TipoAtencion , IFNULL(h_atencion_anexo_dos.`Id`, 0) NIdAnexo,`g_tipoatencion`.`Nbre` AS `TipoATencion`,`c_clasecita`.`Id_Historia` FROM `profesional1` INNER JOIN `c_citas` ON (`profesional1`.`Id_Persona` = `c_citas`.`Id_Profesional`) AND (`profesional1`.`IdEspecialidad` = `c_citas`.`Id_Especialidad`) INNER JOIN `ingreso`  ON (`ingreso`.`Id` = `c_citas`.`Id_ingreso`) INNER JOIN `g_usuario`  ON (`g_usuario`.`Id_persona` = `ingreso`.`Id_Usuario`)   INNER JOIN `g_persona`  ON (`g_persona`.`Id` = `g_usuario`.`Id_persona`)  INNER JOIN `g_tipoedad`  ON (`g_persona`.`Id_TipoEdad` = `g_tipoedad`.`Id`) INNER JOIN `f_empresacontxconvenio`  ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`) INNER JOIN `h_atencion`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`) INNER JOIN `c_clasecita`  ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`) INNER JOIN `g_tipoatencion`  ON (`ingreso`.`Id_TipoAtencion` = `g_tipoatencion`.`Id`)  LEFT JOIN `h_atencion_anexo_dos` ON (`h_atencion_anexo_dos`.`IdAtencion`=h_atencion.`Id`) AND (h_atencion_anexo_dos.`Estado`=1) WHERE (CONCAT(g_persona.`Apellido1`, ' ',g_persona.`Apellido2`, ' ',g_persona.`Nombre1`, ' ',g_persona.`Nombre2`) like'" + this.JTFBusqueda.getText() + "%' and c_citas.Fecha_Cita >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "'  AND c_citas.Fecha_Cita <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' AND  h_atencion.Codigo_Dxp <>'' AND ingreso.Id_Sede ='" + this.xidtipodato[this.JCBUno.getSelectedIndex()] + "'  )   ORDER BY CONCAT(g_persona.`Apellido1`, ' ',g_persona.`Apellido2`, ' ',g_persona.`Nombre1`, ' ',g_persona.`Nombre2`)  ASC ";
                    }
                } else if (this.JCH_FiltroProg.isSelected()) {
                    sql = "SELECT  DATE_FORMAT(h_atencion.Fecha_Atencion,'%d-%m-%Y') AS fecha, g_usuario.NoHistoria,  CONCAT(g_persona.`Apellido1`, ' ',g_persona.`Apellido2`, ' ',g_persona.`Nombre1`, ' ',g_persona.`Nombre2`) AS NUsuario, CONCAT(g_persona.Edad ,' ' , g_tipoedad.`Nbre` ) AS Edad    , g_persona.`Id_Sexo`    , h_atencion.Codigo_Dxp , h_atencion.Codigo_DxR1 , h_atencion.Codigo_DxR2 , h_atencion.Codigo_DxR3, c_clasecita.Nbre AS NClaseCita, f_empresacontxconvenio.Nbre AS NEmpresa,c_citasnp.EstaFacturada, h_atencion.`Id`, g_persona.`Id`, ingreso.Id AS IdIngreso, ingreso.Id_CondVict, ingreso.UsuarioS, ingreso.Id_TipoAtencion , IFNULL(h_atencion_anexo_dos.`Id`, 0) NIdAnexo,`g_tipoatencion`.`Nbre` AS `TipoATencion`,`c_clasecita`.`Id_Historia` FROM `profesional1` INNER JOIN `c_citasnp` ON (`profesional1`.`Id_Persona` = `c_citasnp`.`Id_Profesional`) AND (`profesional1`.`IdEspecialidad` = `c_citasnp`.`Id_Especialidad`) INNER JOIN `ingreso`  ON (`ingreso`.`Id` = `c_citasnp`.`Id_ingreso`) INNER JOIN `g_usuario`  ON (`g_usuario`.`Id_persona` = `ingreso`.`Id_Usuario`)   INNER JOIN `g_persona`  ON (`g_persona`.`Id` = `g_usuario`.`Id_persona`)  INNER JOIN `g_tipoedad`  ON (`g_persona`.`Id_TipoEdad` = `g_tipoedad`.`Id`) INNER JOIN `f_empresacontxconvenio`  ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`) INNER JOIN `h_atencion`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`) INNER JOIN `c_clasecita`  ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`) INNER JOIN `g_tipoatencion`  ON (`ingreso`.`Id_TipoAtencion` = `g_tipoatencion`.`Id`)  LEFT JOIN `h_atencion_anexo_dos` ON (`h_atencion_anexo_dos`.`IdAtencion`=h_atencion.`Id`) AND (h_atencion_anexo_dos.`Estado`=1)  left join h_egreso_atencion hea on (hea.Id_Ingreso=`ingreso`.`Id`) and (hea.Id_Tipo=ingreso.Id_TipoAtencion) WHERE (c_citasnp.Fecha_Cita >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND if(hea.Id=null, 0,1)=1  AND c_citasnp.Fecha_Cita <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' AND  h_atencion.Codigo_Dxp <>'' AND ingreso.Id_Sede ='" + this.xidtipodato[this.JCBUno.getSelectedIndex()] + "'  )   ORDER BY CONCAT(g_persona.`Apellido1`, ' ',g_persona.`Apellido2`, ' ',g_persona.`Nombre1`, ' ',g_persona.`Nombre2`)  ASC ";
                } else {
                    sql = "SELECT  DATE_FORMAT(h_atencion.Fecha_Atencion,'%d-%m-%Y') AS fecha, g_usuario.NoHistoria,  CONCAT(g_persona.`Apellido1`, ' ',g_persona.`Apellido2`, ' ',g_persona.`Nombre1`, ' ',g_persona.`Nombre2`) AS NUsuario, CONCAT(g_persona.Edad ,' ' , g_tipoedad.`Nbre` ) AS Edad    , g_persona.`Id_Sexo`    , h_atencion.Codigo_Dxp , h_atencion.Codigo_DxR1 , h_atencion.Codigo_DxR2 , h_atencion.Codigo_DxR3, c_clasecita.Nbre AS NClaseCita, f_empresacontxconvenio.Nbre AS NEmpresa,1, h_atencion.`Id`, g_persona.`Id`, ingreso.Id AS IdIngreso, ingreso.Id_CondVict, ingreso.UsuarioS, ingreso.Id_TipoAtencion , IFNULL(h_atencion_anexo_dos.`Id`, 0) NIdAnexo,`g_tipoatencion`.`Nbre` AS `TipoATencion`,`c_clasecita`.`Id_Historia` FROM `profesional1` INNER JOIN `c_citas` ON (`profesional1`.`Id_Persona` = `c_citas`.`Id_Profesional`) AND (`profesional1`.`IdEspecialidad` = `c_citas`.`Id_Especialidad`) INNER JOIN `ingreso`  ON (`ingreso`.`Id` = `c_citas`.`Id_ingreso`) INNER JOIN `g_usuario`  ON (`g_usuario`.`Id_persona` = `ingreso`.`Id_Usuario`)   INNER JOIN `g_persona`  ON (`g_persona`.`Id` = `g_usuario`.`Id_persona`)  INNER JOIN `g_tipoedad`  ON (`g_persona`.`Id_TipoEdad` = `g_tipoedad`.`Id`) INNER JOIN `f_empresacontxconvenio`  ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`) INNER JOIN `h_atencion`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`) INNER JOIN `c_clasecita`  ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`) INNER JOIN `g_tipoatencion`  ON (`ingreso`.`Id_TipoAtencion` = `g_tipoatencion`.`Id`)  LEFT JOIN `h_atencion_anexo_dos` ON (`h_atencion_anexo_dos`.`IdAtencion`=h_atencion.`Id`) AND (h_atencion_anexo_dos.`Estado`=1) WHERE (c_citas.Fecha_Cita >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND c_citas.Fecha_Cita <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' AND  h_atencion.Codigo_Dxp <>'' AND ingreso.Id_Sede ='" + this.xidtipodato[this.JCBUno.getSelectedIndex()] + "'  )   ORDER BY CONCAT(g_persona.`Apellido1`, ' ',g_persona.`Apellido2`, ' ',g_persona.`Nombre1`, ' ',g_persona.`Nombre2`)  ASC ";
                }
            }
            ResultSet xrs = this.xconsultabd.traerRs(sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                this.xmt.mEstablecerTextEditor(this.JTBDetalle2, 2);
                this.xmt.mEstablecerTextEditor(this.JTBDetalle2, 9);
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
                    this.xmodelo2.setValueAt(Integer.valueOf(xrs.getInt(12)), n, 11);
                    this.xmodelo2.setValueAt(xrs.getString(13), n, 12);
                    this.xmodelo2.setValueAt(xrs.getString(14), n, 13);
                    this.xmodelo2.setValueAt(xrs.getString(15), n, 14);
                    this.xmodelo2.setValueAt(Integer.valueOf(xrs.getInt(16)), n, 15);
                    this.xmodelo2.setValueAt(xrs.getString(17), n, 16);
                    this.xmodelo2.setValueAt(xrs.getString(18), n, 17);
                    this.xmodelo2.setValueAt(Long.valueOf(xrs.getLong("NIdAnexo")), n, 18);
                    this.xmodelo2.setValueAt(xrs.getString("TipoATencion"), n, 19);
                    this.xmodelo2.setValueAt(Integer.valueOf(xrs.getInt("Id_Historia")), n, 20);
                    this.JTBDetalle2.setDefaultRenderer(Object.class, new MiRender());
                    n++;
                }
            }
            xrs.close();
            this.xconsultabd.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFInformesNProgramada.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mImprimir() {
        String[][] parametros = new String[6][2];
        parametros[0][0] = "fechai";
        parametros[0][1] = this.xmt.formatoAMD.format(this.JDFechaI.getDate());
        parametros[1][0] = "fechaf";
        parametros[1][1] = this.xmt.formatoAMD.format(this.JDFechaF.getDate());
        parametros[2][0] = "usuario";
        parametros[2][1] = this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 4).toString();
        parametros[3][0] = "sede";
        parametros[3][1] = this.xidtipodato[this.JCBUno.getSelectedIndex()];
        parametros[4][0] = "SUBREPORT_DIR";
        parametros[4][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
        parametros[5][0] = "SUBREPORTFIRMA_DIR";
        parametros[5][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
        this.xmt.GenerarPDF(this.xmt.getRutaRep() + "H_ReporteDeAtencionNPMedico", parametros);
    }

    /* JADX INFO: loaded from: GenomaP.jar:Sig/JIFInformesNProgramada$MiRender.class */
    public static class MiRender extends DefaultTableCellRenderer {
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (Long.valueOf(table.getValueAt(row, 15).toString()).longValue() != 0) {
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
            Logger.getLogger(JIFInformesNProgramada.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }
}
