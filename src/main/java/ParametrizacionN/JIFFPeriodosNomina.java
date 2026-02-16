package ParametrizacionN;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:ParametrizacionN/JIFFPeriodosNomina.class */
public class JIFFPeriodosNomina extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private Object[] xdatos;
    private String[] xIdTipoManual;
    private JCheckBox JCHEstado;
    private JSpinner JSNoDias;
    private JTextField JTFAl;
    private JTextField JTFDel;
    private JTextField JTFNombre;
    private JTable JTHistorico;
    private JPanel jPanel1;
    private JScrollPane jScrollPane1;
    private int xEstado = 1;
    private ConsultasMySQL xct = new ConsultasMySQL();
    private Metodos xmt = new Metodos();

    public JIFFPeriodosNomina() {
        initComponents();
        mNuevo();
        mCargarDatosTabla();
    }

    public void mGrabar() {
        String sql;
        if (!this.JTFNombre.getText().isEmpty()) {
            if (!this.JTFDel.getText().isEmpty()) {
                if (!this.JTFAl.getText().isEmpty()) {
                    int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    if (n == 0) {
                        if (Principal.txtNo.getText().isEmpty()) {
                            sql = " Insert into rh_nomina_periodo(`Nbre`, `Del` , `Al`  ,`NDias`, `Estado` , `UsuariS`)  values ('" + this.JTFNombre.getText().toUpperCase() + "','" + this.JTFDel.getText().toUpperCase() + "','" + this.JTFAl.getText().toUpperCase() + "','" + this.JSNoDias.getValue() + "','" + this.xEstado + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                        } else {
                            sql = " update rh_nomina_periodo set Nbre='" + this.JTFNombre.getText().toUpperCase() + "', Estado='" + this.xEstado + "', UsuariS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
                        }
                        this.xct.ejecutarSQL(sql);
                        this.xct.cerrarConexionBd();
                        mCargarDatosTabla();
                        mNuevo();
                        return;
                    }
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Digite la fecha que termina la quincena", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JTFAl.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Digite la fecha que inicia la quincena", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTFDel.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "El nombre no puede ser nulo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JTFNombre.requestFocus();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Nombre", "Del", "Al", "No Días", "Estado"}) { // from class: ParametrizacionN.JIFFPeriodosNomina.1
            Class[] types = {Long.class, String.class, String.class, String.class, Integer.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTHistorico.setModel(this.xmodelo);
        this.JTHistorico.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTHistorico.getColumnModel().getColumn(1).setPreferredWidth(50);
        this.JTHistorico.getColumnModel().getColumn(2).setPreferredWidth(50);
        this.JTHistorico.getColumnModel().getColumn(3).setPreferredWidth(50);
        this.JTHistorico.getColumnModel().getColumn(4).setPreferredWidth(50);
        this.JTHistorico.getColumnModel().getColumn(5).setPreferredWidth(30);
    }

    private void mCargarDatosTabla() {
        try {
            mCrearModeloDatos();
            ResultSet xrs = this.xct.traerRs("SELECT `Id`, `Nbre`, `Del`, `Al`, `NDias`, `Estado` FROM `rh_nomina_periodo` ORDER BY rh_nomina_periodo.Nbre ASC");
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(Integer.valueOf(xrs.getInt(1)), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelo.setValueAt(xrs.getString(4), n, 3);
                    this.xmodelo.setValueAt(Integer.valueOf(xrs.getInt(5)), n, 4);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(6)), n, 5);
                    n++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFTipoEncuesta.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mNuevo() {
        Principal.mLimpiarDatosP();
        this.JTFNombre.setText("");
        this.JTFDel.setText("");
        this.JTFAl.setText("");
        this.JCHEstado.setSelected(true);
        this.xEstado = 1;
    }

    /* JADX WARN: Type inference failed for: r3v43, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jPanel1 = new JPanel();
        this.JTFNombre = new JTextField();
        this.JCHEstado = new JCheckBox();
        this.JTFDel = new JTextField();
        this.JTFAl = new JTextField();
        this.JSNoDias = new JSpinner();
        this.jScrollPane1 = new JScrollPane();
        this.JTHistorico = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("PERIODOS DE NÓMINA");
        setToolTipText("");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("Periodos de Nómina");
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTFNombre.setFont(new Font("Arial", 1, 12));
        this.JTFNombre.setToolTipText("");
        this.JTFNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setSelected(true);
        this.JCHEstado.setText("Estado");
        this.JCHEstado.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFPeriodosNomina.2
            public void actionPerformed(ActionEvent evt) {
                JIFFPeriodosNomina.this.JCHEstadoActionPerformed(evt);
            }
        });
        this.JTFDel.setFont(new Font("Arial", 1, 12));
        this.JTFDel.setToolTipText("");
        this.JTFDel.setBorder(BorderFactory.createTitledBorder((Border) null, "Del", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFAl.setFont(new Font("Arial", 1, 12));
        this.JTFAl.setToolTipText("");
        this.JTFAl.setBorder(BorderFactory.createTitledBorder((Border) null, "Al", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFAl.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFPeriodosNomina.3
            public void actionPerformed(ActionEvent evt) {
                JIFFPeriodosNomina.this.JTFAlActionPerformed(evt);
            }
        });
        this.JSNoDias.setFont(new Font("Arial", 1, 12));
        this.JSNoDias.setModel(new SpinnerNumberModel(1, 1, (Comparable) null, 1));
        this.JSNoDias.setBorder(BorderFactory.createTitledBorder((Border) null, "No Días", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JTFNombre, -2, 133, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFDel, -2, 133, -2).addGap(18, 18, 18).addComponent(this.JTFAl, -2, 133, -2).addGap(18, 18, 18).addComponent(this.JSNoDias, -2, 87, -2).addGap(18, 18, 18).addComponent(this.JCHEstado).addContainerGap(16, 32767)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFNombre, -2, 50, -2).addComponent(this.JTFDel, -2, 50, -2).addComponent(this.JTFAl, -2, 50, -2).addComponent(this.JSNoDias, -2, 50, -2).addComponent(this.JCHEstado)).addGap(10, 10, 10)));
        this.jScrollPane1.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTHistorico.setFont(new Font("Arial", 1, 12));
        this.JTHistorico.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTHistorico.setSelectionBackground(new Color(255, 255, 255));
        this.JTHistorico.setSelectionForeground(Color.red);
        this.JTHistorico.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFFPeriodosNomina.4
            public void mouseClicked(MouseEvent evt) {
                JIFFPeriodosNomina.this.JTHistoricoMouseClicked(evt);
            }
        });
        this.jScrollPane1.setViewportView(this.JTHistorico);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.jPanel1, -2, -1, -2).addGap(10, 10, 10)).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane1, -2, 643, -2).addContainerGap(-1, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jScrollPane1, -1, 355, 32767).addGap(6, 6, 6)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEstadoActionPerformed(ActionEvent evt) {
        if (this.JCHEstado.isSelected()) {
            this.xEstado = 1;
        } else {
            this.xEstado = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTHistoricoMouseClicked(MouseEvent evt) {
        if (this.JTHistorico.getSelectedRow() != -1) {
            Principal.txtNo.setText(this.xmodelo.getValueAt(this.JTHistorico.getSelectedRow(), 0).toString());
            this.JTFNombre.setText(this.xmodelo.getValueAt(this.JTHistorico.getSelectedRow(), 1).toString());
            this.JTFDel.setText(this.xmodelo.getValueAt(this.JTHistorico.getSelectedRow(), 2).toString());
            this.JTFAl.setText(this.xmodelo.getValueAt(this.JTHistorico.getSelectedRow(), 3).toString());
            this.JSNoDias.setValue(this.xmodelo.getValueAt(this.JTHistorico.getSelectedRow(), 4));
            this.JCHEstado.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTHistorico.getSelectedRow(), 5).toString()).booleanValue());
            if (Boolean.valueOf(this.xmodelo.getValueAt(this.JTHistorico.getSelectedRow(), 5).toString()).booleanValue()) {
                this.xEstado = 1;
            } else {
                this.xEstado = 0;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFAlActionPerformed(ActionEvent evt) {
    }
}
