package Laboratorio;

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
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Laboratorio/JIFComentarioxArea.class */
public class JIFComentarioxArea extends JInternalFrame {
    private String xsql;
    private DefaultTableModel xmodelo;
    private Object[] xdatos;
    private String[] xidarea;
    private ButtonGroup JBGTipo;
    private JComboBox JCBArea;
    private JCheckBox JCHEstado;
    private JEditorPane JEPDescripcion;
    private JPanel JPIDatos;
    private JPanel JPITipo;
    private JRadioButton JRBDescriptivo;
    private JRadioButton JRBSeleccion;
    private JScrollPane JSPDescripcion;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;
    private JTextField JTFNombre;
    private ConsultasMySQL xct = new ConsultasMySQL();
    private Metodos xmt = new Metodos();
    private int xestado = 1;
    private int xtipo = 0;

    public JIFComentarioxArea() {
        initComponents();
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v45, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGTipo = new ButtonGroup();
        this.JPIDatos = new JPanel();
        this.JCBArea = new JComboBox();
        this.JTFNombre = new JTextField();
        this.JSPDescripcion = new JScrollPane();
        this.JEPDescripcion = new JEditorPane();
        this.JPITipo = new JPanel();
        this.JRBDescriptivo = new JRadioButton();
        this.JRBSeleccion = new JRadioButton();
        this.JCHEstado = new JCheckBox();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("COMENTARIOS POR AREAS");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjifcomentarioarea");
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JCBArea.setFont(new Font("Arial", 1, 12));
        this.JCBArea.setBorder(BorderFactory.createTitledBorder((Border) null, "Area", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFNombre.setFont(new Font("Arial", 1, 12));
        this.JTFNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPDescripcion.setBorder(BorderFactory.createTitledBorder((Border) null, "Observaciones", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPDescripcion.setHorizontalScrollBarPolicy(31);
        this.JSPDescripcion.setVerticalScrollBarPolicy(21);
        this.JEPDescripcion.setBorder((Border) null);
        this.JEPDescripcion.setFont(new Font("Arial", 1, 12));
        this.JSPDescripcion.setViewportView(this.JEPDescripcion);
        this.JPITipo.setBorder(BorderFactory.createTitledBorder((Border) null, "TIPO", 2, 0, new Font("Arial", 1, 12), new Color(255, 0, 0)));
        this.JBGTipo.add(this.JRBDescriptivo);
        this.JRBDescriptivo.setFont(new Font("Arial", 1, 12));
        this.JRBDescriptivo.setSelected(true);
        this.JRBDescriptivo.setText("Descriptivo");
        this.JRBDescriptivo.addActionListener(new ActionListener() { // from class: Laboratorio.JIFComentarioxArea.1
            public void actionPerformed(ActionEvent evt) {
                JIFComentarioxArea.this.JRBDescriptivoActionPerformed(evt);
            }
        });
        this.JBGTipo.add(this.JRBSeleccion);
        this.JRBSeleccion.setFont(new Font("Arial", 1, 12));
        this.JRBSeleccion.setText("Seleccion");
        this.JRBSeleccion.addActionListener(new ActionListener() { // from class: Laboratorio.JIFComentarioxArea.2
            public void actionPerformed(ActionEvent evt) {
                JIFComentarioxArea.this.JRBSeleccionActionPerformed(evt);
            }
        });
        GroupLayout JPITipoLayout = new GroupLayout(this.JPITipo);
        this.JPITipo.setLayout(JPITipoLayout);
        JPITipoLayout.setHorizontalGroup(JPITipoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPITipoLayout.createSequentialGroup().addContainerGap().addComponent(this.JRBDescriptivo).addGap(18, 18, 18).addComponent(this.JRBSeleccion).addContainerGap(-1, 32767)));
        JPITipoLayout.setVerticalGroup(JPITipoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPITipoLayout.createSequentialGroup().addContainerGap().addGroup(JPITipoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBDescriptivo).addComponent(this.JRBSeleccion)).addContainerGap(-1, 32767)));
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setText("Estado");
        this.JCHEstado.addActionListener(new ActionListener() { // from class: Laboratorio.JIFComentarioxArea.3
            public void actionPerformed(ActionEvent evt) {
                JIFComentarioxArea.this.JCHEstadoActionPerformed(evt);
            }
        });
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JSPDescripcion, -2, 489, -2).addGap(18, 18, 18).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPITipo, -1, -1, 32767).addGroup(JPIDatosLayout.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.JCHEstado)))).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JCBArea, -2, 386, -2).addGap(18, 18, 18).addComponent(this.JTFNombre))).addContainerGap()));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFNombre, -2, 50, -2).addComponent(this.JCBArea, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JPITipo, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHEstado)).addComponent(this.JSPDescripcion)).addContainerGap(-1, 32767)));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalle.setSelectionMode(0);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: Laboratorio.JIFComentarioxArea.4
            public void mouseClicked(MouseEvent evt) {
                JIFComentarioxArea.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPIDatos, -1, -1, 32767).addComponent(this.JSPDetalle, -1, 769, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addGap(18, 18, 18).addComponent(this.JSPDetalle, -1, 229, 32767).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBDescriptivoActionPerformed(ActionEvent evt) {
        this.xtipo = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBSeleccionActionPerformed(ActionEvent evt) {
        this.xtipo = 1;
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
            this.JCBArea.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString());
            this.JTFNombre.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString());
            this.JEPDescripcion.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString());
            if (this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 4).toString().equals("Descriptivo")) {
                this.xtipo = 0;
                this.JRBDescriptivo.setSelected(true);
            } else {
                this.xtipo = 1;
                this.JRBSeleccion.setSelected(true);
            }
            this.JCHEstado.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 5).toString()).booleanValue());
            if (this.JCHEstado.isSelected()) {
                this.xestado = 1;
            } else {
                this.xestado = 0;
            }
        }
    }

    public void mNuevo() {
        Principal.mLimpiarDatosP();
        this.JCBArea.removeAllItems();
        this.xidarea = this.xct.llenarCombo("SELECT `Id`, `Nbre` FROM `l_areas` WHERE (`Estado` =0) ORDER BY `Nbre` ASC", this.xidarea, this.JCBArea);
        this.JCBArea.setSelectedIndex(-1);
        this.xct.cerrarConexionBd();
        this.JTFNombre.setText("");
        this.JEPDescripcion.setText("");
        this.JRBDescriptivo.setSelected(true);
        this.JCHEstado.setSelected(true);
        this.xestado = 1;
        this.xtipo = 0;
        mCargarDatosTabla();
        this.JCBArea.requestFocus();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Area", "Nombre", "Descripcion", "Tipo", "Estado"}) { // from class: Laboratorio.JIFComentarioxArea.5
            Class[] types = {Long.class, String.class, String.class, String.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(5);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(30);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(5);
    }

    public void mGrabar() {
        if (this.JCBArea.getSelectedIndex() != -1) {
            if (!this.JTFNombre.getText().isEmpty()) {
                int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (n == 0) {
                    if (Principal.txtNo.getText().isEmpty()) {
                        this.xsql = "insert into l_protocoloxtabla (`Id_Area` , `Nbre` , `Descripcion` , `Tipo` , `Estado` , `UsuarioS`) values('" + this.xidarea[this.JCBArea.getSelectedIndex()] + "','" + this.JTFNombre.getText().toUpperCase() + "','" + this.JEPDescripcion.getText() + "','" + this.xtipo + "','" + this.xestado + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                        Principal.txtNo.setText(this.xct.ejecutarSQLId(this.xsql));
                        this.xct.cerrarConexionBd();
                    } else {
                        this.xsql = "update l_protocoloxtabla set `Nbre`='" + this.JTFNombre.getText().toUpperCase() + "',`Descripcion`='" + this.JEPDescripcion.getText() + "',`Tipo`='" + this.xtipo + "',`Fecha`='" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "',`UsuarioS`='" + Principal.usuarioSistemaDTO.getLogin() + "' where Id='" + Principal.txtNo.getText() + "'";
                        this.xct.ejecutarSQL(this.xsql);
                        this.xct.cerrarConexionBd();
                    }
                    mCargarDatosTabla();
                    return;
                }
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "El campo nombre no puede ser nulo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTFNombre.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un area", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JCBArea.requestFocus();
    }

    private void mCargarDatosTabla() {
        try {
            mCrearModeloDatos();
            this.xsql = "SELECT `l_protocoloxtabla`.`Id` , `l_areas`.`Nbre` , `l_protocoloxtabla`.`Nbre` , IF(`l_protocoloxtabla`.`Descripcion` IS NULL, '', `l_protocoloxtabla`.`Descripcion`) AS Descriptivo , IF(`l_protocoloxtabla`.`Tipo`=0, 'Descriptivo', 'Seleccion') AS tipo, `l_protocoloxtabla`.`Estado` FROM `l_protocoloxtabla`  INNER JOIN  `l_areas`  ON (`l_protocoloxtabla`.`Id_Area` = `l_areas`.`Id`) ORDER BY `l_areas`.`Nbre` ASC, `l_protocoloxtabla`.`Nbre` ASC ";
            ResultSet xrs = this.xct.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(1)), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelo.setValueAt(xrs.getString(4), n, 3);
                    this.xmodelo.setValueAt(xrs.getString(5), n, 4);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(6)), n, 5);
                    n++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFComentarioxArea.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }
}
