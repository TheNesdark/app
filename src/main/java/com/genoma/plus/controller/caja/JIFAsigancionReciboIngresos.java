package com.genoma.plus.controller.caja;

import Acceso.Principal;
import General.BuscarPersona;
import General.Persona;
import Utilidades.CustomPopupMenuListener;
import Utilidades.Metodos;
import com.genoma.plus.dao.caja.AsignacionReciboIngresosDAO;
import com.genoma.plus.dao.impl.caja.AsignacionReciboIngresosDAOImpl;
import com.genoma.plus.dto.caja.AsignacionReciboIngresosDTO;
import com.genoma.plus.dto.gcuenta.GCGenericoDTO;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/caja/JIFAsigancionReciboIngresos.class */
public class JIFAsigancionReciboIngresos extends JInternalFrame {
    private AsignacionReciboIngresosDAO xAsignacionReciboIngresosDAO;
    private DefaultTableModel xmodelo;
    private Object[] xDato;
    private String[] xidIngresos;
    private JComboBox<String> JCBIngresos;
    private JPanel JPPersona;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;
    public Persona frmPersona = null;
    private Metodos xmt = new Metodos();
    private Boolean xlleno = false;

    public JIFAsigancionReciboIngresos() {
        initComponents();
        springStart();
        cargarPanelPersona();
    }

