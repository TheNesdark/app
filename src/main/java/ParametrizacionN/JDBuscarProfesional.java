package ParametrizacionN;

import Acceso.Principal;
import PyP.Vacunacion;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:ParametrizacionN/JDBuscarProfesional.class */
public class JDBuscarProfesional extends JDialog {
    private DefaultTableModel xmodelo;
    private Metodos xmetodos;
    private ConsultasMySQL consultas;
    private Object[] dato;
    private String xnombre;
    private String xprofesional;
    private String[] xespecialidad;
    int nfila;
    int columna;
    int xtipobusqueda;
    boolean xlleno;
    JTextField Profesional;
    private Vacunacion xvacunacion;
    private JComboBox JCBFEspecialidad;
    private JCheckBox JCHFiltro;
    private JPanel JPFiltroPro;
    private JScrollPane JSDetalle;
    private JTable JTDetalle;

    public JDBuscarProfesional(JTextField codigo, String xnombrellamador, Frame parent, boolean modal) {
        super(parent, modal);
        this.xmodelo = new DefaultTableModel();
        this.xmetodos = new Metodos();
        this.consultas = new ConsultasMySQL();
        this.nfila = 0;
        this.columna = 0;
        this.xtipobusqueda = 0;
        this.xlleno = false;
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        setLocationRelativeTo(null);
        this.xlleno = false;
        this.xespecialidad = this.consultas.llenarCombo("SELECT`Id_Persona`, `Especialidad`FROM`profesional1`GROUP BY `Especialidad`;", this.xespecialidad, this.JCBFEspecialidad);
        this.JCBFEspecialidad.setSelectedIndex(-1);
        this.consultas.cerrarConexionBd();
        this.xlleno = true;
        this.xnombre = xnombrellamador;
        mCargarDatosTabla();
    }

    /* JADX WARN: Type inference failed for: r3v18, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPFiltroPro = new JPanel();
        this.JCBFEspecialidad = new JComboBox();
        this.JCHFiltro = new JCheckBox();
        this.JSDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        setDefaultCloseOperation(2);
        setTitle("PROFESIONAL");
        this.JPFiltroPro.setBorder(BorderFactory.createTitledBorder((Border) null, "FILTRO", 1, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JCBFEspecialidad.setFont(new Font("Arial", 1, 12));
        this.JCBFEspecialidad.setBorder(BorderFactory.createTitledBorder((Border) null, "Especialidad", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBFEspecialidad.setEnabled(false);
        this.JCBFEspecialidad.addItemListener(new ItemListener() { // from class: ParametrizacionN.JDBuscarProfesional.1
            public void itemStateChanged(ItemEvent evt) {
                JDBuscarProfesional.this.JCBFEspecialidadItemStateChanged(evt);
            }
        });
        this.JCHFiltro.setFont(new Font("Arial", 1, 12));
        this.JCHFiltro.setText("Filtrar?");
        this.JCHFiltro.addActionListener(new ActionListener() { // from class: ParametrizacionN.JDBuscarProfesional.2
            public void actionPerformed(ActionEvent evt) {
                JDBuscarProfesional.this.JCHFiltroActionPerformed(evt);
            }
        });
        GroupLayout JPFiltroProLayout = new GroupLayout(this.JPFiltroPro);
        this.JPFiltroPro.setLayout(JPFiltroProLayout);
        JPFiltroProLayout.setHorizontalGroup(JPFiltroProLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPFiltroProLayout.createSequentialGroup().addContainerGap().addComponent(this.JCBFEspecialidad, 0, -1, 32767).addGap(18, 18, 18).addComponent(this.JCHFiltro).addContainerGap()));
        JPFiltroProLayout.setVerticalGroup(JPFiltroProLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPFiltroProLayout.createSequentialGroup().addContainerGap().addGroup(JPFiltroProLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBFEspecialidad, -1, 50, 32767).addGroup(JPFiltroProLayout.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.JCHFiltro))).addContainerGap()));
        this.JSDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JDBuscarProfesional.3
            public void mouseClicked(MouseEvent evt) {
                JDBuscarProfesional.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSDetalle.setViewportView(this.JTDetalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPFiltroPro, -1, -1, 32767).addComponent(this.JSDetalle, -1, 508, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPFiltroPro, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSDetalle, -2, 254, -2).addContainerGap(-1, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBFEspecialidadItemStateChanged(ItemEvent evt) {
        if (this.xtipobusqueda == 1 && this.JCBFEspecialidad.getSelectedIndex() != -1 && this.xlleno) {
            mCargarDatosTabla();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHFiltroActionPerformed(ActionEvent evt) {
        if (this.JCHFiltro.isSelected()) {
            this.xtipobusqueda = 1;
            this.JCBFEspecialidad.setEnabled(true);
            if (this.JCBFEspecialidad.getSelectedIndex() == -1 || !this.xlleno) {
                return;
            }
            mCargarDatosTabla();
            return;
        }
        this.xtipobusqueda = 0;
        this.JCBFEspecialidad.setEnabled(false);
        mCargarDatosTabla();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            if (this.xnombre.equals("Vacunacion")) {
                Principal.clasepyp.frmVacunacion.txtVacunador.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
                dispose();
            }
            dispose();
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Profesional"}) { // from class: ParametrizacionN.JDBuscarProfesional.4
            Class[] types = {String.class};
            boolean[] canEdit = {false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(10);
    }

    private void mCargarDatosTabla() {
        String sql;
        try {
            mCrearModeloDatos();
            if (this.xtipobusqueda == 0) {
                sql = "SELECT`NProfesional` FROM`profesional1`GROUP BY `NProfesional`;";
            } else {
                sql = "SELECT`NProfesional`FROM`profesional1`WHERE (`Especialidad` ='" + this.JCBFEspecialidad.getSelectedItem() + "')GROUP BY `NProfesional`;";
            }
            ResultSet res = this.consultas.traerRs(sql);
            if (res.next()) {
                res.beforeFirst();
                int n = 0;
                while (res.next()) {
                    this.xmodelo.addRow(this.dato);
                    this.xmodelo.setValueAt(res.getString(1), n, 0);
                    n++;
                }
            }
            res.close();
            this.consultas.cerrarConexionBd();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
