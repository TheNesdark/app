package com.genoma.plus.controller.sig;

import Acceso.Principal;
import Utilidades.Metodos;
import com.genoma.plus.dao.impl.sig.ListaOrdenesInternasDAOImpl;
import com.genoma.plus.dao.sig.ListaOrdenesInternasDAO;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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
import javax.swing.JFormattedTextField;
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

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/sig/JIFListaOrdenesInternas.class */
public class JIFListaOrdenesInternas extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private DefaultTableModel xmodelo2;
    private Object[] xdatos;
    private ListaOrdenesInternasDAO xListaOrdenesInternasDAO;
    private JButton JBTExportar;
    private JDateChooser JDFechaF;
    private JDateChooser JDFechaI;
    private JPanel JPI_Estado;
    private JRadioButton JRB_EActivos;
    private JRadioButton JRB_EAnulados;
    private JRadioButton JRB_ETodos;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;
    private JFormattedTextField JTFF_ValorT;
    private JFormattedTextField JTFNRegistro;
    private JTextField JTFRuta;
    private JTextField JTF_NFactura;
    private ButtonGroup buttonGroup1;
    private JPanel jPanel1;
    private Metodos xmt = new Metodos();
    private boolean xlleno = false;
    private String xEstado = "0";

    public JIFListaOrdenesInternas() {
        initComponents();
        springStart();
        mNuevo();
    }

    private void springStart() {
        this.xListaOrdenesInternasDAO = (ListaOrdenesInternasDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("listaOrdenesInternasDAO");
    }

    public void mNuevo() {
        Principal.mLimpiarDatosP();
        this.JTFNRegistro.setText("0");
        this.JTFF_ValorT.setValue(0);
        this.JDFechaI.setDate(this.xmt.getFechaActual());
        this.JDFechaF.setDate(this.xmt.getFechaActual());
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
        mCrearModeloDatos_1();
        this.JDFechaI.requestFocus();
    }

    public void mBuscar() {
        mCargarDatosTabla();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos_1() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Fecha", "N°", "Historia", "Documento", "Usuario", "Empresa", "Servicio", "Estado", "V/Orden", "Copago", "CModeradora", "V/Total", "F_Evento", "UsuarioS", "Armada", "Concepto Anulación", "Fecha Anulación", "Usuario Anulación", "Observación Anulación", "Id_Ingreso", "Id_CCobro", "Id_Factura", "Id_CC_Cotanble", "NIps", "Regimen", "Sede", "Tipo de Atencion"}) { // from class: com.genoma.plus.controller.sig.JIFListaOrdenesInternas.1
            Class[] types = {String.class, Long.class, String.class, String.class, String.class, String.class, String.class, String.class, Double.class, Double.class, Double.class, Double.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Long.class, Long.class, Long.class, Long.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

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
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(120);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(120);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(120);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(120);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(120);
        this.JTDetalle.getColumnModel().getColumn(12).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(13).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(14).setPreferredWidth(120);
        this.JTDetalle.getColumnModel().getColumn(15).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(15).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(15).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(16).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(16).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(16).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(17).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(17).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(17).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(18).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(18).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(18).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(19).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(20).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(20).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(20).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(21).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(21).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(21).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(22).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(22).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(22).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(23).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(23).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(23).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(24).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(24).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(24).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(25).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(25).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(25).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(26).setPreferredWidth(120);
    }

    private void mCargarDatosTabla() {
        List<Object[]> list = this.xListaOrdenesInternasDAO.ListDetalle(this.xmt.formatoAMD1.format(this.JDFechaI.getDate()), this.xmt.formatoAMD1.format(this.JDFechaF.getDate()), this.JTF_NFactura.getText(), this.xEstado);
        mCrearModeloDatos_1();
        double total = 0.0d;
        for (int x = 0; x < list.size(); x++) {
            this.xmodelo.addRow(this.xdatos);
            this.xmodelo.setValueAt(list.get(x)[0], x, 0);
            this.xmodelo.setValueAt(list.get(x)[1], x, 1);
            this.xmodelo.setValueAt(list.get(x)[2], x, 2);
            this.xmodelo.setValueAt(list.get(x)[3], x, 3);
            this.xmodelo.setValueAt(list.get(x)[4], x, 4);
            this.xmodelo.setValueAt(list.get(x)[5], x, 5);
            this.xmodelo.setValueAt(list.get(x)[6], x, 6);
            this.xmodelo.setValueAt(list.get(x)[7], x, 7);
            this.xmodelo.setValueAt(list.get(x)[8], x, 8);
            this.xmodelo.setValueAt(list.get(x)[9], x, 9);
            this.xmodelo.setValueAt(list.get(x)[10], x, 10);
            this.xmodelo.setValueAt(list.get(x)[11], x, 11);
            this.xmodelo.setValueAt(list.get(x)[12], x, 12);
            this.xmodelo.setValueAt(list.get(x)[13], x, 13);
            this.xmodelo.setValueAt(list.get(x)[14], x, 14);
            this.xmodelo.setValueAt(list.get(x)[15], x, 15);
            this.xmodelo.setValueAt(list.get(x)[16], x, 16);
            this.xmodelo.setValueAt(list.get(x)[17], x, 17);
            this.xmodelo.setValueAt(list.get(x)[18], x, 18);
            this.xmodelo.setValueAt(list.get(x)[19], x, 19);
            this.xmodelo.setValueAt(list.get(x)[20], x, 20);
            this.xmodelo.setValueAt(list.get(x)[21], x, 21);
            this.xmodelo.setValueAt(list.get(x)[22], x, 22);
            this.xmodelo.setValueAt(list.get(x)[23], x, 23);
            this.xmodelo.setValueAt(list.get(x)[24], x, 24);
            this.xmodelo.setValueAt(list.get(x)[25], x, 25);
            this.xmodelo.setValueAt(list.get(x)[26], x, 26);
            total += Double.valueOf(list.get(x)[11].toString()).doubleValue();
        }
        this.JTFF_ValorT.setValue(Double.valueOf(total));
        this.JTFNRegistro.setValue(String.valueOf(list.size()));
    }

    /* JADX WARN: Type inference failed for: r3v6, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.buttonGroup1 = new ButtonGroup();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.jPanel1 = new JPanel();
        this.JTFRuta = new JTextField();
        this.JBTExportar = new JButton();
        this.JDFechaI = new JDateChooser();
        this.JDFechaF = new JDateChooser();
        this.JTFNRegistro = new JFormattedTextField();
        this.JTFF_ValorT = new JFormattedTextField();
        this.JPI_Estado = new JPanel();
        this.JRB_ETodos = new JRadioButton();
        this.JRB_EActivos = new JRadioButton();
        this.JRB_EAnulados = new JRadioButton();
        this.JTF_NFactura = new JTextField();
        setClosable(true);
        setIconifiable(true);
        setTitle("LISTADO DE ORDENES INTERNAS");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjiflistaordenesinternas");
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTORICO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.sig.JIFListaOrdenesInternas.2
            public void mouseClicked(MouseEvent evt) {
                JIFListaOrdenesInternas.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS PARA EXPORTAR", 0, 0, new Font("Arial", 1, 14), Color.red));
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.sig.JIFListaOrdenesInternas.3
            public void mouseClicked(MouseEvent evt) {
                JIFListaOrdenesInternas.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.sig.JIFListaOrdenesInternas.4
            public void actionPerformed(ActionEvent evt) {
                JIFListaOrdenesInternas.this.JBTExportarActionPerformed(evt);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.JTFRuta).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTExportar, -2, 198, -2).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JBTExportar, -2, 50, -2).addComponent(this.JTFRuta, -2, 50, -2)).addGap(0, 16, 32767)));
        this.JDFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicial", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFechaI.setFont(new Font("Arial", 1, 12));
        this.JDFechaI.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.sig.JIFListaOrdenesInternas.5
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFListaOrdenesInternas.this.JDFechaIPropertyChange(evt);
            }
        });
        this.JDFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Final", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFechaF.setFont(new Font("Arial", 1, 12));
        this.JDFechaF.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.sig.JIFListaOrdenesInternas.6
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFListaOrdenesInternas.this.JDFechaFPropertyChange(evt);
            }
        });
        this.JTFNRegistro.setBorder(BorderFactory.createTitledBorder((Border) null, "Nº Registro", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFNRegistro.setHorizontalAlignment(4);
        this.JTFNRegistro.setFont(new Font("Arial", 1, 12));
        this.JTFF_ValorT.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor Total", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFF_ValorT.setHorizontalAlignment(4);
        this.JTFF_ValorT.setFont(new Font("Arial", 1, 12));
        this.JPI_Estado.setBorder(BorderFactory.createTitledBorder((Border) null, "Estado", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.buttonGroup1.add(this.JRB_ETodos);
        this.JRB_ETodos.setFont(new Font("Arial", 1, 12));
        this.JRB_ETodos.setText("Todos");
        this.JRB_ETodos.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.sig.JIFListaOrdenesInternas.7
            public void actionPerformed(ActionEvent evt) {
                JIFListaOrdenesInternas.this.JRB_ETodosActionPerformed(evt);
            }
        });
        this.buttonGroup1.add(this.JRB_EActivos);
        this.JRB_EActivos.setFont(new Font("Arial", 1, 12));
        this.JRB_EActivos.setSelected(true);
        this.JRB_EActivos.setText("Activos");
        this.JRB_EActivos.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.sig.JIFListaOrdenesInternas.8
            public void actionPerformed(ActionEvent evt) {
                JIFListaOrdenesInternas.this.JRB_EActivosActionPerformed(evt);
            }
        });
        this.buttonGroup1.add(this.JRB_EAnulados);
        this.JRB_EAnulados.setFont(new Font("Arial", 1, 12));
        this.JRB_EAnulados.setText("Anulados");
        this.JRB_EAnulados.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.sig.JIFListaOrdenesInternas.9
            public void actionPerformed(ActionEvent evt) {
                JIFListaOrdenesInternas.this.JRB_EAnuladosActionPerformed(evt);
            }
        });
        GroupLayout JPI_EstadoLayout = new GroupLayout(this.JPI_Estado);
        this.JPI_Estado.setLayout(JPI_EstadoLayout);
        JPI_EstadoLayout.setHorizontalGroup(JPI_EstadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_EstadoLayout.createSequentialGroup().addContainerGap().addComponent(this.JRB_ETodos).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRB_EActivos).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRB_EAnulados).addContainerGap(-1, 32767)));
        JPI_EstadoLayout.setVerticalGroup(JPI_EstadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPI_EstadoLayout.createSequentialGroup().addGap(0, 0, 0).addGroup(JPI_EstadoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRB_ETodos).addComponent(this.JRB_EActivos).addComponent(this.JRB_EAnulados)).addGap(0, 0, 0)));
        this.JTF_NFactura.setFont(new Font("Arial", 1, 14));
        this.JTF_NFactura.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Factura", 2, 0, new Font("Arial", 1, 12), Color.red));
        this.JTF_NFactura.addFocusListener(new FocusAdapter() { // from class: com.genoma.plus.controller.sig.JIFListaOrdenesInternas.10
            public void focusLost(FocusEvent evt) {
                JIFListaOrdenesInternas.this.JTF_NFacturaFocusLost(evt);
            }
        });
        this.JTF_NFactura.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.sig.JIFListaOrdenesInternas.11
            public void keyPressed(KeyEvent evt) {
                JIFListaOrdenesInternas.this.JTF_NFacturaKeyPressed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -1, -1, 32767).addGroup(layout.createSequentialGroup().addComponent(this.JDFechaI, -2, 120, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JDFechaF, -2, 120, -2).addGap(18, 18, 18).addComponent(this.JPI_Estado, -2, -1, -2).addGap(17, 17, 17).addComponent(this.JTF_NFactura, -2, 168, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFNRegistro, -2, 119, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFF_ValorT, -2, 122, -2)).addComponent(this.JSPDetalle, GroupLayout.Alignment.TRAILING)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JDFechaF, -1, -1, 32767).addComponent(this.JDFechaI, -2, -1, -2)).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFNRegistro, -2, 50, -2).addComponent(this.JTFF_ValorT, -2, 50, -2).addComponent(this.JTF_NFactura, -2, 50, -2)).addComponent(this.JPI_Estado, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPDetalle, -1, 405, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel1, -2, -1, -2).addGap(10, 10, 10)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1 && evt.getClickCount() == 2) {
            Principal.clasefacturacion.imprimir_FacturayOrden(1, this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString(), this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 19).toString(), Principal.usuarioSistemaDTO.getLogin(), 0, 1, 1);
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
    public void JBTExportarActionPerformed(ActionEvent evt) {
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTDetalle, this.JTFRuta.getText(), getTitle());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaIPropertyChange(PropertyChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaFPropertyChange(PropertyChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_ETodosActionPerformed(ActionEvent evt) {
        this.xEstado = "0,1";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_EActivosActionPerformed(ActionEvent evt) {
        this.xEstado = "0";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_EAnuladosActionPerformed(ActionEvent evt) {
        this.xEstado = "1";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTF_NFacturaFocusLost(FocusEvent evt) {
        mCargarDatosTabla();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTF_NFacturaKeyPressed(KeyEvent evt) {
        int key = evt.getKeyCode();
        if (key == 10) {
            this.JTFNRegistro.requestFocus();
        }
    }
}
