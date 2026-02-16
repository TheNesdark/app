package com.genoma.plus.controller.enfermeria;

import Utilidades.Metodos;
import com.genoma.plus.dao.enfermeria.ConteoUnidosisAgrupadaUrgenciaDAO;
import com.genoma.plus.dao.impl.enfermeria.ConteoUnidosisAgrupadasUregenciaDAOImpl;
import com.genoma.plus.dto.enfermeria.ConteoUnidosisAgrupadaUrgenciaDTO;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
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

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/enfermeria/JIFConteoUnidosisAgrupadasUregencia.class */
public class JIFConteoUnidosisAgrupadasUregencia extends JInternalFrame {
    private Metodos xmt = new Metodos();
    private Object[] xDato;
    private ConteoUnidosisAgrupadaUrgenciaDAO xConteoUnidosisAgrupadaUrgenciaDAO;
    private DefaultTableModel xmodelo;
    private DefaultTableModel xmodelo1;
    private int filtroAgrupacion;
    private JButton JBTGenerar;
    private JCheckBox JCHEstado;
    public JDateChooser JDFFechaF;
    public JDateChooser JDFFechaI;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;
    private JTextField JTFRuta;
    private JPanel jPanel1;

    public JIFConteoUnidosisAgrupadasUregencia(String xjifConsultarUnidosis) {
        initComponents();
        springStart();
        mNuevo();
    }

