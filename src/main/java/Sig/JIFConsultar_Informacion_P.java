package Sig;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Sig/JIFConsultar_Informacion_P.class */
public class JIFConsultar_Informacion_P extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private DefaultTableModel xmodelo1;
    private DefaultTableModel xmodelo2;
    private String xsql;
    private String xnombre;
    private String xtitulo;
    private Object[] xdato;
    private JButton JBTExportar;
    private JDateChooser JDFechaF;
    private JDateChooser JDFechaI;
    private JPanel JPIDatosConsolidado;
    private JPanel JPIEncabezado;
    private JScrollPane JSPDetalle;
    public static JSpinner JSPLimite;
    private JTable JTDetalle;
    private JFormattedTextField JTFFCinco;
    private JFormattedTextField JTFFCuatro;
    private JFormattedTextField JTFFDos;
    private JFormattedTextField JTFFTres;
    private JFormattedTextField JTFFUno;
    private JTextField JTFRuta;
    private JTabbedPane JTPDatos;
    private Metodos xmt = new Metodos();
    private ConsultasMySQL xct = new ConsultasMySQL();

    public JIFConsultar_Informacion_P(String xnombre, String xtitulo) {
        initComponents();
        this.xnombre = xnombre;
        setName(xnombre);
        setTitle(xtitulo.toUpperCase());
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v41, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPIEncabezado = new JPanel();
        this.JDFechaI = new JDateChooser();
        this.JDFechaF = new JDateChooser();
        JSPLimite = new JSpinner();
        this.JTFRuta = new JTextField();
        this.JBTExportar = new JButton();
        this.JTPDatos = new JTabbedPane();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JPIDatosConsolidado = new JPanel();
        this.JTFFUno = new JFormattedTextField();
        this.JTFFDos = new JFormattedTextField();
        this.JTFFTres = new JFormattedTextField();
        this.JTFFCuatro = new JFormattedTextField();
        this.JTFFCinco = new JFormattedTextField();
        setClosable(true);
        setIconifiable(true);
        setTitle("INFORME");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjifconsultas_informes_p");
        this.JPIEncabezado.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JDFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicial", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFechaI.setFont(new Font("Arial", 1, 12));
        this.JDFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Final", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFechaF.setFont(new Font("Arial", 1, 12));
        JSPLimite.setFont(new Font("Arial", 1, 12));
        JSPLimite.setToolTipText("Tiempo em minuto para marcar las filas que superen el límite (>=)");
        JSPLimite.setBorder(BorderFactory.createTitledBorder((Border) null, "Límite", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: Sig.JIFConsultar_Informacion_P.1
            public void mouseClicked(MouseEvent evt) {
                JIFConsultar_Informacion_P.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setForeground(Color.red);
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: Sig.JIFConsultar_Informacion_P.2
            public void actionPerformed(ActionEvent evt) {
                JIFConsultar_Informacion_P.this.JBTExportarActionPerformed(evt);
            }
        });
        GroupLayout JPIEncabezadoLayout = new GroupLayout(this.JPIEncabezado);
        this.JPIEncabezado.setLayout(JPIEncabezadoLayout);
        JPIEncabezadoLayout.setHorizontalGroup(JPIEncabezadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIEncabezadoLayout.createSequentialGroup().addContainerGap().addComponent(this.JDFechaI, -2, 125, -2).addGap(10, 10, 10).addComponent(this.JDFechaF, -2, 125, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(JSPLimite, -2, 72, -2).addGap(18, 18, 18).addComponent(this.JTFRuta).addGap(18, 18, 18).addComponent(this.JBTExportar, -2, 137, -2).addContainerGap()));
        JPIEncabezadoLayout.setVerticalGroup(JPIEncabezadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIEncabezadoLayout.createSequentialGroup().addContainerGap().addGroup(JPIEncabezadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIEncabezadoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE, false).addComponent(JSPLimite).addComponent(this.JTFRuta, -2, 50, -2)).addGroup(JPIEncabezadoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JDFechaF, -2, 50, -2).addComponent(this.JDFechaI, -2, 50, -2)).addComponent(this.JBTExportar, -2, 50, -2)).addContainerGap(20, 32767)));
        this.JTPDatos.setForeground(new Color(0, 103, 0));
        this.JTPDatos.setFont(new Font("Arial", 1, 14));
        this.JTDetalle.setBorder(BorderFactory.createBevelBorder(0));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalle.setEditingColumn(0);
        this.JTDetalle.setEditingRow(0);
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setRowMargin(4);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: Sig.JIFConsultar_Informacion_P.3
            public void mouseClicked(MouseEvent evt) {
                JIFConsultar_Informacion_P.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.JTPDatos.addTab("DETALLE", this.JSPDetalle);
        this.JPIDatosConsolidado.setBorder(BorderFactory.createTitledBorder((Border) null, "CONSOLIDADO", 0, 0, new Font("Arial", 1, 14), Color.red));
        this.JTFFUno.setBorder(BorderFactory.createTitledBorder((Border) null, "UNO", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFUno.setHorizontalAlignment(4);
        this.JTFFUno.setFont(new Font("Arial", 1, 12));
        this.JTFFDos.setBorder(BorderFactory.createTitledBorder((Border) null, "UNO", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFDos.setHorizontalAlignment(4);
        this.JTFFDos.setFont(new Font("Arial", 1, 12));
        this.JTFFTres.setBorder(BorderFactory.createTitledBorder((Border) null, "UNO", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFTres.setHorizontalAlignment(4);
        this.JTFFTres.setFont(new Font("Arial", 1, 12));
        this.JTFFCuatro.setBorder(BorderFactory.createTitledBorder((Border) null, "UNO", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFCuatro.setHorizontalAlignment(4);
        this.JTFFCuatro.setFont(new Font("Arial", 1, 12));
        this.JTFFCinco.setBorder(BorderFactory.createTitledBorder((Border) null, "UNO", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFCinco.setHorizontalAlignment(4);
        this.JTFFCinco.setFont(new Font("Arial", 1, 12));
        GroupLayout JPIDatosConsolidadoLayout = new GroupLayout(this.JPIDatosConsolidado);
        this.JPIDatosConsolidado.setLayout(JPIDatosConsolidadoLayout);
        JPIDatosConsolidadoLayout.setHorizontalGroup(JPIDatosConsolidadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosConsolidadoLayout.createSequentialGroup().addContainerGap().addComponent(this.JTFFUno, -2, 130, -2).addGap(18, 18, 18).addComponent(this.JTFFDos, -2, 130, -2).addGap(18, 18, 18).addComponent(this.JTFFTres, -2, 130, -2).addGap(18, 18, 18).addComponent(this.JTFFCuatro, -2, 130, -2).addGap(18, 18, 18).addComponent(this.JTFFCinco, -2, 130, -2).addContainerGap(-1, 32767)));
        JPIDatosConsolidadoLayout.setVerticalGroup(JPIDatosConsolidadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosConsolidadoLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosConsolidadoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFUno, -2, -1, -2).addComponent(this.JTFFDos, -2, -1, -2).addComponent(this.JTFFTres, -2, -1, -2).addComponent(this.JTFFCuatro, -2, -1, -2).addComponent(this.JTFFCinco, -2, -1, -2)).addContainerGap(-1, 32767)));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPIEncabezado, -1, -1, 32767).addComponent(this.JTPDatos, -1, 883, 32767).addComponent(this.JPIDatosConsolidado, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIEncabezado, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTPDatos, -2, 362, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JPIDatosConsolidado, -2, -1, -2).addContainerGap(-1, 32767)));
        pack();
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
        if (this.xnombre.equals("xjifconsultas_informes_p") && this.JTDetalle.getRowCount() != -1) {
            this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTDetalle, this.JTFRuta.getText(), getTitle());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() >= 2 && this.JTDetalle.getSelectedRow() != -1) {
            String[][] mparametros = new String[4][2];
            mparametros[0][0] = "idatencion1";
            mparametros[0][1] = this.JTDetalle.getValueAt(this.JTDetalle.getSelectedRow(), 8).toString();
            mparametros[1][0] = "idpaciente1";
            mparametros[1][1] = this.JTDetalle.getValueAt(this.JTDetalle.getSelectedRow(), 9).toString();
            mparametros[2][0] = "SUBREPORT_DIR";
            mparametros[2][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
            mparametros[3][0] = "SUBREPORTFIRMA_DIR";
            mparametros[3][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
            if (Principal.informacionIps.getEsFpz().intValue() == 0) {
                this.xmt.GenerarPDF(this.xmt.getRutaRep() + "H_HistoriaClinica", mparametros);
            } else {
                this.xmt.GenerarPDF(this.xmt.getRutaRep() + "H_HistoriaClinica1", mparametros);
            }
        }
    }

    public void mNuevo() {
        this.JDFechaI.setDate(this.xmt.getFechaActual());
        this.JDFechaF.setDate(this.xmt.getFechaActual());
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
        this.JTFFUno.setValue(0);
        this.JTFFDos.setValue(0);
        this.JTFFTres.setValue(0);
        this.JTFFCuatro.setValue(0);
        this.JTFFCinco.setValue(0);
        JSPLimite.setValue(new Integer(5));
        mFijarTitulosCombos();
        if (this.xnombre.equals("xjifconsultas_informes_p")) {
            mCrearTablaDetalle1();
        } else if (this.xnombre.equals("xjifconsultas_informes_p1")) {
            mCrearTablaDetalle2();
        }
    }

    private void mFijarTitulosCombos() {
        if (this.xnombre.equals("xjifconsultas_informes_p")) {
            this.JTFFUno.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Atenciones", 0, 0, new Font("Arial", 1, 12), Color.blue));
            this.JTFFUno.setToolTipText("Número de atenciones realizadas");
            this.JTFFDos.setBorder(BorderFactory.createTitledBorder((Border) null, "CMinutos(R-T)", 0, 0, new Font("Arial", 1, 12), Color.blue));
            this.JTFFDos.setToolTipText("Cantidad de minutos (Hora Llegada vs Atención Enfermería)");
            this.JTFFTres.setBorder(BorderFactory.createTitledBorder((Border) null, "Promedio Minutos", 0, 0, new Font("Arial", 1, 12), Color.blue));
            this.JTFFTres.setToolTipText("Promedio (Sumatoria de Minutos vs N° Atenciones)");
            this.JTFFCuatro.setBorder(BorderFactory.createTitledBorder((Border) null, "CMinutos1(R-M)", 0, 0, new Font("Arial", 1, 12), Color.blue));
            this.JTFFCuatro.setToolTipText("Cantidad de minutos (Hora Llegada vs Atención Medica)");
            this.JTFFCinco.setBorder(BorderFactory.createTitledBorder((Border) null, "Promedio Minutos", 0, 0, new Font("Arial", 1, 12), Color.blue));
            this.JTFFCinco.setToolTipText("Promedio (Sumatoria de Minutos1 vs N° Atenciones)");
            return;
        }
        if (this.xnombre.equals("xjifconsultas_informes_p1")) {
            this.JTFFUno.setBorder(BorderFactory.createTitledBorder((Border) null, "Total Atenciones", 0, 0, new Font("Arial", 1, 12), Color.blue));
            this.JTFFUno.setToolTipText("Total de atenciones solicitadas");
            this.JTFFDos.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Atendidas", 0, 0, new Font("Arial", 1, 12), Color.blue));
            this.JTFFDos.setToolTipText("Cantidad atenciones realizadas");
            this.JTFFTres.setBorder(BorderFactory.createTitledBorder((Border) null, "Prom. Atenciones", 0, 0, new Font("Arial", 1, 12), Color.blue));
            this.JTFFTres.setToolTipText("Promedio (Total Atendidas / Total Atenciones)");
            this.JTFFCuatro.setBorder(BorderFactory.createTitledBorder((Border) null, "No Realizadas", 0, 0, new Font("Arial", 1, 12), Color.blue));
            this.JTFFCuatro.setToolTipText("Cantidad de solicitudes que no se atendieron");
            this.JTFFCinco.setBorder(BorderFactory.createTitledBorder((Border) null, "Prom.No Atendidas", 0, 0, new Font("Arial", 1, 12), Color.blue));
            this.JTFFCinco.setToolTipText("Promedio (Total No Atendidas / Total Atenciones)");
        }
    }

    public void mBuscar() {
        if (this.xnombre.equals("xjifconsultas_informes_p")) {
            mCargar_Datos_Tabla_Detalle();
        } else if (this.xnombre.equals("xjifconsultas_informes_p1")) {
            mCargar_Datos_Tabla_Detalle_1();
        }
    }

    private void mCargar_Datos_Tabla_Detalle() {
        try {
            mCrearTablaDetalle1();
            this.xsql = "SELECT COUNT(`h_horallegada`.`Id`) AS `NAtenciones`, SUM(ABS(TIMESTAMPDIFF(MINUTE,TIMESTAMP(`ingreso`.`FechaIngreso` ,`ingreso`.`HoraIngreso`), `h_horallegada`.`Fecha_Hora`))) AS `D_Fl_Fi`, (SUM(ABS(TIMESTAMPDIFF(MINUTE,TIMESTAMP(`ingreso`.`FechaIngreso` ,`ingreso`.`HoraIngreso`), `h_horallegada`.`Fecha_Hora`)))/COUNT(`h_horallegada`.`Id`)) AS `P_D_Fl_Fi` , SUM(ABS(TIMESTAMPDIFF(MINUTE,TIMESTAMP(`h_atencion`.`Fecha_Atencion` , `h_atencion`.`Hora_Atencion`), `h_horallegada`.`Fecha_Hora`))) AS `D_Fl_Fa` , (SUM(ABS(TIMESTAMPDIFF(MINUTE,TIMESTAMP(`h_atencion`.`Fecha_Atencion` , `h_atencion`.`Hora_Atencion`), `h_horallegada`.`Fecha_Hora`)))/ COUNT(`h_horallegada`.`Id`)) AS `P_D_Fl_Fa`     FROM  `ingreso` INNER JOIN `h_horallegada`  ON (`ingreso`.`Id` = `h_horallegada`.`Id_Ingreso`) INNER JOIN `h_atencion`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`) WHERE (h_horallegada.`Estado`=1 AND DATE_FORMAT(`h_horallegada`.`Fecha_Hora`,'%Y-%m-%d') >='" + this.xmt.formatoAMD1.format(this.JDFechaI.getDate()) + "' AND DATE_FORMAT(`h_horallegada`.`Fecha_Hora`,'%Y-%m-%d') <='" + this.xmt.formatoAMD1.format(this.JDFechaF.getDate()) + "' AND TIMEDIFF(TIMESTAMP(`ingreso`.`FechaIngreso`, `ingreso`.`HoraIngreso`), `h_horallegada`.`Fecha_Hora`) >0) ";
            ResultSet xrs = this.xct.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.first();
                this.JTFFUno.setValue(Long.valueOf(xrs.getLong(1)));
                this.JTFFDos.setValue(Double.valueOf(xrs.getDouble(2)));
                this.JTFFTres.setValue(Double.valueOf(xrs.getDouble(3)));
                this.JTFFCuatro.setValue(Double.valueOf(xrs.getDouble(4)));
                this.JTFFCinco.setValue(Double.valueOf(xrs.getDouble(5)));
            }
            xrs.close();
            this.xct.cerrarConexionBd();
            this.xsql = "SELECT DATE_FORMAT(`h_horallegada`.`Fecha_Hora`,'%Y-%m-%d') AS Fecha, `persona`.`NoHistoria`, `persona`.`NUsuario`, `persona`.`IdSexo`, CONCAT(`persona`.`Edad`,' ', `persona`.`NTipoEdad`) AS Edad , SUM(ABS(TIMESTAMPDIFF(MINUTE,TIMESTAMP(`ingreso`.`FechaIngreso` ,`ingreso`.`HoraIngreso`), `h_horallegada`.`Fecha_Hora`))) AS `D_Fl_Fi`     , SUM(ABS(TIMESTAMPDIFF(MINUTE,TIMESTAMP(`h_atencion`.`Fecha_Atencion` , `h_atencion`.`Hora_Atencion`), `h_horallegada`.`Fecha_Hora`))) AS `D_Fl_Fa` , ((SUM(ABS(TIMESTAMPDIFF(MINUTE,TIMESTAMP(`h_atencion`.`Fecha_Atencion` , `h_atencion`.`Hora_Atencion`), `h_horallegada`.`Fecha_Hora`))))-(SUM(ABS(TIMESTAMPDIFF(MINUTE,TIMESTAMP(`ingreso`.`FechaIngreso` ,`ingreso`.`HoraIngreso`), `h_horallegada`.`Fecha_Hora`))))) AS Dif , `h_atencion`.`Id`, `persona`.`Id_persona` FROM  `ingreso` INNER JOIN `h_horallegada`  ON (`ingreso`.`Id` = `h_horallegada`.`Id_Ingreso`) INNER JOIN `h_atencion`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`) INNER JOIN `persona`  ON (`persona`.`Id_persona` = `ingreso`.`Id_Usuario`) WHERE (DATE_FORMAT(`h_horallegada`.`Fecha_Hora`,'%Y-%m-%d') >='" + this.xmt.formatoAMD1.format(this.JDFechaI.getDate()) + "' AND DATE_FORMAT(`h_horallegada`.`Fecha_Hora`,'%Y-%m-%d') <='" + this.xmt.formatoAMD1.format(this.JDFechaF.getDate()) + "' AND TIMEDIFF(TIMESTAMP(`ingreso`.`FechaIngreso`, `ingreso`.`HoraIngreso`), `h_horallegada`.`Fecha_Hora`) >0 AND `h_horallegada`.`Estado` =1) GROUP BY `persona`.`Id_persona`, `h_atencion`.`Id` ORDER BY DATE_FORMAT(`h_horallegada`.`Fecha_Hora`,'%Y-%m-%d') ASC, `persona`.`NUsuario` ASC ";
            ResultSet xrs2 = this.xct.traerRs(this.xsql);
            if (xrs2.next()) {
                xrs2.beforeFirst();
                int x = 0;
                while (xrs2.next()) {
                    this.xmodelo1.addRow(this.xdato);
                    this.xmodelo1.setValueAt(xrs2.getString(1), x, 0);
                    this.xmodelo1.setValueAt(xrs2.getString(2), x, 1);
                    this.xmodelo1.setValueAt(xrs2.getString(3), x, 2);
                    this.xmodelo1.setValueAt(xrs2.getString(4), x, 3);
                    this.xmodelo1.setValueAt(xrs2.getString(5), x, 4);
                    this.xmodelo1.setValueAt(Long.valueOf(xrs2.getLong(6)), x, 5);
                    this.xmodelo1.setValueAt(Long.valueOf(xrs2.getLong(7)), x, 6);
                    this.xmodelo1.setValueAt(Long.valueOf(xrs2.getLong(8)), x, 7);
                    this.xmodelo1.setValueAt(Long.valueOf(xrs2.getLong(9)), x, 8);
                    this.xmodelo1.setValueAt(Long.valueOf(xrs2.getLong(10)), x, 9);
                    this.JTDetalle.setDefaultRenderer(Object.class, new MiRender());
                    x++;
                }
            }
            xrs2.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFConsultar_Informacion_P.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargar_Datos_Tabla_Detalle_1() {
        try {
            mCrearTablaDetalle2();
            this.xsql = "SELECT DATE_FORMAT(`c_citasnp`.`Fecha_Cita`,'%Y-%m-%d') AS Fecha, `persona`.`NoHistoria`, `persona`.`NUsuario`, `persona`.`IdSexo`,  CONCAT(`persona`.`Edad`,' ', `persona`.`NTipoEdad`) AS `Edad`, `f_empresacontxconvenio`.`Nbre` AS `Empresa`, IF(`c_citasnp`.`Asistida`=0,0, 1) AS `Tipo`, `persona`.`Id_persona`, `h_atencion`.`Id`, `profesional1`.`Especialidad`, `profesional1`.`NProfesional` FROM `ingreso` INNER JOIN `c_citasnp`  ON (`ingreso`.`Id` = `c_citasnp`.`Id_ingreso`) INNER JOIN `persona`  ON (`persona`.`Id_persona` = `ingreso`.`Id_Usuario`) INNER JOIN `f_empresacontxconvenio`  ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`) INNER JOIN `h_atencion`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`) INNER JOIN `profesional1`  ON (`profesional1`.`Id_Persona` = `h_atencion`.`Id_Profesional`) AND (`profesional1`.`IdEspecialidad` = `h_atencion`.`Id_Especialidad`) WHERE (ingreso.`Estado`=0 AND `c_citasnp`.`Fecha_Cita` >='" + this.xmt.formatoAMD1.format(this.JDFechaI.getDate()) + "' AND `c_citasnp`.`Fecha_Cita` <='" + this.xmt.formatoAMD1.format(this.JDFechaF.getDate()) + "' AND `c_citasnp`.`Id_MotivoDesistida` =0) ORDER BY `c_citasnp`.`Fecha_Cita` ASC, `persona`.`NUsuario` ASC ";
            ResultSet xrs = this.xct.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int x = 0;
                double xatendidas = 0.0d;
                double xnatendidas = 0.0d;
                while (xrs.next()) {
                    this.xmodelo1.addRow(this.xdato);
                    this.xmodelo1.setValueAt(xrs.getString(1), x, 0);
                    this.xmodelo1.setValueAt(xrs.getString(2), x, 1);
                    this.xmodelo1.setValueAt(xrs.getString(3), x, 2);
                    this.xmodelo1.setValueAt(xrs.getString(4), x, 3);
                    this.xmodelo1.setValueAt(xrs.getString(5), x, 4);
                    this.xmodelo1.setValueAt(xrs.getString(6), x, 5);
                    this.xmodelo1.setValueAt(Long.valueOf(xrs.getLong(7)), x, 6);
                    this.xmodelo1.setValueAt(Long.valueOf(xrs.getLong(8)), x, 7);
                    this.xmodelo1.setValueAt(Long.valueOf(xrs.getLong(9)), x, 8);
                    this.xmodelo1.setValueAt(xrs.getString(10), x, 9);
                    this.xmodelo1.setValueAt(xrs.getString(11), x, 10);
                    this.JTDetalle.setDefaultRenderer(Object.class, new MiRender1());
                    if (xrs.getLong(7) == 0) {
                        xnatendidas += 1.0d;
                    } else {
                        xatendidas += 1.0d;
                    }
                    x++;
                }
                this.JTFFUno.setValue(Integer.valueOf(x));
                this.JTFFDos.setValue(Double.valueOf(xatendidas));
                this.JTFFTres.setValue(Double.valueOf((xatendidas / ((double) x)) * 100.0d));
                this.JTFFCuatro.setValue(Double.valueOf(xnatendidas));
                this.JTFFCinco.setValue(Double.valueOf((xnatendidas / ((double) x)) * 100.0d));
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFConsultar_Informacion_P.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCrearTablaDetalle1() {
        this.xmodelo1 = new DefaultTableModel((Object[][]) null, new String[]{"Fecha", "N°HC", "Usuario", "Sexo", "Edad", "Recepción-Triage", "Recepción-Médico", "Diferencia(Triage-Médico)", "Id_Atencion", "Id_Persona"}) { // from class: Sig.JIFConsultar_Informacion_P.4
            Class[] types = {String.class, String.class, String.class, String.class, String.class, Long.class, Long.class, Long.class, Long.class, Long.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return this.canEdit[colIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo1);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(8).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(8).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(9).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(9).setMaxWidth(0);
    }

    private void mCrearTablaDetalle2() {
        this.xmodelo1 = new DefaultTableModel((Object[][]) null, new String[]{"Fecha", "N°HC", "Usuario", "Sexo", "Edad", "Empresa", "Tipo", "Id_Atencion", "Id_Persona", "Especialidad", "Profesional"}) { // from class: Sig.JIFConsultar_Informacion_P.5
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, Long.class, Long.class, Long.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return this.canEdit[colIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo1);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(7).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(7).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(8).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(8).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(9).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(9).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(10).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(10).setMaxWidth(0);
    }

    /* JADX INFO: loaded from: GenomaP.jar:Sig/JIFConsultar_Informacion_P$MiRender.class */
    public static class MiRender extends DefaultTableCellRenderer {
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (Long.valueOf(table.getValueAt(row, 7).toString()).longValue() >= Long.valueOf(JIFConsultar_Informacion_P.JSPLimite.getValue().toString()).longValue()) {
                cell.setBackground(new Color(177, 251, 177));
            } else {
                cell.setBackground(Color.WHITE);
            }
            return cell;
        }
    }

    /* JADX INFO: loaded from: GenomaP.jar:Sig/JIFConsultar_Informacion_P$MiRender1.class */
    public static class MiRender1 extends DefaultTableCellRenderer {
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (Long.valueOf(table.getValueAt(row, 6).toString()).longValue() == 0) {
                cell.setBackground(new Color(177, 251, 177));
            } else {
                cell.setBackground(Color.WHITE);
            }
            return cell;
        }
    }
}
