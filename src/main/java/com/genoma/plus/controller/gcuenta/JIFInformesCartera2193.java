package com.genoma.plus.controller.gcuenta;

import Utilidades.Metodos;
import com.genoma.plus.dao.impl.gcuenta.InformesCartera2193DAOImpl;
import com.genoma.plus.dto.gcuenta.InformesCartera2193DTO;
import com.genoma.plus.jpa.gcuenta.InformesCaretera2193DAO;
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

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/gcuenta/JIFInformesCartera2193.class */
public class JIFInformesCartera2193 extends JInternalFrame {
    private InformesCaretera2193DAO informesCaretera2193DAO;
    private InformesCartera2193DTO informesCartera2193DTO;
    private DefaultTableModel xmodelo;
    private Object[] dato;
    private Metodos metodos = new Metodos();
    private boolean llleno = false;
    private Integer tipoFiltro = 0;
    private ButtonGroup JBGFiltro;
    private JButton JBTGenerar;
    private JDateChooser JDCFechaFin;
    private JDateChooser JDCFechaInicio;
    private JPanel JPI_DatosFiltro;
    private JPanel JPI_FiltroFecha;
    private JRadioButton JRB_FCuentaCobro;
    private JRadioButton JRB_FFactura;
    private JScrollPane JSP_Detalle;
    private JTable JTBDetalle;
    private JTextField JTFRuta;

    public JIFInformesCartera2193() {
        initComponents();
        springStart();
        nuevo();
    }

