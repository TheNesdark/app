package com.genoma.plus.controller.general;

import Acceso.Principal;
import Utilidades.Metodos;
import com.genoma.plus.jpa.projection.IOdenesCompraContrato;
import com.genoma.plus.jpa.service.ICordenCompraService;
import java.awt.Color;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/general/JIFINgresoFactura.class */
public class JIFINgresoFactura extends JInternalFrame {
    private JDRegistroFactura factura;
    private Object[] datos;
    private DefaultTableModel modelo;
    private List<Integer> filtro;
    private JButton JBTExportar;
    private JPanel JPDatos;
    private JPanel JPDatosB;
    public JRadioButton JRB_Service;
    public JRadioButton JRB_Todos;
    public JRadioButton JRB_contato;
    private JScrollPane JSPResultado2;
    private JTextField JTFRuta;
    private JTextField JTFTercero;
    public JTable JTResultado;
    private ButtonGroup buttonGroup1;
    private JPanel jPanel1;
    private final ICordenCompraService CordenCompra = (ICordenCompraService) Principal.contexto.getBean(ICordenCompraService.class);
    private Metodos metodos = new Metodos();

    public JIFINgresoFactura() {
        initComponents();
        this.filtro = new ArrayList();
        this.filtro.add(3);
        cargarPedidoPorId(this.filtro, "");
        this.JTFRuta.setText(this.metodos.getDirectorioExportacion() + "Planilla");
    }

