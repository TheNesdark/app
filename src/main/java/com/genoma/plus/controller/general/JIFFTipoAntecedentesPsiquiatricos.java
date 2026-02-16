package com.genoma.plus.controller.general;

import Acceso.Principal;
import com.genoma.plus.dao.general.TipoAntecedentesPsiquiatricosDAO;
import com.genoma.plus.dao.impl.general.TipoAntecedentesPsiquiatricosDAOImpl;
import com.genoma.plus.dto.general.TipoAntecedentesPsiquiatricosDTO;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
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
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/general/JIFFTipoAntecedentesPsiquiatricos.class */
public class JIFFTipoAntecedentesPsiquiatricos extends JInternalFrame {
    private DefaultTableModel modelo;
    private TipoAntecedentesPsiquiatricosDAO tipoAntecedentesPsiquiatricosDAO;
    private Object[] dato;
    private JCheckBox JCHEstado;
    private JTable JTDetalle;
    private JTextField JTFNombre;
    private JButton btnGuardar;
    private JButton jButton1;
    private JPanel jPanel1;
    private JScrollPane jScrollPane1;
    private int estado = 1;
    private final TipoAntecedentesPsiquiatricosDTO tipoAntecedentesPsiquiatricosDTO = new TipoAntecedentesPsiquiatricosDTO();

    public JIFFTipoAntecedentesPsiquiatricos() {
        initComponents();
        springStart();
        nuevo();
    }

