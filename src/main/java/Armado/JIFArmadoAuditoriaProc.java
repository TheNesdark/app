package Armado;

import Acceso.Principal;
import Historia.JIFConsultarExamenesxUsuario;
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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
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
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/* JADX INFO: loaded from: GenomaP.jar:Armado/JIFArmadoAuditoriaProc.class */
public class JIFArmadoAuditoriaProc extends JInternalFrame {
    private String[] xidsubgrupo;
    private String[][] xidempresa;
    private String[][] xidservicio;
    private Object[] xdato;
    private String xsql;
    private DefaultTableModel xmodelo;
    private DefaultTableModel xmodelo1;
    private JIFConsultarExamenesxUsuario xjifconsultasexamen;
    private ButtonGroup JBGSeleccion;
    private JComboBox JCBEmpresa;
    private JComboBox JCBGrupo;
    private JComboBox JCBSubGrupo;
    public JDateChooser JDCFechaFin;
    public JDateChooser JDCFechaInicio;
    private JPanel JPEstado;
    private JPanel JPIDatoP;
    private JRadioButton JRBArmada;
    private JRadioButton JRBPresentada;
    private JRadioButton JRBSinArmar;
    private JScrollPane JSPDetalleOrdeFac;
    private JScrollPane JSPResultado;
    private JTable JTBDetalleOrdeFac;
    private JTable JTBResultado;
    private int xllenoc = 0;
    private int xllenocg = 0;
    private int xarmada = 0;
    private Metodos xmt = new Metodos();
    private ConsultasMySQL xct = new ConsultasMySQL();

