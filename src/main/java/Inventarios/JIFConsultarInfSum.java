package Inventarios;

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

/* JADX INFO: loaded from: GenomaP.jar:Inventarios/JIFConsultarInfSum.class */
public class JIFConsultarInfSum extends JInternalFrame {
    private String[] xidbodega;
    private DefaultTableModel xmodelo;
    private ConsultasMySQL xct = new ConsultasMySQL();
    private Metodos xmt = new Metodos();
    private Object[] xdato;
    private String xsql;
    private JButton JBTExportar;
    private JButton JBTExportar1;
    private JComboBox JCBBodega;
    private JComboBox JCBBodega1;
    private JDateChooser JDFechaF;
    private JDateChooser JDFechaF1;
    private JDateChooser JDFechaI;
    private JDateChooser JDFechaI1;
    private JPanel JPIFiltro;
    private JPanel JPIFiltro1;
    private JScrollPane JSPDetalle;
    private JScrollPane JSPDetalle1;
    private JTable JTBDetalle;
    private JTable JTBDetalle1;
    private JTextField JTFRuta;
    private JTextField JTFRuta1;
    private JInternalFrame jInternalFrame1;

    public JIFConsultarInfSum(String xtitulo, String xnombre) {
        initComponents();
        setName(xnombre);
        setTitle(xtitulo);
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v36, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v75, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPIFiltro = new JPanel();
        this.JDFechaI = new JDateChooser();
        this.JDFechaF = new JDateChooser();
        this.JCBBodega = new JComboBox();
        this.JTFRuta = new JTextField();
        this.JBTExportar = new JButton();
        this.JSPDetalle = new JScrollPane();
        this.JTBDetalle = new JTable();
        this.jInternalFrame1 = new JInternalFrame();
        this.JPIFiltro1 = new JPanel();
        this.JDFechaI1 = new JDateChooser();
        this.JDFechaF1 = new JDateChooser();
        this.JCBBodega1 = new JComboBox();
        this.JTFRuta1 = new JTextField();
        this.JBTExportar1 = new JButton();
        this.JSPDetalle1 = new JScrollPane();
        this.JTBDetalle1 = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("CONSULTAR");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifconsultardespacho");
        this.JPIFiltro.setBorder(BorderFactory.createTitledBorder((Border) null, "FILTRO", 0, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JDFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFechaI.setFont(new Font("Arial", 1, 12));
        this.JDFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Fin", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFechaF.setFont(new Font("Arial", 1, 12));
        this.JCBBodega.setFont(new Font("Arial", 1, 12));
        this.JCBBodega.setBorder(BorderFactory.createTitledBorder((Border) null, "Bodega", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: Inventarios.JIFConsultarInfSum.1
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarInfSum.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setForeground(Color.red);
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: Inventarios.JIFConsultarInfSum.2
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarInfSum.this.JBTExportarActionPerformed(evt);
            }
        });
        GroupLayout JPIFiltroLayout = new GroupLayout(this.JPIFiltro);
        this.JPIFiltro.setLayout(JPIFiltroLayout);
        JPIFiltroLayout.setHorizontalGroup(JPIFiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFiltroLayout.createSequentialGroup().addContainerGap().addGroup(JPIFiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFiltroLayout.createSequentialGroup().addComponent(this.JDFechaI, -2, 116, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JDFechaF, -2, 116, -2).addGap(18, 18, 18).addComponent(this.JCBBodega, 0, 549, 32767)).addGroup(JPIFiltroLayout.createSequentialGroup().addComponent(this.JTFRuta, -2, 667, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTExportar, -2, 128, -2))).addContainerGap()));
        JPIFiltroLayout.setVerticalGroup(JPIFiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFiltroLayout.createSequentialGroup().addGroup(JPIFiltroLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JCBBodega, GroupLayout.Alignment.LEADING).addComponent(this.JDFechaF, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.JDFechaI, GroupLayout.Alignment.LEADING, -1, -1, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPIFiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JBTExportar, -2, 50, -2).addComponent(this.JTFRuta, -2, 50, -2)).addContainerGap(14, 32767)));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTBDetalle.setFont(new Font("Arial", 1, 12));
        this.JTBDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTBDetalle.setRowHeight(25);
        this.JTBDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTBDetalle.setSelectionForeground(Color.red);
        this.JTBDetalle.setSelectionMode(0);
        this.JTBDetalle.addMouseListener(new MouseAdapter() { // from class: Inventarios.JIFConsultarInfSum.3
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarInfSum.this.JTBDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTBDetalle);
        this.jInternalFrame1.setClosable(true);
        this.jInternalFrame1.setIconifiable(true);
        this.jInternalFrame1.setTitle("CONSULTAR");
        this.jInternalFrame1.setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        this.jInternalFrame1.setName("jifconsultardespacho");
        this.JPIFiltro1.setBorder(BorderFactory.createTitledBorder((Border) null, "FILTRO", 0, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JDFechaI1.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaI1.setDateFormatString("dd/MM/yyyy");
        this.JDFechaI1.setFont(new Font("Arial", 1, 12));
        this.JDFechaF1.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Fin", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaF1.setDateFormatString("dd/MM/yyyy");
        this.JDFechaF1.setFont(new Font("Arial", 1, 12));
        this.JCBBodega1.setFont(new Font("Arial", 1, 12));
        this.JCBBodega1.setBorder(BorderFactory.createTitledBorder((Border) null, "Bodega", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta1.setFont(new Font("Arial", 1, 12));
        this.JTFRuta1.setText("C:\\plantilla");
        this.JTFRuta1.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta1.addMouseListener(new MouseAdapter() { // from class: Inventarios.JIFConsultarInfSum.4
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarInfSum.this.JTFRuta1MouseClicked(evt);
            }
        });
        this.JBTExportar1.setFont(new Font("Arial", 1, 12));
        this.JBTExportar1.setForeground(Color.red);
        this.JBTExportar1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/actualizar.png")));
        this.JBTExportar1.setText("Exportar");
        this.JBTExportar1.addActionListener(new ActionListener() { // from class: Inventarios.JIFConsultarInfSum.5
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarInfSum.this.JBTExportar1ActionPerformed(evt);
            }
        });
        GroupLayout JPIFiltro1Layout = new GroupLayout(this.JPIFiltro1);
        this.JPIFiltro1.setLayout(JPIFiltro1Layout);
        JPIFiltro1Layout.setHorizontalGroup(JPIFiltro1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFiltro1Layout.createSequentialGroup().addContainerGap().addGroup(JPIFiltro1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFiltro1Layout.createSequentialGroup().addComponent(this.JDFechaI1, -2, 116, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JDFechaF1, -2, 116, -2).addGap(18, 18, 18).addComponent(this.JCBBodega1, 0, -1, 32767)).addGroup(JPIFiltro1Layout.createSequentialGroup().addComponent(this.JTFRuta1, -2, 667, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTExportar1, -2, 128, -2))).addContainerGap()));
        JPIFiltro1Layout.setVerticalGroup(JPIFiltro1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFiltro1Layout.createSequentialGroup().addGroup(JPIFiltro1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JCBBodega1, GroupLayout.Alignment.LEADING).addComponent(this.JDFechaF1, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.JDFechaI1, GroupLayout.Alignment.LEADING, -1, -1, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPIFiltro1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JBTExportar1, -2, 50, -2).addComponent(this.JTFRuta1, -2, 50, -2)).addContainerGap(14, 32767)));
        this.JSPDetalle1.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JTBDetalle1.setFont(new Font("Arial", 1, 12));
        this.JTBDetalle1.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTBDetalle1.setRowHeight(25);
        this.JTBDetalle1.setSelectionBackground(new Color(255, 255, 255));
        this.JTBDetalle1.setSelectionForeground(Color.red);
        this.JTBDetalle1.addMouseListener(new MouseAdapter() { // from class: Inventarios.JIFConsultarInfSum.6
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarInfSum.this.JTBDetalle1MouseClicked(evt);
            }
        });
        this.JSPDetalle1.setViewportView(this.JTBDetalle1);
        GroupLayout jInternalFrame1Layout = new GroupLayout(this.jInternalFrame1.getContentPane());
        this.jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(jInternalFrame1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jInternalFrame1Layout.createSequentialGroup().addContainerGap().addComponent(this.JPIFiltro1, -1, -1, 32767).addContainerGap()).addGroup(jInternalFrame1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jInternalFrame1Layout.createSequentialGroup().addContainerGap().addComponent(this.JSPDetalle1, -1, 837, 32767).addContainerGap())));
        jInternalFrame1Layout.setVerticalGroup(jInternalFrame1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jInternalFrame1Layout.createSequentialGroup().addContainerGap().addComponent(this.JPIFiltro1, -2, -1, -2).addContainerGap(-1, 32767)).addGroup(jInternalFrame1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jInternalFrame1Layout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.JSPDetalle1, -2, 357, -2).addContainerGap())));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPIFiltro, -1, -1, 32767).addComponent(this.JSPDetalle, -1, 841, 32767)).addContainerGap()).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(0, 430, 32767).addComponent(this.jInternalFrame1, -2, 0, -2).addGap(0, 431, 32767))));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIFiltro, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPDetalle, -2, 387, -2).addContainerGap(-1, 32767)).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(0, 283, 32767).addComponent(this.jInternalFrame1, -2, 0, -2).addGap(0, 283, 32767))));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBDetalleMouseClicked(MouseEvent evt) {
        if (this.JTBDetalle.getSelectedRow() != -1 && getName().equals("jifconsultardespacho")) {
            String[][] parametros = new String[4][2];
            parametros[0][0] = "Id";
            parametros[0][1] = this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 0).toString();
            parametros[1][0] = "UsuarioS";
            parametros[1][1] = Principal.usuarioSistemaDTO.getNombreUsuario();
            parametros[2][0] = "SUBREPORT_DIR";
            parametros[2][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
            parametros[3][0] = "SUBREPORTFIRMA_DIR";
            parametros[3][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
            this.xmt.GenerarPDF(this.xmt.getRutaRep() + "I_Nota_Cargo", parametros);
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
    public void JBTExportarActionPerformed(ActionEvent evt) {
        if (!this.JTFRuta.getText().isEmpty()) {
            if (this.JTBDetalle.getRowCount() > -1) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRuta1MouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTExportar1ActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBDetalle1MouseClicked(MouseEvent evt) {
    }

    public void mNuevo() {
        this.JDFechaI.setDate(this.xmt.getFechaActual());
        this.JDFechaF.setDate(this.xmt.getFechaActual());
        this.JCBBodega.removeAllItems();
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
        if (getName().equals("jifconsultardespacho")) {
            this.xidbodega = this.xct.llenarCombo("SELECT  Id , Nbre FROM i_bodegas WHERE (Estado =0 AND PReposicion =1) ORDER BY Nbre ASC", this.xidbodega, this.JCBBodega);
        } else if (getName().equals("xjifconsultarinf")) {
            this.xsql = "SELECT i_salidas.IdBodega , i_bodegas.Nbre FROM i_faltantes INNER JOIN i_salidas  ON (i_faltantes.IdSalida = i_salidas.Id) INNER JOIN i_bodegas  ON (i_salidas.IdBodega = i_bodegas.Id) WHERE (i_salidas.Estado =0) GROUP BY i_salidas.IdBodega ORDER BY i_bodegas.Nbre ASC ";
            this.xidbodega = this.xct.llenarCombo(this.xsql, this.xidbodega, this.JCBBodega);
        } else if (getName().equals("xjifconsultarpsrotacion")) {
            this.xsql = "SELECT i_bodegas.Id, i_bodegas.Nbre FROM i_suministroxbodega INNER JOIN i_bodegas  ON (i_suministroxbodega.IdBodega = i_bodegas.Id) WHERE (i_bodegas.Estado =0) GROUP BY i_bodegas.Id ORDER BY i_bodegas.Nbre ASC ";
            this.xidbodega = this.xct.llenarCombo(this.xsql, this.xidbodega, this.JCBBodega);
        } else if (getName().equals("xjifconsultarfespecialidad")) {
            this.xsql = "SELECT `profesional1`.`IdEspecialidad` , `profesional1`.`Especialidad` FROM `profesional1` INNER JOIN `i_salidas`  ON (`profesional1`.`IdEspecialidad` = `i_salidas`.`IdEspecialidad`) AND (`profesional1`.`Id_Persona` = `i_salidas`.`IdProfesional`) WHERE (`i_salidas`.`Estado` =0 AND `i_salidas`.`IdBodega` ='" + Principal.xClaseInventario.getIdBodega() + "') GROUP BY `profesional1`.`IdEspecialidad` ";
            this.xidbodega = this.xct.llenarCombo(this.xsql, this.xidbodega, this.JCBBodega);
        }
        this.JCBBodega.setSelectedIndex(-1);
        this.xct.cerrarConexionBd();
        mCrearTabla();
    }

    public void mGrabar() {
        if (getName().equals("xjifconsultarpsrotacion")) {
            if (this.xmt.mVerificarDatosTablaTrue(this.JTBDetalle, 9)) {
                int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro re grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (n == 0) {
                    for (int x = 0; x < this.JTBDetalle.getSelectedRowCount(); x++) {
                        if (Boolean.valueOf(this.xmodelo.getValueAt(x, 9).toString()).booleanValue()) {
                            this.xsql = "update i_suministroxbodega set cinventario=1 where Id='" + this.xmodelo.getValueAt(x, 10) + "'";
                            this.xct.ejecutarSQL(this.xsql);
                            this.xct.cerrarConexionBd();
                        }
                    }
                    return;
                }
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar los items a actualizar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        }
    }

    private void mCrearTabla() {
        this.xmodelo = new DefaultTableModel((Object[][]) null, new String[]{"Id", "Fecha", "No. Hc", "Usuario", "Tipo", "Profesional"}) { // from class: Inventarios.JIFConsultarInfSum.7
            Class[] types = {Long.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTBDetalle.setModel(this.xmodelo);
        this.JTBDetalle.getColumnModel().getColumn(0).setPreferredWidth(20);
        this.JTBDetalle.getColumnModel().getColumn(1).setPreferredWidth(30);
        this.JTBDetalle.getColumnModel().getColumn(2).setPreferredWidth(40);
        this.JTBDetalle.getColumnModel().getColumn(3).setPreferredWidth(200);
        this.JTBDetalle.getColumnModel().getColumn(4).setPreferredWidth(30);
        this.JTBDetalle.getColumnModel().getColumn(5).setPreferredWidth(100);
    }

    private void mCrearTabla1() {
        this.xmodelo = new DefaultTableModel((Object[][]) null, new String[]{"Id", "Producto", "PComercial", "Laboratorio", "TCantidad", "SCantidadUE", "CantidadUE"}) { // from class: Inventarios.JIFConsultarInfSum.8
            Class[] types = {Long.class, String.class, String.class, String.class, Long.class, Long.class, Long.class};
            boolean[] canEdit = {false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTBDetalle.setModel(this.xmodelo);
        this.JTBDetalle.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTBDetalle.getColumnModel().getColumn(1).setPreferredWidth(200);
        this.JTBDetalle.getColumnModel().getColumn(2).setPreferredWidth(50);
        this.JTBDetalle.getColumnModel().getColumn(3).setPreferredWidth(50);
        this.JTBDetalle.getColumnModel().getColumn(4).setPreferredWidth(30);
        this.JTBDetalle.getColumnModel().getColumn(5).setPreferredWidth(30);
        this.JTBDetalle.getColumnModel().getColumn(6).setPreferredWidth(30);
    }

    private void mCrearTabla2() {
        this.xmodelo = new DefaultTableModel((Object[][]) null, new String[]{"Id", "Producto", "PActivo", "PComercial", "Laboratorio", "Lote", "FechaVenc", "Cant", "FURotación", "CEstado", "IdSuministroBodega"}) { // from class: Inventarios.JIFConsultarInfSum.9
            Class[] types = {Long.class, String.class, String.class, String.class, String.class, String.class, String.class, Long.class, String.class, Boolean.class, Long.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTBDetalle.setModel(this.xmodelo);
        this.JTBDetalle.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTBDetalle.getColumnModel().getColumn(1).setPreferredWidth(200);
        this.JTBDetalle.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTBDetalle.getColumnModel().getColumn(3).setPreferredWidth(50);
        this.JTBDetalle.getColumnModel().getColumn(4).setPreferredWidth(50);
        this.JTBDetalle.getColumnModel().getColumn(5).setPreferredWidth(30);
        this.JTBDetalle.getColumnModel().getColumn(6).setPreferredWidth(30);
        this.JTBDetalle.getColumnModel().getColumn(7).setPreferredWidth(30);
        this.JTBDetalle.getColumnModel().getColumn(8).setPreferredWidth(30);
        if (getName().equals("xjifconsultarpsrotacion")) {
            this.JTBDetalle.getColumnModel().getColumn(9).setPreferredWidth(30);
        } else {
            this.JTBDetalle.getColumnModel().getColumn(9).setPreferredWidth(0);
            this.JTBDetalle.getColumnModel().getColumn(9).setMinWidth(0);
            this.JTBDetalle.getColumnModel().getColumn(9).setMaxWidth(0);
        }
        this.JTBDetalle.getColumnModel().getColumn(10).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(10).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(10).setMaxWidth(0);
    }

    private void mCargarDatosTabla() {
        try {
            String sql = null;
            if (getName().equals("xjifconsultarinf")) {
                mCrearTabla1();
                sql = "SELECT i_suministro.Id, i_suministro.Nbre, i_presentacioncomercial.Nbre, i_laboratorio.Nbre , sum(i_detallefaltante.Cantidad) as Cantidad , IF(i_bodegas.Principal=0, IF(ROUND(SUM(i_detallefaltante.Cantidad)/i_suministro.CantidadUnidad)=0,1,ROUND(SUM(i_detallefaltante.Cantidad)/i_suministro.CantidadUnidad)), SUM(i_detallefaltante.Cantidad))  AS TCantidadUE , i_suministro.CantidadUnidad FROM i_detallefaltante INNER JOIN i_faltantes  ON (i_detallefaltante.IdFaltante = i_faltantes.Id) INNER JOIN i_salidas  ON (i_faltantes.IdSalida = i_salidas.Id) INNER JOIN i_suministro  ON (i_detallefaltante.IdSuministro = i_suministro.Id)  INNER JOIN i_presentacioncomercial  ON (i_suministro.IdPresentacionComercial = i_presentacioncomercial.Id) INNER JOIN i_laboratorio  ON (i_suministro.IdLaboratorio = i_laboratorio.Id) INNER JOIN i_bodegas  ON (i_salidas.IdBodega = i_bodegas.Id) WHERE (i_salidas.FechaSalida >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND i_salidas.FechaSalida <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' AND i_salidas.Estado =0 AND i_salidas.IdBodega ='" + this.xidbodega[this.JCBBodega.getSelectedIndex()] + "') GROUP BY i_suministro.Id ORDER BY TCantidadUE DESC ";
            } else if (getName().equals("jifconsultardespacho")) {
                mCrearTabla();
                sql = "SELECT i_salidas.Id, date_format(i_salidas.FechaSalida,'%d-%m-%Y') as Fecha, persona.NoHistoria, persona.NUsuario, i_tiposmovimientos.Nbre, profesional1.NProfesional FROM persona INNER JOIN i_salidas  ON (persona.Id_persona = i_salidas.IdDestino) INNER JOIN i_tiposmovimientos  ON (i_salidas.IdTipoMovimiento = i_tiposmovimientos.Id) INNER JOIN profesional1  ON (profesional1.Id_Persona = i_salidas.IdProfesional) AND (profesional1.IdEspecialidad = i_salidas.IdEspecialidad) WHERE (i_salidas.IdBodega ='" + this.xidbodega[this.JCBBodega.getSelectedIndex()] + "' AND i_salidas.FechaSalida >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "'AND i_salidas.FechaSalida <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "'AND i_salidas.Estado =0) ORDER BY i_salidas.FechaSalida ASC, persona.NUsuario ASC ";
            } else if (getName().equals("xjifconsultarpsrotacion")) {
                mCrearTabla2();
                mArmarDatosSinRotacion();
                sql = "SELECT i_suministro.Id, i_suministro.Nbre, i_principioactivo.Nbre, i_presentacioncomercial.Nbre, i_laboratorio.Nbre, i_suministroxlotexbodega.Lote, DATE_FORMAT(i_suministroxlotexbodega.FechaVencimiento,'%d-%m-%Y') AS FV, i_suministroxlotexbodega.Cantidad, DATE_FORMAT(i_suministroxbodega.FechaUR,'%d-%m-%Y') AS FUR, i_suministroxbodega.Id FROM i_suministro INNER JOIN i_tmp_sbodega  ON (i_suministro.Id = i_tmp_sbodega.Id_Suministro) INNER JOIN i_suministroxbodega  ON (i_suministroxbodega.Id = i_tmp_sbodega.Id_SuministroB) AND (i_suministroxbodega.IdSuministro = i_suministro.Id) INNER JOIN i_presentacioncomercial  ON (i_suministro.IdPresentacionComercial = i_presentacioncomercial.Id) INNER JOIN i_laboratorio  ON (i_suministro.IdLaboratorio = i_laboratorio.Id) INNER JOIN i_principioactivo  ON (i_suministro.IdPrincipioActivo = i_principioactivo.Id) INNER JOIN i_suministroxlotexbodega  ON (i_suministroxlotexbodega.Id = i_suministroxbodega.Id) WHERE (i_suministroxlotexbodega.Cantidad <>0 and i_suministroxbodega.FechaUR >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "'AND i_suministroxbodega.FechaUR <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "') ";
            } else if (getName().equals("xjifconsultarfespecialidad")) {
                mCrearTabla1();
                sql = "SELECT `i_suministro`.`Id`, `i_suministro`.`Nbre`, `i_presentacioncomercial`.`Nbre`, `i_laboratorio`.`Nbre`, SUM(`i_detallesalida`.`CantidadDespachada`) AS `CantidadU`, ROUND(SUM(`i_detallesalida`.`CantidadDespachada`)/`i_suministro`.`CantidadUnidad`) AS `CantidadUE` , `i_suministro`.`CantidadUnidad` FROM `i_detallesalida` INNER JOIN `i_salidas`  ON (`i_detallesalida`.`IdSalida` = `i_salidas`.`Id`) INNER JOIN `i_suministro`  ON (`i_detallesalida`.`IdSuministro` = `i_suministro`.`Id`) INNER JOIN `i_presentacioncomercial`  ON (`i_suministro`.`IdPresentacionComercial` = `i_presentacioncomercial`.`Id`) INNER JOIN `i_laboratorio`  ON (`i_suministro`.`IdLaboratorio` = `i_laboratorio`.`Id`) WHERE (`i_salidas`.`FechaSalida` >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND `i_salidas`.`FechaSalida` <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' AND `i_salidas`.`Estado` =0 AND `i_salidas`.`IdEspecialidad` ='" + this.xidbodega[this.JCBBodega.getSelectedIndex()] + "' AND `i_salidas`.`IdBodega` ='" + Principal.xClaseInventario.getIdBodega() + "') GROUP BY `i_suministro`.`Id`, `i_detallesalida`.`CantidadDespachada` ORDER BY `CantidadU` DESC, `i_suministro`.`Nbre` ASC ";
            }
            ResultSet rs = this.xct.traerRs(sql);
            rs.next();
            if (rs.getRow() != 0) {
                rs.beforeFirst();
                int i = 0;
                while (rs.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(Long.valueOf(rs.getLong(1)), i, 0);
                    this.xmodelo.setValueAt(rs.getString(2), i, 1);
                    this.xmodelo.setValueAt(rs.getString(3), i, 2);
                    this.xmodelo.setValueAt(rs.getString(4), i, 3);
                    if (getTitle().equals("Consultar Listado Productos Faltantes".toUpperCase()) || getTitle().equals("Consultar Despacho x Especialidad".toUpperCase())) {
                        this.xmodelo.setValueAt(Long.valueOf(rs.getLong(5)), i, 4);
                        this.xmodelo.setValueAt(Long.valueOf(rs.getLong(6)), i, 5);
                        this.xmodelo.setValueAt(Long.valueOf(rs.getLong(7)), i, 6);
                    } else if (getTitle().equals("Consultar Productos Sin Rotación".toUpperCase())) {
                        this.xmodelo.setValueAt(rs.getString(5), i, 4);
                        this.xmodelo.setValueAt(rs.getString(6), i, 5);
                        this.xmodelo.setValueAt(rs.getString(7), i, 6);
                        this.xmodelo.setValueAt(Long.valueOf(rs.getLong(8)), i, 7);
                        this.xmodelo.setValueAt(rs.getString(9), i, 8);
                        this.xmodelo.setValueAt(true, i, 9);
                        this.xmodelo.setValueAt(Long.valueOf(rs.getLong(10)), i, 10);
                    } else {
                        this.xmodelo.setValueAt(rs.getString(5), i, 4);
                        this.xmodelo.setValueAt(rs.getString(6), i, 5);
                    }
                    i++;
                }
            }
            rs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFConsultarInfSum.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mBuscar() {
        if (this.JCBBodega.getSelectedIndex() != -1) {
            mCargarDatosTabla();
        } else {
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una bodega", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBBodega.requestFocus();
        }
    }

    private void mExportar() {
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            try {
                WritableWorkbook workbook = Workbook.createWorkbook(new File(this.JTFRuta.getText() + ".xls"));
                WritableSheet sheet = workbook.createSheet("plantilla", 0);
                for (int x = 0; x < this.JTBDetalle.getColumnCount(); x++) {
                    sheet.addCell(new Label(x, 0, this.JTBDetalle.getColumnName(x)));
                }
                for (int x2 = 0; x2 < this.JTBDetalle.getRowCount(); x2++) {
                    sheet.addCell(new Number(0, x2 + 1, Long.valueOf(this.xmodelo.getValueAt(x2, 0).toString()).longValue()));
                    sheet.addCell(new Label(1, x2 + 1, this.xmodelo.getValueAt(x2, 1).toString()));
                    sheet.addCell(new Label(2, x2 + 1, this.xmodelo.getValueAt(x2, 2).toString()));
                    sheet.addCell(new Label(3, x2 + 1, this.xmodelo.getValueAt(x2, 3).toString()));
                    if (getTitle().equals("Consultar Productos Sin Rotación".toUpperCase())) {
                        sheet.addCell(new Label(4, x2 + 1, this.xmodelo.getValueAt(x2, 4).toString()));
                        sheet.addCell(new Label(5, x2 + 1, this.xmodelo.getValueAt(x2, 5).toString()));
                        sheet.addCell(new Label(6, x2 + 1, this.xmodelo.getValueAt(x2, 6).toString()));
                        sheet.addCell(new Number(7, x2 + 1, Double.valueOf(this.xmodelo.getValueAt(x2, 7).toString()).doubleValue()));
                        sheet.addCell(new Label(8, x2 + 1, this.xmodelo.getValueAt(x2, 8).toString()));
                    } else {
                        sheet.addCell(new Number(4, x2 + 1, Long.valueOf(this.xmodelo.getValueAt(x2, 4).toString()).longValue()));
                        sheet.addCell(new Number(5, x2 + 1, Long.valueOf(this.xmodelo.getValueAt(x2, 5).toString()).longValue()));
                        sheet.addCell(new Number(6, x2 + 1, Double.valueOf(this.xmodelo.getValueAt(x2, 6).toString()).doubleValue()));
                    }
                }
                workbook.write();
                workbook.close();
            } catch (WriteException e) {
                Logger.getLogger(JIFConsultarInfSum.class.getName()).log(Level.SEVERE, (String) null, e);
            } catch (IOException ex) {
                Logger.getLogger(JIFConsultarInfSum.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        }
    }

    private void mArmarDatosSinRotacion() {
        this.xsql = "DROP TABLE IF EXISTS i_tmp_sbodega ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "CREATE TABLE `i_tmp_sbodega` (`Id_Suministro` bigint(19) default '0',  `Id_SuministroB` bigint(18) default '0', `TMov` tinyint(1) default '0') ENGINE=InnoDB DEFAULT CHARSET=latin1 ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "INSERT INTO i_tmp_sbodega (Id_Suministro,Id_SuministroB) SELECT i_suministro.Id , i_suministroxbodega.Id  FROM i_suministro INNER JOIN i_presentacioncomercial  ON (i_suministro.IdPresentacionComercial = i_presentacioncomercial.Id) INNER JOIN i_laboratorio  ON (i_suministro.IdLaboratorio = i_laboratorio.Id) INNER JOIN i_principioactivo  ON (i_suministro.IdPrincipioActivo = i_principioactivo.Id) INNER JOIN i_suministroxbodega  ON (i_suministroxbodega.IdSuministro = i_suministro.Id) INNER JOIN i_suministroxlotexbodega  ON (i_suministroxlotexbodega.Id = i_suministroxbodega.Id) WHERE (i_suministroxbodega.IdBodega ='" + this.xidbodega[this.JCBBodega.getSelectedIndex()] + "') GROUP BY i_suministroxlotexbodega.Id HAVING (SUM(i_suministroxlotexbodega.Cantidad) <>0) ORDER BY i_principioactivo.Nbre ASC, i_suministro.Nbre ASC ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "DROP TABLE IF EXISTS i_tmp  ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "CREATE TABLE `i_tmp` (`Id` bigint(19) default NULL ) ENGINE=InnoDB DEFAULT CHARSET=latin1 ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "INSERT INTO i_tmp (Id) SELECT i_suministro.Id FROM i_detallesalida INNER JOIN i_suministro  ON (i_detallesalida.IdSuministro = i_suministro.Id) INNER JOIN i_salidas  ON (i_detallesalida.IdSalida = i_salidas.Id) WHERE (i_salidas.IdBodega ='" + this.xidbodega[this.JCBBodega.getSelectedIndex()] + "' AND i_salidas.FechaSalida >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND i_salidas.IdDestino <>0 AND i_salidas.FechaSalida <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "') GROUP BY i_suministro.Id ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "UPDATE i_tmp_sbodega, i_tmp SET i_tmp_sbodega.TMov=1 WHERE i_tmp_sbodega.Id_Suministro=i_tmp.Id ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "delete  from i_tmp_sbodega  where i_tmp_sbodega.TMov=1";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
    }
}
