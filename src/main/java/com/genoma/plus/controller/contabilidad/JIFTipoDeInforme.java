package com.genoma.plus.controller.contabilidad;

import Acceso.Principal;
import Utilidades.Metodos;
import com.genoma.plus.dao.contabilidad.TipodeInformesDAO;
import com.genoma.plus.dao.impl.contabilidad.TipodeInformesDAOImpl;
import com.genoma.plus.dto.contabilidad.TipoDeInformeDTO;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/contabilidad/JIFTipoDeInforme.class */
public class JIFTipoDeInforme extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private Metodos xmt = new Metodos();
    private Object[] xdatos;
    private TipodeInformesDAO xTipoInformeDao;
    private int xtipo;
    private ButtonGroup JBGTipo;
    private JCheckBox JCEstado;
    private JRadioButton JRBEstadoComp;
    private JRadioButton JRBInfoContaduria;
    private JRadioButton JRBNoAplica;
    private JTable JTDetalle;
    private JTextField JTFNombre;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JScrollPane jScrollPane1;

    public JIFTipoDeInforme() {
        initComponents();
        springStart();
        mNuevo();
    }

    private void springStart() {
        this.xTipoInformeDao = (TipodeInformesDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("xTipodeInformeDAO");
    }

    /* JADX WARN: Type inference failed for: r3v40, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGTipo = new ButtonGroup();
        this.jPanel1 = new JPanel();
        this.JTFNombre = new JTextField();
        this.JCEstado = new JCheckBox();
        this.jPanel3 = new JPanel();
        this.JRBInfoContaduria = new JRadioButton();
        this.JRBEstadoComp = new JRadioButton();
        this.JRBNoAplica = new JRadioButton();
        this.jPanel2 = new JPanel();
        this.jScrollPane1 = new JScrollPane();
        this.JTDetalle = new JTable();
        setClosable(true);
        setMaximizable(true);
        setTitle("Tipo de informes");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("JIFTipoDeInforme");
        setOpaque(false);
        addInternalFrameListener(new InternalFrameListener() { // from class: com.genoma.plus.controller.contabilidad.JIFTipoDeInforme.1
            public void internalFrameOpened(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                JIFTipoDeInforme.this.formInternalFrameClosing(evt);
            }

            public void internalFrameClosed(InternalFrameEvent evt) {
            }

            public void internalFrameIconified(InternalFrameEvent evt) {
            }

            public void internalFrameDeiconified(InternalFrameEvent evt) {
            }

            public void internalFrameActivated(InternalFrameEvent evt) {
            }

            public void internalFrameDeactivated(InternalFrameEvent evt) {
            }
        });
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACION", 2, 0, new Font("Arial", 1, 12), new Color(0, 103, 0)));
        this.JTFNombre.setFont(new Font("Arial", 1, 12));
        this.JTFNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCEstado.setFont(new Font("Arial", 1, 12));
        this.JCEstado.setForeground(Color.blue);
        this.JCEstado.setText("Estado");
        this.jPanel3.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo", 2, 0, new Font("Arial", 1, 12), new Color(0, 103, 0)));
        this.JBGTipo.add(this.JRBInfoContaduria);
        this.JRBInfoContaduria.setFont(new Font("Arial", 1, 12));
        this.JRBInfoContaduria.setForeground(Color.blue);
        this.JRBInfoContaduria.setText("Info Contaduria");
        this.JBGTipo.add(this.JRBEstadoComp);
        this.JRBEstadoComp.setFont(new Font("Arial", 1, 12));
        this.JRBEstadoComp.setForeground(Color.blue);
        this.JRBEstadoComp.setText("Estado Comparativo");
        this.JBGTipo.add(this.JRBNoAplica);
        this.JRBNoAplica.setFont(new Font("Arial", 1, 12));
        this.JRBNoAplica.setForeground(Color.blue);
        this.JRBNoAplica.setText("No Aplica");
        GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
        this.jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addComponent(this.JRBInfoContaduria).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 26, 32767).addComponent(this.JRBNoAplica)).addGroup(jPanel3Layout.createSequentialGroup().addComponent(this.JRBEstadoComp).addGap(0, 0, 32767))).addContainerGap()));
        jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBInfoContaduria).addComponent(this.JRBNoAplica)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JRBEstadoComp)));
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.JTFNombre, -2, 298, -2).addGap(18, 18, 18).addComponent(this.jPanel3, -2, -1, -2).addGap(18, 18, 18).addComponent(this.JCEstado).addContainerGap(-1, 32767)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel3, -2, -1, -2).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCEstado).addComponent(this.JTFNombre, -2, 52, -2)))).addContainerGap(-1, 32767)));
        this.jPanel2.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 12), new Color(0, 103, 0)));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalle.setSelectionBackground(Color.white);
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.contabilidad.JIFTipoDeInforme.2
            public void mouseClicked(MouseEvent evt) {
                JIFTipoDeInforme.this.JTDetalleMouseClicked(evt);
            }
        });
        this.jScrollPane1.setViewportView(this.JTDetalle);
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.jScrollPane1).addContainerGap()));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.jScrollPane1, -2, 266, -2).addGap(44, 44, 44)));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.jPanel2, -1, -1, 32767).addComponent(this.jPanel1, -1, -1, 32767)).addContainerGap(-1, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel2, -2, 297, -2).addContainerGap(-1, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosing(InternalFrameEvent evt) {
        Principal.mLimpiarDatosP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        Principal.txtNo.setText(this.JTDetalle.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
        this.JTFNombre.setText(this.JTDetalle.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString());
        switch (this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString()) {
            case "No Aplica":
                this.JRBNoAplica.setSelected(true);
                break;
            case "Info Contaduria":
                this.JRBInfoContaduria.setSelected(true);
                break;
            default:
                this.JRBEstadoComp.setSelected(true);
                break;
        }
        this.JCEstado.setSelected(((Boolean) this.JTDetalle.getValueAt(this.JTDetalle.getSelectedRow(), 3)).booleanValue());
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModelo() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"id", "Nombre", "Tipo", "Estado"}) { // from class: com.genoma.plus.controller.contabilidad.JIFTipoDeInforme.3
            Class[] types = {Integer.class, String.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(40);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(250);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(70);
    }

    private void mCargarDatos() {
        mCrearModelo();
        List<TipoDeInformeDTO> listadoE = this.xTipoInformeDao.listaTInformes();
        for (int x = 0; x < listadoE.size(); x++) {
            this.xmodelo.addRow(this.xdatos);
            this.xmodelo.setValueAt(Long.valueOf(listadoE.get(x).getId()), x, 0);
            this.xmodelo.setValueAt(listadoE.get(x).getNombre(), x, 1);
            switch (listadoE.get(x).getXtipo()) {
                case -1:
                    this.xmodelo.setValueAt("No Aplica", x, 2);
                    break;
                case 0:
                    this.xmodelo.setValueAt("Info Contaduria", x, 2);
                    break;
                default:
                    this.xmodelo.setValueAt("Estados Comparativos", x, 2);
                    break;
            }
            this.xmodelo.setValueAt(Boolean.valueOf(listadoE.get(x).isEstado()), x, 3);
        }
    }

    public void mNuevo() {
        this.JTFNombre.setText("");
        this.JCEstado.setSelected(true);
        this.JRBNoAplica.setSelected(true);
        Principal.mLimpiarDatosP();
        mCargarDatos();
    }

    public void mGrabar() {
        if (!this.JTFNombre.getText().isEmpty()) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                TipoDeInformeDTO xTIDTO = new TipoDeInformeDTO();
                xTIDTO.setNombre(this.JTFNombre.getText());
                xTIDTO.setEstado(this.JCEstado.isSelected());
                xTIDTO.setIdUsuario(Principal.usuarioSistemaDTO.getIdUsuarioSistema().toString());
                if (this.JRBNoAplica.isSelected()) {
                    this.xtipo = -1;
                } else if (this.JRBEstadoComp.isSelected()) {
                    this.xtipo = 1;
                } else {
                    this.xtipo = 0;
                }
                xTIDTO.setXtipo(this.xtipo);
                if (Principal.txtNo.getText().isEmpty()) {
                    this.xTipoInformeDao.mCreate(xTIDTO);
                } else {
                    xTIDTO.setId(Long.parseLong(Principal.txtNo.getText()));
                    this.xTipoInformeDao.mUpdate(xTIDTO);
                }
                mNuevo();
            }
        }
    }
}
