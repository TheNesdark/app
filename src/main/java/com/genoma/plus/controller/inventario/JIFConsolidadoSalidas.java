package com.genoma.plus.controller.inventario;

import Acceso.Principal;
import Utilidades.Metodos;
import com.genoma.plus.dao.impl.inventario.ConsolidadoSalidasDAOImpl;
import com.genoma.plus.dao.inventario.ConsolidadoSalidasDAO;
import com.genoma.plus.dto.inventario.ConsolidadoSalidasDTO;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
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
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/inventario/JIFConsolidadoSalidas.class */
public class JIFConsolidadoSalidas extends JInternalFrame {
    private ConsolidadoSalidasDAO xConsolidadoSalidasDAO;
    private DefaultTableModel xModelo1;
    private Object[] xdatos;
    private String[] xidBodega;
    private JButton JBTExportar;
    public JDateChooser JDFechaF;
    public JDateChooser JDFechaI;
    private ButtonGroup JGBFiltro;
    private JPanel JPInformacion;
    private JRadioButton JRBActivos;
    private JRadioButton JRBAnulados;
    private JRadioButton JRBTodos;
    private JScrollPane JSTDetalle;
    private JTable JTDetalle;
    private JTextField JTFRuta;
    private JPanel jPanel1;
    private Metodos xmt = new Metodos();
    private int xtipo = 0;

    public JIFConsolidadoSalidas() {
        initComponents();
        springStart();
        mNuevo();
    }

