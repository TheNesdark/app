package Facturacion;

import Salud_Ocupacional.JIFDeclaracionSalud;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Facturacion/BuscarIngreso.class */
public class BuscarIngreso extends JDialog {
    private Metodos metodos;
    private ConsultasMySQL consultas;
    private DefaultTableModel modelo;
    private String sql;
    private Facturac frmfacturac;
    private Facturac1 frmfacturac1;
    private int filaGrid;
    private String xFiltro;
    private JIFDeclaracionSalud frmDeclaracion;
    private ButtonGroup JBG_Filtro;
    private JPanel JPI_Filtro;
    private JRadioButton JRB_FActivos;
    private JRadioButton JRB_FAnulados;
    private JRadioButton JRB_FTodos;
    private JButton btnOk;
    private JButton btnSalir;
    private JTable grid;
    private JLabel jLabel1;
    private JScrollPane jScrollPane1;

    public BuscarIngreso(Frame parent, boolean modal, Facturac frm) {
        super(parent, modal);
        this.metodos = new Metodos();
        this.consultas = new ConsultasMySQL();
        this.xFiltro = "in(0)";
        this.frmDeclaracion = null;
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        setLocationRelativeTo(null);
        this.frmfacturac = frm;
        buscarIngreso(this.frmfacturac.frmPersona.getIdPersona());
        this.grid.addMouseListener(new MouseAdapter() { // from class: Facturacion.BuscarIngreso.1
            public void mouseClicked(MouseEvent e) {
                BuscarIngreso.this.filaGrid = BuscarIngreso.this.grid.rowAtPoint(e.getPoint());
            }
        });
    }

    public BuscarIngreso(Frame parent, boolean modal, Facturac1 frm) {
        super(parent, modal);
        this.metodos = new Metodos();
        this.consultas = new ConsultasMySQL();
        this.xFiltro = "in(0)";
        this.frmDeclaracion = null;
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        setLocationRelativeTo(null);
        this.frmfacturac1 = frm;
        buscarIngreso(this.frmfacturac.frmPersona.getIdPersona());
        this.grid.addMouseListener(new MouseAdapter() { // from class: Facturacion.BuscarIngreso.2
            public void mouseClicked(MouseEvent e) {
                BuscarIngreso.this.filaGrid = BuscarIngreso.this.grid.rowAtPoint(e.getPoint());
            }
        });
    }

    public BuscarIngreso(Frame parent, boolean modal, JIFDeclaracionSalud frm) {
        super(parent, modal);
        this.metodos = new Metodos();
        this.consultas = new ConsultasMySQL();
        this.xFiltro = "in(0)";
        this.frmDeclaracion = null;
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        setLocationRelativeTo(null);
        this.frmDeclaracion = frm;
        buscarIngreso(this.frmDeclaracion.frmPersona.getIdPersona());
        this.grid.addMouseListener(new MouseAdapter() { // from class: Facturacion.BuscarIngreso.3
            public void mouseClicked(MouseEvent e) {
                BuscarIngreso.this.filaGrid = BuscarIngreso.this.grid.rowAtPoint(e.getPoint());
            }
        });
    }

