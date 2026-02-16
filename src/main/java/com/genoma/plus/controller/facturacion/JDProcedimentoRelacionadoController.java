package com.genoma.plus.controller.facturacion;

import Acceso.Principal;
import com.genoma.plus.dao.facturacion.FacturacionDAO;
import com.genoma.plus.dao.impl.facturacion.FacturacionDAOImp;
import com.genoma.plus.dto.facturacion.GenericoDTO;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/facturacion/JDProcedimentoRelacionadoController.class */
public class JDProcedimentoRelacionadoController extends JDialog {
    private FacturacionDAO ximplFacturacion;
    private String[] xidProcedimiento;
    private DefaultTableModel xModelo;
    private Object[] xDato;
    private int xgrabar;
    private int xestado;
    private long xidTipoProc;
    private JButton JBT_Grabar;
    private JButton JBT_NUevo;
    private JButton JBT_Salir;
    private JComboBox<String> JCBProcRelacionado;
    private JCheckBox JCHEstado;
    private JPanel JPI_Datos;
    private JScrollPane JSDetalle;
    private JTable JTDetalle;

    public JDProcedimentoRelacionadoController(Frame parent, boolean modal, Long idTipoProc) {
        super(parent, modal);
        this.xgrabar = 0;
        this.xestado = 1;
        initComponents();
        springStart();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        setTitle("PROCEDIMIENTOS RELACIONADOS");
        this.xidTipoProc = idTipoProc.longValue();
        mNuevo(idTipoProc);
    }

