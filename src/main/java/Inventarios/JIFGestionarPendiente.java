package Inventarios;

import Acceso.Principal;
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
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

/* JADX INFO: loaded from: GenomaP.jar:Inventarios/JIFGestionarPendiente.class */
public class JIFGestionarPendiente extends JInternalFrame {
    private Object[] xdatos;
    private String xidusuarios;
    private String[] xidproveedores;
    public static boolean v = true;
    private JButton JBTExportar;
    private JButton JBTOrdenCompra;
    private JButton JBTValorizar;
    private JComboBox JCBProveedor;
    private JDateChooser JDFechaF;
    private JDateChooser JDFechaI;
    private JPanel JPDatosP;
    private JScrollPane JSPTablaR;
    private JTable JTBResultadoP;
    private DefaultTableModel xmodelo = new DefaultTableModel();
    private GregorianCalendar fechaAnterior = new GregorianCalendar();
    private ConsultasMySQL xconsulta = new ConsultasMySQL();
    private Metodos xmetodos = new Metodos();

    public JIFGestionarPendiente() {
        initComponents();
        mNuevo();
        this.xidproveedores = this.xconsulta.llenarCombo("SELECT cc_terceros.Id, cc_terceros.RazonSocialCompleta FROM i_reposiciones INNER JOIN i_proveedores ON (i_reposiciones.Id_Proveedores = i_proveedores.Id_Empresa) INNER JOIN cc_terceros  ON (i_proveedores.Id_Empresa = cc_terceros.Id)  GROUP BY cc_terceros.Id  ORDER BY cc_terceros.RazonSocialCompleta ASC ", this.xidproveedores, this.JCBProveedor);
        this.JCBProveedor.setSelectedIndex(-1);
        mCrearModeloDatos();
        this.xconsulta.cerrarConexionBd();
    }

