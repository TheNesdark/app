package Sig;

import Acceso.Principal;
import General.JD_Impresin_Central_Dc;
import Inventarios.JIFReposicionesP;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

/* JADX INFO: loaded from: GenomaP.jar:Sig/JIFAuditoriaTriage.class */
public class JIFAuditoriaTriage extends JInternalFrame {
    private DefaultTableModel xmodelotabla;
    public boolean xlleno;
    private String[] xidsede;
    private Object[] xdato;
    private JButton JBTExportar;
    private JComboBox JCBClasificacionTriage;
    private JComboBox JCBSede;
    private JCheckBox JCHFiltro;
    private JCheckBox JCHFiltroC;
    private JCheckBox JCHTriage;
    private JDateChooser JDCFechaF;
    private JDateChooser JDCFechaI;
    private JPanel JPIConsolidado;
    private JPanel JPIDatosC;
    private JScrollPane JSPDetalleResultado;
    private JFormattedTextField JTFFNPromedio;
    private JFormattedTextField JTFFNTMinutos;
    private JFormattedTextField JTFFNTriage;
    private JTextField JTFRuta;
    private JTable JTResultado;
    private JPanel jPanel1;
    private ConsultasMySQL xconsultas = new ConsultasMySQL();
    private Metodos xmt = new Metodos();
    public boolean xfiltro = true;
    String xsql = null;

