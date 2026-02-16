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
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:ParametrizacionN/JIFEPreguntaEncuesta.class */
public class JIFEPreguntaEncuesta extends JInternalFrame {
    private ConsultasMySQL xconsulta = new ConsultasMySQL();
    private Metodos xmetodos = new Metodos();
    private int xestado = 1;
    private int xcvalor = 0;
    private DefaultTableModel xmodelo;
    private Object[] xdatos;
    private String xnombre;
    private String[] xidtiporesp;
    private JComboBox JCBTipoR;
    private JCheckBox JCHCValor;
    private JCheckBox JCHEstado;
    private JPanel JPIDatos;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;
    private JTextField JTFNombreP;

    public JIFEPreguntaEncuesta() {
        initComponents();
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v31, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPIDatos = new JPanel();
        this.JTFNombreP = new JTextField();
        this.JCBTipoR = new JComboBox();
        this.JCHEstado = new JCheckBox();
        this.JCHCValor = new JCheckBox();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("PREGUNTA");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifpregunta");
        try {
            setSelected(true);
        } catch (PropertyVetoException e1) {
            e1.printStackTrace();
        }
        addInternalFrameListener(new InternalFrameListener() { // from class: ParametrizacionN.JIFEPreguntaEncuesta.1
            public void internalFrameClosed(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                JIFEPreguntaEncuesta.this.formInternalFrameClosing(evt);
            }

            public void internalFrameOpened(InternalFrameEvent evt) {
            }

            public void internalFrameActivated(InternalFrameEvent evt) {
            }

            public void internalFrameDeactivated(InternalFrameEvent evt) {
            }

            public void internalFrameDeiconified(InternalFrameEvent evt) {
            }

            public void internalFrameIconified(InternalFrameEvent evt) {
            }
        });
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTFNombreP.setFont(new Font("Arial", 1, 12));
        this.JTFNombreP.setToolTipText("");
        this.JTFNombreP.setBorder(BorderFactory.createTitledBorder((Border) null, "Descripción", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTipoR.setFont(new Font("Arial", 1, 12));
        this.JCBTipoR.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Respuesta", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setSelected(true);
        this.JCHEstado.setText("Estado");
        this.JCHEstado.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFEPreguntaEncuesta.2
            public void actionPerformed(ActionEvent evt) {
                JIFEPreguntaEncuesta.this.JCHEstadoActionPerformed(evt);
            }
        });
        this.JCHCValor.setFont(new Font("Arial", 1, 12));
        this.JCHCValor.setText("CValor?");
        this.JCHCValor.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFEPreguntaEncuesta.3
            public void actionPerformed(ActionEvent evt) {
                JIFEPreguntaEncuesta.this.JCHCValorActionPerformed(evt);
            }
        });
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addComponent(this.JTFNombreP, -1, 569, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBTipoR, -2, 219, -2).addGap(18, 18, 18).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHCValor).addComponent(this.JCHEstado)).addContainerGap()));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JCBTipoR, GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.LEADING, JPIDatosLayout.createSequentialGroup().addComponent(this.JCHCValor).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHEstado)).addComponent(this.JTFNombreP, GroupLayout.Alignment.LEADING, -2, 50, -2)).addContainerGap()));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.setSelectionMode(0);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFEPreguntaEncuesta.4
            public void mouseClicked(MouseEvent evt) {
                JIFEPreguntaEncuesta.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JSPDetalle, GroupLayout.Alignment.LEADING, -1, 915, 32767).addComponent(this.JPIDatos, GroupLayout.Alignment.LEADING, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPDetalle, -1, 353, 32767).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            Principal.txtNo.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
            this.JTFNombreP.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString());
            this.JCBTipoR.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString());
            this.JCHCValor.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString()).booleanValue());
            this.JCHEstado.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 4).toString()).booleanValue());
            mIniciarCheck();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosing(InternalFrameEvent evt) {
        Principal.mLimpiarDatosP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEstadoActionPerformed(ActionEvent evt) {
        mIniciarCheck();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHCValorActionPerformed(ActionEvent evt) {
        mIniciarCheck();
    }

    private void mIniciarCheck() {
        if (this.JCHEstado.isSelected()) {
            this.xestado = 1;
        } else {
            this.xestado = 0;
        }
        if (this.JCHCValor.isSelected()) {
            this.xcvalor = 1;
        } else {
            this.xcvalor = 0;
        }
    }

    public void mNuevo() {
        Principal.mLimpiarDatosP();
        this.JTFNombreP.setText("");
        this.JCBTipoR.removeAllItems();
        this.xidtiporesp = this.xconsulta.llenarCombo("SELECT Id, Nbre FROM t_etipo_r WHERE (Estado =1)ORDER BY Nbre ASC", this.xidtiporesp, this.JCBTipoR);
        this.JCBTipoR.setSelectedIndex(-1);
        this.xconsulta.cerrarConexionBd();
        mCargarDatosTabla();
        this.xestado = 1;
        this.xcvalor = 0;
        this.JTFNombreP.requestFocus();
    }

    public void mGrabar() {
        if (!this.JTFNombreP.getText().isEmpty()) {
            if (this.JCBTipoR.getSelectedIndex() != -1) {
                int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (n == 0) {
                    if (Principal.txtNo.getText().isEmpty()) {
                        String sql = " Insert into t_epregunta(Nbre, Id_tipor, CValor, Estado, UsuarioS)  values ('" + this.JTFNombreP.getText().toUpperCase() + "','" + this.xidtiporesp[this.JCBTipoR.getSelectedIndex()] + "','" + this.xcvalor + "','" + this.xestado + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                        Principal.txtNo.setText(this.xconsulta.ejecutarSQLId(sql));
                    } else {
                        String sql2 = " update t_epregunta set Nbre='" + this.JTFNombreP.getText().toUpperCase() + "',Id_tipor='" + this.xidtiporesp[this.JCBTipoR.getSelectedIndex()] + "',CValor='" + this.xcvalor + "',Estado='" + this.xestado + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
                        this.xconsulta.ejecutarSQL(sql2);
                    }
                    this.xconsulta.cerrarConexionBd();
                    mCargarDatosTabla();
                    mNuevo();
                    return;
                }
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un tipo de respuesta", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBTipoR.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "El campo pregunta no puede ser nulo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JTFNombreP.requestFocus();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Pregunta", "Tipo Respuesta", "CValor", "Estado"}) { // from class: ParametrizacionN.JIFEPreguntaEncuesta.5
            Class[] types = {Long.class, String.class, String.class, Boolean.class, Boolean.class};
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
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(500);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(10);
    }

    private void mCargarDatosTabla() {
        try {
            mCrearModeloDatos();
            ResultSet xrs = this.xconsulta.traerRs("SELECT  t_epregunta.Id, t_epregunta.Nbre, t_etipo_r.Nbre,t_epregunta.CValor, t_epregunta.Estado  FROM t_epregunta INNER JOIN t_etipo_r  ON (t_epregunta.Id_tipor = t_etipo_r.Id)");
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(xrs.getString(1), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(4)), n, 3);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(5)), n, 4);
                    n++;
                }
            }
            xrs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFEPreguntaEncuesta.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }
}