    /* JADX WARN: Type inference failed for: r3v6, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JSPTablaR = new JScrollPane();
        this.JTBResultadoP = new JTable();
        this.JPDatosP = new JPanel();
        this.JDFechaI = new JDateChooser();
        this.JDFechaF = new JDateChooser();
        this.JCBProveedor = new JComboBox();
        this.JBTValorizar = new JButton();
        this.JBTExportar = new JButton();
        this.JBTOrdenCompra = new JButton();
        setClosable(true);
        setIconifiable(true);
        setTitle("Gestionar Pendiente");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifgestionpendiente");
        this.JSPTablaR.setBorder(BorderFactory.createTitledBorder((Border) null, "RESULTADO", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JTBResultadoP.setFont(new Font("Arial", 1, 12));
        this.JTBResultadoP.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTBResultadoP.setRowHeight(25);
        this.JTBResultadoP.setSelectionBackground(new Color(255, 255, 255));
        this.JTBResultadoP.setSelectionForeground(new Color(255, 0, 0));
        this.JTBResultadoP.setSelectionMode(0);
        this.JTBResultadoP.addKeyListener(new KeyAdapter() { // from class: Inventarios.JIFGestionarPendiente.1
            public void keyPressed(KeyEvent evt) {
                JIFGestionarPendiente.this.JTBResultadoPKeyPressed(evt);
            }
        });
        this.JSPTablaR.setViewportView(this.JTBResultadoP);
        this.JPDatosP.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS CONSULTA", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JDFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicial", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFechaI.setFont(new Font("Arial", 1, 12));
        this.JDFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Final", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFechaF.setFont(new Font("Arial", 1, 12));
        this.JCBProveedor.setFont(new Font("Arial", 1, 12));
        this.JCBProveedor.setBorder(BorderFactory.createTitledBorder((Border) null, "Proveedor", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPDatosPLayout = new GroupLayout(this.JPDatosP);
        this.JPDatosP.setLayout(JPDatosPLayout);
        JPDatosPLayout.setHorizontalGroup(JPDatosPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosPLayout.createSequentialGroup().addContainerGap().addComponent(this.JDFechaI, -2, 120, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JDFechaF, -2, 120, -2).addGap(18, 18, 18).addComponent(this.JCBProveedor, 0, 534, 32767).addContainerGap()));
        JPDatosPLayout.setVerticalGroup(JPDatosPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosPLayout.createSequentialGroup().addGap(19, 19, 19).addGroup(JPDatosPLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JCBProveedor, -2, 48, -2).addGroup(JPDatosPLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JDFechaF, GroupLayout.Alignment.LEADING, -1, 45, 32767).addComponent(this.JDFechaI, GroupLayout.Alignment.LEADING, -2, -1, -2))).addContainerGap(-1, 32767)));
        this.JBTValorizar.setFont(new Font("Arial", 1, 12));
        this.JBTValorizar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/caja.png")));
        this.JBTValorizar.setText("Valorizar");
        this.JBTValorizar.addActionListener(new ActionListener() { // from class: Inventarios.JIFGestionarPendiente.2
            public void actionPerformed(ActionEvent evt) {
                JIFGestionarPendiente.this.JBTValorizarActionPerformed(evt);
            }
        });
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Deshacer.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: Inventarios.JIFGestionarPendiente.3
            public void actionPerformed(ActionEvent evt) {
                JIFGestionarPendiente.this.JBTExportarActionPerformed(evt);
            }
        });
        this.JBTOrdenCompra.setFont(new Font("Arial", 1, 12));
        this.JBTOrdenCompra.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTOrdenCompra.setText("Generar Orden de Compra");
        this.JBTOrdenCompra.addActionListener(new ActionListener() { // from class: Inventarios.JIFGestionarPendiente.4
            public void actionPerformed(ActionEvent evt) {
                JIFGestionarPendiente.this.JBTOrdenCompraActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JSPTablaR, GroupLayout.Alignment.LEADING, -1, 838, 32767).addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup().addComponent(this.JBTValorizar, -2, 280, -2).addGap(18, 18, 18).addComponent(this.JBTExportar, -2, 280, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBTOrdenCompra, -1, 250, 32767)).addComponent(this.JPDatosP, GroupLayout.Alignment.LEADING, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPDatosP, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPTablaR, -2, 340, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBTValorizar, -2, 55, -2).addComponent(this.JBTExportar, -1, -1, 32767).addComponent(this.JBTOrdenCompra, -2, 52, -2)).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTValorizarActionPerformed(ActionEvent evt) {
        if (this.JTBResultadoP.getRowCount() != -1 && this.JCBProveedor.getSelectedIndex() != -1) {
            for (int x = 0; x < this.JTBResultadoP.getRowCount(); x++) {
                try {
                    String sql = "SELECT valor, P FROM i_reposiciones WHERE (Id_Suministro ='" + this.xmodelo.getValueAt(x, 0) + "' AND Id_Proveedores ='" + this.xidproveedores[this.JCBProveedor.getSelectedIndex()] + "')";
                    ResultSet rs = this.xconsulta.traerRs(sql);
                    if (rs.next()) {
                        this.xmodelo.setValueAt(Double.valueOf(rs.getDouble(1)), x, 3);
                        this.xmodelo.setValueAt(Boolean.valueOf(rs.getBoolean(2)), x, 6);
                    }
                    rs.close();
                    this.xconsulta.cerrarConexionBd();
                } catch (SQLException ex) {
                    Logger.getLogger(JIFGestionarPendiente.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                }
            }
        }
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

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTOrdenCompraActionPerformed(ActionEvent evt) {
        if (!Principal.txtNo.getText().isEmpty()) {
            Principal.xClaseInventario.cargarPantalla("jifcompras2");
            dispose();
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Suministro o Dispotivo Médicos", "Cantidad", "Valor", "", "Comprar?", "Asignado"}) { // from class: Inventarios.JIFGestionarPendiente.5
            Class[] types = {Long.class, String.class, Long.class, Double.class, Long.class, Boolean.class, Boolean.class};
            boolean[] canEdit = {false, false, true, true, false, true, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTBResultadoP.setModel(this.xmodelo);
        this.JTBResultadoP.getColumnModel().getColumn(0).setPreferredWidth(20);
        this.JTBResultadoP.getColumnModel().getColumn(1).setPreferredWidth(300);
        this.JTBResultadoP.getColumnModel().getColumn(2).setPreferredWidth(20);
        this.JTBResultadoP.getColumnModel().getColumn(3).setPreferredWidth(20);
        this.JTBResultadoP.getColumnModel().getColumn(4).setPreferredWidth(0);
        this.JTBResultadoP.getColumnModel().getColumn(4).setMinWidth(0);
        this.JTBResultadoP.getColumnModel().getColumn(4).setMaxWidth(0);
        this.JTBResultadoP.getColumnModel().getColumn(5).setPreferredWidth(20);
        this.JTBResultadoP.getColumnModel().getColumn(6).setPreferredWidth(20);
    }

    private void mCargarDatosTabla() {
        try {
            mCrearModeloDatos();
            String xsql = "SELECT i_detallefaltante.IdSuministro,  CONCAT(i_suministro.Nbre,' ', i_presentacioncomercial.Nbre,' ', i_laboratorio.Nbre) AS Nombre, sum(round(Cantidad/CantidadUnidad)) AS Cantidad, i_suministro.CantidadUnidad AS CantUnidad FROM i_detallefaltante INNER JOIN i_faltantes ON (i_detallefaltante.IdFaltante = i_faltantes.Id) INNER JOIN i_suministro  ON (i_detallefaltante.IdSuministro = i_suministro.Id) INNER JOIN i_presentacioncomercial ON (i_suministro.IdPresentacionComercial = i_presentacioncomercial.Id) INNER JOIN i_laboratorio  ON (i_suministro.IdLaboratorio = i_laboratorio.Id) INNER JOIN i_salidas  ON (i_faltantes.IdSalida = i_salidas.Id) WHERE (i_salidas.FechaSalida >='" + this.xmetodos.formatoAMD.format(this.JDFechaI.getDate()) + "'  AND i_salidas.FechaSalida <='" + this.xmetodos.formatoAMD.format(this.JDFechaF.getDate()) + "' AND i_faltantes.Estado =0) GROUP BY i_detallefaltante.IdSuministro  ORDER BY i_suministro.Nbre ASC ";
            ResultSet xrs = this.xconsulta.traerRs(xsql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(1)), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(3)), n, 2);
                    this.xmodelo.setValueAt(0, n, 3);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(4)), n, 4);
                    this.xmodelo.setValueAt(true, n, 5);
                    this.xmodelo.setValueAt(false, n, 6);
                    n++;
                }
            }
            xrs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFGestionarPendiente.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mNuevo() {
        this.JDFechaI.setDate(this.xmetodos.getFechaActual());
        this.JDFechaF.setDate(this.xmetodos.getFechaActual());
        this.JCBProveedor.setSelectedIndex(-1);
        mCrearModeloDatos();
    }

    public void mBuscar() {
        mCargarDatosTabla();
    }

    private void mExportar() {
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            try {
                WritableWorkbook workbook = Workbook.createWorkbook(new File("c:\\plantilla.xls"));
                WritableSheet sheet = workbook.createSheet("plantilla", 0);
                sheet.addCell(new Label(0, 1, "Id"));
                sheet.addCell(new Label(1, 1, "Suministro"));
                sheet.addCell(new Label(2, 1, "Cantidad"));
                sheet.addCell(new Label(3, 1, "Valor"));
                sheet.addCell(new Label(3, 1, "Asigado"));
                int y = 2;
                for (int x = 0; x < this.JTBResultadoP.getRowCount(); x++) {
                    if (this.xmodelo.getValueAt(x, 5).toString().equals("true")) {
                        sheet.addCell(new Number(0, y, Integer.valueOf(this.xmodelo.getValueAt(x, 0).toString()).intValue()));
                        sheet.addCell(new Label(1, y, this.xmodelo.getValueAt(x, 1).toString()));
                        sheet.addCell(new Number(2, y, Integer.valueOf(this.xmodelo.getValueAt(x, 2).toString()).intValue()));
                        sheet.addCell(new Number(3, y, Double.valueOf(this.xmodelo.getValueAt(x, 3).toString()).doubleValue()));
                        sheet.addCell(new Number(4, y, Double.valueOf(this.xmodelo.getValueAt(x, 6).toString()).doubleValue()));
                        y++;
                    }
                }
                workbook.write();
                workbook.close();
            } catch (WriteException e) {
                Logger.getLogger(JIFGestionarPendiente.class.getName()).log(Level.SEVERE, (String) null, e);
            } catch (IOException ex) {
                Logger.getLogger(JIFGestionarPendiente.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        }
    }

    public void mGrabar() {
        if (this.xmetodos.mVerificarDatosTablaTrue(this.JTBResultadoP, 5)) {
            if (this.JCBProveedor.getSelectedIndex() != -1) {
                String sql = "insert into i_msolicitud_pedido (FechaS, Id_Proveedor, Fecha, UsuarioS) Values ('" + this.xmetodos.formatoAMD.format(this.JDFechaI.getDate()) + "','" + this.xidproveedores[this.JCBProveedor.getSelectedIndex()] + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                Principal.txtNo.setText(this.xconsulta.ejecutarSQLId(sql));
                Principal.txtEstado.setText("ACTIVO");
                this.xconsulta.cerrarConexionBd();
                for (int y = 0; y < this.JTBResultadoP.getRowCount(); y++) {
                    if (this.JTBResultadoP.getValueAt(y, 5).toString().equals("true")) {
                        String sql2 = "insert into i_mdetalle_solicitud_pedido(Id_msolicitud, Id_Producto, Cantidad, Valor) values('" + Principal.txtNo.getText() + "','" + this.xmodelo.getValueAt(y, 0).toString() + "','" + this.xmodelo.getValueAt(y, 2).toString() + "','" + this.xmodelo.getValueAt(y, 3).toString() + "')";
                        this.xconsulta.ejecutarSQL(sql2);
                        this.xconsulta.cerrarConexionBd();
                    }
                }
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe sleccionar un empresa", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBProveedor.requestFocus();
        }
    }
}