    private void buscarIngreso(String idUsuario) {
        this.sql = "SELECT\n  ingreso.Id,\n  DATE_FORMAT(ingreso.FechaIngreso,'%d/%m/%Y') AS Fecha,\n  DATE_FORMAT(ingreso.HoraIngreso, '%h:%i %p') AS Hora,\n  f_empresacontxconvenio.Nbre AS Empresa,\n  f_estrato.Nbre AS Estrato,\n  w_profesional.Especialidad AS Especialidad,\n  w_profesional.NProfesional AS Profesional,\n  g_tipoatencion.Nbre AS TipoAtencion,\n  g_sedes.`Nbre` AS Sede, if(ingreso.Estado=0, 'ACTIVO', 'ANULADO') Estado, ingreso.`SO_Cargo` as cargo, g_sedes.`Nbre` as sede \nFROM\n  ingreso\n  INNER JOIN f_empresacontxconvenio\n    ON (ingreso.Id_EmpresaContxConv = f_empresacontxconvenio.Id)\n  INNER JOIN f_estrato \n    ON (ingreso.Id_Estrato = f_estrato.Id)\n  INNER JOIN w_profesional\n    ON (w_profesional.Id_Persona = ingreso.Id_Profesional) AND (w_profesional.IdEspecialidad = ingreso.Id_Especialidad)\n  INNER JOIN g_tipoatencion\n    ON (ingreso.Id_TipoAtencion = g_tipoatencion.Id)\n  INNER JOIN g_sedes\n    ON (g_sedes.`Id` = ingreso.`Id_Sede`)\nWHERE (\n    ingreso.Id_Usuario = " + idUsuario + "\n    and  ingreso.Estado " + this.xFiltro + "  \n  )\nORDER BY FechaIngreso DESC,\n  HoraIngreso DESC";
        System.out.println("Carga ingreso -> " + this.sql);
        this.consultas.llenarTabla(this.sql, this.grid, this.modelo);
        this.consultas.cerrarConexionBd();
        this.grid.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.grid.getColumnModel().getColumn(1).setPreferredWidth(120);
        this.grid.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.grid.getColumnModel().getColumn(3).setPreferredWidth(300);
        this.grid.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.grid.getColumnModel().getColumn(5).setPreferredWidth(150);
        this.grid.getColumnModel().getColumn(6).setPreferredWidth(300);
        this.grid.getColumnModel().getColumn(7).setPreferredWidth(150);
        this.grid.getColumnModel().getColumn(8).setPreferredWidth(150);
        this.grid.getColumnModel().getColumn(9).setPreferredWidth(150);
        this.grid.getColumnModel().getColumn(10).setPreferredWidth(0);
        this.grid.getColumnModel().getColumn(11).setPreferredWidth(0);
    }

    private void cargar() {
        if (this.grid.getRowCount() > 0) {
            if (this.metodos.esIPSMineros() && this.frmDeclaracion != null) {
                this.frmDeclaracion.cargarConsentimiento(Integer.valueOf(Integer.parseInt(this.grid.getValueAt(this.filaGrid, 0).toString())), this.grid.getValueAt(this.filaGrid, 10).toString(), this.grid.getValueAt(this.filaGrid, 11).toString());
            } else {
                this.frmfacturac.frmIngreso.cargarIngreso(this.grid.getValueAt(this.filaGrid, 0).toString());
            }
            dispose();
        }
    }

    private void salir() {
        dispose();
    }

