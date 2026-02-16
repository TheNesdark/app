package com.genoma.plus.controller.laboratorio;

import Acceso.Principal;
import Laboratorio.TareaOrdenesPendientePorValidar;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import Utilidades.MetodosGenericos;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.genoma.plus.controller.laboratorio.dto.CustomPresenter;
import com.genoma.plus.controller.laboratorio.dto.DetalleResultadoDTO;
import com.genoma.plus.controller.laboratorio.dto.EncabezadoResultadoDTO;
import com.genoma.plus.controller.laboratorio.dto.ListDetalleResultadosMaquinaDTO;
import com.genoma.plus.controller.laboratorio.dto.ResultadoDTO;
import com.genoma.plus.controller.laboratorio.dto.infoAlertaRececion;
import com.genoma.plus.dao.impl.laboratorio.LaboratorioDAOImpl;
import com.genoma.plus.dao.laboratorio.LaboratorioDAO;
import com.genoma.plus.domains.models.domains.general.RecursosMicroserviciosDomain;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.net.URI;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/laboratorio/JIFValidacionMasiva_API.class */
public class JIFValidacionMasiva_API extends JInternalFrame {
    private DefaultTableModel modeloEncabezado;
    private DefaultTableModel modeloFiltro;
    private DefaultTableModel modeloFiltro1;
    private DefaultTableModel modeloSede;
    private Object[] datoEncabezado;
    private Object[] datoHistorico;
    private Object[] datoArea;
    private Object[] datoSede;
    private int paginaActual;
    private int registrosPorPagina;
    private int filtro;
    private LaboratorioDAO xImplLabotaorio;
    private JButton BontonAgregarProcedimeinto;
    private JCheckBox JCHSelect;
    private JDateChooser JDFechaF;
    private JDateChooser JDFechaI;
    private JRadioButton JRBPorValidar;
    private JRadioButton JRBValidado;
    private JTable JTBFiltros;
    private JTable JTBFiltros1;
    private JTable JTBSedes;
    private JTable JTEncabezado;
    private JLabel LabelFiltro;
    private ButtonGroup buttonGroup1;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JPanel jPanel4;
    private JPanel jPanel5;
    private JPanel jPanel6;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JScrollPane jScrollPane3;
    private JScrollPane jScrollPane4;
    Metodos metodos = new Metodos();
    MetodosGenericos<infoAlertaRececion> metodosGenericos = new MetodosGenericos<>();
    List<ListDetalleResultadosMaquinaDTO> listDetalleResultadosMaquinaDTO = new ArrayList();
    private ConsultasMySQL xct = new ConsultasMySQL();
    private boolean xestado = false;
    List<String> idProcedimientoSeleccionadas = new ArrayList();

    static /* synthetic */ int access$808(JIFValidacionMasiva_API x0) {
        int i = x0.paginaActual;
        x0.paginaActual = i + 1;
        return i;
    }

    public JIFValidacionMasiva_API() {
        initComponents();
        springStart();
        nuevo();
    }

