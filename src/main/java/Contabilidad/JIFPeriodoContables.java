package Contabilidad;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.genoma.plus.controller.contabilidad.JD_PeriodoObservacion;
import com.genoma.plus.jpa.entities.CcPeriodoContable;
import com.genoma.plus.jpa.entities.CcPeriodoFinanciero;
import com.genoma.plus.jpa.entities.IPeriodo;
import com.genoma.plus.jpa.service.CcPeriodoContableService;
import com.genoma.plus.jpa.service.ICcPeriodoFinancieroService;
import com.genoma.plus.jpa.service.IIPeriodoService;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyVetoException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Contabilidad/JIFPeriodoContables.class */
public class JIFPeriodoContables extends JInternalFrame {
    private int xactivo;
    private DefaultTableModel xmodelo;
    private Object[] xdatos;
    private String[] xidperiodo;
    private String xnombre;
    private CcPeriodoContable periodoContable;
    private IPeriodo periodoInventario;
    private final CcPeriodoContableService periodoContableService;
    private final IIPeriodoService iPeriodoService;
    private final ICcPeriodoFinancieroService iCcPeriodoFinancieroService;
    private List<CcPeriodoContable> listPeriodosContables;
    private List<IPeriodo> listPeriodosInventario;
    private List<CcPeriodoFinanciero> listPeriodosFinanciero;
    private JComboBox JCBPeridoF;
    private JCheckBox JCHActivo;
    private JCheckBox JCHEsCierre;
    private JCheckBox JCHEstado;
    public JDateChooser JDFFechaF;
    public JDateChooser JDFFechaI;
    private JPanel JPIDatos;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;
    private JTextField JTFNombre;
    private JButton jButton1;
    private ConsultasMySQL xconsulta = new ConsultasMySQL();
    private Metodos xmetodos = new Metodos();
    private int xestado = 1;
    private int xescierre = 0;

    public JIFPeriodoContables(String xnombre) {
        initComponents();
        setName(xnombre);
        this.xnombre = xnombre;
        this.periodoContableService = (CcPeriodoContableService) Principal.contexto.getBean(CcPeriodoContableService.class);
        this.iCcPeriodoFinancieroService = (ICcPeriodoFinancieroService) Principal.contexto.getBean(ICcPeriodoFinancieroService.class);
        this.iPeriodoService = (IIPeriodoService) Principal.contexto.getBean(IIPeriodoService.class);
        this.listPeriodosContables = new ArrayList();
        this.listPeriodosInventario = new ArrayList();
        mNuevo();
        mCargarDatosTabla();
    }

