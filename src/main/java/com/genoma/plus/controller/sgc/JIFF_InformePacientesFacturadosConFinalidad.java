package com.genoma.plus.controller.sgc;

import Utilidades.Metodos;
import com.genoma.plus.dao.impl.sgc.InformePacientesFacturadosConFinalidadDAOImpl;
import com.genoma.plus.dao.sgc.InformePacientesFacturadosConFinalidadDAO;
import com.genoma.plus.dto.sgc.InformePacientesFacturadosConFinalidadDTO;
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
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
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

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/sgc/JIFF_InformePacientesFacturadosConFinalidad.class */
public class JIFF_InformePacientesFacturadosConFinalidad extends JInternalFrame {
    private DefaultTableModel xModelo;
    private Object[] xDato;
    private Object[] xDatoF;
    private InformePacientesFacturadosConFinalidadDAO xInformePacientesFacturadosConFinalidadDAO;
    private List<Object[]> listConvenio;
    private List<Object[]> listTipoAtencion;
    private Boolean xy;
    private String nombre;
    private JButton JBTExportar;
    private JComboBox<String> JCBConvenio;
    private JComboBox<String> JCBTipoAtencion;
    private JDateChooser JDFechaF;
    private JDateChooser JDFechaI;
    private JLabel JLBLCont;
    private JPanel JPDatos;
    private JPanel JPExportar;
    private JRadioButton JRBAtencion;
    private JRadioButton JRBConvenio;
    private JRadioButton JRBFecha;
    private JRadioButton JRBTodos;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;
    private JTextField JTFRuta;
    private ButtonGroup buttonGroup1;
    private ButtonGroup buttonGroup2;
    private ButtonGroup buttonGroup3;
    private JPanel jPConvenio;
    private JPanel jPConvenio1;
    private JPanel jPOpcion;
    private JPanel jPanel3;
    private Metodos xmt = new Metodos();
    private InformePacientesFacturadosConFinalidadDTO informePacientesFacturadosConFinalidadDTO = new InformePacientesFacturadosConFinalidadDTO();

    public JIFF_InformePacientesFacturadosConFinalidad() {
        this.xy = false;
        initComponents();
        springStart();
        mNuevo();
        this.xy = true;
    }

