package ParametrizacionN;

import Acceso.Principal;
import Utilidades.Metodos;
import com.genoma.plus.jpa.entities.GTipoDestinoEntity;
import com.genoma.plus.jpa.service.GTipoDestinoServices;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyVetoException;
import java.util.ArrayList;
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
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:ParametrizacionN/JIFTipoDestino.class */
public class JIFTipoDestino extends JInternalFrame {
    private GTipoDestinoEntity gTipoDestinoEntity;
    private GTipoDestinoServices gTipoDestinoServices;
    private List<GTipoDestinoEntity> listTiposDestinosEntities;
    private DefaultTableModel modelo;
    private Metodos metodos;
    private int estado;
    private JCheckBox JCHEstado;
    private JPanel JPIDatos;
    private JScrollPane JSPDetalle;
    private JTextField JTFCodigo;
    private JTextField JTFNombre;
    private JTextField JTFRips;
    private JTable JTable;

    public JIFTipoDestino() {
        initComponents();
        this.gTipoDestinoEntity = new GTipoDestinoEntity();
        this.gTipoDestinoServices = (GTipoDestinoServices) Principal.contexto.getBean(GTipoDestinoServices.class);
        this.listTiposDestinosEntities = new ArrayList();
        this.modelo = new DefaultTableModel();
        this.estado = 1;
        cargarDatosTabla();
    }

