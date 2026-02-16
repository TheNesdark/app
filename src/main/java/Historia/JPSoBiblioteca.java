package Historia;

import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Historia/JPSoBiblioteca.class */
public class JPSoBiblioteca extends JPanel {
    public DefaultTableModel xmodelo;
    private Object[] xdato;
    private ConsultasMySQL xct = new ConsultasMySQL();
    private Metodos xmetodos = new Metodos();
    private File xfile;
    private JTable JTDetalleDocu;
    private JTextField JTFBusqeuda;
    private JTextField JTFDescipcion;
    private JTextField JTFNombre;
    private JTextField JTFUbicacion;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JScrollPane jScrollPane1;

    public JPSoBiblioteca() {
        initComponents();
        mBuscaInformacion();
    }

    private void mModeloDetalle() {
        this.xmodelo = new DefaultTableModel((Object[][]) null, new String[]{"Id", "Nombre", "Descripcion", "Ubicacion"}) { // from class: Historia.JPSoBiblioteca.1
            Class[] types = {Long.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return this.canEdit[colIndex];
            }
        };
        this.JTDetalleDocu.setModel(this.xmodelo);
        this.JTDetalleDocu.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTDetalleDocu.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTDetalleDocu.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTDetalleDocu.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTDetalleDocu.getColumnModel().getColumn(2).setPreferredWidth(50);
        this.JTDetalleDocu.getColumnModel().getColumn(3).setPreferredWidth(10);
    }

    private void mBuscaInformacion() {
        mModeloDetalle();
        ResultSet rs = this.xct.traerRs("SELECT\n  `id`,\n  `nombreDocumento`,\n  `descripcion`,\n  `urlDocumento`\n FROM `so_biblioteca` ORDER BY nombreDocumento ASC");
        try {
            if (rs.next()) {
                rs.beforeFirst();
                int x = 0;
                while (rs.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(Long.valueOf(rs.getLong(1)), x, 0);
                    this.xmodelo.setValueAt(rs.getString(2), x, 1);
                    this.xmodelo.setValueAt(rs.getString(3), x, 2);
                    this.xmodelo.setValueAt(rs.getString(4), x, 3);
                    x++;
                }
            }
            rs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            this.xct.mostrarErrorSQL(ex);
        }
    }