    public JIFArmadoAuditoriaProc() {
        initComponents();
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v60, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v67, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGSeleccion = new ButtonGroup();
        this.JPIDatoP = new JPanel();
        this.JDCFechaInicio = new JDateChooser();
        this.JDCFechaFin = new JDateChooser();
        this.JCBEmpresa = new JComboBox();
        this.JCBGrupo = new JComboBox();
        this.JCBSubGrupo = new JComboBox();
        this.JPEstado = new JPanel();
        this.JRBSinArmar = new JRadioButton();
        this.JRBArmada = new JRadioButton();
        this.JRBPresentada = new JRadioButton();
        this.JSPResultado = new JScrollPane();
        this.JTBResultado = new JTable();
        this.JSPDetalleOrdeFac = new JScrollPane();
        this.JTBDetalleOrdeFac = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("AUDITORIA Y ARMADO DE FACTURAS DE PROCEDIMIENTOS");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjifauditoriaarmadoproc");
        this.JPIDatoP.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JDCFechaInicio.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicio", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFechaInicio.setDateFormatString("dd/MM/yyyy");
        this.JDCFechaInicio.setFont(new Font("Arial", 1, 12));
        this.JDCFechaInicio.addPropertyChangeListener(new PropertyChangeListener() { // from class: Armado.JIFArmadoAuditoriaProc.1
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFArmadoAuditoriaProc.this.JDCFechaInicioPropertyChange(evt);
            }
        });
        this.JDCFechaFin.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Fin", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFechaFin.setDateFormatString("dd/MM/yyyy");
        this.JDCFechaFin.setFont(new Font("Arial", 1, 12));
        this.JDCFechaFin.addPropertyChangeListener(new PropertyChangeListener() { // from class: Armado.JIFArmadoAuditoriaProc.2
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFArmadoAuditoriaProc.this.JDCFechaFinPropertyChange(evt);
            }
        });
        this.JCBEmpresa.setFont(new Font("Arial", 1, 12));
        this.JCBEmpresa.setBorder(BorderFactory.createTitledBorder((Border) null, "Empresa", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBEmpresa.addItemListener(new ItemListener() { // from class: Armado.JIFArmadoAuditoriaProc.3
            public void itemStateChanged(ItemEvent evt) {
                JIFArmadoAuditoriaProc.this.JCBEmpresaItemStateChanged(evt);
            }
        });
        this.JCBGrupo.setFont(new Font("Arial", 1, 12));
        this.JCBGrupo.setBorder(BorderFactory.createTitledBorder((Border) null, "Grupo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBGrupo.addItemListener(new ItemListener() { // from class: Armado.JIFArmadoAuditoriaProc.4
            public void itemStateChanged(ItemEvent evt) {
                JIFArmadoAuditoriaProc.this.JCBGrupoItemStateChanged(evt);
            }
        });
        this.JCBSubGrupo.setFont(new Font("Arial", 1, 12));
        this.JCBSubGrupo.setBorder(BorderFactory.createTitledBorder((Border) null, "SubGrupo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBSubGrupo.addItemListener(new ItemListener() { // from class: Armado.JIFArmadoAuditoriaProc.5
            public void itemStateChanged(ItemEvent evt) {
                JIFArmadoAuditoriaProc.this.JCBSubGrupoItemStateChanged(evt);
            }
        });
        this.JPEstado.setBorder(BorderFactory.createTitledBorder((Border) null, "Estado", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBGSeleccion.add(this.JRBSinArmar);
        this.JRBSinArmar.setFont(new Font("Arial", 1, 12));
        this.JRBSinArmar.setSelected(true);
        this.JRBSinArmar.setText("Sin Armar");
        this.JRBSinArmar.addActionListener(new ActionListener() { // from class: Armado.JIFArmadoAuditoriaProc.6
            public void actionPerformed(ActionEvent evt) {
                JIFArmadoAuditoriaProc.this.JRBSinArmarActionPerformed(evt);
            }
        });
        this.JBGSeleccion.add(this.JRBArmada);
        this.JRBArmada.setFont(new Font("Arial", 1, 12));
        this.JRBArmada.setText("Armada");
        this.JRBArmada.addActionListener(new ActionListener() { // from class: Armado.JIFArmadoAuditoriaProc.7
            public void actionPerformed(ActionEvent evt) {
                JIFArmadoAuditoriaProc.this.JRBArmadaActionPerformed(evt);
            }
        });
        this.JBGSeleccion.add(this.JRBPresentada);
        this.JRBPresentada.setFont(new Font("Arial", 1, 12));
        this.JRBPresentada.setText("Presentada");
        this.JRBPresentada.addActionListener(new ActionListener() { // from class: Armado.JIFArmadoAuditoriaProc.8
            public void actionPerformed(ActionEvent evt) {
                JIFArmadoAuditoriaProc.this.JRBPresentadaActionPerformed(evt);
            }
        });
        GroupLayout JPEstadoLayout = new GroupLayout(this.JPEstado);
        this.JPEstado.setLayout(JPEstadoLayout);
        JPEstadoLayout.setHorizontalGroup(JPEstadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPEstadoLayout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.JRBSinArmar).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBArmada).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBPresentada)));
        JPEstadoLayout.setVerticalGroup(JPEstadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPEstadoLayout.createSequentialGroup().addContainerGap().addGroup(JPEstadoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBSinArmar).addComponent(this.JRBArmada).addComponent(this.JRBPresentada)).addContainerGap(-1, 32767)));
        GroupLayout JPIDatoPLayout = new GroupLayout(this.JPIDatoP);
        this.JPIDatoP.setLayout(JPIDatoPLayout);
        JPIDatoPLayout.setHorizontalGroup(JPIDatoPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatoPLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatoPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatoPLayout.createSequentialGroup().addComponent(this.JCBGrupo, -2, 368, -2).addGap(18, 18, 18).addComponent(this.JCBSubGrupo, 0, -1, 32767)).addGroup(JPIDatoPLayout.createSequentialGroup().addComponent(this.JDCFechaInicio, -2, 120, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JDCFechaFin, -2, 120, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBEmpresa, -2, 417, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPEstado, -2, -1, -2))).addContainerGap()));
        JPIDatoPLayout.setVerticalGroup(JPIDatoPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatoPLayout.createSequentialGroup().addGroup(JPIDatoPLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JCBEmpresa, -2, 51, -2).addGroup(JPIDatoPLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JDCFechaInicio, -2, 57, -2).addComponent(this.JDCFechaFin, -2, 57, -2)).addComponent(this.JPEstado, -2, -1, -2)).addGap(29, 29, 29).addGroup(JPIDatoPLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBGrupo, -2, 51, -2).addComponent(this.JCBSubGrupo, -2, 51, -2)).addContainerGap(-1, 32767)));
        this.JSPResultado.setBorder(BorderFactory.createTitledBorder((Border) null, "ORDENES O FACTURAS", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JSPResultado.setFont(new Font("Arial", 1, 12));
        this.JTBResultado.setFont(new Font("Arial", 1, 12));
        this.JTBResultado.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTBResultado.setEditingColumn(1);
        this.JTBResultado.setEditingRow(1);
        this.JTBResultado.setRowHeight(25);
        this.JTBResultado.setSelectionBackground(new Color(255, 255, 255));
        this.JTBResultado.setSelectionForeground(Color.red);
        this.JTBResultado.setSelectionMode(0);
        this.JTBResultado.addMouseListener(new MouseAdapter() { // from class: Armado.JIFArmadoAuditoriaProc.9
            public void mouseClicked(MouseEvent evt) {
                JIFArmadoAuditoriaProc.this.JTBResultadoMouseClicked(evt);
            }
        });
        this.JSPResultado.setViewportView(this.JTBResultado);
        this.JSPDetalleOrdeFac.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE ORDEN O FACTURA", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JSPDetalleOrdeFac.setFont(new Font("Arial", 1, 12));
        this.JTBDetalleOrdeFac.setFont(new Font("Arial", 1, 12));
        this.JTBDetalleOrdeFac.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTBDetalleOrdeFac.setEditingColumn(1);
        this.JTBDetalleOrdeFac.setEditingRow(1);
        this.JTBDetalleOrdeFac.setRowHeight(25);
        this.JTBDetalleOrdeFac.setSelectionBackground(new Color(255, 255, 255));
        this.JTBDetalleOrdeFac.setSelectionForeground(Color.red);
        this.JTBDetalleOrdeFac.setSelectionMode(0);
        this.JTBDetalleOrdeFac.addMouseListener(new MouseAdapter() { // from class: Armado.JIFArmadoAuditoriaProc.10
            public void mouseClicked(MouseEvent evt) {
                JIFArmadoAuditoriaProc.this.JTBDetalleOrdeFacMouseClicked(evt);
            }
        });
        this.JSPDetalleOrdeFac.setViewportView(this.JTBDetalleOrdeFac);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JSPDetalleOrdeFac, GroupLayout.Alignment.LEADING).addComponent(this.JSPResultado, GroupLayout.Alignment.LEADING).addComponent(this.JPIDatoP, GroupLayout.Alignment.LEADING, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatoP, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPResultado, -2, 263, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalleOrdeFac, -2, 185, -2).addContainerGap(-1, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBEmpresaItemStateChanged(ItemEvent evt) {
        if (this.xllenoc == 1 && this.JCBEmpresa.getSelectedIndex() != -1) {
            this.JCBGrupo.removeAllItems();
            ConsultasMySQL xct1 = new ConsultasMySQL();
            this.xsql = "SELECT f_gruposervicio.Id_GrupoServicio, f_gruposervicio.Nbre, f_gruposervicio.ConSubGrupo FROM f_subgrupo_empresa INNER JOIN f_subgruposervicio  ON (f_subgrupo_empresa.Id_SubGrupo = f_subgruposervicio.Id_SubgrupoServicio) INNER JOIN f_empresacontxconvenio  ON (f_subgrupo_empresa.Id_Empresa = f_empresacontxconvenio.Id) INNER JOIN f_gruposervicio  ON (f_subgruposervicio.Id_GrupoServicio = f_gruposervicio.Id_GrupoServicio) WHERE (f_subgrupo_empresa.Id_Empresa =" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0] + " AND f_subgrupo_empresa.Estado =1) GROUP BY f_gruposervicio.Id_GrupoServicio ORDER BY f_gruposervicio.Nbre ASC ";
            this.xidservicio = xct1.llenarComboyLista(this.xsql, this.xidservicio, this.JCBGrupo, 3);
            this.JCBGrupo.setSelectedIndex(-1);
            this.xllenocg = 1;
            xct1.cerrarConexionBd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBGrupoItemStateChanged(ItemEvent evt) {
        if (this.xllenocg == 1 && this.JCBGrupo.getSelectedIndex() != -1) {
            this.JCBSubGrupo.removeAllItems();
            ConsultasMySQL xct1 = new ConsultasMySQL();
            this.xsql = "SELECT f_subgrupo_empresa.Id, f_subgruposervicio.Nbre FROM f_subgrupo_empresa INNER JOIN f_subgruposervicio  ON (f_subgrupo_empresa.Id_SubGrupo = f_subgruposervicio.Id_SubgrupoServicio) INNER JOIN f_empresacontxconvenio  ON (f_subgrupo_empresa.Id_Empresa = f_empresacontxconvenio.Id) WHERE (f_subgrupo_empresa.Id_Empresa =" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0] + " AND f_subgrupo_empresa.Estado =1 AND f_subgruposervicio.Id_GrupoServicio ='" + this.xidservicio[this.JCBGrupo.getSelectedIndex()][0] + "') ORDER BY f_subgruposervicio.Nbre ASC ";
            this.xidsubgrupo = xct1.llenarCombo(this.xsql, this.xidsubgrupo, this.JCBSubGrupo);
            xct1.cerrarConexionBd();
            if (this.xidservicio[this.JCBGrupo.getSelectedIndex()][1].equals("1")) {
                this.JCBSubGrupo.setEnabled(true);
                this.JCBSubGrupo.setSelectedIndex(-1);
            } else {
                this.JCBSubGrupo.setEnabled(false);
            }
            this.xllenocg = 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBSubGrupoItemStateChanged(ItemEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBSinArmarActionPerformed(ActionEvent evt) {
        this.xarmada = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBArmadaActionPerformed(ActionEvent evt) {
        this.xarmada = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBPresentadaActionPerformed(ActionEvent evt) {
        this.xarmada = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBResultadoMouseClicked(MouseEvent evt) {
        if (this.JTBResultado.getSelectedRow() != -1 && this.JTBResultado.getSelectedColumn() != 12) {
            Object[] botones = {"Impresión Factura", "Historia Clinica", "Cargar Detalle", "Cerrar"};
            int n = JOptionPane.showOptionDialog(this, "Que desea hacer?", "Consultar", 0, 3, (Icon) null, botones, "Cerrar");
            if (n == 0) {
                Principal.xclasegc.imprimir_FacturayOrden(1, this.xmodelo.getValueAt(this.JTBResultado.getSelectedRow(), 0).toString(), this.xmodelo.getValueAt(this.JTBResultado.getSelectedRow(), 13).toString(), Principal.usuarioSistemaDTO.getLogin(), Integer.valueOf(this.xidempresa[this.JCBEmpresa.getSelectedIndex()][1]).intValue(), 1, this.xidempresa[this.JCBEmpresa.getSelectedIndex()][3], 0);
                return;
            }
            if (n == 1) {
                Principal.xclasegc.cargarPantalla("Gestion Hc");
                Principal.xclasegc.xjifconsutlarhc.xgestiodoc.xjppersona.txtHistoria.setText(this.xmodelo.getValueAt(this.JTBResultado.getSelectedRow(), 2).toString());
                Principal.xclasegc.xjifconsutlarhc.xgestiodoc.xjppersona.buscar(2);
                Principal.xclasegc.xjifconsutlarhc.xgestiodoc.mBuscar();
                return;
            }
            if (n == 2) {
                mCargarDatosDetalle();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBDetalleOrdeFacMouseClicked(MouseEvent evt) {
        if (this.JTBDetalleOrdeFac.getSelectedRow() == -1 || this.JTBDetalleOrdeFac.getSelectedColumn() != 0) {
            if (this.JTBDetalleOrdeFac.getSelectedRow() != -1 && this.JTBDetalleOrdeFac.getSelectedColumn() == 1) {
                Object[] botones = {"Ayudas Dx", "Cerrar"};
                if (JOptionPane.showInternalOptionDialog(this, "Que desea hacer", "IMPRIMIR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), botones, "Cerrar") == 0) {
                    this.xsql = "SELECT NArchivo  FROM l_detallerecepcion WHERE (Id_Recepcion ='" + this.xmodelo1.getValueAt(this.JTBDetalleOrdeFac.getSelectedRow(), 4).toString() + "' AND Id_Procedim ='" + this.xmodelo1.getValueAt(this.JTBDetalleOrdeFac.getSelectedRow(), 0).toString() + "'  AND NArchivo <>'') ";
                    ResultSet xrs = this.xct.traerRs(this.xsql);
                    try {
                        if (xrs.next()) {
                            xrs.first();
                            this.xmt.mostrarPdf(xrs.getString(1));
                            xrs.close();
                            this.xct.cerrarConexionBd();
                        } else {
                            Principal.xclasegc.cargarPantalla("Gestion Ayudas Dx");
                            Principal.xclasegc.xjifconsultaradx.xjppersona.txtHistoria.setText(this.xmodelo.getValueAt(this.JTBResultado.getSelectedRow(), 2).toString());
                            Principal.xclasegc.xjifconsultaradx.xjppersona.buscar(2);
                        }
                        xrs.close();
                        this.xct.cerrarConexionBd();
                        return;
                    } catch (SQLException ex) {
                        Logger.getLogger(JIFArmadoAuditoriaProc.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                        return;
                    }
                }
                return;
            }
            return;
        }
        if (Long.valueOf(this.xmodelo1.getValueAt(this.JTBDetalleOrdeFac.getSelectedRow(), 4).toString()).longValue() > 0 && !Boolean.valueOf(this.xmodelo1.getValueAt(this.JTBDetalleOrdeFac.getSelectedRow(), 6).toString()).booleanValue()) {
            if (Principal.informacionIps.getEsFpz().intValue() == 0) {
                String[][] parametros1 = new String[3][2];
                parametros1[0][0] = "id";
                parametros1[0][1] = this.xmodelo1.getValueAt(this.JTBDetalleOrdeFac.getSelectedRow(), 4).toString();
                parametros1[1][0] = "SUBREPORT_DIR";
                parametros1[1][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
                parametros1[2][0] = "SUBREPORTFIRMA_DIR";
                parametros1[2][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
                this.xmt.GenerarPDF(this.xmt.getRutaRep() + "L_Resultados", parametros1);
                return;
            }
            Object[] botones2 = {"Formato PreImpreso", "Normal", "Cerrar"};
            int n = JOptionPane.showInternalOptionDialog(this, "Que desea hacer", "IMPRIMIR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), botones2, "Cerrar");
            String[][] parametros = new String[4][2];
            if (n == 0) {
                parametros[0][0] = "id";
                parametros[0][1] = this.xmodelo1.getValueAt(this.JTBDetalleOrdeFac.getSelectedRow(), 4).toString();
                parametros[1][0] = "xagregar";
                parametros[1][1] = "0";
                parametros[2][0] = "SUBREPORT_DIR";
                parametros[2][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
                parametros[3][0] = "SUBREPORTFIRMA_DIR";
                parametros[3][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
                if (Principal.informacionIps.getFormaImpresionReporte().intValue() == 0) {
                    if (Principal.informacionIps.getNombreIps().equals("LABORATORIO CLINICO VIVIAN RAMIREZ I.P.S. S.A.")) {
                        this.xmt.GenerarPDF(this.xmt.getRutaRep() + "L_Resultados_Id_N1_Texto1_Chinu", parametros);
                    } else {
                        this.xmt.GenerarPDF(this.xmt.getRutaRep() + "L_Resultados_Id_N1_Texto", parametros);
                    }
                } else if (Principal.informacionIps.getFormaImpresionReporte().intValue() == 1) {
                    if (Principal.informacionIps.getNombreIps().equals("LABORATORIO CLINICO VIVIAN RAMIREZ I.P.S. S.A.")) {
                        this.xmt.GenerarPDF(this.xmt.getRutaRep() + "L_Resultados_Id_N1_Texto1_Chinu", parametros);
                    } else {
                        this.xmt.GenerarPDF(this.xmt.getRutaRep() + "L_Resultados_Id_N1_Texto", parametros);
                    }
                } else if (Principal.informacionIps.getFormaImpresionReporte().intValue() == 2) {
                    if (Principal.informacionIps.getNombreIps().equals("LABORATORIO CLINICO VIVIAN RAMIREZ I.P.S. S.A.")) {
                        this.xmt.GenerarPDF(this.xmt.getRutaRep() + "L_Resultados_Id_N1_Texto1_Chinu", parametros);
                    } else {
                        this.xmt.GenerarPDF(this.xmt.getRutaRep() + "L_Resultados_Id_N1_Texto1", parametros);
                    }
                }
                this.xct.cerrarConexionBd();
                return;
            }
            if (n == 1) {
                parametros[0][0] = "id";
                parametros[0][1] = this.xmodelo1.getValueAt(this.JTBDetalleOrdeFac.getSelectedRow(), 4).toString();
                parametros[1][0] = "idp";
                parametros[1][1] = "";
                parametros[2][0] = "SUBREPORT_DIR";
                parametros[2][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
                parametros[3][0] = "SUBREPORTFIRMA_DIR";
                parametros[3][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
                if (Principal.informacionIps.getFormaImpresionReporte().intValue() == 0) {
                    if (Principal.informacionIps.getNombreIps().equals("LABORATORIO CLINICO VIVIAN RAMIREZ I.P.S. S.A.")) {
                        this.xmt.GenerarPDF(this.xmt.getRutaRep() + "L_Resultados_Id_N2_Chinu", parametros);
                    } else {
                        this.xmt.GenerarPDF(this.xmt.getRutaRep() + "L_Resultados_Id_N2", parametros);
                    }
                } else if (Principal.informacionIps.getFormaImpresionReporte().intValue() == 1) {
                    if (Principal.informacionIps.getNombreIps().equals("LABORATORIO CLINICO VIVIAN RAMIREZ I.P.S. S.A.")) {
                        this.xmt.GenerarPDF(this.xmt.getRutaRep() + "L_Resultados_Id_N2_Chinu", parametros);
                    } else {
                        this.xmt.GenerarPDF(this.xmt.getRutaRep() + "L_Resultados_Id_N1", parametros);
                    }
                } else if (Principal.informacionIps.getFormaImpresionReporte().intValue() == 2) {
                    if (Principal.informacionIps.getNombreIps().equals("LABORATORIO CLINICO VIVIAN RAMIREZ I.P.S. S.A.")) {
                        this.xmt.GenerarPDF(this.xmt.getRutaRep() + "L_Resultados_Id_N2_Chinu", parametros);
                    } else {
                        this.xmt.GenerarPDF(this.xmt.getRutaRep() + "L_Resultados_Id_N2", parametros);
                    }
                }
                this.xct.cerrarConexionBd();
                return;
            }
            return;
        }
        this.xjifconsultasexamen = new JIFConsultarExamenesxUsuario("xjifconsexamenlab", this.xmodelo.getValueAt(this.JTBResultado.getSelectedRow(), 2).toString());
        Principal.cargarPantalla(this.xjifconsultasexamen);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDCFechaInicioPropertyChange(PropertyChangeEvent evt) {
        if (this.xllenoc == 1) {
            mLLenarCEmpresa();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDCFechaFinPropertyChange(PropertyChangeEvent evt) {
        if (this.xllenoc == 1) {
            mLLenarCEmpresa();
        }
    }

    private void mLLenarCEmpresa() {
        this.xllenoc = 0;
        this.xllenocg = 0;
        this.JCBSubGrupo.removeAllItems();
        this.JCBGrupo.removeAllItems();
        this.JCBEmpresa.removeAllItems();
        this.xsql = "SELECT  `f_empresacontxconvenio`.`Id` ,`f_empresacontxconvenio`.`Nbre` , `f_empresacontxconvenio`.`EsCapitado`, g_empresacont.Id_TipoPlan, g_ips.`Nbre` FROM `ingreso` INNER JOIN  `f_liquidacion`  ON (`ingreso`.`Id` = `f_liquidacion`.`Id_Ingreso`) INNER JOIN  `f_empresacontxconvenio`  ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`) INNER JOIN  `g_empresacont`  ON (`g_empresacont`.`Id_empresa` = `f_empresacontxconvenio`.`Id_EmpresaCont`)  INNER JOIN g_ips  ON (f_empresacontxconvenio.`Id_GIps` = g_ips.`Id`)  WHERE (`ingreso`.`FechaIngreso` >='" + this.xmt.formatoAMD.format(this.JDCFechaInicio.getDate()) + "' AND `ingreso`.`FechaIngreso` <='" + this.xmt.formatoAMD.format(this.JDCFechaFin.getDate()) + "' AND `f_liquidacion`.`Estado`=0  and `f_empresacontxconvenio`.EsCapitado<>1) GROUP BY `f_empresacontxconvenio`.`Id` ORDER BY `f_empresacontxconvenio`.`Nbre` ASC ";
        this.xidempresa = this.xct.llenarComboyLista(this.xsql, this.xidempresa, this.JCBEmpresa, 5);
        this.xct.cerrarConexionBd();
        this.JCBEmpresa.setSelectedIndex(-1);
        this.JCBSubGrupo.setEnabled(false);
        mCrearTablaDetalle();
        this.xllenoc = 1;
        this.JCBEmpresa.requestFocus();
    }

    public void mNuevo() {
        this.JDCFechaInicio.setDate(this.xmt.getFechaActual());
        this.JDCFechaFin.setDate(this.xmt.getFechaActual());
        this.JCBSubGrupo.setEnabled(false);
        mCrearTablaDetalle();
        mCrearTablaDetalle1();
        mLLenarCEmpresa();
    }

    private void mCrearTablaDetalle() {
        this.xmodelo = new DefaultTableModel() { // from class: Armado.JIFArmadoAuditoriaProc.11
            Class[] types = {Long.class, String.class, String.class, String.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Long.class, Long.class, Boolean.class, Long.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, true, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return this.canEdit[colIndex];
            }
        };
        this.xmodelo.addColumn("N°Orden/Factura");
        this.xmodelo.addColumn("Fecha");
        this.xmodelo.addColumn("NHC");
        this.xmodelo.addColumn("Usuario");
        this.xmodelo.addColumn("V/Servicio");
        this.xmodelo.addColumn("V/Plan");
        this.xmodelo.addColumn("V/Eps");
        this.xmodelo.addColumn("V/Descuento");
        this.xmodelo.addColumn("V/Usuario");
        this.xmodelo.addColumn("V/Copago o CModerado");
        this.xmodelo.addColumn("IdOrden");
        this.xmodelo.addColumn("IdUsuario");
        this.xmodelo.addColumn("Armar?");
        this.xmodelo.addColumn("IdIngreso");
        this.xmodelo.addColumn("Login");
        TableRowSorter<TableModel> elQueOrdena = new TableRowSorter<>(this.xmodelo);
        this.JTBResultado.setRowSorter(elQueOrdena);
        JTable jTable = this.JTBResultado;
        JTable jTable2 = this.JTBResultado;
        jTable.setAutoResizeMode(0);
        this.JTBResultado.doLayout();
        this.JTBResultado.setModel(this.xmodelo);
        this.JTBResultado.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTBResultado.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTBResultado.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTBResultado.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTBResultado.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTBResultado.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTBResultado.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTBResultado.getColumnModel().getColumn(7).setPreferredWidth(100);
        this.JTBResultado.getColumnModel().getColumn(8).setPreferredWidth(100);
        this.JTBResultado.getColumnModel().getColumn(9).setPreferredWidth(100);
        this.JTBResultado.getColumnModel().getColumn(10).setPreferredWidth(0);
        this.JTBResultado.getColumnModel().getColumn(10).setMinWidth(0);
        this.JTBResultado.getColumnModel().getColumn(10).setMaxWidth(0);
        this.JTBResultado.getColumnModel().getColumn(11).setPreferredWidth(0);
        this.JTBResultado.getColumnModel().getColumn(11).setMinWidth(0);
        this.JTBResultado.getColumnModel().getColumn(11).setMaxWidth(0);
        this.JTBResultado.getColumnModel().getColumn(12).setPreferredWidth(100);
        this.JTBResultado.getColumnModel().getColumn(13).setPreferredWidth(0);
        this.JTBResultado.getColumnModel().getColumn(13).setMinWidth(0);
        this.JTBResultado.getColumnModel().getColumn(13).setMaxWidth(0);
        this.JTBResultado.getColumnModel().getColumn(14).setPreferredWidth(100);
        this.JTBResultado.setModel(this.xmodelo);
    }

    private void mCrearTablaDetalle1() {
        this.xmodelo1 = new DefaultTableModel((Object[][]) null, new String[]{"Código", "Procedimiento", "Cantidad", "Resultado?", "IdRecepcion", "IdResultado", "Remitido?"}) { // from class: Armado.JIFArmadoAuditoriaProc.12
            Class[] types = {Long.class, String.class, Long.class, Boolean.class, Long.class, Long.class, Boolean.class};
            boolean[] canEdit = {false, true, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTBDetalleOrdeFac.setModel(this.xmodelo1);
        this.JTBDetalleOrdeFac.getColumnModel().getColumn(0).setPreferredWidth(30);
        this.JTBDetalleOrdeFac.getColumnModel().getColumn(1).setPreferredWidth(500);
        this.JTBDetalleOrdeFac.getColumnModel().getColumn(2).setPreferredWidth(20);
        this.JTBDetalleOrdeFac.getColumnModel().getColumn(3).setPreferredWidth(30);
        this.JTBDetalleOrdeFac.getColumnModel().getColumn(4).setPreferredWidth(0);
        this.JTBDetalleOrdeFac.getColumnModel().getColumn(4).setMinWidth(0);
        this.JTBDetalleOrdeFac.getColumnModel().getColumn(4).setMaxWidth(0);
        this.JTBDetalleOrdeFac.getColumnModel().getColumn(5).setPreferredWidth(0);
        this.JTBDetalleOrdeFac.getColumnModel().getColumn(5).setMinWidth(0);
        this.JTBDetalleOrdeFac.getColumnModel().getColumn(5).setMaxWidth(0);
        this.JTBDetalleOrdeFac.getColumnModel().getColumn(6).setPreferredWidth(30);
    }

    public void mBuscar() {
        if (this.JCBEmpresa.getSelectedIndex() != -1) {
            if (this.JCBGrupo.getSelectedIndex() != -1) {
                mCargarDatosFactura();
                mCrearTablaDetalle1();
                return;
            } else {
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un grupo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JCBGrupo.requestFocus();
                return;
            }
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una empresa", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JCBEmpresa.requestFocus();
    }

    private void mCargarDatosFactura() {
        mCrearTablaDetalle();
        if (this.xidempresa[this.JCBEmpresa.getSelectedIndex()][1].equals("2")) {
            this.xsql = "SELECT CONCAT(f_factura_evento.Prefijo ,'',f_factura_evento.No_Facturaevento_M), DATE_FORMAT(f_factura_evento.Fecha_FacturaEvento,'%d-%m-%Y') AS FechaF,persona.NoHistoria, persona.NUsuario, f_liquidacion.TotalServicio, f_liquidacion.TotalPlan, f_liquidacion.TotalEps , f_liquidacion.TotalDescuento, f_liquidacion.TotalPaciente, (f_liquidacion.CuotaModeradora + f_liquidacion.Copago)  AS VCMD, f_ordenes.Id, persona.Id_persona, ingreso.Id, IF(f_factura_evento.EstaArmada=0,FALSE, TRUE) EstaArmada, f_liquidacion.UsuarioS  FROM f_factura_evento INNER JOIN f_liquidacion  ON (f_factura_evento.Id_Liquidacion = f_liquidacion.Id) INNER JOIN ingreso  ON (ingreso.Id = f_liquidacion.Id_Ingreso) INNER JOIN f_ordenes  ON (f_ordenes.Id_Ingreso = ingreso.Id) INNER JOIN persona  ON (ingreso.Id_Usuario = persona.Id_persona) INNER JOIN f_itemordenesproced  ON (f_itemordenesproced.Id_Ordenes = f_ordenes.Id)  WHERE (f_factura_evento.Fecha_FacturaEvento >='" + this.xmt.formatoAMD.format(this.JDCFechaInicio.getDate()) + "' AND f_factura_evento.Fecha_FacturaEvento <='" + this.xmt.formatoAMD.format(this.JDCFechaFin.getDate()) + "' AND f_liquidacion.Id_SubGrupoServicio ='" + this.xidsubgrupo[this.JCBSubGrupo.getSelectedIndex()] + "' AND ingreso.Id_EmpresaContxConv ='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0] + "' AND f_liquidacion.Estado =0 AND f_ordenes.Estado =0 and f_factura_evento.EstaArmada='" + this.xarmada + "') GROUP BY f_factura_evento.No_FacturaEvento ORDER BY FechaF ASC, persona.NUsuario ASC   ";
        } else {
            this.xsql = "SELECT f_factura_capita.No_FacturaCapita, DATE_FORMAT(f_factura_capita.Fecha_FacturaCapita,'%d-%m-%Y') AS FechaF, persona.NoHistoria, persona.NUsuario, f_liquidacion.TotalServicio, f_liquidacion.TotalPlan, f_liquidacion.TotalEps , f_liquidacion.TotalDescuento, f_liquidacion.TotalPaciente, (f_liquidacion.CuotaModeradora + f_liquidacion.Copago)  AS VCMD, f_ordenes.Id, persona.Id_persona, ingreso.Id, IF(f_factura_capita.EstaArmada=0,FALSE, TRUE) EstaArmada, f_liquidacion.UsuarioS FROM f_factura_capita INNER JOIN f_liquidacion  ON (f_factura_capita.Id_Liquidacion = f_liquidacion.Id) INNER JOIN ingreso  ON (ingreso.Id = f_liquidacion.Id_Ingreso) INNER JOIN f_ordenes  ON (f_ordenes.Id_Ingreso = ingreso.Id) INNER JOIN persona  ON (ingreso.Id_Usuario = persona.Id_persona) INNER JOIN f_itemordenesproced  ON (f_itemordenesproced.Id_Ordenes = f_ordenes.Id) WHERE (f_factura_capita.Fecha_FacturaCapita >='" + this.xmt.formatoAMD.format(this.JDCFechaInicio.getDate()) + "' AND f_factura_capita.Fecha_FacturaCapita <='" + this.xmt.formatoAMD.format(this.JDCFechaFin.getDate()) + "' AND f_liquidacion.Id_SubGrupoServicio ='" + this.xidsubgrupo[this.JCBSubGrupo.getSelectedIndex()] + "' AND ingreso.Id_EmpresaContxConv ='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0] + "' AND f_liquidacion.Estado =0 AND f_ordenes.Estado =0 and f_factura_capita.EstaArmada='" + this.xarmada + "') GROUP BY f_factura_capita.No_FacturaCapita ORDER BY FechaF ASC, persona.NUsuario ASC";
        }
        ResultSet xrs = this.xct.traerRs(this.xsql);
        try {
            if (xrs.next()) {
                xrs.beforeFirst();
                int x = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(1)), x, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), x, 1);
                    this.xmodelo.setValueAt(xrs.getString(3), x, 2);
                    this.xmodelo.setValueAt(xrs.getString(4), x, 3);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(5)), x, 4);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(6)), x, 5);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(7)), x, 6);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(8)), x, 7);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(9)), x, 8);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(10)), x, 9);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(11)), x, 10);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(12)), x, 11);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(14)), x, 12);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(13)), x, 13);
                    this.xmodelo.setValueAt(xrs.getString(15), x, 14);
                    x++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFArmadoAuditoriaProc.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarDatosDetalle() {
        mCrearTablaDetalle1();
        if (this.xidempresa[this.JCBEmpresa.getSelectedIndex()][1].equals("2")) {
            this.xsql = "SELECT g_procedimiento.Id, g_procedimiento.Nbre, f_itemordenesproced.Cantidad, IF(f_itemordenesproced.Id_ResultadoLab>0, TRUE, FALSE)AS TResultado, f_ordenes.Id_OrdenRecep, f_itemordenesproced.Id_ResultadoLab, g_procedimiento.EsRemitido  FROM f_factura_evento INNER JOIN f_liquidacion  ON (f_factura_evento.Id_Liquidacion = f_liquidacion.Id) INNER JOIN ingreso  ON (ingreso.Id = f_liquidacion.Id_Ingreso)  INNER JOIN f_ordenes  ON (f_ordenes.Id_Ingreso = ingreso.Id) INNER JOIN f_itemordenesproced ON (f_itemordenesproced.Id_Ordenes = f_ordenes.Id) INNER JOIN g_procedimiento  ON (f_itemordenesproced.Id_Procedimiento = g_procedimiento.Id)   WHERE (f_factura_evento.No_FacturaEvento='" + this.JTBResultado.getValueAt(this.JTBResultado.getSelectedRow(), 0) + "') ORDER BY g_procedimiento.Nbre ";
        } else {
            this.xsql = "SELECT g_procedimiento.Id, g_procedimiento.Nbre, f_itemordenesproced.Cantidad, IF(f_itemordenesproced.Id_ResultadoLab>0, TRUE, FALSE)AS TResultado, f_ordenes.Id_OrdenRecep, f_itemordenesproced.Id_ResultadoLab, g_procedimiento.EsRemitido FROM f_factura_capita INNER JOIN f_liquidacion  ON (f_factura_capita.Id_Liquidacion = f_liquidacion.Id) INNER JOIN ingreso  ON (ingreso.Id = f_liquidacion.Id_Ingreso) INNER JOIN f_ordenes  ON (f_ordenes.Id_Ingreso = ingreso.Id) INNER JOIN f_itemordenesproced ON (f_itemordenesproced.Id_Ordenes = f_ordenes.Id) INNER JOIN g_procedimiento  ON (f_itemordenesproced.Id_Procedimiento = g_procedimiento.Id)  WHERE (f_factura_capita.No_FacturaCapita ='" + this.JTBResultado.getValueAt(this.JTBResultado.getSelectedRow(), 0) + "') order by g_procedimiento.Nbre ";
        }
        ResultSet xrs = this.xct.traerRs(this.xsql);
        try {
            if (xrs.next()) {
                xrs.beforeFirst();
                int x = 0;
                while (xrs.next()) {
                    this.xmodelo1.addRow(this.xdato);
                    this.xmodelo1.setValueAt(Long.valueOf(xrs.getLong(1)), x, 0);
                    this.xmodelo1.setValueAt(xrs.getString(2), x, 1);
                    this.xmodelo1.setValueAt(Long.valueOf(xrs.getLong(3)), x, 2);
                    this.xmodelo1.setValueAt(Boolean.valueOf(xrs.getBoolean(4)), x, 3);
                    this.xmodelo1.setValueAt(Long.valueOf(xrs.getLong(5)), x, 4);
                    this.xmodelo1.setValueAt(Long.valueOf(xrs.getLong(6)), x, 5);
                    this.xmodelo1.setValueAt(Boolean.valueOf(xrs.getBoolean(7)), x, 6);
                    x++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFArmadoAuditoriaProc.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mGrabar() {
        if (this.xarmada == 0) {
            if (this.JTBResultado.getRowCount() != -1) {
                if (this.xmt.mVerificarDatosTablaTrue(this.JTBResultado, 12)) {
                    for (int i = 0; i < this.JTBResultado.getRowCount(); i++) {
                        if (this.JTBResultado.getValueAt(i, 12).toString().equals("true")) {
                            if (this.xidempresa[this.JCBEmpresa.getSelectedIndex()][1].equals("2")) {
                                this.xsql = "Update f_factura_evento set EstaArmada=1 where No_FacturaEvento_M='" + this.JTBResultado.getValueAt(i, 0) + "'";
                            } else {
                                this.xsql = "Update f_factura_capita set EstaArmada=1 where No_FacturaCapita='" + this.JTBResultado.getValueAt(i, 0) + "'";
                            }
                            this.xct.ejecutarSQL(this.xsql);
                            this.xct.cerrarConexionBd();
                        }
                    }
                    mCargarDatosFactura();
                    mCrearTablaDetalle1();
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "No existe registro seleccionado para grabar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "No existe registro para grabar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        }
    }

    public void mAnular() {
        if (this.xarmada == 1) {
            for (int i = 0; i < this.JTBResultado.getRowCount(); i++) {
                if (this.JTBResultado.getValueAt(i, 12).toString().equals("false")) {
                    if (this.xidempresa[this.JCBEmpresa.getSelectedIndex()][1].equals("2")) {
                        this.xsql = "Update baseserver.f_factura_evento set EstaArmada=0 where No_FacturaEvento='" + this.JTBResultado.getValueAt(i, 0) + "'";
                    } else {
                        this.xsql = "Update baseserver.f_factura_capita set EstaArmada=0 where No_FacturaCapita='" + this.JTBResultado.getValueAt(i, 0) + "'";
                    }
                    this.xct.ejecutarSQL(this.xsql);
                    this.xct.cerrarConexionBd();
                }
            }
            mCargarDatosFactura();
            mCrearTablaDetalle1();
        }
    }
}