    /* JADX WARN: Type inference failed for: r3v35, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPI_Datos = new JPanel();
        this.JCBProcRelacionado = new JComboBox<>();
        this.JCHEstado = new JCheckBox();
        this.JBT_NUevo = new JButton();
        this.JBT_Grabar = new JButton();
        this.JBT_Salir = new JButton();
        this.JSDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        setDefaultCloseOperation(2);
        this.JPI_Datos.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JCBProcRelacionado.setFont(new Font("Arial", 1, 12));
        this.JCBProcRelacionado.setBorder(BorderFactory.createTitledBorder((Border) null, "Procedimiento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setText("Estado");
        this.JCHEstado.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.facturacion.JDProcedimentoRelacionadoController.1
            public void actionPerformed(ActionEvent evt) {
                JDProcedimentoRelacionadoController.this.JCHEstadoActionPerformed(evt);
            }
        });
        GroupLayout JPI_DatosLayout = new GroupLayout(this.JPI_Datos);
        this.JPI_Datos.setLayout(JPI_DatosLayout);
        JPI_DatosLayout.setHorizontalGroup(JPI_DatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DatosLayout.createSequentialGroup().addGap(17, 17, 17).addComponent(this.JCBProcRelacionado, -2, 886, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JCHEstado).addGap(17, 17, 17)));
        JPI_DatosLayout.setVerticalGroup(JPI_DatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DatosLayout.createSequentialGroup().addContainerGap().addGroup(JPI_DatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JCHEstado).addComponent(this.JCBProcRelacionado, -2, 50, -2)).addContainerGap(23, 32767)));
        this.JBT_NUevo.setFont(new Font("Arial", 1, 12));
        this.JBT_NUevo.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Nuevo29x25.png")));
        this.JBT_NUevo.setText("Nuevo");
        this.JBT_NUevo.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.facturacion.JDProcedimentoRelacionadoController.2
            public void actionPerformed(ActionEvent evt) {
                JDProcedimentoRelacionadoController.this.JBT_NUevoActionPerformed(evt);
            }
        });
        this.JBT_Grabar.setFont(new Font("Arial", 1, 12));
        this.JBT_Grabar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBT_Grabar.setText("Grabar");
        this.JBT_Grabar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.facturacion.JDProcedimentoRelacionadoController.3
            public void actionPerformed(ActionEvent evt) {
                JDProcedimentoRelacionadoController.this.JBT_GrabarActionPerformed(evt);
            }
        });
        this.JBT_Salir.setFont(new Font("Arial", 1, 12));
        this.JBT_Salir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.JBT_Salir.setText("Salir");
        this.JBT_Salir.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.facturacion.JDProcedimentoRelacionadoController.4
            public void actionPerformed(ActionEvent evt) {
                JDProcedimentoRelacionadoController.this.JBT_SalirActionPerformed(evt);
            }
        });
        this.JSDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.facturacion.JDProcedimentoRelacionadoController.5
            public void mouseClicked(MouseEvent evt) {
                JDProcedimentoRelacionadoController.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSDetalle.setViewportView(this.JTDetalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(15, 15, 15).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPI_Datos, -1, -1, 32767).addComponent(this.JSDetalle))).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JBT_NUevo, -2, 340, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBT_Grabar, -1, 340, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBT_Salir, -2, 340, -2))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(14, 14, 14).addComponent(this.JPI_Datos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSDetalle, -2, 321, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBT_Grabar, -2, 50, -2).addComponent(this.JBT_NUevo, -2, 50, -2).addComponent(this.JBT_Salir, -2, 50, -2)).addContainerGap(-1, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_NUevoActionPerformed(ActionEvent evt) {
        mNuevo(Long.valueOf(this.xidTipoProc));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_GrabarActionPerformed(ActionEvent evt) {
        mGrabar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_SalirActionPerformed(ActionEvent evt) {
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEstadoActionPerformed(ActionEvent evt) {
        if (this.JCHEstado.isSelected()) {
            this.xestado = 1;
        } else {
            this.xestado = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getRowCount() != -1 && this.JTDetalle.getSelectedRow() != -1) {
            this.JCBProcRelacionado.setSelectedItem(this.xModelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString());
            this.JCHEstado.setSelected(Boolean.valueOf(this.xModelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString()).booleanValue());
            if (this.JCHEstado.isSelected()) {
                this.xestado = 1;
            } else {
                this.xestado = 0;
            }
            this.xgrabar = 1;
        }
    }

    private void springStart() {
        this.ximplFacturacion = (FacturacionDAOImp) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("facturacionDAOImp");
    }

    private void mNuevo(Long xidProc) {
        List<GenericoDTO> list = this.ximplFacturacion.listProcedimientoTipo(xidProc);
        if (list.size() > 0) {
            this.xidProcedimiento = new String[list.size()];
            this.JCBProcRelacionado.removeAllItems();
            for (int x = 0; x < list.size(); x++) {
                this.xidProcedimiento[x] = list.get(x).getId().toString();
                this.JCBProcRelacionado.addItem(list.get(x).getNombre());
            }
            this.JCBProcRelacionado.setSelectedIndex(-1);
        }
        this.JCHEstado.setSelected(true);
        this.xestado = 1;
        this.xgrabar = 0;
        mCargarDatosTabla(new Long(Principal.txtNo.getText()).longValue());
    }

    public void mGrabar() {
        if (this.JCBProcRelacionado.getSelectedIndex() != -1) {
            int x = JOptionPane.showConfirmDialog(this, "Esta seguro de grabar", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                if (this.xgrabar == 0) {
                    this.ximplFacturacion.addProcedimientoRelacionado(this.xidProcedimiento[this.JCBProcRelacionado.getSelectedIndex()], Principal.txtNo.getText(), Integer.valueOf(this.xestado));
                } else {
                    this.ximplFacturacion.updateProcedimientoRelacionado(this.xidProcedimiento[this.JCBProcRelacionado.getSelectedIndex()], Principal.txtNo.getText(), Integer.valueOf(this.xestado));
                }
                mNuevo(Long.valueOf(this.xidTipoProc));
                return;
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un procedimiento", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        this.JCBProcRelacionado.requestFocus();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xModelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Nombre", "Estado"}) { // from class: com.genoma.plus.controller.facturacion.JDProcedimentoRelacionadoController.6
            Class[] types = {Long.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xModelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(800);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(10);
    }

    public void mCargarDatosTabla(long xid) {
        mCrearModeloDatos();
        List<GenericoDTO> list = this.ximplFacturacion.listProcedimientoRelacionado(Long.valueOf(xid));
        for (int x = 0; x < list.size(); x++) {
            this.xModelo.addRow(this.xDato);
            this.xModelo.setValueAt(list.get(x).getId(), x, 0);
            this.xModelo.setValueAt(list.get(x).getNombre(), x, 1);
            this.xModelo.setValueAt(list.get(x).getEstado(), x, 2);
        }
    }
}
