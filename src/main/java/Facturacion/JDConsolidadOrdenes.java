package Facturacion;

import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JYearChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Facturacion/JDConsolidadOrdenes.class */
public class JDConsolidadOrdenes extends JDialog {
    private String sql;
    private ConsultasMySQL consultas;
    private ResultSet rs;
    private Object[] dato;
    private Facturac frmFacturac;
    private Facturac1 frmFacturac1;
    private DefaultTableModel modeloproc;
    private DefaultTableModel modelosum;
    private Metodos xmt;
    private boolean xlleno;
    private JTabbedPane Datos;
    private JButton JBTExportar;
    private JScrollPane JSPProcedimientos;
    private JScrollPane JSPSuministros;
    private JTextField JTFRuta;
    private JTable JTProcedimientos;
    private JTable JTSuministros;
    private JYearChooser JYCAno;
    private JPanel Panel;
    private JLabel Titulo;
    private JButton btnCerrar;

    public JDConsolidadOrdenes(Frame parent, boolean modal, Facturac frm) {
        super(parent, modal);
        this.consultas = new ConsultasMySQL();
        this.xmt = new Metodos();
        this.xlleno = false;
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        this.frmFacturac = frm;
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
        setTitle("CONSOLIDADO DE ORDENES FACTURADAS");
        cargarGridSum(this.frmFacturac.frmPersona.getIdPersona());
        cargarGridProc(this.frmFacturac.frmPersona.getIdPersona());
        setLocationRelativeTo(null);
        this.xlleno = true;
    }

    public JDConsolidadOrdenes(Frame parent, boolean modal, Facturac1 frm) {
        super(parent, modal);
        this.consultas = new ConsultasMySQL();
        this.xmt = new Metodos();
        this.xlleno = false;
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        this.frmFacturac1 = frm;
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
        setTitle("CONSOLIDADO DE ORDENES FACTURADAS");
        cargarGridSum(this.frmFacturac.frmPersona.getIdPersona());
        cargarGridProc(this.frmFacturac.frmPersona.getIdPersona());
        setLocationRelativeTo(null);
        this.xlleno = true;
    }

