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

/* JADX INFO: loaded from: GenomaP.jar:ParametrizacionN/JIFTipoRespuesta.class */
public class JIFTipoRespuesta extends JInternalFrame {
    private ConsultasMySQL xconsulta = new ConsultasMySQL();
    private Metodos xmetodos = new Metodos();
    private int xestado = 1;
    private int xtiporespuesta = 0;
    private DefaultTableModel xmodelo;
    private Object[] xdatos;
    private String[] xidgenerico;
    private ButtonGroup JBRGTipo;
    private JCheckBox JCHEstado;
    private JPanel JPIDatos;
    private JPanel JPTipo;
    private JRadioButton JRBDescriptivo;
    private JRadioButton JRBNumerico;
    private JRadioButton JRBSeleccion;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;
    private JTextField JTFNombre;

    public JIFTipoRespuesta() {
        initComponents();
        mNuevo();
        mCargarDatosTabla();
    }

    /* JADX WARN: Type inference failed for: r3v48, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBRGTipo = new ButtonGroup();
        this.JPIDatos = new JPanel();
        this.JTFNombre = new JTextField();
        this.JCHEstado = new JCheckBox();
        this.JPTipo = new JPanel();
        this.JRBNumerico = new JRadioButton();
        this.JRBDescriptivo = new JRadioButton();
        this.JRBSeleccion = new JRadioButton();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("TIPO DE RESPUESTAS");
        setToolTipText("");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifSoTipoRespuesta");
        try {
            setSelected(true);
        } catch (PropertyVetoException e1) {
            e1.printStackTrace();
        }
        addInternalFrameListener(new InternalFrameListener() { // from class: ParametrizacionN.JIFTipoRespuesta.1
            public void internalFrameClosed(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                JIFTipoRespuesta.this.formInternalFrameClosing(evt);
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
        this.JTFNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setSelected(true);
        this.JCHEstado.setText("Estado");
        this.JCHEstado.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFTipoRespuesta.2
            public void actionPerformed(ActionEvent evt) {
                JIFTipoRespuesta.this.JCHEstadoActionPerformed(evt);
            }
        });
        this.JPTipo.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JBRGTipo.add(this.JRBNumerico);
        this.JRBNumerico.setFont(new Font("Arial", 1, 12));
        this.JRBNumerico.setText("Numérico");
        this.JRBNumerico.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFTipoRespuesta.3
            public void actionPerformed(ActionEvent evt) {
                JIFTipoRespuesta.this.JRBNumericoActionPerformed(evt);
            }
        });
        this.JBRGTipo.add(this.JRBDescriptivo);
        this.JRBDescriptivo.setFont(new Font("Arial", 1, 12));
        this.JRBDescriptivo.setText("Descriptivo");
        this.JRBDescriptivo.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFTipoRespuesta.4
            public void actionPerformed(ActionEvent evt) {
                JIFTipoRespuesta.this.JRBDescriptivoActionPerformed(evt);
            }
        });
        this.JBRGTipo.add(this.JRBSeleccion);
        this.JRBSeleccion.setFont(new Font("Arial", 1, 12));
        this.JRBSeleccion.setText("Selección");
        this.JRBSeleccion.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFTipoRespuesta.5
            public void actionPerformed(ActionEvent evt) {
                JIFTipoRespuesta.this.JRBSeleccionActionPerformed(evt);
            }
        });
        GroupLayout JPTipoLayout = new GroupLayout(this.JPTipo);
        this.JPTipo.setLayout(JPTipoLayout);
        JPTipoLayout.setHorizontalGroup(JPTipoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPTipoLayout.createSequentialGroup().addContainerGap().addComponent(this.JRBNumerico).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBDescriptivo).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBSeleccion).addGap(6, 6, 6)));
        JPTipoLayout.setVerticalGroup(JPTipoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPTipoLayout.createSequentialGroup().addGroup(JPTipoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBNumerico).addComponent(this.JRBDescriptivo).addComponent(this.JRBSeleccion)).addGap(6, 6, 6)));
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosLayout.createSequentialGroup().addContainerGap().addComponent(this.JTFNombre, -2, 321, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPTipo, -1, -1, 32767).addGap(5, 5, 5).addComponent(this.JCHEstado).addContainerGap()));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JPTipo, -2, -1, -2).addGroup(GroupLayout.Alignment.LEADING, JPIDatosLayout.createSequentialGroup().addGap(3, 3, 3).addComponent(this.JTFNombre, -2, 50, -2))).addGroup(JPIDatosLayout.createSequentialGroup().addGap(16, 16, 16).addComponent(this.JCHEstado))).addContainerGap(-1, 32767)));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalle.setSelectionMode(0);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFTipoRespuesta.6
            public void mouseClicked(MouseEvent evt) {
                JIFTipoRespuesta.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JPIDatos, -1, -1, 32767).addComponent(this.JSPDetalle)).addContainerGap(-1, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPDetalle, -1, 251, 32767).addContainerGap()));
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
            if (this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).equals("Numérico")) {
                this.JRBNumerico.setSelected(true);
            } else if (this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).equals("Descriptivo")) {
                this.JRBDescriptivo.setSelected(true);
            } else {
                this.JRBSeleccion.setSelected(true);
            }
            this.JCHEstado.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString()).booleanValue());
            if (this.JCHEstado.isSelected()) {
                this.xestado = 1;
            } else {
                this.xestado = 0;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosing(InternalFrameEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBNumericoActionPerformed(ActionEvent evt) {
        this.xtiporespuesta = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBDescriptivoActionPerformed(ActionEvent evt) {
        this.xtiporespuesta = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBSeleccionActionPerformed(ActionEvent evt) {
        this.xtiporespuesta = 2;
    }

    public void mNuevo() {
        Principal.mLimpiarDatosP();
        this.JTFNombre.setText("");
        this.JCHEstado.setSelected(true);
        this.xestado = 1;
        this.JTFNombre.requestFocus();
        this.xtiporespuesta = 0;
        this.JRBNumerico.setSelected(true);
    }

    public void mGrabar() {
        String sql;
        if (!this.JTFNombre.getText().isEmpty()) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                if (Principal.txtNo.getText().isEmpty()) {
                    sql = " Insert into so_tipo_respuesta(`Nbre`  , `Tipo`  , `Estado`  , `UsuarioS`)  values ('" + this.JTFNombre.getText() + "','" + this.xtiporespuesta + "','" + this.xestado + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                } else {
                    sql = " update so_tipo_respuesta set Nbre='" + this.JTFNombre.getText() + "',Tipo='" + this.xtiporespuesta + "', Estado='" + this.xestado + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
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
        this.xmodelo = new DefaultTableModel(new Object[0], xcabecera) { // from class: ParametrizacionN.JIFTipoRespuesta.7
            Class[] types = {Integer.class, String.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false};

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
    }

    private void mCargarDatosTabla() {
        try {
            String[] xencabezado = {"Id", "Nombre", "Tipo", "Estado"};
            mCrearModeloDatos(xencabezado);
            ResultSet xrs = this.xconsulta.traerRs("SELECT `Id` , `Nbre`  , IF(`Tipo`=0,'Numérico',IF(`Tipo`=1,'Descriptivo','Selección')) AS Tipo , `Estado` FROM `so_tipo_respuesta` ORDER BY Tipo,Nbre ");
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(Integer.valueOf(xrs.getInt(1)), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(4)), n, 3);
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
