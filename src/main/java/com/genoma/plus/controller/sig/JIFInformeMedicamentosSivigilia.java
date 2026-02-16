package com.genoma.plus.controller.sig;

import Utilidades.Metodos;
import com.genoma.plus.dao.impl.sig.InformeMedicamentosSivigilaDAOImpl;
import com.genoma.plus.dao.sig.InformeMedicamentosSivigiliaDAO;
import com.genoma.plus.dto.sig.InformeMedicamentosSivigiliaDTO;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyVetoException;
import java.io.File;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
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

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/sig/JIFInformeMedicamentosSivigilia.class */
public class JIFInformeMedicamentosSivigilia extends JInternalFrame {
    private File xfile;
    private DefaultTableModel xmodelo;
    private Object[] xdato;
    private InformeMedicamentosSivigiliaDAO sivigilaPajonalDAO;
    List<Object[]> ListadoEmpresa;
    private JButton JBTExportar;
    private JDateChooser JDFFechaF;
    private JDateChooser JDFFechaI;
    private JPanel JPI_Encabezado;
    private JPanel JPI_Exportar;
    private JScrollPane JSP_Detalle;
    private JTable JTB_Detalle;
    private JTextField JTFRuta;
    private JLabel LblId;
    private ButtonGroup buttonGroupEstado;
    private Metodos xmt = new Metodos();
    String idEmpresaSeleccionada = "";

    public JIFInformeMedicamentosSivigilia() {
        initComponents();
        springStart();
        mNuevo();
    }

