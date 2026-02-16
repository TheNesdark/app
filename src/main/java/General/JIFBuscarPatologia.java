package General;

import Acceso.Principal;
import Historia.JPSo_Osteomuscular;
import Historia.clasesHistoriaCE;
import Odontologia.JPOdontograma;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
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
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:General/JIFBuscarPatologia.class */
public class JIFBuscarPatologia extends JDialog {
    private DefaultTableModel modelo;
    private Metodos metodos;
    private ConsultasMySQL consultas;
    private Object[] dato;
    private int nfila;
    private int columna;
    private int estadob;
    private int xValidacion;
    Object jppatologias;
    Object jifhistoria;
    private String xnombre;
    JTextField codigo;
    JTextField nombrep;
    String idcofides;
    int nidcofides;
    private JPSo_Osteomuscular xclase;
    private JPOdontograma xJPOdontograma;
    JComboBox xcombo;
    private JCheckBox JCHContiene;
    private JCheckBox JCHEmpieza;
    private JCheckBox JCHFiltroPrograma;
    public JFormattedTextField JFTFNombrePatologia;
    private JPanel JPIDatosBuscar;
    private JPanel JPIFBusqueda;
    private JScrollPane JSPResultado;
    private JTable JTResultado;
    private ButtonGroup buttonGroup1;

    public JIFBuscarPatologia(Frame parent, boolean modal, Object jppatologias, String nombre, JTextField codigo, JTextField nombrep, Object jifhistoria, String idcofides) {
        super(parent, modal);
        this.modelo = new DefaultTableModel();
        this.metodos = new Metodos();
        this.consultas = new ConsultasMySQL();
        this.nfila = 0;
        this.columna = 0;
        this.estadob = 1;
        this.xValidacion = 0;
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        this.jppatologias = jppatologias;
        this.jifhistoria = jifhistoria;
        this.xnombre = nombre;
        this.codigo = codigo;
        this.nombrep = nombrep;
        this.idcofides = idcofides;
        this.modelo.addColumn("Codigo");
        this.modelo.addColumn("Nombre");
        this.modelo.addColumn("CodFides");
        this.modelo.addRow(this.dato);
        this.JTResultado.setModel(this.modelo);
        this.JTResultado.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTResultado.getColumnModel().getColumn(1).setPreferredWidth(500);
        this.JTResultado.getColumnModel().getColumn(2).setPreferredWidth(5);
    }

    public JIFBuscarPatologia(Frame parent, boolean modal, Object jppatologias, String nombre, JTextField codigo, JTextField nombrep, Object jifhistoria, int nidcofides) {
        super(parent, modal);
        this.modelo = new DefaultTableModel();
        this.metodos = new Metodos();
        this.consultas = new ConsultasMySQL();
        this.nfila = 0;
        this.columna = 0;
        this.estadob = 1;
        this.xValidacion = 0;
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        this.jppatologias = jppatologias;
        this.jifhistoria = jifhistoria;
        this.xnombre = nombre;
        this.codigo = codigo;
        this.nombrep = nombrep;
        this.nidcofides = nidcofides;
        this.modelo.addColumn("Codigo");
        this.modelo.addColumn("Nombre");
        this.modelo.addRow(this.dato);
        this.JTResultado.setModel(this.modelo);
        this.JTResultado.getColumnModel().getColumn(0).setPreferredWidth(50);
        this.JTResultado.getColumnModel().getColumn(1).setPreferredWidth(500);
    }

    public JIFBuscarPatologia(Frame parent, boolean modal, Object jppatologias, String xnombrellamador) {
        super(parent, modal);
        this.modelo = new DefaultTableModel();
        this.metodos = new Metodos();
        this.consultas = new ConsultasMySQL();
        this.nfila = 0;
        this.columna = 0;
        this.estadob = 1;
        this.xValidacion = 0;
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        this.jppatologias = jppatologias;
        this.xnombre = xnombrellamador;
        mCrearTabla();
        this.JFTFNombrePatologia.requestFocus();
    }

