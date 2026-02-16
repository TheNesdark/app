package Contabilidad;

import Acceso.Principal;
import Utilidades.ConsultasSqlServer;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.IndexedColors;

/* JADX INFO: loaded from: GenomaP.jar:Contabilidad/JD_FacturacionBienEstar.class */
public class JD_FacturacionBienEstar extends JDialog {
    private DefaultTableModel xmodelo;
    private DefaultTableModel xmodelo2;
    private Object[] xdato;
    private Object[] xdato2;
    private Metodos xmt;
    private ConsultasSqlServer consultasSQLs;
    private String NIT;
    private int x;
    private JDateChooser FFINAL;
    private JDateChooser FINICIALL;
    private JButton JBBuscarDoc;
    private JButton JBTExportar;
    private JTextField JTFRuta;
    private JButton jButton1;
    private JButton jButton2;
    private JButton jButton3;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane3;
    private JTextField jTNameEmpresa;
    private JTabbedPane jTabbedPane1;
    private JTable jTableProcedimientos;
    private JTable jTableTotalizado;

    public JD_FacturacionBienEstar(Frame parent, boolean modal, String nitEmpresa, String nameEmpresa) {
        super(parent, modal);
        this.xmt = new Metodos();
        this.consultasSQLs = new ConsultasSqlServer();
        this.NIT = "";
        this.x = 0;
        initComponents();
        this.NIT = nitEmpresa;
        this.jTNameEmpresa.setText(nameEmpresa);
    }

