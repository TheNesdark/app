package com.genoma.plus.controller.general;

import Acceso.Principal;
import Utilidades.CustomPopupMenuListener;
import Utilidades.Metodos;
import com.genoma.plus.dao.general.SC_TEventoTConAccDAO;
import com.genoma.plus.dao.impl.general.SC_TEventoTConAccDAOImpl;
import com.genoma.plus.dto.gcuenta.GCGenericoDTO;
import com.genoma.plus.dto.general.SC_TEventoTConAccDTO;
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
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/general/JD_SC_TEventoTConAcc.class */
public class JD_SC_TEventoTConAcc extends JDialog {
    private int xtipo;
    private int xEstado;
    private int xGuardar;
    private DefaultTableModel xmodelo;
    private Object[] xDato;
    private SC_TEventoTConAccDAO xSC_TEventoTConAccDAO;
    private String[] xIdAcciones;
    private Metodos xmt;
    private JButton JBT_Grabar;
    private JButton JBT_NUevo;
    private JButton JBT_Salir;
    private JComboBox JCBGenerico1;
    private JCheckBox JCHEstado;
    private JPanel JPIDatos;
    private JPanel JPTipo;
    private JRadioButton JRBConsecuencias;
    private JRadioButton JRBCorrectiva;
    private JRadioButton JRBPreventiva;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;
    private ButtonGroup buttonGroup1;
    private JSpinner jSpinner1;

    public JD_SC_TEventoTConAcc(Frame parent, boolean modal) {
        super(parent, modal);
        this.xtipo = 0;
        this.xEstado = 1;
        this.xGuardar = 0;
        this.xmt = new Metodos();
        initComponents();
        springStart();
        setTitle("TIPO EVENTO X CONSECUENCIA/ACCION");
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        mNuevo();
        mLLenaCombo();
    }

