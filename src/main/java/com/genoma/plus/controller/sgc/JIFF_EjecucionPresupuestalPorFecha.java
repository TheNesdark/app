package com.genoma.plus.controller.sgc;

import Utilidades.Metodos;
import com.genoma.plus.dao.sgc.EjecucionPresupuestalPorFechaDAO;
import com.genoma.plus.dto.sgc.EjecucionPresupuestalPorFechaDTO;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Dimension;
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
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/sgc/JIFF_EjecucionPresupuestalPorFecha.class */
public class JIFF_EjecucionPresupuestalPorFecha extends JInternalFrame {
    private DefaultTableModel xModelo;
    private Object[] xDato;
    private EjecucionPresupuestalPorFechaDAO dao;
    private List<Object[]> listTipoMovimiento;
    private JButton JBTExportar;
    private JCheckBox JCBFiltro;
    private JComboBox<String> JCBTipoMovimiento;
    private JDateChooser JDFechaF;
    private JDateChooser JDFechaI;
    private JLabel JLBLCont;
    private JPanel JPDatos;
    private JPanel JPExportar;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;
    private JTextField JTFRuta;
    private ButtonGroup buttonGroup1;
    private ButtonGroup buttonGroup2;
    private JPanel jPanel3;
    private Metodos xmt = new Metodos();
    private EjecucionPresupuestalPorFechaDTO dto = new EjecucionPresupuestalPorFechaDTO();
    private Boolean validarFechaI = false;
    private Boolean validarFechaF = false;

    public JIFF_EjecucionPresupuestalPorFecha() {
        initComponents();
        springStart();
        mNuevo();
    }

    private void springStart() {
        this.dao = (EjecucionPresupuestalPorFechaDAO) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("ejecucionPresupuestalPorFechaDAOImpl");
    }

    public void mNuevo() {
        this.JDFechaI.setDate(this.xmt.getFechaActual());
        this.JDFechaF.setDate(this.xmt.getFechaActual());
        mCrearModeloEjecucionPresupuestal();
        mCargarCombo();
        this.JLBLCont.setText("0");
    }

    public void mBuscar() {
        this.dto = new EjecucionPresupuestalPorFechaDTO();
        this.dto.setFechaInicio(this.xmt.formatoAMD.format(this.JDFechaI.getDate()));
        this.dto.setFechaFinal(this.xmt.formatoAMD.format(this.JDFechaF.getDate()));
        this.dto.setFiltroCombo("");
        if (this.JCBFiltro.isSelected()) {
            if (this.JCBTipoMovimiento.getSelectedIndex() != -1) {
                this.dto.setFiltroCombo(this.listTipoMovimiento.get(this.JCBTipoMovimiento.getSelectedIndex())[0].toString());
                mCargarDatosTablaEjecucionPresupuestal();
                return;
            } else {
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un tipo de movimiento \no desmarcar la opción de filtro", "Mensaje", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                return;
            }
        }
        mCargarDatosTablaEjecucionPresupuestal();
    }

    public void mCargarCombo() {
        this.listTipoMovimiento = this.dao.mCargarCombo(this.dto);
        this.JCBTipoMovimiento.removeAllItems();
        for (int i = 0; i < this.listTipoMovimiento.size(); i++) {
            this.JCBTipoMovimiento.addItem(this.listTipoMovimiento.get(i)[1].toString());
        }
        this.JCBTipoMovimiento.setSelectedIndex(-1);
    }

