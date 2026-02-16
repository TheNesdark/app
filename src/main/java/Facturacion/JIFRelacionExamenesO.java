package Facturacion;

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
import java.beans.PropertyVetoException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
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
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

/* JADX INFO: loaded from: GenomaP.jar:Facturacion/JIFRelacionExamenesO.class */
public class JIFRelacionExamenesO extends JInternalFrame {
    private ConsultasMySQL xconsulta = new ConsultasMySQL();
    private Metodos xmt = new Metodos();
    private DefaultTableModel xmodelo;
    private Object[] xdatos;
    private String[] xidbodega;
    private String xsql;
    private ButtonGroup JBGSeleccion;
    private ButtonGroup JBGSeleccion1;
    private JDateChooser JDFechaF;
    private JDateChooser JDFechaI;
    private JPanel JPIDatos;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;
    private JTextField JTFRuta;
    private JButton jButton1;

    public JIFRelacionExamenesO() {
        initComponents();
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v37, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGSeleccion = new ButtonGroup();
        this.JBGSeleccion1 = new ButtonGroup();
        this.JPIDatos = new JPanel();
        this.JDFechaI = new JDateChooser();
        this.JDFechaF = new JDateChooser();
        this.jButton1 = new JButton();
        this.JTFRuta = new JTextField();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("EXÁMENES OCUPACIONALES");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setMaximumSize(null);
        setMinimumSize(null);
        setName("xjifexamenocupacional");
        try {
            setSelected(true);
        } catch (PropertyVetoException e1) {
            e1.printStackTrace();
        }
        addInternalFrameListener(new InternalFrameListener() { // from class: Facturacion.JIFRelacionExamenesO.1
            public void internalFrameOpened(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                JIFRelacionExamenesO.this.formInternalFrameClosing(evt);
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
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JDFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicial", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFechaI.setFont(new Font("Arial", 1, 12));
        this.JDFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Final", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFechaF.setFont(new Font("Arial", 1, 12));
        this.jButton1.setFont(new Font("Arial", 1, 12));
        this.jButton1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.jButton1.setText("Exportar");
        this.jButton1.addActionListener(new ActionListener() { // from class: Facturacion.JIFRelacionExamenesO.2
            public void actionPerformed(ActionEvent evt) {
                JIFRelacionExamenesO.this.jButton1ActionPerformed(evt);
            }
        });
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: Facturacion.JIFRelacionExamenesO.3
            public void mouseClicked(MouseEvent evt) {
                JIFRelacionExamenesO.this.JTFRutaMouseClicked(evt);
            }
        });
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JDFechaI, -2, 120, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JDFechaF, -2, 120, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFRuta, -1, 473, 32767).addGap(33, 33, 33).addComponent(this.jButton1, -1, 164, 32767).addContainerGap()));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JDFechaI, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.JDFechaF, GroupLayout.Alignment.LEADING, -1, -1, 32767)).addComponent(this.jButton1, -2, 51, -2).addComponent(this.JTFRuta, -2, 50, -2)).addGap(16, 16, 16)));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.setSelectionMode(0);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: Facturacion.JIFRelacionExamenesO.4
            public void mouseClicked(MouseEvent evt) {
                JIFRelacionExamenesO.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPIDatos, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addComponent(this.JSPDetalle, GroupLayout.Alignment.TRAILING, -1, 948, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -1, -1, 32767).addGap(18, 18, 18).addComponent(this.JSPDetalle, -2, 334, -2).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosing(InternalFrameEvent evt) {
        Principal.mLimpiarDatosP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jButton1ActionPerformed(ActionEvent evt) {
        mExportar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            mImprimirDocAdiconales();
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

    private void mExportar() {
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            try {
                WritableWorkbook workbook = Workbook.createWorkbook(new File(this.JTFRuta.getText() + ".xls"));
                WritableSheet sheet = workbook.createSheet("Consolidado", 0);
                for (int x = 0; x < this.JTDetalle.getColumnCount(); x++) {
                    sheet.addCell(new Label(x, 0, this.JTDetalle.getColumnName(x)));
                }
                for (int x2 = 0; x2 < this.JTDetalle.getRowCount(); x2++) {
                    sheet.addCell(new Number(0, x2 + 1, Long.valueOf(this.xmodelo.getValueAt(x2, 0).toString()).longValue()));
                    sheet.addCell(new Label(1, x2 + 1, this.xmodelo.getValueAt(x2, 1).toString()));
                    sheet.addCell(new Label(2, x2 + 1, this.xmodelo.getValueAt(x2, 2).toString()));
                    sheet.addCell(new Label(3, x2 + 1, this.xmodelo.getValueAt(x2, 3).toString()));
                    sheet.addCell(new Label(4, x2 + 1, this.xmodelo.getValueAt(x2, 4).toString()));
                    sheet.addCell(new Label(5, x2 + 1, this.xmodelo.getValueAt(x2, 5).toString()));
                    sheet.addCell(new Label(6, x2 + 1, this.xmodelo.getValueAt(x2, 6).toString()));
                }
                workbook.write();
                workbook.close();
            } catch (WriteException e) {
                Logger.getLogger(JIFRelacionExamenesO.class.getName()).log(Level.SEVERE, (String) null, e);
            } catch (IOException ex) {
                Logger.getLogger(JIFRelacionExamenesO.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        }
    }

    public void mBuscar() {
        mCargarDatosTabla();
    }

    private void mExportar(String xsql) {
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            try {
                WritableWorkbook workbook = Workbook.createWorkbook(new File("c:\\plantilla.xls"));
                WritableSheet sheet = workbook.createSheet("plantilla", 0);
                sheet.addCell(new Label(0, 1, "Concepto"));
                sheet.addCell(new Label(1, 1, "Valor"));
                ConsultasMySQL xt2 = new ConsultasMySQL();
                ResultSet rs = xt2.traerRs(xsql);
                if (rs.next()) {
                    rs.beforeFirst();
                    int x = 2;
                    while (rs.next()) {
                        sheet.addCell(new Label(0, x, rs.getString(1)));
                        sheet.addCell(new Number(1, x, rs.getDouble(2)));
                        x++;
                    }
                }
                rs.close();
                xt2.cerrarConexionBd();
                workbook.write();
                workbook.close();
            } catch (WriteException e) {
                Logger.getLogger(JIFRelacionExamenesO.class.getName()).log(Level.SEVERE, (String) null, e);
            } catch (IOException ex) {
                Logger.getLogger(JIFRelacionExamenesO.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            } catch (SQLException ex2) {
                Logger.getLogger(JIFRelacionExamenesO.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex2);
            }
        }
    }

    public void mNuevo() {
        Principal.mLimpiarDatosP();
        this.JDFechaI.setDate(this.xmt.getFechaActual());
        this.JDFechaF.setDate(this.xmt.getFechaActual());
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
        mCrearModeloDatos();
        this.JDFechaI.requestFocus();
    }

    public void mImprimir() {
        if (!Principal.txtNo.getText().isEmpty()) {
            String[][] parametros = new String[3][2];
            parametros[0][0] = "Id";
            parametros[0][1] = Principal.txtNo.getText();
            parametros[1][0] = "SUBREPORT_DIR";
            parametros[1][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
            parametros[2][0] = "SUBREPORTFIRMA_DIR";
            parametros[2][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
            this.xmt.GenerarPDF(this.xmt.getRutaRep() + "h_so_relacion_examenes", parametros);
            this.xconsulta.cerrarConexionBd();
        }
    }

    public void mGrabar() {
        if (Principal.txtNo.getText().isEmpty()) {
            if (this.xmt.mVerificarDatosTablaTrue(this.JTDetalle, 5)) {
                int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (x == 0) {
                    this.xsql = "insert into h_so_relacion (UsuarioS) values ('" + Principal.usuarioSistemaDTO.getLogin() + "')";
                    Principal.txtNo.setText(this.xconsulta.ejecutarSQLId(this.xsql));
                    this.xconsulta.cerrarConexionBd();
                    for (int y = 0; y < this.JTDetalle.getRowCount(); y++) {
                        if (Boolean.valueOf(this.xmodelo.getValueAt(y, 5).toString()).booleanValue()) {
                            this.xsql = "update   h_so_datos_ocupacionales set Id_So_Relacion='" + Principal.txtNo.getText() + "' where Id='" + this.xmodelo.getValueAt(y, 0) + "'";
                            this.xconsulta.ejecutarSQL(this.xsql);
                            this.xconsulta.cerrarConexionBd();
                        }
                    }
                    return;
                }
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "No existen registros seleccionados", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Registros ya grabados", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Fecha", "Tipo Examen", "Usuario", "Empresa", "Cargo", "Incluir?"}) { // from class: Facturacion.JIFRelacionExamenesO.5
            Class[] types = {Long.class, String.class, String.class, String.class, String.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false, false, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(5);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(10);
    }

    private void mCargarDatosTabla() {
        try {
            this.xsql = "SELECT `h_so_datos_ocupacionales`.`Id` , DATE_FORMAT(`h_atencion`.`Fecha_Atencion`, '%d-%m-%Y') AS FechaA , `c_clasecita`.`Nbre` , `persona`.`NUsuario` , cc_terceros.RazonSocialCompleta, `g_cargos`.`Nbre` FROM `h_so_datos_ocupacionales` INNER JOIN `h_atencion`  ON (`h_so_datos_ocupacionales`.`Id_Atencion` = `h_atencion`.`Id`) INNER JOIN `g_cargos`  ON (`h_so_datos_ocupacionales`.`IdCargo` = `g_cargos`.`Id`)  INNER JOIN  `ingreso`   ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`) INNER JOIN  `f_empresacontxconvenio`  ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`) INNER JOIN  `persona`  ON (`ingreso`.`Id_Usuario` = `persona`.`Id_persona`) INNER JOIN  `g_empresacont`  ON (`f_empresacontxconvenio`.`Id_EmpresaCont` = `g_empresacont`.`Id_empresa`) INNER JOIN  cc_terceros  ON (`g_empresacont`.`Id_empresa` = cc_terceros.`Id`) INNER JOIN `c_clasecita`   ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`) WHERE (`h_atencion`.`Fecha_Atencion` >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND `h_atencion`.`Fecha_Atencion` <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' AND `h_so_datos_ocupacionales`.`Estado` =1 and  `h_so_datos_ocupacionales`.`Id_So_Relacion`=0) GROUP BY `h_so_datos_ocupacionales`.`Id` ORDER BY cc_terceros.RazonSocialCompleta ASC, `persona`.`NUsuario` ASC";
            mCrearModeloDatos();
            ResultSet xrs = this.xconsulta.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(1)), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelo.setValueAt(xrs.getString(4), n, 3);
                    this.xmodelo.setValueAt(xrs.getString(5), n, 4);
                    this.xmodelo.setValueAt(xrs.getString(6), n, 5);
                    this.xmodelo.setValueAt(true, n, 6);
                    n++;
                }
            }
            xrs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFRelacionExamenesO.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mCopiarArchivos(File sourceFile, File destFile) throws IOException {
        if (!destFile.exists()) {
            destFile.createNewFile();
        }
        FileChannel source = null;
        FileChannel destination = null;
        try {
            source = new FileInputStream(sourceFile).getChannel();
            destination = new FileOutputStream(destFile).getChannel();
            destination.transferFrom(source, 0L, source.size());
            sourceFile.delete();
            if (source != null) {
                source.close();
            }
            if (destination != null) {
                destination.close();
            }
        } catch (Throwable th) {
            if (source != null) {
                source.close();
            }
            if (destination != null) {
                destination.close();
            }
            throw th;
        }
    }

    private void mImprimirDocAdiconales() {
        try {
            String sql = "SELECT  `h_so_datos_ocupacionales`.`Id`, `h_atencion`.`Id_ClaseCita` FROM  `h_so_datos_ocupacionales` INNER JOIN  `h_atencion`  ON (`h_so_datos_ocupacionales`.`Id_Atencion` = `h_atencion`.`Id`) WHERE (`h_so_datos_ocupacionales`.`Id` ='" + this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0) + "'  AND `h_so_datos_ocupacionales`.`Estado` =1); ";
            ResultSet xrs = this.xconsulta.traerRs(sql);
            if (xrs.next()) {
                xrs.first();
                String[][] mparametros = new String[2][2];
                mparametros[0][0] = "Id";
                mparametros[0][1] = xrs.getString(1);
                mparametros[1][0] = "UsuarioS";
                mparametros[1][1] = Principal.usuarioSistemaDTO.getLogin();
                this.xmt.GenerarPDF(this.xmt.getRutaRep() + "so_Autorizacion_examen", mparametros);
                this.xmt.GenerarPDF(this.xmt.getRutaRep() + "so_FichaClinicaOcupacional", mparametros);
                if (xrs.getInt(2) == 181) {
                    this.xmt.GenerarPDF(this.xmt.getRutaRep() + "so_AptitudMedicaEgreso", mparametros);
                } else {
                    this.xmt.GenerarPDF(this.xmt.getRutaRep() + "so_aptitud_medica", mparametros);
                }
            }
            xrs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(Consolidado.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }
}
