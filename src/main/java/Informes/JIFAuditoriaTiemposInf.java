package Informes;

import Sig.JIFAuditoriaTriage;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.Icon;
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
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

/* JADX INFO: loaded from: GenomaP.jar:Informes/JIFAuditoriaTiemposInf.class */
public class JIFAuditoriaTiemposInf extends JInternalFrame {
    private DefaultTableModel xmodelotabla;
    private String[] xidespecialidad;
    private String[] xidtipocita;
    private int xvc;
    private ButtonGroup JBGDatos;
    private JComboBox JCBEspecialidad;
    private JComboBox JCBTipoCita;
    private JCheckBox JCHFiltrado;
    private JDateChooser JDCFechaF;
    private JDateChooser JDCFechaI;
    private JPanel JPIConsolidado;
    private JPanel JPIDatosC;
    private JPanel JPIEstadoR;
    private JRadioButton JRBAlterado;
    private JRadioButton JRBNoAlterado;
    private JRadioButton JRBTodos;
    private JScrollPane JSPDetalleResultado;
    private JFormattedTextField JTFFNExamen;
    private JFormattedTextField JTFFNOrden;
    private JFormattedTextField JTFFNPromedio;
    private JFormattedTextField JTFFNTMinutos;
    private JFormattedTextField JTFFNTriage;
    private JTable JTResultado;
    private JPanel jPanel1;
    private ConsultasMySQL xconsultas = new ConsultasMySQL();
    private Metodos xmetodos = new Metodos();
    public boolean xfiltro = true;
    private int xlleno = 0;
    private int xtipoexamen = -1;

    public JIFAuditoriaTiemposInf(int xvc, String xtitulo) {
        this.xvc = 0;
        initComponents();
        setTitle(getTitle() + " -- " + xtitulo);
        this.JDCFechaI.setDate(this.xmetodos.getFechaActual());
        this.JDCFechaF.setDate(this.xmetodos.getFechaActual());
        mCrearTablaDetalle();
        this.xvc = xvc;
        if (xvc == 1) {
            mCargarDatosGenerales();
        }
    }

