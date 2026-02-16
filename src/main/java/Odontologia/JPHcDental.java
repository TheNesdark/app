package Odontologia;

import Acceso.Principal;
import Historia.JPAAntecentesFamiliares;
import Historia.clasesHistoriaCE;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Odontologia/JPHcDental.class */
public class JPHcDental extends JPanel {
    private String[] xtipo;
    private String[] xdetalle;
    private String[] xtiporespuesta;
    private DefaultTableModel xmodelo;
    private clasesHistoriaCE xclase;
    private Object[] xdato;
    private int xmod;
    public long xidusuario;
    private String xidatencion;
    private JIFHistoriaOdontologica xjifcho;
    private String xsql;
    private ButtonGroup JBGVive;
    private JButton JBTAdicionarAntCli;
    public JComboBox JCBRespuesta;
    public JComboBox JCBTipo;
    public JComboBox JCBTipoDetale;
    private JPanel JPIAntecendesClinicos;
    private JScrollPane JSPDescripcion;
    private JScrollPane JSPHistorial;
    private JTable JTHistorial;
    private JTextPane JTPDescripcion;
    private Metodos xmt = new Metodos();
    private ConsultasMySQL xct = new ConsultasMySQL();
    private boolean xlleno = false;
    private boolean xlleno1 = false;

    public JPHcDental(clasesHistoriaCE xclase, int xmod) {
        this.xmod = -1;
        initComponents();
        this.xmod = xmod;
        this.xclase = xclase;
        mNuevo();
    }

