package PyP;

import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
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
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:PyP/BuscarCACervix.class */
public class BuscarCACervix extends JDialog {
    private Metodos metodos;
    private ConsultasMySQL consultas;
    private DefaultTableModel modelo;
    private ResultSet rs;
    private String sql;
    private Object[] dato;
    private int filaGrid;
    private int gridD;
    private JIFCACervix frmToma;
    private CACervixResultado frmResultado;
    private JButton btnCargar;
    private JButton btnSalir;
    private JTable grid;
    private JScrollPane jScrollPane1;
    private JLabel lblTitulo;

    public BuscarCACervix(Frame parent, boolean modal, int buscar, JInternalFrame frm) {
        super(parent, modal);
        this.metodos = new Metodos();
        this.consultas = new ConsultasMySQL();
        this.filaGrid = 0;
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        casting(frm);
        iniciar(buscar);
        setLocationRelativeTo(null);
        this.grid.addMouseListener(new MouseAdapter() { // from class: PyP.BuscarCACervix.1
            public void mouseClicked(MouseEvent e) {
                BuscarCACervix.this.filaGrid = BuscarCACervix.this.grid.rowAtPoint(e.getPoint());
                if (e.getClickCount() > 1) {
                    BuscarCACervix.this.cargarGridCA();
                }
            }
        });
    }

    private void casting(JInternalFrame frm) {
        if (!frm.getName().equals("CACervixToma")) {
            if (frm.getName().equals("CACervixResultado")) {
                this.frmResultado = (CACervixResultado) frm;
                return;
            }
            return;
        }
        this.frmToma = (JIFCACervix) frm;
    }

    private void iniciar(int buscar) {
        this.gridD = buscar;
        colocarTitulo(buscar);
        crearGrid();
        cargarGrid(buscar);
    }

    private void colocarTitulo(int titulo) {
        if (titulo != 1) {
            if (titulo != 2) {
                if (titulo != 3) {
                    if (titulo != 4) {
                        if (titulo != 5) {
                            if (titulo == 6) {
                                this.lblTitulo.setText("ASPECTO DEL CUELLO");
                                return;
                            }
                            return;
                        }
                        this.lblTitulo.setText("OTRAS NEOPLASIAS");
                        return;
                    }
                    this.lblTitulo.setText("ANORMALIDAD EN CELULAS GLANDULARES");
                    return;
                }
                this.lblTitulo.setText("ANORMALIDAD EN CELULAS ESCAMOSAS");
                return;
            }
            this.lblTitulo.setText("HALLAZGOS NO NEOPLASICOS");
            return;
        }
        this.lblTitulo.setText("MICROORGANISMOS ENCONTRADOS");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cargarGridCA() {
        if (this.grid.getSelectedRow() != -1) {
            if (this.frmToma != null) {
                this.frmToma.mCargarDatosAspectoCuello(this.modelo.getValueAt(this.filaGrid, 0).toString(), this.modelo.getValueAt(this.filaGrid, 1).toString());
            } else if (this.frmResultado != null) {
                this.frmResultado.cargarGrid(this.gridD, this.modelo.getValueAt(this.filaGrid, 0).toString(), this.modelo.getValueAt(this.filaGrid, 1).toString());
            }
            dispose();
        }
    }

    private void cargarGrid(int op) {
        this.filaGrid = 0;
        int tipo = 0;
        if (op == 1) {
            tipo = 3;
        } else if (op == 2) {
            tipo = 4;
        } else if (op == 3) {
            tipo = 5;
        } else if (op == 4) {
            tipo = 6;
        } else if (op == 5) {
            tipo = 7;
        } else if (op == 6) {
            tipo = 8;
        }
        this.sql = "SELECT Id, Nbre FROM p_citologia_conceptoestudio WHERE (Id_TipoEstudio ='" + tipo + "' AND Estado =0)";
        this.rs = this.consultas.traerRs(this.sql);
        while (this.rs.next()) {
            try {
                this.modelo.addRow(this.dato);
                this.modelo.setValueAt(this.rs.getString(1), this.filaGrid, 0);
                this.modelo.setValueAt(this.rs.getString(2), this.filaGrid, 1);
                this.filaGrid++;
            } catch (SQLException ex) {
                this.consultas.mostrarErrorSQL(ex);
                return;
            }
        }
        this.rs.close();
        this.consultas.cerrarConexionBd();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearGrid() {
        this.modelo = new DefaultTableModel(new Object[0], new String[]{"Id", "SE ENCONTRO"}) { // from class: PyP.BuscarCACervix.2
            Class[] types = {String.class, String.class};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        this.grid.setModel(this.modelo);
        this.grid.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.grid.getColumnModel().getColumn(0).setMinWidth(0);
        this.grid.getColumnModel().getColumn(0).setMaxWidth(0);
        this.modelo.addRow(this.dato);
    }

    /* JADX WARN: Type inference failed for: r3v2, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jScrollPane1 = new JScrollPane();
        this.grid = new JTable();
        this.lblTitulo = new JLabel();
        this.btnCargar = new JButton();
        this.btnSalir = new JButton();
        setDefaultCloseOperation(2);
        setTitle("Busqueda de Resultados de Examenes");
        setName("BuscarCACervix");
        this.grid.setFont(new Font("Arial", 1, 12));
        this.grid.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.grid.setRowHeight(25);
        this.grid.setSelectionBackground(new Color(255, 255, 255));
        this.grid.setSelectionForeground(new Color(255, 0, 0));
        this.grid.setSelectionMode(0);
        this.jScrollPane1.setViewportView(this.grid);
        this.lblTitulo.setBackground(new Color(0, 0, 102));
        this.lblTitulo.setFont(new Font("Arial", 1, 24));
        this.lblTitulo.setForeground(new Color(255, 255, 255));
        this.lblTitulo.setHorizontalAlignment(0);
        this.lblTitulo.setText("jLabel1");
        this.lblTitulo.setOpaque(true);
        this.btnCargar.setFont(new Font("Arial", 1, 12));
        this.btnCargar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.btnCargar.setText("Cargar");
        this.btnCargar.addActionListener(new ActionListener() { // from class: PyP.BuscarCACervix.3
            public void actionPerformed(ActionEvent evt) {
                BuscarCACervix.this.btnCargarActionPerformed(evt);
            }
        });
        this.btnSalir.setFont(new Font("Arial", 1, 12));
        this.btnSalir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.btnSalir.setText("Salir");
        this.btnSalir.addActionListener(new ActionListener() { // from class: PyP.BuscarCACervix.4
            public void actionPerformed(ActionEvent evt) {
                BuscarCACervix.this.btnSalirActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.btnCargar, -2, 385, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 49, 32767).addComponent(this.btnSalir, -2, 391, -2)).addComponent(this.jScrollPane1, -1, 825, 32767)).addContainerGap()).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.lblTitulo, -1, 845, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(46, 46, 46).addComponent(this.jScrollPane1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.btnCargar, -2, 40, -2).addComponent(this.btnSalir, -2, 40, -2)).addContainerGap(-1, 32767)).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.lblTitulo, -2, 39, -2).addContainerGap(471, 32767))));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnCargarActionPerformed(ActionEvent evt) {
        cargarGridCA();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnSalirActionPerformed(ActionEvent evt) {
        dispose();
    }
}
