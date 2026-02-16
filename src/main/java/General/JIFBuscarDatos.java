package General;

import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:General/JIFBuscarDatos.class */
public class JIFBuscarDatos extends JInternalFrame {
    private DefaultTableModel xmodelo = new DefaultTableModel();
    private Metodos xmt = new Metodos();
    private ConsultasMySQL xct = new ConsultasMySQL();
    private Object[] xdato;
    private String xobjetollamador;
    private String xsql;
    private JTextField xnombrep;
    private JButton JBTPAdicionarPeligro;
    private JPanel JPIDatosBuscar;
    private JScrollPane JSPResultado;
    public JFormattedTextField JTFNombre;
    private JTable JTResultado;
    private ButtonGroup buttonGroup1;

    public JIFBuscarDatos(JTextField xnombrep, String xobjetollamador) {
        initComponents();
        this.xnombrep = xnombrep;
        this.xobjetollamador = xobjetollamador;
        mCrearTabla();
    }

    private void initComponents() {
        this.buttonGroup1 = new ButtonGroup();
        this.JSPResultado = new JScrollPane();
        this.JTResultado = new JTable();
        this.JPIDatosBuscar = new JPanel();
        this.JTFNombre = new JFormattedTextField();
        this.JBTPAdicionarPeligro = new JButton();
        setClosable(true);
        setIconifiable(true);
        setTitle("BUSCAR DATOS");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("BDiagnostico");
        this.JSPResultado.setBorder(BorderFactory.createTitledBorder((Border) null, "RESULTADO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTResultado.setFont(new Font("Arial", 1, 12));
        this.JTResultado.setRowHeight(25);
        this.JTResultado.setSelectionBackground(new Color(255, 255, 255));
        this.JTResultado.setSelectionForeground(Color.red);
        this.JTResultado.setSelectionMode(0);
        this.JTResultado.addMouseListener(new MouseAdapter() { // from class: General.JIFBuscarDatos.1
            public void mouseClicked(MouseEvent evt) {
                JIFBuscarDatos.this.JTResultadoMouseClicked(evt);
            }
        });
        this.JSPResultado.setViewportView(this.JTResultado);
        this.JPIDatosBuscar.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTFNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFNombre.setFont(new Font("Arial", 1, 12));
        this.JTFNombre.addKeyListener(new KeyAdapter() { // from class: General.JIFBuscarDatos.2
            public void keyReleased(KeyEvent evt) {
                JIFBuscarDatos.this.JTFNombreKeyReleased(evt);
            }
        });
        GroupLayout JPIDatosBuscarLayout = new GroupLayout(this.JPIDatosBuscar);
        this.JPIDatosBuscar.setLayout(JPIDatosBuscarLayout);
        JPIDatosBuscarLayout.setHorizontalGroup(JPIDatosBuscarLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosBuscarLayout.createSequentialGroup().addContainerGap().addComponent(this.JTFNombre, -1, 699, 32767).addContainerGap()));
        JPIDatosBuscarLayout.setVerticalGroup(JPIDatosBuscarLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosBuscarLayout.createSequentialGroup().addComponent(this.JTFNombre, -2, -1, -2).addContainerGap(-1, 32767)));
        this.JBTPAdicionarPeligro.setFont(new Font("Arial", 1, 12));
        this.JBTPAdicionarPeligro.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.JBTPAdicionarPeligro.setText("SALIR");
        this.JBTPAdicionarPeligro.setActionCommand("Salir");
        this.JBTPAdicionarPeligro.addActionListener(new ActionListener() { // from class: General.JIFBuscarDatos.3
            public void actionPerformed(ActionEvent evt) {
                JIFBuscarDatos.this.JBTPAdicionarPeligroActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JBTPAdicionarPeligro, GroupLayout.Alignment.LEADING, -1, 735, 32767).addComponent(this.JSPResultado, -1, 735, 32767).addComponent(this.JPIDatosBuscar, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatosBuscar, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPResultado, -2, 212, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTPAdicionarPeligro, -2, 43, -2).addContainerGap(19, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNombreKeyReleased(KeyEvent evt) {
        if (!this.JTFNombre.getText().isEmpty()) {
            try {
                mCrearTabla();
                if (this.xobjetollamador.equals("empresa_peligro") || this.xobjetollamador.equals("empresa_accidentet") || this.xobjetollamador.equals("empresa_enfermedadp") || this.xobjetollamador.equals("empresa_arl") || this.xobjetollamador.equals("arl_accidentet")) {
                    this.xsql = "SELECT Id ,  Nbre FROM g_empresa WHERE (Nbre LIKE '" + this.JTFNombre.getText() + "%' and Estado=1) ORDER BY  Nbre  ASC";
                } else if (this.xobjetollamador.equals("cargo_peligro")) {
                    this.xsql = "SELECT Id ,  Nbre FROM g_cargos WHERE (Nbre LIKE '" + this.JTFNombre.getText() + "%' and Estado=1) ORDER BY  Nbre  ASC";
                } else if (this.xobjetollamador.equals("Agrupacion")) {
                    this.xsql = "SELECT Id ,  Nbre FROM rh_activo_tipo_nagrupacion WHERE (Nbre LIKE '" + this.JTFNombre.getText() + "%' and Estado=0) ORDER BY  Nbre  ASC";
                } else if (this.xobjetollamador.equals("datos_seg")) {
                    this.xsql = "SELECT  `Id` , `Nbre` FROM `so_tipo_segmento` WHERE (Nbre LIKE '" + this.JTFNombre.getText() + "%' and Estado=1) ORDER BY  Nbre  ASC";
                }
                ResultSet res = this.xct.traerRs(this.xsql);
                if (res.next()) {
                    res.beforeFirst();
                    int nfila = 0;
                    while (res.next()) {
                        this.xmodelo.addRow(this.xdato);
                        this.xmodelo.setValueAt(res.getString(1), nfila, 0);
                        this.xmodelo.setValueAt(res.getString(2), nfila, 1);
                        nfila++;
                    }
                }
                res.close();
                this.xct.cerrarConexionBd();
            } catch (SQLException ex) {
                Logger.getLogger(JIFBuscarDatos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTResultadoMouseClicked(MouseEvent evt) {
        this.xnombrep.setText(this.xmodelo.getValueAt(this.JTResultado.getSelectedRow(), 1).toString());
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTPAdicionarPeligroActionPerformed(ActionEvent evt) {
        dispose();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTabla() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Nombre"}) { // from class: General.JIFBuscarDatos.4
            Class[] types = {Integer.class, String.class};
            boolean[] canEdit = {false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTResultado.setModel(this.xmodelo);
        this.JTResultado.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTResultado.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTResultado.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTResultado.getColumnModel().getColumn(1).setPreferredWidth(300);
    }
}
