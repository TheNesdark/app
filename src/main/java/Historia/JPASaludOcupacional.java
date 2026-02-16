package Historia;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import Utilidades.TextAreaEditor;
import Utilidades.TextAreaRenderer;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/* JADX INFO: loaded from: GenomaP.jar:Historia/JPASaludOcupacional.class */
public class JPASaludOcupacional extends JPanel {
    private GregorianCalendar hoyaux;
    public ResultSet rsi;
    public String sql;
    public String xnombre;
    public DefaultTableModel xmodelo;
    public DefaultTableModel xmodeloh;
    private Object[] xdatos;
    private clasesHistoriaCE xclase;
    private ButtonGroup JBGProrroga;
    private ButtonGroup JBGTipoIncapacidad;
    private JButton JBGrabarRes;
    private JScrollPane JSPHistorico;
    private JScrollPane JSPPreguntasTrabajador;
    public JTable JTDetalleHistorico;
    public JTable JTDetallePreguntasT;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JTabbedPane jTabbedPane1;
    private int lleno = 0;
    private int xtipoincapacidad = 0;
    private int prorroga = 0;
    private GregorianCalendar hoy = new GregorianCalendar();
    Runtime obj = Runtime.getRuntime();
    private ConsultasMySQL xconsultasbd = new ConsultasMySQL();
    private Metodos xmetodo = new Metodos();

