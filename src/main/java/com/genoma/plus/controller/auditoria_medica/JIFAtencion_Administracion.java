package com.genoma.plus.controller.auditoria_medica;

import Acceso.Principal;
import Utilidades.Metodos;
import com.genoma.plus.controller.utilidades.JDRegistroTrazabilidad;
import com.genoma.plus.dao.auditoria_medica.AuditoriaMedicaDAO;
import com.genoma.plus.dao.impl.auditoria_medica.AuditoriaMedicaDAOImpl;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;
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
import java.beans.PropertyVetoException;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
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

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/auditoria_medica/JIFAtencion_Administracion.class */
public class JIFAtencion_Administracion extends JInternalFrame {
    private AuditoriaMedicaDAO xAuditoriaMedicaDAO;
    private DefaultTableModel xModelo;
    private Object[] xdatos;
    private String[] idServicio;
    private ButtonGroup JBGFitroAtencion;
    private ButtonGroup JBGFitroFacturacion;
    private ButtonGroup JBGFitroSeguimiento;
    private JButton JBTExportar;
    private JButton JBTRegistrarSeguimiento;
    private JComboBox<String> JCB_Servicio;
    private JCheckBox JCH_CConSeguimiento;
    private JCheckBox JCH_CTodos;
    private JCheckBox JCH_Filtro;
    private JCheckBox JCH_Prefactura;
    private JCheckBox JCH_SSeguimiento;
    private JDateChooser JDFFechaF;
    private JDateChooser JDFFechaI;
    private JLabel JLN_NRegistro;
    private JPanel JPIConvenciones;
    private JPanel JPIFiltro;
    private JPanel JPI_Datos1;
    private JPanel JPI_Datos2;
    private JPanel JPI_FFacturacion;
    private JRadioButton JRBFF_Evento;
    private JRadioButton JRBFF_NOrden;
    private JRadioButton JRBFF_Todos;
    private JScrollPane JSP_Detalle;
    private JTable JTDetalle;
    private JTextField JTFNo;
    private JTextField JTFRuta;
    private JTextField JTF_Filtro;
    private JTabbedPane JTP_Utilidades;
    private Metodos xmt = new Metodos();
    private String xtipo = "1,2,3,4,5,6,7,8,9,10";
    private String xFiltro = "0,1";
    private String xFiltroF = "0,1,2";
    private Boolean estadoLlenadoCombo = false;
    private List<String> idServicioList = new ArrayList();

    public JIFAtencion_Administracion(String xTitulo) {
        initComponents();
        springStart();
        setTitle(getTitle() + " - " + xTitulo);
        mNuevo();
    }

