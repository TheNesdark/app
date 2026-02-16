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
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
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

/* JADX INFO: loaded from: GenomaP.jar:Sig/JIFConsultarInfCove.class */
public class JIFConsultarInfCove extends JInternalFrame {
    private String[] xidtipoentidad;
    private String[] xidsede;
    private DefaultTableModel xmodelo;
    private DefaultTableModel xmodelo1;
    private DefaultTableModel xmodelo2;
    private ConsultasMySQL xct = new ConsultasMySQL();
    private Metodos xmt = new Metodos();
    private Object[] xdato;
    private String xsql;
    private ButtonGroup JBGTipoDx;
    private JButton JBTExportar;
    private JComboBox JCBSede;
    private JComboBox JCBTipoEntidad;
    private JCheckBox JCHFiltroSede;
    private JCheckBox JCH_Todos;
    private JDateChooser JDFechaF;
    private JDateChooser JDFechaI;
    private JPanel JPIDx;
    private JPanel JPIFiltro;
    private JRadioButton JRBDxP;
    private JRadioButton JRBDxR1;
    private JRadioButton JRBDxR2;
    private JRadioButton JRBDxR3;
    private JScrollPane JSPDetalle;
    private JScrollPane JSPDetalle1;
    private JScrollPane JSPDetalle2;
    private JTable JTBDetalle;
    private JTable JTBDetalle1;
    private JTable JTBDetalle2;
    private JTextField JTFRuta;
    private JTabbedPane JTPDatosC;

