package ParametrizacionN;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:ParametrizacionN/JIFSgcGlosario.class */
public class JIFSgcGlosario extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private Object[] xdato;
    private String xsql;
    private JCheckBox JCHEstado;
    private JPanel JPIDatos;
    private JPanel JPIHistorico;
    private JScrollPane JSPDTermino;
    private JScrollPane JSPDetalle;
    private JScrollPane JSPFuenteI;
    private JTextPane JTADTermino;
    private JTextPane JTAFuenteI;
    private JTable JTDetalle;
    private JTextField JTFBNombre;
    private JTextField JTFNombre;
    private JTabbedPane JTPDatos;
    private ConsultasMySQL xct = new ConsultasMySQL();
    private Metodos xmt = new Metodos();
    private int xestado = 1;
    private int xmodulo = 0;

    public JIFSgcGlosario(String xnombre) {
        initComponents();
        setName(xnombre);
        mNuevo();
        if (getName().equals("xjifglosario1")) {
            this.JTPDatos.setSelectedIndex(1);
            mCargarDatosTabla();
        }
    }

    /* JADX WARN: Type inference failed for: r3v36, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JTPDatos = new JTabbedPane();
        this.JPIDatos = new JPanel();
        this.JTFNombre = new JTextField();
        this.JSPDTermino = new JScrollPane();
        this.JTADTermino = new JTextPane();
        this.JSPFuenteI = new JScrollPane();
        this.JTAFuenteI = new JTextPane();
        this.JCHEstado = new JCheckBox();
        this.JPIHistorico = new JPanel();
        this.JTFBNombre = new JTextField();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("GLOSARIO SGC");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjifglosario");
        addInternalFrameListener(new InternalFrameListener() { // from class: ParametrizacionN.JIFSgcGlosario.1
            public void internalFrameClosed(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                JIFSgcGlosario.this.formInternalFrameClosing(evt);
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
        this.JTPDatos.setForeground(new Color(255, 0, 0));
        this.JTPDatos.setFont(new Font("Arial", 1, 14));
        this.JTFNombre.setFont(new Font("Arial", 1, 12));
        this.JTFNombre.setToolTipText("");
        this.JTFNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPDTermino.setBorder(BorderFactory.createTitledBorder((Border) null, "Descripción", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTADTermino.setFont(new Font("Arial", 1, 12));
        this.JSPDTermino.setViewportView(this.JTADTermino);
        this.JSPFuenteI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fuente de la Información", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTAFuenteI.setFont(new Font("Arial", 1, 12));
        this.JSPFuenteI.setViewportView(this.JTAFuenteI);
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setSelected(true);
        this.JCHEstado.setText("Estado");
        this.JCHEstado.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFSgcGlosario.2
            public void actionPerformed(ActionEvent evt) {
                JIFSgcGlosario.this.JCHEstadoActionPerformed(evt);
            }
        });
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JSPFuenteI, GroupLayout.Alignment.LEADING, -1, 686, 32767).addComponent(this.JSPDTermino, GroupLayout.Alignment.LEADING, -1, 686, 32767).addGroup(GroupLayout.Alignment.LEADING, JPIDatosLayout.createSequentialGroup().addComponent(this.JTFNombre, -2, 567, -2).addGap(18, 18, 18).addComponent(this.JCHEstado, -1, 101, 32767))).addContainerGap()));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JTFNombre, -2, -1, -2).addComponent(this.JCHEstado)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPDTermino, -2, 81, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPFuenteI, -2, 60, -2).addContainerGap(38, 32767)));
        this.JTPDatos.addTab("TERMINO", this.JPIDatos);
        this.JTFBNombre.setFont(new Font("Arial", 1, 12));
        this.JTFBNombre.setToolTipText("");
        this.JTFBNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFBNombre.addKeyListener(new KeyAdapter() { // from class: ParametrizacionN.JIFSgcGlosario.3
            public void keyPressed(KeyEvent evt) {
                JIFSgcGlosario.this.JTFBNombreKeyPressed(evt);
            }
        });
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalle.setSelectionMode(0);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFSgcGlosario.4
            public void mouseClicked(MouseEvent evt) {
                JIFSgcGlosario.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        GroupLayout JPIHistoricoLayout = new GroupLayout(this.JPIHistorico);
        this.JPIHistorico.setLayout(JPIHistoricoLayout);
        JPIHistoricoLayout.setHorizontalGroup(JPIHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIHistoricoLayout.createSequentialGroup().addContainerGap().addComponent(this.JTFBNombre, -1, 686, 32767).addContainerGap()).addGroup(JPIHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIHistoricoLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPDetalle, -1, 686, 32767).addContainerGap())));
        JPIHistoricoLayout.setVerticalGroup(JPIHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIHistoricoLayout.createSequentialGroup().addContainerGap().addComponent(this.JTFBNombre, -2, -1, -2).addContainerGap(196, 32767)).addGroup(JPIHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIHistoricoLayout.createSequentialGroup().addContainerGap(71, 32767).addComponent(this.JSPDetalle, -2, 166, -2).addContainerGap())));
        this.JTPDatos.addTab("HISTÓRICO", this.JPIHistorico);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTPDatos).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTPDatos, -2, 279, -2).addContainerGap(31, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFBNombreKeyPressed(KeyEvent evt) {
        if (!this.JTFBNombre.getText().isEmpty()) {
            mCargarDatosTabla();
        } else {
            mCargarDatosTabla();
        }
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
    public void formInternalFrameClosing(InternalFrameEvent evt) {
        if (getName().equals("xjifglosario")) {
            Principal.mLimpiarDatosP();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            if (getName().equals("xjifglosario")) {
                Principal.txtNo.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
            }
            this.JTFNombre.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString());
            this.JTADTermino.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString());
            this.JTAFuenteI.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString());
            this.JTPDatos.setSelectedIndex(0);
        }
    }

    public void mNuevo() {
        Principal.mLimpiarDatosP();
        this.JTFNombre.setText("");
        this.JTADTermino.setText("");
        this.JTAFuenteI.setText("");
        this.JTFBNombre.setText("");
        mCrearTablaDetalle();
        this.JTPDatos.setSelectedIndex(0);
        this.JTFNombre.requestFocus();
    }

    public void mGrabar() {
        if (!this.JTFNombre.getText().isEmpty()) {
            if (!this.JTADTermino.getText().isEmpty()) {
                int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (x == 0) {
                    if (Principal.txtNo.getText().isEmpty()) {
                        this.xsql = "insert into s_sgc_glosario (Nbre, Descripcion, FuenteInformacion, Estado, UsuarioS) values('" + this.JTFNombre.getText().toUpperCase() + "','" + this.JTADTermino.getText() + "','" + this.JTAFuenteI.getText() + "','" + this.xestado + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                        Principal.txtNo.setText(this.xct.ejecutarSQLId(this.xsql));
                        this.xct.cerrarConexionBd();
                    } else {
                        this.xsql = "update s_sgc_glosario set Nbre='" + this.JTFNombre.getText().toUpperCase() + "',Descripcion='" + this.JTADTermino.getText() + "',FuenteInformacion='" + this.JTAFuenteI.getText() + "',Estado='" + this.xestado + "',Fecha='" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "' where Id='" + Principal.txtNo.getText() + "'";
                        this.xct.ejecutarSQL(this.xsql);
                        this.xct.cerrarConexionBd();
                    }
                    mCargarDatosTabla();
                    return;
                }
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe digitar la descripción del termino", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTADTermino.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe digitar el termino", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JTFNombre.requestFocus();
    }

    private void mCrearTablaDetalle() {
        this.xmodelo = new DefaultTableModel((Object[][]) null, new String[]{"Id", "Termino", "Descripción", "Fuente", "Estado"}) { // from class: ParametrizacionN.JIFSgcGlosario.5
            Class[] types = {Long.class, String.class, String.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return this.canEdit[colIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(30);
    }

    private void mCargarDatosTabla() {
        mCrearTablaDetalle();
        if (getName().equals("xjifglosario")) {
            if (this.JTFBNombre.getText().isEmpty()) {
                this.xsql = "SELECT Id, Nbre, Descripcion, FuenteInformacion, Estado FROM s_sgc_glosario where Nbre like '" + this.JTFBNombre.getText() + "%'ORDER BY Nbre ASC ";
            } else {
                this.xsql = "SELECT Id, Nbre, Descripcion, FuenteInformacion, Estado FROM s_sgc_glosario ORDER BY Nbre ASC ";
            }
        } else if (getName().equals("xjifglosario1")) {
            if (this.JTFBNombre.getText().isEmpty()) {
                this.xsql = "SELECT Id, Nbre, Descripcion, FuenteInformacion, Estado FROM s_sgc_glosario ORDER BY Nbre ASC ";
            } else {
                this.xsql = "SELECT Id, Nbre, Descripcion, FuenteInformacion, Estado FROM s_sgc_glosario where Nbre like '" + this.JTFBNombre.getText() + "%'ORDER BY Nbre ASC ";
            }
        }
        ResultSet rs = this.xct.traerRs(this.xsql);
        try {
            if (rs.next()) {
                rs.beforeFirst();
                int x = 0;
                while (rs.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(Long.valueOf(rs.getLong(1)), x, 0);
                    this.xmodelo.setValueAt(rs.getString(2), x, 1);
                    this.xmodelo.setValueAt(rs.getString(3), x, 2);
                    this.xmodelo.setValueAt(rs.getString(4), x, 3);
                    this.xmodelo.setValueAt(Boolean.valueOf(rs.getBoolean(5)), x, 4);
                    x++;
                }
            }
            rs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            this.xct.mostrarErrorSQL(ex);
        }
    }
}
