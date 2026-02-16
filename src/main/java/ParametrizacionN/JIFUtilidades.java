package ParametrizacionN;

import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JYearChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;
import jxl.Workbook;
import jxl.write.DateTime;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

/* JADX INFO: loaded from: GenomaP.jar:ParametrizacionN/JIFUtilidades.class */
public class JIFUtilidades extends JInternalFrame {
    private File xfile;
    private Metodos xmt = new Metodos();
    private ConsultasMySQL xct = new ConsultasMySQL();
    private JButton JBTBajar;
    private JPanel JPI_Filtro;
    private JPanel JPI_Filtro1;
    private JTabbedPane JTB_Datos;
    private JFormattedTextField JTFNFinal;
    private JFormattedTextField JTFNInicial;
    private JTextField JTFRuta;
    private JYearChooser JYCAno;
    private JPanel jPanel1;

    public JIFUtilidades() {
        initComponents();
    }

    private void initComponents() {
        this.JTB_Datos = new JTabbedPane();
        this.JPI_Filtro = new JPanel();
        this.JTFNInicial = new JFormattedTextField();
        this.JTFNFinal = new JFormattedTextField();
        this.JTFRuta = new JTextField();
        this.JYCAno = new JYearChooser();
        this.JBTBajar = new JButton();
        this.JPI_Filtro1 = new JPanel();
        this.jPanel1 = new JPanel();
        setClosable(true);
        setIconifiable(true);
        setTitle("UTILIDAD");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifutilidades");
        this.JTB_Datos.setForeground(new Color(0, 103, 0));
        this.JTB_Datos.setFont(new Font("Arial", 1, 14));
        this.JTFNInicial.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Inicial", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFNInicial.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0"))));
        this.JTFNInicial.setFont(new Font("Arial", 1, 13));
        this.JTFNFinal.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Final", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFNFinal.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0"))));
        this.JTFNFinal.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setFont(new Font("Tahoma", 1, 12));
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ruta (Directorio)", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFUtilidades.1
            public void mouseClicked(MouseEvent evt) {
                JIFUtilidades.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JYCAno.setBorder(BorderFactory.createTitledBorder((Border) null, "Año", 0, 0, new Font("Arial", 1, 13), Color.blue));
        this.JBTBajar.setFont(new Font("Arial", 1, 12));
        this.JBTBajar.setText("Bajar");
        this.JBTBajar.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFUtilidades.2
            public void actionPerformed(ActionEvent evt) {
                JIFUtilidades.this.JBTBajarActionPerformed(evt);
            }
        });
        GroupLayout JPI_FiltroLayout = new GroupLayout(this.JPI_Filtro);
        this.JPI_Filtro.setLayout(JPI_FiltroLayout);
        JPI_FiltroLayout.setHorizontalGroup(JPI_FiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_FiltroLayout.createSequentialGroup().addContainerGap().addGroup(JPI_FiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_FiltroLayout.createSequentialGroup().addComponent(this.JTFNInicial, -2, 107, -2).addGap(56, 56, 56).addComponent(this.JTFNFinal, -2, 107, -2).addGap(18, 18, 18).addComponent(this.JYCAno, -2, 95, -2)).addComponent(this.JTFRuta, -2, 384, -2).addComponent(this.JBTBajar, -2, 110, -2)).addContainerGap(389, 32767)));
        JPI_FiltroLayout.setVerticalGroup(JPI_FiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_FiltroLayout.createSequentialGroup().addContainerGap().addGroup(JPI_FiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_FiltroLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFNInicial, -2, 64, -2).addComponent(this.JTFNFinal, -2, 64, -2)).addGroup(GroupLayout.Alignment.TRAILING, JPI_FiltroLayout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JYCAno, -2, -1, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFRuta, -2, -1, -2).addGap(18, 18, 18).addComponent(this.JBTBajar, -2, 43, -2).addContainerGap(230, 32767)));
        this.JTB_Datos.addTab("FILTRO", this.JPI_Filtro);
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 763, 32767));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 100, 32767));
        GroupLayout JPI_Filtro1Layout = new GroupLayout(this.JPI_Filtro1);
        this.JPI_Filtro1.setLayout(JPI_Filtro1Layout);
        JPI_Filtro1Layout.setHorizontalGroup(JPI_Filtro1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_Filtro1Layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -1, -1, 32767).addContainerGap()));
        JPI_Filtro1Layout.setVerticalGroup(JPI_Filtro1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_Filtro1Layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, -1, -2).addContainerGap(307, 32767)));
        this.JTB_Datos.addTab("DETALLE", this.JPI_Filtro1);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTB_Datos).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTB_Datos).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JFileChooser xfilec = new JFileChooser("S:\\GestionDocumental\\Laboratorio\\Anterior");
            xfilec.setFileSelectionMode(1);
            int xv = xfilec.showOpenDialog(this);
            if (xv == 0) {
                this.xfile = xfilec.getSelectedFile();
                String xprevio = this.xfile.getAbsolutePath() + this.xmt.getBarra();
                this.JTFRuta.setText(this.xmt.mTraerUrlBD(xprevio));
                this.xfile.list();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTBajarActionPerformed(ActionEvent evt) {
        mExportar();
    }

    private void mRecuperarBlob() throws SQLException, IOException {
        FileOutputStream fos = null;
        ResultSet rs = null;
        try {
            try {
                String sql = "SELECT Soporte, Id FROM t_registroqrs WHERE (Soporte IS NOT NULL AND Id >='" + this.JTFNInicial.getValue() + "' AND Id <='" + this.JTFNFinal.getValue() + "') ORDER BY Id ASC ";
                rs = this.xct.traerRs(sql);
                if (rs.next()) {
                    rs.beforeFirst();
                    while (rs.next()) {
                        String pathname = this.JTFRuta.getText() + rs.getString(2) + ".pdf";
                        System.out.println(pathname);
                        File file = new File(pathname);
                        fos = new FileOutputStream(file);
                        rs.getBytes(1);
                        Blob bin = rs.getBlob(1);
                        InputStream inStream = bin.getBinaryStream();
                        int size = (int) bin.length();
                        byte[] buffer = new byte[size];
                        while (true) {
                            int length = inStream.read(buffer);
                            if (length != -1) {
                                fos.write(buffer, 0, length);
                            }
                        }
                        fos.close();
                        ConsultasMySQL xct1 = new ConsultasMySQL();
                        String xsql = "update t_registroqrs set UrlSoporte='" + pathname + "' where Id='" + rs.getString(2) + "'";
                        xct1.ejecutarSQL(xsql);
                        xct1.cerrarConexionBd();
                    }
                }
                if (fos != null) {
                    fos.close();
                }
                if (rs != null) {
                    rs.close();
                }
                this.xct.cerrarConexionBd();
            } catch (IOException ioe) {
                throw new IOException(ioe.getMessage());
            }
        } catch (Throwable th) {
            if (fos != null) {
                fos.close();
            }
            if (rs != null) {
                rs.close();
            }
            throw th;
        }
    }

    private void mActualizarUrl() {
        File dir = new File(this.JTFRuta.getText());
        String[] ficheros = dir.list();
        if (ficheros == null) {
            System.out.println("No hay ficheros en el directorio especificado");
            return;
        }
        for (int x = 0; x < ficheros.length; x++) {
            System.out.println(this.JTFRuta.getText() + ficheros[x]);
            System.out.println(ficheros[x].substring(0, ficheros[x].length() - 4));
            ConsultasMySQL xct1 = new ConsultasMySQL();
            String xsql = "update h_atencionesmanuales set Url='" + this.JTFRuta.getText() + ficheros[x] + "' where Id='" + ficheros[x].substring(0, ficheros[x].length() - 4) + "'";
            xct1.ejecutarSQL(xsql);
            xct1.cerrarConexionBd();
        }
    }

    private void mEliminar() {
        try {
            ConsultasMySQL xct1 = new ConsultasMySQL();
            ResultSet xrs = this.xct.traerRs("SELECT Id_ExamenFisico, Id_TipoExamenFisico FROM baseserver.a_uno");
            if (xrs.next()) {
                xrs.beforeFirst();
                while (xrs.next()) {
                    String sql = "delete from h_detalleexamenfisico WHERE (Id_ExamenFisico ='" + xrs.getString(1) + "' AND Id_TipoExamenFisico ='" + xrs.getString(2) + "')";
                    xct1.ejecutarSQL(sql);
                    xct1.cerrarConexionBd();
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFUtilidades.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mEliminarSuministroB() {
        try {
            ConsultasMySQL xct1 = new ConsultasMySQL();
            ResultSet xrs = this.xct.traerRs("SELECT i_suministroxlotexbodega.Id FROM baseserver.i_suministroxbodega INNER JOIN baseserver.i_suministro  ON (i_suministroxbodega.IdSuministro = i_suministro.Id) INNER JOIN baseserver.i_presentacioncomercial  ON (i_suministro.IdPresentacionComercial = i_presentacioncomercial.Id) INNER JOIN baseserver.i_laboratorio  ON (i_suministro.IdLaboratorio = i_laboratorio.Id) INNER JOIN baseserver.i_suministroxlotexbodega  ON (i_suministroxlotexbodega.Id = i_suministroxbodega.Id) WHERE (i_suministroxbodega.IdBodega =5 AND i_suministroxlotexbodega.Cantidad =0) ORDER BY i_suministro.Nbre ASC ");
            if (xrs.next()) {
                xrs.beforeFirst();
                while (xrs.next()) {
                    String sql = "delete from i_suministroxlotexbodega WHERE (Id ='" + xrs.getString(1) + "')";
                    xct1.ejecutarSQL(sql);
                    xct1.cerrarConexionBd();
                    String sql2 = "delete from i_suministroxbodega WHERE (Id ='" + xrs.getString(1) + "')";
                    xct1.ejecutarSQL(sql2);
                    xct1.cerrarConexionBd();
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFUtilidades.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mEliminarSuministroBodega() {
        ConsultasMySQL xct1 = new ConsultasMySQL();
        xct1.ejecutarSQL("delete from i_suministroxbodega WHERE (IdBodega =23)");
        xct1.cerrarConexionBd();
    }

    private void mExportar() {
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            try {
                WritableWorkbook workbook = Workbook.createWorkbook(new File(this.JTFRuta.getText() + ".xls"));
                WritableSheet sheet = workbook.createSheet("Detalle", 0);
                sheet.addCell(new Label(0, 0, "Fecha"));
                sheet.addCell(new Label(1, 0, "Hora"));
                sheet.addCell(new Label(2, 0, "Documento"));
                sheet.addCell(new Label(3, 0, "Nombre"));
                sheet.addCell(new Label(4, 0, "MC"));
                sheet.addCell(new Label(5, 0, "DxP"));
                sheet.addCell(new Label(6, 0, "NDxP"));
                sheet.addCell(new Label(7, 0, "TipoDx"));
                sheet.addCell(new Label(8, 0, "DX1"));
                sheet.addCell(new Label(9, 0, "DX2"));
                sheet.addCell(new Label(10, 0, "DX3"));
                sheet.addCell(new Label(11, 0, "Especialidad"));
                sheet.addCell(new Label(12, 0, "Profesional"));
                String xsql = "SELECT `h_atencion`.`Fecha_Atencion`, `h_atencion`.`Hora_Atencion`, `persona_fpz`.`NoDocumento`, `persona_fpz`.`NUsuario` ,`h_atencion`.`Motivo_Atencion`, `h_atencion`.`Codigo_Dxp`, `g_patologia`.`Nbre` AS `NPatologiaP` , `h_tipodiagnostico`.`Nbre` AS `NTipoDx`, `h_atencion`.`Codigo_DxR1`, `h_atencion`.`Codigo_DxR2`, `h_atencion`.`Codigo_DxR3`, `profesional1`.`Especialidad`, `profesional1`.`NProfesional` FROM  `h_atencion` INNER JOIN  `ingreso`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`) INNER JOIN `persona_fpz`  ON (`persona_fpz`.`Id_persona` = `ingreso`.`Id_Usuario`) INNER JOIN  `h_tipodiagnostico`  ON (`h_tipodiagnostico`.`Id` = `h_atencion`.`Id_TipoDx`) INNER JOIN  `g_patologia`  ON (`g_patologia`.`Id` = `h_atencion`.`Codigo_Dxp`) INNER JOIN  `profesional1`  ON (`profesional1`.`IdEspecialidad` = `h_atencion`.`Id_Especialidad`) AND (`profesional1`.`Id_Persona` = `h_atencion`.`Id_Profesional`) WHERE (DATE_FORMAT(`h_atencion`.`Fecha_Atencion`,'%Y') ='" + this.JYCAno.getValue() + "' AND `persona_fpz`.`IdTipoEmpresa` =1 AND `persona_fpz`.`Parentesco` ='TRABAJADOR') ORDER BY `h_atencion`.`Fecha_Atencion` ASC, `h_atencion`.`Hora_Atencion` ASC ";
                ResultSet xrs = this.xct.traerRs(xsql);
                if (xrs.next()) {
                    xrs.beforeFirst();
                    int x = 0;
                    while (xrs.next()) {
                        sheet.addCell(new DateTime(0, x + 1, xrs.getDate(1)));
                        sheet.addCell(new Label(1, x + 1, xrs.getString(2)));
                        sheet.addCell(new Label(2, x + 1, xrs.getString(3)));
                        sheet.addCell(new Label(3, x + 1, xrs.getString(4)));
                        sheet.addCell(new Label(4, x + 1, xrs.getString(5)));
                        sheet.addCell(new Label(5, x + 1, xrs.getString(6)));
                        sheet.addCell(new Label(6, x + 1, xrs.getString(7)));
                        sheet.addCell(new Label(7, x + 1, xrs.getString(8)));
                        sheet.addCell(new Label(8, x + 1, xrs.getString(9)));
                        sheet.addCell(new Label(9, x + 1, xrs.getString(10)));
                        sheet.addCell(new Label(10, x + 1, xrs.getString(11)));
                        sheet.addCell(new Label(11, x + 1, xrs.getString(12)));
                        sheet.addCell(new Label(12, x + 1, xrs.getString(13)));
                        x++;
                    }
                }
                xrs.close();
                this.xct.cerrarConexionBd();
                workbook.write();
                workbook.close();
            } catch (WriteException e) {
                Logger.getLogger(JIFUtilidades.class.getName()).log(Level.SEVERE, (String) null, e);
            } catch (IOException ex) {
                Logger.getLogger(JIFUtilidades.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            } catch (SQLException ex2) {
                Logger.getLogger(JIFUtilidades.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex2);
            }
        }
    }
}
