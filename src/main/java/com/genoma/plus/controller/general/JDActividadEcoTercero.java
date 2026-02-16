package com.genoma.plus.controller.general;

import Acceso.Principal;
import Utilidades.CustomPopupMenuListener;
import Utilidades.Metodos;
import com.genoma.plus.dao.general.ActividadEconomicaDAO;
import com.genoma.plus.dao.impl.general.ActividadEconomicaDAOImpl;
import com.genoma.plus.dto.gcuenta.GCGenericoDTO;
import com.genoma.plus.dto.general.ActividadEconomicaTerceroDTO;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/general/JDActividadEcoTercero.class */
public class JDActividadEcoTercero extends JDialog {
    private int xEstado;
    private int xguardar;
    private int xlleno;
    private int xActPrincipal;
    private DefaultTableModel xmodelo;
    private Metodos xmt;
    private Object[] xdatos;
    private String[] xIdTercero;
    private String[] xIdActividad;
    private ActividadEconomicaDAO xActividadEconomicaDAO;
    private JButton JBT_Grabar;
    private JButton JBT_NUevo;
    private JButton JBT_Salir;
    private JComboBox JCBActividadEconomica;
    private JCheckBox JCHEsPrincipal;
    private JCheckBox JCHEstado;
    private JPanel JPDatos;
    private JScrollPane JSPHistorico;
    private JScrollPane JSP_Observacion;
    private JTextPane JTA_Observacion;
    private JTextField JTFCodigo;
    private JTable JTHistorico;

    public JDActividadEcoTercero(Frame parent, boolean modal) {
        super(parent, modal);
        this.xEstado = 1;
        this.xguardar = 0;
        this.xlleno = 0;
        this.xActPrincipal = 0;
        this.xmt = new Metodos();
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        setTitle("ACTIVIDAD DE TERCERO");
        springStart();
        mNuevo();
    }

