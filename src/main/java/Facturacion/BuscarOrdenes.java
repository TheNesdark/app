package Facturacion;

import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.LayoutManager;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Facturacion/BuscarOrdenes.class */
public class BuscarOrdenes extends JDialog {
    private String sql;
    private String xsql;
    private ConsultasMySQL consultas;
    private ResultSet rs;
    private Object[] dato;
    private Metodos metodos;
    private Facturac frmFacturac;
    private Facturac1 frmFacturac1;
    private DefaultTableModel modeloproc;
    private DefaultTableModel modelosum;
    private int FilaGrid;
    private int orden;
    private int procedimiento;
    private JTabbedPane Datos;
    private JPanel Panel;
    private JScrollPane SProc;
    private JScrollPane SSum;
    private JLabel Titulo;
    private JButton btnCerrar;
    private JButton btnOK;
    private JButton btnUpdate;
    private JTable gridProc;
    private JTable gridSum;

    public BuscarOrdenes(Frame parent, boolean modal, Facturac frm) {
        super(parent, modal);
        this.xsql = "";
        this.consultas = new ConsultasMySQL();
        this.FilaGrid = 0;
        this.orden = 0;
        this.procedimiento = 0;
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        this.frmFacturac = frm;
        this.metodos = new Metodos(false);
        setTitle("BUSQUEDA DE ORDENES POR INGRESO");
        crearGridSum();
        cargarGridSum(this.frmFacturac.frmIngreso.getIdIngreso());
        crearGridProc();
        cargarGridProc(this.frmFacturac.frmIngreso.getIdIngreso());
        setLocationRelativeTo(null);
    }

    public BuscarOrdenes(Frame parent, boolean modal, Facturac1 frm) {
        super(parent, modal);
        this.xsql = "";
        this.consultas = new ConsultasMySQL();
        this.FilaGrid = 0;
        this.orden = 0;
        this.procedimiento = 0;
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        this.frmFacturac1 = frm;
        this.metodos = new Metodos(false);
        setTitle("BUSQUEDA DE ORDENES POR INGRESO");
        crearGridSum();
        cargarGridSum(this.frmFacturac.frmIngreso.getIdIngreso());
        crearGridProc();
        cargarGridProc(this.frmFacturac.frmIngreso.getIdIngreso());
        setLocationRelativeTo(null);
    }

