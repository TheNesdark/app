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
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:ParametrizacionN/JIFGBarrio.class */
public class JIFGBarrio extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private Object[] xdatos;
    private String[] xidmunicipio;
    int idBarrio;
    private ButtonGroup JBGZona;
    private JComboBox JCBMunicipio;
    private JCheckBox JCHEstado;
    private JPanel JPIDatos;
    private JPanel JPIZona;
    private JRadioButton JRBRural;
    private JRadioButton JRBUrbana;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;
    private JTextField JTFNombre;
    private ConsultasMySQL xconsulta = new ConsultasMySQL();
    private Metodos xmetodos = new Metodos();
    private int xestado = 0;
    private String xzona = "U";
    private String codigoZona = "01";

    public JIFGBarrio() {
        initComponents();
        this.xidmunicipio = this.xconsulta.llenarCombo("SELECT g_municipio.Id, CONCAT(g_municipio.Nbre,' - ', g_departamento.Nbre) AS NMunicipio FROM g_municipio INNER JOIN g_departamento  ON (g_municipio.Id_Dpto = g_departamento.Id) WHERE (g_municipio.Estado =0) ORDER BY NMunicipio ASC", this.xidmunicipio, this.JCBMunicipio);
        mCargarDatosTabla();
        this.xconsulta.cerrarConexionBd();
    }

    /* JADX WARN: Type inference failed for: r3v38, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGZona = new ButtonGroup();
        this.JPIDatos = new JPanel();
        this.JTFNombre = new JTextField();
        this.JCHEstado = new JCheckBox();
        this.JCBMunicipio = new JComboBox();
        this.JPIZona = new JPanel();
        this.JRBUrbana = new JRadioButton();
        this.JRBRural = new JRadioButton();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        setClosable(true);
        setTitle("BARRIO");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifbarrio");
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
        this.JCHEstado.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFGBarrio.1
            public void actionPerformed(ActionEvent evt) {
                JIFGBarrio.this.JCHEstadoActionPerformed(evt);
            }
        });
        this.JCBMunicipio.setFont(new Font("Arial", 1, 12));
        this.JCBMunicipio.setBorder(BorderFactory.createTitledBorder((Border) null, "Municipio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JPIZona.setBorder(BorderFactory.createTitledBorder((Border) null, "Zona", 0, 0, new Font("Arial", 1, 12), new Color(0, 103, 0)));
        this.JBGZona.add(this.JRBUrbana);
        this.JRBUrbana.setFont(new Font("Arial", 1, 12));
        this.JRBUrbana.setSelected(true);
        this.JRBUrbana.setText("Urbana");
        this.JRBUrbana.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFGBarrio.2
            public void actionPerformed(ActionEvent evt) {
                JIFGBarrio.this.JRBUrbanaActionPerformed(evt);
            }
        });
        this.JBGZona.add(this.JRBRural);
        this.JRBRural.setFont(new Font("Arial", 1, 12));
        this.JRBRural.setText("Rural");
        this.JRBRural.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFGBarrio.3
            public void actionPerformed(ActionEvent evt) {
                JIFGBarrio.this.JRBRuralActionPerformed(evt);
            }
        });
        GroupLayout JPIZonaLayout = new GroupLayout(this.JPIZona);
        this.JPIZona.setLayout(JPIZonaLayout);
        JPIZonaLayout.setHorizontalGroup(JPIZonaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIZonaLayout.createSequentialGroup().addComponent(this.JRBUrbana).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBRural).addContainerGap(-1, 32767)));
        JPIZonaLayout.setVerticalGroup(JPIZonaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIZonaLayout.createSequentialGroup().addContainerGap(-1, 32767).addGroup(JPIZonaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBUrbana).addComponent(this.JRBRural)).addContainerGap()));
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JTFNombre, -2, 297, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBMunicipio, -2, 237, -2)).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JPIZona, -1, -1, 32767).addGap(26, 26, 26).addComponent(this.JCHEstado).addGap(556, 556, 556)))));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFNombre).addComponent(this.JCBMunicipio, -2, 50, -2)).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPIZona, -1, -1, 32767).addGap(36, 36, 36)).addGroup(JPIDatosLayout.createSequentialGroup().addGap(38, 38, 38).addComponent(this.JCHEstado).addContainerGap()))));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalle.setSelectionMode(0);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFGBarrio.4
            public void mouseClicked(MouseEvent evt) {
                JIFGBarrio.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPDetalle).addComponent(this.JPIDatos, -2, 577, -2)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, 170, -2).addGap(18, 18, 18).addComponent(this.JSPDetalle, -1, 273, 32767).addContainerGap()));
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
            Principal.txtNo.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
            this.JTFNombre.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString());
            this.JCBMunicipio.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString());
            if (this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString().equals("U")) {
                this.JRBUrbana.setSelected(true);
                this.xzona = "U";
            } else {
                this.JRBRural.setSelected(true);
                this.xzona = "R";
            }
            this.JCHEstado.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 4).toString()).booleanValue());
            if (this.JCHEstado.isSelected()) {
                this.xestado = 0;
            } else {
                this.xestado = 1;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBUrbanaActionPerformed(ActionEvent evt) {
        this.xzona = "U";
        this.codigoZona = "01";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBRuralActionPerformed(ActionEvent evt) {
        this.xzona = "R";
        this.codigoZona = "02";
    }

    public void mNuevo() {
        Principal.txtNo.setText("");
        this.JTFNombre.setText("");
        this.JCBMunicipio.setSelectedIndex(-1);
        this.xzona = "U";
        this.JRBUrbana.setSelected(true);
        this.JCHEstado.setSelected(true);
        this.xestado = 0;
    }

    public void mGrabar() {
        String sql;
        if (!this.JTFNombre.getText().isEmpty()) {
            if (this.JCBMunicipio.getSelectedIndex() != -1) {
                int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (n == 0) {
                    if (Principal.txtNo.getText().isEmpty()) {
                        sql = " Insert into g_barrio(Nbre, Id_Municipio, Zona, Estado, Fecha, UsuarioS, codigoZona)  values ('" + this.JTFNombre.getText().toUpperCase() + "','" + this.xidmunicipio[this.JCBMunicipio.getSelectedIndex()] + "','" + this.xzona + "','" + this.xestado + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "','" + this.codigoZona + "')";
                    } else {
                        sql = " update g_barrio set Nbre='" + this.JTFNombre.getText().toUpperCase() + "',Id_Municipio='" + this.xidmunicipio[this.JCBMunicipio.getSelectedIndex()] + "',Zona='" + this.xzona + "',Estado='" + this.xestado + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "',codigoZona='" + this.codigoZona + "' Where Id='" + Principal.txtNo.getText() + "'";
                    }
                    this.xconsulta.ejecutarSQL(sql);
                    this.xconsulta.cerrarConexionBd();
                    mCargarDatosTabla();
                    return;
                }
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un municipio", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBMunicipio.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "El campo código no puede ser nulo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JTFNombre.requestFocus();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Municipio", "Barrio", "Zona", "Estado"}) { // from class: ParametrizacionN.JIFGBarrio.5
            Class[] types = {Long.class, String.class, String.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(30);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(30);
    }

    private void mCargarDatosTabla() {
        try {
            mCrearModeloDatos();
            ResultSet xrs = this.xconsulta.traerRs("SELECT g_barrio.Id, CONCAT(g_municipio.Nbre,' - ', g_departamento.Nbre) AS Municipio, g_barrio.Nbre, g_barrio.Zona, g_barrio.Estado \n                        FROM baseserver.g_barrio INNER JOIN baseserver.g_municipio  ON (g_barrio.Id_Municipio = g_municipio.Id) \n                        INNER JOIN g_departamento  ON (g_municipio.Id_Dpto = g_departamento.Id) WHERE (g_municipio.Estado =0)\n                        ORDER BY g_municipio.Nbre ASC, g_barrio.Nbre ASC");
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(xrs.getString(1), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelo.setValueAt(xrs.getString(4), n, 3);
                    this.xmodelo.setValueAt(Boolean.valueOf(!xrs.getBoolean(5)), n, 4);
                    n++;
                }
            }
            xrs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFGBarrio.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }
}
