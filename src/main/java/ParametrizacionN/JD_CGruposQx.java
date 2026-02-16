package ParametrizacionN;

import Acceso.Principal;
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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:ParametrizacionN/JD_CGruposQx.class */
public class JD_CGruposQx extends JDialog {
    private Metodos xmt;
    private ConsultasMySQL xct;
    private String xsql;
    private Object[] xDatos;
    private DefaultTableModel xModelo;
    private String[] xId_TManual;
    private String[][] xId_GrupoUrv;
    private boolean xLleno;
    private boolean xLleno1;
    private boolean xEstadog;
    private JButton JBT_Grabar;
    private JButton JBT_NUevo;
    private JButton JBT_Salir;
    private JComboBox JCB_GrupoUvr;
    private JComboBox JCB_TipoManual;
    private JPanel JPI_DCirugia;
    private JScrollPane JSP_PDetalle;
    private JTable JTB_PDetalle;
    private JTextField JTF_Cups;
    private JTextField JTF_Valor;

    public JD_CGruposQx(Frame parent, boolean modal) {
        super(parent, modal);
        this.xmt = new Metodos();
        this.xct = new ConsultasMySQL();
        this.xLleno = false;
        this.xLleno1 = false;
        this.xEstadog = false;
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        mNuevo();
        mCargarDatosTabla();
    }

