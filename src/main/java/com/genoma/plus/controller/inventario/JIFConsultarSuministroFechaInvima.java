package com.genoma.plus.controller.inventario;

import Acceso.Principal;
import Utilidades.Metodos;
import com.genoma.plus.jpa.projection.IInformeSuministrosPorFechaInvima;
import com.genoma.plus.jpa.service.IBodegaDAO;
import com.toedter.calendar.JDateChooser;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/inventario/JIFConsultarSuministroFechaInvima.class */
public class JIFConsultarSuministroFechaInvima extends JInternalFrame {
    private DefaultTableModel modelo;
    private Object[] xdatos;
    private List<Integer> filtroEstado;
    private JButton JBTExportar;
    public JDateChooser JDFechaI;
    private ButtonGroup JGBFiltro;
    private JLabel JLB_NRegistro;
    private JPanel JPInformacion;
    private JRadioButton JRBPorVencer180;
    private JRadioButton JRBPorVencer181;
    private JRadioButton JRBTodos;
    private JRadioButton JRBVencidos;
    private JScrollPane JSTDetalle;
    private JTable JTDetalle;
    private JTextField JTFRuta;
    private JPanel jPanel1;
    private Metodos metodo = new Metodos();
    private final IBodegaDAO bodegaDAO = (IBodegaDAO) Principal.contexto.getBean(IBodegaDAO.class);

    public JIFConsultarSuministroFechaInvima() {
        initComponents();
        nuevo();
    }

    public void nuevo() {
        Principal.mLimpiarDatosP();
        this.JDFechaI.setDate(this.metodo.getFechaActual());
        this.JTFRuta.setText(this.metodo.getDirectorioExportacion() + "Planilla");
        this.filtroEstado = new ArrayList();
        this.filtroEstado.add(1);
        this.filtroEstado.add(2);
        this.filtroEstado.add(3);
        crearModelo();
    }