    private void springStart() {
        this.xActividadEconomicaDAO = (ActividadEconomicaDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("ActividadEconomicaDAO");
    }

    public void mNuevo() {
        this.JTFCodigo.setText("");
        this.JTA_Observacion.setText("");
        this.JCBActividadEconomica.setSelectedIndex(-1);
        this.xEstado = 1;
        this.xguardar = 0;
        this.xActPrincipal = 0;
        mLLenaCombo();
        mCargarDatosTabla();
    }

    public void mGrabar() {
        if (this.JCBActividadEconomica.getSelectedIndex() != -1) {
            if (!this.xmt.mVerificarDatosDoblesTabla(this.JTHistorico, 0, this.xIdActividad[this.JCBActividadEconomica.getSelectedIndex()])) {
                int n = JOptionPane.showConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (n == 0) {
                    ActividadEconomicaTerceroDTO e = new ActividadEconomicaTerceroDTO();
                    e.setIdTercero(Long.valueOf(Principal.txtNo.getText()));
                    e.setIdActividadEconomica(this.xIdActividad[this.JCBActividadEconomica.getSelectedIndex()]);
                    e.setEsPrincipal(this.xActPrincipal);
                    e.setObservacion(this.JTA_Observacion.getText());
                    e.setEstado(this.xEstado);
                    this.xActividadEconomicaDAO.createActividadETercero(e);
                }
            } else if (this.JTHistorico.getSelectedRow() != -1) {
                int n2 = JOptionPane.showConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (n2 == 0) {
                    ActividadEconomicaTerceroDTO e2 = new ActividadEconomicaTerceroDTO();
                    e2.setObservacion(this.JTA_Observacion.getText());
                    e2.setEsPrincipal(this.xActPrincipal);
                    e2.setEstado(this.xEstado);
                    e2.setIdTercero(Long.valueOf(Principal.txtNo.getText()));
                    e2.setIdActividadEconomica(this.xIdActividad[this.JCBActividadEconomica.getSelectedIndex()]);
                    this.xActividadEconomicaDAO.updateActividadETercero(e2);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Esta configuración ya está asignada", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                this.JCBActividadEconomica.requestFocus();
            }
            mNuevo();
            return;
        }
        JOptionPane.showMessageDialog(this, "Debe seleccionar una actividad", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        this.JCBActividadEconomica.requestFocus();
    }

    private void mLLenaCombo() {
        String xsql;
        this.xlleno = 0;
        if (!this.JTFCodigo.getText().isEmpty()) {
            xsql = "SELECT Id, Nbre FROM cc_actividad_economica WHERE ( Id  ='" + this.JTFCodigo.getText() + "' AND ultimoNivel  =1 AND Estado  =1) ORDER BY  Nbre  ASC;";
        } else {
            xsql = "SELECT Id, Nbre FROM cc_actividad_economica WHERE ( ultimoNivel =1 AND Estado =1) ORDER BY Nbre ASC;";
        }
        this.JCBActividadEconomica.removeAllItems();
        List<GCGenericoDTO> list1 = this.xActividadEconomicaDAO.listActividad(xsql);
        this.xIdActividad = new String[list1.size()];
        for (int x = 0; x < list1.size(); x++) {
            this.xIdActividad[x] = String.valueOf(list1.get(x).getId());
            this.JCBActividadEconomica.addItem(list1.get(x).getNombre());
        }
        this.JCBActividadEconomica.addPopupMenuListener(new CustomPopupMenuListener(true, false));
        this.xlleno = 1;
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos(String[] xcabecera) {
        this.xmodelo = new DefaultTableModel(new Object[0], xcabecera) { // from class: com.genoma.plus.controller.general.JDActividadEcoTercero.1
            Class[] types = {String.class, String.class, String.class, Boolean.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTHistorico.setModel(this.xmodelo);
        this.JTHistorico.getColumnModel().getColumn(0).setPreferredWidth(50);
        this.JTHistorico.getColumnModel().getColumn(1).setPreferredWidth(150);
        this.JTHistorico.getColumnModel().getColumn(2).setPreferredWidth(150);
        this.JTHistorico.getColumnModel().getColumn(3).setPreferredWidth(20);
        this.JTHistorico.getColumnModel().getColumn(4).setPreferredWidth(20);
    }

    private void mCargarDatosTabla() {
        String[] xencabezado = {"Código", "Actividad", "Observación", "Es Principal", "Estado"};
        mCrearModeloDatos(xencabezado);
        List<ActividadEconomicaTerceroDTO> list = this.xActividadEconomicaDAO.listActividadETercero(Principal.txtNo.getText());
        for (int x = 0; x < list.size(); x++) {
            this.xmodelo.addRow(this.xdatos);
            this.xmodelo.setValueAt(list.get(x).getId(), x, 0);
            this.xmodelo.setValueAt(list.get(x).getIdActividadEconomica(), x, 1);
            this.xmodelo.setValueAt(list.get(x).getObservacion(), x, 2);
            if (list.get(x).getEsPrincipal() == 1) {
                this.xmodelo.setValueAt(true, x, 3);
            } else {
                this.xmodelo.setValueAt(false, x, 3);
            }
            if (list.get(x).getEstado() == 1) {
                this.xmodelo.setValueAt(true, x, 4);
            } else {
                this.xmodelo.setValueAt(false, x, 4);
            }
        }
    }

    /* JADX WARN: Type inference failed for: r3v31, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPDatos = new JPanel();
        this.JCBActividadEconomica = new JComboBox();
        this.JCHEstado = new JCheckBox();
        this.JCHEsPrincipal = new JCheckBox();
        this.JSP_Observacion = new JScrollPane();
        this.JTA_Observacion = new JTextPane();
        this.JTFCodigo = new JTextField();
        this.JSPHistorico = new JScrollPane();
        this.JTHistorico = new JTable();
        this.JBT_NUevo = new JButton();
        this.JBT_Grabar = new JButton();
        this.JBT_Salir = new JButton();
        setDefaultCloseOperation(2);
        setFont(new Font("Arial", 1, 12));
        this.JPDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JCBActividadEconomica.setFont(new Font("Arial", 1, 12));
        this.JCBActividadEconomica.setBorder(BorderFactory.createTitledBorder((Border) null, "Actividad Económica", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBActividadEconomica.addItemListener(new ItemListener() { // from class: com.genoma.plus.controller.general.JDActividadEcoTercero.2
            public void itemStateChanged(ItemEvent evt) {
                JDActividadEcoTercero.this.JCBActividadEconomicaItemStateChanged(evt);
            }
        });
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setForeground(Color.blue);
        this.JCHEstado.setSelected(true);
        this.JCHEstado.setText("Estado");
        this.JCHEstado.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.general.JDActividadEcoTercero.3
            public void actionPerformed(ActionEvent evt) {
                JDActividadEcoTercero.this.JCHEstadoActionPerformed(evt);
            }
        });
        this.JCHEsPrincipal.setFont(new Font("Arial", 1, 12));
        this.JCHEsPrincipal.setForeground(Color.blue);
        this.JCHEsPrincipal.setText("Es Principal");
        this.JCHEsPrincipal.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.general.JDActividadEcoTercero.4
            public void actionPerformed(ActionEvent evt) {
                JDActividadEcoTercero.this.JCHEsPrincipalActionPerformed(evt);
            }
        });
        this.JSP_Observacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Descripción", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTA_Observacion.setFont(new Font("Arial", 1, 12));
        this.JSP_Observacion.setViewportView(this.JTA_Observacion);
        this.JTFCodigo.setFont(new Font("Arial", 1, 12));
        this.JTFCodigo.setBorder(BorderFactory.createTitledBorder((Border) null, "Código", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFCodigo.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.general.JDActividadEcoTercero.5
            public void actionPerformed(ActionEvent evt) {
                JDActividadEcoTercero.this.JTFCodigoActionPerformed(evt);
            }
        });
        this.JTFCodigo.addFocusListener(new FocusAdapter() { // from class: com.genoma.plus.controller.general.JDActividadEcoTercero.6
            public void focusLost(FocusEvent evt) {
                JDActividadEcoTercero.this.JTFCodigoFocusLost(evt);
            }
        });
        this.JTFCodigo.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.general.JDActividadEcoTercero.7
            public void keyPressed(KeyEvent evt) {
                JDActividadEcoTercero.this.JTFCodigoKeyPressed(evt);
            }
        });
        GroupLayout JPDatosLayout = new GroupLayout(this.JPDatos);
        this.JPDatos.setLayout(JPDatosLayout);
        JPDatosLayout.setHorizontalGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSP_Observacion).addGroup(JPDatosLayout.createSequentialGroup().addComponent(this.JTFCodigo, -1, 140, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBActividadEconomica, -2, 450, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHEsPrincipal).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHEstado, -2, 81, -2))).addContainerGap()));
        JPDatosLayout.setVerticalGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosLayout.createSequentialGroup().addGap(10, 10, 10).addGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBActividadEconomica, -2, 50, -2).addComponent(this.JCHEsPrincipal, -2, 50, -2).addComponent(this.JCHEstado, -2, 50, -2)).addGroup(JPDatosLayout.createSequentialGroup().addComponent(this.JTFCodigo, -2, 50, -2).addGap(4, 4, 4))).addGap(6, 6, 6).addComponent(this.JSP_Observacion, -2, 90, -2)));
        this.JSPHistorico.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTHistorico.setFont(new Font("Arial", 1, 12));
        this.JTHistorico.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTHistorico.setSelectionBackground(new Color(255, 255, 255));
        this.JTHistorico.setSelectionForeground(Color.red);
        this.JTHistorico.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.general.JDActividadEcoTercero.8
            public void mouseClicked(MouseEvent evt) {
                JDActividadEcoTercero.this.JTHistoricoMouseClicked(evt);
            }
        });
        this.JSPHistorico.setViewportView(this.JTHistorico);
        this.JBT_NUevo.setFont(new Font("Arial", 1, 12));
        this.JBT_NUevo.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Nuevo29x25.png")));
        this.JBT_NUevo.setText("Nuevo");
        this.JBT_NUevo.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.general.JDActividadEcoTercero.9
            public void actionPerformed(ActionEvent evt) {
                JDActividadEcoTercero.this.JBT_NUevoActionPerformed(evt);
            }
        });
        this.JBT_Grabar.setFont(new Font("Arial", 1, 12));
        this.JBT_Grabar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBT_Grabar.setText("Grabar");
        this.JBT_Grabar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.general.JDActividadEcoTercero.10
            public void actionPerformed(ActionEvent evt) {
                JDActividadEcoTercero.this.JBT_GrabarActionPerformed(evt);
            }
        });
        this.JBT_Salir.setFont(new Font("Arial", 1, 12));
        this.JBT_Salir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.JBT_Salir.setText("Salir");
        this.JBT_Salir.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.general.JDActividadEcoTercero.11
            public void actionPerformed(ActionEvent evt) {
                JDActividadEcoTercero.this.JBT_SalirActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPDatos, -1, -1, 32767).addComponent(this.JSPHistorico, -1, 816, 32767).addGroup(layout.createSequentialGroup().addComponent(this.JBT_NUevo, -2, 220, -2).addGap(77, 77, 77).addComponent(this.JBT_Grabar, -2, 220, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JBT_Salir, -2, 220, -2))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPDatos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPHistorico, -2, 194, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JBT_NUevo, -2, 50, -2).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBT_Salir, -2, 50, -2).addComponent(this.JBT_Grabar, -2, 50, -2))).addGap(10, 10, 10)));
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
    public void JCHEsPrincipalActionPerformed(ActionEvent evt) {
        if (this.JCHEsPrincipal.isSelected()) {
            this.xActPrincipal = 1;
        } else {
            this.xActPrincipal = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTHistoricoMouseClicked(MouseEvent evt) {
        if (this.JTHistorico.getSelectedRow() != -1) {
            this.JTFCodigo.setText(this.xmodelo.getValueAt(this.JTHistorico.getSelectedRow(), 0).toString());
            this.JCBActividadEconomica.setSelectedItem(this.xmodelo.getValueAt(this.JTHistorico.getSelectedRow(), 1).toString());
            this.JTA_Observacion.setText(this.xmodelo.getValueAt(this.JTHistorico.getSelectedRow(), 2).toString());
            this.JCHEsPrincipal.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTHistorico.getSelectedRow(), 3).toString()).booleanValue());
            if (this.JCHEsPrincipal.isSelected()) {
                this.xActPrincipal = 1;
            } else {
                this.xActPrincipal = 0;
            }
            this.JCHEstado.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTHistorico.getSelectedRow(), 4).toString()).booleanValue());
            if (this.JCHEstado.isSelected()) {
                this.xEstado = 1;
            } else {
                this.xEstado = 0;
            }
            this.xguardar = 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_NUevoActionPerformed(ActionEvent evt) {
        mNuevo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_GrabarActionPerformed(ActionEvent evt) {
        mGrabar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_SalirActionPerformed(ActionEvent evt) {
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCodigoKeyPressed(KeyEvent evt) {
        mLLenaCombo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCodigoActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBActividadEconomicaItemStateChanged(ItemEvent evt) {
        if (this.JCBActividadEconomica.getSelectedIndex() != -1 && this.xlleno == 1) {
            this.JTFCodigo.setText("");
            this.JTFCodigo.setText(this.xIdActividad[this.JCBActividadEconomica.getSelectedIndex()]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCodigoFocusLost(FocusEvent evt) {
        mLLenaCombo();
    }
}