    /* JADX WARN: Type inference failed for: r3v2, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBG_Filtro = new ButtonGroup();
        this.jScrollPane1 = new JScrollPane();
        this.grid = new JTable();
        this.jLabel1 = new JLabel();
        this.btnOk = new JButton();
        this.btnSalir = new JButton();
        this.JPI_Filtro = new JPanel();
        this.JRB_FTodos = new JRadioButton();
        this.JRB_FActivos = new JRadioButton();
        this.JRB_FAnulados = new JRadioButton();
        setDefaultCloseOperation(2);
        this.grid.setFont(new Font("Arial", 1, 12));
        this.grid.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.grid.setAutoResizeMode(0);
        this.grid.setRowHeight(25);
        this.grid.setSelectionBackground(new Color(255, 255, 255));
        this.grid.setSelectionForeground(Color.red);
        this.grid.setSelectionMode(0);
        this.grid.addMouseListener(new MouseAdapter() { // from class: Facturacion.BuscarIngreso.4
            public void mouseClicked(MouseEvent evt) {
                BuscarIngreso.this.gridMouseClicked(evt);
            }
        });
        this.jScrollPane1.setViewportView(this.grid);
        this.jLabel1.setBackground(new Color(0, 0, 153));
        this.jLabel1.setFont(new Font("Arial", 1, 14));
        this.jLabel1.setForeground(new Color(255, 255, 255));
        this.jLabel1.setHorizontalAlignment(0);
        this.jLabel1.setText("BUSQUEDA DE INGRESOS");
        this.jLabel1.setOpaque(true);
        this.btnOk.setFont(new Font("Arial", 1, 12));
        this.btnOk.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.btnOk.setText("Cargar");
        this.btnOk.addActionListener(new ActionListener() { // from class: Facturacion.BuscarIngreso.5
            public void actionPerformed(ActionEvent evt) {
                BuscarIngreso.this.btnOkActionPerformed(evt);
            }
        });
        this.btnSalir.setFont(new Font("Arial", 1, 12));
        this.btnSalir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.btnSalir.setText("Salir");
        this.btnSalir.addActionListener(new ActionListener() { // from class: Facturacion.BuscarIngreso.6
            public void actionPerformed(ActionEvent evt) {
                BuscarIngreso.this.btnSalirActionPerformed(evt);
            }
        });
        this.JPI_Filtro.setBorder(BorderFactory.createTitledBorder((Border) null, "Filtro Estado", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JBG_Filtro.add(this.JRB_FTodos);
        this.JRB_FTodos.setFont(new Font("Arial", 1, 12));
        this.JRB_FTodos.setText("Todos");
        this.JRB_FTodos.addActionListener(new ActionListener() { // from class: Facturacion.BuscarIngreso.7
            public void actionPerformed(ActionEvent evt) {
                BuscarIngreso.this.JRB_FTodosActionPerformed(evt);
            }
        });
        this.JBG_Filtro.add(this.JRB_FActivos);
        this.JRB_FActivos.setFont(new Font("Arial", 1, 12));
        this.JRB_FActivos.setSelected(true);
        this.JRB_FActivos.setText("Activos");
        this.JRB_FActivos.addActionListener(new ActionListener() { // from class: Facturacion.BuscarIngreso.8
            public void actionPerformed(ActionEvent evt) {
                BuscarIngreso.this.JRB_FActivosActionPerformed(evt);
            }
        });
        this.JBG_Filtro.add(this.JRB_FAnulados);
        this.JRB_FAnulados.setFont(new Font("Arial", 1, 12));
        this.JRB_FAnulados.setText("Anulados");
        this.JRB_FAnulados.addActionListener(new ActionListener() { // from class: Facturacion.BuscarIngreso.9
            public void actionPerformed(ActionEvent evt) {
                BuscarIngreso.this.JRB_FAnuladosActionPerformed(evt);
            }
        });
        GroupLayout JPI_FiltroLayout = new GroupLayout(this.JPI_Filtro);
        this.JPI_Filtro.setLayout(JPI_FiltroLayout);
        JPI_FiltroLayout.setHorizontalGroup(JPI_FiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_FiltroLayout.createSequentialGroup().addComponent(this.JRB_FTodos).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRB_FActivos).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRB_FAnulados).addGap(0, 0, 32767)));
        JPI_FiltroLayout.setVerticalGroup(JPI_FiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_FiltroLayout.createSequentialGroup().addContainerGap().addGroup(JPI_FiltroLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRB_FTodos).addComponent(this.JRB_FActivos).addComponent(this.JRB_FAnulados)).addContainerGap(-1, 32767)));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jScrollPane1, -1, 886, 32767).addComponent(this.jLabel1, -1, -1, 32767).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGap(8, 8, 8).addComponent(this.JPI_Filtro, -1, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.btnOk, -2, 287, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.btnSalir, -2, 308, -2))).addContainerGap(-1, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jLabel1, -2, 29, -2).addGap(18, 18, 18).addComponent(this.jScrollPane1, -2, 262, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.btnOk, -2, 50, -2).addComponent(this.btnSalir, -2, 50, -2)).addComponent(this.JPI_Filtro, -2, -1, -2)).addGap(17, 17, 17)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnOkActionPerformed(ActionEvent evt) {
        cargar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnSalirActionPerformed(ActionEvent evt) {
        salir();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_FTodosActionPerformed(ActionEvent evt) {
        this.xFiltro = "in(0,1)";
        buscarIngreso(this.frmfacturac.frmPersona.getIdPersona());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_FActivosActionPerformed(ActionEvent evt) {
        this.xFiltro = "in(0)";
        buscarIngreso(this.frmfacturac.frmPersona.getIdPersona());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_FAnuladosActionPerformed(ActionEvent evt) {
        this.xFiltro = "in(1)";
        buscarIngreso(this.frmfacturac.frmPersona.getIdPersona());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gridMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            cargar();
        }
    }
}
