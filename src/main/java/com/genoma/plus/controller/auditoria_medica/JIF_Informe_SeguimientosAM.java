package com.genoma.plus.controller.auditoria_medica;

import Utilidades.Metodos;
import com.genoma.plus.dao.auditoria_medica.AuditoriaMedicaDAO;
import com.genoma.plus.dao.impl.auditoria_medica.AuditoriaMedicaDAOImpl;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/auditoria_medica/JIF_Informe_SeguimientosAM.class */
public class JIF_Informe_SeguimientosAM extends JInternalFrame {
    private AuditoriaMedicaDAO xAuditoriaMedicaDAO;
    private DefaultTableModel xModelo;
    private Object[] xdatos;
    private ButtonGroup JBG_Convenciones;
    private ButtonGroup JBG_Filtro;
    private JButton JBTExportar;
    private JCheckBox JCH_CTodos;
    private JCheckBox JCH_Cerrar;
    private JCheckBox JCH_PorCerrar;
    private JDateChooser JDFechaF;
    private JDateChooser JDFechaI;
    private JLabel JLN_NRegistro;
    private JPanel JPIConvenciones;
    private JPanel JPIFiltro;
    private JPanel JPI_Datos1;
    private JPanel JPI_Datos2;
    private JScrollPane JSP_Detalle;
    private JTable JTDetalle;
    private JTextField JTFRuta;
    private JTabbedPane JTP_Utilidades;
    private Metodos xmt = new Metodos();
    private String xFiltro = "0,1";

