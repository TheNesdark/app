package com.genoma.plus.controller.comprabs;

import Acceso.Principal;
import Utilidades.Metodos;
import com.genoma.plus.dao.comprabs.ConsolidadoContratosDAO;
import com.genoma.plus.dao.impl.comprabs.ConsolidadoContratosDAOImpl;
import com.genoma.plus.dto.comprabs.ConsolidadoContratosDTO;
import com.toedter.calendar.JYearChooser;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.util.List;
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
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/comprabs/JIFConsolidadoContratos.class */
public class JIFConsolidadoContratos extends JInternalFrame {
    private Metodos xmt = new Metodos();
    private ConsolidadoContratosDAO xConsolidadoContratosDAO;
    private DefaultTableModel xModelo;
    private Object[] xdatos;
    private File xfile;
    private ButtonGroup JBG_Filtro;
    private JButton JBTExportar;
    private JButton JBTExportar1;
    private JCheckBox JCH_Activo;
    private JCheckBox JCH_Activo1;
    private JCheckBox JCH_Activo2;
    private JCheckBox JCH_Activo3;
    private JCheckBox JCH_Activo4;
    private JPanel JPBotones;
    private JPanel JPExportar;
    private JPanel JPI_ConvencionC;
    private JPanel JPI_Filtro;
    private JRadioButton JRB_PorAno;
    private JRadioButton JRB_Todos;
    private JScrollPane JSPResultado;
    private JTabbedPane JTBPOpciones;
    private JTable JTDetalle;
    private JTextField JTFRuta;
    private JYearChooser JYAno;

    public JIFConsolidadoContratos() {
        initComponents();
        springStart();
        this.JYAno.setValue(Integer.valueOf(this.xmt.formatoANO.format(this.xmt.getFechaActual())).intValue());
        mCargarDatos();
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
    }

