package Sig;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

/* JADX INFO: loaded from: GenomaP.jar:Sig/JIFConsultarInforSo.class */
public class JIFConsultarInforSo extends JInternalFrame {
    private String[] xidtipoempresa;
    private DefaultTableModel xmodelo;
    private DefaultTableModel xmodelo1;
    private DefaultTableModel xmodelo2;
    private DefaultTableModel xmodelo4;
    private ConsultasMySQL xct = new ConsultasMySQL();
    private Metodos xmt = new Metodos();
    private Object[] xdato;
    private String xsql;
    private ButtonGroup JBGFiltroT;
    private ButtonGroup JBGTipoDx;
    private JButton JBTExportar;
    private JCheckBox JCBKardex;
    private JComboBox JCBTipoEmpresa;
    private JCheckBox JCHFiltro;
    private JCheckBox JCHFiltroDias;
    private JCheckBox JCHFiltroDias1;
    private JCheckBox JCHFiltroNoHistoria;
    private JCheckBox JCHIncapacidades;
    private JDateChooser JDFechaF;
    private JDateChooser JDFechaI;
    private JPanel JPIFiltro;
    private JPanel JPIncapacidad;
    private JScrollPane JSPDetalle;
    private JScrollPane JSPDetalle1;
    private JScrollPane JSPDetalle2;
    private JSpinner JSPNDias;
    private JTable JTBDetalle;
    private JTable JTBDetalle1;
    private JTable JTBDetalle2;
    private JTextField JTFNoHistoria;
    private JTextField JTFNombre;
    private JTextField JTFRuta;
    private JTabbedPane JTPDatosC;
    private JPanel jPanel1;

