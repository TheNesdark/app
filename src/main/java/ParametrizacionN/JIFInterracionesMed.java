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
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:ParametrizacionN/JIFInterracionesMed.class */
public class JIFInterracionesMed extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private Object[] xdatos;
    private String[] xidgenerico1;
    private String[] xidgenerico2;
    private ButtonGroup JBGTipo;
    private JComboBox JCBPActivo1;
    private JComboBox JCBPActivo2;
    private JCheckBox JCHEstado;
    private JPanel JPIInformacion;
    private JPanel JPITipo;
    private JRadioButton JRBGrave;
    private JRadioButton JRBLeve;
    private JRadioButton JRBModerado;
    private JScrollPane JSPDetalle;
    private JScrollPane JSPMensaje;
    private JTable JTDetalle;
    public JTextPane JTPMensaje;
    private ConsultasMySQL xconsulta = new ConsultasMySQL();
    private Metodos xmetodos = new Metodos();
    private int xestado = 0;
    private int xtipo = 0;
    private boolean xestadog = false;

    public JIFInterracionesMed() {
        initComponents();
        mIniciarComponentes();
        mCargarDatosTabla();
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v7, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGTipo = new ButtonGroup();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JPIInformacion = new JPanel();
        this.JCBPActivo1 = new JComboBox();
        this.JCBPActivo2 = new JComboBox();
        this.JSPMensaje = new JScrollPane();
        this.JTPMensaje = new JTextPane();
        this.JPITipo = new JPanel();
        this.JRBLeve = new JRadioButton();
        this.JRBModerado = new JRadioButton();
        this.JRBGrave = new JRadioButton();
        this.JCHEstado = new JCheckBox();
        setClosable(true);
        setIconifiable(true);
        setTitle("INTERACCIONES MEDICAMENTOSAS");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setMaximumSize(null);
        setName("jifinteracionmed");
        try {
            setSelected(true);
        } catch (PropertyVetoException e1) {
            e1.printStackTrace();
        }
        addInternalFrameListener(new InternalFrameListener() { // from class: ParametrizacionN.JIFInterracionesMed.1
            public void internalFrameClosed(InternalFrameEvent evt) {
                JIFInterracionesMed.this.formInternalFrameClosed(evt);
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
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
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalle.setSelectionMode(0);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFInterracionesMed.2
            public void mouseClicked(MouseEvent evt) {
                JIFInterracionesMed.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.JPIInformacion.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JCBPActivo1.setFont(new Font("Arial", 1, 12));
        this.JCBPActivo1.setBorder(BorderFactory.createTitledBorder((Border) null, "Principio Activo Uno", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBPActivo2.setFont(new Font("Arial", 1, 12));
        this.JCBPActivo2.setBorder(BorderFactory.createTitledBorder((Border) null, "Principio Activo Dos", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPMensaje.setBorder(BorderFactory.createTitledBorder((Border) null, "Mensaje", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPMensaje.setFont(new Font("Arial", 1, 12));
        this.JTPMensaje.setFont(new Font("Arial", 0, 13));
        this.JSPMensaje.setViewportView(this.JTPMensaje);
        this.JPITipo.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo", 0, 0, new Font("Arial", 1, 12), new Color(0, 102, 0)));
        this.JBGTipo.add(this.JRBLeve);
        this.JRBLeve.setFont(new Font("Arial", 1, 12));
        this.JRBLeve.setSelected(true);
        this.JRBLeve.setText("Leve");
        this.JRBLeve.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFInterracionesMed.3
            public void actionPerformed(ActionEvent evt) {
                JIFInterracionesMed.this.JRBLeveActionPerformed(evt);
            }
        });
        this.JBGTipo.add(this.JRBModerado);
        this.JRBModerado.setFont(new Font("Arial", 1, 12));
        this.JRBModerado.setText("Moderado");
        this.JRBModerado.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFInterracionesMed.4
            public void actionPerformed(ActionEvent evt) {
                JIFInterracionesMed.this.JRBModeradoActionPerformed(evt);
            }
        });
        this.JBGTipo.add(this.JRBGrave);
        this.JRBGrave.setFont(new Font("Arial", 1, 12));
        this.JRBGrave.setText("Grave");
        this.JRBGrave.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFInterracionesMed.5
            public void actionPerformed(ActionEvent evt) {
                JIFInterracionesMed.this.JRBGraveActionPerformed(evt);
            }
        });
        GroupLayout JPITipoLayout = new GroupLayout(this.JPITipo);
        this.JPITipo.setLayout(JPITipoLayout);
        JPITipoLayout.setHorizontalGroup(JPITipoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPITipoLayout.createSequentialGroup().addContainerGap().addComponent(this.JRBLeve).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBModerado).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBGrave).addContainerGap(-1, 32767)));
        JPITipoLayout.setVerticalGroup(JPITipoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPITipoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBLeve).addComponent(this.JRBModerado).addComponent(this.JRBGrave)));
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setSelected(true);
        this.JCHEstado.setText("Estado");
        this.JCHEstado.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFInterracionesMed.6
            public void actionPerformed(ActionEvent evt) {
                JIFInterracionesMed.this.JCHEstadoActionPerformed(evt);
            }
        });
        GroupLayout JPIInformacionLayout = new GroupLayout(this.JPIInformacion);
        this.JPIInformacion.setLayout(JPIInformacionLayout);
        JPIInformacionLayout.setHorizontalGroup(JPIInformacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIInformacionLayout.createSequentialGroup().addContainerGap().addGroup(JPIInformacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBPActivo2, 0, 809, 32767).addComponent(this.JCBPActivo1, 0, 809, 32767).addGroup(JPIInformacionLayout.createSequentialGroup().addComponent(this.JSPMensaje, -2, 492, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JPITipo, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHEstado))).addContainerGap()));
        JPIInformacionLayout.setVerticalGroup(JPIInformacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIInformacionLayout.createSequentialGroup().addComponent(this.JCBPActivo1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBPActivo2, -2, -1, -2).addGroup(JPIInformacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIInformacionLayout.createSequentialGroup().addGap(28, 28, 28).addComponent(this.JCHEstado)).addGroup(JPIInformacionLayout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIInformacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPMensaje, -1, 79, 32767).addComponent(this.JPITipo, -2, -1, -2)))).addContainerGap()));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPIInformacion, -2, -1, -2).addComponent(this.JSPDetalle, -1, 845, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIInformacion, -2, -1, -2).addGap(18, 18, 18).addComponent(this.JSPDetalle, -1, 293, 32767).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            this.JCBPActivo1.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
            this.JCBPActivo2.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString());
            this.JTPMensaje.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString());
            this.JCHEstado.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString()).booleanValue());
            if (Integer.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 4).toString()).intValue() == 0) {
                this.JRBLeve.setSelected(true);
                this.xtipo = 0;
            } else if (Integer.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 4).toString()).intValue() == 1) {
                this.JRBModerado.setSelected(true);
                this.xtipo = 1;
            } else if (Integer.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 4).toString()).intValue() == 2) {
                this.JRBGrave.setSelected(true);
                this.xtipo = 2;
            }
            this.xestadog = true;
            return;
        }
        this.xestadog = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosed(InternalFrameEvent evt) {
        Principal.mLimpiarDatosP();
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
    public void JRBLeveActionPerformed(ActionEvent evt) {
        this.xtipo = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBModeradoActionPerformed(ActionEvent evt) {
        this.xtipo = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBGraveActionPerformed(ActionEvent evt) {
        this.xtipo = 2;
    }

    public void mNuevo() {
        this.xestadog = false;
        this.JCBPActivo1.setSelectedIndex(-1);
        this.JCBPActivo2.setSelectedIndex(-1);
        this.JTPMensaje.setText("");
        this.xestado = 1;
        this.JCHEstado.setSelected(true);
        this.JCBPActivo1.requestFocus();
    }

    public void mGrabar() {
        String sql;
        if (this.JCBPActivo1.getSelectedIndex() != -1) {
            if (this.JCBPActivo2.getSelectedIndex() != -1) {
                if (!this.JTPMensaje.getText().isEmpty()) {
                    int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    if (n == 0) {
                        if (!this.xestadog) {
                            sql = " Insert ignore into h_interaciones_pactivo(Id_PrincipioA1, Id_PrincipioA2, Mensaje, Tipo, Estado, Fecha, UsuarioS)  values ('" + this.xidgenerico1[this.JCBPActivo1.getSelectedIndex()] + "','" + this.xidgenerico2[this.JCBPActivo2.getSelectedIndex()] + "','" + this.JTPMensaje.getText() + "','" + this.xtipo + "','" + this.xestado + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                        } else {
                            sql = "update h_interaciones_pactivo set Mensaje='" + this.JTPMensaje.getText() + "',Tipo='" + this.xtipo + "',Estado='" + this.xestado + "',Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "',UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' where Id_PrincipioA1='" + this.xidgenerico1[this.JCBPActivo1.getSelectedIndex()] + "' and  Id_PrincipioA2='" + this.xidgenerico2[this.JCBPActivo2.getSelectedIndex()] + "'";
                        }
                        this.xconsulta.ejecutarSQL(sql);
                        this.xconsulta.cerrarConexionBd();
                        mCargarDatosTabla();
                        return;
                    }
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "El mensaje no puede ser nulo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JTPMensaje.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar el prncipio de activo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBPActivo2.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar el prncipio de activo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JCBPActivo1.requestFocus();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Principio Activo 1", "Principio Activo 2", "Mensaje", "Estado", "Tipo"}) { // from class: ParametrizacionN.JIFInterracionesMed.7
            Class[] types = {String.class, String.class, String.class, Boolean.class, Integer.class};
            boolean[] canEdit = {false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(4).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(4).setMaxWidth(0);
    }

    private void mCargarDatosTabla() {
        try {
            mCrearModeloDatos();
            ResultSet xrs = this.xconsulta.traerRs("SELECT i_principioactivo.Nbre, i_principio_activo.Nbre, h_interaciones_pactivo.Mensaje, h_interaciones_pactivo.Estado, h_interaciones_pactivo.Tipo FROM h_interaciones_pactivo INNER JOIN i_principioactivo ON (h_interaciones_pactivo.Id_PrincipioA1 = i_principioactivo.Id) INNER JOIN i_principio_activo  ON (i_principio_activo.Id = h_interaciones_pactivo.Id_PrincipioA2) ");
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(xrs.getString(1), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(4)), n, 3);
                    this.xmodelo.setValueAt(Integer.valueOf(xrs.getInt(5)), n, 4);
                    n++;
                }
            }
            xrs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFGenericoCh.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mIniciarComponentes() {
        this.xidgenerico1 = this.xconsulta.llenarCombo("SELECT Id, Nbre FROM i_principioactivo WHERE (Estado =1) ORDER BY Nbre ASC", this.xidgenerico1, this.JCBPActivo1);
        this.JCBPActivo1.setSelectedIndex(-1);
        this.xidgenerico2 = this.xconsulta.llenarCombo("SELECT Id, Nbre FROM i_principioactivo WHERE (Estado =1) ORDER BY Nbre ASC", this.xidgenerico2, this.JCBPActivo2);
        this.JCBPActivo2.setSelectedIndex(-1);
        this.xconsulta.cerrarConexionBd();
    }
}