    private void springStart() {
        this.xAsignacionReciboIngresosDAO = (AsignacionReciboIngresosDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("asignacionReciboIngresosDAO");
    }

    private void cargarPanelPersona() {
        if (this.frmPersona == null) {
            this.frmPersona = new Persona(this);
        }
        this.frmPersona.setVisible(true);
        this.JPPersona.setVisible(false);
        this.frmPersona.setBounds(1, 1, 1190, 500);
        this.JPPersona.add(this.frmPersona);
        this.JPPersona.setVisible(true);
        this.frmPersona.txtHistoria.requestFocus();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTabla() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Caja", "No Recibo", "Fecha", "Concepto", "Cantidad", "V/Unitario", "V/Total", "IdIngreso", "No Factura", "Seleccionar"}) { // from class: com.genoma.plus.controller.caja.JIFAsigancionReciboIngresos.1
            Class[] types = {Long.class, String.class, String.class, String.class, String.class, Integer.class, Double.class, Double.class, Long.class, Long.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, true};

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
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(80);
    }

    public void mCargarCombo() {
        this.JCBIngresos.removeAllItems();
        List<GCGenericoDTO> list1 = this.xAsignacionReciboIngresosDAO.listaComboIngresos(this.frmPersona.getIdPersona());
        this.xidIngresos = new String[list1.size()];
        for (int x = 0; x < list1.size(); x++) {
            this.xidIngresos[x] = String.valueOf(list1.get(x).getId());
            this.JCBIngresos.addItem(list1.get(x).getNombre());
            System.out.println("Consulta " + list1.get(x).getId());
            System.out.println("" + list1.get(x).getNombre());
        }
        this.JCBIngresos.addPopupMenuListener(new CustomPopupMenuListener(true, false));
        this.JCBIngresos.setSelectedIndex(-1);
    }

    public void mCargarDatosTabla() {
        System.out.println("Identificacacion " + this.frmPersona.listaTipoIdentificacion[this.frmPersona.cboTipoIdentificacion.getSelectedIndex()][0]);
        List<AsignacionReciboIngresosDTO> list = this.xAsignacionReciboIngresosDAO.ListRecibosUsuario(this.frmPersona.listaTipoIdentificacion[this.frmPersona.cboTipoIdentificacion.getSelectedIndex()][0] + " " + this.frmPersona.getIdentificacion());
        mCrearTabla();
        for (int x = 0; x < list.size(); x++) {
            this.xmodelo.addRow(this.xDato);
            this.xmodelo.setValueAt(list.get(x).getId(), x, 0);
            this.xmodelo.setValueAt(list.get(x).getCaja(), x, 1);
            this.xmodelo.setValueAt(list.get(x).getNRecibo(), x, 2);
            this.xmodelo.setValueAt(list.get(x).getFecha(), x, 3);
            this.xmodelo.setValueAt(list.get(x).getConcepto(), x, 4);
            this.xmodelo.setValueAt(Integer.valueOf(list.get(x).getCantidad()), x, 5);
            this.xmodelo.setValueAt(list.get(x).getVUnitario(), x, 6);
            this.xmodelo.setValueAt(list.get(x).getVTotal(), x, 7);
            this.xmodelo.setValueAt(list.get(x).getIdIngreso(), x, 8);
            this.xmodelo.setValueAt(list.get(x).getNFactura(), x, 9);
            if (list.get(x).getIdIngreso().longValue() != 0) {
                this.xmodelo.setValueAt(true, x, 10);
            } else {
                this.xmodelo.setValueAt(false, x, 10);
            }
        }
    }

    public void mNuevo() {
        Principal.mLimpiarDatosP();
        this.JCBIngresos.removeAllItems();
        mCrearTabla();
        this.frmPersona.nuevo();
        this.frmPersona.txtHistoria.requestFocus();
    }

    public void mBuscar() {
        BuscarPersona frmBuscar = new BuscarPersona(null, true, this.frmPersona);
        frmBuscar.setVisible(true);
    }

    public void mGrabar() {
        if (!this.frmPersona.getIdPersona().isEmpty() && !this.frmPersona.getIdPersona().equals("0")) {
            if (this.JCBIngresos.getSelectedIndex() != -1) {
                if (this.xmt.mVerificarDatosTablaTrue(this.JTDetalle, 10)) {
                    int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    if (n == 0) {
                        for (int y = 0; y < this.JTDetalle.getRowCount(); y++) {
                            if (Boolean.valueOf(this.xmodelo.getValueAt(y, 10).toString()).booleanValue() && Long.valueOf(this.xmodelo.getValueAt(y, 8).toString()).longValue() == 0) {
                                AsignacionReciboIngresosDTO e = new AsignacionReciboIngresosDTO();
                                e.setIdIngreso(Long.valueOf(this.xidIngresos[this.JCBIngresos.getSelectedIndex()]));
                                e.setId(Long.valueOf(this.xmodelo.getValueAt(y, 0).toString()));
                                this.xAsignacionReciboIngresosDAO.updateReciboxIngreso(e);
                            }
                        }
                    }
                    mCargarDatosTabla();
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar al menos un registro", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un Ingreso", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            this.JCBIngresos.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe cargar un Usuario", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        this.frmPersona.txtHistoria.requestFocus();
    }

    /* JADX WARN: Type inference failed for: r3v10, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPPersona = new JPanel();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JCBIngresos = new JComboBox<>();
        setClosable(true);
        setIconifiable(true);
        setTitle("ASIGNACION DE INGRESOS A RECIBOS DE CAJA");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjifasignacionreciboingresos");
        this.JPPersona.setFont(new Font("Arial", 1, 12));
        this.JPPersona.setPreferredSize(new Dimension(920, 165));
        GroupLayout JPPersonaLayout = new GroupLayout(this.JPPersona);
        this.JPPersona.setLayout(JPPersonaLayout);
        JPPersonaLayout.setHorizontalGroup(JPPersonaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 983, 32767));
        JPPersonaLayout.setVerticalGroup(JPPersonaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 165, 32767));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setSelectionBackground(Color.white);
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.JCBIngresos.setFont(new Font("Arial", 1, 12));
        this.JCBIngresos.setModel(new DefaultComboBoxModel(new String[]{" "}));
        this.JCBIngresos.setBorder(BorderFactory.createTitledBorder((Border) null, "Ingresos", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.JPPersona, -2, 983, -2).addGap(10, 12, 32767)).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPDetalle).addGroup(layout.createSequentialGroup().addComponent(this.JCBIngresos, -2, 310, -2).addGap(0, 0, 32767))).addContainerGap()))));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPPersona, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBIngresos, -2, 50, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPDetalle, -2, 443, -2).addContainerGap()));
        pack();
    }
}
