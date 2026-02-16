package Historia;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.genoma.plus.dao.impl.laboratorio.ImpresionReportesDAOImpl;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Historia/JIFConsultarResultadoExamenes.class */
public class JIFConsultarResultadoExamenes extends JInternalFrame {
    private int xfiltro = 0;
    private int xalerta = 0;
    private Metodos xmetodos = new Metodos();
    private ConsultasMySQL xconsultas = new ConsultasMySQL();
    public DefaultTableModel xmodelo;
    private Object[] dato;
    private String xnombre;
    private List<Integer> alterado;
    private List<Integer> aletaCove;
    private ButtonGroup JBGFiltro1;
    private JButton JBTCarguesA1;
    private JCheckBox JCHAlerta;
    private JCheckBox JCH_FAlto;
    private JCheckBox JCH_FBajo;
    private JCheckBox JCH_FBajo1;
    private JCheckBox JCH_FBajo2;
    private JCheckBox JCH_FMedio;
    public JDateChooser JDFechaF;
    public JDateChooser JDFechaI;
    private JPanel JPFiltro;
    private JPanel JPI_Filtro;
    private JRadioButton JRBAlterados;
    private JRadioButton JRBTodas;
    private JScrollPane JSPResultado;
    public JTable JTBResultado;
    private JTextField JTFRuta;
    private JPanel jPanel1;
    private JPanel jPanel2;

    public JIFConsultarResultadoExamenes(String xname) {
        initComponents();
        setName(xname);
        this.xnombre = xname;
        mNuevo();
        mCrearTabla();
    }

