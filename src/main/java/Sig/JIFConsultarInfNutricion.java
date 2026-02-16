package Sig;

import Acceso.Principal;
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
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

/* JADX INFO: loaded from: GenomaP.jar:Sig/JIFConsultarInfNutricion.class */
public class JIFConsultarInfNutricion extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private DefaultTableModel xmodelo1;
    private DefaultTableModel xmodelo2;
    private String xsql;
    private Object[] xdato;
    private String xnombre;
    private JButton JBTExportar;
    private JComboBox JCBOperador;
    private JDateChooser JDFechaF;
    private JDateChooser JDFechaI;
    private JPanel JPIDExportar;
    private JPanel JPIDatos;
    private JScrollPane JSPDetalle;
    private JSpinner JSPValor;
    public JTable JTDetalle;
    private JFormattedTextField JTFFTotalA;
    private JFormattedTextField JTFFTotalP;
    private JFormattedTextField JTFFTotalPR;
    private JFormattedTextField JTFFTotalU;
    private JTextField JTFRuta;
    private Metodos xmt = new Metodos();
    private ConsultasMySQL xct = new ConsultasMySQL();
    private int xtipoc = 0;

    public JIFConsultarInfNutricion() {
        initComponents();
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v57, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPIDatos = new JPanel();
        this.JDFechaI = new JDateChooser();
        this.JDFechaF = new JDateChooser();
        this.JCBOperador = new JComboBox();
        this.JSPValor = new JSpinner();
        this.JTFFTotalA = new JFormattedTextField();
        this.JTFFTotalU = new JFormattedTextField();
        this.JTFFTotalP = new JFormattedTextField();
        this.JTFFTotalPR = new JFormattedTextField();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JPIDExportar = new JPanel();
        this.JBTExportar = new JButton();
        this.JTFRuta = new JTextField();
        setClosable(true);
        setIconifiable(true);
        setTitle("INFORME DE REDUCCIÓNES Y/O AUMENTOS DE PESO EN NUTRICIÓN");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjifconsultarinfnutricion");
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 0, 0, new Font("Arial", 1, 14), Color.red));
        this.JDFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicial", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFechaI.setFont(new Font("Arial", 1, 12));
        this.JDFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Final", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFechaF.setFont(new Font("Arial", 1, 12));
        this.JCBOperador.setFont(new Font("Arial", 1, 12));
        this.JCBOperador.setModel(new DefaultComboBoxModel(new String[]{"=", ">", "<", ">=", "<="}));
        this.JCBOperador.setBorder(BorderFactory.createTitledBorder((Border) null, "Operador Lógico", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPValor.setFont(new Font("Arial", 1, 12));
        this.JSPValor.setModel(new SpinnerNumberModel(0, 0, (Comparable) null, 1));
        this.JSPValor.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFTotalA.setBorder(BorderFactory.createTitledBorder((Border) null, "T Atenciones", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFTotalA.setHorizontalAlignment(4);
        this.JTFFTotalA.setFont(new Font("Arial", 1, 12));
        this.JTFFTotalU.setBorder(BorderFactory.createTitledBorder((Border) null, "T Usuarios", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFTotalU.setHorizontalAlignment(4);
        this.JTFFTotalU.setFont(new Font("Arial", 1, 13));
        this.JTFFTotalP.setBorder(BorderFactory.createTitledBorder((Border) null, "%", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFTotalP.setHorizontalAlignment(4);
        this.JTFFTotalP.setFont(new Font("Arial", 1, 13));
        this.JTFFTotalPR.setBorder(BorderFactory.createTitledBorder((Border) null, "% General", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFTotalPR.setHorizontalAlignment(4);
        this.JTFFTotalPR.setFont(new Font("Arial", 1, 13));
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addComponent(this.JDFechaI, -2, 136, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JDFechaF, -2, 136, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBOperador, -2, 134, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPValor, -2, 72, -2).addGap(26, 26, 26).addComponent(this.JTFFTotalA, -2, 98, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFTotalU, -2, 87, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFTotalP, -2, 87, -2).addGap(18, 18, 18).addComponent(this.JTFFTotalPR, -2, 87, -2).addContainerGap(28, 32767)));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFTotalA, -1, 56, 32767).addComponent(this.JTFFTotalU, -1, 56, 32767).addComponent(this.JTFFTotalP, -1, 56, 32767).addComponent(this.JTFFTotalPR, -1, 56, 32767)).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBOperador, -1, 56, 32767).addComponent(this.JSPValor, -1, 56, 32767)).addComponent(this.JDFechaI, -1, 56, 32767).addComponent(this.JDFechaF, -1, 56, 32767)).addContainerGap()));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTDetalle.setBorder(BorderFactory.createBevelBorder(0));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalle.setEditingColumn(0);
        this.JTDetalle.setEditingRow(0);
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setRowMargin(4);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.setSelectionMode(0);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: Sig.JIFConsultarInfNutricion.1
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarInfNutricion.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.JPIDExportar.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS PARA EXPORTAR", 0, 0, new Font("Arial", 1, 14), Color.red));
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: Sig.JIFConsultarInfNutricion.2
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarInfNutricion.this.JBTExportarActionPerformed(evt);
            }
        });
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: Sig.JIFConsultarInfNutricion.3
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarInfNutricion.this.JTFRutaMouseClicked(evt);
            }
        });
        GroupLayout JPIDExportarLayout = new GroupLayout(this.JPIDExportar);
        this.JPIDExportar.setLayout(JPIDExportarLayout);
        JPIDExportarLayout.setHorizontalGroup(JPIDExportarLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDExportarLayout.createSequentialGroup().addComponent(this.JTFRuta, -2, 639, -2).addGap(18, 18, 18).addComponent(this.JBTExportar, -1, -1, 32767).addContainerGap()));
        JPIDExportarLayout.setVerticalGroup(JPIDExportarLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDExportarLayout.createSequentialGroup().addContainerGap().addGroup(JPIDExportarLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JBTExportar, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.JTFRuta, -2, 50, -2)).addContainerGap()));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JPIDExportar, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.JPIDatos, GroupLayout.Alignment.LEADING, -1, -1, 32767)).addContainerGap()).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JSPDetalle, -1, 963, 32767).addContainerGap())));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 293, 32767).addComponent(this.JPIDExportar, -2, -1, -2).addContainerGap()).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(136, 136, 136).addComponent(this.JSPDetalle, -2, 254, -2).addContainerGap(128, 32767))));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTExportarActionPerformed(ActionEvent evt) {
        if (this.JTDetalle.getRowCount() != 0) {
            mExportar();
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
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedColumn() != -1) {
            String[][] mparametros = new String[4][2];
            mparametros[0][0] = "idatencion1";
            mparametros[0][1] = this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 17).toString();
            mparametros[1][0] = "idpaciente1";
            mparametros[1][1] = this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 22).toString();
            mparametros[2][0] = "SUBREPORT_DIR";
            mparametros[2][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
            mparametros[3][0] = "SUBREPORTFIRMA_DIR";
            mparametros[3][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
            this.xmt.GenerarPDF(this.xmt.getRutaRep() + "H_HistoriaClinicaNutricion", mparametros);
        }
    }

    public void mBuscar() {
        this.xsql = "DROP VIEW IF EXISTS e_refc ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "CREATE VIEW `baseserver`.`e_refc`  AS SELECT MAX(h_atencion.Fecha_Atencion) AS FechaAtencion , ingreso.Id_Usuario , persona.NoHistoria , persona.NUsuario , persona.IdSexo , g_parentesco.Nbre AS Nparentesco, h_nutricional.Imc, persona.Id_TipoIdentificacion, persona.NoDocumento, persona.FechaNac, persona.Edad, persona.Telefono , persona.NTipoEdad , persona.NMunicipio , persona.NBarrio , persona.Direccion , g_tipoempresa.Nbre AS NTipoEmpresa , persona.EPS , persona.TipoAfiliacion, h_atencion.Id as IdAtencion, persona.Id_Persona  FROM h_nutricional INNER JOIN h_atencion  ON (h_nutricional.Id_Atencion = h_atencion.Id) INNER JOIN ingreso ON (h_atencion.Id_Ingreso = ingreso.Id) INNER JOIN persona  ON (persona.Id_persona = ingreso.Id_Usuario) INNER JOIN g_usuario_fpz  ON (g_usuario_fpz.Id_Persona = persona.Id_persona) INNER JOIN g_parentesco  ON (g_parentesco.Id = g_usuario_fpz.Id_Parentesco) INNER JOIN g_tipoempresa  ON (g_usuario_fpz.Id_Empresa = g_tipoempresa.Id) WHERE (h_atencion.Fecha_Atencion >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND h_atencion.Codigo_Dxp <>'') GROUP BY ingreso.Id_Usuario HAVING (FechaAtencion <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "') ORDER BY ingreso.Id_Usuario ASC ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        mCargarDetalle();
    }

    public void mNuevo() {
        Principal.mLimpiarDatosP();
        this.JDFechaI.setDate(this.xmt.getFechaActual());
        this.JDFechaF.setDate(this.xmt.getFechaActual());
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
        mCrearTablaDetalle();
    }

    private void mCrearTablaDetalle() {
        this.xmodelo = new DefaultTableModel((Object[][]) null, new String[]{"FATención", "N° HC", "TipoD", "Documento", "Usuario", "Sexo", "FechaNac", "Edad", "TEdad", "Municipio", "Barrio", "Direción", "Telefono", "Parentesco", "TipoEmpresa", "Eps", "TipoAfiliacion", "IdAtencion", "FechaRef", "ImcP", "ImcU", "Resultado", "IdUsuario"}) { // from class: Sig.JIFConsultarInfNutricion.4
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, Long.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Long.class, String.class, Double.class, Double.class, Double.class, Long.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return this.canEdit[colIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(2).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(2).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(3).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(3).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(6).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(6).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(9).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(9).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(10).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(10).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(11).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(11).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(12).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(12).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(12).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(13).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(13).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(13).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(14).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(14).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(14).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(15).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(15).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(15).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(16).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(16).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(16).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(17).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(17).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(17).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(18).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(19).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(20).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(21).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(22).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(22).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(22).setMaxWidth(0);
    }

    private void mCargarDetalle() {
        mCrearTablaDetalle();
        this.xsql = "SELECT DATE_FORMAT(e_refc.FechaAtencion,'%d-%m-%Y') , e_refc.NoHistoria, e_refc.Id_TipoIdentificacion, e_refc.NoDocumento, e_refc.NUsuario, e_refc.IdSexo, DATE_FORMAT(e_refc.FechaNac,'%d-%m-%Y')  AS FNac , e_refc.Edad, e_refc.NTipoEdad, e_refc.NMunicipio, e_refc.NBarrio, e_refc.Direccion, e_refc.Telefono, e_refc.Nparentesco, e_refc.NTipoEmpresa, e_refc.EPS, e_refc.TipoAfiliacion, e_refc.IdAtencion, DATE_FORMAT(e_refa.Fecha,'%d-%m-%Y') AS FechaCRef, e_refa.Imc AS PImc, e_refc.Imc AS SImc, ROUND((100-((e_refc.Imc*100)/e_refa.Imc)),2) AS Resultado, e_refc.Id_Persona      FROM e_refc INNER JOIN e_refa  ON (e_refc.Id_Usuario = e_refa.Id_Usuario) WHERE (ROUND((100-((e_refc.Imc*100)/e_refa.Imc)),2) " + this.JCBOperador.getSelectedItem().toString() + "" + this.JSPValor.getValue().toString() + ") ORDER BY DATE_FORMAT(e_refc.FechaAtencion,'%d-%m-%Y')  ASC, e_refc.NUsuario ASC ";
        ResultSet rs = this.xct.traerRs(this.xsql);
        double xstotal = 0.0d;
        try {
            if (rs.next()) {
                rs.last();
                this.JTFFTotalU.setValue(Integer.valueOf(rs.getRow()));
                rs.beforeFirst();
                int x = 0;
                while (rs.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(rs.getString(1), x, 0);
                    this.xmodelo.setValueAt(rs.getString(2), x, 1);
                    this.xmodelo.setValueAt(rs.getString(3), x, 2);
                    this.xmodelo.setValueAt(rs.getString(4), x, 3);
                    this.xmodelo.setValueAt(rs.getString(5), x, 4);
                    this.xmodelo.setValueAt(rs.getString(6), x, 5);
                    this.xmodelo.setValueAt(rs.getString(7), x, 6);
                    this.xmodelo.setValueAt(Long.valueOf(rs.getLong(8)), x, 7);
                    this.xmodelo.setValueAt(rs.getString(9), x, 8);
                    this.xmodelo.setValueAt(rs.getString(10), x, 9);
                    this.xmodelo.setValueAt(rs.getString(11), x, 10);
                    this.xmodelo.setValueAt(rs.getString(12), x, 11);
                    this.xmodelo.setValueAt(rs.getString(13), x, 12);
                    this.xmodelo.setValueAt(rs.getString(14), x, 13);
                    this.xmodelo.setValueAt(rs.getString(15), x, 14);
                    this.xmodelo.setValueAt(rs.getString(16), x, 15);
                    this.xmodelo.setValueAt(rs.getString(17), x, 16);
                    this.xmodelo.setValueAt(Long.valueOf(rs.getLong(18)), x, 17);
                    this.xmodelo.setValueAt(rs.getString(19), x, 18);
                    this.xmodelo.setValueAt(Double.valueOf(rs.getDouble(20)), x, 19);
                    this.xmodelo.setValueAt(Double.valueOf(rs.getDouble(21)), x, 20);
                    this.xmodelo.setValueAt(Double.valueOf(rs.getDouble(22)), x, 21);
                    this.xmodelo.setValueAt(Long.valueOf(rs.getLong(23)), x, 22);
                    xstotal += rs.getDouble(22);
                    x++;
                }
            }
            rs.close();
            this.xct.cerrarConexionBd();
            mCTotalAtenciones();
            this.JTFFTotalP.setValue(Double.valueOf(Double.valueOf(this.JTFFTotalU.getValue().toString()).doubleValue() / Double.valueOf(this.JTFFTotalA.getValue().toString()).doubleValue()));
            this.JTFFTotalPR.setValue(Double.valueOf(xstotal / Double.valueOf(this.JTFFTotalU.getValue().toString()).doubleValue()));
        } catch (SQLException ex) {
            this.xct.mostrarErrorSQL(ex);
        }
    }

    private void mCTotalAtenciones() {
        this.xsql = "SELECT count(Id_Usuario) FROM e_refc";
        this.JTFFTotalA.setValue(Long.valueOf(this.xct.traerDato(this.xsql)));
        this.xct.cerrarConexionBd();
    }

    private void mExportar() {
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            try {
                WritableWorkbook workbook = Workbook.createWorkbook(new File(this.JTFRuta.getText() + ".xls"));
                WritableSheet sheet = workbook.createSheet("CEstudio", 0);
                for (int x = 0; x < this.JTDetalle.getColumnCount(); x++) {
                    sheet.addCell(new Label(x, 0, this.JTDetalle.getColumnName(x)));
                }
                for (int x2 = 0; x2 < this.JTDetalle.getRowCount(); x2++) {
                    sheet.addCell(new Label(0, x2 + 1, this.xmodelo.getValueAt(x2, 0).toString()));
                    sheet.addCell(new Label(1, x2 + 1, this.xmodelo.getValueAt(x2, 1).toString()));
                    sheet.addCell(new Label(2, x2 + 1, this.xmodelo.getValueAt(x2, 2).toString()));
                    sheet.addCell(new Label(3, x2 + 1, this.xmodelo.getValueAt(x2, 3).toString()));
                    sheet.addCell(new Label(4, x2 + 1, this.xmodelo.getValueAt(x2, 4).toString()));
                    sheet.addCell(new Label(5, x2 + 1, this.xmodelo.getValueAt(x2, 5).toString()));
                    sheet.addCell(new Label(6, x2 + 1, this.xmodelo.getValueAt(x2, 6).toString()));
                    sheet.addCell(new Number(7, x2 + 1, Long.valueOf(this.xmodelo.getValueAt(x2, 7).toString()).longValue()));
                    sheet.addCell(new Label(8, x2 + 1, this.xmodelo.getValueAt(x2, 8).toString()));
                    sheet.addCell(new Label(9, x2 + 1, this.xmodelo.getValueAt(x2, 9).toString()));
                    sheet.addCell(new Label(11, x2 + 1, this.xmodelo.getValueAt(x2, 10).toString()));
                    sheet.addCell(new Label(11, x2 + 1, this.xmodelo.getValueAt(x2, 11).toString()));
                    sheet.addCell(new Label(12, x2 + 1, this.xmodelo.getValueAt(x2, 12).toString()));
                    sheet.addCell(new Label(13, x2 + 1, this.xmodelo.getValueAt(x2, 13).toString()));
                    sheet.addCell(new Label(14, x2 + 1, this.xmodelo.getValueAt(x2, 14).toString()));
                    sheet.addCell(new Label(15, x2 + 1, this.xmodelo.getValueAt(x2, 15).toString()));
                    sheet.addCell(new Label(16, x2 + 1, this.xmodelo.getValueAt(x2, 16).toString()));
                    sheet.addCell(new Number(17, x2 + 1, Long.valueOf(this.xmodelo.getValueAt(x2, 17).toString()).longValue()));
                    sheet.addCell(new Label(18, x2 + 1, this.xmodelo.getValueAt(x2, 18).toString()));
                    sheet.addCell(new Number(19, x2 + 1, Double.valueOf(this.xmodelo.getValueAt(x2, 19).toString()).doubleValue()));
                    sheet.addCell(new Number(20, x2 + 1, Double.valueOf(this.xmodelo.getValueAt(x2, 20).toString()).doubleValue()));
                    sheet.addCell(new Number(21, x2 + 1, Double.valueOf(this.xmodelo.getValueAt(x2, 21).toString()).doubleValue()));
                }
                workbook.write();
                workbook.close();
            } catch (IOException ex) {
                Logger.getLogger(JIFConsultarInfNutricion.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            } catch (WriteException e) {
                Logger.getLogger(JIFConsultarInfNutricion.class.getName()).log(Level.SEVERE, (String) null, e);
            }
        }
    }
}
