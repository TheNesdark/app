package Facturacion;

import Acceso.Principal;
import General.JIFBuscarPatologia;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Facturacion/JPEstanciasH.class */
public class JPEstanciasH extends JPanel {
    public int prueba;
    public String[] xidEmpresaFact;
    public String[] xidTipoAtencion;
    public String[] xidescolaridad;
    public String[] xidocupaciones;
    public String[] xidEspecialidad;
    public String[] xidProfesional;
    public String[] xidContrato;
    public String[] xidOIngreso;
    public String[] xidCausaExt;
    public String[] xidParentezco;
    public String[][] xidCama;
    public String[][] xidCamaTraslado;
    private JIFLiqServicios xliq;
    private JPEncabezado_Ordenes xEncabezadoOrden;
    private DefaultTableModel xmodelohistorico;
    private Object[] xdatos;
    private ButtonGroup JBGTipoEstrato;
    public JComboBox JCBCama;
    public JComboBox JCBCamaDestino;
    private JCheckBox JCHBTraslado;
    public JDateChooser JDFecha;
    public JDateChooser JDFechaTraslado;
    private JLabel JLNoOrden;
    private JPanel JPCamas;
    private JPanel JPDatosCamas;
    private JPanel JPDatosOrden;
    private JPanel JPHistorico;
    private JPanel JPTraslados;
    private JScrollPane JSPHistoricoC;
    private JTable JTHistoricoCamas;
    private JTabbedPane JTPEstancia;
    private ConsultasMySQL xconsulta = new ConsultasMySQL();
    private int cboLleno = 0;
    public int xcopago = 0;
    private boolean xlleno = false;
    private Metodos xmetodo = new Metodos();
    private String xordenU = "";

    public JPEstanciasH(JIFLiqServicios xliq) {
        initComponents();
        mCargarCombos();
        this.xliq = xliq;
        mIniciarPaneles();
        mBuscarOrdenUsuario();
        mCargarHistoricoCamas();
    }