    /* JADX WARN: Type inference failed for: r3v39, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v45, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.Panel = new JPanel();
        this.btnCerrar = new JButton();
        this.JYCAno = new JYearChooser();
        this.JTFRuta = new JTextField();
        this.JBTExportar = new JButton();
        this.Titulo = new JLabel();
        this.Datos = new JTabbedPane();
        this.JSPProcedimientos = new JScrollPane();
        this.JTProcedimientos = new JTable();
        this.JSPSuministros = new JScrollPane();
        this.JTSuministros = new JTable();
        setDefaultCloseOperation(2);
        setName("BuscarPersona");
        setResizable(false);
        this.Panel.setBorder(BorderFactory.createEtchedBorder());
        this.Panel.setName("Panel");
        this.btnCerrar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.btnCerrar.setText("Cerrar");
        this.btnCerrar.addActionListener(new ActionListener() { // from class: Facturacion.JDConsolidadOrdenes.1
            public void actionPerformed(ActionEvent evt) {
                JDConsolidadOrdenes.this.btnCerrarActionPerformed(evt);
            }
        });
        this.JYCAno.setBorder(BorderFactory.createTitledBorder((Border) null, "Año", 0, 0, new Font("Arial", 1, 13), Color.blue));
        this.JYCAno.addPropertyChangeListener(new PropertyChangeListener() { // from class: Facturacion.JDConsolidadOrdenes.2
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JDConsolidadOrdenes.this.JYCAnoPropertyChange(evt);
            }
        });
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: Facturacion.JDConsolidadOrdenes.3
            public void mouseClicked(MouseEvent evt) {
                JDConsolidadOrdenes.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setForeground(Color.red);
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: Facturacion.JDConsolidadOrdenes.4
            public void actionPerformed(ActionEvent evt) {
                JDConsolidadOrdenes.this.JBTExportarActionPerformed(evt);
            }
        });
        GroupLayout PanelLayout = new GroupLayout(this.Panel);
        this.Panel.setLayout(PanelLayout);
        PanelLayout.setHorizontalGroup(PanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(PanelLayout.createSequentialGroup().addContainerGap().addComponent(this.JYCAno, -2, 70, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFRuta, -2, 590, -2).addGap(8, 8, 8).addComponent(this.JBTExportar).addGap(18, 18, 18).addComponent(this.btnCerrar, -2, 110, -2)));
        PanelLayout.setVerticalGroup(PanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(PanelLayout.createSequentialGroup().addGap(16, 16, 16).addGroup(PanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(PanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBTExportar, -2, 50, -2).addComponent(this.btnCerrar, -2, 50, -2)).addComponent(this.JTFRuta, -2, 50, -2).addComponent(this.JYCAno, -2, 50, -2)).addContainerGap(18, 32767)));
        this.Titulo.setBackground(new Color(0, 0, 153));
        this.Titulo.setFont(new Font("Tahoma", 1, 14));
        this.Titulo.setForeground(new Color(255, 255, 255));
        this.Titulo.setHorizontalAlignment(0);
        this.Titulo.setText("CONSOLIDADO DE ORDENES FACTURADAS");
        this.Titulo.setOpaque(true);
        this.Datos.setForeground(new Color(255, 0, 0));
        this.Datos.setFont(new Font("Arial", 1, 12));
        this.JTProcedimientos.setFont(new Font("Arial", 1, 12));
        this.JTProcedimientos.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTProcedimientos.setRowHeight(25);
        this.JTProcedimientos.setSelectionBackground(new Color(255, 255, 255));
        this.JTProcedimientos.setSelectionForeground(new Color(255, 0, 0));
        this.JTProcedimientos.setSelectionMode(0);
        this.JTProcedimientos.addMouseListener(new MouseAdapter() { // from class: Facturacion.JDConsolidadOrdenes.5
            public void mouseClicked(MouseEvent evt) {
                JDConsolidadOrdenes.this.JTProcedimientosMouseClicked(evt);
            }
        });
        this.JSPProcedimientos.setViewportView(this.JTProcedimientos);
        this.Datos.addTab("Procedimientos", this.JSPProcedimientos);
        this.JTSuministros.setFont(new Font("Arial", 1, 12));
        this.JTSuministros.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTSuministros.setRowHeight(25);
        this.JTSuministros.setSelectionBackground(Color.white);
        this.JTSuministros.setSelectionForeground(Color.red);
        this.JTSuministros.addMouseListener(new MouseAdapter() { // from class: Facturacion.JDConsolidadOrdenes.6
            public void mouseClicked(MouseEvent evt) {
                JDConsolidadOrdenes.this.JTSuministrosMouseClicked(evt);
            }
        });
        this.JSPSuministros.setViewportView(this.JTSuministros);
        this.Datos.addTab("Suministros", this.JSPSuministros);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.Datos, GroupLayout.Alignment.LEADING).addComponent(this.Panel, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.Titulo, GroupLayout.Alignment.LEADING, -2, 931, -2)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.Titulo, -2, 29, -2).addGap(18, 18, 18).addComponent(this.Datos, -2, 373, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.Panel, -2, -1, -2).addContainerGap(14, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnCerrarActionPerformed(ActionEvent evt) {
        salir();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTProcedimientosMouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTSuministrosMouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JYCAnoPropertyChange(PropertyChangeEvent evt) {
        if (this.xlleno) {
            cargarGridSum(this.frmFacturac.frmPersona.getIdPersona());
            cargarGridProc(this.frmFacturac.frmPersona.getIdPersona());
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
            int n = JOptionPane.showConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                if (this.Datos.getSelectedIndex() == 0) {
                    this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTProcedimientos, this.xmt.mTraerUrlBD(this.JTFRuta.getText()), getTitle() + ": " + this.Datos.getTitleAt(0).toUpperCase());
                    return;
                } else {
                    this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTSuministros, this.xmt.mTraerUrlBD(this.JTFRuta.getText()), getTitle() + ": " + this.Datos.getTitleAt(1).toUpperCase());
                    return;
                }
            }
            return;
        }
        JOptionPane.showMessageDialog(this, "Debe seleccionar un ruta valida", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JTFRuta.requestFocus();
    }

    private void salir() {
        dispose();
    }

    private void cargar() {
        if (this.Datos.getSelectedIndex() == 0) {
            if (this.JTProcedimientos.getSelectedRow() >= 0) {
                this.frmFacturac.frmOrdenes.cargar_Orden_Fact(this.JTProcedimientos.getValueAt(this.JTProcedimientos.getSelectedRow(), 0).toString(), 0);
                dispose();
                return;
            }
            return;
        }
        if (this.JTSuministros.getSelectedRow() >= 0) {
            this.frmFacturac.frmOrdenes.cargar_Orden_Fact(this.JTSuministros.getValueAt(this.JTSuministros.getSelectedRow(), 0).toString(), 1);
            dispose();
        }
    }

    public void cargarGridProc(String xidUsuario) {
        try {
            this.sql = "SELECT\n IFNULL(`c_clasecita`.`Nbre`, '') claseCita \n     , f_ordenes.Id\n     , f_ordenes.FechaOrden\n     , f_tiposervicio.Nbre\n     ,g_procedimiento.Id\n     , g_procedimiento.Nbre AS Procedimiento\n     , f_itemordenesproced.Cantidad,(((f_itemordenesproced.Cantidad*f_itemordenesproced.ValorUnitario)+f_itemordenesproced.valorImpuesto)-f_itemordenesproced.ValorDescuento) AS Valor\n     ,  IF(f_ordenes.Estado=0,'ACTIVO','ANULADO') AS Estado \n    , `f_tipofinprocedimiento`.`Nbre`\n    ,  `f_ordenes`.`Id_Ingreso`\nFROM\n    `baseserver`.`f_itemordenesproced`\n    INNER JOIN `baseserver`.`f_ordenes` \n        ON (`f_itemordenesproced`.`Id_Ordenes` = `f_ordenes`.`Id`)\n    INNER JOIN `baseserver`.`g_procedimiento` \n        ON (`f_itemordenesproced`.`Id_Procedimiento` = `g_procedimiento`.`Id`)\n    INNER JOIN `baseserver`.`f_tipofinprocedimiento` \n        ON (`f_itemordenesproced`.`Id_TipofinProc` = `f_tipofinprocedimiento`.`Id`)\n    INNER JOIN `baseserver`.`f_tiposervicio` \n        ON (`f_ordenes`.`Id_TipoServicio` = `f_tiposervicio`.`Id`)\n    INNER JOIN `baseserver`.`ingreso` \n        ON (`f_ordenes`.`Id_Ingreso` = `ingreso`.`Id`)\n    LEFT JOIN `baseserver`.`h_atencion` \n        ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\n    LEFT JOIN `baseserver`.`c_clasecita` \n        ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`)\n        WHERE (ingreso.`Id_Usuario` ='" + xidUsuario + "' AND  f_ordenes.Estado=0\n     AND DATE_FORMAT(f_ordenes.FechaOrden, '%Y')=  '" + this.JYCAno.getValue() + "')\n    ORDER BY f_ordenes.Id ASC;\n    ";
            crearGridProc();
            this.rs = this.consultas.traerRs(this.sql);
            if (this.rs.next()) {
                this.rs.beforeFirst();
                int x = 0;
                while (this.rs.next()) {
                    this.modeloproc.addRow(this.dato);
                    this.modeloproc.setValueAt(this.rs.getString(1), x, 0);
                    this.modeloproc.setValueAt(this.rs.getString(2), x, 1);
                    this.modeloproc.setValueAt(this.rs.getString(3), x, 2);
                    this.modeloproc.setValueAt(this.rs.getString(4), x, 3);
                    this.modeloproc.setValueAt(this.rs.getString(5), x, 4);
                    this.modeloproc.setValueAt(this.rs.getString(6), x, 5);
                    this.modeloproc.setValueAt(Integer.valueOf(this.rs.getInt(7)), x, 6);
                    this.modeloproc.setValueAt(Double.valueOf(this.rs.getDouble(8)), x, 7);
                    this.modeloproc.setValueAt(this.rs.getString(9), x, 8);
                    this.modeloproc.setValueAt(this.rs.getString(10), x, 9);
                    this.modeloproc.setValueAt(this.rs.getString(11), x, 10);
                    x++;
                }
            }
            this.rs.close();
            this.consultas.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JDConsolidadOrdenes.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void cargarGridSum(String xidUsuario) {
        try {
            this.sql = "SELECT `f_ordenes`.`Id_Ingreso`,f_ordenes.Id, f_ordenes.FechaOrden,f_tiposervicio.Nbre, i_suministro.Id, CONCAT(i_suministro.Nbre,' ',i_concentracion.Nbre,' ',i_presentacionfarmaceutica.Nbre,' ',i_laboratorio.Nbre) AS nombre, f_itemordenessum.Cantidad,(((f_itemordenessum.Cantidad*f_itemordenessum.ValorUnit)+f_itemordenessum.valorImpuesto)-f_itemordenessum.valorDesc) AS Valor, IF(f_ordenes.Estado=0,'ACTIVO','ANULADA') AS Estado \nFROM f_itemordenessum \nINNER JOIN f_ordenes  ON (f_itemordenessum.Id_Ordenes = f_ordenes.Id)\nINNER JOIN i_suministro ON (f_itemordenessum.Id_Suministro = i_suministro.Id) \nINNER JOIN f_tiposervicio  ON (f_ordenes.Id_TipoServicio = f_tiposervicio.Id) \nINNER JOIN i_presentacioncomercial  ON (i_suministro.IdPresentacionComercial = i_presentacioncomercial.Id) \nINNER JOIN i_presentacionfarmaceutica ON (i_suministro.IdPresentacionFarmaceutica = i_presentacionfarmaceutica.Id) \nINNER JOIN i_laboratorio ON (i_suministro.IdLaboratorio = i_laboratorio.Id) \nINNER JOIN i_concentracion ON (i_suministro.IdConcentracion = i_concentracion.Id) \nINNER JOIN ingreso ON (`f_ordenes`.`Id_Ingreso`=`ingreso`.`Id`)\nWHERE (ingreso.`Id_Usuario` ='" + xidUsuario + "' AND DATE_FORMAT(f_ordenes.FechaOrden, '%Y')= '" + this.JYCAno.getValue() + "')ORDER BY f_ordenes.FechaOrden ASC, f_ordenes.Id ASC ";
            crearGridSum();
            this.rs = this.consultas.traerRs(this.sql);
            if (this.rs.next()) {
                this.rs.beforeFirst();
                int x = 0;
                while (this.rs.next()) {
                    this.modelosum.addRow(this.dato);
                    this.modelosum.setValueAt(this.rs.getString(1), x, 0);
                    this.modelosum.setValueAt(this.rs.getString(2), x, 1);
                    this.modelosum.setValueAt(this.rs.getString(3), x, 2);
                    this.modelosum.setValueAt(this.rs.getString(4), x, 3);
                    this.modelosum.setValueAt(this.rs.getString(5), x, 4);
                    this.modelosum.setValueAt(this.rs.getString(6), x, 5);
                    this.modelosum.setValueAt(Integer.valueOf(this.rs.getInt(7)), x, 6);
                    this.modelosum.setValueAt(Double.valueOf(this.rs.getDouble(8)), x, 7);
                    this.modelosum.setValueAt(this.rs.getString(9), x, 8);
                    x++;
                }
            }
            this.rs.close();
            this.consultas.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JDConsolidadOrdenes.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearGridSum() {
        this.modelosum = new DefaultTableModel(new Object[0], new String[]{"Ingreso", "No Orden", "Fecha", "Servicio", "Codigo", "Suministro o Material", "Cant", "Valor", "Estado"}) { // from class: Facturacion.JDConsolidadOrdenes.7
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, Integer.class, Double.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTSuministros;
        JTable jTable2 = this.JTSuministros;
        jTable.setAutoResizeMode(0);
        this.JTSuministros.doLayout();
        this.JTSuministros.setModel(this.modelosum);
        this.JTSuministros.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTSuministros.getColumnModel().getColumn(1).setPreferredWidth(80);
        this.JTSuministros.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTSuministros.getColumnModel().getColumn(3).setPreferredWidth(200);
        this.JTSuministros.getColumnModel().getColumn(4).setPreferredWidth(80);
        this.JTSuministros.getColumnModel().getColumn(5).setPreferredWidth(300);
        this.JTSuministros.getColumnModel().getColumn(6).setPreferredWidth(50);
        this.JTSuministros.getColumnModel().getColumn(7).setPreferredWidth(100);
        this.JTSuministros.getColumnModel().getColumn(8).setPreferredWidth(50);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearGridProc() {
        this.modeloproc = new DefaultTableModel(new Object[0], new String[]{"Clase Cita", "No Orden", "Fecha", "Servicio", "Codigo", "Procedimiento", "Cantidad", "Valor", "Estado", "Finalidad", "Ingreso"}) { // from class: Facturacion.JDConsolidadOrdenes.8
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, Integer.class, Double.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTProcedimientos;
        JTable jTable2 = this.JTProcedimientos;
        jTable.setAutoResizeMode(0);
        this.JTProcedimientos.doLayout();
        this.JTProcedimientos.setModel(this.modeloproc);
        this.JTProcedimientos.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTProcedimientos.getColumnModel().getColumn(1).setPreferredWidth(80);
        this.JTProcedimientos.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTProcedimientos.getColumnModel().getColumn(3).setPreferredWidth(200);
        this.JTProcedimientos.getColumnModel().getColumn(4).setPreferredWidth(80);
        this.JTProcedimientos.getColumnModel().getColumn(5).setPreferredWidth(300);
        this.JTProcedimientos.getColumnModel().getColumn(6).setPreferredWidth(50);
        this.JTProcedimientos.getColumnModel().getColumn(7).setPreferredWidth(120);
        this.JTProcedimientos.getColumnModel().getColumn(8).setPreferredWidth(50);
        this.JTProcedimientos.getColumnModel().getColumn(9).setPreferredWidth(400);
        this.JTProcedimientos.getColumnModel().getColumn(10).setPreferredWidth(200);
    }
}
