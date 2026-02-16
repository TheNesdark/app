package Presupuesto;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JYearChooser;
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
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Presupuesto/JIFConsultaDec2193.class */
public class JIFConsultaDec2193 extends JInternalFrame {
    String sql;
    private String idPeriodo;
    private String[] xid;
    private int filaGridI;
    private int filaGridG;
    private DefaultTableModel modeloI;
    private DefaultTableModel modeloG;
    private JButton JBTExportar;
    private JButton JBTOk;
    private JComboBox JCBPeriodo;
    private JTextField JTFRuta;
    private JYearChooser JYCAno;
    private ButtonGroup Tipo;
    private ButtonGroup Trimestres;
    private JRadioButton btnMensual;
    private JRadioButton btnTrim1;
    private JRadioButton btnTrim2;
    private JRadioButton btnTrim3;
    private JRadioButton btnTrim4;
    private JRadioButton btnTrimestre;
    private JTable gridG;
    private JTable gridI;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JScrollPane jScrollPane2;
    private JScrollPane jScrollPane3;
    private JTabbedPane jTabbedPane1;
    private Metodos xmt = new Metodos();
    private String xTipoR = "I";
    String xPeriodos = "";
    private String[] mes = new String[3];
    private int xUltimoN = 0;
    private int xAplicaTercero = 0;
    private Object[] datoI = {"", "", "", 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L};
    private Object[] datoG = {"", "", "", 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L};
    private ConsultasMySQL xct = new ConsultasMySQL();

    public JIFConsultaDec2193() {
        initComponents();
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
    }

