package com.genoma.plus.controller.contabilidad;

import Acceso.Principal;
import Utilidades.Metodos;
import com.genoma.plus.dao.contabilidad.ContabilidadDAO;
import com.genoma.plus.dao.contabilidad.InformesVariosContabilidadDAO;
import com.genoma.plus.dao.contabilidad.PucTipoDeInformesDAO;
import com.genoma.plus.dao.impl.contabilidad.ContabilidadDAOImpl;
import com.genoma.plus.dao.impl.contabilidad.InformesVariosContabilidadDAOImpl;
import com.genoma.plus.dao.impl.contabilidad.PucTipoDeInformeDAOImpl;
import com.toedter.calendar.JYearChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
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

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/contabilidad/JIFInformesVariosContabilidad.class */
public class JIFInformesVariosContabilidad extends JInternalFrame {
    private ContabilidadDAO contabilidadDAO;
    private PucTipoDeInformesDAO tipodeInformesDAO;
    private InformesVariosContabilidadDAO informesVariosContabilidadDAO;
    private DefaultTableModel modelo;
    private Object[] dato;
    private String[][] idPeriodo;
    private String[] idTIpoInforme;
    private Metodos metodos = new Metodos();
    private JButton JBTGenerar;
    private JComboBox JCBPeriodo;
    private JComboBox JCBTipoInforme;
    private JCheckBox JCHActivo;
    private JPanel JPI_DatosFiltro;
    private JScrollPane JSP_Detalle;
    private JTable JTBDetalle;
    private JTextField JTFRuta;
    private JYearChooser JYCAno;

    public JIFInformesVariosContabilidad(String titulo) {
        initComponents();
        setTitle(titulo.toUpperCase());
        springStart();
        nuevo();
    }

