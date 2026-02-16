package com.genoma.plus.controller.caja;

import Acceso.Principal;
import Caja.claseCaja;
import Utilidades.Metodos;
import com.genoma.plus.dao.caja.ReciboEgresosDAO;
import com.genoma.plus.dao.impl.caja.ReciboEgresosDAOImpl;
import com.genoma.plus.dto.caja.ReciboEgresosDTO;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.text.DecimalFormat;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/caja/JDBuscarReciboEgreso.class */
public class JDBuscarReciboEgreso extends JDialog {
    private DefaultTableModel xmodelo;
    private ReciboEgresosDAO xReciboEgresosDAO;
    private Object[] xDato;
    private Metodos xmt;
    private claseCaja classCaja;
    private JIFRecibosEgresos xJIFRecibosEgresos;
    private JButton JBTExportar;
    private JDateChooser JDFechaF;
    private JDateChooser JDFechaI;
    private JFormattedTextField JFTFTotal;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;
    private JTextField JTFRuta;
    private JButton btnBuscar;
    private JPanel jPanel1;

    public JDBuscarReciboEgreso(Frame parent, boolean modal, JIFRecibosEgresos xJIFRecibosEgresos) {
        super(parent, modal);
        this.xmt = new Metodos();
        initComponents();
        this.xJIFRecibosEgresos = xJIFRecibosEgresos;
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        setTitle("HISTORIAL DE RECIBOS DE EGRESO");
        springStart();
        mNuevo();
    }

    private void springStart() {
        this.xReciboEgresosDAO = (ReciboEgresosDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("reciboEgresosDAO");
    }

    public void mNuevo() {
        Principal.mLimpiarDatosP();
        this.JDFechaI.setDate(this.xmt.getFechaActual());
        this.JDFechaF.setDate(this.xmt.getFechaActual());
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
        mCrearModeloTabla();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloTabla() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Fecha", "Caja", "Usuario", "Observacion", "No. Cierre", "Estado", "Total"}) { // from class: com.genoma.plus.controller.caja.JDBuscarReciboEgreso.1
            Class[] types = {Long.class, String.class, String.class, String.class, String.class, Long.class, Boolean.class, Double.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false};

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
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(100);
    }

    private void mBuscaDatos() {
        mCrearModeloTabla();
        List<ReciboEgresosDTO> list = this.xReciboEgresosDAO.listaHistoricoReciboEgresos(this.xmt.formatoAMDG.format(this.JDFechaI.getDate()), this.xmt.formatoAMDG.format(this.JDFechaF.getDate()), null, 0);
        for (int x = 0; x < list.size(); x++) {
            this.xmodelo.addRow(this.xDato);
            this.xmodelo.setValueAt(list.get(x).getIdRecibo(), x, 0);
            this.xmodelo.setValueAt(list.get(x).getFecha(), x, 1);
            this.xmodelo.setValueAt(list.get(x).getIdCaja(), x, 2);
            this.xmodelo.setValueAt(list.get(x).getIdTercero(), x, 3);
            this.xmodelo.setValueAt(list.get(x).getObservacion(), x, 4);
            this.xmodelo.setValueAt(list.get(x).getIdCierre(), x, 5);
            if (list.get(x).getEstado() == 1) {
                this.xmodelo.setValueAt(true, x, 6);
            } else {
                this.xmodelo.setValueAt(false, x, 6);
            }
            this.xmodelo.setValueAt(list.get(x).getValor(), x, 7);
        }
        mTotalizar();
    }

    private void mTotalizar() {
        Double xvalor = Double.valueOf(0.0d);
        if (this.JTDetalle.getRowCount() != 0) {
            for (int x = 0; x < this.JTDetalle.getRowCount(); x++) {
                xvalor = Double.valueOf(xvalor.doubleValue() + Double.valueOf(this.xmodelo.getValueAt(x, 7).toString()).doubleValue());
                this.JFTFTotal.setValue(xvalor);
            }
        }
    }

    /* JADX WARN: Type inference failed for: r3v3, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.jPanel1 = new JPanel();
        this.JDFechaI = new JDateChooser();
        this.JDFechaF = new JDateChooser();
        this.btnBuscar = new JButton();
        this.JTFRuta = new JTextField();
        this.JBTExportar = new JButton();
        this.JFTFTotal = new JFormattedTextField();
        setDefaultCloseOperation(2);
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setSelectionBackground(Color.white);
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.caja.JDBuscarReciboEgreso.2
            public void mouseClicked(MouseEvent evt) {
                JDBuscarReciboEgreso.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACION", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JDFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFechaI.setFont(new Font("Arial", 1, 12));
        this.JDFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Fin", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFechaF.setFont(new Font("Arial", 1, 12));
        this.btnBuscar.setFont(new Font("Arial", 1, 12));
        this.btnBuscar.setForeground(new Color(0, 0, 153));
        this.btnBuscar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Buscar.png")));
        this.btnBuscar.setText("Buscar");
        this.btnBuscar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.caja.JDBuscarReciboEgreso.3
            public void actionPerformed(ActionEvent evt) {
                JDBuscarReciboEgreso.this.btnBuscarActionPerformed(evt);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.JDFechaI, -2, 116, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JDFechaF, -2, 116, -2).addGap(264, 264, 264).addComponent(this.btnBuscar, -2, 192, -2).addGap(10, 10, 10)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.btnBuscar, -2, 50, -2).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JDFechaF, -1, -1, 32767).addComponent(this.JDFechaI, -2, -1, -2))).addGap(5, 5, 5)));
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\\\Genoma\\\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.caja.JDBuscarReciboEgreso.4
            public void mouseClicked(MouseEvent evt) {
                JDBuscarReciboEgreso.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setForeground(Color.red);
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.caja.JDBuscarReciboEgreso.5
            public void actionPerformed(ActionEvent evt) {
                JDBuscarReciboEgreso.this.JBTExportarActionPerformed(evt);
            }
        });
        this.JFTFTotal.setEditable(false);
        this.JFTFTotal.setBorder(BorderFactory.createTitledBorder((Border) null, "Total", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JFTFTotal.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JFTFTotal.setHorizontalAlignment(4);
        this.JFTFTotal.setText("0");
        this.JFTFTotal.setFont(new Font("Arial", 1, 12));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addComponent(this.JSPDetalle).addGroup(layout.createSequentialGroup().addComponent(this.JTFRuta, -2, 420, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTExportar, -2, 151, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JFTFTotal, -2, 149, -2))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalle, -2, 382, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFRuta, -2, 50, -2).addComponent(this.JFTFTotal, -2, 50, -2)).addComponent(this.JBTExportar, -2, 50, -2)).addGap(15, 15, 15)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnBuscarActionPerformed(ActionEvent evt) {
        mBuscaDatos();
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
        if (!this.JTFRuta.getText().isEmpty()) {
            if (this.JTDetalle.getRowCount() != -1) {
                this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTDetalle, this.JTFRuta.getText(), getTitle());
                return;
            } else {
                JOptionPane.showMessageDialog(this, "No existe información para exportar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                return;
            }
        }
        JOptionPane.showMessageDialog(this, "Debe seleccionar un ruta valida", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        this.JTFRuta.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            this.xJIFRecibosEgresos.mCargarRecibos(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
            dispose();
        }
    }
}
