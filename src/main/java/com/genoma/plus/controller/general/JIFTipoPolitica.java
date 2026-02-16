package com.genoma.plus.controller.general;

import Acceso.Principal;
import Utilidades.Metodos;
import com.genoma.plus.jpa.entities.RhTipoPoliticas;
import com.genoma.plus.jpa.projection.ITipoPoliticas;
import com.genoma.plus.jpa.service.IRhTipoPoliticasService;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.text.DecimalFormat;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/general/JIFTipoPolitica.class */
public class JIFTipoPolitica extends JInternalFrame {
    private Object[] xdatos;
    private List<ITipoPoliticas> listaTipoPoliticas;
    private DefaultTableModel xmodelo;
    private JComboBox<String> JCBTipo;
    private JCheckBox JCHEstado;
    private JFormattedTextField JFTFCSalvamento;
    private JPanel JPInformacion;

    /* JADX INFO: renamed from: JSPAño, reason: contains not printable characters */
    private JSpinner f21JSPAo;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;
    private JTextField JTFNombre;
    private JTextField JTFUrlSoporte;
    private Metodos metodos = new Metodos();
    private final IRhTipoPoliticasService xIRhTipoPoliticasService = (IRhTipoPoliticasService) Principal.contexto.getBean(IRhTipoPoliticasService.class);

    public JIFTipoPolitica() {
        initComponents();
        mNuevo();
    }

    public void mNuevo() {
        this.JTFNombre.setText("");
        this.f21JSPAo.setValue(Integer.valueOf(this.metodos.formatoANO.format(this.metodos.getFechaActual())));
        this.JCBTipo.setSelectedIndex(-1);
        this.JFTFCSalvamento.setValue(0);
        this.JTFUrlSoporte.setText("");
        this.JCHEstado.setSelected(true);
        mCargarDatosTabla();
    }