    public JIFConsultarInfCove() {
        initComponents();
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v67, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v72, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v76, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGTipoDx = new ButtonGroup();
        this.JPIFiltro = new JPanel();
        this.JDFechaI = new JDateChooser();
        this.JDFechaF = new JDateChooser();
        this.JCBTipoEntidad = new JComboBox();
        this.JTFRuta = new JTextField();
        this.JBTExportar = new JButton();
        this.JPIDx = new JPanel();
        this.JRBDxP = new JRadioButton();
        this.JRBDxR1 = new JRadioButton();
        this.JRBDxR2 = new JRadioButton();
        this.JRBDxR3 = new JRadioButton();
        this.JCH_Todos = new JCheckBox();
        this.JCBSede = new JComboBox();
        this.JCHFiltroSede = new JCheckBox();
        this.JTPDatosC = new JTabbedPane();
        this.JSPDetalle = new JScrollPane();
        this.JTBDetalle = new JTable();
        this.JSPDetalle1 = new JScrollPane();
        this.JTBDetalle1 = new JTable();
        this.JSPDetalle2 = new JScrollPane();
        this.JTBDetalle2 = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("CONSULTAR INFORMACIÓN DE PATOLOGIAS");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setMaximumSize(null);
        setMinimumSize(null);
        setName("jifinformacioncove");
        setRequestFocusEnabled(false);
        addInternalFrameListener(new InternalFrameListener() { // from class: Sig.JIFConsultarInfCove.1
            public void internalFrameOpened(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                JIFConsultarInfCove.this.formInternalFrameClosing(evt);
            }

            public void internalFrameClosed(InternalFrameEvent evt) {
            }

            public void internalFrameIconified(InternalFrameEvent evt) {
            }

            public void internalFrameDeiconified(InternalFrameEvent evt) {
            }

            public void internalFrameActivated(InternalFrameEvent evt) {
            }

            public void internalFrameDeactivated(InternalFrameEvent evt) {
            }
        });
        this.JPIFiltro.setBorder(BorderFactory.createTitledBorder((Border) null, "FILTRO", 0, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JDFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFechaI.setFont(new Font("Arial", 1, 12));
        this.JDFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Fin", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFechaF.setFont(new Font("Arial", 1, 12));
        this.JCBTipoEntidad.setFont(new Font("Arial", 1, 12));
        this.JCBTipoEntidad.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Entidad", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: Sig.JIFConsultarInfCove.2
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarInfCove.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setForeground(Color.red);
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: Sig.JIFConsultarInfCove.3
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarInfCove.this.JBTExportarActionPerformed(evt);
            }
        });
        this.JPIDx.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Diagnóstico", 0, 0, new Font("Arial", 1, 13), Color.red));
        this.JBGTipoDx.add(this.JRBDxP);
        this.JRBDxP.setFont(new Font("Arial", 1, 12));
        this.JRBDxP.setSelected(true);
        this.JRBDxP.setText("Principal");
        this.JBGTipoDx.add(this.JRBDxR1);
        this.JRBDxR1.setFont(new Font("Arial", 1, 12));
        this.JRBDxR1.setText("Relacionado 1");
        this.JBGTipoDx.add(this.JRBDxR2);
        this.JRBDxR2.setFont(new Font("Arial", 1, 12));
        this.JRBDxR2.setText("Relacionado 2");
        this.JBGTipoDx.add(this.JRBDxR3);
        this.JRBDxR3.setFont(new Font("Arial", 1, 12));
        this.JRBDxR3.setText("Relacionado 3");
        this.JCH_Todos.setFont(new Font("Arial", 1, 12));
        this.JCH_Todos.setForeground(Color.red);
        this.JCH_Todos.setText("Todos?");
        GroupLayout JPIDxLayout = new GroupLayout(this.JPIDx);
        this.JPIDx.setLayout(JPIDxLayout);
        JPIDxLayout.setHorizontalGroup(JPIDxLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDxLayout.createSequentialGroup().addContainerGap().addGroup(JPIDxLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDxLayout.createSequentialGroup().addComponent(this.JRBDxP).addGap(46, 46, 46).addComponent(this.JRBDxR1)).addGroup(JPIDxLayout.createSequentialGroup().addComponent(this.JRBDxR2).addGap(18, 18, 18).addComponent(this.JRBDxR3))).addContainerGap(-1, 32767)).addGroup(GroupLayout.Alignment.TRAILING, JPIDxLayout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.JCH_Todos).addContainerGap()));
        JPIDxLayout.setVerticalGroup(JPIDxLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDxLayout.createSequentialGroup().addGroup(JPIDxLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBDxP).addComponent(this.JRBDxR1)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JCH_Todos).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIDxLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBDxR2).addComponent(this.JRBDxR3)).addGap(20, 20, 20)));
        this.JCBSede.setFont(new Font("Arial", 1, 12));
        this.JCBSede.setBorder(BorderFactory.createTitledBorder((Border) null, "Sede", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHFiltroSede.setFont(new Font("Arial", 1, 12));
        this.JCHFiltroSede.setSelected(true);
        this.JCHFiltroSede.setText("Filtro?");
        GroupLayout JPIFiltroLayout = new GroupLayout(this.JPIFiltro);
        this.JPIFiltro.setLayout(JPIFiltroLayout);
        JPIFiltroLayout.setHorizontalGroup(JPIFiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFiltroLayout.createSequentialGroup().addContainerGap().addGroup(JPIFiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFiltroLayout.createSequentialGroup().addComponent(this.JCBSede, 0, 168, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHFiltroSede).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFRuta, -2, 242, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTExportar, -2, 128, -2)).addGroup(JPIFiltroLayout.createSequentialGroup().addComponent(this.JDFechaI, -2, 116, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JDFechaF, -2, 116, -2).addGap(18, 18, 18).addComponent(this.JCBTipoEntidad, 0, -1, 32767))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPIDx, -2, -1, -2).addGap(26, 26, 26)));
        JPIFiltroLayout.setVerticalGroup(JPIFiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFiltroLayout.createSequentialGroup().addGroup(JPIFiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIFiltroLayout.createSequentialGroup().addGroup(JPIFiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JCBTipoEntidad).addComponent(this.JDFechaF, -1, 50, 32767).addComponent(this.JDFechaI, -1, -1, 32767)).addGroup(JPIFiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFiltroLayout.createSequentialGroup().addGap(16, 16, 16).addGroup(JPIFiltroLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFRuta, -2, 50, -2).addComponent(this.JBTExportar, -2, 50, -2)).addGap(0, 0, 32767)).addGroup(JPIFiltroLayout.createSequentialGroup().addGap(18, 18, 18).addComponent(this.JCBSede)).addGroup(JPIFiltroLayout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JCHFiltroSede)))).addComponent(this.JPIDx, -1, -1, 32767)).addContainerGap()));
        this.JTPDatosC.setBorder(BorderFactory.createTitledBorder((Border) null, "CONSOLIDADO", 2, 0, new Font("Arial", 1, 14), Color.blue));
        this.JTPDatosC.setForeground(Color.red);
        this.JTPDatosC.setFont(new Font("Arial", 1, 14));
        this.JTBDetalle.setFont(new Font("Arial", 1, 12));
        this.JTBDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTBDetalle.setRowHeight(25);
        this.JTBDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTBDetalle.setSelectionForeground(Color.red);
        this.JTBDetalle.addMouseListener(new MouseAdapter() { // from class: Sig.JIFConsultarInfCove.4
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarInfCove.this.JTBDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTBDetalle);
        this.JTPDatosC.addTab("INDIVIDUAL", this.JSPDetalle);
        this.JTBDetalle1.setFont(new Font("Arial", 1, 12));
        this.JTBDetalle1.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTBDetalle1.setRowHeight(25);
        this.JTBDetalle1.setSelectionBackground(new Color(255, 255, 255));
        this.JTBDetalle1.setSelectionForeground(Color.red);
        this.JSPDetalle1.setViewportView(this.JTBDetalle1);
        this.JTPDatosC.addTab("AGRUPADO POR PATOLOGÍA", this.JSPDetalle1);
        this.JTBDetalle2.setFont(new Font("Arial", 1, 12));
        this.JTBDetalle2.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTBDetalle2.setRowHeight(25);
        this.JTBDetalle2.setSelectionBackground(new Color(255, 255, 255));
        this.JTBDetalle2.setSelectionForeground(Color.red);
        this.JSPDetalle2.setViewportView(this.JTBDetalle2);
        this.JTPDatosC.addTab("AGRUPADO POR USUARIO", this.JSPDetalle2);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(10, 10, 10).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTPDatosC, -2, 930, -2).addComponent(this.JPIFiltro, -2, -1, -2)).addContainerGap(17, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(11, 11, 11).addComponent(this.JPIFiltro, -2, -1, -2).addGap(6, 6, 6).addComponent(this.JTPDatosC, -2, 467, -2)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBDetalleMouseClicked(MouseEvent evt) {
        if (this.JTBDetalle.getSelectedRow() != -1) {
            String[][] mparametros = new String[4][2];
            mparametros[0][0] = "idatencion1";
            mparametros[0][1] = this.JTBDetalle.getValueAt(this.JTBDetalle.getSelectedRow(), 0).toString();
            mparametros[1][0] = "idpaciente1";
            mparametros[1][1] = this.JTBDetalle.getValueAt(this.JTBDetalle.getSelectedRow(), 19).toString();
            mparametros[2][0] = "SUBREPORT_DIR";
            mparametros[2][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
            mparametros[3][0] = "SUBREPORTFIRMA_DIR";
            mparametros[3][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
            this.xmt.GenerarPDF(this.xmt.getRutaRep() + "H_HistoriaClinica", mparametros);
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
            if (this.JTPDatosC.getSelectedIndex() == 0) {
                if (this.JTBDetalle.getRowCount() > -1) {
                    this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTBDetalle, this.JTFRuta.getText(), "INFORME INDIVIDUAL");
                    return;
                } else {
                    JOptionPane.showInternalMessageDialog(this, "No existe información para exportar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    return;
                }
            }
            if (this.JTPDatosC.getSelectedIndex() == 1) {
                if (this.JTBDetalle1.getRowCount() > -1) {
                    this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTBDetalle1, this.JTFRuta.getText(), "INFORME AGRUPADO POR PATOLOGIA");
                    return;
                } else {
                    JOptionPane.showInternalMessageDialog(this, "No existe información para exportar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    return;
                }
            }
            if (this.JTPDatosC.getSelectedIndex() == 2) {
                if (this.JTBDetalle2.getRowCount() > -1) {
                    this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTBDetalle2, this.JTFRuta.getText(), "INFORME AGRUPADO POR USUARIO");
                    return;
                } else {
                    JOptionPane.showInternalMessageDialog(this, "No existe información para exportar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    return;
                }
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un ruta valida", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        this.JTFRuta.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosing(InternalFrameEvent evt) {
        Principal.mLimpiarDatosP();
    }

    public void mNuevo() {
        this.JDFechaI.setDate(this.xmt.getFechaActual());
        this.JDFechaF.setDate(this.xmt.getFechaActual());
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
        this.JCBTipoEntidad.removeAllItems();
        this.xsql = "SELECT g_tipoentidad.Id, g_tipoentidad.Nbre FROM r_patologiasreporte INNER JOIN g_tipoentidad  ON (r_patologiasreporte.Id_TipoEntidadR = g_tipoentidad.Id) INNER JOIN h_atenciondx  ON (h_atenciondx.Id_Dx = r_patologiasreporte.Id_Patologia) GROUP BY g_tipoentidad.Id ORDER BY g_tipoentidad.Nbre ASC ";
        this.xidtipoentidad = this.xct.llenarCombo(this.xsql, this.xidtipoentidad, this.JCBTipoEntidad);
        this.JCBTipoEntidad.setSelectedIndex(-1);
        this.xct.cerrarConexionBd();
        this.JCBSede.removeAllItems();
        this.xsql = "SELECT `g_sedes`.`Id`, `g_sedes`.`Nbre` FROM  `g_sedes` INNER JOIN  `ingreso`  ON (`g_sedes`.`Id` = `ingreso`.`Id_Sede`) GROUP BY `g_sedes`.`Id` ORDER BY `g_sedes`.`Nbre` ASC";
        this.xidsede = this.xct.llenarCombo(this.xsql, this.xidsede, this.JCBSede);
        this.JCBSede.setSelectedIndex(-1);
        this.xct.cerrarConexionBd();
        mCrearTabla();
        mCrearTabla1();
    }

    public final void mCrearTabla() {
        this.xmodelo = new DefaultTableModel((Object[][]) null, new String[]{"Id", "NHC", "TDoc", "Documento", "Usuario", "FechaNac", "Edad", "TipoE", "Sexo", "Dpto", "Municipio", "Barrio", "Dirección", "Teléfono", "TipoEmpresa", "Parentesco", "Eps", "Cie10", "Patología", "IdPersona", "FechaAtencion", "Sede"}) { // from class: Sig.JIFConsultarInfCove.5
            Class[] types = {Long.class, String.class, String.class, String.class, String.class, String.class, Long.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTBDetalle;
        JTable jTable2 = this.JTBDetalle;
        jTable.setAutoResizeMode(0);
        this.JTBDetalle.doLayout();
        this.JTBDetalle.setModel(this.xmodelo);
        this.JTBDetalle.getColumnModel().getColumn(0).setPreferredWidth(80);
        this.JTBDetalle.getColumnModel().getColumn(1).setPreferredWidth(80);
        this.JTBDetalle.getColumnModel().getColumn(2).setPreferredWidth(80);
        this.JTBDetalle.getColumnModel().getColumn(3).setPreferredWidth(80);
        this.JTBDetalle.getColumnModel().getColumn(4).setPreferredWidth(300);
        this.JTBDetalle.getColumnModel().getColumn(5).setPreferredWidth(80);
        this.JTBDetalle.getColumnModel().getColumn(6).setPreferredWidth(80);
        this.JTBDetalle.getColumnModel().getColumn(7).setPreferredWidth(80);
        this.JTBDetalle.getColumnModel().getColumn(8).setPreferredWidth(80);
        this.JTBDetalle.getColumnModel().getColumn(9).setPreferredWidth(80);
        this.JTBDetalle.getColumnModel().getColumn(10).setPreferredWidth(80);
        this.JTBDetalle.getColumnModel().getColumn(11).setPreferredWidth(80);
        this.JTBDetalle.getColumnModel().getColumn(12).setPreferredWidth(80);
        this.JTBDetalle.getColumnModel().getColumn(13).setPreferredWidth(80);
        this.JTBDetalle.getColumnModel().getColumn(14).setPreferredWidth(80);
        this.JTBDetalle.getColumnModel().getColumn(15).setPreferredWidth(80);
        this.JTBDetalle.getColumnModel().getColumn(16).setPreferredWidth(80);
        this.JTBDetalle.getColumnModel().getColumn(17).setPreferredWidth(80);
        this.JTBDetalle.getColumnModel().getColumn(18).setPreferredWidth(400);
        this.JTBDetalle.getColumnModel().getColumn(19).setPreferredWidth(80);
        this.JTBDetalle.getColumnModel().getColumn(20).setPreferredWidth(80);
        this.JTBDetalle.getColumnModel().getColumn(21).setPreferredWidth(80);
    }

    public final void mCrearTabla_1() {
        this.xmodelo2 = new DefaultTableModel((Object[][]) null, new String[]{"Id", "NHC", "TDoc", "Documento", "Usuario", "FechaNac", "Edad", "TipoE", "Sexo", "Dpto", "Municipio", "Barrio", "Dirección", "Teléfono", "TipoEmpresa", "Parentesco", "Eps", "Cie10", "Patología", "NCasos"}) { // from class: Sig.JIFConsultarInfCove.6
            Class[] types = {Long.class, String.class, String.class, String.class, String.class, String.class, Long.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Long.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

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
        this.JTBDetalle2.getColumnModel().getColumn(2).setPreferredWidth(80);
        this.JTBDetalle2.getColumnModel().getColumn(3).setPreferredWidth(80);
        this.JTBDetalle2.getColumnModel().getColumn(4).setPreferredWidth(300);
        this.JTBDetalle2.getColumnModel().getColumn(5).setPreferredWidth(80);
        this.JTBDetalle2.getColumnModel().getColumn(6).setPreferredWidth(80);
        this.JTBDetalle2.getColumnModel().getColumn(7).setPreferredWidth(80);
        this.JTBDetalle2.getColumnModel().getColumn(8).setPreferredWidth(80);
        this.JTBDetalle2.getColumnModel().getColumn(9).setPreferredWidth(80);
        this.JTBDetalle2.getColumnModel().getColumn(10).setPreferredWidth(80);
        this.JTBDetalle2.getColumnModel().getColumn(11).setPreferredWidth(80);
        this.JTBDetalle2.getColumnModel().getColumn(12).setPreferredWidth(80);
        this.JTBDetalle2.getColumnModel().getColumn(13).setPreferredWidth(80);
        this.JTBDetalle2.getColumnModel().getColumn(14).setPreferredWidth(80);
        this.JTBDetalle2.getColumnModel().getColumn(15).setPreferredWidth(80);
        this.JTBDetalle2.getColumnModel().getColumn(16).setPreferredWidth(80);
        this.JTBDetalle2.getColumnModel().getColumn(17).setPreferredWidth(80);
        this.JTBDetalle2.getColumnModel().getColumn(18).setPreferredWidth(400);
        this.JTBDetalle2.getColumnModel().getColumn(19).setPreferredWidth(80);
    }

    public final void mCrearTabla2() {
        this.xmodelo2 = new DefaultTableModel((Object[][]) null, new String[]{"Id", "NHC", "TDoc", "Documento", "Usuario", "FechaNac", "Edad", "TipoE", "Sexo", "Dpto", "Municipio", "Barrio", "Dirección", "Teléfono", "TipoEmpresa", "Parentesco", "Eps", "Cie10", "Patología", "IdPersona", "Glucosa", "Glucosa1", "Glucosa2", "PROGRAMA PYP", "FUConsultaNutricion", "TA", "Peso", "Talla", "Imc", "PAbdominal", "Talla", "Peso", "Imc", "CCarpo", "Estructuram", "Cintura", "Cadera", "%Agua", "%Grasa", "MOsea", "MViseral", "PLGrasa", "PUsual", "PObjetivo", "Tto?", "Fecha Tto", "Medicamento"}) { // from class: Sig.JIFConsultarInfCove.7
            Class[] types = {Long.class, String.class, String.class, String.class, String.class, String.class, Long.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTBDetalle2.setModel(this.xmodelo2);
        this.JTBDetalle2.getColumnModel().getColumn(0).setPreferredWidth(5);
        this.JTBDetalle2.getColumnModel().getColumn(1).setPreferredWidth(10);
        this.JTBDetalle2.getColumnModel().getColumn(2).setPreferredWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(2).setMinWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(2).setMaxWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(3).setPreferredWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(3).setMinWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(3).setMaxWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(4).setPreferredWidth(200);
        this.JTBDetalle2.getColumnModel().getColumn(5).setPreferredWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(5).setMinWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(5).setMaxWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(6).setPreferredWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(6).setMinWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(6).setMaxWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(7).setPreferredWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(7).setMinWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(7).setMaxWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(8).setPreferredWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(8).setMinWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(8).setMaxWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(9).setPreferredWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(9).setMinWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(9).setMaxWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(10).setPreferredWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(10).setMinWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(10).setMaxWidth(0);
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
        this.JTBDetalle2.getColumnModel().getColumn(16).setPreferredWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(16).setMinWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(16).setMaxWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(17).setPreferredWidth(10);
        this.JTBDetalle2.getColumnModel().getColumn(18).setPreferredWidth(430);
        this.JTBDetalle2.getColumnModel().getColumn(19).setPreferredWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(19).setMinWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(19).setMaxWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(20).setPreferredWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(20).setMinWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(20).setMaxWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(21).setPreferredWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(21).setMinWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(21).setMaxWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(22).setPreferredWidth(10);
        this.JTBDetalle2.getColumnModel().getColumn(22).setMinWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(22).setMaxWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(23).setPreferredWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(23).setMinWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(23).setMaxWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(24).setPreferredWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(24).setMinWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(24).setMaxWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(25).setPreferredWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(25).setMinWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(25).setMaxWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(26).setPreferredWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(26).setMinWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(26).setMaxWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(27).setPreferredWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(27).setMinWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(27).setMaxWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(28).setPreferredWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(28).setMinWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(28).setMaxWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(29).setPreferredWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(29).setMinWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(29).setMaxWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(30).setPreferredWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(30).setMinWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(30).setMaxWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(31).setPreferredWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(31).setMinWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(31).setMaxWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(32).setPreferredWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(32).setMinWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(32).setMaxWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(33).setPreferredWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(33).setMinWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(33).setMaxWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(34).setPreferredWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(34).setMinWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(34).setMaxWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(35).setPreferredWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(35).setMinWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(35).setMaxWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(36).setPreferredWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(36).setMinWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(36).setMaxWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(37).setPreferredWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(37).setMinWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(37).setMaxWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(38).setPreferredWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(38).setMinWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(38).setMaxWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(39).setPreferredWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(39).setMinWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(39).setMaxWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(40).setPreferredWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(40).setMinWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(40).setMaxWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(41).setPreferredWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(41).setMinWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(41).setMaxWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(42).setPreferredWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(42).setMinWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(42).setMaxWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(43).setPreferredWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(43).setMinWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(43).setMaxWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(44).setPreferredWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(44).setMinWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(44).setMaxWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(45).setPreferredWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(45).setMinWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(45).setMaxWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(46).setPreferredWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(46).setMinWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(46).setMaxWidth(0);
    }

    public final void mCrearTabla3() {
        this.xmodelo2 = new DefaultTableModel((Object[][]) null, new String[]{"Id", "NHC", "TDoc", "Documento", "Usuario", "FechaNac", "Edad", "TipoE", "Sexo", "Dpto", "Municipio", "Barrio", "Dirección", "Teléfono", "TipoEmpresa", "Parentesco", "Eps", "Cie10", "Patología", "IdPersona", "CT", "CT1", "HDL", "HDL1", "LDL", "LDL1", "TRIGLICERIDOS", "TRIGLICERIDOS1", "PROGRAMA PYP", "Fecha Ultima Consulta Nutrición", "TA", "Peso", "Talla", "Imc", "PAbdominal", "Talla", "Peso", "Imc", "CCarpo", "Estructuram", "Cintura", "Cadera", "%Agua", "%Grasa", "MOsea", "MViseral", "PLGrasa", "PUsual", "PObjetivo", "Tto?", "Fecha Tto", "Medicamento"}) { // from class: Sig.JIFConsultarInfCove.8
            Class[] types = {Long.class, String.class, String.class, String.class, String.class, String.class, Long.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTBDetalle2.setModel(this.xmodelo2);
        this.JTBDetalle2.getColumnModel().getColumn(0).setPreferredWidth(5);
        this.JTBDetalle2.getColumnModel().getColumn(1).setPreferredWidth(10);
        this.JTBDetalle2.getColumnModel().getColumn(2).setPreferredWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(2).setMinWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(2).setMaxWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(3).setPreferredWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(3).setMinWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(3).setMaxWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(4).setPreferredWidth(200);
        this.JTBDetalle2.getColumnModel().getColumn(5).setPreferredWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(5).setMinWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(5).setMaxWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(6).setPreferredWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(6).setMinWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(6).setMaxWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(7).setPreferredWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(7).setMinWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(7).setMaxWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(8).setPreferredWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(8).setMinWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(8).setMaxWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(9).setPreferredWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(9).setMinWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(9).setMaxWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(10).setPreferredWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(10).setMinWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(10).setMaxWidth(0);
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
        this.JTBDetalle2.getColumnModel().getColumn(16).setPreferredWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(16).setMinWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(16).setMaxWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(17).setPreferredWidth(10);
        this.JTBDetalle2.getColumnModel().getColumn(18).setPreferredWidth(430);
        this.JTBDetalle2.getColumnModel().getColumn(19).setPreferredWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(19).setMinWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(19).setMaxWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(20).setPreferredWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(20).setMinWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(20).setMaxWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(21).setPreferredWidth(10);
        this.JTBDetalle2.getColumnModel().getColumn(21).setMinWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(21).setMaxWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(22).setPreferredWidth(10);
        this.JTBDetalle2.getColumnModel().getColumn(22).setMinWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(22).setMaxWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(23).setPreferredWidth(10);
        this.JTBDetalle2.getColumnModel().getColumn(23).setMinWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(23).setMaxWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(24).setPreferredWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(24).setMinWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(24).setMaxWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(25).setPreferredWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(25).setMinWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(25).setMaxWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(26).setPreferredWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(26).setMinWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(26).setMaxWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(27).setPreferredWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(27).setMinWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(27).setMaxWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(28).setPreferredWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(28).setMinWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(28).setMaxWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(29).setPreferredWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(29).setMinWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(29).setMaxWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(30).setPreferredWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(30).setMinWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(30).setMaxWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(31).setPreferredWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(31).setMinWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(31).setMaxWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(32).setPreferredWidth(10);
        this.JTBDetalle2.getColumnModel().getColumn(33).setPreferredWidth(10);
        this.JTBDetalle2.getColumnModel().getColumn(34).setPreferredWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(34).setMinWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(34).setMaxWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(35).setPreferredWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(35).setMinWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(35).setMaxWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(36).setPreferredWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(36).setMinWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(36).setMaxWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(37).setPreferredWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(37).setMinWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(37).setMaxWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(38).setPreferredWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(38).setMinWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(38).setMaxWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(39).setPreferredWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(39).setMinWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(39).setMaxWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(40).setPreferredWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(40).setMinWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(40).setMaxWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(41).setPreferredWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(41).setMinWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(41).setMaxWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(42).setPreferredWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(42).setMinWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(42).setMaxWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(43).setPreferredWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(43).setMinWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(43).setMaxWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(44).setPreferredWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(44).setMinWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(44).setMaxWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(45).setPreferredWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(45).setMinWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(45).setMaxWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(46).setPreferredWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(46).setMinWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(46).setMaxWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(47).setPreferredWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(47).setMinWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(47).setMaxWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(48).setPreferredWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(48).setMinWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(48).setMaxWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(49).setPreferredWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(49).setMinWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(49).setMaxWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(50).setPreferredWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(50).setMinWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(50).setMaxWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(51).setPreferredWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(51).setMinWidth(0);
        this.JTBDetalle2.getColumnModel().getColumn(51).setMaxWidth(0);
    }

    public final void mCrearTabla1() {
        this.xmodelo1 = new DefaultTableModel((Object[][]) null, new String[]{"Cie10", "Patología", "Cantidad"}) { // from class: Sig.JIFConsultarInfCove.9
            Class[] types = {String.class, String.class, Long.class};
            boolean[] canEdit = {false, false, false, false, false, false};

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
        this.JTBDetalle1.getColumnModel().getColumn(1).setPreferredWidth(600);
        this.JTBDetalle1.getColumnModel().getColumn(2).setPreferredWidth(100);
    }

    private void mCargarDatosTabla() {
        String sql;
        try {
            String xRelacion = "";
            mCrearTabla();
            String xSede = this.JCHFiltroSede.isSelected() ? " AND ingreso.Id_Sede='" + this.xidsede[this.JCBSede.getSelectedIndex()] + "' " : "";
            if (this.JCH_Todos.isSelected()) {
                sql = "SELECT h_atencion.Id, g_usuario.`NoHistoria`, g_persona.Id_TipoIdentificacion, g_persona.NoDocumento,  CONCAT(g_persona.`Apellido1`,' ',g_persona.`Apellido2`,' ',g_persona.`Nombre1` ,' ',g_persona.`Nombre1` ) AS NUsuario, DATE_FORMAT(g_persona.FechaNac,'%d-%m-%Y')  AS FechaNac , `Devuelve_Edad_2F`(g_persona.FechaNac,h_atencion.`Fecha_Atencion`) AS Edad, \n`Devuelve_Tipo_Edad_2F`(g_persona.FechaNac,h_atencion.`Fecha_Atencion`) AS NTipoEdad, g_persona.`Id_Sexo` AS IdSexo ,g_departamento.`Nbre` AS  Departamento , g_municipio.`Nbre` AS NMunicipio , g_barrio.`Nbre` AS NBarrio , g_persona.Direccion , g_persona.Telefono , IFNULL (g_tipoempresa.Nbre ,' ')AS TipoE , IFNULL ( g_parentesco.Nbre ,' ')AS Parentesco ,\n  f_empresacontxconvenio.Nbre , r_patologiasreporte.Id_Patologia , g_patologia.Nbre , g_persona.`Id` AS persona,h_atencion.`Fecha_Atencion`,  g_sedes.Nbre as Sede  \n  FROM  h_atenciondx  INNER JOIN h_atencion  ON (h_atencion.`Id`= `h_atenciondx`.`Id_Atencion`)   INNER JOIN  r_patologiasreporte  ON (r_patologiasreporte.Id_Patologia = `h_atenciondx`.`Id_Dx`)   INNER JOIN ingreso  ON (h_atencion.Id_Ingreso = ingreso.Id)   INNER JOIN `g_persona`  ON (g_persona.`Id` = ingreso.Id_Usuario)  INNER JOIN `g_usuario`  ON (g_persona.`Id` = g_usuario.`Id_persona`) \nINNER JOIN `g_barrio`  ON (g_persona.`Id_Barrio` = g_barrio.`Id`)  INNER JOIN `g_municipio`  ON (g_persona.`Id_Municipio` = g_municipio.`Id`)  INNER JOIN `g_departamento` ON (g_departamento.`Id` = g_municipio.`Id_Dpto`) \nLEFT JOIN g_usuario_fpz  ON (g_usuario_fpz.Id_Persona = g_persona.Id) LEFT JOIN g_tipoempresa  ON (g_usuario_fpz.Id_Empresa = g_tipoempresa.Id)  LEFT JOIN g_parentesco  ON (g_parentesco.Id = g_usuario_fpz.Id_Parentesco)\nINNER JOIN f_empresacontxconvenio  ON (ingreso.Id_EmpresaContxConv = f_empresacontxconvenio.Id) INNER JOIN g_patologia  ON (r_patologiasreporte.Id_Patologia = g_patologia.Id)   INNER JOIN `g_sedes` ON (`g_sedes`.Id=ingreso.Id_Sede)WHERE (h_atencion.Fecha_Atencion >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND h_atencion.Fecha_Atencion <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' AND r_patologiasreporte.Id_TipoEntidadR ='" + this.xidtipoentidad[this.JCBTipoEntidad.getSelectedIndex()] + "'" + xSede + ")  GROUP BY g_persona.`Id` ORDER BY h_atencion.Fecha_Atencion ASC ";
            } else {
                if (this.JRBDxP.isSelected()) {
                    xRelacion = "r_patologiasreporte.Id_Patologia = `h_atencion`.`Codigo_Dxp`";
                } else if (this.JRBDxR1.isSelected()) {
                    xRelacion = "r_patologiasreporte.Id_Patologia = `h_atencion`.`Codigo_DxR1`";
                } else if (this.JRBDxR2.isSelected()) {
                    xRelacion = "r_patologiasreporte.Id_Patologia = `h_atencion`.`Codigo_DxR2`";
                } else if (this.JRBDxR3.isSelected()) {
                    xRelacion = "r_patologiasreporte.Id_Patologia = `h_atencion`.`Codigo_DxR3`";
                }
                sql = "SELECT h_atencion.Id, g_usuario.`NoHistoria`, g_persona.Id_TipoIdentificacion, g_persona.NoDocumento,  CONCAT(g_persona.`Apellido1`,' ',g_persona.`Apellido2`,' ',g_persona.`Nombre1` ,' ',g_persona.`Nombre1` ) AS NUsuario, DATE_FORMAT(g_persona.FechaNac,'%d-%m-%Y')  AS FechaNac , `Devuelve_Edad_2F`(g_persona.FechaNac,h_atencion.`Fecha_Atencion`) AS Edad, \n`Devuelve_Tipo_Edad_2F`(g_persona.FechaNac,h_atencion.`Fecha_Atencion`) AS NTipoEdad, g_persona.`Id_Sexo` AS IdSexo ,g_departamento.`Nbre` AS  Departamento , g_municipio.`Nbre` AS NMunicipio , g_barrio.`Nbre` AS NBarrio , g_persona.Direccion , g_persona.Telefono , IFNULL (g_tipoempresa.Nbre ,' ')AS TipoE , IFNULL ( g_parentesco.Nbre ,' ')AS Parentesco ,\n  f_empresacontxconvenio.Nbre , r_patologiasreporte.Id_Patologia , g_patologia.Nbre , g_persona.`Id` AS persona,h_atencion.`Fecha_Atencion`,  g_sedes.Nbre AS Sede  \nFROM  h_atencion  \nINNER JOIN  r_patologiasreporte  ON (" + xRelacion + ")   \nINNER JOIN ingreso  ON (h_atencion.Id_Ingreso = ingreso.Id)   \nINNER JOIN `g_persona`  ON (g_persona.`Id` = ingreso.Id_Usuario)  \nINNER JOIN `g_usuario`  ON (g_persona.`Id` = g_usuario.`Id_persona`) \nINNER JOIN `g_barrio`  ON (g_persona.`Id_Barrio` = g_barrio.`Id`)  \nINNER JOIN `g_municipio`  ON (g_persona.`Id_Municipio` = g_municipio.`Id`)  \nINNER JOIN `g_departamento` ON (g_departamento.`Id` = g_municipio.`Id_Dpto`) \nLEFT JOIN g_usuario_fpz  ON (g_usuario_fpz.Id_Persona = g_persona.Id) \nLEFT JOIN g_tipoempresa  ON (g_usuario_fpz.Id_Empresa = g_tipoempresa.Id)  \nLEFT JOIN g_parentesco  ON (g_parentesco.Id = g_usuario_fpz.Id_Parentesco)\nINNER JOIN f_empresacontxconvenio  ON (ingreso.Id_EmpresaContxConv = f_empresacontxconvenio.Id) \nINNER JOIN g_patologia  ON (r_patologiasreporte.Id_Patologia = g_patologia.Id)   \nINNER JOIN `g_sedes` ON (`g_sedes`.Id=ingreso.Id_Sede)\nWHERE ( \nh_atencion.Fecha_Atencion >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' \nAND h_atencion.Fecha_Atencion <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' \nAND r_patologiasreporte.Id_TipoEntidadR ='" + this.xidtipoentidad[this.JCBTipoEntidad.getSelectedIndex()] + "'\n" + xSede + ")  \nGROUP BY g_persona.`Id` ORDER BY h_atencion.Fecha_Atencion ASC ";
            }
            System.out.println("Uno   " + sql);
            ResultSet rs = this.xct.traerRs(sql);
            rs.next();
            if (rs.getRow() != 0) {
                rs.beforeFirst();
                int i = 0;
                while (rs.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(Long.valueOf(rs.getLong(1)), i, 0);
                    this.xmodelo.setValueAt(rs.getString(2), i, 1);
                    this.xmodelo.setValueAt(rs.getString(3), i, 2);
                    this.xmodelo.setValueAt(rs.getString(4), i, 3);
                    this.xmodelo.setValueAt(rs.getString(5), i, 4);
                    this.xmodelo.setValueAt(rs.getString(6), i, 5);
                    this.xmodelo.setValueAt(Long.valueOf(rs.getLong(7)), i, 6);
                    this.xmodelo.setValueAt(rs.getString(8), i, 7);
                    this.xmodelo.setValueAt(rs.getString(9), i, 8);
                    this.xmodelo.setValueAt(rs.getString(10), i, 9);
                    this.xmodelo.setValueAt(rs.getString(11), i, 10);
                    this.xmodelo.setValueAt(rs.getString(12), i, 11);
                    this.xmodelo.setValueAt(rs.getString(13), i, 12);
                    this.xmodelo.setValueAt(rs.getString(14), i, 13);
                    this.xmodelo.setValueAt(rs.getString(15), i, 14);
                    this.xmodelo.setValueAt(rs.getString(16), i, 15);
                    this.xmodelo.setValueAt(rs.getString(17), i, 16);
                    this.xmodelo.setValueAt(rs.getString(18), i, 17);
                    this.xmodelo.setValueAt(rs.getString(19), i, 18);
                    this.xmodelo.setValueAt(rs.getString("persona"), i, 19);
                    this.xmodelo.setValueAt(rs.getString("Fecha_Atencion"), i, 20);
                    this.xmodelo.setValueAt(rs.getString("Sede"), i, 21);
                    i++;
                }
                Principal.txtNo.setText("" + i);
            }
            rs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFConsultarInfCove.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarDatosTabla_1() {
        String sql;
        try {
            String xRelacion = "";
            mCrearTabla_1();
            String xSede = this.JCHFiltroSede.isSelected() ? " AND ingreso.Id_Sede='" + this.xidsede[this.JCBSede.getSelectedIndex()] + "' " : "";
            if (this.JCH_Todos.isSelected()) {
                sql = "SELECT h_atencion.Id, g_usuario.`NoHistoria`, g_persona.Id_TipoIdentificacion, g_persona.NoDocumento,  CONCAT(g_persona.`Apellido1`,' ',g_persona.`Apellido2`,' ',g_persona.`Nombre1` ,' ',g_persona.`Nombre1` ) AS NUsuario, DATE_FORMAT(g_persona.FechaNac,'%d-%m-%Y')  AS FechaNac , `Devuelve_Edad_2F`(g_persona.FechaNac,h_atencion.`Fecha_Atencion`) AS Edad, \n`Devuelve_Tipo_Edad_2F`(g_persona.FechaNac,h_atencion.`Fecha_Atencion`) AS NTipoEdad, g_persona.`Id_Sexo` AS IdSexo ,g_departamento.`Nbre` AS  Departamento , g_municipio.`Nbre` AS NMunicipio , g_barrio.`Nbre` AS NBarrio , g_persona.Direccion , g_persona.Telefono , IFNULL (g_tipoempresa.Nbre ,' ')AS TipoE , IFNULL ( g_parentesco.Nbre ,' ')AS Parentesco ,\n  f_empresacontxconvenio.Nbre , r_patologiasreporte.Id_Patologia , g_patologia.Nbre , g_persona.`Id` AS persona,h_atencion.`Fecha_Atencion`,  g_sedes.Nbre as Sede, count(ingreso.Id)NCasos  \n  FROM  h_atenciondx  INNER JOIN h_atencion  ON (h_atencion.`Id`= `h_atenciondx`.`Id_Atencion`)   INNER JOIN  r_patologiasreporte  ON (r_patologiasreporte.Id_Patologia = `h_atenciondx`.`Id_Dx`)   INNER JOIN ingreso  ON (h_atencion.Id_Ingreso = ingreso.Id)   INNER JOIN `g_persona`  ON (g_persona.`Id` = ingreso.Id_Usuario)  INNER JOIN `g_usuario`  ON (g_persona.`Id` = g_usuario.`Id_persona`) \nINNER JOIN `g_barrio`  ON (g_persona.`Id_Barrio` = g_barrio.`Id`)  INNER JOIN `g_municipio`  ON (g_persona.`Id_Municipio` = g_municipio.`Id`)  INNER JOIN `g_departamento` ON (g_departamento.`Id` = g_municipio.`Id_Dpto`) \nLEFT JOIN g_usuario_fpz  ON (g_usuario_fpz.Id_Persona = g_persona.Id) LEFT JOIN g_tipoempresa  ON (g_usuario_fpz.Id_Empresa = g_tipoempresa.Id)  LEFT JOIN g_parentesco  ON (g_parentesco.Id = g_usuario_fpz.Id_Parentesco)\nINNER JOIN f_empresacontxconvenio  ON (ingreso.Id_EmpresaContxConv = f_empresacontxconvenio.Id) INNER JOIN g_patologia  ON (r_patologiasreporte.Id_Patologia = g_patologia.Id)   INNER JOIN `g_sedes` ON (`g_sedes`.Id=ingreso.Id_Sede)WHERE ( h_atencion.Fecha_Atencion >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND h_atencion.Fecha_Atencion <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' AND r_patologiasreporte.Id_TipoEntidadR ='" + this.xidtipoentidad[this.JCBTipoEntidad.getSelectedIndex()] + "'" + xSede + ")  GROUP BY g_persona.`Id` ORDER BY h_atencion.Fecha_Atencion ASC ";
            } else {
                if (this.JRBDxP.isSelected()) {
                    xRelacion = "r_patologiasreporte.Id_Patologia = `h_atencion`.`Codigo_Dxp`";
                } else if (this.JRBDxR1.isSelected()) {
                    xRelacion = "r_patologiasreporte.Id_Patologia = `h_atencion`.`Codigo_DxR1`";
                } else if (this.JRBDxR2.isSelected()) {
                    xRelacion = "r_patologiasreporte.Id_Patologia = `h_atencion`.`Codigo_DxR2`";
                } else if (this.JRBDxR3.isSelected()) {
                    xRelacion = "r_patologiasreporte.Id_Patologia = `h_atencion`.`Codigo_DxR3`";
                }
                sql = "SELECT h_atencion.Id, g_usuario.`NoHistoria`, g_persona.Id_TipoIdentificacion, g_persona.NoDocumento,  CONCAT(g_persona.`Apellido1`,' ',g_persona.`Apellido2`,' ',g_persona.`Nombre1` ,' ',g_persona.`Nombre1` ) AS NUsuario, DATE_FORMAT(g_persona.FechaNac,'%d-%m-%Y')  AS FechaNac , `Devuelve_Edad_2F`(g_persona.FechaNac,h_atencion.`Fecha_Atencion`) AS Edad, \n`Devuelve_Tipo_Edad_2F`(g_persona.FechaNac,h_atencion.`Fecha_Atencion`) AS NTipoEdad, g_persona.`Id_Sexo` AS IdSexo ,g_departamento.`Nbre` AS  Departamento , g_municipio.`Nbre` AS NMunicipio , g_barrio.`Nbre` AS NBarrio , g_persona.Direccion , g_persona.Telefono , IFNULL (g_tipoempresa.Nbre ,' ')AS TipoE , IFNULL ( g_parentesco.Nbre ,' ')AS Parentesco ,\n  f_empresacontxconvenio.Nbre , r_patologiasreporte.Id_Patologia , g_patologia.Nbre , g_persona.`Id` AS persona,h_atencion.`Fecha_Atencion`,  g_sedes.Nbre as Sede, count(ingreso.Id)NCasos  \n  FROM  r_patologiasreporte  INNER JOIN h_atencion  ON (" + xRelacion + ")  INNER JOIN ingreso  ON (h_atencion.Id_Ingreso = ingreso.Id)   INNER JOIN `g_persona`  ON (g_persona.`Id` = ingreso.Id_Usuario)  INNER JOIN `g_usuario`  ON (g_persona.`Id` = g_usuario.`Id_persona`) \nINNER JOIN `g_barrio`  ON (g_persona.`Id_Barrio` = g_barrio.`Id`)  INNER JOIN `g_municipio`  ON (g_persona.`Id_Municipio` = g_municipio.`Id`)  INNER JOIN `g_departamento` ON (g_departamento.`Id` = g_municipio.`Id_Dpto`) \nLEFT JOIN g_usuario_fpz  ON (g_usuario_fpz.Id_Persona = g_persona.Id) LEFT JOIN g_tipoempresa  ON (g_usuario_fpz.Id_Empresa = g_tipoempresa.Id)  LEFT JOIN g_parentesco  ON (g_parentesco.Id = g_usuario_fpz.Id_Parentesco)\nINNER JOIN f_empresacontxconvenio  ON (ingreso.Id_EmpresaContxConv = f_empresacontxconvenio.Id) INNER JOIN g_patologia  ON (r_patologiasreporte.Id_Patologia = g_patologia.Id)   INNER JOIN `g_sedes` ON (`g_sedes`.Id=ingreso.Id_Sede)WHERE ( h_atencion.Fecha_Atencion >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND h_atencion.Fecha_Atencion <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' AND r_patologiasreporte.Id_TipoEntidadR ='" + this.xidtipoentidad[this.JCBTipoEntidad.getSelectedIndex()] + "'" + xSede + ") group by g_persona.`Id` ORDER BY h_atencion.Fecha_Atencion ASC ";
            }
            System.out.println("Uno   " + sql);
            ResultSet rs = this.xct.traerRs(sql);
            rs.next();
            if (rs.getRow() != 0) {
                rs.beforeFirst();
                int i = 0;
                while (rs.next()) {
                    this.xmodelo2.addRow(this.xdato);
                    this.xmodelo2.setValueAt(Long.valueOf(rs.getLong(1)), i, 0);
                    this.xmodelo2.setValueAt(rs.getString(2), i, 1);
                    this.xmodelo2.setValueAt(rs.getString(3), i, 2);
                    this.xmodelo2.setValueAt(rs.getString(4), i, 3);
                    this.xmodelo2.setValueAt(rs.getString(5), i, 4);
                    this.xmodelo2.setValueAt(rs.getString(6), i, 5);
                    this.xmodelo2.setValueAt(Long.valueOf(rs.getLong(7)), i, 6);
                    this.xmodelo2.setValueAt(rs.getString(8), i, 7);
                    this.xmodelo2.setValueAt(rs.getString(9), i, 8);
                    this.xmodelo2.setValueAt(rs.getString(10), i, 9);
                    this.xmodelo2.setValueAt(rs.getString(11), i, 10);
                    this.xmodelo2.setValueAt(rs.getString(12), i, 11);
                    this.xmodelo2.setValueAt(rs.getString(13), i, 12);
                    this.xmodelo2.setValueAt(rs.getString(14), i, 13);
                    this.xmodelo2.setValueAt(rs.getString(15), i, 14);
                    this.xmodelo2.setValueAt(rs.getString(16), i, 15);
                    this.xmodelo2.setValueAt(rs.getString(17), i, 16);
                    this.xmodelo2.setValueAt(rs.getString(18), i, 17);
                    this.xmodelo2.setValueAt(rs.getString(19), i, 18);
                    this.xmodelo2.setValueAt(rs.getString("NCasos"), i, 19);
                    i++;
                }
                Principal.txtNo.setText("" + i);
            }
            rs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFConsultarInfCove.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarDatosTabla4() {
        try {
            String sql = null;
            mCrearTabla2();
            if (this.JRBDxP.isSelected()) {
                if (Principal.informacionIps.getEsFpz().intValue() == 0) {
                    sql = "SELECT h_atencion.Id, persona.NoHistoria, persona.Id_TipoIdentificacion, persona.NoDocumento, persona.NUsuario, DATE_FORMAT(persona.FechaNac,'%d-%m-%Y')  AS FechaNac , persona.Edad, persona.NTipoEdad, persona.IdSexo, '' AS Departamento , persona.NMunicipio , persona.NBarrio , persona.Direccion , persona.Telefono , g_tipoempresa.Nbre , g_parentesco.Nbre , f_empresacontxconvenio.Nbre , r_patologiasreporte.Id_Patologia , g_patologia.Nbre , persona.Id_persona  FROM  r_patologiasreporte INNER JOIN h_atencion  ON (r_patologiasreporte.Id_Patologia = h_atencion.Codigo_Dxp) INNER JOIN ingreso  ON (h_atencion.Id_Ingreso = ingreso.Id)  INNER JOIN persona  ON (persona.Id_persona = ingreso.Id_Usuario) INNER JOIN g_usuario_fpz  ON (g_usuario_fpz.Id_Persona = persona.Id_persona) INNER JOIN g_tipoempresa  ON (g_usuario_fpz.Id_Empresa = g_tipoempresa.Id) INNER JOIN g_parentesco  ON (g_parentesco.Id = g_usuario_fpz.Id_Parentesco) INNER JOIN f_empresacontxconvenio  ON (ingreso.Id_EmpresaContxConv = f_empresacontxconvenio.Id) INNER JOIN g_patologia  ON (r_patologiasreporte.Id_Patologia = g_patologia.Id) WHERE (h_atencion.Fecha_Atencion >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND h_atencion.Fecha_Atencion <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' AND r_patologiasreporte.Id_TipoEntidadR ='" + this.xidtipoentidad[this.JCBTipoEntidad.getSelectedIndex()] + "')  GROUP BY persona.NoHistoria  ORDER BY h_atencion.Fecha_Atencion ASC ";
                } else {
                    sql = "SELECT h_atencion.Id, persona.NoHistoria, persona.Id_TipoIdentificacion, persona.NoDocumento, persona.NUsuario, DATE_FORMAT(g_persona.FechaNac,'%d-%m-%Y') AS FechaNac, persona.Edad, persona.NTipoEdad, persona.IdSexo , UCASE(g_departamento.Nbre) AS Dpto, g_municipio.Nbre AS NMunicipio, persona.NBarrio, persona.Direccion, persona.Telefono, '', '', f_empresacontxconvenio.Nbre, g_patologia.Id, g_patologia.Nbre, persona.Id_persona FROM h_atencion INNER JOIN ingreso  ON (h_atencion.Id_Ingreso = ingreso.Id) INNER JOIN persona  ON (ingreso.Id_Usuario = persona.Id_persona) INNER JOIN g_usuario  ON (ingreso.Id_Usuario = g_usuario.Id_persona) INNER JOIN r_patologiasreporte  ON (r_patologiasreporte.Id_Patologia = h_atencion.Codigo_Dxp) INNER JOIN g_persona  ON (g_usuario.Id_persona = g_persona.Id) INNER JOIN g_empresacont  ON (g_usuario.Id_EmpresaCont = g_empresacont.Id_empresa) INNER JOIN g_municipio  ON (g_persona.Id_Municipio = g_municipio.Id) INNER JOIN g_departamento  ON (g_municipio.Id_Dpto = g_departamento.Id)  INNER JOIN f_empresacontxconvenio  ON (f_empresacontxconvenio.Id_EmpresaCont = g_empresacont.Id_empresa) INNER JOIN g_patologia  ON (r_patologiasreporte.Id_Patologia = g_patologia.Id) WHERE (h_atencion.Fecha_Atencion >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND h_atencion.Fecha_Atencion <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' AND r_patologiasreporte.Id_TipoEntidadR ='" + this.xidtipoentidad[this.JCBTipoEntidad.getSelectedIndex()] + "')  GROUP BY persona.NoHistoria ";
                }
            } else if (this.JRBDxR1.isSelected()) {
                if (Principal.informacionIps.getEsFpz().intValue() == 0) {
                    sql = "SELECT h_atencion.Id, persona.NoHistoria, persona.Id_TipoIdentificacion, persona.NoDocumento, persona.NUsuario, DATE_FORMAT(persona.FechaNac,'%d-%m-%Y')  AS FechaNac , persona.Edad, persona.NTipoEdad, persona.IdSexo, '' AS Departamento , persona.NMunicipio , persona.NBarrio , persona.Direccion , persona.Telefono , g_tipoempresa.Nbre , g_parentesco.Nbre , f_empresacontxconvenio.Nbre , r_patologiasreporte.Id_Patologia , g_patologia.Nbre , persona.Id_persona  FROM  r_patologiasreporte INNER JOIN h_atencion  ON (r_patologiasreporte.Id_Patologia = h_atencion.Codigo_DxR1) INNER JOIN ingreso  ON (h_atencion.Id_Ingreso = ingreso.Id)  INNER JOIN persona  ON (persona.Id_persona = ingreso.Id_Usuario) INNER JOIN g_usuario_fpz  ON (g_usuario_fpz.Id_Persona = persona.Id_persona) INNER JOIN g_tipoempresa  ON (g_usuario_fpz.Id_Empresa = g_tipoempresa.Id) INNER JOIN g_parentesco  ON (g_parentesco.Id = g_usuario_fpz.Id_Parentesco) INNER JOIN f_empresacontxconvenio  ON (ingreso.Id_EmpresaContxConv = f_empresacontxconvenio.Id) INNER JOIN g_patologia  ON (r_patologiasreporte.Id_Patologia = g_patologia.Id) WHERE (h_atencion.Fecha_Atencion >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND h_atencion.Fecha_Atencion <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' AND r_patologiasreporte.Id_TipoEntidadR ='" + this.xidtipoentidad[this.JCBTipoEntidad.getSelectedIndex()] + "')  GROUP BY persona.NoHistoria  ";
                } else {
                    sql = "SELECT h_atencion.Id, persona.NoHistoria, persona.Id_TipoIdentificacion, persona.NoDocumento, persona.NUsuario, DATE_FORMAT(g_persona.FechaNac,'%d-%m-%Y') AS FechaNac, persona.Edad, persona.NTipoEdad, persona.IdSexo , UCASE(g_departamento.Nbre) AS Dpto, g_municipio.Nbre AS NMunicipio, persona.NBarrio, persona.Direccion, persona.Telefono, '', '', f_empresacontxconvenio.Nbre, g_patologia.Id, g_patologia.Nbre, persona.Id_persona FROM h_atencion INNER JOIN ingreso  ON (h_atencion.Id_Ingreso = ingreso.Id) INNER JOIN persona  ON (ingreso.Id_Usuario = persona.Id_persona) INNER JOIN g_usuario  ON (ingreso.Id_Usuario = g_usuario.Id_persona) INNER JOIN r_patologiasreporte  ON (r_patologiasreporte.Id_Patologia = h_atencion.Codigo_DxR1) INNER JOIN g_persona  ON (g_usuario.Id_persona = g_persona.Id) INNER JOIN g_empresacont  ON (g_usuario.Id_EmpresaCont = g_empresacont.Id_empresa) INNER JOIN g_municipio  ON (g_persona.Id_Municipio = g_municipio.Id) INNER JOIN g_departamento  ON (g_municipio.Id_Dpto = g_departamento.Id)  INNER JOIN f_empresacontxconvenio  ON (f_empresacontxconvenio.Id_EmpresaCont = g_empresacont.Id_empresa) INNER JOIN g_patologia  ON (r_patologiasreporte.Id_Patologia = g_patologia.Id) WHERE (h_atencion.Fecha_Atencion >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND h_atencion.Fecha_Atencion <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' AND r_patologiasreporte.Id_TipoEntidadR ='" + this.xidtipoentidad[this.JCBTipoEntidad.getSelectedIndex()] + "')  GROUP BY persona.NoHistoria ";
                }
            } else if (this.JRBDxR2.isSelected()) {
                if (Principal.informacionIps.getEsFpz().intValue() == 0) {
                    sql = "SELECT h_atencion.Id, persona.NoHistoria, persona.Id_TipoIdentificacion, persona.NoDocumento, persona.NUsuario, DATE_FORMAT(persona.FechaNac,'%d-%m-%Y')  AS FechaNac , persona.Edad, persona.NTipoEdad, persona.IdSexo, '' AS Departamento , persona.NMunicipio , persona.NBarrio , persona.Direccion , persona.Telefono , g_tipoempresa.Nbre , g_parentesco.Nbre , f_empresacontxconvenio.Nbre , r_patologiasreporte.Id_Patologia , g_patologia.Nbre , persona.Id_persona  FROM  r_patologiasreporte INNER JOIN h_atencion  ON (r_patologiasreporte.Id_Patologia = h_atencion.Codigo_DxR2) INNER JOIN ingreso  ON (h_atencion.Id_Ingreso = ingreso.Id)  INNER JOIN persona  ON (persona.Id_persona = ingreso.Id_Usuario) INNER JOIN g_usuario_fpz  ON (g_usuario_fpz.Id_Persona = persona.Id_persona) INNER JOIN g_tipoempresa  ON (g_usuario_fpz.Id_Empresa = g_tipoempresa.Id) INNER JOIN g_parentesco  ON (g_parentesco.Id = g_usuario_fpz.Id_Parentesco) INNER JOIN f_empresacontxconvenio  ON (ingreso.Id_EmpresaContxConv = f_empresacontxconvenio.Id) INNER JOIN g_patologia  ON (r_patologiasreporte.Id_Patologia = g_patologia.Id) WHERE (h_atencion.Fecha_Atencion >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND h_atencion.Fecha_Atencion <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' AND r_patologiasreporte.Id_TipoEntidadR ='" + this.xidtipoentidad[this.JCBTipoEntidad.getSelectedIndex()] + "') GROUP BY persona.NoHistoria  ORDER BY h_atencion.Fecha_Atencion ASC ";
                } else {
                    sql = "SELECT h_atencion.Id, persona.NoHistoria, persona.Id_TipoIdentificacion, persona.NoDocumento, persona.NUsuario, DATE_FORMAT(g_persona.FechaNac,'%d-%m-%Y') AS FechaNac, persona.Edad, persona.NTipoEdad, persona.IdSexo , UCASE(g_departamento.Nbre) AS Dpto, g_municipio.Nbre AS NMunicipio, persona.NBarrio, persona.Direccion, persona.Telefono, '', '', f_empresacontxconvenio.Nbre, g_patologia.Id, g_patologia.Nbre, persona.Id_persona FROM h_atencion INNER JOIN ingreso  ON (h_atencion.Id_Ingreso = ingreso.Id) INNER JOIN persona  ON (ingreso.Id_Usuario = persona.Id_persona) INNER JOIN g_usuario  ON (ingreso.Id_Usuario = g_usuario.Id_persona) INNER JOIN r_patologiasreporte  ON (r_patologiasreporte.Id_Patologia = h_atencion.Codigo_DxR2) INNER JOIN g_persona  ON (g_usuario.Id_persona = g_persona.Id) INNER JOIN g_empresacont  ON (g_usuario.Id_EmpresaCont = g_empresacont.Id_empresa) INNER JOIN g_municipio  ON (g_persona.Id_Municipio = g_municipio.Id) INNER JOIN g_departamento  ON (g_municipio.Id_Dpto = g_departamento.Id)  INNER JOIN f_empresacontxconvenio  ON (f_empresacontxconvenio.Id_EmpresaCont = g_empresacont.Id_empresa) INNER JOIN g_patologia  ON (r_patologiasreporte.Id_Patologia = g_patologia.Id) WHERE (h_atencion.Fecha_Atencion >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND h_atencion.Fecha_Atencion <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' AND r_patologiasreporte.Id_TipoEntidadR ='" + this.xidtipoentidad[this.JCBTipoEntidad.getSelectedIndex()] + "')  GROUP BY persona.NoHistoria ";
                }
            } else if (this.JRBDxR3.isSelected()) {
                if (Principal.informacionIps.getEsFpz().intValue() == 0) {
                    sql = "SELECT h_atencion.Id, persona.NoHistoria, persona.Id_TipoIdentificacion, persona.NoDocumento, persona.NUsuario, DATE_FORMAT(persona.FechaNac,'%d-%m-%Y')  AS FechaNac , persona.Edad, persona.NTipoEdad, persona.IdSexo, '' AS Departamento , persona.NMunicipio , persona.NBarrio , persona.Direccion , persona.Telefono , g_tipoempresa.Nbre , g_parentesco.Nbre , f_empresacontxconvenio.Nbre , r_patologiasreporte.Id_Patologia , g_patologia.Nbre , persona.Id_persona  FROM  r_patologiasreporte INNER JOIN h_atencion  ON (r_patologiasreporte.Id_Patologia = h_atencion.Codigo_DxR3) INNER JOIN ingreso  ON (h_atencion.Id_Ingreso = ingreso.Id)  INNER JOIN persona  ON (persona.Id_persona = ingreso.Id_Usuario) INNER JOIN g_usuario_fpz  ON (g_usuario_fpz.Id_Persona = persona.Id_persona) INNER JOIN g_tipoempresa  ON (g_usuario_fpz.Id_Empresa = g_tipoempresa.Id) INNER JOIN g_parentesco  ON (g_parentesco.Id = g_usuario_fpz.Id_Parentesco) INNER JOIN f_empresacontxconvenio  ON (ingreso.Id_EmpresaContxConv = f_empresacontxconvenio.Id) INNER JOIN g_patologia  ON (r_patologiasreporte.Id_Patologia = g_patologia.Id) WHERE (h_atencion.Fecha_Atencion >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND h_atencion.Fecha_Atencion <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' AND r_patologiasreporte.Id_TipoEntidadR ='" + this.xidtipoentidad[this.JCBTipoEntidad.getSelectedIndex()] + "') GROUP BY persona.NoHistoria  ORDER BY h_atencion.Fecha_Atencion ASC ";
                } else {
                    sql = "SELECT h_atencion.Id, persona.NoHistoria, persona.Id_TipoIdentificacion, persona.NoDocumento, persona.NUsuario, DATE_FORMAT(g_persona.FechaNac,'%d-%m-%Y') AS FechaNac, persona.Edad, persona.NTipoEdad, persona.IdSexo , UCASE(g_departamento.Nbre) AS Dpto, g_municipio.Nbre AS NMunicipio, persona.NBarrio, persona.Direccion, persona.Telefono, '', '', f_empresacontxconvenio.Nbre, g_patologia.Id, g_patologia.Nbre, persona.Id_persona FROM h_atencion INNER JOIN ingreso  ON (h_atencion.Id_Ingreso = ingreso.Id) INNER JOIN persona  ON (ingreso.Id_Usuario = persona.Id_persona) INNER JOIN g_usuario  ON (ingreso.Id_Usuario = g_usuario.Id_persona) INNER JOIN r_patologiasreporte  ON (r_patologiasreporte.Id_Patologia = h_atencion.Codigo_DxR3) INNER JOIN g_persona  ON (g_usuario.Id_persona = g_persona.Id) INNER JOIN g_empresacont  ON (g_usuario.Id_EmpresaCont = g_empresacont.Id_empresa) INNER JOIN g_municipio  ON (g_persona.Id_Municipio = g_municipio.Id) INNER JOIN g_departamento  ON (g_municipio.Id_Dpto = g_departamento.Id)  INNER JOIN f_empresacontxconvenio  ON (f_empresacontxconvenio.Id_EmpresaCont = g_empresacont.Id_empresa) INNER JOIN g_patologia  ON (r_patologiasreporte.Id_Patologia = g_patologia.Id) WHERE (h_atencion.Fecha_Atencion >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND h_atencion.Fecha_Atencion <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' AND r_patologiasreporte.Id_TipoEntidadR ='" + this.xidtipoentidad[this.JCBTipoEntidad.getSelectedIndex()] + "') GROUP BY persona.NoHistoria  ";
                }
            }
            System.out.println("Uno   " + sql);
            ResultSet rs = this.xct.traerRs(sql);
            rs.next();
            if (rs.getRow() != 0) {
                rs.beforeFirst();
                int i = 0;
                while (rs.next()) {
                    this.xmodelo2.addRow(this.xdato);
                    this.xmodelo2.setValueAt(Long.valueOf(rs.getLong(1)), i, 0);
                    this.xmodelo2.setValueAt(rs.getString(2), i, 1);
                    this.xmodelo2.setValueAt(rs.getString(3), i, 2);
                    this.xmodelo2.setValueAt(rs.getString(4), i, 3);
                    this.xmodelo2.setValueAt(rs.getString(5), i, 4);
                    this.xmodelo2.setValueAt(rs.getString(6), i, 5);
                    this.xmodelo2.setValueAt(Long.valueOf(rs.getLong(7)), i, 6);
                    this.xmodelo2.setValueAt(rs.getString(8), i, 7);
                    this.xmodelo2.setValueAt(rs.getString(9), i, 8);
                    this.xmodelo2.setValueAt(rs.getString(10), i, 9);
                    this.xmodelo2.setValueAt(rs.getString(11), i, 10);
                    this.xmodelo2.setValueAt(rs.getString(12), i, 11);
                    this.xmodelo2.setValueAt(rs.getString(13), i, 12);
                    this.xmodelo2.setValueAt(rs.getString(14), i, 13);
                    this.xmodelo2.setValueAt(rs.getString(15), i, 14);
                    this.xmodelo2.setValueAt(rs.getString(16), i, 15);
                    this.xmodelo2.setValueAt(rs.getString(17), i, 16);
                    this.xmodelo2.setValueAt(rs.getString(18), i, 17);
                    this.xmodelo2.setValueAt(rs.getString(19), i, 18);
                    this.xmodelo2.setValueAt(rs.getString(20), i, 19);
                    i++;
                }
                Principal.txtNo.setText("" + i);
            }
            rs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFConsultarInfCove.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarDatosTabla2() {
        String sql;
        try {
            mCrearTabla2();
            if (this.JCHFiltroSede.isSelected()) {
                sql = "SELECT\n\th_atencion.Id,\n\t`g_usuario`.`NoHistoria`,\n\t`g_persona`.`Id_TipoIdentificacion`,\n\t`g_persona`.`NoDocumento`,\n\tconcat(`g_persona`.`Apellido1`,' ',`g_persona`.`Apellido2`,' ',`g_persona`.`Nombre1`,' ',`g_persona`.`Nombre2`) AS `NUsuario`,\n\tDATE_FORMAT(`g_persona`.FechaNac, '%d-%m-%Y') AS FechaNac ,\n\t`g_persona`.`Edad`,\n\t`g_tipoedad`.`Nbre` as NTipoEdad,\n\t`g_persona`.`Id_Sexo` as IdSexo,\n\t'' AS Departamento ,\n\t`g_municipio`.`Nbre` as NMunicipio ,\n\t`g_barrio`.`Nbre` as NBarrio ,\n\tifnull(`g_persona`.`Direccion`,'') as Direccion ,\n\t`g_persona`.`Movil` as Telefono ,\n\tg_tipoempresa.Nbre ,\n\tg_parentesco.Nbre ,\n\tf_empresacontxconvenio.Nbre ,\n\tr_patologiasreporte.Id_Patologia ,\n\tg_patologia.Nbre ,\n\t`g_persona`.`Id` as Id_persona\nFROM\n\th_atencion\nINNER JOIN h_atenciondx ON\n\t(h_atenciondx.Id_Atencion = h_atencion.Id)\nINNER JOIN r_patologiasreporte ON\n\t(r_patologiasreporte.Id_Patologia = h_atenciondx.Id_Dx)\nINNER JOIN ingreso ON\n\t(h_atencion.Id_Ingreso = ingreso.Id)\nINNER JOIN `g_persona` ON\n\t(`g_persona`.`Id` = ingreso.Id_Usuario)\ninner join `g_usuario` ON\n\t(`g_usuario`.`Id_persona`=`g_persona`.`Id`)\ninner join `g_tipoedad` on \n\t(`g_tipoedad`.`Id` = `g_persona`.`Id_TipoEdad`)\ninner join `g_municipio` on\n\t(`g_municipio`.`Id` = `g_persona`.`Id_Municipio`)\ninner join `g_barrio` on\n\t(`g_barrio`.`Id` = `g_persona`.`Id_Barrio`)\nLEFT JOIN g_usuario_fpz ON\n\t(g_usuario_fpz.Id_Persona = `g_persona`.`Id`)\nLEFT JOIN g_tipoempresa ON\n\t(g_usuario_fpz.Id_Empresa = g_tipoempresa.Id)\nLEFT JOIN g_parentesco ON\n\t(g_parentesco.Id = g_usuario_fpz.Id_Parentesco)\nINNER JOIN f_empresacontxconvenio ON\n\t(ingreso.Id_EmpresaContxConv = f_empresacontxconvenio.Id)\nINNER JOIN g_patologia ON\n\t(r_patologiasreporte.Id_Patologia = g_patologia.Id)\nWHERE\n\t(h_atencion.Fecha_Atencion >= '" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "'\n\t\tAND h_atencion.Fecha_Atencion <= '" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "'\n\t\tAND r_patologiasreporte.Id_TipoEntidadR = '" + this.xidtipoentidad[this.JCBTipoEntidad.getSelectedIndex()] + "')\nGROUP BY\n\t`g_usuario`.`NoHistoria`\nORDER BY\n\th_atencion.Fecha_Atencion ASC";
            } else {
                sql = "SELECT\n\th_atencion.Id,\n\t`g_usuario`.`NoHistoria`,\n\t`g_persona`.`Id_TipoIdentificacion`,\n\t`g_persona`.`NoDocumento`,\n\tconcat(`g_persona`.`Apellido1`,' ',`g_persona`.`Apellido2`,' ',`g_persona`.`Nombre1`,' ',`g_persona`.`Nombre2`) AS `NUsuario`,\n\tDATE_FORMAT(`g_persona`.FechaNac, '%d-%m-%Y') AS FechaNac ,\n\t`g_persona`.`Edad`,\n\t`g_tipoedad`.`Nbre` as NTipoEdad,\n\t`g_persona`.`Id_Sexo` as IdSexo,\n\t'' AS Departamento ,\n\t`g_municipio`.`Nbre` as NMunicipio ,\n\t`g_barrio`.`Nbre` as NBarrio ,\n\tifnull(`g_persona`.`Direccion`,'') as Direccion ,\n\t`g_persona`.`Movil` as Telefono ,\n\tg_tipoempresa.Nbre ,\n\tg_parentesco.Nbre ,\n\tf_empresacontxconvenio.Nbre ,\n\tr_patologiasreporte.Id_Patologia ,\n\tg_patologia.Nbre ,\n\t`g_persona`.`Id` as Id_persona\nFROM\n\th_atencion\nINNER JOIN h_atenciondx ON\n\t(h_atenciondx.Id_Atencion = h_atencion.Id)\nINNER JOIN r_patologiasreporte ON\n\t(r_patologiasreporte.Id_Patologia = h_atenciondx.Id_Dx)\nINNER JOIN ingreso ON\n\t(h_atencion.Id_Ingreso = ingreso.Id)\nINNER JOIN `g_persona` ON\n\t(`g_persona`.`Id` = ingreso.Id_Usuario)\ninner join `g_usuario` ON\n\t(`g_usuario`.`Id_persona`=`g_persona`.`Id`)\ninner join `g_tipoedad` on \n\t(`g_tipoedad`.`Id` = `g_persona`.`Id_TipoEdad`)\ninner join `g_municipio` on\n\t(`g_municipio`.`Id` = `g_persona`.`Id_Municipio`)\ninner join `g_barrio` on\n\t(`g_barrio`.`Id` = `g_persona`.`Id_Barrio`)\nLEFT JOIN g_usuario_fpz ON\n\t(g_usuario_fpz.Id_Persona = `g_persona`.`Id`)\nLEFT JOIN g_tipoempresa ON\n\t(g_usuario_fpz.Id_Empresa = g_tipoempresa.Id)\nLEFT JOIN g_parentesco ON\n\t(g_parentesco.Id = g_usuario_fpz.Id_Parentesco)\nINNER JOIN f_empresacontxconvenio ON\n\t(ingreso.Id_EmpresaContxConv = f_empresacontxconvenio.Id)\nINNER JOIN g_patologia ON\n\t(r_patologiasreporte.Id_Patologia = g_patologia.Id)\nWHERE\n\t(h_atencion.Fecha_Atencion >= '" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "'\n\t\tAND h_atencion.Fecha_Atencion <= '" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "')\nGROUP BY\n\t`g_usuario`.`NoHistoria`\nORDER BY\n\th_atencion.Fecha_Atencion ASC";
            }
            System.out.println("Consolidado por usuarios   " + sql);
            ResultSet rs = this.xct.traerRs(sql);
            rs.next();
            if (rs.getRow() != 0) {
                rs.beforeFirst();
                int i = 0;
                while (rs.next()) {
                    this.xmodelo2.addRow(this.xdato);
                    this.xmodelo2.setValueAt(Long.valueOf(rs.getLong(1)), i, 0);
                    this.xmodelo2.setValueAt(rs.getString(2), i, 1);
                    this.xmodelo2.setValueAt(rs.getString(3), i, 2);
                    this.xmodelo2.setValueAt(rs.getString(4), i, 3);
                    this.xmodelo2.setValueAt(rs.getString(5), i, 4);
                    this.xmodelo2.setValueAt(rs.getString(6), i, 5);
                    this.xmodelo2.setValueAt(Long.valueOf(rs.getLong(7)), i, 6);
                    this.xmodelo2.setValueAt(rs.getString(8), i, 7);
                    this.xmodelo2.setValueAt(rs.getString(9), i, 8);
                    this.xmodelo2.setValueAt(rs.getString(10), i, 9);
                    this.xmodelo2.setValueAt(rs.getString(11), i, 10);
                    this.xmodelo2.setValueAt(rs.getString(12), i, 11);
                    this.xmodelo2.setValueAt(rs.getString(13), i, 12);
                    this.xmodelo2.setValueAt(rs.getString(14), i, 13);
                    this.xmodelo2.setValueAt(rs.getString(15), i, 14);
                    this.xmodelo2.setValueAt(rs.getString(16), i, 15);
                    this.xmodelo2.setValueAt(rs.getString(17), i, 16);
                    this.xmodelo2.setValueAt(rs.getString(18), i, 17);
                    this.xmodelo2.setValueAt(rs.getString(19), i, 18);
                    this.xmodelo2.setValueAt(rs.getString(20), i, 19);
                    this.xmodelo2.setValueAt(mBuscarDatosExamen1("903841", "283", rs.getString(20), i), i, 20);
                    this.xmodelo2.setValueAt(mBuscarDatosProgramaExamen(rs.getString(20)), i, 23);
                    this.xmodelo2.setValueAt(mBuscarDatosConsulta(rs.getString(20), "451"), i, 24);
                    mDatosExamenFisico(rs.getString(20), this.xmodelo2, i, 25);
                    mDatosNutricionales(rs.getString(20), this.xmodelo2, i, 30);
                    mDatosMedicamentoPAMetformina(rs.getString(20), this.xmodelo2, i, 44, 186);
                    i++;
                }
            }
            rs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFConsultarInfCove.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarDatosTabla3() {
        try {
            mCrearTabla3();
            String sql = "SELECT h_atencion.Id, g_usuario.`NoHistoria`, g_persona.Id_TipoIdentificacion, g_persona.NoDocumento,  CONCAT(g_persona.`Apellido1`,' ',g_persona.`Apellido2`,' ',g_persona.`Nombre1` ,' ',g_persona.`Nombre1` ) AS NUsuario, DATE_FORMAT(g_persona.FechaNac,'%d-%m-%Y')  AS FechaNac , `Devuelve_Edad_2F`(g_persona.FechaNac,h_atencion.`Fecha_Atencion`) AS Edad,  `Devuelve_Tipo_Edad_2F`(g_persona.FechaNac,h_atencion.`Fecha_Atencion`) AS NTipoEdad, g_persona.`Id_Sexo` AS IdSexo ,g_departamento.`Nbre` AS  Departamento , g_municipio.`Nbre` AS NMunicipio , g_barrio.`Nbre` AS NBarrio , g_persona.Direccion , g_persona.Telefono , g_tipoempresa.Nbre , g_parentesco.Nbre ,  f_empresacontxconvenio.Nbre , r_patologiasreporte.Id_Patologia , g_patologia.Nbre , g_persona.`Id` AS Id_persona   FROM   h_atenciondx  INNER JOIN h_atencion  ON (h_atencion.`Id`= `h_atenciondx`.`Id_Atencion`)   INNER JOIN  r_patologiasreporte  ON (r_patologiasreporte.Id_Patologia = `h_atenciondx`.`Id_Dx`)   INNER JOIN ingreso  ON (h_atencion.Id_Ingreso = ingreso.Id)   INNER JOIN `g_persona`  ON (g_persona.`Id` = ingreso.Id_Usuario)  INNER JOIN `g_usuario`  ON (g_persona.`Id` = g_usuario.`Id_persona`)  INNER JOIN `g_barrio`  ON (g_persona.`Id_Barrio` = g_barrio.`Id`)  INNER JOIN `g_municipio`  ON (g_persona.`Id_Municipio` = g_municipio.`Id`)  INNER JOIN `g_departamento` ON (g_departamento.`Id` = g_municipio.`Id_Dpto`)  LEFT JOIN g_usuario_fpz  ON (g_usuario_fpz.Id_Persona = g_persona.Id) LEFT JOIN g_tipoempresa  ON (g_usuario_fpz.Id_Empresa = g_tipoempresa.Id)  LEFT JOIN g_parentesco  ON (g_parentesco.Id = g_usuario_fpz.Id_Parentesco) INNER JOIN f_empresacontxconvenio  ON (ingreso.Id_EmpresaContxConv = f_empresacontxconvenio.Id) INNER JOIN g_patologia  ON (r_patologiasreporte.Id_Patologia = g_patologia.Id)  WHERE (h_atencion.Fecha_Atencion >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND h_atencion.Fecha_Atencion <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "'  AND r_patologiasreporte.Id_TipoEntidadR ='" + this.xidtipoentidad[this.JCBTipoEntidad.getSelectedIndex()] + "') GROUP BY g_usuario.`NoHistoria` ORDER BY h_atencion.Fecha_Atencion ASC ";
            System.out.println("tres   " + sql);
            ResultSet rs = this.xct.traerRs(sql);
            rs.next();
            if (rs.getRow() != 0) {
                rs.beforeFirst();
                int i = 0;
                while (rs.next()) {
                    this.xmodelo2.addRow(this.xdato);
                    this.xmodelo2.setValueAt(Long.valueOf(rs.getLong(1)), i, 0);
                    this.xmodelo2.setValueAt(rs.getString(2), i, 1);
                    this.xmodelo2.setValueAt(rs.getString(3), i, 2);
                    this.xmodelo2.setValueAt(rs.getString(4), i, 3);
                    this.xmodelo2.setValueAt(rs.getString(5), i, 4);
                    this.xmodelo2.setValueAt(rs.getString(6), i, 5);
                    this.xmodelo2.setValueAt(Long.valueOf(rs.getLong(7)), i, 6);
                    this.xmodelo2.setValueAt(rs.getString(8), i, 7);
                    this.xmodelo2.setValueAt(rs.getString(9), i, 8);
                    this.xmodelo2.setValueAt(rs.getString(10), i, 9);
                    this.xmodelo2.setValueAt(rs.getString(11), i, 10);
                    this.xmodelo2.setValueAt(rs.getString(12), i, 11);
                    this.xmodelo2.setValueAt(rs.getString(13), i, 12);
                    this.xmodelo2.setValueAt(rs.getString(14), i, 13);
                    this.xmodelo2.setValueAt(rs.getString(15), i, 14);
                    this.xmodelo2.setValueAt(rs.getString(16), i, 15);
                    this.xmodelo2.setValueAt(rs.getString(17), i, 16);
                    this.xmodelo2.setValueAt(rs.getString(18), i, 17);
                    this.xmodelo2.setValueAt(rs.getString(19), i, 18);
                    this.xmodelo2.setValueAt(rs.getString(20), i, 19);
                    this.xmodelo2.setValueAt(mBuscarDatosExamen2("903818", "55", rs.getString(20), i, 20), i, 20);
                    this.xmodelo2.setValueAt(mBuscarDatosExamen2("903815", "56", rs.getString(20), i, 22), i, 22);
                    this.xmodelo2.setValueAt(mBuscarDatosExamen2("903816", "57", rs.getString(20), i, 24), i, 24);
                    this.xmodelo2.setValueAt(mBuscarDatosExamen2("903868", "59", rs.getString(20), i, 26), i, 26);
                    this.xmodelo2.setValueAt(mBuscarDatosProgramaExamen(rs.getString(20)), i, 28);
                    this.xmodelo2.setValueAt(mBuscarDatosConsulta(rs.getString(20), "451"), i, 29);
                    mDatosExamenFisico(rs.getString(20), this.xmodelo2, i, 30);
                    mDatosNutricionales(rs.getString(20), this.xmodelo2, i, 35);
                    mDatosMedicamentoPLipido(rs.getString(20), this.xmodelo2, i, 49);
                    i++;
                }
            }
            rs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFConsultarInfCove.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarDatosTabla1() {
        String sql;
        try {
            String xRelacion = "";
            mCrearTabla1();
            String xSede = this.JCHFiltroSede.isSelected() ? " AND ingreso.Id_Sede='" + this.xidsede[this.JCBSede.getSelectedIndex()] + "' " : "";
            if (this.JCH_Todos.isSelected()) {
                sql = "SELECT g_patologia.Id, g_patologia.Nbre, count(g_patologia.Id) AS Cant FROM  h_atenciondx  INNER JOIN h_atencion  ON (h_atencion.`Id`= `h_atenciondx`.`Id_Atencion`)   INNER JOIN  r_patologiasreporte  ON (r_patologiasreporte.Id_Patologia = `h_atenciondx`.`Id_Dx`)  INNER JOIN ingreso  ON (h_atencion.Id_Ingreso = ingreso.Id)  INNER JOIN g_patologia  ON (r_patologiasreporte.Id_Patologia = g_patologia.Id) WHERE (h_atencion.Fecha_Atencion >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND h_atencion.Fecha_Atencion <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' AND r_patologiasreporte.Id_TipoEntidadR ='" + this.xidtipoentidad[this.JCBTipoEntidad.getSelectedIndex()] + "'" + xSede + ") GROUP BY g_patologia.Id ORDER BY count(g_patologia.Id) desc ";
            } else {
                if (this.JRBDxP.isSelected()) {
                    xRelacion = "r_patologiasreporte.Id_Patologia = `h_atencion`.`Codigo_Dxp`";
                } else if (this.JRBDxR1.isSelected()) {
                    xRelacion = "r_patologiasreporte.Id_Patologia = `h_atencion`.`Codigo_DxR1`";
                } else if (this.JRBDxR2.isSelected()) {
                    xRelacion = "r_patologiasreporte.Id_Patologia = `h_atencion`.`Codigo_DxR2`";
                } else if (this.JRBDxR3.isSelected()) {
                    xRelacion = "r_patologiasreporte.Id_Patologia = `h_atencion`.`Codigo_DxR3`";
                }
                sql = "SELECT g_patologia.Id, g_patologia.Nbre, count(g_patologia.Id) AS Cant FROM h_atencion INNER JOIN ingreso  ON (h_atencion.Id_Ingreso = ingreso.Id) INNER JOIN r_patologiasreporte  ON (" + xRelacion + ") INNER JOIN g_patologia  ON (r_patologiasreporte.Id_Patologia = g_patologia.Id) WHERE ( h_atencion.Fecha_Atencion >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND h_atencion.Fecha_Atencion <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' AND r_patologiasreporte.Id_TipoEntidadR ='" + this.xidtipoentidad[this.JCBTipoEntidad.getSelectedIndex()] + "'" + xSede + ") GROUP BY g_patologia.Id ORDER BY count(g_patologia.Id) desc ";
            }
            ResultSet rs = this.xct.traerRs(sql);
            System.out.println("Dos " + sql);
            rs.next();
            if (rs.getRow() != 0) {
                rs.beforeFirst();
                int i = 0;
                while (rs.next()) {
                    this.xmodelo1.addRow(this.xdato);
                    this.xmodelo1.setValueAt(rs.getString(1), i, 0);
                    this.xmodelo1.setValueAt(rs.getString(2), i, 1);
                    this.xmodelo1.setValueAt(Long.valueOf(rs.getLong(3)), i, 2);
                    i++;
                }
            }
            rs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFConsultarInfCove.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mBuscar() {
        if (this.JCBTipoEntidad.getSelectedIndex() != -1) {
            if (this.JCHFiltroSede.isSelected()) {
                if (this.JCBSede.getSelectedIndex() != -1) {
                    mCargarDatosTabla();
                    mCargarDatosTabla1();
                    if (this.xidtipoentidad[this.JCBTipoEntidad.getSelectedIndex()].equals("12")) {
                        mCargarDatosTabla2();
                        return;
                    }
                    if (this.xidtipoentidad[this.JCBTipoEntidad.getSelectedIndex()].equals("11")) {
                        mCargarDatosTabla3();
                        return;
                    } else if (this.xidtipoentidad[this.JCBTipoEntidad.getSelectedIndex()].equals("14")) {
                        mCargarDatosTabla4();
                        return;
                    } else {
                        mCargarDatosTabla_1();
                        return;
                    }
                }
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar la sede", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                this.JCBSede.requestFocus();
                return;
            }
            mCargarDatosTabla();
            mCargarDatosTabla1();
            if (this.xidtipoentidad[this.JCBTipoEntidad.getSelectedIndex()].equals("12")) {
                mCargarDatosTabla2();
                return;
            }
            if (this.xidtipoentidad[this.JCBTipoEntidad.getSelectedIndex()].equals("11")) {
                mCargarDatosTabla3();
                return;
            } else if (this.xidtipoentidad[this.JCBTipoEntidad.getSelectedIndex()].equals("14")) {
                mCargarDatosTabla4();
                return;
            } else {
                mCargarDatosTabla_1();
                return;
            }
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un tipo entidad", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        this.JCBTipoEntidad.requestFocus();
    }

    private String mBuscarDatosExamen(String xprocedimiento, String xprotocolo, String xidusuario) {
        String xdatox = "0";
        ConsultasMySQL xct2 = new ConsultasMySQL();
        this.xsql = "SELECT l_detalleresultado.VrNumerico FROM l_resultados INNER JOIN l_recepcion  ON (l_resultados.Id_Recepcion = l_recepcion.Id) INNER JOIN l_detalleresultado  ON (l_detalleresultado.Id_Resultado = l_resultados.Id) INNER JOIN l_protocoloxprocedimiento  ON (l_detalleresultado.Id_ProtocolProcedim = l_protocoloxprocedimiento.Id) INNER JOIN l_protocolos  ON (l_protocoloxprocedimiento.Id_Protocolo = l_protocolos.Id) INNER JOIN persona  ON (persona.Id_persona = l_recepcion.Id_Paciente) INNER JOIN g_procedimiento  ON (l_protocoloxprocedimiento.Id_Procedim = g_procedimiento.Id) WHERE (g_procedimiento.Id ='" + xprocedimiento + "' AND l_protocolos.Id ='" + xprotocolo + "' AND l_recepcion.Id_Paciente ='" + xidusuario + "' ) GROUP BY l_resultados.FechaResult, l_protocolos.Id ORDER BY l_resultados.FechaResult DESC ";
        ResultSet xrs1 = xct2.traerRs(this.xsql);
        try {
            if (xrs1.next()) {
                xrs1.first();
                xdatox = xrs1.getString(1);
            }
            xrs1.close();
            xct2.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFInformesPyP.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return xdatox;
    }

    private String mBuscarDatosExamen1(String xprocedimiento, String xprotocolo, String xidusuario, int xpos) {
        String xdatox = "0";
        ConsultasMySQL xct2 = new ConsultasMySQL();
        this.xsql = "SELECT l_detalleresultado.VrNumerico FROM l_resultados INNER JOIN l_recepcion  ON (l_resultados.Id_Recepcion = l_recepcion.Id) INNER JOIN l_detalleresultado  ON (l_detalleresultado.Id_Resultado = l_resultados.Id) INNER JOIN l_protocoloxprocedimiento  ON (l_detalleresultado.Id_ProtocolProcedim = l_protocoloxprocedimiento.Id) INNER JOIN l_protocolos  ON (l_protocoloxprocedimiento.Id_Protocolo = l_protocolos.Id) INNER JOIN persona  ON (persona.Id_persona = l_recepcion.Id_Paciente) INNER JOIN g_procedimiento  ON (l_protocoloxprocedimiento.Id_Procedim = g_procedimiento.Id) WHERE (g_procedimiento.Id ='" + xprocedimiento + "' AND l_protocolos.Id ='" + xprotocolo + "' AND l_recepcion.Id_Paciente ='" + xidusuario + "' ) GROUP BY l_resultados.FechaResult, l_protocolos.Id ORDER BY l_resultados.FechaResult DESC ";
        ResultSet xrs1 = xct2.traerRs(this.xsql);
        System.out.println(" glucosa :  " + this.xsql);
        try {
            if (xrs1.next()) {
                xrs1.last();
                System.out.println(xrs1.getRow());
                if (xrs1.getRow() == 1) {
                    xrs1.first();
                    xdatox = xrs1.getString(1);
                    this.xmodelo2.setValueAt("0", xpos, 21);
                    this.xmodelo2.setValueAt("0", xpos, 22);
                } else if (xrs1.getRow() == 2) {
                    xrs1.first();
                    xdatox = xrs1.getString(1);
                    xrs1.next();
                    this.xmodelo2.setValueAt(xrs1.getString(1), xpos, 21);
                    this.xmodelo2.setValueAt("0", xpos, 22);
                } else if (xrs1.getRow() >= 3) {
                    xrs1.first();
                    xdatox = xrs1.getString(1);
                    xrs1.next();
                    this.xmodelo2.setValueAt(xrs1.getString(1), xpos, 21);
                    xrs1.next();
                    this.xmodelo2.setValueAt(xrs1.getString(1), xpos, 22);
                }
            } else {
                this.xmodelo2.setValueAt("0", xpos, 21);
                this.xmodelo2.setValueAt("0", xpos, 22);
            }
            xrs1.close();
            xct2.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFInformesPyP.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return xdatox;
    }

    private String mBuscarDatosExamen2(String xprocedimiento, String xprotocolo, String xidusuario, int xpos, int xposcol) {
        String xdatox = "0";
        ConsultasMySQL xct2 = new ConsultasMySQL();
        this.xsql = "SELECT l_detalleresultado.VrNumerico FROM l_resultados INNER JOIN l_recepcion  ON (l_resultados.Id_Recepcion = l_recepcion.Id) INNER JOIN l_detalleresultado  ON (l_detalleresultado.Id_Resultado = l_resultados.Id) INNER JOIN l_protocoloxprocedimiento  ON (l_detalleresultado.Id_ProtocolProcedim = l_protocoloxprocedimiento.Id) INNER JOIN l_protocolos  ON (l_protocoloxprocedimiento.Id_Protocolo = l_protocolos.Id) INNER JOIN persona  ON (persona.Id_persona = l_recepcion.Id_Paciente) INNER JOIN g_procedimiento  ON (l_protocoloxprocedimiento.Id_Procedim = g_procedimiento.Id) WHERE (g_procedimiento.Id ='" + xprocedimiento + "' AND l_protocolos.Id ='" + xprotocolo + "' AND l_recepcion.Id_Paciente ='" + xidusuario + "' ) GROUP BY l_resultados.FechaResult, l_protocolos.Id ORDER BY l_resultados.FechaResult DESC ";
        ResultSet xrs1 = xct2.traerRs(this.xsql);
        try {
            if (xrs1.next()) {
                xrs1.last();
                if (xrs1.getRow() == 1) {
                    xrs1.first();
                    xdatox = xrs1.getString(1);
                    this.xmodelo2.setValueAt("0", xpos, xposcol + 1);
                } else if (xrs1.getRow() >= 2) {
                    xrs1.first();
                    xdatox = xrs1.getString(1);
                    xrs1.next();
                    this.xmodelo2.setValueAt(xrs1.getString(1), xpos, xposcol + 1);
                }
            } else {
                this.xmodelo2.setValueAt("0", xpos, xposcol + 1);
            }
            xrs1.close();
            xct2.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFInformesPyP.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return xdatox;
    }

    private String mBuscarDatosProgramaExamen(String xidusuario) {
        String xdatox = "NO VINCULADO";
        ConsultasMySQL xct2 = new ConsultasMySQL();
        this.xsql = "SELECT UCASE(g_tipoprograma.Nbre) AS NPrograma FROM g_usuarioxprograma INNER JOIN g_tipoprograma  ON (g_usuarioxprograma.Id_Programa = g_tipoprograma.Id_TipoPrograma) WHERE (g_usuarioxprograma.Id_Usuario ='" + xidusuario + "' AND g_usuarioxprograma.Estado =0) ";
        ResultSet xrs1 = xct2.traerRs(this.xsql);
        try {
            if (xrs1.next()) {
                xrs1.first();
                xdatox = xrs1.getString(1);
            }
            xrs1.close();
            xct2.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFInformesPyP.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return xdatox;
    }

    private String mBuscarDatosConsulta(String xidusuario, String xidespecialidad) {
        String xdatox = "NO TIENE ";
        ConsultasMySQL xct2 = new ConsultasMySQL();
        this.xsql = "SELECT IF(DATE_FORMAT(MAX(`h_atencion`.`Fecha_Atencion`),'%d-%m-%Y') IS NULL,'',DATE_FORMAT(MAX(`h_atencion`.`Fecha_Atencion`),'%d-%m-%Y'))  AS atencion FROM  `h_atencion` INNER JOIN `ingreso`  ON (`Id_Ingreso` = `ingreso`.`Id`) WHERE (`ingreso`.`Id_Usuario` ='" + xidusuario + "' AND `h_atencion`.`Id_Especialidad` ='" + xidespecialidad + "' AND `h_atencion`.`Codigo_Dxp` <>'0000' AND `h_atencion`.`Codigo_Dxp` <>'')";
        ResultSet xrs1 = xct2.traerRs(this.xsql);
        try {
            if (xrs1.next()) {
                xrs1.first();
                xdatox = xrs1.getString(1);
            } else {
                xdatox = "NO TIENE";
            }
            xrs1.close();
            xct2.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFInformesPyP.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return xdatox;
    }

    public void mDatosExamenFisico(String xidusuario, DefaultTableModel xmod, int xfila, int xcoluma) {
        try {
            this.xsql = "SELECT  `h_atencion`.`Fecha_Atencion` , `h_examenfisico`.`TArtSentadoD` , `h_examenfisico`.`TArtSentadoS` , `h_examenfisico`.`Peso` , `h_examenfisico`.`Talla`, `h_examenfisico`.`IMC`, `h_examenfisico`.`PerimetroAbdominal` FROM  `h_examenfisico` INNER JOIN  `h_atencion`  ON (`h_examenfisico`.`Id_Atencion` = `h_atencion`.`Id`) INNER JOIN `ingreso`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`) WHERE (`ingreso`.`Id_Usuario` ='" + xidusuario + "' ) ORDER BY h_atencion.`Fecha_Atencion` DESC LIMIT 1 ";
            ConsultasMySQL xct3 = new ConsultasMySQL();
            System.out.println(" Examen Fisico" + this.xsql);
            ResultSet xrs = xct3.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.first();
                xmod.setValueAt(xrs.getString(3) + "/" + xrs.getString(2), xfila, xcoluma);
                xmod.setValueAt(xrs.getString(4), xfila, xcoluma + 1);
                xmod.setValueAt(xrs.getString(5), xfila, xcoluma + 2);
                xmod.setValueAt(xrs.getString(6), xfila, xcoluma + 3);
                xmod.setValueAt(xrs.getString(7), xfila, xcoluma + 4);
            } else {
                xmod.setValueAt("0", xfila, xcoluma);
                xmod.setValueAt("0", xfila, xcoluma + 1);
                xmod.setValueAt("0", xfila, xcoluma + 2);
                xmod.setValueAt("0", xfila, xcoluma + 3);
                xmod.setValueAt("0", xfila, xcoluma + 4);
            }
            xrs.close();
            xct3.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFConsultarInfCove.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mDatosNutricionales(String xidusuario, DefaultTableModel xmod, int xfila, int xcoluma) {
        try {
            this.xsql = "SELECT `h_atencion`.`Fecha_Atencion` , `h_nutricional`.`Talla` , `h_nutricional`.`Peso` , `h_nutricional`.`Imc` , `h_nutricional`.`CCarpo`, `h_nutricional`.`EstructuraM` , `h_nutricional`.`CCintura`, `h_nutricional`.`CCadera`, `h_nutricional`.`PAgua`, `h_nutricional`.`PGrasa`, `h_nutricional`.`MOsea`, `h_nutricional`.`MViceral`, `h_nutricional`.`PesoLGrasa`, `h_nutricional`.`PesoUsual`, `h_nutricional`.`PesoObjetivo`  FROM `h_nutricional` INNER JOIN `baseserver`.`h_atencion`  ON (`h_nutricional`.`Id_Atencion` = `h_atencion`.`Id`) INNER JOIN  `ingreso` ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)   WHERE (`ingreso`.`Id_Usuario` ='" + xidusuario + "')  ORDER BY `h_atencion`.`Fecha_Atencion` DESC ";
            ConsultasMySQL xct3 = new ConsultasMySQL();
            System.out.println(" Examen Nutricional" + this.xsql);
            ResultSet xrs = xct3.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.first();
                xmod.setValueAt(xrs.getString(2), xfila, xcoluma);
                xmod.setValueAt(xrs.getString(3), xfila, xcoluma + 1);
                xmod.setValueAt(xrs.getString(4), xfila, xcoluma + 2);
                xmod.setValueAt(xrs.getString(5), xfila, xcoluma + 3);
                xmod.setValueAt(xrs.getString(6), xfila, xcoluma + 4);
                xmod.setValueAt(xrs.getString(7), xfila, xcoluma + 5);
                xmod.setValueAt(xrs.getString(8), xfila, xcoluma + 6);
                xmod.setValueAt(xrs.getString(9), xfila, xcoluma + 7);
                xmod.setValueAt(xrs.getString(10), xfila, xcoluma + 8);
                xmod.setValueAt(xrs.getString(11), xfila, xcoluma + 9);
                xmod.setValueAt(xrs.getString(12), xfila, xcoluma + 10);
                xmod.setValueAt(xrs.getString(13), xfila, xcoluma + 11);
                xmod.setValueAt(xrs.getString(14), xfila, xcoluma + 12);
                xmod.setValueAt(xrs.getString(15), xfila, xcoluma + 13);
            } else {
                xmod.setValueAt("0", xfila, xcoluma);
                xmod.setValueAt("0", xfila, xcoluma + 1);
                xmod.setValueAt("0", xfila, xcoluma + 2);
                xmod.setValueAt("0", xfila, xcoluma + 3);
                xmod.setValueAt("0", xfila, xcoluma + 4);
                xmod.setValueAt("0", xfila, xcoluma + 5);
                xmod.setValueAt("0", xfila, xcoluma + 6);
                xmod.setValueAt("0", xfila, xcoluma + 7);
                xmod.setValueAt("0", xfila, xcoluma + 8);
                xmod.setValueAt("0", xfila, xcoluma + 9);
                xmod.setValueAt("0", xfila, xcoluma + 10);
                xmod.setValueAt("0", xfila, xcoluma + 11);
                xmod.setValueAt("0", xfila, xcoluma + 12);
                xmod.setValueAt("0", xfila, xcoluma + 13);
            }
            xrs.close();
            xct3.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFConsultarInfCove.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mDatosMedicamentoPAMetformina(String xidusuario, DefaultTableModel xmod, int xfila, int xcoluma, int xpactivo) {
        try {
            this.xsql = "SELECT `i_salidas`.`FechaSalida`, `i_suministro`.`Nbre` FROM `i_detallesalida` INNER JOIN  `i_suministro`  ON (`i_detallesalida`.`IdSuministro` = `i_suministro`.`Id`) INNER JOIN  `i_salidas`  ON (`i_detallesalida`.`IdSalida` = `i_salidas`.`Id`) INNER JOIN  `persona`  ON (`persona`.`Id_persona` = `i_salidas`.`IdDestino`) WHERE (`i_salidas`.`IdDestino` ='" + xidusuario + "' AND `i_suministro`.`IdPrincipioActivo` ='" + xpactivo + "' and `i_salidas`.Estado=0) ORDER BY `i_salidas`.`FechaSalida` DESC ";
            ConsultasMySQL xct3 = new ConsultasMySQL();
            System.out.println(" Medicamento" + this.xsql);
            ResultSet xrs = xct3.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.first();
                xmod.setValueAt("Si", xfila, xcoluma);
                xmod.setValueAt(xrs.getString(1), xfila, xcoluma + 1);
                xmod.setValueAt(xrs.getString(2), xfila, xcoluma + 2);
            } else {
                xmod.setValueAt("No", xfila, xcoluma);
                xmod.setValueAt("SIN FECHA", xfila, xcoluma + 1);
                xmod.setValueAt(" ", xfila, xcoluma + 2);
            }
            xrs.close();
            xct3.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFConsultarInfCove.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mDatosMedicamentoPLipido(String xidusuario, DefaultTableModel xmod, int xfila, int xcoluma) {
        try {
            this.xsql = "SELECT `i_salidas`.`FechaSalida`, `i_suministro`.`Nbre` FROM `i_detallesalida` INNER JOIN  `i_suministro`  ON (`i_detallesalida`.`IdSuministro` = `i_suministro`.`Id`) INNER JOIN  `i_salidas`  ON (`i_detallesalida`.`IdSalida` = `i_salidas`.`Id`) INNER JOIN  `persona`  ON (`persona`.`Id_persona` = `i_salidas`.`IdDestino`) WHERE (`i_salidas`.`IdDestino` ='" + xidusuario + "' AND `i_suministro`.`IdPrincipioActivo` IN(1221,764,124,533,652,329,573,469,1029) and `i_salidas`.Estado=0 ) ORDER BY `i_salidas`.`FechaSalida` DESC ";
            ConsultasMySQL xct3 = new ConsultasMySQL();
            System.out.println(" Medicamento" + this.xsql);
            ResultSet xrs = xct3.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.first();
                xmod.setValueAt("Si", xfila, xcoluma);
                xmod.setValueAt(xrs.getString(1), xfila, xcoluma + 1);
                xmod.setValueAt(xrs.getString(2), xfila, xcoluma + 2);
            } else {
                xmod.setValueAt("No", xfila, xcoluma);
                xmod.setValueAt("SIN FECHA", xfila, xcoluma + 1);
                xmod.setValueAt(" ", xfila, xcoluma + 2);
            }
            xrs.close();
            xct3.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFConsultarInfCove.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mExportar() {
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            try {
                WritableWorkbook workbook = Workbook.createWorkbook(new File(this.JTFRuta.getText() + ".xls"));
                WritableSheet sheet = workbook.createSheet("Usuario", 0);
                for (int x = 0; x < this.JTBDetalle.getColumnCount(); x++) {
                    sheet.addCell(new Label(x, 0, this.JTBDetalle.getColumnName(x)));
                }
                for (int x2 = 0; x2 < this.JTBDetalle.getRowCount(); x2++) {
                    sheet.addCell(new Number(0, x2 + 1, Long.valueOf(this.xmodelo.getValueAt(x2, 0).toString()).longValue()));
                    sheet.addCell(new Label(1, x2 + 1, this.xmodelo.getValueAt(x2, 1).toString()));
                    sheet.addCell(new Label(2, x2 + 1, this.xmodelo.getValueAt(x2, 2).toString()));
                    sheet.addCell(new Label(3, x2 + 1, this.xmodelo.getValueAt(x2, 3).toString()));
                    sheet.addCell(new Label(4, x2 + 1, this.xmodelo.getValueAt(x2, 4).toString()));
                    sheet.addCell(new Label(5, x2 + 1, this.xmodelo.getValueAt(x2, 5).toString()));
                    sheet.addCell(new Number(6, x2 + 1, Long.valueOf(this.xmodelo.getValueAt(x2, 6).toString()).longValue()));
                    sheet.addCell(new Label(7, x2 + 1, this.xmodelo.getValueAt(x2, 7).toString()));
                    sheet.addCell(new Label(8, x2 + 1, this.xmodelo.getValueAt(x2, 8).toString()));
                    sheet.addCell(new Label(9, x2 + 1, this.xmodelo.getValueAt(x2, 9).toString()));
                    sheet.addCell(new Label(10, x2 + 1, this.xmodelo.getValueAt(x2, 10).toString()));
                    sheet.addCell(new Label(11, x2 + 1, this.xmodelo.getValueAt(x2, 11).toString()));
                    sheet.addCell(new Label(12, x2 + 1, this.xmodelo.getValueAt(x2, 12).toString()));
                    sheet.addCell(new Label(13, x2 + 1, this.xmodelo.getValueAt(x2, 13).toString()));
                    sheet.addCell(new Label(14, x2 + 1, this.xmodelo.getValueAt(x2, 14).toString()));
                    sheet.addCell(new Label(15, x2 + 1, this.xmodelo.getValueAt(x2, 15).toString()));
                    sheet.addCell(new Label(16, x2 + 1, this.xmodelo.getValueAt(x2, 16).toString()));
                    sheet.addCell(new Label(17, x2 + 1, this.xmodelo.getValueAt(x2, 17).toString()));
                    sheet.addCell(new Label(18, x2 + 1, this.xmodelo.getValueAt(x2, 18).toString()));
                }
                WritableSheet sheet2 = workbook.createSheet("Consolidado", 1);
                for (int x3 = 0; x3 < this.JTBDetalle1.getColumnCount(); x3++) {
                    sheet2.addCell(new Label(x3, 0, this.JTBDetalle1.getColumnName(x3)));
                }
                for (int x4 = 0; x4 < this.JTBDetalle1.getRowCount(); x4++) {
                    sheet2.addCell(new Label(0, x4 + 1, this.xmodelo1.getValueAt(x4, 0).toString()));
                    sheet2.addCell(new Label(1, x4 + 1, this.xmodelo1.getValueAt(x4, 1).toString()));
                    sheet2.addCell(new Number(2, x4 + 1, Long.valueOf(this.xmodelo1.getValueAt(x4, 2).toString()).longValue()));
                }
                WritableSheet sheet3 = workbook.createSheet("Agrupada", 1);
                for (int x5 = 0; x5 < this.JTBDetalle2.getColumnCount(); x5++) {
                    sheet3.addCell(new Label(x5, 0, this.JTBDetalle2.getColumnName(x5)));
                }
                for (int x6 = 0; x6 < this.JTBDetalle2.getRowCount(); x6++) {
                    System.out.println(" nFilas " + x6);
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
                    sheet3.addCell(new Number(19, x6 + 1, Long.valueOf(this.xmodelo2.getValueAt(x6, 19).toString()).longValue()));
                    if (!this.xidtipoentidad[this.JCBTipoEntidad.getSelectedIndex()].equals("14")) {
                        sheet3.addCell(new Number(20, x6 + 1, Double.valueOf(this.xmodelo2.getValueAt(x6, 20).toString()).doubleValue()));
                        sheet3.addCell(new Number(21, x6 + 1, Double.valueOf(this.xmodelo2.getValueAt(x6, 21).toString()).doubleValue()));
                        sheet3.addCell(new Number(22, x6 + 1, Double.valueOf(this.xmodelo2.getValueAt(x6, 22).toString()).doubleValue()));
                        sheet3.addCell(new Label(23, x6 + 1, this.xmodelo2.getValueAt(x6, 23).toString()));
                    }
                    if (this.xidtipoentidad[this.JCBTipoEntidad.getSelectedIndex()].equals("11")) {
                        sheet3.addCell(new Label(24, x6 + 1, this.xmodelo2.getValueAt(x6, 24).toString()));
                        sheet3.addCell(new Label(25, x6 + 1, this.xmodelo2.getValueAt(x6, 25).toString()));
                        sheet3.addCell(new Label(26, x6 + 1, this.xmodelo2.getValueAt(x6, 26).toString()));
                        sheet3.addCell(new Label(27, x6 + 1, this.xmodelo2.getValueAt(x6, 27).toString()));
                        sheet3.addCell(new Label(28, x6 + 1, this.xmodelo2.getValueAt(x6, 28).toString()));
                        sheet3.addCell(new Label(29, x6 + 1, this.xmodelo2.getValueAt(x6, 29).toString()));
                        sheet3.addCell(new Label(30, x6 + 1, this.xmodelo2.getValueAt(x6, 30).toString()));
                        sheet3.addCell(new Label(31, x6 + 1, this.xmodelo2.getValueAt(x6, 31).toString()));
                        sheet3.addCell(new Label(32, x6 + 1, this.xmodelo2.getValueAt(x6, 32).toString()));
                        sheet3.addCell(new Label(33, x6 + 1, this.xmodelo2.getValueAt(x6, 33).toString()));
                        sheet3.addCell(new Label(34, x6 + 1, this.xmodelo2.getValueAt(x6, 34).toString()));
                        sheet3.addCell(new Label(35, x6 + 1, this.xmodelo2.getValueAt(x6, 35).toString()));
                        sheet3.addCell(new Label(36, x6 + 1, this.xmodelo2.getValueAt(x6, 36).toString()));
                        sheet3.addCell(new Label(37, x6 + 1, this.xmodelo2.getValueAt(x6, 37).toString()));
                        sheet3.addCell(new Label(38, x6 + 1, this.xmodelo2.getValueAt(x6, 38).toString()));
                        sheet3.addCell(new Label(39, x6 + 1, this.xmodelo2.getValueAt(x6, 39).toString()));
                        sheet3.addCell(new Label(40, x6 + 1, this.xmodelo2.getValueAt(x6, 40).toString()));
                        sheet3.addCell(new Label(41, x6 + 1, this.xmodelo2.getValueAt(x6, 41).toString()));
                        sheet3.addCell(new Label(42, x6 + 1, this.xmodelo2.getValueAt(x6, 42).toString()));
                        sheet3.addCell(new Label(43, x6 + 1, this.xmodelo2.getValueAt(x6, 43).toString()));
                        sheet3.addCell(new Label(44, x6 + 1, this.xmodelo2.getValueAt(x6, 44).toString()));
                        sheet3.addCell(new Label(45, x6 + 1, this.xmodelo2.getValueAt(x6, 45).toString()));
                        sheet3.addCell(new Label(46, x6 + 1, this.xmodelo2.getValueAt(x6, 46).toString()));
                        sheet3.addCell(new Label(47, x6 + 1, this.xmodelo2.getValueAt(x6, 47).toString()));
                        sheet3.addCell(new Label(48, x6 + 1, this.xmodelo2.getValueAt(x6, 48).toString()));
                        sheet3.addCell(new Label(49, x6 + 1, this.xmodelo2.getValueAt(x6, 49).toString()));
                        sheet3.addCell(new Label(50, x6 + 1, this.xmodelo2.getValueAt(x6, 50).toString()));
                        sheet3.addCell(new Label(51, x6 + 1, this.xmodelo2.getValueAt(x6, 51).toString()));
                    } else if (this.xidtipoentidad[this.JCBTipoEntidad.getSelectedIndex()].equals("12")) {
                        sheet3.addCell(new Label(24, x6 + 1, this.xmodelo2.getValueAt(x6, 24).toString()));
                        sheet3.addCell(new Label(25, x6 + 1, this.xmodelo2.getValueAt(x6, 25).toString()));
                        sheet3.addCell(new Number(26, x6 + 1, Double.valueOf(this.xmodelo2.getValueAt(x6, 26).toString()).doubleValue()));
                        sheet3.addCell(new Number(27, x6 + 1, Double.valueOf(this.xmodelo2.getValueAt(x6, 27).toString()).doubleValue()));
                        sheet3.addCell(new Number(28, x6 + 1, Double.valueOf(this.xmodelo2.getValueAt(x6, 28).toString()).doubleValue()));
                        sheet3.addCell(new Number(29, x6 + 1, Double.valueOf(this.xmodelo2.getValueAt(x6, 29).toString()).doubleValue()));
                        sheet3.addCell(new Number(30, x6 + 1, Double.valueOf(this.xmodelo2.getValueAt(x6, 30).toString()).doubleValue()));
                        sheet3.addCell(new Number(31, x6 + 1, Double.valueOf(this.xmodelo2.getValueAt(x6, 31).toString()).doubleValue()));
                        sheet3.addCell(new Number(32, x6 + 1, Double.valueOf(this.xmodelo2.getValueAt(x6, 32).toString()).doubleValue()));
                        sheet3.addCell(new Number(33, x6 + 1, Double.valueOf(this.xmodelo2.getValueAt(x6, 33).toString()).doubleValue()));
                        sheet3.addCell(new Number(34, x6 + 1, Double.valueOf(this.xmodelo2.getValueAt(x6, 34).toString()).doubleValue()));
                        sheet3.addCell(new Number(35, x6 + 1, Double.valueOf(this.xmodelo2.getValueAt(x6, 35).toString()).doubleValue()));
                        sheet3.addCell(new Number(36, x6 + 1, Double.valueOf(this.xmodelo2.getValueAt(x6, 36).toString()).doubleValue()));
                        sheet3.addCell(new Number(37, x6 + 1, Double.valueOf(this.xmodelo2.getValueAt(x6, 37).toString()).doubleValue()));
                        sheet3.addCell(new Number(38, x6 + 1, Double.valueOf(this.xmodelo2.getValueAt(x6, 38).toString()).doubleValue()));
                        sheet3.addCell(new Number(39, x6 + 1, Double.valueOf(this.xmodelo2.getValueAt(x6, 39).toString()).doubleValue()));
                        sheet3.addCell(new Number(40, x6 + 1, Double.valueOf(this.xmodelo2.getValueAt(x6, 40).toString()).doubleValue()));
                        sheet3.addCell(new Number(41, x6 + 1, Double.valueOf(this.xmodelo2.getValueAt(x6, 41).toString()).doubleValue()));
                        sheet3.addCell(new Number(42, x6 + 1, Double.valueOf(this.xmodelo2.getValueAt(x6, 42).toString()).doubleValue()));
                        sheet3.addCell(new Number(43, x6 + 1, Double.valueOf(this.xmodelo2.getValueAt(x6, 43).toString()).doubleValue()));
                        sheet3.addCell(new Label(44, x6 + 1, this.xmodelo2.getValueAt(x6, 44).toString()));
                        sheet3.addCell(new Label(45, x6 + 1, this.xmodelo2.getValueAt(x6, 45).toString()));
                        sheet3.addCell(new Label(46, x6 + 1, this.xmodelo2.getValueAt(x6, 46).toString()));
                    }
                }
                workbook.write();
                workbook.close();
            } catch (WriteException e) {
                Logger.getLogger(JIFConsultarInfCove.class.getName()).log(Level.SEVERE, (String) null, e);
            } catch (IOException ex) {
                Logger.getLogger(JIFConsultarInfCove.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        }
    }
}
