package com.genoma.plus.controller.general;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import com.genoma.plus.dao.general.ActividadEconomicaDAO;
import com.genoma.plus.dao.impl.general.ActividadEconomicaDAOImpl;
import com.genoma.plus.dto.general.ActividadEconomicaNivelDTO;
import java.awt.Color;
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
import javax.swing.JCheckBox;
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
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/general/JIFFNivelActividadE.class */
public class JIFFNivelActividadE extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private Object[] xdatos;
    private ActividadEconomicaDAO xActividadEconomicaDAO;
    private JCheckBox JCHEstado;
    private JPanel JPDatosNivelAct;
    private JScrollPane JSPHistorico;
    private JSpinner JSPNoDigitos;
    private JTextField JTFNoCaracter;
    private JTextField JTFNombre;
    private JTable JTHistorico;
    private int xEstado = 1;
    private ConsultasMySQL xconsulta = new ConsultasMySQL();

    public JIFFNivelActividadE() {
        initComponents();
        springStart();
        mCargarDatosTabla();
    }

    private void springStart() {
        this.xActividadEconomicaDAO = (ActividadEconomicaDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("ActividadEconomicaDAO");
    }

    public void mNuevo() {
        Principal.mLimpiarDatosP();
        this.JTFNombre.setText("");
        this.JTFNoCaracter.setText("");
        this.JSPNoDigitos.setValue(new Integer(2));
        this.xEstado = 1;
        this.JCHEstado.setSelected(true);
        mCargarDatosTabla();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Nombre", "No Nivel", "No Carácter", "Estado"}) { // from class: com.genoma.plus.controller.general.JIFFNivelActividadE.1
            Class[] types = {Long.class, String.class, Integer.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTHistorico.setModel(this.xmodelo);
        this.JTHistorico.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTHistorico.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTHistorico.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTHistorico.getColumnModel().getColumn(1).setPreferredWidth(200);
        this.JTHistorico.getColumnModel().getColumn(2).setPreferredWidth(20);
        this.JTHistorico.getColumnModel().getColumn(3).setPreferredWidth(40);
        this.JTHistorico.getColumnModel().getColumn(4).setPreferredWidth(20);
    }

    private void mCargarDatosTabla() {
        List<ActividadEconomicaNivelDTO> list = this.xActividadEconomicaDAO.listActividadENivel();
        mCrearModeloDatos();
        for (int x = 0; x < list.size(); x++) {
            this.xmodelo.addRow(this.xdatos);
            this.xmodelo.setValueAt(list.get(x).getId(), x, 0);
            this.xmodelo.setValueAt(list.get(x).getNombre(), x, 1);
            this.xmodelo.setValueAt(Integer.valueOf(list.get(x).getNDigitos()), x, 2);
            this.xmodelo.setValueAt(list.get(x).getNCaracter(), x, 3);
            if (list.get(x).getEstado() == 1) {
                this.xmodelo.setValueAt(true, x, 4);
            } else {
                this.xmodelo.setValueAt(false, x, 4);
            }
        }
    }

    public void mGrabar() {
        if (!this.JTFNombre.getText().isEmpty()) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                ActividadEconomicaNivelDTO e = new ActividadEconomicaNivelDTO();
                if (Principal.txtNo.getText().isEmpty()) {
                    e.setNombre(this.JTFNombre.getText().toUpperCase());
                    e.setNDigitos(Integer.valueOf(this.JSPNoDigitos.getValue().toString()).intValue());
                    e.setNCaracter(this.JTFNoCaracter.getText());
                    e.setEstado(this.xEstado);
                    this.xActividadEconomicaDAO.createActividadEnivel(e);
                } else {
                    e.setNombre(this.JTFNombre.getText().toUpperCase());
                    e.setNDigitos(Integer.valueOf(this.JSPNoDigitos.getValue().toString()).intValue());
                    e.setNCaracter(this.JTFNoCaracter.getText());
                    e.setEstado(this.xEstado);
                    e.setId(Long.valueOf(Principal.txtNo.getText()));
                    this.xActividadEconomicaDAO.updateActividadEnivel(e);
                }
                mNuevo();
                return;
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe Ingresar un Nombre", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        this.JTFNombre.requestFocus();
    }

    /* JADX WARN: Type inference failed for: r3v38, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPDatosNivelAct = new JPanel();
        this.JTFNombre = new JTextField();
        this.JSPNoDigitos = new JSpinner();
        this.JCHEstado = new JCheckBox();
        this.JTFNoCaracter = new JTextField();
        this.JSPHistorico = new JScrollPane();
        this.JTHistorico = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("NIVEL ACTIVIDAD ECONÓMICA");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjifnivelactividade");
        this.JPDatosNivelAct.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTFNombre.setFont(new Font("Arial", 1, 12));
        this.JTFNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFNombre.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.general.JIFFNivelActividadE.2
            public void actionPerformed(ActionEvent evt) {
                JIFFNivelActividadE.this.JTFNombreActionPerformed(evt);
            }
        });
        this.JSPNoDigitos.setFont(new Font("Arial", 1, 12));
        this.JSPNoDigitos.setModel(new SpinnerNumberModel(2, 1, (Comparable) null, 1));
        this.JSPNoDigitos.setToolTipText("No Nivel Actividad Económica");
        this.JSPNoDigitos.setBorder(BorderFactory.createTitledBorder((Border) null, "No Dígitos", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setForeground(Color.blue);
        this.JCHEstado.setSelected(true);
        this.JCHEstado.setText("Estado");
        this.JCHEstado.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.general.JIFFNivelActividadE.3
            public void actionPerformed(ActionEvent evt) {
                JIFFNivelActividadE.this.JCHEstadoActionPerformed(evt);
            }
        });
        this.JTFNoCaracter.setFont(new Font("Arial", 1, 12));
        this.JTFNoCaracter.setBorder(BorderFactory.createTitledBorder((Border) null, "No Carácter", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPDatosNivelActLayout = new GroupLayout(this.JPDatosNivelAct);
        this.JPDatosNivelAct.setLayout(JPDatosNivelActLayout);
        JPDatosNivelActLayout.setHorizontalGroup(JPDatosNivelActLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosNivelActLayout.createSequentialGroup().addContainerGap().addComponent(this.JTFNombre).addGap(2, 2, 2).addComponent(this.JTFNoCaracter, -2, 165, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPNoDigitos, -2, 89, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHEstado).addGap(5, 5, 5)));
        JPDatosNivelActLayout.setVerticalGroup(JPDatosNivelActLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosNivelActLayout.createSequentialGroup().addGap(5, 5, 5).addGroup(JPDatosNivelActLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFNombre, -2, 50, -2).addComponent(this.JSPNoDigitos, -1, 50, 32767).addComponent(this.JTFNoCaracter, -2, 50, -2).addComponent(this.JCHEstado, -2, 50, -2)).addGap(5, 5, 5)));
        this.JSPHistorico.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTHistorico.setFont(new Font("Arial", 1, 12));
        this.JTHistorico.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTHistorico.setSelectionBackground(new Color(255, 255, 255));
        this.JTHistorico.setSelectionForeground(Color.red);
        this.JTHistorico.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.general.JIFFNivelActividadE.4
            public void mouseClicked(MouseEvent evt) {
                JIFFNivelActividadE.this.JTHistoricoMouseClicked(evt);
            }
        });
        this.JSPHistorico.setViewportView(this.JTHistorico);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(10, 10, 10).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPHistorico, -1, 666, 32767).addComponent(this.JPDatosNivelAct, -1, -1, 32767)).addGap(10, 10, 10)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPDatosNivelAct, -2, -1, -2).addGap(10, 10, 10).addComponent(this.JSPHistorico, -1, 237, 32767).addGap(10, 10, 10)));
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
    public void JTHistoricoMouseClicked(MouseEvent evt) {
        if (this.JTHistorico.getSelectedRow() != -1) {
            Principal.txtNo.setText(this.xmodelo.getValueAt(this.JTHistorico.getSelectedRow(), 0).toString());
            this.JTFNombre.setText(this.xmodelo.getValueAt(this.JTHistorico.getSelectedRow(), 1).toString());
            this.JSPNoDigitos.setValue(Integer.valueOf(this.xmodelo.getValueAt(this.JTHistorico.getSelectedRow(), 2).toString()));
            this.JTFNoCaracter.setText(this.xmodelo.getValueAt(this.JTHistorico.getSelectedRow(), 3).toString());
            this.JCHEstado.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTHistorico.getSelectedRow(), 4).toString()).booleanValue());
            if (this.JCHEstado.isSelected()) {
                this.xEstado = 1;
            } else {
                this.xEstado = 0;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNombreActionPerformed(ActionEvent evt) {
    }
}
