package Sgc;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
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

/* JADX INFO: loaded from: GenomaP.jar:Sgc/JIFSolicitudes.class */
public class JIFSolicitudes extends JInternalFrame {
    private String[] xidtipop;
    public String[][] xidtiposolicitud;
    public String[][] xidproceso;
    private String xsql;
    private DefaultTableModel xmodelo;
    private Object[] xdato;
    private JButton JBTAdicionar;
    private JButton JBTBuscar;
    private JComboBox JCBProceso;
    private JComboBox JCBTProceso;
    public JComboBox JCBTipoSolicitud;
    private JDateChooser JDFecha;
    private JPanel JPIDatosC;
    private JScrollPane JSPDetalle;
    private JScrollPane JSPObservacion;
    private JTextPane JTAObservacion;
    public JTable JTDetalle;
    public JTextField JTFNombreP;
    private JPanel jPanel1;
    private ConsultasMySQL xct = new ConsultasMySQL();
    private Metodos xmt = new Metodos();
    private boolean xlleno = false;
    private boolean xlleno1 = false;
    public long xidactividad = 1;
    private int xnfila = -1;
    private int xcontar = 0;
    private int xaplicaencuesta = 1;

    public JIFSolicitudes() {
        initComponents();
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v59, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jPanel1 = new JPanel();
        this.JDFecha = new JDateChooser();
        this.JCBTProceso = new JComboBox();
        this.JCBProceso = new JComboBox();
        this.JPIDatosC = new JPanel();
        this.JCBTipoSolicitud = new JComboBox();
        this.JTFNombreP = new JTextField();
        this.JBTAdicionar = new JButton();
        this.JBTBuscar = new JButton();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JSPObservacion = new JScrollPane();
        this.JTAObservacion = new JTextPane();
        setClosable(true);
        setIconifiable(true);
        setTitle("SOLICITUD");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifsolicitudes");
        addInternalFrameListener(new InternalFrameListener() { // from class: Sgc.JIFSolicitudes.1
            public void internalFrameClosed(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                JIFSolicitudes.this.formInternalFrameClosing(evt);
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
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 0, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JDFecha.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFecha.setDateFormatString("dd/MM/yyyy");
        this.JDFecha.setFont(new Font("Arial", 1, 12));
        this.JCBTProceso.setFont(new Font("Arial", 1, 12));
        this.JCBTProceso.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Proceso", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTProceso.addItemListener(new ItemListener() { // from class: Sgc.JIFSolicitudes.2
            public void itemStateChanged(ItemEvent evt) {
                JIFSolicitudes.this.JCBTProcesoItemStateChanged(evt);
            }
        });
        this.JCBProceso.setFont(new Font("Arial", 1, 12));
        this.JCBProceso.setBorder(BorderFactory.createTitledBorder((Border) null, "Proceso", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBProceso.addItemListener(new ItemListener() { // from class: Sgc.JIFSolicitudes.3
            public void itemStateChanged(ItemEvent evt) {
                JIFSolicitudes.this.JCBProcesoItemStateChanged(evt);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addContainerGap(23, 32767).addComponent(this.JDFecha, -2, 120, -2).addGap(18, 18, 18).addComponent(this.JCBTProceso, -2, 236, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBProceso, -2, 466, -2)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JDFecha, -2, -1, -2).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBTProceso, -2, -1, -2).addComponent(this.JCBProceso, -2, -1, -2))).addContainerGap(-1, 32767)));
        this.JPIDatosC.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 0, 0, new Font("Arial", 1, 14), new Color(0, 102, 51)));
        this.JCBTipoSolicitud.setFont(new Font("Arial", 1, 12));
        this.JCBTipoSolicitud.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFNombreP.setFont(new Font("Arial", 1, 12));
        this.JTFNombreP.setHorizontalAlignment(2);
        this.JTFNombreP.setBorder(BorderFactory.createTitledBorder((Border) null, "Descripción", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBTAdicionar.setFont(new Font("Arial", 1, 12));
        this.JBTAdicionar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTAdicionar.setText("Adicionar");
        this.JBTAdicionar.addActionListener(new ActionListener() { // from class: Sgc.JIFSolicitudes.4
            public void actionPerformed(ActionEvent evt) {
                JIFSolicitudes.this.JBTAdicionarActionPerformed(evt);
            }
        });
        this.JBTBuscar.setFont(new Font("Arial", 1, 12));
        this.JBTBuscar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/lupa.png")));
        this.JBTBuscar.addActionListener(new ActionListener() { // from class: Sgc.JIFSolicitudes.5
            public void actionPerformed(ActionEvent evt) {
                JIFSolicitudes.this.JBTBuscarActionPerformed(evt);
            }
        });
        GroupLayout JPIDatosCLayout = new GroupLayout(this.JPIDatosC);
        this.JPIDatosC.setLayout(JPIDatosCLayout);
        JPIDatosCLayout.setHorizontalGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosCLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBTipoSolicitud, 0, 853, 32767).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosCLayout.createSequentialGroup().addComponent(this.JTFNombreP, -1, 782, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBTBuscar)).addComponent(this.JBTAdicionar, -1, 853, 32767)).addContainerGap()));
        JPIDatosCLayout.setVerticalGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosCLayout.createSequentialGroup().addContainerGap().addComponent(this.JCBTipoSolicitud, -2, -1, -2).addGap(10, 10, 10).addGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFNombreP).addComponent(this.JBTBuscar, -1, 50, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBTAdicionar, -2, 38, -2).addContainerGap()));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JSPDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalle.setEditingColumn(2);
        this.JTDetalle.setEditingRow(1);
        this.JTDetalle.setGridColor(new Color(0, 0, 0));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.setSelectionMode(0);
        this.JTDetalle.addKeyListener(new KeyAdapter() { // from class: Sgc.JIFSolicitudes.6
            public void keyPressed(KeyEvent evt) {
                JIFSolicitudes.this.JTDetalleKeyPressed(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.JSPObservacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTAObservacion.setFont(new Font("Arial", 1, 12));
        this.JSPObservacion.setViewportView(this.JTAObservacion);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -1, -1, 32767).addComponent(this.JPIDatosC, -1, -1, 32767).addComponent(this.JSPDetalle, -1, 889, 32767).addComponent(this.JSPObservacion, -1, 889, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPIDatosC, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalle, -2, 187, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPObservacion, -1, 95, 32767).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBTProcesoItemStateChanged(ItemEvent evt) {
        if (this.xlleno && this.JCBTProceso.getSelectedIndex() != -1) {
            ConsultasMySQL xct1 = new ConsultasMySQL();
            this.JCBProceso.removeAllItems();
            this.xidproceso = xct1.llenarComboyLista("SELECT Id, Nbre, correo FROM s_sgc_tipoproceso WHERE (Id_Proceso ='" + this.xidtipop[this.JCBTProceso.getSelectedIndex()] + "' AND Estado =1) ORDER BY Nbre ASC", this.xidproceso, this.JCBProceso, 3);
            this.JCBProceso.setSelectedIndex(-1);
            xct1.cerrarConexionBd();
            this.xlleno1 = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBProcesoItemStateChanged(ItemEvent evt) {
        if (this.xlleno1 && this.JCBProceso.getSelectedIndex() != -1) {
            this.JCBTipoSolicitud.removeAllItems();
            ConsultasMySQL xct2 = new ConsultasMySQL();
            this.xsql = "SELECT s_solicitud_tipo_tipoproceso.Id, s_solicitud_tipo.Nbre, s_solicitud_tipo.AplicaE FROM s_solicitud_tipo_tipoproceso INNER JOIN s_solicitud_tipo  ON (s_solicitud_tipo_tipoproceso.Id_TipoSolicitud = s_solicitud_tipo.Id) WHERE (s_solicitud_tipo_tipoproceso.Estado =1 AND s_solicitud_tipo_tipoproceso.Id_TipoProceso ='" + this.xidproceso[this.JCBProceso.getSelectedIndex()][0] + "') ORDER BY s_solicitud_tipo.Nbre ASC ";
            this.xidtiposolicitud = xct2.llenarComboyLista(this.xsql, this.xidtiposolicitud, this.JCBTipoSolicitud, 3);
            this.JCBTipoSolicitud.setSelectedIndex(-1);
            xct2.cerrarConexionBd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 127 && this.JTDetalle.getSelectedRow() != -1) {
            int x = JOptionPane.showInternalConfirmDialog(this, "Desea eliminar la fila seleccionada?", "Eliminar", 0, 3);
            if (x == 0) {
                this.xmodelo.removeRow(this.JTDetalle.getSelectedRow());
                this.JTFNombreP.requestFocus();
                this.xnfila--;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTAdicionarActionPerformed(ActionEvent evt) {
        if (this.JCBTipoSolicitud.getSelectedIndex() != -1) {
            if (!this.JTFNombreP.getText().isEmpty()) {
                this.xnfila++;
                this.xmodelo.addRow(this.xdato);
                this.xmodelo.setValueAt(Long.valueOf(this.xidtiposolicitud[this.JCBTipoSolicitud.getSelectedIndex()][0]), this.xnfila, 0);
                this.xmodelo.setValueAt(this.JTFNombreP.getText(), this.xnfila, 1);
                this.xmodelo.setValueAt(Long.valueOf(this.xidactividad), this.xnfila, 2);
                System.out.println(this.xidtiposolicitud[this.JCBTipoSolicitud.getSelectedIndex()][1]);
                if (this.xidtiposolicitud[this.JCBTipoSolicitud.getSelectedIndex()][1].equals("1")) {
                    this.xcontar++;
                }
                mNuevoItems();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "La descripción no puede ser nula", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            this.JTFNombreP.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un tipo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        this.JCBTipoSolicitud.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosing(InternalFrameEvent evt) {
        Principal.mLimpiarDatosP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTBuscarActionPerformed(ActionEvent evt) {
        if (this.JCBTipoSolicitud.getSelectedIndex() != -1) {
            JDConsultarActividades dialog = new JDConsultarActividades(Principal.clasegeneral.frmPrincipal, true, this, "ACTIVIDAD");
            dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
            dialog.setVisible(true);
            System.out.println(this.xidproceso[this.JCBProceso.getSelectedIndex()][1]);
        }
    }

    public void mGrabar() {
        String upperCase;
        if (Principal.txtNo.getText().isEmpty()) {
            if (this.JCBProceso.getSelectedIndex() != -1) {
                if (this.xnfila != -1) {
                    int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar la solicitud?", "Guardar", 0, 3);
                    if (x == 0) {
                        if (this.xcontar > 0) {
                            this.xaplicaencuesta = 1;
                        } else {
                            this.xaplicaencuesta = 0;
                        }
                        this.xsql = "insert into s_solicitud(FechaS, Id_Persona_Cargo, AplicaE, ObservacionG, Fecha, UsuarioS) values('" + this.xmt.formatoAMD.format(this.JDFecha.getDate()) + "','" + Principal.usuarioSistemaDTO.getIdPersonaCargo() + "','" + this.xaplicaencuesta + "','" + this.JTAObservacion.getText() + "','" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                        Principal.txtNo.setText(this.xct.ejecutarSQLId(this.xsql));
                        this.xct.cerrarConexionBd();
                        for (int y = 0; y < this.JTDetalle.getRowCount(); y++) {
                            if (Long.valueOf(this.xmodelo.getValueAt(y, 2).toString()).longValue() == 1) {
                                upperCase = this.xmodelo.getValueAt(y, 1).toString().toUpperCase();
                            } else {
                                upperCase = "";
                            }
                            String xnactividad = upperCase;
                            this.xsql = "insert into s_solicitud_detalle (Id_Solicitud, Id_Tipo_S, Id_Actividad, Descripcion) values('" + Principal.txtNo.getText() + "','" + this.xmodelo.getValueAt(y, 0) + "','" + this.xmodelo.getValueAt(y, 2) + "','" + xnactividad + "')";
                            this.xct.ejecutarSQL(this.xsql);
                            this.xct.cerrarConexionBd();
                        }
                        if (this.xcontar > 0) {
                            this.xsql = "insert into s_solicitud_autorizacion(Id_Solicitud, Id_Persona) values('" + Principal.txtNo.getText() + "','" + Principal.usuarioSistemaDTO.getIdPersonaLider() + "')";
                            this.xct.ejecutarSQL(this.xsql);
                            this.xct.cerrarConexionBd();
                            this.xsql = "Se ha generado la solicitud N° " + Principal.txtNo.getText() + "\nal proceso : " + this.JCBProceso.getSelectedItem().toString() + "\nObservación : " + this.JTAObservacion.getText() + "\n\nFavor entrar a Genoma Plus y autorizar.\n\n\n" + Principal.usuarioSistemaDTO.getNombreUsuario() + "\n" + Principal.usuarioSistemaDTO.getNombreCargoUsuario();
                            this.xmt.mEnvioCorreoElectronico(this.xsql, Principal.usuarioSistemaDTO.getCorreoLider(), "AUTORIZACIÓN DE SOLICITUDES", Principal.usuarioSistemaDTO.getLogin());
                            return;
                        }
                        if (!this.xidproceso[this.JCBProceso.getSelectedIndex()][1].equals("")) {
                            this.xsql = "Se ha generado la solicitud N° " + Principal.txtNo.getText() + "\nal proceso : " + this.JCBProceso.getSelectedItem().toString() + "\nObservación : " + this.JTAObservacion.getText() + "\n\nFavor entrar a Genoma Plus y revisar.\n\n\n" + Principal.usuarioSistemaDTO.getNombreUsuario() + "\n" + Principal.usuarioSistemaDTO.getNombreCargoUsuario();
                            this.xmt.mEnvioCorreoElectronico(this.xsql, this.xidproceso[this.JCBProceso.getSelectedIndex()][1], "TAREA ASIGNADA", Principal.usuarioSistemaDTO.getLogin());
                            return;
                        }
                        return;
                    }
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Debe registrar una solicitud", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un proceso", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            this.JCBProceso.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Solicitud ya grabada", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
    }

    public void mNuevo() {
        Principal.mLimpiarDatosP();
        this.xlleno = false;
        this.xcontar = 0;
        this.xlleno1 = false;
        this.xidactividad = 1L;
        this.xnfila = -1;
        this.JDFecha.setDate(this.xmt.getFechaActual());
        this.JCBTipoSolicitud.removeAllItems();
        this.JCBProceso.removeAllItems();
        this.JCBTProceso.removeAllItems();
        this.xidtipop = this.xct.llenarCombo("SELECT Id , Nbre FROM s_sgc_procesos WHERE (Estado =1) ORDER BY Nbre ASC", this.xidtipop, this.JCBTProceso);
        this.JCBTProceso.setSelectedIndex(-1);
        this.xlleno = true;
        this.xct.cerrarConexionBd();
        this.JTAObservacion.setText("");
        mCrearTablaDetalle();
        this.JDFecha.requestFocus();
    }

    private void mNuevoItems() {
        this.xidactividad = 1L;
        this.JTFNombreP.setText("");
        this.JCBTipoSolicitud.setSelectedIndex(-1);
        this.JCBTipoSolicitud.requestFocus();
    }

    private void mCrearTablaDetalle() {
        this.xmodelo = new DefaultTableModel((Object[][]) null, new String[]{"Id", "Nombre", "IdActividad"}) { // from class: Sgc.JIFSolicitudes.7
            Class[] types = {Long.class, String.class, Long.class};
            boolean[] canEdit = {false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(400);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(2).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(2).setMaxWidth(0);
    }

    public long getXidactividad() {
        return this.xidactividad;
    }

    public void setXidactividad(long xidactividad) {
        this.xidactividad = xidactividad;
    }
}
