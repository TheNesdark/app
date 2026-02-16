package AutorizacionMP;

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
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

/* JADX INFO: loaded from: GenomaP.jar:AutorizacionMP/JIFCargarDAcumulado.class */
public class JIFCargarDAcumulado extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private Object[] xdato;
    private String sql;
    private String[] xidtipoempresa;
    private ButtonGroup JBGSoporte;
    private JComboBox JCBEmpresa;
    private JCheckBox JCHLiquidacion;
    private JCheckBox JCHSeleccionar;
    private JDateChooser JDCFechaF;
    private JDateChooser JDCFechaI;
    private JPanel JPIDatos;
    private JPanel JPITipoGeneracion;
    private JRadioButton JRBConSoporte;
    private JRadioButton JRBSinSoporte;
    private JScrollPane JSPHC;
    private JFormattedTextField JTFFNRegistros;
    private JFormattedTextField JTFFValor;
    private JTable JTHistorico;
    private boolean xtipos = true;
    private ConsultasMySQL xconsultas = new ConsultasMySQL();
    private Metodos xmt = new Metodos();
    private int xliquidacion = 0;

    public JIFCargarDAcumulado() {
        initComponents();
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v64, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGSoporte = new ButtonGroup();
        this.JPIDatos = new JPanel();
        this.JDCFechaI = new JDateChooser();
        this.JDCFechaF = new JDateChooser();
        this.JPITipoGeneracion = new JPanel();
        this.JRBSinSoporte = new JRadioButton();
        this.JRBConSoporte = new JRadioButton();
        this.JCHSeleccionar = new JCheckBox();
        this.JCHLiquidacion = new JCheckBox();
        this.JTFFNRegistros = new JFormattedTextField();
        this.JTFFValor = new JFormattedTextField();
        this.JCBEmpresa = new JComboBox();
        this.JSPHC = new JScrollPane();
        this.JTHistorico = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("CARGAR DESCUENTO AL ACUMULADO");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setMinimumSize(null);
        setName("jifcargardescuentoacumulado");
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS DE CONSULTA", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JDCFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicial", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDCFechaI.setFont(new Font("Arial", 1, 12));
        this.JDCFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Final", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDCFechaF.setFont(new Font("Arial", 1, 12));
        this.JPITipoGeneracion.setBorder(BorderFactory.createTitledBorder((Border) null, "Soporte?", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBGSoporte.add(this.JRBSinSoporte);
        this.JRBSinSoporte.setFont(new Font("Arial", 1, 12));
        this.JRBSinSoporte.setSelected(true);
        this.JRBSinSoporte.setText("Si");
        this.JRBSinSoporte.addActionListener(new ActionListener() { // from class: AutorizacionMP.JIFCargarDAcumulado.1
            public void actionPerformed(ActionEvent evt) {
                JIFCargarDAcumulado.this.JRBSinSoporteActionPerformed(evt);
            }
        });
        this.JBGSoporte.add(this.JRBConSoporte);
        this.JRBConSoporte.setFont(new Font("Arial", 1, 12));
        this.JRBConSoporte.setText("No");
        this.JRBConSoporte.addActionListener(new ActionListener() { // from class: AutorizacionMP.JIFCargarDAcumulado.2
            public void actionPerformed(ActionEvent evt) {
                JIFCargarDAcumulado.this.JRBConSoporteActionPerformed(evt);
            }
        });
        GroupLayout JPITipoGeneracionLayout = new GroupLayout(this.JPITipoGeneracion);
        this.JPITipoGeneracion.setLayout(JPITipoGeneracionLayout);
        JPITipoGeneracionLayout.setHorizontalGroup(JPITipoGeneracionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPITipoGeneracionLayout.createSequentialGroup().addContainerGap().addComponent(this.JRBSinSoporte).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBConSoporte).addContainerGap(-1, 32767)));
        JPITipoGeneracionLayout.setVerticalGroup(JPITipoGeneracionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPITipoGeneracionLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBSinSoporte).addComponent(this.JRBConSoporte)));
        this.JCHSeleccionar.setFont(new Font("Arial", 1, 12));
        this.JCHSeleccionar.setText("Seleccionar");
        this.JCHSeleccionar.addActionListener(new ActionListener() { // from class: AutorizacionMP.JIFCargarDAcumulado.3
            public void actionPerformed(ActionEvent evt) {
                JIFCargarDAcumulado.this.JCHSeleccionarActionPerformed(evt);
            }
        });
        this.JCHLiquidacion.setFont(new Font("Arial", 1, 12));
        this.JCHLiquidacion.setText("Liquidación Especial?");
        this.JCHLiquidacion.addActionListener(new ActionListener() { // from class: AutorizacionMP.JIFCargarDAcumulado.4
            public void actionPerformed(ActionEvent evt) {
                JIFCargarDAcumulado.this.JCHLiquidacionActionPerformed(evt);
            }
        });
        this.JTFFNRegistros.setEditable(false);
        this.JTFFNRegistros.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Registros", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFNRegistros.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0"))));
        this.JTFFNRegistros.setHorizontalAlignment(4);
        this.JTFFNRegistros.setFont(new Font("Arial", 1, 12));
        this.JTFFValor.setEditable(false);
        this.JTFFValor.setBorder(BorderFactory.createTitledBorder((Border) null, "Total", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFValor.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFValor.setHorizontalAlignment(4);
        this.JTFFValor.setFont(new Font("Arial", 1, 12));
        this.JCBEmpresa.setFont(new Font("Arial", 1, 12));
        this.JCBEmpresa.setBorder(BorderFactory.createTitledBorder((Border) null, "Empresa", 1, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JCBEmpresa, GroupLayout.Alignment.LEADING, 0, -1, 32767).addGroup(GroupLayout.Alignment.LEADING, JPIDatosLayout.createSequentialGroup().addComponent(this.JDCFechaI, -2, 110, -2).addGap(18, 18, 18).addComponent(this.JDCFechaF, -2, 110, -2).addGap(10, 10, 10).addComponent(this.JPITipoGeneracion, -2, -1, -2))).addGap(18, 18, 18).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHSeleccionar).addComponent(this.JCHLiquidacion)).addGap(18, 18, 18).addComponent(this.JTFFNRegistros, -2, 96, -2).addGap(14, 14, 14).addComponent(this.JTFFValor, -1, 125, 32767).addContainerGap()));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFValor, -2, -1, -2).addComponent(this.JTFFNRegistros, -2, -1, -2)).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JCHLiquidacion).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHSeleccionar)).addComponent(this.JPITipoGeneracion, -2, -1, -2).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JDCFechaI, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addComponent(this.JDCFechaF, GroupLayout.Alignment.TRAILING, -2, 51, -2))).addGap(11, 11, 11).addComponent(this.JCBEmpresa, -1, 59, 32767).addContainerGap()));
        this.JSPHC.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JSPHC.setFont(new Font("Arial", 1, 12));
        this.JTHistorico.setFont(new Font("Arial", 1, 12));
        this.JTHistorico.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTHistorico.setRowHeight(25);
        this.JTHistorico.setSelectionBackground(new Color(255, 255, 255));
        this.JTHistorico.setSelectionForeground(new Color(255, 0, 0));
        this.JTHistorico.setSelectionMode(0);
        this.JTHistorico.addMouseListener(new MouseAdapter() { // from class: AutorizacionMP.JIFCargarDAcumulado.5
            public void mouseClicked(MouseEvent evt) {
                JIFCargarDAcumulado.this.JTHistoricoMouseClicked(evt);
            }
        });
        this.JSPHC.setViewportView(this.JTHistorico);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JPIDatos, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.JSPHC, GroupLayout.Alignment.LEADING, -1, 812, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -1, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPHC, -2, 369, -2).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTHistoricoMouseClicked(MouseEvent evt) {
        if (this.JTHistorico.getRowCount() > -1 && this.JTHistorico.getSelectedRow() != -1) {
            mCalcularContar();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBConSoporteActionPerformed(ActionEvent evt) {
        this.xtipos = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBSinSoporteActionPerformed(ActionEvent evt) {
        this.xtipos = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHSeleccionarActionPerformed(ActionEvent evt) {
        if (this.JCHSeleccionar.isSelected()) {
            mSeleccionar(true);
        } else {
            mSeleccionar(false);
        }
        mCalcularContar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHLiquidacionActionPerformed(ActionEvent evt) {
        if (this.JCHLiquidacion.isSelected()) {
            this.xliquidacion = 1;
        } else {
            this.xliquidacion = 1;
        }
    }

    private void mSeleccionar(boolean xestado) {
        if (this.JTHistorico.getRowCount() > 0) {
            for (int x = 0; x < this.JTHistorico.getRowCount(); x++) {
                this.xmodelo.setValueAt(Boolean.valueOf(xestado), x, 5);
            }
        }
    }

    private void mCalcularContar() {
        if (this.JTHistorico.getRowCount() > 0) {
            double xvalor = 0.0d;
            double xnregistros = 0.0d;
            for (int x = 0; x < this.JTHistorico.getRowCount(); x++) {
                if (Boolean.valueOf(this.xmodelo.getValueAt(x, 5).toString()).booleanValue()) {
                    xvalor += Double.valueOf(this.xmodelo.getValueAt(x, 4).toString()).doubleValue();
                    xnregistros += 1.0d;
                }
            }
            this.JTFFNRegistros.setValue(Double.valueOf(xnregistros));
            this.JTFFValor.setValue(Double.valueOf(xvalor));
        }
    }

    public void mGrabar() {
        if (this.xmt.mVerificarDatosTablaTrue(this.JTHistorico, 5)) {
            int xv = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (xv == 0) {
                for (int x = 0; x < this.JTHistorico.getRowCount(); x++) {
                    if (Boolean.valueOf(this.xmodelo.getValueAt(x, 5).toString()).booleanValue()) {
                        this.sql = "update d_descuento set EsAcumulado=1, Liquidar='" + this.xliquidacion + "' where id='" + this.xmodelo.getValueAt(x, 0) + "'";
                        this.xconsultas.ejecutarSQL(this.sql);
                        this.xconsultas.cerrarConexionBd();
                    }
                }
                mCargarTabla();
                return;
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "No existen descuentos seleccionados", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    public void mNuevo() {
        this.JDCFechaI.setDate(this.xmt.getFechaActual());
        this.JDCFechaF.setDate(this.xmt.getFechaActual());
        this.JRBSinSoporte.setSelected(true);
        this.xidtipoempresa = this.xconsultas.llenarCombo("SELECT g_tipoempresa.Id, g_tipoempresa.Nbre FROM g_usuario_fpz INNER JOIN d_descuento  ON (g_usuario_fpz.Id_Persona = d_descuento.Id_PersonaDescuento) INNER JOIN g_tipoempresa  ON (g_usuario_fpz.Id_Empresa = g_tipoempresa.Id) WHERE (d_descuento.EsAcumulado =0 AND d_descuento.Id_RelacionC =0) GROUP BY g_tipoempresa.Id ORDER BY g_tipoempresa.Nbre ASC ", this.xidtipoempresa, this.JCBEmpresa);
        this.JCBEmpresa.setSelectedIndex(-1);
        this.xconsultas.cerrarConexionBd();
        mCrearTabla();
        this.xliquidacion = 0;
        this.JCHLiquidacion.setSelected(false);
        this.JDCFechaI.requestFocus();
    }

    public void mBuscar() {
        if (this.JCBEmpresa.getSelectedIndex() != -1) {
            mCargarTabla();
        }
    }

    public void mImprimir() {
    }

    private void mCrearTabla() {
        this.xmodelo = new DefaultTableModel((Object[][]) null, new String[]{"Id", "Fecha", "N° HC", "Usuario", "Valor", "Cargar?", "IdUsuario"}) { // from class: AutorizacionMP.JIFCargarDAcumulado.6
            Class[] types = {Long.class, String.class, String.class, String.class, Double.class, Boolean.class, Long.class};
            boolean[] canEdit = {false, false, false, false, false, true, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTHistorico.setModel(this.xmodelo);
        this.JTHistorico.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTHistorico.getColumnModel().getColumn(1).setPreferredWidth(30);
        this.JTHistorico.getColumnModel().getColumn(2).setPreferredWidth(30);
        this.JTHistorico.getColumnModel().getColumn(3).setPreferredWidth(250);
        this.JTHistorico.getColumnModel().getColumn(4).setPreferredWidth(50);
        this.JTHistorico.getColumnModel().getColumn(5).setPreferredWidth(30);
        this.JTHistorico.getColumnModel().getColumn(6).setPreferredWidth(0);
        this.JTHistorico.getColumnModel().getColumn(6).setMinWidth(0);
        this.JTHistorico.getColumnModel().getColumn(6).setMaxWidth(0);
    }

    private void mCargarTabla() {
        mCrearTabla();
        if (this.xtipos) {
            this.sql = "SELECT d_descuento.Id, date_format(d_descuento.FechaD, '%d-%m-%Y') as fecha, persona.NoHistoria, persona.NUsuario, d_descuento.Valor, d_descuento.Id_PersonaDescuento FROM persona INNER JOIN d_descuento ON (persona.Id_persona = d_descuento.Id_PersonaDescuento) INNER JOIN g_usuario_fpz ON (g_usuario_fpz.Id_Persona = d_descuento.Id_PersonaDescuento) INNER JOIN g_tipoempresa  ON (g_usuario_fpz.Id_Empresa = g_tipoempresa.Id)WHERE (d_descuento.FechaD >='" + this.xmt.formatoAMD.format(this.JDCFechaI.getDate()) + "'AND d_descuento.FechaD <='" + this.xmt.formatoAMD.format(this.JDCFechaF.getDate()) + "' AND d_descuento.Estado =0 AND d_descuento.EsAcumulado=0 AND d_descuento.Url <>'' AND d_descuento.Excluir=0 and g_tipoempresa.Id='" + this.xidtipoempresa[this.JCBEmpresa.getSelectedIndex()] + "') ORDER BY persona.NUsuario ASC, d_descuento.FechaD DESC ";
        } else {
            this.sql = "SELECT d_descuento.Id, d_descuento.FechaD, persona.NoHistoria, persona.NUsuario, d_descuento.Valor, d_descuento.Id_PersonaDescuento FROM persona INNER JOIN d_descuento ON (persona.Id_persona = d_descuento.Id_PersonaDescuento) INNER JOIN g_usuario_fpz ON (g_usuario_fpz.Id_Persona = d_descuento.Id_PersonaDescuento) INNER JOIN g_tipoempresa  ON (g_usuario_fpz.Id_Empresa = g_tipoempresa.Id) WHERE (d_descuento.FechaD >='" + this.xmt.formatoAMD.format(this.JDCFechaI.getDate()) + "'AND d_descuento.FechaD <='" + this.xmt.formatoAMD.format(this.JDCFechaF.getDate()) + "' AND d_descuento.Estado =0 AND d_descuento.EsAcumulado=0 AND d_descuento.Url ='' AND d_descuento.Excluir=0  and g_tipoempresa.Id='" + this.xidtipoempresa[this.JCBEmpresa.getSelectedIndex()] + "') ORDER BY persona.NUsuario ASC, d_descuento.FechaD DESC ";
        }
        ResultSet rs = this.xconsultas.traerRs(this.sql);
        try {
            if (rs.next()) {
                rs.beforeFirst();
                int x = 0;
                while (rs.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(Long.valueOf(rs.getLong(1)), x, 0);
                    this.xmodelo.setValueAt(rs.getString(2), x, 1);
                    this.xmodelo.setValueAt(rs.getString(3), x, 2);
                    this.xmodelo.setValueAt(rs.getString(4), x, 3);
                    this.xmodelo.setValueAt(Double.valueOf(rs.getDouble(5)), x, 4);
                    this.xmodelo.setValueAt(false, x, 5);
                    this.xmodelo.setValueAt(Long.valueOf(rs.getLong(6)), x, 6);
                    x++;
                }
            }
            rs.close();
            this.xconsultas.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFCargarDAcumulado.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }
}
