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
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:ParametrizacionN/JIFGenerico3CheckBoxC3.class */
public class JIFGenerico3CheckBoxC3 extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private Object[] xdatos;
    private String xnombre;
    private JCheckBox JCHEstado;
    private JCheckBox JCHEstado1;
    private JCheckBox JCHEstado2;
    private JPanel JPIDatos;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;
    private JTextField JTFNombre;
    private ConsultasMySQL xconsulta = new ConsultasMySQL();
    private Metodos xmetodos = new Metodos();
    private int xestado = 0;
    private int xestado1 = 0;
    private int xestado2 = 1;
    private String xid = "";
    private boolean xestadog = false;

    public JIFGenerico3CheckBoxC3(String xnombre, String xnombref) {
        initComponents();
        setName(xnombref);
        setTitle(xnombre.toUpperCase());
        this.xnombre = xnombref;
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v31, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPIDatos = new JPanel();
        this.JTFNombre = new JTextField();
        this.JCHEstado = new JCheckBox();
        this.JCHEstado1 = new JCheckBox();
        this.JCHEstado2 = new JCheckBox();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("MUNICIPIO");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("");
        try {
            setSelected(true);
        } catch (PropertyVetoException e1) {
            e1.printStackTrace();
        }
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTFNombre.setFont(new Font("Arial", 1, 12));
        this.JTFNombre.setToolTipText("");
        this.JTFNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setSelected(true);
        this.JCHEstado.setText("Estado");
        this.JCHEstado.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFGenerico3CheckBoxC3.1
            public void actionPerformed(ActionEvent evt) {
                JIFGenerico3CheckBoxC3.this.JCHEstadoActionPerformed(evt);
            }
        });
        this.JCHEstado1.setFont(new Font("Arial", 1, 12));
        this.JCHEstado1.setSelected(true);
        this.JCHEstado1.setText("Estado");
        this.JCHEstado1.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFGenerico3CheckBoxC3.2
            public void actionPerformed(ActionEvent evt) {
                JIFGenerico3CheckBoxC3.this.JCHEstado1ActionPerformed(evt);
            }
        });
        this.JCHEstado2.setFont(new Font("Arial", 1, 12));
        this.JCHEstado2.setSelected(true);
        this.JCHEstado2.setText("Estado");
        this.JCHEstado2.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFGenerico3CheckBoxC3.3
            public void actionPerformed(ActionEvent evt) {
                JIFGenerico3CheckBoxC3.this.JCHEstado2ActionPerformed(evt);
            }
        });
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addComponent(this.JTFNombre, -2, 480, -2).addGap(18, 18, 18).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHEstado).addComponent(this.JCHEstado1)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 37, 32767).addComponent(this.JCHEstado2).addGap(18, 18, 18)));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFNombre, -2, -1, -2).addComponent(this.JCHEstado2)).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JCHEstado).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHEstado1))).addContainerGap(10, 32767)));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.setSelectionMode(0);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFGenerico3CheckBoxC3.4
            public void mouseClicked(MouseEvent evt) {
                JIFGenerico3CheckBoxC3.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JSPDetalle, GroupLayout.Alignment.LEADING).addComponent(this.JPIDatos, GroupLayout.Alignment.LEADING, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalle, -1, 305, 32767).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            Principal.txtNo.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
            this.JTFNombre.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString());
            this.JCHEstado.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString()).booleanValue());
            this.JCHEstado1.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString()).booleanValue());
            this.JCHEstado2.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 4).toString()).booleanValue());
            mIniciarCheck();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEstado1ActionPerformed(ActionEvent evt) {
        mIniciarCheck();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEstado2ActionPerformed(ActionEvent evt) {
        mIniciarCheck();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEstadoActionPerformed(ActionEvent evt) {
        mIniciarCheck();
    }

    private void mIniciarCheck() {
        if (this.xnombre.equals("xjiftiporesultado")) {
            if (this.JCHEstado2.isSelected()) {
                this.xestado2 = 0;
            } else {
                this.xestado2 = 1;
            }
            if (this.JCHEstado1.isSelected()) {
                this.xestado1 = 0;
            } else {
                this.xestado1 = 1;
            }
            if (this.JCHEstado.isSelected()) {
                this.xestado = 0;
                return;
            } else {
                this.xestado = 1;
                return;
            }
        }
        if (this.xnombre.equals("xJIFTipoDocumentosRH")) {
            if (this.JCHEstado2.isSelected()) {
                this.xestado2 = 1;
            } else {
                this.xestado2 = 0;
            }
            if (this.JCHEstado1.isSelected()) {
                this.xestado1 = 1;
            } else {
                this.xestado1 = 0;
            }
            if (this.JCHEstado.isSelected()) {
                this.xestado = 1;
            } else {
                this.xestado = 0;
            }
        }
    }

    public void mNuevo() {
        Principal.mLimpiarDatosP();
        this.JTFNombre.setText("");
        if (this.xnombre.equals("xjiftiporesultado")) {
            this.JCHEstado.setText("Numérico?");
            this.JCHEstado1.setText("Alerta?");
            this.JCHEstado2.setText("Estado?");
            this.xestado = 1;
            this.xestado1 = 0;
            this.xestado2 = 0;
            this.JCHEstado.setSelected(false);
            this.JCHEstado1.setSelected(false);
            this.JCHEstado2.setSelected(true);
        } else if (this.xnombre.equals("xJIFTipoDocumentosRH")) {
            this.JCHEstado.setText("Tipo");
            this.JCHEstado1.setText("Es Contable");
            this.JCHEstado2.setText("Estado");
            this.xestado = 0;
            this.xestado1 = 0;
            this.xestado2 = 1;
            this.JCHEstado.setSelected(false);
            this.JCHEstado1.setSelected(false);
            this.JCHEstado2.setSelected(true);
        }
        this.JTFNombre.requestFocus();
        mCargarDatosTabla();
    }

    public void mGrabar() {
        if (!this.JTFNombre.getText().isEmpty()) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                String sql = null;
                if (Principal.txtNo.getText().isEmpty()) {
                    if (this.xnombre.equals("xjiftiporesultado")) {
                        sql = " Insert into l_tiporesultado(Nbre, Vandera, GeneraAlerta, Estado, Fecha, UsuarioS)  values ('" + this.JTFNombre.getText() + "','" + this.xestado + "','" + this.xestado1 + "','" + this.xestado2 + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                    } else if (this.xnombre.equals("xJIFTipoDocumentosRH")) {
                        sql = "INSERT INTO `rh_tipo_documentos` (`Nbre`, `Tipo`,`EsContable`,`Estado`,`Id_UsuarioS`,`Fecha`) values ('" + this.JTFNombre.getText() + "','" + this.xestado + "','" + this.xestado1 + "','" + this.xestado2 + "','" + Principal.usuarioSistemaDTO.getIdPersonaCargo() + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "')";
                    }
                } else if (this.xnombre.equals("xjiftiporesultado")) {
                    sql = " update l_tiporesultado set Nbre='" + this.JTFNombre.getText() + "',Vandera='" + this.xestado + "',GeneraAlerta='" + this.xestado1 + "',Estado='" + this.xestado2 + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
                } else if (this.xnombre.equals("xJIFTipoDocumentosRH")) {
                    sql = " update rh_tipo_documentos set Nbre='" + this.JTFNombre.getText() + "',Tipo='" + this.xestado + "',EsContable='" + this.xestado1 + "',Estado='" + this.xestado2 + "',Id_UsuarioS='" + Principal.usuarioSistemaDTO.getIdPersonaCargo() + "',Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "' Where Id='" + Principal.txtNo.getText() + "'";
                }
                this.xconsulta.ejecutarSQL(sql);
                this.xconsulta.cerrarConexionBd();
                mCargarDatosTabla();
                mNuevo();
                return;
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "El campo nombre no puede ser nulo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JTFNombre.requestFocus();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos(String[] xcabecera) {
        this.xmodelo = new DefaultTableModel(new Object[0], xcabecera) { // from class: ParametrizacionN.JIFGenerico3CheckBoxC3.5
            Class[] types = {Long.class, String.class, Boolean.class, Boolean.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        if (this.xnombre.equals("xJIFTipoDocumentosRH")) {
            this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(0);
            this.JTDetalle.getColumnModel().getColumn(0).setMinWidth(0);
            this.JTDetalle.getColumnModel().getColumn(0).setMaxWidth(0);
        } else if (this.xnombre.equals("xjiftiporesultado")) {
            this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(10);
        }
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(350);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(10);
    }

    private void mCargarDatosTabla() {
        try {
            String sql = null;
            String[] xencabezado = null;
            if (this.xnombre.equals("xjiftiporesultado")) {
                xencabezado = new String[]{"Id", "Nombre", "Numérico", "Alerta", "Estado"};
                sql = "SELECT Id, Nbre, Vandera, GeneraAlerta, Estado FROM l_tiporesultado ORDER BY Nbre ASC";
            } else if (this.xnombre.equals("xJIFTipoDocumentosRH")) {
                xencabezado = new String[]{"Id", "Nombre", "Tipo", "EsContable", "Estado"};
                sql = "SELECT `Id`,`Nbre`,`Tipo`,`EsContable`, `Estado` FROM `rh_tipo_documentos` ORDER BY Nbre ASC";
            }
            mCrearModeloDatos(xencabezado);
            ResultSet xrs = this.xconsulta.traerRs(sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(1)), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(3)), n, 2);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(4)), n, 3);
                    if (this.xnombre.equals("xjiftiporesultado")) {
                        this.xmodelo.setValueAt(Boolean.valueOf(!xrs.getBoolean(5)), n, 4);
                    } else {
                        this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(5)), n, 4);
                    }
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
