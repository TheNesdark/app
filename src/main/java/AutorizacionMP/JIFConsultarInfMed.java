package AutorizacionMP;

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
import java.beans.PropertyVetoException;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

/* JADX INFO: loaded from: GenomaP.jar:AutorizacionMP/JIFConsultarInfMed.class */
public class JIFConsultarInfMed extends JInternalFrame {
    private ConsultasMySQL xconsulta = new ConsultasMySQL();
    private Metodos xmt = new Metodos();
    private DefaultTableModel xmodelo;
    private Object[] xdatos;
    private String xname;
    private ButtonGroup JBGSeleccion;
    private ButtonGroup JBGSeleccion1;
    private JButton JBTExportar;
    private JCheckBox JCHFiltro;
    private JDateChooser JDFechaF;
    private JDateChooser JDFechaI;
    private JPanel JPIDatos;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;
    private JTextField JTFRuta;

    public JIFConsultarInfMed(String xname) {
        initComponents();
        setName(xname);
        this.xname = xname;
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v41, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGSeleccion = new ButtonGroup();
        this.JBGSeleccion1 = new ButtonGroup();
        this.JPIDatos = new JPanel();
        this.JDFechaI = new JDateChooser();
        this.JDFechaF = new JDateChooser();
        this.JCHFiltro = new JCheckBox();
        this.JTFRuta = new JTextField();
        this.JBTExportar = new JButton();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("INFORMES");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setMaximumSize(null);
        setName("jifconsultarinformesi");
        try {
            setSelected(true);
        } catch (PropertyVetoException e1) {
            e1.printStackTrace();
        }
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JDFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicial", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFechaI.setFont(new Font("Arial", 1, 12));
        this.JDFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Final", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFechaF.setFont(new Font("Arial", 1, 12));
        this.JCHFiltro.setFont(new Font("Arial", 1, 12));
        this.JCHFiltro.setForeground(Color.blue);
        this.JCHFiltro.setSelected(true);
        this.JCHFiltro.setText("Aplicar filtro por usuario");
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: AutorizacionMP.JIFConsultarInfMed.1
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarInfMed.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setForeground(Color.red);
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: AutorizacionMP.JIFConsultarInfMed.2
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarInfMed.this.JBTExportarActionPerformed(evt);
            }
        });
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JDFechaI, -2, 120, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JDFechaF, -2, 120, -2).addGap(34, 34, 34).addComponent(this.JCHFiltro).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 28, 32767).addComponent(this.JTFRuta, -2, 341, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTExportar, -2, 128, -2).addGap(1, 1, 1)));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCHFiltro).addComponent(this.JTFRuta, -2, 50, -2)).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JDFechaF, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.JDFechaI, GroupLayout.Alignment.LEADING, -1, -1, 32767))).addComponent(this.JBTExportar, -2, 50, -2)).addContainerGap(15, 32767)));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JSPDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalle.setSelectionMode(0);
        this.JSPDetalle.setViewportView(this.JTDetalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JPIDatos, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.JSPDetalle, GroupLayout.Alignment.LEADING, -1, 963, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addGap(20, 20, 20).addComponent(this.JSPDetalle, -2, 320, -2).addContainerGap(31, 32767)));
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
        if (!this.JTFRuta.getText().isEmpty()) {
            if (this.JTDetalle.getRowCount() > -1) {
                mExportar();
                return;
            } else {
                JOptionPane.showInternalMessageDialog(this, "No existe información para exportar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                return;
            }
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un ruta valida", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JTFRuta.requestFocus();
    }

    public void mBuscar() {
        mCargarDatosTabla();
    }

    private void mExportar() {
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMACIÓN", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            try {
                WritableWorkbook workbook = Workbook.createWorkbook(new File(this.JTFRuta.getText() + ".xls"));
                WritableSheet sheet = workbook.createSheet("plantilla", 0);
                sheet.addCell(new Label(0, 0, "Fecha"));
                sheet.addCell(new Label(1, 0, "N° Orden"));
                sheet.addCell(new Label(2, 0, "Medicamento"));
                sheet.addCell(new Label(3, 0, "Posología"));
                sheet.addCell(new Label(4, 0, "Duración"));
                sheet.addCell(new Label(5, 0, "Cantidad"));
                sheet.addCell(new Label(6, 0, "V/Unitario"));
                sheet.addCell(new Label(7, 0, "V/Total"));
                sheet.addCell(new Label(8, 0, "Observación"));
                sheet.addCell(new Label(9, 0, "NHc"));
                sheet.addCell(new Label(10, 0, "Usuario"));
                for (int x = 0; x < this.JTDetalle.getRowCount(); x++) {
                    sheet.addCell(new Label(0, x + 1, this.xmodelo.getValueAt(x, 0).toString()));
                    sheet.addCell(new Number(1, x + 1, Long.valueOf(this.xmodelo.getValueAt(x, 1).toString()).longValue()));
                    sheet.addCell(new Label(2, x + 1, this.xmodelo.getValueAt(x, 2).toString()));
                    sheet.addCell(new Label(3, x + 1, this.xmodelo.getValueAt(x, 3).toString()));
                    sheet.addCell(new Number(4, x + 1, Long.valueOf(this.xmodelo.getValueAt(x, 4).toString()).longValue()));
                    sheet.addCell(new Number(5, x + 1, Long.valueOf(this.xmodelo.getValueAt(x, 5).toString()).longValue()));
                    sheet.addCell(new Number(6, x + 1, Double.valueOf(this.xmodelo.getValueAt(x, 6).toString()).doubleValue()));
                    sheet.addCell(new Number(7, x + 1, Double.valueOf(this.xmodelo.getValueAt(x, 7).toString()).doubleValue()));
                    sheet.addCell(new Label(8, x + 1, this.xmodelo.getValueAt(x, 8).toString()));
                    sheet.addCell(new Label(9, x + 1, this.xmodelo.getValueAt(x, 9).toString()));
                    sheet.addCell(new Label(10, x + 1, this.xmodelo.getValueAt(x, 10).toString()));
                }
                workbook.write();
                workbook.close();
            } catch (IOException ex) {
                Logger.getLogger(JIFConsultarInfMed.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            } catch (WriteException e) {
                Logger.getLogger(JIFConsultarInfMed.class.getName()).log(Level.SEVERE, (String) null, e);
            }
        }
    }

    public void mNuevo() {
        Principal.mLimpiarDatosP();
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
        this.JDFechaI.setDate(this.xmt.getFechaActual());
        this.JDFechaF.setDate(this.xmt.getFechaActual());
        this.JCHFiltro.setSelected(true);
        mCrearModeloDatos();
        this.JDFechaI.requestFocus();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Fecha", "N° Orden", "Medicamento", "Posología", "Duración", "Cantidad", "V/Unitario", "V/Total", "Observación", "NHC", "Usuario"}) { // from class: AutorizacionMP.JIFConsultarInfMed.3
            Class[] types = {String.class, Long.class, String.class, String.class, Long.class, Long.class, Double.class, Double.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(30);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(30);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(30);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(30);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(9).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(9).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(10).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(10).setMaxWidth(0);
    }

    private void mCargarDatosTabla() {
        String xsql;
        try {
            if (this.JCHFiltro.isSelected()) {
                xsql = "SELECT DATE_FORMAT(Fecha,'%d-%m-%Y') AS FechaD, Id_HOrdenes, SuministroM, PosologiaManual, Duracion, Cantidad, ValorUnitario, (ValorUnitario*Cantidad) as VTotal, ObservacionA, persona.NoHistoria, persona.NUsuario  FROM h_itemordenessum_negados inner join persona on  h_itemordenessum_negados.Id_Usuario=persona.Id_persona WHERE (Id_Usuario ='" + Principal.claseautorizacionmp.autorizacion.frmPersona.getIdPersona() + "')";
            } else {
                xsql = "SELECT DATE_FORMAT(Fecha,'%d-%m-%Y') AS FechaD, Id_HOrdenes, SuministroM, PosologiaManual, Duracion, Cantidad, ValorUnitario, (ValorUnitario*Cantidad) AS VTotal, ObservacionA,  persona.NoHistoria, persona.NUsuario  FROM h_itemordenessum_negados inner join persona on  h_itemordenessum_negados.Id_Usuario=persona.Id_persona WHERE (DATE(Fecha) >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND DATE(Fecha) <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "') ";
            }
            mCrearModeloDatos();
            ResultSet xrs = this.xconsulta.traerRs(xsql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(xrs.getString(1), n, 0);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(2)), n, 1);
                    this.xmodelo.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelo.setValueAt(xrs.getString(4), n, 3);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(5)), n, 4);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(6)), n, 5);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(7)), n, 6);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(8)), n, 7);
                    this.xmodelo.setValueAt(xrs.getString(9), n, 8);
                    this.xmodelo.setValueAt(xrs.getString(10), n, 9);
                    this.xmodelo.setValueAt(xrs.getString(11), n, 10);
                    n++;
                }
            }
            xrs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFConsultarInfMed.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }
}
