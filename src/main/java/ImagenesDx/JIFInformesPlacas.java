package ImagenesDx;

import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

/* JADX INFO: loaded from: GenomaP.jar:ImagenesDx/JIFInformesPlacas.class */
public class JIFInformesPlacas extends JInternalFrame {
    private Object[] xdatos;
    private String xnombre;
    public static boolean v = true;
    private JButton JBTExportar;
    private JDateChooser JDFechaF;
    private JDateChooser JDFechaI;
    private JPanel JPDatosP;
    private JScrollPane JSPTablaR;
    private JTable JTBResultadoP;
    private JFormattedTextField JTFFPorcentaje;
    private JFormattedTextField JTFFTotalPlacas;
    private JFormattedTextField JTFFTotalPlacasD;
    private DefaultTableModel xmodelo = new DefaultTableModel();
    private ConsultasMySQL xconsulta = new ConsultasMySQL();
    private Metodos xmetodos = new Metodos();

    public JIFInformesPlacas(String xtitulo, String xnombre) {
        initComponents();
        setTitle(xtitulo.toUpperCase());
        this.xnombre = xnombre;
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v7, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JSPTablaR = new JScrollPane();
        this.JTBResultadoP = new JTable();
        this.JPDatosP = new JPanel();
        this.JDFechaI = new JDateChooser();
        this.JDFechaF = new JDateChooser();
        this.JBTExportar = new JButton();
        this.JTFFTotalPlacas = new JFormattedTextField();
        this.JTFFTotalPlacasD = new JFormattedTextField();
        this.JTFFPorcentaje = new JFormattedTextField();
        setClosable(true);
        setIconifiable(true);
        setTitle("INFORME DE PLACAS");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifinformeplacas");
        this.JSPTablaR.setBorder(BorderFactory.createTitledBorder((Border) null, "RESULTADO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JSPTablaR.setFont(new Font("Arial", 1, 12));
        this.JTBResultadoP.setFont(new Font("Arial", 1, 12));
        this.JTBResultadoP.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTBResultadoP.setRowHeight(25);
        this.JTBResultadoP.setSelectionBackground(new Color(255, 255, 255));
        this.JTBResultadoP.setSelectionForeground(new Color(255, 0, 0));
        this.JTBResultadoP.setSelectionMode(0);
        this.JTBResultadoP.addKeyListener(new KeyAdapter() { // from class: ImagenesDx.JIFInformesPlacas.1
            public void keyPressed(KeyEvent evt) {
                JIFInformesPlacas.this.JTBResultadoPKeyPressed(evt);
            }
        });
        this.JSPTablaR.setViewportView(this.JTBResultadoP);
        this.JPDatosP.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS CONSULTA", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JPDatosP.setFont(new Font("Arial", 1, 12));
        this.JDFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicial", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFechaI.setFont(new Font("Arial", 1, 12));
        this.JDFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Final", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFechaF.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setForeground(Color.red);
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/actualizar.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: ImagenesDx.JIFInformesPlacas.2
            public void actionPerformed(ActionEvent evt) {
                JIFInformesPlacas.this.JBTExportarActionPerformed(evt);
            }
        });
        GroupLayout JPDatosPLayout = new GroupLayout(this.JPDatosP);
        this.JPDatosP.setLayout(JPDatosPLayout);
        JPDatosPLayout.setHorizontalGroup(JPDatosPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosPLayout.createSequentialGroup().addContainerGap().addComponent(this.JDFechaI, -2, 120, -2).addGap(18, 18, 18).addComponent(this.JDFechaF, -2, 120, -2).addGap(18, 18, 18).addComponent(this.JBTExportar, -1, 253, 32767).addContainerGap()));
        JPDatosPLayout.setVerticalGroup(JPDatosPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPDatosPLayout.createSequentialGroup().addContainerGap().addGroup(JPDatosPLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JBTExportar, GroupLayout.Alignment.LEADING, -1, -1, 32767).addGroup(GroupLayout.Alignment.LEADING, JPDatosPLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JDFechaI, -2, 54, -2).addComponent(this.JDFechaF, -1, -1, 32767))).addContainerGap()));
        this.JTFFTotalPlacas.setBorder(BorderFactory.createTitledBorder((Border) null, "Total Placas", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFTotalPlacas.setHorizontalAlignment(4);
        this.JTFFTotalPlacas.setFont(new Font("Arial", 1, 12));
        this.JTFFTotalPlacasD.setBorder(BorderFactory.createTitledBorder((Border) null, "Total Placas Dañadas", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFTotalPlacasD.setHorizontalAlignment(4);
        this.JTFFTotalPlacasD.setFont(new Font("Arial", 1, 12));
        this.JTFFPorcentaje.setBorder(BorderFactory.createTitledBorder((Border) null, "%", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFPorcentaje.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter()));
        this.JTFFPorcentaje.setHorizontalAlignment(4);
        this.JTFFPorcentaje.setFont(new Font("Arial", 1, 12));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPTablaR, -1, 565, 32767).addComponent(this.JPDatosP, -1, -1, 32767).addGroup(layout.createSequentialGroup().addComponent(this.JTFFTotalPlacas, -2, 141, -2).addGap(18, 18, 18).addComponent(this.JTFFTotalPlacasD, -2, 141, -2).addGap(18, 18, 18).addComponent(this.JTFFPorcentaje, -2, 141, -2))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPDatosP, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPTablaR, -2, 187, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFTotalPlacas, -1, 50, 32767).addComponent(this.JTFFTotalPlacasD, -1, 50, 32767).addComponent(this.JTFFPorcentaje, -1, 50, 32767)).addGap(20, 20, 20)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTExportarActionPerformed(ActionEvent evt) {
        mExportar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBResultadoPKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 127 && this.JTBResultadoP.getSelectedRow() != -1) {
            int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de eliminar?", "Confirmación", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                this.xmodelo.removeRow(this.JTBResultadoP.getSelectedRow());
            }
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Placa", "C/Utilizada", "C/Dañadas", "%"}) { // from class: ImagenesDx.JIFInformesPlacas.3
            Class[] types = {Long.class, String.class, Double.class, Double.class, Double.class};
            boolean[] canEdit = {false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTBResultadoP.setModel(this.xmodelo);
        this.JTBResultadoP.getColumnModel().getColumn(0).setPreferredWidth(5);
        this.JTBResultadoP.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTBResultadoP.getColumnModel().getColumn(2).setPreferredWidth(20);
        this.JTBResultadoP.getColumnModel().getColumn(3).setPreferredWidth(20);
        this.JTBResultadoP.getColumnModel().getColumn(4).setPreferredWidth(20);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos1() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"N° Usuarios", "N° Estudios", "Días", "%D"}) { // from class: ImagenesDx.JIFInformesPlacas.4
            Class[] types = {Long.class, Long.class, Long.class, Double.class};
            boolean[] canEdit = {false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTBResultadoP.setModel(this.xmodelo);
        this.JTBResultadoP.getColumnModel().getColumn(0).setPreferredWidth(80);
        this.JTBResultadoP.getColumnModel().getColumn(1).setPreferredWidth(80);
        this.JTBResultadoP.getColumnModel().getColumn(2).setPreferredWidth(20);
        this.JTBResultadoP.getColumnModel().getColumn(3).setPreferredWidth(20);
    }

    private void mCargarDatosTabla() {
        try {
            mCrearModeloDatos();
            String xsql = "SELECT g_tipo_placasrx.Id, g_tipo_placasrx.Nbre , sum(h_informe_detalle_imagenesdx.Cantidad) AS Cantidad FROM h_informe_detalle_imagenesdx INNER JOIN h_informe_imagenesdx  ON (h_informe_detalle_imagenesdx.Id_infomesdx = h_informe_imagenesdx.Id) INNER JOIN g_tipo_placasrx  ON (h_informe_detalle_imagenesdx.Id_TipoPlaca = g_tipo_placasrx.Id)  WHERE (h_informe_imagenesdx.FechaR >='" + this.xmetodos.formatoAMD.format(this.JDFechaI.getDate()) + "' AND h_informe_imagenesdx.FechaR <='" + this.xmetodos.formatoAMD.format(this.JDFechaF.getDate()) + "' AND h_informe_imagenesdx.Estado =1 AND h_informe_detalle_imagenesdx.Id_TipoDano =1)GROUP BY g_tipo_placasrx.Id ORDER BY g_tipo_placasrx.Id ASC ";
            ResultSet xrs = this.xconsulta.traerRs(xsql);
            double xtotal1 = 0.0d;
            double xtotal2 = 0.0d;
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    ConsultasMySQL xct = new ConsultasMySQL();
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(1)), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(3)), n, 2);
                    xtotal1 += xrs.getLong(3);
                    String xsql2 = "SELECT sum(h_informe_detalle_imagenesdx.Cantidad) AS Cantidad FROM h_informe_detalle_imagenesdx INNER JOIN h_informe_imagenesdx  ON (h_informe_detalle_imagenesdx.Id_infomesdx = h_informe_imagenesdx.Id) INNER JOIN g_tipo_placasrx  ON (h_informe_detalle_imagenesdx.Id_TipoPlaca = g_tipo_placasrx.Id)  WHERE (h_informe_imagenesdx.FechaR >='" + this.xmetodos.formatoAMD.format(this.JDFechaI.getDate()) + "' AND h_informe_imagenesdx.FechaR <='" + this.xmetodos.formatoAMD.format(this.JDFechaF.getDate()) + "' AND h_informe_imagenesdx.Estado =1 AND h_informe_detalle_imagenesdx.Id_TipoDano <>1 and g_tipo_placasrx.Id='" + xrs.getLong(1) + "') GROUP BY g_tipo_placasrx.Id ";
                    ResultSet rs = xct.traerRs(xsql2);
                    if (rs.next()) {
                        this.xmodelo.setValueAt(Integer.valueOf(rs.getInt(1)), n, 3);
                        xtotal2 += rs.getLong(1);
                    } else {
                        this.xmodelo.setValueAt(0, n, 3);
                    }
                    this.xmodelo.setValueAt(Double.valueOf(Double.valueOf(this.xmodelo.getValueAt(n, 3).toString()).doubleValue() / Double.valueOf(this.xmodelo.getValueAt(n, 2).toString()).doubleValue()), n, 4);
                    rs.close();
                    xct.cerrarConexionBd();
                    n++;
                }
            }
            double xt = xtotal2 / xtotal1;
            this.JTFFTotalPlacas.setValue(Double.valueOf(xtotal1));
            this.JTFFTotalPlacasD.setValue(Double.valueOf(xtotal2));
            this.JTFFPorcentaje.setValue(Double.valueOf(xt));
            xrs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFInformesPlacas.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarDatosTabla1() {
        try {
            mCrearModeloDatos1();
            String xsql = "SELECT  COUNT(DISTINCT(Id_OrdenFac)) AS NUsuario, COUNT(h_informe_detalle_imagenesdx.Id_Procedimiento) AS NEstudios ,SUM(DATEDIFF(h_informe_imagenesdx.FechaR, f_ordenes.FechaOrden )) AS DDiasAtencion ,   ROUND((SUM(DATEDIFF(h_informe_imagenesdx.FechaR, f_ordenes.FechaOrden ))/COUNT(h_informe_detalle_imagenesdx.Id_Procedimiento))) AS Resultado      FROM h_informe_detalle_imagenesdx  INNER JOIN h_informe_imagenesdx  ON (h_informe_detalle_imagenesdx.Id_infomesdx = h_informe_imagenesdx.Id)  INNER JOIN f_ordenes  ON (h_informe_detalle_imagenesdx.Id_OrdenFac = f_ordenes.Id) WHERE (h_informe_imagenesdx.FechaR >='" + this.xmetodos.formatoAMD.format(this.JDFechaI.getDate()) + "' AND h_informe_imagenesdx.FechaR <='" + this.xmetodos.formatoAMD.format(this.JDFechaF.getDate()) + "' AND h_informe_imagenesdx.Estado =1) ";
            ResultSet xrs = this.xconsulta.traerRs(xsql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(1)), n, 0);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(2)), n, 1);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(3)), n, 2);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(4)), n, 3);
                    n++;
                }
            }
            xrs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFInformesPlacas.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mNuevo() {
        this.JDFechaI.setDate(this.xmetodos.getFechaActual());
        this.JDFechaF.setDate(this.xmetodos.getFechaActual());
        if (this.xnombre.equals("jifinformeplacas")) {
            this.JTFFTotalPlacas.setBorder(BorderFactory.createTitledBorder((Border) null, "Total Placas", 0, 0, new Font("Arial", 1, 12), Color.blue));
            this.JTFFTotalPlacasD.setBorder(BorderFactory.createTitledBorder((Border) null, "Total Placas Dañadas", 0, 0, new Font("Arial", 1, 12), Color.blue));
            mCrearModeloDatos();
        } else if (this.xnombre.equals("xjifestudiosrealizados")) {
            this.JTFFTotalPlacas.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Usuarios", 0, 0, new Font("Arial", 1, 12), Color.blue));
            this.JTFFTotalPlacasD.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Placas", 0, 0, new Font("Arial", 1, 12), Color.blue));
            mCrearModeloDatos1();
        }
        this.JTFFTotalPlacasD.setValue(new Integer(0));
        this.JTFFTotalPlacas.setValue(new Integer(0));
        this.JTFFPorcentaje.setValue(new Integer(0));
    }

    public void mBuscar() {
        if (this.xnombre.equals("jifinformeplacas")) {
            mCargarDatosTabla();
        } else if (this.xnombre.equals("xjifestudiosrealizados")) {
            mCargarDatosTabla1();
        }
    }

    private void mExportar() {
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            try {
                WritableWorkbook workbook = Workbook.createWorkbook(new File("c:\\plantilla.xls"));
                WritableSheet sheet = workbook.createSheet("plantilla", 0);
                for (int x = 0; x < this.JTBResultadoP.getColumnCount(); x++) {
                    sheet.addCell(new Label(x, 0, this.JTBResultadoP.getColumnName(x)));
                }
                int y = 1;
                for (int x2 = 0; x2 < this.JTBResultadoP.getRowCount(); x2++) {
                    sheet.addCell(new Number(0, y, Integer.valueOf(this.xmodelo.getValueAt(x2, 0).toString()).intValue()));
                    if (this.xnombre.equals("jifinformeplacas")) {
                        sheet.addCell(new Label(1, y, this.xmodelo.getValueAt(x2, 1).toString()));
                        sheet.addCell(new Number(2, y, Integer.valueOf(this.xmodelo.getValueAt(x2, 2).toString()).intValue()));
                        sheet.addCell(new Number(3, y, Integer.valueOf(this.xmodelo.getValueAt(x2, 3).toString()).intValue()));
                        sheet.addCell(new Number(4, y, Double.valueOf(this.xmodelo.getValueAt(x2, 4).toString()).doubleValue()));
                    } else if (this.xnombre.equals("xjifestudiosrealizados")) {
                        sheet.addCell(new Number(1, y, Integer.valueOf(this.xmodelo.getValueAt(x2, 1).toString()).intValue()));
                        sheet.addCell(new Number(2, y, Integer.valueOf(this.xmodelo.getValueAt(x2, 2).toString()).intValue()));
                        sheet.addCell(new Number(3, y, Double.valueOf(this.xmodelo.getValueAt(x2, 3).toString()).doubleValue()));
                    }
                    y++;
                }
                workbook.write();
                workbook.close();
            } catch (IOException ex) {
                Logger.getLogger(JIFInformesPlacas.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            } catch (WriteException e) {
                Logger.getLogger(JIFInformesPlacas.class.getName()).log(Level.SEVERE, (String) null, e);
            }
        }
    }
}