    /* JADX WARN: Type inference failed for: r3v44, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGFiltro = new ButtonGroup();
        this.JPI_DatosFiltro = new JPanel();
        this.JDCFechaInicio = new JDateChooser();
        this.JDCFechaFin = new JDateChooser();
        this.JPI_FiltroFecha = new JPanel();
        this.JRB_FFactura = new JRadioButton();
        this.JRB_FCuentaCobro = new JRadioButton();
        this.JSP_Detalle = new JScrollPane();
        this.JTBDetalle = new JTable();
        this.JTFRuta = new JTextField();
        this.JBTGenerar = new JButton();
        setClosable(true);
        setIconifiable(true);
        setTitle("INFORME CARTERA 2193");
        setFont(new Font("Arial", 1, 14));
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jIFInformesCartera2193");
        this.JPI_DatosFiltro.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JDCFechaInicio.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha(1)", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFechaInicio.setDateFormatString("dd/MM/yyyy");
        this.JDCFechaInicio.setFont(new Font("Arial", 1, 12));
        this.JDCFechaInicio.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.gcuenta.JIFInformesCartera2193.1
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFInformesCartera2193.this.JDCFechaInicioPropertyChange(evt);
            }
        });
        this.JDCFechaFin.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha(2)", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFechaFin.setDateFormatString("dd/MM/yyyy");
        this.JDCFechaFin.setFont(new Font("Arial", 1, 12));
        this.JDCFechaFin.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.gcuenta.JIFInformesCartera2193.2
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFInformesCartera2193.this.JDCFechaFinPropertyChange(evt);
            }
        });
        this.JPI_FiltroFecha.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Filtro en Fecha", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JBGFiltro.add(this.JRB_FFactura);
        this.JRB_FFactura.setFont(new Font("Arial", 1, 12));
        this.JRB_FFactura.setForeground(Color.blue);
        this.JRB_FFactura.setSelected(true);
        this.JRB_FFactura.setText("Factura");
        this.JRB_FFactura.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.gcuenta.JIFInformesCartera2193.3
            public void actionPerformed(ActionEvent evt) {
                JIFInformesCartera2193.this.JRB_FFacturaActionPerformed(evt);
            }
        });
        this.JBGFiltro.add(this.JRB_FCuentaCobro);
        this.JRB_FCuentaCobro.setFont(new Font("Arial", 1, 12));
        this.JRB_FCuentaCobro.setForeground(Color.blue);
        this.JRB_FCuentaCobro.setText("Cuenta Cobro");
        this.JRB_FCuentaCobro.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.gcuenta.JIFInformesCartera2193.4
            public void actionPerformed(ActionEvent evt) {
                JIFInformesCartera2193.this.JRB_FCuentaCobroActionPerformed(evt);
            }
        });
        GroupLayout JPI_FiltroFechaLayout = new GroupLayout(this.JPI_FiltroFecha);
        this.JPI_FiltroFecha.setLayout(JPI_FiltroFechaLayout);
        JPI_FiltroFechaLayout.setHorizontalGroup(JPI_FiltroFechaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_FiltroFechaLayout.createSequentialGroup().addComponent(this.JRB_FFactura).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRB_FCuentaCobro).addContainerGap(33, 32767)));
        JPI_FiltroFechaLayout.setVerticalGroup(JPI_FiltroFechaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_FiltroFechaLayout.createSequentialGroup().addGroup(JPI_FiltroFechaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRB_FFactura).addComponent(this.JRB_FCuentaCobro)).addGap(0, 0, 32767)));
        GroupLayout JPI_DatosFiltroLayout = new GroupLayout(this.JPI_DatosFiltro);
        this.JPI_DatosFiltro.setLayout(JPI_DatosFiltroLayout);
        JPI_DatosFiltroLayout.setHorizontalGroup(JPI_DatosFiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DatosFiltroLayout.createSequentialGroup().addContainerGap().addComponent(this.JPI_FiltroFecha, -2, -1, -2).addGap(18, 18, 18).addComponent(this.JDCFechaInicio, -2, 125, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JDCFechaFin, -2, 125, -2).addContainerGap(-1, 32767)));
        JPI_DatosFiltroLayout.setVerticalGroup(JPI_DatosFiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DatosFiltroLayout.createSequentialGroup().addGroup(JPI_DatosFiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DatosFiltroLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JDCFechaInicio, GroupLayout.Alignment.LEADING, -1, 50, 32767).addComponent(this.JPI_FiltroFecha, GroupLayout.Alignment.LEADING, -1, -1, 32767)).addComponent(this.JDCFechaFin, -2, 50, -2)).addContainerGap(-1, 32767)));
        this.JSP_Detalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTBDetalle.setFont(new Font("Arial", 1, 12));
        this.JTBDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTBDetalle.setRowHeight(25);
        this.JTBDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTBDetalle.setSelectionForeground(Color.red);
        this.JSP_Detalle.setViewportView(this.JTBDetalle);
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\\\Genoma\\\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ruta", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.gcuenta.JIFInformesCartera2193.5
            public void mouseClicked(MouseEvent evt) {
                JIFInformesCartera2193.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBTGenerar.setFont(new Font("Arial", 1, 12));
        this.JBTGenerar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTGenerar.setText("Exportar");
        this.JBTGenerar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.gcuenta.JIFInformesCartera2193.6
            public void actionPerformed(ActionEvent evt) {
                JIFInformesCartera2193.this.JBTGenerarActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.JTFRuta, -1, 731, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTGenerar, -2, 248, -2)).addComponent(this.JPI_DatosFiltro, -1, -1, 32767).addComponent(this.JSP_Detalle)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPI_DatosFiltro, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSP_Detalle, -2, 307, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JBTGenerar, -1, -1, 32767).addComponent(this.JTFRuta, -2, 50, -2)).addContainerGap()));
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
                this.JTFRuta.setText(xfile.getAbsolutePath() + this.metodos.getBarra());
                this.JTFRuta.requestFocus();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTGenerarActionPerformed(ActionEvent evt) {
        if (this.JTBDetalle.getRowCount() != -1) {
            int x = JOptionPane.showConfirmDialog(this, "Esta seguro de exportar?", "CONFIRMACIÓN", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                this.metodos.mExportar_Datos_Tabla_Titulo_Formato(this.JTBDetalle, this.JTFRuta.getText(), getTitle());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDCFechaInicioPropertyChange(PropertyChangeEvent evt) {
        if (this.llleno) {
            iniciarEncabezadoModelo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDCFechaFinPropertyChange(PropertyChangeEvent evt) {
        if (this.llleno) {
            iniciarEncabezadoModelo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_FFacturaActionPerformed(ActionEvent evt) {
        this.tipoFiltro = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_FCuentaCobroActionPerformed(ActionEvent evt) {
        this.tipoFiltro = 1;
    }

    private void springStart() {
        this.informesCaretera2193DAO = (InformesCartera2193DAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("informesCartera2193DAOImpl");
    }

    public void nuevo() {
        this.llleno = false;
        this.JTFRuta.setText(this.metodos.getDirectorioExportacion() + "Planilla");
        this.JDCFechaInicio.setDate(this.metodos.getFechaActual());
        this.JDCFechaFin.setDate(this.metodos.getFechaActual());
        iniciarEncabezadoModelo();
        this.tipoFiltro = 0;
        this.JRB_FFactura.setSelected(true);
        this.llleno = true;
    }

    private void crearModeloDatos() {
        this.xmodelo = new DefaultTableModel((Object[][]) null, new String[]{"Estado Factura", "Regimen", "Razon Social", "Hasta 60 dias", "De 61 a 90 dias", "De 91 a 180 dias", "De 181 a 360 Dias", "De 361 dias en Adelante", "Total"}) { // from class: com.genoma.plus.controller.gcuenta.JIFInformesCartera2193.7
            Class[] types = {String.class, String.class, String.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTBDetalle.setModel(this.xmodelo);
        this.JTBDetalle.setAutoResizeMode(0);
        this.JTBDetalle.doLayout();
        this.JTBDetalle.getColumnModel().getColumn(0).setPreferredWidth(80);
        this.JTBDetalle.getColumnModel().getColumn(1).setPreferredWidth(200);
        this.JTBDetalle.getColumnModel().getColumn(2).setPreferredWidth(400);
        this.JTBDetalle.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTBDetalle.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTBDetalle.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTBDetalle.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTBDetalle.getColumnModel().getColumn(7).setPreferredWidth(100);
        this.JTBDetalle.getColumnModel().getColumn(8).setPreferredWidth(100);
    }

    private void iniciarEncabezadoModelo() {
        crearModeloDatos();
    }

    private boolean validarCampos() {
        boolean respuesta = true;
        try {
            this.metodos.formatoAMD1.format(this.JDCFechaInicio.getDate());
            this.metodos.formatoAMD1.format(this.JDCFechaFin.getDate());
        } catch (Exception e) {
            e.printStackTrace();
            respuesta = false;
        }
        return respuesta;
    }

    private InformesCartera2193DTO LlenarDTO() {
        InformesCartera2193DTO informesCartera2193DTO = new InformesCartera2193DTO();
        informesCartera2193DTO.setFechaInicio(this.metodos.formatoAMD1.format(this.JDCFechaInicio.getDate()));
        informesCartera2193DTO.setFechaFin(this.metodos.formatoAMD1.format(this.JDCFechaFin.getDate()));
        return informesCartera2193DTO;
    }

    private void llenarTablaDatos() {
        if (validarCampos()) {
            crearModeloDatos();
            List<Object[]> listaResultado = this.informesCaretera2193DAO.listCartera2193(LlenarDTO(), this.tipoFiltro);
            if (!listaResultado.isEmpty()) {
                this.metodos.mEstablecerTextEditor(this.JTBDetalle, 0);
                for (int i = 0; i < listaResultado.size(); i++) {
                    this.xmodelo.addRow(this.dato);
                    this.xmodelo.setValueAt(listaResultado.get(i)[0], i, 0);
                    this.xmodelo.setValueAt(listaResultado.get(i)[1], i, 1);
                    this.xmodelo.setValueAt(listaResultado.get(i)[2], i, 2);
                    this.xmodelo.setValueAt(listaResultado.get(i)[3], i, 3);
                    this.xmodelo.setValueAt(listaResultado.get(i)[4], i, 4);
                    this.xmodelo.setValueAt(listaResultado.get(i)[5], i, 5);
                    this.xmodelo.setValueAt(listaResultado.get(i)[6], i, 6);
                    this.xmodelo.setValueAt(listaResultado.get(i)[7], i, 7);
                    this.xmodelo.setValueAt(listaResultado.get(i)[8], i, 8);
                }
                return;
            }
            return;
        }
        JOptionPane.showMessageDialog(this.rootPane, "Formato de fecha Incorrecto");
    }

    public void buscar() {
        llenarTablaDatos();
    }
}
