package com.genoma.plus.controller.facturacion;

import Acceso.Principal;
import Historia.JDPatologia;
import Utilidades.Metodos;
import com.genoma.plus.dao.auditoria_medica.AuditoriaMedicaDAO;
import com.genoma.plus.dao.impl.auditoria_medica.AuditoriaMedicaDAOImpl;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyVetoException;
import java.io.File;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/facturacion/JIF_Informacion_Facturas_Auditadas.class */
public class JIF_Informacion_Facturas_Auditadas extends JInternalFrame {
    private DefaultTableModel xModelo;
    private AuditoriaMedicaDAO xAuditoriaMedicaDAO;
    private Object[] xdatos;
    private String[] idServicio;
    private JButton JBTExportar;
    private JDateChooser JDFFechaF;
    private JDateChooser JDFFechaI;
    private JLabel JLN_NRegistro;
    private JPanel JPIFiltro;
    private JPanel JPI_Datos2;
    private JScrollPane JSP_Detalle;
    private JTable JTDetalle;
    private JTextField JTFRuta;
    private JTabbedPane JTP_Utilidades;
    private Metodos metodo = new Metodos();
    private Metodos xmt = new Metodos();
    private String xtipo = "1,2,3,4,5,6,7,8,9,10";
    private String xFiltro = "0,1";
    private String xFiltroF = "0,1,2";
    private Boolean estadoLlenadoCombo = false;

