package com.genoma.plus.controller.contabilidad;

import Utilidades.Metodos;
import com.genoma.plus.dao.contabilidad.ContabilidadDAO;
import com.genoma.plus.dao.contabilidad.InformesVariosContabilidadDAO;
import com.genoma.plus.dao.contabilidad.PucTipoDeInformesDAO;
import com.genoma.plus.dao.impl.contabilidad.ContabilidadDAOImpl;
import com.genoma.plus.dao.impl.contabilidad.InformesVariosContabilidadDAOImpl;
import com.genoma.plus.dao.impl.contabilidad.PucTipoDeInformeDAOImpl;
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
import java.util.Vector;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/contabilidad/JIFInformesFinancieros.class */
public class JIFInformesFinancieros extends JInternalFrame {
    private ContabilidadDAO contabilidadDAO;
    private PucTipoDeInformesDAO tipodeInformesDAO;
    private InformesVariosContabilidadDAO informesVariosContabilidadDAO;
    private DefaultTableModel modelo;
    private Object[] dato;
    private String[][] idPeriodo;
    private String[] idTIpoInforme;
    private Vector xvector;
    private JButton JBTGenerar;
    private JComboBox JCBTipoInforme;
    private JDateChooser JDCFechaFin;
    private JDateChooser JDCFechaInicio;
    private JPanel JPI_DatosFiltro;
    private JScrollPane JSP_Detalle;
    private JTable JTBDetalle;
    private JTextField JTFRuta;
    private Metodos metodos = new Metodos();
    private boolean llleno = false;

    public JIFInformesFinancieros(String titulo) {
        initComponents();
        setTitle(titulo.toUpperCase());
        springStart();
        nuevo();
    }

