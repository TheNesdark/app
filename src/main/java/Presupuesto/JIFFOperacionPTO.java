package Presupuesto;

import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

/* JADX INFO: loaded from: GenomaP.jar:Presupuesto/JIFFOperacionPTO.class */
public class JIFFOperacionPTO extends JInternalFrame {
    private Metodos xmt = new Metodos();
    private ConsultasMySQL xct = new ConsultasMySQL();
    private JButton JBAdicionar;
    private JButton JBBuscar;
    private JComboBox JCBRubros;
    private JComboBox JCBTipoDocumento;
    private JFormattedTextField JFTFValor;
    public JLabel JLCodigoDoc;
    private JLabel JLDisponible;
    public JTable JTDetalle;
    private JTextField JTFCodigoRbro;
    private JTextField JTFObservacion;
    public JTextArea JTObservacion;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    public JDateChooser txtFecha;

    public JIFFOperacionPTO() {
        initComponents();
    }

    /* JADX WARN: Type inference failed for: r3v74, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jPanel1 = new JPanel();
        this.JCBTipoDocumento = new JComboBox();
        this.txtFecha = new JDateChooser("dd/MM/yyyy", "##/##/####", '_');
        this.jScrollPane1 = new JScrollPane();
        this.JTObservacion = new JTextArea();
        this.JBBuscar = new JButton();
        this.JLCodigoDoc = new JLabel();
        this.jPanel2 = new JPanel();
        this.JCBRubros = new JComboBox();
        this.JTFCodigoRbro = new JTextField();
        this.JFTFValor = new JFormattedTextField();
        this.JBAdicionar = new JButton();
        this.JTFObservacion = new JTextField();
        this.JLDisponible = new JLabel();
        this.jScrollPane2 = new JScrollPane();
        this.JTDetalle = new JTable();
        setTitle("OPERACIONES PRESUPUESTO");
        setToolTipText("");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JCBTipoDocumento.setFont(new Font("Arial", 1, 12));
        this.JCBTipoDocumento.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo de Documento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTipoDocumento.addItemListener(new ItemListener() { // from class: Presupuesto.JIFFOperacionPTO.1
            public void itemStateChanged(ItemEvent evt) {
                JIFFOperacionPTO.this.JCBTipoDocumentoItemStateChanged(evt);
            }
        });
        this.txtFecha.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.txtFecha.setDateFormatString("dd/MM/yyyy");
        this.txtFecha.setFont(new Font("Tahoma", 1, 12));
        this.txtFecha.addKeyListener(new KeyAdapter() { // from class: Presupuesto.JIFFOperacionPTO.2
            public void keyPressed(KeyEvent evt) {
                JIFFOperacionPTO.this.txtFechaKeyPressed(evt);
            }
        });
        this.JTObservacion.setColumns(1);
        this.JTObservacion.setFont(new Font("Arial", 1, 12));
        this.JTObservacion.setLineWrap(true);
        this.JTObservacion.setRows(1);
        this.JTObservacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Objeto", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jScrollPane1.setViewportView(this.JTObservacion);
        this.JBBuscar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/factura.png")));
        this.JBBuscar.setToolTipText("Adjuntar Documento");
        this.JBBuscar.addActionListener(new ActionListener() { // from class: Presupuesto.JIFFOperacionPTO.3
            public void actionPerformed(ActionEvent evt) {
                JIFFOperacionPTO.this.JBBuscarActionPerformed(evt);
            }
        });
        this.JLCodigoDoc.setFont(new Font("Tahoma", 1, 14));
        this.JLCodigoDoc.setForeground(Color.red);
        this.JLCodigoDoc.setHorizontalAlignment(0);
        this.JLCodigoDoc.setBorder(BorderFactory.createTitledBorder((Border) null, "Cód. Documento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.txtFecha, -2, 130, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBTipoDocumento, 0, 420, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JLCodigoDoc, -2, 125, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBBuscar, -2, 51, -2)).addComponent(this.jScrollPane1)).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.txtFecha, -1, 50, 32767).addComponent(this.JCBTipoDocumento).addComponent(this.JBBuscar, -1, -1, 32767).addComponent(this.JLCodigoDoc, -1, -1, 32767)).addGap(5, 5, 5).addComponent(this.jScrollPane1, -2, 63, -2).addContainerGap(-1, 32767)));
        this.jPanel2.setBorder(BorderFactory.createTitledBorder((Border) null, "RUBROS", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JCBRubros.setFont(new Font("Arial", 1, 12));
        this.JCBRubros.setBorder(BorderFactory.createTitledBorder((Border) null, "Rubros", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBRubros.addItemListener(new ItemListener() { // from class: Presupuesto.JIFFOperacionPTO.4
            public void itemStateChanged(ItemEvent evt) {
                JIFFOperacionPTO.this.JCBRubrosItemStateChanged(evt);
            }
        });
        this.JTFCodigoRbro.setFont(new Font("Arial", 1, 12));
        this.JTFCodigoRbro.setToolTipText("");
        this.JTFCodigoRbro.setBorder(BorderFactory.createTitledBorder((Border) null, "Código", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFCodigoRbro.addActionListener(new ActionListener() { // from class: Presupuesto.JIFFOperacionPTO.5
            public void actionPerformed(ActionEvent evt) {
                JIFFOperacionPTO.this.JTFCodigoRbroActionPerformed(evt);
            }
        });
        this.JTFCodigoRbro.addFocusListener(new FocusAdapter() { // from class: Presupuesto.JIFFOperacionPTO.6
            public void focusLost(FocusEvent evt) {
                JIFFOperacionPTO.this.JTFCodigoRbroFocusLost(evt);
            }
        });
        this.JFTFValor.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JFTFValor.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JFTFValor.setHorizontalAlignment(0);
        this.JFTFValor.setFont(new Font("Arial", 1, 12));
        this.JBAdicionar.setFont(new Font("Arial", 1, 12));
        this.JBAdicionar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBAdicionar.setText("Adicionar");
        this.JBAdicionar.addActionListener(new ActionListener() { // from class: Presupuesto.JIFFOperacionPTO.7
            public void actionPerformed(ActionEvent evt) {
                JIFFOperacionPTO.this.JBAdicionarActionPerformed(evt);
            }
        });
        this.JTFObservacion.setFont(new Font("Arial", 1, 12));
        this.JTFObservacion.setToolTipText("");
        this.JTFObservacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JLDisponible.setFont(new Font("Arial", 1, 12));
        this.JLDisponible.setForeground(Color.red);
        this.JLDisponible.setHorizontalAlignment(0);
        this.JLDisponible.setText("0");
        this.JLDisponible.setToolTipText("");
        this.JLDisponible.setBorder(BorderFactory.createTitledBorder((Border) null, "Saldo Disponible", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(this.JLDisponible, -1, 163, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFObservacion, -2, 573, -2)).addGroup(jPanel2Layout.createSequentialGroup().addGap(5, 5, 5).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JBAdicionar, -1, -1, 32767).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.JTFCodigoRbro, -2, 96, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBRubros, 0, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JFTFValor, -2, 114, -2))))).addContainerGap()));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGap(2, 2, 2).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFCodigoRbro, -2, 53, -2).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBRubros, -2, 52, -2).addComponent(this.JFTFValor, -2, 52, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.JTFObservacion, -2, 50, -2)).addComponent(this.JLDisponible, -1, -1, 32767)).addGap(5, 5, 5).addComponent(this.JBAdicionar, -2, 39, -2).addGap(5, 5, 5)));
        this.jScrollPane2.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: Presupuesto.JIFFOperacionPTO.8
            public void mouseClicked(MouseEvent evt) {
                JIFFOperacionPTO.this.JTDetalleMouseClicked(evt);
            }
        });
        this.jScrollPane2.setViewportView(this.JTDetalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -1, -1, 32767).addComponent(this.jScrollPane2, GroupLayout.Alignment.TRAILING)).addContainerGap()).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel2, -1, -1, 32767).addContainerGap())));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, 149, -2).addGap(201, 201, 201).addComponent(this.jScrollPane2, -1, 292, 32767).addContainerGap()).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(166, 166, 166).addComponent(this.jPanel2, -2, 186, -2).addContainerGap(312, 32767))));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBTipoDocumentoItemStateChanged(ItemEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtFechaKeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBBuscarActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBRubrosItemStateChanged(ItemEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCodigoRbroActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCodigoRbroFocusLost(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBAdicionarActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        this.JTDetalle.columnAtPoint(evt.getPoint());
        this.JTDetalle.rowAtPoint(evt.getPoint());
    }
}
