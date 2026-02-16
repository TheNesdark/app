package Facturacion;

import Cirugia.JIF_Programacion_Cx;
import Historia.JPI_Cirugias1;
import ParametrizacionN.JIFGenericoDosCombox1Check;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.genoma.plus.controller.facturacion.JPI_FormularioAnexo3;
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
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Facturacion/BuscarProced.class */
public class BuscarProced extends JDialog {
    private Metodos metodos;
    private ConsultasMySQL consultas;
    private String sql;
    private String xnombre;
    private String idServicio;
    private DefaultTableModel modelo;
    private ResultSet rs;
    private Object[] dato;
    private int FilaGrid;
    private int tipo;
    private Ordenes frmOrdenes;
    private JInternalFrame xjif_objeto;
    private JPanel xjp_objeto;
    private JIF_Programacion_Cx jiffProgramacionCirugia;
    private String especialidad;
    private JIFGenericoDosCombox1Check frmGenerico;
    private JButton btnCerrar;
    private JTable grid;
    private JScrollPane jScrollPane1;
    private JTextField txtNbre;

    public BuscarProced(Frame parent, boolean modal, Ordenes frm, String xnombre) {
        super(parent, modal);
        this.metodos = new Metodos();
        this.consultas = new ConsultasMySQL();
        this.FilaGrid = 0;
        this.tipo = 0;
        initComponents();
        this.xnombre = xnombre;
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        this.frmOrdenes = frm;
        crearGrid();
        setLocationRelativeTo(this);
    }

    public BuscarProced(Frame parent, boolean modal, JInternalFrame frm, String xnombre) {
        super(parent, modal);
        this.metodos = new Metodos();
        this.consultas = new ConsultasMySQL();
        this.FilaGrid = 0;
        this.tipo = 0;
        initComponents();
        this.xjif_objeto = frm;
        this.xnombre = xnombre;
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        crearGrid();
        setLocationRelativeTo(this);
    }

    public BuscarProced(Frame parent, boolean modal, JPanel frm, String xnombre) {
        super(parent, modal);
        this.metodos = new Metodos();
        this.consultas = new ConsultasMySQL();
        this.FilaGrid = 0;
        this.tipo = 0;
        initComponents();
        this.xjp_objeto = frm;
        this.xnombre = xnombre;
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        crearGrid();
        setLocationRelativeTo(this);
    }

    public BuscarProced(Frame parent, boolean modal, JPanel frm, String xnombre, int tipo) {
        super(parent, modal);
        this.metodos = new Metodos();
        this.consultas = new ConsultasMySQL();
        this.FilaGrid = 0;
        this.tipo = 0;
        initComponents();
        this.xjp_objeto = frm;
        this.xnombre = xnombre;
        this.tipo = tipo;
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        crearGrid();
        setLocationRelativeTo(this);
    }

    public BuscarProced(Frame parent, boolean modal, JPanel frm, String xnombre, String idServicio) {
        super(parent, modal);
        this.metodos = new Metodos();
        this.consultas = new ConsultasMySQL();
        this.FilaGrid = 0;
        this.tipo = 0;
        initComponents();
        this.xjp_objeto = frm;
        this.xnombre = xnombre;
        this.idServicio = idServicio;
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        crearGrid();
        setLocationRelativeTo(this);
    }

    public BuscarProced(Frame parent, boolean modal, JInternalFrame frm, String xnombre, String especialidad) {
        super(parent, modal);
        this.metodos = new Metodos();
        this.consultas = new ConsultasMySQL();
        this.FilaGrid = 0;
        this.tipo = 0;
        initComponents();
        this.xjif_objeto = frm;
        this.xnombre = xnombre;
        this.especialidad = especialidad;
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        crearGrid();
        setLocationRelativeTo(this);
    }

