package Armado;

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
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;

/* JADX INFO: loaded from: GenomaP.jar:Armado/JIFGeneracionRips_Extranjeros.class */
public class JIFGeneracionRips_Extranjeros extends JInternalFrame {
    private String[][] xidempresa;
    private String[] xid_factura;
    private String xsql;
    private String sql;
    private File xfile;
    private Vector xvector;
    private String xnumerorips;
    private String xcodigo;
    private ButtonGroup JBGMFact;
    private JButton JBTGenerar;
    private JCheckBox JCH_AgrupadoProcedimiento;
    private JCheckBox JCH_Dx;
    private JPanel JPIDatosT;
    private ButtonGroup JRGFiltro;
    private JTextField JTFRuta;
    private JDateChooser txtFechaFin;
    private JDateChooser txtFechaIni;
    private Metodos xmt = new Metodos();
    private ConsultasMySQL xct = new ConsultasMySQL();
    private int xtipo = 0;
    private int xIncluir_Dx = 0;
    private int xAgrupado = 0;
    private boolean xlleno = false;

    public JIFGeneracionRips_Extranjeros() {
        initComponents();
        mTraerDatosRips();
        mNuevo();
    }

    private void initComponents() {
        this.JBGMFact = new ButtonGroup();
        this.JRGFiltro = new ButtonGroup();
        this.JPIDatosT = new JPanel();
        this.txtFechaIni = new JDateChooser();
        this.txtFechaFin = new JDateChooser();
        this.JTFRuta = new JTextField();
        this.JCH_Dx = new JCheckBox();
        this.JCH_AgrupadoProcedimiento = new JCheckBox();
        this.JBTGenerar = new JButton();
        setClosable(true);
        setIconifiable(true);
        setTitle("GENERACIÓN RIPS - EXTRANJEROS");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifgeneracionrips");
        this.JPIDatosT.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 0, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.txtFechaIni.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.txtFechaIni.setDateFormatString("dd/MM/yyyy");
        this.txtFechaIni.setFont(new Font("Arial", 1, 12));
        this.txtFechaFin.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Fin", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.txtFechaFin.setDateFormatString("dd/MM/yyyy");
        this.txtFechaFin.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ruta (Directorio)", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: Armado.JIFGeneracionRips_Extranjeros.1
            public void mouseClicked(MouseEvent evt) {
                JIFGeneracionRips_Extranjeros.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JCH_Dx.setFont(new Font("Arial", 1, 12));
        this.JCH_Dx.setText("Incluir Dx?");
        this.JCH_Dx.addActionListener(new ActionListener() { // from class: Armado.JIFGeneracionRips_Extranjeros.2
            public void actionPerformed(ActionEvent evt) {
                JIFGeneracionRips_Extranjeros.this.JCH_DxActionPerformed(evt);
            }
        });
        this.JCH_AgrupadoProcedimiento.setFont(new Font("Arial", 1, 12));
        this.JCH_AgrupadoProcedimiento.setSelected(true);
        this.JCH_AgrupadoProcedimiento.setText("Agrupado por Procedimiento");
        this.JCH_AgrupadoProcedimiento.addActionListener(new ActionListener() { // from class: Armado.JIFGeneracionRips_Extranjeros.3
            public void actionPerformed(ActionEvent evt) {
                JIFGeneracionRips_Extranjeros.this.JCH_AgrupadoProcedimientoActionPerformed(evt);
            }
        });
        this.JBTGenerar.setFont(new Font("Arial", 1, 12));
        this.JBTGenerar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTGenerar.setText("Generar");
        this.JBTGenerar.addActionListener(new ActionListener() { // from class: Armado.JIFGeneracionRips_Extranjeros.4
            public void actionPerformed(ActionEvent evt) {
                JIFGeneracionRips_Extranjeros.this.JBTGenerarActionPerformed(evt);
            }
        });
        GroupLayout JPIDatosTLayout = new GroupLayout(this.JPIDatosT);
        this.JPIDatosT.setLayout(JPIDatosTLayout);
        JPIDatosTLayout.setHorizontalGroup(JPIDatosTLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosTLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosTLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JTFRuta).addGroup(JPIDatosTLayout.createSequentialGroup().addComponent(this.txtFechaIni, -2, 133, -2).addGap(18, 18, 18).addComponent(this.txtFechaFin, -2, 121, -2).addGap(18, 18, 18).addGroup(JPIDatosTLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCH_Dx).addComponent(this.JCH_AgrupadoProcedimiento))).addComponent(this.JBTGenerar, -1, -1, 32767)).addContainerGap(-1, 32767)));
        JPIDatosTLayout.setVerticalGroup(JPIDatosTLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosTLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosTLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPIDatosTLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.txtFechaIni, GroupLayout.Alignment.LEADING, -1, 50, 32767).addComponent(this.txtFechaFin, GroupLayout.Alignment.LEADING, -1, -1, 32767)).addGroup(JPIDatosTLayout.createSequentialGroup().addComponent(this.JCH_Dx, -2, 25, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCH_AgrupadoProcedimiento))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFRuta, -2, 50, -2).addGap(18, 18, 18).addComponent(this.JBTGenerar, -2, 51, -2).addContainerGap(-1, 32767)));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatosT, -2, -1, -2).addGap(10, 10, 10)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatosT, -2, -1, -2).addGap(10, 10, 10)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTGenerarActionPerformed(ActionEvent evt) {
        mGenerarArchivos();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JFileChooser xfilec = new JFileChooser(this.JTFRuta.getText());
            xfilec.setFileSelectionMode(1);
            int xv = xfilec.showOpenDialog(this);
            if (xv == 0) {
                this.xfile = xfilec.getSelectedFile();
                this.JTFRuta.setText(this.xfile.getAbsolutePath() + this.xmt.getBarra());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_DxActionPerformed(ActionEvent evt) {
        if (this.JCH_Dx.isSelected()) {
            this.xIncluir_Dx = 1;
        } else {
            this.xIncluir_Dx = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_AgrupadoProcedimientoActionPerformed(ActionEvent evt) {
        if (this.JCH_AgrupadoProcedimiento.isSelected()) {
            this.xAgrupado = 0;
        } else {
            this.xAgrupado = 1;
        }
    }

    public void mNuevo() {
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion());
        this.txtFechaIni.setDate(this.xmt.getFechaActual());
        this.txtFechaFin.setDate(this.xmt.getFechaActual());
        this.txtFechaIni.requestFocus();
    }

    private void mTraerDatosRips() {
        try {
            this.sql = "SELECT NoRemisionRips, CodigoOrganismo FROM g_ips";
            ResultSet xrs = this.xct.traerRs(this.sql);
            if (xrs.next()) {
                xrs.first();
                this.xnumerorips = xrs.getString(1);
                this.xcodigo = xrs.getString(2);
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFGeneracionRips_Extranjeros.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mGenerarArchivos() {
        this.xvector = new Vector();
        this.xsql = "";
        int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de generar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (x == 0) {
            mTraerDatosRips();
            mCrearArchivo_AF_Capitado();
            mCrearArchivo_AD_Capitado();
            mCrearArchivo_US_Capitado();
            mCrearArchivo_AC_Capitado();
            mCrearArchivo_AP_Capitado();
            mCrearArchivo_AM_Capitado();
            mCrearArchivo_AT_Capitado();
            mCrearArchivo_AU_Capitado();
            mCrearArchivo_AH_Capitado();
            mCrearArchivo_AN_Capitado();
            mCrearArchivoCT();
            JOptionPane.showInternalMessageDialog(this, "Archivos generados exitosamente!!!!", "CONFIRMACIÓN", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        }
    }

    private void mCrearArchivoCT() {
        System.out.println(this.xvector.size());
        if (this.xvector.size() >= 1) {
            try {
                String sFichero = this.JTFRuta.getText() + this.xmt.getBarra() + "CT" + this.xmt.formatoMesAno1.format(this.txtFechaFin.getDate()) + ".txt";
                this.xmt.mEliminarArchivo(new File(sFichero));
                boolean xdato = false;
                BufferedWriter bw = new BufferedWriter(new FileWriter(sFichero));
                if (this.xvector.size() >= 0) {
                    for (int x = 0; x < this.xvector.size(); x++) {
                        bw.write(this.xvector.get(x).toString());
                        bw.newLine();
                    }
                    xdato = true;
                }
                bw.close();
                if (!xdato) {
                    this.xmt.mEliminarArchivo(new File(sFichero));
                } else {
                    this.sql = "UPDATE g_ips SET NoRemisionRips = NoRemisionRips + 1";
                    this.xct.ejecutarSQL(this.sql);
                    this.xct.cerrarConexionBd();
                }
            } catch (IOException ex) {
                Logger.getLogger(JIFGeneracionRips_Extranjeros.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        }
    }

    private void mCrearArchivo_AF_Capitado() {
        try {
            String sFichero = this.JTFRuta.getText() + this.xmt.getBarra() + "AF" + this.xmt.formatoMesAno1.format(this.txtFechaFin.getDate()) + ".txt";
            this.xmt.mEliminarArchivo(new File(sFichero));
            boolean xdato = false;
            BufferedWriter bw = new BufferedWriter(new FileWriter(sFichero));
            this.sql = "SELECT CONCAT(g_ips.CodigoOrganismo,',', g_ips.Nbre,',',g_ips.Id_TipoIdentificacion,',', g_ips.Identificacion,',', IF(f_factura_evento.Prefijo='',f_factura_evento.No_FacturaEvento ,CONCAT(f_factura_evento.Prefijo,'',f_factura_evento.No_FacturaEvento)),',', \nDATE_FORMAT(f_factura_evento.Fecha_FacturaEvento,'%d/%m/%Y') ,',','" + this.xmt.formatoAMD1.format(this.txtFechaIni.getDate()) + "' ,',','" + this.xmt.formatoAMD1.format(this.txtFechaFin.getDate()) + "',',',g_empresacont.Codigo,',',  \nSUBSTR(f_empresacontxconvenio.Nbre,1,30) ,',',`g_contratos`.`No_Contrato`,',',f_tipoplan.Nbre,',','',',', ROUND(f_liquidacion.CuotaModeradora+f_liquidacion.Copago)  \n ,',','0',',', f_liquidacion.TotalDescuento,',',f_liquidacion.TotalEps) AS Linea  FROM   \nf_factura_evento \nINNER JOIN  f_liquidacion ON (f_factura_evento.Id_Liquidacion = f_liquidacion.Id)  \nINNER JOIN  f_empresacontxconvenio ON (f_liquidacion.IdEmpresaContxConv = f_empresacontxconvenio.Id)  \nINNER JOIN `g_contratos` ON (g_contratos.`Id_EmpresaContConvenio`= f_empresacontxconvenio.Id)  \nINNER JOIN  f_cuentacobro ON (f_factura_evento.No_CuentaCobro = f_cuentacobro.NoCuenta)  \nINNER JOIN  g_empresacont ON (f_empresacontxconvenio.Id_EmpresaCont = g_empresacont.Id_empresa)  \nINNER JOIN  g_ips ON (f_empresacontxconvenio.Id_GIps = g_ips.Id)   \nINNER JOIN  f_tipoplan ON (g_empresacont.Id_TipoPlan = f_tipoplan.Id) \nINNER JOIN `ingreso` ON (ingreso.`Id` = f_liquidacion.Id)\nINNER JOIN  g_persona ON (g_persona.`Id` = ingreso.`Id_Usuario`) \nINNER JOIN `g_municipio` ON (g_municipio.`Id`= g_persona.`Id_MunicipioNac`)  \nINNER JOIN `g_departamento` ON (g_municipio.`Id_Dpto`= g_departamento.`Id`)  \nINNER JOIN `g_pais` ON (g_pais.`Id`= g_departamento.`CodPais`)  \nWHERE (g_pais.`Id`<> 169 AND f_factura_evento.Estado =0  \nAND f_factura_evento.EstaArmada =2 AND f_liquidacion.Estado =0 AND f_cuentacobro.Periodo_Fact >='" + this.xmt.formatoAMD1.format(this.txtFechaIni.getDate()) + "' AND f_cuentacobro.Periodo_Fact <='" + this.xmt.formatoAMD1.format(this.txtFechaFin.getDate()) + "' AND f_cuentacobro.Estado =0  \nAND g_contratos.`Estado`=0) ";
            System.out.println(" Rips AF : " + this.sql);
            int x = 0;
            ResultSet xrs = this.xct.traerRs(this.sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                while (xrs.next()) {
                    bw.write(xrs.getString(1));
                    bw.newLine();
                    x++;
                }
                xdato = true;
            }
            if (xdato) {
                this.xvector.addElement("AF" + this.xmt.formatoMesAno1.format(this.txtFechaFin.getDate()) + "," + x);
            } else {
                this.xmt.mEliminarArchivo(new File(sFichero));
            }
            xrs.close();
            this.xct.cerrarConexionBd();
            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(JIFGeneracionRips_Extranjeros.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        } catch (SQLException ex2) {
            Logger.getLogger(JIFGeneracionRips_Extranjeros.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex2);
        }
    }

    private void mCrearArchivo_AD_Capitado() {
        try {
            String sFichero = this.JTFRuta.getText() + this.xmt.getBarra() + "AD" + this.xmt.formatoMesAno1.format(this.txtFechaFin.getDate()) + ".txt";
            this.xmt.mEliminarArchivo(new File(sFichero));
            BufferedWriter bw = new BufferedWriter(new FileWriter(sFichero));
            this.sql = "SELECT CONCAT(IF(f_factura_evento.Prefijo='',f_factura_evento.No_FacturaEvento ,CONCAT(f_factura_evento.Prefijo,'',f_factura_evento.No_FacturaEvento)),',',g_ips.CodigoOrganismo,',',IF(i_suministro.Pos=0,'13','12'),',', SUM(f_itemordenessum.Cantidad) ,',',f_itemordenessum.ValorUnit ,',',SUM(((f_itemordenessum.ValorUnit*f_itemordenessum.Cantidad)+f_itemordenessum.valorImpuesto)))  AS Linea  \n FROM g_ips,  f_factura_capita \n INNER JOIN f_liquidacion  ON (f_factura_capita.Id_Liquidacion = f_liquidacion.Id) \n INNER JOIN ingreso  ON (ingreso.Id = f_liquidacion.Id_Ingreso)  \n INNER JOIN `g_persona` ON (ingreso.`Id_Usuario`= g_persona.`Id`)  \n INNER JOIN `g_municipio` ON (g_municipio.`Id`= g_persona.`Id_MunicipioNac`)  \n INNER JOIN `g_departamento` ON (g_municipio.`Id_Dpto`= g_departamento.`Id`)  \n INNER JOIN `g_pais` ON (g_pais.`Id`= g_departamento.`CodPais`)  \n INNER JOIN f_ordenes  ON (f_ordenes.Id_Ingreso = ingreso.Id) \n INNER JOIN f_factura_evento  ON (f_factura_evento.No_FacturaEvento = f_factura_capita.No_FacturaEvento) \n INNER JOIN f_cuentacobro   ON (f_cuentacobro.NoCuenta = f_factura_evento.No_CuentaCobro) \n INNER JOIN f_itemordenessum  ON (f_itemordenessum.Id_Ordenes = f_ordenes.Id) \n INNER JOIN i_suministro  ON (f_itemordenessum.Id_Suministro = i_suministro.Id)  \n WHERE (g_pais.`Id`<>169 AND f_cuentacobro.Periodo_Fact >='" + this.xmt.formatoAMD1.format(this.txtFechaIni.getDate()) + "' AND f_cuentacobro.Periodo_Fact <='" + this.xmt.formatoAMD1.format(this.txtFechaFin.getDate()) + "' \n AND f_ordenes.Estado =0 AND f_factura_capita.EstaArmada =2 AND f_itemordenessum.EsCobrable=1 \n AND f_factura_capita.Estado =0)  \n GROUP BY f_factura_evento.No_FacturaEvento,i_suministro.Id, i_suministro.Pos";
            System.out.println("RIPS AD: " + this.sql);
            ResultSet xrs = this.xct.traerRs(this.sql);
            int x = 0;
            boolean xdato = false;
            if (xrs.next()) {
                xrs.beforeFirst();
                while (xrs.next()) {
                    bw.write(xrs.getString(1));
                    bw.newLine();
                    x++;
                }
                xdato = true;
            }
            xrs.close();
            this.xct.cerrarConexionBd();
            this.sql = "SELECT CONCAT(IF(f_factura_evento.Prefijo='',f_factura_evento.No_FacturaEvento ,CONCAT(f_factura_evento.Prefijo,'',f_factura_evento.No_FacturaEvento)),',',g_ips.CodigoOrganismo,',',IF(i_suministro.Pos=0,'13','12'),',', SUM(f_itemordenessum.Cantidad) ,',', f_itemordenessum.ValorUnit  ,',',SUM(((f_itemordenessum.ValorUnit*f_itemordenessum.Cantidad)+f_itemordenessum.valorImpuesto)) )  AS Linea  \n FROM g_ips,  f_factura_evento \n INNER JOIN f_liquidacion  ON (f_factura_evento.Id_Liquidacion = f_liquidacion.Id) \n INNER JOIN ingreso  ON (ingreso.Id = f_liquidacion.Id_Ingreso)  \n INNER JOIN `g_persona` ON (ingreso.`Id_Usuario`= g_persona.`Id`)  \n INNER JOIN `g_municipio` ON (g_municipio.`Id`= g_persona.`Id_MunicipioNac`)  \n INNER JOIN `g_departamento` ON (g_municipio.`Id_Dpto`= g_departamento.`Id`)  \n INNER JOIN `g_pais` ON (g_pais.`Id`= g_departamento.`CodPais`)  \n INNER JOIN f_ordenes  ON (f_ordenes.Id_Ingreso = ingreso.Id)  \n INNER JOIN f_cuentacobro   ON (f_cuentacobro.NoCuenta = f_factura_evento.No_CuentaCobro) \n INNER JOIN f_itemordenessum  ON (f_itemordenessum.Id_Ordenes = f_ordenes.Id) \n INNER JOIN i_suministro  ON (f_itemordenessum.Id_Suministro = i_suministro.Id)  \n WHERE (g_pais.`Id`<> 169 AND f_cuentacobro.Periodo_Fact >='" + this.xmt.formatoAMD1.format(this.txtFechaIni.getDate()) + "' AND f_cuentacobro.Periodo_Fact <='" + this.xmt.formatoAMD1.format(this.txtFechaFin.getDate()) + "'   AND f_ordenes.Estado =0 AND f_factura_evento.EstaArmada =2 AND f_itemordenessum.EsCobrable=1  AND f_factura_evento.Estado =0)  \n GROUP BY f_factura_evento.No_FacturaEvento,i_suministro.Id, i_suministro.Pos";
            ResultSet xrs2 = this.xct.traerRs(this.sql);
            if (xrs2.next()) {
                xrs2.beforeFirst();
                while (xrs2.next()) {
                    bw.write(xrs2.getString(1));
                    bw.newLine();
                    x++;
                }
                xdato = true;
            }
            xrs2.close();
            this.xct.cerrarConexionBd();
            this.sql = "SELECT CONCAT(IF(f_factura_evento.Prefijo='',f_factura_evento.No_FacturaEvento ,CONCAT(f_factura_evento.Prefijo,'',f_factura_evento.No_FacturaEvento)),',',g_ips.CodigoOrganismo,',',g_procedimiento.Id_TipoConceptoAgrup,',',SUM(f_itemordenesproced.Cantidad) ,',', f_itemordenesproced.ValorUnitario ,',', SUM(((f_itemordenesproced.ValorUnitario*f_itemordenesproced.Cantidad)+f_itemordenesproced.valorImpuesto))) AS Linea \n FROM g_ips, f_factura_capita \n INNER JOIN f_liquidacion  ON (f_factura_capita.Id_Liquidacion = f_liquidacion.Id) \n INNER JOIN ingreso ON (ingreso.Id = f_liquidacion.Id_Ingreso) \n INNER JOIN `g_persona` ON (ingreso.`Id_Usuario`= g_persona.`Id`)  \n INNER JOIN `g_municipio` ON (g_municipio.`Id`= g_persona.`Id_MunicipioNac`)  \n INNER JOIN `g_departamento` ON (g_municipio.`Id_Dpto`= g_departamento.`Id`)  \n INNER JOIN `g_pais` ON (g_pais.`Id`= g_departamento.`CodPais`)  \n INNER JOIN f_ordenes  ON (f_ordenes.Id_Ingreso = ingreso.Id) \n INNER JOIN f_itemordenesproced  ON (f_itemordenesproced.Id_Ordenes = f_ordenes.Id) \n INNER JOIN f_factura_evento  ON (f_factura_evento.No_FacturaEvento = f_factura_capita.No_FacturaEvento)  \n INNER JOIN f_cuentacobro  ON (f_cuentacobro.NoCuenta = f_factura_evento.No_CuentaCobro) \n INNER JOIN g_procedimiento  ON (f_itemordenesproced.Id_Procedimiento = g_procedimiento.Id) \n WHERE (g_pais.`Id`<> 169 AND f_cuentacobro.Periodo_Fact >='" + this.xmt.formatoAMD1.format(this.txtFechaIni.getDate()) + "' AND f_cuentacobro.Periodo_Fact <='" + this.xmt.formatoAMD1.format(this.txtFechaFin.getDate()) + "' \n  AND f_ordenes.Estado =0 AND f_factura_capita.EstaArmada =2 \n  AND f_itemordenesproced.EsCobrable=1  AND f_factura_capita.Estado =0) \n GROUP BY f_factura_evento.No_FacturaEvento, g_procedimiento.Id_TipoConceptoAgrup ";
            System.out.println(this.sql);
            ResultSet xrs3 = this.xct.traerRs(this.sql);
            if (xrs3.next()) {
                xrs3.beforeFirst();
                while (xrs3.next()) {
                    bw.write(xrs3.getString(1));
                    bw.newLine();
                    x++;
                }
                xdato = true;
            }
            xrs3.close();
            this.xct.cerrarConexionBd();
            this.sql = "SELECT CONCAT(IF(f_factura_evento.Prefijo='',f_factura_evento.No_FacturaEvento ,CONCAT(f_factura_evento.Prefijo,'',f_factura_evento.No_FacturaEvento)),',',g_ips.CodigoOrganismo,',',g_procedimiento.Id_TipoConceptoAgrup,',',SUM(f_itemordenesproced.Cantidad) ,',', f_itemordenesproced.ValorUnitario ,',',SUM(((f_itemordenesproced.ValorUnitario*f_itemordenesproced.Cantidad)+f_itemordenesproced.valorImpuesto))) AS Linea \n FROM g_ips, f_factura_evento \n INNER JOIN f_liquidacion  ON (f_factura_evento.Id_Liquidacion = f_liquidacion.Id) \n INNER JOIN ingreso   ON (ingreso.Id = f_liquidacion.Id_Ingreso) \n INNER JOIN `g_persona` ON (ingreso.`Id_Usuario`= g_persona.`Id`)  \n INNER JOIN `g_municipio` ON (g_municipio.`Id`= g_persona.`Id_MunicipioNac`)  \n INNER JOIN `g_departamento` ON (g_municipio.`Id_Dpto`= g_departamento.`Id`)  \n INNER JOIN `g_pais` ON (g_pais.`Id`= g_departamento.`CodPais`)  \n INNER JOIN f_ordenes  ON (f_ordenes.Id_Ingreso = ingreso.Id) \n INNER JOIN f_itemordenesproced  ON (f_itemordenesproced.Id_Ordenes = f_ordenes.Id) \n  INNER JOIN f_cuentacobro  ON (f_cuentacobro.NoCuenta = f_factura_evento.No_CuentaCobro) \n INNER JOIN g_procedimiento  ON (f_itemordenesproced.Id_Procedimiento = g_procedimiento.Id) \n WHERE (g_pais.`Id`<> 169 AND f_cuentacobro.Periodo_Fact >='" + this.xmt.formatoAMD.format(this.txtFechaIni.getDate()) + "' \n AND f_cuentacobro.Periodo_Fact <='" + this.xmt.formatoAMD.format(this.txtFechaFin.getDate()) + "'\n  AND f_itemordenesproced.EsCobrable=1  \n  AND f_ordenes.Estado =0 AND f_factura_evento.EstaArmada =2 AND f_factura_evento.Estado =0) \n GROUP BY f_factura_evento.No_FacturaEvento, g_procedimiento.Id_TipoConceptoAgrup ;";
            System.out.println(this.sql);
            ResultSet xrs4 = this.xct.traerRs(this.sql);
            if (xrs4.next()) {
                xrs4.beforeFirst();
                while (xrs4.next()) {
                    bw.write(xrs4.getString(1));
                    bw.newLine();
                    x++;
                }
                xdato = true;
            }
            xrs4.close();
            this.xct.cerrarConexionBd();
            this.sql = "SELECT CONCAT(IF(f_factura_evento.Prefijo='',f_factura_evento.No_FacturaEvento ,CONCAT(f_factura_evento.Prefijo,'',f_factura_evento.No_FacturaEvento)),',',g_ips.CodigoOrganismo,',',g_procedimiento.Id_TipoConceptoAgrup,',',COUNT(f_itemordenesqx.`Id_OrdenQX`) ,',',ROUND(SUM((f_itemordenesqx.`Valor`*1))) ,',', ROUND(SUM((f_itemordenesqx.`Valor`*1)))) AS Linea  \n FROM g_ips, f_factura_capita \n INNER JOIN f_liquidacion  ON (f_factura_capita.Id_Liquidacion = f_liquidacion.Id) \n INNER JOIN ingreso  ON (ingreso.Id = f_liquidacion.Id_Ingreso) \n INNER JOIN `g_persona` ON (ingreso.`Id_Usuario`= g_persona.`Id`)  \n INNER JOIN `g_municipio` ON (g_municipio.`Id`= g_persona.`Id_MunicipioNac`)  \n INNER JOIN `g_departamento` ON (g_municipio.`Id_Dpto`= g_departamento.`Id`)  \n INNER JOIN `g_pais` ON (g_pais.`Id`= g_departamento.`CodPais`)  \n INNER JOIN f_ordenes  ON (f_ordenes.Id_Ingreso = ingreso.Id)  \n INNER JOIN f_ordenesqx  ON (f_ordenes.Id = f_ordenesqx.Id_Orden) \n INNER JOIN f_itemordenesqx  ON (f_itemordenesqx.Id_OrdenQX = f_ordenesqx.Id)  \n INNER JOIN f_factura_evento  ON (f_factura_evento.No_FacturaEvento = f_factura_capita.No_FacturaEvento)  \n INNER JOIN f_cuentacobro  ON (f_cuentacobro.NoCuenta = f_factura_evento.No_CuentaCobro)  \n INNER JOIN g_procedimiento  ON (f_itemordenesqx.Id_Procedimiento = g_procedimiento.Id)  \n WHERE (g_pais.`Id`<> 169 AND f_cuentacobro.Periodo_Fact >='" + this.xmt.formatoAMD.format(this.txtFechaIni.getDate()) + "' \n AND f_cuentacobro.Periodo_Fact <='" + this.xmt.formatoAMD.format(this.txtFechaFin.getDate()) + "'  \n   AND f_ordenesqx.EsCobrable=1 AND f_ordenes.Estado =0 AND f_factura_capita.EstaArmada =2 \n   AND f_factura_capita.Estado =0)  \n GROUP BY f_factura_evento.No_FacturaEvento, g_procedimiento.Id_TipoConceptoAgrup, f_itemordenesqx.`Valor`  ";
            System.out.println("procedmiento qx : " + this.sql);
            ResultSet xrs5 = this.xct.traerRs(this.sql);
            if (xrs5.next()) {
                xrs5.beforeFirst();
                while (xrs5.next()) {
                    bw.write(xrs5.getString(1));
                    bw.newLine();
                    x++;
                }
                xdato = true;
            }
            xrs5.close();
            this.xct.cerrarConexionBd();
            this.sql = "SELECT CONCAT(IF(f_factura_evento.Prefijo='',f_factura_evento.No_FacturaEvento ,CONCAT(f_factura_evento.Prefijo,'',f_factura_evento.No_FacturaEvento)),',',g_ips.CodigoOrganismo,',',g_procedimiento.Id_TipoConceptoAgrup,',',COUNT(f_itemordenesqx.`Id_OrdenQX`) ,',',ROUND(SUM((f_itemordenesqx.`Valor`*1))) ,',', ROUND(SUM((f_itemordenesqx.`Valor`*1)))) AS Linea \n FROM g_ips, f_factura_evento \n INNER JOIN f_liquidacion  ON (f_factura_evento.Id_Liquidacion = f_liquidacion.Id) \n INNER JOIN ingreso   ON (ingreso.Id = f_liquidacion.Id_Ingreso) \n INNER JOIN `g_persona` ON (ingreso.`Id_Usuario`= g_persona.`Id`)  \n INNER JOIN `g_municipio` ON (g_municipio.`Id`= g_persona.`Id_MunicipioNac`)  \n INNER JOIN `g_departamento` ON (g_municipio.`Id_Dpto`= g_departamento.`Id`)  \n INNER JOIN `g_pais` ON (g_pais.`Id`= g_departamento.`CodPais`)  \n INNER JOIN f_ordenes  ON (f_ordenes.Id_Ingreso = ingreso.Id)  \n INNER JOIN f_ordenesqx  ON (f_ordenes.Id = f_ordenesqx.Id_Orden) \n INNER JOIN f_itemordenesqx  ON (f_itemordenesqx.Id_OrdenQX = f_ordenesqx.Id)\n  INNER JOIN f_cuentacobro  ON (f_cuentacobro.NoCuenta = f_factura_evento.No_CuentaCobro) \n INNER JOIN g_procedimiento  ON (f_itemordenesqx.Id_Procedimiento = g_procedimiento.Id) \n WHERE (g_pais.`Id`<> 169 AND f_cuentacobro.Periodo_Fact >='" + this.xmt.formatoAMD.format(this.txtFechaIni.getDate()) + "' \n AND f_cuentacobro.Periodo_Fact <='" + this.xmt.formatoAMD.format(this.txtFechaFin.getDate()) + "' \n AND f_ordenesqx.EsCobrable=1 AND f_ordenes.Estado =0 AND f_factura_evento.EstaArmada =2 AND f_factura_evento.Estado =0) \n GROUP BY f_factura_evento.No_FacturaEvento, g_procedimiento.Id_TipoConceptoAgrup, f_itemordenesqx.`Valor` ";
            System.out.println("procedmiento qx : " + this.sql);
            ResultSet xrs6 = this.xct.traerRs(this.sql);
            if (xrs6.next()) {
                xrs6.beforeFirst();
                while (xrs6.next()) {
                    bw.write(xrs6.getString(1));
                    bw.newLine();
                    x++;
                }
                xdato = true;
            }
            xrs6.close();
            this.xct.cerrarConexionBd();
            this.sql = "SELECT CONCAT(IF(f_factura_evento.Prefijo='',f_factura_evento.No_FacturaEvento ,CONCAT(f_factura_evento.Prefijo,'',f_factura_evento.No_FacturaEvento)),',',g_ips.CodigoOrganismo,',',g_procedimiento.Id_TipoConceptoAgrup,',',1 ,',',ROUND(SUM((f_ordenesqx.`Valor`*1))) ,',', ROUND(SUM((f_ordenesqx.`Valor`*1)))) AS Linea  \n FROM g_ips, f_factura_capita \n INNER JOIN f_liquidacion  ON (f_factura_capita.Id_Liquidacion = f_liquidacion.Id) \n INNER JOIN ingreso    ON (ingreso.Id = f_liquidacion.Id_Ingreso)\n INNER JOIN `g_persona` ON (ingreso.`Id_Usuario`= g_persona.`Id`)  \n INNER JOIN `g_municipio` ON (g_municipio.`Id`= g_persona.`Id_MunicipioNac`)  \n INNER JOIN `g_departamento` ON (g_municipio.`Id_Dpto`= g_departamento.`Id`)  \n INNER JOIN `g_pais` ON (g_pais.`Id`= g_departamento.`CodPais`)  \n  INNER JOIN f_ordenes  ON (f_ordenes.Id_Ingreso = ingreso.Id)  \n  INNER JOIN f_ordenesqx  ON (f_ordenes.Id = f_ordenesqx.Id_Orden)   \n INNER JOIN f_factura_evento  ON (f_factura_evento.No_FacturaEvento = f_factura_capita.No_FacturaEvento)  \n INNER JOIN f_cuentacobro  ON (f_cuentacobro.NoCuenta = f_factura_evento.No_CuentaCobro)  \n INNER JOIN g_procedimiento  ON (f_ordenesqx.Id_Procedimiento = g_procedimiento.Id)  \n WHERE (g_pais.`Id`<> 169 AND f_cuentacobro.Periodo_Fact >='" + this.xmt.formatoAMD.format(this.txtFechaIni.getDate()) + "' \n AND f_cuentacobro.Periodo_Fact <='" + this.xmt.formatoAMD.format(this.txtFechaFin.getDate()) + "'  \n   AND f_ordenesqx.EsCobrable=1 AND f_ordenesqx.`EsConjunto`=1 AND f_ordenes.Estado =0 \n   AND f_factura_capita.EstaArmada =2 AND f_factura_capita.Estado =0)  \n GROUP BY f_factura_evento.No_FacturaEvento, g_procedimiento.Id_TipoConceptoAgrup, f_ordenesqx.Id_Procedimiento  ";
            System.out.println("procedmiento  ad qx paquetes : " + this.sql);
            ResultSet xrs7 = this.xct.traerRs(this.sql);
            if (xrs7.next()) {
                xrs7.beforeFirst();
                while (xrs7.next()) {
                    bw.write(xrs7.getString(1));
                    bw.newLine();
                    x++;
                }
                xdato = true;
            }
            xrs7.close();
            this.xct.cerrarConexionBd();
            this.sql = " SELECT CONCAT(IF(f_factura_evento.Prefijo='',f_factura_evento.No_FacturaEvento ,CONCAT(f_factura_evento.Prefijo,'',f_factura_evento.No_FacturaEvento)),',',g_ips.CodigoOrganismo,',',g_procedimiento.Id_TipoConceptoAgrup,',',1 ,',',ROUND(SUM((f_ordenesqx.`Valor`*1))) ,',', ROUND(SUM((f_ordenesqx.`Valor`*1)))) AS Linea  \n FROM g_ips, f_factura_evento \n INNER JOIN f_liquidacion  ON (f_factura_evento.Id_Liquidacion = f_liquidacion.Id) \n INNER JOIN ingreso     ON (ingreso.Id = f_liquidacion.Id_Ingreso)\n INNER JOIN `g_persona` ON (ingreso.`Id_Usuario`= g_persona.`Id`)  \n INNER JOIN `g_municipio` ON (g_municipio.`Id`= g_persona.`Id_MunicipioNac`)  \n INNER JOIN `g_departamento` ON (g_municipio.`Id_Dpto`= g_departamento.`Id`)  \n INNER JOIN `g_pais` ON (g_pais.`Id`= g_departamento.`CodPais`)  \n  INNER JOIN f_ordenes  ON (f_ordenes.Id_Ingreso = ingreso.Id)  \n  INNER JOIN f_ordenesqx  ON (f_ordenes.Id = f_ordenesqx.Id_Orden)   \n  INNER JOIN f_cuentacobro  ON (f_cuentacobro.NoCuenta = f_factura_evento.No_CuentaCobro)  \n INNER JOIN g_procedimiento  ON (f_ordenesqx.Id_Procedimiento = g_procedimiento.Id)  \n WHERE (g_pais.`Id`<> 169 AND f_cuentacobro.Periodo_Fact >='" + this.xmt.formatoAMD.format(this.txtFechaIni.getDate()) + "' \n AND f_cuentacobro.Periodo_Fact <='" + this.xmt.formatoAMD.format(this.txtFechaFin.getDate()) + "' \n AND f_ordenesqx.`EsConjunto`=1 AND f_ordenesqx.EsCobrable=1 \n AND f_ordenes.Estado =0 AND f_factura_evento.EstaArmada =2 AND f_factura_evento.Estado =0)  \n GROUP BY f_factura_evento.No_FacturaEvento, g_procedimiento.Id_TipoConceptoAgrup,f_ordenesqx.Id_Procedimiento  ;";
            System.out.println("procedmiento  ad qx paquetes : " + this.sql);
            ResultSet xrs8 = this.xct.traerRs(this.sql);
            if (xrs8.next()) {
                xrs8.beforeFirst();
                while (xrs8.next()) {
                    bw.write(xrs8.getString(1));
                    bw.newLine();
                    x++;
                }
                xdato = true;
            }
            xrs8.close();
            this.xct.cerrarConexionBd();
            bw.close();
            if (xdato) {
                this.xvector.addElement("AD" + this.xmt.formatoMesAno1.format(this.txtFechaFin.getDate()) + "," + x);
            } else {
                this.xmt.mEliminarArchivo(new File(sFichero));
            }
        } catch (IOException ex) {
            Logger.getLogger(JIFGeneracionRips_Extranjeros.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        } catch (SQLException ex2) {
            Logger.getLogger(JIFGeneracionRips_Extranjeros.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex2);
        }
    }

    private void mCrearArchivo_US_Capitado() {
        try {
            String sFichero = this.JTFRuta.getText() + this.xmt.getBarra() + "US" + this.xmt.formatoMesAno1.format(this.txtFechaFin.getDate()) + ".txt";
            this.xmt.mEliminarArchivo(new File(sFichero));
            BufferedWriter bw = new BufferedWriter(new FileWriter(sFichero));
            boolean xdato = false;
            this.sql = "SELECT  CONCAT(g_persona.Id_TipoIdentificacion,',', CONCAT(g_pais.`Codigo`, g_persona.NoDocumento),',', g_empresacont.Codigo,',', f_tiporegimen.`Id_Rips`,',', \n g_persona.Apellido1,',', g_persona.Apellido2,',',g_persona.Nombre1,',', g_persona.Nombre2,',',  IF(DATEDIFF(ingreso.`FechaIngreso`, g_persona.`FechaNac`)<30,DATEDIFF(ingreso.`FechaIngreso`, g_persona.`FechaNac`), IF((DATEDIFF(ingreso.`FechaIngreso`, g_persona.`FechaNac`)>=30 AND DATEDIFF(ingreso.`FechaIngreso`, g_persona.`FechaNac`)<=330),ROUND(DATEDIFF(ingreso.`FechaIngreso`, g_persona.`FechaNac`)/30) , ROUND(DATEDIFF(ingreso.`FechaIngreso`, g_persona.`FechaNac`)/360))),',', IF(DATEDIFF(ingreso.`FechaIngreso`, g_persona.`FechaNac`)<30,3, IF((DATEDIFF(ingreso.`FechaIngreso`, g_persona.`FechaNac`)>=30 AND DATEDIFF(ingreso.`FechaIngreso`, g_persona.`FechaNac`)<=330),2 , 1)),',', \n g_persona.Id_Sexo,',', LEFT(g_persona.Id_Municipio,2),',', RIGHT(g_persona.Id_Municipio,3),',', g_barrio.Zona) AS Linea \n FROM  g_usuario \n INNER JOIN g_persona ON (g_usuario.Id_persona = g_persona.Id) \n  INNER JOIN `g_municipio` ON (g_municipio.`Id`= g_persona.`Id_MunicipioNac`)  \n INNER JOIN `g_departamento` ON (g_municipio.`Id_Dpto`= g_departamento.`Id`)  \n INNER JOIN `g_pais` ON (g_pais.`Id`= g_departamento.`CodPais`)  \n INNER JOIN g_barrio  ON (g_persona.Id_Barrio = g_barrio.Id) \n INNER JOIN ingreso ON (ingreso.Id_Usuario = g_usuario.Id_persona)  \n INNER JOIN f_liquidacion ON (f_liquidacion.Id_Ingreso = ingreso.Id) \n INNER JOIN f_empresacontxconvenio  ON (ingreso.Id_EmpresaContxConv = f_empresacontxconvenio.Id) \n INNER JOIN g_empresacont  ON (f_empresacontxconvenio.Id_EmpresaCont = g_empresacont.Id_empresa) \n INNER JOIN `f_tiporegimen`ON (f_tiporegimen.`Id` = f_empresacontxconvenio.`Id_TipoRegimen`)  \n INNER JOIN f_factura_capita   ON (f_factura_capita.Id_Liquidacion = f_liquidacion.Id) \n INNER JOIN f_factura_evento  ON (f_factura_capita.No_FacturaEvento = f_factura_evento.No_FacturaEvento) \n WHERE (g_pais.`Id`<> 169 AND f_factura_evento.Estado =0 \n AND f_factura_evento.EstaArmada =2  AND f_liquidacion.Estado =0 AND ingreso.Estado =0 \n AND f_factura_capita.Fecha_FacturaCapita >='" + this.xmt.formatoAMD.format(this.txtFechaIni.getDate()) + "' \n AND f_factura_capita.Fecha_FacturaCapita <='" + this.xmt.formatoAMD.format(this.txtFechaFin.getDate()) + "' \n  AND f_factura_capita.EstaArmada =2 \n AND f_factura_capita.Estado =0) GROUP BY g_persona.Id_TipoIdentificacion, g_persona.NoDocumento, g_empresacont.Codigo, \n g_persona.Apellido1, g_persona.Apellido2, g_persona.Nombre1, g_persona.Nombre2";
            System.out.println(" Rips Usuario : " + this.sql);
            ResultSet xrs = this.xct.traerRs(this.sql);
            int x = 0;
            if (xrs.next()) {
                xrs.beforeFirst();
                while (xrs.next()) {
                    bw.write(xrs.getString(1));
                    bw.newLine();
                    x++;
                }
                xdato = true;
            }
            xrs.close();
            this.xct.cerrarConexionBd();
            this.sql = "SELECT CONCAT(g_persona.Id_TipoIdentificacion,',', CONCAT(g_pais.`Codigo`, g_persona.NoDocumento),',',g_empresacont.Codigo,',',f_tiporegimen.`Id_Rips`,',', \n g_persona.Apellido1,',', g_persona.Apellido2,',', g_persona.Nombre1,',', g_persona.Nombre2,',',  IF(DATEDIFF(ingreso.`FechaIngreso`, g_persona.`FechaNac`)<30,DATEDIFF(ingreso.`FechaIngreso`, g_persona.`FechaNac`), IF((DATEDIFF(ingreso.`FechaIngreso`, g_persona.`FechaNac`)>=30 AND DATEDIFF(ingreso.`FechaIngreso`, g_persona.`FechaNac`)<=330),ROUND(DATEDIFF(ingreso.`FechaIngreso`, g_persona.`FechaNac`)/30) , ROUND(DATEDIFF(ingreso.`FechaIngreso`, g_persona.`FechaNac`)/360))),',', IF(DATEDIFF(ingreso.`FechaIngreso`, g_persona.`FechaNac`)<30,3, IF((DATEDIFF(ingreso.`FechaIngreso`, g_persona.`FechaNac`)>=30 AND DATEDIFF(ingreso.`FechaIngreso`, g_persona.`FechaNac`)<=330),2 , 1)),',', \n g_persona.Id_Sexo,',', LEFT(g_persona.Id_Municipio,2),',', RIGHT(g_persona.Id_Municipio,3),',', g_barrio.Zona) AS Linea \n FROM  g_usuario \n INNER JOIN g_persona ON (g_usuario.Id_persona = g_persona.Id) \n  INNER JOIN `g_municipio` ON (g_municipio.`Id`= g_persona.`Id_MunicipioNac`)  \n INNER JOIN `g_departamento` ON (g_municipio.`Id_Dpto`= g_departamento.`Id`)  \n INNER JOIN `g_pais` ON (g_pais.`Id`= g_departamento.`CodPais`)  \n INNER JOIN g_barrio   ON (g_persona.Id_Barrio = g_barrio.Id) \n INNER JOIN ingreso ON (ingreso.Id_Usuario = g_usuario.Id_persona) \n INNER JOIN f_liquidacion ON (f_liquidacion.Id_Ingreso = ingreso.Id) \n INNER JOIN f_empresacontxconvenio  ON (ingreso.Id_EmpresaContxConv = f_empresacontxconvenio.Id) \n INNER JOIN f_factura_evento  ON (f_factura_evento.Id_Liquidacion = f_liquidacion.Id) \n INNER JOIN g_empresacont  ON (f_empresacontxconvenio.Id_EmpresaCont = g_empresacont.Id_empresa) \n INNER JOIN `f_tiporegimen`ON (f_tiporegimen.`Id` = f_empresacontxconvenio.`Id_TipoRegimen`)  \n WHERE (g_pais.`Id`<> 169 AND f_factura_evento.Estado =0 \n AND f_factura_evento.EstaArmada =2 AND f_liquidacion.Estado =0  AND ingreso.Estado =0 \n AND f_factura_evento.Fecha_FacturaEvento >='" + this.xmt.formatoAMD.format(this.txtFechaIni.getDate()) + "' \n AND f_factura_evento.Fecha_FacturaEvento <='" + this.xmt.formatoAMD.format(this.txtFechaFin.getDate()) + "' \n) GROUP BY g_persona.Id_TipoIdentificacion, g_persona.NoDocumento, \n g_empresacont.Codigo, g_persona.Apellido1, g_persona.Apellido2, g_persona.Nombre1, g_persona.Nombre2";
            System.out.println(" Rips Usuario : " + this.sql);
            ResultSet xrs2 = this.xct.traerRs(this.sql);
            if (xrs2.next()) {
                xrs2.beforeFirst();
                while (xrs2.next()) {
                    bw.write(xrs2.getString(1));
                    bw.newLine();
                    x++;
                }
                xdato = true;
            }
            xrs2.close();
            this.xct.cerrarConexionBd();
            bw.close();
            if (xdato) {
                this.xvector.addElement("US" + this.xmt.formatoMesAno1.format(this.txtFechaFin.getDate()) + "," + x);
            } else {
                this.xmt.mEliminarArchivo(new File(sFichero));
            }
        } catch (IOException ex) {
            Logger.getLogger(JIFGeneracionRips_Extranjeros.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        } catch (SQLException ex2) {
            Logger.getLogger(JIFGeneracionRips_Extranjeros.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex2);
        }
    }

    private void mCrearArchivo_AC_Capitado() {
        try {
            String sFichero = this.JTFRuta.getText() + this.xmt.getBarra() + "AC" + this.xmt.formatoMesAno1.format(this.txtFechaFin.getDate()) + ".txt";
            this.xmt.mEliminarArchivo(new File(sFichero));
            boolean xdato = false;
            BufferedWriter bw = new BufferedWriter(new FileWriter(sFichero));
            this.sql = "  SELECT  CONCAT(IF(f_factura_evento.Prefijo='',f_factura_evento.No_FacturaEvento ,CONCAT(f_factura_evento.Prefijo,'',f_factura_evento.No_FacturaEvento)),',', g_ips.CodigoOrganismo,',', g_persona.Id_TipoIdentificacion,',',  \n CONCAT(g_pais.`Codigo`, g_persona.NoDocumento),',', DATE_FORMAT(f_factura_capita.Fecha_FacturaCapita,'%d/%m/%Y'),',',  \n ingreso.NoAutorizacion,',',IF(`f_empresacontxconvenio`.`TCodigo`=0, f_tarifaprocedimiento.CodCUPS ,IF(`f_empresacontxconvenio`.`TCodigo`=1,g_procedimiento.`C_Real`,g_procedimiento.`C_Homologado`)),',', `f_tipofinprocedimiento`.`codigo_rips_homologado`,',',  \n LPAD(`g_causaexterna`.`codigo_rips_homologado` ,2,'0'),',',f_itemripsconsulta.Id_DxPrincipal,',', IFNULL(f_itemripsconsulta.DxRelacional1,''),',',  \n IFNULL(f_itemripsconsulta.DxRelacional2,''),',', IFNULL(f_itemripsconsulta.DxRelacional3,''),',', f_itemripsconsulta.Id_TipoDx,',',  \n ((f_itemordenesproced.ValorUnitario*f_itemordenesproced.Cantidad)+f_itemordenesproced.valorImpuesto),',', f_liquidacion.CuotaModeradora,',',  \n (((f_itemordenesproced.ValorUnitario*f_itemordenesproced.Cantidad)+f_itemordenesproced.valorImpuesto)- f_liquidacion.CuotaModeradora)) AS Linea \n FROM   g_usuario \n INNER JOIN g_persona   ON (g_usuario.Id_persona = g_persona.Id) \n  INNER JOIN `g_municipio` ON (g_municipio.`Id`= g_persona.`Id_MunicipioNac`)  \n INNER JOIN `g_departamento` ON (g_municipio.`Id_Dpto`= g_departamento.`Id`)  \n INNER JOIN `g_pais` ON (g_pais.`Id`= g_departamento.`CodPais`)  \n INNER JOIN ingreso ON (ingreso.Id_Usuario = g_usuario.Id_persona)  \n INNER JOIN f_ordenes ON (f_ordenes.Id_Ingreso = ingreso.Id)  \n INNER JOIN f_empresacontxconvenio   ON (ingreso.Id_EmpresaContxConv = f_empresacontxconvenio.Id) \n INNER JOIN f_itemordenesproced   ON (f_itemordenesproced.Id_Ordenes = f_ordenes.Id)   \n  INNER JOIN g_ips ON (f_empresacontxconvenio.Id_GIps = g_ips.Id)   \n  INNER JOIN f_itemripsconsulta ON (f_itemripsconsulta.Id_Ordenes = f_itemordenesproced.Id_Ordenes) AND   (f_itemripsconsulta.Id_Procedimiento = f_itemordenesproced.Id_Procedimiento) \n  INNER JOIN g_procedimiento   ON (f_itemordenesproced.Id_Procedimiento = g_procedimiento.Id) \n  INNER JOIN f_liquidacion   ON (f_liquidacion.Id_Ingreso = ingreso.Id) \n  INNER JOIN f_subgrupo_empresa  ON (f_liquidacion.Id_SubGrupoServicio = f_subgrupo_empresa.Id) \n  INNER JOIN f_subgruposervicio  ON (f_subgrupo_empresa.Id_SubGrupo = f_subgruposervicio.Id_SubgrupoServicio) \n  INNER JOIN f_gruposervicio  ON (f_subgruposervicio.Id_GrupoServicio = f_gruposervicio.Id_GrupoServicio) \n  INNER JOIN f_tarifaprocedimiento   ON (f_empresacontxconvenio.Id_Manual = f_tarifaprocedimiento.Id_Manual) AND    (f_tarifaprocedimiento.Id_Procedimiento = g_procedimiento.Id)\n   INNER JOIN f_factura_capita   ON (f_factura_capita.Id_Liquidacion = f_liquidacion.Id)\n    INNER JOIN f_factura_evento    ON (f_factura_capita.No_FacturaEvento = f_factura_evento.No_FacturaEvento) \n INNER JOIN `g_causaexterna` ON ingreso.`Id_CausaExterna`=`g_causaexterna`.`Id`  INNER JOIN `f_tipofinprocedimiento` ON `f_itemordenesproced`.`Id_TipofinProc`=`f_tipofinprocedimiento`.`Id`     WHERE (g_pais.`Id`<>169 AND f_itemordenesproced.ValorUnitario >0 AND f_itemordenesproced.EsCobrable=1  \n AND g_procedimiento.Id_TipoProcRIPS =5 AND f_factura_evento.Estado =0  AND f_factura_evento.EstaArmada =2 AND ingreso.Estado =0  \n AND f_ordenes.Estado =0  \n AND f_factura_capita.EstaArmada =2 AND f_factura_capita.Estado =0  \n AND f_factura_capita.Fecha_FacturaCapita >='" + this.xmt.formatoAMD.format(this.txtFechaIni.getDate()) + "' AND f_factura_capita.Fecha_FacturaCapita <='" + this.xmt.formatoAMD.format(this.txtFechaFin.getDate()) + "') \n ORDER BY f_factura_evento.No_FacturaEvento ASC, f_subgruposervicio.Nbre ASC, f_factura_capita.Fecha_FacturaCapita ASC,  g_persona.Apellido1 ASC, g_persona.Apellido2 ASC, g_persona.Nombre1 ASC, g_persona.Nombre2 ASC ";
            System.out.println(" Rips Consulta : " + this.sql);
            ResultSet xrs = this.xct.traerRs(this.sql);
            int x = 0;
            if (xrs.next()) {
                xrs.beforeFirst();
                while (xrs.next()) {
                    bw.write(xrs.getString(1));
                    bw.newLine();
                    x++;
                }
                xdato = true;
            }
            xrs.close();
            this.xct.cerrarConexionBd();
            this.sql = " SELECT  CONCAT(IF(f_factura_evento.Prefijo='',f_factura_evento.No_FacturaEvento ,CONCAT(f_factura_evento.Prefijo,'',f_factura_evento.No_FacturaEvento)),',', g_ips.CodigoOrganismo,',', g_persona.Id_TipoIdentificacion,',',  \n CONCAT(g_pais.`Codigo`, g_persona.NoDocumento),',', DATE_FORMAT(f_factura_evento.Fecha_FacturaEvento,'%d/%m/%Y') ,',',  \n ingreso.NoAutorizacion,',', IF(`f_empresacontxconvenio`.`TCodigo`=0, f_tarifaprocedimiento.CodCUPS ,IF(`f_empresacontxconvenio`.`TCodigo`=1,g_procedimiento.`C_Real`,g_procedimiento.`C_Homologado`)),',', `f_tipofinprocedimiento`.`codigo_rips_homologado`,',',  \n LPAD(`g_causaexterna`.`codigo_rips_homologado` ,2,'0'),',', f_itemripsconsulta.Id_DxPrincipal,',', IFNULL(f_itemripsconsulta.DxRelacional1,''),',',  \n IFNULL(f_itemripsconsulta.DxRelacional2,''),',', IFNULL(f_itemripsconsulta.DxRelacional3,''),',', f_itemripsconsulta.Id_TipoDx,',',  \n ((f_itemordenesproced.ValorUnitario*f_itemordenesproced.Cantidad)+f_itemordenesproced.valorImpuesto) ,',', f_liquidacion.CuotaModeradora,',',  \n (((f_itemordenesproced.ValorUnitario*f_itemordenesproced.Cantidad)+f_itemordenesproced.valorImpuesto)- f_liquidacion.CuotaModeradora)) AS Linea  \n FROM  g_usuario \n INNER JOIN g_persona ON   (g_usuario.Id_persona = g_persona.Id) \n  INNER JOIN `g_municipio` ON (g_municipio.`Id`= g_persona.`Id_MunicipioNac`)  \n INNER JOIN `g_departamento` ON (g_municipio.`Id_Dpto`= g_departamento.`Id`)  \n INNER JOIN `g_pais` ON (g_pais.`Id`= g_departamento.`CodPais`)  \n INNER JOIN ingreso   ON (ingreso.Id_Usuario = g_usuario.Id_persona) \n INNER JOIN f_ordenes   ON (f_ordenes.Id_Ingreso = ingreso.Id) \n INNER JOIN f_empresacontxconvenio   ON (ingreso.Id_EmpresaContxConv = f_empresacontxconvenio.Id) \n INNER JOIN f_itemordenesproced   ON (f_itemordenesproced.Id_Ordenes = f_ordenes.Id)  \n INNER JOIN f_itemripsconsulta   ON (f_itemripsconsulta.Id_Ordenes = f_itemordenesproced.Id_Ordenes) AND    (f_itemripsconsulta.Id_Procedimiento = f_itemordenesproced.Id_Procedimiento) \n INNER JOIN g_procedimiento   ON (f_itemordenesproced.Id_Procedimiento = g_procedimiento.Id) \n INNER JOIN f_liquidacion   ON (f_liquidacion.Id_Ingreso = ingreso.Id)   \n  INNER JOIN f_factura_evento ON (f_factura_evento.Id_Liquidacion = f_liquidacion.Id)   \n  INNER JOIN g_ips ON (f_empresacontxconvenio.Id_GIps = g_ips.Id)   \n  INNER JOIN f_tarifaprocedimiento ON (f_empresacontxconvenio.Id_Manual = f_tarifaprocedimiento.Id_Manual) AND   (f_tarifaprocedimiento.Id_Procedimiento = g_procedimiento.Id) \n INNER JOIN `g_causaexterna` ON ingreso.`Id_CausaExterna`=`g_causaexterna`.`Id`  INNER JOIN `f_tipofinprocedimiento` ON `f_itemordenesproced`.`Id_TipofinProc`=`f_tipofinprocedimiento`.`Id`   WHERE (g_pais.`Id`<>169 AND f_itemordenesproced.ValorUnitario >0 AND f_itemordenesproced.EsCobrable=1  \n AND g_procedimiento.Id_TipoProcRIPS =5 AND f_factura_evento.Estado =0 AND f_factura_evento.EstaArmada =2  \n AND ingreso.Estado =0 AND f_ordenes.Estado =0 AND f_factura_evento.Fecha_FacturaEvento >='" + this.xmt.formatoAMD.format(this.txtFechaIni.getDate()) + "' \n AND f_factura_evento.Fecha_FacturaEvento <='" + this.xmt.formatoAMD.format(this.txtFechaFin.getDate()) + "'  \n ) ";
            System.out.println(" Rips Consulta : " + this.sql);
            ResultSet xrs2 = this.xct.traerRs(this.sql);
            if (xrs2.next()) {
                xrs2.beforeFirst();
                while (xrs2.next()) {
                    bw.write(xrs2.getString(1));
                    bw.newLine();
                    x++;
                }
                xdato = true;
            }
            xrs2.close();
            this.xct.cerrarConexionBd();
            bw.close();
            if (xdato) {
                this.xvector.addElement("AC" + this.xmt.formatoMesAno1.format(this.txtFechaFin.getDate()) + "," + x);
            } else {
                this.xmt.mEliminarArchivo(new File(sFichero));
            }
        } catch (IOException ex) {
            Logger.getLogger(JIFGeneracionRips_Extranjeros.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        } catch (SQLException ex2) {
            Logger.getLogger(JIFGeneracionRips_Extranjeros.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex2);
        }
    }

    private void mCrearArchivo_AU_Capitado() {
        try {
            String sFichero = this.JTFRuta.getText() + this.xmt.getBarra() + "AU" + this.xmt.formatoMesAno1.format(this.txtFechaFin.getDate()) + ".txt";
            this.xmt.mEliminarArchivo(new File(sFichero));
            boolean xdato = false;
            BufferedWriter bw = new BufferedWriter(new FileWriter(sFichero));
            this.sql = "SELECT CONCAT(IF(f_factura_evento.Prefijo='',f_factura_evento.No_FacturaEvento , CONCAT(f_factura_evento.Prefijo,'',f_factura_evento.No_FacturaEvento)),',', g_ips.CodigoOrganismo,',' , g_persona.Id_TipoIdentificacion,',', CONCAT(g_pais.`Codigo`, g_persona.NoDocumento),',', DATE_FORMAT(ingreso.`FechaIngreso`,'%d/%m/%Y') ,',', \nDATE_FORMAT(ingreso.`HoraIngreso`,'%H:%m') ,',',  ingreso.NoAutorizacion ,',',ingreso.`Id_CausaExterna` ,',', `h_egreso_atencion`.`DxP` ,',', `h_egreso_atencion`.`DxR1`  ,',',`h_egreso_atencion`.`DxR2` ,',', `h_egreso_atencion`.`DxR3`  ,',',`h_egreso_atencion`.`Id_Destino`,',',`h_egreso_atencion`.`EstodoS`,',',`h_egreso_atencion`.`DxMuerte` ,',',DATE_FORMAT(`h_egreso_atencion`.`FechaSO`,'%d/%m%/%Y'),',', DATE_FORMAT(h_egreso_atencion.`HoraSO`,'%H:%m')) AS Linea \nFROM  g_ips, g_usuario \nINNER JOIN g_persona  ON (g_usuario.Id_persona = g_persona.Id)\nINNER JOIN `g_municipio` ON (g_municipio.`Id`= g_persona.`Id_MunicipioNac`)  \nINNER JOIN `g_departamento` ON (g_municipio.`Id_Dpto`= g_departamento.`Id`)  \nINNER JOIN `g_pais` ON (g_pais.`Id`= g_departamento.`CodPais`)  \nINNER JOIN ingreso ON (ingreso.Id_Usuario = g_usuario.Id_persona)  \nINNER JOIN f_empresacontxconvenio ON (ingreso.Id_EmpresaContxConv = f_empresacontxconvenio.Id)  \nINNER JOIN g_tipoatencion ON (ingreso.Id_TipoAtencion = g_tipoatencion.Id)   \nINNER JOIN f_liquidacion ON (f_liquidacion.Id_Ingreso = ingreso.Id)   \nINNER JOIN f_factura_capita ON (f_factura_capita.Id_Liquidacion = f_liquidacion.Id)   \nINNER JOIN f_factura_evento  ON (f_factura_capita.No_FacturaEvento = f_factura_evento.No_FacturaEvento) \nINNER JOIN `h_egreso_atencion` ON (h_egreso_atencion.`Id_Ingreso` = ingreso.Id)  \nWHERE (g_pais.`Id`<>169 AND `h_egreso_atencion`.Estado=1 AND `h_egreso_atencion`.Id_Tipo=3 AND  f_factura_evento.Estado =0 AND f_factura_evento.EstaArmada =2 AND ingreso.Estado =0 AND f_factura_capita.Fecha_FacturaCapita  >='" + this.xmt.formatoAMD.format(this.txtFechaIni.getDate()) + "'  AND f_factura_capita.Fecha_FacturaCapita  <='" + this.xmt.formatoAMD.format(this.txtFechaFin.getDate()) + "')  \nORDER BY IF(f_factura_evento.Prefijo='',f_factura_evento.No_FacturaEvento  ,CONCAT(f_factura_evento.Prefijo,'',f_factura_evento.No_FacturaEvento)) ASC ";
            System.out.println(" Rips Consulta : " + this.sql);
            ResultSet xrs = this.xct.traerRs(this.sql);
            int x = 0;
            if (xrs.next()) {
                xrs.beforeFirst();
                while (xrs.next()) {
                    bw.write(xrs.getString(1));
                    bw.newLine();
                    x++;
                }
                xdato = true;
            }
            xrs.close();
            this.xct.cerrarConexionBd();
            this.sql = "SELECT CONCAT(IF(f_factura_evento.Prefijo='',f_factura_evento.No_FacturaEvento , CONCAT(f_factura_evento.Prefijo,'',f_factura_evento.No_FacturaEvento)),',', g_ips.CodigoOrganismo,',' , g_persona.Id_TipoIdentificacion,',', CONCAT(g_pais.`Codigo`, g_persona.NoDocumento),',', DATE_FORMAT(ingreso.`FechaIngreso`,'%d/%m/%Y') ,',', DATE_FORMAT(ingreso.`HoraIngreso`,'%H:%m') ,',',  \ningreso.NoAutorizacion ,',',ingreso.`Id_CausaExterna` ,',', `h_egreso_atencion`.`DxP` ,',', `h_egreso_atencion`.`DxR1`  ,',',`h_egreso_atencion`.`DxR2` ,',', `h_egreso_atencion`.`DxR3`  ,',',`h_egreso_atencion`.`Id_Destino`,',',`h_egreso_atencion`.`EstodoS`,',',`h_egreso_atencion`.`DxMuerte` ,',',DATE_FORMAT(`h_egreso_atencion`.`FechaSO`,'%d/%m%/%Y'),',', DATE_FORMAT(h_egreso_atencion.`HoraSO`,'%H:%m')) AS Linea  \nFROM  g_ips, g_usuario \nINNER JOIN g_persona  ON (g_usuario.Id_persona = g_persona.Id)  \nINNER JOIN `g_municipio` ON (g_municipio.`Id`= g_persona.`Id_MunicipioNac`)  \nINNER JOIN `g_departamento` ON (g_municipio.`Id_Dpto`= g_departamento.`Id`)  \nINNER JOIN `g_pais` ON (g_pais.`Id`= g_departamento.`CodPais`)  \nINNER JOIN ingreso ON (ingreso.Id_Usuario = g_usuario.Id_persona)  \nINNER JOIN f_empresacontxconvenio ON (ingreso.Id_EmpresaContxConv = f_empresacontxconvenio.Id)  \nINNER JOIN g_tipoatencion ON (ingreso.Id_TipoAtencion = g_tipoatencion.Id)  \nINNER JOIN f_liquidacion ON (f_liquidacion.Id_Ingreso = ingreso.Id)  \nINNER JOIN f_factura_evento ON (f_factura_evento.Id_Liquidacion = f_liquidacion.Id)   \nINNER JOIN `h_egreso_atencion` ON (h_egreso_atencion.`Id_Ingreso` = ingreso.Id)  \nWHERE (g_pais.`Id`<>169 AND `h_egreso_atencion`.Estado=1 AND `h_egreso_atencion`.Id_Tipo=3 AND  f_factura_evento.Estado =0 AND f_factura_evento.EstaArmada =2 AND ingreso.Estado =0 AND f_factura_evento.Fecha_FacturaEvento >='" + this.xmt.formatoAMD.format(this.txtFechaIni.getDate()) + "' AND f_factura_evento.Fecha_FacturaEvento <='" + this.xmt.formatoAMD.format(this.txtFechaFin.getDate()) + "')  \nORDER BY IF(f_factura_evento.Prefijo='',f_factura_evento.No_FacturaEvento  ,CONCAT(f_factura_evento.Prefijo,'',f_factura_evento.No_FacturaEvento)) ASC ";
            System.out.println(" Rips Consulta : " + this.sql);
            ResultSet xrs2 = this.xct.traerRs(this.sql);
            if (xrs2.next()) {
                xrs2.beforeFirst();
                while (xrs2.next()) {
                    bw.write(xrs2.getString(1));
                    bw.newLine();
                    x++;
                }
                xdato = true;
            }
            xrs2.close();
            this.xct.cerrarConexionBd();
            bw.close();
            if (xdato) {
                this.xvector.addElement("AU" + this.xmt.formatoMesAno1.format(this.txtFechaFin.getDate()) + "," + x);
            } else {
                this.xmt.mEliminarArchivo(new File(sFichero));
            }
        } catch (IOException ex) {
            Logger.getLogger(JIFGeneracionRips_Extranjeros.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        } catch (SQLException ex2) {
            Logger.getLogger(JIFGeneracionRips_Extranjeros.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex2);
        }
    }

    private void mCrearArchivo_AN_Capitado() {
        try {
            String sFichero = this.JTFRuta.getText() + this.xmt.getBarra() + "AN" + this.xmt.formatoMesAno1.format(this.txtFechaFin.getDate()) + ".txt";
            this.xmt.mEliminarArchivo(new File(sFichero));
            boolean xdato = false;
            BufferedWriter bw = new BufferedWriter(new FileWriter(sFichero));
            this.sql = "SELECT  CONCAT(IF(f_factura_evento.Prefijo='',f_factura_evento.No_FacturaEvento ,CONCAT(f_factura_evento.Prefijo,'',f_factura_evento.No_FacturaEvento)), ',', `g_ips`.`CodigoOrganismo`, ',', `g_persona`.`Id_TipoIdentificacion`\n , ',',CONCAT(g_pais.`Codigo`, g_persona.NoDocumento) , ',',DATE_FORMAT(`h_orden_qx_nacido_detalle`.`FechaNac`,'%d/%m/%Y') , ',', DATE_FORMAT(`h_orden_qx_nacido_detalle`.`Hora`,'%H:%i') , ',', ROUND(IF( (`h_examenfisico`.`SGestacion` IS NULL ||`h_examenfisico`.`SGestacion` =0)  ,(SELECT ROUND(`SemanaG`) FROM`h_antecedenteginecologico` WHERE (`Id_Usuario` =g_persona.`Id` AND `SemanaG` <>'') ORDER BY `Id` DESC LIMIT 1), `h_examenfisico`.`SGestacion`)) , ',',IF(h_examenfisico.`Id_Usuario_Programa`=0, 2,1), ',',IF(`h_orden_qx_nacido_detalle`.`Sexo`='FEMENINO','F', 'M'), ',',\n  `h_orden_qx_nacido_detalle`.`Peso` , ',',`h_orden_qx_nacido_detalle`.`DX`, ',', '' , ',', '' , ',', '' ) AS NFila \nFROM  `h_orden_qx_nacido_detalle` \nINNER JOIN  `h_orden_qx_nacidos`  ON (`h_orden_qx_nacido_detalle`.`IdEncabezado` = `h_orden_qx_nacidos`.`Id`) \nINNER JOIN  `h_orden_qx`  ON (`h_orden_qx_nacidos`.`IdOrdenQx` = `h_orden_qx`.`Id`) \nINNER JOIN  `h_atencion`  ON (`h_orden_qx`.`Id_Atencion` = `h_atencion`.`Id`) \nINNER JOIN  `ingreso`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`) \nLEFT JOIN  `h_examenfisico`  ON (`h_atencion`.`Id` = `h_examenfisico`.`Id`) \nINNER JOIN  `f_liquidacion`  ON (`f_liquidacion`.`Id_Ingreso` = `ingreso`.`Id`) \nINNER JOIN  `f_empresacontxconvenio`  ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`) \nINNER JOIN  `f_factura_capita`  ON (`f_factura_capita`.`Id_Liquidacion` = `f_liquidacion`.`Id`) \nINNER JOIN  `g_ips`  ON (`f_empresacontxconvenio`.`Id_GIps` = `g_ips`.`Id`) \nINNER JOIN  `f_factura_evento`  ON (`f_factura_evento`.`No_FacturaEvento` = `f_factura_capita`.`No_FacturaEvento`) \nINNER JOIN  `g_persona`  ON (`g_persona`.`Id` = `ingreso`.`Id_Usuario`) \nINNER JOIN `g_municipio` ON (g_municipio.`Id`= g_persona.`Id_MunicipioNac`)  \nINNER JOIN `g_departamento` ON (g_municipio.`Id_Dpto`= g_departamento.`Id`)  \nINNER JOIN `g_pais` ON (g_pais.`Id`= g_departamento.`CodPais`)  \nWHERE (g_pais.`Id`<>169 AND f_factura_capita.Fecha_FacturaCapita>='" + this.xmt.formatoAMD.format(this.txtFechaIni.getDate()) + "' AND f_factura_capita.Fecha_FacturaCapita <='" + this.xmt.formatoAMD.format(this.txtFechaFin.getDate()) + "' AND `f_factura_capita`.`EstaArmada` =2 AND `h_orden_qx`.`Estado` =1) ";
            System.out.println(" Rips Consulta : " + this.sql);
            ResultSet xrs = this.xct.traerRs(this.sql);
            int x = 0;
            if (xrs.next()) {
                xrs.first();
                if (xrs.getString(1) != null) {
                    xdato = true;
                }
                xrs.beforeFirst();
                while (xrs.next()) {
                    if (xrs.getString(1) != null) {
                        bw.write(xrs.getString(1));
                        bw.newLine();
                        x++;
                    }
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
            this.sql = "SELECT  CONCAT(IF(f_factura_evento.Prefijo='',f_factura_evento.No_FacturaEvento ,CONCAT(f_factura_evento.Prefijo,'',f_factura_evento.No_FacturaEvento)), ',', `g_ips`.`CodigoOrganismo`, ',', `g_persona`.`Id_TipoIdentificacion`\n, ',',CONCAT(g_pais.`Codigo`, g_persona.NoDocumento), ',',DATE_FORMAT(`h_orden_qx_nacido_detalle`.`FechaNac`,'%d/%m/%Y') , ',', DATE_FORMAT(`h_orden_qx_nacido_detalle`.`Hora`,'%H:%i') , ',', ROUND(IF( (`h_examenfisico`.`SGestacion` IS NULL ||`h_examenfisico`.`SGestacion` =0)  ,(SELECT ROUND(`SemanaG`) FROM`h_antecedenteginecologico` WHERE (`Id_Usuario` =g_persona.`Id` AND `SemanaG` <>'') ORDER BY `Id` DESC LIMIT 1), `h_examenfisico`.`SGestacion`)) , ',',IF(h_examenfisico.`Id_Usuario_Programa`=0, 2,1), ',',IF(`h_orden_qx_nacido_detalle`.`Sexo`='FEMENINO','F', 'M'), ',',\n `h_orden_qx_nacido_detalle`.`Peso` , ',',`h_orden_qx_nacido_detalle`.`DX`, ',', '' , ',', '' , ',', '' ) AS NFila \nFROM  `h_orden_qx_nacido_detalle` \nINNER JOIN  `h_orden_qx_nacidos`  ON (`h_orden_qx_nacido_detalle`.`IdEncabezado` = `h_orden_qx_nacidos`.`Id`) \nINNER JOIN  `h_orden_qx`  ON (`h_orden_qx_nacidos`.`IdOrdenQx` = `h_orden_qx`.`Id`) \nINNER JOIN  `h_atencion`  ON (`h_orden_qx`.`Id_Atencion` = `h_atencion`.`Id`) \nINNER JOIN  `ingreso`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`) \nLEFT JOIN  `h_examenfisico`  ON (`h_atencion`.`Id` = `h_examenfisico`.`Id`) \nINNER JOIN  `f_liquidacion`  ON (`f_liquidacion`.`Id_Ingreso` = `ingreso`.`Id`) \nINNER JOIN  `f_empresacontxconvenio`  ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`) \nINNER JOIN  `f_factura_evento`  ON (`f_factura_evento`.`Id_Liquidacion` = `f_liquidacion`.`Id`) \nINNER JOIN  `g_ips`  ON (`f_empresacontxconvenio`.`Id_GIps` = `g_ips`.`Id`)  \nINNER JOIN  `g_persona`  ON (`g_persona`.`Id` = `ingreso`.`Id_Usuario`) \nINNER JOIN `g_municipio` ON (g_municipio.`Id`= g_persona.`Id_MunicipioNac`)  \nINNER JOIN `g_departamento` ON (g_municipio.`Id_Dpto`= g_departamento.`Id`)  \nINNER JOIN `g_pais` ON (g_pais.`Id`= g_departamento.`CodPais`)  \nWHERE (g_pais.`Id`<>169 AND `f_factura_evento`.`Fecha_FacturaEvento`>='" + this.xmt.formatoAMD.format(this.txtFechaIni.getDate()) + "' AND `f_factura_evento`.`Fecha_FacturaEvento` <='" + this.xmt.formatoAMD.format(this.txtFechaFin.getDate()) + "' AND `f_factura_evento`.`EstaArmada` =2 AND `h_orden_qx`.`Estado` =1) ";
            System.out.println(" Rips Consulta : " + this.sql);
            ResultSet xrs2 = this.xct.traerRs(this.sql);
            if (xrs2.next()) {
                xrs2.first();
                if (xrs2.getString(1) != null) {
                    xdato = true;
                }
                xrs2.beforeFirst();
                while (xrs2.next()) {
                    if (xrs2.getString(1) != null) {
                        bw.write(xrs2.getString(1));
                        bw.newLine();
                        x++;
                    }
                }
            }
            xrs2.close();
            this.xct.cerrarConexionBd();
            bw.close();
            if (xdato) {
                this.xvector.addElement("AN" + this.xmt.formatoMesAno1.format(this.txtFechaFin.getDate()) + "," + x);
            } else {
                this.xmt.mEliminarArchivo(new File(sFichero));
            }
        } catch (IOException ex) {
            Logger.getLogger(JIFGeneracionRips_Extranjeros.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        } catch (SQLException ex2) {
            Logger.getLogger(JIFGeneracionRips_Extranjeros.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex2);
        }
    }

    private void mCrearArchivo_AH_Capitado() {
        try {
            String sFichero = this.JTFRuta.getText() + this.xmt.getBarra() + "AH" + this.xmt.formatoMesAno1.format(this.txtFechaFin.getDate()) + ".txt";
            this.xmt.mEliminarArchivo(new File(sFichero));
            boolean xdato = false;
            BufferedWriter bw = new BufferedWriter(new FileWriter(sFichero));
            this.sql = "SELECT CONCAT(IF(f_factura_evento.Prefijo='',f_factura_evento.No_FacturaEvento , CONCAT(f_factura_evento.Prefijo,'',f_factura_evento.No_FacturaEvento)),',', g_ips.CodigoOrganismo,',' , g_persona.Id_TipoIdentificacion,',', CONCAT(g_pais.`Codigo`, g_persona.NoDocumento),',', g_origenadmision.`codigo_rips_homologado` ,',',DATE_FORMAT(ingreso.`FechaIngreso`,'%d/%m/%Y') ,',',DATE_FORMAT(ingreso.`HoraIngreso`,'%H:%m') ,',',  \ningreso.NoAutorizacion ,',',LPAD(`g_causaexterna`.`codigo_rips_homologado` ,2,'0') ,',', IF(`ingreso`.`DxIngreso`='0000',`h_egreso_atencion`.`DxP`, `ingreso`.`DxIngreso`) ,',', `h_egreso_atencion`.`DxP` ,',', `h_egreso_atencion`.`DxR1`  ,',',`h_egreso_atencion`.`DxR2` ,',',`h_egreso_atencion`.`DxR3`  ,',', `h_egreso_atencion`.`DxC`  ,',',`h_egreso_atencion`.`EstodoS`,',',`h_egreso_atencion`.`DxMuerte` ,',',DATE_FORMAT(`h_egreso_atencion`.`FechaSO`,'%d/%m%/%Y'),',', DATE_FORMAT(h_egreso_atencion.`HoraSO`,'%H:%m')) AS Linea  \nFROM  g_ips, g_usuario \nINNER JOIN g_persona  ON (g_usuario.Id_persona = g_persona.Id)  \nINNER JOIN `g_municipio` ON (g_municipio.`Id`= g_persona.`Id_MunicipioNac`)  \nINNER JOIN `g_departamento` ON (g_municipio.`Id_Dpto`= g_departamento.`Id`)  \nINNER JOIN `g_pais` ON (g_pais.`Id`= g_departamento.`CodPais`)  \nINNER JOIN ingreso ON (ingreso.Id_Usuario = g_usuario.Id_persona)  \nINNER JOIN f_empresacontxconvenio ON (ingreso.Id_EmpresaContxConv = f_empresacontxconvenio.Id)  \nINNER JOIN g_tipoatencion ON (ingreso.Id_TipoAtencion = g_tipoatencion.Id)   \nINNER JOIN f_liquidacion ON (f_liquidacion.Id_Ingreso = ingreso.Id)    \nINNER JOIN f_factura_capita ON (f_factura_capita.Id_Liquidacion = f_liquidacion.Id)  \nINNER JOIN f_factura_evento  ON (f_factura_capita.No_FacturaEvento = f_factura_evento.No_FacturaEvento) \nINNER JOIN `h_egreso_atencion` ON (h_egreso_atencion.`Id_Ingreso` = ingreso.Id)  \n INNER JOIN `g_causaexterna` ON ingreso.`Id_CausaExterna`=`g_causaexterna`.`Id`  INNER JOIN `g_origenadmision` ON ingreso.`Id_OrigenAdmision`=`g_origenadmision`.`Id` WHERE (g_pais.`Id`<>169 AND `h_egreso_atencion`.Estado=1 AND `h_egreso_atencion`.Id_Tipo=2 AND f_factura_evento.Estado =0 AND f_factura_evento.EstaArmada =2 AND ingreso.Estado =0 AND f_factura_capita.Fecha_FacturaCapita >='" + this.xmt.formatoAMD.format(this.txtFechaIni.getDate()) + "' AND f_factura_capita.Fecha_FacturaCapita <='" + this.xmt.formatoAMD.format(this.txtFechaFin.getDate()) + "') \nORDER BY IF(f_factura_evento.Prefijo='',f_factura_evento.No_FacturaEvento  ,CONCAT(f_factura_evento.Prefijo,'',f_factura_evento.No_FacturaEvento)) ASC ";
            System.out.println(" Rips AH : " + this.sql);
            ResultSet xrs = this.xct.traerRs(this.sql);
            int x = 0;
            if (xrs.next()) {
                xrs.beforeFirst();
                while (xrs.next()) {
                    bw.write(xrs.getString(1));
                    bw.newLine();
                    x++;
                }
                xdato = true;
            }
            xrs.close();
            this.xct.cerrarConexionBd();
            this.sql = "SELECT CONCAT(IF(f_factura_evento.Prefijo='',f_factura_evento.No_FacturaEvento , CONCAT(f_factura_evento.Prefijo,'',f_factura_evento.No_FacturaEvento)),',', g_ips.CodigoOrganismo,',' , g_persona.Id_TipoIdentificacion,',', CONCAT(g_pais.`Codigo`, g_persona.NoDocumento),',', g_origenadmision.`codigo_rips_homologado` ,',',DATE_FORMAT(ingreso.`FechaIngreso`,'%d/%m/%Y') ,',', DATE_FORMAT(ingreso.`HoraIngreso`,'%H:%m') ,',',  \n ingreso.NoAutorizacion ,',',LPAD(`g_causaexterna`.`codigo_rips_homologado` ,2,'0') ,',', IF(`ingreso`.`DxIngreso`='0000',`h_egreso_atencion`.`DxP`, `ingreso`.`DxIngreso`) ,',', `h_egreso_atencion`.`DxP` ,',', `h_egreso_atencion`.`DxR1`  ,',',`h_egreso_atencion`.`DxR2` ,',',`h_egreso_atencion`.`DxR3`  ,',', `h_egreso_atencion`.`DxC`  ,',',`h_egreso_atencion`.`EstodoS`,',',`h_egreso_atencion`.`DxMuerte` ,',',DATE_FORMAT(`h_egreso_atencion`.`FechaSO`,'%d/%m%/%Y'),',', DATE_FORMAT(h_egreso_atencion.`HoraSO`,'%H:%m')) AS Linea  \nFROM  g_ips, g_usuario \nINNER JOIN g_persona  ON (g_usuario.Id_persona = g_persona.Id)  \nINNER JOIN `g_municipio` ON (g_municipio.`Id`= g_persona.`Id_MunicipioNac`)  \nINNER JOIN `g_departamento` ON (g_municipio.`Id_Dpto`= g_departamento.`Id`)  \nINNER JOIN `g_pais` ON (g_pais.`Id`= g_departamento.`CodPais`)  \nINNER JOIN ingreso ON (ingreso.Id_Usuario = g_usuario.Id_persona)  \nINNER JOIN f_empresacontxconvenio ON (ingreso.Id_EmpresaContxConv = f_empresacontxconvenio.Id)  \nINNER JOIN g_tipoatencion ON (ingreso.Id_TipoAtencion = g_tipoatencion.Id)   \nINNER JOIN f_liquidacion ON (f_liquidacion.Id_Ingreso = ingreso.Id)    \nINNER JOIN f_factura_evento ON (f_factura_evento.Id_Liquidacion = f_liquidacion.Id)   \nINNER JOIN `h_egreso_atencion` ON (h_egreso_atencion.`Id_Ingreso` = ingreso.Id)  \n INNER JOIN `g_causaexterna` ON ingreso.`Id_CausaExterna`=`g_causaexterna`.`Id`  INNER JOIN `g_origenadmision` ON ingreso.`Id_OrigenAdmision`=`g_origenadmision`.`Id` WHERE (g_pais.`Id`<>169 AND `h_egreso_atencion`.Estado=1 AND `h_egreso_atencion`.Id_Tipo=2 AND  f_factura_evento.Estado =0 AND f_factura_evento.EstaArmada =2 AND ingreso.Estado =0 AND f_factura_evento.Fecha_FacturaEvento >='" + this.xmt.formatoAMD.format(this.txtFechaIni.getDate()) + "' AND f_factura_evento.Fecha_FacturaEvento <='" + this.xmt.formatoAMD.format(this.txtFechaFin.getDate()) + "' ) \nORDER BY IF(f_factura_evento.Prefijo='',f_factura_evento.No_FacturaEvento  ,CONCAT(f_factura_evento.Prefijo,'',f_factura_evento.No_FacturaEvento)) ASC ";
            System.out.println(" Rips AH : " + this.sql);
            ResultSet xrs2 = this.xct.traerRs(this.sql);
            if (xrs2.next()) {
                xrs2.beforeFirst();
                while (xrs2.next()) {
                    bw.write(xrs2.getString(1));
                    bw.newLine();
                    x++;
                }
                xdato = true;
            }
            xrs2.close();
            this.xct.cerrarConexionBd();
            bw.close();
            if (xdato) {
                this.xvector.addElement("AH" + this.xmt.formatoMesAno1.format(this.txtFechaFin.getDate()) + "," + x);
            } else {
                this.xmt.mEliminarArchivo(new File(sFichero));
            }
        } catch (IOException ex) {
            Logger.getLogger(JIFGeneracionRips_Extranjeros.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        } catch (SQLException ex2) {
            Logger.getLogger(JIFGeneracionRips_Extranjeros.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex2);
        }
    }

    private void mCrearArchivo_AP_Capitado() {
        try {
            String sFichero = this.JTFRuta.getText() + this.xmt.getBarra() + "AP" + this.xmt.formatoMesAno1.format(this.txtFechaFin.getDate()) + ".txt";
            this.xmt.mEliminarArchivo(new File(sFichero));
            BufferedWriter bw = new BufferedWriter(new FileWriter(sFichero));
            boolean xdato = false;
            this.sql = "SELECT concat(IF(f_factura_evento.Prefijo='',f_factura_evento.No_FacturaEvento ,CONCAT(f_factura_evento.Prefijo,'',f_factura_evento.No_FacturaEvento)),',',g_ips.CodigoOrganismo,',',g_persona.Id_TipoIdentificacion,',',CONCAT(g_pais.`Codigo`, g_persona.NoDocumento),',',\n DATE_FORMAT(f_factura_capita.Fecha_FacturaCapita,'%d/%m/%Y') ,',',if(f_itemordenesproced.NAutorizacion='',ingreso.NoAutorizacion,f_itemordenesproced.NAutorizacion),',',f_tarifaprocedimiento.CodCUPS,',',\n g_tipoatencion.Id_TipoAmbito,',',`f_tipofinprocedimiento`.`codigo_rips_homologado`,',','',',',if(IF(`f_empresacontxconvenio`.`TCodigo`=0, f_tarifaprocedimiento.CodCUPS ,IF(`f_empresacontxconvenio`.`TCodigo`=1,g_procedimiento.`C_Real`,g_procedimiento.`C_Homologado`))=898001,'Z014',if('" + this.xIncluir_Dx + "'=0,'', if(ingreso.DxIngreso='0000','',ingreso.DxIngreso))),',','',',','',',',\n '',',',IF(0= '" + this.xAgrupado + "'  , ROUND(((f_itemordenesproced.ValorUnitario*f_itemordenesproced.Cantidad)+f_itemordenesproced.valorImpuesto)), f_itemordenesproced.ValorUnitario)) as Linea, f_itemordenesproced.Cantidad  \nFROM g_usuario \nINNER JOIN g_persona ON (g_usuario.Id_persona = g_persona.Id) \nINNER JOIN `g_municipio` ON (g_municipio.`Id`= g_persona.`Id_MunicipioNac`)  \nINNER JOIN `g_departamento` ON (g_municipio.`Id_Dpto`= g_departamento.`Id`)  \nINNER JOIN `g_pais` ON (g_pais.`Id`= g_departamento.`CodPais`)  \nINNER JOIN ingreso ON (ingreso.Id_Usuario = g_usuario.Id_persona) \nINNER JOIN f_ordenes ON (f_ordenes.Id_Ingreso = ingreso.Id) \nINNER JOIN f_empresacontxconvenio ON (ingreso.Id_EmpresaContxConv = f_empresacontxconvenio.Id) \nINNER JOIN f_itemordenesproced  ON (f_itemordenesproced.Id_Ordenes = f_ordenes.Id) \nINNER JOIN g_procedimiento ON (f_itemordenesproced.Id_Procedimiento = g_procedimiento.Id) \n INNER JOIN g_ips ON (f_empresacontxconvenio.Id_GIps = g_ips.Id)  \nINNER JOIN f_liquidacion ON (f_liquidacion.Id_Ingreso = ingreso.Id) \nINNER JOIN f_tarifaprocedimiento ON (f_empresacontxconvenio.Id_Manual = f_tarifaprocedimiento.Id_Manual) AND (f_tarifaprocedimiento.Id_Procedimiento = g_procedimiento.Id) \nINNER JOIN f_factura_capita ON (f_factura_capita.Id_Liquidacion = f_liquidacion.Id) \nINNER JOIN f_factura_evento ON (f_factura_capita.No_FacturaEvento = f_factura_evento.No_FacturaEvento) \nINNER JOIN g_tipoatencion ON (ingreso.Id_TipoAtencion = g_tipoatencion.Id) \n INNER JOIN `f_tipofinprocedimiento` ON `f_itemordenesproced`.`Id_TipofinProc`=`f_tipofinprocedimiento`.`Id` WHERE (g_pais.`Id`<>169 AND f_itemordenesproced.ValorUnitario >0 \nAND g_procedimiento.Id_TipoProcRIPS =6  AND f_factura_evento.Estado =0 AND f_itemordenesproced.EsCobrable=1 AND f_factura_evento.EstaArmada =2 AND ingreso.Estado =0 \nAND f_ordenes.Estado =0 AND f_factura_capita.EstaArmada =2 AND f_factura_capita.Estado =0 AND f_factura_capita.Fecha_FacturaCapita >='" + this.xmt.formatoAMD.format(this.txtFechaIni.getDate()) + "' AND f_factura_capita.Fecha_FacturaCapita <='" + this.xmt.formatoAMD.format(this.txtFechaFin.getDate()) + "' ) order by f_factura_evento.No_FacturaEvento ASC, f_factura_capita.Fecha_FacturaCapita ASC, g_persona.Apellido1 ASC, g_persona.Apellido2 ASC, g_persona.Nombre1 ASC, g_persona.Nombre2 ASC";
            System.out.println(" Rips PROCEDIMIENTO : " + this.sql);
            ResultSet xrs = this.xct.traerRs(this.sql);
            int x = 0;
            if (xrs.next()) {
                xrs.beforeFirst();
                while (xrs.next()) {
                    if (this.JCH_AgrupadoProcedimiento.isSelected()) {
                        bw.write(xrs.getString(1));
                        bw.newLine();
                        x++;
                    } else if (xrs.getInt("Cantidad") > 1) {
                        for (int y = 0; y < xrs.getInt("Cantidad"); y++) {
                            bw.write(xrs.getString(1));
                            bw.newLine();
                            x++;
                        }
                    } else {
                        bw.write(xrs.getString(1));
                        bw.newLine();
                        x++;
                    }
                }
                xdato = true;
            }
            xrs.close();
            this.xct.cerrarConexionBd();
            this.sql = "SELECT CONCAT(IF(f_factura_evento.Prefijo='',f_factura_evento.No_FacturaEvento ,CONCAT(f_factura_evento.Prefijo,'',f_factura_evento.No_FacturaEvento)),',', g_ips.CodigoOrganismo,',', g_persona.Id_TipoIdentificacion,',', CONCAT(g_pais.`Codigo`, g_persona.NoDocumento),',', \nDATE_FORMAT(f_factura_evento.Fecha_FacturaEvento,'%d/%m/%Y') ,',', IF(f_itemordenesproced.NAutorizacion='',ingreso.NoAutorizacion,f_itemordenesproced.NAutorizacion),',',f_tarifaprocedimiento.CodCUPS,',', \ng_tipoatencion.Id_TipoAmbito,',', `f_tipofinprocedimiento`.`codigo_rips_homologado`,',','',',', IF(IF(`f_empresacontxconvenio`.`TCodigo`=0, f_tarifaprocedimiento.CodCUPS ,IF(`f_empresacontxconvenio`.`TCodigo`=1,g_procedimiento.`C_Real`,g_procedimiento.`C_Homologado`))=898001,'Z014',IF('" + this.xIncluir_Dx + "'=0,'', IF(ingreso.DxIngreso='0000','',ingreso.DxIngreso)))  ,',','',',','',',',\n'' ,',',IF(0='" + this.xAgrupado + "', ROUND(((f_itemordenesproced.ValorUnitario*f_itemordenesproced.Cantidad)+f_itemordenesproced.valorImpuesto)), f_itemordenesproced.ValorUnitario)) AS Linea, f_itemordenesproced.Cantidad  \nFROM  g_ips, g_usuario \nINNER JOIN g_persona  ON (g_usuario.Id_persona = g_persona.Id) \nINNER JOIN `g_municipio` ON (g_municipio.`Id`= g_persona.`Id_MunicipioNac`)  \nINNER JOIN `g_departamento` ON (g_municipio.`Id_Dpto`= g_departamento.`Id`)  \nINNER JOIN `g_pais` ON (g_pais.`Id`= g_departamento.`CodPais`)  \nINNER JOIN ingreso ON (ingreso.Id_Usuario = g_usuario.Id_persona) \nINNER JOIN f_ordenes ON (f_ordenes.Id_Ingreso = ingreso.Id) \nINNER JOIN f_empresacontxconvenio ON (ingreso.Id_EmpresaContxConv = f_empresacontxconvenio.Id) \nINNER JOIN g_tipoatencion ON (ingreso.Id_TipoAtencion = g_tipoatencion.Id) \nINNER JOIN f_itemordenesproced ON (f_itemordenesproced.Id_Ordenes = f_ordenes.Id) \nINNER JOIN g_procedimiento ON (f_itemordenesproced.Id_Procedimiento = g_procedimiento.Id) \nINNER JOIN f_liquidacion ON (f_liquidacion.Id_Ingreso = ingreso.Id) \nINNER JOIN f_factura_evento ON (f_factura_evento.Id_Liquidacion = f_liquidacion.Id)  \nINNER JOIN f_tarifaprocedimiento ON (f_empresacontxconvenio.Id_Manual = f_tarifaprocedimiento.Id_Manual) AND (f_tarifaprocedimiento.Id_Procedimiento = g_procedimiento.Id) \n INNER JOIN `f_tipofinprocedimiento` ON `f_itemordenesproced`.`Id_TipofinProc`=`f_tipofinprocedimiento`.`Id` WHERE (g_pais.`Id`<>169 AND f_itemordenesproced.ValorUnitario >0 \nAND f_itemordenesproced.EsCobrable=1 AND g_procedimiento.Id_TipoProcRIPS =6 AND f_factura_evento.Estado =0 AND f_factura_evento.EstaArmada =2 \nAND ingreso.Estado =0 AND f_ordenes.Estado =0 AND f_factura_evento.Fecha_FacturaEvento >='" + this.xmt.formatoAMD.format(this.txtFechaIni.getDate()) + "' AND f_factura_evento.Fecha_FacturaEvento <='" + this.xmt.formatoAMD.format(this.txtFechaFin.getDate()) + "') ORDER BY IF(f_factura_evento.Prefijo='',f_factura_evento.No_FacturaEvento ,CONCAT(f_factura_evento.Prefijo,'',f_factura_evento.No_FacturaEvento)) ASC";
            System.out.println(" Rips PROCEDIMIENTO : " + this.sql);
            ResultSet xrs2 = this.xct.traerRs(this.sql);
            if (xrs2.next()) {
                xrs2.beforeFirst();
                while (xrs2.next()) {
                    if (this.JCH_AgrupadoProcedimiento.isSelected()) {
                        bw.write(xrs2.getString(1));
                        bw.newLine();
                        x++;
                    } else if (xrs2.getInt("Cantidad") > 1) {
                        for (int y2 = 0; y2 < xrs2.getInt("Cantidad"); y2++) {
                            bw.write(xrs2.getString(1));
                            bw.newLine();
                            x++;
                        }
                    } else {
                        bw.write(xrs2.getString(1));
                        bw.newLine();
                        x++;
                    }
                }
                xdato = true;
            }
            xrs2.close();
            this.xct.cerrarConexionBd();
            this.sql = "SELECT CONCAT(IF(f_factura_evento.Prefijo='',f_factura_evento.No_FacturaEvento ,CONCAT(f_factura_evento.Prefijo,'',f_factura_evento.No_FacturaEvento)),',',g_ips.CodigoOrganismo,',',g_persona.Id_TipoIdentificacion,',',CONCAT(g_pais.`Codigo`, g_persona.NoDocumento),',', DATE_FORMAT(f_factura_capita.Fecha_FacturaCapita,'%d/%m/%Y') ,',',IF(f_ordenesqx.NAutorizacion='',ingreso.NoAutorizacion,f_ordenesqx.`NAutorizacion`),',',q_procedtipomanqx.`CodCups`,',', \ng_tipoatencion.Id_TipoAmbito,',',g_procedimiento.`Id_TipoFinProced`,',',g_especialidad.`Id_CRips`,',', f_ordenesqx.`DxP`,',',f_ordenesqx.`DxR`,',',f_ordenesqx.`DxC`,',', \nf_ordenesqx.`Id_Forma`,',',(`f_itemordenesqx`.`Valor`)) AS Linea  \nFROM g_usuario \nINNER JOIN g_persona ON (g_usuario.Id_persona = g_persona.Id) \nINNER JOIN `g_municipio` ON (g_municipio.`Id`= g_persona.`Id_MunicipioNac`)  \nINNER JOIN `g_departamento` ON (g_municipio.`Id_Dpto`= g_departamento.`Id`)  \nINNER JOIN `g_pais` ON (g_pais.`Id`= g_departamento.`CodPais`)  \nINNER JOIN ingreso ON (ingreso.Id_Usuario = g_usuario.Id_persona) \nINNER JOIN f_ordenes ON (f_ordenes.Id_Ingreso = ingreso.Id)  \nINNER JOIN f_empresacontxconvenio ON (ingreso.Id_EmpresaContxConv = f_empresacontxconvenio.Id)  \nINNER JOIN f_ordenesqx  ON (f_ordenes.Id = f_ordenesqx.Id_Orden)  \nINNER JOIN  `f_itemordenesqx` ON (`f_itemordenesqx`.`Id_OrdenQX` = `f_ordenesqx`.`Id`)\nINNER JOIN `g_procedimiento` g_procedimiento1  ON (`f_itemordenesqx`.`Id_Procedimiento` = `g_procedimiento1`.`Id`)\nINNER JOIN `g_especialidad` ON (g_especialidad.`Id` = f_ordenesqx.`Id_Especialidad`)  \nINNER JOIN g_procedimiento ON (f_ordenesqx.`Id_Procedimiento` = g_procedimiento.Id)  \nINNER JOIN `q_procedtipomanqx` ON (`q_procedtipomanqx`.`Id_Procedimiento` = `g_procedimiento`.`Id`) \nLEFT JOIN  `q_tipomanualqx` ON (`q_procedtipomanqx`.`Id_TipoManualQx` = `q_tipomanualqx`.`Id`) \nLEFT JOIN  `f_manual`  ON (`f_manual`.`Id_TipoManQx` = `q_tipomanualqx`.`Id`)  AND (`f_empresacontxconvenio`.`Id_Manual` = `f_manual`.`Id`) \nINNER JOIN g_ips ON (f_empresacontxconvenio.Id_GIps = g_ips.Id)  \nINNER JOIN f_liquidacion ON (f_liquidacion.Id_Ingreso = ingreso.Id)  \nINNER JOIN f_factura_capita ON (f_factura_capita.Id_Liquidacion = f_liquidacion.Id) \nINNER JOIN f_factura_evento ON (f_factura_capita.No_FacturaEvento = f_factura_evento.No_FacturaEvento) \nINNER JOIN g_tipoatencion ON (ingreso.Id_TipoAtencion = g_tipoatencion.Id) \nWHERE (g_pais.`Id`<>169 AND f_ordenesqx.`Valor` >0 AND f_ordenesqx.`EsCobrable`=1 \nAND f_factura_evento.Estado =0 AND f_factura_evento.EstaArmada =2 AND ingreso.Estado =0  \nAND f_ordenes.Estado =0 AND f_factura_capita.EstaArmada =2 AND f_factura_capita.Estado =0 AND f_factura_capita.Fecha_FacturaCapita >='" + this.xmt.formatoAMD.format(this.txtFechaIni.getDate()) + "' \nAND `f_itemordenesqx`.`Id_TipoHonorario` =1 AND  f_factura_capita.Fecha_FacturaCapita <='" + this.xmt.formatoAMD.format(this.txtFechaFin.getDate()) + "' ) GROUP BY f_ordenes.`Id`, f_ordenesqx.`Id_Procedimiento` ORDER BY f_factura_evento.No_FacturaEvento ASC, \nf_factura_capita.Fecha_FacturaCapita ASC, g_persona.Apellido1 ASC, g_persona.Apellido2 ASC, g_persona.Nombre1 ASC, g_persona.Nombre2 ASC ";
            System.out.println(" Rips PROCEDIMIENTO QX : " + this.sql);
            ResultSet xrs1 = this.xct.traerRs(this.sql);
            if (xrs1.next()) {
                xrs1.beforeFirst();
                while (xrs1.next()) {
                    bw.write(xrs1.getString(1));
                    bw.newLine();
                    x++;
                }
                xdato = true;
            }
            xrs1.close();
            this.xct.cerrarConexionBd();
            this.sql = "SELECT CONCAT(IF(f_factura_evento.Prefijo='',f_factura_evento.No_FacturaEvento ,CONCAT(f_factura_evento.Prefijo,'',f_factura_evento.No_FacturaEvento)),',', g_ips.CodigoOrganismo,',', g_persona.Id_TipoIdentificacion,',', CONCAT(g_pais.`Codigo`, g_persona.NoDocumento),',',  \nDATE_FORMAT(f_factura_evento.Fecha_FacturaEvento,'%d/%m/%Y') ,',', IF(f_ordenesqx.NAutorizacion='',ingreso.NoAutorizacion,f_ordenesqx.`NAutorizacion`),',',q_procedtipomanqx.`CodCups`,',', \ng_tipoatencion.Id_TipoAmbito,',',g_procedimiento.`Id_TipoFinProced`,',',g_especialidad.`Id_CRips`,',', f_ordenesqx.`DxP`,',',f_ordenesqx.`DxR`,',',f_ordenesqx.`DxC`,',', \nf_ordenesqx.`Id_Forma`,',',(`f_itemordenesqx`.`Valor`)) AS Linea  \nFROM  g_usuario  \nINNER JOIN g_persona  ON (g_usuario.Id_persona = g_persona.Id) \nINNER JOIN `g_municipio` ON (g_municipio.`Id`= g_persona.`Id_MunicipioNac`)  \nINNER JOIN `g_departamento` ON (g_municipio.`Id_Dpto`= g_departamento.`Id`)  \nINNER JOIN `g_pais` ON (g_pais.`Id`= g_departamento.`CodPais`)  \nINNER JOIN ingreso ON (ingreso.Id_Usuario = g_usuario.Id_persona) \nINNER JOIN f_ordenes ON (f_ordenes.Id_Ingreso = ingreso.Id)  \nINNER JOIN f_empresacontxconvenio ON (ingreso.Id_EmpresaContxConv = f_empresacontxconvenio.Id)  \nINNER JOIN g_tipoatencion ON (ingreso.Id_TipoAtencion = g_tipoatencion.Id) \nINNER JOIN f_ordenesqx  ON (f_ordenes.Id = f_ordenesqx.Id_Orden)  \nINNER JOIN  `f_itemordenesqx`  ON (`f_itemordenesqx`.`Id_OrdenQX` = `f_ordenesqx`.`Id`)\nINNER JOIN `g_procedimiento`  g_procedimiento1  ON (`f_itemordenesqx`.`Id_Procedimiento` = `g_procedimiento1`.`Id`)\nINNER JOIN `g_especialidad` ON (g_especialidad.`Id` = f_ordenesqx.`Id_Especialidad`)  \nINNER JOIN g_ips ON (f_empresacontxconvenio.Id_GIps = g_ips.Id)  \nINNER JOIN g_procedimiento ON (f_ordenesqx.`Id_Procedimiento` = g_procedimiento.Id)  \nINNER JOIN `q_procedtipomanqx`   ON (`q_procedtipomanqx`.`Id_Procedimiento` = `g_procedimiento`.`Id`) \nLEFT JOIN  `q_tipomanualqx`  ON (`q_procedtipomanqx`.`Id_TipoManualQx` = `q_tipomanualqx`.`Id`) \nLEFT JOIN  `f_manual`  ON (`f_manual`.`Id_TipoManQx` = `q_tipomanualqx`.`Id`)  AND (`f_empresacontxconvenio`.`Id_Manual` = `f_manual`.`Id`) \nINNER JOIN f_liquidacion ON (f_liquidacion.Id_Ingreso = ingreso.Id) \nINNER JOIN f_factura_evento ON (f_factura_evento.Id_Liquidacion = f_liquidacion.Id)   \nWHERE (g_pais.`Id`<>169 AND f_ordenesqx.`Valor`>0 AND f_ordenesqx.`EsCobrable`=1 \nAND `f_itemordenesqx`.`Id_TipoHonorario` =1 AND  g_procedimiento.Id_TipoProcRIPS =6 AND f_factura_evento.Estado =0 AND f_factura_evento.EstaArmada =2  \nAND ingreso.Estado =0 AND f_ordenes.Estado =0 AND f_factura_evento.Fecha_FacturaEvento >='" + this.xmt.formatoAMD.format(this.txtFechaIni.getDate()) + "' \nAND f_factura_evento.Fecha_FacturaEvento <='" + this.xmt.formatoAMD.format(this.txtFechaFin.getDate()) + "') GROUP BY f_ordenes.`Id`, f_ordenesqx.`Id_Procedimiento` ORDER BY IF(f_factura_evento.Prefijo='',f_factura_evento.No_FacturaEvento ,CONCAT(f_factura_evento.Prefijo,'',f_factura_evento.No_FacturaEvento)) ASC ";
            System.out.println(" Rips PROCEDIMIENTO QX : " + this.sql);
            ResultSet xrs12 = this.xct.traerRs(this.sql);
            if (xrs12.next()) {
                xrs12.beforeFirst();
                while (xrs12.next()) {
                    bw.write(xrs12.getString(1));
                    bw.newLine();
                    x++;
                }
                xdato = true;
            }
            xrs12.close();
            this.xct.cerrarConexionBd();
            this.sql = "SELECT CONCAT(IF(f_factura_evento.Prefijo='',f_factura_evento.No_FacturaEvento ,CONCAT(f_factura_evento.Prefijo,'',f_factura_evento.No_FacturaEvento)),',',g_ips.CodigoOrganismo,',',g_persona.Id_TipoIdentificacion,',',CONCAT(g_pais.`Codigo`, g_persona.NoDocumento),',', DATE_FORMAT(f_factura_capita.Fecha_FacturaCapita,'%d/%m/%Y') ,',',IF(f_ordenesqx.NAutorizacion='',ingreso.NoAutorizacion,f_ordenesqx.`NAutorizacion`),',',q_procedtipomanqx.`CodCups`,',', \ng_tipoatencion.Id_TipoAmbito,',',g_procedimiento.`Id_TipoFinProced`,',',g_especialidad.`Id_CRips`,',', f_ordenesqx.`DxP`,',',f_ordenesqx.`DxR`,',',f_ordenesqx.`DxC`,',', \nf_ordenesqx.`Id_Forma`,',',(`f_itemordenesqx`.`Valor`)) AS Linea  \nFROM g_usuario \nINNER JOIN g_persona ON (g_usuario.Id_persona = g_persona.Id) \nINNER JOIN `g_municipio` ON (g_municipio.`Id`= g_persona.`Id_MunicipioNac`)  \nINNER JOIN `g_departamento` ON (g_municipio.`Id_Dpto`= g_departamento.`Id`)  \nINNER JOIN `g_pais` ON (g_pais.`Id`= g_departamento.`CodPais`)  \nINNER JOIN ingreso ON (ingreso.Id_Usuario = g_usuario.Id_persona) \nINNER JOIN f_ordenes ON (f_ordenes.Id_Ingreso = ingreso.Id)  \nINNER JOIN f_empresacontxconvenio ON (ingreso.Id_EmpresaContxConv = f_empresacontxconvenio.Id)  \nINNER JOIN f_ordenesqx  ON (f_ordenes.Id = f_ordenesqx.Id_Orden)  \nINNER JOIN `f_itemordenesqx`  ON (`f_itemordenesqx`.`Id_OrdenQX` = `f_ordenesqx`.`Id`)\nINNER JOIN `g_procedimiento`  g_procedimiento1  ON (`f_itemordenesqx`.`Id_Procedimiento` = `g_procedimiento1`.`Id`)\nINNER JOIN `g_especialidad` ON (g_especialidad.`Id` = f_ordenesqx.`Id_Especialidad`)  \nINNER JOIN g_procedimiento ON (f_ordenesqx.`Id_Procedimiento` = g_procedimiento.Id)  \nINNER JOIN `q_procedtipomanqx`   ON (`q_procedtipomanqx`.`Id_Procedimiento` = `g_procedimiento`.`Id`) \nLEFT JOIN  `q_tipomanualqx`  ON (`q_procedtipomanqx`.`Id_TipoManualQx` = `q_tipomanualqx`.`Id`) \nLEFT JOIN  `f_manual`  ON (`f_manual`.`Id_TipoManQx` = `q_tipomanualqx`.`Id`)  AND (`f_empresacontxconvenio`.`Id_Manual` = `f_manual`.`Id`) \nINNER JOIN g_ips ON (f_empresacontxconvenio.Id_GIps = g_ips.Id)  \nINNER JOIN f_liquidacion ON (f_liquidacion.Id_Ingreso = ingreso.Id)  \nINNER JOIN f_factura_capita ON (f_factura_capita.Id_Liquidacion = f_liquidacion.Id) \nINNER JOIN f_factura_evento ON (f_factura_capita.No_FacturaEvento = f_factura_evento.No_FacturaEvento) \nINNER JOIN g_tipoatencion ON (ingreso.Id_TipoAtencion = g_tipoatencion.Id) \nWHERE (g_pais.`Id`<>169 AND f_ordenesqx.`Valor` >0 AND f_ordenesqx.`EsCobrable`=1 \nAND f_factura_evento.Estado =0 AND f_factura_evento.EstaArmada =2 AND ingreso.Estado =0  \nAND f_ordenes.Estado =0 AND f_factura_capita.EstaArmada =2 AND f_factura_capita.Estado =0 AND f_factura_capita.Fecha_FacturaCapita >='" + this.xmt.formatoAMD.format(this.txtFechaIni.getDate()) + "' \nAND `f_itemordenesqx`.`Id_TipoHonorario` =1 AND  f_factura_capita.Fecha_FacturaCapita <='" + this.xmt.formatoAMD.format(this.txtFechaFin.getDate()) + "' ) \nGROUP BY f_ordenes.`Id` ,f_ordenesqx.Id_Procedimiento ORDER BY f_factura_evento.No_FacturaEvento ASC, \nf_factura_capita.Fecha_FacturaCapita ASC, g_persona.Apellido1 ASC, g_persona.Apellido2 ASC, g_persona.Nombre1 ASC, g_persona.Nombre2 ASC ";
            System.out.println(" Rips PROCEDIMIENTO QX  paquetes: " + this.sql);
            ResultSet xrs13 = this.xct.traerRs(this.sql);
            if (xrs13.next()) {
                xrs13.beforeFirst();
                while (xrs13.next()) {
                    bw.write(xrs13.getString(1));
                    bw.newLine();
                    x++;
                }
                xdato = true;
            }
            xrs13.close();
            this.xct.cerrarConexionBd();
            this.sql = "SELECT CONCAT(IF(f_factura_evento.Prefijo='',f_factura_evento.No_FacturaEvento ,CONCAT(f_factura_evento.Prefijo,'',f_factura_evento.No_FacturaEvento)),',', g_ips.CodigoOrganismo,',', g_persona.Id_TipoIdentificacion,',', CONCAT(g_pais.`Codigo`, g_persona.NoDocumento),',',  DATE_FORMAT(f_factura_evento.Fecha_FacturaEvento,'%d/%m/%Y') ,',', IF(f_ordenesqx.NAutorizacion='',\ningreso.NoAutorizacion,f_ordenesqx.`NAutorizacion`),',',g_procedimiento.`C_Homologado`,',', g_tipoatencion.Id_TipoAmbito,',',g_procedimiento.`Id_TipoFinProced`,',',g_especialidad.`Id_CRips`,',', f_ordenesqx.`DxP`,',',f_ordenesqx.`DxR`,',',f_ordenesqx.`DxC`,',', f_ordenesqx.`Id_Forma`,',',(`f_ordenesqx`.`Valor`)) AS Linea  \nFROM `g_usuario`\nINNER JOIN  `g_persona` ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)\nINNER JOIN  `g_municipio` ON (g_municipio.`Id`= g_persona.`Id_MunicipioNac`)  \nINNER JOIN  `g_departamento` ON (g_municipio.`Id_Dpto`= g_departamento.`Id`)  \nINNER JOIN  `g_pais` ON (g_pais.`Id`= g_departamento.`CodPais`)  \nINNER JOIN  `ingreso` ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)\nINNER JOIN  `f_ordenes` ON (`f_ordenes`.`Id_Ingreso` = `ingreso`.`Id`)\nINNER JOIN  `f_empresacontxconvenio` ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)\nINNER JOIN  `g_tipoatencion` ON (`ingreso`.`Id_TipoAtencion` = `g_tipoatencion`.`Id`)\nINNER JOIN  `f_ordenesqx` ON (`f_ordenesqx`.`Id_Orden` = `f_ordenes`.`Id`)\nINNER JOIN  `g_especialidad` ON (`g_especialidad`.`Id` = `f_ordenesqx`.`Id_Especialidad`)\nINNER JOIN  `g_procedimiento` ON (`f_ordenesqx`.`Id_Procedimiento` = `g_procedimiento`.`Id`)\nINNER JOIN  `f_liquidacion` ON (`f_liquidacion`.`Id_Ingreso` = `ingreso`.`Id`)\nINNER JOIN  `f_factura_evento` ON (`f_factura_evento`.`Id_Liquidacion` = `f_liquidacion`.`Id`)\nINNER JOIN  `g_ips` ON (`f_empresacontxconvenio`.`Id_GIps` = `g_ips`.`Id`) \nWHERE (g_pais.`Id`<>169 AND f_ordenesqx.`Valor`>0 AND f_ordenesqx.`EsCobrable`=1 \nAND `f_ordenesqx`.`EsConjunto` =1 AND  g_procedimiento.Id_TipoProcRIPS =6 AND f_factura_evento.Estado =0 AND f_factura_evento.EstaArmada =2  \nAND ingreso.Estado =0 AND f_ordenes.Estado =0 AND f_factura_evento.Fecha_FacturaEvento >='" + this.xmt.formatoAMD.format(this.txtFechaIni.getDate()) + "' \nAND f_factura_evento.Fecha_FacturaEvento <='" + this.xmt.formatoAMD.format(this.txtFechaFin.getDate()) + "') GROUP BY f_ordenes.`Id`,f_ordenesqx.Id_Procedimiento ORDER BY IF(f_factura_evento.Prefijo='',f_factura_evento.No_FacturaEvento ,CONCAT(f_factura_evento.Prefijo,'',f_factura_evento.No_FacturaEvento)) ASC ";
            System.out.println(" Rips PROCEDIMIENTO QX  paquetes: " + this.sql);
            ResultSet xrs14 = this.xct.traerRs(this.sql);
            if (xrs14.next()) {
                xrs14.beforeFirst();
                while (xrs14.next()) {
                    bw.write(xrs14.getString(1));
                    bw.newLine();
                    x++;
                }
                xdato = true;
            }
            xrs14.close();
            this.xct.cerrarConexionBd();
            bw.close();
            if (xdato) {
                this.xvector.addElement("AP" + this.xmt.formatoMesAno1.format(this.txtFechaFin.getDate()) + "," + x);
            } else {
                this.xmt.mEliminarArchivo(new File(sFichero));
            }
        } catch (IOException ex) {
            Logger.getLogger(JIFGeneracionRips_Extranjeros.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        } catch (SQLException ex2) {
            Logger.getLogger(JIFGeneracionRips_Extranjeros.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex2);
        }
    }

    private void mCrearArchivo_AM_Capitado() {
        try {
            String sFichero = this.JTFRuta.getText() + this.xmt.getBarra() + "AM" + this.xmt.formatoMesAno1.format(this.txtFechaFin.getDate()) + ".txt";
            this.xmt.mEliminarArchivo(new File(sFichero));
            BufferedWriter bw = new BufferedWriter(new FileWriter(sFichero));
            boolean xdato = false;
            this.sql = "SELECT CONCAT(IF(f_factura_evento.Prefijo='',f_factura_evento.No_FacturaEvento ,CONCAT(f_factura_evento.Prefijo,'',f_factura_evento.No_FacturaEvento)),',', g_ips.CodigoOrganismo,',', g_persona.Id_TipoIdentificacion,',',CONCAT(g_pais.`Codigo`, g_persona.NoDocumento),',',  \ningreso.NoAutorizacion,',',IF(`f_empresacontxconvenio`.`TCodigoS`=0, `f_tarifasuministro`.`Codigo`,IF(`f_empresacontxconvenio`.`TCodigoS`=1,`i_suministro`.`CodigoAtc`,`i_suministro`.`CodigoCUM`)),',',i_suministro.Pos,',',LEFT(IF(i_principioactivo.Nbre='NO APLICA',i_suministro.Nbre, i_principioactivo.Nbre),30),',',LEFT(IF(i_presentacionfarmaceutica.Nbre='NO APLICA','',i_presentacionfarmaceutica.Nbre),20),',',LEFT(IF(i_concentracion.Nbre='','',i_concentracion.Nbre),20),',',LEFT(IF(i_unidadmedida.Nbre='','',i_unidadmedida.Nbre) ,20),',',SUM(f_itemordenessum.Cantidad),',',f_itemordenessum.ValorUnit,',',(((SUM(f_itemordenessum.Cantidad))*f_itemordenessum.ValorUnit)+f_itemordenessum.valorImpuesto))AS Linea \nFROM  g_usuario \nINNER JOIN g_persona ON (g_usuario.Id_persona = g_persona.Id) \nINNER JOIN `g_municipio` ON (g_municipio.`Id`= g_persona.`Id_MunicipioNac`)  \nINNER JOIN `g_departamento` ON (g_municipio.`Id_Dpto`= g_departamento.`Id`)  \nINNER JOIN `g_pais` ON (g_pais.`Id`= g_departamento.`CodPais`)  \nINNER JOIN ingreso ON (ingreso.Id_Usuario = g_usuario.Id_persona) \nINNER JOIN f_ordenes ON (f_ordenes.Id_Ingreso = ingreso.Id) \nINNER JOIN f_empresacontxconvenio ON (ingreso.Id_EmpresaContxConv = f_empresacontxconvenio.Id) \nINNER JOIN g_ips ON (f_empresacontxconvenio.Id_GIps = g_ips.Id)  \nINNER JOIN f_itemordenessum ON (f_itemordenessum.Id_Ordenes = f_ordenes.Id) \nINNER JOIN i_suministro ON (f_itemordenessum.Id_Suministro = i_suministro.Id) \nINNER JOIN i_principioactivo ON (i_suministro.IdPrincipioActivo = i_principioactivo.Id) \nINNER JOIN i_unidadmedida ON (i_suministro.IdUnidadMedida = i_unidadmedida.Id) \nINNER JOIN i_concentracion ON (i_suministro.IdConcentracion = i_concentracion.Id) \nINNER JOIN i_presentacionfarmaceutica ON (i_suministro.IdPresentacionFarmaceutica = i_presentacionfarmaceutica.Id) \nINNER JOIN f_liquidacion ON (f_liquidacion.Id_Ingreso = ingreso.Id) \nINNER JOIN f_factura_capita ON (f_factura_capita.Id_Liquidacion = f_liquidacion.Id) \nINNER JOIN f_factura_evento ON (f_factura_capita.No_FacturaEvento = f_factura_evento.No_FacturaEvento)  \nINNER JOIN f_tarifasuministro ON (f_tarifasuministro.Id_suministro = i_suministro.Id) AND (f_tarifasuministro.Id_manual = f_empresacontxconvenio.Id_Manual) \nWHERE (g_pais.`Id`<>169 AND i_suministro.EsMaterial =0 AND f_factura_capita.Fecha_FacturaCapita >='" + this.xmt.formatoAMD.format(this.txtFechaIni.getDate()) + "' AND f_factura_capita.Fecha_FacturaCapita <='" + this.xmt.formatoAMD.format(this.txtFechaFin.getDate()) + "' AND f_factura_capita.Estado =0  AND f_factura_capita.EstaArmada =2 AND f_factura_evento.Estado =0 \nAND f_factura_evento.EstaArmada =2 AND f_liquidacion.Estado =0 AND f_ordenes.Estado =0  AND ingreso.Estado =0 \nAND f_itemordenessum.EsCobrable=1 ) GROUP BY g_persona.NoDocumento, i_suministro.Id, f_itemordenessum.ValorUnit ORDER BY f_factura_evento.No_FacturaEvento ASC, f_factura_capita.Fecha_FacturaCapita ASC, g_persona.Apellido1 ASC, g_persona.Apellido2 ASC, g_persona.Nombre1 ASC, g_persona.Nombre2 ASC";
            System.out.println(" Rips Medicamentos : " + this.sql);
            ResultSet xrs = this.xct.traerRs(this.sql);
            int x = 0;
            if (xrs.next()) {
                xrs.beforeFirst();
                while (xrs.next()) {
                    bw.write(xrs.getString(1));
                    bw.newLine();
                    x++;
                }
                xdato = true;
            }
            xrs.close();
            this.xct.cerrarConexionBd();
            this.sql = "SELECT CONCAT(IF(f_factura_evento.Prefijo='',f_factura_evento.No_FacturaEvento ,CONCAT(f_factura_evento.Prefijo,'',f_factura_evento.No_FacturaEvento)),',', g_ips.CodigoOrganismo,',', g_persona.Id_TipoIdentificacion,',',CONCAT(g_pais.`Codigo`, g_persona.NoDocumento),',',  \ningreso.NoAutorizacion,',',IF(`f_empresacontxconvenio`.`TCodigoS`=0, `f_tarifasuministro`.`Codigo`,IF(`f_empresacontxconvenio`.`TCodigoS`=1,`i_suministro`.`CodigoAtc`,`i_suministro`.`CodigoCUM`)),',',i_suministro.Pos,',',LEFT(IF(i_principioactivo.Nbre='NO APLICA',i_suministro.Nbre, i_principioactivo.Nbre),30),',',LEFT(IF(i_presentacionfarmaceutica.Nbre='NO APLICA','',i_presentacionfarmaceutica.Nbre),20),',',LEFT(IF(i_concentracion.Nbre='','',i_concentracion.Nbre),20),',',LEFT(IF(i_unidadmedida.Nbre='','',i_unidadmedida.Nbre) ,20),',',SUM(f_itemordenessum.Cantidad),',',f_itemordenessum.ValorUnit,',',(((SUM(f_itemordenessum.Cantidad))*f_itemordenessum.ValorUnit)+f_itemordenessum.valorImpuesto) )AS Linea \n FROM  g_usuario \nINNER JOIN g_persona ON (g_usuario.Id_persona = g_persona.Id) \nINNER JOIN `g_municipio` ON (g_municipio.`Id`= g_persona.`Id_MunicipioNac`)  \nINNER JOIN `g_departamento` ON (g_municipio.`Id_Dpto`= g_departamento.`Id`)  \nINNER JOIN `g_pais` ON (g_pais.`Id`= g_departamento.`CodPais`)  \nINNER JOIN ingreso ON (ingreso.Id_Usuario = g_usuario.Id_persona) \nINNER JOIN f_ordenes ON (f_ordenes.Id_Ingreso = ingreso.Id) \nINNER JOIN f_empresacontxconvenio ON (ingreso.Id_EmpresaContxConv = f_empresacontxconvenio.Id) \nINNER JOIN g_ips ON (f_empresacontxconvenio.Id_GIps = g_ips.Id)  \nINNER JOIN f_itemordenessum ON (f_itemordenessum.Id_Ordenes = f_ordenes.Id) \nINNER JOIN i_suministro ON (f_itemordenessum.Id_Suministro = i_suministro.Id) \nINNER JOIN i_unidadmedida ON (i_suministro.IdUnidadMedida = i_unidadmedida.Id) \nINNER JOIN i_principioactivo ON (i_suministro.IdPrincipioActivo = i_principioactivo.Id) \nINNER JOIN i_concentracion ON (i_suministro.IdConcentracion = i_concentracion.Id) \nINNER JOIN i_presentacionfarmaceutica ON (i_suministro.IdPresentacionFarmaceutica = i_presentacionfarmaceutica.Id) \nINNER JOIN i_formafarmaceutica ON (i_presentacionfarmaceutica.IdFormaFarmaceutica = i_formafarmaceutica.Id) \nINNER JOIN f_tarifasuministro ON (f_tarifasuministro.Id_suministro = i_suministro.Id) AND (f_tarifasuministro.Id_manual = f_empresacontxconvenio.Id_Manual) \nINNER JOIN f_liquidacion ON (f_liquidacion.Id_Ingreso = ingreso.Id) \nINNER JOIN f_factura_evento ON (f_factura_evento.Id_Liquidacion = f_liquidacion.Id) \nWHERE (g_pais.`Id`<>169 AND i_suministro.EsMaterial =0 \nAND f_factura_evento.Fecha_FacturaEvento >='" + this.xmt.formatoAMD.format(this.txtFechaIni.getDate()) + "' AND f_factura_evento.Fecha_FacturaEvento <='" + this.xmt.formatoAMD.format(this.txtFechaFin.getDate()) + "' AND f_factura_evento.Estado =0 AND f_factura_evento.EstaArmada =2 AND f_liquidacion.Estado =0 AND f_ordenes.Estado =0 \nAND f_itemordenessum.EsCobrable=1  AND ingreso.Estado =0 ) GROUP BY f_factura_evento.No_FacturaEvento, i_suministro.Id, f_itemordenessum.ValorUnit ORDER BY f_factura_evento.No_FacturaEvento ";
            System.out.println(" Rips Medicamentos : " + this.sql);
            ResultSet xrs2 = this.xct.traerRs(this.sql);
            if (xrs2.next()) {
                xrs2.beforeFirst();
                while (xrs2.next()) {
                    bw.write(xrs2.getString(1));
                    bw.newLine();
                    x++;
                }
                xdato = true;
            }
            xrs2.close();
            this.xct.cerrarConexionBd();
            bw.close();
            if (xdato) {
                this.xvector.addElement("AM" + this.xmt.formatoMesAno1.format(this.txtFechaFin.getDate()) + "," + x);
            } else {
                this.xmt.mEliminarArchivo(new File(sFichero));
            }
        } catch (IOException ex) {
            Logger.getLogger(JIFGeneracionRips_Extranjeros.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        } catch (SQLException ex2) {
            Logger.getLogger(JIFGeneracionRips_Extranjeros.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex2);
        }
    }

    private void mCrearArchivo_AT_Capitado() {
        try {
            String sFichero = this.JTFRuta.getText() + this.xmt.getBarra() + "AT" + this.xmt.formatoMesAno1.format(this.txtFechaFin.getDate()) + ".txt";
            this.xmt.mEliminarArchivo(new File(sFichero));
            BufferedWriter bw = new BufferedWriter(new FileWriter(sFichero));
            this.sql = "SELECT CONCAT(IF(f_factura_evento.Prefijo='',f_factura_evento.No_FacturaEvento ,CONCAT(f_factura_evento.Prefijo,'',f_factura_evento.No_FacturaEvento)),',', g_ips.CodigoOrganismo,',',g_persona.Id_TipoIdentificacion,',',CONCAT(g_pais.`Codigo`, g_persona.NoDocumento),',',\ningreso.NoAutorizacion,',',g_procedimiento.Id_TipoProcRIPS,',', IF(`f_empresacontxconvenio`.`TCodigo`=0, f_tarifaprocedimiento.CodCUPS ,IF(`f_empresacontxconvenio`.`TCodigo`=1,g_procedimiento.`C_Real`,g_procedimiento.`C_Homologado`)),',',SUBSTRING(g_procedimiento.Nbre,1,50),',',f_itemordenesproced.Cantidad,',',f_itemordenesproced.ValorUnitario,',',\n((f_itemordenesproced.Cantidad*f_itemordenesproced.ValorUnitario)+f_itemordenesproced.valorImpuesto)) AS Linea \nFROM g_ips, g_usuario \nINNER JOIN g_persona ON (g_usuario.Id_persona = g_persona.Id) \nINNER JOIN `g_municipio` ON (g_municipio.`Id`= g_persona.`Id_MunicipioNac`)  \nINNER JOIN `g_departamento` ON (g_municipio.`Id_Dpto`= g_departamento.`Id`)  \nINNER JOIN `g_pais` ON (g_pais.`Id`= g_departamento.`CodPais`)  \nINNER JOIN ingreso ON (ingreso.Id_Usuario = g_usuario.Id_persona) \nINNER JOIN f_ordenes ON (f_ordenes.Id_Ingreso = ingreso.Id) \nINNER JOIN f_empresacontxconvenio ON (ingreso.Id_EmpresaContxConv = f_empresacontxconvenio.Id) \nINNER JOIN g_tipoatencion ON (ingreso.Id_TipoAtencion = g_tipoatencion.Id) \nINNER JOIN f_itemordenesproced ON (f_itemordenesproced.Id_Ordenes = f_ordenes.Id) \nINNER JOIN g_procedimiento ON (f_itemordenesproced.Id_Procedimiento = g_procedimiento.Id) \nINNER JOIN f_liquidacion ON (f_liquidacion.Id_Ingreso = ingreso.Id)  \nINNER JOIN f_tarifaprocedimiento ON (f_empresacontxconvenio.Id_Manual = f_tarifaprocedimiento.Id_Manual) AND (f_tarifaprocedimiento.Id_Procedimiento = g_procedimiento.Id) \nINNER JOIN f_factura_capita ON (f_factura_capita.Id_Liquidacion = f_liquidacion.Id) \nINNER JOIN f_factura_evento ON (f_factura_capita.No_FacturaEvento = f_factura_evento.No_FacturaEvento) \nWHERE (g_pais.`Id`<>169 AND f_itemordenesproced.ValorUnitario >0 AND g_procedimiento.Id_TipoProcRIPS IN(1,2,3,4)  AND f_itemordenesproced.EsCobrable=1 AND f_factura_evento.Estado =0 AND f_factura_evento.EstaArmada =2 \nAND ingreso.Estado =0 AND f_ordenes.Estado =0 AND f_factura_capita.Fecha_FacturaCapita >='" + this.xmt.formatoAMD.format(this.txtFechaIni.getDate()) + "' AND f_factura_capita.Fecha_FacturaCapita <='" + this.xmt.formatoAMD.format(this.txtFechaFin.getDate()) + "' AND f_factura_capita.Estado =0 AND f_factura_capita.EstaArmada =2) ORDER BY f_factura_evento.No_FacturaEvento ASC, f_factura_capita.Fecha_FacturaCapita ASC, g_persona.Apellido1 ASC, g_persona.Apellido2 ASC, g_persona.Nombre1 ASC, g_persona.Nombre2 ASC";
            System.out.println("AT : " + this.sql);
            ResultSet xrs = this.xct.traerRs(this.sql);
            int x = 0;
            if (xrs.next()) {
                xrs.beforeFirst();
                while (xrs.next()) {
                    bw.write(xrs.getString(1));
                    bw.newLine();
                    x++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
            this.sql = "SELECT concat(IF(f_factura_evento.Prefijo='',f_factura_evento.No_FacturaEvento ,CONCAT(f_factura_evento.Prefijo,'',f_factura_evento.No_FacturaEvento)),',', g_ips.CodigoOrganismo,',',g_persona.Id_TipoIdentificacion,',',CONCAT(g_pais.`Codigo`, g_persona.NoDocumento),',',\ningreso.NoAutorizacion,',',g_procedimiento.Id_TipoProcRIPS,',',IF(`f_empresacontxconvenio`.`TCodigo`=0, f_tarifaprocedimiento.CodCUPS ,IF(`f_empresacontxconvenio`.`TCodigo`=1,g_procedimiento.`C_Real`,g_procedimiento.`C_Homologado`)),',',SUBSTRING(g_procedimiento.Nbre,1,50),',', \nf_itemordenesproced.Cantidad,',',f_itemordenesproced.ValorUnitario,',', ((f_itemordenesproced.Cantidad*f_itemordenesproced.ValorUnitario)+f_itemordenesproced.valorImpuesto) )\nAS Linea FROM g_ips, g_usuario \nINNER JOIN g_persona ON (g_usuario.Id_persona = g_persona.Id) \nINNER JOIN `g_municipio` ON (g_municipio.`Id`= g_persona.`Id_MunicipioNac`)  \nINNER JOIN `g_departamento` ON (g_municipio.`Id_Dpto`= g_departamento.`Id`)  \nINNER JOIN `g_pais` ON (g_pais.`Id`= g_departamento.`CodPais`)  \nINNER JOIN ingreso ON (ingreso.Id_Usuario = g_usuario.Id_persona) \nINNER JOIN f_ordenes ON (f_ordenes.Id_Ingreso = ingreso.Id) \nINNER JOIN f_empresacontxconvenio ON (ingreso.Id_EmpresaContxConv = f_empresacontxconvenio.Id) \nINNER JOIN g_tipoatencion ON (ingreso.Id_TipoAtencion = g_tipoatencion.Id) \nINNER JOIN f_itemordenesproced ON (f_itemordenesproced.Id_Ordenes = f_ordenes.Id) \nINNER JOIN g_procedimiento ON (f_itemordenesproced.Id_Procedimiento = g_procedimiento.Id) \nINNER JOIN f_liquidacion ON (f_liquidacion.Id_Ingreso = ingreso.Id) \nINNER JOIN f_factura_evento ON (f_factura_evento.Id_Liquidacion = f_liquidacion.Id) \nINNER JOIN f_tarifaprocedimiento ON (f_empresacontxconvenio.Id_Manual = f_tarifaprocedimiento.Id_Manual) AND (f_tarifaprocedimiento.Id_Procedimiento = g_procedimiento.Id) \nWHERE (g_pais.`Id`<>169 AND f_itemordenesproced.ValorUnitario >0 AND g_procedimiento.Id_TipoProcRIPS IN(1,2,3,4) AND f_factura_evento.Estado =0 AND f_factura_evento.EstaArmada =2 \nAND ingreso.Estado =0 AND f_ordenes.Estado =0 AND f_itemordenesproced.EsCobrable=1 AND f_factura_evento.Fecha_FacturaEvento >='" + this.xmt.formatoAMD.format(this.txtFechaIni.getDate()) + "' AND f_factura_evento.Fecha_FacturaEvento <='" + this.xmt.formatoAMD.format(this.txtFechaFin.getDate()) + "')";
            System.out.println("AT : " + this.sql);
            ResultSet xrs2 = this.xct.traerRs(this.sql);
            boolean xdato = false;
            if (xrs2.next()) {
                xrs2.beforeFirst();
                while (xrs2.next()) {
                    bw.write(xrs2.getString(1));
                    bw.newLine();
                    x++;
                }
                xdato = true;
            }
            xrs2.close();
            this.xct.cerrarConexionBd();
            this.sql = "SELECT CONCAT(IF(f_factura_evento.Prefijo='',f_factura_evento.No_FacturaEvento ,CONCAT(f_factura_evento.Prefijo,'',f_factura_evento.No_FacturaEvento)),',',g_ips.CodigoOrganismo,',',g_persona.Id_TipoIdentificacion,',', CONCAT(g_pais.`Codigo`, g_persona.NoDocumento),',',\ningreso.NoAutorizacion,',', '1',',', '' ,',', i_suministro.Nbre,',', f_itemordenessum.Cantidad,',', \nf_itemordenessum.ValorUnit,',',((f_itemordenessum.Cantidad*f_itemordenessum.ValorUnit)+f_itemordenessum.valorImpuesto)) AS Linea \nFROM  g_usuario \nINNER JOIN g_persona ON (g_usuario.Id_persona = g_persona.Id) \nINNER JOIN `g_municipio` ON (g_municipio.`Id`= g_persona.`Id_MunicipioNac`)  \nINNER JOIN `g_departamento` ON (g_municipio.`Id_Dpto`= g_departamento.`Id`)  \nINNER JOIN `g_pais` ON (g_pais.`Id`= g_departamento.`CodPais`)  \nINNER JOIN ingreso ON (ingreso.Id_Usuario = g_usuario.Id_persona) \nINNER JOIN f_ordenes ON (f_ordenes.Id_Ingreso = ingreso.Id) \nINNER JOIN f_empresacontxconvenio ON (ingreso.Id_EmpresaContxConv = f_empresacontxconvenio.Id) \nINNER JOIN g_ips ON (f_empresacontxconvenio.Id_GIps = g_ips.Id)  \nINNER JOIN f_itemordenessum ON (f_itemordenessum.Id_Ordenes = f_ordenes.Id) \nINNER JOIN i_suministro ON (f_itemordenessum.Id_Suministro = i_suministro.Id) \nINNER JOIN i_principioactivo ON (i_suministro.IdPrincipioActivo = i_principioactivo.Id) \nINNER JOIN i_unidadmedida ON (i_suministro.IdUnidadMedida = i_unidadmedida.Id) \nINNER JOIN i_concentracion ON (i_suministro.IdConcentracion = i_concentracion.Id) \nINNER JOIN i_presentacionfarmaceutica ON (i_suministro.IdPresentacionFarmaceutica = i_presentacionfarmaceutica.Id) \nINNER JOIN f_liquidacion ON (f_liquidacion.Id_Ingreso = ingreso.Id) \nINNER JOIN f_factura_capita ON (f_factura_capita.Id_Liquidacion = f_liquidacion.Id) \nINNER JOIN f_factura_evento ON (f_factura_capita.No_FacturaEvento = f_factura_evento.No_FacturaEvento)  \nINNER JOIN f_tarifasuministro ON (f_tarifasuministro.Id_suministro = i_suministro.Id) AND (f_tarifasuministro.Id_manual = f_empresacontxconvenio.Id_Manual) \nWHERE (g_pais.`Id`<>169 AND i_suministro.EsMaterial =1 AND f_factura_capita.Fecha_FacturaCapita >='" + this.xmt.formatoAMD.format(this.txtFechaIni.getDate()) + "' AND f_factura_capita.Fecha_FacturaCapita <='" + this.xmt.formatoAMD.format(this.txtFechaFin.getDate()) + "' AND f_factura_capita.Estado =0 AND f_factura_capita.EstaArmada =2 AND f_factura_evento.Estado =0 \nAND f_factura_evento.EstaArmada =2  AND f_liquidacion.Estado =0 AND f_ordenes.Estado =0 AND ingreso.Estado =0 AND f_itemordenessum.EsCobrable=1 ) ORDER BY f_factura_evento.No_FacturaEvento ASC, f_factura_capita.Fecha_FacturaCapita ASC, g_persona.Apellido1 ASC, g_persona.Apellido2 ASC, g_persona.Nombre1 ASC, g_persona.Nombre2 ASC";
            System.out.println("AT Med: " + this.sql);
            ResultSet xrs3 = this.xct.traerRs(this.sql);
            if (xrs3.next()) {
                xrs3.beforeFirst();
                while (xrs3.next()) {
                    bw.write(xrs3.getString(1));
                    bw.newLine();
                    x++;
                }
                xdato = true;
            }
            xrs3.close();
            this.xct.cerrarConexionBd();
            this.sql = "SELECT  CONCAT(IF(f_factura_evento.Prefijo='',f_factura_evento.No_FacturaEvento ,CONCAT(f_factura_evento.Prefijo,'',f_factura_evento.No_FacturaEvento)),',', g_ips.CodigoOrganismo,',',g_persona.Id_TipoIdentificacion,',',CONCAT(g_pais.`Codigo`, g_persona.NoDocumento),',',\ningreso.NoAutorizacion,',', '1',',', '',',',i_suministro.Nbre,',',f_itemordenessum.Cantidad,',',f_itemordenessum.ValorUnit,',', \n((f_itemordenessum.Cantidad*f_itemordenessum.ValorUnit)+f_itemordenessum.valorImpuesto)) AS Linea \nFROM  g_usuario \nINNER JOIN g_persona ON (g_usuario.Id_persona = g_persona.Id) \nINNER JOIN `g_municipio` ON (g_municipio.`Id`= g_persona.`Id_MunicipioNac`)  \nINNER JOIN `g_departamento` ON (g_municipio.`Id_Dpto`= g_departamento.`Id`)  \nINNER JOIN `g_pais` ON (g_pais.`Id`= g_departamento.`CodPais`)  \nINNER JOIN ingreso ON (ingreso.Id_Usuario = g_usuario.Id_persona) \nINNER JOIN f_ordenes ON (f_ordenes.Id_Ingreso = ingreso.Id) \nINNER JOIN f_empresacontxconvenio ON (ingreso.Id_EmpresaContxConv = f_empresacontxconvenio.Id) \nINNER JOIN g_ips ON (f_empresacontxconvenio.Id_GIps = g_ips.Id)  \nINNER JOIN f_itemordenessum ON (f_itemordenessum.Id_Ordenes = f_ordenes.Id) \nINNER JOIN i_suministro ON (f_itemordenessum.Id_Suministro = i_suministro.Id)  \nINNER JOIN i_principioactivo ON (i_suministro.IdPrincipioActivo = i_principioactivo.Id) \nINNER JOIN i_unidadmedida ON (i_suministro.IdUnidadMedida = i_unidadmedida.Id) \nINNER JOIN i_concentracion ON (i_suministro.IdConcentracion = i_concentracion.Id) \nINNER JOIN i_presentacionfarmaceutica ON (i_suministro.IdPresentacionFarmaceutica = i_presentacionfarmaceutica.Id) \nINNER JOIN f_liquidacion ON (f_liquidacion.Id_Ingreso = ingreso.Id) \nINNER JOIN f_factura_evento ON (f_factura_evento.Id_Liquidacion = f_liquidacion.Id) \nINNER JOIN f_tarifasuministro ON (f_tarifasuministro.Id_suministro = i_suministro.Id) AND (f_tarifasuministro.Id_manual = f_empresacontxconvenio.Id_Manual) \nWHERE (g_pais.`Id`<>169 AND i_suministro.EsMaterial =1 AND f_factura_evento.Estado =0 AND f_factura_evento.EstaArmada =2 AND f_liquidacion.Estado =0 \nAND f_ordenes.Estado =0 AND ingreso.Estado =0 AND f_factura_evento.Fecha_FacturaEvento >='" + this.xmt.formatoAMD.format(this.txtFechaIni.getDate()) + "' AND f_itemordenessum.EsCobrable=1  AND f_factura_evento.Fecha_FacturaEvento <='" + this.xmt.formatoAMD.format(this.txtFechaFin.getDate()) + "')";
            System.out.println("AT Med: " + this.sql);
            ResultSet xrs4 = this.xct.traerRs(this.sql);
            if (xrs4.next()) {
                xrs4.beforeFirst();
                while (xrs4.next()) {
                    bw.write(xrs4.getString(1));
                    bw.newLine();
                    x++;
                }
                xdato = true;
            }
            xrs4.close();
            this.xct.cerrarConexionBd();
            this.xsql = "SELECT CONCAT(IF(f_factura_evento.Prefijo='',f_factura_evento.No_FacturaEvento ,CONCAT(f_factura_evento.Prefijo,'',f_factura_evento.No_FacturaEvento)),',', g_ips.CodigoOrganismo,',',g_persona.Id_TipoIdentificacion,',',CONCAT(g_pais.`Codigo`, g_persona.NoDocumento),',',ingreso.NoAutorizacion,',',g_procedimiento.Id_TipoProcRIPS,',',IF(`f_empresacontxconvenio`.`TCodigo`=0, f_tarifaprocedimiento.CodCUPS ,IF(`f_empresacontxconvenio`.`TCodigo`=1,g_procedimiento.`C_Real`,g_procedimiento.`C_Homologado`)),',',IF(LENGTH(g_procedimiento.Nbre)<=50, g_procedimiento.Nbre,MID(g_procedimiento.Nbre,1,50)),',', 1,',',f_itemordenesqx.`Valor`,',', f_itemordenesqx.`Valor` )AS Linea \nFROM g_ips, g_usuario \nINNER JOIN g_persona ON (g_usuario.Id_persona = g_persona.Id) \nINNER JOIN `g_municipio` ON (g_municipio.`Id`= g_persona.`Id_MunicipioNac`)  \nINNER JOIN `g_departamento` ON (g_municipio.`Id_Dpto`= g_departamento.`Id`)  \nINNER JOIN `g_pais` ON (g_pais.`Id`= g_departamento.`CodPais`)  \nINNER JOIN ingreso ON (ingreso.Id_Usuario = g_usuario.Id_persona) \nINNER JOIN f_ordenes ON (f_ordenes.Id_Ingreso = ingreso.Id) \nINNER JOIN `f_ordenesqx` ON (f_ordenes.`Id`= f_ordenesqx.`Id_Orden`) \nINNER JOIN `f_itemordenesqx` ON (f_itemordenesqx.`Id_OrdenQX`= f_ordenesqx.`Id`) \nINNER JOIN g_procedimiento ON (f_itemordenesqx.Id_Procedimiento = g_procedimiento.Id) \nINNER JOIN f_empresacontxconvenio ON (ingreso.Id_EmpresaContxConv = f_empresacontxconvenio.Id) \nINNER JOIN g_tipoatencion ON (ingreso.Id_TipoAtencion = g_tipoatencion.Id)  \nINNER JOIN f_liquidacion ON (f_liquidacion.Id_Ingreso = ingreso.Id) \nINNER JOIN f_factura_capita ON (f_factura_capita.Id_Liquidacion = f_liquidacion.Id) \nINNER JOIN f_factura_evento ON (f_factura_capita.No_FacturaEvento = f_factura_evento.No_FacturaEvento) \nINNER JOIN f_tarifaprocedimiento ON (f_empresacontxconvenio.Id_Manual = f_tarifaprocedimiento.Id_Manual) \nAND (f_tarifaprocedimiento.Id_Procedimiento = g_procedimiento.Id) \nWHERE (g_pais.`Id`<>169 AND `f_itemordenesqx`.`Id_TipoHonorario` <>1 AND f_factura_evento.Estado =0 AND f_factura_evento.EstaArmada =2 AND ingreso.Estado =0 AND f_ordenes.Estado =0 \nAND f_factura_evento.Fecha_FacturaEvento >='" + this.xmt.formatoAMD.format(this.txtFechaIni.getDate()) + "' AND f_factura_evento.Fecha_FacturaEvento <='" + this.xmt.formatoAMD.format(this.txtFechaFin.getDate()) + "')\nORDER BY f_factura_evento.No_FacturaEvento";
            System.out.println("AT qx: " + this.xsql);
            ResultSet xrs5 = this.xct.traerRs(this.xsql);
            if (xrs5.next()) {
                xrs5.beforeFirst();
                while (xrs5.next()) {
                    bw.write(xrs5.getString(1));
                    bw.newLine();
                    x++;
                }
                xdato = true;
            }
            xrs5.close();
            this.xct.cerrarConexionBd();
            this.xsql = "SELECT CONCAT(IF(f_factura_evento.Prefijo='',f_factura_evento.No_FacturaEvento ,CONCAT(f_factura_evento.Prefijo,'',f_factura_evento.No_FacturaEvento)),',', g_ips.CodigoOrganismo,',',g_persona.Id_TipoIdentificacion,',',CONCAT(g_pais.`Codigo`, g_persona.NoDocumento),',',ingreso.NoAutorizacion,',',g_procedimiento.Id_TipoProcRIPS,',',IF(`f_empresacontxconvenio`.`TCodigo`=0, f_tarifaprocedimiento.CodCUPS ,IF(`f_empresacontxconvenio`.`TCodigo`=1,g_procedimiento.`C_Real`,g_procedimiento.`C_Homologado`)),',',IF(LENGTH(g_procedimiento.Nbre)<=50, g_procedimiento.Nbre,MID(g_procedimiento.Nbre,1,50)),',', 1,',',f_itemordenesqx.`Valor`,',', f_itemordenesqx.`Valor` )AS Linea \nFROM g_ips, g_usuario \nINNER JOIN g_persona ON (g_usuario.Id_persona = g_persona.Id) \nINNER JOIN `g_municipio` ON (g_municipio.`Id`= g_persona.`Id_MunicipioNac`)  \nINNER JOIN `g_departamento` ON (g_municipio.`Id_Dpto`= g_departamento.`Id`)  \nINNER JOIN `g_pais` ON (g_pais.`Id`= g_departamento.`CodPais`)  \nINNER JOIN ingreso ON (ingreso.Id_Usuario = g_usuario.Id_persona) \nINNER JOIN f_ordenes ON (f_ordenes.Id_Ingreso = ingreso.Id) \nINNER JOIN `f_ordenesqx` ON (f_ordenes.`Id`= f_ordenesqx.`Id_Orden`) \nINNER JOIN `f_itemordenesqx` ON (f_itemordenesqx.`Id_OrdenQX`= f_ordenesqx.`Id`) \nINNER JOIN g_procedimiento ON (f_itemordenesqx.Id_Procedimiento = g_procedimiento.Id) \nINNER JOIN f_empresacontxconvenio ON (ingreso.Id_EmpresaContxConv = f_empresacontxconvenio.Id) \nINNER JOIN g_tipoatencion ON (ingreso.Id_TipoAtencion = g_tipoatencion.Id)  \nINNER JOIN f_liquidacion ON (f_liquidacion.Id_Ingreso = ingreso.Id) \nINNER JOIN f_factura_evento ON (f_factura_evento.Id_Liquidacion = f_liquidacion.Id) \nINNER JOIN f_tarifaprocedimiento ON (f_empresacontxconvenio.Id_Manual = f_tarifaprocedimiento.Id_Manual) \nAND (f_tarifaprocedimiento.Id_Procedimiento = g_procedimiento.Id) \nWHERE (g_pais.`Id`<>169 AND `f_itemordenesqx`.`Id_TipoHonorario` <>1 AND f_factura_evento.Estado =0 AND f_factura_evento.EstaArmada =2 AND ingreso.Estado =0 AND f_ordenes.Estado =0 \nAND f_factura_evento.Fecha_FacturaEvento >='" + this.xmt.formatoAMD.format(this.txtFechaIni.getDate()) + "' AND f_factura_evento.Fecha_FacturaEvento <='" + this.xmt.formatoAMD.format(this.txtFechaFin.getDate()) + "')\nORDER BY f_factura_evento.No_FacturaEvento";
            System.out.println("AT qx: " + this.xsql);
            ResultSet xrs6 = this.xct.traerRs(this.xsql);
            if (xrs6.next()) {
                xrs6.beforeFirst();
                while (xrs6.next()) {
                    bw.write(xrs6.getString(1));
                    bw.newLine();
                    x++;
                }
                xdato = true;
            }
            xrs6.close();
            this.xct.cerrarConexionBd();
            bw.close();
            if (xdato) {
                this.xvector.addElement("AT" + this.xmt.formatoMesAno1.format(this.txtFechaFin.getDate()) + "," + x);
            } else {
                this.xmt.mEliminarArchivo(new File(sFichero));
            }
        } catch (IOException ex) {
            Logger.getLogger(JIFGeneracionRips_Extranjeros.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        } catch (SQLException ex2) {
            Logger.getLogger(JIFGeneracionRips_Extranjeros.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex2);
        }
    }
}
