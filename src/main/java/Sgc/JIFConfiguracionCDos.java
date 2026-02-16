package Sgc;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Sgc/JIFConfiguracionCDos.class */
public class JIFConfiguracionCDos extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private Object[] xdato;
    private Metodos xmetodos = new Metodos();
    private ConsultasMySQL xconsultas = new ConsultasMySQL();
    private String xsql = null;
    private int xestado = 1;
    private boolean xguardado = false;
    private String[] xidtipoproceso;
    private String[] xidproceso;
    private JComboBox JCBProceso;
    private JComboBox JCBTipoProceso;
    private JLabel JLBTitulo;
    private JScrollPane JSPDetalle;
    private JTable JTBDetalle;

    public JIFConfiguracionCDos(String xtitulo) {
        initComponents();
        this.JLBTitulo.setText(xtitulo);
        this.xidtipoproceso = this.xconsultas.llenarCombo("SELECT Id, Nbre FROM baseserver.s_tipoproceso WHERE (Estado =1) ORDER BY Nbre ASC", this.xidtipoproceso, this.JCBTipoProceso);
        this.JCBTipoProceso.setSelectedIndex(-1);
        this.xconsultas.cerrarConexionBd();
        this.xidproceso = this.xconsultas.llenarCombo("SELECT Id, Nbre FROM baseserver.s_procesos WHERE (Estado =1) ORDER BY Nbre ASC", this.xidproceso, this.JCBProceso);
        this.JCBProceso.setSelectedIndex(-1);
        this.xconsultas.cerrarConexionBd();
        mCrearTabla();
        mCargarDatosTabla();
    }

    /* JADX WARN: Type inference failed for: r3v9, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JLBTitulo = new JLabel();
        this.JSPDetalle = new JScrollPane();
        this.JTBDetalle = new JTable();
        this.JCBTipoProceso = new JComboBox();
        this.JCBProceso = new JComboBox();
        setClosable(true);
        setIconifiable(true);
        setTitle("CONFIGURACIÓN");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifsgcconfiguracioncdos");
        this.JLBTitulo.setFont(new Font("Arial", 1, 18));
        this.JLBTitulo.setForeground(new Color(0, 102, 102));
        this.JLBTitulo.setHorizontalAlignment(0);
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JSPDetalle.setFont(new Font("Arial", 1, 12));
        this.JTBDetalle.setFont(new Font("Arial", 1, 12));
        this.JTBDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTBDetalle.setRowHeight(25);
        this.JTBDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTBDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTBDetalle.setSelectionMode(0);
        this.JTBDetalle.addMouseListener(new MouseAdapter() { // from class: Sgc.JIFConfiguracionCDos.1
            public void mouseClicked(MouseEvent evt) {
                JIFConfiguracionCDos.this.JTBDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTBDetalle);
        this.JCBTipoProceso.setFont(new Font("Arial", 1, 12));
        this.JCBTipoProceso.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo proceso", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBProceso.setFont(new Font("Arial", 1, 12));
        this.JCBProceso.setBorder(BorderFactory.createTitledBorder((Border) null, "Procesos", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup().addComponent(this.JLBTitulo, -1, 1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBTipoProceso, -2, 521, -2)).addGroup(layout.createSequentialGroup().addGap(0, 0, 32767).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JSPDetalle, -2, 521, -2).addComponent(this.JCBProceso, -2, 521, -2)))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLBTitulo, -2, 31, -2).addComponent(this.JCBTipoProceso, -2, 50, -2)).addGap(18, 18, 18).addComponent(this.JCBProceso, -2, 50, -2).addGap(18, 18, 18).addComponent(this.JSPDetalle, -1, 231, 32767).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBDetalleMouseClicked(MouseEvent evt) {
        if (this.JTBDetalle.getSelectedRow() != -1) {
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTabla() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Tipo Proceso", "Id", "Proceso"}) { // from class: Sgc.JIFConfiguracionCDos.2
            Class[] types = {Integer.class, String.class, Integer.class, String.class};
            boolean[] canEdit = {false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTBDetalle.setModel(this.xmodelo);
        this.JTBDetalle.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(1).setPreferredWidth(200);
        this.JTBDetalle.getColumnModel().getColumn(2).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(2).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(2).setMaxWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(3).setPreferredWidth(200);
    }

    public void nuevo() {
        this.JCBTipoProceso.setSelectedIndex(-1);
        this.JCBProceso.setSelectedIndex(-1);
        this.JCBTipoProceso.requestFocus();
        this.xguardado = false;
    }

    private boolean mVerificar() {
        boolean xestadov = false;
        if (this.JCBTipoProceso.getSelectedIndex() != -1) {
            if (this.JCBProceso.getSelectedIndex() != -1) {
                xestadov = true;
            } else {
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar el proceso", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                this.JCBProceso.requestFocus();
            }
        } else {
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar el tpo de proceso", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
            this.JCBTipoProceso.requestFocus();
        }
        return xestadov;
    }

    private void mCargarDatosTabla() {
        try {
            if (this.JLBTitulo.getText().equals("PROCESO X TIPO")) {
                this.xsql = "SELECT s_tipoproceso.Id, s_tipoproceso.Nbre, s_procesos.Id, s_procesos.Nbre FROM baseserver.s_procesoxtipoproceso INNER JOIN baseserver.s_tipoproceso  ON (s_procesoxtipoproceso.ID_TIPO_PROCESO = s_tipoproceso.Id) INNER JOIN baseserver.s_procesos  ON (s_procesoxtipoproceso.ID_PROCESO = s_procesos.Id) ORDER BY s_tipoproceso.Nbre ASC, s_procesos.Nbre ASC ";
            }
            ResultSet rs = this.xconsultas.traerRs(this.xsql);
            if (rs.next()) {
                rs.beforeFirst();
                int x = 0;
                while (rs.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(Integer.valueOf(rs.getInt(1)), x, 0);
                    this.xmodelo.setValueAt(rs.getString(2), x, 1);
                    this.xmodelo.setValueAt(Integer.valueOf(rs.getInt(3)), x, 2);
                    this.xmodelo.setValueAt(rs.getString(4), x, 3);
                    x++;
                }
            }
            rs.close();
            this.xconsultas.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFConfiguracionCDos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void grabar() {
        if (mVerificar()) {
            int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                if (this.JLBTitulo.getText().equals("PROCESO X TIPO")) {
                    this.xsql = "insert ignore into  s_procesoxtipoproceso (ID_TIPO_PROCESO, ID_PROCESO, USUARIO, FECHA) values('" + this.xidtipoproceso[this.JCBTipoProceso.getSelectedIndex()] + "','" + this.xidproceso[this.JCBProceso.getSelectedIndex()] + "','" + Principal.usuarioSistemaDTO.getLogin() + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "')";
                }
                this.xconsultas.ejecutarSQL(this.xsql);
                this.xconsultas.cerrarConexionBd();
                mCrearTabla();
                mCargarDatosTabla();
                nuevo();
            }
        }
    }
}
