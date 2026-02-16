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
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
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

/* JADX INFO: loaded from: GenomaP.jar:Sig/JIFConsultarInf3Tabla.class */
public class JIFConsultarInf3Tabla extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private DefaultTableModel xmodelo1;
    private DefaultTableModel xmodelo2;
    private String xsql;
    private Object[] xdato;
    private String xnombre;
    private JButton JBTExportar;
    private JDateChooser JDFechaF;
    private JDateChooser JDFechaI;
    private JPanel JPIDatos;
    private JScrollPane JSPDetalle;
    private JScrollPane JSPDetalle1;
    private JScrollPane JSPDetalle2;
    public JTable JTDetalle;
    public JTable JTDetalle1;
    public JTable JTDetalle2;
    private JTextField JTFRuta;
    private Metodos xmt = new Metodos();
    private ConsultasMySQL xct = new ConsultasMySQL();
    private int xtipoc = 0;

    public JIFConsultarInf3Tabla(String xnombre, String xtitulo) {
        initComponents();
        this.xnombre = xnombre;
        setName(xnombre);
        setTitle(xtitulo.toUpperCase());
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v34, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v40, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v46, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPIDatos = new JPanel();
        this.JDFechaI = new JDateChooser();
        this.JDFechaF = new JDateChooser();
        this.JBTExportar = new JButton();
        this.JTFRuta = new JTextField();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JSPDetalle1 = new JScrollPane();
        this.JTDetalle1 = new JTable();
        this.JSPDetalle2 = new JScrollPane();
        this.JTDetalle2 = new JTable();
        setClosable(true);
        setIconifiable(true);
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 0, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JDFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicial", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFechaI.setFont(new Font("Arial", 1, 12));
        this.JDFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Final", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFechaF.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setForeground(Color.red);
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: Sig.JIFConsultarInf3Tabla.1
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarInf3Tabla.this.JBTExportarActionPerformed(evt);
            }
        });
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: Sig.JIFConsultarInf3Tabla.2
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarInf3Tabla.this.JTFRutaMouseClicked(evt);
            }
        });
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addComponent(this.JDFechaI, -2, 136, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JDFechaF, -2, 136, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFRuta, -2, 396, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 36, 32767).addComponent(this.JBTExportar, -2, 221, -2).addContainerGap()));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JDFechaI, -2, 56, -2).addComponent(this.JDFechaF, -2, 56, -2)).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosLayout.createSequentialGroup().addGap(0, 16, 32767).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JBTExportar, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addComponent(this.JTFRuta, GroupLayout.Alignment.TRAILING, -1, 50, 32767)))).addContainerGap()));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setBorder(BorderFactory.createBevelBorder(0));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalle.setEditingColumn(0);
        this.JTDetalle.setEditingRow(0);
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setRowMargin(4);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.setSelectionMode(0);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: Sig.JIFConsultarInf3Tabla.3
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarInf3Tabla.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.JSPDetalle1.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTDetalle1.setBorder(BorderFactory.createBevelBorder(0));
        this.JTDetalle1.setFont(new Font("Arial", 1, 12));
        this.JTDetalle1.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalle1.setEditingColumn(0);
        this.JTDetalle1.setEditingRow(0);
        this.JTDetalle1.setRowHeight(25);
        this.JTDetalle1.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle1.setSelectionForeground(Color.red);
        this.JTDetalle1.setSelectionMode(0);
        this.JTDetalle1.addMouseListener(new MouseAdapter() { // from class: Sig.JIFConsultarInf3Tabla.4
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarInf3Tabla.this.JTDetalle1MouseClicked(evt);
            }
        });
        this.JSPDetalle1.setViewportView(this.JTDetalle1);
        this.JSPDetalle2.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTDetalle2.setBorder(BorderFactory.createBevelBorder(0));
        this.JTDetalle2.setFont(new Font("Arial", 1, 12));
        this.JTDetalle2.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalle2.setEditingColumn(0);
        this.JTDetalle2.setEditingRow(0);
        this.JTDetalle2.setRowHeight(25);
        this.JTDetalle2.setRowMargin(4);
        this.JTDetalle2.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle2.setSelectionForeground(Color.red);
        this.JTDetalle2.setSelectionMode(0);
        this.JSPDetalle2.setViewportView(this.JTDetalle2);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JSPDetalle2, -2, 319, -2).addComponent(this.JSPDetalle1, -2, 319, -2).addComponent(this.JPIDatos, -1, -1, 32767)).addContainerGap()).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JSPDetalle, -2, 616, -2).addContainerGap(357, 32767))));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addGap(18, 18, 18).addComponent(this.JSPDetalle1, -2, 175, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPDetalle2, -2, 165, -2).addContainerGap(39, 32767)).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(136, 136, 136).addComponent(this.JSPDetalle, -2, 359, -2).addContainerGap(23, 32767))));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalle1MouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2 && this.JTDetalle1.getSelectedRow() != -1) {
            this.xtipoc = 1;
            mCargarDetalle2();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2 && this.JTDetalle.getSelectedRow() != -1) {
            this.xtipoc = 1;
            mCargarDetalle1();
            mCrearTablaDetalle2();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTExportarActionPerformed(ActionEvent evt) {
        mExportar();
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

    public void mBuscar() {
        this.xtipoc = 0;
        mCargarDetalle();
        mCargarDetalle1();
        mCargarDetalle2();
    }

    public void mNuevo() {
        Principal.mLimpiarDatosP();
        this.JDFechaI.setDate(this.xmt.getFechaActual());
        this.JDFechaF.setDate(this.xmt.getFechaActual());
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
        if (this.xnombre.equals("xjifplacasdanadas")) {
            this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "CONSOLIDADO X PROCEDIMIENTO", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
            this.JSPDetalle1.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE X TIPO DE DAÑO", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
            this.JSPDetalle2.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE X TIPO PLACA", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        }
        mCrearTablaDetalle();
        mCrearTablaDetalle1();
        mCrearTablaDetalle2();
    }

    private void mCrearTablaDetalle() {
        this.xmodelo = new DefaultTableModel((Object[][]) null, new String[]{"Id", "Nombre", "Cantidad"}) { // from class: Sig.JIFConsultarInf3Tabla.5
            Class[] types = {Long.class, String.class, Long.class};
            boolean[] canEdit = {false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return this.canEdit[colIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(400);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(20);
    }

    private void mCrearTablaDetalle1() {
        this.xmodelo1 = new DefaultTableModel((Object[][]) null, new String[]{"Id", "Nombre", "Cantidad"}) { // from class: Sig.JIFConsultarInf3Tabla.6
            Class[] types = {Long.class, String.class, Long.class};
            boolean[] canEdit = {false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return this.canEdit[colIndex];
            }
        };
        this.JTDetalle1.setModel(this.xmodelo1);
        this.JTDetalle1.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTDetalle1.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTDetalle1.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTDetalle1.getColumnModel().getColumn(1).setPreferredWidth(150);
        this.JTDetalle1.getColumnModel().getColumn(2).setPreferredWidth(20);
    }

    private void mCrearTablaDetalle2() {
        this.xmodelo2 = new DefaultTableModel((Object[][]) null, new String[]{"Nombre", "Cantidad"}) { // from class: Sig.JIFConsultarInf3Tabla.7
            Class[] types = {String.class, Long.class};
            boolean[] canEdit = {false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return this.canEdit[colIndex];
            }
        };
        this.JTDetalle2.setModel(this.xmodelo2);
        this.JTDetalle2.getColumnModel().getColumn(0).setPreferredWidth(150);
        this.JTDetalle2.getColumnModel().getColumn(1).setPreferredWidth(20);
    }

    private void mCargarDetalle() {
        mCrearTablaDetalle();
        this.xsql = "SELECT g_procedimiento.Id, g_procedimiento.Nbre , COUNT(g_tipo_placasrx.Nbre) FROM h_informe_detalle_imagenesdx INNER JOIN h_informe_imagenesdx  ON (h_informe_detalle_imagenesdx.Id_infomesdx = h_informe_imagenesdx.Id) INNER JOIN g_tipo_placasrx  ON (h_informe_detalle_imagenesdx.Id_TipoPlaca = g_tipo_placasrx.Id) INNER JOIN g_tipo_causadañoplacas  ON (h_informe_detalle_imagenesdx.Id_TipoDano = g_tipo_causadañoplacas.Id) INNER JOIN g_procedimiento  ON (h_informe_detalle_imagenesdx.Id_Procedimiento = g_procedimiento.Id)  WHERE (g_tipo_causadañoplacas.Id <>1 AND h_informe_imagenesdx.FechaR >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND h_informe_imagenesdx.FechaR <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "') GROUP BY g_procedimiento.Nbre ORDER BY g_procedimiento.Nbre ASC ";
        ResultSet rs = this.xct.traerRs(this.xsql);
        try {
            if (rs.next()) {
                rs.beforeFirst();
                int x = 0;
                while (rs.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(Long.valueOf(rs.getLong(1)), x, 0);
                    this.xmodelo.setValueAt(rs.getString(2), x, 1);
                    this.xmodelo.setValueAt(Long.valueOf(rs.getLong(3)), x, 2);
                    x++;
                }
            }
            rs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            this.xct.mostrarErrorSQL(ex);
        }
    }

    private void mCargarDetalle1() {
        mCrearTablaDetalle1();
        if (this.xtipoc == 0) {
            this.xsql = "SELECT g_tipo_causadañoplacas.Id,  g_tipo_causadañoplacas.Nbre, COUNT(g_tipo_causadañoplacas.Id) FROM h_informe_detalle_imagenesdx INNER JOIN h_informe_imagenesdx  ON (h_informe_detalle_imagenesdx.Id_infomesdx = h_informe_imagenesdx.Id) INNER JOIN g_tipo_placasrx  ON (h_informe_detalle_imagenesdx.Id_TipoPlaca = g_tipo_placasrx.Id) INNER JOIN g_tipo_causadañoplacas  ON (h_informe_detalle_imagenesdx.Id_TipoDano = g_tipo_causadañoplacas.Id) INNER JOIN g_procedimiento  ON (h_informe_detalle_imagenesdx.Id_Procedimiento = g_procedimiento.Id) WHERE (g_tipo_causadañoplacas.Id <>1 AND h_informe_imagenesdx.FechaR >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND h_informe_imagenesdx.FechaR <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' AND h_informe_imagenesdx.Estado=1) GROUP BY g_tipo_causadañoplacas.Nbre ORDER BY g_procedimiento.Nbre ASC ";
        } else {
            this.xsql = "SELECT g_tipo_causadañoplacas.Id, g_tipo_causadañoplacas.Nbre, COUNT(g_tipo_causadañoplacas.Id) FROM h_informe_detalle_imagenesdx INNER JOIN h_informe_imagenesdx  ON (h_informe_detalle_imagenesdx.Id_infomesdx = h_informe_imagenesdx.Id) INNER JOIN g_tipo_placasrx  ON (h_informe_detalle_imagenesdx.Id_TipoPlaca = g_tipo_placasrx.Id) INNER JOIN g_tipo_causadañoplacas  ON (h_informe_detalle_imagenesdx.Id_TipoDano = g_tipo_causadañoplacas.Id) INNER JOIN g_procedimiento  ON (h_informe_detalle_imagenesdx.Id_Procedimiento = g_procedimiento.Id) WHERE (g_tipo_causadañoplacas.Id <>1 AND h_informe_imagenesdx.FechaR >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND h_informe_imagenesdx.FechaR <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' AND h_informe_imagenesdx.Estado=1 and g_procedimiento.Id='" + this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0) + "')GROUP BY g_tipo_causadañoplacas.Nbre ORDER BY g_procedimiento.Nbre ASC ";
        }
        ResultSet rs = this.xct.traerRs(this.xsql);
        try {
            if (rs.next()) {
                rs.beforeFirst();
                int x = 0;
                while (rs.next()) {
                    this.xmodelo1.addRow(this.xdato);
                    this.xmodelo1.setValueAt(Long.valueOf(rs.getLong(1)), x, 0);
                    this.xmodelo1.setValueAt(rs.getString(2), x, 1);
                    this.xmodelo1.setValueAt(Long.valueOf(rs.getLong(3)), x, 2);
                    x++;
                }
            }
            rs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            this.xct.mostrarErrorSQL(ex);
        }
    }

    private void mCargarDetalle2() {
        mCrearTablaDetalle2();
        if (this.xtipoc == 0) {
            this.xsql = "SELECT g_tipo_placasrx.Nbre, COUNT(g_tipo_causadañoplacas.Id) FROM h_informe_detalle_imagenesdx INNER JOIN h_informe_imagenesdx  ON (h_informe_detalle_imagenesdx.Id_infomesdx = h_informe_imagenesdx.Id) INNER JOIN g_tipo_placasrx  ON (h_informe_detalle_imagenesdx.Id_TipoPlaca = g_tipo_placasrx.Id) INNER JOIN g_tipo_causadañoplacas  ON (h_informe_detalle_imagenesdx.Id_TipoDano = g_tipo_causadañoplacas.Id) INNER JOIN g_procedimiento  ON (h_informe_detalle_imagenesdx.Id_Procedimiento = g_procedimiento.Id) WHERE (g_tipo_causadañoplacas.Id <>1 AND h_informe_imagenesdx.FechaR >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND h_informe_imagenesdx.FechaR <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' AND h_informe_imagenesdx.Estado=1) GROUP BY g_tipo_placasrx.Nbre ORDER BY g_tipo_placasrx.Nbre ASC ";
        } else {
            this.xsql = "SELECT g_tipo_placasrx.Nbre, COUNT(g_tipo_causadañoplacas.Id) FROM h_informe_detalle_imagenesdx INNER JOIN h_informe_imagenesdx  ON (h_informe_detalle_imagenesdx.Id_infomesdx = h_informe_imagenesdx.Id) INNER JOIN g_tipo_placasrx  ON (h_informe_detalle_imagenesdx.Id_TipoPlaca = g_tipo_placasrx.Id) INNER JOIN g_tipo_causadañoplacas  ON (h_informe_detalle_imagenesdx.Id_TipoDano = g_tipo_causadañoplacas.Id) INNER JOIN g_procedimiento  ON (h_informe_detalle_imagenesdx.Id_Procedimiento = g_procedimiento.Id) WHERE (g_tipo_causadañoplacas.Id <>1 AND h_informe_imagenesdx.FechaR >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND h_informe_imagenesdx.FechaR <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' and g_tipo_causadañoplacas.Id='" + this.xmodelo1.getValueAt(this.JTDetalle1.getSelectedRow(), 0) + "'and g_procedimiento.Id='" + this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0) + "' AND h_informe_imagenesdx.Estado=1) GROUP BY g_tipo_placasrx.Nbre ORDER BY g_tipo_placasrx.Nbre ASC ";
        }
        ResultSet rs = this.xct.traerRs(this.xsql);
        try {
            if (rs.next()) {
                rs.beforeFirst();
                int x = 0;
                while (rs.next()) {
                    this.xmodelo2.addRow(this.xdato);
                    this.xmodelo2.setValueAt(rs.getString(1), x, 0);
                    this.xmodelo2.setValueAt(Long.valueOf(rs.getLong(2)), x, 1);
                    x++;
                }
            }
            rs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            this.xct.mostrarErrorSQL(ex);
        }
    }

    private void mExportar() {
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            try {
                WritableWorkbook workbook = Workbook.createWorkbook(new File(this.JTFRuta.getText() + ".xls"));
                WritableSheet sheet = workbook.createSheet("CEstudio", 0);
                for (int x = 0; x < this.JTDetalle.getColumnCount(); x++) {
                    sheet.addCell(new Label(x, 0, this.JTDetalle.getColumnName(x)));
                }
                for (int x2 = 0; x2 < this.JTDetalle.getRowCount(); x2++) {
                    sheet.addCell(new Number(0, x2 + 1, Long.valueOf(this.xmodelo.getValueAt(x2, 0).toString()).longValue()));
                    sheet.addCell(new Label(1, x2 + 1, this.xmodelo.getValueAt(x2, 1).toString()));
                    sheet.addCell(new Number(2, x2 + 1, Long.valueOf(this.xmodelo.getValueAt(x2, 2).toString()).longValue()));
                }
                WritableSheet sheet2 = workbook.createSheet("CTipoDaño", 1);
                for (int x3 = 0; x3 < this.JTDetalle1.getColumnCount(); x3++) {
                    sheet2.addCell(new Label(x3, 0, this.JTDetalle1.getColumnName(x3)));
                }
                for (int x4 = 0; x4 < this.JTDetalle1.getRowCount(); x4++) {
                    sheet2.addCell(new Number(0, x4 + 1, Long.valueOf(this.xmodelo1.getValueAt(x4, 0).toString()).longValue()));
                    sheet2.addCell(new Label(1, x4 + 1, this.xmodelo1.getValueAt(x4, 1).toString()));
                    sheet2.addCell(new Number(2, x4 + 1, Long.valueOf(this.xmodelo1.getValueAt(x4, 2).toString()).longValue()));
                }
                WritableSheet sheet3 = workbook.createSheet("CPlaca", 2);
                for (int x5 = 0; x5 < this.JTDetalle2.getColumnCount(); x5++) {
                    sheet3.addCell(new Label(x5, 0, this.JTDetalle2.getColumnName(x5)));
                }
                for (int x6 = 0; x6 < this.JTDetalle2.getRowCount(); x6++) {
                    sheet3.addCell(new Label(0, x6 + 1, this.xmodelo2.getValueAt(x6, 0).toString()));
                    sheet3.addCell(new Number(1, x6 + 1, Long.valueOf(this.xmodelo2.getValueAt(x6, 1).toString()).longValue()));
                }
                workbook.write();
                workbook.close();
            } catch (IOException ex) {
                Logger.getLogger(JIFConsultarInf3Tabla.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            } catch (WriteException e) {
                Logger.getLogger(JIFConsultarInf3Tabla.class.getName()).log(Level.SEVERE, (String) null, e);
            }
        }
    }
}
