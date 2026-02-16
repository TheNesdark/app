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
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:ParametrizacionN/JIFCentroCosto.class */
public class JIFCentroCosto extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private Object[] xdatos;
    private JCheckBox JCHEsContabilidad;
    private JCheckBox JCHEsOdontologia;
    private JCheckBox JCHEsServicio;
    private JCheckBox JCHEsSubGrupo;
    private JCheckBox JCHEstado;
    private JPanel JPanel1;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;
    private JTextField JTFCodigo;
    private JTextField JTFNombre;
    private ConsultasMySQL xconsulta = new ConsultasMySQL();
    private Metodos xmetodos = new Metodos();
    private int xestado = 0;
    private int xessubgrupo = 0;
    private int xesodontologico = 0;
    private int xesservicio = 0;
    private int xescontabilidad = 0;
    String sql = null;

    public JIFCentroCosto() {
        initComponents();
        mCargartabla();
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v49, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPanel1 = new JPanel();
        this.JTFCodigo = new JTextField();
        this.JTFNombre = new JTextField();
        this.JCHEsOdontologia = new JCheckBox();
        this.JCHEsServicio = new JCheckBox();
        this.JCHEsContabilidad = new JCheckBox();
        this.JCHEsSubGrupo = new JCheckBox();
        this.JCHEstado = new JCheckBox();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("CENTRO DE COSTOS");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("Centro de Costo");
        this.JPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACION", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTFCodigo.setFont(new Font("Arial", 1, 12));
        this.JTFCodigo.setBorder(BorderFactory.createTitledBorder((Border) null, "Codigo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFNombre.setFont(new Font("Arial", 1, 12));
        this.JTFNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHEsOdontologia.setFont(new Font("Arial", 1, 12));
        this.JCHEsOdontologia.setForeground(Color.blue);
        this.JCHEsOdontologia.setText("Es Odontologia?");
        this.JCHEsOdontologia.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFCentroCosto.1
            public void actionPerformed(ActionEvent evt) {
                JIFCentroCosto.this.JCHEsOdontologiaActionPerformed(evt);
            }
        });
        this.JCHEsServicio.setFont(new Font("Arial", 1, 12));
        this.JCHEsServicio.setForeground(Color.blue);
        this.JCHEsServicio.setText("Es Servicio?");
        this.JCHEsServicio.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFCentroCosto.2
            public void actionPerformed(ActionEvent evt) {
                JIFCentroCosto.this.JCHEsServicioActionPerformed(evt);
            }
        });
        this.JCHEsContabilidad.setFont(new Font("Arial", 1, 12));
        this.JCHEsContabilidad.setForeground(Color.blue);
        this.JCHEsContabilidad.setText("Es Contabilidad?");
        this.JCHEsContabilidad.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFCentroCosto.3
            public void actionPerformed(ActionEvent evt) {
                JIFCentroCosto.this.JCHEsContabilidadActionPerformed(evt);
            }
        });
        this.JCHEsSubGrupo.setFont(new Font("Arial", 1, 12));
        this.JCHEsSubGrupo.setForeground(Color.blue);
        this.JCHEsSubGrupo.setText("Es Subgrupo?");
        this.JCHEsSubGrupo.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFCentroCosto.4
            public void actionPerformed(ActionEvent evt) {
                JIFCentroCosto.this.JCHEsSubGrupoActionPerformed(evt);
            }
        });
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setForeground(Color.blue);
        this.JCHEstado.setText("Estado");
        this.JCHEstado.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFCentroCosto.5
            public void actionPerformed(ActionEvent evt) {
                JIFCentroCosto.this.JCHEstadoActionPerformed(evt);
            }
        });
        GroupLayout JPanel1Layout = new GroupLayout(this.JPanel1);
        this.JPanel1.setLayout(JPanel1Layout);
        JPanel1Layout.setHorizontalGroup(JPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.JTFCodigo, -2, 111, -2).addGap(18, 18, 18).addComponent(this.JTFNombre, -2, 478, -2).addGap(0, 0, 32767)).addGroup(JPanel1Layout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.JCHEsOdontologia).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHEsServicio, -2, 112, -2).addGap(18, 18, 18).addComponent(this.JCHEsContabilidad).addGap(28, 28, 28).addComponent(this.JCHEsSubGrupo).addGap(29, 29, 29).addComponent(this.JCHEstado).addContainerGap()));
        JPanel1Layout.setVerticalGroup(JPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPanel1Layout.createSequentialGroup().addContainerGap().addGroup(JPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFCodigo, -2, 50, -2).addComponent(this.JTFNombre, -2, 50, -2)).addGap(18, 18, 18).addGroup(JPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCHEsOdontologia).addComponent(this.JCHEsServicio).addComponent(this.JCHEsContabilidad).addComponent(this.JCHEsSubGrupo).addComponent(this.JCHEstado)).addContainerGap(-1, 32767)));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFCentroCosto.6
            public void mouseClicked(MouseEvent evt) {
                JIFCentroCosto.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(10, 10, 10).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPanel1, -1, -1, 32767).addComponent(this.JSPDetalle)).addGap(10, 10, 10)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.JPanel1, -2, -1, -2).addGap(10, 10, 10).addComponent(this.JSPDetalle, -2, 282, -2).addGap(10, 10, 10)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            Principal.txtNo.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
            this.JTFCodigo.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
            this.JTFNombre.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString());
            this.JCHEsOdontologia.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString()).booleanValue());
            if (this.JCHEsOdontologia.isSelected()) {
                this.xesodontologico = 1;
            } else {
                this.xesodontologico = 0;
            }
            this.JCHEsServicio.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString()).booleanValue());
            if (this.JCHEsServicio.isSelected()) {
                this.xesservicio = 1;
            } else {
                this.xesservicio = 0;
            }
            this.JCHEsContabilidad.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 4).toString()).booleanValue());
            if (this.JCHEsContabilidad.isSelected()) {
                this.xescontabilidad = 1;
            } else {
                this.xescontabilidad = 0;
            }
            this.JCHEsSubGrupo.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 5).toString()).booleanValue());
            if (this.JCHEsSubGrupo.isSelected()) {
                this.xessubgrupo = 1;
            } else {
                this.xessubgrupo = 0;
            }
            this.JCHEstado.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 6).toString()).booleanValue());
            if (this.JCHEstado.isSelected()) {
                this.xestado = 1;
            } else {
                this.xestado = 0;
            }
        }
        this.JTFCodigo.setEnabled(false);
    }

    public void mNuevo() {
        Principal.txtNo.setText("");
        this.JTFCodigo.setText("");
        this.JTFNombre.setText("");
        this.JCHEstado.setSelected(true);
        this.xestado = 1;
        this.JCHEsOdontologia.setSelected(false);
        this.xesodontologico = 0;
        this.JCHEsContabilidad.setSelected(false);
        this.xescontabilidad = 0;
        this.JCHEsServicio.setSelected(false);
        this.xesservicio = 0;
        this.JCHEsSubGrupo.setSelected(false);
        this.xessubgrupo = 0;
        this.JTFCodigo.setEnabled(true);
        this.JTFCodigo.requestFocus();
        mCargartabla();
    }

    public void mGrabar() {
        if (!this.JTFCodigo.getText().isEmpty()) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                this.sql = null;
                if (Principal.txtNo.getText().isEmpty()) {
                    this.sql = "   INSERT IGNORE INTO f_centrocosto(Id,Nbre,Odontologia, Estado,servicio,Contabilidad,SubGrupo,Fecha,UsuarioS)VALUES('" + this.JTFCodigo.getText() + "','" + this.JTFNombre.getText().toUpperCase() + "','" + this.xesodontologico + "','" + this.xestado + "','" + this.xesservicio + "','" + this.xescontabilidad + "','" + this.xessubgrupo + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                } else {
                    this.sql = "UPDATE f_centrocosto SET Nbre = '" + this.JTFNombre.getText().toUpperCase() + "',Odontologia = '" + this.xesodontologico + "',Estado= '" + this.xestado + "',servicio = '" + this.xesservicio + "',Contabilidad = '" + this.xescontabilidad + "',SubGrupo = '" + this.xessubgrupo + "', UsuarioS = '" + Principal.usuarioSistemaDTO.getLogin() + "'WHERE `Id` = '" + Principal.txtNo.getText() + "'";
                }
                this.xconsulta.ejecutarSQL(this.sql);
                this.xconsulta.cerrarConexionBd();
                mCargartabla();
                mNuevo();
                this.JTFCodigo.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe Digitar un ID ", "VERFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTFCodigo.requestFocus();
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Nombre", "Odontologia", "Servicio?", "Contabilidad", "Subgrupo", "Estado"}) { // from class: ParametrizacionN.JIFCentroCosto.7
            Class[] types = {Long.class, String.class, Boolean.class, Boolean.class, Boolean.class, Boolean.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(60);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(10);
    }

    private void mCargartabla() {
        try {
            mCrearModeloDatos();
            ResultSet xrs = this.xconsulta.traerRs("SELECT `Id`,`Nbre`,`Odontologia`,`servicio`,`Contabilidad`,`SubGrupo`,`Estado`FROM`f_centrocosto`;");
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(1)), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(3)), n, 2);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(4)), n, 3);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(5)), n, 4);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(6)), n, 5);
                    this.xmodelo.setValueAt(Boolean.valueOf(!xrs.getBoolean(7)), n, 6);
                    n++;
                }
            }
            xrs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFGenericoCh.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEsOdontologiaActionPerformed(ActionEvent evt) {
        if (this.JCHEsOdontologia.isSelected()) {
            this.xesodontologico = 1;
        } else {
            this.xesodontologico = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEsServicioActionPerformed(ActionEvent evt) {
        if (this.JCHEsServicio.isSelected()) {
            this.xesservicio = 1;
        } else {
            this.xesservicio = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEsContabilidadActionPerformed(ActionEvent evt) {
        if (this.JCHEsContabilidad.isSelected()) {
            this.xescontabilidad = 1;
        } else {
            this.xescontabilidad = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEsSubGrupoActionPerformed(ActionEvent evt) {
        if (this.JCHEsSubGrupo.isSelected()) {
            this.xessubgrupo = 1;
        } else {
            this.xessubgrupo = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEstadoActionPerformed(ActionEvent evt) {
        if (this.JCHEstado.isSelected()) {
            this.xestado = 0;
        } else {
            this.xestado = 1;
        }
    }
}