    private void springStart() {
        this.xSC_TEventoTConAccDAO = (SC_TEventoTConAccDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("sCTEventoTConAccDAO");
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mModelo() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"ID", "Consecuencia/Accion", "Nº Orden", "Estado", "Tipo"}) { // from class: com.genoma.plus.controller.general.JD_SC_TEventoTConAcc.1
            Class[] types = {Long.class, String.class, Integer.class, Boolean.class, String.class};
            boolean[] canEdit = {false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(30);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(30);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(100);
    }

    private void mBuscaDatos() {
        mModelo();
        List<SC_TEventoTConAccDTO> list = this.xSC_TEventoTConAccDAO.mListar(Principal.txtNo.getText());
        for (int x = 0; x < list.size(); x++) {
            this.xmt.mEstablecerTextEditor(this.JTDetalle, 1);
            this.xmodelo.addRow(this.xDato);
            this.xmodelo.setValueAt(Integer.valueOf(list.get(x).getId()), x, 0);
            this.xmodelo.setValueAt(list.get(x).getTipoConAcc(), x, 1);
            this.xmodelo.setValueAt(Integer.valueOf(list.get(x).getNOrden()), x, 2);
            if (list.get(x).getEstado() == 1) {
                this.xmodelo.setValueAt(true, x, 3);
            } else {
                this.xmodelo.setValueAt(false, x, 3);
            }
            this.xmodelo.setValueAt(list.get(x).getTipo(), x, 4);
        }
    }

    public void mGuardar() {
        if (this.JCBGenerico1.getSelectedIndex() != -1) {
            int n = JOptionPane.showConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                SC_TEventoTConAccDTO e = new SC_TEventoTConAccDTO();
                if (this.xGuardar == 0) {
                    e.setTipoEvento(Integer.parseInt(Principal.txtNo.getText()));
                    e.setTipoConAcc(this.xIdAcciones[this.JCBGenerico1.getSelectedIndex()]);
                    e.setNOrden(((Integer) this.jSpinner1.getValue()).intValue());
                    e.setEstado(this.xEstado);
                    this.xSC_TEventoTConAccDAO.mCreate(e);
                } else {
                    e.setTipoConAcc(this.xIdAcciones[this.JCBGenerico1.getSelectedIndex()]);
                    e.setNOrden(((Integer) this.jSpinner1.getValue()).intValue());
                    e.setEstado(this.xEstado);
                    e.setId(Integer.parseInt(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString()));
                    this.xSC_TEventoTConAccDAO.mUpdate(e);
                }
                mNuevo();
                return;
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una consecuencia/accion", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        this.JCBGenerico1.requestFocus();
    }

    public void mNuevo() {
        this.xGuardar = 0;
        this.JCBGenerico1.setSelectedIndex(-1);
        this.jSpinner1.setValue(0);
        this.JCHEstado.setSelected(true);
        this.xEstado = 1;
        mBuscaDatos();
    }

    private void mLLenaCombo() {
        this.JCBGenerico1.removeAllItems();
        List<GCGenericoDTO> list1 = this.xSC_TEventoTConAccDAO.listaAcciones(this.xtipo);
        this.xIdAcciones = new String[list1.size()];
        for (int x = 0; x < list1.size(); x++) {
            this.xIdAcciones[x] = String.valueOf(list1.get(x).getId());
            this.JCBGenerico1.addItem(list1.get(x).getNombre());
            System.out.println("Consulta " + list1.get(x).getId());
            System.out.println("" + list1.get(x).getNombre());
        }
        this.JCBGenerico1.addPopupMenuListener(new CustomPopupMenuListener(true, false));
    }

    /* JADX WARN: Type inference failed for: r3v54, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.buttonGroup1 = new ButtonGroup();
        this.JPIDatos = new JPanel();
        this.JCBGenerico1 = new JComboBox();
        this.JCHEstado = new JCheckBox();
        this.jSpinner1 = new JSpinner();
        this.JPTipo = new JPanel();
        this.JRBPreventiva = new JRadioButton();
        this.JRBCorrectiva = new JRadioButton();
        this.JRBConsecuencias = new JRadioButton();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JBT_Grabar = new JButton();
        this.JBT_Salir = new JButton();
        this.JBT_NUevo = new JButton();
        setDefaultCloseOperation(2);
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JCBGenerico1.setFont(new Font("Arial", 1, 12));
        this.JCBGenerico1.setBorder(BorderFactory.createTitledBorder((Border) null, "Consecuencias", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setSelected(true);
        this.JCHEstado.setText("Estado");
        this.JCHEstado.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.general.JD_SC_TEventoTConAcc.2
            public void actionPerformed(ActionEvent evt) {
                JD_SC_TEventoTConAcc.this.JCHEstadoActionPerformed(evt);
            }
        });
        this.jSpinner1.setFont(new Font("Arial", 1, 12));
        this.jSpinner1.setModel(new SpinnerNumberModel(0, 0, (Comparable) null, 1));
        this.jSpinner1.setBorder(BorderFactory.createTitledBorder((Border) null, "Nº Orden", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JPTipo.setBorder(BorderFactory.createTitledBorder((Border) null, "BUSCAR", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.buttonGroup1.add(this.JRBPreventiva);
        this.JRBPreventiva.setFont(new Font("Arial", 1, 12));
        this.JRBPreventiva.setText("Acciones Preventivas");
        this.JRBPreventiva.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.general.JD_SC_TEventoTConAcc.3
            public void actionPerformed(ActionEvent evt) {
                JD_SC_TEventoTConAcc.this.JRBPreventivaActionPerformed(evt);
            }
        });
        this.buttonGroup1.add(this.JRBCorrectiva);
        this.JRBCorrectiva.setFont(new Font("Arial", 1, 12));
        this.JRBCorrectiva.setText("Correctivo Inmediato");
        this.JRBCorrectiva.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.general.JD_SC_TEventoTConAcc.4
            public void actionPerformed(ActionEvent evt) {
                JD_SC_TEventoTConAcc.this.JRBCorrectivaActionPerformed(evt);
            }
        });
        this.buttonGroup1.add(this.JRBConsecuencias);
        this.JRBConsecuencias.setFont(new Font("Arial", 1, 12));
        this.JRBConsecuencias.setSelected(true);
        this.JRBConsecuencias.setText("Consecuencias");
        this.JRBConsecuencias.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.general.JD_SC_TEventoTConAcc.5
            public void actionPerformed(ActionEvent evt) {
                JD_SC_TEventoTConAcc.this.JRBConsecuenciasActionPerformed(evt);
            }
        });
        GroupLayout JPTipoLayout = new GroupLayout(this.JPTipo);
        this.JPTipo.setLayout(JPTipoLayout);
        JPTipoLayout.setHorizontalGroup(JPTipoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPTipoLayout.createSequentialGroup().addContainerGap().addComponent(this.JRBConsecuencias).addGap(18, 18, 18).addComponent(this.JRBCorrectiva).addGap(10, 10, 10).addComponent(this.JRBPreventiva).addContainerGap(-1, 32767)));
        JPTipoLayout.setVerticalGroup(JPTipoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPTipoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBConsecuencias).addComponent(this.JRBCorrectiva).addComponent(this.JRBPreventiva)));
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JPTipo, -2, -1, -2).addGap(0, 80, 32767)).addComponent(this.JCBGenerico1, 0, -1, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHEstado, GroupLayout.Alignment.TRAILING).addComponent(this.jSpinner1, GroupLayout.Alignment.TRAILING, -2, 125, -2)).addGap(18, 18, 18)));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBGenerico1, -2, 50, -2).addComponent(this.jSpinner1, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPTipo, -2, -1, -2).addComponent(this.JCHEstado)).addContainerGap()));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.general.JD_SC_TEventoTConAcc.6
            public void mouseClicked(MouseEvent evt) {
                JD_SC_TEventoTConAcc.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.JBT_Grabar.setFont(new Font("Arial", 1, 12));
        this.JBT_Grabar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBT_Grabar.setText("Grabar");
        this.JBT_Grabar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.general.JD_SC_TEventoTConAcc.7
            public void actionPerformed(ActionEvent evt) {
                JD_SC_TEventoTConAcc.this.JBT_GrabarActionPerformed(evt);
            }
        });
        this.JBT_Salir.setFont(new Font("Arial", 1, 12));
        this.JBT_Salir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.JBT_Salir.setText("Salir");
        this.JBT_Salir.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.general.JD_SC_TEventoTConAcc.8
            public void actionPerformed(ActionEvent evt) {
                JD_SC_TEventoTConAcc.this.JBT_SalirActionPerformed(evt);
            }
        });
        this.JBT_NUevo.setFont(new Font("Arial", 1, 12));
        this.JBT_NUevo.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Nuevo29x25.png")));
        this.JBT_NUevo.setText("Nuevo");
        this.JBT_NUevo.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.general.JD_SC_TEventoTConAcc.9
            public void actionPerformed(ActionEvent evt) {
                JD_SC_TEventoTConAcc.this.JBT_NUevoActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPDetalle).addGroup(layout.createSequentialGroup().addComponent(this.JBT_NUevo, -2, 203, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBT_Grabar, -1, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBT_Salir, -2, 218, -2)).addComponent(this.JPIDatos, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, 153, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalle, -1, 252, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBT_NUevo, -2, 50, -2).addComponent(this.JBT_Grabar, -2, 50, -2).addComponent(this.JBT_Salir, -2, 50, -2)).addContainerGap()));
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
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            this.jSpinner1.setValue(Integer.valueOf(Integer.parseInt(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString())));
            this.JCHEstado.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString()).booleanValue());
            if (Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString()).booleanValue()) {
                this.xEstado = 1;
            } else {
                this.xEstado = 0;
            }
            if ("CONSECUENCIAS".equals(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 4).toString())) {
                this.JRBConsecuencias.setSelected(true);
                JRBConsecuenciasActionPerformed(null);
            }
            if ("CORRECTIVO INMEDIATO".equals(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 4).toString())) {
                this.JRBCorrectiva.setSelected(true);
                JRBCorrectivaActionPerformed(null);
            }
            if ("ACCIONES PREVENTIVAS".equals(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 4).toString())) {
                this.JRBPreventiva.setSelected(true);
                JRBPreventivaActionPerformed(null);
            }
            this.JCBGenerico1.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString());
            this.xGuardar = 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_GrabarActionPerformed(ActionEvent evt) {
        mGuardar();
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
    public void JRBPreventivaActionPerformed(ActionEvent evt) {
        this.xtipo = 2;
        this.JCBGenerico1.setBorder(BorderFactory.createTitledBorder((Border) null, "Acciones Preventivas", 0, 0, new Font("Arial", 1, 12), Color.blue));
        mLLenaCombo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBCorrectivaActionPerformed(ActionEvent evt) {
        this.xtipo = 1;
        this.JCBGenerico1.setBorder(BorderFactory.createTitledBorder((Border) null, "Correctivos Inmediatos", 0, 0, new Font("Arial", 1, 12), Color.blue));
        mLLenaCombo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBConsecuenciasActionPerformed(ActionEvent evt) {
        this.xtipo = 0;
        this.JCBGenerico1.setBorder(BorderFactory.createTitledBorder((Border) null, "Consecuencias", 0, 0, new Font("Arial", 1, 12), Color.blue));
        mLLenaCombo();
    }
}
