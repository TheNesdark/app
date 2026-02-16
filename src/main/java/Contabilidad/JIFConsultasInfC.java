package Contabilidad;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Contabilidad/JIFConsultasInfC.class */
public class JIFConsultasInfC extends JInternalFrame {
    private ConsultasMySQL xct = new ConsultasMySQL();
    private Metodos xmt = new Metodos();
    private DefaultTableModel xmodelo;
    private DefaultTableModel xmodelo1;
    private Object[] xdatos;
    private String[] xidbodega;
    private String xname;
    private String xsql;
    private String xcc_documentoc;
    private ButtonGroup JBGSeleccion;
    private ButtonGroup JBGSeleccion1;
    private JButton JBTGenerar;
    private JDateChooser JDFechaF;
    private JDateChooser JDFechaI;
    private JPanel JPIDTercero;
    private JPanel JPIDatos;
    private JPanel JPIImpresion;
    private JPanel JPIPresentacion;
    private JPanel JPITipoMovi;
    private JRadioButton JRBActivo;
    private JRadioButton JRBConsolidada;
    private JRadioButton JRBCuentaCobro;
    private JRadioButton JRBDetallada;
    private JRadioButton JRBInactivo;
    private JRadioButton JRBRadicacion;
    private JScrollPane JSPDetalle;
    private JScrollPane JSPDetalle1;
    private JTable JTDetalle;
    private JTable JTDetalle1;
    private JFormattedTextField JTFFTotalizarR;
    private JTextField JTFRuta;
    private JTabbedPane JTPDatos;

    public JIFConsultasInfC(String xname) {
        initComponents();
        setName(xname);
        this.JDFechaI.setDate(this.xmt.getFechaActual());
        this.JDFechaF.setDate(this.xmt.getFechaActual());
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
        this.xname = xname;
        if (Principal.xclase.getxForma_Gn_Niif() == 1) {
            this.xcc_documentoc = "cc_documentoc_niif";
        } else {
            this.xcc_documentoc = "cc_documentoc";
        }
        mCrearModeloDatos();
    }

