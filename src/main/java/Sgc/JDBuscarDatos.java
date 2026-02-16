package Sgc;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Sgc/JDBuscarDatos.class */
public class JDBuscarDatos extends JDialog {
    private JInternalFrame xjif;
    private ConsultasMySQL xct;
    private Metodos xmt;
    private DefaultTableModel xmodelo;
    private int xanalizada;
    private int xcerrada;
    private int xesnc;
    private String xnombre;
    private String xsql;
    private JIFRNoConfomidad xjifnc;
    private String[] xidtipoproceso;
    private Object[] xdato;
    private boolean xlleno;
    private ButtonGroup JBGClasificacion;
    private JComboBox JCBProcesoR;
    private JCheckBox JCHAnalizada;
    private JCheckBox JCHCerrada;
    private JCheckBox JCHFiltro;
    private JCheckBox JCHPorAnalizar;
    private JCheckBox JCHPorClasificar;
    private JDateChooser JDFechaF;
    private JDateChooser JDFechaI;
    private JPanel JPIDatos;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;

    public JDBuscarDatos(Frame parent, boolean modal, JInternalFrame xjif) {
        super(parent, modal);
        this.xct = new ConsultasMySQL();
        this.xmt = new Metodos();
        this.xanalizada = 0;
        this.xcerrada = 0;
        this.xesnc = 0;
        this.xlleno = false;
        initComponents();
        this.xjif = xjif;
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        mNuevo();
        mRealizarCasting();
        this.xlleno = true;
        mCargarDatosTabla2();
    }