    /* JADX WARN: Type inference failed for: r3v29, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPI_DatosFiltro = new JPanel();
        this.JCBPeriodo = new JComboBox();
        this.JYCAno = new JYearChooser();
        this.JCHActivo = new JCheckBox();
        this.JCBTipoInforme = new JComboBox();
        this.JSP_Detalle = new JScrollPane();
        this.JTBDetalle = new JTable();
        this.JTFRuta = new JTextField();
        this.JBTGenerar = new JButton();
        setClosable(true);
        setIconifiable(true);
        setName("jif_informesvarioscontabilidad");
        this.JPI_DatosFiltro.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JCBPeriodo.setFont(new Font("Arial", 1, 12));
        this.JCBPeriodo.setBorder(BorderFactory.createTitledBorder((Border) null, "Periodo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBPeriodo.addItemListener(new ItemListener() { // from class: com.genoma.plus.controller.contabilidad.JIFInformesVariosContabilidad.1
            public void itemStateChanged(ItemEvent evt) {
                JIFInformesVariosContabilidad.this.JCBPeriodoItemStateChanged(evt);
            }
        });
        this.JYCAno.setBorder(BorderFactory.createTitledBorder((Border) null, "Año", 0, 0, new Font("Arial", 1, 13), Color.blue));
        this.JYCAno.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.contabilidad.JIFInformesVariosContabilidad.2
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFInformesVariosContabilidad.this.JYCAnoPropertyChange(evt);
            }
        });
        this.JCHActivo.setFont(new Font("Arial", 1, 13));
        this.JCHActivo.setSelected(true);
        this.JCHActivo.setText("Activo");
        this.JCHActivo.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.contabilidad.JIFInformesVariosContabilidad.3
            public void actionPerformed(ActionEvent evt) {
                JIFInformesVariosContabilidad.this.JCHActivoActionPerformed(evt);
            }
        });
        this.JCBTipoInforme.setFont(new Font("Arial", 1, 12));
        this.JCBTipoInforme.setBorder(BorderFactory.createTitledBorder((Border) null, "Informe", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPI_DatosFiltroLayout = new GroupLayout(this.JPI_DatosFiltro);
        this.JPI_DatosFiltro.setLayout(JPI_DatosFiltroLayout);
        JPI_DatosFiltroLayout.setHorizontalGroup(JPI_DatosFiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPI_DatosFiltroLayout.createSequentialGroup().addContainerGap().addComponent(this.JYCAno, -2, 95, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBPeriodo, -2, 352, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHActivo, -2, 79, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBTipoInforme, -2, 352, -2).addContainerGap(-1, 32767)));
        JPI_DatosFiltroLayout.setVerticalGroup(JPI_DatosFiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DatosFiltroLayout.createSequentialGroup().addGroup(JPI_DatosFiltroLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPI_DatosFiltroLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCHActivo).addComponent(this.JCBTipoInforme, -2, 50, -2)).addGroup(JPI_DatosFiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBPeriodo, -2, 50, -2).addComponent(this.JYCAno, -2, 50, -2))).addContainerGap(16, 32767)));
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
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.contabilidad.JIFInformesVariosContabilidad.4
            public void mouseClicked(MouseEvent evt) {
                JIFInformesVariosContabilidad.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBTGenerar.setFont(new Font("Arial", 1, 12));
        this.JBTGenerar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTGenerar.setText("Exportar");
        this.JBTGenerar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.contabilidad.JIFInformesVariosContabilidad.5
            public void actionPerformed(ActionEvent evt) {
                JIFInformesVariosContabilidad.this.JBTGenerarActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(14, 14, 14).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.JTFRuta, -1, 729, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTGenerar, -2, 248, -2)).addComponent(this.JSP_Detalle).addComponent(this.JPI_DatosFiltro, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.JPI_DatosFiltro, -2, -1, -2).addGap(18, 18, 18).addComponent(this.JSP_Detalle, -2, 464, -2).addGap(18, 18, 18).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JBTGenerar, -1, -1, 32767).addComponent(this.JTFRuta, -2, 50, -2))));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHActivoActionPerformed(ActionEvent evt) {
        cargarComboPeriodo();
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
    public void JCBPeriodoItemStateChanged(ItemEvent evt) {
        if (this.JCBPeriodo.getSelectedIndex() != -1) {
            System.out.println("" + this.idPeriodo[this.JCBPeriodo.getSelectedIndex()][2]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JYCAnoPropertyChange(PropertyChangeEvent evt) {
        cargarComboPeriodo();
    }

    private void springStart() {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"});
        this.contabilidadDAO = (ContabilidadDAOImpl) classPathXmlApplicationContext.getBean("contabilidadDAOImpl");
        this.tipodeInformesDAO = (PucTipoDeInformeDAOImpl) classPathXmlApplicationContext.getBean("PucTipodeInformeDAO");
        this.informesVariosContabilidadDAO = (InformesVariosContabilidadDAOImpl) classPathXmlApplicationContext.getBean("informesVariosContabilidadDAO");
    }

    private void cargarComboPeriodo() {
        int filtro;
        this.JCBPeriodo.removeAllItems();
        if (this.JCHActivo.isSelected()) {
            filtro = 1;
        } else {
            filtro = 0;
        }
        List<Object[]> idPeriodoC = this.contabilidadDAO.listadoPeriodoContable(String.valueOf(this.JYCAno.getValue()), Integer.valueOf(filtro));
        if (!idPeriodoC.isEmpty()) {
            this.idPeriodo = new String[idPeriodoC.size()][5];
            for (int i = 0; i < idPeriodoC.size(); i++) {
                this.idPeriodo[i][0] = idPeriodoC.get(i)[0].toString();
                this.idPeriodo[i][1] = idPeriodoC.get(i)[1].toString();
                this.idPeriodo[i][2] = idPeriodoC.get(i)[2].toString();
                this.idPeriodo[i][3] = idPeriodoC.get(i)[3].toString();
                this.idPeriodo[i][4] = idPeriodoC.get(i)[4].toString();
                this.JCBPeriodo.addItem(idPeriodoC.get(i)[1].toString());
            }
        }
    }

    public void nuevo() {
        this.JTFRuta.setText(this.metodos.getDirectorioExportacion() + "Planilla");
        this.JYCAno.setValue(Integer.valueOf(this.metodos.formatoANO.format(this.metodos.getFechaActual())).intValue());
        cargarComboPeriodo();
        this.JCBTipoInforme.removeAllItems();
        List<Object[]> idTipoInforme = this.tipodeInformesDAO.listaTipoInformesFiltrado(0);
        if (!idTipoInforme.isEmpty()) {
            this.idTIpoInforme = new String[idTipoInforme.size()];
            for (int i = 0; i < idTipoInforme.size(); i++) {
                this.idTIpoInforme[i] = idTipoInforme.get(i)[0].toString();
                this.JCBTipoInforme.addItem(idTipoInforme.get(i)[1]);
            }
        }
        crearModeloDatos();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearModeloDatos() {
        this.modelo = new DefaultTableModel(new Object[0], new String[]{"Año", "Mes", "Codigo_Prestador", "Codigo_Concepto", "Nombre_Concepto", "Vigencia_Actual"}) { // from class: com.genoma.plus.controller.contabilidad.JIFInformesVariosContabilidad.6
            Class[] types = {String.class, String.class, String.class, String.class, String.class, Double.class};
            boolean[] canEdit = {false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTBDetalle.setModel(this.modelo);
        JTable jTable = this.JTBDetalle;
        JTable jTable2 = this.JTBDetalle;
        jTable.setAutoResizeMode(0);
        this.JTBDetalle.doLayout();
        this.JTBDetalle.getColumnModel().getColumn(0).setPreferredWidth(50);
        this.JTBDetalle.getColumnModel().getColumn(1).setPreferredWidth(50);
        this.JTBDetalle.getColumnModel().getColumn(2).setPreferredWidth(120);
        this.JTBDetalle.getColumnModel().getColumn(3).setPreferredWidth(120);
        this.JTBDetalle.getColumnModel().getColumn(4).setPreferredWidth(500);
        this.JTBDetalle.getColumnModel().getColumn(5).setPreferredWidth(100);
    }

    private void llenarTablaDatos() {
        crearModeloDatos();
        List<Object[]> listaResultado = this.informesVariosContabilidadDAO.listadoInformeContraloria(String.valueOf(this.JYCAno.getValue()), this.idPeriodo[this.JCBPeriodo.getSelectedIndex()][2].substring(3, 5), Principal.informacionIps.getCodigoOrganismo(), this.idPeriodo[this.JCBPeriodo.getSelectedIndex()][0], this.idTIpoInforme[this.JCBTipoInforme.getSelectedIndex()]);
        if (!listaResultado.isEmpty()) {
            this.metodos.mEstablecerTextEditor(this.JTBDetalle, 4);
            for (int i = 0; i < listaResultado.size(); i++) {
                this.modelo.addRow(this.dato);
                this.modelo.setValueAt(listaResultado.get(i)[0], i, 0);
                this.modelo.setValueAt(listaResultado.get(i)[1], i, 1);
                this.modelo.setValueAt(listaResultado.get(i)[2], i, 2);
                this.modelo.setValueAt(listaResultado.get(i)[3], i, 3);
                this.modelo.setValueAt(listaResultado.get(i)[4], i, 4);
                this.modelo.setValueAt(listaResultado.get(i)[5], i, 5);
            }
        }
    }

    public void buscar() {
        if (this.JCBPeriodo.getSelectedIndex() != -1) {
            if (this.JCBTipoInforme.getSelectedIndex() != -1) {
                llenarTablaDatos();
                return;
            } else {
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un tipo de informe", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                this.JCBTipoInforme.requestFocus();
                return;
            }
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un periodo", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
        this.JCBPeriodo.requestFocus();
    }
}