    /* JADX WARN: Type inference failed for: r3v66, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v70, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGSeleccion = new ButtonGroup();
        this.JBGSeleccion1 = new ButtonGroup();
        this.JPIDatos = new JPanel();
        this.JDFechaI = new JDateChooser();
        this.JDFechaF = new JDateChooser();
        this.JPIPresentacion = new JPanel();
        this.JRBConsolidada = new JRadioButton();
        this.JRBDetallada = new JRadioButton();
        this.JPITipoMovi = new JPanel();
        this.JRBRadicacion = new JRadioButton();
        this.JRBCuentaCobro = new JRadioButton();
        this.JTFFTotalizarR = new JFormattedTextField();
        this.JTFRuta = new JTextField();
        this.JBTGenerar = new JButton();
        this.JTPDatos = new JTabbedPane();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JPIDTercero = new JPanel();
        this.JSPDetalle1 = new JScrollPane();
        this.JTDetalle1 = new JTable();
        this.JPIImpresion = new JPanel();
        this.JRBActivo = new JRadioButton();
        this.JRBInactivo = new JRadioButton();
        setClosable(true);
        setIconifiable(true);
        setTitle("INFORMES");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setMaximumSize(null);
        setMinimumSize(null);
        setName("jifconsultarinformesi");
        try {
            setSelected(true);
        } catch (PropertyVetoException e1) {
            e1.printStackTrace();
        }
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JDFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicial", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFechaI.setFont(new Font("Arial", 1, 13));
        this.JDFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Final", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFechaF.setFont(new Font("Arial", 1, 13));
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
        JPIPresentacionLayout.setHorizontalGroup(JPIPresentacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIPresentacionLayout.createSequentialGroup().addComponent(this.JRBConsolidada).addGap(18, 18, 18).addComponent(this.JRBDetallada).addContainerGap(17, 32767)));
        JPIPresentacionLayout.setVerticalGroup(JPIPresentacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIPresentacionLayout.createSequentialGroup().addGroup(JPIPresentacionLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBConsolidada).addComponent(this.JRBDetallada)).addContainerGap(-1, 32767)));
        this.JPITipoMovi.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo de Movimiento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBGSeleccion.add(this.JRBRadicacion);
        this.JRBRadicacion.setFont(new Font("Arial", 1, 12));
        this.JRBRadicacion.setSelected(true);
        this.JRBRadicacion.setText("Radicación");
        this.JBGSeleccion.add(this.JRBCuentaCobro);
        this.JRBCuentaCobro.setFont(new Font("Arial", 1, 12));
        this.JRBCuentaCobro.setText("Cuenta Cobro");
        GroupLayout JPITipoMoviLayout = new GroupLayout(this.JPITipoMovi);
        this.JPITipoMovi.setLayout(JPITipoMoviLayout);
        JPITipoMoviLayout.setHorizontalGroup(JPITipoMoviLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPITipoMoviLayout.createSequentialGroup().addContainerGap().addComponent(this.JRBRadicacion).addGap(18, 18, 18).addComponent(this.JRBCuentaCobro).addContainerGap(-1, 32767)));
        JPITipoMoviLayout.setVerticalGroup(JPITipoMoviLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPITipoMoviLayout.createSequentialGroup().addGroup(JPITipoMoviLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBRadicacion).addComponent(this.JRBCuentaCobro)).addContainerGap(-1, 32767)));
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JDFechaI, -2, 120, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JDFechaF, -2, 120, -2).addGap(31, 31, 31).addComponent(this.JPIPresentacion, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JPITipoMovi, -2, -1, -2).addContainerGap(20, 32767)));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPITipoMovi, -2, -1, -2).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JDFechaF, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.JDFechaI, GroupLayout.Alignment.LEADING, -1, -1, 32767)).addComponent(this.JPIPresentacion, -2, -1, -2)).addContainerGap(-1, 32767)));
        this.JTFFTotalizarR.setBorder(BorderFactory.createTitledBorder((Border) null, "Total", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFTotalizarR.setHorizontalAlignment(4);
        this.JTFFTotalizarR.setFont(new Font("Arial", 1, 13));
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("c:\\\\genoma\\\\plantilla.xls");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ruta", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBTGenerar.setFont(new Font("Arial", 1, 12));
        this.JBTGenerar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTGenerar.setText("Exportar");
        this.JBTGenerar.addActionListener(new ActionListener() { // from class: Contabilidad.JIFConsultasInfC.1
            public void actionPerformed(ActionEvent evt) {
                JIFConsultasInfC.this.JBTGenerarActionPerformed(evt);
            }
        });
        this.JTPDatos.setForeground(Color.red);
        this.JTPDatos.setFont(new Font("Arial", 1, 14));
        this.JSPDetalle.setBorder((Border) null);
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.JTPDatos.addTab("DETALLE", this.JSPDetalle);
        this.JSPDetalle1.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTDetalle1.setFont(new Font("Arial", 1, 12));
        this.JTDetalle1.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle1.setRowHeight(25);
        this.JSPDetalle1.setViewportView(this.JTDetalle1);
        this.JPIImpresion.setBorder(BorderFactory.createTitledBorder((Border) null, "Impresión", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JRBActivo.setFont(new Font("Arial", 1, 12));
        this.JRBActivo.setText("Inactivos");
        this.JRBActivo.addActionListener(new ActionListener() { // from class: Contabilidad.JIFConsultasInfC.2
            public void actionPerformed(ActionEvent evt) {
                JIFConsultasInfC.this.JRBActivoActionPerformed(evt);
            }
        });
        this.JRBInactivo.setFont(new Font("Arial", 1, 12));
        this.JRBInactivo.setText("Activos");
        GroupLayout JPIImpresionLayout = new GroupLayout(this.JPIImpresion);
        this.JPIImpresion.setLayout(JPIImpresionLayout);
        JPIImpresionLayout.setHorizontalGroup(JPIImpresionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIImpresionLayout.createSequentialGroup().addGap(26, 26, 26).addComponent(this.JRBInactivo).addGap(29, 29, 29).addComponent(this.JRBActivo).addContainerGap(27, 32767)));
        JPIImpresionLayout.setVerticalGroup(JPIImpresionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIImpresionLayout.createSequentialGroup().addGroup(JPIImpresionLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBInactivo).addComponent(this.JRBActivo)).addContainerGap(-1, 32767)));
        GroupLayout JPIDTerceroLayout = new GroupLayout(this.JPIDTercero);
        this.JPIDTercero.setLayout(JPIDTerceroLayout);
        JPIDTerceroLayout.setHorizontalGroup(JPIDTerceroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDTerceroLayout.createSequentialGroup().addContainerGap().addGroup(JPIDTerceroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPDetalle1, -2, 769, -2).addComponent(this.JPIImpresion, -2, -1, -2)).addContainerGap(-1, 32767)));
        JPIDTerceroLayout.setVerticalGroup(JPIDTerceroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDTerceroLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPDetalle1, -2, 283, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPIImpresion, -1, -1, 32767).addContainerGap()));
        this.JTPDatos.addTab("TERCEROS CONSOLIDADO", this.JPIDTercero);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGap(9, 9, 9).addComponent(this.JTFRuta, -2, 280, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTGenerar, -2, 248, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JTFFTotalizarR, -2, 166, -2)).addComponent(this.JPIDatos, -1, -1, 32767).addComponent(this.JTPDatos, -2, 0, 32767)).addContainerGap(29, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTPDatos, -2, 388, -2).addGap(18, 18, 32767).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.JTFFTotalizarR, -2, 50, -2)).addComponent(this.JTFRuta, GroupLayout.Alignment.TRAILING).addComponent(this.JBTGenerar, -1, -1, 32767)).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTGenerarActionPerformed(ActionEvent evt) {
        if (this.JTPDatos.getSelectedIndex() == 0) {
            this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTDetalle, this.JTFRuta.getText(), getTitle());
        } else if (this.JTPDatos.getSelectedIndex() == 1) {
            this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTDetalle1, this.JTFRuta.getText(), getTitle());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBActivoActionPerformed(ActionEvent evt) {
    }

    public void mBuscar() {
        if (this.xname.equals("jifconsultarinformesc") || this.xname.equals("jifconsultarinformesc1")) {
            if (this.JRBRadicacion.isSelected() && this.JRBConsolidada.isSelected()) {
                String sql = "SELECT cc_conceptocmsa.Nbre, ROUND(SUM(cc_radicacion.SubTotal+cc_radicacion.Iva+cc_radicacion.Flete+ cc_radicacion.Otros)) AS Total     \nFROM cc_conceptocmsa INNER JOIN cc_radicacion  ON (cc_conceptocmsa.Id = cc_radicacion.Id_Concepto)\n INNER JOIN cc_terceros ON (cc_radicacion.Id_Proveedor = cc_terceros.Id) \n LEFT JOIN `cc_documentoc` ON (cc_radicacion.`Id`= cc_documentoc.`Id_Radicacion`) \n LEFT JOIN `cc_cuentacobro` ON (cc_cuentacobro.`Id`= cc_documentoc.`Id_CuentaCobro`)\n  LEFT JOIN `f_factura_evento` ON (f_factura_evento.`No_FacturaEvento`= cc_cuentacobro.`NFactura_Evento`) \n   WHERE (cc_radicacion.Fecha >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND cc_documentoc.`Estado`=1 AND cc_radicacion.Estado =1\n    AND cc_radicacion.Fecha <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "') \n    GROUP BY cc_conceptocmsa.Nbre\n    ORDER BY cc_conceptocmsa.Nbre ASC  ";
                mCargarDatosTabla1(sql);
                return;
            }
            if (this.JRBRadicacion.isSelected() && this.JRBDetallada.isSelected()) {
                String sql2 = "SELECT cc_radicacion.Id, DATE_FORMAT(cc_radicacion.Fecha,'%d-%m-%Y') AS Fecha, cc_terceros.RazonSocialCompleta, cc_conceptocmsa.Nbre ,  ROUND(SUM(cc_radicacion.SubTotal+cc_radicacion.Iva+cc_radicacion.Flete+ cc_radicacion.Otros)) AS Total, cc_radicacion.NoFactura, cc_radicacion.ConceptoC, if(cc_radicacion.Tipo=0,'REEMBOLSABLE',IF(cc_radicacion.Tipo=1,'EXCEDENTE', 'RECURSOS PROPIOS')) AS tIPO, IF(cc_cuentacobro.`NFactura_Evento` IS NULL, 0,   IF(f_factura_evento.`Prefijo`='', f_factura_evento.`No_FacturaEvento`, CONCAT(f_factura_evento.`Prefijo`,'-',f_factura_evento.`No_FacturaEvento`) )) AS NFactura , `" + this.xcc_documentoc + "`.`Id_CuentaCobro`    FROM cc_conceptocmsa INNER JOIN cc_radicacion  ON (cc_conceptocmsa.Id = cc_radicacion.Id_Concepto) INNER JOIN cc_terceros ON (cc_radicacion.Id_Proveedor = cc_terceros.Id) LEFT JOIN `" + this.xcc_documentoc + "` ON (cc_radicacion.`Id`= " + this.xcc_documentoc + ".`Id_Radicacion`) LEFT JOIN `cc_cuentacobro` ON (cc_cuentacobro.`Id`= " + this.xcc_documentoc + ".`Id_CuentaCobro`) LEFT JOIN `f_factura_evento` ON (f_factura_evento.`No_FacturaEvento`= cc_cuentacobro.`NFactura_Evento`)  WHERE (cc_radicacion.Fecha >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND " + this.xcc_documentoc + ".`Estado`=1 AND cc_radicacion.Estado =1 AND cc_radicacion.Fecha <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "') GROUP BY cc_radicacion.Id ORDER BY cc_terceros.RazonSocialCompleta ASC, cc_radicacion.Fecha ASC ";
                mCargarDatosTabla(sql2);
                mCrearVistaTercero();
            } else if (this.JRBCuentaCobro.isSelected() && this.JRBConsolidada.isSelected()) {
                String sql3 = "SELECT cc_conceptocmsa.Nbre,  ROUND(SUM(cc_detalle_cuentacobro.Valor)) FROM cc_detalle_cuentacobro INNER JOIN g_empresa ON (cc_detalle_cuentacobro.Id_Tercero = g_empresa.Id) INNER JOIN cc_cuentacobro ON (cc_detalle_cuentacobro.Id_cuentacobro = cc_cuentacobro.Id) INNER JOIN cc_conceptocmsa ON (cc_detalle_cuentacobro.Id_Concepto = cc_conceptocmsa.Id) WHERE (cc_cuentacobro.FechaC >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND cc_cuentacobro.FechaC <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' AND cc_cuentacobro.Estado =1) GROUP BY cc_conceptocmsa.Nbre ORDER BY cc_conceptocmsa.Nbre ASC ";
                mCargarDatosTabla1(sql3);
            } else if (this.JRBCuentaCobro.isSelected() && this.JRBDetallada.isSelected()) {
                String sql4 = "SELECT cc_cuentacobro.Id , cc_cuentacobro.FechaC , cc_terceros.RazonSocialCompleta , cc_conceptocmsa.Nbre , cc_detalle_cuentacobro.Valor, '' as Nfac FROM cc_detalle_cuentacobro INNER JOIN cc_terceros  ON (cc_detalle_cuentacobro.Id_Tercero = cc_terceros.Id) INNER JOIN cc_cuentacobro  ON (cc_detalle_cuentacobro.Id_cuentacobro = cc_cuentacobro.Id) INNER JOIN cc_conceptocmsa  ON (cc_detalle_cuentacobro.Id_Concepto = cc_conceptocmsa.Id) WHERE (cc_cuentacobro.FechaC >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND cc_cuentacobro.FechaC <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' AND cc_cuentacobro.Estado =1) ORDER BY cc_cuentacobro.Id ASC, cc_terceros.RazonSocialCompleta ASC, cc_cuentacobro.FechaC ASC ";
                mCargarDatosTabla(sql4);
            }
        }
    }

    public void mNuevo() {
        this.JDFechaI.setDate(this.xmt.getFechaActual());
        this.JDFechaF.setDate(this.xmt.getFechaActual());
        mCrearModeloDatos();
        Principal.txtNo.setText("");
        this.JDFechaI.requestFocus();
    }

    public void mImprimir() {
        if (this.JTDetalle1.getRowCount() != -1) {
            String[][] parametros = new String[3][2];
            parametros[0][0] = "id";
            parametros[0][1] = Principal.txtNo.getText();
            parametros[1][0] = "SUBREPORT_DIR";
            parametros[1][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
            parametros[2][0] = "SUBREPORTFIRMA_DIR";
            parametros[2][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
            if (this.JRBActivo.isSelected() && !this.JRBInactivo.isSelected()) {
                this.xmt.GenerarPDF(this.xmt.getRutaRep() + "CC_Relacion_Tercero", parametros);
            } else if (this.JRBActivo.isSelected() && this.JRBInactivo.isSelected()) {
                this.xmt.GenerarPDF(this.xmt.getRutaRep() + "CC_Relacion_Tercero_Inactivos", parametros);
                this.xmt.GenerarPDF(this.xmt.getRutaRep() + "CC_Relacion_Tercero", parametros);
            } else if (!this.JRBActivo.isSelected() && this.JRBInactivo.isSelected()) {
                this.xmt.GenerarPDF(this.xmt.getRutaRep() + "CC_Relacion_Tercero_Inactivos", parametros);
            }
            this.xct.cerrarConexionBd();
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Fecha", "Empresa", "Concepto", "Valor", "NFactura", "Descripcion", "Tipo", "N° Factura"}) { // from class: Contabilidad.JIFConsultasInfC.3
            Class[] types = {Long.class, String.class, String.class, String.class, Double.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTDetalle;
        JTable jTable2 = this.JTDetalle;
        jTable.setAutoResizeMode(0);
        this.JTDetalle.doLayout();
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(100);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos1() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Concepto", "Valor"}) { // from class: Contabilidad.JIFConsultasInfC.4
            Class[] types = {String.class, Double.class};
            boolean[] canEdit = {false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTDetalle;
        JTable jTable2 = this.JTDetalle;
        jTable.setAutoResizeMode(0);
        this.JTDetalle.doLayout();
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(600);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(200);
    }

    private void mCargarDatosTabla(String xsql) {
        try {
            mCrearModeloDatos();
            double xvalor = 0.0d;
            ResultSet xrs = this.xct.traerRs(xsql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(1)), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelo.setValueAt(xrs.getString(4), n, 3);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(5)), n, 4);
                    this.xmodelo.setValueAt(xrs.getString(6), n, 5);
                    this.xmodelo.setValueAt(xrs.getString(7), n, 6);
                    this.xmodelo.setValueAt(xrs.getString(8), n, 7);
                    this.xmodelo.setValueAt(xrs.getString(9), n, 8);
                    xvalor += xrs.getDouble(5);
                    n++;
                }
            }
            this.JTFFTotalizarR.setValue(Double.valueOf(xvalor));
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFConsultasInfC.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarDatosTabla1(String xsql) {
        try {
            mCrearModeloDatos1();
            double xvalor = 0.0d;
            ResultSet xrs = this.xct.traerRs(xsql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(xrs.getString(1), n, 0);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(2)), n, 1);
                    xvalor += xrs.getDouble(2);
                    n++;
                }
            }
            this.JTFFTotalizarR.setValue(Double.valueOf(xvalor));
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFConsultasInfC.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCrearVistaTercero() {
        this.xsql = "DROP VIEW IF EXISTS cc_v_tmp_tercero";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "CREATE VIEW  `cc_v_tmp_tercero`  AS SELECT cc_terceros.`Id`, cc_terceros.`TDCompleto`, cc_terceros.`RazonSocialCompleta`, cc_terceros.`NDepartamento`, cc_terceros.`NMunicipio`, cc_terceros.`Direccion`, cc_terceros.`Tel_Numero`, cc_terceros.`Correo`, \n ROUND(SUM(cc_radicacion.SubTotal+cc_radicacion.Iva+cc_radicacion.Flete+ cc_radicacion.Otros)) AS Total       \nFROM cc_conceptocmsa INNER JOIN cc_radicacion  ON (cc_conceptocmsa.Id = cc_radicacion.Id_Concepto)\n INNER JOIN cc_terceros ON (cc_radicacion.Id_Proveedor = cc_terceros.Id) \n LEFT JOIN `cc_documentoc` ON (cc_radicacion.`Id`= cc_documentoc.`Id_Radicacion`) \n LEFT JOIN `cc_cuentacobro` ON (cc_cuentacobro.`Id`= cc_documentoc.`Id_CuentaCobro`)\n  LEFT JOIN `f_factura_evento` ON (f_factura_evento.`No_FacturaEvento`= cc_cuentacobro.`NFactura_Evento`) \n   WHERE (cc_radicacion.Fecha >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND cc_documentoc.`Estado`=1 AND cc_radicacion.Estado =1\n    AND cc_radicacion.Fecha <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "') \n     GROUP BY cc_terceros.Id \n    ORDER BY cc_terceros.RazonSocialCompleta ASC, cc_radicacion.Fecha ASC";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "update g_empresa set VCompraP=0";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "update g_empresa,cc_v_tmp_tercero  set VCompraP=cc_v_tmp_tercero.Total where cc_v_tmp_tercero.Id=g_empresa.Id";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "SELECT cc_terceros.`TDCompleto`, cc_terceros.`RazonSocialCompleta`, cc_terceros.`NDepartamento`, cc_terceros.`NMunicipio`, cc_terceros.`Direccion`, cc_terceros.`Tel_Numero`, cc_terceros.`Correo`, \n ROUND(SUM(cc_radicacion.SubTotal+cc_radicacion.Iva+cc_radicacion.Flete+ cc_radicacion.Otros)) AS Total       \nFROM cc_conceptocmsa INNER JOIN cc_radicacion  ON (cc_conceptocmsa.Id = cc_radicacion.Id_Concepto)\n INNER JOIN cc_terceros ON (cc_radicacion.Id_Proveedor = cc_terceros.Id) \n LEFT JOIN `cc_documentoc` ON (cc_radicacion.`Id`= cc_documentoc.`Id_Radicacion`) \n LEFT JOIN `cc_cuentacobro` ON (cc_cuentacobro.`Id`= cc_documentoc.`Id_CuentaCobro`)\n  LEFT JOIN `f_factura_evento` ON (f_factura_evento.`No_FacturaEvento`= cc_cuentacobro.`NFactura_Evento`) \n   WHERE (cc_radicacion.Fecha >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND cc_documentoc.`Estado`=1 AND cc_radicacion.Estado =1\n    AND cc_radicacion.Fecha <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "') \n     GROUP BY cc_terceros.Id \n    ORDER BY cc_terceros.RazonSocialCompleta ASC, cc_radicacion.Fecha ASC";
        mCargarDatosTablaDetalle(this.xsql);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatosDetalle() {
        this.xmodelo1 = new DefaultTableModel(new Object[0], new String[]{"Documento", "Razon Social", "Departamento", "Municipio", "Direccion", "Telefono", "Correo", "Valor"}) { // from class: Contabilidad.JIFConsultasInfC.5
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, Double.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTDetalle1;
        JTable jTable2 = this.JTDetalle;
        jTable.setAutoResizeMode(0);
        this.JTDetalle1.doLayout();
        this.JTDetalle1.setModel(this.xmodelo1);
        this.JTDetalle1.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTDetalle1.getColumnModel().getColumn(1).setPreferredWidth(400);
        this.JTDetalle1.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTDetalle1.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTDetalle1.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTDetalle1.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTDetalle1.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTDetalle1.getColumnModel().getColumn(7).setPreferredWidth(100);
    }

    private void mCargarDatosTablaDetalle(String xsql) {
        try {
            mCrearModeloDatosDetalle();
            ResultSet xrs = this.xct.traerRs(xsql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo1.addRow(this.xdatos);
                    this.xmodelo1.setValueAt(xrs.getString(1), n, 0);
                    this.xmodelo1.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo1.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelo1.setValueAt(xrs.getString(4), n, 3);
                    this.xmodelo1.setValueAt(xrs.getString(5), n, 4);
                    this.xmodelo1.setValueAt(xrs.getString(6), n, 5);
                    this.xmodelo1.setValueAt(xrs.getString(7), n, 6);
                    this.xmodelo1.setValueAt(Double.valueOf(xrs.getDouble(8)), n, 7);
                    n++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFConsultasInfC.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }
}
