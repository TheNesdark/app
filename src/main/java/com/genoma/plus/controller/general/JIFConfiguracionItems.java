package com.genoma.plus.controller.general;

import Acceso.Principal;
import Utilidades.CustomPopupMenuListener;
import com.genoma.plus.dao.general.ConfiguracionItemsDAO;
import com.genoma.plus.dao.impl.general.ConfiguracionItemsDAOImpl;
import com.genoma.plus.dto.gcuenta.GCGenericoDTO;
import com.genoma.plus.dto.historia.ConfiguracionItems;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
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
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/general/JIFConfiguracionItems.class */
public class JIFConfiguracionItems extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private ConfiguracionItemsDAO xConfiguracionItemsDAO;
    private String[] xidPadre;
    private Object[] xDato;
    private JComboBox<String> JCBPadre;
    private JComboBox<String> JCBSexo;
    private JCheckBox JCHEstado;
    private JCheckBox JCHUltimoNivel;
    private JCheckBox JCHValidable;
    private JFormattedTextField JFTFEdadF;
    private JFormattedTextField JFTFEdadI;
    private JPanel JPInformacion;
    private JScrollPane JSPDetalle;
    private JSpinner JSPNOrden;
    private JScrollPane JSPValorDefecto;
    private JTextArea JTAValorDefecto;
    private JTable JTDetalle;
    private JTextField JTFNFormulario;
    private JTextField JTFNombre;

    public JIFConfiguracionItems() {
        initComponents();
        springStart();
        mNuevo();
    }

    private void springStart() {
        this.xConfiguracionItemsDAO = (ConfiguracionItemsDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("configuracionItemsDAO");
    }

    public void mNuevo() {
        Principal.txtNo.setText("");
        this.JTFNombre.setText("");
        this.JTFNFormulario.setText("");
        this.JCBSexo.setSelectedIndex(0);
        this.JFTFEdadI.setValue(0);
        this.JFTFEdadF.setValue(0);
        this.JSPNOrden.setValue(0);
        this.JTAValorDefecto.setText("");
        this.JCHEstado.setSelected(true);
        this.JCHUltimoNivel.setSelected(false);
        this.JCHValidable.setSelected(false);
        this.JCBPadre.removeAllItems();
        List<GCGenericoDTO> list1 = this.xConfiguracionItemsDAO.listCarpetaPadre();
        this.xidPadre = new String[list1.size()];
        for (int x = 0; x < list1.size(); x++) {
            this.xidPadre[x] = String.valueOf(list1.get(x).getIdString());
            this.JCBPadre.addItem(list1.get(x).getNombre());
        }
        this.JCBPadre.addPopupMenuListener(new CustomPopupMenuListener(true, false));
        this.JCBPadre.setSelectedIndex(-1);
        mBuscaDatos();
    }

    public void mGuardar() {
        if (!this.JTFNombre.getText().equals("")) {
            if (!Principal.txtNo.getText().equals("1")) {
                if (this.JCBPadre.getSelectedIndex() != -1) {
                    int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    if (n == 0) {
                        ConfiguracionItems e = new ConfiguracionItems();
                        if (Principal.txtNo.getText().equals("")) {
                            e.setIdPadre(Long.valueOf(this.xidPadre[this.JCBPadre.getSelectedIndex()]));
                            e.setNombre(this.JTFNombre.getText());
                            e.setNombreFormulario(this.JTFNFormulario.getText());
                            e.setUltimoNivel(Boolean.valueOf(this.JCHUltimoNivel.isSelected()));
                            e.setValidable(Boolean.valueOf(this.JCHValidable.isSelected()));
                            e.setIdSexo(this.JCBSexo.getSelectedItem().toString().substring(0, 1));
                            e.setEdadDiasInicio(Double.valueOf(this.JFTFEdadI.getValue().toString()));
                            e.setEdadDiasFin(Double.valueOf(this.JFTFEdadF.getValue().toString()));
                            e.setNumeroOrden(Long.valueOf(this.JSPNOrden.getValue().toString()));
                            e.setValorPorDefecto(this.JTAValorDefecto.getText());
                            e.setEstado(Boolean.valueOf(this.JCHEstado.isSelected()));
                            this.xConfiguracionItemsDAO.mCreate(e);
                        } else {
                            e.setIdPadre(Long.valueOf(this.xidPadre[this.JCBPadre.getSelectedIndex()]));
                            e.setNombre(this.JTFNombre.getText());
                            e.setNombreFormulario(this.JTFNFormulario.getText());
                            e.setUltimoNivel(Boolean.valueOf(this.JCHUltimoNivel.isSelected()));
                            e.setValidable(Boolean.valueOf(this.JCHValidable.isSelected()));
                            e.setIdSexo(this.JCBSexo.getSelectedItem().toString().substring(0, 1));
                            e.setEdadDiasInicio(Double.valueOf(this.JFTFEdadI.getValue().toString()));
                            e.setEdadDiasFin(Double.valueOf(this.JFTFEdadF.getValue().toString()));
                            e.setNumeroOrden(Long.valueOf(this.JSPNOrden.getValue().toString()));
                            e.setValorPorDefecto(this.JTAValorDefecto.getText());
                            e.setEstado(Boolean.valueOf(this.JCHEstado.isSelected()));
                            e.setId(Long.valueOf(Principal.txtNo.getText()));
                            this.xConfiguracionItemsDAO.mUpdate(e);
                        }
                        mNuevo();
                        return;
                    }
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Debe Seleccionar una carpeta padre", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                this.JCBPadre.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Este registro no puede ser modificado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe digitar un codigo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        this.JTFNombre.requestFocus();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mModelo() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Nombre", "NPadre", "Sexo", "Edad Inicial", "Edad Final", "No. Orden", "Valor Defecto", "Ultimo Nivel?", "Es Validable?", "Estado", "Formulario"}) { // from class: com.genoma.plus.controller.general.JIFConfiguracionItems.1
            Class[] types = {Long.class, String.class, String.class, String.class, Double.class, Double.class, Integer.class, String.class, Boolean.class, Boolean.class, Boolean.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false};

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
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(7).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(7).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(150);
    }

    private void mBuscaDatos() {
        mModelo();
        List<Object[]> list = this.xConfiguracionItemsDAO.listConfiguracionItems(this.JTFNombre.getText());
        if (!list.isEmpty()) {
            for (int x = 0; x < list.size(); x++) {
                this.xmodelo.addRow(this.xDato);
                this.xmodelo.setValueAt(list.get(x)[0], x, 0);
                this.xmodelo.setValueAt(list.get(x)[1], x, 1);
                this.xmodelo.setValueAt(list.get(x)[2], x, 2);
                this.xmodelo.setValueAt(list.get(x)[3], x, 3);
                this.xmodelo.setValueAt(list.get(x)[4], x, 4);
                this.xmodelo.setValueAt(list.get(x)[5], x, 5);
                this.xmodelo.setValueAt(list.get(x)[6], x, 6);
                this.xmodelo.setValueAt(list.get(x)[7], x, 7);
                this.xmodelo.setValueAt(list.get(x)[8], x, 8);
                this.xmodelo.setValueAt(list.get(x)[9], x, 9);
                this.xmodelo.setValueAt(list.get(x)[10], x, 10);
                this.xmodelo.setValueAt(list.get(x)[11], x, 11);
            }
        }
    }

    /* JADX WARN: Type inference failed for: r3v57, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPInformacion = new JPanel();
        this.JTFNombre = new JTextField();
        this.JCHUltimoNivel = new JCheckBox();
        this.JCHValidable = new JCheckBox();
        this.JCHEstado = new JCheckBox();
        this.JSPValorDefecto = new JScrollPane();
        this.JTAValorDefecto = new JTextArea();
        this.JSPNOrden = new JSpinner();
        this.JCBSexo = new JComboBox<>();
        this.JFTFEdadI = new JFormattedTextField();
        this.JFTFEdadF = new JFormattedTextField();
        this.JCBPadre = new JComboBox<>();
        this.JTFNFormulario = new JTextField();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("CONFIGURACION DE ITEMS");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjifconfiguracionitems");
        this.JPInformacion.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACION", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JPInformacion.setName("");
        this.JTFNombre.setFont(new Font("Arial", 1, 12));
        this.JTFNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFNombre.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.general.JIFConfiguracionItems.2
            public void keyPressed(KeyEvent evt) {
                JIFConfiguracionItems.this.JTFNombreKeyPressed(evt);
            }
        });
        this.JCHUltimoNivel.setFont(new Font("Arial", 1, 12));
        this.JCHUltimoNivel.setText("Es Ultimo Nivel?");
        this.JCHValidable.setFont(new Font("Arial", 1, 12));
        this.JCHValidable.setText("Es Validable?");
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setText("Estado");
        this.JSPValorDefecto.setBorder(BorderFactory.createTitledBorder((Border) null, "Informacion por defecto del item", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTAValorDefecto.setColumns(20);
        this.JTAValorDefecto.setFont(new Font("Arial", 1, 12));
        this.JTAValorDefecto.setRows(5);
        this.JSPValorDefecto.setViewportView(this.JTAValorDefecto);
        this.JSPNOrden.setFont(new Font("Arial", 1, 12));
        this.JSPNOrden.setModel(new SpinnerNumberModel(0, 0, (Comparable) null, 1));
        this.JSPNOrden.setBorder(BorderFactory.createTitledBorder((Border) null, "No Orden", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBSexo.setFont(new Font("Arial", 1, 12));
        this.JCBSexo.setModel(new DefaultComboBoxModel(new String[]{"Ambos", "Femenino", "Masculino"}));
        this.JCBSexo.setBorder(BorderFactory.createTitledBorder((Border) null, "Sexo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JFTFEdadI.setBorder(BorderFactory.createTitledBorder((Border) null, "Edad Inicial (Dias)", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JFTFEdadI.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JFTFEdadI.setText("0");
        this.JFTFEdadI.setFont(new Font("Arial", 1, 12));
        this.JFTFEdadF.setBorder(BorderFactory.createTitledBorder((Border) null, "Edad Final (Dias)", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JFTFEdadF.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JFTFEdadF.setText("0");
        this.JFTFEdadF.setFont(new Font("Arial", 1, 12));
        this.JCBPadre.setFont(new Font("Arial", 1, 12));
        this.JCBPadre.setBorder(BorderFactory.createTitledBorder((Border) null, "Carpeta Padre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFNFormulario.setFont(new Font("Arial", 1, 12));
        this.JTFNFormulario.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre de Formulario", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFNFormulario.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.general.JIFConfiguracionItems.3
            public void keyPressed(KeyEvent evt) {
                JIFConfiguracionItems.this.JTFNFormularioKeyPressed(evt);
            }
        });
        GroupLayout JPInformacionLayout = new GroupLayout(this.JPInformacion);
        this.JPInformacion.setLayout(JPInformacionLayout);
        JPInformacionLayout.setHorizontalGroup(JPInformacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPInformacionLayout.createSequentialGroup().addGroup(JPInformacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPInformacionLayout.createSequentialGroup().addGap(10, 10, 10).addGroup(JPInformacionLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JCBPadre, -2, 263, -2).addComponent(this.JTFNFormulario, -2, 261, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPInformacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(JPInformacionLayout.createSequentialGroup().addComponent(this.JSPNOrden, -2, 92, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JFTFEdadI, -2, 120, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JFTFEdadF)).addComponent(this.JTFNombre, -2, 358, -2))).addGroup(JPInformacionLayout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.JSPValorDefecto))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPInformacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JCHEstado).addComponent(this.JCHUltimoNivel, -1, -1, 32767).addComponent(this.JCHValidable).addComponent(this.JCBSexo, 0, -1, 32767)).addGap(10, 10, 10)));
        JPInformacionLayout.setVerticalGroup(JPInformacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPInformacionLayout.createSequentialGroup().addGap(10, 10, 10).addGroup(JPInformacionLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPInformacionLayout.createSequentialGroup().addComponent(this.JCBPadre, -2, 50, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFNFormulario, -2, 58, -2)).addGroup(JPInformacionLayout.createSequentialGroup().addGroup(JPInformacionLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFNombre, -2, 50, -2).addComponent(this.JCBSexo, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPInformacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPInformacionLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JFTFEdadI, -2, 50, -2).addComponent(this.JFTFEdadF, -2, 50, -2)).addGroup(JPInformacionLayout.createSequentialGroup().addComponent(this.JCHUltimoNivel).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHValidable)).addComponent(this.JSPNOrden, -2, 56, -2)))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPInformacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHEstado).addComponent(this.JSPValorDefecto, -2, 75, -2)).addGap(10, 10, 10)));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTORICO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setSelectionBackground(Color.white);
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.general.JIFConfiguracionItems.4
            public void mouseClicked(MouseEvent evt) {
                JIFConfiguracionItems.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JPInformacion, -1, -1, 32767).addComponent(this.JSPDetalle)).addGap(10, 10, 10)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPInformacion, -2, -1, -2).addGap(10, 10, 10).addComponent(this.JSPDetalle, -2, 310, -2).addGap(10, 10, 10)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            Principal.txtNo.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
            this.JTFNombre.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString());
            this.JTFNFormulario.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 11).toString());
            this.JCBPadre.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString());
            this.JCBSexo.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString());
            this.JFTFEdadI.setValue(Double.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 4).toString()));
            this.JFTFEdadF.setValue(Double.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 5).toString()));
            this.JSPNOrden.setValue(Long.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 6).toString()));
            this.JTAValorDefecto.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 7).toString());
            this.JCHUltimoNivel.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 8).toString()).booleanValue());
            this.JCHValidable.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 9).toString()).booleanValue());
            this.JCHEstado.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 10).toString()).booleanValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNombreKeyPressed(KeyEvent evt) {
        mBuscaDatos();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNFormularioKeyPressed(KeyEvent evt) {
    }
}
