package ParametrizacionN;

import Acceso.Principal;
import General.BuscarPersona;
import General.Persona;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

/* JADX INFO: loaded from: GenomaP.jar:ParametrizacionN/JIFGAlertaxUsuario.class */
public class JIFGAlertaxUsuario extends JInternalFrame {
    private File xfile;
    private File directorio;
    public Persona xjppersona;
    private DefaultTableModel xmodelo;
    private Object[] xdato;
    private String[] xidtipoalerta;
    private ButtonGroup JBGOpciones;
    private JComboBox JCBTipoAlerta;
    private JCheckBox JCHEstado;
    private JDateChooser JDCFechaF;
    private JFormattedTextField JFTFValor;
    private JPanel JPIDatosProf;
    private JPanel JPIFDatosUsuario;
    private JScrollPane JSPDetalle;
    private JScrollPane JSPNotas;
    private JTable JTDetalle;
    private JTextField JTFRuta;
    public JTextPane JTPNota;
    private ConsultasMySQL xconsultas = new ConsultasMySQL();
    private Metodos xmetodos = new Metodos();
    private int xestado = 1;
    private boolean xestadog = false;

    public JIFGAlertaxUsuario(String xnombre) {
        initComponents();
        setName(xnombre);
        mCargasPanelUsuario();
        this.xidtipoalerta = this.xconsultas.llenarCombo("SELECT Id, Nbre FROM g_tipoalerta WHERE (Estado =1) ORDER BY Nbre ASC", this.xidtipoalerta, this.JCBTipoAlerta);
        this.JCBTipoAlerta.setSelectedIndex(-1);
        this.xconsultas.cerrarConexionBd();
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v13, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGOpciones = new ButtonGroup();
        this.JPIFDatosUsuario = new JPanel();
        this.JPIDatosProf = new JPanel();
        this.JCBTipoAlerta = new JComboBox();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JCHEstado = new JCheckBox();
        this.JSPNotas = new JScrollPane();
        this.JTPNota = new JTextPane();
        this.JDCFechaF = new JDateChooser();
        this.JTFRuta = new JTextField();
        this.JFTFValor = new JFormattedTextField();
        setClosable(true);
        setTitle("ALERTA POR USUARIO");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setMaximumSize(null);
        setName("jifalertaxusuario");
        addInternalFrameListener(new InternalFrameListener() { // from class: ParametrizacionN.JIFGAlertaxUsuario.1
            public void internalFrameActivated(InternalFrameEvent evt) {
            }

            public void internalFrameClosed(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                JIFGAlertaxUsuario.this.formInternalFrameClosing(evt);
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
        this.JPIFDatosUsuario.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN DEL USUARIO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        GroupLayout JPIFDatosUsuarioLayout = new GroupLayout(this.JPIFDatosUsuario);
        this.JPIFDatosUsuario.setLayout(JPIFDatosUsuarioLayout);
        JPIFDatosUsuarioLayout.setHorizontalGroup(JPIFDatosUsuarioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 0, 32767));
        JPIFDatosUsuarioLayout.setVerticalGroup(JPIFDatosUsuarioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 168, 32767));
        this.JPIDatosProf.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 13), Color.red));
        this.JCBTipoAlerta.setFont(new Font("Arial", 1, 12));
        this.JCBTipoAlerta.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Alerta", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 12), Color.red));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalle.setSelectionMode(0);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFGAlertaxUsuario.2
            public void mouseClicked(MouseEvent evt) {
                JIFGAlertaxUsuario.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setForeground(Color.blue);
        this.JCHEstado.setSelected(true);
        this.JCHEstado.setText("Estado");
        this.JCHEstado.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFGAlertaxUsuario.3
            public void actionPerformed(ActionEvent evt) {
                JIFGAlertaxUsuario.this.JCHEstadoActionPerformed(evt);
            }
        });
        this.JSPNotas.setBorder(BorderFactory.createTitledBorder((Border) null, "Nota", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTPNota.setFont(new Font("Arial", 1, 12));
        this.JTPNota.addKeyListener(new KeyAdapter() { // from class: ParametrizacionN.JIFGAlertaxUsuario.4
            public void keyPressed(KeyEvent evt) {
                JIFGAlertaxUsuario.this.JTPNotaKeyPressed(evt);
            }
        });
        this.JSPNotas.setViewportView(this.JTPNota);
        this.JDCFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fin Alerta", 1, 0, new Font("Tahoma", 1, 12), Color.blue));
        this.JDCFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDCFechaF.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ruta Soporte", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFGAlertaxUsuario.5
            public void mouseClicked(MouseEvent evt) {
                JIFGAlertaxUsuario.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JFTFValor.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JFTFValor.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JFTFValor.setHorizontalAlignment(4);
        this.JFTFValor.setText("0");
        this.JFTFValor.setFont(new Font("Arial", 1, 12));
        GroupLayout JPIDatosProfLayout = new GroupLayout(this.JPIDatosProf);
        this.JPIDatosProf.setLayout(JPIDatosProfLayout);
        JPIDatosProfLayout.setHorizontalGroup(JPIDatosProfLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosProfLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosProfLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPDetalle, GroupLayout.Alignment.TRAILING).addGroup(JPIDatosProfLayout.createSequentialGroup().addGroup(JPIDatosProfLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosProfLayout.createSequentialGroup().addComponent(this.JCHEstado).addGap(18, 18, 18).addComponent(this.JDCFechaF, -1, -1, 32767)).addComponent(this.JCBTipoAlerta, -2, 276, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIDatosProfLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(JPIDatosProfLayout.createSequentialGroup().addComponent(this.JTFRuta, -1, 558, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JFTFValor, -2, 158, -2)).addComponent(this.JSPNotas)))).addContainerGap()));
        JPIDatosProfLayout.setVerticalGroup(JPIDatosProfLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosProfLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosProfLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBTipoAlerta, -2, 52, -2).addComponent(this.JTFRuta, -2, 50, -2).addComponent(this.JFTFValor, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPIDatosProfLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHEstado, -2, 36, -2).addComponent(this.JDCFechaF, -2, 56, -2).addComponent(this.JSPNotas, -2, 99, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalle, -1, 144, 32767).addContainerGap()));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JPIDatosProf, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.JPIFDatosUsuario, GroupLayout.Alignment.LEADING, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIFDatosUsuario, -2, -1, -2).addGap(18, 18, 18).addComponent(this.JPIDatosProf, -1, -1, 32767).addContainerGap()));
        getAccessibleContext().setAccessibleName("usuario");
        pack();
    }

    private void txtFechaNacimientoFocusLost(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosing(InternalFrameEvent evt) {
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            Principal.txtNo.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 4).toString());
            this.JCBTipoAlerta.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString());
            this.JTPNota.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString());
            this.JCHEstado.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString()).booleanValue());
            this.JDCFechaF.setDate(this.xmetodos.getConvertirStringDate(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 5).toString()).getTime());
            this.JTFRuta.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 7).toString());
            this.JFTFValor.setValue(Double.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 8).toString()));
            this.xestadog = true;
            mIniciarCheck();
            if (evt.getClickCount() == 2) {
                String rutaa = this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 7).toString();
                this.xmetodos.mostrarPdf(this.directorio + "\\" + rutaa);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEstadoActionPerformed(ActionEvent evt) {
        mIniciarCheck();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTPNotaKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 9) {
            this.JTPNota.transferFocus();
        } else if (evt.getKeyCode() == 222) {
            JOptionPane.showInternalMessageDialog(this, "Caracter(') no valido, \nFavor reemplazarlo", "Verificacion", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTPNota.setText(this.JTPNota.getText().substring(0, this.JTPNota.getText().length() - 1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JFileChooser xfilec = new JFileChooser(this.JTFRuta.getText());
            int xv = xfilec.showOpenDialog(this);
            if (xv == 0) {
                this.xfile = xfilec.getSelectedFile();
                System.out.println(this.xfile.getAbsolutePath());
                this.JTFRuta.setText(this.xfile.getAbsolutePath());
                this.JTFRuta.setText(this.xmetodos.mTraerUrlBD(this.xfile.getAbsolutePath()));
            }
        }
    }

    private void mIniciarCheck() {
        if (this.JCHEstado.isSelected()) {
            this.xestado = 1;
        } else {
            this.xestado = 0;
        }
    }

    private void mCargasPanelUsuario() {
        this.xjppersona = new Persona(this);
        this.xjppersona.setVisible(true);
        this.JPIFDatosUsuario.setVisible(false);
        this.xjppersona.setBounds(5, 15, 950, 160);
        this.JPIFDatosUsuario.add(this.xjppersona);
        this.JPIFDatosUsuario.setVisible(true);
    }

    public void mNuevo() {
        this.directorio = new File(this.xmetodos.mRutaSoporte("JIFGAlertaxUsuario"));
        this.xjppersona.nuevo();
        Principal.txtNo.setText("");
        this.JDCFechaF.setDate(this.xmetodos.getFechaActual());
        this.xestado = 1;
        this.xestadog = false;
        this.JCBTipoAlerta.setSelectedIndex(-1);
        mCrearModeloDatos();
        this.xjppersona.txtHistoria.requestFocus();
        this.JTPNota.setText("");
        this.JTFRuta.setText("");
        this.JFTFValor.setValue(0);
    }

    public void mGrabar() {
        if (!this.xjppersona.getIdPersona().equals("") && this.xjppersona.getIdPersona() != null) {
            if (this.JCBTipoAlerta.getSelectedIndex() != -1) {
                if (!this.JTPNota.getText().isEmpty()) {
                    int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    if (n == 0) {
                        if (!Principal.txtNo.getText().isEmpty()) {
                            if (this.JTDetalle.getSelectedRow() != -1) {
                                this.xconsultas.ejecutarSQL("update g_usuarioxtipoalerta set Estado='" + this.xestado + "', Detalle='" + this.JTPNota.getText() + "', FechaFin='" + this.xmetodos.formatoAMD.format(this.JDCFechaF.getDate()) + "', Valor='" + this.JFTFValor.getValue() + "' where Id='" + Principal.txtNo.getText() + "'");
                                this.xconsultas.cerrarConexionBd();
                            }
                        } else {
                            this.xjppersona.grabar();
                            File directorio = new File(this.xmetodos.mRutaSoporte("JIFGAlertaxUsuario"));
                            String xidDoc = this.xconsultas.ejecutarSQLId("Insert into g_usuarioxtipoalerta(Id_Usuario, Id_TipoAlerta, Detalle, Estado, FechaFin, Fecha, Valor, UsuarioS) values ('" + this.xjppersona.getIdPersona() + "','" + this.xidtipoalerta[this.JCBTipoAlerta.getSelectedIndex()] + "','" + this.JTPNota.getText() + "','" + this.xestado + "','" + this.xmetodos.formatoAMD.format(this.JDCFechaF.getDate()) + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + this.JFTFValor.getValue() + "','" + Principal.usuarioSistemaDTO.getLogin() + "')");
                            String adjunto = xidDoc + "_" + this.xjppersona.getIdPersona() + "_" + this.JCBTipoAlerta.getSelectedItem() + ".pdf";
                            System.out.println(adjunto);
                            String sql = "UPDATE g_usuarioxtipoalerta set Ruta='" + this.xmetodos.mTraerUrlBD(adjunto) + "' WHERE Id='" + xidDoc + "'";
                            this.xconsultas.ejecutarSQL(sql);
                            this.xconsultas.cerrarConexionBd();
                            File f1 = new File(this.JTFRuta.getText());
                            File f2 = new File(adjunto);
                            f1.renameTo(f2);
                            f2.renameTo(new File(directorio, f2.getName()));
                            this.xestadog = true;
                            this.xconsultas.ejecutarSQL(sql);
                            this.xconsultas.cerrarConexionBd();
                        }
                        mCargarDatosTabla(this.xjppersona.getIdPersona());
                        return;
                    }
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "El detalle no puede ser nulo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JTPNota.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un tipo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBTipoAlerta.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una persona", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Tipo Alerta", "Detalle", "Estado", "", "Fecha Final", "UsuarioS", "Ruta", "Valor"}) { // from class: ParametrizacionN.JIFGAlertaxUsuario.6
            Class[] types = {Long.class, String.class, String.class, Boolean.class, Long.class, String.class, String.class, String.class, Double.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTDetalle;
        JTable jTable2 = this.JTDetalle;
        jTable.setAutoResizeMode(0);
        this.JTDetalle.doLayout();
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(450);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(4).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(4).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(100);
    }

    public void mCargarDatosTabla(String xidp) {
        try {
            mCrearModeloDatos();
            String sql = "SELECT g_tipoalerta.Id, g_tipoalerta.Nbre, g_usuarioxtipoalerta.Detalle, g_usuarioxtipoalerta.Estado, g_usuarioxtipoalerta.Id, DATE_FORMAT(g_usuarioxtipoalerta.FechaFin, '%d/%m/%Y'), g_usuarioxtipoalerta.UsuarioS, `g_usuarioxtipoalerta`.`Ruta`, `g_usuarioxtipoalerta`.`Valor` FROM g_usuarioxtipoalerta INNER JOIN g_tipoalerta  ON (g_usuarioxtipoalerta.Id_TipoAlerta = g_tipoalerta.Id) WHERE g_usuarioxtipoalerta.Id_Usuario= '" + xidp + "' ORDER BY g_tipoalerta.Nbre ASC ";
            ResultSet xrs = this.xconsultas.traerRs(sql);
            System.out.println("Alertas-->" + sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                this.xmetodos.mEstablecerTextEditor(this.JTDetalle, 2);
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(1)), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(4)), n, 3);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(5)), n, 4);
                    this.xmodelo.setValueAt(xrs.getString(6), n, 5);
                    this.xmodelo.setValueAt(xrs.getString("UsuarioS"), n, 6);
                    this.xmodelo.setValueAt(xrs.getString(8), n, 7);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(9)), n, 8);
                    n++;
                }
            }
            xrs.close();
            this.xconsultas.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFFEmpresaServicios.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mBuscar() {
        BuscarPersona frmBuscar = new BuscarPersona(null, true, this.xjppersona);
        frmBuscar.setVisible(true);
    }
}