    private void springStart() {
        this.xConteoUnidosisAgrupadaUrgenciaDAO = (ConteoUnidosisAgrupadasUregenciaDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("conteoUnidosisAgrupadasUregenciaDAOImpl");
    }

    public void mNuevo() {
        this.JDFFechaI.setDate(this.xmt.getFechaActual());
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
        this.JDFFechaF.setDate(this.xmt.getFechaActual());
        this.filtroAgrupacion = 0;
        this.JCHEstado.setSelected(false);
        mModelo();
    }

    public void mBuscar() {
        System.err.println("variable" + this.filtroAgrupacion);
        if (this.filtroAgrupacion == 0) {
            mModelo();
            List<ConteoUnidosisAgrupadaUrgenciaDTO> list = this.xConteoUnidosisAgrupadaUrgenciaDAO.CantidadUnidosisAplicada(this.xmt.formatoAMD1.format(this.JDFFechaI.getDate()), this.xmt.formatoAMD1.format(this.JDFFechaF.getDate()));
            for (int x = 0; x < list.size(); x++) {
                this.xmodelo.addRow(this.xDato);
                this.xmodelo.setValueAt(Integer.valueOf(list.get(x).getIdOrdenUnidosis()), x, 0);
                this.xmodelo.setValueAt(list.get(x).getIdTipoDocumento(), x, 1);
                this.xmodelo.setValueAt(list.get(x).getNumeroDocumento(), x, 2);
                this.xmodelo.setValueAt(list.get(x).getNombreCompleto(), x, 3);
                this.xmodelo.setValueAt(list.get(x).getIdSexo(), x, 4);
                this.xmodelo.setValueAt(list.get(x).getNombreConvenio(), x, 5);
                this.xmodelo.setValueAt(list.get(x).getFechaAplicacionUnidosis(), x, 6);
                this.xmodelo.setValueAt(list.get(x).getHoraaPlicacionUnidosis(), x, 7);
                this.xmodelo.setValueAt(Integer.valueOf(list.get(x).getIdSuministro()), x, 8);
                this.xmodelo.setValueAt(list.get(x).getNombreSuministro(), x, 9);
                this.xmodelo.setValueAt(Integer.valueOf(list.get(x).getCantidadAplicada()), x, 10);
            }
            return;
        }
        mModelo();
        List<ConteoUnidosisAgrupadaUrgenciaDTO> list2 = this.xConteoUnidosisAgrupadaUrgenciaDAO.CantidadUnidosisAplicadaAgrupada(this.xmt.formatoAMD1.format(this.JDFFechaI.getDate()), this.xmt.formatoAMD1.format(this.JDFFechaF.getDate()));
        for (int x2 = 0; x2 < list2.size(); x2++) {
            this.xmodelo1.addRow(this.xDato);
            this.xmodelo1.setValueAt(list2.get(x2).getFechaAplicacionUnidosis(), x2, 0);
            this.xmodelo1.setValueAt(list2.get(x2).getHoraaPlicacionUnidosis(), x2, 1);
            this.xmodelo1.setValueAt(Integer.valueOf(list2.get(x2).getIdSuministro()), x2, 2);
            this.xmodelo1.setValueAt(list2.get(x2).getNombreSuministro(), x2, 3);
            this.xmodelo1.setValueAt(Integer.valueOf(list2.get(x2).getCantidadAplicada()), x2, 4);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mModelo() {
        System.err.println("variable modelo" + this.filtroAgrupacion);
        if (this.filtroAgrupacion == 0) {
            this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "TipoDC", "NumeroDC", "Usiario", "Sexo", "Convenio", "Fecha", "Hora", "IdSumunistro", "NombreS", "Cantidad"}) { // from class: com.genoma.plus.controller.enfermeria.JIFConteoUnidosisAgrupadasUregencia.1
                Class[] types = {Integer.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
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
            this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(0);
            this.JTDetalle.getColumnModel().getColumn(0).setMinWidth(0);
            this.JTDetalle.getColumnModel().getColumn(0).setMaxWidth(0);
            this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(50);
            this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(150);
            this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(300);
            this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(20);
            this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(250);
            this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(100);
            this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(100);
            this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(0);
            this.JTDetalle.getColumnModel().getColumn(0).setMinWidth(0);
            this.JTDetalle.getColumnModel().getColumn(0).setMinWidth(0);
            this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(250);
            this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(50);
            return;
        }
        if (this.filtroAgrupacion == 1) {
            System.err.println("entro 1");
            this.xmodelo1 = new DefaultTableModel(new Object[0], new String[]{"Fecha", "Hora", "IdSumunistro", "NombreS", "Cantidad"}) { // from class: com.genoma.plus.controller.enfermeria.JIFConteoUnidosisAgrupadasUregencia.2
                Class[] types = {String.class, String.class, Long.class, String.class, String.class};
                boolean[] canEdit = {false, false, false, false, false};

                public Class getColumnClass(int columnIndex) {
                    return this.types[columnIndex];
                }

                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return this.canEdit[columnIndex];
                }
            };
            JTable jTable3 = this.JTDetalle;
            JTable jTable4 = this.JTDetalle;
            jTable3.setAutoResizeMode(0);
            this.JTDetalle.doLayout();
            this.JTDetalle.setModel(this.xmodelo1);
            this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(0);
            this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(20);
            this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(150);
            this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(300);
            this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(20);
        }
    }

    /* JADX WARN: Type inference failed for: r3v29, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jPanel1 = new JPanel();
        this.JDFFechaI = new JDateChooser();
        this.JDFFechaF = new JDateChooser();
        this.JCHEstado = new JCheckBox();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JTFRuta = new JTextField();
        this.JBTGenerar = new JButton();
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Consultar Unidosis");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xJIFConsultarUnidosis");
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACION", 2, 0, new Font("Arial", 1, 12), Color.red));
        this.JDFFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFFechaI.setFont(new Font("Arial", 1, 12));
        this.JDFFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Fin", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFFechaF.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setText("Agrepar Suministros?");
        this.JCHEstado.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.enfermeria.JIFConteoUnidosisAgrupadasUregencia.3
            public void actionPerformed(ActionEvent evt) {
                JIFConteoUnidosisAgrupadasUregencia.this.JCHEstadoActionPerformed(evt);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.JDFFechaI, -2, 121, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JDFFechaF, -2, 121, -2).addGap(18, 18, 18).addComponent(this.JCHEstado).addContainerGap(-1, 32767)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JDFFechaI, -2, 54, -2).addComponent(this.JDFFechaF, -2, 54, -2)).addGap(0, 9, 32767)).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.JCHEstado).addContainerGap()));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.enfermeria.JIFConteoUnidosisAgrupadasUregencia.4
            public void mouseClicked(MouseEvent evt) {
                JIFConteoUnidosisAgrupadasUregencia.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\\\Genoma\\\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ruta", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.enfermeria.JIFConteoUnidosisAgrupadasUregencia.5
            public void mouseClicked(MouseEvent evt) {
                JIFConteoUnidosisAgrupadasUregencia.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBTGenerar.setFont(new Font("Arial", 1, 12));
        this.JBTGenerar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTGenerar.setText("Exportar");
        this.JBTGenerar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.enfermeria.JIFConteoUnidosisAgrupadasUregencia.6
            public void actionPerformed(ActionEvent evt) {
                JIFConteoUnidosisAgrupadasUregencia.this.JBTGenerarActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(10, 10, 10).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.JTFRuta, -1, 679, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTGenerar, -2, 248, -2)).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JSPDetalle, GroupLayout.Alignment.LEADING, -1, 933, 32767).addComponent(this.jPanel1, GroupLayout.Alignment.LEADING, -1, -1, 32767))).addGap(10, 10, 10)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalle, -2, 326, -2).addGap(10, 10, 10).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JBTGenerar, -1, -1, 32767).addComponent(this.JTFRuta, -2, 50, -2)).addContainerGap(15, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
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
    public void JBTGenerarActionPerformed(ActionEvent evt) {
        if (this.JTDetalle.getRowCount() != -1) {
            int x = JOptionPane.showConfirmDialog(this, "Esta seguro de exportar?", "CONFIRMACIÓN", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTDetalle, this.JTFRuta.getText(), getTitle());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEstadoActionPerformed(ActionEvent evt) {
        if (this.JCHEstado.isSelected()) {
            this.filtroAgrupacion = 1;
            mModelo();
        } else {
            this.filtroAgrupacion = 0;
        }
    }
}