    public JIFConsultarInforSo() {
        initComponents();
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v37, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v41, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v83, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGTipoDx = new ButtonGroup();
        this.JBGFiltroT = new ButtonGroup();
        this.JPIFiltro = new JPanel();
        this.JDFechaI = new JDateChooser();
        this.JDFechaF = new JDateChooser();
        this.JTFRuta = new JTextField();
        this.JBTExportar = new JButton();
        this.JCBTipoEmpresa = new JComboBox();
        this.JCHFiltro = new JCheckBox();
        this.JCHIncapacidades = new JCheckBox();
        this.JTPDatosC = new JTabbedPane();
        this.JSPDetalle = new JScrollPane();
        this.JTBDetalle = new JTable();
        this.JSPDetalle1 = new JScrollPane();
        this.JTBDetalle1 = new JTable();
        this.JPIncapacidad = new JPanel();
        this.jPanel1 = new JPanel();
        this.JTFNoHistoria = new JTextField();
        this.JTFNombre = new JTextField();
        this.JCHFiltroNoHistoria = new JCheckBox();
        this.JCHFiltroDias = new JCheckBox();
        this.JCHFiltroDias1 = new JCheckBox();
        this.JSPNDias = new JSpinner();
        this.JCBKardex = new JCheckBox();
        this.JSPDetalle2 = new JScrollPane();
        this.JTBDetalle2 = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("CONSULTAR INFORMACIÓN PARA SALUD OCUPACIONAL");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjifinformacionso");
        addInternalFrameListener(new InternalFrameListener() { // from class: Sig.JIFConsultarInforSo.1
            public void internalFrameActivated(InternalFrameEvent evt) {
            }

            public void internalFrameClosed(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                JIFConsultarInforSo.this.formInternalFrameClosing(evt);
            }

            public void internalFrameDeactivated(InternalFrameEvent evt) {
            }

            public void internalFrameDeiconified(InternalFrameEvent evt) {
            }

            public void internalFrameIconified(InternalFrameEvent evt) {
            }

            public void internalFrameOpened(InternalFrameEvent evt) {
            }
        });
        this.JPIFiltro.setBorder(BorderFactory.createTitledBorder((Border) null, "FILTRO", 0, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JDFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFechaI.setFont(new Font("Arial", 1, 12));
        this.JDFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Fin", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFechaF.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\\\Genoma\\\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: Sig.JIFConsultarInforSo.2
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarInforSo.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setForeground(Color.red);
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: Sig.JIFConsultarInforSo.3
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarInforSo.this.JBTExportarActionPerformed(evt);
            }
        });
        this.JCBTipoEmpresa.setFont(new Font("Arial", 1, 12));
        this.JCBTipoEmpresa.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Empresa", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHFiltro.setFont(new Font("Arial", 1, 12));
        this.JCHFiltro.setText("Filtro?");
        this.JCHFiltro.setToolTipText("Filtro por tipo empresa");
        this.JCHFiltro.addActionListener(new ActionListener() { // from class: Sig.JIFConsultarInforSo.4
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarInforSo.this.JCHFiltroActionPerformed(evt);
            }
        });
        this.JCHIncapacidades.setFont(new Font("Arial", 1, 12));
        this.JCHIncapacidades.setText("Incapacidades");
        this.JCHIncapacidades.setToolTipText("Filtro por tipo empresa");
        this.JCHIncapacidades.addActionListener(new ActionListener() { // from class: Sig.JIFConsultarInforSo.5
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarInforSo.this.JCHIncapacidadesActionPerformed(evt);
            }
        });
        GroupLayout JPIFiltroLayout = new GroupLayout(this.JPIFiltro);
        this.JPIFiltro.setLayout(JPIFiltroLayout);
        JPIFiltroLayout.setHorizontalGroup(JPIFiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIFiltroLayout.createSequentialGroup().addContainerGap().addGroup(JPIFiltroLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JTFRuta, GroupLayout.Alignment.LEADING, -1, 726, 32767).addGroup(JPIFiltroLayout.createSequentialGroup().addComponent(this.JDFechaI, -2, 116, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JDFechaF, -2, 116, -2).addGap(18, 18, 18).addComponent(this.JCBTipoEmpresa, 0, 466, 32767))).addGroup(JPIFiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFiltroLayout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.JBTExportar, -2, 171, -2)).addGroup(JPIFiltroLayout.createSequentialGroup().addGap(18, 18, 18).addComponent(this.JCHFiltro).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHIncapacidades))).addContainerGap()));
        JPIFiltroLayout.setVerticalGroup(JPIFiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIFiltroLayout.createSequentialGroup().addGroup(JPIFiltroLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPIFiltroLayout.createSequentialGroup().addContainerGap().addComponent(this.JBTExportar, -2, 50, -2)).addGroup(JPIFiltroLayout.createSequentialGroup().addGroup(JPIFiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFiltroLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBTipoEmpresa, -1, 52, 32767).addComponent(this.JCHFiltro).addComponent(this.JCHIncapacidades)).addGroup(JPIFiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JDFechaF, -1, -1, 32767).addComponent(this.JDFechaI, -2, -1, -2))).addGap(18, 18, 18).addComponent(this.JTFRuta, -2, 50, -2))).addContainerGap()));
        this.JTPDatosC.setBorder(BorderFactory.createTitledBorder((Border) null, "CONSOLIDADO", 2, 0, new Font("Arial", 1, 14), Color.blue));
        this.JTPDatosC.setForeground(Color.red);
        this.JTPDatosC.setFont(new Font("Arial", 1, 14));
        this.JTBDetalle.setFont(new Font("Arial", 1, 12));
        this.JTBDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTBDetalle.setRowHeight(25);
        this.JTBDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTBDetalle.setSelectionForeground(Color.red);
        this.JTBDetalle.setSelectionMode(0);
        this.JSPDetalle.setViewportView(this.JTBDetalle);
        this.JTPDatosC.addTab("CITAS PROGRAMADAS", this.JSPDetalle);
        this.JTBDetalle1.setFont(new Font("Arial", 1, 12));
        this.JTBDetalle1.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTBDetalle1.setRowHeight(25);
        this.JTBDetalle1.setSelectionBackground(new Color(255, 255, 255));
        this.JTBDetalle1.setSelectionForeground(Color.red);
        this.JTBDetalle1.setSelectionMode(0);
        this.JSPDetalle1.setViewportView(this.JTBDetalle1);
        this.JTPDatosC.addTab("CITAS NO PROGRAMADAS", this.JSPDetalle1);
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "Datos", 0, 0, new Font("Arial", 1, 14), new Color(0, 0, 255)));
        this.JTFNoHistoria.setFont(new Font("Arial", 1, 12));
        this.JTFNoHistoria.setToolTipText("");
        this.JTFNoHistoria.setBorder(BorderFactory.createTitledBorder((Border) null, "No. Historia", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFNoHistoria.addActionListener(new ActionListener() { // from class: Sig.JIFConsultarInforSo.6
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarInforSo.this.JTFNoHistoriaActionPerformed(evt);
            }
        });
        this.JTFNoHistoria.addFocusListener(new FocusAdapter() { // from class: Sig.JIFConsultarInforSo.7
            public void focusLost(FocusEvent evt) {
                JIFConsultarInforSo.this.JTFNoHistoriaFocusLost(evt);
            }
        });
        this.JTFNombre.setFont(new Font("Arial", 1, 12));
        this.JTFNombre.setToolTipText("");
        this.JTFNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre Usuario", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHFiltroNoHistoria.setFont(new Font("Arial", 1, 12));
        this.JCHFiltroNoHistoria.setText("Filtro por No. de  Historia");
        this.JCHFiltroNoHistoria.setToolTipText("Filtro por tipo empresa");
        this.JCHFiltroNoHistoria.addActionListener(new ActionListener() { // from class: Sig.JIFConsultarInforSo.8
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarInforSo.this.JCHFiltroNoHistoriaActionPerformed(evt);
            }
        });
        this.JBGFiltroT.add(this.JCHFiltroDias);
        this.JCHFiltroDias.setFont(new Font("Arial", 1, 12));
        this.JCHFiltroDias.setText("Filtro po N° días \">=\"");
        this.JCHFiltroDias.setToolTipText("Filtro por tipo empresa");
        this.JCHFiltroDias.addActionListener(new ActionListener() { // from class: Sig.JIFConsultarInforSo.9
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarInforSo.this.JCHFiltroDiasActionPerformed(evt);
            }
        });
        this.JBGFiltroT.add(this.JCHFiltroDias1);
        this.JCHFiltroDias1.setFont(new Font("Arial", 1, 12));
        this.JCHFiltroDias1.setText("Filtro po N° días \"<=\"");
        this.JCHFiltroDias1.setToolTipText("Filtro por tipo empresa");
        this.JSPNDias.setFont(new Font("Arial", 1, 12));
        this.JSPNDias.setModel(new SpinnerNumberModel(1, 1, (Comparable) null, 1));
        this.JSPNDias.setToolTipText("N° Días");
        this.JSPNDias.setBorder(BorderFactory.createTitledBorder((Border) null, "Días", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JCBKardex.setFont(new Font("Arial", 1, 12));
        this.JCBKardex.setText("Kardex por fecha final");
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(15, 15, 15).addComponent(this.JTFNoHistoria, -2, 103, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFNombre, -2, 323, -2).addGap(18, 18, 18).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JCHFiltroNoHistoria).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHFiltroDias)).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JCBKardex).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JCHFiltroDias1))).addGap(18, 18, 18).addComponent(this.JSPNDias).addGap(34, 34, 34)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCHFiltroNoHistoria).addComponent(this.JCHFiltroDias)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCHFiltroDias1).addComponent(this.JCBKardex))).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFNoHistoria, -2, 50, -2).addComponent(this.JTFNombre, -2, 50, -2)).addComponent(this.JSPNDias, -2, 50, -2)).addGap(0, 10, 32767)));
        this.JTBDetalle2.setFont(new Font("Arial", 1, 12));
        this.JTBDetalle2.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JSPDetalle2.setViewportView(this.JTBDetalle2);
        GroupLayout JPIncapacidadLayout = new GroupLayout(this.JPIncapacidad);
        this.JPIncapacidad.setLayout(JPIncapacidadLayout);
        JPIncapacidadLayout.setHorizontalGroup(JPIncapacidadLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIncapacidadLayout.createSequentialGroup().addContainerGap().addGroup(JPIncapacidadLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -1, -1, 32767).addComponent(this.JSPDetalle2)).addContainerGap()));
        JPIncapacidadLayout.setVerticalGroup(JPIncapacidadLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIncapacidadLayout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPDetalle2, -1, 232, 32767).addContainerGap()));
        this.JTPDatosC.addTab("INCAPACIDADES", this.JPIncapacidad);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPIFiltro, -1, -1, 32767).addComponent(this.JTPDatosC, -2, 937, -2)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIFiltro, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTPDatosC, -1, 404, 32767).addContainerGap()));
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
        if (!this.JTFRuta.getText().isEmpty()) {
            if (this.JCHIncapacidades.isSelected()) {
                if (this.JTBDetalle2.getRowCount() != -1) {
                    this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTBDetalle2, this.JTFRuta.getText(), getTitle());
                    return;
                } else {
                    JOptionPane.showInternalMessageDialog(this, "No existe información para exportar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    return;
                }
            }
            if (this.JTBDetalle.getRowCount() > -1) {
                mExportar();
                return;
            } else {
                JOptionPane.showInternalMessageDialog(this, "No existe información para exportar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                return;
            }
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un ruta valida", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        this.JTFRuta.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosing(InternalFrameEvent evt) {
        Principal.mLimpiarDatosP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNoHistoriaActionPerformed(ActionEvent evt) {
        mBuscarUsuario();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNoHistoriaFocusLost(FocusEvent evt) {
        mBuscarUsuario();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHFiltroNoHistoriaActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHIncapacidadesActionPerformed(ActionEvent evt) {
        if (this.JCHIncapacidades.isSelected()) {
            this.JTPDatosC.setSelectedIndex(2);
        } else {
            this.JTPDatosC.setSelectedIndex(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHFiltroActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHFiltroDiasActionPerformed(ActionEvent evt) {
    }

    private void mBuscarUsuario() {
        this.JTFNombre.setText("");
        try {
            String sql = "SELECT `NUsuario` FROM `persona` WHERE (`NoHistoria` ='" + this.JTFNoHistoria.getText() + "')";
            ResultSet xrs = this.xct.traerRs(sql);
            if (xrs.next()) {
                xrs.first();
                this.JTFNombre.setText(xrs.getString(1));
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFConsultarInforSo.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mNuevo() {
        this.JDFechaI.setDate(this.xmt.getFechaActual());
        this.JDFechaF.setDate(this.xmt.getFechaActual());
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
        this.JCBTipoEmpresa.removeAllItems();
        this.xidtipoempresa = this.xct.llenarCombo("SELECT Id, Nbre FROM g_tipoempresa WHERE (Estado =0) ORDER BY Nbre ASC", this.xidtipoempresa, this.JCBTipoEmpresa);
        this.JCBTipoEmpresa.setSelectedIndex(-1);
        this.xct.cerrarConexionBd();
        this.JCHFiltro.setSelected(false);
        this.JCHIncapacidades.setSelected(false);
        this.JCHFiltroDias.setSelected(false);
        this.JCHFiltroDias1.setSelected(false);
        mCrearTabla();
        mCrearTabla1();
        mCrearTabla2();
    }

    public final void mCrearTabla() {
        this.xmodelo = new DefaultTableModel((Object[][]) null, new String[]{"Fecha", "Hora", "Documento", "NHC", "Usuario", "Sexo", "Edad", "Especialidad", "Profesional", "Asistio"}) { // from class: Sig.JIFConsultarInforSo.10
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTBDetalle.setModel(this.xmodelo);
        this.JTBDetalle.getColumnModel().getColumn(0).setPreferredWidth(5);
        this.JTBDetalle.getColumnModel().getColumn(1).setPreferredWidth(5);
        this.JTBDetalle.getColumnModel().getColumn(2).setPreferredWidth(10);
        this.JTBDetalle.getColumnModel().getColumn(3).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(3).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(3).setMaxWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(4).setPreferredWidth(200);
        this.JTBDetalle.getColumnModel().getColumn(5).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(5).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(5).setMaxWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(6).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(6).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(6).setMaxWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(7).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(7).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(7).setMaxWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(8).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(8).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(8).setMaxWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(9).setPreferredWidth(10);
    }

    public final void mCrearTabla1() {
        this.xmodelo1 = new DefaultTableModel((Object[][]) null, new String[]{"Fecha", "Hora", "Documento", "NHC", "Usuario", "Sexo", "Edad", "Especialidad", "Profesional", "Asistio"}) { // from class: Sig.JIFConsultarInforSo.11
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTBDetalle1.setModel(this.xmodelo1);
        this.JTBDetalle1.getColumnModel().getColumn(0).setPreferredWidth(5);
        this.JTBDetalle1.getColumnModel().getColumn(1).setPreferredWidth(5);
        this.JTBDetalle1.getColumnModel().getColumn(2).setPreferredWidth(10);
        this.JTBDetalle1.getColumnModel().getColumn(3).setPreferredWidth(0);
        this.JTBDetalle1.getColumnModel().getColumn(3).setMinWidth(0);
        this.JTBDetalle1.getColumnModel().getColumn(3).setMaxWidth(0);
        this.JTBDetalle1.getColumnModel().getColumn(4).setPreferredWidth(200);
        this.JTBDetalle1.getColumnModel().getColumn(5).setPreferredWidth(0);
        this.JTBDetalle1.getColumnModel().getColumn(5).setMinWidth(0);
        this.JTBDetalle1.getColumnModel().getColumn(5).setMaxWidth(0);
        this.JTBDetalle1.getColumnModel().getColumn(6).setPreferredWidth(0);
        this.JTBDetalle1.getColumnModel().getColumn(6).setMinWidth(0);
        this.JTBDetalle1.getColumnModel().getColumn(6).setMaxWidth(0);
        this.JTBDetalle1.getColumnModel().getColumn(7).setPreferredWidth(0);
        this.JTBDetalle1.getColumnModel().getColumn(7).setMinWidth(0);
        this.JTBDetalle1.getColumnModel().getColumn(7).setMaxWidth(0);
        this.JTBDetalle1.getColumnModel().getColumn(8).setPreferredWidth(0);
        this.JTBDetalle1.getColumnModel().getColumn(8).setMinWidth(0);
        this.JTBDetalle1.getColumnModel().getColumn(8).setMaxWidth(0);
        this.JTBDetalle1.getColumnModel().getColumn(9).setPreferredWidth(10);
    }

    public final void mCrearTabla2() {
        this.xmodelo4 = new DefaultTableModel((Object[][]) null, new String[]{"Id", "NHC", "TDoc", "Documento", "Usuario", "Fecha Inicio", "Fecha Fin", "NDías", "Prorroga?", "Motivo", "Justificación", "Cie10", "NPatología", "Profesional", "UN", "Fecha Atención", "Código 1Sap", "Eps", "Tipo Incapacidad", "Especialidad", "Fecha Ingreso", "Sexo", "Observacion"}) { // from class: Sig.JIFConsultarInforSo.12
            Class[] types = {Long.class, String.class, String.class, String.class, String.class, String.class, String.class, Long.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

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
        this.JTBDetalle2.setModel(this.xmodelo4);
        this.JTBDetalle2.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTBDetalle2.getColumnModel().getColumn(1).setPreferredWidth(120);
        this.JTBDetalle2.getColumnModel().getColumn(2).setPreferredWidth(80);
        this.JTBDetalle2.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTBDetalle2.getColumnModel().getColumn(4).setPreferredWidth(200);
        this.JTBDetalle2.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTBDetalle2.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTBDetalle2.getColumnModel().getColumn(7).setPreferredWidth(80);
        this.JTBDetalle2.getColumnModel().getColumn(8).setPreferredWidth(80);
        this.JTBDetalle2.getColumnModel().getColumn(9).setPreferredWidth(200);
        this.JTBDetalle2.getColumnModel().getColumn(10).setPreferredWidth(200);
        this.JTBDetalle2.getColumnModel().getColumn(11).setPreferredWidth(80);
        this.JTBDetalle2.getColumnModel().getColumn(12).setPreferredWidth(200);
        this.JTBDetalle2.getColumnModel().getColumn(13).setPreferredWidth(200);
        this.JTBDetalle2.getColumnModel().getColumn(14).setPreferredWidth(100);
        this.JTBDetalle2.getColumnModel().getColumn(15).setPreferredWidth(80);
        this.JTBDetalle2.getColumnModel().getColumn(16).setPreferredWidth(100);
        this.JTBDetalle2.getColumnModel().getColumn(17).setPreferredWidth(200);
        this.JTBDetalle2.getColumnModel().getColumn(18).setPreferredWidth(150);
        this.JTBDetalle2.getColumnModel().getColumn(19).setPreferredWidth(200);
        this.JTBDetalle2.getColumnModel().getColumn(20).setPreferredWidth(80);
        this.JTBDetalle2.getColumnModel().getColumn(21).setPreferredWidth(80);
        this.JTBDetalle2.getColumnModel().getColumn(22).setPreferredWidth(200);
    }

    public final void mCrearTabla_IncapacidadD() {
        this.xmodelo2 = new DefaultTableModel((Object[][]) null, new String[]{"Documento", "Usuario", "Sexo", "Edad", "Días", "Cie10", "Patología", "Fecha_Inicio", "Fecha_Fin", "#Seg", "Unidad Negocio", "Fecha Ingreso"}) { // from class: Sig.JIFConsultarInforSo.13
            Class[] types = {String.class, String.class, String.class, String.class, Long.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false};

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
        this.JTBDetalle2.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTBDetalle2.getColumnModel().getColumn(1).setPreferredWidth(300);
        this.JTBDetalle2.getColumnModel().getColumn(2).setPreferredWidth(80);
        this.JTBDetalle2.getColumnModel().getColumn(3).setPreferredWidth(80);
        this.JTBDetalle2.getColumnModel().getColumn(4).setPreferredWidth(80);
        this.JTBDetalle2.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTBDetalle2.getColumnModel().getColumn(6).setPreferredWidth(200);
        this.JTBDetalle2.getColumnModel().getColumn(7).setPreferredWidth(100);
        this.JTBDetalle2.getColumnModel().getColumn(8).setPreferredWidth(100);
        this.JTBDetalle2.getColumnModel().getColumn(9).setPreferredWidth(100);
        this.JTBDetalle2.getColumnModel().getColumn(10).setPreferredWidth(200);
        this.JTBDetalle2.getColumnModel().getColumn(11).setPreferredWidth(80);
    }

    private void mCargarDatosTabla() {
        String sql;
        try {
            mCrearTabla();
            if (this.JCHFiltro.isSelected()) {
                sql = "SELECT\n\tcc.Fecha_Cita,\n\tcc.HoraInicial,\n\tCONCAT(gp.Id_TipoIdentificacion, '-', gp.NoDocumento) as Documento,\n\tgu.NoHistoria,\n\tCONCAT(gp.Apellido1, ' ', gp.Apellido2, ' ', gp.Nombre1, ' ', gp.Nombre2) AS NUsuario,\n\tgp.Id_Sexo as IdSexo,\n\tCONCAT(gp.Edad, ' ', gt.Nbre) as Edad,\n\tge.Nbre as Especialidad,\n\tCONCAT(gp3.Apellido1, ' ', gp3.Apellido2, ' ', gp3.Nombre1, ' ', gp3.Nombre2) AS NProfesional,\n\tif(cc.Asistida = 0,'NO','SI') as Asistido\nFROM\n\tg_persona gp\ninner join g_usuario gu on\n\t(gu.Id_persona = gp.Id)\ninner join g_tipoedad gt on\n\t(gt.Id = gp.Id_TipoEdad)\ninner join c_citas cc on\n\t(gp.Id = cc.Id_Usuario)\ninner join g_profesionalespecial gp2 on\n\t(gp2.Id_Profesional = cc.Id_Profesional)\n\tAND (gp2.Id_Especialidad = cc.Id_Especialidad)\nINNER JOIN g_persona gp3 on\n\t(gp3.Id = gp2.Id_Profesional)\nINNER JOIN g_especialidad ge on\n\t(ge.Id = gp2.Id_Especialidad)\ninner join g_usuario_fpz guf on\n\t(guf.Id_Persona = gp.Id)\nWHERE\n\t(cc.So = 1\n\t\tAND guf.Id_Empresa = '" + this.xidtipoempresa[this.JCBTipoEmpresa.getSelectedIndex()] + "'\n\t\tAND cc.Fecha_Cita BETWEEN '" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND '" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "'\n)\nORDER BY\n\tcc.Fecha_Cita ASC,\n\tCONCAT(gp.Apellido1, ' ', gp.Apellido2, ' ', gp.Nombre1, ' ', gp.Nombre2) ASC;";
            } else {
                sql = "SELECT\n\tcc.Fecha_Cita,\n\tcc.HoraInicial,\n\tCONCAT(gp.Id_TipoIdentificacion, '-', gp.NoDocumento) as Documento,\n\tgu.NoHistoria,\n\tCONCAT(gp.Apellido1, ' ', gp.Apellido2, ' ', gp.Nombre1, ' ', gp.Nombre2) AS NUsuario,\n\tgp.Id_Sexo as IdSexo,\n\tCONCAT(gp.Edad, ' ', gt.Nbre) as Edad,\n\tge.Nbre as Especialidad,\n\tCONCAT(gp3.Apellido1, ' ', gp3.Apellido2, ' ', gp3.Nombre1, ' ', gp3.Nombre2) AS NProfesional,\n\tif(cc.Asistida = 0,'NO','SI') as Asistido\nFROM\n\tg_persona gp\ninner join g_usuario gu on\n\t(gu.Id_persona = gp.Id)\ninner join g_tipoedad gt on\n\t(gt.Id = gp.Id_TipoEdad)\ninner join c_citas cc on\n\t(gp.Id = cc.Id_Usuario)\ninner join g_profesionalespecial gp2 on\n\t(gp2.Id_Profesional = cc.Id_Profesional)\n\tAND (gp2.Id_Especialidad = cc.Id_Especialidad)\nINNER JOIN g_persona gp3 on\n\t(gp3.Id = gp2.Id_Profesional)\nINNER JOIN g_especialidad ge on\n\t(ge.Id = gp2.Id_Especialidad)\ninner join g_usuario_fpz guf on\n\t(guf.Id_Persona = gp.Id)\nWHERE\n\t(cc.So = 1\n\t\tAND cc.Fecha_Cita BETWEEN '" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND '" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "'\n)\nORDER BY\n\tcc.Fecha_Cita ASC,\n\tCONCAT(gp.Apellido1, ' ', gp.Apellido2, ' ', gp.Nombre1, ' ', gp.Nombre2) ASC;";
            }
            System.out.println("Uno   " + sql);
            ResultSet rs = this.xct.traerRs(sql);
            rs.next();
            if (rs.getRow() != 0) {
                rs.beforeFirst();
                int i = 0;
                while (rs.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(rs.getString(1), i, 0);
                    this.xmodelo.setValueAt(rs.getString(2), i, 1);
                    this.xmodelo.setValueAt(rs.getString(3), i, 2);
                    this.xmodelo.setValueAt(rs.getString(4), i, 3);
                    this.xmodelo.setValueAt(rs.getString(5), i, 4);
                    this.xmodelo.setValueAt(rs.getString(6), i, 5);
                    this.xmodelo.setValueAt(rs.getString(7), i, 6);
                    this.xmodelo.setValueAt(rs.getString(8), i, 7);
                    this.xmodelo.setValueAt(rs.getString(9), i, 8);
                    this.xmodelo.setValueAt(rs.getString(10), i, 9);
                    i++;
                }
            }
            rs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFConsultarInforSo.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarDatosTabla1() {
        String sql;
        try {
            mCrearTabla1();
            if (this.JCHFiltro.isSelected()) {
                sql = "SELECT\n\tcc.Fecha_Cita,\n\tcc.HoraInicial,\n\tCONCAT(gp.Id_TipoIdentificacion, '-', gp.NoDocumento) as Documento,\n\tgu.NoHistoria,\n\tCONCAT(gp.Apellido1, ' ', gp.Apellido2, ' ', gp.Nombre1, ' ', gp.Nombre2) AS NUsuario,\n\tgp.Id_Sexo as IdSexo,\n\tCONCAT(gp.Edad, ' ', gt.Nbre) as Edad,\n\tge.Nbre as Especialidad,\n\tCONCAT(gp3.Apellido1, ' ', gp3.Apellido2, ' ', gp3.Nombre1, ' ', gp3.Nombre2) AS NProfesional,\n\tif(cc.Asistida = 0,'NO','SI') as Asistido\nFROM\n\tg_persona gp\ninner join g_usuario gu on\n\t(gu.Id_persona = gp.Id)\ninner join g_tipoedad gt on\n\t(gt.Id = gp.Id_TipoEdad)\ninner join c_citasnp cc on\n\t(gp.Id = cc.Id_Usuario)\ninner join g_profesionalespecial gp2 on\n\t(gp2.Id_Profesional = cc.Id_Profesional)\n\tAND (gp2.Id_Especialidad = cc.Id_Especialidad)\nINNER JOIN g_persona gp3 on\n\t(gp3.Id = gp2.Id_Profesional)\nINNER JOIN g_especialidad ge on\n\t(ge.Id = gp2.Id_Especialidad)\ninner join g_usuario_fpz guf on\n\t(guf.Id_Persona = gp.Id)\nWHERE\n\t(cc.So = 1\n\t\tAND guf.Id_Empresa = '" + this.xidtipoempresa[this.JCBTipoEmpresa.getSelectedIndex()] + "'\n\t\tAND cc.Fecha_Cita BETWEEN '" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND '" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "'\n)\nORDER BY\n\tcc.Fecha_Cita ASC,\n\tCONCAT(gp.Apellido1, ' ', gp.Apellido2, ' ', gp.Nombre1, ' ', gp.Nombre2) ASC;";
            } else {
                sql = "SELECT\n\tcc.Fecha_Cita,\n\tcc.HoraInicial,\n\tCONCAT(gp.Id_TipoIdentificacion, '-', gp.NoDocumento) as Documento,\n\tgu.NoHistoria,\n\tCONCAT(gp.Apellido1, ' ', gp.Apellido2, ' ', gp.Nombre1, ' ', gp.Nombre2) AS NUsuario,\n\tgp.Id_Sexo as IdSexo,\n\tCONCAT(gp.Edad, ' ', gt.Nbre) as Edad,\n\tge.Nbre as Especialidad,\n\tCONCAT(gp3.Apellido1, ' ', gp3.Apellido2, ' ', gp3.Nombre1, ' ', gp3.Nombre2) AS NProfesional,\n\tif(cc.Asistida = 0,'NO','SI') as Asistido\nFROM\n\tg_persona gp\ninner join g_usuario gu on\n\t(gu.Id_persona = gp.Id)\ninner join g_tipoedad gt on\n\t(gt.Id = gp.Id_TipoEdad)\ninner join c_citasnp cc on\n\t(gp.Id = cc.Id_Usuario)\ninner join g_profesionalespecial gp2 on\n\t(gp2.Id_Profesional = cc.Id_Profesional)\n\tAND (gp2.Id_Especialidad = cc.Id_Especialidad)\nINNER JOIN g_persona gp3 on\n\t(gp3.Id = gp2.Id_Profesional)\nINNER JOIN g_especialidad ge on\n\t(ge.Id = gp2.Id_Especialidad)\ninner join g_usuario_fpz guf on\n\t(guf.Id_Persona = gp.Id)\nWHERE\n\t(cc.So = 1\n\t\tAND cc.Fecha_Cita BETWEEN '" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND '" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "'\n)\nORDER BY\n\tcc.Fecha_Cita ASC,\n\tCONCAT(gp.Apellido1, ' ', gp.Apellido2, ' ', gp.Nombre1, ' ', gp.Nombre2) ASC;";
            }
            System.out.println("Uno   " + sql);
            ResultSet rs = this.xct.traerRs(sql);
            rs.next();
            if (rs.getRow() != 0) {
                rs.beforeFirst();
                int i = 0;
                while (rs.next()) {
                    this.xmodelo1.addRow(this.xdato);
                    this.xmodelo1.setValueAt(rs.getString(1), i, 0);
                    this.xmodelo1.setValueAt(rs.getString(2), i, 1);
                    this.xmodelo1.setValueAt(rs.getString(3), i, 2);
                    this.xmodelo1.setValueAt(rs.getString(4), i, 3);
                    this.xmodelo1.setValueAt(rs.getString(5), i, 4);
                    this.xmodelo1.setValueAt(rs.getString(6), i, 5);
                    this.xmodelo1.setValueAt(rs.getString(7), i, 6);
                    this.xmodelo1.setValueAt(rs.getString(8), i, 7);
                    this.xmodelo1.setValueAt(rs.getString(9), i, 8);
                    this.xmodelo1.setValueAt(rs.getString(10), i, 9);
                    i++;
                }
            }
            rs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFConsultarInforSo.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarDatosTabla2() {
        try {
            mCrearTabla2();
            if (this.JCHFiltro.isSelected()) {
                if (this.JCHFiltroNoHistoria.isSelected()) {
                    this.xsql = "SELECT\n    `h_incapacidad`.`Id`\n    , `g_usuario`.`NoHistoria`\n    , `g_persona`.`Id_TipoIdentificacion`\n    , `g_persona`.`NoDocumento`\n    , CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2`,' ',`g_persona`.`Nombre1`,' ', `g_persona`.`Nombre2`) AS `NUsuario`\n    , `h_incapacidad`.`FechaInicio`\n    , `h_incapacidad`.`FechaFin`\n    , `h_incapacidad`.`NDias`\n    , IF(`h_incapacidad`.`EsProrroga`=1, 'SI', 'NO') AS `EsProrroga`\n    , UCASE(`h_tipomotivoincap`.`Nbre`) AS `Motivo`\n    , UCASE(`h_tipojustificacionincap`.`Nbre`) AS `Justificacion`\n    , `h_incapacidad`.`Id_Patologia`\n    , `g_patologia`.`Nbre` Npatologia\n    , concat(`profesional`.`Apellido1`,' ',`profesional`.`Apellido2`,' ',`profesional`.`Nombre1`,' ',`profesional`.`Nombre2`) AS `NProfesional`\n    , `g_tipounidadnegocio`.`Nbre` UnidadNegocio\n    , DATE_FORMAT(`h_incapacidad`.`Fecha`, '%Y-%m-%d') AS `FechaAtencion`\n    , `g_persona`.`Codigo1Sap`\n    , if(`g_empresa`.`Id_TipoIdentificacion` = 'NI',`g_empresa`.`Nbre`,concat(`g_empresa`.`Apellido1`,' ',`g_empresa`.`Apellido2`,' ',`g_empresa`.`Nombre1`,' ',`g_empresa`.`Nombre2`)) AS `Empresa`\n    , IF(`h_incapacidad`.`TipoIncapacidad`=0,'AMBULATORIO', 'HOSPITALIZACIÓN') AS `TipoIncapacidad`\n    , `g_especialidad`.`Nbre` as Especialidad\n    , `g_usuario`.`FechaIngreso`\n    , `g_sexo`.`Nbre` NSexo\n    , `h_incapacidad`.`Observacion`\nFROM\n     `g_usuario`\n    INNER JOIN  `h_incapacidad` \n        ON (`g_usuario`.`Id_persona` = `h_incapacidad`.`Id_Usuario`)\n    INNER JOIN  `h_tipojustificacionincap` \n        ON (`h_incapacidad`.`IdTipoJustificacion` = `h_tipojustificacionincap`.`Id`)\n    INNER JOIN  `h_tipomotivoincap` \n        ON (`h_incapacidad`.`Id_MotivoIncap` = `h_tipomotivoincap`.`Id`)\n    INNER JOIN  `g_patologia` \n        ON (`h_incapacidad`.`Id_Patologia` = `g_patologia`.`Id`)\n    INNER JOIN  `g_persona` \n        ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)\n    INNER JOIN  `g_sexo` \n        ON (`g_persona`.`Id_Sexo` = `g_sexo`.`Id`)\n    INNER JOIN  `g_usuario_fpz` \n        ON (`g_usuario_fpz`.`Id_Persona` = `g_persona`.`Id`)\n    INNER JOIN  `g_profesionalespecial`\n        ON (`g_profesionalespecial`.`Id_Profesional` = `h_incapacidad`.`Id_Profesional`) AND (`g_profesionalespecial`.`Id_Especialidad` = `h_incapacidad`.`Id_Especialidad`)\n    inner join `g_persona` as profesional \n        ON (profesional.`Id`= g_profesionalespecial.`Id_Profesional`)\n    inner join `g_especialidad` \n        ON (`g_especialidad`.`Id`=`g_profesionalespecial`.`Id_Especialidad`)\t\n    INNER JOIN  `g_tipounidadnegocio` \n        ON (`h_incapacidad`.`Id_TipoUnidadNegocio` = `g_tipounidadnegocio`.`Id`)\n    INNER JOIN  `g_empresa` \n        ON (`g_empresa`.`Id` = `h_incapacidad`.`Id_EmpresaCont`)\nWHERE (`g_usuario_fpz`.`Id_Empresa` ='" + this.xidtipoempresa[this.JCBTipoEmpresa.getSelectedIndex()] + "'\n    AND DATE_FORMAT(`h_incapacidad`.`Fecha`, '%Y-%m-%d') >='" + this.xmt.formatoAMD1.format(this.JDFechaI.getDate()) + "'\n    AND DATE_FORMAT(`h_incapacidad`.`Fecha`, '%Y-%m-%d') <='" + this.xmt.formatoAMD1.format(this.JDFechaF.getDate()) + "'\n    AND `g_usuario`.`NoHistoria`='" + this.JTFNoHistoria.getText() + "'\n    AND `h_incapacidad`.`Estado` =0)\nORDER BY `h_incapacidad`.`Fecha` ASC";
                } else if (this.JCBKardex.isSelected()) {
                    this.xsql = "SELECT\n    `h_incapacidad`.`Id`\n    , `g_usuario`.`NoHistoria`\n    , `g_persona`.`Id_TipoIdentificacion`\n    , `g_persona`.`NoDocumento`\n    , CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2`,' ',`g_persona`.`Nombre1`,' ', `g_persona`.`Nombre2`) AS `NUsuario`\n    , `h_incapacidad`.`FechaInicio`\n    , `h_incapacidad`.`FechaFin`\n    , `h_incapacidad`.`NDias`\n    , IF(`h_incapacidad`.`EsProrroga`=1, 'SI', 'NO') AS `EsProrroga`\n    , UCASE(`h_tipomotivoincap`.`Nbre`) AS `Motivo`\n    , UCASE(`h_tipojustificacionincap`.`Nbre`) AS `Justificacion`\n    , `h_incapacidad`.`Id_Patologia`\n    , `g_patologia`.`Nbre` Npatologia\n    , concat(`profesional`.`Apellido1`,' ',`profesional`.`Apellido2`,' ',`profesional`.`Nombre1`,' ',`profesional`.`Nombre2`) AS `NProfesional`\n    , `g_tipounidadnegocio`.`Nbre` UnidadNegocio\n    , DATE_FORMAT(`h_incapacidad`.`Fecha`, '%Y-%m-%d') AS `FechaAtencion`\n    , `g_persona`.`Codigo1Sap`\n    , if(`g_empresa`.`Id_TipoIdentificacion` = 'NI',`g_empresa`.`Nbre`,concat(`g_empresa`.`Apellido1`,' ',`g_empresa`.`Apellido2`,' ',`g_empresa`.`Nombre1`,' ',`g_empresa`.`Nombre2`)) AS `Empresa`\n    , IF(`h_incapacidad`.`TipoIncapacidad`=0,'AMBULATORIO', 'HOSPITALIZACIÓN') AS `TipoIncapacidad`\n    , `g_especialidad`.`Nbre` as Especialidad\n    , `g_usuario`.`FechaIngreso`\n    , `g_sexo`.`Nbre` NSexo\n    , `h_incapacidad`.`Observacion`\nFROM\n     `g_usuario`\n    INNER JOIN  `h_incapacidad` \n        ON (`g_usuario`.`Id_persona` = `h_incapacidad`.`Id_Usuario`)\n    INNER JOIN  `h_tipojustificacionincap` \n        ON (`h_incapacidad`.`IdTipoJustificacion` = `h_tipojustificacionincap`.`Id`)\n    INNER JOIN  `h_tipomotivoincap` \n        ON (`h_incapacidad`.`Id_MotivoIncap` = `h_tipomotivoincap`.`Id`)\n    INNER JOIN  `g_patologia` \n        ON (`h_incapacidad`.`Id_Patologia` = `g_patologia`.`Id`)\n    INNER JOIN  `g_persona` \n        ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)\n    INNER JOIN  `g_sexo` \n        ON (`g_persona`.`Id_Sexo` = `g_sexo`.`Id`)\n    INNER JOIN  `g_usuario_fpz` \n        ON (`g_usuario_fpz`.`Id_Persona` = `g_persona`.`Id`)\n    INNER JOIN  `g_profesionalespecial`\n        ON (`g_profesionalespecial`.`Id_Profesional` = `h_incapacidad`.`Id_Profesional`) AND (`g_profesionalespecial`.`Id_Especialidad` = `h_incapacidad`.`Id_Especialidad`)\n    inner join `g_persona` as profesional \n        ON (profesional.`Id`= g_profesionalespecial.`Id_Profesional`)\n    inner join `g_especialidad` \n        ON (`g_especialidad`.`Id`=`g_profesionalespecial`.`Id_Especialidad`)\t\n    INNER JOIN  `g_tipounidadnegocio` \n        ON (`h_incapacidad`.`Id_TipoUnidadNegocio` = `g_tipounidadnegocio`.`Id`)\n    INNER JOIN  `g_empresa` \n        ON (`g_empresa`.`Id` = `h_incapacidad`.`Id_EmpresaCont`)\nWHERE (`g_usuario_fpz`.`Id_Empresa` ='" + this.xidtipoempresa[this.JCBTipoEmpresa.getSelectedIndex()] + "'\n    AND DATE_FORMAT(`h_incapacidad`.`Fecha`, '%Y-%m-%d') >='" + this.xmt.formatoAMD1.format(this.JDFechaF.getDate()) + "'\n    AND `h_incapacidad`.`Estado` =0)\nORDER BY `h_incapacidad`.`Fecha` ASC";
                } else {
                    this.xsql = "SELECT\n    `h_incapacidad`.`Id`\n    , `g_usuario`.`NoHistoria`\n    , `g_persona`.`Id_TipoIdentificacion`\n    , `g_persona`.`NoDocumento`\n    , CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2`,' ',`g_persona`.`Nombre1`,' ', `g_persona`.`Nombre2`) AS `NUsuario`\n    , `h_incapacidad`.`FechaInicio`\n    , `h_incapacidad`.`FechaFin`\n    , `h_incapacidad`.`NDias`\n    , IF(`h_incapacidad`.`EsProrroga`=1, 'SI', 'NO') AS `EsProrroga`\n    , UCASE(`h_tipomotivoincap`.`Nbre`) AS `Motivo`\n    , UCASE(`h_tipojustificacionincap`.`Nbre`) AS `Justificacion`\n    , `h_incapacidad`.`Id_Patologia`\n    , `g_patologia`.`Nbre` Npatologia\n    , concat(`profesional`.`Apellido1`,' ',`profesional`.`Apellido2`,' ',`profesional`.`Nombre1`,' ',`profesional`.`Nombre2`) AS `NProfesional`\n    , `g_tipounidadnegocio`.`Nbre` UnidadNegocio\n    , DATE_FORMAT(`h_incapacidad`.`Fecha`, '%Y-%m-%d') AS `FechaAtencion`\n    , `g_persona`.`Codigo1Sap`\n    , if(`g_empresa`.`Id_TipoIdentificacion` = 'NI',`g_empresa`.`Nbre`,concat(`g_empresa`.`Apellido1`,' ',`g_empresa`.`Apellido2`,' ',`g_empresa`.`Nombre1`,' ',`g_empresa`.`Nombre2`)) AS `Empresa`\n    , IF(`h_incapacidad`.`TipoIncapacidad`=0,'AMBULATORIO', 'HOSPITALIZACIÓN') AS `TipoIncapacidad`\n    , `g_especialidad`.`Nbre` as Especialidad\n    , `g_usuario`.`FechaIngreso`\n    , `g_sexo`.`Nbre` NSexo\n    , `h_incapacidad`.`Observacion`\nFROM\n     `g_usuario`\n    INNER JOIN  `h_incapacidad` \n        ON (`g_usuario`.`Id_persona` = `h_incapacidad`.`Id_Usuario`)\n    INNER JOIN  `h_tipojustificacionincap` \n        ON (`h_incapacidad`.`IdTipoJustificacion` = `h_tipojustificacionincap`.`Id`)\n    INNER JOIN  `h_tipomotivoincap` \n        ON (`h_incapacidad`.`Id_MotivoIncap` = `h_tipomotivoincap`.`Id`)\n    INNER JOIN  `g_patologia` \n        ON (`h_incapacidad`.`Id_Patologia` = `g_patologia`.`Id`)\n    INNER JOIN  `g_persona` \n        ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)\n    INNER JOIN  `g_sexo` \n        ON (`g_persona`.`Id_Sexo` = `g_sexo`.`Id`)\n    INNER JOIN  `g_usuario_fpz` \n        ON (`g_usuario_fpz`.`Id_Persona` = `g_persona`.`Id`)\n    INNER JOIN  `g_profesionalespecial`\n        ON (`g_profesionalespecial`.`Id_Profesional` = `h_incapacidad`.`Id_Profesional`) AND (`g_profesionalespecial`.`Id_Especialidad` = `h_incapacidad`.`Id_Especialidad`)\n    inner join `g_persona` as profesional \n        ON (profesional.`Id`= g_profesionalespecial.`Id_Profesional`)\n    inner join `g_especialidad` \n        ON (`g_especialidad`.`Id`=`g_profesionalespecial`.`Id_Especialidad`)\t\n    INNER JOIN  `g_tipounidadnegocio` \n        ON (`h_incapacidad`.`Id_TipoUnidadNegocio` = `g_tipounidadnegocio`.`Id`)\n    INNER JOIN  `g_empresa` \n        ON (`g_empresa`.`Id` = `h_incapacidad`.`Id_EmpresaCont`)\nWHERE (`g_usuario_fpz`.`Id_Empresa` ='" + this.xidtipoempresa[this.JCBTipoEmpresa.getSelectedIndex()] + "'\n    AND DATE_FORMAT(`h_incapacidad`.`Fecha`, '%Y-%m-%d') >='" + this.xmt.formatoAMD1.format(this.JDFechaI.getDate()) + "'\n    AND DATE_FORMAT(`h_incapacidad`.`Fecha`, '%Y-%m-%d') <='" + this.xmt.formatoAMD1.format(this.JDFechaF.getDate()) + "'\n    AND `h_incapacidad`.`Estado` =0)\nORDER BY `h_incapacidad`.`Fecha` ASC";
                }
            } else if (this.JCHFiltroNoHistoria.isSelected()) {
                this.xsql = "SELECT\n    `h_incapacidad`.`Id`\n    , `g_usuario`.`NoHistoria`\n    , `g_persona`.`Id_TipoIdentificacion`\n    , `g_persona`.`NoDocumento`\n    , CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2`,' ',`g_persona`.`Nombre1`,' ', `g_persona`.`Nombre2`) AS `NUsuario`\n    , `h_incapacidad`.`FechaInicio`\n    , `h_incapacidad`.`FechaFin`\n    , `h_incapacidad`.`NDias`\n    , IF(`h_incapacidad`.`EsProrroga`=1, 'SI', 'NO') AS `EsProrroga`\n    , UCASE(`h_tipomotivoincap`.`Nbre`) AS `Motivo`\n    , UCASE(`h_tipojustificacionincap`.`Nbre`) AS `Justificacion`\n    , `h_incapacidad`.`Id_Patologia`\n    , `g_patologia`.`Nbre` Npatologia\n    , concat(`profesional`.`Apellido1`,' ',`profesional`.`Apellido2`,' ',`profesional`.`Nombre1`,' ',`profesional`.`Nombre2`) AS `NProfesional`\n    , `g_tipounidadnegocio`.`Nbre` UnidadNegocio\n    , DATE_FORMAT(`h_incapacidad`.`Fecha`, '%Y-%m-%d') AS `FechaAtencion`\n    , `g_persona`.`Codigo1Sap`\n    , if(`g_empresa`.`Id_TipoIdentificacion` = 'NI',`g_empresa`.`Nbre`,concat(`g_empresa`.`Apellido1`,' ',`g_empresa`.`Apellido2`,' ',`g_empresa`.`Nombre1`,' ',`g_empresa`.`Nombre2`)) AS `Empresa`\n    , IF(`h_incapacidad`.`TipoIncapacidad`=0,'AMBULATORIO', 'HOSPITALIZACIÓN') AS `TipoIncapacidad`\n    , `g_especialidad`.`Nbre` as Especialidad\n    , `g_usuario`.`FechaIngreso`\n    , `g_sexo`.`Nbre` NSexo\n    , `h_incapacidad`.`Observacion`\nFROM\n     `g_usuario`\n    INNER JOIN  `h_incapacidad` \n        ON (`g_usuario`.`Id_persona` = `h_incapacidad`.`Id_Usuario`)\n    INNER JOIN  `h_tipojustificacionincap` \n        ON (`h_incapacidad`.`IdTipoJustificacion` = `h_tipojustificacionincap`.`Id`)\n    INNER JOIN  `h_tipomotivoincap` \n        ON (`h_incapacidad`.`Id_MotivoIncap` = `h_tipomotivoincap`.`Id`)\n    INNER JOIN  `g_patologia` \n        ON (`h_incapacidad`.`Id_Patologia` = `g_patologia`.`Id`)\n    INNER JOIN  `g_persona` \n        ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)\n    INNER JOIN  `g_sexo` \n        ON (`g_persona`.`Id_Sexo` = `g_sexo`.`Id`)\n    INNER JOIN  `g_usuario_fpz` \n        ON (`g_usuario_fpz`.`Id_Persona` = `g_persona`.`Id`)\n    INNER JOIN  `g_profesionalespecial`\n        ON (`g_profesionalespecial`.`Id_Profesional` = `h_incapacidad`.`Id_Profesional`) AND (`g_profesionalespecial`.`Id_Especialidad` = `h_incapacidad`.`Id_Especialidad`)\n    inner join `g_persona` as profesional \n        ON (profesional.`Id`= g_profesionalespecial.`Id_Profesional`)\n    inner join `g_especialidad` \n        ON (`g_especialidad`.`Id`=`g_profesionalespecial`.`Id_Especialidad`)\t\n    INNER JOIN  `g_tipounidadnegocio` \n        ON (`h_incapacidad`.`Id_TipoUnidadNegocio` = `g_tipounidadnegocio`.`Id`)\n    INNER JOIN  `g_empresa` \n        ON (`g_empresa`.`Id` = `h_incapacidad`.`Id_EmpresaCont`)\nWHERE (DATE_FORMAT(`h_incapacidad`.`Fecha`, '%Y-%m-%d') >='" + this.xmt.formatoAMD1.format(this.JDFechaI.getDate()) + "'\n    AND DATE_FORMAT(`h_incapacidad`.`Fecha`, '%Y-%m-%d') <='" + this.xmt.formatoAMD1.format(this.JDFechaF.getDate()) + "'\n    AND `g_usuario`.`NoHistoria`='" + this.JTFNoHistoria.getText() + "'\n    AND `h_incapacidad`.`Estado` =0)\nORDER BY `h_incapacidad`.`Fecha` ASC";
            } else if (this.JCBKardex.isSelected()) {
                this.xsql = "SELECT\n    `h_incapacidad`.`Id`\n    , `g_usuario`.`NoHistoria`\n    , `g_persona`.`Id_TipoIdentificacion`\n    , `g_persona`.`NoDocumento`\n    , CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2`,' ',`g_persona`.`Nombre1`,' ', `g_persona`.`Nombre2`) AS `NUsuario`\n    , `h_incapacidad`.`FechaInicio`\n    , `h_incapacidad`.`FechaFin`\n    , `h_incapacidad`.`NDias`\n    , IF(`h_incapacidad`.`EsProrroga`=1, 'SI', 'NO') AS `EsProrroga`\n    , UCASE(`h_tipomotivoincap`.`Nbre`) AS `Motivo`\n    , UCASE(`h_tipojustificacionincap`.`Nbre`) AS `Justificacion`\n    , `h_incapacidad`.`Id_Patologia`\n    , `g_patologia`.`Nbre` Npatologia\n    , concat(`profesional`.`Apellido1`,' ',`profesional`.`Apellido2`,' ',`profesional`.`Nombre1`,' ',`profesional`.`Nombre2`) AS `NProfesional`\n    , `g_tipounidadnegocio`.`Nbre` UnidadNegocio\n    , DATE_FORMAT(`h_incapacidad`.`Fecha`, '%Y-%m-%d') AS `FechaAtencion`\n    , `g_persona`.`Codigo1Sap`\n    , if(`g_empresa`.`Id_TipoIdentificacion` = 'NI',`g_empresa`.`Nbre`,concat(`g_empresa`.`Apellido1`,' ',`g_empresa`.`Apellido2`,' ',`g_empresa`.`Nombre1`,' ',`g_empresa`.`Nombre2`)) AS `Empresa`\n    , IF(`h_incapacidad`.`TipoIncapacidad`=0,'AMBULATORIO', 'HOSPITALIZACIÓN') AS `TipoIncapacidad`\n    , `g_especialidad`.`Nbre` as Especialidad\n    , `g_usuario`.`FechaIngreso`\n    , `g_sexo`.`Nbre` NSexo\n    , `h_incapacidad`.`Observacion`\nFROM\n     `g_usuario`\n    INNER JOIN  `h_incapacidad` \n        ON (`g_usuario`.`Id_persona` = `h_incapacidad`.`Id_Usuario`)\n    INNER JOIN  `h_tipojustificacionincap` \n        ON (`h_incapacidad`.`IdTipoJustificacion` = `h_tipojustificacionincap`.`Id`)\n    INNER JOIN  `h_tipomotivoincap` \n        ON (`h_incapacidad`.`Id_MotivoIncap` = `h_tipomotivoincap`.`Id`)\n    INNER JOIN  `g_patologia` \n        ON (`h_incapacidad`.`Id_Patologia` = `g_patologia`.`Id`)\n    INNER JOIN  `g_persona` \n        ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)\n    INNER JOIN  `g_sexo` \n        ON (`g_persona`.`Id_Sexo` = `g_sexo`.`Id`)\n    INNER JOIN  `g_usuario_fpz` \n        ON (`g_usuario_fpz`.`Id_Persona` = `g_persona`.`Id`)\n    INNER JOIN  `g_profesionalespecial`\n        ON (`g_profesionalespecial`.`Id_Profesional` = `h_incapacidad`.`Id_Profesional`) AND (`g_profesionalespecial`.`Id_Especialidad` = `h_incapacidad`.`Id_Especialidad`)\n    inner join `g_persona` as profesional \n        ON (profesional.`Id`= g_profesionalespecial.`Id_Profesional`)\n    inner join `g_especialidad` \n        ON (`g_especialidad`.`Id`=`g_profesionalespecial`.`Id_Especialidad`)\t\n    INNER JOIN  `g_tipounidadnegocio` \n        ON (`h_incapacidad`.`Id_TipoUnidadNegocio` = `g_tipounidadnegocio`.`Id`)\n    INNER JOIN  `g_empresa` \n        ON (`g_empresa`.`Id` = `h_incapacidad`.`Id_EmpresaCont`)\nWHERE (DATE_FORMAT(`h_incapacidad`.`Fecha`, '%Y-%m-%d') >='" + this.xmt.formatoAMD1.format(this.JDFechaF.getDate()) + "'\n    AND `h_incapacidad`.`Estado` =0)\nORDER BY `h_incapacidad`.`Fecha` ASC";
            } else {
                this.xsql = "SELECT\n    `h_incapacidad`.`Id`\n    , `g_usuario`.`NoHistoria`\n    , `g_persona`.`Id_TipoIdentificacion`\n    , `g_persona`.`NoDocumento`\n    , CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2`,' ',`g_persona`.`Nombre1`,' ', `g_persona`.`Nombre2`) AS `NUsuario`\n    , `h_incapacidad`.`FechaInicio`\n    , `h_incapacidad`.`FechaFin`\n    , `h_incapacidad`.`NDias`\n    , IF(`h_incapacidad`.`EsProrroga`=1, 'SI', 'NO') AS `EsProrroga`\n    , UCASE(`h_tipomotivoincap`.`Nbre`) AS `Motivo`\n    , UCASE(`h_tipojustificacionincap`.`Nbre`) AS `Justificacion`\n    , `h_incapacidad`.`Id_Patologia`\n    , `g_patologia`.`Nbre` Npatologia\n    , concat(`profesional`.`Apellido1`,' ',`profesional`.`Apellido2`,' ',`profesional`.`Nombre1`,' ',`profesional`.`Nombre2`) AS `NProfesional`\n    , `g_tipounidadnegocio`.`Nbre` UnidadNegocio\n    , DATE_FORMAT(`h_incapacidad`.`Fecha`, '%Y-%m-%d') AS `FechaAtencion`\n    , `g_persona`.`Codigo1Sap`\n    , if(`g_empresa`.`Id_TipoIdentificacion` = 'NI',`g_empresa`.`Nbre`,concat(`g_empresa`.`Apellido1`,' ',`g_empresa`.`Apellido2`,' ',`g_empresa`.`Nombre1`,' ',`g_empresa`.`Nombre2`)) AS `Empresa`\n    , IF(`h_incapacidad`.`TipoIncapacidad`=0,'AMBULATORIO', 'HOSPITALIZACIÓN') AS `TipoIncapacidad`\n    , `g_especialidad`.`Nbre` as Especialidad\n    , `g_usuario`.`FechaIngreso`\n    , `g_sexo`.`Nbre` NSexo\n    , `h_incapacidad`.`Observacion`\nFROM\n     `g_usuario`\n    INNER JOIN  `h_incapacidad` \n        ON (`g_usuario`.`Id_persona` = `h_incapacidad`.`Id_Usuario`)\n    INNER JOIN  `h_tipojustificacionincap` \n        ON (`h_incapacidad`.`IdTipoJustificacion` = `h_tipojustificacionincap`.`Id`)\n    INNER JOIN  `h_tipomotivoincap` \n        ON (`h_incapacidad`.`Id_MotivoIncap` = `h_tipomotivoincap`.`Id`)\n    INNER JOIN  `g_patologia` \n        ON (`h_incapacidad`.`Id_Patologia` = `g_patologia`.`Id`)\n    INNER JOIN  `g_persona` \n        ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)\n    INNER JOIN  `g_sexo` \n        ON (`g_persona`.`Id_Sexo` = `g_sexo`.`Id`)\n    INNER JOIN  `g_usuario_fpz` \n        ON (`g_usuario_fpz`.`Id_Persona` = `g_persona`.`Id`)\n    INNER JOIN  `g_profesionalespecial`\n        ON (`g_profesionalespecial`.`Id_Profesional` = `h_incapacidad`.`Id_Profesional`) AND (`g_profesionalespecial`.`Id_Especialidad` = `h_incapacidad`.`Id_Especialidad`)\n    inner join `g_persona` as profesional \n        ON (profesional.`Id`= g_profesionalespecial.`Id_Profesional`)\n    inner join `g_especialidad` \n        ON (`g_especialidad`.`Id`=`g_profesionalespecial`.`Id_Especialidad`)\t\n    INNER JOIN  `g_tipounidadnegocio` \n        ON (`h_incapacidad`.`Id_TipoUnidadNegocio` = `g_tipounidadnegocio`.`Id`)\n    INNER JOIN  `g_empresa` \n        ON (`g_empresa`.`Id` = `h_incapacidad`.`Id_EmpresaCont`)\nWHERE (DATE_FORMAT(`h_incapacidad`.`Fecha`, '%Y-%m-%d') >='" + this.xmt.formatoAMD1.format(this.JDFechaI.getDate()) + "'\n    AND DATE_FORMAT(`h_incapacidad`.`Fecha`, '%Y-%m-%d') <='" + this.xmt.formatoAMD1.format(this.JDFechaF.getDate()) + "'\n    AND `h_incapacidad`.`Estado` =0)\nORDER BY `h_incapacidad`.`Fecha` ASC";
            }
            System.out.println("Uno   " + this.xsql);
            ResultSet rs = this.xct.traerRs(this.xsql);
            rs.next();
            if (rs.getRow() != 0) {
                rs.beforeFirst();
                int i = 0;
                while (rs.next()) {
                    this.xmodelo4.addRow(this.xdato);
                    this.xmodelo4.setValueAt(Long.valueOf(rs.getLong("Id")), i, 0);
                    this.xmodelo4.setValueAt(rs.getString("NoHistoria"), i, 1);
                    this.xmodelo4.setValueAt(rs.getString("Id_TipoIdentificacion"), i, 2);
                    this.xmodelo4.setValueAt(rs.getString("NoDocumento"), i, 3);
                    this.xmodelo4.setValueAt(rs.getString("NUsuario"), i, 4);
                    this.xmodelo4.setValueAt(rs.getString("FechaInicio"), i, 5);
                    this.xmodelo4.setValueAt(rs.getString("FechaFin"), i, 6);
                    this.xmodelo4.setValueAt(Long.valueOf(rs.getLong("NDias")), i, 7);
                    this.xmodelo4.setValueAt(rs.getString("EsProrroga"), i, 8);
                    this.xmodelo4.setValueAt(rs.getString("Motivo"), i, 9);
                    this.xmodelo4.setValueAt(rs.getString("Justificacion"), i, 10);
                    this.xmodelo4.setValueAt(rs.getString("Id_Patologia"), i, 11);
                    this.xmodelo4.setValueAt(rs.getString("Npatologia"), i, 12);
                    this.xmodelo4.setValueAt(rs.getString("NProfesional"), i, 13);
                    this.xmodelo4.setValueAt(rs.getString("UnidadNegocio"), i, 14);
                    this.xmodelo4.setValueAt(rs.getString("FechaAtencion"), i, 15);
                    this.xmodelo4.setValueAt(rs.getString("Codigo1Sap"), i, 16);
                    this.xmodelo4.setValueAt(rs.getString("Empresa"), i, 17);
                    this.xmodelo4.setValueAt(rs.getString("TipoIncapacidad"), i, 18);
                    this.xmodelo4.setValueAt(rs.getString("Especialidad"), i, 19);
                    this.xmodelo4.setValueAt(rs.getString("FechaIngreso"), i, 20);
                    this.xmodelo4.setValueAt(rs.getString("NSexo"), i, 21);
                    this.xmodelo4.setValueAt(rs.getString("Observacion"), i, 22);
                    i++;
                }
            }
            rs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFConsultarInforSo.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarDatosTabla3() {
        String sql;
        try {
            mCrearTabla_IncapacidadD();
            if (this.JCHFiltro.isSelected()) {
                if (!this.JCHFiltroDias.isSelected() && this.JCHFiltroDias1.isSelected()) {
                    sql = "SELECT\n\tgp.NoDocumento,\n\tCONCAT(gp.Apellido1, ' ', gp.Apellido2, ' ', gp.Nombre1, ' ', gp.Nombre2) AS NUsuario,\n\tgs.Nbre as NSexo,\n\tCONCAT(gp.Edad, ' ', gt2.Nbre) AS Edad ,\n\tSUM(hi.NDias) as NDias,\n\thi.Id_Patologia,\n\tgp2.Nbre as nPatologia,\n\tguf.Id_Persona,\n\tsts.Nbre as tipoSegmento,\n\tgt.Nbre as tipoUnidaNegocio,\n\tif(gu.FechaIngreso is null,\n\t'',\n\tdate_format(gu.FechaIngreso, '%d-%m-%Y')) AS `FechaIngreso`\nFROM\n\tg_usuario_fpz guf\ninner join g_usuario gu on\n\t(gu.Id_persona = guf.Id_Persona)\nINNER join g_persona gp on\n\t(gp.Id = gu.Id_persona)\ninner join g_sexo gs on\n\t(gs.Id = gp.Id_Sexo)\ninner join g_tipoedad gt2 on\n\t(gt2.Id = gp.Id_TipoEdad)\ninner join h_incapacidad hi on\n\t(hi.Id_Usuario = guf.Id_Persona)\ninner join g_patologia gp2 on\n\t(gp2.Id = hi.Id_Patologia)\ninner JOIN so_tipo_segmento sts on\n\t(sts.Id = gu.Id_Segmento)\ninner join g_tipounidadnegocio gt on\n\t(gt.Id = guf.Id_UnidadN)\nWHERE\n\t(\nhi.Id_TipoEmpresa = '" + this.xidtipoempresa[this.JCBTipoEmpresa.getSelectedIndex()] + "'\n\t\tAND hi.Estado = 0\n)\nGROUP BY\n\tguf.Id_Persona,\n\thi.Id_Patologia\nHAVING\n\t(NDias <= " + this.JSPNDias.getValue() + ")\nORDER BY\n\tNDias DESC,\n\tCONCAT(gp.Apellido1, ' ', gp.Apellido2, ' ', gp.Nombre1, ' ', gp.Nombre2) ASC,\n\tguf.Id_Persona ASC;";
                } else {
                    sql = "SELECT\n\tgp.NoDocumento,\n\tCONCAT(gp.Apellido1, ' ', gp.Apellido2, ' ', gp.Nombre1, ' ', gp.Nombre2) AS NUsuario,\n\tgs.Nbre as NSexo,\n\tCONCAT(gp.Edad, ' ', gt2.Nbre) AS Edad ,\n\tSUM(hi.NDias) as NDias,\n\thi.Id_Patologia,\n\tgp2.Nbre as nPatologia,\n\tguf.Id_Persona,\n\tsts.Nbre as tipoSegmento,\n\tgt.Nbre as tipoUnidaNegocio,\n\tif(gu.FechaIngreso is null,\n\t'',\n\tdate_format(gu.FechaIngreso, '%d-%m-%Y')) AS `FechaIngreso`\nFROM\n\tg_usuario_fpz guf\ninner join g_usuario gu on\n\t(gu.Id_persona = guf.Id_Persona)\nINNER join g_persona gp on\n\t(gp.Id = gu.Id_persona)\ninner join g_sexo gs on\n\t(gs.Id = gp.Id_Sexo)\ninner join g_tipoedad gt2 on\n\t(gt2.Id = gp.Id_TipoEdad)\ninner join h_incapacidad hi on\n\t(hi.Id_Usuario = guf.Id_Persona)\ninner join g_patologia gp2 on\n\t(gp2.Id = hi.Id_Patologia)\ninner JOIN so_tipo_segmento sts on\n\t(sts.Id = gu.Id_Segmento)\ninner join g_tipounidadnegocio gt on\n\t(gt.Id = guf.Id_UnidadN)\nWHERE\n\t(\nhi.Id_TipoEmpresa = '" + this.xidtipoempresa[this.JCBTipoEmpresa.getSelectedIndex()] + "'\n\t\tAND hi.Estado = 0\n)\nGROUP BY\n\tguf.Id_Persona,\n\thi.Id_Patologia\nHAVING\n\t(NDias >= " + this.JSPNDias.getValue() + ")\nORDER BY\n\tNDias DESC,\n\tCONCAT(gp.Apellido1, ' ', gp.Apellido2, ' ', gp.Nombre1, ' ', gp.Nombre2) ASC,\n\tguf.Id_Persona ASC;";
                }
            } else {
                sql = "SELECT\n\tgp.NoDocumento,\n\tCONCAT(gp.Apellido1, ' ', gp.Apellido2, ' ', gp.Nombre1, ' ', gp.Nombre2) AS NUsuario,\n\tgs.Nbre as NSexo,\n\tCONCAT(gp.Edad, ' ', gt2.Nbre) AS Edad ,\n\tSUM(hi.NDias) as NDias,\n\thi.Id_Patologia,\n\tgp2.Nbre as nPatologia,\n\tguf.Id_Persona,\n\tsts.Nbre as tipoSegmento,\n\tgt.Nbre as tipoUnidaNegocio,\n\tif(gu.FechaIngreso is null,\n\t'',\n\tdate_format(gu.FechaIngreso, '%d-%m-%Y')) AS `FechaIngreso`\nFROM\n\tg_usuario_fpz guf\ninner join g_usuario gu on\n\t(gu.Id_persona = guf.Id_Persona)\nINNER join g_persona gp on\n\t(gp.Id = gu.Id_persona)\ninner join g_sexo gs on\n\t(gs.Id = gp.Id_Sexo)\ninner join g_tipoedad gt2 on\n\t(gt2.Id = gp.Id_TipoEdad)\ninner join h_incapacidad hi on\n\t(hi.Id_Usuario = guf.Id_Persona)\ninner join g_patologia gp2 on\n\t(gp2.Id = hi.Id_Patologia)\ninner JOIN so_tipo_segmento sts on\n\t(sts.Id = gu.Id_Segmento)\ninner join g_tipounidadnegocio gt on\n\t(gt.Id = guf.Id_UnidadN)\nWHERE\n\t(\n\t\tAND hi.Estado = 0\n)\nGROUP BY\n\tguf.Id_Persona,\n\thi.Id_Patologia\nHAVING\n\t(NDias >= " + this.JSPNDias.getValue() + ")\nORDER BY\n\tNDias DESC,\n\tCONCAT(gp.Apellido1, ' ', gp.Apellido2, ' ', gp.Nombre1, ' ', gp.Nombre2) ASC,\n\tguf.Id_Persona ASC;";
            }
            System.out.println("Uno   " + sql);
            ResultSet rs = this.xct.traerRs(sql);
            if (rs.next()) {
                rs.beforeFirst();
                int i = 0;
                while (rs.next()) {
                    this.xmodelo2.addRow(this.xdato);
                    this.xmodelo2.setValueAt(rs.getString(1), i, 0);
                    this.xmodelo2.setValueAt(rs.getString(2), i, 1);
                    this.xmodelo2.setValueAt(rs.getString(3), i, 2);
                    this.xmodelo2.setValueAt(rs.getString(4), i, 3);
                    this.xmodelo2.setValueAt(Long.valueOf(rs.getLong(5)), i, 4);
                    this.xmodelo2.setValueAt(rs.getString(6), i, 5);
                    this.xmodelo2.setValueAt(rs.getString(7), i, 6);
                    mBuscar_Fechas_Incapacidad(i, rs.getLong(8), rs.getString(6));
                    this.xmodelo2.setValueAt(rs.getString(9), i, 9);
                    this.xmodelo2.setValueAt(rs.getString(10), i, 10);
                    this.xmodelo2.setValueAt(rs.getString("FechaIngreso"), i, 11);
                    i++;
                }
            }
            rs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFConsultarInforSo.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mBuscar_Fechas_Incapacidad(int x, long xid_usuario, String xid_patologia) {
        try {
            this.xsql = "SELECT `FechaInicio`, `FechaFin` FROM `h_incapacidad` WHERE (`Id_Usuario` =" + xid_usuario + " AND `Id_Patologia` ='" + xid_patologia + "' AND Estado=0) ORDER BY `Id` ASC ";
            ConsultasMySQL xct1 = new ConsultasMySQL();
            ResultSet xrs = xct1.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.beforeFirst();
                xrs.first();
                this.xmodelo2.setValueAt(xrs.getString(1), x, 7);
                xrs.last();
                this.xmodelo2.setValueAt(xrs.getString(2), x, 8);
            }
            xrs.close();
            xct1.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFConsultarInforSo.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mBuscar() {
        if (this.JCHIncapacidades.isSelected()) {
            if (this.JCHFiltro.isSelected()) {
                if (this.JCHFiltroDias.isSelected() || this.JCHFiltroDias1.isSelected()) {
                    mCargarDatosTabla3();
                } else {
                    mCargarDatosTabla2();
                }
                this.JTPDatosC.setSelectedIndex(2);
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un tipo de empresa", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            this.JCBTipoEmpresa.requestFocus();
            return;
        }
        if (this.JCHFiltro.isSelected()) {
            if (this.JCBTipoEmpresa.getSelectedIndex() != -1) {
                mCargarDatosTabla();
                mCargarDatosTabla1();
                return;
            } else {
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una bodega", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                this.JCBTipoEmpresa.requestFocus();
                return;
            }
        }
        mCargarDatosTabla();
        mCargarDatosTabla1();
    }

    private void mExportar() {
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            try {
                WritableWorkbook workbook = Workbook.createWorkbook(new File(this.JTFRuta.getText() + ".xls"));
                WritableSheet sheet = workbook.createSheet(this.JTPDatosC.getTitleAt(0), 0);
                for (int x = 0; x < this.JTBDetalle.getColumnCount(); x++) {
                    sheet.addCell(new Label(x, 0, this.JTBDetalle.getColumnName(x)));
                }
                for (int x2 = 0; x2 < this.JTBDetalle.getRowCount(); x2++) {
                    sheet.addCell(new Label(0, x2 + 1, this.xmodelo.getValueAt(x2, 0).toString()));
                    sheet.addCell(new Label(1, x2 + 1, this.xmodelo.getValueAt(x2, 1).toString()));
                    sheet.addCell(new Label(2, x2 + 1, this.xmodelo.getValueAt(x2, 2).toString()));
                    sheet.addCell(new Label(3, x2 + 1, this.xmodelo.getValueAt(x2, 3).toString()));
                    sheet.addCell(new Label(4, x2 + 1, this.xmodelo.getValueAt(x2, 4).toString()));
                    sheet.addCell(new Label(5, x2 + 1, this.xmodelo.getValueAt(x2, 5).toString()));
                    sheet.addCell(new Label(6, x2 + 1, this.xmodelo.getValueAt(x2, 6).toString()));
                    sheet.addCell(new Label(7, x2 + 1, this.xmodelo.getValueAt(x2, 7).toString()));
                    sheet.addCell(new Label(8, x2 + 1, this.xmodelo.getValueAt(x2, 8).toString()));
                    sheet.addCell(new Label(9, x2 + 1, this.xmodelo.getValueAt(x2, 9).toString()));
                }
                WritableSheet sheet2 = workbook.createSheet(this.JTPDatosC.getTitleAt(1), 1);
                for (int x3 = 0; x3 < this.JTBDetalle1.getColumnCount(); x3++) {
                    sheet2.addCell(new Label(x3, 0, this.JTBDetalle1.getColumnName(x3)));
                }
                for (int x4 = 0; x4 < this.JTBDetalle1.getRowCount(); x4++) {
                    sheet2.addCell(new Label(0, x4 + 1, this.xmodelo1.getValueAt(x4, 0).toString()));
                    sheet2.addCell(new Label(1, x4 + 1, this.xmodelo1.getValueAt(x4, 1).toString()));
                    sheet2.addCell(new Label(2, x4 + 1, this.xmodelo1.getValueAt(x4, 2).toString()));
                    sheet2.addCell(new Label(3, x4 + 1, this.xmodelo1.getValueAt(x4, 3).toString()));
                    sheet2.addCell(new Label(4, x4 + 1, this.xmodelo1.getValueAt(x4, 4).toString()));
                    sheet2.addCell(new Label(5, x4 + 1, this.xmodelo1.getValueAt(x4, 5).toString()));
                    sheet2.addCell(new Label(6, x4 + 1, this.xmodelo1.getValueAt(x4, 6).toString()));
                    sheet2.addCell(new Label(7, x4 + 1, this.xmodelo1.getValueAt(x4, 7).toString()));
                    sheet2.addCell(new Label(8, x4 + 1, this.xmodelo1.getValueAt(x4, 8).toString()));
                    sheet2.addCell(new Label(9, x4 + 1, this.xmodelo1.getValueAt(x4, 9).toString()));
                }
                WritableSheet sheet3 = workbook.createSheet(this.JTPDatosC.getTitleAt(2), 2);
                for (int x5 = 0; x5 < this.JTBDetalle2.getColumnCount(); x5++) {
                    sheet3.addCell(new Label(x5, 0, this.JTBDetalle2.getColumnName(x5)));
                }
                for (int x6 = 0; x6 < this.JTBDetalle2.getRowCount(); x6++) {
                    sheet3.addCell(new Number(0, x6 + 1, Long.valueOf(this.xmodelo2.getValueAt(x6, 0).toString()).longValue()));
                    sheet3.addCell(new Label(1, x6 + 1, this.xmodelo2.getValueAt(x6, 1).toString()));
                    sheet3.addCell(new Label(2, x6 + 1, this.xmodelo2.getValueAt(x6, 2).toString()));
                    sheet3.addCell(new Label(3, x6 + 1, this.xmodelo2.getValueAt(x6, 3).toString()));
                    sheet3.addCell(new Label(4, x6 + 1, this.xmodelo2.getValueAt(x6, 4).toString()));
                    sheet3.addCell(new Label(5, x6 + 1, this.xmodelo2.getValueAt(x6, 5).toString()));
                    sheet3.addCell(new Number(6, x6 + 1, Long.valueOf(this.xmodelo2.getValueAt(x6, 6).toString()).longValue()));
                    sheet3.addCell(new Label(7, x6 + 1, this.xmodelo2.getValueAt(x6, 7).toString()));
                    sheet3.addCell(new Label(8, x6 + 1, this.xmodelo2.getValueAt(x6, 8).toString()));
                    sheet3.addCell(new Label(9, x6 + 1, this.xmodelo2.getValueAt(x6, 9).toString()));
                    sheet3.addCell(new Label(10, x6 + 1, this.xmodelo2.getValueAt(x6, 10).toString()));
                    sheet3.addCell(new Label(11, x6 + 1, this.xmodelo2.getValueAt(x6, 11).toString()));
                    sheet3.addCell(new Label(12, x6 + 1, this.xmodelo2.getValueAt(x6, 12).toString()));
                    sheet3.addCell(new Label(13, x6 + 1, this.xmodelo2.getValueAt(x6, 13).toString()));
                    sheet3.addCell(new Label(14, x6 + 1, this.xmodelo2.getValueAt(x6, 14).toString()));
                    sheet3.addCell(new Label(15, x6 + 1, this.xmodelo2.getValueAt(x6, 15).toString()));
                    sheet3.addCell(new Label(16, x6 + 1, this.xmodelo2.getValueAt(x6, 16).toString()));
                    sheet3.addCell(new Label(17, x6 + 1, this.xmodelo2.getValueAt(x6, 17).toString()));
                    sheet3.addCell(new Label(18, x6 + 1, this.xmodelo2.getValueAt(x6, 18).toString()));
                    sheet3.addCell(new Label(19, x6 + 1, this.xmodelo2.getValueAt(x6, 19).toString()));
                }
                workbook.write();
                workbook.close();
            } catch (WriteException e) {
                Logger.getLogger(JIFConsultarInforSo.class.getName()).log(Level.SEVERE, (String) null, e);
            } catch (IOException ex) {
                Logger.getLogger(JIFConsultarInforSo.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        }
    }

    private void mExportar1() {
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTBDetalle2, this.JTFRuta.getText(), getTitle());
        }
    }
}
