package AutorizacionMP;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;
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
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:AutorizacionMP/JIFAuditoriaFormulasMP.class */
public class JIFAuditoriaFormulasMP extends JInternalFrame {
    private ConsultasMySQL xconsultas = new ConsultasMySQL();
    private Metodos xmt = new Metodos();
    private DefaultTableModel xmodelo;
    private DefaultTableModel xmodelo1;
    private Object[] xdato;
    private String sql;
    private String[] xidtipoempresa;
    private String[] xidmunicipio;
    private File xfile;
    private ButtonGroup JBGSoporte;
    private JCheckBox JCBFiltro;
    private JComboBox JCBMunicipio;
    private JComboBox JCBProveedor;
    private JDateChooser JDCFechaA;
    private JDateChooser JDCFechaF;
    private JDateChooser JDCFechaFac;
    private JDateChooser JDCFechaI;
    private JPanel JPIDatos;
    private JPanel JPIDatosA;
    private JPanel JPIDatosPA;
    private JScrollPane JSPHC;
    private JScrollPane JSPHC1;
    private JScrollPane JSPObservacion;
    private JTextPane JTAObservacion;
    private JFormattedTextField JTFFIva;
    private JFormattedTextField JTFFOtros;
    private JFormattedTextField JTFFSubTotal;
    private JFormattedTextField JTFFTotal;
    private JFormattedTextField JTFFTotalA;
    private JFormattedTextField JTFFTotalDife;
    private JFormattedTextField JTFFTotalFac;
    private JTextField JTFNFactura;
    private JTable JTHistorico;
    private JTable JTHistorico1;

