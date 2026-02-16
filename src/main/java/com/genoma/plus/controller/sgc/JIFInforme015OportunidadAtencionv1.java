package com.genoma.plus.controller.sgc;

import Utilidades.Metodos;
import com.genoma.plus.dao.impl.sgc.SGC_Informe015OportunidadAtencionDAOImpl;
import com.genoma.plus.dao.sgc.SGC_Informe015OportunidadAtencioDAO;
import com.genoma.plus.dto.sgc.SGC_Informe015OportunidadAtencionDTO;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
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

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/sgc/JIFInforme015OportunidadAtencionv1.class */
public class JIFInforme015OportunidadAtencionv1 extends JInternalFrame {
    private File xfile;
    private DefaultTableModel xmodelo;
    private Object[] xdato;
    private SGC_Informe015OportunidadAtencioDAO sGC_Informe015OportunidadAtencioDAO;
    List<Object[]> ListadoEmpresa;
    private JButton JBTExportar;
    public JComboBox JCB_Empresa;
    private JCheckBox JCH_Empresa;
    private JDateChooser JDFFechaF;
    private JDateChooser JDFFechaI;
    private JPanel JPI_Encabezado;
    private JPanel JPI_Exportar;
    private JScrollPane JSP_Detalle;
    private JTable JTB_Detalle;
    private JTextField JTFRuta;
    private JLabel LblId;
    private ButtonGroup buttonGroupEstado;
    private JButton jButton1;
    private Metodos xmt = new Metodos();
    String idEmpresaSeleccionada = "";

    public JIFInforme015OportunidadAtencionv1() {
        initComponents();
        springStart();
        mNuevo();
    }

