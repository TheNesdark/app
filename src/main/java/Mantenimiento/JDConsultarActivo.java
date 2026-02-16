package Mantenimiento;

import Activos.JIFGestionActivos;
import Utilidades.ConsultasMySQL;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Mantenimiento/JDConsultarActivo.class */
public class JDConsultarActivo extends JDialog {
    private JIFGestionActivos xgestionactivo;
    DefaultTableModel xmodelo;
    private JScrollPane JSPDetalle;
    private JTable JTResultado;

    public JDConsultarActivo(Frame parent, boolean modal, JIFGestionActivos xgestionactivo) {
        super(parent, modal);
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        this.xgestionactivo = xgestionactivo;
        mCargarDatos();
    }

    /* JADX WARN: Type inference failed for: r3v4, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JSPDetalle = new JScrollPane();
        this.JTResultado = new JTable();
        setDefaultCloseOperation(2);
        setTitle("Consultar Lotes x Producto");
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.blue));
        this.JSPDetalle.setFont(new Font("Arial", 1, 12));
        this.JTResultado.setFont(new Font("Arial", 1, 12));
        this.JTResultado.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTResultado.setRowHeight(25);
        this.JTResultado.setSelectionBackground(new Color(255, 255, 255));
        this.JTResultado.setSelectionForeground(new Color(255, 0, 0));
        this.JTResultado.setSelectionMode(0);
        this.JTResultado.addMouseListener(new MouseAdapter() { // from class: Mantenimiento.JDConsultarActivo.1
            public void mouseClicked(MouseEvent evt) {
                JDConsultarActivo.this.JTResultadoMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTResultado);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JSPDetalle, -1, 760, 32767).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(22, 22, 22).addComponent(this.JSPDetalle, -2, 259, -2).addContainerGap(19, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTResultadoMouseClicked(MouseEvent evt) {
        if (this.JTResultado.getSelectedRow() != -1) {
            this.xgestionactivo.JTADescripcion.setText(this.xmodelo.getValueAt(this.JTResultado.getSelectedRow(), 0).toString());
            dispose();
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Descripción"}) { // from class: Mantenimiento.JDConsultarActivo.2
            Class[] types = {String.class};
            boolean[] canEdit = {false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTResultado.setModel(this.xmodelo);
        this.JTResultado.getColumnModel().getColumn(0).setPreferredWidth(300);
    }

    private void mCargarDatos() {
        ConsultasMySQL consultas = new ConsultasMySQL();
        mCrearModeloDatos();
        ResultSet rs = consultas.traerRs("SELECT Descripcion FROM rh_activos GROUP BY Descripcion ORDER BY Descripcion ASC");
        try {
            if (rs.next()) {
                rs.beforeFirst();
                int n = 0;
                while (rs.next()) {
                    this.xmodelo.addRow((Object[]) null);
                    this.xmodelo.setValueAt(rs.getString(1), n, 0);
                    n++;
                }
            }
            rs.close();
            consultas.cerrarConexionBd();
        } catch (SQLException ex) {
            consultas.mostrarErrorSQL(ex);
        }
    }
}