    private void springStart() {
        this.tipoAntecedentesPsiquiatricosDAO = (TipoAntecedentesPsiquiatricosDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("tipoAntecedentesPsiquiatricosDAO");
    }

    /* JADX WARN: Type inference failed for: r3v3, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jScrollPane1 = new JScrollPane();
        this.JTDetalle = new JTable();
        this.btnGuardar = new JButton();
        this.jPanel1 = new JPanel();
        this.JTFNombre = new JTextField();
        this.JCHEstado = new JCheckBox();
        this.jButton1 = new JButton();
        setClosable(true);
        setTitle("TIPO ANTECEDENTES PSIQUIÁTRICOS");
        setName("tipoAntecedentePsiquiatrico");
        this.jScrollPane1.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalle.setSelectionBackground(Color.white);
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.general.JIFFTipoAntecedentesPsiquiatricos.1
            public void mouseClicked(MouseEvent evt) {
                JIFFTipoAntecedentesPsiquiatricos.this.JTDetalleMouseClicked(evt);
            }
        });
        this.jScrollPane1.setViewportView(this.JTDetalle);
        this.btnGuardar.setFont(new Font("Arial", 1, 12));
        this.btnGuardar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Icono_Guardar_Antecedentes.png")));
        this.btnGuardar.setRolloverIcon(new ImageIcon(getClass().getResource("/Imagenes/Icono_Guardar_Antecedentes_1.png")));
        this.btnGuardar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.general.JIFFTipoAntecedentesPsiquiatricos.2
            public void actionPerformed(ActionEvent evt) {
                JIFFTipoAntecedentesPsiquiatricos.this.btnGuardarActionPerformed(evt);
            }
        });
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JTFNombre.setFont(new Font("Arial", 1, 12));
        this.JTFNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFNombre.setPreferredSize((Dimension) null);
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setSelected(true);
        this.JCHEstado.setText("Estado");
        this.JCHEstado.setPreferredSize((Dimension) null);
        this.JCHEstado.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.general.JIFFTipoAntecedentesPsiquiatricos.3
            public void actionPerformed(ActionEvent evt) {
                JIFFTipoAntecedentesPsiquiatricos.this.JCHEstadoActionPerformed(evt);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JTFNombre, -1, -1, 32767).addGap(18, 18, 18).addComponent(this.JCHEstado, -2, -1, -2).addGap(20, 20, 20)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(2, 2, 2).addComponent(this.JTFNombre, -2, 51, -2)).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.JCHEstado, -2, -1, -2))).addGap(13, 13, 13)));
        this.jButton1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Icono_LimpiarCampos_48_1.png")));
        this.jButton1.setRolloverIcon(new ImageIcon(getClass().getResource("/Imagenes/Icono_LimpiarCampos_48.png")));
        this.jButton1.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.general.JIFFTipoAntecedentesPsiquiatricos.4
            public void actionPerformed(ActionEvent evt) {
                JIFFTipoAntecedentesPsiquiatricos.this.jButton1ActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jScrollPane1, -2, 758, -2).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -1, -1, 32767).addGroup(layout.createSequentialGroup().addComponent(this.jButton1, -2, 253, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.btnGuardar, -2, 231, -2))))).addGap(10, 10, 10)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jButton1, -2, 57, -2).addComponent(this.btnGuardar, -2, 57, -2)).addGap(10, 10, 10).addComponent(this.jScrollPane1, -2, 373, -2).addContainerGap(37, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        Principal.txtNo.setText(this.modelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
        this.JTFNombre.setText(this.modelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString());
        if (Boolean.valueOf(this.modelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString()).booleanValue()) {
            this.JCHEstado.setSelected(true);
            this.estado = 1;
        } else {
            this.JCHEstado.setSelected(false);
            this.estado = 0;
        }
        this.btnGuardar.setEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEstadoActionPerformed(ActionEvent evt) {
        if (this.JCHEstado.isSelected()) {
            this.estado = 1;
        } else {
            this.estado = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnGuardarActionPerformed(ActionEvent evt) {
        guardar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jButton1ActionPerformed(ActionEvent evt) {
        nuevo();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearModelo() {
        this.modelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Tipo Antecedente", "Estado"}) { // from class: com.genoma.plus.controller.general.JIFFTipoAntecedentesPsiquiatricos.5
            Class[] types = {Long.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.modelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(10);
    }

    private void cargarDatos() {
        List<TipoAntecedentesPsiquiatricosDTO> list = this.tipoAntecedentesPsiquiatricosDAO.list();
        crearModelo();
        for (int x = 0; x < list.size(); x++) {
            this.modelo.addRow(this.dato);
            this.modelo.setValueAt(Integer.valueOf(list.get(x).getId()), x, 0);
            this.modelo.setValueAt(list.get(x).getTipoAntecedente(), x, 1);
            if (list.get(x).getEstado() == 1) {
                this.modelo.setValueAt(true, x, 2);
            } else {
                this.modelo.setValueAt(false, x, 2);
            }
        }
    }

    public void guardar() {
        if (!this.JTFNombre.getText().equals("")) {
            if (JOptionPane.showConfirmDialog((Component) null, "Seguro que desea grabar", "Grabar Información Antecedentes Psiquiátricos @GenomaPlus", 1, 3, new ImageIcon("src/Imagenes/Question2.png")) == 0) {
                this.tipoAntecedentesPsiquiatricosDTO.setTipoAntecedente(this.JTFNombre.getText().toUpperCase());
                this.tipoAntecedentesPsiquiatricosDTO.setEstado(this.estado);
                if (Principal.txtNo.getText().equals("")) {
                    this.tipoAntecedentesPsiquiatricosDAO.create(this.tipoAntecedentesPsiquiatricosDTO);
                } else {
                    this.tipoAntecedentesPsiquiatricosDTO.setId(Integer.valueOf(Principal.txtNo.getText()).intValue());
                    this.tipoAntecedentesPsiquiatricosDAO.update(this.tipoAntecedentesPsiquiatricosDTO);
                }
                nuevo();
                return;
            }
            return;
        }
        JOptionPane.showMessageDialog((Component) null, "Digite un tipo de antecedente", "@Guardar Tipo Antecedentes", 1, new ImageIcon("src/Imagenes/Information2.png"));
        this.JTFNombre.requestFocus();
    }

    public void nuevo() {
        this.JTFNombre.setText("");
        this.JCHEstado.setSelected(true);
        this.estado = 1;
        Principal.mLimpiarDatosP();
        cargarDatos();
    }
}