    public JPASaludOcupacional() {
        initComponents();
        mCargarDatosTabla();
        mVerificarEncuesta();
        mCargarDatosTablaHistorico();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Nombre", "Respuesta", "Observación", "TipoR"}) { // from class: Historia.JPASaludOcupacional.1
            Class[] types = {Long.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetallePreguntasT.setModel(this.xmodelo);
        this.JTDetallePreguntasT.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTDetallePreguntasT.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTDetallePreguntasT.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTDetallePreguntasT.getColumnModel().getColumn(1).setPreferredWidth(250);
        this.JTDetallePreguntasT.getColumnModel().getColumn(2).setPreferredWidth(30);
        this.JTDetallePreguntasT.getColumnModel().getColumn(3).setPreferredWidth(30);
        this.JTDetallePreguntasT.getColumnModel().getColumn(4).setPreferredWidth(0);
        this.JTDetallePreguntasT.getColumnModel().getColumn(4).setMinWidth(0);
        this.JTDetallePreguntasT.getColumnModel().getColumn(4).setMaxWidth(0);
    }

    private void mCargarDatosTabla() {
        try {
            mCrearModeloDatos();
            ResultSet xrs = this.xconsultasbd.traerRs("SELECT`Id` , `Nbre`, `TipoRespuesta` FROM `h_so_preguntas_detalle` WHERE (`Estado` =1) ORDER BY `Orden` ASC");
            TableColumnModel cmodel = this.JTDetallePreguntasT.getColumnModel();
            TextAreaRenderer textAreaRenderer = new TextAreaRenderer();
            cmodel.getColumn(3).setCellRenderer(textAreaRenderer);
            TextAreaEditor textEditor = new TextAreaEditor();
            cmodel.getColumn(3).setCellEditor(textEditor);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(1)), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt("", n, 2);
                    this.xmodelo.setValueAt("", n, 3);
                    this.xmodelo.setValueAt(xrs.getString(3), n, 4);
                    n++;
                }
            }
            xrs.close();
            this.xconsultasbd.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPASaludOcupacional.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mConsultarResultados() {
        try {
            mCrearModeloDatos();
            ResultSet xrs = this.xconsultasbd.traerRs("SELECT`Id` , `Nbre`, `TipoRespuesta` FROM `h_so_preguntas_detalle` WHERE (`Estado` =1) ORDER BY `Orden` ASC");
            TableColumnModel cmodel = this.JTDetallePreguntasT.getColumnModel();
            TextAreaRenderer textAreaRenderer = new TextAreaRenderer();
            cmodel.getColumn(3).setCellRenderer(textAreaRenderer);
            TextAreaEditor textEditor = new TextAreaEditor();
            cmodel.getColumn(3).setCellEditor(textEditor);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(1)), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt("", n, 2);
                    this.xmodelo.setValueAt("", n, 3);
                    this.xmodelo.setValueAt(xrs.getString(3), n, 4);
                    n++;
                }
            }
            xrs.close();
            this.xconsultasbd.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPASaludOcupacional.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mImprimir() {
        String[][] mparametros = new String[3][2];
        mparametros[0][0] = "idatencion1";
        mparametros[0][1] = this.xmodeloh.getValueAt(this.JTDetalleHistorico.getSelectedRow(), 0).toString();
        mparametros[1][0] = "SUBREPORT_DIR";
        mparametros[1][1] = this.xmetodo.getSO() + this.xmetodo.getBarra() + "Reportes" + this.xmetodo.getBarra();
        mparametros[2][0] = "SUBREPORTFIRMA_DIR";
        mparametros[2][1] = this.xmetodo.getSO() + this.xmetodo.getBarra() + "Firmas" + this.xmetodo.getBarra();
        this.xmetodo.GenerarPDF(this.xmetodo.getRutaRep() + "H_HistoriaClinicaSO", mparametros);
    }

    /* JADX WARN: Type inference failed for: r3v27, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v6, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGTipoIncapacidad = new ButtonGroup();
        this.JBGProrroga = new ButtonGroup();
        this.jTabbedPane1 = new JTabbedPane();
        this.jPanel1 = new JPanel();
        this.JSPPreguntasTrabajador = new JScrollPane();
        this.JTDetallePreguntasT = new JTable();
        this.JBGrabarRes = new JButton();
        this.jPanel2 = new JPanel();
        this.JSPHistorico = new JScrollPane();
        this.JTDetalleHistorico = new JTable();
        setBorder(BorderFactory.createTitledBorder((Border) null, "CUESTIONARIO PARA TRABAJADORES EN ALTURAS", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        setName("jpsaludocupacional");
        this.jTabbedPane1.setForeground(new Color(255, 0, 0));
        this.jTabbedPane1.setFont(new Font("Arial", 1, 12));
        this.JSPPreguntasTrabajador.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS PARA SER DILIGENCIADO POR EL TRABAJADOR", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTDetallePreguntasT.setFont(new Font("Arial", 1, 12));
        this.JTDetallePreguntasT.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetallePreguntasT.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetallePreguntasT.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetallePreguntasT.addMouseListener(new MouseAdapter() { // from class: Historia.JPASaludOcupacional.2
            public void mouseClicked(MouseEvent evt) {
                JPASaludOcupacional.this.JTDetallePreguntasTMouseClicked(evt);
            }
        });
        this.JSPPreguntasTrabajador.setViewportView(this.JTDetallePreguntasT);
        this.JBGrabarRes.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Grabar29x27.png")));
        this.JBGrabarRes.setText("Grabar");
        this.JBGrabarRes.addActionListener(new ActionListener() { // from class: Historia.JPASaludOcupacional.3
            public void actionPerformed(ActionEvent evt) {
                JPASaludOcupacional.this.JBGrabarResActionPerformed(evt);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JBGrabarRes, -1, -1, 32767).addComponent(this.JSPPreguntasTrabajador, -1, 774, 32767)).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.JSPPreguntasTrabajador, -2, 300, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBGrabarRes, -2, 45, -2).addContainerGap(134, 32767)));
        this.jTabbedPane1.addTab("DATOS TRABAJADOR", this.jPanel1);
        this.JSPHistorico.setBorder(BorderFactory.createTitledBorder((Border) null, "", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTDetalleHistorico.setFont(new Font("Arial", 1, 12));
        this.JTDetalleHistorico.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalleHistorico.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalleHistorico.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalleHistorico.addMouseListener(new MouseAdapter() { // from class: Historia.JPASaludOcupacional.4
            public void mouseClicked(MouseEvent evt) {
                JPASaludOcupacional.this.JTDetalleHistoricoMouseClicked(evt);
            }
        });
        this.JSPHistorico.setViewportView(this.JTDetalleHistorico);
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(this.JSPHistorico, -1, 774, 32767).addContainerGap()));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(this.JSPHistorico, -2, 289, -2).addContainerGap(201, 32767)));
        this.jTabbedPane1.addTab("HISTÓRICO", this.jPanel2);
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jTabbedPane1).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGap(0, 0, 0).addComponent(this.jTabbedPane1).addContainerGap()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetallePreguntasTMouseClicked(MouseEvent evt) {
        if (this.JTDetallePreguntasT.getSelectedColumn() == 2) {
            if (this.xmodelo.getValueAt(this.JTDetallePreguntasT.getSelectedRow(), 4).equals("4")) {
                mCargarTipoResultadoD(2);
                return;
            }
            JDRespuestaSO xjdrespuestaSO = new JDRespuestaSO(Principal.clasehistoriace.frmPrincipal, true, this.xmodelo.getValueAt(this.JTDetallePreguntasT.getSelectedRow(), 4).toString(), this);
            xjdrespuestaSO.setLocationRelativeTo(Principal.clasehistoriace.frmPrincipal);
            xjdrespuestaSO.setVisible(true);
            return;
        }
        if (this.JTDetallePreguntasT.getSelectedColumn() == 3) {
            mCargarTipoResultadoD(3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBGrabarResActionPerformed(ActionEvent evt) {
        mGrabarRespuestas();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleHistoricoMouseClicked(MouseEvent evt) {
        if (this.JTDetalleHistorico.getSelectedRow() != -1 && evt.getClickCount() == 2) {
            mImprimir();
        }
    }

    private void mCargarTipoResultadoD(int xcoluma) {
        JDResultadoDescriptivoSO frmDES = new JDResultadoDescriptivoSO(null, true, "jpsaludocupacional", xcoluma, this);
        frmDES.setVisible(true);
    }

    public void mGrabarRespuestas() {
        if (!this.xmetodo.mVerificarDatosLLeno(this.JTDetallePreguntasT, 2)) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "VERIFICAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                for (int x = 0; x < this.JTDetallePreguntasT.getRowCount(); x++) {
                    String sql = "insert into  h_so_respuestas(`Id_Atencion`, `Id_TPregunta`, `Id_Pregunta`, `Respuesta`, `Observacion`, `UsuarioS`)values ('" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "','" + this.xmodelo.getValueAt(x, 4) + "','" + this.xmodelo.getValueAt(x, 0) + "','" + this.xmodelo.getValueAt(x, 2) + "','" + this.xmodelo.getValueAt(x, 3) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                    this.xconsultasbd.ejecutarSQL(sql);
                    this.xconsultasbd.cerrarConexionBd();
                    this.xmetodo.cambiarEstadoValidadoItemHC(getName(), 1, true);
                }
                return;
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Falta pregunta por diligenciar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    private void mVerificarEncuesta() {
        try {
            String sql = "SELECT `Id_Atencion` FROM `h_so_respuestas` WHERE (`Id_Atencion` ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "') group by Id_Atencion";
            ResultSet xrs = this.xconsultasbd.traerRs(sql);
            if (xrs.next()) {
                xrs.first();
                String xidAtencion = xrs.getString(1);
                if (xidAtencion.equals(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion())) {
                    this.JBGrabarRes.setEnabled(false);
                    this.xmetodo.cambiarEstadoValidadoItemHC(getName(), 1, true);
                } else {
                    this.JBGrabarRes.setEnabled(true);
                }
            }
            xrs.close();
            this.xconsultasbd.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPASaludOcupacional.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloHistorico() {
        this.xmodeloh = new DefaultTableModel(new Object[0], new String[]{"Id Atencion", "Fecha", "Profesional"}) { // from class: Historia.JPASaludOcupacional.5
            Class[] types = {String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalleHistorico.setModel(this.xmodeloh);
        this.JTDetalleHistorico.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTDetalleHistorico.getColumnModel().getColumn(1).setPreferredWidth(10);
        this.JTDetalleHistorico.getColumnModel().getColumn(2).setPreferredWidth(200);
    }

    private void mCargarDatosTablaHistorico() {
        try {
            mCrearModeloHistorico();
            String sql = "SELECT `h_so_respuestas`.`Id_Atencion` , DATE_FORMAT(`h_so_respuestas`.`Fecha`,'%d-%m-%Y')AS Fecha,`profesional`.`NProfesional` FROM `h_so_respuestas` INNER JOIN `h_atencion` ON (`h_so_respuestas`.`Id_Atencion` = `h_atencion`.`Id`)INNER JOIN `profesional` ON (`h_atencion`.`Id_Profesional` = `profesional`.`Id_Persona`)INNER JOIN `ingreso` ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)WHERE (`ingreso`.`Id_Usuario` ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "') group by `h_so_respuestas`.`Id_Atencion`";
            ResultSet xrs = this.xconsultasbd.traerRs(sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodeloh.addRow(this.xdatos);
                    this.xmodeloh.setValueAt(xrs.getString(1), n, 0);
                    this.xmodeloh.setValueAt(xrs.getString(2), n, 1);
                    this.xmodeloh.setValueAt(xrs.getString(3), n, 2);
                    n++;
                }
            }
            xrs.close();
            this.xconsultasbd.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPASaludOcupacional.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }
}
