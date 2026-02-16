package Inventarios;

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
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;

/* JADX INFO: loaded from: GenomaP.jar:Inventarios/ImprimirInventario.class */
public class ImprimirInventario extends JInternalFrame {
    private String[][] listaBodega;
    private ResultSet rs;
    private String sql;
    private JCheckBox btnDiferencias;
    private JCheckBox btnListado;
    private ButtonGroup buttonGroup1;
    private JComboBox cboBodega;
    private JLabel jLabel2;
    private JPanel jPanel1;
    private JSeparator jSeparator1;
    private JTextField txtFecha;
    private JTextField txtInventario;
    private Metodos metodos = new Metodos();
    private ConsultasMySQL consultas = new ConsultasMySQL();
    private int cboLleno = 0;

    public ImprimirInventario() {
        initComponents();
        llenarCombo();
    }

    public void imprimir() {
        String[][] parametros = new String[3][2];
        parametros[0][0] = "fecha";
        parametros[0][1] = this.txtFecha.getText();
        parametros[1][0] = "inventario";
        parametros[1][1] = this.txtInventario.getText();
        parametros[2][0] = "nbreBodega";
        parametros[2][1] = this.cboBodega.getSelectedItem().toString();
        String nbreArchivo = this.btnListado.isSelected() ? "I_Conteo1" : "I_DiferenciasEnInventario";
        this.metodos.GenerarPDF(nbreArchivo, parametros);
        this.consultas.cerrarConexionBd();
    }

    private void llenarCombo() {
        this.sql = "SELECT i_inventario.Id_Bodega, i_bodegas.Nbre, i_inventario.Id, i_inventario.Fecha_Inventario FROM i_bodegas INNER JOIN i_inventario ON (i_bodegas.Id = i_inventario.Id_Bodega) WHERE (i_inventario.Fecha_Cierre ='0000-00-00 00:00:00') ORDER BY i_bodegas.Nbre ASC, i_inventario.Fecha_Inventario ASC";
        this.listaBodega = this.consultas.llenarComboyLista(this.sql, this.listaBodega, this.cboBodega, 4);
        this.consultas.cerrarConexionBd();
        this.cboBodega.setSelectedIndex(-1);
        this.cboLleno = 1;
    }

    public void nuevo() {
        this.cboBodega.setSelectedIndex(-1);
        this.txtFecha.setText("");
        this.txtInventario.setText("");
    }

    private void initComponents() {
        this.buttonGroup1 = new ButtonGroup();
        this.jPanel1 = new JPanel();
        this.cboBodega = new JComboBox();
        this.jSeparator1 = new JSeparator();
        this.txtInventario = new JTextField();
        this.txtFecha = new JTextField();
        this.btnDiferencias = new JCheckBox();
        this.btnListado = new JCheckBox();
        this.jLabel2 = new JLabel();
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("CIERRE DE INVENTARIO");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setMaximumSize(new Dimension(786, 256));
        setMinimumSize(new Dimension(786, 256));
        setName("ImprimirInventario");
        setPreferredSize(new Dimension(786, 256));
        this.jPanel1.setBorder(BorderFactory.createEtchedBorder());
        this.jPanel1.setName("panel");
        this.jPanel1.setLayout((LayoutManager) null);
        this.cboBodega.setFont(new Font("Arial", 1, 12));
        this.cboBodega.setBorder(BorderFactory.createTitledBorder((Border) null, "Bodega", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.cboBodega.addItemListener(new ItemListener() { // from class: Inventarios.ImprimirInventario.1
            public void itemStateChanged(ItemEvent evt) {
                ImprimirInventario.this.cboBodegaItemStateChanged(evt);
            }
        });
        this.jPanel1.add(this.cboBodega);
        this.cboBodega.setBounds(20, 48, 270, 50);
        this.jPanel1.add(this.jSeparator1);
        this.jSeparator1.setBounds(20, 150, 690, 20);
        this.txtInventario.setBackground(new Color(0, 0, 153));
        this.txtInventario.setFont(new Font("Arial", 1, 20));
        this.txtInventario.setForeground(new Color(204, 255, 255));
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
        this.txtFecha.setBounds(320, 50, 140, 40);
        this.buttonGroup1.add(this.btnDiferencias);
        this.btnDiferencias.setFont(new Font("Arial", 1, 12));
        this.btnDiferencias.setForeground(new Color(255, 0, 0));
        this.btnDiferencias.setText("Diferencias en Conteo");
        this.jPanel1.add(this.btnDiferencias);
        this.btnDiferencias.setBounds(320, 120, 380, 23);
        this.buttonGroup1.add(this.btnListado);
        this.btnListado.setFont(new Font("Arial", 1, 12));
        this.btnListado.setForeground(new Color(255, 0, 0));
        this.btnListado.setSelected(true);
        this.btnListado.setText("Listado de Productos");
        this.jPanel1.add(this.btnListado);
        this.btnListado.setBounds(20, 120, 270, 23);
        this.jLabel2.setBackground((Color) null);
        this.jLabel2.setFont(new Font("Arial", 1, 14));
        this.jLabel2.setForeground(new Color(0, 102, 0));
        this.jLabel2.setHorizontalAlignment(0);
        this.jLabel2.setText("REPORTE DE INVENTARIO");
        this.jLabel2.setOpaque(true);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.jPanel1, -2, 750, -2).addContainerGap()).addComponent(this.jLabel2, -1, -1, 32767));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.jLabel2, -2, 38, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel1, -2, 172, -2).addContainerGap()));
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
