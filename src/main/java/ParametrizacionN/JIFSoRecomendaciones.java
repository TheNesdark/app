package ParametrizacionN;

import Acceso.Principal;
import Activos.JIFGestionActivos;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import Utilidades.TextAreaEditor;
import Utilidades.TextAreaRenderer;
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
import javax.swing.table.TableColumnModel;

/* JADX INFO: loaded from: GenomaP.jar:ParametrizacionN/JIFSoRecomendaciones.class */
public class JIFSoRecomendaciones extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private Object[] xdatos;
    private String xnombre;
    private String[] xidgenerico;
    private JIFGestionActivos xjifges;
    private boolean xlleno;
    private JComboBox JCBPartes;
    private JCheckBox JCHCorreo;
    private JCheckBox JCHDefecto;
    private JCheckBox JCHEstado;
    private JPanel JPIDatos;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;
    private JTextField JTFCorreo;
    private JTextField JTFNombre;
    private ConsultasMySQL xconsulta = new ConsultasMySQL();
    private Metodos xmetodos = new Metodos();
    private int xestado = 1;
    private int xdefecto = 0;
    private int xcorreo = 0;
    private boolean xestado1 = false;

    public JIFSoRecomendaciones() {
        initComponents();
        mNuevo();
        mIniciarComponentes();
        mCargarDatosTabla();
    }

    /* JADX WARN: Type inference failed for: r3v32, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPIDatos = new JPanel();
        this.JTFNombre = new JTextField();
        this.JCHEstado = new JCheckBox();
        this.JCBPartes = new JComboBox();
        this.JCHCorreo = new JCheckBox();
        this.JTFCorreo = new JTextField();
        this.JCHDefecto = new JCheckBox();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("RECOMENDACIONES");
        setToolTipText("");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifSoRecomendaciones");
        try {
            setSelected(true);
        } catch (PropertyVetoException e1) {
            e1.printStackTrace();
        }
        addInternalFrameListener(new InternalFrameListener() { // from class: ParametrizacionN.JIFSoRecomendaciones.1
            public void internalFrameClosed(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                JIFSoRecomendaciones.this.formInternalFrameClosing(evt);
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
        this.JTFNombre.setFont(new Font("Arial", 1, 12));
        this.JTFNombre.setToolTipText("");
        this.JTFNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Recomendación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setSelected(true);
        this.JCHEstado.setText("Estado");
        this.JCHEstado.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFSoRecomendaciones.2
            public void actionPerformed(ActionEvent evt) {
                JIFSoRecomendaciones.this.JCHEstadoActionPerformed(evt);
            }
        });
        this.JCBPartes.setFont(new Font("Arial", 1, 12));
        this.JCBPartes.setBorder(BorderFactory.createTitledBorder((Border) null, "Partes", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHCorreo.setFont(new Font("Arial", 1, 12));
        this.JCHCorreo.setText("Correo?");
        this.JCHCorreo.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFSoRecomendaciones.3
            public void actionPerformed(ActionEvent evt) {
                JIFSoRecomendaciones.this.JCHCorreoActionPerformed(evt);
            }
        });
        this.JTFCorreo.setFont(new Font("Arial", 1, 12));
        this.JTFCorreo.setToolTipText("");
        this.JTFCorreo.setBorder(BorderFactory.createTitledBorder((Border) null, "Correo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHDefecto.setFont(new Font("Arial", 1, 12));
        this.JCHDefecto.setText("Por Defecto?");
        this.JCHDefecto.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFSoRecomendaciones.4
            public void actionPerformed(ActionEvent evt) {
                JIFSoRecomendaciones.this.JCHDefectoActionPerformed(evt);
            }
        });
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPIDatosLayout.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.JCBPartes, -2, 337, -2)).addGroup(GroupLayout.Alignment.LEADING, JPIDatosLayout.createSequentialGroup().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addGroup(GroupLayout.Alignment.LEADING, JPIDatosLayout.createSequentialGroup().addComponent(this.JCHCorreo).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFCorreo)).addComponent(this.JTFNombre, -2, 589, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 260, 32767).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHDefecto).addComponent(this.JCHEstado)))).addGap(14, 14, 14)));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBPartes, GroupLayout.Alignment.TRAILING, -1, 58, 32767).addComponent(this.JTFNombre, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHCorreo).addComponent(this.JTFCorreo, -2, 50, -2).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JCHDefecto).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHEstado))).addGap(15, 15, 15)));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalle.setSelectionMode(0);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFSoRecomendaciones.5
            public void mouseClicked(MouseEvent evt) {
                JIFSoRecomendaciones.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPIDatos, -1, -1, 32767).addComponent(this.JSPDetalle)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -1, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalle, -2, 327, -2).addContainerGap()));
        pack();
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
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            Principal.txtNo.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
            this.JTFNombre.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString());
            this.JCBPartes.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString());
            this.JCHCorreo.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString()).booleanValue());
            if (this.JCHCorreo.isSelected()) {
                this.xcorreo = 1;
            } else {
                this.xcorreo = 0;
            }
            this.JTFCorreo.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 4).toString());
            this.JCHDefecto.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 5).toString()).booleanValue());
            if (this.JCHDefecto.isSelected()) {
                this.xdefecto = 1;
            } else {
                this.xdefecto = 0;
            }
            this.JCHEstado.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 6).toString()).booleanValue());
            if (this.JCHEstado.isSelected()) {
                this.xestado = 1;
            } else {
                this.xestado = 0;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosing(InternalFrameEvent evt) {
        Principal.mLimpiarDatosP();
        if (this.xestado1) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHCorreoActionPerformed(ActionEvent evt) {
        if (this.JCHCorreo.isSelected()) {
            this.xcorreo = 1;
        } else {
            this.xcorreo = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHDefectoActionPerformed(ActionEvent evt) {
        if (this.JCHDefecto.isSelected()) {
            this.xdefecto = 1;
        } else {
            this.xdefecto = 0;
        }
    }

    public void mNuevo() {
        Principal.mLimpiarDatosP();
        this.JTFNombre.setText("");
        this.JCBPartes.setSelectedIndex(-1);
        this.JCHEstado.setSelected(true);
        this.xestado = 1;
        this.JTFNombre.requestFocus();
        this.JCHCorreo.setSelected(false);
        this.xcorreo = 0;
        this.JTFCorreo.setText("");
        this.JCHDefecto.setSelected(false);
        this.xdefecto = 0;
    }

    public void mGrabar() {
        String sql;
        if (!this.JTFNombre.getText().isEmpty()) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                if (Principal.txtNo.getText().isEmpty()) {
                    sql = " Insert into so_recomendaciones(`Nbre` , `Id_Encabezado` , `ECorreo`  , `GrupoCorreo`  , `PorDefecto` , `Estado` , `UsuarioS`)  values ('" + this.JTFNombre.getText() + "','" + this.xidgenerico[this.JCBPartes.getSelectedIndex()] + "','" + this.xcorreo + "','" + this.JTFCorreo.getText() + "','" + this.xdefecto + "','" + this.xestado + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                } else {
                    sql = " update so_recomendaciones set Nbre='" + this.JTFNombre.getText() + "',Id_Encabezado='" + this.xidgenerico[this.JCBPartes.getSelectedIndex()] + "',ECorreo='" + this.xcorreo + "', GrupoCorreo='" + this.JTFCorreo.getText() + "', PorDefecto='" + this.xdefecto + "', Estado='" + this.xestado + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
                }
                this.xconsulta.ejecutarSQL(sql);
                this.xconsulta.cerrarConexionBd();
                mCargarDatosTabla();
                mNuevo();
                return;
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "El nombre no puede ser nulo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JTFNombre.requestFocus();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos(String[] xcabecera) {
        this.xmodelo = new DefaultTableModel(new Object[0], xcabecera) { // from class: ParametrizacionN.JIFSoRecomendaciones.6
            Class[] types = {Integer.class, String.class, String.class, Boolean.class, String.class, Boolean.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(5);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(250);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(120);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(6);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(6);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(5);
    }

    private void mCargarDatosTabla() {
        try {
            String[] xencabezado = {"Id", "Recomendación", "Encabezado", "Correo?", "Dirección de Correo", "Por defecto?", "Estado"};
            mCrearModeloDatos(xencabezado);
            ResultSet xrs = this.xconsulta.traerRs("SELECT `so_recomendaciones`.`Id`  , `so_recomendaciones`.`Nbre`  , `so_recomendaciones_encabezado`.`Nbre`  , `so_recomendaciones`.`ECorreo` , `so_recomendaciones`.`GrupoCorreo` , `so_recomendaciones`.`PorDefecto`  , `so_recomendaciones`.`Estado` FROM `so_recomendaciones` INNER JOIN `baseserver`.`so_recomendaciones_encabezado`   ON (`so_recomendaciones`.`Id_Encabezado` = `so_recomendaciones_encabezado`.`Id`) ORDER BY `so_recomendaciones_encabezado`.`Nbre` ");
            TableColumnModel cmodel = this.JTDetalle.getColumnModel();
            TextAreaRenderer textAreaRenderer = new TextAreaRenderer();
            cmodel.getColumn(1).setCellRenderer(textAreaRenderer);
            TextAreaEditor textEditor = new TextAreaEditor();
            cmodel.getColumn(1).setCellEditor(textEditor);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(Integer.valueOf(xrs.getInt(1)), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(4)), n, 3);
                    this.xmodelo.setValueAt(xrs.getString(5), n, 4);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(6)), n, 5);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(7)), n, 6);
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
        this.JCBPartes.removeAllItems();
        this.xidgenerico = this.xconsulta.llenarCombo("SELECT  `Id` , `Nbre` FROM `so_recomendaciones_encabezado` WHERE (`Estado` =1) ORDER BY Nbre", this.xidgenerico, this.JCBPartes);
        this.JCBPartes.setSelectedIndex(-1);
        this.xconsulta.cerrarConexionBd();
        this.xlleno = true;
    }
}