    /* JADX WARN: Type inference failed for: r3v68, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGTipoEstrato = new ButtonGroup();
        this.JPDatosOrden = new JPanel();
        this.JTPEstancia = new JTabbedPane();
        this.JPDatosCamas = new JPanel();
        this.JPCamas = new JPanel();
        this.JDFecha = new JDateChooser();
        this.JCBCama = new JComboBox();
        this.JLNoOrden = new JLabel();
        this.JPTraslados = new JPanel();
        this.JCBCamaDestino = new JComboBox();
        this.JDFechaTraslado = new JDateChooser();
        this.JCHBTraslado = new JCheckBox();
        this.JPHistorico = new JPanel();
        this.JSPHistoricoC = new JScrollPane();
        this.JTHistoricoCamas = new JTable();
        setName("jpEstanciasH");
        this.JPDatosOrden.setMaximumSize(new Dimension(813, 233));
        this.JPDatosOrden.setMinimumSize(new Dimension(813, 233));
        this.JPDatosOrden.setPreferredSize(new Dimension(813, 233));
        GroupLayout JPDatosOrdenLayout = new GroupLayout(this.JPDatosOrden);
        this.JPDatosOrden.setLayout(JPDatosOrdenLayout);
        JPDatosOrdenLayout.setHorizontalGroup(JPDatosOrdenLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 813, 32767));
        JPDatosOrdenLayout.setVerticalGroup(JPDatosOrdenLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 0, 32767));
        this.JTPEstancia.setForeground(new Color(255, 0, 0));
        this.JTPEstancia.setFont(new Font("Arial", 1, 12));
        this.JPCamas.setBorder(BorderFactory.createTitledBorder((Border) null, "ASIGNACIÓN CAMAS", 2, 0, new Font("Arial", 1, 12), new Color(0, 107, 0)));
        this.JDFecha.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFecha.setDateFormatString("dd/MM/yyyy HH:mm:ss");
        this.JDFecha.setFont(new Font("Tahoma", 1, 12));
        this.JDFecha.addKeyListener(new KeyAdapter() { // from class: Facturacion.JPEstanciasH.1
            public void keyPressed(KeyEvent evt) {
                JPEstanciasH.this.JDFechaKeyPressed(evt);
            }
        });
        this.JCBCama.setFont(new Font("Arial", 1, 12));
        this.JCBCama.setBorder(BorderFactory.createTitledBorder((Border) null, "Cama", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JLNoOrden.setFont(new Font("Arial", 1, 18));
        this.JLNoOrden.setForeground(new Color(255, 0, 0));
        this.JLNoOrden.setHorizontalAlignment(0);
        this.JLNoOrden.setBorder(BorderFactory.createTitledBorder((Border) null, "No. Orden", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        GroupLayout JPCamasLayout = new GroupLayout(this.JPCamas);
        this.JPCamas.setLayout(JPCamasLayout);
        JPCamasLayout.setHorizontalGroup(JPCamasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPCamasLayout.createSequentialGroup().addGap(6, 6, 6).addComponent(this.JDFecha, -2, 180, -2).addGap(37, 37, 37).addComponent(this.JCBCama, -2, 396, -2).addGap(36, 36, 36).addComponent(this.JLNoOrden, -2, 123, -2).addContainerGap()));
        JPCamasLayout.setVerticalGroup(JPCamasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPCamasLayout.createSequentialGroup().addContainerGap().addGroup(JPCamasLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JDFecha, -1, 52, 32767).addComponent(this.JCBCama, -2, 50, -2).addComponent(this.JLNoOrden, -1, -1, 32767)).addContainerGap(-1, 32767)));
        this.JPTraslados.setBorder(BorderFactory.createTitledBorder((Border) null, "TRASLADOS", 2, 0, new Font("Arial", 1, 12), new Color(0, 107, 0)));
        this.JCBCamaDestino.setFont(new Font("Arial", 1, 12));
        this.JCBCamaDestino.setBorder(BorderFactory.createTitledBorder((Border) null, "Cama destino", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JCBCamaDestino.setEnabled(false);
        this.JDFechaTraslado.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaTraslado.setDateFormatString("dd/MM/yyyy HH:mm:ss");
        this.JDFechaTraslado.setEnabled(false);
        this.JDFechaTraslado.setFont(new Font("Tahoma", 1, 12));
        this.JDFechaTraslado.addKeyListener(new KeyAdapter() { // from class: Facturacion.JPEstanciasH.2
            public void keyPressed(KeyEvent evt) {
                JPEstanciasH.this.JDFechaTrasladoKeyPressed(evt);
            }
        });
        this.JCHBTraslado.setFont(new Font("Arial", 1, 12));
        this.JCHBTraslado.setForeground(new Color(0, 0, 255));
        this.JCHBTraslado.setText("Traslado");
        this.JCHBTraslado.addActionListener(new ActionListener() { // from class: Facturacion.JPEstanciasH.3
            public void actionPerformed(ActionEvent evt) {
                JPEstanciasH.this.JCHBTrasladoActionPerformed(evt);
            }
        });
        GroupLayout JPTrasladosLayout = new GroupLayout(this.JPTraslados);
        this.JPTraslados.setLayout(JPTrasladosLayout);
        JPTrasladosLayout.setHorizontalGroup(JPTrasladosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPTrasladosLayout.createSequentialGroup().addGap(6, 6, 6).addComponent(this.JDFechaTraslado, -2, 177, -2).addGap(36, 36, 36).addComponent(this.JCBCamaDestino, -2, 399, -2).addGap(40, 40, 40).addComponent(this.JCHBTraslado).addGap(45, 45, 45)));
        JPTrasladosLayout.setVerticalGroup(JPTrasladosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPTrasladosLayout.createSequentialGroup().addContainerGap().addGroup(JPTrasladosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JDFechaTraslado, -1, -1, 32767).addGroup(JPTrasladosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBCamaDestino, -1, 50, 32767).addComponent(this.JCHBTraslado))).addGap(48, 48, 48)));
        GroupLayout JPDatosCamasLayout = new GroupLayout(this.JPDatosCamas);
        this.JPDatosCamas.setLayout(JPDatosCamasLayout);
        JPDatosCamasLayout.setHorizontalGroup(JPDatosCamasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosCamasLayout.createSequentialGroup().addContainerGap().addGroup(JPDatosCamasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPCamas, -1, -1, 32767).addComponent(this.JPTraslados, -1, -1, 32767)).addContainerGap()));
        JPDatosCamasLayout.setVerticalGroup(JPDatosCamasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosCamasLayout.createSequentialGroup().addContainerGap().addComponent(this.JPCamas, -2, 96, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPTraslados, -2, -1, -2).addContainerGap(-1, 32767)));
        this.JTPEstancia.addTab("ASIGNACIÓN CAMAS", this.JPDatosCamas);
        this.JSPHistoricoC.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 12), new Color(0, 102, 0)));
        this.JTHistoricoCamas.setFont(new Font("Arial", 1, 12));
        this.JTHistoricoCamas.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTHistoricoCamas.setSelectionBackground(new Color(255, 255, 255));
        this.JTHistoricoCamas.setSelectionForeground(new Color(255, 0, 0));
        this.JSPHistoricoC.setViewportView(this.JTHistoricoCamas);
        GroupLayout JPHistoricoLayout = new GroupLayout(this.JPHistorico);
        this.JPHistorico.setLayout(JPHistoricoLayout);
        JPHistoricoLayout.setHorizontalGroup(JPHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPHistoricoLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPHistoricoC, -1, 800, 32767).addContainerGap()));
        JPHistoricoLayout.setVerticalGroup(JPHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPHistoricoLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPHistoricoC, -1, 235, 32767).addContainerGap()));
        this.JTPEstancia.addTab("HISTÓRICO", this.JPHistorico);
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap(-1, 32767).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(layout.createSequentialGroup().addComponent(this.JTPEstancia).addContainerGap()).addComponent(this.JPDatosOrden, -2, -1, -2))));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPDatosOrden, -2, 182, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTPEstancia).addContainerGap()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaKeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaTrasladoKeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBTrasladoActionPerformed(ActionEvent evt) {
        if (this.JCHBTraslado.isSelected()) {
            this.JCBCamaDestino.setEnabled(true);
            this.JDFechaTraslado.setEnabled(true);
        } else {
            this.JCBCamaDestino.setEnabled(false);
            this.JDFechaTraslado.setEnabled(false);
        }
    }

    private void mCargarCombos() {
        this.JDFecha.setDate(this.xmetodo.getFechaActual());
        this.JDFechaTraslado.setDate(this.xmetodo.getFechaActual());
        this.JCBCama.removeAllItems();
        this.xidCama = this.xconsulta.llenarComboyLista("SELECT `f_camas`.`Id`, `f_camas`.`Nbre`, `f_tiposervtipoproced`.`Idtiposervicio`, f_camas.`Id_Procedimiento`   FROM `f_camas` INNER JOIN `g_procedimiento`   ON (`f_camas`.`Id_Procedimiento` = `g_procedimiento`.`Id`) INNER JOIN `f_tipoprocedimiento`  ON (`g_procedimiento`.`Id_tipoprocedimiento` = `f_tipoprocedimiento`.`Id`) INNER JOIN `f_tiposervtipoproced`  ON (`f_tiposervtipoproced`.`Idtipoprocedimiento` = `f_tipoprocedimiento`.`Id`) ", this.xidCama, this.JCBCama, 4);
        this.JCBCama.setSelectedIndex(-1);
        this.cboLleno = 1;
        this.xlleno = true;
        this.xconsulta.cerrarConexionBd();
        mLlenarComboCamaTraslado();
    }

    public void mLlenarComboCamaTraslado() {
        this.JCBCamaDestino.removeAllItems();
        this.xidCamaTraslado = this.xconsulta.llenarComboyLista("SELECT `f_camas`.`Id`, `f_camas`.`Nbre`, `f_tiposervtipoproced`.`Idtiposervicio`, f_camas.`Id_Procedimiento`   FROM `f_camas` INNER JOIN `g_procedimiento`   ON (`f_camas`.`Id_Procedimiento` = `g_procedimiento`.`Id`) INNER JOIN `f_tipoprocedimiento`  ON (`g_procedimiento`.`Id_tipoprocedimiento` = `f_tipoprocedimiento`.`Id`) INNER JOIN `f_tiposervtipoproced`  ON (`f_tiposervtipoproced`.`Idtipoprocedimiento` = `f_tipoprocedimiento`.`Id`) WHERE f_camas.Disponible=0", this.xidCamaTraslado, this.JCBCamaDestino, 4);
        this.JCBCamaDestino.setSelectedIndex(-1);
        this.xconsulta.cerrarConexionBd();
    }

    public void mLlenaComboContrato() {
    }

    private void cargarCboProfesional() {
    }

    private void mBuscarPatologiaN(JTextField codigo) {
        JIFBuscarPatologia pac = new JIFBuscarPatologia((Frame) null, true, codigo, "LiqServicios");
        pac.setVisible(true);
        pac.setLocationRelativeTo(this);
    }

    public void mGrabar1() {
    }

    public void mGrabar() {
        String idtiposervicio;
        String xcama;
        String xfechacama;
        if (!this.xliq.JLB_NIngreso.getText().equals("")) {
            if (this.xEncabezadoOrden.JCBEspecialidad.getSelectedIndex() != -1) {
                if (this.xEncabezadoOrden.JCBProfesional.getSelectedIndex() != -1) {
                    if (this.xEncabezadoOrden.JCBCentroCosto.getSelectedIndex() != -1) {
                        if (this.JCBCama.getSelectedIndex() != -1) {
                            int n = JOptionPane.showInternalConfirmDialog(this.xliq, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                            if (n == 0) {
                                if (this.JCHBTraslado.isSelected()) {
                                    idtiposervicio = this.xidCamaTraslado[this.JCBCamaDestino.getSelectedIndex()][1];
                                    xcama = this.xidCamaTraslado[this.JCBCamaDestino.getSelectedIndex()][0];
                                    xfechacama = this.xmetodo.formatoAMDH24.format(this.JDFechaTraslado.getDate());
                                } else {
                                    idtiposervicio = this.xidCama[this.JCBCama.getSelectedIndex()][1];
                                    xcama = this.xidCama[this.JCBCama.getSelectedIndex()][0];
                                    xfechacama = this.xmetodo.formatoAMDH24.format(this.JDFecha.getDate());
                                }
                                String sql = "INSERT INTO  f_ordenes (`Id_Ingreso` , `Id_TipoServicio` , `FechaOrden` , `HoraOrden` , `Id_Profesional` , `Id_Especialidad` , `Id_CentroCosto`, `Fecha` , `UsuarioS`) VALUES ('" + this.xliq.JLB_NIngreso.getText() + "','" + idtiposervicio + "','" + this.xmetodo.formatoAMDH24.format(this.xmetodo.getFechaActual()) + "','" + this.xmetodo.formatoH24.format(this.xmetodo.getFechaActual()) + "','" + this.xEncabezadoOrden.xidprofesional[this.xEncabezadoOrden.JCBProfesional.getSelectedIndex()] + "','" + this.xEncabezadoOrden.xidespecialidad[this.xEncabezadoOrden.JCBEspecialidad.getSelectedIndex()] + "','" + this.xEncabezadoOrden.xidcentrocosto[this.xEncabezadoOrden.JCBCentroCosto.getSelectedIndex()] + "','" + this.xmetodo.formatoAMDH24.format(this.xmetodo.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                                this.JLNoOrden.setText(this.xconsulta.ejecutarSQLId(sql));
                                String sql2 = " INSERT INTO f_itemordenescamas (`IdOrdenes` , `IdCamas`, `FechaIngCama`, UsuarioS) VALUES ('" + this.JLNoOrden.getText() + "','" + xcama + "','" + xfechacama + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                                this.xconsulta.ejecutarSQL(sql2);
                                String sql3 = "UPDATE ingreso SET Cama='" + xcama + "' WHERE Id='" + this.xliq.JLB_NIngreso.getText() + "'";
                                this.xconsulta.ejecutarSQL(sql3);
                                if (this.JCHBTraslado.isSelected()) {
                                    String sql4 = "UPDATE f_camas SET Disponible='0' WHERE Id='" + this.xidCama[this.JCBCama.getSelectedIndex()][0] + "'";
                                    this.xconsulta.ejecutarSQL(sql4);
                                    String sql5 = "UPDATE f_camas SET Disponible='1' WHERE Id='" + this.xidCamaTraslado[this.JCBCamaDestino.getSelectedIndex()][0] + "'";
                                    this.xconsulta.ejecutarSQL(sql5);
                                    String sql6 = "UPDATE f_itemordenescamas SET `FechaEgrCama`='" + this.xmetodo.formatoAMDH24.format(this.JDFechaTraslado.getDate()) + "' , `Nodias`='" + mCalculaDias(this.xmetodo.formatoAMDH24.format(this.JDFechaTraslado.getDate()), this.xmetodo.formatoAMDH24.format(this.JDFecha.getDate())) + "' , `ValorCama`='" + mCalculaTarifaCama(Integer.parseInt(this.xidCama[this.JCBCama.getSelectedIndex()][2].toString())) + "' , `Fecha`='" + this.xmetodo.formatoAMDH24.format(this.xmetodo.getFechaActual()) + "' , `UsuarioS`='" + Principal.usuarioSistemaDTO.getLogin() + "' WHERE IdOrdenes='" + this.xordenU + "'";
                                    this.xconsulta.ejecutarSQL(sql6);
                                } else {
                                    String sql42 = "UPDATE f_camas SET Disponible='1' WHERE Id='" + this.xidCama[this.JCBCama.getSelectedIndex()][0] + "'";
                                    this.xconsulta.ejecutarSQL(sql42);
                                }
                                this.xconsulta.cerrarConexionBd();
                                mBuscarOrdenUsuario();
                                mCargarHistoricoCamas();
                                return;
                            }
                            return;
                        }
                        JOptionPane.showInternalMessageDialog(this.xliq, "Debe seleccionar una cama", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        this.JCBCama.requestFocus();
                        return;
                    }
                    JOptionPane.showInternalMessageDialog(this.xliq, "Debe seleccionar un centro de costo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    this.xEncabezadoOrden.JCBCentroCosto.requestFocus();
                    return;
                }
                JOptionPane.showInternalMessageDialog(this.xliq, "Debe seleccionar un profesional", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.xEncabezadoOrden.JCBProfesional.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this.xliq, "Debe seleccionar una especialidad", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.xEncabezadoOrden.JCBEspecialidad.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this.xliq, "Debe tener un Ingreso cargado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloHistorico() {
        this.xmodelohistorico = new DefaultTableModel(new Object[0], new String[]{"IdOrden", "Cama", "Piso", "Fecha Ingreso", "Fecha Egreso", "No. días", "Valor"}) { // from class: Facturacion.JPEstanciasH.4
            Class[] types = {Integer.class, String.class, String.class, String.class, String.class, Long.class, Double.class};
            boolean[] canEdit = {false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTHistoricoCamas.setModel(this.xmodelohistorico);
        this.JTHistoricoCamas.getColumnModel().getColumn(0).setPreferredWidth(25);
        this.JTHistoricoCamas.getColumnModel().getColumn(1).setPreferredWidth(50);
        this.JTHistoricoCamas.getColumnModel().getColumn(2).setPreferredWidth(50);
        this.JTHistoricoCamas.getColumnModel().getColumn(3).setPreferredWidth(50);
        this.JTHistoricoCamas.getColumnModel().getColumn(4).setPreferredWidth(30);
        this.JTHistoricoCamas.getColumnModel().getColumn(5).setPreferredWidth(20);
        this.JTHistoricoCamas.getColumnModel().getColumn(6).setPreferredWidth(20);
    }

    private void mCargarHistoricoCamas() {
        String sql = "SELECT  `f_itemordenescamas`.`IdOrdenes` , `f_camas`.`Nbre` , f_unidadcama.`Nbre` AS UnidadC,  `f_itemordenescamas`.`FechaIngCama`, f_itemordenescamas.FechaEgrCama, f_itemordenescamas.NoDias, f_itemordenescamas.ValorCama  FROM `f_itemordenescamas` INNER JOIN `baseserver`.`f_camas` ON (`f_itemordenescamas`.`IdCamas` = `f_camas`.`Id`)  INNER JOIN `baseserver`.`f_ordenes`  ON (`f_itemordenescamas`.`IdOrdenes` = `f_ordenes`.`Id`)  INNER JOIN `f_unidadcama` ON (`f_camas`.`Id_UnidadCamas` = `f_unidadcama`.`Id`) WHERE (`f_ordenes`.`Id_Ingreso` = '" + this.xliq.JLB_NIngreso.getText() + "') ORDER BY `f_itemordenescamas`.`FechaIngCama` DESC";
        try {
            mCrearModeloHistorico();
            ResultSet xrs = this.xconsulta.traerRs(sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelohistorico.addRow(this.xdatos);
                    this.xmodelohistorico.setValueAt(Integer.valueOf(xrs.getInt(1)), n, 0);
                    this.xmodelohistorico.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelohistorico.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelohistorico.setValueAt(xrs.getString(4), n, 3);
                    this.xmodelohistorico.setValueAt(xrs.getString(5), n, 4);
                    this.xmodelohistorico.setValueAt(Long.valueOf(xrs.getLong(6)), n, 5);
                    this.xmodelohistorico.setValueAt(Double.valueOf(xrs.getDouble(7)), n, 6);
                    n++;
                }
            }
            xrs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPHistorico_Ingresos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private int mCalculaDias(String xfechaE, String xfechaI) {
        int xdias = 0;
        String sql = "SELECT DATEDIFF('" + xfechaE + "','" + xfechaI + "') AS dias ";
        try {
            ConsultasMySQL xct = new ConsultasMySQL();
            ResultSet xrs = xct.traerRs(sql);
            if (xrs.next()) {
                xrs.first();
                xdias = xrs.getInt("dias");
            }
            xrs.close();
            xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPIngreso.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return xdias;
    }

    private void mIniciarPaneles() {
        this.xEncabezadoOrden = new JPEncabezado_Ordenes(this.xliq);
        this.xEncabezadoOrden.setVisible(false);
        this.JPDatosOrden.setVisible(false);
        this.xEncabezadoOrden.setBounds(1, 1, 780, 160);
        this.JPDatosOrden.add(this.xEncabezadoOrden);
        this.JPDatosOrden.setVisible(true);
        this.xEncabezadoOrden.setVisible(true);
        this.xEncabezadoOrden.JCBTipoServicio.setEnabled(false);
    }

    private void mBuscarOrdenUsuario() {
        String sql = " SELECT  `f_itemordenescamas`.`IdOrdenes` , `f_camas`.`Nbre` AS Cama , f_unidadcama.`Nbre` AS UnidadC,  DATE_FORMAT(f_itemordenescamas.`FechaIngCama`,'%Y-%m-%d %H:%i:%s') AS FechaIngCama, f_itemordenescamas.FechaEgrCama, f_itemordenescamas.NoDias, f_itemordenescamas.ValorCama  FROM `f_itemordenescamas` INNER JOIN `baseserver`.`f_camas` ON (`f_itemordenescamas`.`IdCamas` = `f_camas`.`Id`)  INNER JOIN `baseserver`.`f_ordenes`  ON (`f_itemordenescamas`.`IdOrdenes` = `f_ordenes`.`Id`)  INNER JOIN `f_unidadcama` ON (`f_camas`.`Id_UnidadCamas` = `f_unidadcama`.`Id`) WHERE (`f_ordenes`.`Id_Ingreso` = '" + this.xliq.JLB_NIngreso.getText() + "') ORDER BY `f_itemordenescamas`.`FechaIngCama` DESC";
        try {
            ResultSet xrs = this.xconsulta.traerRs(sql);
            if (xrs.next()) {
                xrs.first();
                this.JDFecha.setDate(xrs.getDate("FechaIngCama"));
                this.JCBCama.setSelectedItem(xrs.getString("Cama"));
                this.JLNoOrden.setText(xrs.getString("IdOrdenes"));
                this.xordenU = xrs.getString("IdOrdenes");
            }
            xrs.close();
            this.xconsulta.cerrarConexionBd();
            mLlenarComboCamaTraslado();
        } catch (SQLException ex) {
            Logger.getLogger(JPEstanciasH.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private double mCalculaTarifaCama(int xprocedimiento) {
        double xvalort = 0.0d;
        try {
            String sql = "SELECT  `Id_Procedimiento` , `Id_Manual` , `VrMinimo` , `VrMaximo` FROM `f_tarifaprocedimiento` WHERE (`Id_Procedimiento` ='" + xprocedimiento + "' AND `Id_Manual` ='" + this.xliq.xIdManual + "');";
            ConsultasMySQL xct = new ConsultasMySQL();
            ResultSet xrs = xct.traerRs(sql);
            if (xrs.next()) {
                xrs.first();
                if (this.xliq.xCValor.equals("0")) {
                    xvalort = ((double) mCalculaDias(this.xmetodo.formatoAMDH24.format(this.JDFechaTraslado.getDate()), this.xmetodo.formatoAMDH24.format(this.JDFecha.getDate()))) * xrs.getDouble("VrMinimo");
                } else {
                    xvalort = ((double) mCalculaDias(this.xmetodo.formatoAMDH24.format(this.JDFechaTraslado.getDate()), this.xmetodo.formatoAMDH24.format(this.JDFecha.getDate()))) * xrs.getDouble("VrMaximo");
                }
            }
            xrs.close();
            xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPEstanciasH.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return xvalort;
    }
}
