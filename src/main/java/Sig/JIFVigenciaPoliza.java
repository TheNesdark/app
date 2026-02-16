package Sig;

import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
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
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

/* JADX INFO: loaded from: GenomaP.jar:Sig/JIFVigenciaPoliza.class */
public class JIFVigenciaPoliza extends JInternalFrame {
    private Metodos xmt;
    private DefaultTableModel xmodelo;
    private ConsultasMySQL xct;
    private String xnombre;
    private String xsql;
    private String[] xid;
    private Object[] xdato;
    private String xencontro;
    private boolean xcombo;
    private int xtipo;
    private ButtonGroup JBGFiltros;
    private JButton JBTExportar;
    private JRadioButton JRB30_60;
    private JRadioButton JRBMa60;
    private JRadioButton JRBMe30;
    private JRadioButton JRBTodo;
    private JScrollPane JSPDetalle;
    public JTable JTDetalle;
    private JTextField JTFRuta;
    private JPanel jPanel1;

    public JIFVigenciaPoliza(String xnombre) {
        this.xmt = new Metodos();
        this.xct = new ConsultasMySQL();
        this.xencontro = "0";
        this.xcombo = false;
        this.xtipo = 0;
        initComponents();
        this.xnombre = xnombre;
        mCargarDatosPoliza();
    }

    public JIFVigenciaPoliza(String xnombre, int xtipo) {
        this.xmt = new Metodos();
        this.xct = new ConsultasMySQL();
        this.xencontro = "0";
        this.xcombo = false;
        this.xtipo = 0;
        initComponents();
        this.xnombre = xnombre;
        this.xtipo = xtipo;
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
    }