    public JIF_Informe_SeguimientosAM() {
        initComponents();
        springStart();
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v27, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBG_Filtro = new ButtonGroup();
        this.JBG_Convenciones = new ButtonGroup();
        this.JPIFiltro = new JPanel();
        this.JLN_NRegistro = new JLabel();
        this.JDFechaI = new JDateChooser();
        this.JDFechaF = new JDateChooser();
        this.JSP_Detalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JTP_Utilidades = new JTabbedPane();
        this.JPI_Datos1 = new JPanel();
        this.JPIConvenciones = new JPanel();
        this.JCH_CTodos = new JCheckBox();
        this.JCH_PorCerrar = new JCheckBox();
        this.JCH_Cerrar = new JCheckBox();
        this.JPI_Datos2 = new JPanel();
        this.JTFRuta = new JTextField();
        this.JBTExportar = new JButton();
        setClosable(true);
        setIconifiable(true);
        setTitle("INFORME DE SEGUIMIENTOS");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjif_InformeSeguimentosAM");
        this.JPIFiltro.setBorder(BorderFactory.createTitledBorder((Border) null, "FILTROS", 0, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JLN_NRegistro.setFont(new Font("Arial", 1, 14));
        this.JLN_NRegistro.setHorizontalAlignment(0);
        this.JLN_NRegistro.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Registros", 0, 0, new Font("Arial", 1, 14), Color.red));
        this.JDFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFechaI.setFont(new Font("Arial", 1, 12));
        this.JDFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Fin", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFechaF.setFont(new Font("Arial", 1, 12));
        GroupLayout JPIFiltroLayout = new GroupLayout(this.JPIFiltro);
        this.JPIFiltro.setLayout(JPIFiltroLayout);
        JPIFiltroLayout.setHorizontalGroup(JPIFiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFiltroLayout.createSequentialGroup().addGap(16, 16, 16).addComponent(this.JDFechaI, -2, 136, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JDFechaF, -2, 136, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JLN_NRegistro, -2, 153, -2).addContainerGap()));
        JPIFiltroLayout.setVerticalGroup(JPIFiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFiltroLayout.createSequentialGroup().addContainerGap().addGroup(JPIFiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFiltroLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JDFechaI, -2, 56, -2).addComponent(this.JDFechaF, -2, 56, -2)).addComponent(this.JLN_NRegistro, -2, 57, -2)).addContainerGap(-1, 32767)));
        this.JSP_Detalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(Color.white);
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JSP_Detalle.setViewportView(this.JTDetalle);
        this.JTP_Utilidades.setForeground(new Color(0, 103, 0));
        this.JTP_Utilidades.setFont(new Font("Arial", 1, 14));
        this.JPIConvenciones.setBorder(BorderFactory.createTitledBorder((Border) null, "Convenciones", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JBG_Convenciones.add(this.JCH_CTodos);
        this.JCH_CTodos.setFont(new Font("Arial", 1, 12));
        this.JCH_CTodos.setText("Todos");
        this.JCH_CTodos.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.auditoria_medica.JIF_Informe_SeguimientosAM.1
            public void actionPerformed(ActionEvent evt) {
                JIF_Informe_SeguimientosAM.this.JCH_CTodosActionPerformed(evt);
            }
        });
        this.JCH_PorCerrar.setBackground(new Color(255, 255, 255));
        this.JBG_Convenciones.add(this.JCH_PorCerrar);
        this.JCH_PorCerrar.setFont(new Font("Arial", 1, 12));
        this.JCH_PorCerrar.setText("Por Cerrar");
        this.JCH_PorCerrar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.auditoria_medica.JIF_Informe_SeguimientosAM.2
            public void actionPerformed(ActionEvent evt) {
                JIF_Informe_SeguimientosAM.this.JCH_PorCerrarActionPerformed(evt);
            }
        });
        this.JCH_Cerrar.setBackground(Color.cyan);
        this.JBG_Convenciones.add(this.JCH_Cerrar);
        this.JCH_Cerrar.setFont(new Font("Arial", 1, 12));
        this.JCH_Cerrar.setSelected(true);
        this.JCH_Cerrar.setText("Cerrado");
        this.JCH_Cerrar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.auditoria_medica.JIF_Informe_SeguimientosAM.3
            public void actionPerformed(ActionEvent evt) {
                JIF_Informe_SeguimientosAM.this.JCH_CerrarActionPerformed(evt);
            }
        });
        GroupLayout JPIConvencionesLayout = new GroupLayout(this.JPIConvenciones);
        this.JPIConvenciones.setLayout(JPIConvencionesLayout);
        JPIConvencionesLayout.setHorizontalGroup(JPIConvencionesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIConvencionesLayout.createSequentialGroup().addContainerGap().addComponent(this.JCH_CTodos).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCH_PorCerrar).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCH_Cerrar).addContainerGap(-1, 32767)));
        JPIConvencionesLayout.setVerticalGroup(JPIConvencionesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIConvencionesLayout.createSequentialGroup().addContainerGap(-1, 32767).addGroup(JPIConvencionesLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCH_PorCerrar).addComponent(this.JCH_Cerrar).addComponent(this.JCH_CTodos)).addContainerGap()));
        GroupLayout JPI_Datos1Layout = new GroupLayout(this.JPI_Datos1);
        this.JPI_Datos1.setLayout(JPI_Datos1Layout);
        JPI_Datos1Layout.setHorizontalGroup(JPI_Datos1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_Datos1Layout.createSequentialGroup().addContainerGap().addComponent(this.JPIConvenciones, -2, -1, -2).addContainerGap(754, 32767)));
        JPI_Datos1Layout.setVerticalGroup(JPI_Datos1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_Datos1Layout.createSequentialGroup().addGap(15, 15, 15).addComponent(this.JPIConvenciones, -2, -1, -2).addContainerGap(13, 32767)));
        this.JTP_Utilidades.addTab("UTILIDAD", this.JPI_Datos1);
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.auditoria_medica.JIF_Informe_SeguimientosAM.4
            public void mouseClicked(MouseEvent evt) {
                JIF_Informe_SeguimientosAM.this.JTFRutaMouseClicked(evt);
            }

            public void mouseEntered(MouseEvent evt) {
                JIF_Informe_SeguimientosAM.this.JTFRutaMouseEntered(evt);
            }
        });
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setForeground(Color.red);
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.auditoria_medica.JIF_Informe_SeguimientosAM.5
            public void actionPerformed(ActionEvent evt) {
                JIF_Informe_SeguimientosAM.this.JBTExportarActionPerformed(evt);
            }
        });
        GroupLayout JPI_Datos2Layout = new GroupLayout(this.JPI_Datos2);
        this.JPI_Datos2.setLayout(JPI_Datos2Layout);
        JPI_Datos2Layout.setHorizontalGroup(JPI_Datos2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_Datos2Layout.createSequentialGroup().addContainerGap().addComponent(this.JTFRuta, -2, 419, -2).addGap(18, 18, 18).addComponent(this.JBTExportar, -2, 264, -2).addContainerGap(334, 32767)));
        JPI_Datos2Layout.setVerticalGroup(JPI_Datos2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_Datos2Layout.createSequentialGroup().addGap(15, 15, 15).addGroup(JPI_Datos2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JBTExportar, -2, 50, -2).addComponent(this.JTFRuta, -2, 50, -2)).addContainerGap(20, 32767)));
        this.JTP_Utilidades.addTab("EXPORTAR", this.JPI_Datos2);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTP_Utilidades).addComponent(this.JPIFiltro, -1, -1, 32767).addComponent(this.JSP_Detalle)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIFiltro, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSP_Detalle, -2, 375, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTP_Utilidades, -2, 131, -2).addContainerGap(-1, 32767)));
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
        if (this.JTDetalle.getRowCount() != -1) {
            int x = JOptionPane.showConfirmDialog(this, "Esta seguro de exportar?", "CONFIRMACIÓN", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTDetalle, this.JTFRuta.getText(), getTitle());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_CTodosActionPerformed(ActionEvent evt) {
        this.xFiltro = "0,1";
        mBuscar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_PorCerrarActionPerformed(ActionEvent evt) {
        this.xFiltro = "0";
        mBuscar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_CerrarActionPerformed(ActionEvent evt) {
        this.xFiltro = "1";
        mBuscar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaMouseEntered(MouseEvent evt) {
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCreaModeloTabla() {
        this.xModelo = new DefaultTableModel(new Object[0], new String[]{"Fecha", "Documento", "Usuario", "Edad", "Sexo", "FechaS", "TipoSeguimiento", "Detalle Seguimiento", "Diagnóstico Principal", "Cama", "Ubicación", "Tipo de Atención", "Convenio", "Norden", "N° Factura", "Total Servicio", "Copago", "CModeradora", "Total Eps", "Cargo", "Responsable", "CSeguimiento", "Cargo_Registra", "Responsable_Registro"}) { // from class: com.genoma.plus.controller.auditoria_medica.JIF_Informe_SeguimientosAM.6
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Double.class, Double.class, Double.class, Double.class, String.class, String.class, Boolean.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

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
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(12).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(13).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(14).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(15).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(16).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(17).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(18).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(19).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(20).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(21).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(21).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(21).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(22).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(23).setPreferredWidth(300);
    }

    private void mCargarDatosTabla() {
        List<Object[]> list = this.xAuditoriaMedicaDAO.listaInformeSeguimientos(this.xmt.formatoAMD1.format(this.JDFechaI.getDate()), this.xmt.formatoAMD1.format(this.JDFechaF.getDate()), this.xFiltro);
        mCreaModeloTabla();
        this.xmt.mEstablecerTextEditor(this.JTDetalle, 2);
        this.xmt.mEstablecerTextEditor(this.JTDetalle, 7);
        this.xmt.mEstablecerTextEditor(this.JTDetalle, 8);
        this.xmt.mEstablecerTextEditor(this.JTDetalle, 19);
        this.xmt.mEstablecerTextEditor(this.JTDetalle, 20);
        long xNregistro = 0;
        for (int x = 0; x < list.size(); x++) {
            this.xModelo.addRow(this.xdatos);
            for (int y = 0; y < this.JTDetalle.getColumnCount(); y++) {
                this.xModelo.setValueAt(list.get(x)[y], x, y);
            }
            this.JTDetalle.setDefaultRenderer(Object.class, new MiRender());
            xNregistro++;
        }
        this.JLN_NRegistro.setText("" + xNregistro);
    }

    private void springStart() {
        this.xAuditoriaMedicaDAO = (AuditoriaMedicaDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("auditoriaMedicaDAO");
    }

    public void mBuscar() {
        mCargarDatosTabla();
    }

    public void mNuevo() {
        this.JDFechaI.setDate(this.xmt.getFechaActual());
        this.JDFechaF.setDate(this.xmt.getFechaActual());
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
        this.xFiltro = "0,1";
        this.JCH_CTodos.setSelected(true);
        mCreaModeloTabla();
    }

    /* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/auditoria_medica/JIF_Informe_SeguimientosAM$MiRender.class */
    public static class MiRender extends DefaultTableCellRenderer {
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            Boolean nvalidacion = Boolean.valueOf(table.getValueAt(row, 21).toString());
            if (nvalidacion.booleanValue()) {
                cell.setBackground(Color.CYAN);
                cell.setForeground(Color.BLACK);
            } else {
                cell.setBackground(Color.white);
                cell.setForeground(Color.BLACK);
            }
            return cell;
        }
    }
}