    private void crearTablatotalizado() {
        this.xmodelo2 = new DefaultTableModel((Object[][]) null, new String[]{"Procedimiento", "Costo", "Cantidad", "CodGenoma"}) { // from class: Contabilidad.JD_FacturacionBienEstar.1
            Class[] types = {String.class, Double.class, Integer.class, String.class};
            boolean[] canEdit = {true, true, true, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.jTableTotalizado.setAutoResizeMode(0);
        this.jTableTotalizado.doLayout();
        this.jTableTotalizado.setModel(this.xmodelo2);
        this.jTableTotalizado.getColumnModel().getColumn(0).setPreferredWidth(270);
        this.jTableTotalizado.getColumnModel().getColumn(1).setPreferredWidth(270);
        this.jTableTotalizado.getColumnModel().getColumn(2).setPreferredWidth(265);
        this.jTableTotalizado.getColumnModel().getColumn(3).setPreferredWidth(270);
    }

    private void crearTabla() {
        this.xmodelo = new DefaultTableModel((Object[][]) null, new String[]{"Fecha", "N° Doc Paciente", "Paciente Nombre", "Emp NIT", "Empresa", "Area", "Tipo Evaluación", "Examen", "Cantidad", "Valor", "Id Genoma"}) { // from class: Contabilidad.JD_FacturacionBienEstar.2
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Integer.class, Double.class, String.class};
            boolean[] canEdit = {false, false, false, true, true, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.jTableProcedimientos.setAutoResizeMode(0);
        this.jTableProcedimientos.doLayout();
        this.jTableProcedimientos.setModel(this.xmodelo);
        this.jTableProcedimientos.getColumnModel().getColumn(0).setPreferredWidth(80);
        this.jTableProcedimientos.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.jTableProcedimientos.getColumnModel().getColumn(2).setPreferredWidth(250);
        this.jTableProcedimientos.getColumnModel().getColumn(2).setMinWidth(250);
        this.jTableProcedimientos.getColumnModel().getColumn(3).setPreferredWidth(90);
        this.jTableProcedimientos.getColumnModel().getColumn(4).setPreferredWidth(250);
        this.jTableProcedimientos.getColumnModel().getColumn(4).setMinWidth(250);
        this.jTableProcedimientos.getColumnModel().getColumn(5).setPreferredWidth(200);
        this.jTableProcedimientos.getColumnModel().getColumn(5).setMinWidth(200);
        this.jTableProcedimientos.getColumnModel().getColumn(6).setPreferredWidth(130);
        this.jTableProcedimientos.getColumnModel().getColumn(6).setMinWidth(130);
        this.jTableProcedimientos.getColumnModel().getColumn(7).setPreferredWidth(170);
        this.jTableProcedimientos.getColumnModel().getColumn(8).setPreferredWidth(100);
        this.jTableProcedimientos.getColumnModel().getColumn(9).setPreferredWidth(130);
        this.jTableProcedimientos.getColumnModel().getColumn(9).setMinWidth(130);
    }

    private void llenarTablaTotalizado(String nit, String Finicial, String Ffinal) {
        crearTablatotalizado();
        String query1 = " SELECT EPAR.EPa_Nombre , PRCL.PCli_Costo,\nCOUNT(PRCL.PCli_Cantidad) AS Cantidad,EPAR.Cod_Genoma\nFROM Persona MEDI\nINNER JOIN Empresa_Empleado EMED ON MEDI.Per_ID = EMED.zPer_ID\nINNER JOIN HistoriaClinica HCLI ON EMED.Emp_ID = HCLI.zEmp_ID_Medico\nINNER JOIN Empresa_Empleado EPAC ON HCLI.HCli_ID = EPAC.zHCli_ID\nINNER JOIN Empresa EMPR ON EPAC.zEmpr_ID = EMPR.Empr_ID\nINNER JOIN Empresa_Area EAR ON EAR.Area_ID = EPAC.zEArea_ID\nINNER JOIN HistoriaClinica_Paraclinicos PRCL ON HCLI.HCli_ID = PRCL.zHCli_ID\nINNER JOIN Persona PACI ON EPAC.zPer_ID = PACI.Per_ID\nINNER JOIN Persona_Documento DOCP ON PACI.zDoc_ID = DOCP.Doc_ID\nINNER JOIN HistoriaClinica_ExamenParaclinico EPAR ON PRCL.zEpa_ID = EPAR.EPa_ID\nINNER JOIN HistoriaClinica_TipoExamen TIPOEXA ON TIPOEXA.TExa_ID = HCLI.zTExa_ID\nWHERE HCLI.HCli_Fecha >= '" + Finicial + "' AND HCLI.HCli_Fecha < '" + Ffinal + "'  AND EMPR.Empr_NIT = '" + nit + "'\ngroup by  EPa_Nombre,PRCL.PCli_Costo, EPAR.Cod_Genoma";
        try {
            ResultSet rss = this.consultasSQLs.traerRs(query1);
            if (rss.next()) {
                int x = 0;
                while (rss.next()) {
                    this.xmodelo2.addRow(this.xdato2);
                    this.xmodelo2.setValueAt(rss.getString(1), x, 0);
                    this.xmodelo2.setValueAt(Double.valueOf(rss.getDouble(2)), x, 1);
                    this.xmodelo2.setValueAt(Integer.valueOf(rss.getInt(3)), x, 2);
                    try {
                        this.xmodelo2.setValueAt(rss.getString(4), x, 3);
                    } catch (Exception e) {
                        this.xmodelo2.setValueAt("", x, 3);
                    }
                    x++;
                }
                rss.close();
                this.consultasSQLs.cerrarConexionBd();
            }
        } catch (Exception e2) {
            System.out.println("ERROR>>>>>>>>" + e2);
        }
    }

    private void llenarTabla(String nit, String Finicial, String Ffinal) {
        crearTabla();
        String query = "SET DATEFORMAT ymd; SELECT HCLI.HCli_Fecha Fecha,\nDOCP.Doc_Numero Paciente_Doc,        (PACI.Per_Nombre1 + ISNULL(' '+\tPACI.Per_Nombre2, '') + ISNULL(' '+ PACI.Per_Apellido1, ' ') + ISNULL(' '+ PACI.Per_Apellido2, '')) Paciente_Nombre,\n(EMPR.Empr_NIT +'-'+ Empr_Digito) Empresa_NIT, EMPR.Empr_RazonSocial Empresa_Nombre, EAR.Area_Nombre Area, TIPOEXA.TExa_Nombre Tipo_de_Evaluacion, EPAR.EPa_Nombre Examen,\nPRCL.PCli_Cantidad Cantidad, PRCL.PCli_Costo Valor,EPAR.Cod_Genoma Cod_Genoma\nFROM Persona MEDI\nINNER JOIN Empresa_Empleado EMED ON MEDI.Per_ID = EMED.zPer_ID\nINNER JOIN HistoriaClinica HCLI ON EMED.Emp_ID = HCLI.zEmp_ID_Medico\nINNER JOIN Empresa_Empleado EPAC ON HCLI.HCli_ID = EPAC.zHCli_ID\nINNER JOIN Empresa EMPR ON EPAC.zEmpr_ID = EMPR.Empr_ID\nINNER JOIN Empresa_Area EAR ON EAR.Area_ID = EPAC.zEArea_ID\nINNER JOIN HistoriaClinica_Paraclinicos PRCL ON HCLI.HCli_ID = PRCL.zHCli_ID\nINNER JOIN Persona PACI ON EPAC.zPer_ID = PACI.Per_ID\nINNER JOIN Persona_Documento DOCP ON PACI.zDoc_ID = DOCP.Doc_ID\nINNER JOIN HistoriaClinica_ExamenParaclinico EPAR ON PRCL.zEpa_ID = EPAR.EPa_ID\nINNER JOIN HistoriaClinica_TipoExamen TIPOEXA ON TIPOEXA.TExa_ID = HCLI.zTExa_ID\nWHERE HCLI.HCli_Fecha >= '" + Finicial + "' AND HCLI.HCli_Fecha < '" + Ffinal + "'  AND EMPR.Empr_NIT = '" + nit + "'\nUNION ALL SELECT OPTO.Opt_Fecha Fecha,\nDOCP.Doc_Numero Paciente_Doc, (PACI.Per_Nombre1 + ISNULL(' '+\tPACI.Per_Nombre2, '') + ISNULL(' '+ PACI.Per_Apellido1, ' ') + ISNULL(' '+ PACI.Per_Apellido2, '')) Paciente ,\n(EMPR.Empr_NIT +'-'+ Empr_Digito) Empresa_NIT, EMPR.Empr_RazonSocial Empresa_Nombre,EAR.Area_Nombre Area, 'NULL' as Tipo_de_Evaluacion, 'Optometria' Examen,  1 Cantidad, 0 Valor, 0 Cod_Genoma\nFROM Persona MEDI\nINNER JOIN Empresa_Empleado EMED ON MEDI.Per_ID = EMED.zPer_ID\nINNER JOIN Optometria OPTO ON EMED.Emp_ID = OPTO.zEmp_ID_Medico\nINNER JOIN Empresa_Empleado EPAC ON OPTO.Opt_ID = EPAC.zOpt_ID\nINNER JOIN Empresa EMPR ON EPAC.zEmpr_ID = EMPR.Empr_ID\nINNER JOIN Empresa_Area EAR ON EAR.Area_ID = EPAC.zEArea_ID\nINNER JOIN Persona PACI ON EPAC.zPer_ID = PACI.Per_ID\nINNER JOIN Persona_Documento DOCP ON PACI.zDoc_ID = DOCP.Doc_ID\nWHERE OPTO.Opt_Fecha >= '" + Finicial + "' AND OPTO.Opt_Fecha < '" + Ffinal + "'  AND EMPR.Empr_NIT = '" + nit + "'\nUNION ALL SELECT AUDIO.Aud_Fecha Fecha,\nDOCP.Doc_Numero Paciente_Doc,        (PACI.Per_Nombre1 + ISNULL(' '+\tPACI.Per_Nombre2, '') + ISNULL(' '+ PACI.Per_Apellido1, ' ') + ISNULL(' '+ PACI.Per_Apellido2, '')) Paciente ,\n(EMPR.Empr_NIT +'-'+ Empr_Digito) Empresa_NIT, EMPR.Empr_RazonSocial Empresa_Nombre, EAR.Area_Nombre Area, 'NULL' as Tipo_de_Evaluacion, 'Audiometria' Examen,\n1 Cantidad,        0 Valor , 0 Cod_Genoma\nFROM Persona MEDI\nINNER JOIN Empresa_Empleado EMED ON MEDI.Per_ID = EMED.zPer_ID\nINNER JOIN Audiometria AUDIO ON EMED.Emp_ID = AUDIO.zEmp_ID_Medico\nINNER JOIN Empresa_Empleado EPAC ON AUDIO.Aud_ID = EPAC.zAud_ID\nINNER JOIN Empresa EMPR ON EPAC.zEmpr_ID = EMPR.Empr_ID\nINNER JOIN Empresa_Area EAR ON EAR.Area_ID = EPAC.zEArea_ID\nINNER JOIN Persona PACI ON EPAC.zPer_ID = PACI.Per_ID\nINNER JOIN Persona_Documento DOCP ON PACI.zDoc_ID = DOCP.Doc_ID\nWHERE AUDIO.Aud_Fecha >= '" + Finicial + "' AND AUDIO.Aud_Fecha < '" + Ffinal + "'  AND EMPR.Empr_NIT = '" + nit + "'  ";
        try {
            ResultSet rss = this.consultasSQLs.traerRs(query);
            if (rss.next()) {
                int x = 0;
                while (rss.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(rss.getString(1), x, 0);
                    this.xmodelo.setValueAt(rss.getString(2), x, 1);
                    this.xmodelo.setValueAt(rss.getString(3), x, 2);
                    this.xmodelo.setValueAt(rss.getString(4), x, 3);
                    this.xmodelo.setValueAt(rss.getString(5), x, 4);
                    this.xmodelo.setValueAt(rss.getString(6), x, 5);
                    this.xmodelo.setValueAt(rss.getString(7), x, 6);
                    this.xmodelo.setValueAt(rss.getString(8), x, 7);
                    this.xmodelo.setValueAt(Integer.valueOf(rss.getInt(9)), x, 8);
                    this.xmodelo.setValueAt(Double.valueOf(rss.getDouble(10)), x, 9);
                    this.xmodelo.setValueAt(rss.getString(11), x, 10);
                    x++;
                }
                rss.close();
                this.consultasSQLs.cerrarConexionBd();
            }
            llenarTablaTotalizado(nit, Finicial, Ffinal);
        } catch (Exception e) {
            System.out.println("ERROR>>>>>>>>" + e);
        }
    }

    /* JADX WARN: Type inference failed for: r3v30, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jPanel1 = new JPanel();
        this.jTNameEmpresa = new JTextField();
        this.FINICIALL = new JDateChooser();
        this.FFINAL = new JDateChooser();
        this.jButton1 = new JButton();
        this.jTabbedPane1 = new JTabbedPane();
        this.jPanel3 = new JPanel();
        this.jScrollPane3 = new JScrollPane();
        this.jTableTotalizado = new JTable();
        this.jPanel2 = new JPanel();
        this.jScrollPane1 = new JScrollPane();
        this.jTableProcedimientos = new JTable();
        this.jButton2 = new JButton();
        this.jButton3 = new JButton();
        this.JTFRuta = new JTextField();
        this.JBTExportar = new JButton();
        this.JBBuscarDoc = new JButton();
        setDefaultCloseOperation(2);
        addWindowListener(new WindowAdapter() { // from class: Contabilidad.JD_FacturacionBienEstar.3
            public void windowClosing(WindowEvent evt) {
                JD_FacturacionBienEstar.this.formWindowClosing(evt);
            }
        });
        this.jTNameEmpresa.setForeground(Color.red);
        this.jTNameEmpresa.setBorder(BorderFactory.createTitledBorder((Border) null, "EMPRESA", 0, 0, new Font("Arial", 1, 14), new Color(0, 0, 255)));
        this.jTNameEmpresa.setEnabled(false);
        this.jTNameEmpresa.addActionListener(new ActionListener() { // from class: Contabilidad.JD_FacturacionBienEstar.4
            public void actionPerformed(ActionEvent evt) {
                JD_FacturacionBienEstar.this.jTNameEmpresaActionPerformed(evt);
            }
        });
        this.FINICIALL.setBorder(BorderFactory.createTitledBorder((Border) null, "FECHA INICIAL", 0, 0, new Font("Arial", 1, 12), new Color(0, 51, 255)));
        this.FFINAL.setBorder(BorderFactory.createTitledBorder((Border) null, "FECHA FINAL", 0, 0, new Font("Arial", 1, 12), new Color(0, 51, 255)));
        this.jButton1.setFont(new Font("Arial", 1, 13));
        this.jButton1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Buscar.png")));
        this.jButton1.setText("Buscar");
        this.jButton1.addActionListener(new ActionListener() { // from class: Contabilidad.JD_FacturacionBienEstar.5
            public void actionPerformed(ActionEvent evt) {
                JD_FacturacionBienEstar.this.jButton1ActionPerformed(evt);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(12, 12, 12).addComponent(this.jTNameEmpresa, -2, 464, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.FINICIALL, -2, 177, -2).addGap(18, 18, 18).addComponent(this.FFINAL, -2, 171, -2).addGap(18, 18, 18).addComponent(this.jButton1, -2, 152, -2).addContainerGap(-1, 32767)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jButton1, -2, 44, -2).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.FINICIALL, -2, 54, -2).addComponent(this.FFINAL, -2, 54, -2)).addComponent(this.jTNameEmpresa))).addContainerGap(-1, 32767)));
        this.jTabbedPane1.setForeground(Color.red);
        this.jTabbedPane1.setFont(new Font("Arial", 1, 13));
        this.jTableTotalizado.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.jTableTotalizado.setCursor(new Cursor(0));
        this.jTableTotalizado.addMouseListener(new MouseAdapter() { // from class: Contabilidad.JD_FacturacionBienEstar.6
            public void mouseClicked(MouseEvent evt) {
                JD_FacturacionBienEstar.this.jTableTotalizadoMouseClicked(evt);
            }
        });
        this.jTableTotalizado.addKeyListener(new KeyAdapter() { // from class: Contabilidad.JD_FacturacionBienEstar.7
            public void keyPressed(KeyEvent evt) {
                JD_FacturacionBienEstar.this.jTableTotalizadoKeyPressed(evt);
            }
        });
        this.jScrollPane3.setViewportView(this.jTableTotalizado);
        GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
        this.jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane3, -2, 1075, -2).addContainerGap(-1, 32767)));
        jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane3, -1, 332, 32767).addContainerGap()));
        this.jTabbedPane1.addTab("TOTALIZADO", this.jPanel3);
        this.jScrollPane1.setViewportView(this.jTableProcedimientos);
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane1).addContainerGap()));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane1, -1, 324, 32767).addContainerGap()));
        this.jTabbedPane1.addTab("DETALLE GENERAL", this.jPanel2);
        this.jButton2.setFont(new Font("Arial", 1, 13));
        this.jButton2.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Grabar29x27.png")));
        this.jButton2.setText("Procesar");
        this.jButton2.addActionListener(new ActionListener() { // from class: Contabilidad.JD_FacturacionBienEstar.8
            public void actionPerformed(ActionEvent evt) {
                JD_FacturacionBienEstar.this.jButton2ActionPerformed(evt);
            }
        });
        this.jButton3.setFont(new Font("Arial", 1, 13));
        this.jButton3.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Configuracion.png")));
        this.jButton3.setText("Configurar Procedimientos");
        this.jButton3.addActionListener(new ActionListener() { // from class: Contabilidad.JD_FacturacionBienEstar.9
            public void actionPerformed(ActionEvent evt) {
                JD_FacturacionBienEstar.this.jButton3ActionPerformed(evt);
            }
        });
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: Contabilidad.JD_FacturacionBienEstar.10
            public void mouseClicked(MouseEvent evt) {
                JD_FacturacionBienEstar.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JTFRuta.addActionListener(new ActionListener() { // from class: Contabilidad.JD_FacturacionBienEstar.11
            public void actionPerformed(ActionEvent evt) {
                JD_FacturacionBienEstar.this.JTFRutaActionPerformed(evt);
            }
        });
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: Contabilidad.JD_FacturacionBienEstar.12
            public void actionPerformed(ActionEvent evt) {
                JD_FacturacionBienEstar.this.JBTExportarActionPerformed(evt);
            }
        });
        this.JBBuscarDoc.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBBuscarDoc.setText("Buscar Doc");
        this.JBBuscarDoc.setToolTipText("");
        this.JBBuscarDoc.addMouseListener(new MouseAdapter() { // from class: Contabilidad.JD_FacturacionBienEstar.13
            public void mouseClicked(MouseEvent evt) {
                JD_FacturacionBienEstar.this.JBBuscarDocMouseClicked(evt);
            }
        });
        this.JBBuscarDoc.addActionListener(new ActionListener() { // from class: Contabilidad.JD_FacturacionBienEstar.14
            public void actionPerformed(ActionEvent evt) {
                JD_FacturacionBienEstar.this.JBBuscarDocActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.jPanel1, -1, -1, 32767).addContainerGap()).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(layout.createSequentialGroup().addComponent(this.jButton2, -2, 176, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jButton3).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFRuta, -2, 362, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBBuscarDoc).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTExportar, -2, 160, -2).addGap(0, 0, 32767)).addComponent(this.jTabbedPane1)).addGap(8, 8, 8)))));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jTabbedPane1, -2, 369, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBTExportar, -2, 50, -2).addComponent(this.JBBuscarDoc, -2, 49, -2)).addComponent(this.JTFRuta, -2, 50, -2).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jButton2, -2, 48, -2).addComponent(this.jButton3, -1, -1, 32767))).addContainerGap(84, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jTNameEmpresaActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jButton1ActionPerformed(ActionEvent evt) {
        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
        String strDateInicial = date.format(this.FINICIALL.getDate()) + " 00:00";
        String strDateFinal = date.format(this.FFINAL.getDate()) + " 23:59";
        llenarTabla(this.NIT, strDateInicial, strDateFinal);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jButton2ActionPerformed(ActionEvent evt) {
        boolean error = false;
        int i = 0;
        while (true) {
            if (i >= this.xmodelo2.getRowCount() - 1) {
                break;
            }
            if (!this.xmodelo2.getValueAt(i, 3).toString().equals("0")) {
                i++;
            } else {
                error = true;
                JOptionPane.showMessageDialog(this, "Puede haber por lo menos un procedimiento no homologado, verifique antes de continuar.");
                break;
            }
        }
        if (!error) {
            int i2 = 0;
            while (i2 < this.xmodelo2.getRowCount() - 1) {
                System.out.println("xmodelo2.getValueAt(i, 1) -> " + this.xmodelo2.getValueAt(i2, 1));
                if (this.xmodelo2.getValueAt(i2, 1).toString().equals("0.0")) {
                    this.xmodelo2.removeRow(i2);
                    i2--;
                } else {
                    JIFGenerarCuentaCobroMImpuestos.xmodeloDataAuto = this.xmodelo2;
                }
                i2++;
            }
            dispose();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jButton3ActionPerformed(ActionEvent evt) {
        JD_HomologarProcedimientosBienestar frmHomologarProcBienEstar = new JD_HomologarProcedimientosBienestar(null, true);
        frmHomologarProcBienEstar.setLocationRelativeTo(this);
        frmHomologarProcBienEstar.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jTableTotalizadoMouseClicked(MouseEvent evt) {
        for (int i = 0; i < this.xmodelo2.getRowCount(); i++) {
            if (this.xmodelo2.getValueAt(i, 3).toString().equals("0")) {
                JOptionPane.showMessageDialog(this, "Puede haber por lo menos un procedimiento no homologado, verifique antes de continuar.");
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jTableTotalizadoKeyPressed(KeyEvent evt) {
        if (this.jTableTotalizado.getSelectedRow() != -1 && evt.getKeyCode() == 127) {
            this.xmodelo2.removeRow(this.jTableTotalizado.getSelectedRow());
            this.x--;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formWindowClosing(WindowEvent evt) {
        this.jTableTotalizado.removeAll();
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
        double sumTotal = 0.0d;
        for (int i = 0; i < this.xmodelo2.getRowCount(); i++) {
            double total = Double.parseDouble(this.xmodelo2.getValueAt(i, 1).toString()) * Double.parseDouble(this.xmodelo2.getValueAt(i, 2).toString());
            sumTotal += total;
        }
        this.xmodelo2.addRow(new Object[0]);
        int row = this.xmodelo2.getRowCount() - 1;
        this.xmodelo2.setValueAt("Total", row, 0);
        this.xmodelo2.setValueAt(Double.valueOf(sumTotal), row, 1);
        this.xmodelo2.setValueAt(1, row, 2);
        this.xmodelo2.setValueAt(Double.valueOf(sumTotal), row, 3);
        exportarArchivo(this.xmodelo, this.xmodelo2);
        this.xmodelo2.removeRow(this.xmodelo2.getRowCount() - 1);
        this.JBTExportar.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBBuscarDocMouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBBuscarDocActionPerformed(ActionEvent evt) {
        JFileChooser xfilec = new JFileChooser(this.JTFRuta.getText());
        xfilec.setFileSelectionMode(0);
        int xv = xfilec.showOpenDialog(this);
        if (xv == 0) {
            File xfile = xfilec.getSelectedFile();
            this.JTFRuta.setText(xfile.getAbsolutePath() + this.xmt.getBarra());
            this.JTFRuta.requestFocus();
        }
        try {
            File archivoGuardado = new File(this.JTFRuta.getText());
            Desktop.getDesktop().open(archivoGuardado);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void exportarArchivo(DefaultTableModel xmodelo, DefaultTableModel xmodelo2) {
        System.out.println("cantidad de filas en totalizado -> " + xmodelo2.getRowCount());
        System.out.println("cantidad de filas en detalle -> " + xmodelo.getRowCount());
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Datos");
        HSSFCellStyle style = workbook.createCellStyle();
        HSSFRow row = sheet.createRow(0);
        double sumTotal = 0.0d;
        for (int i = 0; i < xmodelo.getColumnCount(); i++) {
            HSSFCell cell = row.createCell(i + 1);
            cell.setCellValue(xmodelo.getColumnName(i));
            style.setFillBackgroundColor(IndexedColors.BLUE.getIndex());
            cell.setCellStyle(style);
        }
        for (int i2 = 0; i2 < xmodelo2.getColumnCount(); i2++) {
            HSSFCell cell2 = row.createCell(xmodelo.getColumnCount() + i2 + 2);
            if (xmodelo2.getColumnName(i2).equals("CodGenoma")) {
                cell2.setCellValue("Total");
            } else {
                cell2.setCellValue(xmodelo2.getColumnName(i2));
            }
        }
        for (int i3 = 0; i3 < Math.max(xmodelo.getRowCount(), xmodelo2.getRowCount()); i3++) {
            HSSFRow row2 = sheet.createRow(i3 + 1);
            if (i3 < xmodelo.getRowCount()) {
                for (int j = 0; j < xmodelo.getColumnCount(); j++) {
                    row2.createCell(j + 1).setCellValue(xmodelo.getValueAt(i3, j).toString());
                }
            }
            if (i3 < xmodelo2.getRowCount()) {
                for (int j2 = 0; j2 < xmodelo2.getColumnCount(); j2++) {
                    HSSFCell cell3 = row2.createCell(xmodelo.getColumnCount() + j2 + 2);
                    if (xmodelo2.getColumnName(j2).equals("CodGenoma")) {
                        double total = Double.parseDouble(xmodelo2.getValueAt(i3, 1).toString()) * Double.parseDouble(xmodelo2.getValueAt(i3, 2).toString());
                        cell3.setCellValue(total);
                        System.out.println(i3 + ". total -> " + total);
                        sumTotal += total;
                        System.out.println(i3 + ". sumTotal -> " + sumTotal);
                    } else {
                        cell3.setCellValue(xmodelo2.getValueAt(i3, j2).toString());
                    }
                }
                int lastRow = xmodelo2.getRowCount() - 1;
                HSSFRow lastRowHSSF = sheet.getRow(lastRow + 1);
                if (lastRowHSSF == null) {
                    lastRowHSSF = sheet.createRow(lastRow + 1);
                }
                lastRowHSSF.createCell(xmodelo.getColumnCount() + 3).setCellValue("");
                lastRowHSSF.createCell(xmodelo.getColumnCount() + 4).setCellValue("");
            }
        }
        for (int i4 = 0; i4 < xmodelo.getColumnCount(); i4++) {
            sheet.autoSizeColumn(i4);
        }
        for (int i5 = 0; i5 < xmodelo2.getColumnCount(); i5++) {
            sheet.autoSizeColumn(i5);
        }
        try {
            if (this.JTFRuta.getText().isEmpty()) {
                this.JTFRuta.setText("\\\\BS_SERVER\\FacturaElectronica\\ARCHIVOS ABJUNTOS FACTURAS\\" + this.NIT + "_" + quitarBarra(Principal.txtFecha.getText()) + ".xls");
            }
            String rutaArchivo = this.JTFRuta.getText();
            System.out.println("ruta -> " + rutaArchivo);
            FileOutputStream archivo = new FileOutputStream(new File(rutaArchivo));
            workbook.write(archivo);
            archivo.close();
            File archivoGuardado = new File(rutaArchivo);
            Desktop.getDesktop().open(archivoGuardado);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String quitarBarra(String cadena) {
        return cadena.replace("/", "");
    }
}
