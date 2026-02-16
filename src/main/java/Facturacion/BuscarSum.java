package Facturacion;

import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.genoma.plus.controller.facturacion.JPI_FormularioAnexo3Res2335;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Facturacion/BuscarSum.class */
public class BuscarSum extends JDialog {
    private Metodos metodos;
    private ConsultasMySQL consultas;
    private String sql;
    private String nombrePanel;
    private DefaultTableModel modelo;
    private ResultSet rs;
    private Object[] dato;
    private int FilaGrid;
    private int tipo;
    private Ordenes frmOrdenes;
    private JPI_FormularioAnexo3Res2335 jpanel;
    private JPanel JPITipoProducto;
    private JButton btnCerrar;
    private JRadioButton btnComercial;
    private JRadioButton btnGenerico;
    private ButtonGroup btnGrupo;
    private JTable grid;
    private JScrollPane jScrollPane1;
    private JTextField txtNbre;

    public BuscarSum(Frame parent, boolean modal, Ordenes frm) {
        super(parent, modal);
        this.metodos = new Metodos();
        this.consultas = new ConsultasMySQL();
        this.nombrePanel = "";
        this.FilaGrid = 0;
        this.tipo = 0;
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        setLocationRelativeTo(this);
        this.frmOrdenes = frm;
        crearGrid();
    }

    public BuscarSum(Frame parent, boolean modal, JPI_FormularioAnexo3Res2335 jPanel, String xnombre) {
        super(parent, modal);
        this.metodos = new Metodos();
        this.consultas = new ConsultasMySQL();
        this.nombrePanel = "";
        this.FilaGrid = 0;
        this.tipo = 0;
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        setLocationRelativeTo(this);
        this.jpanel = jPanel;
        this.nombrePanel = xnombre;
        crearGridAnexo1();
    }