    private void springStart() {
        this.xConsolidadoSalidasDAO = (ConsolidadoSalidasDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("consolidadoSalidasDAO");
    }

    public void mNuevo() {
        Principal.mLimpiarDatosP();
        this.JDFechaI.setDate(this.xmt.getFechaActual());
        this.JDFechaF.setDate(this.xmt.getFechaActual());
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
        mCreaModeloPaciente();
    }

    public void mBuscar() {
        mCargarDatosPaciente();
    }

    public void mImprimir() {
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCreaModeloPaciente() {
        this.xModelo1 = new DefaultTableModel(new Object[0], new String[]{"Id", "Fecha Salida", "Movimiento", "Destino", "Tipo Destino", "IdDestino", "Estado", "IdDocumentoContable", "Observaciones", "Tipo Producto", "Categoria", "Producto", "Principio Activo", "Concentracion", "Presentacion Comercial", "Fecha Invima", "Laboratorio", "Lote", "Fecha Vencimiento", "Cantidad", "V/Unitario", "V/Total", "Destino Salida", "Fecha Registro", "Usuario Registro"}) { // from class: com.genoma.plus.controller.inventario.JIFConsolidadoSalidas.1
            Class[] types = {Long.class, String.class, String.class, Integer.class, Integer.class, Long.class, String.class, Long.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Integer.class, Double.class, Double.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

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
        this.JTDetalle.setModel(this.xModelo1);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(12).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(13).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(14).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(15).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(16).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(17).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(18).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(19).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(20).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(21).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(22).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(23).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(24).setPreferredWidth(100);
    }

    private void mCargarDatosPaciente() {
        List<ConsolidadoSalidasDTO> list = this.xConsolidadoSalidasDAO.listaConsolidadoSalidas(this.xmt.formatoAMDG.format(this.JDFechaI.getDate()), this.xmt.formatoAMDG.format(this.JDFechaF.getDate()), this.xtipo);
        mCreaModeloPaciente();
        for (int x = 0; x < list.size(); x++) {
            this.xModelo1.addRow(this.xdatos);
            this.xModelo1.setValueAt(list.get(x).getId(), x, 0);
            this.xModelo1.setValueAt(list.get(x).getFechaSalida(), x, 1);
            this.xModelo1.setValueAt(list.get(x).getNMovimiento(), x, 2);
            this.xModelo1.setValueAt(Integer.valueOf(list.get(x).getDestino()), x, 3);
            this.xModelo1.setValueAt(Integer.valueOf(list.get(x).getTipoD()), x, 4);
            this.xModelo1.setValueAt(list.get(x).getIdDestino(), x, 5);
            this.xModelo1.setValueAt(list.get(x).getEstado(), x, 6);
            this.xModelo1.setValueAt(list.get(x).getIdDocContable(), x, 7);
            this.xModelo1.setValueAt(list.get(x).getObservacion(), x, 8);
            this.xModelo1.setValueAt(list.get(x).getNTipoProducto(), x, 9);
            this.xModelo1.setValueAt(list.get(x).getNCategoria(), x, 10);
            this.xModelo1.setValueAt(list.get(x).getNProducto(), x, 11);
            this.xModelo1.setValueAt(list.get(x).getNPActivo(), x, 12);
            this.xModelo1.setValueAt(list.get(x).getNConcentracion(), x, 13);
            this.xModelo1.setValueAt(list.get(x).getNPresentacionComercial(), x, 14);
            this.xModelo1.setValueAt(list.get(x).getFechaVInvima(), x, 15);
            this.xModelo1.setValueAt(list.get(x).getNLaboratorio(), x, 16);
            this.xModelo1.setValueAt(list.get(x).getLote(), x, 17);
            this.xModelo1.setValueAt(list.get(x).getFechaVencimiento(), x, 18);
            this.xModelo1.setValueAt(Integer.valueOf(list.get(x).getCantidad()), x, 19);
            this.xModelo1.setValueAt(list.get(x).getVUnitario(), x, 20);
            this.xModelo1.setValueAt(list.get(x).getVTotal(), x, 21);
            this.xModelo1.setValueAt(list.get(x).getDestinoSalida(), x, 22);
            this.xModelo1.setValueAt(list.get(x).getFechaRegistro(), x, 23);
            this.xModelo1.setValueAt(list.get(x).getUsuarioRegistro(), x, 24);
        }
    }

    /* JADX WARN: Type inference failed for: r3v6, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JGBFiltro = new ButtonGroup();
        this.JSTDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JPInformacion = new JPanel();
        this.JDFechaF = new JDateChooser();
        this.JDFechaI = new JDateChooser();
        this.jPanel1 = new JPanel();
        this.JRBTodos = new JRadioButton();
        this.JRBActivos = new JRadioButton();
        this.JRBAnulados = new JRadioButton();
        this.JTFRuta = new JTextField();
        this.JBTExportar = new JButton();
        setClosable(true);
        setIconifiable(true);
        setTitle("CONSOLIDADO DE SALIDAS");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjifconsolidadosalidas");
        this.JSTDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setSelectionBackground(Color.white);
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JSTDetalle.setViewportView(this.JTDetalle);
        this.JPInformacion.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACION", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JDFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Final", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFechaF.setFont(new Font("Arial", 1, 12));
        this.JDFechaF.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.inventario.JIFConsolidadoSalidas.2
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFConsolidadoSalidas.this.JDFechaFPropertyChange(evt);
            }
        });
        this.JDFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicial", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFechaI.setFont(new Font("Arial", 1, 12));
        this.JDFechaI.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.inventario.JIFConsolidadoSalidas.3
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFConsolidadoSalidas.this.JDFechaIPropertyChange(evt);
            }
        });
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "FILTRAR", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JGBFiltro.add(this.JRBTodos);
        this.JRBTodos.setFont(new Font("Arial", 1, 12));
        this.JRBTodos.setSelected(true);
        this.JRBTodos.setText("Todos");
        this.JRBTodos.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.inventario.JIFConsolidadoSalidas.4
            public void actionPerformed(ActionEvent evt) {
                JIFConsolidadoSalidas.this.JRBTodosActionPerformed(evt);
            }
        });
        this.JGBFiltro.add(this.JRBActivos);
        this.JRBActivos.setFont(new Font("Arial", 1, 12));
        this.JRBActivos.setText("Activos");
        this.JRBActivos.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.inventario.JIFConsolidadoSalidas.5
            public void actionPerformed(ActionEvent evt) {
                JIFConsolidadoSalidas.this.JRBActivosActionPerformed(evt);
            }
        });
        this.JGBFiltro.add(this.JRBAnulados);
        this.JRBAnulados.setFont(new Font("Arial", 1, 12));
        this.JRBAnulados.setText("Anulados");
        this.JRBAnulados.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.inventario.JIFConsolidadoSalidas.6
            public void actionPerformed(ActionEvent evt) {
                JIFConsolidadoSalidas.this.JRBAnuladosActionPerformed(evt);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.JRBTodos).addGap(18, 18, 18).addComponent(this.JRBActivos).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 12, 32767).addComponent(this.JRBAnulados).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(8, 8, 8).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBTodos).addComponent(this.JRBActivos).addComponent(this.JRBAnulados)).addGap(10, 10, 10)));
        GroupLayout JPInformacionLayout = new GroupLayout(this.JPInformacion);
        this.JPInformacion.setLayout(JPInformacionLayout);
        JPInformacionLayout.setHorizontalGroup(JPInformacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPInformacionLayout.createSequentialGroup().addContainerGap().addComponent(this.JDFechaI, -2, 110, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JDFechaF, -2, 110, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jPanel1, -2, -1, -2).addContainerGap(372, 32767)));
        JPInformacionLayout.setVerticalGroup(JPInformacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPInformacionLayout.createSequentialGroup().addGroup(JPInformacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPInformacionLayout.createSequentialGroup().addContainerGap().addGroup(JPInformacionLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JDFechaI, -2, 50, -2).addComponent(this.JDFechaF, -2, 50, -2))).addComponent(this.jPanel1, -2, -1, -2)).addGap(10, 10, 10)));
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ruta", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.inventario.JIFConsolidadoSalidas.7
            public void mouseClicked(MouseEvent evt) {
                JIFConsolidadoSalidas.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.inventario.JIFConsolidadoSalidas.8
            public void actionPerformed(ActionEvent evt) {
                JIFConsolidadoSalidas.this.JBTExportarActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPInformacion, -1, -1, 32767).addComponent(this.JSTDetalle).addGroup(layout.createSequentialGroup().addComponent(this.JTFRuta).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTExportar, -2, 209, -2))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addComponent(this.JPInformacion, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSTDetalle, -2, 361, -2).addGap(10, 10, 10).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JBTExportar, -2, 50, -2).addComponent(this.JTFRuta, -2, 50, -2)).addGap(15, 15, 15)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaFPropertyChange(PropertyChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaIPropertyChange(PropertyChangeEvent evt) {
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
    public void JRBTodosActionPerformed(ActionEvent evt) {
        this.xtipo = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBActivosActionPerformed(ActionEvent evt) {
        this.xtipo = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBAnuladosActionPerformed(ActionEvent evt) {
        this.xtipo = 2;
    }
}
