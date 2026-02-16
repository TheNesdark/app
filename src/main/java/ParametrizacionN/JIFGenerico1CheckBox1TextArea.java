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
import java.io.File;
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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:ParametrizacionN/JIFGenerico1CheckBox1TextArea.class */
public class JIFGenerico1CheckBox1TextArea extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private Object[] xdatos;
    private String xnombre;
    private String xinformacion;
    private File xfile;
    private JCheckBox JCHEstado;
    private JPanel JPIDatos;
    private JScrollPane JSPDetalle;
    private JTextArea JTADescripcion;
    private JTable JTDetalle;
    private JTextField JTFNombre;
    private JScrollPane jScrollPane1;
    private ConsultasMySQL xconsulta = new ConsultasMySQL();
    private Metodos xmetodos = new Metodos();
    private int xestado = 1;
    private String xid = "";

    public JIFGenerico1CheckBox1TextArea(String xnombre, String xnombref) {
        initComponents();
        setName(xnombref);
        setTitle(xnombre.toUpperCase());
        this.xnombre = xnombre;
        mIniciarComponentes();
        mCargarDatosTabla();
    }

    /* JADX WARN: Type inference failed for: r3v29, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPIDatos = new JPanel();
        this.JTFNombre = new JTextField();
        this.JCHEstado = new JCheckBox();
        this.jScrollPane1 = new JScrollPane();
        this.JTADescripcion = new JTextArea();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("MUNICIPIO");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifgenerico1chbox");
        try {
            setSelected(true);
        } catch (PropertyVetoException e1) {
            e1.printStackTrace();
        }
        addInternalFrameListener(new InternalFrameListener() { // from class: ParametrizacionN.JIFGenerico1CheckBox1TextArea.1
            public void internalFrameActivated(InternalFrameEvent evt) {
            }

            public void internalFrameClosed(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                JIFGenerico1CheckBox1TextArea.this.formInternalFrameClosing(evt);
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
        this.JCHEstado.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFGenerico1CheckBox1TextArea.2
            public void actionPerformed(ActionEvent evt) {
                JIFGenerico1CheckBox1TextArea.this.JCHEstadoActionPerformed(evt);
            }
        });
        this.JTADescripcion.setColumns(1);
        this.JTADescripcion.setFont(new Font("Arial", 1, 13));
        this.JTADescripcion.setLineWrap(true);
        this.JTADescripcion.setRows(1);
        this.JTADescripcion.setBorder(BorderFactory.createTitledBorder((Border) null, "Descripción", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTADescripcion.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFGenerico1CheckBox1TextArea.3
            public void mouseClicked(MouseEvent evt) {
                JIFGenerico1CheckBox1TextArea.this.JTADescripcionMouseClicked(evt);
            }
        });
        this.jScrollPane1.setViewportView(this.JTADescripcion);
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jScrollPane1).addComponent(this.JTFNombre, -1, 501, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHEstado).addContainerGap()));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFNombre, -2, -1, -2).addComponent(this.JCHEstado)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane1, -1, 51, 32767).addContainerGap()));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalle.setSelectionMode(0);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFGenerico1CheckBox1TextArea.4
            public void mouseClicked(MouseEvent evt) {
                JIFGenerico1CheckBox1TextArea.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JPIDatos, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.JSPDetalle, GroupLayout.Alignment.LEADING, -1, 600, 32767)).addContainerGap(-1, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPDetalle, -1, 318, 32767).addContainerGap()));
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
            if (!this.xnombre.equals("SEG")) {
                Principal.txtNo.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
                this.JTFNombre.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString());
                this.JTADescripcion.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString());
                this.JCHEstado.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString()).booleanValue());
                if (this.JCHEstado.isSelected()) {
                    this.xestado = 1;
                } else {
                    this.xestado = 0;
                }
            }
            if (evt.getClickCount() == 2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosing(InternalFrameEvent evt) {
        Principal.mLimpiarDatosP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTADescripcionMouseClicked(MouseEvent evt) {
    }

    public void mNuevo() {
        Principal.mLimpiarDatosP();
        this.xid = "";
        this.JTFNombre.setText("");
        this.JTADescripcion.setText("");
        this.JCHEstado.setSelected(true);
        this.xestado = 1;
    }

    public void mGrabar() {
        if (!this.JTFNombre.getText().isEmpty()) {
            if (!this.JTADescripcion.getText().isEmpty()) {
                int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (n == 0) {
                    String sql = null;
                    if (Principal.txtNo.getText().isEmpty()) {
                        if (this.xnombre.equals("jifSEG")) {
                            sql = " Insert into so_tipo_segmento(Nbre,Descripcion, Estado, Fecha, UsuarioS)  values ('" + this.JTFNombre.getText().toUpperCase() + "','" + this.JTADescripcion.getText() + "','" + this.xestado + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                        }
                    } else if (this.xnombre.equals("jifSEG")) {
                        sql = " update so_tipo_segmento set Nbre='" + this.JTFNombre.getText().toUpperCase() + "', Descripcion='" + this.JTADescripcion.getText() + "',Estado='" + this.xestado + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
                    }
                    this.xconsulta.ejecutarSQL(sql);
                    this.xconsulta.cerrarConexionBd();
                    mCargarDatosTabla();
                    mNuevo();
                    return;
                }
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "El campo " + this.xinformacion + " no puede estar vacio", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTADescripcion.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "El campo nombre no puede estar vacio", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JTFNombre.requestFocus();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos(String[] xcabecera) {
        this.xmodelo = new DefaultTableModel(new Object[0], xcabecera) { // from class: ParametrizacionN.JIFGenerico1CheckBox1TextArea.5
            Class[] types = {Long.class, String.class, String.class, Boolean.class};
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
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(250);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(30);
    }

    private void mCargarDatosTabla() {
        try {
            String sql = null;
            String[] xencabezado = null;
            if (this.xnombre.equals("jifSEG")) {
                xencabezado = new String[]{"Id", "Nombre", "Descripción", "Estado"};
                sql = "SELECT `Id`  , `Nbre` , `Descripcion` , `Estado` FROM `so_tipo_segmento` ORDER BY Id";
            }
            mCrearModeloDatos(xencabezado);
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
            Logger.getLogger(JIFGenerico1CheckBox1TextArea.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mIniciarComponentes() {
        if (this.xnombre.equals("SEG")) {
            this.JTADescripcion.setBorder(BorderFactory.createTitledBorder((Border) null, "Descripcion", 0, 0, new Font("Arial", 1, 12), Color.blue));
            this.xinformacion = "descripcion";
        }
    }
}
