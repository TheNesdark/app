package com.genoma.plus.controller.rrhh;

import Facturacion.JIFLiqServicios;
import Utilidades.Metodos;
import com.genoma.plus.controller.sgc.JIFRegistroReuniones;
import com.genoma.plus.dao.rrhh.GeneralRhDAO;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/rrhh/JD_ConsultarUsuariosCargos.class */
public class JD_ConsultarUsuariosCargos extends JDialog {
    public DefaultTableModel xModelo;
    private GeneralRhDAO xGeneralRhDAO;
    private Metodos xmt;
    private Object[] xDato;
    private String xNombre;
    private JIFRegistroReuniones xJifReuniones;
    private JIFLiqServicios xJifLiquidacion;
    private ButtonGroup JBG_Seleccion;
    private JButton JBTCargar;
    private JButton JBTCargar1;
    private JPanel JPI_DatosFiltro;
    private JPanel JPTipoPersona;
    private JRadioButton JRB_SNinguno;
    private JRadioButton JRB_STodo;
    private JScrollPane JSP_Detalle;
    private JTable JTB_Detalle;
    private JTextField JTF_FiltroBusqueda;

    public JD_ConsultarUsuariosCargos(Frame parent, boolean modal, String xNombre, Object xJifFormulario) {
        super(parent, modal);
        this.xmt = new Metodos();
        initComponents();
        this.xNombre = xNombre;
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        setLocationRelativeTo(null);
        springStart();
        mRealizarCasting(xJifFormulario);
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v32, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBG_Seleccion = new ButtonGroup();
        this.JPI_DatosFiltro = new JPanel();
        this.JTF_FiltroBusqueda = new JTextField();
        this.JPTipoPersona = new JPanel();
        this.JRB_STodo = new JRadioButton();
        this.JRB_SNinguno = new JRadioButton();
        this.JSP_Detalle = new JScrollPane();
        this.JTB_Detalle = new JTable();
        this.JBTCargar = new JButton();
        this.JBTCargar1 = new JButton();
        setDefaultCloseOperation(2);
        this.JPI_DatosFiltro.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS PARA FILTRO", 0, 0, new Font("Arial", 1, 14), Color.red));
        this.JTF_FiltroBusqueda.setFont(new Font("Arial", 1, 12));
        this.JTF_FiltroBusqueda.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre o documento de indentidad", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTF_FiltroBusqueda.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.rrhh.JD_ConsultarUsuariosCargos.1
            public void keyReleased(KeyEvent evt) {
                JD_ConsultarUsuariosCargos.this.JTF_FiltroBusquedaKeyReleased(evt);
            }
        });
        this.JPTipoPersona.setBorder(BorderFactory.createTitledBorder((Border) null, "Selección", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBG_Seleccion.add(this.JRB_STodo);
        this.JRB_STodo.setFont(new Font("Arial", 1, 12));
        this.JRB_STodo.setText("Todo");
        this.JRB_STodo.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.rrhh.JD_ConsultarUsuariosCargos.2
            public void actionPerformed(ActionEvent evt) {
                JD_ConsultarUsuariosCargos.this.JRB_STodoActionPerformed(evt);
            }
        });
        this.JBG_Seleccion.add(this.JRB_SNinguno);
        this.JRB_SNinguno.setFont(new Font("Arial", 1, 12));
        this.JRB_SNinguno.setSelected(true);
        this.JRB_SNinguno.setText("Ninguno");
        this.JRB_SNinguno.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.rrhh.JD_ConsultarUsuariosCargos.3
            public void actionPerformed(ActionEvent evt) {
                JD_ConsultarUsuariosCargos.this.JRB_SNingunoActionPerformed(evt);
            }
        });
        GroupLayout JPTipoPersonaLayout = new GroupLayout(this.JPTipoPersona);
        this.JPTipoPersona.setLayout(JPTipoPersonaLayout);
        JPTipoPersonaLayout.setHorizontalGroup(JPTipoPersonaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPTipoPersonaLayout.createSequentialGroup().addComponent(this.JRB_STodo).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRB_SNinguno)));
        JPTipoPersonaLayout.setVerticalGroup(JPTipoPersonaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPTipoPersonaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRB_STodo).addComponent(this.JRB_SNinguno)));
        GroupLayout JPI_DatosFiltroLayout = new GroupLayout(this.JPI_DatosFiltro);
        this.JPI_DatosFiltro.setLayout(JPI_DatosFiltroLayout);
        JPI_DatosFiltroLayout.setHorizontalGroup(JPI_DatosFiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DatosFiltroLayout.createSequentialGroup().addContainerGap().addComponent(this.JTF_FiltroBusqueda, -2, 441, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 78, 32767).addComponent(this.JPTipoPersona, -2, -1, -2).addContainerGap()));
        JPI_DatosFiltroLayout.setVerticalGroup(JPI_DatosFiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DatosFiltroLayout.createSequentialGroup().addContainerGap().addGroup(JPI_DatosFiltroLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JPTipoPersona, -2, -1, -2).addComponent(this.JTF_FiltroBusqueda, -2, -1, -2)).addContainerGap(19, 32767)));
        this.JSP_Detalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTB_Detalle.setFont(new Font("Arial", 1, 12));
        this.JTB_Detalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTB_Detalle.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.rrhh.JD_ConsultarUsuariosCargos.4
            public void mouseClicked(MouseEvent evt) {
                JD_ConsultarUsuariosCargos.this.JTB_DetalleMouseClicked(evt);
            }
        });
        this.JSP_Detalle.setViewportView(this.JTB_Detalle);
        this.JBTCargar.setFont(new Font("Arial", 1, 12));
        this.JBTCargar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTCargar.setText("Cargar");
        this.JBTCargar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.rrhh.JD_ConsultarUsuariosCargos.5
            public void actionPerformed(ActionEvent evt) {
                JD_ConsultarUsuariosCargos.this.JBTCargarActionPerformed(evt);
            }
        });
        this.JBTCargar1.setFont(new Font("Arial", 1, 12));
        this.JBTCargar1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.JBTCargar1.setText("Salir");
        this.JBTCargar1.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.rrhh.JD_ConsultarUsuariosCargos.6
            public void actionPerformed(ActionEvent evt) {
                JD_ConsultarUsuariosCargos.this.JBTCargar1ActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSP_Detalle).addComponent(this.JPI_DatosFiltro, -1, -1, 32767).addGroup(layout.createSequentialGroup().addComponent(this.JBTCargar, -2, 316, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JBTCargar1, -2, 316, -2))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPI_DatosFiltro, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSP_Detalle, -2, 253, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JBTCargar1, -1, -1, 32767).addComponent(this.JBTCargar, -1, 50, 32767)).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_STodoActionPerformed(ActionEvent evt) {
        mSeleccionar(this.JRB_STodo.isSelected());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_SNingunoActionPerformed(ActionEvent evt) {
        mSeleccionar(this.JRB_SNinguno.isSelected());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTF_FiltroBusquedaKeyReleased(KeyEvent evt) {
        mCargarDatosTabla();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTB_DetalleMouseClicked(MouseEvent evt) {
        if (this.JTB_Detalle.getRowCount() != -1 && this.JTB_Detalle.getSelectedRow() != -1 && evt.getClickCount() == 2) {
            if (this.xNombre.equals("xJifReunionP1")) {
                this.xJifReuniones.xIdPersonaRhObjetivos = Long.valueOf(this.JTB_Detalle.getValueAt(this.JTB_Detalle.getSelectedRow(), 0).toString()).longValue();
                this.xJifReuniones.JTF_ONombre.setText(this.JTB_Detalle.getValueAt(this.JTB_Detalle.getSelectedRow(), 2).toString());
                this.xJifReuniones.JTF_OCargo.setText(this.JTB_Detalle.getValueAt(this.JTB_Detalle.getSelectedRow(), 3).toString());
                dispose();
                return;
            }
            if (this.xNombre.equals("xJifReunionP2")) {
                this.xJifReuniones.xIdPersonaRhIntegrante = Long.valueOf(this.JTB_Detalle.getValueAt(this.JTB_Detalle.getSelectedRow(), 0).toString()).longValue();
                this.xJifReuniones.JTF_INombre.setText(this.JTB_Detalle.getValueAt(this.JTB_Detalle.getSelectedRow(), 2).toString());
                this.xJifReuniones.JTF_ICargo.setText(this.JTB_Detalle.getValueAt(this.JTB_Detalle.getSelectedRow(), 3).toString());
                this.xJifReuniones.JTF_IEmail.setText(this.JTB_Detalle.getValueAt(this.JTB_Detalle.getSelectedRow(), 5).toString());
                dispose();
                return;
            }
            if (this.xNombre.equals("xJifSEguimiento")) {
                this.xJifLiquidacion.xJPIngresoSeguimientos.xIdPersonaResponsable = Long.valueOf(this.JTB_Detalle.getValueAt(this.JTB_Detalle.getSelectedRow(), 0).toString()).longValue();
                this.xJifLiquidacion.xJPIngresoSeguimientos.JTF_ONombre.setText(this.JTB_Detalle.getValueAt(this.JTB_Detalle.getSelectedRow(), 2).toString());
                this.xJifLiquidacion.xJPIngresoSeguimientos.JTF_OCargo.setText(this.JTB_Detalle.getValueAt(this.JTB_Detalle.getSelectedRow(), 3).toString());
                dispose();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTCargar1ActionPerformed(ActionEvent evt) {
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTCargarActionPerformed(ActionEvent evt) {
        if (this.xNombre.equals("xJifReunionP2") && this.xmt.mVerificarDatosTablaTrue(this.JTB_Detalle, 6)) {
            for (int x = 0; x < this.JTB_Detalle.getRowCount(); x++) {
                if (Boolean.valueOf(this.JTB_Detalle.getValueAt(x, 6).toString()).booleanValue()) {
                    this.xDato = new Object[4];
                    this.xDato[0] = Long.valueOf(this.JTB_Detalle.getValueAt(x, 0).toString());
                    this.xDato[1] = this.JTB_Detalle.getValueAt(x, 3).toString();
                    this.xDato[2] = this.JTB_Detalle.getValueAt(x, 2).toString();
                    this.xDato[3] = this.JTB_Detalle.getValueAt(x, 5).toString();
                    this.xJifReuniones.xModeloIntegrantes.addRow(this.xDato);
                    this.xmt.mEstablecerTextEditor(this.xJifReuniones.JTB_IDetalleIntegrantes, 1);
                    this.xmt.mEstablecerTextEditor(this.xJifReuniones.JTB_IDetalleIntegrantes, 2);
                    this.xJifReuniones.mNuevoIntegrante();
                    this.xJifReuniones.JTF_ICargo.requestFocus();
                }
            }
            dispose();
        }
    }

    private void mSeleccionar(boolean xEstado) {
        if (this.JTB_Detalle.getRowCount() != -1) {
            for (int x = 0; x < this.JTB_Detalle.getRowCount(); x++) {
                this.xModelo.setValueAt(Boolean.valueOf(xEstado), x, 6);
            }
        }
    }

    private void mNuevo() {
        this.JTF_FiltroBusqueda.setText("");
        mCargarDatosTabla();
    }

    private void mRealizarCasting(Object xFormulario) {
        if (this.xNombre.equals("xJifReunionP1") || this.xNombre.equals("xJifReunionP2")) {
            this.xJifReuniones = (JIFRegistroReuniones) xFormulario;
        } else if (this.xNombre.equals("xJifSEguimiento")) {
            this.xJifLiquidacion = (JIFLiqServicios) xFormulario;
        }
    }

    private void springStart() {
        this.xGeneralRhDAO = (GeneralRhDAO) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("generalDAO1");
    }

    private void mModeloDetalle() {
        this.xModelo = new DefaultTableModel((Object[][]) null, new String[]{"Id", "Documento", "Usuario", "Cargo", "Unidad Funcional", "Correo Electronico", "Seleccion"}) { // from class: com.genoma.plus.controller.rrhh.JD_ConsultarUsuariosCargos.7
            Class[] types = {Long.class, String.class, String.class, String.class, String.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false, false, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTB_Detalle;
        JTable jTable2 = this.JTB_Detalle;
        jTable.setAutoResizeMode(0);
        this.JTB_Detalle.doLayout();
        this.JTB_Detalle.setModel(this.xModelo);
        this.JTB_Detalle.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTB_Detalle.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTB_Detalle.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTB_Detalle.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTB_Detalle.getColumnModel().getColumn(2).setPreferredWidth(300);
        this.JTB_Detalle.getColumnModel().getColumn(3).setPreferredWidth(200);
        this.JTB_Detalle.getColumnModel().getColumn(4).setPreferredWidth(200);
        this.JTB_Detalle.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTB_Detalle.getColumnModel().getColumn(6).setPreferredWidth(50);
    }

    private void mCargarDatosTabla() {
        mModeloDetalle();
        List<Object[]> list = this.xGeneralRhDAO.mListadoUsuario(this.JTF_FiltroBusqueda.getText());
        for (int x = 0; x < list.size(); x++) {
            this.xModelo.addRow(this.xDato);
            this.xModelo.setValueAt(list.get(x)[0], x, 0);
            this.xModelo.setValueAt(list.get(x)[1], x, 1);
            this.xModelo.setValueAt(list.get(x)[2], x, 2);
            this.xModelo.setValueAt(list.get(x)[3], x, 3);
            this.xModelo.setValueAt(list.get(x)[4], x, 4);
            this.xModelo.setValueAt(list.get(x)[5], x, 5);
            this.xModelo.setValueAt(false, x, 6);
        }
    }
}
