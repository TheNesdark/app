package Contabilidad;

import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
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
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

/* JADX INFO: loaded from: GenomaP.jar:Contabilidad/JIFGeneracionDisfon_v1.class */
public class JIFGeneracionDisfon_v1 extends JInternalFrame {
    private ConsultasMySQL xct = new ConsultasMySQL();
    private Metodos xmt = new Metodos();
    private ButtonGroup JBTGOpciones;
    private JButton JBTGenerar;
    private JLabel JLBEstado;
    private JPanel JPIDatos;
    private JRadioButton JRBTNo;
    private JRadioButton JRBTSi;
    private JFormattedTextField JTFFNComprobante;
    private JTextField JTFRuta;

    public JIFGeneracionDisfon_v1() {
        initComponents();
        nuevo();
    }

    private void initComponents() {
        this.JBTGOpciones = new ButtonGroup();
        this.JTFFNComprobante = new JFormattedTextField();
        this.JBTGenerar = new JButton();
        this.JTFRuta = new JTextField();
        this.JPIDatos = new JPanel();
        this.JRBTSi = new JRadioButton();
        this.JRBTNo = new JRadioButton();
        this.JLBEstado = new JLabel();
        setClosable(true);
        setIconifiable(true);
        setTitle("GENERACIÓN DE ARCHIVO PLANO");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        this.JTFFNComprobante.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Comprobante", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFNComprobante.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0"))));
        this.JTFFNComprobante.setHorizontalAlignment(4);
        this.JTFFNComprobante.setFont(new Font("Arial", 1, 13));
        this.JTFFNComprobante.addFocusListener(new FocusAdapter() { // from class: Contabilidad.JIFGeneracionDisfon_v1.1
            public void focusLost(FocusEvent evt) {
                JIFGeneracionDisfon_v1.this.JTFFNComprobanteFocusLost(evt);
            }
        });
        this.JTFFNComprobante.addActionListener(new ActionListener() { // from class: Contabilidad.JIFGeneracionDisfon_v1.2
            public void actionPerformed(ActionEvent evt) {
                JIFGeneracionDisfon_v1.this.JTFFNComprobanteActionPerformed(evt);
            }
        });
        this.JTFFNComprobante.addKeyListener(new KeyAdapter() { // from class: Contabilidad.JIFGeneracionDisfon_v1.3
            public void keyPressed(KeyEvent evt) {
                JIFGeneracionDisfon_v1.this.JTFFNComprobanteKeyPressed(evt);
            }
        });
        this.JBTGenerar.setFont(new Font("Arial", 1, 12));
        this.JBTGenerar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTGenerar.setText("Generar");
        this.JBTGenerar.addActionListener(new ActionListener() { // from class: Contabilidad.JIFGeneracionDisfon_v1.4
            public void actionPerformed(ActionEvent evt) {
                JIFGeneracionDisfon_v1.this.JBTGenerarActionPerformed(evt);
            }
        });
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ruta", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: Contabilidad.JIFGeneracionDisfon_v1.5
            public void mouseClicked(MouseEvent evt) {
                JIFGeneracionDisfon_v1.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "Documento Contable?", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBTGOpciones.add(this.JRBTSi);
        this.JRBTSi.setFont(new Font("Arial", 1, 12));
        this.JRBTSi.setSelected(true);
        this.JRBTSi.setText("Si");
        this.JBTGOpciones.add(this.JRBTNo);
        this.JRBTNo.setFont(new Font("Arial", 1, 12));
        this.JRBTNo.setText("No");
        this.JRBTNo.addActionListener(new ActionListener() { // from class: Contabilidad.JIFGeneracionDisfon_v1.6
            public void actionPerformed(ActionEvent evt) {
                JIFGeneracionDisfon_v1.this.JRBTNoActionPerformed(evt);
            }
        });
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addComponent(this.JRBTSi).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 57, 32767).addComponent(this.JRBTNo).addContainerGap()));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBTSi).addComponent(this.JRBTNo)).addContainerGap(3, 32767)));
        this.JLBEstado.setFont(new Font("Arial", 1, 12));
        this.JLBEstado.setForeground(new Color(255, 0, 0));
        this.JLBEstado.setHorizontalAlignment(0);
        this.JLBEstado.setBorder(BorderFactory.createTitledBorder((Border) null, "Estado", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JLBEstado.setFocusable(false);
        this.JLBEstado.setHorizontalTextPosition(0);
        this.JLBEstado.setVerifyInputWhenFocusTarget(false);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JTFRuta, -1, 577, 32767).addComponent(this.JBTGenerar, GroupLayout.Alignment.LEADING, -1, 577, 32767).addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup().addComponent(this.JTFFNComprobante, -2, 123, -2).addGap(27, 27, 27).addComponent(this.JPIDatos, -2, -1, -2).addGap(18, 18, 18).addComponent(this.JLBEstado, -1, -1, 32767))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(22, 22, 22).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JPIDatos, 0, -1, 32767).addComponent(this.JTFFNComprobante, -1, 57, 32767).addComponent(this.JLBEstado, -1, -1, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 33, 32767).addComponent(this.JTFRuta, -2, 57, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBTGenerar, -2, 66, -2).addContainerGap(-1, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTGenerarActionPerformed(ActionEvent evt) {
        if (!this.JTFFNComprobante.getText().isEmpty()) {
            if (!this.JTFRuta.getText().isEmpty()) {
                String sFichero = this.JTFRuta.getText() + ".txt";
                File fichero = new File(sFichero);
                if (fichero.exists()) {
                    int n = JOptionPane.showInternalConfirmDialog(this, "El archivo a crear ya existe; desea eliminarlo?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    if (n == 0 && fichero.delete()) {
                        if (this.JRBTSi.isSelected()) {
                            mCrearArchivo();
                            return;
                        } else {
                            mCrearArchivo1();
                            return;
                        }
                    }
                    return;
                }
                if (this.JRBTSi.isSelected()) {
                    mCrearArchivo();
                    return;
                } else {
                    mCrearArchivo1();
                    return;
                }
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una ruta", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTFRuta.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe el comprobante no puede ser nulo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JTFFNComprobante.requestFocus();
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
    public void JRBTNoActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFNComprobanteActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFNComprobanteFocusLost(FocusEvent evt) {
        validarEstadoDocumento();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFNComprobanteKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10 || evt.getKeyCode() == 9) {
            validarEstadoDocumento();
        }
    }

    public void nuevo() {
        this.JBTGenerar.setEnabled(false);
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion());
    }

    private void mCrearArchivo() {
        String sFichero = this.JTFRuta.getText();
        File fichero = new File(sFichero);
        if (fichero.exists()) {
            return;
        }
        BufferedWriter bw = null;
        try {
            try {
                try {
                    bw = new BufferedWriter(new FileWriter(sFichero));
                    ConsultasMySQL xct1 = new ConsultasMySQL();
                    ResultSet xrs = this.xct.traerRs("SELECT 1 AS cp1,DATE_FORMAT(cc_documentoc.FechaD,'%Y%m%d') AS Fecha,LPAD(0,24,0) AS cp2, IF(g_cuentaxips.Id_TipoCuenta=1,'2','1') AS TipoCuenta  ,LPAD(0,8,0) AS cp3,  g_cuentaxips.NCuenta, RPAD(g_ips.Nbre,40,' ') AS NIPS,IF( (LENGTH(CONCAT(g_ips.Identificacion,g_ips.DigitoVerificacion)))=10, CONCAT('0',g_ips.Identificacion,g_ips.DigitoVerificacion),CONCAT(g_ips.Identificacion,g_ips.DigitoVerificacion)) AS Nit,'002' AS cp5 ,g_municipio.Cod_Sucursal , DATE_FORMAT(cc_documentoc.FechaD,'%Y%m%d') AS Fecha , LEFT(g_cuentaxips.NCuenta,3) AS CodigoM , LEFT(g_ips.Id_TipoIdentificacion,1) AS TipoDoc, LPAD('',48,' ')  AS P5, LPAD('',1,' ')  AS P6, LPAD('',80,' ')  AS P7 FROM cc_documentoc,  g_cuentaxips INNER JOIN g_ips ON (g_cuentaxips.Id_Empresa = g_ips.Id) INNER JOIN cc_bancoxsucursal  ON (g_cuentaxips.Id_SucursalxBanco = cc_bancoxsucursal.Id) INNER JOIN g_municipio  ON (cc_bancoxsucursal.Id_Municipio = g_municipio.Id) WHERE (cc_documentoc.Id ='" + this.JTFFNComprobante.getText() + "') GROUP BY g_ips.Id, cc_documentoc.Id  ");
                    if (xrs.next()) {
                        bw.write(xrs.getString(1) + xrs.getString(2) + xrs.getString(3) + xrs.getString(4) + xrs.getString(5) + xrs.getString(6) + xrs.getString(7) + xrs.getString(8) + xrs.getString(9) + xrs.getString(10) + xrs.getString(11) + xrs.getString(12) + xrs.getString(13) + xrs.getString(14) + xrs.getString(15) + xrs.getString(16));
                        bw.newLine();
                    }
                    xrs.close();
                    this.xct.cerrarConexionBd();
                    String sql = "SELECT 2 AS P,LEFT(cc_detalle_documentoc_debito.TipoIdentificacion,1)AS TipoIdentificacion,  LPAD(IF(LEFT(cc_detalle_documentoc_debito.TipoIdentificacion,1)='C',cc_detalle_documentoc_debito.Nit, CONCAT(cc_detalle_documentoc_debito.Nit,cc_detalle_documentoc_debito.DV)),11,0  ) AS NIdentificacion  ,RPAD(cc_detalle_documentoc_debito.NEmpresa,40,' ') AS NProveedor, 0 AS P1,IF(cc_detalle_documentoc_debito.IdTipoCuenta=1,'2','1') AS TipoCuenta,  RPAD(LEFT(cc_detalle_documentoc_debito.NCuenta,17),17,' ') AS NCuenta, CONCAT(LPAD(ROUND(cc_detalle_documentoc_debito.VDebito),16,0),'00') AS Valor, 'A' AS P2,'000' AS P3, cc_detalle_documentoc_debito.CodigoBanco, cc_detalle_documentoc_debito.CodigoSucursal, 'Factura N' AS Adenda, LPAD('',1,' ')  AS P10, RPAD(cc_detalle_documentoc_debito.NoFactura,70,' ')AS NConceptoC, '0' AS P4,LPAD(cc_detalle_documentoc_debito.Id,10,0) AS NComprobante, IF(cc_detalle_documentoc_debito.Correo='','N','C') AS EnviarC    ,LPAD('',48,' ')  AS P5,'N' AS P6,LPAD('',8,' ')  AS P7, cc_detalle_documentoc_debito.Id_Radicacion FROM cc_detalle_documentoc_debito INNER JOIN cc_detalle_documentoc_credito  ON (cc_detalle_documentoc_debito.Id_Tercero = cc_detalle_documentoc_credito.Id_Tercero)  AND (cc_detalle_documentoc_debito.Id_Radicacion = cc_detalle_documentoc_credito.Id_Radicacion)  AND (cc_detalle_documentoc_debito.Id = cc_detalle_documentoc_credito.Id)  WHERE (cc_detalle_documentoc_debito.Id ='" + this.JTFFNComprobante.getText() + "') ORDER BY cc_detalle_documentoc_debito.NEmpresa ASC  ";
                    System.out.println(sql);
                    ResultSet xrs2 = this.xct.traerRs(sql);
                    if (xrs2.next()) {
                        xrs2.beforeFirst();
                        while (xrs2.next()) {
                            bw.write(xrs2.getString(1) + xrs2.getString(2) + xrs2.getString(3) + xrs2.getString(4) + xrs2.getString(5) + xrs2.getString(6) + xrs2.getString(7) + xrs2.getString(8) + xrs2.getString(9) + xrs2.getString(10) + xrs2.getString(11) + xrs2.getString(12) + xrs2.getString(13) + xrs2.getString(14) + xrs2.getString(15) + xrs2.getString(16) + xrs2.getString(17) + xrs2.getString(18) + xrs2.getString(19) + xrs2.getString(20) + xrs2.getString(21));
                            bw.newLine();
                            if (xrs2.getString(18).equals("C")) {
                                ResultSet rs = xct1.traerRs("SELECT \n3 AS P\n,LPAD('',10,' ') P1\n,RPAD(LEFT(cc_detalle_documentoc_debito.Correo,50),50,' ')   AS Email\n, LPAD('0000',4,' ') AS P2\n,LEFT(CONCAT('Factura N° ',cc_detalle_documentoc_debito.NoFactura ),160)AS NConceptoC \n,LPAD('',25,' ') P3 \nFROM cc_detalle_documentoc_debito \nINNER JOIN cc_detalle_documentoc_credito ON (cc_detalle_documentoc_debito.Id_Tercero = cc_detalle_documentoc_credito.Id_Tercero) \nAND (cc_detalle_documentoc_debito.Id_Radicacion = cc_detalle_documentoc_credito.Id_Radicacion) AND (cc_detalle_documentoc_debito.Id = cc_detalle_documentoc_credito.Id)\nWHERE (cc_detalle_documentoc_debito.Id ='" + this.JTFFNComprobante.getText() + "' AND cc_detalle_documentoc_debito.Id_Radicacion='" + xrs2.getString("Id_Radicacion") + "' AND  cc_detalle_documentoc_debito.Correo<>'')\n\nORDER BY cc_detalle_documentoc_debito.NEmpresa ASC");
                                if (rs.next()) {
                                    rs.first();
                                    bw.write(rs.getString(1) + rs.getString(2) + rs.getString(3) + rs.getString(4) + rs.getString(5) + rs.getString(6));
                                    bw.newLine();
                                }
                                rs.close();
                                xct1.cerrarConexionBd();
                                ResultSet rs1 = xct1.traerRs("SELECT \n3 AS P\n,LPAD('',10,' ') P1\n,RPAD(LEFT(cc_detalle_documentoc_debito.Correo,50),50,' ')   AS Email\n, LPAD('0000',4,' ') AS P2\n, RPAD(mid(CONCAT('Factura N° ',cc_detalle_documentoc_debito.NoFactura), 160, 160),160, ' ')\n-- , LENGTH(RPAD(mid(CONCAT('Factura N° ',cc_detalle_documentoc_debito.NoFactura ), 160, 160),160, ' ')) largo \n-- ,LEFT(CONCAT('Factura N° ',cc_detalle_documentoc_debito.NoFactura, ' ',cc_detalle_documentoc_debito.ConceptoC ),160)AS NConceptoC \n,LPAD('',25,' ') P3 \nFROM cc_detalle_documentoc_debito \nINNER JOIN cc_detalle_documentoc_credito ON (cc_detalle_documentoc_debito.Id_Tercero = cc_detalle_documentoc_credito.Id_Tercero) \nAND (cc_detalle_documentoc_debito.Id_Radicacion = cc_detalle_documentoc_credito.Id_Radicacion) AND (cc_detalle_documentoc_debito.Id = cc_detalle_documentoc_credito.Id)\nWHERE (cc_detalle_documentoc_debito.Id ='" + this.JTFFNComprobante.getText() + "' AND cc_detalle_documentoc_debito.Id_Radicacion='" + xrs2.getString("Id_Radicacion") + "' AND  cc_detalle_documentoc_debito.Correo<>'')\nORDER BY cc_detalle_documentoc_debito.NEmpresa ASC");
                                if (rs1.next()) {
                                    rs1.first();
                                    bw.write(rs1.getString(1) + rs1.getString(2) + rs1.getString(3) + rs1.getString(4) + rs1.getString(5) + rs1.getString(6));
                                    bw.newLine();
                                }
                                rs1.close();
                                xct1.cerrarConexionBd();
                                ResultSet rs2 = xct1.traerRs("SELECT \n3 AS P\n,LPAD('',10,' ') P1\n,RPAD(LEFT(cc_detalle_documentoc_debito.Correo,50),50,' ')   AS Email\n, LPAD('0000',4,' ') AS P2\n, RPAD(mid(CONCAT('Factura N° ',cc_detalle_documentoc_debito.NoFactura), 360, 80),80, ' ')\n-- , LENGTH(RPAD(mid(CONCAT('Factura N° ',cc_detalle_documentoc_debito.NoFactura), 160, 160),160, ' ')) largo \n-- ,LEFT(CONCAT('Factura N° ',cc_detalle_documentoc_debito.NoFactura ),160)AS NConceptoC \n,LPAD('',105,' ') P3 \nFROM cc_detalle_documentoc_debito \nINNER JOIN cc_detalle_documentoc_credito ON (cc_detalle_documentoc_debito.Id_Tercero = cc_detalle_documentoc_credito.Id_Tercero) \nAND (cc_detalle_documentoc_debito.Id_Radicacion = cc_detalle_documentoc_credito.Id_Radicacion) AND (cc_detalle_documentoc_debito.Id = cc_detalle_documentoc_credito.Id)\nWHERE (cc_detalle_documentoc_debito.Id ='" + this.JTFFNComprobante.getText() + "' AND cc_detalle_documentoc_debito.Id_Radicacion='" + xrs2.getString("Id_Radicacion") + "' AND  cc_detalle_documentoc_debito.Correo<>'')\nORDER BY cc_detalle_documentoc_debito.NEmpresa ASC");
                                if (rs2.next()) {
                                    rs2.first();
                                    bw.write(rs2.getString(1) + rs2.getString(2) + rs2.getString(3) + rs2.getString(4) + rs2.getString(5) + rs2.getString(6));
                                    bw.newLine();
                                }
                                rs2.close();
                                xct1.cerrarConexionBd();
                            }
                        }
                    }
                    xrs2.close();
                    this.xct.cerrarConexionBd();
                    try {
                        bw.close();
                    } catch (IOException ex) {
                        Logger.getLogger(JIFGeneracionDisfon_v1.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                    }
                } catch (SQLException ex2) {
                    Logger.getLogger(JIFGeneracionDisfon_v1.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex2);
                    try {
                        bw.close();
                    } catch (IOException ex3) {
                        Logger.getLogger(JIFGeneracionDisfon_v1.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex3);
                    }
                }
            } catch (IOException ex4) {
                Logger.getLogger(JIFGeneracionDisfon_v1.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex4);
                try {
                    bw.close();
                } catch (IOException ex5) {
                    Logger.getLogger(JIFGeneracionDisfon_v1.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex5);
                }
            }
        } catch (Throwable th) {
            try {
                bw.close();
            } catch (IOException ex6) {
                Logger.getLogger(JIFGeneracionDisfon_v1.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex6);
            }
            throw th;
        }
    }

    private void mCrearArchivo1() {
        String sFichero = this.JTFRuta.getText();
        File fichero = new File(sFichero);
        if (fichero.exists()) {
            return;
        }
        BufferedWriter bw = null;
        try {
            try {
                bw = new BufferedWriter(new FileWriter(sFichero));
                ConsultasMySQL xct1 = new ConsultasMySQL();
                String sql = "SELECT 1 AS cp1,DATE_FORMAT(cc_documentoc.FechaD,'%Y%m%d') AS Fecha,LPAD(0,24,0) AS cp2, IF(g_cuentaxips.Id_TipoCuenta=1,'2','1') AS TipoCuenta  ,LPAD(0,8,0) AS cp3,  g_cuentaxips.NCuenta, RPAD(g_ips.Nbre,40,' ') AS NIPS,IF( (LENGTH(CONCAT(g_ips.Identificacion,g_ips.DigitoVerificacion)))=10, CONCAT('0',g_ips.Identificacion,g_ips.DigitoVerificacion),CONCAT(g_ips.Identificacion,g_ips.DigitoVerificacion)) AS Nit,'002' AS cp5 ,g_municipio.Cod_Sucursal , DATE_FORMAT(cc_documentoc.FechaD,'%Y%m%d') AS Fecha , LEFT(g_cuentaxips.NCuenta,3) AS CodigoM , LEFT(g_ips.Id_TipoIdentificacion,1) AS TipoDoc, LPAD('',48,' ')  AS P5, LPAD('',1,' ')  AS P6, LPAD('',80,' ')  AS P7 FROM cc_documentoc,  g_cuentaxips INNER JOIN g_ips ON (g_cuentaxips.Id_Empresa = g_ips.Id) INNER JOIN cc_bancoxsucursal  ON (g_cuentaxips.Id_SucursalxBanco = cc_bancoxsucursal.Id) INNER JOIN g_municipio  ON (cc_bancoxsucursal.Id_Municipio = g_municipio.Id) WHERE (cc_documentoc.Id ='" + this.JTFFNComprobante.getText() + "') GROUP BY g_ips.Id, cc_documentoc.Id  ";
                System.out.println("uno : " + sql);
                ResultSet xrs = this.xct.traerRs(sql);
                if (xrs.next()) {
                    bw.write(xrs.getString(1) + xrs.getString(2) + xrs.getString(3) + xrs.getString(4) + xrs.getString(5) + xrs.getString(6) + xrs.getString(7) + xrs.getString(8) + xrs.getString(9) + xrs.getString(10) + xrs.getString(11) + xrs.getString(12) + xrs.getString(13) + xrs.getString(14) + xrs.getString(15) + xrs.getString(16));
                    bw.newLine();
                }
                xrs.close();
                this.xct.cerrarConexionBd();
                String sql2 = "SELECT \n2 AS P, \nLEFT(cc_terceros.Id_TipoIdentificacion,1) AS TipoIdentificacion, \nLPAD(IF(LEFT(cc_terceros.Id_TipoIdentificacion,1)='C',cc_terceros.No_identificacion, CONCAT(cc_terceros.No_identificacion,cc_terceros.Dig_Verificacion)),11,0  ) AS NIdentificacion , \nRPAD(cc_terceros.RazonSocialCompleta,40,' ') AS NProveedor, \nLPAD(IF(cc_cuentaxempresa.Id_TipoCuenta=1,'2','1'),2,0) AS TipoCuenta, \nRPAD(LEFT(cc_cuentaxempresa.NCuenta,17),17,' ') AS NCuenta, \nCONCAT(LPAD(ROUND(cc_detalle_documentoc.VDebito),16,0),'00') AS Valor, \n'A' AS P2  , \n'000' AS P3, \nRPAD(cc_banco.Codigo,3,0) codigoBanco, \nRPAD(g_municipio.Cod_Sucursal,4,0) codigoSucursal, \n-- LPAD('',9,' ') AS P4, \n-- LPAD('',1,' ') AS P5, \nRPAD(CONCAT(cc_detalle_documentoc.NFactura ),80,' ') AS NConceptoC, \n'0' , \nLPAD(cc_documentoc.Id,10,0) AS NComprobante, \nIF(cc_terceros.Correo='','N','N') AS EnviarC, \nLPAD('',48,' ') AS P6, \n'N' AS P7, \nLPAD('',8,' ') AS P8, \ncc_detalle_documentoc.Id idDetalleDocumento \nFROM cc_detalle_documentoc \nINNER JOIN cc_documentoc  ON (cc_detalle_documentoc.Id_Documentoc = cc_documentoc.Id) \nINNER JOIN cc_terceros  ON (cc_terceros.Id = cc_detalle_documentoc.Id_Tercero) \nINNER JOIN cc_cuentaxempresa ON (cc_cuentaxempresa.Id_Empresa = cc_terceros.Id) \nINNER JOIN cc_bancoxsucursal ON (cc_cuentaxempresa.Id_SucursalxBanco = cc_bancoxsucursal.Id) \nINNER JOIN cc_banco  ON (cc_bancoxsucursal.Id_Banco = cc_banco.Id) \nINNER JOIN g_municipio ON (cc_bancoxsucursal.Id_Municipio = g_municipio.Id)\nWHERE (cc_cuentaxempresa.Estado =1 AND cc_documentoc.Id ='" + this.JTFFNComprobante.getText() + "' AND CONCAT(LPAD(ROUND(cc_detalle_documentoc.VDebito),16,0),'00') <>0) ";
                System.out.println(sql2);
                ResultSet xrs2 = this.xct.traerRs(sql2);
                if (xrs2.next()) {
                    xrs2.beforeFirst();
                    while (xrs2.next()) {
                        bw.write(xrs2.getString(1) + xrs2.getString(2) + xrs2.getString(3) + xrs2.getString(4) + xrs2.getString(5) + xrs2.getString(6) + xrs2.getString(7) + xrs2.getString(8) + xrs2.getString(9) + xrs2.getString(10) + xrs2.getString(11) + xrs2.getString(12) + xrs2.getString(13) + xrs2.getString(14) + xrs2.getString(15) + xrs2.getString(16) + xrs2.getString(17) + xrs2.getString(18));
                        bw.newLine();
                        if (xrs2.getString("EnviarC").equals("C")) {
                            String sql3 = "SELECT \n3 AS P\n,LPAD('',10,' ') P1\n,RPAD(LEFT(cc_terceros.Correo,50),50,' ')   AS Email\n, LPAD('0000',4,' ') AS P2\n,LEFT(CONCAT('Comprobante N° ',cc_documentoc.Id , ' ',cc_detalle_documentoc.Concepto ),160)AS NConceptoC \n,LPAD('',25,' ') P3 \nFROM cc_detalle_documentoc \nINNER JOIN cc_documentoc  ON (cc_detalle_documentoc.Id_Documentoc = cc_documentoc.Id) \nINNER JOIN cc_terceros  ON (cc_terceros.Id = cc_detalle_documentoc.Id_Tercero) \nWHERE (cc_detalle_documentoc.Id ='" + xrs2.getString("idDetalleDocumento") + "'  \n and  cc_terceros.Correo<>''\n)";
                            System.out.println("Detalle : " + sql3);
                            ResultSet rs = xct1.traerRs(sql3);
                            if (rs.next()) {
                                rs.first();
                                bw.write(rs.getString(1) + rs.getString(2) + rs.getString(3) + rs.getString(4) + rs.getString(5) + rs.getString(6));
                                bw.newLine();
                            }
                            rs.close();
                            xct1.cerrarConexionBd();
                            String sql4 = "SELECT \n3 AS P\n,LPAD('',10,' ') P1\n,RPAD(LEFT(cc_terceros.Correo,50),50,' ')   AS Email\n, LPAD('0000',4,' ') AS P2\n, RPAD(mid(CONCAT('Comprobante N° ',cc_documentoc.Id, ' ',cc_detalle_documentoc.Concepto ), 160, 160),160, ' ')\n,LPAD('',25,' ') P3 \nFROM cc_detalle_documentoc \nINNER JOIN cc_documentoc  ON (cc_detalle_documentoc.Id_Documentoc = cc_documentoc.Id) \nINNER JOIN cc_terceros  ON (cc_terceros.Id = cc_detalle_documentoc.Id_Tercero) \nWHERE (cc_detalle_documentoc.Id ='" + xrs2.getString("idDetalleDocumento") + "'  \n and  cc_terceros.Correo<>''\n)";
                            System.out.println("Detalle : " + sql4);
                            ResultSet rs1 = xct1.traerRs(sql4);
                            if (rs1.next()) {
                                rs1.first();
                                bw.write(rs1.getString(1) + rs1.getString(2) + rs1.getString(3) + rs1.getString(4) + rs1.getString(5) + rs1.getString(6));
                                bw.newLine();
                            }
                            rs1.close();
                            xct1.cerrarConexionBd();
                            String sql5 = "SELECT \n3 AS P\n,LPAD('',10,' ') P1\n,RPAD(LEFT(cc_terceros.Correo,50),50,' ')   AS Email\n, LPAD('0000',4,' ') AS P2\n, RPAD(mid(CONCAT('Comprobante N° ',cc_documentoc.Id, ' ',cc_detalle_documentoc.Concepto ), 360, 80),80, ' ')\n,LPAD('',105,' ') P3 \nFROM cc_detalle_documentoc \nINNER JOIN cc_documentoc  ON (cc_detalle_documentoc.Id_Documentoc = cc_documentoc.Id) \nINNER JOIN cc_terceros  ON (cc_terceros.Id = cc_detalle_documentoc.Id_Tercero) \nWHERE (cc_detalle_documentoc.Id ='" + xrs2.getString("idDetalleDocumento") + "'  \n and  cc_terceros.Correo<>''\n)";
                            System.out.println("Detalle : " + sql5);
                            ResultSet rs2 = xct1.traerRs(sql5);
                            if (rs2.next()) {
                                rs2.first();
                                bw.write(rs2.getString(1) + rs2.getString(2) + rs2.getString(3) + rs2.getString(4) + rs2.getString(5) + rs2.getString(6));
                                bw.newLine();
                            }
                            rs2.close();
                            xct1.cerrarConexionBd();
                        }
                    }
                }
                xrs2.close();
                this.xct.cerrarConexionBd();
                try {
                    bw.close();
                } catch (IOException ex) {
                    Logger.getLogger(JIFGeneracionDisfon_v1.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                }
            } catch (IOException ex2) {
                Logger.getLogger(JIFGeneracionDisfon_v1.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex2);
                try {
                    bw.close();
                } catch (IOException ex3) {
                    Logger.getLogger(JIFGeneracionDisfon_v1.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex3);
                }
            } catch (SQLException ex4) {
                Logger.getLogger(JIFGeneracionDisfon_v1.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex4);
                try {
                    bw.close();
                } catch (IOException ex5) {
                    Logger.getLogger(JIFGeneracionDisfon_v1.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex5);
                }
            }
        } catch (Throwable th) {
            try {
                bw.close();
            } catch (IOException ex6) {
                Logger.getLogger(JIFGeneracionDisfon_v1.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex6);
            }
            throw th;
        }
    }

    private void validarEstadoDocumento() {
        try {
            ConsultasMySQL xct1 = new ConsultasMySQL();
            String sql = "SELECT\n    `cc_documentoc`.`Id`\n    , `cc_detalle_firma_documentoc`.`Autorizo`\nFROM\n    `cc_documentoc`\n    INNER JOIN `cc_tipo_documentoc` \n        ON (`cc_documentoc`.`Id_TipoComprobante` = `cc_tipo_documentoc`.`Id`)\n    INNER JOIN `cc_tipo_documento_clasificacion` \n        ON (`cc_tipo_documentoc`.`IdClasificacion` = `cc_tipo_documento_clasificacion`.`Id`)\n    INNER JOIN `cc_detalle_firma_documentoc` \n        ON (`cc_detalle_firma_documentoc`.`Id_OrdenDc` = `cc_documentoc`.`Id`)\nWHERE (`cc_documentoc`.`Id` ='" + this.JTFFNComprobante.getText() + "'\n    AND `cc_detalle_firma_documentoc`.`Autorizo`=0)";
            System.out.println("uno : " + sql);
            ResultSet xrs = xct1.traerRs(sql);
            if (xrs.next()) {
                this.JLBEstado.setText("PENDIENTE POR AUTORIZAR");
                this.JBTGenerar.setEnabled(false);
            } else {
                System.out.println("" + xrs.getRow());
                if (xrs.getRow() >= 1) {
                    this.JLBEstado.setText("AUTORIZADO");
                    this.JBTGenerar.setEnabled(true);
                } else {
                    this.JLBEstado.setText("");
                    this.JBTGenerar.setEnabled(false);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(JIFGeneracionDisfon_v1.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }
}