    public JPHcDental(JIFHistoriaOdontologica xjifcho, int xmod) {
        this.xmod = -1;
        initComponents();
        this.xmod = xmod;
        this.xjifcho = xjifcho;
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v42, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGVive = new ButtonGroup();
        this.JPIAntecendesClinicos = new JPanel();
        this.JCBTipo = new JComboBox();
        this.JCBTipoDetale = new JComboBox();
        this.JCBRespuesta = new JComboBox();
        this.JSPDescripcion = new JScrollPane();
        this.JTPDescripcion = new JTextPane();
        this.JBTAdicionarAntCli = new JButton();
        this.JSPHistorial = new JScrollPane();
        this.JTHistorial = new JTable();
        setName("jifantecfamiliares");
        setPreferredSize(new Dimension(835, 386));
        this.JPIAntecendesClinicos.setBorder(BorderFactory.createTitledBorder((Border) null, "", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JCBTipo.setFont(new Font("Arial", 1, 12));
        this.JCBTipo.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTipo.addItemListener(new ItemListener() { // from class: Odontologia.JPHcDental.1
            public void itemStateChanged(ItemEvent evt) {
                JPHcDental.this.JCBTipoItemStateChanged(evt);
            }
        });
        this.JCBTipo.addKeyListener(new KeyAdapter() { // from class: Odontologia.JPHcDental.2
            public void keyPressed(KeyEvent evt) {
                JPHcDental.this.JCBTipoKeyPressed(evt);
            }
        });
        this.JCBTipoDetale.setFont(new Font("Arial", 1, 12));
        this.JCBTipoDetale.setBorder(BorderFactory.createTitledBorder((Border) null, "Detalle", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTipoDetale.addItemListener(new ItemListener() { // from class: Odontologia.JPHcDental.3
            public void itemStateChanged(ItemEvent evt) {
                JPHcDental.this.JCBTipoDetaleItemStateChanged(evt);
            }
        });
        this.JCBTipoDetale.addKeyListener(new KeyAdapter() { // from class: Odontologia.JPHcDental.4
            public void keyPressed(KeyEvent evt) {
                JPHcDental.this.JCBTipoDetaleKeyPressed(evt);
            }
        });
        this.JCBRespuesta.setFont(new Font("Arial", 1, 12));
        this.JCBRespuesta.setBorder(BorderFactory.createTitledBorder((Border) null, "Respuesta", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBRespuesta.addKeyListener(new KeyAdapter() { // from class: Odontologia.JPHcDental.5
            public void keyPressed(KeyEvent evt) {
                JPHcDental.this.JCBRespuestaKeyPressed(evt);
            }
        });
        this.JSPDescripcion.setBorder(BorderFactory.createTitledBorder((Border) null, "Descripción", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTPDescripcion.setFont(new Font("Arial", 1, 12));
        this.JTPDescripcion.addKeyListener(new KeyAdapter() { // from class: Odontologia.JPHcDental.6
            public void keyPressed(KeyEvent evt) {
                JPHcDental.this.JTPDescripcionKeyPressed(evt);
            }
        });
        this.JSPDescripcion.setViewportView(this.JTPDescripcion);
        this.JBTAdicionarAntCli.setFont(new Font("Arial", 1, 14));
        this.JBTAdicionarAntCli.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTAdicionarAntCli.addActionListener(new ActionListener() { // from class: Odontologia.JPHcDental.7
            public void actionPerformed(ActionEvent evt) {
                JPHcDental.this.JBTAdicionarAntCliActionPerformed(evt);
            }
        });
        this.JBTAdicionarAntCli.addKeyListener(new KeyAdapter() { // from class: Odontologia.JPHcDental.8
            public void keyPressed(KeyEvent evt) {
                JPHcDental.this.JBTAdicionarAntCliKeyPressed(evt);
            }
        });
        GroupLayout JPIAntecendesClinicosLayout = new GroupLayout(this.JPIAntecendesClinicos);
        this.JPIAntecendesClinicos.setLayout(JPIAntecendesClinicosLayout);
        JPIAntecendesClinicosLayout.setHorizontalGroup(JPIAntecendesClinicosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIAntecendesClinicosLayout.createSequentialGroup().addContainerGap().addGroup(JPIAntecendesClinicosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPDescripcion, -1, 779, 32767).addGroup(JPIAntecendesClinicosLayout.createSequentialGroup().addComponent(this.JCBTipo, -2, 279, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBTipoDetale, 0, 296, 32767).addGap(18, 18, 18).addComponent(this.JCBRespuesta, -2, 176, -2)).addComponent(this.JBTAdicionarAntCli, -1, 779, 32767)).addContainerGap()));
        JPIAntecendesClinicosLayout.setVerticalGroup(JPIAntecendesClinicosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIAntecendesClinicosLayout.createSequentialGroup().addGroup(JPIAntecendesClinicosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBTipoDetale, -2, -1, -2).addComponent(this.JCBRespuesta, -2, -1, -2).addComponent(this.JCBTipo, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDescripcion, -2, 56, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTAdicionarAntCli, -2, 43, -2)));
        this.JSPHistorial.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTORIAL", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JSPHistorial.setFont(new Font("Arial", 1, 12));
        this.JTHistorial.setFont(new Font("Arial", 1, 12));
        this.JTHistorial.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTHistorial.setRowHeight(25);
        this.JTHistorial.setSelectionBackground(new Color(255, 255, 255));
        this.JTHistorial.setSelectionForeground(new Color(255, 0, 0));
        this.JTHistorial.setSelectionMode(0);
        this.JTHistorial.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPHcDental.9
            public void mouseClicked(MouseEvent evt) {
                JPHcDental.this.JTHistorialMouseClicked(evt);
            }
        });
        this.JSPHistorial.setViewportView(this.JTHistorial);
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPHistorial, GroupLayout.Alignment.TRAILING, -1, 815, 32767).addComponent(this.JPIAntecendesClinicos, GroupLayout.Alignment.TRAILING, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIAntecendesClinicos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPHistorial, -2, 169, -2).addContainerGap(41, 32767)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTAdicionarAntCliActionPerformed(ActionEvent evt) {
        mGrabarBd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTPDescripcionKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 9) {
            this.JTPDescripcion.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTAdicionarAntCliKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            mGrabarBd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBTipoDetaleKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JCBTipoDetale.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBRespuestaKeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBTipoDetaleItemStateChanged(ItemEvent evt) {
        if (this.xlleno1 && this.JCBTipoDetale.getSelectedIndex() != -1) {
            ConsultasMySQL xct1 = new ConsultasMySQL();
            this.JCBRespuesta.removeAllItems();
            this.xsql = "SELECT o_tipo_parametros.Id, o_tipo_parametros.Nbre FROM o_tipo_contenidoxdescripcion INNER JOIN o_tipo_contenido_descripcion  ON (o_tipo_contenidoxdescripcion.Id_tipo_adescripcion = o_tipo_contenido_descripcion.Id) INNER JOIN o_tipo_descripcionxparametro  ON (o_tipo_descripcionxparametro.Id_cdescipcion = o_tipo_contenido_descripcion.Id) INNER JOIN o_tipo_parametros  ON (o_tipo_descripcionxparametro.Id_TipoParametro = o_tipo_parametros.Id) WHERE (o_tipo_contenidoxdescripcion.Id ='" + this.xdetalle[this.JCBTipoDetale.getSelectedIndex()] + "' AND o_tipo_descripcionxparametro.Estado =1) ORDER BY o_tipo_descripcionxparametro.NOrden ASC ";
            this.xtiporespuesta = xct1.llenarCombo(this.xsql, this.xtiporespuesta, this.JCBRespuesta);
            this.JCBRespuesta.setSelectedIndex(-1);
            xct1.cerrarConexionBd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTHistorialMouseClicked(MouseEvent evt) {
        if (this.JTHistorial.getSelectedRow() != -1) {
            this.JCBTipoDetale.setSelectedItem(this.xmodelo.getValueAt(this.JTHistorial.getSelectedRow(), 0));
            this.JCBRespuesta.setSelectedItem(this.xmodelo.getValueAt(this.JTHistorial.getSelectedRow(), 1));
            this.JTPDescripcion.setText(this.xmodelo.getValueAt(this.JTHistorial.getSelectedRow(), 2).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBTipoItemStateChanged(ItemEvent evt) {
        if (this.xlleno && this.JCBTipo.getSelectedIndex() != -1) {
            this.xlleno1 = false;
            ConsultasMySQL xct2 = new ConsultasMySQL();
            this.JCBRespuesta.removeAllItems();
            this.JCBTipoDetale.removeAllItems();
            this.xsql = "SELECT o_tipo_contenidoxdescripcion.Id, o_tipo_contenido_descripcion.Nbre FROM o_tipo_contenidoxdescripcion INNER JOIN o_tipo_contenido_descripcion  ON (o_tipo_contenidoxdescripcion.Id_tipo_adescripcion = o_tipo_contenido_descripcion.Id) INNER JOIN o_tipo_descripcionxparametro  ON (o_tipo_descripcionxparametro.Id_cdescipcion = o_tipo_contenido_descripcion.Id) INNER JOIN o_tipo_parametros  ON (o_tipo_descripcionxparametro.Id_TipoParametro = o_tipo_parametros.Id) WHERE (o_tipo_contenidoxdescripcion.Id_tipo_contenido ='" + this.xtipo[this.JCBTipo.getSelectedIndex()] + "' AND o_tipo_contenidoxdescripcion.Estado =1) GROUP BY o_tipo_contenidoxdescripcion.Id ORDER BY o_tipo_contenidoxdescripcion.NOrden ASC ";
            this.xdetalle = xct2.llenarCombo(this.xsql, this.xdetalle, this.JCBTipoDetale);
            xct2.cerrarConexionBd();
            this.JCBTipoDetale.setSelectedIndex(-1);
            this.xlleno1 = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBTipoKeyPressed(KeyEvent evt) {
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTabla() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Tipo", "Detalle", "Respuesta", "Descripción", "IdUsuario", "IdTipo"}) { // from class: Odontologia.JPHcDental.10
            Class[] types = {String.class, String.class, String.class, String.class, String.class, Long.class, Long.class};
            boolean[] canEdit = {false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTHistorial.setModel(this.xmodelo);
        this.JTHistorial.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTHistorial.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTHistorial.getColumnModel().getColumn(2).setPreferredWidth(20);
        this.JTHistorial.getColumnModel().getColumn(3).setPreferredWidth(250);
        this.JTHistorial.getColumnModel().getColumn(4).setPreferredWidth(0);
        this.JTHistorial.getColumnModel().getColumn(4).setMinWidth(0);
        this.JTHistorial.getColumnModel().getColumn(4).setMaxWidth(0);
        this.JTHistorial.getColumnModel().getColumn(5).setPreferredWidth(0);
        this.JTHistorial.getColumnModel().getColumn(5).setMinWidth(0);
        this.JTHistorial.getColumnModel().getColumn(5).setMaxWidth(0);
    }

    private void mBuscarDatosBd() {
        try {
            String sql = "SELECT o_tipo_contenido.Nbre, o_tipo_contenido_descripcion.Nbre, o_tipo_parametros.Nbre, o_historia_dental.Despcripcion, o_historia_dental.Id_Usuario, o_historia_dental.Id_Tipo_ContDresc FROM o_historia_dental INNER JOIN o_tipo_contenidoxdescripcion  ON (o_historia_dental.Id_Tipo_ContDresc = o_tipo_contenidoxdescripcion.Id) INNER JOIN o_tipo_contenido_descripcion  ON (o_tipo_contenidoxdescripcion.Id_tipo_adescripcion = o_tipo_contenido_descripcion.Id) INNER JOIN o_tipo_contenido  ON (o_tipo_contenidoxdescripcion.Id_tipo_contenido = o_tipo_contenido.Id) INNER JOIN o_tipo_parametros  ON (o_historia_dental.Id_TipoParametro = o_tipo_parametros.Id)  WHERE o_historia_dental.Id_Usuario= '" + this.xidusuario + "' ORDER BY o_tipo_contenido.Orden ASC, o_tipo_contenidoxdescripcion.NOrden ASC ";
            ResultSet rs = this.xct.traerRs(sql);
            if (rs.next()) {
                rs.beforeFirst();
                int x = 0;
                while (rs.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(rs.getString(1), x, 0);
                    this.xmodelo.setValueAt(rs.getString(2), x, 1);
                    this.xmodelo.setValueAt(rs.getString(3), x, 2);
                    this.xmodelo.setValueAt(rs.getString(4), x, 3);
                    this.xmodelo.setValueAt(Long.valueOf(rs.getLong(5)), x, 4);
                    this.xmodelo.setValueAt(Long.valueOf(rs.getLong(6)), x, 5);
                    x++;
                }
            }
            rs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPAAntecentesFamiliares.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mGrabarBd() {
        if (!this.xjifcho.xjppersona.getIdPersona().equals("0")) {
            if (this.JCBTipoDetale.getSelectedIndex() != -1) {
                if (this.JCBRespuesta.getSelectedIndex() != -1) {
                    if (!this.JTPDescripcion.getText().isEmpty()) {
                        this.xsql = "insert ignore into  o_historia_dental(Id_Usuario, Id_Tipo_ContDresc, Id_Atencion, Id_TipoParametro, Despcripcion, UsuarioS) values( '" + this.xidusuario + "','" + this.xdetalle[this.JCBTipoDetale.getSelectedIndex()] + "','" + this.xidatencion + "','" + this.xtiporespuesta[this.JCBRespuesta.getSelectedIndex()] + "','" + this.JTPDescripcion.getText() + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                        System.out.println("odontologicos  " + this.xsql);
                        this.xct.ejecutarSQL(this.xsql);
                        this.xct.cerrarConexionBd();
                        mCrearTabla();
                        mBuscarDatosBd();
                        return;
                    }
                    JOptionPane.showInternalMessageDialog(this, "La descripcion \n no puede estar en blanco", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    this.JTPDescripcion.requestFocus();
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar \n un tipo de respuesta", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JCBTipoDetale.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar \n un tipo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBTipoDetale.requestFocus();
        }
    }

    public void mNuevo() {
        if (this.xmod == 0) {
            this.xidusuario = clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido().longValue();
            this.xidatencion = clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion();
        } else {
            System.out.println(this.xjifcho.xjppersona.getIdPersona());
            if (!this.xjifcho.xjppersona.getIdPersona().equals("0")) {
                this.xidusuario = Long.valueOf(this.xjifcho.xjppersona.getIdPersona()).longValue();
            }
            this.xidatencion = "0";
        }
        this.JCBRespuesta.removeAllItems();
        this.JCBTipoDetale.removeAllItems();
        this.JCBTipo.removeAllItems();
        this.xsql = "SELECT o_tipo_contenido.Id, o_tipo_contenido.Nbre FROM o_tipo_contenidoxdescripcion INNER JOIN o_tipo_contenido_descripcion  ON (o_tipo_contenidoxdescripcion.Id_tipo_adescripcion = o_tipo_contenido_descripcion.Id) INNER JOIN o_tipo_contenido  ON (o_tipo_contenidoxdescripcion.Id_tipo_contenido = o_tipo_contenido.Id) INNER JOIN o_tipo_descripcionxparametro  ON (o_tipo_descripcionxparametro.Id_cdescipcion = o_tipo_contenido_descripcion.Id) INNER JOIN o_tipo_parametros  ON (o_tipo_descripcionxparametro.Id_TipoParametro = o_tipo_parametros.Id) WHERE (o_tipo_contenido.Estado =1) GROUP BY o_tipo_contenido.Id ORDER BY o_tipo_contenido.Orden ASC ";
        this.xtipo = this.xct.llenarCombo(this.xsql, this.xtipo, this.JCBTipo);
        this.JCBTipo.setSelectedIndex(-1);
        this.xct.cerrarConexionBd();
        this.xlleno = true;
        mCrearTabla();
        mBuscarDatosBd();
    }
}