    private void springStart() {
        this.sivigilaPajonalDAO = (InformeMedicamentosSivigilaDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("informeMedicamentosSivigilaDAO");
    }

    public void mNuevo() {
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
        this.JDFFechaI.setDate(this.xmt.getFechaActual());
        this.JDFFechaF.setDate(this.xmt.getFechaActual());
        mCrearTabla();
    }

    private void mCrearTabla() {
        this.xmodelo = new DefaultTableModel((Object[][]) null, new String[]{"Fecha Salida", "Nombre", "Servicio", "Cantidad", "Despacho"}) { // from class: com.genoma.plus.controller.sig.JIFInformeMedicamentosSivigilia.1
            Class[] types = {String.class, String.class, String.class, Integer.class, Integer.class};
            boolean[] canEdit = {false, false, false, false, false};

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
        this.JTB_Detalle.getColumnModel().getColumn(2).setPreferredWidth(200);
        this.JTB_Detalle.getColumnModel().getColumn(3).setPreferredWidth(80);
        this.JTB_Detalle.getColumnModel().getColumn(4).setPreferredWidth(80);
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

    private InformeMedicamentosSivigiliaDTO LlenarDTO() {
        InformeMedicamentosSivigiliaDTO sivigilaPajonalDTO = new InformeMedicamentosSivigiliaDTO();
        sivigilaPajonalDTO.setFechaInicio(this.xmt.formatoAMD1.format(this.JDFFechaI.getDate()));
        sivigilaPajonalDTO.setFechaFin(this.xmt.formatoAMD1.format(this.JDFFechaF.getDate()));
        return sivigilaPajonalDTO;
    }

    public void mCargarDatosTabla(List<Object[]> listado) {
        mCrearTabla();
        for (int x = 0; x < listado.size(); x++) {
            this.xmodelo.addRow(this.xdato);
            for (int y = 0; y < 5; y++) {
                this.xmodelo.setValueAt(listado.get(x)[y], x, y);
            }
        }
    }

    public void mBuscar() {
        if (validarCampos()) {
            InformeMedicamentosSivigiliaDTO sivigilaPajonalDTO = LlenarDTO();
            List<Object[]> lista = this.sivigilaPajonalDAO.listaMedicamentosSivigila(sivigilaPajonalDTO);
            System.err.println("tamannio lista resultante " + lista.size());
            mCargarDatosTabla(lista);
            return;
        }
        JOptionPane.showMessageDialog(this.rootPane, "Verifique las fechas de busqueda");
    }

    /* JADX WARN: Type inference failed for: r3v30, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.buttonGroupEstado = new ButtonGroup();
        this.JPI_Encabezado = new JPanel();
        this.JDFFechaI = new JDateChooser();
        this.JDFFechaF = new JDateChooser();
        this.LblId = new JLabel();
        this.JSP_Detalle = new JScrollPane();
        this.JTB_Detalle = new JTable();
        this.JPI_Exportar = new JPanel();
        this.JBTExportar = new JButton();
        this.JTFRuta = new JTextField();
        setClosable(true);
        setIconifiable(true);
        setTitle("INFORME MEDICAMENTOS SIVIGILA");
        setToolTipText("");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jIFInformeMedicamentosSivigilia");
        try {
            setSelected(true);
        } catch (PropertyVetoException e1) {
            e1.printStackTrace();
        }
        this.JPI_Encabezado.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JDFFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFFechaI.setFont(new Font("Arial", 1, 12));
        this.JDFFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Fin", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFFechaF.setFont(new Font("Arial", 1, 12));
        GroupLayout JPI_EncabezadoLayout = new GroupLayout(this.JPI_Encabezado);
        this.JPI_Encabezado.setLayout(JPI_EncabezadoLayout);
        JPI_EncabezadoLayout.setHorizontalGroup(JPI_EncabezadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_EncabezadoLayout.createSequentialGroup().addContainerGap().addComponent(this.JDFFechaI, -2, 121, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JDFFechaF, -2, 121, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.LblId).addContainerGap(-1, 32767)));
        JPI_EncabezadoLayout.setVerticalGroup(JPI_EncabezadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPI_EncabezadoLayout.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.LblId).addGap(68, 68, 68)).addGroup(JPI_EncabezadoLayout.createSequentialGroup().addGroup(JPI_EncabezadoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JDFFechaF, -2, 50, -2).addComponent(this.JDFFechaI, -2, 50, -2)).addContainerGap(-1, 32767)));
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
        this.JBTExportar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.sig.JIFInformeMedicamentosSivigilia.2
            public void actionPerformed(ActionEvent evt) {
                JIFInformeMedicamentosSivigilia.this.JBTExportarActionPerformed(evt);
            }
        });
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\GenomaP\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.sig.JIFInformeMedicamentosSivigilia.3
            public void mouseClicked(MouseEvent evt) {
                JIFInformeMedicamentosSivigilia.this.JTFRutaMouseClicked(evt);
            }
        });
        GroupLayout JPI_ExportarLayout = new GroupLayout(this.JPI_Exportar);
        this.JPI_Exportar.setLayout(JPI_ExportarLayout);
        JPI_ExportarLayout.setHorizontalGroup(JPI_ExportarLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPI_ExportarLayout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.JBTExportar, -2, 217, -2).addContainerGap()).addGroup(JPI_ExportarLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_ExportarLayout.createSequentialGroup().addGap(3, 3, 3).addComponent(this.JTFRuta, -2, 401, -2).addContainerGap(236, 32767))));
        JPI_ExportarLayout.setVerticalGroup(JPI_ExportarLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_ExportarLayout.createSequentialGroup().addComponent(this.JBTExportar, -2, 50, -2).addGap(0, 21, 32767)).addGroup(JPI_ExportarLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_ExportarLayout.createSequentialGroup().addGap(1, 1, 1).addComponent(this.JTFRuta, -2, 50, -2).addContainerGap(20, 32767))));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JSP_Detalle, -1, 650, 32767).addComponent(this.JPI_Exportar, -1, -1, 32767)).addComponent(this.JPI_Encabezado, -2, -1, -2)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPI_Encabezado, -2, -1, -2).addGap(12, 12, 12).addComponent(this.JSP_Detalle, -2, 342, -2).addGap(18, 18, 18).addComponent(this.JPI_Exportar, -2, -1, -2).addContainerGap()));
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
}
