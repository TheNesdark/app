package Contabilidad;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import Utilidades.WorkerSQL;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
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
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Contabilidad/JIFEstadosFinanc_Comparativos.class */
public class JIFEstadosFinanc_Comparativos extends JInternalFrame {
    private String[][] xid;
    private String xPadre;
    private String xcc_documentoc;
    private DefaultTableModel xmodelo2;
    private Object[] xdatos;
    private String xTitulo;
    private WorkerSQL xWorkerSQL;
    private ButtonGroup JBGEstadoFinanciero;
    private ButtonGroup JBGNivel;
    private ButtonGroup JBGTipoMovimiento;
    private JButton JBTExportar;
    private JCheckBox JCH_EsPorPeriodo;
    private JCheckBox JCH_PeriodoCierre;
    private JDateChooser JDCFechaFin;
    private JDateChooser JDCFechaInicio;
    private JPanel JPI_Est_Financiero;
    private JPanel JPI_Nivel;
    private JPanel JPI_TipoCuenta;
    private JPanel JPI_TipoCuentas;
    private JRadioButton JRB_BalanceGeneral;
    private JRadioButton JRB_Clase;
    private JRadioButton JRB_Cuenta;
    private JRadioButton JRB_EsColgaap;
    private JRadioButton JRB_EsNiif;
    private JRadioButton JRB_Grupo;
    private JRadioButton JRB_PerdidasGanancias;
    private JTextField JTFRuta;
    private JTable JTH_Detalle;
    private JScrollPane jScrollPane1;
    private ConsultasMySQL xct = new ConsultasMySQL();
    private int xNCaracter = 0;
    private final int xM = 2;
    private String[] x6 = new String[4];
    private String[] x8 = new String[5];
    private String[] x10 = new String[6];
    private String[] x12 = new String[7];
    private String xcc_detalle = "";
    private String xaux = "dd.Id_Puc";
    private String xnivel = " na.id_clase,\n na.nbre_clase,";
    private String xestadoFinanciero = " IN(1,2,3)\n ";
    private String xcc_puc = "cc_puc";
    private String incluirPeriodoCierre = "IN(0,1)";
    private String xAplicaNiif = "IN (0)\n";
    private Metodos xmt = new Metodos();
    String comentarioNiif = null;