    /* JADX WARN: Type inference failed for: r3v79, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGDatos = new ButtonGroup();
        this.jPanel1 = new JPanel();
        this.JPIDatosC = new JPanel();
        this.JDCFechaI = new JDateChooser();
        this.JDCFechaF = new JDateChooser();
        this.JCBEspecialidad = new JComboBox();
        this.JPIConsolidado = new JPanel();
        this.JTFFNTriage = new JFormattedTextField();
        this.JTFFNTMinutos = new JFormattedTextField();
        this.JTFFNPromedio = new JFormattedTextField();
        this.JCHFiltrado = new JCheckBox();
        this.JCBTipoCita = new JComboBox();
        this.JPIEstadoR = new JPanel();
        this.JRBTodos = new JRadioButton();
        this.JRBAlterado = new JRadioButton();
        this.JRBNoAlterado = new JRadioButton();
        this.JSPDetalleResultado = new JScrollPane();
        this.JTResultado = new JTable();
        this.JTFFNOrden = new JFormattedTextField();
        this.JTFFNExamen = new JFormattedTextField();
        setClosable(true);
        setIconifiable(true);
        setTitle("AUDITORIA PAMEC");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setMinimumSize(null);
        setName("jifauditoriatiempo");
        setPreferredSize(new Dimension(977, 830));
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN TIEMPO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.jPanel1.setName("jptriage");
        this.JPIDatosC.setBorder(BorderFactory.createEtchedBorder());
        this.JDCFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicio", 1, 0, new Font("Tahoma", 1, 12), Color.blue));
        this.JDCFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDCFechaI.setFont(new Font("Arial", 1, 12));
        this.JDCFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Fin", 1, 0, new Font("Tahoma", 1, 12), Color.blue));
        this.JDCFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDCFechaF.setFont(new Font("Arial", 1, 12));
        this.JCBEspecialidad.setFont(new Font("Arial", 1, 12));
        this.JCBEspecialidad.setBorder(BorderFactory.createTitledBorder((Border) null, "Especialidad", 0, 0, new Font("Arial", 1, 12)));
        this.JCBEspecialidad.setEnabled(false);
        this.JCBEspecialidad.addItemListener(new ItemListener() { // from class: Informes.JIFAuditoriaTiemposInf.1
            public void itemStateChanged(ItemEvent evt) {
                JIFAuditoriaTiemposInf.this.JCBEspecialidadItemStateChanged(evt);
            }
        });
        this.JPIConsolidado.setBorder(BorderFactory.createTitledBorder((Border) null, "Consolidado", 0, 0, new Font("Arial", 1, 13), Color.red));
        this.JTFFNTriage.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Total", 0, 0, new Font("Arial", 1, 12)));
        this.JTFFNTriage.setHorizontalAlignment(4);
        this.JTFFNTriage.setFont(new Font("Arial", 1, 14));
        this.JTFFNTMinutos.setBorder(BorderFactory.createTitledBorder((Border) null, "Total Dias", 0, 0, new Font("Arial", 1, 12)));
        this.JTFFNTMinutos.setHorizontalAlignment(4);
        this.JTFFNTMinutos.setFont(new Font("Arial", 1, 14));
        this.JTFFNPromedio.setBorder(BorderFactory.createTitledBorder((Border) null, "Promedio (Dias)", 0, 0, new Font("Arial", 1, 12)));
        this.JTFFNPromedio.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter()));
        this.JTFFNPromedio.setHorizontalAlignment(4);
        this.JTFFNPromedio.setFont(new Font("Arial", 1, 14));
        GroupLayout JPIConsolidadoLayout = new GroupLayout(this.JPIConsolidado);
        this.JPIConsolidado.setLayout(JPIConsolidadoLayout);
        JPIConsolidadoLayout.setHorizontalGroup(JPIConsolidadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIConsolidadoLayout.createSequentialGroup().addGap(22, 22, 22).addComponent(this.JTFFNTriage, -2, 79, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFNTMinutos, -2, 90, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JTFFNPromedio, -2, 113, -2).addGap(26, 26, 26)));
        JPIConsolidadoLayout.setVerticalGroup(JPIConsolidadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIConsolidadoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFNPromedio, -2, 41, -2).addComponent(this.JTFFNTMinutos, -2, 41, -2).addComponent(this.JTFFNTriage, -2, 41, -2)));
        this.JCHFiltrado.setFont(new Font("Arial", 1, 12));
        this.JCHFiltrado.setSelected(true);
        this.JCHFiltrado.setText("Filtro");
        this.JCHFiltrado.setEnabled(false);
        this.JCHFiltrado.addActionListener(new ActionListener() { // from class: Informes.JIFAuditoriaTiemposInf.2
            public void actionPerformed(ActionEvent evt) {
                JIFAuditoriaTiemposInf.this.JCHFiltradoActionPerformed(evt);
            }
        });
        this.JCBTipoCita.setFont(new Font("Arial", 1, 12));
        this.JCBTipoCita.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Cita", 0, 0, new Font("Arial", 1, 12)));
        this.JCBTipoCita.setEnabled(false);
        this.JPIEstadoR.setBorder(BorderFactory.createTitledBorder((Border) null, "Estado de Resultado", 0, 0, new Font("Arial", 1, 13), Color.red));
        this.JBGDatos.add(this.JRBTodos);
        this.JRBTodos.setFont(new Font("Arial", 1, 12));
        this.JRBTodos.setSelected(true);
        this.JRBTodos.setText("Todos");
        this.JRBTodos.addActionListener(new ActionListener() { // from class: Informes.JIFAuditoriaTiemposInf.3
            public void actionPerformed(ActionEvent evt) {
                JIFAuditoriaTiemposInf.this.JRBTodosActionPerformed(evt);
            }
        });
        this.JBGDatos.add(this.JRBAlterado);
        this.JRBAlterado.setFont(new Font("Arial", 1, 12));
        this.JRBAlterado.setText("Alterados");
        this.JRBAlterado.addActionListener(new ActionListener() { // from class: Informes.JIFAuditoriaTiemposInf.4
            public void actionPerformed(ActionEvent evt) {
                JIFAuditoriaTiemposInf.this.JRBAlteradoActionPerformed(evt);
            }
        });
        this.JBGDatos.add(this.JRBNoAlterado);
        this.JRBNoAlterado.setFont(new Font("Arial", 1, 12));
        this.JRBNoAlterado.setText("No Alterados");
        this.JRBNoAlterado.addActionListener(new ActionListener() { // from class: Informes.JIFAuditoriaTiemposInf.5
            public void actionPerformed(ActionEvent evt) {
                JIFAuditoriaTiemposInf.this.JRBNoAlteradoActionPerformed(evt);
            }
        });
        GroupLayout JPIEstadoRLayout = new GroupLayout(this.JPIEstadoR);
        this.JPIEstadoR.setLayout(JPIEstadoRLayout);
        JPIEstadoRLayout.setHorizontalGroup(JPIEstadoRLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIEstadoRLayout.createSequentialGroup().addContainerGap().addComponent(this.JRBTodos).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBAlterado).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBNoAlterado).addContainerGap(-1, 32767)));
        JPIEstadoRLayout.setVerticalGroup(JPIEstadoRLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIEstadoRLayout.createSequentialGroup().addContainerGap().addGroup(JPIEstadoRLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBTodos).addComponent(this.JRBAlterado).addComponent(this.JRBNoAlterado)).addContainerGap(9, 32767)));
        GroupLayout JPIDatosCLayout = new GroupLayout(this.JPIDatosC);
        this.JPIDatosC.setLayout(JPIDatosCLayout);
        JPIDatosCLayout.setHorizontalGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosCLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(JPIDatosCLayout.createSequentialGroup().addComponent(this.JDCFechaI, -2, 127, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JDCFechaF, -2, 126, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPIEstadoR, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JPIConsolidado, -2, 335, -2)).addGroup(JPIDatosCLayout.createSequentialGroup().addComponent(this.JCBEspecialidad, -2, 423, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBTipoCita, -2, 399, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHFiltrado))).addContainerGap()));
        JPIDatosCLayout.setVerticalGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosCLayout.createSequentialGroup().addGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPIDatosCLayout.createSequentialGroup().addGap(11, 11, 11).addComponent(this.JPIConsolidado, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)).addGroup(JPIDatosCLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JDCFechaI, -2, 56, -2).addComponent(this.JDCFechaF, -2, 56, -2)).addComponent(this.JPIEstadoR, -1, -1, 32767)).addGap(11, 11, 11))).addGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBEspecialidad, -2, 48, -2).addComponent(this.JCBTipoCita, -2, 48, -2).addComponent(this.JCHFiltrado)).addContainerGap()));
        this.JSPDetalleResultado.setBorder(BorderFactory.createTitledBorder((Border) null, "RESULTADO", 2, 0, new Font("Arial", 1, 14), Color.blue));
        this.JTResultado.setFont(new Font("Arial", 1, 12));
        this.JTResultado.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTResultado.setRowHeight(25);
        this.JTResultado.setSelectionBackground(new Color(255, 255, 255));
        this.JTResultado.setSelectionForeground(new Color(255, 0, 0));
        this.JTResultado.setSelectionMode(0);
        this.JTResultado.addMouseListener(new MouseAdapter() { // from class: Informes.JIFAuditoriaTiemposInf.6
            public void mouseClicked(MouseEvent evt) {
                JIFAuditoriaTiemposInf.this.JTResultadoMouseClicked(evt);
            }
        });
        this.JSPDetalleResultado.setViewportView(this.JTResultado);
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JSPDetalleResultado, GroupLayout.Alignment.LEADING).addComponent(this.JPIDatosC, GroupLayout.Alignment.LEADING, -2, -1, -2)).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatosC, -2, -1, -2).addGap(18, 18, 18).addComponent(this.JSPDetalleResultado, -2, -1, -2).addContainerGap(-1, 32767)));
        this.JTFFNOrden.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Ordenes", 0, 0, new Font("Arial", 1, 12)));
        this.JTFFNOrden.setHorizontalAlignment(4);
        this.JTFFNOrden.setFont(new Font("Arial", 1, 14));
        this.JTFFNExamen.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Muestra", 0, 0, new Font("Arial", 1, 12)));
        this.JTFFNExamen.setHorizontalAlignment(4);
        this.JTFFNExamen.setFont(new Font("Arial", 1, 14));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTFFNOrden, -2, 115, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFFNExamen, -2, 115, -2).addContainerGap(713, 32767)).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, -1, -2).addContainerGap(-1, 32767))));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(688, 688, 688).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFNOrden, -2, -1, -2).addComponent(this.JTFFNExamen, -2, -1, -2)).addContainerGap(70, 32767)).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, -1, -2).addContainerGap(150, 32767))));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHFiltradoActionPerformed(ActionEvent evt) {
        if (this.JCHFiltrado.isSelected()) {
            this.JCBTipoCita.setEnabled(true);
            this.xfiltro = true;
        } else {
            this.JCBTipoCita.setEnabled(false);
            this.xfiltro = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTResultadoMouseClicked(MouseEvent evt) {
        if (this.JTResultado.getSelectedRow() != -1 && this.JTResultado.getValueAt(this.JTResultado.getSelectedRow(), 0) != null) {
            Object[] botones = {"Consultar Historia", "Consultar Examen", "Cerrar"};
            int n = JOptionPane.showOptionDialog(this, "Que desea hacer", "CONSULTAR", 0, 3, (Icon) null, botones, "Cerrar");
            String[][] mparametros = new String[4][2];
            if (n == 0) {
                mparametros[0][0] = "idatencion1";
                mparametros[0][1] = this.JTResultado.getValueAt(this.JTResultado.getSelectedRow(), 7).toString();
                mparametros[1][0] = "idpaciente1";
                mparametros[1][1] = this.JTResultado.getValueAt(this.JTResultado.getSelectedRow(), 6).toString();
                mparametros[2][0] = "SUBREPORT_DIR";
                mparametros[2][1] = this.xmetodos.getSO() + this.xmetodos.getBarra() + "Reportes" + this.xmetodos.getBarra();
                mparametros[3][0] = "SUBREPORTFIRMA_DIR";
                mparametros[3][1] = this.xmetodos.getSO() + this.xmetodos.getBarra() + "Firmas" + this.xmetodos.getBarra();
                this.xmetodos.GenerarPDF(this.xmetodos.getRutaRep() + "H_HistoriaClinica", mparametros);
                return;
            }
            if (n == 1) {
                mparametros[0][0] = "id";
                mparametros[0][1] = this.xmodelotabla.getValueAt(this.JTResultado.getSelectedRow(), 5).toString();
                mparametros[1][0] = "profesional";
                mparametros[1][1] = "";
                mparametros[2][0] = "SUBREPORT_DIR";
                mparametros[2][1] = this.xmetodos.getSO() + this.xmetodos.getBarra() + "Reportes" + this.xmetodos.getBarra();
                mparametros[3][0] = "SUBREPORTFIRMA_DIR";
                mparametros[3][1] = this.xmetodos.getSO() + this.xmetodos.getBarra() + "Firmas" + this.xmetodos.getBarra();
                this.xmetodos.GenerarPDF(this.xmetodos.getRutaRep() + "L_Resultados", mparametros);
                this.xconsultas.cerrarConexionBd();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBEspecialidadItemStateChanged(ItemEvent evt) {
        if (this.xlleno == 1 && this.JCBEspecialidad.getSelectedIndex() != -1) {
            this.JCBTipoCita.removeAllItems();
            String sql = "SELECT Id, Nbre FROM baseserver.c_clasecita WHERE (Id_Especialidad ='" + this.xidespecialidad[this.JCBEspecialidad.getSelectedIndex()] + "' AND Estado =0)";
            this.xidtipocita = this.xconsultas.llenarCombo(sql, this.xidtipocita, this.JCBTipoCita);
            this.JCBTipoCita.setSelectedIndex(-1);
            this.xconsultas.cerrarConexionBd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBTodosActionPerformed(ActionEvent evt) {
        this.xtipoexamen = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBAlteradoActionPerformed(ActionEvent evt) {
        this.xtipoexamen = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBNoAlteradoActionPerformed(ActionEvent evt) {
        this.xtipoexamen = 0;
    }

    public void buscar() {
        if (this.xvc == 0) {
            mCrearTablaDetalle();
            mCargarDatosTabla();
        } else {
            mCrearTablaDetalle();
            mCargarDatosTablaAtencionesFact();
        }
    }

    private void mCrearTablaDetalle() {
        this.xmodelotabla = new DefaultTableModel();
        this.xmodelotabla = new DefaultTableModel() { // from class: Informes.JIFAuditoriaTiemposInf.7
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        this.xmodelotabla.addColumn("N° Historia");
        this.xmodelotabla.addColumn("Usuario");
        this.xmodelotabla.addColumn("Fecha Examén");
        this.xmodelotabla.addColumn("Fecha Atención");
        this.xmodelotabla.addColumn("Diferencia");
        this.xmodelotabla.addColumn("");
        this.xmodelotabla.addColumn("");
        this.xmodelotabla.addColumn("");
        this.JTResultado.setModel(this.xmodelotabla);
        this.JTResultado.getColumnModel().getColumn(0).setPreferredWidth(20);
        this.JTResultado.getColumnModel().getColumn(1).setPreferredWidth(200);
        this.JTResultado.getColumnModel().getColumn(2).setPreferredWidth(50);
        this.JTResultado.getColumnModel().getColumn(3).setPreferredWidth(50);
        this.JTResultado.getColumnModel().getColumn(4).setPreferredWidth(50);
        this.JTResultado.getColumnModel().getColumn(5).setPreferredWidth(0);
        this.JTResultado.getColumnModel().getColumn(5).setMinWidth(0);
        this.JTResultado.getColumnModel().getColumn(5).setMaxWidth(0);
        this.JTResultado.getColumnModel().getColumn(6).setPreferredWidth(0);
        this.JTResultado.getColumnModel().getColumn(6).setMinWidth(0);
        this.JTResultado.getColumnModel().getColumn(6).setMaxWidth(0);
        this.JTResultado.getColumnModel().getColumn(7).setPreferredWidth(0);
        this.JTResultado.getColumnModel().getColumn(7).setMinWidth(0);
        this.JTResultado.getColumnModel().getColumn(7).setMaxWidth(0);
    }

    private void mCargarDatosTabla() {
        String sql;
        if (this.xtipoexamen == -1) {
            sql = "SELECT persona.NoHistoria, persona.NUsuario, l_recepcion.FechaRecep, h_atencion.Fecha_Atencion, DATEDIFF(Fecha_Atencion,FechaResult) AS DDias, l_resultados.Id_Recepcion , persona.Id_persona AS IdPersona, h_atencion.Id AS IdAtencion, profesional1.Especialidad, profesional1.NProfesional, g_procedimiento.Nbre FROM l_detallerecepcion INNER JOIN l_recepcion ON (l_detallerecepcion.Id_Recepcion = l_recepcion.Id) INNER JOIN g_procedimiento ON (g_procedimiento.Id= l_detallerecepcion.Id_Procedim) INNER JOIN l_resultados ON (l_resultados.Id_Recepcion = l_recepcion.Id) INNER JOIN persona  ON (persona.Id_persona = l_recepcion.Id_Paciente) INNER JOIN h_atencion  ON (h_atencion.Id = l_detallerecepcion.Id_Atencion) INNER JOIN profesional1  ON (profesional1.Id_Persona = h_atencion.Id_Profesional) AND (profesional1.IdEspecialidad = h_atencion.Id_Especialidad) WHERE (h_atencion.Fecha_Atencion >='" + this.xmetodos.formatoAMD.format(this.JDCFechaI.getDate()) + "' AND h_atencion.Fecha_Atencion <='" + this.xmetodos.formatoAMD.format(this.JDCFechaF.getDate()) + "' AND DATEDIFF(Fecha_Atencion,FechaResult)>=0)  GROUP BY l_recepcion.Id, l_detallerecepcion.Id_Procedim ORDER BY persona.NUsuario, g_procedimiento.Nbre";
        } else {
            sql = "SELECT persona.NoHistoria, persona.NUsuario, l_recepcion.FechaRecep, h_atencion.Fecha_Atencion, DATEDIFF(Fecha_Atencion,FechaResult) AS DDias, l_resultados.Id_Recepcion , persona.Id_persona AS IdPersona, h_atencion.Id AS IdAtencion, profesional1.Especialidad, profesional1.NProfesional, g_procedimiento.Nbre FROM l_detallerecepcion INNER JOIN l_recepcion ON (l_detallerecepcion.Id_Recepcion = l_recepcion.Id) INNER JOIN g_procedimiento ON (g_procedimiento.Id= l_detallerecepcion.Id_Procedim) INNER JOIN l_resultados ON (l_resultados.Id_Recepcion = l_recepcion.Id) INNER JOIN persona  ON (persona.Id_persona = l_recepcion.Id_Paciente) INNER JOIN h_atencion  ON (h_atencion.Id = l_detallerecepcion.Id_Atencion) INNER JOIN profesional1  ON (profesional1.Id_Persona = h_atencion.Id_Profesional) AND (profesional1.IdEspecialidad = h_atencion.Id_Especialidad) WHERE (h_atencion.Fecha_Atencion >='" + this.xmetodos.formatoAMD.format(this.JDCFechaI.getDate()) + "' AND h_atencion.Fecha_Atencion <='" + this.xmetodos.formatoAMD.format(this.JDCFechaF.getDate()) + "' and l_detallerecepcion.Alterado='" + this.xtipoexamen + "'AND DATEDIFF(Fecha_Atencion,FechaResult)>=0)  GROUP BY l_recepcion.Id, l_detallerecepcion.Id_Procedim ORDER BY persona.NUsuario, g_procedimiento.Nbre";
        }
        ResultSet rs = this.xconsultas.traerRs(sql);
        try {
            if (rs.next()) {
                this.JTFFNTriage.setValue(new Integer(0));
                this.JTFFNTMinutos.setValue(new Integer(0));
                this.JTFFNPromedio.setValue(new Integer(0));
                rs.last();
                int nt = rs.getRow();
                rs.beforeFirst();
                int xn = 0;
                int xnt = 0;
                while (rs.next()) {
                    this.xmodelotabla.addRow((Object[]) null);
                    this.xmodelotabla.setValueAt(rs.getString(1), xnt, 0);
                    this.xmodelotabla.setValueAt(rs.getString(2), xnt, 1);
                    this.xmodelotabla.setValueAt(rs.getString(3), xnt, 2);
                    this.xmodelotabla.setValueAt(rs.getString(4), xnt, 3);
                    this.xmodelotabla.setValueAt(rs.getString(5), xnt, 4);
                    this.xmodelotabla.setValueAt(rs.getString(6), xnt, 5);
                    this.xmodelotabla.setValueAt(rs.getString(7), xnt, 6);
                    this.xmodelotabla.setValueAt(rs.getString(8), xnt, 7);
                    xn += rs.getInt(5);
                    xnt++;
                }
                double xtotal = xn;
                this.JTFFNTriage.setValue(Integer.valueOf(nt));
                this.JTFFNTMinutos.setValue(Integer.valueOf(xn));
                this.JTFFNPromedio.setValue(Double.valueOf(xtotal / ((double) nt)));
            }
            rs.close();
            this.xconsultas.cerrarConexionBd();
            String sql2 = "SELECT COUNT(DISTINCT(l_recepcion.Id)) AS NRecepcion , COUNT(l_detallerecepcion.Id_Recepcion) AS NExamen  FROM baseserver.l_detallerecepcion INNER JOIN baseserver.l_recepcion  ON (l_detallerecepcion.Id_Recepcion = l_recepcion.Id)  WHERE (l_recepcion.FechaRecep >='" + this.xmetodos.formatoAMD.format(this.JDCFechaI.getDate()) + " 00:00:00' AND l_recepcion.FechaRecep <='" + this.xmetodos.formatoAMD.format(this.JDCFechaF.getDate()) + " 23:59:59' AND l_recepcion.Estado =0) ";
            ResultSet xrs = this.xconsultas.traerRs(sql2);
            if (xrs.next()) {
                xrs.first();
                this.JTFFNOrden.setValue(Long.valueOf(xrs.getLong(1)));
                this.JTFFNExamen.setValue(Long.valueOf(xrs.getLong(2)));
            }
            xrs.close();
            this.xconsultas.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFAuditoriaTiemposInf.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarDatosTablaAtencionesFact() {
        String sql;
        if (this.xfiltro) {
            sql = "SELECT persona.NoHistoria, persona.NUsuario, TIMESTAMP(h_atencion.Fecha_Atencion, h_atencion.Hora_Atencion) as FechaAt, TIMESTAMP(ingreso.FechaIngreso, ingreso.HoraIngreso) as FechaIng , TIMEDIFF(TIMESTAMP(h_atencion.Fecha_Atencion, h_atencion.Hora_Atencion),TIMESTAMP(ingreso.FechaIngreso, ingreso.HoraIngreso)) as DTiempo,0 as IDE, persona.Id_persona, h_atencion.Id FROM baseserver.h_atencion INNER JOIN baseserver.ingreso  ON (h_atencion.Id_Ingreso = ingreso.Id) INNER JOIN baseserver.persona  ON (persona.Id_persona = ingreso.Id_Usuario) WHERE (h_atencion.Id_Especialidad ='" + this.xidespecialidad[this.JCBEspecialidad.getSelectedIndex()] + "' AND h_atencion.Id_ClaseCita ='" + this.xidtipocita[this.JCBTipoCita.getSelectedIndex()] + "' AND h_atencion.Codigo_Dxp <>' 'AND h_atencion.Fecha_Atencion >='" + this.xmetodos.formatoAMD.format(this.JDCFechaI.getDate()) + "' AND h_atencion.Fecha_Atencion <='" + this.xmetodos.formatoAMD.format(this.JDCFechaF.getDate()) + "' and TIMEDIFF(TIMESTAMP(h_atencion.Fecha_Atencion, h_atencion.Hora_Atencion),TIMESTAMP(ingreso.FechaIngreso, ingreso.HoraIngreso))>='00:00:00' AND DATE_FORMAT(h_atencion.Fecha_Atencion,'%d-%m-Y')=DATE_FORMAT(ingreso.FechaIngreso,'%d-%m-Y') ) ORDER BY h_atencion.Fecha_Atencion ASC ";
        } else {
            sql = "SELECT persona.NoHistoria, persona.NUsuario, TIMESTAMP(h_atencion.Fecha_Atencion, h_atencion.Hora_Atencion) as FechaAt, TIMESTAMP(ingreso.FechaIngreso, ingreso.HoraIngreso) as FechaIng , TIMEDIFF(TIMESTAMP(h_atencion.Fecha_Atencion, h_atencion.Hora_Atencion),TIMESTAMP(ingreso.FechaIngreso, ingreso.HoraIngreso)) as DTiempo,0 as IDE, persona.Id_persona, h_atencion.Id FROM baseserver.h_atencion INNER JOIN baseserver.ingreso  ON (h_atencion.Id_Ingreso = ingreso.Id) INNER JOIN baseserver.persona  ON (persona.Id_persona = ingreso.Id_Usuario) WHERE (h_atencion.Id_Especialidad ='" + this.xidespecialidad[this.JCBEspecialidad.getSelectedIndex()] + "'  AND h_atencion.Codigo_Dxp <>' 'AND h_atencion.Fecha_Atencion >='" + this.xmetodos.formatoAMD.format(this.JDCFechaI.getDate()) + "' AND h_atencion.Fecha_Atencion <='" + this.xmetodos.formatoAMD.format(this.JDCFechaF.getDate()) + "' and TIMEDIFF(TIMESTAMP(h_atencion.Fecha_Atencion, h_atencion.Hora_Atencion),TIMESTAMP(ingreso.FechaIngreso, ingreso.HoraIngreso))>='00:00:00' AND DATE_FORMAT(h_atencion.Fecha_Atencion,'%d-%m-Y')=DATE_FORMAT(ingreso.FechaIngreso,'%d-%m-Y')) ORDER BY h_atencion.Fecha_Atencion ASC ";
        }
        ResultSet rs = this.xconsultas.traerRs(sql);
        try {
            if (rs.next()) {
                this.JTFFNTriage.setValue(new Integer(0));
                this.JTFFNTMinutos.setValue(new Integer(0));
                this.JTFFNPromedio.setValue(new Integer(0));
                rs.beforeFirst();
                int xn = 0;
                int xnt = 0;
                int xm = 0;
                int xs = 0;
                while (rs.next()) {
                    int xvt = Integer.valueOf(rs.getString(5).substring(0, 2)).intValue();
                    if (xvt >= 0) {
                        this.xmodelotabla.addRow((Object[]) null);
                        this.xmodelotabla.setValueAt(rs.getString(1), xn, 0);
                        this.xmodelotabla.setValueAt(rs.getString(2), xn, 1);
                        this.xmodelotabla.setValueAt(rs.getString(3), xn, 2);
                        this.xmodelotabla.setValueAt(rs.getString(4), xn, 3);
                        this.xmodelotabla.setValueAt(rs.getString(5), xn, 4);
                        this.xmodelotabla.setValueAt(rs.getString(6), xn, 5);
                        this.xmodelotabla.setValueAt(rs.getString(7), xn, 6);
                        this.xmodelotabla.setValueAt(rs.getString(8), xn, 7);
                        Integer.valueOf(rs.getString(5).substring(0, 2)).intValue();
                        xm += Integer.valueOf(rs.getString(5).substring(3, 5)).intValue();
                        xs += Integer.valueOf(rs.getString(5).substring(6, 8)).intValue();
                        xn++;
                        xnt++;
                    }
                }
                double xtotalt = (0 * 60) + xm + (xs / 60);
                this.JTFFNTriage.setValue(Integer.valueOf(xnt));
                this.JTFFNTMinutos.setValue(Double.valueOf(xtotalt));
                this.JTFFNPromedio.setValue(Double.valueOf(xtotalt / ((double) xnt)));
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

    private void mCargarDatosGenerales() {
        this.JTFFNTriage.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Total", 0, 0, new Font("Arial", 1, 12)));
        this.JTFFNTMinutos.setBorder(BorderFactory.createTitledBorder((Border) null, "Total Minutos", 0, 0, new Font("Arial", 1, 12)));
        this.JTFFNPromedio.setBorder(BorderFactory.createTitledBorder((Border) null, "Promedio(Minutos)", 0, 0, new Font("Arial", 1, 12)));
        this.xidespecialidad = this.xconsultas.llenarCombo("SELECT Id, Nbre FROM baseserver.g_especialidad WHERE (Estado =0) ORDER BY Nbre ASC", this.xidespecialidad, this.JCBEspecialidad);
        this.JCBEspecialidad.setSelectedIndex(-1);
        this.JCBEspecialidad.setEnabled(true);
        this.JCBTipoCita.setEnabled(true);
        this.JCHFiltrado.setEnabled(true);
        this.xconsultas.cerrarConexionBd();
        this.xlleno = 1;
    }

    /* JADX INFO: loaded from: GenomaP.jar:Informes/JIFAuditoriaTiemposInf$MiRender.class */
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
}
