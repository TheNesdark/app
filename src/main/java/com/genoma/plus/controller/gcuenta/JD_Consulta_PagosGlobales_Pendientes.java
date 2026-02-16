package com.genoma.plus.controller.gcuenta;

import Acceso.Principal;
import Utilidades.Metodos;
import com.genoma.plus.dao.impl.gcuenta.GCuentaDAOImpl;
import com.genoma.plus.jpa.gcuenta.GCuentaDAO;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyVetoException;
import java.io.File;
import java.text.DecimalFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/gcuenta/JD_Consulta_PagosGlobales_Pendientes.class */
public class JD_Consulta_PagosGlobales_Pendientes extends JDialog {
    private Metodos xmt;
    private GCuentaDAO gcuenta;
    private DefaultTableModel xModelo;
    private Object[] xdatos;
    private String xIdEmpresa;
    private ButtonGroup JBG_Filtro;
    private JButton JBTExportar;
    private JPanel JPI_Filtro;
    private JRadioButton JRBAplica;
    private JRadioButton JRBTodas;
    private JScrollPane JSPResultado;
    private JTable JTDetalle;
    private JFormattedTextField JTFFValorT;
    private JTextField JTFRuta;

    public JD_Consulta_PagosGlobales_Pendientes(Frame parent, boolean modal, String xIdEmpresa) {
        super(parent, modal);
        this.xmt = new Metodos();
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        springStart();
        this.xIdEmpresa = xIdEmpresa;
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
        mCargarDatos();
    }

