package com.genoma.plus.controller.inventario;

import Acceso.Principal;
import Utilidades.Metodos;
import com.genoma.plus.dao.impl.inventario.ClasificacionLasaDAOImpl;
import com.genoma.plus.dao.inventario.ClasificacionLasaDAO;
import com.genoma.plus.dto.inventario.ClasificacionLasaDTO;
import java.awt.Color;
import java.awt.Component;
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
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
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

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/inventario/JIFClasificacionLasa.class */
public class JIFClasificacionLasa extends JInternalFrame {
    private DefaultTableModel modelo;
    private ClasificacionLasaDAO clasificacionLasaDAO;
    private Object[] datos;
    private Color color = null;
    private Metodos metodos;
    private JButton JBSelecionarColor;
    private JCheckBox JCEstado;
    private JLabel JLColorSelecionado;
    private JTextArea JTAObservacion;
    private JTable JTDetalle;
    private JTextField JTFAlerta;
    private JTextField JTFNombre;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;

    public JIFClasificacionLasa() {
        initComponents();
        springStart();
        limpiarCampos();
        this.JTDetalle.setDefaultRenderer(Object.class, new MiRenderColoresColumnasPorFilas());
    }

    private void springStart() {
        this.clasificacionLasaDAO = (ClasificacionLasaDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("ClasificacionLasaDAO");
    }

    /* JADX WARN: Type inference failed for: r3v31, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jPanel1 = new JPanel();
        this.JTFNombre = new JTextField();
        this.JTFAlerta = new JTextField();
        this.JBSelecionarColor = new JButton();
        this.jScrollPane1 = new JScrollPane();
        this.JTAObservacion = new JTextArea();
        this.JLColorSelecionado = new JLabel();
        this.JCEstado = new JCheckBox();
        this.jPanel2 = new JPanel();
        this.jScrollPane2 = new JScrollPane();
        this.JTDetalle = new JTable();
        setClosable(true);
        setMaximizable(true);
        setTitle("Clasificacion Lasa");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("JIFClasificacionLasa");
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "Informacion", 2, 0, new Font("Arial", 1, 12), new Color(0, 103, 0)));
        this.JTFNombre.setFont(new Font("Arial", 1, 12));
        this.JTFNombre.setToolTipText("");
        this.JTFNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFAlerta.setFont(new Font("Arial", 1, 12));
        this.JTFAlerta.setBorder(BorderFactory.createTitledBorder((Border) null, "Alerta", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBSelecionarColor.setFont(new Font("Arial", 1, 12));
        this.JBSelecionarColor.setForeground(Color.blue);
        this.JBSelecionarColor.setText("Selecionar Color");
        this.JBSelecionarColor.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.inventario.JIFClasificacionLasa.1
            public void actionPerformed(ActionEvent evt) {
                JIFClasificacionLasa.this.JBSelecionarColorActionPerformed(evt);
            }
        });
        this.JTAObservacion.setColumns(20);
        this.JTAObservacion.setFont(new Font("Arial", 1, 12));
        this.JTAObservacion.setRows(5);
        this.JTAObservacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Observacion", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jScrollPane1.setViewportView(this.JTAObservacion);
        this.JLColorSelecionado.setBackground(Color.white);
        this.JLColorSelecionado.setToolTipText("");
        this.JLColorSelecionado.setOpaque(true);
        this.JCEstado.setFont(new Font("Arial", 1, 12));
        this.JCEstado.setForeground(Color.blue);
        this.JCEstado.setText("Estado");
        this.JCEstado.setToolTipText("");
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.jScrollPane1, GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JTFNombre, -2, 173, -2).addGap(18, 18, 18).addComponent(this.JTFAlerta, -2, 293, -2))).addGap(18, 18, 18).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JBSelecionarColor, -1, 247, 32767).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JCEstado, -2, 99, -2).addGap(0, 0, 32767)).addComponent(this.JLColorSelecionado, GroupLayout.Alignment.TRAILING, -1, -1, 32767)).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(28, 28, 28).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JCEstado).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTFNombre, -1, 55, 32767).addComponent(this.JTFAlerta, -2, 50, -2).addComponent(this.JBSelecionarColor, -1, -1, 32767)).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane1, -2, 75, -2)).addGroup(jPanel1Layout.createSequentialGroup().addGap(14, 14, 14).addComponent(this.JLColorSelecionado, -2, 41, -2))))).addContainerGap(-1, 32767)));
        this.jPanel2.setBorder(BorderFactory.createTitledBorder((Border) null, "Detalle", 2, 0, new Font("Arial", 1, 12), Color.red));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalle.setSelectionBackground(Color.white);
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.inventario.JIFClasificacionLasa.2
            public void mouseClicked(MouseEvent evt) {
                JIFClasificacionLasa.this.JTDetalleMouseClicked(evt);
            }
        });
        this.jScrollPane2.setViewportView(this.JTDetalle);
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane2));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane2, -1, 176, 32767));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -1, -1, 32767).addComponent(this.jPanel2, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, 195, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel2, -2, -1, -2).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBSelecionarColorActionPerformed(ActionEvent evt) {
        new JColorChooser();
        this.color = JColorChooser.showDialog((Component) null, "selecione el color", Color.yellow);
        this.JLColorSelecionado.setBackground(this.color);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            Principal.txtNo.setText(this.JTDetalle.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
            this.JTFNombre.setText(this.JTDetalle.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString());
            this.JTFAlerta.setText(this.JTDetalle.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString());
            this.JTAObservacion.setText(this.JTDetalle.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString());
            if (!this.JTDetalle.getValueAt(this.JTDetalle.getSelectedRow(), 4).equals("") && this.JTDetalle.getValueAt(this.JTDetalle.getSelectedRow(), 4) != null) {
                this.color = new Color(Integer.parseInt(this.JTDetalle.getValueAt(this.JTDetalle.getSelectedRow(), 4).toString()));
                this.JLColorSelecionado.setBackground(this.color);
            } else {
                this.JLColorSelecionado.setBackground(Color.white);
            }
        }
    }

    public void limpiarCampos() {
        this.JTAObservacion.setText("");
        this.JTFNombre.setText("");
        this.JTFAlerta.setText("");
        this.JLColorSelecionado.setBackground(Color.white);
        Principal.txtNo.setText("");
        this.JCEstado.setSelected(true);
        cargarDatos();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearModelo() {
        this.modelo = new DefaultTableModel(new Object[0], new String[]{"id", "Nombre", "Observacion", "Alerta", "color", "Estado"}) { // from class: com.genoma.plus.controller.inventario.JIFClasificacionLasa.3
            Class[] types = {Integer.class, String.class, String.class, String.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.modelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(40);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(70);
    }

    private void cargarDatos() {
        List<ClasificacionLasaDTO> listaClasificacionLasa = this.clasificacionLasaDAO.listaClasificacionLasa();
        crearModelo();
        for (int x = 0; x < listaClasificacionLasa.size(); x++) {
            this.modelo.addRow(this.datos);
            this.modelo.setValueAt(Integer.valueOf(listaClasificacionLasa.get(x).getId()), x, 0);
            this.modelo.setValueAt(listaClasificacionLasa.get(x).getNombre(), x, 1);
            this.modelo.setValueAt(listaClasificacionLasa.get(x).getObservacion(), x, 2);
            this.modelo.setValueAt(listaClasificacionLasa.get(x).getMAlerta(), x, 3);
            this.modelo.setValueAt(listaClasificacionLasa.get(x).getColor(), x, 4);
            this.modelo.setValueAt(Boolean.valueOf(listaClasificacionLasa.get(x).isEstado()), x, 5);
        }
    }

    public void grabar() {
        if (!this.JTFNombre.getText().isEmpty()) {
            if (this.color != null) {
                ClasificacionLasaDTO clasificacionLasa = new ClasificacionLasaDTO();
                clasificacionLasa.setNombre(this.JTFNombre.getText());
                clasificacionLasa.setMAlerta(this.JTFAlerta.getText());
                clasificacionLasa.setObservacion(this.JTAObservacion.getText());
                clasificacionLasa.setEstado(this.JCEstado.isSelected());
                clasificacionLasa.setColor("" + this.color.getRGB());
                clasificacionLasa.setUsuarioSistema(Principal.usuarioSistemaDTO.getNombreUsuario());
                int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (n == 0) {
                    if (Principal.txtNo.getText().isEmpty()) {
                        this.clasificacionLasaDAO.crearClasificacionLasa(clasificacionLasa);
                    } else {
                        clasificacionLasa.setId(Integer.parseInt(Principal.txtNo.getText()));
                        this.clasificacionLasaDAO.actualizarClasificacionLasa(clasificacionLasa);
                    }
                    limpiarCampos();
                    return;
                }
                return;
            }
            this.metodos.mostrarMensaje("Se debe selecionar un color");
            return;
        }
        this.metodos.mostrarMensaje("Se debe diligenciar el campo Nombre");
    }
}
