package com.genoma.plus.controller.general;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.genoma.plus.dao.general.GrupoExamenFisicoDAO;
import com.genoma.plus.dao.impl.general.GrupoExamenFisicoDAOImpl;
import com.genoma.plus.dto.general.GrupoExamenFisicoDTO;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/general/JIFGrupoExamenFisico.class */
public class JIFGrupoExamenFisico extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private Object[] xdatos;
    private GrupoExamenFisicoDAO xgrupoexamenfisicoDAO;
    private JCheckBox JCBAplicasexo;
    private JCheckBox JCBEstado;
    private JSpinner JSNivel;
    private JSpinner JSOrden;
    private JTextArea JTADatosPredefinidos;
    private JTable JTDetalle;
    private JTextField JTFNombre;
    private JPanel jPanel1;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private ConsultasMySQL xconsulta = new ConsultasMySQL();
    private Metodos xmt = new Metodos();

    public JIFGrupoExamenFisico() {
        initComponents();
        springStart();
        mCargarDatosTabla();
    }

    /* JADX WARN: Type inference failed for: r3v46, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jPanel1 = new JPanel();
        this.JTFNombre = new JTextField();
        this.JSOrden = new JSpinner();
        this.JCBAplicasexo = new JCheckBox();
        this.JCBEstado = new JCheckBox();
        this.jScrollPane2 = new JScrollPane();
        this.JTADatosPredefinidos = new JTextArea();
        this.JSNivel = new JSpinner();
        this.jScrollPane1 = new JScrollPane();
        this.JTDetalle = new JTable();
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("GRUPO EXAMEN FISICO");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("JIFGrupoExamenFisico");
        addInternalFrameListener(new InternalFrameListener() { // from class: com.genoma.plus.controller.general.JIFGrupoExamenFisico.1
            public void internalFrameActivated(InternalFrameEvent evt) {
            }

            public void internalFrameClosed(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                JIFGrupoExamenFisico.this.formInternalFrameClosing(evt);
            }

            public void internalFrameDeactivated(InternalFrameEvent evt) {
            }

            public void internalFrameDeiconified(InternalFrameEvent evt) {
            }

            public void internalFrameIconified(InternalFrameEvent evt) {
            }

            public void internalFrameOpened(InternalFrameEvent evt) {
            }
        });
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACION", 2, 0, new Font("Arial", 1, 12), new Color(0, 103, 0)));
        this.JTFNombre.setFont(new Font("Arial", 1, 12));
        this.JTFNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSOrden.setFont(new Font("Arial", 1, 12));
        this.JSOrden.setModel(new SpinnerNumberModel(0, 0, (Comparable) null, 1));
        this.JSOrden.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Orden", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBAplicasexo.setFont(new Font("Arial", 1, 12));
        this.JCBAplicasexo.setForeground(Color.blue);
        this.JCBAplicasexo.setText("Aplica Sexo?");
        this.JCBAplicasexo.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.general.JIFGrupoExamenFisico.2
            public void actionPerformed(ActionEvent evt) {
                JIFGrupoExamenFisico.this.JCBAplicasexoActionPerformed(evt);
            }
        });
        this.JCBEstado.setFont(new Font("Arial", 1, 12));
        this.JCBEstado.setForeground(Color.blue);
        this.JCBEstado.setText("Estado");
        this.JCBEstado.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.general.JIFGrupoExamenFisico.3
            public void actionPerformed(ActionEvent evt) {
                JIFGrupoExamenFisico.this.JCBEstadoActionPerformed(evt);
            }
        });
        this.JTADatosPredefinidos.setColumns(20);
        this.JTADatosPredefinidos.setFont(new Font("Arial", 1, 12));
        this.JTADatosPredefinidos.setRows(1);
        this.JTADatosPredefinidos.setBorder(BorderFactory.createTitledBorder((Border) null, "Datos Predefinidos", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jScrollPane2.setViewportView(this.JTADatosPredefinidos);
        this.JSNivel.setFont(new Font("Arial", 1, 12));
        this.JSNivel.setModel(new SpinnerNumberModel(0, 0, (Comparable) null, 1));
        this.JSNivel.setBorder(BorderFactory.createTitledBorder((Border) null, "Nivel", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane2).addComponent(this.JTFNombre)).addGap(18, 18, 18).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JSNivel, -2, 79, -2).addComponent(this.JSOrden, -2, 79, -2)).addGap(18, 18, 18).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBAplicasexo).addComponent(this.JCBEstado))));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JTFNombre, -2, 51, -2).addComponent(this.JSNivel, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSOrden, -2, 50, -2).addComponent(this.jScrollPane2, -2, -1, -2)).addContainerGap()).addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup().addComponent(this.JCBAplicasexo).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBEstado)));
        this.jScrollPane1.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 12), Color.red));
        this.jScrollPane1.setName("Grupo Examen Fisico");
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalle.setSelectionBackground(Color.white);
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.general.JIFGrupoExamenFisico.4
            public void mouseClicked(MouseEvent evt) {
                JIFGrupoExamenFisico.this.JTDetalleMouseClicked(evt);
            }
        });
        this.jScrollPane1.setViewportView(this.JTDetalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane1, -1, 795, 32767).addComponent(this.jPanel1, -1, -1, 32767));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.jPanel1, -2, 135, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane1, -1, 308, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBEstadoActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBAplicasexoActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        Principal.txtNo.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
        this.JTFNombre.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString());
        this.JSOrden.setValue(Integer.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString()));
        this.JSNivel.setValue(Integer.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 5).toString()));
        this.JTADatosPredefinidos.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 6).toString());
        this.JCBEstado.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString()).booleanValue());
        this.JCBAplicasexo.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 4).toString()).booleanValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosing(InternalFrameEvent evt) {
        Principal.mLimpiarDatosP();
    }

    private void springStart() {
        this.xgrupoexamenfisicoDAO = (GrupoExamenFisicoDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("GrupoExamenFisicoDAO");
    }

    public void mNuevo() {
        this.JTFNombre.setText("");
        this.JCBEstado.setSelected(false);
        this.JSOrden.setValue(0);
        this.JCBAplicasexo.setSelected(false);
        this.JSNivel.setValue(0);
        this.JTADatosPredefinidos.setText("");
        Principal.mLimpiarDatosP();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[][], java.lang.String[]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new String[0], new String[]{"id", "Nbre", "estado", "Orden", "FiltroSexo", "Nivel", "DatosPredefinidos"}) { // from class: com.genoma.plus.controller.general.JIFGrupoExamenFisico.5
            Class[] types = {Integer.class, String.class, Boolean.class, String.class, Boolean.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(30);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(70);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(70);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(70);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(250);
    }

    private void mCargarDatosTabla() {
        List<GrupoExamenFisicoDTO> list = this.xgrupoexamenfisicoDAO.listExamenesFisicos();
        mCrearModeloDatos();
        for (int x = 0; x < list.size(); x++) {
            this.xmodelo.addRow(this.xdatos);
            this.xmodelo.setValueAt(Integer.valueOf(list.get(x).getId()), x, 0);
            this.xmodelo.setValueAt(list.get(x).getNombre(), x, 1);
            this.xmodelo.setValueAt(Boolean.valueOf(list.get(x).isEstado()), x, 2);
            this.xmodelo.setValueAt(Integer.valueOf(list.get(x).getOrden()), x, 3);
            this.xmodelo.setValueAt(Boolean.valueOf(list.get(x).isFiltroSexo()), x, 4);
            this.xmodelo.setValueAt(Integer.valueOf(list.get(x).getNivel()), x, 5);
            this.xmodelo.setValueAt(list.get(x).getDatosPredefinidos(), x, 6);
        }
    }

    public void mGrabar() {
        if (!this.JTFNombre.getText().equals("")) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                GrupoExamenFisicoDTO xgrupo = new GrupoExamenFisicoDTO();
                xgrupo.setNombre(this.JTFNombre.getText());
                xgrupo.setEstado(this.JCBEstado.isSelected());
                xgrupo.setOrden(((Integer) this.JSOrden.getValue()).intValue());
                xgrupo.setFiltroSexo(this.JCBAplicasexo.isSelected());
                xgrupo.setNivel(((Integer) this.JSNivel.getValue()).intValue());
                xgrupo.setDatosPredefinidos(this.JTADatosPredefinidos.getText());
                xgrupo.setFecha(this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()));
                xgrupo.setUsuario(Principal.usuarioSistemaDTO.getLogin());
                if (Principal.txtNo.getText().equals("")) {
                    this.xgrupoexamenfisicoDAO.mCreate(xgrupo);
                } else {
                    xgrupo.setId(Integer.parseInt(Principal.txtNo.getText()));
                    this.xgrupoexamenfisicoDAO.mUpdate(xgrupo);
                }
                mCargarDatosTabla();
                mNuevo();
            }
        }
    }
}