    public JIFBuscarPatologia(Frame parent, boolean modal, JTextField codigo, JTextField nombrep, String xnombrellamador, int xValidacion) {
        super(parent, modal);
        this.modelo = new DefaultTableModel();
        this.metodos = new Metodos();
        this.consultas = new ConsultasMySQL();
        this.nfila = 0;
        this.columna = 0;
        this.estadob = 1;
        this.xValidacion = 0;
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        this.codigo = codigo;
        this.nombrep = nombrep;
        this.xValidacion = xValidacion;
        this.xnombre = xnombrellamador;
        mCrearTabla();
        if (xValidacion == 1) {
            this.JCHFiltroPrograma.setSelected(true);
        } else {
            this.JCHFiltroPrograma.setVisible(false);
        }
        this.JFTFNombrePatologia.requestFocus();
    }

    public JIFBuscarPatologia(Frame parent, boolean modal, JTextField codigo, String xnombrellamador) {
        super(parent, modal);
        this.modelo = new DefaultTableModel();
        this.metodos = new Metodos();
        this.consultas = new ConsultasMySQL();
        this.nfila = 0;
        this.columna = 0;
        this.estadob = 1;
        this.xValidacion = 0;
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        this.codigo = codigo;
        this.xnombre = xnombrellamador;
        mCrearTabla();
        this.JFTFNombrePatologia.requestFocus();
    }

    public JIFBuscarPatologia(Frame parent, boolean modal, JPSo_Osteomuscular xclase, String xnombrellamador) {
        super(parent, modal);
        this.modelo = new DefaultTableModel();
        this.metodos = new Metodos();
        this.consultas = new ConsultasMySQL();
        this.nfila = 0;
        this.columna = 0;
        this.estadob = 1;
        this.xValidacion = 0;
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        this.xclase = xclase;
        this.xnombre = xnombrellamador;
        mCrearTabla();
        this.JFTFNombrePatologia.requestFocus();
    }

    public JIFBuscarPatologia(Frame parent, boolean modal, JPOdontograma xJPOdontograma, String xnombrellamador) {
        super(parent, modal);
        this.modelo = new DefaultTableModel();
        this.metodos = new Metodos();
        this.consultas = new ConsultasMySQL();
        this.nfila = 0;
        this.columna = 0;
        this.estadob = 1;
        this.xValidacion = 0;
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        this.xJPOdontograma = xJPOdontograma;
        this.xnombre = xnombrellamador;
        mCrearTabla();
        this.JFTFNombrePatologia.requestFocus();
    }

