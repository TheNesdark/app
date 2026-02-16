package Caja;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.JTextFieldValidator;
import Utilidades.Metodos;
import Utilidades.convertirNumerosLetras;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

/* JADX INFO: loaded from: GenomaP.jar:Caja/JIFConsultarRecibosC.class */
public class JIFConsultarRecibosC extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private DefaultTableModel xmodeloB;
    private String xnombre;
    private String xsql;
    private String[] xid;
    private Object[] xdato;
    private JButton JBTExportar;
    private JCheckBox JCHFiltro;
    private JCheckBox JCHFiltro1;
    private JCheckBox JCH_SinFiltros;
    private JDateChooser JDFechaF;
    private JDateChooser JDFechaI;
    private JPanel JPIDatosExportacion;
    private JScrollPane JSPDetalle;
    private JScrollPane JSPDetalle1;
    public JTable JTDetalle;
    public JTable JTDetalle1;
    private JTextFieldValidator JTFDocumento;
    private JFormattedTextField JTFF_Totales;
    private JTextFieldValidator JTFNombre;
    private JTextField JTFRuta;
    private JTabbedPane JTPTablas;
    private JPanel jPanel1;
    private Metodos xmt = new Metodos();
    private ConsultasMySQL xct = new ConsultasMySQL();

    public JIFConsultarRecibosC(String xnombre) {
        initComponents();
        setName(xnombre);
        mNuevo();
        this.JCH_SinFiltros.setVisible(false);
    }

    /* JADX WARN: Type inference failed for: r3v61, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v66, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jPanel1 = new JPanel();
        this.JDFechaI = new JDateChooser();
        this.JDFechaF = new JDateChooser();
        this.JTFDocumento = new JTextFieldValidator();
        this.JTFNombre = new JTextFieldValidator();
        this.JCHFiltro = new JCheckBox();
        this.JCHFiltro1 = new JCheckBox();
        this.JCH_SinFiltros = new JCheckBox();
        this.JPIDatosExportacion = new JPanel();
        this.JTFRuta = new JTextField();
        this.JBTExportar = new JButton();
        this.JTFF_Totales = new JFormattedTextField();
        this.JTPTablas = new JTabbedPane();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JSPDetalle1 = new JScrollPane();
        this.JTDetalle1 = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("RECIBOS DE CAJA");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjifconsultar_reciboc");
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS PARA CONSULTA", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JDFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicial", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFechaI.setFont(new Font("Arial", 1, 12));
        this.JDFechaI.addPropertyChangeListener(new PropertyChangeListener() { // from class: Caja.JIFConsultarRecibosC.1
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFConsultarRecibosC.this.JDFechaIPropertyChange(evt);
            }
        });
        this.JDFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Final", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFechaF.setFont(new Font("Arial", 1, 12));
        this.JTFDocumento.setBorder(BorderFactory.createTitledBorder((Border) null, "Doc. Identidad", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFDocumento.setFont(new Font("Arial", 1, 12));
        this.JTFNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Datos del Usuario", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFNombre.setFont(new Font("Arial", 1, 12));
        this.JTFNombre.addActionListener(new ActionListener() { // from class: Caja.JIFConsultarRecibosC.2
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarRecibosC.this.JTFNombreActionPerformed(evt);
            }
        });
        this.JCHFiltro.setFont(new Font("Arial", 1, 12));
        this.JCHFiltro.setText("Filtro?");
        this.JCHFiltro.setToolTipText("Filtro por usuario");
        this.JCHFiltro1.setFont(new Font("Arial", 1, 12));
        this.JCHFiltro1.setForeground(Color.red);
        this.JCHFiltro1.setText("Anulados?");
        this.JCHFiltro1.setToolTipText("Consultar Recibos Anulados");
        this.JCH_SinFiltros.setFont(new Font("Arial", 1, 12));
        this.JCH_SinFiltros.setText("Sin filtros(Sede, caja)");
        this.JCH_SinFiltros.setToolTipText("Filtro por usuario");
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHFiltro1).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JDFechaI, -2, 120, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JDFechaF, -2, 120, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFDocumento, -2, 146, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFNombre, -2, 339, -2).addGap(18, 18, 18).addComponent(this.JCHFiltro).addGap(37, 37, 37).addComponent(this.JCH_SinFiltros))).addContainerGap(-1, 32767)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFDocumento, -2, 50, -2).addComponent(this.JTFNombre, -2, 50, -2)).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JDFechaI, -2, 50, -2).addComponent(this.JDFechaF, -2, 50, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JCHFiltro1).addContainerGap()).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addContainerGap(-1, 32767).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCHFiltro).addComponent(this.JCH_SinFiltros)).addGap(34, 34, 34)));
        this.JPIDatosExportacion.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS PARA LA EXPORTACIÓN", 0, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma\\Plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ruta", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: Caja.JIFConsultarRecibosC.3
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarRecibosC.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: Caja.JIFConsultarRecibosC.4
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarRecibosC.this.JBTExportarActionPerformed(evt);
            }
        });
        GroupLayout JPIDatosExportacionLayout = new GroupLayout(this.JPIDatosExportacion);
        this.JPIDatosExportacion.setLayout(JPIDatosExportacionLayout);
        JPIDatosExportacionLayout.setHorizontalGroup(JPIDatosExportacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosExportacionLayout.createSequentialGroup().addContainerGap().addComponent(this.JTFRuta, -2, 511, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTExportar, -2, 128, -2).addContainerGap(-1, 32767)));
        JPIDatosExportacionLayout.setVerticalGroup(JPIDatosExportacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosExportacionLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosExportacionLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFRuta, -2, 50, -2).addComponent(this.JBTExportar, -2, 50, -2)).addContainerGap(-1, 32767)));
        this.JTFF_Totales.setBorder(BorderFactory.createTitledBorder((Border) null, "TOTAL", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JTFF_Totales.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFF_Totales.setHorizontalAlignment(4);
        this.JTFF_Totales.setFont(new Font("Arial", 1, 14));
        this.JTPTablas.setForeground(Color.red);
        this.JTPTablas.setFont(new Font("Arial", 1, 14));
        this.JTDetalle.setBorder(BorderFactory.createBevelBorder(0));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalle.setEditingColumn(1);
        this.JTDetalle.setEditingRow(1);
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: Caja.JIFConsultarRecibosC.5
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarRecibosC.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.JTPTablas.addTab("Modelo A", this.JSPDetalle);
        this.JTDetalle1.setBorder(BorderFactory.createBevelBorder(0));
        this.JTDetalle1.setFont(new Font("Arial", 1, 12));
        this.JTDetalle1.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalle1.setEditingColumn(1);
        this.JTDetalle1.setEditingRow(1);
        this.JTDetalle1.setRowHeight(25);
        this.JTDetalle1.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle1.setSelectionForeground(Color.red);
        this.JTDetalle1.addMouseListener(new MouseAdapter() { // from class: Caja.JIFConsultarRecibosC.6
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarRecibosC.this.JTDetalle1MouseClicked(evt);
            }
        });
        this.JSPDetalle1.setViewportView(this.JTDetalle1);
        this.JTPTablas.addTab("Modelo B", this.JSPDetalle1);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JTPTablas).addComponent(this.jPanel1, GroupLayout.Alignment.LEADING, -1, -1, 32767).addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup().addComponent(this.JPIDatosExportacion, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JTFF_Totales, -2, 181, -2))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTPTablas, -1, 319, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.JPIDatosExportacion, -2, -1, -2).addContainerGap()).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.JTFF_Totales, -2, 65, -2).addGap(19, 19, 19)))));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaIPropertyChange(PropertyChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1 && evt.getClickCount() == 2) {
            new convertirNumerosLetras();
            this.xmt.mConvertirNumeroLetras(this.JTDetalle.getValueAt(this.JTDetalle.getSelectedRow(), 5).toString());
            Principal.clasecaja.imprimirRecibo(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString(), this.JTDetalle.getValueAt(this.JTDetalle.getSelectedRow(), 5).toString() + "00", this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 12).toString(), this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNombreActionPerformed(ActionEvent evt) {
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
        if (!this.JTFRuta.getText().isEmpty()) {
            if (this.JTPTablas.getSelectedIndex() == 0) {
                if (this.JTDetalle.getRowCount() > 0) {
                    int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    if (x == 0) {
                        this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTDetalle, this.JTFRuta.getText(), getTitle());
                        return;
                    }
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "No existe información para exportar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                return;
            }
            if (this.JTDetalle1.getRowCount() > 0) {
                int x2 = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (x2 == 0) {
                    this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTDetalle1, this.JTFRuta.getText(), getTitle());
                    return;
                }
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "No existe información para exportar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un ruta valida", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JTFRuta.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalle1MouseClicked(MouseEvent evt) {
    }

    public void mBuscar() {
        if (this.JCHFiltro1.isSelected()) {
            this.xsql = "SELECT `k_recibos`.`Id`, `k_recibos`.`NoRecibo`, `k_recibos`.`Fecha_Recibo`, `k_recibos`.`Identificacion`, `k_recibos`.`Nbre_Paciente`, SUM((`k_itemrecibos`.`Cantidad`*`k_itemrecibos`.`VrUnitario`)) AS `ValorR` , `k_formapago`.`Nbre` , `k_recibos`.`Estado` , IF(`k_recibos`.`ObservacionAnulado` IS NULL, '', `k_recibos`.`ObservacionAnulado`) AS Observacion, `k_recibos`.`Id_cierre`, `k_caja`.`Nbre` AS Caja, IF(`rh_tipo_persona_cargon`.`Id` IS NULL, `k_recibos`.`UsuarioS`, CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2` ,' ', `g_persona`.`Nombre1` ,' ',`g_persona`.`Nombre2`)) AS Cajero, `k_caja`.`Id` AS IdCaja, k_recibos.`NoFactura` NFactura, f_empresacontxconvenio.`Nbre` NConvenio, GROUP_CONCAT(k_conceptos.`Nbre` SEPARATOR '-')  NConcepto \nFROM  `k_itemrecibos` INNER JOIN `k_recibos`  ON (`k_itemrecibos`.`Id_Recibo` = `k_recibos`.`Id`) INNER JOIN `k_itemformapago`  ON (`k_itemformapago`.`Id_Recibo` = `k_recibos`.`Id`) \nINNER JOIN  `k_formapago`  ON (`k_itemformapago`.`Id_FormaPago` = `k_formapago`.`Id`) INNER JOIN  `k_conceptos` ON (`k_conceptos`.`Id` = `k_itemrecibos`.`Id_Concepto`) INNER JOIN `k_caja`  ON (`k_recibos`.`Id_Caja` = `k_caja`.`Id`) LEFT JOIN  `rh_tipo_persona_cargon` ON (`rh_tipo_persona_cargon`.`Id` = `k_recibos`.`Id_UsuarioS`) LEFT JOIN `g_persona`  ON (`rh_tipo_persona_cargon`.`Id_Persona` = `g_persona`.`Id`) LEFT JOIN f_empresacontxconvenio ON (f_empresacontxconvenio.`Id`= k_recibos.`Id_EmpresaContxConv`)\nWHERE (DATE_FORMAT(`k_recibos`.`Fecha_Recibo`,'%Y-%m-%d') >='" + this.xmt.formatoAMD1.format(this.JDFechaI.getDate()) + "' AND DATE_FORMAT(`k_recibos`.`Fecha_Recibo`,'%Y-%m-%d') <='" + this.xmt.formatoAMD1.format(this.JDFechaF.getDate()) + "' AND `k_recibos`.`Estado` <>0) GROUP BY `k_recibos`.`Id`, `k_recibos`.`NoRecibo` ORDER BY `k_recibos`.`Fecha_Recibo` DESC, `k_recibos`.`NoRecibo` DESC ";
            mCargarDatosDetalle();
        } else if (this.JCHFiltro.isSelected()) {
            if (!this.JTFDocumento.getText().isEmpty()) {
                this.xsql = "SELECT `k_recibos`.`Id`, `k_recibos`.`NoRecibo`, `k_recibos`.`Fecha_Recibo`, `k_recibos`.`Identificacion`, `k_recibos`.`Nbre_Paciente`, (IF(`k_recibos`.`Estado` =0,SUM((`k_itemrecibos`.`Cantidad`*`k_itemrecibos`.`VrUnitario`))-k_recibos.`Descuento`, 0)) AS `ValorR` , `k_formapago`.`Nbre` , `k_recibos`.`Estado` , IF(`k_recibos`.`ObservacionAnulado` IS NULL, '', `k_recibos`.`ObservacionAnulado`) AS Observacion, `k_recibos`.`Id_cierre`, `k_caja`.`Nbre` AS Caja, IF(`rh_tipo_persona_cargon`.`Id` IS NULL, `k_recibos`.`UsuarioS`, CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2` ,' ', `g_persona`.`Nombre1` ,' ',`g_persona`.`Nombre2`)) AS Cajero, `k_caja`.`Id`  AS IdCaja, k_recibos.`NoFactura` NFactura, f_empresacontxconvenio.`Nbre` NConvenio, GROUP_CONCAT(k_conceptos.`Nbre` SEPARATOR '-')  NConcepto \nFROM  `k_itemrecibos` INNER JOIN `k_recibos`  ON (`k_itemrecibos`.`Id_Recibo` = `k_recibos`.`Id`) INNER JOIN `k_itemformapago`  ON (`k_itemformapago`.`Id_Recibo` = `k_recibos`.`Id`) \nINNER JOIN  `k_formapago`  ON (`k_itemformapago`.`Id_FormaPago` = `k_formapago`.`Id`) INNER JOIN  `k_conceptos` ON (`k_conceptos`.`Id` = `k_itemrecibos`.`Id_Concepto`) INNER JOIN `k_caja`  ON (`k_recibos`.`Id_Caja` = `k_caja`.`Id`) LEFT JOIN  `rh_tipo_persona_cargon` ON (`rh_tipo_persona_cargon`.`Id` = `k_recibos`.`Id_UsuarioS`) LEFT JOIN `g_persona`  ON (`rh_tipo_persona_cargon`.`Id_Persona` = `g_persona`.`Id`) LEFT JOIN f_empresacontxconvenio ON (f_empresacontxconvenio.`Id`= k_recibos.`Id_EmpresaContxConv`) \nWHERE (`k_recibos`.`Identificacion` LIKE '" + this.JTFDocumento.getText() + "%' AND DATE_FORMAT(`k_recibos`.`Fecha_Recibo`,'%Y-%m-%d') >='" + this.xmt.formatoAMD1.format(this.JDFechaI.getDate()) + "' AND DATE_FORMAT(`k_recibos`.`Fecha_Recibo`,'%Y-%m-%d') <='" + this.xmt.formatoAMD1.format(this.JDFechaF.getDate()) + "') GROUP BY `k_recibos`.`Id`, `k_recibos`.`NoRecibo` ORDER BY `k_recibos`.`Fecha_Recibo` DESC, `k_recibos`.`NoRecibo` DESC ";
                mCargarDatosDetalle();
            }
        } else {
            this.xsql = "SELECT `k_recibos`.`Id`, `k_recibos`.`NoRecibo`, `k_recibos`.`Fecha_Recibo`, `k_recibos`.`Identificacion`, `k_recibos`.`Nbre_Paciente`,  (IF(`k_recibos`.`Estado` =0,SUM((`k_itemrecibos`.`Cantidad`*`k_itemrecibos`.`VrUnitario`))-k_recibos.`Descuento`, 0)) AS `ValorR` , `k_formapago`.`Nbre` , `k_recibos`.`Estado` , IF(`k_recibos`.`ObservacionAnulado` IS NULL, '', `k_recibos`.`ObservacionAnulado`) AS Observacion, `k_recibos`.`Id_cierre`, `k_caja`.`Nbre` AS Caja, IF(`rh_tipo_persona_cargon`.`Id` IS NULL, `k_recibos`.`UsuarioS`, CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2` ,' ', `g_persona`.`Nombre1` ,' ',`g_persona`.`Nombre2`)) AS Cajero, `k_caja`.`Id` AS IdCaja, k_recibos.`NoFactura` NFactura, f_empresacontxconvenio.`Nbre` NConvenio, GROUP_CONCAT(k_conceptos.`Nbre` SEPARATOR '-')  NConcepto \nFROM  `k_itemrecibos` INNER JOIN `k_recibos`  ON (`k_itemrecibos`.`Id_Recibo` = `k_recibos`.`Id`) INNER JOIN `k_itemformapago`  ON (`k_itemformapago`.`Id_Recibo` = `k_recibos`.`Id`) \nINNER JOIN  `k_formapago`  ON (`k_itemformapago`.`Id_FormaPago` = `k_formapago`.`Id`) INNER JOIN  `k_conceptos` ON (`k_conceptos`.`Id` = `k_itemrecibos`.`Id_Concepto`) INNER JOIN `k_caja`  ON (`k_recibos`.`Id_Caja` = `k_caja`.`Id`) LEFT JOIN  `rh_tipo_persona_cargon` ON (`rh_tipo_persona_cargon`.`Id` = `k_recibos`.`Id_UsuarioS`) LEFT JOIN `g_persona`  ON (`rh_tipo_persona_cargon`.`Id_Persona` = `g_persona`.`Id`) LEFT JOIN f_empresacontxconvenio ON (f_empresacontxconvenio.`Id`= k_recibos.`Id_EmpresaContxConv`)\nWHERE (DATE_FORMAT(`k_recibos`.`Fecha_Recibo`,'%Y-%m-%d') >='" + this.xmt.formatoAMD1.format(this.JDFechaI.getDate()) + "' AND DATE_FORMAT(`k_recibos`.`Fecha_Recibo`,'%Y-%m-%d') <='" + this.xmt.formatoAMD1.format(this.JDFechaF.getDate()) + "') GROUP BY `k_recibos`.`Id`, `k_recibos`.`NoRecibo` ORDER BY `k_recibos`.`Fecha_Recibo` DESC, `k_recibos`.`NoRecibo` DESC ";
            mCargarDatosDetalle();
        }
        this.xsql = "SELECT \n`profesional1`.`Especialidad`, \n`profesional1`.`NProfesional`, \n`ingreso`.`FechaIngreso`, \nCONCAT(`g_persona`.`Id_TipoIdentificacion` ,' ', `g_persona`.`NoDocumento`) AS `Documento` ,\nCONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2` ,' ', `g_persona`.`Nombre1` ,' ', `g_persona`.`Nombre2`) AS `NUsuario` ,\n`f_empresacontxconvenio`.`Nbre` AS `NConvenio`\n, `f_liquidacion`.`TotalServicio`\n, `f_liquidacion`.TotalDescuento\n, (`f_liquidacion`.`CuotaModeradora`+ `f_liquidacion`.`Copago`) AS `CopCuota`\n, `f_liquidacion`.`TotalServicio`+`f_liquidacion`.`TotalEps`totalFactura\n, (IF(`k_itemrecibos`.`VrUnitario` IS NULL, 0,`k_itemrecibos`.`VrUnitario` ) - k_recibos.Descuento )AS `VRecibo`\n, IF(`k_recibos`.`NoRecibo` IS NULL, '', CONCAT('Caja : ',`k_caja`.`Nbre`,' ,NRecibo : ',`k_recibos`.`NoRecibo`,' SubTotal : ', `k_itemrecibos`.`VrUnitario`,' Descuento : ' \n,k_recibos.Descuento,' Valor Pagado : ', (`k_itemrecibos`.`VrUnitario`- k_recibos.Descuento))) AS `DCaja`\n,IF(f_factura_evento.`No_FacturaEvento` IS NULL, '', CONCAT('FV-', f_factura_evento.`No_FacturaEvento`)) NFactura\n,IF(f_factura_capita.`No_FacturaCapita` IS NULL, '', CONCAT('OS-',f_factura_capita.`No_FacturaCapita`)) NServicio \n, gs.Nbre  as nombreSede \n, (SELECT CONCAT(`g_persona`.`Nombre1`, ' ', `g_persona`.`Nombre2`, ' ', `g_persona`.`Apellido1`, ' ', `g_persona`.`Apellido2`) \n     FROM `g_persona` \n     INNER JOIN `g_usuario_sist` ON `g_persona`.`Id` = `g_usuario_sist`.`Id_Persona`\n     WHERE `g_usuario_sist`.`Login` = `f_liquidacion`.`UsuarioS`) AS facturador \nFROM `ingreso` INNER JOIN  `g_usuario` ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)\nINNER JOIN  `g_persona` ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`) \n INNER JOIN g_sedes gs  ON (gs.Id =ingreso.Id_Sede)  \nLEFT JOIN  `f_liquidacion`\n        ON (`f_liquidacion`.`Id_Ingreso` = `ingreso`.`Id`) AND (f_liquidacion.`Estado`=0)\n    LEFT JOIN `f_factura_evento`\n        ON (`f_liquidacion`.`Id` = `f_factura_evento`.`Id_Liquidacion`)\n    LEFT JOIN  `f_factura_capita`\n        ON (`f_liquidacion`.`Id` = `f_factura_capita`.`Id_Liquidacion`) \nINNER JOIN  `profesional1` ON (`profesional1`.`Id_Persona` = `ingreso`.`Id_Profesional`)\nAND (`profesional1`.`IdEspecialidad` = `ingreso`.`Id_Especialidad`)\nLEFT JOIN  `k_recibos` ON (`k_recibos`.`Id_Ingreso` = `ingreso`.`Id`)AND k_recibos.`Estado`=0 \nLEFT JOIN  `k_itemrecibos` ON (`k_itemrecibos`.`Id_Recibo` = `k_recibos`.`Id`)\nLEFT JOIN  `k_caja` ON (`k_recibos`.`Id_Caja` = `k_caja`.`Id`) \nINNER JOIN  `f_empresacontxconvenio` ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)\nINNER JOIN `d_ips` ON (`d_ips`.`Id` = `f_empresacontxconvenio`.`Id_GIps`)\nWHERE (`ingreso`.`Estado` =0 AND `f_liquidacion`.`Estado` =0 AND `ingreso`.`FechaIngreso` BETWEEN '" + this.xmt.formatoAMD1.format(this.JDFechaI.getDate()) + "' AND '" + this.xmt.formatoAMD1.format(this.JDFechaF.getDate()) + "')\nORDER BY `profesional1`.`Especialidad` ASC, `profesional1`.`NProfesional` ASC, `f_empresacontxconvenio`.`Nbre` ASC, `NUsuario` ASC";
        mCargarDatosDetalleB();
    }

    public void mNuevo() {
        this.JDFechaI.setDate(this.xmt.getFechaActual());
        this.JDFechaF.setDate(this.xmt.getFechaActual());
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
        this.JTFF_Totales.setValue(new Double(0.0d));
        this.JTFDocumento.setText("");
        this.JTFNombre.setText("");
        mCrearTablaDetalle();
        mCrearTablaDetalleB();
    }

    private void mCrearTablaDetalle() {
        this.xmodelo = new DefaultTableModel((Object[][]) null, new String[]{"Id", "NRecibo", "Fecha - Hora", "Identificación", "Usuario", "Valor", "Forma Pago", "Estado", "Observación Anulado", "Id_Cierre", "Caja", "Cajero", "id_caja", "NFactura", "NConvenio", "NConcepto"}) { // from class: Caja.JIFConsultarRecibosC.7
            Class[] types = {Long.class, Long.class, String.class, String.class, String.class, Double.class, String.class, Boolean.class, String.class, Long.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        JTable jTable = this.JTDetalle;
        JTable jTable2 = this.JTDetalle;
        jTable.setAutoResizeMode(0);
        this.JTDetalle.doLayout();
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(12).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(12).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(12).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(13).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(14).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(15).setPreferredWidth(300);
    }

    private void mCrearTablaDetalleB() {
        this.xmodeloB = new DefaultTableModel((Object[][]) null, new String[]{"Especialidad", "Profesional", "Fecha", "Identificación", "Usuario", "Convenio", "Total Servicio", "Descuento", "Cop Cuota", "Total Eps", "V/Recibido", "Descripcion Caja", "NFactura", "NOrdenS", "Sede", "Facturador"}) { // from class: Caja.JIFConsultarRecibosC.8
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, Double.class, Double.class, Double.class, Double.class, Double.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        JTable jTable = this.JTDetalle1;
        JTable jTable2 = this.JTDetalle;
        jTable.setAutoResizeMode(0);
        this.JTDetalle1.doLayout();
        this.JTDetalle1.setModel(this.xmodeloB);
        this.JTDetalle1.getColumnModel().getColumn(0).setPreferredWidth(150);
        this.JTDetalle1.getColumnModel().getColumn(1).setPreferredWidth(200);
        this.JTDetalle1.getColumnModel().getColumn(2).setPreferredWidth(80);
        this.JTDetalle1.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTDetalle1.getColumnModel().getColumn(4).setPreferredWidth(200);
        this.JTDetalle1.getColumnModel().getColumn(5).setPreferredWidth(200);
        this.JTDetalle1.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTDetalle1.getColumnModel().getColumn(7).setPreferredWidth(100);
        this.JTDetalle1.getColumnModel().getColumn(8).setPreferredWidth(100);
        this.JTDetalle1.getColumnModel().getColumn(9).setPreferredWidth(100);
        this.JTDetalle1.getColumnModel().getColumn(10).setPreferredWidth(100);
        this.JTDetalle1.getColumnModel().getColumn(11).setPreferredWidth(300);
        this.JTDetalle1.getColumnModel().getColumn(12).setPreferredWidth(100);
        this.JTDetalle1.getColumnModel().getColumn(13).setPreferredWidth(100);
        this.JTDetalle1.getColumnModel().getColumn(14).setPreferredWidth(200);
        this.JTDetalle1.getColumnModel().getColumn(15).setPreferredWidth(200);
    }

    private void mCrearTablaDetalle_RAnulados() {
        this.xmodelo = new DefaultTableModel((Object[][]) null, new String[]{"Caja", "Fecha - Hora", "NRecibo", "Usuario", "Valor", "Motivo Anulación", "Observación Anulado", "Usuario Anulación", "Fecha Anulación"}) { // from class: Caja.JIFConsultarRecibosC.9
            Class[] types = {String.class, String.class, Long.class, String.class, Double.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(40);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(40);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(4);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(20);
    }

    private void mCargarDatosDetalle() {
        try {
            mCrearTablaDetalle();
            ResultSet xrs = this.xct.traerRs(this.xsql);
            Throwable th = null;
            try {
                double xvalor = 0.0d;
                if (xrs.next()) {
                    xrs.beforeFirst();
                    int x = 0;
                    while (xrs.next()) {
                        this.xmodelo.addRow(this.xdato);
                        this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(1)), x, 0);
                        this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(2)), x, 1);
                        this.xmodelo.setValueAt(xrs.getString(3), x, 2);
                        this.xmodelo.setValueAt(xrs.getString(4), x, 3);
                        this.xmodelo.setValueAt(xrs.getString(5), x, 4);
                        this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(6)), x, 5);
                        this.xmodelo.setValueAt(xrs.getString(7), x, 6);
                        this.xmodelo.setValueAt(Boolean.valueOf(!xrs.getBoolean(8)), x, 7);
                        this.xmodelo.setValueAt(xrs.getString(9), x, 8);
                        this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(10)), x, 9);
                        this.xmodelo.setValueAt(xrs.getString(11), x, 10);
                        this.xmodelo.setValueAt(xrs.getString("Cajero"), x, 11);
                        this.xmodelo.setValueAt(xrs.getString("IdCaja"), x, 12);
                        this.xmodelo.setValueAt(xrs.getString("NFactura"), x, 13);
                        this.xmodelo.setValueAt(xrs.getString("NConvenio"), x, 14);
                        this.xmodelo.setValueAt(xrs.getString("NConcepto"), x, 15);
                        if (xrs.getDouble(6) > 0.0d) {
                            xvalor += xrs.getDouble(6);
                        }
                        x++;
                    }
                }
                this.JTFF_Totales.setValue(Double.valueOf(xvalor));
                if (xrs != null) {
                    if (0 != 0) {
                        try {
                            xrs.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    } else {
                        xrs.close();
                    }
                }
                this.xct.cerrarConexionBd();
            } finally {
            }
        } catch (SQLException ex) {
            Logger.getLogger(JIFConsultarRecibosC.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarDatosDetalleB() {
        try {
            mCrearTablaDetalleB();
            System.out.println("Datos detalle b -> " + this.xsql);
            ResultSet xrs = this.xct.traerRs(this.xsql);
            Throwable th = null;
            try {
                if (xrs.next()) {
                    xrs.beforeFirst();
                    int x = 0;
                    while (xrs.next()) {
                        this.xmodeloB.addRow(this.xdato);
                        this.xmodeloB.setValueAt(xrs.getString(1), x, 0);
                        this.xmodeloB.setValueAt(xrs.getString(2), x, 1);
                        this.xmodeloB.setValueAt(xrs.getString(3), x, 2);
                        this.xmodeloB.setValueAt(xrs.getString(4), x, 3);
                        this.xmodeloB.setValueAt(xrs.getString(5), x, 4);
                        this.xmodeloB.setValueAt(xrs.getString(6), x, 5);
                        this.xmodeloB.setValueAt(Double.valueOf(xrs.getDouble(7)), x, 6);
                        this.xmodeloB.setValueAt(Double.valueOf(xrs.getDouble(8)), x, 7);
                        this.xmodeloB.setValueAt(Double.valueOf(xrs.getDouble(9)), x, 8);
                        this.xmodeloB.setValueAt(Double.valueOf(xrs.getDouble(10)), x, 9);
                        this.xmodeloB.setValueAt(Double.valueOf(xrs.getDouble(11)), x, 10);
                        this.xmodeloB.setValueAt(xrs.getString(12), x, 11);
                        this.xmodeloB.setValueAt(xrs.getString(13), x, 12);
                        this.xmodeloB.setValueAt(xrs.getString(14), x, 13);
                        this.xmodeloB.setValueAt(xrs.getString("nombreSede"), x, 14);
                        this.xmodeloB.setValueAt(xrs.getString("facturador"), x, 15);
                        x++;
                    }
                }
                if (xrs != null) {
                    if (0 != 0) {
                        try {
                            xrs.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    } else {
                        xrs.close();
                    }
                }
                this.xct.cerrarConexionBd();
            } finally {
            }
        } catch (SQLException ex) {
            Logger.getLogger(JIFConsultarRecibosC.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarDatosDetalle_Anulado() {
        try {
            mCrearTablaDetalle_RAnulados();
            this.xsql = "SELECT `k_recibos`.`Id`, `k_recibos`.`NoRecibo`, `k_recibos`.`Fecha_Recibo`, `k_recibos`.`Identificacion`, `k_recibos`.`Nbre_Paciente`, SUM((`k_itemrecibos`.`Cantidad`*`k_itemrecibos`.`VrUnitario`)) AS `ValorR` , `k_formapago`.`Nbre` , `k_recibos`.`Estado` , IF(`k_recibos`.`ObservacionAnulado` IS NULL, '', `k_recibos`.`ObservacionAnulado`) AS Observacion, `k_recibos`.`Id_cierre`, `k_caja`.`Nbre` AS Caja, IF(`rh_tipo_persona_cargon`.`Id` IS NULL, `k_recibos`.`UsuarioS`, CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2` ,' ', `g_persona`.`Nombre1` ,' ',`g_persona`.`Nombre2`)) AS Cajero, `k_caja`.`Id` AS IdCaja, k_recibos.`NoFactura` NFactura, f_empresacontxconvenio.`Nbre` NConvenio, GROUP_CONCAT(k_conceptos.`Nbre` SEPARATOR '-')  NConcepto \nFROM  `k_itemrecibos` INNER JOIN `k_recibos`  ON (`k_itemrecibos`.`Id_Recibo` = `k_recibos`.`Id`) INNER JOIN `k_itemformapago`  ON (`k_itemformapago`.`Id_Recibo` = `k_recibos`.`Id`) \nINNER JOIN  `k_formapago`  ON (`k_itemformapago`.`Id_FormaPago` = `k_formapago`.`Id`) INNER JOIN  `k_conceptos` ON (`k_conceptos`.`Id` = `k_itemrecibos`.`Id_Concepto`) INNER JOIN `k_caja`  ON (`k_recibos`.`Id_Caja` = `k_caja`.`Id`) LEFT JOIN  `rh_tipo_persona_cargon` ON (`rh_tipo_persona_cargon`.`Id` = `k_recibos`.`Id_UsuarioS`) LEFT JOIN `g_persona`  ON (`rh_tipo_persona_cargon`.`Id_Persona` = `g_persona`.`Id`) LEFT JOIN f_empresacontxconvenio ON (f_empresacontxconvenio.`Id`= k_recibos.`Id_EmpresaContxConv`)\nWHERE (DATE_FORMAT(`k_recibos`.`Fecha_Recibo`,'%Y-%m-%d') >='" + this.xmt.formatoAMD1.format(this.JDFechaI.getDate()) + "' AND DATE_FORMAT(`k_recibos`.`Fecha_Recibo`,'%Y-%m-%d') <='" + this.xmt.formatoAMD1.format(this.JDFechaF.getDate()) + "' AND `k_recibos`.`Estado` <>0) GROUP BY `k_recibos`.`Id`, `k_recibos`.`NoRecibo` ORDER BY `k_recibos`.`Fecha_Recibo` DESC, `k_recibos`.`NoRecibo` DESC ";
            ResultSet xrs = this.xct.traerRs(this.xsql);
            Throwable th = null;
            try {
                double xvalor = 0.0d;
                if (xrs.next()) {
                    xrs.beforeFirst();
                    int x = 0;
                    this.xmt.mEstablecerTextEditor(this.JTDetalle, 1);
                    this.xmt.mEstablecerTextEditor(this.JTDetalle, 3);
                    this.xmt.mEstablecerTextEditor(this.JTDetalle, 5);
                    this.xmt.mEstablecerTextEditor(this.JTDetalle, 6);
                    this.xmt.mEstablecerTextEditor(this.JTDetalle, 7);
                    this.xmt.mEstablecerTextEditor(this.JTDetalle, 8);
                    while (xrs.next()) {
                        this.xmodelo.addRow(this.xdato);
                        this.xmodelo.setValueAt(xrs.getString(1), x, 0);
                        this.xmodelo.setValueAt(xrs.getString(2), x, 1);
                        this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(3)), x, 2);
                        this.xmodelo.setValueAt(xrs.getString(4), x, 3);
                        this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(5)), x, 4);
                        this.xmodelo.setValueAt(xrs.getString(6), x, 5);
                        this.xmodelo.setValueAt(xrs.getString(7), x, 6);
                        this.xmodelo.setValueAt(xrs.getString(8), x, 7);
                        this.xmodelo.setValueAt(xrs.getString(9), x, 8);
                        xvalor += xrs.getDouble(5);
                        x++;
                    }
                }
                this.JTFF_Totales.setValue(Double.valueOf(xvalor));
                if (xrs != null) {
                    if (0 != 0) {
                        try {
                            xrs.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    } else {
                        xrs.close();
                    }
                }
                this.xct.cerrarConexionBd();
            } finally {
            }
        } catch (SQLException ex) {
            Logger.getLogger(JIFConsultarRecibosC.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mImprimir() {
        String[][] parametros = new String[4][2];
        parametros[0][0] = "fechai";
        parametros[0][1] = this.xmt.formatoAMD1.format(this.JDFechaI.getDate());
        parametros[1][0] = "fechaf";
        parametros[1][1] = this.xmt.formatoAMD1.format(this.JDFechaF.getDate());
        parametros[2][0] = "SUBREPORT_DIR";
        parametros[2][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
        parametros[3][0] = "SUBREPORTFIRMA_DIR";
        parametros[3][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
        this.xmt.GenerarPDF(this.xmt.getRutaRep() + "F_Liquidacion_Recaudos", parametros);
    }
}
