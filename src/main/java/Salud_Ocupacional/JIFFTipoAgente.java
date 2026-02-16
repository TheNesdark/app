package Salud_Ocupacional;

import Acceso.Principal;
import ParametrizacionN.JIFGenerico1CheckBox1TextArea;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Salud_Ocupacional/JIFFTipoAgente.class */
public class JIFFTipoAgente extends JInternalFrame {
    private ConsultasMySQL xct = new ConsultasMySQL();
    private Metodos xmt = new Metodos();
    private int xEstado = 1;
    private int xTipo = 0;
    private DefaultTableModel xmodelo;
    private Object[] xdato;
    private JTable JTDetalle;
    private JTextField JTFNombre;
    private ButtonGroup buttonGroup1;
    private JCheckBox jCheckBox1;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JRadioButton jRadioButton1;
    private JRadioButton jRadioButton2;
    private JScrollPane jScrollPane1;

    public JIFFTipoAgente() {
        initComponents();
        mCargarDatosTabla();
    }

    /* JADX WARN: Type inference failed for: r3v43, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.buttonGroup1 = new ButtonGroup();
        this.jPanel1 = new JPanel();
        this.JTFNombre = new JTextField();
        this.jPanel2 = new JPanel();
        this.jRadioButton1 = new JRadioButton();
        this.jRadioButton2 = new JRadioButton();
        this.jCheckBox1 = new JCheckBox();
        this.jScrollPane1 = new JScrollPane();
        this.JTDetalle = new JTable();
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("TIPO DE AGENTE");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifTipoAgente");
        addInternalFrameListener(new InternalFrameListener() { // from class: Salud_Ocupacional.JIFFTipoAgente.1
            public void internalFrameActivated(InternalFrameEvent evt) {
            }

            public void internalFrameClosed(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                JIFFTipoAgente.this.formInternalFrameClosing(evt);
            }

            public void internalFrameDeactivated(InternalFrameEvent evt) {
            }

            public void internalFrameDeiconified(InternalFrameEvent evt) {
            }

            public void internalFrameIconified(InternalFrameEvent evt) {
            }

            public void internalFrameOpened(InternalFrameEvent evt) {
            }
        });
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JTFNombre.setFont(new Font("Arial", 1, 12));
        this.JTFNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jPanel2.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.buttonGroup1.add(this.jRadioButton1);
        this.jRadioButton1.setFont(new Font("Arial", 1, 12));
        this.jRadioButton1.setSelected(true);
        this.jRadioButton1.setText("Nivel Exposición");
        this.jRadioButton1.addActionListener(new ActionListener() { // from class: Salud_Ocupacional.JIFFTipoAgente.2
            public void actionPerformed(ActionEvent evt) {
                JIFFTipoAgente.this.jRadioButton1ActionPerformed(evt);
            }
        });
        this.buttonGroup1.add(this.jRadioButton2);
        this.jRadioButton2.setFont(new Font("Arial", 1, 12));
        this.jRadioButton2.setText("Factor de Riesgo");
        this.jRadioButton2.addActionListener(new ActionListener() { // from class: Salud_Ocupacional.JIFFTipoAgente.3
            public void actionPerformed(ActionEvent evt) {
                JIFFTipoAgente.this.jRadioButton2ActionPerformed(evt);
            }
        });
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap(-1, 32767).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jRadioButton1).addComponent(this.jRadioButton2))));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.jRadioButton1).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jRadioButton2).addGap(3, 3, 3)));
        this.jCheckBox1.setFont(new Font("Arial", 1, 12));
        this.jCheckBox1.setSelected(true);
        this.jCheckBox1.setText("Estado");
        this.jCheckBox1.addActionListener(new ActionListener() { // from class: Salud_Ocupacional.JIFFTipoAgente.4
            public void actionPerformed(ActionEvent evt) {
                JIFFTipoAgente.this.jCheckBox1ActionPerformed(evt);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JTFNombre, -2, 392, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel2, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jCheckBox1).addContainerGap(-1, 32767)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(5, 5, 5).addComponent(this.JTFNombre, -2, -1, -2)).addGroup(jPanel1Layout.createSequentialGroup().addGap(3, 3, 3).addComponent(this.jPanel2, -2, -1, -2)).addGroup(jPanel1Layout.createSequentialGroup().addGap(27, 27, 27).addComponent(this.jCheckBox1))).addContainerGap(-1, 32767)));
        this.jScrollPane1.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: Salud_Ocupacional.JIFFTipoAgente.5
            public void mouseClicked(MouseEvent evt) {
                JIFFTipoAgente.this.JTDetalleMouseClicked(evt);
            }
        });
        this.jScrollPane1.setViewportView(this.JTDetalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.jScrollPane1).addComponent(this.jPanel1, -1, -1, 32767)).addContainerGap(-1, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, 101, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane1, -1, 248, 32767).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jRadioButton1ActionPerformed(ActionEvent evt) {
        this.xTipo = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jRadioButton2ActionPerformed(ActionEvent evt) {
        this.xTipo = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox1ActionPerformed(ActionEvent evt) {
        if (this.jCheckBox1.isSelected()) {
            this.xEstado = 1;
        } else {
            this.xEstado = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        Principal.txtNo.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
        this.JTFNombre.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString());
        if (Integer.parseInt(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString()) == 0) {
            this.jRadioButton1.setSelected(true);
            this.xTipo = 0;
        } else {
            this.jRadioButton2.setSelected(true);
            this.xTipo = 1;
        }
        if (Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 4).toString()).booleanValue()) {
            this.jCheckBox1.setSelected(true);
        } else {
            this.jCheckBox1.setSelected(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosing(InternalFrameEvent evt) {
        Principal.mLimpiarDatosP();
    }

    public void mNuevo() {
        this.xEstado = 1;
        this.xTipo = 0;
        this.JTFNombre.setText("");
        this.jRadioButton1.setSelected(true);
        this.jCheckBox1.setSelected(true);
        Principal.mLimpiarDatosP();
    }

    public void mGuardar() {
        String sql;
        if (!this.JTFNombre.getText().isEmpty()) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                if (Principal.txtNo.getText().isEmpty()) {
                    sql = "INSERT INTO  `so_tipo_agentes` ( `Nbre`,`Tipo`,`Estado`, `UsuarioS`) VALUES ('" + this.JTFNombre.getText() + "','" + this.xTipo + "','" + this.xEstado + "','" + Principal.usuarioSistemaDTO.getLogin() + "');";
                } else {
                    sql = "UPDATE  `so_tipo_agentes` SET  `Nbre` = '" + this.JTFNombre.getText() + "', `Tipo` = '" + this.xTipo + "', `Estado` = '" + this.xEstado + "', `UsuarioS` = '" + Principal.usuarioSistemaDTO.getLogin() + "'\nWHERE `Id` = '" + Principal.txtNo.getText() + "'";
                }
                this.xct.ejecutarSQL(sql);
                this.xct.cerrarConexionBd();
                mNuevo();
                mCargarDatosTabla();
                return;
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "El campo Nombre no puede estar vacio", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JTFNombre.requestFocus();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCreaModelo() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Nombre", "Tip", "Tipo", "Estado"}) { // from class: Salud_Ocupacional.JIFFTipoAgente.6
            Class[] types = {Integer.class, String.class, Integer.class, String.class, Boolean.class};
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
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(2).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(2).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(60);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(10);
    }

    private void mCargarDatosTabla() {
        try {
            mCreaModelo();
            ResultSet xrs = this.xct.traerRs("SELECT `Id`,`Nbre`,Tipo,IF(`Tipo`=0,'Nivel Exposición','Factor de Riesgo') AS Tip,`Estado`  FROM  `so_tipo_agentes` ORDER BY Nbre");
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(Integer.valueOf(xrs.getInt(1)), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt(Integer.valueOf(xrs.getInt(3)), n, 2);
                    this.xmodelo.setValueAt(xrs.getString(4), n, 3);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(5)), n, 4);
                    n++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFGenerico1CheckBox1TextArea.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }
}