    /* JADX WARN: Type inference failed for: r3v3, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBG_Filtro = new ButtonGroup();
        this.JSPResultado = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JPI_Filtro = new JPanel();
        this.JRBAplica = new JRadioButton();
        this.JRBTodas = new JRadioButton();
        this.JTFFValorT = new JFormattedTextField();
        this.JTFRuta = new JTextField();
        this.JBTExportar = new JButton();
        setDefaultCloseOperation(2);
        setTitle("CONSULTA DE PAGOS GLOBALES PENDIENTESPOR DESCARGAR");
        this.JSPResultado.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setEditingColumn(1);
        this.JTDetalle.setEditingRow(1);
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.gcuenta.JD_Consulta_PagosGlobales_Pendientes.1
            public void mouseClicked(MouseEvent evt) {
                JD_Consulta_PagosGlobales_Pendientes.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPResultado.setViewportView(this.JTDetalle);
        this.JPI_Filtro.setBorder(BorderFactory.createTitledBorder((Border) null, "Filtro", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBG_Filtro.add(this.JRBAplica);
        this.JRBAplica.setFont(new Font("Arial", 1, 12));
        this.JRBAplica.setSelected(true);
        this.JRBAplica.setText("Aplica");
        this.JRBAplica.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.gcuenta.JD_Consulta_PagosGlobales_Pendientes.2
            public void actionPerformed(ActionEvent evt) {
                JD_Consulta_PagosGlobales_Pendientes.this.JRBAplicaActionPerformed(evt);
            }
        });
        this.JBG_Filtro.add(this.JRBTodas);
        this.JRBTodas.setFont(new Font("Arial", 1, 12));
        this.JRBTodas.setText("Todas");
        this.JRBTodas.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.gcuenta.JD_Consulta_PagosGlobales_Pendientes.3
            public void actionPerformed(ActionEvent evt) {
                JD_Consulta_PagosGlobales_Pendientes.this.JRBTodasActionPerformed(evt);
            }
        });
        GroupLayout JPI_FiltroLayout = new GroupLayout(this.JPI_Filtro);
        this.JPI_Filtro.setLayout(JPI_FiltroLayout);
        JPI_FiltroLayout.setHorizontalGroup(JPI_FiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_FiltroLayout.createSequentialGroup().addContainerGap().addComponent(this.JRBAplica).addGap(18, 18, 18).addComponent(this.JRBTodas).addContainerGap(-1, 32767)));
        JPI_FiltroLayout.setVerticalGroup(JPI_FiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_FiltroLayout.createSequentialGroup().addGroup(JPI_FiltroLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBAplica).addComponent(this.JRBTodas)).addGap(0, 0, 32767)));
        this.JTFFValorT.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor Total", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFValorT.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFValorT.setHorizontalAlignment(4);
        this.JTFFValorT.setFont(new Font("Arial", 1, 14));
        this.JTFFValorT.setValue(new Long(0L));
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.setName("xjif_balancefecha");
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.gcuenta.JD_Consulta_PagosGlobales_Pendientes.4
            public void mouseClicked(MouseEvent evt) {
                JD_Consulta_PagosGlobales_Pendientes.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setForeground(Color.red);
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.gcuenta.JD_Consulta_PagosGlobales_Pendientes.5
            public void actionPerformed(ActionEvent evt) {
                JD_Consulta_PagosGlobales_Pendientes.this.JBTExportarActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JSPResultado).addGroup(layout.createSequentialGroup().addComponent(this.JTFRuta, -2, 279, -2).addGap(18, 18, 18).addComponent(this.JBTExportar, -2, 128, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JPI_Filtro, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFFValorT, -2, 147, -2))).addContainerGap(-1, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap(22, 32767).addComponent(this.JSPResultado, -2, 284, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JPI_Filtro, GroupLayout.Alignment.LEADING, -1, -1, 32767).addGroup(GroupLayout.Alignment.LEADING, layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFRuta, -2, 50, -2).addComponent(this.JBTExportar, -2, 50, -2)).addComponent(this.JTFFValorT)).addContainerGap(15, 32767)));
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
        if (!this.JTFRuta.getText().isEmpty()) {
            if (this.JTDetalle.getRowCount() > -1) {
                int n = JOptionPane.showConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (n == 0) {
                    this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTDetalle, this.xmt.mTraerUrlBD(this.JTFRuta.getText()), getTitle());
                    return;
                }
                return;
            }
            return;
        }
        JOptionPane.showMessageDialog(this, "Debe seleccionar un ruta valida", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        this.JTFRuta.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            try {
                Principal.xclasegc.xJifPagosGrupales.JTF_DocP.setText(this.xModelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
                Principal.xclasegc.xJifPagosGrupales.JTFFValorPagado.setValue(this.xModelo.getValueAt(this.JTDetalle.getSelectedRow(), 3));
                dispose();
                Principal.xclasegc.xJifPagosGrupales.setSelected(true);
            } catch (PropertyVetoException e) {
                Logger.getLogger(JD_Consulta_PagosGlobales_Pendientes.class.getName()).log(Level.SEVERE, (String) null, e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBAplicaActionPerformed(ActionEvent evt) {
        mCargarDatos();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBTodasActionPerformed(ActionEvent evt) {
        mCargarDatos();
    }

    private void springStart() {
        this.gcuenta = (GCuentaDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("gCuentaDAOImpl");
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCreaModelo() {
        this.xModelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Fecha", "Tipo Documento", "Valor", "Descripción", "Empresa"}) { // from class: com.genoma.plus.controller.gcuenta.JD_Consulta_PagosGlobales_Pendientes.6
            Class[] types = {Long.class, String.class, String.class, Double.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xModelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(100);
    }

    private void mCargarDatos() {
        List<Object[]> list;
        if (this.JRBAplica.isSelected()) {
            list = this.gcuenta.listDocumentosPagoGlobalesFEmpresa(this.xIdEmpresa, true);
        } else {
            list = this.gcuenta.listDocumentosPagoGlobalesFEmpresa(this.xIdEmpresa, false);
        }
        mCreaModelo();
        for (int x = 0; x < list.size(); x++) {
            System.out.println("0-->" + list.get(x)[0] + " 1-->" + list.get(x)[1] + " 2-->" + list.get(x)[2] + " 3-->" + list.get(x)[3]);
            this.xModelo.addRow(this.xdatos);
            this.xModelo.setValueAt(list.get(x)[0], x, 0);
            this.xModelo.setValueAt(list.get(x)[1], x, 1);
            this.xModelo.setValueAt(list.get(x)[2], x, 2);
            this.xModelo.setValueAt(list.get(x)[3], x, 3);
            this.xModelo.setValueAt(list.get(x)[4], x, 4);
            this.xModelo.setValueAt(list.get(x)[5], x, 5);
        }
    }
}