    private void springStart() {
        this.xAuditoriaMedicaDAO = (AuditoriaMedicaDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("auditoriaMedicaDAO");
    }

    public void mBuscar() {
        mCargarDatosTabla();
    }

    public void mNuevo() {
        this.estadoLlenadoCombo = false;
        this.JCH_Filtro.setSelected(true);
        this.JCB_Servicio.setEnabled(false);
        this.JDFFechaI.setDate(this.xmt.getFechaActual());
        this.JDFFechaF.setDate(this.xmt.getFechaActual());
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
        this.JTF_Filtro.setText("");
        this.JTFNo.setText("");
        llenarComboServicio();
        mCreaModeloTabla();
        this.estadoLlenadoCombo = true;
    }

    private void llenarComboServicio() {
        this.JCB_Servicio.removeAllItems();
        List<Object[]> listaServicio = this.xAuditoriaMedicaDAO.listaServiciosFiltradoParaAuditoria(this.xmt.formatoAMD1.format(this.JDFFechaI.getDate()), this.xmt.formatoAMD1.format(this.JDFFechaF.getDate()), this.JTF_Filtro.getText(), this.xFiltro, this.xFiltroF, this.JTFNo.getText());
        this.idServicioList = new ArrayList();
        if (!listaServicio.isEmpty()) {
            this.xtipo = "";
            this.idServicio = new String[listaServicio.size()];
            for (int i = 0; i < listaServicio.size(); i++) {
                this.idServicioList.add(listaServicio.get(i)[0].toString());
                this.idServicio[i] = listaServicio.get(i)[0].toString();
                this.JCB_Servicio.addItem(listaServicio.get(i)[1].toString());
            }
            this.JCB_Servicio.setSelectedIndex(-1);
            String idServiciosSeparadosPorComas = String.join(",", this.idServicioList);
            this.xtipo = idServiciosSeparadosPorComas;
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCreaModeloTabla() {
        this.xModelo = new DefaultTableModel(new Object[0], new String[]{"Fecha Ingreso", "Documento", "Usuario", "Edad", "DxP", "Cama", "Ubicacion", "Egreso", "IdIngreso", "IdAtencion", "IdUsuario", "Tipo Atencion", "No Historia", "CSeguimiento", "Convenio", "No Orden", "No Factura", "Total Servicio", "Copago", "C/Moderadora", "Total Eps", "Estado Factura", "Usuario Prefactura", "Cargo", "Motivo", "cerrada", "Motivo Cierre", "Usuario Auditor", "Cargo Auditor"}) { // from class: com.genoma.plus.controller.auditoria_medica.JIFAtencion_Administracion.1
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, Integer.class, Long.class, Long.class, Long.class, String.class, String.class, Boolean.class, String.class, String.class, String.class, Double.class, Double.class, Double.class, Double.class, Integer.class, String.class, String.class, String.class, Boolean.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

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
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(120);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(120);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(120);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(120);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(120);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(12).setPreferredWidth(120);
        this.JTDetalle.getColumnModel().getColumn(13).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(14).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(15).setPreferredWidth(120);
        this.JTDetalle.getColumnModel().getColumn(16).setPreferredWidth(120);
        this.JTDetalle.getColumnModel().getColumn(17).setPreferredWidth(120);
        this.JTDetalle.getColumnModel().getColumn(18).setPreferredWidth(120);
        this.JTDetalle.getColumnModel().getColumn(19).setPreferredWidth(120);
        this.JTDetalle.getColumnModel().getColumn(20).setPreferredWidth(120);
        this.JTDetalle.getColumnModel().getColumn(21).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(22).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(23).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(24).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(25).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(26).setPreferredWidth(350);
        this.JTDetalle.getColumnModel().getColumn(27).setPreferredWidth(300);
    }

    private void mCargarDatosTabla() {
        System.out.println("tipo : " + this.xtipo);
        List<Object[]> filteredList = this.xAuditoriaMedicaDAO.listaAuditoriAdministracion(this.xmt.formatoAMD1.format(this.JDFFechaI.getDate()), this.xmt.formatoAMD1.format(this.JDFFechaF.getDate()), this.xtipo, this.JTF_Filtro.getText(), this.xFiltro, this.xFiltroF, this.JTFNo.getText(), Boolean.valueOf(this.JCH_Prefactura.isSelected()));
        mCreaModeloTabla();
        List<Object[]> list = (List) filteredList.stream().filter(arr -> {
            return !Boolean.valueOf(arr[25].toString()).booleanValue();
        }).collect(Collectors.toList());
        long xNregistro = 0;
        for (int x = 0; x < list.size(); x++) {
            this.xModelo.addRow(this.xdatos);
            this.xModelo.setValueAt(list.get(x)[0], x, 0);
            this.xModelo.setValueAt(list.get(x)[1], x, 1);
            this.xModelo.setValueAt(list.get(x)[2], x, 2);
            this.xModelo.setValueAt(list.get(x)[3], x, 3);
            this.xModelo.setValueAt(list.get(x)[4], x, 4);
            this.xModelo.setValueAt(list.get(x)[5], x, 5);
            this.xModelo.setValueAt(list.get(x)[6], x, 6);
            this.xModelo.setValueAt(list.get(x)[7], x, 7);
            this.xModelo.setValueAt(list.get(x)[8], x, 8);
            this.xModelo.setValueAt(list.get(x)[9], x, 9);
            this.xModelo.setValueAt(list.get(x)[10], x, 10);
            this.xModelo.setValueAt(list.get(x)[11], x, 11);
            this.xModelo.setValueAt(list.get(x)[12], x, 12);
            if (list.get(x)[13].toString().equals("1")) {
                this.xModelo.setValueAt(true, x, 13);
            } else {
                this.xModelo.setValueAt(false, x, 13);
            }
            this.xModelo.setValueAt(list.get(x)[14], x, 14);
            this.xModelo.setValueAt(list.get(x)[15], x, 15);
            this.xModelo.setValueAt(list.get(x)[16], x, 16);
            this.xModelo.setValueAt(list.get(x)[17], x, 17);
            this.xModelo.setValueAt(list.get(x)[18], x, 18);
            this.xModelo.setValueAt(list.get(x)[19], x, 19);
            this.xModelo.setValueAt(list.get(x)[20], x, 20);
            this.xModelo.setValueAt(list.get(x)[21], x, 21);
            this.xModelo.setValueAt(list.get(x)[22], x, 24);
            this.xModelo.setValueAt(list.get(x)[23], x, 22);
            this.xModelo.setValueAt(list.get(x)[24], x, 23);
            this.xModelo.setValueAt(list.get(x)[25], x, 25);
            this.xModelo.setValueAt(list.get(x)[26], x, 26);
            this.xModelo.setValueAt(list.get(x)[27], x, 27);
            this.xModelo.setValueAt(list.get(x)[28], x, 28);
            this.JTDetalle.setDefaultRenderer(Object.class, new MiRender());
            xNregistro++;
        }
        this.JLN_NRegistro.setText("" + xNregistro);
    }

    /* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/auditoria_medica/JIFAtencion_Administracion$MiRender.class */
    public static class MiRender extends DefaultTableCellRenderer {
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            Boolean nvalidacion = Boolean.valueOf(table.getValueAt(row, 13).toString());
            Boolean cerrada = Boolean.valueOf(table.getValueAt(row, 25).toString());
            if (cerrada.booleanValue()) {
                cell.setBackground(Color.CYAN);
                cell.setForeground(Color.BLACK);
            } else if (nvalidacion.booleanValue()) {
                cell.setBackground(Color.GREEN);
                cell.setForeground(Color.BLACK);
            } else {
                cell.setBackground(Color.white);
                cell.setForeground(Color.BLACK);
            }
            return cell;
        }
    }

    /* JADX WARN: Type inference failed for: r3v6, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGFitroAtencion = new ButtonGroup();
        this.JBGFitroFacturacion = new ButtonGroup();
        this.JBGFitroSeguimiento = new ButtonGroup();
        this.JSP_Detalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JPIFiltro = new JPanel();
        this.JLN_NRegistro = new JLabel();
        this.JTF_Filtro = new JTextField();
        this.JPI_FFacturacion = new JPanel();
        this.JRBFF_Todos = new JRadioButton();
        this.JRBFF_Evento = new JRadioButton();
        this.JRBFF_NOrden = new JRadioButton();
        this.JDFFechaI = new JDateChooser();
        this.JDFFechaF = new JDateChooser();
        this.JCB_Servicio = new JComboBox<>();
        this.JCH_Filtro = new JCheckBox();
        this.JCH_Prefactura = new JCheckBox();
        this.JTP_Utilidades = new JTabbedPane();
        this.JPI_Datos1 = new JPanel();
        this.JBTRegistrarSeguimiento = new JButton();
        this.JPIConvenciones = new JPanel();
        this.JCH_CTodos = new JCheckBox();
        this.JCH_SSeguimiento = new JCheckBox();
        this.JCH_CConSeguimiento = new JCheckBox();
        this.JTFNo = new JTextField();
        this.JPI_Datos2 = new JPanel();
        this.JTFRuta = new JTextField();
        this.JBTExportar = new JButton();
        setClosable(true);
        setIconifiable(true);
        setTitle("CONSULTAR ATENCIONES PARA AUDITORIA");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjifAuditoriaMedicaAdmin");
        this.JSP_Detalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(Color.white);
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.auditoria_medica.JIFAtencion_Administracion.2
            public void mouseClicked(MouseEvent evt) {
                JIFAtencion_Administracion.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSP_Detalle.setViewportView(this.JTDetalle);
        this.JPIFiltro.setBorder(BorderFactory.createTitledBorder((Border) null, "FILTROS", 0, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JLN_NRegistro.setFont(new Font("Arial", 1, 14));
        this.JLN_NRegistro.setHorizontalAlignment(0);
        this.JLN_NRegistro.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Registros", 0, 0, new Font("Arial", 1, 14), Color.red));
        this.JTF_Filtro.setFont(new Font("Arial", 1, 12));
        this.JTF_Filtro.setBorder(BorderFactory.createTitledBorder((Border) null, "Filtro por: (Nombre ó Documento de Identidad)", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JPI_FFacturacion.setBorder(BorderFactory.createTitledBorder((Border) null, "FORMA DE FACTURACIÓN", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBGFitroFacturacion.add(this.JRBFF_Todos);
        this.JRBFF_Todos.setFont(new Font("Arial", 1, 12));
        this.JRBFF_Todos.setSelected(true);
        this.JRBFF_Todos.setText("Todos");
        this.JRBFF_Todos.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.auditoria_medica.JIFAtencion_Administracion.3
            public void actionPerformed(ActionEvent evt) {
                JIFAtencion_Administracion.this.JRBFF_TodosActionPerformed(evt);
            }
        });
        this.JBGFitroFacturacion.add(this.JRBFF_Evento);
        this.JRBFF_Evento.setFont(new Font("Arial", 1, 12));
        this.JRBFF_Evento.setText("Orden Servicio");
        this.JRBFF_Evento.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.auditoria_medica.JIFAtencion_Administracion.4
            public void actionPerformed(ActionEvent evt) {
                JIFAtencion_Administracion.this.JRBFF_EventoActionPerformed(evt);
            }
        });
        this.JBGFitroFacturacion.add(this.JRBFF_NOrden);
        this.JRBFF_NOrden.setFont(new Font("Arial", 1, 12));
        this.JRBFF_NOrden.setText("Evento");
        this.JRBFF_NOrden.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.auditoria_medica.JIFAtencion_Administracion.5
            public void actionPerformed(ActionEvent evt) {
                JIFAtencion_Administracion.this.JRBFF_NOrdenActionPerformed(evt);
            }
        });
        GroupLayout JPI_FFacturacionLayout = new GroupLayout(this.JPI_FFacturacion);
        this.JPI_FFacturacion.setLayout(JPI_FFacturacionLayout);
        JPI_FFacturacionLayout.setHorizontalGroup(JPI_FFacturacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_FFacturacionLayout.createSequentialGroup().addContainerGap().addComponent(this.JRBFF_Todos).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBFF_NOrden).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBFF_Evento).addGap(10, 10, 10)));
        JPI_FFacturacionLayout.setVerticalGroup(JPI_FFacturacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_FFacturacionLayout.createSequentialGroup().addContainerGap().addGroup(JPI_FFacturacionLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBFF_Todos).addComponent(this.JRBFF_Evento).addComponent(this.JRBFF_NOrden)).addContainerGap(-1, 32767)));
        this.JDFFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFFechaI.setFont(new Font("Arial", 1, 12));
        this.JDFFechaI.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.auditoria_medica.JIFAtencion_Administracion.6
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFAtencion_Administracion.this.JDFFechaIPropertyChange(evt);
            }
        });
        this.JDFFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Fin", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFFechaF.setFont(new Font("Arial", 1, 12));
        this.JDFFechaF.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.auditoria_medica.JIFAtencion_Administracion.7
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFAtencion_Administracion.this.JDFFechaFPropertyChange(evt);
            }
        });
        this.JCB_Servicio.setFont(new Font("Arial", 1, 12));
        this.JCB_Servicio.setBorder(BorderFactory.createTitledBorder((Border) null, "Servicio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCB_Servicio.addItemListener(new ItemListener() { // from class: com.genoma.plus.controller.auditoria_medica.JIFAtencion_Administracion.8
            public void itemStateChanged(ItemEvent evt) {
                JIFAtencion_Administracion.this.JCB_ServicioItemStateChanged(evt);
            }
        });
        this.JCH_Filtro.setFont(new Font("Arial", 1, 12));
        this.JCH_Filtro.setText("Todos");
        this.JCH_Filtro.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.auditoria_medica.JIFAtencion_Administracion.9
            public void actionPerformed(ActionEvent evt) {
                JIFAtencion_Administracion.this.JCH_FiltroActionPerformed(evt);
            }
        });
        this.JCH_Prefactura.setFont(new Font("Arial", 1, 12));
        this.JCH_Prefactura.setText("Prefcturas?");
        this.JCH_Prefactura.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.auditoria_medica.JIFAtencion_Administracion.10
            public void actionPerformed(ActionEvent evt) {
                JIFAtencion_Administracion.this.JCH_PrefacturaActionPerformed(evt);
            }
        });
        GroupLayout JPIFiltroLayout = new GroupLayout(this.JPIFiltro);
        this.JPIFiltro.setLayout(JPIFiltroLayout);
        JPIFiltroLayout.setHorizontalGroup(JPIFiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIFiltroLayout.createSequentialGroup().addGroup(JPIFiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFiltroLayout.createSequentialGroup().addComponent(this.JDFFechaI, -2, 129, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JDFFechaF, -2, 129, -2)).addGroup(JPIFiltroLayout.createSequentialGroup().addContainerGap().addComponent(this.JCH_Prefactura))).addGroup(JPIFiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFiltroLayout.createSequentialGroup().addGap(12, 12, 12).addComponent(this.JCH_Filtro)).addGroup(JPIFiltroLayout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCB_Servicio, -2, 273, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JPI_FFacturacion, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTF_Filtro, -2, 235, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JLN_NRegistro, -2, 153, -2).addContainerGap()));
        JPIFiltroLayout.setVerticalGroup(JPIFiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFiltroLayout.createSequentialGroup().addGroup(JPIFiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFiltroLayout.createSequentialGroup().addContainerGap().addGroup(JPIFiltroLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JDFFechaI, -2, 50, -2).addComponent(this.JDFFechaF, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JCH_Prefactura)).addGroup(JPIFiltroLayout.createSequentialGroup().addGap(11, 11, 11).addGroup(JPIFiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCB_Servicio, -2, 50, -2).addGroup(JPIFiltroLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JLN_NRegistro, -2, 67, -2).addComponent(this.JTF_Filtro, -2, 67, -2).addComponent(this.JPI_FFacturacion, -2, -1, -2))).addGap(0, 0, 32767))).addContainerGap()).addGroup(GroupLayout.Alignment.TRAILING, JPIFiltroLayout.createSequentialGroup().addGap(68, 68, 68).addComponent(this.JCH_Filtro)));
        this.JTP_Utilidades.setForeground(new Color(0, 103, 0));
        this.JTP_Utilidades.setFont(new Font("Arial", 1, 14));
        this.JBTRegistrarSeguimiento.setFont(new Font("Arial", 1, 12));
        this.JBTRegistrarSeguimiento.setForeground(Color.red);
        this.JBTRegistrarSeguimiento.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Seguimiento_32.png")));
        this.JBTRegistrarSeguimiento.setText("Seguimiento");
        this.JBTRegistrarSeguimiento.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.auditoria_medica.JIFAtencion_Administracion.11
            public void actionPerformed(ActionEvent evt) {
                JIFAtencion_Administracion.this.JBTRegistrarSeguimientoActionPerformed(evt);
            }
        });
        this.JPIConvenciones.setBorder(BorderFactory.createTitledBorder((Border) null, "Convenciones", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JBGFitroSeguimiento.add(this.JCH_CTodos);
        this.JCH_CTodos.setFont(new Font("Arial", 1, 12));
        this.JCH_CTodos.setSelected(true);
        this.JCH_CTodos.setText("Todos");
        this.JCH_CTodos.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.auditoria_medica.JIFAtencion_Administracion.12
            public void actionPerformed(ActionEvent evt) {
                JIFAtencion_Administracion.this.JCH_CTodosActionPerformed(evt);
            }
        });
        this.JCH_SSeguimiento.setBackground(new Color(255, 255, 255));
        this.JBGFitroSeguimiento.add(this.JCH_SSeguimiento);
        this.JCH_SSeguimiento.setFont(new Font("Arial", 1, 12));
        this.JCH_SSeguimiento.setText("Sin Seguimineto");
        this.JCH_SSeguimiento.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.auditoria_medica.JIFAtencion_Administracion.13
            public void actionPerformed(ActionEvent evt) {
                JIFAtencion_Administracion.this.JCH_SSeguimientoActionPerformed(evt);
            }
        });
        this.JCH_CConSeguimiento.setBackground(Color.green);
        this.JBGFitroSeguimiento.add(this.JCH_CConSeguimiento);
        this.JCH_CConSeguimiento.setFont(new Font("Arial", 1, 12));
        this.JCH_CConSeguimiento.setText("Con seguimiento");
        this.JCH_CConSeguimiento.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.auditoria_medica.JIFAtencion_Administracion.14
            public void actionPerformed(ActionEvent evt) {
                JIFAtencion_Administracion.this.JCH_CConSeguimientoActionPerformed(evt);
            }
        });
        GroupLayout JPIConvencionesLayout = new GroupLayout(this.JPIConvenciones);
        this.JPIConvenciones.setLayout(JPIConvencionesLayout);
        JPIConvencionesLayout.setHorizontalGroup(JPIConvencionesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIConvencionesLayout.createSequentialGroup().addContainerGap().addComponent(this.JCH_CTodos).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCH_SSeguimiento).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCH_CConSeguimiento).addContainerGap(-1, 32767)));
        JPIConvencionesLayout.setVerticalGroup(JPIConvencionesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIConvencionesLayout.createSequentialGroup().addGap(0, 5, 32767).addGroup(JPIConvencionesLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCH_SSeguimiento).addComponent(this.JCH_CConSeguimiento).addComponent(this.JCH_CTodos))));
        this.JTFNo.setFont(new Font("Arial", 1, 12));
        this.JTFNo.setBorder(BorderFactory.createTitledBorder((Border) null, "No.", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFNo.setEnabled(false);
        GroupLayout JPI_Datos1Layout = new GroupLayout(this.JPI_Datos1);
        this.JPI_Datos1.setLayout(JPI_Datos1Layout);
        JPI_Datos1Layout.setHorizontalGroup(JPI_Datos1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_Datos1Layout.createSequentialGroup().addGap(18, 18, 18).addComponent(this.JPIConvenciones, -2, -1, -2).addGap(29, 29, 29).addComponent(this.JBTRegistrarSeguimiento, -2, 476, -2).addGap(381, 381, 381)).addGroup(JPI_Datos1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_Datos1Layout.createSequentialGroup().addGap(934, 934, 934).addComponent(this.JTFNo, -2, 194, -2).addContainerGap(129, 32767))));
        JPI_Datos1Layout.setVerticalGroup(JPI_Datos1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_Datos1Layout.createSequentialGroup().addGap(16, 16, 16).addGroup(JPI_Datos1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JPIConvenciones, -2, -1, -2).addComponent(this.JBTRegistrarSeguimiento, -2, 50, -2)).addGap(19, 19, 19)).addGroup(JPI_Datos1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_Datos1Layout.createSequentialGroup().addGap(17, 17, 17).addComponent(this.JTFNo, -2, 50, -2).addContainerGap(18, 32767))));
        this.JTP_Utilidades.addTab("UTILIDAD", this.JPI_Datos1);
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.auditoria_medica.JIFAtencion_Administracion.15
            public void mouseClicked(MouseEvent evt) {
                JIFAtencion_Administracion.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setForeground(Color.red);
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.auditoria_medica.JIFAtencion_Administracion.16
            public void actionPerformed(ActionEvent evt) {
                JIFAtencion_Administracion.this.JBTExportarActionPerformed(evt);
            }
        });
        GroupLayout JPI_Datos2Layout = new GroupLayout(this.JPI_Datos2);
        this.JPI_Datos2.setLayout(JPI_Datos2Layout);
        JPI_Datos2Layout.setHorizontalGroup(JPI_Datos2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPI_Datos2Layout.createSequentialGroup().addGap(677, 677, 677).addComponent(this.JBTExportar, -1, 568, 32767).addContainerGap()).addGroup(JPI_Datos2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_Datos2Layout.createSequentialGroup().addContainerGap().addComponent(this.JTFRuta, -2, 665, -2).addContainerGap(580, 32767))));
        JPI_Datos2Layout.setVerticalGroup(JPI_Datos2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_Datos2Layout.createSequentialGroup().addGap(14, 14, 14).addComponent(this.JBTExportar, -2, 50, -2).addContainerGap(21, 32767)).addGroup(JPI_Datos2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_Datos2Layout.createSequentialGroup().addGap(15, 15, 15).addComponent(this.JTFRuta, -2, 50, -2).addContainerGap(20, 32767))));
        this.JTP_Utilidades.addTab("EXPORTAR", this.JPI_Datos2);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSP_Detalle).addComponent(this.JPIFiltro, -1, -1, 32767).addComponent(this.JTP_Utilidades, GroupLayout.Alignment.TRAILING)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIFiltro, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSP_Detalle, -1, 314, 32767).addGap(18, 18, 18).addComponent(this.JTP_Utilidades, -2, 131, -2).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_CTodosActionPerformed(ActionEvent evt) {
        this.xFiltro = "0,1";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_SSeguimientoActionPerformed(ActionEvent evt) {
        this.xFiltro = "0";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_CConSeguimientoActionPerformed(ActionEvent evt) {
        this.xFiltro = "1";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTRegistrarSeguimientoActionPerformed(ActionEvent evt) {
        cargarPantallaSeguimiento();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTExportarActionPerformed(ActionEvent evt) {
        if (this.JTDetalle.getRowCount() != -1) {
            int x = JOptionPane.showConfirmDialog(this, "Esta seguro de exportar?", "CONFIRMACIÓN", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTDetalle, this.JTFRuta.getText(), getTitle());
            }
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
    public void JRBFF_TodosActionPerformed(ActionEvent evt) {
        this.xFiltroF = "0,1,2";
        this.JTFNo.setEnabled(false);
        this.JTFNo.setText("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBFF_EventoActionPerformed(ActionEvent evt) {
        this.xFiltroF = "0,1";
        this.JTFNo.setEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBFF_NOrdenActionPerformed(ActionEvent evt) {
        this.xFiltroF = "2";
        this.JTFNo.setEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCB_ServicioItemStateChanged(ItemEvent evt) {
        if (this.estadoLlenadoCombo.booleanValue() && this.JCB_Servicio.getSelectedIndex() != -1) {
            this.xtipo = this.idServicio[this.JCB_Servicio.getSelectedIndex()];
            mBuscar();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_FiltroActionPerformed(ActionEvent evt) {
        if (this.JCH_Filtro.isSelected()) {
            this.JCB_Servicio.setSelectedIndex(-1);
            this.JCB_Servicio.setEnabled(false);
            mBuscar();
        } else {
            this.JCB_Servicio.setSelectedIndex(-1);
            this.JCB_Servicio.setEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFFechaIPropertyChange(PropertyChangeEvent evt) {
        if (this.estadoLlenadoCombo.booleanValue()) {
            llenarComboServicio();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFFechaFPropertyChange(PropertyChangeEvent evt) {
        if (this.estadoLlenadoCombo.booleanValue()) {
            llenarComboServicio();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            Object[] botones = {"Cerrar Prefactura", "Cargar Seguimiento", "Cerrar"};
            int y = JOptionPane.showInternalOptionDialog(this, "Que desea hacer", "SELECCIONAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), botones, "Cerrar");
            switch (y) {
                case 0:
                    JDRegistroTrazabilidad trazabilidad = new JDRegistroTrazabilidad(null, true, Long.valueOf(this.xModelo.getValueAt(this.JTDetalle.getSelectedRow(), 8).toString()), "CERRAR PREFACTURA");
                    trazabilidad.setLocationRelativeTo(this);
                    trazabilidad.setVisible(true);
                    break;
                case 1:
                    cargarPantallaSeguimiento();
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_PrefacturaActionPerformed(ActionEvent evt) {
        if (this.JCH_CTodos.isSelected()) {
            llenarComboServicio();
            mCargarDatosTabla();
        }
    }

    private void cargarPantallaSeguimiento() {
        if (this.JTDetalle.getSelectedRow() != -1) {
            try {
                Principal.clasefacturacion.cargarPantalla("Facturación");
                Principal.clasefacturacion.xjiliqServicio.mNuevo();
                Principal.clasefacturacion.xjiliqServicio.xjppersona.txtHistoria.setText(this.xModelo.getValueAt(this.JTDetalle.getSelectedRow(), 12).toString());
                Principal.clasefacturacion.xjiliqServicio.xjppersona.buscar(2);
                Principal.clasefacturacion.xjiliqServicio.setxTipoAuditoria(1);
                Principal.clasefacturacion.xjiliqServicio.JLB_NIngreso.setText(this.xModelo.getValueAt(this.JTDetalle.getSelectedRow(), 8).toString());
                Principal.clasefacturacion.xjiliqServicio.mInicar_Variables_Ingreso(this.xModelo.getValueAt(this.JTDetalle.getSelectedRow(), 8).toString());
                Principal.clasefacturacion.xjiliqServicio.setSelected(true);
                return;
            } catch (PropertyVetoException e) {
                Logger.getLogger(JIFAtencion_Administracion.class.getName()).log(Level.SEVERE, (String) null, e);
                return;
            }
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un registro", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }
}