    /* JADX WARN: Type inference failed for: r4v16, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r4v21, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.Panel = new JPanel();
        this.btnCerrar = new JButton();
        this.btnOK = new JButton();
        this.btnUpdate = new JButton();
        this.Titulo = new JLabel();
        this.Datos = new JTabbedPane();
        this.SProc = new JScrollPane();
        this.gridProc = new JTable();
        this.SSum = new JScrollPane();
        this.gridSum = new JTable();
        setDefaultCloseOperation(2);
        setName("BuscarPersona");
        this.Panel.setBorder(BorderFactory.createEtchedBorder());
        this.Panel.setName("Panel");
        this.Panel.setLayout((LayoutManager) null);
        this.btnCerrar.setFont(new Font("Arial", 1, 12));
        this.btnCerrar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.btnCerrar.setText("Cerrar");
        this.btnCerrar.addActionListener(new ActionListener() { // from class: Facturacion.BuscarOrdenes.1
            public void actionPerformed(ActionEvent evt) {
                BuscarOrdenes.this.btnCerrarActionPerformed(evt);
            }
        });
        this.Panel.add(this.btnCerrar);
        this.btnCerrar.setBounds(800, 20, 110, 40);
        this.btnOK.setFont(new Font("Arial", 1, 12));
        this.btnOK.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.btnOK.setText("Cargar");
        this.btnOK.addActionListener(new ActionListener() { // from class: Facturacion.BuscarOrdenes.2
            public void actionPerformed(ActionEvent evt) {
                BuscarOrdenes.this.btnOKActionPerformed(evt);
            }
        });
        this.Panel.add(this.btnOK);
        this.btnOK.setBounds(400, 20, 140, 40);
        this.btnUpdate.setFont(new Font("Arial", 1, 12));
        this.btnUpdate.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.btnUpdate.setText("Actualiza Fecha Toma");
        this.btnUpdate.addActionListener(new ActionListener() { // from class: Facturacion.BuscarOrdenes.3
            public void actionPerformed(ActionEvent evt) {
                BuscarOrdenes.this.btnUpdateActionPerformed(evt);
            }
        });
        this.Panel.add(this.btnUpdate);
        this.btnUpdate.setBounds(560, 20, 220, 40);
        this.Titulo.setBackground(new Color(0, 0, 153));
        this.Titulo.setFont(new Font("Tahoma", 1, 14));
        this.Titulo.setForeground(new Color(255, 255, 255));
        this.Titulo.setHorizontalAlignment(0);
        this.Titulo.setText("BUSQUEDA DE ORDENES POR INGRESO");
        this.Titulo.setOpaque(true);
        this.Datos.setForeground(new Color(255, 0, 0));
        this.Datos.setFont(new Font("Arial", 1, 12));
        this.gridProc.setFont(new Font("Arial", 1, 12));
        this.gridProc.setModel(new DefaultTableModel(new Object[0], new String[]{"No Orden", "Fecha", "Servicio", "Codigo", "Procedimiento", "Cantidad", "Valor", "Estado"}) { // from class: Facturacion.BuscarOrdenes.4
            Class[] types = {String.class, String.class, String.class, String.class, String.class, Integer.class, Double.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        });
        this.gridProc.setSelectionBackground(new Color(255, 255, 255));
        this.gridProc.setSelectionForeground(new Color(255, 0, 0));
        this.gridProc.setSelectionMode(0);
        this.gridProc.addMouseListener(new MouseAdapter() { // from class: Facturacion.BuscarOrdenes.5
            public void mouseClicked(MouseEvent evt) {
                BuscarOrdenes.this.gridProcMouseClicked(evt);
            }
        });
        this.SProc.setViewportView(this.gridProc);
        this.Datos.addTab("Procedimientos", this.SProc);
        this.gridSum.setFont(new Font("Arial", 1, 12));
        this.gridSum.setModel(new DefaultTableModel(new Object[0], new String[]{"No Orden", "Fecha", "Servicio", "Codigo", "Suministro o Material", "Cant", "Valor", "Estado"}) { // from class: Facturacion.BuscarOrdenes.6
            Class[] types = {String.class, String.class, String.class, String.class, String.class, Integer.class, Long.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        });
        this.gridSum.addMouseListener(new MouseAdapter() { // from class: Facturacion.BuscarOrdenes.7
            public void mouseClicked(MouseEvent evt) {
                BuscarOrdenes.this.gridSumMouseClicked(evt);
            }
        });
        this.SSum.setViewportView(this.gridSum);
        this.Datos.addTab("Suministros", this.SSum);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.Datos, GroupLayout.Alignment.LEADING, -1, 931, 32767).addComponent(this.Titulo, GroupLayout.Alignment.LEADING, -1, 931, 32767).addComponent(this.Panel, GroupLayout.Alignment.LEADING, -1, 931, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.Titulo, -2, 29, -2).addGap(18, 18, 18).addComponent(this.Datos, -2, -1, -2).addGap(8, 8, 8).addComponent(this.Panel, -2, 65, -2).addContainerGap(-1, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnCerrarActionPerformed(ActionEvent evt) {
        salir();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnOKActionPerformed(ActionEvent evt) {
        cargar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gridProcMouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gridSumMouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnUpdateActionPerformed(ActionEvent evt) {
        int n = JOptionPane.showConfirmDialog(this, "Esta seguro de actualziar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            for (int x = 0; x < this.gridProc.getRowCount(); x++) {
                if (this.modeloproc.getValueAt(x, 8).equals(true)) {
                    this.orden = Integer.parseInt(this.modeloproc.getValueAt(x, 0).toString());
                    this.procedimiento = Integer.parseInt(this.modeloproc.getValueAt(x, 3).toString());
                    actualizaFechaToma(Integer.valueOf(this.orden), Integer.valueOf(this.procedimiento));
                }
            }
        }
    }

    private void salir() {
        dispose();
    }

    private void cargar() {
        if (this.Datos.getSelectedIndex() == 0) {
            if (this.gridProc.getSelectedRow() >= 0) {
                this.frmFacturac.frmOrdenes.cargar_Orden_Fact(this.gridProc.getValueAt(this.gridProc.getSelectedRow(), 0).toString(), 0);
                dispose();
                return;
            }
            return;
        }
        if (this.gridSum.getSelectedRow() >= 0) {
            this.frmFacturac.frmOrdenes.cargar_Orden_Fact(this.gridSum.getValueAt(this.gridSum.getSelectedRow(), 0).toString(), 1);
            dispose();
        }
    }

    public void cargarGridProc(String idIngreso) {
        try {
            this.sql = "SELECT f_ordenes.Id, f_ordenes.FechaOrden, f_tiposervicio.Nbre,g_procedimiento.Id, g_procedimiento.Nbre as Procedimiento, f_itemordenesproced.Cantidad,(((f_itemordenesproced.Cantidad*f_itemordenesproced.ValorUnitario)+f_itemordenesproced.valorImpuesto)-f_itemordenesproced.ValorDescuento) as Valor,  IF(f_ordenes.Estado=0,'ACTIVO','ANULADO') AS Estado FROM f_itemordenesproced INNER JOIN f_ordenes ON (f_itemordenesproced.Id_Ordenes = f_ordenes.Id) INNER JOIN f_tiposervicio ON (f_ordenes.Id_TipoServicio = f_tiposervicio.Id) INNER JOIN g_procedimiento ON (f_itemordenesproced.Id_Procedimiento = g_procedimiento.Id) WHERE (f_ordenes.Id_Ingreso =" + idIngreso + " AND  f_ordenes.Estado=0) ORDER BY f_ordenes.Id ASC ";
            this.rs = this.consultas.traerRs(this.sql);
            while (this.rs.next()) {
                this.modeloproc.addRow(this.dato);
                this.modeloproc.setValueAt(this.rs.getString(1), this.FilaGrid, 0);
                this.modeloproc.setValueAt(this.rs.getString(2), this.FilaGrid, 1);
                this.modeloproc.setValueAt(this.rs.getString(3), this.FilaGrid, 2);
                this.modeloproc.setValueAt(this.rs.getString(4), this.FilaGrid, 3);
                this.modeloproc.setValueAt(this.rs.getString(5), this.FilaGrid, 4);
                this.modeloproc.setValueAt(Integer.valueOf(this.rs.getInt(6)), this.FilaGrid, 5);
                this.modeloproc.setValueAt(Double.valueOf(this.rs.getDouble(7)), this.FilaGrid, 6);
                this.modeloproc.setValueAt(this.rs.getString(8), this.FilaGrid, 7);
                this.FilaGrid++;
            }
            this.rs.close();
            this.consultas.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(BuscarOrdenes.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void actualizaFechaToma(Integer orden, Integer procedimiento) {
        this.xsql = "update l_detallerecepcion,(select ld.Id_Recepcion , ld.Id_Procedim from l_recepcion lr inner join l_detallerecepcion ld  on (lr.Id=ld.Id_Recepcion) where lr.Id_OrdenFacturac =" + orden + " and ld.Id_Procedim =" + procedimiento + ") d set l_detallerecepcion.fechaMuestra ='" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "' where l_detallerecepcion.Id_Recepcion =d.Id_Recepcion and l_detallerecepcion.Id_Procedim =d.Id_Procedim";
        System.out.println("sql--> : " + this.xsql);
        this.consultas.ejecutarSQL(this.xsql);
        this.consultas.cerrarConexionBd();
    }

    public void cargarGridSum(String idIngreso) {
        try {
            this.sql = "SELECT f_ordenes.Id, f_ordenes.FechaOrden,f_tiposervicio.Nbre, i_suministro.Id, concat(i_suministro.Nbre,' ',i_concentracion.Nbre,' ',i_presentacionfarmaceutica.Nbre,' ',i_laboratorio.Nbre) as nombre, f_itemordenessum.Cantidad,(((f_itemordenessum.Cantidad*f_itemordenessum.ValorUnit)+f_itemordenessum.valorImpuesto)-f_itemordenessum.valorDesc) as Valor, IF(f_ordenes.Estado=0,'ACTIVO','ANULADA') as Estado FROM f_itemordenessum INNER JOIN f_ordenes  ON (f_itemordenessum.Id_Ordenes = f_ordenes.Id) INNER JOIN i_suministro ON (f_itemordenessum.Id_Suministro = i_suministro.Id) INNER JOIN f_tiposervicio  ON (f_ordenes.Id_TipoServicio = f_tiposervicio.Id) INNER JOIN i_presentacioncomercial  ON (i_suministro.IdPresentacionComercial = i_presentacioncomercial.Id) INNER JOIN i_presentacionfarmaceutica ON (i_suministro.IdPresentacionFarmaceutica = i_presentacionfarmaceutica.Id) INNER JOIN i_laboratorio ON (i_suministro.IdLaboratorio = i_laboratorio.Id) INNER JOIN i_concentracion ON (i_suministro.IdConcentracion = i_concentracion.Id) WHERE (f_ordenes.Id_Ingreso ='" + idIngreso + "')ORDER BY f_ordenes.FechaOrden ASC, f_ordenes.Id ASC ";
            this.rs = this.consultas.traerRs(this.sql);
            while (this.rs.next()) {
                this.modelosum.addRow(this.dato);
                this.modelosum.setValueAt(this.rs.getString(1), this.FilaGrid, 0);
                this.modelosum.setValueAt(this.rs.getString(2), this.FilaGrid, 1);
                this.modelosum.setValueAt(this.rs.getString(3), this.FilaGrid, 2);
                this.modelosum.setValueAt(this.rs.getString(4), this.FilaGrid, 3);
                this.modelosum.setValueAt(this.rs.getString(5), this.FilaGrid, 4);
                this.modelosum.setValueAt(Integer.valueOf(this.rs.getInt(6)), this.FilaGrid, 5);
                this.modelosum.setValueAt(Double.valueOf(this.rs.getDouble(7)), this.FilaGrid, 6);
                this.modelosum.setValueAt(this.rs.getString(8), this.FilaGrid, 7);
                this.FilaGrid++;
            }
            this.rs.close();
            this.consultas.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(BuscarOrdenes.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearGridSum() {
        this.modelosum = new DefaultTableModel(new Object[0], new String[]{"No Orden", "Fecha", "Servicio", "Codigo", "Suministro o Material", "Cant", "Valor", "Estado"}) { // from class: Facturacion.BuscarOrdenes.8
            Class[] types = {String.class, String.class, String.class, String.class, String.class, Integer.class, Double.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.gridSum.setModel(this.modelosum);
        this.gridSum.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.gridSum.getColumnModel().getColumn(1).setPreferredWidth(80);
        this.gridSum.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.gridSum.getColumnModel().getColumn(3).setPreferredWidth(20);
        this.gridSum.getColumnModel().getColumn(4).setPreferredWidth(300);
        this.gridSum.getColumnModel().getColumn(5).setPreferredWidth(20);
        this.gridSum.getColumnModel().getColumn(6).setPreferredWidth(30);
        this.gridSum.getColumnModel().getColumn(7).setPreferredWidth(30);
        this.FilaGrid = 0;
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearGridProc() {
        this.modeloproc = new DefaultTableModel(new Object[0], new String[]{"No Orden", "Fecha", "Servicio", "Codigo", "Procedimiento", "Cantidad", "Valor", "Estado", "Accion"}) { // from class: Facturacion.BuscarOrdenes.9
            Class[] types = {String.class, String.class, String.class, String.class, String.class, Integer.class, Double.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.gridProc.setModel(this.modeloproc);
        this.gridProc.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.gridProc.getColumnModel().getColumn(1).setPreferredWidth(80);
        this.gridProc.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.gridProc.getColumnModel().getColumn(3).setPreferredWidth(50);
        this.gridProc.getColumnModel().getColumn(4).setPreferredWidth(400);
        this.gridProc.getColumnModel().getColumn(5).setPreferredWidth(20);
        this.gridProc.getColumnModel().getColumn(6).setPreferredWidth(50);
        this.gridProc.getColumnModel().getColumn(7).setPreferredWidth(50);
        this.gridProc.getColumnModel().getColumn(8).setPreferredWidth(50);
        this.FilaGrid = 0;
    }
}
