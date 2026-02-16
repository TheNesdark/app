package ParametrizacionN;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.ConsultasSqlServer;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
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
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:ParametrizacionN/JDConvenioEmpresa.class */
public class JDConvenioEmpresa extends JDialog {
    private DefaultTableModel xmodelo;
    private Object[] xdato;
    private ConsultasMySQL xcsmysql;
    private ConsultasSqlServer xcsqlserver;
    String idConvenio;
    String razonSocial;
    String idConvenioBS1;
    String razonSocialBS1;
    private Metodos metodos;
    private JButton JBGrabar;
    private JButton JBSalir;
    private JPanel JPIDatosBusqueda;
    private JTextField JTFNombreBusqueda;
    private JTable JTable;
    private JLabel jLabelInformacion;
    private JScrollPane jScrollPane1;

    public JDConvenioEmpresa(Frame parent, boolean modal) {
        super(parent, modal);
        this.xmodelo = new DefaultTableModel();
        this.xcsmysql = new ConsultasMySQL();
        this.xcsqlserver = new ConsultasSqlServer();
        this.idConvenio = "";
        this.razonSocial = "";
        this.idConvenioBS1 = "";
        this.razonSocialBS1 = "";
        this.metodos = new Metodos();
        initComponents();
        crearModeloDatos();
    }

    public JDConvenioEmpresa(Frame parent, boolean modal, String idConvenioGenoma, String razonSocialConvenio) {
        super(parent, modal);
        this.xmodelo = new DefaultTableModel();
        this.xcsmysql = new ConsultasMySQL();
        this.xcsqlserver = new ConsultasSqlServer();
        this.idConvenio = "";
        this.razonSocial = "";
        this.idConvenioBS1 = "";
        this.razonSocialBS1 = "";
        this.metodos = new Metodos();
        initComponents();
        this.idConvenio = idConvenioGenoma;
        this.razonSocial = razonSocialConvenio;
        crearModeloDatos();
    }