    /* JADX WARN: Type inference failed for: r3v37, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPIDatos = new JPanel();
        this.JCBPeridoF = new JComboBox();
        this.JDFFechaI = new JDateChooser();
        this.JDFFechaF = new JDateChooser();
        this.JCHEstado = new JCheckBox();
        this.JCHActivo = new JCheckBox();
        this.JTFNombre = new JTextField();
        this.JCHEsCierre = new JCheckBox();
        this.jButton1 = new JButton();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("PERIODO CONTABLE");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifperiodoc");
        try {
            setSelected(true);
        } catch (PropertyVetoException e1) {
            e1.printStackTrace();
        }
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JCBPeridoF.setFont(new Font("Arial", 1, 12));
        this.JCBPeridoF.setBorder(BorderFactory.createTitledBorder((Border) null, "Periodo F", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFFechaI.setFont(new Font("Arial", 1, 12));
        this.JDFFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Fin", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFFechaF.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setSelected(true);
        this.JCHEstado.setText("Estado");
        this.JCHActivo.setFont(new Font("Arial", 1, 12));
        this.JCHActivo.setSelected(true);
        this.JCHActivo.setText("Activo");
        this.JTFNombre.setFont(new Font("Arial", 1, 12));
        this.JTFNombre.setToolTipText("Digite el nombre del municipio");
        this.JTFNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHEsCierre.setFont(new Font("Arial", 1, 12));
        this.JCHEsCierre.setText("Es Cierre?");
        this.jButton1.setFont(new Font("Arial", 1, 12));
        this.jButton1.setText("Ver Comentario");
        this.jButton1.addActionListener(new ActionListener() { // from class: Contabilidad.JIFPeriodoContables.1
            public void actionPerformed(ActionEvent evt) {
                JIFPeriodoContables.this.jButton1ActionPerformed(evt);
            }
        });
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JDFFechaI, -2, 120, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JDFFechaF, -2, 120, -2)).addComponent(this.JCBPeridoF, 0, -1, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHEstado).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JCHActivo).addGap(18, 18, 18).addComponent(this.JCHEsCierre))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.jButton1)).addComponent(this.JTFNombre)).addContainerGap()));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBPeridoF, -2, -1, -2).addComponent(this.JTFNombre, -2, 41, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 14, 32767).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JDFFechaF, -2, 54, -2).addComponent(this.JDFFechaI, -2, 54, -2)).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosLayout.createSequentialGroup().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCHActivo).addComponent(this.JCHEsCierre)).addGap(2, 2, 2).addComponent(this.JCHEstado)).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosLayout.createSequentialGroup().addComponent(this.jButton1).addContainerGap()))));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: Contabilidad.JIFPeriodoContables.2
            public void mouseClicked(MouseEvent evt) {
                JIFPeriodoContables.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JSPDetalle, GroupLayout.Alignment.LEADING, -1, 682, 32767).addComponent(this.JPIDatos, GroupLayout.Alignment.LEADING, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -1, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalle, -2, 167, -2).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            if (this.xnombre.equals("jifperiodoc")) {
                this.periodoContable = this.listPeriodosContables.get(this.JTDetalle.getSelectedRow());
                this.JTFNombre.setText(this.periodoContable.getNbre());
                this.JDFFechaI.setDate(this.periodoContable.getFechaI());
                this.JDFFechaF.setDate(this.periodoContable.getFechaF());
                this.JCHEstado.setSelected(this.periodoContable.getEstado().booleanValue());
                this.JCHActivo.setSelected(this.periodoContable.getActivo().booleanValue());
                this.JCHEsCierre.setSelected(this.periodoContable.getEsCierre().booleanValue());
                return;
            }
            this.periodoInventario = this.listPeriodosInventario.get(this.JTDetalle.getSelectedRow());
            this.JTFNombre.setText(this.periodoInventario.getNbre());
            this.JDFFechaI.setDate(this.periodoInventario.getFechaI());
            this.JDFFechaF.setDate(this.periodoInventario.getFechaF());
            this.JCHEstado.setSelected(this.periodoInventario.getEstado().booleanValue());
            this.JCHActivo.setSelected(this.periodoInventario.getActivo().booleanValue());
            this.JCHEsCierre.setSelected(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jButton1ActionPerformed(ActionEvent evt) {
        if (this.periodoContable.getId() != null) {
            abrirModal();
        }
    }

    private void abrirModal() {
        JD_PeriodoObservacion periodoObservacion = new JD_PeriodoObservacion(null, true, this.periodoContable);
        periodoObservacion.setLocationRelativeTo(this);
        periodoObservacion.setVisible(true);
    }

    public final void mNuevo() {
        Principal.txtNo.setText("");
        this.JTFNombre.setText("");
        this.JCBPeridoF.setSelectedIndex(-1);
        this.JDFFechaI.setDate(this.xmetodos.getFechaActual());
        this.JDFFechaF.setDate(this.xmetodos.getFechaActual());
        this.JCHEstado.setSelected(true);
        this.JCHActivo.setSelected(true);
        this.periodoContable = new CcPeriodoContable();
        this.periodoInventario = new IPeriodo();
        this.JCBPeridoF.removeAllItems();
        this.listPeriodosFinanciero = this.iCcPeriodoFinancieroService.getListFilterEstadoOrderByFechaIDesc(false);
        this.listPeriodosFinanciero.forEach(e -> {
            this.JCBPeridoF.addItem(e.getNbre());
        });
        if (this.xnombre.equals("jifperiodocontableI")) {
            this.JCHEsCierre.setVisible(false);
        } else {
            this.JCHEsCierre.setSelected(false);
        }
    }

    private boolean validarPeriodoCierre() {
        boolean estado = false;
        if (this.xmetodos.formatoMes.format(this.JDFFechaI.getDate()).equals("01")) {
            try {
                int anno = Integer.valueOf(this.xmetodos.formatoANO.format(this.JDFFechaI.getDate())).intValue();
                String sql = "SELECT COUNT(Id) cantidad \nfrom cc_periodo_contable cpc \nwhere  DATE_FORMAT(cpc.FechaI, '%Y')=" + (anno - 1) + " and DATE_FORMAT(cpc.FechaI, '%m')=12";
                ResultSet rs = this.xconsulta.traerRs(sql);
                if (rs.next()) {
                    rs.first();
                    if (rs.getInt("cantidad") == 2) {
                        estado = true;
                    } else {
                        estado = false;
                    }
                }
                rs.close();
                this.xconsulta.cerrarConexionBd();
            } catch (SQLException ex) {
                Logger.getLogger(JIFPeriodoContables.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        } else {
            estado = true;
        }
        return estado;
    }

    public void mGrabar() {
        if (this.xnombre.equals("jifperiodoc")) {
            grabarPeriodoContable();
        } else {
            grabarPeriodoInventario();
        }
    }

    private void grabarPeriodoContable() {
        if (this.JCBPeridoF.getSelectedIndex() != -1) {
            if (validarPeriodoCierre()) {
                int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "VERIFICAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (n == 0) {
                    this.periodoContable.setActivo(Boolean.valueOf(this.JCHActivo.isSelected()));
                    this.periodoContable.setEsCierre(Boolean.valueOf(this.JCHEsCierre.isSelected()));
                    this.periodoContable.setEstado(Boolean.valueOf(this.JCHEstado.isSelected()));
                    this.periodoContable.setFechaI(this.JDFFechaI.getDate());
                    this.periodoContable.setFechaF(this.JDFFechaF.getDate());
                    this.periodoContable.setNbre(this.JTFNombre.getText());
                    this.periodoContable.setIdPeriodoF(this.listPeriodosFinanciero.get(this.JCBPeridoF.getSelectedIndex()));
                    this.periodoContable.setFecha(this.xmetodos.getFechaActual());
                    this.periodoContable.setUsuarioS(Principal.usuarioSistemaDTO.getLogin());
                    if (this.periodoContable.getId() != null) {
                        abrirModal();
                        this.periodoContableService.save(this.periodoContable);
                    } else {
                        this.periodoContableService.save(this.periodoContable);
                    }
                    mCargarDatosTabla();
                    mNuevo();
                    return;
                }
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "No se ha creado el perido de cierre; Favor revisar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBPeridoF.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un periodo finaciero", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JCBPeridoF.requestFocus();
    }

    private void grabarPeriodoInventario() {
        if (this.JCBPeridoF.getSelectedIndex() != -1) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "VERIFICAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                this.periodoInventario.setActivo(Boolean.valueOf(this.JCHActivo.isSelected()));
                this.periodoInventario.setEstado(Boolean.valueOf(this.JCHEstado.isSelected()));
                this.periodoInventario.setFechaI(this.JDFFechaI.getDate());
                this.periodoInventario.setFechaF(this.JDFFechaF.getDate());
                this.periodoInventario.setNbre(this.JTFNombre.getText());
                this.periodoInventario.setIdPeriodoF(this.listPeriodosFinanciero.get(this.JCBPeridoF.getSelectedIndex()));
                this.periodoInventario.setFecha(this.xmetodos.getFechaActual());
                this.periodoInventario.setUsuarioS(Principal.usuarioSistemaDTO.getLogin());
                this.iPeriodoService.save(this.periodoInventario);
                mCargarDatosTabla();
                mNuevo();
                return;
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un periodo finaciero", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JCBPeridoF.requestFocus();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Nombre", "Fecha Inicial", "Fecha Final", "Activo", "Estado", "PFinanciero", "EsCierre?", "cantidad"}) { // from class: Contabilidad.JIFPeriodoContables.3
            Class[] types = {Long.class, String.class, Date.class, Date.class, Boolean.class, Boolean.class, String.class, Boolean.class, Integer.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setAutoResizeMode(0);
        this.JTDetalle.doLayout();
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(100);
    }

    private void mCargarDatosTabla() {
        mCrearModeloDatos();
        if (this.xnombre.equals("jifperiodoc")) {
            this.listPeriodosContables = this.periodoContableService.listaPeriodoContable();
        } else {
            this.listPeriodosInventario = this.iPeriodoService.getListIPeriodoOrderByFechaIDesc();
        }
        this.listPeriodosContables.forEach(e -> {
            this.xmodelo.addRow(this.xdatos);
            this.xmodelo.setValueAt(e.getId(), this.JTDetalle.getRowCount() - 1, 0);
            this.xmodelo.setValueAt(e.getNbre(), this.JTDetalle.getRowCount() - 1, 1);
            this.xmodelo.setValueAt(e.getFechaI(), this.JTDetalle.getRowCount() - 1, 2);
            this.xmodelo.setValueAt(e.getFechaF(), this.JTDetalle.getRowCount() - 1, 3);
            this.xmodelo.setValueAt(e.getActivo(), this.JTDetalle.getRowCount() - 1, 4);
            this.xmodelo.setValueAt(e.getEstado(), this.JTDetalle.getRowCount() - 1, 5);
            this.xmodelo.setValueAt(e.getIdPeriodoF().getNbre(), this.JTDetalle.getRowCount() - 1, 6);
            this.xmodelo.setValueAt(e.getEsCierre(), this.JTDetalle.getRowCount() - 1, 7);
            if (e.getCcPeriodoContableObservacionCollection().isEmpty()) {
                this.xmodelo.setValueAt(0, this.JTDetalle.getRowCount() - 1, 8);
            } else {
                this.xmodelo.setValueAt(Integer.valueOf(e.getCcPeriodoContableObservacionCollection().size()), this.JTDetalle.getRowCount() - 1, 8);
            }
        });
        this.listPeriodosInventario.forEach(e2 -> {
            this.xmodelo.addRow(this.xdatos);
            this.xmodelo.setValueAt(e2.getId(), this.JTDetalle.getRowCount() - 1, 0);
            this.xmodelo.setValueAt(e2.getNbre(), this.JTDetalle.getRowCount() - 1, 1);
            this.xmodelo.setValueAt(e2.getFechaI(), this.JTDetalle.getRowCount() - 1, 2);
            this.xmodelo.setValueAt(e2.getFechaF(), this.JTDetalle.getRowCount() - 1, 3);
            this.xmodelo.setValueAt(e2.getActivo(), this.JTDetalle.getRowCount() - 1, 4);
            this.xmodelo.setValueAt(e2.getEstado(), this.JTDetalle.getRowCount() - 1, 5);
            this.xmodelo.setValueAt(e2.getIdPeriodoF().getNbre(), this.JTDetalle.getRowCount() - 1, 6);
            this.xmodelo.setValueAt(false, this.JTDetalle.getRowCount() - 1, 7);
            this.xmodelo.setValueAt(0, this.JTDetalle.getRowCount() - 1, 8);
        });
    }
}