    public BuscarProced(Frame parent, boolean modal, JIFGenericoDosCombox1Check frm, String xnombre) {
        super(parent, modal);
        this.metodos = new Metodos();
        this.consultas = new ConsultasMySQL();
        this.FilaGrid = 0;
        this.tipo = 0;
        initComponents();
        this.xnombre = xnombre;
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        this.frmGenerico = frm;
        crearGrid();
        setLocationRelativeTo(this);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearGrid() {
        this.modelo = new DefaultTableModel(new Object[0], new String[]{"Codigo", "Procedimiento", "Valor"}) { // from class: Facturacion.BuscarProced.1
            Class[] types = {String.class, String.class, Long.class};
            boolean[] canEdit = {false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.grid.setModel(this.modelo);
        this.grid.getColumnModel().getColumn(0).setPreferredWidth(30);
        this.grid.getColumnModel().getColumn(1).setPreferredWidth(450);
        this.grid.getColumnModel().getColumn(2).setPreferredWidth(50);
    }

    private void borrarFilas() {
        for (int i = 0; i < this.FilaGrid; i++) {
            this.modelo.removeRow(0);
        }
        this.FilaGrid = 0;
    }

    private void buscar(String IdEmpresaCont, String IdTipoServicio, String FiltroProcxEmp, String CualValor) {
        try {
            if (this.txtNbre.getText().length() != 0) {
                crearGrid();
                if (this.xnombre.equals("xjifautorizacion_servicios") || this.xnombre.equals("xjpi_formulaanexo3") || this.xnombre.equals("xjpi_formulaanexo3Res2335")) {
                    this.sql = "SELECT  `Id` , `Nbre`, 0 FROM `g_procedimiento` WHERE (`Nbre` like '%" + this.txtNbre.getText() + "%'   AND `Estado` =0)  ORDER BY g_procedimiento.Nbre ASC ";
                } else if (FiltroProcxEmp.equals("0")) {
                    this.sql = "SELECT g_procedimiento.Id, g_procedimiento.Nbre, IF(0=" + CualValor + ",f_tarifaprocedimiento.VrMinimo,f_tarifaprocedimiento.VrMaximo) AS Valor FROM  g_procedimiento INNER JOIN f_tipofinprocedimiento  ON (g_procedimiento.Id_TipoFinProced = f_tipofinprocedimiento.Id) INNER JOIN f_procedempresaconvenio  ON (f_procedempresaconvenio.Id_Procedimiento = g_procedimiento.Id) INNER JOIN f_empresacontxconvenio  ON (f_procedempresaconvenio.Id_EmpresacontxConv = f_empresacontxconvenio.Id) INNER JOIN f_tipoprocedimiento ON (g_procedimiento.Id_tipoprocedimiento = f_tipoprocedimiento.Id) INNER JOIN f_tiposervtipoproced  ON (f_tiposervtipoproced.Idtipoprocedimiento = f_tipoprocedimiento.Id) INNER JOIN f_tarifaprocedimiento ON (f_tarifaprocedimiento.Id_Procedimiento = g_procedimiento.Id) AND (f_empresacontxconvenio.Id_Manual = f_tarifaprocedimiento.Id_Manual) WHERE (f_procedempresaconvenio.Id_EmpresacontxConv ='" + IdEmpresaCont + "'  AND f_tiposervtipoproced.Idtiposervicio ='" + IdTipoServicio + "' AND  g_procedimiento.Estado =0 AND g_procedimiento.Nbre like '%" + this.txtNbre.getText() + "%')  ORDER BY g_procedimiento.Nbre ASC ";
                } else {
                    this.sql = "SELECT g_procedimiento.Id, g_procedimiento.Nbre,IF(0=" + CualValor + ",f_tarifaprocedimiento.VrMinimo,f_tarifaprocedimiento.VrMaximo) AS Valor FROM  g_procedimiento INNER JOIN f_tiposervtipoproced ON (g_procedimiento.Id_tipoprocedimiento = f_tiposervtipoproced.Idtipoprocedimiento) INNER JOIN f_tarifaprocedimiento ON (f_tarifaprocedimiento.Id_Procedimiento = g_procedimiento.Id) INNER JOIN f_empresacontxconvenio ON (f_empresacontxconvenio.Id_Manual = f_tarifaprocedimiento.Id_Manual) WHERE (f_empresacontxconvenio.Id=" + IdEmpresaCont + " AND f_tiposervtipoproced.Idtiposervicio ='" + IdTipoServicio + "' AND g_procedimiento.Estado =0 AND g_procedimiento.Nbre like '%" + this.txtNbre.getText() + "%') ORDER BY g_procedimiento.Nbre ASC ";
                }
                this.rs = this.consultas.traerRs(this.sql);
                if (this.rs.next()) {
                    int i = 0;
                    this.rs.beforeFirst();
                    while (this.rs.next()) {
                        this.modelo.addRow(this.dato);
                        this.modelo.setValueAt(this.rs.getString(1), i, 0);
                        this.modelo.setValueAt(this.rs.getString(2), i, 1);
                        this.modelo.setValueAt(this.rs.getString(3), i, 2);
                        i++;
                    }
                } else {
                    borrarFilas();
                }
                this.rs.close();
                this.consultas.cerrarConexionBd();
            }
        } catch (SQLException ex) {
            Logger.getLogger(BuscarProced.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mBuscar() {
        try {
            if (!this.txtNbre.getText().isEmpty()) {
                crearGrid();
                switch (this.xnombre) {
                    case "xjifautorizacion_servicios":
                    case "xjpi_formulaanexo3":
                    case "Procedimiento Tipo Finalidad":
                        this.sql = "SELECT  `C_Homologado` , `Nbre`, Id FROM `g_procedimiento` WHERE ((`Nbre` like '%" + this.txtNbre.getText() + "%' || `Id` like '%" + this.txtNbre.getText() + "%' || g_procedimiento.C_Homologado LIKE'%" + this.txtNbre.getText() + "%')  AND `Estado` =0)  ORDER BY g_procedimiento.Nbre ASC ";
                        break;
                    case "xjpi_formulaanexo3Res2335":
                        this.sql = "SELECT  `C_Homologado` , `Nbre`, 0 FROM `g_procedimiento` WHERE ((`Nbre` LIKE '%" + this.txtNbre.getText() + "%' || `Id` LIKE '%" + this.txtNbre.getText() + "%' || C_Homologado LIKE'%" + this.txtNbre.getText() + " %'  )  AND `Estado` =0)  ORDER BY g_procedimiento.Nbre ASC";
                        break;
                    case "xjp_intervencion_qx":
                        this.sql = "SELECT\ng_procedimiento.`C_Homologado` , g_procedimiento.`Nbre`, 0 \nFROM`g_procedimiento`\nINNER JOIN `f_tipoprocedimiento`ON ( `g_procedimiento`.`Id_tipoprocedimiento` = `f_tipoprocedimiento`.`Id` )\nINNER JOIN `f_tiposervtipoproced`ON ( `f_tiposervtipoproced`.`Idtipoprocedimiento` = `f_tipoprocedimiento`.`Id` )\nINNER JOIN `f_tiposervicio`ON ( `f_tiposervtipoproced`.`Idtiposervicio` = `f_tiposervicio`.`Id`    )\nWHERE ((g_procedimiento.`Nbre` LIKE '%" + this.txtNbre.getText() + "%' || g_procedimiento.`Id` LIKE '%" + this.txtNbre.getText() + "%' || g_procedimiento.C_Homologado LIKE'%" + this.txtNbre.getText() + "%'  ) \n AND g_procedimiento.`Estado` =0 AND f_tiposervicio.Id='" + this.idServicio + "')\nORDER BY `g_procedimiento`.`Nbre` ASC";
                        break;
                    case "cirugia":
                        this.sql = "SELECT `g_procedimiento`.`Id` ,CONCAT(`g_procedimiento`.`Id`,'-',`g_procedimiento`.`Nbre`) AS Nbre, `q_procedqxespec`.`Duracion` \nFROM  `q_procedqxespec` \nINNER JOIN    `g_procedimiento`  ON (`q_procedqxespec`.`Id_Procedimiento` = `g_procedimiento`.`Id`) \nINNER JOIN    `g_especialidad`  ON (`q_procedqxespec`.`Id_Especialidad` = `g_especialidad`.`Id`) \nWHERE ((`g_procedimiento`.`Nbre` LIKE '%" + this.txtNbre.getText() + "%' ||`g_procedimiento`.`Id` LIKE '%" + this.txtNbre.getText() + "%') AND`g_especialidad`.`Nbre` ='" + this.especialidad + "' AND q_procedqxespec.`Estado`=1) \nORDER BY `g_procedimiento`.`Nbre` ASC ";
                        break;
                }
                this.rs = this.consultas.traerRs(this.sql);
                if (this.rs.next()) {
                    int i = 0;
                    this.rs.beforeFirst();
                    while (this.rs.next()) {
                        this.modelo.addRow(this.dato);
                        this.modelo.setValueAt(this.rs.getString(1), i, 0);
                        this.modelo.setValueAt(this.rs.getString(2), i, 1);
                        this.modelo.setValueAt(this.rs.getString(3), i, 2);
                        i++;
                    }
                } else {
                    borrarFilas();
                }
                this.rs.close();
                this.consultas.cerrarConexionBd();
            }
        } catch (SQLException ex) {
            Logger.getLogger(BuscarProced.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX WARN: Type inference failed for: r3v3, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jScrollPane1 = new JScrollPane();
        this.grid = new JTable();
        this.txtNbre = new JTextField();
        this.btnCerrar = new JButton();
        setDefaultCloseOperation(2);
        this.jScrollPane1.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.grid.setFont(new Font("Arial", 1, 12));
        this.grid.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.grid.setRowHeight(25);
        this.grid.setSelectionBackground(new Color(255, 255, 255));
        this.grid.setSelectionForeground(new Color(255, 0, 0));
        this.grid.setSelectionMode(0);
        this.grid.addMouseListener(new MouseAdapter() { // from class: Facturacion.BuscarProced.2
            public void mouseClicked(MouseEvent evt) {
                BuscarProced.this.gridMouseClicked(evt);
            }
        });
        this.jScrollPane1.setViewportView(this.grid);
        this.txtNbre.setFont(new Font("Arial", 1, 12));
        this.txtNbre.setBorder(BorderFactory.createTitledBorder((Border) null, "Procedimiento", 1, 0, new Font("Arial", 1, 14), new Color(0, 0, 255)));
        this.txtNbre.addActionListener(new ActionListener() { // from class: Facturacion.BuscarProced.3
            public void actionPerformed(ActionEvent evt) {
                BuscarProced.this.txtNbreActionPerformed(evt);
            }
        });
        this.txtNbre.addKeyListener(new KeyAdapter() { // from class: Facturacion.BuscarProced.4
            public void keyPressed(KeyEvent evt) {
                BuscarProced.this.txtNbreKeyPressed(evt);
            }
        });
        this.btnCerrar.setFont(new Font("Arial", 1, 12));
        this.btnCerrar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.btnCerrar.setText("Cerrar");
        this.btnCerrar.addActionListener(new ActionListener() { // from class: Facturacion.BuscarProced.5
            public void actionPerformed(ActionEvent evt) {
                BuscarProced.this.btnCerrarActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jScrollPane1, GroupLayout.Alignment.LEADING, -1, 733, 32767).addComponent(this.txtNbre, GroupLayout.Alignment.LEADING, -1, 733, 32767).addComponent(this.btnCerrar, GroupLayout.Alignment.LEADING, -1, -1, 32767)).addGap(30, 30, 30)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(21, 21, 21).addComponent(this.txtNbre, -2, 54, -2).addGap(18, 18, 18).addComponent(this.jScrollPane1, -2, 214, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.btnCerrar, -2, 50, -2).addContainerGap(13, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnCerrarActionPerformed(ActionEvent evt) {
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtNbreActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtNbreKeyPressed(KeyEvent evt) {
        if (this.xnombre.equals("xjifautorizacion_servicios") || this.xnombre.equals("xjpi_formulaanexo3") || this.xnombre.equals("cirugia") || this.xnombre.equals("Procedimiento Tipo Finalidad") || this.xnombre.equals("xjpi_formulaanexo3Res2335") || this.xnombre.equals("xjp_intervencion_qx")) {
            mBuscar();
        } else {
            buscar(this.frmOrdenes.getidEmpresaCont(), this.frmOrdenes.getIdServicio(), this.frmOrdenes.getFiltroProcxEmp(), this.frmOrdenes.getCualValor());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gridMouseClicked(MouseEvent evt) {
        if (this.grid.getSelectedRow() != -1) {
            if (this.xnombre.equals("xjifautorizacion_servicios")) {
                JIFAutorizacion_Servicios xjif = (JIFAutorizacion_Servicios) this.xjif_objeto;
                xjif.JTF_Codigo.setText(this.modelo.getValueAt(this.grid.getSelectedRow(), 0).toString());
                xjif.JTF_NProcedimiento.setText(this.modelo.getValueAt(this.grid.getSelectedRow(), 1).toString());
            } else if (this.xnombre.equals("xjpi_formulaanexo3")) {
                JPI_FormularioAnexo3 xjp = (JPI_FormularioAnexo3) this.xjp_objeto;
                xjp.JTF_Codigo.setText(this.modelo.getValueAt(this.grid.getSelectedRow(), 0).toString());
                xjp.JTF_NProcedimiento.setText(this.modelo.getValueAt(this.grid.getSelectedRow(), 1).toString());
                xjp.idProcedimiento = Long.valueOf(this.modelo.getValueAt(this.grid.getSelectedRow(), 2).toString());
            } else if (this.xnombre.equals("cirugia")) {
                this.jiffProgramacionCirugia = (JIF_Programacion_Cx) this.xjif_objeto;
                this.jiffProgramacionCirugia.JCb_Procedimiento.setSelectedItem(this.modelo.getValueAt(this.grid.getSelectedRow(), 1).toString());
                this.jiffProgramacionCirugia.JTFF_Duracion.setText(this.modelo.getValueAt(this.grid.getSelectedRow(), 2).toString());
            } else if (this.xnombre.equals("Procedimiento Tipo Finalidad")) {
                this.frmGenerico.comboDos = this.modelo.getValueAt(this.grid.getSelectedRow(), 1).toString();
            } else if (this.xnombre.equals("xjpi_formulaanexo3Res2335")) {
                if (this.tipo == 1) {
                    JPI_FormularioAnexo3Res2335 xjp2 = (JPI_FormularioAnexo3Res2335) this.xjp_objeto;
                    xjp2.JTF_Codigo.setText(this.modelo.getValueAt(this.grid.getSelectedRow(), 0).toString());
                    xjp2.JTF_NProcedimiento.setText(this.modelo.getValueAt(this.grid.getSelectedRow(), 1).toString());
                } else {
                    JPI_FormularioAnexo3Res2335 xjp3 = (JPI_FormularioAnexo3Res2335) this.xjp_objeto;
                    xjp3.JTF_CodigoOtroProc.setText(this.modelo.getValueAt(this.grid.getSelectedRow(), 0).toString());
                    xjp3.JTF_NOtroProcedimiento.setText(this.modelo.getValueAt(this.grid.getSelectedRow(), 1).toString());
                }
            } else if (this.xnombre.equals("xjp_intervencion_qx")) {
                JPI_Cirugias1 xjcr = (JPI_Cirugias1) this.xjp_objeto;
                xjcr.JCB_IProcedimiento.setSelectedItem(this.modelo.getValueAt(this.grid.getSelectedRow(), 1).toString());
            } else {
                this.frmOrdenes.cboProcedSuministro.setSelectedItem(this.modelo.getValueAt(this.grid.getSelectedRow(), 1).toString());
                this.frmOrdenes.txtCantidad.requestFocus();
            }
            dispose();
        }
    }
}
