package com.genoma.plus.controller.general;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.genoma.plus.dao.general.ActividadEconomicaDAO;
import com.genoma.plus.dao.impl.general.ActividadEconomicaDAOImpl;
import com.genoma.plus.dto.general.ActividadEconomicaDTO;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/general/JIFFActividadEconomica.class */
public class JIFFActividadEconomica extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private Object[] xdatos;
    private String[][] xIdNivel;
    private String carga;
    private ActividadEconomicaDAO xActividadEconomicaDAO;
    private JComboBox JCBNivel;
    private JCheckBox JCHEstado;
    private JPanel JPDatos;
    private JScrollPane JSPHistorico;
    private JFormattedTextField JTFF_Codigo;
    private JTextField JTFNombre;
    private JTable JTHistorico;
    private int xEstado = 1;
    private int xlleno = 0;
    private ConsultasMySQL xconsulta = new ConsultasMySQL();
    private Metodos xmt = new Metodos();
    private Metodos xmt_t = new Metodos();

    public JIFFActividadEconomica() {
        initComponents();
        springStart();
        mNuevo();
        mIniciarComponentes();
        mCargarDatosTabla();
    }

    private void springStart() {
        this.xActividadEconomicaDAO = (ActividadEconomicaDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("ActividadEconomicaDAO");
    }

    public void mNuevo() {
        Principal.mLimpiarDatosP();
        this.JTFF_Codigo.setText("");
        this.JCHEstado.setSelected(true);
        this.JCBNivel.setSelectedIndex(-1);
        this.JTFNombre.setText("");
        this.xEstado = 1;
        mCargarDatosTabla();
    }

    public void mGrabar() {
        if (this.JCBNivel.getSelectedIndex() != -1) {
            if (!this.JTFF_Codigo.getText().isEmpty()) {
                if (!this.JTFNombre.getText().isEmpty()) {
                    int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    if (n == 0) {
                        ActividadEconomicaDTO e = new ActividadEconomicaDTO();
                        if (Principal.txtNo.getText().isEmpty()) {
                            if (!this.xmt_t.mVerificarDatosDoblesTabla(this.JTHistorico, 0, this.JTFF_Codigo.getText())) {
                                e.setId(this.JTFF_Codigo.getText());
                                e.setNombre(this.JTFNombre.getText().toUpperCase());
                                e.setIdNivel(this.xIdNivel[this.JCBNivel.getSelectedIndex()][0]);
                                e.setEstado(this.xEstado);
                                this.xActividadEconomicaDAO.createActividadEconomica(e);
                            } else {
                                JOptionPane.showInternalMessageDialog(this, "EL código ya existe", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                                this.JTFF_Codigo.requestFocus();
                            }
                        } else {
                            e.setNombre(this.JTFNombre.getText().toUpperCase());
                            e.setEstado(this.xEstado);
                            e.setId(this.JTFF_Codigo.getText());
                            this.xActividadEconomicaDAO.updateActividadEconomica(e);
                        }
                        mNuevo();
                        return;
                    }
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Ingresar un Nombre", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                this.JTFNombre.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Código no puede ser Null", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            this.JTFF_Codigo.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un nivel", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        this.JCBNivel.requestFocus();
    }

    /* JADX WARN: Type inference failed for: r3v30, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPDatos = new JPanel();
        this.JTFNombre = new JTextField();
        this.JCBNivel = new JComboBox();
        this.JCHEstado = new JCheckBox();
        this.JTFF_Codigo = new JFormattedTextField();
        this.JSPHistorico = new JScrollPane();
        this.JTHistorico = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("ACTIVIDAD ECONÓMICA");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjifactividadeconomica");
        this.JPDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTFNombre.setFont(new Font("Arial", 1, 12));
        this.JTFNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBNivel.setFont(new Font("Arial", 1, 12));
        this.JCBNivel.setBorder(BorderFactory.createTitledBorder((Border) null, "Nivel", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBNivel.addItemListener(new ItemListener() { // from class: com.genoma.plus.controller.general.JIFFActividadEconomica.1
            public void itemStateChanged(ItemEvent evt) {
                JIFFActividadEconomica.this.JCBNivelItemStateChanged(evt);
            }
        });
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setForeground(Color.blue);
        this.JCHEstado.setSelected(true);
        this.JCHEstado.setText("Estado");
        this.JCHEstado.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.general.JIFFActividadEconomica.2
            public void actionPerformed(ActionEvent evt) {
                JIFFActividadEconomica.this.JCHEstadoActionPerformed(evt);
            }
        });
        this.JTFF_Codigo.setBorder(BorderFactory.createTitledBorder((Border) null, "Código", 0, 0, new Font("Arial", 1, 12), Color.blue));
        try {
            this.JTFF_Codigo.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("##")));
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        this.JTFF_Codigo.setFont(new Font("Arial", 1, 12));
        GroupLayout JPDatosLayout = new GroupLayout(this.JPDatos);
        this.JPDatos.setLayout(JPDatosLayout);
        JPDatosLayout.setHorizontalGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPDatosLayout.createSequentialGroup().addGap(5, 5, 5).addGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JTFNombre).addGroup(JPDatosLayout.createSequentialGroup().addComponent(this.JCBNivel, -2, 254, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFF_Codigo).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHEstado, -2, 81, -2))).addGap(10, 10, 10)));
        JPDatosLayout.setVerticalGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBNivel, -2, 50, -2).addComponent(this.JCHEstado, -2, 50, -2).addComponent(this.JTFF_Codigo, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFNombre, -2, 50, -2).addGap(5, 5, 5)));
        this.JSPHistorico.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTHistorico.setFont(new Font("Arial", 1, 12));
        this.JTHistorico.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTHistorico.setSelectionBackground(new Color(255, 255, 255));
        this.JTHistorico.setSelectionForeground(Color.red);
        this.JTHistorico.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.general.JIFFActividadEconomica.3
            public void mouseClicked(MouseEvent evt) {
                JIFFActividadEconomica.this.JTHistoricoMouseClicked(evt);
            }
        });
        this.JSPHistorico.setViewportView(this.JTHistorico);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(5, 5, 5).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPDatos, -1, -1, 32767).addComponent(this.JSPHistorico, -1, 580, 32767)).addGap(5, 5, 5)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPDatos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPHistorico, -1, 266, 32767).addGap(10, 10, 10)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTHistoricoMouseClicked(MouseEvent evt) {
        if (this.JTHistorico.getSelectedRow() != -1) {
            Principal.txtNo.setText(this.xmodelo.getValueAt(this.JTHistorico.getSelectedRow(), 0).toString());
            this.JTFF_Codigo.setText(this.xmodelo.getValueAt(this.JTHistorico.getSelectedRow(), 0).toString());
            this.JCBNivel.setSelectedItem(this.xmodelo.getValueAt(this.JTHistorico.getSelectedRow(), 1).toString());
            this.JTFNombre.setText(this.xmodelo.getValueAt(this.JTHistorico.getSelectedRow(), 2).toString());
            this.JCHEstado.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTHistorico.getSelectedRow(), 3).toString()).booleanValue());
            if (this.JCHEstado.isSelected()) {
                this.xEstado = 1;
            } else {
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
    public void JCBNivelItemStateChanged(ItemEvent evt) {
        if (this.JCBNivel.getSelectedIndex() != -1 && this.xlleno == 1) {
            String sql = "SELECT NCaracter FROM `cc_actividad_economica_nivel` WHERE(`Id` ='" + this.xIdNivel[this.JCBNivel.getSelectedIndex()][0] + "');";
            this.JTFF_Codigo.setFormatterFactory(new DefaultFormatterFactory(this.xmt.mDevolver_Mascara(sql)));
        }
    }

    private void mIniciarComponentes() {
        this.xlleno = 0;
        this.xIdNivel = this.xconsulta.llenarComboyLista("SELECT  Id  ,  Nbre, NDigitos FROM  cc_actividad_economica_nivel WHERE ( Estado  =1)", this.xIdNivel, this.JCBNivel, 3);
        this.JCBNivel.setSelectedIndex(-1);
        this.xconsulta.cerrarConexionBd();
        this.xlleno = 1;
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos(String[] xcabecera) {
        this.xmodelo = new DefaultTableModel(new Object[0], xcabecera) { // from class: com.genoma.plus.controller.general.JIFFActividadEconomica.4
            Class[] types = {String.class, String.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTHistorico.setModel(this.xmodelo);
        this.JTHistorico.getColumnModel().getColumn(0).setPreferredWidth(50);
        this.JTHistorico.getColumnModel().getColumn(1).setPreferredWidth(50);
        this.JTHistorico.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTHistorico.getColumnModel().getColumn(3).setPreferredWidth(50);
    }

    private void mCargarDatosTabla() {
        List<ActividadEconomicaDTO> list = this.xActividadEconomicaDAO.listActividadEconomica();
        String[] xencabezado = {"Código", "Nivel", "Nombre", "Estado"};
        mCrearModeloDatos(xencabezado);
        for (int x = 0; x < list.size(); x++) {
            this.xmodelo.addRow(this.xdatos);
            this.xmodelo.setValueAt(list.get(x).getId(), x, 0);
            this.xmodelo.setValueAt(list.get(x).getIdNivel(), x, 1);
            this.xmodelo.setValueAt(list.get(x).getNombre(), x, 2);
            if (list.get(x).getEstado() == 1) {
                this.xmodelo.setValueAt(true, x, 3);
            } else {
                this.xmodelo.setValueAt(false, x, 3);
            }
        }
    }
}
