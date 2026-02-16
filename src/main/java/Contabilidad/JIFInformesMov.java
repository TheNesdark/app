package Contabilidad;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
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
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
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

/* JADX INFO: loaded from: GenomaP.jar:Contabilidad/JIFInformesMov.class */
public class JIFInformesMov extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private DefaultTableModel xmodelo1;
    private String[] xidtipodoc;
    private String[] xidtercero;
    private String[][] xidperiodo;
    private String xsql;
    private String xcc_detalle_documentoc;
    private String xcc_puc;
    private String xcc_documentoc;
    private Object[] xdatos;
    private JButton JBTGenerar;
    private JComboBox JCBPeriodo;
    private JComboBox JCBTercero;
    private JComboBox JCBTipoDoc;
    private JCheckBox JCHBFCuentaP;
    private JCheckBox JCHBFPeriodo;
    private JCheckBox JCHBFTercero;
    private JCheckBox JCHBFTipoDoc;
    private JDateChooser JDFFechaI;
    private JPanel JPICuentas;
    private JPanel JPIFiltro;
    private JPanel JPIPeriodo;
    private JPanel JPITercero;
    private JPanel JPITipoDoc;
    private JScrollPane JSPResultado;
    private JScrollPane JSPResultado1;
    private JFormattedTextField JTFFNit;
    private JFormattedTextField JTFFPuc2;
    private JFormattedTextField JTFFValorC;
    private JFormattedTextField JTFFValorD;
    private JTextField JTFRuta;
    private JTabbedPane JTPDatosD;
    public JTable JTResultado;
    public JTable JTResultado1;
    private Metodos xmt = new Metodos();
    private ConsultasMySQL xconsultas = new ConsultasMySQL();

    public JIFInformesMov() {
        initComponents();
        if (Principal.xclase.getxForma_Gn_Niif() == 1) {
            this.xcc_detalle_documentoc = "cc_detalle_documentoc_niif";
            this.xcc_puc = "cc_puc_niif";
            this.xcc_documentoc = "cc_documentoc_niif";
        } else {
            this.xcc_detalle_documentoc = "cc_detalle_documentoc";
            this.xcc_puc = "cc_puc";
            this.xcc_documentoc = "cc_documentoc";
        }
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v89, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v93, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPIFiltro = new JPanel();
        this.JPIPeriodo = new JPanel();
        this.JCHBFPeriodo = new JCheckBox();
        this.JCBPeriodo = new JComboBox();
        this.JDFFechaI = new JDateChooser();
        this.JPITercero = new JPanel();
        this.JCHBFTercero = new JCheckBox();
        this.JTFFNit = new JFormattedTextField();
        this.JCBTercero = new JComboBox();
        this.JPITipoDoc = new JPanel();
        this.JCHBFTipoDoc = new JCheckBox();
        this.JCBTipoDoc = new JComboBox();
        this.JPICuentas = new JPanel();
        this.JCHBFCuentaP = new JCheckBox();
        this.JTFFPuc2 = new JFormattedTextField();
        this.JBTGenerar = new JButton();
        this.JTFRuta = new JTextField();
        this.JTPDatosD = new JTabbedPane();
        this.JSPResultado = new JScrollPane();
        this.JTResultado = new JTable();
        this.JSPResultado1 = new JScrollPane();
        this.JTResultado1 = new JTable();
        this.JTFFValorD = new JFormattedTextField();
        this.JTFFValorC = new JFormattedTextField();
        setClosable(true);
        setIconifiable(true);
        setTitle("CONSOLIDADO DE MOVIMIENTOS");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjifcosultarinformesc");
        this.JPIFiltro.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS PARA CONSULTA", 0, 0, new Font("Arial", 1, 14), Color.blue));
        this.JPIPeriodo.setBorder(BorderFactory.createTitledBorder((Border) null, "PERIODO", 0, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JCHBFPeriodo.setFont(new Font("Arial", 1, 12));
        this.JCHBFPeriodo.setText("Aplica Filtro");
        this.JCHBFPeriodo.addActionListener(new ActionListener() { // from class: Contabilidad.JIFInformesMov.1
            public void actionPerformed(ActionEvent evt) {
                JIFInformesMov.this.JCHBFPeriodoActionPerformed(evt);
            }
        });
        this.JCBPeriodo.setFont(new Font("Arial", 1, 12));
        this.JCBPeriodo.setBorder(BorderFactory.createTitledBorder((Border) null, "Periodo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBPeriodo.setEnabled(false);
        this.JDFFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFFechaI.setFont(new Font("Arial", 1, 12));
        GroupLayout JPIPeriodoLayout = new GroupLayout(this.JPIPeriodo);
        this.JPIPeriodo.setLayout(JPIPeriodoLayout);
        JPIPeriodoLayout.setHorizontalGroup(JPIPeriodoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIPeriodoLayout.createSequentialGroup().addContainerGap().addGroup(JPIPeriodoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHBFPeriodo).addGroup(GroupLayout.Alignment.TRAILING, JPIPeriodoLayout.createSequentialGroup().addComponent(this.JCBPeriodo, 0, 281, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JDFFechaI, -2, 121, -2))).addContainerGap()));
        JPIPeriodoLayout.setVerticalGroup(JPIPeriodoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIPeriodoLayout.createSequentialGroup().addGroup(JPIPeriodoLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPIPeriodoLayout.createSequentialGroup().addContainerGap().addComponent(this.JDFFechaI, -2, -1, -2)).addGroup(GroupLayout.Alignment.LEADING, JPIPeriodoLayout.createSequentialGroup().addComponent(this.JCHBFPeriodo).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 9, 32767).addComponent(this.JCBPeriodo, -2, -1, -2))).addContainerGap()));
        this.JPITercero.setBorder(BorderFactory.createTitledBorder((Border) null, "TERCERO", 0, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JCHBFTercero.setFont(new Font("Arial", 1, 12));
        this.JCHBFTercero.setText("Aplica Filtro");
        this.JCHBFTercero.addActionListener(new ActionListener() { // from class: Contabilidad.JIFInformesMov.2
            public void actionPerformed(ActionEvent evt) {
                JIFInformesMov.this.JCHBFTerceroActionPerformed(evt);
            }
        });
        this.JTFFNit.setBorder(BorderFactory.createTitledBorder((Border) null, "Nit", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFNit.setHorizontalAlignment(4);
        this.JTFFNit.setEnabled(false);
        this.JTFFNit.setFont(new Font("Arial", 1, 12));
        this.JTFFNit.addFocusListener(new FocusAdapter() { // from class: Contabilidad.JIFInformesMov.3
            public void focusLost(FocusEvent evt) {
                JIFInformesMov.this.JTFFNitFocusLost(evt);
            }
        });
        this.JCBTercero.setFont(new Font("Arial", 1, 12));
        this.JCBTercero.setBorder(BorderFactory.createTitledBorder((Border) null, "Tercero", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTercero.setEnabled(false);
        GroupLayout JPITerceroLayout = new GroupLayout(this.JPITercero);
        this.JPITercero.setLayout(JPITerceroLayout);
        JPITerceroLayout.setHorizontalGroup(JPITerceroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPITerceroLayout.createSequentialGroup().addContainerGap().addGroup(JPITerceroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPITerceroLayout.createSequentialGroup().addComponent(this.JTFFNit, -2, 101, -2).addGap(18, 18, 18).addComponent(this.JCBTercero, 0, 567, 32767)).addComponent(this.JCHBFTercero)).addContainerGap()));
        JPITerceroLayout.setVerticalGroup(JPITerceroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPITerceroLayout.createSequentialGroup().addComponent(this.JCHBFTercero).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPITerceroLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBTercero, -2, -1, -2).addComponent(this.JTFFNit, -2, 51, -2)).addContainerGap()));
        this.JPITipoDoc.setBorder(BorderFactory.createTitledBorder((Border) null, "TIPO DOCUMENTO", 0, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JCHBFTipoDoc.setFont(new Font("Arial", 1, 12));
        this.JCHBFTipoDoc.setText("Aplica Filtro");
        this.JCHBFTipoDoc.addActionListener(new ActionListener() { // from class: Contabilidad.JIFInformesMov.4
            public void actionPerformed(ActionEvent evt) {
                JIFInformesMov.this.JCHBFTipoDocActionPerformed(evt);
            }
        });
        this.JCBTipoDoc.setFont(new Font("Arial", 1, 12));
        this.JCBTipoDoc.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Documento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTipoDoc.setEnabled(false);
        GroupLayout JPITipoDocLayout = new GroupLayout(this.JPITipoDoc);
        this.JPITipoDoc.setLayout(JPITipoDocLayout);
        JPITipoDocLayout.setHorizontalGroup(JPITipoDocLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPITipoDocLayout.createSequentialGroup().addContainerGap().addGroup(JPITipoDocLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBTipoDoc, 0, 395, 32767).addComponent(this.JCHBFTipoDoc)).addContainerGap()));
        JPITipoDocLayout.setVerticalGroup(JPITipoDocLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPITipoDocLayout.createSequentialGroup().addComponent(this.JCHBFTipoDoc).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 7, 32767).addComponent(this.JCBTipoDoc, -2, -1, -2)));
        this.JPICuentas.setBorder(BorderFactory.createTitledBorder((Border) null, "PUC", 0, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JCHBFCuentaP.setFont(new Font("Arial", 1, 12));
        this.JCHBFCuentaP.setText("Aplica Filtro");
        this.JCHBFCuentaP.addActionListener(new ActionListener() { // from class: Contabilidad.JIFInformesMov.5
            public void actionPerformed(ActionEvent evt) {
                JIFInformesMov.this.JCHBFCuentaPActionPerformed(evt);
            }
        });
        this.JTFFPuc2.setBorder(BorderFactory.createTitledBorder((Border) null, "Cuenta Contable", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFPuc2.setHorizontalAlignment(4);
        this.JTFFPuc2.setEnabled(false);
        this.JTFFPuc2.setFont(new Font("Arial", 1, 12));
        GroupLayout JPICuentasLayout = new GroupLayout(this.JPICuentas);
        this.JPICuentas.setLayout(JPICuentasLayout);
        JPICuentasLayout.setHorizontalGroup(JPICuentasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPICuentasLayout.createSequentialGroup().addContainerGap().addGroup(JPICuentasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHBFCuentaP).addComponent(this.JTFFPuc2, -2, 113, -2)).addContainerGap(-1, 32767)));
        JPICuentasLayout.setVerticalGroup(JPICuentasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPICuentasLayout.createSequentialGroup().addComponent(this.JCHBFCuentaP).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JTFFPuc2, -2, -1, -2)));
        GroupLayout JPIFiltroLayout = new GroupLayout(this.JPIFiltro);
        this.JPIFiltro.setLayout(JPIFiltroLayout);
        JPIFiltroLayout.setHorizontalGroup(JPIFiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFiltroLayout.createSequentialGroup().addContainerGap().addGroup(JPIFiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFiltroLayout.createSequentialGroup().addComponent(this.JPIPeriodo, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JPITipoDoc, -1, -1, 32767)).addGroup(GroupLayout.Alignment.TRAILING, JPIFiltroLayout.createSequentialGroup().addComponent(this.JPITercero, -1, -1, 32767).addGap(18, 18, 18).addComponent(this.JPICuentas, -2, -1, -2))).addContainerGap()));
        JPIFiltroLayout.setVerticalGroup(JPIFiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIFiltroLayout.createSequentialGroup().addContainerGap().addGroup(JPIFiltroLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JPITipoDoc, -1, -1, 32767).addComponent(this.JPIPeriodo, -1, -1, 32767)).addGap(7, 7, 7).addGroup(JPIFiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPICuentas, -1, -1, 32767).addComponent(this.JPITercero, GroupLayout.Alignment.TRAILING, -2, 108, -2)).addContainerGap()));
        this.JBTGenerar.setFont(new Font("Arial", 1, 12));
        this.JBTGenerar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTGenerar.setText("Generar");
        this.JBTGenerar.addActionListener(new ActionListener() { // from class: Contabilidad.JIFInformesMov.6
            public void actionPerformed(ActionEvent evt) {
                JIFInformesMov.this.JBTGenerarActionPerformed(evt);
            }
        });
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("c:\\\\plantilla.xls");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ruta", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: Contabilidad.JIFInformesMov.7
            public void mouseClicked(MouseEvent evt) {
                JIFInformesMov.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JTPDatosD.setForeground(Color.red);
        this.JTPDatosD.setFont(new Font("Arial", 1, 14));
        this.JTResultado.setBorder(BorderFactory.createBevelBorder(0));
        this.JTResultado.setFont(new Font("Arial", 1, 12));
        this.JTResultado.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTResultado.setEditingColumn(1);
        this.JTResultado.setEditingRow(1);
        this.JTResultado.setRowHeight(25);
        this.JTResultado.setSelectionBackground(new Color(255, 255, 255));
        this.JTResultado.setSelectionForeground(Color.red);
        this.JTResultado.setSelectionMode(0);
        this.JSPResultado.setViewportView(this.JTResultado);
        this.JTPDatosD.addTab("DETALLE", this.JSPResultado);
        this.JTResultado1.setBorder(BorderFactory.createBevelBorder(0));
        this.JTResultado1.setFont(new Font("Arial", 1, 12));
        this.JTResultado1.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTResultado1.setEditingColumn(1);
        this.JTResultado1.setEditingRow(1);
        this.JTResultado1.setRowHeight(25);
        this.JTResultado1.setSelectionBackground(new Color(255, 255, 255));
        this.JTResultado1.setSelectionForeground(Color.red);
        this.JTResultado1.setSelectionMode(0);
        this.JSPResultado1.setViewportView(this.JTResultado1);
        this.JTPDatosD.addTab("CONSOLIDADO", this.JSPResultado1);
        this.JTFFValorD.setBorder(BorderFactory.createTitledBorder((Border) null, "Total Débito", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFValorD.setHorizontalAlignment(4);
        this.JTFFValorD.setFont(new Font("Arial", 1, 13));
        this.JTFFValorC.setBorder(BorderFactory.createTitledBorder((Border) null, "Total Crédito", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFValorC.setHorizontalAlignment(4);
        this.JTFFValorC.setFont(new Font("Arial", 1, 13));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JTPDatosD, GroupLayout.Alignment.LEADING, -1, 925, 32767).addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup().addComponent(this.JTFRuta, -2, 264, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTGenerar, -2, 248, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 155, 32767).addComponent(this.JTFFValorD, -2, 123, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFValorC, -2, 123, -2)).addComponent(this.JPIFiltro, GroupLayout.Alignment.LEADING, -1, -1, 32767)).addContainerGap(-1, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIFiltro, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTPDatosD, -2, 390, -2).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(layout.createSequentialGroup().addGap(22, 22, 22).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFRuta, GroupLayout.Alignment.TRAILING, -1, 85, 32767).addComponent(this.JBTGenerar, -1, 57, 32767))).addGroup(layout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFValorD, -2, 57, -2).addComponent(this.JTFFValorC, -2, 57, -2)))).addGap(17, 17, 17)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBFPeriodoActionPerformed(ActionEvent evt) {
        if (this.JCHBFPeriodo.isSelected()) {
            this.JCBPeriodo.setEnabled(true);
            this.JCBPeriodo.requestFocus();
        } else {
            this.JCBPeriodo.setSelectedIndex(-1);
            this.JCBPeriodo.setEnabled(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBFTerceroActionPerformed(ActionEvent evt) {
        if (this.JCHBFTercero.isSelected()) {
            this.JTFFNit.setEnabled(true);
            this.JCBTercero.setEnabled(true);
            this.JTFFNit.requestFocus();
            if (this.JCHBFTipoDoc.isSelected() && this.JCBTipoDoc.getSelectedIndex() != -1) {
                this.JCBTercero.removeAllItems();
                this.xidtercero = this.xconsultas.llenarCombo("SELECT g_empresa.Id, cc_terceros.`RazonSocialCompleta` FROM  " + this.xcc_detalle_documentoc + " INNER JOIN " + this.xcc_documentoc + "  ON (" + this.xcc_detalle_documentoc + ".Id_Documentoc = " + this.xcc_documentoc + ".Id) INNER JOIN `cc_terceros`  ON (cc_terceros.Id = " + this.xcc_detalle_documentoc + ".Id_Tercero)   WHERE (" + this.xcc_documentoc + ".Id_TipoComprobante ='" + this.xidtipodoc[this.JCBTipoDoc.getSelectedIndex()] + "' and " + this.xcc_documentoc + ".Estado=1) GROUP BY g_empresa.Id ORDER BY cc_terceros.`RazonSocialCompleta` ASC", this.xidtercero, this.JCBTercero);
                this.JCBTercero.setSelectedIndex(-1);
                this.xconsultas.cerrarConexionBd();
                return;
            }
            return;
        }
        this.JTFFNit.setEnabled(false);
        this.JCBTercero.setSelectedIndex(-1);
        this.JCBTercero.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBFTipoDocActionPerformed(ActionEvent evt) {
        if (this.JCHBFTipoDoc.isSelected()) {
            this.JCBTipoDoc.setEnabled(true);
            this.JCBTipoDoc.requestFocus();
            if (this.JCHBFTipoDoc.isSelected() && this.JCBTipoDoc.getSelectedIndex() != -1) {
                this.JCBTercero.removeAllItems();
                this.xidtercero = this.xconsultas.llenarCombo("SELECT g_empresa.Id, cc_terceros.`RazonSocialCompleta` FROM  " + this.xcc_detalle_documentoc + " INNER JOIN " + this.xcc_documentoc + "  ON (" + this.xcc_detalle_documentoc + ".Id_Documentoc = " + this.xcc_documentoc + ".Id) INNER JOIN `cc_terceros`  ON (cc_terceros.Id = " + this.xcc_detalle_documentoc + ".Id_Tercero)   WHERE (" + this.xcc_documentoc + ".Id_TipoComprobante ='" + this.xidtipodoc[this.JCBTipoDoc.getSelectedIndex()] + "' and " + this.xcc_documentoc + ".Estado=1) GROUP BY g_empresa.Id ORDER BY cc_terceros.`RazonSocialCompleta` ASC", this.xidtercero, this.JCBTercero);
                this.JCBTercero.setSelectedIndex(-1);
                this.xconsultas.cerrarConexionBd();
                return;
            }
            return;
        }
        this.JCBTipoDoc.setSelectedIndex(-1);
        this.JCBTipoDoc.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBFCuentaPActionPerformed(ActionEvent evt) {
        if (this.JCHBFCuentaP.isSelected()) {
            this.JTFFPuc2.setEnabled(true);
            this.JTFFPuc2.requestFocus();
        } else {
            this.JTFFPuc2.setEnabled(false);
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

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTGenerarActionPerformed(ActionEvent evt) {
        if (this.JTPDatosD.getSelectedIndex() == 0) {
            if (this.JTResultado.getRowCount() > 0) {
                int x = JOptionPane.showConfirmDialog(this, "Esta seguro de exportar?", "CONFIRMACIÓN", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (x == 0) {
                    this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTResultado, this.JTFRuta.getText(), getTitle() + " - " + this.JTPDatosD.getTitleAt(0));
                    return;
                }
                return;
            }
            return;
        }
        if (this.JTResultado1.getRowCount() > 0) {
            int x2 = JOptionPane.showConfirmDialog(this, "Esta seguro de exportar?", "CONFIRMACIÓN", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x2 == 0) {
                this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTResultado1, this.JTFRuta.getText(), getTitle() + " - " + this.JTPDatosD.getTitleAt(1));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFNitFocusLost(FocusEvent evt) {
        if (!this.JTFFNit.getText().isEmpty()) {
            mBuscarTerceroNit();
        }
    }

    private void mBuscarTerceroNit() {
        try {
            this.xsql = "SELECT Nbre FROM g_empresa WHERE IF(Dig_Verificacion='', No_identificacion, CONCAT(No_identificacion,'-',Dig_Verificacion))='" + this.JTFFNit.getText() + "' AND g_empresa.Estado=1 ";
            ResultSet xrs = this.xconsultas.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.first();
                this.JCBTercero.setSelectedItem(xrs.getString(1));
            }
            xrs.close();
            this.xconsultas.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFInformesMov.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mNuevo() {
        this.JDFFechaI.setDate(this.xmt.getFechaActual());
        this.JCBTipoDoc.removeAllItems();
        this.JCBPeriodo.removeAllItems();
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
        this.xidtipodoc = this.xconsultas.llenarCombo("SELECT Id, Nbre FROM cc_tipo_documentoc WHERE (EsContable =1 AND Estado =1) ORDER BY Nbre ASC", this.xidtipodoc, this.JCBTipoDoc);
        this.JCBTipoDoc.setSelectedIndex(-1);
        this.xsql = "SELECT Id, IF(Nbre IS NULL || Nbre='',DevuelveMes(FechaI),Nbre) AS FechaP ,  FechaI , FechaF FROM cc_periodo_contable WHERE (Estado =1) ORDER BY FechaI DESC ";
        this.xidperiodo = this.xconsultas.llenarComboyLista(this.xsql, this.xidperiodo, this.JCBPeriodo, 4);
        this.JCBPeriodo.setSelectedIndex(-1);
        this.JCBTercero.removeAllItems();
        this.xidtercero = this.xconsultas.llenarCombo("SELECT cc_terceros.Id, cc_terceros.`RazonSocialCompleta` FROM  " + this.xcc_detalle_documentoc + " INNER JOIN " + this.xcc_documentoc + "  ON (" + this.xcc_detalle_documentoc + ".Id_Documentoc = " + this.xcc_documentoc + ".Id) INNER JOIN `cc_terceros`  ON (cc_terceros.Id = " + this.xcc_detalle_documentoc + ".Id_Tercero)   GROUP BY cc_terceros.Id ORDER BY cc_terceros.`RazonSocialCompleta` ASC", this.xidtercero, this.JCBTercero);
        this.JCBTercero.setSelectedIndex(-1);
        this.xconsultas.cerrarConexionBd();
        this.JCHBFCuentaP.setSelected(false);
        this.JCHBFPeriodo.setSelected(false);
        this.JCHBFTercero.setSelected(false);
        this.JCHBFTipoDoc.setSelected(false);
        this.JTFFNit.setText("");
        this.JTFFPuc2.setText("");
        mCrearModeloDatos();
        mCrearModeloDatosC();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Fecha Periodo", "CodigoDoc", "Documento", "Tipo Documento", "Tercero", "FechaC", "N° Doc", "Puc", "Cuenta", "Nat", "V/Debito", "V/Credito", "Base", "DescripciónG", "DescripciónE"}) { // from class: Contabilidad.JIFInformesMov.8
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, Long.class, String.class, String.class, String.class, Double.class, Double.class, Double.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTResultado;
        JTable jTable2 = this.JTResultado;
        jTable.setAutoResizeMode(0);
        this.JTResultado.doLayout();
        this.JTResultado.setModel(this.xmodelo);
        this.JTResultado.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTResultado.getColumnModel().getColumn(1).setPreferredWidth(0);
        this.JTResultado.getColumnModel().getColumn(1).setMinWidth(0);
        this.JTResultado.getColumnModel().getColumn(1).setMaxWidth(0);
        this.JTResultado.getColumnModel().getColumn(2).setPreferredWidth(0);
        this.JTResultado.getColumnModel().getColumn(2).setMinWidth(0);
        this.JTResultado.getColumnModel().getColumn(2).setMaxWidth(0);
        this.JTResultado.getColumnModel().getColumn(3).setPreferredWidth(0);
        this.JTResultado.getColumnModel().getColumn(3).setMinWidth(0);
        this.JTResultado.getColumnModel().getColumn(3).setMaxWidth(0);
        this.JTResultado.getColumnModel().getColumn(4).setPreferredWidth(300);
        this.JTResultado.getColumnModel().getColumn(5).setPreferredWidth(0);
        this.JTResultado.getColumnModel().getColumn(5).setMinWidth(0);
        this.JTResultado.getColumnModel().getColumn(5).setMaxWidth(0);
        this.JTResultado.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTResultado.getColumnModel().getColumn(7).setPreferredWidth(120);
        this.JTResultado.getColumnModel().getColumn(8).setPreferredWidth(0);
        this.JTResultado.getColumnModel().getColumn(8).setMinWidth(0);
        this.JTResultado.getColumnModel().getColumn(8).setMaxWidth(0);
        this.JTResultado.getColumnModel().getColumn(9).setPreferredWidth(120);
        this.JTResultado.getColumnModel().getColumn(10).setPreferredWidth(120);
        this.JTResultado.getColumnModel().getColumn(11).setPreferredWidth(120);
        this.JTResultado.getColumnModel().getColumn(12).setPreferredWidth(0);
        this.JTResultado.getColumnModel().getColumn(12).setMinWidth(0);
        this.JTResultado.getColumnModel().getColumn(12).setMaxWidth(0);
        this.JTResultado.getColumnModel().getColumn(13).setPreferredWidth(0);
        this.JTResultado.getColumnModel().getColumn(13).setMinWidth(0);
        this.JTResultado.getColumnModel().getColumn(13).setMaxWidth(0);
        this.JTResultado.getColumnModel().getColumn(14).setPreferredWidth(300);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatosC() {
        this.xmodelo1 = new DefaultTableModel(new Object[0], new String[]{"Codigo", "Documento", "V/Debito", "V/Credito"}) { // from class: Contabilidad.JIFInformesMov.9
            Class[] types = {String.class, String.class, Double.class, Double.class};
            boolean[] canEdit = {false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTResultado1;
        JTable jTable2 = this.JTResultado1;
        jTable.setAutoResizeMode(0);
        this.JTResultado1.doLayout();
        this.JTResultado1.setModel(this.xmodelo1);
        this.JTResultado1.getColumnModel().getColumn(0).setPreferredWidth(120);
        this.JTResultado1.getColumnModel().getColumn(1).setPreferredWidth(400);
        this.JTResultado1.getColumnModel().getColumn(2).setPreferredWidth(120);
        this.JTResultado1.getColumnModel().getColumn(3).setPreferredWidth(120);
    }

    public void mBuscar() {
        if (this.JCHBFPeriodo.isSelected() && !this.JCHBFTipoDoc.isSelected() && !this.JCHBFTercero.isSelected() && !this.JCHBFCuentaP.isSelected()) {
            if (this.JCBPeriodo.getSelectedIndex() != -1) {
                this.xsql = "SELECT cc_periodo_contable.FechaI, cc_tipo_documentoc.CodigoC, cc_tipo_documentoc.Nbre, cc_terceros.`TDCompleto1`, cc_terceros.`RazonSocialCompleta`, " + this.xcc_documentoc + ".FechaD, " + this.xcc_documentoc + ".Id, " + this.xcc_detalle_documentoc + ".Id_Puc, CAST( IF(" + this.xcc_puc + ".PBase<>0, CONCAT(" + this.xcc_puc + ".Nbre,' ', CONCAT(" + this.xcc_puc + ".PBase,'%') )," + this.xcc_puc + ".Nbre) AS  CHAR ) AS NCuenta, IF(" + this.xcc_detalle_documentoc + ".TipoCPuc=0,'Debito','Credito')  AS Naturaleza, " + this.xcc_detalle_documentoc + ".VDebito , " + this.xcc_detalle_documentoc + ".VCredito, " + this.xcc_detalle_documentoc + ".Base , " + this.xcc_documentoc + ".Descripcion, " + this.xcc_detalle_documentoc + ".Concepto FROM " + this.xcc_detalle_documentoc + " INNER JOIN " + this.xcc_documentoc + "  ON (" + this.xcc_detalle_documentoc + ".Id_Documentoc = " + this.xcc_documentoc + ".Id) INNER JOIN cc_tipo_documentoc  ON (" + this.xcc_documentoc + ".Id_TipoComprobante = cc_tipo_documentoc.Id) INNER JOIN cc_periodo_contable  ON (cc_periodo_contable.Id = " + this.xcc_documentoc + ".Id_PeriodoC) INNER JOIN " + this.xcc_puc + "  ON (" + this.xcc_puc + ".Id = " + this.xcc_detalle_documentoc + ".Id_Puc) INNER JOIN `cc_terceros`  ON (cc_terceros.Id = " + this.xcc_detalle_documentoc + ".Id_Tercero)   WHERE (" + this.xcc_documentoc + ".Estado =1 AND " + this.xcc_documentoc + ".Id_PeriodoC ='" + this.xidperiodo[this.JCBPeriodo.getSelectedIndex()][0] + "') ";
                mCargarDatosTabla(this.xsql);
                String xsql1 = "SELECT cc_tipo_documentoc.CodigoC, cc_tipo_documentoc.Nbre, SUM(" + this.xcc_detalle_documentoc + ".VDebito) AS SDebito,SUM(" + this.xcc_detalle_documentoc + ".VCredito) AS SCredito FROM " + this.xcc_detalle_documentoc + " INNER JOIN " + this.xcc_documentoc + "  ON (" + this.xcc_detalle_documentoc + ".Id_Documentoc = " + this.xcc_documentoc + ".Id) INNER JOIN cc_tipo_documentoc  ON (" + this.xcc_documentoc + ".Id_TipoComprobante = cc_tipo_documentoc.Id)  INNER JOIN cc_periodo_contable  ON (cc_periodo_contable.Id = " + this.xcc_documentoc + ".Id_PeriodoC) INNER JOIN " + this.xcc_puc + "  ON (" + this.xcc_puc + ".Id = " + this.xcc_detalle_documentoc + ".Id_Puc) INNER JOIN `cc_terceros`  ON (cc_terceros.Id = " + this.xcc_detalle_documentoc + ".Id_Tercero)    WHERE (" + this.xcc_documentoc + ".Estado =1 AND " + this.xcc_documentoc + ".Id_PeriodoC ='" + this.xidperiodo[this.JCBPeriodo.getSelectedIndex()][0] + "') GROUP BY cc_tipo_documentoc.Nbre  ";
                mCargarDatosTabla1(xsql1);
                return;
            }
            return;
        }
        if (!this.JCHBFPeriodo.isSelected() && this.JCHBFTipoDoc.isSelected() && !this.JCHBFTercero.isSelected() && !this.JCHBFCuentaP.isSelected()) {
            if (this.JCBTipoDoc.getSelectedIndex() != -1) {
                this.xsql = "SELECT cc_periodo_contable.FechaI, cc_tipo_documentoc.CodigoC, cc_tipo_documentoc.Nbre, cc_terceros.`TDCompleto1`, cc_terceros.`RazonSocialCompleta`, " + this.xcc_documentoc + ".FechaD, " + this.xcc_documentoc + ".Id, " + this.xcc_detalle_documentoc + ".Id_Puc, CAST( IF(" + this.xcc_puc + ".PBase<>0, CONCAT(" + this.xcc_puc + ".Nbre,' ', CONCAT(" + this.xcc_puc + ".PBase,'%') )," + this.xcc_puc + ".Nbre) AS  CHAR ) AS NCuenta, IF(" + this.xcc_detalle_documentoc + ".TipoCPuc=0,'Debito','Credito')  AS Naturaleza, " + this.xcc_detalle_documentoc + ".VDebito , " + this.xcc_detalle_documentoc + ".VCredito, " + this.xcc_detalle_documentoc + ".Base , " + this.xcc_documentoc + ".Descripcion, " + this.xcc_detalle_documentoc + ".Concepto FROM " + this.xcc_detalle_documentoc + " INNER JOIN " + this.xcc_documentoc + "  ON (" + this.xcc_detalle_documentoc + ".Id_Documentoc = " + this.xcc_documentoc + ".Id) INNER JOIN cc_tipo_documentoc  ON (" + this.xcc_documentoc + ".Id_TipoComprobante = cc_tipo_documentoc.Id) INNER JOIN cc_periodo_contable  ON (cc_periodo_contable.Id = " + this.xcc_documentoc + ".Id_PeriodoC) INNER JOIN " + this.xcc_puc + "  ON (" + this.xcc_puc + ".Id = " + this.xcc_detalle_documentoc + ".Id_Puc) INNER JOIN `cc_terceros`  ON (cc_terceros.Id = " + this.xcc_detalle_documentoc + ".Id_Tercero)   WHERE (" + this.xcc_documentoc + ".Estado =1 AND " + this.xcc_documentoc + ".Id_TipoComprobante ='" + this.xidtipodoc[this.JCBTipoDoc.getSelectedIndex()] + "') ";
                mCargarDatosTabla(this.xsql);
                String xsql12 = "SELECT cc_tipo_documentoc.CodigoC, cc_tipo_documentoc.Nbre, SUM(" + this.xcc_detalle_documentoc + ".VDebito) AS SDebito,SUM(" + this.xcc_detalle_documentoc + ".VCredito) AS SCredito FROM " + this.xcc_detalle_documentoc + " INNER JOIN " + this.xcc_documentoc + "  ON (" + this.xcc_detalle_documentoc + ".Id_Documentoc = " + this.xcc_documentoc + ".Id) INNER JOIN cc_tipo_documentoc  ON (" + this.xcc_documentoc + ".Id_TipoComprobante = cc_tipo_documentoc.Id)  INNER JOIN cc_periodo_contable  ON (cc_periodo_contable.Id = " + this.xcc_documentoc + ".Id_PeriodoC) INNER JOIN " + this.xcc_puc + "  ON (" + this.xcc_puc + ".Id = " + this.xcc_detalle_documentoc + ".Id_Puc) INNER JOIN `cc_terceros`  ON (cc_terceros.Id = " + this.xcc_detalle_documentoc + ".Id_Tercero)    WHERE (" + this.xcc_documentoc + ".Estado =1 AND " + this.xcc_documentoc + ".Id_TipoComprobante ='" + this.xidtipodoc[this.JCBTipoDoc.getSelectedIndex()] + "') GROUP BY cc_tipo_documentoc.Nbre  ";
                mCargarDatosTabla1(xsql12);
                return;
            }
            return;
        }
        if (!this.JCHBFPeriodo.isSelected() && !this.JCHBFTipoDoc.isSelected() && this.JCHBFTercero.isSelected() && !this.JCHBFCuentaP.isSelected()) {
            if (this.JCBTercero.getSelectedIndex() != -1) {
                this.xsql = "SELECT cc_periodo_contable.FechaI, cc_tipo_documentoc.CodigoC, cc_tipo_documentoc.Nbre, cc_terceros.`TDCompleto1`, cc_terceros.`RazonSocialCompleta`, " + this.xcc_documentoc + ".FechaD, " + this.xcc_documentoc + ".Id, " + this.xcc_detalle_documentoc + ".Id_Puc, CAST( IF(" + this.xcc_puc + ".PBase<>0, CONCAT(" + this.xcc_puc + ".Nbre,' ', CONCAT(" + this.xcc_puc + ".PBase,'%') )," + this.xcc_puc + ".Nbre) AS  CHAR ) AS NCuenta, IF(" + this.xcc_detalle_documentoc + ".TipoCPuc=0,'Debito','Credito')  AS Naturaleza, " + this.xcc_detalle_documentoc + ".VDebito , " + this.xcc_detalle_documentoc + ".VCredito, " + this.xcc_detalle_documentoc + ".Base , " + this.xcc_documentoc + ".Descripcion, " + this.xcc_detalle_documentoc + ".Concepto FROM " + this.xcc_detalle_documentoc + " INNER JOIN " + this.xcc_documentoc + "  ON (" + this.xcc_detalle_documentoc + ".Id_Documentoc = " + this.xcc_documentoc + ".Id) INNER JOIN cc_tipo_documentoc  ON (" + this.xcc_documentoc + ".Id_TipoComprobante = cc_tipo_documentoc.Id) INNER JOIN cc_periodo_contable  ON (cc_periodo_contable.Id = " + this.xcc_documentoc + ".Id_PeriodoC) INNER JOIN " + this.xcc_puc + "  ON (" + this.xcc_puc + ".Id = " + this.xcc_detalle_documentoc + ".Id_Puc) INNER JOIN `cc_terceros`  ON (cc_terceros.Id = " + this.xcc_detalle_documentoc + ".Id_Tercero)   WHERE (" + this.xcc_documentoc + ".Estado =1 AND " + this.xcc_detalle_documentoc + ".Id_Tercero ='" + this.xidtercero[this.JCBTercero.getSelectedIndex()] + "') ";
                mCargarDatosTabla(this.xsql);
                String xsql13 = "SELECT cc_tipo_documentoc.CodigoC, cc_tipo_documentoc.Nbre, SUM(" + this.xcc_detalle_documentoc + ".VDebito) AS SDebito,SUM(" + this.xcc_detalle_documentoc + ".VCredito) AS SCredito FROM " + this.xcc_detalle_documentoc + " INNER JOIN " + this.xcc_documentoc + "  ON (" + this.xcc_detalle_documentoc + ".Id_Documentoc = " + this.xcc_documentoc + ".Id) INNER JOIN cc_tipo_documentoc  ON (" + this.xcc_documentoc + ".Id_TipoComprobante = cc_tipo_documentoc.Id)  INNER JOIN cc_periodo_contable  ON (cc_periodo_contable.Id = " + this.xcc_documentoc + ".Id_PeriodoC) INNER JOIN " + this.xcc_puc + "  ON (" + this.xcc_puc + ".Id = " + this.xcc_detalle_documentoc + ".Id_Puc) INNER JOIN `cc_terceros`  ON (cc_terceros.Id = " + this.xcc_detalle_documentoc + ".Id_Tercero)    WHERE (" + this.xcc_documentoc + ".Estado =1 AND " + this.xcc_detalle_documentoc + ".Id_Tercero ='" + this.xidtercero[this.JCBTercero.getSelectedIndex()] + "') GROUP BY cc_tipo_documentoc.Nbre  ";
                mCargarDatosTabla1(xsql13);
                return;
            }
            return;
        }
        if (!this.JCHBFPeriodo.isSelected() && !this.JCHBFTipoDoc.isSelected() && !this.JCHBFTercero.isSelected() && this.JCHBFCuentaP.isSelected()) {
            if (!this.JTFFPuc2.getText().isEmpty()) {
                this.xsql = "SELECT cc_periodo_contable.FechaI, cc_tipo_documentoc.CodigoC, cc_tipo_documentoc.Nbre, cc_terceros.`TDCompleto1`, cc_terceros.`RazonSocialCompleta`, " + this.xcc_documentoc + ".FechaD, " + this.xcc_documentoc + ".Id, " + this.xcc_detalle_documentoc + ".Id_Puc, CAST( IF(" + this.xcc_puc + ".PBase<>0, CONCAT(" + this.xcc_puc + ".Nbre,' ', CONCAT(" + this.xcc_puc + ".PBase,'%') )," + this.xcc_puc + ".Nbre) AS  CHAR ) AS NCuenta, IF(" + this.xcc_detalle_documentoc + ".TipoCPuc=0,'Debito','Credito')  AS Naturaleza, " + this.xcc_detalle_documentoc + ".VDebito , " + this.xcc_detalle_documentoc + ".VCredito, " + this.xcc_detalle_documentoc + ".Base , " + this.xcc_documentoc + ".Descripcion, " + this.xcc_detalle_documentoc + ".Concepto FROM " + this.xcc_detalle_documentoc + " INNER JOIN " + this.xcc_documentoc + "  ON (" + this.xcc_detalle_documentoc + ".Id_Documentoc = " + this.xcc_documentoc + ".Id) INNER JOIN cc_tipo_documentoc  ON (" + this.xcc_documentoc + ".Id_TipoComprobante = cc_tipo_documentoc.Id) INNER JOIN cc_periodo_contable  ON (cc_periodo_contable.Id = " + this.xcc_documentoc + ".Id_PeriodoC) INNER JOIN " + this.xcc_puc + "  ON (" + this.xcc_puc + ".Id = " + this.xcc_detalle_documentoc + ".Id_Puc) INNER JOIN `cc_terceros`  ON (cc_terceros.Id = " + this.xcc_detalle_documentoc + ".Id_Tercero)   WHERE (" + this.xcc_documentoc + ".Estado =1 AND " + this.xcc_detalle_documentoc + ".Id_Puc ='" + this.JTFFPuc2.getText() + "') ";
                mCargarDatosTabla(this.xsql);
                String xsql14 = "SELECT cc_tipo_documentoc.CodigoC, cc_tipo_documentoc.Nbre, SUM(" + this.xcc_detalle_documentoc + ".VDebito) AS SDebito,SUM(" + this.xcc_detalle_documentoc + ".VCredito) AS SCredito FROM " + this.xcc_detalle_documentoc + " INNER JOIN " + this.xcc_documentoc + "  ON (" + this.xcc_detalle_documentoc + ".Id_Documentoc = " + this.xcc_documentoc + ".Id) INNER JOIN cc_tipo_documentoc  ON (" + this.xcc_documentoc + ".Id_TipoComprobante = cc_tipo_documentoc.Id)  INNER JOIN cc_periodo_contable  ON (cc_periodo_contable.Id = " + this.xcc_documentoc + ".Id_PeriodoC) INNER JOIN " + this.xcc_puc + "  ON (" + this.xcc_puc + ".Id = " + this.xcc_detalle_documentoc + ".Id_Puc) INNER JOIN `cc_terceros`  ON (cc_terceros.Id = " + this.xcc_detalle_documentoc + ".Id_Tercero)    WHERE (" + this.xcc_documentoc + ".Estado =1 AND " + this.xcc_detalle_documentoc + ".Id_Puc ='" + this.JTFFPuc2.getText() + "')  GROUP BY cc_tipo_documentoc.Nbre  ";
                mCargarDatosTabla1(xsql14);
                return;
            }
            return;
        }
        if (this.JCHBFPeriodo.isSelected() && this.JCHBFTipoDoc.isSelected() && !this.JCHBFTercero.isSelected() && !this.JCHBFCuentaP.isSelected()) {
            if (this.JCBPeriodo.getSelectedIndex() != -1 && this.JCBTipoDoc.getSelectedIndex() != -1) {
                this.xsql = "SELECT cc_periodo_contable.FechaI, cc_tipo_documentoc.CodigoC, cc_tipo_documentoc.Nbre, cc_terceros.`TDCompleto1`, cc_terceros.`RazonSocialCompleta`, " + this.xcc_documentoc + ".FechaD, " + this.xcc_documentoc + ".Id, " + this.xcc_detalle_documentoc + ".Id_Puc, CAST( IF(" + this.xcc_puc + ".PBase<>0, CONCAT(" + this.xcc_puc + ".Nbre,' ', CONCAT(" + this.xcc_puc + ".PBase,'%') )," + this.xcc_puc + ".Nbre) AS  CHAR ) AS NCuenta, IF(" + this.xcc_detalle_documentoc + ".TipoCPuc=0,'Debito','Credito')  AS Naturaleza, " + this.xcc_detalle_documentoc + ".VDebito , " + this.xcc_detalle_documentoc + ".VCredito, " + this.xcc_detalle_documentoc + ".Base , " + this.xcc_documentoc + ".Descripcion, " + this.xcc_detalle_documentoc + ".Concepto FROM " + this.xcc_detalle_documentoc + " INNER JOIN " + this.xcc_documentoc + "  ON (" + this.xcc_detalle_documentoc + ".Id_Documentoc = " + this.xcc_documentoc + ".Id) INNER JOIN cc_tipo_documentoc  ON (" + this.xcc_documentoc + ".Id_TipoComprobante = cc_tipo_documentoc.Id) INNER JOIN cc_periodo_contable  ON (cc_periodo_contable.Id = " + this.xcc_documentoc + ".Id_PeriodoC) INNER JOIN " + this.xcc_puc + "  ON (" + this.xcc_puc + ".Id = " + this.xcc_detalle_documentoc + ".Id_Puc) INNER JOIN `cc_terceros`  ON (cc_terceros.Id = " + this.xcc_detalle_documentoc + ".Id_Tercero)   WHERE (" + this.xcc_documentoc + ".Estado =1 AND " + this.xcc_documentoc + ".Id_PeriodoC ='" + this.xidperiodo[this.JCBPeriodo.getSelectedIndex()][0] + "' AND " + this.xcc_documentoc + ".Id_TipoComprobante ='" + this.xidtipodoc[this.JCBTipoDoc.getSelectedIndex()] + "') ";
                mCargarDatosTabla(this.xsql);
                String xsql15 = "SELECT cc_tipo_documentoc.CodigoC, cc_tipo_documentoc.Nbre, SUM(" + this.xcc_detalle_documentoc + ".VDebito) AS SDebito,SUM(" + this.xcc_detalle_documentoc + ".VCredito) AS SCredito FROM " + this.xcc_detalle_documentoc + " INNER JOIN " + this.xcc_documentoc + "  ON (" + this.xcc_detalle_documentoc + ".Id_Documentoc = " + this.xcc_documentoc + ".Id) INNER JOIN cc_tipo_documentoc  ON (" + this.xcc_documentoc + ".Id_TipoComprobante = cc_tipo_documentoc.Id)  INNER JOIN cc_periodo_contable  ON (cc_periodo_contable.Id = " + this.xcc_documentoc + ".Id_PeriodoC) INNER JOIN " + this.xcc_puc + "  ON (" + this.xcc_puc + ".Id = " + this.xcc_detalle_documentoc + ".Id_Puc) INNER JOIN `cc_terceros`  ON (cc_terceros.Id = " + this.xcc_detalle_documentoc + ".Id_Tercero)    WHERE (" + this.xcc_documentoc + ".Estado =1 AND " + this.xcc_documentoc + ".Id_PeriodoC ='" + this.xidperiodo[this.JCBPeriodo.getSelectedIndex()][0] + "' AND " + this.xcc_documentoc + ".Id_TipoComprobante ='" + this.xidtipodoc[this.JCBTipoDoc.getSelectedIndex()] + "')  GROUP BY cc_tipo_documentoc.Nbre  ";
                mCargarDatosTabla1(xsql15);
                return;
            }
            return;
        }
        if (this.JCHBFPeriodo.isSelected() && !this.JCHBFTipoDoc.isSelected() && this.JCHBFTercero.isSelected() && !this.JCHBFCuentaP.isSelected()) {
            if (this.JCBPeriodo.getSelectedIndex() != -1 && this.JCBTercero.getSelectedIndex() != -1) {
                this.xsql = "SELECT cc_periodo_contable.FechaI, cc_tipo_documentoc.CodigoC, cc_tipo_documentoc.Nbre, cc_terceros.`TDCompleto1`, cc_terceros.`RazonSocialCompleta`, " + this.xcc_documentoc + ".FechaD, " + this.xcc_documentoc + ".Id, " + this.xcc_detalle_documentoc + ".Id_Puc, CAST( IF(" + this.xcc_puc + ".PBase<>0, CONCAT(" + this.xcc_puc + ".Nbre,' ', CONCAT(" + this.xcc_puc + ".PBase,'%') )," + this.xcc_puc + ".Nbre) AS  CHAR ) AS NCuenta, IF(" + this.xcc_detalle_documentoc + ".TipoCPuc=0,'Debito','Credito')  AS Naturaleza, " + this.xcc_detalle_documentoc + ".VDebito , " + this.xcc_detalle_documentoc + ".VCredito, " + this.xcc_detalle_documentoc + ".Base , " + this.xcc_documentoc + ".Descripcion, " + this.xcc_detalle_documentoc + ".Concepto FROM " + this.xcc_detalle_documentoc + " INNER JOIN " + this.xcc_documentoc + "  ON (" + this.xcc_detalle_documentoc + ".Id_Documentoc = " + this.xcc_documentoc + ".Id) INNER JOIN cc_tipo_documentoc  ON (" + this.xcc_documentoc + ".Id_TipoComprobante = cc_tipo_documentoc.Id) INNER JOIN cc_periodo_contable  ON (cc_periodo_contable.Id = " + this.xcc_documentoc + ".Id_PeriodoC) INNER JOIN " + this.xcc_puc + "  ON (" + this.xcc_puc + ".Id = " + this.xcc_detalle_documentoc + ".Id_Puc) INNER JOIN `cc_terceros`  ON (cc_terceros.Id = " + this.xcc_detalle_documentoc + ".Id_Tercero)   WHERE (" + this.xcc_documentoc + ".Estado =1 AND " + this.xcc_documentoc + ".Id_PeriodoC ='" + this.xidperiodo[this.JCBPeriodo.getSelectedIndex()][0] + "' AND " + this.xcc_detalle_documentoc + ".Id_Tercero ='" + this.xidtercero[this.JCBTercero.getSelectedIndex()] + "') ";
                mCargarDatosTabla(this.xsql);
                String xsql16 = "SELECT cc_tipo_documentoc.CodigoC, cc_tipo_documentoc.Nbre, SUM(" + this.xcc_detalle_documentoc + ".VDebito) AS SDebito,SUM(" + this.xcc_detalle_documentoc + ".VCredito) AS SCredito FROM " + this.xcc_detalle_documentoc + " INNER JOIN " + this.xcc_documentoc + "  ON (" + this.xcc_detalle_documentoc + ".Id_Documentoc = " + this.xcc_documentoc + ".Id) INNER JOIN cc_tipo_documentoc  ON (" + this.xcc_documentoc + ".Id_TipoComprobante = cc_tipo_documentoc.Id)  INNER JOIN cc_periodo_contable  ON (cc_periodo_contable.Id = " + this.xcc_documentoc + ".Id_PeriodoC) INNER JOIN " + this.xcc_puc + "  ON (" + this.xcc_puc + ".Id = " + this.xcc_detalle_documentoc + ".Id_Puc) INNER JOIN `cc_terceros`  ON (cc_terceros.Id = " + this.xcc_detalle_documentoc + ".Id_Tercero)    WHERE (" + this.xcc_documentoc + ".Estado =1 AND " + this.xcc_documentoc + ".Id_PeriodoC ='" + this.xidperiodo[this.JCBPeriodo.getSelectedIndex()][0] + "' AND " + this.xcc_detalle_documentoc + ".Id_Tercero ='" + this.xidtercero[this.JCBTercero.getSelectedIndex()] + "')  GROUP BY cc_tipo_documentoc.Nbre  ";
                mCargarDatosTabla1(xsql16);
                return;
            }
            return;
        }
        if (this.JCHBFPeriodo.isSelected() && !this.JCHBFTipoDoc.isSelected() && !this.JCHBFTercero.isSelected() && this.JCHBFCuentaP.isSelected()) {
            if (this.JCBPeriodo.getSelectedIndex() != -1 && !this.JTFFPuc2.getText().isEmpty()) {
                this.xsql = "SELECT cc_periodo_contable.FechaI, cc_tipo_documentoc.CodigoC, cc_tipo_documentoc.Nbre, cc_terceros.`TDCompleto1`, cc_terceros.`RazonSocialCompleta`, " + this.xcc_documentoc + ".FechaD, " + this.xcc_documentoc + ".Id, " + this.xcc_detalle_documentoc + ".Id_Puc, CAST( IF(" + this.xcc_puc + ".PBase<>0, CONCAT(" + this.xcc_puc + ".Nbre,' ', CONCAT(" + this.xcc_puc + ".PBase,'%') )," + this.xcc_puc + ".Nbre) AS  CHAR ) AS NCuenta, IF(" + this.xcc_detalle_documentoc + ".TipoCPuc=0,'Debito','Credito')  AS Naturaleza, " + this.xcc_detalle_documentoc + ".VDebito , " + this.xcc_detalle_documentoc + ".VCredito, " + this.xcc_detalle_documentoc + ".Base , " + this.xcc_documentoc + ".Descripcion, " + this.xcc_detalle_documentoc + ".Concepto FROM " + this.xcc_detalle_documentoc + " INNER JOIN " + this.xcc_documentoc + "  ON (" + this.xcc_detalle_documentoc + ".Id_Documentoc = " + this.xcc_documentoc + ".Id) INNER JOIN cc_tipo_documentoc  ON (" + this.xcc_documentoc + ".Id_TipoComprobante = cc_tipo_documentoc.Id) INNER JOIN cc_periodo_contable  ON (cc_periodo_contable.Id = " + this.xcc_documentoc + ".Id_PeriodoC) INNER JOIN " + this.xcc_puc + "  ON (" + this.xcc_puc + ".Id = " + this.xcc_detalle_documentoc + ".Id_Puc) INNER JOIN `cc_terceros`  ON (cc_terceros.Id = " + this.xcc_detalle_documentoc + ".Id_Tercero)   WHERE (" + this.xcc_documentoc + ".Estado =1 AND " + this.xcc_documentoc + ".Id_PeriodoC ='" + this.xidperiodo[this.JCBPeriodo.getSelectedIndex()][0] + "' AND " + this.xcc_detalle_documentoc + ".Id_Puc ='" + this.JTFFPuc2.getText() + "') ";
                mCargarDatosTabla(this.xsql);
                String xsql17 = "SELECT cc_tipo_documentoc.CodigoC, cc_tipo_documentoc.Nbre, SUM(" + this.xcc_detalle_documentoc + ".VDebito) AS SDebito,SUM(" + this.xcc_detalle_documentoc + ".VCredito) AS SCredito FROM " + this.xcc_detalle_documentoc + " INNER JOIN " + this.xcc_documentoc + "  ON (" + this.xcc_detalle_documentoc + ".Id_Documentoc = " + this.xcc_documentoc + ".Id) INNER JOIN cc_tipo_documentoc  ON (" + this.xcc_documentoc + ".Id_TipoComprobante = cc_tipo_documentoc.Id)  INNER JOIN cc_periodo_contable  ON (cc_periodo_contable.Id = " + this.xcc_documentoc + ".Id_PeriodoC) INNER JOIN " + this.xcc_puc + "  ON (" + this.xcc_puc + ".Id = " + this.xcc_detalle_documentoc + ".Id_Puc) INNER JOIN `cc_terceros`  ON (cc_terceros.Id = " + this.xcc_detalle_documentoc + ".Id_Tercero)    WHERE (" + this.xcc_documentoc + ".Estado =1 AND " + this.xcc_documentoc + ".Id_PeriodoC ='" + this.xidperiodo[this.JCBPeriodo.getSelectedIndex()][0] + "' AND " + this.xcc_detalle_documentoc + ".Id_Puc ='" + this.JTFFPuc2.getText() + "')  GROUP BY cc_tipo_documentoc.Nbre  ";
                mCargarDatosTabla1(xsql17);
                return;
            }
            return;
        }
        if (!this.JCHBFPeriodo.isSelected() && this.JCHBFTipoDoc.isSelected() && this.JCHBFTercero.isSelected() && !this.JCHBFCuentaP.isSelected()) {
            if (this.JCBTipoDoc.getSelectedIndex() != -1 && this.JCBTercero.getSelectedIndex() != -1) {
                this.xsql = "SELECT cc_periodo_contable.FechaI, cc_tipo_documentoc.CodigoC, cc_tipo_documentoc.Nbre, cc_terceros.`TDCompleto1`, cc_terceros.`RazonSocialCompleta`, " + this.xcc_documentoc + ".FechaD, " + this.xcc_documentoc + ".Id, " + this.xcc_detalle_documentoc + ".Id_Puc, CAST( IF(" + this.xcc_puc + ".PBase<>0, CONCAT(" + this.xcc_puc + ".Nbre,' ', CONCAT(" + this.xcc_puc + ".PBase,'%') )," + this.xcc_puc + ".Nbre) AS  CHAR ) AS NCuenta, IF(" + this.xcc_detalle_documentoc + ".TipoCPuc=0,'Debito','Credito')  AS Naturaleza, " + this.xcc_detalle_documentoc + ".VDebito , " + this.xcc_detalle_documentoc + ".VCredito, " + this.xcc_detalle_documentoc + ".Base , " + this.xcc_documentoc + ".Descripcion, " + this.xcc_detalle_documentoc + ".Concepto FROM " + this.xcc_detalle_documentoc + " INNER JOIN " + this.xcc_documentoc + "  ON (" + this.xcc_detalle_documentoc + ".Id_Documentoc = " + this.xcc_documentoc + ".Id) INNER JOIN cc_tipo_documentoc  ON (" + this.xcc_documentoc + ".Id_TipoComprobante = cc_tipo_documentoc.Id) INNER JOIN cc_periodo_contable  ON (cc_periodo_contable.Id = " + this.xcc_documentoc + ".Id_PeriodoC) INNER JOIN " + this.xcc_puc + "  ON (" + this.xcc_puc + ".Id = " + this.xcc_detalle_documentoc + ".Id_Puc) INNER JOIN `cc_terceros`  ON (cc_terceros.Id = " + this.xcc_detalle_documentoc + ".Id_Tercero)   WHERE (" + this.xcc_documentoc + ".Estado =1 AND " + this.xcc_documentoc + ".Id_TipoComprobante ='" + this.xidtipodoc[this.JCBTipoDoc.getSelectedIndex()] + "' AND " + this.xcc_detalle_documentoc + ".Id_Tercero ='" + this.xidtercero[this.JCBTercero.getSelectedIndex()] + "') ";
                mCargarDatosTabla(this.xsql);
                String xsql18 = "SELECT cc_tipo_documentoc.CodigoC, cc_tipo_documentoc.Nbre, SUM(" + this.xcc_detalle_documentoc + ".VDebito) AS SDebito,SUM(" + this.xcc_detalle_documentoc + ".VCredito) AS SCredito FROM " + this.xcc_detalle_documentoc + " INNER JOIN " + this.xcc_documentoc + "  ON (" + this.xcc_detalle_documentoc + ".Id_Documentoc = " + this.xcc_documentoc + ".Id) INNER JOIN cc_tipo_documentoc  ON (" + this.xcc_documentoc + ".Id_TipoComprobante = cc_tipo_documentoc.Id)  INNER JOIN cc_periodo_contable  ON (cc_periodo_contable.Id = " + this.xcc_documentoc + ".Id_PeriodoC) INNER JOIN " + this.xcc_puc + "  ON (" + this.xcc_puc + ".Id = " + this.xcc_detalle_documentoc + ".Id_Puc) INNER JOIN `cc_terceros`  ON (cc_terceros.Id = " + this.xcc_detalle_documentoc + ".Id_Tercero)    WHERE (" + this.xcc_documentoc + ".Estado =1 AND " + this.xcc_documentoc + ".Id_TipoComprobante ='" + this.xidtipodoc[this.JCBTipoDoc.getSelectedIndex()] + "' AND " + this.xcc_detalle_documentoc + ".Id_Tercero ='" + this.xidtercero[this.JCBTercero.getSelectedIndex()] + "')  GROUP BY cc_tipo_documentoc.Nbre  ";
                mCargarDatosTabla1(xsql18);
                return;
            }
            return;
        }
        if (!this.JCHBFPeriodo.isSelected() && this.JCHBFTipoDoc.isSelected() && !this.JCHBFTercero.isSelected() && this.JCHBFCuentaP.isSelected()) {
            if (this.JCBTipoDoc.getSelectedIndex() != -1 && !this.JTFFPuc2.getText().isEmpty()) {
                this.xsql = "SELECT cc_periodo_contable.FechaI, cc_tipo_documentoc.CodigoC, cc_tipo_documentoc.Nbre, cc_terceros.`TDCompleto1`, cc_terceros.`RazonSocialCompleta`, " + this.xcc_documentoc + ".FechaD, " + this.xcc_documentoc + ".Id, " + this.xcc_detalle_documentoc + ".Id_Puc, CAST( IF(" + this.xcc_puc + ".PBase<>0, CONCAT(" + this.xcc_puc + ".Nbre,' ', CONCAT(" + this.xcc_puc + ".PBase,'%') )," + this.xcc_puc + ".Nbre) AS  CHAR ) AS NCuenta, IF(" + this.xcc_detalle_documentoc + ".TipoCPuc=0,'Debito','Credito')  AS Naturaleza, " + this.xcc_detalle_documentoc + ".VDebito , " + this.xcc_detalle_documentoc + ".VCredito, " + this.xcc_detalle_documentoc + ".Base , " + this.xcc_documentoc + ".Descripcion, " + this.xcc_detalle_documentoc + ".Concepto FROM " + this.xcc_detalle_documentoc + " INNER JOIN " + this.xcc_documentoc + "  ON (" + this.xcc_detalle_documentoc + ".Id_Documentoc = " + this.xcc_documentoc + ".Id) INNER JOIN cc_tipo_documentoc  ON (" + this.xcc_documentoc + ".Id_TipoComprobante = cc_tipo_documentoc.Id) INNER JOIN cc_periodo_contable  ON (cc_periodo_contable.Id = " + this.xcc_documentoc + ".Id_PeriodoC) INNER JOIN " + this.xcc_puc + "  ON (" + this.xcc_puc + ".Id = " + this.xcc_detalle_documentoc + ".Id_Puc) INNER JOIN `cc_terceros`  ON (cc_terceros.Id = " + this.xcc_detalle_documentoc + ".Id_Tercero)   WHERE (" + this.xcc_documentoc + ".Estado =1 AND " + this.xcc_documentoc + ".Id_TipoComprobante ='" + this.xidtipodoc[this.JCBTipoDoc.getSelectedIndex()] + "' AND " + this.xcc_detalle_documentoc + ".Id_Puc ='" + this.JTFFPuc2.getText() + "') ";
                mCargarDatosTabla(this.xsql);
                String xsql19 = "SELECT cc_tipo_documentoc.CodigoC, cc_tipo_documentoc.Nbre, SUM(" + this.xcc_detalle_documentoc + ".VDebito) AS SDebito,SUM(" + this.xcc_detalle_documentoc + ".VCredito) AS SCredito FROM " + this.xcc_detalle_documentoc + " INNER JOIN " + this.xcc_documentoc + "  ON (" + this.xcc_detalle_documentoc + ".Id_Documentoc = " + this.xcc_documentoc + ".Id) INNER JOIN cc_tipo_documentoc  ON (" + this.xcc_documentoc + ".Id_TipoComprobante = cc_tipo_documentoc.Id)  INNER JOIN cc_periodo_contable  ON (cc_periodo_contable.Id = " + this.xcc_documentoc + ".Id_PeriodoC) INNER JOIN " + this.xcc_puc + "  ON (" + this.xcc_puc + ".Id = " + this.xcc_detalle_documentoc + ".Id_Puc) INNER JOIN `cc_terceros`  ON (cc_terceros.Id = " + this.xcc_detalle_documentoc + ".Id_Tercero)    WHERE (" + this.xcc_documentoc + ".Estado =1 AND " + this.xcc_documentoc + ".Id_TipoComprobante ='" + this.xidtipodoc[this.JCBTipoDoc.getSelectedIndex()] + "' AND " + this.xcc_detalle_documentoc + ".Id_Puc ='" + this.JTFFPuc2.getText() + "')  GROUP BY cc_tipo_documentoc.Nbre  ";
                mCargarDatosTabla1(xsql19);
                return;
            }
            return;
        }
        if (!this.JCHBFPeriodo.isSelected() && !this.JCHBFTipoDoc.isSelected() && this.JCHBFTercero.isSelected() && this.JCHBFCuentaP.isSelected()) {
            if (this.JCBTercero.getSelectedIndex() != -1 && !this.JTFFPuc2.getText().isEmpty()) {
                this.xsql = "SELECT cc_periodo_contable.FechaI, cc_tipo_documentoc.CodigoC, cc_tipo_documentoc.Nbre, cc_terceros.`TDCompleto1`, cc_terceros.`RazonSocialCompleta`, " + this.xcc_documentoc + ".FechaD, " + this.xcc_documentoc + ".Id, " + this.xcc_detalle_documentoc + ".Id_Puc, CAST( IF(" + this.xcc_puc + ".PBase<>0, CONCAT(" + this.xcc_puc + ".Nbre,' ', CONCAT(" + this.xcc_puc + ".PBase,'%') )," + this.xcc_puc + ".Nbre) AS  CHAR ) AS NCuenta, IF(" + this.xcc_detalle_documentoc + ".TipoCPuc=0,'Debito','Credito')  AS Naturaleza, " + this.xcc_detalle_documentoc + ".VDebito , " + this.xcc_detalle_documentoc + ".VCredito, " + this.xcc_detalle_documentoc + ".Base , " + this.xcc_documentoc + ".Descripcion, " + this.xcc_detalle_documentoc + ".Concepto FROM " + this.xcc_detalle_documentoc + " INNER JOIN " + this.xcc_documentoc + "  ON (" + this.xcc_detalle_documentoc + ".Id_Documentoc = " + this.xcc_documentoc + ".Id) INNER JOIN cc_tipo_documentoc  ON (" + this.xcc_documentoc + ".Id_TipoComprobante = cc_tipo_documentoc.Id) INNER JOIN cc_periodo_contable  ON (cc_periodo_contable.Id = " + this.xcc_documentoc + ".Id_PeriodoC) INNER JOIN " + this.xcc_puc + "  ON (" + this.xcc_puc + ".Id = " + this.xcc_detalle_documentoc + ".Id_Puc) INNER JOIN `cc_terceros`  ON (cc_terceros.Id = " + this.xcc_detalle_documentoc + ".Id_Tercero)   WHERE (" + this.xcc_documentoc + ".Estado =1 AND " + this.xcc_detalle_documentoc + ".Id_Puc ='" + this.JTFFPuc2.getText() + "' AND " + this.xcc_detalle_documentoc + ".Id_Tercero ='" + this.xidtercero[this.JCBTercero.getSelectedIndex()] + "') ";
                mCargarDatosTabla(this.xsql);
                String xsql110 = "SELECT cc_tipo_documentoc.CodigoC, cc_tipo_documentoc.Nbre, SUM(" + this.xcc_detalle_documentoc + ".VDebito) AS SDebito,SUM(" + this.xcc_detalle_documentoc + ".VCredito) AS SCredito FROM " + this.xcc_detalle_documentoc + " INNER JOIN " + this.xcc_documentoc + "  ON (" + this.xcc_detalle_documentoc + ".Id_Documentoc = " + this.xcc_documentoc + ".Id) INNER JOIN cc_tipo_documentoc  ON (" + this.xcc_documentoc + ".Id_TipoComprobante = cc_tipo_documentoc.Id)  INNER JOIN cc_periodo_contable  ON (cc_periodo_contable.Id = " + this.xcc_documentoc + ".Id_PeriodoC) INNER JOIN " + this.xcc_puc + "  ON (" + this.xcc_puc + ".Id = " + this.xcc_detalle_documentoc + ".Id_Puc) INNER JOIN `cc_terceros`  ON (cc_terceros.Id = " + this.xcc_detalle_documentoc + ".Id_Tercero)    WHERE (" + this.xcc_documentoc + ".Estado =1 AND " + this.xcc_detalle_documentoc + ".Id_Puc ='" + this.JTFFPuc2.getText() + "' AND " + this.xcc_detalle_documentoc + ".Id_Tercero ='" + this.xidtercero[this.JCBTercero.getSelectedIndex()] + "') GROUP BY cc_tipo_documentoc.Nbre  ";
                mCargarDatosTabla1(xsql110);
                return;
            }
            return;
        }
        if (this.JCHBFPeriodo.isSelected() && this.JCHBFTipoDoc.isSelected() && this.JCHBFTercero.isSelected() && !this.JCHBFCuentaP.isSelected() && this.JCBTercero.getSelectedIndex() != -1 && this.JCBTipoDoc.getSelectedIndex() != -1 && this.JCBPeriodo.getSelectedIndex() != -1) {
            this.xsql = "SELECT cc_periodo_contable.FechaI, cc_tipo_documentoc.CodigoC, cc_tipo_documentoc.Nbre, cc_terceros.`TDCompleto1`, cc_terceros.`RazonSocialCompleta`, " + this.xcc_documentoc + ".FechaD, " + this.xcc_documentoc + ".Id, " + this.xcc_detalle_documentoc + ".Id_Puc, CAST( IF(" + this.xcc_puc + ".PBase<>0, CONCAT(" + this.xcc_puc + ".Nbre,' ', CONCAT(" + this.xcc_puc + ".PBase,'%') )," + this.xcc_puc + ".Nbre) AS  CHAR ) AS NCuenta, IF(" + this.xcc_detalle_documentoc + ".TipoCPuc=0,'Debito','Credito')  AS Naturaleza, " + this.xcc_detalle_documentoc + ".VDebito , " + this.xcc_detalle_documentoc + ".VCredito, " + this.xcc_detalle_documentoc + ".Base , " + this.xcc_documentoc + ".Descripcion, " + this.xcc_detalle_documentoc + ".Concepto FROM " + this.xcc_detalle_documentoc + " INNER JOIN " + this.xcc_documentoc + "  ON (" + this.xcc_detalle_documentoc + ".Id_Documentoc = " + this.xcc_documentoc + ".Id) INNER JOIN cc_tipo_documentoc  ON (" + this.xcc_documentoc + ".Id_TipoComprobante = cc_tipo_documentoc.Id) INNER JOIN cc_periodo_contable  ON (cc_periodo_contable.Id = " + this.xcc_documentoc + ".Id_PeriodoC) INNER JOIN " + this.xcc_puc + "  ON (" + this.xcc_puc + ".Id = " + this.xcc_detalle_documentoc + ".Id_Puc) INNER JOIN `cc_terceros`  ON (cc_terceros.Id = " + this.xcc_detalle_documentoc + ".Id_Tercero)   WHERE (" + this.xcc_documentoc + ".Estado =1 AND " + this.xcc_documentoc + ".Id_PeriodoC ='" + this.xidperiodo[this.JCBPeriodo.getSelectedIndex()][0] + "' AND " + this.xcc_documentoc + ".Id_TipoComprobante ='" + this.xidtipodoc[this.JCBTipoDoc.getSelectedIndex()] + "'  AND " + this.xcc_detalle_documentoc + ".Id_Tercero ='" + this.xidtercero[this.JCBTercero.getSelectedIndex()] + "') ";
            mCargarDatosTabla(this.xsql);
            String xsql111 = "SELECT cc_tipo_documentoc.CodigoC, cc_tipo_documentoc.Nbre, SUM(" + this.xcc_detalle_documentoc + ".VDebito) AS SDebito,SUM(" + this.xcc_detalle_documentoc + ".VCredito) AS SCredito FROM " + this.xcc_detalle_documentoc + " INNER JOIN " + this.xcc_documentoc + "  ON (" + this.xcc_detalle_documentoc + ".Id_Documentoc = " + this.xcc_documentoc + ".Id) INNER JOIN cc_tipo_documentoc  ON (" + this.xcc_documentoc + ".Id_TipoComprobante = cc_tipo_documentoc.Id)  INNER JOIN cc_periodo_contable  ON (cc_periodo_contable.Id = " + this.xcc_documentoc + ".Id_PeriodoC) INNER JOIN " + this.xcc_puc + "  ON (" + this.xcc_puc + ".Id = " + this.xcc_detalle_documentoc + ".Id_Puc) INNER JOIN `cc_terceros`  ON (cc_terceros.Id = " + this.xcc_detalle_documentoc + ".Id_Tercero)    WHERE (" + this.xcc_documentoc + ".Estado =1 AND " + this.xcc_documentoc + ".Id_PeriodoC ='" + this.xidperiodo[this.JCBPeriodo.getSelectedIndex()][0] + "' AND " + this.xcc_documentoc + ".Id_TipoComprobante ='" + this.xidtipodoc[this.JCBTipoDoc.getSelectedIndex()] + "'  AND " + this.xcc_detalle_documentoc + ".Id_Tercero ='" + this.xidtercero[this.JCBTercero.getSelectedIndex()] + "') GROUP BY cc_tipo_documentoc.Nbre  ";
            mCargarDatosTabla1(xsql111);
        }
    }

    private void mCargarDatosTabla(String sql) {
        try {
            mCrearModeloDatos();
            ResultSet xrs = this.xconsultas.traerRs(sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                double xvdebito = 0.0d;
                double xvcredito = 0.0d;
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(xrs.getString(1), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelo.setValueAt(xrs.getString(4), n, 3);
                    this.xmodelo.setValueAt(xrs.getString(5), n, 4);
                    this.xmodelo.setValueAt(xrs.getString(6), n, 5);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(7)), n, 6);
                    this.xmodelo.setValueAt(xrs.getString(8), n, 7);
                    this.xmodelo.setValueAt(xrs.getString(9), n, 8);
                    this.xmodelo.setValueAt(xrs.getString(10), n, 9);
                    xvdebito += xrs.getDouble(11);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(11)), n, 10);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(12)), n, 11);
                    xvcredito += xrs.getDouble(12);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(13)), n, 12);
                    this.xmodelo.setValueAt(xrs.getString(14), n, 13);
                    this.xmodelo.setValueAt(xrs.getString(15), n, 14);
                    n++;
                }
                this.JTFFValorD.setValue(Double.valueOf(xvdebito));
                this.JTFFValorC.setValue(Double.valueOf(xvcredito));
            }
            xrs.close();
            this.xconsultas.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFInformesMov.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarDatosTabla1(String sql) {
        try {
            mCrearModeloDatosC();
            ResultSet xrs = this.xconsultas.traerRs(sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo1.addRow(this.xdatos);
                    this.xmodelo1.setValueAt(xrs.getString(1), n, 0);
                    this.xmodelo1.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo1.setValueAt(Double.valueOf(xrs.getDouble(3)), n, 2);
                    this.xmodelo1.setValueAt(Double.valueOf(xrs.getDouble(4)), n, 3);
                    n++;
                }
            }
            xrs.close();
            this.xconsultas.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFInformesMov.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }
}