    /* JADX WARN: Type inference failed for: r3v47, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGClasificacion = new ButtonGroup();
        this.JPIDatos = new JPanel();
        this.JDFechaI = new JDateChooser();
        this.JDFechaF = new JDateChooser();
        this.JCHAnalizada = new JCheckBox();
        this.JCHCerrada = new JCheckBox();
        this.JCHPorAnalizar = new JCheckBox();
        this.JCBProcesoR = new JComboBox();
        this.JCHPorClasificar = new JCheckBox();
        this.JCHFiltro = new JCheckBox();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        setDefaultCloseOperation(2);
        setTitle("BUSCAR DATOS");
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN PARA CONSULTA", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JDFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicial", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFechaI.setFont(new Font("Arial", 1, 12));
        this.JDFechaI.addPropertyChangeListener(new PropertyChangeListener() { // from class: Sgc.JDBuscarDatos.1
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JDBuscarDatos.this.JDFechaIPropertyChange(evt);
            }
        });
        this.JDFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Final", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFechaF.setFont(new Font("Arial", 1, 12));
        this.JDFechaF.addPropertyChangeListener(new PropertyChangeListener() { // from class: Sgc.JDBuscarDatos.2
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JDBuscarDatos.this.JDFechaFPropertyChange(evt);
            }
        });
        this.JBGClasificacion.add(this.JCHAnalizada);
        this.JCHAnalizada.setFont(new Font("Arial", 1, 12));
        this.JCHAnalizada.setForeground(Color.blue);
        this.JCHAnalizada.setText("Analizadas?");
        this.JCHAnalizada.addActionListener(new ActionListener() { // from class: Sgc.JDBuscarDatos.3
            public void actionPerformed(ActionEvent evt) {
                JDBuscarDatos.this.JCHAnalizadaActionPerformed(evt);
            }
        });
        this.JBGClasificacion.add(this.JCHCerrada);
        this.JCHCerrada.setFont(new Font("Arial", 1, 12));
        this.JCHCerrada.setForeground(Color.blue);
        this.JCHCerrada.setText("Cerradas?");
        this.JCHCerrada.addActionListener(new ActionListener() { // from class: Sgc.JDBuscarDatos.4
            public void actionPerformed(ActionEvent evt) {
                JDBuscarDatos.this.JCHCerradaActionPerformed(evt);
            }
        });
        this.JBGClasificacion.add(this.JCHPorAnalizar);
        this.JCHPorAnalizar.setFont(new Font("Arial", 1, 12));
        this.JCHPorAnalizar.setForeground(Color.blue);
        this.JCHPorAnalizar.setText("Por Analizar?");
        this.JCHPorAnalizar.addActionListener(new ActionListener() { // from class: Sgc.JDBuscarDatos.5
            public void actionPerformed(ActionEvent evt) {
                JDBuscarDatos.this.JCHPorAnalizarActionPerformed(evt);
            }
        });
        this.JCBProcesoR.setFont(new Font("Arial", 1, 12));
        this.JCBProcesoR.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo de Proceso", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBProcesoR.addItemListener(new ItemListener() { // from class: Sgc.JDBuscarDatos.6
            public void itemStateChanged(ItemEvent evt) {
                JDBuscarDatos.this.JCBProcesoRItemStateChanged(evt);
            }
        });
        this.JBGClasificacion.add(this.JCHPorClasificar);
        this.JCHPorClasificar.setFont(new Font("Arial", 1, 12));
        this.JCHPorClasificar.setForeground(Color.blue);
        this.JCHPorClasificar.setSelected(true);
        this.JCHPorClasificar.setText("Por Clasificar?");
        this.JCHPorClasificar.addActionListener(new ActionListener() { // from class: Sgc.JDBuscarDatos.7
            public void actionPerformed(ActionEvent evt) {
                JDBuscarDatos.this.JCHPorClasificarActionPerformed(evt);
            }
        });
        this.JCHFiltro.setFont(new Font("Arial", 1, 12));
        this.JCHFiltro.setForeground(Color.blue);
        this.JCHFiltro.setText("Filtro?");
        this.JCHFiltro.addActionListener(new ActionListener() { // from class: Sgc.JDBuscarDatos.8
            public void actionPerformed(ActionEvent evt) {
                JDBuscarDatos.this.JCHFiltroActionPerformed(evt);
            }
        });
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JDFechaI, -2, 120, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JDFechaF, -2, 120, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBProcesoR, -2, 286, -2).addGap(18, 18, 18).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHPorAnalizar).addComponent(this.JCHAnalizada)).addGap(18, 18, 18).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JCHCerrada).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHFiltro)).addComponent(this.JCHPorClasificar)).addContainerGap(-1, 32767)));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JDFechaI, -1, 52, 32767).addGroup(GroupLayout.Alignment.LEADING, JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBProcesoR, -2, -1, -2).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JCHPorClasificar).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCHCerrada).addComponent(this.JCHFiltro))).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JCHAnalizada).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHPorAnalizar)))).addComponent(this.JDFechaF, GroupLayout.Alignment.LEADING, -1, -1, 32767))).addContainerGap()));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JSPDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalle.setSelectionMode(0);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: Sgc.JDBuscarDatos.9
            public void mouseClicked(MouseEvent evt) {
                JDBuscarDatos.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JSPDetalle, GroupLayout.Alignment.LEADING).addComponent(this.JPIDatos, GroupLayout.Alignment.LEADING, -1, -1, 32767)).addContainerGap(37, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPDetalle, -1, 254, 32767).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHAnalizadaActionPerformed(ActionEvent evt) {
        mIniciarCheckBox();
        mBuscar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHCerradaActionPerformed(ActionEvent evt) {
        mIniciarCheckBox();
        mBuscar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHPorAnalizarActionPerformed(ActionEvent evt) {
        mIniciarCheckBox();
        mBuscar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            if (this.xjif.getName().equals("xjifreportenc") || this.xjif.getName().equals("xjifreportenc1") || this.xjif.getName().equals("xjifreportenc2")) {
                if (this.JCHPorClasificar.isSelected() || this.JCHPorAnalizar.isSelected() || this.JCHAnalizada.isSelected()) {
                    this.xjifnc.mBuscarNC(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
                }
                dispose();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHPorClasificarActionPerformed(ActionEvent evt) {
        mBuscar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaFPropertyChange(PropertyChangeEvent evt) {
        if (this.xlleno) {
            mBuscar();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaIPropertyChange(PropertyChangeEvent evt) {
        if (this.xlleno) {
            mBuscar();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBProcesoRItemStateChanged(ItemEvent evt) {
        if (this.xlleno) {
            mBuscar();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHFiltroActionPerformed(ActionEvent evt) {
        mBuscar();
    }

    private void mIniciarCheckBox() {
        if (this.JCHAnalizada.isSelected()) {
            this.xanalizada = 1;
        } else {
            this.xanalizada = 0;
        }
        if (this.JCHCerrada.isSelected()) {
            this.xcerrada = 1;
        } else {
            this.xcerrada = 0;
        }
        if (this.JCHPorClasificar.isSelected()) {
            this.xesnc = 1;
        } else {
            this.xesnc = 0;
        }
    }

    public void mNuevo() {
        this.JDFechaI.setDate(this.xmt.getFechaActual());
        this.JDFechaF.setDate(this.xmt.getFechaActual());
        this.JCBProcesoR.removeAllItems();
        this.xsql = "SELECT s_sgc_tipoproceso.Id, s_sgc_tipoproceso.Nbre FROM s_sgc_ncregistro INNER JOIN s_sgc_tipoproceso  ON (s_sgc_ncregistro.Id_ProcesoA = s_sgc_tipoproceso.Id) GROUP BY s_sgc_tipoproceso.Id ORDER BY s_sgc_tipoproceso.Nbre ASC";
        this.xidtipoproceso = this.xct.llenarCombo(this.xsql, this.xidtipoproceso, this.JCBProcesoR);
        if (this.xjif.getName().equals("xjifreportenc2")) {
            this.JCBProcesoR.setSelectedIndex(-1);
        } else {
            this.JCBProcesoR.setSelectedItem(Principal.informacionGeneralPrincipalDTO.getNombreProceso());
        }
        this.xct.cerrarConexionBd();
        mIniciarCheckBox();
        if (this.xjif.getName().equals("xjifreportenc1")) {
            this.JCHFiltro.setSelected(true);
            this.JCHPorAnalizar.setSelected(true);
        }
        mBuscar();
    }

    private void mBuscar() {
        if (this.xjif.getName().equals("xjifreportenc") || this.xjif.getName().equals("xjifreportenc1")) {
            if (this.JCBProcesoR.getSelectedIndex() != -1) {
                mCargarDatosTabla();
                return;
            } else {
                JOptionPane.showMessageDialog(this, "Debe seleccionar un tipo de proceso", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                this.JCBProcesoR.requestFocus();
                return;
            }
        }
        if (this.xjif.getName().equals("xjifreportenc2")) {
            mCargarDatosTabla();
        }
    }

    private void mRealizarCasting() {
        if (this.xjif.getName().equals("xjifreportenc") || this.xjif.getName().equals("xjifreportenc1") || this.xjif.getName().equals("xjifreportenc2")) {
            this.xjifnc = (JIFRNoConfomidad) this.xjif;
        }
    }

    private void mCrearTablaDetalle() {
        this.xmodelo = new DefaultTableModel((Object[][]) null, new String[]{"Id", "Fecha", "Usuario que Reporta", "Proceso que Reporta", "Tipo de Proceso que Reporta", "Proceso Implicado", "Tipo de Proceso Implicado", "Analizada?", "Cerrada", "Clasf. NC"}) { // from class: Sgc.JDBuscarDatos.10
            Class[] types = {Long.class, String.class, String.class, String.class, String.class, String.class, String.class, Boolean.class, Boolean.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return this.canEdit[colIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(30);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(30);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(30);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(30);
    }

    private void mCargarDatosTabla() {
        System.out.println(this.xjif.getName());
        if (this.xjif.getName().equals("xjifreportenc") || this.xjif.getName().equals("xjifreportenc1")) {
            mCrearTablaDetalle();
            if (this.JCHFiltro.isSelected()) {
                this.xsql = "SELECT s_sgc_ncregistro.Id, DATE_FORMAT(s_sgc_ncregistro.FechaNC,'%d-%m-%Y') AS FechaNC, persona.NUsuario, s_sgc_procesos.Nbre, s_sgc_tipoproceso.Nbre, sgc_proceso.NProceso, sgc_proceso.NTipoProceso, s_sgc_ncregistro.Analizada, s_sgc_ncregistro.Cerrada, s_sgc_ncregistro.EsNc FROM s_sgc_usuario_tipoproceso INNER JOIN s_sgc_ncregistro  ON (s_sgc_usuario_tipoproceso.Id_Usuario = s_sgc_ncregistro.Id_UsuarioR) INNER JOIN s_sgc_tipoproceso  ON (s_sgc_ncregistro.Id_ProcesoR = s_sgc_tipoproceso.Id) AND (s_sgc_usuario_tipoproceso.Id_TipoProceso = s_sgc_tipoproceso.Id) INNER JOIN s_sgc_procesos  ON (s_sgc_tipoproceso.Id_Proceso = s_sgc_procesos.Id) INNER JOIN persona  ON (persona.Id_persona = s_sgc_usuario_tipoproceso.Id_Usuario) INNER JOIN sgc_proceso  ON (sgc_proceso.IdTipoProceso = s_sgc_ncregistro.Id_ProcesoA) WHERE (s_sgc_ncregistro.Estado =1 AND s_sgc_ncregistro.Analizada ='" + this.xanalizada + "' AND s_sgc_ncregistro.Cerrada ='" + this.xcerrada + "' AND s_sgc_ncregistro.EsNc ='" + this.xesnc + "'  AND s_sgc_ncregistro.Id_ProcesoA ='" + this.xidtipoproceso[this.JCBProcesoR.getSelectedIndex()] + "') ORDER BY s_sgc_ncregistro.FechaNC DESC ";
            } else {
                this.xsql = "SELECT s_sgc_ncregistro.Id, DATE_FORMAT(s_sgc_ncregistro.FechaNC,'%d-%m-%Y') AS FechaNC, persona.NUsuario, s_sgc_procesos.Nbre, s_sgc_tipoproceso.Nbre, sgc_proceso.NProceso, sgc_proceso.NTipoProceso, s_sgc_ncregistro.Analizada, s_sgc_ncregistro.Cerrada, s_sgc_ncregistro.EsNc FROM s_sgc_usuario_tipoproceso INNER JOIN s_sgc_ncregistro  ON (s_sgc_usuario_tipoproceso.Id_Usuario = s_sgc_ncregistro.Id_UsuarioR) INNER JOIN s_sgc_tipoproceso  ON (s_sgc_ncregistro.Id_ProcesoR = s_sgc_tipoproceso.Id) AND (s_sgc_usuario_tipoproceso.Id_TipoProceso = s_sgc_tipoproceso.Id) INNER JOIN s_sgc_procesos  ON (s_sgc_tipoproceso.Id_Proceso = s_sgc_procesos.Id) INNER JOIN persona  ON (persona.Id_persona = s_sgc_usuario_tipoproceso.Id_Usuario) INNER JOIN sgc_proceso  ON (sgc_proceso.IdTipoProceso = s_sgc_ncregistro.Id_ProcesoA) WHERE (s_sgc_ncregistro.Estado =1 ) ORDER BY s_sgc_ncregistro.FechaNC DESC ";
            }
        } else if (this.xjif.getName().equals("xjifreportenc2")) {
            mCrearTablaDetalle();
            if (this.JCHPorClasificar.isSelected()) {
                if (this.JCHFiltro.isSelected()) {
                    if (this.JCBProcesoR.getSelectedIndex() != -1) {
                        this.xsql = "SELECT s_sgc_ncregistro.Id, DATE_FORMAT(s_sgc_ncregistro.FechaNC,'%d-%m-%Y') AS FechaNC, persona.NUsuario, s_sgc_procesos.Nbre, s_sgc_tipoproceso.Nbre, sgc_proceso.NProceso, sgc_proceso.NTipoProceso, s_sgc_ncregistro.Analizada, s_sgc_ncregistro.Cerrada, s_sgc_ncregistro.EsNc FROM s_sgc_usuario_tipoproceso INNER JOIN s_sgc_ncregistro  ON (s_sgc_usuario_tipoproceso.Id_Usuario = s_sgc_ncregistro.Id_UsuarioR) INNER JOIN s_sgc_tipoproceso  ON (s_sgc_ncregistro.Id_ProcesoR = s_sgc_tipoproceso.Id) AND (s_sgc_usuario_tipoproceso.Id_TipoProceso = s_sgc_tipoproceso.Id) INNER JOIN s_sgc_procesos  ON (s_sgc_tipoproceso.Id_Proceso = s_sgc_procesos.Id) INNER JOIN persona  ON (persona.Id_persona = s_sgc_usuario_tipoproceso.Id_Usuario) INNER JOIN sgc_proceso  ON (sgc_proceso.IdTipoProceso = s_sgc_ncregistro.Id_ProcesoA) WHERE (s_sgc_ncregistro.Estado =1  and s_sgc_ncregistro.FechaRev  IS NOT NULL and  s_sgc_ncregistro.FechaNC >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "'  and s_sgc_ncregistro.EsNc=1 and s_sgc_ncregistro.Analizada=0 AND s_sgc_ncregistro.FechaNC <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' and s_sgc_ncregistro.Id_ProcesoA='" + this.xidtipoproceso[this.JCBProcesoR.getSelectedIndex()] + "' ) ORDER BY s_sgc_ncregistro.FechaNC DESC ";
                    } else {
                        JOptionPane.showMessageDialog(this, "Debe seleccionar un tipo de proceso", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                        this.JCBProcesoR.requestFocus();
                    }
                } else {
                    this.xsql = "SELECT s_sgc_ncregistro.Id, DATE_FORMAT(s_sgc_ncregistro.FechaNC,'%d-%m-%Y') AS FechaNC, persona.NUsuario, s_sgc_procesos.Nbre, s_sgc_tipoproceso.Nbre, sgc_proceso.NProceso, sgc_proceso.NTipoProceso, s_sgc_ncregistro.Analizada, s_sgc_ncregistro.Cerrada, s_sgc_ncregistro.EsNc FROM s_sgc_usuario_tipoproceso INNER JOIN s_sgc_ncregistro  ON (s_sgc_usuario_tipoproceso.Id_Usuario = s_sgc_ncregistro.Id_UsuarioR) INNER JOIN s_sgc_tipoproceso  ON (s_sgc_ncregistro.Id_ProcesoR = s_sgc_tipoproceso.Id) AND (s_sgc_usuario_tipoproceso.Id_TipoProceso = s_sgc_tipoproceso.Id) INNER JOIN s_sgc_procesos  ON (s_sgc_tipoproceso.Id_Proceso = s_sgc_procesos.Id) INNER JOIN persona  ON (persona.Id_persona = s_sgc_usuario_tipoproceso.Id_Usuario) INNER JOIN sgc_proceso  ON (sgc_proceso.IdTipoProceso = s_sgc_ncregistro.Id_ProcesoA) WHERE ( s_sgc_ncregistro.FechaRev  IS NULL and  s_sgc_ncregistro.Estado =1  ) ORDER BY s_sgc_ncregistro.FechaNC DESC ";
                }
            } else if (this.JCHPorAnalizar.isSelected()) {
                if (this.JCHFiltro.isSelected()) {
                    if (this.JCBProcesoR.getSelectedIndex() != -1) {
                        this.xsql = "SELECT s_sgc_ncregistro.Id, DATE_FORMAT(s_sgc_ncregistro.FechaNC,'%d-%m-%Y') AS FechaNC, persona.NUsuario, s_sgc_procesos.Nbre, s_sgc_tipoproceso.Nbre, sgc_proceso.NProceso, sgc_proceso.NTipoProceso, s_sgc_ncregistro.Analizada, s_sgc_ncregistro.Cerrada, s_sgc_ncregistro.EsNc FROM s_sgc_usuario_tipoproceso INNER JOIN s_sgc_ncregistro  ON (s_sgc_usuario_tipoproceso.Id_Usuario = s_sgc_ncregistro.Id_UsuarioR) INNER JOIN s_sgc_tipoproceso  ON (s_sgc_ncregistro.Id_ProcesoR = s_sgc_tipoproceso.Id) AND (s_sgc_usuario_tipoproceso.Id_TipoProceso = s_sgc_tipoproceso.Id) INNER JOIN s_sgc_procesos  ON (s_sgc_tipoproceso.Id_Proceso = s_sgc_procesos.Id) INNER JOIN persona  ON (persona.Id_persona = s_sgc_usuario_tipoproceso.Id_Usuario) INNER JOIN sgc_proceso  ON (sgc_proceso.IdTipoProceso = s_sgc_ncregistro.Id_ProcesoA) WHERE (s_sgc_ncregistro.Estado =1  and s_sgc_ncregistro.FechaRev  IS NOT NULL and  s_sgc_ncregistro.FechaNC >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "'  and s_sgc_ncregistro.EsNc=1 and s_sgc_ncregistro.Analizada=0 AND s_sgc_ncregistro.FechaNC <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' and s_sgc_ncregistro.Id_ProcesoA='" + this.xidtipoproceso[this.JCBProcesoR.getSelectedIndex()] + "' ) ORDER BY s_sgc_ncregistro.FechaNC DESC ";
                    } else {
                        JOptionPane.showMessageDialog(this, "Debe seleccionar un tipo de proceso", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                        this.JCBProcesoR.requestFocus();
                    }
                } else {
                    this.xsql = "SELECT s_sgc_ncregistro.Id, DATE_FORMAT(s_sgc_ncregistro.FechaNC,'%d-%m-%Y') AS FechaNC, persona.NUsuario, s_sgc_procesos.Nbre, s_sgc_tipoproceso.Nbre, sgc_proceso.NProceso, sgc_proceso.NTipoProceso, s_sgc_ncregistro.Analizada, s_sgc_ncregistro.Cerrada, s_sgc_ncregistro.EsNc FROM s_sgc_usuario_tipoproceso INNER JOIN s_sgc_ncregistro  ON (s_sgc_usuario_tipoproceso.Id_Usuario = s_sgc_ncregistro.Id_UsuarioR) INNER JOIN s_sgc_tipoproceso  ON (s_sgc_ncregistro.Id_ProcesoR = s_sgc_tipoproceso.Id) AND (s_sgc_usuario_tipoproceso.Id_TipoProceso = s_sgc_tipoproceso.Id) INNER JOIN s_sgc_procesos  ON (s_sgc_tipoproceso.Id_Proceso = s_sgc_procesos.Id) INNER JOIN persona  ON (persona.Id_persona = s_sgc_usuario_tipoproceso.Id_Usuario) INNER JOIN sgc_proceso  ON (sgc_proceso.IdTipoProceso = s_sgc_ncregistro.Id_ProcesoA) WHERE (s_sgc_ncregistro.Estado =1  and s_sgc_ncregistro.FechaRev  IS NOT NULL and  s_sgc_ncregistro.FechaNC >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "'  and s_sgc_ncregistro.EsNc=1 and s_sgc_ncregistro.Analizada=0 AND s_sgc_ncregistro.FechaNC <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' ) ORDER BY s_sgc_ncregistro.FechaNC DESC ";
                }
            } else if (this.JCHAnalizada.isSelected()) {
                if (this.JCHFiltro.isSelected()) {
                    if (this.JCBProcesoR.getSelectedIndex() != -1) {
                        this.xsql = "SELECT s_sgc_ncregistro.Id, DATE_FORMAT(s_sgc_ncregistro.FechaNC,'%d-%m-%Y') AS FechaNC, persona.NUsuario, s_sgc_procesos.Nbre, s_sgc_tipoproceso.Nbre, sgc_proceso.NProceso, sgc_proceso.NTipoProceso, s_sgc_ncregistro.Analizada, s_sgc_ncregistro.Cerrada, s_sgc_ncregistro.EsNc FROM s_sgc_usuario_tipoproceso INNER JOIN s_sgc_ncregistro  ON (s_sgc_usuario_tipoproceso.Id_Usuario = s_sgc_ncregistro.Id_UsuarioR) INNER JOIN s_sgc_tipoproceso  ON (s_sgc_ncregistro.Id_ProcesoR = s_sgc_tipoproceso.Id) AND (s_sgc_usuario_tipoproceso.Id_TipoProceso = s_sgc_tipoproceso.Id) INNER JOIN s_sgc_procesos  ON (s_sgc_tipoproceso.Id_Proceso = s_sgc_procesos.Id) INNER JOIN persona  ON (persona.Id_persona = s_sgc_usuario_tipoproceso.Id_Usuario) INNER JOIN sgc_proceso  ON (sgc_proceso.IdTipoProceso = s_sgc_ncregistro.Id_ProcesoA) WHERE (s_sgc_ncregistro.Estado =1  and s_sgc_ncregistro.FechaRev  IS NOT NULL and  s_sgc_ncregistro.FechaNC >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "'  and s_sgc_ncregistro.EsNc=1 and s_sgc_ncregistro.Analizada=1 AND s_sgc_ncregistro.FechaNC <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' and s_sgc_ncregistro.Id_ProcesoA='" + this.xidtipoproceso[this.JCBProcesoR.getSelectedIndex()] + "' ) ORDER BY s_sgc_ncregistro.FechaNC DESC ";
                    } else {
                        JOptionPane.showMessageDialog(this, "Debe seleccionar un tipo de proceso", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                        this.JCBProcesoR.requestFocus();
                    }
                } else {
                    this.xsql = "SELECT s_sgc_ncregistro.Id, DATE_FORMAT(s_sgc_ncregistro.FechaNC,'%d-%m-%Y') AS FechaNC, persona.NUsuario, s_sgc_procesos.Nbre, s_sgc_tipoproceso.Nbre, sgc_proceso.NProceso, sgc_proceso.NTipoProceso, s_sgc_ncregistro.Analizada, s_sgc_ncregistro.Cerrada, s_sgc_ncregistro.EsNc FROM s_sgc_usuario_tipoproceso INNER JOIN s_sgc_ncregistro  ON (s_sgc_usuario_tipoproceso.Id_Usuario = s_sgc_ncregistro.Id_UsuarioR) INNER JOIN s_sgc_tipoproceso  ON (s_sgc_ncregistro.Id_ProcesoR = s_sgc_tipoproceso.Id) AND (s_sgc_usuario_tipoproceso.Id_TipoProceso = s_sgc_tipoproceso.Id) INNER JOIN s_sgc_procesos  ON (s_sgc_tipoproceso.Id_Proceso = s_sgc_procesos.Id) INNER JOIN persona  ON (persona.Id_persona = s_sgc_usuario_tipoproceso.Id_Usuario) INNER JOIN sgc_proceso  ON (sgc_proceso.IdTipoProceso = s_sgc_ncregistro.Id_ProcesoA) WHERE (s_sgc_ncregistro.Estado =1  and s_sgc_ncregistro.FechaRev  IS NOT NULL and  s_sgc_ncregistro.FechaNC >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "'  and s_sgc_ncregistro.EsNc=1 and s_sgc_ncregistro.Analizada=1 AND s_sgc_ncregistro.FechaNC <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' ) ORDER BY s_sgc_ncregistro.FechaNC DESC ";
                }
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
                    this.xmodelo.setValueAt(rs.getString(5), x, 4);
                    this.xmodelo.setValueAt(rs.getString(6), x, 5);
                    this.xmodelo.setValueAt(rs.getString(7), x, 6);
                    this.xmodelo.setValueAt(Boolean.valueOf(rs.getBoolean(8)), x, 7);
                    this.xmodelo.setValueAt(Boolean.valueOf(rs.getBoolean(9)), x, 8);
                    this.xmodelo.setValueAt(Boolean.valueOf(rs.getBoolean(10)), x, 9);
                    x++;
                }
            }
            rs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            this.xct.mostrarErrorSQL(ex);
        }
    }

    private void mCargarDatosTabla2() {
        mCrearTablaDetalle();
        ResultSet rs = this.xct.traerRs("SELECT s_sgc_ncregistro.Id, DATE_FORMAT(s_sgc_ncregistro.FechaNC,'%d-%m-%Y') AS FechaNC, persona.NUsuario, s_sgc_procesos.Nbre, s_sgc_tipoproceso.Nbre, sgc_proceso.NProceso, sgc_proceso.NTipoProceso, s_sgc_ncregistro.Analizada, s_sgc_ncregistro.Cerrada, s_sgc_ncregistro.EsNc FROM s_sgc_usuario_tipoproceso INNER JOIN s_sgc_ncregistro  ON (s_sgc_usuario_tipoproceso.Id_Usuario = s_sgc_ncregistro.Id_UsuarioR) INNER JOIN s_sgc_tipoproceso  ON (s_sgc_ncregistro.Id_ProcesoR = s_sgc_tipoproceso.Id) AND (s_sgc_usuario_tipoproceso.Id_TipoProceso = s_sgc_tipoproceso.Id) INNER JOIN s_sgc_procesos  ON (s_sgc_tipoproceso.Id_Proceso = s_sgc_procesos.Id) INNER JOIN persona  ON (persona.Id_persona = s_sgc_usuario_tipoproceso.Id_Usuario) INNER JOIN sgc_proceso  ON (sgc_proceso.IdTipoProceso = s_sgc_ncregistro.Id_ProcesoA) WHERE (s_sgc_ncregistro.Estado =1 AND s_sgc_ncregistro.Analizada=0) ORDER BY s_sgc_ncregistro.FechaNC DESC ");
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
                    this.xmodelo.setValueAt(rs.getString(5), x, 4);
                    this.xmodelo.setValueAt(rs.getString(6), x, 5);
                    this.xmodelo.setValueAt(rs.getString(7), x, 6);
                    this.xmodelo.setValueAt(Boolean.valueOf(rs.getBoolean(8)), x, 7);
                    this.xmodelo.setValueAt(Boolean.valueOf(rs.getBoolean(9)), x, 8);
                    this.xmodelo.setValueAt(Boolean.valueOf(rs.getBoolean(10)), x, 9);
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
