package Inventarios;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Inventarios/JIFIAgenda_Cirugia.class */
public class JIFIAgenda_Cirugia extends JInternalFrame {
    private int xtipoa = 3;
    private Metodos xmt = new Metodos();
    private ConsultasMySQL xct = new ConsultasMySQL();
    private String xsql;
    public DefaultTableModel xmodelo;
    private Object[] xdato;
    private mRefrescarAgenda2 claseHilo;
    private Thread hilo;
    private ButtonGroup JBGEstado;
    private ButtonGroup JBGTipoA;
    private JCheckBox JCH_Agrupacion;
    public JDateChooser JDCFechaF;
    public JDateChooser JDCFechaI;
    private JLabel JLBNRegistro;
    private JPanel JPIDatosC;
    private JPanel JPIEstado;
    private JRadioButton JRBDespachada;
    private JRadioButton JRBPorDespachar;
    private JScrollPane JSPAgenda;
    public JTable JTAgenda;
    private JTabbedPane JTPDatosA;

    public JIFIAgenda_Cirugia() {
        initComponents();
        mNuevo();
        iniciarHilo();
    }

    /* JADX WARN: Type inference failed for: r3v51, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGTipoA = new ButtonGroup();
        this.JBGEstado = new ButtonGroup();
        this.JPIDatosC = new JPanel();
        this.JDCFechaI = new JDateChooser();
        this.JDCFechaF = new JDateChooser();
        this.JLBNRegistro = new JLabel();
        this.JPIEstado = new JPanel();
        this.JRBPorDespachar = new JRadioButton();
        this.JRBDespachada = new JRadioButton();
        this.JCH_Agrupacion = new JCheckBox();
        this.JTPDatosA = new JTabbedPane();
        this.JSPAgenda = new JScrollPane();
        this.JTAgenda = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("AGENDA DE  USUARIOS EN CIRUGIA");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjifiagendacirugia");
        this.JPIDatosC.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS PARA CONSULTAR", 0, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JDCFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicio", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDCFechaI.setFont(new Font("Arial", 1, 12));
        this.JDCFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Fin", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDCFechaF.setFont(new Font("Arial", 1, 12));
        this.JLBNRegistro.setBackground(new Color(255, 255, 255));
        this.JLBNRegistro.setFont(new Font("Arial", 1, 18));
        this.JLBNRegistro.setHorizontalAlignment(0);
        this.JLBNRegistro.setBorder(BorderFactory.createTitledBorder((Border) null, "Nº Registro", 2, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JPIEstado.setBorder(BorderFactory.createTitledBorder((Border) null, "Estado", 0, 0, new Font("Arial", 1, 12), new Color(255, 0, 0)));
        this.JBGEstado.add(this.JRBPorDespachar);
        this.JRBPorDespachar.setFont(new Font("Arial", 1, 12));
        this.JRBPorDespachar.setForeground(Color.blue);
        this.JRBPorDespachar.setSelected(true);
        this.JRBPorDespachar.setText("Por despachar");
        this.JRBPorDespachar.addActionListener(new ActionListener() { // from class: Inventarios.JIFIAgenda_Cirugia.1
            public void actionPerformed(ActionEvent evt) {
                JIFIAgenda_Cirugia.this.JRBPorDespacharActionPerformed(evt);
            }
        });
        this.JBGEstado.add(this.JRBDespachada);
        this.JRBDespachada.setFont(new Font("Arial", 1, 12));
        this.JRBDespachada.setForeground(Color.blue);
        this.JRBDespachada.setText("Despachada");
        this.JRBDespachada.addActionListener(new ActionListener() { // from class: Inventarios.JIFIAgenda_Cirugia.2
            public void actionPerformed(ActionEvent evt) {
                JIFIAgenda_Cirugia.this.JRBDespachadaActionPerformed(evt);
            }
        });
        GroupLayout JPIEstadoLayout = new GroupLayout(this.JPIEstado);
        this.JPIEstado.setLayout(JPIEstadoLayout);
        JPIEstadoLayout.setHorizontalGroup(JPIEstadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIEstadoLayout.createSequentialGroup().addContainerGap().addComponent(this.JRBPorDespachar).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBDespachada).addContainerGap(-1, 32767)));
        JPIEstadoLayout.setVerticalGroup(JPIEstadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIEstadoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBPorDespachar).addComponent(this.JRBDespachada)));
        this.JCH_Agrupacion.setFont(new Font("Arial", 1, 12));
        this.JCH_Agrupacion.setText("Agrupación tipo producto");
        GroupLayout JPIDatosCLayout = new GroupLayout(this.JPIDatosC);
        this.JPIDatosC.setLayout(JPIDatosCLayout);
        JPIDatosCLayout.setHorizontalGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosCLayout.createSequentialGroup().addContainerGap().addComponent(this.JDCFechaI, -2, 110, -2).addGap(18, 18, 18).addComponent(this.JDCFechaF, -2, 110, -2).addGap(18, 18, 18).addComponent(this.JCH_Agrupacion).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 147, 32767).addComponent(this.JPIEstado, -2, -1, -2).addGap(18, 18, 18).addComponent(this.JLBNRegistro, -2, 170, -2).addContainerGap()));
        JPIDatosCLayout.setVerticalGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosCLayout.createSequentialGroup().addGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JCH_Agrupacion).addComponent(this.JPIEstado, -2, -1, -2).addGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JLBNRegistro, -1, -1, 32767).addGroup(GroupLayout.Alignment.LEADING, JPIDatosCLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JDCFechaI, -2, 50, -2).addComponent(this.JDCFechaF, -2, 50, -2))))).addContainerGap(-1, 32767)));
        this.JTPDatosA.setForeground(Color.red);
        this.JTPDatosA.setFont(new Font("Arial", 1, 14));
        this.JTAgenda.setFont(new Font("Arial", 1, 12));
        this.JTAgenda.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTAgenda.setRowHeight(25);
        this.JTAgenda.setSelectionBackground(new Color(255, 255, 255));
        this.JTAgenda.setSelectionForeground(new Color(255, 0, 0));
        this.JTAgenda.setSelectionMode(0);
        this.JTAgenda.addMouseListener(new MouseAdapter() { // from class: Inventarios.JIFIAgenda_Cirugia.3
            public void mouseClicked(MouseEvent evt) {
                JIFIAgenda_Cirugia.this.JTAgendaMouseClicked(evt);
            }
        });
        this.JTAgenda.addPropertyChangeListener(new PropertyChangeListener() { // from class: Inventarios.JIFIAgenda_Cirugia.4
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFIAgenda_Cirugia.this.JTAgendaPropertyChange(evt);
            }
        });
        this.JSPAgenda.setViewportView(this.JTAgenda);
        this.JTPDatosA.addTab("AGENDA", this.JSPAgenda);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTPDatosA).addComponent(this.JPIDatosC, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(19, 19, 19).addComponent(this.JPIDatosC, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTPDatosA, -2, 387, -2).addContainerGap(-1, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBPorDespacharActionPerformed(ActionEvent evt) {
        mCargarDatos();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBDespachadaActionPerformed(ActionEvent evt) {
        mCargarDatos();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTAgendaMouseClicked(MouseEvent evt) {
        if (this.JTAgenda.getSelectedRow() != -1) {
            Object[] botones = {"Despachar", "Despachar y Cerrar", "Visualizar", "Cerrar"};
            int y = JOptionPane.showInternalOptionDialog(this, "Que desea hacer", "SELECCIONAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), botones, "Cerrar");
            if (y != 0 && y != 1) {
                if (y == 2) {
                    mImprimir();
                }
            } else {
                if (Long.valueOf(this.xmodelo.getValueAt(this.JTAgenda.getSelectedRow(), 10).toString()).longValue() == 0) {
                    try {
                        dispose();
                        this.claseHilo.xvalor = false;
                        this.claseHilo = null;
                        Principal.xClaseInventario.xjifagendaunidosis = null;
                        finalize();
                        Principal.xClaseInventario.mCargarPantalla("Despachos", this.xmodelo.getValueAt(this.JTAgenda.getSelectedRow(), 4).toString(), Long.valueOf(this.xmodelo.getValueAt(this.JTAgenda.getSelectedRow(), 0).toString()), Long.valueOf(this.xmodelo.getValueAt(this.JTAgenda.getSelectedRow(), 1).toString()), Boolean.valueOf(this.JCH_Agrupacion.isSelected()), Integer.valueOf(this.xmodelo.getValueAt(this.JTAgenda.getSelectedRow(), 13).toString()).intValue(), y, "JIFIAgenda_Cirugia");
                        return;
                    } catch (Throwable ex) {
                        Logger.getLogger(JIFIAgenda_Cirugia.class.getName()).log(Level.SEVERE, (String) null, ex);
                        return;
                    }
                }
                JOptionPane.showInternalMessageDialog(this, "Unidosis ya cerrada", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTAgendaPropertyChange(PropertyChangeEvent evt) {
        if (this.JTAgenda.getRowCount() != -1) {
        }
    }

    public void mImprimir() {
        String[][] mparametros = new String[4][2];
        mparametros[0][0] = "id";
        mparametros[0][1] = this.xmodelo.getValueAt(this.JTAgenda.getSelectedRow(), 0).toString();
        mparametros[1][0] = "nusuarios";
        mparametros[1][1] = Principal.usuarioSistemaDTO.getLogin();
        mparametros[2][0] = "SUBREPORT_DIR";
        mparametros[2][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
        mparametros[3][0] = "SUBREPORTFIRMA_DIR";
        mparametros[3][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
        this.xmt.GenerarPDF(this.xmt.getRutaRep() + "H_ProcedSuministro", mparametros);
    }

    private void iniciarHilo() {
        if (this.claseHilo == null) {
            this.claseHilo = new mRefrescarAgenda2(this);
        }
        if (this.hilo == null) {
            this.hilo = new Thread(this.claseHilo);
        }
        this.hilo.start();
    }

    private void mNuevo() {
        this.JDCFechaI.setDate(this.xmt.getFechaActual());
        this.JDCFechaF.setDate(this.xmt.getFechaActual());
        this.JCH_Agrupacion.setSelected(true);
        mCrearTablaAgenda();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTablaAgenda() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Id_Ingreso", "Fecha", "Hora", "No. Historia", "Usuario", "Sexo", "Edad", "Empresa", "Procedimiento", "Id_Salida", "idTipoAtencion", "Tipo", "EsMaterial?"}) { // from class: Inventarios.JIFIAgenda_Cirugia.5
            Class[] types = {Long.class, Long.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Long.class, Long.class, String.class, Integer.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTAgenda;
        JTable jTable2 = this.JTAgenda;
        jTable.setAutoResizeMode(0);
        this.JTAgenda.doLayout();
        this.JTAgenda.setModel(this.xmodelo);
        this.JTAgenda.getColumnModel().getColumn(0).setPreferredWidth(80);
        this.JTAgenda.getColumnModel().getColumn(1).setPreferredWidth(0);
        this.JTAgenda.getColumnModel().getColumn(1).setMinWidth(0);
        this.JTAgenda.getColumnModel().getColumn(1).setMaxWidth(0);
        this.JTAgenda.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTAgenda.getColumnModel().getColumn(3).setPreferredWidth(80);
        this.JTAgenda.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTAgenda.getColumnModel().getColumn(5).setPreferredWidth(200);
        this.JTAgenda.getColumnModel().getColumn(6).setPreferredWidth(50);
        this.JTAgenda.getColumnModel().getColumn(7).setPreferredWidth(80);
        this.JTAgenda.getColumnModel().getColumn(8).setPreferredWidth(200);
        this.JTAgenda.getColumnModel().getColumn(9).setPreferredWidth(200);
        this.JTAgenda.getColumnModel().getColumn(10).setPreferredWidth(80);
        this.JTAgenda.getColumnModel().getColumn(11).setPreferredWidth(0);
        this.JTAgenda.getColumnModel().getColumn(11).setMinWidth(0);
        this.JTAgenda.getColumnModel().getColumn(11).setMaxWidth(0);
        this.JTAgenda.getColumnModel().getColumn(12).setPreferredWidth(100);
        this.JTAgenda.getColumnModel().getColumn(13).setPreferredWidth(0);
        this.JTAgenda.getColumnModel().getColumn(13).setMinWidth(0);
        this.JTAgenda.getColumnModel().getColumn(13).setMaxWidth(0);
    }

    public void mCargarDatos() {
        if (this.JDCFechaI.getDate() != null && this.xmodelo != null) {
            try {
                mCrearTablaAgenda();
                if (this.JRBPorDespachar.isSelected()) {
                    if (this.JCH_Agrupacion.isSelected()) {
                        this.xsql = "SELECT  `q_agendacx`.`Id`,`q_agendacx`.`Id_Ingreso`  , DATE_FORMAT(`q_agendacx`.`FechaCx`, '%d-%m-%Y') AS Fecha , `q_agendacx`.`HoraInicial`  , `g_usuario`.`NoHistoria`  , CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2` ,' ', `g_persona`.`Nombre1` ,' ', `g_persona`.`Nombre2`) AS `NUsuario` \n, `g_persona`.`Id_Sexo` , CONCAT(`Devuelve_Edad_2F`(`g_persona`.`FechaNac`, `q_agendacx`.FechaCx) , ' ', `Devuelve_Tipo_Edad_2F`(`g_persona`.`FechaNac`, `q_agendacx`.`FechaCx`)) AS `Edad` , `f_empresacontxconvenio`.`Nbre` AS `NEmpresa` , `g_procedimiento`.`Nbre` AS `NProcedimiento` \n,  q_procedsuministro.`Id_Salida`, IF(`ingreso`.`Id_TipoAtencion` IS NULL, 1, `ingreso`.`Id_TipoAtencion`) AS `Id_TipoAtencion`, IF(i_suministro.`EsMaterial`=0, 'MEDICAMENTOS', 'MATERIALES') Tipo ,  i_suministro.`EsMaterial` \nFROM  `q_agendacx` INNER JOIN  `g_persona`  ON (`q_agendacx`.`Id_Usuario` = `g_persona`.`Id`) INNER JOIN  `f_empresacontxconvenio`    ON (`q_agendacx`.`Id_EmpresaConv` = `f_empresacontxconvenio`.`Id`) \nINNER JOIN  `profesional1`  ON (`profesional1`.`IdEspecialidad` = `q_agendacx`.`Id_Especialidad`) AND (`profesional1`.`Id_Persona` = `q_agendacx`.`Id_Profesional`) \nINNER JOIN  `g_procedimiento`   ON (`q_agendacx`.`Id_Procedimiento` = `g_procedimiento`.`Id`) LEFT JOIN  `ingreso`  ON (`q_agendacx`.`Id_Ingreso` = `ingreso`.`Id`) \nINNER JOIN  `g_tipoedad`  ON (`g_persona`.`Id_TipoEdad` = `g_tipoedad`.`Id`) INNER JOIN  `g_usuario`  ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`) \nLEFT JOIN  `h_atencion`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`) LEFT JOIN  `c_clasecita`  ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`)\n INNER JOIN  `q_procedsuministro`  ON (`q_agendacx`.`Id` = `q_procedsuministro`.`Id_AgendaCX`) INNER JOIN  `i_suministro`  ON (`i_suministro`.`Id` = `q_procedsuministro`.`Id_Suministro`)\nWHERE ( q_procedsuministro.`Estado`=1 AND q_procedsuministro.`Id_Salida`=0 AND DATE_FORMAT(`q_agendacx`.`FechaCx`,'%Y/%m/%d')>='" + this.xmt.formatoAMD.format(this.JDCFechaI.getDate()) + "' AND DATE_FORMAT(`q_agendacx`.`FechaCx`,'%Y/%m/%d') <='" + this.xmt.formatoAMD.format(this.JDCFechaF.getDate()) + "' AND `q_agendacx`.`Id_MotivoDesistida` =1 ) \nGROUP BY `q_agendacx`.`Id` , i_suministro.`EsMaterial` ORDER BY `q_agendacx`.`FechaCx` ASC, `q_agendacx`.`HoraInicial` ASC ";
                    } else {
                        this.xsql = "SELECT  `q_agendacx`.`Id`,`q_agendacx`.`Id_Ingreso`  , DATE_FORMAT(`q_agendacx`.`FechaCx`, '%d-%m-%Y') AS Fecha , `q_agendacx`.`HoraInicial`  , `g_usuario`.`NoHistoria`  , CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2` ,' ', `g_persona`.`Nombre1` ,' ', `g_persona`.`Nombre2`) AS `NUsuario` \n, `g_persona`.`Id_Sexo` , CONCAT(`Devuelve_Edad_2F`(`g_persona`.`FechaNac`, `q_agendacx`.FechaCx) , ' ', `Devuelve_Tipo_Edad_2F`(`g_persona`.`FechaNac`, `q_agendacx`.`FechaCx`)) AS `Edad` , `f_empresacontxconvenio`.`Nbre` AS `NEmpresa` , `g_procedimiento`.`Nbre` AS `NProcedimiento` \n,  q_procedsuministro.`Id_Salida`, IF(`ingreso`.`Id_TipoAtencion` IS NULL, 1, `ingreso`.`Id_TipoAtencion`) AS `Id_TipoAtencion`, IF(i_suministro.`EsMaterial`=0, 'MEDICAMENTOS', 'MATERIALES') Tipo ,  i_suministro.`EsMaterial` \nFROM  `q_agendacx` INNER JOIN  `g_persona`  ON (`q_agendacx`.`Id_Usuario` = `g_persona`.`Id`) INNER JOIN  `f_empresacontxconvenio`    ON (`q_agendacx`.`Id_EmpresaConv` = `f_empresacontxconvenio`.`Id`) \nINNER JOIN  `profesional1`  ON (`profesional1`.`IdEspecialidad` = `q_agendacx`.`Id_Especialidad`) AND (`profesional1`.`Id_Persona` = `q_agendacx`.`Id_Profesional`) \nINNER JOIN  `g_procedimiento`   ON (`q_agendacx`.`Id_Procedimiento` = `g_procedimiento`.`Id`) LEFT JOIN  `ingreso`  ON (`q_agendacx`.`Id_Ingreso` = `ingreso`.`Id`) \nINNER JOIN  `g_tipoedad`  ON (`g_persona`.`Id_TipoEdad` = `g_tipoedad`.`Id`) INNER JOIN  `g_usuario`  ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`) \nLEFT JOIN  `h_atencion`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`) LEFT JOIN  `c_clasecita`  ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`)\n INNER JOIN  `q_procedsuministro`  ON (`q_agendacx`.`Id` = `q_procedsuministro`.`Id_AgendaCX`) INNER JOIN  `i_suministro`  ON (`i_suministro`.`Id` = `q_procedsuministro`.`Id_Suministro`)\nWHERE ( q_procedsuministro.`Estado`=1 AND q_procedsuministro.`Id_Salida`=0 AND DATE_FORMAT(`q_agendacx`.`FechaCx`,'%Y/%m/%d')>='" + this.xmt.formatoAMD.format(this.JDCFechaI.getDate()) + "' AND DATE_FORMAT(`q_agendacx`.`FechaCx`,'%Y/%m/%d') <='" + this.xmt.formatoAMD.format(this.JDCFechaF.getDate()) + "'  AND `q_agendacx`.`Id_MotivoDesistida` =1 ) \nGROUP BY `q_agendacx`.`Id` ORDER BY `q_agendacx`.`FechaCx` ASC, `q_agendacx`.`HoraInicial` ASC";
                    }
                } else if (this.JRBDespachada.isSelected()) {
                    if (this.JCH_Agrupacion.isSelected()) {
                        this.xsql = "SELECT  `q_agendacx`.`Id`,`q_agendacx`.`Id_Ingreso`  , DATE_FORMAT(`q_agendacx`.`FechaCx`, '%d-%m-%Y') AS Fecha , `q_agendacx`.`HoraInicial`  , `g_usuario`.`NoHistoria`  , CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2` ,' ', `g_persona`.`Nombre1` ,' ', `g_persona`.`Nombre2`) AS `NUsuario` \n, `g_persona`.`Id_Sexo` , CONCAT(`Devuelve_Edad_2F`(`g_persona`.`FechaNac`, `q_agendacx`.FechaCx) , ' ', `Devuelve_Tipo_Edad_2F`(`g_persona`.`FechaNac`, `q_agendacx`.`FechaCx`)) AS `Edad` , `f_empresacontxconvenio`.`Nbre` AS `NEmpresa` , `g_procedimiento`.`Nbre` AS `NProcedimiento` \n,  q_procedsuministro.`Id_Salida`, IF(`ingreso`.`Id_TipoAtencion` IS NULL, 1, `ingreso`.`Id_TipoAtencion`) AS `Id_TipoAtencion`, IF(i_suministro.`EsMaterial`=0, 'MEDICAMENTOS', 'MATERIALES') Tipo ,  i_suministro.`EsMaterial` \nFROM  `q_agendacx` INNER JOIN  `g_persona`  ON (`q_agendacx`.`Id_Usuario` = `g_persona`.`Id`) INNER JOIN  `f_empresacontxconvenio`    ON (`q_agendacx`.`Id_EmpresaConv` = `f_empresacontxconvenio`.`Id`) \nINNER JOIN  `profesional1`  ON (`profesional1`.`IdEspecialidad` = `q_agendacx`.`Id_Especialidad`) AND (`profesional1`.`Id_Persona` = `q_agendacx`.`Id_Profesional`) \nINNER JOIN  `g_procedimiento`   ON (`q_agendacx`.`Id_Procedimiento` = `g_procedimiento`.`Id`) LEFT JOIN  `ingreso`  ON (`q_agendacx`.`Id_Ingreso` = `ingreso`.`Id`) \nINNER JOIN  `g_tipoedad`  ON (`g_persona`.`Id_TipoEdad` = `g_tipoedad`.`Id`) INNER JOIN  `g_usuario`  ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`) \nLEFT JOIN  `h_atencion`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`) LEFT JOIN  `c_clasecita`  ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`)\n INNER JOIN  `q_procedsuministro`  ON (`q_agendacx`.`Id` = `q_procedsuministro`.`Id_AgendaCX`) INNER JOIN  `i_suministro`  ON (`i_suministro`.`Id` = `q_procedsuministro`.`Id_Suministro`)\nWHERE ( q_procedsuministro.`Estado`=1 AND q_procedsuministro.`Id_Salida`<>0 AND DATE_FORMAT(`q_agendacx`.`FechaCx`,'%Y/%m/%d')>='" + this.xmt.formatoAMD.format(this.JDCFechaI.getDate()) + "' AND DATE_FORMAT(`q_agendacx`.`FechaCx`,'%Y/%m/%d') <='" + this.xmt.formatoAMD.format(this.JDCFechaF.getDate()) + "' AND `q_agendacx`.`Id_MotivoDesistida` =1 ) \nGROUP BY `q_agendacx`.`Id` , i_suministro.`EsMaterial` ORDER BY `q_agendacx`.`FechaCx` ASC, `q_agendacx`.`HoraInicial` ASC";
                    } else {
                        this.xsql = "SELECT  `q_agendacx`.`Id`,`q_agendacx`.`Id_Ingreso`  , DATE_FORMAT(`q_agendacx`.`FechaCx`, '%d-%m-%Y') AS Fecha , `q_agendacx`.`HoraInicial`  , `g_usuario`.`NoHistoria`  , CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2` ,' ', `g_persona`.`Nombre1` ,' ', `g_persona`.`Nombre2`) AS `NUsuario` \n, `g_persona`.`Id_Sexo` , CONCAT(`Devuelve_Edad_2F`(`g_persona`.`FechaNac`, `q_agendacx`.FechaCx) , ' ', `Devuelve_Tipo_Edad_2F`(`g_persona`.`FechaNac`, `q_agendacx`.`FechaCx`)) AS `Edad` , `f_empresacontxconvenio`.`Nbre` AS `NEmpresa` , `g_procedimiento`.`Nbre` AS `NProcedimiento` \n,  q_procedsuministro.`Id_Salida`, IF(`ingreso`.`Id_TipoAtencion` IS NULL, 1, `ingreso`.`Id_TipoAtencion`) AS `Id_TipoAtencion`, IF(i_suministro.`EsMaterial`=0, 'MEDICAMENTOS', 'MATERIALES') Tipo ,  i_suministro.`EsMaterial` \nFROM  `q_agendacx` INNER JOIN  `g_persona`  ON (`q_agendacx`.`Id_Usuario` = `g_persona`.`Id`) INNER JOIN  `f_empresacontxconvenio`    ON (`q_agendacx`.`Id_EmpresaConv` = `f_empresacontxconvenio`.`Id`) \nINNER JOIN  `profesional1`  ON (`profesional1`.`IdEspecialidad` = `q_agendacx`.`Id_Especialidad`) AND (`profesional1`.`Id_Persona` = `q_agendacx`.`Id_Profesional`) \nINNER JOIN  `g_procedimiento`   ON (`q_agendacx`.`Id_Procedimiento` = `g_procedimiento`.`Id`) LEFT JOIN  `ingreso`  ON (`q_agendacx`.`Id_Ingreso` = `ingreso`.`Id`) \nINNER JOIN  `g_tipoedad`  ON (`g_persona`.`Id_TipoEdad` = `g_tipoedad`.`Id`) INNER JOIN  `g_usuario`  ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`) \nLEFT JOIN  `h_atencion`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`) LEFT JOIN  `c_clasecita`  ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`)\n INNER JOIN  `q_procedsuministro`  ON (`q_agendacx`.`Id` = `q_procedsuministro`.`Id_AgendaCX`) INNER JOIN  `i_suministro`  ON (`i_suministro`.`Id` = `q_procedsuministro`.`Id_Suministro`)\nWHERE ( q_procedsuministro.`Estado`=1 AND q_procedsuministro.`Id_Salida`<>0 AND DATE_FORMAT(`q_agendacx`.`FechaCx`,'%Y/%m/%d')>='" + this.xmt.formatoAMD.format(this.JDCFechaI.getDate()) + "' AND DATE_FORMAT(`q_agendacx`.`FechaCx`,'%Y/%m/%d') <='" + this.xmt.formatoAMD.format(this.JDCFechaF.getDate()) + "' AND `q_agendacx`.`Id_MotivoDesistida` =1 ) \nGROUP BY `q_agendacx`.`Id` ORDER BY `q_agendacx`.`FechaCx` ASC, `q_agendacx`.`HoraInicial` ASC";
                    }
                }
                ResultSet xrs = this.xct.traerRs(this.xsql);
                if (xrs.next()) {
                    xrs.beforeFirst();
                    int xfila = 0;
                    while (xrs.next()) {
                        this.xmodelo.addRow(this.xdato);
                        this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(1)), xfila, 0);
                        this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(2)), xfila, 1);
                        this.xmodelo.setValueAt(xrs.getString(3), xfila, 2);
                        this.xmodelo.setValueAt(xrs.getString(4), xfila, 3);
                        this.xmodelo.setValueAt(xrs.getString(5), xfila, 4);
                        this.xmodelo.setValueAt(xrs.getString(6), xfila, 5);
                        this.xmodelo.setValueAt(xrs.getString(7), xfila, 6);
                        this.xmodelo.setValueAt(xrs.getString(8), xfila, 7);
                        this.xmodelo.setValueAt(xrs.getString(9), xfila, 8);
                        this.xmodelo.setValueAt(xrs.getString(10), xfila, 9);
                        this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(11)), xfila, 10);
                        this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(12)), xfila, 11);
                        this.xmodelo.setValueAt(xrs.getString(13), xfila, 12);
                        this.xmodelo.setValueAt(Integer.valueOf(xrs.getInt(14)), xfila, 13);
                        xfila++;
                    }
                    this.JLBNRegistro.setText("" + xfila);
                }
                xrs.close();
                this.xct.cerrarConexionBd();
            } catch (SQLException ex) {
                Logger.getLogger(JIFIAgenda_Cirugia.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        }
    }

    /* JADX INFO: loaded from: GenomaP.jar:Inventarios/JIFIAgenda_Cirugia$MiRender.class */
    public static class MiRender extends DefaultTableCellRenderer {
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (table.getValueAt(row, 11).toString().equals("NUEVA ORDEN")) {
                cell.setBackground(new Color(177, 251, 177));
            } else {
                cell.setBackground(Color.WHITE);
            }
            return cell;
        }
    }
}
