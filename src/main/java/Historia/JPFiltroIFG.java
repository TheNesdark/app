package Historia;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

/* JADX INFO: loaded from: GenomaP.jar:Historia/JPFiltroIFG.class */
public class JPFiltroIFG extends JPanel {
    private DefaultTableModel xmodelo;
    private DefaultTableModel xmodeloH;
    private Object[] xdatos;
    String xedad;
    private JButton JBCalcular;
    private JButton JBGrabar;
    private JDateChooser JDFFechaCreatinina;
    private JLabel JLResultado;
    private JLabel JLValorF;
    private JScrollPane JSPEstadio;
    private JScrollPane JSPHistorico;
    private JScrollPane JSPObservacion;
    private JTextArea JTAObservacion;
    private JTable JTEstadio;
    private JTextField JTFEdad;
    public JFormattedTextField JTFFCreatinina;
    private JFormattedTextField JTFFPeso;
    private JTable JTHistorico;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JPanel jPanel1;
    private JSeparator jSeparator1;
    private ConsultasMySQL xct = new ConsultasMySQL();
    private Metodos xmt = new Metodos();
    private double xresultado = 0.0d;

    public JPFiltroIFG() {
        this.xedad = "";
        initComponents();
        this.JTFEdad.setText("0");
        this.JTFFPeso.setValue(0);
        this.JTFFPeso.setValue(0);
        this.JTFFCreatinina.setValue(0);
        if (clasesHistoriaCE.informacionAgendaMedicaDTO.getIdSexo().equals("F")) {
            this.JLValorF.setVisible(true);
        } else {
            this.JLValorF.setVisible(false);
        }
        String sql = "SELECT `Edad` FROM `persona` WHERE (`Id_persona` ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "');";
        ResultSet xrs = this.xct.traerRs(sql);
        try {
            if (xrs.next()) {
                this.xedad = xrs.getString(1);
                this.JTFEdad.setText(this.xedad);
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPFiltroIFG.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        mCrearModeloDatos();
        mCargarDatosTablaHistorico();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Estadio", "Descripción", "Rango"}) { // from class: Historia.JPFiltroIFG.1
            Class[] types = {Long.class, String.class, String.class};
            boolean[] canEdit = {false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTEstadio.setModel(this.xmodelo);
        this.JTEstadio.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTEstadio.getColumnModel().getColumn(1).setPreferredWidth(200);
        this.JTEstadio.getColumnModel().getColumn(2).setPreferredWidth(30);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatosHistorico() {
        this.xmodeloH = new DefaultTableModel(new Object[0], new String[]{"Fecha", "Edad", "Peso", "Valor Creatinina", "Resultado", "Estadio", "Descripción", "Rango", "Observación"}) { // from class: Historia.JPFiltroIFG.2
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTHistorico.setModel(this.xmodeloH);
        this.JTHistorico.setAutoResizeMode(0);
        this.JTHistorico.getColumnModel().getColumn(0).setPreferredWidth(75);
        this.JTHistorico.getColumnModel().getColumn(1).setPreferredWidth(60);
        this.JTHistorico.getColumnModel().getColumn(2).setPreferredWidth(80);
        this.JTHistorico.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTHistorico.getColumnModel().getColumn(4).setPreferredWidth(70);
        this.JTHistorico.getColumnModel().getColumn(5).setPreferredWidth(70);
        this.JTHistorico.getColumnModel().getColumn(6).setPreferredWidth(260);
        this.JTHistorico.getColumnModel().getColumn(7).setPreferredWidth(250);
        this.JTHistorico.getColumnModel().getColumn(8).setPreferredWidth(600);
    }

    private void mCargarDatosTabla(double xvalor) {
        try {
            mCrearModeloDatos();
            String sql = "SELECT Id, Nbre, CONCAT('Desde ',VInferior,' Hasta ' , VSuperior) AS Rango FROM g_estadioglomerural WHERE  CAST('" + xvalor + "' AS DECIMAL(9,0)) >=VInferior   AND CAST('" + xvalor + "' AS DECIMAL(9,0)) <=VSuperior ;";
            ResultSet xrs = this.xct.traerRs(sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(xrs.getString(1), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt(xrs.getString(3), n, 2);
                    n++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPFiltroIFG.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarDatosTablaHistorico() {
        try {
            mCrearModeloDatosHistorico();
            String sql = "SELECT DATE_FORMAT(h_calculo_ifg.FechaR,'%d-%m-%Y') AS FechaR, `h_calculo_ifg`.`Edad` , `h_calculo_ifg`.`Peso`  , `h_calculo_ifg`.`ValorCreatinina`  , `h_calculo_ifg`.`Resultado` , `h_calculo_ifg`.`Id_Estadio` , `g_estadioglomerural`.`Nbre` , CONCAT('Desde ',g_estadioglomerural.`VInferior`,' Hasta ' , g_estadioglomerural.`VSuperior`-1) AS Rango, h_calculo_ifg.Observacion  FROM `h_calculo_ifg`  INNER JOIN  `g_estadioglomerural`   ON (`h_calculo_ifg`.`Id_Estadio` = `g_estadioglomerural`.`Id`) WHERE (`h_calculo_ifg`.`IdUsuario` ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "') ORDER BY FechaR DESC";
            ResultSet xrs = this.xct.traerRs(sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodeloH.addRow(this.xdatos);
                    this.xmodeloH.setValueAt(xrs.getString(1), n, 0);
                    this.xmodeloH.setValueAt(xrs.getString(2), n, 1);
                    this.xmodeloH.setValueAt(xrs.getString(3), n, 2);
                    this.xmodeloH.setValueAt(xrs.getString(4), n, 3);
                    this.xmodeloH.setValueAt(xrs.getString(5), n, 4);
                    this.xmodeloH.setValueAt(xrs.getString(6), n, 5);
                    this.xmodeloH.setValueAt(xrs.getString(7), n, 6);
                    this.xmodeloH.setValueAt(xrs.getString(8), n, 7);
                    this.xmodeloH.setValueAt(xrs.getString(9), n, 8);
                    n++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPFiltroIFG.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mGrabar() {
        if (!this.JLResultado.getText().isEmpty()) {
            if (this.JDFFechaCreatinina.getDate() != null) {
                int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (n == 0) {
                    String sql = "INSERT INTO `h_calculo_ifg` ( `Id_Atencion`, `IdUsuario`, `Edad`, `Peso`, `ValorCreatinina`, FechaCreatinina, `Resultado`, `Id_Estadio`, `Observacion`, FechaR, `UsuarioS`)  VALUES ( '" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "', '" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "',  '" + this.xedad + "', '" + this.JTFFPeso.getValue() + "', '" + this.JTFFCreatinina.getValue() + "', '" + this.xmt.formatoAMD1.format(this.JDFFechaCreatinina.getDate()) + "', '" + this.xresultado + "', '" + this.xmodelo.getValueAt(0, 0) + "', '" + this.JTAObservacion.getText() + "','" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "', '" + Principal.usuarioSistemaDTO.getLogin() + "');";
                    this.xct.ejecutarSQL(sql);
                    this.xct.cerrarConexionBd();
                    this.xmt.cambiarEstadoValidadoItemHC(getName(), 1, true);
                    mCargarDatosTablaHistorico();
                    mLimpiaCampos();
                    return;
                }
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Ingrese Fecha de Resultado de la Creatinina.", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Calcule el resultado antes de grabar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    /* JADX WARN: Type inference failed for: r3v21, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v30, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jPanel1 = new JPanel();
        this.JLResultado = new JLabel();
        this.jLabel1 = new JLabel();
        this.jSeparator1 = new JSeparator();
        this.jLabel3 = new JLabel();
        this.JTFFCreatinina = new JFormattedTextField();
        this.JLValorF = new JLabel();
        this.JTFEdad = new JTextField();
        this.jLabel2 = new JLabel();
        this.JTFFPeso = new JFormattedTextField();
        this.JSPObservacion = new JScrollPane();
        this.JTAObservacion = new JTextArea();
        this.JSPEstadio = new JScrollPane();
        this.JTEstadio = new JTable();
        this.JBCalcular = new JButton();
        this.JSPHistorico = new JScrollPane();
        this.JTHistorico = new JTable();
        this.JBGrabar = new JButton();
        this.JDFFechaCreatinina = new JDateChooser();
        setName("jpfiltroifg");
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "Estimación usando la fórmula Cockcroft-Gault:", 0, 0, new Font("Arial", 1, 12), new Color(0, 107, 0)));
        this.JLResultado.setFont(new Font("Arial", 1, 12));
        this.JLResultado.setHorizontalAlignment(0);
        this.JLResultado.setBorder(BorderFactory.createTitledBorder(""));
        this.jLabel1.setFont(new Font("Arial", 1, 12));
        this.jLabel1.setText("72         X  ");
        this.jSeparator1.setForeground(new Color(0, 0, 0));
        this.jLabel3.setFont(new Font("Arial", 1, 12));
        this.jLabel3.setText("( 140 -");
        this.JTFFCreatinina.setBorder(BorderFactory.createTitledBorder((Border) null, "Creatinina", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFCreatinina.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0.00"))));
        this.JTFFCreatinina.setHorizontalAlignment(4);
        this.JTFFCreatinina.setFont(new Font("Arial", 1, 12));
        this.JTFFCreatinina.addMouseListener(new MouseAdapter() { // from class: Historia.JPFiltroIFG.3
            public void mouseClicked(MouseEvent evt) {
                JPFiltroIFG.this.JTFFCreatininaMouseClicked(evt);
            }
        });
        this.JLValorF.setFont(new Font("Arial", 1, 12));
        this.JLValorF.setText("X  0,85 ");
        this.JTFEdad.setFont(new Font("Arial", 1, 12));
        this.JTFEdad.setHorizontalAlignment(4);
        this.JTFEdad.setBorder(BorderFactory.createTitledBorder((Border) null, "Edad", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.jLabel2.setFont(new Font("Arial", 1, 12));
        this.jLabel2.setText(")           X");
        this.JTFFPeso.setBorder(BorderFactory.createTitledBorder((Border) null, "Peso (Kg)", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFPeso.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0.00"))));
        this.JTFFPeso.setHorizontalAlignment(4);
        this.JTFFPeso.setFont(new Font("Arial", 1, 12));
        this.JSPObservacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 1, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTAObservacion.setColumns(20);
        this.JTAObservacion.setFont(new Font("Arial", 1, 12));
        this.JTAObservacion.setLineWrap(true);
        this.JTAObservacion.setRows(1);
        this.JTAObservacion.setTabSize(1);
        this.JTAObservacion.setBorder((Border) null);
        this.JSPObservacion.setViewportView(this.JTAObservacion);
        this.JSPEstadio.setBorder(BorderFactory.createTitledBorder((Border) null, "Estadio de la Enfermedad Renal", 2, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTEstadio.setFont(new Font("Arial", 1, 12));
        this.JTEstadio.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTEstadio.setSelectionBackground(new Color(255, 255, 255));
        this.JTEstadio.setSelectionForeground(new Color(255, 0, 0));
        this.JSPEstadio.setViewportView(this.JTEstadio);
        this.JBCalcular.setFont(new Font("Arial", 1, 12));
        this.JBCalcular.setText("Calcular");
        this.JBCalcular.addActionListener(new ActionListener() { // from class: Historia.JPFiltroIFG.4
            public void actionPerformed(ActionEvent evt) {
                JPFiltroIFG.this.JBCalcularActionPerformed(evt);
            }
        });
        this.JSPHistorico.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 12), new Color(0, 107, 0)));
        this.JSPHistorico.addMouseListener(new MouseAdapter() { // from class: Historia.JPFiltroIFG.5
            public void mouseClicked(MouseEvent evt) {
                JPFiltroIFG.this.JSPHistoricoMouseClicked(evt);
            }
        });
        this.JTHistorico.setFont(new Font("Arial", 1, 12));
        this.JTHistorico.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTHistorico.setSelectionBackground(new Color(255, 255, 255));
        this.JTHistorico.setSelectionForeground(new Color(255, 0, 0));
        this.JTHistorico.addMouseListener(new MouseAdapter() { // from class: Historia.JPFiltroIFG.6
            public void mouseClicked(MouseEvent evt) {
                JPFiltroIFG.this.JTHistoricoMouseClicked(evt);
            }
        });
        this.JSPHistorico.setViewportView(this.JTHistorico);
        this.JBGrabar.setFont(new Font("Arial", 1, 12));
        this.JBGrabar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBGrabar.setText("Grabar");
        this.JBGrabar.addActionListener(new ActionListener() { // from class: Historia.JPFiltroIFG.7
            public void actionPerformed(ActionEvent evt) {
                JPFiltroIFG.this.JBGrabarActionPerformed(evt);
            }
        });
        this.JDFFechaCreatinina.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Creatinina", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFechaCreatinina.setToolTipText("Fecha Resultado de la Creatitina");
        this.JDFFechaCreatinina.setDateFormatString("dd/MM/yyyy");
        this.JDFFechaCreatinina.setFont(new Font("Arial", 1, 12));
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(jPanel1Layout.createSequentialGroup().addGap(64, 64, 64).addComponent(this.jLabel1).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFFCreatinina, -2, 84, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JDFFechaCreatinina, -2, 125, -2)).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jLabel3).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFEdad, -2, 58, -2).addGap(5, 5, 5).addComponent(this.jLabel2).addGap(18, 18, 18).addComponent(this.JTFFPeso, -2, 84, -2)).addComponent(this.jSeparator1, -2, 252, -2)).addGap(8, 8, 8).addComponent(this.JLValorF).addGap(4, 4, 4).addComponent(this.JLResultado, -2, 93, -2))).addGap(47, 47, 47).addComponent(this.JBCalcular, -2, 114, -2).addContainerGap(191, 32767)).addComponent(this.JSPObservacion).addComponent(this.JSPEstadio).addComponent(this.JSPHistorico).addComponent(this.JBGrabar, -1, -1, 32767));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(10, 10, 10).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFEdad).addComponent(this.jLabel2, -2, 27, -2).addComponent(this.jLabel3, -2, 27, -2)).addComponent(this.JTFFPeso, -2, -1, -2)).addGap(3, 3, 3).addComponent(this.jSeparator1, -2, -1, -2)).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JBCalcular, GroupLayout.Alignment.TRAILING, -1, 27, 32767).addComponent(this.JLValorF, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addComponent(this.JLResultado, GroupLayout.Alignment.TRAILING, -1, -1, 32767))).addGap(3, 3, 3).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JDFFechaCreatinina, -2, 47, -2).addGroup(jPanel1Layout.createSequentialGroup().addGap(10, 10, 10).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel1, -2, 27, -2).addComponent(this.JTFFCreatinina, -2, -1, -2)))).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPEstadio, -2, 71, -2).addGap(3, 3, 3).addComponent(this.JSPObservacion, -2, 57, -2).addGap(6, 6, 6).addComponent(this.JBGrabar, -2, 39, -2).addGap(5, 5, 5).addComponent(this.JSPHistorico, -2, 235, -2).addContainerGap()));
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -1, -1, 32767).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.jPanel1, -1, -1, 32767).addContainerGap()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBCalcularActionPerformed(ActionEvent evt) {
        if (clasesHistoriaCE.informacionAgendaMedicaDTO.getIdSexo().equals("F")) {
            double formula = ((((double) (140 - Integer.parseInt(this.JTFEdad.getText()))) * Double.valueOf(this.JTFFPeso.getValue().toString()).doubleValue()) / (72.0d * Double.valueOf(this.JTFFCreatinina.getValue().toString()).doubleValue())) * 0.85d;
            this.xresultado = Math.round(formula * Math.pow(10.0d, 2.0d)) / Math.pow(10.0d, 2.0d);
            this.JLResultado.setText("=" + this.xresultado);
        } else {
            double formula2 = (((double) (140 - Integer.parseInt(this.JTFEdad.getText()))) * Double.valueOf(this.JTFFPeso.getValue().toString()).doubleValue()) / (72.0d * Double.valueOf(this.JTFFCreatinina.getValue().toString()).doubleValue());
            this.xresultado = Math.round(formula2 * Math.pow(10.0d, 2.0d)) / Math.pow(10.0d, 2.0d);
            this.JLResultado.setText("=" + this.xresultado);
        }
        mCargarDatosTabla(this.xresultado);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBGrabarActionPerformed(ActionEvent evt) {
        mGrabar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFCreatininaMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JDRCreatinina xventana = new JDRCreatinina(null, true, this);
            xventana.setVisible(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JSPHistoricoMouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTHistoricoMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2 && this.JTHistorico.getSelectedRow() != -1) {
            this.xmodelo.setRowCount(0);
            this.xmodelo.addRow(new Object[]{this.JTHistorico.getValueAt(this.JTHistorico.getSelectedRow(), 5), this.JTHistorico.getValueAt(this.JTHistorico.getSelectedRow(), 6), this.JTHistorico.getValueAt(this.JTHistorico.getSelectedRow(), 7)});
            this.JTAObservacion.setText(this.JTHistorico.getValueAt(this.JTHistorico.getSelectedRow(), 8).toString());
        }
    }

    private void mLimpiaCampos() {
        this.JTFFPeso.setValue(0);
        this.JTFFCreatinina.setValue(0);
        this.JLResultado.setText("");
        this.JTAObservacion.setText("");
        mCrearModeloDatos();
    }
}