    private void springStart() {
        this.xInformePacientesFacturadosConFinalidadDAO = (InformePacientesFacturadosConFinalidadDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("informePacientesFacturadosConFinalidadDAOImpl");
    }

    public void mNuevo() {
        this.JDFechaI.setDate(this.xmt.getFechaActual());
        this.JDFechaF.setDate(this.xmt.getFechaActual());
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
        mCrearModeloInformePacientesFacturadosConFinalidad();
        this.JLBLCont.setText("0");
    }

    private void mCrearModeloInformePacientesFacturadosConFinalidad() {
        this.xModelo = new DefaultTableModel((Object[][]) null, new String[]{"Tipo Identificación", "Documento", "Nombre Usuario", "FechaNac", "Edad", "Sexo", "ID Convenio", "Nombre EmpresaConvenio", "Fecha Ingreso", "Nombre Servicio", "ID Codigo", "Nombre Procedimiento", "ID", "Fin Procedimiento", "Cantidad", "Clase Cita", "Tipo Programa", "Tipo ATencion", "Número Factura", "Número Orden", "Estado Armada"}) { // from class: com.genoma.plus.controller.sgc.JIFF_InformePacientesFacturadosConFinalidad.1
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

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
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(12).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(13).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(14).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(15).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(16).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(17).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(18).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(19).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(20).setPreferredWidth(100);
    }

    private void mCargarDatosTablaInformePacientesFacturadosConFinalidadTodos() {
        mCrearModeloInformePacientesFacturadosConFinalidad();
        List<Object[]> list = this.xInformePacientesFacturadosConFinalidadDAO.mInformePacientesFacturadosConFinalidadTodos(this.informePacientesFacturadosConFinalidadDTO);
        for (int x = 0; x < list.size(); x++) {
            this.xModelo.addRow(this.xDato);
            for (int y = 0; y < 21; y++) {
                this.xModelo.setValueAt(list.get(x)[y], x, y);
            }
        }
        this.JLBLCont.setText(list.size() + "");
    }

    private void mCargarDatosTablaInformePacientesFacturadosConFinalidadFecha() {
        mCrearModeloInformePacientesFacturadosConFinalidad();
        List<Object[]> list = this.xInformePacientesFacturadosConFinalidadDAO.mInformePacientesFacturadosConFinalidadFecha(this.informePacientesFacturadosConFinalidadDTO);
        for (int x = 0; x < list.size(); x++) {
            this.xModelo.addRow(this.xDato);
            for (int y = 0; y < 21; y++) {
                this.xModelo.setValueAt(list.get(x)[y], x, y);
            }
        }
        this.JLBLCont.setText(list.size() + "");
    }

    private void mCargarDatosTablaInformePacientesFacturadosConFinalidadConvenio() {
        mCrearModeloInformePacientesFacturadosConFinalidad();
        List<Object[]> list = this.xInformePacientesFacturadosConFinalidadDAO.mInformePacientesFacturadosConFinalidadConvenio(this.informePacientesFacturadosConFinalidadDTO);
        for (int x = 0; x < list.size(); x++) {
            this.xModelo.addRow(this.xDato);
            for (int y = 0; y < 21; y++) {
                this.xModelo.setValueAt(list.get(x)[y], x, y);
            }
        }
        this.JLBLCont.setText(list.size() + "");
    }

    private void mCargarDatosTablaInformePacientesFacturadosConFinalidadTipoAtencion() {
        mCrearModeloInformePacientesFacturadosConFinalidad();
        List<Object[]> list = this.xInformePacientesFacturadosConFinalidadDAO.mInformePacientesFacturadosConFinalidadTipoAtencion(this.informePacientesFacturadosConFinalidadDTO);
        for (int x = 0; x < list.size(); x++) {
            this.xModelo.addRow(this.xDato);
            for (int y = 0; y < 21; y++) {
                this.xModelo.setValueAt(list.get(x)[y], x, y);
            }
        }
        this.JLBLCont.setText(list.size() + "");
    }

    public void mCargarCombo() {
        this.informePacientesFacturadosConFinalidadDTO = new InformePacientesFacturadosConFinalidadDTO();
        this.informePacientesFacturadosConFinalidadDTO.setFechaInicio(this.xmt.formatoAMD.format(this.JDFechaI.getDate()));
        this.informePacientesFacturadosConFinalidadDTO.setFechaFinal(this.xmt.formatoAMD.format(this.JDFechaF.getDate()));
        this.JCBConvenio.removeAllItems();
        this.JCBTipoAtencion.removeAllItems();
        this.listConvenio = this.xInformePacientesFacturadosConFinalidadDAO.mCargarComboConvenio(this.informePacientesFacturadosConFinalidadDTO);
        for (int i = 0; i < this.listConvenio.size(); i++) {
            this.JCBConvenio.addItem(this.listConvenio.get(i)[1].toString());
        }
        this.JCBConvenio.setSelectedIndex(-1);
        this.listTipoAtencion = this.xInformePacientesFacturadosConFinalidadDAO.mCargarComboTipoAtencion(this.informePacientesFacturadosConFinalidadDTO);
        for (int i2 = 0; i2 < this.listTipoAtencion.size(); i2++) {
            this.JCBTipoAtencion.addItem(this.listTipoAtencion.get(i2)[1].toString());
        }
        this.JCBTipoAtencion.setSelectedIndex(-1);
    }

    public void mBuscar() {
        System.out.println("Buscar.... --------------------------");
        this.informePacientesFacturadosConFinalidadDTO = new InformePacientesFacturadosConFinalidadDTO();
        this.informePacientesFacturadosConFinalidadDTO.setFechaInicio(this.xmt.formatoAMD.format(this.JDFechaI.getDate()));
        this.informePacientesFacturadosConFinalidadDTO.setFechaFinal(this.xmt.formatoAMD.format(this.JDFechaF.getDate()));
        if (this.JRBTodos.isSelected()) {
            if (this.JCBConvenio.getSelectedIndex() != -1) {
                if (this.JCBTipoAtencion.getSelectedIndex() != -1) {
                    for (int i = 0; i < this.listConvenio.size(); i++) {
                        if (this.JCBConvenio.getSelectedItem().equals(this.listConvenio.get(i)[1].toString())) {
                            this.informePacientesFacturadosConFinalidadDTO.setFiltroComboConvenio(this.listConvenio.get(i)[0].toString());
                        }
                    }
                    for (int i2 = 0; i2 < this.listTipoAtencion.size(); i2++) {
                        if (this.JCBTipoAtencion.getSelectedItem().equals(this.listTipoAtencion.get(i2)[1].toString())) {
                            this.informePacientesFacturadosConFinalidadDTO.setFiltroComboTipoAtencion(this.listTipoAtencion.get(i2)[0].toString());
                        }
                    }
                    mCargarDatosTablaInformePacientesFacturadosConFinalidadTodos();
                    System.out.println("Todos.... ------- mCargarDatosTablaInformePacientesFacturadosConFinalidadTodos();");
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un Tipo Atencion", "Mensaje", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                mCrearModeloInformePacientesFacturadosConFinalidad();
                this.JLBLCont.setText("0");
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un Convenio", "Mensaje", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            mCrearModeloInformePacientesFacturadosConFinalidad();
            this.JLBLCont.setText("0");
            return;
        }
        if (this.JRBFecha.isSelected()) {
            mCargarDatosTablaInformePacientesFacturadosConFinalidadFecha();
            System.out.println("Fecha.... ------ mCargarDatosTablaInformePacientesFacturadosConFinalidadFecha();");
            return;
        }
        if (this.JRBConvenio.isSelected()) {
            if (this.JCBConvenio.getSelectedIndex() != -1) {
                for (int i3 = 0; i3 < this.listConvenio.size(); i3++) {
                    if (this.JCBConvenio.getSelectedItem().equals(this.listConvenio.get(i3)[1].toString())) {
                        this.informePacientesFacturadosConFinalidadDTO.setFiltroComboConvenio(this.listConvenio.get(i3)[0].toString());
                    }
                }
                mCargarDatosTablaInformePacientesFacturadosConFinalidadConvenio();
                System.out.println("Convenio... ------- mCargarDatosTablaInformePacientesFacturadosConFinalidadConvenio();");
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un Convenio", "Mensaje", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            mCrearModeloInformePacientesFacturadosConFinalidad();
            this.JLBLCont.setText("0");
            return;
        }
        if (this.JRBAtencion.isSelected()) {
            if (this.JCBTipoAtencion.getSelectedIndex() != -1) {
                for (int i4 = 0; i4 < this.listTipoAtencion.size(); i4++) {
                    if (this.JCBTipoAtencion.getSelectedItem().equals(this.listTipoAtencion.get(i4)[1].toString())) {
                        this.informePacientesFacturadosConFinalidadDTO.setFiltroComboTipoAtencion(this.listTipoAtencion.get(i4)[0].toString());
                    }
                }
                mCargarDatosTablaInformePacientesFacturadosConFinalidadTipoAtencion();
                System.out.println("Atencion... ----- mCargarDatosTablaInformePacientesFacturadosConFinalidadTipoAtencion();");
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un Tipo Atencion", "Mensaje", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            mCrearModeloInformePacientesFacturadosConFinalidad();
            this.JLBLCont.setText("0");
        }
    }

    /* JADX WARN: Type inference failed for: r3v57, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.buttonGroup1 = new ButtonGroup();
        this.buttonGroup2 = new ButtonGroup();
        this.buttonGroup3 = new ButtonGroup();
        this.JPDatos = new JPanel();
        this.JDFechaI = new JDateChooser();
        this.JDFechaF = new JDateChooser();
        this.jPOpcion = new JPanel();
        this.JRBTodos = new JRadioButton();
        this.JRBFecha = new JRadioButton();
        this.JRBConvenio = new JRadioButton();
        this.JRBAtencion = new JRadioButton();
        this.jPConvenio = new JPanel();
        this.JCBConvenio = new JComboBox<>();
        this.jPConvenio1 = new JPanel();
        this.JCBTipoAtencion = new JComboBox<>();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JPExportar = new JPanel();
        this.JTFRuta = new JTextField();
        this.JBTExportar = new JButton();
        this.jPanel3 = new JPanel();
        this.JLBLCont = new JLabel();
        setClosable(true);
        setIconifiable(true);
        setTitle("Informe Pacientes facturados con finalidad");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jiff_InformePacientesFacturadosConFinalidad");
        this.JPDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "FILTRO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JPDatos.setPreferredSize(new Dimension(1330, 92));
        this.JDFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicial", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFechaI.setFont(new Font("Arial", 1, 12));
        this.JDFechaI.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.sgc.JIFF_InformePacientesFacturadosConFinalidad.2
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFF_InformePacientesFacturadosConFinalidad.this.JDFechaIPropertyChange(evt);
            }
        });
        this.JDFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Final", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFechaF.setFont(new Font("Arial", 1, 12));
        this.JDFechaF.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.sgc.JIFF_InformePacientesFacturadosConFinalidad.3
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFF_InformePacientesFacturadosConFinalidad.this.JDFechaFPropertyChange(evt);
            }
        });
        this.jPOpcion.setBorder(BorderFactory.createTitledBorder((Border) null, "Filtros", 0, 0, new Font("Dialog", 1, 12), new Color(0, 0, 255)));
        this.buttonGroup1.add(this.JRBTodos);
        this.JRBTodos.setSelected(true);
        this.JRBTodos.setText("Todo");
        this.buttonGroup1.add(this.JRBFecha);
        this.JRBFecha.setText("Fecha");
        this.buttonGroup1.add(this.JRBConvenio);
        this.JRBConvenio.setText("Convenio");
        this.buttonGroup1.add(this.JRBAtencion);
        this.JRBAtencion.setText("Tipo Atencion");
        GroupLayout jPOpcionLayout = new GroupLayout(this.jPOpcion);
        this.jPOpcion.setLayout(jPOpcionLayout);
        jPOpcionLayout.setHorizontalGroup(jPOpcionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPOpcionLayout.createSequentialGroup().addContainerGap().addComponent(this.JRBTodos).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED, -1, 32767).addComponent(this.JRBFecha).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED, -1, 32767).addComponent(this.JRBConvenio).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED, -1, 32767).addComponent(this.JRBAtencion)));
        jPOpcionLayout.setVerticalGroup(jPOpcionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPOpcionLayout.createSequentialGroup().addGap(0, 0, 0).addGroup(jPOpcionLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBTodos).addComponent(this.JRBFecha).addComponent(this.JRBConvenio).addComponent(this.JRBAtencion)).addGap(0, 0, 32767)));
        this.jPConvenio.setBorder(BorderFactory.createTitledBorder((Border) null, "Convenios", 0, 0, new Font("Dialog", 1, 12), new Color(0, 0, 255)));
        this.JCBConvenio.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.sgc.JIFF_InformePacientesFacturadosConFinalidad.4
            public void actionPerformed(ActionEvent evt) {
                JIFF_InformePacientesFacturadosConFinalidad.this.JCBConvenioActionPerformed(evt);
            }
        });
        GroupLayout jPConvenioLayout = new GroupLayout(this.jPConvenio);
        this.jPConvenio.setLayout(jPConvenioLayout);
        jPConvenioLayout.setHorizontalGroup(jPConvenioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBConvenio, GroupLayout.Alignment.TRAILING, 0, 693, 32767));
        jPConvenioLayout.setVerticalGroup(jPConvenioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBConvenio, -2, 36, -2));
        this.jPConvenio1.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Atencion", 0, 0, new Font("Dialog", 1, 12), new Color(0, 0, 255)));
        this.JCBTipoAtencion.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.sgc.JIFF_InformePacientesFacturadosConFinalidad.5
            public void actionPerformed(ActionEvent evt) {
                JIFF_InformePacientesFacturadosConFinalidad.this.JCBTipoAtencionActionPerformed(evt);
            }
        });
        GroupLayout jPConvenio1Layout = new GroupLayout(this.jPConvenio1);
        this.jPConvenio1.setLayout(jPConvenio1Layout);
        jPConvenio1Layout.setHorizontalGroup(jPConvenio1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBTipoAtencion, GroupLayout.Alignment.TRAILING, 0, 693, 32767));
        jPConvenio1Layout.setVerticalGroup(jPConvenio1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBTipoAtencion, -2, 36, -2));
        GroupLayout JPDatosLayout = new GroupLayout(this.JPDatos);
        this.JPDatos.setLayout(JPDatosLayout);
        JPDatosLayout.setHorizontalGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosLayout.createSequentialGroup().addGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosLayout.createSequentialGroup().addGap(45, 45, 45).addComponent(this.JDFechaI, -2, 136, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JDFechaF, -2, 136, -2).addGap(107, 107, 107)).addGroup(JPDatosLayout.createSequentialGroup().addContainerGap().addComponent(this.jPOpcion, -1, -1, 32767))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPConvenio, GroupLayout.Alignment.TRAILING, -2, -1, -2).addComponent(this.jPConvenio1, GroupLayout.Alignment.TRAILING, -2, -1, -2)).addGap(0, 0, 0)));
        JPDatosLayout.setVerticalGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPDatosLayout.createSequentialGroup().addGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(GroupLayout.Alignment.LEADING, JPDatosLayout.createSequentialGroup().addGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JDFechaF, -1, 59, 32767).addComponent(this.JDFechaI, -1, -1, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.jPOpcion, -1, -1, 32767)).addGroup(JPDatosLayout.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.jPConvenio, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPConvenio1, -2, -1, -2))).addGap(26, 26, 26)));
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
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.sgc.JIFF_InformePacientesFacturadosConFinalidad.6
            public void mouseClicked(MouseEvent evt) {
                JIFF_InformePacientesFacturadosConFinalidad.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JTFRuta.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.sgc.JIFF_InformePacientesFacturadosConFinalidad.7
            public void actionPerformed(ActionEvent evt) {
                JIFF_InformePacientesFacturadosConFinalidad.this.JTFRutaActionPerformed(evt);
            }
        });
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setForeground(Color.red);
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.sgc.JIFF_InformePacientesFacturadosConFinalidad.8
            public void actionPerformed(ActionEvent evt) {
                JIFF_InformePacientesFacturadosConFinalidad.this.JBTExportarActionPerformed(evt);
            }
        });
        GroupLayout JPExportarLayout = new GroupLayout(this.JPExportar);
        this.JPExportar.setLayout(JPExportarLayout);
        JPExportarLayout.setHorizontalGroup(JPExportarLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPExportarLayout.createSequentialGroup().addContainerGap().addComponent(this.JTFRuta, -2, 560, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 48, 32767).addComponent(this.JBTExportar, -2, 145, -2).addGap(43, 43, 43)));
        JPExportarLayout.setVerticalGroup(JPExportarLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JBTExportar, GroupLayout.Alignment.TRAILING, -2, 48, -2).addComponent(this.JTFRuta, GroupLayout.Alignment.TRAILING, -2, 48, -2));
        this.jPanel3.setBorder(BorderFactory.createTitledBorder((Border) null, "Total de registros", 0, 0, new Font("Dialog", 1, 12), Color.blue));
        this.JLBLCont.setFont(new Font("Arial", 1, 36));
        this.JLBLCont.setHorizontalAlignment(0);
        this.JLBLCont.setText("0");
        GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
        this.jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addGap(40, 40, 40).addComponent(this.JLBLCont, -2, 197, -2).addContainerGap(56, 32767)));
        jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addComponent(this.JLBLCont).addContainerGap(-1, 32767)));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.JPExportar, -2, -1, -2).addGap(28, 28, 28).addComponent(this.jPanel3, -1, -1, 32767)).addComponent(this.JPDatos, -1, 1149, 32767).addComponent(this.JSPDetalle, -2, 0, 32767));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.JPDatos, -2, 153, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JSPDetalle, -2, 323, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JPExportar, -1, -1, 32767).addComponent(this.jPanel3, -1, -1, 32767)).addContainerGap()));
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
    public void JTFRutaActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBTipoAtencionActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBConvenioActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaFPropertyChange(PropertyChangeEvent evt) {
        if (this.xy.booleanValue()) {
            mCargarCombo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaIPropertyChange(PropertyChangeEvent evt) {
        if (this.xy.booleanValue()) {
            mCargarCombo();
        }
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
