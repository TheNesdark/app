package Historia;

import Acceso.Principal;
import General.JDBiometrico;
import Utilidades.ConsultasMySQL;
import Utilidades.JTextFieldValidator;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Historia/JPSo_Test_PRespiratorio.class */
public class JPSo_Test_PRespiratorio extends JPanel {
    private int xtipo;
    private Object[] xdatos;
    private String xsql;
    private DefaultTableModel xmodelo;
    private ButtonGroup JBGCambio;
    private ButtonGroup JBGControl;
    private ButtonGroup JBGRealizo;
    private ButtonGroup JBGResultado;
    private JPanel JPICambio;
    private JPanel JPIDatosP;
    private JPanel JPIResultado;
    private JPanel JPITipo;
    private JPanel JPITipo1;
    private JRadioButton JRBCNo;
    private JRadioButton JRBCSi;
    private JRadioButton JRBNo;
    private JRadioButton JRBRAprobada;
    private JRadioButton JRBRNo;
    private JRadioButton JRBRNoAprobada;
    private JRadioButton JRBRSi;
    private JRadioButton JRBSi;
    private JScrollPane JSPHistorico;
    private JScrollPane JSPObservacion;
    private JTextArea JTAObservacion;
    public JTable JTDetalleHistorico;
    private JTextFieldValidator JTFFValor;
    private JButton jButton2;
    private int xcontrol = -1;
    private int xresultado = -1;
    private int xcambio = -1;
    private int xrealiza = -1;
    public long xgrabado = 0;
    private ConsultasMySQL xct = new ConsultasMySQL();
    private Metodos xmt = new Metodos();

