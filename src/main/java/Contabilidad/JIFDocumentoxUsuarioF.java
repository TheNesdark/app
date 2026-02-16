package Contabilidad;

import Acceso.Principal;
import ParametrizacionN.JIFGenericoCh;
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
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

/* JADX INFO: loaded from: GenomaP.jar:Contabilidad/JIFDocumentoxUsuarioF.class */
public class JIFDocumentoxUsuarioF extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private Object[] xdatos;
    private String xsql;
    private String[] xidlider;
    private String[] xiddocumento;
    private JComboBox JCBDocumento;
    private JComboBox JCBLider;
    private JCheckBox JCHEstado;
    private JCheckBox JCHMonto;
    private JPanel JPIDatos;
    private JScrollPane JSPDetalle;
    private JSpinner JSPOrden;
    private JTable JTDetalle;
    private JFormattedTextField JTFFValor;
    private JFormattedTextField JTFFValorM;
    private ConsultasMySQL xconsulta = new ConsultasMySQL();
    private Metodos xmetodos = new Metodos();
    private int xestado = 1;
    private int xmonto = 0;
    private boolean xestadog = false;

    public JIFDocumentoxUsuarioF() {
        initComponents();
        this.xsql = "SELECT rh_tipo_persona_cargon.Id_Persona, concat(gp.Apellido1,' ', gp.Apellido2,' ', gp.Nombre1,' ', gp.Nombre2) NUsuario \nFROM rh_tipo_persona_cargon \nINNER JOIN g_persona gp \n ON (rh_tipo_persona_cargon.Id_Persona = gp.Id ) \n WHERE (rh_tipo_persona_cargon.Lider =1 AND rh_tipo_persona_cargon.Estado =1) \n ORDER BY NUsuario ASC ";
        this.xidlider = this.xconsulta.llenarCombo(this.xsql, this.xidlider, this.JCBLider);
        this.xiddocumento = this.xconsulta.llenarCombo("SELECT Id , Nbre FROM cc_tipo_documentof WHERE (Estado =1) ORDER BY Nbre ASC", this.xiddocumento, this.JCBDocumento);
        this.xconsulta.cerrarConexionBd();
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v49, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPIDatos = new JPanel();
        this.JCBLider = new JComboBox();
        this.JCHEstado = new JCheckBox();
        this.JCBDocumento = new JComboBox();
        this.JCHMonto = new JCheckBox();
        this.JTFFValorM = new JFormattedTextField();
        this.JTFFValor = new JFormattedTextField();
        this.JSPOrden = new JSpinner();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("USUARIO POR DOCUMENTO A FIRMAR");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifdocumentousuariof");
        try {
            setSelected(true);
        } catch (PropertyVetoException e1) {
            e1.printStackTrace();
        }
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JCBLider.setFont(new Font("Arial", 1, 13));
        this.JCBLider.setBorder(BorderFactory.createTitledBorder((Border) null, "Lider", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setSelected(true);
        this.JCHEstado.setText("Estado");
        this.JCHEstado.addActionListener(new ActionListener() { // from class: Contabilidad.JIFDocumentoxUsuarioF.1
            public void actionPerformed(ActionEvent evt) {
                JIFDocumentoxUsuarioF.this.JCHEstadoActionPerformed(evt);
            }
        });
        this.JCBDocumento.setFont(new Font("Arial", 1, 13));
        this.JCBDocumento.setBorder(BorderFactory.createTitledBorder((Border) null, "Documento Contable", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHMonto.setFont(new Font("Arial", 1, 12));
        this.JCHMonto.setText("Aplica Monto?");
        this.JCHMonto.addActionListener(new ActionListener() { // from class: Contabilidad.JIFDocumentoxUsuarioF.2
            public void actionPerformed(ActionEvent evt) {
                JIFDocumentoxUsuarioF.this.JCHMontoActionPerformed(evt);
            }
        });
        this.JTFFValorM.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor Mínimo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFValorM.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFValorM.setHorizontalAlignment(4);
        this.JTFFValorM.setFont(new Font("Arial", 1, 13));
        this.JTFFValor.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor Máximo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFValor.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFValor.setHorizontalAlignment(4);
        this.JTFFValor.setFont(new Font("Arial", 1, 13));
        this.JSPOrden.setBorder(BorderFactory.createTitledBorder((Border) null, "Orden", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBLider, -2, 408, -2).addComponent(this.JCBDocumento, -2, 380, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPOrden, -2, 67, -2).addComponent(this.JCHMonto)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JTFFValorM, -2, 123, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHEstado)).addComponent(this.JTFFValor, -2, 123, -2)).addContainerGap(17, 32767)));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFFValorM, GroupLayout.Alignment.TRAILING).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JCBLider, -2, -1, -2).addComponent(this.JCHMonto)).addComponent(this.JCHEstado)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBDocumento, -2, -1, -2).addComponent(this.JTFFValor).addComponent(this.JSPOrden, -2, 43, -2)).addContainerGap(-1, 32767)));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: Contabilidad.JIFDocumentoxUsuarioF.3
            public void mouseClicked(MouseEvent evt) {
                JIFDocumentoxUsuarioF.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPIDatos, -1, -1, 32767).addComponent(this.JSPDetalle)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalle, -1, 177, 32767).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            this.JCBLider.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
            this.JCBDocumento.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString());
            this.JCHMonto.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString()).booleanValue());
            this.JTFFValorM.setValue(Double.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString()));
            this.JTFFValor.setValue(Double.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 4).toString()));
            this.JCHEstado.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 5).toString()).booleanValue());
            if (Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 5).toString()).booleanValue()) {
                this.xestado = 1;
            } else {
                this.xestado = 0;
            }
            if (Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString()).booleanValue()) {
                this.xmonto = 1;
            } else {
                this.xmonto = 0;
            }
            this.JSPOrden.setValue(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 6));
            this.xestadog = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEstadoActionPerformed(ActionEvent evt) {
        if (this.JCHEstado.isSelected()) {
            this.xestado = 1;
        } else {
            this.xestado = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHMontoActionPerformed(ActionEvent evt) {
        if (this.JCHMonto.isSelected()) {
            this.xmonto = 1;
        } else {
            this.xmonto = 0;
        }
    }

    public void mNuevo() {
        this.xestado = 1;
        this.xmonto = 0;
        this.JCHEstado.setSelected(true);
        this.JCHMonto.setSelected(false);
        this.JCBLider.setSelectedIndex(-1);
        this.JCBDocumento.setSelectedIndex(-1);
        this.JTFFValor.setValue(new Integer(0));
        this.JTFFValorM.setValue(new Integer(0));
        this.xestadog = false;
        mCargarDatosTabla();
        this.JCBLider.requestFocus();
    }

    public void mGrabar() {
        String sql;
        if (this.JCBLider.getSelectedIndex() != -1) {
            if (this.JCBLider.getSelectedIndex() != -1) {
                int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (n == 0) {
                    if (!this.xestadog) {
                        sql = " Insert ignore into  cc_usuarioxdocumentof(Id_Persona, Id_TipoDocF, AplicaM, MontoM,Monto,Orden, Estado, Fecha, UsuarioS)  values ('" + this.xidlider[this.JCBLider.getSelectedIndex()] + "','" + this.xiddocumento[this.JCBDocumento.getSelectedIndex()] + "','" + this.xmonto + "','" + this.JTFFValorM.getValue() + "','" + this.JTFFValor.getValue() + "','" + this.JSPOrden.getValue() + "','" + this.xestado + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                    } else {
                        sql = "update cc_usuarioxdocumentof set Estado='" + this.xestado + "',Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "',AplicaM='" + this.xmonto + "',MontoM='" + this.JTFFValorM.getValue() + "',Monto='" + this.JTFFValor.getValue() + "',Orden='" + this.JSPOrden.getValue() + "',UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' where Id_Persona='" + this.xidlider[this.JCBLider.getSelectedIndex()] + "' and Id_TipoDocF='" + this.xiddocumento[this.JCBDocumento.getSelectedIndex()] + "'";
                    }
                    this.xconsulta.ejecutarSQL(sql);
                    this.xconsulta.cerrarConexionBd();
                    mCargarDatosTabla();
                    return;
                }
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un documento", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBDocumento.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un lider", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JCBLider.requestFocus();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Lider", "Documento", "AplicaM?", "Valor Mínimo", "Valor Máximo", "Estado", "Orden"}) { // from class: Contabilidad.JIFDocumentoxUsuarioF.4
            Class[] types = {String.class, String.class, Boolean.class, Double.class, Double.class, Boolean.class, Long.class};
            boolean[] canEdit = {false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(30);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(30);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(10);
    }

    private void mCargarDatosTabla() {
        try {
            mCrearModeloDatos();
            ResultSet xrs = this.xconsulta.traerRs("SELECT persona.NUsuario, cc_tipo_documentof.Nbre, cc_usuarioxdocumentof.AplicaM, cc_usuarioxdocumentof.MontoM, cc_usuarioxdocumentof.Monto,cc_usuarioxdocumentof.Estado,cc_usuarioxdocumentof.Orden FROM cc_usuarioxdocumentof INNER JOIN cc_tipo_documentof ON (cc_usuarioxdocumentof.Id_TipoDocF = cc_tipo_documentof.Id) INNER JOIN persona  ON (persona.Id_persona = cc_usuarioxdocumentof.Id_Persona) ORDER BY cc_tipo_documentof.Nbre ASC, persona.NUsuario ASC  ");
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(xrs.getString(1), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(3)), n, 2);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(4)), n, 3);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(5)), n, 4);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(6)), n, 5);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(7)), n, 6);
                    n++;
                }
            }
            xrs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFGenericoCh.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }
}