    /* JADX WARN: Type inference failed for: r3v34, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPI_DCirugia = new JPanel();
        this.JCB_TipoManual = new JComboBox();
        this.JTF_Cups = new JTextField();
        this.JCB_GrupoUvr = new JComboBox();
        this.JTF_Valor = new JTextField();
        this.JBT_Grabar = new JButton();
        this.JSP_PDetalle = new JScrollPane();
        this.JTB_PDetalle = new JTable();
        this.JBT_Salir = new JButton();
        this.JBT_NUevo = new JButton();
        setDefaultCloseOperation(2);
        this.JPI_DCirugia.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS CIRUGÍA", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JCB_TipoManual.setFont(new Font("Arial", 1, 12));
        this.JCB_TipoManual.setBorder(BorderFactory.createTitledBorder((Border) null, "TIpo de Manual", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCB_TipoManual.addItemListener(new ItemListener() { // from class: ParametrizacionN.JD_CGruposQx.1
            public void itemStateChanged(ItemEvent evt) {
                JD_CGruposQx.this.JCB_TipoManualItemStateChanged(evt);
            }
        });
        this.JTF_Cups.setFont(new Font("Arial", 1, 12));
        this.JTF_Cups.setHorizontalAlignment(0);
        this.JTF_Cups.setToolTipText("");
        this.JTF_Cups.setBorder(BorderFactory.createTitledBorder((Border) null, "Cups", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCB_GrupoUvr.setFont(new Font("Arial", 1, 12));
        this.JCB_GrupoUvr.setBorder(BorderFactory.createTitledBorder((Border) null, "Grupo _ Uvr", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCB_GrupoUvr.addItemListener(new ItemListener() { // from class: ParametrizacionN.JD_CGruposQx.2
            public void itemStateChanged(ItemEvent evt) {
                JD_CGruposQx.this.JCB_GrupoUvrItemStateChanged(evt);
            }
        });
        this.JTF_Valor.setFont(new Font("Arial", 1, 12));
        this.JTF_Valor.setHorizontalAlignment(0);
        this.JTF_Valor.setToolTipText("Valor Grupo o Uvr");
        this.JTF_Valor.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBT_Grabar.setFont(new Font("Arial", 1, 12));
        this.JBT_Grabar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBT_Grabar.setText("Grabar");
        this.JBT_Grabar.addActionListener(new ActionListener() { // from class: ParametrizacionN.JD_CGruposQx.3
            public void actionPerformed(ActionEvent evt) {
                JD_CGruposQx.this.JBT_GrabarActionPerformed(evt);
            }
        });
        GroupLayout JPI_DCirugiaLayout = new GroupLayout(this.JPI_DCirugia);
        this.JPI_DCirugia.setLayout(JPI_DCirugiaLayout);
        JPI_DCirugiaLayout.setHorizontalGroup(JPI_DCirugiaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DCirugiaLayout.createSequentialGroup().addContainerGap().addGroup(JPI_DCirugiaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DCirugiaLayout.createSequentialGroup().addComponent(this.JCB_TipoManual, -2, 211, -2).addGap(18, 18, 18).addComponent(this.JTF_Cups, -2, 129, -2).addGap(18, 18, 18).addComponent(this.JCB_GrupoUvr, -2, 373, -2)).addGroup(JPI_DCirugiaLayout.createSequentialGroup().addComponent(this.JTF_Valor, -2, 129, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBT_Grabar, -2, 239, -2))).addContainerGap(-1, 32767)));
        JPI_DCirugiaLayout.setVerticalGroup(JPI_DCirugiaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DCirugiaLayout.createSequentialGroup().addGroup(JPI_DCirugiaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCB_TipoManual, -2, 50, -2).addComponent(this.JTF_Cups, -2, 50, -2).addComponent(this.JCB_GrupoUvr, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 7, 32767).addGroup(JPI_DCirugiaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTF_Valor, -2, 50, -2).addComponent(this.JBT_Grabar, -2, 50, -2)).addContainerGap()));
        this.JSP_PDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTB_PDetalle.setFont(new Font("Arial", 1, 12));
        this.JTB_PDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTB_PDetalle.setRowHeight(25);
        this.JTB_PDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTB_PDetalle.setSelectionForeground(Color.red);
        this.JTB_PDetalle.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JD_CGruposQx.4
            public void mouseClicked(MouseEvent evt) {
                JD_CGruposQx.this.JTB_PDetalleMouseClicked(evt);
            }
        });
        this.JSP_PDetalle.setViewportView(this.JTB_PDetalle);
        this.JBT_Salir.setFont(new Font("Arial", 1, 12));
        this.JBT_Salir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.JBT_Salir.setText("Salir");
        this.JBT_Salir.addActionListener(new ActionListener() { // from class: ParametrizacionN.JD_CGruposQx.5
            public void actionPerformed(ActionEvent evt) {
                JD_CGruposQx.this.JBT_SalirActionPerformed(evt);
            }
        });
        this.JBT_NUevo.setFont(new Font("Arial", 1, 12));
        this.JBT_NUevo.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Nuevo29x25.png")));
        this.JBT_NUevo.setText("Nuevo");
        this.JBT_NUevo.addActionListener(new ActionListener() { // from class: ParametrizacionN.JD_CGruposQx.6
            public void actionPerformed(ActionEvent evt) {
                JD_CGruposQx.this.JBT_NUevoActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSP_PDetalle).addGroup(layout.createSequentialGroup().addComponent(this.JPI_DCirugia, -2, -1, -2).addGap(0, 0, 32767)).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.JBT_NUevo, -2, 350, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JBT_Salir, -2, 350, -2))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPI_DCirugia, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSP_PDetalle, -2, 215, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 9, 32767).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBT_Salir, -2, 50, -2).addComponent(this.JBT_NUevo, -2, 50, -2)).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_GrabarActionPerformed(ActionEvent evt) {
        if (this.JCB_TipoManual.getSelectedIndex() != -1) {
            if (!this.JTF_Cups.getText().isEmpty()) {
                if (this.JCB_GrupoUvr.getSelectedIndex() != -1) {
                    if (!this.JTF_Valor.getText().isEmpty() || !this.JTF_Valor.getText().equals("0")) {
                        int x = JOptionPane.showConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                        if (x == 0) {
                            if (this.xEstadog) {
                                this.xsql = "update q_procedtipomanqx set CodCups='" + this.JTF_Cups.getText() + "', Id_GrupoUVRQx='" + this.xId_GrupoUrv[this.JCB_GrupoUvr.getSelectedIndex()][0] + "', Grupo_UVR='" + this.JTF_Valor.getText() + "' where Id_Procedimiento='" + Principal.txtNo.getText() + "' and Id_TipoManualQx='" + this.xId_TManual[this.JCB_TipoManual.getSelectedIndex()] + "'";
                            } else {
                                this.xsql = "insert into q_procedtipomanqx(`Id_Procedimiento` , `Id_TipoManualQx` , `CodCups` , `Id_GrupoUVRQx` , `Grupo_UVR` , `UsuarioS` , `Fecha`) values('" + Principal.txtNo.getText() + "','" + this.xId_TManual[this.JCB_TipoManual.getSelectedIndex()] + "','" + this.JTF_Cups.getText() + "','" + this.xId_GrupoUrv[this.JCB_GrupoUvr.getSelectedIndex()][0] + "','" + this.JTF_Valor.getText() + "','" + Principal.usuarioSistemaDTO.getLogin() + "','" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "')";
                            }
                            this.xct.ejecutarSQL(this.xsql);
                            this.xct.cerrarConexionBd();
                            mCargarDatosTabla();
                            return;
                        }
                        return;
                    }
                    JOptionPane.showMessageDialog(this, "Debe registrar el grupo o valor uvr", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    this.JTF_Valor.requestFocus();
                    return;
                }
                JOptionPane.showMessageDialog(this, "Debe selecionar un grupo - uvr", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JCB_GrupoUvr.requestFocus();
                return;
            }
            JOptionPane.showMessageDialog(this, "Debe registrar codigo cups", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTF_Cups.requestFocus();
            return;
        }
        JOptionPane.showMessageDialog(this, "Debe selecionar un tipo de manual", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JCB_TipoManual.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_SalirActionPerformed(ActionEvent evt) {
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCB_TipoManualItemStateChanged(ItemEvent evt) {
        if (this.xLleno && this.JCB_TipoManual.getSelectedIndex() != -1) {
            this.xLleno1 = false;
            this.JCB_GrupoUvr.removeAllItems();
            this.xId_GrupoUrv = this.xct.llenarComboyLista("SELECT  `Id` , `Nbre` , `Orden` FROM `q_grupouvr` WHERE (`Id_TipoManualQX` ='" + this.xId_TManual[this.JCB_TipoManual.getSelectedIndex()] + "') ORDER BY `Orden` ASC", this.xId_GrupoUrv, this.JCB_GrupoUvr, 3);
            this.JCB_GrupoUvr.setSelectedIndex(-1);
            this.xLleno1 = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCB_GrupoUvrItemStateChanged(ItemEvent evt) {
        if (this.xLleno1 && this.JCB_GrupoUvr.getSelectedIndex() != -1) {
            this.JTF_Valor.setText(this.xId_GrupoUrv[this.JCB_GrupoUvr.getSelectedIndex()][1]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTB_PDetalleMouseClicked(MouseEvent evt) {
        if (this.JTB_PDetalle.getSelectedRow() != -1) {
            this.JCB_TipoManual.setSelectedItem(this.xModelo.getValueAt(this.JTB_PDetalle.getSelectedRow(), 0));
            this.JTF_Cups.setText(this.xModelo.getValueAt(this.JTB_PDetalle.getSelectedRow(), 1).toString());
            this.JCB_GrupoUvr.setSelectedItem(this.xModelo.getValueAt(this.JTB_PDetalle.getSelectedRow(), 2));
            this.JTF_Valor.setText(this.xModelo.getValueAt(this.JTB_PDetalle.getSelectedRow(), 3).toString());
            this.xEstadog = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_NUevoActionPerformed(ActionEvent evt) {
        mNuevo();
    }

    private void mNuevo() {
        this.xLleno = false;
        this.JCB_GrupoUvr.removeAllItems();
        this.JCB_TipoManual.removeAllItems();
        this.xId_TManual = this.xct.llenarCombo("SELECT  `Id` , `Nbre` FROM `q_tipomanualqx` ORDER BY `Nbre` ASC", this.xId_TManual, this.JCB_TipoManual);
        this.JCB_TipoManual.setSelectedIndex(-1);
        this.JTF_Cups.setText(Principal.txtNo.getText());
        this.JTF_Valor.setText("0");
        this.xLleno = true;
        this.xEstadog = false;
        this.JCB_TipoManual.requestFocus();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModelo() {
        this.xModelo = new DefaultTableModel(new Object[0], new String[]{"Tipo Manual", "Cups", "Grupo - Uvr", "Valor"}) { // from class: ParametrizacionN.JD_CGruposQx.7
            Class[] types = {String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTB_PDetalle.setModel(this.xModelo);
        this.JTB_PDetalle.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTB_PDetalle.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTB_PDetalle.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTB_PDetalle.getColumnModel().getColumn(3).setPreferredWidth(20);
    }

    private void mCargarDatosTabla() {
        try {
            mCrearModelo();
            this.xsql = "SELECT  `q_tipomanualqx`.`Nbre` , `q_procedtipomanqx`.`CodCups` , `q_grupouvr`.`Nbre` , `q_procedtipomanqx`.`Grupo_UVR` FROM `q_procedtipomanqx` INNER JOIN  `q_grupouvr`  ON (`q_procedtipomanqx`.`Id_GrupoUVRQx` = `q_grupouvr`.`Id`) INNER JOIN  `q_tipomanualqx`  ON (`q_procedtipomanqx`.`Id_TipoManualQx` = `q_tipomanualqx`.`Id`) WHERE (`q_procedtipomanqx`.`Id_Procedimiento` ='" + Principal.txtNo.getText() + "') ORDER BY `q_tipomanualqx`.`Nbre` ASC ";
            ResultSet xrs = this.xct.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int x = 0;
                this.xmt.mEstablecerTextEditor(this.JTB_PDetalle, 1);
                while (xrs.next()) {
                    this.xModelo.addRow(this.xDatos);
                    this.xModelo.setValueAt(xrs.getString(1), x, 0);
                    this.xModelo.setValueAt(xrs.getString(2), x, 1);
                    this.xModelo.setValueAt(xrs.getString(3), x, 2);
                    this.xModelo.setValueAt(xrs.getString(4), x, 3);
                    x++;
                }
            } else {
                mCrearModelo();
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JD_CGruposQx.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }
}
