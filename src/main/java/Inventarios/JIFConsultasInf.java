package Inventarios;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyVetoException;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
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

/* JADX INFO: loaded from: GenomaP.jar:Inventarios/JIFConsultasInf.class */
public class JIFConsultasInf extends JInternalFrame {
    private ConsultasMySQL xconsulta = new ConsultasMySQL();
    private Metodos xmetodos = new Metodos();
    private DefaultTableModel xmodelo;
    private Object[] xdatos;
    private String[] xidbodega;
    private String[] xidperiodo;
    private String xname;
    private ButtonGroup JBGSeleccion;
    private ButtonGroup JBGSeleccion1;
    public JComboBox JCBBodega;
    private JComboBox JCBPeriodo;
    private JDateChooser JDFechaF;
    private JDateChooser JDFechaI;
    private JPanel JPIDatos;
    private JPanel JPIPresentacion;
    private JPanel JPITipoMovi;
    private JPanel JPITotales;
    private JRadioButton JRBConsolidada;
    private JRadioButton JRBDetallada;
    private JRadioButton JRBEntrada;
    private JRadioButton JRBSalida;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;
    private JFormattedTextField JTFFTotal1;
    private JFormattedTextField JTFFTotal2;
    private JFormattedTextField JTFFTotal3;

    public JIFConsultasInf(String xname) {
        initComponents();
        setName(xname);
        this.xidbodega = this.xconsulta.llenarCombo("SELECT Id, Nbre FROM i_bodegas WHERE (Estado =0) ORDER BY Nbre ASC", this.xidbodega, this.JCBBodega);
        this.JCBBodega.setSelectedIndex(-1);
        this.xconsulta.cerrarConexionBd();
        this.JDFechaI.setDate(this.xmetodos.getFechaActual());
        this.JDFechaF.setDate(this.xmetodos.getFechaActual());
        this.JTFFTotal1.setValue(new Long(0L));
        this.JTFFTotal2.setValue(new Long(0L));
        this.JTFFTotal3.setValue(new Long(0L));
        this.xname = xname;
        if (xname.equals("jifconsultarinformesi1") || xname.equals("jifconsultarinformesi2")) {
            this.JPIPresentacion.setVisible(false);
            this.JPITipoMovi.setVisible(false);
            this.xidperiodo = this.xconsulta.llenarCombo("SELECT Id, CONCAT(DevuelveMes(FechaF), '-',DATE_FORMAT(FechaF,'%Y')) AS MesC FROM i_periodo order by FechaF desc", this.xidperiodo, this.JCBPeriodo);
            this.xconsulta.cerrarConexionBd();
            this.JCBPeriodo.setSelectedIndex(-1);
        } else {
            this.xidperiodo = this.xconsulta.llenarCombo("SELECT Id, CONCAT(DevuelveMes(FechaF), '-',DATE_FORMAT(FechaF,'%Y')) AS MesC FROM i_periodo order by FechaF desc", this.xidperiodo, this.JCBPeriodo);
        }
        this.xconsulta.cerrarConexionBd();
        mCrearModeloDatos();
    }

