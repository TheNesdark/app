package com.genoma.plus.controller.presupuesto;

import Acceso.Principal;
import Utilidades.Metodos;
import com.genoma.plus.dao.impl.presupuesto.RubrosContraloriaDAOImpl;
import com.genoma.plus.dao.presupuesto.RubrosContraloriaDAO;
import com.genoma.plus.dto.presupuesto.RubrosContraloriaDTO;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
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

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/presupuesto/JIFRubrosContraloria.class */
public class JIFRubrosContraloria extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private RubrosContraloriaDAO xRubrosContraloriaDAO;
    private Object[] xdatos;
    private Metodos metodos = new Metodos();
    private ButtonGroup BGUltimoNivel;
    private JCheckBox JCHEstado;
    private JPanel JPanelI;
    private JRadioButton JRBNo;
    private JRadioButton JRBSi;
    private JTable JTDetalle;
    private JTextField JTFCodigo;
    private JTextField JTFNombre;
    private JTextField JTFPadre;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JScrollPane jScrollPane1;

    public JIFRubrosContraloria() {
        initComponents();
        sprintStart();
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v48, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.BGUltimoNivel = new ButtonGroup();
        this.JPanelI = new JPanel();
        this.JTFCodigo = new JTextField();
        this.JTFNombre = new JTextField();
        this.JCHEstado = new JCheckBox();
        this.JTFPadre = new JTextField();
        this.jPanel3 = new JPanel();
        this.JRBSi = new JRadioButton();
        this.JRBNo = new JRadioButton();
        this.jPanel2 = new JPanel();
        this.jScrollPane1 = new JScrollPane();
        this.JTDetalle = new JTable();
        setClosable(true);
        setMaximizable(true);
        setTitle("Rubro  Contraloria");
        setFont(new Font("Arial", 1, 12));
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xJIFRubroContraloria");
        this.JPanelI.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACION", 2, 0, new Font("Arial", 1, 12), new Color(0, 103, 0)));
        this.JTFCodigo.setFont(new Font("Arial", 1, 12));
        this.JTFCodigo.setBorder(BorderFactory.createTitledBorder((Border) null, "Codigo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFCodigo.addFocusListener(new FocusAdapter() { // from class: com.genoma.plus.controller.presupuesto.JIFRubrosContraloria.1
            public void focusLost(FocusEvent evt) {
                JIFRubrosContraloria.this.JTFCodigoFocusLost(evt);
            }
        });
        this.JTFNombre.setFont(new Font("Arial", 1, 12));
        this.JTFNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setForeground(Color.blue);
        this.JCHEstado.setText("Estado");
        this.JTFPadre.setFont(new Font("Arial", 1, 12));
        this.JTFPadre.setToolTipText("");
        this.JTFPadre.setBorder(BorderFactory.createTitledBorder((Border) null, "Padre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFPadre.setEnabled(false);
        this.jPanel3.setBorder(BorderFactory.createTitledBorder((Border) null, "Es Ultimo Nivel", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.BGUltimoNivel.add(this.JRBSi);
        this.JRBSi.setFont(new Font("Arial", 1, 12));
        this.JRBSi.setText("Si");
        this.BGUltimoNivel.add(this.JRBNo);
        this.JRBNo.setFont(new Font("Arial", 1, 12));
        this.JRBNo.setText("No");
        GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
        this.jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addComponent(this.JRBSi).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBNo).addGap(0, 43, 32767)));
        jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup().addGap(0, 0, 32767).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBSi).addComponent(this.JRBNo))));
        GroupLayout JPanelILayout = new GroupLayout(this.JPanelI);
        this.JPanelI.setLayout(JPanelILayout);
        JPanelILayout.setHorizontalGroup(JPanelILayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPanelILayout.createSequentialGroup().addGap(21, 21, 21).addGroup(JPanelILayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFCodigo, -2, 130, -2).addComponent(this.JTFPadre, -2, 124, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPanelILayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPanelILayout.createSequentialGroup().addComponent(this.JTFNombre, -1, 387, 32767).addGap(18, 18, 18).addComponent(this.JCHEstado).addGap(43, 43, 43)).addGroup(JPanelILayout.createSequentialGroup().addComponent(this.jPanel3, -2, -1, -2).addContainerGap(-1, 32767)))));
        JPanelILayout.setVerticalGroup(JPanelILayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPanelILayout.createSequentialGroup().addContainerGap().addGroup(JPanelILayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHEstado).addGroup(JPanelILayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTFCodigo, -1, 50, 32767).addComponent(this.JTFNombre))).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPanelILayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JTFPadre, GroupLayout.Alignment.LEADING).addComponent(this.jPanel3, -1, -1, 32767)).addContainerGap(26, 32767)));
        this.jPanel2.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 12), Color.red));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.presupuesto.JIFRubrosContraloria.2
            public void mouseClicked(MouseEvent evt) {
                JIFRubrosContraloria.this.JTDetalleMouseClicked(evt);
            }
        });
        this.jScrollPane1.setViewportView(this.JTDetalle);
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane1, GroupLayout.Alignment.TRAILING, -1, 676, 32767));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane1, -2, 321, -2));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPanelI, -1, -1, 32767).addComponent(this.jPanel2, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPanelI, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel2, -2, -1, -2).addContainerGap(-1, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            this.JCHEstado.setSelected(((Boolean) this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 4)).booleanValue());
            this.JTFCodigo.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
            this.JTFNombre.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString());
            this.JTFPadre.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString());
            if (((Boolean) this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2)).booleanValue()) {
                this.JRBSi.setSelected(true);
            } else {
                this.JRBNo.setSelected(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCodigoFocusLost(FocusEvent evt) {
        if (this.JTFCodigo.getText().length() == 3) {
            this.JTFPadre.setText(this.JTFCodigo.getText().substring(0, this.JTFCodigo.getText().length() - 2));
        } else if (this.JTFCodigo.getText().length() > 3) {
            this.JTFPadre.setText(this.JTFCodigo.getText().substring(0, this.JTFCodigo.getText().length() - 3));
        } else {
            this.JTFPadre.setText("-1");
        }
    }

    private void sprintStart() {
        this.xRubrosContraloriaDAO = (RubrosContraloriaDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("RubrosContraloriaDAO");
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModelo() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Codigo", "Nombre", "EsUltimoNivel", "Padre", "Estado"}) { // from class: com.genoma.plus.controller.presupuesto.JIFRubrosContraloria.3
            Class[] types = {String.class, String.class, Boolean.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(140);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(250);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(80);
    }

    private void mCargarDatos() {
        mCrearModelo();
        List<Object[]> lista = this.xRubrosContraloriaDAO.listaRubroContraloria();
        for (int x = 0; x < lista.size(); x++) {
            this.xmodelo.addRow(this.xdatos);
            for (int j = 0; j < 5; j++) {
                this.xmodelo.setValueAt(lista.get(x)[j], x, j);
            }
        }
    }

    public void mNuevo() {
        this.JTFCodigo.setText("");
        this.JTFNombre.setText("");
        this.JCHEstado.setSelected(true);
        this.JTFPadre.setText("");
        mCargarDatos();
        Principal.mLimpiarDatosP();
    }

    public void mGuardar() {
        if (!this.JTFCodigo.getText().isEmpty()) {
            if (!this.JTFNombre.getText().isEmpty()) {
                if (!this.JTFPadre.getText().isEmpty()) {
                    int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    if (n == 0) {
                        RubrosContraloriaDTO RcontraloriaDTO = new RubrosContraloriaDTO();
                        RcontraloriaDTO.setCodigo(this.JTFCodigo.getText());
                        RcontraloriaDTO.setNombre(this.JTFNombre.getText());
                        RcontraloriaDTO.setIdPadre(this.JTFPadre.getText());
                        if (this.JRBSi.isSelected()) {
                            RcontraloriaDTO.setUltimoNivel(1);
                        } else {
                            RcontraloriaDTO.setUltimoNivel(0);
                        }
                        RcontraloriaDTO.setEstado(this.JCHEstado.isSelected());
                        RcontraloriaDTO.setIdUsuario(Principal.usuarioSistemaDTO.getIdUsuarioSistema().toString());
                        if (!this.xRubrosContraloriaDAO.ValidarExistencia(this.JTFCodigo.getText()) && Principal.txtNo.getText().isEmpty()) {
                            this.xRubrosContraloriaDAO.mCreate(RcontraloriaDTO);
                        } else {
                            this.xRubrosContraloriaDAO.mUpdate(RcontraloriaDTO);
                        }
                        mNuevo();
                        return;
                    }
                    return;
                }
                return;
            }
            this.metodos.mostrarMensaje("El campo nombre no puede estar vacio ");
            return;
        }
        this.metodos.mostrarMensaje("El campo codigo no puede ser vacio");
    }
}