    public JPSo_Test_PRespiratorio(int xtipo) {
        initComponents();
        this.xtipo = xtipo;
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v98, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGControl = new ButtonGroup();
        this.JBGResultado = new ButtonGroup();
        this.JBGCambio = new ButtonGroup();
        this.JBGRealizo = new ButtonGroup();
        this.JPIDatosP = new JPanel();
        this.JPITipo = new JPanel();
        this.JRBSi = new JRadioButton();
        this.JRBNo = new JRadioButton();
        this.JPIResultado = new JPanel();
        this.JRBRAprobada = new JRadioButton();
        this.JRBRNoAprobada = new JRadioButton();
        this.JPICambio = new JPanel();
        this.JRBCSi = new JRadioButton();
        this.JRBCNo = new JRadioButton();
        this.JSPObservacion = new JScrollPane();
        this.JTAObservacion = new JTextArea();
        this.JTFFValor = new JTextFieldValidator();
        this.JPITipo1 = new JPanel();
        this.JRBRSi = new JRadioButton();
        this.JRBRNo = new JRadioButton();
        this.jButton2 = new JButton();
        this.JSPHistorico = new JScrollPane();
        this.JTDetalleHistorico = new JTable();
        setBorder(BorderFactory.createTitledBorder((Border) null, "TEST PROTECTOR RESPIRATORÍO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        setName("xjptest_prespiratorio");
        this.JPIDatosP.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JPITipo.setBorder(BorderFactory.createTitledBorder((Border) null, "Control", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBGControl.add(this.JRBSi);
        this.JRBSi.setFont(new Font("Arial", 1, 12));
        this.JRBSi.setText("Si");
        this.JRBSi.addActionListener(new ActionListener() { // from class: Historia.JPSo_Test_PRespiratorio.1
            public void actionPerformed(ActionEvent evt) {
                JPSo_Test_PRespiratorio.this.JRBSiActionPerformed(evt);
            }
        });
        this.JBGControl.add(this.JRBNo);
        this.JRBNo.setFont(new Font("Arial", 1, 12));
        this.JRBNo.setText("No");
        this.JRBNo.addActionListener(new ActionListener() { // from class: Historia.JPSo_Test_PRespiratorio.2
            public void actionPerformed(ActionEvent evt) {
                JPSo_Test_PRespiratorio.this.JRBNoActionPerformed(evt);
            }
        });
        GroupLayout JPITipoLayout = new GroupLayout(this.JPITipo);
        this.JPITipo.setLayout(JPITipoLayout);
        JPITipoLayout.setHorizontalGroup(JPITipoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPITipoLayout.createSequentialGroup().addContainerGap().addComponent(this.JRBSi).addGap(18, 18, 18).addComponent(this.JRBNo).addContainerGap(15, 32767)));
        JPITipoLayout.setVerticalGroup(JPITipoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPITipoLayout.createSequentialGroup().addContainerGap(-1, 32767).addGroup(JPITipoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBSi).addComponent(this.JRBNo))));
        this.JPIResultado.setBorder(BorderFactory.createTitledBorder((Border) null, "Resultado", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBGResultado.add(this.JRBRAprobada);
        this.JRBRAprobada.setFont(new Font("Arial", 1, 12));
        this.JRBRAprobada.setText("Aprobada");
        this.JRBRAprobada.addActionListener(new ActionListener() { // from class: Historia.JPSo_Test_PRespiratorio.3
            public void actionPerformed(ActionEvent evt) {
                JPSo_Test_PRespiratorio.this.JRBRAprobadaActionPerformed(evt);
            }
        });
        this.JBGResultado.add(this.JRBRNoAprobada);
        this.JRBRNoAprobada.setFont(new Font("Arial", 1, 12));
        this.JRBRNoAprobada.setText("No Aprobada");
        this.JRBRNoAprobada.addActionListener(new ActionListener() { // from class: Historia.JPSo_Test_PRespiratorio.4
            public void actionPerformed(ActionEvent evt) {
                JPSo_Test_PRespiratorio.this.JRBRNoAprobadaActionPerformed(evt);
            }
        });
        GroupLayout JPIResultadoLayout = new GroupLayout(this.JPIResultado);
        this.JPIResultado.setLayout(JPIResultadoLayout);
        JPIResultadoLayout.setHorizontalGroup(JPIResultadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIResultadoLayout.createSequentialGroup().addContainerGap().addComponent(this.JRBRAprobada).addGap(18, 18, 18).addComponent(this.JRBRNoAprobada).addContainerGap(-1, 32767)));
        JPIResultadoLayout.setVerticalGroup(JPIResultadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIResultadoLayout.createSequentialGroup().addContainerGap(-1, 32767).addGroup(JPIResultadoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBRAprobada).addComponent(this.JRBRNoAprobada))));
        this.JPICambio.setBorder(BorderFactory.createTitledBorder((Border) null, "Cambio de Protector?", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBGCambio.add(this.JRBCSi);
        this.JRBCSi.setFont(new Font("Arial", 1, 12));
        this.JRBCSi.setText("Si");
        this.JRBCSi.addActionListener(new ActionListener() { // from class: Historia.JPSo_Test_PRespiratorio.5
            public void actionPerformed(ActionEvent evt) {
                JPSo_Test_PRespiratorio.this.JRBCSiActionPerformed(evt);
            }
        });
        this.JBGCambio.add(this.JRBCNo);
        this.JRBCNo.setFont(new Font("Arial", 1, 12));
        this.JRBCNo.setText("No");
        this.JRBCNo.addActionListener(new ActionListener() { // from class: Historia.JPSo_Test_PRespiratorio.6
            public void actionPerformed(ActionEvent evt) {
                JPSo_Test_PRespiratorio.this.JRBCNoActionPerformed(evt);
            }
        });
        GroupLayout JPICambioLayout = new GroupLayout(this.JPICambio);
        this.JPICambio.setLayout(JPICambioLayout);
        JPICambioLayout.setHorizontalGroup(JPICambioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPICambioLayout.createSequentialGroup().addGap(18, 18, 18).addComponent(this.JRBCSi).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 21, 32767).addComponent(this.JRBCNo).addGap(20, 20, 20)));
        JPICambioLayout.setVerticalGroup(JPICambioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPICambioLayout.createSequentialGroup().addContainerGap(-1, 32767).addGroup(JPICambioLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBCSi).addComponent(this.JRBCNo))));
        this.JSPObservacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTAObservacion.setColumns(1);
        this.JTAObservacion.setFont(new Font("Arial", 1, 12));
        this.JTAObservacion.setLineWrap(true);
        this.JTAObservacion.setRows(1);
        this.JTAObservacion.setTabSize(1);
        this.JTAObservacion.setBorder((Border) null);
        this.JSPObservacion.setViewportView(this.JTAObservacion);
        this.JTFFValor.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFValor.setHorizontalAlignment(0);
        this.JTFFValor.setText("0");
        this.JTFFValor.setToolTipText("Valor Global");
        this.JTFFValor.setExprecionRegular("^[0.0-9]*$");
        this.JTFFValor.setFocusAccelerator('C');
        this.JTFFValor.setFont(new Font("Arial", 1, 12));
        this.JTFFValor.addFocusListener(new FocusAdapter() { // from class: Historia.JPSo_Test_PRespiratorio.7
            public void focusGained(FocusEvent evt) {
                JPSo_Test_PRespiratorio.this.JTFFValorFocusGained(evt);
            }
        });
        this.JPITipo1.setBorder(BorderFactory.createTitledBorder((Border) null, "Realiza Prueba", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBGRealizo.add(this.JRBRSi);
        this.JRBRSi.setFont(new Font("Arial", 1, 12));
        this.JRBRSi.setText("Si");
        this.JRBRSi.addActionListener(new ActionListener() { // from class: Historia.JPSo_Test_PRespiratorio.8
            public void actionPerformed(ActionEvent evt) {
                JPSo_Test_PRespiratorio.this.JRBRSiActionPerformed(evt);
            }
        });
        this.JBGRealizo.add(this.JRBRNo);
        this.JRBRNo.setFont(new Font("Arial", 1, 12));
        this.JRBRNo.setText("No");
        this.JRBRNo.addActionListener(new ActionListener() { // from class: Historia.JPSo_Test_PRespiratorio.9
            public void actionPerformed(ActionEvent evt) {
                JPSo_Test_PRespiratorio.this.JRBRNoActionPerformed(evt);
            }
        });
        GroupLayout JPITipo1Layout = new GroupLayout(this.JPITipo1);
        this.JPITipo1.setLayout(JPITipo1Layout);
        JPITipo1Layout.setHorizontalGroup(JPITipo1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPITipo1Layout.createSequentialGroup().addContainerGap().addComponent(this.JRBRSi).addGap(18, 18, 18).addComponent(this.JRBRNo).addContainerGap(15, 32767)));
        JPITipo1Layout.setVerticalGroup(JPITipo1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPITipo1Layout.createSequentialGroup().addContainerGap(-1, 32767).addGroup(JPITipo1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBRSi).addComponent(this.JRBRNo))));
        this.jButton2.setFont(new Font("Arial", 1, 12));
        this.jButton2.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Compras29x27.png")));
        this.jButton2.setText("<html><P ALIGN=center>Firmado por Biometría");
        this.jButton2.addActionListener(new ActionListener() { // from class: Historia.JPSo_Test_PRespiratorio.10
            public void actionPerformed(ActionEvent evt) {
                JPSo_Test_PRespiratorio.this.jButton2ActionPerformed(evt);
            }
        });
        GroupLayout JPIDatosPLayout = new GroupLayout(this.JPIDatosP);
        this.JPIDatosP.setLayout(JPIDatosPLayout);
        JPIDatosPLayout.setHorizontalGroup(JPIDatosPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosPLayout.createSequentialGroup().addGroup(JPIDatosPLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JSPObservacion, GroupLayout.Alignment.LEADING).addGroup(JPIDatosPLayout.createSequentialGroup().addContainerGap(14, 32767).addComponent(this.JPITipo1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JPITipo, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPIResultado, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPICambio, -2, -1, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPIDatosPLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTFFValor, -1, 143, 32767).addComponent(this.jButton2, -2, 0, 32767)).addContainerGap()));
        JPIDatosPLayout.setVerticalGroup(JPIDatosPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosPLayout.createSequentialGroup().addGroup(JPIDatosPLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JPITipo, -1, -1, 32767).addComponent(this.JPIResultado, -1, -1, 32767).addComponent(this.JPICambio, -1, -1, 32767).addComponent(this.JTFFValor, -1, -1, 32767).addComponent(this.JPITipo1, -1, -1, 32767)).addGap(18, 18, 18).addGroup(JPIDatosPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPObservacion).addGroup(JPIDatosPLayout.createSequentialGroup().addGap(0, 103, 32767).addComponent(this.jButton2, -2, 50, -2))).addContainerGap()));
        this.JSPHistorico.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.JTDetalleHistorico.setFont(new Font("Arial", 1, 12));
        this.JTDetalleHistorico.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalleHistorico.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalleHistorico.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalleHistorico.addMouseListener(new MouseAdapter() { // from class: Historia.JPSo_Test_PRespiratorio.11
            public void mouseClicked(MouseEvent evt) {
                JPSo_Test_PRespiratorio.this.JTDetalleHistoricoMouseClicked(evt);
            }
        });
        this.JSPHistorico.setViewportView(this.JTDetalleHistorico);
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPIDatosP, -1, -1, 32767).addComponent(this.JSPHistorico, -1, 840, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.JPIDatosP, -1, -1, 32767).addGap(18, 18, 18).addComponent(this.JSPHistorico, -2, 279, -2).addGap(21, 21, 21)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBSiActionPerformed(ActionEvent evt) {
        this.xcontrol = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBNoActionPerformed(ActionEvent evt) {
        this.xcontrol = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBRAprobadaActionPerformed(ActionEvent evt) {
        this.xresultado = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBRNoAprobadaActionPerformed(ActionEvent evt) {
        this.xresultado = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBCSiActionPerformed(ActionEvent evt) {
        this.xcambio = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBCNoActionPerformed(ActionEvent evt) {
        this.xcambio = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleHistoricoMouseClicked(MouseEvent evt) {
        if (this.JTDetalleHistorico.getSelectedRow() != -1) {
            this.xgrabado = Long.valueOf(this.xmodelo.getValueAt(this.JTDetalleHistorico.getSelectedRow(), 0).toString()).longValue();
            if (Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalleHistorico.getSelectedRow(), 2).toString()).booleanValue()) {
                this.JRBSi.setSelected(true);
                this.xcontrol = 1;
            } else {
                this.JRBNo.setSelected(true);
                this.xcontrol = 0;
            }
            if (Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalleHistorico.getSelectedRow(), 3).toString()).booleanValue()) {
                this.JRBRAprobada.setSelected(true);
                this.xresultado = 1;
            } else {
                this.JRBRAprobada.setSelected(true);
                this.xresultado = 0;
            }
            if (Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalleHistorico.getSelectedRow(), 4).toString()).booleanValue()) {
                this.JRBCSi.setSelected(true);
                this.xcambio = 1;
            } else {
                this.JRBCNo.setSelected(true);
                this.xcambio = 0;
            }
            this.JTAObservacion.setText(this.xmodelo.getValueAt(this.JTDetalleHistorico.getSelectedRow(), 5).toString());
            this.xmt.mostrarPdf(this.xmt.mTraerUrlBD(this.xmodelo.getValueAt(this.JTDetalleHistorico.getSelectedRow(), 7).toString()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFValorFocusGained(FocusEvent evt) {
        this.JTFFValor.selectAll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBRSiActionPerformed(ActionEvent evt) {
        this.xrealiza = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBRNoActionPerformed(ActionEvent evt) {
        this.xrealiza = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jButton2ActionPerformed(ActionEvent evt) {
        if (this.xgrabado != 0 && this.xtipo == 1) {
            JDBiometrico xjdBiometrico = new JDBiometrico(null, true, getName(), String.valueOf(this.xgrabado));
            xjdBiometrico.setTemplate(null);
            xjdBiometrico.setVisible(true);
        }
    }

    public void mNuevo() {
        this.xcontrol = -1;
        this.xresultado = -1;
        this.xgrabado = 0L;
        this.JRBRAprobada.setSelected(false);
        this.JRBRNoAprobada.setSelected(false);
        this.JRBSi.setSelected(false);
        this.JRBNo.setSelected(false);
        this.JRBCSi.setSelected(false);
        this.JRBCNo.setSelected(false);
        this.JRBRSi.setSelected(false);
        this.JRBRNo.setSelected(false);
        if (this.xtipo == 0) {
            setBorder(BorderFactory.createTitledBorder((Border) null, "TEST PROTECTOR RESPIRATORÍO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
            this.JPICambio.setBorder(BorderFactory.createTitledBorder((Border) null, "Cambio de Protector?", 2, 0, new Font("Arial", 1, 12), Color.blue));
            this.JTFFValor.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
            this.JTFFValor.setToolTipText("Valor Global");
        } else {
            setBorder(BorderFactory.createTitledBorder((Border) null, "TEST PROTECTOR AUDITIVO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
            this.JPICambio.setBorder(BorderFactory.createTitledBorder((Border) null, "Realiza Reentrenamiento?", 2, 0, new Font("Arial", 1, 12), Color.blue));
            this.JTFFValor.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor Atenuación", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
            this.JTFFValor.setToolTipText("Valor Atenuación");
        }
        mCargarDatosTabla();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloHistorico() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Fecha", "Control", "Resultado", "CProtector", "Observación", "Profesional", "UrlSoporte", "Valor"}) { // from class: Historia.JPSo_Test_PRespiratorio.12
            Class[] types = {Long.class, String.class, Boolean.class, Boolean.class, Boolean.class, String.class, String.class, String.class, Double.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalleHistorico.setModel(this.xmodelo);
        this.JTDetalleHistorico.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTDetalleHistorico.getColumnModel().getColumn(1).setPreferredWidth(10);
        this.JTDetalleHistorico.getColumnModel().getColumn(2).setPreferredWidth(10);
        this.JTDetalleHistorico.getColumnModel().getColumn(3).setPreferredWidth(10);
        this.JTDetalleHistorico.getColumnModel().getColumn(4).setPreferredWidth(10);
        this.JTDetalleHistorico.getColumnModel().getColumn(5).setPreferredWidth(250);
        this.JTDetalleHistorico.getColumnModel().getColumn(6).setPreferredWidth(80);
        this.JTDetalleHistorico.getColumnModel().getColumn(7).setPreferredWidth(10);
        this.JTDetalleHistorico.getColumnModel().getColumn(8).setPreferredWidth(10);
    }

    private void mCargarDatosTabla() {
        try {
            mCrearModeloHistorico();
            if (this.xtipo == 0) {
                this.xsql = "SELECT  `h_so_test_prespiratorio`.`Id` , `ingreso`.`FechaIngreso` , `h_so_test_prespiratorio`.`Control` , `h_so_test_prespiratorio`.`Resultado` , `h_so_test_prespiratorio`.`CProtector` , `h_so_test_prespiratorio`.`Observacion` , `profesional1`.`NProfesional` , DATE_FORMAT(`FechaIngreso`,'%Y'), CONCAT(MID(DevuelveMes(`FechaIngreso`),1, 1),'',LOWER(MID(DevuelveMes(`FechaIngreso`),2, LENGTH(DevuelveMes(`FechaIngreso`))))) AS Mes,  h_so_test_prespiratorio.UrlSoporte,  h_so_test_prespiratorio.VGlobal FROM  `profesional1` INNER JOIN `h_so_test_prespiratorio`  ON (`profesional1`.`IdEspecialidad` = `h_so_test_prespiratorio`.`Id_Especialidad`) AND (`profesional1`.`Id_Persona` = `h_so_test_prespiratorio`.`Id_Profesional`) INNER JOIN  `ingreso`  ON (`ingreso`.`Id` = `h_so_test_prespiratorio`.`Id_Ingreso`) WHERE (`h_so_test_prespiratorio`.`Estado` =1 AND `ingreso`.`Id_Usuario` ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "')  ORDER BY `ingreso`.`FechaIngreso` DESC";
            } else {
                this.xsql = "SELECT  `h_so_test_auditivo`.`Id` , `ingreso`.`FechaIngreso` , `h_so_test_auditivo`.`Control` , `h_so_test_auditivo`.`Resultado` , `h_so_test_auditivo`.`Reentrenamiento` , `h_so_test_auditivo`.`Observacion` , `profesional1`.`NProfesional` , DATE_FORMAT(`FechaIngreso`,'%Y'), CONCAT(MID(DevuelveMes(`FechaIngreso`),1, 1),'',LOWER(MID(DevuelveMes(`FechaIngreso`),2, LENGTH(DevuelveMes(`FechaIngreso`))))) AS Mes,  h_so_test_auditivo.UrlSoporte,  h_so_test_auditivo.VGlobal FROM  `profesional1` INNER JOIN `h_so_test_auditivo`  ON (`profesional1`.`IdEspecialidad` = `h_so_test_auditivo`.`Id_Especialidad`) AND (`profesional1`.`Id_Persona` = `h_so_test_auditivo`.`Id_Profesional`) INNER JOIN  `ingreso`  ON (`ingreso`.`Id` = `h_so_test_auditivo`.`Id_Ingreso`) WHERE (`h_so_test_auditivo`.`Estado` =1 AND `ingreso`.`Id_Usuario` ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "')  ORDER BY `ingreso`.`FechaIngreso` DESC";
            }
            ResultSet xrs = this.xct.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int x = 0;
                this.xmt.mEstablecerTextEditor(this.JTDetalleHistorico, 6);
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(1)), x, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), x, 1);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(3)), x, 2);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(4)), x, 3);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(5)), x, 4);
                    this.xmodelo.setValueAt(xrs.getString(6), x, 5);
                    this.xmodelo.setValueAt(xrs.getString(7), x, 6);
                    this.xmodelo.setValueAt(xrs.getString(10), x, 7);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(11)), x, 8);
                    x++;
                }
                this.xmt.cambiarEstadoValidadoItemHC(getName(), 1, true);
            } else {
                mCrearModeloHistorico();
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPSo_Test_PRespiratorio.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mGrabar() {
        if (this.xgrabado == 0) {
            if (this.xrealiza == 1) {
                if (this.xresultado != -1) {
                    int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    if (x == 0) {
                        if (this.xtipo == 0) {
                            this.xsql = "insert into h_so_test_prespiratorio (`Id_Atencion`, `Id_Ingreso`, `Realizo`,`Control`, `Resultado`, `CProtector`, `Observacion`, VGlobal, `Id_Especialidad`, `Id_Profesional`, `UsuarioS`)  values('" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "','" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdIngreso() + "','" + this.xrealiza + "','" + this.xcontrol + "','" + this.xresultado + "','" + this.xcambio + "','" + this.JTAObservacion.getText() + "','" + this.JTFFValor.getText().replaceAll(",", ".") + "','" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                        } else {
                            this.xsql = "insert into h_so_test_auditivo (`Id_Atencion`, `Id_Ingreso`, `Realizo`,`Control`, `Resultado`, `Reentrenamiento`, `Observacion`, VGlobal, `Id_Especialidad`, `Id_Profesional`, `UsuarioS`)  values('" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "','" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdIngreso() + "','" + this.xrealiza + "','" + this.xcontrol + "','" + this.xresultado + "','" + this.xcambio + "','" + this.JTAObservacion.getText() + "','" + this.JTFFValor.getText().replaceAll(",", ".") + "','" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                        }
                        this.xgrabado = Long.valueOf(this.xct.ejecutarSQLId(this.xsql)).longValue();
                        Principal.clasehistoriace.mCambiarEstadoOrdenProcedimiento();
                        this.xmt.cambiarEstadoValidadoItemHC(getName(), 1, true);
                        mCargarDatosTabla();
                        return;
                    }
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar el resultado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                return;
            }
            int x2 = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x2 == 0) {
                if (this.xtipo == 0) {
                    this.xsql = "insert into h_so_test_prespiratorio (`Id_Atencion`, `Id_Ingreso`, `Realizo`,`Control`, `Resultado`, `CProtector`, `Observacion`, VGlobal, `Id_Especialidad`, `Id_Profesional`, `UsuarioS`)  values('" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "','" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdIngreso() + "','" + this.xrealiza + "','" + this.xcontrol + "','" + this.xresultado + "','" + this.xcambio + "','" + this.JTAObservacion.getText() + "','" + this.JTFFValor.getText().replaceAll(",", ".") + "','" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                } else {
                    this.xsql = "insert into h_so_test_auditivo (`Id_Atencion`, `Id_Ingreso`, `Realizo`,`Control`, `Resultado`, `Reentrenamiento`, `Observacion`, VGlobal, `Id_Especialidad`, `Id_Profesional`, `UsuarioS`)  values('" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "','" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdIngreso() + "','" + this.xrealiza + "','" + this.xcontrol + "','" + this.xresultado + "','" + this.xcambio + "','" + this.JTAObservacion.getText() + "','" + this.JTFFValor.getText().replaceAll(",", ".") + "','" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                }
                this.xgrabado = Long.valueOf(this.xct.ejecutarSQLId(this.xsql)).longValue();
                Principal.clasehistoriace.mCambiarEstadoOrdenProcedimiento();
                this.xmt.cambiarEstadoValidadoItemHC(getName(), 1, true);
                mCargarDatosTabla();
                return;
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Registro ya grabado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    public void mImprimir() {
        String[][] mparametros = new String[3][2];
        mparametros[0][0] = "Id";
        mparametros[0][1] = this.xmodelo.getValueAt(this.JTDetalleHistorico.getSelectedRow(), 0).toString();
        mparametros[1][0] = "SUBREPORT_DIR";
        mparametros[1][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
        mparametros[2][0] = "SUBREPORTFIRMA_DIR";
        mparametros[2][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
        if (this.xtipo == 0) {
            this.xmt.GenerarPDF(this.xmt.getRutaRep() + "H_So_Test_Respitarorio_AS", mparametros);
        } else {
            this.xmt.GenerarPDF(this.xmt.getRutaRep() + "H_So_Test_Auditivo_AS_1", mparametros);
        }
    }
}
