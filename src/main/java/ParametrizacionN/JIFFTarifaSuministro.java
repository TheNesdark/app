package ParametrizacionN;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyVetoException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
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
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

/* JADX INFO: loaded from: GenomaP.jar:ParametrizacionN/JIFFTarifaSuministro.class */
public class JIFFTarifaSuministro extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private Object[] xdatos;
    private String[] xidplan;
    private String[] xidmanual;
    private JButton JBTExportar;
    private JComboBox JCBManual;
    private JComboBox JCBPlan;
    private JPanel JPIDatos;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;
    private JTextField JTFCodigo;
    private JFormattedTextField JTFFValor;
    private JTextField JTFRuta;
    private ConsultasMySQL xconsulta = new ConsultasMySQL();
    private Metodos xmt = new Metodos();
    private int xestado = 1;
    private boolean xestadog = false;

    public JIFFTarifaSuministro() {
        initComponents();
        this.xidmanual = this.xconsulta.llenarCombo("SELECT Id, Nbre FROM  f_manual WHERE (Estado =0) ORDER BY Nbre ASC", this.xidmanual, this.JCBManual);
        this.JCBManual.setSelectedIndex(-1);
        this.xidplan = this.xconsulta.llenarCombo("SELECT Id, Nbre, Estado FROM  f_tipoplan WHERE (Estado =0) ORDER BY Nbre ASC", this.xidplan, this.JCBPlan);
        this.JCBPlan.setSelectedIndex(-1);
        this.xconsulta.cerrarConexionBd();
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
        mCargarDatosTabla();
    }

    /* JADX WARN: Type inference failed for: r3v31, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPIDatos = new JPanel();
        this.JCBManual = new JComboBox();
        this.JTFCodigo = new JTextField();
        this.JCBPlan = new JComboBox();
        this.JTFFValor = new JFormattedTextField();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JBTExportar = new JButton();
        this.JTFRuta = new JTextField();
        setClosable(true);
        setIconifiable(true);
        setTitle("TARIFA DE SUMINISTRO");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jiftarifasuministro");
        try {
            setSelected(true);
        } catch (PropertyVetoException e1) {
            e1.printStackTrace();
        }
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JCBManual.setFont(new Font("Arial", 1, 12));
        this.JCBManual.setBorder(BorderFactory.createTitledBorder((Border) null, "Manual", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFCodigo.setFont(new Font("Arial", 1, 12));
        this.JTFCodigo.setToolTipText("");
        this.JTFCodigo.setBorder(BorderFactory.createTitledBorder((Border) null, "Código", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBPlan.setFont(new Font("Arial", 1, 12));
        this.JCBPlan.setBorder(BorderFactory.createTitledBorder((Border) null, "Plan", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFValor.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFValor.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFValor.setHorizontalAlignment(4);
        this.JTFFValor.setFont(new Font("Arial", 1, 12));
        this.JTFFValor.setValue(new Integer(0));
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(GroupLayout.Alignment.LEADING, JPIDatosLayout.createSequentialGroup().addComponent(this.JTFFValor, -2, 165, -2).addGap(18, 18, 18).addComponent(this.JCBPlan, 0, 378, 32767)).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JCBManual, 0, 373, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFCodigo, -2, 178, -2))).addContainerGap()));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JTFCodigo).addComponent(this.JCBManual, -2, -1, -2)).addGap(18, 18, 18).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JCBPlan).addComponent(this.JTFFValor)).addContainerGap()));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalle.setSelectionMode(0);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFFTarifaSuministro.1
            public void mouseClicked(MouseEvent evt) {
                JIFFTarifaSuministro.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JTDetalle.addKeyListener(new KeyAdapter() { // from class: ParametrizacionN.JIFFTarifaSuministro.2
            public void keyPressed(KeyEvent evt) {
                JIFFTarifaSuministro.this.JTDetalleKeyPressed(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setForeground(Color.blue);
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFTarifaSuministro.3
            public void actionPerformed(ActionEvent evt) {
                JIFFTarifaSuministro.this.JBTExportarActionPerformed(evt);
            }
        });
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFFTarifaSuministro.4
            public void mouseClicked(MouseEvent evt) {
                JIFFTarifaSuministro.this.JTFRutaMouseClicked(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JBTExportar, -1, 597, 32767).addComponent(this.JPIDatos, -1, -1, 32767).addComponent(this.JSPDetalle, -1, 599, 32767).addComponent(this.JTFRuta)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalle, -1, 302, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFRuta, -2, 50, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTExportar, -2, 57, -2).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            this.JCBManual.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
            this.JTFCodigo.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString());
            this.JTFFValor.setValue(Double.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString()));
            this.JCBPlan.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString());
            this.xestadog = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTExportarActionPerformed(ActionEvent evt) {
        if (this.JCBManual.getSelectedIndex() != -1) {
            try {
                String sql = "SELECT i_suministro.Id, i_suministro.Nbre AS Producto, i_presentacionfarmaceutica.Nbre AS PFarmaceutica, i_laboratorio.Nbre AS Laboratorio, i_tipoproducto.Nbre AS TipoProducto, f_tarifasuministro.Codigo AS CodigoCUM, f_tarifasuministro.Valor FROM f_tarifasuministro INNER JOIN i_suministro  ON (f_tarifasuministro.Id_suministro = i_suministro.Id) INNER JOIN i_presentacionfarmaceutica  ON (i_suministro.IdPresentacionFarmaceutica = i_presentacionfarmaceutica.Id) INNER JOIN i_laboratorio  ON (i_suministro.IdLaboratorio = i_laboratorio.Id) INNER JOIN i_tipoproducto  ON (i_suministro.IdTipoProducto = i_tipoproducto.Id) WHERE (f_tarifasuministro.Id_manual ='" + this.xidmanual[this.JCBManual.getSelectedIndex()] + "') ORDER BY i_tipoproducto.Nbre ASC, i_suministro.Nbre ASC";
                this.xmt.mExportar_Datos_Formato_Consulta(sql, this.JTFRuta.getText(), getTitle());
            } catch (FileNotFoundException ex) {
                Logger.getLogger(JIFFTarifaSuministro.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
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
    public void JTDetalleKeyPressed(KeyEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1 && evt.getKeyCode() == 127) {
            int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de eliminar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                String xsql = "delete from f_tarifasuministro where  `f_tarifasuministro`.`Id_Suministro`='" + this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 4) + "'  and  `f_tarifasuministro`.`Id_manual`='" + this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 5) + "'";
                this.xconsulta.ejecutarSQL(xsql);
                this.xconsulta.cerrarConexionBd();
                mCargarDatosTabla();
            }
        }
    }

    public void mNuevo() {
        this.JCBManual.setSelectedIndex(-1);
        this.JTFCodigo.setText("");
        this.JTFFValor.setValue(new Integer(0));
        this.JCBPlan.setSelectedIndex(-1);
        this.JCBManual.requestFocus();
        this.xestadog = false;
    }

    public void mGrabar() {
        String sql;
        if (this.JCBManual.getSelectedIndex() != -1) {
            if (this.JCBPlan.getSelectedIndex() != -1) {
                int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (n == 0) {
                    if (!this.xestadog) {
                        sql = " Insert ignore into  f_tarifasuministro(Id_suministro, Id_manual, Codigo, Valor, Id_TipoPlan, Fecha, UsuarioS)  values ('" + Principal.txtNo.getText() + "','" + this.xidmanual[this.JCBManual.getSelectedIndex()] + "','" + this.JTFCodigo.getText() + "','" + this.JTFFValor.getValue() + "','" + this.xidplan[this.JCBPlan.getSelectedIndex()] + "','" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                    } else {
                        sql = " update f_tarifasuministro set Codigo='" + this.JTFCodigo.getText() + "',Valor='" + this.JTFFValor.getValue() + "', Id_TipoPlan='" + this.xidplan[this.JCBPlan.getSelectedIndex()] + "', Fecha='" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id_suministro='" + Principal.txtNo.getText() + "' and Id_Manual='" + this.xidmanual[this.JCBManual.getSelectedIndex()] + "'";
                    }
                    this.xconsulta.ejecutarSQL(sql);
                    this.xconsulta.cerrarConexionBd();
                    mCargarDatosTabla();
                    return;
                }
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un plan", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBPlan.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un manual", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JCBManual.requestFocus();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Manual", "Código", "Valor", "Plan", "Id_Suministro", "Id_Manual"}) { // from class: ParametrizacionN.JIFFTarifaSuministro.5
            Class[] types = {String.class, String.class, Double.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(70);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(4).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(4).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(5).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(5).setMaxWidth(0);
    }

    private void mCargarDatosTabla() {
        try {
            mCrearModeloDatos();
            String sql = "SELECT f_manual.Nbre, f_tarifasuministro.Codigo, f_tarifasuministro.Valor, f_tipoplan.Nbre, f_tarifasuministro.Id_suministro, f_tarifasuministro.Id_manual FROM  f_tarifasuministro INNER JOIN  f_manual  ON (f_tarifasuministro.Id_manual = f_manual.Id) INNER JOIN  f_tipoplan  ON (f_tarifasuministro.Id_TipoPlan = f_tipoplan.Id) WHERE (f_tarifasuministro.Id_suministro ='" + Principal.txtNo.getText() + "') ORDER BY f_manual.Nbre ASC ";
            ResultSet xrs = this.xconsulta.traerRs(sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(xrs.getString(1), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(3)), n, 2);
                    this.xmodelo.setValueAt(xrs.getString(4), n, 3);
                    this.xmodelo.setValueAt(xrs.getString("Id_suministro"), n, 4);
                    this.xmodelo.setValueAt(xrs.getString("Id_manual"), n, 5);
                    n++;
                }
            }
            xrs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFFTarifaSuministro.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mExportar(String xsql) {
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            try {
                WritableWorkbook workbook = Workbook.createWorkbook(new File(this.JTFRuta.getText() + ".xls"));
                WritableSheet sheet = workbook.createSheet("plantilla", 0);
                sheet.addCell(new Label(0, 1, "Id"));
                sheet.addCell(new Label(1, 1, "NProducto"));
                sheet.addCell(new Label(2, 1, "PFarmacéutica"));
                sheet.addCell(new Label(3, 1, "Laboratorio"));
                sheet.addCell(new Label(4, 1, "Tipo Producto"));
                sheet.addCell(new Label(5, 1, "Código CUM"));
                sheet.addCell(new Label(6, 1, "Valor"));
                ConsultasMySQL xt2 = new ConsultasMySQL();
                ResultSet rs = xt2.traerRs(xsql);
                if (rs.next()) {
                    rs.beforeFirst();
                    int x = 2;
                    while (rs.next()) {
                        sheet.addCell(new Number(0, x, rs.getLong(1)));
                        sheet.addCell(new Label(1, x, rs.getString(2)));
                        sheet.addCell(new Label(2, x, rs.getString(3)));
                        sheet.addCell(new Label(3, x, rs.getString(4)));
                        sheet.addCell(new Label(4, x, rs.getString(5)));
                        sheet.addCell(new Label(5, x, rs.getString(6)));
                        sheet.addCell(new Number(6, x, rs.getDouble(7)));
                        x++;
                    }
                }
                rs.close();
                xt2.cerrarConexionBd();
                workbook.write();
                workbook.close();
            } catch (SQLException ex) {
                Logger.getLogger(JIFFTarifaSuministro.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            } catch (WriteException e) {
                Logger.getLogger(JIFFTarifaSuministro.class.getName()).log(Level.SEVERE, (String) null, e);
            } catch (IOException ex2) {
                Logger.getLogger(JIFFTarifaSuministro.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex2);
            }
        }
    }
}