    public JIF_Informacion_Facturas_Auditadas() {
        initComponents();
        this.xAuditoriaMedicaDAO = (AuditoriaMedicaDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("auditoriaMedicaDAO");
        nuevo();
    }

    /* JADX WARN: Type inference failed for: r3v6, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JSP_Detalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JTP_Utilidades = new JTabbedPane();
        this.JPI_Datos2 = new JPanel();
        this.JTFRuta = new JTextField();
        this.JBTExportar = new JButton();
        this.JPIFiltro = new JPanel();
        this.JLN_NRegistro = new JLabel();
        this.JDFFechaI = new JDateChooser();
        this.JDFFechaF = new JDateChooser();
        setClosable(true);
        setDefaultCloseOperation(2);
        setIconifiable(true);
        setTitle("INFORME AUDITORIA");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jif_facturas_auditadas");
        this.JSP_Detalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(Color.white);
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.facturacion.JIF_Informacion_Facturas_Auditadas.1
            public void mouseClicked(MouseEvent evt) {
                JIF_Informacion_Facturas_Auditadas.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSP_Detalle.setViewportView(this.JTDetalle);
        this.JTP_Utilidades.setForeground(new Color(0, 103, 0));
        this.JTP_Utilidades.setFont(new Font("Arial", 1, 14));
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.facturacion.JIF_Informacion_Facturas_Auditadas.2
            public void mouseClicked(MouseEvent evt) {
                JIF_Informacion_Facturas_Auditadas.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setForeground(Color.red);
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.facturacion.JIF_Informacion_Facturas_Auditadas.3
            public void actionPerformed(ActionEvent evt) {
                JIF_Informacion_Facturas_Auditadas.this.JBTExportarActionPerformed(evt);
            }
        });
        GroupLayout JPI_Datos2Layout = new GroupLayout(this.JPI_Datos2);
        this.JPI_Datos2.setLayout(JPI_Datos2Layout);
        JPI_Datos2Layout.setHorizontalGroup(JPI_Datos2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPI_Datos2Layout.createSequentialGroup().addGap(677, 677, 677).addComponent(this.JBTExportar, -1, 567, 32767).addContainerGap()).addGroup(JPI_Datos2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_Datos2Layout.createSequentialGroup().addContainerGap().addComponent(this.JTFRuta, -2, 665, -2).addContainerGap(579, 32767))));
        JPI_Datos2Layout.setVerticalGroup(JPI_Datos2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_Datos2Layout.createSequentialGroup().addGap(14, 14, 14).addComponent(this.JBTExportar, -2, 50, -2).addContainerGap(36, 32767)).addGroup(JPI_Datos2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_Datos2Layout.createSequentialGroup().addGap(15, 15, 15).addComponent(this.JTFRuta, -2, 50, -2).addContainerGap(35, 32767))));
        this.JTP_Utilidades.addTab("EXPORTAR", this.JPI_Datos2);
        this.JPIFiltro.setBorder(BorderFactory.createTitledBorder((Border) null, "FILTROS", 0, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JLN_NRegistro.setFont(new Font("Arial", 1, 14));
        this.JLN_NRegistro.setHorizontalAlignment(0);
        this.JLN_NRegistro.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Registros", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JDFFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFFechaI.setFont(new Font("Arial", 1, 12));
        this.JDFFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Fin", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFFechaF.setFont(new Font("Arial", 1, 12));
        GroupLayout JPIFiltroLayout = new GroupLayout(this.JPIFiltro);
        this.JPIFiltro.setLayout(JPIFiltroLayout);
        JPIFiltroLayout.setHorizontalGroup(JPIFiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIFiltroLayout.createSequentialGroup().addComponent(this.JDFFechaI, -2, 129, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JDFFechaF, -2, 129, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JLN_NRegistro, -2, 153, -2).addContainerGap()));
        JPIFiltroLayout.setVerticalGroup(JPIFiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFiltroLayout.createSequentialGroup().addGroup(JPIFiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFiltroLayout.createSequentialGroup().addGap(8, 8, 8).addGroup(JPIFiltroLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JDFFechaI, -2, 50, -2).addComponent(this.JDFFechaF, -2, 50, -2))).addGroup(GroupLayout.Alignment.TRAILING, JPIFiltroLayout.createSequentialGroup().addGap(11, 11, 11).addComponent(this.JLN_NRegistro, -2, 50, -2))).addContainerGap(-1, 32767)));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSP_Detalle).addComponent(this.JTP_Utilidades).addComponent(this.JPIFiltro, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIFiltro, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSP_Detalle, -1, 464, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTP_Utilidades, -2, 131, -2).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            Object[] botones = {"Cargar Ingreso", "Cerrar"};
            int y = JOptionPane.showInternalOptionDialog(this, "Que desea hacer", "SELECCIONAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), botones, "Cerrar");
            switch (y) {
                case 0:
                    if (Principal.informacionGeneralPrincipalDTO.getIdModulo().intValue() == 5) {
                        try {
                            Principal.clasefacturacion.cargarPantalla("Facturación");
                            Principal.clasefacturacion.xjiliqServicio.setSelected(true);
                        } catch (PropertyVetoException e) {
                            Logger.getLogger(JDPatologia.class.getName()).log(Level.SEVERE, (String) null, e);
                        }
                        String[] partes = this.xModelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString().split("-");
                        System.out.println("cedula " + partes[1]);
                        Principal.clasefacturacion.xjiliqServicio.mNuevo();
                        Principal.clasefacturacion.xjiliqServicio.xjppersona.txtHistoria.setText(partes[1]);
                        Principal.clasefacturacion.xjiliqServicio.xjppersona.buscar(2);
                        Principal.clasefacturacion.xjiliqServicio.JLB_NIngreso.setText(this.xModelo.getValueAt(this.JTDetalle.getSelectedRow(), 8).toString());
                        Principal.clasefacturacion.xjiliqServicio.mInicar_Variables_Ingreso(this.xModelo.getValueAt(this.JTDetalle.getSelectedRow(), 8).toString());
                    }
                    break;
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
                this.JTFRuta.setText(xfile.getAbsolutePath() + this.metodo.getBarra());
                this.JTFRuta.requestFocus();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTExportarActionPerformed(ActionEvent evt) {
        if (this.JTDetalle.getRowCount() != -1) {
            int x = JOptionPane.showConfirmDialog(this, "Esta seguro de exportar?", "CONFIRMACIÓN", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                this.metodo.mExportar_Datos_Tabla_Titulo_Formato(this.JTDetalle, this.JTFRuta.getText(), getTitle());
            }
        }
    }

    public void nuevo() {
        this.estadoLlenadoCombo = false;
        this.JDFFechaI.setDate(this.xmt.getFechaActual());
        this.JDFFechaF.setDate(this.xmt.getFechaActual());
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
        mCreaModeloTabla();
        this.estadoLlenadoCombo = true;
    }

    public void buscar() {
        mCargarDatosTabla();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCreaModeloTabla() {
        this.xModelo = new DefaultTableModel(new Object[0], new String[]{"Fecha Ingreso", "Documento", "Usuario", "Edad", "DxP", "Cama", "Ubicacion", "Egreso", "IdIngreso", "IdAtencion", "IdUsuario", "Tipo Atencion", "No Historia", "CSeguimiento", "Convenio", "No Orden", "No Factura", "Total Servicio", "Copago", "C/Moderadora", "Total Eps", "Estado Factura", "Usuario Prefactura", "Cargo", "Motivo", "cerrada", "Motivo Cierre", "Usuario Auditor", "Cargo Auditor"}) { // from class: com.genoma.plus.controller.facturacion.JIF_Informacion_Facturas_Auditadas.4
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, Integer.class, Long.class, Long.class, Long.class, String.class, String.class, Boolean.class, String.class, String.class, String.class, Double.class, Double.class, Double.class, Double.class, Integer.class, String.class, String.class, String.class, Boolean.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

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
        this.JTDetalle.setModel(this.xModelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(120);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(120);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(120);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(120);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(120);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(12).setPreferredWidth(120);
        this.JTDetalle.getColumnModel().getColumn(13).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(14).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(15).setPreferredWidth(120);
        this.JTDetalle.getColumnModel().getColumn(16).setPreferredWidth(120);
        this.JTDetalle.getColumnModel().getColumn(17).setPreferredWidth(120);
        this.JTDetalle.getColumnModel().getColumn(18).setPreferredWidth(120);
        this.JTDetalle.getColumnModel().getColumn(19).setPreferredWidth(120);
        this.JTDetalle.getColumnModel().getColumn(20).setPreferredWidth(120);
        this.JTDetalle.getColumnModel().getColumn(21).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(22).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(23).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(24).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(25).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(26).setPreferredWidth(350);
        this.JTDetalle.getColumnModel().getColumn(27).setPreferredWidth(300);
    }

    private void mCargarDatosTabla() {
        System.out.println("tipo : " + this.xtipo);
        List<Object[]> filteredList = this.xAuditoriaMedicaDAO.listaAuditoriAdministracion(this.xmt.formatoAMD1.format(this.JDFFechaI.getDate()), this.xmt.formatoAMD1.format(this.JDFFechaF.getDate()), this.xtipo, "", this.xFiltro, this.xFiltroF, "", true);
        mCreaModeloTabla();
        String usuario = Principal.usuarioSistemaDTO.getNombreUsuario();
        List<Object[]> list = (List) filteredList.stream().filter(arr -> {
            return arr[23].equals(usuario) && arr[26].equals("CERRAR PREFACTURA") && Integer.parseInt(arr[21].toString()) == 0;
        }).collect(Collectors.toList());
        long xNregistro = 0;
        for (int x = 0; x < list.size(); x++) {
            this.xModelo.addRow(this.xdatos);
            this.xModelo.setValueAt(list.get(x)[0], x, 0);
            this.xModelo.setValueAt(list.get(x)[1], x, 1);
            this.xModelo.setValueAt(list.get(x)[2], x, 2);
            this.xModelo.setValueAt(list.get(x)[3], x, 3);
            this.xModelo.setValueAt(list.get(x)[4], x, 4);
            this.xModelo.setValueAt(list.get(x)[5], x, 5);
            this.xModelo.setValueAt(list.get(x)[6], x, 6);
            this.xModelo.setValueAt(list.get(x)[7], x, 7);
            this.xModelo.setValueAt(list.get(x)[8], x, 8);
            this.xModelo.setValueAt(list.get(x)[9], x, 9);
            this.xModelo.setValueAt(list.get(x)[10], x, 10);
            this.xModelo.setValueAt(list.get(x)[11], x, 11);
            this.xModelo.setValueAt(list.get(x)[12], x, 12);
            if (list.get(x)[13].toString().equals("1")) {
                this.xModelo.setValueAt(true, x, 13);
            } else {
                this.xModelo.setValueAt(false, x, 13);
            }
            this.xModelo.setValueAt(list.get(x)[14], x, 14);
            this.xModelo.setValueAt(list.get(x)[15], x, 15);
            this.xModelo.setValueAt(list.get(x)[16], x, 16);
            this.xModelo.setValueAt(list.get(x)[17], x, 17);
            this.xModelo.setValueAt(list.get(x)[18], x, 18);
            this.xModelo.setValueAt(list.get(x)[19], x, 19);
            this.xModelo.setValueAt(list.get(x)[20], x, 20);
            this.xModelo.setValueAt(list.get(x)[21], x, 21);
            this.xModelo.setValueAt(list.get(x)[22], x, 24);
            this.xModelo.setValueAt(list.get(x)[23], x, 22);
            this.xModelo.setValueAt(list.get(x)[24], x, 23);
            this.xModelo.setValueAt(list.get(x)[25], x, 25);
            this.xModelo.setValueAt(list.get(x)[26], x, 26);
            this.xModelo.setValueAt(list.get(x)[27], x, 27);
            this.xModelo.setValueAt(list.get(x)[28], x, 28);
            this.JTDetalle.setDefaultRenderer(Object.class, new MiRender());
            xNregistro++;
        }
        this.JLN_NRegistro.setText("" + xNregistro);
    }

    /* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/facturacion/JIF_Informacion_Facturas_Auditadas$MiRender.class */
    public static class MiRender extends DefaultTableCellRenderer {
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            Boolean nvalidacion = Boolean.valueOf(table.getValueAt(row, 13).toString());
            Boolean cerrada = Boolean.valueOf(table.getValueAt(row, 25).toString());
            if (cerrada.booleanValue()) {
                cell.setBackground(Color.CYAN);
                cell.setForeground(Color.BLACK);
            } else if (nvalidacion.booleanValue()) {
                cell.setBackground(Color.GREEN);
                cell.setForeground(Color.BLACK);
            } else {
                cell.setBackground(Color.white);
                cell.setForeground(Color.BLACK);
            }
            return cell;
        }
    }
}