    private void springStart() {
        this.sGC_Informe015OportunidadAtencioDAO = (SGC_Informe015OportunidadAtencionDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("sGC_Informe015OportunidadAtencioDAO");
    }

    public void mNuevo() {
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
        this.JDFFechaI.setDate(this.xmt.getFechaActual());
        this.JDFFechaF.setDate(this.xmt.getFechaActual());
        mLLenar_CEmpresa();
        mCrearTabla();
    }

    private void mLLenar_CEmpresa() {
        this.ListadoEmpresa = this.sGC_Informe015OportunidadAtencioDAO.listarComboEmpresas();
        this.JCB_Empresa.removeAllItems();
        this.JCB_Empresa.setSelectedIndex(-1);
        for (int z = 0; z < this.ListadoEmpresa.size(); z++) {
            this.JCB_Empresa.addItem(this.ListadoEmpresa.get(z)[1].toString());
        }
        this.JCB_Empresa.setSelectedIndex(-1);
    }

    private void mCrearTabla() {
        this.xmodelo = new DefaultTableModel((Object[][]) null, new String[]{"Id", "Nombres", "Apellidos", "Tipo de Identificacion", "Documento", "Sexo", "Telefono", "Direccion", "Tipo de Afiliado", "Especialidad", "Clase de Cita", "Fecha de Asignacion", "Fecha Sugerida Usuario", "Fecha Cita", "Asignacion vs Fecha Cita", "Usuario vs Fecha Cita", "Nombre Empresa", "Nombre Medico"}) { // from class: com.genoma.plus.controller.sgc.JIFInforme015OportunidadAtencionv1.1
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTB_Detalle.setModel(this.xmodelo);
        JTable jTable = this.JTB_Detalle;
        JTable jTable2 = this.JTB_Detalle;
        jTable.setAutoResizeMode(0);
        this.JTB_Detalle.getColumnModel().getColumn(0).setPreferredWidth(80);
        this.JTB_Detalle.getColumnModel().getColumn(1).setPreferredWidth(200);
        this.JTB_Detalle.getColumnModel().getColumn(2).setPreferredWidth(80);
        this.JTB_Detalle.getColumnModel().getColumn(3).setPreferredWidth(80);
        this.JTB_Detalle.getColumnModel().getColumn(4).setPreferredWidth(80);
        this.JTB_Detalle.getColumnModel().getColumn(5).setPreferredWidth(80);
        this.JTB_Detalle.getColumnModel().getColumn(6).setPreferredWidth(80);
        this.JTB_Detalle.getColumnModel().getColumn(7).setPreferredWidth(80);
        this.JTB_Detalle.getColumnModel().getColumn(8).setPreferredWidth(80);
        this.JTB_Detalle.getColumnModel().getColumn(9).setPreferredWidth(80);
        this.JTB_Detalle.getColumnModel().getColumn(10).setPreferredWidth(80);
        this.JTB_Detalle.getColumnModel().getColumn(11).setPreferredWidth(80);
        this.JTB_Detalle.getColumnModel().getColumn(12).setPreferredWidth(80);
        this.JTB_Detalle.getColumnModel().getColumn(13).setPreferredWidth(80);
        this.JTB_Detalle.getColumnModel().getColumn(14).setPreferredWidth(80);
        this.JTB_Detalle.getColumnModel().getColumn(15).setPreferredWidth(80);
        this.JTB_Detalle.getColumnModel().getColumn(16).setPreferredWidth(80);
        this.JTB_Detalle.getColumnModel().getColumn(17).setPreferredWidth(80);
    }

    private boolean validarCampos() {
        boolean respuesta = true;
        try {
            this.xmt.formatoAMD1.format(this.JDFFechaI.getDate());
            this.xmt.formatoAMD1.format(this.JDFFechaF.getDate());
        } catch (Exception e) {
            e.printStackTrace();
            respuesta = false;
        }
        return respuesta;
    }

    private SGC_Informe015OportunidadAtencionDTO LlenarDTO() {
        SGC_Informe015OportunidadAtencionDTO sGC_Informe015OportunidadAtencionDTO = new SGC_Informe015OportunidadAtencionDTO();
        sGC_Informe015OportunidadAtencionDTO.setInicioRangoCita(this.xmt.formatoAMD1.format(this.JDFFechaI.getDate()));
        sGC_Informe015OportunidadAtencionDTO.setFinRangoCita(this.xmt.formatoAMD1.format(this.JDFFechaF.getDate()));
        sGC_Informe015OportunidadAtencionDTO.setIdEmpresa(this.idEmpresaSeleccionada);
        return sGC_Informe015OportunidadAtencionDTO;
    }

    public void mCargarDatosTabla(List<Object[]> listado) {
        mCrearTabla();
        for (int x = 0; x < listado.size(); x++) {
            this.xmodelo.addRow(this.xdato);
            for (int y = 0; y < 18; y++) {
                this.xmodelo.setValueAt(listado.get(x)[y], x, y);
            }
        }
    }

    public String mBuscarIdDeComboEmpresaEnLista(List<Object[]> listaEmpresa, int indiceCombo, String nombreItemCombo) {
        String id = "-5";
        System.err.println("metodo buscar; indiceCombo: " + indiceCombo + " nombreitem " + nombreItemCombo.toString() + "tamaño Lista: " + listaEmpresa.size());
        if (indiceCombo >= 0 && indiceCombo < listaEmpresa.size()) {
            if (listaEmpresa.get(indiceCombo)[1].toString().equals(nombreItemCombo.toString())) {
                id = listaEmpresa.get(indiceCombo)[0].toString();
                System.err.println("si cogio else if nombre : " + listaEmpresa.get(indiceCombo)[1].toString() + "id " + listaEmpresa.get(indiceCombo)[1].toString() + " id guardado variable: " + id);
            } else {
                System.err.println("no cogio else if nombre : " + listaEmpresa.get(indiceCombo)[1].toString() + "id " + listaEmpresa.get(indiceCombo)[1].toString() + " id guardado variable: " + id);
            }
        }
        return id;
    }

    public void mBuscar() {
        List<Object[]> lista;
        if (validarCampos()) {
            if (!this.JCH_Empresa.isSelected()) {
                this.JCB_Empresa.setSelectedIndex(-1);
            }
            if (this.JCB_Empresa.getSelectedIndex() == -1) {
                this.idEmpresaSeleccionada = mBuscarIdDeComboEmpresaEnLista(this.ListadoEmpresa, this.JCB_Empresa.getSelectedIndex(), "");
            } else {
                this.idEmpresaSeleccionada = mBuscarIdDeComboEmpresaEnLista(this.ListadoEmpresa, this.JCB_Empresa.getSelectedIndex(), this.JCB_Empresa.getSelectedItem().toString());
            }
            System.err.println("id empresa: " + this.idEmpresaSeleccionada);
            SGC_Informe015OportunidadAtencionDTO sGC_Informe015OportunidadAtencionDTO = LlenarDTO();
            System.err.println("id de empresa dentro del dto" + sGC_Informe015OportunidadAtencionDTO.getIdEmpresa());
            if (this.JCH_Empresa.isSelected() && this.JCB_Empresa.getSelectedIndex() != -1) {
                System.err.println("check seleccionado listar empresa");
                lista = this.sGC_Informe015OportunidadAtencioDAO.listarporEmpresa(sGC_Informe015OportunidadAtencionDTO);
            } else {
                System.err.println("check seleccionado listar todos");
                lista = this.sGC_Informe015OportunidadAtencioDAO.list(sGC_Informe015OportunidadAtencionDTO);
            }
            System.err.println("tamannio lista resultante " + lista.size());
            mCargarDatosTabla(lista);
            return;
        }
        JOptionPane.showMessageDialog(this.rootPane, "Verifique las fechas de busqueda");
    }

    /* JADX WARN: Type inference failed for: r3v26, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.buttonGroupEstado = new ButtonGroup();
        this.JPI_Encabezado = new JPanel();
        this.JDFFechaI = new JDateChooser();
        this.JDFFechaF = new JDateChooser();
        this.JCB_Empresa = new JComboBox();
        this.JCH_Empresa = new JCheckBox();
        this.LblId = new JLabel();
        this.JSP_Detalle = new JScrollPane();
        this.JTB_Detalle = new JTable();
        this.JPI_Exportar = new JPanel();
        this.JBTExportar = new JButton();
        this.JTFRuta = new JTextField();
        this.jButton1 = new JButton();
        setClosable(true);
        setIconifiable(true);
        setTitle("REPORTE OPORTUNIDAD DE ATENCION");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jiFOportunidadAtencion");
        this.JPI_Encabezado.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JDFFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFFechaI.setFont(new Font("Arial", 1, 12));
        this.JDFFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Fin", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFFechaF.setFont(new Font("Arial", 1, 12));
        this.JCB_Empresa.setFont(new Font("Arial", 1, 12));
        this.JCB_Empresa.setBorder(BorderFactory.createTitledBorder((Border) null, "EPS", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCH_Empresa.setFont(new Font("Arial", 1, 12));
        this.JCH_Empresa.setText("Empresa");
        GroupLayout JPI_EncabezadoLayout = new GroupLayout(this.JPI_Encabezado);
        this.JPI_Encabezado.setLayout(JPI_EncabezadoLayout);
        JPI_EncabezadoLayout.setHorizontalGroup(JPI_EncabezadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_EncabezadoLayout.createSequentialGroup().addContainerGap().addGroup(JPI_EncabezadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_EncabezadoLayout.createSequentialGroup().addComponent(this.JDFFechaI, -2, 121, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JDFFechaF, -2, 121, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCB_Empresa, -2, 492, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCH_Empresa)).addGroup(JPI_EncabezadoLayout.createSequentialGroup().addGap(605, 605, 605).addComponent(this.LblId))).addContainerGap(38, 32767)));
        JPI_EncabezadoLayout.setVerticalGroup(JPI_EncabezadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPI_EncabezadoLayout.createSequentialGroup().addGap(0, 12, 32767).addComponent(this.LblId).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPI_EncabezadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_EncabezadoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JDFFechaI, -2, 50, -2).addComponent(this.JDFFechaF, -2, 50, -2)).addGroup(JPI_EncabezadoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCB_Empresa, -2, 50, -2).addComponent(this.JCH_Empresa))).addContainerGap()));
        this.JSP_Detalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTB_Detalle.setFont(new Font("Arial", 1, 12));
        this.JTB_Detalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTB_Detalle.setRowHeight(25);
        this.JTB_Detalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTB_Detalle.setSelectionForeground(Color.red);
        this.JSP_Detalle.setViewportView(this.JTB_Detalle);
        this.JPI_Exportar.setBorder(BorderFactory.createTitledBorder((Border) null, "EXPORTACIÓN", 0, 0, new Font("Arial", 1, 14), Color.red));
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.sgc.JIFInforme015OportunidadAtencionv1.2
            public void actionPerformed(ActionEvent evt) {
                JIFInforme015OportunidadAtencionv1.this.JBTExportarActionPerformed(evt);
            }
        });
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\GenomaP\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.sgc.JIFInforme015OportunidadAtencionv1.3
            public void mouseClicked(MouseEvent evt) {
                JIFInforme015OportunidadAtencionv1.this.JTFRutaMouseClicked(evt);
            }
        });
        GroupLayout JPI_ExportarLayout = new GroupLayout(this.JPI_Exportar);
        this.JPI_Exportar.setLayout(JPI_ExportarLayout);
        JPI_ExportarLayout.setHorizontalGroup(JPI_ExportarLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_ExportarLayout.createSequentialGroup().addGap(492, 492, 492).addComponent(this.JBTExportar, -2, 230, -2).addContainerGap(-1, 32767)).addGroup(JPI_ExportarLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_ExportarLayout.createSequentialGroup().addGap(3, 3, 3).addComponent(this.JTFRuta, -2, 461, -2).addContainerGap(268, 32767))));
        JPI_ExportarLayout.setVerticalGroup(JPI_ExportarLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_ExportarLayout.createSequentialGroup().addComponent(this.JBTExportar, -2, 50, -2).addGap(0, 21, 32767)).addGroup(JPI_ExportarLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_ExportarLayout.createSequentialGroup().addGap(1, 1, 1).addComponent(this.JTFRuta, -2, 50, -2).addContainerGap(-1, 32767))));
        this.jButton1.setFont(new Font("Arial", 1, 15));
        this.jButton1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Buscar.png")));
        this.jButton1.setText("Buscsar");
        this.jButton1.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.sgc.JIFInforme015OportunidadAtencionv1.4
            public void actionPerformed(ActionEvent evt) {
                JIFInforme015OportunidadAtencionv1.this.jButton1ActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.JPI_Exportar, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jButton1, -2, 130, -2).addGap(0, 0, 32767)).addComponent(this.JSP_Detalle, GroupLayout.Alignment.TRAILING).addComponent(this.JPI_Encabezado, GroupLayout.Alignment.TRAILING, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPI_Encabezado, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSP_Detalle, -2, 342, -2).addGap(18, 18, 18).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JPI_Exportar, -1, -1, 32767).addComponent(this.jButton1, -1, -1, 32767)).addContainerGap(51, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTExportarActionPerformed(ActionEvent evt) {
        if (this.JTB_Detalle.getRowCount() != -1) {
            int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar?", "CONFIRMACIÓN", 0, 3);
            if (x == 0) {
                this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTB_Detalle, this.JTFRuta.getText(), getTitle());
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

    /* JADX INFO: Access modifiers changed from: private */
    public void jButton1ActionPerformed(ActionEvent evt) {
        mBuscar();
    }
}
