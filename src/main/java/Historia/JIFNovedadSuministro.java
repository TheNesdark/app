package Historia;

import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/* JADX INFO: loaded from: GenomaP.jar:Historia/JIFNovedadSuministro.class */
public class JIFNovedadSuministro extends JInternalFrame {
    private DefaultTableModel modelosuministro;
    private Object[] dato;
    private ResultSet rs;
    private JButton JBTCerrar;
    private JLabel JLBTitulo;
    private JScrollPane JSPDetalleConsulta;
    private JTable JTBDetalle;
    private TableColumn column = null;
    private Metodos xmetodo = new Metodos();

    public JIFNovedadSuministro(String sql) {
        initComponents();
        mCrearTablaDetalle();
        mCargarDatos(sql);
    }

    private void initComponents() {
        this.JSPDetalleConsulta = new JScrollPane();
        this.JTBDetalle = new JTable();
        this.JLBTitulo = new JLabel();
        this.JBTCerrar = new JButton();
        setClosable(true);
        setTitle("NOVEDAD DEL SUMINISTRO");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        this.JSPDetalleConsulta.setBorder(BorderFactory.createEtchedBorder());
        this.JTBDetalle.setFont(new Font("Arial", 1, 12));
        this.JTBDetalle.setRowHeight(25);
        this.JTBDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTBDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTBDetalle.setSelectionMode(0);
        this.JTBDetalle.addMouseListener(new MouseAdapter() { // from class: Historia.JIFNovedadSuministro.1
            public void mouseClicked(MouseEvent evt) {
                JIFNovedadSuministro.this.JTBDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalleConsulta.setViewportView(this.JTBDetalle);
        this.JLBTitulo.setBackground(new Color(0, 0, 153));
        this.JLBTitulo.setFont(new Font("Arial", 1, 14));
        this.JLBTitulo.setForeground(new Color(204, 255, 255));
        this.JLBTitulo.setHorizontalAlignment(0);
        this.JLBTitulo.setText("NOVEDAD DEL SUMINISTRO");
        this.JLBTitulo.setBorder(BorderFactory.createEtchedBorder());
        this.JLBTitulo.setOpaque(true);
        this.JBTCerrar.setFont(new Font("Arial", 1, 12));
        this.JBTCerrar.setForeground(new Color(0, 0, 153));
        this.JBTCerrar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.JBTCerrar.setText("Cerrar");
        this.JBTCerrar.addActionListener(new ActionListener() { // from class: Historia.JIFNovedadSuministro.2
            public void actionPerformed(ActionEvent evt) {
                JIFNovedadSuministro.this.JBTCerrarActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JLBTitulo, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.JSPDetalleConsulta, GroupLayout.Alignment.LEADING, -1, 664, 32767))).addGroup(layout.createSequentialGroup().addGap(288, 288, 288).addComponent(this.JBTCerrar))).addContainerGap(-1, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JLBTitulo, -2, 28, -2).addGap(18, 18, 18).addComponent(this.JSPDetalleConsulta, -2, 153, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBTCerrar).addContainerGap(23, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBDetalleMouseClicked(MouseEvent evt) {
        if (this.JTBDetalle.getSelectedRow() != -1 && this.modelosuministro.getValueAt(this.JTBDetalle.getSelectedRow(), 2).toString().equals("Si")) {
            try {
                this.xmetodo.recuperarBlob("SELECT g_novedadsuministro.Documento FROM baseserver.g_novedadsuministro INNER JOIN baseserver.g_tiponovedad ON (g_novedadsuministro.Id_TipoNovedad = g_tiponovedad.Id) WHERE (g_novedadsuministro.Id ='" + this.modelosuministro.getValueAt(this.JTBDetalle.getSelectedRow(), 0) + "')", 0);
            } catch (IOException ex) {
                Logger.getLogger(JIFNovedadSuministro.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            } catch (SQLException ex2) {
                Logger.getLogger(JIFNovedadSuministro.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex2);
            }
            this.xmetodo.mostrarPdf("C:\\Genoma\\tmp\\atmp.pdf");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTCerrarActionPerformed(ActionEvent evt) {
        dispose();
    }

    private void mCrearTablaDetalle() {
        this.modelosuministro = new DefaultTableModel();
        this.modelosuministro.addColumn("Id");
        this.modelosuministro.addColumn("Tipo Novedad");
        this.modelosuministro.addColumn("Imagen");
        this.JTBDetalle.setModel(this.modelosuministro);
        this.column = this.JTBDetalle.getColumnModel().getColumn(0);
        this.column.setPreferredWidth(50);
        this.column = this.JTBDetalle.getColumnModel().getColumn(1);
        this.column.setPreferredWidth(400);
        this.column = this.JTBDetalle.getColumnModel().getColumn(2);
        this.column.setPreferredWidth(50);
    }

    public void mCargarDatos(String sql) {
        ConsultasMySQL xmt = new ConsultasMySQL();
        this.rs = xmt.traerRs(sql);
        try {
            this.rs.next();
            if (this.rs.getRow() != 0) {
                this.rs.beforeFirst();
                int i = 0;
                while (this.rs.next()) {
                    this.modelosuministro.addRow(this.dato);
                    this.modelosuministro.setValueAt(Long.valueOf(this.rs.getLong(1)), i, 0);
                    this.modelosuministro.setValueAt(this.rs.getString(2), i, 1);
                    if (this.rs.getInt(3) == 1) {
                        this.modelosuministro.setValueAt("Si", i, 2);
                    } else {
                        this.modelosuministro.setValueAt("No", i, 2);
                    }
                    i++;
                }
            }
            this.rs.close();
            xmt.cerrarConexionBd();
        } catch (SQLException e) {
        }
    }
}