    /* JADX INFO: loaded from: GenomaP.jar:ParametrizacionN/JDConvenioEmpresa$MiRender.class */
    public class MiRender extends DefaultTableCellRenderer {
        public MiRender() {
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            return cell;
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id Bs1", "No Documento", "Razon Social"}) { // from class: ParametrizacionN.JDConvenioEmpresa.1
            Class[] types = {String.class, String.class, Integer.class};
            boolean[] canEdit = {false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTable.setModel(this.xmodelo);
        this.JTable.doLayout();
        this.JTable.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTable.getColumnModel().getColumn(1).setPreferredWidth(25);
        this.JTable.getColumnModel().getColumn(2).setPreferredWidth(25);
    }

    private void listarEmpresasBienEstar(String busqueda) {
    }

    private void mCargarDatosTabla(String sql) {
        crearModeloDatos();
        ResultSet rs = this.xcsqlserver.traerRs(sql);
        try {
            if (rs.next()) {
                rs.beforeFirst();
                int x = 0;
                while (rs.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(rs.getString(1), x, 0);
                    this.xmodelo.setValueAt(rs.getString(2), x, 1);
                    this.xmodelo.setValueAt(rs.getString(3), x, 2);
                    this.JTable.setDefaultRenderer(Object.class, new MiRender());
                    x++;
                }
            }
            rs.close();
            this.xcsqlserver.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFFEmpresa.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jScrollPane1 = new JScrollPane();
        this.JTable = new JTable();
        this.JBGrabar = new JButton();
        this.JBSalir = new JButton();
        this.JPIDatosBusqueda = new JPanel();
        this.JTFNombreBusqueda = new JTextField();
        this.jLabelInformacion = new JLabel();
        setDefaultCloseOperation(2);
        this.JTable.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTable.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JDConvenioEmpresa.2
            public void mouseClicked(MouseEvent evt) {
                JDConvenioEmpresa.this.JTableMouseClicked(evt);
            }
        });
        this.jScrollPane1.setViewportView(this.JTable);
        this.JBGrabar.setFont(new Font("Arial", 1, 12));
        this.JBGrabar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Grabar29x27.png")));
        this.JBGrabar.setText("Homologar");
        this.JBGrabar.addActionListener(new ActionListener() { // from class: ParametrizacionN.JDConvenioEmpresa.3
            public void actionPerformed(ActionEvent evt) {
                JDConvenioEmpresa.this.JBGrabarActionPerformed(evt);
            }
        });
        this.JBSalir.setFont(new Font("Arial", 1, 12));
        this.JBSalir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.JBSalir.setText("Salir");
        this.JBSalir.addActionListener(new ActionListener() { // from class: ParametrizacionN.JDConvenioEmpresa.4
            public void actionPerformed(ActionEvent evt) {
                JDConvenioEmpresa.this.JBSalirActionPerformed(evt);
            }
        });
        this.JPIDatosBusqueda.setBorder(BorderFactory.createTitledBorder((Border) null, "Búsqueda Filtrada", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JTFNombreBusqueda.setFont(new Font("Arial", 1, 12));
        this.JTFNombreBusqueda.setToolTipText("");
        this.JTFNombreBusqueda.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre o Documento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFNombreBusqueda.addActionListener(new ActionListener() { // from class: ParametrizacionN.JDConvenioEmpresa.5
            public void actionPerformed(ActionEvent evt) {
                JDConvenioEmpresa.this.JTFNombreBusquedaActionPerformed(evt);
            }
        });
        this.JTFNombreBusqueda.addKeyListener(new KeyAdapter() { // from class: ParametrizacionN.JDConvenioEmpresa.6
            public void keyTyped(KeyEvent evt) {
                JDConvenioEmpresa.this.JTFNombreBusquedaKeyTyped(evt);
            }
        });
        GroupLayout JPIDatosBusquedaLayout = new GroupLayout(this.JPIDatosBusqueda);
        this.JPIDatosBusqueda.setLayout(JPIDatosBusquedaLayout);
        JPIDatosBusquedaLayout.setHorizontalGroup(JPIDatosBusquedaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosBusquedaLayout.createSequentialGroup().addContainerGap().addComponent(this.JTFNombreBusqueda, -2, 784, -2).addContainerGap(-1, 32767)));
        JPIDatosBusquedaLayout.setVerticalGroup(JPIDatosBusquedaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosBusquedaLayout.createSequentialGroup().addComponent(this.JTFNombreBusqueda, -2, 50, -2).addContainerGap(7, 32767)));
        this.jLabelInformacion.setFont(new Font("Segoe UI", 1, 13));
        this.jLabelInformacion.setForeground(new Color(0, 102, 255));
        this.jLabelInformacion.setText("---");
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.JPIDatosBusqueda, -2, -1, -2).addGap(0, 0, 32767)).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jScrollPane1, -2, 800, -2).addGroup(layout.createSequentialGroup().addComponent(this.JBGrabar, -2, 404, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBSalir, -1, -1, 32767)).addComponent(this.jLabelInformacion)).addContainerGap(-1, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatosBusqueda, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jScrollPane1, -2, 156, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jLabelInformacion).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 37, 32767).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBGrabar, -2, 50, -2).addComponent(this.JBSalir, -2, 50, -2)).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBGrabarActionPerformed(ActionEvent evt) {
        int x = JOptionPane.showConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (x == 0) {
            if (!this.idConvenioBS1.equals("") && !this.idConvenio.equals("")) {
                insertarHomologacion(this.idConvenioBS1, this.razonSocialBS1, this.idConvenio, this.razonSocial);
            } else {
                JOptionPane.showMessageDialog(this, "Seleccione antes un convenio de BS1", "Verificar", 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBSalirActionPerformed(ActionEvent evt) {
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNombreBusquedaKeyTyped(KeyEvent evt) {
        String Query = "select e.Empr_ID,e.Empr_NIT,e.Empr_RazonSocial from Empresa e\nwhere  e.Empr_RazonSocial like '%" + this.JTFNombreBusqueda.getText() + "%'";
        mCargarDatosTabla(Query);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNombreBusquedaActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTableMouseClicked(MouseEvent evt) {
        if (this.JTable.getSelectedRow() != -1 && evt.getClickCount() == 2) {
            this.idConvenioBS1 = this.xmodelo.getValueAt(this.JTable.getSelectedRow(), 0).toString();
            this.razonSocialBS1 = this.xmodelo.getValueAt(this.JTable.getSelectedRow(), 2).toString();
            System.out.println("ID BS1: " + this.idConvenioBS1 + "RAZON SOCIAL: " + this.razonSocialBS1);
            this.jLabelInformacion.setText("Genoma: " + this.razonSocial + "  ==  BienestarSalud: " + this.razonSocialBS1);
        }
    }

    private void insertarHomologacion(String idConvenioBS1, String nombreBs1, String idConvenioGenoma, String razonSocialGenoma) {
        String sqlValidar = "SELECT COUNT(idConvenioBS1) AS total\nFROM baseserver.g_homologacion_convenio\nWHERE idConvenioBS1='" + idConvenioBS1 + "' AND idConvenioGenoma='" + idConvenioGenoma + "';";
        int resultado = Integer.valueOf(this.xcsmysql.traerDato(sqlValidar)).intValue();
        this.xcsmysql.cerrarConexionBd();
        if (resultado == 0) {
            String sqlInsert = "INSERT INTO baseserver.g_homologacion_convenio\n(idConvenioBS1, nombreConvenioBS1, idConvenioGenoma, nombreConvenioGenoma, estado, fechaRegistro, usuarioSistema)\nVALUES('" + idConvenioBS1 + "', '" + nombreBs1 + "', '" + idConvenioGenoma + "', '" + razonSocialGenoma + "', 1, '" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "', '" + Principal.usuarioSistemaDTO.getLogin() + "');";
            this.xcsmysql.ejecutarSQL(sqlInsert);
            JOptionPane.showMessageDialog(this, "Homologados exitosamente", "Succes", 1);
        } else if (resultado > 0) {
            JOptionPane.showMessageDialog(this, "Ya se encuentran homolagados estos dos convenios", "Verificar", 1);
        }
        this.xcsmysql.cerrarConexionBd();
    }
}
