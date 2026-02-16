package Laboratorio;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
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
import javax.swing.JComboBox;
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

/* JADX INFO: loaded from: GenomaP.jar:Laboratorio/JIFProtocoloxTipoResultado.class */
public class JIFProtocoloxTipoResultado extends JInternalFrame {
    private Object[] xdato;
    private DefaultTableModel xmodelo;
    private String[] xidprotocolo;
    private String[] xidtiporesultado;
    private int xalterado;
    private String xsql;
    private JComboBox JCBProtocolo;
    private JComboBox JCBTipoResultado;
    private JCheckBox JCHAlterado;
    private JCheckBox JCHEstado;
    private JPanel JPIDatos;
    private JScrollPane JSPDetalle;
    private JSpinner JSPNOrden;
    private JTable JTBDetalle;
    private JTextField jtfCodigoInterfaz;
    private ConsultasMySQL xct = new ConsultasMySQL();
    private Metodos xmt = new Metodos();
    private int xestado = 0;
    private boolean xlleno = false;
    private boolean xestadog = false;

    public JIFProtocoloxTipoResultado() {
        initComponents();
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v43, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPIDatos = new JPanel();
        this.JCBProtocolo = new JComboBox();
        this.JCBTipoResultado = new JComboBox();
        this.JCHEstado = new JCheckBox();
        this.JSPNOrden = new JSpinner();
        this.JCHAlterado = new JCheckBox();
        this.jtfCodigoInterfaz = new JTextField();
        this.JSPDetalle = new JScrollPane();
        this.JTBDetalle = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("PROTOCOLO POR TIPO DE RESULTADO");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("ProtocoloxTipoResultado");
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JCBProtocolo.setFont(new Font("Arial", 1, 12));
        this.JCBProtocolo.setBorder(BorderFactory.createTitledBorder((Border) null, "Protocolo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBProtocolo.addItemListener(new ItemListener() { // from class: Laboratorio.JIFProtocoloxTipoResultado.1
            public void itemStateChanged(ItemEvent evt) {
                JIFProtocoloxTipoResultado.this.JCBProtocoloItemStateChanged(evt);
            }
        });
        this.JCBTipoResultado.setFont(new Font("Arial", 1, 12));
        this.JCBTipoResultado.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Resultado", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setSelected(true);
        this.JCHEstado.setText("Estado");
        this.JCHEstado.addActionListener(new ActionListener() { // from class: Laboratorio.JIFProtocoloxTipoResultado.2
            public void actionPerformed(ActionEvent evt) {
                JIFProtocoloxTipoResultado.this.JCHEstadoActionPerformed(evt);
            }
        });
        this.JSPNOrden.setFont(new Font("Arial", 1, 12));
        this.JSPNOrden.setModel(new SpinnerNumberModel(0, 0, (Comparable) null, 1));
        this.JSPNOrden.setBorder(BorderFactory.createTitledBorder((Border) null, "Orden", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHAlterado.setFont(new Font("Arial", 1, 12));
        this.JCHAlterado.setText("Es Alterado?");
        this.JCHAlterado.addActionListener(new ActionListener() { // from class: Laboratorio.JIFProtocoloxTipoResultado.3
            public void actionPerformed(ActionEvent evt) {
                JIFProtocoloxTipoResultado.this.JCHAlteradoActionPerformed(evt);
            }
        });
        this.jtfCodigoInterfaz.setFont(new Font("Arial", 1, 12));
        this.jtfCodigoInterfaz.setToolTipText("Código externo del interfaces");
        this.jtfCodigoInterfaz.setBorder(BorderFactory.createTitledBorder((Border) null, "Código Interfaz", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JCBProtocolo, -2, 349, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBTipoResultado, -2, 233, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jtfCodigoInterfaz, -2, 128, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPNOrden, -2, 64, -2).addGap(3, 3, 3).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHEstado).addComponent(this.JCHAlterado)).addContainerGap()));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JCHAlterado).addGap(3, 3, 3).addComponent(this.JCHEstado)).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBProtocolo, -2, 52, -2).addComponent(this.JSPNOrden, -2, 51, -2).addComponent(this.JCBTipoResultado, -2, 51, -2).addComponent(this.jtfCodigoInterfaz, -2, 51, -2))).addGap(10, 10, 10)));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.JTBDetalle.setFont(new Font("Arial", 1, 12));
        this.JTBDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTBDetalle.setRowHeight(25);
        this.JTBDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTBDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTBDetalle.setSelectionMode(0);
        this.JTBDetalle.addMouseListener(new MouseAdapter() { // from class: Laboratorio.JIFProtocoloxTipoResultado.4
            public void mouseClicked(MouseEvent evt) {
                JIFProtocoloxTipoResultado.this.JTBDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTBDetalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(10, 10, 10).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPIDatos, -1, -1, 32767).addComponent(this.JSPDetalle)).addGap(10, 10, 10)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addGap(10, 10, 10).addComponent(this.JSPDetalle, -1, 237, 32767).addContainerGap()));
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
    public void JCBProtocoloItemStateChanged(ItemEvent evt) {
        if (this.xlleno && this.JCBProtocolo.getSelectedIndex() != -1) {
            mCargarDatosTabla();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBDetalleMouseClicked(MouseEvent evt) {
        if (this.JTBDetalle.getSelectedRow() != -1) {
            this.JCBTipoResultado.setSelectedItem(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 1));
            this.JCHEstado.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 2).toString()).booleanValue());
            if (this.JCHEstado.isSelected()) {
                this.xestado = 0;
            } else {
                this.xestado = 1;
            }
            this.xestadog = true;
            this.JSPNOrden.setValue(Long.valueOf(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 3).toString()));
            this.JCHAlterado.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 4).toString()).booleanValue());
            if (this.JCHAlterado.isSelected()) {
                this.xalterado = 1;
            } else {
                this.xalterado = 0;
            }
            this.jtfCodigoInterfaz.setText(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 5).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHAlteradoActionPerformed(ActionEvent evt) {
        if (this.JCHAlterado.isSelected()) {
            this.xalterado = 1;
        } else {
            this.xalterado = 0;
        }
    }

    public void mNuevo() {
        this.xlleno = false;
        this.xestadog = false;
        this.JCBProtocolo.removeAllItems();
        this.xidprotocolo = this.xct.llenarCombo("SELECT Id, CONCAT(Nbre,' (',Id,')') FROM l_protocolos WHERE (Estado =0) ORDER BY Nbre ASC", this.xidprotocolo, this.JCBProtocolo);
        this.JCBProtocolo.setSelectedIndex(-1);
        this.xct.cerrarConexionBd();
        this.JCBTipoResultado.removeAllItems();
        this.xidtiporesultado = this.xct.llenarCombo("SELECT Id, CONCAT(Nbre,' (',Id,')') FROM l_tiporesultado WHERE (Estado =0) ORDER BY Nbre ASC", this.xidtiporesultado, this.JCBTipoResultado);
        this.JCBTipoResultado.setSelectedIndex(-1);
        this.xct.cerrarConexionBd();
        this.xestado = 0;
        this.xalterado = 0;
        this.JCHAlterado.setSelected(false);
        this.JSPNOrden.setValue(new Integer(0));
        this.JCHEstado.setSelected(true);
        mCrearModeloDatos();
        this.xlleno = true;
        this.JCBProtocolo.requestFocus();
        this.jtfCodigoInterfaz.setText("");
    }

    public void mGrabar() {
        if (this.JCBProtocolo.getSelectedIndex() != -1) {
            if (this.JCBTipoResultado.getSelectedIndex() != -1) {
                int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (x == 0) {
                    if (this.xestadog) {
                        this.xsql = "update l_protocoloxtiporesultado set Estado='" + this.xestado + "', Fecha='" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "', NOrden='" + this.JSPNOrden.getValue() + "', Alterado='" + this.xalterado + "', Codigo='" + this.jtfCodigoInterfaz.getText() + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id_Protocolo='" + this.xidprotocolo[this.JCBProtocolo.getSelectedIndex()] + "' and Id_TipoResultado='" + this.xidtiporesultado[this.JCBTipoResultado.getSelectedIndex()] + "'";
                    } else {
                        this.xsql = " insert ignore into l_protocoloxtiporesultado(Id_Protocolo, Id_TipoResultado, NOrden, Alterado,Codigo, Estado, Fecha, UsuarioS) values ('" + this.xidprotocolo[this.JCBProtocolo.getSelectedIndex()] + "','" + this.xidtiporesultado[this.JCBTipoResultado.getSelectedIndex()] + "','" + this.JSPNOrden.getValue() + "','" + this.xalterado + "','" + this.jtfCodigoInterfaz.getText() + "','" + this.xestado + "','" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                    }
                    this.xct.ejecutarSQL(this.xsql);
                    this.xct.cerrarConexionBd();
                    mCargarDatosTabla();
                    return;
                }
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un tipo resultado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBTipoResultado.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un protocolo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JCBProtocolo.requestFocus();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Nombre", "Estado", "NOrden", "Alterado?", "Código Interfaz"}) { // from class: Laboratorio.JIFProtocoloxTipoResultado.5
            Class[] types = {Long.class, String.class, Boolean.class, Long.class, Boolean.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTBDetalle.setModel(this.xmodelo);
        this.JTBDetalle.getColumnModel().getColumn(0).setPreferredWidth(5);
        this.JTBDetalle.getColumnModel().getColumn(1).setPreferredWidth(400);
        this.JTBDetalle.getColumnModel().getColumn(2).setPreferredWidth(20);
        this.JTBDetalle.getColumnModel().getColumn(3).setPreferredWidth(20);
        this.JTBDetalle.getColumnModel().getColumn(4).setPreferredWidth(20);
        this.JTBDetalle.getColumnModel().getColumn(5).setPreferredWidth(20);
    }

    private void mCargarDatosTabla() {
        try {
            mCrearModeloDatos();
            String sql = "SELECT l_tiporesultado.Id, CONCAT(l_tiporesultado.Nbre,' (',l_tiporesultado.Id,')') Nbre, l_protocoloxtiporesultado.Estado, l_protocoloxtiporesultado.NOrden, l_protocoloxtiporesultado.Alterado,IFNULL(l_protocoloxtiporesultado.Codigo,'') AS Codigo  FROM l_protocoloxtiporesultado INNER JOIN l_protocolos ON (l_protocoloxtiporesultado.Id_Protocolo = l_protocolos.Id) INNER JOIN l_tiporesultado  ON (l_protocoloxtiporesultado.Id_TipoResultado = l_tiporesultado.Id) WHERE (l_protocolos.Id ='" + this.xidprotocolo[this.JCBProtocolo.getSelectedIndex()] + "') ORDER BY l_protocoloxtiporesultado.NOrden asc, l_tiporesultado.Nbre ASC ";
            ResultSet xrs = this.xct.traerRs(sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(xrs.getString(1), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt(Boolean.valueOf(!xrs.getBoolean(3)), n, 2);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(4)), n, 3);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(5)), n, 4);
                    this.xmodelo.setValueAt(xrs.getString(6), n, 5);
                    n++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFProtocoloxTipoResultado.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mAnular() {
        if (this.JTBDetalle.getSelectedRow() != -1) {
            int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de eliminar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                this.xsql = "delete from  l_protocoloxtiporesultado   Where Id_Protocolo='" + this.xidprotocolo[this.JCBProtocolo.getSelectedIndex()] + "' and Id_TipoResultado='" + this.xidtiporesultado[this.JCBTipoResultado.getSelectedIndex()] + "'";
                this.xct.ejecutarSQL(this.xsql);
                this.xct.cerrarConexionBd();
                mNuevoAnulado();
                mCargarDatosTabla();
            }
        }
    }

    private void mNuevoAnulado() {
        this.xlleno = false;
        this.xestadog = false;
        this.xestado = 0;
        this.xalterado = 0;
        this.JCHAlterado.setSelected(false);
        this.JSPNOrden.setValue(new Integer(0));
        this.JCHEstado.setSelected(true);
        mCrearModeloDatos();
        this.xlleno = true;
        this.JCBProtocolo.requestFocus();
        this.jtfCodigoInterfaz.setText("");
    }
}
