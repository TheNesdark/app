package com.genoma.plus.controller.sgc;

import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
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
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/sgc/JIF_Reportes_PyP_Generico.class */
public class JIF_Reportes_PyP_Generico extends JInternalFrame {
    private DefaultTableModel xmodeloN;
    private Object[] xDato;
    private String[] idConvenio;
    private int idModulo;
    private JButton JBTExportar;
    private JComboBox<String> JCBReportesPYP;
    private JComboBox<String> JCB_Empresa;
    private JDateChooser JDFechaF;
    private JDateChooser JDFechaI;
    private JLabel JLBLCont;
    private JPanel JPExportar;
    private JPanel JPI_Filtro;
    private JPanel JPI_Filtro1;
    private JScrollPane JSPDetalle;
    private JTabbedPane JTB_Datos;
    private JTable JTDetalle;
    private JTextField JTFRuta;
    private ButtonGroup buttonGroup1;
    private ButtonGroup buttonGroup2;
    private JPanel jPanel3;
    private Metodos xmt = new Metodos();
    private Boolean xy = false;
    private List<String> query = new ArrayList();
    private ConsultasMySQL xct = new ConsultasMySQL();

    public JIF_Reportes_PyP_Generico(int idModulo, String titulo, String nombre) {
        initComponents();
        setTitle(titulo);
        setName(nombre);
        this.idModulo = idModulo;
        mNuevo();
    }

    public void mNuevo() {
        this.JDFechaI.setDate(this.xmt.getFechaActual());
        this.JDFechaF.setDate(this.xmt.getFechaActual());
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
        mCargarCombo();
        this.JLBLCont.setText("0");
    }

    private void mCargarCombo() {
        try {
            this.JCBReportesPYP.removeAllItems();
            String sql = "SELECT r.Nbre, r.Sql FROM reportes_pyp r WHERE r.Estado = 1 and idModulo=" + this.idModulo + " order by r.Nbre asc;";
            ResultSet rs = this.xct.traerRs(sql);
            Throwable th = null;
            try {
                try {
                    if (rs.next()) {
                        int n = 0;
                        rs.beforeFirst();
                        while (rs.next()) {
                            this.JCBReportesPYP.addItem(rs.getString("Nbre"));
                            this.query.add(rs.getString("Sql"));
                            n++;
                        }
                    }
                    this.JCBReportesPYP.setSelectedIndex(-1);
                    if (rs != null) {
                        if (0 != 0) {
                            try {
                                rs.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                        } else {
                            rs.close();
                        }
                    }
                    this.xct.cerrarConexionBd();
                } finally {
                }
            } catch (Throwable th3) {
                th = th3;
                throw th3;
            }
        } catch (SQLException e) {
            this.xct.mostrarErrorSQL(e);
        }
    }

    private Boolean getTextoEnConsulta(String texto) {
        Boolean datos = false;
        if (texto.contains(":idConvenio")) {
            datos = true;
        }
        return datos;
    }

    /* JADX WARN: Type inference failed for: r3v2, types: [java.lang.Object[], java.lang.Object[][]] */
    private void buscarDatos(String sql) {
        try {
            this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, this.JCBReportesPYP.getSelectedItem().toString().toUpperCase(), 2, 0, new Font("Arial", 1, 14), Color.red));
            this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
            this.JLBLCont.setText("0");
            ResultSet rs = this.xct.traerRs(sql);
            Throwable th = null;
            try {
                try {
                    if (rs.next()) {
                        rs.beforeFirst();
                        ResultSetMetaData rsmd = rs.getMetaData();
                        Integer columnas = Integer.valueOf(rsmd.getColumnCount());
                        String[] encabezado = new String[columnas.intValue()];
                        Class[] clases = new Class[columnas.intValue()];
                        boolean[] editable = new boolean[columnas.intValue()];
                        for (int i = 0; i < columnas.intValue(); i++) {
                            encabezado[i] = rsmd.getColumnLabel(i + 1);
                            switch (rsmd.getColumnClassName(i + 1)) {
                                case "java.lang.String":
                                    clases[i] = String.class;
                                    break;
                                case "java.lang.Double":
                                    clases[i] = Double.class;
                                    break;
                                case "java.lang.Long":
                                case "java.math.BigInteger":
                                case "java.math.BigDecimal":
                                    clases[i] = Long.class;
                                    break;
                                default:
                                    clases[i] = String.class;
                                    break;
                            }
                            editable[i] = false;
                        }
                        mCrearModeloDatos(columnas, encabezado, clases, editable);
                        int n = 0;
                        while (rs.next()) {
                            this.xmodeloN.addRow(this.xDato);
                            for (int i2 = 0; i2 < columnas.intValue(); i2++) {
                                if (this.xmodeloN.getColumnClass(i2).toString().equals("class java.lang.Double")) {
                                    this.xmodeloN.setValueAt(Double.valueOf(rs.getDouble(i2 + 1)), n, i2);
                                } else {
                                    this.xmodeloN.setValueAt(rs.getString(i2 + 1), n, i2);
                                }
                            }
                            n++;
                        }
                        adjustColumnWidths(this.JTDetalle);
                        this.JLBLCont.setText("" + n);
                    }
                    if (rs != null) {
                        if (0 != 0) {
                            try {
                                rs.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                        } else {
                            rs.close();
                        }
                    }
                    this.xct.cerrarConexionBd();
                } finally {
                }
            } catch (Throwable th3) {
                th = th3;
                throw th3;
            }
        } catch (SQLException ex) {
            this.xct.mostrarErrorSQL(ex);
        }
    }

