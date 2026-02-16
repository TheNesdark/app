package com.genoma.plus.controller.general;

import Acceso.Principal;
import com.genoma.plus.dao.general.SO_TipoResultadoDAO;
import com.genoma.plus.dao.impl.general.SO_TipoResultadoDAOImpl;
import com.genoma.plus.dto.general.SO_TipoResultadoDTO;
import java.awt.Color;
import java.awt.Dimension;
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

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/general/JIF_SO_TipoResultado.class */
public class JIF_SO_TipoResultado extends JInternalFrame {
    private int xEstado = 1;
    private int xtipo = -1;
    private DefaultTableModel xmodelo;
    private SO_TipoResultadoDAO xSO_TipoResultadoDAO;
    private Object[] xDato;
    private ButtonGroup BGTipoExamen;
    private JCheckBox JCHEstado;
    private JPanel JPInformacion;
    private JPanel JPTipoExamen;
    private JRadioButton JRBAudiometria;
    private JRadioButton JRBCuestionarios;
    private JRadioButton JRBEspirometria;
    private JRadioButton JRBOptometria;
    private JRadioButton JRBOsteoMuscular;
    private JRadioButton JRBPsicomotriz;
    private JRadioButton JRBVisiometria;
    private JScrollPane JSDetalle;
    private JTable JTDetalle;
    private JTextField JTFNombre;

    public JIF_SO_TipoResultado() {
        initComponents();
        springStart();
        mNuevo();
    }

    private void springStart() {
        this.xSO_TipoResultadoDAO = (SO_TipoResultadoDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("sOTipoResultadoDAOImpl");
    }

    public void mNuevo() {
        this.JTFNombre.setText("");
        this.JCHEstado.setSelected(true);
        this.JRBEspirometria.setSelected(true);
        this.xtipo = 1;
        this.xEstado = 1;
        Principal.mLimpiarDatosP();
        mBuscaDatos();
    }

    public void mGuardar() {
        if (!this.JTFNombre.getText().equals("")) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                SO_TipoResultadoDTO e = new SO_TipoResultadoDTO();
                if (Principal.txtNo.getText().equals("")) {
                    e.setNombre(this.JTFNombre.getText().toUpperCase());
                    e.setTipoExamen(String.valueOf(this.xtipo));
                    e.setEstado(this.xEstado);
                    this.xSO_TipoResultadoDAO.mCreate(e);
                } else {
                    e.setNombre(this.JTFNombre.getText().toUpperCase());
                    e.setTipoExamen(String.valueOf(this.xtipo));
                    e.setEstado(this.xEstado);
                    e.setId(Long.valueOf(Principal.txtNo.getText()));
                    this.xSO_TipoResultadoDAO.mUpdate(e);
                }
                mNuevo();
                return;
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe digitar el Nombre", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        this.JTFNombre.requestFocus();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mModelo() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Nombre", "Tipo De Examen", "Estado"}) { // from class: com.genoma.plus.controller.general.JIF_SO_TipoResultado.1
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
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(50);
    }

    private void mBuscaDatos() {
        mModelo();
        List<SO_TipoResultadoDTO> list = this.xSO_TipoResultadoDAO.mListar();
        for (int x = 0; x < list.size(); x++) {
            this.xmodelo.addRow(this.xDato);
            this.xmodelo.setValueAt(list.get(x).getId(), x, 0);
            this.xmodelo.setValueAt(list.get(x).getNombre(), x, 1);
            this.xmodelo.setValueAt(list.get(x).getTipoExamen(), x, 2);
            if (list.get(x).getEstado() == 1) {
                this.xmodelo.setValueAt(true, x, 3);
            } else {
                this.xmodelo.setValueAt(false, x, 3);
            }
        }
    }

