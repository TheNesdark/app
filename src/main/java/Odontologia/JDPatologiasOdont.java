package Odontologia;

import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
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
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Odontologia/JDPatologiasOdont.class */
public class JDPatologiasOdont extends JDialog {
    private DefaultTableModel xmodelo;
    private DefaultTableModel xmodelodx;
    private JPOdontogramaClinico xJPOdontogramaClinico;
    private Object[] xdatos;
    private String xNDiente;
    private ConsultasMySQL xct;
    private Metodos xmt;
    private String[] xtipodx;
    private JLabel xlabel;
    private JButton JBAsignar;
    private JButton JBFinalizar;
    private JComboBox JCBTipoDx;
    private JTable JTDetalle;
    private JTable JTDetalleDX;
    private JTextField JTFCie10;
    private JTextField JTFNombre;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;

    public JDPatologiasOdont(Frame parent, boolean modal, JPOdontogramaClinico xJPOdontogramaClinico, String xNDiente, JLabel xlabel) {
        super(parent, modal);
        this.xct = new ConsultasMySQL();
        this.xmt = new Metodos();
        initComponents();
        setTitle("PATOLOGIAS");
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        setLocationRelativeTo(null);
        this.xNDiente = xNDiente;
        this.xJPOdontogramaClinico = xJPOdontogramaClinico;
        mCreaModeloSuperficies();
        mLlenaTabla();
        mIniciaComponentes();
        this.xlabel = xlabel;
    }

