package com.genoma.plus.controller.sig;

import Utilidades.Metodos;
import com.genoma.plus.dao.impl.sig.ReportesProduccionPorSedeDA0Impl;
import com.genoma.plus.dao.sig.ReportesProduccionPorSedeDAO;
import com.genoma.plus.dto.sig.ReportesProduccionPorSedeDTO;
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

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/sig/JIFReportesProduccionPorSede.class */
public class JIFReportesProduccionPorSede extends JInternalFrame {
    private ReportesProduccionPorSedeDAO objectDAO;
    private ReportesProduccionPorSedeDTO objectDTO;
    private ReportesProduccionPorSedeDA0Impl objectDAOImpl;
    private DefaultTableModel xmodelo;
    private Object[] dato;
    private Metodos metodos = new Metodos();
    private boolean llleno = false;
    private List xidEmpresa;
    private String idEmpresa;
    private String idSede;
    List<Object[]> listaEmpresas;
    List<Object[]> listaSedes;
    private JButton JBTGenerar;
    private JComboBox JCBEmpresa;
    private JComboBox JCBSede;
    private JDateChooser JDCFechaFin;
    private JDateChooser JDCFechaInicio;
    private JPanel JPI_DatosFiltro;
    private JScrollPane JSP_Detalle;
    private JTable JTBDetalle;
    private JTextField JTFRuta;

    public JIFReportesProduccionPorSede() {
        springStart();
        initComponents();
        nuevo();
    }