    public JIFAuditoriaTriage(String xnombre) {
        initComponents();
        setName(xnombre);
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v55, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jPanel1 = new JPanel();
        this.JPIDatosC = new JPanel();
        this.JDCFechaI = new JDateChooser();
        this.JDCFechaF = new JDateChooser();
        this.JCBClasificacionTriage = new JComboBox();
        this.JPIConsolidado = new JPanel();
        this.JTFFNTriage = new JFormattedTextField();
        this.JTFFNTMinutos = new JFormattedTextField();
        this.JTFFNPromedio = new JFormattedTextField();
        this.JCHTriage = new JCheckBox();
        this.JCHFiltroC = new JCheckBox();
        this.JCHFiltro = new JCheckBox();
        this.JCBSede = new JComboBox();
        this.JSPDetalleResultado = new JScrollPane();
        this.JTResultado = new JTable();
        this.JTFRuta = new JTextField();
        this.JBTExportar = new JButton();
        setClosable(true);
        setIconifiable(true);
        setTitle("AUDITORIA DE TRIAGE");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifauditoriatriage");
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN TRIAGE", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.jPanel1.setName("jptriage");
        this.JPIDatosC.setBorder(BorderFactory.createEtchedBorder());
        this.JDCFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicio", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDCFechaI.setFont(new Font("Arial", 1, 12));
        this.JDCFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Fin", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDCFechaF.setFont(new Font("Arial", 1, 12));
        this.JCBClasificacionTriage.setFont(new Font("Arial", 1, 12));
        this.JCBClasificacionTriage.setModel(new DefaultComboBoxModel(new String[]{"UNO", "DOS", "TRES", "CUATRO", "CINCO"}));
        this.JCBClasificacionTriage.setBorder(BorderFactory.createTitledBorder((Border) null, "Clasificación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JPIConsolidado.setBorder(BorderFactory.createTitledBorder((Border) null, "CONSOLIDADO", 0, 0, new Font("Arial", 1, 14), Color.red));
        this.JTFFNTriage.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Triage", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFNTriage.setHorizontalAlignment(4);
        this.JTFFNTriage.setFont(new Font("Arial", 1, 14));
        this.JTFFNTMinutos.setBorder(BorderFactory.createTitledBorder((Border) null, "Total Minutos", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFNTMinutos.setHorizontalAlignment(4);
        this.JTFFNTMinutos.setFont(new Font("Arial", 1, 14));
        this.JTFFNPromedio.setBorder(BorderFactory.createTitledBorder((Border) null, "Promedio (Minutos)", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFNPromedio.setHorizontalAlignment(4);
        this.JTFFNPromedio.setFont(new Font("Arial", 1, 14));
        this.JCHTriage.setFont(new Font("Arial", 1, 12));
        this.JCHTriage.setText("Filtro x Hora de Triage");
        this.JCHTriage.addActionListener(new ActionListener() { // from class: Sig.JIFAuditoriaTriage.1
            public void actionPerformed(ActionEvent evt) {
                JIFAuditoriaTriage.this.JCHTriageActionPerformed(evt);
            }
        });
        GroupLayout JPIConsolidadoLayout = new GroupLayout(this.JPIConsolidado);
        this.JPIConsolidado.setLayout(JPIConsolidadoLayout);
        JPIConsolidadoLayout.setHorizontalGroup(JPIConsolidadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIConsolidadoLayout.createSequentialGroup().addContainerGap().addGroup(JPIConsolidadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHTriage).addGroup(JPIConsolidadoLayout.createSequentialGroup().addComponent(this.JTFFNTriage, -2, 79, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFFNTMinutos, -2, 106, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFNPromedio, -2, 136, -2))).addGap(0, 121, 32767)));
        JPIConsolidadoLayout.setVerticalGroup(JPIConsolidadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIConsolidadoLayout.createSequentialGroup().addContainerGap().addGroup(JPIConsolidadoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE, false).addComponent(this.JTFFNTriage).addComponent(this.JTFFNTMinutos).addComponent(this.JTFFNPromedio)).addGap(18, 18, 18).addComponent(this.JCHTriage).addContainerGap(18, 32767)));
        this.JCHFiltroC.setFont(new Font("Arial", 1, 12));
        this.JCHFiltroC.setSelected(true);
        this.JCHFiltroC.setText("Filtro");
        this.JCHFiltroC.addActionListener(new ActionListener() { // from class: Sig.JIFAuditoriaTriage.2
            public void actionPerformed(ActionEvent evt) {
                JIFAuditoriaTriage.this.JCHFiltroCActionPerformed(evt);
            }
        });
        this.JCHFiltro.setFont(new Font("Arial", 1, 12));
        this.JCHFiltro.setText("Filtro?");
        this.JCHFiltro.addActionListener(new ActionListener() { // from class: Sig.JIFAuditoriaTriage.3
            public void actionPerformed(ActionEvent evt) {
                JIFAuditoriaTriage.this.JCHFiltroActionPerformed(evt);
            }
        });
        this.JCBSede.setFont(new Font("Arial", 1, 12));
        this.JCBSede.setBorder(BorderFactory.createTitledBorder((Border) null, "Sede", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPIDatosCLayout = new GroupLayout(this.JPIDatosC);
        this.JPIDatosC.setLayout(JPIDatosCLayout);
        JPIDatosCLayout.setHorizontalGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosCLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosCLayout.createSequentialGroup().addComponent(this.JDCFechaI, -2, 120, -2).addGap(18, 18, 18).addComponent(this.JDCFechaF, -2, 120, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JCBClasificacionTriage, -2, 175, -2).addGap(6, 6, 6).addComponent(this.JCHFiltroC)).addGroup(JPIDatosCLayout.createSequentialGroup().addComponent(this.JCHFiltro).addGap(18, 18, 18).addComponent(this.JCBSede, -2, 198, -2).addGap(0, 0, 32767))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPIConsolidado, -2, -1, -2).addContainerGap()));
        JPIDatosCLayout.setVerticalGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosCLayout.createSequentialGroup().addGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosCLayout.createSequentialGroup().addContainerGap().addComponent(this.JPIConsolidado, -1, -1, 32767)).addGroup(JPIDatosCLayout.createSequentialGroup().addGap(19, 19, 19).addGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JCHFiltroC).addComponent(this.JDCFechaI, -1, 56, 32767).addComponent(this.JDCFechaF, -1, -1, 32767).addComponent(this.JCBClasificacionTriage)).addGap(18, 18, 18).addGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBSede).addGroup(JPIDatosCLayout.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.JCHFiltro))))).addContainerGap()));
        this.JSPDetalleResultado.setBorder(BorderFactory.createTitledBorder((Border) null, "RESULTADO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTResultado.setFont(new Font("Arial", 1, 12));
        this.JTResultado.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTResultado.setRowHeight(25);
        this.JTResultado.setSelectionBackground(new Color(255, 255, 255));
        this.JTResultado.setSelectionForeground(new Color(255, 0, 0));
        this.JTResultado.addMouseListener(new MouseAdapter() { // from class: Sig.JIFAuditoriaTriage.4
            public void mouseClicked(MouseEvent evt) {
                JIFAuditoriaTriage.this.JTResultadoMouseClicked(evt);
            }

            public void mouseExited(MouseEvent evt) {
                JIFAuditoriaTriage.this.JTResultadoMouseExited(evt);
            }
        });
        this.JTResultado.addKeyListener(new KeyAdapter() { // from class: Sig.JIFAuditoriaTriage.5
            public void keyReleased(KeyEvent evt) {
                JIFAuditoriaTriage.this.JTResultadoKeyReleased(evt);
            }
        });
        this.JSPDetalleResultado.setViewportView(this.JTResultado);
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JSPDetalleResultado, GroupLayout.Alignment.LEADING).addComponent(this.JPIDatosC, GroupLayout.Alignment.LEADING, -1, -1, 32767)).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatosC, -2, -1, -2).addGap(18, 18, 18).addComponent(this.JSPDetalleResultado, -1, 418, 32767).addContainerGap()));
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma\\plantilla_triage");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: Sig.JIFAuditoriaTriage.6
            public void mouseClicked(MouseEvent evt) {
                JIFAuditoriaTriage.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: Sig.JIFAuditoriaTriage.7
            public void actionPerformed(ActionEvent evt) {
                JIFAuditoriaTriage.this.JBTExportarActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTFRuta, -2, 307, -2).addGap(31, 31, 31).addComponent(this.JBTExportar, -2, 158, -2).addContainerGap(549, 32767)).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, -1, -2).addContainerGap(-1, 32767))));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap(679, 32767).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFRuta, -2, 50, -2).addComponent(this.JBTExportar, -2, 50, -2)).addContainerGap()).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, -1, -2).addContainerGap(83, 32767))));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHFiltroCActionPerformed(ActionEvent evt) {
        if (this.JCHFiltroC.isSelected()) {
            this.JCBClasificacionTriage.setEnabled(true);
        } else {
            this.JCBClasificacionTriage.setEnabled(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTResultadoMouseClicked(MouseEvent evt) {
        if (this.JTResultado.getSelectedRow() != -1 && this.JTResultado.getValueAt(this.JTResultado.getSelectedRow(), 0) != null) {
            JD_Impresin_Central_Dc xjd = new JD_Impresin_Central_Dc(null, true, this.JTResultado.getValueAt(this.JTResultado.getSelectedRow(), 9).toString(), this.JTResultado.getValueAt(this.JTResultado.getSelectedRow(), 10).toString(), this.JTResultado.getValueAt(this.JTResultado.getSelectedRow(), 17).toString(), this.JTResultado.getValueAt(this.JTResultado.getSelectedRow(), 10).toString(), Integer.valueOf(this.JTResultado.getValueAt(this.JTResultado.getSelectedRow(), 18).toString()), this.JTResultado.getValueAt(this.JTResultado.getSelectedRow(), 19).toString());
            xjd.setLocationRelativeTo(this);
            xjd.setVisible(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTExportarActionPerformed(ActionEvent evt) {
        if (this.JTResultado.getRowCount() != -1) {
            int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTResultado, this.JTFRuta.getText(), getTitle());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTResultadoKeyReleased(KeyEvent evt) {
        System.out.println(evt.getKeyCode());
        if (evt.getKeyCode() == 10 && this.JTResultado.getSelectedRow() != -1) {
            int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de actualizar?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                this.xsql = "update h_atencion set Hora_Atencion='" + this.xmodelotabla.getValueAt(this.JTResultado.getSelectedRow(), 6) + "' where Id='" + this.xmodelotabla.getValueAt(this.JTResultado.getSelectedRow(), 9) + "'";
                this.xconsultas.ejecutarSQL(this.xsql);
                this.xconsultas.cerrarConexionBd();
                mCargarDatosTabla();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHFiltroActionPerformed(ActionEvent evt) {
        mLLenarCombo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHTriageActionPerformed(ActionEvent evt) {
        if (this.JCHTriage.isSelected()) {
            this.JCBClasificacionTriage.setEnabled(false);
            this.JCHFiltroC.setSelected(false);
        } else {
            this.JCBClasificacionTriage.setEnabled(true);
            this.JCHFiltroC.setSelected(false);
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
                this.JTFRuta.setText(xfile.getAbsolutePath() + this.xmt.getBarra());
                this.JTFRuta.requestFocus();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTResultadoMouseExited(MouseEvent evt) {
    }

    public void mNuevo() {
        this.xlleno = false;
        this.JDCFechaI.setDate(this.xmt.getFechaActual());
        this.JDCFechaF.setDate(this.xmt.getFechaActual());
        this.JBTExportar.setEnabled(false);
        mCrearTablaDetalle();
        mLLenarCombo();
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
        this.xlleno = true;
    }

    public void mBuscar() {
        if (this.JCHFiltro.isSelected()) {
            if (this.JCBSede.getSelectedIndex() != -1) {
                if (this.JCHFiltroC.isSelected()) {
                    if (this.JCBClasificacionTriage.getSelectedIndex() != -1) {
                        mCargarDatosTabla();
                        return;
                    } else {
                        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un clasificación", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                        this.JCBSede.requestFocus();
                        return;
                    }
                }
                mCargarDatosTabla();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una sede", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            this.JCBSede.requestFocus();
            return;
        }
        if (this.JCHFiltroC.isSelected()) {
            if (this.JCBClasificacionTriage.getSelectedIndex() != -1) {
                mCargarDatosTabla();
                return;
            } else {
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un clasificación", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                this.JCBSede.requestFocus();
                return;
            }
        }
        mCargarDatosTabla();
    }

    private void mCrearTablaDetalle() {
        this.xmodelotabla = new DefaultTableModel((Object[][]) null, new String[]{"Id", "NHC", "Usuario", "Fecha T", "Hora T", "Fecha AT", "Hora AT", "Nivel", "Minutos", "IdAtencion", "IdPaciente", "Estado", "Empresa", "Profesional", "Codigo DX", "Diagnostico", "Afiliacion EPS", "idIngreso", "idTipoHistoria", "correo"}) { // from class: Sig.JIFAuditoriaTriage.8
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Long.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Integer.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, true, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return this.canEdit[colIndex];
            }
        };
        JTable jTable = this.JTResultado;
        JTable jTable2 = this.JTResultado;
        jTable.setAutoResizeMode(0);
        this.JTResultado.doLayout();
        this.JTResultado.setModel(this.xmodelotabla);
        this.JTResultado.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTResultado.getColumnModel().getColumn(1).setPreferredWidth(120);
        this.JTResultado.getColumnModel().getColumn(2).setPreferredWidth(300);
        this.JTResultado.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTResultado.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTResultado.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTResultado.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTResultado.getColumnModel().getColumn(7).setPreferredWidth(100);
        this.JTResultado.getColumnModel().getColumn(8).setPreferredWidth(100);
        this.JTResultado.getColumnModel().getColumn(9).setPreferredWidth(0);
        this.JTResultado.getColumnModel().getColumn(9).setMinWidth(0);
        this.JTResultado.getColumnModel().getColumn(9).setMaxWidth(0);
        this.JTResultado.getColumnModel().getColumn(10).setPreferredWidth(0);
        this.JTResultado.getColumnModel().getColumn(10).setMinWidth(0);
        this.JTResultado.getColumnModel().getColumn(10).setMaxWidth(0);
        this.JTResultado.getColumnModel().getColumn(11).setPreferredWidth(0);
        this.JTResultado.getColumnModel().getColumn(11).setMinWidth(0);
        this.JTResultado.getColumnModel().getColumn(11).setMaxWidth(0);
        this.JTResultado.getColumnModel().getColumn(12).setPreferredWidth(0);
        this.JTResultado.getColumnModel().getColumn(12).setMinWidth(0);
        this.JTResultado.getColumnModel().getColumn(12).setMaxWidth(0);
        this.JTResultado.getColumnModel().getColumn(13).setPreferredWidth(0);
        this.JTResultado.getColumnModel().getColumn(13).setMinWidth(0);
        this.JTResultado.getColumnModel().getColumn(13).setMaxWidth(0);
        this.JTResultado.getColumnModel().getColumn(14).setPreferredWidth(120);
        this.JTResultado.getColumnModel().getColumn(15).setPreferredWidth(200);
        this.JTResultado.getColumnModel().getColumn(16).setPreferredWidth(200);
        this.JTResultado.getColumnModel().getColumn(17).setPreferredWidth(100);
        this.JTResultado.getColumnModel().getColumn(18).setPreferredWidth(100);
        this.JTResultado.getColumnModel().getColumn(19).setPreferredWidth(100);
    }

    private void mCargarDatosTabla() {
        mCrearTablaDetalle();
        int idc = this.JCBClasificacionTriage.getSelectedIndex() + 1;
        String sql = null;
        if (this.JCHTriage.isSelected()) {
            sql = "SELECT h_triage.Id, persona.NoHistoria, persona.NUsuario,  DATE_FORMAT(`h_horallegada`.`Fecha_Hora`, '%d/%m/%Y') AS FechaIngreso,  DATE_FORMAT(`h_horallegada`.`Fecha_Hora`,'%H:%i:%S') AS hora_Ingreso,  DATE_FORMAT(h_triage.FechaTriage, '%d/%m/%Y') AS FechaTriage,  h_triage.HoraTriage,  h_triage.Clasificacion,   (MINUTE(TIMEDIFF(TIMESTAMP(h_triage.FechaTriage, h_triage.HoraTriage), TIMESTAMP(DATE_FORMAT(`h_horallegada`.`Fecha_Hora`, '%Y-%m-%d'), DATE_FORMAT(`h_horallegada`.`Fecha_Hora`,'%H:%i:%S'))))) AS minutos,  h_atencion.Id, persona.Id_persona,  IF(HOUR(TIMEDIFF(TIMESTAMP(h_triage.FechaTriage, h_triage.HoraTriage),  TIMESTAMP(DATE_FORMAT(`h_horallegada`.`Fecha_Hora`, '%Y-%m-%d'), DATE_FORMAT(`h_horallegada`.`Fecha_Hora`,'%H:%i:%S'))))=1,'1','0')AS Hora, `f_empresacontxconvenio`.`Nbre` , CONCAT(persona_1.Apellido1 , ' ',persona_1.Apellido2 , ' ',persona_1.Nombre1 , ' ',persona_1.Nombre2 ) AS NProfesional , `ingreso`.`DxIngreso`, IFNULL(g_patologia.Nbre,'') AS Diagnostico, persona.EPS, ingreso.Id idIngreso, c_clasecita.Id_Historia idTipoHistoria, persona.Corre correo    FROM h_atencion  INNER JOIN ingreso  ON (h_atencion.Id_Ingreso = ingreso.Id)   INNER JOIN g_profesional  ON (h_atencion.Id_Profesional = g_profesional.Id_Persona)  INNER JOIN h_triage  ON (h_triage.IdIngreso = ingreso.Id)    INNER JOIN persona  ON (ingreso.Id_Usuario = persona.Id_persona)   INNER JOIN g_profesionalespecial  ON (g_profesionalespecial.Id_Profesional = g_profesional.Id_Persona)   INNER JOIN g_especialidad  ON (g_profesionalespecial.Id_Especialidad = g_especialidad.Id)   INNER JOIN `h_horallegada` ON (`h_horallegada`.`Id_Ingreso` = `ingreso`.`Id`)    INNER JOIN `c_clasecita` ON (`c_clasecita`.`Id` = `h_atencion`.`Id_ClaseCita`) LEFT JOIN `g_patologia` ON (`g_patologia`.`Id` = `ingreso`.`DxIngreso`)  INNER JOIN  `f_empresacontxconvenio`  ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`) INNER JOIN `g_persona` AS persona_1  ON (persona_1.Id = g_profesional.Id_Persona)      WHERE (h_triage.FechaTriage >='" + this.xmt.formatoAMD.format(this.JDCFechaI.getDate()) + "' AND h_triage.FechaTriage <='" + this.xmt.formatoAMD.format(this.JDCFechaF.getDate()) + "'AND h_triage.Estado =0  AND ingreso.Id_Sede='" + this.xidsede[this.JCBSede.getSelectedIndex()] + "' AND  h_atencion.Codigo_Dxp <> '' AND g_especialidad.Id =382 ) ORDER BY h_triage.Id ASC ";
        } else if (this.JCHFiltro.isSelected() && this.JCHFiltroC.isSelected()) {
            sql = Principal.informacionIps.getEsFpz().intValue() == 0 ? "SELECT h_triage.Id, persona.NoHistoria, persona.NUsuario, DATE_FORMAT(h_triage.FechaTriage, '%d/%m/%Y') AS Fechat, h_triage.HoraTriage, DATE_FORMAT(h_atencion.Fecha_Atencion, '%d/%m/%Y') AS FechaAt, h_atencion.Hora_Atencion, h_triage.Clasificacion,  (HOUR(TIMEDIFF(TIMESTAMP(h_atencion.Fecha_Atencion, h_atencion.Hora_Atencion),TIMESTAMP(h_triage.FechaTriage, h_triage.HoraTriage)))*60) +(MINUTE(TIMEDIFF(TIMESTAMP(h_atencion.Fecha_Atencion, h_atencion.Hora_Atencion),TIMESTAMP(h_triage.FechaTriage, h_triage.HoraTriage))))+ (ROUND(SECOND(TIMEDIFF(TIMESTAMP(h_atencion.Fecha_Atencion, h_atencion.Hora_Atencion),TIMESTAMP(h_triage.FechaTriage, h_triage.HoraTriage)))/60))  AS DTiempo, h_atencion.Id, persona.Id_persona, IF(HOUR(TIMEDIFF(TIMESTAMP(h_atencion.Fecha_Atencion, h_atencion.Hora_Atencion),TIMESTAMP(h_triage.FechaTriage, h_triage.HoraTriage)))=1,'1','0')AS Hora,`f_empresacontxconvenio`.`Nbre` , CONCAT(persona_1.Apellido1 , ' ',persona_1.Apellido2 , ' ',persona_1.Nombre1 , ' ',persona_1.Nombre2 ) AS NProfesional , `ingreso`.`DxIngreso`, IFNULL(g_patologia.Nbre,'') AS Diagnostico, persona.EPS, ingreso.Id idIngreso, c_clasecita.Id_Historia idTipoHistoria, persona.Corre correo FROM h_atencion  INNER JOIN ingreso  ON (h_atencion.Id_Ingreso = ingreso.Id)  INNER JOIN g_profesional  ON (h_atencion.Id_Profesional = g_profesional.Id_Persona)  INNER JOIN h_triage  ON (h_triage.IdIngreso = ingreso.Id)   INNER JOIN persona  ON (ingreso.Id_Usuario = persona.Id_persona)  INNER JOIN g_profesionalespecial  ON (g_profesionalespecial.Id_Profesional = g_profesional.Id_Persona)  INNER JOIN g_especialidad  ON (g_profesionalespecial.Id_Especialidad = g_especialidad.Id) INNER JOIN  `f_empresacontxconvenio`  ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`) INNER JOIN `g_persona` AS persona_1  ON (persona_1.Id = g_profesional.Id_Persona)    INNER JOIN `c_clasecita` ON (`c_clasecita`.`Id` = `h_atencion`.`Id_ClaseCita`)LEFT JOIN `g_patologia` ON (`g_patologia`.`Id` = `ingreso`.`DxIngreso`) WHERE (h_triage.FechaTriage >='" + this.xmt.formatoAMD.format(this.JDCFechaI.getDate()) + "' AND h_triage.FechaTriage <='" + this.xmt.formatoAMD.format(this.JDCFechaF.getDate()) + "'AND h_triage.Estado =0   AND ingreso.Id_Sede='" + this.xidsede[this.JCBSede.getSelectedIndex()] + "' AND  h_triage.Clasificacion='" + idc + "' AND h_atencion.Codigo_Dxp <> '' AND g_especialidad.Id =382 ) ORDER BY h_triage.Id ASC " : "SELECT h_triage.Id, persona.NoHistoria, persona.NUsuario, DATE_FORMAT(h_triage.FechaTriage, '%d/%m/%Y') AS Fechat, h_triage.HoraTriage, DATE_FORMAT(h_atencion.Fecha_Atencion, '%d/%m/%Y') AS FechaAt, h_atencion.Hora_Atencion, h_triage.Clasificacion,  (HOUR(TIMEDIFF(TIMESTAMP(h_atencion.Fecha_Atencion, h_atencion.Hora_Atencion),TIMESTAMP(h_triage.FechaTriage, h_triage.HoraTriage)))*60) +(MINUTE(TIMEDIFF(TIMESTAMP(h_atencion.Fecha_Atencion, h_atencion.Hora_Atencion),TIMESTAMP(h_triage.FechaTriage, h_triage.HoraTriage))))+ (ROUND(SECOND(TIMEDIFF(TIMESTAMP(h_atencion.Fecha_Atencion, h_atencion.Hora_Atencion),TIMESTAMP(h_triage.FechaTriage, h_triage.HoraTriage)))/60))  AS DTiempo, h_atencion.Id, persona.Id_persona, IF(HOUR(TIMEDIFF(TIMESTAMP(h_atencion.Fecha_Atencion, h_atencion.Hora_Atencion),TIMESTAMP(h_triage.FechaTriage, h_triage.HoraTriage)))=1,'1','0')AS Hora, `f_empresacontxconvenio`.`Nbre` , CONCAT(persona_1.Apellido1 , ' ',persona_1.Apellido2 , ' ',persona_1.Nombre1 , ' ',persona_1.Nombre2 ) AS NProfesional , `ingreso`.`DxIngreso`, IFNULL(g_patologia.Nbre,'') AS Diagnostico, persona.EPS, ingreso.Id idIngreso, c_clasecita.Id_Historia idTipoHistoria, persona.Corre correo FROM h_atencion  INNER JOIN ingreso  ON (h_atencion.Id_Ingreso = ingreso.Id)  INNER JOIN g_profesional  ON (h_atencion.Id_Profesional = g_profesional.Id_Persona)  INNER JOIN h_triage  ON (h_triage.IdIngreso = ingreso.Id)   INNER JOIN persona  ON (ingreso.Id_Usuario = persona.Id_persona)  INNER JOIN g_profesionalespecial  ON (g_profesionalespecial.Id_Profesional = g_profesional.Id_Persona)  INNER JOIN g_especialidad  ON (g_profesionalespecial.Id_Especialidad = g_especialidad.Id) INNER JOIN  `f_empresacontxconvenio`  ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`) INNER JOIN `g_persona` AS persona_1  ON (persona_1.Id = g_profesional.Id_Persona)    INNER JOIN `c_clasecita` ON (`c_clasecita`.`Id` = `h_atencion`.`Id_ClaseCita`)LEFT JOIN `g_patologia` ON (`g_patologia`.`Id` = `ingreso`.`DxIngreso`) WHERE (h_triage.FechaTriage >='" + this.xmt.formatoAMD.format(this.JDCFechaI.getDate()) + "' AND h_triage.FechaTriage <='" + this.xmt.formatoAMD.format(this.JDCFechaF.getDate()) + "'AND h_triage.Estado =0   AND ingreso.Id_Sede='" + this.xidsede[this.JCBSede.getSelectedIndex()] + "' AND  h_triage.Clasificacion='" + idc + "'  AND g_especialidad.Id =382 ) ORDER BY h_triage.Id ASC ";
        } else if (!this.JCHFiltro.isSelected() && this.JCHFiltroC.isSelected()) {
            sql = Principal.informacionIps.getEsFpz().intValue() == 0 ? "SELECT h_triage.Id, persona.NoHistoria, persona.NUsuario, DATE_FORMAT(h_triage.FechaTriage, '%d/%m/%Y') AS Fechat, h_triage.HoraTriage, DATE_FORMAT(h_atencion.Fecha_Atencion, '%d/%m/%Y') AS FechaAt, h_atencion.Hora_Atencion, h_triage.Clasificacion,  (HOUR(TIMEDIFF(TIMESTAMP(h_atencion.Fecha_Atencion, h_atencion.Hora_Atencion),TIMESTAMP(h_triage.FechaTriage, h_triage.HoraTriage)))*60) +(MINUTE(TIMEDIFF(TIMESTAMP(h_atencion.Fecha_Atencion, h_atencion.Hora_Atencion),TIMESTAMP(h_triage.FechaTriage, h_triage.HoraTriage))))+ (ROUND(SECOND(TIMEDIFF(TIMESTAMP(h_atencion.Fecha_Atencion, h_atencion.Hora_Atencion),TIMESTAMP(h_triage.FechaTriage, h_triage.HoraTriage)))/60))  AS DTiempo, h_atencion.Id, persona.Id_persona, IF(HOUR(TIMEDIFF(TIMESTAMP(h_atencion.Fecha_Atencion, h_atencion.Hora_Atencion),TIMESTAMP(h_triage.FechaTriage, h_triage.HoraTriage)))=1,'1','0')AS Hora, `f_empresacontxconvenio`.`Nbre` , CONCAT(persona_1.Apellido1 , ' ',persona_1.Apellido2 , ' ',persona_1.Nombre1 , ' ',persona_1.Nombre2 ) AS NProfesional , `ingreso`.`DxIngreso`, IFNULL(g_patologia.Nbre,'') AS Diagnostico, persona.EPS, ingreso.Id idIngreso, c_clasecita.Id_Historia idTipoHistoria, persona.Corre correo FROM h_atencion  INNER JOIN ingreso  ON (h_atencion.Id_Ingreso = ingreso.Id)  INNER JOIN g_profesional  ON (h_atencion.Id_Profesional = g_profesional.Id_Persona)  INNER JOIN h_triage  ON (h_triage.IdIngreso = ingreso.Id)   INNER JOIN persona  ON (ingreso.Id_Usuario = persona.Id_persona)  INNER JOIN g_profesionalespecial  ON (g_profesionalespecial.Id_Profesional = g_profesional.Id_Persona)  INNER JOIN g_especialidad  ON (g_profesionalespecial.Id_Especialidad = g_especialidad.Id)  INNER JOIN f_empresacontxconvenio  ON (ingreso.`Id_EmpresaContxConv` = f_empresacontxconvenio.`Id`) INNER JOIN `g_persona` AS persona_1  ON (persona_1.Id = g_profesional.Id_Persona)    INNER JOIN `c_clasecita` ON (`c_clasecita`.`Id` = `h_atencion`.`Id_ClaseCita`)LEFT JOIN `g_patologia` ON (`g_patologia`.`Id` = `ingreso`.`DxIngreso`) WHERE (h_triage.FechaTriage >='" + this.xmt.formatoAMD.format(this.JDCFechaI.getDate()) + "' AND h_triage.FechaTriage <='" + this.xmt.formatoAMD.format(this.JDCFechaF.getDate()) + "'AND h_triage.Estado =0    AND  h_triage.Clasificacion='" + idc + "' AND h_atencion.Codigo_Dxp <> '' AND g_especialidad.Id =382 ) ORDER BY h_triage.Id ASC " : "SELECT h_triage.Id, persona.NoHistoria, persona.NUsuario, DATE_FORMAT(h_triage.FechaTriage, '%d/%m/%Y') AS Fechat, h_triage.HoraTriage, DATE_FORMAT(h_atencion.Fecha_Atencion, '%d/%m/%Y') AS FechaAt, h_atencion.Hora_Atencion, h_triage.Clasificacion,  (HOUR(TIMEDIFF(TIMESTAMP(h_atencion.Fecha_Atencion, h_atencion.Hora_Atencion),TIMESTAMP(h_triage.FechaTriage, h_triage.HoraTriage)))*60) +(MINUTE(TIMEDIFF(TIMESTAMP(h_atencion.Fecha_Atencion, h_atencion.Hora_Atencion),TIMESTAMP(h_triage.FechaTriage, h_triage.HoraTriage))))+ (ROUND(SECOND(TIMEDIFF(TIMESTAMP(h_atencion.Fecha_Atencion, h_atencion.Hora_Atencion),TIMESTAMP(h_triage.FechaTriage, h_triage.HoraTriage)))/60))  AS DTiempo, h_atencion.Id, persona.Id_persona, IF(HOUR(TIMEDIFF(TIMESTAMP(h_atencion.Fecha_Atencion, h_atencion.Hora_Atencion),TIMESTAMP(h_triage.FechaTriage, h_triage.HoraTriage)))=1,'1','0')AS Hora, `f_empresacontxconvenio`.`Nbre` , CONCAT(persona_1.Apellido1 , ' ',persona_1.Apellido2 , ' ',persona_1.Nombre1 , ' ',persona_1.Nombre2 ) AS NProfesional , `ingreso`.`DxIngreso`, IFNULL(g_patologia.Nbre,'') AS Diagnostico, persona.EPS, ingreso.Id idIngreso, c_clasecita.Id_Historia idTipoHistoria, persona.Corre correo FROM h_atencion  INNER JOIN ingreso  ON (h_atencion.Id_Ingreso = ingreso.Id)  INNER JOIN g_profesional  ON (h_atencion.Id_Profesional = g_profesional.Id_Persona)  INNER JOIN h_triage  ON (h_triage.IdIngreso = ingreso.Id)   INNER JOIN persona  ON (ingreso.Id_Usuario = persona.Id_persona)  INNER JOIN g_profesionalespecial  ON (g_profesionalespecial.Id_Profesional = g_profesional.Id_Persona)  INNER JOIN g_especialidad  ON (g_profesionalespecial.Id_Especialidad = g_especialidad.Id) INNER JOIN f_empresacontxconvenio  ON (ingreso.`Id_EmpresaContxConv` = f_empresacontxconvenio.`Id`) INNER JOIN `g_persona` AS persona_1  ON (persona_1.Id = g_profesional.Id_Persona) LEFT JOIN `g_patologia` ON (`g_patologia`.`Id` = `ingreso`.`DxIngreso`) WHERE (h_triage.FechaTriage >='" + this.xmt.formatoAMD.format(this.JDCFechaI.getDate()) + "' AND h_triage.FechaTriage <='" + this.xmt.formatoAMD.format(this.JDCFechaF.getDate()) + "'AND h_triage.Estado =0    AND  h_triage.Clasificacion='" + idc + "'  AND g_especialidad.Id =382 ) ORDER BY h_triage.Id ASC ";
        } else if (this.JCHFiltro.isSelected() && !this.JCHFiltroC.isSelected()) {
            sql = Principal.informacionIps.getEsFpz().intValue() == 0 ? "SELECT h_triage.Id, persona.NoHistoria, persona.NUsuario, DATE_FORMAT(h_triage.FechaTriage, '%d/%m/%Y') AS Fechat, h_triage.HoraTriage, DATE_FORMAT(h_atencion.Fecha_Atencion, '%d/%m/%Y') AS FechaAt, h_atencion.Hora_Atencion, h_triage.Clasificacion,  (HOUR(TIMEDIFF(TIMESTAMP(h_atencion.Fecha_Atencion, h_atencion.Hora_Atencion),TIMESTAMP(h_triage.FechaTriage, h_triage.HoraTriage)))*60) +(MINUTE(TIMEDIFF(TIMESTAMP(h_atencion.Fecha_Atencion, h_atencion.Hora_Atencion),TIMESTAMP(h_triage.FechaTriage, h_triage.HoraTriage))))+ (ROUND(SECOND(TIMEDIFF(TIMESTAMP(h_atencion.Fecha_Atencion, h_atencion.Hora_Atencion),TIMESTAMP(h_triage.FechaTriage, h_triage.HoraTriage)))/60))  AS DTiempo, h_atencion.Id, persona.Id_persona, IF(HOUR(TIMEDIFF(TIMESTAMP(h_atencion.Fecha_Atencion, h_atencion.Hora_Atencion),TIMESTAMP(h_triage.FechaTriage, h_triage.HoraTriage)))=1,'1','0')AS Hora, `f_empresacontxconvenio`.`Nbre` , CONCAT(persona_1.Apellido1 , ' ',persona_1.Apellido2 , ' ',persona_1.Nombre1 , ' ',persona_1.Nombre2 ) AS NProfesional , `ingreso`.`DxIngreso`, IFNULL(g_patologia.Nbre,'') AS Diagnostico, persona.EPS, ingreso.Id idIngreso, c_clasecita.Id_Historia idTipoHistoria, persona.Corre correo FROM h_atencion  INNER JOIN ingreso  ON (h_atencion.Id_Ingreso = ingreso.Id)  INNER JOIN g_profesional  ON (h_atencion.Id_Profesional = g_profesional.Id_Persona)  INNER JOIN h_triage  ON (h_triage.IdIngreso = ingreso.Id)   INNER JOIN persona  ON (ingreso.Id_Usuario = persona.Id_persona)  INNER JOIN g_profesionalespecial  ON (g_profesionalespecial.Id_Profesional = g_profesional.Id_Persona)  INNER JOIN g_especialidad  ON (g_profesionalespecial.Id_Especialidad = g_especialidad.Id) INNER JOIN  `f_empresacontxconvenio`  ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`) INNER JOIN `g_persona` AS persona_1  ON (persona_1.Id = g_profesional.Id_Persona)    INNER JOIN `c_clasecita` ON (`c_clasecita`.`Id` = `h_atencion`.`Id_ClaseCita`)LEFT JOIN `g_patologia` ON (`g_patologia`.`Id` = `ingreso`.`DxIngreso`) WHERE (h_triage.FechaTriage >='" + this.xmt.formatoAMD.format(this.JDCFechaI.getDate()) + "' AND h_triage.FechaTriage <='" + this.xmt.formatoAMD.format(this.JDCFechaF.getDate()) + "'AND h_triage.Estado =0   AND ingreso.Id_Sede='" + this.xidsede[this.JCBSede.getSelectedIndex()] + "'  AND h_atencion.Codigo_Dxp <> '' AND g_especialidad.Id =382 ) ORDER BY h_triage.Id ASC " : "SELECT h_triage.Id, persona.NoHistoria, persona.NUsuario, DATE_FORMAT(h_triage.FechaTriage, '%d/%m/%Y') AS Fechat, h_triage.HoraTriage, DATE_FORMAT(h_atencion.Fecha_Atencion, '%d/%m/%Y') AS FechaAt, h_atencion.Hora_Atencion, h_triage.Clasificacion,  (HOUR(TIMEDIFF(TIMESTAMP(h_atencion.Fecha_Atencion, h_atencion.Hora_Atencion),TIMESTAMP(h_triage.FechaTriage, h_triage.HoraTriage)))*60) +(MINUTE(TIMEDIFF(TIMESTAMP(h_atencion.Fecha_Atencion, h_atencion.Hora_Atencion),TIMESTAMP(h_triage.FechaTriage, h_triage.HoraTriage))))+ (ROUND(SECOND(TIMEDIFF(TIMESTAMP(h_atencion.Fecha_Atencion, h_atencion.Hora_Atencion),TIMESTAMP(h_triage.FechaTriage, h_triage.HoraTriage)))/60))  AS DTiempo, h_atencion.Id, persona.Id_persona, IF(HOUR(TIMEDIFF(TIMESTAMP(h_atencion.Fecha_Atencion, h_atencion.Hora_Atencion),TIMESTAMP(h_triage.FechaTriage, h_triage.HoraTriage)))=1,'1','0')AS Hora, `f_empresacontxconvenio`.`Nbre` , CONCAT(persona_1.Apellido1 , ' ',persona_1.Apellido2 , ' ',persona_1.Nombre1 , ' ',persona_1.Nombre2 ) AS NProfesional , `ingreso`.`DxIngreso`, IFNULL(g_patologia.Nbre,'') AS Diagnostico, persona.EPS, ingreso.Id idIngreso, c_clasecita.Id_Historia idTipoHistoria, persona.Corre correo FROM h_atencion  INNER JOIN ingreso  ON (h_atencion.Id_Ingreso = ingreso.Id)  INNER JOIN g_profesional  ON (h_atencion.Id_Profesional = g_profesional.Id_Persona)  INNER JOIN h_triage  ON (h_triage.IdIngreso = ingreso.Id)   INNER JOIN persona  ON (ingreso.Id_Usuario = persona.Id_persona)  INNER JOIN g_profesionalespecial  ON (g_profesionalespecial.Id_Profesional = g_profesional.Id_Persona)  INNER JOIN g_especialidad  ON (g_profesionalespecial.Id_Especialidad = g_especialidad.Id) INNER JOIN  `f_empresacontxconvenio`  ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`) INNER JOIN `g_persona` AS persona_1  ON (persona_1.Id = g_profesional.Id_Persona)    INNER JOIN `c_clasecita` ON (`c_clasecita`.`Id` = `h_atencion`.`Id_ClaseCita`)LEFT JOIN `g_patologia` ON (`g_patologia`.`Id` = `ingreso`.`DxIngreso`) WHERE (h_triage.FechaTriage >='" + this.xmt.formatoAMD.format(this.JDCFechaI.getDate()) + "' AND h_triage.FechaTriage <='" + this.xmt.formatoAMD.format(this.JDCFechaF.getDate()) + "'AND h_triage.Estado =0   AND ingreso.Id_Sede='" + this.xidsede[this.JCBSede.getSelectedIndex()] + "'  AND g_especialidad.Id =382 ) ORDER BY h_triage.Id ASC ";
        } else if (!this.JCHFiltro.isSelected() && !this.JCHFiltroC.isSelected()) {
            sql = Principal.informacionIps.getEsFpz().intValue() == 0 ? "SELECT h_triage.Id, persona.NoHistoria, persona.NUsuario, DATE_FORMAT(h_triage.FechaTriage, '%d/%m/%Y') AS Fechat, h_triage.HoraTriage, DATE_FORMAT(h_atencion.Fecha_Atencion, '%d/%m/%Y') AS FechaAt, h_atencion.Hora_Atencion, h_triage.Clasificacion,  (HOUR(TIMEDIFF(TIMESTAMP(h_atencion.Fecha_Atencion, h_atencion.Hora_Atencion),TIMESTAMP(h_triage.FechaTriage, h_triage.HoraTriage)))*60) +(MINUTE(TIMEDIFF(TIMESTAMP(h_atencion.Fecha_Atencion, h_atencion.Hora_Atencion),TIMESTAMP(h_triage.FechaTriage, h_triage.HoraTriage))))+ (ROUND(SECOND(TIMEDIFF(TIMESTAMP(h_atencion.Fecha_Atencion, h_atencion.Hora_Atencion),TIMESTAMP(h_triage.FechaTriage, h_triage.HoraTriage)))/60))  AS DTiempo, h_atencion.Id, persona.Id_persona, IF(HOUR(TIMEDIFF(TIMESTAMP(h_atencion.Fecha_Atencion, h_atencion.Hora_Atencion),TIMESTAMP(h_triage.FechaTriage, h_triage.HoraTriage)))=1,'1','0')AS Hora, `f_empresacontxconvenio`.`Nbre` , CONCAT(persona_1.Apellido1 , ' ',persona_1.Apellido2 , ' ',persona_1.Nombre1 , ' ',persona_1.Nombre2 ) AS NProfesional , `ingreso`.`DxIngreso`, IFNULL(g_patologia.Nbre,'') AS Diagnostico, persona.EPS, ingreso.Id idIngreso, c_clasecita.Id_Historia idTipoHistoria, persona.Corre correo FROM h_atencion  INNER JOIN ingreso  ON (h_atencion.Id_Ingreso = ingreso.Id)  INNER JOIN g_profesional  ON (h_atencion.Id_Profesional = g_profesional.Id_Persona)  INNER JOIN h_triage  ON (h_triage.IdIngreso = ingreso.Id)   INNER JOIN persona  ON (ingreso.Id_Usuario = persona.Id_persona)  INNER JOIN g_profesionalespecial  ON (g_profesionalespecial.Id_Profesional = g_profesional.Id_Persona)  INNER JOIN g_especialidad  ON (g_profesionalespecial.Id_Especialidad = g_especialidad.Id) INNER JOIN  `f_empresacontxconvenio`  ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`) INNER JOIN `g_persona` AS persona_1  ON (persona_1.Id = g_profesional.Id_Persona)   INNER JOIN `c_clasecita` ON (`c_clasecita`.`Id` = `h_atencion`.`Id_ClaseCita`) LEFT JOIN `g_patologia` ON (`g_patologia`.`Id` = `ingreso`.`DxIngreso`) WHERE (h_triage.FechaTriage >='" + this.xmt.formatoAMD.format(this.JDCFechaI.getDate()) + "' AND h_triage.FechaTriage <='" + this.xmt.formatoAMD.format(this.JDCFechaF.getDate()) + "'AND h_triage.Estado =0    AND h_atencion.Codigo_Dxp <> '' AND g_especialidad.Id =382 ) ORDER BY h_triage.Id ASC " : "SELECT h_triage.Id, persona.NoHistoria, persona.NUsuario, DATE_FORMAT(h_triage.FechaTriage, '%d/%m/%Y') AS Fechat, h_triage.HoraTriage, DATE_FORMAT(h_atencion.Fecha_Atencion, '%d/%m/%Y') AS FechaAt, h_atencion.Hora_Atencion, h_triage.Clasificacion,  (HOUR(TIMEDIFF(TIMESTAMP(h_atencion.Fecha_Atencion, h_atencion.Hora_Atencion),TIMESTAMP(h_triage.FechaTriage, h_triage.HoraTriage)))*60) +(MINUTE(TIMEDIFF(TIMESTAMP(h_atencion.Fecha_Atencion, h_atencion.Hora_Atencion),TIMESTAMP(h_triage.FechaTriage, h_triage.HoraTriage))))+ (ROUND(SECOND(TIMEDIFF(TIMESTAMP(h_atencion.Fecha_Atencion, h_atencion.Hora_Atencion),TIMESTAMP(h_triage.FechaTriage, h_triage.HoraTriage)))/60))  AS DTiempo, h_atencion.Id, persona.Id_persona, IF(HOUR(TIMEDIFF(TIMESTAMP(h_atencion.Fecha_Atencion, h_atencion.Hora_Atencion),TIMESTAMP(h_triage.FechaTriage, h_triage.HoraTriage)))=1,'1','0')AS Hora, `f_empresacontxconvenio`.`Nbre` , CONCAT(persona_1.Apellido1 , ' ',persona_1.Apellido2 , ' ',persona_1.Nombre1 , ' ',persona_1.Nombre2 ) AS NProfesional , `ingreso`.`DxIngreso`, IFNULL(g_patologia.Nbre,'') AS Diagnostico, persona.EPS, ingreso.Id idIngreso, c_clasecita.Id_Historia idTipoHistoria, persona.Corre correo FROM h_atencion  INNER JOIN ingreso  ON (h_atencion.Id_Ingreso = ingreso.Id)  INNER JOIN g_profesional  ON (h_atencion.Id_Profesional = g_profesional.Id_Persona)  INNER JOIN h_triage  ON (h_triage.IdIngreso = ingreso.Id)   INNER JOIN persona  ON (ingreso.Id_Usuario = persona.Id_persona)  INNER JOIN g_profesionalespecial  ON (g_profesionalespecial.Id_Profesional = g_profesional.Id_Persona)  INNER JOIN g_especialidad  ON (g_profesionalespecial.Id_Especialidad = g_especialidad.Id) INNER JOIN  `f_empresacontxconvenio`  ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`) INNER JOIN `g_persona` AS persona_1  ON (persona_1.Id = g_profesional.Id_Persona)    INNER JOIN `c_clasecita` ON (`c_clasecita`.`Id` = `h_atencion`.`Id_ClaseCita`)LEFT JOIN `g_patologia` ON (`g_patologia`.`Id` = `ingreso`.`DxIngreso`) WHERE (h_triage.FechaTriage >='" + this.xmt.formatoAMD.format(this.JDCFechaI.getDate()) + "' AND h_triage.FechaTriage <='" + this.xmt.formatoAMD.format(this.JDCFechaF.getDate()) + "'AND h_triage.Estado =0     AND g_especialidad.Id =382 ) ORDER BY h_triage.Id ASC ";
        }
        this.xsql = sql;
        ResultSet rs = this.xconsultas.traerRs(sql);
        try {
            this.JTFFNTriage.setValue(0);
            this.JTFFNTMinutos.setValue(0);
            this.JTFFNPromedio.setValue(0);
            this.JBTExportar.setEnabled(true);
            if (rs.next()) {
                rs.beforeFirst();
                int xn = 0;
                int xntriage = 0;
                int xminutos = 0;
                while (rs.next()) {
                    this.xmodelotabla.addRow(this.xdato);
                    this.xmodelotabla.setValueAt(rs.getString(1), xn, 0);
                    this.xmodelotabla.setValueAt(rs.getString(2), xn, 1);
                    this.xmodelotabla.setValueAt(rs.getString(3), xn, 2);
                    this.xmodelotabla.setValueAt(rs.getString(4), xn, 3);
                    this.xmodelotabla.setValueAt(rs.getString(5), xn, 4);
                    this.xmodelotabla.setValueAt(rs.getString(6), xn, 5);
                    this.xmodelotabla.setValueAt(rs.getString(7), xn, 6);
                    this.xmodelotabla.setValueAt(rs.getString(8), xn, 7);
                    this.xmodelotabla.setValueAt(Long.valueOf(rs.getLong(9)), xn, 8);
                    this.xmodelotabla.setValueAt(rs.getString(10), xn, 9);
                    this.xmodelotabla.setValueAt(rs.getString(11), xn, 10);
                    this.xmodelotabla.setValueAt(rs.getString(12), xn, 11);
                    this.xmodelotabla.setValueAt(rs.getString(13), xn, 12);
                    this.xmodelotabla.setValueAt(rs.getString(14), xn, 13);
                    this.xmodelotabla.setValueAt(rs.getString("DxIngreso"), xn, 14);
                    this.xmodelotabla.setValueAt(rs.getString("Diagnostico"), xn, 15);
                    this.xmodelotabla.setValueAt(rs.getString("EPS"), xn, 16);
                    this.xmodelotabla.setValueAt(rs.getString("idIngreso"), xn, 17);
                    this.xmodelotabla.setValueAt(Integer.valueOf(rs.getInt("idTipoHistoria")), xn, 18);
                    this.xmodelotabla.setValueAt(rs.getString("correo"), xn, 19);
                    this.JTResultado.setDefaultRenderer(Object.class, new MiRender());
                    xminutos = (int) (((long) xminutos) + rs.getLong(9));
                    xntriage++;
                    xn++;
                }
                this.JTFFNTriage.setValue(Integer.valueOf(xntriage));
                this.JTFFNTMinutos.setValue(Integer.valueOf(xminutos));
                this.JTFFNPromedio.setValue(Integer.valueOf(xminutos / xntriage));
            } else {
                this.JTFFNTriage.setValue(new Integer(0));
                this.JTFFNTMinutos.setValue(new Integer(0));
                this.JTFFNPromedio.setValue(new Integer(0));
            }
            rs.close();
            this.xconsultas.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFAuditoriaTriage.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mLLenarCombo() {
        this.xlleno = false;
        this.JCBSede.removeAllItems();
        ConsultasMySQL xct = new ConsultasMySQL();
        this.xsql = "SELECT `g_sedes`.`Id`, `g_sedes`.`Nbre` FROM  `l_recepcion` INNER JOIN  `g_sedes`  ON (`l_recepcion`.`Id_Sede` = `g_sedes`.`Id`) WHERE (DATE_FORMAT(`l_recepcion`.`FechaRecep`,'%d-%m-%Y') >='" + this.xmt.formatoDMA1.format(this.JDCFechaI.getDate()) + "' AND DATE_FORMAT(`l_recepcion`.`FechaRecep`,'%d-%m-%Y') <='" + this.xmt.formatoDMA.format(this.JDCFechaF.getDate()) + "' AND `l_recepcion`.`Estado` =0) GROUP BY `g_sedes`.`Id`";
        this.xidsede = xct.llenarCombo(this.xsql, this.xidsede, this.JCBSede);
        this.JCBSede.setSelectedIndex(-1);
        xct.cerrarConexionBd();
        this.xlleno = true;
    }

    /* JADX INFO: loaded from: GenomaP.jar:Sig/JIFAuditoriaTriage$MiRender.class */
    public static class MiRender extends DefaultTableCellRenderer {
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            String trabajador = table.getValueAt(row, 11).toString();
            if (trabajador != null && trabajador.equals("1")) {
                cell.setBackground(new Color(177, 251, 177));
            } else {
                cell.setBackground(Color.WHITE);
            }
            return cell;
        }
    }

    private void mExportar(String xsql) throws WriteException, IOException {
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            try {
                WritableWorkbook workbook = Workbook.createWorkbook(new File(this.JTFRuta.getText() + ".xls"));
                WritableSheet sheet = workbook.createSheet("plantilla", 0);
                sheet.addCell(new Label(0, 1, "NHC"));
                sheet.addCell(new Label(1, 1, "Usuario"));
                sheet.addCell(new Label(2, 1, "Fecha y Hora Triage"));
                sheet.addCell(new Label(3, 1, "Fecha y Hora Atención"));
                sheet.addCell(new Label(4, 1, "Clasificación"));
                sheet.addCell(new Label(5, 1, "DTiempo"));
                ConsultasMySQL xt2 = new ConsultasMySQL();
                ResultSet rs = xt2.traerRs(xsql);
                if (rs.next()) {
                    rs.beforeFirst();
                    int x = 2;
                    while (rs.next()) {
                        sheet.addCell(new Number(0, x, rs.getLong(2)));
                        sheet.addCell(new Label(1, x, rs.getString(3)));
                        sheet.addCell(new Label(2, x, rs.getString(4) + " " + rs.getString(5)));
                        sheet.addCell(new Label(3, x, rs.getString(6) + " " + rs.getString(7)));
                        sheet.addCell(new Label(4, x, rs.getString(8)));
                        sheet.addCell(new Label(5, x, rs.getString(9)));
                        x++;
                    }
                }
                rs.close();
                xt2.cerrarConexionBd();
                workbook.write();
                workbook.close();
                System.out.println("Ejemplo finalizado.");
            } catch (IOException ex) {
                Logger.getLogger(JIFReposicionesP.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            } catch (SQLException ex2) {
                Logger.getLogger(JIFReposicionesP.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex2);
            } catch (WriteException e) {
                Logger.getLogger(JIFReposicionesP.class.getName()).log(Level.SEVERE, (String) null, e);
            }
        }
    }
}
