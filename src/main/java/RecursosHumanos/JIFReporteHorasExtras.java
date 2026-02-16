package RecursosHumanos;

import Acceso.Principal;
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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:RecursosHumanos/JIFReporteHorasExtras.class */
public class JIFReporteHorasExtras extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private String xsql;
    private Object[] xdato;
    private String[] xidtiponovedad;
    private String[] xidtipoconcepto;
    private JButton JBTCarguesA;
    private JComboBox JCBConcepto;
    private JComboBox JCBTipoReporte;
    private JDateChooser JDFFechaF;
    private JDateChooser JDFFechaI;
    private JDateChooser JDFFechaR;
    private JPanel JPIDatos;
    private JPanel JPIDatosR;
    private JPanel JPIPeriodo;
    private JScrollPane JSPDetalle;
    private JSpinner JSPNHoras;
    private JScrollPane JSPObservacion;
    private JTextPane JTAObservacion;
    private JTable JTDetalle;
    private Metodos xmt = new Metodos();
    private ConsultasMySQL xct = new ConsultasMySQL();
    private boolean xlleno = false;
    private int xnfila = -1;

    public JIFReporteHorasExtras() {
        initComponents();
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v65, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPIDatos = new JPanel();
        this.JPIPeriodo = new JPanel();
        this.JDFFechaI = new JDateChooser();
        this.JDFFechaF = new JDateChooser();
        this.JCBTipoReporte = new JComboBox();
        this.JPIDatosR = new JPanel();
        this.JDFFechaR = new JDateChooser();
        this.JCBConcepto = new JComboBox();
        this.JSPObservacion = new JScrollPane();
        this.JTAObservacion = new JTextPane();
        this.JSPNHoras = new JSpinner();
        this.JBTCarguesA = new JButton();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("REPORTE DE RECARGOS Y HORA EXTRAS");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjifreportehorasextras");
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JPIPeriodo.setBorder(BorderFactory.createTitledBorder((Border) null, "Período Laborado", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JDFFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicial", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFFechaI.setFont(new Font("Arial", 1, 12));
        this.JDFFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Final", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFFechaF.setFont(new Font("Arial", 1, 12));
        GroupLayout JPIPeriodoLayout = new GroupLayout(this.JPIPeriodo);
        this.JPIPeriodo.setLayout(JPIPeriodoLayout);
        JPIPeriodoLayout.setHorizontalGroup(JPIPeriodoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIPeriodoLayout.createSequentialGroup().addContainerGap().addComponent(this.JDFFechaI, -2, 109, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JDFFechaF, -2, 109, -2).addContainerGap(-1, 32767)));
        JPIPeriodoLayout.setVerticalGroup(JPIPeriodoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIPeriodoLayout.createSequentialGroup().addGroup(JPIPeriodoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JDFFechaI, -2, -1, -2).addComponent(this.JDFFechaF, -2, -1, -2)).addContainerGap(-1, 32767)));
        this.JCBTipoReporte.setFont(new Font("Arial", 1, 12));
        this.JCBTipoReporte.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Reporte", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTipoReporte.addItemListener(new ItemListener() { // from class: RecursosHumanos.JIFReporteHorasExtras.1
            public void itemStateChanged(ItemEvent evt) {
                JIFReporteHorasExtras.this.JCBTipoReporteItemStateChanged(evt);
            }
        });
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addComponent(this.JCBTipoReporte, -2, 280, -2).addGap(18, 18, 18).addComponent(this.JPIPeriodo, -2, -1, -2).addContainerGap(194, 32767)));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBTipoReporte, -2, -1, -2).addComponent(this.JPIPeriodo, -2, -1, -2)).addContainerGap()));
        this.JPIDatosR.setBorder(BorderFactory.createTitledBorder((Border) null, "REPORTE", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JDFFechaR.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFechaR.setDateFormatString("dd/MM/yyyy");
        this.JDFFechaR.setFont(new Font("Arial", 1, 12));
        this.JCBConcepto.setFont(new Font("Arial", 1, 12));
        this.JCBConcepto.setBorder(BorderFactory.createTitledBorder((Border) null, "Concepto", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPObservacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTAObservacion.setFont(new Font("Arial", 1, 12));
        this.JSPObservacion.setViewportView(this.JTAObservacion);
        this.JSPNHoras.setFont(new Font("Arial", 1, 12));
        this.JSPNHoras.setModel(new SpinnerNumberModel(1, 1, (Comparable) null, 1));
        this.JSPNHoras.setBorder(BorderFactory.createTitledBorder((Border) null, "N°", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBTCarguesA.setFont(new Font("Arial", 1, 12));
        this.JBTCarguesA.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTCarguesA.setText("Adicionar");
        this.JBTCarguesA.addActionListener(new ActionListener() { // from class: RecursosHumanos.JIFReporteHorasExtras.2
            public void actionPerformed(ActionEvent evt) {
                JIFReporteHorasExtras.this.JBTCarguesAActionPerformed(evt);
            }
        });
        GroupLayout JPIDatosRLayout = new GroupLayout(this.JPIDatosR);
        this.JPIDatosR.setLayout(JPIDatosRLayout);
        JPIDatosRLayout.setHorizontalGroup(JPIDatosRLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosRLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosRLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosRLayout.createSequentialGroup().addComponent(this.JDFFechaR, -2, 109, -2).addGap(2, 2, 2).addComponent(this.JCBConcepto, -2, 353, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPNHoras, -2, 53, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPObservacion, -1, 213, 32767)).addComponent(this.JBTCarguesA, GroupLayout.Alignment.TRAILING, -1, 746, 32767)).addContainerGap()));
        JPIDatosRLayout.setVerticalGroup(JPIDatosRLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosRLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosRLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPIDatosRLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JSPNHoras, -2, 46, -2).addComponent(this.JCBConcepto, -2, -1, -2)).addGroup(JPIDatosRLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPObservacion, -2, -1, -2).addComponent(this.JDFFechaR, -2, -1, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTCarguesA, -2, 44, -2).addContainerGap(-1, 32767)));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JSPDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.setSelectionMode(0);
        this.JTDetalle.addKeyListener(new KeyAdapter() { // from class: RecursosHumanos.JIFReporteHorasExtras.3
            public void keyPressed(KeyEvent evt) {
                JIFReporteHorasExtras.this.JTDetalleKeyPressed(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JSPDetalle, GroupLayout.Alignment.LEADING, -1, 782, 32767).addComponent(this.JPIDatosR, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.JPIDatos, GroupLayout.Alignment.LEADING, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JPIDatosR, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalle, -1, 197, 32767).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBTipoReporteItemStateChanged(ItemEvent evt) {
        if (this.JCBTipoReporte.getSelectedIndex() != -1 && this.xlleno) {
            this.JCBConcepto.removeAllItems();
            this.xsql = "SELECT rh_nomina_novedad_concepto.Id, rh_nomina_conceptos.Nbre FROM rh_nomina_novedad_concepto INNER JOIN rh_nomina_conceptos  ON (rh_nomina_novedad_concepto.Id_Concepto = rh_nomina_conceptos.Id) WHERE (rh_nomina_novedad_concepto.Estado =1 AND rh_nomina_novedad_concepto.Id_Novedad ='" + this.xidtiponovedad[this.JCBTipoReporte.getSelectedIndex()] + "' AND rh_nomina_conceptos.ReporteU =1) ORDER BY rh_nomina_conceptos.Nbre ASC ";
            this.xidtipoconcepto = this.xct.llenarCombo(this.xsql, this.xidtipoconcepto, this.JCBConcepto);
            this.JCBConcepto.setSelectedIndex(-1);
            this.xct.cerrarConexionBd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTCarguesAActionPerformed(ActionEvent evt) {
        if (this.JCBConcepto.getSelectedIndex() == -1) {
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un concepto", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBConcepto.requestFocus();
            return;
        }
        if (Double.valueOf(this.JSPNHoras.getValue().toString()).doubleValue() > 0.0d) {
            this.xnfila++;
            this.xmodelo.addRow(this.xdato);
            this.xmodelo.setValueAt(this.xmt.formatoAMD.format(this.JDFFechaR.getDate()), this.xnfila, 0);
            this.xmodelo.setValueAt(this.xidtipoconcepto[this.JCBConcepto.getSelectedIndex()], this.xnfila, 1);
            this.xmodelo.setValueAt(this.JCBConcepto.getSelectedItem().toString(), this.xnfila, 2);
            this.xmodelo.setValueAt(this.JSPNHoras.getValue(), this.xnfila, 3);
            this.xmodelo.setValueAt(this.JTAObservacion.getText(), this.xnfila, 4);
            this.JDFFechaR.setDate(this.xmt.getFechaActual());
            this.JCBConcepto.setSelectedIndex(-1);
            this.JSPNHoras.setValue(new Double(0.0d));
            this.JTAObservacion.setText("");
            this.JCBConcepto.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "N Horas debe ser mayor que cero", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JSPNHoras.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 127 && this.JTDetalle.getSelectedRow() != -1) {
            int x = JOptionPane.showInternalConfirmDialog(this, "Desea eliminar la fila seleccionada?", "ELIMINAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                this.xmodelo.removeRow(this.JTDetalle.getSelectedRow());
                this.xnfila--;
            }
        }
    }

    public void mNuevo() {
        Principal.mLimpiarDatosP();
        this.xlleno = false;
        this.JCBConcepto.removeAllItems();
        this.JCBTipoReporte.removeAllItems();
        this.xsql = "SELECT rh_nomina_tipo_novedades.Id , rh_nomina_tipo_novedades.Nbre FROM rh_nomina_novedad_concepto INNER JOIN rh_nomina_tipo_novedades  ON (rh_nomina_novedad_concepto.Id_Novedad = rh_nomina_tipo_novedades.Id) INNER JOIN rh_nomina_conceptos  ON (rh_nomina_novedad_concepto.Id_Concepto = rh_nomina_conceptos.Id) WHERE (rh_nomina_tipo_novedades.Id =2 AND rh_nomina_tipo_novedades.ReporteU =1 AND rh_nomina_tipo_novedades.Estado =1) GROUP BY rh_nomina_tipo_novedades.Id ORDER BY rh_nomina_tipo_novedades.Nbre ASC ";
        this.xidtiponovedad = this.xct.llenarCombo(this.xsql, this.xidtiponovedad, this.JCBTipoReporte);
        this.JCBTipoReporte.setSelectedIndex(-1);
        this.JDFFechaI.setDate(this.xmt.getFechaActual());
        this.JDFFechaF.setDate(this.xmt.getFechaActual());
        this.JDFFechaR.setDate(this.xmt.getFechaActual());
        this.xct.cerrarConexionBd();
        mCrearModeloDatos();
        this.xlleno = true;
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Fecha", "Id", "Concepto", "Cant", "Observación"}) { // from class: RecursosHumanos.JIFReporteHorasExtras.4
            Class[] types = {String.class, String.class, String.class, Long.class, String.class};
            boolean[] canEdit = {false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(1).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(1).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(250);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(50);
        this.xnfila = -1;
    }

    private void mGrabar() {
        if (this.xnfila != -1) {
        }
    }
}
