package ParametrizacionN;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.genoma.plus.jpa.entities.GCargos;
import com.genoma.plus.jpa.service.IGCargosService;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

/* JADX INFO: loaded from: GenomaP.jar:ParametrizacionN/JDcargos.class */
public class JDcargos extends JDialog {
    private DefaultTableModel xmodelo;
    private ConsultasMySQL xct;
    private Object[] xdatos;
    private String sql;
    private String xllamador;
    private ResultSet rs;
    private Object textFiel;
    private final Metodos metodos;
    private final IGCargosService cargosService;
    private JDcargos jd;
    private JButton JBT_Grabar;
    private JButton JBT_NUevo;
    private JButton JBT_Salir;
    private JPanel JPIDatosBusqueda;
    private JTable JTAble;
    private JTextField JTFNombreBusqueda;
    private JScrollPane jScrollPane1;

    public JDcargos(Frame parent, boolean modal, Object textFiel) {
        super(parent, modal);
        this.xct = new ConsultasMySQL();
        initComponents();
        this.metodos = new Metodos();
        this.cargosService = (IGCargosService) Principal.contexto.getBean(IGCargosService.class);
        this.textFiel = textFiel;
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
    }

    /* JADX WARN: Type inference failed for: r3v13, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPIDatosBusqueda = new JPanel();
        this.JTFNombreBusqueda = new JTextField();
        this.jScrollPane1 = new JScrollPane();
        this.JTAble = new JTable();
        this.JBT_NUevo = new JButton();
        this.JBT_Grabar = new JButton();
        this.JBT_Salir = new JButton();
        setDefaultCloseOperation(2);
        setTitle("CARGO");
        setIconImage(null);
        this.JPIDatosBusqueda.setBorder(BorderFactory.createTitledBorder((Border) null, "FILTRO", 0, 0, new Font("Arial", 1, 14), Color.red));
        this.JTFNombreBusqueda.setFont(new Font("Arial", 1, 12));
        this.JTFNombreBusqueda.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFNombreBusqueda.addActionListener(new ActionListener() { // from class: ParametrizacionN.JDcargos.1
            public void actionPerformed(ActionEvent evt) {
                JDcargos.this.JTFNombreBusquedaActionPerformed(evt);
            }
        });
        this.JTFNombreBusqueda.addKeyListener(new KeyAdapter() { // from class: ParametrizacionN.JDcargos.2
            public void keyTyped(KeyEvent evt) {
                JDcargos.this.JTFNombreBusquedaKeyTyped(evt);
            }
        });
        GroupLayout JPIDatosBusquedaLayout = new GroupLayout(this.JPIDatosBusqueda);
        this.JPIDatosBusqueda.setLayout(JPIDatosBusquedaLayout);
        JPIDatosBusquedaLayout.setHorizontalGroup(JPIDatosBusquedaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosBusquedaLayout.createSequentialGroup().addContainerGap().addComponent(this.JTFNombreBusqueda).addContainerGap()));
        JPIDatosBusquedaLayout.setVerticalGroup(JPIDatosBusquedaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosBusquedaLayout.createSequentialGroup().addContainerGap().addComponent(this.JTFNombreBusqueda, -2, 53, -2).addContainerGap(14, 32767)));
        this.jScrollPane1.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 0, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTAble.setFont(new Font("Arial", 1, 12));
        this.JTAble.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTAble.setRowHeight(25);
        this.JTAble.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JDcargos.3
            public void mouseClicked(MouseEvent evt) {
                JDcargos.this.JTAbleMouseClicked(evt);
            }
        });
        this.JTAble.addKeyListener(new KeyAdapter() { // from class: ParametrizacionN.JDcargos.4
            public void keyPressed(KeyEvent evt) {
                JDcargos.this.JTAbleKeyPressed(evt);
            }
        });
        this.jScrollPane1.setViewportView(this.JTAble);
        this.JBT_NUevo.setFont(new Font("Arial", 1, 12));
        this.JBT_NUevo.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Nuevo29x25.png")));
        this.JBT_NUevo.setText("Nuevo");
        this.JBT_NUevo.addActionListener(new ActionListener() { // from class: ParametrizacionN.JDcargos.5
            public void actionPerformed(ActionEvent evt) {
                JDcargos.this.JBT_NUevoActionPerformed(evt);
            }
        });
        this.JBT_Grabar.setFont(new Font("Arial", 1, 12));
        this.JBT_Grabar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBT_Grabar.setText("Grabar");
        this.JBT_Grabar.addFocusListener(new FocusAdapter() { // from class: ParametrizacionN.JDcargos.6
            public void focusGained(FocusEvent evt) {
                JDcargos.this.JBT_GrabarFocusGained(evt);
            }
        });
        this.JBT_Grabar.addActionListener(new ActionListener() { // from class: ParametrizacionN.JDcargos.7
            public void actionPerformed(ActionEvent evt) {
                JDcargos.this.JBT_GrabarActionPerformed(evt);
            }
        });
        this.JBT_Salir.setFont(new Font("Arial", 1, 12));
        this.JBT_Salir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.JBT_Salir.setText("Salir");
        this.JBT_Salir.addActionListener(new ActionListener() { // from class: ParametrizacionN.JDcargos.8
            public void actionPerformed(ActionEvent evt) {
                JDcargos.this.JBT_SalirActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPIDatosBusqueda, -1, -1, 32767).addComponent(this.jScrollPane1).addGroup(layout.createSequentialGroup().addComponent(this.JBT_NUevo, -2, 200, -2).addGap(47, 47, 47).addComponent(this.JBT_Grabar, -2, 200, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 53, 32767).addComponent(this.JBT_Salir, -2, 200, -2))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatosBusqueda, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane1, -1, 237, 32767).addGap(18, 18, 18).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBT_Salir, -2, 50, -2).addComponent(this.JBT_Grabar, -2, 50, -2).addComponent(this.JBT_NUevo, -2, 50, -2)).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNombreBusquedaKeyTyped(KeyEvent evt) {
        mCargarDatosTabla();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNombreBusquedaActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTAbleMouseClicked(MouseEvent evt) {
        if (this.JTAble.getSelectedRow() != -1) {
            entregarDato();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_NUevoActionPerformed(ActionEvent evt) {
        nuevo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_GrabarFocusGained(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_GrabarActionPerformed(ActionEvent evt) {
        grabar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_SalirActionPerformed(ActionEvent evt) {
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTAbleKeyPressed(KeyEvent evt) {
        if (this.JTAble.getSelectedRow() != -1 && evt.getKeyCode() == 10) {
            entregarDato();
        }
    }

    private void entregarDato() {
        JTextField textField = (JTextField) this.textFiel;
        textField.setText(this.xmodelo.getValueAt(this.JTAble.getSelectedRow(), 1).toString());
        dispose();
    }

    private void mCargarDatosTabla() {
        try {
            String sql = "SELECT Id, Nbre FROM g_cargos gc WHERE gc.Nbre  LIKE '%" + this.JTFNombreBusqueda.getText() + "%'";
            mCrearModeloDatos();
            ResultSet xrs = this.xct.traerRs(sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(Integer.valueOf(xrs.getInt("Id")), n, 0);
                    this.xmodelo.setValueAt(xrs.getString("Nbre"), n, 1);
                    n++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JDcargos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Nombre"}) { // from class: ParametrizacionN.JDcargos.9
            Class[] types = {Long.class, String.class};
            boolean[] canEdit = {false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTAble.setDefaultRenderer(JButton.class, new TableCellRenderer() { // from class: ParametrizacionN.JDcargos.10
            public Component getTableCellRendererComponent(JTable jtable, Object objeto, boolean estaSeleccionado, boolean tieneElFoco, int fila, int columna) {
                return (Component) objeto;
            }
        });
        JTable jTable = this.JTAble;
        JTable jTable2 = this.JTAble;
        jTable.setAutoResizeMode(0);
        this.JTAble.doLayout();
        this.JTAble.setFont(new Font("Arial", 1, 12));
        this.JTAble.setSelectionBackground(Color.WHITE);
        this.JTAble.setSelectionForeground(Color.RED);
        JTable jTable3 = this.JTAble;
        JTable jTable4 = this.JTAble;
        jTable3.setAutoResizeMode(0);
        this.JTAble.doLayout();
        this.JTAble.setModel(this.xmodelo);
        this.JTAble.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTAble.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTAble.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTAble.getColumnModel().getColumn(1).setPreferredWidth(800);
        this.jScrollPane1.getViewport().add(this.JTAble);
    }

    private void grabar() {
        GCargos cargo = new GCargos();
        cargo.setEstado(true);
        cargo.setFecha(this.metodos.getFechaActual());
        cargo.setNbre(this.JTFNombreBusqueda.getText());
        cargo.setUsuarioS(Principal.usuarioSistemaDTO.getLogin());
        this.cargosService.crearCargo(cargo);
    }

    private void nuevo() {
        this.JTFNombreBusqueda.setText("");
        this.JTFNombreBusqueda.requestFocus();
    }
}