    public void mGrabar() {
        if (!this.JTFNombre.getText().isEmpty()) {
            if (this.JCBTipo.getSelectedIndex() != -1) {
                int n = JOptionPane.showConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (n == 0) {
                    RhTipoPoliticas e = new RhTipoPoliticas();
                    e.setNbre(this.JTFNombre.getText());
                    e.setAno(Integer.valueOf(this.f21JSPAo.getValue().toString()));
                    e.setTipo(Integer.valueOf(this.JCBTipo.getSelectedIndex()));
                    e.setCSalvamento(Double.valueOf(this.JFTFCSalvamento.getValue().toString()));
                    e.setUrlSoporte(this.JTFUrlSoporte.getText());
                    e.setEstado(Boolean.valueOf(this.JCHEstado.isSelected()));
                    e.setUsuarioS(Principal.usuarioSistemaDTO.getLogin());
                    e.setFecha(this.metodos.getFechaActual());
                    if (this.JTDetalle.getSelectedRow() != -1) {
                        e.setId(Integer.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString()));
                    }
                    this.xIRhTipoPoliticasService.grabar(e);
                    mNuevo();
                    return;
                }
                return;
            }
            JOptionPane.showMessageDialog(this, "Debe seleccionar un Tipo de Politica", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            this.JCBTipo.requestFocus();
            return;
        }
        JOptionPane.showMessageDialog(this, "Debe digitar el nombre de la carpeta", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        this.JTFNombre.requestFocus();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloTabla() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Nombre", "Año", "Tipo", "C/Salvamento", "Ruta", "Estado"}) { // from class: com.genoma.plus.controller.general.JIFTipoPolitica.1
            Class[] types = {Integer.class, String.class, Integer.class, String.class, Double.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTDetalle;
        JTable jTable2 = this.JTDetalle;
        jTable.setAutoResizeMode(0);
        this.JTDetalle.doLayout();
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(80);
    }

    private void mCargarDatosTabla() {
        mCrearModeloTabla();
        this.listaTipoPoliticas = this.xIRhTipoPoliticasService.listaTipoPoliticas();
        if (!this.listaTipoPoliticas.isEmpty()) {
            for (int i = 0; i < this.listaTipoPoliticas.size(); i++) {
                this.xmodelo.addRow(this.xdatos);
                this.xmodelo.setValueAt(this.listaTipoPoliticas.get(i).getId(), i, 0);
                this.xmodelo.setValueAt(this.listaTipoPoliticas.get(i).getNbre(), i, 1);
                this.xmodelo.setValueAt(this.listaTipoPoliticas.get(i).getAno(), i, 2);
                this.xmodelo.setValueAt(this.listaTipoPoliticas.get(i).getTipo(), i, 3);
                this.xmodelo.setValueAt(this.listaTipoPoliticas.get(i).getCSalvamento(), i, 4);
                this.xmodelo.setValueAt(this.listaTipoPoliticas.get(i).getUrlSoporte(), i, 5);
                this.xmodelo.setValueAt(this.listaTipoPoliticas.get(i).getEstado(), i, 6);
            }
        }
    }

    /* JADX WARN: Type inference failed for: r3v42, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPInformacion = new JPanel();
        this.JTFUrlSoporte = new JTextField();
        this.f21JSPAo = new JSpinner();
        this.JTFNombre = new JTextField();
        this.JFTFCSalvamento = new JFormattedTextField();
        this.JCHEstado = new JCheckBox();
        this.JCBTipo = new JComboBox<>();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("TIPOS DE POLÍTICAS");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjiftipopoliticas");
        this.JPInformacion.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACION", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JPInformacion.setForeground(new Color(0, 103, 0));
        this.JPInformacion.setFont(new Font("Arial", 1, 14));
        this.JTFUrlSoporte.setFont(new Font("Arial", 1, 12));
        this.JTFUrlSoporte.setBorder(BorderFactory.createTitledBorder((Border) null, "Ruta de Soporte", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFUrlSoporte.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.general.JIFTipoPolitica.2
            public void mouseClicked(MouseEvent evt) {
                JIFTipoPolitica.this.JTFUrlSoporteMouseClicked(evt);
            }
        });
        this.f21JSPAo.setFont(new Font("Arial", 1, 12));
        this.f21JSPAo.setModel(new SpinnerNumberModel(2021, 2000, (Comparable) null, 1));
        this.f21JSPAo.setBorder(BorderFactory.createTitledBorder((Border) null, "Añó", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFNombre.setFont(new Font("Arial", 1, 12));
        this.JTFNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JFTFCSalvamento.setBorder(BorderFactory.createTitledBorder((Border) null, "Costo Salvamento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JFTFCSalvamento.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0.00"))));
        this.JFTFCSalvamento.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setSelected(true);
        this.JCHEstado.setText("Estado");
        this.JCBTipo.setFont(new Font("Arial", 1, 12));
        this.JCBTipo.setModel(new DefaultComboBoxModel(new String[]{"DEPRECIACIÓN", "DE BAJA"}));
        this.JCBTipo.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPInformacionLayout = new GroupLayout(this.JPInformacion);
        this.JPInformacion.setLayout(JPInformacionLayout);
        JPInformacionLayout.setHorizontalGroup(JPInformacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPInformacionLayout.createSequentialGroup().addGap(10, 10, 10).addGroup(JPInformacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(JPInformacionLayout.createSequentialGroup().addComponent(this.JTFNombre, -2, 289, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.f21JSPAo, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBTipo, -2, 148, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JFTFCSalvamento, -2, 182, -2)).addGroup(GroupLayout.Alignment.TRAILING, JPInformacionLayout.createSequentialGroup().addComponent(this.JTFUrlSoporte, -2, 667, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHEstado))).addGap(10, 10, 10)));
        JPInformacionLayout.setVerticalGroup(JPInformacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPInformacionLayout.createSequentialGroup().addContainerGap().addGroup(JPInformacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPInformacionLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.f21JSPAo, -2, 50, -2).addComponent(this.JTFNombre, -2, 50, -2)).addGroup(JPInformacionLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBTipo, -2, 50, -2).addComponent(this.JFTFCSalvamento, -2, 50, -2))).addGap(12, 12, 12).addGroup(JPInformacionLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFUrlSoporte, -2, 50, -2).addComponent(this.JCHEstado)).addContainerGap(-1, 32767)));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setSelectionBackground(Color.white);
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.general.JIFTipoPolitica.3
            public void mouseClicked(MouseEvent evt) {
                JIFTipoPolitica.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.JPInformacion, -2, -1, -2)).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JSPDetalle, -2, 772, -2))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPInformacion, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalle, -2, 404, -2).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            Principal.txtNo.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
            this.JTFNombre.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString());
            this.f21JSPAo.setValue(Integer.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString()));
            this.JCBTipo.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString());
            this.JFTFCSalvamento.setValue(Double.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 4).toString()));
            this.JTFUrlSoporte.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 5).toString());
            this.JCHEstado.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 6).toString()).booleanValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFUrlSoporteMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JFileChooser xfilec = new JFileChooser(this.JTFUrlSoporte.getText());
            xfilec.setFileSelectionMode(1);
            int xv = xfilec.showOpenDialog(this);
            if (xv == 0) {
                File xfile = xfilec.getSelectedFile();
                this.JTFUrlSoporte.setText(xfile.getAbsolutePath() + this.metodos.getBarra());
                this.JTFUrlSoporte.requestFocus();
            }
        }
    }
}