    /* JADX WARN: Type inference failed for: r3v20, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.buttonGroup1 = new ButtonGroup();
        this.JPDatos = new JPanel();
        this.jPanel1 = new JPanel();
        this.JRB_contato = new JRadioButton();
        this.JRB_Todos = new JRadioButton();
        this.JRB_Service = new JRadioButton();
        this.JSPResultado2 = new JScrollPane();
        this.JTResultado = new JTable();
        this.JPDatosB = new JPanel();
        this.JTFTercero = new JTextField();
        this.JBTExportar = new JButton();
        this.JTFRuta = new JTextField();
        setClosable(true);
        setIconifiable(true);
        setTitle("REGISTRAR FACTURAS");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("JIFConsultaOrdenesCompra");
        this.JPDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "FILTRO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo ", 0, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.jPanel1.setLayout((LayoutManager) null);
        this.buttonGroup1.add(this.JRB_contato);
        this.JRB_contato.setFont(new Font("Arial", 1, 12));
        this.JRB_contato.setForeground(new Color(0, 0, 255));
        this.JRB_contato.setSelected(true);
        this.JRB_contato.setText("Contrato");
        this.JRB_contato.setName("");
        this.JRB_contato.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.general.JIFINgresoFactura.1
            public void actionPerformed(ActionEvent evt) {
                JIFINgresoFactura.this.JRB_contatoActionPerformed(evt);
            }
        });
        this.jPanel1.add(this.JRB_contato);
        this.JRB_contato.setBounds(10, 20, 90, 19);
        this.buttonGroup1.add(this.JRB_Todos);
        this.JRB_Todos.setFont(new Font("Arial", 1, 12));
        this.JRB_Todos.setForeground(new Color(0, 0, 255));
        this.JRB_Todos.setText("Todos");
        this.JRB_Todos.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.general.JIFINgresoFactura.2
            public void actionPerformed(ActionEvent evt) {
                JIFINgresoFactura.this.JRB_TodosActionPerformed(evt);
            }
        });
        this.jPanel1.add(this.JRB_Todos);
        this.JRB_Todos.setBounds(10, 60, 90, 19);
        this.buttonGroup1.add(this.JRB_Service);
        this.JRB_Service.setFont(new Font("Arial", 1, 12));
        this.JRB_Service.setForeground(new Color(0, 0, 255));
        this.JRB_Service.setText("Servicio");
        this.JRB_Service.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.general.JIFINgresoFactura.3
            public void actionPerformed(ActionEvent evt) {
                JIFINgresoFactura.this.JRB_ServiceActionPerformed(evt);
            }
        });
        this.jPanel1.add(this.JRB_Service);
        this.JRB_Service.setBounds(10, 40, 110, 19);
        this.JSPResultado2.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTResultado.setBorder(BorderFactory.createBevelBorder(0));
        this.JTResultado.setFont(new Font("Arial", 1, 12));
        this.JTResultado.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTResultado.setEditingColumn(1);
        this.JTResultado.setEditingRow(1);
        this.JTResultado.setGridColor(new Color(204, 204, 204));
        this.JTResultado.setRowHeight(25);
        this.JTResultado.setSelectionBackground(new Color(255, 255, 255));
        this.JTResultado.setSelectionForeground(new Color(255, 0, 0));
        this.JTResultado.setSelectionMode(0);
        this.JTResultado.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.general.JIFINgresoFactura.4
            public void mouseClicked(MouseEvent evt) {
                JIFINgresoFactura.this.JTResultadoMouseClicked(evt);
            }
        });
        this.JTResultado.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.general.JIFINgresoFactura.5
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFINgresoFactura.this.JTResultadoPropertyChange(evt);
            }
        });
        this.JTResultado.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.general.JIFINgresoFactura.6
            public void keyPressed(KeyEvent evt) {
                JIFINgresoFactura.this.JTResultadoKeyPressed(evt);
            }
        });
        this.JSPResultado2.setViewportView(this.JTResultado);
        this.JPDatosB.setBorder(BorderFactory.createTitledBorder((Border) null, "FILTRO", 0, 0, new Font("Arial", 1, 14), Color.red));
        this.JTFTercero.setFont(new Font("Arial", 1, 12));
        this.JTFTercero.setHorizontalAlignment(2);
        this.JTFTercero.setBorder(BorderFactory.createTitledBorder((Border) null, "Tercero", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFTercero.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.general.JIFINgresoFactura.7
            public void keyPressed(KeyEvent evt) {
                JIFINgresoFactura.this.JTFTerceroKeyPressed(evt);
            }
        });
        GroupLayout JPDatosBLayout = new GroupLayout(this.JPDatosB);
        this.JPDatosB.setLayout(JPDatosBLayout);
        JPDatosBLayout.setHorizontalGroup(JPDatosBLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosBLayout.createSequentialGroup().addContainerGap().addComponent(this.JTFTercero).addContainerGap()));
        JPDatosBLayout.setVerticalGroup(JPDatosBLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosBLayout.createSequentialGroup().addComponent(this.JTFTercero, -2, -1, -2).addContainerGap(-1, 32767)));
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setForeground(Color.red);
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.general.JIFINgresoFactura.8
            public void actionPerformed(ActionEvent evt) {
                JIFINgresoFactura.this.JBTExportarActionPerformed(evt);
            }
        });
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.general.JIFINgresoFactura.9
            public void mouseClicked(MouseEvent evt) {
                JIFINgresoFactura.this.JTFRutaMouseClicked(evt);
            }
        });
        GroupLayout JPDatosLayout = new GroupLayout(this.JPDatos);
        this.JPDatos.setLayout(JPDatosLayout);
        JPDatosLayout.setHorizontalGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosLayout.createSequentialGroup().addGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPDatosLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPResultado2)).addGroup(JPDatosLayout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.jPanel1, -2, 118, -2).addGap(18, 18, 18).addComponent(this.JPDatosB, -1, -1, 32767))).addContainerGap()).addGroup(GroupLayout.Alignment.TRAILING, JPDatosLayout.createSequentialGroup().addComponent(this.JTFRuta, -2, 637, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTExportar, -2, 268, -2).addGap(0, 0, 32767)));
        JPDatosLayout.setVerticalGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosLayout.createSequentialGroup().addGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosLayout.createSequentialGroup().addContainerGap().addComponent(this.JPDatosB, -2, -1, -2)).addComponent(this.jPanel1, -2, 90, -2)).addGap(18, 18, 18).addComponent(this.JSPResultado2, -2, 242, -2).addGap(28, 28, 28).addGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JBTExportar, -1, 50, 32767).addComponent(this.JTFRuta)).addContainerGap()));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addComponent(this.JPDatos, -1, -1, 32767).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPDatos, -1, -1, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTResultadoPropertyChange(PropertyChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTResultadoKeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_contatoActionPerformed(ActionEvent evt) {
        this.filtro = new ArrayList();
        this.filtro.add(3);
        cargarPedidoPorId(this.filtro, this.JTFTercero.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_ServiceActionPerformed(ActionEvent evt) {
        this.filtro = new ArrayList();
        this.filtro.add(2);
        cargarPedidoPorId(this.filtro, this.JTFTercero.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_TodosActionPerformed(ActionEvent evt) {
        this.filtro = new ArrayList();
        this.filtro.add(2);
        this.filtro.add(3);
        cargarPedidoPorId(this.filtro, this.JTFTercero.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTResultadoMouseClicked(MouseEvent evt) {
        if (this.JTResultado.getSelectedRow() != -1) {
            JDRegistroFactura factura = new JDRegistroFactura(null, true, Long.valueOf(this.JTResultado.getValueAt(this.JTResultado.getSelectedRow(), 0).toString()), Double.valueOf(this.JTResultado.getValueAt(this.JTResultado.getSelectedRow(), 8).toString()));
            factura.setLocationRelativeTo(this);
            factura.setVisible(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFTerceroKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10 || evt.getKeyCode() == 18) {
            cargarPedidoPorId(this.filtro, this.JTFTercero.getText());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTExportarActionPerformed(ActionEvent evt) {
        if (!this.JTFRuta.getText().isEmpty()) {
            if (this.JTResultado.getRowCount() > -1) {
                int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (n == 0) {
                    this.metodos.mExportar_Datos_Tabla_Titulo_Formato(this.JTResultado, this.metodos.mTraerUrlBD(this.JTFRuta.getText()), getTitle());
                    return;
                }
                return;
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un ruta valida", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        this.JTFRuta.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JFileChooser xfilec = new JFileChooser(this.JTFRuta.getText());
            xfilec.setFileSelectionMode(1);
            int xv = xfilec.showOpenDialog(this);
            if (xv == 0) {
                File xfile = xfilec.getSelectedFile();
                this.JTFRuta.setText(xfile.getAbsolutePath() + this.metodos.getBarra());
                this.JTFRuta.requestFocus();
            }
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearModeloOrdenCompra() {
        this.modelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Fecha Orden", "Consecutivo", "Tipo Documento", "Documento", "Tercero", "ValorOrden", "ValorFacturas", "Saldo"}) { // from class: com.genoma.plus.controller.general.JIFINgresoFactura.10
            Class[] types = {Long.class, Date.class, String.class, String.class, String.class, String.class, Double.class, Double.class, Double.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTResultado;
        JTable jTable2 = this.JTResultado;
        jTable.setAutoResizeMode(0);
        this.JTResultado.doLayout();
        this.JTResultado.setModel(this.modelo);
        this.JTResultado.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTResultado.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTResultado.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTResultado.getColumnModel().getColumn(3).setPreferredWidth(200);
        this.JTResultado.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTResultado.getColumnModel().getColumn(5).setPreferredWidth(300);
        this.JTResultado.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTResultado.getColumnModel().getColumn(7).setPreferredWidth(100);
        this.JTResultado.getColumnModel().getColumn(8).setPreferredWidth(100);
    }

    public void cargarPedidoPorId(List<Integer> tipo, String filtroEmpresa) {
        crearModeloOrdenCompra();
        List<IOdenesCompraContrato> e = this.CordenCompra.ListaOrdenesDeCompra(tipo, filtroEmpresa);
        System.out.println("entra al metodo" + e.size());
        if (e != null && !e.isEmpty()) {
            e.forEach(detalle -> {
                this.modelo.addRow(this.datos);
                this.JTResultado.setValueAt(detalle.getId(), this.JTResultado.getRowCount() - 1, 0);
                this.JTResultado.setValueAt(detalle.getFechaOrden(), this.JTResultado.getRowCount() - 1, 1);
                this.JTResultado.setValueAt(detalle.getConsecutivo(), this.JTResultado.getRowCount() - 1, 2);
                this.JTResultado.setValueAt(detalle.getTipoDocumento(), this.JTResultado.getRowCount() - 1, 3);
                this.JTResultado.setValueAt(detalle.getDocumento(), this.JTResultado.getRowCount() - 1, 4);
                this.JTResultado.setValueAt(detalle.getTercero(), this.JTResultado.getRowCount() - 1, 5);
                this.JTResultado.setValueAt(detalle.getValorOrden(), this.JTResultado.getRowCount() - 1, 6);
                this.JTResultado.setValueAt(detalle.getValorFacturas(), this.JTResultado.getRowCount() - 1, 7);
                this.JTResultado.setValueAt(detalle.getValorSaldo(), this.JTResultado.getRowCount() - 1, 8);
            });
        }
    }
}
