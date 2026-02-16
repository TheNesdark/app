package GestionDoc;

import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultCellEditor;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/* JADX INFO: loaded from: GenomaP.jar:GestionDoc/JIFGestionExamenes.class */
public class JIFGestionExamenes extends JInternalFrame {
    private String[] xidservicio;
    private DefaultTableModel xmodelo;
    private int xllenoc;
    private Object[] xdato;
    private Object xjif;
    private String xnombre;
    private ButtonGroup JBGDatos;
    private JComboBox JCBEmpresa;
    public JDateChooser JDCFechaFin;
    public JDateChooser JDCFechaInicio;
    private JPanel JPEstado;
    private JPanel JPIDatoP;
    private JPanel JPIDetalle;
    private JPanel JPPrincipal;
    private JRadioButton JRBArmada;
    private JRadioButton JRBSinArmar;
    private JScrollPane JSPResultado;
    private JTable JTBResultado;
    private int xllenocg = 0;
    private int xidescapitado = 0;
    private int xnitems = 0;
    private int xllego = 0;
    private ConsultasMySQL xconsultasbd = new ConsultasMySQL();
    private Metodos xmetodo = new Metodos();

    public JIFGestionExamenes() {
        this.xllenoc = 0;
        initComponents();
        this.JDCFechaInicio.setDate(this.xmetodo.getFechaActual());
        this.JDCFechaFin.setDate(this.xmetodo.getFechaActual());
        this.xidservicio = this.xconsultasbd.llenarCombo("SELECT Id, Nbre FROM  f_tiposervicio WHERE (Estado =0) ORDER BY Nbre ASC", this.xidservicio, this.JCBEmpresa);
        this.JCBEmpresa.setSelectedIndex(-1);
        this.xconsultasbd.cerrarConexionBd();
        mCrearTablaDetalleProc();
        this.xllenoc = 1;
    }

