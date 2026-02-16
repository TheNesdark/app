package Inventarios;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;

/* JADX INFO: loaded from: GenomaP.jar:Inventarios/CerrarInventario.class */
public class CerrarInventario extends JInternalFrame {
    private String[][] listaBodega;
    private ResultSet rs;
    private String sql;
    private JComboBox cboBodega;
    private JEditorPane jEditorPane1;
    private JLabel jLabel2;
    private JPanel jPanel1;
    private JScrollPane jScrollPane1;
    private JSeparator jSeparator1;
    private JTextField txtFecha;
    private JTextField txtInventario;
    private JTextField txtProgreso;
    private Metodos metodos = new Metodos();
    private ConsultasMySQL consultas = new ConsultasMySQL();
    private int cboLleno = 0;

    public CerrarInventario() {
        initComponents();
        llenarCombo();
    }

    private int actualizarConteo2() {
        int op = 0;
        this.sql = "SELECT Conteo2 FROM i_suministroxlotexbodegainv WHERE Conteo2 > 0 AND Id_inventario ='" + this.txtInventario.getText() + "'";
        String dato = this.consultas.traerDato(this.sql);
        if (dato.isEmpty()) {
            this.sql = "UPDATE i_suministroxlotexbodegainv SET Conteo2 = Conteo1 WHERE Cantidad = Conteo1 and Id_inventario='" + this.txtInventario.getText() + "'";
            this.consultas.ejecutarSQL(this.sql);
            this.consultas.cerrarConexionBd();
            this.sql = "SELECT Conteo2 FROM i_suministroxlotexbodegainv WHERE Cantidad <> Conteo1 and Id_inventario='" + this.txtInventario.getText() + "'";
            String dato2 = this.consultas.traerDato(this.sql);
            if (!dato2.isEmpty()) {
                op = 1;
            }
            this.consultas.cerrarConexionBd();
        }
        return op;
    }

    private void actualizarInventario() {
        this.txtProgreso.setText("Actualizando la Información de Cierre del Inventario...");
        this.sql = "UPDATE i_inventario SET Fecha_Cierre ='" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "', Fecha ='" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "', UsuarioS ='" + Principal.usuarioSistemaDTO.getLogin() + "' WHERE (Id ='" + this.txtInventario.getText() + "')";
        this.consultas.ejecutarSQL(this.sql);
        this.consultas.cerrarConexionBd();
        this.txtProgreso.setText("Actualizando la Información de Cierre del Inventario terminada.");
    }

    private void actualizarSuministroxLotexBodega() {
        this.metodos = new Metodos();
        this.txtProgreso.setText("Actualizando los Lotes de cada Productos...");
        this.sql = "UPDATE i_suministroxlotexbodega, i_suministroxlotexbodegainv SET i_suministroxlotexbodega.Cantidad = i_suministroxlotexbodegainv.Conteo2  WHERE (i_suministroxlotexbodega.Id = i_suministroxlotexbodegainv.Id AND  i_suministroxlotexbodega.Lote = i_suministroxlotexbodegainv.Lote  AND  i_suministroxlotexbodegainv.Id_Inventario ='" + this.txtInventario.getText() + "')";
        this.consultas.ejecutarSQL(this.sql);
        this.consultas.cerrarConexionBd();
    }

    private void sumarLotes() {
        this.txtProgreso.setText("Actualizando el total sumado de los Lotes de cada Productos...");
        this.sql = "INSERT INTO i_suministroxbodegatmp (SELECT i_suministroxlotexbodegainv.Id AS IdSumnistroBodega,  SUM(i_suministroxlotexbodegainv.Conteo2)AS Cantidad  FROM  i_suministroxlotexbodegainv GROUP BY i_suministroxlotexbodegainv.Id)";
        this.consultas.ejecutarSQL(this.sql);
        this.consultas.cerrarConexionBd();
    }

    private void actualizarSuministroxBodega() {
        this.txtProgreso.setText("Actualizando las Cantidades de Cada Producto...");
        this.sql = "UPDATE i_suministroxbodega, i_suministroxbodegatmp SET i_suministroxbodega.Existencia = i_suministroxbodegatmp.Existencia WHERE (i_suministroxbodega.Id = i_suministroxbodegatmp.IdSuministroBodega AND i_suministroxbodega.IdBodega ='" + this.listaBodega[this.cboBodega.getSelectedIndex()][0] + "')";
        this.consultas.ejecutarSQL(this.sql);
        this.consultas.cerrarConexionBd();
    }

