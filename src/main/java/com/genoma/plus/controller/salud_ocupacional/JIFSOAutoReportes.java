package com.genoma.plus.controller.salud_ocupacional;

import Utilidades.Metodos;
import com.genoma.plus.dao.impl.salud_ocupacional.InformeSaludOcupacionalDAOImpl;
import com.genoma.plus.dao.salud_ocupacional.InformeSaludOcupacionalDAO;
import com.genoma.plus.dto.gcuenta.GCGenericoDTO;
import com.genoma.plus.dto.salud_ocupacional.AutoReporteDTO;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
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

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/salud_ocupacional/JIFSOAutoReportes.class */
public class JIFSOAutoReportes extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private Object[] xDato;
    private String[] xIdAutoReporte;
    private Metodos xmt = new Metodos();
    private boolean xlleno = false;
    private InformeSaludOcupacionalDAO InformeSaludOcupacionalDAO;
    private JButton JBTGenerar;
    private JComboBox JCBGenerico;
    private JDateChooser JDFechaF;
    private JDateChooser JDFechaI;
    private JPanel JPIDatos;
    private JScrollPane JSDetalle;
    private JTable JTDetalle;
    private JTextField JTFRuta;

    public JIFSOAutoReportes() {
        initComponents();
        springStart();
        mNuevo();
    }

    private void springStart() {
        this.InformeSaludOcupacionalDAO = (InformeSaludOcupacionalDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("informeSaludOcupacionalDAO");
    }

    public void mNuevo() {
        this.xlleno = false;
        this.JDFechaI.setDate(this.xmt.getFechaActual());
        this.JDFechaF.setDate(this.xmt.getFechaActual());
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
        mCrearTabla();
        this.xlleno = true;
    }

    public void mBuscar() {
        if (this.JCBGenerico.getSelectedIndex() != -1) {
            mBuscaDatos();
        }
    }

    private void mLLenarCombo() {
        this.JCBGenerico.removeAllItems();
        List<GCGenericoDTO> list1 = this.InformeSaludOcupacionalDAO.listTipoCuestionario(this.xmt.formatoAMD1.format(this.JDFechaI.getDate()), this.xmt.formatoAMD1.format(this.JDFechaF.getDate()));
        this.xIdAutoReporte = new String[list1.size()];
        for (int x = 0; x < list1.size(); x++) {
            this.xIdAutoReporte[x] = String.valueOf(list1.get(x).getId());
            this.JCBGenerico.addItem(list1.get(x).getNombre());
        }
        this.JCBGenerico.setSelectedIndex(-1);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTabla() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Fecha", "Identificacion", "No. Documento", "Usuario", "Sexo", "Edad", "Unidad de Negocio", "Tipo de Empresa", "Empresa", "Calificación", "Riesgo o Concepto"}) { // from class: com.genoma.plus.controller.salud_ocupacional.JIFSOAutoReportes.1
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Double.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false};

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
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(350);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(200);
    }

    private void mBuscaDatos() {
        List<AutoReporteDTO> list = this.InformeSaludOcupacionalDAO.listAutoReporteDetalle(this.xmt.formatoAMD1.format(this.JDFechaI.getDate()), this.xmt.formatoAMD1.format(this.JDFechaF.getDate()), this.xIdAutoReporte[this.JCBGenerico.getSelectedIndex()]);
        mCrearTabla();
        for (int x = 0; x < list.size(); x++) {
            this.xmodelo.addRow(this.xDato);
            this.xmodelo.setValueAt(list.get(x).getFechaR(), x, 0);
            this.xmodelo.setValueAt(list.get(x).getIdentificacion(), x, 1);
            this.xmodelo.setValueAt(list.get(x).getNDocumento(), x, 2);
            this.xmodelo.setValueAt(list.get(x).getNUsuario(), x, 3);
            this.xmodelo.setValueAt(list.get(x).getSexo(), x, 4);
            this.xmodelo.setValueAt(list.get(x).getEdad(), x, 5);
            this.xmodelo.setValueAt(list.get(x).getUnidadNegocio(), x, 6);
            this.xmodelo.setValueAt(list.get(x).getTipoEmpresa(), x, 7);
            this.xmodelo.setValueAt(list.get(x).getNEmpresFactura(), x, 8);
            this.xmodelo.setValueAt(list.get(x).getResultadoTexto(), x, 10);
            this.xmodelo.setValueAt(list.get(x).getTc(), x, 9);
        }
    }

    /* JADX WARN: Type inference failed for: r3v39, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPIDatos = new JPanel();
        this.JDFechaI = new JDateChooser();
        this.JDFechaF = new JDateChooser();
        this.JCBGenerico = new JComboBox();
        this.JBTGenerar = new JButton();
        this.JTFRuta = new JTextField();
        this.JSDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("INFORME DE AUTOREPORTES");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjifsoautoreportes");
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JDFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicial", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFechaI.setFont(new Font("Arial", 1, 12));
        this.JDFechaI.addFocusListener(new FocusAdapter() { // from class: com.genoma.plus.controller.salud_ocupacional.JIFSOAutoReportes.2
            public void focusLost(FocusEvent evt) {
                JIFSOAutoReportes.this.JDFechaIFocusLost(evt);
            }
        });
        this.JDFechaI.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.salud_ocupacional.JIFSOAutoReportes.3
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFSOAutoReportes.this.JDFechaIPropertyChange(evt);
            }
        });
        this.JDFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Final", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFechaF.setFont(new Font("Arial", 1, 12));
        this.JDFechaF.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.salud_ocupacional.JIFSOAutoReportes.4
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFSOAutoReportes.this.JDFechaFPropertyChange(evt);
            }
        });
        this.JCBGenerico.setFont(new Font("Arial", 1, 12));
        this.JCBGenerico.setBorder(BorderFactory.createTitledBorder((Border) null, "Cuestionarios", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBGenerico.addItemListener(new ItemListener() { // from class: com.genoma.plus.controller.salud_ocupacional.JIFSOAutoReportes.5
            public void itemStateChanged(ItemEvent evt) {
                JIFSOAutoReportes.this.JCBGenericoItemStateChanged(evt);
            }
        });
        this.JCBGenerico.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.salud_ocupacional.JIFSOAutoReportes.6
            public void actionPerformed(ActionEvent evt) {
                JIFSOAutoReportes.this.JCBGenericoActionPerformed(evt);
            }
        });
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addComponent(this.JDFechaI, -2, 111, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JDFechaF, -2, 114, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBGenerico, 0, -1, 32767).addContainerGap()));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosLayout.createSequentialGroup().addContainerGap(-1, 32767).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JDFechaI, -2, 50, -2).addComponent(this.JDFechaF, -2, 50, -2)).addComponent(this.JCBGenerico, -2, 50, -2)).addContainerGap()));
        this.JBTGenerar.setFont(new Font("Arial", 1, 12));
        this.JBTGenerar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTGenerar.setText("Exportar");
        this.JBTGenerar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.salud_ocupacional.JIFSOAutoReportes.7
            public void actionPerformed(ActionEvent evt) {
                JIFSOAutoReportes.this.JBTGenerarActionPerformed(evt);
            }
        });
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\\\Genoma\\\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ruta", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.salud_ocupacional.JIFSOAutoReportes.8
            public void mouseClicked(MouseEvent evt) {
                JIFSOAutoReportes.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JSDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setSelectionBackground(Color.white);
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JSDetalle.setViewportView(this.JTDetalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSDetalle, -1, 877, 32767).addGroup(layout.createSequentialGroup().addComponent(this.JTFRuta).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTGenerar, -2, 189, -2)).addComponent(this.JPIDatos, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSDetalle, -2, 326, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.JBTGenerar, -1, 55, 32767).addGap(1, 1, 1)).addComponent(this.JTFRuta, -2, 50, -2)).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaIFocusLost(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaIPropertyChange(PropertyChangeEvent evt) {
        if (this.xlleno) {
            mLLenarCombo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaFPropertyChange(PropertyChangeEvent evt) {
        if (this.xlleno) {
            mLLenarCombo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBGenericoItemStateChanged(ItemEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBGenericoActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTGenerarActionPerformed(ActionEvent evt) {
        if (this.JTDetalle.getRowCount() != -1) {
            int x = JOptionPane.showConfirmDialog(this, "Esta seguro de exportar?", "CONFIRMACIÓN", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTDetalle, this.JTFRuta.getText(), getTitle());
            }
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
}