    private void initComponents() {
        this.buttonGroup1 = new ButtonGroup();
        this.JSPResultado = new JScrollPane();
        this.JTResultado = new JTable();
        this.JPIDatosBuscar = new JPanel();
        this.JFTFNombrePatologia = new JFormattedTextField();
        this.JPIFBusqueda = new JPanel();
        this.JCHEmpieza = new JCheckBox();
        this.JCHContiene = new JCheckBox();
        this.JCHFiltroPrograma = new JCheckBox();
        setTitle("BÚSQUEDA DE DIAGNOSTICO CIE10");
        setName("BDiagnostico");
        this.JSPResultado.setBorder(BorderFactory.createTitledBorder((Border) null, "RESULTADO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTResultado.setFont(new Font("Arial", 1, 12));
        this.JTResultado.setRowHeight(25);
        this.JTResultado.setSelectionBackground(new Color(255, 255, 255));
        this.JTResultado.setSelectionForeground(Color.red);
        this.JTResultado.setSelectionMode(0);
        this.JTResultado.addMouseListener(new MouseAdapter() { // from class: General.JIFBuscarPatologia.1
            public void mouseClicked(MouseEvent evt) {
                JIFBuscarPatologia.this.JTResultadoMouseClicked(evt);
            }
        });
        this.JSPResultado.setViewportView(this.JTResultado);
        this.JPIDatosBuscar.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JFTFNombrePatologia.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JFTFNombrePatologia.setFont(new Font("Arial", 1, 12));
        this.JFTFNombrePatologia.addKeyListener(new KeyAdapter() { // from class: General.JIFBuscarPatologia.2
            public void keyPressed(KeyEvent evt) {
                JIFBuscarPatologia.this.JFTFNombrePatologiaKeyPressed(evt);
            }

            public void keyReleased(KeyEvent evt) {
                JIFBuscarPatologia.this.JFTFNombrePatologiaKeyReleased(evt);
            }
        });
        this.JPIFBusqueda.setBorder(BorderFactory.createEtchedBorder(Color.white, (Color) null));
        this.buttonGroup1.add(this.JCHEmpieza);
        this.JCHEmpieza.setFont(new Font("Arial", 1, 12));
        this.JCHEmpieza.setForeground(Color.blue);
        this.JCHEmpieza.setText("Comienza por");
        this.JCHEmpieza.addActionListener(new ActionListener() { // from class: General.JIFBuscarPatologia.3
            public void actionPerformed(ActionEvent evt) {
                JIFBuscarPatologia.this.JCHEmpiezaActionPerformed(evt);
            }
        });
        this.buttonGroup1.add(this.JCHContiene);
        this.JCHContiene.setFont(new Font("Arial", 1, 12));
        this.JCHContiene.setForeground(Color.blue);
        this.JCHContiene.setSelected(true);
        this.JCHContiene.setText("Contiene");
        this.JCHContiene.addActionListener(new ActionListener() { // from class: General.JIFBuscarPatologia.4
            public void actionPerformed(ActionEvent evt) {
                JIFBuscarPatologia.this.JCHContieneActionPerformed(evt);
            }
        });
        GroupLayout JPIFBusquedaLayout = new GroupLayout(this.JPIFBusqueda);
        this.JPIFBusqueda.setLayout(JPIFBusquedaLayout);
        JPIFBusquedaLayout.setHorizontalGroup(JPIFBusquedaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFBusquedaLayout.createSequentialGroup().addContainerGap().addComponent(this.JCHContiene).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JCHEmpieza).addContainerGap()));
        JPIFBusquedaLayout.setVerticalGroup(JPIFBusquedaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFBusquedaLayout.createSequentialGroup().addContainerGap().addGroup(JPIFBusquedaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCHContiene).addComponent(this.JCHEmpieza)).addContainerGap(16, 32767)));
        this.JCHFiltroPrograma.setFont(new Font("Arial", 1, 12));
        this.JCHFiltroPrograma.setForeground(Color.blue);
        this.JCHFiltroPrograma.setSelected(true);
        this.JCHFiltroPrograma.setText("Filtro por porgrama");
        this.JCHFiltroPrograma.addActionListener(new ActionListener() { // from class: General.JIFBuscarPatologia.5
            public void actionPerformed(ActionEvent evt) {
                JIFBuscarPatologia.this.JCHFiltroProgramaActionPerformed(evt);
            }
        });
        GroupLayout JPIDatosBuscarLayout = new GroupLayout(this.JPIDatosBuscar);
        this.JPIDatosBuscar.setLayout(JPIDatosBuscarLayout);
        JPIDatosBuscarLayout.setHorizontalGroup(JPIDatosBuscarLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosBuscarLayout.createSequentialGroup().addContainerGap().addComponent(this.JFTFNombrePatologia, -2, 483, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPIDatosBuscarLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHFiltroPrograma).addComponent(this.JPIFBusqueda, -2, -1, -2)).addContainerGap(-1, 32767)));
        JPIDatosBuscarLayout.setVerticalGroup(JPIDatosBuscarLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosBuscarLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosBuscarLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JPIFBusqueda, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addComponent(this.JFTFNombrePatologia, GroupLayout.Alignment.TRAILING)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JCHFiltroPrograma)));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPIDatosBuscar, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addComponent(this.JSPResultado)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatosBuscar, -1, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPResultado, -2, 247, -2).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JFTFNombrePatologiaKeyReleased(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEmpiezaActionPerformed(ActionEvent evt) {
        this.estadob = 0;
        this.JFTFNombrePatologia.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHContieneActionPerformed(ActionEvent evt) {
        this.estadob = 1;
        this.JFTFNombrePatologia.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTResultadoMouseClicked(MouseEvent evt) {
        switch (this.xnombre) {
            case "jpingreso":
                dispose();
                break;
            case "antecedentesFamiliares":
            case "patologiasasociadas":
            case "antecedentesocupacionales":
            case "cirugia":
                mLlenarTextFiel();
                break;
            case "conclusion":
            case "incapacidad":
            case "ReporteP":
            case "Odontolgia":
            case "seguimientopac":
            case "transfusiones":
            case "transporte_asis":
            case "xjpdiagnostico":
            case "patologiaCirugia":
                mLlenarTextFiel();
                break;
            case "digitaciondx":
                if (Principal.clasefacturacion.xjifdigitaciondx != null) {
                    Principal.clasefacturacion.xjifdigitaciondx.xmodelo.setValueAt(this.modelo.getValueAt(this.JTResultado.getSelectedRow(), 0).toString(), Principal.clasefacturacion.xjifdigitaciondx.JTBResultado.getSelectedRow(), Principal.clasefacturacion.xjifdigitaciondx.JTBResultado.getSelectedColumn());
                } else if (Principal.xclasegc.xjifdigitaciondx != null) {
                    Principal.xclasegc.xjifdigitaciondx.xmodelo.setValueAt(this.modelo.getValueAt(this.JTResultado.getSelectedRow(), 0).toString(), Principal.xclasegc.xjifdigitaciondx.JTBResultado.getSelectedRow(), Principal.xclasegc.xjifdigitaciondx.JTBResultado.getSelectedColumn());
                }
                dispose();
                break;
            case "facturacion":
            case "EgresoPyP":
            case "LiqServicios":
                mLlenarTextFiel1();
                break;
            case "diagnostico_activos":
                this.xclase.xmodeloDiagActivo.setValueAt(this.modelo.getValueAt(this.JTResultado.getSelectedRow(), 0).toString(), this.xclase.JTDiagActivos.getSelectedRow(), 4);
                dispose();
                break;
            case "dxodontograma":
                this.xJPOdontograma.JCBDx.setSelectedItem(this.modelo.getValueAt(this.JTResultado.getSelectedRow(), 0) + " " + this.modelo.getValueAt(this.JTResultado.getSelectedRow(), 1));
                dispose();
                break;
            case "historia_fisioterapia":
                mLlenarTextFiel();
                break;
            case "recien_nacidos":
                mLlenarTextFiel();
                break;
            case "Cirugias":
                mLlenarTextFiel2();
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHFiltroProgramaActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JFTFNombrePatologiaKeyPressed(KeyEvent evt) {
        if (!this.JFTFNombrePatologia.getText().isEmpty()) {
            mBuscar();
        }
    }

    private void mBuscar() {
        String sql;
        try {
            mCrearTabla();
            if (this.xnombre.equals("conclusion")) {
                if (Principal.informacionIps.getFiltroPatologiaPrograma().intValue() == 1) {
                    if (this.JCHFiltroPrograma.isSelected() && clasesHistoriaCE.informacionAgendaMedicaDTO.getIdPrograma().intValue() != 0) {
                        if (this.estadob == 0) {
                            sql = "SELECT\n    `g_patologia`.`Id`\n    , `g_patologia`.`Nbre`\nFROM\n    `g_patologia_programa`\n    INNER JOIN `g_patologia` \n        ON (`g_patologia_programa`.`Id_Patologia` = `g_patologia`.`Id`)\nWHERE (`g_patologia`.`Nbre` =like '" + this.JFTFNombrePatologia.getText() + "%'\n    AND `g_patologia_programa`.`Id_Programa` ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdPrograma() + "'\n    AND `g_patologia_programa`.`Estado` =1)";
                        } else {
                            sql = "SELECT\n    `g_patologia`.`Id`\n    , `g_patologia`.`Nbre`\nFROM\n    `g_patologia_programa`\n    INNER JOIN `g_patologia` \n        ON (`g_patologia_programa`.`Id_Patologia` = `g_patologia`.`Id`)\nWHERE (`g_patologia`.`Nbre` like '%" + this.JFTFNombrePatologia.getText() + "%'\n    AND `g_patologia_programa`.`Id_Programa` ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdPrograma() + "'\n    AND `g_patologia_programa`.`Estado` =1)";
                        }
                    } else if (this.estadob == 0) {
                        sql = "SELECT Id, Nbre FROM g_patologia WHERE (Nbre like '" + this.JFTFNombrePatologia.getText() + "%' and Estado=1) ORDER BY Nbre ASC";
                    } else {
                        sql = "SELECT Id, Nbre FROM g_patologia WHERE  (Nbre like '%" + this.JFTFNombrePatologia.getText() + "%' and Estado=1) ORDER BY Nbre ASC";
                    }
                } else if (this.estadob == 0) {
                    sql = "SELECT Id, Nbre FROM g_patologia WHERE (Nbre like '" + this.JFTFNombrePatologia.getText() + "%' and Estado=1) ORDER BY Nbre ASC";
                } else {
                    sql = "SELECT Id, Nbre FROM g_patologia WHERE  (Nbre like '%" + this.JFTFNombrePatologia.getText() + "%' and Estado=1) ORDER BY Nbre ASC";
                }
            } else if (this.estadob == 0) {
                sql = "SELECT Id, Nbre FROM g_patologia WHERE (Nbre like '" + this.JFTFNombrePatologia.getText() + "%' and Estado=1) ORDER BY Nbre ASC";
            } else {
                sql = "SELECT Id, Nbre FROM g_patologia WHERE  (Nbre like '%" + this.JFTFNombrePatologia.getText() + "%' and Estado=1) ORDER BY Nbre ASC";
            }
            ResultSet res = this.consultas.traerRs(sql);
            if (res.next()) {
                res.beforeFirst();
                int nfila1 = 0;
                this.metodos.mEstablecerTextEditor(this.JTResultado, 1);
                while (res.next()) {
                    this.modelo.addRow(this.dato);
                    this.modelo.setValueAt(res.getString(1), nfila1, 0);
                    this.modelo.setValueAt(res.getString(2), nfila1, 1);
                    nfila1++;
                }
            }
            res.close();
            this.consultas.cerrarConexionBd();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void mLlenarTextFiel() {
        this.codigo.setText(this.modelo.getValueAt(this.JTResultado.getSelectedRow(), 0).toString());
        this.nombrep.setText(this.modelo.getValueAt(this.JTResultado.getSelectedRow(), 1).toString());
        System.out.println(this.codigo.getText() + " - " + this.nombrep.getText());
        this.codigo.requestFocus();
        dispose();
    }

    private void mLlenarTextFiel1() {
        this.codigo.setText(this.modelo.getValueAt(this.JTResultado.getSelectedRow(), 0).toString());
        dispose();
        this.codigo.requestFocus();
    }

    private void mLlenarTextFiel2() {
        this.codigo.setText(this.modelo.getValueAt(this.JTResultado.getSelectedRow(), 0).toString());
        this.nombrep.setText(this.modelo.getValueAt(this.JTResultado.getSelectedRow(), 1).toString());
        dispose();
        this.codigo.requestFocus();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTabla() {
        this.modelo = new DefaultTableModel(new Object[0], new String[]{"Código", "Nombre"}) { // from class: General.JIFBuscarPatologia.6
            Class[] types = {String.class, String.class};
            boolean[] canEdit = {false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTResultado;
        JTable jTable2 = this.JTResultado;
        jTable.setAutoResizeMode(0);
        this.JTResultado.doLayout();
        this.JTResultado.setModel(this.modelo);
        this.JTResultado.getColumnModel().getColumn(0).setPreferredWidth(80);
        this.JTResultado.getColumnModel().getColumn(1).setPreferredWidth(600);
    }
}
