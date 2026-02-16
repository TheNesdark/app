package AutorizacionMP;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

/* JADX INFO: loaded from: GenomaP.jar:AutorizacionMP/JIFGenerarRelacionCobro.class */
public class JIFGenerarRelacionCobro extends JInternalFrame {
    private boolean xguardado = false;
    private boolean xtipos = true;
    private ConsultasMySQL xconsultas = new ConsultasMySQL();
    private ButtonGroup JBGSoporte;
    private JButton JBTGenerar;
    public JDateChooser JDCFechaF;
    public JDateChooser JDCFechaI;
    private JPanel JPIDatos;
    private JPanel JPITipoGeneracion;
    private JRadioButton JRBConSoporte;
    private JRadioButton JRBSinSoporte;
    private JFormattedTextField JTFFNRelacion;

    public JIFGenerarRelacionCobro() {
        initComponents();
        Metodos xmt = new Metodos();
        this.JDCFechaI.setDate(xmt.getFechaActual());
        this.JDCFechaF.setDate(xmt.getFechaActual());
    }

    private void initComponents() {
        this.JBGSoporte = new ButtonGroup();
        this.JPIDatos = new JPanel();
        this.JTFFNRelacion = new JFormattedTextField();
        this.JDCFechaI = new JDateChooser();
        this.JDCFechaF = new JDateChooser();
        this.JPITipoGeneracion = new JPanel();
        this.JRBSinSoporte = new JRadioButton();
        this.JRBConSoporte = new JRadioButton();
        this.JBTGenerar = new JButton();
        setClosable(true);
        setIconifiable(true);
        setTitle("GENERAR RELACION DE COBRO");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifgenerarrelacioncobro");
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTFFNRelacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Relación N°", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFNRelacion.setForeground(Color.blue);
        this.JTFFNRelacion.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0"))));
        this.JTFFNRelacion.setHorizontalAlignment(4);
        this.JTFFNRelacion.setFont(new Font("Arial", 1, 18));
        this.JDCFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicial", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDCFechaI.setFont(new Font("Arial", 1, 12));
        this.JDCFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Final", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDCFechaF.setFont(new Font("Arial", 1, 12));
        this.JPITipoGeneracion.setBorder(BorderFactory.createTitledBorder((Border) null, "Soporte?", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBGSoporte.add(this.JRBSinSoporte);
        this.JRBSinSoporte.setFont(new Font("Arial", 1, 12));
        this.JRBSinSoporte.setSelected(true);
        this.JRBSinSoporte.setText("Si");
        this.JRBSinSoporte.addActionListener(new ActionListener() { // from class: AutorizacionMP.JIFGenerarRelacionCobro.1
            public void actionPerformed(ActionEvent evt) {
                JIFGenerarRelacionCobro.this.JRBSinSoporteActionPerformed(evt);
            }
        });
        this.JBGSoporte.add(this.JRBConSoporte);
        this.JRBConSoporte.setFont(new Font("Arial", 1, 12));
        this.JRBConSoporte.setText("No");
        this.JRBConSoporte.addActionListener(new ActionListener() { // from class: AutorizacionMP.JIFGenerarRelacionCobro.2
            public void actionPerformed(ActionEvent evt) {
                JIFGenerarRelacionCobro.this.JRBConSoporteActionPerformed(evt);
            }
        });
        GroupLayout JPITipoGeneracionLayout = new GroupLayout(this.JPITipoGeneracion);
        this.JPITipoGeneracion.setLayout(JPITipoGeneracionLayout);
        JPITipoGeneracionLayout.setHorizontalGroup(JPITipoGeneracionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPITipoGeneracionLayout.createSequentialGroup().addContainerGap().addComponent(this.JRBSinSoporte).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 40, 32767).addComponent(this.JRBConSoporte).addGap(24, 24, 24)));
        JPITipoGeneracionLayout.setVerticalGroup(JPITipoGeneracionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPITipoGeneracionLayout.createSequentialGroup().addContainerGap(-1, 32767).addGroup(JPITipoGeneracionLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBSinSoporte).addComponent(this.JRBConSoporte))));
        this.JBTGenerar.setFont(new Font("Arial", 1, 12));
        this.JBTGenerar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTGenerar.setText("Cargar Valores al Acumulado");
        this.JBTGenerar.addActionListener(new ActionListener() { // from class: AutorizacionMP.JIFGenerarRelacionCobro.3
            public void actionPerformed(ActionEvent evt) {
                JIFGenerarRelacionCobro.this.JBTGenerarActionPerformed(evt);
            }
        });
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JDCFechaI, -2, 136, -2).addGap(18, 18, 18).addComponent(this.JDCFechaF, -2, 136, -2).addGap(18, 18, 18).addComponent(this.JPITipoGeneracion, -2, -1, -2).addGap(18, 18, 18).addComponent(this.JTFFNRelacion, -1, 152, 32767)).addComponent(this.JBTGenerar, -1, 642, 32767)).addGap(19, 19, 19)));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JDCFechaI, -2, 65, -2).addComponent(this.JDCFechaF, -2, 65, -2)).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JTFFNRelacion, -2, 63, -2).addComponent(this.JPITipoGeneracion, -2, -1, -2))).addGap(18, 18, 18).addComponent(this.JBTGenerar, -2, 43, -2).addContainerGap(20, 32767)));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -1, -1, 32767).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addContainerGap(30, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBSinSoporteActionPerformed(ActionEvent evt) {
        this.xtipos = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBConSoporteActionPerformed(ActionEvent evt) {
        this.xtipos = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTGenerarActionPerformed(ActionEvent evt) {
        if (!this.JTFFNRelacion.getText().isEmpty()) {
            String sql = "SELECT d_descuento.Id_PersonaDescuento, SUM(d_descuento.Valor) FROM d_relacion INNER JOIN baseserver.d_descuento  ON (d_relacion.Id = d_descuento.Id_RelacionC) WHERE (d_descuento.Id_RelacionC ='" + this.JTFFNRelacion.getText() + "' AND d_relacion.EsCargadaA =0) GROUP BY d_descuento.Id_PersonaDescuento ORDER BY d_descuento.Id_PersonaDescuento ASC ";
            ResultSet rs = this.xconsultas.traerRs(sql);
            try {
                if (rs.next()) {
                    int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de cargar la relación generada?", "CONFIRMAR", 2, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    if (n == 0) {
                        rs.beforeFirst();
                        ConsultasMySQL xct = new ConsultasMySQL();
                        ConsultasMySQL xct1 = new ConsultasMySQL();
                        while (rs.next()) {
                            ResultSet xrs = xct.traerRs("SELECT Id_Persona FROM d_acomulado_usuario WHERE (Id_Persona ='" + rs.getString(1) + "')");
                            if (xrs.next()) {
                                String sql2 = "update d_acomulado_usuario set Valor=Valor+" + rs.getDouble(2) + " where Id_Persona='" + rs.getString(1) + "'";
                                xct1.ejecutarSQL(sql2);
                                xct1.cerrarConexionBd();
                            } else {
                                String sql3 = "insert into d_acomulado_usuario(Id_Persona,Valor) values('" + rs.getString(1) + "','" + rs.getDouble(2) + "')";
                                xct1.ejecutarSQL(sql3);
                                xct1.cerrarConexionBd();
                            }
                            xrs.close();
                            xct.cerrarConexionBd();
                        }
                        String sql4 = "update d_relacion set EsCargadaA=1 where Id='" + this.JTFFNRelacion.getText() + "'";
                        new ConsultasMySQL().ejecutarSQL(sql4);
                        this.xconsultas.cerrarConexionBd();
                    }
                } else {
                    JOptionPane.showInternalMessageDialog(this, "N° Relación ya cargada", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                }
                rs.close();
                this.xconsultas.cerrarConexionBd();
                return;
            } catch (SQLException ex) {
                Logger.getLogger(JIFGenerarRelacionCobro.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                return;
            }
        }
        JOptionPane.showInternalMessageDialog(this, "Debe existir relacion numerada", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
    }

    public void escribirExcel() {
        try {
            WritableWorkbook workbook = Workbook.createWorkbook(new File("c:\\plantilla.xls"));
            WritableSheet sheet = workbook.createSheet("plantilla", 0);
            String sql = "SELECT persona.NoDocumento, SUM(d_descuento.Valor) AS Total, COUNT(d_descuento.Id) AS NDescuentos, g_tipoempresa.Nbre AS TipoEmpresa FROM baseserver.d_descuento INNER JOIN baseserver.h_atencion  ON (d_descuento.Id_HAtencion = h_atencion.Id) INNER JOIN baseserver.ingreso  ON (h_atencion.Id_Ingreso = ingreso.Id) INNER JOIN baseserver.g_usuario ON (ingreso.Id_Usuario = g_usuario.Id_persona)INNER JOIN baseserver.g_usuario_fpz  ON (g_usuario_fpz.Id_Persona = g_usuario.Id_persona) INNER JOIN baseserver.persona ON (g_usuario_fpz.Id_PersDescuento = persona.Id_persona)INNER JOIN baseserver.g_tipoempresa  ON (g_usuario_fpz.Id_Empresa = g_tipoempresa.Id) WHERE (d_descuento.Id_RelacionC ='" + this.JTFFNRelacion.getText() + "' and d_descuento.Estado =0) GROUP BY persona.NoDocumento ORDER BY TipoEmpresa ASC ";
            sheet.addCell(new Label(0, 0, "N° Documento"));
            sheet.addCell(new Label(1, 0, "Valor Total"));
            sheet.addCell(new Label(2, 0, "N° Descuentos"));
            sheet.addCell(new Label(3, 0, "Tipo Empresa"));
            ConsultasMySQL xt2 = new ConsultasMySQL();
            ResultSet rs = xt2.traerRs(sql);
            try {
                if (rs.next()) {
                    rs.beforeFirst();
                    int x = 1;
                    while (rs.next()) {
                        sheet.addCell(new Number(0, x, rs.getLong(1)));
                        sheet.addCell(new Number(1, x, rs.getLong(2)));
                        sheet.addCell(new Number(2, x, rs.getLong(3)));
                        sheet.addCell(new Label(3, x, rs.getString(4)));
                        x++;
                    }
                }
                rs.close();
                xt2.cerrarConexionBd();
            } catch (SQLException ex) {
                Logger.getLogger(JIFGenerarRelacionCobro.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
            new SimpleDateFormat("yyyy/MM/dd");
            workbook.write();
            workbook.close();
        } catch (WriteException e) {
            Logger.getLogger(JIFGenerarRelacionCobro.class.getName()).log(Level.SEVERE, (String) null, e);
        } catch (IOException ex2) {
            Logger.getLogger(JIFGenerarRelacionCobro.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex2);
        }
    }

    private void mGenerarPlantilla() {
        String sql;
        try {
            Metodos xmt = new Metodos();
            if (this.xtipos) {
                sql = "SELECT d_descuento.Id FROM baseserver.d_descuento INNER JOIN baseserver.h_atencion  ON (d_descuento.Id_HAtencion = h_atencion.Id) INNER JOIN baseserver.ingreso ON (h_atencion.Id_Ingreso = ingreso.Id) INNER JOIN baseserver.persona  ON (ingreso.Id_Usuario = persona.Id_persona) WHERE (ingreso.FechaIngreso >='" + xmt.formatoAMD.format(this.JDCFechaI.getDate()) + "'  AND ingreso.FechaIngreso <='" + xmt.formatoAMD.format(this.JDCFechaF.getDate()) + "' AND d_descuento.Url<>'' AND d_descuento.Estado =0 AND d_descuento.Id_RelacionC=0 and d_descuento.valor<>0) ";
            } else {
                sql = "SELECT d_descuento.Id FROM baseserver.d_descuento INNER JOIN baseserver.h_atencion  ON (d_descuento.Id_HAtencion = h_atencion.Id) INNER JOIN baseserver.ingreso ON (h_atencion.Id_Ingreso = ingreso.Id) INNER JOIN baseserver.persona  ON (ingreso.Id_Usuario = persona.Id_persona) WHERE (ingreso.FechaIngreso >='" + xmt.formatoAMD.format(this.JDCFechaI.getDate()) + "'  AND ingreso.FechaIngreso <='" + xmt.formatoAMD.format(this.JDCFechaF.getDate()) + "' AND d_descuento.Url='' AND d_descuento.Estado =0  AND d_descuento.Id_RelacionC=0 and d_descuento.valor<>0) ";
            }
            ConsultasMySQL xt1 = new ConsultasMySQL();
            ResultSet xrs = xt1.traerRs(sql);
            if (xrs.next()) {
                int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 2, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (n == 0) {
                    xrs.beforeFirst();
                    ConsultasMySQL xt2 = new ConsultasMySQL();
                    String xsql = "Insert into d_relacion (FechaI, FechaF, Estado, Fecha, UsuarioS) values ('" + xmt.formatoAMD.format(this.JDCFechaI.getDate()) + "','" + xmt.formatoAMD.format(this.JDCFechaF.getDate()) + "','0','" + xmt.formatoAMDH24.format(xmt.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                    String id = xt2.ejecutarSQLId(xsql);
                    while (xrs.next()) {
                        String sql1 = "update d_descuento set Id_RelacionC='" + id + "' where id='" + xrs.getString(1) + "'";
                        xt2.ejecutarSQL(sql1);
                    }
                    xt2.cerrarConexionBd();
                    this.JTFFNRelacion.setText(id);
                }
            } else {
                JOptionPane.showInternalMessageDialog(this, "No existe información para este rango de fecha", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            }
            xrs.close();
            xt1.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFGenerarRelacionCobro.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void grabar() {
        mGenerarPlantilla();
    }

    public void nuevo() {
        Metodos xmt = new Metodos();
        this.JDCFechaI.setDate(xmt.getFechaActual());
        this.JDCFechaF.setDate(xmt.getFechaActual());
        this.JTFFNRelacion.setText((String) null);
        this.JTFFNRelacion.requestFocus();
    }

    public void mImprimir() {
        if (!this.JTFFNRelacion.getText().isEmpty()) {
            escribirExcel();
        }
    }
}