    private void crearGrid() {
        this.modelo = new DefaultTableModel() { // from class: Facturacion.BuscarSum.1
            Class[] types = {String.class, String.class, String.class, Long.class, String.class, String.class, String.class};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        this.modelo.addColumn("Codigo");
        this.modelo.addColumn("Genérico");
        this.modelo.addColumn("Comercial");
        this.modelo.addColumn("Valor");
        this.modelo.addColumn("Es Material");
        this.modelo.addColumn("Tipo");
        this.modelo.addColumn("Tipo Producto");
        this.modelo.addRow(this.dato);
        this.grid.setModel(this.modelo);
        this.grid.getColumnModel().getColumn(0).setPreferredWidth(30);
        this.grid.getColumnModel().getColumn(1).setPreferredWidth(300);
        this.grid.getColumnModel().getColumn(2).setPreferredWidth(300);
        this.grid.getColumnModel().getColumn(3).setPreferredWidth(50);
        this.grid.getColumnModel().getColumn(4).setPreferredWidth(20);
        this.grid.getColumnModel().getColumn(5).setPreferredWidth(50);
        this.grid.getColumnModel().getColumn(6).setPreferredWidth(50);
    }

    private void crearGridAnexo1() {
        this.modelo = new DefaultTableModel() { // from class: Facturacion.BuscarSum.2
            Class[] types = {String.class, String.class, String.class, Long.class};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        this.modelo.addColumn("Codigo");
        this.modelo.addColumn("Nombre");
        this.modelo.addColumn("Comercial");
        this.modelo.addRow(this.dato);
        this.grid.setModel(this.modelo);
        this.grid.getColumnModel().getColumn(0).setPreferredWidth(30);
        this.grid.getColumnModel().getColumn(1).setPreferredWidth(300);
        this.grid.getColumnModel().getColumn(2).setPreferredWidth(300);
    }

    private void borrarFilas() {
        for (int i = 0; i < this.FilaGrid; i++) {
            this.modelo.removeRow(0);
        }
        this.FilaGrid = 0;
    }

    private void buscar(String IdEmpresaCont) {
        try {
            if (this.txtNbre.getText().length() != 0) {
                crearGrid();
                this.sql = "SELECT i_suministro.Id, i_principioactivo.Nbre,CONCAT(i_suministro.Nbre,' ',i_concentracion.Nbre,' ',i_presentacionfarmaceutica.Nbre,' ', i_laboratorio.Nbre) AS Suministro, ROUND(f_tarifasuministro.Valor) AS Valor, IF(i_suministro.EsMaterial=0,'NO','SI') AS Es_Material, IF(i_suministro.Pos=1,'POS','NO POS') AS Tipo, i_tipoproducto.Nbre AS Tipo_Producto FROM i_suministro INNER JOIN i_concentracion ON (i_suministro.IdConcentracion = i_concentracion.Id) INNER JOIN i_presentacionfarmaceutica ON (i_suministro.IdPresentacionFarmaceutica = i_presentacionfarmaceutica.Id) INNER JOIN i_laboratorio  ON (i_suministro.IdLaboratorio = i_laboratorio.Id) INNER JOIN f_tarifasuministro ON (f_tarifasuministro.Id_suministro = i_suministro.Id) INNER JOIN i_tipoproducto ON (i_suministro.IdTipoProducto = i_tipoproducto.Id) INNER JOIN f_empresacontxconvenio ON (f_tarifasuministro.Id_manual = f_empresacontxconvenio.Id_Manual) INNER JOIN i_principioactivo ON (i_principioactivo.Id = i_suministro.IdPrincipioActivo) WHERE (i_suministro.EstaActivo =1 AND f_empresacontxconvenio.Id =" + IdEmpresaCont + " AND IF(" + this.tipo + "=0, i_principioactivo.Nbre LIKE '%" + this.txtNbre.getText() + "%',CONCAT(i_suministro.Nbre,' ',i_concentracion.Nbre,' ',i_presentacionfarmaceutica.Nbre,' ', i_laboratorio.Nbre) LIKE '%" + this.txtNbre.getText() + "%') ) order by Suministro";
                this.rs = this.consultas.traerRs(this.sql);
                if (this.rs.next()) {
                    int i = 0;
                    this.rs.beforeFirst();
                    while (this.rs.next()) {
                        this.modelo.setValueAt(this.rs.getString(1), i, 0);
                        this.modelo.setValueAt(this.rs.getString(2), i, 1);
                        this.modelo.setValueAt(this.rs.getString(3), i, 2);
                        this.modelo.setValueAt(this.rs.getString(4), i, 3);
                        this.modelo.setValueAt(this.rs.getString(5), i, 4);
                        this.modelo.setValueAt(this.rs.getString(6), i, 5);
                        this.modelo.setValueAt(this.rs.getString(7), i, 6);
                        this.modelo.addRow(this.dato);
                        i++;
                    }
                } else {
                    borrarFilas();
                }
                this.rs.close();
                this.consultas.cerrarConexionBd();
            }
        } catch (SQLException ex) {
            Logger.getLogger(BuscarSum.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void buscarAnexo1() {
        try {
            if (this.txtNbre.getText().length() != 0) {
                crearGridAnexo1();
                this.sql = "SELECT\n  IF(i_suministro.`CodigoCUM`='',i_suministro.`codigoIUM`,i_suministro.CodigoCUM) Codigo,\n  i_principioactivo.Nbre,\n  CONCAT(    i_suministro.Nbre,  ' ',  i_concentracion.Nbre,  ' ',   i_presentacionfarmaceutica.Nbre,   ' ',  i_laboratorio.Nbre  ) AS Suministro\nFROM\n  i_suministro\n  INNER JOIN i_concentracion  ON (      i_suministro.IdConcentracion = i_concentracion.Id    )\n  INNER JOIN i_presentacionfarmaceutica  ON (      i_suministro.IdPresentacionFarmaceutica = i_presentacionfarmaceutica.Id    )\n  INNER JOIN i_laboratorio  ON (    i_suministro.IdLaboratorio = i_laboratorio.Id    )\n  INNER JOIN f_tarifasuministro    ON (  f_tarifasuministro.Id_suministro = i_suministro.Id  )\n  INNER JOIN i_tipoproducto  ON ( i_suministro.IdTipoProducto = i_tipoproducto.Id )\n  INNER JOIN i_principioactivo  ON (i_principioactivo.Id = i_suministro.IdPrincipioActivo   ) \n WHERE ( i_suministro.EstaActivo = 1      and i_suministro.`EsMaterial` = 1                 \n    AND IF(  " + this.tipo + "  = 0, i_principioactivo.Nbre LIKE '%" + this.txtNbre.getText() + "%', CONCAT( i_suministro.Nbre, ' ',i_concentracion.Nbre, ' ', i_presentacionfarmaceutica.Nbre,  ' ', i_laboratorio.Nbre) LIKE '%" + this.txtNbre.getText() + "%'\n    )\n  )\n  GROUP BY i_suministro.`Id`\nORDER BY Suministro ";
                System.out.println(this.sql);
                this.rs = this.consultas.traerRs(this.sql);
                if (this.rs.next()) {
                    int i = 0;
                    this.rs.beforeFirst();
                    while (this.rs.next()) {
                        this.modelo.setValueAt(this.rs.getString(1), i, 0);
                        this.modelo.setValueAt(this.rs.getString(2), i, 1);
                        this.modelo.setValueAt(this.rs.getString(3), i, 2);
                        this.modelo.addRow(this.dato);
                        i++;
                    }
                } else {
                    borrarFilas();
                }
                this.rs.close();
                this.consultas.cerrarConexionBd();
            }
        } catch (SQLException ex) {
            Logger.getLogger(BuscarSum.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX WARN: Type inference failed for: r3v3, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.btnGrupo = new ButtonGroup();
        this.jScrollPane1 = new JScrollPane();
        this.grid = new JTable();
        this.txtNbre = new JTextField();
        this.btnCerrar = new JButton();
        this.JPITipoProducto = new JPanel();
        this.btnGenerico = new JRadioButton();
        this.btnComercial = new JRadioButton();
        setDefaultCloseOperation(2);
        this.jScrollPane1.setBorder(BorderFactory.createTitledBorder((Border) null, "Detalle", 2, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.grid.setFont(new Font("Arial", 1, 12));
        this.grid.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.grid.setSelectionBackground(new Color(255, 255, 255));
        this.grid.setSelectionForeground(new Color(255, 0, 0));
        this.grid.setSelectionMode(0);
        this.grid.addMouseListener(new MouseAdapter() { // from class: Facturacion.BuscarSum.3
            public void mouseClicked(MouseEvent evt) {
                BuscarSum.this.gridMouseClicked(evt);
            }
        });
        this.jScrollPane1.setViewportView(this.grid);
        this.txtNbre.setFont(new Font("Arial", 1, 12));
        this.txtNbre.setBorder(BorderFactory.createTitledBorder((Border) null, "Suministro", 2, 0, new Font("Arial", 1, 14), new Color(0, 0, 255)));
        this.txtNbre.addKeyListener(new KeyAdapter() { // from class: Facturacion.BuscarSum.4
            public void keyPressed(KeyEvent evt) {
                BuscarSum.this.txtNbreKeyPressed(evt);
            }
        });
        this.btnCerrar.setFont(new Font("Arial", 1, 12));
        this.btnCerrar.setForeground(new Color(0, 0, 153));
        this.btnCerrar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.btnCerrar.setText("Cerrar");
        this.btnCerrar.addActionListener(new ActionListener() { // from class: Facturacion.BuscarSum.5
            public void actionPerformed(ActionEvent evt) {
                BuscarSum.this.btnCerrarActionPerformed(evt);
            }
        });
        this.JPITipoProducto.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.btnGrupo.add(this.btnGenerico);
        this.btnGenerico.setFont(new Font("Arial", 1, 12));
        this.btnGenerico.setSelected(true);
        this.btnGenerico.setText("P.Activo");
        this.btnGenerico.addActionListener(new ActionListener() { // from class: Facturacion.BuscarSum.6
            public void actionPerformed(ActionEvent evt) {
                BuscarSum.this.btnGenericoActionPerformed(evt);
            }
        });
        this.btnGrupo.add(this.btnComercial);
        this.btnComercial.setFont(new Font("Arial", 1, 12));
        this.btnComercial.setText("N.Comercial");
        this.btnComercial.addActionListener(new ActionListener() { // from class: Facturacion.BuscarSum.7
            public void actionPerformed(ActionEvent evt) {
                BuscarSum.this.btnComercialActionPerformed(evt);
            }
        });
        GroupLayout JPITipoProductoLayout = new GroupLayout(this.JPITipoProducto);
        this.JPITipoProducto.setLayout(JPITipoProductoLayout);
        JPITipoProductoLayout.setHorizontalGroup(JPITipoProductoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPITipoProductoLayout.createSequentialGroup().addComponent(this.btnGenerico).addGap(10, 10, 10).addComponent(this.btnComercial)));
        JPITipoProductoLayout.setVerticalGroup(JPITipoProductoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPITipoProductoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.btnGenerico).addComponent(this.btnComercial)));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(30, 30, 30).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.txtNbre, -2, 796, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPITipoProducto, -2, -1, -2)).addComponent(this.jScrollPane1, -2, 1005, -2).addComponent(this.btnCerrar, GroupLayout.Alignment.TRAILING, -2, 116, -2)).addGap(28, 28, 28)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(34, 34, 34).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JPITipoProducto, -2, -1, -2).addComponent(this.txtNbre, -2, 54, -2)).addGap(18, 18, 18).addComponent(this.jScrollPane1, -2, 276, -2).addGap(18, 18, 18).addComponent(this.btnCerrar).addContainerGap(34, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnCerrarActionPerformed(ActionEvent evt) {
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtNbreKeyPressed(KeyEvent evt) {
        if (this.nombrePanel.equals("xjpi_formulaanexo3Res2335")) {
            buscarAnexo1();
        } else {
            buscar(this.frmOrdenes.getidEmpresaCont());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gridMouseClicked(MouseEvent evt) {
        if (this.nombrePanel.equals("xjpi_formulaanexo3Res2335")) {
            if (this.modelo.getRowCount() > 0) {
                System.err.println("13");
                System.err.println("this.modelo.getValueAt(this.grid.getSelectedRow(), 0).toString()" + this.modelo.getValueAt(this.grid.getSelectedRow(), 0).toString());
                this.jpanel.JTF_CodigoSuministro.setText(this.modelo.getValueAt(this.grid.getSelectedRow(), 0).toString());
            }
        } else if (this.modelo.getRowCount() > 0) {
            System.err.println("12");
            this.frmOrdenes.cboProcedSuministro.setSelectedItem(this.modelo.getValueAt(this.grid.getSelectedRow(), 2).toString());
            this.frmOrdenes.txtCantidad.requestFocus();
        }
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnGenericoActionPerformed(ActionEvent evt) {
        this.tipo = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnComercialActionPerformed(ActionEvent evt) {
        this.tipo = 1;
    }
}
