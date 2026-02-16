package com.genoma.plus.controller.general;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import com.genoma.plus.dao.general.TipoDocumentoClasificacionDAO;
import com.genoma.plus.dao.impl.general.TipoDocumentoClasificacionDAOImpl;
import com.genoma.plus.dto.general.TipoDocumentoClasificacionDTO;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.table.DefaultTableModel;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/general/JIFTipoDocumentoClasificacion.class */
public class JIFTipoDocumentoClasificacion extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private Object[] xdatos;
    private TipoDocumentoClasificacionDAO xTipoDocumentoClasificacionDAO;
    private ButtonGroup JBGOperaciones;
    private JCheckBox JCHEstado;
    private JPanel JPTipOperacion;
    private JRadioButton JRNoAplica;
    private JRadioButton JRResta;
    private JRadioButton JRSuma;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;
    private JTextField JTFNombre;
    private JPanel jPanel1;
    private int xEstado = 1;
    private ConsultasMySQL xconsulta = new ConsultasMySQL();
    private String xoperacion = "-1";

    public JIFTipoDocumentoClasificacion() {
        initComponents();
        springStart();
        mCargarDatosTabla();
    }

    private void springStart() {
        this.xTipoDocumentoClasificacionDAO = (TipoDocumentoClasificacionDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("tipoDocumentoClasificacionDAO");
    }

    public void mNuevo() {
        Principal.mLimpiarDatosP();
        this.JTFNombre.setText("");
        this.JRNoAplica.setSelected(true);
        this.xoperacion = "-1";
        this.JCHEstado.setSelected(true);
        this.xEstado = 1;
        mCargarDatosTabla();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Nombre", "Operacion", "Estado"}) { // from class: com.genoma.plus.controller.general.JIFTipoDocumentoClasificacion.1
            Class[] types = {Long.class, String.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(50);
    }

    private void mCargarDatosTabla() {
        List<TipoDocumentoClasificacionDTO> list = this.xTipoDocumentoClasificacionDAO.listTipoDocumentoClasificacion();
        mCrearModeloDatos();
        for (int x = 0; x < list.size(); x++) {
            this.xmodelo.addRow(this.xdatos);
            this.xmodelo.setValueAt(list.get(x).getId(), x, 0);
            this.xmodelo.setValueAt(list.get(x).getNombre(), x, 1);
            this.xmodelo.setValueAt(list.get(x).getOperacion(), x, 2);
            if (list.get(x).getEstado() == 1) {
                this.xmodelo.setValueAt(true, x, 3);
            } else {
                this.xmodelo.setValueAt(false, x, 3);
            }
        }
    }

    public void mGrabar() {
        if (!this.JTFNombre.getText().isEmpty()) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                TipoDocumentoClasificacionDTO e = new TipoDocumentoClasificacionDTO();
                if (Principal.txtNo.getText().isEmpty()) {
                    e.setNombre(this.JTFNombre.getText().toUpperCase());
                    e.setOperacion(this.xoperacion);
                    e.setEstado(this.xEstado);
                    this.xTipoDocumentoClasificacionDAO.mCreate(e);
                } else {
                    e.setNombre(this.JTFNombre.getText().toUpperCase());
                    e.setOperacion(this.xoperacion);
                    e.setEstado(this.xEstado);
                    e.setId(Long.valueOf(Principal.txtNo.getText()));
                    this.xTipoDocumentoClasificacionDAO.mUpdate(e);
                }
                mNuevo();
                return;
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe Ingresar un Nombre", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        this.JTFNombre.requestFocus();
    }

    /* JADX WARN: Type inference failed for: r3v47, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGOperaciones = new ButtonGroup();
        this.jPanel1 = new JPanel();
        this.JTFNombre = new JTextField();
        this.JCHEstado = new JCheckBox();
        this.JPTipOperacion = new JPanel();
        this.JRSuma = new JRadioButton();
        this.JRNoAplica = new JRadioButton();
        this.JRResta = new JRadioButton();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("CLASIFICACION DE TIPO DOCUMENTO");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjiftipodocumentoclasificacion");
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACION", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTFNombre.setFont(new Font("Arial", 1, 12));
        this.JTFNombre.setToolTipText("");
        this.JTFNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setText("Estado");
        this.JCHEstado.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.general.JIFTipoDocumentoClasificacion.2
            public void actionPerformed(ActionEvent evt) {
                JIFTipoDocumentoClasificacion.this.JCHEstadoActionPerformed(evt);
            }
        });
        this.JPTipOperacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Operacion", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBGOperaciones.add(this.JRSuma);
        this.JRSuma.setFont(new Font("Arial", 1, 12));
        this.JRSuma.setText("Suma");
        this.JRSuma.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.general.JIFTipoDocumentoClasificacion.3
            public void actionPerformed(ActionEvent evt) {
                JIFTipoDocumentoClasificacion.this.JRSumaActionPerformed(evt);
            }
        });
        this.JBGOperaciones.add(this.JRNoAplica);
        this.JRNoAplica.setFont(new Font("Arial", 1, 12));
        this.JRNoAplica.setSelected(true);
        this.JRNoAplica.setText("No Aplica");
        this.JRNoAplica.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.general.JIFTipoDocumentoClasificacion.4
            public void actionPerformed(ActionEvent evt) {
                JIFTipoDocumentoClasificacion.this.JRNoAplicaActionPerformed(evt);
            }
        });
        this.JBGOperaciones.add(this.JRResta);
        this.JRResta.setFont(new Font("Arial", 1, 12));
        this.JRResta.setText("Resta");
        this.JRResta.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.general.JIFTipoDocumentoClasificacion.5
            public void actionPerformed(ActionEvent evt) {
                JIFTipoDocumentoClasificacion.this.JRRestaActionPerformed(evt);
            }
        });
        GroupLayout JPTipOperacionLayout = new GroupLayout(this.JPTipOperacion);
        this.JPTipOperacion.setLayout(JPTipOperacionLayout);
        JPTipOperacionLayout.setHorizontalGroup(JPTipOperacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPTipOperacionLayout.createSequentialGroup().addGap(2, 2, 2).addComponent(this.JRNoAplica).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRSuma).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 12, 32767).addComponent(this.JRResta).addContainerGap()));
        JPTipOperacionLayout.setVerticalGroup(JPTipOperacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPTipOperacionLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRSuma).addComponent(this.JRNoAplica).addComponent(this.JRResta)));
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFNombre).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JPTipOperacion, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHEstado).addGap(0, 0, 0))).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(12, 12, 12).addComponent(this.JTFNombre, -2, 47, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JPTipOperacion, -2, -1, -2).addComponent(this.JCHEstado)).addGap(10, 10, 10)));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.general.JIFTipoDocumentoClasificacion.6
            public void mouseClicked(MouseEvent evt) {
                JIFTipoDocumentoClasificacion.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JSPDetalle, -1, 563, 32767).addComponent(this.jPanel1, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalle, -2, 289, -2).addGap(10, 10, 10)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEstadoActionPerformed(ActionEvent evt) {
        if (this.JCHEstado.isSelected()) {
            this.xEstado = 1;
        } else {
            this.xEstado = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRSumaActionPerformed(ActionEvent evt) {
        this.xoperacion = "0";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRNoAplicaActionPerformed(ActionEvent evt) {
        this.xoperacion = "-1";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            Principal.txtNo.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
            this.JTFNombre.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString());
            if (this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString().equals("SUMA")) {
                this.JRSuma.setSelected(true);
                this.xoperacion = "0";
            } else if (this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString().equals("RESTA")) {
                this.JRResta.setSelected(true);
                this.xoperacion = "1";
            } else {
                this.JRNoAplica.setSelected(true);
                this.xoperacion = "-1";
            }
            if (Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString()).booleanValue()) {
                this.JCHEstado.setSelected(true);
                this.xEstado = 1;
            } else {
                this.JCHEstado.setSelected(false);
                this.xEstado = 0;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRRestaActionPerformed(ActionEvent evt) {
        this.xoperacion = "1";
    }
}
