package Contabilidad;

import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.DefaultCellEditor;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/* JADX INFO: loaded from: GenomaP.jar:Contabilidad/IntegraFactura.class */
public class IntegraFactura extends JInternalFrame {
    private DefaultTableModel modelo;
    private claseContabilidad claseconta;
    private JComboBox cboCuenta;
    private JComboBox cboTipo;
    private JComboBox cboCC;
    private String[] listaCC;
    private JTable grid;
    private JLabel jLabel1;
    private JLabel jLabel17;
    private JLabel jLabel18;
    private JLabel jLabel19;
    private JLabel jLabel20;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JScrollPane jScrollPane1;
    private JFormattedTextField txtCredito;
    private JFormattedTextField txtDebito;
    private JLabel txtEstado;
    public JDateChooser txtFechaFin;
    public JDateChooser txtFechaIni;
    private Metodos metodos = new Metodos();
    private ConsultasMySQL consultas = new ConsultasMySQL();
    private Object[] dato = {"", "", "", "", "", "", "", "", new Boolean(false), new Long(0), ""};

    public IntegraFactura(claseContabilidad clase) {
        initComponents();
        this.claseconta = clase;
        nuevo();
    }

    public void buscar() {
        this.metodos.mostrarMensaje("Aqui busco de acuerd a los criterios de busqueda de fechas");
    }