    /* JADX WARN: Type inference failed for: r3v38, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPIDatos = new JPanel();
        this.JTFCodigo = new JTextField();
        this.JCHEstado = new JCheckBox();
        this.JTFNombre = new JTextField();
        this.JTFRips = new JTextField();
        this.JSPDetalle = new JScrollPane();
        this.JTable = new JTable();
        setClosable(true);
        setTitle("TIPO DESTINO");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jiftipodestino");
        try {
            setSelected(true);
        } catch (PropertyVetoException e1) {
            e1.printStackTrace();
        }
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JTFCodigo.setFont(new Font("Arial", 1, 12));
        this.JTFCodigo.setToolTipText("");
        this.JTFCodigo.setBorder(BorderFactory.createTitledBorder((Border) null, "Codigo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFCodigo.addKeyListener(new KeyAdapter() { // from class: ParametrizacionN.JIFTipoDestino.1
            public void keyTyped(KeyEvent evt) {
                JIFTipoDestino.this.JTFCodigoKeyTyped(evt);
            }
        });
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setSelected(true);
        this.JCHEstado.setText("Estado");
        this.JCHEstado.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFTipoDestino.2
            public void actionPerformed(ActionEvent evt) {
                JIFTipoDestino.this.JCHEstadoActionPerformed(evt);
            }
        });
        this.JTFNombre.setFont(new Font("Arial", 1, 12));
        this.JTFNombre.setToolTipText("");
        this.JTFNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRips.setFont(new Font("Arial", 1, 12));
        this.JTFRips.setToolTipText("");
        this.JTFRips.setBorder(BorderFactory.createTitledBorder((Border) null, "RIPS", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRips.addKeyListener(new KeyAdapter() { // from class: ParametrizacionN.JIFTipoDestino.3
            public void keyTyped(KeyEvent evt) {
                JIFTipoDestino.this.JTFRipsKeyTyped(evt);
            }
        });
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addComponent(this.JTFCodigo, -2, 124, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JTFNombre, -2, 214, -2).addGap(27, 27, 27).addComponent(this.JTFRips, -2, 124, -2).addGap(18, 18, 18).addComponent(this.JCHEstado).addGap(36, 36, 36)));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addGap(15, 15, 15).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFCodigo, -2, -1, -2).addComponent(this.JTFNombre, -2, -1, -2).addComponent(this.JCHEstado).addComponent(this.JTFRips, -2, -1, -2)).addContainerGap(24, 32767)));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JSPDetalle.setFont(new Font("Arial", 1, 12));
        this.JTable.setFont(new Font("Arial", 1, 12));
        this.JTable.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTable.setRowHeight(25);
        this.JTable.setSelectionBackground(new Color(255, 255, 255));
        this.JTable.setSelectionForeground(new Color(255, 0, 0));
        this.JTable.setSelectionMode(0);
        this.JTable.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFTipoDestino.4
            public void mouseClicked(MouseEvent evt) {
                JIFTipoDestino.this.JTableMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTable);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JSPDetalle, -1, 650, 32767).addComponent(this.JPIDatos, -1, -1, 32767)).addContainerGap(19, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addGap(18, 18, 18).addComponent(this.JSPDetalle, -2, 293, -2).addContainerGap(36, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTableMouseClicked(MouseEvent evt) {
        seleccionarFila();
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
    public void JTFCodigoKeyTyped(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRipsKeyTyped(KeyEvent evt) {
    }

    public void nuevo() {
        this.JTFCodigo.setText("");
        this.JTFNombre.setText("");
        this.JTFRips.setText("");
        Principal.txtNo.setText("");
        cargarDatosTabla();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearModeloDatos() {
        this.modelo = new DefaultTableModel(new Object[0], new String[]{"CODIGO", "NOMBRE", "RIPS", "ESTADO"}) { // from class: ParametrizacionN.JIFTipoDestino.5
            Class[] types = {String.class, String.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTable.setModel(this.modelo);
        this.JTable.doLayout();
        this.JTable.getColumnModel().getColumn(0).setPreferredWidth(25);
        this.JTable.getColumnModel().getColumn(1).setPreferredWidth(25);
        this.JTable.getColumnModel().getColumn(2).setPreferredWidth(25);
        this.JTable.getColumnModel().getColumn(3).setPreferredWidth(15);
    }

    private void cargarDatosTabla() {
        crearModeloDatos();
        this.listTiposDestinosEntities = this.gTipoDestinoServices.findAllOrderByNbre();
        this.modelo.setRowCount(0);
        for (GTipoDestinoEntity e : this.listTiposDestinosEntities) {
            Object[] fila = {e.getCodigo(), e.getNbre(), Long.valueOf(e.getIdRips()), Boolean.valueOf(e.isEstado())};
            this.modelo.addRow(fila);
        }
    }

    public void grabar() {
        if (!this.JTFCodigo.getText().isEmpty()) {
            if (!this.JTFRips.getText().isEmpty()) {
                if (!this.JTFNombre.getText().isEmpty()) {
                    GTipoDestinoEntity tipoDestinoEntity = new GTipoDestinoEntity();
                    if (!Principal.txtNo.getText().isEmpty()) {
                        tipoDestinoEntity.setId(Integer.valueOf(Integer.parseInt(Principal.txtNo.getText())));
                    }
                    tipoDestinoEntity.setCodigo(this.JTFCodigo.getText());
                    tipoDestinoEntity.setNbre(this.JTFNombre.getText());
                    tipoDestinoEntity.setEstado(this.JCHEstado.isSelected());
                    tipoDestinoEntity.setIdRips(Long.parseLong(this.JTFRips.getText()));
                    int y = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    if (y == 0) {
                        this.gTipoDestinoServices.save(tipoDestinoEntity);
                    }
                    JOptionPane.showMessageDialog((Component) null, "Datos Guardados");
                    nuevo();
                } else {
                    JOptionPane.showInternalMessageDialog(this, "Debe ingresar un nombre", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    this.JTFNombre.requestFocusInWindow();
                }
            } else {
                JOptionPane.showInternalMessageDialog(this, "Debe Ingresar un Rips", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JTFRips.requestFocusInWindow();
            }
        } else {
            JOptionPane.showInternalMessageDialog(this, "Debe Ingresar un codigo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTFCodigo.requestFocusInWindow();
        }
        cargarDatosTabla();
    }

    private void seleccionarFila() {
        int indiceSeleccionado = this.JTable.getSelectedRow();
        if (indiceSeleccionado != -1 && indiceSeleccionado < this.listTiposDestinosEntities.size()) {
            this.gTipoDestinoEntity = this.listTiposDestinosEntities.get(indiceSeleccionado);
            Principal.txtNo.setText(this.gTipoDestinoEntity.getId().toString());
            this.JTFCodigo.setText(this.modelo.getValueAt(indiceSeleccionado, 0).toString());
            this.JTFNombre.setText(this.modelo.getValueAt(indiceSeleccionado, 1).toString());
            this.JTFRips.setText(this.modelo.getValueAt(indiceSeleccionado, 2).toString());
            this.JCHEstado.setSelected(this.gTipoDestinoEntity.isEstado());
        }
    }
}
