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
import java.beans.PropertyVetoException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:ParametrizacionN/JIFSPresentacionFarmaceuta.class */
public class JIFSPresentacionFarmaceuta extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private Object[] xdatos;
    private String[] xidformafarm;
    private JIFSSuministro xjifsuministro;
    private JComboBox JCBFormaFarmaceutica;
    private JCheckBox JCHEsAmpolla;
    private JCheckBox JCHEsFacturable;
    private JCheckBox JCHEstado;
    private JPanel JPIDatos;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;
    private JTextField JTFAdministracion;
    private JTextField JTFDosis;
    private JTextField JTFInvima;
    private JTextField JTFNombre;
    private ConsultasMySQL xconsulta = new ConsultasMySQL();
    private Metodos xmetodos = new Metodos();
    private int xestado = 0;
    private int xesampolla = 0;
    private int xesfacturable = 0;
    private String xid = "";
    private boolean xestadog = false;

    public JIFSPresentacionFarmaceuta(JIFSSuministro xjifsuministro) {
        initComponents();
        this.xjifsuministro = xjifsuministro;
        this.xidformafarm = this.xconsulta.llenarCombo("SELECT Id, Nbre FROM baseserver.i_formafarmaceutica WHERE (Estado =0) ORDER BY Nbre ASC", this.xidformafarm, this.JCBFormaFarmaceutica);
        this.JCBFormaFarmaceutica.setSelectedIndex(-1);
        this.xconsulta.cerrarConexionBd();
        mCargarDatosTabla();
    }

    /* JADX WARN: Type inference failed for: r3v41, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPIDatos = new JPanel();
        this.JTFNombre = new JTextField();
        this.JCBFormaFarmaceutica = new JComboBox();
        this.JCHEstado = new JCheckBox();
        this.JTFAdministracion = new JTextField();
        this.JTFDosis = new JTextField();
        this.JCHEsAmpolla = new JCheckBox();
        this.JCHEsFacturable = new JCheckBox();
        this.JTFInvima = new JTextField();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        setTitle("PRESENTACIÓN FARMACÉUTICA");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifpresentacionfarma");
        try {
            setSelected(true);
        } catch (PropertyVetoException e1) {
            e1.printStackTrace();
        }
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTFNombre.setFont(new Font("Arial", 1, 12));
        this.JTFNombre.setToolTipText("");
        this.JTFNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBFormaFarmaceutica.setFont(new Font("Arial", 1, 12));
        this.JCBFormaFarmaceutica.setBorder(BorderFactory.createTitledBorder((Border) null, "Forma Farmacéutica", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setSelected(true);
        this.JCHEstado.setText("Estado");
        this.JCHEstado.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFSPresentacionFarmaceuta.1
            public void actionPerformed(ActionEvent evt) {
                JIFSPresentacionFarmaceuta.this.JCHEstadoActionPerformed(evt);
            }
        });
        this.JTFAdministracion.setFont(new Font("Arial", 1, 12));
        this.JTFAdministracion.setToolTipText("");
        this.JTFAdministracion.setBorder(BorderFactory.createTitledBorder((Border) null, "Administración", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFDosis.setFont(new Font("Arial", 1, 12));
        this.JTFDosis.setToolTipText("");
        this.JTFDosis.setBorder(BorderFactory.createTitledBorder((Border) null, "Dosis", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHEsAmpolla.setFont(new Font("Arial", 1, 12));
        this.JCHEsAmpolla.setText("Es Ampolla?");
        this.JCHEsAmpolla.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFSPresentacionFarmaceuta.2
            public void actionPerformed(ActionEvent evt) {
                JIFSPresentacionFarmaceuta.this.JCHEsAmpollaActionPerformed(evt);
            }
        });
        this.JCHEsFacturable.setFont(new Font("Arial", 1, 12));
        this.JCHEsFacturable.setText("Es Facturable?");
        this.JCHEsFacturable.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFSPresentacionFarmaceuta.3
            public void actionPerformed(ActionEvent evt) {
                JIFSPresentacionFarmaceuta.this.JCHEsFacturableActionPerformed(evt);
            }
        });
        this.JTFInvima.setFont(new Font("Arial", 1, 12));
        this.JTFInvima.setToolTipText("");
        this.JTFInvima.setBorder(BorderFactory.createTitledBorder((Border) null, "No Invima", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JTFInvima, -2, 130, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFNombre, -2, 306, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBFormaFarmaceutica, 0, -1, 32767).addContainerGap()).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JTFAdministracion, -2, 298, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFDosis, -2, 262, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHEsAmpolla).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHEsFacturable).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JCHEstado).addGap(18, 18, 18)))));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFNombre, -2, -1, -2).addComponent(this.JCBFormaFarmaceutica, -2, -1, -2).addComponent(this.JTFInvima, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFAdministracion, -2, -1, -2).addComponent(this.JTFDosis, -2, -1, -2).addComponent(this.JCHEstado).addComponent(this.JCHEsAmpolla).addComponent(this.JCHEsFacturable)).addGap(10, 10, 10)));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalle.setSelectionMode(0);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFSPresentacionFarmaceuta.4
            public void mouseClicked(MouseEvent evt) {
                JIFSPresentacionFarmaceuta.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JPIDatos, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.JSPDetalle, GroupLayout.Alignment.LEADING)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addGap(10, 10, 10).addComponent(this.JSPDetalle, -2, 263, -2).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEstadoActionPerformed(ActionEvent evt) {
        if (this.JCHEstado.isSelected()) {
            this.xestado = 0;
        } else {
            this.xestado = 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            this.xid = this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString();
            this.JTFNombre.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString());
            this.JCBFormaFarmaceutica.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString());
            this.JTFAdministracion.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString());
            this.JTFDosis.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 4).toString());
            this.JCHEsAmpolla.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 5).toString()).booleanValue());
            this.JCHEsFacturable.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 6).toString()).booleanValue());
            this.JCHEstado.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 7).toString()).booleanValue());
            if (this.JCHEstado.isSelected()) {
                this.xestado = 0;
            } else {
                this.xestado = 1;
            }
            if (this.JCHEsFacturable.isSelected()) {
                this.xesfacturable = 1;
            } else {
                this.xesfacturable = 0;
            }
            this.JTFInvima.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 8).toString());
            this.xestadog = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEsAmpollaActionPerformed(ActionEvent evt) {
        if (this.JCHEsAmpolla.isSelected()) {
            this.xesampolla = 1;
        } else {
            this.xesampolla = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEsFacturableActionPerformed(ActionEvent evt) {
        if (this.JCHEsFacturable.isSelected()) {
            this.xesfacturable = 1;
        } else {
            this.xesfacturable = 0;
        }
    }

    public void mNuevo() {
        this.xid = "";
        this.JTFInvima.setText("");
        this.JTFNombre.setText("");
        this.JCBFormaFarmaceutica.setSelectedIndex(-1);
        this.JTFAdministracion.setText("");
        this.JTFDosis.setText("");
        this.JCHEstado.setSelected(true);
        this.JCHEsAmpolla.setSelected(false);
        this.JCHEsFacturable.setSelected(false);
        this.xestado = 0;
        this.xesampolla = 0;
        this.xesfacturable = 0;
        this.xestadog = false;
        this.JTFNombre.requestFocus();
    }

    public void mGrabar() {
        String sql;
        if (!this.JTFNombre.getText().isEmpty()) {
            if (this.JCBFormaFarmaceutica.getSelectedIndex() != -1) {
                int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (n == 0) {
                    if (this.xid.isEmpty()) {
                        sql = " Insert into i_presentacionfarmaceutica(NInvima, Nbre, IdFormaFarmaceutica, Administracion, Dosis, EsAmpolla, Facturable, Estado, Fecha, UsuarioS)  values ('" + this.JTFInvima.getText().toUpperCase() + "','" + this.JTFNombre.getText().toUpperCase() + "','" + this.xidformafarm[this.JCBFormaFarmaceutica.getSelectedIndex()] + "','" + this.JTFAdministracion.getText() + "','" + this.JTFDosis.getText() + "','" + this.xesampolla + "','" + this.xesfacturable + "','" + this.xestado + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                    } else {
                        sql = " update i_presentacionfarmaceutica set NInvima='" + this.JTFInvima.getText().toUpperCase() + "',Nbre='" + this.JTFNombre.getText().toUpperCase() + "',IdFormaFarmaceutica='" + this.xidformafarm[this.JCBFormaFarmaceutica.getSelectedIndex()] + "',Administracion='" + this.JTFAdministracion.getText() + "', Dosis='" + this.JTFDosis.getText() + "',EsAmpolla='" + this.xesampolla + "',Facturable='" + this.xesfacturable + "',Estado='" + this.xestado + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + this.xid + "'";
                    }
                    this.xconsulta.ejecutarSQL(sql);
                    this.xconsulta.cerrarConexionBd();
                    mCargarDatosTabla();
                    mRecargarCombo();
                    return;
                }
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un subgrupo químico", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBFormaFarmaceutica.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "El campo nombre no puede ser nulo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JTFNombre.requestFocus();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Nombre", "Forma Farmacéutica", "Administración", "Dosis", "Ampolla?", "Facturable?", "Estado", "Invima"}) { // from class: ParametrizacionN.JIFSPresentacionFarmaceuta.5
            Class[] types = {Long.class, String.class, String.class, String.class, String.class, Boolean.class, Boolean.class, Boolean.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(250);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(100);
    }

    private void mCargarDatosTabla() {
        try {
            mCrearModeloDatos();
            ResultSet xrs = this.xconsulta.traerRs("SELECT i_presentacionfarmaceutica.Id, i_presentacionfarmaceutica.Nbre, i_formafarmaceutica.Nbre, i_presentacionfarmaceutica.Administracion, i_presentacionfarmaceutica.Dosis, i_presentacionfarmaceutica.EsAmpolla, i_presentacionfarmaceutica.Facturable, i_presentacionfarmaceutica.Estado, i_presentacionfarmaceutica.NInvima FROM baseserver.i_presentacionfarmaceutica INNER JOIN baseserver.i_formafarmaceutica  ON (i_presentacionfarmaceutica.IdFormaFarmaceutica = i_formafarmaceutica.Id) ORDER BY i_presentacionfarmaceutica.Nbre ASC ");
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(1)), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelo.setValueAt(xrs.getString(4), n, 3);
                    this.xmodelo.setValueAt(xrs.getString(5), n, 4);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(6)), n, 5);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(7)), n, 6);
                    this.xmodelo.setValueAt(Boolean.valueOf(!xrs.getBoolean(8)), n, 7);
                    this.xmodelo.setValueAt(xrs.getString(9), n, 8);
                    n++;
                }
            }
            xrs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFSPresentacionFarmaceuta.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mRecargarCombo() {
        this.xjifsuministro.JCBPFarmaceutica.removeAllItems();
        this.xjifsuministro.xidpresentacionf = this.xconsulta.llenarCombo("SELECT Id, Nbre FROM baseserver.i_presentacionfarmaceutica WHERE (Estado =0) ORDER BY Nbre ASC", this.xjifsuministro.xidpresentacionf, this.xjifsuministro.JCBPFarmaceutica);
        this.xjifsuministro.JCBPFarmaceutica.setSelectedIndex(-1);
        this.xconsulta.cerrarConexionBd();
        dispose();
    }
}
