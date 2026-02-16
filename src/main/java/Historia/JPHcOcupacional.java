package Historia;

import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Historia/JPHcOcupacional.class */
public class JPHcOcupacional extends JPanel {
    private String[] xidcargo;
    private String[] xidunidadnego;
    private String[] xidturno;
    private DefaultTableModel xmodelo;
    private Metodos xmt = new Metodos();
    private ConsultasMySQL xct = new ConsultasMySQL();
    private clasesHistoriaCE xclase;
    private int xmod;
    private Object[] xdato;
    private JButton JBTAdicionarAntCli;
    private JComboBox JCBCargo;
    private JComboBox JCBTurno;
    private JComboBox JCBUnidadNeg;
    private JScrollPane JSPHistorial;
    private JTable JTHistorial;
    private JTabbedPane JTPDatosOcupacionales;
    private JPanel jPanel1;

    public JPHcOcupacional(clasesHistoriaCE xclase, int xmod) {
        this.xmod = -1;
        initComponents();
        this.xmod = xmod;
        this.xclase = xclase;
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v15, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JTPDatosOcupacionales = new JTabbedPane();
        this.jPanel1 = new JPanel();
        this.JCBCargo = new JComboBox();
        this.JCBUnidadNeg = new JComboBox();
        this.JCBTurno = new JComboBox();
        this.JBTAdicionarAntCli = new JButton();
        this.JSPHistorial = new JScrollPane();
        this.JTHistorial = new JTable();
        this.JTPDatosOcupacionales.setForeground(new Color(0, 103, 0));
        this.JTPDatosOcupacionales.setFont(new Font("Arial", 1, 14));
        this.JCBCargo.setFont(new Font("Arial", 1, 12));
        this.JCBCargo.setBorder(BorderFactory.createTitledBorder((Border) null, "Cargo Actual a Desempeñar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBUnidadNeg.setFont(new Font("Arial", 1, 12));
        this.JCBUnidadNeg.setBorder(BorderFactory.createTitledBorder((Border) null, "Unidad de Negocio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTurno.setFont(new Font("Arial", 1, 12));
        this.JCBTurno.setBorder(BorderFactory.createTitledBorder((Border) null, "Turno", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBTAdicionarAntCli.setFont(new Font("Arial", 1, 14));
        this.JBTAdicionarAntCli.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JSPHistorial.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTORIAL", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTHistorial.setFont(new Font("Arial", 1, 12));
        this.JTHistorial.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTHistorial.setRowHeight(25);
        this.JTHistorial.setSelectionBackground(new Color(255, 255, 255));
        this.JTHistorial.setSelectionForeground(new Color(255, 0, 0));
        this.JTHistorial.setSelectionMode(0);
        this.JSPHistorial.setViewportView(this.JTHistorial);
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JSPHistorial, GroupLayout.Alignment.LEADING, -1, 790, 32767).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JCBTurno, GroupLayout.Alignment.LEADING, 0, -1, 32767).addComponent(this.JCBCargo, GroupLayout.Alignment.LEADING, 0, 353, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JBTAdicionarAntCli, -1, 431, 32767).addComponent(this.JCBUnidadNeg, 0, 431, 32767)))).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBCargo, -2, -1, -2).addComponent(this.JCBUnidadNeg, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JBTAdicionarAntCli, -1, 54, 32767).addComponent(this.JCBTurno, GroupLayout.Alignment.LEADING, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPHistorial, -1, 161, 32767).addContainerGap()));
        this.JTPDatosOcupacionales.addTab("INF. OCUPACIONAL", this.jPanel1);
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTPDatosOcupacionales).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTPDatosOcupacionales).addContainerGap()));
    }

    public void mNuevo() {
        this.JCBCargo.removeAllItems();
        this.xidcargo = this.xct.llenarCombo("SELECT Id, Nbre FROM g_cargos WHERE (Estado =1) ORDER BY Nbre ASC", this.xidcargo, this.JCBCargo);
        this.JCBCargo.setSelectedIndex(-1);
        this.JCBUnidadNeg.removeAllItems();
        this.xidunidadnego = this.xct.llenarCombo("SELECT Id, Nbre FROM g_tipounidadnegocio WHERE (Estado =0) ORDER BY Nbre ASC", this.xidunidadnego, this.JCBUnidadNeg);
        this.JCBUnidadNeg.setSelectedIndex(-1);
        this.JCBTurno.removeAllItems();
        this.xidturno = this.xct.llenarCombo("SELECT Id , Nbre FROM g_turnos WHERE (Estado =1) ORDER BY Nbre ASC", this.xidturno, this.JCBTurno);
        this.JCBTurno.setSelectedIndex(-1);
        mCrearTabla();
        this.xct.cerrarConexionBd();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTabla() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Cargo", "Unidad Negocio", "Turno"}) { // from class: Historia.JPHcOcupacional.1
            Class[] types = {Integer.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTHistorial.setModel(this.xmodelo);
        this.JTHistorial.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTHistorial.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTHistorial.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTHistorial.getColumnModel().getColumn(1).setPreferredWidth(50);
        this.JTHistorial.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTHistorial.getColumnModel().getColumn(3).setPreferredWidth(50);
    }
}