    private void crearGrid() {
        this.modelo = new DefaultTableModel((Object[][]) null, new String[]{"Centro Costo", "Cuenta", "Comprobante", "Fecha", "Documento", "Doc. Referencia", "NIT", "Detalle", "Debito", "Valor", "Registro"}) { // from class: Contabilidad.IntegraFactura.1
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Boolean.class, Long.class, Integer.class};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }
        };
        this.grid.setModel(this.modelo);
        TableColumn cuenta = this.grid.getColumnModel().getColumn(1);
        TableColumn cc = this.grid.getColumnModel().getColumn(0);
        this.cboCC = new JComboBox();
        this.cboCuenta = new JComboBox();
        this.listaCC = this.consultas.llenarCombo("SELECT Id, Nbre FROM f_centrocosto WHERE (Estado =0) ORDER BY Nbre ASC", this.listaCC, this.cboCC);
        cuenta.setCellEditor(new DefaultCellEditor(this.cboCuenta));
        cc.setCellEditor(new DefaultCellEditor(this.cboCC));
        this.modelo.addRow(this.dato);
        this.modelo.addRow(this.dato);
        this.consultas.cerrarConexionBd();
    }

    public void nuevo() {
        this.txtFechaIni.setDate((Date) null);
        this.txtFechaFin.setDate((Date) null);
        this.txtDebito.setValue(0);
        this.txtCredito.setValue(0);
        this.txtEstado.setText("Desigual");
        this.metodos.limpiarDatosPrincipal();
        crearGrid();
    }

    public void sumarValores() {
        this.txtDebito.setValue(0);
        this.txtCredito.setValue(0);
        for (int f = 0; f < this.modelo.getRowCount(); f++) {
            if (this.modelo.getValueAt(f, 8).toString().equals("true")) {
                this.txtDebito.setValue(Long.valueOf(Long.parseLong(this.txtDebito.getValue().toString()) + Long.parseLong(this.modelo.getValueAt(f, 9).toString())));
            } else {
                this.txtCredito.setValue(Long.valueOf(Long.parseLong(this.txtCredito.getValue().toString()) + Long.parseLong(this.modelo.getValueAt(f, 9).toString())));
            }
        }
        if (this.txtDebito.getValue().equals(this.txtCredito.getValue())) {
            this.txtEstado.setText("PARTIDA DOBLE");
        } else {
            this.txtEstado.setText("Desigual");
        }
    }

    /* JADX WARN: Type inference failed for: r3v7, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jLabel1 = new JLabel();
        this.jScrollPane1 = new JScrollPane();
        this.grid = new JTable();
        this.jPanel1 = new JPanel();
        this.jLabel17 = new JLabel();
        this.txtFechaIni = new JDateChooser();
        this.jLabel18 = new JLabel();
        this.txtFechaFin = new JDateChooser();
        this.jPanel2 = new JPanel();
        this.jLabel19 = new JLabel();
        this.jLabel20 = new JLabel();
        this.txtDebito = new JFormattedTextField();
        this.txtCredito = new JFormattedTextField();
        this.txtEstado = new JLabel();
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("MÓDULO DE INTEGRACIÓN A CONTABILIDAD");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("IntegraFactura");
        this.jLabel1.setBackground(new Color(102, 0, 102));
        this.jLabel1.setFont(new Font("Tahoma", 1, 14));
        this.jLabel1.setForeground(new Color(204, 255, 255));
        this.jLabel1.setHorizontalAlignment(0);
        this.jLabel1.setText("CUENTAS DE FACTURACION");
        this.jLabel1.setOpaque(true);
        this.grid.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.grid.addMouseListener(new MouseAdapter() { // from class: Contabilidad.IntegraFactura.2
            public void mouseExited(MouseEvent evt) {
                IntegraFactura.this.gridMouseExited(evt);
            }
        });
        this.jScrollPane1.setViewportView(this.grid);
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "Período", 0, 0, new Font("Tahoma", 1, 12), new Color(102, 0, 102)));
        this.jLabel17.setBackground(new Color(0, 51, 204));
        this.jLabel17.setFont(new Font("Tahoma", 0, 13));
        this.jLabel17.setForeground(new Color(0, 0, 153));
        this.jLabel17.setText("Fecha Inicial");
        this.txtFechaIni.setDateFormatString("dd/MM/yyyy");
        this.txtFechaIni.setFont(new Font("Tahoma", 0, 13));
        this.jLabel18.setBackground(new Color(0, 51, 204));
        this.jLabel18.setFont(new Font("Tahoma", 0, 13));
        this.jLabel18.setForeground(new Color(0, 0, 153));
        this.jLabel18.setText("Fecha Final");
        this.txtFechaFin.setDateFormatString("dd/MM/yyyy");
        this.txtFechaFin.setFont(new Font("Tahoma", 0, 13));
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel17, -2, 90, -2).addComponent(this.txtFechaIni, -2, 100, -2)).addGap(18, 18, 18).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel18, -2, 90, -2).addComponent(this.txtFechaFin, -2, 100, -2)).addContainerGap(26, 32767)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap(-1, 32767).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addComponent(this.jLabel17).addGap(4, 4, 4).addComponent(this.txtFechaIni, -2, 30, -2)).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addComponent(this.jLabel18).addGap(4, 4, 4).addComponent(this.txtFechaFin, -2, 30, -2)))));
        this.jPanel2.setBorder(BorderFactory.createTitledBorder((Border) null, "Valores", 0, 0, new Font("Tahoma", 1, 12), new Color(102, 0, 102)));
        this.jLabel19.setBackground(new Color(0, 51, 204));
        this.jLabel19.setFont(new Font("Tahoma", 0, 13));
        this.jLabel19.setForeground(new Color(0, 0, 153));
        this.jLabel19.setText("Total Debito");
        this.jLabel20.setBackground(new Color(0, 51, 204));
        this.jLabel20.setFont(new Font("Tahoma", 0, 13));
        this.jLabel20.setForeground(new Color(0, 0, 153));
        this.jLabel20.setText("Total Credito");
        this.txtDebito.setBackground(new Color(102, 0, 102));
        this.txtDebito.setHorizontalAlignment(4);
        this.txtDebito.setDisabledTextColor(new Color(255, 255, 255));
        this.txtDebito.setEnabled(false);
        this.txtDebito.setFont(new Font("Tahoma", 1, 14));
        this.txtDebito.setValue(0);
        this.txtCredito.setBackground(new Color(102, 0, 102));
        this.txtCredito.setHorizontalAlignment(4);
        this.txtCredito.setDisabledTextColor(new Color(255, 255, 255));
        this.txtCredito.setEnabled(false);
        this.txtCredito.setFont(new Font("Tahoma", 1, 14));
        this.txtCredito.setValue(0);
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.txtDebito, -2, 157, -2).addComponent(this.jLabel19, -2, 90, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel20, -2, 90, -2).addComponent(this.txtCredito, -2, 171, -2)).addContainerGap(-1, 32767)));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel19).addComponent(this.jLabel20)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.txtDebito, -2, 28, -2).addComponent(this.txtCredito, -2, 28, -2)).addContainerGap(-1, 32767)));
        this.txtEstado.setFont(new Font("Tahoma", 1, 12));
        this.txtEstado.setForeground(new Color(0, 0, 102));
        this.txtEstado.setHorizontalAlignment(0);
        this.txtEstado.setBorder(BorderFactory.createTitledBorder((Border) null, "Estado", 0, 0, new Font("Tahoma", 1, 12), new Color(102, 0, 102)));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel1, -1, 997, 32767).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jPanel2, -2, -1, -2).addGap(27, 27, 27).addComponent(this.txtEstado, -2, 176, -2).addContainerGap(-1, 32767)).addComponent(this.jScrollPane1, GroupLayout.Alignment.TRAILING, -1, 997, 32767));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.jLabel1, -2, 28, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jPanel1, -2, -1, -2).addComponent(this.jPanel2, -1, -1, 32767).addGroup(layout.createSequentialGroup().addGap(0, 8, 32767).addComponent(this.txtEstado, -2, 84, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jScrollPane1, -1, 431, 32767).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gridMouseExited(MouseEvent evt) {
    }
}
