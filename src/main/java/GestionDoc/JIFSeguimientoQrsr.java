package GestionDoc;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:GestionDoc/JIFSeguimientoQrsr.class */
public class JIFSeguimientoQrsr extends JInternalFrame {
    private String[] xidtiporegistro;
    private DefaultTableModel xmodelo;
    private DefaultTableModel xmodelos;
    private Object[] dato;
    private JComboBox JCBTipoRegistro;
    private JCheckBox JCHGeneraAccion;
    public JDateChooser JDCFechaF;
    public JDateChooser JDCFechaI;
    public JDateChooser JDCFechaSg;
    private JPanel JPIDGeneral;
    private JPanel JPISeguimiento;
    private JScrollPane JSPDSeguimiento;
    private JScrollPane JSPDetalle;
    private JScrollPane JSPSeguimiento;
    private JTable JTBDetalle;
    private JTable JTBSeguimiento;
    private JTextPane JTPDSeguimiento;
    private JPanel jPanel1;
    private int xgenera = 0;
    private ConsultasMySQL xconsulta = new ConsultasMySQL();
    private Metodos xmetodo = new Metodos();

    public JIFSeguimientoQrsr() {
        initComponents();
        mCargarCombox();
    }

    private void initComponents() {
        this.jPanel1 = new JPanel();
        this.JPIDGeneral = new JPanel();
        this.JDCFechaI = new JDateChooser();
        this.JCBTipoRegistro = new JComboBox();
        this.JDCFechaF = new JDateChooser();
        this.JCHGeneraAccion = new JCheckBox();
        this.JPISeguimiento = new JPanel();
        this.JSPDSeguimiento = new JScrollPane();
        this.JTPDSeguimiento = new JTextPane();
        this.JDCFechaSg = new JDateChooser();
        this.JSPDetalle = new JScrollPane();
        this.JTBDetalle = new JTable();
        this.JSPSeguimiento = new JScrollPane();
        this.JTBSeguimiento = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("SEGUIMIENTO DE QUEJAS, RECLAMOS O SUGERENCIAS");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifseguimientoqrsr");
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "SEGUIMIENTO DE QUEJAS, RECLAMOS O SUGERENCIA", 2, 0, new Font("Arial", 1, 16), new Color(0, 102, 0)));
        this.jPanel1.setName("jpqrseguimiento");
        this.JPIDGeneral.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN GENERAL", 0, 0, new Font("Arial", 1, 14), Color.red));
        this.JDCFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDCFechaI.setFont(new Font("Arial", 1, 12));
        this.JCBTipoRegistro.setFont(new Font("Arial", 1, 12));
        this.JCBTipoRegistro.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Registro", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Fin", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDCFechaF.setFont(new Font("Arial", 1, 12));
        this.JCHGeneraAccion.setFont(new Font("Arial", 1, 12));
        this.JCHGeneraAccion.setForeground(Color.blue);
        this.JCHGeneraAccion.setText("Aplicar Filtro?");
        this.JCHGeneraAccion.addActionListener(new ActionListener() { // from class: GestionDoc.JIFSeguimientoQrsr.1
            public void actionPerformed(ActionEvent evt) {
                JIFSeguimientoQrsr.this.JCHGeneraAccionActionPerformed(evt);
            }
        });
        GroupLayout JPIDGeneralLayout = new GroupLayout(this.JPIDGeneral);
        this.JPIDGeneral.setLayout(JPIDGeneralLayout);
        JPIDGeneralLayout.setHorizontalGroup(JPIDGeneralLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDGeneralLayout.createSequentialGroup().addContainerGap().addComponent(this.JDCFechaI, -2, 131, -2).addGap(11, 11, 11).addComponent(this.JDCFechaF, -2, 131, -2).addGap(18, 18, 18).addComponent(this.JCHGeneraAccion).addGap(18, 18, 18).addComponent(this.JCBTipoRegistro, 0, -1, 32767).addContainerGap()));
        JPIDGeneralLayout.setVerticalGroup(JPIDGeneralLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDGeneralLayout.createSequentialGroup().addGroup(JPIDGeneralLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDGeneralLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JDCFechaI, -2, -1, -2).addComponent(this.JDCFechaF, -2, -1, -2)).addGroup(JPIDGeneralLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBTipoRegistro, -2, -1, -2).addComponent(this.JCHGeneraAccion))).addContainerGap(-1, 32767)));
        this.JPISeguimiento.setBorder(BorderFactory.createTitledBorder((Border) null, "SEGUIMIENTO A LOS CORRECTIVOS TOMADOS", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JSPDSeguimiento.setBorder(BorderFactory.createTitledBorder((Border) null, "Descripción del Seguimiento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTPDSeguimiento.setFont(new Font("Arial", 1, 12));
        this.JTPDSeguimiento.addKeyListener(new KeyAdapter() { // from class: GestionDoc.JIFSeguimientoQrsr.2
            public void keyPressed(KeyEvent evt) {
                JIFSeguimientoQrsr.this.JTPDSeguimientoKeyPressed(evt);
            }
        });
        this.JSPDSeguimiento.setViewportView(this.JTPDSeguimiento);
        this.JDCFechaSg.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFechaSg.setDateFormatString("dd/MM/yyyy");
        this.JDCFechaSg.setFont(new Font("Arial", 1, 12));
        GroupLayout JPISeguimientoLayout = new GroupLayout(this.JPISeguimiento);
        this.JPISeguimiento.setLayout(JPISeguimientoLayout);
        JPISeguimientoLayout.setHorizontalGroup(JPISeguimientoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPISeguimientoLayout.createSequentialGroup().addGap(21, 21, 21).addComponent(this.JDCFechaSg, -2, 131, -2).addGap(4, 4, 4).addComponent(this.JSPDSeguimiento, -2, 798, -2).addContainerGap()));
        JPISeguimientoLayout.setVerticalGroup(JPISeguimientoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPISeguimientoLayout.createSequentialGroup().addGroup(JPISeguimientoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JDCFechaSg, -2, 63, -2).addComponent(this.JSPDSeguimiento, -2, 118, -2)).addContainerGap(-1, 32767)));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JTBDetalle.setFont(new Font("Arial", 1, 12));
        this.JTBDetalle.setRowHeight(25);
        this.JTBDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTBDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTBDetalle.addMouseListener(new MouseAdapter() { // from class: GestionDoc.JIFSeguimientoQrsr.3
            public void mouseClicked(MouseEvent evt) {
                JIFSeguimientoQrsr.this.JTBDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTBDetalle);
        this.JSPSeguimiento.setBorder(BorderFactory.createTitledBorder((Border) null, "SEGUIMIENTOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JTBSeguimiento.setFont(new Font("Arial", 1, 12));
        this.JTBSeguimiento.setRowHeight(25);
        this.JTBSeguimiento.setSelectionBackground(new Color(255, 255, 255));
        this.JTBSeguimiento.setSelectionForeground(new Color(255, 0, 0));
        this.JTBSeguimiento.setSelectionMode(0);
        this.JTBSeguimiento.addMouseListener(new MouseAdapter() { // from class: GestionDoc.JIFSeguimientoQrsr.4
            public void mouseClicked(MouseEvent evt) {
                JIFSeguimientoQrsr.this.JTBSeguimientoMouseClicked(evt);
            }
        });
        this.JSPSeguimiento.setViewportView(this.JTBSeguimiento);
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JPISeguimiento, GroupLayout.Alignment.LEADING, -1, -1, 32767).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JPIDGeneral, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.JSPDetalle, GroupLayout.Alignment.LEADING, -2, 970, -2).addGroup(jPanel1Layout.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.JSPSeguimiento, -2, 970, -2))))).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JPIDGeneral, -2, -1, -2).addGap(18, 18, 18).addComponent(this.JSPDetalle, -2, 239, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPSeguimiento, -2, 162, -2).addGap(18, 18, 18).addComponent(this.JPISeguimiento, -2, -1, -2).addContainerGap()));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 1026, 32767).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, -1, -2).addContainerGap(14, 32767))));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 790, 32767).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, -1, -2).addContainerGap(61, 32767))));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHGeneraAccionActionPerformed(ActionEvent evt) {
        if (this.JCHGeneraAccion.isSelected()) {
            this.xgenera = 1;
            this.JCBTipoRegistro.setEnabled(true);
        } else {
            this.xgenera = 0;
            this.JCBTipoRegistro.setEnabled(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTPDSeguimientoKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 9) {
            this.JTPDSeguimiento.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBDetalleMouseClicked(MouseEvent evt) {
        if (this.JTBDetalle.getSelectedRow() != -1 && this.JTBDetalle.getValueAt(this.JTBDetalle.getSelectedRow(), 0) != null) {
            try {
                Object[] botones = {"Nuevo Seguimientos", "Consultar Seguimientos", "Consultar soporte", "Cerrar"};
                int n = JOptionPane.showOptionDialog(this, "Que desea hacer", "CONSULTAR", 0, 3, (Icon) null, botones, "Cerrar");
                if (n == 0) {
                    if (this.JTBDetalle.getSelectedRow() != -1 && this.JTBDetalle.getValueAt(this.JTBDetalle.getSelectedRow(), 0) != null) {
                        this.JTPDSeguimiento.setText((String) null);
                        this.JTPDSeguimiento.setEnabled(true);
                        this.JDCFechaSg.setDate(this.xmetodo.getFechaActual());
                        this.JDCFechaSg.setEnabled(true);
                        Principal.txtNo.setText((String) null);
                    } else {
                        JOptionPane.showMessageDialog(this, "Debe seleccionar un registro", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                        this.JTBDetalle.requestFocus();
                    }
                } else if (n == 1) {
                    String sql = "SELECT DATE_FORMAT(FechaSeguimiento,'%d-%m-%Y') AS fecha, Seguimiento FROM baseserver.t_seguimientoqrs WHERE (id_tqrs ='" + this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 0) + "')  ORDER BY FechaSeguimiento ASC ";
                    mCrearTablaSeguimiento();
                    mCargarDatosTablaSeguimiento(sql);
                } else if (n == 2) {
                    this.xmetodo.recuperarBlob("SELECT Soporte FROM baseserver.t_registroqrs WHERE (Id ='" + this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 0) + "')", 0);
                    this.xmetodo.mostrarPdf(this.xmetodo.getRutaRep() + "tmp.pdf");
                }
            } catch (IOException ex) {
                Logger.getLogger(JIFSeguimientoQrsr.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            } catch (SQLException ex2) {
                Logger.getLogger(JIFSeguimientoQrsr.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBSeguimientoMouseClicked(MouseEvent evt) {
        if (this.JTBSeguimiento.getSelectedRow() != -1 && this.JTBSeguimiento.getValueAt(this.JTBSeguimiento.getSelectedRow(), 0) != null) {
            this.JDCFechaSg.setDate(Date.valueOf(this.xmetodo.formatoAMD.format(this.JTBSeguimiento.getValueAt(this.JTBSeguimiento.getSelectedRow(), 0).toString())));
            this.JTPDSeguimiento.setText(this.JTBSeguimiento.getValueAt(this.JTBSeguimiento.getSelectedRow(), 1).toString());
        }
    }

    public void nuevo() {
        mManejoBTNuevo();
    }

    public void buscar() {
        if (this.xgenera == 0) {
            String sql = "SELECT t_registroqrs.Id, DATE_FORMAT(t_registroqrs.FechaQRS,'%d-%m-%Y') AS fecha, t_tiporegistro.Nbre, t_registroqrs.Descripcion, t_registroqrs.FechaQRS  FROM baseserver.t_registroqrs INNER JOIN baseserver.t_tiporegistro ON (t_registroqrs.Id_TipoR = t_tiporegistro.Id) WHERE (t_registroqrs.FechaQRS >='" + this.xmetodo.formatoAMD.format(this.JDCFechaI.getDate()) + "' AND t_registroqrs.FechaQRS <='" + this.xmetodo.formatoAMD.format(this.JDCFechaF.getDate()) + "') ORDER BY t_registroqrs.FechaQRS ASC ";
            mCrearTabla();
            mCargarDatosTabla(sql);
        } else if (this.JCBTipoRegistro.getSelectedIndex() != -1) {
            String sql2 = "SELECT t_registroqrs.Id, DATE_FORMAT(t_registroqrs.FechaQRS,'%d-%m-%Y') AS fecha, t_tiporegistro.Nbre, t_registroqrs.Descripcion, t_registroqrs.FechaQRS  FROM baseserver.t_registroqrs INNER JOIN baseserver.t_tiporegistro ON (t_registroqrs.Id_TipoR = t_tiporegistro.Id) WHERE (t_registroqrs.FechaQRS >='" + this.xmetodo.formatoAMD.format(this.JDCFechaI.getDate()) + "' AND t_registroqrs.FechaQRS <='" + this.xmetodo.formatoAMD.format(this.JDCFechaF.getDate()) + "' AND t_registroqrs.Id_TipoR='" + this.xidtiporegistro[this.JCBTipoRegistro.getSelectedIndex()] + "') ORDER BY t_registroqrs.FechaQRS ASC ";
            mCrearTabla();
            mCargarDatosTabla(sql2);
        } else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar el tipo de registo", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
            this.JCBTipoRegistro.requestFocus();
        }
    }

    private void mManejoBTNuevo() {
        this.JDCFechaI.setDate(this.xmetodo.getFechaActual());
        this.JDCFechaF.setDate(this.xmetodo.getFechaActual());
        this.JDCFechaSg.setDate(this.xmetodo.getFechaActual());
        this.JCBTipoRegistro.setSelectedIndex(-1);
        this.JTPDSeguimiento.setText((String) null);
        mCrearTabla();
        mCrearTablaSeguimiento();
        this.xgenera = 0;
        this.JCHGeneraAccion.setSelected(false);
        this.JTPDSeguimiento.setEnabled(false);
        this.JDCFechaSg.setEnabled(false);
    }

    private boolean mValidarDatos() {
        boolean xest = false;
        if (this.JTBDetalle.getSelectedRow() != -1 && this.JTBDetalle.getValueAt(this.JTBDetalle.getSelectedRow(), 0) != null) {
            if (!this.JTPDSeguimiento.getText().isEmpty()) {
                xest = true;
            } else {
                JOptionPane.showMessageDialog(this, "El seguimiento no puede estar en blanco", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                this.JTPDSeguimiento.requestFocus();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un registro", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
            this.JTBDetalle.requestFocus();
        }
        return xest;
    }

    private void mCargarCombox() {
        this.JDCFechaI.setDate(this.xmetodo.getFechaActual());
        this.JDCFechaF.setDate(this.xmetodo.getFechaActual());
        this.JDCFechaSg.setDate(this.xmetodo.getFechaActual());
        this.xidtiporegistro = this.xconsulta.llenarCombo("SELECT Id, Nbre FROM baseserver.t_tiporegistro WHERE (Estado =0) ORDER BY Nbre ASC", this.xidtiporegistro, this.JCBTipoRegistro);
        this.JCBTipoRegistro.setSelectedIndex(-1);
        this.xconsulta.cerrarConexionBd();
        this.JCBTipoRegistro.setEnabled(false);
        this.JTPDSeguimiento.setEnabled(false);
        this.JDCFechaSg.setEnabled(false);
        mCrearTabla();
        mCrearTablaSeguimiento();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTabla() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Fecha", "Tipo", "Descripción"}) { // from class: GestionDoc.JIFSeguimientoQrsr.5
            Class[] types = {Integer.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTBDetalle.setModel(this.xmodelo);
        this.JTBDetalle.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTBDetalle.getColumnModel().getColumn(1).setPreferredWidth(60);
        this.JTBDetalle.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTBDetalle.getColumnModel().getColumn(3).setPreferredWidth(550);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTablaSeguimiento() {
        this.xmodelos = new DefaultTableModel(new Object[0], new String[]{"Fecha", "Descripción"}) { // from class: GestionDoc.JIFSeguimientoQrsr.6
            Class[] types = {String.class, String.class};
            boolean[] canEdit = {false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTBSeguimiento.setModel(this.xmodelos);
        this.JTBSeguimiento.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTBSeguimiento.getColumnModel().getColumn(1).setPreferredWidth(700);
    }

    public void grabar() {
        if (Principal.txtNo.getText() == null && mValidarDatos()) {
            int n = JOptionPane.showConfirmDialog(this, "Esta seguro de guardar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                String sql = "insert into baseserver.t_seguimientoqrs (id_tqrs, FechaSeguimiento, Seguimiento, Fecha, UsuarioS)  values('" + this.JTBDetalle.getValueAt(this.JTBDetalle.getSelectedRow(), 0) + "','" + this.xmetodo.formatoAMD.format(this.JDCFechaSg.getDate()) + "','" + this.JTPDSeguimiento.getText() + "','" + this.xmetodo.formatoAMDH24.format(this.xmetodo.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                Principal.txtNo.setText(this.xconsulta.ejecutarSQLId(sql));
                this.xconsulta.cerrarConexionBd();
                String sql2 = "SELECT DATE_FORMAT(FechaSeguimiento,'%d-%m-%Y') AS fecha, Seguimiento FROM baseserver.t_seguimientoqrs WHERE (id_tqrs ='" + this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 0) + "')  ORDER BY FechaSeguimiento ASC ";
                mCrearTablaSeguimiento();
                mCargarDatosTablaSeguimiento(sql2);
            }
        }
    }

    private void mCargarDatosTabla(String sql) {
        try {
            ResultSet rs = this.xconsulta.traerRs(sql);
            if (rs.next()) {
                rs.beforeFirst();
                int i = 0;
                while (rs.next()) {
                    this.xmodelo.addRow(this.dato);
                    this.xmodelo.setValueAt(Long.valueOf(rs.getLong(1)), i, 0);
                    this.xmodelo.setValueAt(rs.getString(2), i, 1);
                    this.xmodelo.setValueAt(rs.getString(3), i, 2);
                    this.xmodelo.setValueAt(rs.getString(4), i, 3);
                    i++;
                }
            }
            rs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFSeguimientoQrsr.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarDatosTablaSeguimiento(String sql) {
        try {
            ResultSet rs = this.xconsulta.traerRs(sql);
            rs.next();
            if (rs.getRow() != 0) {
                rs.beforeFirst();
                int i = 0;
                while (rs.next()) {
                    this.xmodelos.addRow(this.dato);
                    this.xmodelos.setValueAt(rs.getString(1), i, 0);
                    this.xmodelos.setValueAt(rs.getString(2), i, 1);
                    i++;
                }
            }
            rs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFSeguimientoQrsr.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }
}