    public JIFAuditoriaFormulasMP() {
        initComponents();
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v38, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v46, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGSoporte = new ButtonGroup();
        this.JPIDatos = new JPanel();
        this.JDCFechaI = new JDateChooser();
        this.JDCFechaF = new JDateChooser();
        this.JCBProveedor = new JComboBox();
        this.JCBFiltro = new JCheckBox();
        this.JCBMunicipio = new JComboBox();
        this.JSPHC = new JScrollPane();
        this.JTHistorico = new JTable();
        this.JSPHC1 = new JScrollPane();
        this.JTHistorico1 = new JTable();
        this.JPIDatosPA = new JPanel();
        this.JDCFechaA = new JDateChooser();
        this.JTFNFactura = new JTextField();
        this.JDCFechaFac = new JDateChooser();
        this.JTFFSubTotal = new JFormattedTextField();
        this.JTFFIva = new JFormattedTextField();
        this.JTFFOtros = new JFormattedTextField();
        this.JSPObservacion = new JScrollPane();
        this.JTAObservacion = new JTextPane();
        this.JTFFTotal = new JFormattedTextField();
        this.JPIDatosA = new JPanel();
        this.JTFFTotalA = new JFormattedTextField();
        this.JTFFTotalFac = new JFormattedTextField();
        this.JTFFTotalDife = new JFormattedTextField();
        setClosable(true);
        setIconifiable(true);
        setTitle("AUDITORIA FACTURAS MEDICINA PREPAGADA");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifauditoriafmp");
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS DE CONSULTA", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JDCFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDCFechaI.setFont(new Font("Arial", 1, 12));
        this.JDCFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Fin", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDCFechaF.setFont(new Font("Arial", 1, 12));
        this.JCBProveedor.setFont(new Font("Arial", 1, 12));
        this.JCBProveedor.setBorder(BorderFactory.createTitledBorder((Border) null, "Empresa", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBProveedor.addActionListener(new ActionListener() { // from class: AutorizacionMP.JIFAuditoriaFormulasMP.1
            public void actionPerformed(ActionEvent evt) {
                JIFAuditoriaFormulasMP.this.JCBProveedorActionPerformed(evt);
            }
        });
        this.JCBFiltro.setFont(new Font("Arial", 1, 12));
        this.JCBFiltro.setText("Filtro Municipo");
        this.JCBFiltro.addActionListener(new ActionListener() { // from class: AutorizacionMP.JIFAuditoriaFormulasMP.2
            public void actionPerformed(ActionEvent evt) {
                JIFAuditoriaFormulasMP.this.JCBFiltroActionPerformed(evt);
            }
        });
        this.JCBMunicipio.setFont(new Font("Arial", 1, 12));
        this.JCBMunicipio.setBorder(BorderFactory.createTitledBorder((Border) null, "Municipio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBMunicipio.setEnabled(false);
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JDCFechaI, -2, 124, -2).addGap(4, 4, 4).addComponent(this.JDCFechaF, -2, 124, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBProveedor, 0, 415, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBFiltro).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBMunicipio, -2, 213, -2)));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JDCFechaI, -2, -1, -2).addComponent(this.JDCFechaF, -2, -1, -2)).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBProveedor, -2, -1, -2).addComponent(this.JCBMunicipio, -2, -1, -2).addComponent(this.JCBFiltro))).addContainerGap(18, 32767)));
        this.JSPHC.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE AUTORIZACIONES", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 51)));
        this.JSPHC.setFont(new Font("Arial", 1, 12));
        this.JTHistorico.setFont(new Font("Arial", 1, 12));
        this.JTHistorico.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTHistorico.setRowHeight(25);
        this.JTHistorico.setSelectionBackground(new Color(255, 255, 255));
        this.JTHistorico.setSelectionForeground(new Color(255, 0, 0));
        this.JTHistorico.setSelectionMode(0);
        this.JTHistorico.addMouseListener(new MouseAdapter() { // from class: AutorizacionMP.JIFAuditoriaFormulasMP.3
            public void mouseClicked(MouseEvent evt) {
                JIFAuditoriaFormulasMP.this.JTHistoricoMouseClicked(evt);
            }
        });
        this.JSPHC.setViewportView(this.JTHistorico);
        this.JSPHC1.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 51)));
        this.JSPHC1.setFont(new Font("Arial", 1, 12));
        this.JTHistorico1.setFont(new Font("Arial", 1, 12));
        this.JTHistorico1.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTHistorico1.setRowHeight(25);
        this.JTHistorico1.setSelectionBackground(new Color(255, 255, 255));
        this.JTHistorico1.setSelectionForeground(new Color(255, 0, 0));
        this.JTHistorico1.setSelectionMode(0);
        this.JTHistorico1.addMouseListener(new MouseAdapter() { // from class: AutorizacionMP.JIFAuditoriaFormulasMP.4
            public void mouseClicked(MouseEvent evt) {
                JIFAuditoriaFormulasMP.this.JTHistorico1MouseClicked(evt);
            }
        });
        this.JSPHC1.setViewportView(this.JTHistorico1);
        this.JPIDatosPA.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS DE FACTURA PARA AUDITORIA", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JDCFechaA.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFechaA.setDateFormatString("dd/MM/yyyy");
        this.JDCFechaA.setFont(new Font("Arial", 1, 12));
        this.JTFNFactura.setFont(new Font("Arial", 1, 14));
        this.JTFNFactura.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Factura", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFechaFac.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Factura", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFechaFac.setDateFormatString("dd/MM/yyyy");
        this.JDCFechaFac.setFont(new Font("Arial", 1, 12));
        this.JTFFSubTotal.setBorder(BorderFactory.createTitledBorder((Border) null, "SubTotal", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFSubTotal.setHorizontalAlignment(4);
        this.JTFFSubTotal.setFont(new Font("Arial", 1, 14));
        this.JTFFSubTotal.addActionListener(new ActionListener() { // from class: AutorizacionMP.JIFAuditoriaFormulasMP.5
            public void actionPerformed(ActionEvent evt) {
                JIFAuditoriaFormulasMP.this.JTFFSubTotalActionPerformed(evt);
            }
        });
        this.JTFFSubTotal.addFocusListener(new FocusAdapter() { // from class: AutorizacionMP.JIFAuditoriaFormulasMP.6
            public void focusLost(FocusEvent evt) {
                JIFAuditoriaFormulasMP.this.JTFFSubTotalFocusLost(evt);
            }
        });
        this.JTFFIva.setBorder(BorderFactory.createTitledBorder((Border) null, "Iva", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFIva.setHorizontalAlignment(4);
        this.JTFFIva.setFont(new Font("Arial", 1, 14));
        this.JTFFIva.addActionListener(new ActionListener() { // from class: AutorizacionMP.JIFAuditoriaFormulasMP.7
            public void actionPerformed(ActionEvent evt) {
                JIFAuditoriaFormulasMP.this.JTFFIvaActionPerformed(evt);
            }
        });
        this.JTFFIva.addFocusListener(new FocusAdapter() { // from class: AutorizacionMP.JIFAuditoriaFormulasMP.8
            public void focusGained(FocusEvent evt) {
                JIFAuditoriaFormulasMP.this.JTFFIvaFocusGained(evt);
            }

            public void focusLost(FocusEvent evt) {
                JIFAuditoriaFormulasMP.this.JTFFIvaFocusLost(evt);
            }
        });
        this.JTFFOtros.setBorder(BorderFactory.createTitledBorder((Border) null, "Otros", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFOtros.setHorizontalAlignment(4);
        this.JTFFOtros.setFont(new Font("Arial", 1, 14));
        this.JTFFOtros.addActionListener(new ActionListener() { // from class: AutorizacionMP.JIFAuditoriaFormulasMP.9
            public void actionPerformed(ActionEvent evt) {
                JIFAuditoriaFormulasMP.this.JTFFOtrosActionPerformed(evt);
            }
        });
        this.JTFFOtros.addFocusListener(new FocusAdapter() { // from class: AutorizacionMP.JIFAuditoriaFormulasMP.10
            public void focusGained(FocusEvent evt) {
                JIFAuditoriaFormulasMP.this.JTFFOtrosFocusGained(evt);
            }

            public void focusLost(FocusEvent evt) {
                JIFAuditoriaFormulasMP.this.JTFFOtrosFocusLost(evt);
            }
        });
        this.JSPObservacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTAObservacion.setFont(new Font("Arial", 1, 12));
        this.JTAObservacion.addFocusListener(new FocusAdapter() { // from class: AutorizacionMP.JIFAuditoriaFormulasMP.11
            public void focusGained(FocusEvent evt) {
                JIFAuditoriaFormulasMP.this.JTAObservacionFocusGained(evt);
            }
        });
        this.JTAObservacion.addKeyListener(new KeyAdapter() { // from class: AutorizacionMP.JIFAuditoriaFormulasMP.12
            public void keyPressed(KeyEvent evt) {
                JIFAuditoriaFormulasMP.this.JTAObservacionKeyPressed(evt);
            }
        });
        this.JSPObservacion.setViewportView(this.JTAObservacion);
        this.JTFFTotal.setEditable(false);
        this.JTFFTotal.setBorder(BorderFactory.createTitledBorder((Border) null, "Total", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFTotal.setForeground(Color.red);
        this.JTFFTotal.setHorizontalAlignment(4);
        this.JTFFTotal.setFont(new Font("Arial", 1, 14));
        GroupLayout JPIDatosPALayout = new GroupLayout(this.JPIDatosPA);
        this.JPIDatosPA.setLayout(JPIDatosPALayout);
        JPIDatosPALayout.setHorizontalGroup(JPIDatosPALayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosPALayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosPALayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosPALayout.createSequentialGroup().addComponent(this.JDCFechaA, -2, 124, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFNFactura, -2, 124, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JDCFechaFac, -2, 124, -2)).addComponent(this.JSPObservacion)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPIDatosPALayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosPALayout.createSequentialGroup().addComponent(this.JTFFSubTotal, -2, 127, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFIva, -2, 120, -2)).addGroup(JPIDatosPALayout.createSequentialGroup().addGap(4, 4, 4).addComponent(this.JTFFOtros, -2, 123, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFTotal, -2, 120, -2))).addContainerGap()));
        JPIDatosPALayout.setVerticalGroup(JPIDatosPALayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosPALayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosPALayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(GroupLayout.Alignment.LEADING, JPIDatosPALayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFSubTotal, -1, 50, 32767).addComponent(this.JTFFIva, -1, 51, 32767)).addComponent(this.JDCFechaFac, GroupLayout.Alignment.LEADING, -1, 52, 32767).addComponent(this.JTFNFactura, GroupLayout.Alignment.LEADING, -1, 52, 32767).addComponent(this.JDCFechaA, GroupLayout.Alignment.LEADING, -1, 52, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPIDatosPALayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPObservacion, -2, -1, -2).addGroup(JPIDatosPALayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFTotal, -2, 52, -2).addComponent(this.JTFFOtros, -2, 51, -2))).addContainerGap()));
        this.JPIDatosA.setBorder(BorderFactory.createTitledBorder((Border) null, "VALORES AUTORIZACIÓN", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTFFTotalA.setEditable(false);
        this.JTFFTotalA.setBorder(BorderFactory.createTitledBorder((Border) null, "Total Autorizado", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFTotalA.setHorizontalAlignment(4);
        this.JTFFTotalA.setFont(new Font("Arial", 1, 14));
        this.JTFFTotalFac.setEditable(false);
        this.JTFFTotalFac.setBorder(BorderFactory.createTitledBorder((Border) null, "Total Facturado", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFTotalFac.setHorizontalAlignment(4);
        this.JTFFTotalFac.setFont(new Font("Arial", 1, 14));
        this.JTFFTotalDife.setEditable(false);
        this.JTFFTotalDife.setBorder(BorderFactory.createTitledBorder((Border) null, "Total Diferencia", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFTotalDife.setHorizontalAlignment(4);
        this.JTFFTotalDife.setFont(new Font("Arial", 1, 14));
        GroupLayout JPIDatosALayout = new GroupLayout(this.JPIDatosA);
        this.JPIDatosA.setLayout(JPIDatosALayout);
        JPIDatosALayout.setHorizontalGroup(JPIDatosALayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosALayout.createSequentialGroup().addGroup(JPIDatosALayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosALayout.createSequentialGroup().addContainerGap().addComponent(this.JTFFTotalA, -2, 127, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 42, 32767).addComponent(this.JTFFTotalFac, -2, 127, -2)).addGroup(JPIDatosALayout.createSequentialGroup().addGap(96, 96, 96).addComponent(this.JTFFTotalDife, -2, 127, -2))).addContainerGap()));
        JPIDatosALayout.setVerticalGroup(JPIDatosALayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosALayout.createSequentialGroup().addGroup(JPIDatosALayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFTotalA, -1, 50, 32767).addComponent(this.JTFFTotalFac, -1, 50, 32767)).addGap(17, 17, 17).addComponent(this.JTFFTotalDife, -1, 76, 32767).addContainerGap()));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPHC1, -1, 1021, 32767).addComponent(this.JSPHC, -1, 1021, 32767).addComponent(this.JPIDatos, -1, -1, 32767).addGroup(layout.createSequentialGroup().addComponent(this.JPIDatosPA, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPIDatosA, -1, -1, 32767))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPHC, -2, 192, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPHC1, -2, 123, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JPIDatosPA, -2, -1, -2).addComponent(this.JPIDatosA, -1, -1, 32767)).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTHistoricoMouseClicked(MouseEvent evt) {
        if (this.JTHistorico.getRowCount() > -1 && this.JTHistorico.getSelectedRow() != -1) {
            mCrearTabla1();
            this.sql = "SELECT i_suministro.Id, CONCAT(i_suministro.Nbre,' ' , i_presentacioncomercial.Nbre,' ' ,i_laboratorio.Nbre) AS Nproducto, h_itemordenessum.PosologiaManual, h_itemordenessum.Duracion, h_itemordenessum.Cantidad, h_itemordenessum.ValorUnitario, h_itemordenessum.ValorTotal FROM h_itemordenessum INNER JOIN h_ordenes  ON (h_itemordenessum.Id_HOrdenes = h_ordenes.Id)INNER JOIN i_suministro  ON (h_itemordenessum.Id_Suministro = i_suministro.Id) INNER JOIN i_presentacioncomercial  ON (i_suministro.IdPresentacionComercial = i_presentacioncomercial.Id) INNER JOIN i_laboratorio  ON (i_suministro.IdLaboratorio = i_laboratorio.Id) WHERE (h_ordenes.Id ='" + this.xmodelo.getValueAt(this.JTHistorico.getSelectedRow(), 0) + "') ";
            ResultSet rs = this.xconsultas.traerRs(this.sql);
            try {
                if (rs.next()) {
                    rs.beforeFirst();
                    int x = 0;
                    double xvalora = 0.0d;
                    double xvalorc = 0.0d;
                    while (rs.next()) {
                        this.xmodelo1.addRow(this.xdato);
                        this.xmodelo1.setValueAt(Long.valueOf(rs.getLong(1)), x, 0);
                        this.xmodelo1.setValueAt(rs.getString(2), x, 1);
                        this.xmodelo1.setValueAt(rs.getString(3), x, 2);
                        this.xmodelo1.setValueAt(Long.valueOf(rs.getLong(4)), x, 3);
                        this.xmodelo1.setValueAt(Long.valueOf(rs.getLong(5)), x, 4);
                        this.xmodelo1.setValueAt(Double.valueOf(rs.getDouble(6)), x, 5);
                        this.xmodelo1.setValueAt(Double.valueOf(rs.getDouble(7)), x, 6);
                        this.sql = "SELECT Valor FROM d_tarifa_empresa_mp WHERE (Id_Empresa ='" + this.xidtipoempresa[this.JCBProveedor.getSelectedIndex()] + "' AND Id_Suministro ='" + rs.getLong(1) + "')";
                        ConsultasMySQL xct = new ConsultasMySQL();
                        ResultSet xrs = xct.traerRs(this.sql);
                        if (xrs.next()) {
                            xrs.first();
                            this.xmodelo1.setValueAt(Double.valueOf(xrs.getDouble(1)), x, 7);
                            this.xmodelo1.setValueAt(Double.valueOf(xrs.getDouble(1) * rs.getLong(5)), x, 8);
                            this.xmodelo1.setValueAt(Double.valueOf(Double.valueOf(this.xmodelo1.getValueAt(x, 6).toString()).doubleValue() - Double.valueOf(this.xmodelo1.getValueAt(x, 8).toString()).doubleValue()), x, 9);
                            this.JTHistorico1.setDefaultRenderer(Object.class, new MiRender());
                            if (Double.valueOf(this.xmodelo1.getValueAt(x, 6).toString()).doubleValue() - Double.valueOf(this.xmodelo1.getValueAt(x, 8).toString()).doubleValue() == 0.0d) {
                                this.xmodelo1.setValueAt("OK", x, 10);
                            } else {
                                this.xmodelo1.setValueAt("", x, 10);
                            }
                        } else {
                            this.xmodelo1.setValueAt(new Double(0.0d), x, 7);
                            this.xmodelo1.setValueAt(new Double(0.0d), x, 8);
                            this.xmodelo1.setValueAt(Double.valueOf(Double.valueOf(this.xmodelo1.getValueAt(x, 6).toString()).doubleValue() - Double.valueOf(this.xmodelo1.getValueAt(x, 8).toString()).doubleValue()), x, 9);
                            this.JTHistorico1.setDefaultRenderer(Object.class, new MiRender());
                            this.xmodelo1.setValueAt("", x, 10);
                        }
                        xrs.close();
                        xct.cerrarConexionBd();
                        xvalora += Double.valueOf(this.xmodelo1.getValueAt(x, 6).toString()).doubleValue();
                        xvalorc += Double.valueOf(this.xmodelo1.getValueAt(x, 8).toString()).doubleValue();
                        this.JTFFTotalA.setValue(Double.valueOf(xvalora));
                        this.JTFFTotalFac.setValue(Double.valueOf(xvalorc));
                        this.JTFFTotalDife.setValue(Double.valueOf(xvalora - xvalorc));
                        x++;
                    }
                }
                rs.close();
                this.xconsultas.cerrarConexionBd();
            } catch (SQLException ex) {
                Logger.getLogger(JIFAuditoriaFormulasMP.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTHistorico1MouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBFiltroActionPerformed(ActionEvent evt) {
        if (this.JCBFiltro.isSelected()) {
            this.JCBMunicipio.setEnabled(true);
        } else {
            this.JCBMunicipio.setEnabled(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFSubTotalActionPerformed(ActionEvent evt) {
        this.JTFFSubTotal.transferFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFSubTotalFocusLost(FocusEvent evt) {
        mCalcularTotal();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFIvaActionPerformed(ActionEvent evt) {
        mCalcularTotal();
        this.JTFFIva.transferFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFIvaFocusLost(FocusEvent evt) {
        mCalcularTotal();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFOtrosActionPerformed(ActionEvent evt) {
        mCalcularTotal();
        this.JTFFOtros.transferFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFOtrosFocusLost(FocusEvent evt) {
        mCalcularTotal();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFIvaFocusGained(FocusEvent evt) {
        mCalcularTotal();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFOtrosFocusGained(FocusEvent evt) {
        mCalcularTotal();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTAObservacionFocusGained(FocusEvent evt) {
        mCalcularTotal();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTAObservacionKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 9 || evt.getKeyCode() == 10) {
            this.JTAObservacion.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBProveedorActionPerformed(ActionEvent evt) {
    }

    public void mGrabar() {
        if (!Principal.txtNo.getText().isEmpty()) {
            if (this.JTHistorico.getRowCount() > 0) {
                if (this.JTHistorico1.getRowCount() > 0) {
                    if (!mVerificarDatosTablaTrue()) {
                        int xv = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                        if (xv == 0) {
                            this.sql = "update h_ordenes set  Id_AuditoriaMP='" + Principal.txtNo.getText() + "' where Id='" + this.xmodelo.getValueAt(this.JTHistorico.getSelectedRow(), 0) + "'";
                            this.xconsultas.ejecutarSQL(this.sql);
                            this.xconsultas.cerrarConexionBd();
                            for (int x = 0; x < this.JTHistorico1.getRowCount(); x++) {
                                this.sql = "update h_itemordenessum  set ObservacionA='" + this.xmodelo1.getValueAt(x, 10).toString() + "' where Id_HOrdenes='" + this.xmodelo.getValueAt(this.JTHistorico.getSelectedRow(), 0) + "' and  Id_Suministro='" + this.xmodelo1.getValueAt(x, 0).toString() + "'";
                                this.xconsultas.ejecutarSQL(this.sql);
                                this.xconsultas.cerrarConexionBd();
                            }
                            mCrearTabla1();
                            this.xmodelo.removeRow(this.JTHistorico.getSelectedRow());
                            return;
                        }
                        return;
                    }
                    JOptionPane.showInternalMessageDialog(this, "Existe un registro con diferencia;\nFavor verificar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "No existen registros en la tabla detalle de autorizaciones", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "No existen registros en la tabla de N° de autorizaciones", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        if (mValidarDatosFactura().booleanValue()) {
            int xv2 = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (xv2 == 0) {
                this.sql = "insert into d_auditoria_formulamp(FechaA, Id_Empresa, NFactura, FechaF, Subtotal, Iva, OtroValor, Observacion, UsuarioS)  values('" + this.xmt.formatoAMD.format(this.JDCFechaA.getDate()) + "','" + this.xidtipoempresa[this.JCBProveedor.getSelectedIndex()] + "','" + this.JTFNFactura.getText() + "','" + this.xmt.formatoAMD.format(this.JDCFechaFac.getDate()) + "','" + this.JTFFSubTotal.getValue() + "','" + this.JTFFIva.getValue() + "','" + this.JTFFOtros.getValue() + "','" + this.JTAObservacion.getText() + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                Principal.txtNo.setText(this.xconsultas.ejecutarSQLId(this.sql));
                this.xconsultas.cerrarConexionBd();
            }
        }
    }

    private Boolean mValidarDatosFactura() {
        boolean xretorno = false;
        if (this.JCBProveedor.getSelectedIndex() != -1) {
            if (this.JTFNFactura.getText().isEmpty()) {
                JOptionPane.showInternalMessageDialog(this, "El N° de factura no puede ser nulo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JTFNFactura.requestFocus();
            } else if (Double.valueOf(this.JTFFSubTotal.getValue().toString()).doubleValue() > 0.0d) {
                xretorno = true;
            } else {
                JOptionPane.showInternalMessageDialog(this, "Falta registrar valores de factura", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JTFFSubTotal.requestFocus();
            }
        } else {
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un proveedor", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBProveedor.requestFocus();
        }
        return Boolean.valueOf(xretorno);
    }

    public void mNuevo() {
        Principal.mLimpiarDatosP();
        this.JDCFechaI.setDate(this.xmt.getFechaActual());
        this.JDCFechaF.setDate(this.xmt.getFechaActual());
        this.JDCFechaA.setDate(this.xmt.getFechaActual());
        this.JDCFechaFac.setDate(this.xmt.getFechaActual());
        this.JCBProveedor.removeAllItems();
        this.xidtipoempresa = this.xconsultas.llenarCombo("SELECT Id, Nbre FROM g_empresa WHERE (Estado =1 AND EsConvenioMp =1) ORDER BY Nbre ASC", this.xidtipoempresa, this.JCBProveedor);
        this.JCBProveedor.setSelectedIndex(-1);
        this.xconsultas.cerrarConexionBd();
        this.JCBMunicipio.removeAllItems();
        this.xidmunicipio = this.xconsultas.llenarCombo("SELECT Id , Nbre FROM g_municipio WHERE (Estado =0) ORDER BY Nbre ASC", this.xidmunicipio, this.JCBMunicipio);
        this.JCBMunicipio.setSelectedIndex(-1);
        this.xconsultas.cerrarConexionBd();
        this.JTFFIva.setValue(new Double(0.0d));
        this.JTFFOtros.setValue(new Double(0.0d));
        this.JTFFSubTotal.setValue(new Double(0.0d));
        this.JTFFTotal.setValue(new Double(0.0d));
        this.JTFFTotalA.setValue(new Double(0.0d));
        this.JTFFTotalDife.setValue(new Double(0.0d));
        this.JTFFTotalFac.setValue(new Double(0.0d));
        mCrearTabla();
        mCrearTabla1();
    }

    public void mBuscar() {
        if (this.JCBProveedor.getSelectedIndex() != -1) {
            mCrearTabla1();
            if (this.JCBFiltro.isSelected()) {
                if (this.JCBMunicipio.getSelectedIndex() != -1) {
                    this.sql = "SELECT h_ordenes.Id, DATE_FORMAT(h_ordenes.FechaOrden, '%d-%m-%Y') AS Fecha, persona.NoHistoria, persona.NUsuario, h_tipoformula.Nbre, g_municipio.Nbre, profesional1.NProfesional FROM h_tipoformula INNER JOIN h_ordenes  ON (h_tipoformula.Id = h_ordenes.IdTipoFormula) INNER JOIN profesional1  ON (profesional1.Id_Persona = h_ordenes.Id_Profesional) AND (profesional1.IdEspecialidad = h_ordenes.Id_Especialidad) INNER JOIN g_municipio  ON (g_municipio.Id = h_ordenes.IdMunicipio) INNER JOIN h_atencion  ON (h_ordenes.Id_Atencion = h_atencion.Id) INNER JOIN ingreso  ON (h_atencion.Id_Ingreso = ingreso.Id) INNER JOIN persona  ON (persona.Id_persona = ingreso.Id_Usuario) WHERE (h_ordenes.Id_Proveedor ='" + this.xidtipoempresa[this.JCBProveedor.getSelectedIndex()] + "' AND h_ordenes.Estado =0 AND h_ordenes.FechaOrden >='" + this.xmt.formatoAMD.format(this.JDCFechaI.getDate()) + "' AND h_ordenes.Id_AuditoriaMP=0 AND h_ordenes.FechaOrden <='" + this.xmt.formatoAMD.format(this.JDCFechaF.getDate()) + "' AND h_ordenes.IdMunicipio='" + this.xidmunicipio[this.JCBMunicipio.getSelectedIndex()] + "' ) ORDER BY h_ordenes.Id ASC ";
                    mCargarTabla(this.sql);
                    return;
                } else {
                    JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un municipio", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    this.JCBMunicipio.requestFocus();
                    return;
                }
            }
            this.sql = "SELECT h_ordenes.Id, DATE_FORMAT(h_ordenes.FechaOrden, '%d-%m-%Y') AS Fecha, persona.NoHistoria, persona.NUsuario, h_tipoformula.Nbre, g_municipio.Nbre, profesional1.NProfesional FROM h_tipoformula INNER JOIN h_ordenes  ON (h_tipoformula.Id = h_ordenes.IdTipoFormula) INNER JOIN profesional1  ON (profesional1.Id_Persona = h_ordenes.Id_Profesional) AND (profesional1.IdEspecialidad = h_ordenes.Id_Especialidad) INNER JOIN g_municipio  ON (g_municipio.Id = h_ordenes.IdMunicipio) INNER JOIN h_atencion  ON (h_ordenes.Id_Atencion = h_atencion.Id) INNER JOIN ingreso  ON (h_atencion.Id_Ingreso = ingreso.Id) INNER JOIN persona  ON (persona.Id_persona = ingreso.Id_Usuario) WHERE (h_ordenes.Id_Proveedor ='" + this.xidtipoempresa[this.JCBProveedor.getSelectedIndex()] + "' AND h_ordenes.Estado =0 AND h_ordenes.FechaOrden >='" + this.xmt.formatoAMD.format(this.JDCFechaI.getDate()) + "' AND h_ordenes.Id_AuditoriaMP=0 AND h_ordenes.FechaOrden <='" + this.xmt.formatoAMD.format(this.JDCFechaF.getDate()) + "') ORDER BY h_ordenes.Id ASC ";
            mCargarTabla(this.sql);
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un proveedor", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JCBProveedor.requestFocus();
    }

    public void mImprimir() {
    }

    public void mCalcularTotal() {
        double total = Double.valueOf(this.JTFFSubTotal.getValue().toString()).doubleValue() + Double.valueOf(this.JTFFIva.getValue().toString()).doubleValue() + Double.valueOf(this.JTFFOtros.getValue().toString()).doubleValue();
        this.JTFFTotal.setValue(Double.valueOf(total));
    }

    private void mCrearTabla() {
        this.xmodelo = new DefaultTableModel((Object[][]) null, new String[]{"Id", "Fecha Orden", "N° HC", "Usuario", "Tipo Formula", "Municipio", "Profesional"}) { // from class: AutorizacionMP.JIFAuditoriaFormulasMP.13
            Class[] types = {Long.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTHistorico.setModel(this.xmodelo);
        this.JTHistorico.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTHistorico.getColumnModel().getColumn(1).setPreferredWidth(20);
        this.JTHistorico.getColumnModel().getColumn(2).setPreferredWidth(20);
        this.JTHistorico.getColumnModel().getColumn(3).setPreferredWidth(200);
        this.JTHistorico.getColumnModel().getColumn(4).setPreferredWidth(80);
        this.JTHistorico.getColumnModel().getColumn(5).setPreferredWidth(50);
        this.JTHistorico.getColumnModel().getColumn(6).setPreferredWidth(150);
    }

    private void mCrearTabla1() {
        this.xmodelo1 = new DefaultTableModel((Object[][]) null, new String[]{"Id", "Suministro", "Posología", "Duración", "Cant", "V/Unitario", "V/Total", "V/UnitarioC", "V/TotalC", "Diferencia", "Observación"}) { // from class: AutorizacionMP.JIFAuditoriaFormulasMP.14
            Class[] types = {Long.class, String.class, String.class, Integer.class, Integer.class, Double.class, Double.class, Double.class, Double.class, Double.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTHistorico1.setModel(this.xmodelo1);
        this.JTHistorico1.getColumnModel().getColumn(0).setPreferredWidth(5);
        this.JTHistorico1.getColumnModel().getColumn(1).setPreferredWidth(200);
        this.JTHistorico1.getColumnModel().getColumn(2).setPreferredWidth(50);
        this.JTHistorico1.getColumnModel().getColumn(3).setPreferredWidth(10);
        this.JTHistorico1.getColumnModel().getColumn(4).setPreferredWidth(10);
        this.JTHistorico1.getColumnModel().getColumn(5).setPreferredWidth(30);
        this.JTHistorico1.getColumnModel().getColumn(6).setPreferredWidth(30);
        this.JTHistorico1.getColumnModel().getColumn(7).setPreferredWidth(30);
        this.JTHistorico1.getColumnModel().getColumn(8).setPreferredWidth(30);
        this.JTHistorico1.getColumnModel().getColumn(9).setPreferredWidth(30);
        this.JTHistorico1.getColumnModel().getColumn(10).setPreferredWidth(100);
    }

    private void mCargarTabla(String xsql) {
        mCrearTabla();
        ResultSet rs = this.xconsultas.traerRs(xsql);
        try {
            if (rs.next()) {
                rs.beforeFirst();
                int x = 0;
                while (rs.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(Long.valueOf(rs.getLong(1)), x, 0);
                    this.xmodelo.setValueAt(rs.getString(2), x, 1);
                    this.xmodelo.setValueAt(rs.getString(3), x, 2);
                    this.xmodelo.setValueAt(rs.getString(4), x, 3);
                    this.xmodelo.setValueAt(rs.getString(5), x, 4);
                    this.xmodelo.setValueAt(rs.getString(6), x, 5);
                    this.xmodelo.setValueAt(rs.getString(7), x, 6);
                    x++;
                }
            }
            rs.close();
            this.xconsultas.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFAuditoriaFormulasMP.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX INFO: loaded from: GenomaP.jar:AutorizacionMP/JIFAuditoriaFormulasMP$MiRender.class */
    public static class MiRender extends DefaultTableCellRenderer {
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            double xvalor = Double.valueOf(table.getValueAt(row, 9).toString()).doubleValue();
            if (xvalor != 0.0d) {
                cell.setBackground(new Color(177, 251, 177));
            } else {
                cell.setBackground(Color.WHITE);
            }
            return cell;
        }
    }

    private boolean mVerificarDatosTablaTrue() {
        boolean estado = false;
        if (this.JTHistorico1.getRowCount() > 0) {
            int i = 0;
            while (true) {
                if (i >= this.JTHistorico1.getRowCount()) {
                    break;
                }
                if (!this.JTHistorico1.getValueAt(i, 10).toString().equals("")) {
                    i++;
                } else {
                    estado = true;
                    break;
                }
            }
        }
        return estado;
    }
}