    /* JADX WARN: Type inference failed for: r3v50, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGDatos = new ButtonGroup();
        this.JPPrincipal = new JPanel();
        this.JPIDatoP = new JPanel();
        this.JDCFechaInicio = new JDateChooser();
        this.JDCFechaFin = new JDateChooser();
        this.JCBEmpresa = new JComboBox();
        this.JPEstado = new JPanel();
        this.JRBSinArmar = new JRadioButton();
        this.JRBArmada = new JRadioButton();
        this.JPIDetalle = new JPanel();
        this.JSPResultado = new JScrollPane();
        this.JTBResultado = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("GESTION DE EXAMENES");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifgestionexamenes");
        setPreferredSize(new Dimension(1079, 801));
        this.JPPrincipal.setName("jpgestionexamenes");
        this.JPPrincipal.setPreferredSize(new Dimension(1035, 827));
        this.JPIDatoP.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS PARA CONSULTAR", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JDCFechaInicio.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicio", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFechaInicio.setDateFormatString("dd/MM/yyyy");
        this.JDCFechaInicio.setFont(new Font("Arial", 1, 12));
        this.JDCFechaFin.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Fin", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFechaFin.setDateFormatString("dd/MM/yyyy");
        this.JDCFechaFin.setFont(new Font("Arial", 1, 12));
        this.JCBEmpresa.setFont(new Font("Arial", 1, 12));
        this.JCBEmpresa.setBorder(BorderFactory.createTitledBorder((Border) null, "Servicio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JPEstado.setBorder(BorderFactory.createTitledBorder((Border) null, "Estado", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBGDatos.add(this.JRBSinArmar);
        this.JRBSinArmar.setFont(new Font("Arial", 1, 12));
        this.JRBSinArmar.setSelected(true);
        this.JRBSinArmar.setText("Por Recepcionar");
        this.JRBSinArmar.addActionListener(new ActionListener() { // from class: GestionDoc.JIFGestionExamenes.1
            public void actionPerformed(ActionEvent evt) {
                JIFGestionExamenes.this.JRBSinArmarActionPerformed(evt);
            }
        });
        this.JBGDatos.add(this.JRBArmada);
        this.JRBArmada.setFont(new Font("Arial", 1, 12));
        this.JRBArmada.setText("Recepcionados");
        this.JRBArmada.addActionListener(new ActionListener() { // from class: GestionDoc.JIFGestionExamenes.2
            public void actionPerformed(ActionEvent evt) {
                JIFGestionExamenes.this.JRBArmadaActionPerformed(evt);
            }
        });
        GroupLayout JPEstadoLayout = new GroupLayout(this.JPEstado);
        this.JPEstado.setLayout(JPEstadoLayout);
        JPEstadoLayout.setHorizontalGroup(JPEstadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPEstadoLayout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.JRBSinArmar).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBArmada).addGap(81, 81, 81)));
        JPEstadoLayout.setVerticalGroup(JPEstadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPEstadoLayout.createSequentialGroup().addContainerGap().addGroup(JPEstadoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBSinArmar).addComponent(this.JRBArmada)).addContainerGap(-1, 32767)));
        GroupLayout JPIDatoPLayout = new GroupLayout(this.JPIDatoP);
        this.JPIDatoP.setLayout(JPIDatoPLayout);
        JPIDatoPLayout.setHorizontalGroup(JPIDatoPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatoPLayout.createSequentialGroup().addContainerGap().addComponent(this.JDCFechaInicio, -2, 130, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JDCFechaFin, -2, 130, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBEmpresa, 0, 434, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JPEstado, -2, 263, -2).addGap(18, 18, 18)));
        JPIDatoPLayout.setVerticalGroup(JPIDatoPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatoPLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatoPLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JCBEmpresa, -2, 51, -2).addComponent(this.JPEstado, -2, -1, -2).addGroup(JPIDatoPLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JDCFechaInicio, -2, 61, -2).addComponent(this.JDCFechaFin, -2, 61, -2))).addContainerGap(-1, 32767)));
        this.JPIDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "RESULTADO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JSPResultado.setBorder(BorderFactory.createEtchedBorder());
        this.JTBResultado.setFont(new Font("Arial", 1, 12));
        this.JTBResultado.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTBResultado.setEditingColumn(1);
        this.JTBResultado.setEditingRow(1);
        this.JTBResultado.setRowHeight(25);
        this.JTBResultado.setSelectionBackground(new Color(255, 255, 255));
        this.JTBResultado.setSelectionForeground(new Color(255, 0, 0));
        this.JTBResultado.setSelectionMode(0);
        this.JTBResultado.addMouseListener(new MouseAdapter() { // from class: GestionDoc.JIFGestionExamenes.3
            public void mouseClicked(MouseEvent evt) {
                JIFGestionExamenes.this.JTBResultadoMouseClicked(evt);
            }
        });
        this.JSPResultado.setViewportView(this.JTBResultado);
        GroupLayout JPIDetalleLayout = new GroupLayout(this.JPIDetalle);
        this.JPIDetalle.setLayout(JPIDetalleLayout);
        JPIDetalleLayout.setHorizontalGroup(JPIDetalleLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDetalleLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPResultado, -1, 993, 32767).addContainerGap()));
        JPIDetalleLayout.setVerticalGroup(JPIDetalleLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDetalleLayout.createSequentialGroup().addComponent(this.JSPResultado, -1, 565, 32767).addContainerGap()));
        GroupLayout JPPrincipalLayout = new GroupLayout(this.JPPrincipal);
        this.JPPrincipal.setLayout(JPPrincipalLayout);
        JPPrincipalLayout.setHorizontalGroup(JPPrincipalLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPPrincipalLayout.createSequentialGroup().addContainerGap().addGroup(JPPrincipalLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JPIDetalle, GroupLayout.Alignment.LEADING, 0, -1, 32767).addComponent(this.JPIDatoP, GroupLayout.Alignment.LEADING, -1, -1, 32767)).addContainerGap()));
        JPPrincipalLayout.setVerticalGroup(JPPrincipalLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPPrincipalLayout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatoP, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JPIDetalle, -1, -1, 32767).addContainerGap()));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPPrincipal, -1, 1043, 32767).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap(17, 32767).addComponent(this.JPPrincipal, -2, 744, -2).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBSinArmarActionPerformed(ActionEvent evt) {
        this.xllego = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBArmadaActionPerformed(ActionEvent evt) {
        this.xllego = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBResultadoMouseClicked(MouseEvent evt) {
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTablaDetalleProc() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Fecha", "N° Historia", "Usuario", "Procedimiento", "Profesional", "Estado", "Id Orden", "IdProcedimiento"}) { // from class: GestionDoc.JIFGestionExamenes.4
            Class[] types = {String.class, String.class, String.class, String.class, String.class, Boolean.class, Long.class, Long.class};
            boolean[] canEdit = {false, true, false, false, false, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTBResultado.setModel(this.xmodelo);
        this.JTBResultado.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTBResultado.getColumnModel().getColumn(1).setPreferredWidth(15);
        this.JTBResultado.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTBResultado.getColumnModel().getColumn(3).setPreferredWidth(250);
        this.JTBResultado.getColumnModel().getColumn(4).setPreferredWidth(50);
        this.JTBResultado.getColumnModel().getColumn(5).setPreferredWidth(10);
        TableColumn sportColumn = this.JTBResultado.getColumnModel().getColumn(5);
        JCheckBox jch = new JCheckBox();
        sportColumn.setCellEditor(new DefaultCellEditor(jch));
        this.JTBResultado.getColumnModel().getColumn(6).setPreferredWidth(0);
        this.JTBResultado.getColumnModel().getColumn(6).setMinWidth(0);
        this.JTBResultado.getColumnModel().getColumn(6).setMaxWidth(0);
        this.JTBResultado.getColumnModel().getColumn(7).setPreferredWidth(0);
        this.JTBResultado.getColumnModel().getColumn(7).setMinWidth(0);
        this.JTBResultado.getColumnModel().getColumn(7).setMaxWidth(0);
    }

    private void mCargarDatos() {
        if (this.JCBEmpresa.getSelectedIndex() != -1) {
            String sql = "SELECT DATE_FORMAT(f_ordenes.Fecha,'%d-%m-%Y') AS Fecha, persona.NoHistoria , persona.NUsuario , g_procedimiento.Nbre, profesional.NProfesional, f_ordenes.Id, f_itemordenesproced.Id_Procedimiento, f_itemordenesproced.EsRecepcionado  FROM  f_itemordenesproced INNER JOIN  f_ordenes  ON (f_itemordenesproced.Id_Ordenes = f_ordenes.Id) INNER JOIN  ingreso ON (f_ordenes.Id_Ingreso = ingreso.Id) INNER JOIN  profesional ON (f_ordenes.Id_Profesional = profesional.Id_Persona) INNER JOIN  g_procedimiento  ON (f_itemordenesproced.Id_Procedimiento = g_procedimiento.Id) INNER JOIN  persona  ON (persona.Id_persona = ingreso.Id_Usuario) WHERE (ingreso.FechaIngreso >='" + this.xmetodo.formatoAMD.format(this.JDCFechaInicio.getDate()) + "'  AND ingreso.FechaIngreso <='" + this.xmetodo.formatoAMD.format(this.JDCFechaFin.getDate()) + "' AND f_ordenes.Id_TipoServicio ='" + this.xidservicio[this.JCBEmpresa.getSelectedIndex()] + "' AND f_ordenes.Estado =0 AND f_itemordenesproced.EsRecepcionado='" + this.xllego + "') ORDER BY f_ordenes.Fecha ASC,  f_ordenes.Id ASC, g_procedimiento.Nbre ASC ";
            ResultSet rs = this.xconsultasbd.traerRs(sql);
            try {
                if (rs.next()) {
                    rs.beforeFirst();
                    int m = 0;
                    this.xnitems = 0;
                    while (rs.next()) {
                        this.xmodelo.addRow(this.xdato);
                        this.xmodelo.setValueAt(rs.getString(1), m, 0);
                        this.xmodelo.setValueAt(rs.getString(2), m, 1);
                        this.xmodelo.setValueAt(rs.getString(3), m, 2);
                        this.xmodelo.setValueAt(rs.getString(4), m, 3);
                        this.xmodelo.setValueAt(rs.getString(5), m, 4);
                        this.xmodelo.setValueAt(rs.getString(6), m, 6);
                        this.xmodelo.setValueAt(rs.getString(7), m, 7);
                        if (rs.getInt(8) == 0) {
                            this.JTBResultado.setValueAt(false, m, 5);
                        } else {
                            this.JTBResultado.setValueAt(true, m, 5);
                        }
                        m++;
                    }
                }
                rs.close();
                this.xconsultasbd.cerrarConexionBd();
                return;
            } catch (SQLException e) {
                return;
            }
        }
        JOptionPane.showMessageDialog(this, "Debe seleccionar una empresa", "VALIDAR", 0);
        this.JCBEmpresa.requestFocus();
    }

    private boolean mVerificarDatosTablaTrue() {
        boolean estado = false;
        if (this.JTBResultado.getRowCount() > 1) {
            int i = 0;
            while (true) {
                if (i >= this.JTBResultado.getRowCount() - 1) {
                    break;
                }
                if (!this.JTBResultado.getValueAt(i, 5).toString().equals("true")) {
                    i++;
                } else {
                    estado = true;
                    break;
                }
            }
        }
        return estado;
    }

    private boolean mVerificarDatosTablaFalse() {
        boolean estado = false;
        if (this.JTBResultado.getRowCount() > 1) {
            int i = 0;
            while (true) {
                if (i >= this.JTBResultado.getRowCount() - 1) {
                    break;
                }
                if (!this.JTBResultado.getValueAt(i, 5).toString().equals("false")) {
                    i++;
                } else {
                    estado = true;
                    break;
                }
            }
        }
        return estado;
    }

    public void buscar() {
        mCrearTablaDetalleProc();
        mCargarDatos();
    }

    public void nuevo() {
        this.xllenoc = 0;
        this.xllenocg = 0;
        this.JDCFechaInicio.setDate(this.xmetodo.getFechaActual());
        this.JDCFechaFin.setDate(this.xmetodo.getFechaActual());
        this.JCBEmpresa.setSelectedIndex(-1);
        mCrearTablaDetalleProc();
        this.xllego = 0;
        this.JRBSinArmar.setSelected(true);
        this.xllenoc = 1;
        this.xllenocg = 1;
        this.JDCFechaInicio.requestFocus();
    }

    public void grabar() {
        int n = JOptionPane.showConfirmDialog(this, "Esta seguro de guardar", "CONFIRMAR", 2, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            if (this.xllego == 0 && mVerificarDatosTablaTrue() && this.JTBResultado.getRowCount() > 1) {
                this.xmetodo = new Metodos();
                for (int i = 0; i < this.JTBResultado.getRowCount() - 1; i++) {
                    if (this.JTBResultado.getValueAt(i, 5).toString().equals("true")) {
                        String sql = "Update  f_itemordenesproced set EsRecepcionado=1 where Id_Ordenes='" + this.JTBResultado.getValueAt(i, 6) + "' and Id_Procedimiento='" + this.JTBResultado.getValueAt(i, 7) + "'";
                        this.xconsultasbd.ejecutarSQL(sql);
                        this.xconsultasbd.cerrarConexionBd();
                    }
                }
                mCrearTablaDetalleProc();
                mCargarDatos();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "No existe orden seleccionada", "VERIFICAR", 0);
            this.JTBResultado.requestFocus();
        }
    }

    public void anular() {
        String sql;
        if (this.xllego == 1 && mVerificarDatosTablaFalse() && this.JTBResultado.getRowCount() > 1) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de cambiar el estado \n\t a las cuentas ya armadas", "CONFIRMAR", 2, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                for (int i = 0; i < this.JTBResultado.getRowCount() - 1; i++) {
                    if (this.JTBResultado.getValueAt(i, 9).toString().equals("false")) {
                        if (this.xidescapitado == 0) {
                            sql = "Update  f_factura_capita set EstaArmada=0 where No_FacturaCapita='" + this.JTBResultado.getValueAt(i, 1) + "'";
                        } else {
                            sql = "Update  f_factura_evento set EstaArmada=0 where No_FacturaEvento='" + this.JTBResultado.getValueAt(i, 1) + "'";
                        }
                        this.xconsultasbd.ejecutarSQL(sql);
                        this.xconsultasbd.cerrarConexionBd();
                    }
                }
                mCrearTablaDetalleProc();
                mCargarDatos();
            }
        }
    }

    private void mCambiarEstadoArmado() {
        if (this.xnombre.equals("FEAuditoria")) {
            this.xllego = 1;
            this.JRBSinArmar.setSelected(true);
        } else if (this.xnombre.equals("jifarmadocapitacionserv")) {
            this.xllego = 0;
            this.JRBSinArmar.setSelected(false);
        }
    }
}