    public JIFEstadosFinanc_Comparativos(String xTitulo) {
        initComponents();
        setTitle(xTitulo.toUpperCase());
        this.xTitulo = xTitulo;
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v93, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGEstadoFinanciero = new ButtonGroup();
        this.JBGNivel = new ButtonGroup();
        this.JBGTipoMovimiento = new ButtonGroup();
        this.JPI_TipoCuenta = new JPanel();
        this.JDCFechaInicio = new JDateChooser();
        this.JDCFechaFin = new JDateChooser();
        this.JPI_Est_Financiero = new JPanel();
        this.JRB_BalanceGeneral = new JRadioButton();
        this.JRB_PerdidasGanancias = new JRadioButton();
        this.JPI_Nivel = new JPanel();
        this.JRB_Clase = new JRadioButton();
        this.JRB_Grupo = new JRadioButton();
        this.JRB_Cuenta = new JRadioButton();
        this.JPI_TipoCuentas = new JPanel();
        this.JRB_EsColgaap = new JRadioButton();
        this.JRB_EsNiif = new JRadioButton();
        this.JCH_PeriodoCierre = new JCheckBox();
        this.JCH_EsPorPeriodo = new JCheckBox();
        this.jScrollPane1 = new JScrollPane();
        this.JTH_Detalle = new JTable();
        this.JTFRuta = new JTextField();
        this.JBTExportar = new JButton();
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("ESTADOS FINANCIEROS");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjif_estadofinancierocomparativo");
        this.JPI_TipoCuenta.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JDCFechaInicio.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicio", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFechaInicio.setDateFormatString("dd/MM/yyyy");
        this.JDCFechaInicio.setFont(new Font("Arial", 1, 12));
        this.JDCFechaFin.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Fin", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFechaFin.setDateFormatString("dd/MM/yyyy");
        this.JDCFechaFin.setFont(new Font("Arial", 1, 12));
        this.JPI_Est_Financiero.setBorder(BorderFactory.createTitledBorder((Border) null, "ESTADO FINANCIERO", 2, 0, new Font("Arial", 1, 12), Color.red));
        this.JBGEstadoFinanciero.add(this.JRB_BalanceGeneral);
        this.JRB_BalanceGeneral.setFont(new Font("Arial", 1, 12));
        this.JRB_BalanceGeneral.setSelected(true);
        this.JRB_BalanceGeneral.setText("Balance General");
        this.JRB_BalanceGeneral.addActionListener(new ActionListener() { // from class: Contabilidad.JIFEstadosFinanc_Comparativos.1
            public void actionPerformed(ActionEvent evt) {
                JIFEstadosFinanc_Comparativos.this.JRB_BalanceGeneralActionPerformed(evt);
            }
        });
        this.JBGEstadoFinanciero.add(this.JRB_PerdidasGanancias);
        this.JRB_PerdidasGanancias.setFont(new Font("Arial", 1, 12));
        this.JRB_PerdidasGanancias.setText("Estado de Resultado");
        this.JRB_PerdidasGanancias.setHorizontalAlignment(11);
        this.JRB_PerdidasGanancias.addActionListener(new ActionListener() { // from class: Contabilidad.JIFEstadosFinanc_Comparativos.2
            public void actionPerformed(ActionEvent evt) {
                JIFEstadosFinanc_Comparativos.this.JRB_PerdidasGananciasActionPerformed(evt);
            }
        });
        GroupLayout JPI_Est_FinancieroLayout = new GroupLayout(this.JPI_Est_Financiero);
        this.JPI_Est_Financiero.setLayout(JPI_Est_FinancieroLayout);
        JPI_Est_FinancieroLayout.setHorizontalGroup(JPI_Est_FinancieroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_Est_FinancieroLayout.createSequentialGroup().addGap(15, 15, 15).addGroup(JPI_Est_FinancieroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JRB_PerdidasGanancias).addComponent(this.JRB_BalanceGeneral)).addGap(0, 55, 32767)));
        JPI_Est_FinancieroLayout.setVerticalGroup(JPI_Est_FinancieroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_Est_FinancieroLayout.createSequentialGroup().addContainerGap().addComponent(this.JRB_BalanceGeneral, -2, 23, -2).addGap(18, 18, 18).addComponent(this.JRB_PerdidasGanancias).addContainerGap(16, 32767)));
        this.JPI_Nivel.setBorder(BorderFactory.createTitledBorder((Border) null, "NIVEL", 2, 0, new Font("Arial", 1, 12), Color.red));
        this.JBGNivel.add(this.JRB_Clase);
        this.JRB_Clase.setFont(new Font("Arial", 1, 12));
        this.JRB_Clase.setSelected(true);
        this.JRB_Clase.setText("Clase");
        this.JRB_Clase.addActionListener(new ActionListener() { // from class: Contabilidad.JIFEstadosFinanc_Comparativos.3
            public void actionPerformed(ActionEvent evt) {
                JIFEstadosFinanc_Comparativos.this.JRB_ClaseActionPerformed(evt);
            }
        });
        this.JBGNivel.add(this.JRB_Grupo);
        this.JRB_Grupo.setFont(new Font("Arial", 1, 12));
        this.JRB_Grupo.setText("Grupo");
        this.JRB_Grupo.setHorizontalAlignment(11);
        this.JRB_Grupo.addActionListener(new ActionListener() { // from class: Contabilidad.JIFEstadosFinanc_Comparativos.4
            public void actionPerformed(ActionEvent evt) {
                JIFEstadosFinanc_Comparativos.this.JRB_GrupoActionPerformed(evt);
            }
        });
        this.JBGNivel.add(this.JRB_Cuenta);
        this.JRB_Cuenta.setFont(new Font("Arial", 1, 12));
        this.JRB_Cuenta.setText("Cuenta");
        this.JRB_Cuenta.setHorizontalAlignment(11);
        this.JRB_Cuenta.addActionListener(new ActionListener() { // from class: Contabilidad.JIFEstadosFinanc_Comparativos.5
            public void actionPerformed(ActionEvent evt) {
                JIFEstadosFinanc_Comparativos.this.JRB_CuentaActionPerformed(evt);
            }
        });
        GroupLayout JPI_NivelLayout = new GroupLayout(this.JPI_Nivel);
        this.JPI_Nivel.setLayout(JPI_NivelLayout);
        JPI_NivelLayout.setHorizontalGroup(JPI_NivelLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_NivelLayout.createSequentialGroup().addContainerGap().addGroup(JPI_NivelLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_NivelLayout.createSequentialGroup().addComponent(this.JRB_Cuenta).addContainerGap(89, 32767)).addGroup(JPI_NivelLayout.createSequentialGroup().addGroup(JPI_NivelLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JRB_Clase).addComponent(this.JRB_Grupo)).addGap(0, 0, 32767)))));
        JPI_NivelLayout.setVerticalGroup(JPI_NivelLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_NivelLayout.createSequentialGroup().addComponent(this.JRB_Clase).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRB_Grupo, -2, 23, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRB_Cuenta).addContainerGap(12, 32767)));
        this.JPI_TipoCuentas.setBorder(BorderFactory.createTitledBorder((Border) null, "TIPO CUENTAS", 2, 0, new Font("Arial", 1, 12), Color.red));
        this.JBGTipoMovimiento.add(this.JRB_EsColgaap);
        this.JRB_EsColgaap.setFont(new Font("Arial", 1, 12));
        this.JRB_EsColgaap.setSelected(true);
        this.JRB_EsColgaap.setText("Colgaap");
        this.JRB_EsColgaap.addActionListener(new ActionListener() { // from class: Contabilidad.JIFEstadosFinanc_Comparativos.6
            public void actionPerformed(ActionEvent evt) {
                JIFEstadosFinanc_Comparativos.this.JRB_EsColgaapActionPerformed(evt);
            }
        });
        this.JBGTipoMovimiento.add(this.JRB_EsNiif);
        this.JRB_EsNiif.setFont(new Font("Arial", 1, 12));
        this.JRB_EsNiif.setText("Niif");
        this.JRB_EsNiif.setHorizontalAlignment(11);
        this.JRB_EsNiif.addActionListener(new ActionListener() { // from class: Contabilidad.JIFEstadosFinanc_Comparativos.7
            public void actionPerformed(ActionEvent evt) {
                JIFEstadosFinanc_Comparativos.this.JRB_EsNiifActionPerformed(evt);
            }
        });
        GroupLayout JPI_TipoCuentasLayout = new GroupLayout(this.JPI_TipoCuentas);
        this.JPI_TipoCuentas.setLayout(JPI_TipoCuentasLayout);
        JPI_TipoCuentasLayout.setHorizontalGroup(JPI_TipoCuentasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_TipoCuentasLayout.createSequentialGroup().addGap(15, 15, 15).addGroup(JPI_TipoCuentasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JRB_EsNiif).addComponent(this.JRB_EsColgaap)).addGap(0, 42, 32767)));
        JPI_TipoCuentasLayout.setVerticalGroup(JPI_TipoCuentasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_TipoCuentasLayout.createSequentialGroup().addContainerGap().addComponent(this.JRB_EsColgaap).addGap(18, 18, 18).addComponent(this.JRB_EsNiif).addContainerGap(16, 32767)));
        this.JCH_PeriodoCierre.setFont(new Font("Arial", 1, 12));
        this.JCH_PeriodoCierre.setSelected(true);
        this.JCH_PeriodoCierre.setText("Incluir periodo de cierre?");
        this.JCH_PeriodoCierre.addActionListener(new ActionListener() { // from class: Contabilidad.JIFEstadosFinanc_Comparativos.8
            public void actionPerformed(ActionEvent evt) {
                JIFEstadosFinanc_Comparativos.this.JCH_PeriodoCierreActionPerformed(evt);
            }
        });
        this.JCH_EsPorPeriodo.setFont(new Font("Arial", 1, 12));
        this.JCH_EsPorPeriodo.setSelected(true);
        this.JCH_EsPorPeriodo.setText("es por periodo?");
        this.JCH_EsPorPeriodo.addActionListener(new ActionListener() { // from class: Contabilidad.JIFEstadosFinanc_Comparativos.9
            public void actionPerformed(ActionEvent evt) {
                JIFEstadosFinanc_Comparativos.this.JCH_EsPorPeriodoActionPerformed(evt);
            }
        });
        GroupLayout JPI_TipoCuentaLayout = new GroupLayout(this.JPI_TipoCuenta);
        this.JPI_TipoCuenta.setLayout(JPI_TipoCuentaLayout);
        JPI_TipoCuentaLayout.setHorizontalGroup(JPI_TipoCuentaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_TipoCuentaLayout.createSequentialGroup().addContainerGap().addComponent(this.JPI_TipoCuentas, -2, -1, -2).addGap(10, 10, 10).addComponent(this.JPI_Est_Financiero, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPI_Nivel, -2, -1, -2).addGap(18, 18, 18).addGroup(JPI_TipoCuentaLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JDCFechaFin, -1, 138, 32767).addComponent(this.JDCFechaInicio, -1, -1, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPI_TipoCuentaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCH_PeriodoCierre).addComponent(this.JCH_EsPorPeriodo)).addContainerGap(-1, 32767)));
        JPI_TipoCuentaLayout.setVerticalGroup(JPI_TipoCuentaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPI_TipoCuentaLayout.createSequentialGroup().addContainerGap(-1, 32767).addGroup(JPI_TipoCuentaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPI_TipoCuentaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPI_Est_Financiero, -2, -1, -2).addComponent(this.JPI_TipoCuentas, -2, -1, -2)).addGroup(GroupLayout.Alignment.TRAILING, JPI_TipoCuentaLayout.createSequentialGroup().addGroup(JPI_TipoCuentaLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JDCFechaInicio, -2, 54, -2).addComponent(this.JCH_EsPorPeriodo)).addGroup(JPI_TipoCuentaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_TipoCuentaLayout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JDCFechaFin, -2, 51, -2)).addGroup(JPI_TipoCuentaLayout.createSequentialGroup().addGap(26, 26, 26).addComponent(this.JCH_PeriodoCierre)))).addComponent(this.JPI_Nivel, GroupLayout.Alignment.TRAILING, -2, -1, -2)).addGap(299, 299, 299)));
        this.jScrollPane1.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.jScrollPane1.setName("xjifestadofinancomparativo");
        this.jScrollPane1.setOpaque(false);
        this.JTH_Detalle.setFont(new Font("Arial", 1, 12));
        this.JTH_Detalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTH_Detalle.setRowHeight(25);
        this.JTH_Detalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTH_Detalle.setSelectionForeground(Color.red);
        this.jScrollPane1.setViewportView(this.JTH_Detalle);
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.setName("xjif_balancefecha");
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: Contabilidad.JIFEstadosFinanc_Comparativos.10
            public void mouseClicked(MouseEvent evt) {
                JIFEstadosFinanc_Comparativos.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setForeground(Color.red);
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: Contabilidad.JIFEstadosFinanc_Comparativos.11
            public void actionPerformed(ActionEvent evt) {
                JIFEstadosFinanc_Comparativos.this.JBTExportarActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.JTFRuta, -2, 398, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBTExportar, -2, 128, -2).addGap(869, 869, 869)).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane1).addComponent(this.JPI_TipoCuenta, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.JPI_TipoCuenta, -2, 166, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane1, -2, 458, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFRuta, -2, 50, -2).addComponent(this.JBTExportar, -2, 50, -2)).addContainerGap(-1, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JFileChooser xfilec = new JFileChooser(this.JTFRuta.getText());
            xfilec.setFileSelectionMode(1);
            int xv = xfilec.showOpenDialog(this);
            if (xv == 0) {
                File xfile = xfilec.getSelectedFile();
                this.JTFRuta.setText(xfile.getAbsolutePath() + this.xmt.getBarra());
                this.JTFRuta.requestFocus();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTExportarActionPerformed(ActionEvent evt) {
        if (!this.JTFRuta.getText().isEmpty()) {
            if (this.JTH_Detalle.getRowCount() > -1) {
                int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (n == 0) {
                    this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTH_Detalle, this.xmt.mTraerUrlBD(this.JTFRuta.getText()), getTitle());
                    return;
                }
                return;
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un ruta valida", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JTFRuta.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_BalanceGeneralActionPerformed(ActionEvent evt) {
        this.xestadoFinanciero = " IN(1,2,3)\n ";
        this.JCH_PeriodoCierre.setSelected(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_PerdidasGananciasActionPerformed(ActionEvent evt) {
        this.xestadoFinanciero = " IN(4,5,6)\n ";
        this.JCH_PeriodoCierre.setSelected(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_ClaseActionPerformed(ActionEvent evt) {
        this.xnivel = "na.id_clase,\nna.nbre_clase,";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_GrupoActionPerformed(ActionEvent evt) {
        this.xnivel = "na.id_clase,\nna.nbre_clase,\nna.id_grupo,\nna.nbre_grupo,";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_CuentaActionPerformed(ActionEvent evt) {
        this.xnivel = "na.id_clase,\nna.nbre_clase,\nna.id_grupo,\nna.nbre_grupo,na.id_cuenta,\nna.nbre_cuenta,";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_EsNiifActionPerformed(ActionEvent evt) {
        this.xAplicaNiif = "IN (0,1)\n ";
        this.xcc_puc = "cc_puc_niif ";
        this.xaux = "pn.Id_Puc_Niif";
        this.xcc_detalle = "INNER JOIN cc_pucg_niif pn\nON pn.Id_Puc_G=pu.id\nINNER JOIN cc_puc_niif ni\nON ni.id=pn.Id_Puc_Niif\n";
        this.comentarioNiif = "Elaborado Bajo Normas Internacionales de Información Financiera";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_EsColgaapActionPerformed(ActionEvent evt) {
        this.xAplicaNiif = "IN (0)\n ";
        this.xcc_detalle = "";
        this.xaux = "dd.Id_Puc";
        this.comentarioNiif = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_PeriodoCierreActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_EsPorPeriodoActionPerformed(ActionEvent evt) {
    }

    public void mBuscar() {
        this.xWorkerSQL = null;
        this.xWorkerSQL = new WorkerSQL("Cargando la Informacion...", this);
        this.xWorkerSQL.execute();
    }

    public void mBuscarM() {
        String sql;
        String titulo;
        String xanno_inicio = this.xmt.formatoANO.format(this.JDCFechaInicio.getDate());
        String xanno_fin = this.xmt.formatoANO.format(this.JDCFechaFin.getDate());
        if (this.JCH_PeriodoCierre.isSelected()) {
            this.incluirPeriodoCierre = "IN(0,1)";
        } else {
            this.incluirPeriodoCierre = "IN(0)";
        }
        if (this.JCH_EsPorPeriodo.isSelected()) {
            sql = "WITH nv_clase AS (\nSELECT id  id_clase,\n       nbre nbre_clase\nFROM  " + this.xcc_puc + "\nWHERE id_nivel=1\n)\n,nv_grupo AS (\nSELECT c.*, p.id  id_grupo,\n       p.nbre nbre_grupo\n       \nFROM  " + this.xcc_puc + " p\nINNER JOIN nv_clase c\nON p.id_Padre=c.id_clase\nWHERE p.id_nivel=2\n)\n\n,nv_cuenta AS (\nSELECT g.*, p.id  id_cuenta,\n       p.nbre nbre_cuenta\n       \nFROM  " + this.xcc_puc + " p\nINNER JOIN nv_grupo g\nON p.id_Padre=g.id_grupo\nWHERE p.id_nivel=3\n)\n\n,nv_subcuenta AS (\nSELECT g.*, p.id  id_subcuenta,\n       p.nbre nbre_subcuenta\n       \nFROM  " + this.xcc_puc + " p\nINNER JOIN nv_cuenta g\nON p.id_Padre=g.id_cuenta\nWHERE p.id_nivel=4\n)\n\n,nv_auxiliar AS (\nSELECT g.*, p.id  id_auxiliar,\n       p.nbre nbre_auxiliar,\n       p.UNivel\n       \nFROM  " + this.xcc_puc + " p\nINNER JOIN nv_subcuenta g\nON p.id_Padre=g.id_subcuenta\nWHERE p.id_nivel=5\n)\n\n, set_datos AS \n(\nSELECT dd.id_Puc, SUBSTR(" + this.xaux + ",1,8) id_puc_aux,  DATE_FORMAT(FechaD, '%Y') anno, pu.tipo, dd.VDebito, dd.VCredito,\nCASE WHEN  pu.Tipo=0 THEN \n ROUND(dd.VDebito,2) - ROUND(dd.VCredito,2)\nELSE\n  ROUND(dd.VCredito,2) - ROUND(dd.VDebito,2) \nEND saldo\n\n  FROM cc_documentoc d\nINNER JOIN cc_detalle_documentoc dd\nON d.id=dd.id_documentoc\nINNER JOIN cc_puc pu\nON dd.Id_Puc=pu.id\n" + this.xcc_detalle + "INNER JOIN cc_periodo_contable pc\nON d.Id_PeriodoC=pc.id\nINNER JOIN cc_tipo_documentoc td\nON d.Id_TipoComprobante=td.id\nWHERE pc.Escierre " + this.incluirPeriodoCierre + " AND td.Es_Niif " + this.xAplicaNiif + "AND d.estado=1\nAND pu.AplicaNiif " + this.xAplicaNiif + "AND(d.FechaD >='" + this.xmt.formatoAMD1.format(this.JDCFechaInicio.getDate()) + "'   AND  d.FechaD <='" + this.xmt.formatoAMD1.format(this.JDCFechaFin.getDate()) + "')\n) \n";
        } else {
            sql = "WITH nv_clase AS (\nSELECT id  id_clase,\n       nbre nbre_clase\nFROM  " + this.xcc_puc + "\nWHERE id_nivel=1\n)\n,nv_grupo AS (\nSELECT c.*, p.id  id_grupo,\n       p.nbre nbre_grupo\n       \nFROM  " + this.xcc_puc + " p\nINNER JOIN nv_clase c\nON p.id_Padre=c.id_clase\nWHERE p.id_nivel=2\n)\n\n,nv_cuenta AS (\nSELECT g.*, p.id  id_cuenta,\n       p.nbre nbre_cuenta\n       \nFROM  " + this.xcc_puc + " p\nINNER JOIN nv_grupo g\nON p.id_Padre=g.id_grupo\nWHERE p.id_nivel=3\n)\n\n,nv_subcuenta AS (\nSELECT g.*, p.id  id_subcuenta,\n       p.nbre nbre_subcuenta\n       \nFROM  " + this.xcc_puc + " p\nINNER JOIN nv_cuenta g\nON p.id_Padre=g.id_cuenta\nWHERE p.id_nivel=4\n)\n\n,nv_auxiliar AS (\nSELECT g.*, p.id  id_auxiliar,\n       p.nbre nbre_auxiliar,\n       p.UNivel\n       \nFROM  " + this.xcc_puc + " p\nINNER JOIN nv_subcuenta g\nON p.id_Padre=g.id_subcuenta\nWHERE p.id_nivel=5\n)\n\n, set_datos AS \n(\nSELECT dd.id_Puc, SUBSTR(" + this.xaux + ",1,8) id_puc_aux,  DATE_FORMAT(FechaD, '%Y') anno, pu.tipo, dd.VDebito, dd.VCredito,\nCASE WHEN  pu.Tipo=0 THEN \n ROUND(dd.VDebito,2) - ROUND(dd.VCredito,2)\nELSE\n  ROUND(dd.VCredito,2) - ROUND(dd.VDebito,2) \nEND saldo\n\n  FROM cc_documentoc d\nINNER JOIN cc_detalle_documentoc dd\nON d.id=dd.id_documentoc\nINNER JOIN cc_puc pu\nON dd.Id_Puc=pu.id\n" + this.xcc_detalle + "INNER JOIN cc_periodo_contable pc\nON d.Id_PeriodoC=pc.id\nINNER JOIN cc_tipo_documentoc td\nON d.Id_TipoComprobante=td.id\nWHERE pc.Escierre " + this.incluirPeriodoCierre + " AND td.Es_Niif " + this.xAplicaNiif + "AND d.estado=1\nAND pu.AplicaNiif " + this.xAplicaNiif + "AND d.FechaD <='" + this.xmt.formatoAMD1.format(this.JDCFechaFin.getDate()) + "'\n) \n";
        }
        if (xanno_inicio.equals(xanno_fin)) {
            String sql2 = sql + ", set_balance AS (SELECT  id_puc_aux, tipo,\n CASE WHEN MID(id_puc_aux,1,1) IN(4,5,6,7) THEN\n\tSUM(IF(anno =  '" + xanno_fin + "', ROUND(Saldo,2), 0)) \nELSE\n\tSUM(IF(anno <=  '" + xanno_fin + "', ROUND(Saldo,2), 0)) \nEND AS 'Anno_fin' \nFROM set_datos\nGROUP BY id_puc_aux, tipo\n)\n , set_b_final AS (\nSELECT " + this.xnivel + "\ts.tipo,\n'" + xanno_inicio + "' Anno_I,\n'" + xanno_fin + "' Anno_F,\nSUM(s.Anno_fin) Anno_" + xanno_fin + " \n\t\nFROM set_balance s\nINNER JOIN nv_auxiliar na\nON s.id_puc_aux=na.id_auxiliar\nWHERE na.id_clase " + this.xestadoFinanciero + " GROUP BY " + this.xnivel + "\ts.tipo\n)\n\nSELECT na.*\n FROM set_b_final na";
            System.out.println("sql puc-->" + sql2);
            if (this.JRB_BalanceGeneral.isSelected()) {
                if (this.JRB_EsColgaap.isSelected()) {
                    titulo = "BALANCE GENERAL";
                } else {
                    titulo = "ESTADO DE SITUACIÓN FINANCIERA";
                }
                if (this.JRB_Clase.isSelected()) {
                    mCargarClaseUnico(sql2, xanno_inicio, xanno_fin);
                    mImprimir_clase_unico(sql2, xanno_inicio, xanno_fin, titulo);
                    return;
                } else if (this.JRB_Grupo.isSelected()) {
                    mCargarGrupoUnico(sql2, xanno_inicio, xanno_fin);
                    mImprimir_grupo_unico(sql2, xanno_inicio, xanno_fin, titulo);
                    return;
                } else {
                    if (this.JRB_Cuenta.isSelected()) {
                        mCargarCuentaUnico(sql2, xanno_inicio, xanno_fin);
                        mImprimir_cuenta_unico(sql2, xanno_inicio, xanno_fin, titulo);
                        return;
                    }
                    return;
                }
            }
            if (this.JRB_Clase.isSelected()) {
                mCargarClaseUnico(sql2, xanno_inicio, xanno_fin);
                mImprimir_clase_unico(sql2, xanno_inicio, xanno_fin, "ESTADO DE RESULTADO");
                return;
            } else if (this.JRB_Grupo.isSelected()) {
                mCargarGrupoUnico(sql2, xanno_inicio, xanno_fin);
                mImprimir_grupo_unico(sql2, xanno_inicio, xanno_fin, "ESTADO DE RESULTADO");
                return;
            } else {
                if (this.JRB_Cuenta.isSelected()) {
                    mCargarCuentaUnico(sql2, xanno_inicio, xanno_fin);
                    mImprimir_cuenta_unico(sql2, xanno_inicio, xanno_fin, "ESTADO DE RESULTADO");
                    return;
                }
                return;
            }
        }
        String sql3 = sql + ", set_balance AS (SELECT  id_puc_aux, tipo,\n CASE WHEN MID(id_puc_aux,1,1) IN(4,5,6,7) THEN\n\tSUM(IF(anno = '" + xanno_inicio + "', ROUND(Saldo,2), 0))\nELSE\t\n\tSUM(IF(anno <= '" + xanno_inicio + "', ROUND(Saldo,2), 0)) \nEND  AS 'Anno_inicio',\nCASE WHEN MID(id_puc_aux,1,1) IN(4,5,6,7) THEN\n\tSUM(IF(anno = '" + xanno_fin + "', ROUND(Saldo,2), 0)) \nELSE\n\tSUM(IF(anno <= '" + xanno_fin + "', ROUND(Saldo,2), 0)) \nEND AS 'Anno_fin'\nFROM set_datos\nGROUP BY id_puc_aux, tipo\n)\n , set_b_final AS (\nSELECT " + this.xnivel + "\ts.tipo,\n'" + xanno_inicio + "' Anno_I,\n'" + xanno_fin + "' Anno_F,\n\tSUM(s.Anno_inicio) Anno_" + xanno_inicio + ",\n\tSUM(s.Anno_fin) Anno_" + xanno_fin + ", \n\tROUND(IFNULL(((SUM(s.Anno_fin)/ CASE WHEN SUM(s.Anno_inicio)=0 THEN 0.1 ELSE SUM(s.Anno_inicio) END)-1)*100,0),2) valor_relativo,\n\tSUM(s.Anno_fin)-SUM(s.Anno_inicio) valor_absoluto\n\t\nFROM set_balance s\nINNER JOIN nv_auxiliar na\nON s.id_puc_aux=na.id_auxiliar\nWHERE na.id_clase " + this.xestadoFinanciero + " GROUP BY " + this.xnivel + "\ts.tipo\n)\n\nSELECT na.*\n FROM set_b_final na";
        System.out.println("sql puc-->" + sql3);
        if (this.JRB_BalanceGeneral.isSelected()) {
            if (this.JRB_EsColgaap.isSelected()) {
            }
            if (this.JRB_Clase.isSelected()) {
                mCargarClase(sql3, xanno_inicio, xanno_fin);
                mImprimir_clase(sql3, xanno_inicio, xanno_fin, "BALANCE GENERAL COMPARATIVO");
                return;
            } else if (this.JRB_Grupo.isSelected()) {
                mCargarGrupo(sql3, xanno_inicio, xanno_fin);
                mImprimir_grupo(sql3, xanno_inicio, xanno_fin, "BALANCE GENERAL COMPARATIVO");
                return;
            } else {
                if (this.JRB_Cuenta.isSelected()) {
                    mCargarCuenta(sql3, xanno_inicio, xanno_fin);
                    mImprimir_cuenta(sql3, xanno_inicio, xanno_fin, "BALANCE GENERAL COMPARATIVO");
                    return;
                }
                return;
            }
        }
        if (this.JRB_Clase.isSelected()) {
            mCargarClase(sql3, xanno_inicio, xanno_fin);
            mImprimir_clase(sql3, xanno_inicio, xanno_fin, "ESTADO DE RESULTADO COMPARATIVO");
        } else if (this.JRB_Grupo.isSelected()) {
            mCargarGrupo(sql3, xanno_inicio, xanno_fin);
            mImprimir_grupo(sql3, xanno_inicio, xanno_fin, "ESTADO DE RESULTADO COMPARATIVO");
        } else if (this.JRB_Cuenta.isSelected()) {
            mCargarCuenta(sql3, xanno_inicio, xanno_fin);
            mImprimir_cuenta(sql3, xanno_inicio, xanno_fin, "ESTADO DE RESULTADO COMPARATIVO");
        }
    }

    public void mNuevo() {
        this.JDCFechaInicio.setDate(this.xmt.getFechaActual());
        this.JDCFechaFin.setDate(this.xmt.getFechaActual());
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
        this.JCH_EsPorPeriodo.setSelected(false);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mModeloClase(String anno_ini, String anno_fin) {
        this.xmodelo2 = new DefaultTableModel(new Object[0], new String[]{"IdClase", "Nombre Clase", "Tipo", "Año Inicio", "Año Fin", "Año " + anno_ini, "Año " + anno_fin, "Valor Relativo", "Valor Absoluto"}) { // from class: Contabilidad.JIFEstadosFinanc_Comparativos.12
            Class[] types = {String.class, String.class, String.class, String.class, String.class, Double.class, Double.class, Double.class, Double.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTH_Detalle.setModel(this.xmodelo2);
        JTable jTable = this.JTH_Detalle;
        JTable jTable2 = this.JTH_Detalle;
        jTable.setAutoResizeMode(0);
        this.JTH_Detalle.doLayout();
        this.JTH_Detalle.getColumnModel().getColumn(0).setPreferredWidth(50);
        this.JTH_Detalle.getColumnModel().getColumn(1).setPreferredWidth(150);
        this.JTH_Detalle.getColumnModel().getColumn(2).setPreferredWidth(0);
        this.JTH_Detalle.getColumnModel().getColumn(2).setMinWidth(0);
        this.JTH_Detalle.getColumnModel().getColumn(2).setMaxWidth(0);
        this.JTH_Detalle.getColumnModel().getColumn(3).setPreferredWidth(0);
        this.JTH_Detalle.getColumnModel().getColumn(3).setMinWidth(0);
        this.JTH_Detalle.getColumnModel().getColumn(3).setMaxWidth(0);
        this.JTH_Detalle.getColumnModel().getColumn(4).setPreferredWidth(0);
        this.JTH_Detalle.getColumnModel().getColumn(4).setMinWidth(0);
        this.JTH_Detalle.getColumnModel().getColumn(4).setMaxWidth(0);
        this.JTH_Detalle.getColumnModel().getColumn(5).setPreferredWidth(150);
        this.JTH_Detalle.getColumnModel().getColumn(6).setPreferredWidth(150);
        this.JTH_Detalle.getColumnModel().getColumn(7).setPreferredWidth(100);
        this.JTH_Detalle.getColumnModel().getColumn(8).setPreferredWidth(150);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mModeloGrupo(String anno_ini, String anno_fin) {
        this.xmodelo2 = new DefaultTableModel(new Object[0], new String[]{"IdClase", "Nombre Clase", "IdGrupo", "Nombre Grupo", "Tipo", "Año Inicio", "Año Fin", "Año " + anno_ini, "Año " + anno_fin, "Valor Relactivo", "Valor Absoluto"}) { // from class: Contabilidad.JIFEstadosFinanc_Comparativos.13
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, Double.class, Double.class, Double.class, Double.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTH_Detalle.setModel(this.xmodelo2);
        JTable jTable = this.JTH_Detalle;
        JTable jTable2 = this.JTH_Detalle;
        jTable.setAutoResizeMode(0);
        this.JTH_Detalle.doLayout();
        this.JTH_Detalle.getColumnModel().getColumn(0).setPreferredWidth(50);
        this.JTH_Detalle.getColumnModel().getColumn(1).setPreferredWidth(150);
        this.JTH_Detalle.getColumnModel().getColumn(2).setPreferredWidth(50);
        this.JTH_Detalle.getColumnModel().getColumn(3).setPreferredWidth(300);
        this.JTH_Detalle.getColumnModel().getColumn(4).setPreferredWidth(0);
        this.JTH_Detalle.getColumnModel().getColumn(4).setMinWidth(0);
        this.JTH_Detalle.getColumnModel().getColumn(4).setMaxWidth(0);
        this.JTH_Detalle.getColumnModel().getColumn(5).setPreferredWidth(0);
        this.JTH_Detalle.getColumnModel().getColumn(5).setMinWidth(0);
        this.JTH_Detalle.getColumnModel().getColumn(5).setMaxWidth(0);
        this.JTH_Detalle.getColumnModel().getColumn(6).setPreferredWidth(0);
        this.JTH_Detalle.getColumnModel().getColumn(6).setMinWidth(0);
        this.JTH_Detalle.getColumnModel().getColumn(6).setMaxWidth(0);
        this.JTH_Detalle.getColumnModel().getColumn(7).setPreferredWidth(150);
        this.JTH_Detalle.getColumnModel().getColumn(8).setPreferredWidth(150);
        this.JTH_Detalle.getColumnModel().getColumn(9).setPreferredWidth(100);
        this.JTH_Detalle.getColumnModel().getColumn(10).setPreferredWidth(150);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mModeloCuenta(String anno_ini, String anno_fin) {
        this.xmodelo2 = new DefaultTableModel(new Object[0], new String[]{"IdClase", "Nombre Clase", "IdGrupo", "Nombre Grupo", "IdCuenta", "Nombre Cuenta", "Tipo", "Año Inicio", "Año Fin", "Año " + anno_ini, "Año " + anno_fin, "Valor Relactivo", "Valor Absoluto"}) { // from class: Contabilidad.JIFEstadosFinanc_Comparativos.14
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Double.class, Double.class, Double.class, Double.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTH_Detalle.setModel(this.xmodelo2);
        this.JTH_Detalle.doLayout();
        this.JTH_Detalle.getColumnModel().getColumn(0).setPreferredWidth(50);
        this.JTH_Detalle.getColumnModel().getColumn(1).setPreferredWidth(120);
        this.JTH_Detalle.getColumnModel().getColumn(2).setPreferredWidth(50);
        this.JTH_Detalle.getColumnModel().getColumn(3).setPreferredWidth(250);
        this.JTH_Detalle.getColumnModel().getColumn(4).setPreferredWidth(50);
        this.JTH_Detalle.getColumnModel().getColumn(5).setPreferredWidth(250);
        this.JTH_Detalle.getColumnModel().getColumn(6).setPreferredWidth(0);
        this.JTH_Detalle.getColumnModel().getColumn(6).setMinWidth(0);
        this.JTH_Detalle.getColumnModel().getColumn(6).setMaxWidth(0);
        this.JTH_Detalle.getColumnModel().getColumn(7).setPreferredWidth(0);
        this.JTH_Detalle.getColumnModel().getColumn(7).setMinWidth(0);
        this.JTH_Detalle.getColumnModel().getColumn(7).setMaxWidth(0);
        this.JTH_Detalle.getColumnModel().getColumn(8).setPreferredWidth(0);
        this.JTH_Detalle.getColumnModel().getColumn(8).setMinWidth(0);
        this.JTH_Detalle.getColumnModel().getColumn(8).setMaxWidth(0);
        this.JTH_Detalle.getColumnModel().getColumn(9).setPreferredWidth(150);
        this.JTH_Detalle.getColumnModel().getColumn(10).setPreferredWidth(150);
        this.JTH_Detalle.getColumnModel().getColumn(11).setPreferredWidth(100);
        this.JTH_Detalle.getColumnModel().getColumn(12).setPreferredWidth(150);
    }

    private void mCargarClase(String sql, String xanno_inicio, String xanno_fin) {
        try {
            mModeloClase(xanno_inicio, xanno_fin);
            ResultSet xrs1 = this.xct.traerRs(sql);
            if (xrs1.next()) {
                xrs1.beforeFirst();
                int i = 0;
                while (xrs1.next()) {
                    this.xmodelo2.addRow(this.xdatos);
                    this.xmodelo2.setValueAt(xrs1.getString(1), i, 0);
                    this.xmodelo2.setValueAt(xrs1.getString(2), i, 1);
                    this.xmodelo2.setValueAt(xrs1.getString(3), i, 2);
                    this.xmodelo2.setValueAt(xrs1.getString(4), i, 3);
                    this.xmodelo2.setValueAt(xrs1.getString(5), i, 4);
                    this.xmodelo2.setValueAt(Double.valueOf(xrs1.getDouble(6)), i, 5);
                    this.xmodelo2.setValueAt(Double.valueOf(xrs1.getDouble(7)), i, 6);
                    this.xmodelo2.setValueAt(Double.valueOf(xrs1.getDouble(8)), i, 7);
                    this.xmodelo2.setValueAt(Double.valueOf(xrs1.getDouble(9)), i, 8);
                    i++;
                }
            }
            xrs1.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFEstadosFinanc_Comparativos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarClaseUnico(String sql, String xanno_inicio, String xanno_fin) {
        try {
            mModeloClase(xanno_inicio, xanno_fin);
            this.JTH_Detalle.getColumnModel().getColumn(5).setPreferredWidth(0);
            this.JTH_Detalle.getColumnModel().getColumn(5).setMinWidth(0);
            this.JTH_Detalle.getColumnModel().getColumn(5).setMaxWidth(0);
            this.JTH_Detalle.getColumnModel().getColumn(7).setPreferredWidth(0);
            this.JTH_Detalle.getColumnModel().getColumn(7).setMinWidth(0);
            this.JTH_Detalle.getColumnModel().getColumn(7).setMaxWidth(0);
            this.JTH_Detalle.getColumnModel().getColumn(8).setPreferredWidth(0);
            this.JTH_Detalle.getColumnModel().getColumn(8).setMinWidth(0);
            this.JTH_Detalle.getColumnModel().getColumn(8).setMaxWidth(0);
            ResultSet xrs1 = this.xct.traerRs(sql);
            if (xrs1.next()) {
                xrs1.beforeFirst();
                int i = 0;
                while (xrs1.next()) {
                    this.xmodelo2.addRow(this.xdatos);
                    this.xmodelo2.setValueAt(xrs1.getString(1), i, 0);
                    this.xmodelo2.setValueAt(xrs1.getString(2), i, 1);
                    this.xmodelo2.setValueAt(xrs1.getString(3), i, 2);
                    this.xmodelo2.setValueAt(xrs1.getString(4), i, 3);
                    this.xmodelo2.setValueAt(xrs1.getString(5), i, 4);
                    this.xmodelo2.setValueAt(Double.valueOf(xrs1.getDouble(6)), i, 6);
                    i++;
                }
            }
            xrs1.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFEstadosFinanc_Comparativos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarGrupo(String sql, String xanno_inicio, String xanno_fin) {
        try {
            mModeloGrupo(xanno_inicio, xanno_fin);
            ResultSet xrs1 = this.xct.traerRs(sql);
            if (xrs1.next()) {
                xrs1.beforeFirst();
                int i = 0;
                while (xrs1.next()) {
                    this.xmodelo2.addRow(this.xdatos);
                    this.xmodelo2.setValueAt(xrs1.getString(1), i, 0);
                    this.xmodelo2.setValueAt(xrs1.getString(2), i, 1);
                    this.xmodelo2.setValueAt(xrs1.getString(3), i, 2);
                    this.xmodelo2.setValueAt(xrs1.getString(4), i, 3);
                    this.xmodelo2.setValueAt(xrs1.getString(5), i, 4);
                    this.xmodelo2.setValueAt(xrs1.getString(6), i, 5);
                    this.xmodelo2.setValueAt(xrs1.getString(7), i, 6);
                    this.xmodelo2.setValueAt(Double.valueOf(xrs1.getDouble(8)), i, 7);
                    this.xmodelo2.setValueAt(Double.valueOf(xrs1.getDouble(9)), i, 8);
                    this.xmodelo2.setValueAt(Double.valueOf(xrs1.getDouble(10)), i, 9);
                    this.xmodelo2.setValueAt(Double.valueOf(xrs1.getDouble(11)), i, 10);
                    i++;
                }
            }
            xrs1.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFEstadosFinanc_Comparativos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarGrupoUnico(String sql, String xanno_inicio, String xanno_fin) {
        try {
            mModeloGrupo(xanno_inicio, xanno_fin);
            this.JTH_Detalle.getColumnModel().getColumn(7).setPreferredWidth(0);
            this.JTH_Detalle.getColumnModel().getColumn(7).setMinWidth(0);
            this.JTH_Detalle.getColumnModel().getColumn(7).setMaxWidth(0);
            this.JTH_Detalle.getColumnModel().getColumn(9).setPreferredWidth(0);
            this.JTH_Detalle.getColumnModel().getColumn(9).setMinWidth(0);
            this.JTH_Detalle.getColumnModel().getColumn(9).setMaxWidth(0);
            this.JTH_Detalle.getColumnModel().getColumn(10).setPreferredWidth(0);
            this.JTH_Detalle.getColumnModel().getColumn(10).setMinWidth(0);
            this.JTH_Detalle.getColumnModel().getColumn(10).setMaxWidth(0);
            ResultSet xrs1 = this.xct.traerRs(sql);
            if (xrs1.next()) {
                xrs1.beforeFirst();
                int i = 0;
                while (xrs1.next()) {
                    this.xmodelo2.addRow(this.xdatos);
                    this.xmodelo2.setValueAt(xrs1.getString(1), i, 0);
                    this.xmodelo2.setValueAt(xrs1.getString(2), i, 1);
                    this.xmodelo2.setValueAt(xrs1.getString(3), i, 2);
                    this.xmodelo2.setValueAt(xrs1.getString(4), i, 3);
                    this.xmodelo2.setValueAt(xrs1.getString(5), i, 4);
                    this.xmodelo2.setValueAt(xrs1.getString(6), i, 5);
                    this.xmodelo2.setValueAt(xrs1.getString(7), i, 6);
                    this.xmodelo2.setValueAt(Double.valueOf(xrs1.getDouble(8)), i, 8);
                    i++;
                }
            }
            xrs1.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFEstadosFinanc_Comparativos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarCuenta(String sql, String xanno_inicio, String xanno_fin) {
        try {
            mModeloCuenta(xanno_inicio, xanno_fin);
            ResultSet xrs1 = this.xct.traerRs(sql);
            if (xrs1.next()) {
                xrs1.beforeFirst();
                int i = 0;
                while (xrs1.next()) {
                    this.xmodelo2.addRow(this.xdatos);
                    this.xmodelo2.setValueAt(xrs1.getString(1), i, 0);
                    this.xmodelo2.setValueAt(xrs1.getString(2), i, 1);
                    this.xmodelo2.setValueAt(xrs1.getString(3), i, 2);
                    this.xmodelo2.setValueAt(xrs1.getString(4), i, 3);
                    this.xmodelo2.setValueAt(xrs1.getString(5), i, 4);
                    this.xmodelo2.setValueAt(xrs1.getString(6), i, 5);
                    this.xmodelo2.setValueAt(xrs1.getString(7), i, 6);
                    this.xmodelo2.setValueAt(xrs1.getString(8), i, 7);
                    this.xmodelo2.setValueAt(xrs1.getString(9), i, 8);
                    this.xmodelo2.setValueAt(Double.valueOf(xrs1.getDouble(10)), i, 9);
                    this.xmodelo2.setValueAt(Double.valueOf(xrs1.getDouble(11)), i, 10);
                    this.xmodelo2.setValueAt(Double.valueOf(xrs1.getDouble(12)), i, 11);
                    this.xmodelo2.setValueAt(Double.valueOf(xrs1.getDouble(13)), i, 12);
                    i++;
                }
            }
            xrs1.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFEstadosFinanc_Comparativos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarCuentaUnico(String sql, String xanno_inicio, String xanno_fin) {
        try {
            mModeloCuenta(xanno_inicio, xanno_fin);
            this.JTH_Detalle.getColumnModel().getColumn(9).setPreferredWidth(0);
            this.JTH_Detalle.getColumnModel().getColumn(9).setMinWidth(0);
            this.JTH_Detalle.getColumnModel().getColumn(9).setMaxWidth(0);
            this.JTH_Detalle.getColumnModel().getColumn(11).setPreferredWidth(0);
            this.JTH_Detalle.getColumnModel().getColumn(11).setMinWidth(0);
            this.JTH_Detalle.getColumnModel().getColumn(11).setMaxWidth(0);
            this.JTH_Detalle.getColumnModel().getColumn(12).setPreferredWidth(0);
            this.JTH_Detalle.getColumnModel().getColumn(12).setMinWidth(0);
            this.JTH_Detalle.getColumnModel().getColumn(12).setMaxWidth(0);
            ResultSet xrs1 = this.xct.traerRs(sql);
            if (xrs1.next()) {
                xrs1.beforeFirst();
                int i = 0;
                while (xrs1.next()) {
                    this.xmodelo2.addRow(this.xdatos);
                    this.xmodelo2.setValueAt(xrs1.getString(1), i, 0);
                    this.xmodelo2.setValueAt(xrs1.getString(2), i, 1);
                    this.xmodelo2.setValueAt(xrs1.getString(3), i, 2);
                    this.xmodelo2.setValueAt(xrs1.getString(4), i, 3);
                    this.xmodelo2.setValueAt(xrs1.getString(5), i, 4);
                    this.xmodelo2.setValueAt(xrs1.getString(6), i, 5);
                    this.xmodelo2.setValueAt(xrs1.getString(7), i, 6);
                    this.xmodelo2.setValueAt(xrs1.getString(8), i, 7);
                    this.xmodelo2.setValueAt(xrs1.getString(9), i, 8);
                    this.xmodelo2.setValueAt(Double.valueOf(xrs1.getDouble(10)), i, 10);
                    i++;
                }
            }
            xrs1.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFEstadosFinanc_Comparativos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mImprimir_clase(String sql, String xanno_inicio, String xanno_fin, String Titulo) {
        String[][] parametros = new String[7][2];
        parametros[0][0] = "UsuarioS";
        parametros[0][1] = Principal.usuarioSistemaDTO.getLogin();
        parametros[1][0] = "Periodo";
        parametros[1][1] = "Desde " + this.xmt.formatoDMA.format(this.JDCFechaInicio.getDate()) + " Hasta " + this.xmt.formatoDMA.format(this.JDCFechaFin.getDate());
        parametros[2][0] = "Titulo";
        parametros[2][1] = Titulo;
        parametros[3][0] = "Nivel";
        parametros[3][1] = "CLASE";
        parametros[4][0] = "SUBREPORT_DIR";
        parametros[4][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
        parametros[5][0] = "SUBREPORTFIRMA_DIR";
        parametros[5][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
        parametros[6][0] = "comentarioNiif";
        parametros[6][1] = this.comentarioNiif;
        this.xct.ejecutarSQL("truncate table cc_informe_financiero_clase");
        String sql2 = "insert into cc_informe_financiero_clase\n " + sql;
        this.xct.ejecutarSQL(sql2);
        this.xct.cerrarConexionBd();
        this.xmt.GenerarPDF(this.xmt.getRutaRep() + "CC_Balance_Comparativo_Clase_PucNiif", parametros);
    }

    public void mImprimir_clase_unico(String sql, String xanno_inicio, String xanno_fin, String Titulo) {
        String[][] parametros = new String[7][2];
        parametros[0][0] = "UsuarioS";
        parametros[0][1] = Principal.usuarioSistemaDTO.getLogin();
        parametros[1][0] = "Periodo";
        parametros[1][1] = "Hasta " + this.xmt.formatoDMA.format(this.JDCFechaFin.getDate());
        parametros[2][0] = "Titulo";
        parametros[2][1] = Titulo;
        parametros[3][0] = "Nivel";
        parametros[3][1] = "CLASE";
        parametros[4][0] = "SUBREPORT_DIR";
        parametros[4][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
        parametros[5][0] = "SUBREPORTFIRMA_DIR";
        parametros[5][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
        parametros[6][0] = "comentarioNiif";
        parametros[6][1] = this.comentarioNiif;
        this.xct.ejecutarSQL("truncate table cc_informe_financiero_clase");
        String sql2 = "insert into cc_informe_financiero_clase(id_clase,nbre_clase,tipo,anno_i,anno_f,anno_fin)\n " + sql;
        this.xct.ejecutarSQL(sql2);
        this.xct.cerrarConexionBd();
        this.xmt.GenerarPDF(this.xmt.getRutaRep() + "CC_Balance_Unico_Clase_PucNiif", parametros);
    }

    public void mImprimir_grupo(String sql, String xanno_inicio, String xanno_fin, String Titulo) {
        String[][] parametros = new String[7][2];
        parametros[0][0] = "UsuarioS";
        parametros[0][1] = Principal.usuarioSistemaDTO.getLogin();
        parametros[1][0] = "Periodo";
        parametros[1][1] = "Desde " + this.xmt.formatoDMA.format(this.JDCFechaInicio.getDate()) + " Hasta " + this.xmt.formatoDMA.format(this.JDCFechaFin.getDate());
        parametros[2][0] = "Titulo";
        parametros[2][1] = Titulo;
        parametros[3][0] = "Nivel";
        parametros[3][1] = "GRUPO";
        parametros[4][0] = "SUBREPORT_DIR";
        parametros[4][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
        parametros[5][0] = "SUBREPORTFIRMA_DIR";
        parametros[5][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
        parametros[6][0] = "comentarioNiif";
        parametros[6][1] = this.comentarioNiif;
        this.xct.ejecutarSQL("truncate table cc_informe_financiero_grupo");
        String sql2 = "insert into cc_informe_financiero_grupo\n " + sql;
        this.xct.ejecutarSQL(sql2);
        this.xct.cerrarConexionBd();
        this.xmt.GenerarPDF(this.xmt.getRutaRep() + "CC_Balance_Comparativo_Grupo_PucNiif", parametros);
    }

    public void mImprimir_grupo_unico(String sql, String xanno_inicio, String xanno_fin, String Titulo) {
        String[][] parametros = new String[7][2];
        parametros[0][0] = "UsuarioS";
        parametros[0][1] = Principal.usuarioSistemaDTO.getLogin();
        parametros[1][0] = "Periodo";
        parametros[1][1] = "Hasta " + this.xmt.formatoDMA.format(this.JDCFechaFin.getDate());
        parametros[2][0] = "Titulo";
        parametros[2][1] = Titulo;
        parametros[3][0] = "Nivel";
        parametros[3][1] = "GRUPO";
        parametros[4][0] = "SUBREPORT_DIR";
        parametros[4][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
        parametros[5][0] = "SUBREPORTFIRMA_DIR";
        parametros[5][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
        parametros[6][0] = "comentarioNiif";
        parametros[6][1] = this.comentarioNiif;
        this.xct.ejecutarSQL("truncate table cc_informe_financiero_grupo");
        String sql2 = "insert into cc_informe_financiero_grupo(id_clase,nbre_clase,id_grupo,nbre_grupo,tipo,anno_i,anno_f,anno_fin)\n " + sql;
        this.xct.ejecutarSQL(sql2);
        this.xct.cerrarConexionBd();
        this.xmt.GenerarPDF(this.xmt.getRutaRep() + "CC_Balance_Unico_Grupo_PucNiif", parametros);
    }

    public void mImprimir_cuenta(String sql, String xanno_inicio, String xanno_fin, String Titulo) {
        String[][] parametros = new String[7][2];
        parametros[0][0] = "UsuarioS";
        parametros[0][1] = Principal.usuarioSistemaDTO.getLogin();
        parametros[1][0] = "Periodo";
        parametros[1][1] = "Desde " + this.xmt.formatoDMA.format(this.JDCFechaInicio.getDate()) + " Hasta " + this.xmt.formatoDMA.format(this.JDCFechaFin.getDate());
        parametros[2][0] = "Titulo";
        parametros[2][1] = Titulo;
        parametros[3][0] = "Nivel";
        parametros[3][1] = "CUENTA";
        parametros[4][0] = "SUBREPORT_DIR";
        parametros[4][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
        parametros[5][0] = "SUBREPORTFIRMA_DIR";
        parametros[5][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
        parametros[6][0] = "comentarioNiif";
        parametros[6][1] = this.comentarioNiif;
        this.xct.ejecutarSQL("truncate table cc_informe_financiero_cuenta");
        String sql2 = "insert into cc_informe_financiero_cuenta\n " + sql;
        this.xct.ejecutarSQL(sql2);
        this.xct.cerrarConexionBd();
        this.xmt.GenerarPDF(this.xmt.getRutaRep() + "CC_Balance_Comparativo_Cuenta_PucNiif", parametros);
    }

    public void mImprimir_cuenta_unico(String sql, String xanno_inicio, String xanno_fin, String Titulo) {
        String[][] parametros = new String[7][2];
        parametros[0][0] = "UsuarioS";
        parametros[0][1] = Principal.usuarioSistemaDTO.getLogin();
        parametros[1][0] = "Periodo";
        parametros[1][1] = "Hasta " + this.xmt.formatoDMA.format(this.JDCFechaFin.getDate());
        parametros[2][0] = "Titulo";
        parametros[2][1] = Titulo;
        parametros[3][0] = "Nivel";
        parametros[3][1] = "CUENTA";
        parametros[4][0] = "SUBREPORT_DIR";
        parametros[4][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
        parametros[5][0] = "SUBREPORTFIRMA_DIR";
        parametros[5][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
        parametros[6][0] = "comentarioNiif";
        parametros[6][1] = this.comentarioNiif;
        this.xct.ejecutarSQL("truncate table cc_informe_financiero_cuenta");
        String sql2 = "insert into cc_informe_financiero_cuenta(id_clase,nbre_clase,id_grupo,nbre_grupo,id_cuenta,nbre_cuenta,tipo,anno_i,anno_f,anno_fin)\n " + sql;
        this.xct.ejecutarSQL(sql2);
        this.xct.cerrarConexionBd();
        this.xmt.GenerarPDF(this.xmt.getRutaRep() + "CC_Balance_Unico_Cuenta_PucNiif", parametros);
    }
}