    /* JADX WARN: Type inference failed for: r3v15, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jScrollPane1 = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JTFNombre = new JTextField();
        this.JTFCie10 = new JTextField();
        this.jScrollPane2 = new JScrollPane();
        this.JTDetalleDX = new JTable();
        this.JCBTipoDx = new JComboBox();
        this.JBAsignar = new JButton();
        this.JBFinalizar = new JButton();
        setDefaultCloseOperation(2);
        this.jScrollPane1.setBorder(BorderFactory.createTitledBorder((Border) null, "SUPERFICIES MARCADAS", 2, 0, new Font("Arial", 1, 12), new Color(0, 102, 0)));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(Color.red);
        this.jScrollPane1.setViewportView(this.JTDetalle);
        this.JTFNombre.setFont(new Font("Arial", 1, 12));
        this.JTFNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Patología", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFNombre.addKeyListener(new KeyAdapter() { // from class: Odontologia.JDPatologiasOdont.1
            public void keyReleased(KeyEvent evt) {
                JDPatologiasOdont.this.JTFNombreKeyReleased(evt);
            }
        });
        this.JTFCie10.setFont(new Font("Arial", 1, 12));
        this.JTFCie10.setBorder(BorderFactory.createTitledBorder((Border) null, "CIE10", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFCie10.addFocusListener(new FocusAdapter() { // from class: Odontologia.JDPatologiasOdont.2
            public void focusLost(FocusEvent evt) {
                JDPatologiasOdont.this.JTFCie10FocusLost(evt);
            }
        });
        this.JTFCie10.addKeyListener(new KeyAdapter() { // from class: Odontologia.JDPatologiasOdont.3
            public void keyPressed(KeyEvent evt) {
                JDPatologiasOdont.this.JTFCie10KeyPressed(evt);
            }

            public void keyReleased(KeyEvent evt) {
                JDPatologiasOdont.this.JTFCie10KeyReleased(evt);
            }
        });
        this.jScrollPane2.setBorder(BorderFactory.createTitledBorder((Border) null, "DIAGNÓSTICOS", 2, 0, new Font("Arial", 1, 12), new Color(0, 102, 0)));
        this.JTDetalleDX.setFont(new Font("Arial", 1, 12));
        this.JTDetalleDX.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalleDX.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalleDX.setSelectionForeground(Color.red);
        this.JTDetalleDX.addMouseListener(new MouseAdapter() { // from class: Odontologia.JDPatologiasOdont.4
            public void mouseClicked(MouseEvent evt) {
                JDPatologiasOdont.this.JTDetalleDXMouseClicked(evt);
            }
        });
        this.jScrollPane2.setViewportView(this.JTDetalleDX);
        this.JCBTipoDx.setFont(new Font("Arial", 1, 12));
        this.JCBTipoDx.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo DX", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JBAsignar.setFont(new Font("Arial", 1, 12));
        this.JBAsignar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBAsignar.setText("Asignar");
        this.JBAsignar.addActionListener(new ActionListener() { // from class: Odontologia.JDPatologiasOdont.5
            public void actionPerformed(ActionEvent evt) {
                JDPatologiasOdont.this.JBAsignarActionPerformed(evt);
            }
        });
        this.JBFinalizar.setFont(new Font("Arial", 1, 12));
        this.JBFinalizar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBFinalizar.setText("Finalizar");
        this.JBFinalizar.addActionListener(new ActionListener() { // from class: Odontologia.JDPatologiasOdont.6
            public void actionPerformed(ActionEvent evt) {
                JDPatologiasOdont.this.JBFinalizarActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane1).addGroup(layout.createSequentialGroup().addComponent(this.JTFCie10, -2, 78, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFNombre, -2, 427, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBTipoDx, -2, 191, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBAsignar, -1, -1, 32767)).addComponent(this.jScrollPane2, GroupLayout.Alignment.TRAILING).addComponent(this.JBFinalizar, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(5, 5, 5).addComponent(this.jScrollPane1, -2, 154, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBTipoDx, GroupLayout.Alignment.TRAILING).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFNombre, -2, 49, -2).addComponent(this.JTFCie10, -2, 49, -2)).addComponent(this.JBAsignar, -2, 41, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane2, -2, 165, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBFinalizar, -2, 41, -2).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNombreKeyReleased(KeyEvent evt) {
        try {
            if (!this.JTFNombre.getText().isEmpty()) {
                mCrearModeloDatos();
                String sql = "SELECT Id, Nbre FROM g_patologia WHERE  (Nbre like '%" + this.JTFNombre.getText() + "%' and Estado=1) ORDER BY Nbre ASC";
                ResultSet res = this.xct.traerRs(sql);
                this.xmt.mEstablecerTextEditor(this.JTDetalleDX, 1);
                if (res.next()) {
                    int n = 0;
                    res.beforeFirst();
                    while (res.next()) {
                        this.xmodelodx.addRow(this.xdatos);
                        this.xmodelodx.setValueAt(res.getString(1), n, 0);
                        this.xmodelodx.setValueAt(res.getString(2), n, 1);
                        n++;
                    }
                }
                res.close();
                this.xct.cerrarConexionBd();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelodx = new DefaultTableModel(new Object[0], new String[]{"CIE10", "Nombre"}) { // from class: Odontologia.JDPatologiasOdont.7
            Class[] types = {String.class, String.class};
            boolean[] canEdit = {false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalleDX.setModel(this.xmodelodx);
        this.JTDetalleDX.getColumnModel().getColumn(0).setPreferredWidth(5);
        this.JTDetalleDX.getColumnModel().getColumn(1).setPreferredWidth(455);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCie10KeyReleased(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleDXMouseClicked(MouseEvent evt) {
        if (this.JTDetalleDX.getSelectedRow() > -1) {
            this.JTFCie10.setText(this.xmodelodx.getValueAt(this.JTDetalleDX.getSelectedRow(), 0).toString());
            this.JTFNombre.setText(this.xmodelodx.getValueAt(this.JTDetalleDX.getSelectedRow(), 1).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCie10FocusLost(FocusEvent evt) {
        buscarPatologias(this.JTFCie10, this.JTFNombre, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCie10KeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            buscarPatologias(this.JTFCie10, this.JTFNombre, 0);
            this.JTFCie10.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBAsignarActionPerformed(ActionEvent evt) {
        if (xMarcado()) {
            if (!this.JTFCie10.getText().equals("") && !this.JTFNombre.getText().equals("")) {
                if (this.JCBTipoDx.getSelectedIndex() > -1) {
                    for (int i = 0; i < this.JTDetalle.getRowCount(); i++) {
                        if (Boolean.valueOf(this.xmodelo.getValueAt(i, 9).toString()).booleanValue()) {
                            this.xmodelo.setValueAt(this.JTFCie10.getText(), i, 3);
                            this.xmodelo.setValueAt(this.JTFNombre.getText(), i, 4);
                            this.xmodelo.setValueAt(this.xtipodx[this.JCBTipoDx.getSelectedIndex()], i, 5);
                            this.xmodelo.setValueAt(this.JCBTipoDx.getSelectedItem(), i, 6);
                            this.xmodelo.setValueAt(false, i, 9);
                        }
                    }
                    this.JTFCie10.setText("");
                    this.JTFNombre.setText("");
                    this.JCBTipoDx.setSelectedIndex(-1);
                    return;
                }
                JOptionPane.showMessageDialog(this, "Debe seleccionar un Tipo de DX", "Verificar", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JCBTipoDx.requestFocus();
                return;
            }
            JOptionPane.showMessageDialog(this, "Debe seleccionar un DX", "Verificar", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTFCie10.requestFocus();
            return;
        }
        JOptionPane.showMessageDialog(this, "Debe seleccionar por lo menos una Superficie de la Tabla", "Verificar", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBFinalizarActionPerformed(ActionEvent evt) {
        for (int i = 0; i < this.JTDetalle.getRowCount(); i++) {
            if (!this.xmodelo.getValueAt(i, 3).toString().equals("")) {
                for (int j = 0; j < this.xJPOdontogramaClinico.JTDetalleO.getRowCount(); j++) {
                    if (this.xmodelo.getValueAt(i, 0).toString().equals(this.xJPOdontogramaClinico.modelo.getValueAt(j, 0).toString())) {
                        this.xJPOdontogramaClinico.modelo.setValueAt(this.xmodelo.getValueAt(i, 3).toString(), j, 3);
                        this.xJPOdontogramaClinico.modelo.setValueAt(this.xmodelo.getValueAt(i, 4).toString(), j, 4);
                        this.xJPOdontogramaClinico.modelo.setValueAt(this.xmodelo.getValueAt(i, 5).toString(), j, 5);
                        this.xJPOdontogramaClinico.modelo.setValueAt(this.xmodelo.getValueAt(i, 6).toString(), j, 6);
                    }
                }
            }
        }
        this.xJPOdontogramaClinico.pintaNumero(this.xlabel);
        dispose();
    }

    private boolean xMarcado() {
        boolean xExiste = false;
        int i = 0;
        while (true) {
            if (i >= this.JTDetalle.getRowCount()) {
                break;
            }
            if (!Boolean.valueOf(this.xmodelo.getValueAt(i, 9).toString()).booleanValue()) {
                i++;
            } else {
                xExiste = true;
                break;
            }
        }
        return xExiste;
    }

    private void mLlenaTabla() {
        int n = 0;
        for (int i = 0; i < this.xJPOdontogramaClinico.JTDetalleO.getRowCount(); i++) {
            if (this.xJPOdontogramaClinico.modelo.getValueAt(i, 1).toString().equals(this.xNDiente)) {
                this.xmodelo.addRow(this.xdatos);
                this.xmodelo.setValueAt(this.xJPOdontogramaClinico.modelo.getValueAt(i, 0).toString(), n, 0);
                this.xmodelo.setValueAt(this.xJPOdontogramaClinico.modelo.getValueAt(i, 1).toString(), n, 1);
                this.xmodelo.setValueAt(this.xJPOdontogramaClinico.modelo.getValueAt(i, 2).toString(), n, 2);
                this.xmodelo.setValueAt(this.xJPOdontogramaClinico.modelo.getValueAt(i, 3).toString(), n, 3);
                this.xmodelo.setValueAt(this.xJPOdontogramaClinico.modelo.getValueAt(i, 4).toString(), n, 4);
                this.xmodelo.setValueAt(this.xJPOdontogramaClinico.modelo.getValueAt(i, 5).toString(), n, 5);
                this.xmodelo.setValueAt(this.xJPOdontogramaClinico.modelo.getValueAt(i, 6).toString(), n, 6);
                this.xmodelo.setValueAt(this.xJPOdontogramaClinico.modelo.getValueAt(i, 7).toString(), n, 7);
                this.xmodelo.setValueAt(this.xJPOdontogramaClinico.modelo.getValueAt(i, 8).toString(), n, 8);
                this.xmodelo.setValueAt(false, n, 9);
                n++;
            }
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCreaModeloSuperficies() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"IdDiente", "N°Diente", "Superficie", "CIE10", "Diagnóstico", "IdTipoDx", "TipoDx", "Proceso", "Observacion", "✓"}) { // from class: Odontologia.JDPatologiasOdont.8
            Class[] types = {Integer.class, Long.class, String.class, String.class, String.class, Long.class, String.class, String.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, true, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(3);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(25);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(5);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(130);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(5).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(5).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(40);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(60);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(8).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(8).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(3);
    }

    private void mIniciaComponentes() {
        this.JCBTipoDx.removeAllItems();
        this.xtipodx = this.xct.llenarCombo("SELECT  `Id` , `Nbre` FROM `h_tipodiagnostico`", this.xtipodx, this.JCBTipoDx);
        this.JCBTipoDx.setSelectedIndex(-1);
        this.xct.cerrarConexionBd();
    }

    private void buscarPatologias(JTextField codigo, JTextField nombrep, int n) {
        if (!codigo.getText().isEmpty()) {
            try {
                String sql = "SELECT Id, Nbre FROM g_patologia where Id='" + codigo.getText().toUpperCase() + "'";
                ResultSet res = this.xct.traerRs(sql);
                res.next();
                if (res.getRow() != 0) {
                    nombrep.setText(res.getString(2));
                    codigo.setText(codigo.getText().toUpperCase());
                } else {
                    JOptionPane.showMessageDialog(this, "Codigo no existe", "BUSCAR PATOLOGÍA", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    nombrep.setText((String) null);
                    codigo.setText((String) null);
                    codigo.requestFocus();
                }
                res.close();
                this.xct.cerrarConexionBd();
            } catch (SQLException e) {
            }
        }
    }
}
