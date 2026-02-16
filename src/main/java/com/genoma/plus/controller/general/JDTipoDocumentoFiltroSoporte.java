package com.genoma.plus.controller.general;

import Acceso.Principal;
import com.genoma.plus.dao.general.TipoDocumentoFiltroSoporteDAO;
import com.genoma.plus.dao.impl.general.TipoDocumentoFiltroSoporteDAOImpl;
import com.genoma.plus.dto.gcuenta.GCGenericoDTO;
import com.genoma.plus.dto.general.TipoDocumentoFiltroSoporteDTO;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
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
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/general/JDTipoDocumentoFiltroSoporte.class */
public class JDTipoDocumentoFiltroSoporte extends JDialog {
    private int xEstado;
    private int xGuardar;
    private DefaultTableModel xModelo;
    private Object[] xDato;
    private TipoDocumentoFiltroSoporteDAO xTipoDocumentoFiltroSoporteDAO;
    private String[] xidDocumentoS;
    private JButton JBT_Grabar;
    private JButton JBT_NUevo;
    private JButton JBT_Salir;
    private JComboBox JCBDocumentoS;
    private JCheckBox JCHEstado;
    private JPanel JPIDatos;
    private JSpinner JSNOrden;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;

    public JDTipoDocumentoFiltroSoporte(Frame parent, boolean modal) {
        super(parent, modal);
        this.xEstado = 1;
        this.xGuardar = 0;
        initComponents();
        setTitle("DOCUMENTOS DE FIRMAS POR SOPORTE");
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        springStart();
        mNuevo();
    }

