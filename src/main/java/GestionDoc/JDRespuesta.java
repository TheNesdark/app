package GestionDoc;

import Sgc.JIFEncuestaS;
import Utilidades.ConsultasMySQL;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:GestionDoc/JDRespuesta.class */
public class JDRespuesta extends JDialog {
    public DefaultTableModel xmodelo;
    private ConsultasMySQL xct;
    private Object[] xdato;
    private JIFEncuestaS xjifenc;
    private JButton JBTCerrar;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;

    public JDRespuesta(Frame parent, boolean modal, String xidt, JIFEncuestaS xjifenc) {
        super(parent, modal);
        this.xct = new ConsultasMySQL();
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        this.xjifenc = xjifenc;
        mCargarDetalle(xidt);
    }

    /* JADX WARN: Type inference failed for: r3v4, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JBTCerrar = new JButton();
        setDefaultCloseOperation(2);
        setTitle("RESPUESTA");
        setFont(new Font("Arial", 1, 14));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.setSelectionMode(0);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: GestionDoc.JDRespuesta.1
            public void mouseClicked(MouseEvent evt) {
                JDRespuesta.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.JBTCerrar.setFont(new Font("Arial", 1, 12));
        this.JBTCerrar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.JBTCerrar.setText("Cerrar");
        this.JBTCerrar.addActionListener(new ActionListener() { // from class: GestionDoc.JDRespuesta.2
            public void actionPerformed(ActionEvent evt) {
                JDRespuesta.this.JBTCerrarActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JBTCerrar, GroupLayout.Alignment.LEADING, -1, 510, 32767).addComponent(this.JSPDetalle, GroupLayout.Alignment.LEADING, -1, 510, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JSPDetalle, -2, 146, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBTCerrar, -1, 43, 32767).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            this.xjifenc.xmodelo.setValueAt(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1), this.xjifenc.JTDetalle.getSelectedRow(), 2);
            this.xjifenc.xmodelo.setValueAt(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0), this.xjifenc.JTDetalle.getSelectedRow(), 5);
            dispose();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTCerrarActionPerformed(ActionEvent evt) {
        dispose();
    }

    private void mCrearTablaDetalle() {
        this.xmodelo = new DefaultTableModel((Object[][]) null, new String[]{"Id", "Nombre"}) { // from class: GestionDoc.JDRespuesta.3
            Class[] types = {Long.class, String.class};
            boolean[] canEdit = {false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(100);
    }

    private void mCargarDetalle(String xid) {
        mCrearTablaDetalle();
        String sql = "SELECT Id, Nbre FROM t_etipo_respuesta WHERE (Id_tipor ='" + xid + "') ORDER BY Id ASC";
        ResultSet rs = this.xct.traerRs(sql);
        try {
            if (rs.next()) {
                rs.beforeFirst();
                int x = 0;
                while (rs.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(Long.valueOf(rs.getLong(1)), x, 0);
                    this.xmodelo.setValueAt(rs.getString(2), x, 1);
                    x++;
                }
            }
            rs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            this.xct.mostrarErrorSQL(ex);
        }
    }
}