    /* JADX WARN: Type inference failed for: r3v14, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v17, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.Tipo = new ButtonGroup();
        this.Trimestres = new ButtonGroup();
        this.JBTExportar = new JButton();
        this.JTFRuta = new JTextField();
        this.jTabbedPane1 = new JTabbedPane();
        this.jScrollPane2 = new JScrollPane();
        this.gridI = new JTable();
        this.jScrollPane3 = new JScrollPane();
        this.gridG = new JTable();
        this.jPanel1 = new JPanel();
        this.JCBPeriodo = new JComboBox();
        this.JYCAno = new JYearChooser();
        this.JBTOk = new JButton();
        this.jPanel2 = new JPanel();
        this.btnMensual = new JRadioButton();
        this.btnTrimestre = new JRadioButton();
        this.btnTrim1 = new JRadioButton();
        this.btnTrim2 = new JRadioButton();
        this.btnTrim3 = new JRadioButton();
        this.btnTrim4 = new JRadioButton();
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("DECRETO 2193");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xConsultaDec2193");
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: Presupuesto.JIFConsultaDec2193.1
            public void actionPerformed(ActionEvent evt) {
                JIFConsultaDec2193.this.JBTExportarActionPerformed(evt);
            }
        });
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: Presupuesto.JIFConsultaDec2193.2
            public void mouseClicked(MouseEvent evt) {
                JIFConsultaDec2193.this.JTFRutaMouseClicked(evt);
            }
        });
        this.jTabbedPane1.setForeground(Color.red);
        this.jTabbedPane1.setFont(new Font("Arial", 1, 14));
        this.gridI.setFont(new Font("Arial", 1, 12));
        this.gridI.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.gridI.setSelectionBackground(Color.white);
        this.gridI.setSelectionForeground(Color.red);
        this.jScrollPane2.setViewportView(this.gridI);
        this.jTabbedPane1.addTab("INGRESOS", this.jScrollPane2);
        this.gridG.setFont(new Font("Arial", 1, 12));
        this.gridG.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.gridG.setSelectionBackground(Color.white);
        this.gridG.setSelectionForeground(Color.red);
        this.jScrollPane3.setViewportView(this.gridG);
        this.jTabbedPane1.addTab("GASTOS", this.jScrollPane3);
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JCBPeriodo.setFont(new Font("Arial", 1, 12));
        this.JCBPeriodo.setBorder(BorderFactory.createTitledBorder((Border) null, "Periodo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBPeriodo.addItemListener(new ItemListener() { // from class: Presupuesto.JIFConsultaDec2193.3
            public void itemStateChanged(ItemEvent evt) {
                JIFConsultaDec2193.this.JCBPeriodoItemStateChanged(evt);
            }
        });
        this.JYCAno.setBorder(BorderFactory.createTitledBorder((Border) null, "Año", 0, 0, new Font("Arial", 1, 13), Color.blue));
        this.JYCAno.addPropertyChangeListener(new PropertyChangeListener() { // from class: Presupuesto.JIFConsultaDec2193.4
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFConsultaDec2193.this.JYCAnoPropertyChange(evt);
            }
        });
        this.JBTOk.setFont(new Font("Arial", 1, 13));
        this.JBTOk.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTOk.setText("Consultar");
        this.JBTOk.addActionListener(new ActionListener() { // from class: Presupuesto.JIFConsultaDec2193.5
            public void actionPerformed(ActionEvent evt) {
                JIFConsultaDec2193.this.JBTOkActionPerformed(evt);
            }
        });
        this.jPanel2.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Reporte", 0, 0, new Font("Arial", 1, 13), Color.blue));
        this.Tipo.add(this.btnMensual);
        this.btnMensual.setFont(new Font("Arial", 1, 12));
        this.btnMensual.setText("Mensual");
        this.btnMensual.addActionListener(new ActionListener() { // from class: Presupuesto.JIFConsultaDec2193.6
            public void actionPerformed(ActionEvent evt) {
                JIFConsultaDec2193.this.btnMensualActionPerformed(evt);
            }
        });
        this.Tipo.add(this.btnTrimestre);
        this.btnTrimestre.setFont(new Font("Arial", 1, 12));
        this.btnTrimestre.setSelected(true);
        this.btnTrimestre.setText("Timestre");
        this.btnTrimestre.addActionListener(new ActionListener() { // from class: Presupuesto.JIFConsultaDec2193.7
            public void actionPerformed(ActionEvent evt) {
                JIFConsultaDec2193.this.btnTrimestreActionPerformed(evt);
            }
        });
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(this.btnMensual).addGap(43, 43, 43).addComponent(this.btnTrimestre).addContainerGap(42, 32767)));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap(-1, 32767).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.btnMensual).addComponent(this.btnTrimestre))));
        this.Trimestres.add(this.btnTrim1);
        this.btnTrim1.setFont(new Font("Arial", 1, 12));
        this.btnTrim1.setSelected(true);
        this.btnTrim1.setText("Trimestre 1");
        this.Trimestres.add(this.btnTrim2);
        this.btnTrim2.setFont(new Font("Arial", 1, 12));
        this.btnTrim2.setText("Trimestre 2");
        this.Trimestres.add(this.btnTrim3);
        this.btnTrim3.setFont(new Font("Arial", 1, 12));
        this.btnTrim3.setText("Trimestre 3");
        this.Trimestres.add(this.btnTrim4);
        this.btnTrim4.setFont(new Font("Arial", 1, 12));
        this.btnTrim4.setText("Trimestre 4");
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(20, 20, 20).addComponent(this.JYCAno, -2, 95, -2).addGap(18, 18, 18).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel2, -2, -1, -2).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.btnTrim1).addGap(18, 18, 18).addComponent(this.btnTrim2).addGap(18, 18, 18).addComponent(this.btnTrim3))).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JCBPeriodo, -2, 238, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 48, 32767).addComponent(this.JBTOk, -2, 240, -2).addContainerGap()).addGroup(jPanel1Layout.createSequentialGroup().addGap(18, 18, 18).addComponent(this.btnTrim4).addContainerGap(-1, 32767)))));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JBTOk, -1, -1, 32767).addComponent(this.JCBPeriodo))).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JYCAno, -2, -1, -2).addComponent(this.jPanel2, -2, -1, -2)).addGap(18, 18, 18).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.btnTrim2).addComponent(this.btnTrim1).addComponent(this.btnTrim3).addComponent(this.btnTrim4)))).addContainerGap(-1, 32767)));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(14, 14, 14).addComponent(this.JTFRuta, -1, 759, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBTExportar, -2, 221, -2).addGap(6, 6, 6)).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addComponent(this.jTabbedPane1).addContainerGap()).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, -1, -2).addContainerGap(-1, 32767))));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGap(147, 147, 147).addComponent(this.jTabbedPane1, -2, 374, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 37, 32767).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFRuta, -2, 56, -2).addComponent(this.JBTExportar, -2, 56, -2)).addContainerGap()).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, -1, -2).addContainerGap(489, 32767))));
        this.jTabbedPane1.getAccessibleContext().setAccessibleName("Ingresos");
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
        if (this.jTabbedPane1.getSelectedIndex() == 0) {
            if (this.gridI.getRowCount() > -1) {
                int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (n == 0) {
                    String xtitulo = "EJECUCIÓN PRESUPUESTAL DE INGRESOS AÑO " + this.JYCAno.getValue() + " PERIODO " + this.JCBPeriodo.getSelectedItem();
                    this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.gridI, this.xmt.mTraerUrlBD(this.JTFRuta.getText()), xtitulo);
                    return;
                }
                return;
            }
            return;
        }
        int n2 = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n2 == 0) {
            String xtitulo2 = "EJECUCIÓN PRESUPUESTAL DE GASTOS AÑO " + this.JYCAno.getValue() + " PERIODO " + this.JCBPeriodo.getSelectedItem();
            this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.gridG, this.xmt.mTraerUrlBD(this.JTFRuta.getText()), xtitulo2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBPeriodoItemStateChanged(ItemEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JYCAnoPropertyChange(PropertyChangeEvent evt) {
        mCargarCombo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTOkActionPerformed(ActionEvent evt) {
        mLlenarDatos();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnMensualActionPerformed(ActionEvent evt) {
        if (this.btnMensual.isSelected()) {
            this.JCBPeriodo.setEnabled(true);
            this.btnTrim1.setEnabled(false);
            this.btnTrim2.setEnabled(false);
            this.btnTrim3.setEnabled(false);
            this.btnTrim4.setEnabled(false);
            return;
        }
        this.JCBPeriodo.setEnabled(false);
        this.btnTrim1.setEnabled(true);
        this.btnTrim2.setEnabled(true);
        this.btnTrim3.setEnabled(true);
        this.btnTrim4.setEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnTrimestreActionPerformed(ActionEvent evt) {
        if (this.btnTrimestre.isSelected()) {
            this.JCBPeriodo.setEnabled(false);
            this.btnTrim1.setEnabled(true);
            this.btnTrim2.setEnabled(true);
            this.btnTrim3.setEnabled(true);
            this.btnTrim4.setEnabled(true);
            return;
        }
        this.JCBPeriodo.setEnabled(true);
        this.btnTrim1.setEnabled(false);
        this.btnTrim2.setEnabled(false);
        this.btnTrim3.setEnabled(false);
        this.btnTrim4.setEnabled(false);
    }

    private void mValidarTrimestre() {
        if (this.btnTrim1.isSelected()) {
            this.mes[0] = "01";
            this.mes[1] = "02";
            this.mes[2] = "03";
            return;
        }
        if (this.btnTrim2.isSelected()) {
            this.mes[0] = "04";
            this.mes[1] = "05";
            this.mes[2] = "06";
        } else if (this.btnTrim3.isSelected()) {
            this.mes[0] = "07";
            this.mes[1] = "08";
            this.mes[2] = "09";
        } else if (this.btnTrim4.isSelected()) {
            this.mes[0] = "10";
            this.mes[1] = "11";
            this.mes[2] = "12";
        }
    }

    private void mCargarCombo() {
        this.JCBPeriodo.removeAllItems();
        String sql = "SELECT `Id`, `Nbre`, `FechaI`, `FechaF`, `Cerrado` FROM `pp_periodo` WHERE (DATE_FORMAT(FechaI,'%Y')='" + this.JYCAno.getValue() + "') ORDER BY Id DESC ";
        this.xid = this.xct.llenarCombo(sql, this.xid, this.JCBPeriodo);
        this.xct.cerrarConexionBd();
    }

    private void mLlenarDatosMes(String idPer) {
        this.sql = "DROP TABLE IF EXISTS pp_tem_rubros_trim_c;\n";
        this.xct.ejecutarSQL(this.sql);
        this.sql = "CREATE TABLE  pp_tem_rubros_trim_c\n                SELECT  \n                r.Id\n                ,r.IdPadre\n                ,r.Nbre\n                ,r.TipoRubro\n                ,IFNULL(Presupuesto_Inicial,0) Presupuesto_Inicial\n                ,IFNULL(Adicion_Presupuesto,0) Adicion_Presupuesto\n                ,IFNULL(Reduccion_Presupuesto,0) Reduccion_Presupuesto\n                ,IFNULL(Traslados_Debitos,0) Traslados_Debitos\n                ,IFNULL(Traslados_Creditos,0) Traslados_Creditos\n                ,IFNULL(Presupuesto_Definitivo,0) Presupuesto_Definitivo\n                ,IFNULL(Reconocimiento_Anterior,0) Reconocimiento_Anterior\n                ,IFNULL(Reconocimiento_Actual,0) Reconocimiento_Actual\n                ,IFNULL(Reconocimiento_Total,0) Reconocimiento_Total\n                ,IFNULL(Recaudo_Anterior,0) Recaudo_Anterior\n                ,IFNULL(Recaudo_Actual,0) Recaudo_Actual\n                ,IFNULL(Recaudo_Total,0) Recaudo_Total\n                ,IFNULL(Saldo_por_Ejecutar,0) Saldo_por_Ejecutar\n                ,IFNULL(Saldo_por_Recaudar,0) Saldo_por_Recaudar\n                ,IFNULL(Certificado_Anterior,0) Certificado_Anterior\n                ,IFNULL(Certificado_Actual,0) Certificado_Actual\n                ,IFNULL(Total_Certificados,0) Total_Certificados\n                ,IFNULL(Compromiso_Anterior,0) Compromiso_Anterior\n                ,IFNULL(Compromiso_Actual,0) Compromiso_Actual\n                ,IFNULL(Compromiso_Total,0) Compromiso_Total\n                ,IFNULL(Obligacion_Anterior,0) Obligacion_Anterior\n                ,IFNULL(Obligacion_Actual,0) Obligacion_Actual\n                ,IFNULL(Total_Obligaciones,0) Total_Obligaciones\n                ,IFNULL(Pagos_Anterior,0) Pagos_Anterior\n                ,IFNULL(Pagos_Actual,0) Pagos_Actual\n                ,IFNULL(Total_Pagos,0) Total_Pagos\n                ,IFNULL(Saldo_Disponible,0) Saldo_Disponible\n                ,IFNULL(Sin_Comprometer,0) Sin_Comprometer\n                ,IFNULL(Compromisos_por_Pagar,0) Compromisos_por_Pagar\n                ,IFNULL(Cuentas_por_Pagar,0) Cuentas_por_Pagar\n                ,IFNULL(Certificado_sin_Comprometer,0) Certificado_sin_Comprometer\n                , Periodo_Act\n                FROM pp_rubros r\n                LEFT JOIN \n                (SELECT \n                 Id_R\n                 ,N_R\n                 ,TipoRubro\n                 ,Presupuesto_Inicial\n                 ,Adicion_Presupuesto\n                 ,Reduccion_Presupuesto\n                 ,Traslados_Debitos\n                 ,Traslados_Creditos\n                 , (Presupuesto_Inicial+Adicion_Presupuesto-Reduccion_Presupuesto-Traslados_Debitos+Traslados_Creditos) Presupuesto_Definitivo\n                  ,Reconocimiento_Anterior\n                 ,Reconocimiento_Actual\n                 ,(Reconocimiento_Anterior+Reconocimiento_Actual) Reconocimiento_Total\n                 ,Recaudo_Anterior\n                 ,Recaudo_Actual\n                 ,(Recaudo_Anterior+Recaudo_Actual) Recaudo_Total\n                 , ((Presupuesto_Inicial+Adicion_Presupuesto-Reduccion_Presupuesto-Traslados_Debitos+Traslados_Creditos) - (Reconocimiento_Anterior+Reconocimiento_Actual)) Saldo_por_Ejecutar\n                 , ((Reconocimiento_Anterior+Reconocimiento_Actual) - (Recaudo_Anterior+Recaudo_Actual)) Saldo_por_Recaudar \n                 ,Disponibilidad_Anterior  AS Certificado_Anterior\n                 ,Disponibilidad_Actual  AS Certificado_Actual\n                 , (Disponibilidad_Anterior+Disponibilidad_Actual) Total_Certificados\n                 ,Compromiso_Anterior\n                 ,Compromiso_Actual\n                 ,(Compromiso_Anterior+Compromiso_Actual) Compromiso_Total\n                 ,Obligacion_Anterior\n                 ,Obligacion_Actual\n                 ,(Obligacion_Anterior+Obligacion_Actual) Total_Obligaciones\n                 ,Pagos_Anterior\n                 ,Pagos_Actual\n                 ,(Pagos_Anterior+ Pagos_Actual) Total_Pagos\n                 ,((Presupuesto_Inicial+Adicion_Presupuesto-Reduccion_Presupuesto-Traslados_Debitos+Traslados_Creditos)- (Disponibilidad_Anterior+Disponibilidad_Actual)) Saldo_Disponible\n                 ,((Presupuesto_Inicial+Adicion_Presupuesto-Reduccion_Presupuesto-Traslados_Debitos+Traslados_Creditos)-(Compromiso_Anterior+Compromiso_Actual)) Sin_Comprometer\n                 ,((Compromiso_Anterior+Compromiso_Actual)-(Pagos_Anterior+ Pagos_Actual)) Compromisos_por_Pagar\n                 ,((Obligacion_Anterior+Obligacion_Actual)-(Pagos_Anterior+ Pagos_Actual)) Cuentas_por_Pagar\n                 ,((Disponibilidad_Anterior+Disponibilidad_Actual)-(Compromiso_Anterior+Compromiso_Actual)) Certificado_sin_Comprometer\n                 ,Periodo_Act\n                FROM \n                (SELECT  \n                Id_R\n                ,N_R\n                ,TipoRubro\n                ,SUM(IFNULL(Presupuesto_Inicial,0)) Presupuesto_Inicial\n                ,SUM(IFNULL(Adicion_Presupuesto,0)) Adicion_Presupuesto\n                ,SUM(IFNULL(Reduccion_Presupuesto,0)) Reduccion_Presupuesto\n                ,SUM(IFNULL(Traslados_Debitos,0)) Traslados_Debitos\n                ,SUM(IFNULL(Traslados_Creditos,0)) Traslados_Creditos\n                ,SUM(IFNULL(Reconocimiento_Anterior,0)) Reconocimiento_Anterior\n                ,SUM(IFNULL(Reconocimiento_Actual,0)) Reconocimiento_Actual\n                ,SUM(IFNULL(Recaudo_Anterior,0)) Recaudo_Anterior\n                ,SUM(IFNULL(Recaudo_Actual,0)) Recaudo_Actual\n                ,SUM(IFNULL(Disponibilidad_Anterior,0)) Disponibilidad_Anterior\n                ,SUM(IFNULL(Disponibilidad_Actual,0)) Disponibilidad_Actual\n                ,SUM(IFNULL(Compromiso_Anterior,0)) Compromiso_Anterior\n                ,SUM(IFNULL(Compromiso_Actual,0)) Compromiso_Actual\n                ,SUM(IFNULL(Obligacion_Anterior,0)) Obligacion_Anterior\n                ,SUM(IFNULL(Obligacion_Actual,0)) Obligacion_Actual\n                ,SUM(IFNULL(Pagos_Anterior,0)) Pagos_Anterior\n                ,SUM(IFNULL(Pagos_Actual,0)) Pagos_Actual\n                ,Periodo_Act\n                FROM \n                (SELECT \n                Id_R\n                ,N_R\n                ,TipoRubro\n                ,CASE WHEN Id_CD=1 THEN \n                   Valor\n                END Presupuesto_Inicial  \n                \n                ,CASE WHEN Id_CD=8  AND Tipo=1 THEN \n                   Valor\n                END Adicion_Presupuesto  \n                \n                ,CASE WHEN Id_CD=8  AND Tipo=0 THEN \n                   Valor \n                END Reduccion_Presupuesto  \n                \n                ,CASE WHEN Id_CD=7 AND Tipo=0 THEN\n                   Valor\n                  END Traslados_Debitos \n                \n                ,CASE WHEN Id_CD=7 AND Tipo=1 THEN \n                 Valor\n                END Traslados_Creditos\n                \n                \n                ,CASE WHEN Id_CD=2  AND Id_Periodo<>Periodo_Act  THEN\n                     Valor\n                 END Reconocimiento_Anterior\n                \n                ,CASE WHEN Id_CD=2  AND Id_Periodo=Periodo_Act  THEN\n                     Valor\n                 END Reconocimiento_Actual\n                \n                ,CASE WHEN Id_CD=3  AND Id_Periodo<>Periodo_Act  THEN\n                     Valor\n                 END Recaudo_Anterior\n                \n                ,CASE WHEN Id_CD=3  AND Id_Periodo=Periodo_Act  THEN\n                     Valor\n                 END Recaudo_Actual\n                \n                \n                ,CASE WHEN Id_CD IN(9,10)  AND Id_Periodo<>Periodo_Act  THEN\n                     Valor\n                     WHEN Id_CD IN(11)  AND Id_Periodo<>Periodo_Act THEN\n                      Valor*(-1)\n                 END Disponibilidad_Anterior\n                \n                ,CASE WHEN Id_CD IN(9,10)  AND Id_Periodo=Periodo_Act  THEN\n                     Valor\n                     WHEN Id_CD IN(11)  AND Id_Periodo=Periodo_Act THEN\n                      Valor*(-1)\n                 END Disponibilidad_Actual\n                \n                ,CASE WHEN Id_CD IN(4,12)  AND Id_Periodo<>Periodo_Act  THEN\n                     Valor\n                     WHEN Id_CD IN(13)  AND Id_Periodo<>Periodo_Act THEN\n                      Valor*(-1)\n                 END Compromiso_Anterior\n                 \n                 ,CASE WHEN Id_CD IN(4,12)  AND Id_Periodo=Periodo_Act  THEN\n                     Valor\n                     WHEN Id_CD IN(13)  AND Id_Periodo=Periodo_Act THEN\n                      Valor*(-1)\n                 END Compromiso_Actual\n                 \n                 ,CASE WHEN Id_CD IN(5,14)  AND Id_Periodo<>Periodo_Act THEN\n                     Valor\n                    WHEN Id_CD IN(15)  AND Id_Periodo<>Periodo_Act THEN\n                      Valor*(-1)\n                 END Obligacion_Anterior\n                 \n                ,CASE WHEN Id_CD IN(5,14)  AND Id_Periodo=Periodo_Act THEN\n                     Valor\n                   WHEN Id_CD IN(15)  AND Id_Periodo=Periodo_Act THEN\n                      Valor*(-1)\n                 END Obligacion_Actual \n                 ,CASE WHEN Id_CD=6 AND Id_Periodo<>Periodo_Act THEN\n                     Valor\n                 END Pagos_Anterior\n                 \n                 ,CASE WHEN Id_CD=6 AND Id_Periodo=Periodo_Act THEN\n                     Valor\n                 END Pagos_Actual\n                 , Periodo_Act\n                     \n                 FROM \n                (SELECT\n                      pp_clase_documento.Id Id_CD \n                     , pp_clase_documento.Nbre N_CD\n                     , pp_rubros.Id Id_R\n                     , pp_rubros.Nbre N_R\n                     ,pp_rubros.TipoRubro \n                    , pp_detalle_movimiento.Tipo\n                    , pp_movimiento.Id_Periodo\n                    , SUM(pp_detalle_movimiento.Valor) Valor\n                    , @Periodo_Act Periodo_Act\n                    \n                FROM (SELECT @Periodo_Act:=" + idPer + ") p,\n                    pp_movimiento\n                    INNER JOIN pp_periodo \n                        ON (pp_movimiento.Id_Periodo = pp_periodo.Id)\n                    INNER JOIN pp_detalle_movimiento \n                        ON (pp_detalle_movimiento.Id_Movimiento = pp_movimiento.Id)\n                    INNER JOIN pp_tipo_documentos \n                        ON (pp_movimiento.Id_TipoDoc = pp_tipo_documentos.Id)\n                    INNER JOIN pp_rubros \n                        ON (pp_detalle_movimiento.Id_Rubro = pp_rubros.Id) AND (pp_rubros.`idEncabezadoRubro`=pp_detalle_movimiento.`idEncabezado`) \n                    INNER JOIN pp_clase_documento \n                        ON (pp_tipo_documentos.Id_ClaseDoc = pp_clase_documento.Id)\n                    WHERE  pp_detalle_movimiento.idEncabezado='" + Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro() + "' AND pp_periodo.Id IN ( SELECT DISTINCT pant.Id  FROM `pp_periodo` pant, (SELECT Id, FechaI,FechaF FROM `pp_periodo`\n                \t\t\t\tWHERE Id IN(" + idPer + ") ) pact\n                \t\t\t\tWHERE (DATE_FORMAT(pant.FechaI,'%Y')=DATE_FORMAT(pact.FechaI,'%Y') AND pant.FechaF<=pact.FechaI)\n                \t\t\t\tOR pact.Id=pant.id\n                \t\t\t      ) \t\n                    AND pp_movimiento.Id_MotivoAnulacion=1 AND pp_movimiento.Id_MotivoAnulacion=1\n                 GROUP BY  pp_clase_documento.Id   , pp_clase_documento.Nbre, pp_rubros.Id ,pp_detalle_movimiento.Tipo ,pp_movimiento.Id_Periodo\n                 ) datos\n                 ) datos\n                GROUP BY Id_R ,N_R,TipoRubro\n                ) datos ) datos\n                ON r.Id=datos.Id_R WHERE r.`idEncabezadoRubro`='" + Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro() + "';";
        System.out.println("-> Sql decreto " + this.sql);
        this.xct.ejecutarSQL(this.sql);
        this.sql = "UPDATE pp_tem_rubros_trim_c P\n                INNER JOIN\n                (SELECT \n                 A.Id\n                ,SUM(B.Presupuesto_Inicial) Presupuesto_Inicial\n                ,SUM(B.Adicion_Presupuesto) Adicion_Presupuesto\n                ,SUM(B.Reduccion_Presupuesto) Reduccion_Presupuesto\n                ,SUM(B.Traslados_Debitos) Traslados_Debitos\n                ,SUM(B.Traslados_Creditos) Traslados_Creditos\n                ,SUM(B.Presupuesto_Definitivo) Presupuesto_Definitivo\n                ,SUM(B.Reconocimiento_Anterior) Reconocimiento_Anterior\n                ,SUM(B.Reconocimiento_Actual) Reconocimiento_Actual\n                ,SUM(B.Reconocimiento_Total) Reconocimiento_Total\n                ,SUM(B.Recaudo_Anterior) Recaudo_Anterior\n                ,SUM(B.Recaudo_Actual) Recaudo_Actual\n                ,SUM(B.Recaudo_Total) Recaudo_Total\n                ,SUM(B.Saldo_por_Ejecutar) Saldo_por_Ejecutar\n                ,SUM(B.Saldo_por_Recaudar ) Saldo_por_Recaudar\n                ,SUM(B.Certificado_Anterior) Certificado_Anterior\n                ,SUM(B.Certificado_Actual) Certificado_Actual\n                ,SUM(B.Total_Certificados) Total_Certificados\n                ,SUM(B.Compromiso_Anterior) Compromiso_Anterior\n                ,SUM(B.Compromiso_Actual) Compromiso_Actual\n                ,SUM(B.Compromiso_Total) Compromiso_Total\n                ,SUM(B.Obligacion_Anterior) Obligacion_Anterior\n                ,SUM(B.Obligacion_Actual) Obligacion_Actual\n                ,SUM(B.Total_Obligaciones) Total_Obligaciones\n                ,SUM(B.Pagos_Anterior) Pagos_Anterior\n                ,SUM(B.Pagos_Actual) Pagos_Actual\n                ,SUM(B.Total_Pagos) Total_Pagos\n                ,SUM(B.Saldo_Disponible) Saldo_Disponible\n                ,SUM(B.Sin_Comprometer) Sin_Comprometer\n                ,SUM(B.Compromisos_por_Pagar) Compromisos_por_Pagar\n                ,SUM(B.Cuentas_por_Pagar) Cuentas_por_Pagar\n                ,SUM(B.Certificado_sin_Comprometer) Certificado_sin_Comprometer\n                ,B.`Periodo_Act`\n                FROM pp_tem_rubros_trim_c A\n                INNER JOIN\n                pp_tem_rubros_trim_c B\n                ON A.Id= B.IdPadre \n                GROUP BY A.Id) A\n                ON P.Id=A.Id  \n                SET \tP.Presupuesto_Inicial=A.Presupuesto_Inicial\n                ,\tP.Adicion_Presupuesto\t=\tA.Adicion_Presupuesto\n                ,\tP.Reduccion_Presupuesto\t=\tA.Reduccion_Presupuesto\n                ,\tP.Traslados_Debitos\t=\tA.Traslados_Debitos\n                ,\tP.Traslados_Creditos\t=\tA.Traslados_Creditos\n                ,\tP.Presupuesto_Definitivo\t=\tA.Presupuesto_Definitivo\n                ,\tP.Reconocimiento_Anterior\t=\tA.Reconocimiento_Anterior\n                ,\tP.Reconocimiento_Actual\t=\tA.Reconocimiento_Actual\n                ,\tP.Reconocimiento_Total\t=\tA.Reconocimiento_Total\n                ,\tP.Recaudo_Anterior\t=\tA.Recaudo_Anterior\n                ,\tP.Recaudo_Actual\t=\tA.Recaudo_Actual\n                ,\tP.Recaudo_Total\t=\tA.Recaudo_Total\n                ,\tP.Saldo_por_Ejecutar\t=\tA.Saldo_por_Ejecutar\n                ,\tP.Saldo_por_Recaudar \t=\tA.Saldo_por_Recaudar \n                ,\tP.Certificado_Anterior\t=\tA.Certificado_Anterior\n                ,\tP.Certificado_Actual\t=\tA.Certificado_Actual\n                ,\tP.Total_Certificados\t=\tA.Total_Certificados\n                ,\tP.Compromiso_Anterior\t=\tA.Compromiso_Anterior\n                ,\tP.Compromiso_Actual\t=\tA.Compromiso_Actual\n                ,\tP.Compromiso_Total\t=\tA.Compromiso_Total\n                ,\tP.Obligacion_Anterior\t=\tA.Obligacion_Anterior\n                ,\tP.Obligacion_Actual\t=\tA.Obligacion_Actual\n                ,\tP.Total_Obligaciones\t=\tA.Total_Obligaciones\n                ,\tP.Pagos_Anterior\t=\tA.Pagos_Anterior\n                ,\tP.Pagos_Actual\t=\tA.Pagos_Actual\n                ,\tP.Total_Pagos\t=\tA.Total_Pagos\n                ,\tP.Saldo_Disponible\t=\tA.Saldo_Disponible\n                ,\tP.Sin_Comprometer\t=\tA.Sin_Comprometer\n                ,\tP.Compromisos_por_Pagar\t=\tA.Compromisos_por_Pagar\n                ,\tP.Cuentas_por_Pagar\t=\tA.Cuentas_por_Pagar\n                ,\tP.Certificado_sin_Comprometer\t=\tA.Certificado_sin_Comprometer\n                ,\tP.Periodo_Act=A.Periodo_Act;";
        for (int i = 0; i < 50; i++) {
            this.xct.ejecutarSQL(this.sql);
        }
        this.sql = "INSERT INTO  pp_tem_rubros_trim \n SELECT * FROM pp_tem_rubros_trim_c ";
        this.xct.ejecutarSQL(this.sql);
    }

    private void mLlenarDatos() {
        if (this.btnMensual.isSelected()) {
            if (this.JCBPeriodo.getSelectedIndex() != -1) {
                this.idPeriodo = this.xid[this.JCBPeriodo.getSelectedIndex()];
                this.sql = "TRUNCATE TABLE pp_tem_rubros_trim";
                this.xct.ejecutarSQL(this.sql);
                mLlenarDatosMes(this.idPeriodo);
            } else {
                JOptionPane.showMessageDialog(this, "Debe seleccionar un periodo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JCBPeriodo.requestFocus();
            }
        } else {
            mValidarTrimestre();
            this.sql = "TRUNCATE TABLE pp_tem_rubros_trim";
            this.xct.ejecutarSQL(this.sql);
            this.xPeriodos = "";
            for (int contador = 0; contador < 3; contador++) {
                this.sql = "SELECT Id FROM pp_periodo WHERE (DATE_FORMAT(FechaI,'%Y')='" + this.JYCAno.getValue() + "') AND DATE_FORMAT(FechaI,'%m')='" + this.mes[contador] + "'";
                this.idPeriodo = this.xct.traerDato(this.sql);
                this.xPeriodos += "," + this.idPeriodo;
                mLlenarDatosMes(this.idPeriodo);
            }
        }
        this.sql = "DROP TABLE IF EXISTS pp_trim_decreto2193";
        this.xct.ejecutarSQL(this.sql);
        if (this.btnMensual.isSelected()) {
            this.sql = "CREATE TABLE  pp_trim_decreto2193\nSELECT D.Id\n\t,D.CodigoAlterno\n\t,D.Nbre\n\t,D.Id_Padre\n\t,D.Tipo\n\t,D.Posicion\n\t,Presupuesto_Definitivo\n\t,Reconocimiento_Total \n\t,Recaudo_MES\n\t,Recaudo_Total\n\t,Comprometido \n\t,Obligaciones \n\t,Pagos_MES       \n\t,Pagos_Acumulados\nFROM pp_det_resoluciones D\nLEFT JOIN\n\t(SELECT MES.CodigoAlterno\n\t       ,MES.TipoRubro\n\t       ,MES.Presupuesto_Definitivo\n\t       ,MES.Reconocimiento_Total \n\t       ,MES.Recaudo_MES\n\t       ,MES.Recaudo_Total\n\t       ,MES.Comprometido \n\t       ,MES.Obligaciones \n\t       ,MES.Pagos_MES       \n\t       ,MES.Pagos_Acumulados\n\tFROM\n\t \n\t(SELECT Periodo_Act\n\t\t,CodigoAlterno \n\t\t,TipoRubro\n\t\t,Presupuesto_Definitivo \n\t\t,Reconocimiento_Total\n\t\t\n\t\t,CASE WHEN Periodo_Act=Periodo3 THEN \n\t\t\tIFNULL(Recaudo_Actual,0)\n\t\tELSE 0\t\n\t\tEND Recaudo_MES\n\t\t\n\t\t,Recaudo_Total\n\t\t\n\t\t, Compromiso_Total Comprometido\n\t\t, Total_Obligaciones Obligaciones\n\t\t\n\t\t\n\t\t,CASE WHEN Periodo_Act=Periodo3 THEN \n\t\t\tIFNULL(Pagos_Actual,0)\n\t\tELSE 0\t\n\t\tEND Pagos_MES\n\t\t, Total_Pagos Pagos_Acumulados\n\t\t,Periodo3\n\t\t\t\n\t\tFROM \n\t(SELECT \n\t\tB.Periodo_Act\n\t\t,res.CodigoAlterno \n\t\t,B.TipoRubro \n\t\t,SUM(B.Presupuesto_Inicial) Presupuesto_Inicial\n\t\t\t,SUM(B.Adicion_Presupuesto) Adicion_Presupuesto\n\t\t\t,SUM(B.Reduccion_Presupuesto) Reduccion_Presupuesto\n\t\t\t,SUM(B.Traslados_Debitos) Traslados_Debitos\n\t\t\t,SUM(B.Traslados_Creditos) Traslados_Creditos\n\t\t\t,SUM(B.Presupuesto_Definitivo) Presupuesto_Definitivo\n\t\t\t,SUM(B.Reconocimiento_Anterior) Reconocimiento_Anterior\n\t\t\t,SUM(B.Reconocimiento_Actual) Reconocimiento_Actual\n\t\t\t,SUM(B.Reconocimiento_Total) Reconocimiento_Total\n\t\t\t,SUM(B.Recaudo_Anterior) Recaudo_Anterior\n\t\t\t,SUM(B.Recaudo_Actual) Recaudo_Actual\n\t\t\t,SUM(B.Recaudo_Total) Recaudo_Total\n\t\t\t,SUM(B.Saldo_por_Ejecutar) Saldo_por_Ejecutar\n\t\t\t,SUM(B.Saldo_por_Recaudar ) Saldo_por_Recaudar\n\t\t\t,SUM(B.Certificado_Anterior) Certificado_Anterior\n\t\t\t,SUM(B.Certificado_Actual) Certificado_Actual\n\t\t\t,SUM(B.Total_Certificados) Total_Certificados\n\t\t\t,SUM(B.Compromiso_Anterior) Compromiso_Anterior\n\t\t\t,SUM(B.Compromiso_Actual) Compromiso_Actual\n\t\t\t,SUM(B.Compromiso_Total) Compromiso_Total\n\t\t\t,SUM(B.Obligacion_Anterior) Obligacion_Anterior\n\t\t\t,SUM(B.Obligacion_Actual) Obligacion_Actual\n\t\t\t,SUM(B.Total_Obligaciones) Total_Obligaciones\n\t\t\t,SUM(B.Pagos_Anterior) Pagos_Anterior\n\t\t\t,SUM(B.Pagos_Actual) Pagos_Actual\n\t\t\t,SUM(B.Total_Pagos) Total_Pagos\n\t\t\t,SUM(B.Saldo_Disponible) Saldo_Disponible\n\t\t\t,SUM(B.Sin_Comprometer) Sin_Comprometer\n\t\t\t,SUM(B.Compromisos_por_Pagar) Compromisos_por_Pagar\n\t\t\t,SUM(B.Cuentas_por_Pagar) Cuentas_por_Pagar\n\t\t\t,SUM(B.Certificado_sin_Comprometer) Certificado_sin_Comprometer\t\n\t\t\t, @Periodo3 Periodo3 \n\t\tFROM (SELECT @Periodo3:=(SELECT id FROM pp_periodo WHERE Id IN(" + this.idPeriodo + ") AND FechaI=(SELECT MAX(FechaI) FechaM FROM pp_periodo WHERE Id IN (" + this.idPeriodo + ")))) p ,\n\t\tpp_tem_rubros_trim B\n\tINNER JOIN pp_resoluciones_rubro res\n\tON B.Id = res.IdRubro\n\tWHERE res.IdResolucion=1\n\tGROUP BY Periodo_Act, CodigoAlterno\n\tORDER BY Periodo_Act, TipoRubro DESC, CodigoAlterno ) AUX\n\tWHERE Periodo_Act=@Periodo3\n\t) MES\n\t\n\t ) TRI\n ON D.CodigoAlterno=TRI.CodigoAlterno AND D.IdResolucion=1 AND D.Tipo=TRI.TipoRubro\nORDER BY D.Tipo , D.Posicion";
            this.xct.ejecutarSQL("sql creacion tabla -> " + this.sql);
            this.sql = "UPDATE pp_trim_decreto2193 P\n                INNER JOIN\n                (SELECT \n                 A.Id\n                \n                ,SUM(B.Presupuesto_Definitivo) Presupuesto_Definitivo\n                ,SUM(B.Reconocimiento_Total) Reconocimiento_Total\n                ,SUM(B.Recaudo_MES) Recaudo_MES\n                ,SUM(B.Recaudo_Total) Recaudo_Total\n                ,SUM(B.Comprometido) Comprometido\n                ,SUM(B.Obligaciones) Obligaciones\n                ,SUM(B.Pagos_MES) Pagos_MES\n\t\t        ,SUM(B.Pagos_Acumulados) Pagos_Acumulados\n                \n                FROM pp_trim_decreto2193 A\n                INNER JOIN\n                pp_trim_decreto2193 B\n                ON A.Id= B.Id_Padre \n                GROUP BY A.Id) A\n                ON P.Id=A.Id  \n                SET \tP.Presupuesto_Definitivo=A.Presupuesto_Definitivo\n                ,\tP.Reconocimiento_Total\t=\tA.Reconocimiento_Total\n                ,\tP.Recaudo_MES\t=\tA.Recaudo_MES\n                ,\tP.Recaudo_Total\t=\tA.Recaudo_Total\n                ,\tP.Comprometido\t=\tA.Comprometido\n                ,\tP.Obligaciones\t=\tA.Obligaciones\n                ,\tP.Pagos_MES\t=\tA.Pagos_MES\n                ,\tP.Pagos_Acumulados\t=\tA.Pagos_Acumulados;";
            for (int i = 0; i < 50; i++) {
                this.xct.ejecutarSQL(this.sql);
            }
        } else {
            String per = this.xPeriodos.substring(1, this.xPeriodos.length());
            this.sql = "CREATE TABLE  pp_trim_decreto2193\nSELECT D.Id\n\t,D.CodigoAlterno\n\t,D.Nbre\n\t,D.Id_Padre\n\t,D.Tipo\n\t,D.Posicion\n\t,Presupuesto_Definitivo\n\t,Reconocimiento_Total \n\t,Recaudo_Mes1\n\t,Recaudo_Mes2\n\t,Recaudo_Mes3\n\t,Recaudo_Total\n\t,Comprometido \n\t,Obligaciones \n\t,Pagos_Mes1\n\t,Pagos_Mes2\n\t,Pagos_Mes3       \n\t,Pagos_Acumulados\nFROM pp_det_resoluciones D\nLEFT JOIN\n\t(SELECT MES1.CodigoAlterno\n\t       ,MES1.TipoRubro\n\t       ,MES3.Presupuesto_Definitivo\n\t       ,MES3.Reconocimiento_Total \n\t       ,MES1.Recaudo_Mes1\n\t       ,MES2.Recaudo_Mes2\n\t       ,MES3.Recaudo_Mes3\n\t       ,MES3.Recaudo_Total\n\t       ,MES3.Comprometido \n\t       ,MES3.Obligaciones \n\t       ,MES1.Pagos_Mes1\n\t       ,MES2.Pagos_Mes2\n\t       ,MES3.Pagos_Mes3       \n\t       ,MES3.Pagos_Acumulados\n\tFROM\n\t(SELECT Periodo_Act\n\t\t,CodigoAlterno \n\t\t,TipoRubro\n\t\t\n\t\t,CASE WHEN Periodo_Act=Periodo1 THEN \n\t\t\tIFNULL(Recaudo_Actual,0)\n\t\tELSE 0\t\n\t\tEND Recaudo_Mes1\n\t\t,CASE WHEN Periodo_Act=Periodo1 THEN \n\t\t\tIFNULL(Pagos_Actual,0)\n\t\tELSE 0\t\n\t\tEND Pagos_Mes1\n\t       \n\t\tFROM \n\t(SELECT \n\t\tB.Periodo_Act\n\t\t,res.CodigoAlterno \n\t\t,B.TipoRubro \n\t\t,SUM(B.Presupuesto_Inicial) Presupuesto_Inicial\n\t\t\t,SUM(B.Adicion_Presupuesto) Adicion_Presupuesto\n\t\t\t,SUM(B.Reduccion_Presupuesto) Reduccion_Presupuesto\n\t\t\t,SUM(B.Traslados_Debitos) Traslados_Debitos\n\t\t\t,SUM(B.Traslados_Creditos) Traslados_Creditos\n\t\t\t,SUM(B.Presupuesto_Definitivo) Presupuesto_Definitivo\n\t\t\t,SUM(B.Reconocimiento_Anterior) Reconocimiento_Anterior\n\t\t\t,SUM(B.Reconocimiento_Actual) Reconocimiento_Actual\n\t\t\t,SUM(B.Reconocimiento_Total) Reconocimiento_Total\n\t\t\t,SUM(B.Recaudo_Anterior) Recaudo_Anterior\n\t\t\t,SUM(B.Recaudo_Actual) Recaudo_Actual\n\t\t\t,SUM(B.Recaudo_Total) Recaudo_Total\n\t\t\t,SUM(B.Saldo_por_Ejecutar) Saldo_por_Ejecutar\n\t\t\t,SUM(B.Saldo_por_Recaudar ) Saldo_por_Recaudar\n\t\t\t,SUM(B.Certificado_Anterior) Certificado_Anterior\n\t\t\t,SUM(B.Certificado_Actual) Certificado_Actual\n\t\t\t,SUM(B.Total_Certificados) Total_Certificados\n\t\t\t,SUM(B.Compromiso_Anterior) Compromiso_Anterior\n\t\t\t,SUM(B.Compromiso_Actual) Compromiso_Actual\n\t\t\t,SUM(B.Compromiso_Total) Compromiso_Total\n\t\t\t,SUM(B.Obligacion_Anterior) Obligacion_Anterior\n\t\t\t,SUM(B.Obligacion_Actual) Obligacion_Actual\n\t\t\t,SUM(B.Total_Obligaciones) Total_Obligaciones\n\t\t\t,SUM(B.Pagos_Anterior) Pagos_Anterior\n\t\t\t,SUM(B.Pagos_Actual) Pagos_Actual\n\t\t\t,SUM(B.Total_Pagos) Total_Pagos\n\t\t\t,SUM(B.Saldo_Disponible) Saldo_Disponible\n\t\t\t,SUM(B.Sin_Comprometer) Sin_Comprometer\n\t\t\t,SUM(B.Compromisos_por_Pagar) Compromisos_por_Pagar\n\t\t\t,SUM(B.Cuentas_por_Pagar) Cuentas_por_Pagar\n\t\t\t,SUM(B.Certificado_sin_Comprometer) Certificado_sin_Comprometer\t\n\t\t\t,@Periodo1 Periodo1 \n\t\tFROM (SELECT @Periodo1:=(SELECT id FROM pp_periodo WHERE Id IN(" + per + ") AND FechaI=(SELECT MIN(FechaI) FechaM FROM pp_periodo WHERE Id IN (" + per + ")))) p1,pp_tem_rubros_trim B\n\tLEFT JOIN pp_resoluciones_rubro res\n\tON B.Id = res.IdRubro\n\tWHERE res.IdResolucion=1\n\tGROUP BY Periodo_Act, CodigoAlterno\n\tORDER BY Periodo_Act, TipoRubro DESC, CodigoAlterno ) AUX\n\tWHERE Periodo_Act= @Periodo1\n\t) MES1\n\tINNER JOIN \n\n\t(SELECT Periodo_Act\n\t\t,CodigoAlterno \n\t\t,TipoRubro\n\t\t\n\t\t,CASE WHEN Periodo_Act=Periodo2 THEN \n\t\t\tIFNULL(Recaudo_Actual,0)\n\t\tELSE 0\t\n\t\tEND Recaudo_Mes2\n\t\t,CASE WHEN Periodo_Act=Periodo2 THEN \n\t\t\tIFNULL(Pagos_Actual,0)\n\t\tELSE 0\t\n\t\tEND Pagos_Mes2\n\t       \n\t\tFROM \n\t(SELECT \n\t\tB.Periodo_Act\n\t\t,res.CodigoAlterno \n\t\t,B.TipoRubro \n\t\t,SUM(B.Presupuesto_Inicial) Presupuesto_Inicial\n\t\t\t,SUM(B.Adicion_Presupuesto) Adicion_Presupuesto\n\t\t\t,SUM(B.Reduccion_Presupuesto) Reduccion_Presupuesto\n\t\t\t,SUM(B.Traslados_Debitos) Traslados_Debitos\n\t\t\t,SUM(B.Traslados_Creditos) Traslados_Creditos\n\t\t\t,SUM(B.Presupuesto_Definitivo) Presupuesto_Definitivo\n\t\t\t,SUM(B.Reconocimiento_Anterior) Reconocimiento_Anterior\n\t\t\t,SUM(B.Reconocimiento_Actual) Reconocimiento_Actual\n\t\t\t,SUM(B.Reconocimiento_Total) Reconocimiento_Total\n\t\t\t,SUM(B.Recaudo_Anterior) Recaudo_Anterior\n\t\t\t,SUM(B.Recaudo_Actual) Recaudo_Actual\n\t\t\t,SUM(B.Recaudo_Total) Recaudo_Total\n\t\t\t,SUM(B.Saldo_por_Ejecutar) Saldo_por_Ejecutar\n\t\t\t,SUM(B.Saldo_por_Recaudar ) Saldo_por_Recaudar\n\t\t\t,SUM(B.Certificado_Anterior) Certificado_Anterior\n\t\t\t,SUM(B.Certificado_Actual) Certificado_Actual\n\t\t\t,SUM(B.Total_Certificados) Total_Certificados\n\t\t\t,SUM(B.Compromiso_Anterior) Compromiso_Anterior\n\t\t\t,SUM(B.Compromiso_Actual) Compromiso_Actual\n\t\t\t,SUM(B.Compromiso_Total) Compromiso_Total\n\t\t\t,SUM(B.Obligacion_Anterior) Obligacion_Anterior\n\t\t\t,SUM(B.Obligacion_Actual) Obligacion_Actual\n\t\t\t,SUM(B.Total_Obligaciones) Total_Obligaciones\n\t\t\t,SUM(B.Pagos_Anterior) Pagos_Anterior\n\t\t\t,SUM(B.Pagos_Actual) Pagos_Actual\n\t\t\t,SUM(B.Total_Pagos) Total_Pagos\n\t\t\t,SUM(B.Saldo_Disponible) Saldo_Disponible\n\t\t\t,SUM(B.Sin_Comprometer) Sin_Comprometer\n\t\t\t,SUM(B.Compromisos_por_Pagar) Compromisos_por_Pagar\n\t\t\t,SUM(B.Cuentas_por_Pagar) Cuentas_por_Pagar\n\t\t\t,SUM(B.Certificado_sin_Comprometer) Certificado_sin_Comprometer\t\n\t\t\t, @Periodo2 Periodo2\n\t\tFROM (SELECT @Periodo2:= (SELECT id FROM pp_periodo WHERE Id IN(" + per + ") AND FechaI>(SELECT MIN(FechaI) FechaM FROM pp_periodo WHERE Id IN (" + per + "))\n\tAND FechaI<(SELECT MAX(FechaI) FechaM FROM pp_periodo WHERE Id IN (" + per + ")) ) ) p2, pp_tem_rubros_trim B\n\tINNER JOIN pp_resoluciones_rubro res\n\tON B.Id = res.IdRubro\n\tWHERE res.IdResolucion=1\n\tGROUP BY Periodo_Act, CodigoAlterno\n\tORDER BY Periodo_Act, TipoRubro DESC, CodigoAlterno ) AUX\n\tWHERE Periodo_Act= @Periodo2\n\t) MES2\n\t ON MES1.CodigoAlterno = MES2.CodigoAlterno AND MES1.TipoRubro = MES2.TipoRubro\n\tLEFT JOIN \n\t(SELECT Periodo_Act\n\t\t,CodigoAlterno \n\t\t,TipoRubro\n\t\t,Presupuesto_Definitivo \n\t\t,Reconocimiento_Total\n\t\t\n\t\t,CASE WHEN Periodo_Act=Periodo3 THEN \n\t\t\tIFNULL(Recaudo_Actual,0)\n\t\tELSE 0\t\n\t\tEND Recaudo_Mes3\n\t\t\n\t\t,Recaudo_Total\n\t\t\n\t\t, Compromiso_Total Comprometido\n\t\t, Total_Obligaciones Obligaciones\n\t\t\n\t\t\n\t\t,CASE WHEN Periodo_Act=Periodo3 THEN \n\t\t\tIFNULL(Pagos_Actual,0)\n\t\tELSE 0\t\n\t\tEND Pagos_Mes3\n\t\t, Total_Pagos Pagos_Acumulados\n\t\t,Periodo3\n\t\t\t\n\t\tFROM \n\t(SELECT \n\t\tB.Periodo_Act\n\t\t,res.CodigoAlterno \n\t\t,B.TipoRubro \n\t\t,SUM(B.Presupuesto_Inicial) Presupuesto_Inicial\n\t\t\t,SUM(B.Adicion_Presupuesto) Adicion_Presupuesto\n\t\t\t,SUM(B.Reduccion_Presupuesto) Reduccion_Presupuesto\n\t\t\t,SUM(B.Traslados_Debitos) Traslados_Debitos\n\t\t\t,SUM(B.Traslados_Creditos) Traslados_Creditos\n\t\t\t,SUM(B.Presupuesto_Definitivo) Presupuesto_Definitivo\n\t\t\t,SUM(B.Reconocimiento_Anterior) Reconocimiento_Anterior\n\t\t\t,SUM(B.Reconocimiento_Actual) Reconocimiento_Actual\n\t\t\t,SUM(B.Reconocimiento_Total) Reconocimiento_Total\n\t\t\t,SUM(B.Recaudo_Anterior) Recaudo_Anterior\n\t\t\t,SUM(B.Recaudo_Actual) Recaudo_Actual\n\t\t\t,SUM(B.Recaudo_Total) Recaudo_Total\n\t\t\t,SUM(B.Saldo_por_Ejecutar) Saldo_por_Ejecutar\n\t\t\t,SUM(B.Saldo_por_Recaudar ) Saldo_por_Recaudar\n\t\t\t,SUM(B.Certificado_Anterior) Certificado_Anterior\n\t\t\t,SUM(B.Certificado_Actual) Certificado_Actual\n\t\t\t,SUM(B.Total_Certificados) Total_Certificados\n\t\t\t,SUM(B.Compromiso_Anterior) Compromiso_Anterior\n\t\t\t,SUM(B.Compromiso_Actual) Compromiso_Actual\n\t\t\t,SUM(B.Compromiso_Total) Compromiso_Total\n\t\t\t,SUM(B.Obligacion_Anterior) Obligacion_Anterior\n\t\t\t,SUM(B.Obligacion_Actual) Obligacion_Actual\n\t\t\t,SUM(B.Total_Obligaciones) Total_Obligaciones\n\t\t\t,SUM(B.Pagos_Anterior) Pagos_Anterior\n\t\t\t,SUM(B.Pagos_Actual) Pagos_Actual\n\t\t\t,SUM(B.Total_Pagos) Total_Pagos\n\t\t\t,SUM(B.Saldo_Disponible) Saldo_Disponible\n\t\t\t,SUM(B.Sin_Comprometer) Sin_Comprometer\n\t\t\t,SUM(B.Compromisos_por_Pagar) Compromisos_por_Pagar\n\t\t\t,SUM(B.Cuentas_por_Pagar) Cuentas_por_Pagar\n\t\t\t,SUM(B.Certificado_sin_Comprometer) Certificado_sin_Comprometer\t\n\t\t\t, @Periodo3 Periodo3 \n\t\tFROM (SELECT @Periodo3:=(SELECT id FROM pp_periodo WHERE Id IN(" + per + ") AND FechaI=(SELECT MAX(FechaI) FechaM FROM pp_periodo WHERE Id IN (" + per + ")))) p ,\n\t\tpp_tem_rubros_trim B\n\tINNER JOIN pp_resoluciones_rubro res\n\tON B.Id = res.IdRubro\n\tWHERE res.IdResolucion=1\n\tGROUP BY Periodo_Act, CodigoAlterno\n\tORDER BY Periodo_Act, TipoRubro DESC, CodigoAlterno ) AUX\n\tWHERE Periodo_Act=@Periodo3\n\t) MES3\n\t ON MES1.CodigoAlterno = MES3.CodigoAlterno AND MES1.TipoRubro = MES3.TipoRubro\n\t ) TRI\n ON D.CodigoAlterno=TRI.CodigoAlterno AND D.IdResolucion=1 AND D.Tipo=TRI.TipoRubro\nORDER BY D.Tipo , D.Posicion";
            this.xct.ejecutarSQL(this.sql);
            this.sql = "UPDATE pp_trim_decreto2193 P\n                INNER JOIN\n                (SELECT \n                 A.Id\n                \n                ,SUM(B.Presupuesto_Definitivo) Presupuesto_Definitivo\n                ,SUM(B.Reconocimiento_Total) Reconocimiento_Total\n                ,SUM(B.Recaudo_Mes1) Recaudo_Mes1\n                ,SUM(B.Recaudo_Mes2) Recaudo_Mes2\n                ,SUM(B.Recaudo_Mes3) Recaudo_Mes3\n                ,SUM(B.Recaudo_Total) Recaudo_Total\n                ,SUM(B.Comprometido) Comprometido\n                ,SUM(B.Obligaciones) Obligaciones\n                ,SUM(B.Pagos_Mes1) Pagos_Mes1\n\t\t,SUM(B.Pagos_Mes2) Pagos_Mes2\n\t\t,SUM(B.Pagos_Mes3) Pagos_Mes3\t\t\n                ,SUM(B.Pagos_Acumulados) Pagos_Acumulados\n                \n                FROM pp_trim_decreto2193 A\n                INNER JOIN\n                pp_trim_decreto2193 B\n                ON A.Id= B.Id_Padre \n                GROUP BY A.Id) A\n                ON P.Id=A.Id  \n                SET \tP.Presupuesto_Definitivo=A.Presupuesto_Definitivo\n                ,\tP.Reconocimiento_Total\t=\tA.Reconocimiento_Total\n                ,\tP.Recaudo_Mes1\t=\tA.Recaudo_Mes1\n                ,\tP.Recaudo_Mes2\t=\tA.Recaudo_Mes2\n                ,\tP.Recaudo_Mes3\t=\tA.Recaudo_Mes3\n                ,\tP.Recaudo_Total\t=\tA.Recaudo_Total\n                ,\tP.Comprometido\t=\tA.Comprometido\n                ,\tP.Obligaciones\t=\tA.Obligaciones\n                ,\tP.Pagos_Mes1\t=\tA.Pagos_Mes1\n                ,\tP.Pagos_Mes2\t=\tA.Pagos_Mes2\n                ,\tP.Pagos_Mes3\t=\tA.Pagos_Mes3\n                ,\tP.Pagos_Acumulados\t=\tA.Pagos_Acumulados;";
            for (int i2 = 0; i2 < 50; i2++) {
                this.xct.ejecutarSQL(this.sql);
            }
        }
        this.xct.cerrarConexionBd();
        this.sql = "SELECT * FROM pp_trim_decreto2193";
        if (this.btnMensual.isSelected()) {
            this.filaGridI = 0;
            this.filaGridG = 0;
            mCrearGridIngresos_mes();
            mCrearGridGastos_mes();
            ResultSet xrs = this.xct.traerRs(this.sql);
            while (xrs.next()) {
                try {
                    if (xrs.getString("Tipo").equals("I")) {
                        this.modeloI.addRow(this.datoI);
                        this.modeloI.setValueAt(xrs.getString("CodigoAlterno"), this.filaGridI, 0);
                        this.modeloI.setValueAt(xrs.getString("Nbre"), this.filaGridI, 1);
                        this.modeloI.setValueAt(Double.valueOf(xrs.getDouble("Presupuesto_Definitivo")), this.filaGridI, 2);
                        this.modeloI.setValueAt(Double.valueOf(xrs.getDouble("Reconocimiento_Total")), this.filaGridI, 3);
                        this.modeloI.setValueAt(Double.valueOf(xrs.getDouble("Recaudo_MES")), this.filaGridI, 4);
                        this.modeloI.setValueAt(Double.valueOf(xrs.getDouble("Recaudo_Total")), this.filaGridI, 5);
                        this.filaGridI++;
                    } else {
                        this.modeloG.addRow(this.datoG);
                        this.modeloG.setValueAt(xrs.getString("CodigoAlterno"), this.filaGridG, 0);
                        this.modeloG.setValueAt(xrs.getString("Nbre"), this.filaGridG, 1);
                        this.modeloG.setValueAt(Double.valueOf(xrs.getDouble("Presupuesto_Definitivo")), this.filaGridG, 2);
                        this.modeloG.setValueAt(Double.valueOf(xrs.getDouble("Comprometido")), this.filaGridG, 3);
                        this.modeloG.setValueAt(Double.valueOf(xrs.getDouble("Obligaciones")), this.filaGridG, 4);
                        this.modeloG.setValueAt(Double.valueOf(xrs.getDouble("Pagos_MES")), this.filaGridG, 5);
                        this.modeloG.setValueAt(Double.valueOf(xrs.getDouble("Pagos_Acumulados")), this.filaGridG, 6);
                        this.filaGridG++;
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(JIFConsultaDec2193.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                    return;
                }
            }
            xrs.close();
            return;
        }
        this.filaGridI = 0;
        this.filaGridG = 0;
        mCrearGridIngresos();
        mCrearGridGastos();
        ResultSet xrs2 = this.xct.traerRs(this.sql);
        while (xrs2.next()) {
            try {
                if (xrs2.getString("Tipo").equals("I")) {
                    this.modeloI.addRow(this.datoI);
                    this.modeloI.setValueAt(xrs2.getString("CodigoAlterno"), this.filaGridI, 0);
                    this.modeloI.setValueAt(xrs2.getString("Nbre"), this.filaGridI, 1);
                    this.modeloI.setValueAt(Double.valueOf(xrs2.getDouble("Presupuesto_Definitivo")), this.filaGridI, 2);
                    this.modeloI.setValueAt(Double.valueOf(xrs2.getDouble("Reconocimiento_Total")), this.filaGridI, 3);
                    this.modeloI.setValueAt(Double.valueOf(xrs2.getDouble("Recaudo_Mes1")), this.filaGridI, 4);
                    this.modeloI.setValueAt(Double.valueOf(xrs2.getDouble("Recaudo_Mes2")), this.filaGridI, 5);
                    this.modeloI.setValueAt(Double.valueOf(xrs2.getDouble("Recaudo_Mes3")), this.filaGridI, 6);
                    this.modeloI.setValueAt(Double.valueOf(xrs2.getDouble("Recaudo_Total")), this.filaGridI, 7);
                    this.filaGridI++;
                } else {
                    this.modeloG.addRow(this.datoG);
                    this.modeloG.setValueAt(xrs2.getString("CodigoAlterno"), this.filaGridG, 0);
                    this.modeloG.setValueAt(xrs2.getString("Nbre"), this.filaGridG, 1);
                    this.modeloG.setValueAt(Double.valueOf(xrs2.getDouble("Presupuesto_Definitivo")), this.filaGridG, 2);
                    this.modeloG.setValueAt(Double.valueOf(xrs2.getDouble("Comprometido")), this.filaGridG, 3);
                    this.modeloG.setValueAt(Double.valueOf(xrs2.getDouble("Obligaciones")), this.filaGridG, 4);
                    this.modeloG.setValueAt(Double.valueOf(xrs2.getDouble("Pagos_Mes1")), this.filaGridG, 5);
                    this.modeloG.setValueAt(Double.valueOf(xrs2.getDouble("Pagos_Mes2")), this.filaGridG, 6);
                    this.modeloG.setValueAt(Double.valueOf(xrs2.getDouble("Pagos_Mes3")), this.filaGridG, 7);
                    this.modeloG.setValueAt(Double.valueOf(xrs2.getDouble("Pagos_Acumulados")), this.filaGridG, 8);
                    this.filaGridG++;
                }
            } catch (SQLException ex2) {
                Logger.getLogger(JIFConsultaDec2193.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex2);
                return;
            }
        }
        xrs2.close();
    }

    private void mCrearGridIngresos_mes() {
        this.modeloI = new DefaultTableModel() { // from class: Presupuesto.JIFConsultaDec2193.8
            Class[] types = {String.class, String.class, Double.class, Double.class, Double.class, Double.class};
            boolean[] canEdit = {false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return this.canEdit[colIndex];
            }
        };
        this.modeloI.addColumn("Codigo ");
        this.modeloI.addColumn("Nombre ");
        this.modeloI.addColumn("Presupuesto Definitivo");
        this.modeloI.addColumn("Total Reconocido Acumulado");
        this.modeloI.addColumn("Recaudos Mes");
        this.modeloI.addColumn("Total Acumulado Recaudos");
        JTable jTable = this.gridI;
        JTable jTable2 = this.gridI;
        jTable.setAutoResizeMode(0);
        this.gridI.doLayout();
        this.gridI.setModel(this.modeloI);
        this.gridI.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.gridI.getColumnModel().getColumn(1).setPreferredWidth(450);
        this.gridI.getColumnModel().getColumn(2).setPreferredWidth(150);
        this.gridI.getColumnModel().getColumn(3).setPreferredWidth(150);
        this.gridI.getColumnModel().getColumn(4).setPreferredWidth(150);
        this.gridI.getColumnModel().getColumn(5).setPreferredWidth(150);
        this.filaGridI = 0;
        this.gridI.setModel(this.modeloI);
    }

    private void mCrearGridIngresos() {
        this.modeloI = new DefaultTableModel() { // from class: Presupuesto.JIFConsultaDec2193.9
            Class[] types = {String.class, String.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return this.canEdit[colIndex];
            }
        };
        this.modeloI.addColumn("Codigo ");
        this.modeloI.addColumn("Nombre ");
        this.modeloI.addColumn("Presupuesto Definitivo");
        this.modeloI.addColumn("Total Reconocido Acumulado");
        this.modeloI.addColumn("Recaudos Mes X");
        this.modeloI.addColumn("Recaudos Mes Y");
        this.modeloI.addColumn("Recaudos Mes Z");
        this.modeloI.addColumn("Total Acumulado Recaudos");
        JTable jTable = this.gridI;
        JTable jTable2 = this.gridI;
        jTable.setAutoResizeMode(0);
        this.gridI.doLayout();
        this.gridI.setModel(this.modeloI);
        this.gridI.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.gridI.getColumnModel().getColumn(1).setPreferredWidth(450);
        this.gridI.getColumnModel().getColumn(2).setPreferredWidth(150);
        this.gridI.getColumnModel().getColumn(3).setPreferredWidth(150);
        this.gridI.getColumnModel().getColumn(4).setPreferredWidth(150);
        this.gridI.getColumnModel().getColumn(5).setPreferredWidth(150);
        this.gridI.getColumnModel().getColumn(6).setPreferredWidth(150);
        this.gridI.getColumnModel().getColumn(7).setPreferredWidth(150);
        this.filaGridI = 0;
        this.gridI.setModel(this.modeloI);
    }

    private void mCrearGridGastos_mes() {
        this.modeloG = new DefaultTableModel() { // from class: Presupuesto.JIFConsultaDec2193.10
            Class[] types = {String.class, String.class, Double.class, Double.class, Double.class, Double.class, Double.class};
            boolean[] canEdit = {false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return this.canEdit[colIndex];
            }
        };
        this.modeloG.addColumn("Codigo");
        this.modeloG.addColumn("Nombre ");
        this.modeloG.addColumn("Definitivo");
        this.modeloG.addColumn("Comprometido");
        this.modeloG.addColumn("Obligaciones");
        this.modeloG.addColumn("Pagos Mes");
        this.modeloG.addColumn("Pagos Acumulados");
        JTable jTable = this.gridG;
        JTable jTable2 = this.gridG;
        jTable.setAutoResizeMode(0);
        this.gridG.doLayout();
        this.gridG.setModel(this.modeloG);
        this.gridG.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.gridG.getColumnModel().getColumn(1).setPreferredWidth(450);
        this.gridG.getColumnModel().getColumn(2).setPreferredWidth(150);
        this.gridG.getColumnModel().getColumn(3).setPreferredWidth(150);
        this.gridG.getColumnModel().getColumn(4).setPreferredWidth(150);
        this.gridG.getColumnModel().getColumn(5).setPreferredWidth(150);
        this.gridG.getColumnModel().getColumn(6).setPreferredWidth(150);
        this.filaGridG = 0;
        this.gridG.setModel(this.modeloG);
    }

    private void mCrearGridGastos() {
        this.modeloG = new DefaultTableModel() { // from class: Presupuesto.JIFConsultaDec2193.11
            Class[] types = {String.class, String.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return this.canEdit[colIndex];
            }
        };
        this.modeloG.addColumn("Codigo");
        this.modeloG.addColumn("Nombre ");
        this.modeloG.addColumn("Definitivo");
        this.modeloG.addColumn("Comprometido");
        this.modeloG.addColumn("Obligaciones");
        this.modeloG.addColumn("Pagos Mes X");
        this.modeloG.addColumn("Pagos Mes Y");
        this.modeloG.addColumn("Pagos Mes Z");
        this.modeloG.addColumn("Pagos Acumulados");
        JTable jTable = this.gridG;
        JTable jTable2 = this.gridG;
        jTable.setAutoResizeMode(0);
        this.gridG.doLayout();
        this.gridG.setModel(this.modeloG);
        this.gridG.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.gridG.getColumnModel().getColumn(1).setPreferredWidth(450);
        this.gridG.getColumnModel().getColumn(2).setPreferredWidth(150);
        this.gridG.getColumnModel().getColumn(3).setPreferredWidth(150);
        this.gridG.getColumnModel().getColumn(4).setPreferredWidth(150);
        this.gridG.getColumnModel().getColumn(5).setPreferredWidth(150);
        this.gridG.getColumnModel().getColumn(6).setPreferredWidth(150);
        this.gridG.getColumnModel().getColumn(7).setPreferredWidth(150);
        this.gridG.getColumnModel().getColumn(8).setPreferredWidth(150);
        this.filaGridG = 0;
        this.gridG.setModel(this.modeloG);
    }

    public void mNuevo() {
        this.xTipoR = "I";
        this.xUltimoN = 0;
        this.xAplicaTercero = 0;
    }
}
