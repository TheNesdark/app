package Odontologia;

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
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Odontologia/JDProcedimientosOdont.class */
public class JDProcedimientosOdont extends JDialog {
    private DefaultTableModel xmodelo;
    private Object[] xdatos;
    ConsultasMySQL xct;
    Metodos xmt;
    private String[] xidgrupo;
    private boolean xlleno;
    private String xllamador;
    private JPOdontogramaClinico xJPOdontogramaClinico;
    private JComboBox JCBGrupos;
    private JCheckBox JCHFiltro;
    private JTable JTDetalle;
    private JTextField JTFNombre;
    private JScrollPane jScrollPane1;

    public JDProcedimientosOdont(Frame parent, boolean modal, JPOdontogramaClinico xJPOdontogramaClinico, String xllamador) {
        super(parent, modal);
        this.xct = new ConsultasMySQL();
        this.xmt = new Metodos();
        this.xlleno = false;
        this.xllamador = "";
        initComponents();
        this.xJPOdontogramaClinico = xJPOdontogramaClinico;
        setTitle("BÚSQUEDA DE PROCEDIMIENTOS ODONTOLÓGICOS");
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        setLocationRelativeTo(null);
        this.xllamador = xllamador;
        mCargarDatosTabla();
        this.xidgrupo = this.xct.llenarCombo("SELECT `Id`,`Nbre` FROM `o_grupo_pro_cup` WHERE (Estado=1 AND Id<>1)", this.xidgrupo, this.JCBGrupos);
        this.JCBGrupos.setSelectedIndex(-1);
        this.xlleno = true;
        this.xct.cerrarConexionBd();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Nombre"}) { // from class: Odontologia.JDProcedimientosOdont.1
            Class[] types = {Long.class, String.class};
            boolean[] canEdit = {false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(450);
    }

    /* JADX WARN: Type inference failed for: r3v11, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JTFNombre = new JTextField();
        this.JCBGrupos = new JComboBox();
        this.JCHFiltro = new JCheckBox();
        this.jScrollPane1 = new JScrollPane();
        this.JTDetalle = new JTable();
        setDefaultCloseOperation(2);
        this.JTFNombre.setFont(new Font("Arial", 1, 12));
        this.JTFNombre.setToolTipText("");
        this.JTFNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFNombre.addKeyListener(new KeyAdapter() { // from class: Odontologia.JDProcedimientosOdont.2
            public void keyPressed(KeyEvent evt) {
                JDProcedimientosOdont.this.JTFNombreKeyPressed(evt);
            }
        });
        this.JCBGrupos.setFont(new Font("Arial", 1, 12));
        this.JCBGrupos.setBorder(BorderFactory.createTitledBorder((Border) null, "Grupos", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBGrupos.setEnabled(false);
        this.JCBGrupos.addItemListener(new ItemListener() { // from class: Odontologia.JDProcedimientosOdont.3
            public void itemStateChanged(ItemEvent evt) {
                JDProcedimientosOdont.this.JCBGruposItemStateChanged(evt);
            }
        });
        this.JCHFiltro.setFont(new Font("Arial", 1, 12));
        this.JCHFiltro.setText("Filtro?");
        this.JCHFiltro.addActionListener(new ActionListener() { // from class: Odontologia.JDProcedimientosOdont.4
            public void actionPerformed(ActionEvent evt) {
                JDProcedimientosOdont.this.JCHFiltroActionPerformed(evt);
            }
        });
        this.jScrollPane1.setBorder(BorderFactory.createTitledBorder((Border) null, "RESULTADO", 2, 0, new Font("Arial", 1, 14), new Color(0, 107, 0)));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: Odontologia.JDProcedimientosOdont.5
            public void mouseClicked(MouseEvent evt) {
                JDProcedimientosOdont.this.JTDetalleMouseClicked(evt);
            }
        });
        this.jScrollPane1.setViewportView(this.JTDetalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane1, -1, 749, 32767).addGroup(layout.createSequentialGroup().addComponent(this.JTFNombre, -2, 417, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBGrupos, 0, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHFiltro))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(7, 7, 7).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFNombre, -2, -1, -2).addComponent(this.JCBGrupos, -2, -1, -2).addComponent(this.JCHFiltro)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jScrollPane1, -1, 365, 32767).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNombreKeyPressed(KeyEvent evt) {
        mCargarDatosTabla();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBGruposItemStateChanged(ItemEvent evt) {
        if (this.xlleno && this.JCBGrupos.getSelectedIndex() != -1) {
            mCargarDatosTabla();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHFiltroActionPerformed(ActionEvent evt) {
        if (this.JCHFiltro.isSelected()) {
            this.JCBGrupos.setEnabled(true);
        } else {
            this.JCBGrupos.setSelectedIndex(-1);
            this.JCBGrupos.setEnabled(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        this.xJPOdontogramaClinico.llenaComboProcedimientos();
        if (this.xllamador.equals("procedimientos")) {
            this.xJPOdontogramaClinico.JCBProcedimiento.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1));
        } else {
            this.xJPOdontogramaClinico.JCBOProcedimiento.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1));
        }
        dispose();
    }

    private void mCargarDatosTabla() {
        String sql;
        try {
            mCrearModeloDatos();
            if (this.JTFNombre.getText().isEmpty() && !this.JCHFiltro.isSelected()) {
                sql = "SELECT  `Id` , `Nbre` FROM `g_procedimiento`  where EsOdontologico=1 ORDER BY Nbre";
            } else if (this.JCHFiltro.isSelected() && this.JCBGrupos.getSelectedIndex() != -1) {
                sql = "SELECT `o_proced_x_grupo`.`IdProcedimiento` , `g_procedimiento`.`Nbre`  FROM `o_proced_x_grupo`  INNER JOIN   `g_procedimiento`    ON (`o_proced_x_grupo`.`IdProcedimiento` = `g_procedimiento`.`Id`)  WHERE (`o_proced_x_grupo`.`IdGrupo` ='" + this.xidgrupo[this.JCBGrupos.getSelectedIndex()] + "' AND g_procedimiento.Nbre LIKE '%" + this.JTFNombre.getText() + "%')";
            } else {
                sql = "SELECT  `Id` , `Nbre` FROM `g_procedimiento` WHERE(Nbre LIKE '%" + this.JTFNombre.getText() + "%' and EsOdontologico=1) ORDER BY Nbre";
            }
            ResultSet xrs = this.xct.traerRs(sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(xrs.getString(1), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    n++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JDProcedimientosOdont.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }
}
