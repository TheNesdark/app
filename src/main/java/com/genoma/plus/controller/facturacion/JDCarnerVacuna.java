package com.genoma.plus.controller.facturacion;

import Facturacion.Facturac;
import Facturacion.Facturac1;
import Facturacion.JDConsolidadOrdenes;
import Facturacion.Ordenes;
import Utilidades.ConsultasMySQL;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/facturacion/JDCarnerVacuna.class */
public class JDCarnerVacuna extends JDialog {
    private DefaultTableModel modelo;
    private String sql;
    private ConsultasMySQL consultas;
    private ResultSet rs;
    private Object[] dato;
    private Facturac frmfacturac;
    private Facturac1 frmfacturac1;
    private Ordenes frmOrden;
    private String idPaquete;
    private int fila;
    private JLabel Titulo;
    private JButton btnCerrar;
    private JButton btnOk;
    private JTable grid;
    private JPanel jPanel2;
    private JScrollPane jScrollPane2;

    public JDCarnerVacuna(Frame parent, boolean modal, Facturac frm, String id) {
        super(parent, modal);
        this.modelo = new DefaultTableModel();
        this.consultas = new ConsultasMySQL();
        this.fila = 0;
        initComponents();
        this.frmfacturac = frm;
        this.idPaquete = id;
        System.err.println("idpaciente" + this.frmfacturac.frmPersona.getIdPersona());
        nuevo();
        cargarGrid(this.frmfacturac.frmPersona.getIdPersona());
    }

    public JDCarnerVacuna(Frame parent, boolean modal, Facturac1 frm, String id) {
        super(parent, modal);
        this.modelo = new DefaultTableModel();
        this.consultas = new ConsultasMySQL();
        this.fila = 0;
        initComponents();
        this.frmfacturac1 = frm;
        this.idPaquete = id;
        System.err.println("idpaciente" + this.frmfacturac.frmPersona.getIdPersona());
        nuevo();
        cargarGrid(this.frmfacturac.frmPersona.getIdPersona());
    }