    private void limpiarTablaTmp() {
        this.txtProgreso.setText("Eliminando la información temporal de Cada Producto...");
        this.sql = "DELETE FROM i_suministroxbodegatmp";
        this.consultas.ejecutarSQL(this.sql);
        this.consultas.cerrarConexionBd();
    }

    public void grabar() {
        if (this.cboBodega.getSelectedIndex() < 0) {
            this.metodos.mostrarMensaje("Por favor seleccione una Bodega");
            this.cboBodega.requestFocus();
        } else if (this.metodos.getPregunta("Esta seguro de Realizar el Cierre del Inventario?") == 0) {
            actualizarInventario();
            this.txtProgreso.setText("Proceso Terminado");
            this.metodos.mostrarMensaje("Proceso Terminado");
        }
    }

    private void generarInforme() {
        String[][] parametros = new String[5][2];
        parametros[0][0] = "fecha";
        parametros[0][1] = this.txtFecha.getText();
        parametros[1][0] = "inventario";
        parametros[1][1] = this.txtInventario.getText();
        parametros[2][0] = "nbreBodega";
        parametros[2][1] = this.cboBodega.getSelectedItem().toString();
        parametros[3][0] = "SUBREPORT_DIR";
        parametros[3][1] = this.metodos.getSO() + this.metodos.getBarra() + "Reportes" + this.metodos.getBarra();
        parametros[4][0] = "SUBREPORTFIRMA_DIR";
        parametros[4][1] = this.metodos.getSO() + this.metodos.getBarra() + "Firmas" + this.metodos.getBarra();
        this.metodos.GenerarPDF(this.metodos.getRutaRep() + "I_DiferenciasEnInventario", parametros);
        this.consultas.cerrarConexionBd();
    }

    private void limpiarCantidadesEnBodegas() {
        this.txtProgreso.setText("Actualizando las Cantidades Por Lotes a Cero...");
        this.sql = "UPDATE i_suministroxbodega SET i_suministroxbodega.Existencia = 0 WHERE (i_suministroxbodega.IdBodega ='" + this.listaBodega[this.cboBodega.getSelectedIndex()][0] + "')";
        this.consultas.ejecutarSQL(this.sql);
        this.consultas.cerrarConexionBd();
    }

    private void limpiarCantidadesEnLotes() {
        this.txtProgreso.setText("Actualizando las Cantidades Por Lotes a Cero...");
        this.sql = "UPDATE i_suministroxlotexbodega, i_suministroxbodega SET  i_suministroxlotexbodega.Cantidad = 0 WHERE (i_suministroxbodega.Id = i_suministroxlotexbodega.Id AND  i_suministroxbodega.IdBodega ='" + this.listaBodega[this.cboBodega.getSelectedIndex()][0] + "')";
        this.consultas.ejecutarSQL(this.sql);
        this.consultas.cerrarConexionBd();
    }

    private void llenarCombo() {
        this.sql = "SELECT i_inventario.Id_Bodega, i_bodegas.Nbre, i_inventario.Id, i_inventario.Fecha_Inventario FROM i_bodegas INNER JOIN i_inventario ON (i_bodegas.Id = i_inventario.Id_Bodega) WHERE (i_inventario.Fecha_Cierre IS NULL) ORDER BY i_bodegas.Nbre ASC, i_inventario.Fecha_Inventario ASC";
        this.listaBodega = this.consultas.llenarComboyLista(this.sql, this.listaBodega, this.cboBodega, 4);
        this.consultas.cerrarConexionBd();
        this.cboBodega.setSelectedIndex(-1);
        this.cboLleno = 1;
    }

    public void nuevo() {
        this.cboBodega.setSelectedIndex(-1);
        this.txtFecha.setText("");
        this.txtInventario.setText("");
        this.txtProgreso.setText("");
    }

