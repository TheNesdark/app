package AutorizacionMP;

import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
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
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

/* JADX INFO: loaded from: GenomaP.jar:AutorizacionMP/JIFSubirRelacionC.class */
public class JIFSubirRelacionC extends JInternalFrame {
    private ConsultasMySQL xconsultas = new ConsultasMySQL();
    private Metodos xmt = new Metodos();
    private DefaultTableModel xmodelo;
    private DefaultTableModel xmodelo1;
    private Object[] xdato;
    private String sql;
    private String[] xidtipoempresa;
    private File xfile;
    private ButtonGroup JBGSoporte;
    private JButton JBTAplicar;
    private JDateChooser JDCFecha;
    private JPanel JPIDatos;
    private JScrollPane JSPHC;
    private JScrollPane JSPHC1;
    private JSpinner JSPNRelacion;
    private JTextField JTFRuta;
    private JTable JTHistorico;
    private JTable JTHistorico1;

    public JIFSubirRelacionC() {
        initComponents();
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v31, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v38, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGSoporte = new ButtonGroup();
        this.JPIDatos = new JPanel();
        this.JDCFecha = new JDateChooser();
        this.JTFRuta = new JTextField();
        this.JSPNRelacion = new JSpinner();
        this.JSPHC = new JScrollPane();
        this.JTHistorico = new JTable();
        this.JSPHC1 = new JScrollPane();
        this.JTHistorico1 = new JTable();
        this.JBTAplicar = new JButton();
        setClosable(true);
        setIconifiable(true);
        setTitle("SUBIR VALORES DESCUENTOS");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifsubirplantillad");
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JDCFecha.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFecha.setDateFormatString("dd/MM/yyyy");
        this.JDCFecha.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ruta", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: AutorizacionMP.JIFSubirRelacionC.1
            public void mouseClicked(MouseEvent evt) {
                JIFSubirRelacionC.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JSPNRelacion.setFont(new Font("Arial", 1, 12));
        this.JSPNRelacion.setModel(new SpinnerNumberModel(0, 0, (Comparable) null, 1));
        this.JSPNRelacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Relación N°", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPNRelacion.addChangeListener(new ChangeListener() { // from class: AutorizacionMP.JIFSubirRelacionC.2
            public void stateChanged(ChangeEvent evt) {
                JIFSubirRelacionC.this.JSPNRelacionStateChanged(evt);
            }
        });
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addComponent(this.JDCFecha, -2, 124, -2).addGap(18, 18, 18).addComponent(this.JSPNRelacion, -2, 103, -2).addGap(18, 18, 18).addComponent(this.JTFRuta, -1, 584, 32767).addContainerGap()));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFRuta, -2, -1, -2).addComponent(this.JSPNRelacion, -2, 46, -2)).addComponent(this.JDCFecha, -2, -1, -2)).addGap(19, 19, 19)));
        this.JSPHC.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE PLANTILLA", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JSPHC.setFont(new Font("Arial", 1, 12));
        this.JTHistorico.setFont(new Font("Arial", 1, 12));
        this.JTHistorico.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTHistorico.setRowHeight(25);
        this.JTHistorico.setSelectionBackground(new Color(255, 255, 255));
        this.JTHistorico.setSelectionForeground(new Color(255, 0, 0));
        this.JTHistorico.setSelectionMode(0);
        this.JSPHC.setViewportView(this.JTHistorico);
        this.JSPHC1.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE ARCHIVO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JSPHC1.setFont(new Font("Arial", 1, 12));
        this.JTHistorico1.setFont(new Font("Arial", 1, 12));
        this.JTHistorico1.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTHistorico1.setRowHeight(25);
        this.JTHistorico1.setSelectionBackground(new Color(255, 255, 255));
        this.JTHistorico1.setSelectionForeground(new Color(255, 0, 0));
        this.JTHistorico1.setSelectionMode(0);
        this.JSPHC1.setViewportView(this.JTHistorico1);
        this.JBTAplicar.setFont(new Font("Arial", 1, 12));
        this.JBTAplicar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTAplicar.setText("Aplicar");
        this.JBTAplicar.addActionListener(new ActionListener() { // from class: AutorizacionMP.JIFSubirRelacionC.3
            public void actionPerformed(ActionEvent evt) {
                JIFSubirRelacionC.this.JBTAplicarActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPHC1, -1, 883, 32767).addComponent(this.JSPHC, -1, 883, 32767).addComponent(this.JPIDatos, -1, -1, 32767).addComponent(this.JBTAplicar, -1, 883, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addGap(18, 18, 18).addComponent(this.JSPHC, -2, 234, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPHC1, -2, 227, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBTAplicar, -1, 90, 32767).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JFileChooser xfilec = new JFileChooser(this.JTFRuta.getText());
            int xv = xfilec.showOpenDialog(this);
            if (xv == 0) {
                this.xfile = xfilec.getSelectedFile();
                this.JTFRuta.setText(this.xfile.getAbsolutePath());
                this.JTFRuta.setText(this.xmt.mTraerUrlBD(this.xfile.getAbsolutePath()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTAplicarActionPerformed(ActionEvent evt) {
        if (this.JTHistorico.getRowCount() != -1 && this.JTHistorico1.getRowCount() != -1) {
            for (int x = 0; x < this.JTHistorico1.getRowCount(); x++) {
                Double xvalord = Double.valueOf(this.xmodelo1.getValueAt(x, 3).toString());
                for (int y = 0; y < this.JTHistorico.getRowCount(); y++) {
                    if (this.xmodelo1.getValueAt(x, 1).toString().equals(this.xmodelo.getValueAt(y, 2).toString())) {
                        if (Double.valueOf(this.xmodelo.getValueAt(y, 4).toString()).doubleValue() - Double.valueOf(this.xmodelo.getValueAt(y, 5).toString()).doubleValue() != 0.0d) {
                            if (xvalord.doubleValue() <= Double.valueOf(this.xmodelo.getValueAt(y, 4).toString()).doubleValue()) {
                                this.xmodelo.setValueAt(xvalord, y, 5);
                            } else {
                                this.xmodelo.setValueAt(Double.valueOf(this.xmodelo.getValueAt(y, 4).toString()), y, 5);
                            }
                            xvalord = Double.valueOf(xvalord.doubleValue() - Double.valueOf(this.xmodelo.getValueAt(y, 5).toString()).doubleValue());
                        }
                        this.xmodelo1.setValueAt(true, x, 4);
                    } else {
                        this.xmodelo1.setValueAt(false, x, 4);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JSPNRelacionStateChanged(ChangeEvent evt) {
        mCargarTabla();
    }

    public void mGrabar() {
        int xv = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (xv == 0) {
            this.sql = "update d_relacion  set EsCargadaA=1 where Id='" + this.JSPNRelacion.getValue() + "'";
            this.xconsultas.ejecutarSQL(this.sql);
            this.xconsultas.cerrarConexionBd();
            for (int x = 0; x < this.JTHistorico.getRowCount(); x++) {
                if (Double.valueOf(this.xmodelo.getValueAt(x, 5).toString()).doubleValue() != 0.0d) {
                    this.sql = "update d_detalle_relacion  set VDescontado=VDescontado+'" + this.xmodelo.getValueAt(x, 5).toString() + "' where Id_Relacion='" + this.JSPNRelacion.getValue() + "' and  Id_Descuento='" + this.xmodelo.getValueAt(x, 0).toString() + "'";
                    this.xconsultas.ejecutarSQL(this.sql);
                    this.xconsultas.cerrarConexionBd();
                    ConsultasMySQL xct = new ConsultasMySQL();
                    try {
                        CallableStatement cs = xct.establecerConexionBd().prepareCall("{CALL Actualizar_Descuento(?,?)}");
                        cs.setLong("xid", Long.valueOf(this.xmodelo.getValueAt(x, 0).toString()).longValue());
                        cs.setDouble("xvalor", Double.valueOf(this.xmodelo.getValueAt(x, 5).toString()).doubleValue());
                        cs.execute();
                        cs.close();
                        xct.cerrarConexionBd();
                    } catch (SQLException ex) {
                        Logger.getLogger(JIFSubirRelacionC.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                    }
                }
            }
            for (int x2 = 0; x2 < this.JTHistorico1.getRowCount(); x2++) {
                this.sql = "INSERT INTO d_descuento_relacion_d (`Id_Relacion`, `NCedula`, `Valor`)  VALUES('" + this.JSPNRelacion.getValue() + "','" + this.xmodelo1.getValueAt(x2, 1).toString() + "','" + this.xmodelo1.getValueAt(x2, 3).toString() + "')";
                this.xconsultas.ejecutarSQL(this.sql);
                this.xconsultas.cerrarConexionBd();
            }
        }
    }

    public void mNuevo() {
        this.JDCFecha.setDate(this.xmt.getFechaActual());
        mCrearTabla();
        mCrearTabla1();
    }

    public void mBuscar() {
        if (!this.JTFRuta.getText().isEmpty()) {
            mCagarDArchivo();
        } else {
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar la plantilla a cargar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTFRuta.requestFocus();
        }
    }

    public void mImprimir() {
    }

    private void mCrearTabla() {
        this.xmodelo = new DefaultTableModel((Object[][]) null, new String[]{"Id", "Código 1Sap", "Documento", "Usuario", "V/Descuento", "V/Aplicado", "C"}) { // from class: AutorizacionMP.JIFSubirRelacionC.4
            Class[] types = {Long.class, String.class, String.class, String.class, Double.class, Double.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTHistorico.setModel(this.xmodelo);
        this.JTHistorico.getColumnModel().getColumn(0).setPreferredWidth(20);
        this.JTHistorico.getColumnModel().getColumn(1).setPreferredWidth(30);
        this.JTHistorico.getColumnModel().getColumn(2).setPreferredWidth(30);
        this.JTHistorico.getColumnModel().getColumn(3).setPreferredWidth(250);
        this.JTHistorico.getColumnModel().getColumn(4).setPreferredWidth(50);
        this.JTHistorico.getColumnModel().getColumn(5).setPreferredWidth(50);
        this.JTHistorico.getColumnModel().getColumn(6).setPreferredWidth(0);
        this.JTHistorico.getColumnModel().getColumn(6).setMinWidth(0);
        this.JTHistorico.getColumnModel().getColumn(6).setMaxWidth(0);
    }

    private void mCrearTabla1() {
        this.xmodelo1 = new DefaultTableModel((Object[][]) null, new String[]{"Código 1Sap", "N° HC", "Usuario", "V/Aplicado", "Encontró?"}) { // from class: AutorizacionMP.JIFSubirRelacionC.5
            Class[] types = {Long.class, String.class, String.class, Double.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTHistorico1.setModel(this.xmodelo1);
        this.JTHistorico1.getColumnModel().getColumn(0).setPreferredWidth(20);
        this.JTHistorico1.getColumnModel().getColumn(1).setPreferredWidth(30);
        this.JTHistorico1.getColumnModel().getColumn(2).setPreferredWidth(250);
        this.JTHistorico1.getColumnModel().getColumn(3).setPreferredWidth(50);
        this.JTHistorico1.getColumnModel().getColumn(4).setPreferredWidth(20);
    }

    private void mCargarTabla() {
        mCrearTabla();
        this.sql = "SELECT d_descuento.Id, persona.Codigo1Sap, persona.NoDocumento, persona.NUsuario, round(d_detalle_relacion.VADescontar), round(d_detalle_relacion.VDescontado), ROUND(d_detalle_relacion.VDescontado), IF(ROUND(d_detalle_relacion.VADescontar)-ROUND(d_detalle_relacion.VDescontado)=0,TRUE, FALSE) AS VR FROM d_detalle_relacion INNER JOIN `d_relacion`  ON (d_detalle_relacion.`Id_Relacion` = d_relacion.Id) INNER JOIN d_descuento  ON (d_detalle_relacion.Id_Descuento = d_descuento.Id) INNER JOIN persona  ON (persona.Id_persona = d_descuento.Id_PersonaDescuento) WHERE ( d_detalle_relacion.Id_Relacion ='" + this.JSPNRelacion.getValue() + "' AND d_relacion.`Estado`=0 )  ORDER BY persona.NUsuario ASC, d_descuento.Id ASC ";
        ResultSet rs = this.xconsultas.traerRs(this.sql);
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
                    this.xmodelo.setValueAt(Double.valueOf(rs.getDouble(5)), x, 4);
                    this.xmodelo.setValueAt(Double.valueOf(rs.getDouble(6)), x, 5);
                    this.xmodelo.setValueAt(Boolean.valueOf(rs.getBoolean(7)), x, 6);
                    this.JTHistorico.setDefaultRenderer(Object.class, new MiRender());
                    x++;
                }
            } else {
                JOptionPane.showInternalMessageDialog(this, "Plantilla no existe o ya aplicada", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            }
            rs.close();
            this.xconsultas.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFSubirRelacionC.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX INFO: loaded from: GenomaP.jar:AutorizacionMP/JIFSubirRelacionC$MiRender.class */
    public static class MiRender extends DefaultTableCellRenderer {
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            boolean xvalor = Boolean.valueOf(table.getValueAt(row, 6).toString()).booleanValue();
            if (xvalor) {
                cell.setBackground(new Color(177, 251, 177));
            } else {
                cell.setBackground(Color.WHITE);
            }
            return cell;
        }
    }

    private void mCagarDArchivo() {
        try {
            mCrearTabla1();
            Workbook xac = Workbook.getWorkbook(new File(this.JTFRuta.getText()));
            Sheet sheet = xac.getSheet(0);
            int y = 0;
            for (int x = 0; x < xac.getSheet(0).getRows(); x++) {
                this.xmodelo1.addRow(this.xdato);
                this.xmodelo1.setValueAt(Long.valueOf(sheet.getCell(0, y).getContents()), x, 0);
                this.xmodelo1.setValueAt(sheet.getCell(1, y).getContents(), x, 1);
                this.xmodelo1.setValueAt(sheet.getCell(2, y).getContents(), x, 2);
                this.xmodelo1.setValueAt(Double.valueOf(sheet.getCell(3, y).getContents()), x, 3);
                this.xmodelo1.setValueAt(false, x, 4);
                y++;
            }
            xac.close();
        } catch (BiffException e) {
            Logger.getLogger(JIFSubirRelacionC.class.getName()).log(Level.SEVERE, (String) null, e);
        } catch (IOException ex) {
            Logger.getLogger(JIFSubirRelacionC.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private boolean mVerificarDatosTablaTrue() {
        return false;
    }

    private void mExportarPlantilla() {
        try {
            WritableWorkbook workbook = Workbook.createWorkbook(new File("c:\\plantilla.xls"));
            WritableSheet sheet = workbook.createSheet("plantilla", 0);
            sheet.addCell(new Label(0, 0, "Persona N°"));
            sheet.addCell(new Label(1, 0, "Cédula"));
            sheet.addCell(new Label(2, 0, "Usuario"));
            sheet.addCell(new Label(3, 0, "Valor"));
            int x = 1;
            if (this.JTHistorico.getRowCount() > 0) {
                for (int i = 0; i < this.JTHistorico.getRowCount(); i++) {
                    sheet.addCell(new Number(0, x, Long.valueOf(this.xmodelo.getValueAt(i, 2).toString()).longValue()));
                    sheet.addCell(new Number(1, x, Long.valueOf(this.xmodelo.getValueAt(i, 1).toString()).longValue()));
                    sheet.addCell(new Label(2, x, this.xmodelo.getValueAt(i, 3).toString()));
                    sheet.addCell(new Number(3, x, Double.valueOf(this.xmodelo.getValueAt(i, 4).toString()).doubleValue()));
                    x++;
                }
            }
            workbook.write();
            workbook.close();
        } catch (IOException ex) {
            Logger.getLogger(JIFGenerarRelacionCobro.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        } catch (WriteException e) {
            Logger.getLogger(JIFGenerarRelacionCobro.class.getName()).log(Level.SEVERE, (String) null, e);
        }
    }
}