    /* JADX WARN: Type inference failed for: r3v6, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGFiltros = new ButtonGroup();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JBTExportar = new JButton();
        this.JTFRuta = new JTextField();
        this.jPanel1 = new JPanel();
        this.JRBTodo = new JRadioButton();
        this.JRBMe30 = new JRadioButton();
        this.JRB30_60 = new JRadioButton();
        this.JRBMa60 = new JRadioButton();
        setClosable(true);
        setIconifiable(true);
        setTitle("CONSULTAR VIGENCIA DE PÓLIZAS");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifvigenciapoliza");
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setBorder(BorderFactory.createBevelBorder(0));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalle.setEditingColumn(1);
        this.JTDetalle.setEditingRow(1);
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.setSelectionMode(0);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: Sig.JIFVigenciaPoliza.1
            public void mouseClicked(MouseEvent evt) {
                JIFVigenciaPoliza.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: Sig.JIFVigenciaPoliza.2
            public void actionPerformed(ActionEvent evt) {
                JIFVigenciaPoliza.this.JBTExportarActionPerformed(evt);
            }
        });
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: Sig.JIFVigenciaPoliza.3
            public void mouseClicked(MouseEvent evt) {
                JIFVigenciaPoliza.this.JTFRutaMouseClicked(evt);
            }
        });
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "FILTROS", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.jPanel1.setForeground(new Color(0, 102, 0));
        this.JBGFiltros.add(this.JRBTodo);
        this.JRBTodo.setFont(new Font("Arial", 1, 12));
        this.JRBTodo.setSelected(true);
        this.JRBTodo.setText("Mostrar Todo");
        this.JRBTodo.addActionListener(new ActionListener() { // from class: Sig.JIFVigenciaPoliza.4
            public void actionPerformed(ActionEvent evt) {
                JIFVigenciaPoliza.this.JRBTodoActionPerformed(evt);
            }
        });
        this.JBGFiltros.add(this.JRBMe30);
        this.JRBMe30.setFont(new Font("Arial", 1, 12));
        this.JRBMe30.setText(" <= 30 días");
        this.JRBMe30.addActionListener(new ActionListener() { // from class: Sig.JIFVigenciaPoliza.5
            public void actionPerformed(ActionEvent evt) {
                JIFVigenciaPoliza.this.JRBMe30ActionPerformed(evt);
            }
        });
        this.JBGFiltros.add(this.JRB30_60);
        this.JRB30_60.setFont(new Font("Arial", 1, 12));
        this.JRB30_60.setText(" >30 y <=60 días");
        this.JRB30_60.addActionListener(new ActionListener() { // from class: Sig.JIFVigenciaPoliza.6
            public void actionPerformed(ActionEvent evt) {
                JIFVigenciaPoliza.this.JRB30_60ActionPerformed(evt);
            }
        });
        this.JBGFiltros.add(this.JRBMa60);
        this.JRBMa60.setFont(new Font("Arial", 1, 12));
        this.JRBMa60.setText("> 60 días");
        this.JRBMa60.addActionListener(new ActionListener() { // from class: Sig.JIFVigenciaPoliza.7
            public void actionPerformed(ActionEvent evt) {
                JIFVigenciaPoliza.this.JRBMa60ActionPerformed(evt);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(44, 44, 44).addComponent(this.JRBTodo).addGap(134, 134, 134).addComponent(this.JRBMe30).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JRB30_60).addGap(132, 132, 132).addComponent(this.JRBMa60).addGap(35, 35, 35)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBTodo).addComponent(this.JRBMe30).addComponent(this.JRB30_60).addComponent(this.JRBMa60)).addGap(0, 7, 32767)));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -1, -1, 32767).addGroup(layout.createSequentialGroup().addComponent(this.JTFRuta, -2, 577, -2).addGap(40, 40, 40).addComponent(this.JBTExportar, -1, 226, 32767))).addContainerGap()).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JSPDetalle, -2, 843, -2).addContainerGap(-1, 32767))));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 362, 32767).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTFRuta, -1, 50, 32767).addComponent(this.JBTExportar, -1, 50, 32767)).addContainerGap()).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(64, 64, 64).addComponent(this.JSPDetalle, -2, 334, -2).addContainerGap(75, 32767))));
        pack();
    }

    private void mCrearTablaPoliza() {
        this.xmodelo = new DefaultTableModel((Object[][]) null, new String[]{"Id", "Proveedor", "Tipo Doc", "No. Documento", "Fecha Vencimiento Póliza", "Días Vig", "Díasv"}) { // from class: Sig.JIFVigenciaPoliza.8
            Class[] types = {Integer.class, String.class, String.class, String.class, String.class, Long.class, Long.class};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(5);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(15);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(3);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(6).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(6).setMaxWidth(0);
    }

    private void mCargarDatosPoliza() {
        String sql;
        mCrearTablaPoliza();
        if (this.JRBMe30.isSelected()) {
            sql = "SELECT `g_empresa`.`Id` , cc_terceros.RazonSocialCompleta , `g_empresa`.`Id_TipoIdentificacion` , IF(`g_empresa`.`Dig_Verificacion`='',`g_empresa`.`No_identificacion`,CONCAT(`g_empresa`.`No_identificacion`,'-',`g_empresa`.`Dig_Verificacion`)) AS no_documento  , IF(`FechaPoliza` IS NULL,'',FechaPoliza) AS FecPoliza,DATEDIFF(CAST(g_empresa.`FechaPoliza` AS DATE),NOW()) AS dias,IF(DATEDIFF(CAST(g_empresa.`FechaPoliza` AS DATE),NOW())<=30,1, IF(DATEDIFF(CAST(g_empresa.`FechaPoliza` AS DATE),NOW())>30 AND DATEDIFF(CAST(g_empresa.`FechaPoliza` AS DATE),NOW())<60,2,3)) AS dias_v  FROM `g_empresa` INNER JOIN `g_municipio`  ON (`g_empresa`.`Id_Municipio` = `g_municipio`.`Id`) INNER JOIN `g_departamento` ON (`g_municipio`.`Id_Dpto` = `g_departamento`.`Id`) INNER JOIN `cc_terceros` ON (`g_empresa`.`Id` = `cc_terceros`.`Id`) WHERE (DATEDIFF(CAST(g_empresa.`FechaPoliza` AS DATE),NOW())<=30)ORDER BY cc_terceros.RazonSocialCompleta ASC";
        } else if (this.JRB30_60.isSelected()) {
            sql = "SELECT `g_empresa`.`Id` , cc_terceros.RazonSocialCompleta , `g_empresa`.`Id_TipoIdentificacion` , IF(`g_empresa`.`Dig_Verificacion`='',`g_empresa`.`No_identificacion`,CONCAT(`g_empresa`.`No_identificacion`,'-',`g_empresa`.`Dig_Verificacion`)) AS no_documento  , IF(`FechaPoliza` IS NULL,'',FechaPoliza) AS FecPoliza,DATEDIFF(CAST(g_empresa.`FechaPoliza` AS DATE),NOW()) AS dias,IF(DATEDIFF(CAST(g_empresa.`FechaPoliza` AS DATE),NOW())<=30,1, IF(DATEDIFF(CAST(g_empresa.`FechaPoliza` AS DATE),NOW())>30 AND DATEDIFF(CAST(g_empresa.`FechaPoliza` AS DATE),NOW())<60,2,3)) AS dias_v  FROM `g_empresa` INNER JOIN `g_municipio`  ON (`g_empresa`.`Id_Municipio` = `g_municipio`.`Id`) INNER JOIN `g_departamento` ON (`g_municipio`.`Id_Dpto` = `g_departamento`.`Id`) INNER JOIN `cc_terceros` ON (`g_empresa`.`Id` = `cc_terceros`.`Id`) WHERE (DATEDIFF(CAST(g_empresa.`FechaPoliza` AS DATE),NOW())>30 AND DATEDIFF(CAST(g_empresa.`FechaPoliza` AS DATE),NOW())<=60)ORDER BY cc_terceros.RazonSocialCompleta ASC";
        } else if (this.JRBMa60.isSelected()) {
            sql = "SELECT `g_empresa`.`Id` , cc_terceros.RazonSocialCompleta , `g_empresa`.`Id_TipoIdentificacion` , IF(`g_empresa`.`Dig_Verificacion`='',`g_empresa`.`No_identificacion`,CONCAT(`g_empresa`.`No_identificacion`,'-',`g_empresa`.`Dig_Verificacion`)) AS no_documento  , IF(`FechaPoliza` IS NULL,'',FechaPoliza) AS FecPoliza,DATEDIFF(CAST(g_empresa.`FechaPoliza` AS DATE),NOW()) AS dias,IF(DATEDIFF(CAST(g_empresa.`FechaPoliza` AS DATE),NOW())<=30,1, IF(DATEDIFF(CAST(g_empresa.`FechaPoliza` AS DATE),NOW())>30 AND DATEDIFF(CAST(g_empresa.`FechaPoliza` AS DATE),NOW())<60,2,3)) AS dias_v  FROM `g_empresa` INNER JOIN `g_municipio`  ON (`g_empresa`.`Id_Municipio` = `g_municipio`.`Id`) INNER JOIN `g_departamento` ON (`g_municipio`.`Id_Dpto` = `g_departamento`.`Id`) INNER JOIN `cc_terceros` ON (`g_empresa`.`Id` = `cc_terceros`.`Id`) WHERE (DATEDIFF(CAST(g_empresa.`FechaPoliza` AS DATE),NOW())>60)ORDER BY cc_terceros.RazonSocialCompleta ASC";
        } else {
            sql = "SELECT `g_empresa`.`Id` , cc_terceros.RazonSocialCompleta , `g_empresa`.`Id_TipoIdentificacion` , IF(`g_empresa`.`Dig_Verificacion`='',`g_empresa`.`No_identificacion`,CONCAT(`g_empresa`.`No_identificacion`,'-',`g_empresa`.`Dig_Verificacion`)) AS no_documento  , IF(`FechaPoliza` IS NULL,'',FechaPoliza) AS FecPoliza,\t\nDATEDIFF(CAST(g_empresa.`FechaPoliza` AS DATE),NOW()) AS dias,\nIF(DATEDIFF(CAST(g_empresa.`FechaPoliza` AS DATE),NOW())<=30,1, IF(DATEDIFF(CAST(g_empresa.`FechaPoliza` AS DATE),NOW())>30 AND DATEDIFF(CAST(g_empresa.`FechaPoliza` AS DATE),NOW())<=60,2,3)) AS dias_v \nFROM `g_empresa` INNER JOIN `g_municipio`  ON (`g_empresa`.`Id_Municipio` = `g_municipio`.`Id`) INNER JOIN `g_departamento` ON (`g_municipio`.`Id_Dpto` = `g_departamento`.`Id`)\nINNER JOIN `cc_terceros` ON (`g_empresa`.`Id` = `cc_terceros`.`Id`) \nORDER BY cc_terceros.RazonSocialCompleta ASC";
        }
        ResultSet rs = this.xct.traerRs(sql);
        try {
            if (rs.next()) {
                rs.beforeFirst();
                int x = 0;
                while (rs.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(Integer.valueOf(rs.getInt(1)), x, 0);
                    this.xmodelo.setValueAt(rs.getString(2), x, 1);
                    this.xmodelo.setValueAt(rs.getString(3), x, 2);
                    this.xmodelo.setValueAt(rs.getString(4), x, 3);
                    this.xmodelo.setValueAt(rs.getString(5), x, 4);
                    this.xmodelo.setValueAt(Long.valueOf(rs.getLong(6)), x, 5);
                    this.xmodelo.setValueAt(Long.valueOf(rs.getLong(7)), x, 6);
                    x++;
                }
            }
            this.JTDetalle.setDefaultRenderer(Object.class, new MiRender());
            rs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFVigenciaPoliza.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTExportarActionPerformed(ActionEvent evt) {
        mExportarInformacion();
    }

    private void mExportarInformacion() {
        if (this.JTDetalle.getRowCount() > 0) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                try {
                    WritableWorkbook workbook = Workbook.createWorkbook(new File(this.JTFRuta.getText() + ".xls"));
                    WritableSheet sheet = workbook.createSheet("plantilla", 0);
                    sheet.addCell(new Label(0, 0, this.xnombre.toUpperCase()));
                    sheet.addCell(new Label(0, 1, "ID"));
                    sheet.addCell(new Label(1, 1, "Proveedor"));
                    sheet.addCell(new Label(2, 1, "Tipo Doc"));
                    sheet.addCell(new Label(3, 1, "No. Documento"));
                    sheet.addCell(new Label(4, 1, "Fecha Vencimiento Póliza"));
                    sheet.addCell(new Label(5, 1, "Días Vigentes"));
                    int y = 2;
                    for (int x = 0; x < this.JTDetalle.getRowCount(); x++) {
                        sheet.addCell(new Number(0, y, Integer.valueOf(this.xmodelo.getValueAt(x, 0).toString()).intValue()));
                        sheet.addCell(new Label(1, y, this.xmodelo.getValueAt(x, 1).toString()));
                        sheet.addCell(new Label(2, y, this.xmodelo.getValueAt(x, 2).toString()));
                        sheet.addCell(new Label(3, y, this.xmodelo.getValueAt(x, 3).toString()));
                        sheet.addCell(new Label(4, y, this.xmodelo.getValueAt(x, 4).toString()));
                        sheet.addCell(new Number(5, y, Integer.valueOf(this.xmodelo.getValueAt(x, 5).toString()).intValue()));
                        y++;
                    }
                    workbook.write();
                    workbook.close();
                } catch (WriteException e) {
                    Logger.getLogger(JIFVigenciaPoliza.class.getName()).log(Level.SEVERE, (String) null, e);
                } catch (IOException ex) {
                    Logger.getLogger(JIFVigenciaPoliza.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                }
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
    public void JTDetalleMouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBTodoActionPerformed(ActionEvent evt) {
        mCargarDatosPoliza();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBMe30ActionPerformed(ActionEvent evt) {
        mCargarDatosPoliza();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB30_60ActionPerformed(ActionEvent evt) {
        mCargarDatosPoliza();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBMa60ActionPerformed(ActionEvent evt) {
        mCargarDatosPoliza();
    }

    /* JADX INFO: loaded from: GenomaP.jar:Sig/JIFVigenciaPoliza$MiRender.class */
    public static class MiRender extends DefaultTableCellRenderer {
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            String dias_v = table.getValueAt(row, 6).toString();
            if (dias_v != null && dias_v.equals("1")) {
                cell.setBackground(new Color(251, 54, 54));
                cell.setForeground(Color.WHITE);
            } else if (dias_v != null && dias_v.equals("2")) {
                cell.setBackground(Color.yellow);
                cell.setForeground(Color.BLACK);
            } else {
                cell.setBackground(new Color(133, 218, 160));
                cell.setForeground(Color.BLACK);
            }
            return cell;
        }
    }
}