    private void initComponents() {
        this.jPanel1 = new JPanel();
        this.jScrollPane1 = new JScrollPane();
        this.jEditorPane1 = new JEditorPane();
        this.cboBodega = new JComboBox();
        this.jSeparator1 = new JSeparator();
        this.txtProgreso = new JTextField();
        this.txtInventario = new JTextField();
        this.txtFecha = new JTextField();
        this.jLabel2 = new JLabel();
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("CIERRE DE INVENTARIO ");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setMaximumSize(new Dimension(789, 350));
        setMinimumSize(new Dimension(789, 350));
        setName("CerrarInventario");
        setPreferredSize(new Dimension(789, 350));
        this.jPanel1.setBorder(BorderFactory.createEtchedBorder());
        this.jPanel1.setName("panel");
        this.jPanel1.setLayout((LayoutManager) null);
        this.jEditorPane1.setEditable(false);
        this.jEditorPane1.setBorder(BorderFactory.createEtchedBorder());
        this.jEditorPane1.setFont(new Font("Arial", 1, 14));
        this.jEditorPane1.setText("Este módulo le permite Cerrar el Inventario que se encuentra abierto. Pasará los valores reales de los Lotes existentes y el total por cada Producto sumando sus Lotes respectivos.");
        this.jEditorPane1.setDisabledTextColor(new Color(255, 0, 0));
        this.jEditorPane1.setEnabled(false);
        this.jScrollPane1.setViewportView(this.jEditorPane1);
        this.jPanel1.add(this.jScrollPane1);
        this.jScrollPane1.setBounds(20, 110, 690, 70);
        this.cboBodega.setFont(new Font("Arial", 1, 12));
        this.cboBodega.setBorder(BorderFactory.createTitledBorder((Border) null, "Bodega", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.cboBodega.addItemListener(new ItemListener() { // from class: Inventarios.CerrarInventario.1
            public void itemStateChanged(ItemEvent evt) {
                CerrarInventario.this.cboBodegaItemStateChanged(evt);
            }
        });
        this.jPanel1.add(this.cboBodega);
        this.cboBodega.setBounds(20, 38, 270, 60);
        this.jPanel1.add(this.jSeparator1);
        this.jSeparator1.setBounds(20, 232, 690, 20);
        this.txtProgreso.setFont(new Font("Arial", 1, 12));
        this.jPanel1.add(this.txtProgreso);
        this.txtProgreso.setBounds(20, 190, 690, 30);
        this.txtInventario.setBackground(new Color(0, 0, 153));
        this.txtInventario.setFont(new Font("Arial", 1, 20));
        this.txtInventario.setForeground(new Color(255, 255, 255));
        this.txtInventario.setHorizontalAlignment(0);
        this.txtInventario.setBorder(BorderFactory.createTitledBorder((Border) null, "No. Inventario", 0, 0, new Font("Tahoma", 0, 14), new Color(255, 255, 255)));
        this.txtInventario.setDisabledTextColor(new Color(255, 255, 255));
        this.txtInventario.setEnabled(false);
        this.jPanel1.add(this.txtInventario);
        this.txtInventario.setBounds(480, 30, 230, 70);
        this.txtFecha.setFont(new Font("Arial", 1, 12));
        this.txtFecha.setForeground(new Color(0, 0, 102));
        this.txtFecha.setHorizontalAlignment(0);
        this.txtFecha.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtFecha.setDisabledTextColor(new Color(0, 0, 102));
        this.txtFecha.setEnabled(false);
        this.jPanel1.add(this.txtFecha);
        this.txtFecha.setBounds(320, 40, 140, 50);
        this.jLabel2.setBackground((Color) null);
        this.jLabel2.setFont(new Font("Arial", 1, 14));
        this.jLabel2.setForeground(new Color(0, 102, 0));
        this.jLabel2.setHorizontalAlignment(0);
        this.jLabel2.setText("CIERRE DE INVENTARIO");
        this.jLabel2.setOpaque(true);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel2, -1, 779, 32767).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, 750, -2).addContainerGap(13, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.jLabel2, -1, 39, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel1, -2, 260, -2).addGap(16, 16, 16)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cboBodegaItemStateChanged(ItemEvent evt) {
        if (this.cboLleno == 1 && this.cboBodega.getSelectedIndex() > -1) {
            this.txtFecha.setText(this.listaBodega[this.cboBodega.getSelectedIndex()][2]);
            this.txtInventario.setText(this.listaBodega[this.cboBodega.getSelectedIndex()][1]);
        }
    }
}
