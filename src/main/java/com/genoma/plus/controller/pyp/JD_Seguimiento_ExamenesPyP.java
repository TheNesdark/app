package com.genoma.plus.controller.pyp;

import Acceso.Principal;
import Utilidades.Metodos;
import com.genoma.plus.dao.impl.pyp.ItemProcedimientoSeguimientoDAOImpl;
import com.genoma.plus.dao.impl.pyp.TipoSeguimientoCDAOImpl;
import com.genoma.plus.dao.pyp.ItemProcedimientoSeguimientoDAO;
import com.genoma.plus.dao.pyp.TipoSeguimientoCDAO;
import com.genoma.plus.dto.pyp.ItemProcedimientoSeguimientoDTO;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/pyp/JD_Seguimiento_ExamenesPyP.class */
public class JD_Seguimiento_ExamenesPyP extends JDialog {
    private Metodos xmt;
    private Long xIdProcedimiento;
    private ItemProcedimientoSeguimientoDAO xItemProcedimientoSeguimiento;
    private TipoSeguimientoCDAO xTipoSeguimiento;
    private String[] xIdTipoSeguimiento;
    private DefaultTableModel xModeloSeguimiento;
    private Object[] xDato;
    private JButton JBT_Guardar;
    private JButton JBT_Nuevo;
    private JButton JBT_Salir;
    private JComboBox JCB_STipoSeguimiento;
    private JDateChooser JDFechaC;
    private JLabel JLN_NSeguimiento;
    private JScrollPane JSPObservacion;
    private JScrollPane JS_SPHistorico;
    private JTextArea JTAObservacion;
    private JTable JTB_SHistorico;

    public JD_Seguimiento_ExamenesPyP(Frame parent, boolean modal, Long xIdProcedimiento) {
        super(parent, modal);
        this.xmt = new Metodos();
        initComponents();
        this.xIdProcedimiento = xIdProcedimiento;
        springStart();
        mNuevo();
        mCargarDatosTabla();
    }