    private void springStart() {
        this.xConsolidadoContratosDAO = (ConsolidadoContratosDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("consolidadoContratosDAO");
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCreaModelo() {
        this.xModelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Nº Contrato", "FechaC", "FechaF", "Duracion", "Tercero", "Unidad Funcional", "Tipo Documento", "Objetivo General", "Valor Presupuesto", "Iva", "Administrador", "Cargo", "IdDiponibilidad", "Es Prorroga?", "Estado", "Validacion", "Seguimientos", "Documentos", "Adicion", "Alerta", "Pago Vigente", " Tipo Gasto"}) { // from class: com.genoma.plus.controller.comprabs.JIFConsolidadoContratos.1
            Class[] types = {Long.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Double.class, Double.class, String.class, String.class, Long.class, String.class, String.class, Integer.class, String.class, String.class, String.class, String.class, Double.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTDetalle;
        JTable jTable2 = this.JTDetalle;
        jTable.setAutoResizeMode(0);
        this.JTDetalle.doLayout();
        this.JTDetalle.setModel(this.xModelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(12).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(13).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(14).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(15).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(16).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(16).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(16).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(17).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(18).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(19).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(20).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(21).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(22).setPreferredWidth(150);
    }

    private void mCargarDatos() {
        List<ConsolidadoContratosDTO> list;
        if (this.JRB_PorAno.isSelected()) {
            list = this.xConsolidadoContratosDAO.listar(this.JYAno.getValue(), true, mVerificarCheks());
        } else {
            list = this.xConsolidadoContratosDAO.listar(this.JYAno.getValue(), false, mVerificarCheks());
        }
        mCreaModelo();
        for (int x = 0; x < list.size(); x++) {
            this.xmt.mEstablecerTextEditor(this.JTDetalle, 8);
            this.xmt.mEstablecerTextEditor(this.JTDetalle, 17);
            this.xmt.mEstablecerTextEditor(this.JTDetalle, 18);
            this.xmt.mEstablecerTextEditor(this.JTDetalle, 19);
            this.xModelo.addRow(this.xdatos);
            this.xModelo.setValueAt(Integer.valueOf(list.get(x).getId()), x, 0);
            this.xModelo.setValueAt(list.get(x).getNInterno(), x, 1);
            this.xModelo.setValueAt(list.get(x).getFechaC(), x, 2);
            this.xModelo.setValueAt(list.get(x).getFechaFinC(), x, 3);
            this.xModelo.setValueAt(list.get(x).getDuracion(), x, 4);
            this.xModelo.setValueAt(list.get(x).getTercero(), x, 5);
            this.xModelo.setValueAt(list.get(x).getUnidadF(), x, 6);
            this.xModelo.setValueAt(list.get(x).getTipoDocumento(), x, 7);
            this.xModelo.setValueAt(list.get(x).getObjetivoG(), x, 8);
            this.xModelo.setValueAt(list.get(x).getValorP(), x, 9);
            this.xModelo.setValueAt(list.get(x).getIva(), x, 10);
            this.xModelo.setValueAt(list.get(x).getAdministrador(), x, 11);
            this.xModelo.setValueAt(list.get(x).getCargo(), x, 12);
            this.xModelo.setValueAt(Integer.valueOf(list.get(x).getIdDisponibilidad()), x, 13);
            if (list.get(x).getEsProg() == 1) {
                this.xModelo.setValueAt("SI", x, 14);
            } else {
                this.xModelo.setValueAt("NO", x, 14);
            }
            if (list.get(x).getEstado() == 1) {
                this.xModelo.setValueAt("ACTIVO", x, 15);
            } else {
                this.xModelo.setValueAt("ANULADO", x, 15);
            }
            this.xModelo.setValueAt(Integer.valueOf(list.get(x).getValidacion()), x, 16);
            this.xModelo.setValueAt(list.get(x).getSeguimientos(), x, 17);
            this.xModelo.setValueAt(list.get(x).getDocumentos(), x, 18);
            this.xModelo.setValueAt(list.get(x).getAdicion(), x, 19);
            this.xModelo.setValueAt(list.get(x).getPVigencia(), x, 21);
            this.xModelo.setValueAt(list.get(x).getTipoGasto(), x, 22);
            this.JTDetalle.setDefaultRenderer(Object.class, new MiRenderHistorico());
        }
    }

    /* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/comprabs/JIFConsolidadoContratos$MiRenderHistorico.class */
    public static class MiRenderHistorico extends DefaultTableCellRenderer {
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            int nvalidacion = Integer.valueOf(table.getValueAt(row, 16).toString()).intValue();
            if (nvalidacion == -2) {
                cell.setBackground(Color.cyan);
                cell.setForeground(Color.BLACK);
                table.setValueAt("Cerrado", row, 20);
            } else if (nvalidacion == -1 || nvalidacion == 3) {
                cell.setBackground(Color.WHITE);
                cell.setForeground(Color.BLACK);
                table.setValueAt("Activo", row, 20);
            } else if (nvalidacion == 0) {
                cell.setBackground(Color.red);
                cell.setForeground(Color.BLACK);
                table.setValueAt("<=30 días", row, 20);
            } else if (nvalidacion == 1) {
                cell.setBackground(new Color(255, 255, 0));
                cell.setForeground(Color.BLACK);
                table.setValueAt(">30 y <=90 días", row, 20);
            } else if (nvalidacion == 2) {
                cell.setBackground(new Color(0, 204, 0));
                cell.setForeground(Color.BLACK);
                table.setValueAt(">90 días", row, 20);
            }
            return cell;
        }
    }

    private String mVerificarCheks() {
        String v1 = this.JCH_Activo4.isSelected() ? "-2" : "";
        String v2 = this.JCH_Activo1.isSelected() ? ",-1,3" : "";
        String v3 = this.JCH_Activo.isSelected() ? ",0" : "";
        String v4 = this.JCH_Activo2.isSelected() ? ",1" : "";
        String v5 = this.JCH_Activo3.isSelected() ? ",2" : "";
        String xcheks = v1 + v2 + v3 + v4 + v5;
        if (!this.JCH_Activo4.isSelected() && !this.JCH_Activo1.isSelected() && !this.JCH_Activo.isSelected() && !this.JCH_Activo2.isSelected() && !this.JCH_Activo3.isSelected()) {
            xcheks = "-100";
        }
        return xcheks;
    }

    /* JADX WARN: Type inference failed for: r3v6, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBG_Filtro = new ButtonGroup();
        this.JSPResultado = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JPI_Filtro = new JPanel();
        this.JRB_Todos = new JRadioButton();
        this.JRB_PorAno = new JRadioButton();
        this.JYAno = new JYearChooser();
        this.JPI_ConvencionC = new JPanel();
        this.JCH_Activo = new JCheckBox();
        this.JCH_Activo1 = new JCheckBox();
        this.JCH_Activo2 = new JCheckBox();
        this.JCH_Activo3 = new JCheckBox();
        this.JCH_Activo4 = new JCheckBox();
        this.JTBPOpciones = new JTabbedPane();
        this.JPBotones = new JPanel();
        this.JBTExportar1 = new JButton();
        this.JPExportar = new JPanel();
        this.JTFRuta = new JTextField();
        this.JBTExportar = new JButton();
        setClosable(true);
        setIconifiable(true);
        setTitle("CONSOLIDADO DE CONTRATOS");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        this.JSPResultado.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setEditingColumn(1);
        this.JTDetalle.setEditingRow(1);
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.comprabs.JIFConsolidadoContratos.2
            public void mouseClicked(MouseEvent evt) {
                JIFConsolidadoContratos.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPResultado.setViewportView(this.JTDetalle);
        this.JPI_Filtro.setBorder(BorderFactory.createTitledBorder((Border) null, "Filtro", 0, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JBG_Filtro.add(this.JRB_Todos);
        this.JRB_Todos.setFont(new Font("Arial", 1, 12));
        this.JRB_Todos.setText("Todos");
        this.JRB_Todos.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.comprabs.JIFConsolidadoContratos.3
            public void actionPerformed(ActionEvent evt) {
                JIFConsolidadoContratos.this.JRB_TodosActionPerformed(evt);
            }
        });
        this.JBG_Filtro.add(this.JRB_PorAno);
        this.JRB_PorAno.setFont(new Font("Arial", 1, 12));
        this.JRB_PorAno.setSelected(true);
        this.JRB_PorAno.setText("Por año de inicio");
        this.JRB_PorAno.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.comprabs.JIFConsolidadoContratos.4
            public void actionPerformed(ActionEvent evt) {
                JIFConsolidadoContratos.this.JRB_PorAnoActionPerformed(evt);
            }
        });
        this.JYAno.setBorder(BorderFactory.createTitledBorder((Border) null, "Año", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JYAno.setYear(2016);
        this.JYAno.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.comprabs.JIFConsolidadoContratos.5
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFConsolidadoContratos.this.JYAnoPropertyChange(evt);
            }
        });
        GroupLayout JPI_FiltroLayout = new GroupLayout(this.JPI_Filtro);
        this.JPI_Filtro.setLayout(JPI_FiltroLayout);
        JPI_FiltroLayout.setHorizontalGroup(JPI_FiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_FiltroLayout.createSequentialGroup().addContainerGap().addComponent(this.JRB_Todos).addGap(18, 18, 18).addComponent(this.JRB_PorAno).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 24, 32767).addComponent(this.JYAno, -2, 82, -2).addContainerGap()));
        JPI_FiltroLayout.setVerticalGroup(JPI_FiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_FiltroLayout.createSequentialGroup().addContainerGap().addGroup(JPI_FiltroLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRB_Todos).addComponent(this.JRB_PorAno)).addContainerGap(-1, 32767)).addGroup(JPI_FiltroLayout.createSequentialGroup().addComponent(this.JYAno, -2, 50, -2).addGap(0, 0, 32767)));
        this.JPI_ConvencionC.setBorder(BorderFactory.createTitledBorder((Border) null, "Convenciones de colores para alerta ", 0, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JCH_Activo.setBackground(new Color(255, 255, 255));
        this.JCH_Activo.setFont(new Font("Arial", 1, 12));
        this.JCH_Activo.setSelected(true);
        this.JCH_Activo.setText("Activo");
        this.JCH_Activo.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.comprabs.JIFConsolidadoContratos.6
            public void actionPerformed(ActionEvent evt) {
                JIFConsolidadoContratos.this.JCH_ActivoActionPerformed(evt);
            }
        });
        this.JCH_Activo1.setBackground(Color.red);
        this.JCH_Activo1.setFont(new Font("Arial", 1, 12));
        this.JCH_Activo1.setSelected(true);
        this.JCH_Activo1.setText("<=30 días");
        this.JCH_Activo1.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.comprabs.JIFConsolidadoContratos.7
            public void actionPerformed(ActionEvent evt) {
                JIFConsolidadoContratos.this.JCH_Activo1ActionPerformed(evt);
            }
        });
        this.JCH_Activo2.setBackground(new Color(255, 255, 0));
        this.JCH_Activo2.setFont(new Font("Arial", 1, 12));
        this.JCH_Activo2.setSelected(true);
        this.JCH_Activo2.setText(">30 y <=90 días");
        this.JCH_Activo2.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.comprabs.JIFConsolidadoContratos.8
            public void actionPerformed(ActionEvent evt) {
                JIFConsolidadoContratos.this.JCH_Activo2ActionPerformed(evt);
            }
        });
        this.JCH_Activo3.setBackground(Color.green);
        this.JCH_Activo3.setFont(new Font("Arial", 1, 12));
        this.JCH_Activo3.setSelected(true);
        this.JCH_Activo3.setText(">90 días");
        this.JCH_Activo3.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.comprabs.JIFConsolidadoContratos.9
            public void actionPerformed(ActionEvent evt) {
                JIFConsolidadoContratos.this.JCH_Activo3ActionPerformed(evt);
            }
        });
        this.JCH_Activo4.setBackground(Color.cyan);
        this.JCH_Activo4.setFont(new Font("Arial", 1, 12));
        this.JCH_Activo4.setSelected(true);
        this.JCH_Activo4.setText("Cerrado");
        this.JCH_Activo4.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.comprabs.JIFConsolidadoContratos.10
            public void actionPerformed(ActionEvent evt) {
                JIFConsolidadoContratos.this.JCH_Activo4ActionPerformed(evt);
            }
        });
        GroupLayout JPI_ConvencionCLayout = new GroupLayout(this.JPI_ConvencionC);
        this.JPI_ConvencionC.setLayout(JPI_ConvencionCLayout);
        JPI_ConvencionCLayout.setHorizontalGroup(JPI_ConvencionCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_ConvencionCLayout.createSequentialGroup().addContainerGap().addGroup(JPI_ConvencionCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCH_Activo, -2, 113, -2).addComponent(this.JCH_Activo1, -2, 113, -2)).addGap(13, 13, 13).addGroup(JPI_ConvencionCLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JCH_Activo2, -1, -1, 32767).addComponent(this.JCH_Activo3, -1, -1, 32767)).addGap(18, 18, 18).addComponent(this.JCH_Activo4, -1, -1, 32767).addGap(43, 43, 43)));
        JPI_ConvencionCLayout.setVerticalGroup(JPI_ConvencionCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_ConvencionCLayout.createSequentialGroup().addGroup(JPI_ConvencionCLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCH_Activo).addComponent(this.JCH_Activo2).addComponent(this.JCH_Activo4)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addGroup(JPI_ConvencionCLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCH_Activo1).addComponent(this.JCH_Activo3))));
        this.JTBPOpciones.setForeground(Color.red);
        this.JTBPOpciones.setFont(new Font("Arial", 1, 14));
        this.JBTExportar1.setFont(new Font("Arial", 1, 12));
        this.JBTExportar1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/AgendaMedica.png")));
        this.JBTExportar1.setText("Cierre");
        this.JBTExportar1.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.comprabs.JIFConsolidadoContratos.11
            public void actionPerformed(ActionEvent evt) {
                JIFConsolidadoContratos.this.JBTExportar1ActionPerformed(evt);
            }
        });
        GroupLayout JPBotonesLayout = new GroupLayout(this.JPBotones);
        this.JPBotones.setLayout(JPBotonesLayout);
        JPBotonesLayout.setHorizontalGroup(JPBotonesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPBotonesLayout.createSequentialGroup().addContainerGap().addComponent(this.JBTExportar1, -2, 149, -2).addContainerGap(761, 32767)));
        JPBotonesLayout.setVerticalGroup(JPBotonesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPBotonesLayout.createSequentialGroup().addContainerGap().addComponent(this.JBTExportar1, -2, 50, -2).addContainerGap(-1, 32767)));
        this.JTBPOpciones.addTab("OPCIONES", this.JPBotones);
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.comprabs.JIFConsolidadoContratos.12
            public void mouseClicked(MouseEvent evt) {
                JIFConsolidadoContratos.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.comprabs.JIFConsolidadoContratos.13
            public void actionPerformed(ActionEvent evt) {
                JIFConsolidadoContratos.this.JBTExportarActionPerformed(evt);
            }
        });
        GroupLayout JPExportarLayout = new GroupLayout(this.JPExportar);
        this.JPExportar.setLayout(JPExportarLayout);
        JPExportarLayout.setHorizontalGroup(JPExportarLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPExportarLayout.createSequentialGroup().addContainerGap().addComponent(this.JTFRuta, -1, 694, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTExportar, -2, 198, -2).addGap(12, 12, 12)));
        JPExportarLayout.setVerticalGroup(JPExportarLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPExportarLayout.createSequentialGroup().addGroup(JPExportarLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBTExportar, -2, 50, -2).addComponent(this.JTFRuta, -2, 50, -2)).addGap(12, 12, 12)));
        this.JTBPOpciones.addTab("EXPORTAR", this.JPExportar);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.JPI_Filtro, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JPI_ConvencionC, -2, -1, -2)).addComponent(this.JSPResultado).addComponent(this.JTBPOpciones)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JPI_ConvencionC, -1, -1, 32767).addComponent(this.JPI_Filtro, -1, -1, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPResultado, -1, 291, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTBPOpciones, -2, 100, -2).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            Principal.txtNo.setText(this.xModelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JYAnoPropertyChange(PropertyChangeEvent evt) {
        mCargarDatos();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JFileChooser xfilec = new JFileChooser(this.JTFRuta.getText());
            xfilec.setFileSelectionMode(1);
            int xv = xfilec.showOpenDialog(this);
            if (xv == 0) {
                this.xfile = xfilec.getSelectedFile();
                this.JTFRuta.setText(this.xfile.getAbsolutePath() + this.xmt.getBarra());
                this.JTFRuta.requestFocus();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTExportarActionPerformed(ActionEvent evt) {
        if (this.JTDetalle.getRowCount() > 0) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTDetalle, this.JTFRuta.getText(), getTitle());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_TodosActionPerformed(ActionEvent evt) {
        mCargarDatos();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_PorAnoActionPerformed(ActionEvent evt) {
        mCargarDatos();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTExportar1ActionPerformed(ActionEvent evt) {
        if (!Principal.txtNo.getText().isEmpty()) {
            JDCierreOrden jdcierre = new JDCierreOrden(null, true);
            jdcierre.setLocationRelativeTo(this);
            jdcierre.setVisible(true);
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Tienen que seleccionar un Contrato", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_Activo3ActionPerformed(ActionEvent evt) {
        mCargarDatos();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_ActivoActionPerformed(ActionEvent evt) {
        mCargarDatos();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_Activo1ActionPerformed(ActionEvent evt) {
        mCargarDatos();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_Activo2ActionPerformed(ActionEvent evt) {
        mCargarDatos();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_Activo4ActionPerformed(ActionEvent evt) {
        mCargarDatos();
    }
}