    private void springStart() {
        this.xImplLabotaorio = (LaboratorioDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("laboratorioDAOImpl");
    }

    /* JADX WARN: Type inference failed for: r3v25, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v37, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v40, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v96, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.buttonGroup1 = new ButtonGroup();
        this.jPanel1 = new JPanel();
        this.jPanel2 = new JPanel();
        this.JDFechaI = new JDateChooser();
        this.JDFechaF = new JDateChooser();
        this.jPanel4 = new JPanel();
        this.jScrollPane1 = new JScrollPane();
        this.JTBSedes = new JTable();
        this.jPanel6 = new JPanel();
        this.jScrollPane2 = new JScrollPane();
        this.JTBFiltros = new JTable();
        this.jScrollPane4 = new JScrollPane();
        this.JTBFiltros1 = new JTable();
        this.jPanel3 = new JPanel();
        this.JRBPorValidar = new JRadioButton();
        this.JRBValidado = new JRadioButton();
        this.JCHSelect = new JCheckBox();
        this.BontonAgregarProcedimeinto = new JButton();
        this.LabelFiltro = new JLabel();
        this.jPanel5 = new JPanel();
        this.jScrollPane3 = new JScrollPane();
        this.JTEncabezado = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("VALIDACION MASIVA");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("ValidacionMasiva");
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "PARAMETROS DE BUSQUEDA", 2, 0, new Font("Arial", 1, 14), Color.blue));
        this.jPanel2.setBorder(BorderFactory.createTitledBorder((Border) null, "RANGOS DE BUSQUEDA", 2, 0, new Font("Arial", 1, 10), Color.red));
        this.JDFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicial", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFechaI.setFont(new Font("Arial", 1, 12));
        this.JDFechaI.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.laboratorio.JIFValidacionMasiva_API.1
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFValidacionMasiva_API.this.JDFechaIPropertyChange(evt);
            }
        });
        this.JDFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Final", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFechaF.setFont(new Font("Arial", 1, 12));
        this.JDFechaF.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.laboratorio.JIFValidacionMasiva_API.2
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFValidacionMasiva_API.this.JDFechaFPropertyChange(evt);
            }
        });
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(this.JDFechaI, -2, 120, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JDFechaF, -2, 120, -2).addContainerGap(-1, 32767)));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JDFechaF, -1, -1, 32767).addComponent(this.JDFechaI, -2, 62, -2)).addGap(0, 11, 32767)));
        this.jPanel4.setBorder(BorderFactory.createTitledBorder((Border) null, "SEDES", 2, 0, new Font("Arial", 1, 10), Color.red));
        this.JTBSedes.setFont(new Font("Arial", 1, 10));
        this.JTBSedes.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.jScrollPane1.setViewportView(this.JTBSedes);
        GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
        this.jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.jScrollPane1, -2, 346, -2).addGap(111, 111, 111)));
        jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane1, -2, 152, -2).addGap(10, 10, 10)));
        this.jPanel6.setBorder(BorderFactory.createTitledBorder((Border) null, "FILTROS", 2, 0, new Font("Arial", 1, 10), Color.red));
        this.JTBFiltros.setFont(new Font("Arial", 1, 12));
        this.JTBFiltros.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.jScrollPane2.setViewportView(this.JTBFiltros);
        this.JTBFiltros1.setFont(new Font("Arial", 1, 12));
        this.JTBFiltros1.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.jScrollPane4.setViewportView(this.JTBFiltros1);
        GroupLayout jPanel6Layout = new GroupLayout(this.jPanel6);
        this.jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel6Layout.createSequentialGroup().addContainerGap().addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane2, -2, 359, -2).addComponent(this.jScrollPane4, -2, 358, -2)).addContainerGap(-1, 32767)));
        jPanel6Layout.setVerticalGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane2, -2, 75, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jScrollPane4, -2, 67, -2).addGap(10, 10, 10)));
        this.jPanel3.setBorder(BorderFactory.createTitledBorder((Border) null, "FILTROS", 2, 0, new Font("Arial", 1, 10), Color.red));
        this.jPanel3.setForeground(Color.red);
        this.buttonGroup1.add(this.JRBPorValidar);
        this.JRBPorValidar.setFont(new Font("Arial", 1, 12));
        this.JRBPorValidar.setSelected(true);
        this.JRBPorValidar.setText("Por Validar");
        this.JRBPorValidar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.laboratorio.JIFValidacionMasiva_API.3
            public void actionPerformed(ActionEvent evt) {
                JIFValidacionMasiva_API.this.JRBPorValidarActionPerformed(evt);
            }
        });
        this.buttonGroup1.add(this.JRBValidado);
        this.JRBValidado.setFont(new Font("Arial", 1, 12));
        this.JRBValidado.setText("Validado");
        this.JRBValidado.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.laboratorio.JIFValidacionMasiva_API.4
            public void actionPerformed(ActionEvent evt) {
                JIFValidacionMasiva_API.this.JRBValidadoActionPerformed(evt);
            }
        });
        GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
        this.jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addGap(25, 25, 25).addComponent(this.JRBPorValidar).addGap(18, 18, 18).addComponent(this.JRBValidado).addContainerGap(60, 32767)));
        jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBValidado).addComponent(this.JRBPorValidar)).addGap(0, 6, 32767)));
        this.JCHSelect.setFont(new Font("Arial", 1, 12));
        this.JCHSelect.setText("Select Todo ?");
        this.JCHSelect.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.laboratorio.JIFValidacionMasiva_API.5
            public void actionPerformed(ActionEvent evt) {
                JIFValidacionMasiva_API.this.JCHSelectActionPerformed(evt);
            }
        });
        this.BontonAgregarProcedimeinto.setFont(new Font("Arial", 1, 12));
        this.BontonAgregarProcedimeinto.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Buscar.png")));
        this.BontonAgregarProcedimeinto.setText("Procedimiento ?");
        this.BontonAgregarProcedimeinto.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.laboratorio.JIFValidacionMasiva_API.6
            public void actionPerformed(ActionEvent evt) {
                JIFValidacionMasiva_API.this.BontonAgregarProcedimeintoActionPerformed(evt);
            }
        });
        this.LabelFiltro.setFont(new Font("Arial", 1, 14));
        this.LabelFiltro.setForeground(new Color(255, 0, 0));
        this.LabelFiltro.setText("  ");
        this.LabelFiltro.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jPanel2, -2, -1, -2).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel3, -1, -1, 32767).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JCHSelect).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.BontonAgregarProcedimeinto).addGap(0, 0, 32767))))).addGap(18, 18, 18).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jPanel4, -2, 367, -2).addGap(10, 10, 10).addComponent(this.jPanel6, -2, -1, -2)).addComponent(this.LabelFiltro, -1, -1, 32767)).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jPanel6, -1, -1, 32767).addComponent(this.jPanel4, -1, -1, 32767)).addGap(18, 18, 18).addComponent(this.LabelFiltro).addGap(0, 9, 32767)).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jPanel2, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel3, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.BontonAgregarProcedimeinto).addComponent(this.JCHSelect)))).addContainerGap()));
        this.jPanel5.setBorder(BorderFactory.createTitledBorder((Border) null, "RESULTADOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 204, 0)));
        this.JTEncabezado.setFont(new Font("Arial", 1, 10));
        this.JTEncabezado.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.jScrollPane3.setViewportView(this.JTEncabezado);
        GroupLayout jPanel5Layout = new GroupLayout(this.jPanel5);
        this.jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane3, -2, 1086, -2).addGap(5, 5, 5)));
        jPanel5Layout.setVerticalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addGap(5, 5, 5).addComponent(this.jScrollPane3, -1, 446, 32767).addContainerGap()));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(5, 5, 5).addComponent(this.jPanel1, -1, -1, 32767)).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.jPanel5, -2, -1, -2))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.jPanel1, -1, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel5, -2, -1, -2).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaIPropertyChange(PropertyChangeEvent evt) {
        if (this.xestado) {
            mCargarDatoSedes();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaFPropertyChange(PropertyChangeEvent evt) {
        if (this.xestado) {
            mCargarDatoSedes();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBPorValidarActionPerformed(ActionEvent evt) {
        this.filtro = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBValidadoActionPerformed(ActionEvent evt) {
        this.filtro = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHSelectActionPerformed(ActionEvent evt) {
        boolean selected = this.JCHSelect.isSelected();
        seleccionarTodasLasFilas(selected);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BontonAgregarProcedimeintoActionPerformed(ActionEvent evt) {
        this.idProcedimientoSeleccionadas.clear();
        JDAdicionarProcedimeinto jDAdicionarProcedimeinto = new JDAdicionarProcedimeinto(null, true, this.metodos.formatoAMD1.format(this.JDFechaI.getDate()), this.metodos.formatoAMD1.format(this.JDFechaF.getDate()), null);
        jDAdicionarProcedimeinto.setLocationRelativeTo(null);
        jDAdicionarProcedimeinto.setVisible(true);
        List<String> selectedIds = jDAdicionarProcedimeinto.getIdProcedimientoSeleccionadas();
        if (selectedIds != null && !selectedIds.isEmpty()) {
            String idsConcatenados = String.join(", ", selectedIds);
            System.out.println("Cantidad de procedimientos seleccionados: " + selectedIds.size());
            System.out.println("CUPS SELECCIONADOS PARA FILTRAR: " + idsConcatenados);
            System.out.println("==========================================");
            this.LabelFiltro.setText("IDs seleccionados: " + idsConcatenados);
            this.idProcedimientoSeleccionadas.addAll(selectedIds);
            return;
        }
        this.LabelFiltro.setText("No se seleccionó ningún procedimiento.");
    }

    private void seleccionarTodasLasFilas(boolean selected) {
        if (this.listDetalleResultadosMaquinaDTO.isEmpty()) {
            JOptionPane.showMessageDialog((Component) null, "No hay datos para seleccionar.", "Advertencia", 2);
            this.JCHSelect.setSelected(false);
            return;
        }
        for (int i = 0; i < this.listDetalleResultadosMaquinaDTO.size(); i++) {
            if (((Integer) this.modeloEncabezado.getValueAt(i, 17)).intValue() == 0) {
                this.modeloEncabezado.setValueAt(Boolean.valueOf(selected), i, 0);
            }
        }
        this.JTEncabezado.repaint();
    }

    public void nuevo() {
        this.LabelFiltro.setText("ACTUALMENTE NO ESTAS FILTRANDO POR PROCEDIMIENTO ");
        this.paginaActual = 0;
        this.registrosPorPagina = 100;
        this.filtro = 0;
        this.JDFechaI.setDate(this.metodos.getFechaActual());
        this.JDFechaF.setDate(this.metodos.getFechaActual());
        mCrearModeloDatos();
        mCargarDatoSedes();
        llenarModeloFiltro();
        llenarModeloFiltro1();
        this.xestado = true;
        this.idProcedimientoSeleccionadas.clear();
    }

    private void mCargarDatoSedes() {
        try {
            String xsql = "SELECT\n\tgs.Id,\n\tconcat(gs.Nbre,' (',gm.Nbre,')') as sede\nFROM\n\tl_detallerecepcion ld\nINNER JOIN l_recepcion lr on\n\t(ld.Id_Recepcion = lr.Id)\nINNER JOIN g_sedes gs on\n\t(lr.Id_Sede = gs.Id)\nINNER JOIN g_procedimiento gp ON\n\t(ld.Id_Procedim = gp.Id)\nINNER JOIN g_municipio gm  ON\n\t(gs.Id_Municipio = gm.Id )\nWHERE\n\t(DATE_FORMAT(lr.FechaRecep, '%Y-%m-%d') BETWEEN '" + this.metodos.formatoAMD1.format(this.JDFechaI.getDate()) + "' AND '" + this.metodos.formatoAMD1.format(this.JDFechaF.getDate()) + "'\n\t\tAND lr.Estado = 0\n\t\tAND gp.EsRemitido =0)\nGROUP BY gs.Id\nORDER BY gs.Nbre ASC";
            System.out.println(xsql);
            ResultSet xrs = this.xct.traerRs(xsql);
            Throwable th = null;
            try {
                try {
                    modeloDetalleSede();
                    if (xrs.next()) {
                        int x = 0;
                        xrs.beforeFirst();
                        while (xrs.next()) {
                            this.modeloSede.addRow(this.datoSede);
                            this.modeloSede.setValueAt(Integer.valueOf(xrs.getInt(1)), x, 0);
                            this.modeloSede.setValueAt(xrs.getString(2), x, 1);
                            this.modeloSede.setValueAt(false, x, 2);
                            x++;
                        }
                    }
                    if (xrs != null) {
                        if (0 != 0) {
                            try {
                                xrs.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                        } else {
                            xrs.close();
                        }
                    }
                    this.xct.cerrarConexionBd();
                } finally {
                }
            } catch (Throwable th3) {
                th = th3;
                throw th3;
            }
        } catch (SQLException ex) {
            Logger.getLogger(JIFValidacionMasiva_API.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void modeloDetalleSede() {
        this.modeloSede = new DefaultTableModel(new Object[0], new String[]{"Id", "Opcion", "Cargar"}) { // from class: com.genoma.plus.controller.laboratorio.JIFValidacionMasiva_API.7
            Class[] types = {Integer.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTBSedes.setModel(this.modeloSede);
        this.JTBSedes.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTBSedes.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTBSedes.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTBSedes.getColumnModel().getColumn(1).setPreferredWidth(300);
        this.JTBSedes.getColumnModel().getColumn(2).setPreferredWidth(50);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void modeloDetalleFiltro() {
        this.modeloFiltro = new DefaultTableModel(new Object[0], new String[]{"Id", "Opcion", "Cargar"}) { // from class: com.genoma.plus.controller.laboratorio.JIFValidacionMasiva_API.8
            Class[] types = {Integer.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTBFiltros.setModel(this.modeloFiltro);
        this.JTBFiltros.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTBFiltros.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTBFiltros.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTBFiltros.getColumnModel().getColumn(1).setPreferredWidth(300);
        this.JTBFiltros.getColumnModel().getColumn(2).setPreferredWidth(50);
    }

    private void llenarModeloFiltro() {
        modeloDetalleFiltro();
        this.modeloFiltro.setRowCount(0);
        this.modeloFiltro.addRow(new Object[]{1, "Con Resultado", false});
        this.modeloFiltro.addRow(new Object[]{2, "Sin Resultado", false});
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void modeloDetalleFiltro1() {
        this.modeloFiltro1 = new DefaultTableModel(new Object[0], new String[]{"Id", "Nombre", "Cargar"}) { // from class: com.genoma.plus.controller.laboratorio.JIFValidacionMasiva_API.9
            Class[] types = {Integer.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTBFiltros1.setModel(this.modeloFiltro1);
        this.JTBFiltros1.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTBFiltros1.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTBFiltros1.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTBFiltros1.getColumnModel().getColumn(1).setPreferredWidth(500);
        this.JTBFiltros1.getColumnModel().getColumn(2).setPreferredWidth(10);
    }

    private void llenarModeloFiltro1() {
        modeloDetalleFiltro1();
        this.modeloFiltro1.setRowCount(0);
        this.modeloFiltro1.addRow(new Object[]{0, "Resultado Normal", false});
        this.modeloFiltro1.addRow(new Object[]{1, "Resultado FueraRango", false});
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        String[] columnas = {"S", "RECEPCION", "CUPS", "PROCEDIMIENTO", "IDPROCEDIMIENTOPROTOCOLO", "FORMULA", "PROTOCOLO", "RESULTADO", "UNIDAD", "MINIMO", "MAXIMO", "VALIDADOLABORATORIO", "VALIDACION", "NORDENI", "ORDEN", "IDEQUIPO", "ABREVIATURA", "FUERADERANGO", "EDAD", "TALLA", "PESO", "PERIMETROAB", "PERIMETROCOP", "NOMBREQUIPO"};
        this.modeloEncabezado = new DefaultTableModel(new Object[0], columnas) { // from class: com.genoma.plus.controller.laboratorio.JIFValidacionMasiva_API.10
            Class[] types = {Boolean.class, Integer.class, Long.class, String.class, Integer.class, String.class, String.class, Double.class, String.class, String.class, String.class, Integer.class, String.class, Integer.class, Integer.class, Integer.class, String.class, Integer.class, Integer.class, Double.class, Double.class, Double.class, Double.class, String.class};
            boolean[] canEdit = {true, false, false, false, false, false, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTEncabezado.setModel(this.modeloEncabezado);
        this.JTEncabezado.getColumnModel().getColumn(0).setPreferredWidth(50);
        this.JTEncabezado.getColumnModel().getColumn(1).setPreferredWidth(90);
        this.JTEncabezado.getColumnModel().getColumn(2).setPreferredWidth(90);
        this.JTEncabezado.getColumnModel().getColumn(3).setPreferredWidth(300);
        this.JTEncabezado.getColumnModel().getColumn(4).setPreferredWidth(0);
        this.JTEncabezado.getColumnModel().getColumn(4).setMinWidth(0);
        this.JTEncabezado.getColumnModel().getColumn(4).setMaxWidth(0);
        this.JTEncabezado.getColumnModel().getColumn(5).setPreferredWidth(0);
        this.JTEncabezado.getColumnModel().getColumn(5).setMinWidth(0);
        this.JTEncabezado.getColumnModel().getColumn(5).setMaxWidth(0);
        this.JTEncabezado.getColumnModel().getColumn(6).setPreferredWidth(260);
        this.JTEncabezado.getColumnModel().getColumn(7).setPreferredWidth(120);
        this.JTEncabezado.getColumnModel().getColumn(8).setPreferredWidth(100);
        this.JTEncabezado.getColumnModel().getColumn(9).setPreferredWidth(100);
        this.JTEncabezado.getColumnModel().getColumn(10).setPreferredWidth(100);
        this.JTEncabezado.getColumnModel().getColumn(11).setPreferredWidth(0);
        this.JTEncabezado.getColumnModel().getColumn(11).setMinWidth(0);
        this.JTEncabezado.getColumnModel().getColumn(11).setMaxWidth(0);
        this.JTEncabezado.getColumnModel().getColumn(12).setPreferredWidth(70);
        this.JTEncabezado.getColumnModel().getColumn(13).setPreferredWidth(0);
        this.JTEncabezado.getColumnModel().getColumn(13).setMinWidth(0);
        this.JTEncabezado.getColumnModel().getColumn(13).setMaxWidth(0);
        this.JTEncabezado.getColumnModel().getColumn(14).setPreferredWidth(0);
        this.JTEncabezado.getColumnModel().getColumn(14).setMinWidth(0);
        this.JTEncabezado.getColumnModel().getColumn(14).setMaxWidth(0);
        this.JTEncabezado.getColumnModel().getColumn(15).setPreferredWidth(0);
        this.JTEncabezado.getColumnModel().getColumn(15).setMinWidth(0);
        this.JTEncabezado.getColumnModel().getColumn(15).setMaxWidth(0);
        this.JTEncabezado.getColumnModel().getColumn(16).setPreferredWidth(100);
        this.JTEncabezado.getColumnModel().getColumn(17).setPreferredWidth(50);
        this.JTEncabezado.getColumnModel().getColumn(18).setPreferredWidth(0);
        this.JTEncabezado.getColumnModel().getColumn(18).setMinWidth(0);
        this.JTEncabezado.getColumnModel().getColumn(18).setMaxWidth(0);
        this.JTEncabezado.getColumnModel().getColumn(19).setPreferredWidth(0);
        this.JTEncabezado.getColumnModel().getColumn(19).setMinWidth(0);
        this.JTEncabezado.getColumnModel().getColumn(19).setMaxWidth(0);
        this.JTEncabezado.getColumnModel().getColumn(20).setPreferredWidth(0);
        this.JTEncabezado.getColumnModel().getColumn(20).setMinWidth(0);
        this.JTEncabezado.getColumnModel().getColumn(20).setMaxWidth(0);
        this.JTEncabezado.getColumnModel().getColumn(21).setPreferredWidth(0);
        this.JTEncabezado.getColumnModel().getColumn(21).setMinWidth(0);
        this.JTEncabezado.getColumnModel().getColumn(21).setMaxWidth(0);
        this.JTEncabezado.getColumnModel().getColumn(22).setPreferredWidth(0);
        this.JTEncabezado.getColumnModel().getColumn(22).setMinWidth(0);
        this.JTEncabezado.getColumnModel().getColumn(22).setMaxWidth(0);
        this.JTEncabezado.getColumnModel().getColumn(23).setPreferredWidth(0);
        this.JTEncabezado.getColumnModel().getColumn(23).setMinWidth(0);
        this.JTEncabezado.getColumnModel().getColumn(23).setMaxWidth(0);
        TableCellRenderer textAreaRenderer = new TableCellRenderer() { // from class: com.genoma.plus.controller.laboratorio.JIFValidacionMasiva_API.11
            JTextArea textArea = new JTextArea();

            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                this.textArea.setText((String) value);
                this.textArea.setWrapStyleWord(true);
                this.textArea.setLineWrap(true);
                this.textArea.setOpaque(true);
                if (isSelected) {
                    this.textArea.setBackground(table.getSelectionBackground());
                    this.textArea.setForeground(table.getSelectionForeground());
                } else {
                    this.textArea.setBackground(table.getBackground());
                    this.textArea.setForeground(table.getForeground());
                }
                int width = table.getColumnModel().getColumn(column).getWidth();
                this.textArea.setSize(new Dimension(width, 32767));
                int height = this.textArea.getPreferredSize().height;
                if (table.getRowHeight(row) != height) {
                    table.setRowHeight(row, height);
                }
                return this.textArea;
            }
        };
        this.JTEncabezado.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.laboratorio.JIFValidacionMasiva_API.12
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                if (keyCode == 40 || keyCode == 34) {
                    int selectedRow = JIFValidacionMasiva_API.this.JTEncabezado.getSelectedRow();
                    int totalRows = JIFValidacionMasiva_API.this.JTEncabezado.getRowCount();
                    if (selectedRow == totalRows - 1) {
                        JIFValidacionMasiva_API.this.cargarSiguientePagina();
                    }
                }
            }
        });
        this.JTEncabezado.getColumnModel().getColumn(3).setCellRenderer(textAreaRenderer);
        this.JTEncabezado.getColumnModel().getColumn(6).setCellRenderer(textAreaRenderer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cargarSiguientePagina() {
        int totalRegistros = this.listDetalleResultadosMaquinaDTO.size();
        int registrosMostrados = (this.paginaActual + 1) * this.registrosPorPagina;
        if (registrosMostrados < totalRegistros) {
            this.paginaActual++;
            System.out.println("Cargando página: " + this.paginaActual);
            cargarPagina(this.paginaActual);
            this.JTEncabezado.setRowSelectionInterval(registrosMostrados, registrosMostrados);
        }
    }

    private boolean validarSelecciones(List<Integer> idFiltrosSeleccionadas, List<Integer> idFiltros1Seleccionadas, List<Integer> idSedesSeleccionadas) {
        idFiltrosSeleccionadas.clear();
        idFiltros1Seleccionadas.clear();
        idSedesSeleccionadas.clear();
        for (int i = 0; i < this.JTBFiltros.getRowCount(); i++) {
            Boolean cargar = (Boolean) this.JTBFiltros.getValueAt(i, 2);
            if (cargar != null && cargar.booleanValue()) {
                Integer idFiltro = (Integer) this.JTBFiltros.getValueAt(i, 0);
                idFiltrosSeleccionadas.add(idFiltro);
            }
        }
        for (int i2 = 0; i2 < this.JTBFiltros1.getRowCount(); i2++) {
            Boolean cargar2 = (Boolean) this.JTBFiltros1.getValueAt(i2, 2);
            if (cargar2 != null && cargar2.booleanValue()) {
                Integer idFiltro1 = (Integer) this.JTBFiltros1.getValueAt(i2, 0);
                idFiltros1Seleccionadas.add(idFiltro1);
            }
        }
        for (int i3 = 0; i3 < this.JTBSedes.getRowCount(); i3++) {
            Boolean cargar3 = (Boolean) this.JTBSedes.getValueAt(i3, 2);
            if (cargar3 != null && cargar3.booleanValue()) {
                Integer idSede = (Integer) this.JTBSedes.getValueAt(i3, 0);
                idSedesSeleccionadas.add(idSede);
            }
        }
        if (idFiltrosSeleccionadas.isEmpty() || idSedesSeleccionadas.isEmpty() || idFiltros1Seleccionadas.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar al menos un Filtro y una sede.", "Error", 0);
            return false;
        }
        return true;
    }

    public void buscar() {
        mCrearModeloDatos();
        String date1 = this.metodos.formatoAMD1.format(this.JDFechaI.getDate());
        String date2 = this.metodos.formatoAMD1.format(this.JDFechaF.getDate());
        List<Integer> idSedesSeleccionadas = new ArrayList<>();
        List<Integer> idFiltrosSeleccionadas = new ArrayList<>();
        List<Integer> idFiltros1Seleccionadas = new ArrayList<>();
        if (!validarSelecciones(idFiltrosSeleccionadas, idFiltros1Seleccionadas, idSedesSeleccionadas)) {
            return;
        }
        System.out.println("idFiltrosSeleccionadas de filtros seleccionadas: " + idFiltrosSeleccionadas);
        System.out.println("idFiltros1Seleccionadas de filtros 1 seleccionadas: " + idFiltros1Seleccionadas);
        System.out.println("idSedesSeleccionadas de sedes seleccionadas: " + idSedesSeleccionadas);
        System.out.println("idSedesSeleccionadas de idProcedimientoSeleccionadas seleccionadas: " + this.idProcedimientoSeleccionadas);
        RecursosMicroserviciosDomain microserviciosDomain = this.metodos.getParametrosEncriptados("24", "ListValidacionMasiva");
        String baseUrl = microserviciosDomain.getUrlRecurso();
        String idSedeStr = String.join(",", (CharSequence[]) idSedesSeleccionadas.stream().map((v0) -> {
            return v0.toString();
        }).toArray(x$0 -> {
            return new String[x$0];
        }));
        String idFiltrosStr = String.join(",", (CharSequence[]) idFiltrosSeleccionadas.stream().map((v0) -> {
            return v0.toString();
        }).toArray(x$02 -> {
            return new String[x$02];
        }));
        String idFiltros1Str = String.join(",", (CharSequence[]) idFiltros1Seleccionadas.stream().map((v0) -> {
            return v0.toString();
        }).toArray(x$03 -> {
            return new String[x$03];
        }));
        String idProcedimeintoStr = String.join(",", (CharSequence[]) this.idProcedimientoSeleccionadas.stream().map((v0) -> {
            return v0.toString();
        }).toArray(x$04 -> {
            return new String[x$04];
        }));
        System.err.println("baseUrl" + baseUrl);
        URI fullUri = UriBuilder.fromUri(baseUrl).path("buscar").queryParam("date1", new Object[]{date1}).queryParam("date2", new Object[]{date2}).queryParam("idSede", new Object[]{idSedeStr}).queryParam("idArea", new Object[]{7}).queryParam("idFiltros", new Object[]{idFiltrosStr}).queryParam("idFiltros1", new Object[]{idFiltros1Str}).queryParam("reportado", new Object[]{Integer.valueOf(this.filtro)}).queryParam("idProcedimientos", new Object[]{idProcedimeintoStr}).build(new Object[0]);
        String fullUrl = fullUri.toString();
        System.out.println("fullUrl --- " + fullUrl);
        Response response = this.metodos.getResteasyClient().target(fullUrl).request().get();
        int statusCode = response.getStatus();
        System.out.println("Status Code: " + statusCode);
        if (statusCode == 200) {
            try {
                new CustomPresenter();
                CustomPresenter presenter = (CustomPresenter) this.metodos.getMapper().readValue((String) response.readEntity(String.class), CustomPresenter.class);
                System.out.println("Presenter Data: " + presenter.getData());
                this.listDetalleResultadosMaquinaDTO = (List) this.metodos.getMapper().readValue(this.metodos.getMapper().writeValueAsString(presenter.getData()), new TypeReference<List<ListDetalleResultadosMaquinaDTO>>() { // from class: com.genoma.plus.controller.laboratorio.JIFValidacionMasiva_API.13
                });
                System.out.println("Número de registros recibidos: " + this.listDetalleResultadosMaquinaDTO.size());
                SwingUtilities.invokeLater(() -> {
                    cargarPagina(0);
                    configurarScrollPaginado();
                });
            } catch (JsonProcessingException e) {
                Logger.getLogger(TareaOrdenesPendientePorValidar.class.getName()).log(Level.SEVERE, (String) null, e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cargarPagina(int pagina) {
        int inicio = pagina * this.registrosPorPagina;
        int fin = Math.min(inicio + this.registrosPorPagina, this.listDetalleResultadosMaquinaDTO.size());
        if (pagina == 0) {
            this.modeloEncabezado.setRowCount(0);
        }
        for (int i = inicio; i < fin; i++) {
            ListDetalleResultadosMaquinaDTO detalle = this.listDetalleResultadosMaquinaDTO.get(i);
            Object[] fila = {false, detalle.getIdRecepcion(), detalle.getIdProcedimiento(), detalle.getProcedimiento(), detalle.getIdProcedimientoProtocolo(), detalle.getFormula(), detalle.getProtocolo(), detalle.getResultado(), detalle.getUnidad(), detalle.getValorRefecenciaMinimo(), detalle.getValorRefecenciaMaximo(), detalle.getValidadoLaboratorio(), detalle.getValidacion(), detalle.getNuneroOrdenI(), detalle.getOrden(), detalle.getIdEquipo(), detalle.getAbreviatura(), detalle.getFueraDeRango(), detalle.getEdad(), detalle.getTalla(), detalle.getPeso(), detalle.getPerimetroAbdominal(), detalle.getSuperficieCorporal(), detalle.getNombreEquipo()};
            this.modeloEncabezado.addRow(fila);
        }
        this.JTEncabezado.repaint();
    }

    private void configurarScrollPaginado() {
        JScrollPane scrollPane = this.JTEncabezado.getParent().getParent();
        final JScrollBar scrollBar = scrollPane.getVerticalScrollBar();
        int totalRegistros = this.listDetalleResultadosMaquinaDTO.size();
        final int totalPaginas = (int) Math.ceil(((double) totalRegistros) / ((double) this.registrosPorPagina));
        scrollBar.addAdjustmentListener(new AdjustmentListener() { // from class: com.genoma.plus.controller.laboratorio.JIFValidacionMasiva_API.14
            public void adjustmentValueChanged(AdjustmentEvent e) {
                if (!e.getValueIsAdjusting() && scrollBar.getValue() + scrollBar.getVisibleAmount() >= scrollBar.getMaximum()) {
                    if (JIFValidacionMasiva_API.this.paginaActual < totalPaginas - 1) {
                        JIFValidacionMasiva_API.access$808(JIFValidacionMasiva_API.this);
                        System.out.println("Cargando página: " + JIFValidacionMasiva_API.this.paginaActual);
                        JIFValidacionMasiva_API.this.cargarPagina(JIFValidacionMasiva_API.this.paginaActual);
                        return;
                    }
                    System.out.println("No hay más datos por cargar.");
                }
            }
        });
        int maxScroll = totalRegistros * this.JTEncabezado.getRowHeight();
        scrollBar.setMaximum(maxScroll);
    }

    public void grabar() {
        if (!this.JRBValidado.isSelected()) {
            EncabezadoResultadoDTO encabezadoResultado = EncabezadoResultadoDTO.builder().detallesEncabezadoResultado(new ArrayList()).build();
            Map<Long, ResultadoDTO> resultadoMap = new HashMap<>();
            for (int registro = 0; registro < this.JTEncabezado.getRowCount(); registro++) {
                Boolean seleccionado = (Boolean) this.JTEncabezado.getValueAt(registro, 0);
                Integer fueraDeRango = (Integer) this.JTEncabezado.getValueAt(registro, 17);
                if (Boolean.TRUE.equals(seleccionado) && fueraDeRango.equals(0)) {
                    Long idRecepcion = Long.valueOf(this.JTEncabezado.getValueAt(registro, 1).toString());
                    ResultadoDTO resultadoDTO = resultadoMap.get(idRecepcion);
                    if (resultadoDTO == null) {
                        resultadoDTO = ResultadoDTO.builder().idRecepcion(idRecepcion).fechaResult(this.metodos.formatoISO8601.format(this.metodos.getFechaActual())).idEspecialidad(Long.valueOf(Principal.informacionGeneralPrincipalDTO.getIdEspecialidad().toString())).idProfesional(Principal.usuarioSistemaDTO.getIdUsuarioSistema()).estado(0).soporte(0).url("").estadoHcBs1(0).fecha(this.metodos.formatoISO8601.format(this.metodos.getFechaActual())).usuarioS(Principal.usuarioSistemaDTO.getLogin()).detallesResultado(new ArrayList()).build();
                        resultadoMap.put(idRecepcion, resultadoDTO);
                    }
                    DetalleResultadoDTO detalle = DetalleResultadoDTO.builder().fecha(this.metodos.formatoISO8601.format(this.metodos.getFechaActual())).idEspecialidad(Long.valueOf(Principal.informacionGeneralPrincipalDTO.getIdEspecialidad().toString())).bacteriologo(Principal.usuarioSistemaDTO.getIdUsuarioSistema()).idProcedimiento(Long.valueOf(this.JTEncabezado.getValueAt(registro, 2).toString())).idProtocolprocedim(Integer.valueOf(this.JTEncabezado.getValueAt(registro, 4).toString())).resultado(1).vrNumerico(this.JTEncabezado.getValueAt(registro, 7).toString()).unidad(this.JTEncabezado.getValueAt(registro, 8).toString()).valorRefecenciaMinimo(this.JTEncabezado.getValueAt(registro, 9).toString()).valorRefecenciaMaximo(this.JTEncabezado.getValueAt(registro, 10).toString()).alterado(Integer.valueOf(this.JTEncabezado.getValueAt(registro, 17).toString())).imprime(1).validado(1).idEspecialidadV(Long.valueOf(Principal.informacionGeneralPrincipalDTO.getIdEspecialidad().toString())).idProfesionalV(Principal.usuarioSistemaDTO.getIdUsuarioSistema()).estado(1).build();
                    resultadoDTO.getDetallesResultado().add(detalle);
                }
            }
            encabezadoResultado.getDetallesEncabezadoResultado().addAll(resultadoMap.values());
            System.out.println("EncabezadoResultadoDTO:");
            System.out.println(encabezadoResultado);
            try {
                RecursosMicroserviciosDomain microserviciosDomain = this.metodos.getParametrosEncriptados("24", "RegistrarResultadoMasivo");
                Response responsePos = this.metodos.getResteasyClient().target(microserviciosDomain.getUrlRecurso()).request().post(Entity.json(this.metodos.getMapper().writeValueAsString(encabezadoResultado)));
                if (responsePos.getStatus() == Response.Status.OK.getStatusCode()) {
                    String responseBody = (String) responsePos.readEntity(String.class);
                    System.out.println("Respuesta del servidor: " + responseBody);
                    CustomPresenter presenter = (CustomPresenter) this.metodos.getMapper().readValue(responseBody, CustomPresenter.class);
                    if (presenter.getData() != null) {
                        JsonNode dataNode = (JsonNode) this.metodos.getMapper().convertValue(presenter.getData(), JsonNode.class);
                        JsonNode<JsonNode> detallesEncabezadoResultadoNode = dataNode.get("detallesEncabezadoResultado");
                        if (detallesEncabezadoResultadoNode != null && detallesEncabezadoResultadoNode.isArray()) {
                            for (JsonNode resultadoNode : detallesEncabezadoResultadoNode) {
                                Long idRecepcion2 = Long.valueOf(resultadoNode.get("idRecepcion").asLong());
                                JsonNode<JsonNode> detallesResultadoNode = resultadoNode.get("detallesResultado");
                                if (detallesResultadoNode != null && detallesResultadoNode.isArray()) {
                                    for (JsonNode detalleNode : detallesResultadoNode) {
                                        Long idProcedimiento = Long.valueOf(detalleNode.get("idProcedimiento").asLong());
                                        System.err.println("" + idProcedimiento + " " + idRecepcion2);
                                        this.xImplLabotaorio.updateDetalleRecepcion(Integer.valueOf(detalleNode.get("alterado").asInt()), 1, idProcedimiento, idRecepcion2, 0, 1);
                                    }
                                }
                            }
                        }
                    }
                    JOptionPane.showMessageDialog(this, "La operación se completó exitosamente.", "Éxito", 1);
                    mGrabarComentarioProcedimiento();
                    buscar();
                } else {
                    String errorMessage = "Error en la solicitud. Código de estado: " + responsePos.getStatus();
                    if (responsePos.hasEntity()) {
                        errorMessage = errorMessage + "\nMensaje de error: " + ((String) responsePos.readEntity(String.class));
                    }
                    JOptionPane.showMessageDialog(this, errorMessage, "Error", 0);
                    Logger.getLogger(JIFValidacionMasiva_API.class.getName()).log(Level.SEVERE, errorMessage);
                }
                responsePos.close();
                return;
            } catch (Exception ex) {
                Logger.getLogger(JIFValidacionMasiva_API.class.getName()).log(Level.SEVERE, "Error inesperado", (Throwable) ex);
                JOptionPane.showMessageDialog(this, "Ocurrió un error inesperado. Por favor, intente nuevamente.", "Error", 0);
                return;
            } catch (JsonProcessingException e) {
                Logger.getLogger(JIFValidacionMasiva_API.class.getName()).log(Level.SEVERE, "Error al procesar JSON", e);
                JOptionPane.showMessageDialog(this, "Error al procesar los datos. Por favor, verifique la información.", "Error", 0);
                return;
            }
        }
        JOptionPane.showMessageDialog(this, "Resultados Validados", "Error", 0);
        Logger.getLogger(JIFValidacionMasiva_API.class.getName()).log(Level.SEVERE, "Resultados Validados");
    }

    private void mGrabarComentarioProcedimiento() {
        for (int registro = 0; registro < this.JTEncabezado.getRowCount(); registro++) {
            Boolean seleccionado = (Boolean) this.JTEncabezado.getValueAt(registro, 0);
            Integer fueraDeRango = (Integer) this.JTEncabezado.getValueAt(registro, 17);
            if (Boolean.TRUE.equals(seleccionado) && fueraDeRango.equals(0)) {
                List<Object[]> list = this.xImplLabotaorio.listComentariosProcedimientoMaquinaResultado(this.modeloEncabezado.getValueAt(registro, 2).toString(), this.modeloEncabezado.getValueAt(registro, 23).toString(), this.modeloEncabezado.getValueAt(registro, 1).toString());
                if (list == null || list.isEmpty()) {
                    List<Object[]> listComentarioProcedimiento = this.xImplLabotaorio.listComentariosProcedimientoMaquina(this.modeloEncabezado.getValueAt(registro, 2).toString(), this.modeloEncabezado.getValueAt(registro, 23).toString());
                    if (listComentarioProcedimiento != null || !listComentarioProcedimiento.isEmpty()) {
                        for (int x = 0; x < listComentarioProcedimiento.size(); x++) {
                            System.out.println("Descripcion: " + listComentarioProcedimiento.get(x)[1].toString());
                            System.out.println("Nombre Maquina: " + listComentarioProcedimiento.get(x)[2].toString());
                            System.out.println("No. Orden: " + listComentarioProcedimiento.get(x)[3].toString());
                            this.xImplLabotaorio.addComentarioArea(Long.valueOf(this.modeloEncabezado.getValueAt(registro, 1).toString()), Long.valueOf(this.modeloEncabezado.getValueAt(registro, 2).toString()), new Long(0L), listComentarioProcedimiento.get(x)[1].toString(), Integer.valueOf(listComentarioProcedimiento.get(x)[3].toString()), listComentarioProcedimiento.get(x)[2].toString());
                        }
                    } else {
                        System.out.println("procedimiento con comentario grabado anteriormente : ");
                    }
                } else {
                    System.out.println("procedimiento si comentario : ");
                }
            }
        }
    }
}