    /* JADX WARN: Type inference failed for: r3v26, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPI_DatosFiltro = new JPanel();
        this.JCBTipoInforme = new JComboBox();
        this.JDCFechaInicio = new JDateChooser();
        this.JDCFechaFin = new JDateChooser();
        this.JSP_Detalle = new JScrollPane();
        this.JTBDetalle = new JTable();
        this.JTFRuta = new JTextField();
        this.JBTGenerar = new JButton();
        setClosable(true);
        setIconifiable(true);
        setName("jif_informesestadofinanciero");
        this.JPI_DatosFiltro.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JCBTipoInforme.setFont(new Font("Arial", 1, 12));
        this.JCBTipoInforme.setBorder(BorderFactory.createTitledBorder((Border) null, "Informe", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFechaInicio.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha(1)", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFechaInicio.setDateFormatString("dd/MM/yyyy");
        this.JDCFechaInicio.setFont(new Font("Arial", 1, 12));
        this.JDCFechaInicio.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.contabilidad.JIFInformesFinancieros.1
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFInformesFinancieros.this.JDCFechaInicioPropertyChange(evt);
            }
        });
        this.JDCFechaFin.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha(2)", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFechaFin.setDateFormatString("dd/MM/yyyy");
        this.JDCFechaFin.setFont(new Font("Arial", 1, 12));
        this.JDCFechaFin.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.contabilidad.JIFInformesFinancieros.2
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFInformesFinancieros.this.JDCFechaFinPropertyChange(evt);
            }
        });
        GroupLayout JPI_DatosFiltroLayout = new GroupLayout(this.JPI_DatosFiltro);
        this.JPI_DatosFiltro.setLayout(JPI_DatosFiltroLayout);
        JPI_DatosFiltroLayout.setHorizontalGroup(JPI_DatosFiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DatosFiltroLayout.createSequentialGroup().addContainerGap().addComponent(this.JCBTipoInforme, -2, 371, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JDCFechaInicio, -2, 125, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JDCFechaFin, -2, 125, -2).addGap(29, 29, 29)));
        JPI_DatosFiltroLayout.setVerticalGroup(JPI_DatosFiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPI_DatosFiltroLayout.createSequentialGroup().addContainerGap().addGroup(JPI_DatosFiltroLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPI_DatosFiltroLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JDCFechaInicio, -1, 53, 32767).addComponent(this.JDCFechaFin, -1, -1, 32767)).addGroup(JPI_DatosFiltroLayout.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.JCBTipoInforme, -2, 50, -2))).addContainerGap()));
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
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.contabilidad.JIFInformesFinancieros.3
            public void mouseClicked(MouseEvent evt) {
                JIFInformesFinancieros.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBTGenerar.setFont(new Font("Arial", 1, 12));
        this.JBTGenerar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTGenerar.setText("Exportar");
        this.JBTGenerar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.contabilidad.JIFInformesFinancieros.4
            public void actionPerformed(ActionEvent evt) {
                JIFInformesFinancieros.this.JBTGenerarActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(14, 14, 14).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.JTFRuta, -1, 729, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTGenerar, -2, 248, -2)).addComponent(this.JSP_Detalle).addComponent(this.JPI_DatosFiltro, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap(7, 32767).addComponent(this.JPI_DatosFiltro, -2, -1, -2).addGap(18, 18, 18).addComponent(this.JSP_Detalle, -2, 464, -2).addGap(18, 18, 18).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JBTGenerar, -1, -1, 32767).addComponent(this.JTFRuta, -2, 50, -2))));
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

    private void springStart() {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"});
        this.contabilidadDAO = (ContabilidadDAOImpl) classPathXmlApplicationContext.getBean("contabilidadDAOImpl");
        this.tipodeInformesDAO = (PucTipoDeInformeDAOImpl) classPathXmlApplicationContext.getBean("PucTipodeInformeDAO");
        this.informesVariosContabilidadDAO = (InformesVariosContabilidadDAOImpl) classPathXmlApplicationContext.getBean("informesVariosContabilidadDAO");
    }

    public void nuevo() {
        this.llleno = false;
        this.JTFRuta.setText(this.metodos.getDirectorioExportacion() + "Planilla");
        this.JDCFechaInicio.setDate(this.metodos.getFechaActual());
        this.JDCFechaFin.setDate(this.metodos.getFechaActual());
        this.JCBTipoInforme.removeAllItems();
        List<Object[]> idTipoInforme = this.tipodeInformesDAO.listaTipoInformesFiltrado(1);
        if (!idTipoInforme.isEmpty()) {
            this.idTIpoInforme = new String[idTipoInforme.size()];
            for (int i = 0; i < idTipoInforme.size(); i++) {
                this.idTIpoInforme[i] = idTipoInforme.get(i)[0].toString();
                this.JCBTipoInforme.addItem(idTipoInforme.get(i)[1]);
            }
        }
        iniciarEncabezadoModelo();
        this.llleno = true;
    }

    private void crearModeloDatos() {
        this.modelo = new DefaultTableModel(null, this.xvector) { // from class: com.genoma.plus.controller.contabilidad.JIFInformesFinancieros.5
            Class[] types = {String.class, String.class, Double.class, Double.class};
            boolean[] canEdit = {true, true, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        this.JTBDetalle.setModel(this.modelo);
        JTable jTable = this.JTBDetalle;
        JTable jTable2 = this.JTBDetalle;
        jTable.setAutoResizeMode(0);
        this.JTBDetalle.doLayout();
        this.JTBDetalle.getColumnModel().getColumn(0).setPreferredWidth(490);
        this.JTBDetalle.getColumnModel().getColumn(1).setPreferredWidth(80);
        this.JTBDetalle.getColumnModel().getColumn(2).setPreferredWidth(200);
        this.JTBDetalle.getColumnModel().getColumn(3).setPreferredWidth(200);
    }

    private void agregarColumnaTabla() {
        this.xvector = new Vector();
        this.xvector.add("Cuenta");
        this.xvector.add("Nota");
        this.xvector.add(this.metodos.formatoANO.format(this.JDCFechaInicio.getDate()));
        this.xvector.add(this.metodos.formatoANO.format(this.JDCFechaFin.getDate()));
    }

    private void iniciarEncabezadoModelo() {
        agregarColumnaTabla();
        crearModeloDatos();
    }

    private void llenarTablaDatos() {
        crearModeloDatos();
        List<Object[]> listaResultado = this.informesVariosContabilidadDAO.listadoEstadosFinancieros(this.idTIpoInforme[this.JCBTipoInforme.getSelectedIndex()], this.metodos.formatoAMD1.format(this.JDCFechaInicio.getDate()), this.metodos.formatoAMD1.format(this.JDCFechaFin.getDate()));
        if (!listaResultado.isEmpty()) {
            this.metodos.mEstablecerTextEditor(this.JTBDetalle, 0);
            for (int i = 0; i < listaResultado.size(); i++) {
                this.modelo.addRow(this.dato);
                this.modelo.setValueAt(listaResultado.get(i)[0], i, 0);
                this.modelo.setValueAt(listaResultado.get(i)[1], i, 1);
                this.modelo.setValueAt(listaResultado.get(i)[2], i, 2);
                this.modelo.setValueAt(listaResultado.get(i)[3], i, 3);
            }
        }
    }

    public void buscar() {
        if (this.JCBTipoInforme.getSelectedIndex() != -1) {
            llenarTablaDatos();
        } else {
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un tipo de informe", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
            this.JCBTipoInforme.requestFocus();
        }
    }
}