    private void springStart() {
        this.xTipoDocumentoFiltroSoporteDAO = (TipoDocumentoFiltroSoporteDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("tipoDocumentoFiltroSoporteDAO");
    }

    public void mNuevo() {
        this.xGuardar = 0;
        this.JCHEstado.setSelected(true);
        this.JSNOrden.setValue(0);
        this.xEstado = 1;
        mCargarDatosTabla();
        mLLenaCombo();
    }

    public void mGrabar() {
        if (this.JCBDocumentoS.getSelectedIndex() != -1) {
            int n = JOptionPane.showConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                if (this.xGuardar == 0) {
                    TipoDocumentoFiltroSoporteDTO e = new TipoDocumentoFiltroSoporteDTO();
                    e.setIdTipoDocF(Integer.valueOf(Principal.txtNo.getText()).intValue());
                    e.setIdTipoDocS(this.xidDocumentoS[this.JCBDocumentoS.getSelectedIndex()]);
                    e.setNOrden(Integer.valueOf(this.JSNOrden.getValue().toString()).intValue());
                    e.setEstado(this.xEstado);
                    this.xTipoDocumentoFiltroSoporteDAO.create(e);
                } else {
                    TipoDocumentoFiltroSoporteDTO e2 = new TipoDocumentoFiltroSoporteDTO();
                    e2.setIdTipoDocF(Integer.valueOf(Principal.txtNo.getText()).intValue());
                    e2.setIdTipoDocS(this.xidDocumentoS[this.JCBDocumentoS.getSelectedIndex()]);
                    e2.setNOrden(Integer.valueOf(this.JSNOrden.getValue().toString()).intValue());
                    e2.setEstado(this.xEstado);
                    this.xTipoDocumentoFiltroSoporteDAO.update(e2);
                }
                mNuevo();
                return;
            }
            return;
        }
        JOptionPane.showMessageDialog(this, "Debe Seleccionar un tipo de documento soporte", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        this.JCBDocumentoS.requestFocus();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mModelo() {
        this.xModelo = new DefaultTableModel(new Object[0], new String[]{"Nombre", "Nº Orden", "Estado"}) { // from class: com.genoma.plus.controller.general.JDTipoDocumentoFiltroSoporte.1
            Class[] types = {String.class, Integer.class, Boolean.class};
            boolean[] canEdit = {false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xModelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(50);
    }

    private void mCargarDatosTabla() {
        mModelo();
        List<TipoDocumentoFiltroSoporteDTO> list = this.xTipoDocumentoFiltroSoporteDAO.list();
        for (int x = 0; x < list.size(); x++) {
            this.xModelo.addRow(this.xDato);
            this.xModelo.setValueAt(list.get(x).getIdTipoDocS(), x, 0);
            this.xModelo.setValueAt(Integer.valueOf(list.get(x).getNOrden()), x, 1);
            if (list.get(x).getEstado() == 1) {
                this.xModelo.setValueAt(true, x, 2);
            } else {
                this.xModelo.setValueAt(false, x, 2);
            }
        }
    }

    private void mLLenaCombo() {
        this.JCBDocumentoS.removeAllItems();
        List<GCGenericoDTO> list1 = this.xTipoDocumentoFiltroSoporteDAO.listaSoporte();
        this.xidDocumentoS = new String[list1.size()];
        for (int x = 0; x < list1.size(); x++) {
            this.xidDocumentoS[x] = String.valueOf(list1.get(x).getId());
            this.JCBDocumentoS.addItem(list1.get(x).getNombre());
            System.out.println("Consulta " + list1.get(x).getId());
            System.out.println("" + list1.get(x).getNombre());
        }
        this.JCBDocumentoS.setSelectedIndex(-1);
    }

    /* JADX WARN: Type inference failed for: r3v41, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBT_Grabar = new JButton();
        this.JPIDatos = new JPanel();
        this.JCBDocumentoS = new JComboBox();
        this.JCHEstado = new JCheckBox();
        this.JSNOrden = new JSpinner();
        this.JBT_Salir = new JButton();
        this.JBT_NUevo = new JButton();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        setDefaultCloseOperation(2);
        this.JBT_Grabar.setFont(new Font("Arial", 1, 12));
        this.JBT_Grabar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBT_Grabar.setText("Grabar");
        this.JBT_Grabar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.general.JDTipoDocumentoFiltroSoporte.2
            public void actionPerformed(ActionEvent evt) {
                JDTipoDocumentoFiltroSoporte.this.JBT_GrabarActionPerformed(evt);
            }
        });
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JCBDocumentoS.setFont(new Font("Arial", 1, 12));
        this.JCBDocumentoS.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo de Documento Soporte", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setSelected(true);
        this.JCHEstado.setText("Estado");
        this.JCHEstado.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.general.JDTipoDocumentoFiltroSoporte.3
            public void actionPerformed(ActionEvent evt) {
                JDTipoDocumentoFiltroSoporte.this.JCHEstadoActionPerformed(evt);
            }
        });
        this.JSNOrden.setFont(new Font("Arial", 1, 12));
        this.JSNOrden.setModel(new SpinnerNumberModel(0, 0, (Comparable) null, 1));
        this.JSNOrden.setBorder(BorderFactory.createTitledBorder((Border) null, "Nº Orden", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addComponent(this.JCBDocumentoS, 0, 402, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSNOrden, -2, 97, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHEstado).addContainerGap()));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBDocumentoS, -2, 50, -2).addComponent(this.JSNOrden, -2, 50, -2).addComponent(this.JCHEstado)).addContainerGap(-1, 32767)));
        this.JBT_Salir.setFont(new Font("Arial", 1, 12));
        this.JBT_Salir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.JBT_Salir.setText("Salir");
        this.JBT_Salir.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.general.JDTipoDocumentoFiltroSoporte.4
            public void actionPerformed(ActionEvent evt) {
                JDTipoDocumentoFiltroSoporte.this.JBT_SalirActionPerformed(evt);
            }
        });
        this.JBT_NUevo.setFont(new Font("Arial", 1, 12));
        this.JBT_NUevo.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Nuevo29x25.png")));
        this.JBT_NUevo.setText("Nuevo");
        this.JBT_NUevo.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.general.JDTipoDocumentoFiltroSoporte.5
            public void actionPerformed(ActionEvent evt) {
                JDTipoDocumentoFiltroSoporte.this.JBT_NUevoActionPerformed(evt);
            }
        });
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.general.JDTipoDocumentoFiltroSoporte.6
            public void mouseClicked(MouseEvent evt) {
                JDTipoDocumentoFiltroSoporte.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.JPIDatos, -2, -1, -2).addGap(0, 0, 32767)).addComponent(this.JSPDetalle).addGroup(layout.createSequentialGroup().addComponent(this.JBT_NUevo, -2, 190, -2).addGap(18, 18, 18).addComponent(this.JBT_Grabar, -2, 190, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JBT_Salir, -2, 190, -2))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, 98, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalle, -2, 298, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBT_NUevo, -2, 50, -2).addComponent(this.JBT_Grabar, -2, 50, -2).addComponent(this.JBT_Salir, -2, 50, -2)).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_GrabarActionPerformed(ActionEvent evt) {
        mGrabar();
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
    public void JBT_SalirActionPerformed(ActionEvent evt) {
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_NUevoActionPerformed(ActionEvent evt) {
        mNuevo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            this.JCBDocumentoS.setSelectedItem(this.xModelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
            this.JSNOrden.setValue(Integer.valueOf(Integer.parseInt(this.xModelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString())));
            this.JCHEstado.setSelected(Boolean.valueOf(this.xModelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString()).booleanValue());
            if (Boolean.valueOf(this.xModelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString()).booleanValue()) {
                this.xEstado = 1;
            } else {
                this.xEstado = 0;
            }
            this.xGuardar = 1;
        }
    }
}