    /* JADX WARN: Type inference failed for: r3v60, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGSeleccion = new ButtonGroup();
        this.JBGSeleccion1 = new ButtonGroup();
        this.JPIDatos = new JPanel();
        this.JCBBodega = new JComboBox();
        this.JDFechaI = new JDateChooser();
        this.JDFechaF = new JDateChooser();
        this.JPIPresentacion = new JPanel();
        this.JRBConsolidada = new JRadioButton();
        this.JRBDetallada = new JRadioButton();
        this.JPITipoMovi = new JPanel();
        this.JRBEntrada = new JRadioButton();
        this.JRBSalida = new JRadioButton();
        this.JCBPeriodo = new JComboBox();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JPITotales = new JPanel();
        this.JTFFTotal1 = new JFormattedTextField();
        this.JTFFTotal2 = new JFormattedTextField();
        this.JTFFTotal3 = new JFormattedTextField();
        setClosable(true);
        setIconifiable(true);
        setTitle("INFORMES");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setMaximumSize(new Dimension(817, 640));
        setMinimumSize(new Dimension(817, 640));
        setName("jifconsultarinformesi");
        try {
            setSelected(true);
        } catch (PropertyVetoException e1) {
            e1.printStackTrace();
        }
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JCBBodega.setFont(new Font("Arial", 1, 12));
        this.JCBBodega.setBorder(BorderFactory.createTitledBorder((Border) null, "Bodega", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicial", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFechaI.setFont(new Font("Arial", 1, 12));
        this.JDFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Final", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFechaF.setFont(new Font("Arial", 1, 12));
        this.JPIPresentacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Presentación de Información", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBGSeleccion1.add(this.JRBConsolidada);
        this.JRBConsolidada.setFont(new Font("Arial", 1, 12));
        this.JRBConsolidada.setSelected(true);
        this.JRBConsolidada.setText("Consolidada");
        this.JBGSeleccion1.add(this.JRBDetallada);
        this.JRBDetallada.setFont(new Font("Arial", 1, 12));
        this.JRBDetallada.setText("Detallada");
        GroupLayout JPIPresentacionLayout = new GroupLayout(this.JPIPresentacion);
        this.JPIPresentacion.setLayout(JPIPresentacionLayout);
        JPIPresentacionLayout.setHorizontalGroup(JPIPresentacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIPresentacionLayout.createSequentialGroup().addComponent(this.JRBConsolidada).addGap(18, 18, 18).addComponent(this.JRBDetallada).addGap(10, 10, 10)));
        JPIPresentacionLayout.setVerticalGroup(JPIPresentacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIPresentacionLayout.createSequentialGroup().addGroup(JPIPresentacionLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBConsolidada).addComponent(this.JRBDetallada)).addGap(10, 10, 10)));
        this.JPITipoMovi.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo de Movimiento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBGSeleccion.add(this.JRBEntrada);
        this.JRBEntrada.setFont(new Font("Arial", 1, 12));
        this.JRBEntrada.setSelected(true);
        this.JRBEntrada.setText("Entrada");
        this.JBGSeleccion.add(this.JRBSalida);
        this.JRBSalida.setFont(new Font("Arial", 1, 12));
        this.JRBSalida.setText("Salida");
        GroupLayout JPITipoMoviLayout = new GroupLayout(this.JPITipoMovi);
        this.JPITipoMovi.setLayout(JPITipoMoviLayout);
        JPITipoMoviLayout.setHorizontalGroup(JPITipoMoviLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPITipoMoviLayout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.JRBEntrada).addGap(18, 18, 18).addComponent(this.JRBSalida).addGap(10, 10, 10)));
        JPITipoMoviLayout.setVerticalGroup(JPITipoMoviLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPITipoMoviLayout.createSequentialGroup().addGroup(JPITipoMoviLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBEntrada).addComponent(this.JRBSalida)).addGap(10, 10, 10)));
        this.JCBPeriodo.setFont(new Font("Arial", 1, 12));
        this.JCBPeriodo.setBorder(BorderFactory.createTitledBorder((Border) null, "Periodo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JDFechaI, -2, 120, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JDFechaF, -2, 120, -2).addGap(18, 18, 18).addComponent(this.JCBBodega, -2, 492, -2)).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosLayout.createSequentialGroup().addComponent(this.JCBPeriodo, 0, -1, 32767).addGap(18, 18, 18).addComponent(this.JPIPresentacion, -2, -1, -2).addGap(18, 18, 18).addComponent(this.JPITipoMovi, -2, -1, -2))).addContainerGap()));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBBodega, -2, -1, -2).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JDFechaF, GroupLayout.Alignment.LEADING, -1, -1, -2).addComponent(this.JDFechaI, GroupLayout.Alignment.LEADING, -1, -1, -2))).addGap(10, 10, 10).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPIPresentacion, -2, -1, -2).addComponent(this.JPITipoMovi, -2, -1, -2)).addComponent(this.JCBPeriodo, -2, 50, -2)).addGap(10, 10, 10)));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: Inventarios.JIFConsultasInf.1
            public void mouseClicked(MouseEvent evt) {
                JIFConsultasInf.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.JPITotales.setBorder(BorderFactory.createTitledBorder((Border) null, "TOTALES", 0, 0, new Font("Arial", 1, 14), Color.red));
        this.JTFFTotal1.setEditable(false);
        this.JTFFTotal1.setBorder(BorderFactory.createTitledBorder((Border) null, "NFormulas", 0, 0, new Font("Arial", 1, 13), Color.blue));
        this.JTFFTotal1.setForeground(Color.red);
        this.JTFFTotal1.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFTotal1.setHorizontalAlignment(0);
        this.JTFFTotal1.setFont(new Font("Arial", 1, 18));
        this.JTFFTotal2.setEditable(false);
        this.JTFFTotal2.setBorder(BorderFactory.createTitledBorder((Border) null, "NItems", 0, 0, new Font("Arial", 1, 13), Color.blue));
        this.JTFFTotal2.setForeground(Color.red);
        this.JTFFTotal2.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFTotal2.setHorizontalAlignment(0);
        this.JTFFTotal2.setFont(new Font("Arial", 1, 18));
        this.JTFFTotal3.setEditable(false);
        this.JTFFTotal3.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor", 0, 0, new Font("Arial", 1, 13), Color.blue));
        this.JTFFTotal3.setForeground(Color.red);
        this.JTFFTotal3.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFTotal3.setHorizontalAlignment(0);
        this.JTFFTotal3.setFont(new Font("Arial", 1, 18));
        GroupLayout JPITotalesLayout = new GroupLayout(this.JPITotales);
        this.JPITotales.setLayout(JPITotalesLayout);
        JPITotalesLayout.setHorizontalGroup(JPITotalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPITotalesLayout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.JTFFTotal1, -2, 116, -2).addGap(18, 18, 18).addComponent(this.JTFFTotal2, -2, 116, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFFTotal3, -2, 184, -2).addContainerGap()));
        JPITotalesLayout.setVerticalGroup(JPITotalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPITotalesLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFTotal3, -2, -1, -2).addComponent(this.JTFFTotal1, -2, -1, -2).addComponent(this.JTFFTotal2, -2, -1, -2)));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JSPDetalle, -2, 784, -2).addComponent(this.JPIDatos, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addComponent(this.JPITotales, GroupLayout.Alignment.TRAILING, -2, -1, -2)).addGap(10, 10, 10)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalle, -2, 338, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPITotales, -2, -1, -2).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
    }

    public void mBuscar() {
        if (this.xname.equals("jifconsultarinformesi")) {
            if (this.JRBEntrada.isSelected() && this.JRBConsolidada.isSelected()) {
                String sql = "SELECT i_tiposmovimientos.Nbre, round(SUM((((Cantidad*ValorUnitario)*Iva)/100)+(Cantidad*ValorUnitario))) AS Valor, i_tiposmovimientos.CPuc_Debito, i_tiposmovimientos.CPuc_Credito  FROM baseserver.i_entradas INNER JOIN baseserver.i_tiposmovimientos ON (i_entradas.IdTipoMovimiento = i_tiposmovimientos.Id) INNER JOIN baseserver.i_detalleentrada  ON (i_detalleentrada.IdEntrada = i_entradas.Id) WHERE (i_entradas.Estado =0 AND i_entradas.IdBodega ='" + this.xidbodega[this.JCBBodega.getSelectedIndex()] + "' AND i_entradas.Id_Periodo='" + this.xidperiodo[this.JCBPeriodo.getSelectedIndex()] + "') GROUP BY i_tiposmovimientos.Nbre  ORDER BY i_tiposmovimientos.Nbre ASC ";
                mCargarDatosTabla(sql);
                mExportar(sql);
                return;
            }
            if (this.JRBEntrada.isSelected() && this.JRBDetallada.isSelected()) {
                String sql2 = "SELECT i_tiposmovimientos.Nbre, i_entradas.Id, i_entradas.FechaEntrada, round(SUM((((Cantidad*ValorUnitario)*Iva)/100)+(Cantidad*ValorUnitario))) AS Valor, i_tiposmovimientos.CPuc_Debito, i_tiposmovimientos.CPuc_Credito  FROM baseserver.i_entradas INNER JOIN baseserver.i_tiposmovimientos  ON (i_entradas.IdTipoMovimiento = i_tiposmovimientos.Id) INNER JOIN baseserver.i_detalleentrada  ON (i_detalleentrada.IdEntrada = i_entradas.Id)  WHERE (i_entradas.Id_Periodo ='" + this.xidperiodo[this.JCBPeriodo.getSelectedIndex()] + "' AND i_entradas.Estado =0 AND i_entradas.IdBodega ='" + this.xidbodega[this.JCBBodega.getSelectedIndex()] + "') GROUP BY i_entradas.Id ORDER BY i_tiposmovimientos.Nbre ASC, i_entradas.FechaEntrada ASC ";
                mCargarDatosTabla1(sql2);
                mExportar1(sql2);
                return;
            } else if (this.JRBSalida.isSelected() && this.JRBConsolidada.isSelected()) {
                String sql3 = "SELECT i_tiposmovimientos.Nbre, round(SUM((CantidadDespachada*ValorUnitario))) AS VALOR, i_tiposmovimientos.CPuc_Debito, i_tiposmovimientos.CPuc_Credito  FROM i_salidas INNER JOIN baseserver.i_tiposmovimientos  ON (i_salidas.IdTipoMovimiento = i_tiposmovimientos.Id)  INNER JOIN baseserver.i_detallesalida  ON (i_detallesalida.IdSalida = i_salidas.Id) WHERE (i_salidas.IdBodega ='" + this.xidbodega[this.JCBBodega.getSelectedIndex()] + "' AND i_salidas.Id_Periodo ='" + this.xidperiodo[this.JCBPeriodo.getSelectedIndex()] + "' AND i_salidas.Estado =0) GROUP BY i_tiposmovimientos.Nbre  ORDER BY i_tiposmovimientos.Nbre ASC ";
                mCargarDatosTabla(sql3);
                mExportar(sql3);
                return;
            } else {
                if (this.JRBSalida.isSelected() && this.JRBDetallada.isSelected()) {
                    String sql4 = "SELECT i_tiposmovimientos.Nbre, i_salidas.Id, i_salidas.FechaSalida, round(SUM((CantidadDespachada*ValorUnitario))) AS Valor, i_tiposmovimientos.CPuc_Debito, i_tiposmovimientos.CPuc_Credito  FROM baseserver.i_detallesalida INNER JOIN baseserver.i_salidas  ON (i_detallesalida.IdSalida = i_salidas.Id) INNER JOIN baseserver.i_tiposmovimientos  ON (i_salidas.IdTipoMovimiento = i_tiposmovimientos.Id) WHERE (i_salidas.IdBodega ='" + this.xidbodega[this.JCBBodega.getSelectedIndex()] + "'  AND i_salidas.Estado =0 AND i_salidas.Id_Periodo ='" + this.xidperiodo[this.JCBPeriodo.getSelectedIndex()] + "') GROUP BY i_salidas.Id  ORDER BY i_tiposmovimientos.Nbre ASC, i_salidas.FechaSalida ASC ";
                    mCargarDatosTabla1(sql4);
                    mExportar1(sql4);
                    return;
                }
                return;
            }
        }
        if (this.xname.equals("jifconsultarinformesi1")) {
            String sql5 = "SELECT i_tiposmovimientos.Nbre, COUNT(DISTINCT i_salidas.Id) AS NFormula , COUNT(i_detallesalida.IdSalida) AS NDespacho, SUM((CantidadDespachada*ValorUnitario)) AS Valor, i_tiposmovimientos.CPuc_Debito, i_tiposmovimientos.CPuc_Credito  FROM  baseserver.i_detallesalida INNER JOIN baseserver.i_salidas  ON (i_detallesalida.IdSalida = i_salidas.Id) INNER JOIN baseserver.i_tiposmovimientos  ON (i_salidas.IdTipoMovimiento = i_tiposmovimientos.Id) WHERE ( i_salidas.Id_Periodo ='" + this.xidperiodo[this.JCBPeriodo.getSelectedIndex()] + "' AND i_salidas.IdBodega ='" + this.xidbodega[this.JCBBodega.getSelectedIndex()] + "' AND i_salidas.Estado =0 AND i_tiposmovimientos.Despacho =1) GROUP BY i_tiposmovimientos.Nbre ";
            mCargarDatosTabla2(sql5);
            mExportar2(sql5);
        } else if (this.xname.equals("jifconsultarinformesi2")) {
            String sql6 = "SELECT i_tiposmovimientos.Nbre, COUNT(i_salidas.Id), i_tiposmovimientos.CPuc_Debito, i_tiposmovimientos.CPuc_Credito   FROM baseserver.i_salidas INNER JOIN baseserver.i_tiposmovimientos  ON (i_salidas.IdTipoMovimiento = i_tiposmovimientos.Id) INNER JOIN baseserver.i_faltantes  ON (i_faltantes.IdSalida = i_salidas.Id) WHERE (i_salidas.Id_Periodo ='" + this.xidperiodo[this.JCBPeriodo.getSelectedIndex()] + "' AND i_salidas.Estado =0 and i_faltantes.Estado=0 AND i_salidas.IdBodega ='" + this.xidbodega[this.JCBBodega.getSelectedIndex()] + "') GROUP BY i_tiposmovimientos.Nbre  ORDER BY i_tiposmovimientos.Nbre ASC ";
            mCargarDatosTabla(sql6);
            mExportar(sql6);
        }
    }

    private void mExportar(String xsql) {
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            try {
                WritableWorkbook workbook = Workbook.createWorkbook(new File("c:\\plantilla.xls"));
                WritableSheet sheet = workbook.createSheet("plantilla", 0);
                sheet.addCell(new Label(0, 1, "Tipo Movimiento"));
                sheet.addCell(new Label(1, 1, "Valor"));
                sheet.addCell(new Label(2, 1, "C"));
                sheet.addCell(new Label(3, 1, "D"));
                ConsultasMySQL xt2 = new ConsultasMySQL();
                ResultSet rs = xt2.traerRs(xsql);
                if (rs.next()) {
                    rs.beforeFirst();
                    int x = 2;
                    while (rs.next()) {
                        sheet.addCell(new Label(0, x, rs.getString(1)));
                        sheet.addCell(new Number(1, x, rs.getDouble(2)));
                        sheet.addCell(new Label(2, x, rs.getString(3)));
                        sheet.addCell(new Label(3, x, rs.getString(4)));
                        x++;
                    }
                }
                rs.close();
                xt2.cerrarConexionBd();
                workbook.write();
                workbook.close();
            } catch (IOException ex) {
                Logger.getLogger(JIFConsultasInf.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            } catch (WriteException e) {
                Logger.getLogger(JIFConsultasInf.class.getName()).log(Level.SEVERE, (String) null, e);
            } catch (SQLException ex2) {
                Logger.getLogger(JIFConsultasInf.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex2);
            }
        }
    }

    private void mExportar1(String xsql) {
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            try {
                WritableWorkbook workbook = Workbook.createWorkbook(new File("c:\\plantilla.xls"));
                WritableSheet sheet = workbook.createSheet("plantilla", 0);
                sheet.addCell(new Label(0, 1, "Tipo Movimiento"));
                sheet.addCell(new Label(1, 1, "IdSalida"));
                sheet.addCell(new Label(2, 1, "Fecha"));
                sheet.addCell(new Label(3, 1, "Valor"));
                sheet.addCell(new Label(4, 1, "C"));
                sheet.addCell(new Label(5, 1, "D"));
                ConsultasMySQL xt2 = new ConsultasMySQL();
                ResultSet rs = xt2.traerRs(xsql);
                if (rs.next()) {
                    rs.beforeFirst();
                    int x = 2;
                    while (rs.next()) {
                        sheet.addCell(new Label(0, x, rs.getString(1)));
                        sheet.addCell(new Number(1, x, rs.getLong(2)));
                        sheet.addCell(new Label(2, x, rs.getString(3)));
                        sheet.addCell(new Number(3, x, rs.getDouble(4)));
                        sheet.addCell(new Label(4, x, rs.getString(5)));
                        sheet.addCell(new Label(5, x, rs.getString(6)));
                        x++;
                    }
                }
                rs.close();
                xt2.cerrarConexionBd();
                workbook.write();
                workbook.close();
            } catch (WriteException e) {
                Logger.getLogger(JIFConsultasInf.class.getName()).log(Level.SEVERE, (String) null, e);
            } catch (IOException ex) {
                Logger.getLogger(JIFConsultasInf.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            } catch (SQLException ex2) {
                Logger.getLogger(JIFConsultasInf.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex2);
            }
        }
    }

    private void mExportar2(String xsql) {
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            try {
                WritableWorkbook workbook = Workbook.createWorkbook(new File("c:\\plantilla.xls"));
                WritableSheet sheet = workbook.createSheet("plantilla", 0);
                sheet.addCell(new Label(0, 1, "Tipo Movimiento"));
                sheet.addCell(new Label(1, 1, "Nformula"));
                sheet.addCell(new Label(2, 1, "NItems"));
                sheet.addCell(new Label(3, 1, "Valor"));
                sheet.addCell(new Label(4, 1, "C"));
                sheet.addCell(new Label(5, 1, "D"));
                ConsultasMySQL xt2 = new ConsultasMySQL();
                ResultSet rs = xt2.traerRs(xsql);
                if (rs.next()) {
                    rs.beforeFirst();
                    int x = 2;
                    while (rs.next()) {
                        sheet.addCell(new Label(0, x, rs.getString(1)));
                        sheet.addCell(new Number(1, x, rs.getLong(2)));
                        sheet.addCell(new Number(2, x, rs.getLong(3)));
                        sheet.addCell(new Number(3, x, rs.getDouble(4)));
                        sheet.addCell(new Label(4, x, rs.getString(5)));
                        sheet.addCell(new Label(5, x, rs.getString(6)));
                        x++;
                    }
                }
                rs.close();
                xt2.cerrarConexionBd();
                workbook.write();
                workbook.close();
            } catch (WriteException e) {
                Logger.getLogger(JIFConsultasInf.class.getName()).log(Level.SEVERE, (String) null, e);
            } catch (IOException ex) {
                Logger.getLogger(JIFConsultasInf.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            } catch (SQLException ex2) {
                Logger.getLogger(JIFConsultasInf.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex2);
            }
        }
    }

    public void mNuevo() {
        this.JDFechaI.setDate(this.xmetodos.getFechaActual());
        this.JDFechaF.setDate(this.xmetodos.getFechaActual());
        this.JCBBodega.setSelectedIndex(-1);
        mCrearModeloDatos();
        Principal.txtNo.setText("");
        this.JDFechaI.requestFocus();
    }

    public void mImprimir() {
        if (!Principal.txtNo.getText().isEmpty()) {
            String[][] parametros = new String[3][2];
            parametros[0][0] = "id";
            parametros[0][1] = Principal.txtNo.getText();
            parametros[1][0] = "SUBREPORT_DIR";
            parametros[1][1] = this.xmetodos.getSO() + this.xmetodos.getBarra() + "Reportes" + this.xmetodos.getBarra();
            parametros[2][0] = "SUBREPORTFIRMA_DIR";
            parametros[2][1] = this.xmetodos.getSO() + this.xmetodos.getBarra() + "Firmas" + this.xmetodos.getBarra();
            this.xmetodos.GenerarPDF(this.xmetodos.getRutaRep() + "L_PlanillaRemision", parametros);
            this.xconsulta.cerrarConexionBd();
        }
    }

    public void mGrabar() {
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Tipo Movimiento", "Valor", "C", "D"}) { // from class: Inventarios.JIFConsultasInf.2
            Class[] types = {String.class, Double.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(50);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos1() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Tipo Movimiento", "Id Entrada", "Fecha", "Valor", "C", "D"}) { // from class: Inventarios.JIFConsultasInf.3
            Class[] types = {String.class, Long.class, String.class, Double.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(50);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos2() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Tipo Movimiento", "NFormulas", "NItemsxFormula", "Valor", "D", "C"}) { // from class: Inventarios.JIFConsultasInf.4
            Class[] types = {String.class, Long.class, Long.class, Double.class, String.class, String.class};
            boolean[] canEdit = {true, true, true, true, true, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(50);
    }

    public void mCargarDatosTabla(String xsql) {
        try {
            mCrearModeloDatos();
            this.JTFFTotal1.setVisible(false);
            this.JTFFTotal2.setVisible(false);
            this.JTFFTotal3.setVisible(true);
            ResultSet xrs = this.xconsulta.traerRs(xsql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                double xv3 = 0.0d;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(xrs.getString(1), n, 0);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(2)), n, 1);
                    xv3 += xrs.getDouble(2);
                    this.xmodelo.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelo.setValueAt(xrs.getString(4), n, 3);
                    n++;
                }
                this.JTFFTotal3.setValue(Double.valueOf(xv3));
            }
            xrs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFConsultasInf.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mCargarDatosTabla1(String xsql) {
        try {
            mCrearModeloDatos1();
            ResultSet xrs = this.xconsulta.traerRs(xsql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(xrs.getString(1), n, 0);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(2)), n, 1);
                    this.xmodelo.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(4)), n, 3);
                    this.xmodelo.setValueAt(xrs.getString(5), n, 4);
                    this.xmodelo.setValueAt(xrs.getString(6), n, 5);
                    n++;
                }
            }
            xrs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFConsultasInf.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mCargarDatosTabla2(String xsql) {
        try {
            mCrearModeloDatos2();
            this.JTFFTotal1.setVisible(true);
            this.JTFFTotal2.setVisible(true);
            this.JTFFTotal3.setVisible(true);
            ResultSet xrs = this.xconsulta.traerRs(xsql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                long xv1 = 0;
                long xv2 = 0;
                double xv3 = 0.0d;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(xrs.getString(1), n, 0);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(2)), n, 1);
                    xv1 += xrs.getLong(2);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(3)), n, 2);
                    xv2 += xrs.getLong(3);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(4)), n, 3);
                    xv3 += xrs.getDouble(4);
                    this.xmodelo.setValueAt(xrs.getString(5), n, 4);
                    this.xmodelo.setValueAt(xrs.getString(6), n, 5);
                    n++;
                }
                this.JTFFTotal1.setValue(Long.valueOf(xv1));
                this.JTFFTotal2.setValue(Long.valueOf(xv2));
                this.JTFFTotal3.setValue(Double.valueOf(xv3));
            }
            xrs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFConsultasInf.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }
}
