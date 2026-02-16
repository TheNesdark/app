package com.genoma.plus.controller.presupuesto;

import Acceso.Principal;
import Utilidades.Metodos;
import com.genoma.plus.dao.impl.presupuesto.FinalidadGastoDAOImpl;
import com.genoma.plus.dao.presupuesto.FinalidadGastoDAO;
import com.genoma.plus.dto.presupuesto.FinalidadGastoDTO;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
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
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/presupuesto/JIFFinalidaGasto.class */
public class JIFFinalidaGasto extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private FinalidadGastoDAO xFinalidadGastoDAO;
    private Object[] xdatos;
    private Metodos metodos = new Metodos();
    private JCheckBox JCHEstado;
    private JTextArea JTAObservacion;
    private JTable JTDetalle;
    private JTextField JTFCodigo;
    private JTextField JTFNombre;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;

    public JIFFinalidaGasto() {
        initComponents();
        sprintStart();
        mNuevo();
    }

    private void sprintStart() {
        this.xFinalidadGastoDAO = (FinalidadGastoDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("FinalidadGastoDAO");
    }

    /* JADX WARN: Type inference failed for: r3v24, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jPanel1 = new JPanel();
        this.JTFCodigo = new JTextField();
        this.JTFNombre = new JTextField();
        this.JCHEstado = new JCheckBox();
        this.jScrollPane1 = new JScrollPane();
        this.JTAObservacion = new JTextArea();
        this.jPanel2 = new JPanel();
        this.jScrollPane2 = new JScrollPane();
        this.JTDetalle = new JTable();
        setClosable(true);
        setMaximizable(true);
        setTitle("Finalidad Gasto");
        setFont(new Font("Arial", 1, 12));
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xJIFFinalidadGasto");
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACION", 2, 0, new Font("Arial", 1, 12), new Color(0, 103, 0)));
        this.JTFCodigo.setBorder(BorderFactory.createTitledBorder((Border) null, "Codigo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setForeground(Color.blue);
        this.JCHEstado.setText("Estado");
        this.JTAObservacion.setColumns(20);
        this.JTAObservacion.setRows(5);
        this.JTAObservacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Observacion", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jScrollPane1.setViewportView(this.JTAObservacion);
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane1, -2, 348, -2).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JTFCodigo, -2, 120, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFNombre, -2, 287, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHEstado))).addContainerGap(36, 32767)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHEstado).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTFCodigo, -1, 50, 32767).addComponent(this.JTFNombre))).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jScrollPane1, -1, 70, 32767).addGap(1, 1, 1)));
        this.jPanel2.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 12), Color.red));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalle.setSelectionBackground(Color.white);
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.presupuesto.JIFFinalidaGasto.1
            public void mouseClicked(MouseEvent evt) {
                JIFFinalidaGasto.this.JTDetalleMouseClicked(evt);
            }
        });
        this.jScrollPane2.setViewportView(this.JTDetalle);
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane2, GroupLayout.Alignment.TRAILING));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane2, GroupLayout.Alignment.TRAILING, -1, 231, 32767));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -1, -1, 32767).addComponent(this.jPanel2, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jPanel2, -2, -1, -2)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            Principal.txtNo.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
            this.JTFCodigo.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString());
            this.JTFNombre.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString());
            this.JTAObservacion.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString());
            this.JCHEstado.setSelected(((Boolean) this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 4)).booleanValue());
        }
    }

    public void mGrabar() {
        if (!this.JTFCodigo.getText().isEmpty()) {
            if (!this.JTFNombre.getText().isEmpty()) {
                int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (n == 0) {
                    FinalidadGastoDTO fGastoDTO = new FinalidadGastoDTO();
                    fGastoDTO.setCodigo(this.JTFCodigo.getText());
                    fGastoDTO.setNombre(this.JTFNombre.getText());
                    fGastoDTO.setObservacion(this.JTAObservacion.getText());
                    fGastoDTO.setEstado(this.JCHEstado.isSelected());
                    fGastoDTO.setIdUsuario(Principal.usuarioSistemaDTO.getIdUsuarioSistema().toString());
                    if (Principal.txtNo.getText().isEmpty()) {
                        this.xFinalidadGastoDAO.mCreate(fGastoDTO);
                    } else {
                        fGastoDTO.setId(Integer.parseInt(Principal.txtNo.getText()));
                        this.xFinalidadGastoDAO.mUpdate(fGastoDTO);
                    }
                    mNuevo();
                    return;
                }
                return;
            }
            this.metodos.mostrarMensaje("El campo nombre no puede ser vacio ");
            return;
        }
        this.metodos.mostrarMensaje("El campo codigo no puede ser vacio");
    }

    public void mNuevo() {
        this.JCHEstado.setSelected(true);
        this.JTFCodigo.setText("");
        this.JTFNombre.setText("");
        this.JTAObservacion.setText("");
        mCargarDatos();
        Principal.mLimpiarDatosP();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModelo() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Codigo", "Nombre", "Observacion", "Estado"}) { // from class: com.genoma.plus.controller.presupuesto.JIFFinalidaGasto.2
            Class[] types = {Integer.class, String.class, String.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(60);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(120);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(60);
    }

    private void mCargarDatos() {
        mCrearModelo();
        List<Object[]> listaFGastos = this.xFinalidadGastoDAO.listaFinalidadGasto();
        for (int x = 0; x < listaFGastos.size(); x++) {
            this.xmodelo.addRow(this.xdatos);
            for (int j = 0; j < 5; j++) {
                this.xmodelo.setValueAt(listaFGastos.get(x)[j], x, j);
            }
        }
    }
}