    private void mCrearModeloEjecucionPresupuestal() {
        this.xModelo = new DefaultTableModel((Object[][]) null, new String[]{"FechaD", "NoConcecutivo", "Id_Rubro", "rubro", "No_identificacion", "nombre", "Valor", "Observacion"}) { // from class: com.genoma.plus.controller.sgc.JIFF_EjecucionPresupuestalPorFecha.1
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xModelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(100);
    }

    private void mCargarDatosTablaEjecucionPresupuestal() {
        mCrearModeloEjecucionPresupuestal();
        List<Object[]> list = this.dao.mEjecusionPresupuestal(this.dto);
        for (int x = 0; x < list.size(); x++) {
            this.xModelo.addRow(this.xDato);
            for (int y = 0; y < 8; y++) {
                this.xModelo.setValueAt(list.get(x)[y], x, y);
            }
        }
        this.JLBLCont.setText(list.size() + "");
    }

    /* JADX WARN: Type inference failed for: r3v36, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.buttonGroup1 = new ButtonGroup();
        this.buttonGroup2 = new ButtonGroup();
        this.JPDatos = new JPanel();
        this.JDFechaI = new JDateChooser();
        this.JDFechaF = new JDateChooser();
        this.JCBTipoMovimiento = new JComboBox<>();
        this.JCBFiltro = new JCheckBox();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JPExportar = new JPanel();
        this.JTFRuta = new JTextField();
        this.JBTExportar = new JButton();
        this.jPanel3 = new JPanel();
        this.JLBLCont = new JLabel();
        setClosable(true);
        setIconifiable(true);
        setTitle("Ejecucion presupuestal por fecha");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jiff_EjecucionPresupuestalPorFecha");
        this.JPDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "FILTRO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JPDatos.setPreferredSize(new Dimension(1330, 92));
        this.JDFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicial", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFechaI.setFont(new Font("Arial", 1, 12));
        this.JDFechaI.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.sgc.JIFF_EjecucionPresupuestalPorFecha.2
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFF_EjecucionPresupuestalPorFecha.this.JDFechaIPropertyChange(evt);
            }
        });
        this.JDFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Final", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFechaF.setFont(new Font("Arial", 1, 12));
        this.JDFechaF.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.sgc.JIFF_EjecucionPresupuestalPorFecha.3
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFF_EjecucionPresupuestalPorFecha.this.JDFechaFPropertyChange(evt);
            }
        });
        this.JCBTipoMovimiento.setModel(new DefaultComboBoxModel(new String[]{"Item 1", "Item 2", "Item 3", "Item 4"}));
        this.JCBTipoMovimiento.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo de movimiento", 0, 0, new Font("Arial", 1, 12), new Color(0, 51, 255)));
        this.JCBTipoMovimiento.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.sgc.JIFF_EjecucionPresupuestalPorFecha.4
            public void actionPerformed(ActionEvent evt) {
                JIFF_EjecucionPresupuestalPorFecha.this.JCBTipoMovimientoActionPerformed(evt);
            }
        });
        this.JCBFiltro.setText("Filtro por movimiento");
        GroupLayout JPDatosLayout = new GroupLayout(this.JPDatos);
        this.JPDatos.setLayout(JPDatosLayout);
        JPDatosLayout.setHorizontalGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosLayout.createSequentialGroup().addContainerGap().addComponent(this.JDFechaI, -2, 136, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JDFechaF, -2, 136, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBFiltro).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBTipoMovimiento, -2, 504, -2).addGap(0, 0, 0)));
        JPDatosLayout.setVerticalGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosLayout.createSequentialGroup().addGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPDatosLayout.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.JCBFiltro, -2, 45, -2)).addGroup(JPDatosLayout.createSequentialGroup().addGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JDFechaI, -2, 56, -2).addComponent(this.JDFechaF, -2, 56, -2)).addGap(0, 0, 32767)).addComponent(this.JCBTipoMovimiento, GroupLayout.Alignment.TRAILING)).addContainerGap()));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JSPDetalle.setPreferredSize(new Dimension(1330, 426));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setAutoResizeMode(0);
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.JPExportar.setBorder(BorderFactory.createTitledBorder((Border) null, "EXPORTAR", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.sgc.JIFF_EjecucionPresupuestalPorFecha.5
            public void mouseClicked(MouseEvent evt) {
                JIFF_EjecucionPresupuestalPorFecha.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JTFRuta.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.sgc.JIFF_EjecucionPresupuestalPorFecha.6
            public void actionPerformed(ActionEvent evt) {
                JIFF_EjecucionPresupuestalPorFecha.this.JTFRutaActionPerformed(evt);
            }
        });
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setForeground(Color.red);
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.sgc.JIFF_EjecucionPresupuestalPorFecha.7
            public void actionPerformed(ActionEvent evt) {
                JIFF_EjecucionPresupuestalPorFecha.this.JBTExportarActionPerformed(evt);
            }
        });
        GroupLayout JPExportarLayout = new GroupLayout(this.JPExportar);
        this.JPExportar.setLayout(JPExportarLayout);
        JPExportarLayout.setHorizontalGroup(JPExportarLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPExportarLayout.createSequentialGroup().addContainerGap().addComponent(this.JTFRuta, -2, 558, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTExportar, -2, 145, -2).addContainerGap(-1, 32767)));
        JPExportarLayout.setVerticalGroup(JPExportarLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JBTExportar, GroupLayout.Alignment.TRAILING, -2, 48, -2).addComponent(this.JTFRuta, GroupLayout.Alignment.TRAILING, -2, 48, -2));
        this.jPanel3.setBorder(BorderFactory.createTitledBorder((Border) null, "Total de registros", 0, 0, new Font("Dialog", 1, 12), Color.blue));
        this.JLBLCont.setFont(new Font("Arial", 1, 36));
        this.JLBLCont.setHorizontalAlignment(0);
        this.JLBLCont.setText("0");
        GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
        this.jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addComponent(this.JLBLCont, -2, 197, -2).addContainerGap(-1, 32767)));
        jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addComponent(this.JLBLCont).addContainerGap(-1, 32767)));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JSPDetalle, GroupLayout.Alignment.LEADING, -2, 0, 32767).addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup().addComponent(this.JPExportar, -2, -1, -2).addGap(18, 18, 18).addComponent(this.jPanel3, -2, -1, -2)).addComponent(this.JPDatos, -1, 992, 32767)).addGap(0, 0, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.JPDatos, -2, 87, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalle, -1, 378, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JPExportar, -1, -1, 32767).addComponent(this.jPanel3, -1, -1, 32767)).addContainerGap()));
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
        mExportar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBTipoMovimientoActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaFPropertyChange(PropertyChangeEvent evt) {
        if (this.validarFechaI.booleanValue() && this.validarFechaF.booleanValue()) {
            this.dto.setFechaInicio(this.xmt.formatoAMD.format(this.JDFechaI.getDate()));
            this.dto.setFechaFinal(this.xmt.formatoAMD.format(this.JDFechaF.getDate()));
            mCargarCombo();
            return;
        }
        this.validarFechaF = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaIPropertyChange(PropertyChangeEvent evt) {
        if (this.validarFechaI.booleanValue() && this.validarFechaF.booleanValue()) {
            this.dto.setFechaInicio(this.xmt.formatoAMD.format(this.JDFechaI.getDate()));
            this.dto.setFechaFinal(this.xmt.formatoAMD.format(this.JDFechaF.getDate()));
            mCargarCombo();
            return;
        }
        this.validarFechaI = true;
    }

    private void mExportar() {
        if (!this.JTFRuta.getText().isEmpty()) {
            if (this.JTDetalle.getRowCount() != -1) {
                int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMAR", 0, 3, new ImageIcon("src/Imagenes/Question2.png"));
                if (n == 0) {
                    this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTDetalle, this.JTFRuta.getText(), getTitle());
                    return;
                }
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "No existe información para exportar", "VERIFICAR", 1, new ImageIcon("src/Imagenes/Information2.png"));
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un ruta valida", "VERIFICAR", 1, new ImageIcon("src/Imagenes/Information2.png"));
        this.JTFRuta.requestFocus();
    }
}