    /* JADX WARN: Type inference failed for: r3v6, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGFiltro1 = new ButtonGroup();
        this.JSPResultado = new JScrollPane();
        this.JTBResultado = new JTable();
        this.jPanel1 = new JPanel();
        this.JDFechaI = new JDateChooser();
        this.JDFechaF = new JDateChooser();
        this.JPFiltro = new JPanel();
        this.JRBTodas = new JRadioButton();
        this.JRBAlterados = new JRadioButton();
        this.JCHAlerta = new JCheckBox();
        this.JPI_Filtro = new JPanel();
        this.JCH_FAlto = new JCheckBox();
        this.JCH_FMedio = new JCheckBox();
        this.JCH_FBajo = new JCheckBox();
        this.JCH_FBajo1 = new JCheckBox();
        this.JCH_FBajo2 = new JCheckBox();
        this.jPanel2 = new JPanel();
        this.JTFRuta = new JTextField();
        this.JBTCarguesA1 = new JButton();
        setClosable(true);
        setIconifiable(true);
        setTitle("RESULTADO DE EXÁMENES DE LABORATORIO");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifconsultarresultado");
        this.JSPResultado.setBorder(BorderFactory.createTitledBorder((Border) null, "RESULTADO", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JSPResultado.setAutoscrolls(true);
        this.JSPResultado.setEnabled(false);
        this.JTBResultado.setFont(new Font("Arial", 1, 12));
        this.JTBResultado.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTBResultado.setAutoResizeMode(4);
        this.JTBResultado.setRowHeight(25);
        this.JTBResultado.setSelectionBackground(new Color(255, 255, 255));
        this.JTBResultado.setSelectionForeground(Color.red);
        this.JTBResultado.setSelectionMode(0);
        this.JTBResultado.addMouseListener(new MouseAdapter() { // from class: Historia.JIFConsultarResultadoExamenes.1
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarResultadoExamenes.this.JTBResultadoMouseClicked(evt);
            }
        });
        this.JSPResultado.setViewportView(this.JTBResultado);
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "FILTRO", 0, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JDFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicial", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFechaI.setFont(new Font("Arial", 1, 12));
        this.JDFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Final", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFechaF.setFont(new Font("Arial", 1, 12));
        this.JPFiltro.setBorder(BorderFactory.createTitledBorder((Border) null, "Filtro por Tipo Rsultado", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBGFiltro1.add(this.JRBTodas);
        this.JRBTodas.setFont(new Font("Arial", 1, 12));
        this.JRBTodas.setSelected(true);
        this.JRBTodas.setText("Todas");
        this.JRBTodas.addActionListener(new ActionListener() { // from class: Historia.JIFConsultarResultadoExamenes.2
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarResultadoExamenes.this.JRBTodasActionPerformed(evt);
            }
        });
        this.JBGFiltro1.add(this.JRBAlterados);
        this.JRBAlterados.setFont(new Font("Arial", 1, 12));
        this.JRBAlterados.setText("Alterados");
        this.JRBAlterados.addActionListener(new ActionListener() { // from class: Historia.JIFConsultarResultadoExamenes.3
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarResultadoExamenes.this.JRBAlteradosActionPerformed(evt);
            }
        });
        GroupLayout JPFiltroLayout = new GroupLayout(this.JPFiltro);
        this.JPFiltro.setLayout(JPFiltroLayout);
        JPFiltroLayout.setHorizontalGroup(JPFiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPFiltroLayout.createSequentialGroup().addContainerGap().addComponent(this.JRBTodas).addGap(10, 10, 10).addComponent(this.JRBAlterados).addContainerGap(18, 32767)));
        JPFiltroLayout.setVerticalGroup(JPFiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPFiltroLayout.createSequentialGroup().addContainerGap().addGroup(JPFiltroLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBTodas).addComponent(this.JRBAlterados)).addContainerGap(-1, 32767)));
        this.JCHAlerta.setFont(new Font("Arial", 1, 12));
        this.JCHAlerta.setForeground(Color.blue);
        this.JCHAlerta.setText("Alerta Cove?");
        this.JCHAlerta.addActionListener(new ActionListener() { // from class: Historia.JIFConsultarResultadoExamenes.4
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarResultadoExamenes.this.JCHAlertaActionPerformed(evt);
            }
        });
        this.JPI_Filtro.setBorder(BorderFactory.createTitledBorder((Border) null, "Semaforización(Prioridades revision)", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCH_FAlto.setBackground(Color.red);
        this.JCH_FAlto.setFont(new Font("Arial", 1, 12));
        this.JCH_FAlto.setForeground(new Color(255, 255, 255));
        this.JCH_FAlto.setText("Alta");
        this.JCH_FMedio.setBackground(Color.yellow);
        this.JCH_FMedio.setFont(new Font("Arial", 1, 12));
        this.JCH_FMedio.setText("Medio");
        this.JCH_FBajo.setBackground(Color.green);
        this.JCH_FBajo.setFont(new Font("Arial", 1, 12));
        this.JCH_FBajo.setText("Bajo");
        this.JCH_FBajo1.setBackground(new Color(255, 255, 255));
        this.JCH_FBajo1.setFont(new Font("Arial", 1, 12));
        this.JCH_FBajo1.setText("No aplica");
        this.JCH_FBajo2.setBackground(new Color(0, 0, 102));
        this.JCH_FBajo2.setFont(new Font("Arial", 1, 12));
        this.JCH_FBajo2.setForeground(new Color(255, 255, 255));
        this.JCH_FBajo2.setText("No Alterado");
        GroupLayout JPI_FiltroLayout = new GroupLayout(this.JPI_Filtro);
        this.JPI_Filtro.setLayout(JPI_FiltroLayout);
        JPI_FiltroLayout.setHorizontalGroup(JPI_FiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPI_FiltroLayout.createSequentialGroup().addGap(14, 14, 14).addComponent(this.JCH_FAlto, -2, 75, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCH_FMedio, -2, 75, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCH_FBajo, -2, 75, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCH_FBajo1, -2, 87, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCH_FBajo2, -1, 102, 32767).addContainerGap()));
        JPI_FiltroLayout.setVerticalGroup(JPI_FiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_FiltroLayout.createSequentialGroup().addContainerGap().addGroup(JPI_FiltroLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCH_FAlto).addComponent(this.JCH_FMedio).addComponent(this.JCH_FBajo).addComponent(this.JCH_FBajo1).addComponent(this.JCH_FBajo2)).addContainerGap(10, 32767)));
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.JDFechaI, -2, 143, -2).addGap(18, 18, 18).addComponent(this.JDFechaF, -2, 143, -2).addGap(40, 40, 40).addComponent(this.JPFiltro, -2, -1, -2).addGap(18, 18, 18).addComponent(this.JCHAlerta).addGap(18, 18, 18).addComponent(this.JPI_Filtro, -2, -1, -2).addContainerGap(15, 32767)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPI_Filtro, -2, -1, -2).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JPFiltro, GroupLayout.Alignment.LEADING, 0, -1, 32767).addComponent(this.JDFechaF, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.JDFechaI, GroupLayout.Alignment.LEADING, -2, 53, -2)).addGroup(jPanel1Layout.createSequentialGroup().addGap(19, 19, 19).addComponent(this.JCHAlerta))).addContainerGap(-1, 32767)));
        this.jPanel2.setBorder(BorderFactory.createTitledBorder((Border) null, "UTILIDADES", 0, 0, new Font("Arial", 1, 14), Color.red));
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: Historia.JIFConsultarResultadoExamenes.5
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarResultadoExamenes.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBTCarguesA1.setFont(new Font("Arial", 1, 12));
        this.JBTCarguesA1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTCarguesA1.setText("Exportar");
        this.JBTCarguesA1.addActionListener(new ActionListener() { // from class: Historia.JIFConsultarResultadoExamenes.6
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarResultadoExamenes.this.JBTCarguesA1ActionPerformed(evt);
            }
        });
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGap(20, 20, 20).addComponent(this.JTFRuta, -1, 344, 32767).addGap(18, 18, 18).addComponent(this.JBTCarguesA1, -2, 171, -2).addGap(18, 18, 18)));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFRuta, -2, 50, -2).addComponent(this.JBTCarguesA1, -2, 50, -2)).addContainerGap(-1, 32767)));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -1, -1, 32767).addComponent(this.JSPResultado).addGroup(layout.createSequentialGroup().addComponent(this.jPanel2, -2, -1, -2).addGap(0, 0, 32767))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPResultado, -1, 505, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jPanel2, -2, -1, -2)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBResultadoMouseClicked(MouseEvent evt) {
        mImprimir();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBTodasActionPerformed(ActionEvent evt) {
        this.alterado = new ArrayList();
        this.alterado.add(0);
        this.alterado.add(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBAlteradosActionPerformed(ActionEvent evt) {
        this.alterado = new ArrayList();
        this.alterado.add(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHAlertaActionPerformed(ActionEvent evt) {
        this.aletaCove = new ArrayList();
        if (this.JCHAlerta.isSelected()) {
            this.aletaCove.add(1);
            this.xalerta = 1;
        } else {
            this.aletaCove.add(0);
            this.xalerta = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTCarguesA1ActionPerformed(ActionEvent evt) {
        if (this.JTBResultado.getRowCount() != -1) {
            this.xmetodos.mExportar_Datos_Tabla_Titulo_Formato(this.JTBResultado, this.JTFRuta.getText(), getTitle() + " - ");
        } else {
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar documento", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JFileChooser xfilec = new JFileChooser(this.JTFRuta.getText());
            xfilec.setFileSelectionMode(1);
            int xv = xfilec.showOpenDialog(this);
            if (xv == 0) {
                File xfile = xfilec.getSelectedFile();
                this.JTFRuta.setText(xfile.getAbsolutePath() + this.xmetodos.getBarra());
                this.JTFRuta.requestFocus();
            }
        }
    }

    public void mImprimir() {
        if ((this.xnombre.equals("jifconsultarresultado") || this.xnombre.equals("jifconsultarresultadoLab")) && this.JTBResultado.getSelectedRow() != -1) {
            Object[] botones = {"Por orden de recepción", "Por tipo resultado", "Registro de Seguimiento", "Cerrar"};
            int n = JOptionPane.showInternalOptionDialog(this, "Que desea hacer", "IMPRIMIR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), botones, "Cerrar");
            ImpresionReportesDAOImpl impresion = new ImpresionReportesDAOImpl();
            switch (n) {
                case 0:
                    impresion.mImprimirResultado(this.xmodelo.getValueAt(this.JTBResultado.getSelectedRow(), 6).toString(), "", this.xmetodos.getSO() + this.xmetodos.getBarra() + "Reportes" + this.xmetodos.getBarra(), this.xmetodos.getSO() + this.xmetodos.getBarra() + "Firmas" + this.xmetodos.getBarra(), true, this.xmodelo.getValueAt(this.JTBResultado.getSelectedRow(), 11).toString(), true);
                    break;
                case 1:
                    impresion.mImprimirResultado(this.xmodelo.getValueAt(this.JTBResultado.getSelectedRow(), 6).toString(), this.xmodelo.getValueAt(this.JTBResultado.getSelectedRow(), 10).toString(), this.xmetodos.getSO() + this.xmetodos.getBarra() + "Reportes" + this.xmetodos.getBarra(), this.xmetodos.getSO() + this.xmetodos.getBarra() + "Firmas" + this.xmetodos.getBarra(), true, this.xmodelo.getValueAt(this.JTBResultado.getSelectedRow(), 11).toString(), true);
                    break;
                case 2:
                    Principal.clasehistoriace.cargarPantalla("jifseguimientolab", Principal.clasehistoriace.frmPrincipal);
                    break;
            }
        }
    }

    private void mNuevo() {
        this.JTFRuta.setText(this.xmetodos.getDirectorioExportacion() + "Planilla");
        this.JDFechaI.setDate(this.xmetodos.getFechaActual());
        this.JDFechaF.setDate(this.xmetodos.getFechaActual());
        this.JRBTodas.setSelected(true);
        this.aletaCove = new ArrayList();
        this.alterado = new ArrayList();
        this.aletaCove.add(0);
        this.alterado.add(0);
        this.alterado.add(1);
        this.xfiltro = 0;
    }

    public void mBuscar() {
        mCargarDatos();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTabla() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"NHC", "Nombre", "Sexo", "Edad", "Fecha", "Exámen", "Recepcion", "Resultado", "Alterado", "Revisado", "IdPr", "Idpersona", "prioridad", "Servicio", "Cama"}) { // from class: Historia.JIFConsultarResultadoExamenes.7
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, Long.class, Long.class, Boolean.class, Boolean.class, Long.class, Long.class, Integer.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTBResultado;
        JTable jTable2 = this.JTBResultado;
        jTable.setAutoResizeMode(0);
        this.JTBResultado.doLayout();
        this.JTBResultado.setModel(this.xmodelo);
        this.JTBResultado.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTBResultado.getColumnModel().getColumn(1).setPreferredWidth(300);
        this.JTBResultado.getColumnModel().getColumn(2).setPreferredWidth(80);
        this.JTBResultado.getColumnModel().getColumn(3).setPreferredWidth(80);
        this.JTBResultado.getColumnModel().getColumn(4).setPreferredWidth(150);
        this.JTBResultado.getColumnModel().getColumn(5).setPreferredWidth(400);
        this.JTBResultado.getColumnModel().getColumn(6).setPreferredWidth(0);
        this.JTBResultado.getColumnModel().getColumn(6).setMinWidth(0);
        this.JTBResultado.getColumnModel().getColumn(6).setMaxWidth(0);
        this.JTBResultado.getColumnModel().getColumn(7).setPreferredWidth(0);
        this.JTBResultado.getColumnModel().getColumn(7).setMinWidth(0);
        this.JTBResultado.getColumnModel().getColumn(7).setMaxWidth(0);
        this.JTBResultado.getColumnModel().getColumn(8).setPreferredWidth(100);
        this.JTBResultado.getColumnModel().getColumn(9).setPreferredWidth(100);
        this.JTBResultado.getColumnModel().getColumn(10).setPreferredWidth(0);
        this.JTBResultado.getColumnModel().getColumn(10).setMinWidth(0);
        this.JTBResultado.getColumnModel().getColumn(10).setMaxWidth(0);
        this.JTBResultado.getColumnModel().getColumn(11).setPreferredWidth(0);
        this.JTBResultado.getColumnModel().getColumn(11).setMinWidth(0);
        this.JTBResultado.getColumnModel().getColumn(11).setMaxWidth(0);
        this.JTBResultado.getColumnModel().getColumn(12).setPreferredWidth(0);
        this.JTBResultado.getColumnModel().getColumn(12).setMinWidth(0);
        this.JTBResultado.getColumnModel().getColumn(12).setMaxWidth(0);
        this.JTBResultado.getColumnModel().getColumn(13).setPreferredWidth(350);
        this.JTBResultado.getColumnModel().getColumn(14).setPreferredWidth(350);
    }

    private void mCargarDatos() {
        try {
            String sql = "with maestra as (\nselect \ngu.`NoHistoria` numeroHistoria\n, CONCAT(gp2.`Apellido1`,' ',gp2.`Apellido2`,' ',gp2.`Nombre1`,' ',gp2.`Nombre2`) AS nombreUsuario  \n, gp2.Id_Sexo idSexo\n, Devuelve_Edad_2F(gp2.FechaNac,lr.FechaRecep) edad\n, Devuelve_Tipo_Edad_2F(gp2.FechaNac,lr.FechaRecep) tipoEdad\n, ld.FechaValidado  fechaResultado\n, lr.Id  idRecepcion\n, IF(ld.Id_Atencion=0,0,1)AS revisado\n, gp.Nbre nombreProcedimiento\n, gp.Id idProcedimiento\n, gp2.`Id`  idPersona\n,IF(gp3.`Id_tipoprioridad` IS NULL,0, gp3.`Id_tipoprioridad`) AS idTipoPrioridad \n, gp.Alerta alertaCove, gt.Nbre servicio , if(fc.Nbre is null, '', concat(fu.Nbre ,'-',fc.Nbre)) cama\nfrom  l_recepcion lr \ninner join l_detallerecepcion ld  ON (ld.Id_Recepcion = lr.Id) \ninner join g_procedimiento gp  on (gp.Id=ld.Id_Procedim)\ninner join f_ordenes fo on (fo.Id=lr.Id_OrdenFacturac)\ninner join ingreso i on (i.Id=fo.Id_Ingreso)\ninner join g_usuario gu on (gu.Id_persona=i.Id_Usuario)\ninner join g_persona gp2  on (gp2.Id=gu.Id_persona)\ninner join l_resultados lr2 on (lr2.Id_Recepcion=lr.Id) \ninner join g_tipoatencion gt on (gt.Id=i.Id_TipoAtencion)\nleft join g_procedimientoxprioridadr gp3  on (gp3.Id_Procedimiento=gp.Id)\nleft join f_camas fc on (i.Cama=fc.Id )\nleft  join f_unidadcama fu on (fu.Id=fc.Id_UnidadCamas )\nwhere  lr2.FechaResult BETWEEN '" + this.xmetodos.formatoAMD1.format(this.JDFechaI.getDate()) + "' and '" + this.xmetodos.formatoAMD1.format(this.JDFechaF.getDate()) + "'\nand lr2.Estado =0 and ld.ValidadoLab=1\nGROUP BY gp2.Id , lr.Id , ld.Id_Procedim \n-- HAVING nombreUsuario like 'romero%'\nORDER BY fechaResultado DESC, nombreUsuario ASC\n)\n-- select * from maestra\n, resultadoAlterado as (\n\tselect ld2.Alterado alterado, lr3.Id_Recepcion  idRecepcion, ld2.Id_Procedimiento idProcedimiento\n\tfrom l_resultados lr3 \n\tinner join l_detalleresultado ld2  on (ld2.Id_Resultado=lr3.Id) and (ld2.Alterado=1) \n\tinner join maestra m on (m.idRecepcion=lr3.Id_Recepcion) and (ld2.Id_Procedimiento=m.idProcedimiento)\n\t-- where lr3.Id_Recepcion =249349\n\tgroup by lr3.Id_Recepcion , ld2.Id_Procedimiento \n)\n-- select * from resultadoAlterado\nselect\nm.numeroHistoria\n, m.nombreUsuario  \n, m.idSexo\n, m.edad\n, m.tipoEdad\n, m.fechaResultado\n, m.nombreProcedimiento\n, m.idRecepcion\n, ifnull(r.alterado,0) alterado\n, m.revisado\n, m.idProcedimiento\n,m.idPersona\n,m.idTipoPrioridad \n, m.alertaCove, m.servicio, m.cama\nfrom maestra m \nleft join resultadoAlterado r on (r.idRecepcion=m.idRecepcion) and (r.idProcedimiento=m.idProcedimiento)\nwhere ifnull(r.alterado,0) in (" + this.alterado.toString().replace("[", "").replace("]", "") + ") and  m.alertaCove in(" + this.aletaCove.toString().replace("[", "").replace("]", "") + ")\nORDER BY m.fechaResultado DESC, m.nombreUsuario ASC\n-- where  m.nombreUsuario like 'romero%'";
            System.out.println("Consulta-->" + sql);
            ResultSet rs = this.xconsultas.traerRs(sql);
            Throwable th = null;
            try {
                try {
                    if (rs.next()) {
                        rs.beforeFirst();
                        int filaGrid = 0;
                        mCrearTabla();
                        while (rs.next()) {
                            this.xmodelo.addRow(this.dato);
                            this.xmodelo.setValueAt(rs.getString("numeroHistoria"), filaGrid, 0);
                            this.xmodelo.setValueAt(rs.getString("nombreUsuario"), filaGrid, 1);
                            this.xmodelo.setValueAt(rs.getString("idSexo"), filaGrid, 2);
                            this.xmodelo.setValueAt(rs.getString("edad") + " " + rs.getString("tipoEdad"), filaGrid, 3);
                            this.xmodelo.setValueAt(rs.getString("fechaResultado"), filaGrid, 4);
                            this.xmodelo.setValueAt(rs.getString("nombreProcedimiento"), filaGrid, 5);
                            this.xmodelo.setValueAt(Long.valueOf(rs.getLong("idRecepcion")), filaGrid, 6);
                            this.xmodelo.setValueAt(Long.valueOf(rs.getLong("idRecepcion")), filaGrid, 7);
                            this.xmodelo.setValueAt(Boolean.valueOf(rs.getBoolean("alterado")), filaGrid, 8);
                            this.xmodelo.setValueAt(Boolean.valueOf(rs.getBoolean("revisado")), filaGrid, 9);
                            this.xmodelo.setValueAt(Long.valueOf(rs.getLong("idProcedimiento")), filaGrid, 10);
                            this.xmodelo.setValueAt(Long.valueOf(rs.getLong("idPersona")), filaGrid, 11);
                            this.xmodelo.setValueAt(rs.getString("servicio"), filaGrid, 13);
                            this.xmodelo.setValueAt(rs.getString("cama"), filaGrid, 14);
                            this.xmodelo.setValueAt(Integer.valueOf(rs.getInt("idTipoPrioridad")), filaGrid, 12);
                            this.JTBResultado.setDefaultRenderer(Object.class, new MiRender());
                            filaGrid++;
                        }
                    }
                    if (rs != null) {
                        if (0 != 0) {
                            try {
                                rs.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                        } else {
                            rs.close();
                        }
                    }
                    this.xconsultas.cerrarConexionBd();
                } finally {
                }
            } catch (Throwable th3) {
                th = th3;
                throw th3;
            }
        } catch (Exception ex) {
            Logger.getLogger(JIFConsultarResultadoExamenes.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX INFO: loaded from: GenomaP.jar:Historia/JIFConsultarResultadoExamenes$MiRender.class */
    public class MiRender extends DefaultTableCellRenderer {
        public MiRender() {
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (table.getValueAt(row, 8).toString().equals("false")) {
                cell.setBackground(new Color(0, 0, 102));
                cell.setForeground(Color.WHITE);
            } else if (table.getValueAt(row, 8).toString().equals("true")) {
                int xValor = Integer.parseInt(table.getValueAt(row, 12).toString());
                if (xValor == 1) {
                    cell.setBackground(Color.RED);
                    cell.setForeground(Color.BLACK);
                } else if (xValor == 2) {
                    cell.setBackground(Color.YELLOW);
                    cell.setForeground(Color.BLACK);
                } else if (xValor == 3) {
                    cell.setBackground(Color.GREEN);
                    cell.setForeground(Color.BLACK);
                } else if (xValor == 0) {
                    cell.setBackground(Color.WHITE);
                    cell.setForeground(Color.BLACK);
                }
            }
            return cell;
        }
    }
}
