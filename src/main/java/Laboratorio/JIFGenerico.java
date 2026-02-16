package Laboratorio;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Dimension;
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

/* JADX INFO: loaded from: GenomaP.jar:Laboratorio/JIFGenerico.class */
public class JIFGenerico extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private Object[] xdatos;
    private String xnombre;
    private String xid;
    private ButtonGroup GenericRadio;
    private JCheckBox JCHEstado;
    private JPanel JPIDatos;
    private JPanel JPanel1;
    private JRadioButton JRadGenerico1;
    private JRadioButton JRadGenerico2;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;
    private JTextField JTFNombre;
    private ConsultasMySQL xconsulta = new ConsultasMySQL();
    private Metodos xmetodos = new Metodos();
    private int xestado = 1;
    private int xtipo = 0;
    private boolean xestadog = false;

    public JIFGenerico(String xnombre) {
        initComponents();
        setTitle(xnombre.toUpperCase());
        this.xnombre = xnombre;
        mIniciarComponentes();
        mCargarDatosTabla();
    }

    /* JADX WARN: Type inference failed for: r3v44, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.GenericRadio = new ButtonGroup();
        this.JPIDatos = new JPanel();
        this.JTFNombre = new JTextField();
        this.JCHEstado = new JCheckBox();
        this.JPanel1 = new JPanel();
        this.JRadGenerico1 = new JRadioButton();
        this.JRadGenerico2 = new JRadioButton();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        setClosable(true);
        setIconifiable(true);
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("GenericoLab");
        try {
            setSelected(true);
        } catch (PropertyVetoException e1) {
            e1.printStackTrace();
        }
        addInternalFrameListener(new InternalFrameListener() { // from class: Laboratorio.JIFGenerico.1
            public void internalFrameActivated(InternalFrameEvent evt) {
            }

            public void internalFrameClosed(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                JIFGenerico.this.formInternalFrameClosing(evt);
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
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTFNombre.setFont(new Font("Arial", 1, 12));
        this.JTFNombre.setToolTipText("");
        this.JTFNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setSelected(true);
        this.JCHEstado.setText("Estado");
        this.JCHEstado.addActionListener(new ActionListener() { // from class: Laboratorio.JIFGenerico.2
            public void actionPerformed(ActionEvent evt) {
                JIFGenerico.this.JCHEstadoActionPerformed(evt);
            }
        });
        this.JPanel1.setPreferredSize(new Dimension(124, 63));
        this.GenericRadio.add(this.JRadGenerico1);
        this.JRadGenerico1.setFont(new Font("Arial", 1, 12));
        this.JRadGenerico1.setText("<code text1>");
        this.JRadGenerico1.addActionListener(new ActionListener() { // from class: Laboratorio.JIFGenerico.3
            public void actionPerformed(ActionEvent evt) {
                JIFGenerico.this.JRadGenerico1ActionPerformed(evt);
            }
        });
        this.GenericRadio.add(this.JRadGenerico2);
        this.JRadGenerico2.setFont(new Font("Arial", 1, 12));
        this.JRadGenerico2.setText("<code text2>");
        this.JRadGenerico2.addActionListener(new ActionListener() { // from class: Laboratorio.JIFGenerico.4
            public void actionPerformed(ActionEvent evt) {
                JIFGenerico.this.JRadGenerico2ActionPerformed(evt);
            }
        });
        GroupLayout JPanel1Layout = new GroupLayout(this.JPanel1);
        this.JPanel1.setLayout(JPanel1Layout);
        JPanel1Layout.setHorizontalGroup(JPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPanel1Layout.createSequentialGroup().addContainerGap().addGroup(JPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JRadGenerico1, -1, -1, 32767).addComponent(this.JRadGenerico2, -1, -1, 32767)).addContainerGap(19, 32767)));
        JPanel1Layout.setVerticalGroup(JPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.JRadGenerico1).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRadGenerico2).addContainerGap(10, 32767)));
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosLayout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.JTFNombre, -2, 453, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHEstado).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPanel1, -2, -1, -2).addGap(10, 10, 10)));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFNombre, -2, -1, -2).addComponent(this.JCHEstado)).addContainerGap(-1, 32767)).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JPanel1, -1, 66, 32767).addContainerGap()));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalle.setSelectionMode(0);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: Laboratorio.JIFGenerico.5
            public void mouseClicked(MouseEvent evt) {
                JIFGenerico.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addContainerGap(-1, 32767)).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.JSPDetalle, -2, 682, -2).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalle, -2, 350, -2).addContainerGap()));
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
            this.xid = this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString();
            this.JTFNombre.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString());
            if ("RECHAZO".equals(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString())) {
                this.xtipo = 0;
                this.JRadGenerico1.setSelected(true);
            } else {
                this.xtipo = 1;
                this.JRadGenerico2.setSelected(true);
            }
            this.JCHEstado.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString()).booleanValue());
            this.xestadog = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosing(InternalFrameEvent evt) {
        Principal.mLimpiarDatosP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRadGenerico2ActionPerformed(ActionEvent evt) {
        this.xtipo = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRadGenerico1ActionPerformed(ActionEvent evt) {
        this.xtipo = 0;
    }

    public void mNuevo() {
        Principal.mLimpiarDatosP();
        this.JTFNombre.setText("");
        this.JCHEstado.setSelected(true);
        this.JRadGenerico1.setSelected(true);
        this.xestado = 1;
        this.xtipo = 0;
        this.xestadog = false;
    }

    public void mGrabar() {
        if (!this.JTFNombre.getText().isEmpty()) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "Verificar", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                String sql = null;
                if (this.xnombre.equals("Tipo Rechazo")) {
                    if (!this.xestadog) {
                        sql = " Insert into l_tipo_rechazo(Nbre, Tipo, Estado, Fecha, UsuarioS)  values ('" + this.JTFNombre.getText().toUpperCase() + "','" + this.xtipo + "','" + this.xestado + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                    } else {
                        sql = " update l_tipo_rechazo set Nbre='" + this.JTFNombre.getText().toUpperCase() + "',Tipo='" + this.xtipo + "',Estado='" + this.xestado + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + this.xid + "'";
                    }
                } else if (this.xnombre.equals("Tipos de Métodos")) {
                    if (!this.xestadog) {
                        sql = " Insert into l_tipo_metodo(Nbre, Estado, UsuarioS)  values ('" + this.JTFNombre.getText().toUpperCase() + "','" + this.xestado + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                    } else {
                        sql = " update l_tipo_metodo set Nbre='" + this.JTFNombre.getText().toUpperCase() + "',Estado='" + this.xestado + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + this.xid + "'";
                    }
                } else if (this.xnombre.equals("Tipo Encabezado")) {
                    if (!this.xestadog) {
                        sql = " Insert into l_tipo_encabezado(Nbre, Estado, UsuarioS)  values ('" + this.JTFNombre.getText().toUpperCase() + "','" + this.xestado + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                    } else {
                        sql = " update l_tipo_encabezado set Nbre='" + this.JTFNombre.getText().toUpperCase() + "',Estado='" + this.xestado + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + this.xid + "'";
                    }
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

    public void mEliminar() {
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Nombre", "Tipo", "Estado"}) { // from class: Laboratorio.JIFGenerico.6
            Class[] types = {String.class, String.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(250);
        if (this.xnombre.equals("Tipo Rechazo")) {
            this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(30);
        } else {
            this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(0);
            this.JTDetalle.getColumnModel().getColumn(2).setMinWidth(0);
            this.JTDetalle.getColumnModel().getColumn(2).setMaxWidth(0);
        }
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(30);
    }

    private void mCargarDatosTabla() {
        try {
            mCrearModeloDatos();
            String sql = null;
            if (this.xnombre.equals("Tipo Rechazo")) {
                sql = "SELECT Id , Nbre ,IF(Tipo=0,'RECHAZO','DEVOLUCION'), Estado FROM l_tipo_rechazo ORDER BY Nbre ASC";
            } else if (this.xnombre.equals("Tipos de Métodos")) {
                sql = "SELECT Id , Nbre ,'',Estado FROM l_tipo_metodo ORDER BY Nbre ASC";
            } else if (this.xnombre.equals("Tipo Encabezado")) {
                sql = "SELECT Id , Nbre ,'', Estado FROM l_tipo_encabezado ORDER BY Nbre ASC";
            }
            ResultSet xrs = this.xconsulta.traerRs(sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(xrs.getString(1), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(4)), n, 3);
                    n++;
                }
            }
            xrs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFGenerico.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mIniciarComponentes() {
        if (this.xnombre.equals("Tipo Rechazo")) {
            this.JPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo", 2, 2, new Font("Arial", 1, 12), new Color(0, 103, 0)));
            this.JRadGenerico1.setText("Rechazo");
            this.JRadGenerico1.setSelected(true);
            this.JRadGenerico2.setText("Devolucion");
            this.JRadGenerico2.setToolTipText("Demanda No Atentida");
            return;
        }
        this.JPanel1.setSize(124, 63);
        this.JRadGenerico1.setVisible(false);
        this.JRadGenerico2.setVisible(false);
    }
}