    /* JADX WARN: Type inference failed for: r3v20, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JDFechaC = new JDateChooser();
        this.JSPObservacion = new JScrollPane();
        this.JTAObservacion = new JTextArea();
        this.JLN_NSeguimiento = new JLabel();
        this.JBT_Guardar = new JButton();
        this.JBT_Salir = new JButton();
        this.JCB_STipoSeguimiento = new JComboBox();
        this.JS_SPHistorico = new JScrollPane();
        this.JTB_SHistorico = new JTable();
        this.JBT_Nuevo = new JButton();
        setDefaultCloseOperation(2);
        setTitle("SEGUIMIENTO");
        this.JDFechaC.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaC.setDateFormatString("dd/MM/yyyy");
        this.JDFechaC.setFont(new Font("Arial", 1, 12));
        this.JSPObservacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Observacion", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTAObservacion.setColumns(20);
        this.JTAObservacion.setRows(5);
        this.JSPObservacion.setViewportView(this.JTAObservacion);
        this.JLN_NSeguimiento.setFont(new Font("Arial", 1, 14));
        this.JLN_NSeguimiento.setHorizontalAlignment(0);
        this.JLN_NSeguimiento.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Seguimiento", 0, 0, new Font("Arial", 1, 14), Color.red));
        this.JBT_Guardar.setFont(new Font("Arial", 1, 12));
        this.JBT_Guardar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBT_Guardar.setText("Guardar");
        this.JBT_Guardar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.pyp.JD_Seguimiento_ExamenesPyP.1
            public void actionPerformed(ActionEvent evt) {
                JD_Seguimiento_ExamenesPyP.this.JBT_GuardarActionPerformed(evt);
            }
        });
        this.JBT_Salir.setFont(new Font("Arial", 1, 12));
        this.JBT_Salir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.JBT_Salir.setText("Salir");
        this.JBT_Salir.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.pyp.JD_Seguimiento_ExamenesPyP.2
            public void actionPerformed(ActionEvent evt) {
                JD_Seguimiento_ExamenesPyP.this.JBT_SalirActionPerformed(evt);
            }
        });
        this.JCB_STipoSeguimiento.setFont(new Font("Arial", 1, 12));
        this.JCB_STipoSeguimiento.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JS_SPHistorico.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTB_SHistorico.setFont(new Font("Arial", 1, 12));
        this.JTB_SHistorico.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTB_SHistorico.setRowHeight(25);
        this.JTB_SHistorico.setSelectionBackground(new Color(255, 255, 255));
        this.JTB_SHistorico.setSelectionForeground(new Color(255, 0, 0));
        this.JTB_SHistorico.setSelectionMode(0);
        this.JS_SPHistorico.setViewportView(this.JTB_SHistorico);
        this.JBT_Nuevo.setFont(new Font("Arial", 1, 12));
        this.JBT_Nuevo.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Nuevo.png")));
        this.JBT_Nuevo.setText("Nuevo");
        this.JBT_Nuevo.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.pyp.JD_Seguimiento_ExamenesPyP.3
            public void actionPerformed(ActionEvent evt) {
                JD_Seguimiento_ExamenesPyP.this.JBT_NuevoActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(14, 14, 14).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPObservacion).addGroup(layout.createSequentialGroup().addComponent(this.JDFechaC, -2, 136, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCB_STipoSeguimiento, -2, 326, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JLN_NSeguimiento, -2, 153, -2)))).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addComponent(this.JS_SPHistorico)).addGroup(layout.createSequentialGroup().addGap(0, 3, 32767).addComponent(this.JBT_Nuevo, -2, 261, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBT_Guardar, -2, 261, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 15, 32767).addComponent(this.JBT_Salir, -2, 261, -2))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(15, 15, 15).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JDFechaC, -1, 56, 32767).addComponent(this.JLN_NSeguimiento, -1, -1, 32767)).addComponent(this.JCB_STipoSeguimiento, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPObservacion, -2, 113, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JS_SPHistorico, -2, 176, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBT_Guardar, -2, 44, -2).addComponent(this.JBT_Salir, -1, -1, 32767).addComponent(this.JBT_Nuevo, -2, 44, -2)).addContainerGap(-1, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_GuardarActionPerformed(ActionEvent evt) {
        if (this.JLN_NSeguimiento.getText().isEmpty()) {
            if (!this.JTAObservacion.getText().isEmpty()) {
                if (this.JCB_STipoSeguimiento.getSelectedIndex() != -1) {
                    int x = JOptionPane.showConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 3, new ImageIcon("src/Imagenes/Question.png"));
                    if (x == 0) {
                        try {
                            ItemProcedimientoSeguimientoDTO e = new ItemProcedimientoSeguimientoDTO();
                            e.setFecha(this.xmt.formatoAMD1.format(this.JDFechaC.getDate()));
                            e.setIdTipoSeguimiento(Integer.valueOf(this.xIdTipoSeguimiento[this.JCB_STipoSeguimiento.getSelectedIndex()]).intValue());
                            e.setObservacion(this.JTAObservacion.getText());
                            e.setIdItemsOrden(this.xIdProcedimiento.longValue());
                            e.setIdUsuarioRh(Principal.usuarioSistemaDTO.getIdPersonaCargo().longValue());
                            this.xItemProcedimientoSeguimiento.createSeguimiento(e);
                            Principal.clasepyp.xJIFGestionExamen.mBuscar();
                            dispose();
                            Principal.clasepyp.xJIFGestionExamen.setSelected(true);
                            return;
                        } catch (PropertyVetoException e2) {
                            Logger.getLogger(JD_Seguimiento_ExamenesPyP.class.getName()).log(Level.SEVERE, (String) null, e2);
                            return;
                        }
                    }
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar el tipo de seguimiento", " VERIFICAR", 1, new ImageIcon("src/Imagenes/Information.png"));
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "La observacion no puede ser nula", " VERIFICAR", 1, new ImageIcon("src/Imagenes/Information.png"));
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Registro ya grabado", "VERIFICAR", 1, new ImageIcon("src/Imagenes/Information.png"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_SalirActionPerformed(ActionEvent evt) {
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_NuevoActionPerformed(ActionEvent evt) {
        mNuevo();
    }

    private void springStart() {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"});
        this.xItemProcedimientoSeguimiento = (ItemProcedimientoSeguimientoDAOImpl) classPathXmlApplicationContext.getBean("itemProcedimientoSeguimientoDAO");
        this.xTipoSeguimiento = (TipoSeguimientoCDAOImpl) classPathXmlApplicationContext.getBean("tipoSeguimientoCDAO");
    }

    public void mNuevo() {
        this.JDFechaC.setDate(this.xmt.getFechaActual());
        this.JLN_NSeguimiento.setText("");
        this.JTAObservacion.setText("");
        List<Object[]> list = this.xTipoSeguimiento.listTipoSeguimiento();
        this.JCB_STipoSeguimiento.removeAllItems();
        if (!list.isEmpty()) {
            this.xIdTipoSeguimiento = new String[list.size()];
            for (int x = 0; x < list.size(); x++) {
                this.xIdTipoSeguimiento[x] = list.get(x)[0].toString();
                this.JCB_STipoSeguimiento.addItem(list.get(x)[1].toString());
            }
            this.JCB_STipoSeguimiento.setSelectedIndex(-1);
        }
    }

    private void mCargarDatosTabla() {
        List<Object[]> list = this.xItemProcedimientoSeguimiento.listaSeguimientoItems(this.xIdProcedimiento);
        mCrearTablaSeguimiento();
        this.xmt.mEstablecerTextEditor(this.JTB_SHistorico, 2);
        this.xmt.mEstablecerTextEditor(this.JTB_SHistorico, 3);
        for (int x = 0; x < list.size(); x++) {
            this.xModeloSeguimiento.addRow(this.xDato);
            for (int y = 0; y < this.xModeloSeguimiento.getColumnCount(); y++) {
                this.xModeloSeguimiento.setValueAt(list.get(x)[y], x, y);
            }
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTablaSeguimiento() {
        this.xModeloSeguimiento = new DefaultTableModel(new Object[0], new String[]{"Id", "Fecha", "Tipo", "Observacion", "Cargo", "Responsable"}) { // from class: com.genoma.plus.controller.pyp.JD_Seguimiento_ExamenesPyP.4
            Class[] types = {Long.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTB_SHistorico;
        JTable jTable2 = this.JTB_SHistorico;
        jTable.setAutoResizeMode(0);
        this.JTB_SHistorico.doLayout();
        this.JTB_SHistorico.setModel(this.xModeloSeguimiento);
        this.JTB_SHistorico.getColumnModel().getColumn(0).setPreferredWidth(80);
        this.JTB_SHistorico.getColumnModel().getColumn(1).setPreferredWidth(80);
        this.JTB_SHistorico.getColumnModel().getColumn(2).setPreferredWidth(200);
        this.JTB_SHistorico.getColumnModel().getColumn(3).setPreferredWidth(300);
        this.JTB_SHistorico.getColumnModel().getColumn(4).setPreferredWidth(150);
        this.JTB_SHistorico.getColumnModel().getColumn(5).setPreferredWidth(200);
    }
}
