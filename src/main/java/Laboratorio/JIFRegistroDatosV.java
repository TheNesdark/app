package Laboratorio;

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
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyVetoException;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
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

/* JADX INFO: loaded from: GenomaP.jar:Laboratorio/JIFRegistroDatosV.class */
public class JIFRegistroDatosV extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private Object[] xdatos;
    private String[] xidprocedimiento;
    private String xsql;
    private JButton JBTGrafico1;
    private JComboBox JCBProcedimiento;
    private JDateChooser JDFechaF;
    private JDateChooser JDFechaI;
    private JPanel JPIDatos;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;
    private JTextField JTFRuta;
    private ConsultasMySQL xconsulta = new ConsultasMySQL();
    private Metodos xmt = new Metodos();
    private Boolean xlleno = false;

    public JIFRegistroDatosV() {
        initComponents();
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v28, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPIDatos = new JPanel();
        this.JDFechaI = new JDateChooser();
        this.JDFechaF = new JDateChooser();
        this.JCBProcedimiento = new JComboBox();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JBTGrafico1 = new JButton();
        this.JTFRuta = new JTextField();
        setClosable(true);
        setIconifiable(true);
        setTitle("REGISTRO DE INFORMACION ADICIONAL POR EXÁMEN");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setMaximumSize(null);
        setName("jifregistrodatosv");
        try {
            setSelected(true);
        } catch (PropertyVetoException e1) {
            e1.printStackTrace();
        }
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JDFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicial", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFechaI.setFont(new Font("Arial", 1, 12));
        this.JDFechaI.addPropertyChangeListener(new PropertyChangeListener() { // from class: Laboratorio.JIFRegistroDatosV.1
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFRegistroDatosV.this.JDFechaIPropertyChange(evt);
            }
        });
        this.JDFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Final", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFechaF.setFont(new Font("Arial", 1, 12));
        this.JDFechaF.addPropertyChangeListener(new PropertyChangeListener() { // from class: Laboratorio.JIFRegistroDatosV.2
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFRegistroDatosV.this.JDFechaFPropertyChange(evt);
            }
        });
        this.JCBProcedimiento.setFont(new Font("Arial", 1, 12));
        this.JCBProcedimiento.setBorder(BorderFactory.createTitledBorder((Border) null, "Procedimiento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addComponent(this.JDFechaI, -2, 120, -2).addGap(18, 18, 18).addComponent(this.JDFechaF, -2, 120, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBProcedimiento, -2, 642, -2).addContainerGap(15, 32767)));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosLayout.createSequentialGroup().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JCBProcedimiento, GroupLayout.Alignment.LEADING).addComponent(this.JDFechaI, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.JDFechaF, -2, 51, -2)).addContainerGap()));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalle.setSelectionMode(0);
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.JBTGrafico1.setFont(new Font("Arial", 1, 12));
        this.JBTGrafico1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTGrafico1.setText("Exportar");
        this.JBTGrafico1.addActionListener(new ActionListener() { // from class: Laboratorio.JIFRegistroDatosV.3
            public void actionPerformed(ActionEvent evt) {
                JIFRegistroDatosV.this.JBTGrafico1ActionPerformed(evt);
            }
        });
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: Laboratorio.JIFRegistroDatosV.4
            public void mouseClicked(MouseEvent evt) {
                JIFRegistroDatosV.this.JTFRutaMouseClicked(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JSPDetalle, GroupLayout.Alignment.LEADING, -1, 947, 32767).addComponent(this.JPIDatos, -1, -1, 32767).addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup().addComponent(this.JTFRuta, -2, 436, -2).addGap(143, 143, 143).addComponent(this.JBTGrafico1, -1, 368, 32767))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalle, -1, 369, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JBTGrafico1, -2, 50, -2).addComponent(this.JTFRuta, -2, 50, -2)).addContainerGap()));
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
    public void JBTGrafico1ActionPerformed(ActionEvent evt) {
        if (this.JTDetalle.getRowCount() != -1 && !this.JTFRuta.getText().isEmpty()) {
            mExportar();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaIPropertyChange(PropertyChangeEvent evt) {
        if (this.xlleno.booleanValue()) {
            mCargarCombo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaFPropertyChange(PropertyChangeEvent evt) {
        if (this.xlleno.booleanValue()) {
            mCargarCombo();
        }
    }

    public void mBuscar() {
        if (this.JCBProcedimiento.getSelectedIndex() != -1) {
            String sql = "SELECT l_recepcion.Id, persona.NoHistoria, persona.NUsuario, CONCAT(persona.Edad,' ', persona.NTipoEdad) AS Edad, persona.IdSexo , l_detallerecepcion.Peso , l_detallerecepcion.Talla, l_detallerecepcion.Volumen, l_detallerecepcion.Id_Procedim, IF(l_detallerecepcion.Volumen<>0,1,0) AS Lleno, persona.Id_Persona FROM l_detallerecepcion INNER JOIN l_recepcion  ON (l_detallerecepcion.Id_Recepcion = l_recepcion.Id) INNER JOIN g_procedimiento  ON (l_detallerecepcion.Id_Procedim = g_procedimiento.Id) INNER JOIN persona  ON (persona.Id_persona = l_recepcion.Id_Paciente) WHERE (g_procedimiento.RPrevios IS NOT NULL AND l_recepcion.Estado =0 AND DATE_FORMAT(l_recepcion.FechaRecep,'%Y/%m/%d') >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND DATE_FORMAT(l_recepcion.FechaRecep,'%Y/%m/%d') <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' AND l_detallerecepcion.Id_Procedim='" + this.xidprocedimiento[this.JCBProcedimiento.getSelectedIndex()] + "') ORDER BY persona.NUsuario ASC ";
            mCargarDatosTabla(sql);
        } else {
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un un procedimiento", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBProcedimiento.requestFocus();
        }
    }

    public void mGrabar() {
        if (this.JTDetalle.getRowCount() != -1) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de actualizar?", "VERIFICAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                for (int x = 0; x < this.JTDetalle.getRowCount(); x++) {
                    if (!Boolean.valueOf(this.xmodelo.getValueAt(x, 9).toString()).booleanValue()) {
                        this.xsql = "Update l_detallerecepcion set Peso='" + this.xmodelo.getValueAt(x, 5) + "', Talla='" + this.xmodelo.getValueAt(x, 6) + "', Volumen='" + this.xmodelo.getValueAt(x, 7) + "' where Id_Recepcion='" + this.xmodelo.getValueAt(x, 0) + "' and Id_Procedim='" + this.xmodelo.getValueAt(x, 8) + "'";
                        this.xconsulta.ejecutarSQL(this.xsql);
                        this.xconsulta.cerrarConexionBd();
                    }
                }
            }
        }
    }

    private void mExportar() {
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            try {
                WritableWorkbook workbook = Workbook.createWorkbook(new File(this.JTFRuta.getText() + ".xls"));
                WritableSheet sheet = workbook.createSheet("plantilla", 0);
                sheet.addCell(new Label(0, 0, "CONSOLIDADO DE EXAMENES"));
                sheet.addCell(new Label(0, 1, "Id"));
                sheet.addCell(new Label(1, 1, "Procedimiento"));
                sheet.addCell(new Label(2, 1, "Cantidad"));
                int z = 1;
                for (int x = 0; x < this.JTDetalle.getRowCount(); x++) {
                    sheet.addCell(new Number(0, z, Long.valueOf(this.xmodelo.getValueAt(x, 0).toString()).longValue()));
                    sheet.addCell(new Label(1, z, this.xmodelo.getValueAt(x, 1).toString()));
                    sheet.addCell(new Number(2, z, Long.valueOf(this.xmodelo.getValueAt(x, 2).toString()).longValue()));
                    z++;
                }
                if (this.JCBProcedimiento.getSelectedIndex() != -1) {
                    WritableSheet sheet1 = workbook.createSheet("Detalle", 1);
                    sheet1.addCell(new Label(0, 0, "RESULTADO DE EXAMENES"));
                    sheet1.addCell(new Label(0, 1, "NHC"));
                    sheet1.addCell(new Label(1, 1, "TD"));
                    sheet1.addCell(new Label(2, 1, "NDocumento"));
                    sheet1.addCell(new Label(3, 1, "NUsuario"));
                    sheet1.addCell(new Label(4, 1, "FechaNac"));
                    sheet1.addCell(new Label(5, 1, "Edad"));
                    sheet1.addCell(new Label(6, 1, "TipoEdad"));
                    sheet1.addCell(new Label(7, 1, "Sexo"));
                    sheet1.addCell(new Label(8, 1, "Departamento"));
                    sheet1.addCell(new Label(9, 1, "Municipio"));
                    sheet1.addCell(new Label(10, 1, "Dirección"));
                    sheet1.addCell(new Label(11, 1, "Teléfono"));
                    sheet1.addCell(new Label(12, 1, "Tipo Empresa"));
                    sheet1.addCell(new Label(13, 1, "Parentesco"));
                    sheet1.addCell(new Label(14, 1, "Eps"));
                    sheet1.addCell(new Label(15, 1, "Tipo Afiliación"));
                    sheet1.addCell(new Label(16, 1, "FechaResultado"));
                    sheet1.addCell(new Label(17, 1, "Exámen"));
                    sheet1.addCell(new Label(18, 1, "Protocolo"));
                    sheet1.addCell(new Label(19, 1, "V/Resultado"));
                    ConsultasMySQL xt2 = new ConsultasMySQL();
                    ResultSet rs = xt2.traerRs(this.xsql);
                    if (rs.next()) {
                        rs.beforeFirst();
                        int y = 2;
                        while (rs.next()) {
                            sheet1.addCell(new Label(0, y, rs.getString(1)));
                            sheet1.addCell(new Label(1, y, rs.getString(2)));
                            sheet1.addCell(new Label(2, y, rs.getString(3)));
                            sheet1.addCell(new Label(3, y, rs.getString(4)));
                            sheet1.addCell(new Label(4, y, rs.getString(5)));
                            sheet1.addCell(new Number(5, y, rs.getInt(6)));
                            sheet1.addCell(new Label(6, y, rs.getString(7)));
                            sheet1.addCell(new Label(7, y, rs.getString(8)));
                            sheet1.addCell(new Label(8, y, rs.getString(9)));
                            sheet1.addCell(new Label(9, y, rs.getString(10)));
                            sheet1.addCell(new Label(10, y, rs.getString(11)));
                            sheet1.addCell(new Label(11, y, rs.getString(12)));
                            sheet1.addCell(new Label(12, y, rs.getString(13)));
                            sheet1.addCell(new Label(13, y, rs.getString(14)));
                            sheet1.addCell(new Label(14, y, rs.getString(15)));
                            sheet1.addCell(new Label(15, y, rs.getString(16)));
                            sheet1.addCell(new Label(16, y, rs.getString(17)));
                            sheet1.addCell(new Label(17, y, rs.getString(18)));
                            sheet1.addCell(new Label(18, y, rs.getString(19)));
                            sheet1.addCell(new Label(19, y, rs.getString(20)));
                            y++;
                        }
                    }
                    rs.close();
                    xt2.cerrarConexionBd();
                }
                workbook.write();
                workbook.close();
            } catch (SQLException ex) {
                Logger.getLogger(JIFRegistroDatosV.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            } catch (WriteException e) {
                Logger.getLogger(JIFRegistroDatosV.class.getName()).log(Level.SEVERE, (String) null, e);
            } catch (IOException ex2) {
                Logger.getLogger(JIFRegistroDatosV.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex2);
            }
        }
    }

    public void mNuevo() {
        this.JDFechaI.setDate(this.xmt.getFechaActual());
        this.JDFechaF.setDate(this.xmt.getFechaActual());
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
        mCargarCombo();
        mCrearModeloDatos();
        this.JDFechaI.requestFocus();
    }

    private void mCargarCombo() {
        this.xlleno = false;
        this.JCBProcedimiento.removeAllItems();
        this.xsql = "SELECT l_detallerecepcion.Id_Procedim , g_procedimiento.Nbre FROM l_detallerecepcion INNER JOIN l_recepcion  ON (l_detallerecepcion.Id_Recepcion = l_recepcion.Id) INNER JOIN g_procedimiento  ON (l_detallerecepcion.Id_Procedim = g_procedimiento.Id) WHERE (g_procedimiento.RPrevios IS NOT NULL AND l_recepcion.Estado =0 AND DATE_FORMAT(l_recepcion.FechaRecep,'%Y/%m/%d') >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND DATE_FORMAT(l_recepcion.FechaRecep,'%Y/%m/%d') <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "') GROUP BY l_detallerecepcion.Id_Procedim ORDER BY g_procedimiento.Nbre ASC ";
        this.xidprocedimiento = this.xconsulta.llenarCombo(this.xsql, this.xidprocedimiento, this.JCBProcedimiento);
        this.JCBProcedimiento.setSelectedIndex(-1);
        this.xconsulta.cerrarConexionBd();
        this.xlleno = true;
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"N° Recepción", "N° HC", "Usuario", "Edad", "Sexo", "Peso", "Talla", "Volumen", "IdProcedimiento", "R", "IdPersona"}) { // from class: Laboratorio.JIFRegistroDatosV.5
            Class[] types = {Long.class, String.class, String.class, String.class, String.class, Double.class, Double.class, Double.class, Long.class, Boolean.class, Long.class};
            boolean[] canEdit = {false, false, false, false, false, true, true, true, false, false, false};

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
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(8).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(8).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(10).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(10).setMaxWidth(0);
    }

    public void mCargarDatosTabla(String xsql) {
        try {
            mCrearModeloDatos();
            ResultSet xrs = this.xconsulta.traerRs(xsql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(1)), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelo.setValueAt(xrs.getString(4), n, 3);
                    this.xmodelo.setValueAt(xrs.getString(5), n, 4);
                    if (xrs.getBoolean(10)) {
                        this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(6)), n, 5);
                        this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(7)), n, 6);
                    } else {
                        mBuscarDatosAdicionales(Long.valueOf(xrs.getLong(11)), n);
                    }
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(8)), n, 7);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(9)), n, 8);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(10)), n, 9);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(11)), n, 10);
                    n++;
                }
            }
            xrs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFRegistroDatosV.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mBuscarDatosAdicionales(Long xidpersona, int xnfila) {
        try {
            this.xsql = "SELECT h_examenfisico.Peso, h_examenfisico.Talla FROM h_examenfisico INNER JOIN h_atencion  ON (h_examenfisico.Id_Atencion = h_atencion.Id) INNER JOIN ingreso  ON (h_atencion.Id_Ingreso = ingreso.Id) WHERE (h_examenfisico.Peso <>0 AND h_examenfisico.Talla <>0 AND ingreso.Id_Usuario ='" + xidpersona + "') GROUP BY ingreso.Id_Usuario ";
            ConsultasMySQL xct = new ConsultasMySQL();
            ResultSet xrs = xct.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.first();
                this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(1)), xnfila, 5);
                this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(2)), xnfila, 6);
            }
            xrs.close();
            xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFRegistroDatosV.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }
}