    /* JADX WARN: Type inference failed for: r3v23, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jPanel1 = new JPanel();
        this.JTFNombre = new JTextField();
        this.JTFDescipcion = new JTextField();
        this.JTFUbicacion = new JTextField();
        this.jScrollPane1 = new JScrollPane();
        this.JTDetalleDocu = new JTable();
        this.jPanel2 = new JPanel();
        this.JTFBusqeuda = new JTextField();
        setName("jifBibliotecaSO");
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 107, 0)));
        this.jPanel1.setForeground(new Color(0, 107, 0));
        this.JTFNombre.setFont(new Font("Arial", 1, 12));
        this.JTFNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFDescipcion.setFont(new Font("Arial", 1, 12));
        this.JTFDescipcion.setBorder(BorderFactory.createTitledBorder((Border) null, "Descripción", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFUbicacion.setFont(new Font("Arial", 1, 12));
        this.JTFUbicacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación documento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFUbicacion.addMouseListener(new MouseAdapter() { // from class: Historia.JPSoBiblioteca.2
            public void mouseClicked(MouseEvent evt) {
                JPSoBiblioteca.this.JTFUbicacionMouseClicked(evt);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JTFNombre, -2, 319, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFDescipcion)).addComponent(this.JTFUbicacion)).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFNombre, -2, 50, -2).addComponent(this.JTFDescipcion, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFUbicacion, -2, 50, -2).addGap(5, 5, 5)));
        this.JTDetalleDocu.setFont(new Font("Arial", 1, 12));
        this.JTDetalleDocu.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalleDocu.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalleDocu.setSelectionForeground(Color.red);
        this.JTDetalleDocu.addMouseListener(new MouseAdapter() { // from class: Historia.JPSoBiblioteca.3
            public void mouseClicked(MouseEvent evt) {
                JPSoBiblioteca.this.JTDetalleDocuMouseClicked(evt);
            }
        });
        this.jScrollPane1.setViewportView(this.JTDetalleDocu);
        this.jPanel2.setBorder(BorderFactory.createTitledBorder((Border) null, "BÚSQUEDA", 2, 0, new Font("Arial", 1, 14), new Color(0, 107, 0)));
        this.JTFBusqeuda.setFont(new Font("Arial", 1, 12));
        this.JTFBusqeuda.setBorder(BorderFactory.createTitledBorder((Border) null, "", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFBusqeuda.addKeyListener(new KeyAdapter() { // from class: Historia.JPSoBiblioteca.4
            public void keyPressed(KeyEvent evt) {
                JPSoBiblioteca.this.JTFBusqeudaKeyPressed(evt);
            }

            public void keyReleased(KeyEvent evt) {
                JPSoBiblioteca.this.JTFBusqeudaKeyReleased(evt);
            }

            public void keyTyped(KeyEvent evt) {
                JPSoBiblioteca.this.JTFBusqeudaKeyTyped(evt);
            }
        });
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(this.JTFBusqeuda).addContainerGap()));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.JTFBusqeuda, -2, 50, -2).addGap(0, 8, 32767)));
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -1, -1, 32767).addComponent(this.jScrollPane1, -1, 726, 32767).addComponent(this.jPanel2, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel2, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane1, -1, 257, 32767).addContainerGap()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleDocuMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            this.xmetodos.mostrarPdf(this.xmodelo.getValueAt(this.JTDetalleDocu.getSelectedRow(), 3).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFUbicacionMouseClicked(MouseEvent evt) {
        JFileChooser xfilec = new JFileChooser("C:\\");
        int xv = xfilec.showOpenDialog(this);
        if (xv == 0) {
            this.xfile = xfilec.getSelectedFile();
            this.JTFUbicacion.setText(this.xfile.getAbsolutePath());
            this.JTFUbicacion.setText(this.xmetodos.mTraerUrlBD(this.xfile.getAbsolutePath()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFBusqeudaKeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFBusqeudaKeyTyped(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFBusqeudaKeyReleased(KeyEvent evt) {
        mBuscar();
    }

    public void mGrabar() {
        if (!this.JTFNombre.getText().isEmpty()) {
            if (!this.JTFUbicacion.getText().isEmpty()) {
                int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (x == 0) {
                    String sql = "INSERT INTO `so_biblioteca`\n            (`nombreDocumento`,\n             `descripcion`,\n             `urlDocumento`)\nVALUES ('" + this.JTFNombre.getText().toUpperCase() + "',\n        '" + this.JTFDescipcion.getText() + "',\n        '" + this.JTFUbicacion.getText() + "');";
                    this.xct.ejecutarSQL(sql);
                    this.xct.cerrarConexionBd();
                    mNuevo();
                    mBuscaInformacion();
                    return;
                }
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "debe seleccionar una ubicación", "VERIFICAR INFORMACIÓN", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe digitar el nombre", "VERIFICAR INFORMACIÓN", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
    }

    private void mNuevo() {
        this.JTFNombre.setText("");
        this.JTFDescipcion.setText("");
        this.JTFUbicacion.setText("");
    }

    private void mBuscar() {
        String sql = "SELECT  `id`,  `nombreDocumento`, `descripcion`, `urlDocumento`\nFROM `so_biblioteca` WHERE nombreDocumento LIKE '%" + this.JTFBusqeuda.getText() + "%'  ORDER BY nombreDocumento ASC";
        mModeloDetalle();
        ResultSet rs = this.xct.traerRs(sql);
        try {
            if (rs.next()) {
                rs.beforeFirst();
                int x = 0;
                while (rs.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(Long.valueOf(rs.getLong(1)), x, 0);
                    this.xmodelo.setValueAt(rs.getString(2), x, 1);
                    this.xmodelo.setValueAt(rs.getString(3), x, 2);
                    this.xmodelo.setValueAt(rs.getString(4), x, 3);
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