    /* JADX WARN: Type inference failed for: r3v30, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPI_DatosFiltro = new JPanel();
        this.JDCFechaInicio = new JDateChooser();
        this.JDCFechaFin = new JDateChooser();
        this.JCBEmpresa = new JComboBox();
        this.JCBSede = new JComboBox();
        this.JSP_Detalle = new JScrollPane();
        this.JTBDetalle = new JTable();
        this.JTFRuta = new JTextField();
        this.JBTGenerar = new JButton();
        setClosable(true);
        setIconifiable(true);
        setTitle("Reportes Produccion Por Sede");
        setName("jIFReportesProduccionPorSede");
        this.JPI_DatosFiltro.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JDCFechaInicio.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha(1)", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFechaInicio.setDateFormatString("dd/MM/yyyy");
        this.JDCFechaInicio.setFont(new Font("Arial", 1, 12));
        this.JDCFechaInicio.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.sig.JIFReportesProduccionPorSede.1
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFReportesProduccionPorSede.this.JDCFechaInicioPropertyChange(evt);
            }
        });
        this.JDCFechaFin.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha(2)", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFechaFin.setDateFormatString("dd/MM/yyyy");
        this.JDCFechaFin.setFont(new Font("Arial", 1, 12));
        this.JDCFechaFin.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.sig.JIFReportesProduccionPorSede.2
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFReportesProduccionPorSede.this.JDCFechaFinPropertyChange(evt);
            }
        });
        this.JCBEmpresa.setFont(new Font("Arial", 1, 12));
        this.JCBEmpresa.setBorder(BorderFactory.createTitledBorder((Border) null, "Empresa", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBSede.setFont(new Font("Arial", 1, 12));
        this.JCBSede.setBorder(BorderFactory.createTitledBorder((Border) null, "Sede", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPI_DatosFiltroLayout = new GroupLayout(this.JPI_DatosFiltro);
        this.JPI_DatosFiltro.setLayout(JPI_DatosFiltroLayout);
        JPI_DatosFiltroLayout.setHorizontalGroup(JPI_DatosFiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DatosFiltroLayout.createSequentialGroup().addContainerGap().addComponent(this.JDCFechaInicio, -2, 125, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JDCFechaFin, -2, 125, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBSede, -2, 246, -2).addGap(18, 18, 18).addComponent(this.JCBEmpresa, -2, 417, -2).addContainerGap(-1, 32767)));
        JPI_DatosFiltroLayout.setVerticalGroup(JPI_DatosFiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DatosFiltroLayout.createSequentialGroup().addContainerGap().addGroup(JPI_DatosFiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPI_DatosFiltroLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JDCFechaInicio, -1, 53, 32767).addComponent(this.JDCFechaFin, -1, -1, 32767)).addGroup(GroupLayout.Alignment.TRAILING, JPI_DatosFiltroLayout.createSequentialGroup().addGap(0, 0, 32767).addGroup(JPI_DatosFiltroLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBEmpresa, -2, 51, -2).addComponent(this.JCBSede, -2, 51, -2)))).addContainerGap()));
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
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.sig.JIFReportesProduccionPorSede.3
            public void mouseClicked(MouseEvent evt) {
                JIFReportesProduccionPorSede.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBTGenerar.setFont(new Font("Arial", 1, 12));
        this.JBTGenerar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTGenerar.setText("Exportar");
        this.JBTGenerar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.sig.JIFReportesProduccionPorSede.4
            public void actionPerformed(ActionEvent evt) {
                JIFReportesProduccionPorSede.this.JBTGenerarActionPerformed(evt);
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
            if (validarCampos()) {
                mLLenarCEmpresa();
                mLLenarCSede();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDCFechaFinPropertyChange(PropertyChangeEvent evt) {
        if (this.llleno) {
            iniciarEncabezadoModelo();
            if (validarCampos()) {
                mLLenarCEmpresa();
                mLLenarCSede();
            }
        }
    }

    private void springStart() {
        this.objectDAO = (ReportesProduccionPorSedeDA0Impl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("reportesCamu633DA0Impl");
    }

    public void nuevo() {
        this.llleno = false;
        this.JTFRuta.setText(this.metodos.getDirectorioExportacion() + "Planilla");
        this.JDCFechaInicio.setDate(this.metodos.getFechaActual());
        this.JDCFechaFin.setDate(this.metodos.getFechaActual());
        mLLenarCEmpresa();
        mLLenarCSede();
        iniciarEncabezadoModelo();
        this.llleno = true;
    }

    private void crearModeloDatos() {
        this.xmodelo = new DefaultTableModel((Object[][]) null, new String[]{"Id", "Nombre Convenio", "Id Orden", "Id Ingreso", "id Tipo Fin Procedimiento", "Finalidad Procedimiento", "Fecha Ingreso", "Fecha Egreso", "Id Profesional", "Nombre Profesional", "Id Procedimiento", "Codigo Homologado", "Codigo Real", "Nombre del Procedimiento", "Cantidad", "Valor Unitario", "Id Persona", "Nombre del Usuario", "Id Tipo de Identificacion", "Numero de Documento", "Id Sexo", "Edad", "Tipo de Edad", "Id Dx Principal", "Id Dx relacionado 1", "Id dx Relacionado 2", "Id Dx relacionado 3", "Sede", "Peso", "Talla", "Semanas de Gestacion", "Usuario del Sistema", "Fecha del Ingreso", "Id Tipo de Regimen"}) { // from class: com.genoma.plus.controller.sig.JIFReportesProduccionPorSede.5
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTBDetalle.setModel(this.xmodelo);
        JTable jTable = this.JTBDetalle;
        JTable jTable2 = this.JTBDetalle;
        jTable.setAutoResizeMode(0);
        this.JTBDetalle.doLayout();
        this.JTBDetalle.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTBDetalle.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTBDetalle.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTBDetalle.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTBDetalle.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTBDetalle.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTBDetalle.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTBDetalle.getColumnModel().getColumn(7).setPreferredWidth(100);
        this.JTBDetalle.getColumnModel().getColumn(8).setPreferredWidth(100);
        this.JTBDetalle.getColumnModel().getColumn(9).setPreferredWidth(100);
        this.JTBDetalle.getColumnModel().getColumn(10).setPreferredWidth(100);
        this.JTBDetalle.getColumnModel().getColumn(11).setPreferredWidth(100);
        this.JTBDetalle.getColumnModel().getColumn(12).setPreferredWidth(100);
        this.JTBDetalle.getColumnModel().getColumn(13).setPreferredWidth(100);
        this.JTBDetalle.getColumnModel().getColumn(14).setPreferredWidth(100);
        this.JTBDetalle.getColumnModel().getColumn(15).setPreferredWidth(100);
        this.JTBDetalle.getColumnModel().getColumn(16).setPreferredWidth(100);
        this.JTBDetalle.getColumnModel().getColumn(17).setPreferredWidth(100);
        this.JTBDetalle.getColumnModel().getColumn(18).setPreferredWidth(100);
        this.JTBDetalle.getColumnModel().getColumn(19).setPreferredWidth(100);
        this.JTBDetalle.getColumnModel().getColumn(20).setPreferredWidth(100);
        this.JTBDetalle.getColumnModel().getColumn(21).setPreferredWidth(100);
        this.JTBDetalle.getColumnModel().getColumn(22).setPreferredWidth(100);
        this.JTBDetalle.getColumnModel().getColumn(23).setPreferredWidth(100);
        this.JTBDetalle.getColumnModel().getColumn(24).setPreferredWidth(100);
        this.JTBDetalle.getColumnModel().getColumn(25).setPreferredWidth(100);
        this.JTBDetalle.getColumnModel().getColumn(26).setPreferredWidth(100);
        this.JTBDetalle.getColumnModel().getColumn(27).setPreferredWidth(100);
        this.JTBDetalle.getColumnModel().getColumn(28).setPreferredWidth(100);
        this.JTBDetalle.getColumnModel().getColumn(29).setPreferredWidth(100);
        this.JTBDetalle.getColumnModel().getColumn(30).setPreferredWidth(100);
        this.JTBDetalle.getColumnModel().getColumn(31).setPreferredWidth(100);
        this.JTBDetalle.getColumnModel().getColumn(32).setPreferredWidth(100);
        this.JTBDetalle.getColumnModel().getColumn(33).setPreferredWidth(100);
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

    private ReportesProduccionPorSedeDTO LlenarDTO() {
        ReportesProduccionPorSedeDTO objectDTO = new ReportesProduccionPorSedeDTO();
        objectDTO.setFechaInicio(this.metodos.formatoAMD1.format(this.JDCFechaInicio.getDate()));
        objectDTO.setFechaFin(this.metodos.formatoAMD1.format(this.JDCFechaFin.getDate()));
        if (this.JCBEmpresa.getSelectedIndex() != -1) {
            objectDTO.setIdEmpresa(Integer.parseInt(this.listaEmpresas.get(this.JCBEmpresa.getSelectedIndex())[0].toString()));
        } else {
            objectDTO.setIdEmpresa(this.JCBEmpresa.getSelectedIndex());
        }
        if (this.JCBSede.getSelectedIndex() != -1) {
            objectDTO.setIdSede(Integer.parseInt(this.listaSedes.get(this.JCBSede.getSelectedIndex())[0].toString()));
        } else {
            objectDTO.setIdSede(this.JCBSede.getSelectedIndex());
        }
        return objectDTO;
    }

    private void mLLenarCEmpresa() {
        this.JCBEmpresa.removeAllItems();
        LlenarDTO();
        this.listaEmpresas = null;
        this.listaEmpresas = this.objectDAO.listarEmpresasPorFechas(LlenarDTO());
        if (!this.listaEmpresas.isEmpty() && this.listaEmpresas != null) {
            for (int i = 0; i < this.listaEmpresas.size(); i++) {
                this.JCBEmpresa.addItem(this.listaEmpresas.get(i)[1]);
            }
        }
        this.JCBEmpresa.setSelectedIndex(-1);
    }

    private void mLLenarCSede() {
        this.JCBSede.removeAllItems();
        LlenarDTO();
        this.listaSedes = null;
        this.listaSedes = this.objectDAO.listarSedesPorFechas(LlenarDTO());
        if (!this.listaSedes.isEmpty() && this.listaSedes != null) {
            for (int i = 0; i < this.listaSedes.size(); i++) {
                this.JCBSede.addItem(this.listaSedes.get(i)[1]);
            }
        }
        this.JCBSede.setSelectedIndex(-1);
    }

    private void llenarTablaDatos() {
        if (validarCampos()) {
            crearModeloDatos();
            List<Object[]> listaResultado = null;
            if (this.JCBEmpresa.getSelectedIndex() != -1 && this.JCBSede.getSelectedIndex() != -1) {
                listaResultado = this.objectDAO.listarPorIdSedeyEmpresa(LlenarDTO());
            } else if (this.JCBEmpresa.getSelectedIndex() != -1 && this.JCBSede.getSelectedIndex() == -1) {
                listaResultado = this.objectDAO.listarPorIdEmpresa(LlenarDTO());
            } else if (this.JCBEmpresa.getSelectedIndex() == -1 && this.JCBSede.getSelectedIndex() != -1) {
                listaResultado = this.objectDAO.listarPorIdSede(LlenarDTO());
            } else if (this.JCBEmpresa.getSelectedIndex() == -1 && this.JCBSede.getSelectedIndex() == -1) {
                listaResultado = this.objectDAO.listar(LlenarDTO());
            }
            if (!listaResultado.isEmpty() && listaResultado != null) {
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
                    this.xmodelo.setValueAt(listaResultado.get(i)[9], i, 9);
                    this.xmodelo.setValueAt(listaResultado.get(i)[10], i, 10);
                    this.xmodelo.setValueAt(listaResultado.get(i)[11], i, 11);
                    this.xmodelo.setValueAt(listaResultado.get(i)[12], i, 12);
                    this.xmodelo.setValueAt(listaResultado.get(i)[13], i, 13);
                    this.xmodelo.setValueAt(listaResultado.get(i)[14], i, 14);
                    this.xmodelo.setValueAt(listaResultado.get(i)[15], i, 15);
                    this.xmodelo.setValueAt(listaResultado.get(i)[16], i, 16);
                    this.xmodelo.setValueAt(listaResultado.get(i)[17], i, 17);
                    this.xmodelo.setValueAt(listaResultado.get(i)[18], i, 18);
                    this.xmodelo.setValueAt(listaResultado.get(i)[19], i, 19);
                    this.xmodelo.setValueAt(listaResultado.get(i)[20], i, 20);
                    this.xmodelo.setValueAt(listaResultado.get(i)[21], i, 21);
                    this.xmodelo.setValueAt(listaResultado.get(i)[22], i, 22);
                    this.xmodelo.setValueAt(listaResultado.get(i)[23], i, 23);
                    this.xmodelo.setValueAt(listaResultado.get(i)[24], i, 24);
                    this.xmodelo.setValueAt(listaResultado.get(i)[25], i, 25);
                    this.xmodelo.setValueAt(listaResultado.get(i)[26], i, 26);
                    this.xmodelo.setValueAt(listaResultado.get(i)[27], i, 27);
                    this.xmodelo.setValueAt(listaResultado.get(i)[28], i, 28);
                    this.xmodelo.setValueAt(listaResultado.get(i)[29], i, 29);
                    this.xmodelo.setValueAt(listaResultado.get(i)[30], i, 30);
                    this.xmodelo.setValueAt(listaResultado.get(i)[31], i, 31);
                    this.xmodelo.setValueAt(listaResultado.get(i)[32], i, 32);
                    this.xmodelo.setValueAt(listaResultado.get(i)[33], i, 33);
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