    public void buscar() {
        cargarDatos();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearModelo() {
        this.modelo = new DefaultTableModel(new Object[0], new String[]{"idSuministro", "Código Barra", "Nombre Producto", "Principio Activo", "Concentracion", "Presentacion Comercial", "Registro Invima", "fecha Vencimiento Invima", "Categoria", "Forma Farmaceutica", "Clasificacion", "Tipo Producto", "Laboratorio", "Clasificacion Vencimiento"}) { // from class: com.genoma.plus.controller.inventario.JIFConsultarSuministroFechaInvima.1
            Class[] types = {Long.class, String.class, String.class, String.class, String.class, String.class, String.class, Date.class, String.class, String.class, String.class, String.class, String.class, Integer.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false};

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
        this.JTDetalle.setModel(this.modelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(250);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(12).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(13).setPreferredWidth(100);
    }

    private void cargarDatos() {
        List<IInformeSuministrosPorFechaInvima> list = this.bodegaDAO.listadoSuministrosPorFechaInvima(this.filtroEstado, this.metodo.formatoAMD1.format(this.JDFechaI.getDate()));
        crearModelo();
        int fila = 0;
        for (int x = 0; x < list.size(); x++) {
            this.modelo.addRow(this.xdatos);
            this.modelo.setValueAt(list.get(x).getIdSuministro(), x, 0);
            this.modelo.setValueAt(list.get(x).getCodigoBarra(), x, 1);
            this.modelo.setValueAt(list.get(x).getNombreProducto(), x, 2);
            this.modelo.setValueAt(list.get(x).getNombrePrincipioActivo(), x, 3);
            this.modelo.setValueAt(list.get(x).getNombreConcentracion(), x, 4);
            this.modelo.setValueAt(list.get(x).getNombrePresentacionComercial(), x, 5);
            this.modelo.setValueAt(list.get(x).getRegistroInvima(), x, 6);
            this.modelo.setValueAt(list.get(x).getFechaVecimientoInvima(), x, 7);
            this.modelo.setValueAt(list.get(x).getNombreCategoria(), x, 8);
            this.modelo.setValueAt(list.get(x).getNombreFormaFarmaceutica(), x, 9);
            this.modelo.setValueAt(list.get(x).getNombreClasificacion(), x, 10);
            this.modelo.setValueAt(list.get(x).getNombreTipoProducto(), x, 11);
            this.modelo.setValueAt(list.get(x).getNombreLaboratorio(), x, 12);
            this.modelo.setValueAt(list.get(x).getClasificacionVencimiento(), x, 13);
            this.JTDetalle.setDefaultRenderer(Object.class, new MiRender());
            fila++;
        }
        this.JLB_NRegistro.setText("" + fila);
    }

    /* JADX WARN: Type inference failed for: r3v6, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JGBFiltro = new ButtonGroup();
        this.JSTDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JPInformacion = new JPanel();
        this.JDFechaI = new JDateChooser();
        this.jPanel1 = new JPanel();
        this.JRBTodos = new JRadioButton();
        this.JRBVencidos = new JRadioButton();
        this.JRBPorVencer180 = new JRadioButton();
        this.JRBPorVencer181 = new JRadioButton();
        this.JTFRuta = new JTextField();
        this.JBTExportar = new JButton();
        this.JLB_NRegistro = new JLabel();
        setClosable(true);
        setIconifiable(true);
        setTitle("INFORME SUMINISTRO POR FECHA DE INVIMA");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifSuministrosFechaInvima");
        this.JSTDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTORICO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setSelectionBackground(Color.white);
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JSTDetalle.setViewportView(this.JTDetalle);
        this.JPInformacion.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACION", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JDFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Corte", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFechaI.setFont(new Font("Arial", 1, 12));
        this.JDFechaI.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.inventario.JIFConsultarSuministroFechaInvima.2
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFConsultarSuministroFechaInvima.this.JDFechaIPropertyChange(evt);
            }
        });
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "FILTRAR", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JRBTodos.setBackground(new Color(255, 255, 255));
        this.JGBFiltro.add(this.JRBTodos);
        this.JRBTodos.setFont(new Font("Arial", 1, 12));
        this.JRBTodos.setSelected(true);
        this.JRBTodos.setText("Todos");
        this.JRBTodos.setOpaque(true);
        this.JRBTodos.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.inventario.JIFConsultarSuministroFechaInvima.3
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarSuministroFechaInvima.this.JRBTodosActionPerformed(evt);
            }
        });
        this.JRBVencidos.setBackground(Color.red);
        this.JGBFiltro.add(this.JRBVencidos);
        this.JRBVencidos.setFont(new Font("Arial", 1, 12));
        this.JRBVencidos.setText("Vencidos");
        this.JRBVencidos.setOpaque(true);
        this.JRBVencidos.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.inventario.JIFConsultarSuministroFechaInvima.4
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarSuministroFechaInvima.this.JRBVencidosActionPerformed(evt);
            }
        });
        this.JRBPorVencer180.setBackground(Color.yellow);
        this.JGBFiltro.add(this.JRBPorVencer180);
        this.JRBPorVencer180.setFont(new Font("Arial", 1, 12));
        this.JRBPorVencer180.setText("Por Vencer (<180 días)");
        this.JRBPorVencer180.setOpaque(true);
        this.JRBPorVencer180.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.inventario.JIFConsultarSuministroFechaInvima.5
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarSuministroFechaInvima.this.JRBPorVencer180ActionPerformed(evt);
            }
        });
        this.JRBPorVencer181.setBackground(Color.green);
        this.JGBFiltro.add(this.JRBPorVencer181);
        this.JRBPorVencer181.setFont(new Font("Arial", 1, 12));
        this.JRBPorVencer181.setText("Por Vencer (>180 días)");
        this.JRBPorVencer181.setOpaque(true);
        this.JRBPorVencer181.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.inventario.JIFConsultarSuministroFechaInvima.6
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarSuministroFechaInvima.this.JRBPorVencer181ActionPerformed(evt);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.JRBTodos).addGap(18, 18, 18).addComponent(this.JRBVencidos).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBPorVencer180).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBPorVencer181).addContainerGap(-1, 32767)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(8, 8, 8).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBTodos).addComponent(this.JRBVencidos).addComponent(this.JRBPorVencer180).addComponent(this.JRBPorVencer181)).addGap(10, 10, 10)));
        GroupLayout JPInformacionLayout = new GroupLayout(this.JPInformacion);
        this.JPInformacion.setLayout(JPInformacionLayout);
        JPInformacionLayout.setHorizontalGroup(JPInformacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPInformacionLayout.createSequentialGroup().addContainerGap().addComponent(this.JDFechaI, -2, 110, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jPanel1, -2, -1, -2).addContainerGap(-1, 32767)));
        JPInformacionLayout.setVerticalGroup(JPInformacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPInformacionLayout.createSequentialGroup().addGroup(JPInformacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPInformacionLayout.createSequentialGroup().addContainerGap().addComponent(this.JDFechaI, -2, 50, -2)).addComponent(this.jPanel1, -2, -1, -2)).addGap(10, 10, 10)));
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ruta", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.inventario.JIFConsultarSuministroFechaInvima.7
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarSuministroFechaInvima.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.inventario.JIFConsultarSuministroFechaInvima.8
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarSuministroFechaInvima.this.JBTExportarActionPerformed(evt);
            }
        });
        this.JLB_NRegistro.setFont(new Font("Arial", 1, 14));
        this.JLB_NRegistro.setHorizontalAlignment(0);
        this.JLB_NRegistro.setBorder(BorderFactory.createTitledBorder((Border) null, "No. Registros", 0, 0, new Font("Arial", 1, 14), Color.red));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPInformacion, -1, -1, 32767).addComponent(this.JSTDetalle).addGroup(layout.createSequentialGroup().addComponent(this.JTFRuta, -2, 492, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTExportar, -2, 209, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 211, 32767).addComponent(this.JLB_NRegistro, -2, 138, -2))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addComponent(this.JPInformacion, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSTDetalle, -2, 361, -2).addGap(10, 10, 10).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JBTExportar, -2, 50, -2).addComponent(this.JTFRuta, -2, 50, -2).addComponent(this.JLB_NRegistro, -2, 50, -2)).addGap(15, 15, 15)));
        pack();
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
                this.JTFRuta.setText(xfile.getAbsolutePath() + this.metodo.getBarra());
                this.JTFRuta.requestFocus();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTExportarActionPerformed(ActionEvent evt) {
        if (this.JTDetalle.getRowCount() != -1) {
            int x = JOptionPane.showConfirmDialog(this, "Esta seguro de exportar?", "CONFIRMACIÓN", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                this.metodo.mExportar_Datos_Tabla_Titulo_Formato(this.JTDetalle, this.JTFRuta.getText(), getTitle());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBTodosActionPerformed(ActionEvent evt) {
        this.filtroEstado = new ArrayList();
        this.filtroEstado.add(1);
        this.filtroEstado.add(2);
        this.filtroEstado.add(3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBVencidosActionPerformed(ActionEvent evt) {
        this.filtroEstado = new ArrayList();
        this.filtroEstado.add(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBPorVencer180ActionPerformed(ActionEvent evt) {
        this.filtroEstado = new ArrayList();
        this.filtroEstado.add(2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBPorVencer181ActionPerformed(ActionEvent evt) {
        this.filtroEstado = new ArrayList();
        this.filtroEstado.add(3);
    }

    /* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/inventario/JIFConsultarSuministroFechaInvima$MiRender.class */
    public static class MiRender extends DefaultTableCellRenderer {
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (Integer.valueOf(table.getValueAt(row, 13).toString()).intValue() == 1) {
                cell.setBackground(Color.RED);
                cell.setForeground(Color.BLACK);
            } else if (Integer.valueOf(table.getValueAt(row, 13).toString()).intValue() == 2) {
                cell.setBackground(Color.YELLOW);
                cell.setForeground(Color.BLACK);
            } else if (Integer.valueOf(table.getValueAt(row, 13).toString()).intValue() == 3) {
                cell.setBackground(Color.GREEN);
                cell.setForeground(Color.BLACK);
            } else {
                cell.setBackground(Color.white);
                cell.setForeground(Color.BLACK);
            }
            return cell;
        }
    }
}