    /* JADX WARN: Type inference failed for: r3v4, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jPanel2 = new JPanel();
        this.jScrollPane2 = new JScrollPane();
        this.grid = new JTable();
        this.btnOk = new JButton();
        this.btnCerrar = new JButton();
        this.Titulo = new JLabel();
        setDefaultCloseOperation(2);
        setMinimumSize(new Dimension(548, 191));
        setResizable(false);
        this.jPanel2.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.grid.setFont(new Font("Arial", 1, 12));
        this.grid.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.jScrollPane2.setViewportView(this.grid);
        this.btnOk.setFont(new Font("Arial", 1, 12));
        this.btnOk.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.btnOk.setText("Cargar");
        this.btnOk.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.facturacion.JDCarnerVacuna.1
            public void actionPerformed(ActionEvent evt) {
                JDCarnerVacuna.this.btnOkActionPerformed(evt);
            }
        });
        this.btnCerrar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.btnCerrar.setText("Cerrar");
        this.btnCerrar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.facturacion.JDCarnerVacuna.2
            public void actionPerformed(ActionEvent evt) {
                JDCarnerVacuna.this.btnCerrarActionPerformed(evt);
            }
        });
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane2).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.btnOk, -2, 131, -2).addGap(18, 18, 18).addComponent(this.btnCerrar, -2, 110, -2))).addGap(5, 5, 5)));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGap(5, 5, 5).addComponent(this.jScrollPane2, -1, 369, 32767).addGap(5, 5, 5).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.btnCerrar, -2, 40, -2).addComponent(this.btnOk, -1, -1, 32767)).addGap(5, 5, 5)));
        this.Titulo.setBackground(new Color(0, 0, 153));
        this.Titulo.setFont(new Font("Tahoma", 1, 14));
        this.Titulo.setForeground(new Color(255, 255, 255));
        this.Titulo.setHorizontalAlignment(0);
        this.Titulo.setText("BUSQUEDA DE CARNET DE VACUNAS APLICADAS");
        this.Titulo.setOpaque(true);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(5, 5, 5).addComponent(this.jPanel2, -1, -1, 32767)).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addComponent(this.Titulo, -1, 785, 32767))).addGap(5, 5, 5)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(5, 5, 5).addComponent(this.Titulo, -2, 29, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel2, -1, -1, 32767).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnOkActionPerformed(ActionEvent evt) {
        entregarDatos();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnCerrarActionPerformed(ActionEvent evt) {
        salir();
    }

    private void salir() {
        dispose();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearGrid() {
        this.modelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Vacuna", "Dosis", "Edad", "Fecha", "Vacunador", "NOmbreS", "Cups", "Procedimiento", "Finproce"}) { // from class: com.genoma.plus.controller.facturacion.JDCarnerVacuna.3
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.grid.setModel(this.modelo);
        this.grid.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.grid.getColumnModel().getColumn(1).setPreferredWidth(250);
        this.grid.getColumnModel().getColumn(2).setPreferredWidth(50);
        this.grid.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.grid.getColumnModel().getColumn(4).setPreferredWidth(50);
        this.grid.getColumnModel().getColumn(5).setPreferredWidth(150);
        this.grid.getColumnModel().getColumn(6).setPreferredWidth(150);
        this.grid.getColumnModel().getColumn(7).setPreferredWidth(250);
        this.grid.getColumnModel().getColumn(8).setPreferredWidth(50);
        this.grid.getColumnModel().getColumn(9).setPreferredWidth(100);
        this.fila = 0;
    }

    public void cargarGrid(String xidUsuario) {
        try {
            String sql = "SELECT p_vacunacion_carnet.IdEsquema, p_vacunacion_vacunas.Nbre AS vacuna, p_vacunacion_dosis.Nbre AS dosis, p_vacunacion_edad.Nbre AS edad,     \n p_vacunacion_carnet.FechaVacuna, p_vacunacion_carnet.Vacunador ,f_tiposervicio.`Nbre` AS Servicio\n ,   g_procedimiento.`Id`, g_procedimiento.`Nbre`\n ,  CONCAT(f_tipofinprocedimiento.`Id`, '-',f_tipofinprocedimiento.`Nbre`) AS finProcedimiento   FROM `baseserver`.`p_vacunacion_esquema`\n    INNER JOIN `baseserver`.`p_vacunacion_dosis` \n        ON (`p_vacunacion_esquema`.`IdDosis` = `p_vacunacion_dosis`.`Id`)\n    INNER JOIN `baseserver`.`p_vacunacion_edad` \n        ON (`p_vacunacion_esquema`.`IdEdad` = `p_vacunacion_edad`.`Id`)\n    INNER JOIN `baseserver`.`p_vacunacion_carnet` \n        ON (`p_vacunacion_carnet`.`IdEsquema` = `p_vacunacion_esquema`.`Id`)\n    INNER JOIN `baseserver`.`p_vacunacion_vacunas` \n        ON (`p_vacunacion_esquema`.`IdVacuna` = `p_vacunacion_vacunas`.`Id`)\n    INNER JOIN `baseserver`.`g_procedimiento` \n        ON (`p_vacunacion_vacunas`.`Id_Procedimiento` = `g_procedimiento`.`Id`)\n    INNER JOIN `baseserver`.`f_procedimcentrocosto` \n        ON (`f_procedimcentrocosto`.`Id_Procedimiento` = `g_procedimiento`.`Id`)\n    INNER JOIN `baseserver`.`f_tipoprocedimiento` \n        ON (`g_procedimiento`.`Id_tipoprocedimiento` = `f_tipoprocedimiento`.`Id`)\n    INNER JOIN `baseserver`.`f_tiposervtipoproced` \n        ON (`f_tiposervtipoproced`.`Idtipoprocedimiento` = `f_tipoprocedimiento`.`Id`)\n    INNER JOIN `baseserver`.`f_tiposervicio` \n        ON (`f_tiposervtipoproced`.`Idtiposervicio` = `f_tiposervicio`.`Id`)\n    INNER JOIN `baseserver`.`f_tarifaprocedimiento` \n        ON (`f_tarifaprocedimiento`.`Id_Procedimiento` = `g_procedimiento`.`Id`)\n    INNER JOIN `baseserver`.`f_tipofinprocedimiento` \n        ON (`g_procedimiento`.`Id_TipoFinProced` = `f_tipofinprocedimiento`.`Id`)\n     WHERE (p_vacunacion_esquema.Estado=1 AND p_vacunacion_carnet.IdPaciente ='" + xidUsuario + "'\n      AND p_vacunacion_carnet.`IdIngreso`=0 AND `p_vacunacion_carnet`.`FechaVacuna`<>'')GROUP BY  p_vacunacion_carnet.`IdEsquema` \n      ORDER BY p_vacunacion_vacunas.Id ASC, p_vacunacion_dosis.Id ASC;";
            crearGrid();
            this.rs = this.consultas.traerRs(sql);
            if (this.rs.next()) {
                this.rs.beforeFirst();
                while (this.rs.next()) {
                    this.modelo.addRow(this.dato);
                    this.modelo.setValueAt(this.rs.getString("IdEsquema"), this.fila, 0);
                    this.modelo.setValueAt(this.rs.getString("vacuna"), this.fila, 1);
                    this.modelo.setValueAt(this.rs.getString("dosis"), this.fila, 2);
                    this.modelo.setValueAt(this.rs.getString("edad"), this.fila, 3);
                    this.modelo.setValueAt(this.rs.getString("FechaVacuna"), this.fila, 4);
                    this.modelo.setValueAt(this.rs.getString("Vacunador"), this.fila, 5);
                    this.modelo.setValueAt(this.rs.getString("Servicio"), this.fila, 6);
                    this.modelo.setValueAt(this.rs.getString("Id"), this.fila, 7);
                    this.modelo.setValueAt(this.rs.getString("Nbre"), this.fila, 8);
                    this.modelo.setValueAt(this.rs.getString("finProcedimiento"), this.fila, 9);
                    this.fila++;
                }
            }
            this.rs.close();
            this.consultas.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JDConsolidadOrdenes.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void nuevo() {
        crearGrid();
    }

    private void entregarDatos() {
        for (int f = 0; f < this.modelo.getRowCount(); f++) {
            System.err.println("linea6" + this.modelo.getValueAt(f, 6).toString());
            this.frmfacturac.frmOrdenes.cboServicio.setSelectedItem(this.modelo.getValueAt(f, 6).toString());
            System.err.println("linea7" + this.modelo.getValueAt(f, 7).toString());
            this.frmfacturac.frmOrdenes.txtCodigo.setText(this.modelo.getValueAt(f, 7).toString());
            System.err.println("linea8" + this.modelo.getValueAt(f, 8).toString());
            this.frmfacturac.frmOrdenes.cboProcedSuministro.setSelectedItem(this.modelo.getValueAt(f, 8).toString());
            System.err.println("linea9" + this.modelo.getValueAt(f, 9).toString());
            this.frmfacturac.frmOrdenes.cboFinProcedimiento.setSelectedItem(this.modelo.getValueAt(f, 9).toString());
            this.frmfacturac.frmOrdenes.bajarTabla("");
            dispose();
        }
    }
}