    /* JADX WARN: Type inference failed for: r3v6, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.BGTipoExamen = new ButtonGroup();
        this.JSDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JPInformacion = new JPanel();
        this.JTFNombre = new JTextField();
        this.JCHEstado = new JCheckBox();
        this.JPTipoExamen = new JPanel();
        this.JRBEspirometria = new JRadioButton();
        this.JRBAudiometria = new JRadioButton();
        this.JRBVisiometria = new JRadioButton();
        this.JRBOptometria = new JRadioButton();
        this.JRBOsteoMuscular = new JRadioButton();
        this.JRBCuestionarios = new JRadioButton();
        this.JRBPsicomotriz = new JRadioButton();
        setClosable(true);
        setIconifiable(true);
        setTitle("SALUD OCUPACIONAL TIPO DE RESULTADO");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjifsotiporesultado");
        this.JSDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalle.setSelectionBackground(Color.white);
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.general.JIF_SO_TipoResultado.2
            public void mouseClicked(MouseEvent evt) {
                JIF_SO_TipoResultado.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSDetalle.setViewportView(this.JTDetalle);
        this.JPInformacion.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JTFNombre.setFont(new Font("Arial", 1, 12));
        this.JTFNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFNombre.setPreferredSize((Dimension) null);
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setSelected(true);
        this.JCHEstado.setText("Estado");
        this.JCHEstado.setPreferredSize((Dimension) null);
        this.JCHEstado.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.general.JIF_SO_TipoResultado.3
            public void actionPerformed(ActionEvent evt) {
                JIF_SO_TipoResultado.this.JCHEstadoActionPerformed(evt);
            }
        });
        this.JPTipoExamen.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo de Examen", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.BGTipoExamen.add(this.JRBEspirometria);
        this.JRBEspirometria.setFont(new Font("Arial", 1, 12));
        this.JRBEspirometria.setSelected(true);
        this.JRBEspirometria.setText("Espirometria");
        this.JRBEspirometria.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.general.JIF_SO_TipoResultado.4
            public void actionPerformed(ActionEvent evt) {
                JIF_SO_TipoResultado.this.JRBEspirometriaActionPerformed(evt);
            }
        });
        this.BGTipoExamen.add(this.JRBAudiometria);
        this.JRBAudiometria.setFont(new Font("Arial", 1, 12));
        this.JRBAudiometria.setText("Audiometria");
        this.JRBAudiometria.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.general.JIF_SO_TipoResultado.5
            public void actionPerformed(ActionEvent evt) {
                JIF_SO_TipoResultado.this.JRBAudiometriaActionPerformed(evt);
            }
        });
        this.BGTipoExamen.add(this.JRBVisiometria);
        this.JRBVisiometria.setFont(new Font("Arial", 1, 12));
        this.JRBVisiometria.setText("Visiometria");
        this.JRBVisiometria.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.general.JIF_SO_TipoResultado.6
            public void actionPerformed(ActionEvent evt) {
                JIF_SO_TipoResultado.this.JRBVisiometriaActionPerformed(evt);
            }
        });
        this.BGTipoExamen.add(this.JRBOptometria);
        this.JRBOptometria.setFont(new Font("Arial", 1, 12));
        this.JRBOptometria.setText("Optometria");
        this.JRBOptometria.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.general.JIF_SO_TipoResultado.7
            public void actionPerformed(ActionEvent evt) {
                JIF_SO_TipoResultado.this.JRBOptometriaActionPerformed(evt);
            }
        });
        this.BGTipoExamen.add(this.JRBOsteoMuscular);
        this.JRBOsteoMuscular.setFont(new Font("Arial", 1, 12));
        this.JRBOsteoMuscular.setText("Osteomuscular");
        this.JRBOsteoMuscular.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.general.JIF_SO_TipoResultado.8
            public void actionPerformed(ActionEvent evt) {
                JIF_SO_TipoResultado.this.JRBOsteoMuscularActionPerformed(evt);
            }
        });
        this.BGTipoExamen.add(this.JRBCuestionarios);
        this.JRBCuestionarios.setFont(new Font("Arial", 1, 12));
        this.JRBCuestionarios.setText("Cuestionarios");
        this.JRBCuestionarios.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.general.JIF_SO_TipoResultado.9
            public void actionPerformed(ActionEvent evt) {
                JIF_SO_TipoResultado.this.JRBCuestionariosActionPerformed(evt);
            }
        });
        this.BGTipoExamen.add(this.JRBPsicomotriz);
        this.JRBPsicomotriz.setFont(new Font("Arial", 1, 12));
        this.JRBPsicomotriz.setText("Test Psicomotriz");
        this.JRBPsicomotriz.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.general.JIF_SO_TipoResultado.10
            public void actionPerformed(ActionEvent evt) {
                JIF_SO_TipoResultado.this.JRBPsicomotrizActionPerformed(evt);
            }
        });
        GroupLayout JPTipoExamenLayout = new GroupLayout(this.JPTipoExamen);
        this.JPTipoExamen.setLayout(JPTipoExamenLayout);
        JPTipoExamenLayout.setHorizontalGroup(JPTipoExamenLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPTipoExamenLayout.createSequentialGroup().addContainerGap().addGroup(JPTipoExamenLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPTipoExamenLayout.createSequentialGroup().addComponent(this.JRBEspirometria).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBAudiometria).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBOptometria).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBOsteoMuscular).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBCuestionarios).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBVisiometria)).addComponent(this.JRBPsicomotriz)).addGap(10, 10, 10)));
        JPTipoExamenLayout.setVerticalGroup(JPTipoExamenLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPTipoExamenLayout.createSequentialGroup().addGroup(JPTipoExamenLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBEspirometria).addComponent(this.JRBAudiometria).addComponent(this.JRBVisiometria).addComponent(this.JRBCuestionarios).addComponent(this.JRBOsteoMuscular).addComponent(this.JRBOptometria)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBPsicomotriz).addGap(10, 10, 10)));
        GroupLayout JPInformacionLayout = new GroupLayout(this.JPInformacion);
        this.JPInformacion.setLayout(JPInformacionLayout);
        JPInformacionLayout.setHorizontalGroup(JPInformacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPInformacionLayout.createSequentialGroup().addContainerGap().addComponent(this.JTFNombre, -2, 518, -2).addGap(10, 10, 10).addComponent(this.JCHEstado, -2, -1, -2).addContainerGap()).addComponent(this.JPTipoExamen, -1, -1, 32767));
        JPInformacionLayout.setVerticalGroup(JPInformacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPInformacionLayout.createSequentialGroup().addGap(10, 10, 10).addGroup(JPInformacionLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFNombre, -2, 51, -2).addComponent(this.JCHEstado, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JPTipoExamen, -2, -1, -2).addGap(10, 10, 10)));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JSDetalle).addComponent(this.JPInformacion, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPInformacion, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSDetalle, -1, 217, 32767).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            Principal.txtNo.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
            this.JTFNombre.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString());
            if ("ESPIROMETRIA".equals(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString())) {
                this.JRBEspirometria.setSelected(true);
                this.xtipo = 1;
            } else if ("AUDIOMETRIA".equals(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString())) {
                this.JRBAudiometria.setSelected(true);
                this.xtipo = 2;
            } else if ("OPTOMETRIA".equals(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString())) {
                this.JRBOptometria.setSelected(true);
                this.xtipo = 3;
            } else if ("OSTEOMUSCULAR".equals(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString())) {
                this.JRBOsteoMuscular.setSelected(true);
                this.xtipo = 4;
            } else if ("CUESTIONARIOS".equals(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString())) {
                this.JRBCuestionarios.setSelected(true);
                this.xtipo = 5;
            } else if ("VISIOMETRIA".equals(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString())) {
                this.JRBVisiometria.setSelected(true);
                this.xtipo = 6;
            } else if ("PSICOMOTRIZ".equals(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString())) {
                this.JRBPsicomotriz.setSelected(true);
                this.xtipo = 7;
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
    public void JCHEstadoActionPerformed(ActionEvent evt) {
        if (this.JCHEstado.isSelected()) {
            this.xEstado = 1;
        } else {
            this.xEstado = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBEspirometriaActionPerformed(ActionEvent evt) {
        this.xtipo = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBAudiometriaActionPerformed(ActionEvent evt) {
        this.xtipo = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBOptometriaActionPerformed(ActionEvent evt) {
        this.xtipo = 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBOsteoMuscularActionPerformed(ActionEvent evt) {
        this.xtipo = 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBCuestionariosActionPerformed(ActionEvent evt) {
        this.xtipo = 5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBVisiometriaActionPerformed(ActionEvent evt) {
        this.xtipo = 6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBPsicomotrizActionPerformed(ActionEvent evt) {
        this.xtipo = 7;
    }
}
