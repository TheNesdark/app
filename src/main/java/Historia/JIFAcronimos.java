package Historia;

import Utilidades.ConsultasMySQL;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Historia/JIFAcronimos.class */
public class JIFAcronimos extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private Object[] xdato;
    private ConsultasMySQL xconsultas = new ConsultasMySQL();
    private JPanel JPIDatos;
    private JScrollPane JSPDetalle;
    public JTable JTBDetalle;
    private JFormattedTextField JTFFCodigo;
    private JFormattedTextField JTFFNbre;

    public JIFAcronimos() {
        initComponents();
        mCargarDatosTabla("SELECT Acronimo, Significado, Estado FROM  baseserver.h_acronimos ORDER BY Significado ASC");
    }

    /* JADX WARN: Type inference failed for: r3v24, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPIDatos = new JPanel();
        this.JTFFCodigo = new JFormattedTextField();
        this.JTFFNbre = new JFormattedTextField();
        this.JSPDetalle = new JScrollPane();
        this.JTBDetalle = new JTable();
        setClosable(true);
        setTitle("ACRÓNIMOS");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS PARA CONSULTA", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTFFCodigo.setBorder(BorderFactory.createTitledBorder((Border) null, "Código", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFCodigo.setFont(new Font("Arial", 1, 12));
        this.JTFFCodigo.addKeyListener(new KeyAdapter() { // from class: Historia.JIFAcronimos.1
            public void keyReleased(KeyEvent evt) {
                JIFAcronimos.this.JTFFCodigoKeyReleased(evt);
            }
        });
        this.JTFFNbre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFNbre.setFont(new Font("Arial", 1, 12));
        this.JTFFNbre.addKeyListener(new KeyAdapter() { // from class: Historia.JIFAcronimos.2
            public void keyReleased(KeyEvent evt) {
                JIFAcronimos.this.JTFFNbreKeyReleased(evt);
            }
        });
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addComponent(this.JTFFCodigo, -2, 136, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFFNbre, -1, 668, 32767).addContainerGap()));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFCodigo, -2, 50, -2).addComponent(this.JTFFNbre, -2, 50, -2)).addContainerGap(13, 32767)));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTBDetalle.setFont(new Font("Arial", 1, 12));
        this.JTBDetalle.setForeground(new Color(0, 0, 204));
        this.JTBDetalle.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTBDetalle.setEditingColumn(1);
        this.JTBDetalle.setEditingRow(1);
        this.JTBDetalle.setRowHeight(25);
        this.JTBDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTBDetalle.setSelectionForeground(Color.red);
        this.JTBDetalle.setSelectionMode(0);
        this.JSPDetalle.setViewportView(this.JTBDetalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JSPDetalle, GroupLayout.Alignment.LEADING, -1, 850, 32767).addComponent(this.JPIDatos, GroupLayout.Alignment.LEADING, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalle, -1, 349, 32767).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFNbreKeyReleased(KeyEvent evt) {
        if (!this.JTFFNbre.getText().isEmpty()) {
            String sql = "SELECT Acronimo, Significado, Estado FROM  baseserver.h_acronimos WHERE (Significado like '" + this.JTFFNbre.getText() + "%') ORDER BY Significado ASC";
            mCargarDatosTabla(sql);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFCodigoKeyReleased(KeyEvent evt) {
        if (!this.JTFFCodigo.getText().isEmpty()) {
            String sql = "SELECT Acronimo, Significado, Estado FROM  baseserver.h_acronimos WHERE (Acronimo like '" + this.JTFFCodigo.getText() + "%') ORDER BY Significado ASC";
            mCargarDatosTabla(sql);
        }
    }

    private void mCrearTabla() {
        this.xmodelo = new DefaultTableModel((Object[][]) null, new String[]{"Acronimo", "Nombre", "Estado"}) { // from class: Historia.JIFAcronimos.3
            Class[] types = {String.class, String.class, Boolean.class};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        this.JTBDetalle.setModel(this.xmodelo);
        this.JTBDetalle.getColumnModel().getColumn(0).setPreferredWidth(30);
        this.JTBDetalle.getColumnModel().getColumn(1).setPreferredWidth(600);
        this.JTBDetalle.getColumnModel().getColumn(2).setPreferredWidth(10);
    }

    private void mCargarDatosTabla(String sql) {
        try {
            mCrearTabla();
            ResultSet rs = this.xconsultas.traerRs(sql);
            rs.next();
            if (rs.getRow() != 0) {
                rs.beforeFirst();
                int i = 0;
                while (rs.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(rs.getString(1), i, 0);
                    this.xmodelo.setValueAt(rs.getString(2), i, 1);
                    this.xmodelo.setValueAt(Boolean.valueOf(rs.getBoolean(3)), i, 2);
                    i++;
                }
            }
            rs.close();
            this.xconsultas.cerrarConexionBd();
        } catch (SQLException e) {
        }
    }
}
