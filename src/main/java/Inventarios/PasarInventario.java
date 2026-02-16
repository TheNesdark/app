package Inventarios;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;

/* JADX INFO: loaded from: GenomaP.jar:Inventarios/PasarInventario.class */
public class PasarInventario extends JInternalFrame {
    private Metodos metodos = new Metodos();
    private ConsultasMySQL consultas = new ConsultasMySQL();
    private String[] listaBodega;
    private String sql;
    private ResultSet rs;
    private claseInventario claseInv;
    private JButton btnAceptar;
    private JButton btnSalir;
    private JComboBox cboBodega;
    private JEditorPane jEditorPane1;
    private JPanel jPanel1;
    private JScrollPane jScrollPane1;
    private JDateChooser txtFecha;

    public PasarInventario(claseInventario claseI) {
        initComponents();
        this.claseInv = claseI;
        llenarCombo();
        this.txtFecha.setDate(this.metodos.getFechaActual());
    }

    private void initComponents() {
        this.jPanel1 = new JPanel();
        this.jScrollPane1 = new JScrollPane();
        this.jEditorPane1 = new JEditorPane();
        this.btnAceptar = new JButton();
        this.btnSalir = new JButton();
        this.cboBodega = new JComboBox();
        this.txtFecha = new JDateChooser();
        setTitle("G@NOMA SOFT - MÓDULO DE INVENTARIO - PASO DE INVENTARIO");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("FIPasarInventario");
        this.jPanel1.setBorder(BorderFactory.createEtchedBorder());
        this.jPanel1.setLayout((LayoutManager) null);
        this.jEditorPane1.setEditable(false);
        this.jEditorPane1.setFont(new Font("Arial", 1, 12));
        this.jEditorPane1.setText("Este módulo le permite pasar los datos del Inventario actual a otras tablas de respaldo, además dejará los valores del Inventario actual sin Cantidad, sin Lote y sin Fecha de Vencimiento");
        this.jScrollPane1.setViewportView(this.jEditorPane1);
        this.jPanel1.add(this.jScrollPane1);
        this.jScrollPane1.setBounds(20, 110, 460, 80);
        this.btnAceptar.setFont(new Font("Arial", 1, 12));
        this.btnAceptar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.btnAceptar.setText("Aceptar");
        this.btnAceptar.addActionListener(new ActionListener() { // from class: Inventarios.PasarInventario.1
            public void actionPerformed(ActionEvent evt) {
                PasarInventario.this.btnAceptarActionPerformed(evt);
            }
        });
        this.jPanel1.add(this.btnAceptar);
        this.btnAceptar.setBounds(20, 210, 230, 40);
        this.btnSalir.setFont(new Font("Arial", 1, 12));
        this.btnSalir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.btnSalir.setText("Salir");
        this.btnSalir.addActionListener(new ActionListener() { // from class: Inventarios.PasarInventario.2
            public void actionPerformed(ActionEvent evt) {
                PasarInventario.this.btnSalirActionPerformed(evt);
            }
        });
        this.jPanel1.add(this.btnSalir);
        this.btnSalir.setBounds(270, 210, 210, 40);
        this.cboBodega.setFont(new Font("Arial", 1, 12));
        this.cboBodega.setBorder(BorderFactory.createTitledBorder((Border) null, "Bodega", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.jPanel1.add(this.cboBodega);
        this.cboBodega.setBounds(210, 58, 270, 40);
        this.txtFecha.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha del Inventario", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtFecha.setFont(new Font("Arial", 1, 12));
        this.jPanel1.add(this.txtFecha);
        this.txtFecha.setBounds(20, 48, 160, 50);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, 508, -2).addContainerGap(-1, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, 267, -2).addContainerGap(31, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnSalirActionPerformed(ActionEvent evt) {
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnAceptarActionPerformed(ActionEvent evt) {
        ejecutar();
    }

    private void ejecutar() {
        if (this.cboBodega.getSelectedIndex() < 0) {
            this.metodos.mostrarMensaje("Por favor seleccione una Bodega");
            this.cboBodega.requestFocus();
            return;
        }
        if (this.metodos.getPregunta("Esta seguro de Proceder?") == 0) {
            this.metodos = new Metodos();
            this.sql = "INSERT INTO i_inventario (Id_Bodega, Fecha_Inventario, Fecha, UsuarioS) VALUES ('" + this.claseInv.getIdBodega() + "','" + this.metodos.formatoAMD.format(this.txtFecha.getDate()) + "','" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
            this.consultas.ejecutarSQL(this.sql);
            this.consultas.cerrarConexionBd();
            this.sql = "SELECT Id FROM i_inventario WHERE (Id_Bodega ='" + this.claseInv.getIdBodega() + "' AND Fecha_Inventario ='" + this.metodos.formatoAMD.format(this.txtFecha.getDate()) + "')";
            String idInventario = this.consultas.traerDato(this.sql);
            this.sql = "SELECT i_suministroxbodega.Id, i_suministroxbodega.IdBodega, i_suministroxbodega.IdSuministro, i_suministroxbodega.Minimo, i_suministroxbodega.Maximo, i_suministroxbodega.Existencia, i_suministroxbodega.Costo, i_suministroxbodega.Fecha, i_suministroxbodega.UsuarioS, i_suministroxlotexbodega.Id, i_suministroxlotexbodega.Lote, i_suministroxlotexbodega.FechaVencimiento, i_suministroxlotexbodega.Cantidad FROM i_suministroxlotexbodega INNER JOIN i_suministroxbodega ON (i_suministroxlotexbodega.Id = i_suministroxbodega.Id) WHERE (i_suministroxbodega.IdBodega ='" + this.claseInv.getIdBodega() + "')";
            this.rs = this.consultas.traerRs(this.sql);
            this.consultas.cerrarConexionBd();
            String idAnterior = "";
            while (this.rs.next()) {
                try {
                    if (!idAnterior.equals(this.rs.getString(1))) {
                        this.sql = "INSERT INTO i_suministroxbodegainv (Id, Id_Inventario, IdSuministro, Minimo, Maximo, Existencia, Costo, Fecha, UsuarioS) VALUES ('" + this.rs.getString(1) + "','" + idInventario + "','" + this.rs.getString(3) + "','" + this.rs.getString(4) + "','" + this.rs.getString(5) + "','" + this.rs.getString(6) + "','" + this.rs.getString(7) + "','" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                        this.consultas.ejecutarSQL(this.sql);
                        this.consultas.cerrarConexionBd();
                    }
                    this.sql = "INSERT INTO i_suministroxlotexbodegainv (Id, Lote, FechaVencimiento, Cantidad) VALUES ('" + this.rs.getString(1) + "','" + this.rs.getString(11) + "','" + this.rs.getString(12) + "','" + this.rs.getString(13) + "')";
                    this.consultas.ejecutarSQL(this.sql);
                    this.consultas.cerrarConexionBd();
                    this.sql = "UPDATE i_suministroxlotexbodega SET  Lote = '', FechaVencimiento = '0000-00-00', Cantidad = 0 WHERE (Id = '" + this.rs.getString(1) + "')";
                    this.consultas.ejecutarSQL(this.sql);
                    this.consultas.cerrarConexionBd();
                    idAnterior = this.rs.getString(1);
                } catch (SQLException ex) {
                    this.consultas.mostrarErrorSQL(ex);
                    return;
                }
            }
            this.consultas.cerrarConexionBd();
            this.sql = "UPDATE i_suministroxbodega SET  Existencia = 0 WHERE (IdBodega = '" + this.claseInv.getIdBodega() + "')";
            this.consultas.ejecutarSQL(this.sql);
            this.rs.close();
            this.consultas.cerrarConexionBd();
        }
    }

    private void llenarCombo() {
        this.listaBodega = this.consultas.llenarCombo("SELECT Id, Nbre FROM i_bodegas ORDER BY Nbre ASC", this.listaBodega, this.cboBodega);
        this.consultas.cerrarConexionBd();
    }
}