    public void mBuscarConsultaPyP() {
        if (this.JCBReportesPYP.getSelectedIndex() > -1) {
            String ConsultaSql = this.query.get(this.JCBReportesPYP.getSelectedIndex()).replaceAll(":FechaInicio", this.xmt.formatoAMD1.format(this.JDFechaI.getDate())).replaceAll(":FechaFinal", this.xmt.formatoAMD1.format(this.JDFechaF.getDate()));
            if (ConsultaSql.contains(":idConvenio") && this.JCB_Empresa.getSelectedIndex() != -1) {
                ConsultaSql = ConsultaSql.replaceAll(":idConvenio", this.idConvenio[this.JCB_Empresa.getSelectedIndex()]);
            }
            if (getTextoEnConsulta(ConsultaSql).booleanValue()) {
                if (this.JCB_Empresa.getSelectedIndex() > -1) {
                    buscarDatos(this.title);
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un convenio.", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JTB_Datos.setSelectedIndex(1);
                this.JCB_Empresa.requestFocus();
                return;
            }
            buscarDatos(ConsultaSql);
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un reporte.", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JTB_Datos.setSelectedIndex(0);
        this.JCBReportesPYP.requestFocus();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos(Integer columnas, String[] Encabezado, final Class[] clases, final boolean[] Editable) {
        this.xmodeloN = new DefaultTableModel(new Object[0], Encabezado) { // from class: com.genoma.plus.controller.sgc.JIF_Reportes_PyP_Generico.1
            Class[] types;
            boolean[] canEdit;

            {
                this.types = clases;
                this.canEdit = Editable;
            }

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
        this.JTDetalle.setModel(this.xmodeloN);
    }

    public void mBuscar() {
        mBuscarConsultaPyP();
    }

    /* JADX WARN: Type inference failed for: r3v8, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.buttonGroup1 = new ButtonGroup();
        this.buttonGroup2 = new ButtonGroup();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JPExportar = new JPanel();
        this.JTFRuta = new JTextField();
        this.JBTExportar = new JButton();
        this.jPanel3 = new JPanel();
        this.JLBLCont = new JLabel();
        this.JTB_Datos = new JTabbedPane();
        this.JPI_Filtro = new JPanel();
        this.JDFechaI = new JDateChooser();
        this.JDFechaF = new JDateChooser();
        this.JCBReportesPYP = new JComboBox<>();
        this.JPI_Filtro1 = new JPanel();
        this.JCB_Empresa = new JComboBox<>();
        setClosable(true);
        setIconifiable(true);
        setTitle("Reportes PyP");
        setCursor(new Cursor(0));
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jif_ReportesPyP");
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JSPDetalle.setPreferredSize(new Dimension(1330, 426));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setAutoResizeMode(0);
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.JPExportar.setBorder(BorderFactory.createTitledBorder((Border) null, "EXPORTAR", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.sgc.JIF_Reportes_PyP_Generico.2
            public void mouseClicked(MouseEvent evt) {
                JIF_Reportes_PyP_Generico.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JTFRuta.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.sgc.JIF_Reportes_PyP_Generico.3
            public void actionPerformed(ActionEvent evt) {
                JIF_Reportes_PyP_Generico.this.JTFRutaActionPerformed(evt);
            }
        });
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setForeground(Color.red);
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.sgc.JIF_Reportes_PyP_Generico.4
            public void actionPerformed(ActionEvent evt) {
                JIF_Reportes_PyP_Generico.this.JBTExportarActionPerformed(evt);
            }
        });
        GroupLayout JPExportarLayout = new GroupLayout(this.JPExportar);
        this.JPExportar.setLayout(JPExportarLayout);
        JPExportarLayout.setHorizontalGroup(JPExportarLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPExportarLayout.createSequentialGroup().addGap(0, 0, 0).addComponent(this.JTFRuta, -2, 329, -2).addGap(18, 18, 18).addComponent(this.JBTExportar, -2, 145, -2).addContainerGap(28, 32767)));
        JPExportarLayout.setVerticalGroup(JPExportarLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPExportarLayout.createSequentialGroup().addGroup(JPExportarLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTFRuta, -1, 48, 32767).addComponent(this.JBTExportar, -1, -1, 32767)).addContainerGap(7, 32767)));
        this.jPanel3.setBorder(BorderFactory.createTitledBorder((Border) null, "TOTAL REGISTROS", 0, 0, new Font("Arial", 1, 14), new Color(0, 100, 0)));
        this.JLBLCont.setFont(new Font("Arial", 1, 36));
        this.JLBLCont.setHorizontalAlignment(0);
        this.JLBLCont.setText("0");
        GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
        this.jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLBLCont, GroupLayout.Alignment.TRAILING, -1, 151, 32767));
        jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLBLCont, GroupLayout.Alignment.TRAILING, -1, 55, 32767));
        this.JTB_Datos.setForeground(new Color(0, 103, 0));
        this.JTB_Datos.setFont(new Font("Arial", 1, 14));
        this.JDFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicial", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFechaI.setFont(new Font("Arial", 1, 12));
        this.JDFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Final", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFechaF.setFont(new Font("Arial", 1, 12));
        this.JCBReportesPYP.setFont(new Font("Arial", 1, 14));
        this.JCBReportesPYP.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBReportesPYP.addItemListener(new ItemListener() { // from class: com.genoma.plus.controller.sgc.JIF_Reportes_PyP_Generico.5
            public void itemStateChanged(ItemEvent evt) {
                JIF_Reportes_PyP_Generico.this.JCBReportesPYPItemStateChanged(evt);
            }
        });
        GroupLayout JPI_FiltroLayout = new GroupLayout(this.JPI_Filtro);
        this.JPI_Filtro.setLayout(JPI_FiltroLayout);
        JPI_FiltroLayout.setHorizontalGroup(JPI_FiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_FiltroLayout.createSequentialGroup().addGap(23, 23, 23).addComponent(this.JDFechaI, -2, 136, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JDFechaF, -2, 136, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBReportesPYP, 0, 825, 32767).addContainerGap()));
        JPI_FiltroLayout.setVerticalGroup(JPI_FiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_FiltroLayout.createSequentialGroup().addGap(16, 16, 16).addGroup(JPI_FiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPI_FiltroLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JDFechaI, -2, 50, -2).addComponent(this.JDFechaF, -2, 50, -2)).addComponent(this.JCBReportesPYP, GroupLayout.Alignment.TRAILING, -2, 55, -2)).addContainerGap(10, 32767)));
        this.JTB_Datos.addTab("FILTRO", this.JPI_Filtro);
        this.JCB_Empresa.setFont(new Font("Arial", 1, 14));
        this.JCB_Empresa.setBorder(BorderFactory.createTitledBorder((Border) null, "Entidad", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPI_Filtro1Layout = new GroupLayout(this.JPI_Filtro1);
        this.JPI_Filtro1.setLayout(JPI_Filtro1Layout);
        JPI_Filtro1Layout.setHorizontalGroup(JPI_Filtro1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_Filtro1Layout.createSequentialGroup().addGap(15, 15, 15).addComponent(this.JCB_Empresa, 0, 825, 32767).addGap(304, 304, 304)));
        JPI_Filtro1Layout.setVerticalGroup(JPI_Filtro1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_Filtro1Layout.createSequentialGroup().addGap(17, 17, 17).addComponent(this.JCB_Empresa, -2, 55, -2).addContainerGap(9, 32767)));
        this.JTB_Datos.addTab("FILTRO1", this.JPI_Filtro1);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JTB_Datos, GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.JPExportar, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.jPanel3, -2, -1, -2)).addComponent(this.JSPDetalle, GroupLayout.Alignment.LEADING, -2, 0, 32767)).addContainerGap(-1, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addComponent(this.JTB_Datos, -2, 112, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPDetalle, -1, 362, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPExportar, GroupLayout.Alignment.TRAILING, -2, -1, -2).addComponent(this.jPanel3, GroupLayout.Alignment.TRAILING, -2, -1, -2)).addContainerGap()));
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
        mExportar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBReportesPYPItemStateChanged(ItemEvent evt) {
        int selectedIndex = this.JCBReportesPYP.getSelectedIndex();
        if (selectedIndex != -1 && selectedIndex < this.query.size()) {
            String queryElement = this.query.get(selectedIndex);
            if (queryElement != null && !queryElement.isEmpty()) {
                if (queryElement.contains(":idConvenio")) {
                    llenarComboEmpresa();
                    return;
                }
                return;
            }
            System.out.println("El elemento seleccionado en la lista query está vacío.");
            return;
        }
        System.out.println("Índice seleccionado no válido o fuera de rango.");
    }

    private void mExportar() {
        if (!this.JTFRuta.getText().isEmpty()) {
            if (this.JTDetalle.getRowCount() != -1) {
                int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMAR", 0, 3, new ImageIcon("src/Imagenes/Question2.png"));
                if (n == 0) {
                    this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTDetalle, this.JTFRuta.getText(), this.JCBReportesPYP.getSelectedItem().toString());
                    return;
                }
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "No existe información para exportar", "VERIFICAR", 1, new ImageIcon("src/Imagenes/Information2.png"));
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un ruta valida", "VERIFICAR", 1, new ImageIcon("src/Imagenes/Information2.png"));
        this.JTFRuta.requestFocus();
    }

    private void llenarComboEmpresa() {
        try {
            this.JCB_Empresa.removeAllItems();
            ResultSet rs = this.xct.traerRs("select \nfe.Id idConvenio, \nfe.Nbre nombreConvenio, \nge.Id idEmpresa, \nif((ge.Nbre<>'' or ge.Nbre is not null), ge.Nbre, concat(ge.Apellido1,' ', ge.Apellido2,' ', ge.Nombre1 ,' ', ge.Nombre2)) nombreEmpresa\nfrom f_empresacontxconvenio fe\ninner join g_empresa ge  on (fe.Id_EmpresaCont=ge.Id)\ninner join ingreso i on (i.Id_EmpresaContxConv=fe.Id)\ngroup by fe.Id \norder by nombreConvenio asc");
            Throwable th = null;
            try {
                if (rs.next()) {
                    rs.last();
                    this.idConvenio = new String[rs.getRow()];
                    int x = 0;
                    rs.beforeFirst();
                    while (rs.next()) {
                        this.idConvenio[x] = rs.getString("idConvenio");
                        this.JCB_Empresa.addItem(rs.getString("nombreConvenio"));
                        x++;
                    }
                }
                this.JCB_Empresa.setSelectedIndex(-1);
                if (rs != null) {
                    if (0 != 0) {
                        try {
                            rs.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    } else {
                        rs.close();
                    }
                }
                this.xct.cerrarConexionBd();
            } finally {
            }
        } catch (SQLException e) {
            this.xct.mostrarErrorSQL(e);
        }
    }

    private static void adjustColumnWidths(JTable table) {
        for (int col = 0; col < table.getColumnCount(); col++) {
            TableColumn column = table.getColumnModel().getColumn(col);
            TableCellRenderer headerRenderer = table.getTableHeader().getDefaultRenderer();
            Component headerComp = headerRenderer.getTableCellRendererComponent(table, column.getHeaderValue(), false, false, 0, col);
            int maxWidth = Math.max(0, headerComp.getPreferredSize().width);
            for (int row = 0; row < table.getRowCount(); row++) {
                TableCellRenderer cellRenderer = table.getCellRenderer(row, col);
                Component cellComp = cellRenderer.getTableCellRendererComponent(table, table.getValueAt(row, col), false, false, row, col);
                maxWidth = Math.max(maxWidth, cellComp.getPreferredSize().width);
            }
            column.setPreferredWidth(maxWidth + 10);
        }
    }
}
